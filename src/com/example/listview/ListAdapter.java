package com.example.listview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	ArrayList<Cliente> result;    
	Context context;
	private static LayoutInflater inflater=null;



	public ListAdapter(listClientes context, ArrayList<Cliente> lista) {
		super();
		result=lista;


		this.context=context;


		inflater = ( LayoutInflater )context.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		//notifyDataSetChanged();

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


	}

//	@SuppressLint({ "InflateParams", "ViewHolder" })
	@Override
	public View getView(final int position, View view, ViewGroup arg2) {

		final Holder holder=new Holder();
		View rowView;       
		rowView = inflater.inflate(R.layout.listview_each_item, null);
		holder.tv=(TextView) rowView.findViewById(R.id.textViewNome);
		holder.tv2=(TextView) rowView.findViewById(R.id.textViewTelefone);




		holder.tv.setText(result.get(position).getNome());
		holder.tv2.setText(result.get(position).getTelefone());





		return rowView;


	}

}
