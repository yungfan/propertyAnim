package com.acj.myapplication;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.football);


        //   translateAni();

        //  rotateAni();

         scaleAni();
        //     alphaAni();

        //    aniSet();


        //  colorAni();

      //  colorAni2(Color.RED, Color.CYAN);


    }


    // 颜色渐变动画 这个要注意 无法直接采用上面的方法直接来设置 设置了也是无效的 这里涉及到给任意属性设置动画的问题
    // 所以这里采用了ValueAnimator,监听动画过程，自己来实现属性的改变
    private void colorAni2(int startColor, int endColor) {

        ValueAnimator valueAnimator = ValueAnimator.ofArgb(startColor, endColor);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                //找到Activity的默认View
                View view = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);

                //改变背景色
                view.setBackgroundColor((Integer) valueAnimator.getAnimatedValue());

            }
        });

        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }


    /**
     * 1.5秒 将图像向Y轴正方向移动500
     */
    private void translateAni() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "translationY", 500);

        animator.setDuration(1500);

        animator.start();
    }

    /**
     * 1.5秒 将图像沿Y从1.0放大到1.5，注意这里属性值可以为scaleX和scaleY，但设置scale是不行的
     */
    private void scaleAni() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "scaleY", 1, 1.5f);

        animator.setDuration(1500);

        animator.start();
    }

    /**
     * 1.5秒 将图像轴旋转360度
     */
    private void rotateAni() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "rotation", 0, 360);

        animator.setDuration(1500);

        animator.start();
    }

    /**
     * 1.5秒 将图像的透明度从1变到0.2
     */
    private void alphaAni() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(img, "alpha", 1, 0.2f);

        animator.setDuration(1500);

        animator.start();
    }

    /**
     * 属性集合 将上述动画集合起来一起放一遍
     */
    private void aniSet() {

        AnimatorSet set = new AnimatorSet();

        set.playTogether(
                ObjectAnimator.ofFloat(img, "translationY", 500),
                ObjectAnimator.ofFloat(img, "scaleY", 1, 1.5f),
                ObjectAnimator.ofFloat(img, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(img, "rotation", 0, 360),
                ObjectAnimator.ofFloat(img, "alpha", 1, 0.2f)
        );


        set.setDuration(3000);

        set.start();
    }

}
