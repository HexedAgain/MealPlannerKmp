package com.example.mealplannerkmp.domain.model

import com.example.mealplannerkmp.domain.model.ingredient.Ingredient
import com.example.mealplannerkmp.domain.model.ingredient.IngredientClass
import com.example.mealplannerkmp.domain.model.ingredient.IngredientSet
import com.example.mealplannerkmp.domain.model.nutrition.NutritionItem
import com.example.mealplannerkmp.domain.model.nutrition.NutritionType
import com.example.mealplannerkmp.domain.model.nutrition.RecipeNutrition
import com.example.mealplannerkmp.domain.model.recipeUnit.ComplexRecipeUnit
import com.example.mealplannerkmp.domain.model.recipeUnit.SimpleRecipeUnit
import com.example.mealplannerkmp.domain.model.timeline.RecipeTimeLine
import com.example.mealplannerkmp.domain.model.timeline.TimeLineStart

val recipe = Recipe(
    title = "Spaghetti Bolognese",
    description = "Our best ever spaghetti bolognese is super easy and a true Italian classic with a meaty, chilli sauce. This pasta bolognese recipe is sure to become a family favourite.",
    image = "https://media.delight.video/0c18e53b610964fac175fe0e757adc30557e79b7/3bc1208e7a20c38eba142fc1478c3b3407c76f40/POSTER_USER/v0/3bc1208e7a20c38eba142fc1478c3b3407c76f40.jpeg?quality=90",
    video = null,
    nutrition = RecipeNutrition(
        items = listOf(
            NutritionItem(
                type = NutritionType.Calories,
                qty = RecipeQuantity(qty = 624.0f, unit = SimpleRecipeUnit.KiloCalorie)
            ),
            NutritionItem(
                type = NutritionType.Fat,
                qty = RecipeQuantity(qty = 24.0f, unit = SimpleRecipeUnit.Gram)
            ),
            NutritionItem(
                type = NutritionType.Saturates,
                qty = RecipeQuantity(qty = 10.0f, unit = SimpleRecipeUnit.Gram)
            ),
            NutritionItem(
                type = NutritionType.Carbs,
                qty = RecipeQuantity(qty = 58.0f, unit = SimpleRecipeUnit.Gram)
            ),
            NutritionItem(
                type = NutritionType.Fibre,
                qty = RecipeQuantity(qty = 6.0f, unit = SimpleRecipeUnit.Gram)
            ),
            NutritionItem(
                type = NutritionType.Protein,
                qty = RecipeQuantity(qty = 35.0f, unit = SimpleRecipeUnit.Gram)
            ),
            NutritionItem(
                type = NutritionType.Salt,
                qty = RecipeQuantity(qty = 1.6f, unit = SimpleRecipeUnit.Gram)
            ),
        )
    ),
    preparationTime = RecipeTime(mins = 25.0f),
    cookTime = RecipeTime(mins = 50.0f, hours = 1.0f),
    difficulty = RecipeDifficulty.Easy,
    serves = 6,
    ratings = 4.5f,
    ingredients = listOf(
        IngredientSet(
            ingredientClass = IngredientClass.Global,
            ingredients = listOf(
                Ingredient(
                    name = "olive oil",
                    quantity = RecipeQuantity(qty = 1.0f, unit = SimpleRecipeUnit.TableSpoon)
                ),
                Ingredient(
                    name = "rashers smoked streaky bacon",
                    quantity = RecipeQuantity(qty = 4.0f),
                    extraDetails = listOf("finely chopped")
                ),
                Ingredient(
                    name = "medium onions",
                    quantity = RecipeQuantity(qty = 2.0f),
                    extraDetails = listOf("finely chopped")
                ),
                Ingredient(
                    name = "carrots",
                    quantity = RecipeQuantity(qty = 2.0f),
                    extraDetails = listOf("trimmed and finely chopped")
                ),
                Ingredient(
                    name = "celery sticks",
                    quantity = RecipeQuantity(qty = 2.0f),
                    extraDetails = listOf("finely chopped")
                ),
                Ingredient(
                    name = "garlic cloves",
                    quantity = RecipeQuantity(qty = 2.0f),
                    extraDetails = listOf("finely chopped")
                ),
                Ingredient(
                    name = "rosemary leaves",
                    quantity = RecipeQuantity(
                        qtyMin = 2.0f,
                        qtyMax = 3.0f,
                        unit = SimpleRecipeUnit.Sprig
                    ),
                    extraDetails = listOf("finely chopped")
                ),
                Ingredient(
                    name = "beef mince",
                    quantity = RecipeQuantity(qty = 500f, unit = SimpleRecipeUnit.Gram),
                    extraDetails = listOf("finely chopped")
                ),
            )
        ),
        IngredientSet(
            ingredientClass = IngredientClass.Custom("For the bolognese sauce"),
            ingredients = listOf(
                Ingredient(
                    name = "plum tomatoes",
                    quantity = RecipeQuantity(
                        qty = 2.0f,
                        unit = ComplexRecipeUnit.Tin(
                            qty = RecipeQuantity(
                                400f,
                                unit = SimpleRecipeUnit.Gram
                            )
                        )
                    )
                ),
                Ingredient(
                    name = "small pack basil leaves picked",
                    quantity = RecipeQuantity(qty = 1f),
                    extraDetails = listOf("3/4 finely chopped and the rest left for garnish")
                ),
                Ingredient(
                    name = "dried oregano",
                    quantity = RecipeQuantity(qty = 1f, unit = SimpleRecipeUnit.TableSpoon),
                ),
                Ingredient(
                    name = "beef stock cube",
                    quantity = RecipeQuantity(qty = 1f),
                ),
                Ingredient(
                    name = "red chilli",
                    quantity = RecipeQuantity(qty = 1f),
                    extraDetails = listOf("deseeded and finely chopped"),
                    isOptional = true
                ),
                Ingredient(
                    name = "red wine",
                    quantity = RecipeQuantity(qty = 125f, unit = SimpleRecipeUnit.Millilitre),
                ),
                Ingredient(
                    name = "cherry tomatoes",
                    quantity = RecipeQuantity(qty = 6f),
                    extraDetails = listOf("sliced in half")
                ),
            )
        ),
        IngredientSet(
            ingredientClass = IngredientClass.Custom("To season and serve"),
            ingredients = listOf(
                Ingredient(
                    name = "parmesan",
                    quantity = RecipeQuantity(qty = 75f, unit = SimpleRecipeUnit.Gram),
                    extraDetails = listOf("grated, plus extra to serve")
                ),
                Ingredient(
                    name = "spaghetti",
                    quantity = RecipeQuantity(qty = 400f, unit = SimpleRecipeUnit.Gram),
                ),
                Ingredient(
                    name = "crusty bread",
                    quantity = RecipeQuantity(qty = 1f),
                    extraDetails = listOf("to serve"),
                    isOptional = true
                ),
            )
        ),
    ),
    timelineSteps = listOf(
        RecipeTimeLine(
            start = TimeLineStart.AbsoluteTimeLine(time = RecipeTime.Zero),
            steps = listOf(
                RecipeStep(
                    title = "Step 1",
                    body = "Put a large saucepan on a medium heat and add 1 tbsp olive oil.",
                    time = RecipeTime.Zero
                ),
                RecipeStep(
                    title = "Step 2",
                    body = "Add 4 finely chopped bacon rashers and fry for 10 mins until golden and crisp.",
                    time = RecipeTime(mins = 10f)
                ),
                RecipeStep(
                    title = "Step 3",
                    body = "Reduce the heat and add the 2 onions, 2 carrots, 2 celery sticks, 2 garlic cloves and the leaves from 2-3 sprigs rosemary, all finely chopped, then fry for 10 mins. Stir the veg often until it softens.",
                    time = RecipeTime(mins = 10f)
                ),
                RecipeStep(
                    title = "Step 4",
                    body = "Increase the heat to medium-high, add 500g beef mince and cook stirring for 3-4 mins until the meat is browned all over.",
                    time = RecipeTime(minsLower = 3f, minsUpper = 4f)
                ),
                RecipeStep(
                    title = "Step 3",
                    body = "Add 2 tins plum tomatoes, the finely chopped leaves from 3/4 small pack basil, 1 tsp dried oregano, 2 bay leaves, 2 tbsp tomato purée, 1 beef stock cube, 1 deseeded and finely chopped red chilli (if using), 125ml red wine and 6 halved cherry tomatoes. Stir with a wooden spoon, breaking up the plum tomatoes.",
                    time = RecipeTime(minsLower = 1f, minsUpper = 5f)
                ),
                RecipeStep(
                    title = "Step 6",
                    body = "Bring to the boil, reduce to a gentle simmer and cover with a lid. Cook for 1 hr 15 mins stirring occasionally, until you have a rich, thick sauce.",
                    time = RecipeTime(mins = 15f)
                ),
                RecipeStep(
                    title = "Step 7",
                    body = "Add the 75g grated parmesan, check the seasoning and stir.",
                    time = RecipeTime(mins = 15f)
                )
            )
        ),
        RecipeTimeLine(
            start = TimeLineStart.RelativeTimeLine(
                timelineRef = 0, titleRef = "Step 6", offset = RecipeTime(mins = 10.0f)
            ),
            steps = listOf(
                RecipeStep(
                    title = "Step 8",
                    body = "When the bolognese is nearly finished, cook 400g spaghetti following the pack instructions.",
                    time = RecipeTime(minsLower = 5f, minsUpper = 10f)
                ),
                RecipeStep(
                    title = "Step 9",
                    body = "Drain the spaghetti and either stir into the bolognese sauce, or serve the sauce on top. Serve with more grated parmesan, the remaining basil leaves and crusty bread, if you like.",
                    time = RecipeTime.Zero
                )
            )
        )
    )
)
