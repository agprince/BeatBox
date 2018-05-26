package com.agprincefu.andriod.beatbox;

import android.util.Log;

public class Sound {

    private String mName;
    private String mAssetPath;
    private Integer mSoundId;

    public Sound(String assetPath){

        mAssetPath = assetPath;
        String [] components = mAssetPath.split("/");
        String fileName = components[components.length-1];
        //LogUtil.d("fileName : "+fileName);
        mName = fileName.replace(".wav","");
        //LogUtil.d( "nName : "+mName);

    }

    public String getName() {
        return mName;
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
