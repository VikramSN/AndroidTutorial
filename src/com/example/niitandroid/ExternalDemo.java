package com.example.niitandroid;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExternalDemo extends Activity {

	EditText name, data;
	Button save, show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_external_demo);

		name = (EditText) findViewById(R.id.exname);
		data = (EditText) findViewById(R.id.exdata);
		save = (Button) findViewById(R.id.exSavebtn);
		show = (Button) findViewById(R.id.exShowbtn);

		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String uname = name.getText().toString(), udata = data
						.getText().toString();

				String bdata = "\n Name : " + uname + "\n Data : " + udata;
				File file;
				FileOutputStream outputStream;
				try {
					file = new File(Environment.getExternalStorageDirectory(),
							"MyCache");

					outputStream = new FileOutputStream(file);
					outputStream.write(bdata.getBytes());
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				Toast.makeText(getApplicationContext(),
						"Data Saved Successfully  ", Toast.LENGTH_LONG).show();
			}
		});

		show.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						ExternalDemo.this);

				StringBuilder text = new StringBuilder();
				try {
					File file = new File(Environment
							.getExternalStorageDirectory().getAbsolutePath(),
							"MyCache");

					BufferedReader reader = new BufferedReader(new FileReader(
							file));
					String line;

					while ((line = reader.readLine()) != null) {
						alertDialogBuilder.setMessage("DATA\n====\n" + text.append(line));
					}
					reader.close();

				} catch (Exception e) {
					e.printStackTrace();
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
