package com.example.kotlin42.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlin42.R
import com.example.kotlin42.databinding.FragmentHomeBinding
import com.example.kotlin42.presentation.ui.SafeList
import com.example.kotlin42.presentation.ui.adapter.AnimeAdapter


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val animeAdapter = AnimeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        try {
            val args: HomeFragmentArgs by navArgs()
            SafeList.anime.add(args.animeModel)
            animeAdapter.setAnimeList(SafeList.anime)
            binding.rvFragmentHome.adapter = animeAdapter
        }catch (exception: Exception) {

        }
    }

    private fun setupListeners() {
        binding.btnAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addItemFragment)
        }
    }
}
