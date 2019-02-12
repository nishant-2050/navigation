package com.example.android.codelabs.navigation.recipies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.codelabs.navigation.R.layout
import com.example.android.codelabs.navigation.recipies.ItemListAdapter.ItemListViewHolder
import com.example.android.codelabs.navigation.recipies.data.RecipeList
import kotlinx.android.synthetic.main.row_list_item.view.id_ingr
import kotlinx.android.synthetic.main.row_list_item.view.id_thumbnail
import kotlinx.android.synthetic.main.row_list_item.view.id_title

class ItemListAdapter(
    val context: Context?,
    val handler: ItemClickHandler
) : RecyclerView.Adapter<ItemListViewHolder>() {

    lateinit var mRecipeList: RecipeList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val inflatedView =
            LayoutInflater.from(context).inflate(layout.row_list_item, parent, false)
        return ItemListViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return mRecipeList.receipes.size
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        val recipe = mRecipeList.receipes[position]
        holder.apply {
            title.text = recipe.title
            ingredients.text = recipe.ingredients
        }
        Glide.with(context)
            .load(recipe.thumbnail)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.thumbnail)
    }

    fun setReceipeList(recipeList: RecipeList) {
        mRecipeList = recipeList
        notifyDataSetChanged()
    }

    interface ItemClickHandler {
        fun onItemCLick(selectedItem: Int)
    }

    inner class ItemListViewHolder(view: View) : RecyclerView.ViewHolder(view), OnClickListener {
        var title: TextView = view.id_title
        var ingredients: TextView = view.id_ingr
        var thumbnail: ImageView = view.id_thumbnail

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            handler.onItemCLick(adapterPosition)
        }
    }
}