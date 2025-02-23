package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* renamed from: rC  reason: default package and case insensitive filesystem */
/* compiled from: ViewGroup.kt */
public final class C0313rC extends C0595Mh implements Function1<View, Iterator<? extends View>> {
    public static final C0313rC a = new C0313rC();

    public C0313rC() {
        super(1);
    }

    public final Object invoke(Object obj) {
        ViewGroup viewGroup;
        View view = (View) obj;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            return new C0324sC(viewGroup);
        }
        return null;
    }
}
