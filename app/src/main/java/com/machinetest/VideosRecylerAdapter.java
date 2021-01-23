package com.machinetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideosRecylerAdapter extends RecyclerView.Adapter<VideosRecylerAdapter.MyViewHolder> {

    Context myContext;

    public VideosRecylerAdapter(Context aContext) {
        this.myContext = aContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_inflate_video_list_item, null);
        VideosRecylerAdapter.MyViewHolder aView = new VideosRecylerAdapter.MyViewHolder(layoutView);
        return aView;
    }

    @Override
    public void onBindViewHolder(@NonNull VideosRecylerAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 11;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView aViewsTXT;

        public MyViewHolder(View itemView) {
            super(itemView);
            aViewsTXT = (TextView) itemView.findViewById(R.id.layout_inflate_video_list_item_TXT_views);
        }
    }

}
