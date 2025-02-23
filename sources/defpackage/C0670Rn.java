package defpackage;

import java.util.HashSet;

/* renamed from: Rn  reason: default package and case insensitive filesystem */
/* compiled from: OnErrorThrowable */
public final class C0670Rn extends RuntimeException {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = -569558213262703934L;

    /* renamed from: Rn$a */
    /* compiled from: OnErrorThrowable */
    public static class a extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        public final Object a;

        /* renamed from: Rn$a$a  reason: collision with other inner class name */
        /* compiled from: OnErrorThrowable */
        public static final class C0047a {
            public static final HashSet a;

            static {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                a = hashSet;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "OnError while emitting onNext value: "
                r0.<init>(r1)
                if (r4 != 0) goto L_0x000c
                java.lang.String r1 = "null"
                goto L_0x0048
            L_0x000c:
                java.util.HashSet r1 = defpackage.C0670Rn.a.C0047a.a
                java.lang.Class r2 = r4.getClass()
                boolean r1 = r1.contains(r2)
                if (r1 == 0) goto L_0x001d
                java.lang.String r1 = r4.toString()
                goto L_0x0048
            L_0x001d:
                boolean r1 = r4 instanceof java.lang.String
                if (r1 == 0) goto L_0x0025
                r1 = r4
                java.lang.String r1 = (java.lang.String) r1
                goto L_0x0048
            L_0x0025:
                boolean r1 = r4 instanceof java.lang.Enum
                if (r1 == 0) goto L_0x0031
                r1 = r4
                java.lang.Enum r1 = (java.lang.Enum) r1
                java.lang.String r1 = r1.name()
                goto L_0x0048
            L_0x0031:
                Cu r1 = defpackage.Cu.f3555a
                su r1 = r1.b()
                r1.getClass()
                java.lang.Class r1 = r4.getClass()
                java.lang.String r1 = r1.getName()
                java.lang.String r2 = ".class"
                java.lang.String r1 = r1.concat(r2)
            L_0x0048:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r3.<init>(r0)
                boolean r0 = r4 instanceof java.io.Serializable
                if (r0 == 0) goto L_0x0057
                goto L_0x0061
            L_0x0057:
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x005c }
                goto L_0x0061
            L_0x005c:
                r4 = move-exception
                java.lang.String r4 = r4.getMessage()
            L_0x0061:
                r3.a = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0670Rn.a.<init>(java.lang.Object):void");
        }
    }
}
