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

        //  scaleAni();
        //     alphaAni();

        //    aniSet();


        colorAni();
    }

    /**
     * 动态添加带动画的视图
     */
    private void colorAni() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        AnimationView animationView = new AnimationView(this);
        relativeLayout.addView(animationView);
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


    /**
     * 自定义一个显示颜色动画的视图
     */
    class AnimationView extends View {
        public AnimationView(Context context) {
            super(context);
            ValueAnimator animator = ObjectAnimator.ofInt(MainActivity.this, "backgroundColor", Color.RED, Color.CYAN);
            animator.setEvaluator(new ArgbEvaluator()); //添加颜色估值器 否则动画过程会一直闪
            animator.setTarget(this); //设置动画的目标对象 不设置无效果
            animator.setDuration(3000);
            animator.start();
        }

    }
}
