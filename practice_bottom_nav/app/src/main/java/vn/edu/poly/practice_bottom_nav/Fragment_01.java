package vn.edu.poly.practice_bottom_nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_01 extends Fragment {
    Button btn;
    TextView tv_01;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.layout_frag_1,container,false);

      return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn = view.findViewById(R.id.btn_frag1);
        TextView tv_01 = view.findViewById(R.id.tv_01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_01.setText("Hello 01");
                Toast.makeText(getContext(), "Fragment 01", Toast.LENGTH_LONG).show();
//                FragmentManager manager = getActivity().getSupportFragmentManager();
//               Fragment_02 frag2 = (Fragment_02) manager.findFragmentById(R.id.frag_2);
//                frag2.tv_fag02.setText("Đây là fragment 1");


            }
        });

    }
}
