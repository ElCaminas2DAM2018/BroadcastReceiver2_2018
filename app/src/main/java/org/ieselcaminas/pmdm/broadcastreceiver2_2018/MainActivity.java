package org.ieselcaminas.pmdm.broadcastreceiver2_2018;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = null;

        Button bEnable = findViewById(R.id.buttonEnable);
        bEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                MyReceiver receiver = new MyReceiver();
                registerReceiver(receiver, filter);
            }
        });

        Button bDisable = findViewById(R.id.buttonDisable);
        bDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (receiver != null) {
                    unregisterReceiver(receiver);
                }
            }
        });
    }
}
