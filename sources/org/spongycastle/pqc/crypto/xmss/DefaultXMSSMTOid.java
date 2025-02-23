package org.spongycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DefaultXMSSMTOid implements XMSSOid {
    public static final Map<String, DefaultXMSSMTOid> a;

    /* renamed from: a  reason: collision with other field name */
    public final String f6757a;

    static {
        HashMap hashMap = new HashMap();
        xx.R("XMSSMT_SHA2-256_W16_H20_D2", hashMap, a("SHA-256", 32, 16, 67, 20, 2));
        xx.R("XMSSMT_SHA2-256_W16_H20_D4", hashMap, a("SHA-256", 32, 16, 67, 20, 4));
        xx.R("XMSSMT_SHA2-256_W16_H40_D2", hashMap, a("SHA-256", 32, 16, 67, 40, 2));
        xx.R("XMSSMT_SHA2-256_W16_H40_D4", hashMap, a("SHA-256", 32, 16, 67, 40, 2));
        xx.R("XMSSMT_SHA2-256_W16_H40_D8", hashMap, a("SHA-256", 32, 16, 67, 40, 4));
        xx.R("XMSSMT_SHA2-256_W16_H60_D3", hashMap, a("SHA-256", 32, 16, 67, 60, 8));
        xx.R("XMSSMT_SHA2-256_W16_H60_D6", hashMap, a("SHA-256", 32, 16, 67, 60, 6));
        xx.R("XMSSMT_SHA2-256_W16_H60_D12", hashMap, a("SHA-256", 32, 16, 67, 60, 12));
        xx.R("XMSSMT_SHA2-512_W16_H20_D2", hashMap, a("SHA2-512", 64, 16, 131, 20, 2));
        xx.R("XMSSMT_SHA2-512_W16_H20_D4", hashMap, a("SHA2-512", 64, 16, 131, 20, 4));
        xx.R("XMSSMT_SHA2-512_W16_H40_D2", hashMap, a("SHA2-512", 64, 16, 131, 40, 2));
        xx.R("XMSSMT_SHA2-512_W16_H40_D4", hashMap, a("SHA2-512", 64, 16, 131, 40, 4));
        xx.R("XMSSMT_SHA2-512_W16_H40_D8", hashMap, a("SHA2-512", 64, 16, 131, 40, 8));
        xx.R("XMSSMT_SHA2-512_W16_H60_D3", hashMap, a("SHA2-512", 64, 16, 131, 60, 3));
        xx.R("XMSSMT_SHA2-512_W16_H60_D6", hashMap, a("SHA2-512", 64, 16, 131, 60, 6));
        xx.R("XMSSMT_SHA2-512_W16_H60_D12", hashMap, a("SHA2-512", 64, 16, 131, 60, 12));
        xx.R("XMSSMT_SHAKE128_W16_H20_D2", hashMap, a("SHAKE128", 32, 16, 67, 20, 2));
        xx.R("XMSSMT_SHAKE128_W16_H20_D4", hashMap, a("SHAKE128", 32, 16, 67, 20, 4));
        xx.R("XMSSMT_SHAKE128_W16_H40_D2", hashMap, a("SHAKE128", 32, 16, 67, 40, 2));
        xx.R("XMSSMT_SHAKE128_W16_H40_D4", hashMap, a("SHAKE128", 32, 16, 67, 40, 4));
        xx.R("XMSSMT_SHAKE128_W16_H40_D8", hashMap, a("SHAKE128", 32, 16, 67, 40, 8));
        xx.R("XMSSMT_SHAKE128_W16_H60_D3", hashMap, a("SHAKE128", 32, 16, 67, 60, 3));
        xx.R("XMSSMT_SHAKE128_W16_H60_D6", hashMap, a("SHAKE128", 32, 16, 67, 60, 6));
        xx.R("XMSSMT_SHAKE128_W16_H60_D12", hashMap, a("SHAKE128", 32, 16, 67, 60, 12));
        xx.R("XMSSMT_SHAKE256_W16_H20_D2", hashMap, a("SHAKE256", 64, 16, 131, 20, 2));
        xx.R("XMSSMT_SHAKE256_W16_H20_D4", hashMap, a("SHAKE256", 64, 16, 131, 20, 4));
        xx.R("XMSSMT_SHAKE256_W16_H40_D2", hashMap, a("SHAKE256", 64, 16, 131, 40, 2));
        xx.R("XMSSMT_SHAKE256_W16_H40_D4", hashMap, a("SHAKE256", 64, 16, 131, 40, 4));
        xx.R("XMSSMT_SHAKE256_W16_H40_D8", hashMap, a("SHAKE256", 64, 16, 131, 40, 8));
        xx.R("XMSSMT_SHAKE256_W16_H60_D3", hashMap, a("SHAKE256", 64, 16, 131, 60, 3));
        xx.R("XMSSMT_SHAKE256_W16_H60_D6", hashMap, a("SHAKE256", 64, 16, 131, 60, 6));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 12), new DefaultXMSSMTOid("XMSSMT_SHAKE256_W16_H60_D12"));
        a = Collections.unmodifiableMap(hashMap);
    }

    public DefaultXMSSMTOid(String str) {
        this.f6757a = str;
    }

    public static String a(String str, int i, int i2, int i3, int i4, int i5) {
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4 + "-" + i5;
    }

    public final String toString() {
        return this.f6757a;
    }
}
