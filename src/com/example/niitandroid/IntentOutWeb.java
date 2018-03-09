package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class IntentOutWeb extends Activity {

	WebView intOut;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_out_web);

		intOut=(WebView)findViewById(R.id.intOutWeb);
		
		 WebSettings webSetting = intOut.getSettings();
		 webSetting.setBuiltInZoomControls(true);
		 intOut.setWebViewClient(new WebViewClient());
		 intOut.loadUrl("file:///android_asset/IntentSource.html");
		}
		 private class WebViewClient extends android.webkit.WebViewClient
		 {
		 @Override
		 public boolean shouldOverrideUrlLoading(WebView view, String url) 
		 {
		 return super.shouldOverrideUrlLoading(view, url);
		 }
	
	}
}
