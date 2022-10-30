package vn.edu.poly.ph26495_lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.poly.ph26495_lab3.ADAPTER.AdapterFragGird;
import vn.edu.poly.ph26495_lab3.ADAPTER.AdapterFragLinear;
import vn.edu.poly.ph26495_lab3.DAO.UserDAO;
import vn.edu.poly.ph26495_lab3.DTO.Users;


public class FragmentGirdLayout extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gird_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyle_view_gird);
        ImageView add = view.findViewById(R.id.add);
        UserDAO userDAO = new UserDAO(getContext());

//        ArrayList<Users> list = userDAO.selectAll();
//        list.add(new Users(1,"Lê Văn A",R.drawable.profile));
//        list.add(new Users(2,"Lê Văn B",R.drawable.profile));
//        list.add(new Users(3,"Lê Văn C",R.drawable.profile));
//        list.add(new Users(4,"Lê Văn D",R.drawable.profile));
//        list.add(new Users(5,"Lê Văn E",R.drawable.profile));
        AdapterFragGird adapterFragGird = new AdapterFragGird(userDAO.selectAll(),userDAO);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterFragGird.addUser(getContext());
            }
        });
        recyclerView.setAdapter(adapterFragGird);

        return view;




    }
}