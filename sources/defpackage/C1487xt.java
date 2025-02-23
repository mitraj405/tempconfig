package defpackage;

import java.util.TreeMap;

/* renamed from: xt  reason: default package and case insensitive filesystem */
/* compiled from: RequestCreator */
public final class C1487xt {
    public static C1487xt a;

    public static TreeMap a(String str, String str2, String str3, String str4) {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put("PHONE", str);
            treeMap.put("MID", str2);
            treeMap.put("SCOPE", "paytm,txn");
            treeMap.put("RESPONSE_TYPE", "token");
            treeMap.put("OTP_DELIVERY_METHOD", str4);
            treeMap.put("USER_TYPE", "01");
            treeMap.put("CHECKSUM", str3);
        } catch (Exception unused) {
        }
        return treeMap;
    }

    public static C1487xt b() {
        if (a == null) {
            a = new C1487xt();
        }
        return a;
    }
}
