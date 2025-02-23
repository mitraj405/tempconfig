package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.Surface;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaal {
    private final zzzv zza = new zzzv();
    private final zzaaj zzb;
    private final zzaak zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzaal(Context context) {
        zzaaj zzaaj;
        DisplayManager displayManager;
        zzaak zzaak = null;
        if (context == null || (displayManager = (DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) == null) {
            zzaaj = null;
        } else {
            zzaaj = new zzaaj(this, displayManager);
        }
        this.zzb = zzaaj;
        this.zzc = zzaaj != null ? zzaak.zza() : zzaak;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzaal zzaal, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzaal.zzk = refreshRate;
            zzaal.zzl = (refreshRate * 80) / 100;
            return;
        }
        zzea.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        zzaal.zzk = -9223372036854775807L;
        zzaal.zzl = -9223372036854775807L;
    }

    private final void zzk() {
        Surface surface;
        if (zzet.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE && this.zzh != 0.0f) {
            this.zzh = 0.0f;
            zzaai.zza(surface, 0.0f);
        }
    }

    private final void zzl() {
        this.zzm = 0;
        this.zzp = -1;
        this.zzn = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (java.lang.Math.abs(r0 - r9.zzg) >= r2) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r9.zza.zzb() >= 30) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzm() {
        /*
            r9 = this;
            int r0 = com.google.android.gms.internal.ads.zzet.zza
            r1 = 30
            if (r0 < r1) goto L_0x006a
            android.view.Surface r0 = r9.zze
            if (r0 != 0) goto L_0x000b
            goto L_0x006a
        L_0x000b:
            com.google.android.gms.internal.ads.zzzv r0 = r9.zza
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzzv r0 = r9.zza
            float r0 = r0.zza()
            goto L_0x001c
        L_0x001a:
            float r0 = r9.zzf
        L_0x001c:
            float r2 = r9.zzg
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x006a
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0057
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0057
            com.google.android.gms.internal.ads.zzzv r1 = r9.zza
            boolean r1 = r1.zzg()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzzv r1 = r9.zza
            long r3 = r1.zzd()
            r7 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x004a
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L_0x004a:
            float r1 = r9.zzg
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0062
            goto L_0x0063
        L_0x0057:
            if (r4 != 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzzv r2 = r9.zza
            int r2 = r2.zzb()
            if (r2 < r1) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r5 = r6
        L_0x0063:
            if (r5 == 0) goto L_0x006a
        L_0x0065:
            r9.zzg = r0
            r9.zzn(r6)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaal.zzm():void");
    }

    private final void zzn(boolean z) {
        Surface surface;
        if (zzet.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE) {
            float f = 0.0f;
            if (this.zzd) {
                float f2 = this.zzg;
                if (f2 != -1.0f) {
                    f = this.zzi * f2;
                }
            }
            if (z || this.zzh != f) {
                this.zzh = f;
                zzaai.zza(surface, f);
            }
        }
    }

    public final long zza(long j) {
        long j2;
        if (this.zzp != -1 && this.zza.zzg()) {
            long zzc2 = this.zza.zzc();
            long j3 = this.zzq + ((long) (((float) ((this.zzm - this.zzp) * zzc2)) / this.zzi));
            if (Math.abs(j - j3) > 20000000) {
                zzl();
            } else {
                j = j3;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzaak zzaak = this.zzc;
        if (!(zzaak == null || this.zzk == -9223372036854775807L)) {
            long j4 = zzaak.zza;
            if (j4 != -9223372036854775807L) {
                long j5 = this.zzk;
                long j6 = (((j - j4) / j5) * j5) + j4;
                if (j <= j6) {
                    j2 = j6 - j5;
                } else {
                    j2 = j6;
                    j6 = j5 + j6;
                }
                long j7 = this.zzl;
                if (j6 - j >= j - j2) {
                    j6 = j2;
                }
                return j6 - j7;
            }
        }
        return j;
    }

    public final void zzc(float f) {
        this.zzf = f;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j * 1000);
        zzm();
    }

    public final void zze(float f) {
        this.zzi = f;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzaak zzaak = this.zzc;
            zzaak.getClass();
            zzaak.zzb();
            this.zzb.zza();
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzaaj zzaaj = this.zzb;
        if (zzaaj != null) {
            zzaaj.zzb();
            zzaak zzaak = this.zzc;
            zzaak.getClass();
            zzaak.zzc();
        }
        zzk();
    }

    public final void zzi(Surface surface) {
        if (true == (surface instanceof zzaad)) {
            surface = null;
        }
        if (this.zze != surface) {
            zzk();
            this.zze = surface;
            zzn(true);
        }
    }

    public final void zzj(int i) {
        if (this.zzj != i) {
            this.zzj = i;
            zzn(true);
        }
    }
}
