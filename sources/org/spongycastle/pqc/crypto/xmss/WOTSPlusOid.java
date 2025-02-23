package org.spongycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class WOTSPlusOid implements XMSSOid {
    public static final Map<String, WOTSPlusOid> a;

    /* renamed from: a  reason: collision with other field name */
    public final String f6762a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a(32, 67, "SHA-256"), new WOTSPlusOid("WOTSP_SHA2-256_W16"));
        hashMap.put(a(64, 131, "SHA-512"), new WOTSPlusOid("WOTSP_SHA2-512_W16"));
        hashMap.put(a(32, 67, "SHAKE128"), new WOTSPlusOid("WOTSP_SHAKE128_W16"));
        hashMap.put(a(64, 131, "SHAKE256"), new WOTSPlusOid("WOTSP_SHAKE256_W16"));
        a = Collections.unmodifiableMap(hashMap);
    }

    public WOTSPlusOid(String str) {
        this.f6762a = str;
    }

    public static String a(int i, int i2, String str) {
        return str + "-" + i + "-16-" + i2;
    }

    public final String toString() {
        return this.f6762a;
    }
}
