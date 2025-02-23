package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzdo;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjs;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznk;
import com.google.android.gms.measurement.internal.zzin;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public class zznc implements zzil {
    private static volatile zznc zza;
    private List<Long> zzaa;
    private long zzab;
    private final Map<String, zzin> zzac;
    private final Map<String, zzav> zzad;
    private final Map<String, zzb> zzae;
    private zzkp zzaf;
    private String zzag;
    private final zznr zzah;
    private zzgt zzb;
    private zzfz zzc;
    private zzal zzd;
    private zzgg zze;
    private zzmw zzf;
    private zzu zzg;
    private final zznl zzh;
    private zzkn zzi;
    private zzmc zzj;
    private final zzna zzk;
    private zzgq zzl;
    /* access modifiers changed from: private */
    public final zzhj zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;
    private List<Runnable> zzq;
    private final Set<String> zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List<Long> zzz;

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public class zza implements zzap {
        zzfn.zzk zza;
        List<Long> zzb;
        List<zzfn.zzf> zzc;
        private long zzd;

        private static long zza(zzfn.zzf zzf) {
            return ((zzf.zzd() / 1000) / 60) / 60;
        }

        private zza() {
        }

        public final void zza(zzfn.zzk zzk) {
            Preconditions.checkNotNull(zzk);
            this.zza = zzk;
        }

        public final boolean zza(long j, zzfn.zzf zzf) {
            Preconditions.checkNotNull(zzf);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (!this.zzc.isEmpty() && zza(this.zzc.get(0)) != zza(zzf)) {
                return false;
            }
            long zzca = this.zzd + ((long) zzf.zzca());
            zznc.this.zze();
            if (zzca >= ((long) Math.max(0, zzbf.zzi.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzca;
            this.zzc.add(zzf);
            this.zzb.add(Long.valueOf(j));
            int size = this.zzc.size();
            zznc.this.zze();
            if (size >= Math.max(1, zzbf.zzj.zza(null).intValue())) {
                return false;
            }
            return true;
        }
    }

    private zznc(zznm zznm) {
        this(zznm, (zzhj) null);
    }

    private final void zzaa() {
        zzl().zzt();
        if (this.zzu || this.zzv || this.zzw) {
            zzj().zzp().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzj().zzp().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzab() {
        /*
            r21 = this;
            r0 = r21
            com.google.android.gms.measurement.internal.zzhc r1 = r21.zzl()
            r1.zzt()
            r21.zzs()
            long r1 = r0.zzp
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004d
            com.google.android.gms.common.util.Clock r1 = r21.zzb()
            long r1 = r1.elapsedRealtime()
            long r5 = r0.zzp
            long r1 = r1 - r5
            long r1 = java.lang.Math.abs(r1)
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzfw r1 = r21.zzj()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r1.zza(r2, r3)
            com.google.android.gms.measurement.internal.zzgg r1 = r21.zzy()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzmw r1 = r21.zzz()
            r1.zzu()
            return
        L_0x004b:
            r0.zzp = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzhj r1 = r0.zzm
            boolean r1 = r1.zzaf()
            if (r1 == 0) goto L_0x024e
            boolean r1 = r21.zzac()
            if (r1 != 0) goto L_0x005d
            goto L_0x024e
        L_0x005d:
            com.google.android.gms.common.util.Clock r1 = r21.zzb()
            long r1 = r1.currentTimeMillis()
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzbf.zzaa
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzal r5 = r21.zzf()
            boolean r5 = r5.zzz()
            if (r5 != 0) goto L_0x0090
            com.google.android.gms.measurement.internal.zzal r5 = r21.zzf()
            boolean r5 = r5.zzy()
            if (r5 == 0) goto L_0x008e
            goto L_0x0090
        L_0x008e:
            r5 = 0
            goto L_0x0091
        L_0x0090:
            r5 = 1
        L_0x0091:
            if (r5 == 0) goto L_0x00d1
            com.google.android.gms.measurement.internal.zzag r10 = r21.zze()
            java.lang.String r10 = r10.zzn()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00bd
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00bd
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzbf.zzv
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00e4
        L_0x00bd:
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzbf.zzu
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00e4
        L_0x00d1:
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzbf.zzt
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00e4:
            com.google.android.gms.measurement.internal.zzmc r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzgm r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzmc r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzgm r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzal r16 = r21.zzf()
            r17 = r10
            long r9 = r16.c_()
            com.google.android.gms.measurement.internal.zzal r11 = r21.zzf()
            r19 = r7
            long r6 = r11.d_()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0113
        L_0x0110:
            r10 = r3
            goto L_0x018d
        L_0x0113:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x0139
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0139
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x0139:
            com.google.android.gms.measurement.internal.zznl r5 = r21.zzp()
            r12 = r17
            boolean r5 = r5.zza((long) r8, (long) r12)
            if (r5 != 0) goto L_0x0147
            long r10 = r8 + r12
        L_0x0147:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018d
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x018d
            r5 = 0
        L_0x0150:
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r6 = com.google.android.gms.measurement.internal.zzbf.zzac
            r7 = 0
            java.lang.Object r6 = r6.zza(r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r8 = 0
            int r6 = java.lang.Math.max(r8, r6)
            r9 = 20
            int r6 = java.lang.Math.min(r9, r6)
            if (r5 >= r6) goto L_0x0110
            r12 = 1
            long r12 = r12 << r5
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r6 = com.google.android.gms.measurement.internal.zzbf.zzab
            java.lang.Object r6 = r6.zza(r7)
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            long r6 = java.lang.Math.max(r3, r6)
            long r6 = r6 * r12
            long r10 = r10 + r6
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x018a
            goto L_0x018d
        L_0x018a:
            int r5 = r5 + 1
            goto L_0x0150
        L_0x018d:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01ad
            com.google.android.gms.measurement.internal.zzfw r1 = r21.zzj()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgg r1 = r21.zzy()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzmw r1 = r21.zzz()
            r1.zzu()
            return
        L_0x01ad:
            com.google.android.gms.measurement.internal.zzfz r1 = r21.zzh()
            boolean r1 = r1.zzu()
            if (r1 != 0) goto L_0x01d3
            com.google.android.gms.measurement.internal.zzfw r1 = r21.zzj()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgg r1 = r21.zzy()
            r1.zza()
            com.google.android.gms.measurement.internal.zzmw r1 = r21.zzz()
            r1.zzu()
            return
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzmc r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzgm r1 = r1.zzb
            long r1 = r1.zza()
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzbf.zzr
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zznl r7 = r21.zzp()
            boolean r7 = r7.zza((long) r1, (long) r5)
            if (r7 != 0) goto L_0x01fe
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x01fe:
            com.google.android.gms.measurement.internal.zzgg r1 = r21.zzy()
            r1.zzb()
            com.google.android.gms.common.util.Clock r1 = r21.zzb()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0235
            r21.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzbf.zzw
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzmc r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzgm r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r21.zzb()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x0235:
            com.google.android.gms.measurement.internal.zzfw r1 = r21.zzj()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()
            java.lang.String r2 = "Upload scheduled in approximately ms"
            java.lang.Long r3 = java.lang.Long.valueOf(r10)
            r1.zza(r2, r3)
            com.google.android.gms.measurement.internal.zzmw r1 = r21.zzz()
            r1.zza(r10)
            return
        L_0x024e:
            com.google.android.gms.measurement.internal.zzfw r1 = r21.zzj()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgg r1 = r21.zzy()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzmw r1 = r21.zzz()
            r1.zzu()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zzab():void");
    }

    private final boolean zzac() {
        zzl().zzt();
        zzs();
        if (zzf().zzx() || !TextUtils.isEmpty(zzf().f_())) {
            return true;
        }
        return false;
    }

    private final boolean zzad() {
        zzl().zzt();
        FileLock fileLock = this.zzx;
        if (fileLock == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(zzcf.zza().zza(this.zzm.zza().getFilesDir(), "google_app_measurement.db")), "rw").getChannel();
                this.zzy = channel;
                FileLock tryLock = channel.tryLock();
                this.zzx = tryLock;
                if (tryLock != null) {
                    zzj().zzp().zza("Storage concurrent access okay");
                    return true;
                }
                zzj().zzg().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzj().zzg().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzj().zzg().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzj().zzu().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzj().zzp().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final zzo zzc(String str) {
        String str2 = str;
        zzg zze2 = zzf().zze(str2);
        if (zze2 == null || TextUtils.isEmpty(zze2.zzaf())) {
            zzj().zzc().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zza2 = zza(zze2);
        if (zza2 == null || zza2.booleanValue()) {
            zzg zzg2 = zze2;
            return new zzo(str, zze2.zzah(), zze2.zzaf(), zze2.zze(), zze2.zzae(), zze2.zzq(), zze2.zzn(), (String) null, zze2.zzar(), false, zze2.zzag(), zze2.zzd(), 0, 0, zzg2.zzaq(), false, zzg2.zzaa(), zzg2.zzx(), zzg2.zzo(), zzg2.zzan(), (String) null, zzb(str).zzh(), "", (String) null, zzg2.zzat(), zzg2.zzw(), zzb(str).zza(), zzd(str).zzf(), zzg2.zza(), zzg2.zzf(), zzg2.zzam(), zzg2.zzak());
        }
        zzj().zzg().zza("App version does not match; dropping. appId", zzfw.zza(str));
        return null;
    }

    private final long zzx() {
        long currentTimeMillis = zzb().currentTimeMillis();
        zzmc zzmc = this.zzj;
        zzmc.zzal();
        zzmc.zzt();
        long zza2 = zzmc.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzmc.zzq().zzv().nextInt(86400000)) + 1;
            zzmc.zze.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    private final zzgg zzy() {
        zzgg zzgg = this.zze;
        if (zzgg != null) {
            return zzgg;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzmw zzz() {
        return (zzmw) zza((zzmx) this.zzf);
    }

    public final Clock zzb() {
        return ((zzhj) Preconditions.checkNotNull(this.zzm)).zzb();
    }

    public final zzab zzd() {
        return this.zzm.zzd();
    }

    public final zzag zze() {
        return ((zzhj) Preconditions.checkNotNull(this.zzm)).zzf();
    }

    public final zzal zzf() {
        return (zzal) zza((zzmx) this.zzd);
    }

    public final zzfr zzg() {
        return this.zzm.zzk();
    }

    public final zzfz zzh() {
        return (zzfz) zza((zzmx) this.zzc);
    }

    public final zzgt zzi() {
        return (zzgt) zza((zzmx) this.zzb);
    }

    public final zzfw zzj() {
        return ((zzhj) Preconditions.checkNotNull(this.zzm)).zzj();
    }

    public final zzhj zzk() {
        return this.zzm;
    }

    public final zzhc zzl() {
        return ((zzhj) Preconditions.checkNotNull(this.zzm)).zzl();
    }

    public final zzkn zzm() {
        return (zzkn) zza((zzmx) this.zzi);
    }

    public final zzmc zzn() {
        return this.zzj;
    }

    public final zzna zzo() {
        return this.zzk;
    }

    public final zznl zzp() {
        return (zznl) zza((zzmx) this.zzh);
    }

    public final zznp zzq() {
        return ((zzhj) Preconditions.checkNotNull(this.zzm)).zzt();
    }

    public final void zzr() {
        zzl().zzt();
        zzs();
        if (!this.zzo) {
            this.zzo = true;
            if (zzad()) {
                int zza2 = zza(this.zzy);
                int zzab2 = this.zzm.zzh().zzab();
                zzl().zzt();
                if (zza2 > zzab2) {
                    zzj().zzg().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzab2));
                } else if (zza2 >= zzab2) {
                } else {
                    if (zza(zzab2, this.zzy)) {
                        zzj().zzp().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzab2));
                    } else {
                        zzj().zzg().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzab2));
                    }
                }
            }
        }
    }

    public final void zzs() {
        if (!this.zzn) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void zzt() {
        this.zzt++;
    }

    public final void zzu() {
        this.zzs++;
    }

    public final void zzv() {
        int delete;
        zzl().zzt();
        zzf().zzv();
        zzal zzf2 = zzf();
        zzf2.zzt();
        zzf2.zzal();
        if (zzf2.zzaa()) {
            zzfj<Long> zzfj = zzbf.zzbf;
            if (zzfj.zza(null).longValue() != 0 && (delete = zzf2.e_().delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzf2.zzb().currentTimeMillis()), String.valueOf(zzfj.zza(null))})) > 0) {
                zzf2.zzj().zzp().zza("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
            }
        }
        if (this.zzj.zzc.zza() == 0) {
            this.zzj.zzc.zza(zzb().currentTimeMillis());
        }
        zzab();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:210:?, code lost:
        zzj().zzg().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzfw.zza(r6), r17.zzb());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:209:0x04d6 */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03aa A[Catch:{ all -> 0x0414, all -> 0x0518 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03ab A[Catch:{ all -> 0x0414, all -> 0x0518 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw() {
        /*
            r26 = this;
            r7 = r26
            com.google.android.gms.measurement.internal.zzhc r0 = r26.zzl()
            r0.zzt()
            r26.zzs()
            r0 = 1
            r7.zzw = r0
            r8 = 0
            com.google.android.gms.measurement.internal.zzhj r1 = r7.zzm     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzkx r1 = r1.zzr()     // Catch:{ all -> 0x051b }
            java.lang.Boolean r1 = r1.zzab()     // Catch:{ all -> 0x051b }
            if (r1 != 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzfw r0 = r26.zzj()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzu()     // Catch:{ all -> 0x051b }
            java.lang.String r1 = "Upload data called on the client side before use of service was decided"
            r0.zza(r1)     // Catch:{ all -> 0x051b }
            r7.zzw = r8
            r26.zzaa()
            return
        L_0x002f:
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x051b }
            if (r1 == 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzfw r0 = r26.zzj()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzg()     // Catch:{ all -> 0x051b }
            java.lang.String r1 = "Upload called in the client side when service should be used"
            r0.zza(r1)     // Catch:{ all -> 0x051b }
            r7.zzw = r8
            r26.zzaa()
            return
        L_0x0048:
            long r1 = r7.zzp     // Catch:{ all -> 0x051b }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0059
            r26.zzab()     // Catch:{ all -> 0x051b }
            r7.zzw = r8
            r26.zzaa()
            return
        L_0x0059:
            com.google.android.gms.measurement.internal.zzhc r1 = r26.zzl()     // Catch:{ all -> 0x051b }
            r1.zzt()     // Catch:{ all -> 0x051b }
            java.util.List<java.lang.Long> r1 = r7.zzz     // Catch:{ all -> 0x051b }
            if (r1 == 0) goto L_0x0066
            r1 = r0
            goto L_0x0067
        L_0x0066:
            r1 = r8
        L_0x0067:
            if (r1 == 0) goto L_0x007c
            com.google.android.gms.measurement.internal.zzfw r0 = r26.zzj()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzp()     // Catch:{ all -> 0x051b }
            java.lang.String r1 = "Uploading requested multiple times"
            r0.zza(r1)     // Catch:{ all -> 0x051b }
            r7.zzw = r8
            r26.zzaa()
            return
        L_0x007c:
            com.google.android.gms.measurement.internal.zzfz r1 = r26.zzh()     // Catch:{ all -> 0x051b }
            boolean r1 = r1.zzu()     // Catch:{ all -> 0x051b }
            if (r1 != 0) goto L_0x009c
            com.google.android.gms.measurement.internal.zzfw r0 = r26.zzj()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzp()     // Catch:{ all -> 0x051b }
            java.lang.String r1 = "Network not connected, ignoring upload request"
            r0.zza(r1)     // Catch:{ all -> 0x051b }
            r26.zzab()     // Catch:{ all -> 0x051b }
            r7.zzw = r8
            r26.zzaa()
            return
        L_0x009c:
            com.google.android.gms.common.util.Clock r1 = r26.zzb()     // Catch:{ all -> 0x051b }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzag r5 = r26.zze()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r6 = com.google.android.gms.measurement.internal.zzbf.zzas     // Catch:{ all -> 0x051b }
            r9 = 0
            int r5 = r5.zzb((java.lang.String) r9, (com.google.android.gms.measurement.internal.zzfj<java.lang.Integer>) r6)     // Catch:{ all -> 0x051b }
            r26.zze()     // Catch:{ all -> 0x051b }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzh()     // Catch:{ all -> 0x051b }
            long r10 = r1 - r10
            r6 = r8
        L_0x00b9:
            if (r6 >= r5) goto L_0x00c4
            boolean r12 = r7.zza((java.lang.String) r9, (long) r10)     // Catch:{ all -> 0x051b }
            if (r12 == 0) goto L_0x00c4
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x00c4:
            boolean r5 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ all -> 0x051b }
            if (r5 == 0) goto L_0x011e
            com.google.android.gms.measurement.internal.zzhc r5 = r26.zzl()     // Catch:{ all -> 0x051b }
            r5.zzt()     // Catch:{ all -> 0x051b }
            java.util.Set<java.lang.String> r5 = r7.zzr     // Catch:{ all -> 0x051b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x051b }
        L_0x00d7:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x051b }
            if (r6 == 0) goto L_0x0119
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x051b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x051b }
            boolean r10 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ all -> 0x051b }
            if (r10 == 0) goto L_0x00d7
            com.google.android.gms.measurement.internal.zzag r10 = r26.zze()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbf.zzbz     // Catch:{ all -> 0x051b }
            boolean r10 = r10.zze(r6, r11)     // Catch:{ all -> 0x051b }
            if (r10 == 0) goto L_0x00d7
            com.google.android.gms.measurement.internal.zzfw r10 = r26.zzj()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfy r10 = r10.zzc()     // Catch:{ all -> 0x051b }
            java.lang.String r11 = "Notifying app that trigger URIs are available. App ID"
            r10.zza(r11, r6)     // Catch:{ all -> 0x051b }
            android.content.Intent r10 = new android.content.Intent     // Catch:{ all -> 0x051b }
            r10.<init>()     // Catch:{ all -> 0x051b }
            java.lang.String r11 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            r10.setAction(r11)     // Catch:{ all -> 0x051b }
            r10.setPackage(r6)     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzhj r6 = r7.zzm     // Catch:{ all -> 0x051b }
            android.content.Context r6 = r6.zza()     // Catch:{ all -> 0x051b }
            r6.sendBroadcast(r10)     // Catch:{ all -> 0x051b }
            goto L_0x00d7
        L_0x0119:
            java.util.Set<java.lang.String> r5 = r7.zzr     // Catch:{ all -> 0x051b }
            r5.clear()     // Catch:{ all -> 0x051b }
        L_0x011e:
            com.google.android.gms.measurement.internal.zzmc r5 = r7.zzj     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzgm r5 = r5.zzc     // Catch:{ all -> 0x051b }
            long r5 = r5.zza()     // Catch:{ all -> 0x051b }
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0141
            com.google.android.gms.measurement.internal.zzfw r3 = r26.zzj()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzc()     // Catch:{ all -> 0x051b }
            java.lang.String r4 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r5 = r1 - r5
            long r5 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x051b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x051b }
            r3.zza(r4, r5)     // Catch:{ all -> 0x051b }
        L_0x0141:
            com.google.android.gms.measurement.internal.zzal r3 = r26.zzf()     // Catch:{ all -> 0x051b }
            java.lang.String r6 = r3.f_()     // Catch:{ all -> 0x051b }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x051b }
            r4 = -1
            if (r3 != 0) goto L_0x04ec
            long r10 = r7.zzab     // Catch:{ all -> 0x051b }
            int r3 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzal r3 = r26.zzf()     // Catch:{ all -> 0x051b }
            long r3 = r3.b_()     // Catch:{ all -> 0x051b }
            r7.zzab = r3     // Catch:{ all -> 0x051b }
        L_0x0161:
            com.google.android.gms.measurement.internal.zzag r3 = r26.zze()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r4 = com.google.android.gms.measurement.internal.zzbf.zzg     // Catch:{ all -> 0x051b }
            int r3 = r3.zzb((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzfj<java.lang.Integer>) r4)     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzag r4 = r26.zze()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r5 = com.google.android.gms.measurement.internal.zzbf.zzh     // Catch:{ all -> 0x051b }
            int r4 = r4.zzb((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzfj<java.lang.Integer>) r5)     // Catch:{ all -> 0x051b }
            int r4 = java.lang.Math.max(r8, r4)     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzal r5 = r26.zzf()     // Catch:{ all -> 0x051b }
            java.util.List r3 = r5.zza((java.lang.String) r6, (int) r3, (int) r4)     // Catch:{ all -> 0x051b }
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x051b }
            if (r4 != 0) goto L_0x0511
            com.google.android.gms.measurement.internal.zzin r4 = r7.zzb((java.lang.String) r6)     // Catch:{ all -> 0x051b }
            boolean r4 = r4.zzi()     // Catch:{ all -> 0x051b }
            if (r4 == 0) goto L_0x01e4
            java.util.Iterator r4 = r3.iterator()     // Catch:{ all -> 0x051b }
        L_0x0195:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x051b }
            if (r5 == 0) goto L_0x01b4
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x051b }
            android.util.Pair r5 = (android.util.Pair) r5     // Catch:{ all -> 0x051b }
            java.lang.Object r5 = r5.first     // Catch:{ all -> 0x051b }
            com.google.android.gms.internal.measurement.zzfn$zzk r5 = (com.google.android.gms.internal.measurement.zzfn.zzk) r5     // Catch:{ all -> 0x051b }
            java.lang.String r10 = r5.zzan()     // Catch:{ all -> 0x051b }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x051b }
            if (r10 != 0) goto L_0x0195
            java.lang.String r4 = r5.zzan()     // Catch:{ all -> 0x051b }
            goto L_0x01b5
        L_0x01b4:
            r4 = r9
        L_0x01b5:
            if (r4 == 0) goto L_0x01e4
            r5 = r8
        L_0x01b8:
            int r10 = r3.size()     // Catch:{ all -> 0x051b }
            if (r5 >= r10) goto L_0x01e4
            java.lang.Object r10 = r3.get(r5)     // Catch:{ all -> 0x051b }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x051b }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x051b }
            com.google.android.gms.internal.measurement.zzfn$zzk r10 = (com.google.android.gms.internal.measurement.zzfn.zzk) r10     // Catch:{ all -> 0x051b }
            java.lang.String r11 = r10.zzan()     // Catch:{ all -> 0x051b }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x051b }
            if (r11 != 0) goto L_0x01e1
            java.lang.String r10 = r10.zzan()     // Catch:{ all -> 0x051b }
            boolean r10 = r10.equals(r4)     // Catch:{ all -> 0x051b }
            if (r10 != 0) goto L_0x01e1
            java.util.List r3 = r3.subList(r8, r5)     // Catch:{ all -> 0x051b }
            goto L_0x01e4
        L_0x01e1:
            int r5 = r5 + 1
            goto L_0x01b8
        L_0x01e4:
            com.google.android.gms.internal.measurement.zzfn$zzj$zzb r4 = com.google.android.gms.internal.measurement.zzfn.zzj.zzb()     // Catch:{ all -> 0x051b }
            int r5 = r3.size()     // Catch:{ all -> 0x051b }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x051b }
            int r11 = r3.size()     // Catch:{ all -> 0x051b }
            r10.<init>(r11)     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzag r11 = r26.zze()     // Catch:{ all -> 0x051b }
            boolean r11 = r11.zzj(r6)     // Catch:{ all -> 0x051b }
            if (r11 == 0) goto L_0x020b
            com.google.android.gms.measurement.internal.zzin r11 = r7.zzb((java.lang.String) r6)     // Catch:{ all -> 0x051b }
            boolean r11 = r11.zzi()     // Catch:{ all -> 0x051b }
            if (r11 == 0) goto L_0x020b
            r11 = r0
            goto L_0x020c
        L_0x020b:
            r11 = r8
        L_0x020c:
            com.google.android.gms.measurement.internal.zzin r12 = r7.zzb((java.lang.String) r6)     // Catch:{ all -> 0x051b }
            boolean r12 = r12.zzi()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzin r13 = r7.zzb((java.lang.String) r6)     // Catch:{ all -> 0x051b }
            boolean r13 = r13.zzj()     // Catch:{ all -> 0x051b }
            boolean r14 = com.google.android.gms.internal.measurement.zzph.zza()     // Catch:{ all -> 0x051b }
            if (r14 == 0) goto L_0x0230
            com.google.android.gms.measurement.internal.zzag r14 = r26.zze()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzbf.zzbr     // Catch:{ all -> 0x051b }
            boolean r14 = r14.zze(r6, r15)     // Catch:{ all -> 0x051b }
            if (r14 == 0) goto L_0x0230
            r14 = r0
            goto L_0x0231
        L_0x0230:
            r14 = r8
        L_0x0231:
            com.google.android.gms.measurement.internal.zzna r15 = r7.zzk     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzmz r17 = r15.zza(r6)     // Catch:{ all -> 0x051b }
            boolean r15 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ all -> 0x051b }
            r9 = 3
            if (r15 == 0) goto L_0x026a
            com.google.android.gms.measurement.internal.zzag r15 = r26.zze()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzbf.zzbs     // Catch:{ all -> 0x051b }
            boolean r0 = r15.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r0)     // Catch:{ all -> 0x051b }
            if (r0 == 0) goto L_0x026a
            r26.zzq()     // Catch:{ all -> 0x051b }
            boolean r0 = com.google.android.gms.measurement.internal.zznp.zzf(r6)     // Catch:{ all -> 0x051b }
            if (r0 == 0) goto L_0x026a
            com.google.android.gms.measurement.internal.zzgt r0 = r26.zzi()     // Catch:{ all -> 0x051b }
            java.lang.String r0 = r0.zzf(r6)     // Catch:{ all -> 0x051b }
            int r15 = r17.zza()     // Catch:{ all -> 0x051b }
            if (r15 != r9) goto L_0x026a
            boolean r15 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x051b }
            if (r15 != 0) goto L_0x026a
            r4.zza((java.lang.String) r0)     // Catch:{ all -> 0x051b }
        L_0x026a:
            r0 = r8
        L_0x026b:
            if (r0 >= r5) goto L_0x0418
            java.lang.Object r15 = r3.get(r0)     // Catch:{ all -> 0x051b }
            android.util.Pair r15 = (android.util.Pair) r15     // Catch:{ all -> 0x051b }
            java.lang.Object r15 = r15.first     // Catch:{ all -> 0x051b }
            com.google.android.gms.internal.measurement.zzfn$zzk r15 = (com.google.android.gms.internal.measurement.zzfn.zzk) r15     // Catch:{ all -> 0x051b }
            com.google.android.gms.internal.measurement.zzjk$zzb r15 = r15.zzcc()     // Catch:{ all -> 0x051b }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r15 = (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r15     // Catch:{ all -> 0x051b }
            java.lang.Object r18 = r3.get(r0)     // Catch:{ all -> 0x051b }
            r9 = r18
            android.util.Pair r9 = (android.util.Pair) r9     // Catch:{ all -> 0x051b }
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x051b }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x051b }
            r10.add(r9)     // Catch:{ all -> 0x051b }
            r26.zze()     // Catch:{ all -> 0x051b }
            r8 = 97001(0x17ae9, double:4.7925E-319)
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r8 = r15.zzl((long) r8)     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r8 = r8.zzk((long) r1)     // Catch:{ all -> 0x0518 }
            r9 = 0
            r8.zzd((boolean) r9)     // Catch:{ all -> 0x0414 }
            if (r11 != 0) goto L_0x02a3
            r15.zzk()     // Catch:{ all -> 0x0518 }
        L_0x02a3:
            if (r12 != 0) goto L_0x02ab
            r15.zzq()     // Catch:{ all -> 0x0518 }
            r15.zzn()     // Catch:{ all -> 0x0518 }
        L_0x02ab:
            if (r13 != 0) goto L_0x02b0
            r15.zzh()     // Catch:{ all -> 0x0518 }
        L_0x02b0:
            r7.zza((java.lang.String) r6, (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r15)     // Catch:{ all -> 0x0518 }
            if (r14 != 0) goto L_0x02b8
            r15.zzr()     // Catch:{ all -> 0x0518 }
        L_0x02b8:
            boolean r8 = com.google.android.gms.internal.measurement.zznk.zza()     // Catch:{ all -> 0x0518 }
            if (r8 == 0) goto L_0x02cf
            com.google.android.gms.measurement.internal.zzag r8 = r26.zze()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzbf.zzcw     // Catch:{ all -> 0x0518 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r9)     // Catch:{ all -> 0x0518 }
            if (r8 == 0) goto L_0x02cf
            if (r13 != 0) goto L_0x02cf
            r15.zzi()     // Catch:{ all -> 0x0518 }
        L_0x02cf:
            boolean r8 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ all -> 0x0518 }
            if (r8 == 0) goto L_0x03ad
            com.google.android.gms.measurement.internal.zzag r8 = r26.zze()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzbf.zzck     // Catch:{ all -> 0x0518 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r9)     // Catch:{ all -> 0x0518 }
            if (r8 == 0) goto L_0x03ad
            java.lang.String r8 = r15.zzz()     // Catch:{ all -> 0x0518 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0518 }
            if (r9 != 0) goto L_0x0300
            java.lang.String r9 = "00000000-0000-0000-0000-000000000000"
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0518 }
            if (r8 == 0) goto L_0x02f4
            goto L_0x0300
        L_0x02f4:
            r21 = r3
            r22 = r11
            r24 = r12
            r23 = r13
            r25 = r14
            goto L_0x03a4
        L_0x0300:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0518 }
            java.util.List r9 = r15.zzaa()     // Catch:{ all -> 0x0518 }
            r8.<init>(r9)     // Catch:{ all -> 0x0518 }
            java.util.Iterator r9 = r8.iterator()     // Catch:{ all -> 0x0518 }
            r21 = r3
            r22 = r11
            r3 = 0
            r11 = 0
            r19 = 0
            r20 = 0
        L_0x0317:
            boolean r23 = r9.hasNext()     // Catch:{ all -> 0x0518 }
            if (r23 == 0) goto L_0x038c
            java.lang.Object r23 = r9.next()     // Catch:{ all -> 0x0518 }
            r24 = r12
            r12 = r23
            com.google.android.gms.internal.measurement.zzfn$zzf r12 = (com.google.android.gms.internal.measurement.zzfn.zzf) r12     // Catch:{ all -> 0x0518 }
            r23 = r13
            java.lang.String r13 = "_fx"
            r25 = r14
            java.lang.String r14 = r12.zzg()     // Catch:{ all -> 0x0518 }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0518 }
            if (r13 == 0) goto L_0x0345
            r9.remove()     // Catch:{ all -> 0x0518 }
            r13 = r23
            r12 = r24
            r14 = r25
            r19 = 1
            r20 = 1
            goto L_0x0317
        L_0x0345:
            java.lang.String r13 = "_f"
            java.lang.String r14 = r12.zzg()     // Catch:{ all -> 0x0518 }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0518 }
            if (r13 == 0) goto L_0x0385
            com.google.android.gms.measurement.internal.zzag r13 = r26.zze()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzbf.zzcs     // Catch:{ all -> 0x0518 }
            boolean r13 = r13.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r14)     // Catch:{ all -> 0x0518 }
            if (r13 == 0) goto L_0x0383
            r26.zzp()     // Catch:{ all -> 0x0518 }
            java.lang.String r13 = "_pfo"
            com.google.android.gms.internal.measurement.zzfn$zzh r13 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0518 }
            if (r13 == 0) goto L_0x0370
            long r13 = r13.zzd()     // Catch:{ all -> 0x0518 }
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0518 }
        L_0x0370:
            r26.zzp()     // Catch:{ all -> 0x0518 }
            java.lang.String r13 = "_uwa"
            com.google.android.gms.internal.measurement.zzfn$zzh r12 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0518 }
            if (r12 == 0) goto L_0x0383
            long r12 = r12.zzd()     // Catch:{ all -> 0x0518 }
            java.lang.Long r3 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0518 }
        L_0x0383:
            r20 = 1
        L_0x0385:
            r13 = r23
            r12 = r24
            r14 = r25
            goto L_0x0317
        L_0x038c:
            r24 = r12
            r23 = r13
            r25 = r14
            if (r19 == 0) goto L_0x039a
            r15.zzl()     // Catch:{ all -> 0x0518 }
            r15.zzb((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfn.zzf>) r8)     // Catch:{ all -> 0x0518 }
        L_0x039a:
            if (r20 == 0) goto L_0x03a4
            java.lang.String r8 = r15.zzt()     // Catch:{ all -> 0x0518 }
            r9 = 1
            r7.zza((java.lang.String) r8, (boolean) r9, (java.lang.Long) r11, (java.lang.Long) r3)     // Catch:{ all -> 0x0518 }
        L_0x03a4:
            int r3 = r15.zzc()     // Catch:{ all -> 0x0518 }
            if (r3 == 0) goto L_0x03ab
            goto L_0x03b7
        L_0x03ab:
            r8 = 3
            goto L_0x0404
        L_0x03ad:
            r21 = r3
            r22 = r11
            r24 = r12
            r23 = r13
            r25 = r14
        L_0x03b7:
            com.google.android.gms.measurement.internal.zzag r3 = r26.zze()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbf.zzbh     // Catch:{ all -> 0x0518 }
            boolean r3 = r3.zze(r6, r8)     // Catch:{ all -> 0x0518 }
            if (r3 == 0) goto L_0x03da
            com.google.android.gms.internal.measurement.zzkt r3 = r15.zzai()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzjk r3 = (com.google.android.gms.internal.measurement.zzjk) r3     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfn$zzk r3 = (com.google.android.gms.internal.measurement.zzfn.zzk) r3     // Catch:{ all -> 0x0518 }
            byte[] r3 = r3.zzbz()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zznl r8 = r26.zzp()     // Catch:{ all -> 0x0518 }
            long r8 = r8.zza((byte[]) r3)     // Catch:{ all -> 0x0518 }
            r15.zza((long) r8)     // Catch:{ all -> 0x0518 }
        L_0x03da:
            boolean r3 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ all -> 0x0518 }
            if (r3 == 0) goto L_0x0400
            com.google.android.gms.measurement.internal.zzag r3 = r26.zze()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbf.zzbs     // Catch:{ all -> 0x0518 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r8)     // Catch:{ all -> 0x0518 }
            if (r3 == 0) goto L_0x0400
            r26.zzq()     // Catch:{ all -> 0x0518 }
            boolean r3 = com.google.android.gms.measurement.internal.zznp.zzf(r6)     // Catch:{ all -> 0x0518 }
            if (r3 == 0) goto L_0x0400
            int r3 = r17.zza()     // Catch:{ all -> 0x0518 }
            r8 = 3
            if (r3 != r8) goto L_0x0401
            r15.zzk()     // Catch:{ all -> 0x0518 }
            goto L_0x0401
        L_0x0400:
            r8 = 3
        L_0x0401:
            r4.zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r15)     // Catch:{ all -> 0x0518 }
        L_0x0404:
            int r0 = r0 + 1
            r9 = r8
            r3 = r21
            r11 = r22
            r13 = r23
            r12 = r24
            r14 = r25
            r8 = 0
            goto L_0x026b
        L_0x0414:
            r0 = move-exception
            r1 = r9
            goto L_0x051d
        L_0x0418:
            boolean r0 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ all -> 0x0518 }
            if (r0 == 0) goto L_0x0444
            com.google.android.gms.measurement.internal.zzag r0 = r26.zze()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzck     // Catch:{ all -> 0x0518 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r3)     // Catch:{ all -> 0x0518 }
            if (r0 == 0) goto L_0x0444
            int r0 = r4.zza()     // Catch:{ all -> 0x0518 }
            if (r0 != 0) goto L_0x0444
            r7.zza((java.util.List<java.lang.Long>) r10)     // Catch:{ all -> 0x0518 }
            r2 = 0
            r3 = 204(0xcc, float:2.86E-43)
            r4 = 0
            r5 = 0
            r1 = r26
            r1.zza((boolean) r2, (int) r3, (java.lang.Throwable) r4, (byte[]) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0518 }
            r1 = 0
            r7.zzw = r1
            r26.zzaa()
            return
        L_0x0444:
            com.google.android.gms.measurement.internal.zzfw r0 = r26.zzj()     // Catch:{ all -> 0x0518 }
            r3 = 2
            boolean r0 = r0.zza((int) r3)     // Catch:{ all -> 0x0518 }
            if (r0 == 0) goto L_0x0460
            com.google.android.gms.measurement.internal.zznl r0 = r26.zzp()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzkt r3 = r4.zzai()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzjk r3 = (com.google.android.gms.internal.measurement.zzjk) r3     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfn$zzj r3 = (com.google.android.gms.internal.measurement.zzfn.zzj) r3     // Catch:{ all -> 0x0518 }
            java.lang.String r9 = r0.zza((com.google.android.gms.internal.measurement.zzfn.zzj) r3)     // Catch:{ all -> 0x0518 }
            goto L_0x0461
        L_0x0460:
            r9 = 0
        L_0x0461:
            r26.zzp()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzkt r0 = r4.zzai()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzjk r0 = (com.google.android.gms.internal.measurement.zzjk) r0     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfn$zzj r0 = (com.google.android.gms.internal.measurement.zzfn.zzj) r0     // Catch:{ all -> 0x0518 }
            byte[] r14 = r0.zzbz()     // Catch:{ all -> 0x0518 }
            r7.zza((java.util.List<java.lang.Long>) r10)     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.measurement.internal.zzmc r0 = r7.zzj     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.measurement.internal.zzgm r0 = r0.zzd     // Catch:{ MalformedURLException -> 0x04d6 }
            r0.zza(r1)     // Catch:{ MalformedURLException -> 0x04d6 }
            java.lang.String r0 = "?"
            if (r5 <= 0) goto L_0x048b
            r1 = 0
            com.google.android.gms.internal.measurement.zzfn$zzk r0 = r4.zza((int) r1)     // Catch:{ all -> 0x0488 }
            java.lang.String r0 = r0.zzz()     // Catch:{ MalformedURLException -> 0x04d6 }
            goto L_0x048b
        L_0x0488:
            r0 = move-exception
            goto L_0x051d
        L_0x048b:
            com.google.android.gms.measurement.internal.zzfw r1 = r26.zzj()     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()     // Catch:{ MalformedURLException -> 0x04d6 }
            java.lang.String r2 = "Uploading data. app, uncompressed size, data"
            int r3 = r14.length     // Catch:{ MalformedURLException -> 0x04d6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ MalformedURLException -> 0x04d6 }
            r1.zza(r2, r0, r3, r9)     // Catch:{ MalformedURLException -> 0x04d6 }
            r0 = 1
            r7.zzv = r0     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.measurement.internal.zzfz r11 = r26.zzh()     // Catch:{ MalformedURLException -> 0x04d6 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04d6 }
            java.lang.String r0 = r17.zzb()     // Catch:{ MalformedURLException -> 0x04d6 }
            r13.<init>(r0)     // Catch:{ MalformedURLException -> 0x04d6 }
            java.util.Map r15 = r17.zzc()     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.measurement.internal.zzne r0 = new com.google.android.gms.measurement.internal.zzne     // Catch:{ MalformedURLException -> 0x04d6 }
            r0.<init>(r7, r6)     // Catch:{ MalformedURLException -> 0x04d6 }
            r11.zzt()     // Catch:{ MalformedURLException -> 0x04d6 }
            r11.zzal()     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.measurement.internal.zzhc r1 = r11.zzl()     // Catch:{ MalformedURLException -> 0x04d6 }
            com.google.android.gms.measurement.internal.zzgd r2 = new com.google.android.gms.measurement.internal.zzgd     // Catch:{ MalformedURLException -> 0x04d6 }
            r10 = r2
            r12 = r6
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04d6 }
            r1.zza((java.lang.Runnable) r2)     // Catch:{ MalformedURLException -> 0x04d6 }
            goto L_0x0511
        L_0x04d6:
            com.google.android.gms.measurement.internal.zzfw r0 = r26.zzj()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzg()     // Catch:{ all -> 0x0518 }
            java.lang.String r1 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r6)     // Catch:{ all -> 0x0518 }
            java.lang.String r3 = r17.zzb()     // Catch:{ all -> 0x0518 }
            r0.zza(r1, r2, r3)     // Catch:{ all -> 0x0518 }
            goto L_0x0511
        L_0x04ec:
            r7.zzab = r4     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzal r0 = r26.zzf()     // Catch:{ all -> 0x0518 }
            r26.zze()     // Catch:{ all -> 0x0518 }
            long r3 = com.google.android.gms.measurement.internal.zzag.zzh()     // Catch:{ all -> 0x0518 }
            long r1 = r1 - r3
            java.lang.String r0 = r0.zza((long) r1)     // Catch:{ all -> 0x0518 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0518 }
            if (r1 != 0) goto L_0x0511
            com.google.android.gms.measurement.internal.zzal r1 = r26.zzf()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzg r0 = r1.zze(r0)     // Catch:{ all -> 0x0518 }
            if (r0 == 0) goto L_0x0511
            r7.zzb((com.google.android.gms.measurement.internal.zzg) r0)     // Catch:{ all -> 0x0518 }
        L_0x0511:
            r1 = 0
            r7.zzw = r1
            r26.zzaa()
            return
        L_0x0518:
            r0 = move-exception
            r1 = 0
            goto L_0x051d
        L_0x051b:
            r0 = move-exception
            r1 = r8
        L_0x051d:
            r7.zzw = r1
            r26.zzaa()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zzw():void");
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
    public class zzb {
        final String zza;
        long zzb;

        private zzb(zznc zznc) {
            this(zznc, zznc.zzq().zzp());
        }

        private zzb(zznc zznc, String str) {
            this.zza = str;
            this.zzb = zznc.zzb().elapsedRealtime();
        }
    }

    private zznc(zznm zznm, zzhj zzhj) {
        this.zzn = false;
        this.zzr = new HashSet();
        this.zzah = new zznf(this);
        Preconditions.checkNotNull(zznm);
        this.zzm = zzhj.zza(zznm.zza, (zzdo) null, (Long) null);
        this.zzab = -1;
        this.zzk = new zzna(this);
        zznl zznl = new zznl(this);
        zznl.zzam();
        this.zzh = zznl;
        zzfz zzfz = new zzfz(this);
        zzfz.zzam();
        this.zzc = zzfz;
        zzgt zzgt = new zzgt(this);
        zzgt.zzam();
        this.zzb = zzgt;
        this.zzac = new HashMap();
        this.zzad = new HashMap();
        this.zzae = new HashMap();
        zzl().zzb((Runnable) new zznb(this, zznm));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r0 = r5.zzb;
        r3 = com.google.android.gms.measurement.internal.zzin.zza.AD_PERSONALIZATION;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.lang.String r6, com.google.android.gms.measurement.internal.zzah r7) {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzb
            com.google.android.gms.internal.measurement.zzfi$zza r0 = r0.zzb(r6)
            r1 = 1
            if (r0 != 0) goto L_0x0011
            com.google.android.gms.measurement.internal.zzin$zza r6 = com.google.android.gms.measurement.internal.zzin.zza.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.zzak r0 = com.google.android.gms.measurement.internal.zzak.FAILSAFE
            r7.zza((com.google.android.gms.measurement.internal.zzin.zza) r6, (com.google.android.gms.measurement.internal.zzak) r0)
            return r1
        L_0x0011:
            boolean r0 = com.google.android.gms.internal.measurement.zzne.zza()
            r2 = 0
            if (r0 == 0) goto L_0x0055
            com.google.android.gms.measurement.internal.zzag r0 = r5.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzcp
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r3)
            if (r0 == 0) goto L_0x0055
            com.google.android.gms.measurement.internal.zzal r0 = r5.zzf()
            com.google.android.gms.measurement.internal.zzg r0 = r0.zze(r6)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r0.zzak()
            com.google.android.gms.measurement.internal.zzgi r0 = com.google.android.gms.measurement.internal.zzgi.zza(r0)
            com.google.android.gms.measurement.internal.zzim r0 = r0.zza()
            com.google.android.gms.measurement.internal.zzim r3 = com.google.android.gms.measurement.internal.zzim.POLICY
            if (r0 != r3) goto L_0x0055
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzb
            com.google.android.gms.measurement.internal.zzin$zza r3 = com.google.android.gms.measurement.internal.zzin.zza.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.zzim r0 = r0.zza((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzin.zza) r3)
            com.google.android.gms.measurement.internal.zzim r4 = com.google.android.gms.measurement.internal.zzim.UNINITIALIZED
            if (r0 == r4) goto L_0x0055
            com.google.android.gms.measurement.internal.zzak r6 = com.google.android.gms.measurement.internal.zzak.REMOTE_ENFORCED_DEFAULT
            r7.zza((com.google.android.gms.measurement.internal.zzin.zza) r3, (com.google.android.gms.measurement.internal.zzak) r6)
            com.google.android.gms.measurement.internal.zzim r6 = com.google.android.gms.measurement.internal.zzim.GRANTED
            if (r0 != r6) goto L_0x0054
            return r2
        L_0x0054:
            return r1
        L_0x0055:
            com.google.android.gms.measurement.internal.zzin$zza r0 = com.google.android.gms.measurement.internal.zzin.zza.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.zzak r3 = com.google.android.gms.measurement.internal.zzak.REMOTE_DEFAULT
            r7.zza((com.google.android.gms.measurement.internal.zzin.zza) r0, (com.google.android.gms.measurement.internal.zzak) r3)
            com.google.android.gms.measurement.internal.zzgt r7 = r5.zzb
            boolean r6 = r7.zzc((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzin.zza) r0)
            if (r6 == 0) goto L_0x0065
            return r2
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zza(java.lang.String, com.google.android.gms.measurement.internal.zzah):int");
    }

    private final zzav zzd(String str) {
        zzl().zzt();
        zzs();
        zzav zzav = this.zzad.get(str);
        if (zzav != null) {
            return zzav;
        }
        zzav zzg2 = zzf().zzg(str);
        this.zzad.put(str, zzg2);
        return zzg2;
    }

    private final Boolean zzg(zzo zzo2) {
        Boolean bool = zzo2.zzq;
        if (!zzne.zza() || !zze().zza(zzbf.zzcp) || TextUtils.isEmpty(zzo2.zzad)) {
            return bool;
        }
        int i = zznh.zza[zzgi.zza(zzo2.zzad).zza().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Boolean.FALSE;
            }
            if (i == 3) {
                return Boolean.TRUE;
            }
            if (i != 4) {
                return bool;
            }
        }
        return null;
    }

    private static boolean zzh(zzo zzo2) {
        return !TextUtils.isEmpty(zzo2.zzb) || !TextUtils.isEmpty(zzo2.zzp);
    }

    public final zzin zzb(String str) {
        zzl().zzt();
        zzs();
        zzin zzin = this.zzac.get(str);
        if (zzin == null) {
            zzin = zzf().zzi(str);
            if (zzin == null) {
                zzin = zzin.zza;
            }
            zza(str, zzin);
        }
        return zzin;
    }

    public final void zze(zzo zzo2) {
        zzl().zzt();
        zzs();
        Preconditions.checkNotEmpty(zzo2.zza);
        zzav zza2 = zzav.zza(zzo2.zzz);
        zzj().zzp().zza("Setting DMA consent for package", zzo2.zza, zza2);
        String str = zzo2.zza;
        zzl().zzt();
        zzs();
        zzim zzc2 = zzav.zza(zza(str), 100).zzc();
        this.zzad.put(str, zza2);
        zzf().zza(str, zza2);
        zzim zzc3 = zzav.zza(zza(str), 100).zzc();
        zzl().zzt();
        zzs();
        zzim zzim = zzim.DENIED;
        boolean z = true;
        boolean z2 = zzc2 == zzim && zzc3 == zzim.GRANTED;
        boolean z3 = zzc2 == zzim.GRANTED && zzc3 == zzim;
        if (zze().zza(zzbf.zzci)) {
            if (!z2 && !z3) {
                z = false;
            }
            z2 = z;
        }
        if (z2) {
            zzj().zzp().zza("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzf().zza(zzx(), str, false, false, false, false, false, false).zzf < ((long) zze().zzb(str, zzbf.zzaw))) {
                bundle.putLong("_r", 1);
                zzj().zzp().zza("_dcu realtime event count", str, Long.valueOf(zzf().zza(zzx(), str, false, false, false, false, false, true).zzf));
            }
            this.zzah.zza(str, "_dcu", bundle);
        }
    }

    public final void zzf(zzo zzo2) {
        zzl().zzt();
        zzs();
        Preconditions.checkNotEmpty(zzo2.zza);
        zzin zza2 = zzin.zza(zzo2.zzt, zzo2.zzy);
        zzin zzb2 = zzb(zzo2.zza);
        zzj().zzp().zza("Setting storage consent for package", zzo2.zza, zza2);
        zza(zzo2.zza, zza2);
        if ((!zznk.zza() || !zze().zza(zzbf.zzcv)) && zza2.zzc(zzb2)) {
            zzd(zzo2);
        }
    }

    public final void zzd(zzo zzo2) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzaa = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzal zzf2 = zzf();
        String str = (String) Preconditions.checkNotNull(zzo2.zza);
        Preconditions.checkNotEmpty(str);
        zzf2.zzt();
        zzf2.zzal();
        try {
            SQLiteDatabase e_ = zzf2.e_();
            String[] strArr = {str};
            int delete = e_.delete("apps", "app_id=?", strArr) + 0 + e_.delete("events", "app_id=?", strArr) + e_.delete("events_snapshot", "app_id=?", strArr) + e_.delete("user_attributes", "app_id=?", strArr) + e_.delete("conditional_properties", "app_id=?", strArr) + e_.delete("raw_events", "app_id=?", strArr) + e_.delete("raw_events_metadata", "app_id=?", strArr) + e_.delete("queue", "app_id=?", strArr) + e_.delete("audience_filter_values", "app_id=?", strArr) + e_.delete("main_event_params", "app_id=?", strArr) + e_.delete("default_event_params", "app_id=?", strArr) + e_.delete("trigger_uris", "app_id=?", strArr);
            if (delete > 0) {
                zzf2.zzj().zzp().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzf2.zzj().zzg().zza("Error resetting analytics data. appId, error", zzfw.zza(str), e);
        }
        if (zzo2.zzh) {
            zzc(zzo2);
        }
    }

    public final String zzb(zzo zzo2) {
        try {
            return (String) zzl().zza(new zzng(this, zzo2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzj().zzg().zza("Failed to get app instance id. appId", zzfw.zza(zzo2.zza), e);
            return null;
        }
    }

    private final void zzb(zzg zzg2) {
        zzl().zzt();
        if (!TextUtils.isEmpty(zzg2.zzah()) || !TextUtils.isEmpty(zzg2.zzaa())) {
            Uri.Builder builder = new Uri.Builder();
            String zzah2 = zzg2.zzah();
            if (TextUtils.isEmpty(zzah2)) {
                zzah2 = zzg2.zzaa();
            }
            ArrayMap arrayMap = null;
            Uri.Builder encodedAuthority = builder.scheme(zzbf.zze.zza(null)).encodedAuthority(zzbf.zzf.zza(null));
            encodedAuthority.path("config/app/" + zzah2).appendQueryParameter("platform", LogSubCategory.LifeCycle.ANDROID).appendQueryParameter("gmp_version", "97001").appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String str = (String) Preconditions.checkNotNull(zzg2.zzac());
                URL url = new URL(uri);
                zzj().zzp().zza("Fetching remote configuration", str);
                zzfi.zzd zzc2 = zzi().zzc(str);
                String zze2 = zzi().zze(str);
                if (zzc2 != null) {
                    if (!TextUtils.isEmpty(zze2)) {
                        arrayMap = new ArrayMap();
                        arrayMap.put(HttpHeaders.IF_MODIFIED_SINCE, zze2);
                    }
                    String zzd2 = zzi().zzd(str);
                    if (!TextUtils.isEmpty(zzd2)) {
                        if (arrayMap == null) {
                            arrayMap = new ArrayMap();
                        }
                        arrayMap.put(HttpHeaders.IF_NONE_MATCH, zzd2);
                    }
                }
                this.zzu = true;
                zzfz zzh2 = zzh();
                zznd zznd = new zznd(this);
                zzh2.zzt();
                zzh2.zzal();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zznd);
                zzh2.zzl().zza((Runnable) new zzgd(zzh2, str, url, (byte[]) null, arrayMap, zznd));
            } catch (MalformedURLException unused) {
                zzj().zzg().zza("Failed to parse config URL. Not fetching. appId", zzfw.zza(zzg2.zzac()), uri);
            }
        } else {
            zza((String) Preconditions.checkNotNull(zzg2.zzac()), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzl().zzt();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzj().zzg().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    zzj().zzu().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            zzj().zzg().zza("Failed to read from channel", e);
            return 0;
        }
    }

    public final Context zza() {
        return this.zzm.zza();
    }

    public final Bundle zza(String str) {
        int i;
        zzl().zzt();
        zzs();
        if (zzi().zzb(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzin zzb2 = zzb(str);
        bundle.putAll(zzb2.zzb());
        bundle.putAll(zza(str, zzd(str), zzb2, new zzah()).zzb());
        if (zzp().zzc(str)) {
            i = 1;
        } else {
            zznq zze2 = zzf().zze(str, "_npa");
            if (zze2 != null) {
                i = zze2.zze.equals(1L);
            } else {
                i = zza(str, new zzah());
            }
        }
        bundle.putString("ad_personalization", i == 1 ? "denied" : "granted");
        return bundle;
    }

    public final zzu zzc() {
        return (zzu) zza((zzmx) this.zzg);
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x03aa A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03d5 A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03ea A[SYNTHETIC, Splitter:B:126:0x03ea] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0498 A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0501 A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0109 A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ca A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0226 A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0233 A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0245 A[Catch:{ SQLiteException -> 0x01b5, all -> 0x052f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.measurement.internal.zzo r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "com.android.vending"
            java.lang.String r0 = "_npa"
            java.lang.String r7 = "_uwa"
            java.lang.String r8 = "app_id=?"
            com.google.android.gms.measurement.internal.zzhc r9 = r23.zzl()
            r9.zzt()
            r23.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r24)
            java.lang.String r9 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            boolean r9 = zzh(r24)
            if (r9 != 0) goto L_0x002b
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.zzal r9 = r23.zzf()
            java.lang.String r10 = r2.zza
            com.google.android.gms.measurement.internal.zzg r9 = r9.zze(r10)
            r10 = 0
            r12 = 0
            if (r9 == 0) goto L_0x005f
            java.lang.String r13 = r9.zzah()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x005f
            java.lang.String r13 = r2.zzb
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x005f
            r9.zzd((long) r10)
            com.google.android.gms.measurement.internal.zzal r13 = r23.zzf()
            r13.zza((com.google.android.gms.measurement.internal.zzg) r9, (boolean) r12, (boolean) r12)
            com.google.android.gms.measurement.internal.zzgt r9 = r23.zzi()
            java.lang.String r13 = r2.zza
            r9.zzj(r13)
        L_0x005f:
            boolean r9 = r2.zzh
            if (r9 != 0) goto L_0x0067
            r23.zza((com.google.android.gms.measurement.internal.zzo) r24)
            return
        L_0x0067:
            long r13 = r2.zzl
            int r9 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r9 != 0) goto L_0x0075
            com.google.android.gms.common.util.Clock r9 = r23.zzb()
            long r13 = r9.currentTimeMillis()
        L_0x0075:
            com.google.android.gms.measurement.internal.zzhj r9 = r1.zzm
            com.google.android.gms.measurement.internal.zzax r9 = r9.zzg()
            r9.zzm()
            int r9 = r2.zzm
            r15 = 1
            if (r9 == 0) goto L_0x009d
            if (r9 == r15) goto L_0x009d
            com.google.android.gms.measurement.internal.zzfw r16 = r23.zzj()
            com.google.android.gms.measurement.internal.zzfy r15 = r16.zzu()
            java.lang.String r10 = r2.zza
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "Incorrect app type, assuming installed app. appId, appType"
            r15.zza(r11, r10, r9)
            r9 = r12
        L_0x009d:
            com.google.android.gms.measurement.internal.zzal r10 = r23.zzf()
            r10.zzp()
            com.google.android.gms.measurement.internal.zzal r10 = r23.zzf()     // Catch:{ all -> 0x052f }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zznq r10 = r10.zze(r11, r0)     // Catch:{ all -> 0x052f }
            java.lang.Boolean r11 = r23.zzg(r24)     // Catch:{ all -> 0x052f }
            r21 = r13
            if (r10 == 0) goto L_0x00c3
            java.lang.String r14 = "auto"
            java.lang.String r15 = r10.zzb     // Catch:{ all -> 0x052f }
            boolean r14 = r14.equals(r15)     // Catch:{ all -> 0x052f }
            if (r14 == 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r11 = 1
            goto L_0x00f7
        L_0x00c3:
            if (r11 == 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzno r0 = new com.google.android.gms.measurement.internal.zzno     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_npa"
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x052f }
            if (r11 == 0) goto L_0x00d2
            r14 = 1
            goto L_0x00d4
        L_0x00d2:
            r14 = 0
        L_0x00d4:
            java.lang.Long r19 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x052f }
            java.lang.String r20 = "auto"
            r11 = 1
            r15 = r0
            r17 = r21
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052f }
            if (r10 == 0) goto L_0x00ed
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x052f }
            java.lang.Long r14 = r0.zzc     // Catch:{ all -> 0x052f }
            boolean r10 = r10.equals(r14)     // Catch:{ all -> 0x052f }
            if (r10 != 0) goto L_0x00f7
        L_0x00ed:
            r1.zza((com.google.android.gms.measurement.internal.zzno) r0, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
            goto L_0x00f7
        L_0x00f1:
            r11 = 1
            if (r10 == 0) goto L_0x00f7
            r1.zza((java.lang.String) r0, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
        L_0x00f7:
            com.google.android.gms.measurement.internal.zzal r0 = r23.zzf()     // Catch:{ all -> 0x052f }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x052f }
            java.lang.Object r10 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x052f }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zze(r10)     // Catch:{ all -> 0x052f }
            if (r0 == 0) goto L_0x01c8
            r23.zzq()     // Catch:{ all -> 0x052f }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x052f }
            java.lang.String r15 = r0.zzah()     // Catch:{ all -> 0x052f }
            java.lang.String r10 = r2.zzp     // Catch:{ all -> 0x052f }
            java.lang.String r12 = r0.zzaa()     // Catch:{ all -> 0x052f }
            boolean r10 = com.google.android.gms.measurement.internal.zznp.zza((java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ all -> 0x052f }
            if (r10 == 0) goto L_0x01c8
            com.google.android.gms.measurement.internal.zzfw r10 = r23.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r10 = r10.zzu()     // Catch:{ all -> 0x052f }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r0.zzac()     // Catch:{ all -> 0x052f }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ all -> 0x052f }
            r10.zza(r12, r13)     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzal r10 = r23.zzf()     // Catch:{ all -> 0x052f }
            java.lang.String r12 = r0.zzac()     // Catch:{ all -> 0x052f }
            r10.zzal()     // Catch:{ all -> 0x052f }
            r10.zzt()     // Catch:{ all -> 0x052f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x052f }
            android.database.sqlite.SQLiteDatabase r0 = r10.e_()     // Catch:{ SQLiteException -> 0x01b5 }
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x01b5 }
            r14 = 0
            r13[r14] = r12     // Catch:{ SQLiteException -> 0x01b5 }
            java.lang.String r15 = "events"
            int r15 = r0.delete(r15, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "user_attributes"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "conditional_properties"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "apps"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "raw_events"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "raw_events_metadata"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "event_filters"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "property_filters"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "audience_filter_values"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "consent_settings"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "default_event_params"
            int r14 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r14
            java.lang.String r14 = "trigger_uris"
            int r0 = r0.delete(r14, r8, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            int r15 = r15 + r0
            if (r15 <= 0) goto L_0x01c7
            com.google.android.gms.measurement.internal.zzfw r0 = r10.zzj()     // Catch:{ SQLiteException -> 0x01b5 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzp()     // Catch:{ SQLiteException -> 0x01b5 }
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x01b5 }
            r0.zza(r8, r12, r13)     // Catch:{ SQLiteException -> 0x01b5 }
            goto L_0x01c7
        L_0x01b5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r8 = r10.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzg()     // Catch:{ all -> 0x052f }
            java.lang.String r10 = "Error deleting application data. appId, error"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r12)     // Catch:{ all -> 0x052f }
            r8.zza(r10, r12, r0)     // Catch:{ all -> 0x052f }
        L_0x01c7:
            r0 = 0
        L_0x01c8:
            if (r0 == 0) goto L_0x0221
            long r12 = r0.zze()     // Catch:{ all -> 0x052f }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x01e1
            long r12 = r0.zze()     // Catch:{ all -> 0x052f }
            long r14 = r2.zzj     // Catch:{ all -> 0x052f }
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x01e1
            r15 = r11
            goto L_0x01e2
        L_0x01e1:
            r15 = 0
        L_0x01e2:
            java.lang.String r8 = r0.zzaf()     // Catch:{ all -> 0x052f }
            long r12 = r0.zze()     // Catch:{ all -> 0x052f }
            r16 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x01fd
            if (r8 == 0) goto L_0x01fd
            java.lang.String r0 = r2.zzc     // Catch:{ all -> 0x052f }
            boolean r0 = r8.equals(r0)     // Catch:{ all -> 0x052f }
            if (r0 != 0) goto L_0x01fd
            r0 = r11
            goto L_0x01fe
        L_0x01fd:
            r0 = 0
        L_0x01fe:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x0221
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x052f }
            r0.<init>()     // Catch:{ all -> 0x052f }
            java.lang.String r10 = "_pv"
            r0.putString(r10, r8)     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzbd r8 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_au"
            com.google.android.gms.measurement.internal.zzbc r10 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x052f }
            r10.<init>(r0)     // Catch:{ all -> 0x052f }
            java.lang.String r18 = "auto"
            r15 = r8
            r17 = r10
            r19 = r21
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052f }
            r1.zza((com.google.android.gms.measurement.internal.zzbd) r8, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
        L_0x0221:
            r23.zza((com.google.android.gms.measurement.internal.zzo) r24)     // Catch:{ all -> 0x052f }
            if (r9 != 0) goto L_0x0233
            com.google.android.gms.measurement.internal.zzal r0 = r23.zzf()     // Catch:{ all -> 0x052f }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x052f }
            java.lang.String r10 = "_f"
            com.google.android.gms.measurement.internal.zzaz r0 = r0.zzd(r8, r10)     // Catch:{ all -> 0x052f }
            goto L_0x0243
        L_0x0233:
            if (r9 != r11) goto L_0x0242
            com.google.android.gms.measurement.internal.zzal r0 = r23.zzf()     // Catch:{ all -> 0x052f }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x052f }
            java.lang.String r10 = "_v"
            com.google.android.gms.measurement.internal.zzaz r0 = r0.zzd(r8, r10)     // Catch:{ all -> 0x052f }
            goto L_0x0243
        L_0x0242:
            r0 = 0
        L_0x0243:
            if (r0 != 0) goto L_0x0501
            r12 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = r21 / r12
            r16 = 1
            long r14 = r14 + r16
            long r14 = r14 * r12
            java.lang.String r8 = "_dac"
            java.lang.String r10 = "_et"
            java.lang.String r12 = "_r"
            java.lang.String r13 = "_c"
            if (r9 != 0) goto L_0x04b3
            com.google.android.gms.measurement.internal.zzno r0 = new com.google.android.gms.measurement.internal.zzno     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_fot"
            java.lang.Long r19 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x052f }
            java.lang.String r20 = "auto"
            r15 = r0
            r17 = r21
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052f }
            r1.zza((com.google.android.gms.measurement.internal.zzno) r0, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzhc r0 = r23.zzl()     // Catch:{ all -> 0x052f }
            r0.zzt()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzgq r0 = r1.zzl     // Catch:{ all -> 0x052f }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x052f }
            r9 = r0
            com.google.android.gms.measurement.internal.zzgq r9 = (com.google.android.gms.measurement.internal.zzgq) r9     // Catch:{ all -> 0x052f }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x052f }
            if (r0 == 0) goto L_0x036d
            boolean r14 = r0.isEmpty()     // Catch:{ all -> 0x052f }
            if (r14 == 0) goto L_0x0288
            goto L_0x036d
        L_0x0288:
            com.google.android.gms.measurement.internal.zzhj r14 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzhc r14 = r14.zzl()     // Catch:{ all -> 0x052f }
            r14.zzt()     // Catch:{ all -> 0x052f }
            boolean r14 = r9.zza()     // Catch:{ all -> 0x052f }
            if (r14 != 0) goto L_0x02a8
            com.google.android.gms.measurement.internal.zzhj r0 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzn()     // Catch:{ all -> 0x052f }
            java.lang.String r6 = "Install Referrer Reporter is not available"
            r0.zza(r6)     // Catch:{ all -> 0x052f }
            goto L_0x037c
        L_0x02a8:
            com.google.android.gms.measurement.internal.zzgp r14 = new com.google.android.gms.measurement.internal.zzgp     // Catch:{ all -> 0x052f }
            r14.<init>(r9, r0)     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzhj r0 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzhc r0 = r0.zzl()     // Catch:{ all -> 0x052f }
            r0.zzt()     // Catch:{ all -> 0x052f }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x052f }
            java.lang.String r15 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r15)     // Catch:{ all -> 0x052f }
            android.content.ComponentName r15 = new android.content.ComponentName     // Catch:{ all -> 0x052f }
            java.lang.String r11 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15.<init>(r6, r11)     // Catch:{ all -> 0x052f }
            r0.setComponent(r15)     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzhj r11 = r9.zza     // Catch:{ all -> 0x052f }
            android.content.Context r11 = r11.zza()     // Catch:{ all -> 0x052f }
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch:{ all -> 0x052f }
            if (r11 != 0) goto L_0x02e4
            com.google.android.gms.measurement.internal.zzhj r0 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzw()     // Catch:{ all -> 0x052f }
            java.lang.String r6 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r6)     // Catch:{ all -> 0x052f }
            goto L_0x037c
        L_0x02e4:
            r15 = 0
            java.util.List r11 = r11.queryIntentServices(r0, r15)     // Catch:{ all -> 0x052f }
            if (r11 == 0) goto L_0x035d
            boolean r16 = r11.isEmpty()     // Catch:{ all -> 0x052f }
            if (r16 != 0) goto L_0x035d
            java.lang.Object r11 = r11.get(r15)     // Catch:{ all -> 0x052f }
            android.content.pm.ResolveInfo r11 = (android.content.pm.ResolveInfo) r11     // Catch:{ all -> 0x052f }
            android.content.pm.ServiceInfo r11 = r11.serviceInfo     // Catch:{ all -> 0x052f }
            if (r11 == 0) goto L_0x037c
            java.lang.String r15 = r11.packageName     // Catch:{ all -> 0x052f }
            java.lang.String r11 = r11.name     // Catch:{ all -> 0x052f }
            if (r11 == 0) goto L_0x034d
            boolean r6 = r6.equals(r15)     // Catch:{ all -> 0x052f }
            if (r6 == 0) goto L_0x034d
            boolean r6 = r9.zza()     // Catch:{ all -> 0x052f }
            if (r6 == 0) goto L_0x034d
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x052f }
            r6.<init>(r0)     // Catch:{ all -> 0x052f }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0338 }
            com.google.android.gms.measurement.internal.zzhj r11 = r9.zza     // Catch:{ RuntimeException -> 0x0338 }
            android.content.Context r11 = r11.zza()     // Catch:{ RuntimeException -> 0x0338 }
            r15 = 1
            boolean r0 = r0.bindService(r11, r6, r14, r15)     // Catch:{ RuntimeException -> 0x0338 }
            com.google.android.gms.measurement.internal.zzhj r6 = r9.zza     // Catch:{ RuntimeException -> 0x0338 }
            com.google.android.gms.measurement.internal.zzfw r6 = r6.zzj()     // Catch:{ RuntimeException -> 0x0338 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch:{ RuntimeException -> 0x0338 }
            java.lang.String r11 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x0332
            java.lang.String r0 = "available"
            goto L_0x0334
        L_0x0332:
            java.lang.String r0 = "not available"
        L_0x0334:
            r6.zza(r11, r0)     // Catch:{ RuntimeException -> 0x0338 }
            goto L_0x037c
        L_0x0338:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhj r6 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfw r6 = r6.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzg()     // Catch:{ all -> 0x052f }
            java.lang.String r9 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x052f }
            r6.zza(r9, r0)     // Catch:{ all -> 0x052f }
            goto L_0x037c
        L_0x034d:
            com.google.android.gms.measurement.internal.zzhj r0 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzu()     // Catch:{ all -> 0x052f }
            java.lang.String r6 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r6)     // Catch:{ all -> 0x052f }
            goto L_0x037c
        L_0x035d:
            com.google.android.gms.measurement.internal.zzhj r0 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzn()     // Catch:{ all -> 0x052f }
            java.lang.String r6 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r6)     // Catch:{ all -> 0x052f }
            goto L_0x037c
        L_0x036d:
            com.google.android.gms.measurement.internal.zzhj r0 = r9.zza     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzw()     // Catch:{ all -> 0x052f }
            java.lang.String r6 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r6)     // Catch:{ all -> 0x052f }
        L_0x037c:
            com.google.android.gms.measurement.internal.zzhc r0 = r23.zzl()     // Catch:{ all -> 0x052f }
            r0.zzt()     // Catch:{ all -> 0x052f }
            r23.zzs()     // Catch:{ all -> 0x052f }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x052f }
            r6.<init>()     // Catch:{ all -> 0x052f }
            r14 = 1
            r6.putLong(r13, r14)     // Catch:{ all -> 0x052f }
            r6.putLong(r12, r14)     // Catch:{ all -> 0x052f }
            r11 = 0
            r6.putLong(r7, r11)     // Catch:{ all -> 0x052f }
            r6.putLong(r5, r11)     // Catch:{ all -> 0x052f }
            r6.putLong(r4, r11)     // Catch:{ all -> 0x052f }
            r6.putLong(r3, r11)     // Catch:{ all -> 0x052f }
            r11 = 1
            r6.putLong(r10, r11)     // Catch:{ all -> 0x052f }
            boolean r0 = r2.zzo     // Catch:{ all -> 0x052f }
            if (r0 == 0) goto L_0x03ad
            r6.putLong(r8, r11)     // Catch:{ all -> 0x052f }
        L_0x03ad:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x052f }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x052f }
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzal r0 = r23.zzf()     // Catch:{ all -> 0x052f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x052f }
            r0.zzt()     // Catch:{ all -> 0x052f }
            r0.zzal()     // Catch:{ all -> 0x052f }
            java.lang.String r9 = "first_open_count"
            long r9 = r0.zzb((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzhj r0 = r1.zzm     // Catch:{ all -> 0x052f }
            android.content.Context r0 = r0.zza()     // Catch:{ all -> 0x052f }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x052f }
            if (r0 != 0) goto L_0x03ea
            com.google.android.gms.measurement.internal.zzfw r0 = r23.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzg()     // Catch:{ all -> 0x052f }
            java.lang.String r3 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x052f }
            r0.zza(r3, r4)     // Catch:{ all -> 0x052f }
        L_0x03e6:
            r3 = 0
            goto L_0x0494
        L_0x03ea:
            com.google.android.gms.measurement.internal.zzhj r0 = r1.zzm     // Catch:{ NameNotFoundException -> 0x03fa }
            android.content.Context r0 = r0.zza()     // Catch:{ NameNotFoundException -> 0x03fa }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03fa }
            r11 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r8, r11)     // Catch:{ NameNotFoundException -> 0x03fa }
            goto L_0x040d
        L_0x03fa:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r11 = r23.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r11 = r11.zzg()     // Catch:{ all -> 0x052f }
            java.lang.String r12 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x052f }
            r11.zza(r12, r13, r0)     // Catch:{ all -> 0x052f }
            r0 = 0
        L_0x040d:
            if (r0 == 0) goto L_0x0457
            long r11 = r0.firstInstallTime     // Catch:{ all -> 0x052f }
            r13 = 0
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x0457
            long r13 = r0.lastUpdateTime     // Catch:{ all -> 0x052f }
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x043c
            com.google.android.gms.measurement.internal.zzag r0 = r23.zze()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbf.zzbn     // Catch:{ all -> 0x052f }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r11)     // Catch:{ all -> 0x052f }
            if (r0 == 0) goto L_0x0435
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x043a
            r11 = 1
            r6.putLong(r7, r11)     // Catch:{ all -> 0x052f }
            goto L_0x043a
        L_0x0435:
            r11 = 1
            r6.putLong(r7, r11)     // Catch:{ all -> 0x052f }
        L_0x043a:
            r15 = 0
            goto L_0x043d
        L_0x043c:
            r15 = 1
        L_0x043d:
            com.google.android.gms.measurement.internal.zzno r0 = new com.google.android.gms.measurement.internal.zzno     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_fi"
            if (r15 == 0) goto L_0x0446
            r11 = 1
            goto L_0x0448
        L_0x0446:
            r11 = 0
        L_0x0448:
            java.lang.Long r19 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x052f }
            java.lang.String r20 = "auto"
            r15 = r0
            r17 = r21
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052f }
            r1.zza((com.google.android.gms.measurement.internal.zzno) r0, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
        L_0x0457:
            com.google.android.gms.measurement.internal.zzhj r0 = r1.zzm     // Catch:{ NameNotFoundException -> 0x0467 }
            android.content.Context r0 = r0.zza()     // Catch:{ NameNotFoundException -> 0x0467 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0467 }
            r7 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r8, r7)     // Catch:{ NameNotFoundException -> 0x0467 }
            goto L_0x047a
        L_0x0467:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r7 = r23.zzj()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzg()     // Catch:{ all -> 0x052f }
            java.lang.String r11 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x052f }
            r7.zza(r11, r8, r0)     // Catch:{ all -> 0x052f }
            r0 = 0
        L_0x047a:
            if (r0 == 0) goto L_0x03e6
            int r7 = r0.flags     // Catch:{ all -> 0x052f }
            r8 = 1
            r7 = r7 & r8
            if (r7 == 0) goto L_0x0487
            r7 = 1
            r6.putLong(r4, r7)     // Catch:{ all -> 0x052f }
        L_0x0487:
            int r0 = r0.flags     // Catch:{ all -> 0x052f }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03e6
            r7 = 1
            r6.putLong(r3, r7)     // Catch:{ all -> 0x052f }
            goto L_0x03e6
        L_0x0494:
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x049b
            r6.putLong(r5, r9)     // Catch:{ all -> 0x052f }
        L_0x049b:
            com.google.android.gms.measurement.internal.zzbd r0 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_f"
            com.google.android.gms.measurement.internal.zzbc r3 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x052f }
            r3.<init>(r6)     // Catch:{ all -> 0x052f }
            java.lang.String r18 = "auto"
            r15 = r0
            r17 = r3
            r19 = r21
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052f }
            r1.zzb((com.google.android.gms.measurement.internal.zzbd) r0, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
            goto L_0x0520
        L_0x04b3:
            r3 = r11
            if (r9 != r3) goto L_0x0520
            com.google.android.gms.measurement.internal.zzno r0 = new com.google.android.gms.measurement.internal.zzno     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_fvt"
            java.lang.Long r19 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x052f }
            java.lang.String r20 = "auto"
            r15 = r0
            r17 = r21
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x052f }
            r1.zza((com.google.android.gms.measurement.internal.zzno) r0, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzhc r0 = r23.zzl()     // Catch:{ all -> 0x052f }
            r0.zzt()     // Catch:{ all -> 0x052f }
            r23.zzs()     // Catch:{ all -> 0x052f }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x052f }
            r0.<init>()     // Catch:{ all -> 0x052f }
            r3 = 1
            r0.putLong(r13, r3)     // Catch:{ all -> 0x052f }
            r0.putLong(r12, r3)     // Catch:{ all -> 0x052f }
            r0.putLong(r10, r3)     // Catch:{ all -> 0x052f }
            boolean r5 = r2.zzo     // Catch:{ all -> 0x052f }
            if (r5 == 0) goto L_0x04ea
            r0.putLong(r8, r3)     // Catch:{ all -> 0x052f }
        L_0x04ea:
            com.google.android.gms.measurement.internal.zzbd r3 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_v"
            com.google.android.gms.measurement.internal.zzbc r4 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x052f }
            r4.<init>(r0)     // Catch:{ all -> 0x052f }
            java.lang.String r18 = "auto"
            r15 = r3
            r17 = r4
            r19 = r21
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052f }
            r1.zzb((com.google.android.gms.measurement.internal.zzbd) r3, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
            goto L_0x0520
        L_0x0501:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x052f }
            if (r0 == 0) goto L_0x0520
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x052f }
            r0.<init>()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzbd r3 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x052f }
            java.lang.String r16 = "_cd"
            com.google.android.gms.measurement.internal.zzbc r4 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x052f }
            r4.<init>(r0)     // Catch:{ all -> 0x052f }
            java.lang.String r18 = "auto"
            r15 = r3
            r17 = r4
            r19 = r21
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x052f }
            r1.zzb((com.google.android.gms.measurement.internal.zzbd) r3, (com.google.android.gms.measurement.internal.zzo) r2)     // Catch:{ all -> 0x052f }
        L_0x0520:
            com.google.android.gms.measurement.internal.zzal r0 = r23.zzf()     // Catch:{ all -> 0x052f }
            r0.zzw()     // Catch:{ all -> 0x052f }
            com.google.android.gms.measurement.internal.zzal r0 = r23.zzf()
            r0.zzu()
            return
        L_0x052f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r2 = r23.zzf()
            r2.zzu()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zzc(com.google.android.gms.measurement.internal.zzo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x024c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zza(com.google.android.gms.measurement.internal.zzo r14) {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.zzhc r0 = r13.zzl()
            r0.zzt()
            r13.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            java.lang.String r0 = r14.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            java.lang.String r0 = r14.zzu
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0029
            java.util.Map<java.lang.String, com.google.android.gms.measurement.internal.zznc$zzb> r0 = r13.zzae
            java.lang.String r2 = r14.zza
            com.google.android.gms.measurement.internal.zznc$zzb r3 = new com.google.android.gms.measurement.internal.zznc$zzb
            java.lang.String r4 = r14.zzu
            r3.<init>(r4)
            r0.put(r2, r3)
        L_0x0029:
            com.google.android.gms.measurement.internal.zzal r0 = r13.zzf()
            java.lang.String r2 = r14.zza
            com.google.android.gms.measurement.internal.zzg r0 = r0.zze(r2)
            java.lang.String r2 = r14.zza
            com.google.android.gms.measurement.internal.zzin r2 = r13.zzb((java.lang.String) r2)
            java.lang.String r3 = r14.zzt
            com.google.android.gms.measurement.internal.zzin r3 = com.google.android.gms.measurement.internal.zzin.zzb((java.lang.String) r3)
            com.google.android.gms.measurement.internal.zzin r2 = r2.zza((com.google.android.gms.measurement.internal.zzin) r3)
            boolean r3 = r2.zzi()
            if (r3 == 0) goto L_0x0054
            com.google.android.gms.measurement.internal.zzmc r3 = r13.zzj
            java.lang.String r4 = r14.zza
            boolean r5 = r14.zzn
            java.lang.String r3 = r3.zza((java.lang.String) r4, (boolean) r5)
            goto L_0x0056
        L_0x0054:
            java.lang.String r3 = ""
        L_0x0056:
            r4 = 0
            if (r0 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzhj r5 = r13.zzm
            java.lang.String r6 = r14.zza
            r0.<init>(r5, r6)
            boolean r5 = r2.zzj()
            if (r5 == 0) goto L_0x006f
            java.lang.String r5 = r13.zza((com.google.android.gms.measurement.internal.zzin) r2)
            r0.zzb((java.lang.String) r5)
        L_0x006f:
            boolean r2 = r2.zzi()
            if (r2 == 0) goto L_0x013e
            r0.zzh((java.lang.String) r3)
            goto L_0x013e
        L_0x007a:
            boolean r5 = r2.zzi()
            if (r5 == 0) goto L_0x0127
            if (r3 == 0) goto L_0x0127
            java.lang.String r5 = r0.zzaj()
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0127
            java.lang.String r5 = r0.zzaj()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r0.zzh((java.lang.String) r3)
            boolean r3 = r14.zzn
            if (r3 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzmc r3 = r13.zzj
            java.lang.String r6 = r14.zza
            android.util.Pair r3 = r3.zza((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzin) r2)
            java.lang.Object r3 = r3.first
            java.lang.String r6 = "00000000-0000-0000-0000-000000000000"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x010f
            if (r5 != 0) goto L_0x010f
            boolean r3 = com.google.android.gms.internal.measurement.zznk.zza()
            if (r3 == 0) goto L_0x00c9
            com.google.android.gms.measurement.internal.zzag r3 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbf.zzcv
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r5)
            if (r3 == 0) goto L_0x00c9
            boolean r3 = r2.zzj()
            if (r3 != 0) goto L_0x00c9
            r2 = 1
            goto L_0x00d1
        L_0x00c9:
            java.lang.String r2 = r13.zza((com.google.android.gms.measurement.internal.zzin) r2)
            r0.zzb((java.lang.String) r2)
            r2 = r4
        L_0x00d1:
            com.google.android.gms.measurement.internal.zzal r3 = r13.zzf()
            java.lang.String r5 = r14.zza
            java.lang.String r6 = "_id"
            com.google.android.gms.measurement.internal.zznq r3 = r3.zze(r5, r6)
            if (r3 == 0) goto L_0x013f
            com.google.android.gms.measurement.internal.zzal r3 = r13.zzf()
            java.lang.String r5 = r14.zza
            java.lang.String r6 = "_lair"
            com.google.android.gms.measurement.internal.zznq r3 = r3.zze(r5, r6)
            if (r3 != 0) goto L_0x013f
            com.google.android.gms.common.util.Clock r3 = r13.zzb()
            long r9 = r3.currentTimeMillis()
            com.google.android.gms.measurement.internal.zznq r3 = new com.google.android.gms.measurement.internal.zznq
            java.lang.String r6 = r14.zza
            java.lang.String r7 = "auto"
            java.lang.String r8 = "_lair"
            r11 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r5 = r3
            r5.<init>(r6, r7, r8, r9, r11)
            com.google.android.gms.measurement.internal.zzal r5 = r13.zzf()
            r5.zza((com.google.android.gms.measurement.internal.zznq) r3)
            goto L_0x013f
        L_0x010f:
            java.lang.String r3 = r0.zzad()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x013e
            boolean r3 = r2.zzj()
            if (r3 == 0) goto L_0x013e
            java.lang.String r2 = r13.zza((com.google.android.gms.measurement.internal.zzin) r2)
            r0.zzb((java.lang.String) r2)
            goto L_0x013e
        L_0x0127:
            java.lang.String r3 = r0.zzad()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x013e
            boolean r3 = r2.zzj()
            if (r3 == 0) goto L_0x013e
            java.lang.String r2 = r13.zza((com.google.android.gms.measurement.internal.zzin) r2)
            r0.zzb((java.lang.String) r2)
        L_0x013e:
            r2 = r4
        L_0x013f:
            java.lang.String r3 = r14.zzb
            r0.zzf((java.lang.String) r3)
            java.lang.String r3 = r14.zzp
            r0.zza((java.lang.String) r3)
            java.lang.String r3 = r14.zzk
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0156
            java.lang.String r3 = r14.zzk
            r0.zze((java.lang.String) r3)
        L_0x0156:
            long r5 = r14.zze
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0161
            r0.zzn(r5)
        L_0x0161:
            java.lang.String r3 = r14.zzc
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x016e
            java.lang.String r3 = r14.zzc
            r0.zzd((java.lang.String) r3)
        L_0x016e:
            long r5 = r14.zzj
            r0.zzb((long) r5)
            java.lang.String r3 = r14.zzd
            if (r3 == 0) goto L_0x017a
            r0.zzc((java.lang.String) r3)
        L_0x017a:
            long r5 = r14.zzf
            r0.zzk((long) r5)
            boolean r3 = r14.zzh
            r0.zzb((boolean) r3)
            java.lang.String r3 = r14.zzg
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0191
            java.lang.String r3 = r14.zzg
            r0.zzg((java.lang.String) r3)
        L_0x0191:
            boolean r3 = r14.zzn
            r0.zza((boolean) r3)
            java.lang.Boolean r3 = r14.zzq
            r0.zza((java.lang.Boolean) r3)
            long r5 = r14.zzr
            r0.zzl(r5)
            java.lang.String r3 = r14.zzv
            r0.zzj((java.lang.String) r3)
            boolean r3 = com.google.android.gms.internal.measurement.zznw.zza()
            if (r3 == 0) goto L_0x01bd
            com.google.android.gms.measurement.internal.zzag r3 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbf.zzbq
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r5)
            if (r3 == 0) goto L_0x01bd
            java.util.List<java.lang.String> r1 = r14.zzs
            r0.zza((java.util.List<java.lang.String>) r1)
            goto L_0x01d2
        L_0x01bd:
            boolean r3 = com.google.android.gms.internal.measurement.zznw.zza()
            if (r3 == 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzag r3 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbf.zzbp
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r5)
            if (r3 == 0) goto L_0x01d2
            r0.zza((java.util.List<java.lang.String>) r1)
        L_0x01d2:
            boolean r1 = com.google.android.gms.internal.measurement.zzpn.zza()
            if (r1 == 0) goto L_0x0207
            com.google.android.gms.measurement.internal.zzag r1 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzbs
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x0207
            r13.zzq()
            java.lang.String r1 = r0.zzac()
            boolean r1 = com.google.android.gms.measurement.internal.zznp.zzf(r1)
            if (r1 == 0) goto L_0x0207
            boolean r1 = r14.zzw
            r0.zzc((boolean) r1)
            com.google.android.gms.measurement.internal.zzag r1 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzbt
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x0207
            java.lang.String r1 = r14.zzac
            r0.zzk((java.lang.String) r1)
        L_0x0207:
            boolean r1 = com.google.android.gms.internal.measurement.zzpg.zza()
            if (r1 == 0) goto L_0x021e
            com.google.android.gms.measurement.internal.zzag r1 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzbz
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x021e
            int r1 = r14.zzaa
            r0.zza((int) r1)
        L_0x021e:
            long r5 = r14.zzx
            r0.zzt(r5)
            boolean r1 = com.google.android.gms.internal.measurement.zzne.zza()
            if (r1 == 0) goto L_0x023a
            com.google.android.gms.measurement.internal.zzag r1 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzcp
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x023a
            java.lang.String r14 = r14.zzad
            r0.zzi((java.lang.String) r14)
        L_0x023a:
            boolean r14 = com.google.android.gms.internal.measurement.zznk.zza()
            if (r14 == 0) goto L_0x025c
            com.google.android.gms.measurement.internal.zzag r14 = r13.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbf.zzcv
            boolean r14 = r14.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r1)
            if (r14 == 0) goto L_0x025c
            boolean r14 = r0.zzas()
            if (r14 != 0) goto L_0x0254
            if (r2 == 0) goto L_0x0269
        L_0x0254:
            com.google.android.gms.measurement.internal.zzal r14 = r13.zzf()
            r14.zza((com.google.android.gms.measurement.internal.zzg) r0, (boolean) r2, (boolean) r4)
            goto L_0x0269
        L_0x025c:
            boolean r14 = r0.zzas()
            if (r14 == 0) goto L_0x0269
            com.google.android.gms.measurement.internal.zzal r14 = r13.zzf()
            r14.zza((com.google.android.gms.measurement.internal.zzg) r0, (boolean) r4, (boolean) r4)
        L_0x0269:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zza(com.google.android.gms.measurement.internal.zzo):com.google.android.gms.measurement.internal.zzg");
    }

    private final void zzb(zzbd zzbd, zzo zzo2) {
        Preconditions.checkNotEmpty(zzo2.zza);
        zzga zza2 = zzga.zza(zzbd);
        zzq().zza(zza2.zzb, zzf().zzd(zzo2.zza));
        zzq().zza(zza2, zze().zzb(zzo2.zza));
        zzbd zza3 = zza2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza3.zza) && "referrer API v2".equals(zza3.zzb.zzd("_cis"))) {
            String zzd2 = zza3.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zza(new zzno("_lgclid", zza3.zzd, zzd2, "auto"), zzo2);
            }
        }
        zza(zza3, zzo2);
    }

    public final void zzb(zzg zzg2, zzfn.zzk.zza zza2) {
        zzl().zzt();
        zzs();
        zzfn.zza.C0045zza zzc2 = zzfn.zza.zzc();
        byte[] zzav = zzg2.zzav();
        if (zzav != null) {
            try {
                zzc2 = (zzfn.zza.C0045zza) zznl.zza(zzc2, zzav);
            } catch (zzjs unused) {
                zzj().zzu().zza("Failed to parse locally stored ad campaign info. appId", zzfw.zza(zzg2.zzac()));
            }
        }
        Iterator<zzfn.zzf> it = zza2.zzaa().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            zzfn.zzf next = it.next();
            if (next.zzg().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zznl.zza(next, "gclid", (Object) "");
                String str2 = (String) zznl.zza(next, "gbraid", (Object) "");
                String str3 = (String) zznl.zza(next, "gad_source", (Object) "");
                if (!str.isEmpty() || (!str2.isEmpty() || !str3.isEmpty())) {
                    long longValue = ((Long) zznl.zza(next, "click_timestamp", (Object) 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = next.zzd();
                    }
                    if ("referrer API v2".equals(zznl.zzb(next, "_cis"))) {
                        if (longValue > zzc2.zzb()) {
                            z = true;
                        }
                        if (z) {
                            if (str.isEmpty()) {
                                zzc2.zzh();
                            } else {
                                zzc2.zzf(str);
                            }
                            if (str2.isEmpty()) {
                                zzc2.zzg();
                            } else {
                                zzc2.zze(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc2.zzf();
                            } else {
                                zzc2.zzd(str3);
                            }
                            zzc2.zzb(longValue);
                        }
                    } else {
                        if (longValue > zzc2.zza()) {
                            z = true;
                        }
                        if (z) {
                            if (str.isEmpty()) {
                                zzc2.zze();
                            } else {
                                zzc2.zzc(str);
                            }
                            if (str2.isEmpty()) {
                                zzc2.zzd();
                            } else {
                                zzc2.zzb(str2);
                            }
                            if (str3.isEmpty()) {
                                zzc2.zzc();
                            } else {
                                zzc2.zza(str3);
                            }
                            zzc2.zza(longValue);
                        }
                    }
                }
            }
        }
        if (!((zzfn.zza) ((zzjk) zzc2.zzai())).equals(zzfn.zza.zze())) {
            zza2.zza((zzfn.zza) ((zzjk) zzc2.zzai()));
        }
        zzg2.zza(((zzfn.zza) ((zzjk) zzc2.zzai())).zzbz());
        if (zzg2.zzas()) {
            zzf().zza(zzg2, false, false);
        }
    }

    public final void zzb(zzae zzae2) {
        zzo zzc2 = zzc((String) Preconditions.checkNotNull(zzae2.zza));
        if (zzc2 != null) {
            zzb(zzae2, zzc2);
        }
    }

    public final void zzb(zzae zzae2, zzo zzo2) {
        boolean z;
        Preconditions.checkNotNull(zzae2);
        Preconditions.checkNotEmpty(zzae2.zza);
        Preconditions.checkNotNull(zzae2.zzb);
        Preconditions.checkNotNull(zzae2.zzc);
        Preconditions.checkNotEmpty(zzae2.zzc.zza);
        zzl().zzt();
        zzs();
        if (zzh(zzo2)) {
            if (!zzo2.zzh) {
                zza(zzo2);
                return;
            }
            zzae zzae3 = new zzae(zzae2);
            boolean z2 = false;
            zzae3.zze = false;
            zzf().zzp();
            try {
                zzae zzc2 = zzf().zzc((String) Preconditions.checkNotNull(zzae3.zza), zzae3.zzc.zza);
                if (zzc2 != null && !zzc2.zzb.equals(zzae3.zzb)) {
                    zzj().zzu().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzm.zzk().zzc(zzae3.zzc.zza), zzae3.zzb, zzc2.zzb);
                }
                if (zzc2 != null && (z = zzc2.zze)) {
                    zzae3.zzb = zzc2.zzb;
                    zzae3.zzd = zzc2.zzd;
                    zzae3.zzh = zzc2.zzh;
                    zzae3.zzf = zzc2.zzf;
                    zzae3.zzi = zzc2.zzi;
                    zzae3.zze = z;
                    zzno zzno = zzae3.zzc;
                    zzae3.zzc = new zzno(zzno.zza, zzc2.zzc.zzb, zzno.zza(), zzc2.zzc.zze);
                } else if (TextUtils.isEmpty(zzae3.zzf)) {
                    zzno zzno2 = zzae3.zzc;
                    zzae3.zzc = new zzno(zzno2.zza, zzae3.zzd, zzno2.zza(), zzae3.zzc.zze);
                    z2 = true;
                    zzae3.zze = true;
                }
                if (zzae3.zze) {
                    zzno zzno3 = zzae3.zzc;
                    zznq zznq = new zznq((String) Preconditions.checkNotNull(zzae3.zza), zzae3.zzb, zzno3.zza, zzno3.zzb, Preconditions.checkNotNull(zzno3.zza()));
                    if (zzf().zza(zznq)) {
                        zzj().zzc().zza("User property updated immediately", zzae3.zza, this.zzm.zzk().zzc(zznq.zzc), zznq.zze);
                    } else {
                        zzj().zzg().zza("(2)Too many active user properties, ignoring", zzfw.zza(zzae3.zza), this.zzm.zzk().zzc(zznq.zzc), zznq.zze);
                    }
                    if (z2 && zzae3.zzi != null) {
                        zzc(new zzbd(zzae3.zzi, zzae3.zzd), zzo2);
                    }
                }
                if (zzf().zza(zzae3)) {
                    zzj().zzc().zza("Conditional property added", zzae3.zza, this.zzm.zzk().zzc(zzae3.zzc.zza), zzae3.zzc.zza());
                } else {
                    zzj().zzg().zza("Too many conditional properties, ignoring", zzfw.zza(zzae3.zza), this.zzm.zzk().zzc(zzae3.zzc.zza), zzae3.zzc.zza());
                }
                zzf().zzw();
            } finally {
                zzf().zzu();
            }
        }
    }

    private final zzav zza(String str, zzav zzav, zzin zzin, zzah zzah2) {
        zzim zzim;
        zzin.zza zza2;
        zzim zza3;
        int i = 90;
        if (zzi().zzb(str) == null) {
            if (zzav.zzc() == zzim.DENIED) {
                i = zzav.zza();
                zzah2.zza(zzin.zza.AD_USER_DATA, i);
            } else {
                zzah2.zza(zzin.zza.AD_USER_DATA, zzak.FAILSAFE);
            }
            return new zzav(Boolean.FALSE, i, Boolean.TRUE, "-");
        }
        zzim zzc2 = zzav.zzc();
        zzim zzim2 = zzim.GRANTED;
        if (zzc2 == zzim2 || zzc2 == (zzim = zzim.DENIED)) {
            i = zzav.zza();
            zzah2.zza(zzin.zza.AD_USER_DATA, i);
        } else {
            boolean z = false;
            if (!zzne.zza() || !zze().zza(zzbf.zzcp)) {
                zzim zzim3 = zzim.UNINITIALIZED;
                if (zzc2 == zzim3 || zzc2 == zzim.POLICY) {
                    z = true;
                }
                Preconditions.checkArgument(z);
                zzgt zzgt = this.zzb;
                zzin.zza zza4 = zzin.zza.AD_USER_DATA;
                zzin.zza zzb2 = zzgt.zzb(str, zza4);
                Boolean zze2 = zzin.zze();
                if (zzb2 == zzin.zza.AD_STORAGE && zze2 != null) {
                    zzc2 = zze2.booleanValue() ? zzim2 : zzim;
                    zzah2.zza(zza4, zzak.REMOTE_DELEGATION);
                }
                if (zzc2 == zzim3) {
                    if (!this.zzb.zzc(str, zza4)) {
                        zzim2 = zzim;
                    }
                    zzah2.zza(zza4, zzak.REMOTE_DEFAULT);
                }
            } else if (zzc2 != zzim.POLICY || (zza3 = this.zzb.zza(str, zza2)) == zzim.UNINITIALIZED) {
                zzgt zzgt2 = this.zzb;
                zzin.zza zza5 = zzin.zza.AD_USER_DATA;
                zzin.zza zzb3 = zzgt2.zzb(str, zza5);
                zzim zzc3 = zzin.zzc();
                if (zzc3 == zzim2 || zzc3 == zzim) {
                    z = true;
                }
                if (zzb3 != zzin.zza.AD_STORAGE || !z) {
                    zzah2.zza(zza5, zzak.REMOTE_DEFAULT);
                    if (!this.zzb.zzc(str, zza5)) {
                        zzc2 = zzim;
                    }
                } else {
                    zzah2.zza(zza5, zzak.REMOTE_DELEGATION);
                    zzc2 = zzc3;
                }
            } else {
                zzah2.zza((zza2 = zzin.zza.AD_USER_DATA), zzak.REMOTE_ENFORCED_DEFAULT);
                zzc2 = zza3;
            }
            zzc2 = zzim2;
        }
        boolean zzn2 = this.zzb.zzn(str);
        SortedSet<String> zzh2 = zzi().zzh(str);
        if (zzc2 == zzim.DENIED || zzh2.isEmpty()) {
            return new zzav(Boolean.FALSE, i, Boolean.valueOf(zzn2), "-");
        }
        Boolean bool = Boolean.TRUE;
        Boolean valueOf = Boolean.valueOf(zzn2);
        String str2 = "";
        if (zzn2) {
            str2 = TextUtils.join(str2, zzh2);
        }
        return new zzav(bool, i, valueOf, str2);
    }

    private static zzmx zza(zzmx zzmx) {
        if (zzmx == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzmx.zzan()) {
            return zzmx;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzmx.getClass())));
        }
    }

    public static zznc zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zznc.class) {
                if (zza == null) {
                    zza = new zznc((zznm) Preconditions.checkNotNull(new zznm(context)));
                }
            }
        }
        return zza;
    }

    private final Boolean zza(zzg zzg2) {
        try {
            if (zzg2.zze() != -2147483648L) {
                if (zzg2.zze() == ((long) Wrappers.packageManager(this.zzm.zza()).getPackageInfo(zzg2.zzac(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzm.zza()).getPackageInfo(zzg2.zzac(), 0).versionName;
                String zzaf2 = zzg2.zzaf();
                if (zzaf2 != null && zzaf2.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final String zza(zzin zzin) {
        if (!zzin.zzj()) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzq().zzv().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public static /* synthetic */ void zza(zznc zznc, zznm zznm) {
        zznc.zzl().zzt();
        zznc.zzl = new zzgq(zznc);
        zzal zzal = new zzal(zznc);
        zzal.zzam();
        zznc.zzd = zzal;
        zznc.zze().zza((zzai) Preconditions.checkNotNull(zznc.zzb));
        zzmc zzmc = new zzmc(zznc);
        zzmc.zzam();
        zznc.zzj = zzmc;
        zzu zzu2 = new zzu(zznc);
        zzu2.zzam();
        zznc.zzg = zzu2;
        zzkn zzkn = new zzkn(zznc);
        zzkn.zzam();
        zznc.zzi = zzkn;
        zzmw zzmw = new zzmw(zznc);
        zzmw.zzam();
        zznc.zzf = zzmw;
        zznc.zze = new zzgg(zznc);
        if (zznc.zzs != zznc.zzt) {
            zznc.zzj().zzg().zza("Not all upload components initialized", Integer.valueOf(zznc.zzs), Integer.valueOf(zznc.zzt));
        }
        zznc.zzn = true;
    }

    public final void zza(Runnable runnable) {
        zzl().zzt();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    private static void zza(zzfn.zzk.zza zza2, zzin zzin) {
        if (!zzin.zzi()) {
            zza2.zzq();
            zza2.zzn();
            zza2.zzk();
        }
        if (!zzin.zzj()) {
            zza2.zzh();
            zza2.zzr();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:333:0x09cd, code lost:
        r8 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x030c A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0342 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03ae A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0731 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0743 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0789 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x07e4 A[SYNTHETIC, Splitter:B:280:0x07e4] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0806 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0880 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0899 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x08fb A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0923 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0941 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x09b7 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0a11 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c6 A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ce A[Catch:{ SQLiteException -> 0x02d6, all -> 0x0a5c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.measurement.internal.zzbd r37, com.google.android.gms.measurement.internal.zzo r38) {
        /*
            r36 = this;
            r1 = r36
            r2 = r37
            r3 = r38
            java.lang.String r4 = "_fx"
            java.lang.String r5 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r38)
            java.lang.String r6 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)
            long r6 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzhc r8 = r36.zzl()
            r8.zzt()
            r36.zzs()
            java.lang.String r8 = r3.zza
            r36.zzp()
            boolean r9 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.measurement.internal.zzbd) r37, (com.google.android.gms.measurement.internal.zzo) r38)
            if (r9 != 0) goto L_0x002c
            return
        L_0x002c:
            boolean r9 = r3.zzh
            if (r9 != 0) goto L_0x0034
            r1.zza((com.google.android.gms.measurement.internal.zzo) r3)
            return
        L_0x0034:
            com.google.android.gms.measurement.internal.zzgt r9 = r36.zzi()
            java.lang.String r10 = r2.zza
            boolean r9 = r9.zzd(r8, r10)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r9 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfw r3 = r36.zzj()
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzu()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)
            com.google.android.gms.measurement.internal.zzhj r5 = r1.zzm
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzk()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzgt r3 = r36.zzi()
            boolean r3 = r3.zzm(r8)
            if (r3 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzgt r3 = r36.zzi()
            boolean r3 = r3.zzo(r8)
            if (r3 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r3 = 0
            goto L_0x0078
        L_0x0077:
            r3 = 1
        L_0x0078:
            if (r3 != 0) goto L_0x0095
            java.lang.String r4 = r2.zza
            boolean r4 = r15.equals(r4)
            if (r4 != 0) goto L_0x0095
            r36.zzq()
            com.google.android.gms.measurement.internal.zznr r9 = r1.zzah
            r11 = 11
            java.lang.String r12 = "_ev"
            java.lang.String r13 = r2.zza
            r2 = 0
            r10 = r8
            r4 = r14
            r14 = r2
            com.google.android.gms.measurement.internal.zznp.zza((com.google.android.gms.measurement.internal.zznr) r9, (java.lang.String) r10, (int) r11, (java.lang.String) r12, (java.lang.String) r13, (int) r14)
            goto L_0x0096
        L_0x0095:
            r4 = r14
        L_0x0096:
            if (r3 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()
            com.google.android.gms.measurement.internal.zzg r2 = r2.zze(r8)
            if (r2 == 0) goto L_0x00de
            long r5 = r2.zzp()
            long r7 = r2.zzg()
            long r5 = java.lang.Math.max(r5, r7)
            com.google.android.gms.common.util.Clock r3 = r36.zzb()
            long r7 = r3.currentTimeMillis()
            long r7 = r7 - r5
            long r5 = java.lang.Math.abs(r7)
            r36.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r3 = com.google.android.gms.measurement.internal.zzbf.zzz
            java.lang.Object r3 = r3.zza(r4)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfw r3 = r36.zzj()
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzb((com.google.android.gms.measurement.internal.zzg) r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzga r2 = com.google.android.gms.measurement.internal.zzga.zza(r37)
            com.google.android.gms.measurement.internal.zznp r9 = r36.zzq()
            com.google.android.gms.measurement.internal.zzag r10 = r36.zze()
            int r10 = r10.zzb(r8)
            r9.zza((com.google.android.gms.measurement.internal.zzga) r2, (int) r10)
            boolean r9 = com.google.android.gms.internal.measurement.zzou.zza()
            if (r9 == 0) goto L_0x0113
            com.google.android.gms.measurement.internal.zzag r9 = r36.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzbf.zzby
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r10)
            if (r9 == 0) goto L_0x0113
            com.google.android.gms.measurement.internal.zzag r9 = r36.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzbf.zzaq
            r11 = 10
            r12 = 35
            int r9 = r9.zza(r8, r10, r11, r12)
            goto L_0x0114
        L_0x0113:
            r9 = 0
        L_0x0114:
            java.util.TreeSet r10 = new java.util.TreeSet
            android.os.Bundle r11 = r2.zzb
            java.util.Set r11 = r11.keySet()
            r10.<init>(r11)
            java.util.Iterator r10 = r10.iterator()
        L_0x0123:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x015b
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "items"
            boolean r12 = r12.equals(r11)
            if (r12 == 0) goto L_0x0159
            com.google.android.gms.measurement.internal.zznp r12 = r36.zzq()
            android.os.Bundle r13 = r2.zzb
            android.os.Parcelable[] r11 = r13.getParcelableArray(r11)
            boolean r13 = com.google.android.gms.internal.measurement.zzou.zza()
            if (r13 == 0) goto L_0x0155
            com.google.android.gms.measurement.internal.zzag r13 = r36.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzbf.zzby
            boolean r13 = r13.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r14)
            if (r13 == 0) goto L_0x0155
            r13 = 1
            goto L_0x0156
        L_0x0155:
            r13 = 0
        L_0x0156:
            r12.zza((android.os.Parcelable[]) r11, (int) r9, (boolean) r13)
        L_0x0159:
            r14 = 0
            goto L_0x0123
        L_0x015b:
            com.google.android.gms.measurement.internal.zzbd r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzfw r9 = r36.zzj()
            r10 = 2
            boolean r9 = r9.zza((int) r10)
            if (r9 == 0) goto L_0x0181
            com.google.android.gms.measurement.internal.zzfw r9 = r36.zzj()
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzp()
            com.google.android.gms.measurement.internal.zzhj r11 = r1.zzm
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzk()
            java.lang.String r11 = r11.zza((com.google.android.gms.measurement.internal.zzbd) r2)
            java.lang.String r12 = "Logging event"
            r9.zza(r12, r11)
        L_0x0181:
            boolean r9 = com.google.android.gms.internal.measurement.zzoo.zza()
            if (r9 == 0) goto L_0x0190
            com.google.android.gms.measurement.internal.zzag r9 = r36.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbf.zzbv
            r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r11)
        L_0x0190:
            com.google.android.gms.measurement.internal.zzal r9 = r36.zzf()
            r9.zzp()
            r1.zza((com.google.android.gms.measurement.internal.zzo) r3)     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = "ecommerce_purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a5c }
            java.lang.String r11 = "refund"
            if (r9 != 0) goto L_0x01bb
            java.lang.String r9 = "purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x0a5c }
            if (r9 != 0) goto L_0x01bb
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a5c }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x01b9
            goto L_0x01bb
        L_0x01b9:
            r9 = 0
            goto L_0x01bc
        L_0x01bb:
            r9 = 1
        L_0x01bc:
            java.lang.String r12 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0a5c }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0a5c }
            if (r12 != 0) goto L_0x01cb
            if (r9 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01c9:
            r12 = 0
            goto L_0x01cc
        L_0x01cb:
            r12 = 1
        L_0x01cc:
            if (r12 == 0) goto L_0x0351
            com.google.android.gms.measurement.internal.zzbc r12 = r2.zzb     // Catch:{ all -> 0x0a5c }
            java.lang.String r13 = "currency"
            java.lang.String r12 = r12.zzd(r13)     // Catch:{ all -> 0x0a5c }
            java.lang.String r13 = "value"
            if (r9 == 0) goto L_0x0235
            com.google.android.gms.measurement.internal.zzbc r9 = r2.zzb     // Catch:{ all -> 0x0a5c }
            java.lang.Double r9 = r9.zza((java.lang.String) r13)     // Catch:{ all -> 0x0a5c }
            double r19 = r9.doubleValue()     // Catch:{ all -> 0x0a5c }
            r21 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r19 = r19 * r21
            r23 = 0
            int r9 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r9 != 0) goto L_0x01fe
            com.google.android.gms.measurement.internal.zzbc r9 = r2.zzb     // Catch:{ all -> 0x0a5c }
            java.lang.Long r9 = r9.zzb(r13)     // Catch:{ all -> 0x0a5c }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0a5c }
            double r13 = (double) r13     // Catch:{ all -> 0x0a5c }
            double r19 = r13 * r21
        L_0x01fe:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x0218
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x0218
            long r13 = java.lang.Math.round(r19)     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a5c }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x023f
            long r13 = -r13
            goto L_0x023f
        L_0x0218:
            com.google.android.gms.measurement.internal.zzfw r9 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzu()     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = "Data lost. Currency value is too big. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a5c }
            java.lang.Double r12 = java.lang.Double.valueOf(r19)     // Catch:{ all -> 0x0a5c }
            r9.zza(r10, r11, r12)     // Catch:{ all -> 0x0a5c }
            r24 = r6
            r26 = r15
            r7 = 0
            r13 = 0
            goto L_0x0340
        L_0x0235:
            com.google.android.gms.measurement.internal.zzbc r9 = r2.zzb     // Catch:{ all -> 0x0a5c }
            java.lang.Long r9 = r9.zzb(r13)     // Catch:{ all -> 0x0a5c }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0a5c }
        L_0x023f:
            boolean r9 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0a5c }
            if (r9 != 0) goto L_0x033a
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r12.toUpperCase(r9)     // Catch:{ all -> 0x0a5c }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x0a5c }
            if (r11 == 0) goto L_0x033a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a5c }
            java.lang.String r12 = "_ltv_"
            r11.<init>(r12)     // Catch:{ all -> 0x0a5c }
            r11.append(r9)     // Catch:{ all -> 0x0a5c }
            java.lang.String r12 = r11.toString()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r9 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznq r9 = r9.zze(r8, r12)     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x029d
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0a5c }
            boolean r11 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x0a5c }
            if (r11 != 0) goto L_0x0272
            goto L_0x029d
        L_0x0272:
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x0a5c }
            long r9 = r9.longValue()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznq r19 = new com.google.android.gms.measurement.internal.zznq     // Catch:{ all -> 0x0a5c }
            java.lang.String r11 = r2.zzc     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.common.util.Clock r20 = r36.zzb()     // Catch:{ all -> 0x0a5c }
            long r20 = r20.currentTimeMillis()     // Catch:{ all -> 0x0a5c }
            long r9 = r9 + r13
            java.lang.Long r22 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0a5c }
            r9 = r19
            r10 = r8
            r13 = 0
            r24 = r6
            r7 = r13
            r6 = 1
            r13 = r20
            r26 = r15
            r15 = r22
            r9.<init>(r10, r11, r12, r13, r15)     // Catch:{ all -> 0x0a5c }
        L_0x029a:
            r6 = r19
            goto L_0x0302
        L_0x029d:
            r24 = r6
            r26 = r15
            r6 = 1
            r7 = 0
            com.google.android.gms.measurement.internal.zzal r9 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzag r11 = r36.zze()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzbf.zzae     // Catch:{ all -> 0x0a5c }
            int r11 = r11.zzb((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzfj<java.lang.Integer>) r15)     // Catch:{ all -> 0x0a5c }
            int r11 = r11 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0a5c }
            r9.zzt()     // Catch:{ all -> 0x0a5c }
            r9.zzal()     // Catch:{ all -> 0x0a5c }
            android.database.sqlite.SQLiteDatabase r15 = r9.e_()     // Catch:{ SQLiteException -> 0x02d6 }
            java.lang.String r10 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x02d6 }
            r6[r7] = r8     // Catch:{ SQLiteException -> 0x02d6 }
            r17 = 1
            r6[r17] = r8     // Catch:{ SQLiteException -> 0x02d6 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x02d6 }
            r16 = 2
            r6[r16] = r11     // Catch:{ SQLiteException -> 0x02d6 }
            r15.execSQL(r10, r6)     // Catch:{ SQLiteException -> 0x02d6 }
            goto L_0x02e9
        L_0x02d6:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfw r9 = r9.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = "Error pruning currencies. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a5c }
            r9.zza(r10, r11, r6)     // Catch:{ all -> 0x0a5c }
        L_0x02e9:
            com.google.android.gms.measurement.internal.zznq r19 = new com.google.android.gms.measurement.internal.zznq     // Catch:{ all -> 0x0a5c }
            java.lang.String r11 = r2.zzc     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.common.util.Clock r6 = r36.zzb()     // Catch:{ all -> 0x0a5c }
            long r15 = r6.currentTimeMillis()     // Catch:{ all -> 0x0a5c }
            java.lang.Long r6 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a5c }
            r9 = r19
            r10 = r8
            r13 = r15
            r15 = r6
            r9.<init>(r10, r11, r12, r13, r15)     // Catch:{ all -> 0x0a5c }
            goto L_0x029a
        L_0x0302:
            com.google.android.gms.measurement.internal.zzal r9 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zznq) r6)     // Catch:{ all -> 0x0a5c }
            if (r9 != 0) goto L_0x033f
            com.google.android.gms.measurement.internal.zzfw r9 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r12 = r1.zzm     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfr r12 = r12.zzk()     // Catch:{ all -> 0x0a5c }
            java.lang.String r13 = r6.zzc     // Catch:{ all -> 0x0a5c }
            java.lang.String r12 = r12.zzc(r13)     // Catch:{ all -> 0x0a5c }
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x0a5c }
            r9.zza(r10, r11, r12, r6)     // Catch:{ all -> 0x0a5c }
            r36.zzq()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznr r9 = r1.zzah     // Catch:{ all -> 0x0a5c }
            r11 = 9
            r12 = 0
            r13 = 0
            r14 = 0
            r10 = r8
            com.google.android.gms.measurement.internal.zznp.zza((com.google.android.gms.measurement.internal.zznr) r9, (java.lang.String) r10, (int) r11, (java.lang.String) r12, (java.lang.String) r13, (int) r14)     // Catch:{ all -> 0x0a5c }
            goto L_0x033f
        L_0x033a:
            r24 = r6
            r26 = r15
            r7 = 0
        L_0x033f:
            r13 = 1
        L_0x0340:
            if (r13 != 0) goto L_0x0356
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            r2.zzw()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()
            r2.zzu()
            return
        L_0x0351:
            r24 = r6
            r26 = r15
            r7 = 0
        L_0x0356:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x0a5c }
            boolean r6 = com.google.android.gms.measurement.internal.zznp.zzh(r6)     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a5c }
            r10 = r26
            boolean r21 = r10.equals(r9)     // Catch:{ all -> 0x0a5c }
            r36.zzq()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzbc r9 = r2.zzb     // Catch:{ all -> 0x0a5c }
            long r9 = com.google.android.gms.measurement.internal.zznp.zza((com.google.android.gms.measurement.internal.zzbc) r9)     // Catch:{ all -> 0x0a5c }
            r13 = 1
            long r15 = r9 + r13
            com.google.android.gms.measurement.internal.zzal r9 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            long r10 = r36.zzx()     // Catch:{ all -> 0x0a5c }
            r17 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r12 = r8
            r22 = r8
            r7 = r13
            r13 = r15
            r15 = r17
            r16 = r6
            r17 = r18
            r18 = r21
            com.google.android.gms.measurement.internal.zzaq r9 = r9.zza(r10, r12, r13, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0a5c }
            long r10 = r9.zzb     // Catch:{ all -> 0x0a5c }
            r36.zze()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzbf.zzk     // Catch:{ all -> 0x0a5c }
            r13 = 0
            java.lang.Object r12 = r12.zza(r13)     // Catch:{ all -> 0x0a5c }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x0a5c }
            int r12 = r12.intValue()     // Catch:{ all -> 0x0a5c }
            long r12 = (long) r12     // Catch:{ all -> 0x0a5c }
            long r10 = r10 - r12
            r14 = 0
            int r12 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            r16 = 1000(0x3e8, double:4.94E-321)
            if (r12 <= 0) goto L_0x03da
            long r10 = r10 % r16
            int r2 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x03cb
            com.google.android.gms.measurement.internal.zzfw r2 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r22)     // Catch:{ all -> 0x0a5c }
            long r5 = r9.zzb     // Catch:{ all -> 0x0a5c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a5c }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0a5c }
        L_0x03cb:
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            r2.zzw()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()
            r2.zzu()
            return
        L_0x03da:
            if (r6 == 0) goto L_0x0431
            long r10 = r9.zza     // Catch:{ all -> 0x0a5c }
            r36.zze()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzbf.zzm     // Catch:{ all -> 0x0a5c }
            r13 = 0
            java.lang.Object r12 = r12.zza(r13)     // Catch:{ all -> 0x0a5c }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x0a5c }
            int r12 = r12.intValue()     // Catch:{ all -> 0x0a5c }
            long r12 = (long) r12     // Catch:{ all -> 0x0a5c }
            long r10 = r10 - r12
            int r12 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x0431
            long r10 = r10 % r16
            int r3 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0411
            com.google.android.gms.measurement.internal.zzfw r3 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r22)     // Catch:{ all -> 0x0a5c }
            long r6 = r9.zza     // Catch:{ all -> 0x0a5c }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a5c }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x0a5c }
        L_0x0411:
            r36.zzq()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznr r9 = r1.zzah     // Catch:{ all -> 0x0a5c }
            r11 = 16
            java.lang.String r12 = "_ev"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0a5c }
            r14 = 0
            r10 = r22
            com.google.android.gms.measurement.internal.zznp.zza((com.google.android.gms.measurement.internal.zznr) r9, (java.lang.String) r10, (int) r11, (java.lang.String) r12, (java.lang.String) r13, (int) r14)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            r2.zzw()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()
            r2.zzu()
            return
        L_0x0431:
            if (r21 == 0) goto L_0x047f
            long r10 = r9.zzd     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzag r12 = r36.zze()     // Catch:{ all -> 0x0a5c }
            java.lang.String r13 = r3.zza     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzbf.zzl     // Catch:{ all -> 0x0a5c }
            int r7 = r12.zzb((java.lang.String) r13, (com.google.android.gms.measurement.internal.zzfj<java.lang.Integer>) r7)     // Catch:{ all -> 0x0a5c }
            r8 = 1000000(0xf4240, float:1.401298E-39)
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ all -> 0x0a5c }
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)     // Catch:{ all -> 0x0a5c }
            long r7 = (long) r7     // Catch:{ all -> 0x0a5c }
            long r10 = r10 - r7
            int r7 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r7 <= 0) goto L_0x047f
            r7 = 1
            int r2 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x0470
            com.google.android.gms.measurement.internal.zzfw r2 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r22)     // Catch:{ all -> 0x0a5c }
            long r5 = r9.zzd     // Catch:{ all -> 0x0a5c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a5c }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x0a5c }
        L_0x0470:
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            r2.zzw()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()
            r2.zzu()
            return
        L_0x047f:
            com.google.android.gms.measurement.internal.zzbc r7 = r2.zzb     // Catch:{ all -> 0x0a5c }
            android.os.Bundle r7 = r7.zzb()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznp r8 = r36.zzq()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = "_o"
            java.lang.String r10 = r2.zzc     // Catch:{ all -> 0x0a5c }
            r8.zza((android.os.Bundle) r7, (java.lang.String) r9, (java.lang.Object) r10)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznp r8 = r36.zzq()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r3.zzac     // Catch:{ all -> 0x0a5c }
            r13 = r22
            boolean r8 = r8.zzd(r13, r9)     // Catch:{ all -> 0x0a5c }
            java.lang.String r12 = "_r"
            if (r8 == 0) goto L_0x04ba
            com.google.android.gms.measurement.internal.zznp r8 = r36.zzq()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = "_dbg"
            r10 = 1
            java.lang.Long r14 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0a5c }
            r8.zza((android.os.Bundle) r7, (java.lang.String) r9, (java.lang.Object) r14)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznp r8 = r36.zzq()     // Catch:{ all -> 0x0a5c }
            java.lang.Long r9 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0a5c }
            r8.zza((android.os.Bundle) r7, (java.lang.String) r12, (java.lang.Object) r9)     // Catch:{ all -> 0x0a5c }
        L_0x04ba:
            java.lang.String r8 = "_s"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a5c }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x04df
            com.google.android.gms.measurement.internal.zzal r8 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznq r8 = r8.zze(r9, r5)     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x04df
            java.lang.Object r9 = r8.zze     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x04df
            com.google.android.gms.measurement.internal.zznp r9 = r36.zzq()     // Catch:{ all -> 0x0a5c }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0a5c }
            r9.zza((android.os.Bundle) r7, (java.lang.String) r5, (java.lang.Object) r8)     // Catch:{ all -> 0x0a5c }
        L_0x04df:
            com.google.android.gms.measurement.internal.zzal r5 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            long r8 = r5.zza((java.lang.String) r13)     // Catch:{ all -> 0x0a5c }
            r14 = 0
            int r5 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r5 <= 0) goto L_0x0502
            com.google.android.gms.measurement.internal.zzfw r5 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzu()     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ all -> 0x0a5c }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0a5c }
            r5.zza(r10, r11, r8)     // Catch:{ all -> 0x0a5c }
        L_0x0502:
            com.google.android.gms.measurement.internal.zzba r5 = new com.google.android.gms.measurement.internal.zzba     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r10 = r1.zzm     // Catch:{ all -> 0x0a5c }
            java.lang.String r11 = r2.zzc     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a5c }
            long r14 = r2.zzd     // Catch:{ all -> 0x0a5c }
            r18 = 0
            r9 = r5
            r2 = r12
            r12 = r13
            r30 = r2
            r2 = r13
            r13 = r8
            r16 = r18
            r18 = r7
            r9.<init>((com.google.android.gms.measurement.internal.zzhj) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (long) r14, (long) r16, (android.os.Bundle) r18)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r7 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzaz r7 = r7.zzd(r2, r8)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x059a
            com.google.android.gms.measurement.internal.zzal r7 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            long r7 = r7.zzc(r2)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzag r9 = r36.zze()     // Catch:{ all -> 0x0a5c }
            int r9 = r9.zza((java.lang.String) r2)     // Catch:{ all -> 0x0a5c }
            long r9 = (long) r9     // Catch:{ all -> 0x0a5c }
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x057e
            if (r6 == 0) goto L_0x057e
            com.google.android.gms.measurement.internal.zzfw r3 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r4 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r2)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r7 = r1.zzm     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzk()     // Catch:{ all -> 0x0a5c }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x0a5c }
            java.lang.String r5 = r7.zza((java.lang.String) r5)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzag r7 = r36.zze()     // Catch:{ all -> 0x0a5c }
            int r7 = r7.zza((java.lang.String) r2)     // Catch:{ all -> 0x0a5c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0a5c }
            r3.zza(r4, r6, r5, r7)     // Catch:{ all -> 0x0a5c }
            r36.zzq()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznr r9 = r1.zzah     // Catch:{ all -> 0x0a5c }
            r11 = 8
            r12 = 0
            r13 = 0
            r14 = 0
            r10 = r2
            com.google.android.gms.measurement.internal.zznp.zza((com.google.android.gms.measurement.internal.zznr) r9, (java.lang.String) r10, (int) r11, (java.lang.String) r12, (java.lang.String) r13, (int) r14)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()
            r2.zzu()
            return
        L_0x057e:
            com.google.android.gms.measurement.internal.zzaz r6 = new com.google.android.gms.measurement.internal.zzaz     // Catch:{ all -> 0x0a5c }
            java.lang.String r11 = r5.zzb     // Catch:{ all -> 0x0a5c }
            r12 = 0
            r14 = 0
            long r7 = r5.zzc     // Catch:{ all -> 0x0a5c }
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r9 = r6
            r10 = r2
            r16 = r7
            r9.<init>(r10, r11, r12, r14, r16, r18, r20, r21, r22, r23)     // Catch:{ all -> 0x0a5c }
            goto L_0x05a8
        L_0x059a:
            com.google.android.gms.measurement.internal.zzhj r2 = r1.zzm     // Catch:{ all -> 0x0a5c }
            long r8 = r7.zzf     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzba r5 = r5.zza(r2, r8)     // Catch:{ all -> 0x0a5c }
            long r8 = r5.zzc     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzaz r6 = r7.zza(r8)     // Catch:{ all -> 0x0a5c }
        L_0x05a8:
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            r2.zza((com.google.android.gms.measurement.internal.zzaz) r6)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhc r2 = r36.zzl()     // Catch:{ all -> 0x0a5c }
            r2.zzt()     // Catch:{ all -> 0x0a5c }
            r36.zzs()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r38)     // Catch:{ all -> 0x0a5c }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0a5c }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a5c }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x0a5c }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r2 = com.google.android.gms.internal.measurement.zzfn.zzk.zzw()     // Catch:{ all -> 0x0a5c }
            r6 = 1
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r2 = r2.zzh((int) r6)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r2 = r2.zzp(r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a5c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x05eb
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a5c }
            r2.zzb((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
        L_0x05eb:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0a5c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x05f8
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0a5c }
            r2.zzd((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
        L_0x05f8:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0a5c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x0605
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0a5c }
            r2.zze((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
        L_0x0605:
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0a5c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x0612
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x0a5c }
            r2.zzr(r7)     // Catch:{ all -> 0x0a5c }
        L_0x0612:
            long r7 = r3.zzj     // Catch:{ all -> 0x0a5c }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 == 0) goto L_0x061f
            int r7 = (int) r7     // Catch:{ all -> 0x0a5c }
            r2.zze((int) r7)     // Catch:{ all -> 0x0a5c }
        L_0x061f:
            long r7 = r3.zze     // Catch:{ all -> 0x0a5c }
            r2.zzf((long) r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0a5c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x0631
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0a5c }
            r2.zzm(r7)     // Catch:{ all -> 0x0a5c }
        L_0x0631:
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a5c }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzin r7 = r1.zzb((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r3.zzt     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzin r8 = com.google.android.gms.measurement.internal.zzin.zzb((java.lang.String) r8)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzin r7 = r7.zza((com.google.android.gms.measurement.internal.zzin) r8)     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r7.zzg()     // Catch:{ all -> 0x0a5c }
            r2.zzg((java.lang.String) r8)     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r2.zzx()     // Catch:{ all -> 0x0a5c }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0665
            java.lang.String r8 = r3.zzp     // Catch:{ all -> 0x0a5c }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a5c }
            if (r8 != 0) goto L_0x0665
            java.lang.String r8 = r3.zzp     // Catch:{ all -> 0x0a5c }
            r2.zza((java.lang.String) r8)     // Catch:{ all -> 0x0a5c }
        L_0x0665:
            boolean r8 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0729
            com.google.android.gms.measurement.internal.zzag r8 = r36.zze()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzbf.zzbz     // Catch:{ all -> 0x0a5c }
            boolean r8 = r8.zze(r9, r10)     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0729
            r36.zzq()     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a5c }
            boolean r8 = com.google.android.gms.measurement.internal.zznp.zzd(r8)     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0729
            int r8 = r3.zzaa     // Catch:{ all -> 0x0a5c }
            r2.zzd((int) r8)     // Catch:{ all -> 0x0a5c }
            long r8 = r3.zzab     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzag r10 = r36.zze()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbf.zzcd     // Catch:{ all -> 0x0a5c }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a5c }
            r11 = 32
            if (r10 != 0) goto L_0x06ac
            boolean r7 = r7.zzi()     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x06ac
            r13 = 0
            int r7 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x06ae
            r15 = -2
            long r7 = r8 & r15
            long r8 = r7 | r11
            goto L_0x06ae
        L_0x06ac:
            r13 = 0
        L_0x06ae:
            r15 = 1
            int r7 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r7 != 0) goto L_0x06b6
            r7 = r6
            goto L_0x06b7
        L_0x06b6:
            r7 = 0
        L_0x06b7:
            r2.zza((boolean) r7)     // Catch:{ all -> 0x0a5c }
            int r7 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x072b
            com.google.android.gms.internal.measurement.zzfn$zzc$zza r7 = com.google.android.gms.internal.measurement.zzfn.zzc.zza()     // Catch:{ all -> 0x0a5c }
            r15 = 1
            long r17 = r8 & r15
            int r10 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x06cc
            r10 = r6
            goto L_0x06cd
        L_0x06cc:
            r10 = 0
        L_0x06cd:
            r7.zzc(r10)     // Catch:{ all -> 0x0a5c }
            r15 = 2
            long r15 = r15 & r8
            int r10 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x06d9
            r10 = r6
            goto L_0x06da
        L_0x06d9:
            r10 = 0
        L_0x06da:
            r7.zze(r10)     // Catch:{ all -> 0x0a5c }
            r15 = 4
            long r15 = r15 & r8
            int r10 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x06e6
            r10 = r6
            goto L_0x06e7
        L_0x06e6:
            r10 = 0
        L_0x06e7:
            r7.zzf(r10)     // Catch:{ all -> 0x0a5c }
            r15 = 8
            long r15 = r15 & r8
            int r10 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x06f3
            r10 = r6
            goto L_0x06f4
        L_0x06f3:
            r10 = 0
        L_0x06f4:
            r7.zzg(r10)     // Catch:{ all -> 0x0a5c }
            r15 = 16
            long r15 = r15 & r8
            int r10 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x0700
            r10 = r6
            goto L_0x0701
        L_0x0700:
            r10 = 0
        L_0x0701:
            r7.zzb(r10)     // Catch:{ all -> 0x0a5c }
            long r10 = r8 & r11
            int r10 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x070c
            r10 = r6
            goto L_0x070d
        L_0x070c:
            r10 = 0
        L_0x070d:
            r7.zza(r10)     // Catch:{ all -> 0x0a5c }
            r10 = 64
            long r8 = r8 & r10
            int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x0719
            r8 = r6
            goto L_0x071a
        L_0x0719:
            r8 = 0
        L_0x071a:
            r7.zzd(r8)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzkt r7 = r7.zzai()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzjk r7 = (com.google.android.gms.internal.measurement.zzjk) r7     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzfn$zzc r7 = (com.google.android.gms.internal.measurement.zzfn.zzc) r7     // Catch:{ all -> 0x0a5c }
            r2.zza((com.google.android.gms.internal.measurement.zzfn.zzc) r7)     // Catch:{ all -> 0x0a5c }
            goto L_0x072b
        L_0x0729:
            r13 = 0
        L_0x072b:
            long r7 = r3.zzf     // Catch:{ all -> 0x0a5c }
            int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x0734
            r2.zzc((long) r7)     // Catch:{ all -> 0x0a5c }
        L_0x0734:
            long r7 = r3.zzr     // Catch:{ all -> 0x0a5c }
            r2.zzd((long) r7)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznl r7 = r36.zzp()     // Catch:{ all -> 0x0a5c }
            java.util.List r7 = r7.zzu()     // Catch:{ all -> 0x0a5c }
            if (r7 == 0) goto L_0x0746
            r2.zzc((java.lang.Iterable<? extends java.lang.Integer>) r7)     // Catch:{ all -> 0x0a5c }
        L_0x0746:
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a5c }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzin r7 = r1.zzb((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r3.zzt     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzin r8 = com.google.android.gms.measurement.internal.zzin.zzb((java.lang.String) r8)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzin r7 = r7.zza((com.google.android.gms.measurement.internal.zzin) r8)     // Catch:{ all -> 0x0a5c }
            boolean r8 = r7.zzi()     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0836
            boolean r8 = r3.zzn     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0836
            com.google.android.gms.measurement.internal.zzmc r8 = r1.zzj     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0a5c }
            android.util.Pair r8 = r8.zza((java.lang.String) r9, (com.google.android.gms.measurement.internal.zzin) r7)     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0836
            java.lang.Object r9 = r8.first     // Catch:{ all -> 0x0a5c }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ all -> 0x0a5c }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0a5c }
            if (r9 != 0) goto L_0x0836
            boolean r9 = r3.zzn     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x0836
            java.lang.Object r9 = r8.first     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0a5c }
            r2.zzq(r9)     // Catch:{ all -> 0x0a5c }
            java.lang.Object r9 = r8.second     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x0792
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0a5c }
            r2.zzc((boolean) r9)     // Catch:{ all -> 0x0a5c }
        L_0x0792:
            boolean r9 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x0836
            com.google.android.gms.measurement.internal.zzag r9 = r36.zze()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzbf.zzck     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r10)     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x0836
            java.lang.String r9 = r5.zzb     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9.equals(r4)     // Catch:{ all -> 0x0a5c }
            if (r9 != 0) goto L_0x0836
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = "00000000-0000-0000-0000-000000000000"
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0a5c }
            if (r8 != 0) goto L_0x0836
            com.google.android.gms.measurement.internal.zzal r8 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzg r8 = r8.zze(r9)     // Catch:{ all -> 0x0a5c }
            if (r8 == 0) goto L_0x0836
            boolean r9 = r8.zzau()     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x0836
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0a5c }
            r10 = 0
            r11 = 0
            r1.zza((java.lang.String) r9, (boolean) r11, (java.lang.Long) r10, (java.lang.Long) r10)     // Catch:{ all -> 0x0a5c }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0a5c }
            r9.<init>()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzag r10 = r36.zze()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbf.zzcs     // Catch:{ all -> 0x0a5c }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r11)     // Catch:{ all -> 0x0a5c }
            java.lang.String r11 = "_pfo"
            if (r10 == 0) goto L_0x0806
            java.lang.Long r10 = r8.zzy()     // Catch:{ all -> 0x0a5c }
            r12 = r7
            if (r10 == 0) goto L_0x07f6
            long r6 = r10.longValue()     // Catch:{ all -> 0x0a5c }
            long r6 = java.lang.Math.max(r13, r6)     // Catch:{ all -> 0x0a5c }
            r9.putLong(r11, r6)     // Catch:{ all -> 0x0a5c }
        L_0x07f6:
            java.lang.Long r6 = r8.zzz()     // Catch:{ all -> 0x0a5c }
            if (r6 == 0) goto L_0x0827
            java.lang.String r7 = "_uwa"
            long r10 = r6.longValue()     // Catch:{ all -> 0x0a5c }
            r9.putLong(r7, r10)     // Catch:{ all -> 0x0a5c }
            goto L_0x0827
        L_0x0806:
            r12 = r7
            com.google.android.gms.measurement.internal.zzag r6 = r36.zze()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzcr     // Catch:{ all -> 0x0a5c }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ all -> 0x0a5c }
            if (r6 == 0) goto L_0x0827
            com.google.android.gms.measurement.internal.zzal r6 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a5c }
            long r6 = r6.zzb(r7)     // Catch:{ all -> 0x0a5c }
            r15 = 1
            long r6 = r6 - r15
            long r6 = java.lang.Math.max(r13, r6)     // Catch:{ all -> 0x0a5c }
            r9.putLong(r11, r6)     // Catch:{ all -> 0x0a5c }
        L_0x0827:
            r6 = r30
            r7 = 1
            r9.putLong(r6, r7)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznr r7 = r1.zzah     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a5c }
            r7.zza(r8, r4, r9)     // Catch:{ all -> 0x0a5c }
            goto L_0x0839
        L_0x0836:
            r12 = r7
            r6 = r30
        L_0x0839:
            com.google.android.gms.measurement.internal.zzhj r4 = r1.zzm     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzax r4 = r4.zzg()     // Catch:{ all -> 0x0a5c }
            r4.zzac()     // Catch:{ all -> 0x0a5c }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r4 = r2.zzi((java.lang.String) r4)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r7 = r1.zzm     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzax r7 = r7.zzg()     // Catch:{ all -> 0x0a5c }
            r7.zzac()     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r4 = r4.zzo(r7)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r7 = r1.zzm     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzax r7 = r7.zzg()     // Catch:{ all -> 0x0a5c }
            long r7 = r7.zzg()     // Catch:{ all -> 0x0a5c }
            int r7 = (int) r7     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r4 = r4.zzj((int) r7)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r7 = r1.zzm     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzax r7 = r7.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r7.zzh()     // Catch:{ all -> 0x0a5c }
            r4.zzs(r7)     // Catch:{ all -> 0x0a5c }
            long r7 = r3.zzx     // Catch:{ all -> 0x0a5c }
            r2.zzj((long) r7)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r4 = r1.zzm     // Catch:{ all -> 0x0a5c }
            boolean r4 = r4.zzac()     // Catch:{ all -> 0x0a5c }
            if (r4 == 0) goto L_0x088d
            r2.zzt()     // Catch:{ all -> 0x0a5c }
            r4 = 0
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x088d
            r2.zzj((java.lang.String) r4)     // Catch:{ all -> 0x0a5c }
        L_0x088d:
            com.google.android.gms.measurement.internal.zzal r4 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zze(r7)     // Catch:{ all -> 0x0a5c }
            if (r4 != 0) goto L_0x08fb
            com.google.android.gms.measurement.internal.zzg r4 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzhj r7 = r1.zzm     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a5c }
            r4.<init>(r7, r8)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r1.zza((com.google.android.gms.measurement.internal.zzin) r12)     // Catch:{ all -> 0x0a5c }
            r4.zzb((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zzk     // Catch:{ all -> 0x0a5c }
            r4.zze((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x0a5c }
            r4.zzf((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
            boolean r7 = r12.zzi()     // Catch:{ all -> 0x0a5c }
            if (r7 == 0) goto L_0x08c6
            com.google.android.gms.measurement.internal.zzmc r7 = r1.zzj     // Catch:{ all -> 0x0a5c }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a5c }
            boolean r9 = r3.zzn     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r7.zza((java.lang.String) r8, (boolean) r9)     // Catch:{ all -> 0x0a5c }
            r4.zzh((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
        L_0x08c6:
            r4.zzq(r13)     // Catch:{ all -> 0x0a5c }
            r4.zzr(r13)     // Catch:{ all -> 0x0a5c }
            r4.zzp(r13)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x0a5c }
            r4.zzd((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
            long r7 = r3.zzj     // Catch:{ all -> 0x0a5c }
            r4.zzb((long) r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x0a5c }
            r4.zzc((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
            long r7 = r3.zze     // Catch:{ all -> 0x0a5c }
            r4.zzn(r7)     // Catch:{ all -> 0x0a5c }
            long r7 = r3.zzf     // Catch:{ all -> 0x0a5c }
            r4.zzk((long) r7)     // Catch:{ all -> 0x0a5c }
            boolean r7 = r3.zzh     // Catch:{ all -> 0x0a5c }
            r4.zzb((boolean) r7)     // Catch:{ all -> 0x0a5c }
            long r7 = r3.zzr     // Catch:{ all -> 0x0a5c }
            r4.zzl(r7)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r7 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            r8 = 0
            r7.zza((com.google.android.gms.measurement.internal.zzg) r4, (boolean) r8, (boolean) r8)     // Catch:{ all -> 0x0a5c }
            goto L_0x08fc
        L_0x08fb:
            r8 = 0
        L_0x08fc:
            boolean r7 = r12.zzj()     // Catch:{ all -> 0x0a5c }
            if (r7 == 0) goto L_0x0919
            java.lang.String r7 = r4.zzad()     // Catch:{ all -> 0x0a5c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x0919
            java.lang.String r7 = r4.zzad()     // Catch:{ all -> 0x0a5c }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0a5c }
            r2.zzc((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
        L_0x0919:
            java.lang.String r7 = r4.zzag()     // Catch:{ all -> 0x0a5c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0a5c }
            if (r7 != 0) goto L_0x0930
            java.lang.String r7 = r4.zzag()     // Catch:{ all -> 0x0a5c }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0a5c }
            r2.zzl((java.lang.String) r7)     // Catch:{ all -> 0x0a5c }
        L_0x0930:
            com.google.android.gms.measurement.internal.zzal r7 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0a5c }
            java.util.List r7 = r7.zzk(r9)     // Catch:{ all -> 0x0a5c }
            r12 = r8
        L_0x093b:
            int r9 = r7.size()     // Catch:{ all -> 0x0a5c }
            if (r12 >= r9) goto L_0x099f
            com.google.android.gms.internal.measurement.zzfn$zzo$zza r9 = com.google.android.gms.internal.measurement.zzfn.zzo.zze()     // Catch:{ all -> 0x0a5c }
            java.lang.Object r10 = r7.get(r12)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznq r10 = (com.google.android.gms.measurement.internal.zznq) r10     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzfn$zzo$zza r9 = r9.zza((java.lang.String) r10)     // Catch:{ all -> 0x0a5c }
            java.lang.Object r10 = r7.get(r12)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznq r10 = (com.google.android.gms.measurement.internal.zznq) r10     // Catch:{ all -> 0x0a5c }
            long r10 = r10.zzd     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.internal.measurement.zzfn$zzo$zza r9 = r9.zzb((long) r10)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznl r10 = r36.zzp()     // Catch:{ all -> 0x0a5c }
            java.lang.Object r11 = r7.get(r12)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznq r11 = (com.google.android.gms.measurement.internal.zznq) r11     // Catch:{ all -> 0x0a5c }
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0a5c }
            r10.zza((com.google.android.gms.internal.measurement.zzfn.zzo.zza) r9, (java.lang.Object) r11)     // Catch:{ all -> 0x0a5c }
            r2.zza((com.google.android.gms.internal.measurement.zzfn.zzo.zza) r9)     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = "_sid"
            java.lang.Object r10 = r7.get(r12)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zznq r10 = (com.google.android.gms.measurement.internal.zznq) r10     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x0a5c }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x099c
            long r9 = r4.zzv()     // Catch:{ all -> 0x0a5c }
            int r9 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x099c
            com.google.android.gms.measurement.internal.zznl r9 = r36.zzp()     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = r3.zzv     // Catch:{ all -> 0x0a5c }
            long r9 = r9.zza((java.lang.String) r10)     // Catch:{ all -> 0x0a5c }
            long r15 = r4.zzv()     // Catch:{ all -> 0x0a5c }
            int r9 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r9 == 0) goto L_0x099c
            r2.zzr()     // Catch:{ all -> 0x0a5c }
        L_0x099c:
            int r12 = r12 + 1
            goto L_0x093b
        L_0x099f:
            com.google.android.gms.measurement.internal.zzal r3 = r36.zzf()     // Catch:{ IOException -> 0x0a14 }
            com.google.android.gms.internal.measurement.zzkt r4 = r2.zzai()     // Catch:{ IOException -> 0x0a14 }
            com.google.android.gms.internal.measurement.zzjk r4 = (com.google.android.gms.internal.measurement.zzjk) r4     // Catch:{ IOException -> 0x0a14 }
            com.google.android.gms.internal.measurement.zzfn$zzk r4 = (com.google.android.gms.internal.measurement.zzfn.zzk) r4     // Catch:{ IOException -> 0x0a14 }
            long r2 = r3.zza((com.google.android.gms.internal.measurement.zzfn.zzk) r4)     // Catch:{ IOException -> 0x0a14 }
            com.google.android.gms.measurement.internal.zzal r4 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzbc r7 = r5.zze     // Catch:{ all -> 0x0a5c }
            if (r7 == 0) goto L_0x0a0b
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0a5c }
        L_0x09bb:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x09cf
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0a5c }
            boolean r9 = r6.equals(r9)     // Catch:{ all -> 0x0a5c }
            if (r9 == 0) goto L_0x09bb
        L_0x09cd:
            r8 = 1
            goto L_0x0a0b
        L_0x09cf:
            com.google.android.gms.measurement.internal.zzgt r6 = r36.zzi()     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a5c }
            java.lang.String r9 = r5.zzb     // Catch:{ all -> 0x0a5c }
            boolean r6 = r6.zzc((java.lang.String) r7, (java.lang.String) r9)     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r26 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            long r27 = r36.zzx()     // Catch:{ all -> 0x0a5c }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a5c }
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r29 = r7
            com.google.android.gms.measurement.internal.zzaq r7 = r26.zza(r27, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ all -> 0x0a5c }
            if (r6 == 0) goto L_0x0a0b
            long r6 = r7.zze     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzag r9 = r36.zze()     // Catch:{ all -> 0x0a5c }
            java.lang.String r10 = r5.zza     // Catch:{ all -> 0x0a5c }
            int r9 = r9.zzc(r10)     // Catch:{ all -> 0x0a5c }
            long r9 = (long) r9     // Catch:{ all -> 0x0a5c }
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x0a0b
            goto L_0x09cd
        L_0x0a0b:
            boolean r2 = r4.zza((com.google.android.gms.measurement.internal.zzba) r5, (long) r2, (boolean) r8)     // Catch:{ all -> 0x0a5c }
            if (r2 == 0) goto L_0x0a2b
            r1.zzp = r13     // Catch:{ all -> 0x0a5c }
            goto L_0x0a2b
        L_0x0a14:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfw r4 = r36.zzj()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzg()     // Catch:{ all -> 0x0a5c }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzt()     // Catch:{ all -> 0x0a5c }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r2)     // Catch:{ all -> 0x0a5c }
            r4.zza(r5, r2, r3)     // Catch:{ all -> 0x0a5c }
        L_0x0a2b:
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()     // Catch:{ all -> 0x0a5c }
            r2.zzw()     // Catch:{ all -> 0x0a5c }
            com.google.android.gms.measurement.internal.zzal r2 = r36.zzf()
            r2.zzu()
            r36.zzab()
            com.google.android.gms.measurement.internal.zzfw r2 = r36.zzj()
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzp()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r24
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x0a5c:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzal r3 = r36.zzf()
            r3.zzu()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zzc(com.google.android.gms.measurement.internal.zzbd, com.google.android.gms.measurement.internal.zzo):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ab, code lost:
        if ((zze().zzc(r6, com.google.android.gms.measurement.internal.zzbf.zzau) + r0.zzb) < zzb().elapsedRealtime()) goto L_0x00ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r6, com.google.android.gms.internal.measurement.zzfn.zzk.zza r7) {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzi()
            java.util.Set r0 = r0.zzg(r6)
            if (r0 == 0) goto L_0x000d
            r7.zzd((java.lang.Iterable<java.lang.String>) r0)
        L_0x000d:
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzi()
            boolean r0 = r0.zzq(r6)
            if (r0 == 0) goto L_0x001a
            r7.zzj()
        L_0x001a:
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzi()
            boolean r0 = r0.zzt(r6)
            r1 = -1
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r7.zzy()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x003f
            java.lang.String r2 = "."
            int r2 = r0.indexOf(r2)
            if (r2 == r1) goto L_0x003f
            r3 = 0
            java.lang.String r0 = r0.substring(r3, r2)
            r7.zzo(r0)
        L_0x003f:
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzi()
            boolean r0 = r0.zzu(r6)
            if (r0 == 0) goto L_0x0054
            java.lang.String r0 = "_id"
            int r0 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r7, (java.lang.String) r0)
            if (r0 == r1) goto L_0x0054
            r7.zzc((int) r0)
        L_0x0054:
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzi()
            boolean r0 = r0.zzs(r6)
            if (r0 == 0) goto L_0x0061
            r7.zzk()
        L_0x0061:
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzi()
            boolean r0 = r0.zzp(r6)
            if (r0 == 0) goto L_0x00bd
            r7.zzh()
            boolean r0 = com.google.android.gms.internal.measurement.zznk.zza()
            if (r0 == 0) goto L_0x008a
            com.google.android.gms.measurement.internal.zzag r0 = r5.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzbf.zzcv
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x008a
            com.google.android.gms.measurement.internal.zzin r0 = r5.zzb((java.lang.String) r6)
            boolean r0 = r0.zzj()
            if (r0 == 0) goto L_0x00bd
        L_0x008a:
            java.util.Map<java.lang.String, com.google.android.gms.measurement.internal.zznc$zzb> r0 = r5.zzae
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.measurement.internal.zznc$zzb r0 = (com.google.android.gms.measurement.internal.zznc.zzb) r0
            if (r0 == 0) goto L_0x00ad
            long r1 = r0.zzb
            com.google.android.gms.measurement.internal.zzag r3 = r5.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Long> r4 = com.google.android.gms.measurement.internal.zzbf.zzau
            long r3 = r3.zzc((java.lang.String) r6, (com.google.android.gms.measurement.internal.zzfj<java.lang.Long>) r4)
            long r3 = r3 + r1
            com.google.android.gms.common.util.Clock r1 = r5.zzb()
            long r1 = r1.elapsedRealtime()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b8
        L_0x00ad:
            com.google.android.gms.measurement.internal.zznc$zzb r0 = new com.google.android.gms.measurement.internal.zznc$zzb
            r1 = 0
            r0.<init>()
            java.util.Map<java.lang.String, com.google.android.gms.measurement.internal.zznc$zzb> r1 = r5.zzae
            r1.put(r6, r0)
        L_0x00b8:
            java.lang.String r0 = r0.zza
            r7.zzk((java.lang.String) r0)
        L_0x00bd:
            com.google.android.gms.measurement.internal.zzgt r0 = r5.zzi()
            boolean r6 = r0.zzr(r6)
            if (r6 == 0) goto L_0x00ca
            r7.zzr()
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zza(java.lang.String, com.google.android.gms.internal.measurement.zzfn$zzk$zza):void");
    }

    public final void zza(zzg zzg2, zzfn.zzk.zza zza2) {
        zzfn.zzo zzo2;
        zzl().zzt();
        zzs();
        zzah zza3 = zzah.zza(zza2.zzv());
        if (!zzne.zza() || !zze().zza(zzbf.zzcp)) {
            String zzac2 = zzg2.zzac();
            zzl().zzt();
            zzs();
            zzin zzb2 = zzb(zzac2);
            if (zzb2.zze() != null) {
                zza3.zza(zzin.zza.AD_STORAGE, zzb2.zza());
            } else {
                zza3.zza(zzin.zza.AD_STORAGE, zzak.FAILSAFE);
            }
            if (zzb2.zzf() != null) {
                zza3.zza(zzin.zza.ANALYTICS_STORAGE, zzb2.zza());
            } else {
                zza3.zza(zzin.zza.ANALYTICS_STORAGE, zzak.FAILSAFE);
            }
        } else {
            String zzac3 = zzg2.zzac();
            zzl().zzt();
            zzs();
            zzin zzb3 = zzb(zzac3);
            int[] iArr = zznh.zza;
            int i = iArr[zzb3.zzc().ordinal()];
            if (i == 1) {
                zza3.zza(zzin.zza.AD_STORAGE, zzak.REMOTE_ENFORCED_DEFAULT);
            } else if (i == 2 || i == 3) {
                zza3.zza(zzin.zza.AD_STORAGE, zzb3.zza());
            } else {
                zza3.zza(zzin.zza.AD_STORAGE, zzak.FAILSAFE);
            }
            int i2 = iArr[zzb3.zzd().ordinal()];
            if (i2 == 1) {
                zza3.zza(zzin.zza.ANALYTICS_STORAGE, zzak.REMOTE_ENFORCED_DEFAULT);
            } else if (i2 == 2 || i2 == 3) {
                zza3.zza(zzin.zza.ANALYTICS_STORAGE, zzb3.zza());
            } else {
                zza3.zza(zzin.zza.ANALYTICS_STORAGE, zzak.FAILSAFE);
            }
        }
        String zzac4 = zzg2.zzac();
        zzl().zzt();
        zzs();
        zzav zza4 = zza(zzac4, zzd(zzac4), zzb(zzac4), zza3);
        zza2.zzb(((Boolean) Preconditions.checkNotNull(zza4.zzd())).booleanValue());
        if (!TextUtils.isEmpty(zza4.zze())) {
            zza2.zzh(zza4.zze());
        }
        zzl().zzt();
        zzs();
        Iterator<zzfn.zzo> it = zza2.zzab().iterator();
        while (true) {
            if (!it.hasNext()) {
                zzo2 = null;
                break;
            }
            zzo2 = it.next();
            if ("_npa".equals(zzo2.zzg())) {
                break;
            }
        }
        if (zzo2 != null) {
            zzin.zza zza5 = zzin.zza.AD_PERSONALIZATION;
            if (zza3.zza(zza5) == zzak.UNSET) {
                zznq zze2 = zzf().zze(zzg2.zzac(), "_npa");
                if (zze2 == null) {
                    Boolean zzx2 = zzg2.zzx();
                    if (zzx2 == null || ((zzx2 == Boolean.TRUE && zzo2.zzc() != 1) || (zzx2 == Boolean.FALSE && zzo2.zzc() != 0))) {
                        zza3.zza(zza5, zzak.API);
                    } else {
                        zza3.zza(zza5, zzak.MANIFEST);
                    }
                } else if ("tcf".equals(zze2.zzb)) {
                    zza3.zza(zza5, zzak.TCF);
                } else if ("app".equals(zze2.zzb)) {
                    zza3.zza(zza5, zzak.API);
                } else {
                    zza3.zza(zza5, zzak.MANIFEST);
                }
            }
        } else {
            int zza6 = zza(zzg2.zzac(), zza3);
            zza2.zza((zzfn.zzo) ((zzjk) zzfn.zzo.zze().zza("_npa").zzb(zzb().currentTimeMillis()).zza((long) zza6).zzai()));
            zzj().zzp().zza("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zza6));
        }
        zza2.zzf(zza3.toString());
        boolean zzn2 = this.zzb.zzn(zzg2.zzac());
        List<zzfn.zzf> zzaa2 = zza2.zzaa();
        int i3 = 0;
        for (int i4 = 0; i4 < zzaa2.size(); i4++) {
            if ("_tcf".equals(zzaa2.get(i4).zzg())) {
                zzfn.zzf.zza zza7 = (zzfn.zzf.zza) zzaa2.get(i4).zzcc();
                List<zzfn.zzh> zzf2 = zza7.zzf();
                while (true) {
                    if (i3 >= zzf2.size()) {
                        break;
                    } else if ("_tcfd".equals(zzf2.get(i3).zzg())) {
                        zza7.zza(i3, zzfn.zzh.zze().zza("_tcfd").zzb(zzms.zza(zzf2.get(i3).zzh(), zzn2)));
                        break;
                    } else {
                        i3++;
                    }
                }
                zza2.zza(i4, zza7);
                return;
            }
        }
    }

    private static void zza(zzfn.zzf.zza zza2, int i, String str) {
        List<zzfn.zzh> zzf2 = zza2.zzf();
        int i2 = 0;
        while (i2 < zzf2.size()) {
            if (!"_err".equals(zzf2.get(i2).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzfn.zzh) ((zzjk) zzfn.zzh.zze().zza("_err").zza(Long.valueOf((long) i).longValue()).zzai())).zza((zzfn.zzh) ((zzjk) zzfn.zzh.zze().zza("_ev").zzb(str).zzai()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002b, code lost:
        r4 = r1.zzag;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzbd r20, com.google.android.gms.measurement.internal.zzo r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r21)
            java.lang.String r2 = r0.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)
            com.google.android.gms.measurement.internal.zzhc r2 = r19.zzl()
            r2.zzt()
            r19.zzs()
            java.lang.String r2 = r0.zza
            r3 = r20
            long r10 = r3.zzd
            com.google.android.gms.measurement.internal.zzga r3 = com.google.android.gms.measurement.internal.zzga.zza(r20)
            com.google.android.gms.measurement.internal.zzhc r4 = r19.zzl()
            r4.zzt()
            com.google.android.gms.measurement.internal.zzkp r4 = r1.zzaf
            if (r4 == 0) goto L_0x0039
            java.lang.String r4 = r1.zzag
            if (r4 == 0) goto L_0x0039
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            com.google.android.gms.measurement.internal.zzkp r4 = r1.zzaf
            goto L_0x003a
        L_0x0039:
            r4 = 0
        L_0x003a:
            android.os.Bundle r5 = r3.zzb
            r12 = 0
            com.google.android.gms.measurement.internal.zznp.zza((com.google.android.gms.measurement.internal.zzkp) r4, (android.os.Bundle) r5, (boolean) r12)
            com.google.android.gms.measurement.internal.zzbd r3 = r3.zza()
            r19.zzp()
            boolean r4 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.measurement.internal.zzbd) r3, (com.google.android.gms.measurement.internal.zzo) r0)
            if (r4 != 0) goto L_0x004e
            return
        L_0x004e:
            boolean r4 = r0.zzh
            if (r4 != 0) goto L_0x0056
            r1.zza((com.google.android.gms.measurement.internal.zzo) r0)
            return
        L_0x0056:
            java.util.List<java.lang.String> r4 = r0.zzs
            if (r4 == 0) goto L_0x0097
            java.lang.String r5 = r3.zza
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0085
            com.google.android.gms.measurement.internal.zzbc r4 = r3.zzb
            android.os.Bundle r4 = r4.zzb()
            java.lang.String r5 = "ga_safelisted"
            r6 = 1
            r4.putLong(r5, r6)
            com.google.android.gms.measurement.internal.zzbd r5 = new com.google.android.gms.measurement.internal.zzbd
            java.lang.String r14 = r3.zza
            com.google.android.gms.measurement.internal.zzbc r15 = new com.google.android.gms.measurement.internal.zzbc
            r15.<init>(r4)
            java.lang.String r4 = r3.zzc
            long r6 = r3.zzd
            r13 = r5
            r16 = r4
            r17 = r6
            r13.<init>(r14, r15, r16, r17)
            goto L_0x0098
        L_0x0085:
            com.google.android.gms.measurement.internal.zzfw r0 = r19.zzj()
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzc()
            java.lang.String r4 = r3.zza
            java.lang.String r3 = r3.zzc
            java.lang.String r5 = "Dropping non-safelisted event. appId, event name, origin"
            r0.zza(r5, r2, r4, r3)
            return
        L_0x0097:
            r13 = r3
        L_0x0098:
            com.google.android.gms.measurement.internal.zzal r3 = r19.zzf()
            r3.zzp()
            com.google.android.gms.measurement.internal.zzal r3 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x02f2 }
            r3.zzt()     // Catch:{ all -> 0x02f2 }
            r3.zzal()     // Catch:{ all -> 0x02f2 }
            r4 = 0
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r5 = 2
            r14 = 1
            if (r4 >= 0) goto L_0x00ce
            com.google.android.gms.measurement.internal.zzfw r3 = r3.zzj()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzu()     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = "Invalid time querying timed out conditional properties"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r2)     // Catch:{ all -> 0x02f2 }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x02f2 }
            r3.zza(r6, r7, r8)     // Catch:{ all -> 0x02f2 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x02f2 }
            goto L_0x00de
        L_0x00ce:
            java.lang.String r6 = "active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout"
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ all -> 0x02f2 }
            r7[r12] = r2     // Catch:{ all -> 0x02f2 }
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x02f2 }
            r7[r14] = r8     // Catch:{ all -> 0x02f2 }
            java.util.List r3 = r3.zza((java.lang.String) r6, (java.lang.String[]) r7)     // Catch:{ all -> 0x02f2 }
        L_0x00de:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x02f2 }
        L_0x00e2:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x02f2 }
            if (r6 == 0) goto L_0x012e
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzae r6 = (com.google.android.gms.measurement.internal.zzae) r6     // Catch:{ all -> 0x02f2 }
            if (r6 == 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzfw r7 = r19.zzj()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzp()     // Catch:{ all -> 0x02f2 }
            java.lang.String r8 = "User property timed out"
            java.lang.String r9 = r6.zza     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzhj r15 = r1.zzm     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfr r15 = r15.zzk()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzno r14 = r6.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.String r14 = r14.zza     // Catch:{ all -> 0x02f2 }
            java.lang.String r14 = r15.zzc(r14)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzno r15 = r6.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x02f2 }
            r7.zza(r8, r9, r14, r15)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzbd r7 = r6.zzg     // Catch:{ all -> 0x02f2 }
            if (r7 == 0) goto L_0x0121
            com.google.android.gms.measurement.internal.zzbd r7 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzbd r8 = r6.zzg     // Catch:{ all -> 0x02f2 }
            r7.<init>(r8, r10)     // Catch:{ all -> 0x02f2 }
            r1.zzc(r7, r0)     // Catch:{ all -> 0x02f2 }
        L_0x0121:
            com.google.android.gms.measurement.internal.zzal r7 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzno r6 = r6.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = r6.zza     // Catch:{ all -> 0x02f2 }
            r7.zza((java.lang.String) r2, (java.lang.String) r6)     // Catch:{ all -> 0x02f2 }
            r14 = 1
            goto L_0x00e2
        L_0x012e:
            com.google.android.gms.measurement.internal.zzal r3 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x02f2 }
            r3.zzt()     // Catch:{ all -> 0x02f2 }
            r3.zzal()     // Catch:{ all -> 0x02f2 }
            if (r4 >= 0) goto L_0x0157
            com.google.android.gms.measurement.internal.zzfw r3 = r3.zzj()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzu()     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = "Invalid time querying expired conditional properties"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r2)     // Catch:{ all -> 0x02f2 }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x02f2 }
            r3.zza(r6, r7, r8)     // Catch:{ all -> 0x02f2 }
            java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x02f2 }
            goto L_0x0168
        L_0x0157:
            java.lang.String r6 = "active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live"
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ all -> 0x02f2 }
            r7[r12] = r2     // Catch:{ all -> 0x02f2 }
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x02f2 }
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x02f2 }
            java.util.List r3 = r3.zza((java.lang.String) r6, (java.lang.String[]) r7)     // Catch:{ all -> 0x02f2 }
        L_0x0168:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x02f2 }
            int r7 = r3.size()     // Catch:{ all -> 0x02f2 }
            r6.<init>(r7)     // Catch:{ all -> 0x02f2 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x02f2 }
        L_0x0175:
            boolean r7 = r3.hasNext()     // Catch:{ all -> 0x02f2 }
            if (r7 == 0) goto L_0x01c5
            java.lang.Object r7 = r3.next()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzae r7 = (com.google.android.gms.measurement.internal.zzae) r7     // Catch:{ all -> 0x02f2 }
            if (r7 == 0) goto L_0x0175
            com.google.android.gms.measurement.internal.zzfw r8 = r19.zzj()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzp()     // Catch:{ all -> 0x02f2 }
            java.lang.String r9 = "User property expired"
            java.lang.String r14 = r7.zza     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzhj r15 = r1.zzm     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfr r15 = r15.zzk()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzno r5 = r7.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x02f2 }
            java.lang.String r5 = r15.zzc(r5)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzno r15 = r7.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.Object r15 = r15.zza()     // Catch:{ all -> 0x02f2 }
            r8.zza(r9, r14, r5, r15)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzal r5 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzno r8 = r7.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.String r8 = r8.zza     // Catch:{ all -> 0x02f2 }
            r5.zzh(r2, r8)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzbd r5 = r7.zzk     // Catch:{ all -> 0x02f2 }
            if (r5 == 0) goto L_0x01b8
            r6.add(r5)     // Catch:{ all -> 0x02f2 }
        L_0x01b8:
            com.google.android.gms.measurement.internal.zzal r5 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzno r7 = r7.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = r7.zza     // Catch:{ all -> 0x02f2 }
            r5.zza((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ all -> 0x02f2 }
            r5 = 2
            goto L_0x0175
        L_0x01c5:
            int r3 = r6.size()     // Catch:{ all -> 0x02f2 }
            r5 = r12
        L_0x01ca:
            if (r5 >= r3) goto L_0x01dd
            java.lang.Object r7 = r6.get(r5)     // Catch:{ all -> 0x02f2 }
            int r5 = r5 + 1
            com.google.android.gms.measurement.internal.zzbd r7 = (com.google.android.gms.measurement.internal.zzbd) r7     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzbd r8 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x02f2 }
            r8.<init>(r7, r10)     // Catch:{ all -> 0x02f2 }
            r1.zzc(r8, r0)     // Catch:{ all -> 0x02f2 }
            goto L_0x01ca
        L_0x01dd:
            com.google.android.gms.measurement.internal.zzal r3 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            java.lang.String r5 = r13.zza     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x02f2 }
            r3.zzt()     // Catch:{ all -> 0x02f2 }
            r3.zzal()     // Catch:{ all -> 0x02f2 }
            if (r4 >= 0) goto L_0x0213
            com.google.android.gms.measurement.internal.zzfw r4 = r3.zzj()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzu()     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = "Invalid time querying triggered conditional properties"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r2)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzi()     // Catch:{ all -> 0x02f2 }
            java.lang.String r3 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x02f2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x02f2 }
            r4.zza(r6, r2, r3, r5)     // Catch:{ all -> 0x02f2 }
            java.util.List r2 = java.util.Collections.emptyList()     // Catch:{ all -> 0x02f2 }
            goto L_0x0228
        L_0x0213:
            java.lang.String r4 = "active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x02f2 }
            r6[r12] = r2     // Catch:{ all -> 0x02f2 }
            r2 = 1
            r6[r2] = r5     // Catch:{ all -> 0x02f2 }
            java.lang.String r2 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x02f2 }
            r5 = 2
            r6[r5] = r2     // Catch:{ all -> 0x02f2 }
            java.util.List r2 = r3.zza((java.lang.String) r4, (java.lang.String[]) r6)     // Catch:{ all -> 0x02f2 }
        L_0x0228:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x02f2 }
            int r3 = r2.size()     // Catch:{ all -> 0x02f2 }
            r14.<init>(r3)     // Catch:{ all -> 0x02f2 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x02f2 }
        L_0x0235:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x02f2 }
            if (r3 == 0) goto L_0x02c8
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x02f2 }
            r15 = r3
            com.google.android.gms.measurement.internal.zzae r15 = (com.google.android.gms.measurement.internal.zzae) r15     // Catch:{ all -> 0x02f2 }
            if (r15 == 0) goto L_0x0235
            com.google.android.gms.measurement.internal.zzno r3 = r15.zzc     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zznq r9 = new com.google.android.gms.measurement.internal.zznq     // Catch:{ all -> 0x02f2 }
            java.lang.String r4 = r15.zza     // Catch:{ all -> 0x02f2 }
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x02f2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x02f2 }
            java.lang.String r5 = r15.zzb     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x02f2 }
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x02f2 }
            java.lang.Object r16 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x02f2 }
            r3 = r9
            r7 = r10
            r12 = r9
            r9 = r16
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzal r3 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zznq) r12)     // Catch:{ all -> 0x02f2 }
            if (r3 == 0) goto L_0x028c
            com.google.android.gms.measurement.internal.zzfw r3 = r19.zzj()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzp()     // Catch:{ all -> 0x02f2 }
            java.lang.String r4 = "User property triggered"
            java.lang.String r5 = r15.zza     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzhj r6 = r1.zzm     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzk()     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = r12.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = r6.zzc(r7)     // Catch:{ all -> 0x02f2 }
            java.lang.Object r7 = r12.zze     // Catch:{ all -> 0x02f2 }
            r3.zza(r4, r5, r6, r7)     // Catch:{ all -> 0x02f2 }
            goto L_0x02ad
        L_0x028c:
            com.google.android.gms.measurement.internal.zzfw r3 = r19.zzj()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ all -> 0x02f2 }
            java.lang.String r4 = "Too many active user properties, ignoring"
            java.lang.String r5 = r15.zza     // Catch:{ all -> 0x02f2 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r5)     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzhj r6 = r1.zzm     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzk()     // Catch:{ all -> 0x02f2 }
            java.lang.String r7 = r12.zzc     // Catch:{ all -> 0x02f2 }
            java.lang.String r6 = r6.zzc(r7)     // Catch:{ all -> 0x02f2 }
            java.lang.Object r7 = r12.zze     // Catch:{ all -> 0x02f2 }
            r3.zza(r4, r5, r6, r7)     // Catch:{ all -> 0x02f2 }
        L_0x02ad:
            com.google.android.gms.measurement.internal.zzbd r3 = r15.zzi     // Catch:{ all -> 0x02f2 }
            if (r3 == 0) goto L_0x02b4
            r14.add(r3)     // Catch:{ all -> 0x02f2 }
        L_0x02b4:
            com.google.android.gms.measurement.internal.zzno r3 = new com.google.android.gms.measurement.internal.zzno     // Catch:{ all -> 0x02f2 }
            r3.<init>(r12)     // Catch:{ all -> 0x02f2 }
            r15.zzc = r3     // Catch:{ all -> 0x02f2 }
            r3 = 1
            r15.zze = r3     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzal r4 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            r4.zza((com.google.android.gms.measurement.internal.zzae) r15)     // Catch:{ all -> 0x02f2 }
            r12 = 0
            goto L_0x0235
        L_0x02c8:
            r1.zzc(r13, r0)     // Catch:{ all -> 0x02f2 }
            int r2 = r14.size()     // Catch:{ all -> 0x02f2 }
            r12 = 0
        L_0x02d0:
            if (r12 >= r2) goto L_0x02e3
            java.lang.Object r3 = r14.get(r12)     // Catch:{ all -> 0x02f2 }
            int r12 = r12 + 1
            com.google.android.gms.measurement.internal.zzbd r3 = (com.google.android.gms.measurement.internal.zzbd) r3     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzbd r4 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x02f2 }
            r4.<init>(r3, r10)     // Catch:{ all -> 0x02f2 }
            r1.zzc(r4, r0)     // Catch:{ all -> 0x02f2 }
            goto L_0x02d0
        L_0x02e3:
            com.google.android.gms.measurement.internal.zzal r0 = r19.zzf()     // Catch:{ all -> 0x02f2 }
            r0.zzw()     // Catch:{ all -> 0x02f2 }
            com.google.android.gms.measurement.internal.zzal r0 = r19.zzf()
            r0.zzu()
            return
        L_0x02f2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r2 = r19.zzf()
            r2.zzu()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zza(com.google.android.gms.measurement.internal.zzbd, com.google.android.gms.measurement.internal.zzo):void");
    }

    public final void zza(zzbd zzbd, String str) {
        zzbd zzbd2 = zzbd;
        String str2 = str;
        zzg zze2 = zzf().zze(str2);
        if (zze2 == null || TextUtils.isEmpty(zze2.zzaf())) {
            zzj().zzc().zza("No app data available; dropping event", str2);
            return;
        }
        Boolean zza2 = zza(zze2);
        if (zza2 == null) {
            if (!"_ui".equals(zzbd2.zza)) {
                zzj().zzu().zza("Could not find package. appId", zzfw.zza(str));
            }
        } else if (!zza2.booleanValue()) {
            zzj().zzg().zza("App version does not match; dropping event. appId", zzfw.zza(str));
            return;
        }
        zzo zzo2 = r2;
        zzg zzg2 = zze2;
        zzo zzo3 = new zzo(str, zze2.zzah(), zze2.zzaf(), zze2.zze(), zze2.zzae(), zze2.zzq(), zze2.zzn(), (String) null, zze2.zzar(), false, zzg2.zzag(), zzg2.zzd(), 0, 0, zzg2.zzaq(), false, zzg2.zzaa(), zzg2.zzx(), zzg2.zzo(), zzg2.zzan(), (String) null, zzb(str2).zzh(), "", (String) null, zzg2.zzat(), zzg2.zzw(), zzb(str2).zza(), zzd(str2).zzf(), zzg2.zza(), zzg2.zzf(), zzg2.zzam(), zzg2.zzak());
        zzb(zzbd2, zzo2);
    }

    private final void zza(zzfn.zzk.zza zza2, long j, boolean z) {
        zznq zznq;
        boolean z2;
        String str = z ? "_se" : "_lte";
        zznq zze2 = zzf().zze(zza2.zzt(), str);
        if (zze2 == null || zze2.zze == null) {
            zznq = new zznq(zza2.zzt(), "auto", str, zzb().currentTimeMillis(), Long.valueOf(j));
        } else {
            zznq = new zznq(zza2.zzt(), "auto", str, zzb().currentTimeMillis(), Long.valueOf(((Long) zze2.zze).longValue() + j));
        }
        zzfn.zzo zzo2 = (zzfn.zzo) ((zzjk) zzfn.zzo.zze().zza(str).zzb(zzb().currentTimeMillis()).zza(((Long) zznq.zze).longValue()).zzai());
        int zza3 = zznl.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzo2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            zza2.zza(zzo2);
        }
        if (j > 0) {
            zzf().zza(zznq);
            zzj().zzp().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zznq.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0144 A[Catch:{ all -> 0x0193, all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0152 A[Catch:{ all -> 0x0193, all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0178 A[Catch:{ all -> 0x0193, all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x017c A[Catch:{ all -> 0x0193, all -> 0x019c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzhc r0 = r6.zzl()
            r0.zzt()
            r6.zzs()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0012
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x019c }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzfw r1 = r6.zzj()     // Catch:{ all -> 0x019c }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzp()     // Catch:{ all -> 0x019c }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x019c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x019c }
            r1.zza(r2, r3)     // Catch:{ all -> 0x019c }
            com.google.android.gms.measurement.internal.zzal r1 = r6.zzf()     // Catch:{ all -> 0x019c }
            r1.zzp()     // Catch:{ all -> 0x019c }
            com.google.android.gms.measurement.internal.zzal r1 = r6.zzf()     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zze(r7)     // Catch:{ all -> 0x0193 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x0040
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x0040
            if (r8 != r3) goto L_0x0044
        L_0x0040:
            if (r9 != 0) goto L_0x0044
            r2 = r4
            goto L_0x0045
        L_0x0044:
            r2 = r0
        L_0x0045:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfw r8 = r6.zzj()     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzu()     // Catch:{ all -> 0x0193 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r7)     // Catch:{ all -> 0x0193 }
            r8.zza(r9, r7)     // Catch:{ all -> 0x0193 }
            goto L_0x017f
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ba
            if (r8 != r5) goto L_0x0061
            goto L_0x00ba
        L_0x0061:
            com.google.android.gms.common.util.Clock r10 = r6.zzb()     // Catch:{ all -> 0x0193 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0193 }
            r1.zzm(r10)     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzal r10 = r6.zzf()     // Catch:{ all -> 0x0193 }
            r10.zza((com.google.android.gms.measurement.internal.zzg) r1, (boolean) r0, (boolean) r0)     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfw r10 = r6.zzj()     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfy r10 = r10.zzp()     // Catch:{ all -> 0x0193 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0193 }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzgt r9 = r6.zzi()     // Catch:{ all -> 0x0193 }
            r9.zzi(r7)     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzmc r7 = r6.zzj     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzgm r7 = r7.zzd     // Catch:{ all -> 0x0193 }
            com.google.android.gms.common.util.Clock r9 = r6.zzb()     // Catch:{ all -> 0x0193 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0193 }
            r7.zza(r9)     // Catch:{ all -> 0x0193 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00a4
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r4 = r0
        L_0x00a4:
            if (r4 == 0) goto L_0x00b5
            com.google.android.gms.measurement.internal.zzmc r7 = r6.zzj     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzgm r7 = r7.zzb     // Catch:{ all -> 0x0193 }
            com.google.android.gms.common.util.Clock r8 = r6.zzb()     // Catch:{ all -> 0x0193 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0193 }
            r7.zza(r8)     // Catch:{ all -> 0x0193 }
        L_0x00b5:
            r6.zzab()     // Catch:{ all -> 0x0193 }
            goto L_0x017f
        L_0x00ba:
            r9 = 0
            if (r11 == 0) goto L_0x00c6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r2 = r11.get(r2)     // Catch:{ all -> 0x0193 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0193 }
            goto L_0x00c7
        L_0x00c6:
            r2 = r9
        L_0x00c7:
            if (r2 == 0) goto L_0x00d6
            boolean r4 = r2.isEmpty()     // Catch:{ all -> 0x0193 }
            if (r4 != 0) goto L_0x00d6
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0193 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0193 }
            goto L_0x00d7
        L_0x00d6:
            r2 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e2
            java.lang.String r4 = "ETag"
            java.lang.Object r11 = r11.get(r4)     // Catch:{ all -> 0x0193 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0193 }
            goto L_0x00e3
        L_0x00e2:
            r11 = r9
        L_0x00e3:
            if (r11 == 0) goto L_0x00f2
            boolean r4 = r11.isEmpty()     // Catch:{ all -> 0x0193 }
            if (r4 != 0) goto L_0x00f2
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0193 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0193 }
            goto L_0x00f3
        L_0x00f2:
            r11 = r9
        L_0x00f3:
            if (r8 == r5) goto L_0x010f
            if (r8 != r3) goto L_0x00f8
            goto L_0x010f
        L_0x00f8:
            com.google.android.gms.measurement.internal.zzgt r9 = r6.zzi()     // Catch:{ all -> 0x0193 }
            boolean r9 = r9.zza(r7, r10, r2, r11)     // Catch:{ all -> 0x0193 }
            if (r9 != 0) goto L_0x0130
            com.google.android.gms.measurement.internal.zzal r7 = r6.zzf()     // Catch:{ all -> 0x019c }
            r7.zzu()     // Catch:{ all -> 0x019c }
            r6.zzu = r0
            r6.zzaa()
            return
        L_0x010f:
            com.google.android.gms.measurement.internal.zzgt r11 = r6.zzi()     // Catch:{ all -> 0x0193 }
            com.google.android.gms.internal.measurement.zzfi$zzd r11 = r11.zzc(r7)     // Catch:{ all -> 0x0193 }
            if (r11 != 0) goto L_0x0130
            com.google.android.gms.measurement.internal.zzgt r11 = r6.zzi()     // Catch:{ all -> 0x0193 }
            boolean r9 = r11.zza(r7, r9, r9, r9)     // Catch:{ all -> 0x0193 }
            if (r9 != 0) goto L_0x0130
            com.google.android.gms.measurement.internal.zzal r7 = r6.zzf()     // Catch:{ all -> 0x019c }
            r7.zzu()     // Catch:{ all -> 0x019c }
            r6.zzu = r0
            r6.zzaa()
            return
        L_0x0130:
            com.google.android.gms.common.util.Clock r9 = r6.zzb()     // Catch:{ all -> 0x0193 }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x0193 }
            r1.zzd((long) r2)     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzal r9 = r6.zzf()     // Catch:{ all -> 0x0193 }
            r9.zza((com.google.android.gms.measurement.internal.zzg) r1, (boolean) r0, (boolean) r0)     // Catch:{ all -> 0x0193 }
            if (r8 != r5) goto L_0x0152
            com.google.android.gms.measurement.internal.zzfw r8 = r6.zzj()     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzv()     // Catch:{ all -> 0x0193 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x0193 }
            goto L_0x0168
        L_0x0152:
            com.google.android.gms.measurement.internal.zzfw r7 = r6.zzj()     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzp()     // Catch:{ all -> 0x0193 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0193 }
            int r10 = r10.length     // Catch:{ all -> 0x0193 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0193 }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x0193 }
        L_0x0168:
            com.google.android.gms.measurement.internal.zzfz r7 = r6.zzh()     // Catch:{ all -> 0x0193 }
            boolean r7 = r7.zzu()     // Catch:{ all -> 0x0193 }
            if (r7 == 0) goto L_0x017c
            boolean r7 = r6.zzac()     // Catch:{ all -> 0x0193 }
            if (r7 == 0) goto L_0x017c
            r6.zzw()     // Catch:{ all -> 0x0193 }
            goto L_0x017f
        L_0x017c:
            r6.zzab()     // Catch:{ all -> 0x0193 }
        L_0x017f:
            com.google.android.gms.measurement.internal.zzal r7 = r6.zzf()     // Catch:{ all -> 0x0193 }
            r7.zzw()     // Catch:{ all -> 0x0193 }
            com.google.android.gms.measurement.internal.zzal r7 = r6.zzf()     // Catch:{ all -> 0x019c }
            r7.zzu()     // Catch:{ all -> 0x019c }
            r6.zzu = r0
            r6.zzaa()
            return
        L_0x0193:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzal r8 = r6.zzf()     // Catch:{ all -> 0x019c }
            r8.zzu()     // Catch:{ all -> 0x019c }
            throw r7     // Catch:{ all -> 0x019c }
        L_0x019c:
            r7 = move-exception
            r6.zzu = r0
            r6.zzaa()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void zza(boolean z) {
        zzab();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2 A[Catch:{ all -> 0x0140 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0131 A[Catch:{ SQLiteException -> 0x0149 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0135 A[Catch:{ SQLiteException -> 0x0149 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r9, int r10, java.lang.Throwable r11, byte[] r12, java.lang.String r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzhc r13 = r8.zzl()
            r13.zzt()
            r8.zzs()
            r13 = 0
            if (r12 != 0) goto L_0x000f
            byte[] r12 = new byte[r13]     // Catch:{ all -> 0x01c0 }
        L_0x000f:
            java.util.List<java.lang.Long> r0 = r8.zzz     // Catch:{ all -> 0x01c0 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x01c0 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x01c0 }
            r1 = 0
            r8.zzz = r1     // Catch:{ all -> 0x01c0 }
            boolean r2 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ all -> 0x01c0 }
            r3 = 1
            if (r2 == 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzag r2 = r8.zze()     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzbf.zzck     // Catch:{ all -> 0x01c0 }
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r4)     // Catch:{ all -> 0x01c0 }
            if (r2 == 0) goto L_0x002f
            if (r9 == 0) goto L_0x0039
        L_0x002f:
            r2 = 200(0xc8, float:2.8E-43)
            if (r10 == r2) goto L_0x0037
            r2 = 204(0xcc, float:2.86E-43)
            if (r10 != r2) goto L_0x0175
        L_0x0037:
            if (r11 != 0) goto L_0x0175
        L_0x0039:
            boolean r11 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ SQLiteException -> 0x0149 }
            if (r11 == 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzag r11 = r8.zze()     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzck     // Catch:{ SQLiteException -> 0x0149 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r2)     // Catch:{ SQLiteException -> 0x0149 }
            if (r11 == 0) goto L_0x004d
            if (r9 == 0) goto L_0x005c
        L_0x004d:
            com.google.android.gms.measurement.internal.zzmc r11 = r8.zzj     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.measurement.internal.zzgm r11 = r11.zzc     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.common.util.Clock r2 = r8.zzb()     // Catch:{ SQLiteException -> 0x0149 }
            long r4 = r2.currentTimeMillis()     // Catch:{ SQLiteException -> 0x0149 }
            r11.zza(r4)     // Catch:{ SQLiteException -> 0x0149 }
        L_0x005c:
            com.google.android.gms.measurement.internal.zzmc r11 = r8.zzj     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.measurement.internal.zzgm r11 = r11.zzd     // Catch:{ SQLiteException -> 0x0149 }
            r4 = 0
            r11.zza(r4)     // Catch:{ SQLiteException -> 0x0149 }
            r8.zzab()     // Catch:{ SQLiteException -> 0x0149 }
            boolean r11 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ SQLiteException -> 0x0149 }
            if (r11 == 0) goto L_0x009b
            com.google.android.gms.measurement.internal.zzag r11 = r8.zze()     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzck     // Catch:{ SQLiteException -> 0x0149 }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r2)     // Catch:{ SQLiteException -> 0x0149 }
            if (r11 == 0) goto L_0x009b
            if (r9 == 0) goto L_0x007d
            goto L_0x009b
        L_0x007d:
            boolean r9 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ SQLiteException -> 0x0149 }
            if (r9 == 0) goto L_0x00b1
            com.google.android.gms.measurement.internal.zzag r9 = r8.zze()     // Catch:{ SQLiteException -> 0x0149 }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r2)     // Catch:{ SQLiteException -> 0x0149 }
            if (r9 == 0) goto L_0x00b1
            com.google.android.gms.measurement.internal.zzfw r9 = r8.zzj()     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzp()     // Catch:{ SQLiteException -> 0x0149 }
            java.lang.String r10 = "Purged empty bundles"
            r9.zza(r10)     // Catch:{ SQLiteException -> 0x0149 }
            goto L_0x00b1
        L_0x009b:
            com.google.android.gms.measurement.internal.zzfw r9 = r8.zzj()     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzp()     // Catch:{ SQLiteException -> 0x0149 }
            java.lang.String r11 = "Successful upload. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ SQLiteException -> 0x0149 }
            int r12 = r12.length     // Catch:{ SQLiteException -> 0x0149 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ SQLiteException -> 0x0149 }
            r9.zza(r11, r10, r12)     // Catch:{ SQLiteException -> 0x0149 }
        L_0x00b1:
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ SQLiteException -> 0x0149 }
            r9.zzp()     // Catch:{ SQLiteException -> 0x0149 }
            java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x0140 }
        L_0x00bc:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0140 }
            if (r10 == 0) goto L_0x0111
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0140 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0140 }
            com.google.android.gms.measurement.internal.zzal r11 = r8.zzf()     // Catch:{ SQLiteException -> 0x0104 }
            long r6 = r10.longValue()     // Catch:{ SQLiteException -> 0x0104 }
            r11.zzt()     // Catch:{ SQLiteException -> 0x0104 }
            r11.zzal()     // Catch:{ SQLiteException -> 0x0104 }
            android.database.sqlite.SQLiteDatabase r12 = r11.e_()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String[] r0 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r2 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0104 }
            r0[r13] = r2     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r2 = "queue"
            java.lang.String r6 = "rowid=?"
            int r12 = r12.delete(r2, r6, r0)     // Catch:{ SQLiteException -> 0x00f5 }
            if (r12 != r3) goto L_0x00ed
            goto L_0x00bc
        L_0x00ed:
            android.database.sqlite.SQLiteException r12 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00f5 }
            java.lang.String r0 = "Deleted fewer rows from queue than expected"
            r12.<init>(r0)     // Catch:{ SQLiteException -> 0x00f5 }
            throw r12     // Catch:{ SQLiteException -> 0x00f5 }
        L_0x00f5:
            r12 = move-exception
            com.google.android.gms.measurement.internal.zzfw r11 = r11.zzj()     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.zzfy r11 = r11.zzg()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r0 = "Failed to delete a bundle in a queue table"
            r11.zza(r0, r12)     // Catch:{ SQLiteException -> 0x0104 }
            throw r12     // Catch:{ SQLiteException -> 0x0104 }
        L_0x0104:
            r11 = move-exception
            java.util.List<java.lang.Long> r12 = r8.zzaa     // Catch:{ all -> 0x0140 }
            if (r12 == 0) goto L_0x0110
            boolean r10 = r12.contains(r10)     // Catch:{ all -> 0x0140 }
            if (r10 == 0) goto L_0x0110
            goto L_0x00bc
        L_0x0110:
            throw r11     // Catch:{ all -> 0x0140 }
        L_0x0111:
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ all -> 0x0140 }
            r9.zzw()     // Catch:{ all -> 0x0140 }
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ SQLiteException -> 0x0149 }
            r9.zzu()     // Catch:{ SQLiteException -> 0x0149 }
            r8.zzaa = r1     // Catch:{ SQLiteException -> 0x0149 }
            com.google.android.gms.measurement.internal.zzfz r9 = r8.zzh()     // Catch:{ SQLiteException -> 0x0149 }
            boolean r9 = r9.zzu()     // Catch:{ SQLiteException -> 0x0149 }
            if (r9 == 0) goto L_0x0135
            boolean r9 = r8.zzac()     // Catch:{ SQLiteException -> 0x0149 }
            if (r9 == 0) goto L_0x0135
            r8.zzw()     // Catch:{ SQLiteException -> 0x0149 }
            goto L_0x013c
        L_0x0135:
            r9 = -1
            r8.zzab = r9     // Catch:{ SQLiteException -> 0x0149 }
            r8.zzab()     // Catch:{ SQLiteException -> 0x0149 }
        L_0x013c:
            r8.zzp = r4     // Catch:{ SQLiteException -> 0x0149 }
            goto L_0x01ba
        L_0x0140:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzal r10 = r8.zzf()     // Catch:{ SQLiteException -> 0x0149 }
            r10.zzu()     // Catch:{ SQLiteException -> 0x0149 }
            throw r9     // Catch:{ SQLiteException -> 0x0149 }
        L_0x0149:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzfw r10 = r8.zzj()     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzfy r10 = r10.zzg()     // Catch:{ all -> 0x01c0 }
            java.lang.String r11 = "Database error while trying to delete uploaded bundles"
            r10.zza(r11, r9)     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.common.util.Clock r9 = r8.zzb()     // Catch:{ all -> 0x01c0 }
            long r9 = r9.elapsedRealtime()     // Catch:{ all -> 0x01c0 }
            r8.zzp = r9     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzfw r9 = r8.zzj()     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzp()     // Catch:{ all -> 0x01c0 }
            java.lang.String r10 = "Disable upload, time"
            long r11 = r8.zzp     // Catch:{ all -> 0x01c0 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x01c0 }
            r9.zza(r10, r11)     // Catch:{ all -> 0x01c0 }
            goto L_0x01ba
        L_0x0175:
            com.google.android.gms.measurement.internal.zzfw r9 = r8.zzj()     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzp()     // Catch:{ all -> 0x01c0 }
            java.lang.String r12 = "Network upload failed. Will retry later. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x01c0 }
            r9.zza(r12, r1, r11)     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzmc r9 = r8.zzj     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzgm r9 = r9.zzd     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.common.util.Clock r11 = r8.zzb()     // Catch:{ all -> 0x01c0 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x01c0 }
            r9.zza(r11)     // Catch:{ all -> 0x01c0 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x019f
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x019e
            goto L_0x019f
        L_0x019e:
            r3 = r13
        L_0x019f:
            if (r3 == 0) goto L_0x01b0
            com.google.android.gms.measurement.internal.zzmc r9 = r8.zzj     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzgm r9 = r9.zzb     // Catch:{ all -> 0x01c0 }
            com.google.android.gms.common.util.Clock r10 = r8.zzb()     // Catch:{ all -> 0x01c0 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x01c0 }
            r9.zza(r10)     // Catch:{ all -> 0x01c0 }
        L_0x01b0:
            com.google.android.gms.measurement.internal.zzal r9 = r8.zzf()     // Catch:{ all -> 0x01c0 }
            r9.zza((java.util.List<java.lang.Long>) r0)     // Catch:{ all -> 0x01c0 }
            r8.zzab()     // Catch:{ all -> 0x01c0 }
        L_0x01ba:
            r8.zzv = r13
            r8.zzaa()
            return
        L_0x01c0:
            r9 = move-exception
            r8.zzv = r13
            r8.zzaa()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zza(boolean, int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    public final void zza(zzae zzae2) {
        zzo zzc2 = zzc((String) Preconditions.checkNotNull(zzae2.zza));
        if (zzc2 != null) {
            zza(zzae2, zzc2);
        }
    }

    public final void zza(zzae zzae2, zzo zzo2) {
        Preconditions.checkNotNull(zzae2);
        Preconditions.checkNotEmpty(zzae2.zza);
        Preconditions.checkNotNull(zzae2.zzc);
        Preconditions.checkNotEmpty(zzae2.zzc.zza);
        zzl().zzt();
        zzs();
        if (zzh(zzo2)) {
            if (!zzo2.zzh) {
                zza(zzo2);
                return;
            }
            zzf().zzp();
            try {
                zza(zzo2);
                String str = (String) Preconditions.checkNotNull(zzae2.zza);
                zzae zzc2 = zzf().zzc(str, zzae2.zzc.zza);
                if (zzc2 != null) {
                    zzj().zzc().zza("Removing conditional user property", zzae2.zza, this.zzm.zzk().zzc(zzae2.zzc.zza));
                    zzf().zza(str, zzae2.zzc.zza);
                    if (zzc2.zze) {
                        zzf().zzh(str, zzae2.zzc.zza);
                    }
                    zzbd zzbd = zzae2.zzk;
                    if (zzbd != null) {
                        zzbc zzbc = zzbd.zzb;
                        zzc((zzbd) Preconditions.checkNotNull(zzq().zza(str, ((zzbd) Preconditions.checkNotNull(zzae2.zzk)).zza, zzbc != null ? zzbc.zzb() : null, zzc2.zzb, zzae2.zzk.zzd, true, true)), zzo2);
                    }
                } else {
                    zzj().zzu().zza("Conditional user property doesn't exist", zzfw.zza(zzae2.zza), this.zzm.zzk().zzc(zzae2.zzc.zza));
                }
                zzf().zzw();
            } finally {
                zzf().zzu();
            }
        }
    }

    private static void zza(zzfn.zzf.zza zza2, String str) {
        List<zzfn.zzh> zzf2 = zza2.zzf();
        for (int i = 0; i < zzf2.size(); i++) {
            if (str.equals(zzf2.get(i).zzg())) {
                zza2.zza(i);
                return;
            }
        }
    }

    public final void zza(String str, zzo zzo2) {
        zzl().zzt();
        zzs();
        if (zzh(zzo2)) {
            if (!zzo2.zzh) {
                zza(zzo2);
                return;
            }
            Boolean zzg2 = zzg(zzo2);
            if (!"_npa".equals(str) || zzg2 == null) {
                zzj().zzc().zza("Removing user property", this.zzm.zzk().zzc(str));
                zzf().zzp();
                try {
                    zza(zzo2);
                    if ("_id".equals(str)) {
                        zzf().zzh((String) Preconditions.checkNotNull(zzo2.zza), "_lair");
                    }
                    zzf().zzh((String) Preconditions.checkNotNull(zzo2.zza), str);
                    zzf().zzw();
                    zzj().zzc().zza("User property removed", this.zzm.zzk().zzc(str));
                } finally {
                    zzf().zzu();
                }
            } else {
                zzj().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzno("_npa", zzb().currentTimeMillis(), Long.valueOf(zzg2.booleanValue() ? 1 : 0), "auto"), zzo2);
            }
        }
    }

    public final void zza(String str, zzkp zzkp) {
        zzl().zzt();
        String str2 = this.zzag;
        if (str2 == null || str2.equals(str) || zzkp != null) {
            this.zzag = str;
            this.zzaf = zzkp;
        }
    }

    private final void zza(List<Long> list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzj().zzg().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    private final void zza(String str, zzin zzin) {
        zzl().zzt();
        zzs();
        this.zzac.put(str, zzin);
        zzf().zzb(str, zzin);
    }

    private final void zza(String str, boolean z, Long l, Long l2) {
        zzg zze2 = zzf().zze(str);
        if (zze2 != null) {
            zze2.zzd(z);
            zze2.zza(l);
            zze2.zzb(l2);
            if (zze2.zzas()) {
                zzf().zza(zze2, false, false);
            }
        }
    }

    public final void zza(zzno zzno, zzo zzo2) {
        zznq zze2;
        long j;
        zzl().zzt();
        zzs();
        if (zzh(zzo2)) {
            if (!zzo2.zzh) {
                zza(zzo2);
                return;
            }
            int zzb2 = zzq().zzb(zzno.zza);
            int i = 0;
            if (zzb2 != 0) {
                zzq();
                String str = zzno.zza;
                zze();
                String zza2 = zznp.zza(str, 24, true);
                String str2 = zzno.zza;
                int length = str2 != null ? str2.length() : 0;
                zzq();
                zznp.zza(this.zzah, zzo2.zza, zzb2, "_ev", zza2, length);
                return;
            }
            int zza3 = zzq().zza(zzno.zza, zzno.zza());
            if (zza3 != 0) {
                zzq();
                String str3 = zzno.zza;
                zze();
                String zza4 = zznp.zza(str3, 24, true);
                Object zza5 = zzno.zza();
                if (zza5 != null && ((zza5 instanceof String) || (zza5 instanceof CharSequence))) {
                    i = String.valueOf(zza5).length();
                }
                zzq();
                zznp.zza(this.zzah, zzo2.zza, zza3, "_ev", zza4, i);
                return;
            }
            Object zzc2 = zzq().zzc(zzno.zza, zzno.zza());
            if (zzc2 != null) {
                if ("_sid".equals(zzno.zza)) {
                    long j2 = zzno.zzb;
                    String str4 = zzno.zze;
                    String str5 = (String) Preconditions.checkNotNull(zzo2.zza);
                    zznq zze3 = zzf().zze(str5, "_sno");
                    if (zze3 != null) {
                        Object obj = zze3.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zza(new zzno("_sno", j2, Long.valueOf(j + 1), str4), zzo2);
                        }
                    }
                    if (zze3 != null) {
                        zzj().zzu().zza("Retrieved last session number from database does not contain a valid (long) value", zze3.zze);
                    }
                    zzaz zzd2 = zzf().zzd(str5, "_s");
                    if (zzd2 != null) {
                        j = zzd2.zzc;
                        zzj().zzp().zza("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zza(new zzno("_sno", j2, Long.valueOf(j + 1), str4), zzo2);
                }
                zznq zznq = new zznq((String) Preconditions.checkNotNull(zzo2.zza), (String) Preconditions.checkNotNull(zzno.zze), zzno.zza, zzno.zzb, zzc2);
                zzj().zzp().zza("Setting user property", this.zzm.zzk().zzc(zznq.zzc), zzc2);
                zzf().zzp();
                try {
                    if ("_id".equals(zznq.zzc) && (zze2 = zzf().zze(zzo2.zza, "_id")) != null && !zznq.zze.equals(zze2.zze)) {
                        zzf().zzh(zzo2.zza, "_lair");
                    }
                    zza(zzo2);
                    boolean zza6 = zzf().zza(zznq);
                    if ("_sid".equals(zzno.zza)) {
                        long zza7 = zzp().zza(zzo2.zzv);
                        zzg zze4 = zzf().zze(zzo2.zza);
                        if (zze4 != null) {
                            zze4.zzs(zza7);
                            if (zze4.zzas()) {
                                zzf().zza(zze4, false, false);
                            }
                        }
                    }
                    zzf().zzw();
                    if (!zza6) {
                        zzj().zzg().zza("Too many unique user properties are set. Ignoring user property", this.zzm.zzk().zzc(zznq.zzc), zznq.zze);
                        zzq();
                        zznp.zza(this.zzah, zzo2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzf().zzu();
                }
            }
        }
    }

    private final void zza(String str, zzfn.zzh.zza zza2, Bundle bundle, String str2) {
        int i;
        List listOf = CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (zznp.zzg(zza2.zzf()) || zznp.zzg(str)) {
            i = zze().zzb(str2, true);
        } else {
            i = zze().zza(str2, true);
        }
        long j = (long) i;
        long codePointCount = (long) zza2.zzg().codePointCount(0, zza2.zzg().length());
        zzq();
        String zzf2 = zza2.zzf();
        zze();
        String zza3 = zznp.zza(zzf2, 40, true);
        if (codePointCount > j && !listOf.contains(zza2.zzf())) {
            if ("_ev".equals(zza2.zzf())) {
                zzq();
                bundle.putString("_ev", zznp.zza(zza2.zzg(), zze().zzb(str2, true), true));
                return;
            }
            zzj().zzv().zza("Param value is too long; discarded. Name, value length", zza3, Long.valueOf(codePointCount));
            if (bundle.getLong("_err") == 0) {
                bundle.putLong("_err", 4);
                if (bundle.getString("_ev") == null) {
                    bundle.putString("_ev", zza3);
                    bundle.putLong("_el", codePointCount);
                }
            }
            bundle.remove(zza2.zzf());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x022e A[SYNTHETIC, Splitter:B:108:0x022e] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0235 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0241 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03b9 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03bb A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03be A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03bf A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x059b A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0664 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x06b7 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0728 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0838 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0aaf A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x0ac7 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0bc1 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x0bf6 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x0c31 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:551:0x0f61 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x0f73 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:555:0x0f8c A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:579:0x1009 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x100d A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:584:0x101e A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:598:0x1094 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:603:0x10c5 A[Catch:{ IOException -> 0x01f5, all -> 0x1130 }] */
    /* JADX WARNING: Removed duplicated region for block: B:615:0x1118 A[SYNTHETIC, Splitter:B:615:0x1118] */
    /* JADX WARNING: Removed duplicated region for block: B:622:0x112c A[SYNTHETIC, Splitter:B:622:0x112c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r42, long r43) {
        /*
            r41 = this;
            r1 = r41
            java.lang.String r2 = "_ai"
            java.lang.String r3 = "items"
            com.google.android.gms.measurement.internal.zzal r4 = r41.zzf()
            r4.zzp()
            com.google.android.gms.measurement.internal.zznc$zza r4 = new com.google.android.gms.measurement.internal.zznc$zza     // Catch:{ all -> 0x1130 }
            r5 = 0
            r4.<init>()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r6 = r41.zzf()     // Catch:{ all -> 0x1130 }
            long r7 = r1.zzab     // Catch:{ all -> 0x1130 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x1130 }
            r6.zzt()     // Catch:{ all -> 0x1130 }
            r6.zzal()     // Catch:{ all -> 0x1130 }
            r10 = -1
            r12 = 2
            r13 = 1
            r14 = 0
            android.database.sqlite.SQLiteDatabase r15 = r6.e_()     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            boolean r16 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r17 = ""
            if (r16 == 0) goto L_0x0087
            int r16 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x004b
            java.lang.String[] r9 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0046 }
            java.lang.String r18 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0046 }
            r9[r14] = r18     // Catch:{ SQLiteException -> 0x0046 }
            java.lang.String r18 = java.lang.String.valueOf(r43)     // Catch:{ SQLiteException -> 0x0046 }
            r9[r13] = r18     // Catch:{ SQLiteException -> 0x0046 }
            goto L_0x0053
        L_0x0046:
            r0 = move-exception
            r7 = r0
            r9 = r5
            goto L_0x021b
        L_0x004b:
            java.lang.String[] r9 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r18 = java.lang.String.valueOf(r43)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            r9[r14] = r18     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
        L_0x0053:
            if (r16 == 0) goto L_0x0057
            java.lang.String r17 = "rowid <= ? and "
        L_0x0057:
            r5 = r17
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r10 = "select app_id, metadata_fingerprint from raw_events where "
            r12.<init>(r10)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r12.append(r5)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r5 = r12.toString()     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            android.database.Cursor r5 = r15.rawQuery(r5, r9)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x020f }
            if (r9 != 0) goto L_0x007b
            r5.close()     // Catch:{ all -> 0x1130 }
            goto L_0x0231
        L_0x007b:
            java.lang.String r9 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x020f }
            java.lang.String r10 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x020c }
            r5.close()     // Catch:{ SQLiteException -> 0x020c }
            goto L_0x00ce
        L_0x0087:
            r9 = r10
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x0099
            r9 = 2
            java.lang.String[] r10 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            r9 = 0
            r10[r14] = r9     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r9 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            r10[r13] = r9     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            goto L_0x009e
        L_0x0099:
            r9 = 0
            java.lang.String[] r10 = new java.lang.String[]{r9}     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
        L_0x009e:
            if (r5 == 0) goto L_0x00a2
            java.lang.String r17 = " and rowid <= ?"
        L_0x00a2:
            r5 = r17
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r11 = "select metadata_fingerprint from raw_events where app_id = ?"
            r9.<init>(r11)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            r9.append(r5)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r5 = " order by rowid limit 1;"
            r9.append(r5)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            java.lang.String r5 = r9.toString()     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            android.database.Cursor r5 = r15.rawQuery(r5, r10)     // Catch:{ SQLiteException -> 0x0217, all -> 0x0212 }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x020f }
            if (r9 != 0) goto L_0x00c6
            r5.close()     // Catch:{ all -> 0x1130 }
            goto L_0x0231
        L_0x00c6:
            java.lang.String r10 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x020f }
            r5.close()     // Catch:{ SQLiteException -> 0x020f }
            r9 = 0
        L_0x00ce:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r11 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r11}     // Catch:{ SQLiteException -> 0x020c }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r11 = 2
            java.lang.String[] r12 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x020c }
            r12[r14] = r9     // Catch:{ SQLiteException -> 0x020c }
            r12[r13] = r10     // Catch:{ SQLiteException -> 0x020c }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            java.lang.String r23 = "2"
            r11 = r15
            r15 = r11
            r19 = r12
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x020c }
            boolean r12 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x020c }
            if (r12 != 0) goto L_0x010b
            com.google.android.gms.measurement.internal.zzfw r7 = r6.zzj()     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzg()     // Catch:{ SQLiteException -> 0x020c }
            java.lang.String r8 = "Raw event metadata record is missing. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x020c }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x020c }
            r5.close()     // Catch:{ all -> 0x1130 }
            goto L_0x0231
        L_0x010b:
            byte[] r12 = r5.getBlob(r14)     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r15 = com.google.android.gms.internal.measurement.zzfn.zzk.zzw()     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzks r12 = com.google.android.gms.measurement.internal.zznl.zza(r15, (byte[]) r12)     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r12 = (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r12     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzkt r12 = r12.zzai()     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzjk r12 = (com.google.android.gms.internal.measurement.zzjk) r12     // Catch:{ IOException -> 0x01f5 }
            com.google.android.gms.internal.measurement.zzfn$zzk r12 = (com.google.android.gms.internal.measurement.zzfn.zzk) r12     // Catch:{ IOException -> 0x01f5 }
            boolean r15 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x020c }
            if (r15 == 0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzfw r15 = r6.zzj()     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.measurement.internal.zzfy r15 = r15.zzu()     // Catch:{ SQLiteException -> 0x020c }
            java.lang.String r13 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x020c }
            r15.zza(r13, r14)     // Catch:{ SQLiteException -> 0x020c }
        L_0x0138:
            r5.close()     // Catch:{ SQLiteException -> 0x020c }
            r4.zza(r12)     // Catch:{ SQLiteException -> 0x020c }
            r12 = -1
            int r14 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x015b
            java.lang.String r12 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x020c }
            r13 = 0
            r14[r13] = r9     // Catch:{ SQLiteException -> 0x020c }
            r13 = 1
            r14[r13] = r10     // Catch:{ SQLiteException -> 0x020c }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x020c }
            r8 = 2
            r14[r8] = r7     // Catch:{ SQLiteException -> 0x020c }
            r18 = r12
            r19 = r14
            goto L_0x016a
        L_0x015b:
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r8 = 2
            java.lang.String[] r12 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x020c }
            r8 = 0
            r12[r8] = r9     // Catch:{ SQLiteException -> 0x020c }
            r8 = 1
            r12[r8] = r10     // Catch:{ SQLiteException -> 0x020c }
            r18 = r7
            r19 = r12
        L_0x016a:
            java.lang.String r16 = "raw_events"
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "name"
            java.lang.String r10 = "timestamp"
            java.lang.String r12 = "data"
            java.lang.String[] r17 = new java.lang.String[]{r7, r8, r10, r12}     // Catch:{ SQLiteException -> 0x020c }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            r23 = 0
            r15 = r11
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x020c }
            boolean r7 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x020c }
            if (r7 != 0) goto L_0x01a1
            com.google.android.gms.measurement.internal.zzfw r7 = r6.zzj()     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzu()     // Catch:{ SQLiteException -> 0x020c }
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x020c }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x020c }
            r5.close()     // Catch:{ all -> 0x1130 }
            goto L_0x0231
        L_0x01a1:
            r7 = 0
            long r10 = r5.getLong(r7)     // Catch:{ SQLiteException -> 0x020c }
            r7 = 3
            byte[] r8 = r5.getBlob(r7)     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r7 = com.google.android.gms.internal.measurement.zzfn.zzf.zze()     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.internal.measurement.zzks r7 = com.google.android.gms.measurement.internal.zznl.zza(r7, (byte[]) r8)     // Catch:{ IOException -> 0x01d8 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r7 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r7     // Catch:{ IOException -> 0x01d8 }
            r8 = 1
            java.lang.String r12 = r5.getString(r8)     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r8 = r7.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x020c }
            r12 = 2
            long r13 = r5.getLong(r12)     // Catch:{ SQLiteException -> 0x020c }
            r8.zzb((long) r13)     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.internal.measurement.zzkt r7 = r7.zzai()     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.internal.measurement.zzjk r7 = (com.google.android.gms.internal.measurement.zzjk) r7     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.internal.measurement.zzfn$zzf r7 = (com.google.android.gms.internal.measurement.zzfn.zzf) r7     // Catch:{ SQLiteException -> 0x020c }
            boolean r7 = r4.zza(r10, r7)     // Catch:{ SQLiteException -> 0x020c }
            if (r7 != 0) goto L_0x01eb
            r5.close()     // Catch:{ all -> 0x1130 }
            goto L_0x0231
        L_0x01d8:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzfw r8 = r6.zzj()     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzg()     // Catch:{ SQLiteException -> 0x020c }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x020c }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x020c }
        L_0x01eb:
            boolean r7 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x020c }
            if (r7 != 0) goto L_0x01a1
            r5.close()     // Catch:{ all -> 0x1130 }
            goto L_0x0231
        L_0x01f5:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzfw r8 = r6.zzj()     // Catch:{ SQLiteException -> 0x020c }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzg()     // Catch:{ SQLiteException -> 0x020c }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x020c }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x020c }
            r5.close()     // Catch:{ all -> 0x1130 }
            goto L_0x0231
        L_0x020c:
            r0 = move-exception
            r7 = r0
            goto L_0x021b
        L_0x020f:
            r0 = move-exception
            r7 = r0
            goto L_0x021a
        L_0x0212:
            r0 = move-exception
            r1 = r0
            r5 = 0
            goto L_0x112a
        L_0x0217:
            r0 = move-exception
            r7 = r0
            r5 = 0
        L_0x021a:
            r9 = 0
        L_0x021b:
            com.google.android.gms.measurement.internal.zzfw r6 = r6.zzj()     // Catch:{ all -> 0x1128 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzg()     // Catch:{ all -> 0x1128 }
            java.lang.String r8 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r9)     // Catch:{ all -> 0x1128 }
            r6.zza(r8, r9, r7)     // Catch:{ all -> 0x1128 }
            if (r5 == 0) goto L_0x0231
            r5.close()     // Catch:{ all -> 0x1130 }
        L_0x0231:
            java.util.List<com.google.android.gms.internal.measurement.zzfn$zzf> r5 = r4.zzc     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x023e
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x023c
            goto L_0x023e
        L_0x023c:
            r5 = 0
            goto L_0x023f
        L_0x023e:
            r5 = 1
        L_0x023f:
            if (r5 != 0) goto L_0x1118
            com.google.android.gms.internal.measurement.zzfn$zzk r5 = r4.zza     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r5 = r5.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r5 = (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r5 = r5.zzl()     // Catch:{ all -> 0x1130 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
        L_0x0254:
            java.util.List<com.google.android.gms.internal.measurement.zzfn$zzf> r14 = r4.zzc     // Catch:{ all -> 0x1130 }
            int r14 = r14.size()     // Catch:{ all -> 0x1130 }
            java.lang.String r15 = "_fr"
            java.lang.String r6 = "_et"
            r16 = r10
            java.lang.String r10 = "_e"
            r44 = r11
            java.lang.String r11 = "_c"
            r18 = r6
            r17 = r7
            if (r9 >= r14) goto L_0x085e
            java.util.List<com.google.android.gms.internal.measurement.zzfn$zzf> r14 = r4.zzc     // Catch:{ all -> 0x1130 }
            java.lang.Object r14 = r14.get(r9)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r14 = (com.google.android.gms.internal.measurement.zzfn.zzf) r14     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r14 = r14.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r14 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzgt r6 = r41.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r7 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1130 }
            r21 = r9
            java.lang.String r9 = r14.zze()     // Catch:{ all -> 0x1130 }
            boolean r6 = r6.zzd(r7, r9)     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = "_err"
            if (r6 == 0) goto L_0x030e
            com.google.android.gms.measurement.internal.zzfw r6 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzu()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzfn$zzk r10 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r10)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzhj r11 = r1.zzm     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzk()     // Catch:{ all -> 0x1130 }
            java.lang.String r15 = r14.zze()     // Catch:{ all -> 0x1130 }
            java.lang.String r11 = r11.zza((java.lang.String) r15)     // Catch:{ all -> 0x1130 }
            r6.zza(r9, r10, r11)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzgt r6 = r41.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r9 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r9.zzz()     // Catch:{ all -> 0x1130 }
            boolean r6 = r6.zzm(r9)     // Catch:{ all -> 0x1130 }
            if (r6 != 0) goto L_0x02da
            com.google.android.gms.measurement.internal.zzgt r6 = r41.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r9 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r9.zzz()     // Catch:{ all -> 0x1130 }
            boolean r6 = r6.zzo(r9)     // Catch:{ all -> 0x1130 }
            if (r6 == 0) goto L_0x02d8
            goto L_0x02da
        L_0x02d8:
            r6 = 0
            goto L_0x02db
        L_0x02da:
            r6 = 1
        L_0x02db:
            if (r6 != 0) goto L_0x0301
            java.lang.String r6 = r14.zze()     // Catch:{ all -> 0x1130 }
            boolean r6 = r7.equals(r6)     // Catch:{ all -> 0x1130 }
            if (r6 != 0) goto L_0x0301
            r41.zzq()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznr r6 = r1.zzah     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r7 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r25 = r7.zzz()     // Catch:{ all -> 0x1130 }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r14.zze()     // Catch:{ all -> 0x1130 }
            r29 = 0
            r24 = r6
            com.google.android.gms.measurement.internal.zznp.zza((com.google.android.gms.measurement.internal.zznr) r24, (java.lang.String) r25, (int) r26, (java.lang.String) r27, (java.lang.String) r28, (int) r29)     // Catch:{ all -> 0x1130 }
        L_0x0301:
            r23 = r2
            r11 = r3
            r10 = r16
            r7 = r17
            r6 = r21
            r2 = r44
            goto L_0x0856
        L_0x030e:
            java.lang.String r6 = r14.zze()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = com.google.android.gms.measurement.internal.zziq.zza(r2)     // Catch:{ all -> 0x1130 }
            boolean r6 = r6.equals(r9)     // Catch:{ all -> 0x1130 }
            if (r6 == 0) goto L_0x0380
            r14.zza((java.lang.String) r2)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfw r6 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = "Renaming ad_impression to _ai"
            r6.zza(r9)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfw r6 = r41.zzj()     // Catch:{ all -> 0x1130 }
            r9 = 5
            boolean r6 = r6.zza((int) r9)     // Catch:{ all -> 0x1130 }
            if (r6 == 0) goto L_0x0380
            r6 = 0
        L_0x0338:
            int r9 = r14.zza()     // Catch:{ all -> 0x1130 }
            if (r6 >= r9) goto L_0x0380
            java.lang.String r9 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfn$zzh r22 = r14.zzb((int) r6)     // Catch:{ all -> 0x1130 }
            r23 = r2
            java.lang.String r2 = r22.zzg()     // Catch:{ all -> 0x1130 }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x1130 }
            if (r2 == 0) goto L_0x037b
            com.google.android.gms.internal.measurement.zzfn$zzh r2 = r14.zzb((int) r6)     // Catch:{ all -> 0x1130 }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x1130 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x1130 }
            if (r2 != 0) goto L_0x037b
            java.lang.String r2 = "admob"
            com.google.android.gms.internal.measurement.zzfn$zzh r9 = r14.zzb((int) r6)     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r9.zzh()     // Catch:{ all -> 0x1130 }
            boolean r2 = r2.equalsIgnoreCase(r9)     // Catch:{ all -> 0x1130 }
            if (r2 == 0) goto L_0x037b
            com.google.android.gms.measurement.internal.zzfw r2 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzv()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = "AdMob ad impression logged from app. Potentially duplicative."
            r2.zza(r9)     // Catch:{ all -> 0x1130 }
        L_0x037b:
            int r6 = r6 + 1
            r2 = r23
            goto L_0x0338
        L_0x0380:
            r23 = r2
            com.google.android.gms.measurement.internal.zzgt r2 = r41.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r14.zze()     // Catch:{ all -> 0x1130 }
            boolean r2 = r2.zzc((java.lang.String) r6, (java.lang.String) r9)     // Catch:{ all -> 0x1130 }
            if (r2 != 0) goto L_0x03c8
            r41.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r14.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x1130 }
            int r9 = r6.hashCode()     // Catch:{ all -> 0x1130 }
            r22 = r3
            r3 = 95027(0x17333, float:1.33161E-40)
            if (r9 == r3) goto L_0x03ac
            goto L_0x03b6
        L_0x03ac:
            java.lang.String r3 = "_ui"
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x1130 }
            if (r3 == 0) goto L_0x03b6
            r3 = 0
            goto L_0x03b7
        L_0x03b6:
            r3 = -1
        L_0x03b7:
            if (r3 == 0) goto L_0x03bb
            r3 = 0
            goto L_0x03bc
        L_0x03bb:
            r3 = 1
        L_0x03bc:
            if (r3 == 0) goto L_0x03bf
            goto L_0x03ca
        L_0x03bf:
            r25 = r5
            r6 = r8
            r24 = r12
            r26 = r13
            goto L_0x0599
        L_0x03c8:
            r22 = r3
        L_0x03ca:
            r24 = r12
            r3 = 0
            r6 = 0
            r9 = 0
        L_0x03cf:
            int r12 = r14.zza()     // Catch:{ all -> 0x1130 }
            r25 = r5
            java.lang.String r5 = "_r"
            if (r9 >= r12) goto L_0x0439
            com.google.android.gms.internal.measurement.zzfn$zzh r12 = r14.zzb((int) r9)     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x1130 }
            boolean r12 = r11.equals(r12)     // Catch:{ all -> 0x1130 }
            if (r12 == 0) goto L_0x0406
            com.google.android.gms.internal.measurement.zzfn$zzh r3 = r14.zzb((int) r9)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r3 = r3.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r3     // Catch:{ all -> 0x1130 }
            r26 = r13
            r12 = 1
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = r3.zza((long) r12)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r3 = r3.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r3 = (com.google.android.gms.internal.measurement.zzjk) r3     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r3 = (com.google.android.gms.internal.measurement.zzfn.zzh) r3     // Catch:{ all -> 0x1130 }
            r14.zza((int) r9, (com.google.android.gms.internal.measurement.zzfn.zzh) r3)     // Catch:{ all -> 0x1130 }
            r3 = 1
            goto L_0x0432
        L_0x0406:
            r26 = r13
            com.google.android.gms.internal.measurement.zzfn$zzh r12 = r14.zzb((int) r9)     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x1130 }
            boolean r5 = r5.equals(r12)     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x0432
            com.google.android.gms.internal.measurement.zzfn$zzh r5 = r14.zzb((int) r9)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r5 = r5.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r5 = (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r5     // Catch:{ all -> 0x1130 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r5 = r5.zza((long) r12)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r5 = r5.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r5 = (com.google.android.gms.internal.measurement.zzjk) r5     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r5 = (com.google.android.gms.internal.measurement.zzfn.zzh) r5     // Catch:{ all -> 0x1130 }
            r14.zza((int) r9, (com.google.android.gms.internal.measurement.zzfn.zzh) r5)     // Catch:{ all -> 0x1130 }
            r6 = 1
        L_0x0432:
            int r9 = r9 + 1
            r5 = r25
            r13 = r26
            goto L_0x03cf
        L_0x0439:
            r26 = r13
            if (r3 != 0) goto L_0x046b
            if (r2 == 0) goto L_0x046b
            com.google.android.gms.measurement.internal.zzfw r3 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzhj r12 = r1.zzm     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfr r12 = r12.zzk()     // Catch:{ all -> 0x1130 }
            java.lang.String r13 = r14.zze()     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = r12.zza((java.lang.String) r13)     // Catch:{ all -> 0x1130 }
            r3.zza(r9, r12)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = com.google.android.gms.internal.measurement.zzfn.zzh.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = r3.zza((java.lang.String) r11)     // Catch:{ all -> 0x1130 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = r3.zza((long) r12)     // Catch:{ all -> 0x1130 }
            r14.zza((com.google.android.gms.internal.measurement.zzfn.zzh.zza) r3)     // Catch:{ all -> 0x1130 }
        L_0x046b:
            if (r6 != 0) goto L_0x0499
            com.google.android.gms.measurement.internal.zzfw r3 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzhj r9 = r1.zzm     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfr r9 = r9.zzk()     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = r14.zze()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r9.zza((java.lang.String) r12)     // Catch:{ all -> 0x1130 }
            r3.zza(r6, r9)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = com.google.android.gms.internal.measurement.zzfn.zzh.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x1130 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = r3.zza((long) r12)     // Catch:{ all -> 0x1130 }
            r14.zza((com.google.android.gms.internal.measurement.zzfn.zzh.zza) r3)     // Catch:{ all -> 0x1130 }
        L_0x0499:
            com.google.android.gms.measurement.internal.zzal r27 = r41.zzf()     // Catch:{ all -> 0x1130 }
            long r28 = r41.zzx()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r3 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r30 = r3.zzz()     // Catch:{ all -> 0x1130 }
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 1
            r36 = 0
            com.google.android.gms.measurement.internal.zzaq r3 = r27.zza(r28, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x1130 }
            long r12 = r3.zze     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzag r3 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            int r3 = r3.zzc(r6)     // Catch:{ all -> 0x1130 }
            r6 = r8
            long r8 = (long) r3     // Catch:{ all -> 0x1130 }
            int r3 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x04d1
            zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14, (java.lang.String) r5)     // Catch:{ all -> 0x1130 }
            goto L_0x04d3
        L_0x04d1:
            r16 = 1
        L_0x04d3:
            java.lang.String r3 = r14.zze()     // Catch:{ all -> 0x1130 }
            boolean r3 = com.google.android.gms.measurement.internal.zznp.zzh(r3)     // Catch:{ all -> 0x1130 }
            if (r3 == 0) goto L_0x0599
            if (r2 == 0) goto L_0x0599
            com.google.android.gms.measurement.internal.zzal r27 = r41.zzf()     // Catch:{ all -> 0x1130 }
            long r28 = r41.zzx()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r3 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r30 = r3.zzz()     // Catch:{ all -> 0x1130 }
            r31 = 0
            r32 = 0
            r33 = 1
            r34 = 0
            r35 = 0
            r36 = 0
            com.google.android.gms.measurement.internal.zzaq r3 = r27.zza(r28, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x1130 }
            long r8 = r3.zzc     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzag r3 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r5 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = r5.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzbf.zzn     // Catch:{ all -> 0x1130 }
            int r3 = r3.zzb((java.lang.String) r5, (com.google.android.gms.measurement.internal.zzfj<java.lang.Integer>) r12)     // Catch:{ all -> 0x1130 }
            long r12 = (long) r3     // Catch:{ all -> 0x1130 }
            int r3 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0599
            com.google.android.gms.measurement.internal.zzfw r3 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzu()     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x1130 }
            r3.zza(r5, r8)     // Catch:{ all -> 0x1130 }
            r3 = -1
            r5 = 0
            r8 = 0
            r9 = 0
        L_0x052f:
            int r12 = r14.zza()     // Catch:{ all -> 0x1130 }
            if (r9 >= r12) goto L_0x055a
            com.google.android.gms.internal.measurement.zzfn$zzh r12 = r14.zzb((int) r9)     // Catch:{ all -> 0x1130 }
            java.lang.String r13 = r12.zzg()     // Catch:{ all -> 0x1130 }
            boolean r13 = r11.equals(r13)     // Catch:{ all -> 0x1130 }
            if (r13 == 0) goto L_0x054c
            com.google.android.gms.internal.measurement.zzjk$zzb r3 = r12.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r3 = (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r3     // Catch:{ all -> 0x1130 }
            r5 = r3
            r3 = r9
            goto L_0x0557
        L_0x054c:
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x1130 }
            boolean r12 = r7.equals(r12)     // Catch:{ all -> 0x1130 }
            if (r12 == 0) goto L_0x0557
            r8 = 1
        L_0x0557:
            int r9 = r9 + 1
            goto L_0x052f
        L_0x055a:
            if (r8 == 0) goto L_0x0562
            if (r5 == 0) goto L_0x0562
            r14.zza((int) r3)     // Catch:{ all -> 0x1130 }
            goto L_0x0599
        L_0x0562:
            if (r5 == 0) goto L_0x0582
            java.lang.Object r5 = r5.clone()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r5 = (com.google.android.gms.internal.measurement.zzjk.zzb) r5     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r5 = (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r5     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r5 = r5.zza((java.lang.String) r7)     // Catch:{ all -> 0x1130 }
            r7 = 10
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r5 = r5.zza((long) r7)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r5 = r5.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r5 = (com.google.android.gms.internal.measurement.zzjk) r5     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r5 = (com.google.android.gms.internal.measurement.zzfn.zzh) r5     // Catch:{ all -> 0x1130 }
            r14.zza((int) r3, (com.google.android.gms.internal.measurement.zzfn.zzh) r5)     // Catch:{ all -> 0x1130 }
            goto L_0x0599
        L_0x0582:
            com.google.android.gms.measurement.internal.zzfw r3 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzfn$zzk r7 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r7)     // Catch:{ all -> 0x1130 }
            r3.zza(r5, r7)     // Catch:{ all -> 0x1130 }
        L_0x0599:
            if (r2 == 0) goto L_0x0658
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x1130 }
            java.util.List r3 = r14.zzf()     // Catch:{ all -> 0x1130 }
            r2.<init>(r3)     // Catch:{ all -> 0x1130 }
            r3 = 0
            r5 = -1
            r7 = -1
        L_0x05a7:
            int r8 = r2.size()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = "currency"
            java.lang.String r12 = "value"
            if (r3 >= r8) goto L_0x05d7
            java.lang.Object r8 = r2.get(r3)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r8 = (com.google.android.gms.internal.measurement.zzfn.zzh) r8     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x1130 }
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x05c3
            r5 = r3
            goto L_0x05d4
        L_0x05c3:
            java.lang.Object r8 = r2.get(r3)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r8 = (com.google.android.gms.internal.measurement.zzfn.zzh) r8     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x1130 }
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x05d4
            r7 = r3
        L_0x05d4:
            int r3 = r3 + 1
            goto L_0x05a7
        L_0x05d7:
            r3 = -1
            if (r5 == r3) goto L_0x0659
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r3 = (com.google.android.gms.internal.measurement.zzfn.zzh) r3     // Catch:{ all -> 0x1130 }
            boolean r3 = r3.zzl()     // Catch:{ all -> 0x1130 }
            if (r3 != 0) goto L_0x060b
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r3 = (com.google.android.gms.internal.measurement.zzfn.zzh) r3     // Catch:{ all -> 0x1130 }
            boolean r3 = r3.zzj()     // Catch:{ all -> 0x1130 }
            if (r3 != 0) goto L_0x060b
            com.google.android.gms.measurement.internal.zzfw r2 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzv()     // Catch:{ all -> 0x1130 }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x1130 }
            r14.zza((int) r5)     // Catch:{ all -> 0x1130 }
            zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14, (java.lang.String) r11)     // Catch:{ all -> 0x1130 }
            r2 = 18
            zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14, (int) r2, (java.lang.String) r12)     // Catch:{ all -> 0x1130 }
            goto L_0x0658
        L_0x060b:
            r3 = -1
            if (r7 != r3) goto L_0x0611
            r2 = 1
            r8 = 3
            goto L_0x063d
        L_0x0611:
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r2 = (com.google.android.gms.internal.measurement.zzfn.zzh) r2     // Catch:{ all -> 0x1130 }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x1130 }
            int r7 = r2.length()     // Catch:{ all -> 0x1130 }
            r8 = 3
            if (r7 == r8) goto L_0x0624
        L_0x0622:
            r2 = 1
            goto L_0x063d
        L_0x0624:
            r7 = 0
        L_0x0625:
            int r12 = r2.length()     // Catch:{ all -> 0x1130 }
            if (r7 >= r12) goto L_0x063c
            int r12 = r2.codePointAt(r7)     // Catch:{ all -> 0x1130 }
            boolean r13 = java.lang.Character.isLetter(r12)     // Catch:{ all -> 0x1130 }
            if (r13 != 0) goto L_0x0636
            goto L_0x0622
        L_0x0636:
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x1130 }
            int r7 = r7 + r12
            goto L_0x0625
        L_0x063c:
            r2 = 0
        L_0x063d:
            if (r2 == 0) goto L_0x065a
            com.google.android.gms.measurement.internal.zzfw r2 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzv()     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r7)     // Catch:{ all -> 0x1130 }
            r14.zza((int) r5)     // Catch:{ all -> 0x1130 }
            zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14, (java.lang.String) r11)     // Catch:{ all -> 0x1130 }
            r2 = 19
            zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14, (int) r2, (java.lang.String) r9)     // Catch:{ all -> 0x1130 }
            goto L_0x065a
        L_0x0658:
            r3 = -1
        L_0x0659:
            r8 = 3
        L_0x065a:
            java.lang.String r2 = r14.zze()     // Catch:{ all -> 0x1130 }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x1130 }
            if (r2 == 0) goto L_0x06b7
            r41.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r2 = r14.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r2 = (com.google.android.gms.internal.measurement.zzfn.zzf) r2     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r2 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r2, (java.lang.String) r15)     // Catch:{ all -> 0x1130 }
            if (r2 != 0) goto L_0x06b2
            if (r6 == 0) goto L_0x06a7
            long r9 = r6.zzc()     // Catch:{ all -> 0x1130 }
            long r11 = r14.zzc()     // Catch:{ all -> 0x1130 }
            long r9 = r9 - r11
            long r9 = java.lang.Math.abs(r9)     // Catch:{ all -> 0x1130 }
            r11 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x06a7
            java.lang.Object r2 = r6.clone()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r2 = (com.google.android.gms.internal.measurement.zzjk.zzb) r2     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2     // Catch:{ all -> 0x1130 }
            boolean r5 = r1.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2)     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x06a7
            r5 = r25
            r7 = r26
            r5.zza((int) r7, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2)     // Catch:{ all -> 0x1130 }
            r13 = r7
            r12 = r24
        L_0x06a2:
            r6 = 0
            r17 = 0
            goto L_0x0710
        L_0x06a7:
            r5 = r25
            r7 = r26
            r12 = r44
            r13 = r7
            r17 = r14
            goto L_0x0710
        L_0x06b2:
            r5 = r25
            r7 = r26
            goto L_0x070c
        L_0x06b7:
            r5 = r25
            r7 = r26
            java.lang.String r2 = "_vs"
            java.lang.String r9 = r14.zze()     // Catch:{ all -> 0x1130 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x1130 }
            if (r2 == 0) goto L_0x070c
            r41.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r2 = r14.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r2 = (com.google.android.gms.internal.measurement.zzfn.zzf) r2     // Catch:{ all -> 0x1130 }
            r9 = r18
            com.google.android.gms.internal.measurement.zzfn$zzh r2 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r2, (java.lang.String) r9)     // Catch:{ all -> 0x1130 }
            if (r2 != 0) goto L_0x070c
            if (r17 == 0) goto L_0x0705
            long r9 = r17.zzc()     // Catch:{ all -> 0x1130 }
            long r11 = r14.zzc()     // Catch:{ all -> 0x1130 }
            long r9 = r9 - r11
            long r9 = java.lang.Math.abs(r9)     // Catch:{ all -> 0x1130 }
            r11 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x0705
            java.lang.Object r2 = r17.clone()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r2 = (com.google.android.gms.internal.measurement.zzjk.zzb) r2     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2     // Catch:{ all -> 0x1130 }
            boolean r6 = r1.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14)     // Catch:{ all -> 0x1130 }
            if (r6 == 0) goto L_0x0705
            r9 = r24
            r5.zza((int) r9, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2)     // Catch:{ all -> 0x1130 }
            r13 = r7
            r12 = r9
            goto L_0x06a2
        L_0x0705:
            r9 = r24
            r13 = r44
            r12 = r9
            r6 = r14
            goto L_0x0710
        L_0x070c:
            r9 = r24
            r13 = r7
            r12 = r9
        L_0x0710:
            boolean r2 = com.google.android.gms.internal.measurement.zzop.zza()     // Catch:{ all -> 0x1130 }
            if (r2 == 0) goto L_0x0838
            com.google.android.gms.measurement.internal.zzag r2 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzcn     // Catch:{ all -> 0x1130 }
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ all -> 0x1130 }
            if (r2 == 0) goto L_0x0838
            int r2 = r14.zza()     // Catch:{ all -> 0x1130 }
            if (r2 == 0) goto L_0x0838
            r41.zzp()     // Catch:{ all -> 0x1130 }
            java.util.List r2 = r14.zzf()     // Catch:{ all -> 0x1130 }
            android.os.Bundle r2 = com.google.android.gms.measurement.internal.zznl.zza((java.util.List<com.google.android.gms.internal.measurement.zzfn.zzh>) r2)     // Catch:{ all -> 0x1130 }
            r7 = 0
        L_0x0734:
            int r9 = r14.zza()     // Catch:{ all -> 0x1130 }
            if (r7 >= r9) goto L_0x07e4
            com.google.android.gms.internal.measurement.zzfn$zzh r9 = r14.zzb((int) r7)     // Catch:{ all -> 0x1130 }
            java.lang.String r10 = r9.zzg()     // Catch:{ all -> 0x1130 }
            r11 = r22
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x1130 }
            if (r10 == 0) goto L_0x07bb
            java.util.List r10 = r9.zzi()     // Catch:{ all -> 0x1130 }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x1130 }
            if (r10 != 0) goto L_0x07bb
            com.google.android.gms.internal.measurement.zzfn$zzk r10 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1130 }
            java.util.List r9 = r9.zzi()     // Catch:{ all -> 0x1130 }
            int r15 = r9.size()     // Catch:{ all -> 0x1130 }
            android.os.Bundle[] r15 = new android.os.Bundle[r15]     // Catch:{ all -> 0x1130 }
            r3 = 0
        L_0x0765:
            int r8 = r9.size()     // Catch:{ all -> 0x1130 }
            if (r3 >= r8) goto L_0x07b5
            java.lang.Object r8 = r9.get(r3)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r8 = (com.google.android.gms.internal.measurement.zzfn.zzh) r8     // Catch:{ all -> 0x1130 }
            r41.zzp()     // Catch:{ all -> 0x1130 }
            java.util.List r18 = r8.zzi()     // Catch:{ all -> 0x1130 }
            r19 = r6
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zznl.zza((java.util.List<com.google.android.gms.internal.measurement.zzfn.zzh>) r18)     // Catch:{ all -> 0x1130 }
            java.util.List r8 = r8.zzi()     // Catch:{ all -> 0x1130 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x1130 }
        L_0x0786:
            boolean r18 = r8.hasNext()     // Catch:{ all -> 0x1130 }
            if (r18 == 0) goto L_0x07aa
            java.lang.Object r18 = r8.next()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r18 = (com.google.android.gms.internal.measurement.zzfn.zzh) r18     // Catch:{ all -> 0x1130 }
            r20 = r8
            java.lang.String r8 = r14.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r18 = r18.zzcc()     // Catch:{ all -> 0x1130 }
            r22 = r9
            r9 = r18
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r9 = (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r9     // Catch:{ all -> 0x1130 }
            r1.zza((java.lang.String) r8, (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r9, (android.os.Bundle) r6, (java.lang.String) r10)     // Catch:{ all -> 0x1130 }
            r8 = r20
            r9 = r22
            goto L_0x0786
        L_0x07aa:
            r22 = r9
            r15[r3] = r6     // Catch:{ all -> 0x1130 }
            int r3 = r3 + 1
            r6 = r19
            r9 = r22
            goto L_0x0765
        L_0x07b5:
            r19 = r6
            r2.putParcelableArray(r11, r15)     // Catch:{ all -> 0x1130 }
            goto L_0x07da
        L_0x07bb:
            r19 = r6
            java.lang.String r3 = r9.zzg()     // Catch:{ all -> 0x1130 }
            boolean r3 = r3.equals(r11)     // Catch:{ all -> 0x1130 }
            if (r3 != 0) goto L_0x07da
            java.lang.String r3 = r14.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r6 = r9.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r6 = (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r6     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1130 }
            r1.zza((java.lang.String) r3, (com.google.android.gms.internal.measurement.zzfn.zzh.zza) r6, (android.os.Bundle) r2, (java.lang.String) r8)     // Catch:{ all -> 0x1130 }
        L_0x07da:
            int r7 = r7 + 1
            r22 = r11
            r6 = r19
            r3 = -1
            r8 = 3
            goto L_0x0734
        L_0x07e4:
            r19 = r6
            r11 = r22
            r14.zzd()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznl r3 = r41.zzp()     // Catch:{ all -> 0x1130 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x1130 }
            r6.<init>()     // Catch:{ all -> 0x1130 }
            java.util.Set r7 = r2.keySet()     // Catch:{ all -> 0x1130 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x1130 }
        L_0x07fc:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x0825
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r9 = com.google.android.gms.internal.measurement.zzfn.zzh.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r9 = r9.zza((java.lang.String) r8)     // Catch:{ all -> 0x1130 }
            java.lang.Object r8 = r2.get(r8)     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x07fc
            r3.zza((com.google.android.gms.internal.measurement.zzfn.zzh.zza) r9, (java.lang.Object) r8)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r8 = r9.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r8 = (com.google.android.gms.internal.measurement.zzjk) r8     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r8 = (com.google.android.gms.internal.measurement.zzfn.zzh) r8     // Catch:{ all -> 0x1130 }
            r6.add(r8)     // Catch:{ all -> 0x1130 }
            goto L_0x07fc
        L_0x0825:
            int r2 = r6.size()     // Catch:{ all -> 0x1130 }
            r3 = 0
        L_0x082a:
            if (r3 >= r2) goto L_0x083c
            java.lang.Object r7 = r6.get(r3)     // Catch:{ all -> 0x1130 }
            int r3 = r3 + 1
            com.google.android.gms.internal.measurement.zzfn$zzh r7 = (com.google.android.gms.internal.measurement.zzfn.zzh) r7     // Catch:{ all -> 0x1130 }
            r14.zza((com.google.android.gms.internal.measurement.zzfn.zzh) r7)     // Catch:{ all -> 0x1130 }
            goto L_0x082a
        L_0x0838:
            r19 = r6
            r11 = r22
        L_0x083c:
            java.util.List<com.google.android.gms.internal.measurement.zzfn$zzf> r2 = r4.zzc     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r3 = r14.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r3 = (com.google.android.gms.internal.measurement.zzjk) r3     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r3 = (com.google.android.gms.internal.measurement.zzfn.zzf) r3     // Catch:{ all -> 0x1130 }
            r6 = r21
            r2.set(r6, r3)     // Catch:{ all -> 0x1130 }
            int r2 = r44 + 1
            r5.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r14)     // Catch:{ all -> 0x1130 }
            r10 = r16
            r7 = r17
            r8 = r19
        L_0x0856:
            int r9 = r6 + 1
            r3 = r11
            r11 = r2
            r2 = r23
            goto L_0x0254
        L_0x085e:
            r9 = r18
            r2 = 0
            r6 = r44
            r12 = r2
            r7 = 0
        L_0x0866:
            if (r7 >= r6) goto L_0x08b3
            com.google.android.gms.internal.measurement.zzfn$zzf r8 = r5.zza((int) r7)     // Catch:{ all -> 0x1130 }
            java.lang.String r14 = r8.zzg()     // Catch:{ all -> 0x1130 }
            boolean r14 = r10.equals(r14)     // Catch:{ all -> 0x1130 }
            if (r14 == 0) goto L_0x0887
            r41.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r14 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r8, (java.lang.String) r15)     // Catch:{ all -> 0x1130 }
            if (r14 == 0) goto L_0x0887
            r5.zzb((int) r7)     // Catch:{ all -> 0x1130 }
            int r6 = r6 + -1
            int r7 = r7 + -1
            goto L_0x08b0
        L_0x0887:
            r41.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r8 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf) r8, (java.lang.String) r9)     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x08b0
            boolean r14 = r8.zzl()     // Catch:{ all -> 0x1130 }
            if (r14 == 0) goto L_0x089f
            long r17 = r8.zzd()     // Catch:{ all -> 0x1130 }
            java.lang.Long r8 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x1130 }
            goto L_0x08a0
        L_0x089f:
            r8 = 0
        L_0x08a0:
            if (r8 == 0) goto L_0x08b0
            long r17 = r8.longValue()     // Catch:{ all -> 0x1130 }
            int r14 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r14 <= 0) goto L_0x08b0
            long r17 = r8.longValue()     // Catch:{ all -> 0x1130 }
            long r12 = r12 + r17
        L_0x08b0:
            r8 = 1
            int r7 = r7 + r8
            goto L_0x0866
        L_0x08b3:
            r6 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5, (long) r12, (boolean) r6)     // Catch:{ all -> 0x1130 }
            java.util.List r6 = r5.zzaa()     // Catch:{ all -> 0x1130 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x1130 }
        L_0x08bf:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x08d9
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r7 = (com.google.android.gms.internal.measurement.zzfn.zzf) r7     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = "_s"
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x1130 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x08bf
            r6 = 1
            goto L_0x08da
        L_0x08d9:
            r6 = 0
        L_0x08da:
            java.lang.String r7 = "_se"
            if (r6 == 0) goto L_0x08e9
            com.google.android.gms.measurement.internal.zzal r6 = r41.zzf()     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r5.zzt()     // Catch:{ all -> 0x1130 }
            r6.zzh(r8, r7)     // Catch:{ all -> 0x1130 }
        L_0x08e9:
            java.lang.String r6 = "_sid"
            int r6 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5, (java.lang.String) r6)     // Catch:{ all -> 0x1130 }
            if (r6 < 0) goto L_0x08f3
            r6 = 1
            goto L_0x08f4
        L_0x08f3:
            r6 = 0
        L_0x08f4:
            if (r6 == 0) goto L_0x08fb
            r6 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5, (long) r12, (boolean) r6)     // Catch:{ all -> 0x1130 }
            goto L_0x091b
        L_0x08fb:
            int r6 = com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5, (java.lang.String) r7)     // Catch:{ all -> 0x1130 }
            if (r6 < 0) goto L_0x091b
            r5.zzc((int) r6)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfw r6 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzg()     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x1130 }
            r6.zza(r7, r8)     // Catch:{ all -> 0x1130 }
        L_0x091b:
            com.google.android.gms.measurement.internal.zznl r6 = r41.zzp()     // Catch:{ all -> 0x1130 }
            r6.zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzhc r7 = r41.zzl()     // Catch:{ all -> 0x1130 }
            r7.zzt()     // Catch:{ all -> 0x1130 }
            r41.zzs()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r7 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zze(r6)     // Catch:{ all -> 0x1130 }
            if (r7 != 0) goto L_0x094e
            com.google.android.gms.measurement.internal.zzfw r7 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzg()     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = "Cannot fix consent fields without appInfo. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r6)     // Catch:{ all -> 0x1130 }
            r7.zza(r8, r6)     // Catch:{ all -> 0x1130 }
            goto L_0x0951
        L_0x094e:
            r1.zza((com.google.android.gms.measurement.internal.zzg) r7, (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5)     // Catch:{ all -> 0x1130 }
        L_0x0951:
            boolean r6 = com.google.android.gms.internal.measurement.zzoj.zza()     // Catch:{ all -> 0x1130 }
            if (r6 == 0) goto L_0x0992
            com.google.android.gms.measurement.internal.zzag r6 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzcm     // Catch:{ all -> 0x1130 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ all -> 0x1130 }
            if (r6 == 0) goto L_0x0992
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzhc r7 = r41.zzl()     // Catch:{ all -> 0x1130 }
            r7.zzt()     // Catch:{ all -> 0x1130 }
            r41.zzs()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r7 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zze(r6)     // Catch:{ all -> 0x1130 }
            if (r7 != 0) goto L_0x098f
            com.google.android.gms.measurement.internal.zzfw r7 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzu()     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = "Cannot populate ad_campaign_info without appInfo. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r6)     // Catch:{ all -> 0x1130 }
            r7.zza(r8, r6)     // Catch:{ all -> 0x1130 }
            goto L_0x0992
        L_0x098f:
            r1.zzb((com.google.android.gms.measurement.internal.zzg) r7, (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5)     // Catch:{ all -> 0x1130 }
        L_0x0992:
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r6 = r5.zzi((long) r6)     // Catch:{ all -> 0x1130 }
            r7 = -9223372036854775808
            r6.zze((long) r7)     // Catch:{ all -> 0x1130 }
            r6 = 0
        L_0x09a1:
            int r7 = r5.zzc()     // Catch:{ all -> 0x1130 }
            if (r6 >= r7) goto L_0x09d4
            com.google.android.gms.internal.measurement.zzfn$zzf r7 = r5.zza((int) r6)     // Catch:{ all -> 0x1130 }
            long r8 = r7.zzd()     // Catch:{ all -> 0x1130 }
            long r12 = r5.zzf()     // Catch:{ all -> 0x1130 }
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 >= 0) goto L_0x09be
            long r8 = r7.zzd()     // Catch:{ all -> 0x1130 }
            r5.zzi((long) r8)     // Catch:{ all -> 0x1130 }
        L_0x09be:
            long r8 = r7.zzd()     // Catch:{ all -> 0x1130 }
            long r12 = r5.zze()     // Catch:{ all -> 0x1130 }
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x09d1
            long r7 = r7.zzd()     // Catch:{ all -> 0x1130 }
            r5.zze((long) r7)     // Catch:{ all -> 0x1130 }
        L_0x09d1:
            int r6 = r6 + 1
            goto L_0x09a1
        L_0x09d4:
            r5.zzs()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r6 = com.google.android.gms.measurement.internal.zzin.zza     // Catch:{ all -> 0x1130 }
            boolean r7 = com.google.android.gms.internal.measurement.zznk.zza()     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x0a54
            com.google.android.gms.measurement.internal.zzag r7 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbf.zzcv     // Catch:{ all -> 0x1130 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r8)     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x0a54
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r6 = r1.zzb((java.lang.String) r6)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r7 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = r7.zzae()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r7 = com.google.android.gms.measurement.internal.zzin.zzb((java.lang.String) r7)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r6 = r6.zza((com.google.android.gms.measurement.internal.zzin) r7)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r7 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r7 = r7.zzh(r8)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r8 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r9 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r9.zzz()     // Catch:{ all -> 0x1130 }
            r8.zza((java.lang.String) r9, (com.google.android.gms.measurement.internal.zzin) r6)     // Catch:{ all -> 0x1130 }
            boolean r8 = r6.zzj()     // Catch:{ all -> 0x1130 }
            if (r8 != 0) goto L_0x0a38
            boolean r8 = r7.zzj()     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x0a38
            com.google.android.gms.measurement.internal.zzal r7 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1130 }
            r7.zzo(r8)     // Catch:{ all -> 0x1130 }
            goto L_0x0a51
        L_0x0a38:
            boolean r8 = r6.zzj()     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x0a51
            boolean r7 = r7.zzj()     // Catch:{ all -> 0x1130 }
            if (r7 != 0) goto L_0x0a51
            com.google.android.gms.measurement.internal.zzal r7 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1130 }
            r7.zzp(r8)     // Catch:{ all -> 0x1130 }
        L_0x0a51:
            zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5, (com.google.android.gms.measurement.internal.zzin) r6)     // Catch:{ all -> 0x1130 }
        L_0x0a54:
            com.google.android.gms.measurement.internal.zzag r7 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbf.zzcd     // Catch:{ all -> 0x1130 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r8)     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x0a7b
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r6 = r1.zzb((java.lang.String) r6)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzae()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r8 = com.google.android.gms.measurement.internal.zzin.zzb((java.lang.String) r8)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r6 = r6.zza((com.google.android.gms.measurement.internal.zzin) r8)     // Catch:{ all -> 0x1130 }
            zza((com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5, (com.google.android.gms.measurement.internal.zzin) r6)     // Catch:{ all -> 0x1130 }
        L_0x0a7b:
            boolean r8 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x0aac
            com.google.android.gms.measurement.internal.zzag r8 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r9 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r9.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzbf.zzbz     // Catch:{ all -> 0x1130 }
            boolean r8 = r8.zze(r9, r10)     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x0aac
            r41.zzq()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r8.zzz()     // Catch:{ all -> 0x1130 }
            boolean r8 = com.google.android.gms.measurement.internal.zznp.zzd(r8)     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x0aac
            com.google.android.gms.internal.measurement.zzfn$zzk r8 = r4.zza     // Catch:{ all -> 0x1130 }
            boolean r8 = r8.zzat()     // Catch:{ all -> 0x1130 }
            if (r8 == 0) goto L_0x0aac
            r8 = 1
            goto L_0x0aad
        L_0x0aac:
            r8 = 0
        L_0x0aad:
            if (r7 != 0) goto L_0x0ac5
            if (r8 == 0) goto L_0x0ac3
            com.google.android.gms.internal.measurement.zzfn$zzk r7 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzin r7 = r1.zzb((java.lang.String) r7)     // Catch:{ all -> 0x1130 }
            boolean r7 = r7.zzi()     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x0ac3
            r7 = 1
            goto L_0x0ac4
        L_0x0ac3:
            r7 = 0
        L_0x0ac4:
            r8 = r7
        L_0x0ac5:
            if (r8 == 0) goto L_0x0baf
            r7 = 0
        L_0x0ac8:
            int r8 = r5.zzc()     // Catch:{ all -> 0x1130 }
            if (r7 >= r8) goto L_0x0baf
            com.google.android.gms.internal.measurement.zzfn$zzf r8 = r5.zza((int) r7)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r8 = r8.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r8 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r8     // Catch:{ all -> 0x1130 }
            java.util.List r9 = r8.zzf()     // Catch:{ all -> 0x1130 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x1130 }
        L_0x0ae0:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x1130 }
            if (r10 == 0) goto L_0x0af8
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r10 = (com.google.android.gms.internal.measurement.zzfn.zzh) r10     // Catch:{ all -> 0x1130 }
            java.lang.String r10 = r10.zzg()     // Catch:{ all -> 0x1130 }
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x1130 }
            if (r10 == 0) goto L_0x0ae0
            r9 = 1
            goto L_0x0af9
        L_0x0af8:
            r9 = 0
        L_0x0af9:
            if (r9 == 0) goto L_0x0bab
            com.google.android.gms.internal.measurement.zzfn$zzk r9 = r4.zza     // Catch:{ all -> 0x1130 }
            int r9 = r9.zza()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzag r10 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r12 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = r12.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzbf.zzav     // Catch:{ all -> 0x1130 }
            int r10 = r10.zzb((java.lang.String) r12, (com.google.android.gms.measurement.internal.zzfj<java.lang.Integer>) r13)     // Catch:{ all -> 0x1130 }
            if (r9 < r10) goto L_0x0ba0
            com.google.android.gms.measurement.internal.zzag r9 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r10 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzbf.zzcb     // Catch:{ all -> 0x1130 }
            boolean r9 = r9.zze(r10, r12)     // Catch:{ all -> 0x1130 }
            if (r9 == 0) goto L_0x0b47
            com.google.android.gms.measurement.internal.zznp r9 = r41.zzq()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r9.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r10 = com.google.android.gms.internal.measurement.zzfn.zzh.zze()     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = "_tu"
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r10 = r10.zza((java.lang.String) r12)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r10 = r10.zzb(r9)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r10 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r10 = (com.google.android.gms.internal.measurement.zzjk) r10     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r10 = (com.google.android.gms.internal.measurement.zzfn.zzh) r10     // Catch:{ all -> 0x1130 }
            r8.zza((com.google.android.gms.internal.measurement.zzfn.zzh) r10)     // Catch:{ all -> 0x1130 }
            goto L_0x0b48
        L_0x0b47:
            r9 = 0
        L_0x0b48:
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r10 = com.google.android.gms.internal.measurement.zzfn.zzh.zze()     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = "_tr"
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r10 = r10.zza((java.lang.String) r12)     // Catch:{ all -> 0x1130 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzfn$zzh$zza r10 = r10.zza((long) r12)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r10 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r10 = (com.google.android.gms.internal.measurement.zzjk) r10     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r10 = (com.google.android.gms.internal.measurement.zzfn.zzh) r10     // Catch:{ all -> 0x1130 }
            r8.zza((com.google.android.gms.internal.measurement.zzfn.zzh) r10)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznl r10 = r41.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r12 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = r12.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzmu r9 = r10.zza((java.lang.String) r12, (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r5, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r8, (java.lang.String) r9)     // Catch:{ all -> 0x1130 }
            if (r9 == 0) goto L_0x0ba0
            com.google.android.gms.measurement.internal.zzfw r10 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r10 = r10.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = "Generated trigger URI. appId, uri"
            com.google.android.gms.internal.measurement.zzfn$zzk r13 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r13 = r13.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.String r14 = r9.zza     // Catch:{ all -> 0x1130 }
            r10.zza(r12, r13, r14)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r10 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r12 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = r12.zzz()     // Catch:{ all -> 0x1130 }
            r10.zza((java.lang.String) r12, (com.google.android.gms.measurement.internal.zzmu) r9)     // Catch:{ all -> 0x1130 }
            java.util.Set<java.lang.String> r9 = r1.zzr     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r10 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r10 = r10.zzz()     // Catch:{ all -> 0x1130 }
            r9.add(r10)     // Catch:{ all -> 0x1130 }
        L_0x0ba0:
            com.google.android.gms.internal.measurement.zzkt r8 = r8.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r8 = (com.google.android.gms.internal.measurement.zzjk) r8     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r8 = (com.google.android.gms.internal.measurement.zzfn.zzf) r8     // Catch:{ all -> 0x1130 }
            r5.zza((int) r7, (com.google.android.gms.internal.measurement.zzfn.zzf) r8)     // Catch:{ all -> 0x1130 }
        L_0x0bab:
            int r7 = r7 + 1
            goto L_0x0ac8
        L_0x0baf:
            boolean r7 = com.google.android.gms.internal.measurement.zznk.zza()     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x0bf6
            com.google.android.gms.measurement.internal.zzag r7 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbf.zzcv     // Catch:{ all -> 0x1130 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r8)     // Catch:{ all -> 0x1130 }
            if (r7 == 0) goto L_0x0bf6
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r7 = r5.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzu r8 = r41.zzc()     // Catch:{ all -> 0x1130 }
            java.lang.String r9 = r5.zzt()     // Catch:{ all -> 0x1130 }
            java.util.List r10 = r5.zzaa()     // Catch:{ all -> 0x1130 }
            java.util.List r11 = r5.zzab()     // Catch:{ all -> 0x1130 }
            long r12 = r5.zzf()     // Catch:{ all -> 0x1130 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x1130 }
            long r13 = r5.zze()     // Catch:{ all -> 0x1130 }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x1130 }
            boolean r6 = r6.zzj()     // Catch:{ all -> 0x1130 }
            if (r6 != 0) goto L_0x0bed
            r14 = 1
            goto L_0x0bee
        L_0x0bed:
            r14 = 0
        L_0x0bee:
            java.util.List r6 = r8.zza(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x1130 }
            r7.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfn.zzd>) r6)     // Catch:{ all -> 0x1130 }
            goto L_0x0c21
        L_0x0bf6:
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r6 = r5.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzu r7 = r41.zzc()     // Catch:{ all -> 0x1130 }
            java.lang.String r8 = r5.zzt()     // Catch:{ all -> 0x1130 }
            java.util.List r9 = r5.zzaa()     // Catch:{ all -> 0x1130 }
            java.util.List r10 = r5.zzab()     // Catch:{ all -> 0x1130 }
            long r11 = r5.zzf()     // Catch:{ all -> 0x1130 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1130 }
            long r12 = r5.zze()     // Catch:{ all -> 0x1130 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x1130 }
            java.util.List r7 = r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x1130 }
            r6.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfn.zzd>) r7)     // Catch:{ all -> 0x1130 }
        L_0x0c21:
            com.google.android.gms.measurement.internal.zzag r6 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r7 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r7 = r7.zzz()     // Catch:{ all -> 0x1130 }
            boolean r6 = r6.zzk(r7)     // Catch:{ all -> 0x1130 }
            if (r6 == 0) goto L_0x0f61
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x1130 }
            r6.<init>()     // Catch:{ all -> 0x1130 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x1130 }
            r7.<init>()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznp r8 = r41.zzq()     // Catch:{ all -> 0x1130 }
            java.security.SecureRandom r8 = r8.zzv()     // Catch:{ all -> 0x1130 }
            r9 = 0
        L_0x0c44:
            int r10 = r5.zzc()     // Catch:{ all -> 0x1130 }
            if (r9 >= r10) goto L_0x0f2a
            com.google.android.gms.internal.measurement.zzfn$zzf r10 = r5.zza((int) r9)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk$zzb r10 = r10.zzcc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r10 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10     // Catch:{ all -> 0x1130 }
            java.lang.String r11 = r10.zze()     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x1130 }
            java.lang.String r12 = "_sr"
            if (r11 == 0) goto L_0x0ce1
            r41.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r11 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r11 = (com.google.android.gms.internal.measurement.zzjk) r11     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r11 = (com.google.android.gms.internal.measurement.zzfn.zzf) r11     // Catch:{ all -> 0x1130 }
            java.lang.String r13 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zznl.zzb(r11, r13)     // Catch:{ all -> 0x1130 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x1130 }
            java.lang.Object r13 = r6.get(r11)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r13 = (com.google.android.gms.measurement.internal.zzaz) r13     // Catch:{ all -> 0x1130 }
            if (r13 != 0) goto L_0x0c96
            com.google.android.gms.measurement.internal.zzal r13 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r14 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r14 = r14.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.Object r15 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x1130 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r13 = r13.zzd(r14, r15)     // Catch:{ all -> 0x1130 }
            if (r13 == 0) goto L_0x0c96
            r6.put(r11, r13)     // Catch:{ all -> 0x1130 }
        L_0x0c96:
            if (r13 == 0) goto L_0x0cd5
            java.lang.Long r11 = r13.zzi     // Catch:{ all -> 0x1130 }
            if (r11 != 0) goto L_0x0cd5
            java.lang.Long r11 = r13.zzj     // Catch:{ all -> 0x1130 }
            if (r11 == 0) goto L_0x0cb2
            long r14 = r11.longValue()     // Catch:{ all -> 0x1130 }
            r17 = 1
            int r11 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x0cb2
            r41.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.Long r11 = r13.zzj     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10, (java.lang.String) r12, (java.lang.Object) r11)     // Catch:{ all -> 0x1130 }
        L_0x0cb2:
            java.lang.Boolean r11 = r13.zzk     // Catch:{ all -> 0x1130 }
            if (r11 == 0) goto L_0x0cca
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x1130 }
            if (r11 == 0) goto L_0x0cca
            r41.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.String r11 = "_efs"
            r12 = 1
            java.lang.Long r14 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10, (java.lang.String) r11, (java.lang.Object) r14)     // Catch:{ all -> 0x1130 }
        L_0x0cca:
            com.google.android.gms.internal.measurement.zzkt r11 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r11 = (com.google.android.gms.internal.measurement.zzjk) r11     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r11 = (com.google.android.gms.internal.measurement.zzfn.zzf) r11     // Catch:{ all -> 0x1130 }
            r7.add(r11)     // Catch:{ all -> 0x1130 }
        L_0x0cd5:
            r5.zza((int) r9, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10)     // Catch:{ all -> 0x1130 }
        L_0x0cd8:
            r15 = r4
            r1 = r5
            r44 = r8
            r2 = r9
            r8 = 1
            goto L_0x0f1d
        L_0x0ce1:
            com.google.android.gms.measurement.internal.zzgt r11 = r41.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r13 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r13 = r13.zzz()     // Catch:{ all -> 0x1130 }
            long r13 = r11.zza((java.lang.String) r13)     // Catch:{ all -> 0x1130 }
            r41.zzq()     // Catch:{ all -> 0x1130 }
            long r2 = r10.zzc()     // Catch:{ all -> 0x1130 }
            long r2 = com.google.android.gms.measurement.internal.zznp.zza((long) r2, (long) r13)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r11 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r11 = (com.google.android.gms.internal.measurement.zzjk) r11     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r11 = (com.google.android.gms.internal.measurement.zzfn.zzf) r11     // Catch:{ all -> 0x1130 }
            java.lang.String r15 = "_dbg"
            r17 = 1
            java.lang.Long r1 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x1130 }
            boolean r17 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x1130 }
            if (r17 != 0) goto L_0x0d66
            if (r1 != 0) goto L_0x0d13
            goto L_0x0d66
        L_0x0d13:
            java.util.List r11 = r11.zzh()     // Catch:{ all -> 0x1130 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x1130 }
        L_0x0d1b:
            boolean r17 = r11.hasNext()     // Catch:{ all -> 0x1130 }
            if (r17 == 0) goto L_0x0d66
            java.lang.Object r17 = r11.next()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzh r17 = (com.google.android.gms.internal.measurement.zzfn.zzh) r17     // Catch:{ all -> 0x1130 }
            r44 = r11
            java.lang.String r11 = r17.zzg()     // Catch:{ all -> 0x1130 }
            boolean r11 = r15.equals(r11)     // Catch:{ all -> 0x1130 }
            if (r11 == 0) goto L_0x0d63
            long r21 = r17.zzd()     // Catch:{ all -> 0x1130 }
            java.lang.Long r11 = java.lang.Long.valueOf(r21)     // Catch:{ all -> 0x1130 }
            boolean r11 = r1.equals(r11)     // Catch:{ all -> 0x1130 }
            if (r11 != 0) goto L_0x0d61
            boolean r11 = r1 instanceof java.lang.String     // Catch:{ all -> 0x1130 }
            if (r11 == 0) goto L_0x0d4f
            java.lang.String r11 = r17.zzh()     // Catch:{ all -> 0x1130 }
            boolean r11 = r1.equals(r11)     // Catch:{ all -> 0x1130 }
            if (r11 != 0) goto L_0x0d61
        L_0x0d4f:
            boolean r11 = r1 instanceof java.lang.Double     // Catch:{ all -> 0x1130 }
            if (r11 == 0) goto L_0x0d66
            double r17 = r17.zza()     // Catch:{ all -> 0x1130 }
            java.lang.Double r11 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x1130 }
            boolean r1 = r1.equals(r11)     // Catch:{ all -> 0x1130 }
            if (r1 == 0) goto L_0x0d66
        L_0x0d61:
            r1 = 1
            goto L_0x0d67
        L_0x0d63:
            r11 = r44
            goto L_0x0d1b
        L_0x0d66:
            r1 = 0
        L_0x0d67:
            if (r1 != 0) goto L_0x0d7c
            com.google.android.gms.measurement.internal.zzgt r1 = r41.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r11 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r11 = r11.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.String r15 = r10.zze()     // Catch:{ all -> 0x1130 }
            int r1 = r1.zzb((java.lang.String) r11, (java.lang.String) r15)     // Catch:{ all -> 0x1130 }
            goto L_0x0d7d
        L_0x0d7c:
            r1 = 1
        L_0x0d7d:
            if (r1 > 0) goto L_0x0da4
            com.google.android.gms.measurement.internal.zzfw r2 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzu()     // Catch:{ all -> 0x1130 }
            java.lang.String r3 = "Sample rate must be positive. event, rate"
            java.lang.String r11 = r10.zze()     // Catch:{ all -> 0x1130 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x1130 }
            r2.zza(r3, r11, r1)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r1 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r1 = (com.google.android.gms.internal.measurement.zzjk) r1     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r1 = (com.google.android.gms.internal.measurement.zzfn.zzf) r1     // Catch:{ all -> 0x1130 }
            r7.add(r1)     // Catch:{ all -> 0x1130 }
            r5.zza((int) r9, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10)     // Catch:{ all -> 0x1130 }
            goto L_0x0cd8
        L_0x0da4:
            java.lang.String r11 = r10.zze()     // Catch:{ all -> 0x1130 }
            java.lang.Object r11 = r6.get(r11)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r11 = (com.google.android.gms.measurement.internal.zzaz) r11     // Catch:{ all -> 0x1130 }
            if (r11 != 0) goto L_0x0e03
            com.google.android.gms.measurement.internal.zzal r11 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r15 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r15 = r15.zzz()     // Catch:{ all -> 0x1130 }
            r17 = r13
            java.lang.String r13 = r10.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r11 = r11.zzd(r15, r13)     // Catch:{ all -> 0x1130 }
            if (r11 != 0) goto L_0x0e05
            com.google.android.gms.measurement.internal.zzfw r11 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r11 = r11.zzu()     // Catch:{ all -> 0x1130 }
            java.lang.String r13 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzfn$zzk r14 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r14 = r14.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.String r15 = r10.zze()     // Catch:{ all -> 0x1130 }
            r11.zza(r13, r14, r15)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r11 = new com.google.android.gms.measurement.internal.zzaz     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r13 = r4.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r25 = r13.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.String r26 = r10.zze()     // Catch:{ all -> 0x1130 }
            r27 = 1
            r29 = 1
            r31 = 1
            long r33 = r10.zzc()     // Catch:{ all -> 0x1130 }
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r24 = r11
            r24.<init>(r25, r26, r27, r29, r31, r33, r35, r37, r38, r39, r40)     // Catch:{ all -> 0x1130 }
            goto L_0x0e05
        L_0x0e03:
            r17 = r13
        L_0x0e05:
            r41.zzp()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r13 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r13 = (com.google.android.gms.internal.measurement.zzjk) r13     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r13 = (com.google.android.gms.internal.measurement.zzfn.zzf) r13     // Catch:{ all -> 0x1130 }
            java.lang.String r14 = "_eid"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zznl.zzb(r13, r14)     // Catch:{ all -> 0x1130 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x1130 }
            if (r13 == 0) goto L_0x0e1c
            r14 = 1
            goto L_0x0e1d
        L_0x0e1c:
            r14 = 0
        L_0x0e1d:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x1130 }
            r15 = 1
            if (r1 != r15) goto L_0x0e52
            com.google.android.gms.internal.measurement.zzkt r1 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r1 = (com.google.android.gms.internal.measurement.zzjk) r1     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r1 = (com.google.android.gms.internal.measurement.zzfn.zzf) r1     // Catch:{ all -> 0x1130 }
            r7.add(r1)     // Catch:{ all -> 0x1130 }
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x1130 }
            if (r1 == 0) goto L_0x0e4d
            java.lang.Long r1 = r11.zzi     // Catch:{ all -> 0x1130 }
            if (r1 != 0) goto L_0x0e41
            java.lang.Long r1 = r11.zzj     // Catch:{ all -> 0x1130 }
            if (r1 != 0) goto L_0x0e41
            java.lang.Boolean r1 = r11.zzk     // Catch:{ all -> 0x1130 }
            if (r1 == 0) goto L_0x0e4d
        L_0x0e41:
            r1 = 0
            com.google.android.gms.measurement.internal.zzaz r2 = r11.zza(r1, r1, r1)     // Catch:{ all -> 0x1130 }
            java.lang.String r1 = r10.zze()     // Catch:{ all -> 0x1130 }
            r6.put(r1, r2)     // Catch:{ all -> 0x1130 }
        L_0x0e4d:
            r5.zza((int) r9, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10)     // Catch:{ all -> 0x1130 }
            goto L_0x0cd8
        L_0x0e52:
            int r15 = r8.nextInt(r1)     // Catch:{ all -> 0x1130 }
            if (r15 != 0) goto L_0x0e98
            r41.zzp()     // Catch:{ all -> 0x1130 }
            r15 = r4
            r25 = r5
            long r4 = (long) r1     // Catch:{ all -> 0x1130 }
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10, (java.lang.String) r12, (java.lang.Object) r1)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r1 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r1 = (com.google.android.gms.internal.measurement.zzjk) r1     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r1 = (com.google.android.gms.internal.measurement.zzfn.zzf) r1     // Catch:{ all -> 0x1130 }
            r7.add(r1)     // Catch:{ all -> 0x1130 }
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x1130 }
            if (r1 == 0) goto L_0x0e80
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x1130 }
            r4 = 0
            com.google.android.gms.measurement.internal.zzaz r11 = r11.zza(r4, r1, r4)     // Catch:{ all -> 0x1130 }
        L_0x0e80:
            java.lang.String r1 = r10.zze()     // Catch:{ all -> 0x1130 }
            long r4 = r10.zzc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r2 = r11.zza(r4, r2)     // Catch:{ all -> 0x1130 }
            r6.put(r1, r2)     // Catch:{ all -> 0x1130 }
            r44 = r8
            r2 = r9
            r1 = r25
            r8 = 1
            goto L_0x0f1a
        L_0x0e98:
            r15 = r4
            r25 = r5
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x1130 }
            if (r4 == 0) goto L_0x0ea8
            long r4 = r4.longValue()     // Catch:{ all -> 0x1130 }
            r44 = r8
            r21 = r9
            goto L_0x0eb9
        L_0x0ea8:
            r41.zzq()     // Catch:{ all -> 0x1130 }
            long r4 = r10.zzb()     // Catch:{ all -> 0x1130 }
            r44 = r8
            r21 = r9
            r8 = r17
            long r4 = com.google.android.gms.measurement.internal.zznp.zza((long) r4, (long) r8)     // Catch:{ all -> 0x1130 }
        L_0x0eb9:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0f02
            r41.zzp()     // Catch:{ all -> 0x1130 }
            java.lang.String r4 = "_efs"
            r8 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10, (java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x1130 }
            r41.zzp()     // Catch:{ all -> 0x1130 }
            long r4 = (long) r1     // Catch:{ all -> 0x1130 }
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zznl.zza((com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10, (java.lang.String) r12, (java.lang.Object) r1)     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r1 = r10.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r1 = (com.google.android.gms.internal.measurement.zzjk) r1     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzf r1 = (com.google.android.gms.internal.measurement.zzfn.zzf) r1     // Catch:{ all -> 0x1130 }
            r7.add(r1)     // Catch:{ all -> 0x1130 }
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x1130 }
            if (r1 == 0) goto L_0x0ef2
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x1130 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x1130 }
            r5 = 0
            com.google.android.gms.measurement.internal.zzaz r11 = r11.zza(r5, r1, r4)     // Catch:{ all -> 0x1130 }
        L_0x0ef2:
            java.lang.String r1 = r10.zze()     // Catch:{ all -> 0x1130 }
            long r4 = r10.zzc()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r2 = r11.zza(r4, r2)     // Catch:{ all -> 0x1130 }
            r6.put(r1, r2)     // Catch:{ all -> 0x1130 }
            goto L_0x0f16
        L_0x0f02:
            r8 = 1
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x1130 }
            if (r1 == 0) goto L_0x0f16
            java.lang.String r1 = r10.zze()     // Catch:{ all -> 0x1130 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzaz r3 = r11.zza(r13, r2, r2)     // Catch:{ all -> 0x1130 }
            r6.put(r1, r3)     // Catch:{ all -> 0x1130 }
        L_0x0f16:
            r2 = r21
            r1 = r25
        L_0x0f1a:
            r1.zza((int) r2, (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r10)     // Catch:{ all -> 0x1130 }
        L_0x0f1d:
            int r2 = r2 + 1
            r8 = r44
            r5 = r1
            r9 = r2
            r4 = r15
            r2 = 0
            r1 = r41
            goto L_0x0c44
        L_0x0f2a:
            r15 = r4
            r1 = r5
            int r2 = r7.size()     // Catch:{ all -> 0x1130 }
            int r3 = r1.zzc()     // Catch:{ all -> 0x1130 }
            if (r2 >= r3) goto L_0x0f3d
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r2 = r1.zzl()     // Catch:{ all -> 0x1130 }
            r2.zzb((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzfn.zzf>) r7)     // Catch:{ all -> 0x1130 }
        L_0x0f3d:
            java.util.Set r2 = r6.entrySet()     // Catch:{ all -> 0x1130 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x1130 }
        L_0x0f45:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x1130 }
            if (r3 == 0) goto L_0x0f5f
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x1130 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r4 = r41.zzf()     // Catch:{ all -> 0x1130 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzaz r3 = (com.google.android.gms.measurement.internal.zzaz) r3     // Catch:{ all -> 0x1130 }
            r4.zza((com.google.android.gms.measurement.internal.zzaz) r3)     // Catch:{ all -> 0x1130 }
            goto L_0x0f45
        L_0x0f5f:
            r2 = r15
            goto L_0x0f63
        L_0x0f61:
            r1 = r5
            r2 = r4
        L_0x0f63:
            com.google.android.gms.internal.measurement.zzfn$zzk r3 = r2.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r3 = r3.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r4 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zze(r3)     // Catch:{ all -> 0x1130 }
            if (r4 != 0) goto L_0x0f8c
            com.google.android.gms.measurement.internal.zzfw r4 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzg()     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r2.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r6)     // Catch:{ all -> 0x1130 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x1130 }
            goto L_0x1018
        L_0x0f8c:
            int r5 = r1.zzc()     // Catch:{ all -> 0x1130 }
            if (r5 <= 0) goto L_0x1018
            long r5 = r4.zzs()     // Catch:{ all -> 0x1130 }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0fa0
            r1.zzg((long) r5)     // Catch:{ all -> 0x1130 }
            goto L_0x0fa3
        L_0x0fa0:
            r1.zzo()     // Catch:{ all -> 0x1130 }
        L_0x0fa3:
            long r7 = r4.zzu()     // Catch:{ all -> 0x1130 }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0fae
            goto L_0x0faf
        L_0x0fae:
            r5 = r7
        L_0x0faf:
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0fb7
            r1.zzh((long) r5)     // Catch:{ all -> 0x1130 }
            goto L_0x0fba
        L_0x0fb7:
            r1.zzp()     // Catch:{ all -> 0x1130 }
        L_0x0fba:
            boolean r5 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x0fea
            com.google.android.gms.measurement.internal.zzag r5 = r41.zze()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzbf.zzbs     // Catch:{ all -> 0x1130 }
            boolean r5 = r5.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r6)     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x0fea
            r41.zzq()     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = r4.zzac()     // Catch:{ all -> 0x1130 }
            boolean r5 = com.google.android.gms.measurement.internal.zznp.zzf(r5)     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x0fea
            int r5 = r1.zzc()     // Catch:{ all -> 0x1130 }
            long r5 = (long) r5     // Catch:{ all -> 0x1130 }
            r4.zza((long) r5)     // Catch:{ all -> 0x1130 }
            long r5 = r4.zzr()     // Catch:{ all -> 0x1130 }
            int r5 = (int) r5     // Catch:{ all -> 0x1130 }
            r1.zzg((int) r5)     // Catch:{ all -> 0x1130 }
            goto L_0x0fed
        L_0x0fea:
            r4.zzap()     // Catch:{ all -> 0x1130 }
        L_0x0fed:
            long r5 = r4.zzt()     // Catch:{ all -> 0x1130 }
            int r5 = (int) r5     // Catch:{ all -> 0x1130 }
            r1.zzf((int) r5)     // Catch:{ all -> 0x1130 }
            long r5 = r1.zzf()     // Catch:{ all -> 0x1130 }
            r4.zzr(r5)     // Catch:{ all -> 0x1130 }
            long r5 = r1.zze()     // Catch:{ all -> 0x1130 }
            r4.zzp(r5)     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = r4.zzab()     // Catch:{ all -> 0x1130 }
            if (r5 == 0) goto L_0x100d
            r1.zzn(r5)     // Catch:{ all -> 0x1130 }
            goto L_0x1010
        L_0x100d:
            r1.zzm()     // Catch:{ all -> 0x1130 }
        L_0x1010:
            com.google.android.gms.measurement.internal.zzal r5 = r41.zzf()     // Catch:{ all -> 0x1130 }
            r6 = 0
            r5.zza((com.google.android.gms.measurement.internal.zzg) r4, (boolean) r6, (boolean) r6)     // Catch:{ all -> 0x1130 }
        L_0x1018:
            int r4 = r1.zzc()     // Catch:{ all -> 0x1130 }
            if (r4 <= 0) goto L_0x1077
            com.google.android.gms.measurement.internal.zzgt r4 = r41.zzi()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r5 = r2.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = r5.zzz()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfi$zzd r4 = r4.zzc(r5)     // Catch:{ all -> 0x1130 }
            if (r4 == 0) goto L_0x103d
            boolean r5 = r4.zzs()     // Catch:{ all -> 0x1130 }
            if (r5 != 0) goto L_0x1035
            goto L_0x103d
        L_0x1035:
            long r4 = r4.zzc()     // Catch:{ all -> 0x1130 }
            r1.zzb((long) r4)     // Catch:{ all -> 0x1130 }
            goto L_0x1066
        L_0x103d:
            com.google.android.gms.internal.measurement.zzfn$zzk r4 = r2.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r4 = r4.zzaj()     // Catch:{ all -> 0x1130 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x1130 }
            if (r4 == 0) goto L_0x104f
            r4 = -1
            r1.zzb((long) r4)     // Catch:{ all -> 0x1130 }
            goto L_0x1066
        L_0x104f:
            com.google.android.gms.measurement.internal.zzfw r4 = r41.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzu()     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzfn$zzk r6 = r2.zza     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = r6.zzz()     // Catch:{ all -> 0x1130 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r6)     // Catch:{ all -> 0x1130 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x1130 }
        L_0x1066:
            com.google.android.gms.measurement.internal.zzal r4 = r41.zzf()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzkt r1 = r1.zzai()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzjk r1 = (com.google.android.gms.internal.measurement.zzjk) r1     // Catch:{ all -> 0x1130 }
            com.google.android.gms.internal.measurement.zzfn$zzk r1 = (com.google.android.gms.internal.measurement.zzfn.zzk) r1     // Catch:{ all -> 0x1130 }
            r10 = r16
            r4.zza((com.google.android.gms.internal.measurement.zzfn.zzk) r1, (boolean) r10)     // Catch:{ all -> 0x1130 }
        L_0x1077:
            com.google.android.gms.measurement.internal.zzal r1 = r41.zzf()     // Catch:{ all -> 0x1130 }
            java.util.List<java.lang.Long> r2 = r2.zzb     // Catch:{ all -> 0x1130 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x1130 }
            r1.zzt()     // Catch:{ all -> 0x1130 }
            r1.zzal()     // Catch:{ all -> 0x1130 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = "rowid in ("
            r4.<init>(r5)     // Catch:{ all -> 0x1130 }
            r5 = 0
        L_0x108e:
            int r6 = r2.size()     // Catch:{ all -> 0x1130 }
            if (r5 >= r6) goto L_0x10ab
            if (r5 == 0) goto L_0x109b
            java.lang.String r6 = ","
            r4.append(r6)     // Catch:{ all -> 0x1130 }
        L_0x109b:
            java.lang.Object r6 = r2.get(r5)     // Catch:{ all -> 0x1130 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x1130 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x1130 }
            r4.append(r6)     // Catch:{ all -> 0x1130 }
            int r5 = r5 + 1
            goto L_0x108e
        L_0x10ab:
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ all -> 0x1130 }
            android.database.sqlite.SQLiteDatabase r5 = r1.e_()     // Catch:{ all -> 0x1130 }
            java.lang.String r6 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x1130 }
            r7 = 0
            int r4 = r5.delete(r6, r4, r7)     // Catch:{ all -> 0x1130 }
            int r5 = r2.size()     // Catch:{ all -> 0x1130 }
            if (r4 == r5) goto L_0x10de
            com.google.android.gms.measurement.internal.zzfw r1 = r1.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x1130 }
            java.lang.String r5 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x1130 }
            int r2 = r2.size()     // Catch:{ all -> 0x1130 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x1130 }
            r1.zza(r5, r4, r2)     // Catch:{ all -> 0x1130 }
        L_0x10de:
            com.google.android.gms.measurement.internal.zzal r1 = r41.zzf()     // Catch:{ all -> 0x1130 }
            android.database.sqlite.SQLiteDatabase r2 = r1.e_()     // Catch:{ all -> 0x1130 }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x10f5 }
            r6 = 0
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x10f5 }
            r6 = 1
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x10f5 }
            r2.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x10f5 }
            goto L_0x1108
        L_0x10f5:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzfw r1 = r1.zzj()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x1130 }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r3)     // Catch:{ all -> 0x1130 }
            r1.zza(r4, r3, r2)     // Catch:{ all -> 0x1130 }
        L_0x1108:
            com.google.android.gms.measurement.internal.zzal r1 = r41.zzf()     // Catch:{ all -> 0x1130 }
            r1.zzw()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r1 = r41.zzf()
            r1.zzu()
            r1 = 1
            return r1
        L_0x1118:
            com.google.android.gms.measurement.internal.zzal r1 = r41.zzf()     // Catch:{ all -> 0x1130 }
            r1.zzw()     // Catch:{ all -> 0x1130 }
            com.google.android.gms.measurement.internal.zzal r1 = r41.zzf()
            r1.zzu()
            r1 = 0
            return r1
        L_0x1128:
            r0 = move-exception
            r1 = r0
        L_0x112a:
            if (r5 == 0) goto L_0x112f
            r5.close()     // Catch:{ all -> 0x1130 }
        L_0x112f:
            throw r1     // Catch:{ all -> 0x1130 }
        L_0x1130:
            r0 = move-exception
            r1 = r0
            com.google.android.gms.measurement.internal.zzal r2 = r41.zzf()
            r2.zzu()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznc.zza(java.lang.String, long):boolean");
    }

    private final boolean zza(zzfn.zzf.zza zza2, zzfn.zzf.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zze()));
        zzp();
        zzfn.zzh zza4 = zznl.zza((zzfn.zzf) ((zzjk) zza2.zzai()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzh();
        }
        zzp();
        zzfn.zzh zza5 = zznl.zza((zzfn.zzf) ((zzjk) zza3.zzai()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzh();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zza2.zze()));
        zzp();
        zzfn.zzh zza6 = zznl.zza((zzfn.zzf) ((zzjk) zza2.zzai()), "_et");
        if (zza6 == null || !zza6.zzl() || zza6.zzd() <= 0) {
            return true;
        }
        long zzd2 = zza6.zzd();
        zzp();
        zzfn.zzh zza7 = zznl.zza((zzfn.zzf) ((zzjk) zza3.zzai()), "_et");
        if (zza7 != null && zza7.zzd() > 0) {
            zzd2 += zza7.zzd();
        }
        zzp();
        zznl.zza(zza3, "_et", (Object) Long.valueOf(zzd2));
        zzp();
        zznl.zza(zza2, "_fr", (Object) 1L);
        return true;
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzl().zzt();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzj().zzg().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                zzj().zzg().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            zzj().zzg().zza("Failed to write to channel", e);
            return false;
        }
    }
}
