package activities;

import java.util.ArrayList;

import com.example.listview.R;

import adapters.ChamadoAdapter;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import entidades.Chamado;

public class ChamadoActivity extends Activity {

	ListView listView;
	Cursor cursor;
	ChamadoAdapter ListAdapter;
	Context context;

	final ArrayList<Chamado> lista = new ArrayList<Chamado>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chamado);

		context = this;
		listView=(ListView) findViewById(R.id.listClientes);	




		lista.add(new Chamado("Ajuste Site","Studio Danilo","1", "2"));
		lista.add(new Chamado("Imagens não aparecem","Fátima Lima", "4", "1"));
	



		// Create the Adapter
		ListAdapter=new ChamadoAdapter(this,lista);

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
