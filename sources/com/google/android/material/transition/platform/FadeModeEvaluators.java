package com.google.android.material.transition.platform;

import com.google.firebase.perf.util.Constants;

class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp((int) Constants.MAX_HOST_LENGTH, 0, f2, f3, f), TransitionUtils.lerp(0, (int) Constants.MAX_HOST_LENGTH, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.endOnTop(Constants.MAX_HOST_LENGTH, TransitionUtils.lerp(0, (int) Constants.MAX_HOST_LENGTH, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp((int) Constants.MAX_HOST_LENGTH, 0, f2, f3, f), Constants.MAX_HOST_LENGTH);
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            float a = lf.a(f3, f2, f4, f2);
            return FadeModeResult.startOnTop(TransitionUtils.lerp((int) Constants.MAX_HOST_LENGTH, 0, f2, a, f), TransitionUtils.lerp(0, (int) Constants.MAX_HOST_LENGTH, a, f3, f));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i, boolean z) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return CROSS;
                }
                if (i == 3) {
                    return THROUGH;
                }
                throw new IllegalArgumentException(lf.h("Invalid fade mode: ", i));
            } else if (z) {
                return OUT;
            } else {
                return IN;
            }
        } else if (z) {
            return IN;
        } else {
            return OUT;
        }
    }
}
