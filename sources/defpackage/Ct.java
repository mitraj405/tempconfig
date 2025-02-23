package defpackage;

import android.content.Context;
import android.view.LayoutInflater;

/* renamed from: Ct  reason: default package */
/* compiled from: ResourceCursorAdapter */
public abstract class Ct extends F7 {
    public final LayoutInflater a;
    public final int d;
    public final int e;

    @Deprecated
    public Ct(Context context, int i) {
        super(context);
        this.e = i;
        this.d = i;
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
