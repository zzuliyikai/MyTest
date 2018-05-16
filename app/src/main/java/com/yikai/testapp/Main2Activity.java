package com.yikai.testapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main2Activity extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mVideoView = findViewById(R.id.vv);

        //设置videoview播放的路径
        mVideoView.setVideoURI(Uri.parse("http://test.yungeshidai.com/material/9cc447d4001e84d650d1f4169d5bd33d.mp4"));

        //设置播放监听
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                setVolume(0.0f, mediaPlayer);
                //加载结束后开始播放，这行代码可以控制视频的播放。
                mVideoView.start();
            }
        });

    }

    public void setVolume(float volume, Object mediaPlayer) {
        try {
            Class mMediaPlayerClass = mediaPlayer.getClass();
            Method declaredMethod = mMediaPlayerClass.getDeclaredMethod("_setVolume", float.class, float.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(mediaPlayer, volume, volume);
        } catch (Exception e) {
            Log.d("yikai", e.getMessage());
        }
    }

}
