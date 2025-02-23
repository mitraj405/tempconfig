package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.firebase.sessions.settings.RemoteSettings;
import defpackage.UB;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: nj  reason: default package and case insensitive filesystem */
/* compiled from: LottieCompositionFactory */
public final class C0281nj {
    public static final HashMap a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f3112a = {80, 75, 3, 4};

    public static Mj<C0181ej> a(String str, Callable<Lj<C0181ej>> callable) {
        C0181ej ejVar;
        Throwable th;
        if (str == null) {
            ejVar = null;
        } else {
            ejVar = C0196fj.a.f2940a.get(str);
        }
        if (ejVar != null) {
            return new Mj<>(new C0228ij(ejVar, 0), false);
        }
        HashMap hashMap = a;
        if (str != null && hashMap.containsKey(str)) {
            return (Mj) hashMap.get(str);
        }
        Mj<C0181ej> mj = new Mj<>(callable, false);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            mj.a(new C0239jj(str, atomicBoolean));
            C0249kj kjVar = new C0249kj(str, atomicBoolean);
            synchronized (mj) {
                Lj<T> lj = mj.f407a;
                if (!(lj == null || (th = lj.f387a) == null)) {
                    kjVar.onResult(th);
                }
                mj.b.add(kjVar);
            }
            if (!atomicBoolean.get()) {
                hashMap.put(str, mj);
            }
        }
        return mj;
    }

    public static Lj<C0181ej> b(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip")) {
                if (!str.endsWith(".lottie")) {
                    return c(context.getAssets().open(str), str2);
                }
            }
            return f(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new Lj<>((Throwable) e);
        }
    }

    public static Lj<C0181ej> c(InputStream inputStream, String str) {
        try {
            As as = new As(C1517zn.b(inputStream));
            String[] strArr = Tg.b;
            return d(new Ug(as), str, true);
        } finally {
            UB.b(inputStream);
        }
    }

    public static Lj d(Ug ug, String str, boolean z) {
        try {
            C0181ej a2 = oj.a(ug);
            if (str != null) {
                C0196fj.a.f2940a.put(str, a2);
            }
            Lj lj = new Lj(a2);
            if (z) {
                UB.b(ug);
            }
            return lj;
        } catch (Exception e) {
            Lj lj2 = new Lj((Throwable) e);
            if (z) {
                UB.b(ug);
            }
            return lj2;
        } catch (Throwable th) {
            if (z) {
                UB.b(ug);
            }
            throw th;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.Lj<defpackage.C0181ej> e(android.content.Context r5, int r6, java.lang.String r7) {
        /*
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x0058 }
            java.io.InputStream r5 = r5.openRawResource(r6)     // Catch:{ NotFoundException -> 0x0058 }
            wn r5 = defpackage.C1517zn.b(r5)     // Catch:{ NotFoundException -> 0x0058 }
            As r6 = new As     // Catch:{ NotFoundException -> 0x0058 }
            r6.<init>(r5)     // Catch:{ NotFoundException -> 0x0058 }
            As r5 = r6.B()     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            byte[] r0 = f3112a     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            int r1 = r0.length     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            r2 = 0
        L_0x0019:
            if (r2 >= r1) goto L_0x0029
            byte r3 = r0[r2]     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            byte r4 = r5.readByte()     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            if (r4 == r3) goto L_0x0026
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            goto L_0x0039
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x0019
        L_0x0029:
            r5.close()     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ NoSuchMethodError -> 0x0037, Exception -> 0x002f }
            goto L_0x0039
        L_0x002f:
            yi r5 = defpackage.Ai.a     // Catch:{ NotFoundException -> 0x0058 }
            r5.getClass()     // Catch:{ NotFoundException -> 0x0058 }
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ NotFoundException -> 0x0058 }
            goto L_0x0039
        L_0x0037:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ NotFoundException -> 0x0058 }
        L_0x0039:
            boolean r5 = r5.booleanValue()     // Catch:{ NotFoundException -> 0x0058 }
            if (r5 == 0) goto L_0x004e
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch:{ NotFoundException -> 0x0058 }
            As$a r0 = new As$a     // Catch:{ NotFoundException -> 0x0058 }
            r0.<init>()     // Catch:{ NotFoundException -> 0x0058 }
            r5.<init>(r0)     // Catch:{ NotFoundException -> 0x0058 }
            Lj r5 = f(r5, r7)     // Catch:{ NotFoundException -> 0x0058 }
            return r5
        L_0x004e:
            As$a r5 = new As$a     // Catch:{ NotFoundException -> 0x0058 }
            r5.<init>()     // Catch:{ NotFoundException -> 0x0058 }
            Lj r5 = c(r5, r7)     // Catch:{ NotFoundException -> 0x0058 }
            return r5
        L_0x0058:
            r5 = move-exception
            Lj r6 = new Lj
            r6.<init>((java.lang.Throwable) r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0281nj.e(android.content.Context, int, java.lang.String):Lj");
    }

    public static Lj<C0181ej> f(ZipInputStream zipInputStream, String str) {
        try {
            return g(zipInputStream, str);
        } finally {
            UB.b(zipInputStream);
        }
    }

    public static Lj<C0181ej> g(ZipInputStream zipInputStream, String str) {
        Gj gj;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            C0181ej ejVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    As as = new As(C1517zn.b(zipInputStream));
                    String[] strArr = Tg.b;
                    ejVar = (C0181ej) d(new Ug(as), (String) null, false).a;
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg")) {
                        if (!name.contains(".jpeg")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (ejVar == null) {
                return new Lj<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<Gj> it = ejVar.f2908b.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        gj = null;
                        break;
                    }
                    gj = it.next();
                    if (gj.f234a.equals(str2)) {
                        break;
                    }
                }
                if (gj != null) {
                    Bitmap bitmap = (Bitmap) entry.getValue();
                    UB.a aVar = UB.f567a;
                    int width = bitmap.getWidth();
                    int i = gj.a;
                    int i2 = gj.b;
                    if (!(width == i && bitmap.getHeight() == i2)) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                    gj.f233a = bitmap;
                }
            }
            for (Map.Entry next : ejVar.f2908b.entrySet()) {
                if (((Gj) next.getValue()).f233a == null) {
                    return new Lj<>((Throwable) new IllegalStateException("There is no image for " + ((Gj) next.getValue()).f234a));
                }
            }
            if (str != null) {
                C0196fj.a.f2940a.put(str, ejVar);
            }
            return new Lj<>(ejVar);
        } catch (IOException e) {
            return new Lj<>((Throwable) e);
        }
    }

    public static String h(Context context, int i) {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder("rawRes");
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }
}
