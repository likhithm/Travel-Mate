package com.example.admin.travel;

/**
 * Created by Sharu on 4/4/2016.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.MyViewHolder> {
    private List<Quotes> quotesList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);

        }
    }
    public QuotesAdapter(List<Quotes> quoteList) {
        this.quotesList = quoteList;
    }

    @Override
    public QuotesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_list_row,null);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuotesAdapter.MyViewHolder holder, int position) {
        Quotes qoute = quotesList.get(position);
        holder.title.setText(qoute.getTitle());

    }

    @Override
    public int getItemCount() {
        return quotesList.size();
    }
}
