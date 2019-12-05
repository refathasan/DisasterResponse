package net.mergecreation.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import net.mergecreation.myapplication.R;
import net.mergecreation.myapplication.base.OnItemListener;
import net.mergecreation.myapplication.model.HelpLineModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Callback;

public class ImmergencyPhoneTypeAdapter extends RecyclerView.Adapter<ImmergencyPhoneTypeAdapter.ImmergencyPhoneViewHolder> {
    List<HelpLineModel> helpLineList = new ArrayList<>();
    private Context context;
    public OnItemListener onItemListener;
    public ImmergencyPhoneTypeAdapter(Context context,List<HelpLineModel> helpLineList ) {
        this.helpLineList = helpLineList;
        this.context = context;
    }


    @NonNull
    @Override
    public ImmergencyPhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.row_important_phone,parent,false);
       return new ImmergencyPhoneViewHolder(view,onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ImmergencyPhoneViewHolder holder, int position) {
        HelpLineModel helpLineModel = helpLineList.get(position);
        holder.nameView.setText(helpLineModel.getDescription());
        holder.numberView.setText(helpLineModel.getMobileNumber());
       /* Toast.makeText(context, helpLineModel.getDescription(), Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public int getItemCount() {
        return helpLineList.size();
    }

    public class ImmergencyPhoneViewHolder extends RecyclerView.ViewHolder implements OnItemListener {
        public OnItemListener onItemListener;
        public TextView nameView;
        public TextView numberView;

        public ImmergencyPhoneViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            nameView = itemView.findViewById(R.id.tvContactText);

            numberView = itemView.findViewById(R.id.tvNumberText);
            this.onItemListener = onItemListener;
        }

        @Override
        public void onItemClick(int position) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }
}
