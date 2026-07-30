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


First: don't worry about having no Google Play presence yet

For an early app, a Play Store listing is not your main problem.

Your first goal is not:

"Get 100,000 downloads"

It is:

"Find 100 people who love the idea."

Those first people are far more valuable because they tell you what the product actually is.

The obvious channel: cooking content

Your app naturally creates things people want to watch.

Imagine posting:

"I cooked a Sunday roast without looking at the recipe once. The app told me exactly when to start each part."

Video:

00:00 Start gravy
00:10 Put potatoes on
00:25 Check chicken
00:45 Rest meat

The visual timeline is inherently shareable.

TikTok / Instagram Reels / YouTube Shorts are actually a good fit.

Not because you need to become an influencer, but because the concept is visual.

Build the audience before the app

You could start a simple landing page:

Never lose track of a recipe again.

Cook like someone experienced is beside you.

Join the beta.

Collect emails.

Then post:

screenshots
timeline animations
"before/after" recipe transformations
cooking experiments
The "recipe transformation" content could be very effective

Example posts:

Before:

A normal recipe:

"Cook onions until soft. Add spices. Simmer."

After:

Your app:

18:00 Start onions

18:10 Add spices

18:25 Start rice

18:45 Check sauce thickness

People immediately understand the difference.

Your first users are probably not random cooks

I would target:

1. Beginner cooks

They feel the pain.

Examples:

students
people moving out
new parents
people trying to eat better
2. Cooking enthusiasts

They enjoy experimenting.

They may become your creators later.

3. Food creators

This is interesting because they could become your distribution channel.

A chef with:

20k Instagram followers

is worth more than 10,000 random installs.

Your pitch:

"Turn your recipes into interactive cooking experiences your followers can cook along with."

You don't actually need Google Play initially

You can distribute early versions through:

internal testing
closed testing
TestFlight (iOS)
direct APK (Android)
Firebase App Distribution

Your goal is feedback, not scale.

A clever launch strategy

I would avoid launching as:

"New recipe app available!"

Nobody cares.

Instead:

"I built an app that turns any recipe into a cooking timeline."

That is a new idea.

Consider a "hero recipe"

Don't launch with 500 recipes.

Launch with one amazing experience.

Something like:

Sunday roast
lasagne
curry
sourdough
Christmas dinner

Something where timing coordination is genuinely difficult.

Make someone say:

"Oh, I actually need this."

A possible 90-day path
Month 1

Build:

cooking timeline
notifications
progress UI

Use your own recipes.

Month 2

Create content:

10-20 guided recipes
short videos showing the experience
landing page

Start collecting beta users.

Month 3

Invite:

50 cooks
5 food creators

Watch them use it.

One thing I really like about this idea

The app itself creates marketing material.

Many apps struggle because the product is invisible.

A banking app cannot easily make a viral video.

Your app can literally show:

A recipe becoming alive.

A recipe transforms from:

boring text

into:

a moving cooking journey

That is something people can understand in 5 seconds.

Also, given you are building in Kotlin Multiplatform, I would be tempted not to think "Android app first" but "experience first". The first people you need are not Android users — they are cooks who say:

"Wait, my recipes don't normally work like this?"

That reaction is the validation you're looking for.


Ingredient preferences are a genuinely useful feature

Most recipe apps do something like:

"Search for chicken curry"

Your idea is closer to:

"Find me something I can actually cook and enjoy."

Example:

User profile:

Likes:
✓ chicken
✓ rice
✓ chilli
✓ garlic

Dislikes:
✗ cheese
✗ mushrooms
✗ coriander

Avoid:
✗ shellfish
✗ peanuts

Then:

Recommended:

✓ Chicken tikka masala
✓ Thai basil chicken
✓ Beef chilli

Excluded:

✗ Lasagne
Reason: parmesan + mozzarella

✗ Mushroom risotto
Reason: mushroom disliked
The interesting part is distinguishing ingredients

Your existing model actually gives you a starting point:

Ingredient(
name = "parmesan",
quantity = ...
)

But for filtering, you probably need more semantic information.

For example:

Ingredient(
name = "parmesan",
ingredientId = "cheese.parmesan",
categories = [
IngredientCategory.Dairy,
IngredientCategory.Cheese
],
optional = false
)

Because users don't think in exact strings.

A user might say:

"I don't like cheese"

They don't mean:

ingredient.name == "cheese"

They mean:

category == Dairy.Cheese

So:

Cheddar
Mozzarella
Parmesan
Brie
Blue cheese

are all candidates.

Optional ingredients become important

You mentioned:

unless an optional ingredient I can remove

That is a really good observation.

You probably want to distinguish:

Ingredient(
name = "chilli",
isOptional = true
)

from:

Ingredient(
name = "cream",
isOptional = false
)

Then the recommendation engine can say:

Match score: 95%

Minor adjustment:
Remove optional parmesan topping

rather than rejecting it.

This could become a recommendation engine

Eventually:

User preferences
+
Available ingredients
+
Dietary requirements
+
Skill level
+
Available cooking time
|
v
Recipe ranking

Example:

User:

Time available: 40 minutes
Skill: beginner
Avoid: cheese
Have:
- chicken
- rice
- peppers

Output:

Tonight:
Chicken fajitas

Reason:
✓ Uses ingredients you have
✓ No disliked ingredients
✓ 35 minutes
✓ Beginner friendly
Your server model starts becoming interesting

Something like:

Recipe Database

Recipe
|
+-- Ingredients
|
+-- Tags
|
+-- Timeline
|
+-- Nutrition
|
+-- Creator
|
+-- Ratings


Ingredient Knowledge Graph

Ingredient
|
+-- categories
|
+-- substitutes
|
+-- allergens
|
+-- common pairings
This also helps your creator marketplace

A creator uploads:

"Three cheese ravioli"

The system knows:

Contains:
✓ wheat
✓ dairy
✓ cheese

Optional:
✓ parmesan garnish

A user with:

Avoid cheese

doesn't see it.

But someone who dislikes parmesan specifically might still see it.

Another interesting possibility: ingredient substitutions

This is where the AI + structured data combination becomes powerful.

User:

"I hate mushrooms"

Recipe:

"Add mushrooms"

AI could suggest:

Replace mushrooms with:

- courgette (similar texture)
- aubergine
- extra peppers

But the creator should control this.

A chef might say:

IngredientSubstitution(
remove = "mushroom",
alternatives = [
"aubergine",
"courgette"
]
)
This also gives you a reason to have a backend

Your original thought:

"some server with a database of known recipes"

is probably right.

The app becomes:

Mobile App
|
|
Backend API
|
+-- Recipe database
|
+-- Ingredient knowledge
|
+-- User preferences
|
+-- Purchases
|
+-- Creator content

The mobile app is the cooking interface.

The server is the intelligence layer.

One thought though: don't underestimate how valuable the preference engine could be. A lot of people don't fail to cook because they cannot find recipes — they fail because they open a recipe and think:

"Oh, I hate half of those ingredients."

A recipe app that already knows "never show me cheese" feels much more personal.

And it ties back into your original vision: the app is not just storing recipes. It is trying to understand the person cooking them.


The trick is separating:

the kernel (what makes this special)
the expansion pack (things that would be great later)
The kernel (build this first)

I would argue your MVP is surprisingly small:

Recipe
|
v
Cooking Timeline
|
v
Guided Cooking Session

A user can:

Open a recipe
Press "Start cooking"
Get guided through it
Receive notifications
See progress visually

That's it.

If that feels magical, you have something.

Things that are currently "later"
AI recipe import

Amazing.

But initially:

You manually create recipes

The goal is proving the experience.

Later:

photo
|
AI
|
Recipe
|
Timeline
Ingredient preference engine

Very useful.

But initially:

Search recipes

Later:

I hate cheese
I have chicken
I have 45 minutes

What should I cook?
Marketplace

Potentially huge.

But initially:

You are the creator.

Later:

1000 chefs create content.
Payments

Definitely later.

The danger is building the "platform"

Developers love platforms because they are interesting.

The user does not care.

The user thinks:

"Can this help me make dinner tonight?"

Not:

"Does this have a sophisticated ingredient ontology?"

😂

I would think of it like this:
Version 0.1 — "The cooking timer that isn't a timer"

Goal:

Make cooking one meal feel amazing.

Features:

✅ one recipe
✅ timeline
✅ notifications
✅ progress animation

Version 0.2 — "My recipes"

Add:

✅ save recipes
✅ import manually
✅ edit timelines

Version 0.3 — "The recipe converter"

Add:

✅ AI import
✅ photo → recipe
✅ URL → recipe

Version 0.4 — "The cooking assistant"

Add:

✅ preferences
✅ ingredient filtering
✅ recommendations

Version 0.5 — "The platform"

Add:

✅ creators
✅ marketplace
✅ payments

The funny thing is: your existing Kotlin model is already further along than most people would be. You have not started with:

Recipe(
name: String,
instructions: String
)

You already have concepts like:

RelativeTimeLine
RecipeTime
IngredientSet
isOptional

which means you were already thinking about the hard part.

If I were you, I would actually put a big warning at the top of your project:

# DO NOT BUILD THE PLATFORM YET

The product is the cooking experience.

Everything else exists only to make that experience better.

Because the most likely failure mode is not someone stealing it.

The most likely failure mode is you spend six months building:

auth
databases
AI parsing
payments
ingredient graphs

and never get to the moment where someone says:

"Wow, cooking with this is genuinely better."

Get that moment first. The rest becomes much easier to justify. 🙂


Scaling ingredients is easy. Scaling cooking behaviour is hard.

Most apps do:

Serves 6
|
divide ingredients by 6
|
Serves 1

But cooking is not arithmetic.

Ingredients scale linearly (mostly)

These are straightforward:

6 people:
600g chicken

1 person:
100g chicken

or:

6 people:
300g rice

1 person:
50g rice

Your serves field handles this nicely.

Time does not scale linearly

Your example is exactly right.

Imagine:

Original

Serves 6:

Fry onions:
30 minutes

Scaling to one person:

Fry onions:
20 minutes

Not:

30 / 6 = 5 minutes

because the time is not really about quantity.

It is about:

heat transfer
pan temperature
moisture evaporation
surface area
chemistry
desired texture
Some timings barely change

Examples:

Boiling pasta

Serves 1:

10 minutes

Serves 8:

10 minutes

The pasta cooking time is almost identical.

Simmering a sauce

Serves 6:

60 minutes

Serves 1:

30-45 minutes

because there is less volume to reduce.

Browning meat

This is where it gets interesting.

Serves 6:

500g mince
15 minutes

Serves 1:

100g mince
5 minutes

Maybe.

But if you use the same pan:

100g in a large pan

might brown poorly because it loses moisture differently.

You probably need a concept beyond "duration"

Your current:

RecipeTime

is a good start, but eventually steps might need metadata.

Something like:

RecipeStep(
title = "Simmer sauce",
duration = RecipeTime(mins = 60),
scalingBehaviour = ScalingBehaviour.ReduceWithQuantity
)

Where:

enum class ScalingBehaviour {
Fixed,
Linear,
ReduceWithQuantity,
CreatorDefined
}

Examples:

Boil pasta:
Fixed

Chop vegetables:
Linear

Reduce sauce:
ReduceWithQuantity

Bake cake:
CreatorDefined
The really interesting part: AI could estimate this

When importing a recipe:

AI sees:

"Cook for 45 minutes until thickened."

It could infer:

{
"duration": {
"base": 45,
"scaling": "reduce_with_quantity"
}
}

But allow the creator to override it.

This ties into your "hold their hand" idea

A bad scaling engine says:

"Here is the recipe divided by 6."

A good cooking assistant says:

"I've adjusted the quantities, but I've also changed the timings."

Example:

Original:

Serves 6

Simmer sauce:
60 mins

New:

Serves 1

Simmer sauce:
35 mins

Start checking thickness after 25 mins.

That feels intelligent.

It also affects your timeline engine

The cooking plan is not static.

It is generated from:

Recipe
+
Number of servings
+
Equipment
+
User skill
+
Available time
=
Cooking Plan

So:

Recipe:
Lasagne

Serves:
6

User:
Cooking for 2

Output:
Different quantities
Different timeline
Different notifications
One more thought: equipment matters too

A recipe for 6 in a restaurant kitchen:

Large frying pan
High heat

does not translate perfectly to:

Small saucepan
Home hob

You could eventually have:

CookingContext(
servings = 2,
equipment = [
FryingPan(size = Medium)
],
skillLevel = Beginner
)

and generate the experience.

This is actually a really nice example of why I think the core idea is stronger than a recipe database. A database stores what someone wrote.

Your app is trying to understand:

"Given this person, this kitchen, and this situation, what should happen next?"

That's a much harder problem — but also a much more interesting one


Your target user is the person standing in the kitchen thinking:

"I just want this to work. Please don't make me think."

That opens up a lot of possibilities. Some of these are big features, some are tiny UX details that could make the app feel magical.

1. "Do I have everything?" (pre-cooking confidence check)

A huge source of cooking failure happens before cooking starts.

The user chooses:

Chicken curry

The app says:

Before we start:

✓ Chicken
✓ Rice
✓ Garlic
✓ Onion

⚠ Missing:
- Garam masala

Substitutions:
- Curry powder + cumin

The key is not just listing missing ingredients. It should answer:

"Can I still make this?"

2. "Get everything ready first" mode

A beginner often starts cooking too early.

Recipe says:

Fry onions, then chop tomatoes.

Experienced cooks know they should prep first.

Your app could have:

Preparation phase
Before cooking:

☐ Chop 2 onions
☐ Crush garlic
☐ Measure spices
☐ Get saucepan ready

Press Start Cooking when ready

This avoids the classic:

"Oh no, my onions are burning while I'm still chopping."

3. "What should this look like?"

This is massive.

Recipes often say:

"Cook until golden brown."

A beginner thinks:

"What does golden brown mean?"

Your app could have:

Checkpoint:

Your onions should look like:

[image]

Not this:

[image]

Visual checkpoints could be incredibly valuable.

4. Recovery mode ("I messed up")

This is a big one.

Beginners abandon recipes when something goes wrong.

Examples:

Burned onions

User:

"My onions went brown too quickly."

App:

Don't panic.

Option 1:
Remove onions and restart.

Option 2:
Continue — your dish will be sweeter and darker.

Reduce next cooking step by 5 minutes.
Sauce too thin
Your sauce is watery.

Try:
✓ simmer uncovered
✓ increase heat slightly
✓ add tomato paste

A chef's knowledge is often:

"What do I do when reality doesn't match the recipe?"

That is valuable.

5. "I am running late"

Real life happens.

User:

"Dinner needs to be ready in 40 minutes."

Recipe normally takes:

75 minutes.

The app could say:

Time-saving mode:

Skip:
- resting period

Change:
- simmer 45 mins → 25 mins

Result:
Good meal, slightly less depth of flavour
6. Confidence level

The app could adjust explanations.

User profile:

Cooking confidence:
Beginner

Then:

"Dice onions"

becomes:

Cut onion in half.
Remove the papery skin.
Lay flat side down.
Slice into strips.
Turn and chop across.

Experienced user:

Dice onions.

Same recipe. Different guidance.

7. Equipment awareness

People fail because they don't have the right stuff.

Recipe:

Use a Dutch oven.

User:

"I don't have one."

App:

No Dutch oven?

Use:
✓ heavy saucepan
✓ deep frying pan

Avoid:
✗ thin aluminium pan
8. The "kitchen inventory"

This is probably later, but interesting.

The app knows:

I usually have:

✓ olive oil
✓ salt
✓ pepper
✓ rice
✓ pasta

Then recommendations improve.

9. "What can I make tonight?"

This is where your ingredient preference idea gets powerful.

User:

I have:

Chicken
Peppers
Rice
Tomatoes

I don't like:

Cheese
Mushrooms
Fish

App:

Tonight:

Chicken fajitas
35 mins

Why:
✓ Uses your ingredients
✓ No disliked foods
✓ Beginner friendly
10. Shopping list intelligence

Not:

Buy:
chicken
onions
garlic

Better:

You need:

Chicken thighs
(500g)

You already have:
✓ garlic
✓ onions

Buy:
- chicken thighs
- yoghurt
- coriander
11. "Don't leave me idle"

Beginners hate waiting.

Recipe:

Simmer for 45 minutes.

They think:

"What now?"

Your app:

While sauce simmers:

Optional:

5 mins:
Prepare salad

10 mins:
Clean chopping board

20 mins:
Set table

This is a very natural extension of your timeline idea.

12. Voice guidance

A cook's hands are busy.

Imagine:

"Hey, what's next?"

App:

"You are simmering the sauce. Next step is to start the pasta in 8 minutes."

This feels much more natural than looking at a phone with flour-covered hands.

13. "Cooking autopilot"

A really nice mode:

Phone on the counter.

Screen:

CURRENT STEP

Stir sauce occasionally

12:32 remaining


Next:
Add pasta

No scrolling.
No searching.
No thinking.

14. Learning from the user's behaviour

After cooking:

How did it go?

👍 Too easy
👍 Just right
👎 Too complicated

Over time:

You usually prefer:

- 30 minute meals
- mild spice
- chicken dishes
- fewer preparation steps

The app becomes personalised.

15. "I hate cleaning"

This is underrated.

A lot of people hate cooking because the aftermath sucks.

Timeline could include:

While sauce simmers:

Clean:
✓ chopping board
✓ knife
✓ empty tins

Then:

"Dinner is finished. Kitchen is already mostly clean."

The bigger theme

The hapless cook does not need more recipes.

They need cognitive load removed.

The app should answer:

What do I do now?
Did I do that correctly?
What happens next?
Can I recover?
Can I adapt?
Am I going to finish on time?

That is why I keep coming back to the same idea: the real product is not the recipe.

It is the confidence layer between a recipe and a human being trying to execute it.

And ironically, someone who hates cooking may be one of the best people to design that layer, because you naturally notice all the places where cooking makes unreasonable assumptions. 🙂