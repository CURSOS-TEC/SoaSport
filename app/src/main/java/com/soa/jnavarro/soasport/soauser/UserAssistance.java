package com.soa.jnavarro.soasport.soauser;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.soa.jnavarro.soasport.MainActivity;

public class UserAssistance {
    private static final UserAssistance ourInstance = new UserAssistance();

    public static UserAssistance getInstance() {
        return ourInstance;
    }

    private UserAssistance() {
    }

    /**
     * Make a toast that shows the realted email of the user
     * @param ctx the context to render the toast
     */
    public void wellcomeUser(Context ctx){
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

            Toast.makeText(ctx, user.getEmail().toString(),
                    Toast.LENGTH_SHORT).show();

        }
    }
}
