package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzer {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzer(long j) {
        zzi(0);
    }

    public static long zzg(long j) {
        return (j * 1000000) / 90000;
    }

    public static long zzh(long j) {
        return (j * 90000) / 1000000;
    }

    public final synchronized long zza(long j) {
        if (!zzj()) {
            long j2 = this.zza;
            if (j2 == 9223372036854775806L) {
                Long l = (Long) this.zzd.get();
                l.getClass();
                j2 = l.longValue();
            }
            this.zzb = j2 - j;
            notifyAll();
        }
        this.zzc = j;
        return j + this.zzb;
    }

    public final synchronized long zzb(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            long zzh = zzh(j2);
            long j3 = (4294967296L + zzh) / 8589934592L;
            long j4 = ((-1 + j3) * 8589934592L) + j;
            long j5 = (j3 * 8589934592L) + j;
            if (Math.abs(j4 - zzh) < Math.abs(j5 - zzh)) {
                j = j4;
            } else {
                j = j5;
            }
        }
        return zza(zzg(j));
    }

    public final synchronized long zzc(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            long zzh = zzh(j2);
            long j3 = zzh / 8589934592L;
            long j4 = (j3 * 8589934592L) + j;
            long j5 = ((j3 + 1) * 8589934592L) + j;
            if (j4 >= zzh) {
                j = j4;
            } else {
                j = j5;
            }
        }
        return zza(zzg(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        return -9223372036854775807L;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzd() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.zza     // Catch:{ all -> 0x001f }
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0018
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            monitor-exit(r4)
            return r0
        L_0x0018:
            monitor-exit(r4)
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzer.zzd():long");
    }

    public final synchronized long zze() {
        long j;
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            j = j2 + this.zzb;
        } else {
            j = zzd();
        }
        return j;
    }

    public final synchronized long zzf() {
        return this.zzb;
    }

    public final synchronized void zzi(long j) {
        long j2;
        this.zza = j;
        if (j == Long.MAX_VALUE) {
            j2 = 0;
        } else {
            j2 = -9223372036854775807L;
        }
        this.zzb = j2;
        this.zzc = -9223372036854775807L;
    }

    public final synchronized boolean zzj() {
        if (this.zzb != -9223372036854775807L) {
            return true;
        }
        return false;
    }
}
