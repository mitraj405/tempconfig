package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;
import java.util.HashMap;

public class CircularFlow extends VirtualLayout {
    public static float a;
    public static int g;

    /* renamed from: a  reason: collision with other field name */
    public ConstraintLayout f1420a;

    /* renamed from: a  reason: collision with other field name */
    public Float f1421a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f1422a;

    /* renamed from: a  reason: collision with other field name */
    public float[] f1423a;
    public int[] b;
    public int d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public String f1424e;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public String f1425f;

    public CircularFlow(Context context) {
        super(context);
    }

    private void setAngles(String str) {
        if (str != null) {
            int i = 0;
            this.f = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    v(str.substring(i).trim());
                    return;
                } else {
                    v(str.substring(i, indexOf).trim());
                    i = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i = 0;
            this.e = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    w(str.substring(i).trim());
                    return;
                } else {
                    w(str.substring(i, indexOf).trim());
                    i = indexOf + 1;
                }
            }
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f1423a, this.f);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.b, this.e);
    }

    public final void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.d = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == C0221hs.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1424e = string;
                    setAngles(string);
                } else if (index == C0221hs.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1425f = string2;
                    setRadius(string2);
                } else if (index == C0221hs.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, a));
                    this.f1421a = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == C0221hs.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, g));
                    this.f1422a = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1424e;
        if (str != null) {
            this.f1423a = new float[1];
            setAngles(str);
        }
        String str2 = this.f1425f;
        if (str2 != null) {
            this.b = new int[1];
            setRadius(str2);
        }
        Float f2 = this.f1421a;
        if (f2 != null) {
            setDefaultAngle(f2.floatValue());
        }
        Integer num = this.f1422a;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        this.f1420a = (ConstraintLayout) getParent();
        for (int i = 0; i < this.c; i++) {
            View viewById = this.f1420a.getViewById(this.f1623a[i]);
            if (viewById != null) {
                int i2 = g;
                float f3 = a;
                int[] iArr = this.b;
                HashMap<Integer, String> hashMap = this.f1622a;
                if (iArr == null || i >= iArr.length) {
                    Integer num2 = this.f1422a;
                    if (num2 == null || num2.intValue() == -1) {
                        String str3 = hashMap.get(Integer.valueOf(viewById.getId()));
                    } else {
                        this.e++;
                        if (this.b == null) {
                            this.b = new int[1];
                        }
                        int[] radius = getRadius();
                        this.b = radius;
                        radius[this.e - 1] = i2;
                    }
                } else {
                    i2 = iArr[i];
                }
                float[] fArr = this.f1423a;
                if (fArr == null || i >= fArr.length) {
                    Float f4 = this.f1421a;
                    if (f4 == null || f4.floatValue() == -1.0f) {
                        String str4 = hashMap.get(Integer.valueOf(viewById.getId()));
                    } else {
                        this.f++;
                        if (this.f1423a == null) {
                            this.f1423a = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f1423a = angles;
                        angles[this.f - 1] = f3;
                    }
                } else {
                    f3 = fArr[i];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.b = f3;
                layoutParams.n = this.d;
                layoutParams.o = i2;
                viewById.setLayoutParams(layoutParams);
            }
        }
        h();
    }

    public void setDefaultAngle(float f2) {
        a = f2;
    }

    public void setDefaultRadius(int i) {
        g = i;
    }

    public final void v(String str) {
        float[] fArr;
        if (str != null && str.length() != 0 && this.f1621a != null && (fArr = this.f1423a) != null) {
            if (this.f + 1 > fArr.length) {
                this.f1423a = Arrays.copyOf(fArr, fArr.length + 1);
            }
            this.f1423a[this.f] = (float) Integer.parseInt(str);
            this.f++;
        }
    }

    public final void w(String str) {
        Context context;
        int[] iArr;
        if (str != null && str.length() != 0 && (context = this.f1621a) != null && (iArr = this.b) != null) {
            if (this.e + 1 > iArr.length) {
                this.b = Arrays.copyOf(iArr, iArr.length + 1);
            }
            this.b[this.e] = (int) (((float) Integer.parseInt(str)) * context.getResources().getDisplayMetrics().density);
            this.e++;
        }
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
