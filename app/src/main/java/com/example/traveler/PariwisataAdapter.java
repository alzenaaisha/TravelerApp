package com.example.traveler;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.traveler.model.PariwisataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PariwisataAdapter extends RecyclerView.Adapter<PariwisataAdapter.viewHolder> {
    private List<PariwisataModel.Data> data=new ArrayList();
    private TabFragment1 mContext;

    public PariwisataAdapter(TabFragment1 context, List<PariwisataModel.Data> data){
        this.data = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public PariwisataAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PariwisataAdapter.viewHolder holder, int position) {
        PariwisataModel.Data mData=data.get(position);
        holder.namaWisata.setText(mData.getName());
        //glide
        //Glide.with(mContext).load(mData.getThumbnail()).placeholder(R.drawable.loading_image).error(R.drawable.error_image).into(holder.gambarWisata);
        //picasso
        Picasso.get().load(mData.getThumbnail()).resize(1920,1200).placeholder(R.drawable.loading_image).error(R.drawable.error_image).into(holder.gambarWisata);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView gambarWisata;
        TextView namaWisata;

        public viewHolder(View itemView) {
            super(itemView);
            gambarWisata = itemView.findViewById(R.id.gambar_wisata);
            namaWisata = itemView.findViewById(R.id.nama_wisata);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            PariwisataModel.Data mData = data.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext.getContext(), DetailActivity.class);
            detailIntent.putExtra("name", mData.getName());
            detailIntent.putExtra("description", mData.getDescription());
            detailIntent.putExtra("latitude", mData.getLatitude());
            detailIntent.putExtra("longitude", mData.getLongitude());
            detailIntent.putExtra("thumbnail",
                    mData.getThumbnail());
            mContext.startActivity(detailIntent);
        }
    }
    public void setWisata(List<PariwisataModel.Data> wisata){
        data.clear();
        data.addAll(wisata);
        notifyDataSetChanged();
    }
}

