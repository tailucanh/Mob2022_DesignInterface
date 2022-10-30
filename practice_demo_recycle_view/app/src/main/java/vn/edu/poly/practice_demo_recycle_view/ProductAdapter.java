package vn.edu.poly.practice_demo_recycle_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    ArrayList<Products> listPr;

    public ProductAdapter(ArrayList<Products> listPr) {
        this.listPr = listPr;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.layout_one_item,parent,false);
        ProductsViewHolder viewHolder = new ProductsViewHolder(row);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        final  int viTri = position;
        Products products = listPr.get(position);
        holder.img_pr.setImageResource(products.getId_img());
        holder.tv_name.setText(products.getId()+" . "+ products.getName());
        holder.img_dele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPr.remove(viTri);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listPr.size();
    }
}
