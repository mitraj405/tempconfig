package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* renamed from: xh  reason: default package and case insensitive filesystem */
/* compiled from: KeyPosition */
public final class C0395xh extends C0410yh {
    public float a = Float.NaN;
    public float b = Float.NaN;

    /* renamed from: b  reason: collision with other field name */
    public String f3411b = null;
    public float c = Float.NaN;
    public float d = Float.NaN;

    /* renamed from: d  reason: collision with other field name */
    public int f3412d = -1;
    public float e = Float.NaN;

    /* renamed from: e  reason: collision with other field name */
    public int f3413e = 0;
    public float f = Float.NaN;

    /* renamed from: f  reason: collision with other field name */
    public int f3414f = 0;

    /* renamed from: xh$a */
    /* compiled from: KeyPosition */
    public static class a {
        public static final SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(C0221hs.KeyPosition_motionTarget, 1);
            sparseIntArray.append(C0221hs.KeyPosition_framePosition, 2);
            sparseIntArray.append(C0221hs.KeyPosition_transitionEasing, 3);
            sparseIntArray.append(C0221hs.KeyPosition_curveFit, 4);
            sparseIntArray.append(C0221hs.KeyPosition_drawPath, 5);
            sparseIntArray.append(C0221hs.KeyPosition_percentX, 6);
            sparseIntArray.append(C0221hs.KeyPosition_percentY, 7);
            sparseIntArray.append(C0221hs.KeyPosition_keyPositionType, 9);
            sparseIntArray.append(C0221hs.KeyPosition_sizePercent, 8);
            sparseIntArray.append(C0221hs.KeyPosition_percentWidth, 11);
            sparseIntArray.append(C0221hs.KeyPosition_percentHeight, 12);
            sparseIntArray.append(C0221hs.KeyPosition_pathMotionArc, 10);
        }
    }

    public final C0260lh b() {
        C0395xh xhVar = new C0395xh();
        super.c(this);
        xhVar.f3411b = this.f3411b;
        xhVar.f3412d = this.f3412d;
        xhVar.f3413e = this.f3413e;
        xhVar.a = this.a;
        xhVar.b = Float.NaN;
        xhVar.c = this.c;
        xhVar.d = this.d;
        xhVar.e = this.e;
        xhVar.f = this.f;
        return xhVar;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.KeyPosition);
        SparseIntArray sparseIntArray = a.a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
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
                    if (obtainStyledAttributes.peekValue(index).type != 3) {
                        this.f3411b = T9.f544a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    } else {
                        this.f3411b = obtainStyledAttributes.getString(index);
                        break;
                    }
                case 4:
                    this.c = obtainStyledAttributes.getInteger(index, this.c);
                    break;
                case 5:
                    this.f3413e = obtainStyledAttributes.getInt(index, this.f3413e);
                    break;
                case 6:
                    this.c = obtainStyledAttributes.getFloat(index, this.c);
                    break;
                case 7:
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                    break;
                case 8:
                    float f2 = obtainStyledAttributes.getFloat(index, this.b);
                    this.a = f2;
                    this.b = f2;
                    break;
                case 9:
                    this.f3414f = obtainStyledAttributes.getInt(index, this.f3414f);
                    break;
                case 10:
                    this.f3412d = obtainStyledAttributes.getInt(index, this.f3412d);
                    break;
                case 11:
                    this.a = obtainStyledAttributes.getFloat(index, this.a);
                    break;
                case 12:
                    this.b = obtainStyledAttributes.getFloat(index, this.b);
                    break;
                default:
                    Integer.toHexString(index);
                    sparseIntArray2.get(index);
                    break;
            }
        }
    }

    public final void h(Object obj, String str) {
        int i;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c2 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c2 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c2 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c2 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.f3411b = obj.toString();
                return;
            case 1:
                this.a = C0260lh.g((Number) obj);
                return;
            case 2:
                this.b = C0260lh.g((Number) obj);
                return;
            case 3:
                Number number = (Number) obj;
                if (number instanceof Integer) {
                    i = ((Integer) number).intValue();
                } else {
                    i = Integer.parseInt(number.toString());
                }
                this.f3413e = i;
                return;
            case 4:
                float g = C0260lh.g((Number) obj);
                this.a = g;
                this.b = g;
                return;
            case 5:
                this.c = C0260lh.g((Number) obj);
                return;
            case 6:
                this.d = C0260lh.g((Number) obj);
                return;
            default:
                return;
        }
    }

    public final void a(HashMap<String, MC> hashMap) {
    }
}
