/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation.recipies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.navigation.R
import com.example.android.codelabs.navigation.R.layout
import com.example.android.codelabs.navigation.recipies.getReceipeList
import com.example.android.codelabs.navigation.recipies.ui.ItemListAdapter.ItemClickHandler
import kotlinx.android.synthetic.main.item_list_fragment.view.item_list

/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment(), ItemClickHandler {

    override fun onItemCLick(selectedItem: Int) {
        findNavController().navigate(R.id.action_go_detail, null)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(layout.item_list_fragment, container, false)
        val listAdapter =
            ItemListAdapter(context, this)
        view.item_list.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = listAdapter
        }
        //feed data to recycler view
        setDataToList(listAdapter)

        return view
    }

    private fun setDataToList(adapter: ItemListAdapter){
        adapter.setReceipeList(getReceipeList())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}
