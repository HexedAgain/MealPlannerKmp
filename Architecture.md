# MealMate Architecture

> **Vision**
>
> MealMate is not a recipe app.
>
> It is a cooking companion.
>
> The goal is not to store recipes, but to guide a cook from the first ingredient to the finished meal with confidence.

---

# Core Principles

## Recipes are immutable

A recipe represents a set of cooking instructions.

It never changes while a user is cooking.

Runtime cooking state is stored separately.

This separation allows:

- resuming a cooking session
- notifications after app restart
- multiple users cooking the same recipe independently
- future synchronisation across devices

---

## Runtime state is not part of the recipe

The runtime layer is responsible for:

- current step
- elapsed time
- scheduled notifications
- paused/running state
- completion state
- user notes (future)

The recipe itself remains read-only.

---

## Domain driven

Separate models exist for:

```
API DTOs
        │
        ▼
Network Mapper
        │
        ▼
Domain Models
        │
   ┌────┴────┐
   ▼         ▼
Room      UI Models
Mapper    (optional)
   │
   ▼
Room Entities
```

Rules:

- Room entities never leave persistence.
- DTOs never reach business logic.
- UI never depends directly on persistence.
- Domain models contain business logic.

---

# Data Evolution

## API evolution

The internal domain model is the source of truth.

API versions expose different representations of that model.

```
Database
      │
      ▼
Domain Recipe
      │
 ┌────┴────┐
 ▼         ▼
API v1   API v2
```

Guidelines:

- Prefer additive changes.
- Never rename fields without deprecation.
- Never remove fields immediately.
- Old API versions ignore new data.
- Transform layers map between versions.

Example:

```
Internal:

RecipeTime

↓

v1:

cookTimeMinutes

↓

v2:

RecipeTime
```

---

## Database migrations

Database schema should evolve forwards.

Prefer:

- nullable columns
- additive tables
- enrichment tables

Avoid destructive migrations where possible.

---

# Recipes

Initially:

```
Recipe
```

Future:

```
Recipe Family
      │
      ├── Alice's version
      ├── Bob's version
      └── Premium chef version
```

Users search for dishes.

Creators publish variants.

---

# Ingredients

Recipes should not own ingredient knowledge.

Instead:

```
Recipe
      │
      ▼
Recipe Ingredient
      │
      ▼
Ingredient
```

Recipes reference ingredients.

Ingredients evolve independently.

---

## Ingredient enrichment

Initially an ingredient may only contain:

```
id
name
```

Over time:

```
Ingredient

id
name
aliases
categories
allergens
flavour profile
cuisines
substitutions
status
```

Recipes never require modification as ingredient knowledge improves.

---

## Unknown ingredients

Unknown ingredients should never block publishing.

Workflow:

```
Creator uploads recipe

↓

Unknown ingredient detected

↓

Recipe still published

↓

Ingredient Review Queue

↓

AI classification

↓

Human review

↓

Ingredient database enriched
```

Creator optionally helps classify ingredients.

The platform learns over time.

---

# Ingredient knowledge

Knowledge belongs to MealMate.

Examples:

```
Parmesan

Categories:
- Dairy
- Cheese
- Hard cheese

Allergens:
- Milk

Aliases:
- Parmigiano Reggiano
```

```
Gochujang

Categories:
- Sauce
- Fermented
- Korean

Allergens:
- Soy
```

---

# MealMate Knowledge Layer

MealMate should maintain a layer of knowledge about food concepts which is separate from recipe content.

Recipes contain the creator's original text.

MealMate enriches that content at runtime by linking parts of the text to known concepts.

The recipe itself is never modified.

---

## Knowledge Items

A knowledge item represents something MealMate understands.

Examples:

```
Knowledge Item

Sauté

Type:
Technique

Description:
Cook gently in a small amount of oil while stirring.

Aliases:
- saute
- sauté
```

```
Knowledge Item

Skillet

Type:
Equipment

Description:
A frying pan, often designed to also be used in an oven.

Aliases:
- frying pan
- skillet
```

```
Knowledge Item

Cilantro

Type:
Ingredient

Aliases:
- coriander
- fresh coriander
```

---

## Text enrichment

Recipe text remains plain text:

```
Sauté the onions in a skillet until translucent.
```

A background process identifies concepts:

```
Recipe Step

"Sauté the onions in a skillet until translucent."

References:

- Technique: Sauté
- Equipment: Skillet
```

The UI constructs an annotated string during rendering.

The original recipe text remains unchanged.

---

## Annotation pipeline

```
Recipe text

↓

Knowledge matching

↓

Knowledge references

↓

UI annotated string

↓

Clickable explanations
```

Example:

```
Sauté the onions in a skillet.
^^^^^             ^^^^^^^
```

The user can tap highlighted concepts to learn more.

---

## Knowledge matching

Initially matching can use:

- exact keyword matching
- aliases
- known terminology

Future enrichment may use AI to discover:

- unknown cooking techniques
- unfamiliar ingredients
- regional terminology
- creator-specific wording

---

## Runtime rendering

The UI is responsible for creating annotated text.

The domain model does not contain:

- UI spans
- click handlers
- Compose-specific types
- formatting information

The domain layer only exposes:

```
Recipe text

+

Knowledge references
```

---

## Knowledge reference model

A possible representation:

```
KnowledgeReference

knowledgeItemId

occurrences:

    start index
    end index
```

Example:

```
Text:

"Sauté the onions"

Reference:

knowledgeItem:
Sauté

occurrence:
0..5
```

This allows the expensive matching/enrichment work to happen once, while rendering remains lightweight.

---

## Why this exists

The goal is not to create a glossary.

The goal is to make MealMate feel like an experienced cooking companion.

A recipe assumes the cook understands:

- terminology
- equipment
- techniques
- ingredients

MealMate fills those gaps.

Examples:

```
"Simmer"

Small bubbles, not a rapid boil.

```

```
"Skillet"

A frying pan.

```

```
"Deglaze"

Add liquid to a hot pan to loosen flavourful browned bits.
```

---

## Future uses

The same knowledge layer can support:

- contextual explanations
- beginner mode
- voice guidance
- ingredient substitutions
- allergen warnings
- recipe search
- cooking education
- ingredient discovery

The recipe remains content.

The knowledge layer makes the content understandable.

---

# Equipment

Equipment is independent from recipes.

```
Recipe
      │
      ▼
RecipeEquipment
      │
      ▼
Equipment
```

Future examples:

```
Skillet

Aliases:
- Frying pan

Description:
American term for a frying pan.
```

MealMate can explain unfamiliar equipment.

---

# Kitchen Translator

Recipes often contain unfamiliar language.

MealMate should translate terminology.

Examples:

```
Skillet

"A frying pan."
```

```
Simmer

"Small bubbles.
If your sauce is trying to escape the pan,
turn the heat down."
```

```
Fold

"Gently combine without beating."
```

This is contextual help rather than a glossary.

---

# Cooking Timeline

Recipes contain timelines.

Users create cooking sessions.

Timeline drives:

- notifications
- current instruction
- remaining time
- progress indicators

Future UI:

```
──────────────
██████░░░░░░░
──────────────

Current step:
Cook onions

Elapsed:
6 minutes
```

---

# Notifications

The app should act like a sat-nav.

Examples:

```
Now:

Cook onions.

```

Five minutes later:

```
Now add garlic.
```

Then:

```
Start boiling pasta.
```

The user should rarely need to watch the screen.

---

# Cooking Session

A cooking session represents one execution of a recipe.

Future responsibilities:

- start time
- pause
- resume
- completion
- notification schedule
- timeline position

Multiple sessions may exist for the same recipe.

---

# AI

AI assists creators.

It does not become the source of truth.

Potential responsibilities:

- OCR recipe photos
- Parse ingredients
- Parse timings
- Detect equipment
- Detect nutrition
- Suggest ingredient categories
- Suggest allergens
- Detect likely recipe family

Humans remain able to review AI suggestions.

---

# Creator Workflow

Goal:

Creating recipes should require as little manual work as possible.

Future flow:

```
Photo

↓

OCR

↓

AI parsing

↓

Structured recipe

↓

Creator reviews

↓

Publish
```

Unknown ingredients become review items rather than blocking publication.

---

# Discovery

Future recipe discovery may support:

- ingredients liked
- ingredients disliked
- allergens
- cuisine
- preparation time
- difficulty
- available equipment
- dietary preferences

Requires ingredient knowledge rather than simple string matching.

---

# Marketplace

Future feature.

Creators may publish:

- free recipes
- premium recipes

MealMate provides:

- hosting
- discovery
- cooking experience
- payment processing

Revenue through marketplace commission.

---

# Long-term Vision

MealMate should become increasingly intelligent over time.

Initially it knows almost nothing.

As recipes are uploaded it learns:

- ingredients
- equipment
- cuisines
- substitutions
- timing
- terminology

The intelligence of the platform grows alongside the recipe database.

---

# MVP

The MVP intentionally ignores many future features.

Success criteria:

A user can:

- open the app
- see a recipe
- start cooking
- receive guidance
- finish the meal without continually referring back to the recipe

If this experience is genuinely better than following a traditional recipe, the core idea has been validated.

Everything else is an enhancement.