package vn.edu.poly.practice_demo_21_07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        Toolbar toolbar = findViewById(R.id.toolBar_custom);
        setSupportActionBar(toolbar);
        //Chỉnh sửa toolbar
        //Nút back về
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Ẩn tiêu đề mặc định
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Đổi biểu tượng
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_delete);




    }
}