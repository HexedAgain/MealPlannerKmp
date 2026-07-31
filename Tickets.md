# Guided Cooking - MVP Backlog

---

# Epic: Project Resurrection

## TICKET-001 - Project builds successfully

Description:
- Open project
- Upgrade dependencies if required
- Ensure Android build succeeds
- Ensure sample recipe compiles

Acceptance Criteria:
- App launches on device/emulator
- No build warnings that block development

Priority:
⭐⭐⭐⭐⭐

---

# Epic: Local Recipe Storage

## TICKET-002 - Room database

Description:
Create local Room database.

Initially store only one sample recipe.

Acceptance Criteria:
- Room configured
- Recipe entity stored
- Repository returns recipe

Priority:
⭐⭐⭐⭐⭐

---

## TICKET-003 - Seed sample recipe

Description:

Populate database on first launch with:

- Spaghetti Bolognese

Acceptance Criteria:

- Fresh install contains one recipe
- App can retrieve recipe

Priority:
⭐⭐⭐⭐⭐

---

# Epic: Home Screen

## TICKET-004 - Recipe list screen

Description:

Display all recipes.

Initially:

- one card

Acceptance Criteria:

Recipe card displays:

- image
- title
- preparation time
- cook time
- servings
- difficulty

Priority:
⭐⭐⭐⭐⭐

---

## TICKET-005 - Recipe card component

Description:

Create reusable composable.

Displays:

- Hero image
- Recipe name
- Difficulty badge
- Total cooking time
- Preparation time
- Serves
- Rating (if available)

Stretch:

Show ingredient count.

Acceptance Criteria:

Looks attractive.

Priority:
⭐⭐⭐⭐⭐

---

# Epic: Cooking Session

## TICKET-006 - Start cooking

Description:

Tap recipe card.

Creates CookingSession.

Navigate to cooking screen.

Acceptance Criteria:

User reaches cooking screen.

Priority:
⭐⭐⭐⭐⭐

---

## TICKET-007 - CookingSession model

Description:

Introduce runtime state.

Example:

Current timeline

Current step

Elapsed time

Completed steps

Paused state

Acceptance Criteria:

CookingSession exists independently of Recipe.

Priority:
⭐⭐⭐⭐⭐

---

# Epic: Cooking UI

## TICKET-008 - Current step screen

Description:

Display:

Current step title

Instruction

Time remaining

Timeline progress

Acceptance Criteria:

One active step shown.

Priority:
⭐⭐⭐⭐⭐

---

## TICKET-009 - Timeline progress

Description:

Represent elapsed time visually.

Ideas:

Progress bar

or

Box gradually fills

Acceptance Criteria:

Progress updates continuously.

Priority:
⭐⭐⭐⭐⭐

---

## TICKET-010 - Next step preview

Description:

Display next step underneath.

Example:

Next:

Start boiling pasta

Acceptance Criteria:

User always knows what's coming.

Priority:
⭐⭐⭐⭐

---

# Epic: Development Tools

## TICKET-011 - Time controller

Description:

Developer-only controls.

Slider:

0%
↓

100%

Controls CookingSession clock.

Acceptance Criteria:

Dragging instantly updates cooking state.

Priority:
⭐⭐⭐⭐⭐

Notes:

This will massively speed up development.

---

## TICKET-012 - Play / Pause

Description:

Developer controls:

▶ Play

⏸ Pause

Acceptance Criteria:

Session time freezes.

Priority:
⭐⭐⭐⭐

---

## TICKET-013 - Speed multiplier

Description:

Developer speeds:

1x

2x

5x

10x

60x

Acceptance Criteria:

Cooking progresses faster.

Priority:
⭐⭐⭐

---

# Epic: Notifications

## TICKET-014 - Local notification scheduler

Description:

Generate notifications from timeline.

Acceptance Criteria:

Upcoming notifications visible.

Priority:
⭐⭐⭐⭐

---

## TICKET-015 - Notification testing mode

Description:

Developer button:

"Fire next notification"

Acceptance Criteria:

Can test notifications instantly.

Priority:
⭐⭐⭐⭐

---

# Epic: Recipe Detail

## TICKET-016 - Recipe detail page

Description:

Display:

Description

Ingredients

Nutrition

Timeline

Acceptance Criteria:

Recipe view exists before cooking starts.

Priority:
⭐⭐⭐

---

# Epic: Timeline Visualisation

## TICKET-017 - Timeline component

Description:

Visual timeline.

Shows:

Past

Current

Future

Acceptance Criteria:

Easy to understand cooking progress.

Priority:
⭐⭐⭐⭐

---

## TICKET-018 - Parallel timeline support

Description:

Support overlapping activities.

Acceptance Criteria:

Multiple active timelines render correctly.

Priority:
⭐⭐

---

# Epic: Polish

## TICKET-019 - Finished cooking screen

Description:

Display:

🎉

Recipe complete.

Acceptance Criteria:

Cooking session ends gracefully.

Priority:
⭐⭐⭐⭐

---

## TICKET-020 - Restart recipe

Description:

Allow immediate restart.

Acceptance Criteria:

New CookingSession created.

Priority:
⭐⭐⭐

---

# Stretch Goals

- AI recipe import
- OCR
- Recipe scaling
- Ingredient substitutions
- Creator tools
- Marketplace
- Cloud sync
- User accounts