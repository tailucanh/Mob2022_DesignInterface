package vn.edu.poly.practice_thuc_hanh_28_07;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText ed_name, ed_email,ed_ngay_sinh;
    ImageView img_calendar;
    Button dang_ki;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDayOfMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = findViewById(R.id.ed_ten);
        ed_ngay_sinh = findViewById(R.id.ed_ngay_sinh);
        ed_email = findViewById(R.id.ed_email);
        img_calendar = findViewById(R.id.datetime_ngaysinh);
        img_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDate(ed_ngay_sinh,MainActivity.this);
            }
        });
        dang_ki = findViewById(R.id.btn_save);

        dang_ki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =ed_name.getText().toString();
                String email = ed_email.getText().toString();
                String ngay_sinh = ed_ngay_sinh.getText().toString();

                Toast.makeText(MainActivity.this, " - Họ tên: "+name+"\n"+
                        "- Email: "+email+"\n"+
                        " - Ngày sinh: "+ngay_sinh, Toast.LENGTH_LONG).show();

            }
        });
    }
    public void SelectDate(EditText editText, Context context){
        final Calendar calendar = Calendar.getInstance();
        this.selectedYear = calendar.get(Calendar.YEAR);
        this.selectedMonth = calendar.get(Calendar.MONTH);
        this.selectedDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                editText.setText(year + " - "+(month+1)+" - "+dayOfMonth);
                editText.setFocusable(false);
                selectedYear = year;
                selectedMonth = month;
                selectedDayOfMonth = dayOfMonth;
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,dateSetListener,selectedYear,
                selectedMonth,selectedDayOfMonth);
        datePickerDialog.show();
    }


}