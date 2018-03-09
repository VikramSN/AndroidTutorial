package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorld extends Activity {
Button demo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_world);
	demo=(Button)findViewById(R.id.demoHW);
	
	demo.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			LayoutInflater li = getLayoutInflater();  
            View layout = li.inflate(R.layout.customtoast_hw,  
              (ViewGroup) findViewById(R.id.custom_toast_layout));
            
            Toast toast = new Toast(getApplicationContext());  
            toast.setDuration(Toast.LENGTH_SHORT);  
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);  
            toast.setView(layout);  
            toast.show(); 
		}
	});
	
	}


}
