package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Introduction extends Activity {
	WebView intro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduction);
		intro = (WebView) findViewById(R.id.introWeb);
		WebSettings webSetting = intro.getSettings();
		webSetting.setBuiltInZoomControls(true);
		intro.setWebViewClient(new WebViewClient());
		intro.loadUrl("file:///android_asset/IntroAndroid.html");
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	}

}
