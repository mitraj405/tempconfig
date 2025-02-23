package org.spongycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DefaultXMSSOid implements XMSSOid {
    public static final Map<String, DefaultXMSSOid> a;

    /* renamed from: a  reason: collision with other field name */
    public final String f6758a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a("SHA-256", 32, 16, 67, 10), new DefaultXMSSOid("XMSS_SHA2-256_W16_H10"));
        hashMap.put(a("SHA-256", 32, 16, 67, 16), new DefaultXMSSOid("XMSS_SHA2-256_W16_H16"));
        hashMap.put(a("SHA-256", 32, 16, 67, 20), new DefaultXMSSOid("XMSS_SHA2-256_W16_H20"));
        hashMap.put(a("SHA-512", 64, 16, 131, 10), new DefaultXMSSOid("XMSS_SHA2-512_W16_H10"));
        hashMap.put(a("SHA-512", 64, 16, 131, 16), new DefaultXMSSOid("XMSS_SHA2-512_W16_H16"));
        hashMap.put(a("SHA-512", 64, 16, 131, 20), new DefaultXMSSOid("XMSS_SHA2-512_W16_H20"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 10), new DefaultXMSSOid("XMSS_SHAKE128_W16_H10"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 16), new DefaultXMSSOid("XMSS_SHAKE128_W16_H16"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 20), new DefaultXMSSOid("XMSS_SHAKE128_W16_H20"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 10), new DefaultXMSSOid("XMSS_SHAKE256_W16_H10"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 16), new DefaultXMSSOid("XMSS_SHAKE256_W16_H16"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 20), new DefaultXMSSOid("XMSS_SHAKE256_W16_H20"));
        a = Collections.unmodifiableMap(hashMap);
    }

    public DefaultXMSSOid(String str) {
        this.f6758a = str;
    }

    public static String a(String str, int i, int i2, int i3, int i4) {
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4;
    }

    public final String toString() {
        return this.f6758a;
    }
}
