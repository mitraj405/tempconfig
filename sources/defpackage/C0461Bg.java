package defpackage;

import kotlin.random.Random;

/* renamed from: Bg  reason: default package and case insensitive filesystem */
/* compiled from: JDK8PlatformImplementations.kt */
public class C0461Bg extends C0450Ag {

    /* renamed from: Bg$a */
    /* compiled from: JDK8PlatformImplementations.kt */
    public static final class a {
        public static final Integer a;

        /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
        static {
            /*
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0018 }
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch:{ all -> 0x0018 }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0018 }
                boolean r2 = r1 instanceof java.lang.Integer     // Catch:{ all -> 0x0018 }
                if (r2 == 0) goto L_0x0018
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0018 }
                goto L_0x0019
            L_0x0018:
                r1 = r0
            L_0x0019:
                if (r1 == 0) goto L_0x0027
                int r2 = r1.intValue()
                if (r2 <= 0) goto L_0x0023
                r2 = 1
                goto L_0x0024
            L_0x0023:
                r2 = 0
            L_0x0024:
                if (r2 == 0) goto L_0x0027
                r0 = r1
            L_0x0027:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0461Bg.a.<clinit>():void");
        }
    }

    public final Random b() {
        boolean z;
        Integer num = a.a;
        if (num == null || num.intValue() >= 34) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new Cp();
        }
        return new C0665Rb();
    }
}
