package vn.edu.poly.ph26495_lab3.ADAPTER;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.poly.ph26495_lab3.FragmentGirdLayout;
import vn.edu.poly.ph26495_lab3.FragmentLinearLayout;

public class AdapterFrag extends FragmentStateAdapter {
    public AdapterFrag(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public AdapterFrag(@NonNull Fragment fragment) {
        super(fragment);
    }

    public AdapterFrag(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return  new  FragmentLinearLayout();
        }
        return new FragmentGirdLayout();
    }



    @Override
    public int getItemCount() {
        return 2;
    }
}
