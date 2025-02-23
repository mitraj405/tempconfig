package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Pair;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzjm extends zzj implements zzih {
    public static final /* synthetic */ int zzd = 0;
    private boolean zzA;
    private int zzB;
    private zzlj zzC;
    private zzig zzD;
    private zzbt zzE;
    private zzbh zzF;
    /* access modifiers changed from: private */
    public Object zzG;
    private Surface zzH;
    private int zzI;
    private zzel zzJ;
    private int zzK;
    private zzh zzL;
    private float zzM;
    /* access modifiers changed from: private */
    public boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private int zzQ;
    private zzbh zzR;
    private zzkx zzS;
    private int zzT;
    private long zzU;
    private final zzii zzV;
    private zzwa zzW;
    final zzyc zzb;
    final zzbt zzc;
    private final zzdm zze;
    private final Context zzf;
    private final zzbw zzg;
    private final zzle[] zzh;
    private final zzyb zzi;
    private final zzdt zzj;
    private final zzjx zzk;
    /* access modifiers changed from: private */
    public final zzdz zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzca zzn;
    private final List zzo;
    private final boolean zzp;
    /* access modifiers changed from: private */
    public final zzln zzq;
    private final Looper zzr;
    private final zzyj zzs;
    private final zzdj zzt;
    private final zzji zzu;
    private final zzjk zzv;
    private final zzhl zzw;
    private final long zzx;
    private int zzy;
    private int zzz;

    static {
        zzbd.zzb("media3.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Object, com.google.android.gms.internal.ads.zzln] */
    @SuppressLint({"HandlerLeak"})
    public zzjm(zzif zzif, zzbw zzbw) {
        zznz zza;
        int i;
        zzif zzif2 = zzif;
        zzbw zzbw2 = zzbw;
        zzdm zzdm = new zzdm(zzdj.zza);
        this.zze = zzdm;
        try {
            zzea.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.0-alpha02] [" + zzet.zze + "]");
            Context applicationContext = zzif2.zza.getApplicationContext();
            this.zzf = applicationContext;
            ? apply = zzif2.zzh.apply(zzif2.zzb);
            this.zzq = apply;
            this.zzQ = zzif2.zzj;
            this.zzL = zzif2.zzk;
            this.zzI = zzif2.zzl;
            this.zzN = false;
            this.zzx = zzif2.zzp;
            zzji zzji = new zzji(this, (zzjh) null);
            this.zzu = zzji;
            zzjk zzjk = new zzjk((zzjj) null);
            this.zzv = zzjk;
            Handler handler = new Handler(zzif2.zzi);
            Handler handler2 = handler;
            zzle[] zza2 = ((zzhy) zzif2.zzc).zza.zza(handler, zzji, zzji, zzji, zzji);
            this.zzh = zza2;
            int length = zza2.length;
            zzyb zzyb = (zzyb) zzif2.zze.zza();
            this.zzi = zzyb;
            zzif.zza(((zzhz) zzif2.zzd).zza);
            zzyn zzg2 = zzyn.zzg(((zzic) zzif2.zzg).zza);
            this.zzs = zzg2;
            this.zzp = zzif2.zzm;
            this.zzC = zzif2.zzn;
            Looper looper = zzif2.zzi;
            this.zzr = looper;
            zzdj zzdj = zzif2.zzb;
            this.zzt = zzdj;
            this.zzg = zzbw2;
            zzdz zzdz = new zzdz(looper, zzdj, new zzjc(this));
            this.zzl = zzdz;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            zzjk zzjk2 = zzjk;
            this.zzW = new zzwa(0);
            this.zzD = zzig.zza;
            int length2 = zza2.length;
            CopyOnWriteArraySet copyOnWriteArraySet2 = copyOnWriteArraySet;
            zzdz zzdz2 = zzdz;
            zzji zzji2 = zzji;
            zzyc zzyc = new zzyc(new zzli[2], new zzxv[2], zzck.zza, (Object) null);
            this.zzb = zzyc;
            this.zzn = new zzca();
            zzbr zzbr = new zzbr();
            zzdm zzdm2 = zzdm;
            zzbr.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzyb.zzn();
            zzbr.zzd(29, true);
            zzbr.zzd(23, false);
            zzbr.zzd(25, false);
            zzbr.zzd(33, false);
            zzbr.zzd(26, false);
            zzbr.zzd(34, false);
            zzbt zze2 = zzbr.zze();
            this.zzc = zze2;
            zzbr zzbr2 = new zzbr();
            zzbr2.zzb(zze2);
            zzbr2.zza(4);
            zzbr2.zza(10);
            this.zzE = zzbr2.zze();
            this.zzj = zzdj.zzb(looper, (Handler.Callback) null);
            zzii zzii = new zzii(this);
            this.zzV = zzii;
            this.zzS = zzkx.zzg(zzyc);
            apply.zzR(zzbw2, looper);
            if (zzet.zza < 31) {
                zza = new zznz(zzif2.zzs);
            } else {
                zza = zzjd.zza(applicationContext, this, zzif2.zzq, zzif2.zzs);
            }
            zznz zznz = zza;
            zzlj zzlj = this.zzC;
            zzln zzln = apply;
            zzjk zzjk3 = zzjk2;
            zzlj zzlj2 = zzlj;
            zzdz zzdz3 = zzdz2;
            zzyc zzyc2 = zzyc;
            Looper looper2 = looper;
            zzyn zzyn = zzg2;
            zzyb zzyb2 = zzyb;
            CopyOnWriteArraySet copyOnWriteArraySet3 = copyOnWriteArraySet2;
            zzji zzji3 = zzji2;
            this.zzk = new zzjx(zza2, zzyb, zzyc2, (zzkb) zzif2.zzf.zza(), zzg2, 0, false, zzln, zzlj2, zzif2.zzt, zzif2.zzo, false, false, looper2, zzdj, zzii, zznz, (Looper) null, this.zzD);
            this.zzM = 1.0f;
            zzbh zzbh = zzbh.zza;
            this.zzF = zzbh;
            this.zzR = zzbh;
            this.zzT = -1;
            AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
            if (audioManager == null) {
                i = -1;
            } else {
                i = audioManager.generateAudioSessionId();
            }
            this.zzK = i;
            int i2 = zzdc.zza;
            this.zzO = true;
            zzln.getClass();
            zzln zzln2 = zzln;
            zzdz3.zzb(zzln2);
            zzyn.zze(new Handler(looper2), zzln2);
            zzji zzji4 = zzji3;
            copyOnWriteArraySet3.add(zzji4);
            zzif zzif3 = zzif;
            Handler handler3 = handler2;
            new zzhh(zzif3.zza, handler3, zzji4);
            this.zzw = new zzhl(zzif3.zza, handler3, zzji4);
            zzet.zzG((Object) null, (Object) null);
            PowerManager powerManager = (PowerManager) zzif3.zza.getApplicationContext().getSystemService("power");
            WifiManager wifiManager = (WifiManager) zzif3.zza.getApplicationContext().getSystemService("wifi");
            new zzs(0).zza();
            zzcp zzcp = zzcp.zza;
            this.zzJ = zzel.zza;
            zzyb2.zzk(this.zzL);
            zzab(1, 10, Integer.valueOf(this.zzK));
            zzab(2, 10, Integer.valueOf(this.zzK));
            zzab(1, 3, this.zzL);
            zzab(2, 4, Integer.valueOf(this.zzI));
            zzab(2, 5, 0);
            zzab(1, 9, Boolean.valueOf(this.zzN));
            zzjk zzjk4 = zzjk3;
            zzab(2, 7, zzjk4);
            zzab(6, 8, zzjk4);
            zzab(-1, 16, Integer.valueOf(this.zzQ));
            zzdm2.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    public static /* bridge */ /* synthetic */ void zzK(zzjm zzjm, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzjm.zzad(surface);
        zzjm.zzH = surface;
    }

    private final int zzR(zzkx zzkx) {
        if (zzkx.zza.zzo()) {
            return this.zzT;
        }
        return zzkx.zza.zzn(zzkx.zzb.zza, this.zzn).zzc;
    }

    /* access modifiers changed from: private */
    public static int zzS(boolean z, int i) {
        if (!z || i == 1) {
            return 1;
        }
        return 2;
    }

    private final long zzT(zzkx zzkx) {
        if (!zzkx.zzb.zzb()) {
            return zzet.zzu(zzU(zzkx));
        }
        zzkx.zza.zzn(zzkx.zzb.zza, this.zzn);
        long j = zzkx.zzc;
        if (j != -9223372036854775807L) {
            return zzet.zzu(j) + zzet.zzu(0);
        }
        long j2 = zzkx.zza.zze(zzR(zzkx), this.zza, 0).zzl;
        return zzet.zzu(0);
    }

    private final long zzU(zzkx zzkx) {
        if (zzkx.zza.zzo()) {
            return zzet.zzr(this.zzU);
        }
        long j = zzkx.zzr;
        if (zzkx.zzb.zzb()) {
            return j;
        }
        zzW(zzkx.zza, zzkx.zzb, j);
        return j;
    }

    private static long zzV(zzkx zzkx) {
        zzcb zzcb = new zzcb();
        zzca zzca = new zzca();
        zzkx.zza.zzn(zzkx.zzb.zza, zzca);
        long j = zzkx.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzkx.zza.zze(zzca.zzc, zzcb, 0).zzl;
        return 0;
    }

    private final long zzW(zzcc zzcc, zzui zzui, long j) {
        zzcc.zzn(zzui.zza, this.zzn);
        return j;
    }

    private final Pair zzX(zzcc zzcc, int i, long j) {
        if (zzcc.zzo()) {
            this.zzT = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzU = j;
            return null;
        }
        if (i == -1 || i >= zzcc.zzc()) {
            i = zzcc.zzg(false);
            long j2 = zzcc.zze(i, this.zza, 0).zzl;
            j = zzet.zzu(0);
        }
        return zzcc.zzl(this.zza, this.zzn, i, zzet.zzr(j));
    }

    private final zzkx zzY(zzkx zzkx, zzcc zzcc, Pair pair) {
        boolean z;
        zzui zzui;
        zzwi zzwi;
        zzyc zzyc;
        List list;
        int i;
        long j;
        zzcc zzcc2 = zzcc;
        Pair pair2 = pair;
        if (zzcc.zzo() || pair2 != null) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        zzcc zzcc3 = zzkx.zza;
        long zzT2 = zzT(zzkx);
        zzkx zzf2 = zzkx.zzf(zzcc);
        if (zzcc.zzo()) {
            zzui zzh2 = zzkx.zzh();
            long zzr2 = zzet.zzr(this.zzU);
            zzkx zza = zzf2.zzb(zzh2, zzr2, zzr2, zzr2, 0, zzwi.zza, this.zzb, zzfxr.zzm()).zza(zzh2);
            zza.zzp = zza.zzr;
            return zza;
        }
        Object obj = zzf2.zzb.zza;
        int i2 = zzet.zza;
        boolean z2 = !obj.equals(pair2.first);
        if (z2) {
            zzui = new zzui(pair2.first, -1);
        } else {
            zzui = zzf2.zzb;
        }
        zzui zzui2 = zzui;
        long longValue = ((Long) pair2.second).longValue();
        long zzr3 = zzet.zzr(zzT2);
        if (!zzcc3.zzo()) {
            zzcc3.zzn(obj, this.zzn);
        }
        if (z2 || longValue < zzr3) {
            long j2 = longValue;
            zzui zzui3 = zzui2;
            zzdi.zzf(!zzui3.zzb());
            if (z2) {
                zzwi = zzwi.zza;
            } else {
                zzwi = zzf2.zzh;
            }
            zzwi zzwi2 = zzwi;
            if (z2) {
                zzyc = this.zzb;
            } else {
                zzyc = zzf2.zzi;
            }
            zzyc zzyc2 = zzyc;
            if (z2) {
                list = zzfxr.zzm();
            } else {
                list = zzf2.zzj;
            }
            zzkx zza2 = zzf2.zzb(zzui3, j2, j2, j2, 0, zzwi2, zzyc2, list).zza(zzui3);
            zza2.zzp = j2;
            return zza2;
        } else if (i == 0) {
            int zza3 = zzcc2.zza(zzf2.zzk.zza);
            if (zza3 != -1 && zzcc2.zzd(zza3, this.zzn, false).zzc == zzcc2.zzn(zzui2.zza, this.zzn).zzc) {
                return zzf2;
            }
            zzcc2.zzn(zzui2.zza, this.zzn);
            if (zzui2.zzb()) {
                j = this.zzn.zzh(zzui2.zzb, zzui2.zzc);
            } else {
                j = this.zzn.zzd;
            }
            zzkx zza4 = zzf2.zzb(zzui2, zzf2.zzr, zzf2.zzr, zzf2.zzd, j - zzf2.zzr, zzf2.zzh, zzf2.zzi, zzf2.zzj).zza(zzui2);
            zza4.zzp = j;
            return zza4;
        } else {
            zzui zzui4 = zzui2;
            zzdi.zzf(!zzui4.zzb());
            long max = Math.max(0, zzf2.zzq - (longValue - zzr3));
            long j3 = zzf2.zzp;
            if (zzf2.zzk.equals(zzf2.zzb)) {
                j3 = longValue + max;
            }
            zzkx zzb2 = zzf2.zzb(zzui4, longValue, longValue, longValue, max, zzf2.zzh, zzf2.zzi, zzf2.zzj);
            zzb2.zzp = j3;
            return zzb2;
        }
    }

    private final zzla zzZ(zzkz zzkz) {
        int zzR2 = zzR(this.zzS);
        zzcc zzcc = this.zzS.zza;
        if (zzR2 == -1) {
            zzR2 = 0;
        }
        zzdj zzdj = this.zzt;
        zzjx zzjx = this.zzk;
        return new zzla(zzjx, zzkz, zzcc, zzR2, zzdj, zzjx.zzc());
    }

    /* access modifiers changed from: private */
    public final void zzaa(int i, int i2) {
        if (i != this.zzJ.zzb() || i2 != this.zzJ.zza()) {
            this.zzJ = new zzel(i, i2);
            zzdz zzdz = this.zzl;
            zzdz.zzd(24, new zziz(i, i2));
            zzdz.zzc();
            zzab(2, 14, new zzel(i, i2));
        }
    }

    private final void zzab(int i, int i2, Object obj) {
        zzle[] zzleArr = this.zzh;
        int length = zzleArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzle zzle = zzleArr[i3];
            if (i == -1 || zzle.zzb() == i) {
                zzla zzZ = zzZ(zzle);
                zzZ.zzf(i2);
                zzZ.zze(obj);
                zzZ.zzd();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzac() {
        zzab(1, 2, Float.valueOf(this.zzM * this.zzw.zza()));
    }

    /* access modifiers changed from: private */
    public final void zzad(Object obj) {
        ArrayList arrayList = new ArrayList();
        zzle[] zzleArr = this.zzh;
        int length = zzleArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            zzle zzle = zzleArr[i];
            if (zzle.zzb() == 2) {
                zzla zzZ = zzZ(zzle);
                zzZ.zzf(1);
                zzZ.zze(obj);
                zzZ.zzd();
                arrayList.add(zzZ);
            }
        }
        Object obj2 = this.zzG;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzla) it.next()).zzi(this.zzx);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.zzG;
            Surface surface = this.zzH;
            if (obj3 == surface) {
                surface.release();
                this.zzH = null;
            }
        }
        this.zzG = obj;
        if (z) {
            zzae(zzhw.zzd(new zzjy(3), 1003));
        }
    }

    private final void zzae(zzhw zzhw) {
        zzkx zzkx = this.zzS;
        zzkx zza = zzkx.zza(zzkx.zzb);
        zza.zzp = zza.zzr;
        zza.zzq = 0;
        zzkx zze2 = zza.zze(1);
        if (zzhw != null) {
            zze2 = zze2.zzd(zzhw);
        }
        this.zzy++;
        this.zzk.zzn();
        zzag(zze2, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    /* access modifiers changed from: private */
    public final void zzaf(boolean z, int i, int i2) {
        boolean z2;
        int i3 = 0;
        if (!z || i == -1) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 && i != 1) {
            i3 = 1;
        }
        zzkx zzkx = this.zzS;
        if (zzkx.zzl != z2 || zzkx.zzm != i3) {
            this.zzy++;
            zzkx zzc2 = zzkx.zzc(z2, i3);
            this.zzk.zzm(z2, i3);
            zzag(zzc2, 0, i2, false, 5, -9223372036854775807L, -1, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0393  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0475 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x047f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x048a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x049b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x04a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x04be A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04cc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag(com.google.android.gms.internal.ads.zzkx r43, int r44, int r45, boolean r46, int r47, long r48, int r50, boolean r51) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r2 = r47
            com.google.android.gms.internal.ads.zzkx r3 = r0.zzS
            r0.zzS = r1
            com.google.android.gms.internal.ads.zzcc r4 = r3.zza
            com.google.android.gms.internal.ads.zzcc r5 = r1.zza
            boolean r4 = r4.equals(r5)
            r5 = 1
            r4 = r4 ^ r5
            com.google.android.gms.internal.ads.zzcc r6 = r3.zza
            com.google.android.gms.internal.ads.zzcc r7 = r1.zza
            boolean r8 = r7.zzo()
            r10 = 3
            r11 = -1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r13 = 0
            r15 = 0
            if (r8 == 0) goto L_0x0035
            boolean r8 = r6.zzo()
            if (r8 == 0) goto L_0x0035
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.<init>(r7, r12)
            goto L_0x004a
        L_0x0035:
            boolean r8 = r7.zzo()
            boolean r9 = r6.zzo()
            if (r8 == r9) goto L_0x004f
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r6.<init>(r7, r8)
        L_0x004a:
            r7 = r6
            r6 = r46
            goto L_0x00d9
        L_0x004f:
            com.google.android.gms.internal.ads.zzui r8 = r3.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzca r9 = r0.zzn
            com.google.android.gms.internal.ads.zzca r8 = r6.zzn(r8, r9)
            int r8 = r8.zzc
            com.google.android.gms.internal.ads.zzcb r9 = r0.zza
            com.google.android.gms.internal.ads.zzcb r6 = r6.zze(r8, r9, r13)
            java.lang.Object r6 = r6.zzb
            com.google.android.gms.internal.ads.zzui r8 = r1.zzb
            java.lang.Object r8 = r8.zza
            com.google.android.gms.internal.ads.zzca r9 = r0.zzn
            com.google.android.gms.internal.ads.zzca r8 = r7.zzn(r8, r9)
            int r8 = r8.zzc
            com.google.android.gms.internal.ads.zzcb r9 = r0.zza
            com.google.android.gms.internal.ads.zzcb r7 = r7.zze(r8, r9, r13)
            java.lang.Object r7 = r7.zzb
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00a6
            if (r46 == 0) goto L_0x0087
            if (r2 != 0) goto L_0x0085
            r6 = r5
            r7 = r6
            r2 = r15
            goto L_0x0093
        L_0x0085:
            r6 = r5
            goto L_0x0088
        L_0x0087:
            r6 = r15
        L_0x0088:
            r7 = r6
            if (r6 == 0) goto L_0x0090
            if (r2 != r5) goto L_0x0090
            r6 = r7
            r7 = 2
            goto L_0x0093
        L_0x0090:
            if (r4 == 0) goto L_0x00a0
            r7 = r10
        L_0x0093:
            android.util.Pair r8 = new android.util.Pair
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.<init>(r9, r7)
            r7 = r8
            goto L_0x00d9
        L_0x00a0:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00a6:
            if (r46 == 0) goto L_0x00cb
            if (r2 != 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzui r2 = r3.zzb
            long r6 = r2.zzd
            com.google.android.gms.internal.ads.zzui r2 = r1.zzb
            long r8 = r2.zzd
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c5
            android.util.Pair r6 = new android.util.Pair
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.Integer r7 = java.lang.Integer.valueOf(r15)
            r6.<init>(r2, r7)
            r7 = r6
            r2 = r15
            r6 = r5
            goto L_0x00d9
        L_0x00c5:
            r2 = r5
            r6 = r15
            goto L_0x00cd
        L_0x00c8:
            r6 = r2
            r2 = r5
            goto L_0x00cd
        L_0x00cb:
            r6 = r2
            r2 = r15
        L_0x00cd:
            android.util.Pair r7 = new android.util.Pair
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r7.<init>(r8, r12)
            r41 = r6
            r6 = r2
            r2 = r41
        L_0x00d9:
            java.lang.Object r8 = r7.first
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.Object r7 = r7.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r8 == 0) goto L_0x0112
            com.google.android.gms.internal.ads.zzcc r12 = r1.zza
            boolean r12 = r12.zzo()
            if (r12 != 0) goto L_0x010c
            com.google.android.gms.internal.ads.zzcc r12 = r1.zza
            com.google.android.gms.internal.ads.zzui r9 = r1.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzca r10 = r0.zzn
            com.google.android.gms.internal.ads.zzca r9 = r12.zzn(r9, r10)
            int r9 = r9.zzc
            com.google.android.gms.internal.ads.zzcc r10 = r1.zza
            com.google.android.gms.internal.ads.zzcb r12 = r0.zza
            com.google.android.gms.internal.ads.zzcb r9 = r10.zze(r9, r12, r13)
            com.google.android.gms.internal.ads.zzbc r9 = r9.zzd
            goto L_0x010d
        L_0x010c:
            r9 = 0
        L_0x010d:
            com.google.android.gms.internal.ads.zzbh r10 = com.google.android.gms.internal.ads.zzbh.zza
            r0.zzR = r10
            goto L_0x0113
        L_0x0112:
            r9 = 0
        L_0x0113:
            if (r8 != 0) goto L_0x011f
            java.util.List r10 = r3.zzj
            java.util.List r12 = r1.zzj
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0151
        L_0x011f:
            com.google.android.gms.internal.ads.zzbh r10 = r0.zzR
            com.google.android.gms.internal.ads.zzbf r10 = r10.zza()
            java.util.List r12 = r1.zzj
            r11 = r15
        L_0x0128:
            int r15 = r12.size()
            if (r11 >= r15) goto L_0x014b
            java.lang.Object r15 = r12.get(r11)
            com.google.android.gms.internal.ads.zzbk r15 = (com.google.android.gms.internal.ads.zzbk) r15
            r5 = 0
        L_0x0135:
            int r13 = r15.zza()
            if (r5 >= r13) goto L_0x0145
            com.google.android.gms.internal.ads.zzbj r13 = r15.zzb(r5)
            r13.zza(r10)
            int r5 = r5 + 1
            goto L_0x0135
        L_0x0145:
            int r11 = r11 + 1
            r5 = 1
            r13 = 0
            goto L_0x0128
        L_0x014b:
            com.google.android.gms.internal.ads.zzbh r5 = r10.zzu()
            r0.zzR = r5
        L_0x0151:
            com.google.android.gms.internal.ads.zzcc r5 = r42.zzn()
            boolean r10 = r5.zzo()
            if (r10 == 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzbh r5 = r0.zzR
            goto L_0x017b
        L_0x015e:
            int r10 = r42.zzd()
            com.google.android.gms.internal.ads.zzcb r11 = r0.zza
            r12 = 0
            com.google.android.gms.internal.ads.zzcb r5 = r5.zze(r10, r11, r12)
            com.google.android.gms.internal.ads.zzbc r5 = r5.zzd
            com.google.android.gms.internal.ads.zzbh r10 = r0.zzR
            com.google.android.gms.internal.ads.zzbf r10 = r10.zza()
            com.google.android.gms.internal.ads.zzbh r5 = r5.zzd
            r10.zzb(r5)
            com.google.android.gms.internal.ads.zzbh r5 = r10.zzu()
        L_0x017b:
            com.google.android.gms.internal.ads.zzbh r10 = r0.zzF
            boolean r10 = r5.equals(r10)
            r11 = 1
            r10 = r10 ^ r11
            r0.zzF = r5
            boolean r5 = r3.zzl
            boolean r11 = r1.zzl
            if (r5 == r11) goto L_0x018d
            r11 = 1
            goto L_0x018e
        L_0x018d:
            r11 = 0
        L_0x018e:
            int r5 = r3.zze
            int r12 = r1.zze
            if (r5 == r12) goto L_0x0196
            r5 = 1
            goto L_0x0197
        L_0x0196:
            r5 = 0
        L_0x0197:
            if (r5 != 0) goto L_0x019b
            if (r11 == 0) goto L_0x019e
        L_0x019b:
            r42.zzah()
        L_0x019e:
            boolean r12 = r3.zzg
            boolean r13 = r1.zzg
            if (r12 == r13) goto L_0x01a6
            r12 = 1
            goto L_0x01a7
        L_0x01a6:
            r12 = 0
        L_0x01a7:
            if (r4 == 0) goto L_0x01b6
            com.google.android.gms.internal.ads.zzdz r4 = r0.zzl
            com.google.android.gms.internal.ads.zzik r13 = new com.google.android.gms.internal.ads.zzik
            r14 = r44
            r13.<init>(r1, r14)
            r14 = 0
            r4.zzd(r14, r13)
        L_0x01b6:
            if (r6 == 0) goto L_0x02e4
            com.google.android.gms.internal.ads.zzca r6 = new com.google.android.gms.internal.ads.zzca
            r6.<init>()
            com.google.android.gms.internal.ads.zzcc r13 = r3.zza
            boolean r13 = r13.zzo()
            if (r13 != 0) goto L_0x01f7
            com.google.android.gms.internal.ads.zzui r13 = r3.zzb
            java.lang.Object r13 = r13.zza
            com.google.android.gms.internal.ads.zzcc r14 = r3.zza
            r14.zzn(r13, r6)
            int r14 = r6.zzc
            com.google.android.gms.internal.ads.zzcc r15 = r3.zza
            int r15 = r15.zza(r13)
            com.google.android.gms.internal.ads.zzcc r4 = r3.zza
            r47 = r13
            com.google.android.gms.internal.ads.zzcb r13 = r0.zza
            r17 = r11
            r18 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzcb r4 = r4.zze(r14, r13, r11)
            java.lang.Object r4 = r4.zzb
            com.google.android.gms.internal.ads.zzcb r11 = r0.zza
            com.google.android.gms.internal.ads.zzbc r11 = r11.zzd
            r23 = r47
            r20 = r4
            r22 = r11
            r21 = r14
            r24 = r15
            goto L_0x0205
        L_0x01f7:
            r17 = r11
            r18 = r12
            r21 = r50
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = -1
        L_0x0205:
            if (r2 != 0) goto L_0x022f
            com.google.android.gms.internal.ads.zzui r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x021e
            com.google.android.gms.internal.ads.zzui r4 = r3.zzb
            int r11 = r4.zzb
            int r4 = r4.zzc
            long r11 = r6.zzh(r11, r4)
            long r13 = zzV(r3)
            goto L_0x0241
        L_0x021e:
            com.google.android.gms.internal.ads.zzui r4 = r3.zzb
            int r4 = r4.zze
            r11 = -1
            if (r4 == r11) goto L_0x022c
            com.google.android.gms.internal.ads.zzkx r4 = r0.zzS
            long r11 = zzV(r4)
            goto L_0x0240
        L_0x022c:
            long r11 = r6.zzd
            goto L_0x0240
        L_0x022f:
            com.google.android.gms.internal.ads.zzui r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x023e
            long r11 = r3.zzr
            long r13 = zzV(r3)
            goto L_0x0241
        L_0x023e:
            long r11 = r3.zzr
        L_0x0240:
            r13 = r11
        L_0x0241:
            com.google.android.gms.internal.ads.zzbv r4 = new com.google.android.gms.internal.ads.zzbv
            int r6 = com.google.android.gms.internal.ads.zzet.zza
            com.google.android.gms.internal.ads.zzui r6 = r3.zzb
            int r15 = r6.zzb
            int r6 = r6.zzc
            long r25 = com.google.android.gms.internal.ads.zzet.zzu(r11)
            long r27 = com.google.android.gms.internal.ads.zzet.zzu(r13)
            r19 = r4
            r29 = r15
            r30 = r6
            r19.<init>(r20, r21, r22, r23, r24, r25, r27, r29, r30)
            int r6 = r42.zzd()
            com.google.android.gms.internal.ads.zzkx r11 = r0.zzS
            com.google.android.gms.internal.ads.zzcc r11 = r11.zza
            boolean r11 = r11.zzo()
            if (r11 != 0) goto L_0x029d
            com.google.android.gms.internal.ads.zzkx r11 = r0.zzS
            com.google.android.gms.internal.ads.zzui r12 = r11.zzb
            java.lang.Object r12 = r12.zza
            com.google.android.gms.internal.ads.zzcc r11 = r11.zza
            com.google.android.gms.internal.ads.zzca r13 = r0.zzn
            r11.zzn(r12, r13)
            com.google.android.gms.internal.ads.zzkx r11 = r0.zzS
            com.google.android.gms.internal.ads.zzcc r11 = r11.zza
            int r11 = r11.zza(r12)
            com.google.android.gms.internal.ads.zzkx r13 = r0.zzS
            com.google.android.gms.internal.ads.zzcc r13 = r13.zza
            com.google.android.gms.internal.ads.zzcb r14 = r0.zza
            r46 = r11
            r15 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzcb r13 = r13.zze(r6, r14, r11)
            java.lang.Object r11 = r13.zzb
            com.google.android.gms.internal.ads.zzcb r12 = r0.zza
            com.google.android.gms.internal.ads.zzbc r12 = r12.zzd
            r34 = r46
            r30 = r11
            r32 = r12
            r33 = r15
            goto L_0x02a5
        L_0x029d:
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = -1
        L_0x02a5:
            long r35 = com.google.android.gms.internal.ads.zzet.zzu(r48)
            com.google.android.gms.internal.ads.zzbv r11 = new com.google.android.gms.internal.ads.zzbv
            com.google.android.gms.internal.ads.zzkx r12 = r0.zzS
            com.google.android.gms.internal.ads.zzui r12 = r12.zzb
            boolean r12 = r12.zzb()
            if (r12 == 0) goto L_0x02c2
            com.google.android.gms.internal.ads.zzkx r12 = r0.zzS
            long r12 = zzV(r12)
            long r12 = com.google.android.gms.internal.ads.zzet.zzu(r12)
            r37 = r12
            goto L_0x02c4
        L_0x02c2:
            r37 = r35
        L_0x02c4:
            com.google.android.gms.internal.ads.zzkx r12 = r0.zzS
            com.google.android.gms.internal.ads.zzui r12 = r12.zzb
            int r13 = r12.zzb
            int r12 = r12.zzc
            r29 = r11
            r31 = r6
            r39 = r13
            r40 = r12
            r29.<init>(r30, r31, r32, r33, r34, r35, r37, r39, r40)
            com.google.android.gms.internal.ads.zzdz r6 = r0.zzl
            com.google.android.gms.internal.ads.zzip r12 = new com.google.android.gms.internal.ads.zzip
            r12.<init>(r2, r4, r11)
            r2 = 11
            r6.zzd(r2, r12)
            goto L_0x02e8
        L_0x02e4:
            r17 = r11
            r18 = r12
        L_0x02e8:
            if (r8 == 0) goto L_0x02f6
            com.google.android.gms.internal.ads.zzdz r2 = r0.zzl
            com.google.android.gms.internal.ads.zzir r4 = new com.google.android.gms.internal.ads.zzir
            r4.<init>(r9, r7)
            r11 = 1
            r2.zzd(r11, r4)
            goto L_0x02f7
        L_0x02f6:
            r11 = 1
        L_0x02f7:
            com.google.android.gms.internal.ads.zzhw r2 = r3.zzf
            com.google.android.gms.internal.ads.zzhw r4 = r1.zzf
            r6 = 10
            if (r2 == r4) goto L_0x0317
            com.google.android.gms.internal.ads.zzdz r2 = r0.zzl
            com.google.android.gms.internal.ads.zzis r4 = new com.google.android.gms.internal.ads.zzis
            r4.<init>(r1)
            r2.zzd(r6, r4)
            com.google.android.gms.internal.ads.zzhw r2 = r1.zzf
            if (r2 == 0) goto L_0x0317
            com.google.android.gms.internal.ads.zzdz r2 = r0.zzl
            com.google.android.gms.internal.ads.zzit r4 = new com.google.android.gms.internal.ads.zzit
            r4.<init>(r1)
            r2.zzd(r6, r4)
        L_0x0317:
            com.google.android.gms.internal.ads.zzyc r2 = r3.zzi
            com.google.android.gms.internal.ads.zzyc r4 = r1.zzi
            if (r2 == r4) goto L_0x032f
            com.google.android.gms.internal.ads.zzyb r2 = r0.zzi
            java.lang.Object r4 = r4.zze
            r2.zzp(r4)
            com.google.android.gms.internal.ads.zzdz r2 = r0.zzl
            com.google.android.gms.internal.ads.zziu r4 = new com.google.android.gms.internal.ads.zziu
            r4.<init>(r1)
            r7 = 2
            r2.zzd(r7, r4)
        L_0x032f:
            if (r10 == 0) goto L_0x033f
            com.google.android.gms.internal.ads.zzbh r2 = r0.zzF
            com.google.android.gms.internal.ads.zzdz r4 = r0.zzl
            com.google.android.gms.internal.ads.zziv r7 = new com.google.android.gms.internal.ads.zziv
            r7.<init>(r2)
            r2 = 14
            r4.zzd(r2, r7)
        L_0x033f:
            if (r18 == 0) goto L_0x034c
            com.google.android.gms.internal.ads.zzdz r2 = r0.zzl
            com.google.android.gms.internal.ads.zziw r4 = new com.google.android.gms.internal.ads.zziw
            r4.<init>(r1)
            r7 = 3
            r2.zzd(r7, r4)
        L_0x034c:
            if (r5 != 0) goto L_0x0350
            if (r17 == 0) goto L_0x035b
        L_0x0350:
            com.google.android.gms.internal.ads.zzdz r2 = r0.zzl
            com.google.android.gms.internal.ads.zzix r4 = new com.google.android.gms.internal.ads.zzix
            r4.<init>(r1)
            r7 = -1
            r2.zzd(r7, r4)
        L_0x035b:
            r2 = 4
            if (r5 == 0) goto L_0x0368
            com.google.android.gms.internal.ads.zzdz r4 = r0.zzl
            com.google.android.gms.internal.ads.zziy r5 = new com.google.android.gms.internal.ads.zziy
            r5.<init>(r1)
            r4.zzd(r2, r5)
        L_0x0368:
            r4 = 5
            if (r17 == 0) goto L_0x0377
            com.google.android.gms.internal.ads.zzdz r5 = r0.zzl
            com.google.android.gms.internal.ads.zzil r7 = new com.google.android.gms.internal.ads.zzil
            r8 = r45
            r7.<init>(r1, r8)
            r5.zzd(r4, r7)
        L_0x0377:
            int r5 = r3.zzm
            int r7 = r1.zzm
            r8 = 6
            if (r5 == r7) goto L_0x0388
            com.google.android.gms.internal.ads.zzdz r5 = r0.zzl
            com.google.android.gms.internal.ads.zzim r7 = new com.google.android.gms.internal.ads.zzim
            r7.<init>(r1)
            r5.zzd(r8, r7)
        L_0x0388:
            boolean r5 = r3.zzi()
            boolean r7 = r43.zzi()
            r9 = 7
            if (r5 == r7) goto L_0x039d
            com.google.android.gms.internal.ads.zzdz r5 = r0.zzl
            com.google.android.gms.internal.ads.zzin r7 = new com.google.android.gms.internal.ads.zzin
            r7.<init>(r1)
            r5.zzd(r9, r7)
        L_0x039d:
            com.google.android.gms.internal.ads.zzbq r3 = r3.zzn
            com.google.android.gms.internal.ads.zzbq r5 = r1.zzn
            boolean r3 = r3.equals(r5)
            r5 = 12
            if (r3 != 0) goto L_0x03b3
            com.google.android.gms.internal.ads.zzdz r3 = r0.zzl
            com.google.android.gms.internal.ads.zzio r7 = new com.google.android.gms.internal.ads.zzio
            r7.<init>(r1)
            r3.zzd(r5, r7)
        L_0x03b3:
            com.google.android.gms.internal.ads.zzbt r1 = r0.zzE
            com.google.android.gms.internal.ads.zzbw r3 = r0.zzg
            com.google.android.gms.internal.ads.zzbt r7 = r0.zzc
            int r10 = com.google.android.gms.internal.ads.zzet.zza
            boolean r10 = r3.zzw()
            r12 = r3
            com.google.android.gms.internal.ads.zzj r12 = (com.google.android.gms.internal.ads.zzj) r12
            com.google.android.gms.internal.ads.zzcc r13 = r12.zzn()
            boolean r14 = r13.zzo()
            if (r14 != 0) goto L_0x03de
            int r14 = r12.zzd()
            com.google.android.gms.internal.ads.zzcb r15 = r12.zza
            r5 = 0
            com.google.android.gms.internal.ads.zzcb r13 = r13.zze(r14, r15, r5)
            boolean r5 = r13.zzh
            if (r5 == 0) goto L_0x03de
            r5 = r11
            goto L_0x03df
        L_0x03de:
            r5 = 0
        L_0x03df:
            com.google.android.gms.internal.ads.zzcc r6 = r12.zzn()
            boolean r13 = r6.zzo()
            if (r13 == 0) goto L_0x03ee
            r13 = -1
            r14 = 0
            r16 = 0
            goto L_0x0405
        L_0x03ee:
            int r13 = r12.zzd()
            r12.zzh()
            r12.zzv()
            r14 = 0
            int r6 = r6.zzk(r13, r14, r14)
            r13 = -1
            if (r6 == r13) goto L_0x0403
            r16 = r11
            goto L_0x0405
        L_0x0403:
            r16 = r14
        L_0x0405:
            com.google.android.gms.internal.ads.zzcc r6 = r12.zzn()
            boolean r15 = r6.zzo()
            if (r15 == 0) goto L_0x0411
        L_0x040f:
            r6 = r14
            goto L_0x0422
        L_0x0411:
            int r15 = r12.zzd()
            r12.zzh()
            r12.zzv()
            int r6 = r6.zzj(r15, r14, r14)
            if (r6 == r13) goto L_0x040f
            r6 = r11
        L_0x0422:
            com.google.android.gms.internal.ads.zzcc r13 = r12.zzn()
            boolean r15 = r13.zzo()
            if (r15 != 0) goto L_0x0440
            int r15 = r12.zzd()
            com.google.android.gms.internal.ads.zzcb r11 = r12.zza
            r8 = 0
            com.google.android.gms.internal.ads.zzcb r11 = r13.zze(r15, r11, r8)
            boolean r11 = r11.zzb()
            if (r11 == 0) goto L_0x0442
            r11 = 1
            goto L_0x0443
        L_0x0440:
            r8 = 0
        L_0x0442:
            r11 = r14
        L_0x0443:
            com.google.android.gms.internal.ads.zzcc r13 = r12.zzn()
            boolean r15 = r13.zzo()
            if (r15 != 0) goto L_0x045d
            int r15 = r12.zzd()
            com.google.android.gms.internal.ads.zzcb r12 = r12.zza
            com.google.android.gms.internal.ads.zzcb r8 = r13.zze(r15, r12, r8)
            boolean r8 = r8.zzi
            if (r8 == 0) goto L_0x045d
            r8 = 1
            goto L_0x045e
        L_0x045d:
            r8 = r14
        L_0x045e:
            com.google.android.gms.internal.ads.zzcc r3 = r3.zzn()
            boolean r3 = r3.zzo()
            com.google.android.gms.internal.ads.zzbr r9 = new com.google.android.gms.internal.ads.zzbr
            r9.<init>()
            r9.zzb(r7)
            r7 = r10 ^ 1
            r9.zzd(r2, r7)
            if (r5 == 0) goto L_0x0479
            if (r10 != 0) goto L_0x0479
            r2 = 1
            goto L_0x047a
        L_0x0479:
            r2 = r14
        L_0x047a:
            r9.zzd(r4, r2)
            if (r16 == 0) goto L_0x0483
            if (r10 != 0) goto L_0x0483
            r2 = 1
            goto L_0x0484
        L_0x0483:
            r2 = r14
        L_0x0484:
            r4 = 6
            r9.zzd(r4, r2)
            if (r3 != 0) goto L_0x0494
            if (r16 != 0) goto L_0x0490
            if (r11 == 0) goto L_0x0490
            if (r5 == 0) goto L_0x0494
        L_0x0490:
            if (r10 != 0) goto L_0x0494
            r2 = 1
            goto L_0x0495
        L_0x0494:
            r2 = r14
        L_0x0495:
            r4 = 7
            r9.zzd(r4, r2)
            if (r6 == 0) goto L_0x049f
            if (r10 != 0) goto L_0x049f
            r2 = 1
            goto L_0x04a0
        L_0x049f:
            r2 = r14
        L_0x04a0:
            r4 = 8
            r9.zzd(r4, r2)
            if (r3 != 0) goto L_0x04b1
            if (r6 != 0) goto L_0x04ad
            if (r11 == 0) goto L_0x04b1
            if (r8 == 0) goto L_0x04b1
        L_0x04ad:
            if (r10 != 0) goto L_0x04b1
            r11 = 1
            goto L_0x04b2
        L_0x04b1:
            r11 = r14
        L_0x04b2:
            r2 = 9
            r9.zzd(r2, r11)
            r2 = 10
            r9.zzd(r2, r7)
            if (r5 == 0) goto L_0x04c4
            if (r10 != 0) goto L_0x04c4
            r2 = 11
            r11 = 1
            goto L_0x04c7
        L_0x04c4:
            r11 = r14
            r2 = 11
        L_0x04c7:
            r9.zzd(r2, r11)
            if (r5 == 0) goto L_0x04d2
            if (r10 != 0) goto L_0x04d2
            r2 = 12
            r5 = 1
            goto L_0x04d5
        L_0x04d2:
            r5 = r14
            r2 = 12
        L_0x04d5:
            r9.zzd(r2, r5)
            com.google.android.gms.internal.ads.zzbt r2 = r9.zze()
            r0.zzE = r2
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x04f0
            com.google.android.gms.internal.ads.zzdz r1 = r0.zzl
            com.google.android.gms.internal.ads.zzij r2 = new com.google.android.gms.internal.ads.zzij
            r2.<init>(r0)
            r3 = 13
            r1.zzd(r3, r2)
        L_0x04f0:
            com.google.android.gms.internal.ads.zzdz r1 = r0.zzl
            r1.zzc()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjm.zzag(com.google.android.gms.internal.ads.zzkx, int, int, boolean, int, long, int, boolean):void");
    }

    private final void zzah() {
        int zzf2 = zzf();
        if (zzf2 == 2 || zzf2 == 3) {
            zzai();
            boolean z = this.zzS.zzo;
            zzu();
            zzu();
        }
    }

    private final void zzai() {
        IllegalStateException illegalStateException;
        this.zze.zzb();
        if (Thread.currentThread() != this.zzr.getThread()) {
            String format = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", new Object[]{Thread.currentThread().getName(), this.zzr.getThread().getName()});
            if (!this.zzO) {
                if (this.zzP) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzea.zzg("ExoPlayerImpl", format, illegalStateException);
                this.zzP = true;
                return;
            }
            throw new IllegalStateException(format);
        }
    }

    public final void zzA(zzlq zzlq) {
        zzai();
        this.zzq.zzQ(zzlq);
    }

    public final void zzB(zzuk zzuk) {
        boolean z;
        zzai();
        List singletonList = Collections.singletonList(zzuk);
        zzai();
        zzai();
        zzR(this.zzS);
        zzk();
        this.zzy++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzW = this.zzW.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < singletonList.size(); i2++) {
            zzku zzku = new zzku((zzuk) singletonList.get(i2), this.zzp);
            arrayList.add(zzku);
            this.zzo.add(i2, new zzjl(zzku.zzb, zzku.zza));
        }
        this.zzW = this.zzW.zzg(0, arrayList.size());
        zzlc zzlc = new zzlc(this.zzo, this.zzW);
        if (zzlc.zzo() || zzlc.zzc() >= 0) {
            int zzg2 = zzlc.zzg(false);
            zzkx zzY = zzY(this.zzS, zzlc, zzX(zzlc, zzg2, -9223372036854775807L));
            int i3 = zzY.zze;
            if (!(zzg2 == -1 || i3 == 1)) {
                i3 = 4;
                if (!zzlc.zzo() && zzg2 < zzlc.zzc()) {
                    i3 = 2;
                }
            }
            zzkx zze2 = zzY.zze(i3);
            this.zzk.zzp(arrayList, zzg2, zzet.zzr(-9223372036854775807L), this.zzW);
            if (this.zzS.zzb.zza.equals(zze2.zzb.zza) || this.zzS.zza.zzo()) {
                z = false;
            } else {
                z = true;
            }
            zzag(zze2, 0, 1, z, 4, zzU(zze2), -1, false);
            return;
        }
        throw new zzaj(zzlc, -1, -9223372036854775807L);
    }

    public final zzhw zzE() {
        zzai();
        return this.zzS.zzf;
    }

    public final /* synthetic */ void zzN(zzjv zzjv) {
        long j;
        boolean z;
        boolean z2;
        int i = this.zzy - zzjv.zzb;
        this.zzy = i;
        boolean z3 = true;
        if (zzjv.zzc) {
            this.zzz = zzjv.zzd;
            this.zzA = true;
        }
        if (zzjv.zze) {
            this.zzB = zzjv.zzf;
        }
        if (i == 0) {
            zzcc zzcc = zzjv.zza.zza;
            if (!this.zzS.zza.zzo() && zzcc.zzo()) {
                this.zzT = -1;
                this.zzU = 0;
            }
            if (!zzcc.zzo()) {
                List zzw2 = ((zzlc) zzcc).zzw();
                if (zzw2.size() == this.zzo.size()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzdi.zzf(z2);
                for (int i2 = 0; i2 < zzw2.size(); i2++) {
                    ((zzjl) this.zzo.get(i2)).zzc((zzcc) zzw2.get(i2));
                }
            }
            if (this.zzA) {
                if (zzjv.zza.zzb.equals(this.zzS.zzb) && zzjv.zza.zzd == this.zzS.zzr) {
                    z3 = false;
                }
                if (!z3) {
                    j = -9223372036854775807L;
                } else if (zzcc.zzo() || zzjv.zza.zzb.zzb()) {
                    j = zzjv.zza.zzd;
                } else {
                    zzkx zzkx = zzjv.zza;
                    zzui zzui = zzkx.zzb;
                    j = zzkx.zzd;
                    zzW(zzcc, zzui, j);
                }
                z = z3;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.zzA = false;
            zzag(zzjv.zza, 1, this.zzB, z, this.zzz, j, -1, false);
        }
    }

    public final /* synthetic */ void zzO(zzjv zzjv) {
        this.zzj.zzh(new zzjb(this, zzjv));
    }

    public final /* synthetic */ void zzP(zzbu zzbu) {
        zzbu.zza(this.zzE);
    }

    public final void zza(int i, long j, int i2, boolean z) {
        boolean z2;
        zzai();
        if (i != -1) {
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzdi.zzd(z2);
            zzcc zzcc = this.zzS.zza;
            if (zzcc.zzo() || i < zzcc.zzc()) {
                this.zzq.zzu();
                this.zzy++;
                if (zzw()) {
                    zzea.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                    zzjv zzjv = new zzjv(this.zzS);
                    zzjv.zza(1);
                    this.zzV.zza.zzO(zzjv);
                    return;
                }
                zzkx zzkx = this.zzS;
                int i3 = zzkx.zze;
                if (i3 == 3 || (i3 == 4 && !zzcc.zzo())) {
                    zzkx = this.zzS.zze(2);
                }
                int zzd2 = zzd();
                zzkx zzY = zzY(zzkx, zzcc, zzX(zzcc, i, j));
                this.zzk.zzk(zzcc, i, zzet.zzr(j));
                zzag(zzY, 0, 1, true, 1, zzU(zzY), zzd2, false);
            }
        }
    }

    public final int zzb() {
        zzai();
        if (zzw()) {
            return this.zzS.zzb.zzb;
        }
        return -1;
    }

    public final int zzc() {
        zzai();
        if (zzw()) {
            return this.zzS.zzb.zzc;
        }
        return -1;
    }

    public final int zzd() {
        zzai();
        int zzR2 = zzR(this.zzS);
        if (zzR2 == -1) {
            return 0;
        }
        return zzR2;
    }

    public final int zze() {
        zzai();
        if (this.zzS.zza.zzo()) {
            return 0;
        }
        zzkx zzkx = this.zzS;
        return zzkx.zza.zza(zzkx.zzb.zza);
    }

    public final int zzf() {
        zzai();
        return this.zzS.zze;
    }

    public final int zzg() {
        zzai();
        return this.zzS.zzm;
    }

    public final int zzh() {
        zzai();
        return 0;
    }

    public final long zzi() {
        zzai();
        if (zzw()) {
            zzkx zzkx = this.zzS;
            if (zzkx.zzk.equals(zzkx.zzb)) {
                return zzet.zzu(this.zzS.zzp);
            }
            return zzl();
        }
        zzai();
        if (this.zzS.zza.zzo()) {
            return this.zzU;
        }
        zzkx zzkx2 = this.zzS;
        long j = 0;
        if (zzkx2.zzk.zzd != zzkx2.zzb.zzd) {
            return zzet.zzu(zzkx2.zza.zze(zzd(), this.zza, 0).zzm);
        }
        long j2 = zzkx2.zzp;
        if (this.zzS.zzk.zzb()) {
            zzkx zzkx3 = this.zzS;
            zzkx3.zza.zzn(zzkx3.zzk.zza, this.zzn).zzi(this.zzS.zzk.zzb);
        } else {
            j = j2;
        }
        zzkx zzkx4 = this.zzS;
        zzW(zzkx4.zza, zzkx4.zzk, j);
        return zzet.zzu(j);
    }

    public final long zzj() {
        zzai();
        return zzT(this.zzS);
    }

    public final long zzk() {
        zzai();
        return zzet.zzu(zzU(this.zzS));
    }

    public final long zzl() {
        zzai();
        if (!zzw()) {
            zzcc zzn2 = zzn();
            if (zzn2.zzo()) {
                return -9223372036854775807L;
            }
            return zzet.zzu(zzn2.zze(zzd(), this.zza, 0).zzm);
        }
        zzkx zzkx = this.zzS;
        zzui zzui = zzkx.zzb;
        zzkx.zza.zzn(zzui.zza, this.zzn);
        return zzet.zzu(this.zzn.zzh(zzui.zzb, zzui.zzc));
    }

    public final long zzm() {
        zzai();
        return zzet.zzu(this.zzS.zzq);
    }

    public final zzcc zzn() {
        zzai();
        return this.zzS.zza;
    }

    public final zzck zzo() {
        zzai();
        return this.zzS.zzi.zzd;
    }

    public final void zzp() {
        zzai();
        zzhl zzhl = this.zzw;
        boolean zzu2 = zzu();
        int i = 2;
        int zzb2 = zzhl.zzb(zzu2, 2);
        zzaf(zzu2, zzb2, zzS(zzu2, zzb2));
        zzkx zzkx = this.zzS;
        if (zzkx.zze == 1) {
            zzkx zzd2 = zzkx.zzd((zzhw) null);
            if (true == zzd2.zza.zzo()) {
                i = 4;
            }
            zzkx zze2 = zzd2.zze(i);
            this.zzy++;
            this.zzk.zzj();
            zzag(zze2, 1, 1, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final void zzq(boolean z) {
        zzai();
        int zzb2 = this.zzw.zzb(z, zzf());
        zzaf(z, zzb2, zzS(z, zzb2));
    }

    public final void zzr(Surface surface) {
        int i;
        zzai();
        zzad(surface);
        if (surface == null) {
            i = 0;
        } else {
            i = -1;
        }
        zzaa(i, i);
    }

    public final void zzs(float f) {
        zzai();
        float max = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzM != max) {
            this.zzM = max;
            zzac();
            zzdz zzdz = this.zzl;
            zzdz.zzd(22, new zziq(max));
            zzdz.zzc();
        }
    }

    public final void zzt() {
        zzai();
        this.zzw.zzb(zzu(), 1);
        zzae((zzhw) null);
        int i = zzdc.zza;
        zzfxr zzm2 = zzfxr.zzm();
        long j = this.zzS.zzr;
        zzfxr.zzk(zzm2);
    }

    public final boolean zzu() {
        zzai();
        return this.zzS.zzl;
    }

    public final boolean zzv() {
        zzai();
        return false;
    }

    public final boolean zzw() {
        zzai();
        return this.zzS.zzb.zzb();
    }

    public final int zzx() {
        zzai();
        int length = this.zzh.length;
        return 2;
    }

    public final void zzy(zzlq zzlq) {
        this.zzq.zzt(zzlq);
    }

    public final void zzz() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzet.zze;
        String zza = zzbd.zza();
        StringBuilder b = C0437ME.b("Release ", hexString, " [AndroidXMedia3/1.4.0-alpha02] [", str, "] [");
        b.append(zza);
        b.append("]");
        zzea.zze("ExoPlayerImpl", b.toString());
        zzai();
        this.zzw.zzd();
        if (!this.zzk.zzo()) {
            zzdz zzdz = this.zzl;
            zzdz.zzd(10, new zzja());
            zzdz.zzc();
        }
        this.zzl.zze();
        this.zzj.zze((Object) null);
        this.zzs.zzf(this.zzq);
        zzkx zzkx = this.zzS;
        boolean z = zzkx.zzo;
        zzkx zze2 = zzkx.zze(1);
        this.zzS = zze2;
        zzkx zza2 = zze2.zza(zze2.zzb);
        this.zzS = zza2;
        zza2.zzp = zza2.zzr;
        this.zzS.zzq = 0;
        this.zzq.zzP();
        this.zzi.zzj();
        Surface surface = this.zzH;
        if (surface != null) {
            surface.release();
            this.zzH = null;
        }
        int i = zzdc.zza;
    }
}
