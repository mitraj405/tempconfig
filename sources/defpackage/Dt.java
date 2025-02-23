package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SparseArrayCompat;
import defpackage.o1;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: Dt  reason: default package */
/* compiled from: ResourceManagerInternal */
public final class Dt {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static Dt f124a;

    /* renamed from: a  reason: collision with other field name */
    public static final PorterDuff.Mode f125a = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with other field name */
    public b f126a;

    /* renamed from: a  reason: collision with other field name */
    public TypedValue f127a;

    /* renamed from: a  reason: collision with other field name */
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f128a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f129a;
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> b = new WeakHashMap<>(0);

    /* renamed from: Dt$a */
    /* compiled from: ResourceManagerInternal */
    public static class a extends LruCache<Integer, PorterDuffColorFilter> {
        public a() {
            super(6);
        }
    }

    /* renamed from: Dt$b */
    /* compiled from: ResourceManagerInternal */
    public interface b {
    }

    public static synchronized Dt c() {
        Dt dt;
        synchronized (Dt.class) {
            if (f124a == null) {
                f124a = new Dt();
            }
            dt = f124a;
        }
        return dt;
    }

    public static synchronized PorterDuffColorFilter g(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (Dt.class) {
            a aVar = a;
            aVar.getClass();
            int i2 = (i + 31) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) aVar.get(Integer.valueOf(mode.hashCode() + i2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                aVar.getClass();
                PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) aVar.put(Integer.valueOf(mode.hashCode() + i2), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public final synchronized void a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            LongSparseArray longSparseArray = this.b.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.b.put(context, longSparseArray);
            }
            longSparseArray.e(j, new WeakReference(constantState));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable b(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.util.TypedValue r0 = r7.f127a
            if (r0 != 0) goto L_0x000b
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r7.f127a = r0
        L_0x000b:
            android.util.TypedValue r0 = r7.f127a
            android.content.res.Resources r1 = r8.getResources()
            r2 = 1
            r1.getValue(r9, r0, r2)
            int r1 = r0.assetCookie
            long r3 = (long) r1
            r1 = 32
            long r3 = r3 << r1
            int r1 = r0.data
            long r5 = (long) r1
            long r3 = r3 | r5
            android.graphics.drawable.Drawable r1 = r7.d(r8, r3)
            if (r1 == 0) goto L_0x0026
            return r1
        L_0x0026:
            Dt$b r1 = r7.f126a
            if (r1 != 0) goto L_0x002b
            goto L_0x006a
        L_0x002b:
            int r1 = defpackage.zr.abc_cab_background_top_material
            if (r9 != r1) goto L_0x0049
            android.graphics.drawable.LayerDrawable r9 = new android.graphics.drawable.LayerDrawable
            r1 = 2
            android.graphics.drawable.Drawable[] r1 = new android.graphics.drawable.Drawable[r1]
            int r5 = defpackage.zr.abc_cab_background_internal_bg
            android.graphics.drawable.Drawable r5 = r7.e(r8, r5)
            r6 = 0
            r1[r6] = r5
            int r5 = defpackage.zr.abc_cab_background_top_mtrl_alpha
            android.graphics.drawable.Drawable r5 = r7.e(r8, r5)
            r1[r2] = r5
            r9.<init>(r1)
            goto L_0x006b
        L_0x0049:
            int r1 = defpackage.zr.abc_ratingbar_material
            if (r9 != r1) goto L_0x0054
            int r9 = defpackage.tr.abc_star_big
            android.graphics.drawable.LayerDrawable r9 = defpackage.o1.a.c(r7, r8, r9)
            goto L_0x006b
        L_0x0054:
            int r1 = defpackage.zr.abc_ratingbar_indicator_material
            if (r9 != r1) goto L_0x005f
            int r9 = defpackage.tr.abc_star_medium
            android.graphics.drawable.LayerDrawable r9 = defpackage.o1.a.c(r7, r8, r9)
            goto L_0x006b
        L_0x005f:
            int r1 = defpackage.zr.abc_ratingbar_small_material
            if (r9 != r1) goto L_0x006a
            int r9 = defpackage.tr.abc_star_small
            android.graphics.drawable.LayerDrawable r9 = defpackage.o1.a.c(r7, r8, r9)
            goto L_0x006b
        L_0x006a:
            r9 = 0
        L_0x006b:
            if (r9 == 0) goto L_0x0075
            int r0 = r0.changingConfigurations
            r9.setChangingConfigurations(r0)
            r7.a(r8, r3, r9)
        L_0x0075:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Dt.b(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        r5 = r0.f1326a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable d(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.b     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0041 }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x0041 }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.d(r5, r1)     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x003f
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0041 }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0041 }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x0041 }
            monitor-exit(r3)
            return r4
        L_0x0028:
            long[] r4 = r0.f1325a     // Catch:{ all -> 0x0041 }
            int r2 = r0.c     // Catch:{ all -> 0x0041 }
            int r4 = defpackage.C1354qp.k(r2, r5, r4)     // Catch:{ all -> 0x0041 }
            if (r4 < 0) goto L_0x003f
            java.lang.Object[] r5 = r0.f1326a     // Catch:{ all -> 0x0041 }
            r6 = r5[r4]     // Catch:{ all -> 0x0041 }
            java.lang.Object r2 = androidx.collection.LongSparseArray.a     // Catch:{ all -> 0x0041 }
            if (r6 == r2) goto L_0x003f
            r5[r4] = r2     // Catch:{ all -> 0x0041 }
            r4 = 1
            r0.f1324a = r4     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r3)
            return r1
        L_0x0041:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Dt.d(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public final synchronized Drawable e(Context context, int i) {
        return f(context, i, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r0 == false) goto L_0x00e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d4 A[Catch:{ all -> 0x00a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable f(android.content.Context r11, int r12, boolean r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.f129a     // Catch:{ all -> 0x00a5 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0008
            goto L_0x002c
        L_0x0008:
            r10.f129a = r2     // Catch:{ all -> 0x00a5 }
            int r0 = defpackage.ur.abc_vector_test     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r0 = r10.e(r11, r0)     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x00e5
            boolean r3 = r0 instanceof defpackage.ZB     // Catch:{ all -> 0x00a5 }
            if (r3 != 0) goto L_0x0029
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "android.graphics.drawable.VectorDrawable"
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r0 = r1
            goto L_0x002a
        L_0x0029:
            r0 = r2
        L_0x002a:
            if (r0 == 0) goto L_0x00e5
        L_0x002c:
            android.graphics.drawable.Drawable r0 = r10.b(r11, r12)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x0038
            java.lang.Object r0 = defpackage.d7.a     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r0 = defpackage.d7.a.b(r11, r12)     // Catch:{ all -> 0x00a5 }
        L_0x0038:
            if (r0 == 0) goto L_0x00de
            android.content.res.ColorStateList r3 = r10.h(r11, r12)     // Catch:{ all -> 0x00a5 }
            r4 = 0
            if (r3 == 0) goto L_0x005d
            int[] r11 = defpackage.w9.f3389a     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r11 = r0.mutate()     // Catch:{ all -> 0x00a5 }
            defpackage.v9.a.h(r11, r3)     // Catch:{ all -> 0x00a5 }
            Dt$b r13 = r10.f126a     // Catch:{ all -> 0x00a5 }
            if (r13 != 0) goto L_0x004f
            goto L_0x0055
        L_0x004f:
            int r13 = defpackage.zr.abc_switch_thumb_material     // Catch:{ all -> 0x00a5 }
            if (r12 != r13) goto L_0x0055
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.MULTIPLY     // Catch:{ all -> 0x00a5 }
        L_0x0055:
            if (r4 == 0) goto L_0x005a
            defpackage.v9.a.i(r11, r4)     // Catch:{ all -> 0x00a5 }
        L_0x005a:
            r0 = r11
            goto L_0x00de
        L_0x005d:
            Dt$b r3 = r10.f126a     // Catch:{ all -> 0x00a5 }
            if (r3 == 0) goto L_0x00d5
            int r3 = defpackage.zr.abc_seekbar_track_material     // Catch:{ all -> 0x00a5 }
            r5 = 16908301(0x102000d, float:2.3877265E-38)
            r6 = 16908303(0x102000f, float:2.387727E-38)
            r7 = 16908288(0x1020000, float:2.387723E-38)
            if (r12 != r3) goto L_0x0098
            r1 = r0
            android.graphics.drawable.LayerDrawable r1 = (android.graphics.drawable.LayerDrawable) r1     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r3 = r1.findDrawableByLayerId(r7)     // Catch:{ all -> 0x00a5 }
            int r7 = defpackage.C0220hr.colorControlNormal     // Catch:{ all -> 0x00a5 }
            int r8 = defpackage.Oz.c(r11, r7)     // Catch:{ all -> 0x00a5 }
            android.graphics.PorterDuff$Mode r9 = defpackage.o1.a     // Catch:{ all -> 0x00a5 }
            defpackage.o1.a.e(r3, r8, r9)     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r3 = r1.findDrawableByLayerId(r6)     // Catch:{ all -> 0x00a5 }
            int r6 = defpackage.Oz.c(r11, r7)     // Catch:{ all -> 0x00a5 }
            defpackage.o1.a.e(r3, r6, r9)     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r1 = r1.findDrawableByLayerId(r5)     // Catch:{ all -> 0x00a5 }
            int r3 = defpackage.C0220hr.colorControlActivated     // Catch:{ all -> 0x00a5 }
            int r3 = defpackage.Oz.c(r11, r3)     // Catch:{ all -> 0x00a5 }
            defpackage.o1.a.e(r1, r3, r9)     // Catch:{ all -> 0x00a5 }
            goto L_0x00d1
        L_0x0098:
            int r3 = defpackage.zr.abc_ratingbar_material     // Catch:{ all -> 0x00a5 }
            if (r12 == r3) goto L_0x00a7
            int r3 = defpackage.zr.abc_ratingbar_indicator_material     // Catch:{ all -> 0x00a5 }
            if (r12 == r3) goto L_0x00a7
            int r3 = defpackage.zr.abc_ratingbar_small_material     // Catch:{ all -> 0x00a5 }
            if (r12 != r3) goto L_0x00d2
            goto L_0x00a7
        L_0x00a5:
            r11 = move-exception
            goto L_0x00ef
        L_0x00a7:
            r1 = r0
            android.graphics.drawable.LayerDrawable r1 = (android.graphics.drawable.LayerDrawable) r1     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r3 = r1.findDrawableByLayerId(r7)     // Catch:{ all -> 0x00a5 }
            int r7 = defpackage.C0220hr.colorControlNormal     // Catch:{ all -> 0x00a5 }
            int r7 = defpackage.Oz.b(r11, r7)     // Catch:{ all -> 0x00a5 }
            android.graphics.PorterDuff$Mode r8 = defpackage.o1.a     // Catch:{ all -> 0x00a5 }
            defpackage.o1.a.e(r3, r7, r8)     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r3 = r1.findDrawableByLayerId(r6)     // Catch:{ all -> 0x00a5 }
            int r6 = defpackage.C0220hr.colorControlActivated     // Catch:{ all -> 0x00a5 }
            int r7 = defpackage.Oz.c(r11, r6)     // Catch:{ all -> 0x00a5 }
            defpackage.o1.a.e(r3, r7, r8)     // Catch:{ all -> 0x00a5 }
            android.graphics.drawable.Drawable r1 = r1.findDrawableByLayerId(r5)     // Catch:{ all -> 0x00a5 }
            int r3 = defpackage.Oz.c(r11, r6)     // Catch:{ all -> 0x00a5 }
            defpackage.o1.a.e(r1, r3, r8)     // Catch:{ all -> 0x00a5 }
        L_0x00d1:
            r1 = r2
        L_0x00d2:
            if (r1 == 0) goto L_0x00d5
            goto L_0x00de
        L_0x00d5:
            boolean r11 = r10.i(r11, r12, r0)     // Catch:{ all -> 0x00a5 }
            if (r11 != 0) goto L_0x00de
            if (r13 == 0) goto L_0x00de
            r0 = r4
        L_0x00de:
            if (r0 == 0) goto L_0x00e3
            defpackage.w9.a(r0)     // Catch:{ all -> 0x00a5 }
        L_0x00e3:
            monitor-exit(r10)
            return r0
        L_0x00e5:
            r10.f129a = r1     // Catch:{ all -> 0x00a5 }
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a5 }
            java.lang.String r12 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r11.<init>(r12)     // Catch:{ all -> 0x00a5 }
            throw r11     // Catch:{ all -> 0x00a5 }
        L_0x00ef:
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Dt.f(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList h(Context context, int i) {
        ColorStateList colorStateList;
        SparseArrayCompat sparseArrayCompat;
        try {
            WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f128a;
            ColorStateList colorStateList2 = null;
            if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
                colorStateList = null;
            } else {
                colorStateList = (ColorStateList) sparseArrayCompat.c(i, (Integer) null);
            }
            if (colorStateList == null) {
                b bVar = this.f126a;
                if (bVar != null) {
                    colorStateList2 = ((o1.a) bVar).d(context, i);
                }
                if (colorStateList2 != null) {
                    if (this.f128a == null) {
                        this.f128a = new WeakHashMap<>();
                    }
                    SparseArrayCompat sparseArrayCompat2 = this.f128a.get(context);
                    if (sparseArrayCompat2 == null) {
                        sparseArrayCompat2 = new SparseArrayCompat();
                        this.f128a.put(context, sparseArrayCompat2);
                    }
                    sparseArrayCompat2.a(i, colorStateList2);
                }
                colorStateList = colorStateList2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return colorStateList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            Dt$b r0 = r6.f126a
            r1 = 0
            if (r0 == 0) goto L_0x006c
            o1$a r0 = (defpackage.o1.a) r0
            android.graphics.PorterDuff$Mode r2 = defpackage.o1.a
            int[] r3 = r0.a
            boolean r3 = defpackage.o1.a.a(r8, r3)
            r4 = 1
            r5 = -1
            if (r3 == 0) goto L_0x0016
            int r8 = defpackage.C0220hr.colorControlNormal
            goto L_0x0046
        L_0x0016:
            int[] r3 = r0.c
            boolean r3 = defpackage.o1.a.a(r8, r3)
            if (r3 == 0) goto L_0x0021
            int r8 = defpackage.C0220hr.colorControlActivated
            goto L_0x0046
        L_0x0021:
            int[] r0 = r0.d
            boolean r0 = defpackage.o1.a.a(r8, r0)
            if (r0 == 0) goto L_0x002c
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0043
        L_0x002c:
            int r0 = defpackage.zr.abc_list_divider_mtrl_alpha
            if (r8 != r0) goto L_0x003f
            r8 = 1109603123(0x42233333, float:40.8)
            int r8 = java.lang.Math.round(r8)
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            r3 = r2
            r2 = r0
            r0 = r8
            r8 = r4
            goto L_0x004e
        L_0x003f:
            int r0 = defpackage.zr.abc_dialog_material_background
            if (r8 != r0) goto L_0x0049
        L_0x0043:
            r8 = 16842801(0x1010031, float:2.3693695E-38)
        L_0x0046:
            r0 = r8
            r8 = r4
            goto L_0x004b
        L_0x0049:
            r8 = r1
            r0 = r8
        L_0x004b:
            r3 = r2
            r2 = r0
            r0 = r5
        L_0x004e:
            if (r8 == 0) goto L_0x0068
            int[] r8 = defpackage.w9.f3389a
            android.graphics.drawable.Drawable r8 = r9.mutate()
            int r7 = defpackage.Oz.c(r7, r2)
            android.graphics.PorterDuffColorFilter r7 = defpackage.o1.c(r7, r3)
            r8.setColorFilter(r7)
            if (r0 == r5) goto L_0x0066
            r8.setAlpha(r0)
        L_0x0066:
            r7 = r4
            goto L_0x0069
        L_0x0068:
            r7 = r1
        L_0x0069:
            if (r7 == 0) goto L_0x006c
            r1 = r4
        L_0x006c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Dt.i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
