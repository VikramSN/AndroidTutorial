package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ToastSourceCode extends Activity {

	WebView sourcefile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast_source_code);
	sourcefile=(WebView)findViewById(R.id.toastSourceWebView);
		WebSettings webSetting = sourcefile.getSettings();
		webSetting.setBuiltInZoomControls(true);
		sourcefile.setWebViewClient(new WebViewClient());
		sourcefile.loadUrl("file:///android_asset/ToastSource.html");
	}

	private class WebViewClient extends android.webkit.WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}
	 }
}
