package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzqv extends zzso implements zzkg {
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzpd zzc;
    private final zzpl zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private zzaf zzh;
    private zzaf zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    /* access modifiers changed from: private */
    public boolean zzm;
    private int zzn = -1000;

    public zzqv(Context context, zzsa zzsa, zzsq zzsq, boolean z, Handler handler, zzpe zzpe, zzpl zzpl) {
        super(1, zzsa, zzsq, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzpl;
        this.zzc = new zzpd(handler, zzpe);
        zzpl.zzp(new zzqu(this, (zzqt) null));
    }

    private final int zzaO(zzsf zzsf, zzaf zzaf) {
        int i;
        if (!"OMX.google.raw.decoder".equals(zzsf.zza) || (i = zzet.zza) >= 24 || (i == 23 && zzet.zzN(this.zzb))) {
            return zzaf.zzn;
        }
        return -1;
    }

    private static List zzaP(zzsq zzsq, zzaf zzaf, boolean z, zzpl zzpl) throws zzsw {
        zzsf zzb2;
        if (zzaf.zzm == null) {
            return zzfxr.zzm();
        }
        if (!zzpl.zzz(zzaf) || (zzb2 = zztc.zzb()) == null) {
            return zztc.zzf(zzsq, zzaf, false, false);
        }
        return zzfxr.zzn(zzb2);
    }

    private final void zzaQ() {
        long zzb2 = this.zzd.zzb(zzW());
        if (zzb2 != Long.MIN_VALUE) {
            if (!this.zzk) {
                zzb2 = Math.max(this.zzj, zzb2);
            }
            this.zzj = zzb2;
            this.zzk = false;
        }
    }

    public final void zzA() {
        this.zzd.zzk();
    }

    public final void zzC() {
        this.zzm = false;
        try {
            super.zzC();
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
        } catch (Throwable th) {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
            throw th;
        }
    }

    public final void zzD() {
        this.zzd.zzi();
    }

    public final void zzE() {
        zzaQ();
        this.zzd.zzh();
    }

    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzW() {
        if (!super.zzW() || !this.zzd.zzy()) {
            return false;
        }
        return true;
    }

    public final boolean zzX() {
        if (this.zzd.zzx() || super.zzX()) {
            return true;
        }
        return false;
    }

    public final float zzZ(float f, zzaf zzaf, zzaf[] zzafArr) {
        int i = -1;
        for (zzaf zzaf2 : zzafArr) {
            int i2 = zzaf2.zzA;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return ((float) i) * f;
    }

    public final long zza() {
        if (zzcV() == 2) {
            zzaQ();
        }
        return this.zzj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzaa(com.google.android.gms.internal.ads.zzsq r10, com.google.android.gms.internal.ads.zzaf r11) throws com.google.android.gms.internal.ads.zzsw {
        /*
            r9 = this;
            java.lang.String r0 = r11.zzm
            boolean r0 = com.google.android.gms.internal.ads.zzbn.zzg(r0)
            r1 = 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            int r0 = com.google.android.gms.internal.ads.zzet.zza
            int r0 = r11.zzG
            boolean r2 = com.google.android.gms.internal.ads.zzso.zzaN(r11)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzsf r0 = com.google.android.gms.internal.ads.zztc.zzb()
            if (r0 == 0) goto L_0x0046
        L_0x001f:
            com.google.android.gms.internal.ads.zzpl r0 = r9.zzd
            com.google.android.gms.internal.ads.zzoq r0 = r0.zzd(r11)
            boolean r5 = r0.zzb
            if (r5 != 0) goto L_0x002b
            r5 = r3
            goto L_0x003a
        L_0x002b:
            boolean r5 = r0.zzc
            if (r4 == r5) goto L_0x0032
            r5 = 512(0x200, float:7.175E-43)
            goto L_0x0034
        L_0x0032:
            r5 = 1536(0x600, float:2.152E-42)
        L_0x0034:
            boolean r0 = r0.zzd
            if (r0 == 0) goto L_0x003a
            r5 = r5 | 2048(0x800, float:2.87E-42)
        L_0x003a:
            com.google.android.gms.internal.ads.zzpl r0 = r9.zzd
            boolean r0 = r0.zzz(r11)
            if (r0 != 0) goto L_0x0043
            goto L_0x0047
        L_0x0043:
            r10 = r5 | 172(0xac, float:2.41E-43)
            return r10
        L_0x0046:
            r5 = r3
        L_0x0047:
            java.lang.String r0 = r11.zzm
            java.lang.String r6 = "audio/raw"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzpl r0 = r9.zzd
            boolean r0 = r0.zzz(r11)
            if (r0 != 0) goto L_0x005a
            goto L_0x007c
        L_0x005a:
            com.google.android.gms.internal.ads.zzpl r0 = r9.zzd
            int r6 = r11.zzz
            int r7 = r11.zzA
            r8 = 2
            com.google.android.gms.internal.ads.zzaf r6 = com.google.android.gms.internal.ads.zzet.zzz(r8, r6, r7)
            boolean r0 = r0.zzz(r6)
            if (r0 != 0) goto L_0x006c
            goto L_0x007c
        L_0x006c:
            com.google.android.gms.internal.ads.zzpl r0 = r9.zzd
            java.util.List r10 = zzaP(r10, r11, r3, r0)
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            if (r2 != 0) goto L_0x007f
            r4 = r8
        L_0x007c:
            r10 = r4 | 128(0x80, float:1.794E-43)
            return r10
        L_0x007f:
            java.lang.Object r0 = r10.get(r3)
            com.google.android.gms.internal.ads.zzsf r0 = (com.google.android.gms.internal.ads.zzsf) r0
            boolean r2 = r0.zze(r11)
            if (r2 != 0) goto L_0x00a5
            r6 = r4
        L_0x008c:
            int r7 = r10.size()
            if (r6 >= r7) goto L_0x00a5
            java.lang.Object r7 = r10.get(r6)
            com.google.android.gms.internal.ads.zzsf r7 = (com.google.android.gms.internal.ads.zzsf) r7
            boolean r8 = r7.zze(r11)
            if (r8 == 0) goto L_0x00a2
            r10 = r3
            r2 = r4
            r0 = r7
            goto L_0x00a6
        L_0x00a2:
            int r6 = r6 + 1
            goto L_0x008c
        L_0x00a5:
            r10 = r4
        L_0x00a6:
            if (r4 == r2) goto L_0x00aa
            r6 = 3
            goto L_0x00ab
        L_0x00aa:
            r6 = 4
        L_0x00ab:
            r7 = 8
            if (r2 == 0) goto L_0x00b7
            boolean r11 = r0.zzf(r11)
            if (r11 == 0) goto L_0x00b7
            r7 = 16
        L_0x00b7:
            boolean r11 = r0.zzg
            if (r4 == r11) goto L_0x00bd
            r11 = r3
            goto L_0x00bf
        L_0x00bd:
            r11 = 64
        L_0x00bf:
            if (r4 == r10) goto L_0x00c2
            r1 = r3
        L_0x00c2:
            r10 = r6 | r7
            r10 = r10 | 32
            r10 = r10 | r11
            r10 = r10 | r1
            r10 = r10 | r5
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqv.zzaa(com.google.android.gms.internal.ads.zzsq, com.google.android.gms.internal.ads.zzaf):int");
    }

    public final zzho zzab(zzsf zzsf, zzaf zzaf, zzaf zzaf2) {
        int i;
        int i2;
        zzho zzb2 = zzsf.zzb(zzaf, zzaf2);
        int i3 = zzb2.zze;
        if (zzaL(zzaf2)) {
            i3 |= 32768;
        }
        if (zzaO(zzsf, zzaf2) > this.zze) {
            i3 |= 64;
        }
        String str = zzsf.zza;
        if (i3 != 0) {
            i = i3;
            i2 = 0;
        } else {
            i2 = zzb2.zzd;
            i = 0;
        }
        return new zzho(str, zzaf, zzaf2, i2, i);
    }

    public final zzho zzac(zzjz zzjz) throws zzhw {
        zzaf zzaf = zzjz.zza;
        zzaf.getClass();
        this.zzh = zzaf;
        zzho zzac = super.zzac(zzjz);
        this.zzc.zzi(zzaf, zzac);
        return zzac;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d0, code lost:
        if ("AXON 7 mini".equals(r10) == false) goto L_0x00d2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrz zzaf(com.google.android.gms.internal.ads.zzsf r8, com.google.android.gms.internal.ads.zzaf r9, android.media.MediaCrypto r10, float r11) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzaf[] r10 = r7.zzT()
            int r0 = r10.length
            int r1 = r7.zzaO(r8, r9)
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L_0x000e
            goto L_0x0026
        L_0x000e:
            r4 = r2
        L_0x000f:
            if (r4 >= r0) goto L_0x0026
            r5 = r10[r4]
            com.google.android.gms.internal.ads.zzho r6 = r8.zzb(r9, r5)
            int r6 = r6.zzd
            if (r6 == 0) goto L_0x0023
            int r5 = r7.zzaO(r8, r5)
            int r1 = java.lang.Math.max(r1, r5)
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0026:
            r7.zze = r1
            java.lang.String r10 = r8.zza
            int r0 = com.google.android.gms.internal.ads.zzet.zza
            r1 = 24
            if (r0 >= r1) goto L_0x005e
            java.lang.String r4 = "OMX.SEC.aac.dec"
            boolean r10 = r4.equals(r10)
            if (r10 == 0) goto L_0x005e
            java.lang.String r10 = "samsung"
            java.lang.String r4 = com.google.android.gms.internal.ads.zzet.zzc
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x005e
            java.lang.String r10 = com.google.android.gms.internal.ads.zzet.zzb
            java.lang.String r4 = "zeroflte"
            boolean r4 = r10.startsWith(r4)
            if (r4 != 0) goto L_0x005c
            java.lang.String r4 = "herolte"
            boolean r4 = r10.startsWith(r4)
            if (r4 != 0) goto L_0x005c
            java.lang.String r4 = "heroqlte"
            boolean r10 = r10.startsWith(r4)
            if (r10 == 0) goto L_0x005e
        L_0x005c:
            r10 = r3
            goto L_0x005f
        L_0x005e:
            r10 = r2
        L_0x005f:
            r7.zzf = r10
            java.lang.String r10 = r8.zza
            java.lang.String r4 = "OMX.google.opus.decoder"
            boolean r4 = r10.equals(r4)
            if (r4 != 0) goto L_0x0086
            java.lang.String r4 = "c2.android.opus.decoder"
            boolean r4 = r10.equals(r4)
            if (r4 != 0) goto L_0x0086
            java.lang.String r4 = "OMX.google.vorbis.decoder"
            boolean r4 = r10.equals(r4)
            if (r4 != 0) goto L_0x0086
            java.lang.String r4 = "c2.android.vorbis.decoder"
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r10 = r2
            goto L_0x0087
        L_0x0086:
            r10 = r3
        L_0x0087:
            r7.zzg = r10
            java.lang.String r10 = r8.zzc
            int r4 = r7.zze
            android.media.MediaFormat r5 = new android.media.MediaFormat
            r5.<init>()
            java.lang.String r6 = "mime"
            r5.setString(r6, r10)
            int r10 = r9.zzz
            java.lang.String r6 = "channel-count"
            r5.setInteger(r6, r10)
            int r10 = r9.zzA
            java.lang.String r6 = "sample-rate"
            r5.setInteger(r6, r10)
            java.util.List r10 = r9.zzo
            com.google.android.gms.internal.ads.zzed.zzb(r5, r10)
            java.lang.String r10 = "max-input-size"
            com.google.android.gms.internal.ads.zzed.zza(r5, r10, r4)
            r10 = 23
            if (r0 < r10) goto L_0x00d7
            java.lang.String r4 = "priority"
            r5.setInteger(r4, r2)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00d7
            if (r0 != r10) goto L_0x00d2
            java.lang.String r10 = com.google.android.gms.internal.ads.zzet.zzd
            java.lang.String r4 = "ZTE B2017G"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x00d7
            java.lang.String r4 = "AXON 7 mini"
            boolean r10 = r4.equals(r10)
            if (r10 != 0) goto L_0x00d7
        L_0x00d2:
            java.lang.String r10 = "operating-rate"
            r5.setFloat(r10, r11)
        L_0x00d7:
            r10 = 28
            if (r0 > r10) goto L_0x00ea
            java.lang.String r10 = r9.zzm
            java.lang.String r11 = "audio/ac4"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x00ea
            java.lang.String r10 = "ac4-is-sync"
            r5.setInteger(r10, r3)
        L_0x00ea:
            if (r0 < r1) goto L_0x0103
            com.google.android.gms.internal.ads.zzpl r10 = r7.zzd
            int r11 = r9.zzz
            int r1 = r9.zzA
            r3 = 4
            com.google.android.gms.internal.ads.zzaf r11 = com.google.android.gms.internal.ads.zzet.zzz(r3, r11, r1)
            int r10 = r10.zza(r11)
            r11 = 2
            if (r10 != r11) goto L_0x0103
            java.lang.String r10 = "pcm-encoding"
            r5.setInteger(r10, r3)
        L_0x0103:
            r10 = 32
            if (r0 < r10) goto L_0x010e
            java.lang.String r10 = "max-output-channel-count"
            r11 = 99
            r5.setInteger(r10, r11)
        L_0x010e:
            r10 = 35
            if (r0 < r10) goto L_0x011e
            int r10 = r7.zzn
            int r10 = -r10
            int r10 = java.lang.Math.max(r2, r10)
            java.lang.String r11 = "importance"
            r5.setInteger(r11, r10)
        L_0x011e:
            java.lang.String r10 = r8.zzb
            java.lang.String r11 = "audio/raw"
            boolean r10 = r11.equals(r10)
            r0 = 0
            if (r10 == 0) goto L_0x0133
            java.lang.String r10 = r9.zzm
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x0133
            r10 = r9
            goto L_0x0134
        L_0x0133:
            r10 = r0
        L_0x0134:
            r7.zzi = r10
            com.google.android.gms.internal.ads.zzrz r8 = com.google.android.gms.internal.ads.zzrz.zza(r8, r5, r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqv.zzaf(com.google.android.gms.internal.ads.zzsf, com.google.android.gms.internal.ads.zzaf, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrz");
    }

    public final List zzag(zzsq zzsq, zzaf zzaf, boolean z) throws zzsw {
        return zztc.zzg(zzaP(zzsq, zzaf, false, this.zzd), zzaf);
    }

    public final void zzaj(zzhd zzhd) {
        zzaf zzaf;
        if (zzet.zza >= 29 && (zzaf = zzhd.zza) != null && Objects.equals(zzaf.zzm, "audio/opus") && zzaK()) {
            ByteBuffer byteBuffer = zzhd.zzf;
            byteBuffer.getClass();
            zzaf zzaf2 = zzhd.zza;
            zzaf2.getClass();
            if (byteBuffer.remaining() == 8) {
                this.zzd.zzq(zzaf2.zzC, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
            }
        }
    }

    public final void zzak(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    public final void zzal(String str, zzrz zzrz, long j, long j2) {
        this.zzc.zze(str, j, j2);
    }

    public final void zzam(String str) {
        this.zzc.zzf(str);
    }

    public final void zzan(zzaf zzaf, MediaFormat mediaFormat) throws zzhw {
        boolean z;
        int i;
        int[] iArr;
        int i2;
        zzaf zzaf2 = this.zzi;
        int[] iArr2 = null;
        if (zzaf2 != null) {
            zzaf = zzaf2;
        } else if (zzay() != null) {
            mediaFormat.getClass();
            if ("audio/raw".equals(zzaf.zzm)) {
                i = zzaf.zzB;
            } else if (zzet.zza >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i = zzet.zzl(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i = 2;
            }
            zzad zzad = new zzad();
            zzad.zzX("audio/raw");
            zzad.zzR(i);
            zzad.zzF(zzaf.zzC);
            zzad.zzG(zzaf.zzD);
            zzad.zzQ(zzaf.zzk);
            zzad.zzK(zzaf.zza);
            zzad.zzM(zzaf.zzb);
            zzad.zzN(zzaf.zzc);
            zzad.zzO(zzaf.zzd);
            zzad.zzZ(zzaf.zze);
            zzad.zzV(zzaf.zzf);
            zzad.zzy(mediaFormat.getInteger("channel-count"));
            zzad.zzY(mediaFormat.getInteger("sample-rate"));
            zzaf zzad2 = zzad.zzad();
            if (this.zzf && zzad2.zzz == 6 && (i2 = zzaf.zzz) < 6) {
                iArr2 = new int[i2];
                for (int i3 = 0; i3 < zzaf.zzz; i3++) {
                    iArr2[i3] = i3;
                }
            } else if (this.zzg) {
                int i4 = zzad2.zzz;
                if (i4 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i4 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i4 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i4 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i4 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzaf = zzad2;
        }
        try {
            int i5 = zzet.zza;
            if (i5 >= 29) {
                if (zzaK()) {
                    zzm();
                }
                if (i5 >= 29) {
                    z = true;
                } else {
                    z = false;
                }
                zzdi.zzf(z);
            }
            this.zzd.zze(zzaf, 0, iArr2);
        } catch (zzpg e) {
            throw zzi(e, e.zza, false, 5001);
        }
    }

    public final void zzao() {
        this.zzk = true;
    }

    public final void zzap() {
        this.zzd.zzg();
    }

    public final void zzaq() throws zzhw {
        int i;
        try {
            this.zzd.zzj();
        } catch (zzpk e) {
            if (true != zzaK()) {
                i = 5002;
            } else {
                i = 5003;
            }
            throw zzi(e, e.zzc, e.zzb, i);
        }
    }

    public final boolean zzar(long j, long j2, zzsc zzsc, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzaf) throws zzhw {
        byteBuffer.getClass();
        if (this.zzi != null && (i2 & 2) != 0) {
            zzsc.getClass();
            zzsc.zzn(i, false);
            return true;
        } else if (z) {
            if (zzsc != null) {
                zzsc.zzn(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzg();
            return true;
        } else {
            try {
                if (!this.zzd.zzw(byteBuffer, j3, i3)) {
                    return false;
                }
                if (zzsc != null) {
                    zzsc.zzn(i, false);
                }
                this.zza.zze += i3;
                return true;
            } catch (zzph e) {
                zzaf zzaf2 = this.zzh;
                if (zzaK()) {
                    zzm();
                }
                throw zzi(e, zzaf2, e.zzb, 5001);
            } catch (zzpk e2) {
                if (zzaK()) {
                    zzm();
                }
                throw zzi(e2, zzaf, e2.zzb, 5002);
            }
        }
    }

    public final boolean zzas(zzaf zzaf) {
        zzm();
        return this.zzd.zzz(zzaf);
    }

    public final zzbq zzc() {
        return this.zzd.zzc();
    }

    public final void zzg(zzbq zzbq) {
        this.zzd.zzr(zzbq);
    }

    public final boolean zzj() {
        boolean z = this.zzm;
        this.zzm = false;
        return z;
    }

    public final void zzt(int i, Object obj) throws zzhw {
        if (i == 2) {
            zzpl zzpl = this.zzd;
            obj.getClass();
            zzpl.zzv(((Float) obj).floatValue());
        } else if (i == 3) {
            zzh zzh2 = (zzh) obj;
            zzpl zzpl2 = this.zzd;
            zzh2.getClass();
            zzpl2.zzm(zzh2);
        } else if (i == 6) {
            zzi zzi2 = (zzi) obj;
            zzpl zzpl3 = this.zzd;
            zzi2.getClass();
            zzpl3.zzo(zzi2);
        } else if (i != 12) {
            if (i == 16) {
                obj.getClass();
                this.zzn = ((Integer) obj).intValue();
                zzsc zzay = zzay();
                if (zzay != null && zzet.zza >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzn));
                    zzay.zzp(bundle);
                }
            } else if (i == 9) {
                zzpl zzpl4 = this.zzd;
                obj.getClass();
                zzpl4.zzu(((Boolean) obj).booleanValue());
            } else if (i != 10) {
                super.zzt(i, obj);
            } else {
                zzpl zzpl5 = this.zzd;
                obj.getClass();
                zzpl5.zzn(((Integer) obj).intValue());
            }
        } else if (zzet.zza >= 23) {
            zzqs.zza(this.zzd, obj);
        }
    }

    public final void zzw() {
        this.zzl = true;
        this.zzh = null;
        try {
            this.zzd.zzf();
            super.zzw();
        } catch (Throwable th) {
            super.zzw();
            throw th;
        } finally {
            this.zzc.zzg(this.zza);
        }
    }

    public final void zzx(boolean z, boolean z2) throws zzhw {
        super.zzx(z, z2);
        this.zzc.zzh(this.zza);
        zzm();
        this.zzd.zzs(zzn());
        zzh();
    }

    public final void zzz(long j, boolean z) throws zzhw {
        super.zzz(j, z);
        this.zzd.zzf();
        this.zzj = j;
        this.zzm = false;
        this.zzk = true;
    }

    public final zzkg zzk() {
        return this;
    }
}
