package com.example.niitandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyBS extends Service {
MediaPlayer mp;

public class LocalBinder extends Binder {
    MyBS getService() {
        return MyBS.this;
    }
}

@Override
public void onCreate() {
	Toast.makeText(this, "[Bound-Service] Created", Toast.LENGTH_LONG).show();
	mp= MediaPlayer.create(MyBS.this,R.raw.closer);
	  mp.setLooping(false);	
	  
super.onCreate();
}


@Override
	public IBinder onBind(Intent arg0) {
	Toast.makeText(this, "[Bound-Service] Started", Toast.LENGTH_LONG).show();  
	mp.start();
return null;
	}

	@Override
		public boolean onUnbind(Intent intent) {
		Toast.makeText(this, "[Bind-Service] Stoped", Toast.LENGTH_LONG).show();
		mp.stop();		 
		return super.onUnbind(intent);
		}
}
	


