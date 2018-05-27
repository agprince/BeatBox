package com.agprincefu.andriod.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {

    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS=5;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context){

        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    public void play(Sound sound,float rate){
        Integer sounudId = sound.getSoundId();
        if(sounudId == null){
            return;
        }
        mSoundPool.play(sounudId,1.0f,1.0f,1,0,rate);
    }

    public void release(){
        mSoundPool.release();
    }

    private void loadSounds(){
        String [] fileNames ;
        try{
            fileNames = mAssets.list(SOUNDS_FOLDER);
            LogUtil.d("Found "+fileNames.length+" sounds");

        }catch (IOException e) {
            LogUtil.e("Could not list assets");
            e.printStackTrace();
            return;
        }
        for(String SoundName:fileNames){
            String path = SOUNDS_FOLDER+"/"+SoundName;
            Sound sound = new Sound(path);
            try {
                load(sound);
            } catch (IOException e) {
                e.printStackTrace();
                LogUtil.e("could not load sound"+fileNames);
            }
            mSounds.add(sound);

        }


    }
    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);

    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
