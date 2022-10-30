package vn.edu.poly.practice_2_16_07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Demo hiênr thị màu sắc lên spinner
        String [] listColors = {"Xanh", " Đỏ", "Tím", "Vàng","Lục","Lam"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_background,listColors);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);

        Spinner spinner = findViewById(R.id.spinner_colors);
        spinner.setAdapter(arrayAdapter);
        //Xử lí chọn
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

              Toast.makeText(MainActivity.this, "Bạn chọn: "+listColors[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //gắn  vào listview
        ListView lv = findViewById(R.id.lv_colors);
        lv.setAdapter(arrayAdapter);

        //gắn  vào gridview
        GridView gridView = findViewById(R.id.gr_colors);
        gridView.setAdapter(arrayAdapter);



    }
}