package com.agprincefu.andriod.beatbox;

import android.util.Log;

public class Sound {
    private static final String TAG = "agtest";
    private String mName;
    private String mAssetPath;

    public Sound(String assetPath){

        mAssetPath = assetPath;
        String [] components = mAssetPath.split("/");
        String fileName = components[components.length-1];
        Log.d(TAG, "fileName : "+fileName);
        mName = fileName.replace(".wav","");
        Log.d(TAG, "nName : "+mName);

    }

    public String getName() {
        return mName;
    }

    public String getAssetPath() {
        return mAssetPath;
    }
}
