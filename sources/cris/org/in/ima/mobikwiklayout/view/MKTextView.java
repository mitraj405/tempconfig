package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MKTextView extends TextView {
    public MKTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLineSpacing(0.0f, 1.2f);
    }

    public boolean isInEditMode() {
        return true;
    }

    public MKTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MKTextView(Context context) {
        this(context, (AttributeSet) null, 0);
    }
}
