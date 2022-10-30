package vn.edu.poly.practice_demo_recycle_view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsViewHolder extends RecyclerView.ViewHolder {
    ImageView img_pr, img_dele;
    TextView tv_name;

    public ProductsViewHolder(@NonNull View itemView) {
        super(itemView);
        img_pr = itemView.findViewById(R.id.image_res);
        img_dele = itemView.findViewById(R.id.delete);
        tv_name = itemView.findViewById(R.id.name_item);

    }
}
