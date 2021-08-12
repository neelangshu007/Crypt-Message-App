package com.example.cryptmessage;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

public class Base64Decode {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String base64Decode(String s){

        // decode into String from encoded format
        byte[] actualByte = Base64.getDecoder().decode(s);

        String actualString =  new String(actualByte);

        // print actual String
        return actualString;
    }

}
