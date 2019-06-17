package com.learnque.my.stories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPeopleAdapter extends RecyclerView.Adapter<ListPeopleAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<People> peopleList;

    public ArrayList<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(ArrayList<People> peopleList) {
        this.peopleList = peopleList;
    }

    public ListPeopleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_stories, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getPeopleList().get(position).getName());
        categoryViewHolder.tvQuote.setText(getPeopleList().get(position).getQuote());

        Glide.with(context)
                .load(getPeopleList().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return this.getPeopleList().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvQuote;
        ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvQuote = itemView.findViewById(R.id.tv_item_quote);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
