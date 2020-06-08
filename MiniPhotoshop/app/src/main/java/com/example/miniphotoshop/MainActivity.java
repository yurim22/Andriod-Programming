package com.example.miniphotoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray, ibBlur, ibEmbos;
    MyGraphicView graphicView;
    static  float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static  boolean blur = false;
    static boolean embos = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView) new MyGraphicView(this);
        pictureLayout.addView(graphicView);
        clickIcons();
    }
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX,cenY);
            canvas.rotate(angle, cenX, cenY);
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, null);

            Paint paint = new Paint();
            float[] array = { color,0,0,0,0,
            0,color,0,0,0,
            0,0,color,0,0,
            0,0,0,1,0};
            ColorMatrix cm = new ColorMatrix(array);

            if(blur ==true) {
                BlurMaskFilter bMask;
                bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(bMask);
            }
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            if(embos ==true) {
                EmbossMaskFilter eMask;
                eMask = new EmbossMaskFilter(new float[] {3,3,3}, 0.5f, 5, 10);
                paint.setColor(Color.GRAY);
                paint.setMaskFilter(eMask);
            }

            canvas.drawBitmap(picture, cenX, cenY, paint);

            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }

    private void clickIcons() {
        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        ibZoomin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });
        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        ibZoomout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });
        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });
        ibBright = (ImageButton) findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });
        ibDark = (ImageButton) findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });
        ibBlur = (ImageButton) findViewById(R.id.ibBlur);
        ibBlur.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (blur == true) blur = false;
                else blur = true;
                graphicView.invalidate();
            }
        });
        ibEmbos = (ImageButton) findViewById(R.id.ibEmbos);
        ibEmbos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (embos == true) embos = false;
                else embos = true;
                graphicView.invalidate();
            }
        });

    }
}
