package com.example.roy.geoguessswipe;

public class GeoObject {

    private int mGeoImageName;
    private String mGeoMessage;

    public GeoObject(int mGeoName, String mGeoMessage) {

        this.mGeoImageName = mGeoName;
        this.mGeoMessage = mGeoMessage;
    }
    public int getmGeoName() {
        return mGeoImageName;
    }
    public void setmGeoName() {
        this.mGeoImageName = mGeoImageName;
    }
    public String getmGeoMessage() {
        return mGeoMessage;

    }
    public void setmGeoMessage(){
        this.mGeoMessage = mGeoMessage;
    }

    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
        R.drawable.img1_yes_denmark,
        R.drawable.img2_no_canada,
        R.drawable.img3_no_bangladesh,
        R.drawable.img4_yes_kazachstan,
        R.drawable.img5_no_colombia,
        R.drawable.img6_yes_poland,
        R.drawable.img7_yes_malta,
        R.drawable.img8_no_thailand,
        R.drawable.checkmark,
        R.drawable.cross
    };


    public static final String[] PRE_DEFINED_OBJECT_SOLUTIONS= {
            "yes",
            "no",
            "no",
            "yes",
            "no",
            "yes",
            "yes",
            "no",

    };
}
