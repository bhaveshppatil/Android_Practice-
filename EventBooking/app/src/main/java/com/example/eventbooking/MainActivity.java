package com.example.eventbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etEmail, etNumber;
    private Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewInit();
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSaver.editStringToPreference("number", etNumber.getText().toString());
                DataSaver.editStringToPreference("FirstName", etFirstName.getText().toString());
                DataSaver.editStringToPreference("LastName", etLastName.getText().toString());
                DataSaver.editStringToPreference("email", etEmail.getText().toString());
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void viewInit() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etNumber = findViewById(R.id.etNumber);
        btnBook = findViewById(R.id.btnBookEvent);
        DataSaver.getInstance(this);
    }

//    private boolean isNumberValid() {
//        boolean isDataCorrect = false;
//        String data = etNumber.getText().toString();
//        try {
//            int number = Integer.parseInt(data);
//            isDataCorrect = true;
//        } catch (NumberFormatException e) {
//            isDataCorrect = false;
//        }
//        return isDataCorrect;
//    }
}