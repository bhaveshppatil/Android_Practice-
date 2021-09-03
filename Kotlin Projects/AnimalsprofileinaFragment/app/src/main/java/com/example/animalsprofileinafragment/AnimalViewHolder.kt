package com.example.animalsprofileinafragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.animal_item_layout.view.*

class AnimalViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setAnimalData(animalModel: AnimalModel) {
        view.apply {
            tvName.text = animalModel.name
            Glide.with(ivProfile).load(animalModel.imagePath).into(ivProfile)
        }
    }
}