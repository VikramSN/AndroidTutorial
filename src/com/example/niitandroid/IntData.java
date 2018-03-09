package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntData extends Activity {

	TextView data;
	Button goBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_int_data);
	data=(TextView)findViewById(R.id.getData);
	goBack=(Button)findViewById(R.id.goBackII);
	
	Bundle extras = getIntent().getExtras(); 
	String gotData = extras.getString("dataKey");
	data.setText(gotData);
	
	goBack.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		
			Intent i =  new Intent(getApplicationContext(),ImplicitIntent.class);
			startActivity(i);
		}
	});
	
	}

}
