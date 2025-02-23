package com.google.android.gms.cloudmessaging;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
public final /* synthetic */ class zzj implements Runnable {
    public final /* synthetic */ zzp zza;

    public /* synthetic */ zzj(zzp zzp) {
        this.zza = zzp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        "Sending ".concat(java.lang.String.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        r3 = r0.zzf;
        r4 = r0.zzb;
        r5 = r1.zzc;
        r3 = r3.zzb;
        r6 = android.os.Message.obtain();
        r6.what = r5;
        r6.arg1 = r1.zza;
        r6.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zzb());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r1.zzd);
        r6.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.zzc.zza(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
        r0.zza(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
        L_0x0000:
            com.google.android.gms.cloudmessaging.zzp r0 = r8.zza
            monitor-enter(r0)
            int r1 = r0.zza     // Catch:{ all -> 0x0093 }
            r2 = 2
            if (r1 == r2) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return
        L_0x000a:
            java.util.Queue r1 = r0.zzd     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0017
            r0.zzf()     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            return
        L_0x0017:
            java.util.Queue r1 = r0.zzd     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.cloudmessaging.zzs r1 = (com.google.android.gms.cloudmessaging.zzs) r1     // Catch:{ all -> 0x0093 }
            android.util.SparseArray r3 = r0.zze     // Catch:{ all -> 0x0093 }
            int r4 = r1.zza     // Catch:{ all -> 0x0093 }
            r3.put(r4, r1)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.cloudmessaging.zzv r3 = r0.zzf     // Catch:{ all -> 0x0093 }
            java.util.concurrent.ScheduledExecutorService r3 = r3.zzc     // Catch:{ all -> 0x0093 }
            com.google.android.gms.cloudmessaging.zzn r4 = new com.google.android.gms.cloudmessaging.zzn     // Catch:{ all -> 0x0093 }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x0093 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0093 }
            r6 = 30
            r3.schedule(r4, r6, r5)     // Catch:{ all -> 0x0093 }
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "MessengerIpcClient"
            r4 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r4)
            if (r3 == 0) goto L_0x004b
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = "Sending "
            r4.concat(r3)
        L_0x004b:
            com.google.android.gms.cloudmessaging.zzv r3 = r0.zzf
            android.os.Messenger r4 = r0.zzb
            int r5 = r1.zzc
            android.content.Context r3 = r3.zzb
            android.os.Message r6 = android.os.Message.obtain()
            r6.what = r5
            int r5 = r1.zza
            r6.arg1 = r5
            r6.replyTo = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            boolean r5 = r1.zzb()
            java.lang.String r7 = "oneWay"
            r4.putBoolean(r7, r5)
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r5 = "pkg"
            r4.putString(r5, r3)
            android.os.Bundle r1 = r1.zzd
            java.lang.String r3 = "data"
            r4.putBundle(r3, r1)
            r6.setData(r4)
            com.google.android.gms.cloudmessaging.zzq r1 = r0.zzc     // Catch:{ RemoteException -> 0x0089 }
            r1.zza(r6)     // Catch:{ RemoteException -> 0x0089 }
            goto L_0x0000
        L_0x0089:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            r0.zza(r2, r1)
            goto L_0x0000
        L_0x0093:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzj.run():void");
    }
}
