package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ExSource extends Activity {

	WebView source;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ex_source);
		source = (WebView) findViewById(R.id.exSourceWeb);
		WebSettings webSetting = source.getSettings();
		webSetting.setBuiltInZoomControls(true);
		source.setWebViewClient(new WebViewClient());
		source.loadUrl("file:///android_asset/ExSource.html");
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	}

}
