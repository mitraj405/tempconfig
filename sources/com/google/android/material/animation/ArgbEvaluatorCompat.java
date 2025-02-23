package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import com.google.firebase.perf.util.Constants;

public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    private static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    public Integer evaluate(float f, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f2 = ((float) ((intValue >> 24) & Constants.MAX_HOST_LENGTH)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & Constants.MAX_HOST_LENGTH)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & Constants.MAX_HOST_LENGTH)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & Constants.MAX_HOST_LENGTH)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & Constants.MAX_HOST_LENGTH)) / 255.0f), 2.2d);
        float a = lf.a(((float) ((intValue2 >> 24) & Constants.MAX_HOST_LENGTH)) / 255.0f, f2, f, f2);
        float a2 = lf.a(pow4, pow, f, pow);
        float a3 = lf.a((float) Math.pow((double) (((float) ((intValue2 >> 8) & Constants.MAX_HOST_LENGTH)) / 255.0f), 2.2d), pow2, f, pow2);
        float a4 = lf.a((float) Math.pow((double) (((float) (intValue2 & Constants.MAX_HOST_LENGTH)) / 255.0f), 2.2d), pow3, f, pow3);
        int round = Math.round(((float) Math.pow((double) a2, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow((double) a4, 0.45454545454545453d)) * 255.0f) | round | (Math.round(a * 255.0f) << 24) | (Math.round(((float) Math.pow((double) a3, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
