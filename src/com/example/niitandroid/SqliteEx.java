package com.example.niitandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SqliteEx extends Activity {

	Button demo, source;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_ex);

		demo = (Button) findViewById(R.id.sqDemo);
		source = (Button) findViewById(R.id.sqSource);

		demo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), SqDemo.class);
				startActivity(i);
			}
		});

		source.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(getApplicationContext(),
						SqliteSource.class);
				startActivity(i);
			}
		});

	}

}
