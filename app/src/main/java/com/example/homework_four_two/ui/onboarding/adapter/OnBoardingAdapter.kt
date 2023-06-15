package com.example.homework_four_two.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.homework_four_two.databinding.ItemOnboardingBinding
import com.example.homework_four_two.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = listOf(
        OnBoarding("Вода и рыбка", "Рыбки утонули ", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSt0jeuI8duekRytsimWU10Q7c_pSgVviWe7Q&usqp=CAU"),
        OnBoarding("Больше воды", "В конце гора", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLC1-baIu-fcn8E26Skx6vaCcHjZvZCJ0I5W6wKu7MuiIqmo0_b5z29W1BaCutmjdyPss&usqp=CAU"),
        OnBoarding("Вода с облоками", "Без рыбок", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmH3Ep35qB-9V6xHJ98FTzp938uEXFfAa5s_hMC6SJoVDJT1RgtDoOqLQDJR6H2mNuMos&usqp=CAU")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            Glide.with(ivOnboard).load(onBoarding.image).into(ivOnboard)
            btnStart.isVisible = adapterPosition == list.lastIndex
            btnStart.setOnClickListener {
                onClick()
            }
        }
    }
}