package com.example.eventbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView tvFirstName, tvLastName, tvEmail;
    private EditText etNoOfSeat, etDate;
    private Button btnPreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNumberValid()) {
                    DataSaver.editIntToPreference("NoOfSeat", Integer.parseInt(etNoOfSeat.getText().toString()));
                }
                DataSaver.editStringToPreference("Date", etDate.getText().toString());
                Intent intent = new Intent(SecondActivity.this, User_Event_data.class);
                startActivity(intent);
            }
        });

        setUserdata();
    }

    private void initViews() {
        tvFirstName = findViewById(R.id.tvName);
        tvLastName = findViewById(R.id.tvLastName);
        tvEmail = findViewById(R.id.tvEmail);
        etNoOfSeat = findViewById(R.id.etNumOfSeat);
        etDate = findViewById(R.id.etDateOfShow);
        btnPreview = findViewById(R.id.btnPreview);
        DataSaver.getInstance(this);
    }

    private void setUserdata() {
        String firstName = DataSaver.getString("FirstName");
        tvFirstName.setText("First Name: " +firstName);
        String lastName = DataSaver.getString("LastName");
        tvLastName.setText("Last Name: "+lastName);
        String email = DataSaver.getString("email");
        tvEmail.setText("Email id: "+email);
    }

    private boolean isNumberValid() {
        boolean isDataCorrect = false;
        String seat = etNoOfSeat.getText().toString();
        try {
            int seatNum = Integer.parseInt(seat);
            isDataCorrect = true;
        } catch (NumberFormatException e) {
            isDataCorrect = false;
        }
        return isDataCorrect;
    }
}