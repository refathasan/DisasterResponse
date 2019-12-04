package net.mergecreation.myapplication.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImmergencyPhoneTypeAdapter extends RecyclerView.Adapter<ImmergencyPhoneTypeAdapter.ImmergencyPhoneView> {


    @NonNull
    @Override
    public ImmergencyPhoneView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ImmergencyPhoneView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ImmergencyPhoneView extends RecyclerView.ViewHolder{

        public ImmergencyPhoneView(@NonNull View itemView) {
            super(itemView);
        }
    }
}
