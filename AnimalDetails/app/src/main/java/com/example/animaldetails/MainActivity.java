package com.example.animaldetails;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {
    private RecyclerView recyclerView;
    private ArrayList<AnimalModel> modelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rclView);
        buildAnimalData();
        setRecyclerView();

    }

    private void setRecyclerView() {
        AnimalAdapter animalAdapter = new AnimalAdapter(modelArrayList, this);
        GridLayoutManager linearLayout = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(animalAdapter);
    }

    private void buildAnimalData() {
        modelArrayList.add(new AnimalModel("Alligator", "bellow, hiss", R.drawable.alligator));
        modelArrayList.add(new AnimalModel("Bear", "roar, growl", R.drawable.bears_animal_wildlife));
        modelArrayList.add(new AnimalModel("Tiger", "growl", R.drawable.tiger_de_edit02));
        modelArrayList.add(new AnimalModel("Cat", "mew, meow", R.drawable.cat));
        modelArrayList.add(new AnimalModel("Deer", "bellow", R.drawable.deer));
        modelArrayList.add(new AnimalModel("Dog", "bow-wow", R.drawable.dog));
        modelArrayList.add(new AnimalModel("Eagle", "Screech", R.drawable.eagle_raftsund_square_crop));
        modelArrayList.add(new AnimalModel("Elephant", "trumpet", R.drawable.elephant));
        modelArrayList.add(new AnimalModel("Horse", "whinny, nicker", R.drawable.horse_in_ladakh));
        modelArrayList.add(new AnimalModel("Lion", "roar, growl, snarl", R.drawable.lion_waiting_in_namibia));
        modelArrayList.add(new AnimalModel("Monkey", "scream, chatter", R.drawable.monkey_eating));
        modelArrayList.add(new AnimalModel("Prairie dog", "bark", R.drawable.prairie_dog));
        modelArrayList.add(new AnimalModel("Raccoon", "trill", R.drawable.raccoon_in_the_rain));
        modelArrayList.add(new AnimalModel("Squirrel", "squeak", R.drawable.squirrel_posing));
        modelArrayList.add(new AnimalModel("Wolf", "bellow, hiss", R.drawable.mexican_wolf));
        modelArrayList.add(new AnimalModel("Leopard", "roar, growl", R.drawable.african_leopard_male));
        modelArrayList.add(new AnimalModel("Jaguar", "roar, growl, snarl", R.drawable.standing_jaguar));
        modelArrayList.add(new AnimalModel("Asian Cat", "growl, snarl", R.drawable.asian_golden_cat_974x1024));
        modelArrayList.add(new AnimalModel("Caracal cat", "growl", R.drawable.caracal_cat));
        modelArrayList.add(new AnimalModel("Clouded Leopard", "roar, growl", R.drawable.clouded_leopard));
        modelArrayList.add(new AnimalModel("Snow Leopard", "roar", R.drawable.snow_leopard));
        modelArrayList.add(new AnimalModel("Raccoon", "trill", R.drawable.raccoon_in_the_rain));


    }

    @Override
    public void onClick(int position, AnimalModel animalModel) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(animalModel.getTvName() + " Data")
                .setIcon(animalModel.getImgID())
                .setMessage("Name: " + animalModel.getTvName()).show();

    }
}