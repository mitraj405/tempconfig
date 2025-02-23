package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzanh implements zzant {
    private final zzang zza;
    private final zzek zzb = new zzek(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzanh(zzang zzang) {
        this.zza = zzang;
    }

    public final void zza(zzek zzek, int i) {
        int i2;
        boolean z;
        int i3 = i & 1;
        if (i3 != 0) {
            i2 = zzek.zzd() + zzek.zzm();
        } else {
            i2 = -1;
        }
        if (this.zzf) {
            if (i3 != 0) {
                this.zzf = false;
                zzek.zzK(i2);
                this.zzd = 0;
            } else {
                return;
            }
        }
        while (zzek.zzb() > 0) {
            int i4 = this.zzd;
            if (i4 < 3) {
                if (i4 == 0) {
                    int zzm = zzek.zzm();
                    zzek.zzK(zzek.zzd() - 1);
                    if (zzm == 255) {
                    }
                }
                int min = Math.min(zzek.zzb(), 3 - this.zzd);
                zzek.zzG(this.zzb.zzM(), this.zzd, min);
                int i5 = this.zzd + min;
                this.zzd = i5;
                if (i5 == 3) {
                    this.zzb.zzK(0);
                    this.zzb.zzJ(3);
                    this.zzb.zzL(1);
                    zzek zzek2 = this.zzb;
                    int zzm2 = zzek2.zzm();
                    if ((zzm2 & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int zzm3 = zzek2.zzm();
                    this.zze = z;
                    this.zzc = (zzm3 | ((zzm2 & 15) << 8)) + 3;
                    int zzc2 = this.zzb.zzc();
                    int i6 = this.zzc;
                    if (zzc2 < i6) {
                        int zzc3 = this.zzb.zzc();
                        this.zzb.zzE(Math.min(4098, Math.max(i6, zzc3 + zzc3)));
                    }
                }
            } else {
                int min2 = Math.min(zzek.zzb(), this.zzc - i4);
                zzek.zzG(this.zzb.zzM(), this.zzd, min2);
                int i7 = this.zzd + min2;
                this.zzd = i7;
                int i8 = this.zzc;
                if (i7 != i8) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzJ(i8);
                    } else if (zzet.zze(this.zzb.zzM(), 0, i8, -1) == 0) {
                        this.zzb.zzJ(this.zzc - 4);
                    }
                    this.zzb.zzK(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
            this.zzf = true;
            return;
        }
    }

    public final void zzb(zzer zzer, zzacn zzacn, zzans zzans) {
        this.zza.zzb(zzer, zzacn, zzans);
        this.zzf = true;
    }

    public final void zzc() {
        this.zzf = true;
    }
}
