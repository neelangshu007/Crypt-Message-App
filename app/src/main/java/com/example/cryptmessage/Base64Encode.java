package com.example.cryptmessage;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

public class Base64Encode {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String base64Encode(String s){

        // Encode into Base64 format
        String basicBase64FormatString = Base64.getEncoder().encodeToString(s.getBytes());

        return basicBase64FormatString;
    }
}
