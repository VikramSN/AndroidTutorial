package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class NotifySourceCode extends Activity {
	WebView sourcefile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notify_source_code);
		sourcefile=(WebView)findViewById(R.id.notifySourceWebView);
		WebSettings webSetting = sourcefile.getSettings();
		webSetting.setBuiltInZoomControls(true);
		sourcefile.setWebViewClient(new WebViewClient());
		sourcefile.loadUrl("file:///android_asset/NotifySource.html");
	}
	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}
	
}}
