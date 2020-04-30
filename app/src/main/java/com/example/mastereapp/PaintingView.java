package com.example.mastereapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PaintingView extends View {

    private Paint paint;
    private Canvas canvas;

    public PaintingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs)
    {
        if (attrs != null)
        {
            // récupération d'un tableau d'arguments :
            TypedArray arguments = context.obtainStyledAttributes(attrs,
                    R.styleable.MaVue);

            // lecture de chaque argument :
            int color = arguments.getColor(R.styleable.MaVue_color, 0);

            paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            // IMPORTANT !! ne pas oublier :
            arguments.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
