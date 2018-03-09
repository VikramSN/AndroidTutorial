package com.example.niitandroid;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InterDemo extends Activity {

	EditText name, email, mobile, pass;
	Button save, show;
	private String file = "mydata";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inter_demo);
		name = (EditText) findViewById(R.id.nameR);
		email = (EditText) findViewById(R.id.emailR);
		mobile = (EditText) findViewById(R.id.mobileR);
		pass = (EditText) findViewById(R.id.passR);
		save = (Button) findViewById(R.id.Savebtn);
		show = (Button) findViewById(R.id.Showbtn);

		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				String uname = name.getText().toString(), uemail = email
						.getText().toString(), umobile = mobile
						.getText().toString(), upass = pass.getText()
						.toString();
				String dt="\nYour Name : "+uname+"\nYour Email : "+uemail+"\nYour Contact : "+umobile+"\nYour Password : "+upass;
				try {
					FileOutputStream fOut = openFileOutput(file, MODE_PRIVATE);
					fOut.write(dt.getBytes());
					fOut.close();
					Toast.makeText(getBaseContext(), "Data Saved Successfully",
							Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		show.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						InterDemo.this);

				try {
					String temp = "";
					FileInputStream fin = openFileInput(file);
					int c;
					while ((c = fin.read()) != -1) {
						temp = temp + Character.toString((char) c);
						alertDialogBuilder.setMessage("DATA\n===="+temp);
					}
				} catch (Exception e) {
				}
				alertDialogBuilder.setPositiveButton("Ok",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								finish();
							}
						});
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();

			}
		});
	}
}
