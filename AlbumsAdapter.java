package com.fasttech.music;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dell on 7/17/2017.
 */

class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder>  {
    ArrayList<Albums> albumsArrayList;
    Context context;
    int previousPosition=0;


    public AlbumsAdapter(ArrayList<Albums> albumsArrayList,Context context) {
        this.albumsArrayList = albumsArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_albums,parent,false);
        ViewHolder vh = new ViewHolder(view,context,albumsArrayList);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Albums albums = albumsArrayList.get(position);
        holder.textView.setText(albums.getAlbumname());
        holder.imageView.setBackgroundResource(albums.getIcon());

        if(position > previousPosition){
            AnimationsUtil.animate(holder,true); //MOVING DOWNWARDS

        }else{
            AnimationsUtil.animate(holder,false);  //MOVING UPWARDS
        }
        previousPosition = position;
    }

    @Override
    public int getItemCount() {
        return albumsArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        ArrayList<Albums> albumsArrayList = new ArrayList<>();
        Context context;
        public ViewHolder(View itemView,Context context,ArrayList<Albums>albumsArrayList) {
            super(itemView);
            this.context = context;
            this.albumsArrayList = albumsArrayList;
            itemView.setOnClickListener(this);
            imageView = (ImageView)itemView.findViewById(R.id.albumsimage);
            textView = (TextView)itemView.findViewById(R.id.albumstext);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Albums albums = this.albumsArrayList.get(position);
            Intent intent = new Intent(this.context,AlbumsOpenActivity.class);
            intent.putExtra("KeyImg",albums.getIcon());
            intent.putExtra("KeyName",albums.getAlbumname());
            this.context.startActivity(intent);

        }
    }
}
