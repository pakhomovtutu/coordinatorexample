package com.example.bottommenucoordinator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottommenucoordinator.databinding.FragmentSecondBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        listSetup()
        return binding.root

    }
    private fun listSetup() {
        val listAdapter = ListDelegationAdapter<List<Int>> (
            itemTestDelegate()
        )

        listAdapter.items = (1..100).toList()

        binding.mainList.adapter = listAdapter

        //Декоратор задает отступ для первого элемента что бы тулбар в начале его не перекрывал
        binding.mainList.addItemDecoration(FirstElementSpaceDecorator())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}