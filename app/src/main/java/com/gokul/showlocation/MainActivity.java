package com.gokul.showlocation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText mobile;
    Button next;
    String number;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobile = findViewById(R.id.etMobileNumber);
        next = findViewById(R.id.btnNext);

        mAuth = FirebaseAuth.getInstance();


            next.setOnClickListener(v -> {
                String number = mobile.getText().toString().trim();
                if (number.isEmpty() || mobile.length() < 10) {
                    mobile.setError("Enter a valid mobile");
                    mobile.requestFocus();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, VerifyActivity.class);
                intent.putExtra("mobile", number);
                startActivity(intent);

            });



    }


}