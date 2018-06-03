package com.soa.jnavarro.soasport.utils.soa.soaalerts;

import android.content.Context;
import android.widget.Toast;

public class SoaAlert {
    private static final SoaAlert ourInstance = new SoaAlert();

    public static SoaAlert getInstance() {
        return ourInstance;
    }

    private SoaAlert() {
    }

    /**
     * Toast a message in the given context
     * @param ctx The context, the current activity
     * @param message The message to show
     */
    public void ToastMessage (Context ctx, String message){
        Toast.makeText(ctx,message,
                Toast.LENGTH_SHORT).show();
    }
}
