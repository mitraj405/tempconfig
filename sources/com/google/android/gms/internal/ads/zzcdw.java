package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcdw extends zzcbb implements zzgu, zzlq {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcdh zzc;
    private final zzxt zzd;
    private final zzcbj zze;
    private final WeakReference zzf;
    private final zzvm zzg;
    private zzih zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcba zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private final Object zzq = new Object();
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcdj zzt;
    private final Set zzu = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00e3, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzbG)).booleanValue() == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e7, code lost:
        if (r5.zzi == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e9, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ec, code lost:
        if (r5.zzl == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ee, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcdn(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f6, code lost:
        if (r5.zzh <= 0) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f8, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcdo(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fe, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcdp(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0105, code lost:
        if (r5.zzi == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0107, code lost:
        r5 = new com.google.android.gms.internal.ads.zzcdq(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x010e, code lost:
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010f, code lost:
        r4 = r3.zzi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0111, code lost:
        if (r4 == null) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0117, code lost:
        if (r4.limit() <= 0) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0119, code lost:
        r4 = new byte[r3.zzi.limit()];
        r3.zzi.get(r4);
        r5 = new com.google.android.gms.internal.ads.zzcdr(r5, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcdw(android.content.Context r4, com.google.android.gms.internal.ads.zzcbj r5, com.google.android.gms.internal.ads.zzcbk r6, java.lang.Integer r7) {
        /*
            r3 = this;
            r3.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r3.zzq = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.zzu = r0
            r3.zzb = r4
            r3.zze = r5
            r3.zzr = r7
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference
            r7.<init>(r6)
            r3.zzf = r7
            com.google.android.gms.internal.ads.zzcdh r7 = new com.google.android.gms.internal.ads.zzcdh
            r7.<init>()
            r3.zzc = r7
            com.google.android.gms.internal.ads.zzxt r0 = new com.google.android.gms.internal.ads.zzxt
            r0.<init>(r4)
            r3.zzd = r0
            boolean r1 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "SimpleExoPlayerAdapter initialize "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.ads.internal.util.zze.zza(r1)
        L_0x003f:
            java.util.concurrent.atomic.AtomicInteger r1 = com.google.android.gms.internal.ads.zzcbb.zzD()
            r1.incrementAndGet()
            com.google.android.gms.internal.ads.zzlk r1 = new com.google.android.gms.internal.ads.zzlk
            com.google.android.gms.internal.ads.zzcdt r2 = new com.google.android.gms.internal.ads.zzcdt
            r2.<init>(r3)
            r1.<init>(r4, r2)
            r1.zzb(r0)
            r1.zza(r7)
            com.google.android.gms.internal.ads.zzll r7 = r1.zzc()
            r3.zzh = r7
            r7.zzy(r3)
            r7 = 0
            r3.zzl = r7
            r0 = 0
            r3.zzn = r0
            r3.zzm = r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.zzs = r0
            r0 = 0
            r3.zzt = r0
            if (r6 == 0) goto L_0x0078
            java.lang.String r0 = r6.zzr()
        L_0x0078:
            com.google.android.gms.internal.ads.zzfus r0 = com.google.android.gms.internal.ads.zzfus.zzd(r0)
            java.lang.String r1 = ""
            java.lang.Object r0 = r0.zzb(r1)
            java.lang.String r0 = (java.lang.String) r0
            r3.zzo = r0
            if (r6 == 0) goto L_0x008d
            int r0 = r6.zzf()
            goto L_0x008e
        L_0x008d:
            r0 = r7
        L_0x008e:
            r3.zzp = r0
            com.google.android.gms.internal.ads.zzvm r0 = new com.google.android.gms.internal.ads.zzvm
            com.google.android.gms.ads.internal.util.zzt r1 = com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r6 = r6.zzn()
            java.lang.String r6 = r6.afmaVersion
            java.lang.String r4 = r1.zzc(r4, r6)
            boolean r6 = r3.zzj
            if (r6 == 0) goto L_0x00c0
            java.nio.ByteBuffer r6 = r3.zzi
            int r6 = r6.limit()
            if (r6 <= 0) goto L_0x00c0
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r5 = r3.zzi
            r5.get(r4)
            com.google.android.gms.internal.ads.zzcdl r5 = new com.google.android.gms.internal.ads.zzcdl
            r5.<init>(r4)
            goto L_0x012c
        L_0x00c0:
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzbO
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r1.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1 = 1
            if (r6 == 0) goto L_0x00e5
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzbG
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r2.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x00e9
        L_0x00e5:
            boolean r6 = r5.zzi
            if (r6 != 0) goto L_0x00ea
        L_0x00e9:
            r7 = r1
        L_0x00ea:
            boolean r6 = r5.zzl
            if (r6 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzcdn r6 = new com.google.android.gms.internal.ads.zzcdn
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00f4:
            int r6 = r5.zzh
            if (r6 <= 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzcdo r6 = new com.google.android.gms.internal.ads.zzcdo
            r6.<init>(r3, r4, r7)
            goto L_0x0103
        L_0x00fe:
            com.google.android.gms.internal.ads.zzcdp r6 = new com.google.android.gms.internal.ads.zzcdp
            r6.<init>(r3, r4, r7)
        L_0x0103:
            boolean r4 = r5.zzi
            if (r4 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzcdq r4 = new com.google.android.gms.internal.ads.zzcdq
            r4.<init>(r3, r6)
            r5 = r4
            goto L_0x010f
        L_0x010e:
            r5 = r6
        L_0x010f:
            java.nio.ByteBuffer r4 = r3.zzi
            if (r4 == 0) goto L_0x012c
            int r4 = r4.limit()
            if (r4 <= 0) goto L_0x012c
            java.nio.ByteBuffer r4 = r3.zzi
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r6 = r3.zzi
            r6.get(r4)
            com.google.android.gms.internal.ads.zzcdr r6 = new com.google.android.gms.internal.ads.zzcdr
            r6.<init>(r5, r4)
            r5 = r6
        L_0x012c:
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzl
            com.google.android.gms.internal.ads.zzbbu r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r6.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0144
            com.google.android.gms.internal.ads.zzcdv r4 = new com.google.android.gms.internal.ads.zzcdv
            r4.<init>()
            goto L_0x0149
        L_0x0144:
            com.google.android.gms.internal.ads.zzcdm r4 = new com.google.android.gms.internal.ads.zzcdm
            r4.<init>()
        L_0x0149:
            com.google.android.gms.internal.ads.zzvl r6 = new com.google.android.gms.internal.ads.zzvl
            r6.<init>(r4)
            r0.<init>(r5, r6)
            r3.zzg = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdw.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcbj, com.google.android.gms.internal.ads.zzcbk, java.lang.Integer):void");
    }

    private final boolean zzad() {
        if (this.zzt == null || !this.zzt.zzq()) {
            return false;
        }
        return true;
    }

    public final void finalize() {
        zzcbb.zzD().decrementAndGet();
        if (zze.zzc()) {
            zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzad()) {
            return (long) this.zzl;
        }
        return 0;
    }

    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j = this.zzn;
                Map zze2 = ((zzgp) this.zzs.remove(0)).zze();
                long j2 = 0;
                if (zze2 != null) {
                    Iterator it = zze2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (!(entry.getKey() == null || !zzfuf.zzc("content-length", (CharSequence) entry.getKey()) || entry.getValue() == null || ((List) entry.getValue()).get(0) == null)) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzn = j + j2;
            }
        }
        return this.zzn;
    }

    public final Integer zzC() {
        return this.zzr;
    }

    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzuk zzuk;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzuk = zzaa(uriArr[0]);
            } else {
                zzuk[] zzukArr = new zzuk[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzukArr[i] = zzaa(uriArr[i]);
                }
                zzuk = new zzux(false, false, new zztt(), zzukArr);
            }
            this.zzh.zzB(zzuk);
            this.zzh.zzp();
            zzcbb.zzE().incrementAndGet();
        }
    }

    public final void zzH() {
        zzih zzih = this.zzh;
        if (zzih != null) {
            zzih.zzA(this);
            this.zzh.zzz();
            this.zzh = null;
            zzcbb.zzE().decrementAndGet();
        }
    }

    public final void zzI(long j) {
        zzj zzj2 = (zzj) this.zzh;
        zzj2.zza(zzj2.zzd(), j, 5, false);
    }

    public final void zzJ(int i) {
        this.zzc.zzk(i);
    }

    public final void zzK(int i) {
        this.zzc.zzl(i);
    }

    public final void zzL(zzcba zzcba) {
        this.zzk = zzcba;
    }

    public final void zzM(int i) {
        this.zzc.zzm(i);
    }

    public final void zzN(int i) {
        this.zzc.zzn(i);
    }

    public final void zzO(boolean z) {
        this.zzh.zzq(z);
    }

    public final void zzP(Integer num) {
        this.zzr = num;
    }

    public final void zzQ(boolean z) {
        if (this.zzh != null) {
            int i = 0;
            while (true) {
                this.zzh.zzx();
                if (i < 2) {
                    zzxt zzxt = this.zzd;
                    zzxg zzc2 = zzxt.zzf().zzc();
                    zzc2.zzp(i, !z);
                    zzxt.zzl(zzc2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzR(int i) {
        for (WeakReference weakReference : this.zzu) {
            zzcdg zzcdg = (zzcdg) weakReference.get();
            if (zzcdg != null) {
                zzcdg.zzm(i);
            }
        }
    }

    public final void zzS(Surface surface, boolean z) {
        zzih zzih = this.zzh;
        if (zzih != null) {
            zzih.zzr(surface);
        }
    }

    public final void zzT(float f, boolean z) {
        zzih zzih = this.zzh;
        if (zzih != null) {
            zzih.zzs(f);
        }
    }

    public final void zzU() {
        this.zzh.zzt();
    }

    public final boolean zzV() {
        if (this.zzh != null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ zzfs zzW(String str, boolean z) {
        zzcdw zzcdw;
        if (true != z) {
            zzcdw = null;
        } else {
            zzcdw = this;
        }
        zzcbj zzcbj = this.zze;
        return new zzcdz(str, zzcdw, zzcbj.zzd, zzcbj.zze, zzcbj.zzm, zzcbj.zzn);
    }

    public final /* synthetic */ zzfs zzX(String str, boolean z) {
        zzcdw zzcdw;
        if (true != z) {
            zzcdw = null;
        } else {
            zzcdw = this;
        }
        zzcbj zzcbj = this.zze;
        zzcdg zzcdg = new zzcdg(str, zzcdw, zzcbj.zzd, zzcbj.zze, zzcbj.zzh);
        this.zzu.add(new WeakReference(zzcdg));
        return zzcdg;
    }

    public final /* synthetic */ zzfs zzY(String str, boolean z) {
        zzcdw zzcdw;
        zzgb zzgb = new zzgb();
        zzgb.zzf(str);
        if (true != z) {
            zzcdw = null;
        } else {
            zzcdw = this;
        }
        zzgb.zze(zzcdw);
        zzgb.zzc(this.zze.zzd);
        zzgb.zzd(this.zze.zze);
        zzgb.zzb(true);
        return zzgb.zza();
    }

    public final /* synthetic */ zzfs zzZ(zzfr zzfr) {
        zzfs zza2 = zzfr.zza();
        zzcdu zzcdu = new zzcdu(this);
        return new zzcdj(this.zzb, zza2, this.zzo, this.zzp, this, zzcdu);
    }

    public final void zza(zzfs zzfs, zzfy zzfy, boolean z, int i) {
        this.zzl += i;
    }

    public final zzuk zzaa(Uri uri) {
        zzam zzam = new zzam();
        zzam.zzb(uri);
        zzbc zzc2 = zzam.zzc();
        zzvm zzvm = this.zzg;
        zzvm.zza(this.zze.zzf);
        return zzvm.zzb(zzc2);
    }

    public final /* synthetic */ void zzab(boolean z, long j) {
        zzcba zzcba = this.zzk;
        if (zzcba != null) {
            zzcba.zzi(z, j);
        }
    }

    public final /* synthetic */ zzle[] zzac(Handler handler, zzaay zzaay, zzpe zzpe, zzwl zzwl, zztg zztg) {
        zzsq zzsq = zzsq.zza;
        Context context = this.zzb;
        zzqv zzqv = new zzqv(context, new zzry(context), zzsq, false, handler, zzpe, new zzqb(context).zzc());
        Context context2 = this.zzb;
        return new zzle[]{zzqv, new zzaaa(context2, new zzry(context2), zzsq, 0, false, handler, zzaay, -1, 30.0f)};
    }

    public final void zzd(zzfs zzfs, zzfy zzfy, boolean z) {
        if (zzfs instanceof zzgp) {
            synchronized (this.zzq) {
                this.zzs.add((zzgp) zzfs);
            }
        } else if (zzfs instanceof zzcdj) {
            this.zzt = (zzcdj) zzfs;
            zzcbk zzcbk = (zzcbk) this.zzf.get();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbG)).booleanValue() && zzcbk != null && this.zzt.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                zzt.zza.post(new zzcds(zzcbk, hashMap));
            }
        }
    }

    public final void zze(zzlo zzlo, zzaf zzaf, zzho zzho) {
        zzcbk zzcbk = (zzcbk) this.zzf.get();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbG)).booleanValue() && zzcbk != null) {
            HashMap hashMap = new HashMap();
            String str = zzaf.zzl;
            if (str != null) {
                hashMap.put("audioMime", str);
            }
            String str2 = zzaf.zzm;
            if (str2 != null) {
                hashMap.put("audioSampleMime", str2);
            }
            String str3 = zzaf.zzj;
            if (str3 != null) {
                hashMap.put("audioCodec", str3);
            }
            zzcbk.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzh(zzlo zzlo, int i, long j) {
        this.zzm += i;
    }

    public final void zzj(zzlo zzlo, zztz zztz, zzue zzue, IOException iOException, boolean z) {
        zzcba zzcba = this.zzk;
        if (zzcba == null) {
            return;
        }
        if (this.zze.zzj) {
            zzcba.zzl("onLoadException", iOException);
        } else {
            zzcba.zzk("onLoadError", iOException);
        }
    }

    public final void zzk(zzlo zzlo, int i) {
        zzcba zzcba = this.zzk;
        if (zzcba != null) {
            zzcba.zzm(i);
        }
    }

    public final void zzl(zzlo zzlo, zzbp zzbp) {
        zzcba zzcba = this.zzk;
        if (zzcba != null) {
            zzcba.zzk("onPlayerError", zzbp);
        }
    }

    public final void zzn(zzlo zzlo, Object obj, long j) {
        zzcba zzcba = this.zzk;
        if (zzcba != null) {
            zzcba.zzv();
        }
    }

    public final void zzp(zzlo zzlo, zzaf zzaf, zzho zzho) {
        zzcbk zzcbk = (zzcbk) this.zzf.get();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbG)).booleanValue() && zzcbk != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzaf.zzt));
            hashMap.put("bitRate", String.valueOf(zzaf.zzi));
            int i = zzaf.zzr;
            int i2 = zzaf.zzs;
            hashMap.put("resolution", i + "x" + i2);
            String str = zzaf.zzl;
            if (str != null) {
                hashMap.put("videoMime", str);
            }
            String str2 = zzaf.zzm;
            if (str2 != null) {
                hashMap.put("videoSampleMime", str2);
            }
            String str3 = zzaf.zzj;
            if (str3 != null) {
                hashMap.put("videoCodec", str3);
            }
            zzcbk.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzq(zzlo zzlo, zzcp zzcp) {
        zzcba zzcba = this.zzk;
        if (zzcba != null) {
            zzcba.zzD(zzcp.zzb, zzcp.zzc);
        }
    }

    public final int zzr() {
        return this.zzm;
    }

    public final int zzt() {
        return this.zzh.zzf();
    }

    public final long zzv() {
        return this.zzh.zzi();
    }

    public final long zzw() {
        return (long) this.zzl;
    }

    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min((long) this.zzl, this.zzt.zzk());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzh.zzk();
    }

    public final long zzz() {
        return this.zzh.zzl();
    }

    public final /* synthetic */ void zzg(zzlo zzlo, zzue zzue) {
    }

    public final /* synthetic */ void zzi(zzbw zzbw, zzlp zzlp) {
    }

    public final /* synthetic */ void zzo(zzlo zzlo, zzhn zzhn) {
    }

    public final void zzb(zzfs zzfs, zzfy zzfy, boolean z) {
    }

    public final void zzc(zzfs zzfs, zzfy zzfy, boolean z) {
    }

    public final /* synthetic */ void zzf(zzlo zzlo, int i, long j, long j2) {
    }

    public final /* synthetic */ void zzm(zzlo zzlo, zzbv zzbv, zzbv zzbv2, int i) {
    }
}
