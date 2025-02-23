package org.spongycastle.jcajce.util;

import org.spongycastle.jce.provider.BouncyCastleProvider;

public class BCJcaJceHelper extends ProviderJcaJceHelper {
    public static volatile BouncyCastleProvider a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BCJcaJceHelper() {
        /*
            r2 = this;
            java.lang.String r0 = "SC"
            java.security.Provider r1 = java.security.Security.getProvider(r0)
            if (r1 == 0) goto L_0x000d
            java.security.Provider r0 = java.security.Security.getProvider(r0)
            goto L_0x001d
        L_0x000d:
            org.spongycastle.jce.provider.BouncyCastleProvider r0 = a
            if (r0 == 0) goto L_0x0014
            org.spongycastle.jce.provider.BouncyCastleProvider r0 = a
            goto L_0x001d
        L_0x0014:
            org.spongycastle.jce.provider.BouncyCastleProvider r0 = new org.spongycastle.jce.provider.BouncyCastleProvider
            r0.<init>()
            a = r0
            org.spongycastle.jce.provider.BouncyCastleProvider r0 = a
        L_0x001d:
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.util.BCJcaJceHelper.<init>():void");
    }
}
