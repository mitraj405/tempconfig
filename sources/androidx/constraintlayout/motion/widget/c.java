package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ViewTransition */
public final class c {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1542a;

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintSet.a f1543a;

    /* renamed from: a  reason: collision with other field name */
    public String f1544a;

    /* renamed from: a  reason: collision with other field name */
    public final rh f1545a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1546a = false;
    public int b = -1;

    /* renamed from: b  reason: collision with other field name */
    public String f1547b = null;
    public int c = 0;
    public int d;
    public int e = -1;
    public int f = -1;
    public int g;
    public int h = 0;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int o = -1;

    /* compiled from: ViewTransition */
    public static class a {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public final int f1548a;

        /* renamed from: a  reason: collision with other field name */
        public long f1549a;

        /* renamed from: a  reason: collision with other field name */
        public final Vl f1550a;

        /* renamed from: a  reason: collision with other field name */
        public final Rect f1551a = new Rect();

        /* renamed from: a  reason: collision with other field name */
        public final Interpolator f1552a;

        /* renamed from: a  reason: collision with other field name */
        public final d f1553a;

        /* renamed from: a  reason: collision with other field name */
        public final nh f1554a = new nh(0);

        /* renamed from: a  reason: collision with other field name */
        public boolean f1555a = false;
        public float b;

        /* renamed from: b  reason: collision with other field name */
        public final int f1556b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f1557b = false;
        public final int c;

        public a(d dVar, Vl vl, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            float f;
            this.f1553a = dVar;
            this.f1550a = vl;
            this.c = i2;
            this.f1549a = System.nanoTime();
            if (dVar.b == null) {
                dVar.b = new ArrayList<>();
            }
            dVar.b.add(this);
            this.f1552a = interpolator;
            this.f1548a = i4;
            this.f1556b = i5;
            if (i3 == 3) {
                this.f1557b = true;
            }
            if (i == 0) {
                f = Float.MAX_VALUE;
            } else {
                f = 1.0f / ((float) i);
            }
            this.b = f;
            a();
        }

        public final void a() {
            float f;
            boolean z = this.f1555a;
            int i = this.f1556b;
            int i2 = this.f1548a;
            d dVar = this.f1553a;
            Interpolator interpolator = this.f1552a;
            Vl vl = this.f1550a;
            if (z) {
                long nanoTime = System.nanoTime();
                this.f1549a = nanoTime;
                float f2 = this.a - (((float) (((double) (nanoTime - this.f1549a)) * 1.0E-6d)) * this.b);
                this.a = f2;
                if (f2 < 0.0f) {
                    this.a = 0.0f;
                }
                float f3 = this.a;
                if (interpolator != null) {
                    f3 = interpolator.getInterpolation(f3);
                }
                Vl vl2 = vl;
                boolean e = vl.e(f3, nanoTime, vl.f606a, this.f1554a);
                if (this.a <= 0.0f) {
                    if (i2 != -1) {
                        vl2.f606a.setTag(i2, Long.valueOf(System.nanoTime()));
                    }
                    if (i != -1) {
                        vl2.f606a.setTag(i, (Object) null);
                    }
                    dVar.c.add(this);
                }
                if (this.a > 0.0f || e) {
                    dVar.a.invalidate();
                    return;
                }
                return;
            }
            Vl vl3 = vl;
            long nanoTime2 = System.nanoTime();
            this.f1549a = nanoTime2;
            float f4 = (((float) (((double) (nanoTime2 - this.f1549a)) * 1.0E-6d)) * this.b) + this.a;
            this.a = f4;
            if (f4 >= 1.0f) {
                this.a = 1.0f;
            }
            if (interpolator == null) {
                f = this.a;
            } else {
                f = interpolator.getInterpolation(this.a);
            }
            boolean e2 = vl3.e(f, nanoTime2, vl3.f606a, this.f1554a);
            if (this.a >= 1.0f) {
                if (i2 != -1) {
                    vl3.f606a.setTag(i2, Long.valueOf(System.nanoTime()));
                }
                if (i != -1) {
                    vl3.f606a.setTag(i, (Object) null);
                }
                if (!this.f1557b) {
                    dVar.c.add(this);
                }
            }
            if (this.a < 1.0f || e2) {
                dVar.a.invalidate();
            }
        }

        public final void b() {
            float f;
            this.f1555a = true;
            int i = this.c;
            if (i != -1) {
                if (i == 0) {
                    f = Float.MAX_VALUE;
                } else {
                    f = 1.0f / ((float) i);
                }
                this.b = f;
            }
            this.f1553a.a.invalidate();
            this.f1549a = System.nanoTime();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.b = r0
            r1 = 0
            r9.f1546a = r1
            r9.c = r1
            r9.e = r0
            r9.f = r0
            r9.h = r1
            r2 = 0
            r9.f1547b = r2
            r9.i = r0
            r9.j = r0
            r9.k = r0
            r9.l = r0
            r9.m = r0
            r9.n = r0
            r9.o = r0
            r9.f1542a = r10
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
        L_0x0028:
            r3 = 1
            if (r2 == r3) goto L_0x00b8
            java.lang.String r4 = "ViewTransition"
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L_0x0040
            if (r2 == r5) goto L_0x0035
            goto L_0x00a9
        L_0x0035:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            boolean r2 = r4.equals(r2)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x00a9
            return
        L_0x0040:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            int r7 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r8 = 4
            switch(r7) {
                case -1962203927: goto L_0x0073;
                case -1239391468: goto L_0x0069;
                case 61998586: goto L_0x0061;
                case 366511058: goto L_0x0057;
                case 1791837707: goto L_0x004d;
                default: goto L_0x004c;
            }     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
        L_0x004c:
            goto L_0x007d
        L_0x004d:
            java.lang.String r4 = "CustomAttribute"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = r5
            goto L_0x007e
        L_0x0057:
            java.lang.String r4 = "CustomMethod"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = r8
            goto L_0x007e
        L_0x0061:
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = r1
            goto L_0x007e
        L_0x0069:
            java.lang.String r4 = "KeyFrameSet"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = r3
            goto L_0x007e
        L_0x0073:
            java.lang.String r4 = "ConstraintOverride"
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            if (r2 == 0) goto L_0x007d
            r2 = r6
            goto L_0x007e
        L_0x007d:
            r2 = r0
        L_0x007e:
            if (r2 == 0) goto L_0x00a6
            if (r2 == r3) goto L_0x009e
            if (r2 == r6) goto L_0x0097
            if (r2 == r5) goto L_0x008f
            if (r2 == r8) goto L_0x008f
            defpackage.C0175e8.a()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x008f:
            androidx.constraintlayout.widget.ConstraintSet$a r2 = r9.f1543a     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            java.util.HashMap<java.lang.String, O6> r2 = r2.f1670a     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            defpackage.O6.d(r10, r11, r2)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x0097:
            androidx.constraintlayout.widget.ConstraintSet$a r2 = androidx.constraintlayout.widget.ConstraintSet.d(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r9.f1543a = r2     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x009e:
            rh r2 = new rh     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            r9.f1545a = r2     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x00a9
        L_0x00a6:
            r9.d(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
        L_0x00a9:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x00b4, IOException -> 0x00af }
            goto L_0x0028
        L_0x00af:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00b8
        L_0x00b4:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.c.<init>(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public final void a(d dVar, MotionLayout motionLayout, int i2, ConstraintSet constraintSet, View... viewArr) {
        ConstraintSet constraintSet2;
        QC qc;
        Interpolator interpolator;
        MotionLayout motionLayout2 = motionLayout;
        int i3 = i2;
        ConstraintSet constraintSet3 = constraintSet;
        View[] viewArr2 = viewArr;
        if (!this.f1546a) {
            int i4 = this.d;
            rh rhVar = this.f1545a;
            if (i4 == 2) {
                View view = viewArr2[0];
                Vl vl = new Vl(view);
                Xl xl = vl.f604a;
                xl.f679a = 0.0f;
                xl.b = 0.0f;
                vl.f623b = true;
                xl.i(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                vl.f619b.i(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                Tl tl = vl.f603a;
                tl.getClass();
                view.getX();
                view.getY();
                view.getWidth();
                view.getHeight();
                tl.f(view);
                Tl tl2 = vl.f618b;
                tl2.getClass();
                view.getX();
                view.getY();
                view.getWidth();
                view.getHeight();
                tl2.f(view);
                ArrayList arrayList = rhVar.a.get(-1);
                if (arrayList != null) {
                    vl.f621b.addAll(arrayList);
                }
                vl.h(motionLayout.getWidth(), motionLayout.getHeight(), System.nanoTime());
                int i5 = this.e;
                int i6 = this.f;
                int i7 = this.b;
                Context context = motionLayout.getContext();
                int i8 = this.h;
                if (i8 == -2) {
                    interpolator = AnimationUtils.loadInterpolator(context, this.i);
                } else if (i8 == -1) {
                    qc = new QC(T9.c(this.f1547b));
                    new a(dVar, vl, i5, i6, i7, qc, this.j, this.k);
                    return;
                } else if (i8 == 0) {
                    interpolator = new AccelerateDecelerateInterpolator();
                } else if (i8 == 1) {
                    interpolator = new AccelerateInterpolator();
                } else if (i8 == 2) {
                    interpolator = new DecelerateInterpolator();
                } else if (i8 == 4) {
                    interpolator = new BounceInterpolator();
                } else if (i8 == 5) {
                    interpolator = new OvershootInterpolator();
                } else if (i8 != 6) {
                    interpolator = null;
                } else {
                    interpolator = new AnticipateInterpolator();
                }
                qc = interpolator;
                new a(dVar, vl, i5, i6, i7, qc, this.j, this.k);
                return;
            }
            ConstraintSet.a aVar = this.f1543a;
            if (i4 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i9 : constraintSetIds) {
                    if (i9 != i3) {
                        a aVar2 = motionLayout2.f1447a;
                        if (aVar2 == null) {
                            constraintSet2 = null;
                        } else {
                            constraintSet2 = aVar2.b(i9);
                        }
                        for (View id : viewArr2) {
                            ConstraintSet.a i10 = constraintSet2.i(id.getId());
                            if (aVar != null) {
                                ConstraintSet.a.C0007a aVar3 = aVar.f1664a;
                                if (aVar3 != null) {
                                    aVar3.e(i10);
                                }
                                i10.f1670a.putAll(aVar.f1670a);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet4 = new ConstraintSet();
            HashMap<Integer, ConstraintSet.a> hashMap = constraintSet4.f1663b;
            hashMap.clear();
            for (Integer next : constraintSet3.f1663b.keySet()) {
                ConstraintSet.a aVar4 = constraintSet3.f1663b.get(next);
                if (aVar4 != null) {
                    hashMap.put(next, aVar4.clone());
                }
            }
            for (View id2 : viewArr2) {
                ConstraintSet.a i11 = constraintSet4.i(id2.getId());
                if (aVar != null) {
                    ConstraintSet.a.C0007a aVar5 = aVar.f1664a;
                    if (aVar5 != null) {
                        aVar5.e(i11);
                    }
                    i11.f1670a.putAll(aVar.f1670a);
                }
            }
            motionLayout2.u(i3, constraintSet4);
            int i12 = Ir.view_transition;
            motionLayout2.u(i12, constraintSet3);
            motionLayout2.setState(i12, -1, -1);
            a.b bVar = new a.b(motionLayout2.f1447a, i12, i3);
            for (View view2 : viewArr2) {
                int i13 = this.e;
                if (i13 != -1) {
                    bVar.f = Math.max(i13, 8);
                }
                bVar.h = this.c;
                int i14 = this.h;
                String str = this.f1547b;
                int i15 = this.i;
                bVar.d = i14;
                bVar.f1519a = str;
                bVar.e = i15;
                int id3 = view2.getId();
                if (rhVar != null) {
                    rh rhVar2 = new rh();
                    Iterator it = rhVar.a.get(-1).iterator();
                    while (it.hasNext()) {
                        C0260lh b2 = ((C0260lh) it.next()).clone();
                        b2.b = id3;
                        rhVar2.b(b2);
                    }
                    bVar.f1520a.add(rhVar2);
                }
            }
            motionLayout2.setTransition(bVar);
            PC pc = new PC(0, this, viewArr2);
            motionLayout2.f(1.0f);
            motionLayout2.f1449a = pc;
        }
    }

    public final boolean b(View view) {
        boolean z;
        boolean z2;
        int i2 = this.l;
        if (i2 != -1 && view.getTag(i2) == null) {
            z = false;
        } else {
            z = true;
        }
        int i3 = this.m;
        if (i3 == -1 || view.getTag(i3) == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public final boolean c(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.g == -1 && this.f1544a == null) || !b(view)) {
            return false;
        }
        if (view.getId() == this.g) {
            return true;
        }
        if (this.f1544a != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).f1631b) != null && str.matches(this.f1544a)) {
            return true;
        }
        return false;
    }

    public final void d(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == C0221hs.ViewTransition_android_id) {
                this.a = obtainStyledAttributes.getResourceId(index, this.a);
            } else if (index == C0221hs.ViewTransition_motionTarget) {
                if (MotionLayout.k) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.g);
                    this.g = resourceId;
                    if (resourceId == -1) {
                        this.f1544a = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.f1544a = obtainStyledAttributes.getString(index);
                } else {
                    this.g = obtainStyledAttributes.getResourceId(index, this.g);
                }
            } else if (index == C0221hs.ViewTransition_onStateTransition) {
                this.b = obtainStyledAttributes.getInt(index, this.b);
            } else if (index == C0221hs.ViewTransition_transitionDisable) {
                this.f1546a = obtainStyledAttributes.getBoolean(index, this.f1546a);
            } else if (index == C0221hs.ViewTransition_pathMotionArc) {
                this.c = obtainStyledAttributes.getInt(index, this.c);
            } else if (index == C0221hs.ViewTransition_duration) {
                this.e = obtainStyledAttributes.getInt(index, this.e);
            } else if (index == C0221hs.ViewTransition_upDuration) {
                this.f = obtainStyledAttributes.getInt(index, this.f);
            } else if (index == C0221hs.ViewTransition_viewTransitionMode) {
                this.d = obtainStyledAttributes.getInt(index, this.d);
            } else if (index == C0221hs.ViewTransition_motionInterpolator) {
                int i3 = obtainStyledAttributes.peekValue(index).type;
                if (i3 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.i = resourceId2;
                    if (resourceId2 != -1) {
                        this.h = -2;
                    }
                } else if (i3 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1547b = string;
                    if (string == null || string.indexOf(RemoteSettings.FORWARD_SLASH_STRING) <= 0) {
                        this.h = -1;
                    } else {
                        this.i = obtainStyledAttributes.getResourceId(index, -1);
                        this.h = -2;
                    }
                } else {
                    this.h = obtainStyledAttributes.getInteger(index, this.h);
                }
            } else if (index == C0221hs.ViewTransition_setsTag) {
                this.j = obtainStyledAttributes.getResourceId(index, this.j);
            } else if (index == C0221hs.ViewTransition_clearsTag) {
                this.k = obtainStyledAttributes.getResourceId(index, this.k);
            } else if (index == C0221hs.ViewTransition_ifTagSet) {
                this.l = obtainStyledAttributes.getResourceId(index, this.l);
            } else if (index == C0221hs.ViewTransition_ifTagNotSet) {
                this.m = obtainStyledAttributes.getResourceId(index, this.m);
            } else if (index == C0221hs.ViewTransition_SharedValueId) {
                this.o = obtainStyledAttributes.getResourceId(index, this.o);
            } else if (index == C0221hs.ViewTransition_SharedValue) {
                this.n = obtainStyledAttributes.getInteger(index, this.n);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final String toString() {
        return "ViewTransition(" + C0175e8.c(this.f1542a, this.a) + ")";
    }
}
