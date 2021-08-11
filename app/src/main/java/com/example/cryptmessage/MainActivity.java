package com.example.cryptmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link both the button variables with its id
        Button encryptionButton = findViewById(R.id.encryptButton);
        Button decryptionButton = findViewById(R.id.decryptButton);

        // onClick function for encryption
        encryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent function to move to another activity
                Intent intent = new Intent(getApplicationContext(), Encoder.class);
                startActivity(intent);
            }
        });

        // onClick function for decryption
        decryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Decoder.class);
                startActivity(intent);
            }
        });

    }
}