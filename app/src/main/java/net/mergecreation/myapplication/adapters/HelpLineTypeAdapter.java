package net.mergecreation.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.OnItemListener;
import net.mergecreation.myapplication.home_activity.ImportantPhoneNumberActivity;
import net.mergecreation.myapplication.model.HelpLineCategoryTypeModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HelpLineTypeAdapter extends RecyclerView.Adapter<HelpLineTypeAdapter.HelpLineTypeViewHolder> {
    List<HelpLineCategoryTypeModel> helpLineCategoryTypeModelList = new ArrayList<>();
    private Context context;
    private OnItemListener onItemListener;

    public HelpLineTypeAdapter(Context context, List<HelpLineCategoryTypeModel> helpLineCategoryTypeModelList) {
        this.helpLineCategoryTypeModelList = helpLineCategoryTypeModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public HelpLineTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_help_line_type, parent, false);
        return new HelpLineTypeViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpLineTypeViewHolder holder, int position) {
        HelpLineCategoryTypeModel model = helpLineCategoryTypeModelList.get(position);
        // holder.imageView.
        Picasso.get().load(model.getImgUrl()).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
        holder.textView.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        return helpLineCategoryTypeModelList.size();
    }

    public class HelpLineTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public OnItemListener onItemListener;
        public CircleImageView imageView;
        public TextView textView;

        public HelpLineTypeViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tvCategory);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            v.getContext().startActivity(new Intent(v.getContext(), ImportantPhoneNumberActivity.class));
        }
    }
}
