package com.soa.jnavarro.soasport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.soa.jnavarro.soasport.database.DBManager;
import com.soa.jnavarro.soasport.soauser.UserAssistance;
import com.soa.jnavarro.soasport.utils.soa.soapost.SoaPost;
import com.soa.jnavarro.soasport.utils.soa.soapost.SoaPostAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Log out button
    Button mLogoutButton;
    //Reference to Recycler view
    RecyclerView mRecyclerView;
    //Adapter of SoaPosts
    SoaPostAdapter mAdapter;
    //List of SoaPosts
    ArrayList<SoaPost> mSoaPostList = new ArrayList<SoaPost>();
    //Reference to the  to the firebase DataBase
    DatabaseReference myRef = DBManager.getInstance().getDataBaseReference("news");

    private Button mTestBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.postRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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

        mTestBtn = (Button) findViewById(R.id.testBtn);
        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSoaPostList.add(new SoaPost( "id1",  "mDescription 1 ",
                        "mAuthor 1", "mURImage 1", "mTitle 1", "mRating 1"));
                mAdapter.notifyDataSetChanged();
            }
        });

        UserAssistance.getInstance().wellcomeUser(MainActivity.this);

        this.mAdapter = new SoaPostAdapter(this,mSoaPostList);

        mRecyclerView.setAdapter(mAdapter);


        DBManager.getInstance().setPostEventListener(myRef, mAdapter, mSoaPostList,MainActivity.this);


    }
}
