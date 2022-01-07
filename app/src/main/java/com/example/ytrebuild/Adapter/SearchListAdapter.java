package com.example.ytrebuild.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ytrebuild.R;
import com.example.ytrebuild.Response.YTSearchResponse;
import com.example.ytrebuild.Response.YTVideoResponse;

import java.util.ArrayList;
import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    Context context;
    List<YTSearchResponse> ytResList = new ArrayList<>();

    public SearchListAdapter(Context context, List<YTSearchResponse> ytResList) {
        this.context = context;
        this.ytResList = ytResList;
    }

    @NonNull
    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.video_id_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListAdapter.ViewHolder holder, int position) {
        holder.vidTitle.setText(ytResList.get(position).getSnippet().getTitle());
        Log.d("TAGT", "onBindViewHolder: "+ytResList.get(position).getSnippet().getTitle());
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
            vidTitle = itemView.findViewById(R.id.videoIdText);
            vidThumb = itemView.findViewById(R.id.thumbImg);
        }
    }
}
