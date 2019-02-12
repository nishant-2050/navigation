package com.example.android.codelabs.navigation.recipies

import com.example.android.codelabs.navigation.recipies.data.model.Recipe
import com.example.android.codelabs.navigation.recipies.data.model.RecipeList

fun getReceipeList() : RecipeList {
    var recipe1 = Recipe(
        1,
        "title1",
        "url1",
        "ingr1",
        "thumbnail url",
        0
    )
    var recipe2 = Recipe(
        2,
        "title1",
        "url1",
        "ingr1",
        "thumbnail url",
        0
    )
    var recipe3 = Recipe(
        3,
        "title1",
        "url1",
        "ingr1",
        "thumbnail url",
        0
    )

    var recipies = listOf<Recipe>(recipe1, recipe2, recipe3)
    var recipeList  = RecipeList(
        "title",
        "version",
        "link",
        recipies
    )
    return recipeList
}