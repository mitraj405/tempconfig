package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.logging.type.LogSeverity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: MotionScene */
public final class a {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public int f1500a;

    /* renamed from: a  reason: collision with other field name */
    public Ux f1501a = null;

    /* renamed from: a  reason: collision with other field name */
    public final SparseArray<ConstraintSet> f1502a;

    /* renamed from: a  reason: collision with other field name */
    public final SparseIntArray f1503a;

    /* renamed from: a  reason: collision with other field name */
    public MotionEvent f1504a;

    /* renamed from: a  reason: collision with other field name */
    public MotionLayout.g f1505a;

    /* renamed from: a  reason: collision with other field name */
    public final MotionLayout f1506a;

    /* renamed from: a  reason: collision with other field name */
    public b f1507a = null;

    /* renamed from: a  reason: collision with other field name */
    public final d f1508a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f1509a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, Integer> f1510a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1511a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public int f1512b;

    /* renamed from: b  reason: collision with other field name */
    public b f1513b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<b> f1514b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1515b;
    public boolean c;

    /* renamed from: androidx.constraintlayout.motion.widget.a$a  reason: collision with other inner class name */
    /* compiled from: MotionScene */
    public class C0005a implements Interpolator {
        public final /* synthetic */ T9 a;

        public C0005a(T9 t9) {
            this.a = t9;
        }

        public final float getInterpolation(float f) {
            return (float) this.a.a((double) f);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r12, androidx.constraintlayout.motion.widget.MotionLayout r13, int r14) {
        /*
            r11 = this;
            r11.<init>()
            r0 = 0
            r11.f1501a = r0
            r11.f1507a = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r11.f1509a = r1
            r11.f1513b = r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r11.f1514b = r2
            android.util.SparseArray r2 = new android.util.SparseArray
            r2.<init>()
            r11.f1502a = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r11.f1510a = r2
            android.util.SparseIntArray r2 = new android.util.SparseIntArray
            r2.<init>()
            r11.f1503a = r2
            r2 = 400(0x190, float:5.6E-43)
            r11.f1500a = r2
            r2 = 0
            r11.f1512b = r2
            r11.f1511a = r2
            r11.f1515b = r2
            r11.f1506a = r13
            androidx.constraintlayout.motion.widget.d r3 = new androidx.constraintlayout.motion.widget.d
            r3.<init>(r13)
            r11.f1508a = r3
            android.content.res.Resources r13 = r12.getResources()
            android.content.res.XmlResourceParser r13 = r13.getXml(r14)
            int r3 = r13.getEventType()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r4 = r0
        L_0x004e:
            r5 = 1
            if (r3 == r5) goto L_0x0191
            if (r3 == 0) goto L_0x017f
            r6 = 2
            if (r3 == r6) goto L_0x0058
            goto L_0x0182
        L_0x0058:
            java.lang.String r3 = r13.getName()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            int r7 = r3.hashCode()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r8 = 4
            r9 = 5
            r10 = -1
            switch(r7) {
                case -1349929691: goto L_0x00c4;
                case -1239391468: goto L_0x00b9;
                case -687739768: goto L_0x00af;
                case 61998586: goto L_0x00a4;
                case 269306229: goto L_0x009b;
                case 312750793: goto L_0x0091;
                case 327855227: goto L_0x0087;
                case 793277014: goto L_0x007d;
                case 1382829617: goto L_0x0073;
                case 1942574248: goto L_0x0068;
                default: goto L_0x0066;
            }     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
        L_0x0066:
            goto L_0x00ce
        L_0x0068:
            java.lang.String r5 = "include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = 6
            goto L_0x00cf
        L_0x0073:
            java.lang.String r5 = "StateSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = r8
            goto L_0x00cf
        L_0x007d:
            java.lang.String r5 = "MotionScene"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = r2
            goto L_0x00cf
        L_0x0087:
            java.lang.String r5 = "OnSwipe"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = r6
            goto L_0x00cf
        L_0x0091:
            java.lang.String r5 = "OnClick"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = 3
            goto L_0x00cf
        L_0x009b:
            java.lang.String r6 = "Transition"
            boolean r3 = r3.equals(r6)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00a4:
            java.lang.String r5 = "ViewTransition"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = 9
            goto L_0x00cf
        L_0x00af:
            java.lang.String r5 = "Include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = 7
            goto L_0x00cf
        L_0x00b9:
            java.lang.String r5 = "KeyFrameSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = 8
            goto L_0x00cf
        L_0x00c4:
            java.lang.String r5 = "ConstraintSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x00ce
            r5 = r9
            goto L_0x00cf
        L_0x00ce:
            r5 = r10
        L_0x00cf:
            switch(r5) {
                case 0: goto L_0x017b;
                case 1: goto L_0x014c;
                case 2: goto L_0x0134;
                case 3: goto L_0x0127;
                case 4: goto L_0x011f;
                case 5: goto L_0x011b;
                case 6: goto L_0x0116;
                case 7: goto L_0x0116;
                case 8: goto L_0x0108;
                case 9: goto L_0x00d4;
                default: goto L_0x00d2;
            }     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
        L_0x00d2:
            goto L_0x0182
        L_0x00d4:
            androidx.constraintlayout.motion.widget.c r3 = new androidx.constraintlayout.motion.widget.c     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.<init>(r12, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            androidx.constraintlayout.motion.widget.d r5 = r11.f1508a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r6 = r5.f1558a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r6.add(r3)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r5.f1559a = r0     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            int r5 = r3.b     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r5 != r8) goto L_0x00f6
            androidx.constraintlayout.widget.SharedValues r5 = androidx.constraintlayout.widget.ConstraintLayout.getSharedValues()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            int r3 = r3.o     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            RC r6 = new RC     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r5.a(r3, r6)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x00f6:
            if (r5 != r9) goto L_0x0182
            androidx.constraintlayout.widget.SharedValues r5 = androidx.constraintlayout.widget.ConstraintLayout.getSharedValues()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            int r3 = r3.o     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            RC r6 = new RC     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r5.a(r3, r6)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x0108:
            rh r3 = new rh     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.<init>(r12, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r4 == 0) goto L_0x0182
            java.util.ArrayList<rh> r5 = r4.f1520a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x0116:
            r11.k(r12, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x011b:
            r11.i(r12, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x011f:
            Ux r3 = new Ux     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.<init>(r12, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r11.f1501a = r3     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x0127:
            if (r4 == 0) goto L_0x0182
            androidx.constraintlayout.motion.widget.a$b$a r3 = new androidx.constraintlayout.motion.widget.a$b$a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.<init>(r12, r4, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b$a> r5 = r4.f1522b     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x0134:
            if (r4 != 0) goto L_0x0140
            android.content.res.Resources r3 = r12.getResources()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.getResourceEntryName(r14)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
        L_0x0140:
            if (r4 == 0) goto L_0x0182
            androidx.constraintlayout.motion.widget.b r3 = new androidx.constraintlayout.motion.widget.b     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r11.f1506a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.<init>(r12, r5, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r4.f1518a = r3     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x014c:
            androidx.constraintlayout.motion.widget.a$b r4 = new androidx.constraintlayout.motion.widget.a$b     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r4.<init>((androidx.constraintlayout.motion.widget.a) r11, (android.content.Context) r12, (android.content.res.XmlResourceParser) r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r1.add(r4)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            androidx.constraintlayout.motion.widget.a$b r3 = r11.f1507a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 != 0) goto L_0x0167
            boolean r3 = r4.f1521a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 != 0) goto L_0x0167
            r11.f1507a = r4     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            androidx.constraintlayout.motion.widget.b r3 = r4.f1518a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x0167
            boolean r5 = r11.c     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.c(r5)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
        L_0x0167:
            boolean r3 = r4.f1521a     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 == 0) goto L_0x0182
            int r3 = r4.b     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            if (r3 != r10) goto L_0x0172
            r11.f1513b = r4     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0177
        L_0x0172:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r3 = r11.f1514b     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            r3.add(r4)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
        L_0x0177:
            r1.remove(r4)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x017b:
            r11.l(r12, r13)     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x0182
        L_0x017f:
            r13.getName()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
        L_0x0182:
            int r3 = r13.next()     // Catch:{ XmlPullParserException -> 0x018d, IOException -> 0x0188 }
            goto L_0x004e
        L_0x0188:
            r12 = move-exception
            r12.printStackTrace()
            goto L_0x0191
        L_0x018d:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0191:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r12 = r11.f1502a
            int r13 = defpackage.Ir.motion_base
            androidx.constraintlayout.widget.ConstraintSet r14 = new androidx.constraintlayout.widget.ConstraintSet
            r14.<init>()
            r12.put(r13, r14)
            java.util.HashMap<java.lang.String, java.lang.Integer> r12 = r11.f1510a
            java.lang.String r14 = "motion_base"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r12.put(r14, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.a.<init>(android.content.Context, androidx.constraintlayout.motion.widget.MotionLayout, int):void");
    }

    public final boolean a(int i, MotionLayout motionLayout) {
        boolean z;
        boolean z2;
        if (this.f1505a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        Iterator<b> it = this.f1509a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = next.g;
            if (i2 != 0) {
                b bVar = this.f1507a;
                if (bVar == next) {
                    if ((bVar.j & 2) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        continue;
                    }
                }
                int i3 = next.c;
                MotionLayout.j jVar = MotionLayout.j.FINISHED;
                MotionLayout.j jVar2 = MotionLayout.j.MOVING;
                MotionLayout.j jVar3 = MotionLayout.j.SETUP;
                if (i == i3 && (i2 == 4 || i2 == 2)) {
                    motionLayout.setState(jVar);
                    motionLayout.setTransition(next);
                    if (next.g == 4) {
                        motionLayout.s();
                        motionLayout.setState(jVar3);
                        motionLayout.setState(jVar2);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.h(true);
                        motionLayout.setState(jVar3);
                        motionLayout.setState(jVar2);
                        motionLayout.setState(jVar);
                        motionLayout.o();
                    }
                    return true;
                } else if (i == next.b && (i2 == 3 || i2 == 1)) {
                    motionLayout.setState(jVar);
                    motionLayout.setTransition(next);
                    if (next.g == 3) {
                        motionLayout.f(0.0f);
                        motionLayout.setState(jVar3);
                        motionLayout.setState(jVar2);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.h(true);
                        motionLayout.setState(jVar3);
                        motionLayout.setState(jVar2);
                        motionLayout.setState(jVar);
                        motionLayout.o();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final ConstraintSet b(int i) {
        int a2;
        SparseArray<ConstraintSet> sparseArray = this.f1502a;
        Ux ux = this.f1501a;
        if (!(ux == null || (a2 = ux.a(i)) == -1)) {
            i = a2;
        }
        if (sparseArray.get(i) != null) {
            return sparseArray.get(i);
        }
        C0175e8.c(this.f1506a.getContext(), i);
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public final int c() {
        b bVar = this.f1507a;
        if (bVar != null) {
            return bVar.f;
        }
        return this.f1500a;
    }

    public final int d(Context context, String str) {
        int i;
        if (str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), FacebookMediationAdapter.KEY_ID, context.getPackageName());
        } else {
            i = -1;
        }
        if (i != -1 || str.length() <= 1) {
            return i;
        }
        return Integer.parseInt(str.substring(1));
    }

    public final Interpolator e() {
        b bVar = this.f1507a;
        int i = bVar.d;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(this.f1506a.getContext(), this.f1507a.e);
        }
        if (i == -1) {
            return new C0005a(T9.c(bVar.f1519a));
        }
        if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i == 4) {
            return new BounceInterpolator();
        }
        if (i == 5) {
            return new OvershootInterpolator();
        }
        if (i != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public final void f(Vl vl) {
        b bVar = this.f1507a;
        if (bVar == null) {
            b bVar2 = this.f1513b;
            if (bVar2 != null) {
                Iterator<rh> it = bVar2.f1520a.iterator();
                while (it.hasNext()) {
                    it.next().a(vl);
                }
                return;
            }
            return;
        }
        Iterator<rh> it2 = bVar.f1520a.iterator();
        while (it2.hasNext()) {
            it2.next().a(vl);
        }
    }

    public final float g() {
        b bVar;
        b bVar2 = this.f1507a;
        if (bVar2 == null || (bVar = bVar2.f1518a) == null) {
            return 0.0f;
        }
        return bVar.h;
    }

    public final int h() {
        b bVar = this.f1507a;
        if (bVar == null) {
            return -1;
        }
        return bVar.c;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int i(android.content.Context r14, android.content.res.XmlResourceParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = new androidx.constraintlayout.widget.ConstraintSet
            r0.<init>()
            r1 = 0
            r0.f1661a = r1
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = r1
            r5 = r3
            r6 = r5
        L_0x0010:
            if (r4 >= r2) goto L_0x00d8
            java.lang.String r7 = r15.getAttributeName(r4)
            java.lang.String r8 = r15.getAttributeValue(r4)
            r7.getClass()
            int r9 = r7.hashCode()
            r10 = 2
            r11 = 1
            switch(r9) {
                case -1496482599: goto L_0x003e;
                case -1153153640: goto L_0x0033;
                case 3355: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            r7 = r3
            goto L_0x0048
        L_0x0028:
            java.lang.String r9 = "id"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0031
            goto L_0x0026
        L_0x0031:
            r7 = r10
            goto L_0x0048
        L_0x0033:
            java.lang.String r9 = "constraintRotate"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x003c
            goto L_0x0026
        L_0x003c:
            r7 = r11
            goto L_0x0048
        L_0x003e:
            java.lang.String r9 = "deriveConstraintsFrom"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0047
            goto L_0x0026
        L_0x0047:
            r7 = r1
        L_0x0048:
            switch(r7) {
                case 0: goto L_0x00d0;
                case 1: goto L_0x0071;
                case 2: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x00d4
        L_0x004d:
            int r5 = r13.d(r14, r8)
            r7 = 47
            int r7 = r8.indexOf(r7)
            if (r7 >= 0) goto L_0x005a
            goto L_0x0060
        L_0x005a:
            int r7 = r7 + 1
            java.lang.String r8 = r8.substring(r7)
        L_0x0060:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.util.HashMap<java.lang.String, java.lang.Integer> r9 = r13.f1510a
            r9.put(r8, r7)
            java.lang.String r7 = defpackage.C0175e8.c(r14, r5)
            r0.f1659a = r7
            goto L_0x00d4
        L_0x0071:
            int r7 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0079 }
            r0.f1658a = r7     // Catch:{ NumberFormatException -> 0x0079 }
            goto L_0x00d4
        L_0x0079:
            r8.getClass()
            int r7 = r8.hashCode()
            r9 = 3
            r12 = 4
            switch(r7) {
                case -768416914: goto L_0x00b3;
                case 3317767: goto L_0x00a8;
                case 3387192: goto L_0x009d;
                case 108511772: goto L_0x0092;
                case 1954540437: goto L_0x0087;
                default: goto L_0x0085;
            }
        L_0x0085:
            r7 = r3
            goto L_0x00bd
        L_0x0087:
            java.lang.String r7 = "x_right"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x0090
            goto L_0x0085
        L_0x0090:
            r7 = r12
            goto L_0x00bd
        L_0x0092:
            java.lang.String r7 = "right"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x009b
            goto L_0x0085
        L_0x009b:
            r7 = r9
            goto L_0x00bd
        L_0x009d:
            java.lang.String r7 = "none"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x00a6
            goto L_0x0085
        L_0x00a6:
            r7 = r10
            goto L_0x00bd
        L_0x00a8:
            java.lang.String r7 = "left"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x00b1
            goto L_0x0085
        L_0x00b1:
            r7 = r11
            goto L_0x00bd
        L_0x00b3:
            java.lang.String r7 = "x_left"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x00bc
            goto L_0x0085
        L_0x00bc:
            r7 = r1
        L_0x00bd:
            switch(r7) {
                case 0: goto L_0x00cd;
                case 1: goto L_0x00ca;
                case 2: goto L_0x00c7;
                case 3: goto L_0x00c4;
                case 4: goto L_0x00c1;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            goto L_0x00d4
        L_0x00c1:
            r0.f1658a = r9
            goto L_0x00d4
        L_0x00c4:
            r0.f1658a = r11
            goto L_0x00d4
        L_0x00c7:
            r0.f1658a = r1
            goto L_0x00d4
        L_0x00ca:
            r0.f1658a = r10
            goto L_0x00d4
        L_0x00cd:
            r0.f1658a = r12
            goto L_0x00d4
        L_0x00d0:
            int r6 = r13.d(r14, r8)
        L_0x00d4:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x00d8:
            if (r5 == r3) goto L_0x00ed
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.f1506a
            int r1 = r1.f1472h
            r0.k(r14, r15)
            if (r6 == r3) goto L_0x00e8
            android.util.SparseIntArray r14 = r13.f1503a
            r14.put(r5, r6)
        L_0x00e8:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r14 = r13.f1502a
            r14.put(r5, r0)
        L_0x00ed:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.a.i(android.content.Context, android.content.res.XmlResourceParser):int");
    }

    public final int j(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return i(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public final void k(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0221hs.include_constraintSet) {
                j(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void l(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0221hs.MotionScene_defaultDuration) {
                int i2 = obtainStyledAttributes.getInt(index, this.f1500a);
                this.f1500a = i2;
                if (i2 < 8) {
                    this.f1500a = 8;
                }
            } else if (index == C0221hs.MotionScene_layoutDuringTransition) {
                this.f1512b = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void m(int i, MotionLayout motionLayout) {
        SparseArray<ConstraintSet> sparseArray = this.f1502a;
        ConstraintSet constraintSet = sparseArray.get(i);
        constraintSet.f1662b = constraintSet.f1659a;
        int i2 = this.f1503a.get(i);
        HashMap<Integer, ConstraintSet.a> hashMap = constraintSet.f1663b;
        if (i2 > 0) {
            m(i2, motionLayout);
            ConstraintSet constraintSet2 = sparseArray.get(i2);
            if (constraintSet2 == null) {
                C0175e8.c(this.f1506a.getContext(), i2);
                return;
            }
            constraintSet.f1662b += RemoteSettings.FORWARD_SLASH_STRING + constraintSet2.f1662b;
            HashMap<Integer, ConstraintSet.a> hashMap2 = constraintSet2.f1663b;
            for (Integer next : hashMap2.keySet()) {
                int intValue = next.intValue();
                ConstraintSet.a aVar = hashMap2.get(next);
                if (!hashMap.containsKey(Integer.valueOf(intValue))) {
                    hashMap.put(Integer.valueOf(intValue), new ConstraintSet.a());
                }
                ConstraintSet.a aVar2 = hashMap.get(Integer.valueOf(intValue));
                if (aVar2 != null) {
                    ConstraintSet.b bVar = aVar2.f1665a;
                    if (!bVar.f1685b) {
                        bVar.a(aVar.f1665a);
                    }
                    ConstraintSet.d dVar = aVar2.f1667a;
                    if (!dVar.f1705a) {
                        ConstraintSet.d dVar2 = aVar.f1667a;
                        dVar.f1705a = dVar2.f1705a;
                        dVar.f1704a = dVar2.f1704a;
                        dVar.a = dVar2.a;
                        dVar.b = dVar2.b;
                        dVar.f1706b = dVar2.f1706b;
                    }
                    ConstraintSet.e eVar = aVar2.f1668a;
                    if (!eVar.f1709a) {
                        eVar.a(aVar.f1668a);
                    }
                    ConstraintSet.c cVar = aVar2.f1666a;
                    if (!cVar.f1700a) {
                        cVar.a(aVar.f1666a);
                    }
                    for (String next2 : aVar.f1670a.keySet()) {
                        if (!aVar2.f1670a.containsKey(next2)) {
                            aVar2.f1670a.put(next2, aVar.f1670a.get(next2));
                        }
                    }
                }
            }
        } else {
            constraintSet.f1662b = C0709Uj.j(new StringBuilder(), constraintSet.f1662b, "  layout");
            int childCount = motionLayout.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = motionLayout.getChildAt(i3);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                int id = childAt.getId();
                if (!constraintSet.f1661a || id != -1) {
                    if (!hashMap.containsKey(Integer.valueOf(id))) {
                        hashMap.put(Integer.valueOf(id), new ConstraintSet.a());
                    }
                    ConstraintSet.a aVar3 = hashMap.get(Integer.valueOf(id));
                    if (aVar3 != null) {
                        ConstraintSet.b bVar2 = aVar3.f1665a;
                        if (!bVar2.f1685b) {
                            aVar3.c(id, layoutParams);
                            if (childAt instanceof ConstraintHelper) {
                                bVar2.f1682a = ((ConstraintHelper) childAt).getReferencedIds();
                                if (childAt instanceof Barrier) {
                                    Barrier barrier = (Barrier) childAt;
                                    bVar2.f1694f = barrier.getAllowsGoneWidget();
                                    bVar2.U = barrier.getType();
                                    bVar2.V = barrier.getMargin();
                                }
                            }
                            bVar2.f1685b = true;
                        }
                        ConstraintSet.d dVar3 = aVar3.f1667a;
                        if (!dVar3.f1705a) {
                            dVar3.f1704a = childAt.getVisibility();
                            dVar3.a = childAt.getAlpha();
                            dVar3.f1705a = true;
                        }
                        ConstraintSet.e eVar2 = aVar3.f1668a;
                        if (!eVar2.f1709a) {
                            eVar2.f1709a = true;
                            eVar2.f1707a = childAt.getRotation();
                            eVar2.b = childAt.getRotationX();
                            eVar2.c = childAt.getRotationY();
                            eVar2.d = childAt.getScaleX();
                            eVar2.e = childAt.getScaleY();
                            float pivotX = childAt.getPivotX();
                            float pivotY = childAt.getPivotY();
                            if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                                eVar2.f = pivotX;
                                eVar2.g = pivotY;
                            }
                            eVar2.h = childAt.getTranslationX();
                            eVar2.i = childAt.getTranslationY();
                            eVar2.j = childAt.getTranslationZ();
                            if (eVar2.f1710b) {
                                eVar2.k = childAt.getElevation();
                            }
                        }
                    }
                    i3++;
                } else {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
            }
        }
        for (ConstraintSet.a next3 : hashMap.values()) {
            if (next3.f1664a != null) {
                if (next3.f1669a != null) {
                    for (Integer intValue2 : hashMap.keySet()) {
                        ConstraintSet.a i4 = constraintSet.i(intValue2.intValue());
                        String str = i4.f1665a.f1687c;
                        if (str != null && next3.f1669a.matches(str)) {
                            next3.f1664a.e(i4);
                            i4.f1670a.putAll((HashMap) next3.f1670a.clone());
                        }
                    }
                } else {
                    next3.f1664a.e(constraintSet.i(next3.a));
                }
            }
        }
    }

    public final void n(MotionLayout motionLayout) {
        boolean z;
        int i = 0;
        while (true) {
            SparseArray<ConstraintSet> sparseArray = this.f1502a;
            if (i < sparseArray.size()) {
                int keyAt = sparseArray.keyAt(i);
                SparseIntArray sparseIntArray = this.f1503a;
                int i2 = sparseIntArray.get(keyAt);
                int size = sparseIntArray.size();
                while (true) {
                    if (i2 <= 0) {
                        z = false;
                        break;
                    } else if (i2 == keyAt) {
                        break;
                    } else {
                        int i3 = size - 1;
                        if (size < 0) {
                            break;
                        }
                        i2 = sparseIntArray.get(i2);
                        size = i3;
                    }
                }
                z = true;
                if (!z) {
                    m(keyAt, motionLayout);
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(int r9, int r10) {
        /*
            r8 = this;
            Ux r0 = r8.f1501a
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.a(r9)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r9
        L_0x000d:
            Ux r2 = r8.f1501a
            int r2 = r2.a(r10)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r9
        L_0x0017:
            r2 = r10
        L_0x0018:
            androidx.constraintlayout.motion.widget.a$b r3 = r8.f1507a
            if (r3 == 0) goto L_0x0025
            int r4 = r3.b
            if (r4 != r10) goto L_0x0025
            int r3 = r3.c
            if (r3 != r9) goto L_0x0025
            return
        L_0x0025:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r3 = r8.f1509a
            java.util.Iterator r4 = r3.iterator()
        L_0x002b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0051
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.motion.widget.a$b r5 = (androidx.constraintlayout.motion.widget.a.b) r5
            int r6 = r5.b
            if (r6 != r2) goto L_0x003f
            int r7 = r5.c
            if (r7 == r0) goto L_0x0045
        L_0x003f:
            if (r6 != r10) goto L_0x002b
            int r6 = r5.c
            if (r6 != r9) goto L_0x002b
        L_0x0045:
            r8.f1507a = r5
            androidx.constraintlayout.motion.widget.b r9 = r5.f1518a
            if (r9 == 0) goto L_0x0050
            boolean r10 = r8.c
            r9.c(r10)
        L_0x0050:
            return
        L_0x0051:
            androidx.constraintlayout.motion.widget.a$b r9 = r8.f1513b
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r4 = r8.f1514b
            java.util.Iterator r4 = r4.iterator()
        L_0x0059:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x006b
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.motion.widget.a$b r5 = (androidx.constraintlayout.motion.widget.a.b) r5
            int r6 = r5.b
            if (r6 != r10) goto L_0x0059
            r9 = r5
            goto L_0x0059
        L_0x006b:
            androidx.constraintlayout.motion.widget.a$b r10 = new androidx.constraintlayout.motion.widget.a$b
            r10.<init>(r8, r9)
            r10.c = r0
            r10.b = r2
            if (r0 == r1) goto L_0x0079
            r3.add(r10)
        L_0x0079:
            r8.f1507a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.a.o(int, int):void");
    }

    public final boolean p() {
        Iterator<b> it = this.f1509a.iterator();
        while (it.hasNext()) {
            if (it.next().f1518a != null) {
                return true;
            }
        }
        b bVar = this.f1507a;
        if (bVar == null || bVar.f1518a == null) {
            return false;
        }
        return true;
    }

    /* compiled from: MotionScene */
    public static class b {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public int f1516a;

        /* renamed from: a  reason: collision with other field name */
        public final a f1517a;

        /* renamed from: a  reason: collision with other field name */
        public b f1518a;

        /* renamed from: a  reason: collision with other field name */
        public String f1519a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<rh> f1520a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1521a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public final ArrayList<C0006a> f1522b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1523b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;

        /* renamed from: androidx.constraintlayout.motion.widget.a$b$a  reason: collision with other inner class name */
        /* compiled from: MotionScene */
        public static class C0006a implements View.OnClickListener {
            public final b a;
            public final int c = -1;
            public final int d = 17;

            public C0006a(Context context, b bVar, XmlResourceParser xmlResourceParser) {
                this.a = bVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == C0221hs.OnClick_targetId) {
                        this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    } else if (index == C0221hs.OnClick_clickAction) {
                        this.d = obtainStyledAttributes.getInt(index, this.d);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public final void a(MotionLayout motionLayout, int i, b bVar) {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                int i2 = this.c;
                View view = motionLayout;
                if (i2 != -1) {
                    view = motionLayout.findViewById(i2);
                }
                if (view != null) {
                    int i3 = bVar.c;
                    int i4 = bVar.b;
                    if (i3 == -1) {
                        view.setOnClickListener(this);
                        return;
                    }
                    int i5 = this.d;
                    int i6 = i5 & 1;
                    boolean z5 = true;
                    if (i6 == 0 || i != i3) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if ((i5 & 256) == 0 || i != i3) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    boolean z6 = z | z2;
                    if (i6 == 0 || i != i3) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    boolean z7 = z3 | z6;
                    if ((i5 & 16) == 0 || i != i4) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    boolean z8 = z7 | z4;
                    if ((i5 & 4096) == 0 || i != i4) {
                        z5 = false;
                    }
                    if (z8 || z5) {
                        view.setOnClickListener(this);
                    }
                }
            }

            public final void onClick(View view) {
                boolean z;
                boolean z2;
                boolean z3;
                int i;
                b bVar = this.a;
                a aVar = bVar.f1517a;
                MotionLayout motionLayout = aVar.f1506a;
                if (motionLayout.f1454a) {
                    if (bVar.c == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            int i2 = bVar.b;
                            if (!motionLayout.isAttachedToWindow()) {
                                if (motionLayout.f1444a == null) {
                                    motionLayout.f1444a = new MotionLayout.h();
                                }
                                motionLayout.f1444a.f1498b = i2;
                                return;
                            }
                            motionLayout.t(i2, -1);
                            return;
                        }
                        b bVar2 = new b(bVar.f1517a, bVar);
                        bVar2.c = currentState;
                        bVar2.b = bVar.b;
                        motionLayout.setTransition(bVar2);
                        motionLayout.s();
                        return;
                    }
                    b bVar3 = aVar.f1507a;
                    int i3 = this.d;
                    int i4 = i3 & 1;
                    boolean z4 = true;
                    if (i4 == 0 && (i3 & 256) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    int i5 = i3 & 16;
                    if (i5 == 0 && (i3 & 4096) == 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z || !z2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        if (bVar3 != bVar) {
                            motionLayout.setTransition(bVar);
                        }
                        if (motionLayout.getCurrentState() == motionLayout.getEndState() || motionLayout.getProgress() > 0.5f) {
                            z = false;
                        } else {
                            z2 = false;
                        }
                    }
                    if (bVar != bVar3) {
                        int i6 = bVar.b;
                        int i7 = bVar.c;
                        if (i7 != -1 ? !((i = motionLayout.f1462d) == i7 || i == i6) : motionLayout.f1462d == i6) {
                            z4 = false;
                        }
                    }
                    if (!z4) {
                        return;
                    }
                    if (z && i4 != 0) {
                        motionLayout.setTransition(bVar);
                        motionLayout.s();
                    } else if (z2 && i5 != 0) {
                        motionLayout.setTransition(bVar);
                        motionLayout.f(0.0f);
                    } else if (z && (i3 & 256) != 0) {
                        motionLayout.setTransition(bVar);
                        motionLayout.setProgress(1.0f);
                    } else if (z2 && (i3 & 4096) != 0) {
                        motionLayout.setTransition(bVar);
                        motionLayout.setProgress(0.0f);
                    }
                }
            }
        }

        public b(a aVar, b bVar) {
            this.f1516a = -1;
            this.f1521a = false;
            this.b = -1;
            this.c = -1;
            this.d = 0;
            this.f1519a = null;
            this.e = -1;
            this.f = LogSeverity.WARNING_VALUE;
            this.a = 0.0f;
            this.f1520a = new ArrayList<>();
            this.f1518a = null;
            this.f1522b = new ArrayList<>();
            this.g = 0;
            this.f1523b = false;
            this.h = -1;
            this.i = 0;
            this.j = 0;
            this.f1517a = aVar;
            this.f = aVar.f1500a;
            if (bVar != null) {
                this.h = bVar.h;
                this.d = bVar.d;
                this.f1519a = bVar.f1519a;
                this.e = bVar.e;
                this.f = bVar.f;
                this.f1520a = bVar.f1520a;
                this.a = bVar.a;
                this.i = bVar.i;
            }
        }

        public b(a aVar, int i2, int i3) {
            this.f1516a = -1;
            this.f1521a = false;
            this.b = -1;
            this.c = -1;
            this.d = 0;
            this.f1519a = null;
            this.e = -1;
            this.f = LogSeverity.WARNING_VALUE;
            this.a = 0.0f;
            this.f1520a = new ArrayList<>();
            this.f1518a = null;
            this.f1522b = new ArrayList<>();
            this.g = 0;
            this.f1523b = false;
            this.h = -1;
            this.i = 0;
            this.j = 0;
            this.f1516a = -1;
            this.f1517a = aVar;
            this.c = i2;
            this.b = i3;
            this.f = aVar.f1500a;
            this.i = aVar.f1512b;
        }

        public b(a aVar, Context context, XmlResourceParser xmlResourceParser) {
            this.f1516a = -1;
            this.f1521a = false;
            this.b = -1;
            this.c = -1;
            this.d = 0;
            this.f1519a = null;
            this.e = -1;
            this.f = LogSeverity.WARNING_VALUE;
            this.a = 0.0f;
            this.f1520a = new ArrayList<>();
            this.f1518a = null;
            this.f1522b = new ArrayList<>();
            this.g = 0;
            this.f1523b = false;
            this.h = -1;
            this.i = 0;
            this.j = 0;
            this.f = aVar.f1500a;
            this.i = aVar.f1512b;
            this.f1517a = aVar;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.Transition);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = C0221hs.Transition_constraintSetEnd;
                SparseArray<ConstraintSet> sparseArray = aVar.f1502a;
                if (index == i3) {
                    this.b = obtainStyledAttributes.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.b);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.j(context, this.b);
                        sparseArray.append(this.b, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.b = aVar.j(context, this.b);
                    }
                } else if (index == C0221hs.Transition_constraintSetStart) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.c);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.j(context, this.c);
                        sparseArray.append(this.c, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.c = aVar.j(context, this.c);
                    }
                } else if (index == C0221hs.Transition_motionInterpolator) {
                    int i4 = obtainStyledAttributes.peekValue(index).type;
                    if (i4 == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.e = resourceId;
                        if (resourceId != -1) {
                            this.d = -2;
                        }
                    } else if (i4 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f1519a = string;
                        if (string != null) {
                            if (string.indexOf(RemoteSettings.FORWARD_SLASH_STRING) > 0) {
                                this.e = obtainStyledAttributes.getResourceId(index, -1);
                                this.d = -2;
                            } else {
                                this.d = -1;
                            }
                        }
                    } else {
                        this.d = obtainStyledAttributes.getInteger(index, this.d);
                    }
                } else if (index == C0221hs.Transition_duration) {
                    int i5 = obtainStyledAttributes.getInt(index, this.f);
                    this.f = i5;
                    if (i5 < 8) {
                        this.f = 8;
                    }
                } else if (index == C0221hs.Transition_staggered) {
                    this.a = obtainStyledAttributes.getFloat(index, this.a);
                } else if (index == C0221hs.Transition_autoTransition) {
                    this.g = obtainStyledAttributes.getInteger(index, this.g);
                } else if (index == C0221hs.Transition_android_id) {
                    this.f1516a = obtainStyledAttributes.getResourceId(index, this.f1516a);
                } else if (index == C0221hs.Transition_transitionDisable) {
                    this.f1523b = obtainStyledAttributes.getBoolean(index, this.f1523b);
                } else if (index == C0221hs.Transition_pathMotionArc) {
                    this.h = obtainStyledAttributes.getInteger(index, -1);
                } else if (index == C0221hs.Transition_layoutDuringTransition) {
                    this.i = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == C0221hs.Transition_transitionFlags) {
                    this.j = obtainStyledAttributes.getInteger(index, 0);
                }
            }
            if (this.c == -1) {
                this.f1521a = true;
            }
            obtainStyledAttributes.recycle();
        }
    }
}
