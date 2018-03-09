package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityB extends Activity {

	Button goA;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_b);
	goA=(Button)findViewById(R.id.goA);
	
	goA.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(ActivityB.this,ExplicitIntent.class);
			startActivity(i);
			
		}
	});
	
	
	}

}
