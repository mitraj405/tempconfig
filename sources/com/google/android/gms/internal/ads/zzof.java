package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzof {
    public static final zzof zza = new zzof(zzfxr.zzn(zzod.zza));
    static final zzfxu zzb;
    @SuppressLint({"InlinedApi"})
    private static final zzfxr zzc = zzfxr.zzp(2, 5, 6);
    private final SparseArray zzd;
    private final int zze;

    static {
        zzfxt zzfxt = new zzfxt();
        zzfxt.zza(5, 6);
        zzfxt.zza(17, 6);
        zzfxt.zza(7, 6);
        zzfxt.zza(30, 10);
        zzfxt.zza(18, 6);
        zzfxt.zza(6, 8);
        zzfxt.zza(8, 8);
        zzfxt.zza(14, 8);
        zzb = zzfxt.zzc();
    }

    public static Uri zza() {
        if (zzf()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    @SuppressLint({"UnprotectedReceiver"})
    public static zzof zzc(Context context, zzh zzh, zzon zzon) {
        return zzd(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzh, zzon);
    }

    @SuppressLint({"InlinedApi"})
    public static zzof zzd(Context context, Intent intent, zzh zzh, zzon zzon) {
        boolean z;
        Object systemService = context.getSystemService("audio");
        systemService.getClass();
        AudioManager audioManager = (AudioManager) systemService;
        if (zzon == null) {
            if (zzet.zza >= 33) {
                zzon = zzoc.zzb(audioManager, zzh);
            } else {
                zzon = null;
            }
        }
        int i = zzet.zza;
        if (i >= 33 && (zzet.zzN(context) || zzet.zzJ(context))) {
            return zzoc.zza(audioManager, zzh);
        }
        if (i >= 23 && zzoa.zza(audioManager, zzon)) {
            return zza;
        }
        zzfxv zzfxv = new zzfxv();
        zzfxv.zzf(2);
        if (i < 29 || (!zzet.zzN(context) && !zzet.zzJ(context))) {
            ContentResolver contentResolver = context.getContentResolver();
            if (Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if ((z || zzf()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
                zzfxv.zzh(zzc);
            }
            if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
                return new zzof(zze(zzgap.zzh(zzfxv.zzi()), 10));
            }
            int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
            if (intArrayExtra != null) {
                zzfxv.zzh(zzgap.zzg(intArrayExtra));
            }
            return new zzof(zze(zzgap.zzh(zzfxv.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
        }
        zzfxv.zzh(zzob.zzb(zzh));
        return new zzof(zze(zzgap.zzh(zzfxv.zzi()), 10));
    }

    private static zzfxr zze(int[] iArr, int i) {
        zzfxo zzfxo = new zzfxo();
        for (int zzod : iArr) {
            zzfxo.zzf(new zzod(zzod, i));
        }
        return zzfxo.zzi();
    }

    private static boolean zzf() {
        String str = zzet.zzc;
        if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r1.contentEquals(r3) != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r9 instanceof com.google.android.gms.internal.ads.zzof
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.android.gms.internal.ads.zzof r9 = (com.google.android.gms.internal.ads.zzof) r9
            android.util.SparseArray r1 = r8.zzd
            android.util.SparseArray r3 = r9.zzd
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            r5 = 31
            if (r4 < r5) goto L_0x001d
            boolean r1 = r1.contentEquals(r3)
            if (r1 == 0) goto L_0x0046
            goto L_0x003f
        L_0x001d:
            int r4 = r1.size()
            int r5 = r3.size()
            if (r4 != r5) goto L_0x0046
            r5 = r2
        L_0x0028:
            if (r5 >= r4) goto L_0x003f
            int r6 = r1.keyAt(r5)
            java.lang.Object r7 = r1.valueAt(r5)
            java.lang.Object r6 = r3.get(r6)
            boolean r6 = java.util.Objects.equals(r7, r6)
            if (r6 == 0) goto L_0x0046
            int r5 = r5 + 1
            goto L_0x0028
        L_0x003f:
            int r1 = r8.zze
            int r9 = r9.zze
            if (r1 != r9) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzof.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        int i2 = zzet.zza;
        SparseArray sparseArray = this.zzd;
        if (i2 >= 31) {
            i = sparseArray.contentHashCode();
        } else {
            int i3 = 17;
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                int keyAt = sparseArray.keyAt(i4);
                i3 = Objects.hashCode(sparseArray.valueAt(i4)) + ((keyAt + (i3 * 31)) * 31);
            }
            i = i3;
        }
        return (i * 31) + this.zze;
    }

    public final String toString() {
        String obj = this.zzd.toString();
        return "AudioCapabilities[maxChannelCount=" + this.zze + ", audioProfiles=" + obj + "]";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (com.google.android.gms.internal.ads.zzet.zzH(r8.zzd, 30) == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009a, code lost:
        if (r6 != 5) goto L_0x009d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zzb(com.google.android.gms.internal.ads.zzaf r9, com.google.android.gms.internal.ads.zzh r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.zzm
            r0.getClass()
            java.lang.String r1 = r9.zzj
            int r0 = com.google.android.gms.internal.ads.zzbn.zza(r0, r1)
            com.google.android.gms.internal.ads.zzfxu r1 = zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0019
            goto L_0x00c3
        L_0x0019:
            r1 = 7
            r2 = 6
            r3 = 8
            r4 = 18
            if (r0 != r4) goto L_0x002c
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzet.zzH(r0, r4)
            if (r0 != 0) goto L_0x002b
            r0 = r2
            goto L_0x0047
        L_0x002b:
            r0 = r4
        L_0x002c:
            if (r0 != r3) goto L_0x003a
            android.util.SparseArray r0 = r8.zzd
            boolean r0 = com.google.android.gms.internal.ads.zzet.zzH(r0, r3)
            if (r0 == 0) goto L_0x0038
            r0 = r3
            goto L_0x003a
        L_0x0038:
            r0 = r1
            goto L_0x0047
        L_0x003a:
            r5 = 30
            if (r0 != r5) goto L_0x0047
            android.util.SparseArray r6 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzet.zzH(r6, r5)
            if (r5 != 0) goto L_0x0047
            goto L_0x0038
        L_0x0047:
            android.util.SparseArray r5 = r8.zzd
            boolean r5 = com.google.android.gms.internal.ads.zzet.zzH(r5, r0)
            if (r5 == 0) goto L_0x00c3
            android.util.SparseArray r5 = r8.zzd
            java.lang.Object r5 = r5.get(r0)
            com.google.android.gms.internal.ads.zzod r5 = (com.google.android.gms.internal.ads.zzod) r5
            r5.getClass()
            int r6 = r9.zzz
            r7 = -1
            if (r6 == r7) goto L_0x007e
            if (r0 != r4) goto L_0x0062
            goto L_0x007e
        L_0x0062:
            java.lang.String r9 = r9.zzm
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0077
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            r10 = 33
            if (r9 >= r10) goto L_0x0077
            r9 = 10
            if (r6 <= r9) goto L_0x0089
            goto L_0x00c3
        L_0x0077:
            boolean r9 = r5.zzb(r6)
            if (r9 != 0) goto L_0x0089
            goto L_0x00c3
        L_0x007e:
            int r9 = r9.zzA
            if (r9 != r7) goto L_0x0085
            r9 = 48000(0xbb80, float:6.7262E-41)
        L_0x0085:
            int r6 = r5.zza(r9, r10)
        L_0x0089:
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            r10 = 28
            if (r9 > r10) goto L_0x009d
            if (r6 != r1) goto L_0x0093
            r2 = r3
            goto L_0x009e
        L_0x0093:
            r10 = 3
            if (r6 == r10) goto L_0x009e
            r10 = 4
            if (r6 == r10) goto L_0x009e
            r10 = 5
            if (r6 != r10) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r2 = r6
        L_0x009e:
            r10 = 26
            if (r9 > r10) goto L_0x00b0
            java.lang.String r9 = "fugu"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzet.zzb
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x00b0
            r9 = 1
            if (r2 != r9) goto L_0x00b0
            r2 = 2
        L_0x00b0:
            int r9 = com.google.android.gms.internal.ads.zzet.zzh(r2)
            if (r9 == 0) goto L_0x00c3
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r9 = android.util.Pair.create(r10, r9)
            return r9
        L_0x00c3:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzof.zzb(com.google.android.gms.internal.ads.zzaf, com.google.android.gms.internal.ads.zzh):android.util.Pair");
    }

    private zzof(List list) {
        this.zzd = new SparseArray();
        for (int i = 0; i < list.size(); i++) {
            zzod zzod = (zzod) list.get(i);
            this.zzd.put(zzod.zzb, zzod);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzd.size(); i3++) {
            i2 = Math.max(i2, ((zzod) this.zzd.valueAt(i3)).zzc);
        }
        this.zze = i2;
    }
}
