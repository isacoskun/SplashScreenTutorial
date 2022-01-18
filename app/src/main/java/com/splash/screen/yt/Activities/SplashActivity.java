package com.splash.screen.yt.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.splash.screen.yt.Classess.FullScreen;
import com.splash.screen.yt.Classess.TypeWriter;
import com.splash.screen.yt.R;

public class SplashActivity extends AppCompatActivity {

    int SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** for full screen */
        FullScreen.setFullScreen(SplashActivity.this);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.splashView);
        Drawable drawable = imageView.getDrawable();
        Animatable animatable = (Animatable) drawable;
        animatable.start();

        Animation fadeIn = new AlphaAnimation(0,1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(SPLASH_SCREEN_DELAY);

        TypeWriter typeWriter = findViewById(R.id.splashText);
        typeWriter.setCharacterDelay(100);
        typeWriter.setAnimatedText(getString(R.string.app_name));
        typeWriter.startAnimation(fadeIn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startOtherActivity();
            }
        },SPLASH_SCREEN_DELAY);
    }

    private void startOtherActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onBackPressed(){
        //disable back keyboard for splash screen
    }
}