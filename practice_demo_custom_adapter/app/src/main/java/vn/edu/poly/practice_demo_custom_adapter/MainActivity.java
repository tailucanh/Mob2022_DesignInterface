package vn.edu.poly.practice_demo_custom_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lv = findViewById(R.id.lv_pr);
        ArrayList<Products> list = new ArrayList<>();
        list.add(new Products(1,"Ảnh số 1",R.drawable.img_1));
        list.add(new Products(2,"Ảnh số 2",R.drawable.img_2));
        list.add(new Products(3,"Ảnh số 3",R.drawable.img_3));

        ProductAdapter adapter = new ProductAdapter(list);
        lv.setAdapter(adapter);


    }
}