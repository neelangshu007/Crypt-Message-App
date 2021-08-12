package com.example.cryptmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Changing Status Bar Color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#FF8400"));
        window.setNavigationBarColor(Color.parseColor("#FF8400"));

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