package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.google.firebase.perf.util.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: O6  reason: default package */
/* compiled from: ConstraintAttribute */
public final class O6 {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final int f463a;

    /* renamed from: a  reason: collision with other field name */
    public final String f464a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f465a = false;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public String f466b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f467b;
    public int c;

    public O6(String str, int i, Object obj, boolean z) {
        this.f464a = str;
        this.f463a = i;
        this.f465a = z;
        f(obj);
    }

    public static void d(Context context, XmlResourceParser xmlResourceParser, HashMap hashMap) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        int i = 0;
        boolean z = false;
        Object obj = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == C0221hs.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == C0221hs.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == C0221hs.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                i = 6;
            } else if (index == C0221hs.CustomAttribute_customColorValue) {
                obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                i = 3;
            } else if (index == C0221hs.CustomAttribute_customColorDrawableValue) {
                obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                i = 4;
            } else {
                if (index == C0221hs.CustomAttribute_customPixelDimension) {
                    obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == C0221hs.CustomAttribute_customDimension) {
                    obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == C0221hs.CustomAttribute_customFloatValue) {
                    obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                    i = 2;
                } else if (index == C0221hs.CustomAttribute_customIntegerValue) {
                    obj = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                    i = 1;
                } else if (index == C0221hs.CustomAttribute_customStringValue) {
                    obj = obtainStyledAttributes.getString(index);
                    i = 5;
                } else if (index == C0221hs.CustomAttribute_customReference) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    obj = Integer.valueOf(resourceId);
                    i = 8;
                }
                i = 7;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new O6(str, i, obj, z));
        }
        obtainStyledAttributes.recycle();
    }

    public static void e(View view, HashMap<String, O6> hashMap) {
        Class<?> cls = view.getClass();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            O6 o6 = hashMap.get(next);
            if (!o6.f465a) {
                next = C0709Uj.i("set", next);
            }
            try {
                switch (xx.V(o6.f463a)) {
                    case 0:
                        cls.getMethod(next, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(o6.b)});
                        break;
                    case 1:
                        cls.getMethod(next, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(o6.a)});
                        break;
                    case 2:
                        cls.getMethod(next, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(o6.c)});
                        break;
                    case 3:
                        Method method = cls.getMethod(next, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(o6.c);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 4:
                        cls.getMethod(next, new Class[]{CharSequence.class}).invoke(view, new Object[]{o6.f466b});
                        break;
                    case 5:
                        cls.getMethod(next, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(o6.f467b)});
                        break;
                    case 6:
                        cls.getMethod(next, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(o6.a)});
                        break;
                    case 7:
                        cls.getMethod(next, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(o6.b)});
                        break;
                }
            } catch (NoSuchMethodException e) {
                e.getMessage();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final float a() {
        switch (xx.V(this.f463a)) {
            case 0:
                return (float) this.b;
            case 1:
                return this.a;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                if (this.f467b) {
                    return 1.0f;
                }
                return 0.0f;
            case 6:
                return this.a;
            default:
                return Float.NaN;
        }
    }

    public final void b(float[] fArr) {
        float f;
        switch (xx.V(this.f463a)) {
            case 0:
                fArr[0] = (float) this.b;
                return;
            case 1:
                fArr[0] = this.a;
                return;
            case 2:
            case 3:
                int i = this.c;
                int i2 = (i >> 24) & Constants.MAX_HOST_LENGTH;
                int i3 = (i >> 16) & Constants.MAX_HOST_LENGTH;
                int i4 = (i >> 8) & Constants.MAX_HOST_LENGTH;
                int i5 = i & Constants.MAX_HOST_LENGTH;
                float pow = (float) Math.pow((double) (((float) i3) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) i4) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) i5) / 255.0f), 2.2d);
                fArr[3] = ((float) i2) / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                if (this.f467b) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                fArr[0] = f;
                return;
            case 6:
                fArr[0] = this.a;
                return;
            default:
                return;
        }
    }

    public final int c() {
        int V = xx.V(this.f463a);
        if (V == 2 || V == 3) {
            return 4;
        }
        return 1;
    }

    public final void f(Object obj) {
        switch (xx.V(this.f463a)) {
            case 0:
            case 7:
                this.b = ((Integer) obj).intValue();
                return;
            case 1:
                this.a = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.c = ((Integer) obj).intValue();
                return;
            case 4:
                this.f466b = (String) obj;
                return;
            case 5:
                this.f467b = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.a = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public O6(O6 o6, Object obj) {
        this.f464a = o6.f464a;
        this.f463a = o6.f463a;
        f(obj);
    }
}
