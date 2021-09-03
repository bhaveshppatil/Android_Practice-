package com.example.animalsprofileinafragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_animal.*

class AnimalFragment : Fragment(R.layout.fragment_animal) {

    private val animalModelList = ArrayList<AnimalModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildAnimalData()
        setRecyclerView()
    }

    private fun buildAnimalData() {
        for (i in 1..10) {
            animalModelList.add(
                AnimalModel(
                    "Fox",
                    "https://images.unsplash.com/photo-1470093851219-69951fcbb533?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
                )
            )
            animalModelList.add(
                AnimalModel(
                    "White Rhinos in the South African veld",
                    "https://images.unsplash.com/flagged/photo-1557650454-65194af63bf9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
                )
            )
            animalModelList.add(
                AnimalModel(
                    "Black and white zebra",
                    "https://images.unsplash.com/photo-1501706362039-c06b2d715385?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=535&q=80"
                )
            )
            animalModelList.add(
                AnimalModel(
                    "Fox Wild Nature",
                    "https://images.unsplash.com/photo-1535393857990-03242fe70580?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
                )
            )

            animalModelList.add(
                AnimalModel(
                    "Lions",
                    "https://images.unsplash.com/photo-1559899289-df9330a3116a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
                )
            )
            animalModelList.add(
                AnimalModel(
                    "Tiger",
                    "https://images.unsplash.com/photo-1556713304-e5ac0f02e516?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
                )
            )

            animalModelList.add(
                AnimalModel(
                    "Brown Bear",
                    "https://images.unsplash.com/photo-1572119710866-93ba6aea5810?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=924&q=80"
                )
            )

            animalModelList.add(
                AnimalModel(
                    "Elephants",
                    "https://images.unsplash.com/photo-1518217065450-4a8bfc17bf38?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
                )
            )
            animalModelList.add(
                AnimalModel(
                    "Cheetah's",
                    "https://images.unsplash.com/photo-1514227344848-4e29bbe5b488?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80"
                )
            )
            animalModelList.add(
                AnimalModel(
                    "leopard",
                    "https://images.unsplash.com/photo-1541799027-fb83463ee9c5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=967&q=80"
                )
            )
        }
    }

    private fun setRecyclerView() {

        val animalAdapter = AnimalAdapter(animalModelList)
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = animalAdapter
        recyclerView.layoutManager = gridLayoutManager
    }
}