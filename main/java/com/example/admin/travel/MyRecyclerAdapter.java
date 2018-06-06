package com.example.admin.travel;

/**
 * Created by Sharu on 26/3/2016.
 */
import com.android.volley.toolbox.NetworkImageView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ListRowViewHolder>{
    private List<ListItems> listItemsList;
    private Context mContext;
    private ImageLoader mImageLoader;

    private int focusedItem = 0;
    private int previousPosition=0;


    public MyRecyclerAdapter(Context context, List<ListItems> listItemsList) {
        this.listItemsList = listItemsList;
        this.mContext = context;
    }

    @Override
    public ListRowViewHolder onCreateViewHolder(ViewGroup viewGroup, final int position) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, null);
        ListRowViewHolder holder = new ListRowViewHolder(v, mContext);


        return holder;
    }


    @Override
    public void onBindViewHolder(final ListRowViewHolder listRowViewHolder, int position) {
        ListItems listItems = listItemsList.get(position);
        listRowViewHolder.itemView.setSelected(focusedItem == position);

        listRowViewHolder.getLayoutPosition();

        mImageLoader = MySingleton.getInstance(mContext).getImageLoader();

        listRowViewHolder.thumbnail.setImageUrl(listItems.getProfilePic(), mImageLoader);
        listRowViewHolder.thumbnail.setDefaultImageResId(R.mipmap.ic_launcher);

        listRowViewHolder.title.setText(Html.fromHtml(listItems.getName()));
        if(position>previousPosition)
        {
            animate(listRowViewHolder,true);
        }
        else{
            animate(listRowViewHolder, false);
        }
        previousPosition=position;


    }

    public void clearAdapter() {
        listItemsList.clear();
        notifyDataSetChanged();
    }

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {



        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(holder.itemView, "scaleY", 0.5F, 0.8F, 1.0F);
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown == true ? 300 : -300, 0);
        animatorSet.playTogether( animatorTranslateY, animatorScaleY);
        animatorSet.setInterpolator(new AnticipateInterpolator());
        animatorSet.setDuration(1000);
        animatorSet.start();

    }
    @Override
    public int getItemCount() {
        return (null != listItemsList ? listItemsList.size() : 0);
    }


    public class ListRowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected NetworkImageView thumbnail;
        protected TextView title;
        protected RelativeLayout recLayout;

        protected LayoutInflater inflater;


        public ListRowViewHolder(View view, Context context) {
            super(view);
            inflater = LayoutInflater.from(mContext);
            this.thumbnail = (NetworkImageView) view.findViewById(R.id.profilePic);
            this.title = (TextView) view.findViewById(R.id.name);

            this.recLayout = (RelativeLayout) view.findViewById(R.id.recLayout);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Intent intent;


            intent = new Intent(mContext, NineActivity.class);
            mContext.startActivity(intent);
            Bundle bundle=new Bundle();
            bundle.putInt("valu",getPosition());
            intent.putExtras(bundle);

            mContext.startActivity(intent);

        }
    }


}
