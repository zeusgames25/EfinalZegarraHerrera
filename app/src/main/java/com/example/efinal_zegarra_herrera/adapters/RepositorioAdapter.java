package com.example.efinal_zegarra_herrera.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.efinal_zegarra_herrera.Clases.Cuenta;
import com.example.efinal_zegarra_herrera.R;

import java.util.List;

public class RepositorioAdapter extends RecyclerView.Adapter<RepositorioAdapter.NameViewHolder>{

    private List<Cuenta> data;

    public RepositorioAdapter(List<Cuenta> data) {
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
        TextView tvId = holder.itemView.findViewById(R.id.tvId);
        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        Cuenta repo = data.get(position);
        tvId.setText(String.valueOf(repo.getNombre()));
        tvName.setText(repo.getMonto());

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
