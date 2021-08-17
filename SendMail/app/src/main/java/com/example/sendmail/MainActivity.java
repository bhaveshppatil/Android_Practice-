package com.example.sendmail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etEmailCC, etEmailSub;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etEmailCC = findViewById(R.id.etEmailCC);
        etEmailSub = findViewById(R.id.etEmailSub);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String toEmail = etEmail.getText().toString();
                String ccEmail = etEmailCC.getText().toString();
                String subEmail = etEmailSub.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{toEmail});
                intent.putExtra(Intent.EXTRA_CC, new String[]{ccEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Enter subject");
                intent.putExtra(Intent.EXTRA_TEXT, subEmail);
                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });

    }
}