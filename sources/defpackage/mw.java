package defpackage;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mw  reason: default package */
/* compiled from: ShapeData */
public final class mw {
    public PointF a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3107a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3108a;

    public mw(PointF pointF, boolean z, List<E7> list) {
        this.a = pointF;
        this.f3108a = z;
        this.f3107a = new ArrayList(list);
    }

    public final void a(float f, float f2) {
        if (this.a == null) {
            this.a = new PointF();
        }
        this.a.set(f, f2);
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.f3107a.size() + "closed=" + this.f3108a + '}';
    }

    public mw() {
        this.f3107a = new ArrayList();
    }
}
