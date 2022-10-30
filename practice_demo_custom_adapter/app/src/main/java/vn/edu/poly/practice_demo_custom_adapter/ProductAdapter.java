package vn.edu.poly.practice_demo_custom_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList<Products> listPr;

    public ProductAdapter(ArrayList<Products> listPr) {
        this.listPr = listPr;
    }

    @Override
    public int getCount() {
        return listPr.size();
    }

    @Override
    public Object getItem(int position) {
        return listPr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (listPr.get(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if(convertView == null){
            row = View.inflate(parent.getContext(),R.layout.layout_one_item,null);
        }else{
            row = convertView;
        }
        Products products = listPr.get(position);
        ImageView   imgPr = row.findViewById(R.id.image_res);
        ImageView imgDele = row.findViewById(R.id.delete);
        TextView name = row.findViewById(R.id.name_item);

        imgPr.setImageResource(products.id_img);
        name.setText(products.getId() +" . "+products.getName());

        imgDele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPr.remove(position);
                notifyDataSetChanged();
            }
        });

        return row;
    }



}
