package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.gms.ads.AdRequest;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzsf {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    public zzsf(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z;
        this.zze = z4;
        this.zzf = z6;
        this.zzh = zzbn.zzi(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if ("OMX.Exynos.AVC.Decoder.secure".equals(r12) == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r15.isFeatureSupported("secure-playback") != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if ("Nexus 10".equals(r3) == false) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzsf zzc(java.lang.String r12, java.lang.String r13, java.lang.String r14, android.media.MediaCodecInfo.CodecCapabilities r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            r1 = r12
            r4 = r15
            com.google.android.gms.internal.ads.zzsf r11 = new com.google.android.gms.internal.ads.zzsf
            r0 = 1
            r2 = 0
            if (r4 == 0) goto L_0x003b
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x003b
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            r5 = 22
            if (r3 > r5) goto L_0x0039
            java.lang.String r3 = com.google.android.gms.internal.ads.zzet.zzd
            java.lang.String r5 = "ODROID-XU3"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x0028
            java.lang.String r5 = "Nexus 10"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0039
        L_0x0028:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L_0x003b
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r8 = r0
            goto L_0x003c
        L_0x003b:
            r8 = r2
        L_0x003c:
            if (r4 == 0) goto L_0x004a
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            java.lang.String r3 = "tunneled-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x004a
            r9 = r0
            goto L_0x004b
        L_0x004a:
            r9 = r2
        L_0x004b:
            if (r20 != 0) goto L_0x005c
            if (r4 == 0) goto L_0x005a
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            java.lang.String r3 = "secure-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r10 = r2
            goto L_0x005d
        L_0x005c:
            r10 = r0
        L_0x005d:
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzc(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zzsf");
    }

    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i3 = zzet.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        String str2 = zzet.zze;
        StringBuilder K = xx.K("NoSupport [", str, "] [");
        K.append(this.zza);
        K.append(", ");
        K.append(this.zzb);
        K.append("] [");
        K.append(str2);
        K.append("]");
        zzea.zzb("MediaCodecInfo", K.toString());
    }

    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point zzi = zzi(videoCapabilities, i, i2);
        int i3 = zzi.x;
        int i4 = zzi.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    private final boolean zzl(zzaf zzaf, boolean z) {
        int i;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair zza2 = zztc.zza(zzaf);
        if (zza2 != null) {
            int intValue = ((Integer) zza2.first).intValue();
            int intValue2 = ((Integer) zza2.second).intValue();
            int i2 = 8;
            if ("video/dolby-vision".equals(zzaf.zzm)) {
                if ("video/avc".equals(this.zzb)) {
                    intValue = 8;
                } else if ("video/hevc".equals(this.zzb)) {
                    intValue = 2;
                }
                intValue2 = 0;
            }
            if (!this.zzh) {
                if (intValue == 42) {
                    intValue = 42;
                }
            }
            MediaCodecInfo.CodecProfileLevel[] zzh2 = zzh();
            if (zzet.zza <= 23 && "video/x-vnd.on2.vp9".equals(this.zzb) && zzh2.length == 0) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
                if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                    i = 0;
                } else {
                    i = videoCapabilities.getBitrateRange().getUpper().intValue();
                }
                if (i >= 180000000) {
                    i2 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                } else if (i >= 120000000) {
                    i2 = AdRequest.MAX_CONTENT_URL_LENGTH;
                } else if (i >= 60000000) {
                    i2 = 256;
                } else if (i >= 30000000) {
                    i2 = 128;
                } else if (i >= 18000000) {
                    i2 = 64;
                } else if (i >= 12000000) {
                    i2 = 32;
                } else if (i >= 7200000) {
                    i2 = 16;
                } else if (i < 3600000) {
                    if (i >= 1800000) {
                        i2 = 4;
                    } else if (i >= 800000) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                }
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                codecProfileLevel.profile = 1;
                codecProfileLevel.level = i2;
                zzh2 = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : zzh2) {
                if (codecProfileLevel2.profile == intValue && (codecProfileLevel2.level >= intValue2 || !z)) {
                    if ("video/hevc".equals(this.zzb) && intValue == 2) {
                        String str = zzet.zzb;
                        if (!"sailfish".equals(str) && !"marlin".equals(str)) {
                        }
                    }
                }
            }
            zzj("codec.profileLevel, " + zzaf.zzj + ", " + this.zzc);
            return false;
        }
        return true;
    }

    private final boolean zzm(zzaf zzaf) {
        if (this.zzb.equals(zzaf.zzm) || this.zzb.equals(zztc.zzc(zzaf))) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.zza;
    }

    public final Point zza(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i, i2);
    }

    public final zzho zzb(zzaf zzaf, zzaf zzaf2) {
        int i;
        int i2;
        if (true != zzet.zzG(zzaf.zzm, zzaf2.zzm)) {
            i = 8;
        } else {
            i = 0;
        }
        if (this.zzh) {
            if (zzaf.zzu != zzaf2.zzu) {
                i |= UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            if (!this.zze && !(zzaf.zzr == zzaf2.zzr && zzaf.zzs == zzaf2.zzs)) {
                i |= AdRequest.MAX_CONTENT_URL_LENGTH;
            }
            if ((!zzo.zzg(zzaf.zzy) || !zzo.zzg(zzaf2.zzy)) && !zzet.zzG(zzaf.zzy, zzaf2.zzy)) {
                i |= 2048;
            }
            String str = this.zza;
            if (zzet.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzaf.zzd(zzaf2)) {
                i |= 2;
            }
            if (i == 0) {
                String str2 = this.zza;
                if (true != zzaf.zzd(zzaf2)) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                return new zzho(str2, zzaf, zzaf2, i2, 0);
            }
        } else {
            if (zzaf.zzz != zzaf2.zzz) {
                i |= 4096;
            }
            if (zzaf.zzA != zzaf2.zzA) {
                i |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
            }
            if (zzaf.zzB != zzaf2.zzB) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                Pair zza2 = zztc.zza(zzaf);
                Pair zza3 = zztc.zza(zzaf2);
                if (!(zza2 == null || zza3 == null)) {
                    int intValue = ((Integer) zza2.first).intValue();
                    int intValue2 = ((Integer) zza3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zzho(this.zza, zzaf, zzaf2, 3, 0);
                    }
                }
            }
            if (!zzaf.zzd(zzaf2)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzho(this.zza, zzaf, zzaf2, 1, 0);
            }
        }
        return new zzho(this.zza, zzaf, zzaf2, 0, i);
    }

    public final boolean zzd(zzaf zzaf) {
        if (!zzm(zzaf) || !zzl(zzaf, false)) {
            return false;
        }
        return true;
    }

    public final boolean zze(zzaf zzaf) throws zzsw {
        int i;
        int i2;
        if (!zzm(zzaf) || !zzl(zzaf, true)) {
            return false;
        }
        if (this.zzh) {
            int i3 = zzaf.zzr;
            if (i3 <= 0 || (i2 = zzaf.zzs) <= 0) {
                return true;
            }
            int i4 = zzet.zza;
            return zzg(i3, i2, (double) zzaf.zzt);
        }
        int i5 = zzet.zza;
        int i6 = zzaf.zzA;
        if (i6 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzj("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzj("sampleRate.aCaps");
                return false;
            } else if (!audioCapabilities.isSampleRateSupported(i6)) {
                zzj(lf.h("sampleRate.support, ", i6));
                return false;
            }
        }
        int i7 = zzaf.zzz;
        if (i7 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzj("channelCount.caps");
            } else {
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    zzj("channelCount.aCaps");
                } else {
                    String str = this.zza;
                    String str2 = this.zzb;
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((zzet.zza < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                        if ("audio/ac3".equals(str2)) {
                            i = 6;
                        } else if ("audio/eac3".equals(str2)) {
                            i = 16;
                        } else {
                            i = 30;
                        }
                        zzea.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i + "]");
                        maxInputChannelCount = i;
                    }
                    if (maxInputChannelCount < i7) {
                        zzj(lf.h("channelCount.support, ", i7));
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean zzf(zzaf zzaf) {
        if (this.zzh) {
            return this.zze;
        }
        Pair zza2 = zztc.zza(zzaf);
        if (zza2 == null || ((Integer) zza2.first).intValue() != 42) {
            return false;
        }
        return true;
    }

    public final boolean zzg(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzet.zza >= 29) {
            int zza2 = zzsh.zza(videoCapabilities, i, i2, d);
            if (zza2 != 2) {
                if (zza2 == 1) {
                    StringBuilder C = C1058d.C("sizeAndRate.cover, ", i, "x", i2, "@");
                    C.append(d);
                    zzj(C.toString());
                    return false;
                }
            }
            return true;
        }
        if (!zzk(videoCapabilities, i, i2, d)) {
            if (i >= i2 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzet.zzb)) || !zzk(videoCapabilities, i2, i, d))) {
                StringBuilder C2 = C1058d.C("sizeAndRate.support, ", i, "x", i2, "@");
                C2.append(d);
                zzj(C2.toString());
                return false;
            }
            StringBuilder C3 = C1058d.C("sizeAndRate.rotated, ", i, "x", i2, "@");
            C3.append(d);
            String sb = C3.toString();
            String str = this.zza;
            String str2 = this.zzb;
            String str3 = zzet.zze;
            StringBuilder b = C0437ME.b("AssumedSupport [", sb, "] [", str, ", ");
            b.append(str2);
            b.append("] [");
            b.append(str3);
            b.append("]");
            zzea.zzb("MediaCodecInfo", b.toString());
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return codecProfileLevelArr;
    }
}
