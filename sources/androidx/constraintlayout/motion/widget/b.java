package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: TouchResponse */
public final class b {
    public static final float[][] a = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] b = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: a  reason: collision with other field name */
    public float f1524a = 0.5f;

    /* renamed from: a  reason: collision with other field name */
    public int f1525a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final MotionLayout f1526a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1527a = false;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f1528a = new float[2];

    /* renamed from: a  reason: collision with other field name */
    public final int[] f1529a = new int[2];

    /* renamed from: b  reason: collision with other field name */
    public float f1530b = 0.5f;

    /* renamed from: b  reason: collision with other field name */
    public int f1531b = 0;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1532b = false;
    public float c = 0.0f;

    /* renamed from: c  reason: collision with other field name */
    public int f1533c = 0;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1534c = true;
    public float d = 1.0f;

    /* renamed from: d  reason: collision with other field name */
    public int f1535d = -1;
    public float e;

    /* renamed from: e  reason: collision with other field name */
    public int f1536e = -1;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public int f1537f = -1;
    public float g = 4.0f;

    /* renamed from: g  reason: collision with other field name */
    public int f1538g = -1;
    public float h = 1.2f;

    /* renamed from: h  reason: collision with other field name */
    public int f1539h = 0;
    public float i = 1.0f;

    /* renamed from: i  reason: collision with other field name */
    public int f1540i = 0;
    public float j = 10.0f;

    /* renamed from: j  reason: collision with other field name */
    public int f1541j = 0;
    public float k = 10.0f;
    public float l = 1.0f;
    public float m = Float.NaN;
    public float n = Float.NaN;

    public b(Context context, MotionLayout motionLayout, XmlResourceParser xmlResourceParser) {
        this.f1526a = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.OnSwipe);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == C0221hs.OnSwipe_touchAnchorId) {
                this.f1535d = obtainStyledAttributes.getResourceId(index, this.f1535d);
            } else if (index == C0221hs.OnSwipe_touchAnchorSide) {
                int i3 = obtainStyledAttributes.getInt(index, this.f1525a);
                this.f1525a = i3;
                float[] fArr = a[i3];
                this.f1530b = fArr[0];
                this.f1524a = fArr[1];
            } else if (index == C0221hs.OnSwipe_dragDirection) {
                int i4 = obtainStyledAttributes.getInt(index, this.f1531b);
                this.f1531b = i4;
                if (i4 < 6) {
                    float[] fArr2 = b[i4];
                    this.c = fArr2[0];
                    this.d = fArr2[1];
                } else {
                    this.d = Float.NaN;
                    this.c = Float.NaN;
                    this.f1527a = true;
                }
            } else if (index == C0221hs.OnSwipe_maxVelocity) {
                this.g = obtainStyledAttributes.getFloat(index, this.g);
            } else if (index == C0221hs.OnSwipe_maxAcceleration) {
                this.h = obtainStyledAttributes.getFloat(index, this.h);
            } else if (index == C0221hs.OnSwipe_moveWhenScrollAtTop) {
                this.f1534c = obtainStyledAttributes.getBoolean(index, this.f1534c);
            } else if (index == C0221hs.OnSwipe_dragScale) {
                this.i = obtainStyledAttributes.getFloat(index, this.i);
            } else if (index == C0221hs.OnSwipe_dragThreshold) {
                this.j = obtainStyledAttributes.getFloat(index, this.j);
            } else if (index == C0221hs.OnSwipe_touchRegionId) {
                this.f1536e = obtainStyledAttributes.getResourceId(index, this.f1536e);
            } else if (index == C0221hs.OnSwipe_onTouchUp) {
                this.f1533c = obtainStyledAttributes.getInt(index, this.f1533c);
            } else if (index == C0221hs.OnSwipe_nestedScrollFlags) {
                this.f1539h = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == C0221hs.OnSwipe_limitBoundsTo) {
                this.f1537f = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == C0221hs.OnSwipe_rotationCenterId) {
                this.f1538g = obtainStyledAttributes.getResourceId(index, this.f1538g);
            } else if (index == C0221hs.OnSwipe_springDamping) {
                this.k = obtainStyledAttributes.getFloat(index, this.k);
            } else if (index == C0221hs.OnSwipe_springMass) {
                this.l = obtainStyledAttributes.getFloat(index, this.l);
            } else if (index == C0221hs.OnSwipe_springStiffness) {
                this.m = obtainStyledAttributes.getFloat(index, this.m);
            } else if (index == C0221hs.OnSwipe_springStopThreshold) {
                this.n = obtainStyledAttributes.getFloat(index, this.n);
            } else if (index == C0221hs.OnSwipe_springBoundary) {
                this.f1540i = obtainStyledAttributes.getInt(index, this.f1540i);
            } else if (index == C0221hs.OnSwipe_autoCompleteMode) {
                this.f1541j = obtainStyledAttributes.getInt(index, this.f1541j);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final RectF a(MotionLayout motionLayout, RectF rectF) {
        View findViewById;
        int i2 = this.f1537f;
        if (i2 == -1 || (findViewById = motionLayout.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public final RectF b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f1536e;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public final void c(boolean z) {
        float[][] fArr = a;
        float[][] fArr2 = b;
        if (z) {
            fArr2[4] = fArr2[3];
            fArr2[5] = fArr2[2];
            fArr[5] = fArr[2];
            fArr[6] = fArr[1];
        } else {
            fArr2[4] = fArr2[2];
            fArr2[5] = fArr2[3];
            fArr[5] = fArr[1];
            fArr[6] = fArr[2];
        }
        float[] fArr3 = fArr[this.f1525a];
        this.f1530b = fArr3[0];
        this.f1524a = fArr3[1];
        int i2 = this.f1531b;
        if (i2 < 6) {
            float[] fArr4 = fArr2[i2];
            this.c = fArr4[0];
            this.d = fArr4[1];
        }
    }

    public final String toString() {
        if (Float.isNaN(this.c)) {
            return "rotation";
        }
        return this.c + " , " + this.d;
    }
}
