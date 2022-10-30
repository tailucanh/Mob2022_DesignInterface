package vn.edu.poly.practice_bottom_nav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_frag,new Fragment_01()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.frag1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_frag,new Fragment_01()).commit();
                        break;
                    case R.id.frag2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_frag,new Fragment_02()).commit();
                        break;
                    case R.id.frag3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_frag,new Fragment_03()).commit();
                        break;
                    default:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container_frag,new Fragment_01()).commit();
                }
                return true;
            }
        });


    }
}