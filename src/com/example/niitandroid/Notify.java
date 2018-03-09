package com.example.niitandroid;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notify extends Activity {

	Button demonoti,sourcenoti;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notify);
	demonoti=(Button)findViewById(R.id.startNotify);
	sourcenoti=(Button)findViewById(R.id.SourceNotify);
	
	
	demonoti.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		
			      NotificationCompat.Builder builder = new NotificationCompat.Builder(Notify.this);
			         builder.setSmallIcon(R.drawable.n);
			         builder.setContentTitle("Notification");
			         builder.setContentText("This is an example of notification");

			      Intent notificationIntent = new Intent(Notify.this, Notify.class);
			      PendingIntent contentIntent = PendingIntent.getActivity(Notify.this, 0, notificationIntent,
			         PendingIntent.FLAG_UPDATE_CURRENT);
			      builder.setContentIntent(contentIntent);

			      // Add as notification
			      NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			      manager.notify(0, builder.build());
			   }
		
	});


	sourcenoti.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
		
			Intent i = new Intent(getApplicationContext(),NotifySourceCode.class);
			startActivity(i);
		}
	});
	}
}
