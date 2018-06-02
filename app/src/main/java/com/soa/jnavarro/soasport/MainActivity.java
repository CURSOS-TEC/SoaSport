package com.soa.jnavarro.soasport;

<<<<<<< HEAD
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
=======
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
>>>>>>> feature/AuthTheme
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button mLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
=======


>>>>>>> feature/AuthTheme
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
<<<<<<< HEAD
        }
=======


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
>>>>>>> feature/AuthTheme
    }
}
