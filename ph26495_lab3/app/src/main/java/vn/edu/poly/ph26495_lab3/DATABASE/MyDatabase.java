package vn.edu.poly.ph26495_lab3.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vn.edu.poly.ph26495_lab3.R;

public class MyDatabase extends SQLiteOpenHelper {

    public static String DB_NAME = "UserMangament";
    public static int DB_VERSION = 1;


    public  MyDatabase(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        int img = R.drawable.profile;
        String db_user = "CREATE TABLE  tb_user (id_ur INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,name TEXT NOT NULL,avatar INTEGER );";
        db.execSQL(db_user);
        String insert_tb = "Insert into tb_user (id_ur,name, avatar)  values (null,'LE VAN A' "+","+img+")";
        db.execSQL(insert_tb);
        insert_tb = "Insert into tb_user (id_ur,name, avatar)  values (null,'LE VAN B'"+","+img+")";
        db.execSQL(insert_tb);
        insert_tb = "Insert into  tb_user (id_ur,name, avatar)  values (null,'LE VAN C'"+","+img+")";
        db.execSQL(insert_tb);
        insert_tb = "Insert into  tb_user (id_ur,name, avatar)  values (null,'LE VAN D'"+","+img+")";
        db.execSQL(insert_tb);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
