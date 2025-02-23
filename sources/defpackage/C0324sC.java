package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* renamed from: sC  reason: default package and case insensitive filesystem */
/* compiled from: ViewGroup.kt */
public final class C0324sC implements Iterator<View> {
    public final /* synthetic */ ViewGroup a;
    public int c;

    public C0324sC(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public final boolean hasNext() {
        if (this.c < this.a.getChildCount()) {
            return true;
        }
        return false;
    }

    public final Object next() {
        int i = this.c;
        this.c = i + 1;
        View childAt = this.a.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void remove() {
        int i = this.c - 1;
        this.c = i;
        this.a.removeViewAt(i);
    }
}
