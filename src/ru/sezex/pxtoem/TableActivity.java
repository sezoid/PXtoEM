package ru.sezex.pxtoem;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class TableActivity extends ActionBarActivity {

	private WebView tablePX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table);

		getSupportActionBar().setElevation(0);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		tablePX = (WebView) findViewById(R.id.tablePX);
		tablePX.setBackgroundColor(0xfffcfcfc);
		tablePX.loadUrl("file:///android_res/raw/table.html");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
