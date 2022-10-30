package vn.edu.poly.practice_viewpage2_02_08;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter01 extends FragmentStateAdapter {

    public ViewPageAdapter01(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPageAdapter01(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPageAdapter01(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return  new Fragment_01();
        }
        return new Fragment_02();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
