package activities;

import java.util.ArrayList;

import com.example.listview.R;

import adapters.ClienteAdapter;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import entidades.Cliente;

public class ClientesActivity extends Activity {

	ListView listView;
	Cursor cursor;
	ClienteAdapter ListAdapter;
	Context context;

	final ArrayList<Cliente> lista = new ArrayList<Cliente>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes);

		context = this;
		listView=(ListView) findViewById(R.id.listChamados);	




		lista.add(new Cliente("Bergson", "986225910", "bergsonsud@gmail.com"));
		lista.add(new Cliente("Bruno", null, "brunolima@gmail.com"));
		lista.add(new Cliente("Kamyla", "988998899", "kamila@gmail.com"));
		lista.add(new Cliente("Alana", null, null));
		lista.add(new Cliente("Camila", null, null));



		// Create the Adapter
		ListAdapter=new ClienteAdapter(this,lista);

		// Set The Adapter to ListView
		listView.setAdapter(ListAdapter);

		
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
