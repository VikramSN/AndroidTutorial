package com.example.niitandroid;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MyBroadcast extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context c, Intent i) {
		Bundle extras = i.getExtras(); 
		String gotData = extras.getString("wfS");
			
		if(gotData.equals("WiFi is ON")) {
		      NotificationCompat.Builder builder = new NotificationCompat.Builder(c)
		         .setSmallIcon(R.drawable.notibr)
		         .setContentTitle("Broadcast Message")
		         .setContentText("Wifi is ON");
		      Bitmap bitmap_image = BitmapFactory.decodeResource(c.getResources(), R.drawable.wfobr);
		        NotificationCompat.BigPictureStyle s = new NotificationCompat.BigPictureStyle().bigPicture(bitmap_image);
		        s.setSummaryText("Wifi is ON");
		        builder.setStyle(s);
		      PendingIntent contentIntent = PendingIntent.getActivity(c, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
		      builder.setContentIntent(contentIntent);

		      NotificationManager manager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
		      manager.notify(0, builder.build());
		}
		else {
			  NotificationCompat.Builder builder = new NotificationCompat.Builder(c)
		         .setSmallIcon(R.drawable.notibr)
		         .setContentTitle("Broadcast Message")
		         .setContentText("Wifi is OFF");
			  Bitmap bitmap_image = BitmapFactory.decodeResource(c.getResources(), R.drawable.wffbr);
		        NotificationCompat.BigPictureStyle s = new NotificationCompat.BigPictureStyle().bigPicture(bitmap_image);
		        s.setSummaryText("Wifi is OFF");
		        builder.setStyle(s);
		        
		      PendingIntent contentIntent = PendingIntent.getActivity(c, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
		      builder.setContentIntent(contentIntent);
		      NotificationManager manager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
		      manager.notify(0, builder.build());

		      

		}
		

		
	}

	
}
