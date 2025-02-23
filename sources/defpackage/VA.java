package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import defpackage.C0180ed;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: VA  reason: default package */
/* compiled from: TypefaceCompatApi26Impl */
public class VA extends UA {
    public final Class<?> b;

    /* renamed from: b  reason: collision with other field name */
    public final Constructor<?> f588b;
    public final Method c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Method g;

    public VA() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method4 = k(cls);
            method3 = l(cls);
            method2 = cls.getMethod("freeze", new Class[0]);
            method5 = cls.getMethod("abortCreation", new Class[0]);
            method = m(cls);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.b = cls;
        this.f588b = constructor;
        this.c = method4;
        this.d = method3;
        this.e = method2;
        this.f = method5;
        this.g = method;
    }

    public static Method k(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    public static Method l(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    public final Typeface a(Context context, C0180ed.c cVar, Resources resources, int i) {
        boolean z;
        Object obj;
        if (this.c != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return super.a(context, cVar, resources, i);
        }
        try {
            obj = this.f588b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        for (C0180ed.d dVar : cVar.a) {
            if (!h(context, obj, dVar.f2883a, dVar.b, dVar.a, dVar.f2884a ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.f2885b))) {
                try {
                    this.f.invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
                return null;
            }
        }
        if (!j(obj)) {
            return null;
        }
        return i(obj);
    }

    public final Typeface b(Context context, C0204gd[] gdVarArr, int i) {
        boolean z;
        Object obj;
        Typeface i2;
        boolean z2;
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        C0204gd[] gdVarArr2 = gdVarArr;
        int i3 = i;
        if (gdVarArr2.length < 1) {
            return null;
        }
        if (this.c != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            C0204gd e2 = e(i3, gdVarArr2);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(e2.f2968a, "r", (CancellationSignal) null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(e2.b).setItalic(e2.f2969a).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            HashMap hashMap = new HashMap();
            for (C0204gd gdVar : gdVarArr2) {
                if (gdVar.c == 0) {
                    Uri uri = gdVar.f2968a;
                    if (!hashMap.containsKey(uri)) {
                        hashMap.put(uri, C0116aB.e(context, uri));
                    }
                }
                Context context2 = context;
            }
            Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
            try {
                obj = this.f588b.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused2) {
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            int length = gdVarArr2.length;
            int i4 = 0;
            boolean z3 = false;
            while (true) {
                Method method = this.f;
                if (i4 < length) {
                    C0204gd gdVar2 = gdVarArr2[i4];
                    ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(gdVar2.f2968a);
                    if (byteBuffer != null) {
                        try {
                            z2 = ((Boolean) this.d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(gdVar2.a), null, Integer.valueOf(gdVar2.b), Integer.valueOf(gdVar2.f2969a ? 1 : 0)})).booleanValue();
                        } catch (IllegalAccessException | InvocationTargetException unused3) {
                            z2 = false;
                        }
                        if (!z2) {
                            try {
                                method.invoke(obj, new Object[0]);
                                return null;
                            } catch (IllegalAccessException | InvocationTargetException unused4) {
                                return null;
                            }
                        } else {
                            z3 = true;
                        }
                    }
                    i4++;
                } else if (!z3) {
                    try {
                        method.invoke(obj, new Object[0]);
                        return null;
                    } catch (IllegalAccessException | InvocationTargetException unused5) {
                        return null;
                    }
                } else if (j(obj) && (i2 = i(obj)) != null) {
                    return Typeface.create(i2, i3);
                } else {
                    return null;
                }
            }
        }
        throw th;
    }

    public final Typeface c(Context context, Resources resources, int i, String str, int i2) {
        boolean z;
        Object obj;
        if (this.c != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return super.c(context, resources, i, str, i2);
        }
        try {
            obj = this.f588b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        if (!h(context, obj, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            try {
                this.f.invoke(obj, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
            return null;
        } else if (!j(obj)) {
            return null;
        } else {
            return i(obj);
        }
    }

    public final boolean h(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.g.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean j(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method m(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
