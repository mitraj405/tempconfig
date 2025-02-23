package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.datastore.core.CorruptionException;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import defpackage.C0670Rn;
import defpackage.C1171i7;
import defpackage.V4;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.c;
import kotlinx.coroutines.f;
import kotlinx.coroutines.g;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import rx.Subscriber;

/* renamed from: qp  reason: default package and case insensitive filesystem */
/* compiled from: PaytmUtility */
public class C1354qp implements XB, C0387x7, C0405yD {
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static Typeface f6910a;

    /* renamed from: a  reason: collision with other field name */
    public static final C1354qp f6911a = new C1354qp();

    /* renamed from: a  reason: collision with other field name */
    public static final C1402ta f6912a = new C1402ta(false);

    /* renamed from: a  reason: collision with other field name */
    public static volatile C0397xm f6913a;

    /* renamed from: a  reason: collision with other field name */
    public static final C0422zD f6914a = new C0422zD("COMPLETING_ALREADY", 2);

    /* renamed from: a  reason: collision with other field name */
    public static volatile C0427zm f6915a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f6916a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f6917a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f6918a = new int[0];

    /* renamed from: a  reason: collision with other field name */
    public static final long[] f6919a = new long[0];

    /* renamed from: a  reason: collision with other field name */
    public static final Object[] f6920a = new Object[0];

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f6921a = new String[0];
    public static final C1402ta b = new C1402ta(true);

    /* renamed from: b  reason: collision with other field name */
    public static final C0422zD f6922b = new C0422zD("COMPLETING_WAITING_CHILDREN", 2);

    /* renamed from: b  reason: collision with other field name */
    public static final byte[] f6923b = new byte[0];

    /* renamed from: b  reason: collision with other field name */
    public static final Object[] f6924b = new Object[0];
    public static final C0422zD c = new C0422zD("COMPLETING_RETRY", 2);
    public static final C0422zD d = new C0422zD("TOO_LATE_TO_CANCEL", 2);
    public static final C0422zD e = new C0422zD("SEALED", 2);
    public static final C0422zD f = new C0422zD("CONDITION_FALSE", 2);
    public static final C0422zD g = new C0422zD("NO_OWNER", 2);

    public /* synthetic */ C1354qp() {
    }

    public static byte[] A(byte[]... bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] write : bArr) {
                byteArrayOutputStream.write(write);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new IllegalStateException("IOEx from ByteArrayOutputStream?!", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long A0(long r23, long r25, long r27, java.lang.String r29) {
        /*
            r0 = r25
            r2 = r27
            r4 = r29
            int r5 = defpackage.C1121fz.a
            java.lang.String r6 = java.lang.System.getProperty(r29)     // Catch:{ SecurityException -> 0x000d }
            goto L_0x000e
        L_0x000d:
            r6 = 0
        L_0x000e:
            if (r6 != 0) goto L_0x0014
            r8 = r23
            goto L_0x00c5
        L_0x0014:
            fg r7 = new fg
            r8 = 2
            r9 = 36
            r7.<init>(r8, r9)
            int r7 = r7.d
            r10 = 0
            r11 = 1
            r12 = 10
            if (r12 > r7) goto L_0x0026
            r7 = r11
            goto L_0x0027
        L_0x0026:
            r7 = r10
        L_0x0027:
            if (r7 == 0) goto L_0x011a
            int r7 = r6.length()
            if (r7 != 0) goto L_0x0033
        L_0x002f:
            r19 = r6
            goto L_0x0096
        L_0x0033:
            char r8 = r6.charAt(r10)
            r9 = 48
            if (r8 >= r9) goto L_0x003d
            r9 = -1
            goto L_0x0042
        L_0x003d:
            if (r8 != r9) goto L_0x0041
            r9 = r10
            goto L_0x0042
        L_0x0041:
            r9 = r11
        L_0x0042:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 >= 0) goto L_0x005b
            if (r7 != r11) goto L_0x004c
            goto L_0x002f
        L_0x004c:
            r9 = 45
            if (r8 != r9) goto L_0x0054
            r13 = -9223372036854775808
            r8 = r11
            goto L_0x005c
        L_0x0054:
            r9 = 43
            if (r8 != r9) goto L_0x002f
            r9 = r10
            r8 = r11
            goto L_0x005d
        L_0x005b:
            r8 = r10
        L_0x005c:
            r9 = r8
        L_0x005d:
            r15 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r17 = 0
            r10 = r17
            r17 = r15
        L_0x0068:
            if (r8 >= r7) goto L_0x00a0
            char r5 = r6.charAt(r8)
            int r5 = java.lang.Character.digit(r5, r12)
            if (r5 >= 0) goto L_0x0075
            goto L_0x002f
        L_0x0075:
            int r19 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r19 >= 0) goto L_0x0089
            int r17 = (r17 > r15 ? 1 : (r17 == r15 ? 0 : -1))
            if (r17 != 0) goto L_0x002f
            r19 = r6
            r20 = r7
            long r6 = (long) r12
            long r17 = r13 / r6
            int r6 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r6 >= 0) goto L_0x008d
            goto L_0x0096
        L_0x0089:
            r19 = r6
            r20 = r7
        L_0x008d:
            long r6 = (long) r12
            long r10 = r10 * r6
            long r5 = (long) r5
            long r21 = r13 + r5
            int r7 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r7 >= 0) goto L_0x0098
        L_0x0096:
            r5 = 0
            goto L_0x00ae
        L_0x0098:
            long r10 = r10 - r5
            int r8 = r8 + 1
            r6 = r19
            r7 = r20
            goto L_0x0068
        L_0x00a0:
            r19 = r6
            if (r9 == 0) goto L_0x00a9
            java.lang.Long r5 = java.lang.Long.valueOf(r10)
            goto L_0x00ae
        L_0x00a9:
            long r5 = -r10
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
        L_0x00ae:
            r6 = 39
            java.lang.String r7 = "System property '"
            if (r5 == 0) goto L_0x00f7
            long r8 = r5.longValue()
            int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x00c2
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00c2
            r10 = 1
            goto L_0x00c3
        L_0x00c2:
            r10 = 0
        L_0x00c3:
            if (r10 == 0) goto L_0x00c6
        L_0x00c5:
            return r8
        L_0x00c6:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r7)
            r10.append(r4)
            java.lang.String r4 = "' should be in range "
            r10.append(r4)
            r10.append(r0)
            java.lang.String r0 = ".."
            r10.append(r0)
            r10.append(r2)
            java.lang.String r0 = ", but is '"
            r10.append(r0)
            r10.append(r8)
            r10.append(r6)
            java.lang.String r0 = r10.toString()
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x00f7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r7)
            r1.append(r4)
            java.lang.String r2 = "' has unrecognized value '"
            r1.append(r2)
            r5 = r19
            r1.append(r5)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x011a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "radix 10 was not in valid range "
            r1.<init>(r2)
            fg r2 = new fg
            r2.<init>(r8, r9)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1354qp.A0(long, long, long, java.lang.String):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean B(java.lang.Object[] r4, defpackage.mf r5) {
        /*
            r0 = 0
            r1 = -1
            if (r5 != 0) goto L_0x0010
            r5 = r0
        L_0x0005:
            int r2 = r4.length
            if (r5 >= r2) goto L_0x002f
            r2 = r4[r5]
            if (r2 != 0) goto L_0x000d
            goto L_0x0030
        L_0x000d:
            int r5 = r5 + 1
            goto L_0x0005
        L_0x0010:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r2 = r2.getComponentType()
            boolean r2 = r2.isInstance(r5)
            if (r2 == 0) goto L_0x002f
            r2 = r0
        L_0x001f:
            int r3 = r4.length
            if (r2 >= r3) goto L_0x002f
            r3 = r4[r2]
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x002c
            r5 = r2
            goto L_0x0030
        L_0x002c:
            int r2 = r2 + 1
            goto L_0x001f
        L_0x002f:
            r5 = r1
        L_0x0030:
            if (r5 == r1) goto L_0x0033
            r0 = 1
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1354qp.B(java.lang.Object[], mf):boolean");
    }

    public static int B0(String str, int i, int i2, int i3, int i4) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) A0((long) i, (long) i2, (long) i3, str);
    }

    public static final long C(long j, C0513G9 g9, C0513G9 g92) {
        C1177ig.f(g9, "sourceUnit");
        C1177ig.f(g92, "targetUnit");
        return g92.f3590a.convert(j, g9.f3590a);
    }

    public static void C0(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList.size() == 1) {
                Throwable th = (Throwable) arrayList.get(0);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                } else if (th instanceof Error) {
                    throw ((Error) th);
                } else {
                    throw new RuntimeException(th);
                }
            } else {
                throw new C1190j6((List) arrayList);
            }
        }
    }

    public static synchronized void D() {
        synchronized (C1354qp.class) {
        }
    }

    public static void D0(Throwable th) {
        if (th instanceof Qn) {
            throw ((Qn) th);
        } else if (th instanceof Pn) {
            throw ((Pn) th);
        } else if (th instanceof Nn) {
            throw ((Nn) th);
        } else if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static String E(String str) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (!str.isEmpty()) {
            i = Integer.parseInt(str.substring(0, 1));
        } else {
            i = 0;
        }
        if (str.length() > 1) {
            i2 = Integer.parseInt(str.substring(0, 2));
        } else {
            i2 = 0;
        }
        if (str.length() > 3) {
            i3 = Integer.parseInt(str.substring(0, 4));
        } else {
            i3 = 0;
        }
        if (str.length() > 5) {
            i4 = Integer.parseInt(str.substring(0, 6));
        }
        if (i4 >= 508500 && i4 <= 508999) {
            return "rupay";
        }
        if (i4 >= 606985 && i4 <= 607384) {
            return "rupay";
        }
        if (i4 >= 607385 && i4 <= 607484) {
            return "rupay";
        }
        if (i4 >= 607485 && i4 <= 607984) {
            return "rupay";
        }
        if (i4 >= 608001 && i4 <= 608100) {
            return "rupay";
        }
        if (i4 >= 608101 && i4 <= 608200) {
            return "rupay";
        }
        if (i4 >= 608201 && i4 <= 608300) {
            return "rupay";
        }
        if (i4 >= 608301 && i4 <= 608350) {
            return "rupay";
        }
        if (i4 >= 608351 && i4 <= 608500) {
            return "rupay";
        }
        if (i4 >= 652150 && i4 <= 652849) {
            return "rupay";
        }
        if (i4 >= 652850 && i4 <= 653049) {
            return "rupay";
        }
        if (i4 >= 653050 && i4 <= 653149) {
            return "rupay";
        }
        if (i == 4) {
            return "visa";
        }
        if (i2 >= 51 && i2 <= 55) {
            return "mastercard";
        }
        if (i2 == 34 || i2 == 37 || i3 == 3528 || i3 == 3589) {
            return "amex";
        }
        if (i4 >= 300000 && i4 <= 305999) {
            return "diners";
        }
        if (i4 >= 309500 && i4 <= 309599) {
            return "diners";
        }
        if (i4 >= 360000 && i4 <= 369999) {
            return "diners";
        }
        if (i4 >= 380000 && i4 <= 389999) {
            return "diners";
        }
        if (i4 >= 601100 && i4 <= 601109) {
            return "discover";
        }
        if (i4 >= 601120 && i4 <= 601149) {
            return "discover";
        }
        if (i4 >= 601174 && i4 <= 601174) {
            return "discover";
        }
        if (i4 >= 601177 && i4 <= 601179) {
            return "discover";
        }
        if (i4 >= 601186 && i4 <= 601199) {
            return "discover";
        }
        if (i4 >= 644000 && i4 <= 659999) {
            return "discover";
        }
        if (str.matches("^(508125|508126|508159|508192|508227|504437|504681|5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390|50|63|66|5[6-8]|6[8-9]|600[0-9]|6010|601[2-9]|60[2-9]|61|620|621|6220|6221[0-1])([0-9]*)") || str.length() > 16) {
            return "maestro";
        }
        return "Unsupported Card";
    }

    public static void E0(Throwable th, Subscriber subscriber, Object obj) {
        D0(th);
        int i = C0670Rn.c;
        int i2 = 0;
        Throwable th2 = th;
        int i3 = 0;
        while (true) {
            if (th2.getCause() == null) {
                break;
            }
            int i4 = i3 + 1;
            if (i3 >= 25) {
                th2 = new RuntimeException("Stack too deep to get final cause");
                break;
            } else {
                th2 = th2.getCause();
                i3 = i4;
            }
        }
        if (!(th2 instanceof C0670Rn.a) || ((C0670Rn.a) th2).a != obj) {
            C0670Rn.a aVar = new C0670Rn.a(obj);
            HashSet hashSet = new HashSet();
            Throwable th3 = th;
            while (true) {
                if (th3.getCause() != null) {
                    int i5 = i2 + 1;
                    if (i2 >= 25) {
                        break;
                    }
                    th3 = th3.getCause();
                    if (!hashSet.contains(th3.getCause())) {
                        hashSet.add(th3.getCause());
                        i2 = i5;
                    }
                }
                try {
                    th3.initCause(aVar);
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        subscriber.onError(th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0092, code lost:
        if (r9 != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0096, code lost:
        if ((r7 instanceof java.util.concurrent.CancellationException) != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009b, code lost:
        if (r5 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        r5 = new java.util.concurrent.CancellationException("Channel was consumed, consumer had failed");
        r5.initCause(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a7, code lost:
        r8.c(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x0091 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object F(kotlinx.coroutines.flow.FlowCollector r7, defpackage.C1501yq r8, boolean r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof defpackage.C0552Jc
            if (r0 == 0) goto L_0x0013
            r0 = r10
            Jc r0 = (defpackage.C0552Jc) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Jc r0 = new Jc
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f3667a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r3) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            boolean r9 = r0.f3669a
            T4 r7 = r0.f3666a
            Cs r8 = r0.a
            kotlinx.coroutines.flow.FlowCollector r2 = r0.f3668a
            defpackage.r1.R(r10)     // Catch:{ all -> 0x0086 }
        L_0x0032:
            r10 = r7
            r7 = r2
            goto L_0x0054
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            boolean r9 = r0.f3669a
            T4 r7 = r0.f3666a
            Cs r8 = r0.a
            kotlinx.coroutines.flow.FlowCollector r2 = r0.f3668a
            defpackage.r1.R(r10)     // Catch:{ all -> 0x0086 }
            goto L_0x0069
        L_0x0049:
            defpackage.r1.R(r10)
            boolean r10 = r7 instanceof defpackage.Wz
            if (r10 != 0) goto L_0x00ab
            T4 r10 = r8.f()     // Catch:{ all -> 0x0086 }
        L_0x0054:
            r0.f3668a = r7     // Catch:{ all -> 0x0086 }
            r0.a = r8     // Catch:{ all -> 0x0086 }
            r0.f3666a = r10     // Catch:{ all -> 0x0086 }
            r0.f3669a = r9     // Catch:{ all -> 0x0086 }
            r0.c = r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = r10.a(r0)     // Catch:{ all -> 0x0086 }
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L_0x0069:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0086 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0086 }
            if (r10 == 0) goto L_0x0088
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x0086 }
            r0.f3668a = r2     // Catch:{ all -> 0x0086 }
            r0.a = r8     // Catch:{ all -> 0x0086 }
            r0.f3666a = r7     // Catch:{ all -> 0x0086 }
            r0.f3669a = r9     // Catch:{ all -> 0x0086 }
            r0.c = r4     // Catch:{ all -> 0x0086 }
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch:{ all -> 0x0086 }
            if (r10 != r1) goto L_0x0032
            return r1
        L_0x0086:
            r7 = move-exception
            goto L_0x0090
        L_0x0088:
            if (r9 == 0) goto L_0x008d
            r8.c(r5)
        L_0x008d:
            kotlin.Unit r7 = kotlin.Unit.a
            return r7
        L_0x0090:
            throw r7     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r10 = move-exception
            if (r9 == 0) goto L_0x00aa
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L_0x009b
            r5 = r7
            java.util.concurrent.CancellationException r5 = (java.util.concurrent.CancellationException) r5
        L_0x009b:
            if (r5 != 0) goto L_0x00a7
            java.util.concurrent.CancellationException r5 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r5.<init>(r9)
            r5.initCause(r7)
        L_0x00a7:
            r8.c(r5)
        L_0x00aa:
            throw r10
        L_0x00ab:
            Wz r7 = (defpackage.Wz) r7
            r7.getClass()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1354qp.F(kotlinx.coroutines.flow.FlowCollector, yq, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object[] F0(Collection collection) {
        C1177ig.f(collection, "collection");
        int size = collection.size();
        Object[] objArr = f6920a;
        if (size == 0) {
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArr2 = new Object[size];
        int i = 0;
        while (true) {
            int i2 = i + 1;
            objArr2[i] = it.next();
            if (i2 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = 2147483645;
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i3);
                C1177ig.e(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr2, i2);
                C1177ig.e(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i = i2;
        }
    }

    public static void G() {
        int i = a;
        if (i > 0) {
            a = i - 1;
        }
    }

    public static final Object[] G0(Collection collection, Object[] objArr) {
        Object[] objArr2;
        C1177ig.f(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    C1177ig.d(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i2 = i + 1;
                    objArr2[i] = it.next();
                    if (i2 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i3);
                        C1177ig.e(objArr2, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i2] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i2);
                        C1177ig.e(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i = i2;
                }
            } else if (objArr.length <= 0) {
                return objArr;
            } else {
                objArr[0] = null;
                return objArr;
            }
        } else if (objArr.length <= 0) {
            return objArr;
        } else {
            objArr[0] = null;
            return objArr;
        }
    }

    public static final boolean H(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static final long H0(int i, C0513G9 g9) {
        C1177ig.f(g9, "unit");
        if (g9.compareTo(C0513G9.SECONDS) > 0) {
            return I0((long) i, g9);
        }
        long C = C((long) i, g9, C0513G9.NANOSECONDS) << 1;
        int i2 = Duration.c;
        int i3 = F9.a;
        return C;
    }

    public static String I(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                sb.append("\\f");
            } else if (charAt == 13) {
                sb.append("\\r");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    default:
                        if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                            String hexString = Integer.toHexString(charAt);
                            sb.append("\\u");
                            for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                                sb.append('0');
                            }
                            sb.append(hexString.toUpperCase());
                            break;
                        } else {
                            sb.append(charAt);
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r6 > 4611686018427387903L) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long I0(long r6, defpackage.C0513G9 r8) {
        /*
            java.lang.String r0 = "unit"
            defpackage.C1177ig.f(r8, r0)
            G9 r0 = defpackage.C0513G9.NANOSECONDS
            r1 = 4611686018426999999(0x3ffffffffffa14bf, double:1.9999999999138678)
            long r1 = C(r1, r0, r8)
            Wi r3 = new Wi
            long r4 = -r1
            r3.<init>(r4, r1)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r2 = 1
            if (r1 > 0) goto L_0x0023
            long r3 = r3.b
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0023
            r1 = r2
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r1 == 0) goto L_0x0030
            long r6 = C(r6, r8, r0)
            long r6 = r6 << r2
            int r8 = kotlin.time.Duration.c
            int r8 = defpackage.F9.a
            return r6
        L_0x0030:
            G9 r0 = defpackage.C0513G9.MILLISECONDS
            java.lang.String r1 = "targetUnit"
            defpackage.C1177ig.f(r0, r1)
            java.util.concurrent.TimeUnit r0 = r0.f3590a
            java.util.concurrent.TimeUnit r8 = r8.f3590a
            long r6 = r0.convert(r6, r8)
            r0 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 >= 0) goto L_0x004a
        L_0x0048:
            r6 = r0
            goto L_0x0054
        L_0x004a:
            r0 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x0054
            goto L_0x0048
        L_0x0054:
            long r6 = r6 << r2
            r0 = 1
            long r6 = r6 + r0
            int r8 = kotlin.time.Duration.c
            int r8 = defpackage.F9.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1354qp.I0(long, G9):long");
    }

    public static u8 J(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.GET);
        httpURLConnection.connect();
        return new u8(httpURLConnection);
    }

    public static String J0(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th);
        while (th.getCause() != null) {
            th = th.getCause();
            sb.append("; caused by: ");
            sb.append(th);
        }
        return sb.toString();
    }

    public static final C1423ub K(Executor executor) {
        if (executor instanceof C1192j9) {
            C1192j9 j9Var = (C1192j9) executor;
        }
        return new C1423ub(executor);
    }

    public static final void K0(C0790aw awVar, Object obj) {
        Object d2 = awVar.d(obj);
        if (!(d2 instanceof V4.b)) {
            Unit unit = (Unit) d2;
            Unit unit2 = Unit.a;
            return;
        }
        Object obj2 = ((V4) u0(new X4(awVar, obj, (Continuation<? super X4>) null))).f3815a;
    }

    public static byte[] L(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        return allocate.array();
    }

    public static final Object L0(Object obj) {
        Bf bf;
        C0449Af af;
        if (obj instanceof Bf) {
            bf = (Bf) obj;
        } else {
            bf = null;
        }
        if (bf == null || (af = bf.a) == null) {
            return obj;
        }
        return af;
    }

    public static Cipher M(String str) throws C0626Og {
        try {
            return Cipher.getInstance(str);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new C0626Og(e2.toString(), e2);
        } catch (NoSuchProviderException e3) {
            throw new C0626Og(lf.j("Unable to get a Cipher implementation of ", str, " using provider null"), e3);
        }
    }

    public static void M0(Key key, String str, int i) throws C1259mg {
        int length;
        if (key != null) {
            String algorithm = key.getAlgorithm();
            if (!"AES".equals(algorithm)) {
                throw new C1259mg(C1058d.A("Invalid key for JWE ", str, ", expected an AES key but an ", algorithm, " key was provided."));
            } else if (key.getEncoded() != null && (length = key.getEncoded().length) != i) {
                StringBuilder K = xx.K("Invalid key for JWE ", str, ", expected a ");
                K.append(l(i));
                K.append(" bit key but a ");
                K.append(l(length));
                K.append(" bit key was provided.");
                throw new C1259mg(K.toString());
            }
        } else {
            throw new C1259mg("The key must not be null.");
        }
    }

    public static int N(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }

    /* JADX INFO: finally extract failed */
    public static final Object N0(Continuation continuation, CoroutineContext coroutineContext, Function2 function2) {
        CoroutineContext coroutineContext2;
        CoroutineContext context = continuation.getContext();
        boolean z = false;
        if (!((Boolean) coroutineContext.C(Boolean.FALSE, C1344q7.a)).booleanValue()) {
            coroutineContext2 = context.j(coroutineContext);
        } else {
            coroutineContext2 = C1320p7.a(context, coroutineContext, false);
        }
        Job job = (Job) coroutineContext2.b(Job.b.a);
        if (job != null && !job.isActive()) {
            throw job.e();
        } else if (coroutineContext2 == context) {
            C1266mv mvVar = new C1266mv(continuation, coroutineContext2);
            return y0(mvVar, mvVar, function2);
        } else {
            C1171i7.a aVar = C1171i7.a.a;
            if (C1177ig.a(coroutineContext2.b(aVar), context.b(aVar))) {
                C1129gB gBVar = new C1129gB(continuation, coroutineContext2);
                CoroutineContext coroutineContext3 = gBVar.a;
                Object b2 = C0673Rz.b(coroutineContext3, (Object) null);
                try {
                    Object y0 = y0(gBVar, gBVar, function2);
                    C0673Rz.a(coroutineContext3, b2);
                    return y0;
                } catch (Throwable th) {
                    C0673Rz.a(coroutineContext3, b2);
                    throw th;
                }
            } else {
                f fVar = new f(continuation, coroutineContext2);
                try {
                    r1.M(r1.B(r1.m(fVar, fVar, function2)), Unit.a, (Function1) null);
                    while (true) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f.a;
                        int i = atomicIntegerFieldUpdater.get(fVar);
                        if (i == 0) {
                            if (atomicIntegerFieldUpdater.compareAndSet(fVar, 0, 1)) {
                                z = true;
                                break;
                            }
                        } else if (i != 2) {
                            throw new IllegalStateException("Already suspended".toString());
                        }
                    }
                    if (z) {
                        return C1438v7.COROUTINE_SUSPENDED;
                    }
                    Object L0 = L0(fVar.S());
                    if (!(L0 instanceof C0677S5)) {
                        return L0;
                    }
                    throw ((C0677S5) L0).f3789a;
                } catch (Throwable th2) {
                    fVar.resumeWith(r1.n(th2));
                    throw th2;
                }
            }
        }
    }

    public static String O(Context context, int i) {
        if (context == null) {
            return "";
        }
        if (i == 1) {
            return context.getString(Wr.fingerprint_error_hw_not_available);
        }
        if (i != 7) {
            switch (i) {
                case 9:
                    break;
                case 10:
                    return context.getString(Wr.fingerprint_error_user_canceled);
                case 11:
                    return context.getString(Wr.fingerprint_error_no_fingerprints);
                case 12:
                    return context.getString(Wr.fingerprint_error_hw_not_present);
                default:
                    return context.getString(Wr.default_error_msg);
            }
        }
        return context.getString(Wr.fingerprint_error_lockout);
    }

    public static void O0(Object obj, StringWriter stringWriter) throws IOException {
        if (obj == null) {
            stringWriter.write("null");
        } else if (obj instanceof String) {
            stringWriter.write(34);
            stringWriter.write(I((String) obj));
            stringWriter.write(34);
        } else if (obj instanceof Double) {
            Double d2 = (Double) obj;
            if (d2.isInfinite() || d2.isNaN()) {
                stringWriter.write("null");
            } else {
                stringWriter.write(obj.toString());
            }
        } else if (obj instanceof Float) {
            Float f2 = (Float) obj;
            if (f2.isInfinite() || f2.isNaN()) {
                stringWriter.write("null");
            } else {
                stringWriter.write(obj.toString());
            }
        } else if (obj instanceof Number) {
            stringWriter.write(obj.toString());
        } else if (obj instanceof Boolean) {
            stringWriter.write(obj.toString());
        } else if (obj instanceof C0520Gg) {
            ((C0520Gg) obj).a(stringWriter);
        } else if (obj instanceof Dg) {
            stringWriter.write(((Dg) obj).b());
        } else if (obj instanceof Map) {
            Eg.c((Map) obj, stringWriter);
        } else if (obj instanceof Collection) {
            Cg.c((Collection) obj, stringWriter);
        } else {
            int i = 1;
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int i2 = Cg.c;
                if (bArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                stringWriter.write(String.valueOf(bArr[0]));
                while (i < bArr.length) {
                    stringWriter.write(",");
                    stringWriter.write(String.valueOf(bArr[i]));
                    i++;
                }
                stringWriter.write("]");
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int i3 = Cg.c;
                if (sArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                stringWriter.write(String.valueOf(sArr[0]));
                while (i < sArr.length) {
                    stringWriter.write(",");
                    stringWriter.write(String.valueOf(sArr[i]));
                    i++;
                }
                stringWriter.write("]");
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int i4 = Cg.c;
                if (iArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                stringWriter.write(String.valueOf(iArr[0]));
                while (i < iArr.length) {
                    stringWriter.write(",");
                    stringWriter.write(String.valueOf(iArr[i]));
                    i++;
                }
                stringWriter.write("]");
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int i5 = Cg.c;
                if (jArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                stringWriter.write(String.valueOf(jArr[0]));
                while (i < jArr.length) {
                    stringWriter.write(",");
                    stringWriter.write(String.valueOf(jArr[i]));
                    i++;
                }
                stringWriter.write("]");
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int i6 = Cg.c;
                if (fArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                stringWriter.write(String.valueOf(fArr[0]));
                while (i < fArr.length) {
                    stringWriter.write(",");
                    stringWriter.write(String.valueOf(fArr[i]));
                    i++;
                }
                stringWriter.write("]");
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int i7 = Cg.c;
                if (dArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                stringWriter.write(String.valueOf(dArr[0]));
                while (i < dArr.length) {
                    stringWriter.write(",");
                    stringWriter.write(String.valueOf(dArr[i]));
                    i++;
                }
                stringWriter.write("]");
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int i8 = Cg.c;
                if (zArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                stringWriter.write(String.valueOf(zArr[0]));
                while (i < zArr.length) {
                    stringWriter.write(",");
                    stringWriter.write(String.valueOf(zArr[i]));
                    i++;
                }
                stringWriter.write("]");
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                int i9 = Cg.c;
                if (cArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[\"");
                stringWriter.write(I(String.valueOf(cArr[0])));
                while (i < cArr.length) {
                    stringWriter.write("\",\"");
                    stringWriter.write(I(String.valueOf(cArr[i])));
                    i++;
                }
                stringWriter.write("\"]");
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                int i10 = Cg.c;
                if (objArr.length == 0) {
                    stringWriter.write("[]");
                    return;
                }
                stringWriter.write("[");
                O0(objArr[0], stringWriter);
                while (i < objArr.length) {
                    stringWriter.write(",");
                    O0(objArr[i], stringWriter);
                    i++;
                }
                stringWriter.write("]");
            } else {
                O0(obj.toString(), stringWriter);
            }
        }
    }

    public static Typeface P(Context context) {
        if (f6910a == null) {
            f6910a = Typeface.createFromAsset(context.getAssets(), "fonts/mbk_font.ttf");
        }
        return f6910a;
    }

    public static void P0(ByteArrayOutputStream byteArrayOutputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) ((j >> (i2 * 8)) & 255));
        }
        byteArrayOutputStream.write(bArr);
    }

    public static final Class Q(C1198jh jhVar) {
        C1177ig.f(jhVar, "<this>");
        Class<?> a2 = ((C1274n5) jhVar).a();
        if (!a2.isPrimitive()) {
            return a2;
        }
        String name = a2.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                    return a2;
                }
                return Double.class;
            case 104431:
                if (!name.equals("int")) {
                    return a2;
                }
                return Integer.class;
            case 3039496:
                if (!name.equals("byte")) {
                    return a2;
                }
                return Byte.class;
            case 3052374:
                if (!name.equals("char")) {
                    return a2;
                }
                return Character.class;
            case 3327612:
                if (!name.equals("long")) {
                    return a2;
                }
                return Long.class;
            case 3625364:
                if (!name.equals("void")) {
                    return a2;
                }
                return Void.class;
            case 64711720:
                if (!name.equals("boolean")) {
                    return a2;
                }
                return Boolean.class;
            case 97526364:
                if (!name.equals("float")) {
                    return a2;
                }
                return Float.class;
            case 109413500:
                if (!name.equals("short")) {
                    return a2;
                }
                return Short.class;
            default:
                return a2;
        }
    }

    public static void Q0(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        P0(byteArrayOutputStream, (long) i, 2);
    }

    public static String R(Class cls) {
        return "[" + cls.getSimpleName() + "]";
    }

    public static C0301pz S(ByteArrayInputStream byteArrayInputStream) {
        byte[] bArr;
        String str;
        if (byteArrayInputStream.available() >= 2) {
            byteArrayInputStream.mark(0);
            int read = byteArrayInputStream.read();
            while (true) {
                byte b2 = (byte) read;
                if (read == -1 || !(b2 == -1 || b2 == 0)) {
                    byteArrayInputStream.reset();
                } else {
                    byteArrayInputStream.mark(0);
                    read = byteArrayInputStream.read();
                }
            }
            byteArrayInputStream.reset();
            if (byteArrayInputStream.available() >= 2) {
                byte[] n0 = n0(byteArrayInputStream);
                byteArrayInputStream.mark(0);
                int available = byteArrayInputStream.available();
                int o0 = o0(byteArrayInputStream);
                int available2 = byteArrayInputStream.available();
                byteArrayInputStream.reset();
                int i = available - available2;
                byte[] bArr2 = new byte[i];
                if (i < 1 || i > 4) {
                    throw new C0155cA(lf.h("Number of length bytes must be from 1 to 4. Found ", i));
                }
                byteArrayInputStream.read(bArr2, 0, i);
                if (i <= 0 || i > 4) {
                    throw new IllegalArgumentException(lf.h("Length must be between 1 and 4. Length = ", i));
                } else if (i >= i + 0) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        i2 += (bArr2[0 + i3] & UnsignedBytes.MAX_VALUE) << (((i - i3) - 1) * 8);
                    }
                    mf v0 = v0(n0);
                    if (i2 == 128) {
                        byteArrayInputStream.mark(0);
                        int i4 = 0;
                        int i5 = 1;
                        while (true) {
                            i4++;
                            int read2 = byteArrayInputStream.read();
                            if (read2 >= 0) {
                                if (i5 == 0 && read2 == 0) {
                                    o0 = i4 - 2;
                                    bArr = new byte[o0];
                                    byteArrayInputStream.reset();
                                    byteArrayInputStream.read(bArr, 0, o0);
                                    break;
                                }
                                i5 = read2;
                            } else {
                                throw new C0155cA("Error parsing data. TLV length byte indicated indefinite length, but EOS was reached before 0x0000 was found" + byteArrayInputStream.available());
                            }
                        }
                    } else if (byteArrayInputStream.available() < o0) {
                        StringBuilder m = lf.m("Length byte(s) indicated ", o0, " value bytes, but only ");
                        m.append(byteArrayInputStream.available());
                        m.append(" ");
                        if (byteArrayInputStream.available() > 1) {
                            str = "are";
                        } else {
                            str = "is";
                        }
                        throw new C0155cA(C0709Uj.j(m, str, " available"));
                    } else {
                        bArr = new byte[o0];
                        byteArrayInputStream.read(bArr, 0, o0);
                    }
                    byteArrayInputStream.mark(0);
                    int read3 = byteArrayInputStream.read();
                    while (true) {
                        byte b3 = (byte) read3;
                        if (read3 == -1 || !(b3 == -1 || b3 == 0)) {
                            byteArrayInputStream.reset();
                        } else {
                            byteArrayInputStream.mark(0);
                            read3 = byteArrayInputStream.read();
                        }
                    }
                    byteArrayInputStream.reset();
                    return new C0301pz(v0, o0, bArr);
                } else {
                    throw new IllegalArgumentException("Length or startPos not valid");
                }
            } else {
                throw new C0155cA("Error parsing data. Available bytes < 2 . Length=" + byteArrayInputStream.available());
            }
        } else {
            throw new C0155cA("Error parsing data. Available bytes < 2 . Length=" + byteArrayInputStream.available());
        }
    }

    public static final Pv T(Object obj) {
        if (obj != r1.f3215c) {
            return (Pv) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static synchronized String U(Bundle bundle) {
        String stringBuffer;
        synchronized (C1354qp.class) {
            try {
                synchronized (C1354qp.class) {
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                boolean z = true;
                for (String next : bundle.keySet()) {
                    if (z) {
                        z = false;
                    } else {
                        stringBuffer2.append("&");
                    }
                    stringBuffer2.append(next);
                    stringBuffer2.append("=");
                    stringBuffer2.append(bundle.getString(next));
                }
                synchronized (C1354qp.class) {
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Exception e2) {
                i0(e2);
                return null;
            }
        }
        return stringBuffer;
    }

    public static synchronized String V(Bundle bundle) {
        String stringBuffer;
        synchronized (C1354qp.class) {
            try {
                synchronized (C1354qp.class) {
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                boolean z = true;
                for (String next : bundle.keySet()) {
                    if (z) {
                        z = false;
                    } else {
                        stringBuffer2.append("&");
                    }
                    stringBuffer2.append(next);
                    stringBuffer2.append("=");
                    stringBuffer2.append(URLEncoder.encode(bundle.getString(next), "UTF-8"));
                }
                synchronized (C1354qp.class) {
                }
                stringBuffer = stringBuffer2.toString();
            } catch (Exception e2) {
                i0(e2);
                return null;
            }
        }
        return stringBuffer;
    }

    public static byte[] W(byte[] bArr, mf... mfVarArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            while (byteArrayInputStream.available() > 0) {
                C0301pz S = S(byteArrayInputStream);
                mf mfVar = S.a;
                boolean B = B(mfVarArr, mfVar);
                byte[] bArr3 = S.f3176a;
                if (!B) {
                    if (mfVar.a() && (bArr2 = W(bArr3, mfVarArr)) != null) {
                        break;
                    }
                } else {
                    return bArr3;
                }
            }
        }
        return bArr2;
    }

    public static ArrayList X(byte[] bArr, mf... mfVarArr) {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (byteArrayInputStream.available() > 0) {
            C0301pz S = S(byteArrayInputStream);
            mf mfVar = S.a;
            if (B(mfVarArr, mfVar)) {
                arrayList.add(S);
            } else if (mfVar.a()) {
                arrayList.addAll(X(S.f3176a, mfVarArr));
            }
        }
        return arrayList;
    }

    public static final void Y(CoroutineContext coroutineContext, Throwable th) {
        Throwable th2;
        for (C1364r7 n : C1381s7.a) {
            try {
                n.n(coroutineContext, th);
            } catch (Throwable th3) {
                if (th == th3) {
                    th2 = th;
                } else {
                    th2 = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                    g(th2, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
            }
        }
        try {
            g(th, new C0691T8(coroutineContext));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean Z(Object obj) {
        if (obj == r1.f3215c) {
            return true;
        }
        return false;
    }

    public static synchronized boolean a0(Context context) {
        synchronized (C1354qp.class) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            boolean isConnected = activeNetworkInfo.isConnected();
            return isConnected;
        }
    }

    public static final boolean b0(char c2) {
        if (Character.isWhitespace(c2) || Character.isSpaceChar(c2)) {
            return true;
        }
        return false;
    }

    public static Nx c0(CoroutineScope coroutineScope, Function2 function2) {
        Nx nx = new Nx(C1320p7.b(coroutineScope, C1440va.a), true);
        nx.q0(1, nx, function2);
        return nx;
    }

    public static final C0715Uy d0(Function0 function0) {
        C1177ig.f(function0, "initializer");
        return new C0715Uy(function0);
    }

    public static G0 e0(Ug ug, C0181ej ejVar) throws IOException {
        return new G0(Eh.a(ug, ejVar, 1.0f, r1.a, false), 0);
    }

    public static H0 f0(Tg tg, C0181ej ejVar, boolean z) throws IOException {
        float f2;
        if (z) {
            f2 = UB.c();
        } else {
            f2 = 1.0f;
        }
        return new H0(Eh.a(tg, ejVar, f2, C0097Ic.a, false));
    }

    public static final void g(Throwable th, Throwable th2) {
        C1177ig.f(th, "<this>");
        C1177ig.f(th2, "exception");
        if (th != th2) {
            Bp.a.a(th, th2);
        }
    }

    public static J0 g0(Ug ug, C0181ej ejVar) throws IOException {
        return new J0(Eh.a(ug, ejVar, 1.0f, f6911a, false), 0);
    }

    public static final C0233j7 h(c cVar) {
        return new C0233j7(cVar);
    }

    public static G0 h0(Ug ug, C0181ej ejVar) throws IOException {
        return new G0(Eh.a(ug, ejVar, UB.c(), Gp.a, true), 1);
    }

    public static C0457B8 i(C1085e7 e7Var, Function2 function2) {
        C0457B8 b8 = new C0457B8(C1320p7.b(e7Var, C1440va.a), true);
        b8.q0(1, b8, function2);
        return b8;
    }

    public static synchronized void i0(Exception exc) {
        synchronized (C1354qp.class) {
            exc.printStackTrace();
        }
    }

    public static int j(int i, int i2, int[] iArr) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final void j0(Continuation continuation) {
        C1177ig.f(continuation, "frame");
    }

    public static int k(int i, long j, long[] jArr) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = (jArr[i4] > j ? 1 : (jArr[i4] == j ? 0 : -1));
            if (i5 < 0) {
                i3 = i4 + 1;
            } else if (i5 <= 0) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public static byte[] k0(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static int l(int i) {
        if (i <= 268435455 && i >= 0) {
            return i * 8;
        }
        throw new V5(C1058d.y("Invalid byte length (", i, ") for converting to bit length"));
    }

    public static byte[] l0(int i, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read >= 0) {
                i2 += read;
            } else {
                throw new IllegalStateException(lf.h("Not enough bytes to read: ", i));
            }
        }
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = r3.getClass().getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m(java.lang.StringBuilder r2, androidx.lifecycle.LifecycleOwner r3) {
        /*
            if (r3 != 0) goto L_0x0008
            java.lang.String r3 = "null"
            r2.append(r3)
            goto L_0x003f
        L_0x0008:
            java.lang.Class r0 = r3.getClass()
            java.lang.String r0 = r0.getSimpleName()
            int r1 = r0.length()
            if (r1 > 0) goto L_0x002c
            java.lang.Class r0 = r3.getClass()
            java.lang.String r0 = r0.getName()
            r1 = 46
            int r1 = r0.lastIndexOf(r1)
            if (r1 <= 0) goto L_0x002c
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
        L_0x002c:
            r2.append(r0)
            r0 = 123(0x7b, float:1.72E-43)
            r2.append(r0)
            int r3 = java.lang.System.identityHashCode(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1354qp.m(java.lang.StringBuilder, androidx.lifecycle.LifecycleOwner):void");
    }

    public static byte[] m0(FileInputStream fileInputStream, int i, int i2) throws IOException {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int i4 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int read = fileInputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i4 += inflater.inflate(bArr, i4, i2 - i4);
                    i3 += read;
                } else {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
            }
            if (i3 != i) {
                throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw new IllegalStateException("Inflater did not finish");
            }
        } catch (DataFormatException e2) {
            throw new IllegalStateException(e2.getMessage());
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static final void n(CoroutineContext coroutineContext, CancellationException cancellationException) {
        int i = Job.b;
        Job job = (Job) coroutineContext.b(Job.b.a);
        if (job != null) {
            job.c(cancellationException);
        }
    }

    public static byte[] n0(ByteArrayInputStream byteArrayInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte read = (byte) byteArrayInputStream.read();
        byteArrayOutputStream.write(read);
        if ((read & Ascii.US) == 31) {
            while (true) {
                int read2 = byteArrayInputStream.read();
                if (read2 >= 0) {
                    byte b2 = (byte) read2;
                    byteArrayOutputStream.write(b2);
                    if (!r1.I(b2, 7) || (r1.I(b2, 7) && (b2 & Ascii.DEL) == 0)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Key o(Key key, Class cls) throws C1259mg {
        if (key != null) {
            try {
                return (Key) cls.cast(key);
            } catch (ClassCastException e2) {
                throw new C1259mg("Invalid key " + e2);
            }
        } else {
            throw new C1259mg("The key must not be null.");
        }
    }

    public static int o0(ByteArrayInputStream byteArrayInputStream) {
        int read = byteArrayInputStream.read();
        if (read < 0) {
            throw new C0155cA(lf.h("Negative length: ", read));
        } else if (read <= 127 || read == 128) {
            return read;
        } else {
            int i = read & 127;
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                int read2 = byteArrayInputStream.read();
                if (read2 >= 0) {
                    i2 = (i2 << 8) | read2;
                    i3++;
                } else {
                    throw new C0155cA("EOS when reading length bytes");
                }
            }
            return i2;
        }
    }

    public static void p(String str, byte[] bArr) throws C1259mg {
        if (bArr != null) {
            throw new C1259mg(C0709Uj.i("An explicit content encryption key cannot be used with ", str));
        }
    }

    public static long p0(int i, InputStream inputStream) throws IOException {
        byte[] l0 = l0(i, inputStream);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += ((long) (l0[i2] & UnsignedBytes.MAX_VALUE)) << (i2 * 8);
        }
        return j;
    }

    public static void q(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static int q0(InputStream inputStream) throws IOException {
        return (int) p0(2, inputStream);
    }

    public static void r(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static final Object r0(Object obj) {
        if (obj instanceof C0677S5) {
            return r1.n(((C0677S5) obj).f3789a);
        }
        return obj;
    }

    public static void s(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    public static final void s0(g gVar, Continuation continuation, boolean z) {
        Object obj;
        C1129gB<?> gBVar;
        Object h = gVar.h();
        Throwable d2 = gVar.d(h);
        if (d2 != null) {
            obj = r1.n(d2);
        } else {
            obj = gVar.e(h);
        }
        if (z) {
            C1177ig.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            C1173i9 i9Var = (C1173i9) continuation;
            Continuation<T> continuation2 = i9Var.f5486a;
            CoroutineContext context = continuation2.getContext();
            Object b2 = C0673Rz.b(context, i9Var.b);
            if (b2 != C0673Rz.f3788a) {
                gBVar = C1320p7.c(continuation2, context, b2);
            } else {
                gBVar = null;
            }
            try {
                i9Var.f5486a.resumeWith(obj);
                Unit unit = Unit.a;
            } finally {
                if (gBVar == null || gBVar.r0()) {
                    C0673Rz.a(context, b2);
                }
            }
        } else {
            continuation.resumeWith(obj);
        }
    }

    public static void t(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static byte[] t0(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[(length - 1) - i] = bArr[i];
        }
        return bArr2;
    }

    public static final void u(int i) {
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(lf.h("Expected positive parallelism level, but got ", i).toString());
        }
    }

    public static Object u0(Function2 function2) throws InterruptedException {
        long j;
        C0677S5 s5;
        C1440va vaVar = C1440va.a;
        Thread currentThread = Thread.currentThread();
        C1171i7.a aVar = C1171i7.a.a;
        C0765Za a2 = C0686Sz.a();
        CoroutineContext a3 = C1320p7.a(vaVar, a2, true);
        C1474x8 x8Var = C1213k9.f5544a;
        if (a3 != x8Var && a3.b(aVar) == null) {
            a3 = a3.j(x8Var);
        }
        C0730W2 w2 = new C0730W2(a3, currentThread, a2);
        w2.q0(1, w2, function2);
        C0765Za za = w2.a;
        if (za != null) {
            int i = C0765Za.c;
            za.s(false);
        }
        while (!Thread.interrupted()) {
            try {
                if (za != null) {
                    j = za.u();
                } else {
                    j = Long.MAX_VALUE;
                }
                if (!(!(w2.S() instanceof C0449Af))) {
                    LockSupport.parkNanos(w2, j);
                } else {
                    Object L0 = L0(w2.S());
                    if (L0 instanceof C0677S5) {
                        s5 = (C0677S5) L0;
                    } else {
                        s5 = null;
                    }
                    if (s5 == null) {
                        return L0;
                    }
                    throw s5.f3789a;
                }
            } finally {
                if (za != null) {
                    int i2 = C0765Za.c;
                    za.r(false);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        w2.w(interruptedException);
        throw interruptedException;
    }

    public static void v(Key key) throws C1259mg {
        int bitLength;
        if (key == null) {
            throw new C1259mg("The RSA key must not be null.");
        } else if ((key instanceof RSAKey) && (bitLength = ((RSAKey) key).getModulus().bitLength()) < 2048) {
            throw new C1259mg(C1058d.y("An RSA key of size 2048 bits or larger MUST be used with the all JOSE RSA algorithms (given key was only ", bitLength, " bits)."));
        }
    }

    public static mf v0(byte[] bArr) {
        LinkedHashMap<u3, mf> linkedHashMap = Ba.a;
        bArr.getClass();
        mf mfVar = linkedHashMap.get(new u3(bArr));
        if (mfVar == null) {
            return new tz(bArr, 1, "[UNKNOWN TAG]");
        }
        return mfVar;
    }

    public static float w(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        if (f2 > f4) {
            return f4;
        }
        return f2;
    }

    public static String w0(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str == null) {
                str = "";
            }
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static int x(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        if (i > i3) {
            return i3;
        }
        return i;
    }

    public static final void x0(View view, Xu xu) {
        C1177ig.f(view, "<this>");
        view.setTag(Ar.view_tree_saved_state_registry_owner, xu);
    }

    public static final void y(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            g(th, th2);
        }
    }

    public static final Object y0(C1266mv mvVar, C1266mv mvVar2, Function2 function2) {
        Object obj;
        Object a0;
        try {
            C0648QA.a(2, function2);
            obj = function2.invoke(mvVar2, mvVar);
        } catch (Throwable th) {
            obj = new C0677S5(false, th);
        }
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        if (obj == v7Var || (a0 = mvVar.a0(obj)) == f6922b) {
            return v7Var;
        }
        if (!(a0 instanceof C0677S5)) {
            return L0(a0);
        }
        throw ((C0677S5) a0).f3789a;
    }

    public static byte[] z(byte[] bArr) throws IOException {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
        throw th;
    }

    public static byte[] z0(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public WebViewProviderBoundaryInterface a(WebView webView) {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    public String[] c() {
        return f6921a;
    }

    public Object d(Tg tg, float f2) throws IOException {
        return Integer.valueOf(Math.round(Wg.d(tg) * f2));
    }

    public StaticsBoundaryInterface e() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    public DropDataContentProviderBoundaryInterface f() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    public /* synthetic */ C1354qp(Configuration configuration) {
        C1177ig.f(configuration, "newConfig");
    }

    public Object b(CorruptionException corruptionException) throws CorruptionException {
        throw corruptionException;
    }
}
