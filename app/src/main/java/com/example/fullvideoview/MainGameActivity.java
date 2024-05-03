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

import com.example.fullvideoview.databinding.ActivityMainGameBinding;

public class MainGameActivity extends AppCompatActivity {
    ActivityMainGameBinding binding;
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
        binding = ActivityMainGameBinding.inflate(getLayoutInflater());
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

//    private void clearTextBoxes() {
//        try {
//
//
//            binding.textInputID1.setText("");
//            binding.textInputID2.setText("");
//            binding.textInputID3.setText("");
//            binding.textInputID4.setText("");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

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

//    private void detectEmptEdtitext() {
//        String input1 = binding.textInputID1.getText().toString();
//        String input2 = binding.textInputID2.getText().toString();
//        String input3= binding.textInputID3.getText().toString();
//        String input4 = binding.textInputID4.getText().toString();
//        /*
//        * This method is used to detect empty spaces and get values from text-box and increase counter
//        * */
//        try{
//            if(input1.isEmpty()){
//                binding.textInputID1.setError("invalid");
//                counter+=1;
//            }else {
//                temp1=Integer.parseInt(binding.textInputID1.getText().toString());
//            }
//            if(input2.isEmpty()){
//                binding.textInputID2.setError("invalid");
//                counter+=1;
//            }else{
//                temp2 = Integer.parseInt(binding.textInputID2.getText().toString());
//            }
//            if(input3.isEmpty()){
//                binding.textInputID3.setError("invalid");
//                counter+=1;
//            } else{
//                temp3 = Integer.parseInt(binding.textInputID3.getText().toString());
//            }
//            if (input4.isEmpty()) {
//                binding.textInputID4.setError("invalid");
//                counter+=1;
//            }else{
//                temp4 = Integer.parseInt(binding.textInputID4.getText().toString());
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        calulateScore();
//        if(counter==0){
//           // startActivity(new Intent(MainGameActivity.this,));
//        }
//    }

    private void calulateScore() {
        /*
        * This method increments score variable by 5 if user clicks correct addition ans.
        * and add it back to score on UI.
        * */
        score=0;
        try {
            if (temp1 == 4)
                score += scoreIncremented;
            if (temp2 == 5)
                score += scoreIncremented;

            if (temp3 == 3)
                score += scoreIncremented;

            if (temp4 == 4)
                score += scoreIncremented;

            String scoreStr = String.valueOf(score);

            binding.scorevalue.setText(scoreStr);

        }catch (Exception e){
            e.printStackTrace();
        }
//        Handler handler = new Handler();
//        int delayMilis = 2000;
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },delayMilis);
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
}