package dev.fizcode.tokopaerbe_xml.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import dev.fizcode.tokopaerbe_xml.R
import dev.fizcode.tokopaerbe_xml.databinding.FragmentOnboardingBinding

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OnBoardingViewModel by viewModels()

    private lateinit var onboardingAdapter: OnBoardingAdapter
    private lateinit var imageList: ArrayList<Int>
    private lateinit var vpOnboarding: ViewPager2
    private lateinit var tabValue: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        bindView(container = container)

        return root
    }

    private fun bindView(container: ViewGroup?) {
        vpOnboarding = binding.vpOnboarding
        tabValue = binding.tabOnboardingTabView
        imageList = arrayListOf(
            R.drawable.onboard1,
            R.drawable.onboard2,
            R.drawable.onboard3
        )

        onboardingAdapter = OnBoardingAdapter(imageList)
        vpOnboarding.adapter = onboardingAdapter

        TabLayoutMediator(tabValue, vpOnboarding) { tab, _ ->
            tab.customView = layoutInflater.inflate(R.layout.tab_layout_custom, container, false)
        }.attach()

        vpOnboarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    2 -> binding.btnNext.isGone = true
                    else -> binding.btnNext.isGone = false
                }
            }
        })

        // onClick Listener
        binding.btnJoin.setOnClickListener {
            viewModel.completeOnboarding()
            println("fragment JoinButton")
            findNavController().navigate(R.id.action_OnBoardingFragment_to_signupFragment)
        }
        binding.btnSkip.setOnClickListener {
            viewModel.completeOnboarding()
            println("fragment SkipButton")
            findNavController().navigate(R.id.action_OnBoardingFragment_to_signinFragment)
        }
        binding.btnNext.setOnClickListener {
            val nextIndex = vpOnboarding.currentItem + 1
            vpOnboarding.setCurrentItem(nextIndex, true)
        }

    }


}