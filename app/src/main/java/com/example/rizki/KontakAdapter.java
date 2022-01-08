package com.example.rizki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rizki.R;
import com.example.rizki.database.entitas.Kontak;

import java.util.List;
import java.util.zip.Inflater;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.KontakViewHolder> {
    private List<Kontak> kontakList;
    private Context context;

    public KontakAdapter(List<Kontak> kontakList, Context context) {
        this.kontakList = kontakList;
        this.context = context;
    }

    @NonNull
    @Override
    public KontakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kontak, parent, false);
        return new KontakAdapter.KontakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KontakAdapter.KontakViewHolder holder, int position) {
        holder.tvNama.setText(kontakList.get(position).Nama);
        holder.tvNomor.setText(kontakList.get(position).tlp);
    }

    @Override
    public int getItemCount() {
        return kontakList.size();
    }

    public class KontakViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNomor;

        public KontakViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNomor = itemView.findViewById(R.id.tvNomor);
        }
    }
}
