package amst.g1.labsec.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import amst.g1.labsec.R;

public class LabViewHolder extends RecyclerView.ViewHolder {

    public final CardView cvRoot;
    public final TextView tvName;
    public final TextView tvLocation;
    public final TextView tvInCharge;


    public LabViewHolder(@NonNull View itemView) {
        super(itemView);
        cvRoot = itemView.findViewById(R.id.cvItemLabRoot);
        tvName = itemView.findViewById(R.id.tvItemLabName);
        tvLocation = itemView.findViewById(R.id.tvItemLabLocation);
        tvInCharge = itemView.findViewById(R.id.tvItemLabInCharge);
    }
}
