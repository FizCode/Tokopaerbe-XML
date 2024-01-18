package dev.fizcode.tokopaerbe_xml.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.fizcode.tokopaerbe_xml.R
import dev.fizcode.tokopaerbe_xml.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    private lateinit var binding : FragmentMainMenuBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navView: BottomNavigationView = binding.bottomNav
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_bottom_fragment) as NavHostFragment

        navController = navHostFragment.navController

        navView.setupWithNavController(navController)

    }

}