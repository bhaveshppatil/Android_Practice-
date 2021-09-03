package com.example.animalsprofileinafragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(val animalModelList: List<AnimalModel>) : RecyclerView.Adapter<AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.animal_item_layout, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animalModel: AnimalModel = animalModelList[position]
        holder.setAnimalData(animalModel)
    }

    override fun getItemCount(): Int {
        return animalModelList.size
    }
}