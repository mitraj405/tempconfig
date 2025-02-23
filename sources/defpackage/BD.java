package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: BD  reason: default package */
/* compiled from: WidgetGroup */
public final class BD {
    public static int d;
    public final int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<ConstraintWidget> f46a = new ArrayList<>();
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<a> f47b = null;
    public int c = -1;

    /* renamed from: BD$a */
    /* compiled from: WidgetGroup */
    public class a {
        public a(ConstraintWidget constraintWidget, ei eiVar) {
            new WeakReference(constraintWidget);
            ConstraintAnchor constraintAnchor = constraintWidget.f1348a;
            eiVar.getClass();
            ei.n(constraintAnchor);
            ei.n(constraintWidget.f1363b);
            ei.n(constraintWidget.f1371c);
            ei.n(constraintWidget.f1376d);
            ei.n(constraintWidget.f1379e);
        }
    }

    public BD(int i) {
        int i2 = d;
        d = i2 + 1;
        this.a = i2;
        this.b = i;
    }

    public final void a(ArrayList<BD> arrayList) {
        int size = this.f46a.size();
        if (this.c != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                BD bd = arrayList.get(i);
                if (this.c == bd.a) {
                    c(this.b, bd);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(ei eiVar, int i) {
        int i2;
        int i3;
        ArrayList<ConstraintWidget> arrayList = this.f46a;
        if (arrayList.size() == 0) {
            return 0;
        }
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).f1349a;
        eiVar.s();
        constraintWidgetContainer.e(eiVar, false);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList.get(i4).e(eiVar, false);
        }
        if (i == 0 && constraintWidgetContainer.E > 0) {
            b.a(constraintWidgetContainer, eiVar, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.F > 0) {
            b.a(constraintWidgetContainer, eiVar, arrayList, 1);
        }
        try {
            eiVar.p();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f47b = new ArrayList<>();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            this.f47b.add(new a(arrayList.get(i5), eiVar));
        }
        if (i == 0) {
            i2 = ei.n(constraintWidgetContainer.f1348a);
            i3 = ei.n(constraintWidgetContainer.f1371c);
            eiVar.s();
        } else {
            i2 = ei.n(constraintWidgetContainer.f1363b);
            i3 = ei.n(constraintWidgetContainer.f1376d);
            eiVar.s();
        }
        return i3 - i2;
    }

    public final void c(int i, BD bd) {
        Iterator<ConstraintWidget> it = this.f46a.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            int i2 = bd.a;
            if (hasNext) {
                ConstraintWidget next = it.next();
                ArrayList<ConstraintWidget> arrayList = bd.f46a;
                if (!arrayList.contains(next)) {
                    arrayList.add(next);
                }
                if (i == 0) {
                    next.z = i2;
                } else {
                    next.A = i2;
                }
            } else {
                this.c = i2;
                return;
            }
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        int i = this.b;
        if (i == 0) {
            str = "Horizontal";
        } else if (i == 1) {
            str = "Vertical";
        } else if (i == 2) {
            str = "Both";
        } else {
            str = "Unknown";
        }
        sb.append(str);
        sb.append(" [");
        String k = lf.k(sb, this.a, "] <");
        Iterator<ConstraintWidget> it = this.f46a.iterator();
        while (it.hasNext()) {
            StringBuilder n = lf.n(k, " ");
            n.append(it.next().f1365b);
            k = n.toString();
        }
        return C1058d.z(k, " >");
    }
}
