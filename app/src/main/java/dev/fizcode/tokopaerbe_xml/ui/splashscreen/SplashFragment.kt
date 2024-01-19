package dev.fizcode.tokopaerbe_xml.ui.splashscreen

import android.animation.ObjectAnimator
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.fizcode.tokopaerbe_xml.R
import dev.fizcode.tokopaerbe_xml.databinding.FragmentSplashBinding

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        // Splash Duration and logic to the next fragment
        val animationDuration = 1000L
        val handler = Handler(Looper.getMainLooper())

        rotateView(animationDuration)
        translationX(animationDuration)
        translationY(animationDuration)
        handler.postDelayed({
            splashViewModel.onViewLoaded()
        }, 3000)

        bindViewModel()

        return root
    }

    private fun rotateView(rotateDuration: Long = 1500) {
        val rotateRed = ObjectAnimator.ofFloat(
            binding.shapeRed, View.ROTATION, 0f, 20f,
        )
        val rotateYellow = ObjectAnimator.ofFloat(
            binding.shapeYellow, View.ROTATION, 0f, -20f
        )

        rotateRed.duration = rotateDuration
        rotateYellow.duration = rotateDuration
        rotateRed.start()
        rotateYellow.start()
    }

    private fun translationX(translateDuration: Long = 1500) {
        val translateXRed = ObjectAnimator.ofFloat(
            binding.shapeRed, View.TRANSLATION_X, 0f, -50F
        )
        val translateXYellow = ObjectAnimator.ofFloat(
            binding.shapeRed, View.TRANSLATION_X, 0f, 100F
        )

        translateXRed.duration = translateDuration
        translateXYellow.duration = translateDuration
        translateXRed.start()
        translateXYellow.start()
    }

    private fun translationY(translateDuration: Long = 1500) {
        val translateYGreen = ObjectAnimator.ofFloat(
            binding.shapeGreen, View.TRANSLATION_Y, 0f, -100f
        )
        val translateYRed = ObjectAnimator.ofFloat(
            binding.shapeGreen, View.TRANSLATION_Y, 0f, -40f
        )
        val translateYYellow = ObjectAnimator.ofFloat(
            binding.shapeGreen, View.TRANSLATION_Y, 0f, -100f
        )

        translateYGreen.duration = translateDuration
        translateYRed.duration = translateDuration
        translateYYellow.duration = translateDuration
        translateYGreen.start()
        translateYRed.start()
        translateYYellow.start()
    }

    private fun bindViewModel() {

        splashViewModel.shouldSkipOnboarding.observe(viewLifecycleOwner) { skipOnboard ->
            if (skipOnboard) {
                splashViewModel.shouldSkipAuth.observe(viewLifecycleOwner) { signedIn ->
                    if (signedIn) {
                        findNavController().navigate(R.id.action_SplashFragment_to_mainMenuFragment)
                    } else {
                        findNavController().navigate(R.id.action_SplashFragment_to_signinFragment)
                    }
                }
            } else {
                findNavController().navigate(R.id.action_SplashFragment_to_OnBoardingFragment)
            }
        }

        splashViewModel.shouldCheckAppTheme.observe(viewLifecycleOwner) { theme ->
            if (theme == "LIGHT") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else if (theme == "DARK") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                if (!isDarkModeOn()) {
                    splashViewModel.setTheme("LIGHT")
                } else {
                    splashViewModel.setTheme("DARK")
                }
            }

        }
    }

    private fun isDarkModeOn(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }


}