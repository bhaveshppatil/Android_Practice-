package com.example.recyclerview3_we;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {

    private ArrayList<Model> modelArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EditText etName, etAge, etAddress;
    private CardView cardView;
    private Button btnDone;
    private Adapter adapter;
    private ImageView imgEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rclView);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        btnDone = findViewById(R.id.btnDone);
        cardView = findViewById(R.id.editCrdView);
        imgEdit = findViewById(R.id.imgEdit);
        buildModelList();
        setRecyclerView();

    }

    private void setRecyclerView() {
        adapter = new Adapter(modelArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void buildModelList() {
       modelArrayList.add(new Model("Bhavesh", 21, "Panvel, Navi-Mumbai, Maharashtra, 400702"));
        modelArrayList.add(new Model("Ajay", 23, "Vashi, Navi-Mumbai, Maharashtra, 410206"));
        modelArrayList.add(new Model("Mayur", 22, "Kharghar, Navi-Mumbai, Maharashtra, 200701"));
        modelArrayList.add(new Model("Rutuja", 20, "Nerul, Navi-Mumbai, Maharashtra, 300389"));
        modelArrayList.add(new Model("Dolly", 21, "Thane, Navi-Mumbai, Maharashtra, 510702"));
    }

    @Override
    public void onItemClick(int position, Model model) {
        cardView.setVisibility(View.VISIBLE);
        etName.setText(model.getName());
        etAge.setText(model.getAge() + "");
        etAddress.setText(model.getAddress());

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.setVisibility(View.VISIBLE);
                Model newModel = new Model(etName.getText().toString(),
                        Integer.parseInt(etAge.getText().toString()),
                        etAddress.getText().toString());
                modelArrayList.set(position, newModel);
                adapter.notifyItemChanged(position);
                cardView.setVisibility(View.GONE);
            }
        });
    }
}