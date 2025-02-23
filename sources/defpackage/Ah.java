package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: Ah  reason: default package */
/* compiled from: KeyTrigger */
public final class Ah extends C0260lh {
    public float a = 0.1f;

    /* renamed from: a  reason: collision with other field name */
    public RectF f11a = new RectF();

    /* renamed from: a  reason: collision with other field name */
    public View f12a = null;

    /* renamed from: a  reason: collision with other field name */
    public boolean f13a = true;
    public float b = Float.NaN;

    /* renamed from: b  reason: collision with other field name */
    public RectF f14b = new RectF();

    /* renamed from: b  reason: collision with other field name */
    public String f15b = null;

    /* renamed from: b  reason: collision with other field name */
    public HashMap<String, Method> f16b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f17b = true;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f18c = -1;

    /* renamed from: c  reason: collision with other field name */
    public String f19c = null;

    /* renamed from: c  reason: collision with other field name */
    public boolean f20c = true;
    public int d = -1;

    /* renamed from: d  reason: collision with other field name */
    public String f21d = null;

    /* renamed from: d  reason: collision with other field name */
    public boolean f22d = false;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public int h = -1;

    /* renamed from: Ah$a */
    /* compiled from: KeyTrigger */
    public static class a {
        public static final SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.KeyTrigger_framePosition, 8);
            sparseIntArray.append(C0221hs.KeyTrigger_onCross, 4);
            sparseIntArray.append(C0221hs.KeyTrigger_onNegativeCross, 1);
            sparseIntArray.append(C0221hs.KeyTrigger_onPositiveCross, 2);
            sparseIntArray.append(C0221hs.KeyTrigger_motionTarget, 7);
            sparseIntArray.append(C0221hs.KeyTrigger_triggerId, 6);
            sparseIntArray.append(C0221hs.KeyTrigger_triggerSlack, 5);
            sparseIntArray.append(C0221hs.KeyTrigger_motion_triggerOnCollision, 9);
            sparseIntArray.append(C0221hs.KeyTrigger_motion_postLayoutCollision, 10);
            sparseIntArray.append(C0221hs.KeyTrigger_triggerReceiver, 11);
            sparseIntArray.append(C0221hs.KeyTrigger_viewTransitionOnCross, 12);
            sparseIntArray.append(C0221hs.KeyTrigger_viewTransitionOnNegativeCross, 13);
            sparseIntArray.append(C0221hs.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }
    }

    public Ah() {
        this.f3093a = new HashMap<>();
    }

    public static void j(RectF rectF, View view, boolean z) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* renamed from: b */
    public final C0260lh clone() {
        Ah ah = new Ah();
        super.c(this);
        ah.f15b = this.f15b;
        ah.f18c = this.f18c;
        ah.f19c = this.f19c;
        ah.f21d = this.f21d;
        ah.d = this.d;
        ah.e = this.e;
        ah.f12a = this.f12a;
        ah.a = this.a;
        ah.f13a = this.f13a;
        ah.f17b = this.f17b;
        ah.f20c = this.f20c;
        ah.b = this.b;
        ah.c = this.c;
        ah.f22d = this.f22d;
        ah.f11a = this.f11a;
        ah.f14b = this.f14b;
        ah.f16b = this.f16b;
        return ah;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.KeyTrigger);
        SparseIntArray sparseIntArray = a.a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray2 = a.a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.f19c = obtainStyledAttributes.getString(index);
                    break;
                case 2:
                    this.f21d = obtainStyledAttributes.getString(index);
                    break;
                case 4:
                    this.f15b = obtainStyledAttributes.getString(index);
                    break;
                case 5:
                    this.a = obtainStyledAttributes.getFloat(index, this.a);
                    break;
                case 6:
                    this.d = obtainStyledAttributes.getResourceId(index, this.d);
                    break;
                case 7:
                    if (!MotionLayout.k) {
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.b = obtainStyledAttributes.getResourceId(index, this.b);
                            break;
                        } else {
                            this.f3092a = obtainStyledAttributes.getString(index);
                            break;
                        }
                    } else {
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.b);
                        this.b = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.f3092a = obtainStyledAttributes.getString(index);
                            break;
                        }
                    }
                case 8:
                    int integer = obtainStyledAttributes.getInteger(index, this.a);
                    this.a = integer;
                    this.b = (((float) integer) + 0.5f) / 100.0f;
                    break;
                case 9:
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    break;
                case 10:
                    this.f22d = obtainStyledAttributes.getBoolean(index, this.f22d);
                    break;
                case 11:
                    this.f18c = obtainStyledAttributes.getResourceId(index, this.f18c);
                    break;
                case 12:
                    this.h = obtainStyledAttributes.getResourceId(index, this.h);
                    break;
                case 13:
                    this.f = obtainStyledAttributes.getResourceId(index, this.f);
                    break;
                case 14:
                    this.g = obtainStyledAttributes.getResourceId(index, this.g);
                    break;
                default:
                    Integer.toHexString(index);
                    sparseIntArray2.get(index);
                    break;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.e
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 == r3) goto L_0x0060
            android.view.View r0 = r9.f12a
            if (r0 != 0) goto L_0x0019
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r4 = r9.e
            android.view.View r0 = r0.findViewById(r4)
            r9.f12a = r0
        L_0x0019:
            android.graphics.RectF r0 = r9.f11a
            android.view.View r4 = r9.f12a
            boolean r5 = r9.f22d
            j(r0, r4, r5)
            android.graphics.RectF r0 = r9.f14b
            boolean r4 = r9.f22d
            j(r0, r11, r4)
            android.graphics.RectF r0 = r9.f11a
            android.graphics.RectF r4 = r9.f14b
            boolean r0 = r0.intersect(r4)
            if (r0 == 0) goto L_0x004a
            boolean r0 = r9.f13a
            if (r0 == 0) goto L_0x003b
            r9.f13a = r2
            r0 = r1
            goto L_0x003c
        L_0x003b:
            r0 = r2
        L_0x003c:
            boolean r4 = r9.f20c
            if (r4 == 0) goto L_0x0044
            r9.f20c = r2
            r4 = r1
            goto L_0x0045
        L_0x0044:
            r4 = r2
        L_0x0045:
            r9.f17b = r1
            r5 = r2
            goto L_0x00da
        L_0x004a:
            boolean r0 = r9.f13a
            if (r0 != 0) goto L_0x0052
            r9.f13a = r1
            r0 = r1
            goto L_0x0053
        L_0x0052:
            r0 = r2
        L_0x0053:
            boolean r4 = r9.f17b
            if (r4 == 0) goto L_0x005b
            r9.f17b = r2
            r4 = r1
            goto L_0x005c
        L_0x005b:
            r4 = r2
        L_0x005c:
            r9.f20c = r1
            goto L_0x00d8
        L_0x0060:
            boolean r0 = r9.f13a
            r4 = 0
            if (r0 == 0) goto L_0x0075
            float r0 = r9.b
            float r5 = r10 - r0
            float r6 = r9.c
            float r6 = r6 - r0
            float r6 = r6 * r5
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0085
            r9.f13a = r2
            r0 = r1
            goto L_0x0086
        L_0x0075:
            float r0 = r9.b
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r5 = r9.a
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0085
            r9.f13a = r1
        L_0x0085:
            r0 = r2
        L_0x0086:
            boolean r5 = r9.f17b
            if (r5 == 0) goto L_0x009e
            float r5 = r9.b
            float r6 = r10 - r5
            float r7 = r9.c
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x00ae
            int r5 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x00ae
            r9.f17b = r2
            r5 = r1
            goto L_0x00af
        L_0x009e:
            float r5 = r9.b
            float r5 = r10 - r5
            float r5 = java.lang.Math.abs(r5)
            float r6 = r9.a
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ae
            r9.f17b = r1
        L_0x00ae:
            r5 = r2
        L_0x00af:
            boolean r6 = r9.f20c
            if (r6 == 0) goto L_0x00c7
            float r6 = r9.b
            float r7 = r10 - r6
            float r8 = r9.c
            float r8 = r8 - r6
            float r8 = r8 * r7
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00d9
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d9
            r9.f20c = r2
            r4 = r1
            goto L_0x00da
        L_0x00c7:
            float r4 = r9.b
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r6 = r9.a
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d7
            r9.f20c = r1
        L_0x00d7:
            r4 = r5
        L_0x00d8:
            r5 = r4
        L_0x00d9:
            r4 = r2
        L_0x00da:
            r9.c = r10
            if (r5 != 0) goto L_0x00e2
            if (r0 != 0) goto L_0x00e2
            if (r4 == 0) goto L_0x0107
        L_0x00e2:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            androidx.constraintlayout.motion.widget.MotionLayout$i r6 = r10.f1445a
            if (r6 == 0) goto L_0x00ef
            r6.d()
        L_0x00ef:
            java.util.concurrent.CopyOnWriteArrayList<androidx.constraintlayout.motion.widget.MotionLayout$i> r10 = r10.f1452a
            if (r10 == 0) goto L_0x0107
            java.util.Iterator r10 = r10.iterator()
        L_0x00f7:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto L_0x0107
            java.lang.Object r6 = r10.next()
            androidx.constraintlayout.motion.widget.MotionLayout$i r6 = (androidx.constraintlayout.motion.widget.MotionLayout.i) r6
            r6.d()
            goto L_0x00f7
        L_0x0107:
            int r10 = r9.f18c
            if (r10 != r3) goto L_0x010d
            r10 = r11
            goto L_0x0119
        L_0x010d:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r6 = r9.f18c
            android.view.View r10 = r10.findViewById(r6)
        L_0x0119:
            if (r5 == 0) goto L_0x0135
            java.lang.String r5 = r9.f19c
            if (r5 == 0) goto L_0x0122
            r9.i(r10, r5)
        L_0x0122:
            int r5 = r9.f
            if (r5 == r3) goto L_0x0135
            android.view.ViewParent r5 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r5 = (androidx.constraintlayout.motion.widget.MotionLayout) r5
            int r6 = r9.f
            android.view.View[] r7 = new android.view.View[r1]
            r7[r2] = r10
            r5.v(r6, r7)
        L_0x0135:
            if (r4 == 0) goto L_0x0151
            java.lang.String r4 = r9.f21d
            if (r4 == 0) goto L_0x013e
            r9.i(r10, r4)
        L_0x013e:
            int r4 = r9.g
            if (r4 == r3) goto L_0x0151
            android.view.ViewParent r4 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r4 = (androidx.constraintlayout.motion.widget.MotionLayout) r4
            int r5 = r9.g
            android.view.View[] r6 = new android.view.View[r1]
            r6[r2] = r10
            r4.v(r5, r6)
        L_0x0151:
            if (r0 == 0) goto L_0x016d
            java.lang.String r0 = r9.f15b
            if (r0 == 0) goto L_0x015a
            r9.i(r10, r0)
        L_0x015a:
            int r0 = r9.h
            if (r0 == r3) goto L_0x016d
            android.view.ViewParent r11 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r0 = r9.h
            android.view.View[] r1 = new android.view.View[r1]
            r1[r2] = r10
            r11.v(r0, r1)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ah.h(float, android.view.View):void");
    }

    public final void i(View view, String str) {
        Method method;
        boolean z;
        O6 o6;
        if (str != null) {
            if (str.startsWith(".")) {
                if (str.length() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    str = str.substring(1).toLowerCase(Locale.ROOT);
                }
                for (String next : this.f3093a.keySet()) {
                    String lowerCase = next.toLowerCase(Locale.ROOT);
                    if ((z || lowerCase.matches(str)) && (o6 = this.f3093a.get(next)) != null) {
                        Class<?> cls = view.getClass();
                        boolean z2 = o6.f465a;
                        String str2 = o6.f464a;
                        if (!z2) {
                            str2 = C0709Uj.i("set", str2);
                        }
                        try {
                            switch (xx.V(o6.f463a)) {
                                case 0:
                                case 7:
                                    cls.getMethod(str2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(o6.b)});
                                    break;
                                case 1:
                                    cls.getMethod(str2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(o6.a)});
                                    break;
                                case 2:
                                    cls.getMethod(str2, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(o6.c)});
                                    break;
                                case 3:
                                    Method method2 = cls.getMethod(str2, new Class[]{Drawable.class});
                                    ColorDrawable colorDrawable = new ColorDrawable();
                                    colorDrawable.setColor(o6.c);
                                    method2.invoke(view, new Object[]{colorDrawable});
                                    break;
                                case 4:
                                    cls.getMethod(str2, new Class[]{CharSequence.class}).invoke(view, new Object[]{o6.f466b});
                                    break;
                                case 5:
                                    cls.getMethod(str2, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(o6.f467b)});
                                    break;
                                case 6:
                                    cls.getMethod(str2, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(o6.a)});
                                    break;
                            }
                        } catch (NoSuchMethodException e2) {
                            e2.getMessage();
                        } catch (IllegalAccessException e3) {
                            e3.printStackTrace();
                        } catch (InvocationTargetException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                return;
            }
            if (this.f16b.containsKey(str)) {
                method = this.f16b.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, new Class[0]);
                    this.f16b.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.f16b.put(str, (Object) null);
                    view.getClass();
                    C0175e8.d(view);
                    return;
                }
            }
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                view.getClass();
                C0175e8.d(view);
            }
        }
    }

    public final void a(HashMap<String, MC> hashMap) {
    }

    public final void d(HashSet<String> hashSet) {
    }
}
