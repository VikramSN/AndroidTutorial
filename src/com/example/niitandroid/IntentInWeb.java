package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class IntentInWeb extends Activity {

	WebView inw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_in_web);
		inw = (WebView) findViewById(R.id.intInWeb);

		WebSettings webSetting = inw.getSettings();
		webSetting.setBuiltInZoomControls(true);
		inw.setWebViewClient(new WebViewClient());
		inw.loadUrl("file:///android_asset/IntentImSource.html");
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	}

}
