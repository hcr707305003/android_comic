package com.example.android_comic.plugin.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_comic.R;
import com.example.android_comic.plugin.Bean.ComicWeekBean;

import java.util.ArrayList;
import java.util.List;

/**
 * create by shiroi on 2022/5/17 0017
 */
public class ComicWeekAdapter extends RecyclerView.Adapter<ComicWeekAdapter.MyViewHolder> {

    private List<ComicWeekBean> data = new ArrayList<>();
    private Context context;

    public ComicWeekAdapter(List<ComicWeekBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.comic_week_tag_layout_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerItemClickLister != null) {
                        onRecyclerItemClickLister.onRecyclerItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    private OnRecyclerItemClickLister onRecyclerItemClickLister;

    public void setOnRecyclerItemClickLister(OnRecyclerItemClickLister lister) {
        onRecyclerItemClickLister = lister;
    }

    public interface OnRecyclerItemClickLister {
        void onRecyclerItemClick(int position);
    }
}
