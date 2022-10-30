package vn.edu.poly.ph26495_pager_tab.ADAPTER;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragKhoanChi;
import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragKhoanThu;
import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragLoaiChi;
import vn.edu.poly.ph26495_pager_tab.FRAGMENT.FragLoaiThu;

public class TabLayoutChiAdapter extends FragmentStateAdapter {

    public TabLayoutChiAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TabLayoutChiAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public TabLayoutChiAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1){
            return  new  FragKhoanChi();
        }
        return  new FragLoaiChi();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
