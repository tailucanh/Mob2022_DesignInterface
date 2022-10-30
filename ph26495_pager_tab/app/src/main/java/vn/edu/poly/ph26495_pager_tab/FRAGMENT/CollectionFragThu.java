package vn.edu.poly.ph26495_pager_tab.FRAGMENT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import vn.edu.poly.ph26495_pager_tab.ADAPTER.TabLayoutChiAdapter;
import vn.edu.poly.ph26495_pager_tab.ADAPTER.TabLayoutThuAdapter;
import vn.edu.poly.ph26495_pager_tab.R;

public class CollectionFragThu extends Fragment {
    ViewPager2 viewPager2;
    TabLayoutThuAdapter adapter;
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.collections_frag_thu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tabLayout_thu);
        viewPager2 = view.findViewById(R.id.viewPage_tab);
        adapter = new TabLayoutThuAdapter(this);

        tabLayout.addTab(tabLayout.newTab().setText("Loại thu"));
        tabLayout.addTab(tabLayout.newTab().setText("Khoản thu"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        viewPager2.setAdapter(adapter);



    }
}
