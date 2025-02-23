package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import java.util.Collections;
import java.util.List;

/* compiled from: ListFieldSchema */
public abstract class u {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f1937a = new b();

    /* compiled from: ListFieldSchema */
    public static final class a extends u {
        public static final Class<?> a = Collections.unmodifiableList(Collections.emptyList()).getClass();

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.datastore.preferences.protobuf.t} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: androidx.datastore.preferences.protobuf.t} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.datastore.preferences.protobuf.t} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <L> java.util.List<L> d(java.lang.Object r3, long r4, int r6) {
            /*
                java.lang.Object r0 = defpackage.C0285oB.n(r3, r4)
                java.util.List r0 = (java.util.List) r0
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002f
                boolean r1 = r0 instanceof defpackage.Vh
                if (r1 == 0) goto L_0x0016
                androidx.datastore.preferences.protobuf.t r0 = new androidx.datastore.preferences.protobuf.t
                r0.<init>((int) r6)
                goto L_0x002b
            L_0x0016:
                boolean r1 = r0 instanceof defpackage.qq
                if (r1 == 0) goto L_0x0026
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.p.c
                if (r1 == 0) goto L_0x0026
                androidx.datastore.preferences.protobuf.p$c r0 = (androidx.datastore.preferences.protobuf.p.c) r0
                androidx.datastore.preferences.protobuf.p$c r6 = r0.l(r6)
                r0 = r6
                goto L_0x002b
            L_0x0026:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x002b:
                defpackage.C0285oB.u(r3, r4, r0)
                goto L_0x0081
            L_0x002f:
                java.lang.Class r1 = r0.getClass()
                java.lang.Class<?> r2 = a
                boolean r1 = r2.isAssignableFrom(r1)
                if (r1 == 0) goto L_0x004d
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                defpackage.C0285oB.u(r3, r4, r1)
            L_0x004b:
                r0 = r1
                goto L_0x0081
            L_0x004d:
                boolean r1 = r0 instanceof defpackage.kB
                if (r1 == 0) goto L_0x0064
                androidx.datastore.preferences.protobuf.t r1 = new androidx.datastore.preferences.protobuf.t
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                kB r0 = (defpackage.kB) r0
                r1.addAll(r0)
                defpackage.C0285oB.u(r3, r4, r1)
                goto L_0x004b
            L_0x0064:
                boolean r1 = r0 instanceof defpackage.qq
                if (r1 == 0) goto L_0x0081
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.p.c
                if (r1 == 0) goto L_0x0081
                r1 = r0
                androidx.datastore.preferences.protobuf.p$c r1 = (androidx.datastore.preferences.protobuf.p.c) r1
                boolean r2 = r1.isModifiable()
                if (r2 != 0) goto L_0x0081
                int r0 = r0.size()
                int r0 = r0 + r6
                androidx.datastore.preferences.protobuf.p$c r0 = r1.l(r0)
                defpackage.C0285oB.u(r3, r4, r0)
            L_0x0081:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.u.a.d(java.lang.Object, long, int):java.util.List");
        }

        public final void a(Object obj, long j) {
            Object obj2;
            List list = (List) C0285oB.n(obj, j);
            if (list instanceof Vh) {
                obj2 = ((Vh) list).m();
            } else {
                if (!a.isAssignableFrom(list.getClass())) {
                    if (!(list instanceof qq) || !(list instanceof p.c)) {
                        obj2 = Collections.unmodifiableList(list);
                    } else {
                        p.c cVar = (p.c) list;
                        if (cVar.isModifiable()) {
                            cVar.makeImmutable();
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
            C0285oB.u(obj, j, obj2);
        }

        public final <E> void b(Object obj, Object obj2, long j) {
            List list = (List) C0285oB.n(obj2, j);
            List d = d(obj, j, list.size());
            int size = d.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                d.addAll(list);
            }
            if (size > 0) {
                list = d;
            }
            C0285oB.u(obj, j, list);
        }

        public final <L> List<L> c(Object obj, long j) {
            return d(obj, j, 10);
        }
    }

    /* compiled from: ListFieldSchema */
    public static final class b extends u {
        public final void a(Object obj, long j) {
            ((p.c) C0285oB.n(obj, j)).makeImmutable();
        }

        public final <E> void b(Object obj, Object obj2, long j) {
            p.c cVar = (p.c) C0285oB.n(obj, j);
            p.c cVar2 = (p.c) C0285oB.n(obj2, j);
            int size = cVar.size();
            int size2 = cVar2.size();
            if (size > 0 && size2 > 0) {
                if (!cVar.isModifiable()) {
                    cVar = cVar.l(size2 + size);
                }
                cVar.addAll(cVar2);
            }
            if (size > 0) {
                cVar2 = cVar;
            }
            C0285oB.u(obj, j, cVar2);
        }

        public final <L> List<L> c(Object obj, long j) {
            int i;
            p.c cVar = (p.c) C0285oB.n(obj, j);
            if (cVar.isModifiable()) {
                return cVar;
            }
            int size = cVar.size();
            if (size == 0) {
                i = 10;
            } else {
                i = size * 2;
            }
            p.c l = cVar.l(i);
            C0285oB.u(obj, j, l);
            return l;
        }
    }

    public abstract void a(Object obj, long j);

    public abstract <L> void b(Object obj, Object obj2, long j);

    public abstract <L> List<L> c(Object obj, long j);
}
