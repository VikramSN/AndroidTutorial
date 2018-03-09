package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InternalStorageEx extends Activity {
Button demoIS,sourceIS;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_internal_storage_ex);
	demoIS=(Button)findViewById(R.id.internalStorageDemo);
	sourceIS=(Button)findViewById(R.id.sourceInternalStorage);
	
	demoIS.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		Intent i = new Intent(getApplicationContext(),InterDemo.class);
		startActivity(i);
		}
	});
	
	sourceIS.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			Intent i = new Intent(InternalStorageEx.this,InterSource.class);
			startActivity(i);
		}
	});
	
	}

}
