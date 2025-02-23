package defpackage;

import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Set;

/* renamed from: nu  reason: default package and case insensitive filesystem */
/* compiled from: RsaUsingShaAlgorithm */
public class C1290nu extends A2 {

    /* renamed from: nu$a */
    /* compiled from: RsaUsingShaAlgorithm */
    public static class a extends C1290nu {
        public a() {
            super("PS256", C1290nu.n("SHA256withRSAandMGF1"));
            if (this.b.equals("RSASSA-PSS")) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
                this.a = new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 32, 1);
            }
        }
    }

    /* renamed from: nu$b */
    /* compiled from: RsaUsingShaAlgorithm */
    public static class b extends C1290nu {
        public b() {
            super("PS384", C1290nu.n("SHA384withRSAandMGF1"));
            if (this.b.equals("RSASSA-PSS")) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA384;
                this.a = new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 48, 1);
            }
        }
    }

    /* renamed from: nu$c */
    /* compiled from: RsaUsingShaAlgorithm */
    public static class c extends C1290nu {
        public c() {
            super("PS512", C1290nu.n("SHA512withRSAandMGF1"));
            if (this.b.equals("RSASSA-PSS")) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA512;
                this.a = new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 64, 1);
            }
        }
    }

    /* renamed from: nu$d */
    /* compiled from: RsaUsingShaAlgorithm */
    public static class d extends C1290nu {
        public d() {
            super("RS256", "SHA256withRSA");
        }
    }

    /* renamed from: nu$e */
    /* compiled from: RsaUsingShaAlgorithm */
    public static class e extends C1290nu {
        public e() {
            super("RS384", "SHA384withRSA");
        }
    }

    /* renamed from: nu$f */
    /* compiled from: RsaUsingShaAlgorithm */
    public static class f extends C1290nu {
        public f() {
            super("RS512", "SHA512withRSA");
        }
    }

    public C1290nu(String str, String str2) {
        super(str, str2);
    }

    public static String n(String str) {
        Set<String> algorithms = Security.getAlgorithms("Signature");
        boolean z = Boolean.getBoolean("org.jose4j.jws.use-legacy-rsapss-alg-names");
        if (!algorithms.contains("RSASSA-PSS") || z) {
            return str;
        }
        return "RSASSA-PSS";
    }

    public final void m(PrivateKey privateKey) throws C1259mg {
        C1354qp.v(privateKey);
    }
}
