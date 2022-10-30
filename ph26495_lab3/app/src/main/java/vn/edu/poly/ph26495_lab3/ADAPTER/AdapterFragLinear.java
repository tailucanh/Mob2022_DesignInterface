package vn.edu.poly.ph26495_lab3.ADAPTER;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAccumulator;

import vn.edu.poly.ph26495_lab3.DAO.UserDAO;
import vn.edu.poly.ph26495_lab3.DTO.Users;
import vn.edu.poly.ph26495_lab3.R;

public class AdapterFragLinear extends RecyclerView.Adapter<AdapterFragLinear.MyViewHolder> {

    ArrayList<Users> listUser;
    UserDAO userDAO;

    public AdapterFragLinear(ArrayList<Users> listUser) {
        this.listUser = listUser;
    }

    public AdapterFragLinear(ArrayList<Users> listUser, UserDAO userDAO) {
        this.listUser = listUser;
        this.userDAO = userDAO;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_one_item_linear,parent,false);

        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFragLinear.MyViewHolder holder, int position) {
        final  int index = position;
        Users user = listUser.get(position);
        holder.avatar.setImageResource(user.getAvatar());
        holder.id.setText(user.getId_ur() + "");
        holder.tv_name.setText(user.getName());

        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listUser.remove(index);
                delete(v.getContext(),user,index);
                notifyDataSetChanged();
            }
        });
        holder.img_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(v.getContext(),user,index);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,id;
        ImageView img_delete, img_update,avatar;
        public MyViewHolder(View view){
            super(view);
            id = view.findViewById(R.id.id_linear);
            tv_name = view.findViewById(R.id.name_linear);
            img_delete = view.findViewById(R.id.delete_linear);
            img_update = view.findViewById(R.id.update_linear);
            avatar = view.findViewById(R.id.avatar_user);
        }
    }

    public void addUser(Context context){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_add);
        dialog.setCancelable(true);
        EditText ed_name = dialog.findViewById(R.id.ed_User_add);
        Button btn_save = dialog.findViewById(R.id.btn_save);



        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setIcon(R.drawable.contactform);
                builder.setTitle("Confirm !!!");
                builder.setMessage("Xác nhận lưu thông tin !");
                builder.setCancelable(true);
                Users user = new Users();
                String nameUser = ed_name.getText().toString();
                user.setName(nameUser);
                user.setAvatar(R.drawable.profile);

                long res = userDAO.insertNew(user);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        if(res > 0){
                            listUser.clear();
                            listUser.addAll(userDAO.selectAll());
                            notifyDataSetChanged();
                            Toast.makeText(context, "Đã thêm mới! ", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        Toast.makeText(context,"Đã hủy !",Toast.LENGTH_SHORT).show();
                        dialog1.cancel();
                    }
                });

                AlertDialog sh = builder.create();
                sh.show();
            }
        });
        dialog.show();
    }


    public void update(Context context, Users user, int index){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_edit_user);
        dialog.setCancelable(true);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.contactform);
        builder.setTitle("Confirm !!!");
        builder.setMessage("Xác nhận sửa đổi thông tin!");
        builder.setCancelable(true);

        EditText name_update = dialog.findViewById(R.id.ed_User_sua);
        EditText avtar_update = dialog.findViewById(R.id.ed_avatar_sua);
        name_update.setText(user.getName());
        avtar_update.setText(user.getAvatar());

        Button btn_update = dialog.findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(name_update.getText().toString());
                user.setAvatar(R.drawable.profile);

                int res = userDAO.updateUser(user);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(res > 0){
                            listUser.set(index,user);
                            notifyDataSetChanged();
                            Toast.makeText(context, "Đã sửa thông tin !", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(context, "Không sửa được thông tin !" + res, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"Đã hủy !",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });


                AlertDialog sh = builder.create();
                sh.show();
            }
        });
        dialog.show();
    }

    public void delete(Context context,Users user,int index){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xóa lớp?");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Có chắc chắn xóa : " + user.getName());
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int kq = userDAO.deleteUser(user);
                if(kq > 0)
                {
                    listUser.remove(index);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Đã xóa! ", Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }else
                    Toast.makeText(context, "Không xóa được! " + kq, Toast.LENGTH_SHORT).show();

                dialogInterface.dismiss();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Đã hủy", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
