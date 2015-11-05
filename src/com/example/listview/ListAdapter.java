package com.example.listview;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

@SuppressLint("InflateParams") public class ListAdapter extends BaseAdapter {

	ArrayList<Cliente> result;    
	Context context;
	private static LayoutInflater inflater=null;



	public ListAdapter(listClientes context, ArrayList<Cliente> lista) {
		super();
		result=lista;


		this.context=context;


		inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		

	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return result.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public class Holder
	{
		TextView tv;
		TextView tv2;
		ImageButton delete;

	}


	@SuppressLint("ViewHolder") @Override
	public View getView(final int position, View view, ViewGroup arg2) {

		final Holder holder=new Holder();
		View rowView;       
		rowView = inflater.inflate(R.layout.listview_each_item, null);
		holder.tv=(TextView) rowView.findViewById(R.id.textViewNome);
		holder.tv2=(TextView) rowView.findViewById(R.id.textViewTelefone);
		holder.delete = (ImageButton) rowView.findViewById(R.id.delete);		

		holder.tv.setText(result.get(position).getNome());
		holder.tv2.setText(result.get(position).getTelefone());
		
		final android.content.DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				 switch (which){
			        case DialogInterface.BUTTON_POSITIVE:
			            result.remove(position);
			            notifyDataSetChanged();
			            break;

			        case DialogInterface.BUTTON_NEGATIVE:
			            //No button clicked
			            break;
			        }
				
			}
		};
		
		holder.delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setMessage("Tem certeza que deseja excluir?").setPositiveButton("Sim", dialogClickListener)
				    .setNegativeButton("Não", dialogClickListener).show();
				
			}
		});

		rowView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				TextView n=(TextView)v.findViewById(R.id.textViewNome);
				String nome=n.getText().toString();
				String email = result.get(position).getEmail();
				String telefone = result.get(position).getTelefone();
				
				
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




		return rowView;


	}

}
