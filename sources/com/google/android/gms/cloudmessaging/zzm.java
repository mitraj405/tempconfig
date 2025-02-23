package com.google.android.gms.cloudmessaging;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
public final /* synthetic */ class zzm implements Handler.Callback {
    public final /* synthetic */ zzp zza;

    public /* synthetic */ zzm(zzp zzp) {
        this.zza = zzp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        r2.zzc(new com.google.android.gms.cloudmessaging.zzt(4, "Not supported by GmsCore", (java.lang.Throwable) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r2.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r5 = r5.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            java.lang.String r0 = "MessengerIpcClient"
            int r1 = r5.arg1
            r2 = 3
            android.util.Log.isLoggable(r0, r2)
            com.google.android.gms.cloudmessaging.zzp r0 = r4.zza
            monitor-enter(r0)
            android.util.SparseArray r2 = r0.zze     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003f }
            com.google.android.gms.cloudmessaging.zzs r2 = (com.google.android.gms.cloudmessaging.zzs) r2     // Catch:{ all -> 0x003f }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0017:
            android.util.SparseArray r3 = r0.zze     // Catch:{ all -> 0x003f }
            r3.remove(r1)     // Catch:{ all -> 0x003f }
            r0.zzf()     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x003a
            java.lang.String r5 = "Not supported by GmsCore"
            com.google.android.gms.cloudmessaging.zzt r0 = new com.google.android.gms.cloudmessaging.zzt
            r1 = 4
            r3 = 0
            r0.<init>(r1, r5, r3)
            r2.zzc(r0)
            goto L_0x003d
        L_0x003a:
            r2.zza(r5)
        L_0x003d:
            r5 = 1
            return r5
        L_0x003f:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzm.handleMessage(android.os.Message):boolean");
    }
}
