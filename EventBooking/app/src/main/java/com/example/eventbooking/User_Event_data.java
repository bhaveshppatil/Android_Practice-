package com.example.eventbooking;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class User_Event_data extends AppCompatActivity {

    private TextView tvUserFName, tvUserLName, tvUserEmail, tvUserNumber, tvUserNoOfSeat, tvUserDateOfShow;
    private Button btnConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__event_data);
        initView();

        String FName = DataSaver.getString("FirstName");
        tvUserFName.setText("First Name: " + FName);
        String lName = DataSaver.getString("LastName");
        tvUserLName.setText("Last Name: " + lName);
        String email = DataSaver.getString("email");
        tvUserEmail.setText("Email Id: " + email);
        String number = DataSaver.getString("number");
        tvUserNumber.setText("Phone Number: " + number + "");
        int noOfSeat = DataSaver.getInt("NoOfSeat");
        tvUserNoOfSeat.setText("Seat: " + noOfSeat + "");
        String date = DataSaver.getString("Date");
        tvUserDateOfShow.setText("Event Date: " + date + " ");

        btnConfirm = findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(User_Event_data.this);
                alertDialog.setTitle("Confirm Event ");
                alertDialog.setMessage("Once Check Event information and Click Confirm");
                alertDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(User_Event_data.this, "Event registered Successfully on " + date, Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog.show();
            }
        });


    }

    private void initView() {
        tvUserFName = findViewById(R.id.tvUserFName);
        tvUserLName = findViewById(R.id.tvUserLName);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        tvUserNumber = findViewById(R.id.tvUserNumber);
        tvUserDateOfShow = findViewById(R.id.tvUserDateOfShow);
        tvUserNoOfSeat = findViewById(R.id.tvUserNoOfSeat);
        DataSaver.getInstance(this);
    }
}