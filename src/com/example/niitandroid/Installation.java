package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Installation extends Activity {

	WebView install;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_installation);
		install = (WebView) findViewById(R.id.installWeb);

		WebSettings webSetting = install.getSettings();
		webSetting.setBuiltInZoomControls(true);
		install.setWebViewClient(new WebViewClient());
		install.loadUrl("file:///android_asset/Installation.html");
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	}

}
