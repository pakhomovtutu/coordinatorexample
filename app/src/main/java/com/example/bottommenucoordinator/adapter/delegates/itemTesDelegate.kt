package com.example.bottommenucoordinator

import com.example.bottommenucoordinator.databinding.ItemListTestBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun itemTestDelegate() =
    adapterDelegateViewBinding<Int, Int, ItemListTestBinding>(
        { layoutInflater, root -> ItemListTestBinding.inflate(layoutInflater, root, false) }
    ) {

        bind {
            binding.info.text = item.toString()
        }
    }