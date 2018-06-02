package com.soa.jnavarro.soasport;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.soa.jnavarro.soasport.utils.posts.SoaPost;
import com.soa.jnavarro.soasport.utils.posts.SoaPostAdapter;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button mLogoutButton;

    RecyclerView mRecyclerView;
    SoaPostAdapter mAdapter;
    ArrayList<SoaPost> mSoaPostList = new ArrayList<SoaPost>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.postRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSoaPostList.add(new SoaPost( "id1",  "mDescription 1 ",
                "mAuthor 1", "mURImage 1", "mTitle 1", "mRating 1"));

        mSoaPostList.add(new SoaPost( "id2",  "mDescription 2 ",
                "mAuthor 2", "mURImage 2", "mTitle 2", "mRating 2"));

        mSoaPostList.add(new SoaPost( "id3",  "mDescription 2 ",
                "mAuthor 2", "mURImage 2", "mTitle 2", "mRating 2"));

        mSoaPostList.add(new SoaPost( "id3",  "mDescription 2 ",
                "mAuthor 2", "mURImage 2", "mTitle 2", "mRating 2"));

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();

            Toast.makeText(MainActivity.this, user.getEmail().toString(),
                    Toast.LENGTH_SHORT).show();

        }

        mLogoutButton = (Button)findViewById(R.id.btn_logout);

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FirebaseAuth.getInstance().signOut();
                    Intent myIntent = new Intent(MainActivity.this, AuthActivity.class);
                    MainActivity.this.startActivity(myIntent);
                    MainActivity.this.finish();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, " Error during logout.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


        this.mAdapter = new SoaPostAdapter(this,mSoaPostList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
