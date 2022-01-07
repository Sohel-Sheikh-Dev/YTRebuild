package com.example.ytrebuild.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ytrebuild.R;
import com.example.ytrebuild.Response.YTSearchResponse;

import java.util.ArrayList;
import java.util.List;

public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.ViewHolder> {

    Context context;
    List<YTSearchResponse> ytResList = new ArrayList<>();

    public ShortsAdapter(Context context, List<YTSearchResponse> ytResList) {
        this.context = context;
        this.ytResList = ytResList;
    }

    @NonNull
    @Override
    public ShortsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.shorts_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShortsAdapter.ViewHolder holder, int position) {
        holder.vidTitle.setText(ytResList.get(position).getSnippet().getTitle());
        Log.d("TAG", "onKindViewHolder: "+ytResList.get(position).getSnippet().getThumbnails().getDefault().getUrl());
        Glide.with(context.getApplicationContext()).load(ytResList.get(position).getSnippet().getThumbnails().getHigh().getUrl()).into(holder.vidThumb);

    }

    @Override
    public int getItemCount() {
        return ytResList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView vidTitle;
        ImageView vidThumb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vidTitle = itemView.findViewById(R.id.shortTitile);
            vidThumb = itemView.findViewById(R.id.shortThumb);
        }
    }
}
