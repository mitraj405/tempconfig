package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: dd  reason: default package and case insensitive filesystem */
/* compiled from: FontRequestWorker */
public final class C0169dd {
    public static final LruCache<String, Typeface> a = new LruCache<>(16);

    /* renamed from: a  reason: collision with other field name */
    public static final SimpleArrayMap<String, ArrayList<U6<a>>> f2869a = new SimpleArrayMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static final Object f2870a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static final ThreadPoolExecutor f2871a;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new C0413yt());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f2871a = threadPoolExecutor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.C0169dd.a a(java.lang.String r6, android.content.Context r7, defpackage.C0109Yc r8, int r9) {
        /*
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r0 = a
            java.lang.Object r1 = r0.get(r6)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0010
            dd$a r6 = new dd$a
            r6.<init>((android.graphics.Typeface) r1)
            return r6
        L_0x0010:
            fd r8 = defpackage.C0107Xc.a(r7, r8)     // Catch:{ NameNotFoundException -> 0x005b }
            r1 = 1
            r2 = -3
            gd[] r3 = r8.f2939a
            int r8 = r8.a
            if (r8 == 0) goto L_0x0021
            if (r8 == r1) goto L_0x001f
            goto L_0x0034
        L_0x001f:
            r8 = -2
            goto L_0x003c
        L_0x0021:
            if (r3 == 0) goto L_0x003b
            int r8 = r3.length
            if (r8 != 0) goto L_0x0027
            goto L_0x003b
        L_0x0027:
            int r8 = r3.length
            r1 = 0
            r4 = r1
        L_0x002a:
            if (r4 >= r8) goto L_0x003b
            r5 = r3[r4]
            int r5 = r5.c
            if (r5 == 0) goto L_0x0038
            if (r5 >= 0) goto L_0x0036
        L_0x0034:
            r8 = r2
            goto L_0x003c
        L_0x0036:
            r8 = r5
            goto L_0x003c
        L_0x0038:
            int r4 = r4 + 1
            goto L_0x002a
        L_0x003b:
            r8 = r1
        L_0x003c:
            if (r8 == 0) goto L_0x0044
            dd$a r6 = new dd$a
            r6.<init>((int) r8)
            return r6
        L_0x0044:
            ZA r8 = defpackage.TA.a
            android.graphics.Typeface r7 = r8.b(r7, r3, r9)
            if (r7 == 0) goto L_0x0055
            r0.put(r6, r7)
            dd$a r6 = new dd$a
            r6.<init>((android.graphics.Typeface) r7)
            return r6
        L_0x0055:
            dd$a r6 = new dd$a
            r6.<init>((int) r2)
            return r6
        L_0x005b:
            dd$a r6 = new dd$a
            r7 = -1
            r6.<init>((int) r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0169dd.a(java.lang.String, android.content.Context, Yc, int):dd$a");
    }

    /* renamed from: dd$a */
    /* compiled from: FontRequestWorker */
    public static final class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Typeface f2872a;

        public a(int i) {
            this.f2872a = null;
            this.a = i;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.f2872a = typeface;
            this.a = 0;
        }
    }
}
