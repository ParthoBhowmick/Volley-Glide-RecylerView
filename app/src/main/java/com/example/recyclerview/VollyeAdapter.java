package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class VollyeAdapter extends RecyclerView.Adapter<VollyeAdapter.ViewHold> {

    private Context mContext;
    private ArrayList<Item> mLists;

    public VollyeAdapter(Context context, ArrayList<Item> list) {
        mContext = context;
        mLists = list;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item, viewGroup, false);
        ViewHold hold = new ViewHold(v);
        return hold;
    }



    @Override
    public void onBindViewHolder(ViewHold viewHold, int i) {

        Item currentItem = mLists.get(i);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikeCount();
        String like = Integer.toString(likeCount);


        Glide.with(mContext)
                .asBitmap()
                .load(imageUrl)
                .into(viewHold.mImageView);

        viewHold.mTextViewCreator.setText(creatorName);
        viewHold.mTextViewLikes.setText(like);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewCreator;
        public  TextView mTextViewLikes;

        public ViewHold(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.likes);
        }
    }

}
