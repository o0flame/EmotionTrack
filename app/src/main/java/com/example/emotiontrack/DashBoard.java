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
import java.text.SimpleDateFormat;
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
    Button shareButton;
    Button changeStatusButton;


    Map<String,String> user_info;

    int emotion_day;
    int curDay;
    Date currentTime;
    Calendar calendar;
    int[] emotions;
    String[] analysis;

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

        shareButton = (Button)findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, ShareInput.class));
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

        changeStatusButton = (Button) findViewById(R.id.change_status_button);
        changeStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashBoard.this, ChangeStatus.class));
            }
        });

        /* set dashboard by database */
        currentTime = Calendar.getInstance().getTime();
        calendar = Calendar.getInstance();
        //start from Sunday = 1, to sat = 7;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        curDay = day;
        //System.out.println("day is" + day);

        Intent intent = getIntent();
        if(intent != null){
            user_info = (HashMap<String,String>) intent.getSerializableExtra("user_info");

            String[] res = user_info.get("emotion").split(",");
            if(res.length!=7) System.out.println("emotion size is wrong");

            emotions = new int[res.length];
            for(int i=0;i<emotions.length;i++) emotions[i] = Integer.parseInt(res[i]);

            welcomeText = findViewById(R.id.welcome);
            welcomeText.setText("Hi, "+ user_info.get("fullname")+"!");

            analysis = user_info.get("analysis").split(",");


            //database: last 7 days emotions including today. -->today, yesterday ....
            //map last seven days to S-M-T...-Sat
            for(int d=0;d<=6;d++){
                int cur = day-d-1;
                if(cur<0) cur+=7; // map 0-6 for sunday to sat
                String dateid = "text_"+String.valueOf(cur);
                int date_rid = getResources().getIdentifier(dateid,"id",getPackageName());
                TextView textView = (TextView)findViewById(date_rid);
                Calendar cal = Calendar.getInstance();
                cal.add(calendar.DATE,day-d-2);
                SimpleDateFormat dateFormat =new SimpleDateFormat("MM/dd");
                String out = dateFormat.format(cal.getTime());
                textView.setTextSize(10f);
                textView.setText(out);



                String bid = "rec_button_"+String.valueOf(cur)+"_"+String.valueOf(6-emotions[d]);
                int resID = getResources().getIdentifier(bid,"id",getPackageName());
                ImageButton colorButton = (ImageButton)findViewById(resID);
                //colorButton.getDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                colorButton.setBackgroundResource(R.drawable.dark_rec);
                emotion_day = d;
                customSetOnClick(colorButton,curDay,d);  //customized on click to pass vars

                /*colorButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //startActivity(new Intent(DashBoard.this, Analysis.class));
                        int message = -1;
                        if(emotions[emotion_day] == -1) message = 2;
                        else if(emotions[emotion_day] >= 4) message = 1;
                        else if(emotions[emotion_day] == 3) message = 2;
                        else if(emotions[emotion_day] <= 2) message = 3;  // 1: happy, 2: meh, 3: sad
                        System.out.println(message);
                        SimpleDateFormat format =new SimpleDateFormat("EEEE MM-dd-YYYY");
                        Calendar cal = Calendar.getInstance();
                        cal.add(Calendar.DATE,curDay-emotion_day);
                        //intent2.putExtra("date", format.format(cal.getTime()));
                        System.out.println("format.format(cal.getTime()):"+format.format(cal.getTime()));
                        //Intent intent2 = new Intent(DashBoard.this, Analysis.class);
                        //intent2.putExtra("this_emotion", message);

                        //startActivity(intent2);
                        //startActivityForResult(new Intent(DashBoard.this, Analysis.class), TO_ANALYSIS);
                    }
                });*/

                String image_id_str = "Emotion_" + String.valueOf(cur);
                int image_id = getResources().getIdentifier(image_id_str,"id",getPackageName());
                ImageView imageView = findViewById(image_id);
                if(emotions[d]==-1) imageView.setImageResource(R.drawable.meh); // replace with ? later on
                else if(emotions[d]>=4) imageView.setImageResource(R.drawable.laugh);
                else if(emotions[d]==3) imageView.setImageResource(R.drawable.meh);
                else if(emotions[d]<=2) imageView.setImageResource(R.drawable.sad);

            }
        }// if syntax end

        /*
        String bid = "rec_button_3_2";
        int resID = getResources().getIdentifier(bid,"id",getPackageName());
        ImageButton colorButton = (ImageButton)findViewById(resID);
        //colorButton.getDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        colorButton.setBackgroundColor(Color.parseColor("#666bff"));*/

        if(analysis.length>=3){
            TextView kw1 = findViewById(R.id.tag1);
            kw1.setText(analysis[0]);
            TextView kw2 = findViewById(R.id.tag2);
            kw2.setText(analysis[1]);
            TextView kw3 = findViewById(R.id.tag3);
            kw3.setText(analysis[2]);
        }

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


    private void customSetOnClick(final ImageButton btn, final int curDay,final int d){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Do whatever you want(str can be used here)
                int message = -1;
                if(emotions[d] == -1) message = 2;
                else if(emotions[d] >= 4) message = 1;
                else if(emotions[d] == 3) message = 2;
                else if(emotions[d] <= 2) message = 3;
                SimpleDateFormat format =new SimpleDateFormat("EEEE MM/dd");
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE,curDay-d-2);
                //intent2.putExtra("date", format.format(cal.getTime()));
                System.out.println("format.format(cal.getTime()):"+format.format(cal.getTime()));

                Intent intent2 = new Intent(DashBoard.this, Analysis.class);
                intent2.putExtra("this_emotion", message);
                intent2.putExtra("date", format.format(cal.getTime()));

                startActivity(intent2);

            }
        });
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
