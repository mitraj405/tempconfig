package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcce implements zzfs {
    private final Context zza;
    private final zzfs zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbah zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private zzfy zzl;

    public zzcce(Context context, zzfs zzfs, String str, int i, zzgu zzgu, zzccd zzccd) {
        this.zza = context;
        this.zzb = zzfs;
        this.zzc = str;
        this.zzd = i;
        new AtomicLong(-1);
        this.zze = ((Boolean) zzba.zzc().zza(zzbbw.zzbG)).booleanValue();
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdT)).booleanValue() && !this.zzj) {
            return true;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzdU)).booleanValue() || this.zzk) {
            return false;
        }
        return true;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzg) {
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                return inputStream.read(bArr, i, i2);
            }
            return this.zzb.zza(bArr, i, i2);
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x009d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzfy r6) throws java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r5.zzg
            if (r0 != 0) goto L_0x011c
            r0 = 1
            r5.zzg = r0
            android.net.Uri r0 = r6.zza
            r5.zzh = r0
            r5.zzl = r6
            com.google.android.gms.internal.ads.zzbah r0 = com.google.android.gms.internal.ads.zzbah.zza(r0)
            r5.zzi = r0
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzdQ
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            if (r0 == 0) goto L_0x00fa
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            long r2 = r6.zze
            r0.zzh = r2
            com.google.android.gms.internal.ads.zzbah r6 = r5.zzi
            java.lang.String r0 = r5.zzc
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfvj.zzc(r0)
            r6.zzi = r0
            com.google.android.gms.internal.ads.zzbah r6 = r5.zzi
            int r0 = r5.zzd
            r6.zzj = r0
            com.google.android.gms.internal.ads.zzbah r6 = r5.zzi
            boolean r6 = r6.zzg
            if (r6 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzdS
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r0.zza(r6)
            java.lang.Long r6 = (java.lang.Long) r6
            goto L_0x005f
        L_0x0053:
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzdR
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r0.zza(r6)
            java.lang.Long r6 = (java.lang.Long) r6
        L_0x005f:
            long r2 = r6.longValue()
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzu.zzB()
            r6.elapsedRealtime()
            com.google.android.gms.ads.internal.zzu.zzd()
            android.content.Context r6 = r5.zza
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            java.util.concurrent.Future r6 = com.google.android.gms.internal.ads.zzbas.zza(r6, r0)
            r0 = 0
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            java.lang.Object r2 = r6.get(r2, r4)     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            com.google.android.gms.internal.ads.zzbat r2 = (com.google.android.gms.internal.ads.zzbat) r2     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            r2.zzd()     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            boolean r3 = r2.zzf()     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            r5.zzj = r3     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            boolean r3 = r2.zze()     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            r5.zzk = r3     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            r2.zza()     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            boolean r3 = r5.zzg()     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            if (r3 != 0) goto L_0x00ab
            java.io.InputStream r2 = r2.zzc()     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            r5.zzf = r2     // Catch:{ ExecutionException | TimeoutException -> 0x00a8, InterruptedException -> 0x009d }
            goto L_0x00ab
        L_0x009d:
            r6.cancel(r0)     // Catch:{ all -> 0x00ab }
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00ab }
            r6.interrupt()     // Catch:{ all -> 0x00ab }
            goto L_0x00ab
        L_0x00a8:
            r6.cancel(r0)     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzu.zzB()
            r6.elapsedRealtime()
            throw r1
        L_0x00b3:
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            if (r0 == 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            long r1 = r6.zze
            r0.zzh = r1
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            java.lang.String r1 = r5.zzc
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfvj.zzc(r1)
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            int r1 = r5.zzd
            r0.zzj = r1
            com.google.android.gms.internal.ads.zzbad r0 = com.google.android.gms.ads.internal.zzu.zzc()
            com.google.android.gms.internal.ads.zzbah r1 = r5.zzi
            com.google.android.gms.internal.ads.zzbae r1 = r0.zzb(r1)
        L_0x00d7:
            if (r1 == 0) goto L_0x00fa
            boolean r0 = r1.zze()
            if (r0 == 0) goto L_0x00fa
            boolean r0 = r1.zzg()
            r5.zzj = r0
            boolean r0 = r1.zzf()
            r5.zzk = r0
            boolean r0 = r5.zzg()
            if (r0 != 0) goto L_0x00fa
            java.io.InputStream r6 = r1.zzc()
            r5.zzf = r6
            r0 = -1
            return r0
        L_0x00fa:
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            if (r0 == 0) goto L_0x0113
            com.google.android.gms.internal.ads.zzfw r6 = r6.zza()
            com.google.android.gms.internal.ads.zzbah r0 = r5.zzi
            java.lang.String r0 = r0.zza
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r6.zzd(r0)
            com.google.android.gms.internal.ads.zzfy r6 = r6.zze()
            r5.zzl = r6
        L_0x0113:
            com.google.android.gms.internal.ads.zzfs r6 = r5.zzb
            com.google.android.gms.internal.ads.zzfy r0 = r5.zzl
            long r0 = r6.zzb(r0)
            return r0
        L_0x011c:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open CacheDataSource."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcce.zzb(com.google.android.gms.internal.ads.zzfy):long");
    }

    public final Uri zzc() {
        return this.zzh;
    }

    public final void zzd() throws IOException {
        if (this.zzg) {
            this.zzg = false;
            this.zzh = null;
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzf = null;
                return;
            }
            this.zzb.zzd();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    public final void zzf(zzgu zzgu) {
    }
}
