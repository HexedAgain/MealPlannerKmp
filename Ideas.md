# Guided Cooking Platform - Product Vision

## Overview

This is not intended to be another recipe app.

A traditional recipe is a static document:

- ingredients
- instructions
- timings

However, cooking is not static. Cooking involves:

- sequencing
- timing
- parallel activities
- judgement calls
- waiting periods
- confidence and reassurance

The core idea:

> Transform recipes into guided cooking journeys.

The app acts like a cooking assistant that knows:

- where the user is
- what stage they are at
- what they should do next
- when to notify them
- what they should be looking for

The user should feel like they have an experienced cook guiding them.

---

# Product Differentiation

Most recipe apps answer:

> "How do I make this?"

This app answers:

> "How do I successfully cook this right now?"

The analogy:

Most recipe apps are instruction manuals.

This app is a sat-nav for cooking.

---

# Core Architecture

The most important distinction:

A recipe is not the live experience.

The architecture should probably be:

Recipe
|
v
Cooking Plan
|
v
Cooking Session
|
+--> UI Timeline
|
+--> Local Notifications
|
+--> Progress Tracking


## Recipe

Static data:

- ingredients
- instructions
- metadata
- author information

## Cooking Plan

A transformed recipe designed for execution.

Contains:

- steps
- timings
- dependencies
- parallel tasks
- checkpoints
- notifications

## Cooking Session

The live user experience.

Contains:

- current step
- elapsed time
- completed steps
- paused state
- adjustments
- user progress

---

# Timeline-Based Cooking

The core UI concept.

A recipe becomes a visual timeline.

Example:
00:00
[ Prepare vegetables -------- ]

00:10
[ Brown mince ------- ]

00:25
[ Simmer sauce ---------------- ]

01:15
[ Cook pasta --- ]

01:25
Serve


The user can see:

- where they are
- what is happening
- what comes next

---

# Visual Progress

Each cooking step is represented as a box.

The elapsed portion is shaded.

Example:
Simmer sauce

██████████████░░░░░░░░░░

35 minutes elapsed
25 minutes remaining


The UI becomes a visual cooking journey.

---

# Parallel Cooking

Cooking is naturally parallel.

Traditional recipes are usually linear, but real cooking is not.

Example:

A written recipe:
1. Make sauce
2. Cook pasta
3. Serve


Actual cooking:
Sauce:
████████████████████████

Pasta:
████████

Garlic bread:
████


The system should support overlapping timelines.

The existing idea of:
TimeLineStart.RelativeTimeLine

is a strong fit.

---

# RecipeStep Evolution

Current concept:

RecipeStep(
    title,
    body,
    time
)

Potential future:

RecipeStep(
    id,
    title,
    body,
    duration,
    type,
    checkpoints
)

Possible step types:

Action
Timer
Parallel
Confirmation

Examples:

Action:

"Dice onions"

Timer:

"Simmer for 45 minutes"

Confirmation:

"Check chicken is cooked through"

Timing Model

Recipes contain ambiguity.

Examples:

cook until golden
simmer until thick
bake until done
rest before serving

Do not assume all timings are exact.

Support:

minimum duration
expected duration
maximum duration

Example:

Simmer sauce

40-60 minutes

The app can say:

"Your sauce has been simmering for 45 minutes. Check thickness."

instead of:

"Your sauce is finished."

Checkpoints

Duration and notification are separate concepts.

Example:

Roast chicken:

Start roast

+30 minutes:
Turn chicken

+50 minutes:
Check temperature

+60 minutes:
Remove from oven

        )
    ]
)

Notifications

Notifications are generated from the cooking timeline.

Flow:

Step begins
    |
    v
Timer starts
    |
    v
Progress updates
    |
    v
Checkpoint reached
    |
    v
Local notification

Examples:

"Add the garlic now"
"Start heating the pasta water"
"Your sauce should be thickening"
"Time to check the oven"

Creator Experience

Creators should NOT manually enter recipes.

Nobody wants to fill in:

Step:
Duration:
Notification:
Dependencies:

Instead:

Give us your recipe in whatever form you already have.

Inputs:

photograph
handwritten recipe card
PDF
Word document
URL
video transcript
social media post
notes

AI Recipe Import Pipeline
Recipe Source
      |
      v
OCR / Text Extraction
      |
      v
AI Recipe Understanding
      |
      v
Structured Recipe
      |
      v
Timeline Generation
      |
      v
Creator Review
      |
      v
Publish

OCR + AI Responsibilities

OCR handles:

extracting text from images

Possible technologies:

Google ML Kit
Apple Vision
Tesseract

AI handles:

understanding recipe meaning
extracting ingredients
normalising units
creating cooking steps
identifying parallel activities
suggesting timings

Creator Timeline Editor

The creator editor should be visual.

Think:

Video editing timeline, but for cooking.

Example:

Prepare onions
██████████
10 mins


Cook sauce
          █████████████████
          60 mins


Cook pasta
                         █████
                         10 mins

Creators can:

drag duration handles
move steps
reorder steps
overlap activities
add tips
add notifications

Drag-Based Editing

Avoid forms.

Instead of:

Duration:
[45]

Use:

Simmer sauce

███████████████████

45 mins

Creator drags the end of the block.

This feels natural because cooks think visually.

Recipe Timeline Editor Concept

The editor is similar to a video editor:

Cooking steps
────────────────────────

Timers
────────────────────────

Notifications
────────────────────────

Chef tips
────────────────────────

Creators are authoring a cooking experience, not a recipe.

Unit Conversion

Recipes may arrive in:

imperial
metric
ambiguous measurements

Need:

Raw Recipe
    |
    v
Normalisation Layer
    |
    v
Internal Representation

Examples:

1 lb chicken
=
454g chicken

However:

Volume conversion requires ingredient awareness.

Examples:

1 cup flour ≠ 1 cup sugar

Need ingredient-specific rules.

Marketplace Concept

Creators can sell guided cooking experiences.

Not just recipes.

They sell:

expertise
technique
timing
confidence
personal tips

Example:

Chef Marco's Carbonara Masterclass

£2.99

Includes:

✓ Guided timeline
✓ Chef tips
✓ Cooking checkpoints
✓ Notifications

Creator Economics

Possible model:

Creator sets price.

Example:

Recipe price: £2.99

Platform takes commission

Creator receives remainder

Possible commission:

5%
10%
15%

(depending on payment costs and platform expenses)

Creator Value Proposition

Current options:

YouTube
blogs
social media
Patreon

This offers:

Turn your cooking knowledge into an interactive cooking lesson.

Creator Reputation

Useful metrics:

Chef Marco

★★★★★ 4.9

120 recipes

25,000 successful cooks

92% completion rate

Important metric:

Not:

"Recipe views"

but:

"People successfully cooked this."

Recipe Scaling

Existing:

serves

field is valuable.

Example:

Original:

6 servings
400g pasta

User chooses:

2 servings

App calculates:

133g pasta

Creator Marketplace Architecture

Separate:

Recipe ownership
Recipe(
    id,
    creatorId,
    ...
)

from:

User entitlement
UserRecipeAccess(
    userId,
    recipeId,
    purchasedAt
)

A recipe is not the product.

The product is:

User
 |
 purchases
 |
 Cooking Experience
 |
 launches
 |
 Cooking Session
 
 Product Metrics

Interesting metrics:

Not:

recipe views

Instead:

started cooking
completed cooking
abandoned cooking
repeat cooks
success rate

The platform knows whether someone actually cooked.

MVP Direction

Do not start with marketplace.

Start with the cooking engine.

Build:

Guided cooking timeline
Visual progress UI
Local notifications
Cooking session state

Create:

20-50 excellent recipes

Validate:

Does this genuinely make cooking easier?

Then add:

AI import
creator tools
marketplace

Main Product Insight

The hard problem is not storing recipes.

The hard problem is:

Turning human recipes into reliable cooking experiences.

The core transformation:

Recipe
    |
    v
Cooking Timeline
    |
    v
Guided Cooking Session

Positioning

Avoid:

"A recipe app"

Better:

"The cooking assistant that guides you from ingredients to finished meal."

or:

"Cook with an expert beside you."

The goal:

The user should feel like they have someone experienced in the kitchen helping them.