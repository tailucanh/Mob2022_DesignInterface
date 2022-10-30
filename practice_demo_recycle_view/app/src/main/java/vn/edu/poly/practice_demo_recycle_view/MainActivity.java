package vn.edu.poly.practice_demo_recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        ArrayList<Products> list = new ArrayList<>();
        list.add(new Products(1,"Ảnh 1",R.drawable.img_1));
        list.add(new Products(2,"Ảnh 2",R.drawable.img_2));
        list.add(new Products(3,"Ảnh 3",R.drawable.img_3));
        ProductAdapter adapter = new ProductAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}