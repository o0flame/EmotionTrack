package com.example.emotiontrack;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;

public class DashBoard extends AppCompatActivity {

    /* request code */
    public static final int TO_SELF_REFLECT_CHOOSE = 1;
    public static final int TO_BUZZ_TIPS_CHOOSE = 2;
    public static final int TO_ANALYSIS = 3;

    /* widgets */
    private TextView mTextMessage;
    TextView welcomeText;
    Button selfReflectButton;
    Button buzzTipsButtion;

    Map<String,String> user_info;

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        /* find by id */
        mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /* set buttons' click */
        selfReflectButton = (Button) findViewById(R.id.self_refect_button);
        selfReflectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, SelfReflectChoose.class));
                //startActivityForResult(new Intent(DashBoard.this, SelfReflectChoose.class), TO_SELF_REFLECT_CHOOSE);
            }
        });

        buzzTipsButtion = (Button) findViewById(R.id.buzztip_button);
        buzzTipsButtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, BuzzTipsChoose.class));
                //startActivityForResult(new Intent(DashBoard.this, BuzzTipsChoose.class), TO_BUZZ_TIPS_CHOOSE);
            }
        });

        /* set dashboard by database */
        Date currentTime = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        //start from Sunday = 1, to sat = 7;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("day is" + day);

        Intent intent = getIntent();
        if(intent != null){
            user_info = (HashMap<String,String>) intent.getSerializableExtra("user_info");

            String[] res = user_info.get("emotion").split(",");
            if(res.length!=7) System.out.println("emotion size is wrong");

            int[] emotions = new int[res.length];
            for(int i=0;i<emotions.length;i++) emotions[i] = Integer.parseInt(res[i]);

            welcomeText = findViewById(R.id.welcome);
            welcomeText.setText("Hi, "+ user_info.get("fullname")+"!");

            //database: last 7 days emotions including today. -->today, yesterday ....
            //map last seven days to S-M-T...-Sat
            for(int d=0;d<=6;d++){
                int cur = day-d-1;
                if(cur<0) cur+=7; // map 0-6 for sunday to sat
                String bid = "rec_button_"+String.valueOf(cur)+"_"+String.valueOf(6-emotions[d]);
                int resID = getResources().getIdentifier(bid,"id",getPackageName());
                ImageButton colorButton = (ImageButton)findViewById(resID);
                //colorButton.getDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                colorButton.setBackgroundResource(R.drawable.dark_rec);

                colorButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(DashBoard.this, Analysis.class));
                        //startActivityForResult(new Intent(DashBoard.this, Analysis.class), TO_ANALYSIS);
                    }
                });

                String image_id_str = "Emotion_" + String.valueOf(cur);
                int image_id = getResources().getIdentifier(image_id_str,"id",getPackageName());
                ImageView imageView = findViewById(image_id);
                if(emotions[d]==-1) imageView.setImageResource(R.drawable.meh); // replace with ? later on
                else if(emotions[d]>=4) imageView.setImageResource(R.drawable.laugh);
                else if(emotions[d]==3) imageView.setImageResource(R.drawable.meh);
                else if(emotions[d]<=2) imageView.setImageResource(R.drawable.sad);

            }
        }// dashboard set end


        /*
        String bid = "rec_button_3_2";
        int resID = getResources().getIdentifier(bid,"id",getPackageName());
        ImageButton colorButton = (ImageButton)findViewById(resID);
        //colorButton.getDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        colorButton.setBackgroundColor(Color.parseColor("#666bff"));*/

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        switch (requestCode){
//            case TO_SELF_REFLECT_CHOOSE:
//
//                break;
//            case TO_BUZZ_TIPS_CHOOSE:
//
//                break;
//            case TO_ANALYSIS:
//
//                break;
//        }
//
//
//    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//
//
//    }
}
