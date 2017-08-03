package com.fasttech.music;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dell on 7/19/2017.
 */

public class AnimationsUtil {
    public static void animate(RecyclerView.ViewHolder holder,boolean goesDown){
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true ? 200 : -200,0);
        animatorTranslateY.setDuration(1500);

        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView,"translationX",-30,30,-30,30,-20,20,-10,10,0); //PROVIDES ZIG-ZAG MOVEMENT
        animatorTranslateX.setDuration(1500);

        animatorSet.playTogether(animatorTranslateY,animatorTranslateX);
        animatorSet.start();
    }
}
