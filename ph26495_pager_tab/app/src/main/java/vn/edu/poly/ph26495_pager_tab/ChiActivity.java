package vn.edu.poly.ph26495_pager_tab;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import vn.edu.poly.ph26495_pager_tab.ADAPTER.TabLayoutChiAdapter;
import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragKhoanChi;

public class ChiActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView img_setting;
    TextView tv_title;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi);
        toolbar = findViewById(R.id.toolbar_activity);
        img_setting = findViewById(R.id.img_setting);

        img_setting.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(ChiActivity.this,v);
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
                            case R.id.nav_thu:
                                Intent intent2 = new Intent(getBaseContext(),ThuActivity.class);
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