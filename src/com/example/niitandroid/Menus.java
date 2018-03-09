package com.example.niitandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Menus extends Activity {
	Button cont, pop, source;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menus);
		cont = (Button) findViewById(R.id.contMenu);
		pop = (Button) findViewById(R.id.popMenu);

		source = (Button) findViewById(R.id.sourceMenu);
		source.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

			}
		});

		cont.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View vv) {
				registerForContextMenu(vv);
			}
		});

		pop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				PopupMenu ppm = new PopupMenu(Menus.this, v);
				MenuInflater mi = ppm.getMenuInflater();
				mi.inflate(R.menu.menus, ppm.getMenu());
				ppm.show();

				ppm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {

						switch (item.getItemId()) {
						case R.id.firetoast:
							Toast.makeText(getApplicationContext(),
									"Open Toast via Menu", Toast.LENGTH_SHORT)
									.show();
							break;

						case R.id.close:
							finish();
							break;
						}
						return false;
					}
				});
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menus, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.firetoast:
			Toast.makeText(getApplicationContext(), "Open Toast via Menu",
					Toast.LENGTH_SHORT).show();
			break;

		case R.id.close:
			finish();
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.menus, menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.firetoast:
			Toast.makeText(getApplicationContext(), "Open Toast via Menu",
					Toast.LENGTH_SHORT).show();
			break;

		case R.id.close:
			finish();
			break;
		}
		return super.onContextItemSelected(item);
	}

}
