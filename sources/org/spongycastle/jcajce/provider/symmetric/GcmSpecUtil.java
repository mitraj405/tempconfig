package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.jcajce.provider.symmetric.util.ClassUtil;

class GcmSpecUtil {
    public static final Class a = ClassUtil.a(GcmSpecUtil.class, "javax.crypto.spec.GCMParameterSpec");

    public static GCMParameters a(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        try {
            Class cls = a;
            return new GCMParameters((byte[]) cls.getDeclaredMethod("getIV", new Class[0]).invoke(algorithmParameterSpec, new Object[0]), ((Integer) cls.getDeclaredMethod("getTLen", new Class[0]).invoke(algorithmParameterSpec, new Object[0])).intValue() / 8);
        } catch (Exception unused) {
            throw new InvalidParameterSpecException("Cannot process GCMParameterSpec");
        }
    }

    public static AlgorithmParameterSpec b(DERSequence dERSequence) throws InvalidParameterSpecException {
        try {
            GCMParameters g = GCMParameters.g(dERSequence);
            return (AlgorithmParameterSpec) a.getConstructor(new Class[]{Integer.TYPE, byte[].class}).newInstance(new Object[]{Integer.valueOf(g.c * 8), g.h()});
        } catch (NoSuchMethodException unused) {
            throw new InvalidParameterSpecException("No constructor found!");
        } catch (Exception e) {
            throw new InvalidParameterSpecException(C1058d.M(e, new StringBuilder("Construction failed: ")));
        }
    }

    public static boolean c(AlgorithmParameterSpec algorithmParameterSpec) {
        Class cls = a;
        if (cls == null || !cls.isInstance(algorithmParameterSpec)) {
            return false;
        }
        return true;
    }
}
