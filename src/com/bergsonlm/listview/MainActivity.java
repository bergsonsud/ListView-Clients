package com.bergsonlm.listview;

import com.example.listview.R;

import activities.ChamadoActivity;
import activities.ClientesActivity;
import adapters.ClienteAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listView;
	Cursor cursor;
	ClienteAdapter ListAdapter;
	Context context;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ImageButton imgbtnCli = (ImageButton) findViewById(R.id.imgbtnClientes);
		ImageButton imgbtnChamado = (ImageButton) findViewById(R.id.imgbtnChamados);
		
		imgbtnCli.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(MainActivity.this,ClientesActivity.class);
				startActivity(intent);

				
				
			}
		});
		
		imgbtnChamado.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(MainActivity.this,ChamadoActivity.class);
				startActivity(intent);

				
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
