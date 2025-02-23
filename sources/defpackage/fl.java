package defpackage;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
/* renamed from: fl  reason: default package */
/* compiled from: MergePathsContent */
public final class fl implements dp, C0090Ee {
    public final Path a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final el f2941a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f2942a = new ArrayList();
    public final Path b = new Path();
    public final Path c = new Path();

    public fl(el elVar) {
        elVar.getClass();
        this.f2941a = elVar;
    }

    public final Path b() {
        Path path = this.c;
        path.reset();
        el elVar = this.f2941a;
        if (elVar.f2910a) {
            return path;
        }
        int V = xx.V(elVar.a);
        if (V == 0) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.f2942a;
                if (i >= arrayList.size()) {
                    break;
                }
                path.addPath(((dp) arrayList.get(i)).b());
                i++;
            }
        } else if (V == 1) {
            e(Path.Op.UNION);
        } else if (V == 2) {
            e(Path.Op.REVERSE_DIFFERENCE);
        } else if (V == 3) {
            e(Path.Op.INTERSECT);
        } else if (V == 4) {
            e(Path.Op.XOR);
        }
        return path;
    }

    public final void d(List<V6> list, List<V6> list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2942a;
            if (i < arrayList.size()) {
                ((dp) arrayList.get(i)).d(list, list2);
                i++;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    public final void e(Path.Op op) {
        Matrix matrix;
        Matrix matrix2;
        Path path = this.b;
        path.reset();
        Path path2 = this.a;
        path2.reset();
        ArrayList arrayList = this.f2942a;
        for (int size = arrayList.size() - 1; size >= 1; size--) {
            dp dpVar = (dp) arrayList.get(size);
            if (dpVar instanceof Y6) {
                Y6 y6 = (Y6) dpVar;
                ArrayList arrayList2 = (ArrayList) y6.g();
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Path b2 = ((dp) arrayList2.get(size2)).b();
                    HA ha = y6.f700a;
                    if (ha != null) {
                        matrix2 = ha.d();
                    } else {
                        matrix2 = y6.f702a;
                        matrix2.reset();
                    }
                    b2.transform(matrix2);
                    path.addPath(b2);
                }
            } else {
                path.addPath(dpVar.b());
            }
        }
        int i = 0;
        dp dpVar2 = (dp) arrayList.get(0);
        if (dpVar2 instanceof Y6) {
            Y6 y62 = (Y6) dpVar2;
            List<dp> g = y62.g();
            while (true) {
                ArrayList arrayList3 = (ArrayList) g;
                if (i >= arrayList3.size()) {
                    break;
                }
                Path b3 = ((dp) arrayList3.get(i)).b();
                HA ha2 = y62.f700a;
                if (ha2 != null) {
                    matrix = ha2.d();
                } else {
                    matrix = y62.f702a;
                    matrix.reset();
                }
                b3.transform(matrix);
                path2.addPath(b3);
                i++;
            }
        } else {
            path2.set(dpVar2.b());
        }
        this.c.op(path2, path, op);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.util.ListIterator<defpackage.V6> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r0 = r3.previous()
            if (r0 == r2) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.previous()
            V6 r0 = (defpackage.V6) r0
            boolean r1 = r0 instanceof defpackage.dp
            if (r1 == 0) goto L_0x000d
            java.util.ArrayList r1 = r2.f2942a
            dp r0 = (defpackage.dp) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000d
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fl.g(java.util.ListIterator):void");
    }
}
