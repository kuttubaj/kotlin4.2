package com.example.kotlin42.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin42.R
import com.example.kotlin42.databinding.FragmentSingApBinding
import com.example.kotlin42.presentation.data.SharedPreferences


class SingApFragment : Fragment() {

    private var _binding: FragmentSingApBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingApBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() = with(binding) {
        val prefenceHelper = SharedPreferences(requireContext())
        btnSignIn.setOnClickListener {
            if (binding.etUserName.text.isEmpty() || binding.etPochta.text.isEmpty() || binding.etParol.text.isEmpty() || binding.etParol2.text.isEmpty()) {
                
            } else {
                if (etParol.text.toString().trim() == etParol2.text.toString().trim()) {
                    prefenceHelper.userName = etUserName.text.toString().trim()
                    prefenceHelper.userMail = etPochta.text.toString().trim()
                    prefenceHelper.userPassword = etParol.text.toString().trim()
                    findNavController().navigate(R.id.action_singApFragment_to_homeFragment)
                } else {
                    etParol.error = "Wrong password"
                    etParol2.error = "Wrong password"
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
