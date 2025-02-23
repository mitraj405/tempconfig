package com.google.android.material.transition;

import android.graphics.RectF;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements ShapeAppearanceModel.CornerSizeUnaryOperator {
    public final /* synthetic */ RectF a;

    public /* synthetic */ a(RectF rectF) {
        this.a = rectF;
    }

    public final CornerSize apply(CornerSize cornerSize) {
        return RelativeCornerSize.createFromCornerSize(this.a, cornerSize);
    }
}
