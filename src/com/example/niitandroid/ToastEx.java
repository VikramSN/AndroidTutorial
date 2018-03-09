package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastEx extends Activity {
Button demo,source;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast);
	demo=(Button)findViewById(R.id.demoT);
	source=(Button)findViewById(R.id.sourceT);
	
	demo.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		Toast.makeText(ToastEx.this,"This is a Toast message",Toast.LENGTH_SHORT).show();
			
		}
	});
	
	source.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
		Intent i = new Intent(getApplicationContext(),ToastSourceCode.class);
		startActivity(i);
			
		}
	});
	
	}


}
