package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* renamed from: nh  reason: default package */
/* compiled from: KeyCache */
public final class nh implements R0 {
    public final Object a;

    public /* synthetic */ nh(Object obj) {
        this.a = obj;
    }

    public boolean a() {
        Object obj = this.a;
        if (((List) obj).size() != 1 || !((Bh) ((List) obj).get(0)).c()) {
            return false;
        }
        return true;
    }

    public C0335t2 b() {
        Object obj = this.a;
        if (((Bh) ((List) obj).get(0)).c()) {
            return new Hp((List) obj);
        }
        return new C0206gp((List) obj);
    }

    public List c() {
        return (List) this.a;
    }

    public byte[] d(String str) {
        return ((C1295o2) this.a).b(str);
    }

    public String e(byte[] bArr) {
        return ((C1295o2) this.a).d(bArr);
    }

    public float f(Object obj, String str) {
        HashMap hashMap;
        float[] fArr;
        HashMap hashMap2 = (HashMap) this.a;
        if (hashMap2.containsKey(obj) && (hashMap = (HashMap) hashMap2.get(obj)) != null && hashMap.containsKey(str) && (fArr = (float[]) hashMap.get(str)) != null && fArr.length > 0) {
            return fArr[0];
        }
        return Float.NaN;
    }

    public /* synthetic */ nh(int i) {
        Handler handler;
        Handler handler2;
        if (i == 1) {
            Looper mainLooper = Looper.getMainLooper();
            if (Build.VERSION.SDK_INT >= 28) {
                handler = Handler.createAsync(mainLooper);
            } else {
                Class<Handler> cls = Handler.class;
                try {
                    handler2 = cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{mainLooper, null, Boolean.TRUE});
                } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
                    handler2 = new Handler(mainLooper);
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    } else if (cause instanceof Error) {
                        throw ((Error) cause);
                    } else {
                        throw new RuntimeException(cause);
                    }
                }
                handler = handler2;
            }
            this.a = handler;
        } else if (i != 3) {
            this.a = new HashMap();
        } else {
            this.a = new C1295o2((byte[]) null, -1, true);
        }
    }
}
