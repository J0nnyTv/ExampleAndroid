package com.example.exemple_aplicaciones;

import android.content.Context;

public class AspectRatioImageView extends androidx.appcompat.widget.AppCompatImageView {

    public Float ratio = 1f;

    public AspectRatioImageView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        if (width == 0 && height == 0){
            return;
        }

        if(width > 0){
            height = (int) (width * ratio);
        }
        else if(height > 0){
            width = (int) (height / ratio);
        }

        setMeasuredDimension(width, height);
    }
}
