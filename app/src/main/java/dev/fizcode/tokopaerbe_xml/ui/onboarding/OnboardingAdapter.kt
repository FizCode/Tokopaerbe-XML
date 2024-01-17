package dev.fizcode.tokopaerbe_xml.ui.onboarding

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.fizcode.tokopaerbe_xml.R
import dev.fizcode.tokopaerbe_xml.databinding.ImgCointainerOnboardingBinding

class OnboardingAdapter(
    private var imageList: ArrayList<Int>
) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {

    inner class ViewHolder(
        val binding: ImgCointainerOnboardingBinding
    ) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataChanged")
    fun updateOnboardingImage(image: ArrayList<Int>) {
        this.imageList = image
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ImgCointainerOnboardingBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgOnboarding.setImageResource(imageList[position])
        holder.binding.imgOnboarding.setBackgroundColor(Color.TRANSPARENT)
    }
}