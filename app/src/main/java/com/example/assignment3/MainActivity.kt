package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment3.data.Food
import com.example.assignment3.data.foods
import com.example.assignment3.ui.theme.Assignment3Theme

import androidx.compose.material3.MaterialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Assignment30days()
                }
            }
        }
    }
}

@Composable
fun Assignment30days() {
    Scaffold(
        topBar = {
            foodTopAppBar()
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(foods) { food ->
                FoodItem(food = food)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun foodTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.healthyfood),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
                )
            }

        },
        modifier = modifier
    )

}

@Composable
fun FoodItem(
    food: Food,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )
    Card(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
            .clickable { expanded = !expanded } // Toggle expanded state on click
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = color)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(dimensionResource(R.dimen.padding_small)),
                    horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                .fillMaxWidth()

            ) {
                // Display the image
                Text(
                    text = stringResource(id = food.name),
                    //style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                // Display the name

            }
            Image(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.food_image_size))
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                painter = painterResource(id = food.imageResourceId),
                contentDescription = null
            )
            // Show description and hyperlink if expanded
            if (expanded) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                FoodDetail(
                    foodDetail = food.description, // Pass the description to FoodDetail
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}





@Composable
fun FoodDetail(
    foodDetail: Int, // Remove the @StringRes annotation
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(id = foodDetail), // Update to use the foodDetail directly
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun Hyperlink(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        //colors = Color.Red,
        modifier = modifier.clickable { onClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun Assignment30daysPreview() {
    Assignment3Theme {
        Assignment30days()
    }
}
