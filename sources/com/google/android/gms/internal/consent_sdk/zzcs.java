package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzcs {
    private static Boolean zza;

    private zzcs() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(android.webkit.WebView r3, java.lang.String r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.consent_sdk.zzcs> r0 = com.google.android.gms.internal.consent_sdk.zzcs.class
            monitor-enter(r0)
            java.lang.Boolean r1 = zza     // Catch:{ all -> 0x002d }
            r2 = 0
            if (r1 != 0) goto L_0x0016
            java.lang.String r1 = "(function(){})()"
            r3.evaluateJavascript(r1, r2)     // Catch:{ IllegalStateException -> 0x0012 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ IllegalStateException -> 0x0012 }
            zza = r1     // Catch:{ IllegalStateException -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x002d }
            zza = r1     // Catch:{ all -> 0x002d }
        L_0x0016:
            java.lang.Boolean r1 = zza     // Catch:{ all -> 0x002d }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0023
            r3.evaluateJavascript(r4, r2)
            return
        L_0x0023:
            java.lang.String r0 = "javascript:"
            java.lang.String r4 = r0.concat(r4)
            r3.loadUrl(r4)
            return
        L_0x002d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzcs.zza(android.webkit.WebView, java.lang.String):void");
    }
}
