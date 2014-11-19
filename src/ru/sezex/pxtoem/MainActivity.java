package ru.sezex.pxtoem;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	double a, b, c;
	TextView RESULT;
	EditText PX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		getSupportActionBar().setElevation(0);

		RESULT = (TextView) findViewById(R.id.result);
		PX = (EditText) findViewById(R.id.px);

		final Button ConvertButton = (Button) findViewById(R.id.ConvertButton);
		ConvertButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				try {
					a = Double.parseDouble(PX.getText().toString());
					b = 16;

				} catch (NumberFormatException e) {
					a = 0;
					b = 0;
				}

				if (PX.getText().toString().equals("")) {
					RESULT.setTextColor(Color.parseColor("#F44336"));
					RESULT.setText(getString(R.string.error));
				} else {
					c = a / b;
					java.math.BigDecimal x = new java.math.BigDecimal(c);
					x = x.setScale(3, java.math.BigDecimal.ROUND_HALF_UP);
					RESULT.setTextColor(Color.parseColor("#4285F4"));
					RESULT.setText(getString(R.string.res) + " " + x + "em");
				}
			}

		});

		final Button CleanButton = (Button) findViewById(R.id.CleanButton);
		CleanButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				PX.setText("");
				RESULT.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.table) {
			Intent tobase = new Intent(MainActivity.this, TableActivity.class);
			startActivity(tobase);
		}
		if (id == R.id.info) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					MainActivity.this);
			builder.setTitle(R.string.app_name).setMessage(R.string.info)
					.setCancelable(true);
			AlertDialog Info = builder.create();
			Info.show();
		}
		return super.onOptionsItemSelected(item);
	}

}