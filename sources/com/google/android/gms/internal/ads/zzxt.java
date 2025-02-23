package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzxt extends zzxy implements zzlg {
    /* access modifiers changed from: private */
    public static final zzfzc zzb = zzfzc.zzb(new zzws());
    public final Context zza;
    private final Object zzc = new Object();
    private final boolean zzd;
    private zzxi zze;
    private zzxm zzf;
    private zzh zzg;
    private final zzwo zzh;

    public zzxt(Context context) {
        Context context2;
        zzwo zzwo = new zzwo();
        zzxi zzd2 = zzxi.zzd(context);
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.zza = context2;
        this.zzh = zzwo;
        this.zze = zzd2;
        this.zzg = zzh.zza;
        boolean z = false;
        if (context != null && zzet.zzN(context)) {
            z = true;
        }
        this.zzd = z;
        if (!z && context != null && zzet.zza >= 32) {
            this.zzf = zzxm.zza(context);
        }
        if (this.zze.zzM && context == null) {
            zzea.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static /* bridge */ /* synthetic */ int zzb(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    public static int zzc(zzaf zzaf, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzaf.zzd)) {
            return 4;
        }
        String zzh2 = zzh(str);
        String zzh3 = zzh(zzaf.zzd);
        if (zzh3 == null || zzh2 == null) {
            if (!z || zzh3 != null) {
                return 0;
            }
            return 1;
        } else if (zzh3.startsWith(zzh2) || zzh2.startsWith(zzh3)) {
            return 3;
        } else {
            int i = zzet.zza;
            if (zzh3.split("-", 2)[0].equals(zzh2.split("-", 2)[0])) {
                return 2;
            }
            return 0;
        }
    }

    public static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean zzm(com.google.android.gms.internal.ads.zzxt r8, com.google.android.gms.internal.ads.zzaf r9) {
        /*
            java.lang.Object r0 = r8.zzc
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzxi r1 = r8.zze     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzM     // Catch:{ all -> 0x008f }
            r2 = 1
            if (r1 == 0) goto L_0x008d
            boolean r1 = r8.zzd     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x008d
            int r1 = r9.zzz     // Catch:{ all -> 0x008f }
            r3 = 2
            if (r1 <= r3) goto L_0x008d
            java.lang.String r1 = r9.zzm     // Catch:{ all -> 0x008f }
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L_0x001b
            goto L_0x0065
        L_0x001b:
            int r6 = r1.hashCode()     // Catch:{ all -> 0x008f }
            r7 = 3
            switch(r6) {
                case -2123537834: goto L_0x0042;
                case 187078296: goto L_0x0038;
                case 187078297: goto L_0x002e;
                case 1504578661: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x004c
        L_0x0024:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r2
            goto L_0x004d
        L_0x002e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r7
            goto L_0x004d
        L_0x0038:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r5
            goto L_0x004d
        L_0x0042:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r3
            goto L_0x004d
        L_0x004c:
            r1 = -1
        L_0x004d:
            if (r1 == 0) goto L_0x0056
            if (r1 == r2) goto L_0x0056
            if (r1 == r3) goto L_0x0056
            if (r1 == r7) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            int r1 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008d
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008d
            boolean r1 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x0065
            goto L_0x008d
        L_0x0065:
            int r1 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008c
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            boolean r3 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x008c
            boolean r1 = r1.zze()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzf()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzxm r1 = r8.zzf     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzh r8 = r8.zzg     // Catch:{ all -> 0x008f }
            boolean r8 = r1.zzd(r8, r9)     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r2 = r5
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return r2
        L_0x008f:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxt.zzm(com.google.android.gms.internal.ads.zzxt, com.google.android.gms.internal.ads.zzaf):boolean");
    }

    private static void zzt(zzwi zzwi, zzci zzci, Map map) {
        int i = 0;
        while (i < zzwi.zzb) {
            if (((zzce) zzci.zzA.get(zzwi.zzb(i))) == null) {
                i++;
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzu() {
        boolean z;
        zzxm zzxm;
        synchronized (this.zzc) {
            z = false;
            if (this.zze.zzM && !this.zzd && zzet.zza >= 32 && (zzxm = this.zzf) != null && zzxm.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzs();
        }
    }

    private static final Pair zzv(int i, zzxx zzxx, int[][][] iArr, zzxo zzxo, Comparator comparator) {
        Object obj;
        zzxx zzxx2 = zzxx;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzxx2.zzc(i2)) {
                zzwi zzd2 = zzxx2.zzd(i2);
                int i3 = 0;
                while (i3 < zzd2.zzb) {
                    zzcd zzb2 = zzd2.zzb(i3);
                    List zza2 = zzxo.zza(i2, zzb2, iArr[i2][i3]);
                    boolean[] zArr = new boolean[zzb2.zza];
                    int i4 = 0;
                    while (i4 < zzb2.zza) {
                        int i5 = i4 + 1;
                        zzxp zzxp = (zzxp) zza2.get(i4);
                        int zzb3 = zzxp.zzb();
                        if (!zArr[i4] && zzb3 != 0) {
                            if (zzb3 == 1) {
                                obj = zzfxr.zzn(zzxp);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzxp);
                                int i6 = i5;
                                while (i6 < zzb2.zza) {
                                    zzxp zzxp2 = (zzxp) zza2.get(i6);
                                    if (zzxp2.zzb() == 2 && zzxp.zzc(zzxp2)) {
                                        arrayList2.add(zzxp2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    zzxx zzxx3 = zzxx;
                                }
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        zzxx zzxx4 = zzxx;
                        i4 = i5;
                    }
                    i3++;
                    zzxx zzxx5 = zzxx;
                }
            }
            zzxo zzxo2 = zzxo;
            i2++;
            zzxx2 = zzxx;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iArr2[i7] = ((zzxp) list.get(i7)).zzc;
        }
        zzxp zzxp3 = (zzxp) list.get(0);
        return Pair.create(new zzxu(zzxp3.zzb, iArr2, 0), Integer.valueOf(zzxp3.zza));
    }

    public final void zza(zzle zzle) {
        synchronized (this.zzc) {
            boolean z = this.zze.zzQ;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.google.android.gms.internal.ads.zzxv[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.google.android.gms.internal.ads.zzwp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: com.google.android.gms.internal.ads.zzxw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: com.google.android.gms.internal.ads.zzxw} */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zzd(com.google.android.gms.internal.ads.zzxx r27, int[][][] r28, int[] r29, com.google.android.gms.internal.ads.zzui r30, com.google.android.gms.internal.ads.zzcc r31) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            r3 = r29
            java.lang.Object r4 = r1.zzc
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzxi r5 = r1.zze     // Catch:{ all -> 0x024f }
            boolean r6 = r5.zzM     // Catch:{ all -> 0x024f }
            if (r6 == 0) goto L_0x0025
            int r6 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ all -> 0x024f }
            r7 = 32
            if (r6 < r7) goto L_0x0025
            com.google.android.gms.internal.ads.zzxm r6 = r1.zzf     // Catch:{ all -> 0x024f }
            if (r6 == 0) goto L_0x0025
            android.os.Looper r7 = android.os.Looper.myLooper()     // Catch:{ all -> 0x024f }
            com.google.android.gms.internal.ads.zzdi.zzb(r7)     // Catch:{ all -> 0x024f }
            r6.zzb(r1, r7)     // Catch:{ all -> 0x024f }
        L_0x0025:
            monitor-exit(r4)     // Catch:{ all -> 0x024f }
            r4 = 2
            com.google.android.gms.internal.ads.zzxu[] r6 = new com.google.android.gms.internal.ads.zzxu[r4]
            com.google.android.gms.internal.ads.zzwy r7 = new com.google.android.gms.internal.ads.zzwy
            r7.<init>(r5, r3)
            com.google.android.gms.internal.ads.zzwz r8 = new com.google.android.gms.internal.ads.zzwz
            r8.<init>()
            android.util.Pair r7 = zzv(r4, r0, r2, r7, r8)
            r8 = 4
            if (r7 != 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzwu r10 = new com.google.android.gms.internal.ads.zzwu
            r10.<init>(r5)
            com.google.android.gms.internal.ads.zzwv r11 = new com.google.android.gms.internal.ads.zzwv
            r11.<init>()
            android.util.Pair r10 = zzv(r8, r0, r2, r10, r11)
            goto L_0x004a
        L_0x0049:
            r10 = 0
        L_0x004a:
            r11 = 0
            if (r10 == 0) goto L_0x005d
            java.lang.Object r7 = r10.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r10 = r10.first
            com.google.android.gms.internal.ads.zzxu r10 = (com.google.android.gms.internal.ads.zzxu) r10
            r6[r7] = r10
        L_0x005b:
            r7 = r11
            goto L_0x006e
        L_0x005d:
            if (r7 == 0) goto L_0x005b
            java.lang.Object r10 = r7.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r7 = r7.first
            com.google.android.gms.internal.ads.zzxu r7 = (com.google.android.gms.internal.ads.zzxu) r7
            r6[r10] = r7
            goto L_0x005b
        L_0x006e:
            r10 = 1
            if (r7 >= r4) goto L_0x0084
            int r12 = r0.zzc(r7)
            if (r12 != r4) goto L_0x0081
            com.google.android.gms.internal.ads.zzwi r12 = r0.zzd(r7)
            int r12 = r12.zzb
            if (r12 <= 0) goto L_0x0081
            r7 = r10
            goto L_0x0085
        L_0x0081:
            int r7 = r7 + 1
            goto L_0x006e
        L_0x0084:
            r7 = r11
        L_0x0085:
            com.google.android.gms.internal.ads.zzww r12 = new com.google.android.gms.internal.ads.zzww
            r12.<init>(r1, r5, r7, r3)
            com.google.android.gms.internal.ads.zzwx r3 = new com.google.android.gms.internal.ads.zzwx
            r3.<init>()
            android.util.Pair r3 = zzv(r10, r0, r2, r12, r3)
            if (r3 == 0) goto L_0x00a3
            java.lang.Object r7 = r3.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r12 = r3.first
            com.google.android.gms.internal.ads.zzxu r12 = (com.google.android.gms.internal.ads.zzxu) r12
            r6[r7] = r12
        L_0x00a3:
            if (r3 != 0) goto L_0x00a7
            r3 = 0
            goto L_0x00ba
        L_0x00a7:
            java.lang.Object r3 = r3.first
            r7 = r3
            com.google.android.gms.internal.ads.zzxu r7 = (com.google.android.gms.internal.ads.zzxu) r7
            com.google.android.gms.internal.ads.zzcd r7 = r7.zza
            com.google.android.gms.internal.ads.zzxu r3 = (com.google.android.gms.internal.ads.zzxu) r3
            int[] r3 = r3.zzb
            r3 = r3[r11]
            com.google.android.gms.internal.ads.zzaf r3 = r7.zzb(r3)
            java.lang.String r3 = r3.zzd
        L_0x00ba:
            com.google.android.gms.internal.ads.zzxa r7 = new com.google.android.gms.internal.ads.zzxa
            r7.<init>(r5, r3)
            com.google.android.gms.internal.ads.zzxb r3 = new com.google.android.gms.internal.ads.zzxb
            r3.<init>()
            r12 = 3
            android.util.Pair r3 = zzv(r12, r0, r2, r7, r3)
            if (r3 == 0) goto L_0x00d9
            java.lang.Object r7 = r3.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r3 = r3.first
            com.google.android.gms.internal.ads.zzxu r3 = (com.google.android.gms.internal.ads.zzxu) r3
            r6[r7] = r3
        L_0x00d9:
            r3 = r11
        L_0x00da:
            if (r3 >= r4) goto L_0x014d
            int r7 = r0.zzc(r3)
            if (r7 == r4) goto L_0x0145
            if (r7 == r10) goto L_0x0145
            if (r7 == r12) goto L_0x0145
            if (r7 == r8) goto L_0x0145
            com.google.android.gms.internal.ads.zzwi r7 = r0.zzd(r3)
            r13 = r2[r3]
            r14 = r11
            r16 = r14
            r15 = 0
            r17 = 0
        L_0x00f4:
            int r8 = r7.zzb
            if (r14 >= r8) goto L_0x0134
            com.google.android.gms.internal.ads.zzcd r8 = r7.zzb(r14)
            r18 = r13[r14]
            r9 = r11
            r12 = r17
        L_0x0101:
            int r4 = r8.zza
            if (r9 >= r4) goto L_0x012b
            r4 = r18[r9]
            boolean r11 = r5.zzN
            boolean r4 = com.google.android.gms.internal.ads.zzlf.zza(r4, r11)
            if (r4 == 0) goto L_0x0126
            com.google.android.gms.internal.ads.zzaf r4 = r8.zzb(r9)
            com.google.android.gms.internal.ads.zzxe r11 = new com.google.android.gms.internal.ads.zzxe
            r10 = r18[r9]
            r11.<init>(r4, r10)
            if (r12 == 0) goto L_0x0122
            int r4 = r11.compareTo(r12)
            if (r4 <= 0) goto L_0x0126
        L_0x0122:
            r15 = r8
            r16 = r9
            r12 = r11
        L_0x0126:
            int r9 = r9 + 1
            r10 = 1
            r11 = 0
            goto L_0x0101
        L_0x012b:
            int r14 = r14 + 1
            r17 = r12
            r4 = 2
            r10 = 1
            r11 = 0
            r12 = 3
            goto L_0x00f4
        L_0x0134:
            if (r15 != 0) goto L_0x0138
            r4 = 0
            goto L_0x0143
        L_0x0138:
            com.google.android.gms.internal.ads.zzxu r4 = new com.google.android.gms.internal.ads.zzxu
            r7 = 1
            int[] r8 = new int[r7]
            r7 = 0
            r8[r7] = r16
            r4.<init>(r15, r8, r7)
        L_0x0143:
            r6[r3] = r4
        L_0x0145:
            int r3 = r3 + 1
            r4 = 2
            r8 = 4
            r10 = 1
            r11 = 0
            r12 = 3
            goto L_0x00da
        L_0x014d:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 2
            r7 = 0
        L_0x0154:
            if (r7 >= r3) goto L_0x0160
            com.google.android.gms.internal.ads.zzwi r4 = r0.zzd(r7)
            zzt(r4, r5, r2)
            int r7 = r7 + 1
            goto L_0x0154
        L_0x0160:
            com.google.android.gms.internal.ads.zzwi r4 = r27.zze()
            zzt(r4, r5, r2)
            r7 = 0
        L_0x0168:
            if (r7 >= r3) goto L_0x017f
            int r4 = r0.zzc(r7)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r2.get(r4)
            com.google.android.gms.internal.ads.zzce r4 = (com.google.android.gms.internal.ads.zzce) r4
            if (r4 != 0) goto L_0x017d
            int r7 = r7 + 1
            goto L_0x0168
        L_0x017d:
            r4 = 0
            throw r4
        L_0x017f:
            r4 = 0
            r7 = 0
        L_0x0181:
            if (r7 >= r3) goto L_0x019b
            com.google.android.gms.internal.ads.zzwi r2 = r0.zzd(r7)
            boolean r3 = r5.zzg(r7, r2)
            if (r3 != 0) goto L_0x018e
            goto L_0x0196
        L_0x018e:
            com.google.android.gms.internal.ads.zzxj r2 = r5.zze(r7, r2)
            if (r2 != 0) goto L_0x019a
            r6[r7] = r4
        L_0x0196:
            int r7 = r7 + 1
            r3 = 2
            goto L_0x0181
        L_0x019a:
            throw r4
        L_0x019b:
            r2 = r3
            r7 = 0
        L_0x019d:
            if (r7 >= r2) goto L_0x01bf
            int r2 = r0.zzc(r7)
            boolean r3 = r5.zzf(r7)
            if (r3 != 0) goto L_0x01b8
            com.google.android.gms.internal.ads.zzfxw r3 = r5.zzB
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r3.contains(r2)
            if (r2 == 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r4 = 0
            goto L_0x01bb
        L_0x01b8:
            r4 = 0
            r6[r7] = r4
        L_0x01bb:
            int r7 = r7 + 1
            r2 = 2
            goto L_0x019d
        L_0x01bf:
            r4 = 0
            com.google.android.gms.internal.ads.zzwo r2 = r1.zzh
            com.google.android.gms.internal.ads.zzyj r3 = r26.zzq()
            com.google.android.gms.internal.ads.zzfxr r7 = com.google.android.gms.internal.ads.zzwp.zzf(r6)
            r8 = 2
            com.google.android.gms.internal.ads.zzxv[] r14 = new com.google.android.gms.internal.ads.zzxv[r8]
            r15 = 0
        L_0x01ce:
            if (r15 >= r8) goto L_0x0217
            r8 = r6[r15]
            if (r8 == 0) goto L_0x020f
            int[] r10 = r8.zzb
            int r9 = r10.length
            if (r9 != 0) goto L_0x01da
            goto L_0x020f
        L_0x01da:
            r13 = 1
            if (r9 != r13) goto L_0x01f5
            com.google.android.gms.internal.ads.zzcd r8 = r8.zza
            com.google.android.gms.internal.ads.zzxw r9 = new com.google.android.gms.internal.ads.zzxw
            r16 = 0
            r22 = r10[r16]
            r23 = 0
            r24 = 0
            r25 = 0
            r20 = r9
            r21 = r8
            r20.<init>(r21, r22, r23, r24, r25)
            r19 = r13
            goto L_0x020c
        L_0x01f5:
            r16 = 0
            com.google.android.gms.internal.ads.zzcd r9 = r8.zza
            r11 = 0
            java.lang.Object r8 = r7.get(r15)
            r18 = r8
            com.google.android.gms.internal.ads.zzfxr r18 = (com.google.android.gms.internal.ads.zzfxr) r18
            r8 = r2
            r12 = r3
            r19 = r13
            r13 = r18
            com.google.android.gms.internal.ads.zzwp r9 = r8.zza(r9, r10, r11, r12, r13)
        L_0x020c:
            r14[r15] = r9
            goto L_0x0213
        L_0x020f:
            r16 = 0
            r19 = 1
        L_0x0213:
            int r15 = r15 + 1
            r8 = 2
            goto L_0x01ce
        L_0x0217:
            r16 = 0
            com.google.android.gms.internal.ads.zzli[] r2 = new com.google.android.gms.internal.ads.zzli[r8]
            r11 = r16
        L_0x021d:
            if (r11 >= r8) goto L_0x024a
            int r3 = r0.zzc(r11)
            boolean r6 = r5.zzf(r11)
            if (r6 != 0) goto L_0x0244
            com.google.android.gms.internal.ads.zzfxw r6 = r5.zzB
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x0236
            goto L_0x0244
        L_0x0236:
            int r3 = r0.zzc(r11)
            r6 = -2
            if (r3 == r6) goto L_0x0241
            r3 = r14[r11]
            if (r3 == 0) goto L_0x0244
        L_0x0241:
            com.google.android.gms.internal.ads.zzli r3 = com.google.android.gms.internal.ads.zzli.zza
            goto L_0x0245
        L_0x0244:
            r3 = r4
        L_0x0245:
            r2[r11] = r3
            int r11 = r11 + 1
            goto L_0x021d
        L_0x024a:
            android.util.Pair r0 = android.util.Pair.create(r2, r14)
            return r0
        L_0x024f:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x024f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxt.zzd(com.google.android.gms.internal.ads.zzxx, int[][][], int[], com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzcc):android.util.Pair");
    }

    public final zzxi zzf() {
        zzxi zzxi;
        synchronized (this.zzc) {
            zzxi = this.zze;
        }
        return zzxi;
    }

    public final void zzj() {
        zzxm zzxm;
        synchronized (this.zzc) {
            if (zzet.zza >= 32 && (zzxm = this.zzf) != null) {
                zzxm.zzc();
            }
        }
        super.zzj();
    }

    public final void zzk(zzh zzh2) {
        boolean z;
        synchronized (this.zzc) {
            z = !this.zzg.equals(zzh2);
            this.zzg = zzh2;
        }
        if (z) {
            zzu();
        }
    }

    public final void zzl(zzxg zzxg) {
        boolean z;
        zzxi zzxi = new zzxi(zzxg);
        synchronized (this.zzc) {
            z = !this.zze.equals(zzxi);
            this.zze = zzxi;
        }
        if (z) {
            if (zzxi.zzM && this.zza == null) {
                zzea.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzs();
        }
    }

    public final boolean zzn() {
        return true;
    }

    public final zzlg zze() {
        return this;
    }
}
