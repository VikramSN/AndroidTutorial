package com.example.niitandroid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ServiceSource extends Activity {
WebView wvss;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_source);
	wvss=(WebView)findViewById(R.id.serviceSourceWeb);
	WebSettings webSetting = wvss.getSettings();
	webSetting.setBuiltInZoomControls(true);
	wvss.setWebViewClient(new WebViewClient());
	wvss.loadUrl("file:///android_asset/ServiceSourceCode.html");
}

private class WebViewClient extends android.webkit.WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return super.shouldOverrideUrlLoading(view, url);
	}
}

}
