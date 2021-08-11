package com.example.cryptmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Decoder extends AppCompatActivity {

    EditText decoderEditText;
    TextView decoderTextView;
    ClipboardManager clipboardManager;
    Button decoderEncryptButton;
    Button decoderCopyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);

        // link the edittext and textview with its id
        decoderEditText = findViewById(R.id.decryptEditText);
        decoderTextView = findViewById(R.id.decryptTextView);
        decoderEncryptButton = findViewById(R.id.decryptBtn);
        decoderCopyButton = findViewById(R.id.decryptCopyBtn);

        // create a clipboard manager variable to copy text
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        decoderEncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decryption(view);
            }
        });

        decoderCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copyFunction(view);
            }
        });
    }

    public void decryption(View view){
        // get code from edittext
        String editTextTemp = decoderEditText.getText().toString();
        Log.e("decryption", "text - " + editTextTemp);

        // pass the string to the decryption algorithm
        // and get the decrypted text
        String decryptedString = Decode.decode(editTextTemp);

        // set the text to the edit text for display
        decoderTextView.setText(decryptedString);
        Log.e("decryption", "text - " + decryptedString);
    }

    public void copyFunction(View view){

        // get the string from the textview and trim all spaces
        String data = decoderTextView.getText().toString().trim();

        // check if the textview is not empty
        if(!data.isEmpty()){

            // copy the text in the clip board
            ClipData temp = ClipData.newPlainText("text", data);

            // display message that the text has been copied
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }
    }

}