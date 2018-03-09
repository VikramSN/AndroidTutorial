package com.example.niitandroid;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqDemo extends Activity {

	EditText name, email, mobile, pass;
	Button savedb, showdb;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sq_demo);
		name = (EditText) findViewById(R.id.nameSq);
		email = (EditText) findViewById(R.id.emailSq);
		mobile = (EditText) findViewById(R.id.mobileSq);
		pass = (EditText) findViewById(R.id.passSq);
		savedb = (Button) findViewById(R.id.SqSavebtn);
		showdb = (Button) findViewById(R.id.SqShowbtn);

		savedb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String uname = name.getText().toString(), uemail = email
						.getText().toString(), umobile = mobile.getText()
						.toString(), upass = pass.getText().toString();

				db = openOrCreateDatabase("SQLiteData", Context.MODE_PRIVATE,
						null);
				db.execSQL("CREATE TABLE IF NOT EXISTS userdata(name varchar,email varchar,mobile number,password varchar);");
				db.execSQL("INSERT INTO userdata(name,email,mobile,password)VALUES('"
						+ uname
						+ "','"
						+ uemail
						+ "','"
						+ umobile
						+ "','"
						+ upass + "');");
	            Toast.makeText(SqDemo.this.getApplicationContext(),"Data Inserted Successfully",Toast.LENGTH_SHORT).show();

			}
		});

		
		
		showdb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				Cursor obj= db.query("userdata", null, null, null, null, null, null);
				if(obj.moveToFirst())
				{
					while(obj.isAfterLast()==false)
					{
						Toast.makeText(getApplicationContext(),"Data\n=====\nName : "+obj.getString(0), Toast.LENGTH_SHORT).show();
						obj.moveToNext();	
					}
				}
				obj.close();
					}
		});

	}
}
