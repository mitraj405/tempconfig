package defpackage;

import android.graphics.Typeface;
import android.widget.TextView;

/* renamed from: t1  reason: default package */
/* compiled from: AppCompatTextHelper */
public final class t1 implements Runnable {
    public final /* synthetic */ Typeface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TextView f3283a;
    public final /* synthetic */ int c;

    public t1(TextView textView, Typeface typeface, int i) {
        this.f3283a = textView;
        this.a = typeface;
        this.c = i;
    }

    public final void run() {
        this.f3283a.setTypeface(this.a, this.c);
    }
}
