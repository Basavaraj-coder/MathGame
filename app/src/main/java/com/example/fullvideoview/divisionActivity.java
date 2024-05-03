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

import com.example.fullvideoview.databinding.ActivityDivisionBinding;

public class divisionActivity extends AppCompatActivity {

    ActivityDivisionBinding binding;
    private int score;
    private int scoreIncremented = 5;
    private int counter=0;
    private static int counter2=0;
    MediaPlayer mediaPlayer;
    private int temp1=0,temp2=0,temp3=0;
    private TextWatcher tw3,tw2,tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDivisionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mediaPlayer = MediaPlayer.create(this, R.raw.flute); // Use the correct audio file name without extension
        mediaPlayer.setLooping(true);

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

                    if (binding.textInputID1.getText().toString().isEmpty()) {
                        counter++;
                        //binding.textInputID1.setError("Error");
                    } else if (binding.textInputID2.getText().toString().isEmpty()) {
                        counter++;
                        //binding.textInputID2.setError("Error");
                    } else if (binding.textInputID3.getText().toString().isEmpty()) {
                        counter++;
                        //binding.textInputID3.setError("Error");
                    }
                    if(counter >0){
                        Toast.makeText(divisionActivity.this,"Please enter some values in Box",Toast.LENGTH_SHORT).show();
                    }
                    calulateScore();
                    loadStarImgs();
                }
            };
        }catch (Exception e ){
            e.printStackTrace();
        }
        binding.textInputID3.addTextChangedListener(tw3);
    }

    private void loadStarImgs() {
        counter2+=1;
        binding.imojimage.setVisibility(View.GONE);
        binding.star2image.setVisibility(View.GONE);
        binding.star3image.setVisibility(View.GONE);
        binding.congratulationstxt.setVisibility(View.GONE);

        if(counter2>=3) {
            Handler handler = new Handler();
            int delayMillis = 5000;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (score == 15) {
                        //binding.scrolid.setVisibility(View.INVISIBLE);

                        //  binding.rel.setBackgroundResource(R.drawable.blurimage);
                        binding.star3image.setVisibility(View.VISIBLE);
                        binding.congratulationstxt.setVisibility(View.VISIBLE);
                        //clearTextBoxes();

                    } else if (score < 15 && score > 5) {
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
            if (temp1 == 2) //this temp1,temp2,temp3,temp4 are nothing but taking input from user as solution
                score += scoreIncremented;
            if (temp2 == 2)
                score += scoreIncremented;

            if (temp3 == 5)
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