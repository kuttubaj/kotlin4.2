package com.example.kotlin42.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin42.R
import com.example.kotlin42.databinding.FragmentAddItemBinding
import com.example.kotlin42.presentation.data.models.Anime


class AddItemFragment : Fragment() {

    private lateinit var binding: FragmentAddItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnEnd.setOnClickListener {
            if (binding.etAddItem.text.isEmpty()) {
                binding.etAddItem.error = "No text"
            } else {
                val name = binding.etAddItem.text.toString().trim()
                val animeModel = Anime(name, R.drawable.ic_launcher_background)
                Log.e("cryptoList", "setupListener: ${animeModel}")
                findNavController().navigate(
                    AddItemFragmentDirections.actionAddItemFragmentToHomeFragment(animeModel)
                )
            }
        }
    }
}