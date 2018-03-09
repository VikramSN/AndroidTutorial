package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BrSource extends Activity {

	WebView brw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_br_source);
	brw=(WebView)findViewById(R.id.brWeb);
	WebSettings webSetting = brw.getSettings();
	webSetting.setBuiltInZoomControls(true);
	brw.setWebViewClient(new WebViewClient());
	brw.loadUrl("file:///android_asset/BrSource.html");
}

private class WebViewClient extends android.webkit.WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return super.shouldOverrideUrlLoading(view, url);
	}
 }
}
