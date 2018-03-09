package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExplicitIntent extends Activity {

	Button goB;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_explicit_intent);
	
	goB=(Button)findViewById(R.id.goB);
	
	goB.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(ExplicitIntent.this,ActivityB.class);
			startActivity(i);
			
		}
	});
	}


}
