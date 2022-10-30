package vn.edu.poly.ph26495_lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import vn.edu.poly.ph26495_lab3.ADAPTER.AdapterFrag;
import vn.edu.poly.ph26495_lab3.ADAPTER.AdapterFragGird;
import vn.edu.poly.ph26495_lab3.ADAPTER.AdapterFragLinear;
import vn.edu.poly.ph26495_lab3.DAO.UserDAO;
import vn.edu.poly.ph26495_lab3.DTO.Users;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.viewPage_tab);
        AdapterFrag adapter = new AdapterFrag(this);
        viewPager.setAdapter(adapter);

        UserDAO userDAO = new UserDAO(this);

        tabLayout.addTab(tabLayout.newTab().setText("LinearLayout"));
        tabLayout.addTab(tabLayout.newTab().setText("Girl Layout"));
        RecyclerView view2 = findViewById(R.id.recyle_view_gird);
        RecyclerView view = findViewById(R.id.recyle_view_linear);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });




    }


}