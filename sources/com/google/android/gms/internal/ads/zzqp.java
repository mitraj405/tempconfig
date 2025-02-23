package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzqp implements zzpl {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private zzbq zzA;
    private boolean zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private int zzG;
    private boolean zzH;
    private boolean zzI;
    private long zzJ;
    private float zzK;
    private ByteBuffer zzL;
    private int zzM;
    private ByteBuffer zzN;
    private boolean zzO;
    private boolean zzP;
    /* access modifiers changed from: private */
    public boolean zzQ;
    private boolean zzR;
    private int zzS;
    private zzi zzT;
    private zzon zzU;
    /* access modifiers changed from: private */
    public long zzV;
    private boolean zzW;
    private boolean zzX;
    private Looper zzY;
    private long zzZ;
    private long zzaa;
    private Handler zzab;
    private final zzqd zzac;
    private final zzpt zzad;
    private final Context zzd;
    private final zzpq zze;
    private final zzqz zzf;
    private final zzfxr zzg;
    private final zzfxr zzh;
    private final zzdm zzi;
    private final zzpp zzj;
    private final ArrayDeque zzk;
    private zzqn zzl;
    private final zzqi zzm;
    private final zzqi zzn;
    private zznz zzo;
    /* access modifiers changed from: private */
    public zzpi zzp;
    private zzqc zzq;
    private zzqc zzr;
    private zzcq zzs;
    /* access modifiers changed from: private */
    public AudioTrack zzt;
    private zzof zzu;
    private zzom zzv;
    private zzqh zzw;
    private zzh zzx;
    private zzqf zzy;
    private zzqf zzz;

    public /* synthetic */ zzqp(zzqb zzqb, zzqo zzqo) {
        zzof zzof;
        Context zza2 = zzqb.zza;
        this.zzd = zza2;
        zzh zzh2 = zzh.zza;
        this.zzx = zzh2;
        if (zza2 != null) {
            zzof zzof2 = zzof.zza;
            int i = zzet.zza;
            zzof = zzof.zzc(zza2, zzh2, (zzon) null);
        } else {
            zzof = zzqb.zzb;
        }
        this.zzu = zzof;
        this.zzac = zzqb.zze;
        int i2 = zzet.zza;
        zzpt zze2 = zzqb.zzf;
        zze2.getClass();
        this.zzad = zze2;
        zzdm zzdm = new zzdm(zzdj.zza);
        this.zzi = zzdm;
        zzdm.zze();
        this.zzj = new zzpp(new zzqk(this, (zzqj) null));
        zzpq zzpq = new zzpq();
        this.zze = zzpq;
        zzqz zzqz = new zzqz();
        this.zzf = zzqz;
        this.zzg = zzfxr.zzp(new zzcx(), zzpq, zzqz);
        this.zzh = zzfxr.zzn(new zzqy());
        this.zzK = 1.0f;
        this.zzS = 0;
        this.zzT = new zzi(0, 0.0f);
        zzbq zzbq = zzbq.zza;
        this.zzz = new zzqf(zzbq, 0, 0, (zzqe) null);
        this.zzA = zzbq;
        this.zzB = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzqi(100);
        this.zzn = new zzqi(100);
    }

    public static /* synthetic */ void zzF(zzqp zzqp) {
        if (zzqp.zzaa >= 300000) {
            ((zzqu) zzqp.zzp).zza.zzm = true;
            zzqp.zzaa = 0;
        }
    }

    public static /* synthetic */ void zzH(AudioTrack audioTrack, zzpi zzpi, Handler handler, zzpf zzpf, zzdm zzdm) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzpi != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzpv(zzpi, zzpf));
            }
            zzdm.zze();
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzpi != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzpv(zzpi, zzpf));
            }
            zzdm.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public final long zzJ() {
        zzqc zzqc = this.zzr;
        if (zzqc.zzc == 0) {
            return this.zzC / ((long) zzqc.zzb);
        }
        return this.zzD;
    }

    /* access modifiers changed from: private */
    public final long zzK() {
        zzqc zzqc = this.zzr;
        if (zzqc.zzc != 0) {
            return this.zzF;
        }
        long j = this.zzE;
        long j2 = (long) zzqc.zzd;
        int i = zzet.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzL(zzqc zzqc) throws zzph {
        try {
            return zzqc.zza(this.zzx, this.zzS);
        } catch (zzph e) {
            zzpi zzpi = this.zzp;
            if (zzpi != null) {
                zzpi.zza(e);
            }
            throw e;
        }
    }

    private final void zzM(long j) {
        zzbq zzbq;
        boolean z;
        if (zzY()) {
            zzqd zzqd = this.zzac;
            zzbq = this.zzA;
            zzqd.zzc(zzbq);
        } else {
            zzbq = zzbq.zza;
        }
        zzbq zzbq2 = zzbq;
        this.zzA = zzbq2;
        if (zzY()) {
            zzqd zzqd2 = this.zzac;
            z = this.zzB;
            zzqd2.zzd(z);
        } else {
            z = false;
        }
        this.zzB = z;
        this.zzk.add(new zzqf(zzbq2, Math.max(0, j), zzet.zzs(zzK(), this.zzr.zze), (zzqe) null));
        zzT();
        zzpi zzpi = this.zzp;
        if (zzpi != null) {
            ((zzqu) zzpi).zza.zzc.zzw(this.zzB);
        }
    }

    private final void zzN() {
        if (this.zzr.zzc()) {
            this.zzW = true;
        }
    }

    private final void zzO() {
        if (this.zzv == null && this.zzd != null) {
            this.zzY = Looper.myLooper();
            zzom zzom = new zzom(this.zzd, new zzpx(this), this.zzx, this.zzU);
            this.zzv = zzom;
            this.zzu = zzom.zzc();
        }
    }

    private final void zzP() {
        if (!this.zzP) {
            this.zzP = true;
            this.zzj.zzb(zzK());
            if (zzX(this.zzt)) {
                this.zzQ = false;
            }
            this.zzt.stop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r0.hasRemaining() == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r2.zzs.zze(r2.zzL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = r2.zzL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r0 == null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzQ(long r3) throws com.google.android.gms.internal.ads.zzpk {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzcq r0 = r2.zzs
            boolean r0 = r0.zzh()
            if (r0 == 0) goto L_0x0039
        L_0x0008:
            com.google.android.gms.internal.ads.zzcq r0 = r2.zzs
            boolean r0 = r0.zzg()
            if (r0 != 0) goto L_0x0038
        L_0x0010:
            com.google.android.gms.internal.ads.zzcq r0 = r2.zzs
            java.nio.ByteBuffer r0 = r0.zzb()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x0026
            r2.zzU(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x0010
            goto L_0x0038
        L_0x0026:
            java.nio.ByteBuffer r0 = r2.zzL
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzcq r0 = r2.zzs
            java.nio.ByteBuffer r1 = r2.zzL
            r0.zze(r1)
            goto L_0x0008
        L_0x0038:
            return
        L_0x0039:
            java.nio.ByteBuffer r0 = r2.zzL
            if (r0 != 0) goto L_0x003f
            java.nio.ByteBuffer r0 = com.google.android.gms.internal.ads.zzct.zza
        L_0x003f:
            r2.zzU(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqp.zzQ(long):void");
    }

    private final void zzR(zzbq zzbq) {
        zzqf zzqf = new zzqf(zzbq, -9223372036854775807L, -9223372036854775807L, (zzqe) null);
        if (zzW()) {
            this.zzy = zzqf;
        } else {
            this.zzz = zzqf;
        }
    }

    private final void zzS() {
        if (zzW()) {
            int i = zzet.zza;
            this.zzt.setVolume(this.zzK);
        }
    }

    private final void zzT() {
        zzcq zzcq = this.zzr.zzi;
        this.zzs = zzcq;
        zzcq.zzc();
    }

    private final void zzU(ByteBuffer byteBuffer, long j) throws zzpk {
        zzpi zzpi;
        boolean z;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzN;
            boolean z2 = false;
            if (byteBuffer2 != null) {
                if (byteBuffer2 == byteBuffer) {
                    z = true;
                } else {
                    z = false;
                }
                zzdi.zzd(z);
            } else {
                this.zzN = byteBuffer;
                int i = zzet.zza;
            }
            int remaining = byteBuffer.remaining();
            int i2 = zzet.zza;
            int write = this.zzt.write(byteBuffer, remaining, 1);
            this.zzV = SystemClock.elapsedRealtime();
            if (write < 0) {
                if ((zzet.zza >= 24 && write == -6) || write == -32) {
                    if (zzK() <= 0) {
                        if (zzX(this.zzt)) {
                            zzN();
                        }
                    }
                    z2 = true;
                }
                zzpk zzpk = new zzpk(write, this.zzr.zza, z2);
                zzpi zzpi2 = this.zzp;
                if (zzpi2 != null) {
                    zzpi2.zza(zzpk);
                }
                if (!zzpk.zzb) {
                    this.zzn.zzb(zzpk);
                } else {
                    this.zzu = zzof.zza;
                    throw zzpk;
                }
            } else {
                this.zzn.zza();
                if (zzX(this.zzt)) {
                    if (this.zzF > 0) {
                        this.zzX = false;
                    }
                    if (this.zzR && (zzpi = this.zzp) != null && write < remaining) {
                        zzqu zzqu = (zzqu) zzpi;
                    }
                }
                int i3 = this.zzr.zzc;
                if (i3 == 0) {
                    this.zzE += (long) write;
                }
                if (write == remaining) {
                    if (i3 != 0) {
                        if (byteBuffer == this.zzL) {
                            z2 = true;
                        }
                        zzdi.zzf(z2);
                        this.zzF = (((long) this.zzG) * ((long) this.zzM)) + this.zzF;
                    }
                    this.zzN = null;
                }
            }
        }
    }

    private final boolean zzV() throws zzpk {
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzN;
            if (byteBuffer == null) {
                return true;
            }
            zzU(byteBuffer, Long.MIN_VALUE);
            if (this.zzN == null) {
                return true;
            }
            return false;
        }
        this.zzs.zzd();
        zzQ(Long.MIN_VALUE);
        if (!this.zzs.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzN;
        if (byteBuffer2 == null) {
            return true;
        }
        if (byteBuffer2.hasRemaining()) {
            return false;
        }
        return true;
    }

    private final boolean zzW() {
        if (this.zzt != null) {
            return true;
        }
        return false;
    }

    private static boolean zzX(AudioTrack audioTrack) {
        if (zzet.zza < 29 || !audioTrack.isOffloadedPlayback()) {
            return false;
        }
        return true;
    }

    private final boolean zzY() {
        zzqc zzqc = this.zzr;
        if (zzqc.zzc != 0) {
            return false;
        }
        int i = zzqc.zza.zzB;
        return true;
    }

    public final void zzI(zzof zzof) {
        String str;
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zzY;
        if (looper != myLooper) {
            String str2 = "null";
            if (looper == null) {
                str = str2;
            } else {
                str = looper.getThread().getName();
            }
            if (myLooper != null) {
                str2 = myLooper.getThread().getName();
            }
            throw new IllegalStateException(C1058d.A("Current looper (", str2, ") is not the playback looper (", str, ")"));
        } else if (!zzof.equals(this.zzu)) {
            this.zzu = zzof;
            zzpi zzpi = this.zzp;
            if (zzpi != null) {
                ((zzqu) zzpi).zza.zzB();
            }
        }
    }

    public final int zza(zzaf zzaf) {
        zzO();
        if ("audio/raw".equals(zzaf.zzm)) {
            if (!zzet.zzK(zzaf.zzB)) {
                C0709Uj.t("Invalid PCM encoding: ", zzaf.zzB, "DefaultAudioSink");
                return 0;
            } else if (zzaf.zzB != 2) {
                return 1;
            } else {
                return 2;
            }
        } else if (this.zzu.zzb(zzaf, this.zzx) != null) {
            return 2;
        } else {
            return 0;
        }
    }

    public final long zzb(boolean z) {
        long j;
        if (!zzW() || this.zzI) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzj.zza(z), zzet.zzs(zzK(), this.zzr.zze));
        while (!this.zzk.isEmpty() && min >= ((zzqf) this.zzk.getFirst()).zzc) {
            this.zzz = (zzqf) this.zzk.remove();
        }
        long j2 = min - this.zzz.zzc;
        if (this.zzk.isEmpty()) {
            j = this.zzz.zzb + this.zzac.zza(j2);
        } else {
            zzqf zzqf = (zzqf) this.zzk.getFirst();
            j = zzqf.zzb - zzet.zzp(zzqf.zzc - min, this.zzz.zza.zzb);
        }
        long zzb2 = this.zzac.zzb();
        long zzs2 = zzet.zzs(zzb2, this.zzr.zze) + j;
        long j3 = this.zzZ;
        if (zzb2 > j3) {
            long zzs3 = zzet.zzs(zzb2 - j3, this.zzr.zze);
            this.zzZ = zzb2;
            this.zzaa += zzs3;
            if (this.zzab == null) {
                this.zzab = new Handler(Looper.myLooper());
            }
            this.zzab.removeCallbacksAndMessages((Object) null);
            this.zzab.postDelayed(new zzpw(this), 100);
        }
        return zzs2;
    }

    public final zzbq zzc() {
        return this.zzA;
    }

    public final zzoq zzd(zzaf zzaf) {
        if (this.zzW) {
            return zzoq.zza;
        }
        return this.zzad.zza(zzaf, this.zzx);
    }

    public final void zze(zzaf zzaf, int i, int[] iArr) throws zzpg {
        zzcq zzcq;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9;
        int i10;
        int i11;
        zzaf zzaf2 = zzaf;
        zzO();
        if ("audio/raw".equals(zzaf2.zzm)) {
            zzdi.zzd(zzet.zzK(zzaf2.zzB));
            i7 = zzet.zzm(zzaf2.zzB, zzaf2.zzz);
            zzfxo zzfxo = new zzfxo();
            zzfxo.zzh(this.zzg);
            zzfxo.zzg(this.zzac.zze());
            zzcq zzcq2 = new zzcq(zzfxo.zzi());
            if (zzcq2.equals(this.zzs)) {
                zzcq2 = this.zzs;
            }
            this.zzf.zzq(zzaf2.zzC, zzaf2.zzD);
            this.zze.zzo(iArr);
            try {
                zzcr zza2 = zzcq2.zza(new zzcr(zzaf2.zzA, zzaf2.zzz, zzaf2.zzB));
                i4 = zza2.zzd;
                i3 = zza2.zzb;
                int i12 = zza2.zzc;
                i2 = zzet.zzh(i12);
                zzcq = zzcq2;
                i5 = zzet.zzm(i4, i12);
                i6 = 0;
            } catch (zzcs e) {
                throw new zzpg((Throwable) e, zzaf2);
            }
        } else {
            zzcq zzcq3 = new zzcq(zzfxr.zzm());
            int i13 = zzaf2.zzA;
            zzoq zzoq = zzoq.zza;
            Pair zzb2 = this.zzu.zzb(zzaf2, this.zzx);
            if (zzb2 != null) {
                i4 = ((Integer) zzb2.first).intValue();
                zzcq = zzcq3;
                i7 = -1;
                i2 = ((Integer) zzb2.second).intValue();
                i5 = -1;
                i3 = i13;
                i6 = 2;
            } else {
                throw new zzpg("Unable to configure passthrough for: ".concat(String.valueOf(zzaf)), zzaf2);
            }
        }
        if (i4 == 0) {
            throw new zzpg("Invalid output encoding (mode=" + i6 + ") for: " + String.valueOf(zzaf), zzaf2);
        } else if (i2 != 0) {
            int i14 = zzaf2.zzi;
            if ("audio/vnd.dts.hd;profile=lbr".equals(zzaf2.zzm) && i14 == -1) {
                i14 = 768000;
            }
            int minBufferSize = AudioTrack.getMinBufferSize(i3, i2, i4);
            if (minBufferSize != -2) {
                z = true;
            } else {
                z = false;
            }
            zzdi.zzf(z);
            if (i5 != -1) {
                i8 = i5;
            } else {
                i8 = 1;
            }
            int i15 = 250000;
            if (i6 == 0) {
                i9 = i6;
                i10 = Math.max(zzqr.zza(250000, i3, i8), Math.min(minBufferSize * 4, zzqr.zza(750000, i3, i8)));
            } else if (i6 != 1) {
                if (i4 == 5) {
                    i15 = 500000;
                } else if (i4 == 8) {
                    i15 = 1000000;
                    i4 = 8;
                }
                if (i14 != -1) {
                    i11 = zzgah.zzb(i14, 8, RoundingMode.CEILING);
                } else {
                    i11 = zzqr.zzb(i4);
                }
                i9 = i6;
                i10 = zzgap.zzb((((long) i15) * ((long) i11)) / 1000000);
            } else {
                i9 = i6;
                i10 = zzgap.zzb((((long) zzqr.zzb(i4)) * 50000000) / 1000000);
            }
            this.zzW = false;
            zzqc zzqc = new zzqc(zzaf, i7, i9, i5, i3, i2, i4, (((Math.max(minBufferSize, (int) ((double) i10)) + i8) - 1) / i8) * i8, zzcq, false, false, false);
            if (zzW()) {
                this.zzq = zzqc;
            } else {
                this.zzr = zzqc;
            }
        } else {
            throw new zzpg("Invalid output channel config (mode=" + i6 + ") for: " + String.valueOf(zzaf), zzaf2);
        }
    }

    public final void zzf() {
        zzqh zzqh;
        if (zzW()) {
            this.zzC = 0;
            this.zzD = 0;
            this.zzE = 0;
            this.zzF = 0;
            this.zzX = false;
            this.zzG = 0;
            this.zzz = new zzqf(this.zzA, 0, 0, (zzqe) null);
            this.zzJ = 0;
            this.zzy = null;
            this.zzk.clear();
            this.zzL = null;
            this.zzM = 0;
            this.zzN = null;
            this.zzP = false;
            this.zzO = false;
            this.zzQ = false;
            this.zzf.zzp();
            zzT();
            if (this.zzj.zzg()) {
                this.zzt.pause();
            }
            if (zzX(this.zzt)) {
                zzqn zzqn = this.zzl;
                zzqn.getClass();
                zzqn.zzb(this.zzt);
            }
            int i = zzet.zza;
            zzpf zzb2 = this.zzr.zzb();
            zzqc zzqc = this.zzq;
            if (zzqc != null) {
                this.zzr = zzqc;
                this.zzq = null;
            }
            this.zzj.zzc();
            if (zzet.zza >= 24 && (zzqh = this.zzw) != null) {
                zzqh.zzb();
                this.zzw = null;
            }
            AudioTrack audioTrack = this.zzt;
            zzdm zzdm = this.zzi;
            zzpi zzpi = this.zzp;
            zzdm.zzc();
            Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzet.zzE("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new zzpu(audioTrack, zzpi, handler, zzb2, zzdm));
            }
            this.zzt = null;
        }
        this.zzn.zza();
        this.zzm.zza();
        this.zzZ = 0;
        this.zzaa = 0;
        Handler handler2 = this.zzab;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void zzg() {
        this.zzH = true;
    }

    public final void zzh() {
        this.zzR = false;
        if (!zzW()) {
            return;
        }
        if (this.zzj.zzj() || zzX(this.zzt)) {
            this.zzt.pause();
        }
    }

    public final void zzi() {
        this.zzR = true;
        if (zzW()) {
            this.zzj.zze();
            this.zzt.play();
        }
    }

    public final void zzj() throws zzpk {
        if (!this.zzO && zzW() && zzV()) {
            zzP();
            this.zzO = true;
        }
    }

    public final void zzk() {
        zzom zzom = this.zzv;
        if (zzom != null) {
            zzom.zzi();
        }
    }

    public final void zzl() {
        zzf();
        zzfxr zzfxr = this.zzg;
        int size = zzfxr.size();
        for (int i = 0; i < size; i++) {
            ((zzct) zzfxr.get(i)).zzf();
        }
        zzfxr zzfxr2 = this.zzh;
        int size2 = zzfxr2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzct) zzfxr2.get(i2)).zzf();
        }
        zzcq zzcq = this.zzs;
        if (zzcq != null) {
            zzcq.zzf();
        }
        this.zzR = false;
        this.zzW = false;
    }

    public final void zzm(zzh zzh2) {
        if (!this.zzx.equals(zzh2)) {
            this.zzx = zzh2;
            zzom zzom = this.zzv;
            if (zzom != null) {
                zzom.zzg(zzh2);
            }
            zzf();
        }
    }

    public final void zzn(int i) {
        if (this.zzS != i) {
            this.zzS = i;
            zzf();
        }
    }

    public final void zzo(zzi zzi2) {
        if (!this.zzT.equals(zzi2)) {
            if (this.zzt != null) {
                int i = this.zzT.zza;
            }
            this.zzT = zzi2;
        }
    }

    public final void zzp(zzpi zzpi) {
        this.zzp = zzpi;
    }

    public final void zzq(int i, int i2) {
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzX(audioTrack);
        }
    }

    public final void zzr(zzbq zzbq) {
        this.zzA = new zzbq(Math.max(0.1f, Math.min(zzbq.zzb, 8.0f)), Math.max(0.1f, Math.min(zzbq.zzc, 8.0f)));
        zzR(zzbq);
    }

    public final void zzs(zznz zznz) {
        this.zzo = zznz;
    }

    public final void zzt(AudioDeviceInfo audioDeviceInfo) {
        zzon zzon;
        if (audioDeviceInfo == null) {
            zzon = null;
        } else {
            zzon = new zzon(audioDeviceInfo);
        }
        this.zzU = zzon;
        zzom zzom = this.zzv;
        if (zzom != null) {
            zzom.zzh(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzpy.zza(audioTrack, this.zzU);
        }
    }

    public final void zzu(boolean z) {
        this.zzB = z;
        zzR(this.zzA);
    }

    public final void zzv(float f) {
        if (this.zzK != f) {
            this.zzK = f;
            zzS();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01d8, code lost:
        r0 = com.google.android.gms.internal.ads.zzabj.zza(r25);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzw(java.nio.ByteBuffer r25, long r26, int r28) throws com.google.android.gms.internal.ads.zzph, com.google.android.gms.internal.ads.zzpk {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r3 = r26
            r5 = r28
            java.nio.ByteBuffer r0 = r1.zzL
            r6 = 0
            if (r0 == 0) goto L_0x0012
            if (r2 != r0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r0 = r6
            goto L_0x0013
        L_0x0012:
            r0 = 1
        L_0x0013:
            com.google.android.gms.internal.ads.zzdi.zzd(r0)
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzq
            r7 = 0
            if (r0 == 0) goto L_0x0067
            boolean r0 = r24.zzV()
            if (r0 != 0) goto L_0x0022
            return r6
        L_0x0022:
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzq
            com.google.android.gms.internal.ads.zzqc r8 = r1.zzr
            int r9 = r8.zzc
            int r10 = r0.zzc
            if (r9 != r10) goto L_0x0057
            int r9 = r8.zzg
            int r10 = r0.zzg
            if (r9 != r10) goto L_0x0057
            int r9 = r8.zze
            int r10 = r0.zze
            if (r9 != r10) goto L_0x0057
            int r9 = r8.zzf
            int r10 = r0.zzf
            if (r9 != r10) goto L_0x0057
            int r8 = r8.zzd
            int r9 = r0.zzd
            if (r8 != r9) goto L_0x0057
            r1.zzr = r0
            r1.zzq = r7
            android.media.AudioTrack r0 = r1.zzt
            if (r0 == 0) goto L_0x0064
            boolean r0 = zzX(r0)
            if (r0 == 0) goto L_0x0064
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzr
            boolean r0 = r0.zzk
            goto L_0x0064
        L_0x0057:
            r24.zzP()
            boolean r0 = r24.zzx()
            if (r0 == 0) goto L_0x0061
            return r6
        L_0x0061:
            r24.zzf()
        L_0x0064:
            r1.zzM(r3)
        L_0x0067:
            boolean r0 = r24.zzW()
            r7 = 31
            if (r0 == 0) goto L_0x0071
            goto L_0x014c
        L_0x0071:
            com.google.android.gms.internal.ads.zzdm r0 = r1.zzi     // Catch:{ zzph -> 0x03a6 }
            boolean r0 = r0.zzd()     // Catch:{ zzph -> 0x03a6 }
            if (r0 != 0) goto L_0x007a
            return r6
        L_0x007a:
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzr     // Catch:{ zzph -> 0x0084 }
            r0.getClass()
            android.media.AudioTrack r0 = r1.zzL(r0)     // Catch:{ zzph -> 0x0084 }
            goto L_0x00ba
        L_0x0084:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzr     // Catch:{ zzph -> 0x03a6 }
            int r8 = r0.zzh     // Catch:{ zzph -> 0x03a6 }
            r9 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 <= r9) goto L_0x03a2
            com.google.android.gms.internal.ads.zzqc r8 = new com.google.android.gms.internal.ads.zzqc     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzaf r11 = r0.zza     // Catch:{ zzph -> 0x03a6 }
            int r12 = r0.zzb     // Catch:{ zzph -> 0x03a6 }
            int r13 = r0.zzc     // Catch:{ zzph -> 0x03a6 }
            int r14 = r0.zzd     // Catch:{ zzph -> 0x03a6 }
            int r15 = r0.zze     // Catch:{ zzph -> 0x03a6 }
            int r9 = r0.zzf     // Catch:{ zzph -> 0x03a6 }
            int r10 = r0.zzg     // Catch:{ zzph -> 0x03a6 }
            r18 = 1000000(0xf4240, float:1.401298E-39)
            com.google.android.gms.internal.ads.zzcq r0 = r0.zzi     // Catch:{ zzph -> 0x03a6 }
            r20 = 0
            r21 = 0
            r22 = 0
            r17 = r10
            r10 = r8
            r16 = r9
            r19 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ zzph -> 0x03a6 }
            android.media.AudioTrack r0 = r1.zzL(r8)     // Catch:{ zzph -> 0x039e }
            r1.zzr = r8     // Catch:{ zzph -> 0x039e }
        L_0x00ba:
            r1.zzt = r0     // Catch:{ zzph -> 0x03a6 }
            boolean r0 = zzX(r0)     // Catch:{ zzph -> 0x03a6 }
            if (r0 == 0) goto L_0x00d8
            android.media.AudioTrack r0 = r1.zzt     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzqn r6 = r1.zzl     // Catch:{ zzph -> 0x03a6 }
            if (r6 != 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzqn r6 = new com.google.android.gms.internal.ads.zzqn     // Catch:{ zzph -> 0x03a6 }
            r6.<init>(r1)     // Catch:{ zzph -> 0x03a6 }
            r1.zzl = r6     // Catch:{ zzph -> 0x03a6 }
        L_0x00cf:
            com.google.android.gms.internal.ads.zzqn r6 = r1.zzl     // Catch:{ zzph -> 0x03a6 }
            r6.zza(r0)     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzr     // Catch:{ zzph -> 0x03a6 }
            boolean r0 = r0.zzk     // Catch:{ zzph -> 0x03a6 }
        L_0x00d8:
            int r0 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ zzph -> 0x03a6 }
            if (r0 < r7) goto L_0x00e5
            com.google.android.gms.internal.ads.zznz r6 = r1.zzo     // Catch:{ zzph -> 0x03a6 }
            if (r6 == 0) goto L_0x00e5
            android.media.AudioTrack r8 = r1.zzt     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzpz.zza(r8, r6)     // Catch:{ zzph -> 0x03a6 }
        L_0x00e5:
            android.media.AudioTrack r6 = r1.zzt     // Catch:{ zzph -> 0x03a6 }
            int r6 = r6.getAudioSessionId()     // Catch:{ zzph -> 0x03a6 }
            r1.zzS = r6     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzpp r8 = r1.zzj     // Catch:{ zzph -> 0x03a6 }
            android.media.AudioTrack r9 = r1.zzt     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzqc r6 = r1.zzr     // Catch:{ zzph -> 0x03a6 }
            int r10 = r6.zzc     // Catch:{ zzph -> 0x03a6 }
            r11 = 2
            if (r10 != r11) goto L_0x00fa
            r10 = 1
            goto L_0x00fb
        L_0x00fa:
            r10 = 0
        L_0x00fb:
            int r11 = r6.zzg     // Catch:{ zzph -> 0x03a6 }
            int r12 = r6.zzd     // Catch:{ zzph -> 0x03a6 }
            int r13 = r6.zzh     // Catch:{ zzph -> 0x03a6 }
            r8.zzd(r9, r10, r11, r12, r13)     // Catch:{ zzph -> 0x03a6 }
            r24.zzS()     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzi r6 = r1.zzT     // Catch:{ zzph -> 0x03a6 }
            int r6 = r6.zza     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzon r6 = r1.zzU     // Catch:{ zzph -> 0x03a6 }
            if (r6 == 0) goto L_0x0123
            r8 = 23
            if (r0 < r8) goto L_0x0123
            android.media.AudioTrack r8 = r1.zzt     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzpy.zza(r8, r6)     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzom r6 = r1.zzv     // Catch:{ zzph -> 0x03a6 }
            if (r6 == 0) goto L_0x0123
            com.google.android.gms.internal.ads.zzon r8 = r1.zzU     // Catch:{ zzph -> 0x03a6 }
            android.media.AudioDeviceInfo r8 = r8.zza     // Catch:{ zzph -> 0x03a6 }
            r6.zzh(r8)     // Catch:{ zzph -> 0x03a6 }
        L_0x0123:
            r6 = 24
            if (r0 < r6) goto L_0x0134
            com.google.android.gms.internal.ads.zzom r0 = r1.zzv     // Catch:{ zzph -> 0x03a6 }
            if (r0 == 0) goto L_0x0134
            com.google.android.gms.internal.ads.zzqh r6 = new com.google.android.gms.internal.ads.zzqh     // Catch:{ zzph -> 0x03a6 }
            android.media.AudioTrack r8 = r1.zzt     // Catch:{ zzph -> 0x03a6 }
            r6.<init>(r8, r0)     // Catch:{ zzph -> 0x03a6 }
            r1.zzw = r6     // Catch:{ zzph -> 0x03a6 }
        L_0x0134:
            r0 = 1
            r1.zzI = r0     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzpi r0 = r1.zzp     // Catch:{ zzph -> 0x03a6 }
            if (r0 == 0) goto L_0x014c
            com.google.android.gms.internal.ads.zzqc r6 = r1.zzr     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzpf r6 = r6.zzb()     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzqu r0 = (com.google.android.gms.internal.ads.zzqu) r0     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzqv r0 = r0.zza     // Catch:{ zzph -> 0x03a6 }
            com.google.android.gms.internal.ads.zzpd r0 = r0.zzc     // Catch:{ zzph -> 0x03a6 }
            r0.zzc(r6)     // Catch:{ zzph -> 0x03a6 }
        L_0x014c:
            com.google.android.gms.internal.ads.zzqi r0 = r1.zzm
            r0.zza()
            boolean r0 = r1.zzI
            r8 = 0
            if (r0 == 0) goto L_0x016c
            long r10 = java.lang.Math.max(r8, r3)
            r1.zzJ = r10
            r0 = 0
            r1.zzH = r0
            r1.zzI = r0
            r1.zzM(r3)
            boolean r0 = r1.zzR
            if (r0 == 0) goto L_0x016c
            r24.zzi()
        L_0x016c:
            com.google.android.gms.internal.ads.zzpp r0 = r1.zzj
            long r10 = r24.zzK()
            boolean r0 = r0.zzi(r10)
            if (r0 != 0) goto L_0x017a
            r0 = 0
            return r0
        L_0x017a:
            java.nio.ByteBuffer r0 = r1.zzL
            if (r0 != 0) goto L_0x0371
            java.nio.ByteOrder r0 = r25.order()
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN
            if (r0 != r6) goto L_0x0188
            r0 = 1
            goto L_0x0189
        L_0x0188:
            r0 = 0
        L_0x0189:
            com.google.android.gms.internal.ads.zzdi.zzd(r0)
            boolean r0 = r25.hasRemaining()
            if (r0 != 0) goto L_0x0194
            r0 = 1
            return r0
        L_0x0194:
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzr
            int r6 = r0.zzc
            if (r6 == 0) goto L_0x02e1
            int r6 = r1.zzG
            if (r6 != 0) goto L_0x02e1
            int r0 = r0.zzg
            r6 = 20
            if (r0 == r6) goto L_0x02d6
            r6 = 30
            r10 = -2
            r11 = 1024(0x400, float:1.435E-42)
            r12 = -1
            if (r0 == r6) goto L_0x0247
            switch(r0) {
                case 5: goto L_0x01d8;
                case 6: goto L_0x01d8;
                case 7: goto L_0x0247;
                case 8: goto L_0x0247;
                case 9: goto L_0x01c3;
                case 10: goto L_0x02d4;
                case 11: goto L_0x01c0;
                case 12: goto L_0x01c0;
                default: goto L_0x01af;
            }
        L_0x01af:
            r6 = 16
            switch(r0) {
                case 14: goto L_0x01fa;
                case 15: goto L_0x01f7;
                case 16: goto L_0x02d4;
                case 17: goto L_0x01df;
                case 18: goto L_0x01d8;
                default: goto L_0x01b4;
            }
        L_0x01b4:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Unexpected audio encoding: "
            java.lang.String r0 = defpackage.lf.h(r3, r0)
            r2.<init>(r0)
            throw r2
        L_0x01c0:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x01dc
        L_0x01c3:
            int r0 = r25.position()
            int r0 = com.google.android.gms.internal.ads.zzet.zzi(r2, r0)
            int r0 = com.google.android.gms.internal.ads.zzadd.zzc(r0)
            if (r0 == r12) goto L_0x01d2
            goto L_0x01dc
        L_0x01d2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x01d8:
            int r0 = com.google.android.gms.internal.ads.zzabj.zza(r25)
        L_0x01dc:
            r11 = r0
            goto L_0x02d4
        L_0x01df:
            byte[] r0 = new byte[r6]
            int r7 = r25.position()
            r2.get(r0)
            r2.position(r7)
            com.google.android.gms.internal.ads.zzej r7 = new com.google.android.gms.internal.ads.zzej
            r7.<init>(r0, r6)
            com.google.android.gms.internal.ads.zzabl r0 = com.google.android.gms.internal.ads.zzabm.zza(r7)
            int r0 = r0.zzc
            goto L_0x01dc
        L_0x01f7:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x01dc
        L_0x01fa:
            int r0 = r25.position()
            int r7 = r25.limit()
            int r7 = r7 + -10
            r11 = r0
        L_0x0205:
            if (r11 > r7) goto L_0x0218
            int r13 = r11 + 4
            int r13 = com.google.android.gms.internal.ads.zzet.zzi(r2, r13)
            r13 = r13 & r10
            r14 = -126718022(0xfffffffff8726fba, float:-1.966878E34)
            if (r13 != r14) goto L_0x0215
            int r11 = r11 - r0
            goto L_0x0219
        L_0x0215:
            int r11 = r11 + 1
            goto L_0x0205
        L_0x0218:
            r11 = r12
        L_0x0219:
            if (r11 != r12) goto L_0x021d
            r0 = 0
            goto L_0x01dc
        L_0x021d:
            int r0 = r25.position()
            int r0 = r0 + r11
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r7 = r25.position()
            int r7 = r7 + r11
            r10 = 187(0xbb, float:2.62E-43)
            if (r0 != r10) goto L_0x0236
            r0 = 9
            goto L_0x0238
        L_0x0236:
            r0 = 8
        L_0x0238:
            int r7 = r7 + r0
            byte r0 = r2.get(r7)
            int r0 = r0 >> 4
            r0 = r0 & 7
            r7 = 40
            int r0 = r7 << r0
            int r0 = r0 * r6
            goto L_0x01dc
        L_0x0247:
            r0 = 0
            int r6 = r2.getInt(r0)
            r13 = -233094848(0xfffffffff21b4140, float:-3.0751398E30)
            if (r6 == r13) goto L_0x02d4
            int r6 = r2.getInt(r0)
            r13 = -398277519(0xffffffffe842c471, float:-3.6790512E24)
            if (r6 != r13) goto L_0x025c
            goto L_0x02d4
        L_0x025c:
            int r0 = r2.getInt(r0)
            r6 = 622876772(0x25205864, float:1.3907736E-16)
            if (r0 != r6) goto L_0x0269
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x01dc
        L_0x0269:
            int r0 = r25.position()
            byte r6 = r2.get(r0)
            if (r6 == r10) goto L_0x02b9
            if (r6 == r12) goto L_0x029d
            if (r6 == r7) goto L_0x028b
            int r6 = r0 + 4
            int r0 = r0 + 5
            byte r6 = r2.get(r6)
            r6 = r6 & 1
            int r6 = r6 << 6
            byte r0 = r2.get(r0)
            r0 = r0 & 252(0xfc, float:3.53E-43)
            r7 = 2
            goto L_0x02b5
        L_0x028b:
            r6 = 2
            int r7 = r0 + 5
            byte r7 = r2.get(r7)
            r7 = r7 & 7
            int r7 = r7 << 4
            int r0 = r0 + 6
            byte r0 = r2.get(r0)
            goto L_0x02ae
        L_0x029d:
            r6 = 2
            int r7 = r0 + 4
            byte r7 = r2.get(r7)
            r7 = r7 & 7
            int r7 = r7 << 4
            int r0 = r0 + 7
            byte r0 = r2.get(r0)
        L_0x02ae:
            r23 = r7
            r7 = r6
            r6 = r23
            r0 = r0 & 60
        L_0x02b5:
            int r0 = r0 >> r7
            r0 = r0 | r6
            r6 = 1
            goto L_0x02cf
        L_0x02b9:
            int r6 = r0 + 4
            int r0 = r0 + 5
            byte r0 = r2.get(r0)
            r7 = 1
            r0 = r0 & r7
            int r0 = r0 << 6
            byte r6 = r2.get(r6)
            r6 = r6 & 252(0xfc, float:3.53E-43)
            int r6 = r6 >> 2
            r0 = r0 | r6
            r6 = r7
        L_0x02cf:
            int r0 = r0 + r6
            int r11 = r0 * 32
            r0 = r6
            goto L_0x02db
        L_0x02d4:
            r0 = 1
            goto L_0x02db
        L_0x02d6:
            r0 = 1
            int r11 = com.google.android.gms.internal.ads.zzade.zzb(r25)
        L_0x02db:
            r1.zzG = r11
            if (r11 == 0) goto L_0x02e0
            goto L_0x02e1
        L_0x02e0:
            return r0
        L_0x02e1:
            com.google.android.gms.internal.ads.zzqf r0 = r1.zzy
            if (r0 == 0) goto L_0x02f3
            boolean r0 = r24.zzV()
            if (r0 != 0) goto L_0x02ed
            r0 = 0
            return r0
        L_0x02ed:
            r1.zzM(r3)
            r0 = 0
            r1.zzy = r0
        L_0x02f3:
            long r6 = r1.zzJ
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzr
            long r10 = r24.zzJ()
            com.google.android.gms.internal.ads.zzqz r12 = r1.zzf
            long r12 = r12.zzo()
            long r10 = r10 - r12
            com.google.android.gms.internal.ads.zzaf r0 = r0.zza
            int r0 = r0.zzA
            long r10 = com.google.android.gms.internal.ads.zzet.zzs(r10, r0)
            long r10 = r10 + r6
            boolean r0 = r1.zzH
            if (r0 != 0) goto L_0x032b
            long r6 = r10 - r3
            long r6 = java.lang.Math.abs(r6)
            r12 = 200000(0x30d40, double:9.8813E-319)
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x032b
            com.google.android.gms.internal.ads.zzpi r0 = r1.zzp
            if (r0 == 0) goto L_0x0328
            com.google.android.gms.internal.ads.zzpj r6 = new com.google.android.gms.internal.ads.zzpj
            r6.<init>(r3, r10)
            r0.zza(r6)
        L_0x0328:
            r0 = 1
            r1.zzH = r0
        L_0x032b:
            boolean r0 = r1.zzH
            if (r0 == 0) goto L_0x0352
            boolean r0 = r24.zzV()
            r6 = 0
            if (r0 != 0) goto L_0x0337
            return r6
        L_0x0337:
            long r10 = r3 - r10
            long r12 = r1.zzJ
            long r12 = r12 + r10
            r1.zzJ = r12
            r1.zzH = r6
            r1.zzM(r3)
            com.google.android.gms.internal.ads.zzpi r0 = r1.zzp
            if (r0 == 0) goto L_0x0352
            int r6 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0352
            com.google.android.gms.internal.ads.zzqu r0 = (com.google.android.gms.internal.ads.zzqu) r0
            com.google.android.gms.internal.ads.zzqv r0 = r0.zza
            r0.zzao()
        L_0x0352:
            com.google.android.gms.internal.ads.zzqc r0 = r1.zzr
            int r0 = r0.zzc
            if (r0 != 0) goto L_0x0363
            long r6 = r1.zzC
            int r0 = r25.remaining()
            long r8 = (long) r0
            long r6 = r6 + r8
            r1.zzC = r6
            goto L_0x036d
        L_0x0363:
            long r6 = r1.zzD
            int r0 = r1.zzG
            long r8 = (long) r0
            long r10 = (long) r5
            long r8 = r8 * r10
            long r8 = r8 + r6
            r1.zzD = r8
        L_0x036d:
            r1.zzL = r2
            r1.zzM = r5
        L_0x0371:
            r1.zzQ(r3)
            java.nio.ByteBuffer r0 = r1.zzL
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x0384
            r0 = 0
            r1.zzL = r0
            r0 = 0
            r1.zzM = r0
            r0 = 1
            return r0
        L_0x0384:
            r0 = 0
            r2 = 1
            com.google.android.gms.internal.ads.zzpp r3 = r1.zzj
            long r4 = r24.zzK()
            boolean r3 = r3.zzh(r4)
            if (r3 == 0) goto L_0x039d
            java.lang.String r0 = "DefaultAudioSink"
            java.lang.String r3 = "Resetting stalled audio track"
            com.google.android.gms.internal.ads.zzea.zzf(r0, r3)
            r24.zzf()
            return r2
        L_0x039d:
            return r0
        L_0x039e:
            r0 = move-exception
            r6.addSuppressed(r0)     // Catch:{ zzph -> 0x03a6 }
        L_0x03a2:
            r24.zzN()     // Catch:{ zzph -> 0x03a6 }
            throw r6     // Catch:{ zzph -> 0x03a6 }
        L_0x03a6:
            r0 = move-exception
            boolean r2 = r0.zzb
            if (r2 != 0) goto L_0x03b2
            com.google.android.gms.internal.ads.zzqi r2 = r1.zzm
            r2.zzb(r0)
            r0 = 0
            return r0
        L_0x03b2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqp.zzw(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean zzx() {
        if (!zzW()) {
            return false;
        }
        if ((zzet.zza < 29 || !this.zzt.isOffloadedPlayback() || !this.zzQ) && this.zzj.zzf(zzK())) {
            return true;
        }
        return false;
    }

    public final boolean zzy() {
        if (!zzW()) {
            return true;
        }
        if (!this.zzO) {
            return false;
        }
        if (!zzx()) {
            return true;
        }
        return false;
    }

    public final boolean zzz(zzaf zzaf) {
        if (zza(zzaf) != 0) {
            return true;
        }
        return false;
    }
}
