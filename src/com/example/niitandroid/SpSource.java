package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SpSource extends Activity {

	WebView SpSource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sp_source);
		SpSource=(WebView)findViewById(R.id.SpWeb);
	WebSettings webSetting = SpSource.getSettings();
	webSetting.setBuiltInZoomControls(true);
	SpSource.setWebViewClient(new WebViewClient());
	SpSource.loadUrl("file:///android_asset/SpSource.html");
}

private class WebViewClient extends android.webkit.WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return super.shouldOverrideUrlLoading(view, url);
	}
	
	
	}
}
