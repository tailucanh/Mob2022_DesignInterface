package vn.edu.poly.ph26495_pager_tab;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class ThuActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView img_setting;
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thu);
        toolbar = findViewById(R.id.toolbar_activity);
        img_setting = findViewById(R.id.img_setting);
        tv_title = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        img_setting.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(ThuActivity.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_items,popupMenu.getMenu());
                popupMenu.setForceShowIcon(true);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.nav_trang_chu:
                                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.nav_chi:
                                Intent intent2 = new Intent(getBaseContext(),ChiActivity.class);
                                startActivity(intent2);
                                break;
                        }
                        return  false;
                    }

                });

                popupMenu.show();
            }
        });

    }
}