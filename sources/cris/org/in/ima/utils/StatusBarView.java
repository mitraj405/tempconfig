package cris.org.in.ima.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

public class StatusBarView extends View {
    public int c;

    public StatusBarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        this.c = windowInsets.getSystemWindowInsetTop();
        return windowInsets.consumeSystemWindowInsets();
    }

    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), this.c);
    }

    public StatusBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSystemUiVisibility(UserMetadata.MAX_ATTRIBUTE_SIZE);
    }
}
