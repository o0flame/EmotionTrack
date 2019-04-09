package com.example.emotiontrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;

public class DashBoard extends AppCompatActivity {

    private TextView mTextMessage;
    TextView welcomeText;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Date currentTime = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        //start from Sunday = 1;
        int day = calendar.get(Calendar.DAY_OF_WEEK);


        Intent intent = getIntent();
        Map<String,String> user_info = (HashMap<String,String>) intent.getSerializableExtra("user_info");

        String[] res = user_info.get("emotion").split(",");
        if(res.length!=7) System.out.println("emotion size is wrong");

        int[] emotions = new int[res.length];
        for(int i=0;i<emotions.length;i++) emotions[i] = Integer.parseInt(res[i]);


        welcomeText = findViewById(R.id.welcome);
        welcomeText.setText("Hi, "+ user_info.get("fullname")+"!");

        String bid = "button_12";
        int resID = getResources().getIdentifier(bid,"id",getPackageName());
        ImageButton colorButton = (ImageButton)findViewById(resID);









    }

}
