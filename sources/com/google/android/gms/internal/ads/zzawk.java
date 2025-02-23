package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawk extends zzaxd {
    private final Map zzh;
    private final View zzi;
    private final Context zzj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzawk(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, Map map, View view, Context context) {
        super(zzavp, "SKSJAjN3UKeguXyEasCGg04d/yJuUN8XZYgactMp4rfMtHcIJcD0mydl5RKvI49M", "lnMUlT0qopStslq/RfZHkyvg0xAUTVuMPsMot4SEaYA=", zzaro, i, 85);
        this.zzh = map;
        this.zzi = view;
        this.zzj = context;
    }

    private final long zzc(int i) {
        Map map = this.zzh;
        Integer valueOf = Integer.valueOf(i);
        if (map.containsKey(valueOf)) {
            return ((Long) this.zzh.get(valueOf)).longValue();
        }
        return Long.MIN_VALUE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r10 = this;
            r0 = 2
            long[] r1 = new long[r0]
            r2 = 1
            long r3 = r10.zzc(r2)
            r5 = 0
            r1[r5] = r3
            long r3 = r10.zzc(r0)
            r1[r2] = r3
            android.content.Context r3 = r10.zzj
            if (r3 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzavp r3 = r10.zza
            android.content.Context r3 = r3.zzb()
        L_0x001b:
            java.lang.reflect.Method r4 = r10.zze
            r6 = 3
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r5] = r1
            r7[r2] = r3
            android.view.View r1 = r10.zzi
            r7[r0] = r1
            r1 = 0
            java.lang.Object r1 = r4.invoke(r1, r7)
            long[] r1 = (long[]) r1
            r3 = r1[r5]
            java.util.Map r5 = r10.zzh
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            r8 = r1[r2]
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r5.put(r7, r2)
            r7 = r1[r0]
            java.util.Map r2 = r10.zzh
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5 = r1[r6]
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            r2.put(r0, r1)
            com.google.android.gms.internal.ads.zzaro r0 = r10.zzd
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaro r1 = r10.zzd     // Catch:{ all -> 0x0060 }
            r1.zzv(r3)     // Catch:{ all -> 0x0060 }
            com.google.android.gms.internal.ads.zzaro r1 = r10.zzd     // Catch:{ all -> 0x0060 }
            r1.zzu(r7)     // Catch:{ all -> 0x0060 }
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0060:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawk.zza():void");
    }
}
