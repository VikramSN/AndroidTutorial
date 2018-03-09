package com.example.niitandroid;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Emu extends Activity {

	WebView emu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emu);
		emu = (WebView) findViewById(R.id.emuWeb);
		WebSettings webSetting = emu.getSettings();
		webSetting.setBuiltInZoomControls(true);
		emu.setWebViewClient(new WebViewClient());
		emu.loadUrl("file:///android_asset/Emulator.html");
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	}

}
