package com.example.callerapp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickListener {

    private static final int REQ_CODE = 99;
    private List<PersonModel> personModelList = new ArrayList<>();
    private ClickListener clickListener;
    private TextView tvPName, tvPNumber;
    private ImageView pAvatar;
    private Context context;
    private RecyclerView recyclerView;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        String[] permission = {Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(MainActivity.this, permission, REQ_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            buildData();
            setRecyclerView();

        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this)

                    .setTitle("Contact Permission Needed")
                    .setMessage("You have to allow contact permission to show list of contact")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String[] permission = {Manifest.permission.READ_CONTACTS};
                            ActivityCompat.requestPermissions(MainActivity.this, permission, REQ_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "Nothing Happened", Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }
    }

    private void initViews() {
        tvPName = findViewById(R.id.tvPersonName);
        tvPNumber = findViewById(R.id.tvContactNo);
        pAvatar = findViewById(R.id.ContactProfile);
        recyclerView = findViewById(R.id.recyclerView);
        cardView = findViewById(R.id.cardView);

    }

    public void buildData() {

        personModelList.add(new PersonModel("Bill Gates", "8108432474", R.drawable.men_contact));
        personModelList.add(new PersonModel("Elon Musk", "7551986200", R.drawable.men_contact));
        personModelList.add(new PersonModel("Alice Walton", "9748651234", R.drawable.women_contact));
        personModelList.add(new PersonModel("Jeff Bezos", "7743249414", R.drawable.men_contact));
        personModelList.add(new PersonModel("Jack Ma", "7984026541", R.drawable.men_contact));
        personModelList.add(new PersonModel("MacKenzie Scott", "8876120466", R.drawable.women_contact));
        personModelList.add(new PersonModel("Mark Zuckerberg", "8602496145", R.drawable.men_contact));
        personModelList.add(new PersonModel("Miriam Adelson", "8877445613", R.drawable.women_contact));
        personModelList.add(new PersonModel("Jacqueline Mars", "7700560450", R.drawable.women_contact));
        personModelList.add(new PersonModel("Warren Buffett", "8622144478", R.drawable.men_contact));

    }

    public void setRecyclerView() {
        PersonAdapter adapter = new PersonAdapter(personModelList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(PersonModel model) {
        
        String number = model.getTvPNumber().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: "+ number ));
        startActivity(intent);
    }
}