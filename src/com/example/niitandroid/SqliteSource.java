package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SqliteSource extends Activity {

	WebView sqs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_source);
	
	sqs=(WebView)findViewById(R.id.sqSourceWeb);
	
	WebSettings webSetting = sqs.getSettings();
	webSetting.setBuiltInZoomControls(true);
	sqs.setWebViewClient(new WebViewClient());
	sqs.loadUrl("file:///android_asset/SqliteSource.html");
}

private class WebViewClient extends android.webkit.WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return super.shouldOverrideUrlLoading(view, url);
	}	}

}
