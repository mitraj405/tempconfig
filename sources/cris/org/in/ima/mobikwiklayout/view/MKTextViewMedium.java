package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MKTextViewMedium extends TextView {
    public final Context a;

    public MKTextViewMedium(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        setLineSpacing(0.0f, 1.2f);
    }

    public MKTextViewMedium(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MKTextViewMedium(Context context) {
        this(context, (AttributeSet) null, 0);
    }
}
