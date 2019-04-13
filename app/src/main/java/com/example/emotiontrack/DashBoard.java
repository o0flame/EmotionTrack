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

import java.io.Serializable;
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

            final int[] emotions = new int[res.length];
            for(int i=0;i<emotions.length;i++) emotions[i] = Integer.parseInt(res[i]);

            welcomeText = findViewById(R.id.welcome);
            welcomeText.setText("Hi, "+ user_info.get("fullname")+"!");

            // Sunday button
            String bid = "rec_button_"+String.valueOf(0)+"_"+String.valueOf(6-emotions[0]);
            int resID = getResources().getIdentifier(bid,"id",getPackageName());
            ImageButton sundayButton = (ImageButton)findViewById(resID);
            sundayButton.setBackgroundResource(R.drawable.dark_rec);
            setEmojiHere(emotions, 0);
            sundayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntentHere(emotions, 0);
                }
            });

            // Monday button
            bid = "rec_button_"+String.valueOf(1)+"_"+String.valueOf(6-emotions[1]);
            resID = getResources().getIdentifier(bid,"id",getPackageName());
            ImageButton mondayButton = (ImageButton)findViewById(resID);
            mondayButton.setBackgroundResource(R.drawable.dark_rec);
            setEmojiHere(emotions, 1);
            mondayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntentHere(emotions, 1);
                }
            });

            // Tuesday button
            bid = "rec_button_"+String.valueOf(2)+"_"+String.valueOf(6-emotions[2]);
            resID = getResources().getIdentifier(bid,"id",getPackageName());
            ImageButton tuesdayButton = (ImageButton)findViewById(resID);
            tuesdayButton.setBackgroundResource(R.drawable.dark_rec);
            setEmojiHere(emotions, 2);
            tuesdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntentHere(emotions, 2);
                }
            });

            // Wednesday button
            bid = "rec_button_"+String.valueOf(3)+"_"+String.valueOf(6-emotions[3]);
            resID = getResources().getIdentifier(bid,"id",getPackageName());
            ImageButton wednesdayButton = (ImageButton)findViewById(resID);
            wednesdayButton.setBackgroundResource(R.drawable.dark_rec);
            setEmojiHere(emotions, 3);
            wednesdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntentHere(emotions, 3);
                }
            });

            // Thursday button
            bid = "rec_button_"+String.valueOf(4)+"_"+String.valueOf(6-emotions[4]);
            resID = getResources().getIdentifier(bid,"id",getPackageName());
            ImageButton thursdayButton = (ImageButton)findViewById(resID);
            thursdayButton.setBackgroundResource(R.drawable.dark_rec);
            setEmojiHere(emotions, 4);
            thursdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntentHere(emotions, 4);
                }
            });

            // Friday button
            bid = "rec_button_"+String.valueOf(5)+"_"+String.valueOf(6-emotions[5]);
            resID = getResources().getIdentifier(bid,"id",getPackageName());
            ImageButton fridayButton = (ImageButton)findViewById(resID);
            fridayButton.setBackgroundResource(R.drawable.dark_rec);
            setEmojiHere(emotions, 5);
            fridayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntentHere(emotions, 5);
                }
            });

            // Saturday button
            bid = "rec_button_"+String.valueOf(6)+"_"+String.valueOf(6-emotions[6]);
            resID = getResources().getIdentifier(bid,"id",getPackageName());
            ImageButton saturdayButton = (ImageButton)findViewById(resID);
            saturdayButton.setBackgroundResource(R.drawable.dark_rec);
            setEmojiHere(emotions, 6);
            saturdayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntentHere(emotions, 6);
                }
            });

//            //database: last 7 days emotions including today. -->today, yesterday ....
//            //map last seven days to S-M-T...-Sat
//            for(int d=0;d<=6;d++){
//                int cur = day-d-1;
//                if(cur<0) cur+=7; // map 0-6 for sunday to sat
//                String bid = "rec_button_"+String.valueOf(cur)+"_"+String.valueOf(6-emotions[d]);
//                int resID = getResources().getIdentifier(bid,"id",getPackageName());
//                ImageButton colorButton = (ImageButton)findViewById(resID);
//                //colorButton.getDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
//                colorButton.setBackgroundResource(R.drawable.dark_rec);
//
//                colorButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        startActivity(new Intent(DashBoard.this, Analysis.class));
//                        int message = -1;
//                        if(emotions[d] == -1) message = 2;
//                        else if(emotions[d] >= 4) message = 1;
//                        else if(emotions[d] == 3) message = 2;
//                        else if(emotions[d] <= 2) message = 3;  // 1: happy, 2: meh, 3: sad
//                        Intent intent2 = new Intent(DashBoard.this, Analysis.class);
//                        intent2.putExtra("this_emotion", (Serializable)message);
//                        startActivity(intent2);
//                        //startActivityForResult(new Intent(DashBoard.this, Analysis.class), TO_ANALYSIS);
//                    }
//                });
//
//                String image_id_str = "Emotion_" + String.valueOf(cur);
//                int image_id = getResources().getIdentifier(image_id_str,"id",getPackageName());
//                ImageView imageView = findViewById(image_id);
//                if(emotions[d]==-1) imageView.setImageResource(R.drawable.meh); // replace with ? later on
//                else if(emotions[d]>=4) imageView.setImageResource(R.drawable.laugh);
//                else if(emotions[d]==3) imageView.setImageResource(R.drawable.meh);
//                else if(emotions[d]<=2) imageView.setImageResource(R.drawable.sad);
//
//            }
        }// if syntax end


        /*
        String bid = "rec_button_3_2";
        int resID = getResources().getIdentifier(bid,"id",getPackageName());
        ImageButton colorButton = (ImageButton)findViewById(resID);
        //colorButton.getDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        colorButton.setBackgroundColor(Color.parseColor("#666bff"));*/

    }// onCreate end

    public void setIntentHere(int[] emotions, int e){
        int message = -1;
        if(emotions[e] == -1) message = 2;
        else if(emotions[e] >= 4) message = 1;
        else if(emotions[e] == 3) message = 2;
        else if(emotions[e] <= 2) message = 3;  // 1: happy, 2: meh, 3: sad
        int[] info = new int[2];
        info[0] = message;
        info[1] = e;
        Intent intent2 = new Intent(DashBoard.this, Analysis.class);
        intent2.putExtra("this_emotion", (Serializable)info);
        startActivity(intent2);
    }

    public  void setEmojiHere(int[] emotions, int e){
        String image_id_str = "Emotion_" + String.valueOf(e);
        int image_id = getResources().getIdentifier(image_id_str,"id",getPackageName());
        ImageView imageView = findViewById(image_id);
        if(emotions[e]==-1) imageView.setImageResource(R.drawable.meh); // replace with ? later on
        else if(emotions[e]>=4) imageView.setImageResource(R.drawable.laugh);
        else if(emotions[e]==3) imageView.setImageResource(R.drawable.meh);
        else if(emotions[e]<=2) imageView.setImageResource(R.drawable.sad);
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
