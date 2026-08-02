package com.example.mealplannerkmp.android.homescreen

import android.view.RoundedCorner
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mealplannerkmp.domain.model.Recipe
import com.example.mealplannerkmp.domain.model.sampleRecipe
import org.koin.androidx.compose.koinViewModel

@Composable
fun RecipeListing(recipeListingViewModel: RecipeListingViewModel = koinViewModel()) {
    recipeListingViewModel.insertRecipe()
    Scaffold { _ ->
        Column(modifier = Modifier.padding(16.dp)) {
            UIRecipe(sampleRecipe)
        }
    }
}

// FIXME - this needs to be a ui model not a domain model
@Composable
fun UIRecipe(recipe: Recipe) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .height(250.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        // Really I would like this to be in 4:3 aspect ratio
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            AsyncImage(
                model = recipe.image,
                modifier = Modifier.height(150.dp),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = recipe.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 1.2.em
            )
        }
    }
}

@Composable
fun Carousel(recipes: List<Recipe>) {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) { }
}