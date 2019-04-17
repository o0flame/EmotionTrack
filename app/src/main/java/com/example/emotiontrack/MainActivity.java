package com.example.emotiontrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView mTextMessage;
    Button log_but;
    TextView test;
    String username;
    TextInputEditText input;

    Map<String,String> user_info;


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
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        user_info = new HashMap<String,String>();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        log_but = findViewById(R.id.login_button);
        test = findViewById(R.id.test);
        input = findViewById(R.id.input_text);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(); // write
        DatabaseReference userRef = database.getReference("user");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                System.out.println("this is called");
                String value = dataSnapshot.getValue().toString();
                Log.d("Value is: " , value);
                System.out.println("value is"+ value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Failed to read value.", error.toException());
            }
        });

        log_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = input.getText().toString();
                if(username.length()>0) {
                    //test.setText(username);
                    DatabaseReference userRef = myRef.child("user").child(username);

                    userRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //if(dataSnapshot.hasChild(username)){
                            if(dataSnapshot.exists()){
                                System.out.println("this user exists");
                                //read data
                                for(DataSnapshot ds : dataSnapshot.getChildren()){
                                    //System.out.println("ds:"+ds.getKey()+","+ds.getValue().toString());
                                    user_info.put(ds.getKey(),ds.getValue().toString());
                                    System.out.println("userinfo size:"+user_info.size());
                                }

                                Intent intent = new Intent(MainActivity.this, DashBoard.class);
                                intent.putExtra("user_info",(Serializable)user_info);
                                startActivity(intent);
                            }
                            else{
                                //initiate data
                                String valueString = "";
                                System.out.println("push user data");
                                for(int i=0; i<=6; i++){
                                    int cur_rand = (int)(Math.random() * 5);
                                    if(cur_rand == 0) cur_rand = 1;
                                    if(cur_rand == 6) cur_rand = 5;
                                    valueString += String.valueOf(cur_rand);
                                    if(i<6) valueString += ",";
                                }
                                //myRef.child("user").child(username).child("emotion").setValue("1,2,3,4,5,6,7");
                                myRef.child("user").child(username).child("emotion").setValue(valueString);
                                myRef.child("user").child(username).child("fullname").setValue(username);
                                myRef.child("user").child(username).child("analysis").setValue("happy,wonderful,glad");

                                user_info.put("emotion","1,2,3,4,5,6,7");
                                user_info.put("fullname",username);
                                user_info.put("analysis","happy,wonderful,glad");

                                Intent intent = new Intent(MainActivity.this, DashBoard.class);
                                intent.putExtra("user_info",(Serializable)user_info);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.w("Failed to read value.", databaseError.toException());
                        }
                    });

                }
            }
        });
    }


}
