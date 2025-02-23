package defpackage;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.support.v4.media.MediaBrowserCompat;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import com.paytm.pgsdk.sdknative.LoginActivity;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.prs.ima.R;
import defpackage.C0698Tt;
import defpackage.Y0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.crypto.Mac;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.c;
import kotlinx.coroutines.d;

@SuppressLint({"RestrictedAPI"})
/* renamed from: r1  reason: default package */
/* compiled from: AppCompatResources */
public class r1 implements XB, C0680Sb, D, C0505Fd {
    public static final r1 a = new r1();

    /* renamed from: a  reason: collision with other field name */
    public static final C0422zD f3208a = new C0422zD("NO_DECISION", 2);

    /* renamed from: a  reason: collision with other field name */
    public static final float[] f3209a = {95.047f, 100.0f, 108.883f};

    /* renamed from: a  reason: collision with other field name */
    public static final Class[] f3210a;

    /* renamed from: a  reason: collision with other field name */
    public static final float[][] f3211a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static r1 b;

    /* renamed from: b  reason: collision with other field name */
    public static final C0422zD f3212b = new C0422zD("RESUME_TOKEN", 2);

    /* renamed from: b  reason: collision with other field name */
    public static final Class[] f3213b;

    /* renamed from: b  reason: collision with other field name */
    public static final float[][] f3214b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final r1 c = new r1();

    /* renamed from: c  reason: collision with other field name */
    public static final C0422zD f3215c = new C0422zD("CLOSED", 2);

    /* renamed from: c  reason: collision with other field name */
    public static final float[][] f3216c = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final C0422zD d = new C0422zD("UNDEFINED", 2);
    public static final C0422zD e = new C0422zD("REUSABLE_CLAIMED", 2);
    public static final C0422zD f = new C0422zD("REMOVED_TASK", 2);
    public static final C0422zD g = new C0422zD("CLOSED_EMPTY", 2);
    public static final C0422zD h = new C0422zD("NULL", 2);
    public static final C0422zD i = new C0422zD("STATE_REG", 2);
    public static final C0422zD j = new C0422zD("STATE_COMPLETED", 2);
    public static final C0422zD k = new C0422zD("STATE_CANCELLED", 2);
    public static final C0422zD l = new C0422zD("NONE", 2);
    public static final C0422zD m = new C0422zD("PENDING", 2);

    static {
        Class<Context> cls = Context.class;
        f3210a = new Class[]{cls};
        f3213b = new Class[]{cls, AttributeSet.class};
    }

    public static int A(float f2) {
        boolean z;
        float f3;
        boolean z2;
        float f4;
        if (f2 < 1.0f) {
            return -16777216;
        }
        if (f2 > 99.0f) {
            return -1;
        }
        float f5 = (f2 + 16.0f) / 116.0f;
        if (f2 > 8.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f3 = f5 * f5 * f5;
        } else {
            f3 = f2 / 903.2963f;
        }
        float f6 = f5 * f5 * f5;
        if (f6 > 0.008856452f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            f4 = f6;
        } else {
            f4 = ((f5 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z2) {
            f6 = ((f5 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f3209a;
        return A5.a((double) (f4 * fArr[0]), (double) (f3 * fArr[1]), (double) (f6 * fArr[2]));
    }

    public static final Continuation B(Continuation continuation) {
        C1148h7 h7Var;
        Continuation<Object> intercepted;
        C1177ig.f(continuation, "<this>");
        if (continuation instanceof C1148h7) {
            h7Var = (C1148h7) continuation;
        } else {
            h7Var = null;
        }
        if (h7Var == null || (intercepted = h7Var.intercepted()) == null) {
            return continuation;
        }
        return intercepted;
    }

    public static boolean C(String str) {
        Y0.d dVar = C0376wD.a;
        Set<C0401y6> unmodifiableSet = Collections.unmodifiableSet(Y0.a);
        HashSet hashSet = new HashSet();
        for (C0401y6 y6Var : unmodifiableSet) {
            if (y6Var.a().equals(str)) {
                hashSet.add(y6Var);
            }
        }
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((C0401y6) it.next()).isSupported()) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException("Unknown feature ".concat(str));
    }

    public static float D(int i2) {
        float pow;
        float f2 = ((float) i2) / 255.0f;
        if (f2 <= 0.04045f) {
            pow = f2 / 12.92f;
        } else {
            pow = (float) Math.pow((double) ((f2 + 0.055f) / 1.055f), 2.4000000953674316d);
        }
        return pow * 100.0f;
    }

    public static final List E(Object obj) {
        List singletonList = Collections.singletonList(obj);
        C1177ig.e(singletonList, "singletonList(element)");
        return singletonList;
    }

    public static final List F(Object... objArr) {
        if (objArr.length <= 0) {
            return C1477xa.a;
        }
        List asList = Arrays.asList(objArr);
        C1177ig.e(asList, "asList(this)");
        return asList;
    }

    public static SSLContext G() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(IrctcImaApplication.a.getString(R.string.long_buffer), 0));
        KeyStore instance = KeyStore.getInstance("PKCS12");
        instance.load(byteArrayInputStream, LoginActivity.MOBILE_KEY.toCharArray());
        KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        instance2.init(instance, LoginActivity.MOBILE_KEY.toCharArray());
        SSLContext instance3 = SSLContext.getInstance("TLS");
        instance3.init(instance2.getKeyManagers(), (TrustManager[]) null, (SecureRandom) null);
        return instance3;
    }

    public static final int H(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean I(int i2, int i3) {
        if (i3 < 0 || i3 > 31) {
            throw new IllegalArgumentException(lf.h("parameter 'pBitIndex' must be between 0 and 31. pBitIndex=", i3));
        } else if ((i2 & (1 << i3)) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void J(View view, EditorInfo editorInfo, InputConnection inputConnection) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (parent instanceof ID) {
                    editorInfo.hintText = ((ID) parent).a();
                    return;
                }
            }
        }
    }

    public static final Object K(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static fq L(String str, wt wtVar) {
        C1382s8 s8Var = C1213k9.a;
        C0524Gy gy = new C0524Gy((Job) null);
        s8Var.getClass();
        C1085e7 a2 = d.a(CoroutineContext.a.a(s8Var, gy));
        C1177ig.f(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        C0161cq cqVar = C0161cq.a;
        C1177ig.f(cqVar, "produceMigrations");
        return new fq(str, wtVar, cqVar, a2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ab, code lost:
        if (r5.r0() != false) goto L_0x00ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void M(kotlin.coroutines.Continuation r9, java.lang.Object r10, kotlin.jvm.functions.Function1 r11) {
        /*
            boolean r0 = r9 instanceof defpackage.C1173i9
            if (r0 == 0) goto L_0x00d1
            i9 r9 = (defpackage.C1173i9) r9
            java.lang.Throwable r0 = defpackage.C0698Tt.a(r10)
            r1 = 0
            if (r0 != 0) goto L_0x0017
            if (r11 == 0) goto L_0x0015
            T5 r0 = new T5
            r0.<init>(r10, r11)
            goto L_0x001d
        L_0x0015:
            r0 = r10
            goto L_0x001d
        L_0x0017:
            S5 r11 = new S5
            r11.<init>(r1, r0)
            r0 = r11
        L_0x001d:
            kotlin.coroutines.Continuation<T> r11 = r9.f5486a
            r9.getContext()
            kotlinx.coroutines.CoroutineDispatcher r2 = r9.f5487a
            boolean r3 = r2.q()
            r4 = 1
            if (r3 == 0) goto L_0x0038
            r9.f5485a = r0
            r9.c = r4
            kotlin.coroutines.CoroutineContext r10 = r9.getContext()
            r2.h(r10, r9)
            goto L_0x00d4
        L_0x0038:
            Za r2 = defpackage.C0686Sz.a()
            long r5 = r2.a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0049
            r3 = r4
            goto L_0x004a
        L_0x0049:
            r3 = r1
        L_0x004a:
            if (r3 == 0) goto L_0x0060
            r9.f5485a = r0
            r9.c = r4
            I1<kotlinx.coroutines.g<?>> r10 = r2.f3880a
            if (r10 != 0) goto L_0x005b
            I1 r10 = new I1
            r10.<init>()
            r2.f3880a = r10
        L_0x005b:
            r10.addLast(r9)
            goto L_0x00d4
        L_0x0060:
            r2.s(r4)
            r3 = 0
            kotlin.coroutines.CoroutineContext r5 = r9.getContext()     // Catch:{ all -> 0x0088 }
            kotlinx.coroutines.Job$b r6 = kotlinx.coroutines.Job.b.a     // Catch:{ all -> 0x0088 }
            kotlin.coroutines.CoroutineContext$b r5 = r5.b(r6)     // Catch:{ all -> 0x0088 }
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5     // Catch:{ all -> 0x0088 }
            if (r5 == 0) goto L_0x008a
            boolean r6 = r5.isActive()     // Catch:{ all -> 0x0088 }
            if (r6 != 0) goto L_0x008a
            java.util.concurrent.CancellationException r1 = r5.e()     // Catch:{ all -> 0x0088 }
            r9.a(r0, r1)     // Catch:{ all -> 0x0088 }
            Tt$a r0 = n(r1)     // Catch:{ all -> 0x0088 }
            r9.resumeWith(r0)     // Catch:{ all -> 0x0088 }
            r1 = r4
            goto L_0x008a
        L_0x0088:
            r10 = move-exception
            goto L_0x00c5
        L_0x008a:
            if (r1 != 0) goto L_0x00be
            java.lang.Object r0 = r9.b     // Catch:{ all -> 0x0088 }
            kotlin.coroutines.CoroutineContext r1 = r11.getContext()     // Catch:{ all -> 0x0088 }
            java.lang.Object r0 = defpackage.C0673Rz.b(r1, r0)     // Catch:{ all -> 0x0088 }
            zD r5 = defpackage.C0673Rz.f3788a     // Catch:{ all -> 0x0088 }
            if (r0 == r5) goto L_0x009f
            gB r5 = defpackage.C1320p7.c(r11, r1, r0)     // Catch:{ all -> 0x0088 }
            goto L_0x00a0
        L_0x009f:
            r5 = r3
        L_0x00a0:
            r11.resumeWith(r10)     // Catch:{ all -> 0x00b1 }
            kotlin.Unit r10 = kotlin.Unit.a     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x00ad
            boolean r10 = r5.r0()     // Catch:{ all -> 0x0088 }
            if (r10 == 0) goto L_0x00be
        L_0x00ad:
            defpackage.C0673Rz.a(r1, r0)     // Catch:{ all -> 0x0088 }
            goto L_0x00be
        L_0x00b1:
            r10 = move-exception
            if (r5 == 0) goto L_0x00ba
            boolean r11 = r5.r0()     // Catch:{ all -> 0x0088 }
            if (r11 == 0) goto L_0x00bd
        L_0x00ba:
            defpackage.C0673Rz.a(r1, r0)     // Catch:{ all -> 0x0088 }
        L_0x00bd:
            throw r10     // Catch:{ all -> 0x0088 }
        L_0x00be:
            boolean r10 = r2.v()     // Catch:{ all -> 0x0088 }
            if (r10 != 0) goto L_0x00be
            goto L_0x00c8
        L_0x00c5:
            r9.f(r10, r3)     // Catch:{ all -> 0x00cc }
        L_0x00c8:
            r2.r(r4)
            goto L_0x00d4
        L_0x00cc:
            r9 = move-exception
            r2.r(r4)
            throw r9
        L_0x00d1:
            r9.resumeWith(r10)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r1.M(kotlin.coroutines.Continuation, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static final void N(View view, LifecycleOwner lifecycleOwner) {
        C1177ig.f(view, "<this>");
        view.setTag(Mr.view_tree_lifecycle_owner, lifecycleOwner);
    }

    public static byte O(byte b2, int i2) {
        if (i2 >= 0 && i2 <= 7) {
            return (byte) (b2 | (1 << i2));
        }
        throw new IllegalArgumentException(lf.h("parameter 'pBitIndex' must be between 0 and 7. pBitIndex=", i2));
    }

    public static void P(O6 o6, View view, float[] fArr) {
        Class<?> cls = view.getClass();
        String str = "set" + o6.f464a;
        try {
            boolean z = true;
            switch (xx.V(o6.f463a)) {
                case 0:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf((int) fArr[0])});
                    return;
                case 1:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(fArr[0])});
                    return;
                case 2:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf((l((int) (fArr[3] * 255.0f)) << 24) | (l((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (l((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | l((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)))});
                    return;
                case 3:
                    Method method = cls.getMethod(str, new Class[]{Drawable.class});
                    int l2 = l((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                    int l3 = l((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                    int l4 = l((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((l((int) (fArr[3] * 255.0f)) << 24) | (l2 << 16) | (l3 << 8) | l4);
                    method.invoke(view, new Object[]{colorDrawable});
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + o6.f464a);
                case 5:
                    Method method2 = cls.getMethod(str, new Class[]{Boolean.TYPE});
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    method2.invoke(view, objArr);
                    return;
                case 6:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(fArr[0])});
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e2) {
            C0175e8.d(view);
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            C0175e8.d(view);
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public static final void Q(Field field, C0811c cVar, Object obj) {
        C1177ig.g(field, "receiver$0");
        try {
            field.set(cVar, obj);
        } catch (IllegalAccessException unused) {
        }
    }

    public static final void R(Object obj) {
        if (obj instanceof C0698Tt.a) {
            throw ((C0698Tt.a) obj).a;
        }
    }

    public static byte[] S(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            byte[] byteArray = bigInteger.toByteArray();
            if (bigInteger.bitLength() % 8 == 0 && byteArray[0] == 0 && byteArray.length > 1) {
                return C1354qp.z0(byteArray, 1, byteArray.length - 1);
            }
            return byteArray;
        }
        throw new IllegalArgumentException("Cannot convert negative values to an unsigned magnitude byte array: " + bigInteger);
    }

    public static final Map T(LinkedHashMap linkedHashMap) {
        Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        C1177ig.e(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static void U() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }

    public static float V() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public static float a(float f2) {
        if (f2 <= 0.04045f) {
            return f2 / 12.92f;
        }
        return (float) Math.pow((double) ((f2 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static float b(float f2) {
        if (f2 <= 0.0031308f) {
            return f2 * 12.92f;
        }
        return (float) ((Math.pow((double) f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static boolean e(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle2 == null) {
            if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1)) {
            return true;
        } else {
            return false;
        }
    }

    public static H3 f(C0457B8 b8) {
        F3 f3 = new F3();
        H3<T> h3 = new H3<>(f3);
        f3.f187a = h3;
        f3.f188a = n7.class;
        try {
            b8.W(new o7(f3, b8));
            f3.f188a = "Deferred.asListenableFuture";
        } catch (Exception e2) {
            h3.a.setException(e2);
        }
        return h3;
    }

    public static void g(byte[] bArr) {
        if (bArr != null) {
            char[] charArray = "0123456789ABCDEF".toCharArray();
            char[] cArr = new char[(bArr.length * 2)];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
                int i3 = i2 * 2;
                cArr[i3] = charArray[b2 >>> 4];
                cArr[i3 + 1] = charArray[b2 & Ascii.SI];
            }
            new String(cArr);
        }
    }

    public static final void h(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        C0155cA i2 = i(function1, obj, (C0155cA) null);
        if (i2 != null) {
            C1399t7.a(coroutineContext, i2);
        }
    }

    public static final C0155cA i(Function1 function1, Object obj, C0155cA cAVar) {
        try {
            function1.invoke(obj);
        } catch (Throwable th) {
            if (cAVar == null || cAVar.getCause() == th) {
                return new C0155cA("Exception in undelivered element handler for " + obj, th);
            }
            C1354qp.g(cAVar, th);
        }
        return cAVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.Serializable j(kotlin.coroutines.Continuation r4, kotlinx.coroutines.flow.Flow r5, kotlinx.coroutines.flow.FlowCollector r6) {
        /*
            boolean r0 = r4 instanceof defpackage.C0578Lc
            if (r0 == 0) goto L_0x0013
            r0 = r4
            Lc r0 = (defpackage.C0578Lc) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Lc r0 = new Lc
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.f3695a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            Ks r5 = r0.a
            R(r4)     // Catch:{ all -> 0x0029 }
            goto L_0x004c
        L_0x0029:
            r4 = move-exception
            r1 = r4
            goto L_0x0051
        L_0x002c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0034:
            R(r4)
            Ks r4 = new Ks
            r4.<init>()
            Mc r2 = new Mc     // Catch:{ all -> 0x004e }
            r2.<init>(r6, r4)     // Catch:{ all -> 0x004e }
            r0.a = r4     // Catch:{ all -> 0x004e }
            r0.c = r3     // Catch:{ all -> 0x004e }
            java.lang.Object r4 = r5.collect(r2, r0)     // Catch:{ all -> 0x004e }
            if (r4 != r1) goto L_0x004c
            goto L_0x008b
        L_0x004c:
            r1 = 0
            goto L_0x008b
        L_0x004e:
            r5 = move-exception
            r1 = r5
            r5 = r4
        L_0x0051:
            T r4 = r5.a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r5 = 0
            if (r4 == 0) goto L_0x0060
            boolean r6 = defpackage.C1177ig.a(r4, r1)
            if (r6 == 0) goto L_0x0060
            r6 = r3
            goto L_0x0061
        L_0x0060:
            r6 = r5
        L_0x0061:
            if (r6 != 0) goto L_0x0098
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.Job$b r0 = kotlinx.coroutines.Job.b.a
            kotlin.coroutines.CoroutineContext$b r6 = r6.b(r0)
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            if (r6 == 0) goto L_0x0087
            boolean r0 = r6.isCancelled()
            if (r0 != 0) goto L_0x0078
            goto L_0x0087
        L_0x0078:
            java.util.concurrent.CancellationException r6 = r6.e()
            if (r6 == 0) goto L_0x0085
            boolean r6 = defpackage.C1177ig.a(r6, r1)
            if (r6 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r3 = r5
        L_0x0086:
            r5 = r3
        L_0x0087:
            if (r5 != 0) goto L_0x0098
            if (r4 != 0) goto L_0x008c
        L_0x008b:
            return r1
        L_0x008c:
            boolean r5 = r1 instanceof java.util.concurrent.CancellationException
            if (r5 == 0) goto L_0x0094
            defpackage.C1354qp.g(r4, r1)
            throw r4
        L_0x0094:
            defpackage.C1354qp.g(r1, r4)
            throw r1
        L_0x0098:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r1.j(kotlin.coroutines.Continuation, kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.FlowCollector):java.io.Serializable");
    }

    public static int k(Context context, String str) {
        boolean z;
        int i2;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String d2 = B1.d(str);
        if (d2 != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            int myUid2 = Process.myUid();
            String packageName2 = context.getPackageName();
            if (myUid2 != myUid || !Objects.equals(packageName2, packageName)) {
                z = false;
            } else {
                z = true;
            }
            Class cls = AppOpsManager.class;
            if (!z) {
                i2 = B1.c((AppOpsManager) B1.a(context, cls), d2, packageName);
            } else if (Build.VERSION.SDK_INT >= 29) {
                AppOpsManager c2 = C1.c(context);
                i2 = C1.a(c2, d2, Binder.getCallingUid(), packageName);
                if (i2 == 0) {
                    i2 = C1.a(c2, d2, myUid, C1.b(context));
                }
            } else {
                i2 = B1.c((AppOpsManager) B1.a(context, cls), d2, packageName);
            }
            if (i2 != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static int l(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + Constants.MAX_HOST_LENGTH;
    }

    public static final Continuation m(Object obj, Continuation continuation, Function2 function2) {
        C1177ig.f(function2, "<this>");
        C1177ig.f(continuation, "completion");
        if (function2 instanceof C1340q2) {
            return ((C1340q2) function2).create(obj, continuation);
        }
        CoroutineContext context = continuation.getContext();
        if (context == C1440va.a) {
            return new C1197jg(obj, continuation, function2);
        }
        return new C1219kg(continuation, context, function2, obj);
    }

    public static final C0698Tt.a n(Throwable th) {
        C1177ig.f(th, "exception");
        return new C0698Tt.a(th);
    }

    public static void o(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain ".concat(str));
        }
    }

    public static int p(float f2, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        float f3 = ((float) ((i2 >> 24) & Constants.MAX_HOST_LENGTH)) / 255.0f;
        float a2 = a(((float) ((i2 >> 16) & Constants.MAX_HOST_LENGTH)) / 255.0f);
        float a3 = a(((float) ((i2 >> 8) & Constants.MAX_HOST_LENGTH)) / 255.0f);
        float a4 = a(((float) (i2 & Constants.MAX_HOST_LENGTH)) / 255.0f);
        float a5 = a(((float) ((i3 >> 16) & Constants.MAX_HOST_LENGTH)) / 255.0f);
        float a6 = a(((float) ((i3 >> 8) & Constants.MAX_HOST_LENGTH)) / 255.0f);
        float a7 = a(((float) (i3 & Constants.MAX_HOST_LENGTH)) / 255.0f);
        float a8 = lf.a(((float) ((i3 >> 24) & Constants.MAX_HOST_LENGTH)) / 255.0f, f3, f2, f3);
        float a9 = lf.a(a5, a2, f2, a2);
        float a10 = lf.a(a6, a3, f2, a3);
        float a11 = lf.a(a7, a4, f2, a4);
        int round = Math.round(b(a9) * 255.0f) << 16;
        return Math.round(b(a11) * 255.0f) | round | (Math.round(a8 * 255.0f) << 24) | (Math.round(b(a10) * 255.0f) << 8);
    }

    public static final Object q(Pv pv, long j2, Function2 function2) {
        boolean z;
        while (true) {
            if (pv.f3758a >= j2 && !pv.c()) {
                return pv;
            }
            Object obj = C1473x6.a.get(pv);
            C0422zD zDVar = f3215c;
            if (obj == zDVar) {
                return zDVar;
            }
            Pv pv2 = (Pv) ((C1473x6) obj);
            if (pv2 == null) {
                pv2 = (Pv) function2.invoke(Long.valueOf(pv.f3758a + 1), pv);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1473x6.a;
                    if (!atomicReferenceFieldUpdater.compareAndSet(pv, (Object) null, pv2)) {
                        if (atomicReferenceFieldUpdater.get(pv) != null) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    if (pv.c()) {
                        pv.d();
                    }
                }
            }
            pv = pv2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object r(kotlinx.coroutines.flow.Flow r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof defpackage.C0636Pc
            if (r0 == 0) goto L_0x0013
            r0 = r6
            Pc r0 = (defpackage.C0636Pc) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Pc r0 = new Pc
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f3753a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            zD r3 = h
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            Oc r5 = r0.f3752a
            Ks r0 = r0.a
            R(r6)     // Catch:{ j -> 0x002d }
            goto L_0x005d
        L_0x002d:
            r6 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            R(r6)
            Ks r6 = new Ks
            r6.<init>()
            r6.a = r3
            Oc r2 = new Oc
            r2.<init>(r6)
            r0.a = r6     // Catch:{ j -> 0x0055 }
            r0.f3752a = r2     // Catch:{ j -> 0x0055 }
            r0.c = r4     // Catch:{ j -> 0x0055 }
            java.lang.Object r5 = r5.collect(r2, r0)     // Catch:{ j -> 0x0055 }
            if (r5 != r1) goto L_0x0053
            goto L_0x0061
        L_0x0053:
            r0 = r6
            goto L_0x005d
        L_0x0055:
            r5 = move-exception
            r0 = r6
            r6 = r5
            r5 = r2
        L_0x0059:
            kotlinx.coroutines.flow.FlowCollector<?> r1 = r6.a
            if (r1 != r5) goto L_0x006a
        L_0x005d:
            T r1 = r0.a
            if (r1 == r3) goto L_0x0062
        L_0x0061:
            return r1
        L_0x0062:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "Expected at least one element"
            r5.<init>(r6)
            throw r5
        L_0x006a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r1.r(kotlinx.coroutines.flow.Flow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static BigInteger s(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] t(String str) {
        String replace = str.replace(" ", "");
        if (replace.length() % 2 == 0) {
            byte[] bArr = new byte[Math.round(((float) replace.length()) / 2.0f)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < replace.length()) {
                int i4 = i2 + 2;
                bArr[i3] = Integer.valueOf(Integer.parseInt(replace.substring(i2, i4), 16)).byteValue();
                i2 = i4;
                i3++;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex binary needs to be even-length :".concat(str));
    }

    public static byte[] u(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalStateException(C0709Uj.i("Unknown or unsupported character set name: ", str2));
        }
    }

    public static byte[] v(String str) {
        return u(str, "UTF-8");
    }

    public static Drawable w(Context context, int i2) {
        return Dt.c().e(context, i2);
    }

    public static Mac x(String str, Key key) throws C0626Og {
        try {
            Mac instance = Mac.getInstance(str);
            try {
                instance.init(key);
                return instance;
            } catch (InvalidKeyException e2) {
                throw new C1259mg("Key is not valid for " + instance.getAlgorithm() + " - " + e2, e2);
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new C0626Og(C0709Uj.i("Unable to get a MAC implementation of algorithm name: ", str), e3);
        } catch (NoSuchProviderException e4) {
            throw new C0626Og(lf.j("Unable to get a MAC implementation of algorithm name: ", str, " using provider null"), e4);
        }
    }

    public static final int y(List list) {
        C1177ig.f(list, "<this>");
        return list.size() - 1;
    }

    public static final c z(Continuation continuation) {
        c cVar;
        c cVar2;
        boolean z;
        boolean z2 = true;
        if (!(continuation instanceof C1173i9)) {
            return new c(1, continuation);
        }
        C1173i9 i9Var = (C1173i9) continuation;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1173i9.a;
            Object obj = atomicReferenceFieldUpdater.get(i9Var);
            C0422zD zDVar = e;
            cVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(i9Var, zDVar);
                cVar2 = null;
                break;
            } else if (obj instanceof c) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(i9Var, obj, zDVar)) {
                        if (atomicReferenceFieldUpdater.get(i9Var) != obj) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    cVar2 = (c) obj;
                    break;
                }
            } else if (obj != zDVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (cVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = c.f5561a;
            Object obj2 = atomicReferenceFieldUpdater2.get(cVar2);
            if (!(obj2 instanceof Q5) || ((Q5) obj2).b == null) {
                c.a.set(cVar2, 536870911);
                atomicReferenceFieldUpdater2.set(cVar2, H.a);
            } else {
                cVar2.n();
                z2 = false;
            }
            if (z2) {
                cVar = cVar2;
            }
            if (cVar != null) {
                return cVar;
            }
        }
        return new c(2, continuation);
    }

    public Object c(Object obj) {
        C c2 = (C) obj;
        Cu.f3555a.e().getClass();
        return c2;
    }

    public void call(Object obj) {
        Throwable th = (Throwable) obj;
        Cu.f3555a.b().getClass();
    }

    public Object d(Tg tg, float f2) throws IOException {
        double d2;
        boolean z = true;
        if (tg.r() != 1) {
            z = false;
        }
        if (z) {
            tg.a();
        }
        double m2 = tg.m();
        double m3 = tg.m();
        double m4 = tg.m();
        if (tg.r() == 7) {
            d2 = tg.m();
        } else {
            d2 = 1.0d;
        }
        if (z) {
            tg.c();
        }
        if (m2 <= 1.0d && m3 <= 1.0d && m4 <= 1.0d) {
            m2 *= 255.0d;
            m3 *= 255.0d;
            m4 *= 255.0d;
            if (d2 <= 1.0d) {
                d2 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d2, (int) m2, (int) m3, (int) m4));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.View r5, java.lang.String r6, android.content.Context r7, android.util.AttributeSet r8) {
        /*
            r4 = this;
            java.lang.String r5 = "name"
            defpackage.C1177ig.g(r6, r5)
            java.lang.String r5 = "context"
            defpackage.C1177ig.g(r7, r5)
            java.lang.Class r5 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0053 }
            java.lang.Class<android.view.View> r6 = android.view.View.class
            java.lang.Class r5 = r5.asSubclass(r6)     // Catch:{ Exception -> 0x0053 }
            r6 = 0
            r0 = 1
            java.lang.Class[] r1 = f3213b     // Catch:{ NoSuchMethodException -> 0x002f }
            r2 = 2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r2)     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.reflect.Constructor r1 = r5.getConstructor(r1)     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.String r3 = "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_2)"
            defpackage.C1177ig.b(r1, r3)     // Catch:{ NoSuchMethodException -> 0x002f }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x002f }
            r2[r6] = r7     // Catch:{ NoSuchMethodException -> 0x002f }
            r2[r0] = r8     // Catch:{ NoSuchMethodException -> 0x002f }
            goto L_0x0044
        L_0x002f:
            java.lang.Class[] r8 = f3210a     // Catch:{ Exception -> 0x0053 }
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r0)     // Catch:{ Exception -> 0x0053 }
            java.lang.Class[] r8 = (java.lang.Class[]) r8     // Catch:{ Exception -> 0x0053 }
            java.lang.reflect.Constructor r1 = r5.getConstructor(r8)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_1)"
            defpackage.C1177ig.b(r1, r5)     // Catch:{ Exception -> 0x0053 }
            android.content.Context[] r2 = new android.content.Context[r0]     // Catch:{ Exception -> 0x0053 }
            r2[r6] = r7     // Catch:{ Exception -> 0x0053 }
        L_0x0044:
            r1.setAccessible(r0)     // Catch:{ Exception -> 0x0053 }
            int r5 = r2.length     // Catch:{ Exception -> 0x0053 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r2, r5)     // Catch:{ Exception -> 0x0053 }
            java.lang.Object r5 = r1.newInstance(r5)     // Catch:{ Exception -> 0x0053 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ Exception -> 0x0053 }
            return r5
        L_0x0053:
            r5 = move-exception
            boolean r6 = r5 instanceof java.lang.ClassNotFoundException
            if (r6 == 0) goto L_0x005c
            r5.printStackTrace()
            goto L_0x007b
        L_0x005c:
            boolean r6 = r5 instanceof java.lang.NoSuchMethodException
            if (r6 == 0) goto L_0x0064
            r5.printStackTrace()
            goto L_0x007b
        L_0x0064:
            boolean r6 = r5 instanceof java.lang.IllegalAccessException
            if (r6 == 0) goto L_0x006c
            r5.printStackTrace()
            goto L_0x007b
        L_0x006c:
            boolean r6 = r5 instanceof java.lang.InstantiationException
            if (r6 == 0) goto L_0x0074
            r5.printStackTrace()
            goto L_0x007b
        L_0x0074:
            boolean r6 = r5 instanceof java.lang.reflect.InvocationTargetException
            if (r6 == 0) goto L_0x007d
            r5.printStackTrace()
        L_0x007b:
            r5 = 0
            return r5
        L_0x007d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r1.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }
}
