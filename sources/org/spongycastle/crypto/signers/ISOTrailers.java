package org.spongycastle.crypto.signers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ISOTrailers {
    public static final Map<String, Integer> a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("RIPEMD128", 13004);
        hashMap.put("RIPEMD160", 12748);
        hashMap.put("SHA-1", 13260);
        hashMap.put("SHA-224", 14540);
        hashMap.put("SHA-256", 13516);
        hashMap.put("SHA-384", 14028);
        hashMap.put("SHA-512", 13772);
        hashMap.put("SHA-512/224", 14796);
        hashMap.put("SHA-512/256", 16588);
        hashMap.put("Whirlpool", 14284);
        a = Collections.unmodifiableMap(hashMap);
    }
}
