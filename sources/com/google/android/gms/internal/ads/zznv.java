package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zznv implements zzlq, zznw {
    private final Context zza;
    private final zznx zzb;
    private final PlaybackSession zzc;
    private final long zzd = SystemClock.elapsedRealtime();
    private final zzcb zze = new zzcb();
    private final zzca zzf = new zzca();
    private final HashMap zzg = new HashMap();
    private final HashMap zzh = new HashMap();
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private int zzl = 0;
    private int zzm = 0;
    private zzbp zzn;
    private zznu zzo;
    private zznu zzp;
    private zznu zzq;
    private zzaf zzr;
    private zzaf zzs;
    private zzaf zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    private zznv(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zznt zznt = new zznt(zznt.zza);
        this.zzb = zznt;
        zznt.zzh(this);
    }

    public static zznv zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zznv(context, mediaMetricsManager.createPlaybackSession());
    }

    @SuppressLint({"SwitchIntDef"})
    private static int zzr(int i) {
        switch (zzet.zzj(i)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long j;
        long j2;
        int i;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            builder2.setNetworkTransferDurationMillis(j);
            Long l2 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            builder3.setNetworkBytesRead(j2);
            PlaybackMetrics.Builder builder4 = this.zzj;
            if (l2 == null || l2.longValue() <= 0) {
                i = 0;
            } else {
                i = 1;
            }
            builder4.setStreamSource(i);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzaf zzaf, int i) {
        int i2;
        if (!zzet.zzG(this.zzs, zzaf)) {
            if (this.zzs == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.zzs = zzaf;
            zzx(0, j, zzaf, i2);
        }
    }

    private final void zzu(long j, zzaf zzaf, int i) {
        int i2;
        if (!zzet.zzG(this.zzt, zzaf)) {
            if (this.zzt == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.zzt = zzaf;
            zzx(2, j, zzaf, i2);
        }
    }

    private final void zzv(zzcc zzcc, zzui zzui) {
        int zza2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzui != null && (zza2 = zzcc.zza(zzui.zza)) != -1) {
            int i = 0;
            zzcc.zzd(zza2, this.zzf, false);
            zzcc.zze(this.zzf.zzc, this.zze, 0);
            zzax zzax = this.zze.zzd.zzb;
            int i2 = 2;
            if (zzax != null) {
                int zzn2 = zzet.zzn(zzax.zza);
                if (zzn2 == 0) {
                    i = 3;
                } else if (zzn2 == 1) {
                    i = 5;
                } else if (zzn2 != 2) {
                    i = 1;
                } else {
                    i = 4;
                }
            }
            builder.setStreamType(i);
            zzcb zzcb = this.zze;
            long j = zzcb.zzm;
            if (j != -9223372036854775807L && !zzcb.zzk && !zzcb.zzi && !zzcb.zzb()) {
                builder.setMediaDurationMillis(zzet.zzu(j));
            }
            if (true != this.zze.zzb()) {
                i2 = 1;
            }
            builder.setPlaybackType(i2);
            this.zzz = true;
        }
    }

    private final void zzw(long j, zzaf zzaf, int i) {
        int i2;
        if (!zzet.zzG(this.zzr, zzaf)) {
            if (this.zzr == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.zzr = zzaf;
            zzx(1, j, zzaf, i2);
        }
    }

    private final void zzx(int i, long j, zzaf zzaf, int i2) {
        int i3;
        String str;
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzaf != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i2 != 1) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i3);
            String str2 = zzaf.zzl;
            if (str2 != null) {
                timeSinceCreatedMillis.setContainerMimeType(str2);
            }
            String str3 = zzaf.zzm;
            if (str3 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str3);
            }
            String str4 = zzaf.zzj;
            if (str4 != null) {
                timeSinceCreatedMillis.setCodecName(str4);
            }
            int i4 = zzaf.zzi;
            if (i4 != -1) {
                timeSinceCreatedMillis.setBitrate(i4);
            }
            int i5 = zzaf.zzr;
            if (i5 != -1) {
                timeSinceCreatedMillis.setWidth(i5);
            }
            int i6 = zzaf.zzs;
            if (i6 != -1) {
                timeSinceCreatedMillis.setHeight(i6);
            }
            int i7 = zzaf.zzz;
            if (i7 != -1) {
                timeSinceCreatedMillis.setChannelCount(i7);
            }
            int i8 = zzaf.zzA;
            if (i8 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i8);
            }
            String str5 = zzaf.zzd;
            if (str5 != null) {
                int i9 = zzet.zza;
                String[] split = str5.split("-", -1);
                String str6 = split[0];
                if (split.length >= 2) {
                    str = split[1];
                } else {
                    str = null;
                }
                Pair create = Pair.create(str6, str);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = zzaf.zzt;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    private final boolean zzy(zznu zznu) {
        if (zznu == null) {
            return false;
        }
        if (zznu.zzc.equals(this.zzb.zze())) {
            return true;
        }
        return false;
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    public final void zzc(zzlo zzlo, String str) {
        zzui zzui = zzlo.zzd;
        if (zzui == null || !zzui.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.4.0-alpha02");
            zzv(zzlo.zzb, zzlo.zzd);
        }
    }

    public final void zzd(zzlo zzlo, String str, boolean z) {
        zzui zzui = zzlo.zzd;
        if ((zzui == null || !zzui.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    public final void zzf(zzlo zzlo, int i, long j, long j2) {
        long j3;
        zzui zzui = zzlo.zzd;
        if (zzui != null) {
            zznx zznx = this.zzb;
            zzcc zzcc = zzlo.zzb;
            HashMap hashMap = this.zzh;
            String zzf2 = zznx.zzf(zzcc, zzui);
            Long l = (Long) hashMap.get(zzf2);
            Long l2 = (Long) this.zzg.get(zzf2);
            HashMap hashMap2 = this.zzh;
            long j4 = 0;
            if (l == null) {
                j3 = 0;
            } else {
                j3 = l.longValue();
            }
            hashMap2.put(zzf2, Long.valueOf(j3 + j));
            HashMap hashMap3 = this.zzg;
            if (l2 != null) {
                j4 = l2.longValue();
            }
            hashMap3.put(zzf2, Long.valueOf(j4 + ((long) i)));
        }
    }

    public final void zzg(zzlo zzlo, zzue zzue) {
        zzui zzui = zzlo.zzd;
        if (zzui != null) {
            zzaf zzaf = zzue.zzb;
            zzaf.getClass();
            zznu zznu = new zznu(zzaf, 0, this.zzb.zzf(zzlo.zzb, zzui));
            int i = zzue.zza;
            if (i != 0) {
                if (i == 1) {
                    this.zzp = zznu;
                    return;
                } else if (i != 2) {
                    if (i == 3) {
                        this.zzq = zznu;
                        return;
                    }
                    return;
                }
            }
            this.zzo = zznu;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01eb, code lost:
        if (r8 != 1) goto L_0x01ef;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.internal.ads.zzbw r19, com.google.android.gms.internal.ads.zzlp r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            int r2 = r20.zzb()
            if (r2 != 0) goto L_0x000c
            goto L_0x03c3
        L_0x000c:
            r2 = 0
            r3 = r2
        L_0x000e:
            int r4 = r20.zzb()
            r5 = 11
            if (r3 >= r4) goto L_0x0038
            int r4 = r1.zza(r3)
            com.google.android.gms.internal.ads.zzlo r6 = r1.zzc(r4)
            if (r4 != 0) goto L_0x0026
            com.google.android.gms.internal.ads.zznx r4 = r0.zzb
            r4.zzk(r6)
            goto L_0x0035
        L_0x0026:
            if (r4 != r5) goto L_0x0030
            com.google.android.gms.internal.ads.zznx r4 = r0.zzb
            int r5 = r0.zzk
            r4.zzj(r6, r5)
            goto L_0x0035
        L_0x0030:
            com.google.android.gms.internal.ads.zznx r4 = r0.zzb
            r4.zzi(r6)
        L_0x0035:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0038:
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r6 = r1.zzd(r2)
            if (r6 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzlo r6 = r1.zzc(r2)
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzcc r7 = r6.zzb
            com.google.android.gms.internal.ads.zzui r6 = r6.zzd
            r0.zzv(r7, r6)
        L_0x0051:
            r6 = 2
            boolean r7 = r1.zzd(r6)
            r9 = 3
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00c9
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzck r7 = r19.zzo()
            com.google.android.gms.internal.ads.zzfxr r7 = r7.zza()
            int r12 = r7.size()
            r13 = r2
        L_0x006c:
            if (r13 >= r12) goto L_0x0092
            java.lang.Object r14 = r7.get(r13)
            com.google.android.gms.internal.ads.zzcj r14 = (com.google.android.gms.internal.ads.zzcj) r14
            r15 = r2
        L_0x0075:
            int r5 = r14.zza
            int r16 = r13 + 1
            if (r15 >= r5) goto L_0x008d
            boolean r5 = r14.zzd(r15)
            if (r5 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzaf r5 = r14.zzb(r15)
            com.google.android.gms.internal.ads.zzy r5 = r5.zzp
            if (r5 == 0) goto L_0x008a
            goto L_0x0093
        L_0x008a:
            int r15 = r15 + 1
            goto L_0x0075
        L_0x008d:
            r13 = r16
            r5 = 11
            goto L_0x006c
        L_0x0092:
            r5 = r10
        L_0x0093:
            if (r5 == 0) goto L_0x00c9
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            int r12 = com.google.android.gms.internal.ads.zzet.zza
            r12 = r2
        L_0x009a:
            int r13 = r5.zzb
            if (r12 >= r13) goto L_0x00c5
            com.google.android.gms.internal.ads.zzx r13 = r5.zza(r12)
            java.util.UUID r13 = r13.zza
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzk.zzd
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00ae
            r5 = r9
            goto L_0x00c6
        L_0x00ae:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzk.zze
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00b8
            r5 = r6
            goto L_0x00c6
        L_0x00b8:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzk.zzc
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00c2
            r5 = 6
            goto L_0x00c6
        L_0x00c2:
            int r12 = r12 + 1
            goto L_0x009a
        L_0x00c5:
            r5 = r11
        L_0x00c6:
            r7.setDrmType(r5)
        L_0x00c9:
            r5 = 1011(0x3f3, float:1.417E-42)
            boolean r5 = r1.zzd(r5)
            if (r5 == 0) goto L_0x00d6
            int r5 = r0.zzy
            int r5 = r5 + r11
            r0.zzy = r5
        L_0x00d6:
            com.google.android.gms.internal.ads.zzbp r5 = r0.zzn
            r16 = 9
            if (r5 != 0) goto L_0x00de
            goto L_0x0274
        L_0x00de:
            android.content.Context r7 = r0.zza
            int r8 = r5.zza
            r12 = 1001(0x3e9, float:1.403E-42)
            if (r8 != r12) goto L_0x00eb
            r7 = 20
        L_0x00e8:
            r8 = r2
            goto L_0x024e
        L_0x00eb:
            r8 = r5
            com.google.android.gms.internal.ads.zzhw r8 = (com.google.android.gms.internal.ads.zzhw) r8
            int r12 = r8.zzc
            if (r12 != r11) goto L_0x00f4
            r12 = r11
            goto L_0x00f5
        L_0x00f4:
            r12 = r2
        L_0x00f5:
            int r8 = r8.zzg
            java.lang.Throwable r13 = r5.getCause()
            r13.getClass()
            boolean r14 = r13 instanceof java.io.IOException
            r15 = 23
            if (r14 == 0) goto L_0x01e5
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgn
            if (r8 == 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzgn r13 = (com.google.android.gms.internal.ads.zzgn) r13
            int r7 = r13.zzc
            r8 = r7
            r7 = 5
            goto L_0x024e
        L_0x0110:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgm
            if (r8 != 0) goto L_0x01e0
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzbo
            if (r8 == 0) goto L_0x011a
            goto L_0x01e0
        L_0x011a:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzgl
            if (r8 != 0) goto L_0x01ad
            boolean r12 = r13 instanceof com.google.android.gms.internal.ads.zzgv
            if (r12 == 0) goto L_0x0124
            goto L_0x01ad
        L_0x0124:
            int r7 = r5.zza
            r8 = 1002(0x3ea, float:1.404E-42)
            if (r7 != r8) goto L_0x012d
            r7 = 21
            goto L_0x00e8
        L_0x012d:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzrb
            if (r7 == 0) goto L_0x0179
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            int r8 = com.google.android.gms.internal.ads.zzet.zza
            boolean r8 = r7 instanceof android.media.MediaDrm.MediaDrmStateException
            if (r8 == 0) goto L_0x014e
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = com.google.android.gms.internal.ads.zzet.zzk(r7)
            int r8 = zzr(r7)
            goto L_0x0218
        L_0x014e:
            int r8 = com.google.android.gms.internal.ads.zzet.zza
            if (r8 < r15) goto L_0x0159
            boolean r8 = r7 instanceof android.media.MediaDrmResetException
            if (r8 == 0) goto L_0x0159
            r7 = 27
            goto L_0x00e8
        L_0x0159:
            boolean r8 = r7 instanceof android.media.NotProvisionedException
            if (r8 == 0) goto L_0x0160
            r7 = 24
            goto L_0x00e8
        L_0x0160:
            boolean r8 = r7 instanceof android.media.DeniedByServerException
            if (r8 == 0) goto L_0x0167
            r7 = 29
            goto L_0x00e8
        L_0x0167:
            boolean r8 = r7 instanceof com.google.android.gms.internal.ads.zzrl
            if (r8 == 0) goto L_0x016d
            goto L_0x01fb
        L_0x016d:
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzra
            if (r7 == 0) goto L_0x0175
            r7 = 28
            goto L_0x00e8
        L_0x0175:
            r7 = 30
            goto L_0x00e8
        L_0x0179:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzgi
            if (r7 == 0) goto L_0x01a8
            java.lang.Throwable r7 = r13.getCause()
            boolean r7 = r7 instanceof java.io.FileNotFoundException
            if (r7 == 0) goto L_0x01a8
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            java.lang.Throwable r7 = r7.getCause()
            int r8 = com.google.android.gms.internal.ads.zzet.zza
            boolean r8 = r7 instanceof android.system.ErrnoException
            r12 = 31
            if (r8 == 0) goto L_0x01a4
            android.system.ErrnoException r7 = (android.system.ErrnoException) r7
            int r7 = r7.errno
            int r8 = android.system.OsConstants.EACCES
            if (r7 != r8) goto L_0x01a4
            r7 = 32
            goto L_0x00e8
        L_0x01a4:
            r8 = r2
            r7 = r12
            goto L_0x024e
        L_0x01a8:
            r8 = r2
            r7 = r16
            goto L_0x024e
        L_0x01ad:
            com.google.android.gms.internal.ads.zzei r7 = com.google.android.gms.internal.ads.zzei.zzb(r7)
            int r7 = r7.zza()
            if (r7 != r11) goto L_0x01bb
            r8 = r2
            r7 = r9
            goto L_0x024e
        L_0x01bb:
            java.lang.Throwable r7 = r13.getCause()
            boolean r12 = r7 instanceof java.net.UnknownHostException
            if (r12 == 0) goto L_0x01c7
            r8 = r2
            r7 = 6
            goto L_0x024e
        L_0x01c7:
            boolean r7 = r7 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x01cf
            r8 = r2
            r7 = 7
            goto L_0x024e
        L_0x01cf:
            if (r8 == 0) goto L_0x01db
            com.google.android.gms.internal.ads.zzgl r13 = (com.google.android.gms.internal.ads.zzgl) r13
            int r7 = r13.zzb
            if (r7 != r11) goto L_0x01db
            r8 = r2
            r7 = 4
            goto L_0x024e
        L_0x01db:
            r8 = r2
            r7 = 8
            goto L_0x024e
        L_0x01e0:
            r8 = r2
            r7 = 11
            goto L_0x024e
        L_0x01e5:
            if (r12 == 0) goto L_0x01ef
            r7 = 35
            if (r8 == 0) goto L_0x00e8
            if (r8 != r11) goto L_0x01ef
            goto L_0x00e8
        L_0x01ef:
            if (r12 == 0) goto L_0x01f7
            if (r8 != r9) goto L_0x01f7
            r7 = 15
            goto L_0x00e8
        L_0x01f7:
            if (r12 == 0) goto L_0x01fe
            if (r8 != r6) goto L_0x01fe
        L_0x01fb:
            r8 = r2
            r7 = r15
            goto L_0x024e
        L_0x01fe:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzsk
            if (r7 == 0) goto L_0x020e
            com.google.android.gms.internal.ads.zzsk r13 = (com.google.android.gms.internal.ads.zzsk) r13
            java.lang.String r7 = r13.zzd
            int r7 = com.google.android.gms.internal.ads.zzet.zzk(r7)
            r8 = r7
            r7 = 13
            goto L_0x024e
        L_0x020e:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzse
            r8 = 14
            if (r7 == 0) goto L_0x021e
            com.google.android.gms.internal.ads.zzse r13 = (com.google.android.gms.internal.ads.zzse) r13
            int r7 = r13.zzb
        L_0x0218:
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x024e
        L_0x021e:
            boolean r7 = r13 instanceof java.lang.OutOfMemoryError
            if (r7 == 0) goto L_0x0225
            r7 = r8
            goto L_0x00e8
        L_0x0225:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzph
            if (r7 == 0) goto L_0x0230
            com.google.android.gms.internal.ads.zzph r13 = (com.google.android.gms.internal.ads.zzph) r13
            int r7 = r13.zza
            r8 = 17
            goto L_0x0218
        L_0x0230:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzpk
            if (r7 == 0) goto L_0x023b
            com.google.android.gms.internal.ads.zzpk r13 = (com.google.android.gms.internal.ads.zzpk) r13
            int r7 = r13.zza
            r8 = 18
            goto L_0x0218
        L_0x023b:
            boolean r7 = r13 instanceof android.media.MediaCodec.CryptoException
            if (r7 == 0) goto L_0x024a
            android.media.MediaCodec$CryptoException r13 = (android.media.MediaCodec.CryptoException) r13
            int r7 = r13.getErrorCode()
            int r8 = zzr(r7)
            goto L_0x0218
        L_0x024a:
            r7 = 22
            goto L_0x00e8
        L_0x024e:
            android.media.metrics.PlaybackSession r12 = r0.zzc
            android.media.metrics.PlaybackErrorEvent$Builder r13 = new android.media.metrics.PlaybackErrorEvent$Builder
            r13.<init>()
            long r14 = r0.zzd
            long r14 = r3 - r14
            android.media.metrics.PlaybackErrorEvent$Builder r13 = r13.setTimeSinceCreatedMillis(r14)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r13.setErrorCode(r7)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r7.setSubErrorCode(r8)
            android.media.metrics.PlaybackErrorEvent$Builder r5 = r7.setException(r5)
            android.media.metrics.PlaybackErrorEvent r5 = r5.build()
            r12.reportPlaybackErrorEvent(r5)
            r0.zzz = r11
            r0.zzn = r10
        L_0x0274:
            boolean r5 = r1.zzd(r6)
            if (r5 == 0) goto L_0x02a0
            com.google.android.gms.internal.ads.zzck r5 = r19.zzo()
            boolean r7 = r5.zzb(r6)
            boolean r8 = r5.zzb(r11)
            boolean r5 = r5.zzb(r9)
            if (r7 != 0) goto L_0x0291
            if (r8 != 0) goto L_0x0291
            if (r5 == 0) goto L_0x02a0
            r5 = r11
        L_0x0291:
            if (r7 != 0) goto L_0x0296
            r0.zzw(r3, r10, r2)
        L_0x0296:
            if (r8 != 0) goto L_0x029b
            r0.zzt(r3, r10, r2)
        L_0x029b:
            if (r5 != 0) goto L_0x02a0
            r0.zzu(r3, r10, r2)
        L_0x02a0:
            com.google.android.gms.internal.ads.zznu r5 = r0.zzo
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02b6
            com.google.android.gms.internal.ads.zznu r5 = r0.zzo
            com.google.android.gms.internal.ads.zzaf r5 = r5.zza
            int r7 = r5.zzs
            r8 = -1
            if (r7 == r8) goto L_0x02b6
            r0.zzw(r3, r5, r2)
            r0.zzo = r10
        L_0x02b6:
            com.google.android.gms.internal.ads.zznu r5 = r0.zzp
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02c7
            com.google.android.gms.internal.ads.zznu r5 = r0.zzp
            com.google.android.gms.internal.ads.zzaf r5 = r5.zza
            r0.zzt(r3, r5, r2)
            r0.zzp = r10
        L_0x02c7:
            com.google.android.gms.internal.ads.zznu r5 = r0.zzq
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02d8
            com.google.android.gms.internal.ads.zznu r5 = r0.zzq
            com.google.android.gms.internal.ads.zzaf r5 = r5.zza
            r0.zzu(r3, r5, r2)
            r0.zzq = r10
        L_0x02d8:
            android.content.Context r5 = r0.zza
            com.google.android.gms.internal.ads.zzei r5 = com.google.android.gms.internal.ads.zzei.zzb(r5)
            int r5 = r5.zza()
            switch(r5) {
                case 0: goto L_0x02f9;
                case 1: goto L_0x02f6;
                case 2: goto L_0x02f4;
                case 3: goto L_0x02f2;
                case 4: goto L_0x02f0;
                case 5: goto L_0x02ee;
                case 6: goto L_0x02e5;
                case 7: goto L_0x02ec;
                case 8: goto L_0x02e5;
                case 9: goto L_0x02e9;
                case 10: goto L_0x02e7;
                default: goto L_0x02e5;
            }
        L_0x02e5:
            r13 = r11
            goto L_0x02fa
        L_0x02e7:
            r13 = 7
            goto L_0x02fa
        L_0x02e9:
            r13 = 8
            goto L_0x02fa
        L_0x02ec:
            r13 = r9
            goto L_0x02fa
        L_0x02ee:
            r13 = 6
            goto L_0x02fa
        L_0x02f0:
            r13 = 5
            goto L_0x02fa
        L_0x02f2:
            r13 = 4
            goto L_0x02fa
        L_0x02f4:
            r13 = r6
            goto L_0x02fa
        L_0x02f6:
            r13 = r16
            goto L_0x02fa
        L_0x02f9:
            r13 = r2
        L_0x02fa:
            int r5 = r0.zzm
            if (r13 == r5) goto L_0x031a
            r0.zzm = r13
            android.media.metrics.PlaybackSession r5 = r0.zzc
            android.media.metrics.NetworkEvent$Builder r7 = new android.media.metrics.NetworkEvent$Builder
            r7.<init>()
            android.media.metrics.NetworkEvent$Builder r7 = r7.setNetworkType(r13)
            long r12 = r0.zzd
            long r12 = r3 - r12
            android.media.metrics.NetworkEvent$Builder r7 = r7.setTimeSinceCreatedMillis(r12)
            android.media.metrics.NetworkEvent r7 = r7.build()
            r5.reportNetworkEvent(r7)
        L_0x031a:
            int r5 = r19.zzf()
            if (r5 == r6) goto L_0x0322
            r0.zzu = r2
        L_0x0322:
            r5 = r19
            com.google.android.gms.internal.ads.zzll r5 = (com.google.android.gms.internal.ads.zzll) r5
            com.google.android.gms.internal.ads.zzhw r5 = r5.zzC()
            r7 = 10
            if (r5 != 0) goto L_0x0331
            r0.zzv = r2
            goto L_0x0339
        L_0x0331:
            boolean r2 = r1.zzd(r7)
            if (r2 == 0) goto L_0x0339
            r0.zzv = r11
        L_0x0339:
            int r2 = r19.zzf()
            boolean r5 = r0.zzu
            if (r5 == 0) goto L_0x0343
            r5 = 5
            goto L_0x038f
        L_0x0343:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x034a
            r5 = 13
            goto L_0x038f
        L_0x034a:
            r5 = 4
            if (r2 != r5) goto L_0x0350
            r5 = 11
            goto L_0x038f
        L_0x0350:
            r8 = 12
            if (r2 != r6) goto L_0x0371
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x036f
            if (r2 == r6) goto L_0x036f
            if (r2 != r8) goto L_0x035d
            goto L_0x036f
        L_0x035d:
            boolean r2 = r19.zzu()
            if (r2 != 0) goto L_0x0365
            r5 = 7
            goto L_0x038f
        L_0x0365:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x036d
            r5 = r7
            goto L_0x038f
        L_0x036d:
            r5 = 6
            goto L_0x038f
        L_0x036f:
            r5 = r6
            goto L_0x038f
        L_0x0371:
            if (r2 != r9) goto L_0x0385
            boolean r2 = r19.zzu()
            if (r2 != 0) goto L_0x037a
            goto L_0x038f
        L_0x037a:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x0383
            r5 = r16
            goto L_0x038f
        L_0x0383:
            r5 = r9
            goto L_0x038f
        L_0x0385:
            if (r2 != r11) goto L_0x038d
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x038d
            r5 = r8
            goto L_0x038f
        L_0x038d:
            int r5 = r0.zzl
        L_0x038f:
            int r2 = r0.zzl
            if (r2 == r5) goto L_0x03b2
            r0.zzl = r5
            r0.zzz = r11
            android.media.metrics.PlaybackSession r2 = r0.zzc
            android.media.metrics.PlaybackStateEvent$Builder r5 = new android.media.metrics.PlaybackStateEvent$Builder
            r5.<init>()
            int r6 = r0.zzl
            android.media.metrics.PlaybackStateEvent$Builder r5 = r5.setState(r6)
            long r6 = r0.zzd
            long r3 = r3 - r6
            android.media.metrics.PlaybackStateEvent$Builder r3 = r5.setTimeSinceCreatedMillis(r3)
            android.media.metrics.PlaybackStateEvent r3 = r3.build()
            r2.reportPlaybackStateEvent(r3)
        L_0x03b2:
            r2 = 1028(0x404, float:1.44E-42)
            boolean r3 = r1.zzd(r2)
            if (r3 == 0) goto L_0x03c3
            com.google.android.gms.internal.ads.zznx r3 = r0.zzb
            com.google.android.gms.internal.ads.zzlo r1 = r1.zzc(r2)
            r3.zzg(r1)
        L_0x03c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznv.zzi(com.google.android.gms.internal.ads.zzbw, com.google.android.gms.internal.ads.zzlp):void");
    }

    public final void zzl(zzlo zzlo, zzbp zzbp) {
        this.zzn = zzbp;
    }

    public final void zzm(zzlo zzlo, zzbv zzbv, zzbv zzbv2, int i) {
        if (i == 1) {
            this.zzu = true;
            i = 1;
        }
        this.zzk = i;
    }

    public final void zzo(zzlo zzlo, zzhn zzhn) {
        this.zzw += zzhn.zzg;
        this.zzx += zzhn.zze;
    }

    public final void zzq(zzlo zzlo, zzcp zzcp) {
        zznu zznu = this.zzo;
        if (zznu != null) {
            zzaf zzaf = zznu.zza;
            if (zzaf.zzs == -1) {
                zzad zzb2 = zzaf.zzb();
                zzb2.zzac(zzcp.zzb);
                zzb2.zzI(zzcp.zzc);
                this.zzo = new zznu(zzb2.zzad(), 0, zznu.zzc);
            }
        }
    }

    public final /* synthetic */ void zzk(zzlo zzlo, int i) {
    }

    public final /* synthetic */ void zze(zzlo zzlo, zzaf zzaf, zzho zzho) {
    }

    public final /* synthetic */ void zzh(zzlo zzlo, int i, long j) {
    }

    public final /* synthetic */ void zzn(zzlo zzlo, Object obj, long j) {
    }

    public final /* synthetic */ void zzp(zzlo zzlo, zzaf zzaf, zzho zzho) {
    }

    public final void zzj(zzlo zzlo, zztz zztz, zzue zzue, IOException iOException, boolean z) {
    }
}
