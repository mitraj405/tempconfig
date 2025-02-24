package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfp extends zzfl {
    private final ContentResolver zza;
    private Uri zzb;
    private AssetFileDescriptor zzc;
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzfp(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzfo {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzfo(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i3 = zzet.zza;
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zze;
        if (j2 != -1) {
            this.zze = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = 2000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f0, code lost:
        r2 = 2005;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f7, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f6 A[ExcHandler: zzfo (r0v1 'e' com.google.android.gms.internal.ads.zzfo A[CUSTOM_DECLARE]), Splitter:B:1:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzfy r16) throws com.google.android.gms.internal.ads.zzfo {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            java.lang.String r2 = "Could not open file descriptor for: "
            r4 = 1
            android.net.Uri r5 = r0.zza     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            android.net.Uri r5 = r5.normalizeScheme()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r1.zzb = r5     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r15.zzi(r16)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.lang.String r6 = "content"
            java.lang.String r7 = r5.getScheme()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            boolean r6 = r6.equals(r7)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            if (r6 == 0) goto L_0x0030
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r6.<init>()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.lang.String r7 = "android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT"
            r6.putBoolean(r7, r4)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            android.content.ContentResolver r7 = r1.zza     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.lang.String r8 = "*/*"
            android.content.res.AssetFileDescriptor r6 = r7.openTypedAssetFileDescriptor(r5, r8, r6)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            goto L_0x0038
        L_0x0030:
            android.content.ContentResolver r6 = r1.zza     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.lang.String r7 = "r"
            android.content.res.AssetFileDescriptor r6 = r6.openAssetFileDescriptor(r5, r7)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
        L_0x0038:
            r1.zzc = r6     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            if (r6 == 0) goto L_0x00ce
            long r7 = r6.getLength()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.io.FileDescriptor r5 = r6.getFileDescriptor()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r2.<init>(r5)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r1.zzd = r2     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r9 = -1
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            r11 = 2008(0x7d8, float:2.814E-42)
            r12 = 0
            if (r5 == 0) goto L_0x0061
            long r13 = r0.zze     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 > 0) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            com.google.android.gms.internal.ads.zzfo r0 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r0.<init>(r12, r11)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            throw r0     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
        L_0x0061:
            long r13 = r6.getStartOffset()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            long r3 = r0.zze     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            long r3 = r3 + r13
            long r3 = r2.skip(r3)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            long r3 = r3 - r13
            long r13 = r0.zze     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x00c8
            r13 = 0
            if (r5 != 0) goto L_0x0099
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            long r3 = r2.size()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x0087
            r1.zze = r9     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r3 = r9
            goto L_0x00a1
        L_0x0087:
            long r7 = r2.position()     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            long r3 = r3 - r7
            r1.zze = r3     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x0093
            goto L_0x00a1
        L_0x0093:
            com.google.android.gms.internal.ads.zzfo r0 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r0.<init>(r12, r11)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            throw r0     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
        L_0x0099:
            long r3 = r7 - r3
            r1.zze = r3     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x00c2
        L_0x00a1:
            long r5 = r0.zzf
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x00b2
            int r2 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x00ac
            goto L_0x00b0
        L_0x00ac:
            long r5 = java.lang.Math.min(r3, r5)
        L_0x00b0:
            r1.zze = r5
        L_0x00b2:
            r2 = 1
            r1.zzf = r2
            r15.zzj(r16)
            long r2 = r0.zzf
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x00bf
            return r2
        L_0x00bf:
            long r2 = r1.zze
            return r2
        L_0x00c2:
            com.google.android.gms.internal.ads.zzfo r0 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r0.<init>(r12, r11)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            throw r0     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
        L_0x00c8:
            com.google.android.gms.internal.ads.zzfo r0 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r0.<init>(r12, r11)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            throw r0     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
        L_0x00ce:
            com.google.android.gms.internal.ads.zzfo r0 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            java.lang.String r2 = r2.concat(r4)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r3.<init>(r2)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e5 }
            r2 = 2000(0x7d0, float:2.803E-42)
            r0.<init>(r3, r2)     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e3 }
            throw r0     // Catch:{ zzfo -> 0x00f6, IOException -> 0x00e3 }
        L_0x00e3:
            r0 = move-exception
            goto L_0x00e8
        L_0x00e5:
            r0 = move-exception
            r2 = 2000(0x7d0, float:2.803E-42)
        L_0x00e8:
            com.google.android.gms.internal.ads.zzfo r3 = new com.google.android.gms.internal.ads.zzfo
            boolean r4 = r0 instanceof java.io.FileNotFoundException
            r5 = 1
            if (r5 == r4) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r2 = 2005(0x7d5, float:2.81E-42)
        L_0x00f2:
            r3.<init>(r0, r2)
            throw r3
        L_0x00f6:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzb(com.google.android.gms.internal.ads.zzfy):long");
    }

    public final Uri zzc() {
        return this.zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        throw new com.google.android.gms.internal.ads.zzfo(r3, 2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004f, code lost:
        throw new com.google.android.gms.internal.ads.zzfo(r3, 2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        r5.zzc = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0054, code lost:
        if (r5.zzf != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r5.zzf = false;
        zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x000f, B:15:0x0025, B:24:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzfo {
        /*
            r5 = this;
            r0 = 0
            r5.zzb = r0
            r1 = 0
            r2 = 2000(0x7d0, float:2.803E-42)
            java.io.FileInputStream r3 = r5.zzd     // Catch:{ IOException -> 0x002d }
            if (r3 == 0) goto L_0x000d
            r3.close()     // Catch:{ IOException -> 0x002d }
        L_0x000d:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r3 = r5.zzc     // Catch:{ IOException -> 0x0024 }
            if (r3 == 0) goto L_0x0016
            r3.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0016:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0021
            r5.zzf = r1
            r5.zzh()
        L_0x0021:
            return
        L_0x0022:
            r2 = move-exception
            goto L_0x0050
        L_0x0024:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfo r4 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ all -> 0x0022 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0022 }
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x002b:
            r3 = move-exception
            goto L_0x0034
        L_0x002d:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfo r4 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ all -> 0x002b }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x002b }
            throw r4     // Catch:{ all -> 0x002b }
        L_0x0034:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r4 = r5.zzc     // Catch:{ IOException -> 0x0049 }
            if (r4 == 0) goto L_0x003d
            r4.close()     // Catch:{ IOException -> 0x0049 }
        L_0x003d:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0048
            r5.zzf = r1
            r5.zzh()
        L_0x0048:
            throw r3
        L_0x0049:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfo r4 = new com.google.android.gms.internal.ads.zzfo     // Catch:{ all -> 0x0022 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0022 }
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0050:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x005b
            r5.zzf = r1
            r5.zzh()
        L_0x005b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfp.zzd():void");
    }
}
