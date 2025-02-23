package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import com.google.common.primitives.Ints;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzvw implements zzadp {
    private zzrj zzA;
    private final zzvq zza;
    private final zzvs zzb = new zzvs();
    private final zzwd zzc = new zzwd(new zzvr());
    private final zzri zzd;
    private zzvv zze;
    private zzaf zzf;
    private int zzg = 1000;
    private long[] zzh = new long[1000];
    private long[] zzi = new long[1000];
    private int[] zzj = new int[1000];
    private int[] zzk = new int[1000];
    private long[] zzl = new long[1000];
    private zzado[] zzm = new zzado[1000];
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private long zzr = Long.MIN_VALUE;
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private boolean zzu;
    private boolean zzv = true;
    private boolean zzw = true;
    private zzaf zzx;
    private boolean zzy = true;
    private boolean zzz;

    public zzvw(zzyk zzyk, zzri zzri, zzrd zzrd) {
        this.zzd = zzri;
        this.zza = new zzvq(zzyk);
    }

    private final int zzA(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (this.zzl[i] > j ? 1 : (this.zzl[i] == j ? 0 : -1));
            if (i5 > 0) {
                break;
            }
            if (!z || (this.zzk[i] & 1) != 0) {
                i3 = i4;
                if (i5 == 0) {
                    break;
                }
            }
            i++;
            if (i == this.zzg) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzB(int i) {
        int i2 = this.zzp + i;
        int i3 = this.zzg;
        if (i2 < i3) {
            return i2;
        }
        return i2 - i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized int zzC(com.google.android.gms.internal.ads.zzjz r7, com.google.android.gms.internal.ads.zzhd r8, boolean r9, boolean r10, com.google.android.gms.internal.ads.zzvs r11) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r8.zzd = r0     // Catch:{ all -> 0x008f }
            boolean r0 = r6.zzK()     // Catch:{ all -> 0x008f }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x002f
            if (r10 != 0) goto L_0x0025
            boolean r10 = r6.zzu     // Catch:{ all -> 0x008f }
            if (r10 == 0) goto L_0x0014
            goto L_0x0025
        L_0x0014:
            com.google.android.gms.internal.ads.zzaf r8 = r6.zzx     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x0023
            if (r9 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzaf r9 = r6.zzf     // Catch:{ all -> 0x008f }
            if (r8 == r9) goto L_0x0023
        L_0x001e:
            r6.zzH(r8, r7)     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r1
        L_0x0023:
            monitor-exit(r6)
            return r2
        L_0x0025:
            r7 = 4
            r8.zzc(r7)     // Catch:{ all -> 0x008f }
            r9 = -9223372036854775808
            r8.zze = r9     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r3
        L_0x002f:
            com.google.android.gms.internal.ads.zzwd r0 = r6.zzc     // Catch:{ all -> 0x008f }
            int r4 = r6.zzo     // Catch:{ all -> 0x008f }
            int r5 = r6.zzq     // Catch:{ all -> 0x008f }
            int r4 = r4 + r5
            java.lang.Object r0 = r0.zza(r4)     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzvu r0 = (com.google.android.gms.internal.ads.zzvu) r0     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzaf r0 = r0.zza     // Catch:{ all -> 0x008f }
            if (r9 != 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzaf r9 = r6.zzf     // Catch:{ all -> 0x008f }
            if (r0 == r9) goto L_0x0045
            goto L_0x008a
        L_0x0045:
            int r7 = r6.zzq     // Catch:{ all -> 0x008f }
            int r7 = r6.zzB(r7)     // Catch:{ all -> 0x008f }
            boolean r9 = r6.zzL(r7)     // Catch:{ all -> 0x008f }
            if (r9 != 0) goto L_0x0056
            r7 = 1
            r8.zzd = r7     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r2
        L_0x0056:
            int[] r9 = r6.zzk     // Catch:{ all -> 0x008f }
            r9 = r9[r7]     // Catch:{ all -> 0x008f }
            r8.zzc(r9)     // Catch:{ all -> 0x008f }
            int r9 = r6.zzq     // Catch:{ all -> 0x008f }
            int r0 = r6.zzn     // Catch:{ all -> 0x008f }
            int r0 = r0 + -1
            if (r9 != r0) goto L_0x0070
            if (r10 != 0) goto L_0x006b
            boolean r9 = r6.zzu     // Catch:{ all -> 0x008f }
            if (r9 == 0) goto L_0x0070
        L_0x006b:
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            r8.zza(r9)     // Catch:{ all -> 0x008f }
        L_0x0070:
            long[] r9 = r6.zzl     // Catch:{ all -> 0x008f }
            r0 = r9[r7]     // Catch:{ all -> 0x008f }
            r8.zze = r0     // Catch:{ all -> 0x008f }
            int[] r8 = r6.zzj     // Catch:{ all -> 0x008f }
            r8 = r8[r7]     // Catch:{ all -> 0x008f }
            r11.zza = r8     // Catch:{ all -> 0x008f }
            long[] r8 = r6.zzi     // Catch:{ all -> 0x008f }
            r9 = r8[r7]     // Catch:{ all -> 0x008f }
            r11.zzb = r9     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzado[] r8 = r6.zzm     // Catch:{ all -> 0x008f }
            r7 = r8[r7]     // Catch:{ all -> 0x008f }
            r11.zzc = r7     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r3
        L_0x008a:
            r6.zzH(r0, r7)     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r1
        L_0x008f:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zzC(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzhd, boolean, boolean, com.google.android.gms.internal.ads.zzvs):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized long zzD(long r8, boolean r10, boolean r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r10 = r7.zzn     // Catch:{ all -> 0x002d }
            if (r10 == 0) goto L_0x0029
            long[] r0 = r7.zzl     // Catch:{ all -> 0x002d }
            int r2 = r7.zzp     // Catch:{ all -> 0x002d }
            r3 = r0[r2]     // Catch:{ all -> 0x002d }
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            if (r11 == 0) goto L_0x0018
            int r11 = r7.zzq     // Catch:{ all -> 0x002d }
            if (r11 == r10) goto L_0x0018
            int r10 = r11 + 1
        L_0x0018:
            r3 = r10
            r6 = 0
            r1 = r7
            r4 = r8
            int r8 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x002d }
            r9 = -1
            if (r8 == r9) goto L_0x0029
            long r8 = r7.zzF(r8)     // Catch:{ all -> 0x002d }
            monitor-exit(r7)
            return r8
        L_0x0029:
            monitor-exit(r7)
            r8 = -1
            return r8
        L_0x002d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zzD(long, boolean, boolean):long");
    }

    private final synchronized long zzE() {
        int i = this.zzn;
        if (i == 0) {
            return -1;
        }
        return zzF(i);
    }

    private final long zzF(int i) {
        long j = this.zzs;
        long j2 = Long.MIN_VALUE;
        if (i != 0) {
            int zzB = zzB(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                j2 = Math.max(j2, this.zzl[zzB]);
                if ((this.zzk[zzB] & 1) != 0) {
                    break;
                }
                zzB--;
                if (zzB == -1) {
                    zzB = this.zzg - 1;
                }
            }
        }
        this.zzs = Math.max(j, j2);
        this.zzn -= i;
        int i3 = this.zzo + i;
        this.zzo = i3;
        int i4 = this.zzp + i;
        this.zzp = i4;
        int i5 = this.zzg;
        if (i4 >= i5) {
            this.zzp = i4 - i5;
        }
        int i6 = this.zzq - i;
        this.zzq = i6;
        if (i6 < 0) {
            this.zzq = 0;
        }
        this.zzc.zze(i3);
        if (this.zzn != 0) {
            return this.zzi[this.zzp];
        }
        int i7 = this.zzp;
        if (i7 == 0) {
            i7 = this.zzg;
        }
        int i8 = i7 - 1;
        return this.zzi[i8] + ((long) this.zzj[i8]);
    }

    private final synchronized void zzG(long j, int i, long j2, int i2, zzado zzado) {
        boolean z;
        boolean z2;
        int i3 = this.zzn;
        if (i3 > 0) {
            int zzB = zzB(i3 - 1);
            if (this.zzi[zzB] + ((long) this.zzj[zzB]) <= j2) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzdi.zzd(z2);
        }
        if ((536870912 & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.zzu = z;
        this.zzt = Math.max(this.zzt, j);
        int zzB2 = zzB(this.zzn);
        this.zzl[zzB2] = j;
        this.zzi[zzB2] = j2;
        this.zzj[zzB2] = i2;
        this.zzk[zzB2] = i;
        this.zzm[zzB2] = zzado;
        this.zzh[zzB2] = 0;
        if (this.zzc.zzf() || !((zzvu) this.zzc.zzb()).zza.equals(this.zzx)) {
            zzaf zzaf = this.zzx;
            zzaf.getClass();
            this.zzc.zzc(this.zzo + this.zzn, new zzvu(zzaf, zzrh.zza, (zzvt) null));
        }
        int i4 = this.zzn + 1;
        this.zzn = i4;
        int i5 = this.zzg;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            zzado[] zzadoArr = new zzado[i6];
            int i7 = this.zzp;
            int i8 = i5 - i7;
            System.arraycopy(this.zzi, i7, jArr2, 0, i8);
            System.arraycopy(this.zzl, this.zzp, jArr3, 0, i8);
            System.arraycopy(this.zzk, this.zzp, iArr, 0, i8);
            System.arraycopy(this.zzj, this.zzp, iArr2, 0, i8);
            System.arraycopy(this.zzm, this.zzp, zzadoArr, 0, i8);
            System.arraycopy(this.zzh, this.zzp, jArr, 0, i8);
            int i9 = this.zzp;
            System.arraycopy(this.zzi, 0, jArr2, i8, i9);
            System.arraycopy(this.zzl, 0, jArr3, i8, i9);
            System.arraycopy(this.zzk, 0, iArr, i8, i9);
            System.arraycopy(this.zzj, 0, iArr2, i8, i9);
            System.arraycopy(this.zzm, 0, zzadoArr, i8, i9);
            System.arraycopy(this.zzh, 0, jArr, i8, i9);
            this.zzi = jArr2;
            this.zzl = jArr3;
            this.zzk = iArr;
            this.zzj = iArr2;
            this.zzm = zzadoArr;
            this.zzh = jArr;
            this.zzp = 0;
            this.zzg = i6;
        }
    }

    private final void zzH(zzaf zzaf, zzjz zzjz) {
        zzy zzy2;
        zzaf zzaf2 = this.zzf;
        zzrj zzrj = null;
        if (zzaf2 == null) {
            zzy2 = null;
        } else {
            zzy2 = zzaf2.zzp;
        }
        this.zzf = zzaf;
        zzy zzy3 = zzaf.zzp;
        zzjz.zza = zzaf.zzc(this.zzd.zza(zzaf));
        zzjz.zzb = this.zzA;
        if (zzaf2 == null || !zzet.zzG(zzy2, zzy3)) {
            if (zzaf.zzp != null) {
                zzrj = new zzrj(new zzrb(new zzrl(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
            }
            this.zzA = zzrj;
            zzjz.zzb = zzrj;
        }
    }

    private final void zzI() {
        if (this.zzA != null) {
            this.zzA = null;
            this.zzf = null;
        }
    }

    private final synchronized void zzJ() {
        this.zzq = 0;
        this.zza.zzg();
    }

    private final boolean zzK() {
        if (this.zzq != this.zzn) {
            return true;
        }
        return false;
    }

    private final boolean zzL(int i) {
        if (this.zzA != null) {
            return (this.zzk[i] & Ints.MAX_POWER_OF_TWO) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzM(zzaf zzaf) {
        this.zzw = false;
        if (zzet.zzG(zzaf, this.zzx)) {
            return false;
        }
        if (this.zzc.zzf() || !((zzvu) this.zzc.zzb()).zza.equals(zzaf)) {
            this.zzx = zzaf;
        } else {
            this.zzx = ((zzvu) this.zzc.zzb()).zza;
        }
        boolean z = this.zzy;
        zzaf zzaf2 = this.zzx;
        this.zzy = z & zzbn.zzf(zzaf2.zzm, zzaf2.zzj);
        this.zzz = false;
        return true;
    }

    public final int zza() {
        return this.zzo;
    }

    public final int zzb() {
        return this.zzo + this.zzq;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r9 != -1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzc(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.zzq     // Catch:{ all -> 0x0038 }
            int r2 = r8.zzB(r0)     // Catch:{ all -> 0x0038 }
            boolean r1 = r8.zzK()     // Catch:{ all -> 0x0038 }
            r7 = 0
            if (r1 == 0) goto L_0x0036
            long[] r1 = r8.zzl     // Catch:{ all -> 0x0038 }
            r3 = r1[r2]     // Catch:{ all -> 0x0038 }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0017
            goto L_0x0036
        L_0x0017:
            long r3 = r8.zzt     // Catch:{ all -> 0x0038 }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0025
            if (r11 != 0) goto L_0x0020
            goto L_0x0025
        L_0x0020:
            int r9 = r8.zzn     // Catch:{ all -> 0x0038 }
            int r9 = r9 - r0
            monitor-exit(r8)
            return r9
        L_0x0025:
            int r11 = r8.zzn     // Catch:{ all -> 0x0038 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x0038 }
            r10 = -1
            monitor-exit(r8)
            if (r9 != r10) goto L_0x0035
            return r7
        L_0x0035:
            return r9
        L_0x0036:
            monitor-exit(r8)
            return r7
        L_0x0038:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zzc(long, boolean):int");
    }

    public final int zzd() {
        return this.zzo + this.zzn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r9 != 0) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zze(com.google.android.gms.internal.ads.zzjz r9, com.google.android.gms.internal.ads.zzhd r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L_0x0007
            r5 = r1
            goto L_0x0009
        L_0x0007:
            r0 = 0
            r5 = r0
        L_0x0009:
            com.google.android.gms.internal.ads.zzvs r7 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.zzC(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L_0x003e
            boolean r9 = r10.zzf()
            if (r9 != 0) goto L_0x003d
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L_0x0034
            if (r9 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzvq r9 = r8.zza
            com.google.android.gms.internal.ads.zzvs r11 = r8.zzb
            r9.zzd(r10, r11)
            goto L_0x003d
        L_0x002c:
            com.google.android.gms.internal.ads.zzvq r9 = r8.zza
            com.google.android.gms.internal.ads.zzvs r11 = r8.zzb
            r9.zze(r10, r11)
            goto L_0x0037
        L_0x0034:
            if (r9 == 0) goto L_0x0037
            goto L_0x003d
        L_0x0037:
            int r9 = r8.zzq
            int r9 = r9 + r1
            r8.zzq = r9
            return r12
        L_0x003d:
            r9 = r12
        L_0x003e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zze(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzhd, int, boolean):int");
    }

    public final /* synthetic */ int zzf(zzp zzp2, int i, boolean z) {
        return zzadn.zza(this, zzp2, i, z);
    }

    public final int zzg(zzp zzp2, int i, boolean z, int i2) throws IOException {
        return this.zza.zza(zzp2, i, z);
    }

    public final synchronized long zzh() {
        return this.zzt;
    }

    public final synchronized zzaf zzi() {
        if (this.zzw) {
            return null;
        }
        return this.zzx;
    }

    public final void zzj(long j, boolean z, boolean z2) {
        this.zza.zzc(zzD(j, false, z2));
    }

    public final void zzk() {
        this.zza.zzc(zzE());
    }

    public final void zzl(zzaf zzaf) {
        boolean zzM = zzM(zzaf);
        zzvv zzvv = this.zze;
        if (zzvv != null && zzM) {
            zzvv.zzM(zzaf);
        }
    }

    public final void zzm() throws IOException {
        zzrj zzrj = this.zzA;
        if (zzrj != null) {
            throw zzrj.zza();
        }
    }

    public final void zzn() {
        zzk();
        zzI();
    }

    public final void zzo() {
        zzp(true);
        zzI();
    }

    public final void zzp(boolean z) {
        this.zza.zzf();
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzv = true;
        this.zzr = Long.MIN_VALUE;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = false;
        this.zzc.zzd();
        if (z) {
            this.zzx = null;
            this.zzw = true;
            this.zzy = true;
        }
    }

    public final /* synthetic */ void zzq(zzek zzek, int i) {
        zzadn.zzb(this, zzek, i);
    }

    public final void zzr(zzek zzek, int i, int i2) {
        this.zza.zzh(zzek, i);
    }

    public final void zzs(long j, int i, int i2, int i3, zzado zzado) {
        if (this.zzv) {
            if ((i & 1) != 0) {
                this.zzv = false;
            } else {
                return;
            }
        }
        if (this.zzy) {
            if (j < this.zzr) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzz) {
                    zzea.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzx)));
                    this.zzz = true;
                }
                i |= 1;
            }
        }
        zzG(j, i, (this.zza.zzb() - ((long) i2)) - ((long) i3), i2, zzado);
    }

    public final void zzt(long j) {
        this.zzr = j;
    }

    public final void zzu(zzvv zzvv) {
        this.zze = zzvv;
    }

    public final synchronized void zzv(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzq + i <= this.zzn) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzdi.zzd(z);
        this.zzq += i;
    }

    public final synchronized boolean zzw() {
        return this.zzu;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzx(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzK()     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 != 0) goto L_0x001d
            if (r4 != 0) goto L_0x001b
            boolean r4 = r3.zzu     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzaf r4 = r3.zzx     // Catch:{ all -> 0x003e }
            r0 = 0
            if (r4 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzaf r2 = r3.zzf     // Catch:{ all -> 0x003e }
            if (r4 == r2) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            monitor-exit(r3)
            return r0
        L_0x001a:
            r1 = r0
        L_0x001b:
            monitor-exit(r3)
            return r1
        L_0x001d:
            com.google.android.gms.internal.ads.zzwd r4 = r3.zzc     // Catch:{ all -> 0x003e }
            int r0 = r3.zzo     // Catch:{ all -> 0x003e }
            int r2 = r3.zzq     // Catch:{ all -> 0x003e }
            int r0 = r0 + r2
            java.lang.Object r4 = r4.zza(r0)     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzvu r4 = (com.google.android.gms.internal.ads.zzvu) r4     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzaf r4 = r4.zza     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzaf r0 = r3.zzf     // Catch:{ all -> 0x003e }
            if (r4 == r0) goto L_0x0032
            monitor-exit(r3)
            return r1
        L_0x0032:
            int r4 = r3.zzq     // Catch:{ all -> 0x003e }
            int r4 = r3.zzB(r4)     // Catch:{ all -> 0x003e }
            boolean r4 = r3.zzL(r4)     // Catch:{ all -> 0x003e }
            monitor-exit(r3)
            return r4
        L_0x003e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zzx(boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzy(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.zzJ()     // Catch:{ all -> 0x001b }
            int r0 = r3.zzo     // Catch:{ all -> 0x001b }
            if (r4 < r0) goto L_0x0018
            int r1 = r3.zzn     // Catch:{ all -> 0x001b }
            int r1 = r1 + r0
            if (r4 <= r1) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            r1 = -9223372036854775808
            r3.zzr = r1     // Catch:{ all -> 0x001b }
            int r4 = r4 - r0
            r3.zzq = r4     // Catch:{ all -> 0x001b }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0018:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x001b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zzy(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzz(long r11, boolean r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            r10.zzJ()     // Catch:{ all -> 0x0060 }
            int r0 = r10.zzq     // Catch:{ all -> 0x0060 }
            int r2 = r10.zzB(r0)     // Catch:{ all -> 0x0060 }
            boolean r1 = r10.zzK()     // Catch:{ all -> 0x0060 }
            r7 = 0
            if (r1 == 0) goto L_0x005e
            long[] r1 = r10.zzl     // Catch:{ all -> 0x0060 }
            r3 = r1[r2]     // Catch:{ all -> 0x0060 }
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x005e
            long r3 = r10.zzt     // Catch:{ all -> 0x0060 }
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            r8 = 1
            if (r1 <= 0) goto L_0x0023
            if (r13 == 0) goto L_0x005e
            r13 = r8
        L_0x0023:
            boolean r1 = r10.zzy     // Catch:{ all -> 0x0060 }
            r9 = -1
            if (r1 == 0) goto L_0x0047
            int r1 = r10.zzn     // Catch:{ all -> 0x0060 }
            int r1 = r1 - r0
            r0 = r7
        L_0x002c:
            if (r0 >= r1) goto L_0x0042
            long[] r3 = r10.zzl     // Catch:{ all -> 0x0060 }
            r4 = r3[r2]     // Catch:{ all -> 0x0060 }
            int r3 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x0040
            int r2 = r2 + 1
            int r3 = r10.zzg     // Catch:{ all -> 0x0060 }
            if (r2 != r3) goto L_0x003d
            r2 = r7
        L_0x003d:
            int r0 = r0 + 1
            goto L_0x002c
        L_0x0040:
            r1 = r0
            goto L_0x0052
        L_0x0042:
            if (r13 == 0) goto L_0x0045
            goto L_0x0052
        L_0x0045:
            r1 = r9
            goto L_0x0052
        L_0x0047:
            int r13 = r10.zzn     // Catch:{ all -> 0x0060 }
            int r3 = r13 - r0
            r6 = 1
            r1 = r10
            r4 = r11
            int r1 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x0060 }
        L_0x0052:
            if (r1 != r9) goto L_0x0055
            goto L_0x005e
        L_0x0055:
            r10.zzr = r11     // Catch:{ all -> 0x0060 }
            int r11 = r10.zzq     // Catch:{ all -> 0x0060 }
            int r11 = r11 + r1
            r10.zzq = r11     // Catch:{ all -> 0x0060 }
            monitor-exit(r10)
            return r8
        L_0x005e:
            monitor-exit(r10)
            return r7
        L_0x0060:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zzz(long, boolean):boolean");
    }
}
