package com.example.traveler;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.traveler.model.PariwisataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PariwisataAdapter extends RecyclerView.Adapter<PariwisataAdapter.viewHolder> {
    private List<PariwisataModel.Wisata> wisata=new ArrayList();
    private TabFragment1 mContext;

    public PariwisataAdapter(TabFragment1 context, List<PariwisataModel.Wisata> wisata){
        this.wisata=wisata;
        this.mContext=context;
    }

    @NonNull
    @Override
    public PariwisataAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PariwisataAdapter.viewHolder holder, int position) {
        PariwisataModel.Wisata mWisata=wisata.get(position);

        holder.namaWisata.setText(mWisata.getNama());
        holder.kategoriWisata.setText(mWisata.getKategori());
        //glide
        //Glide.with(mContext).load(mWisata.getGambar_url()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(holder.gambarWisata);
        //picasso
        Picasso.get().load(mWisata.getGambar_url()).resize(1920,1200).placeholder(R.drawable.loading_image).error(R.drawable.error_image).into(holder.gambarWisata);
    }

    @Override
    public int getItemCount() {
        return wisata.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView gambarWisata;

        TextView namaWisata;
        TextView kategoriWisata;

        public viewHolder(View itemView) {
            super(itemView);
            gambarWisata = itemView.findViewById(R.id.gambar_wisata);

            namaWisata = itemView.findViewById(R.id.nama_wisata);
            kategoriWisata = itemView.findViewById(R.id.kategori_wisata);
        }
    }
    public void setData(List<PariwisataModel.Wisata> data){
        wisata.clear();
        wisata.addAll(data);
        notifyDataSetChanged();
    }
}

