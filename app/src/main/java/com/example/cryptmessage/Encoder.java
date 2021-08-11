package com.example.cryptmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Encoder extends AppCompatActivity {

    EditText encoderEditText;
    TextView encoderTextView;
    ClipboardManager clipboardManager;
    Button encoderEncryptButton;
    Button encoderCopyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);

        // link the edittext and textview with its id
        encoderEditText = findViewById(R.id.encryptEditText);
        encoderTextView = findViewById(R.id.encryptTextView);
        encoderEncryptButton = findViewById(R.id.encryptBtn);
        encoderCopyButton = findViewById(R.id.encryptCopyBtn);

        // create a clipboard manager variable to copy text
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        encoderEncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encryption(view);
            }
        });

        encoderCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copyFunction(view);
            }
        });
    }

    public void encryption(View view){
        // get text from edittext
        String editTextTemp = encoderEditText.getText().toString();

        // pass the string to the encryption
        // algorithm and get the encrypted code
        String encryptedString = Encode.encode(editTextTemp);

        // set the code to the edit text
        encoderTextView.setText(encryptedString);
    }

    public void copyFunction(View view){
        // get the string from the textview and trim all spaces
        String data = encoderTextView.getText().toString().trim();

        // check if the textview is not empty
        if(!data.isEmpty()){

            // copy the text in the clip board
            ClipData temp = ClipData.newPlainText("text", data);
            clipboardManager.setPrimaryClip(temp);

            // display message that the text has been copied
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }
    }

}