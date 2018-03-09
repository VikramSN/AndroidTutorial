package com.example.niitandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Broadcast_Recever extends Activity {

	Button brSource;
ToggleButton brDemo;
TextView ws;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broadcast__recever);

		brDemo = (ToggleButton) findViewById(R.id.demoBR);
		brSource = (Button) findViewById(R.id.sourceBR);
		ws=(TextView)findViewById(R.id.wifistatusText);
		brDemo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton cb, boolean checked) {
				brDemo.setText("WiFi");
				if (checked) {
					ws.setText("WiFi is ON");
                    ws.setTextColor(Color.GREEN);
                    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);

                    
                } else {
                    ws.setText("WiFi is OFF");
                    ws.setTextColor(Color.RED);
                    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
				
				Intent intent = new Intent(Broadcast_Recever.this,MyBroadcast.class);
				intent.putExtra("wfS", ws.getText().toString().trim());
                sendBroadcast(intent);
			}
		});

		brSource.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(Broadcast_Recever.this, BrSource.class);
				startActivity(i);
			}
		});

	}
}
