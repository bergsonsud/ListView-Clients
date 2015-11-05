package com.example.listview;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class listClientes extends Activity {

	ListView listView;
	Cursor cursor;
	ListAdapter ListAdapter;
	Context context;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
		listView=(ListView) findViewById(R.id.listViewSMS);	

		final ArrayList<Cliente> lista = new ArrayList<Cliente>();


		lista.add(new Cliente("Bergson", "986225910", "bergsonsud@gmail.com"));
		lista.add(new Cliente("Bruno", null, "brunolima@gmail.com"));
		lista.add(new Cliente("Kamyla", "988998899", "kamila@gmail.com"));
		lista.add(new Cliente("Alana", null, null));
		lista.add(new Cliente("Camila", null, null));



		// Create the Adapter
		ListAdapter=new ListAdapter(this,lista);

		// Set The Adapter to ListView
		listView.setAdapter(ListAdapter);

		// to handle click event on listView item
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
			{

				TextView n=(TextView)v.findViewById(R.id.textViewNome);
				String nome=n.getText().toString();
				String email = lista.get(position).getEmail();
				String telefone = lista.get(position).getTelefone();
				
				
				if (email == null) {
					email = "Email não definido";
				}
				
				if (telefone == null) {
					telefone = "Telefone não definido";
				}



				// Show The Dialog with Selected Client
				AlertDialog dialog = new AlertDialog.Builder(context).create();
				dialog.setTitle(nome);
				dialog.setIcon(android.R.drawable.ic_dialog_info);
				
				dialog.setMessage("Email: "+email+" Telefone: "+telefone);
				dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which)
					{

						dialog.dismiss();
						return;
					}   
				});
				dialog.show();


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
