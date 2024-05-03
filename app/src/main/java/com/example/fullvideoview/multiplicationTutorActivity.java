package com.example.fullvideoview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;

import com.example.fullvideoview.databinding.ActivityMultiplicationTutorBinding;

import java.io.IOException;

public class multiplicationTutorActivity extends AppCompatActivity {
    ActivityMultiplicationTutorBinding binding;

    private MediaPlayer mediaPlayer;
    int vidResourceId = R.raw.multiplication;
    Button btnskip,btnReload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMultiplicationTutorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadVideo();

        loadSkipButton();
        loadReloadBtn();
    }

    private void loadVideo() {
        binding.textureView.setVisibility(View.VISIBLE);

        replayVideo(); //if user click on reload from UI than only this () gets executes
        /*
         * in above replayVideo() it is checking that mediaPlayer is consuming any resources or not
         * if it is consuming than free/stop/release it and start again from start.
         * */

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
//                mediaPlayer.stop();
//                mediaPlayer.release();
                moveToMultiplicationtActivity();
            }
        });
    }
    private void moveToMultiplicationtActivity() {
        startActivity(new Intent(this, multiplicationActivity.class));
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
    @Override
    protected void onPause() {

        super.onPause();
        mediaPlayer.pause();
    }



    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        mediaPlayer.stop();
        super.onStop();
    }

}