package vn.edu.poly.ph26495_lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import vn.edu.poly.ph26495_lab3.ADAPTER.AdapterFragGird;
import vn.edu.poly.ph26495_lab3.ADAPTER.AdapterFragLinear;
import vn.edu.poly.ph26495_lab3.DAO.UserDAO;
import vn.edu.poly.ph26495_lab3.DTO.Users;


public class FragmentLinearLayout extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linear_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyle_view_linear);
        ImageView add = view.findViewById(R.id.add);
        UserDAO userDAO = new UserDAO(getContext());

       AdapterFragLinear adapterFragLinear = new AdapterFragLinear(userDAO.selectAll(),userDAO);

         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 adapterFragLinear.addUser(getContext());
             }
         });
        recyclerView.setAdapter(adapterFragLinear);
        return view;
    }
}