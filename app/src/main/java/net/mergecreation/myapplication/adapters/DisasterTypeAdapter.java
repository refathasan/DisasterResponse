package net.mergecreation.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.mergecreation.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DisasterTypeAdapter extends RecyclerView.Adapter<DisasterTypeAdapter.DisasterView> {
    List<Integer> imageList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    private OnItemListener onItemListener;
    public DisasterTypeAdapter(List<Integer> imageList, List<String> nameList,OnItemListener onItemListener) {
        this.imageList = imageList;
        this.nameList = nameList;
        this.onItemListener=onItemListener;

    }

    @NonNull
    @Override
    public DisasterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_disaster, parent, false);
        return new DisasterView(view,onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DisasterView holder, int position) {
        holder.imageOfDisaster.setImageResource(imageList.get(position));
        holder.textOfDisaster.setText(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class DisasterView extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageOfDisaster;
        TextView textOfDisaster;
        OnItemListener onItemListener;

        public DisasterView(@NonNull View itemView,OnItemListener onItemListener) {
            super(itemView);
            imageOfDisaster = (ImageView) itemView.findViewById(R.id.im_disaster_image);
            textOfDisaster = (TextView) itemView.findViewById(R.id.tv_disaster_name);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener {
        void onItemClick(int position);
    }
}
