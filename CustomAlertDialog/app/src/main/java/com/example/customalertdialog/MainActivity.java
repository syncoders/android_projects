package com.example.customalertdialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li1 = LayoutInflater.from(MainActivity.this);
                View promptsView1 = li1.inflate(R.layout.custom_dialog_layout, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(promptsView1);
                Button cancel = (Button) promptsView1.findViewById(R.id.odo_cancel);
                Button next = (Button) promptsView1.findViewById(R.id.odo_next);
                final EditText userInputname = (EditText) promptsView1.findViewById(R.id.editTextDialogUserInput);
                final EditText userInputHMobile = (EditText) promptsView1.findViewById(R.id.editTextUserInputMobile);
                userInputname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (userInputname.getText().toString().length() < 1) {
                            userInputname.setError("Enter Your Name");
                            return;
                        } else userInputHMobile.setEnabled(true);
                    }
                });
                userInputHMobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (userInputname.getText().toString().length() < 1) {
                            userInputname.setError("Enter Mobile Number");
                            userInputname.requestFocus();
                            return;
                        }
                    }
                });
                builder.setCancelable(false);

                final AlertDialog alert = builder.create();
                alert.show();
                Button bq = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
                Button bq1 = alert.getButton(DialogInterface.BUTTON_POSITIVE);
//                Button bq2 = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    bq.setTextColor(getColor(android.R.color.holo_blue_bright));
                    bq1.setTextColor(getColor(android.R.color.holo_blue_bright));
//                    bq2.setTextColor(getColor(android.R.color.holo_blue_bright));
                }

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();
                    }
                });
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Toast.makeText(MapsActivityCustomTask.this,""+userInput.getText(),Toast.LENGTH_SHORT).show();
                        if ((userInputHMobile.getText().toString().length() < 1) || (userInputHMobile.getText().toString().length() < 10)) {
                            userInputHMobile.setError("Enter a valid mobile number");
//                                userInput.requestFocus();
//                                userInputHour.setEnabled(false);
                            return;
                        }
                        if (userInputname.getText().toString().length() < 1) {
                            userInputname.setError("Enter Name");
//                                userInput.requestFocus();
//                                userInputHour.setEnabled(false);
                            return;
                        }
                        if (userInputname.getText().toString().equals("")) {
                            Toast.makeText(MainActivity.this, "Enter a valid name) ", Toast.LENGTH_SHORT).show();
                            return;
//                                            builder.create();
//                                            userInput.requestFocus();
                        }
                        if ((userInputHMobile.getText().toString().length() < 0)) {
                            Toast.makeText(MainActivity.this, "Enter mobile number", Toast.LENGTH_SHORT).show();
                            return;
//                                            builder.create();
//                                            userInput.requestFocus();
                        }
              Toast.makeText(MainActivity.this,"Name: "+userInputname.getText()+"  Mobile: "+userInputHMobile.getText(),Toast.LENGTH_LONG).show();
                        alert.dismiss();
                    }
                });
            }
        });


    }
}