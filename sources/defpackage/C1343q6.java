package defpackage;

import com.google.android.gms.ads.AdRequest;
import com.google.common.base.Ascii;

/* renamed from: q6  reason: default package and case insensitive filesystem */
/* compiled from: ConcatKeyDerivationFunctionFactory */
public final class C1343q6 {
    public static final Bi a;

    /* renamed from: a  reason: collision with other field name */
    public static final Class<C1363r6> f6895a;

    static {
        Bi d = C0473Ci.d(C1343q6.class);
        a = d;
        String property = System.getProperty("org.jose4j.jwe.kdf.ConcatenationKeyDerivationFunctionWithSha256");
        if (property != null) {
            try {
                Class<?> cls = Class.forName(property);
                f6895a = cls;
                C1363r6 r6Var = (C1363r6) cls.newInstance();
                r6Var.a(new byte[]{124, -81, 43, Ascii.SO, -71, -72, -84, 75, 115, 73, -52, -39, 74, -58, 77, -83}, AdRequest.MAX_CONTENT_URL_LENGTH, new byte[8]);
                d.b("Using custom ConcatenationKeyDerivationFunctionWithSha256 implementation: " + r6Var.getClass());
            } catch (Throwable th) {
                f6895a = null;
                a.f("Using jose4j's concatenation key derivation function implementation because of problems with ".concat(property), th);
            }
        }
    }
}
