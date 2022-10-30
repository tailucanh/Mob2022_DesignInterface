package vn.edu.poly.practice_demo_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_01 = findViewById(R.id.tv_01);
        // Khai báo sd context menu
        registerForContextMenu(tv_01);
        //Sử dụng popup up menu

        Button btn_click = findViewById(R.id.btn_01);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tạo menu popup
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,btn_click);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_01,popupMenu.getMenu());
                //Sự kiện chọn
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.m_add:
                                Toast.makeText(MainActivity.this, "Thêm mới", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.m_info:
                                Toast.makeText(MainActivity.this, "Thông tin ", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.m_share:
                                Toast.makeText(MainActivity.this, "Chia sẻ", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();

            }
        });


    }
    //-------------Hàm tạo context menu-----------------


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_01,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_add:
                Toast.makeText(this, "Thêm mới", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_info:
                Toast.makeText(this, "Thông tin ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.m_share:
                Toast.makeText(this, "Chia sẻ", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);


    }

    //--------------Hàm option menu-------------
    @Override   //Khởi tạo
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_01,menu);

        return super.onCreateOptionsMenu(menu);
    }
        //Xử lí xự kiện người dùng
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.m_add:
                Toast.makeText(this, "Thêm mới", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_info:
                Toast.makeText(this, "Thông tin ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.m_share:
                Toast.makeText(this, "Chia sẻ", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}