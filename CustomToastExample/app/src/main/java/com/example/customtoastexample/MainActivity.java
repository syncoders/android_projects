package com.example.customtoastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the custom layout view.
        View toastView = getLayoutInflater().inflate(R.layout.activity_toast_custom_view, null);
        // Initiate the Toast instance.
        Toast toast = new Toast(getApplicationContext());
        // Set custom view in toast.
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.show();
    }
}
