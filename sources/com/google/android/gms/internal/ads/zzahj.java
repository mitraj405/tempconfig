package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzahj implements zzack {
    private static final byte[] zza = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final byte[] zzb = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfuj.zzc);
    private static final byte[] zzc = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] zzd = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    /* access modifiers changed from: private */
    public static final UUID zze = new UUID(72057594037932032L, -9223371306706625679L);
    /* access modifiers changed from: private */
    public static final Map zzf;
    private long zzA;
    private long zzB;
    private zzahi zzC;
    private boolean zzD;
    private int zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private long zzJ;
    private zzeb zzK;
    private zzeb zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private long zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    private int[] zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private long zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private int zzag;
    private byte zzah;
    private boolean zzai;
    private zzacn zzaj;
    private final zzahf zzg;
    private final zzahl zzh;
    private final SparseArray zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final zzajy zzl;
    private final zzek zzm;
    private final zzek zzn;
    private final zzek zzo;
    private final zzek zzp;
    private final zzek zzq;
    private final zzek zzr;
    private final zzek zzs;
    private final zzek zzt;
    private final zzek zzu;
    private final zzek zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzet.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzf = Collections.unmodifiableMap(hashMap);
    }

    @Deprecated
    public zzahj() {
        this(new zzahd(), 2, zzajy.zza);
    }

    private static int[] zzA(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        if (length >= i) {
            return iArr;
        }
        return new int[Math.max(length + length, i)];
    }

    private final int zzq(zzacl zzacl, zzahi zzahi, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzahi.zzb)) {
            zzy(zzacl, zza, i);
            int i3 = this.zzab;
            zzx();
            return i3;
        } else if ("S_TEXT/ASS".equals(zzahi.zzb)) {
            zzy(zzacl, zzc, i);
            int i4 = this.zzab;
            zzx();
            return i4;
        } else if ("S_TEXT/WEBVTT".equals(zzahi.zzb)) {
            zzy(zzacl, zzd, i);
            int i5 = this.zzab;
            zzx();
            return i5;
        } else {
            zzadp zzadp = zzahi.zzW;
            boolean z2 = true;
            if (!this.zzad) {
                if (zzahi.zzg) {
                    this.zzW &= -1073741825;
                    int i6 = 128;
                    if (!this.zzae) {
                        ((zzaby) zzacl).zzn(this.zzo.zzM(), 0, 1, false);
                        this.zzaa++;
                        if ((this.zzo.zzM()[0] & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                            this.zzah = this.zzo.zzM()[0];
                            this.zzae = true;
                        } else {
                            throw zzbo.zza("Extension bit is set in signal byte", (Throwable) null);
                        }
                    }
                    byte b = this.zzah;
                    if ((b & 1) == 1) {
                        byte b2 = b & 2;
                        this.zzW |= Ints.MAX_POWER_OF_TWO;
                        if (!this.zzai) {
                            ((zzaby) zzacl).zzn(this.zzt.zzM(), 0, 8, false);
                            this.zzaa += 8;
                            this.zzai = true;
                            zzek zzek = this.zzo;
                            if (b2 != 2) {
                                i6 = 0;
                            }
                            zzek.zzM()[0] = (byte) (i6 | 8);
                            this.zzo.zzK(0);
                            zzadp.zzr(this.zzo, 1, 1);
                            this.zzab++;
                            this.zzt.zzK(0);
                            zzadp.zzr(this.zzt, 8, 1);
                            this.zzab += 8;
                        }
                        if (b2 == 2) {
                            if (!this.zzaf) {
                                ((zzaby) zzacl).zzn(this.zzo.zzM(), 0, 1, false);
                                this.zzaa++;
                                this.zzo.zzK(0);
                                this.zzag = this.zzo.zzm();
                                this.zzaf = true;
                            }
                            int i7 = this.zzag * 4;
                            this.zzo.zzH(i7);
                            ((zzaby) zzacl).zzn(this.zzo.zzM(), 0, i7, false);
                            this.zzaa += i7;
                            int i8 = (this.zzag >> 1) + 1;
                            int i9 = (i8 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzw;
                            if (byteBuffer == null || byteBuffer.capacity() < i9) {
                                this.zzw = ByteBuffer.allocate(i9);
                            }
                            this.zzw.position(0);
                            this.zzw.putShort((short) i8);
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                i2 = this.zzag;
                                if (i10 >= i2) {
                                    break;
                                }
                                int zzp2 = this.zzo.zzp();
                                int i12 = zzp2 - i11;
                                if (i10 % 2 == 0) {
                                    this.zzw.putShort((short) i12);
                                } else {
                                    this.zzw.putInt(i12);
                                }
                                i10++;
                                i11 = zzp2;
                            }
                            int i13 = (i - this.zzaa) - i11;
                            if ((i2 & 1) == 1) {
                                this.zzw.putInt(i13);
                            } else {
                                this.zzw.putShort((short) i13);
                                this.zzw.putInt(0);
                            }
                            this.zzu.zzI(this.zzw.array(), i9);
                            zzadp.zzr(this.zzu, i9, 1);
                            this.zzab += i9;
                        }
                    }
                } else {
                    byte[] bArr = zzahi.zzh;
                    if (bArr != null) {
                        this.zzr.zzI(bArr, bArr.length);
                    }
                }
                if (!"A_OPUS".equals(zzahi.zzb) ? zzahi.zzf > 0 : z) {
                    this.zzW |= 268435456;
                    this.zzv.zzH(0);
                    int zze2 = (this.zzr.zze() + i) - this.zzaa;
                    this.zzo.zzH(4);
                    this.zzo.zzM()[0] = (byte) ((zze2 >> 24) & Constants.MAX_HOST_LENGTH);
                    this.zzo.zzM()[1] = (byte) ((zze2 >> 16) & Constants.MAX_HOST_LENGTH);
                    this.zzo.zzM()[2] = (byte) ((zze2 >> 8) & Constants.MAX_HOST_LENGTH);
                    this.zzo.zzM()[3] = (byte) (zze2 & Constants.MAX_HOST_LENGTH);
                    zzadp.zzr(this.zzo, 4, 2);
                    this.zzab += 4;
                }
                this.zzad = true;
            }
            int zze3 = this.zzr.zze() + i;
            if (!"V_MPEG4/ISO/AVC".equals(zzahi.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzahi.zzb)) {
                if (zzahi.zzT != null) {
                    if (this.zzr.zze() != 0) {
                        z2 = false;
                    }
                    zzdi.zzf(z2);
                    zzahi.zzT.zzd(zzacl);
                }
                while (true) {
                    int i14 = this.zzaa;
                    if (i14 >= zze3) {
                        break;
                    }
                    int zzr2 = zzr(zzacl, zzadp, zze3 - i14);
                    this.zzaa += zzr2;
                    this.zzab += zzr2;
                }
            } else {
                byte[] zzM2 = this.zzn.zzM();
                zzM2[0] = 0;
                zzM2[1] = 0;
                zzM2[2] = 0;
                int i15 = zzahi.zzX;
                int i16 = 4 - i15;
                while (this.zzaa < zze3) {
                    int i17 = this.zzac;
                    if (i17 == 0) {
                        int min = Math.min(i15, this.zzr.zzb());
                        ((zzaby) zzacl).zzn(zzM2, i16 + min, i15 - min, false);
                        if (min > 0) {
                            this.zzr.zzG(zzM2, i16, min);
                        }
                        this.zzaa += i15;
                        this.zzn.zzK(0);
                        this.zzac = this.zzn.zzp();
                        this.zzm.zzK(0);
                        zzadp.zzq(this.zzm, 4);
                        this.zzab += 4;
                    } else {
                        int zzr3 = zzr(zzacl, zzadp, i17);
                        this.zzaa += zzr3;
                        this.zzab += zzr3;
                        this.zzac -= zzr3;
                    }
                }
            }
            if ("A_VORBIS".equals(zzahi.zzb)) {
                this.zzp.zzK(0);
                zzadp.zzq(this.zzp, 4);
                this.zzab += 4;
            }
            int i18 = this.zzab;
            zzx();
            return i18;
        }
    }

    private final int zzr(zzacl zzacl, zzadp zzadp, int i) throws IOException {
        int zzb2 = this.zzr.zzb();
        if (zzb2 <= 0) {
            return zzadp.zzf(zzacl, i, false);
        }
        int min = Math.min(i, zzb2);
        zzadp.zzq(this.zzr, min);
        return min;
    }

    private final long zzs(long j) throws zzbo {
        long j2 = this.zzz;
        if (j2 != -9223372036854775807L) {
            return zzet.zzt(j, j2, 1000, RoundingMode.FLOOR);
        }
        throw zzbo.zza("Can't scale timecode prior to timecodeScale being set.", (Throwable) null);
    }

    private final void zzt(int i) throws zzbo {
        if (this.zzK == null || this.zzL == null) {
            throw zzbo.zza("Element " + i + " must be in a Cues", (Throwable) null);
        }
    }

    private final void zzu(int i) throws zzbo {
        if (this.zzC == null) {
            throw zzbo.zza("Element " + i + " must be in a TrackEntry", (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0 A[EDGE_INSN: B:59:0x00e0->B:48:0x00e0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzv(com.google.android.gms.internal.ads.zzahi r18, long r19, int r21, int r22, int r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.google.android.gms.internal.ads.zzadq r2 = r1.zzT
            r9 = 1
            if (r2 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzadp r3 = r1.zzW
            com.google.android.gms.internal.ads.zzado r8 = r1.zzi
            r1 = r2
            r2 = r3
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r23
            r1.zzc(r2, r3, r5, r6, r7, r8)
            goto L_0x0121
        L_0x001c:
            java.lang.String r2 = r1.zzb
            java.lang.String r3 = "S_TEXT/UTF8"
            boolean r2 = r3.equals(r2)
            java.lang.String r4 = "S_TEXT/WEBVTT"
            java.lang.String r5 = "S_TEXT/ASS"
            r6 = 0
            r7 = 2
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x003c
            java.lang.String r2 = r1.zzb
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0058
        L_0x003c:
            int r2 = r0.zzS
            java.lang.String r8 = "MatroskaExtractor"
            if (r2 <= r9) goto L_0x0048
            java.lang.String r2 = "Skipping subtitle sample in laced block."
            com.google.android.gms.internal.ads.zzea.zzf(r8, r2)
            goto L_0x0058
        L_0x0048:
            long r10 = r0.zzQ
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x005c
            java.lang.String r2 = "Skipping subtitle sample with no duration."
            com.google.android.gms.internal.ads.zzea.zzf(r8, r2)
        L_0x0058:
            r2 = r22
            goto L_0x00f3
        L_0x005c:
            java.lang.String r2 = r1.zzb
            com.google.android.gms.internal.ads.zzek r8 = r0.zzs
            byte[] r8 = r8.zzM()
            int r12 = r2.hashCode()
            r13 = 738597099(0x2c0618eb, float:1.9056378E-12)
            if (r12 == r13) goto L_0x0088
            r5 = 1045209816(0x3e4ca2d8, float:0.19983995)
            if (r12 == r5) goto L_0x0080
            r4 = 1422270023(0x54c61e47, float:6.807292E12)
            if (r12 == r4) goto L_0x0078
            goto L_0x0090
        L_0x0078:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0090
            r2 = r6
            goto L_0x0091
        L_0x0080:
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0090
            r2 = r7
            goto L_0x0091
        L_0x0088:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0090
            r2 = r9
            goto L_0x0091
        L_0x0090:
            r2 = -1
        L_0x0091:
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x00b3
            if (r2 == r9) goto L_0x00a8
            if (r2 != r7) goto L_0x00a2
            java.lang.String r2 = "%02d:%02d:%02d.%03d"
            byte[] r2 = zzz(r10, r2, r3)
            r3 = 25
            goto L_0x00bb
        L_0x00a2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        L_0x00a8:
            java.lang.String r2 = "%01d:%02d:%02d:%02d"
            r3 = 10000(0x2710, double:4.9407E-320)
            byte[] r2 = zzz(r10, r2, r3)
            r3 = 21
            goto L_0x00bb
        L_0x00b3:
            java.lang.String r2 = "%02d:%02d:%02d,%03d"
            byte[] r2 = zzz(r10, r2, r3)
            r3 = 19
        L_0x00bb:
            int r4 = r2.length
            java.lang.System.arraycopy(r2, r6, r8, r3, r4)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzs
            int r2 = r2.zzd()
        L_0x00c5:
            com.google.android.gms.internal.ads.zzek r3 = r0.zzs
            int r3 = r3.zze()
            if (r2 >= r3) goto L_0x00e0
            com.google.android.gms.internal.ads.zzek r3 = r0.zzs
            byte[] r3 = r3.zzM()
            byte r3 = r3[r2]
            if (r3 != 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzek r3 = r0.zzs
            r3.zzJ(r2)
            goto L_0x00e0
        L_0x00dd:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x00e0:
            com.google.android.gms.internal.ads.zzadp r2 = r1.zzW
            com.google.android.gms.internal.ads.zzek r3 = r0.zzs
            int r4 = r3.zze()
            r2.zzq(r3, r4)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzs
            int r2 = r2.zze()
            int r2 = r2 + r22
        L_0x00f3:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r21 & r3
            if (r3 == 0) goto L_0x0111
            int r3 = r0.zzS
            if (r3 <= r9) goto L_0x0103
            com.google.android.gms.internal.ads.zzek r3 = r0.zzv
            r3.zzH(r6)
            goto L_0x0111
        L_0x0103:
            com.google.android.gms.internal.ads.zzek r3 = r0.zzv
            int r3 = r3.zze()
            com.google.android.gms.internal.ads.zzadp r4 = r1.zzW
            com.google.android.gms.internal.ads.zzek r5 = r0.zzv
            r4.zzr(r5, r3, r7)
            int r2 = r2 + r3
        L_0x0111:
            r14 = r2
            com.google.android.gms.internal.ads.zzadp r10 = r1.zzW
            com.google.android.gms.internal.ads.zzado r1 = r1.zzi
            r11 = r19
            r13 = r21
            r15 = r23
            r16 = r1
            r10.zzs(r11, r13, r14, r15, r16)
        L_0x0121:
            r0.zzN = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zzv(com.google.android.gms.internal.ads.zzahi, long, int, int, int):void");
    }

    private final void zzw(zzacl zzacl, int i) throws IOException {
        if (this.zzo.zze() < i) {
            if (this.zzo.zzc() < i) {
                zzek zzek = this.zzo;
                int zzc2 = zzek.zzc();
                zzek.zzE(Math.max(zzc2 + zzc2, i));
            }
            zzek zzek2 = this.zzo;
            ((zzaby) zzacl).zzn(zzek2.zzM(), zzek2.zze(), i - zzek2.zze(), false);
            this.zzo.zzJ(i);
        }
    }

    private final void zzx() {
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = 0;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = false;
        this.zzag = 0;
        this.zzah = 0;
        this.zzai = false;
        this.zzr.zzH(0);
    }

    private final void zzy(zzacl zzacl, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        if (this.zzs.zzc() < i2) {
            zzek zzek = this.zzs;
            byte[] copyOf = Arrays.copyOf(bArr, i2 + i);
            zzek.zzI(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzs.zzM(), 0, length);
        }
        ((zzaby) zzacl).zzn(this.zzs.zzM(), length, i, false);
        this.zzs.zzK(0);
        this.zzs.zzJ(i2);
    }

    private static byte[] zzz(long j, String str, long j2) {
        boolean z;
        if (j != -9223372036854775807L) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        int i = (int) (j / 3600000000L);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String format = String.format(Locale.US, str, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))});
        int i4 = zzet.zza;
        return format.getBytes(zzfuj.zzc);
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        this.zzN = false;
        while (!this.zzN) {
            if (this.zzg.zzc(zzacl)) {
                long zzf2 = zzacl.zzf();
                if (this.zzG) {
                    this.zzI = zzf2;
                    zzadf.zza = this.zzH;
                    this.zzG = false;
                    return 1;
                } else if (this.zzD) {
                    long j = this.zzI;
                    if (j != -1) {
                        zzadf.zza = j;
                        this.zzI = -1;
                        return 1;
                    }
                }
            } else {
                for (int i = 0; i < this.zzi.size(); i++) {
                    zzahi zzahi = (zzahi) this.zzi.valueAt(i);
                    zzahi.zzW.getClass();
                    zzadq zzadq = zzahi.zzT;
                    if (zzadq != null) {
                        zzadq.zza(zzahi.zzW, zzahi.zzi);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzaj = zzacn;
        if (this.zzk) {
            zzacn = new zzakc(zzacn, this.zzl);
        }
        this.zzaj = zzacn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:97:0x027c, code lost:
        throw com.google.android.gms.internal.ads.zzbo.zza("EBML lacing sample size out of range.", (java.lang.Throwable) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(int r20, int r21, com.google.android.gms.internal.ads.zzacl r22) throws java.io.IOException {
        /*
            r19 = this;
            r7 = r19
            r0 = r20
            r1 = r21
            r8 = r22
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 0
            r4 = 4
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            if (r0 == r2) goto L_0x0110
            if (r0 == r5) goto L_0x0110
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00d9
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00af
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x009f
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x008a
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x0064
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0054
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x0041
            r19.zzu(r20)
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            byte[] r2 = new byte[r1]
            r0.zzv = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaby r0 = (com.google.android.gms.internal.ads.zzaby) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x0041:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected id: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r3)
            throw r0
        L_0x0054:
            r19.zzu(r20)
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            byte[] r2 = new byte[r1]
            r0.zzj = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaby r0 = (com.google.android.gms.internal.ads.zzaby) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x0064:
            com.google.android.gms.internal.ads.zzek r0 = r7.zzq
            byte[] r0 = r0.zzM()
            java.util.Arrays.fill(r0, r10)
            com.google.android.gms.internal.ads.zzek r0 = r7.zzq
            int r2 = 4 - r1
            byte[] r0 = r0.zzM()
            r3 = r8
            com.google.android.gms.internal.ads.zzaby r3 = (com.google.android.gms.internal.ads.zzaby) r3
            r3.zzn(r0, r2, r1, r10)
            com.google.android.gms.internal.ads.zzek r0 = r7.zzq
            r0.zzK(r10)
            com.google.android.gms.internal.ads.zzek r0 = r7.zzq
            long r0 = r0.zzu()
            int r0 = (int) r0
            r7.zzE = r0
            return
        L_0x008a:
            byte[] r2 = new byte[r1]
            r3 = r8
            com.google.android.gms.internal.ads.zzaby r3 = (com.google.android.gms.internal.ads.zzaby) r3
            r3.zzn(r2, r10, r1, r10)
            r19.zzu(r20)
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            com.google.android.gms.internal.ads.zzado r1 = new com.google.android.gms.internal.ads.zzado
            r1.<init>(r9, r2, r10, r10)
            r0.zzi = r1
            return
        L_0x009f:
            r19.zzu(r20)
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            byte[] r2 = new byte[r1]
            r0.zzh = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaby r0 = (com.google.android.gms.internal.ads.zzaby) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x00af:
            r19.zzu(r20)
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            int r2 = r0.zzY
            r3 = 1685485123(0x64767643, float:1.8185683E22)
            if (r2 == r3) goto L_0x00ce
            int r2 = r0.zzY
            r3 = 1685480259(0x64766343, float:1.8180206E22)
            if (r2 != r3) goto L_0x00c7
            goto L_0x00ce
        L_0x00c7:
            r0 = r8
            com.google.android.gms.internal.ads.zzaby r0 = (com.google.android.gms.internal.ads.zzaby) r0
            r0.zzo(r1, r10)
            return
        L_0x00ce:
            byte[] r2 = new byte[r1]
            r0.zzN = r2
            r0 = r8
            com.google.android.gms.internal.ads.zzaby r0 = (com.google.android.gms.internal.ads.zzaby) r0
            r0.zzn(r2, r10, r1, r10)
            return
        L_0x00d9:
            int r0 = r7.zzO
            if (r0 == r6) goto L_0x00df
            goto L_0x0325
        L_0x00df:
            android.util.SparseArray r0 = r7.zzi
            int r2 = r7.zzU
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.ads.zzahi r0 = (com.google.android.gms.internal.ads.zzahi) r0
            int r2 = r7.zzX
            if (r2 != r4) goto L_0x0109
            java.lang.String r0 = r0.zzb
            java.lang.String r2 = "V_VP9"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0109
            com.google.android.gms.internal.ads.zzek r0 = r7.zzv
            r0.zzH(r1)
            com.google.android.gms.internal.ads.zzek r0 = r7.zzv
            byte[] r0 = r0.zzM()
            r2 = r8
            com.google.android.gms.internal.ads.zzaby r2 = (com.google.android.gms.internal.ads.zzaby) r2
            r2.zzn(r0, r10, r1, r10)
            return
        L_0x0109:
            r0 = r8
            com.google.android.gms.internal.ads.zzaby r0 = (com.google.android.gms.internal.ads.zzaby) r0
            r0.zzo(r1, r10)
            return
        L_0x0110:
            int r2 = r7.zzO
            r11 = 8
            if (r2 != 0) goto L_0x0135
            com.google.android.gms.internal.ads.zzahl r2 = r7.zzh
            long r12 = r2.zzd(r8, r10, r9, r11)
            int r2 = (int) r12
            r7.zzU = r2
            com.google.android.gms.internal.ads.zzahl r2 = r7.zzh
            int r2 = r2.zza()
            r7.zzV = r2
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zzQ = r12
            r7.zzO = r9
            com.google.android.gms.internal.ads.zzek r2 = r7.zzo
            r2.zzH(r10)
        L_0x0135:
            android.util.SparseArray r2 = r7.zzi
            int r12 = r7.zzU
            java.lang.Object r2 = r2.get(r12)
            r12 = r2
            com.google.android.gms.internal.ads.zzahi r12 = (com.google.android.gms.internal.ads.zzahi) r12
            if (r12 != 0) goto L_0x014f
            int r0 = r7.zzV
            int r0 = r1 - r0
            r1 = r8
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzo(r0, r10)
            r7.zzO = r10
            return
        L_0x014f:
            r12.zzW.getClass()
            int r2 = r7.zzO
            if (r2 != r9) goto L_0x02dd
            r2 = 3
            r7.zzw(r8, r2)
            com.google.android.gms.internal.ads.zzek r13 = r7.zzo
            byte[] r13 = r13.zzM()
            byte r13 = r13[r6]
            r13 = r13 & 6
            int r13 = r13 >> r9
            r14 = 255(0xff, float:3.57E-43)
            if (r13 != 0) goto L_0x017c
            r7.zzS = r9
            int[] r2 = r7.zzT
            int[] r2 = zzA(r2, r9)
            r7.zzT = r2
            int r3 = r7.zzV
            int r1 = r1 - r3
            int r1 = r1 + -3
            r2[r10] = r1
            goto L_0x028d
        L_0x017c:
            r7.zzw(r8, r4)
            com.google.android.gms.internal.ads.zzek r15 = r7.zzo
            byte[] r15 = r15.zzM()
            byte r15 = r15[r2]
            r15 = r15 & r14
            int r15 = r15 + r9
            r7.zzS = r15
            int[] r4 = r7.zzT
            int[] r4 = zzA(r4, r15)
            r7.zzT = r4
            if (r13 != r6) goto L_0x01a2
            int r2 = r7.zzV
            int r1 = r1 - r2
            int r1 = r1 + -4
            int r2 = r7.zzS
            int r1 = r1 / r2
            java.util.Arrays.fill(r4, r10, r2, r1)
            goto L_0x028d
        L_0x01a2:
            if (r13 != r9) goto L_0x01da
            r2 = r10
            r3 = r2
            r4 = 4
        L_0x01a7:
            int r13 = r7.zzS
            int r13 = r13 + -1
            if (r2 >= r13) goto L_0x01cf
            int[] r13 = r7.zzT
            r13[r2] = r10
        L_0x01b1:
            int r4 = r4 + r9
            r7.zzw(r8, r4)
            com.google.android.gms.internal.ads.zzek r13 = r7.zzo
            int r15 = r4 + -1
            byte[] r13 = r13.zzM()
            byte r13 = r13[r15]
            r13 = r13 & r14
            int[] r15 = r7.zzT
            r16 = r15[r2]
            int r16 = r16 + r13
            r15[r2] = r16
            if (r13 == r14) goto L_0x01b1
            int r3 = r3 + r16
            int r2 = r2 + 1
            goto L_0x01a7
        L_0x01cf:
            int[] r2 = r7.zzT
            int r15 = r7.zzV
            int r1 = r1 - r15
            int r1 = r1 - r4
            int r1 = r1 - r3
            r2[r13] = r1
            goto L_0x028d
        L_0x01da:
            if (r13 != r2) goto L_0x02d6
            r2 = r10
            r13 = r2
            r4 = 4
        L_0x01df:
            int r15 = r7.zzS
            int r15 = r15 + -1
            if (r2 >= r15) goto L_0x0284
            int[] r15 = r7.zzT
            r15[r2] = r10
            int r4 = r4 + 1
            r7.zzw(r8, r4)
            com.google.android.gms.internal.ads.zzek r15 = r7.zzo
            int r16 = r4 + -1
            byte[] r15 = r15.zzM()
            byte r15 = r15[r16]
            if (r15 == 0) goto L_0x027d
            r15 = r10
        L_0x01fb:
            if (r15 >= r11) goto L_0x024e
            int r17 = 7 - r15
            int r5 = r9 << r17
            com.google.android.gms.internal.ads.zzek r6 = r7.zzo
            byte[] r6 = r6.zzM()
            byte r6 = r6[r16]
            r6 = r6 & r5
            if (r6 == 0) goto L_0x0244
            int r4 = r4 + r15
            r7.zzw(r8, r4)
            com.google.android.gms.internal.ads.zzek r6 = r7.zzo
            int r18 = r16 + 1
            byte[] r6 = r6.zzM()
            byte r6 = r6[r16]
            r6 = r6 & r14
            int r5 = ~r5
            r5 = r5 & r6
            long r5 = (long) r5
            r9 = r18
        L_0x0220:
            if (r9 >= r4) goto L_0x0236
            long r5 = r5 << r11
            com.google.android.gms.internal.ads.zzek r11 = r7.zzo
            int r16 = r9 + 1
            byte[] r11 = r11.zzM()
            byte r9 = r11[r9]
            r9 = r9 & r14
            long r10 = (long) r9
            long r5 = r5 | r10
            r9 = r16
            r10 = 0
            r11 = 8
            goto L_0x0220
        L_0x0236:
            if (r2 <= 0) goto L_0x0250
            int r15 = r15 * 7
            int r15 = r15 + 6
            r9 = 1
            long r9 = r9 << r15
            r15 = -1
            long r9 = r9 + r15
            long r5 = r5 - r9
            goto L_0x0250
        L_0x0244:
            int r15 = r15 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            r11 = 8
            goto L_0x01fb
        L_0x024e:
            r5 = 0
        L_0x0250:
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r9 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x0276
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r9 > 0) goto L_0x0276
            int[] r9 = r7.zzT
            int r5 = (int) r5
            if (r2 == 0) goto L_0x0268
            int r6 = r2 + -1
            r6 = r9[r6]
            int r5 = r5 + r6
        L_0x0268:
            r9[r2] = r5
            int r13 = r13 + r5
            int r2 = r2 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 2
            r9 = 1
            r10 = 0
            r11 = 8
            goto L_0x01df
        L_0x0276:
            java.lang.String r0 = "EBML lacing sample size out of range."
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r3)
            throw r0
        L_0x027d:
            java.lang.String r0 = "No valid varint length mask found"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r3)
            throw r0
        L_0x0284:
            int[] r2 = r7.zzT
            int r3 = r7.zzV
            int r1 = r1 - r3
            int r1 = r1 - r4
            int r1 = r1 - r13
            r2[r15] = r1
        L_0x028d:
            com.google.android.gms.internal.ads.zzek r1 = r7.zzo
            byte[] r1 = r1.zzM()
            r2 = 0
            byte r1 = r1[r2]
            r2 = 8
            int r1 = r1 << r2
            com.google.android.gms.internal.ads.zzek r2 = r7.zzo
            byte[] r2 = r2.zzM()
            r3 = 1
            byte r2 = r2[r3]
            r2 = r2 & r14
            long r3 = r7.zzJ
            r1 = r1 | r2
            long r1 = (long) r1
            long r1 = r7.zzs(r1)
            long r3 = r3 + r1
            r7.zzP = r3
            int r1 = r12.zzd
            r2 = 2
            if (r1 == r2) goto L_0x02cb
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02c9
            com.google.android.gms.internal.ads.zzek r0 = r7.zzo
            byte[] r0 = r0.zzM()
            byte r0 = r0[r2]
            r1 = 128(0x80, float:1.794E-43)
            r0 = r0 & r1
            if (r0 != r1) goto L_0x02c7
            r0 = 163(0xa3, float:2.28E-43)
            goto L_0x02cb
        L_0x02c7:
            r0 = 163(0xa3, float:2.28E-43)
        L_0x02c9:
            r1 = 0
            goto L_0x02cc
        L_0x02cb:
            r1 = 1
        L_0x02cc:
            r7.zzW = r1
            r7.zzO = r2
            r1 = 0
            r7.zzR = r1
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x02de
        L_0x02d6:
            java.lang.String r0 = "Unexpected lacing value: 2"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r3)
            throw r0
        L_0x02dd:
            r1 = r5
        L_0x02de:
            if (r0 != r1) goto L_0x030e
        L_0x02e0:
            int r0 = r7.zzR
            int r1 = r7.zzS
            if (r0 >= r1) goto L_0x030a
            int[] r1 = r7.zzT
            r0 = r1[r0]
            r1 = 0
            int r5 = r7.zzq(r8, r12, r0, r1)
            long r0 = r7.zzP
            int r2 = r7.zzR
            int r3 = r12.zze
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.zzW
            r6 = 0
            r0 = r19
            r1 = r12
            r0.zzv(r1, r2, r4, r5, r6)
            int r0 = r7.zzR
            r1 = 1
            int r0 = r0 + r1
            r7.zzR = r0
            goto L_0x02e0
        L_0x030a:
            r0 = 0
            r7.zzO = r0
            return
        L_0x030e:
            r1 = 1
        L_0x030f:
            int r0 = r7.zzR
            int r2 = r7.zzS
            if (r0 >= r2) goto L_0x0325
            int[] r2 = r7.zzT
            r3 = r2[r0]
            int r3 = r7.zzq(r8, r12, r3, r1)
            r2[r0] = r3
            int r0 = r7.zzR
            int r0 = r0 + r1
            r7.zzR = r0
            goto L_0x030f
        L_0x0325:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zzh(int, int, com.google.android.gms.internal.ads.zzacl):void");
    }

    public final void zzi(long j, long j2) {
        this.zzJ = -9223372036854775807L;
        this.zzO = 0;
        this.zzg.zzb();
        this.zzh.zze();
        zzx();
        for (int i = 0; i < this.zzi.size(); i++) {
            zzadq zzadq = ((zzahi) this.zzi.valueAt(i)).zzT;
            if (zzadq != null) {
                zzadq.zzb();
            }
        }
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        return new zzahk().zza(zzacl);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01e6, code lost:
        if (r5.equals("V_MPEGH/ISO/HEVC") != false) goto L_0x0313;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(int r22) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            com.google.android.gms.internal.ads.zzacn r1 = r7.zzaj
            com.google.android.gms.internal.ads.zzdi.zzb(r1)
            r1 = 160(0xa0, float:2.24E-43)
            r2 = 8
            java.lang.String r3 = "A_OPUS"
            r4 = 2
            r5 = 0
            if (r0 == r1) goto L_0x0332
            r1 = 174(0xae, float:2.44E-43)
            r10 = -1
            if (r0 == r1) goto L_0x0188
            r1 = 19899(0x4dbb, float:2.7884E-41)
            r2 = -1
            r4 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r0 == r1) goto L_0x0170
            r1 = 25152(0x6240, float:3.5245E-41)
            if (r0 == r1) goto L_0x013d
            r1 = 28032(0x6d80, float:3.9281E-41)
            if (r0 == r1) goto L_0x0126
            r1 = 357149030(0x1549a966, float:4.072526E-26)
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == r1) goto L_0x010e
            r1 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r0 == r1) goto L_0x00f8
            if (r0 == r4) goto L_0x003d
            goto L_0x03ad
        L_0x003d:
            boolean r0 = r7.zzD
            if (r0 != 0) goto L_0x00f2
            com.google.android.gms.internal.ads.zzacn r0 = r7.zzaj
            com.google.android.gms.internal.ads.zzeb r1 = r7.zzK
            com.google.android.gms.internal.ads.zzeb r4 = r7.zzL
            long r14 = r7.zzy
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00e5
            long r2 = r7.zzB
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x00e5
            if (r1 == 0) goto L_0x00e5
            int r2 = r1.zza()
            if (r2 == 0) goto L_0x00e5
            if (r4 == 0) goto L_0x00e5
            int r2 = r4.zza()
            int r3 = r1.zza()
            if (r2 == r3) goto L_0x0069
            goto L_0x00e5
        L_0x0069:
            int r2 = r1.zza()
            int[] r3 = new int[r2]
            long[] r12 = new long[r2]
            long[] r13 = new long[r2]
            long[] r14 = new long[r2]
            r15 = 0
        L_0x0076:
            if (r15 >= r2) goto L_0x008b
            long r16 = r1.zzb(r15)
            r14[r15] = r16
            long r8 = r7.zzy
            long r18 = r4.zzb(r15)
            long r18 = r18 + r8
            r12[r15] = r18
            int r15 = r15 + 1
            goto L_0x0076
        L_0x008b:
            r9 = 0
        L_0x008c:
            int r1 = r2 + -1
            if (r9 >= r1) goto L_0x00a6
            int r1 = r9 + 1
            r17 = r12[r1]
            r19 = r12[r9]
            long r10 = r17 - r19
            int r4 = (int) r10
            r3[r9] = r4
            r10 = r14[r1]
            r17 = r14[r9]
            long r10 = r10 - r17
            r13[r9] = r10
            r9 = r1
            r10 = -1
            goto L_0x008c
        L_0x00a6:
            long r8 = r7.zzy
            long r10 = r7.zzx
            long r8 = r8 + r10
            r10 = r12[r1]
            long r8 = r8 - r10
            int r2 = (int) r8
            r3[r1] = r2
            long r8 = r7.zzB
            r10 = r14[r1]
            long r8 = r8 - r10
            r13[r1] = r8
            int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r2 > 0) goto L_0x00df
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Discarding last cue point with unexpected duration: "
            r2.<init>(r4)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "MatroskaExtractor"
            com.google.android.gms.internal.ads.zzea.zzf(r4, r2)
            int[] r3 = java.util.Arrays.copyOf(r3, r1)
            long[] r12 = java.util.Arrays.copyOf(r12, r1)
            long[] r13 = java.util.Arrays.copyOf(r13, r1)
            long[] r14 = java.util.Arrays.copyOf(r14, r1)
        L_0x00df:
            com.google.android.gms.internal.ads.zzabw r1 = new com.google.android.gms.internal.ads.zzabw
            r1.<init>(r3, r12, r13, r14)
            goto L_0x00ec
        L_0x00e5:
            com.google.android.gms.internal.ads.zzadh r1 = new com.google.android.gms.internal.ads.zzadh
            long r2 = r7.zzB
            r1.<init>(r2, r5)
        L_0x00ec:
            r0.zzO(r1)
            r0 = 1
            r7.zzD = r0
        L_0x00f2:
            r0 = 0
            r7.zzK = r0
            r7.zzL = r0
            return
        L_0x00f8:
            r0 = 0
            android.util.SparseArray r1 = r7.zzi
            int r1 = r1.size()
            if (r1 == 0) goto L_0x0107
            com.google.android.gms.internal.ads.zzacn r0 = r7.zzaj
            r0.zzD()
            return
        L_0x0107:
            java.lang.String r1 = "No valid tracks were found"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r1, r0)
            throw r0
        L_0x010e:
            long r0 = r7.zzz
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0119
            r0 = 1000000(0xf4240, double:4.940656E-318)
            r7.zzz = r0
        L_0x0119:
            long r0 = r7.zzA
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x03ad
            long r0 = r7.zzs(r0)
            r7.zzB = r0
            return
        L_0x0126:
            r21.zzu(r22)
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x03ad
            byte[] r0 = r0.zzh
            if (r0 != 0) goto L_0x0135
            goto L_0x03ad
        L_0x0135:
            java.lang.String r0 = "Combining encryption and compression is not supported"
            r1 = 0
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r1)
            throw r0
        L_0x013d:
            r21.zzu(r22)
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            boolean r1 = r0.zzg
            if (r1 == 0) goto L_0x03ad
            com.google.android.gms.internal.ads.zzado r1 = r0.zzi
            if (r1 == 0) goto L_0x0168
            com.google.android.gms.internal.ads.zzy r1 = new com.google.android.gms.internal.ads.zzy
            r2 = 1
            com.google.android.gms.internal.ads.zzx[] r2 = new com.google.android.gms.internal.ads.zzx[r2]
            com.google.android.gms.internal.ads.zzx r3 = new com.google.android.gms.internal.ads.zzx
            java.util.UUID r4 = com.google.android.gms.internal.ads.zzk.zza
            com.google.android.gms.internal.ads.zzahi r5 = r7.zzC
            com.google.android.gms.internal.ads.zzado r5 = r5.zzi
            byte[] r5 = r5.zzb
            java.lang.String r6 = "video/webm"
            r8 = 0
            r3.<init>(r4, r8, r6, r5)
            r4 = 0
            r2[r4] = r3
            r1.<init>(r8, r2)
            r0.zzk = r1
            return
        L_0x0168:
            r8 = 0
            java.lang.String r0 = "Encrypted Track found but ContentEncKeyID was not found"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r8)
            throw r0
        L_0x0170:
            int r0 = r7.zzE
            r1 = -1
            if (r0 == r1) goto L_0x0180
            long r5 = r7.zzF
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0180
            if (r0 != r4) goto L_0x03ad
            r7.zzH = r5
            return
        L_0x0180:
            java.lang.String r0 = "Mandatory element SeekID or SeekPosition not found"
            r1 = 0
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r1)
            throw r0
        L_0x0188:
            r1 = r10
            com.google.android.gms.internal.ads.zzahi r0 = r7.zzC
            com.google.android.gms.internal.ads.zzdi.zzb(r0)
            java.lang.String r5 = r0.zzb
            if (r5 == 0) goto L_0x032a
            int r6 = r5.hashCode()
            switch(r6) {
                case -2095576542: goto L_0x0308;
                case -2095575984: goto L_0x02fe;
                case -1985379776: goto L_0x02f3;
                case -1784763192: goto L_0x02e8;
                case -1730367663: goto L_0x02dd;
                case -1482641358: goto L_0x02d2;
                case -1482641357: goto L_0x02c7;
                case -1373388978: goto L_0x02bc;
                case -933872740: goto L_0x02b1;
                case -538363189: goto L_0x02a6;
                case -538363109: goto L_0x029b;
                case -425012669: goto L_0x028f;
                case -356037306: goto L_0x0283;
                case 62923557: goto L_0x0277;
                case 62923603: goto L_0x026b;
                case 62927045: goto L_0x025f;
                case 82318131: goto L_0x0254;
                case 82338133: goto L_0x0249;
                case 82338134: goto L_0x023e;
                case 99146302: goto L_0x0232;
                case 444813526: goto L_0x0226;
                case 542569478: goto L_0x021a;
                case 635596514: goto L_0x020e;
                case 725948237: goto L_0x0202;
                case 725957860: goto L_0x01f6;
                case 738597099: goto L_0x01ea;
                case 855502857: goto L_0x01e0;
                case 1045209816: goto L_0x01d4;
                case 1422270023: goto L_0x01c8;
                case 1809237540: goto L_0x01bd;
                case 1950749482: goto L_0x01b1;
                case 1950789798: goto L_0x01a5;
                case 1951062397: goto L_0x019b;
                default: goto L_0x0199;
            }
        L_0x0199:
            goto L_0x0312
        L_0x019b:
            boolean r2 = r5.equals(r3)
            if (r2 == 0) goto L_0x0312
            r2 = 11
            goto L_0x0313
        L_0x01a5:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 22
            goto L_0x0313
        L_0x01b1:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 17
            goto L_0x0313
        L_0x01bd:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 3
            goto L_0x0313
        L_0x01c8:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 27
            goto L_0x0313
        L_0x01d4:
            java.lang.String r2 = "S_TEXT/WEBVTT"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 29
            goto L_0x0313
        L_0x01e0:
            java.lang.String r3 = "V_MPEGH/ISO/HEVC"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0312
            goto L_0x0313
        L_0x01ea:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 28
            goto L_0x0313
        L_0x01f6:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 24
            goto L_0x0313
        L_0x0202:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 25
            goto L_0x0313
        L_0x020e:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 26
            goto L_0x0313
        L_0x021a:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 20
            goto L_0x0313
        L_0x0226:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 10
            goto L_0x0313
        L_0x0232:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 31
            goto L_0x0313
        L_0x023e:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 1
            goto L_0x0313
        L_0x0249:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 0
            goto L_0x0313
        L_0x0254:
            java.lang.String r2 = "V_AV1"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = r4
            goto L_0x0313
        L_0x025f:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 19
            goto L_0x0313
        L_0x026b:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 16
            goto L_0x0313
        L_0x0277:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 13
            goto L_0x0313
        L_0x0283:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 21
            goto L_0x0313
        L_0x028f:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 30
            goto L_0x0313
        L_0x029b:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 7
            goto L_0x0313
        L_0x02a6:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 5
            goto L_0x0313
        L_0x02b1:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 32
            goto L_0x0313
        L_0x02bc:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 9
            goto L_0x0313
        L_0x02c7:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 15
            goto L_0x0313
        L_0x02d2:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 14
            goto L_0x0313
        L_0x02dd:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 12
            goto L_0x0313
        L_0x02e8:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 18
            goto L_0x0313
        L_0x02f3:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 23
            goto L_0x0313
        L_0x02fe:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 4
            goto L_0x0313
        L_0x0308:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0312
            r2 = 6
            goto L_0x0313
        L_0x0312:
            r2 = r1
        L_0x0313:
            switch(r2) {
                case 0: goto L_0x0318;
                case 1: goto L_0x0318;
                case 2: goto L_0x0318;
                case 3: goto L_0x0318;
                case 4: goto L_0x0318;
                case 5: goto L_0x0318;
                case 6: goto L_0x0318;
                case 7: goto L_0x0318;
                case 8: goto L_0x0318;
                case 9: goto L_0x0318;
                case 10: goto L_0x0318;
                case 11: goto L_0x0318;
                case 12: goto L_0x0318;
                case 13: goto L_0x0318;
                case 14: goto L_0x0318;
                case 15: goto L_0x0318;
                case 16: goto L_0x0318;
                case 17: goto L_0x0318;
                case 18: goto L_0x0318;
                case 19: goto L_0x0318;
                case 20: goto L_0x0318;
                case 21: goto L_0x0318;
                case 22: goto L_0x0318;
                case 23: goto L_0x0318;
                case 24: goto L_0x0318;
                case 25: goto L_0x0318;
                case 26: goto L_0x0318;
                case 27: goto L_0x0318;
                case 28: goto L_0x0318;
                case 29: goto L_0x0318;
                case 30: goto L_0x0318;
                case 31: goto L_0x0318;
                case 32: goto L_0x0318;
                default: goto L_0x0316;
            }
        L_0x0316:
            r0 = 0
            goto L_0x0327
        L_0x0318:
            com.google.android.gms.internal.ads.zzacn r1 = r7.zzaj
            int r2 = r0.zzc
            r0.zze(r1, r2)
            android.util.SparseArray r1 = r7.zzi
            int r2 = r0.zzc
            r1.put(r2, r0)
            goto L_0x0316
        L_0x0327:
            r7.zzC = r0
            return
        L_0x032a:
            r0 = 0
            java.lang.String r1 = "CodecId is missing in TrackEntry element"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r1, r0)
            throw r0
        L_0x0332:
            int r0 = r7.zzO
            if (r0 != r4) goto L_0x03ad
            android.util.SparseArray r0 = r7.zzi
            int r1 = r7.zzU
            java.lang.Object r0 = r0.get(r1)
            r8 = r0
            com.google.android.gms.internal.ads.zzahi r8 = (com.google.android.gms.internal.ads.zzahi) r8
            r8.zzW.getClass()
            long r0 = r7.zzZ
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x036c
            java.lang.String r0 = r8.zzb
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x036c
            com.google.android.gms.internal.ads.zzek r0 = r7.zzv
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r2)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r1 = r1.order(r2)
            long r2 = r7.zzZ
            java.nio.ByteBuffer r1 = r1.putLong(r2)
            byte[] r1 = r1.array()
            int r2 = r1.length
            r0.zzI(r1, r2)
        L_0x036c:
            r0 = 0
            r4 = 0
        L_0x036e:
            int r1 = r7.zzS
            if (r4 >= r1) goto L_0x037a
            int[] r1 = r7.zzT
            r1 = r1[r4]
            int r0 = r0 + r1
            int r4 = r4 + 1
            goto L_0x036e
        L_0x037a:
            r4 = 0
        L_0x037b:
            int r1 = r7.zzS
            if (r4 >= r1) goto L_0x03aa
            long r1 = r7.zzP
            int r3 = r8.zze
            int r3 = r3 * r4
            int r3 = r3 / 1000
            long r5 = (long) r3
            long r2 = r1 + r5
            int r1 = r7.zzW
            if (r4 != 0) goto L_0x0396
            boolean r4 = r7.zzY
            if (r4 != 0) goto L_0x0393
            r1 = r1 | 1
        L_0x0393:
            r4 = r1
            r9 = 0
            goto L_0x0398
        L_0x0396:
            r9 = r4
            r4 = r1
        L_0x0398:
            int[] r1 = r7.zzT
            r5 = r1[r9]
            int r10 = r0 - r5
            r0 = r21
            r1 = r8
            r6 = r10
            r0.zzv(r1, r2, r4, r5, r6)
            r0 = 1
            int r4 = r9 + 1
            r0 = r10
            goto L_0x037b
        L_0x03aa:
            r1 = 0
            r7.zzO = r1
        L_0x03ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahj.zzk(int):void");
    }

    public final void zzl(int i, double d) throws zzbo {
        if (i == 181) {
            zzu(i);
            this.zzC.zzQ = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    zzu(i);
                    this.zzC.zzD = (float) d;
                    return;
                case 21970:
                    zzu(i);
                    this.zzC.zzE = (float) d;
                    return;
                case 21971:
                    zzu(i);
                    this.zzC.zzF = (float) d;
                    return;
                case 21972:
                    zzu(i);
                    this.zzC.zzG = (float) d;
                    return;
                case 21973:
                    zzu(i);
                    this.zzC.zzH = (float) d;
                    return;
                case 21974:
                    zzu(i);
                    this.zzC.zzI = (float) d;
                    return;
                case 21975:
                    zzu(i);
                    this.zzC.zzJ = (float) d;
                    return;
                case 21976:
                    zzu(i);
                    this.zzC.zzK = (float) d;
                    return;
                case 21977:
                    zzu(i);
                    this.zzC.zzL = (float) d;
                    return;
                case 21978:
                    zzu(i);
                    this.zzC.zzM = (float) d;
                    return;
                default:
                    switch (i) {
                        case 30323:
                            zzu(i);
                            this.zzC.zzs = (float) d;
                            return;
                        case 30324:
                            zzu(i);
                            this.zzC.zzt = (float) d;
                            return;
                        case 30325:
                            zzu(i);
                            this.zzC.zzu = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.zzA = (long) d;
        }
    }

    public final void zzm(int i, long j) throws zzbo {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        zzu(i);
                        this.zzC.zzd = (int) j;
                        return;
                    case 136:
                        if (j == 1) {
                            z = true;
                        }
                        zzu(i);
                        this.zzC.zzV = z;
                        return;
                    case 155:
                        this.zzQ = zzs(j);
                        return;
                    case 159:
                        zzu(i);
                        this.zzC.zzO = (int) j;
                        return;
                    case 176:
                        zzu(i);
                        this.zzC.zzl = (int) j;
                        return;
                    case 179:
                        zzt(i);
                        this.zzK.zzc(zzs(j));
                        return;
                    case 186:
                        zzu(i);
                        this.zzC.zzm = (int) j;
                        return;
                    case 215:
                        zzu(i);
                        this.zzC.zzc = (int) j;
                        return;
                    case 231:
                        this.zzJ = zzs(j);
                        return;
                    case 238:
                        this.zzX = (int) j;
                        return;
                    case 241:
                        if (!this.zzM) {
                            zzt(i);
                            this.zzL.zzc(j);
                            this.zzM = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzY = true;
                        return;
                    case 16871:
                        zzu(i);
                        this.zzC.zzY = (int) j;
                        return;
                    case 16980:
                        if (j != 3) {
                            throw zzbo.zza("ContentCompAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw zzbo.zza("DocTypeReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            throw zzbo.zza("EBMLReadVersion " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            throw zzbo.zza("ContentEncAlgo " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            throw zzbo.zza("AESSettingsCipherMode " + j + " not supported", (Throwable) null);
                        }
                        return;
                    case 21420:
                        this.zzF = j + this.zzy;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        zzu(i);
                        if (i2 == 0) {
                            this.zzC.zzw = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzC.zzw = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzC.zzw = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzC.zzw = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        zzu(i);
                        this.zzC.zzo = (int) j;
                        return;
                    case 21682:
                        zzu(i);
                        this.zzC.zzq = (int) j;
                        return;
                    case 21690:
                        zzu(i);
                        this.zzC.zzp = (int) j;
                        return;
                    case 21930:
                        if (j == 1) {
                            z = true;
                        }
                        zzu(i);
                        this.zzC.zzU = z;
                        return;
                    case 21938:
                        zzu(i);
                        zzahi zzahi = this.zzC;
                        zzahi.zzx = true;
                        zzahi.zzn = (int) j;
                        return;
                    case 21998:
                        zzu(i);
                        this.zzC.zzf = (int) j;
                        return;
                    case 22186:
                        zzu(i);
                        this.zzC.zzR = j;
                        return;
                    case 22203:
                        zzu(i);
                        this.zzC.zzS = j;
                        return;
                    case 25188:
                        zzu(i);
                        this.zzC.zzP = (int) j;
                        return;
                    case 30114:
                        this.zzZ = j;
                        return;
                    case 30321:
                        int i3 = (int) j;
                        zzu(i);
                        if (i3 == 0) {
                            this.zzC.zzr = 0;
                            return;
                        } else if (i3 == 1) {
                            this.zzC.zzr = 1;
                            return;
                        } else if (i3 == 2) {
                            this.zzC.zzr = 2;
                            return;
                        } else if (i3 == 3) {
                            this.zzC.zzr = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        zzu(i);
                        this.zzC.zze = (int) j;
                        return;
                    case 2807729:
                        this.zzz = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i4 = (int) j;
                                zzu(i);
                                if (i4 == 1) {
                                    this.zzC.zzA = 2;
                                    return;
                                } else if (i4 == 2) {
                                    this.zzC.zzA = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                zzu(i);
                                int zzb2 = zzo.zzb((int) j);
                                if (zzb2 != -1) {
                                    this.zzC.zzz = zzb2;
                                    return;
                                }
                                return;
                            case 21947:
                                zzu(i);
                                this.zzC.zzx = true;
                                int zza2 = zzo.zza((int) j);
                                if (zza2 != -1) {
                                    this.zzC.zzy = zza2;
                                    return;
                                }
                                return;
                            case 21948:
                                zzu(i);
                                this.zzC.zzB = (int) j;
                                return;
                            case 21949:
                                zzu(i);
                                this.zzC.zzC = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                throw zzbo.zza("ContentEncodingScope " + j + " not supported", (Throwable) null);
            }
        } else if (j != 0) {
            throw zzbo.zza("ContentEncodingOrder " + j + " not supported", (Throwable) null);
        }
    }

    public final void zzn(int i, long j, long j2) throws zzbo {
        zzdi.zzb(this.zzaj);
        if (i == 160) {
            this.zzY = false;
            this.zzZ = 0;
        } else if (i == 174) {
            this.zzC = new zzahi();
        } else if (i == 187) {
            this.zzM = false;
        } else if (i == 19899) {
            this.zzE = -1;
            this.zzF = -1;
        } else if (i == 20533) {
            zzu(i);
            this.zzC.zzg = true;
        } else if (i == 21968) {
            zzu(i);
            this.zzC.zzx = true;
        } else if (i == 408125543) {
            long j3 = this.zzy;
            if (j3 == -1 || j3 == j) {
                this.zzy = j;
                this.zzx = j2;
                return;
            }
            throw zzbo.zza("Multiple Segment elements not supported", (Throwable) null);
        } else if (i == 475249515) {
            this.zzK = new zzeb(32);
            this.zzL = new zzeb(32);
        } else if (i != 524531317 || this.zzD) {
        } else {
            if (!this.zzj || this.zzH == -1) {
                this.zzaj.zzO(new zzadh(this.zzB, 0));
                this.zzD = true;
                return;
            }
            this.zzG = true;
        }
    }

    public final void zzo(int i, String str) throws zzbo {
        if (i == 134) {
            zzu(i);
            this.zzC.zzb = str;
        } else if (i != 17026) {
            if (i == 21358) {
                zzu(i);
                this.zzC.zza = str;
            } else if (i == 2274716) {
                zzu(i);
                this.zzC.zzZ = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            throw zzbo.zza("DocType " + str + " not supported", (Throwable) null);
        }
    }

    public zzahj(zzahf zzahf, int i, zzajy zzajy) {
        this.zzy = -1;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzH = -1;
        this.zzI = -1;
        this.zzJ = -9223372036854775807L;
        this.zzg = zzahf;
        zzahf.zza(new zzahh(this, (zzahg) null));
        this.zzl = zzajy;
        boolean z = false;
        this.zzj = 1 == ((i & 1) ^ 1);
        this.zzk = (i & 2) == 0 ? true : z;
        this.zzh = new zzahl();
        this.zzi = new SparseArray();
        this.zzo = new zzek(4);
        this.zzp = new zzek(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzek(4);
        this.zzm = new zzek(zzfh.zza);
        this.zzn = new zzek(4);
        this.zzr = new zzek();
        this.zzs = new zzek();
        this.zzt = new zzek(8);
        this.zzu = new zzek();
        this.zzv = new zzek();
        this.zzT = new int[1];
    }

    public zzahj(zzajy zzajy, int i) {
        this(new zzahd(), 0, zzajy);
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
