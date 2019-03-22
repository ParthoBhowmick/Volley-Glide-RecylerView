package com.example.recyclerview;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.ViewHolder> {

    private ArrayList<String> mImageName = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context context;

    public RecycleviewAdapter(ArrayList<String> imageName, ArrayList<String> images, Context context) {
        mImageName = imageName;
        mImages = images;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item,viewGroup,false);
       
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Glide.with(context)
             .asBitmap()
             .load(mImages.get(i))
             .into(viewHolder.image);

        viewHolder.imageName.setText(mImageName.get(i));


    }

    @Override
    public int getItemCount() {
        return mImageName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.circle_image);
            imageName = itemView.findViewById(R.id.image_name);

        }
    }

}
