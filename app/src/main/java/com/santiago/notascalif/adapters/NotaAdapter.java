package com.santiago.notascalif.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.santiago.notascalif.R;
import com.santiago.notascalif.models.Nota;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder>{

    private List<Nota> notas;

    public NotaAdapter(List<Nota> notas){
        this.notas = notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView date;
        public TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            date = (TextView) itemView.findViewById(R.id.date_text);
            content = (TextView) itemView.findViewById(R.id.content_text);
        }
    }

    @Override
    public NotaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotaAdapter.ViewHolder viewHolder, int position) {
        Nota nota = this.notas.get(position);
        Date d = new Date();
        d.setTime(nota.getDate());
        String date = new SimpleDateFormat("dd/MM/yyyy").format(d);

        viewHolder.title.setText(nota.getTitle());
        viewHolder.date.setText(date);
        viewHolder.content.setText(nota.getContent());
    }

    @Override
    public int getItemCount() {
        return this.notas.size();
    }
}
