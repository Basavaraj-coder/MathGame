package com.example.fullvideoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fullvideoview.databinding.ActivityMemoryGameBinding;

public class memoryGameActivity extends AppCompatActivity {

    ActivityMemoryGameBinding binding;
    int score = 0;
    MediaPlayer mp3;
    private int a[]=new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemoryGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mp3 = MediaPlayer.create(this,R.raw.loooop);
        mp3.setLooping(true);

        int delayMillis = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        binding.applebtn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.bananabtn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.mangobtn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.chikoobtn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.watermelonbtn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.watermelon2btn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.chikoo2btn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.mango2btn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.banana2btn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
//                        binding.applebtn.setScaleType(ImageButton.ScaleType.FIT_CENTER);
                        //binding.banana2btn.setScaleType(ImageButton.ScaleType.FIT_CENTER);

                        hideImages();
                    }
                });
            }
        },delayMillis);

        binding.applebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[0]=1;
            }
        });

        binding.mangobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[1]=2;
            }
        });

        binding.bananabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[2]=3;
            }
        });

        binding.chikoobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[3]=4;
            }
        });

        binding.mango2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[4]=2;
            }
        });

        binding.banana2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[5]=3;
            }
        });

        binding.watermelonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[6]=5;
            }
        });
        binding.chikoo2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[7]=4;
            }
        });

        binding.watermelon2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[8]=5;
            }
        });

        binding.apple2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[9]=1;
            }
        });

        binding.donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });

        binding.resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int delayMillis = 500;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

//                                binding.applebtn.setImageResource(R.drawable.greyimage);
//                                binding.bananabtn.setImageResource(R.drawable.greyimage);
//                                binding.mangobtn.setImageResource(R.drawable.greyimage);
//                                binding.chikoobtn.setImageResource(R.drawable.greyimage);
//                                binding.watermelonbtn.setImageResource(R.drawable.greyimage);
//                                binding.watermelon2btn.setImageResource(R.drawable.greyimage);
//                                binding.chikoo2btn.setImageResource(R.drawable.greyimage);
//                                binding.mango2btn.setImageResource(R.drawable.greyimage);
//                                binding.banana2btn.setImageResource(R.drawable.greyimage);
//                                binding.apple2btn.setImageResource(R.drawable.greyimage);
                                hideImages();
                            }
                        });
                    }
                },delayMillis);

            }
        });
    }

    private void hideImages() {
        binding.applebtn.setImageResource(R.drawable.greyimage);
        binding.bananabtn.setImageResource(R.drawable.greyimage);
        binding.mangobtn.setImageResource(R.drawable.greyimage);
        binding.chikoobtn.setImageResource(R.drawable.greyimage);
        binding.watermelonbtn.setImageResource(R.drawable.greyimage);
        binding.watermelon2btn.setImageResource(R.drawable.greyimage);
        binding.chikoo2btn.setImageResource(R.drawable.greyimage);
        binding.mango2btn.setImageResource(R.drawable.greyimage);
        binding.banana2btn.setImageResource(R.drawable.greyimage);
        binding.apple2btn.setImageResource(R.drawable.greyimage);
    }

    private void calculateResult() {
        int delay = 1000;
        if(a[0]==1 && a[9]==1){ //apple
            score = 2;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.applebtn.setImageResource(R.drawable.appleimg);
                            binding.apple2btn.setImageResource(R.drawable.appleimg);
                        }
                    });
                }
            },delay);
        }
        if(a[1]==2 && a[4]==2){ //mango
            score = score + 2;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.mangobtn.setImageResource(R.drawable.mangoimg);
                            binding.mango2btn.setImageResource(R.drawable.mangoimg);
                        }
                    });
                }
            },delay);
        }
        if(a[2]==3 && a[5]==3){ //banana
            score = score+2;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.bananabtn.setImageResource(R.drawable.bananaimg);
                            binding.banana2btn.setImageResource(R.drawable.bananaimg);
                        }
                    });
                }
            },delay);

        }
        if(a[3]==4 && a[7]==4){//chikoo
            score = score+2;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.chikoobtn.setImageResource(R.drawable.chikooimg);
                            binding.chikoo2btn.setImageResource(R.drawable.chikooimg);
                        }
                    });
                }
            },delay);

        }
        if(a[6]==5 && a[8]==4){//watermelon
            score=score+2;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.watermelonbtn.setImageResource(R.drawable.watermeloncutimg);
                            binding.watermelon2btn.setImageResource(R.drawable.watermeloncutimg);
                        }
                    });
                }
            },delay);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp3.pause();
        startActivity(new Intent(this,selectLevelActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp3.stop();
        mp3.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp3.start();
    }
}
