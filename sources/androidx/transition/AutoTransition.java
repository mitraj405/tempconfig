package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        f();
    }

    public final void f() {
        e(1);
        a(new Fade(2));
        a(new ChangeBounds());
        a(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }
}
