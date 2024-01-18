package dev.fizcode.tokopaerbe_xml.ui.auth.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.fizcode.tokopaerbe_xml.R
import dev.fizcode.tokopaerbe_xml.common.CustomSpannableString
import dev.fizcode.tokopaerbe_xml.databinding.FragmentSigninBinding


@AndroidEntryPoint
class SigninFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null
    private val binding get() = _binding!!

    val signinViewModel: SigninViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSigninBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        bindView()

        return root
    }

    private fun bindView() {

        // Set spannable string on Terms & Condition
        val tnc = binding.txtLoginTnc
        tnc.text = CustomSpannableString.applyCustomTextColor(
            requireContext(),
            "Dengan masuk disini, kamu menyetujui Syarat & Ketentuan serta Kebijakan Privasi TokoPhincon."
        )

        binding.btnSigninMasuk.setOnClickListener {
            /* TODO: Form Validation */
        }

        binding.btnSigninDaftar.setOnClickListener {
            findNavController().navigate(R.id.action_signinFragment_to_signupFragment)
        }
    }

    @Override
    fun onBackPressed() {
        Log.d("CDA", "onBackPressed Called")
        val setIntent = Intent(Intent.ACTION_MAIN)
        setIntent.addCategory(Intent.CATEGORY_HOME)
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(setIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onBackPressed()
    }

}