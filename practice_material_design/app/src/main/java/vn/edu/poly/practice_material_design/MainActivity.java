package vn.edu.poly.practice_material_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button_submit);
        TextInputLayout name = findViewById(R.id.input_layout_user_name);
        TextInputLayout pass = findViewById(R.id.input_layout_pass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameUser = name.getEditText().getText().toString();
                String passWord = pass.getEditText().getText().toString();

                if(nameUser.length() < 3){
                    name.setError("Cần nhập ít nhất 3 kí tự tên");
                    return;
                }
                if(passWord.length() < 3){
                    pass.setError("Cần nhập ít nhất 3 kí tự pass");
                    return;
                }
                name.setError("");
                pass.setError("");
                Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}