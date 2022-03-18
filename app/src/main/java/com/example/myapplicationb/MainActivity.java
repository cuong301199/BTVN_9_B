package com.example.myapplicationb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_SEND ="send" ;
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS ="address" ;
    private static final String KEY_PHONE = "phone";

    EditText edt_name,edt_address,edt_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        edt_phone_number = findViewById(R.id.edt_phone_number);
    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ACTION_SEND)){

                String name = intent.getExtras().getString(KEY_NAME);
                String address = intent.getExtras().getString(KEY_ADDRESS);
                String phone = intent.getExtras().getString(KEY_PHONE);

                edt_name.setText(name);
                edt_address.setText(address);
                edt_phone_number.setText(phone);

            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ACTION_SEND);
        registerReceiver(broadcastReceiver,intentFilter);
    }
}