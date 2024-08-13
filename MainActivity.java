package com.technical.coding.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView animationImage;
    Button animationButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationImage = findViewById(R.id.imageView_animation);
        animationButton = findViewById(R.id.button_animation);
        cancelButton = findViewById(R.id.button_cancel);


        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.sequence_animation);

        animation.setInterpolator(new OvershootInterpolator());

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "animation started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "animation ended", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        animationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animationImage.startAnimation(animation);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animationImage.clearAnimation();
            }
        });


    }




}