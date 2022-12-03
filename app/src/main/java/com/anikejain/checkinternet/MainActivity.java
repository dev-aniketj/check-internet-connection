package com.anikejain.checkinternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anikejain.check_connection.InternetConnectivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InternetConnectivity.checkConnectionCloseActivity(this, 1500, "Please check your internet connection");

    }
}