package com.example.fullvideoview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.fullvideoview.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
  //  VideoView videoView;
    private MediaPlayer mediaPlayer;
    int vidResourceId = R.raw.addition;

    Button btnskip,btnReload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        loadVideo();

        loadSkipButton();
        loadReloadBtn();
    }

    private void loadVideo() {
        binding.textureView.setVisibility(View.VISIBLE);
        replayVideo();

        try {
            binding.textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
                @Override
                public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i, int i1) {
                    /*
                     * Get the resource identifier for your video file. You can do this by using the R.raw resource identifier:
                     * */
                    try {
                        Surface surface = new Surface(surfaceTexture);

                            mediaPlayer = new MediaPlayer();
                            mediaPlayer.setSurface(surface);
                            try {
                                mediaPlayer.setDataSource(getResources().openRawResourceFd(vidResourceId));
                                try {
                                    mediaPlayer.prepare();
                                    mediaPlayer.start();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("error in mediaPlayer.prepare ");
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i, int i1) {

                }

                @Override
                public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
                    return true;
                }

                @Override
                public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

//        binding.btnReload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mediaPlayer!=null){
//                    mediaPlayer.stop();
//                    mediaPlayer
//                }
//            }
//        });

//        Handler handler = new Handler();
//        int delaymilis = 2000;
//        handler.postDelayed(new Runnable() {
//            //we preferred Handler over Thread.sleep() becos Handler do have postDelayed()
//            /**
//             * PD() doesn't stops mainUi Thread, mainUI stops it will result in notresponding.
//             * Thread.sleep does.
//             * */
//            @Override
//            public void run() {
//
//            }
//
//        },delaymilis);
    }

    private void replayVideo() {
        /*
        * This method is to replay video after clicking reload label from UI.
        * */
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.reset();
            try{
                mediaPlayer.setDataSource(getResources().openRawResourceFd(vidResourceId));
                mediaPlayer.prepare();
                mediaPlayer.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void loadSkipButton() {
        btnskip = findViewById(R.id.btnSkip);
        btnskip.setVisibility(View.VISIBLE);
        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.release();
                moveToMainGameAcitvity();
            }
        });
//        Handler handler = new Handler();
//        //we preferred Handler over Thread.sleep() becos Handler do have postDelayed()
//        /**
//         * PD() doesn't stops mainUi Thread, mainUI stops it will result in notresponding.
//         * Thread.sleep does.
//         * */
//        int delayMilis = 7000;
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//
//            }
//        },delayMilis);
    }
    private void loadReloadBtn(){
        Handler obj = new Handler();
        int delayMilis = 15000;
        obj.postDelayed(new Runnable() {
            @Override
            public void run() {

                btnReload = findViewById(R.id.buttonReload);
                btnReload.setVisibility(View.VISIBLE);
                btnReload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        loadVideo();
                        
                    }
                });
            }
        },delayMilis);
    }

    private void moveToMainGameAcitvity() {
        Intent i = new Intent(this, MainGameActivity.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }

    @Override
    public void onBackPressed() {
        // Restore the previous orientation
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

/*
* video view inside Handler class
*         videoView = findViewById(R.id.videoView);
                videoView.setVisibility(View.VISIBLE);
                videoView.setVideoURI(Uri.parse("android.resource://com.example.fullvideoview/raw/addition"));
                videoView.start();
                hideSystemUI();

//                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    @Override
//                    public void onPrepared(MediaPlayer mp) {
//                        // Set the VideoView to fullscreen
//                        videoView.setLayoutParams(new RelativeLayout.LayoutParams(
//                                RelativeLayout.LayoutParams.MATCH_PARENT,
//                                RelativeLayout.LayoutParams.MATCH_PARENT
//                        ));
//                    }
//                });
*
*             private void hideSystemUI() {  //anonymous method of hideSystemUI but no use of this method
* this method changes nothing
                View decorView = getWindow().getDecorView();
                decorView.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                );
            }

* */