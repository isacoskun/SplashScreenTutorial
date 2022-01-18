package com.splash.screen.yt.Classess;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.logging.LogRecord;

public class TypeWriter extends androidx.appcompat.widget.AppCompatTextView {

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 150;

    public TypeWriter(Context context) {
        super(context);
    }

    public TypeWriter(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    private final Handler handler = new Handler();

    private final Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0,mIndex++));

            if (mIndex <= mText.length()){
                handler.postDelayed(characterAdder,mDelay);
            }
        }
    };

    public void setAnimatedText(CharSequence text){
        mText = text;
        mIndex = 0;

        setText("");
        handler.removeCallbacks(characterAdder);
        handler.postDelayed(characterAdder,mDelay);
    }

    public void setCharacterDelay(long m){
        mDelay = m;
    }
}
