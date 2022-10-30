package vn.edu.poly.practice_3_16_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SimpleAdapter
        List<HashMap<String, Object>> listPr = new ArrayList();

        HashMap<String, Object> objPr = new HashMap<>();
        objPr.put("image",R.drawable.instagram);
        objPr.put("name","Instagram");
        objPr.put("price",20000000);
        listPr.add(objPr);

        objPr = new HashMap<>();
        objPr.put("image",R.drawable.tiktok);
        objPr.put("name","Tiktok");
        objPr.put("price",17000000);
        listPr.add(objPr);

        String [] forms = {"name","price","image"};
        int [] arrTo = {R.id.tv_name, R.id.tv_price,R.id.img_product};

        SimpleAdapter simpleAdapter =
                new SimpleAdapter(this, listPr, R.layout.layout_one_item,forms,arrTo);

        ListView lv = findViewById(R.id.lv_pr);
        lv.setAdapter(simpleAdapter);
        GridView gridView = findViewById(R.id.gr_pr);
        gridView.setAdapter(simpleAdapter);
        Spinner spinner = findViewById(R.id.spinner_pr);
        spinner.setAdapter(simpleAdapter);


    }
}