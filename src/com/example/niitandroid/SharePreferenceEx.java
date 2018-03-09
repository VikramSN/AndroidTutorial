package com.example.niitandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SharePreferenceEx extends Activity {
	Button demosp, sourcesp;
	String red = "#DB7F7C", blue = "#5073A7", brown = "#A77450",
			green = "#51A750", pink = "#A7509F", face = "#F3EBAB",
			black = "#000000", orange = "#F07637", gray = "#BCB7B5",
			white = "#ffffff";
	CharSequence[] colors = { "RED", "BLUE", "BROWN", "GREEN", "PINK", "FACE",
			"BLACK", "ORANGE", "GRAY", "WHITE" };

	RelativeLayout rl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_preference);

		demosp = (Button) findViewById(R.id.sPreDemo);
		sourcesp = (Button) findViewById(R.id.sPreSource);
		rl = (RelativeLayout) findViewById(R.id.rootbb);

		demosp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				SharedPreferences sp = getSharedPreferences("MyPreference",
						MODE_PRIVATE);
				SharedPreferences.Editor e = sp.edit();
				e.putString("red", red).putString("blue", blue)
						.putString("brown", brown).putString("green", green)
						.putString("pink", pink).putString("face", face)
						.putString("black", black).putString("orange", orange)
						.putString("gray", gray).putString("white", white);
				e.commit();

				AlertDialog.Builder ab = new AlertDialog.Builder(
						SharePreferenceEx.this);
				ab.setTitle("Select One Color");
				ab.setSingleChoiceItems(colors, -1,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface di, int pos) {
								if (pos == 0) {
									rl.setBackgroundColor(Color.parseColor(red));
								} else if (pos == 1) {
									rl.setBackgroundColor(Color.parseColor(blue));
								} else if (pos == 2) {
									rl.setBackgroundColor(Color.parseColor(brown));
								} else if (pos == 3) {
									rl.setBackgroundColor(Color.parseColor(green));
								} else if (pos == 4) {
									rl.setBackgroundColor(Color.parseColor(pink));
								} else if (pos == 5) {
									rl.setBackgroundColor(Color.parseColor(face));
								} else if (pos == 6) {
									rl.setBackgroundColor(Color.parseColor(black));
								} else if (pos == 7) {
									rl.setBackgroundColor(Color.parseColor(orange));
								} else if (pos == 8) {
									rl.setBackgroundColor(Color.parseColor(gray));
								} else if (pos == 9) {
									rl.setBackgroundColor(Color.parseColor(white));
								}
							di.dismiss();
							}
						});
				AlertDialog alertDialog = ab.create();
				alertDialog.show();
			}
		});

		sourcesp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(SharePreferenceEx.this,SpSource.class);
				startActivity(i);
				
			}
		});

	}

}
