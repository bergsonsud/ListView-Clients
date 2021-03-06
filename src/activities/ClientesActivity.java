package activities;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.listview.R;

import adapters.ClienteAdapter;
import android.app.Activity;
import android.app.ProgressDialog;
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
	private String urlJsonArry = "http://bergsonlm.com/andro_cli";
	private ProgressDialog pDialog;
	private ArrayList<Cliente> lista = new ArrayList<Cliente>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clientes);
		
		pDialog = new ProgressDialog(this);
		pDialog.setMessage("Please wait...");
		pDialog.setCancelable(false);


		context = this;
		listView=(ListView) findViewById(R.id.listClientes);	
		
	    makeRequest();


	
	}

	
	 
		public void makeRequest() {
		 showpDialog();
		 
		 RequestQueue rq = Volley.newRequestQueue(this);
		 JsonArrayRequest JReq = new JsonArrayRequest(urlJsonArry, 
				 new Response.Listener<JSONArray>() {
	         
             @Override
             public void onResponse(JSONArray response) {
             	                    
                 for (int i = 0; i < response.length(); i++) {
                   try {
                     	JSONObject obj = (JSONObject) response.get(i);                     
                     	String nome = obj.getString("nome");
                     	String telefone = obj.getString("telefone");
                     	String email = obj.getString("email");
 
                     	Cliente cliente = new Cliente(nome,telefone,email);
                     	lista.add(cliente);
                     	
                         
                     } catch (JSONException e) {
                     }
                   
                 }
                               
                 
                 ListAdapter=new ClienteAdapter(ClientesActivity.this,lista);
                 listView.setAdapter(ListAdapter);
                 hidepDialog();
             }

				
         }, new Response.ErrorListener() {
             
             @Override
             public void onErrorResponse(VolleyError error) {
                 // Handle error
  
             }
             
         });
		 
		 rq.add(JReq);
		 
		}
		



		private void showpDialog() {
			if (!pDialog.isShowing())
				pDialog.show();
		}

		private void hidepDialog() {
			if (pDialog.isShowing())
				pDialog.dismiss();
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
