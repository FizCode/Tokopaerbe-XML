package dev.fizcode.tokopaerbe_xml.ui.splashscreen

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.fizcode.tokopaerbe_xml.R
import dev.fizcode.tokopaerbe_xml.databinding.FragmentSplashBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    val videModel: SplashViewModel by viewModels()
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
        val timer = object : CountDownTimer(3000, 100) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                videModel.onViewLoaded()
                startActivity()
            }

        }

        rotateView(animationDuration)
        translationX(animationDuration)
        translationY(animationDuration)
        timer.start()
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

    private fun startActivity() {
        findNavController().navigate(R.id.action_SplashFragment_to_OnBoardingFragment)
    }

    private fun bindViewModel() {
        /* TODO("Business logic and navigation to onboarding or auth") */
    }

    private fun bindView() {
        /* TODO("Not yet implemented") */
    }


}