package com.example.niitandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.niitandroid.MyBS.LocalBinder;

public class ServiceEx extends Activity {
	Button start, bound, sourceS;
	MyBS obj1;
	SeekBar seek;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_ex);
		start = (Button) findViewById(R.id.startServiceEX);
		bound = (Button) findViewById(R.id.BoundService);
		sourceS = (Button) findViewById(R.id.SourceService);

		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ProgressDialog pd = new ProgressDialog(ServiceEx.this);
				pd.setTitle("Music Player");
				pd.setIcon(R.drawable.music);
				pd.setMessage("Playing...");
				pd.setCancelable(false);
				pd.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dd, int arg1) {
						dd.cancel();
						stopService(new Intent(getApplicationContext(),MySS.class));
					}
				});
				pd.show();
				
				Intent i = new Intent(ServiceEx.this,MySS.class);
		startService(i);
					}
		});
		bound.setOnClickListener(new my());

		sourceS.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				Intent i = new Intent(ServiceEx.this,ServiceSource.class);
				startActivity(i);
				
			}
		});
	}

	ServiceConnection obj = new ServiceConnection() {
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			
		}

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			LocalBinder lb = (LocalBinder) arg1;
			obj1 = lb.getService();
		}
	};

	class my implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			Intent i = new Intent(ServiceEx.this, MyBS.class);
			bindService(i, obj, Context.BIND_AUTO_CREATE);
			ShowDialog();
		}
	}

	// method for music player=====================================
	public void ShowDialog() {
		AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
		seek = new SeekBar(this);
		seek.setMax(10);
		popDialog.setCancelable(false);

		popDialog.setIcon(R.drawable.music);
		popDialog.setTitle("Music Player");
		popDialog.setView(seek);

		seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean input) {
				Toast.makeText(getApplicationContext(),
						"Playing process..." + progress, Toast.LENGTH_SHORT)
						.show();
			}

			public void onStartTrackingTouch(SeekBar arg0) {
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
			}
		});
		popDialog.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						//Intent i = new Intent(ServiceEx.this, MyBS.class);
						unbindService(obj);
					}
				});
		popDialog.create();
		popDialog.show();

	}
}
