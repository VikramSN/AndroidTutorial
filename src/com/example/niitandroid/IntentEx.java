package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentEx extends Activity {
Button implicit,explicit,sourceInt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_ex);
	implicit=(Button)findViewById(R.id.imInt);
	explicit=(Button)findViewById(R.id.ExInt);
	sourceInt=(Button)findViewById(R.id.sourceI);

	implicit.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(IntentEx.this,ImplicitIntent.class);
			startActivity(i);
			
		}
	});
	
	explicit.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			Intent i = new Intent(IntentEx.this,ExplicitIntent.class);
			startActivity(i);
			
		}
	});
	
	sourceInt.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			
			Intent i = new Intent(IntentEx.this,IntentOutWeb.class);
			startActivity(i);
			
		}
	});
	
	}

}
