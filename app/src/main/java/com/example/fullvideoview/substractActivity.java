package com.example.fullvideoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.fullvideoview.databinding.ActivityMainGameBinding;
import com.example.fullvideoview.databinding.ActivitySubstractBinding;

public class substractActivity extends AppCompatActivity {

    ActivitySubstractBinding binding;
    private int score;
    private int scoreIncremented = 5;
    private int counter=0;
    private static int counter2=0;
    MediaPlayer mediaPlayer;
    private int temp1=0,temp2=0,temp3=0,temp4=0;
    private TextWatcher tw4,tw3,tw2,tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySubstractBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mediaPlayer = MediaPlayer.create(this, R.raw.flute); // Use the correct audio file name without extension
        mediaPlayer.setLooping(true); // To make the music loop

        getValueFromEditext();
    }

    private void getValueFromEditext() {
        try {
            tw = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(editable.length()>0)
                        temp1 = Integer.parseInt(editable.toString());
                    else
                        temp1 = 0;
                    calulateScore();
                    loadStarImgs();
                }
            };
        }catch (Exception e){
            e.printStackTrace();
        }
        binding.textInputID1.addTextChangedListener(tw);

        try {
            tw2 = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(editable.length()>0)
                        temp2 = Integer.parseInt(editable.toString());
                    else
                        temp2 = 0;
                    calulateScore();
                    loadStarImgs();
                }
            };
        }catch (Exception e){
            e.printStackTrace();
        }
        binding.textInputID2.addTextChangedListener(tw2);

        try {
            tw3 = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(editable.length()>0)
                        temp3 = Integer.parseInt(editable.toString());
                    else
                        temp3 = 0;
                    calulateScore();
                    loadStarImgs();
                }
            };
        }catch (Exception e ){
            e.printStackTrace();
        }
        binding.textInputID3.addTextChangedListener(tw3);

        try {
            tw4 = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if(editable.length()>0)
                        temp4 = Integer.parseInt(editable.toString());
                    else
                        temp4 = 0;

                    if (binding.textInputID1.getText().toString().isEmpty()) {
                        counter++;
                        //binding.textInputID1.setError("Error");
                    } else if (binding.textInputID2.getText().toString().isEmpty()) {
                        counter++;
                        //binding.textInputID2.setError("Error");
                    } else if (binding.textInputID3.getText().toString().isEmpty()) {
                        counter++;
                        //binding.textInputID3.setError("Error");
                    } else if (binding.textInputID4.getText().toString().isEmpty()) {
                        counter++;
                        //binding.textInputID4.setError("Error");
                    }
                    if(counter >0){
                        Toast.makeText(substractActivity.this,"Please enter some values in Box",Toast.LENGTH_SHORT).show();
                    }
                    calulateScore();
                    loadStarImgs();
                    // clearTextBoxes();

                }
            };
        }catch (Exception e){
            e.printStackTrace();
        }
        binding.textInputID4.addTextChangedListener(tw4);

    }

    private void loadStarImgs() {
        counter2+=1;
        binding.imojimage.setVisibility(View.GONE);
        binding.star2image.setVisibility(View.GONE);
        binding.star3image.setVisibility(View.GONE);
        binding.congratulationstxt.setVisibility(View.GONE);

        if(counter2>=4) {
            Handler handler = new Handler();
            int delayMillis = 5000;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (score == 20) {
                        //binding.scrolid.setVisibility(View.INVISIBLE);

                        //  binding.rel.setBackgroundResource(R.drawable.blurimage);
                        binding.star3image.setVisibility(View.VISIBLE);
                        binding.congratulationstxt.setVisibility(View.VISIBLE);
                        //clearTextBoxes();

                    } else if (score < 20 && score > 10) {
                        //binding.rel.setBackgroundResource(R.drawable.blurimage);
                        binding.star2image.setVisibility(View.VISIBLE);

                        //clearTextBoxes();
                    } else {
                        //  binding.rel.setBackgroundResource(R.drawable.blurimage);
                        binding.imojimage.setVisibility(View.VISIBLE);

                        //clearTextBoxes();
//                        binding.star2image.setVisibility(View.VISIBLE);
//                        binding.star1image.setVisibility(View.VISIBLE);
                    }

                }
            }, delayMillis);
        }
    }
    private void calulateScore() {
        /*
         * This method increments score variable by 5 if user clicks correct addition ans.
         * and add it back to score on UI.
         * */
        score=0;
        try {
            if (temp1 == 2)
                score += scoreIncremented;
            if (temp2 == 1)
                score += scoreIncremented;

            if (temp3 == 1)
                score += scoreIncremented;

            if (temp4 == 0)
                score += scoreIncremented;

            String scoreStr = String.valueOf(score);

            binding.scorevalue.setText(scoreStr);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,selectLevelActivity.class));
        mediaPlayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        mediaPlayer.pause();
        super.onPause();
    }
}