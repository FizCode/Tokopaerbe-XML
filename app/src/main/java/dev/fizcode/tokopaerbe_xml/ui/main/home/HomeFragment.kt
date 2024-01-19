package dev.fizcode.tokopaerbe_xml.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.fizcode.tokopaerbe_xml.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
        bindViewModel()
        homeViewModel.onViewLoaded()
    }

    private fun bindView() {
        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                homeViewModel.setTheme("DARK")
            } else {
                homeViewModel.setTheme("LIGHT")
            }
        }
    }

    private fun bindViewModel() {
        homeViewModel.shouldBeDarkTheme.observe(viewLifecycleOwner) { isDark ->
            if (isDark) {
                binding.switchTheme.isChecked = isDark
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                binding.switchTheme.isChecked = !isDark
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

}