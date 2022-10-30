package vn.edu.poly.ph26495_lab12_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.material.badge.BadgeDrawable;

public class MainActivity extends AppCompatActivity {
    ImageView mess,notification;
    LinearLayout bottomApp,container,statusApp;
    FrameLayout notificationApp;
    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        statusApp.setVisibility(View.GONE);
        bottomApp.setVisibility(View.GONE);
        container.setVisibility(View.GONE);
        scrollView.setVisibility(View.GONE);
        notificationApp.setVisibility(View.VISIBLE);

        if(notification.getVisibility() == View.VISIBLE){
            mess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    visibleLayout();
                }
            });
        }
        mess.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                goneLayout();
                return true;
            }

        });
    }

    void anhXa(){
        mess =  findViewById(R.id.message_notification);
        notification = findViewById(R.id.notification);
        statusApp = findViewById(R.id.status_appbar);
        bottomApp = findViewById(R.id.bottom_appbar);
        notificationApp = findViewById(R.id.notification_message);
        container = findViewById(R.id.containerMain);
        scrollView = findViewById(R.id.scv_scroll);
    }
    void visibleLayout(){
        mess.setAlpha(0f);
        mess.setTranslationZ(40);
        mess.animate().alpha(1f).translationZBy(-40).setDuration(200);
        statusApp.setVisibility(View.VISIBLE);
        bottomApp.setVisibility(View.VISIBLE);
        container.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.VISIBLE);
        notification.setVisibility(View.GONE);
    }
    void goneLayout(){
        mess.setAlpha(0f);
        mess.setTranslationZ(30);
        mess.animate().alpha(1f).translationZBy(-30).setDuration(500);
        statusApp.setVisibility(View.GONE);
        bottomApp.setVisibility(View.GONE);
        container.setVisibility(View.GONE);
        scrollView.setVisibility(View.GONE);
        notification.setVisibility(View.VISIBLE);
    }

}