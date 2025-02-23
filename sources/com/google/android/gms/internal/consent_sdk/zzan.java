package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzan implements zzd {
    private final Application zza;
    private final zzap zzb;
    private final Executor zzc;

    public zzan(Application application, zzap zzap, Executor executor) {
        this.zza = application;
        this.zzb = zzap;
        this.zzc = executor;
    }

    public final Executor zza() {
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(java.lang.String r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 94746189(0x5a5b64d, float:1.5583492E-35)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 113399775(0x6c257df, float:7.3103804E-35)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "write"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "clear"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0025
            r6 = r3
            goto L_0x0026
        L_0x0025:
            r6 = -1
        L_0x0026:
            if (r6 == 0) goto L_0x006a
            if (r6 == r3) goto L_0x002b
            return r2
        L_0x002b:
            java.lang.String r6 = "keys"
            org.json.JSONArray r6 = r7.optJSONArray(r6)
            if (r6 == 0) goto L_0x005c
            int r0 = r6.length()
            if (r0 != 0) goto L_0x003a
            goto L_0x005c
        L_0x003a:
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            int r0 = r6.length()
        L_0x0043:
            if (r2 >= r0) goto L_0x0056
            java.lang.String r1 = r6.optString(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x0050
            goto L_0x0053
        L_0x0050:
            r7.add(r1)
        L_0x0053:
            int r2 = r2 + 1
            goto L_0x0043
        L_0x0056:
            android.app.Application r6 = r5.zza
            com.google.android.gms.internal.consent_sdk.zzco.zzb(r6, r7)
            goto L_0x0069
        L_0x005c:
            java.lang.String r6 = r7.toString()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "Action[clear]: wrong args."
            r7.concat(r6)
        L_0x0069:
            return r3
        L_0x006a:
            android.app.Application r6 = r5.zza
            com.google.android.gms.internal.consent_sdk.zzcn r0 = new com.google.android.gms.internal.consent_sdk.zzcn
            r0.<init>(r6)
            java.util.Iterator r6 = r7.keys()
        L_0x0075:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x00a2
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.opt(r1)
            java.lang.String.valueOf(r2)
            boolean r2 = r0.zzc(r1, r2)
            if (r2 == 0) goto L_0x0098
            com.google.android.gms.internal.consent_sdk.zzap r2 = r5.zzb
            java.util.Set r2 = r2.zzd()
            r2.add(r1)
            goto L_0x0075
        L_0x0098:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Failed writing key: "
            r2.concat(r1)
            goto L_0x0075
        L_0x00a2:
            com.google.android.gms.internal.consent_sdk.zzap r6 = r5.zzb
            r6.zzf()
            r0.zzb()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzan.zzb(java.lang.String, org.json.JSONObject):boolean");
    }
}
