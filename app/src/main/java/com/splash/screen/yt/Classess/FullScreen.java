package com.splash.screen.yt.Classess;

import android.app.Activity;
import android.view.View;

public class FullScreen {
    public static void setFullScreen(Activity activity){
        /** for full screen */
        View decorView = activity.getWindow().getDecorView();
        int uiOptions =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View. SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
