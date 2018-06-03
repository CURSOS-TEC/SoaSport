package com.soa.jnavarro.soasport.utils.soa.soapost;

import android.util.Log;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class SoaPost {
    private String mId;
    private String mDescription;
    private String mAuthor;
    private String mURImage;
    private String mTitle;
    private String mRating;

    /**
     * With no arguments
     */
    public  SoaPost (){
        this.mId = "";
        this.mDescription = "";
        this.mAuthor = "";
        this.mURImage = "";
        this.mTitle = "";
        this.mRating = "";
    }

    /**
     * Constructor of
     * @param mId
     * @param mDescription
     * @param mAuthor
     * @param mURImage
     */
    public SoaPost(String mId, String mDescription, String mAuthor, String mURImage,String mTitle,String mRating) {
        this.mId = mId;
        this.mDescription = mDescription;
        this.mAuthor = mAuthor;
        this.mURImage = mURImage;
        this.mTitle = mTitle;
        this.mRating = mRating;

    }



    /**
     *
     * @return
     */
    public String getmId() {
        return mId;
    }

    /**
     *
     * @return
     */
    public String getmDescription() {
        return mDescription;
    }

    /**
     *
     * @return
     */
    public String getmAuthor() {
        return mAuthor;
    }

    /**
     *
     * @return
     */
    public String getmURImage() {
        return mURImage;
    }

    /**
     *
     * @return
     */
    public String getmTitle(){
        return mTitle;
    }

    /**
     *
     * @return
     */
    public String getmRating(){
        return mRating;
    }

    @Override
    public String toString(){
        return (this.mAuthor + " " + this.mDescription + " " + this.mTitle );
    }
}
