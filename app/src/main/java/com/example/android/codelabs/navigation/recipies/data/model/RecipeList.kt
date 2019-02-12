package com.example.android.codelabs.navigation.recipies.data.model

data class RecipeList(
    var title: String,
    var version: String,
    var link: String,
    var receipes: List<Recipe>
)
