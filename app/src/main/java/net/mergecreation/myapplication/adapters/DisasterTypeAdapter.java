package net.mergecreation.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.mergecreation.myapplication.R;

public class DisasterTypeAdapter extends RecyclerView.Adapter<DisasterTypeAdapter.DisasterView> {

    @NonNull
    @Override
    public DisasterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_disaster,parent,false);
        return new DisasterView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisasterView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DisasterView extends RecyclerView.ViewHolder{

        public DisasterView(@NonNull View itemView) {
            super(itemView);
        }
    }
}
