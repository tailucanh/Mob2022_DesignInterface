package vn.edu.poly.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed_kq, ed_A, ed_B, ed_C;
    Button btn_tong, btn_tich, bnt_ptb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_kq = findViewById(R.id.ed_kq);
        ed_A = findViewById(R.id.ed_a);
        ed_B = findViewById(R.id.ed_b);
        ed_C = findViewById(R.id.ed_c);
        btn_tong = findViewById(R.id.btn_tong);
        btn_tich = findViewById(R.id.btn_tich);
        bnt_ptb2 = findViewById(R.id.btn_ptb2);

        btn_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double kq;
                String a = ed_A.getText().toString();
                String b = ed_B.getText().toString();
                String c = ed_C.getText().toString();
                if(a.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập a",Toast.LENGTH_SHORT).show();
                }else if(b.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập b",Toast.LENGTH_SHORT).show();
                }
                else if(c.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập c",Toast.LENGTH_SHORT).show();
                }else {
                   double numberA = Double.parseDouble(a);
                    double numberB = Double.parseDouble(b);
                    double numberC = Double.parseDouble(c);

                     kq = numberA + numberB + numberC;
                    ed_kq.setText(String.valueOf(numberA+" + "+numberB+" + "+numberC+" = "+ String.format("%.2f",kq)) );
                }

            }
        });

        btn_tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double kq;
                String a = ed_A.getText().toString();
                String b = ed_B.getText().toString();
                String c = ed_C.getText().toString();
                if(a.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập a",Toast.LENGTH_SHORT).show();
                }else if(b.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập b",Toast.LENGTH_SHORT).show();
                }
                else if(c.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập c",Toast.LENGTH_SHORT).show();
                }else {
                    double numberA = Double.parseDouble(a);
                    double numberB = Double.parseDouble(b);
                    double numberC = Double.parseDouble(c);

                    kq = numberA * numberB * numberC;
                    ed_kq.setText(String.valueOf(numberA+" x "+numberB+" x "+numberC+" = "+ String.format("%.2f",kq)) );
                }

            }
        });


        bnt_ptb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = ed_A.getText().toString();
                String b = ed_B.getText().toString();
                String c = ed_C.getText().toString();
                if(a.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập a",Toast.LENGTH_SHORT).show();
                }else if(b.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập b",Toast.LENGTH_SHORT).show();
                }
                else if(c.equals("")){
                    Toast.makeText(MainActivity.this,"Hãy nhập c",Toast.LENGTH_SHORT).show();
                }else {
                    double numberA = Double.parseDouble(a);
                    double numberB = Double.parseDouble(b);
                    double numberC = Double.parseDouble(c);
                    if(numberA == 0){
                        if(numberB == 0 ){
                            if (numberC == 0){
                                ed_kq.setText("Phương trình có vô số nghiệm!");
                                Toast.makeText(MainActivity.this,"Phương trình có vô số nghiệm!",Toast.LENGTH_SHORT).show();
                            }else {
                                ed_kq.setText("Phương trình vô nghiệm!");
                                Toast.makeText(MainActivity.this,"Phương trình vô nghiệm!",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            double x = numberC/numberB;
                            ed_kq.setText("X = "+String.format("%.2f",x));
                            Toast.makeText(MainActivity.this,"Phương trình có 1 nghiệm!",Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        double denlta = Math.pow(numberB,2) - 4*numberA*numberC;
                        if(denlta > 0){
                            double x1 = -(numberB + Math.sqrt(denlta))/(2*numberA);
                            double x2 = -(numberB - Math.sqrt(denlta))/(2*numberA);
                            ed_kq.setText(" -> X1 = "+String.format("%.2f",x1) +"  -> X2 = "+String.format("%.2f",x2));
                            Toast.makeText(MainActivity.this,"Phương trình có 2 nghiệm nhân biệt !",Toast.LENGTH_SHORT).show();
                        }else if(denlta == 0){
                            double x = -numberB/2*numberA;
                            ed_kq.setText("X = "+String.format("%.2f",x));
                            Toast.makeText(MainActivity.this,"Phương trình có 1 nghiệm duy nhất!",Toast.LENGTH_SHORT).show();
                        }else{
                            ed_kq.setText("Phương trình vô nghiệm!");
                            Toast.makeText(MainActivity.this,"Phương trình vô nghiệm!",Toast.LENGTH_SHORT).show();
                        }

                    }

                }
            }
        });



        ed_A.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_kq.setText(ed_A.getText().toString());
            }
        });

        ed_B.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_kq.setText(ed_B.getText().toString());
            }
        });
        ed_C.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ed_kq.setText(ed_C.getText().toString());
            }
        });


    }


}