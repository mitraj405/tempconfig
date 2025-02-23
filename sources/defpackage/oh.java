package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: oh  reason: default package */
/* compiled from: KeyCycle */
public final class oh extends C0260lh {
    public float a = Float.NaN;
    public float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    public String f3157b = null;
    public float c = 0.0f;

    /* renamed from: c  reason: collision with other field name */
    public int f3158c = 0;
    public float d = Float.NaN;

    /* renamed from: d  reason: collision with other field name */
    public int f3159d = -1;
    public float e = Float.NaN;

    /* renamed from: e  reason: collision with other field name */
    public int f3160e = -1;
    public float f = Float.NaN;
    public float g = Float.NaN;
    public float h = Float.NaN;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;

    /* renamed from: oh$a */
    /* compiled from: KeyCycle */
    public static class a {
        public static final SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.KeyCycle_motionTarget, 1);
            sparseIntArray.append(C0221hs.KeyCycle_framePosition, 2);
            sparseIntArray.append(C0221hs.KeyCycle_transitionEasing, 3);
            sparseIntArray.append(C0221hs.KeyCycle_curveFit, 4);
            sparseIntArray.append(C0221hs.KeyCycle_waveShape, 5);
            sparseIntArray.append(C0221hs.KeyCycle_wavePeriod, 6);
            sparseIntArray.append(C0221hs.KeyCycle_waveOffset, 7);
            sparseIntArray.append(C0221hs.KeyCycle_waveVariesBy, 8);
            sparseIntArray.append(C0221hs.KeyCycle_android_alpha, 9);
            sparseIntArray.append(C0221hs.KeyCycle_android_elevation, 10);
            sparseIntArray.append(C0221hs.KeyCycle_android_rotation, 11);
            sparseIntArray.append(C0221hs.KeyCycle_android_rotationX, 12);
            sparseIntArray.append(C0221hs.KeyCycle_android_rotationY, 13);
            sparseIntArray.append(C0221hs.KeyCycle_transitionPathRotate, 14);
            sparseIntArray.append(C0221hs.KeyCycle_android_scaleX, 15);
            sparseIntArray.append(C0221hs.KeyCycle_android_scaleY, 16);
            sparseIntArray.append(C0221hs.KeyCycle_android_translationX, 17);
            sparseIntArray.append(C0221hs.KeyCycle_android_translationY, 18);
            sparseIntArray.append(C0221hs.KeyCycle_android_translationZ, 19);
            sparseIntArray.append(C0221hs.KeyCycle_motionProgress, 20);
            sparseIntArray.append(C0221hs.KeyCycle_wavePhase, 21);
        }
    }

    public oh() {
        this.f3093a = new HashMap<>();
    }

    public final void a(HashMap<String, MC> hashMap) {
        hashMap.size();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(2, stackTrace.length - 1);
        String str = " ";
        for (int i2 = 1; i2 <= min; i2++) {
            stackTrace[i2].getFileName();
            stackTrace[i2].getLineNumber();
            stackTrace[i2].getMethodName();
            str = str + " ";
        }
        for (String next : hashMap.keySet()) {
            Ex ex = hashMap.get(next);
            if (ex != null) {
                next.getClass();
                char c2 = 65535;
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (next.equals("rotation")) {
                            c2 = 8;
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c2 = 9;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c2 = 10;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (next.equals("waveOffset")) {
                            c2 = 12;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (next.equals("wavePhase")) {
                            c2 = 13;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        ex.b(this.i, this.a);
                        break;
                    case 1:
                        ex.b(this.j, this.a);
                        break;
                    case 2:
                        ex.b(this.m, this.a);
                        break;
                    case 3:
                        ex.b(this.n, this.a);
                        break;
                    case 4:
                        ex.b(this.o, this.a);
                        break;
                    case 5:
                        ex.b(this.d, this.a);
                        break;
                    case 6:
                        ex.b(this.k, this.a);
                        break;
                    case 7:
                        ex.b(this.l, this.a);
                        break;
                    case 8:
                        ex.b(this.g, this.a);
                        break;
                    case 9:
                        ex.b(this.f, this.a);
                        break;
                    case 10:
                        ex.b(this.h, this.a);
                        break;
                    case 11:
                        ex.b(this.e, this.a);
                        break;
                    case 12:
                        ex.b(this.b, this.a);
                        break;
                    case 13:
                        ex.b(this.c, this.a);
                        break;
                    default:
                        next.startsWith("CUSTOM");
                        break;
                }
            }
        }
    }

    /* renamed from: b */
    public final C0260lh clone() {
        oh ohVar = new oh();
        super.c(this);
        ohVar.f3158c = this.f3158c;
        ohVar.f3159d = this.f3159d;
        ohVar.f3157b = this.f3157b;
        ohVar.a = this.a;
        ohVar.b = this.b;
        ohVar.c = this.c;
        ohVar.d = this.d;
        ohVar.f3160e = this.f3160e;
        ohVar.e = this.e;
        ohVar.f = this.f;
        ohVar.g = this.g;
        ohVar.h = this.h;
        ohVar.i = this.i;
        ohVar.j = this.j;
        ohVar.k = this.k;
        ohVar.l = this.l;
        ohVar.m = this.m;
        ohVar.n = this.n;
        ohVar.o = this.o;
        return ohVar;
    }

    public final void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.e)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.g)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.h)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("translationZ");
        }
        if (this.f3093a.size() > 0) {
            for (String str : this.f3093a.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.KeyCycle);
        SparseIntArray sparseIntArray = a.a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            SparseIntArray sparseIntArray2 = a.a;
            switch (sparseIntArray2.get(index)) {
                case 1:
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
                case 2:
                    this.a = obtainStyledAttributes.getInt(index, this.a);
                    break;
                case 3:
                    obtainStyledAttributes.getString(index);
                    break;
                case 4:
                    this.f3158c = obtainStyledAttributes.getInteger(index, this.f3158c);
                    break;
                case 5:
                    if (obtainStyledAttributes.peekValue(index).type != 3) {
                        this.f3159d = obtainStyledAttributes.getInt(index, this.f3159d);
                        break;
                    } else {
                        this.f3157b = obtainStyledAttributes.getString(index);
                        this.f3159d = 7;
                        break;
                    }
                case 6:
                    this.a = obtainStyledAttributes.getFloat(index, this.a);
                    break;
                case 7:
                    if (obtainStyledAttributes.peekValue(index).type != 5) {
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    } else {
                        this.b = obtainStyledAttributes.getDimension(index, this.b);
                        break;
                    }
                case 8:
                    this.f3160e = obtainStyledAttributes.getInt(index, this.f3160e);
                    break;
                case 9:
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                    break;
                case 10:
                    this.f = obtainStyledAttributes.getDimension(index, this.f);
                    break;
                case 11:
                    this.g = obtainStyledAttributes.getFloat(index, this.g);
                    break;
                case 12:
                    this.i = obtainStyledAttributes.getFloat(index, this.i);
                    break;
                case 13:
                    this.j = obtainStyledAttributes.getFloat(index, this.j);
                    break;
                case 14:
                    this.h = obtainStyledAttributes.getFloat(index, this.h);
                    break;
                case 15:
                    this.k = obtainStyledAttributes.getFloat(index, this.k);
                    break;
                case 16:
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                    break;
                case 17:
                    this.m = obtainStyledAttributes.getDimension(index, this.m);
                    break;
                case 18:
                    this.n = obtainStyledAttributes.getDimension(index, this.n);
                    break;
                case 19:
                    this.o = obtainStyledAttributes.getDimension(index, this.o);
                    break;
                case 20:
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                    break;
                case 21:
                    this.c = obtainStyledAttributes.getFloat(index, this.c) / 360.0f;
                    break;
                default:
                    Integer.toHexString(index);
                    sparseIntArray2.get(index);
                    break;
            }
        }
    }
}
