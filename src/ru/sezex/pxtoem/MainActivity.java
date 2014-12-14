package ru.sezex.pxtoem;

import java.util.ArrayList;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	double a, b, c;
	EditText PX;
	ListView HISTORY;
	final ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		getSupportActionBar().setElevation(0);

		PX = (EditText) findViewById(R.id.px);
		HISTORY = (ListView) findViewById(R.id.historyListView);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		HISTORY.setAdapter(adapter);

		PX.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					try {
						a = Double.parseDouble(PX.getText().toString());
						b = 16;

					} catch (NumberFormatException e) {
						a = 0;
						b = 0;
					}

					if (PX.getText().toString().equals("")) {
						Toast ERROR = Toast.makeText(getApplication(),
								R.string.error, Toast.LENGTH_SHORT);
						ERROR.show();
					} else {
						c = a / b;
						java.math.BigDecimal x = new java.math.BigDecimal(c);
						x = x.setScale(3, java.math.BigDecimal.ROUND_HALF_UP);
						list.add(0, PX.getText().toString() + "px " + "= " + x
								+ "em");
						adapter.notifyDataSetChanged();
					}
					handled = true;
				}
				return handled;
			}
		});

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
					Toast ERROR = Toast.makeText(getApplication(),
							R.string.error, Toast.LENGTH_SHORT);
					ERROR.show();
				} else {
					c = a / b;
					java.math.BigDecimal x = new java.math.BigDecimal(c);
					x = x.setScale(3, java.math.BigDecimal.ROUND_HALF_UP);
					list.add(0, PX.getText().toString() + "px " + "= " + x
							+ "em");
					adapter.notifyDataSetChanged();
				}
			}

		});

		final Button CleanButton = (Button) findViewById(R.id.CleanButton);
		CleanButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				PX.setText("");
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
		if (id == R.id.remove_history) {
			list.clear();
			adapter.notifyDataSetChanged();
		}
		if (id == R.id.support) {
			Intent intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("mailto:roman@sezex.ru?subject=PXtoEM"));
			startActivity(intent);
		}
		if (id == R.id.info) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					MainActivity.this);
			builder.setTitle(R.string.app_name)
					.setCancelable(true)
					.setMessage(getString(R.string.info))
					.setPositiveButton(R.string.web,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent intent = new Intent(
											Intent.ACTION_VIEW,
											Uri.parse("http://sezex.ru/pxtoem/"));
									startActivity(intent);
								}
							})
					.setNegativeButton(R.string.source,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent intent = new Intent(
											Intent.ACTION_VIEW,
											Uri.parse("http://github.com/sezoid/PXtoEM/"));
									startActivity(intent);
								}
							});
			AlertDialog Info = builder.create();
			Info.show();
		}
		return super.onOptionsItemSelected(item);
	}

}
