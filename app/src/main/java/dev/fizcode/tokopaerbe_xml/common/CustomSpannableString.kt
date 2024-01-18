package dev.fizcode.tokopaerbe_xml.common

import android.content.Context
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import dev.fizcode.tokopaerbe_xml.R


class CustomSpannableString {

    companion object {
        fun applyCustomTextColor(context: Context, fullText: String): SpannableString {
            val spannableString = SpannableString(fullText)

            val startTNC = fullText.indexOf("Syarat & Ketentuan")
            val endTNC = startTNC + "Syarat & Ketentuan".length

            val startPrivacyPolicy = fullText.indexOf("Kebijakan Privasi")
            val endPrivacyPolicy = startPrivacyPolicy + "Kebijakan Privasi".length

            val customPrimaryColor = ContextCompat.getColor(context, R.color.md_theme_light_primary)
            spannableString.setSpan(ForegroundColorSpan(customPrimaryColor), startTNC, endTNC, 0)
            spannableString.setSpan(
                ForegroundColorSpan(customPrimaryColor),
                startPrivacyPolicy,
                endPrivacyPolicy,
                0
            )

            return spannableString
        }
    }
}