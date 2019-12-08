package net.mergecreation.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.model.HelpLineCategoryTypeModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HelpLineCategoryTypeAdapter extends RecyclerView.Adapter<HelpLineCategoryTypeAdapter.HelpLineCategoryTypeViewHolder> {
    List<HelpLineCategoryTypeModel> helpLineCategoryTypeModelList = new ArrayList<>();
    Context context;

    public HelpLineCategoryTypeAdapter(List<HelpLineCategoryTypeModel> helpLineCategoryTypeModelList, Context context) {
        this.helpLineCategoryTypeModelList = helpLineCategoryTypeModelList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_help_line_type,parent,false);
        return new HelpLineCategoryTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpLineCategoryTypeViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HelpLineCategoryTypeModel model = helpLineCategoryTypeModelList.get(position);
        holder.
    }

    @Override
    public int getItemCount() {
        return helpLineCategoryTypeModelList.size();
    }

    public class HelpLineCategoryTypeViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView textView;

        public HelpLineCategoryTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tvCategory);
        }
    }
}
