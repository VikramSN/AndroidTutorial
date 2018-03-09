package com.example.niitandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView lv;
	String chname[] = { "Introduction", "Installation", "Emulator","Hello World", "Toast",
			"Intent", "Internal Storage", "External Storage", "SQlite Database","SharePreference","Service","Broadcast Receiver","Menus","Notification"};

	int img [] ={R.drawable.i,R.drawable.i,R.drawable.e,R.drawable.h,R.drawable.t,
			R.drawable.i,R.drawable.i,R.drawable.e,R.drawable.s,R.drawable.p,R.drawable.s,R.drawable.b,R.drawable.m,R.drawable.n};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.tutList);
		
		Adapter a = new Adapter(this,chname, img);
		lv.setAdapter(a);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> av, View v, int position,
					long ll) {
				if (position == 0) {

					Intent i = new Intent(MainActivity.this, Introduction.class);
					startActivity(i);
				} else if (position == 1) {

					Intent i = new Intent(MainActivity.this, Installation.class);
					startActivity(i);
				} else if (position == 2) {

					Intent i = new Intent(MainActivity.this, Emu.class);
					startActivity(i);
				}else if (position == 3) {

					Intent i = new Intent(MainActivity.this, HelloWorld.class);
					startActivity(i);
				}
				else if (position == 4) {

					Intent i = new Intent(MainActivity.this, ToastEx.class);
					startActivity(i);
				} else if (position == 5) {

					Intent i = new Intent(MainActivity.this, IntentEx.class);
					startActivity(i);
				} else if (position == 6) {

					Intent i = new Intent(MainActivity.this,
							InternalStorageEx.class);
					startActivity(i);
				} else if (position == 7) {

					Intent i = new Intent(MainActivity.this,
							ExternalStorageEx.class);
					startActivity(i);
				} else if(position==8) {
					Intent i = new Intent(MainActivity.this,
							SqliteEx.class);
					startActivity(i);
				} else if(position==9) {
					Intent i = new Intent(MainActivity.this,
							SharePreferenceEx.class);
					startActivity(i);
				} else if(position==10) {
					Intent i = new Intent(MainActivity.this,
							ServiceEx.class);
					startActivity(i);
				} else if(position==11) {
					Intent i = new Intent(MainActivity.this,
							Broadcast_Recever.class);
					startActivity(i);
				} else if(position==12) {
					Intent i = new Intent(MainActivity.this,
							Menus.class);
					startActivity(i);
				} else if(position==13) {
					Intent i = new Intent(MainActivity.this,Notify.class);
					startActivity(i);
				}
			}
		});

	}

}


class Adapter extends ArrayAdapter<String> {
 Context context;
 String [] chname;
 int [] img;
	
	public Adapter(Context context,String [] chname,int [] img) {
		super(context,R.layout.custlist,R.id.custText,chname);
		this.context=context;
		this.chname=chname;
		this.img=img;
}

	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView=inflater.inflate(R.layout.custlist,parent,false);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.custText);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.custImg);
		txtTitle.setTextColor(Color.WHITE);
		txtTitle.setText(chname[position]);
		imageView.setImageResource(img[position]);
		return rowView;
		}
	
}




