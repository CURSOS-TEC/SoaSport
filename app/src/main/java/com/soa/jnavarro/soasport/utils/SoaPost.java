package com.soa.jnavarro.soasport.utils;

public class SoaPost {
    private String mId;
    private String mDescription;
    private String mAuthor;
    private String mURImage;

    /**
     * Constructor of
     * @param mId
     * @param mDescription
     * @param mAuthor
     * @param mURImage
     */
    public SoaPost(String mId, String mDescription, String mAuthor, String mURImage) {
        this.mId = mId;
        this.mDescription = mDescription;
        this.mAuthor = mAuthor;
        this.mURImage = mURImage;
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
}
