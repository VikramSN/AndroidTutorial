package com.example.niitandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MySS extends Service {
	MediaPlayer mps;
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
	mps= MediaPlayer.create(MySS.this,R.raw.sia);
	mps.setLooping(false);
	Toast.makeText(this, "[Start-Service] Created", Toast.LENGTH_LONG).show();
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		mps.start();
		Toast.makeText(this, "[Start-Service] Started", Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public boolean stopService(Intent name) {
		mps.stop();
		return super.stopService(name);
	}
	
	@Override
	public void onDestroy() {
	mps.stop();
	Toast.makeText(this, "[Start-Service] Stoped", Toast.LENGTH_LONG).show();
		}
	
}
