package com.example.efinal_zegarra_herrera.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.efinal_zegarra_herrera.R;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder>{

    private List<String> data;

    public NameAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name,parent,false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NameViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.tvId);
        String value = data.get(position);
        tv.setText(value);

//        Button clicMensaje = holder.itemView.findViewById(R.id.btnMensaje);
//        clicMensaje.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(),value, Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(holder.itemView.getContext(), MapaActivity.class);
//                intent.putExtra("value",value);
//                holder.itemView.getContext().startActivity(intent);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder{

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
