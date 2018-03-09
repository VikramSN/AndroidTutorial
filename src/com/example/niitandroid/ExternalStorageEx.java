package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExternalStorageEx extends Activity {

	Button xdemo,xsource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_external_storage_ex);
	
	xdemo=(Button)findViewById(R.id.externalStorageDemo);
	xsource=(Button)findViewById(R.id.sourceExternalStorage);
	
	xdemo.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(getApplicationContext(),ExternalDemo.class);
			startActivity(i);
		}
	});

	xsource.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(getApplicationContext(),ExSource.class);
			startActivity(i);
			
		}
	});
	}

}
