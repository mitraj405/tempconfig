package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public final void j(ConstraintLayout constraintLayout) {
        i(constraintLayout);
    }

    public final void n(AttributeSet attributeSet) {
        super.n(attributeSet);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    public final void q() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f1627a.R(0);
        layoutParams.f1627a.O(0);
    }

    public void setElevation(float f) {
        super.setElevation(f);
        h();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        h();
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
