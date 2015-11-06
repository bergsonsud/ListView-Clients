package adapters;

import java.util.ArrayList;

import com.example.listview.R;

import activities.ChamadoActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import entidades.Chamado;

@SuppressLint("InflateParams") public class ChamadoAdapter extends BaseAdapter {

	ArrayList<Chamado> result;    
	Context context;
	private static LayoutInflater inflater=null;



	public ChamadoAdapter(ChamadoActivity context, ArrayList<Chamado> lista) {
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
		Button status;
		Button urgencia;
		ImageButton delete;

	}
	

	@SuppressLint("ViewHolder") @Override
	public View getView(final int position, View view, ViewGroup arg2) {

		final Holder holder=new Holder();
		View rowView;       
		rowView = inflater.inflate(R.layout.chamado_each_item, null);
		
		holder.tv=(TextView) rowView.findViewById(R.id.textViewCliente);
		holder.status=(Button) rowView.findViewById(R.id.Status);
		holder.urgencia=(Button) rowView.findViewById(R.id.Urgencia);
		holder.delete = (ImageButton) rowView.findViewById(R.id.delete);		

		holder.tv.setText(result.get(position).getCliente());
		holder.status.setText(result.get(position).getStatus());
		holder.urgencia.setText(result.get(position).getUrgencia());
		holder.urgencia.setBackgroundColor(Color.RED);


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
	

				// Show The Dialog with Selected Client
				AlertDialog dialog = new AlertDialog.Builder(context).create();
				dialog.setTitle(nome);
				dialog.setIcon(android.R.drawable.ic_dialog_info);

				dialog.setMessage("");
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
