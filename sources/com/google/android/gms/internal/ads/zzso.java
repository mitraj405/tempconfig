package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzso extends zzhm {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private long zzG;
    private int zzH;
    private int zzI;
    private ByteBuffer zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private long zzW;
    private long zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzhn zza;
    private boolean zzaa;
    private zzsn zzab;
    private long zzac;
    private boolean zzad;
    private zzrj zzae;
    private zzrj zzaf;
    private final zzsa zzc;
    private final zzsq zzd;
    private final float zze;
    private final zzhd zzf = new zzhd(0, 0);
    private final zzhd zzg = new zzhd(0, 0);
    private final zzhd zzh = new zzhd(2, 0);
    private final zzrx zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzqw zzl;
    private zzaf zzm;
    private zzaf zzn;
    /* access modifiers changed from: private */
    public zzld zzo;
    private MediaCrypto zzp;
    private float zzq;
    private zzsc zzr;
    private zzaf zzs;
    private MediaFormat zzt;
    private boolean zzu;
    private float zzv;
    private ArrayDeque zzw;
    private zzsk zzx;
    private zzsf zzy;
    private int zzz;

    public zzso(int i, zzsa zzsa, zzsq zzsq, boolean z, float f) {
        super(i);
        this.zzc = zzsa;
        this.zzd = zzsq;
        this.zze = f;
        zzrx zzrx = new zzrx();
        this.zzi = zzrx;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzq = 1.0f;
        this.zzk = new ArrayDeque();
        this.zzab = zzsn.zza;
        zzrx.zzi(0);
        zzrx.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzqw();
        this.zzv = -1.0f;
        this.zzz = 0;
        this.zzQ = 0;
        this.zzH = -1;
        this.zzI = -1;
        this.zzG = -9223372036854775807L;
        this.zzW = -9223372036854775807L;
        this.zzX = -9223372036854775807L;
        this.zzac = -9223372036854775807L;
        this.zzR = 0;
        this.zzS = 0;
        this.zza = new zzhn();
    }

    public static boolean zzaN(zzaf zzaf2) {
        if (zzaf2.zzG != 0) {
            return false;
        }
        return true;
    }

    private final void zzaO() {
        this.zzH = -1;
        this.zzg.zzc = null;
    }

    private final void zzaP() {
        this.zzI = -1;
        this.zzJ = null;
    }

    private final void zzaQ(zzsn zzsn) {
        this.zzab = zzsn;
        if (zzsn.zzd != -9223372036854775807L) {
            this.zzad = true;
        }
    }

    private final void zzaR() throws zzhw {
        zzrj zzrj = this.zzaf;
        zzrj.getClass();
        this.zzae = zzrj;
        this.zzR = 0;
        this.zzS = 0;
    }

    @TargetApi(23)
    private final boolean zzaS() throws zzhw {
        if (this.zzT) {
            this.zzR = 1;
            if (this.zzB) {
                this.zzS = 3;
                return false;
            }
            this.zzS = 2;
        } else {
            zzaR();
        }
        return true;
    }

    private final boolean zzaT() throws zzhw {
        zzsc zzsc = this.zzr;
        if (zzsc == null || this.zzR == 2 || this.zzY) {
            return false;
        }
        if (this.zzH < 0) {
            int zza2 = zzsc.zza();
            this.zzH = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzc = zzsc.zzf(zza2);
            this.zzg.zzb();
        }
        if (this.zzR == 1) {
            if (!this.zzF) {
                this.zzU = true;
                zzsc.zzj(this.zzH, 0, 0, 0, 4);
                zzaO();
            }
            this.zzR = 2;
            return false;
        } else if (this.zzD) {
            this.zzD = false;
            ByteBuffer byteBuffer = this.zzg.zzc;
            byteBuffer.getClass();
            byteBuffer.put(zzb);
            zzsc.zzj(this.zzH, 0, 38, 0, 0);
            zzaO();
            this.zzT = true;
            return true;
        } else {
            if (this.zzQ == 1) {
                int i = 0;
                while (true) {
                    zzaf zzaf2 = this.zzs;
                    zzaf2.getClass();
                    if (i >= zzaf2.zzo.size()) {
                        break;
                    }
                    ByteBuffer byteBuffer2 = this.zzg.zzc;
                    byteBuffer2.getClass();
                    byteBuffer2.put((byte[]) this.zzs.zzo.get(i));
                    i++;
                }
                this.zzQ = 2;
            }
            ByteBuffer byteBuffer3 = this.zzg.zzc;
            byteBuffer3.getClass();
            int position = byteBuffer3.position();
            zzjz zzcY = zzcY();
            try {
                int zzcW = zzcW(zzcY, this.zzg, 0);
                if (zzcW == -3) {
                    if (zzQ()) {
                        this.zzX = this.zzW;
                    }
                    return false;
                } else if (zzcW == -5) {
                    if (this.zzQ == 2) {
                        this.zzg.zzb();
                        this.zzQ = 1;
                    }
                    zzac(zzcY);
                    return true;
                } else {
                    zzhd zzhd = this.zzg;
                    if (zzhd.zzf()) {
                        this.zzX = this.zzW;
                        if (this.zzQ == 2) {
                            zzhd.zzb();
                            this.zzQ = 1;
                        }
                        this.zzY = true;
                        if (!this.zzT) {
                            zzao();
                            return false;
                        }
                        try {
                            if (!this.zzF) {
                                this.zzU = true;
                                zzsc.zzj(this.zzH, 0, 0, 0, 4);
                                zzaO();
                            }
                            return false;
                        } catch (MediaCodec.CryptoException e) {
                            throw zzi(e, this.zzm, false, zzet.zzj(e.getErrorCode()));
                        }
                    } else if (this.zzT || zzhd.zzg()) {
                        boolean zzk2 = zzhd.zzk();
                        if (zzk2) {
                            zzhd.zzb.zzb(position);
                        }
                        long j = this.zzg.zze;
                        if (this.zzaa) {
                            if (!this.zzk.isEmpty()) {
                                zzeq zzeq = ((zzsn) this.zzk.peekLast()).zze;
                                zzaf zzaf3 = this.zzm;
                                zzaf3.getClass();
                                zzeq.zzd(j, zzaf3);
                            } else {
                                zzeq zzeq2 = this.zzab.zze;
                                zzaf zzaf4 = this.zzm;
                                zzaf4.getClass();
                                zzeq2.zzd(j, zzaf4);
                            }
                            this.zzaa = false;
                        }
                        long max = Math.max(this.zzW, j);
                        this.zzW = max;
                        if (zzQ() || this.zzg.zzh()) {
                            this.zzX = max;
                        }
                        this.zzg.zzj();
                        zzhd zzhd2 = this.zzg;
                        if (zzhd2.zze()) {
                            zzaj(zzhd2);
                        }
                        zzaD(this.zzg);
                        zzat(this.zzg);
                        if (zzk2) {
                            try {
                                zzsc.zzk(this.zzH, 0, this.zzg.zzb, j, 0);
                            } catch (MediaCodec.CryptoException e2) {
                                throw zzi(e2, this.zzm, false, zzet.zzj(e2.getErrorCode()));
                            }
                        } else {
                            int i2 = this.zzH;
                            ByteBuffer byteBuffer4 = this.zzg.zzc;
                            byteBuffer4.getClass();
                            zzsc.zzj(i2, 0, byteBuffer4.limit(), j, 0);
                        }
                        zzaO();
                        this.zzT = true;
                        this.zzQ = 0;
                        this.zza.zzc++;
                        return true;
                    } else {
                        zzhd.zzb();
                        if (this.zzQ == 2) {
                            this.zzQ = 1;
                        }
                        return true;
                    }
                }
            } catch (zzhc e3) {
                zzak(e3);
                zzaW(0);
                zzah();
                return true;
            }
        }
    }

    private final boolean zzaU() {
        if (this.zzI >= 0) {
            return true;
        }
        return false;
    }

    private final boolean zzaV(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzaf zzaf2 = this.zzn;
        if (zzaf2 == null || !Objects.equals(zzaf2.zzm, "audio/opus")) {
            return true;
        }
        if (zzade.zzf(j, j2)) {
            return false;
        }
        return true;
    }

    private final boolean zzaW(int i) throws zzhw {
        zzhd zzhd = this.zzf;
        zzjz zzcY = zzcY();
        zzhd.zzb();
        int zzcW = zzcW(zzcY, this.zzf, i | 4);
        if (zzcW == -5) {
            zzac(zzcY);
            return true;
        } else if (zzcW != -4 || !this.zzf.zzf()) {
            return false;
        } else {
            this.zzY = true;
            zzao();
            return false;
        }
    }

    private final boolean zzaX(zzaf zzaf2) throws zzhw {
        if (!(zzet.zza < 23 || this.zzr == null || this.zzS == 3 || zzcV() == 0)) {
            float f = this.zzq;
            zzaf2.getClass();
            float zzZ2 = zzZ(f, zzaf2, zzT());
            float f2 = this.zzv;
            if (f2 != zzZ2) {
                if (zzZ2 == -1.0f) {
                    zzae();
                    return false;
                } else if (f2 != -1.0f || zzZ2 > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", zzZ2);
                    zzsc zzsc = this.zzr;
                    zzsc.getClass();
                    zzsc.zzp(bundle);
                    this.zzv = zzZ2;
                }
            }
        }
        return true;
    }

    private final void zzad() {
        this.zzO = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzN = false;
        this.zzM = false;
        this.zzl.zzb();
    }

    private final void zzae() throws zzhw {
        if (this.zzT) {
            this.zzR = 1;
            this.zzS = 3;
            return;
        }
        zzaF();
        zzaB();
    }

    private final void zzah() {
        try {
            zzsc zzsc = this.zzr;
            zzdi.zzb(zzsc);
            zzsc.zzi();
        } finally {
            zzaG();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzai(com.google.android.gms.internal.ads.zzsf r19, android.media.MediaCrypto r20) throws java.lang.Exception {
        /*
            r18 = this;
            r8 = r18
            r0 = r19
            java.lang.String r1 = "createCodec:"
            com.google.android.gms.internal.ads.zzaf r2 = r8.zzm
            r2.getClass()
            java.lang.String r3 = r0.zza
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            r5 = 23
            if (r4 >= r5) goto L_0x0016
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0020
        L_0x0016:
            float r5 = r8.zzq
            com.google.android.gms.internal.ads.zzaf[] r6 = r18.zzT()
            float r5 = r8.zzZ(r5, r2, r6)
        L_0x0020:
            float r6 = r8.zze
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0028
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0028:
            r8.zzaE(r2)
            r18.zzh()
            long r6 = android.os.SystemClock.elapsedRealtime()
            r9 = 0
            com.google.android.gms.internal.ads.zzrz r10 = r8.zzaf(r0, r2, r9, r5)
            r11 = 31
            if (r4 < r11) goto L_0x0042
            com.google.android.gms.internal.ads.zznz r4 = r18.zzn()
            com.google.android.gms.internal.ads.zzsj.zza(r10, r4)
        L_0x0042:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ef }
            r4.<init>(r1)     // Catch:{ all -> 0x03ef }
            r4.append(r3)     // Catch:{ all -> 0x03ef }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x03ef }
            android.os.Trace.beginSection(r1)     // Catch:{ all -> 0x03ef }
            com.google.android.gms.internal.ads.zzsa r1 = r8.zzc     // Catch:{ all -> 0x03ef }
            com.google.android.gms.internal.ads.zzsc r1 = r1.zzd(r10)     // Catch:{ all -> 0x03ef }
            r8.zzr = r1     // Catch:{ all -> 0x03ef }
            com.google.android.gms.internal.ads.zzsm r4 = new com.google.android.gms.internal.ads.zzsm     // Catch:{ all -> 0x03ef }
            r4.<init>(r8, r9)     // Catch:{ all -> 0x03ef }
            com.google.android.gms.internal.ads.zzsi.zza(r1, r4)     // Catch:{ all -> 0x03ef }
            android.os.Trace.endSection()
            r18.zzh()
            long r11 = android.os.SystemClock.elapsedRealtime()
            boolean r1 = r0.zze(r2)
            r4 = 2
            if (r1 != 0) goto L_0x02b9
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r4 = "id="
            java.lang.StringBuilder r4 = defpackage.xx.J(r4)
            java.lang.String r9 = r2.zza
            r4.append(r9)
            java.lang.String r9 = ", mimeType="
            r4.append(r9)
            java.lang.String r9 = r2.zzm
            r4.append(r9)
            java.lang.String r9 = r2.zzl
            if (r9 == 0) goto L_0x0097
            java.lang.String r9 = ", container="
            r4.append(r9)
            java.lang.String r9 = r2.zzl
            r4.append(r9)
        L_0x0097:
            int r9 = r2.zzi
            r13 = -1
            if (r9 == r13) goto L_0x00a6
            java.lang.String r9 = ", bitrate="
            r4.append(r9)
            int r9 = r2.zzi
            r4.append(r9)
        L_0x00a6:
            java.lang.String r9 = r2.zzj
            if (r9 == 0) goto L_0x00b4
            java.lang.String r9 = ", codecs="
            r4.append(r9)
            java.lang.String r9 = r2.zzj
            r4.append(r9)
        L_0x00b4:
            com.google.android.gms.internal.ads.zzy r9 = r2.zzp
            java.lang.String r13 = ","
            if (r9 == 0) goto L_0x0149
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r14 = 0
        L_0x00c0:
            com.google.android.gms.internal.ads.zzy r15 = r2.zzp
            r20 = r10
            int r10 = r15.zzb
            if (r14 >= r10) goto L_0x0139
            com.google.android.gms.internal.ads.zzx r10 = r15.zza(r14)
            java.util.UUID r10 = r10.zza
            java.util.UUID r15 = com.google.android.gms.internal.ads.zzk.zzb
            boolean r15 = r10.equals(r15)
            if (r15 == 0) goto L_0x00dc
            java.lang.String r10 = "cenc"
            r9.add(r10)
            goto L_0x0113
        L_0x00dc:
            java.util.UUID r15 = com.google.android.gms.internal.ads.zzk.zzc
            boolean r15 = r10.equals(r15)
            if (r15 == 0) goto L_0x00ea
            java.lang.String r10 = "clearkey"
            r9.add(r10)
            goto L_0x0113
        L_0x00ea:
            java.util.UUID r15 = com.google.android.gms.internal.ads.zzk.zze
            boolean r15 = r10.equals(r15)
            if (r15 == 0) goto L_0x00f8
            java.lang.String r10 = "playready"
            r9.add(r10)
            goto L_0x0113
        L_0x00f8:
            java.util.UUID r15 = com.google.android.gms.internal.ads.zzk.zzd
            boolean r15 = r10.equals(r15)
            if (r15 == 0) goto L_0x0106
            java.lang.String r10 = "widevine"
            r9.add(r10)
            goto L_0x0113
        L_0x0106:
            java.util.UUID r15 = com.google.android.gms.internal.ads.zzk.zza
            boolean r15 = r10.equals(r15)
            if (r15 == 0) goto L_0x0116
            java.lang.String r10 = "universal"
            r9.add(r10)
        L_0x0113:
            r16 = r6
            goto L_0x0132
        L_0x0116:
            java.lang.String r10 = r10.toString()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r16 = r6
            java.lang.String r6 = "unknown ("
            r15.<init>(r6)
            r15.append(r10)
            java.lang.String r6 = ")"
            r15.append(r6)
            java.lang.String r6 = r15.toString()
            r9.add(r6)
        L_0x0132:
            int r14 = r14 + 1
            r10 = r20
            r6 = r16
            goto L_0x00c0
        L_0x0139:
            r16 = r6
            java.lang.String r6 = ", drm=["
            r4.append(r6)
            com.google.android.gms.internal.ads.zzfum.zzb(r4, r9, r13)
            r6 = 93
            r4.append(r6)
            goto L_0x014d
        L_0x0149:
            r16 = r6
            r20 = r10
        L_0x014d:
            int r6 = r2.zzr
            r7 = -1
            if (r6 == r7) goto L_0x016a
            int r6 = r2.zzs
            if (r6 == r7) goto L_0x016a
            java.lang.String r6 = ", res="
            r4.append(r6)
            int r6 = r2.zzr
            r4.append(r6)
            java.lang.String r6 = "x"
            r4.append(r6)
            int r6 = r2.zzs
            r4.append(r6)
        L_0x016a:
            com.google.android.gms.internal.ads.zzo r6 = r2.zzy
            if (r6 == 0) goto L_0x0188
            boolean r7 = r6.zze()
            if (r7 != 0) goto L_0x017a
            boolean r6 = r6.zzf()
            if (r6 == 0) goto L_0x0188
        L_0x017a:
            java.lang.String r6 = ", color="
            r4.append(r6)
            com.google.android.gms.internal.ads.zzo r6 = r2.zzy
            java.lang.String r6 = r6.zzd()
            r4.append(r6)
        L_0x0188:
            float r6 = r2.zzt
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x019a
            java.lang.String r6 = ", fps="
            r4.append(r6)
            float r6 = r2.zzt
            r4.append(r6)
        L_0x019a:
            int r6 = r2.zzz
            r7 = -1
            if (r6 == r7) goto L_0x01a9
            java.lang.String r6 = ", channels="
            r4.append(r6)
            int r6 = r2.zzz
            r4.append(r6)
        L_0x01a9:
            int r6 = r2.zzA
            if (r6 == r7) goto L_0x01b7
            java.lang.String r6 = ", sample_rate="
            r4.append(r6)
            int r6 = r2.zzA
            r4.append(r6)
        L_0x01b7:
            java.lang.String r6 = r2.zzd
            if (r6 == 0) goto L_0x01c5
            java.lang.String r6 = ", language="
            r4.append(r6)
            java.lang.String r6 = r2.zzd
            r4.append(r6)
        L_0x01c5:
            java.util.List r6 = r2.zzc
            boolean r6 = r6.isEmpty()
            java.lang.String r7 = "]"
            if (r6 != 0) goto L_0x01dc
            java.lang.String r6 = ", labels=["
            r4.append(r6)
            java.util.List r6 = r2.zzc
            com.google.android.gms.internal.ads.zzfum.zzb(r4, r6, r13)
            r4.append(r7)
        L_0x01dc:
            int r6 = r2.zze
            if (r6 == 0) goto L_0x0204
            java.lang.String r6 = ", selectionFlags=["
            r4.append(r6)
            int r6 = r2.zze
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = r6 & 1
            if (r10 == 0) goto L_0x01f5
            java.lang.String r10 = "default"
            r9.add(r10)
        L_0x01f5:
            r6 = r6 & 2
            if (r6 == 0) goto L_0x01fe
            java.lang.String r6 = "forced"
            r9.add(r6)
        L_0x01fe:
            com.google.android.gms.internal.ads.zzfum.zzb(r4, r9, r13)
            r4.append(r7)
        L_0x0204:
            int r6 = r2.zzf
            if (r6 == 0) goto L_0x02a1
            java.lang.String r6 = ", roleFlags=["
            r4.append(r6)
            int r6 = r2.zzf
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = r6 & 1
            if (r10 == 0) goto L_0x021d
            java.lang.String r10 = "main"
            r9.add(r10)
        L_0x021d:
            r10 = r6 & 2
            if (r10 == 0) goto L_0x0226
            java.lang.String r10 = "alt"
            r9.add(r10)
        L_0x0226:
            r10 = r6 & 4
            if (r10 == 0) goto L_0x022f
            java.lang.String r10 = "supplementary"
            r9.add(r10)
        L_0x022f:
            r10 = r6 & 8
            if (r10 == 0) goto L_0x0238
            java.lang.String r10 = "commentary"
            r9.add(r10)
        L_0x0238:
            r10 = r6 & 16
            if (r10 == 0) goto L_0x0241
            java.lang.String r10 = "dub"
            r9.add(r10)
        L_0x0241:
            r10 = r6 & 32
            if (r10 == 0) goto L_0x024a
            java.lang.String r10 = "emergency"
            r9.add(r10)
        L_0x024a:
            r10 = r6 & 64
            if (r10 == 0) goto L_0x0253
            java.lang.String r10 = "caption"
            r9.add(r10)
        L_0x0253:
            r10 = r6 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x025c
            java.lang.String r10 = "subtitle"
            r9.add(r10)
        L_0x025c:
            r10 = r6 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0265
            java.lang.String r10 = "sign"
            r9.add(r10)
        L_0x0265:
            r10 = r6 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x026e
            java.lang.String r10 = "describes-video"
            r9.add(r10)
        L_0x026e:
            r10 = r6 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x0277
            java.lang.String r10 = "describes-music"
            r9.add(r10)
        L_0x0277:
            r10 = r6 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0280
            java.lang.String r10 = "enhanced-intelligibility"
            r9.add(r10)
        L_0x0280:
            r10 = r6 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0289
            java.lang.String r10 = "transcribes-dialog"
            r9.add(r10)
        L_0x0289:
            r10 = r6 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x0292
            java.lang.String r10 = "easy-read"
            r9.add(r10)
        L_0x0292:
            r6 = r6 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x029b
            java.lang.String r6 = "trick-play"
            r9.add(r6)
        L_0x029b:
            com.google.android.gms.internal.ads.zzfum.zzb(r4, r9, r13)
            r4.append(r7)
        L_0x02a1:
            java.lang.String r4 = r4.toString()
            r6 = 0
            r1[r6] = r4
            r4 = 1
            r1[r4] = r3
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r7 = "Format exceeds selected codec's capabilities [%s, %s]"
            java.lang.String r1 = java.lang.String.format(r4, r7, r1)
            java.lang.String r4 = "MediaCodecRenderer"
            com.google.android.gms.internal.ads.zzea.zzf(r4, r1)
            goto L_0x02be
        L_0x02b9:
            r16 = r6
            r20 = r10
            r6 = 0
        L_0x02be:
            r8.zzy = r0
            r8.zzv = r5
            r8.zzs = r2
            int r1 = com.google.android.gms.internal.ads.zzet.zza
            r2 = 25
            if (r1 > r2) goto L_0x02f6
            java.lang.String r4 = "OMX.Exynos.avc.dec.secure"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x02f6
            java.lang.String r4 = com.google.android.gms.internal.ads.zzet.zzd
            java.lang.String r5 = "SM-T585"
            boolean r5 = r4.startsWith(r5)
            if (r5 != 0) goto L_0x02f4
            java.lang.String r5 = "SM-A510"
            boolean r5 = r4.startsWith(r5)
            if (r5 != 0) goto L_0x02f4
            java.lang.String r5 = "SM-A520"
            boolean r5 = r4.startsWith(r5)
            if (r5 != 0) goto L_0x02f4
            java.lang.String r5 = "SM-J700"
            boolean r4 = r4.startsWith(r5)
            if (r4 == 0) goto L_0x02f6
        L_0x02f4:
            r4 = 2
            goto L_0x032f
        L_0x02f6:
            r4 = 24
            if (r1 >= r4) goto L_0x032e
            java.lang.String r4 = "OMX.Nvidia.h264.decode"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x030a
            java.lang.String r4 = "OMX.Nvidia.h264.decode.secure"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x032e
        L_0x030a:
            java.lang.String r4 = com.google.android.gms.internal.ads.zzet.zzb
            java.lang.String r5 = "flounder"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x032c
            java.lang.String r5 = "flounder_lte"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x032c
            java.lang.String r5 = "grouper"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x032c
            java.lang.String r5 = "tilapia"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x032e
        L_0x032c:
            r4 = 1
            goto L_0x032f
        L_0x032e:
            r4 = r6
        L_0x032f:
            r8.zzz = r4
            com.google.android.gms.internal.ads.zzaf r4 = r8.zzs
            r4.getClass()
            r4 = 29
            if (r1 != r4) goto L_0x0344
            java.lang.String r5 = "c2.android.aac.decoder"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0344
            r5 = 1
            goto L_0x0345
        L_0x0344:
            r5 = r6
        L_0x0345:
            r8.zzA = r5
            r5 = 23
            if (r1 > r5) goto L_0x0356
            java.lang.String r5 = "OMX.google.vorbis.decoder"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x0354
            goto L_0x0356
        L_0x0354:
            r5 = 1
            goto L_0x0357
        L_0x0356:
            r5 = r6
        L_0x0357:
            r8.zzB = r5
            r5 = 21
            if (r1 != r5) goto L_0x0367
            java.lang.String r5 = "OMX.google.aac.decoder"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0367
            r5 = 1
            goto L_0x0368
        L_0x0367:
            r5 = r6
        L_0x0368:
            r8.zzC = r5
            java.lang.String r5 = r0.zza
            if (r1 > r2) goto L_0x0376
            java.lang.String r2 = "OMX.rk.video_decoder.avc"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x03c0
        L_0x0376:
            if (r1 > r4) goto L_0x03a8
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03c0
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel.secure"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03c0
            java.lang.String r1 = "OMX.bcm.vdec.avc.tunnel"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03c0
            java.lang.String r1 = "OMX.bcm.vdec.avc.tunnel.secure"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03c0
            java.lang.String r1 = "OMX.bcm.vdec.hevc.tunnel"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03c0
            java.lang.String r1 = "OMX.bcm.vdec.hevc.tunnel.secure"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x03c0
        L_0x03a8:
            java.lang.String r1 = "Amazon"
            java.lang.String r2 = com.google.android.gms.internal.ads.zzet.zzc
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x03c1
            java.lang.String r1 = "AFTS"
            java.lang.String r2 = com.google.android.gms.internal.ads.zzet.zzd
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x03c1
            boolean r0 = r0.zzf
            if (r0 == 0) goto L_0x03c1
        L_0x03c0:
            r6 = 1
        L_0x03c1:
            r8.zzF = r6
            com.google.android.gms.internal.ads.zzsc r0 = r8.zzr
            r0.getClass()
            int r0 = r18.zzcV()
            r1 = 2
            if (r0 != r1) goto L_0x03db
            r18.zzh()
            long r0 = android.os.SystemClock.elapsedRealtime()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r4
            r8.zzG = r0
        L_0x03db:
            com.google.android.gms.internal.ads.zzhn r0 = r8.zza
            int r1 = r0.zza
            int r1 = r1 + 1
            r0.zza = r1
            long r6 = r11 - r16
            r1 = r18
            r2 = r3
            r3 = r20
            r4 = r11
            r1.zzal(r2, r3, r4, r6)
            return
        L_0x03ef:
            r0 = move-exception
            android.os.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzai(com.google.android.gms.internal.ads.zzsf, android.media.MediaCrypto):void");
    }

    @TargetApi(23)
    private final void zzao() throws zzhw {
        int i = this.zzS;
        if (i == 1) {
            zzah();
        } else if (i == 2) {
            zzah();
            zzaR();
        } else if (i != 3) {
            this.zzZ = true;
            zzaq();
        } else {
            zzaF();
            zzaB();
        }
    }

    public void zzC() {
        try {
            zzad();
            zzaF();
        } finally {
            this.zzaf = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r5 >= r1) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF(com.google.android.gms.internal.ads.zzaf[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzui r18) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zzsn r1 = r0.zzab
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzsn r1 = new com.google.android.gms.internal.ads.zzsn
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaQ(r1)
            return
        L_0x0020:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0055
            long r1 = r0.zzW
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0038
            long r5 = r0.zzac
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0055
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0055
        L_0x0038:
            com.google.android.gms.internal.ads.zzsn r1 = new com.google.android.gms.internal.ads.zzsn
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaQ(r1)
            com.google.android.gms.internal.ads.zzsn r1 = r0.zzab
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0054
            r12.zzap()
        L_0x0054:
            return
        L_0x0055:
            java.util.ArrayDeque r1 = r0.zzk
            com.google.android.gms.internal.ads.zzsn r9 = new com.google.android.gms.internal.ads.zzsn
            long r3 = r0.zzW
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzF(com.google.android.gms.internal.ads.zzaf[], long, long, com.google.android.gms.internal.ads.zzui):void");
    }

    public void zzM(float f, float f2) throws zzhw {
        this.zzq = f2;
        zzaX(this.zzs);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: android.media.MediaCodec$BufferInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: android.media.MediaFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v39, resolved type: com.google.android.gms.internal.ads.zzaf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v93, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v99, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v101, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v102, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v105, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v106, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v107, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v108, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v109, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v52, resolved type: com.google.android.gms.internal.ads.zzaf} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v53, resolved type: com.google.android.gms.internal.ads.zzso} */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r1v20, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v27, types: [android.media.MediaFormat] */
    /* JADX WARNING: type inference failed for: r17v14 */
    /* JADX WARNING: type inference failed for: r17v18 */
    /* JADX WARNING: type inference failed for: r17v19 */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:132|133|(1:135)(0)|153|154|298|(1:233)|297|235|246|247) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:211|212|213|(3:214|215|(1:217))) */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ed, code lost:
        r2 = true;
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0220, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0225, code lost:
        if (r15.zzZ != false) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0227, code lost:
        zzaF();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0263, code lost:
        r17 = r13;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0301, code lost:
        if (r15.zzn != null) goto L_0x0303;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x034e, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0351, code lost:
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0353, code lost:
        r17 = r17;
        r1 = r1;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:?, code lost:
        r0 = r15.zzZ;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0355, code lost:
        if (r0 != false) goto L_0x0357;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0357, code lost:
        zzaF();
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x035c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x035d, code lost:
        r2 = true;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x03b8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x03b9, code lost:
        r1 = r15;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r15.zzZ = true;
        r13 = false;
        r15 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x0220 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:211:0x034e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0413  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x03a7 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzV(long r22, long r24) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r21 = this;
            r15 = r21
            r14 = 1
            r13 = 0
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x000c
            r21.zzaq()     // Catch:{ IllegalStateException -> 0x03de }
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzm     // Catch:{ IllegalStateException -> 0x03de }
            r11 = 2
            if (r0 != 0) goto L_0x0019
            boolean r0 = r15.zzaW(r11)     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            r21.zzaB()     // Catch:{ IllegalStateException -> 0x03de }
            boolean r0 = r15.zzM     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x01f7
            java.lang.String r0 = "bypassRender"
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x03de }
        L_0x0025:
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03de }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdi.zzf(r0)     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzrx r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x0089
            java.nio.ByteBuffer r7 = r0.zzc     // Catch:{ IllegalStateException -> 0x03de }
            int r8 = r15.zzI     // Catch:{ IllegalStateException -> 0x03de }
            int r10 = r0.zzl()     // Catch:{ IllegalStateException -> 0x03de }
            long r11 = r0.zze     // Catch:{ IllegalStateException -> 0x03de }
            long r1 = r21.zzf()     // Catch:{ IllegalStateException -> 0x03de }
            long r3 = r0.zzm()     // Catch:{ IllegalStateException -> 0x03de }
            boolean r0 = r15.zzaV(r1, r3)     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzrx r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03de }
            boolean r16 = r1.zzf()     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzaf r9 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            r9.getClass()
            r6 = 0
            r17 = 0
            r1 = r21
            r2 = r22
            r4 = r24
            r18 = r9
            r9 = r17
            r13 = r0
            r14 = r16
            r15 = r18
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0083 }
            if (r0 == 0) goto L_0x007d
            r15 = r21
            com.google.android.gms.internal.ads.zzrx r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x01f0 }
            long r0 = r0.zzm()     // Catch:{ IllegalStateException -> 0x01f0 }
            r15.zzaC(r0)     // Catch:{ IllegalStateException -> 0x01f0 }
            com.google.android.gms.internal.ads.zzrx r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x01f0 }
            r0.zzb()     // Catch:{ IllegalStateException -> 0x01f0 }
            goto L_0x0089
        L_0x007d:
            r15 = r21
            r13 = 0
            r14 = 1
            goto L_0x01e3
        L_0x0083:
            r0 = move-exception
            r2 = 1
            r17 = 0
            goto L_0x035e
        L_0x0089:
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x01f0 }
            if (r0 == 0) goto L_0x0093
            r14 = 1
            r15.zzZ = r14     // Catch:{ IllegalStateException -> 0x01ec }
            r13 = 0
            goto L_0x01e3
        L_0x0093:
            r14 = 1
            boolean r0 = r15.zzN     // Catch:{ IllegalStateException -> 0x01ec }
            if (r0 == 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzrx r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x01ec }
            com.google.android.gms.internal.ads.zzhd r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x01ec }
            boolean r0 = r0.zzo(r1)     // Catch:{ IllegalStateException -> 0x01ec }
            com.google.android.gms.internal.ads.zzdi.zzf(r0)     // Catch:{ IllegalStateException -> 0x01ec }
            r13 = 0
            r15.zzN = r13     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x00a8
        L_0x00a7:
            r13 = 0
        L_0x00a8:
            boolean r0 = r15.zzO     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzrx r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03de }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 != 0) goto L_0x0025
            r21.zzad()     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzO = r13     // Catch:{ IllegalStateException -> 0x03de }
            r21.zzaB()     // Catch:{ IllegalStateException -> 0x03de }
            boolean r0 = r15.zzM     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x01e3
        L_0x00c0:
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03de }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdi.zzf(r0)     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzjz r0 = r21.zzcY()     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzhd r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x03de }
        L_0x00cf:
            com.google.android.gms.internal.ads.zzhd r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzhd r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            int r1 = r15.zzcW(r0, r1, r13)     // Catch:{ IllegalStateException -> 0x03de }
            r2 = -5
            if (r1 == r2) goto L_0x01c3
            r2 = -4
            if (r1 == r2) goto L_0x00ec
            boolean r0 = r21.zzQ()     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x01c6
            long r0 = r15.zzW     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzX = r0     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x01c6
        L_0x00ec:
            com.google.android.gms.internal.ads.zzhd r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            boolean r2 = r1.zzf()     // Catch:{ IllegalStateException -> 0x03de }
            if (r2 == 0) goto L_0x00fc
            r15.zzY = r14     // Catch:{ IllegalStateException -> 0x03de }
            long r0 = r15.zzW     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzX = r0     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x01c6
        L_0x00fc:
            long r2 = r15.zzW     // Catch:{ IllegalStateException -> 0x03de }
            long r4 = r1.zze     // Catch:{ IllegalStateException -> 0x03de }
            long r1 = java.lang.Math.max(r2, r4)     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzW = r1     // Catch:{ IllegalStateException -> 0x03de }
            boolean r3 = r21.zzQ()     // Catch:{ IllegalStateException -> 0x03de }
            if (r3 != 0) goto L_0x0114
            com.google.android.gms.internal.ads.zzhd r3 = r15.zzg     // Catch:{ IllegalStateException -> 0x03de }
            boolean r3 = r3.zzh()     // Catch:{ IllegalStateException -> 0x03de }
            if (r3 == 0) goto L_0x0116
        L_0x0114:
            r15.zzX = r1     // Catch:{ IllegalStateException -> 0x03de }
        L_0x0116:
            boolean r1 = r15.zzaa     // Catch:{ IllegalStateException -> 0x03de }
            java.lang.String r2 = "audio/opus"
            if (r1 == 0) goto L_0x015d
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzm     // Catch:{ IllegalStateException -> 0x03de }
            r1.getClass()
            r15.zzn = r1     // Catch:{ IllegalStateException -> 0x03de }
            java.lang.String r1 = r1.zzm     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = java.util.Objects.equals(r1, r2)     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            java.util.List r1 = r1.zzo     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = r1.isEmpty()     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 != 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            java.util.List r1 = r1.zzo     // Catch:{ IllegalStateException -> 0x03de }
            java.lang.Object r1 = r1.get(r13)     // Catch:{ IllegalStateException -> 0x03de }
            byte[] r1 = (byte[]) r1     // Catch:{ IllegalStateException -> 0x03de }
            int r1 = com.google.android.gms.internal.ads.zzade.zza(r1)     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzaf r3 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            r3.getClass()
            com.google.android.gms.internal.ads.zzad r3 = r3.zzb()     // Catch:{ IllegalStateException -> 0x03de }
            r3.zzF(r1)     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzaf r1 = r3.zzad()     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzn = r1     // Catch:{ IllegalStateException -> 0x03de }
        L_0x0155:
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            r3 = 0
            r15.zzan(r1, r3)     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzaa = r13     // Catch:{ IllegalStateException -> 0x03de }
        L_0x015d:
            com.google.android.gms.internal.ads.zzhd r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            r1.zzj()     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x0197
            java.lang.String r1 = r1.zzm     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = java.util.Objects.equals(r1, r2)     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x0197
            com.google.android.gms.internal.ads.zzhd r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            boolean r2 = r1.zze()     // Catch:{ IllegalStateException -> 0x03de }
            if (r2 == 0) goto L_0x017d
            com.google.android.gms.internal.ads.zzaf r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            r1.zza = r2     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzaj(r1)     // Catch:{ IllegalStateException -> 0x03de }
        L_0x017d:
            long r1 = r21.zzf()     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzhd r3 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            long r4 = r3.zze     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = com.google.android.gms.internal.ads.zzade.zzf(r1, r4)     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x0197
            com.google.android.gms.internal.ads.zzqw r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzaf r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            r2.getClass()
            java.util.List r2 = r2.zzo     // Catch:{ IllegalStateException -> 0x03de }
            r1.zza(r3, r2)     // Catch:{ IllegalStateException -> 0x03de }
        L_0x0197:
            com.google.android.gms.internal.ads.zzrx r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03de }
            boolean r2 = r1.zzp()     // Catch:{ IllegalStateException -> 0x03de }
            if (r2 != 0) goto L_0x01a0
            goto L_0x01b6
        L_0x01a0:
            long r2 = r21.zzf()     // Catch:{ IllegalStateException -> 0x03de }
            long r4 = r1.zzm()     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = r15.zzaV(r2, r4)     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzhd r4 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            long r4 = r4.zze     // Catch:{ IllegalStateException -> 0x03de }
            boolean r2 = r15.zzaV(r2, r4)     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 != r2) goto L_0x01c0
        L_0x01b6:
            com.google.android.gms.internal.ads.zzrx r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzhd r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = r1.zzo(r2)     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 != 0) goto L_0x00cf
        L_0x01c0:
            r15.zzN = r14     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x01c6
        L_0x01c3:
            r15.zzac(r0)     // Catch:{ IllegalStateException -> 0x03de }
        L_0x01c6:
            com.google.android.gms.internal.ads.zzrx r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03de }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x01d1
            r0.zzj()     // Catch:{ IllegalStateException -> 0x03de }
        L_0x01d1:
            com.google.android.gms.internal.ads.zzrx r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x03de }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 != 0) goto L_0x0025
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 != 0) goto L_0x0025
            boolean r0 = r15.zzO     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x01e3
            goto L_0x0025
        L_0x01e3:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x03de }
            r17 = r13
            r2 = r14
            r1 = r15
            goto L_0x03d3
        L_0x01ec:
            r0 = move-exception
            r2 = r14
            r1 = r15
            goto L_0x01f3
        L_0x01f0:
            r0 = move-exception
            r1 = r15
            r2 = 1
        L_0x01f3:
            r17 = 0
            goto L_0x03e3
        L_0x01f7:
            com.google.android.gms.internal.ads.zzsc r0 = r15.zzr     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x03c1
            r21.zzh()     // Catch:{ IllegalStateException -> 0x03bb }
            android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x03bb }
            java.lang.String r0 = "drainAndFeed"
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x03bb }
        L_0x0206:
            com.google.android.gms.internal.ads.zzsc r6 = r15.zzr     // Catch:{ IllegalStateException -> 0x03bb }
            r6.getClass()
            boolean r0 = r21.zzaU()     // Catch:{ IllegalStateException -> 0x03bb }
            if (r0 != 0) goto L_0x0311
            boolean r0 = r15.zzC     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x022b
            boolean r0 = r15.zzU     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x022b
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x0220 }
            int r0 = r6.zzb(r0)     // Catch:{ IllegalStateException -> 0x0220 }
            goto L_0x0231
        L_0x0220:
            r21.zzao()     // Catch:{ IllegalStateException -> 0x03de }
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x0263
            r21.zzaF()     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x0263
        L_0x022b:
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03de }
            int r0 = r6.zzb(r0)     // Catch:{ IllegalStateException -> 0x03de }
        L_0x0231:
            if (r0 >= 0) goto L_0x0274
            r1 = -2
            if (r0 != r1) goto L_0x025f
            r15.zzV = r14     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzsc r0 = r15.zzr     // Catch:{ IllegalStateException -> 0x03de }
            r0.getClass()
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ IllegalStateException -> 0x03de }
            int r1 = r15.zzz     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x025a
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x03de }
            r2 = 32
            if (r1 != r2) goto L_0x025a
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 != r2) goto L_0x025a
            r15.zzE = r14     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x0206
        L_0x025a:
            r15.zzt = r0     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzu = r14     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x0206
        L_0x025f:
            boolean r0 = r15.zzF     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 != 0) goto L_0x0268
        L_0x0263:
            r17 = r13
        L_0x0265:
            r1 = r15
            goto L_0x03a9
        L_0x0268:
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 != 0) goto L_0x0270
            int r0 = r15.zzR     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 != r11) goto L_0x0263
        L_0x0270:
            r21.zzao()     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x0263
        L_0x0274:
            boolean r1 = r15.zzE     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x027e
            r15.zzE = r13     // Catch:{ IllegalStateException -> 0x03de }
            r6.zzn(r0, r13)     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x0206
        L_0x027e:
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03de }
            int r2 = r1.size     // Catch:{ IllegalStateException -> 0x03de }
            if (r2 != 0) goto L_0x028e
            int r1 = r1.flags     // Catch:{ IllegalStateException -> 0x03de }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x028e
            r21.zzao()     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x0263
        L_0x028e:
            r15.zzI = r0     // Catch:{ IllegalStateException -> 0x03de }
            java.nio.ByteBuffer r0 = r6.zzg(r0)     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzJ = r0     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x02ab
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03de }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x03de }
            r0.position(r1)     // Catch:{ IllegalStateException -> 0x03de }
            java.nio.ByteBuffer r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x03de }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03de }
            int r2 = r1.offset     // Catch:{ IllegalStateException -> 0x03de }
            int r1 = r1.size     // Catch:{ IllegalStateException -> 0x03de }
            int r2 = r2 + r1
            r0.limit(r2)     // Catch:{ IllegalStateException -> 0x03de }
        L_0x02ab:
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03de }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03de }
            long r2 = r21.zzf()     // Catch:{ IllegalStateException -> 0x03de }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x02b9
            r0 = r14
            goto L_0x02ba
        L_0x02b9:
            r0 = r13
        L_0x02ba:
            r15.zzK = r0     // Catch:{ IllegalStateException -> 0x03de }
            long r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x03de }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x02d1
            android.media.MediaCodec$BufferInfo r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x03de }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03de }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x02d1
            r0 = r14
            goto L_0x02d2
        L_0x02d1:
            r0 = r13
        L_0x02d2:
            r15.zzL = r0     // Catch:{ IllegalStateException -> 0x03de }
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03de }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzsn r2 = r15.zzab     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzeq r2 = r2.zze     // Catch:{ IllegalStateException -> 0x03de }
            java.lang.Object r0 = r2.zzc(r0)     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzaf r0 = (com.google.android.gms.internal.ads.zzaf) r0     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 != 0) goto L_0x02f6
            boolean r1 = r15.zzad     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x02f6
            android.media.MediaFormat r1 = r15.zzt     // Catch:{ IllegalStateException -> 0x03de }
            if (r1 == 0) goto L_0x02f6
            com.google.android.gms.internal.ads.zzsn r0 = r15.zzab     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzeq r0 = r0.zze     // Catch:{ IllegalStateException -> 0x03de }
            java.lang.Object r0 = r0.zzb()     // Catch:{ IllegalStateException -> 0x03de }
            com.google.android.gms.internal.ads.zzaf r0 = (com.google.android.gms.internal.ads.zzaf) r0     // Catch:{ IllegalStateException -> 0x03de }
        L_0x02f6:
            if (r0 == 0) goto L_0x02fb
            r15.zzn = r0     // Catch:{ IllegalStateException -> 0x03de }
            goto L_0x0303
        L_0x02fb:
            boolean r0 = r15.zzu     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x0311
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x0311
        L_0x0303:
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzn     // Catch:{ IllegalStateException -> 0x03de }
            r0.getClass()
            android.media.MediaFormat r1 = r15.zzt     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzan(r0, r1)     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzu = r13     // Catch:{ IllegalStateException -> 0x03de }
            r15.zzad = r13     // Catch:{ IllegalStateException -> 0x03de }
        L_0x0311:
            boolean r0 = r15.zzC     // Catch:{ IllegalStateException -> 0x03bb }
            if (r0 == 0) goto L_0x0362
            boolean r0 = r15.zzU     // Catch:{ IllegalStateException -> 0x03de }
            if (r0 == 0) goto L_0x0362
            java.nio.ByteBuffer r7 = r15.zzJ     // Catch:{ IllegalStateException -> 0x034c }
            int r8 = r15.zzI     // Catch:{ IllegalStateException -> 0x034c }
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x034c }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x034c }
            long r4 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x034c }
            boolean r0 = r15.zzK     // Catch:{ IllegalStateException -> 0x034c }
            boolean r12 = r15.zzL     // Catch:{ IllegalStateException -> 0x034c }
            com.google.android.gms.internal.ads.zzaf r10 = r15.zzn     // Catch:{ IllegalStateException -> 0x034c }
            r10.getClass()
            r16 = 1
            r1 = r21
            r2 = r22
            r17 = r4
            r4 = r24
            r19 = r10
            r10 = r16
            r20 = r11
            r16 = r12
            r11 = r17
            r17 = r13
            r13 = r0
            r14 = r16
            r15 = r19
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x034e }
            goto L_0x0385
        L_0x034c:
            r17 = r13
        L_0x034e:
            r21.zzao()     // Catch:{ IllegalStateException -> 0x035c }
            r15 = r21
            boolean r0 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03b8 }
            if (r0 == 0) goto L_0x0265
            r21.zzaF()     // Catch:{ IllegalStateException -> 0x03b8 }
            goto L_0x0265
        L_0x035c:
            r0 = move-exception
            r2 = 1
        L_0x035e:
            r1 = r21
            goto L_0x03e3
        L_0x0362:
            r20 = r11
            r17 = r13
            java.nio.ByteBuffer r7 = r15.zzJ     // Catch:{ IllegalStateException -> 0x03b8 }
            int r8 = r15.zzI     // Catch:{ IllegalStateException -> 0x03b8 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x03b8 }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x03b8 }
            long r11 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03b8 }
            boolean r13 = r15.zzK     // Catch:{ IllegalStateException -> 0x03b8 }
            boolean r14 = r15.zzL     // Catch:{ IllegalStateException -> 0x03b8 }
            com.google.android.gms.internal.ads.zzaf r0 = r15.zzn     // Catch:{ IllegalStateException -> 0x03b8 }
            r0.getClass()
            r10 = 1
            r1 = r21
            r2 = r22
            r4 = r24
            r15 = r0
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x03b4 }
        L_0x0385:
            if (r0 == 0) goto L_0x03a7
            r1 = r21
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x03db }
            long r2 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03db }
            r1.zzaC(r2)     // Catch:{ IllegalStateException -> 0x03db }
            android.media.MediaCodec$BufferInfo r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x03db }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x03db }
            r0 = r0 & 4
            r21.zzaP()     // Catch:{ IllegalStateException -> 0x03db }
            if (r0 == 0) goto L_0x039f
            r21.zzao()     // Catch:{ IllegalStateException -> 0x03db }
            goto L_0x03a9
        L_0x039f:
            r15 = r1
            r13 = r17
            r11 = r20
            r14 = 1
            goto L_0x0206
        L_0x03a7:
            r1 = r21
        L_0x03a9:
            boolean r0 = r21.zzaT()     // Catch:{ IllegalStateException -> 0x03db }
            if (r0 != 0) goto L_0x03a9
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x03db }
            r2 = 1
            goto L_0x03d3
        L_0x03b4:
            r0 = move-exception
            r1 = r21
            goto L_0x03dc
        L_0x03b8:
            r0 = move-exception
            r1 = r15
            goto L_0x03dc
        L_0x03bb:
            r0 = move-exception
            r17 = r13
            r1 = r15
            r2 = r14
            goto L_0x03e3
        L_0x03c1:
            r17 = r13
            r1 = r15
            com.google.android.gms.internal.ads.zzhn r0 = r1.zza     // Catch:{ IllegalStateException -> 0x03db }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x03db }
            int r3 = r21.zzd(r22)     // Catch:{ IllegalStateException -> 0x03db }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x03db }
            r2 = 1
            r1.zzaW(r2)     // Catch:{ IllegalStateException -> 0x03d9 }
        L_0x03d3:
            com.google.android.gms.internal.ads.zzhn r0 = r1.zza     // Catch:{ IllegalStateException -> 0x03d9 }
            r0.zza()     // Catch:{ IllegalStateException -> 0x03d9 }
            return
        L_0x03d9:
            r0 = move-exception
            goto L_0x03e3
        L_0x03db:
            r0 = move-exception
        L_0x03dc:
            r2 = 1
            goto L_0x03e3
        L_0x03de:
            r0 = move-exception
            r17 = r13
            r2 = r14
            r1 = r15
        L_0x03e3:
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x03ea
            goto L_0x03ff
        L_0x03ea:
            java.lang.StackTraceElement[] r4 = r0.getStackTrace()
            int r5 = r4.length
            if (r5 <= 0) goto L_0x042e
            r4 = r4[r17]
            java.lang.String r4 = r4.getClassName()
            java.lang.String r5 = "android.media.MediaCodec"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x042e
        L_0x03ff:
            r1.zzak(r0)
            if (r3 == 0) goto L_0x040f
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x040f
            r14 = r2
            goto L_0x0411
        L_0x040f:
            r14 = r17
        L_0x0411:
            if (r14 == 0) goto L_0x0416
            r21.zzaF()
        L_0x0416:
            com.google.android.gms.internal.ads.zzsf r2 = r1.zzy
            com.google.android.gms.internal.ads.zzse r0 = r1.zzaz(r0, r2)
            int r2 = r0.zzb
            r3 = 1101(0x44d, float:1.543E-42)
            if (r2 != r3) goto L_0x0425
            r2 = 4006(0xfa6, float:5.614E-42)
            goto L_0x0427
        L_0x0425:
            r2 = 4003(0xfa3, float:5.61E-42)
        L_0x0427:
            com.google.android.gms.internal.ads.zzaf r3 = r1.zzm
            com.google.android.gms.internal.ads.zzhw r0 = r1.zzi(r0, r3, r14, r2)
            throw r0
        L_0x042e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzV(long, long):void");
    }

    public boolean zzW() {
        return this.zzZ;
    }

    public boolean zzX() {
        if (this.zzm == null) {
            return false;
        }
        if (zzS() || zzaU()) {
            return true;
        }
        if (this.zzG == -9223372036854775807L) {
            return false;
        }
        zzh();
        if (SystemClock.elapsedRealtime() >= this.zzG) {
            return false;
        }
        return true;
    }

    public final int zzY(zzaf zzaf2) throws zzhw {
        try {
            return zzaa(this.zzd, zzaf2);
        } catch (zzsw e) {
            throw zzi(e, zzaf2, false, 4002);
        }
    }

    public float zzZ(float f, zzaf zzaf2, zzaf[] zzafArr) {
        throw null;
    }

    public final zzsf zzaA() {
        return this.zzy;
    }

    public final void zzaB() throws zzhw {
        zzaf zzaf2;
        zzaf zzaf3;
        if (this.zzr == null && !this.zzM && (zzaf2 = this.zzm) != null) {
            if (zzaL(zzaf2)) {
                zzad();
                String str = zzaf2.zzm;
                if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                    this.zzi.zzn(32);
                } else {
                    this.zzi.zzn(1);
                }
                this.zzM = true;
                return;
            }
            zzrj zzrj = this.zzaf;
            this.zzae = zzrj;
            if (zzrj != null) {
                zzdi.zzf(true);
                zzrj zzrj2 = this.zzae;
                boolean z = zzrk.zza;
                zzrj2.zza();
            }
            try {
                if (this.zzae != null) {
                    zzdi.zzb(zzaf2.zzm);
                }
                zzaf3 = this.zzm;
                zzaf3.getClass();
                if (this.zzw == null) {
                    List zzag = zzag(this.zzd, zzaf3, false);
                    zzag.isEmpty();
                    this.zzw = new ArrayDeque();
                    if (!zzag.isEmpty()) {
                        this.zzw.add((zzsf) zzag.get(0));
                    }
                    this.zzx = null;
                }
                if (!this.zzw.isEmpty()) {
                    ArrayDeque arrayDeque = this.zzw;
                    arrayDeque.getClass();
                    zzsf zzsf = (zzsf) arrayDeque.peekFirst();
                    while (this.zzr == null) {
                        zzsf zzsf2 = (zzsf) arrayDeque.peekFirst();
                        zzsf2.getClass();
                        if (zzaM(zzsf2)) {
                            try {
                                zzai(zzsf2, (MediaCrypto) null);
                            } catch (Exception e) {
                                if (zzsf2 == zzsf) {
                                    zzea.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                                    Thread.sleep(50);
                                    zzai(zzsf2, (MediaCrypto) null);
                                } else {
                                    throw e;
                                }
                            } catch (Exception e2) {
                                zzea.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zzsf2.zza), e2);
                                arrayDeque.removeFirst();
                                zzsk zzsk = new zzsk(zzaf3, (Throwable) e2, false, zzsf2);
                                zzak(zzsk);
                                zzsk zzsk2 = this.zzx;
                                if (zzsk2 == null) {
                                    this.zzx = zzsk;
                                } else {
                                    this.zzx = zzsk.zza(zzsk2, zzsk);
                                }
                                if (arrayDeque.isEmpty()) {
                                    throw this.zzx;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    this.zzw = null;
                    return;
                }
                throw new zzsk(zzaf3, (Throwable) null, false, -49999);
            } catch (zzsw e3) {
                throw new zzsk(zzaf3, (Throwable) e3, false, -49998);
            } catch (zzsk e4) {
                throw zzi(e4, zzaf2, false, 4001);
            }
        }
    }

    public void zzaC(long j) {
        this.zzac = j;
        while (!this.zzk.isEmpty() && j >= ((zzsn) this.zzk.peek()).zzb) {
            zzsn zzsn = (zzsn) this.zzk.poll();
            zzsn.getClass();
            zzaQ(zzsn);
            zzap();
        }
    }

    public final void zzaF() {
        try {
            zzsc zzsc = this.zzr;
            if (zzsc != null) {
                zzsc.zzl();
                this.zza.zzb++;
                zzsf zzsf = this.zzy;
                zzsf.getClass();
                zzam(zzsf.zza);
            }
        } finally {
            this.zzr = null;
            this.zzp = null;
            this.zzae = null;
            zzaH();
        }
    }

    public void zzaG() {
        zzaO();
        zzaP();
        this.zzG = -9223372036854775807L;
        this.zzU = false;
        this.zzT = false;
        this.zzD = false;
        this.zzE = false;
        this.zzK = false;
        this.zzL = false;
        this.zzW = -9223372036854775807L;
        this.zzX = -9223372036854775807L;
        this.zzac = -9223372036854775807L;
        this.zzR = 0;
        this.zzS = 0;
        this.zzQ = this.zzP ? 1 : 0;
    }

    public final void zzaH() {
        zzaG();
        this.zzw = null;
        this.zzy = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = false;
        this.zzV = false;
        this.zzv = -1.0f;
        this.zzz = 0;
        this.zzA = false;
        this.zzB = false;
        this.zzC = false;
        this.zzF = false;
        this.zzP = false;
        this.zzQ = 0;
    }

    public final boolean zzaI() throws zzhw {
        boolean zzaJ = zzaJ();
        if (zzaJ) {
            zzaB();
        }
        return zzaJ;
    }

    public final boolean zzaJ() {
        boolean z;
        if (this.zzr == null) {
            return false;
        }
        int i = this.zzS;
        if (i == 3 || ((this.zzA && !this.zzV) || (this.zzB && this.zzU))) {
            zzaF();
            return true;
        }
        if (i == 2) {
            int i2 = zzet.zza;
            if (i2 >= 23) {
                z = true;
            } else {
                z = false;
            }
            zzdi.zzf(z);
            if (i2 >= 23) {
                try {
                    zzaR();
                } catch (zzhw e) {
                    zzea.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzaF();
                    return true;
                }
            }
        }
        zzah();
        return false;
    }

    public final boolean zzaK() {
        return this.zzM;
    }

    public final boolean zzaL(zzaf zzaf2) {
        if (this.zzaf != null || !zzas(zzaf2)) {
            return false;
        }
        return true;
    }

    public boolean zzaM(zzsf zzsf) {
        return true;
    }

    public abstract int zzaa(zzsq zzsq, zzaf zzaf2) throws zzsw;

    public zzho zzab(zzsf zzsf, zzaf zzaf2, zzaf zzaf3) {
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0082, code lost:
        if (zzaS() == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ae, code lost:
        if (zzaS() == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c1, code lost:
        if (zzaS() == false) goto L_0x00d8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ee A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzho zzac(com.google.android.gms.internal.ads.zzjz r12) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r11 = this;
            r0 = 1
            r11.zzaa = r0
            com.google.android.gms.internal.ads.zzaf r1 = r12.zza
            r1.getClass()
            java.lang.String r2 = r1.zzm
            r3 = 0
            if (r2 == 0) goto L_0x00fe
            java.lang.String r4 = "video/av01"
            boolean r2 = r2.equals(r4)
            r4 = 0
            if (r2 == 0) goto L_0x0029
            java.util.List r2 = r1.zzo
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0029
            com.google.android.gms.internal.ads.zzad r1 = r1.zzb()
            r1.zzL(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r1.zzad()
        L_0x0029:
            r8 = r1
            com.google.android.gms.internal.ads.zzrj r12 = r12.zzb
            r11.zzaf = r12
            r11.zzm = r8
            boolean r1 = r11.zzM
            if (r1 == 0) goto L_0x0037
            r11.zzO = r0
            return r4
        L_0x0037:
            com.google.android.gms.internal.ads.zzsc r1 = r11.zzr
            if (r1 != 0) goto L_0x0041
            r11.zzw = r4
            r11.zzaB()
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzsf r2 = r11.zzy
            r2.getClass()
            com.google.android.gms.internal.ads.zzaf r7 = r11.zzs
            r7.getClass()
            com.google.android.gms.internal.ads.zzrj r4 = r11.zzae
            if (r4 != r12) goto L_0x00ef
            if (r12 == r4) goto L_0x0053
            r12 = r0
            goto L_0x0054
        L_0x0053:
            r12 = r3
        L_0x0054:
            if (r12 == 0) goto L_0x005f
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            r5 = 23
            if (r4 < r5) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r4 = r3
            goto L_0x0060
        L_0x005f:
            r4 = r0
        L_0x0060:
            com.google.android.gms.internal.ads.zzdi.zzf(r4)
            com.google.android.gms.internal.ads.zzho r4 = r11.zzab(r2, r7, r8)
            int r5 = r4.zzd
            r6 = 3
            if (r5 == 0) goto L_0x00d4
            r9 = 16
            r10 = 2
            if (r5 == r0) goto L_0x00b1
            if (r5 == r10) goto L_0x0085
            boolean r0 = r11.zzaX(r8)
            if (r0 != 0) goto L_0x007a
            goto L_0x00b7
        L_0x007a:
            r11.zzs = r8
            if (r12 == 0) goto L_0x00d7
            boolean r12 = r11.zzaS()
            if (r12 != 0) goto L_0x00d7
            goto L_0x00d8
        L_0x0085:
            boolean r5 = r11.zzaX(r8)
            if (r5 != 0) goto L_0x008c
            goto L_0x00b7
        L_0x008c:
            r11.zzP = r0
            r11.zzQ = r0
            int r5 = r11.zzz
            if (r5 == r10) goto L_0x00a4
            if (r5 != r0) goto L_0x00a3
            int r5 = r8.zzr
            int r9 = r7.zzr
            if (r5 != r9) goto L_0x00a3
            int r5 = r8.zzs
            int r9 = r7.zzs
            if (r5 != r9) goto L_0x00a3
            goto L_0x00a4
        L_0x00a3:
            r0 = r3
        L_0x00a4:
            r11.zzD = r0
            r11.zzs = r8
            if (r12 == 0) goto L_0x00d7
            boolean r12 = r11.zzaS()
            if (r12 != 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00b1:
            boolean r5 = r11.zzaX(r8)
            if (r5 != 0) goto L_0x00b9
        L_0x00b7:
            r10 = r9
            goto L_0x00d8
        L_0x00b9:
            r11.zzs = r8
            if (r12 == 0) goto L_0x00c4
            boolean r12 = r11.zzaS()
            if (r12 != 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00c4:
            boolean r12 = r11.zzT
            if (r12 == 0) goto L_0x00d7
            r11.zzR = r0
            boolean r12 = r11.zzB
            if (r12 == 0) goto L_0x00d1
            r11.zzS = r6
            goto L_0x00d8
        L_0x00d1:
            r11.zzS = r0
            goto L_0x00d7
        L_0x00d4:
            r11.zzae()
        L_0x00d7:
            r10 = r3
        L_0x00d8:
            int r12 = r4.zzd
            if (r12 == 0) goto L_0x00ee
            com.google.android.gms.internal.ads.zzsc r12 = r11.zzr
            if (r12 != r1) goto L_0x00e4
            int r12 = r11.zzS
            if (r12 != r6) goto L_0x00ee
        L_0x00e4:
            java.lang.String r6 = r2.zza
            com.google.android.gms.internal.ads.zzho r12 = new com.google.android.gms.internal.ads.zzho
            r9 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            return r12
        L_0x00ee:
            return r4
        L_0x00ef:
            r11.zzae()
            java.lang.String r6 = r2.zza
            com.google.android.gms.internal.ads.zzho r12 = new com.google.android.gms.internal.ads.zzho
            r9 = 0
            r10 = 128(0x80, float:1.794E-43)
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            return r12
        L_0x00fe:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Sample MIME type is null."
            r12.<init>(r0)
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zzhw r12 = r11.zzi(r12, r1, r3, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzso.zzac(com.google.android.gms.internal.ads.zzjz):com.google.android.gms.internal.ads.zzho");
    }

    public abstract zzrz zzaf(zzsf zzsf, zzaf zzaf2, MediaCrypto mediaCrypto, float f);

    public abstract List zzag(zzsq zzsq, zzaf zzaf2, boolean z) throws zzsw;

    public void zzaj(zzhd zzhd) throws zzhw {
        throw null;
    }

    public void zzak(Exception exc) {
        throw null;
    }

    public void zzal(String str, zzrz zzrz, long j, long j2) {
        throw null;
    }

    public void zzam(String str) {
        throw null;
    }

    public void zzan(zzaf zzaf2, MediaFormat mediaFormat) throws zzhw {
        throw null;
    }

    public abstract boolean zzar(long j, long j2, zzsc zzsc, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzaf2) throws zzhw;

    public boolean zzas(zzaf zzaf2) {
        return false;
    }

    public int zzat(zzhd zzhd) {
        return 0;
    }

    public final long zzau() {
        return this.zzab.zzd;
    }

    public final long zzav() {
        return this.zzab.zzc;
    }

    public final zzld zzax() {
        return this.zzo;
    }

    public final zzsc zzay() {
        return this.zzr;
    }

    public zzse zzaz(Throwable th, zzsf zzsf) {
        return new zzse(th, zzsf);
    }

    public final int zze() {
        return 8;
    }

    public void zzt(int i, Object obj) throws zzhw {
        if (i == 11) {
            this.zzo = (zzld) obj;
        }
    }

    public void zzw() {
        this.zzm = null;
        zzaQ(zzsn.zza);
        this.zzk.clear();
        zzaJ();
    }

    public void zzx(boolean z, boolean z2) throws zzhw {
        this.zza = new zzhn();
    }

    public void zzz(long j, boolean z) throws zzhw {
        this.zzY = false;
        this.zzZ = false;
        if (this.zzM) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzN = false;
            this.zzl.zzb();
        } else {
            zzaI();
        }
        zzeq zzeq = this.zzab.zze;
        if (zzeq.zza() > 0) {
            this.zzaa = true;
        }
        zzeq.zze();
        this.zzk.clear();
    }

    public void zzap() {
    }

    public void zzaq() throws zzhw {
    }

    public void zzaD(zzhd zzhd) throws zzhw {
    }

    public void zzaE(zzaf zzaf2) throws zzhw {
    }
}
