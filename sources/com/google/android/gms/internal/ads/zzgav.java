package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzgav extends zzgbz implements Runnable {
    ListenableFuture zza;
    Class zzb;
    Object zzc;

    public zzgav(ListenableFuture listenableFuture, Class cls, Object obj) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.common.util.concurrent.ListenableFuture r0 = r10.zza
            java.lang.Class r1 = r10.zzb
            java.lang.Object r2 = r10.zzc
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = r3
            goto L_0x000d
        L_0x000c:
            r5 = r4
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = r3
            goto L_0x0012
        L_0x0011:
            r6 = r4
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            r3 = r3 | r5
            if (r3 != 0) goto L_0x0090
            boolean r3 = r10.isCancelled()
            if (r3 == 0) goto L_0x0022
            goto L_0x0090
        L_0x0022:
            r3 = 0
            r10.zza = r3
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzgdm     // Catch:{ ExecutionException -> 0x003b, all -> 0x0039 }
            if (r4 == 0) goto L_0x0031
            r4 = r0
            com.google.android.gms.internal.ads.zzgdm r4 = (com.google.android.gms.internal.ads.zzgdm) r4     // Catch:{ ExecutionException -> 0x003b, all -> 0x0039 }
            java.lang.Throwable r4 = r4.zzl()     // Catch:{ ExecutionException -> 0x003b, all -> 0x0039 }
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            if (r4 != 0) goto L_0x0062
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzgcj.zzp(r0)     // Catch:{ ExecutionException -> 0x003b, all -> 0x0039 }
            goto L_0x0063
        L_0x0039:
            r4 = move-exception
            goto L_0x0062
        L_0x003b:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0061
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r7 = "Future type "
            java.lang.String r8 = " threw "
            java.lang.String r9 = " without a cause"
            java.lang.String r4 = defpackage.C1058d.A(r7, r6, r8, r4, r9)
            r5.<init>(r4)
        L_0x0061:
            r4 = r5
        L_0x0062:
            r5 = r3
        L_0x0063:
            if (r4 != 0) goto L_0x0069
            r10.zzc(r5)
            return
        L_0x0069:
            boolean r1 = r1.isInstance(r4)
            if (r1 == 0) goto L_0x008d
            java.lang.Object r0 = r10.zze(r2, r4)     // Catch:{ all -> 0x007b }
            r10.zzb = r3
            r10.zzc = r3
            r10.zzf(r0)
            return
        L_0x007b:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzgdb.zza(r0)     // Catch:{ all -> 0x0087 }
            r10.zzd(r0)     // Catch:{ all -> 0x0087 }
            r10.zzb = r3
            r10.zzc = r3
            return
        L_0x0087:
            r0 = move-exception
            r10.zzb = r3
            r10.zzc = r3
            throw r0
        L_0x008d:
            r10.zzs(r0)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgav.run():void");
    }

    public final String zza() {
        String str;
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String zza2 = super.zza();
        if (listenableFuture != null) {
            str = lf.j("inputFuture=[", listenableFuture.toString(), "], ");
        } else {
            str = "";
        }
        if (cls != null && obj != null) {
            String obj2 = cls.toString();
            String obj3 = obj.toString();
            return str + "exceptionType=[" + obj2 + "], fallback=[" + obj3 + "]";
        } else if (zza2 != null) {
            return str.concat(zza2);
        } else {
            return null;
        }
    }

    public final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    public abstract Object zze(Object obj, Throwable th) throws Exception;

    public abstract void zzf(Object obj);
}
