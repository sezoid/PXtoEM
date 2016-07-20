package ru.sezex.pxtoem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    double a, b, c;
    EditText BASE;
    EditText PX;
    ListView HISTORY;
    final ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getSupportActionBar().setElevation(0);

        BASE = (EditText) findViewById(R.id.base);
        PX = (EditText) findViewById(R.id.px);
        HISTORY = (ListView) findViewById(R.id.historyListView);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        HISTORY.setAdapter(adapter);

        final Button ConvertButton = (Button) findViewById(R.id.ConvertButton);
        if (ConvertButton != null) {
            ConvertButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    try {
                        a = Double.parseDouble(PX.getText().toString());
                        b = Double.parseDouble(BASE.getText().toString());

                    } catch (NumberFormatException e) {
                        a = 0;
                        b = 0;
                    }

                    if (BASE.getText().toString().equals("")
                            && PX.getText().toString().length() > 0) {
                        Toast ERROR = Toast.makeText(getApplication(),
                                R.string.error, Toast.LENGTH_LONG);
                        ERROR.show();
                    } else if (PX.getText().toString().equals("")
                            && BASE.getText().toString().length() > 0) {
                        Toast ERROR2 = Toast.makeText(getApplication(),
                                R.string.error2, Toast.LENGTH_LONG);
                        ERROR2.show();
                    } else if (BASE.getText().toString().equals("")
                            && PX.getText().toString().equals("")) {
                        Toast ERROR3 = Toast.makeText(getApplication(),
                                R.string.error3, Toast.LENGTH_LONG);
                        ERROR3.show();
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
        }

        final Button CleanButton = (Button) findViewById(R.id.CleanButton);
        if (CleanButton != null) {
            CleanButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    PX.setText("");
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.remove_history) {
            if (list.isEmpty()) {
                Toast ERROR4 = Toast.makeText(getApplication(),
                        R.string.error4, Toast.LENGTH_LONG);
                ERROR4.show();
            } else {
                list.clear();
                adapter.notifyDataSetChanged();
            }
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
                                            Intent.ACTION_VIEW, Uri
                                            .parse("http://sezex.ru/works/pxtoem/"));
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
