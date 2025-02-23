package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: zh  reason: default package and case insensitive filesystem */
/* compiled from: KeyTimeCycle */
public final class C0426zh extends C0260lh {
    public float a = Float.NaN;
    public float b = Float.NaN;
    public float c = Float.NaN;

    /* renamed from: c  reason: collision with other field name */
    public int f3485c = -1;
    public float d = Float.NaN;

    /* renamed from: d  reason: collision with other field name */
    public int f3486d = 0;
    public float e = Float.NaN;
    public float f = Float.NaN;
    public float g = Float.NaN;
    public float h = Float.NaN;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = 0.0f;

    /* renamed from: zh$a */
    /* compiled from: KeyTimeCycle */
    public static class a {
        public static final SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_alpha, 1);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_elevation, 2);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_rotation, 4);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_rotationX, 5);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_rotationY, 6);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_scaleX, 7);
            sparseIntArray.append(C0221hs.KeyTimeCycle_transitionPathRotate, 8);
            sparseIntArray.append(C0221hs.KeyTimeCycle_transitionEasing, 9);
            sparseIntArray.append(C0221hs.KeyTimeCycle_motionTarget, 10);
            sparseIntArray.append(C0221hs.KeyTimeCycle_framePosition, 12);
            sparseIntArray.append(C0221hs.KeyTimeCycle_curveFit, 13);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_scaleY, 14);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_translationX, 15);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_translationY, 16);
            sparseIntArray.append(C0221hs.KeyTimeCycle_android_translationZ, 17);
            sparseIntArray.append(C0221hs.KeyTimeCycle_motionProgress, 18);
            sparseIntArray.append(C0221hs.KeyTimeCycle_wavePeriod, 20);
            sparseIntArray.append(C0221hs.KeyTimeCycle_waveOffset, 21);
            sparseIntArray.append(C0221hs.KeyTimeCycle_waveShape, 19);
        }
    }

    public C0426zh() {
        this.f3093a = new HashMap<>();
    }

    public final void a(HashMap<String, MC> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* renamed from: b */
    public final C0260lh clone() {
        C0426zh zhVar = new C0426zh();
        super.c(this);
        zhVar.f3485c = this.f3485c;
        zhVar.f3486d = this.f3486d;
        zhVar.m = this.m;
        zhVar.n = this.n;
        zhVar.l = this.l;
        zhVar.a = this.a;
        zhVar.b = this.b;
        zhVar.c = this.c;
        zhVar.f = this.f;
        zhVar.d = this.d;
        zhVar.e = this.e;
        zhVar.g = this.g;
        zhVar.h = this.h;
        zhVar.i = this.i;
        zhVar.j = this.j;
        zhVar.k = this.k;
        return zhVar;
    }

    public final void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.a)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.b)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.c)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.d)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.e)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.i)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.g)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.h)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("progress");
        }
        if (this.f3093a.size() > 0) {
            for (String str : this.f3093a.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.KeyTimeCycle);
        SparseIntArray sparseIntArray = a.a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            SparseIntArray sparseIntArray2 = a.a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.a = obtainStyledAttributes.getFloat(index, this.a);
                    break;
                case 2:
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                    break;
                case 4:
                    this.c = obtainStyledAttributes.getFloat(index, this.c);
                    break;
                case 5:
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                    break;
                case 6:
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                    break;
                case 7:
                    this.g = obtainStyledAttributes.getFloat(index, this.g);
                    break;
                case 8:
                    this.f = obtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 9:
                    obtainStyledAttributes.getString(index);
                    break;
                case 10:
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
                case 12:
                    this.a = obtainStyledAttributes.getInt(index, this.a);
                    break;
                case 13:
                    this.f3485c = obtainStyledAttributes.getInteger(index, this.f3485c);
                    break;
                case 14:
                    this.h = obtainStyledAttributes.getFloat(index, this.h);
                    break;
                case 15:
                    this.i = obtainStyledAttributes.getDimension(index, this.i);
                    break;
                case 16:
                    this.j = obtainStyledAttributes.getDimension(index, this.j);
                    break;
                case 17:
                    this.k = obtainStyledAttributes.getDimension(index, this.k);
                    break;
                case 18:
                    this.l = obtainStyledAttributes.getFloat(index, this.l);
                    break;
                case 19:
                    if (obtainStyledAttributes.peekValue(index).type != 3) {
                        this.f3486d = obtainStyledAttributes.getInt(index, this.f3486d);
                        break;
                    } else {
                        obtainStyledAttributes.getString(index);
                        this.f3486d = 7;
                        break;
                    }
                case 20:
                    this.m = obtainStyledAttributes.getFloat(index, this.m);
                    break;
                case 21:
                    if (obtainStyledAttributes.peekValue(index).type != 5) {
                        this.n = obtainStyledAttributes.getFloat(index, this.n);
                        break;
                    } else {
                        this.n = obtainStyledAttributes.getDimension(index, this.n);
                        break;
                    }
                default:
                    Integer.toHexString(index);
                    sparseIntArray2.get(index);
                    break;
            }
        }
    }

    public final void f(HashMap<String, Integer> hashMap) {
        if (this.f3485c != -1) {
            if (!Float.isNaN(this.a)) {
                hashMap.put("alpha", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.b)) {
                hashMap.put("elevation", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.c)) {
                hashMap.put("rotation", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.d)) {
                hashMap.put("rotationX", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.e)) {
                hashMap.put("rotationY", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.i)) {
                hashMap.put("translationX", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.j)) {
                hashMap.put("translationY", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.k)) {
                hashMap.put("translationZ", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.f)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.g)) {
                hashMap.put("scaleX", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.g)) {
                hashMap.put("scaleY", Integer.valueOf(this.f3485c));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("progress", Integer.valueOf(this.f3485c));
            }
            if (this.f3093a.size() > 0) {
                for (String i2 : this.f3093a.keySet()) {
                    hashMap.put(C0709Uj.i("CUSTOM,", i2), Integer.valueOf(this.f3485c));
                }
            }
        }
    }
}
