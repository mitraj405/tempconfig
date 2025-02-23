package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhw extends zzbp {
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final zzaf zzf;
    public final int zzg;
    public final zzui zzh;
    final boolean zzi;

    static {
        Integer.toString(AdError.NO_FILL_ERROR_CODE, 36);
        Integer.toString(AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE, 36);
        Integer.toString(1003, 36);
        Integer.toString(1004, 36);
        Integer.toString(1005, 36);
        Integer.toString(1006, 36);
    }

    private zzhw(int i, Throwable th, int i2) {
        this(i, th, (String) null, i2, (String) null, -1, (zzaf) null, 4, false);
    }

    public static zzhw zzb(Throwable th, String str, int i, zzaf zzaf, int i2, boolean z, int i3) {
        int i4;
        if (zzaf == null) {
            i4 = 4;
        } else {
            i4 = i2;
        }
        return new zzhw(1, th, (String) null, i3, str, i, zzaf, i4, z);
    }

    public static zzhw zzc(IOException iOException, int i) {
        return new zzhw(0, iOException, i);
    }

    public static zzhw zzd(RuntimeException runtimeException, int i) {
        return new zzhw(2, runtimeException, i);
    }

    public final zzhw zza(zzui zzui) {
        String message = getMessage();
        int i = zzet.zza;
        return new zzhw(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzui, this.zzb, this.zzi);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzhw(int r14, java.lang.Throwable r15, java.lang.String r16, int r17, java.lang.String r18, int r19, com.google.android.gms.internal.ads.zzaf r20, int r21, boolean r22) {
        /*
            r13 = this;
            r4 = r14
            r8 = r21
            if (r4 == 0) goto L_0x0059
            r0 = 1
            if (r4 == r0) goto L_0x000f
            java.lang.String r0 = "Unexpected runtime error"
            r5 = r18
            r6 = r19
            goto L_0x005f
        L_0x000f:
            java.lang.String r1 = java.lang.String.valueOf(r20)
            int r2 = com.google.android.gms.internal.ads.zzet.zza
            if (r8 == 0) goto L_0x0034
            if (r8 == r0) goto L_0x0031
            r0 = 2
            if (r8 == r0) goto L_0x002e
            r0 = 3
            if (r8 == r0) goto L_0x002b
            r0 = 4
            if (r8 != r0) goto L_0x0025
            java.lang.String r0 = "YES"
            goto L_0x0036
        L_0x0025:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x002b:
            java.lang.String r0 = "NO_EXCEEDS_CAPABILITIES"
            goto L_0x0036
        L_0x002e:
            java.lang.String r0 = "NO_UNSUPPORTED_DRM"
            goto L_0x0036
        L_0x0031:
            java.lang.String r0 = "NO_UNSUPPORTED_TYPE"
            goto L_0x0036
        L_0x0034:
            java.lang.String r0 = "NO"
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r5 = r18
            r2.append(r5)
            java.lang.String r3 = " error, index="
            r2.append(r3)
            r6 = r19
            r2.append(r6)
            java.lang.String r3 = ", format="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = ", format_supported="
            java.lang.String r0 = defpackage.C0709Uj.j(r2, r1, r0)
            goto L_0x005f
        L_0x0059:
            r5 = r18
            r6 = r19
            java.lang.String r0 = "Source error"
        L_0x005f:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006c
            java.lang.String r1 = ": null"
            java.lang.String r0 = r0.concat(r1)
        L_0x006c:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r2 = r15
            r3 = r17
            r4 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r12 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhw.<init>(int, java.lang.Throwable, java.lang.String, int, java.lang.String, int, com.google.android.gms.internal.ads.zzaf, int, boolean):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzhw(String str, Throwable th, int i, int i2, String str2, int i3, zzaf zzaf, int i4, zzui zzui, long j, boolean z) {
        super(str, th, i, j);
        boolean z2;
        int i5;
        boolean z3 = z;
        boolean z4 = false;
        if (z3) {
            i5 = i2;
            if (i5 == 1) {
                i5 = 1;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            i5 = i2;
            z2 = true;
        }
        zzdi.zzd(z2);
        zzdi.zzd(th != null ? true : z4);
        this.zzc = i5;
        this.zzd = str2;
        this.zze = i3;
        this.zzf = zzaf;
        this.zzg = i4;
        this.zzh = zzui;
        this.zzi = z3;
    }
}
