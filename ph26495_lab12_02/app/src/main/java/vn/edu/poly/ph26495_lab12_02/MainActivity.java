package vn.edu.poly.ph26495_lab12_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);
        TextView title = findViewById(R.id.tv_title);
        ImageView img = findViewById(R.id.image_title);
        // Animation
        btnStart.setAlpha(0f);
        btnStart.setTranslationY(50);
        btnStart.animate().alpha(1f).translationYBy(-50).setStartDelay(300).setDuration(2500);
        title.setAlpha(0f);
        title.setTranslationY(50);
        title.animate().alpha(1f).translationYBy(-50).setStartDelay(200).setDuration(2700);
        img.animate().rotation(360).setDuration(3500);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ActivityFirst.class);
                Toast.makeText(MainActivity.this, "Chào mừng đến với TEST IQ", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


    }


}