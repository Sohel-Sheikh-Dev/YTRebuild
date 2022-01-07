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
import com.example.ytrebuild.Response.YTVideoResponse;

import java.util.ArrayList;
import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {

    Context context;
    List<YTVideoResponse> ytResList = new ArrayList<>();

    public VideoListAdapter(Context context, List<YTVideoResponse> ytResList) {
        this.context = context;
        this.ytResList = ytResList;
    }

    @NonNull
    @Override
    public VideoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.video_id_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoListAdapter.ViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: "+ytResList.get(position).getSnippet().getTitle());
        holder.vidTitle.setText(ytResList.get(position).getSnippet().getTitle());
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
