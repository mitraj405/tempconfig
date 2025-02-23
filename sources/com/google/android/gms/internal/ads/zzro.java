package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzro implements zzsa {
    private final zzfvk zza;
    private final zzfvk zzb;
    private boolean zzc = true;

    public zzro(int i) {
        zzrm zzrm = new zzrm(i);
        zzrn zzrn = new zzrn(i);
        this.zza = zzrm;
        this.zzb = zzrn;
    }

    public static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzrq.zzs(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    public static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzrq.zzs(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrq zzc(com.google.android.gms.internal.ads.zzrz r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "createCodec:"
            com.google.android.gms.internal.ads.zzsf r1 = r7.zza
            java.lang.String r1 = r1.zza
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0069 }
            r3.append(r1)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0069 }
            android.os.Trace.beginSection(r0)     // Catch:{ Exception -> 0x0069 }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ Exception -> 0x0069 }
            boolean r1 = r6.zzc     // Catch:{ Exception -> 0x0067 }
            if (r1 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzaf r1 = r7.zzc     // Catch:{ Exception -> 0x0067 }
            int r3 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ Exception -> 0x0067 }
            r4 = 34
            if (r3 >= r4) goto L_0x0027
            goto L_0x003a
        L_0x0027:
            r4 = 35
            if (r3 >= r4) goto L_0x0033
            java.lang.String r1 = r1.zzm     // Catch:{ Exception -> 0x0067 }
            boolean r1 = com.google.android.gms.internal.ads.zzbn.zzi(r1)     // Catch:{ Exception -> 0x0067 }
            if (r1 == 0) goto L_0x003a
        L_0x0033:
            com.google.android.gms.internal.ads.zztf r1 = new com.google.android.gms.internal.ads.zztf     // Catch:{ Exception -> 0x0067 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0067 }
            r3 = 4
            goto L_0x004a
        L_0x003a:
            com.google.android.gms.internal.ads.zzru r1 = new com.google.android.gms.internal.ads.zzru     // Catch:{ Exception -> 0x0067 }
            com.google.android.gms.internal.ads.zzfvk r3 = r6.zzb     // Catch:{ Exception -> 0x0067 }
            com.google.android.gms.internal.ads.zzrn r3 = (com.google.android.gms.internal.ads.zzrn) r3     // Catch:{ Exception -> 0x0067 }
            int r3 = r3.zza     // Catch:{ Exception -> 0x0067 }
            android.os.HandlerThread r3 = zzb(r3)     // Catch:{ Exception -> 0x0067 }
            r1.<init>(r0, r3)     // Catch:{ Exception -> 0x0067 }
            r3 = 0
        L_0x004a:
            com.google.android.gms.internal.ads.zzrq r4 = new com.google.android.gms.internal.ads.zzrq     // Catch:{ Exception -> 0x0067 }
            com.google.android.gms.internal.ads.zzfvk r5 = r6.zza     // Catch:{ Exception -> 0x0067 }
            com.google.android.gms.internal.ads.zzrm r5 = (com.google.android.gms.internal.ads.zzrm) r5     // Catch:{ Exception -> 0x0067 }
            int r5 = r5.zza     // Catch:{ Exception -> 0x0067 }
            android.os.HandlerThread r5 = zza(r5)     // Catch:{ Exception -> 0x0067 }
            r4.<init>(r0, r5, r1, r2)     // Catch:{ Exception -> 0x0067 }
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x0064 }
            android.media.MediaFormat r1 = r7.zzb     // Catch:{ Exception -> 0x0064 }
            android.view.Surface r7 = r7.zzd     // Catch:{ Exception -> 0x0064 }
            com.google.android.gms.internal.ads.zzrq.zzh(r4, r1, r7, r2, r3)     // Catch:{ Exception -> 0x0064 }
            return r4
        L_0x0064:
            r7 = move-exception
            r2 = r4
            goto L_0x006b
        L_0x0067:
            r7 = move-exception
            goto L_0x006b
        L_0x0069:
            r7 = move-exception
            r0 = r2
        L_0x006b:
            if (r2 != 0) goto L_0x0073
            if (r0 == 0) goto L_0x0076
            r0.release()
            goto L_0x0076
        L_0x0073:
            r2.zzl()
        L_0x0076:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzro.zzc(com.google.android.gms.internal.ads.zzrz):com.google.android.gms.internal.ads.zzrq");
    }

    public final /* bridge */ /* synthetic */ zzsc zzd(zzrz zzrz) throws IOException {
        throw null;
    }

    public final void zze(boolean z) {
        this.zzc = true;
    }
}
