package org.spongycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;

public class Properties {
    public static final ThreadLocal a = new ThreadLocal();

    private Properties() {
    }

    public static String a(final String str) {
        return (String) AccessController.doPrivileged(new PrivilegedAction() {
            public final Object run() {
                Map map = (Map) Properties.a.get();
                String str = str;
                if (map != null) {
                    return map.get(str);
                }
                return System.getProperty(str);
            }
        });
    }

    public static boolean b(String str) {
        try {
            String a2 = a(str);
            if (a2 != null) {
                return "true".equals(Strings.e(a2));
            }
            return false;
        } catch (AccessControlException unused) {
            return false;
        }
    }
}
