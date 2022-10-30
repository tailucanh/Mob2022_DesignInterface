package vn.edu.poly.ph26495_pager_tab.ADAPTER;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragKhoanChi;
import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragKhoanThu;
import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragLoaiChi;
import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragLoaiThu;

public class TabLayoutThuAdapter extends FragmentStateAdapter {

    public TabLayoutThuAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 0){
            return  new FragKhoanThu();
        }
        return  new FragLoaiThu();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
