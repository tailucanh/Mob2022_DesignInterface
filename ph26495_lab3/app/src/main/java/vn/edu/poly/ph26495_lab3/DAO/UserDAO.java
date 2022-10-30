package vn.edu.poly.ph26495_lab3.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ProgressBar;

import java.util.ArrayList;

import vn.edu.poly.ph26495_lab3.DATABASE.MyDatabase;
import vn.edu.poly.ph26495_lab3.DTO.Users;


public class UserDAO {
    SQLiteDatabase sqLiteDatabase;
    MyDatabase myDatabase;

    public UserDAO(Context context){
        myDatabase =new MyDatabase(context);
        sqLiteDatabase = myDatabase.getWritableDatabase();
    }
    public void close(){
        myDatabase.close();
    }

    public long insertNew(Users user){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",user.getName());
        contentValues.put("avatar",user.getAvatar());

        long res = sqLiteDatabase.insert("tb_user", null, contentValues);
        return  res;
    }

    public int updateUser(Users user){
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",user.getName());
        contentValues.put("avatar",user.getAvatar());

        int res = sqLiteDatabase.update( "tb_user", contentValues,"id_ur = ?", new String[] { user.getId_ur() +"" } );
        return  res;
    }

    public int deleteUser(Users user){
        int res =sqLiteDatabase.delete("tb_user","id_ur = ?", new String[]{user.getId_ur() +""});
        return  res;
    }

    public ArrayList<Users> selectAll(){
        ArrayList<Users> lists = new ArrayList<>();
        String sql_Select = "SELECT * FROM tb_user";

        Cursor cursor = sqLiteDatabase.rawQuery(sql_Select,null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                    Users user= new Users();
                    user.setId_ur(cursor.getInt(0));
                    user.setName(cursor.getString(1));
                    user.setAvatar(cursor.getInt(2));

                    lists.add(user);
                 cursor.moveToNext(); ///Phải cho vào while
            }
        }
        return lists;
    }



}
