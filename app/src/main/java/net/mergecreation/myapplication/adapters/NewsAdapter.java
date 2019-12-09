package net.mergecreation.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<NewsModel> newsModelList = new ArrayList<>();
    Context context;

    public NewsAdapter(Context context, List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_news,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, int position) {
        NewsModel model = newsModelList.get(position);
        Picasso.get().load(model.getImgUrl()).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
        holder.textView.setText(model.getDescription());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.textView.setMaxLines(100);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imageView);
            textView =itemView.findViewById(R.id.textView);
        }
    }
}
