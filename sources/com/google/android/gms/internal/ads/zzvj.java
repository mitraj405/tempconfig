package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzvj implements zzug, zzacn, zzyp, zzyu, zzvv {
    /* access modifiers changed from: private */
    public static final Map zzb;
    /* access modifiers changed from: private */
    public static final zzaf zzc;
    private zzadi zzA;
    /* access modifiers changed from: private */
    public long zzB;
    private boolean zzC;
    private int zzD;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    private boolean zzH;
    private long zzI;
    private long zzJ;
    private boolean zzK;
    private int zzL;
    private boolean zzM;
    private boolean zzN;
    private final zzyk zzO;
    private final Uri zzd;
    private final zzfs zze;
    private final zzri zzf;
    private final zzur zzg;
    private final zzrd zzh;
    private final zzvf zzi;
    /* access modifiers changed from: private */
    public final long zzj;
    private final long zzk;
    private final zzyx zzl = new zzyx("ProgressiveMediaPeriod");
    private final zzuy zzm;
    private final zzdm zzn;
    private final Runnable zzo;
    /* access modifiers changed from: private */
    public final Runnable zzp;
    /* access modifiers changed from: private */
    public final Handler zzq;
    private zzuf zzr;
    /* access modifiers changed from: private */
    public zzafn zzs;
    private zzvw[] zzt;
    private zzvh[] zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzvi zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", C0515Ga.AVLBLTY_ONLY);
        zzb = Collections.unmodifiableMap(hashMap);
        zzad zzad = new zzad();
        zzad.zzK("icy");
        zzad.zzX("application/x-icy");
        zzc = zzad.zzad();
    }

    public zzvj(Uri uri, zzfs zzfs, zzuy zzuy, zzri zzri, zzrd zzrd, zzyo zzyo, zzur zzur, zzvf zzvf, zzyk zzyk, String str, int i, long j) {
        this.zzd = uri;
        this.zze = zzfs;
        this.zzf = zzri;
        this.zzh = zzrd;
        this.zzg = zzur;
        this.zzi = zzvf;
        this.zzO = zzyk;
        this.zzj = (long) i;
        this.zzm = zzuy;
        this.zzk = j;
        this.zzn = new zzdm(zzdj.zza);
        this.zzo = new zzva(this);
        this.zzp = new zzvb(this);
        this.zzq = zzet.zzx((Handler.Callback) null);
        this.zzu = new zzvh[0];
        this.zzt = new zzvw[0];
        this.zzJ = -9223372036854775807L;
        this.zzD = 1;
    }

    private final int zzQ() {
        int i = 0;
        for (zzvw zzd2 : this.zzt) {
            i += zzd2.zzd();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public final long zzR(boolean z) {
        int i = 0;
        long j = Long.MIN_VALUE;
        while (true) {
            zzvw[] zzvwArr = this.zzt;
            if (i >= zzvwArr.length) {
                return j;
            }
            if (!z) {
                zzvi zzvi = this.zzz;
                zzvi.getClass();
                if (!zzvi.zzc[i]) {
                    i++;
                }
            }
            j = Math.max(j, zzvwArr[i].zzh());
            i++;
        }
    }

    private final zzadp zzS(zzvh zzvh) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzvh.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        zzvw zzvw = new zzvw(this.zzO, this.zzf, this.zzh);
        zzvw.zzu(this);
        int i2 = length + 1;
        zzvh[] zzvhArr = (zzvh[]) Arrays.copyOf(this.zzu, i2);
        zzvhArr[length] = zzvh;
        int i3 = zzet.zza;
        this.zzu = zzvhArr;
        zzvw[] zzvwArr = (zzvw[]) Arrays.copyOf(this.zzt, i2);
        zzvwArr[length] = zzvw;
        this.zzt = zzvwArr;
        return zzvw;
    }

    private final void zzT() {
        zzdi.zzf(this.zzw);
        this.zzz.getClass();
        this.zzA.getClass();
    }

    /* access modifiers changed from: private */
    public final void zzU() {
        boolean z;
        boolean z2;
        int i;
        zzbk zzbk;
        if (!this.zzN && !this.zzw && this.zzv && this.zzA != null) {
            zzvw[] zzvwArr = this.zzt;
            int length = zzvwArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (zzvwArr[i2].zzi() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.zzn.zzc();
            int length2 = this.zzt.length;
            zzcd[] zzcdArr = new zzcd[length2];
            boolean[] zArr = new boolean[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                zzaf zzi2 = this.zzt[i3].zzi();
                zzi2.getClass();
                String str = zzi2.zzm;
                boolean zzg2 = zzbn.zzg(str);
                if (zzg2 || zzbn.zzi(str)) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i3] = z;
                this.zzx = z | this.zzx;
                boolean zzh2 = zzbn.zzh(str);
                if (this.zzk == -9223372036854775807L || length2 != 1 || !zzh2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.zzy = z2;
                zzafn zzafn = this.zzs;
                if (zzafn != null) {
                    if (zzg2 || this.zzu[i3].zzb) {
                        zzbk zzbk2 = zzi2.zzk;
                        if (zzbk2 == null) {
                            zzbk = new zzbk(-9223372036854775807L, zzafn);
                        } else {
                            zzbk = zzbk2.zzc(zzafn);
                        }
                        zzad zzb2 = zzi2.zzb();
                        zzb2.zzQ(zzbk);
                        zzi2 = zzb2.zzad();
                    }
                    if (zzg2 && zzi2.zzg == -1 && zzi2.zzh == -1 && (i = zzafn.zza) != -1) {
                        zzad zzb3 = zzi2.zzb();
                        zzb3.zzx(i);
                        zzi2 = zzb3.zzad();
                    }
                }
                zzcdArr[i3] = new zzcd(Integer.toString(i3), zzi2.zzc(this.zzf.zza(zzi2)));
            }
            this.zzz = new zzvi(new zzwi(zzcdArr), zArr);
            if (this.zzy && this.zzB == -9223372036854775807L) {
                this.zzB = this.zzk;
                this.zzA = new zzvd(this, this.zzA);
            }
            this.zzi.zza(this.zzB, this.zzA.zzh(), this.zzC);
            this.zzw = true;
            zzuf zzuf = this.zzr;
            zzuf.getClass();
            zzuf.zzh(this);
        }
    }

    private final void zzV(int i) {
        zzT();
        zzvi zzvi = this.zzz;
        boolean[] zArr = zzvi.zzd;
        if (!zArr[i]) {
            zzaf zzb2 = zzvi.zza.zzb(i).zzb(0);
            this.zzg.zzc(new zzue(1, zzbn.zzb(zzb2.zzm), zzb2, 0, (Object) null, zzet.zzu(this.zzI), -9223372036854775807L));
            zArr[i] = true;
        }
    }

    private final void zzW(int i) {
        zzT();
        boolean[] zArr = this.zzz.zzb;
        if (this.zzK && zArr[i] && !this.zzt[i].zzx(false)) {
            this.zzJ = 0;
            this.zzK = false;
            this.zzF = true;
            this.zzI = 0;
            this.zzL = 0;
            for (zzvw zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            zzuf zzuf = this.zzr;
            zzuf.getClass();
            zzuf.zzf(this);
        }
    }

    private final void zzX() {
        zzve zzve = new zzve(this, this.zzd, this.zze, this.zzm, this, this.zzn);
        if (this.zzw) {
            zzdi.zzf(zzY());
            long j = this.zzB;
            if (j == -9223372036854775807L || this.zzJ <= j) {
                zzadi zzadi = this.zzA;
                zzadi.getClass();
                zzve.zzf(zzve, zzadi.zzg(this.zzJ).zza.zzc, this.zzJ);
                for (zzvw zzt2 : this.zzt) {
                    zzt2.zzt(this.zzJ);
                }
                this.zzJ = -9223372036854775807L;
            } else {
                this.zzM = true;
                this.zzJ = -9223372036854775807L;
                return;
            }
        }
        this.zzL = zzQ();
        long zza = this.zzl.zza(zzve, this, zzyo.zza(this.zzD));
        this.zzg.zzg(new zztz(zzve.zzb, zzve.zzl, zza), new zzue(1, -1, (zzaf) null, 0, (Object) null, zzet.zzu(zzve.zzk), zzet.zzu(this.zzB)));
    }

    private final boolean zzY() {
        if (this.zzJ != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    private final boolean zzZ() {
        if (this.zzF || zzY()) {
            return true;
        }
        return false;
    }

    public final void zzD() {
        this.zzv = true;
        this.zzq.post(this.zzo);
    }

    public final /* synthetic */ void zzE() {
        if (!this.zzN) {
            zzuf zzuf = this.zzr;
            zzuf.getClass();
            zzuf.zzf(this);
        }
    }

    public final /* synthetic */ void zzF() {
        this.zzH = true;
    }

    public final /* synthetic */ void zzG(zzadi zzadi) {
        zzadi zzadi2;
        if (this.zzs == null) {
            zzadi2 = zzadi;
        } else {
            zzadi2 = new zzadh(-9223372036854775807L, 0);
        }
        this.zzA = zzadi2;
        this.zzB = zzadi.zza();
        boolean z = false;
        int i = 1;
        if (!this.zzH && zzadi.zza() == -9223372036854775807L) {
            z = true;
        }
        this.zzC = z;
        if (true == z) {
            i = 7;
        }
        this.zzD = i;
        if (this.zzw) {
            this.zzi.zza(this.zzB, zzadi.zzh(), this.zzC);
        } else {
            zzU();
        }
    }

    public final void zzH() throws IOException {
        this.zzl.zzi(zzyo.zza(this.zzD));
    }

    public final void zzI(int i) throws IOException {
        this.zzt[i].zzm();
        zzH();
    }

    public final /* bridge */ /* synthetic */ void zzJ(zzyt zzyt, long j, long j2, boolean z) {
        zzve zzve = (zzve) zzyt;
        zzgt zze2 = zzve.zzd;
        zztz zztz = new zztz(zzve.zzb, zzve.zzl, zze2.zzh(), zze2.zzi(), j, j2, zze2.zzg());
        long unused = zzve.zzb;
        long zzc2 = zzve.zzk;
        long j3 = this.zzB;
        long zzu2 = zzet.zzu(zzc2);
        long zzu3 = zzet.zzu(j3);
        zzue zzue = r5;
        zzue zzue2 = new zzue(1, -1, (zzaf) null, 0, (Object) null, zzu2, zzu3);
        this.zzg.zzd(zztz, zzue);
        if (!z) {
            for (zzvw zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            if (this.zzG > 0) {
                zzuf zzuf = this.zzr;
                zzuf.getClass();
                zzuf.zzf(this);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzK(zzyt zzyt, long j, long j2) {
        zzadi zzadi;
        long j3;
        if (this.zzB == -9223372036854775807L && (zzadi = this.zzA) != null) {
            boolean zzh2 = zzadi.zzh();
            long zzR = zzR(true);
            if (zzR == Long.MIN_VALUE) {
                j3 = 0;
            } else {
                j3 = zzR + 10000;
            }
            this.zzB = j3;
            this.zzi.zza(j3, zzh2, this.zzC);
        }
        zzve zzve = (zzve) zzyt;
        zzgt zze2 = zzve.zzd;
        long zzb2 = zzve.zzb;
        zzfy zzd2 = zzve.zzl;
        Uri zzh3 = zze2.zzh();
        Map zzi2 = zze2.zzi();
        long zzg2 = zze2.zzg();
        zztz zztz = r4;
        zztz zztz2 = new zztz(zzb2, zzd2, zzh3, zzi2, j, j2, zzg2);
        long unused = zzve.zzb;
        this.zzg.zze(zztz, new zzue(1, -1, (zzaf) null, 0, (Object) null, zzet.zzu(zzve.zzk), zzet.zzu(this.zzB)));
        this.zzM = true;
        zzuf zzuf = this.zzr;
        zzuf.getClass();
        zzuf.zzf(this);
    }

    public final void zzL() {
        for (zzvw zzo2 : this.zzt) {
            zzo2.zzo();
        }
        this.zzm.zze();
    }

    public final void zzM(zzaf zzaf) {
        this.zzq.post(this.zzo);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzvw zzn2 : this.zzt) {
                zzn2.zzn();
            }
        }
        this.zzl.zzj(this);
        this.zzq.removeCallbacksAndMessages((Object) null);
        this.zzr = null;
        this.zzN = true;
    }

    public final void zzO(zzadi zzadi) {
        this.zzq.post(new zzvc(this, zzadi));
    }

    public final boolean zzP(int i) {
        if (zzZ() || !this.zzt[i].zzx(this.zzM)) {
            return false;
        }
        return true;
    }

    public final long zza(long j, zzlj zzlj) {
        boolean z;
        long j2 = j;
        zzlj zzlj2 = zzlj;
        zzT();
        if (!this.zzA.zzh()) {
            return 0;
        }
        zzadg zzg2 = this.zzA.zzg(j2);
        zzadj zzadj = zzg2.zza;
        zzadj zzadj2 = zzg2.zzb;
        long j3 = zzlj2.zzc;
        if (j3 == 0) {
            if (zzlj2.zzd == 0) {
                return j2;
            }
            j3 = 0;
        }
        long j4 = zzadj.zzb;
        int i = zzet.zza;
        long j5 = j2 - j3;
        long j6 = zzlj2.zzd;
        long j7 = j2 + j6;
        long j8 = j2 ^ j7;
        long j9 = j6 ^ j7;
        if (((j2 ^ j3) & (j2 ^ j5)) < 0) {
            j5 = Long.MIN_VALUE;
        }
        if ((j8 & j9) < 0) {
            j7 = Long.MAX_VALUE;
        }
        boolean z2 = true;
        if (j5 > j4 || j4 > j7) {
            z = false;
        } else {
            z = true;
        }
        long j10 = zzadj2.zzb;
        if (j5 > j10 || j10 > j7) {
            z2 = false;
        }
        if (z && z2) {
            if (Math.abs(j4 - j2) > Math.abs(j10 - j2)) {
                return j10;
            }
        } else if (!z) {
            if (z2) {
                return j10;
            }
            return j5;
        }
        return j4;
    }

    public final long zzb() {
        long j;
        zzT();
        if (this.zzM || this.zzG == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzJ;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzvi zzvi = this.zzz;
                if (zzvi.zzb[i] && zzvi.zzc[i] && !this.zzt[i].zzw()) {
                    j = Math.min(j, this.zzt[i].zzh());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = zzR(false);
        }
        if (j == Long.MIN_VALUE) {
            return this.zzI;
        }
        return j;
    }

    public final long zzc() {
        return zzb();
    }

    public final long zzd() {
        if (!this.zzF) {
            return -9223372036854775807L;
        }
        if (!this.zzM && zzQ() <= this.zzL) {
            return -9223372036854775807L;
        }
        this.zzF = false;
        return this.zzI;
    }

    public final long zze(long j) {
        boolean z;
        zzT();
        boolean[] zArr = this.zzz.zzb;
        if (true != this.zzA.zzh()) {
            j = 0;
        }
        this.zzF = false;
        this.zzI = j;
        if (zzY()) {
            this.zzJ = j;
            return j;
        }
        if (this.zzD != 7) {
            int length = this.zzt.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                zzvw zzvw = this.zzt[i];
                if (this.zzy) {
                    z = zzvw.zzy(zzvw.zza());
                } else {
                    z = zzvw.zzz(j, false);
                }
                if (!z && (zArr[i] || !this.zzx)) {
                    break;
                }
                i++;
            }
            return j;
        }
        this.zzK = false;
        this.zzJ = j;
        this.zzM = false;
        zzyx zzyx = this.zzl;
        if (zzyx.zzl()) {
            for (zzvw zzk2 : this.zzt) {
                zzk2.zzk();
            }
            this.zzl.zzg();
        } else {
            zzyx.zzh();
            for (zzvw zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
        }
        return j;
    }

    public final int zzf(int i, zzjz zzjz, zzhd zzhd, int i2) {
        if (zzZ()) {
            return -3;
        }
        zzV(i);
        int zze2 = this.zzt[i].zze(zzjz, zzhd, i2, this.zzM);
        if (zze2 == -3) {
            zzW(i);
        }
        return zze2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if (r2 == 0) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzg(com.google.android.gms.internal.ads.zzxv[] r8, boolean[] r9, com.google.android.gms.internal.ads.zzvx[] r10, boolean[] r11, long r12) {
        /*
            r7 = this;
            r7.zzT()
            com.google.android.gms.internal.ads.zzvi r0 = r7.zzz
            com.google.android.gms.internal.ads.zzwi r1 = r0.zza
            boolean[] r0 = r0.zzc
            int r2 = r7.zzG
            r3 = 0
            r4 = r3
        L_0x000d:
            int r5 = r8.length
            if (r4 >= r5) goto L_0x0035
            r5 = r10[r4]
            if (r5 == 0) goto L_0x0032
            r6 = r8[r4]
            if (r6 == 0) goto L_0x001c
            boolean r6 = r9[r4]
            if (r6 != 0) goto L_0x0032
        L_0x001c:
            com.google.android.gms.internal.ads.zzvg r5 = (com.google.android.gms.internal.ads.zzvg) r5
            int r5 = r5.zzb
            boolean r6 = r0[r5]
            com.google.android.gms.internal.ads.zzdi.zzf(r6)
            int r6 = r7.zzG
            int r6 = r6 + -1
            r7.zzG = r6
            r0[r5] = r3
            r5 = 0
            r10[r4] = r5
        L_0x0032:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0035:
            boolean r9 = r7.zzy
            r4 = 1
            if (r9 != 0) goto L_0x004c
            boolean r9 = r7.zzE
            if (r9 == 0) goto L_0x0041
            if (r2 != 0) goto L_0x004c
            goto L_0x0047
        L_0x0041:
            r5 = 0
            int r9 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0049
        L_0x0047:
            r9 = r4
            goto L_0x004d
        L_0x0049:
            r9 = r3
            r12 = r5
            goto L_0x004d
        L_0x004c:
            r9 = r3
        L_0x004d:
            r2 = r3
        L_0x004e:
            int r5 = r8.length
            if (r2 >= r5) goto L_0x00a7
            r5 = r10[r2]
            if (r5 != 0) goto L_0x00a4
            r5 = r8[r2]
            if (r5 == 0) goto L_0x00a4
            int r6 = r5.zzc()
            if (r6 != r4) goto L_0x0061
            r6 = r4
            goto L_0x0062
        L_0x0061:
            r6 = r3
        L_0x0062:
            com.google.android.gms.internal.ads.zzdi.zzf(r6)
            int r6 = r5.zza(r3)
            if (r6 != 0) goto L_0x006d
            r6 = r4
            goto L_0x006e
        L_0x006d:
            r6 = r3
        L_0x006e:
            com.google.android.gms.internal.ads.zzdi.zzf(r6)
            com.google.android.gms.internal.ads.zzcd r5 = r5.zze()
            int r5 = r1.zza(r5)
            boolean r6 = r0[r5]
            r6 = r6 ^ r4
            com.google.android.gms.internal.ads.zzdi.zzf(r6)
            int r6 = r7.zzG
            int r6 = r6 + r4
            r7.zzG = r6
            r0[r5] = r4
            com.google.android.gms.internal.ads.zzvg r6 = new com.google.android.gms.internal.ads.zzvg
            r6.<init>(r7, r5)
            r10[r2] = r6
            r11[r2] = r4
            if (r9 != 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzvw[] r9 = r7.zzt
            r9 = r9[r5]
            int r5 = r9.zzb()
            if (r5 == 0) goto L_0x00a3
            boolean r9 = r9.zzz(r12, r4)
            if (r9 != 0) goto L_0x00a3
            r9 = r4
            goto L_0x00a4
        L_0x00a3:
            r9 = r3
        L_0x00a4:
            int r2 = r2 + 1
            goto L_0x004e
        L_0x00a7:
            int r8 = r7.zzG
            if (r8 != 0) goto L_0x00d8
            r7.zzK = r3
            r7.zzF = r3
            com.google.android.gms.internal.ads.zzyx r8 = r7.zzl
            boolean r8 = r8.zzl()
            if (r8 == 0) goto L_0x00ca
            com.google.android.gms.internal.ads.zzvw[] r8 = r7.zzt
            int r9 = r8.length
        L_0x00ba:
            if (r3 >= r9) goto L_0x00c4
            r10 = r8[r3]
            r10.zzk()
            int r3 = r3 + 1
            goto L_0x00ba
        L_0x00c4:
            com.google.android.gms.internal.ads.zzyx r8 = r7.zzl
            r8.zzg()
            goto L_0x00ea
        L_0x00ca:
            com.google.android.gms.internal.ads.zzvw[] r8 = r7.zzt
            int r9 = r8.length
            r10 = r3
        L_0x00ce:
            if (r10 >= r9) goto L_0x00ea
            r11 = r8[r10]
            r11.zzp(r3)
            int r10 = r10 + 1
            goto L_0x00ce
        L_0x00d8:
            if (r9 == 0) goto L_0x00ea
            long r12 = r7.zze(r12)
        L_0x00de:
            int r8 = r10.length
            if (r3 >= r8) goto L_0x00ea
            r8 = r10[r3]
            if (r8 == 0) goto L_0x00e7
            r11[r3] = r4
        L_0x00e7:
            int r3 = r3 + 1
            goto L_0x00de
        L_0x00ea:
            r7.zzE = r4
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zzg(com.google.android.gms.internal.ads.zzxv[], boolean[], com.google.android.gms.internal.ads.zzvx[], boolean[], long):long");
    }

    public final int zzh(int i, long j) {
        if (zzZ()) {
            return 0;
        }
        zzV(i);
        zzvw zzvw = this.zzt[i];
        int zzc2 = zzvw.zzc(j, this.zzM);
        zzvw.zzv(zzc2);
        if (zzc2 != 0) {
            return zzc2;
        }
        zzW(i);
        return 0;
    }

    public final zzwi zzi() {
        zzT();
        return this.zzz.zza;
    }

    public final void zzj(long j, boolean z) {
        if (!this.zzy) {
            zzT();
            if (!zzY()) {
                boolean[] zArr = this.zzz.zzc;
                int length = this.zzt.length;
                for (int i = 0; i < length; i++) {
                    this.zzt[i].zzj(j, false, zArr[i]);
                }
            }
        }
    }

    public final void zzk() throws IOException {
        zzH();
        if (this.zzM && !this.zzw) {
            throw zzbo.zza("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public final void zzl(zzuf zzuf, long j) {
        this.zzr = zzuf;
        this.zzn.zze();
        zzX();
    }

    public final boolean zzo(zzkf zzkf) {
        if (this.zzM) {
            return false;
        }
        zzyx zzyx = this.zzl;
        if (zzyx.zzk() || this.zzK) {
            return false;
        }
        if (this.zzw && this.zzG == 0) {
            return false;
        }
        boolean zze2 = this.zzn.zze();
        if (zzyx.zzl()) {
            return zze2;
        }
        zzX();
        return true;
    }

    public final boolean zzp() {
        if (!this.zzl.zzl() || !this.zzn.zzd()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zzyr zzu(com.google.android.gms.internal.ads.zzyt r22, long r23, long r25, java.io.IOException r27, int r28) {
        /*
            r21 = this;
            r0 = r21
            r1 = r27
            r2 = r22
            com.google.android.gms.internal.ads.zzve r2 = (com.google.android.gms.internal.ads.zzve) r2
            com.google.android.gms.internal.ads.zzgt r3 = r2.zzd
            com.google.android.gms.internal.ads.zztz r14 = new com.google.android.gms.internal.ads.zztz
            long r5 = r2.zzb
            com.google.android.gms.internal.ads.zzfy r7 = r2.zzl
            android.net.Uri r8 = r3.zzh()
            java.util.Map r9 = r3.zzi()
            long r15 = r3.zzg()
            r4 = r14
            r10 = r23
            r12 = r25
            r3 = r14
            r14 = r15
            r4.<init>(r5, r7, r8, r9, r10, r12, r14)
            long unused = r2.zzk
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzbo
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof java.io.FileNotFoundException
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzgk
            if (r4 != 0) goto L_0x0068
            boolean r4 = r1 instanceof com.google.android.gms.internal.ads.zzyw
            if (r4 != 0) goto L_0x0068
            r4 = r1
        L_0x0047:
            if (r4 == 0) goto L_0x005c
            boolean r7 = r4 instanceof com.google.android.gms.internal.ads.zzft
            if (r7 == 0) goto L_0x0057
            r7 = r4
            com.google.android.gms.internal.ads.zzft r7 = (com.google.android.gms.internal.ads.zzft) r7
            int r7 = r7.zza
            r8 = 2008(0x7d8, float:2.814E-42)
            if (r7 != r8) goto L_0x0057
            goto L_0x0068
        L_0x0057:
            java.lang.Throwable r4 = r4.getCause()
            goto L_0x0047
        L_0x005c:
            int r4 = r28 + -1
            int r4 = r4 * 1000
            r7 = 5000(0x1388, float:7.006E-42)
            int r4 = java.lang.Math.min(r4, r7)
            long r7 = (long) r4
            goto L_0x0069
        L_0x0068:
            r7 = r5
        L_0x0069:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            r9 = 1
            if (r4 != 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzyr r4 = com.google.android.gms.internal.ads.zzyx.zzb
            goto L_0x00bd
        L_0x0071:
            int r4 = r21.zzQ()
            int r10 = r0.zzL
            r11 = 0
            if (r4 <= r10) goto L_0x007c
            r10 = r9
            goto L_0x007d
        L_0x007c:
            r10 = r11
        L_0x007d:
            boolean r12 = r0.zzH
            if (r12 != 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzadi r12 = r0.zzA
            if (r12 == 0) goto L_0x008e
            long r12 = r12.zza()
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x008e
            goto L_0x00b7
        L_0x008e:
            boolean r4 = r0.zzw
            if (r4 == 0) goto L_0x009d
            boolean r5 = r21.zzZ()
            if (r5 != 0) goto L_0x009d
            r0.zzK = r9
            com.google.android.gms.internal.ads.zzyr r4 = com.google.android.gms.internal.ads.zzyx.zza
            goto L_0x00bd
        L_0x009d:
            r0.zzF = r4
            r4 = 0
            r0.zzI = r4
            r0.zzL = r11
            com.google.android.gms.internal.ads.zzvw[] r6 = r0.zzt
            int r12 = r6.length
            r13 = r11
        L_0x00a9:
            if (r13 >= r12) goto L_0x00b3
            r14 = r6[r13]
            r14.zzp(r11)
            int r13 = r13 + 1
            goto L_0x00a9
        L_0x00b3:
            com.google.android.gms.internal.ads.zzve.zzf(r2, r4, r4)
            goto L_0x00b9
        L_0x00b7:
            r0.zzL = r4
        L_0x00b9:
            com.google.android.gms.internal.ads.zzyr r4 = com.google.android.gms.internal.ads.zzyx.zzb(r10, r7)
        L_0x00bd:
            boolean r5 = r4.zzc()
            r5 = r5 ^ r9
            com.google.android.gms.internal.ads.zzur r6 = r0.zzg
            long r7 = r2.zzk
            long r9 = r0.zzB
            long r17 = com.google.android.gms.internal.ads.zzet.zzu(r7)
            long r19 = com.google.android.gms.internal.ads.zzet.zzu(r9)
            com.google.android.gms.internal.ads.zzue r7 = new com.google.android.gms.internal.ads.zzue
            r12 = 1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r11 = r7
            r11.<init>(r12, r13, r14, r15, r16, r17, r19)
            r6.zzf(r3, r7, r1, r5)
            if (r5 == 0) goto L_0x00e6
            long unused = r2.zzb
        L_0x00e6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zzu(com.google.android.gms.internal.ads.zzyt, long, long, java.io.IOException, int):com.google.android.gms.internal.ads.zzyr");
    }

    public final zzadp zzv() {
        return zzS(new zzvh(0, true));
    }

    public final zzadp zzw(int i, int i2) {
        return zzS(new zzvh(i, false));
    }

    public final void zzm(long j) {
    }
}
