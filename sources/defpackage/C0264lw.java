package defpackage;

import android.graphics.Path;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: lw  reason: default package and case insensitive filesystem */
/* compiled from: ShapeContent */
public final class C0264lw implements dp, C0335t2.a {
    public final Ej a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f3095a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final sw f3096a;

    /* renamed from: a  reason: collision with other field name */
    public final C0422zD f3097a = new C0422zD();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3098a;
    public boolean b;

    public C0264lw(Ej ej, C0359v2 v2Var, vw vwVar) {
        vwVar.getClass();
        this.f3098a = vwVar.f3387a;
        this.a = ej;
        sw swVar = new sw(vwVar.f3385a.a);
        this.f3096a = swVar;
        v2Var.g(swVar);
        swVar.a(this);
    }

    public final Path b() {
        boolean z = this.b;
        Path path = this.f3095a;
        if (z) {
            return path;
        }
        path.reset();
        if (this.f3098a) {
            this.b = true;
            return path;
        }
        Path path2 = (Path) this.f3096a.f();
        if (path2 == null) {
            return path;
        }
        path.set(path2);
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f3097a.b(path);
        this.b = true;
        return path;
    }

    public final void d(List<V6> list, List<V6> list2) {
        ArrayList arrayList = null;
        int i = 0;
        while (true) {
            ArrayList arrayList2 = (ArrayList) list;
            if (i < arrayList2.size()) {
                V6 v6 = (V6) arrayList2.get(i);
                if (v6 instanceof MA) {
                    MA ma = (MA) v6;
                    if (ma.a == 1) {
                        ((List) this.f3097a.f3457a).add(ma);
                        ma.e(this);
                        i++;
                    }
                }
                if (v6 instanceof uw) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((uw) v6);
                }
                i++;
            } else {
                this.f3096a.f3280a = arrayList;
                return;
            }
        }
    }

    public final void f() {
        this.b = false;
        this.a.invalidateSelf();
    }
}
