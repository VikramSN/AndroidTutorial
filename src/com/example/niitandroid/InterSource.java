package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class InterSource extends Activity {
	WebView websource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inter_source);
		websource = (WebView) findViewById(R.id.InterWebSource);
		WebSettings webSetting = websource.getSettings();
		webSetting.setBuiltInZoomControls(true);
		websource.setWebViewClient(new WebViewClient());
		websource.loadUrl("file:///android_asset/InterSource.html");
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	}

}
