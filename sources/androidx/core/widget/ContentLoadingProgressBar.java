package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    public static final /* synthetic */ int c = 0;
    public final C0088Dd a;

    /* renamed from: a  reason: collision with other field name */
    public final gA f1851a;

    public ContentLoadingProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.a);
        removeCallbacks(this.f1851a);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.a);
        removeCallbacks(this.f1851a);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = new C0088Dd(this, 4);
        this.f1851a = new gA(this, 1);
    }
}
