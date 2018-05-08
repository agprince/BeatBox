package com.agprincefu.andriod.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "agtest";

    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){

        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds(){
        String [] fileNames ;
        try{
            fileNames = mAssets.list(SOUNDS_FOLDER);
            Log.d(TAG, "Found "+fileNames.length+" sounds");


            for(String SoundName:fileNames){

            }
        }catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            e.printStackTrace();
            return;
        }
        for(String SoundName:fileNames){
            String path = SOUNDS_FOLDER+"/"+SoundName;
            Sound sound = new Sound(path);
            mSounds.add(sound);

        }


    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
