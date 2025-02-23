package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: mh  reason: default package */
/* compiled from: KeyAttributes */
public final class mh extends C0260lh {
    public float a = Float.NaN;
    public float b = Float.NaN;
    public float c = Float.NaN;

    /* renamed from: c  reason: collision with other field name */
    public int f3102c = -1;
    public float d = Float.NaN;
    public float e = Float.NaN;
    public float f = Float.NaN;
    public float g = Float.NaN;
    public float h = Float.NaN;
    public float i = Float.NaN;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = Float.NaN;
    public float m = Float.NaN;
    public float n = Float.NaN;

    /* renamed from: mh$a */
    /* compiled from: KeyAttributes */
    public static class a {
        public static final SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.KeyAttribute_android_alpha, 1);
            sparseIntArray.append(C0221hs.KeyAttribute_android_elevation, 2);
            sparseIntArray.append(C0221hs.KeyAttribute_android_rotation, 4);
            sparseIntArray.append(C0221hs.KeyAttribute_android_rotationX, 5);
            sparseIntArray.append(C0221hs.KeyAttribute_android_rotationY, 6);
            sparseIntArray.append(C0221hs.KeyAttribute_android_transformPivotX, 19);
            sparseIntArray.append(C0221hs.KeyAttribute_android_transformPivotY, 20);
            sparseIntArray.append(C0221hs.KeyAttribute_android_scaleX, 7);
            sparseIntArray.append(C0221hs.KeyAttribute_transitionPathRotate, 8);
            sparseIntArray.append(C0221hs.KeyAttribute_transitionEasing, 9);
            sparseIntArray.append(C0221hs.KeyAttribute_motionTarget, 10);
            sparseIntArray.append(C0221hs.KeyAttribute_framePosition, 12);
            sparseIntArray.append(C0221hs.KeyAttribute_curveFit, 13);
            sparseIntArray.append(C0221hs.KeyAttribute_android_scaleY, 14);
            sparseIntArray.append(C0221hs.KeyAttribute_android_translationX, 15);
            sparseIntArray.append(C0221hs.KeyAttribute_android_translationY, 16);
            sparseIntArray.append(C0221hs.KeyAttribute_android_translationZ, 17);
            sparseIntArray.append(C0221hs.KeyAttribute_motionProgress, 18);
        }
    }

    public mh() {
        this.f3093a = new HashMap<>();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (r1.equals("scaleY") == false) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.HashMap<java.lang.String, defpackage.MC> r7) {
        /*
            r6 = this;
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01e2
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.get(r1)
            Ex r2 = (defpackage.Ex) r2
            if (r2 != 0) goto L_0x001d
            goto L_0x0008
        L_0x001d:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            r4 = 7
            if (r3 == 0) goto L_0x003e
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap<java.lang.String, O6> r3 = r6.f3093a
            java.lang.Object r1 = r3.get(r1)
            O6 r1 = (defpackage.O6) r1
            if (r1 == 0) goto L_0x0008
            MC$b r2 = (defpackage.MC.b) r2
            int r3 = r6.a
            android.util.SparseArray<O6> r2 = r2.a
            r2.append(r3, r1)
            goto L_0x0008
        L_0x003e:
            int r3 = r1.hashCode()
            r5 = -1
            switch(r3) {
                case -1249320806: goto L_0x00e4;
                case -1249320805: goto L_0x00d8;
                case -1225497657: goto L_0x00cc;
                case -1225497656: goto L_0x00c0;
                case -1225497655: goto L_0x00b5;
                case -1001078227: goto L_0x00aa;
                case -908189618: goto L_0x009f;
                case -908189617: goto L_0x0096;
                case -760884510: goto L_0x008a;
                case -760884509: goto L_0x007d;
                case -40300674: goto L_0x0070;
                case -4379043: goto L_0x0063;
                case 37232917: goto L_0x0056;
                case 92909918: goto L_0x0049;
                default: goto L_0x0046;
            }
        L_0x0046:
            r4 = r5
            goto L_0x00ef
        L_0x0049:
            java.lang.String r3 = "alpha"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0052
            goto L_0x0046
        L_0x0052:
            r4 = 13
            goto L_0x00ef
        L_0x0056:
            java.lang.String r3 = "transitionPathRotate"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x005f
            goto L_0x0046
        L_0x005f:
            r4 = 12
            goto L_0x00ef
        L_0x0063:
            java.lang.String r3 = "elevation"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x006c
            goto L_0x0046
        L_0x006c:
            r4 = 11
            goto L_0x00ef
        L_0x0070:
            java.lang.String r3 = "rotation"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0079
            goto L_0x0046
        L_0x0079:
            r4 = 10
            goto L_0x00ef
        L_0x007d:
            java.lang.String r3 = "transformPivotY"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0086
            goto L_0x0046
        L_0x0086:
            r4 = 9
            goto L_0x00ef
        L_0x008a:
            java.lang.String r3 = "transformPivotX"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0093
            goto L_0x0046
        L_0x0093:
            r4 = 8
            goto L_0x00ef
        L_0x0096:
            java.lang.String r3 = "scaleY"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00ef
            goto L_0x0046
        L_0x009f:
            java.lang.String r3 = "scaleX"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00a8
            goto L_0x0046
        L_0x00a8:
            r4 = 6
            goto L_0x00ef
        L_0x00aa:
            java.lang.String r3 = "progress"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00b3
            goto L_0x0046
        L_0x00b3:
            r4 = 5
            goto L_0x00ef
        L_0x00b5:
            java.lang.String r3 = "translationZ"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00be
            goto L_0x0046
        L_0x00be:
            r4 = 4
            goto L_0x00ef
        L_0x00c0:
            java.lang.String r3 = "translationY"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00ca
            goto L_0x0046
        L_0x00ca:
            r4 = 3
            goto L_0x00ef
        L_0x00cc:
            java.lang.String r3 = "translationX"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00d6
            goto L_0x0046
        L_0x00d6:
            r4 = 2
            goto L_0x00ef
        L_0x00d8:
            java.lang.String r3 = "rotationY"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00e2
            goto L_0x0046
        L_0x00e2:
            r4 = 1
            goto L_0x00ef
        L_0x00e4:
            java.lang.String r3 = "rotationX"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00ee
            goto L_0x0046
        L_0x00ee:
            r4 = 0
        L_0x00ef:
            switch(r4) {
                case 0: goto L_0x01d1;
                case 1: goto L_0x01c0;
                case 2: goto L_0x01af;
                case 3: goto L_0x019e;
                case 4: goto L_0x018d;
                case 5: goto L_0x017c;
                case 6: goto L_0x016b;
                case 7: goto L_0x015a;
                case 8: goto L_0x0149;
                case 9: goto L_0x0138;
                case 10: goto L_0x0127;
                case 11: goto L_0x0116;
                case 12: goto L_0x0105;
                case 13: goto L_0x00f4;
                default: goto L_0x00f2;
            }
        L_0x00f2:
            goto L_0x0008
        L_0x00f4:
            float r1 = r6.a
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.a
            r2.b(r3, r1)
            goto L_0x0008
        L_0x0105:
            float r1 = r6.h
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.h
            r2.b(r3, r1)
            goto L_0x0008
        L_0x0116:
            float r1 = r6.b
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.b
            r2.b(r3, r1)
            goto L_0x0008
        L_0x0127:
            float r1 = r6.c
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.c
            r2.b(r3, r1)
            goto L_0x0008
        L_0x0138:
            float r1 = r6.e
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.g
            r2.b(r3, r1)
            goto L_0x0008
        L_0x0149:
            float r1 = r6.d
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.f
            r2.b(r3, r1)
            goto L_0x0008
        L_0x015a:
            float r1 = r6.j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.j
            r2.b(r3, r1)
            goto L_0x0008
        L_0x016b:
            float r1 = r6.i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.i
            r2.b(r3, r1)
            goto L_0x0008
        L_0x017c:
            float r1 = r6.n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.n
            r2.b(r3, r1)
            goto L_0x0008
        L_0x018d:
            float r1 = r6.m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.m
            r2.b(r3, r1)
            goto L_0x0008
        L_0x019e:
            float r1 = r6.l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.l
            r2.b(r3, r1)
            goto L_0x0008
        L_0x01af:
            float r1 = r6.k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.k
            r2.b(r3, r1)
            goto L_0x0008
        L_0x01c0:
            float r1 = r6.e
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.e
            r2.b(r3, r1)
            goto L_0x0008
        L_0x01d1:
            float r1 = r6.d
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.a
            float r3 = r6.d
            r2.b(r3, r1)
            goto L_0x0008
        L_0x01e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh.a(java.util.HashMap):void");
    }

    /* renamed from: b */
    public final C0260lh clone() {
        mh mhVar = new mh();
        super.c(this);
        mhVar.f3102c = this.f3102c;
        mhVar.a = this.a;
        mhVar.b = this.b;
        mhVar.c = this.c;
        mhVar.d = this.d;
        mhVar.e = this.e;
        mhVar.f = this.f;
        mhVar.g = this.g;
        mhVar.h = this.h;
        mhVar.i = this.i;
        mhVar.j = this.j;
        mhVar.k = this.k;
        mhVar.l = this.l;
        mhVar.m = this.m;
        mhVar.n = this.n;
        return mhVar;
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
        if (!Float.isNaN(this.f)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.g)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.h)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.i)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("progress");
        }
        if (this.f3093a.size() > 0) {
            for (String str : this.f3093a.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.KeyAttribute);
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
                    this.i = obtainStyledAttributes.getFloat(index, this.i);
                    break;
                case 8:
                    this.h = obtainStyledAttributes.getFloat(index, this.h);
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
                    this.f3102c = obtainStyledAttributes.getInteger(index, this.f3102c);
                    break;
                case 14:
                    this.j = obtainStyledAttributes.getFloat(index, this.j);
                    break;
                case 15:
                    this.k = obtainStyledAttributes.getDimension(index, this.k);
                    break;
                case 16:
                    this.l = obtainStyledAttributes.getDimension(index, this.l);
                    break;
                case 17:
                    this.m = obtainStyledAttributes.getDimension(index, this.m);
                    break;
                case 18:
                    this.n = obtainStyledAttributes.getFloat(index, this.n);
                    break;
                case 19:
                    this.f = obtainStyledAttributes.getDimension(index, this.f);
                    break;
                case 20:
                    this.g = obtainStyledAttributes.getDimension(index, this.g);
                    break;
                default:
                    Integer.toHexString(index);
                    sparseIntArray2.get(index);
                    break;
            }
        }
    }

    public final void f(HashMap<String, Integer> hashMap) {
        if (this.f3102c != -1) {
            if (!Float.isNaN(this.a)) {
                hashMap.put("alpha", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.b)) {
                hashMap.put("elevation", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.c)) {
                hashMap.put("rotation", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.d)) {
                hashMap.put("rotationX", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.e)) {
                hashMap.put("rotationY", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.f)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.g)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.k)) {
                hashMap.put("translationX", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.l)) {
                hashMap.put("translationY", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.m)) {
                hashMap.put("translationZ", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.h)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.i)) {
                hashMap.put("scaleX", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.j)) {
                hashMap.put("scaleY", Integer.valueOf(this.f3102c));
            }
            if (!Float.isNaN(this.n)) {
                hashMap.put("progress", Integer.valueOf(this.f3102c));
            }
            if (this.f3093a.size() > 0) {
                for (String i2 : this.f3093a.keySet()) {
                    hashMap.put(C0709Uj.i("CUSTOM,", i2), Integer.valueOf(this.f3102c));
                }
            }
        }
    }

    public final void h(Object obj, String str) {
        int i2;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 8;
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c2 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c2 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 14;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.n = C0260lh.g((Number) obj);
                return;
            case 1:
                obj.toString();
                return;
            case 2:
                this.d = C0260lh.g((Number) obj);
                return;
            case 3:
                this.e = C0260lh.g((Number) obj);
                return;
            case 4:
                this.k = C0260lh.g((Number) obj);
                return;
            case 5:
                this.l = C0260lh.g((Number) obj);
                return;
            case 6:
                this.m = C0260lh.g((Number) obj);
                return;
            case 7:
                this.i = C0260lh.g((Number) obj);
                return;
            case 8:
                this.j = C0260lh.g((Number) obj);
                return;
            case 9:
                this.f = C0260lh.g((Number) obj);
                return;
            case 10:
                this.g = C0260lh.g((Number) obj);
                return;
            case 11:
                this.c = C0260lh.g((Number) obj);
                return;
            case 12:
                this.b = C0260lh.g((Number) obj);
                return;
            case 13:
                this.h = C0260lh.g((Number) obj);
                return;
            case 14:
                this.a = C0260lh.g((Number) obj);
                return;
            case 15:
                Number number = (Number) obj;
                if (number instanceof Integer) {
                    i2 = ((Integer) number).intValue();
                } else {
                    i2 = Integer.parseInt(number.toString());
                }
                this.f3102c = i2;
                return;
            case 16:
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                    return;
                } else {
                    Boolean.parseBoolean(obj.toString());
                    return;
                }
            default:
                return;
        }
    }
}
