package com.example.niitandroid;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ImplicitIntent extends Activity {
	Button call, sms, email, website, map, photo, data, playStore, source;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_implicit_intent);

		call = (Button) findViewById(R.id.phoneCall);
		sms = (Button) findViewById(R.id.sendSMS);
		email = (Button) findViewById(R.id.SendEmail);
		website = (Button) findViewById(R.id.launchWebsite);
		map = (Button) findViewById(R.id.googleMap);
		photo = (Button) findViewById(R.id.capturePhoto);
		data = (Button) findViewById(R.id.shareData);
		playStore = (Button) findViewById(R.id.googlePlayStore);
		source = (Button) findViewById(R.id.sourceCodeImplicitIntent);

		call.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel: 8285198978"));
				startActivity(callIntent);

			}
		});

		sms.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent sendIntent = new Intent(Intent.ACTION_VIEW);
				sendIntent.putExtra("Hii, This is vicky", "Android Lover");
				sendIntent.setType("vnd.android-dir/mms-sms");
				startActivity(sendIntent);

				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage("8285198978", null,
						"this is about of SMS in Android", null, null);

			}
		});

		email.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				String[] TO = { "viki.aryan.negi@gmail.com" };
				String[] CC = { "vikinegi5@gmail.com" };
				Intent emailIntent = new Intent(Intent.ACTION_SEND);

				emailIntent.setData(Uri.parse("mailto:"));
				emailIntent.setType("text/plain");
				emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
				emailIntent.putExtra(Intent.EXTRA_CC, CC);
				emailIntent.putExtra(Intent.EXTRA_SUBJECT,
						"Email by Android Lover");
				emailIntent.putExtra(Intent.EXTRA_TEXT,
						"this is an email via Android");

				try {
					startActivity(Intent.createChooser(emailIntent,
							"Send mail..."));
					finish();

				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(getApplicationContext(),
							"There is no email client installed.",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		website.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				String url = "http://aw-awesome-world.blogspot.in/2017/09/how-to-download-hotspot-for-pc.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);

			}
		});

		map.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				double latitude = 28.568134;
				double longitude = 77.221447;
				String uri = String.format(Locale.ENGLISH, "geo:%f,%f",
						latitude, longitude);
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
				startActivity(intent);
			}
		});
		photo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent cameraIntent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, 1888);
			}
		});
		data.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						IntData.class);
				intent.putExtra("dataKey", "I am Sharing data using Intent");
				startActivity(intent);

			}
		});
		playStore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				final String appPackageName = getPackageName();
				try {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("market://details?id=" + appPackageName)));
				} catch (android.content.ActivityNotFoundException anfe) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri
							.parse("https://play.google.com/store"
									+ appPackageName)));
				}
			}
		});

		source.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(ImplicitIntent.this, IntentInWeb.class);
				startActivity(i);

			}
		});
	}

}
