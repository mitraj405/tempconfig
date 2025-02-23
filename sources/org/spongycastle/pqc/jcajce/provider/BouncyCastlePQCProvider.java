package org.spongycastle.pqc.jcajce.provider;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class BouncyCastlePQCProvider extends Provider implements ConfigurableProvider {
    public static final HashMap a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f6806a = {"Rainbow", "McEliece", "SPHINCS", "NH", "XMSS"};

    public BouncyCastlePQCProvider() {
        super("BCPQC", 1.58d, "BouncyCastle Post-Quantum Security Provider v1.58");
        AccessController.doPrivileged(new PrivilegedAction() {
            public final Object run() {
                HashMap hashMap = BouncyCastlePQCProvider.a;
                BouncyCastlePQCProvider bouncyCastlePQCProvider = BouncyCastlePQCProvider.this;
                bouncyCastlePQCProvider.getClass();
                int i = 0;
                while (true) {
                    String[] strArr = BouncyCastlePQCProvider.f6806a;
                    Class<?> cls = null;
                    if (i == strArr.length) {
                        return null;
                    }
                    Class<BouncyCastlePQCProvider> cls2 = BouncyCastlePQCProvider.class;
                    String j = C0709Uj.j(new StringBuilder("org.spongycastle.pqc.jcajce.provider."), strArr[i], "$Mappings");
                    try {
                        ClassLoader classLoader = cls2.getClassLoader();
                        if (classLoader != null) {
                            cls = classLoader.loadClass(j);
                        } else {
                            cls = (Class) AccessController.doPrivileged(new PrivilegedAction(j) {
                                public final /* synthetic */ String a;

                                {
                                    this.a = r1;
                                }

                                public final Object run() {
                                    try {
                                        return Class.forName(this.a);
                                    } catch (Exception unused) {
                                        return null;
                                    }
                                }
                            });
                        }
                    } catch (ClassNotFoundException unused) {
                    }
                    if (cls != null) {
                        try {
                            ((AlgorithmProvider) cls.newInstance()).a(bouncyCastlePQCProvider);
                        } catch (Exception e) {
                            throw new InternalError("cannot create instance of org.spongycastle.pqc.jcajce.provider." + strArr[i] + "$Mappings : " + e);
                        }
                    }
                    i++;
                }
            }
        });
    }

    public final void a(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        HashMap hashMap = a;
        synchronized (hashMap) {
            hashMap.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }

    public final void b(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException(lf.j("duplicate provider key (", str, ") found"));
    }

    public final void c(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        if (containsKey(str + "." + str2)) {
            b(str + "." + aSN1ObjectIdentifier, str2);
            b(str + ".OID." + aSN1ObjectIdentifier, str2);
            return;
        }
        throw new IllegalStateException(C1058d.A("primary key (", str, ".", str2, ") not found"));
    }

    public final boolean d(String str) {
        if (containsKey("MessageDigest.".concat(str)) || containsKey("Alg.Alias.MessageDigest.".concat(str))) {
            return true;
        }
        return false;
    }

    public final void e(String str, HashMap hashMap) {
        for (String str2 : hashMap.keySet()) {
            String D = xx.D(str, " ", str2);
            if (!containsKey(D)) {
                put(D, hashMap.get(str2));
            } else {
                throw new IllegalStateException(lf.j("duplicate provider attribute key (", D, ") found"));
            }
        }
    }
}
