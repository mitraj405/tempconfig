package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzpp {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private final zzpo zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzpn zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzpp(zzpo zzpo) {
        this.zza = zzpo;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
    }

    private final long zzk() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 2;
        if (this.zzx != -9223372036854775807L) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2) {
                return this.zzz;
            }
            return Math.min(this.zzA, this.zzz + zzet.zzo(zzet.zzp(zzet.zzr(elapsedRealtime) - this.zzx, this.zzi), this.zzf));
        }
        if (elapsedRealtime - this.zzr >= 5) {
            AudioTrack audioTrack2 = this.zzc;
            audioTrack2.getClass();
            int playState = audioTrack2.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack2.getPlaybackHeadPosition()) & 4294967295L;
                long j = 0;
                if (this.zzg) {
                    if (playState != 2) {
                        i = playState;
                    } else if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playbackHeadPosition += this.zzu;
                    playState = i;
                }
                if (zzet.zza <= 29) {
                    if (playbackHeadPosition != 0) {
                        j = playbackHeadPosition;
                    } else if (this.zzs > 0 && playState == 3) {
                        if (this.zzy == -9223372036854775807L) {
                            this.zzy = elapsedRealtime;
                        }
                    }
                    this.zzy = -9223372036854775807L;
                    playbackHeadPosition = j;
                }
                if (this.zzs > playbackHeadPosition) {
                    this.zzt++;
                }
                this.zzs = playbackHeadPosition;
            }
            this.zzr = elapsedRealtime;
        }
        return this.zzs + this.zzH + (this.zzt << 32);
    }

    private final long zzl() {
        return zzet.zzs(zzk(), this.zzf);
    }

    private final void zzm() {
        this.zzk = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzj = false;
    }

    public final long zza(boolean z) {
        long j;
        long j2;
        Method method;
        zzpp zzpp = this;
        AudioTrack audioTrack = zzpp.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - zzpp.zzl >= 30000) {
                long zzl2 = zzl();
                if (zzl2 != 0) {
                    zzpp.zzb[zzpp.zzv] = zzet.zzq(zzl2, zzpp.zzi) - nanoTime;
                    zzpp.zzv = (zzpp.zzv + 1) % 10;
                    int i = zzpp.zzw;
                    if (i < 10) {
                        zzpp.zzw = i + 1;
                    }
                    zzpp.zzl = nanoTime;
                    zzpp.zzk = 0;
                    int i2 = 0;
                    while (true) {
                        int i3 = zzpp.zzw;
                        if (i2 >= i3) {
                            break;
                        }
                        zzpp.zzk = (zzpp.zzb[i2] / ((long) i3)) + zzpp.zzk;
                        i2++;
                    }
                }
            }
            if (!zzpp.zzg) {
                zzpn zzpn = zzpp.zze;
                zzpn.getClass();
                if (zzpn.zzg(nanoTime)) {
                    long zzb2 = zzpn.zzb();
                    long zza2 = zzpn.zza();
                    long zzl3 = zzl();
                    if (Math.abs(zzb2 - nanoTime) > 5000000) {
                        zzqp zzqp = ((zzqk) zzpp.zza).zza;
                        long zzB2 = zzqp.zzJ();
                        long zzC2 = zzqp.zzK();
                        StringBuilder sb = new StringBuilder("Spurious audio timestamp (system clock mismatch): ");
                        sb.append(zza2);
                        String str = ", ";
                        sb.append(str);
                        sb.append(zzb2);
                        sb.append(str);
                        sb.append(nanoTime);
                        sb.append(str);
                        sb.append(zzl3);
                        sb.append(str);
                        sb.append(zzB2);
                        sb.append(str);
                        sb.append(zzC2);
                        zzea.zzf("DefaultAudioSink", sb.toString());
                        zzpn.zzd();
                    } else {
                        zzpp zzpp2 = zzpp;
                        String str2 = ", ";
                        if (Math.abs(zzet.zzs(zza2, zzpp2.zzf) - zzl3) > 5000000) {
                            zzqp zzqp2 = ((zzqk) zzpp2.zza).zza;
                            long zzB3 = zzqp2.zzJ();
                            long zzC3 = zzqp2.zzK();
                            zzea.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + zza2 + str2 + zzb2 + str2 + nanoTime + str2 + zzl3 + str2 + zzB3 + str2 + zzC3);
                            zzpn.zzd();
                        } else {
                            zzpn.zzc();
                        }
                    }
                    zzpp = this;
                }
                if (zzpp.zzp && (method = zzpp.zzm) != null && nanoTime - zzpp.zzq >= 500000) {
                    try {
                        AudioTrack audioTrack2 = zzpp.zzc;
                        audioTrack2.getClass();
                        int i4 = zzet.zza;
                        long intValue = (((long) ((Integer) method.invoke(audioTrack2, new Object[0])).intValue()) * 1000) - zzpp.zzh;
                        zzpp.zzn = intValue;
                        long max = Math.max(intValue, 0);
                        zzpp.zzn = max;
                        if (max > 5000000) {
                            zzea.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + max);
                            zzpp.zzn = 0;
                        }
                    } catch (Exception unused) {
                        zzpp.zzm = null;
                    }
                    zzpp.zzq = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        zzpn zzpn2 = zzpp.zze;
        zzpn2.getClass();
        boolean zzf2 = zzpn2.zzf();
        if (zzf2) {
            j = zzet.zzp(nanoTime2 - zzpn2.zzb(), zzpp.zzi) + zzet.zzs(zzpn2.zza(), zzpp.zzf);
        } else {
            if (zzpp.zzw == 0) {
                j2 = zzl();
            } else {
                j2 = zzet.zzp(zzpp.zzk + nanoTime2, zzpp.zzi);
            }
            j = j2;
            if (!z) {
                j = Math.max(0, j - zzpp.zzn);
            }
        }
        if (zzpp.zzD != zzf2) {
            zzpp.zzF = zzpp.zzC;
            zzpp.zzE = zzpp.zzB;
        }
        long j3 = nanoTime2 - zzpp.zzF;
        if (j3 < 1000000) {
            long j4 = (j3 * 1000) / 1000000;
            long j5 = j * j4;
            long j6 = 1000 - j4;
            j = ((j6 * (zzet.zzp(j3, zzpp.zzi) + zzpp.zzE)) + j5) / 1000;
        }
        if (!zzpp.zzj) {
            long j7 = zzpp.zzB;
            if (j > j7) {
                zzpp.zzj = true;
                int i5 = zzet.zza;
                long currentTimeMillis = System.currentTimeMillis() - zzet.zzu(zzet.zzq(zzet.zzu(j - j7), zzpp.zzi));
                zzqp zzqp3 = ((zzqk) zzpp.zza).zza;
                if (zzqp3.zzp != null) {
                    ((zzqu) zzqp3.zzp).zza.zzc.zzv(currentTimeMillis);
                }
            }
        }
        zzpp.zzC = nanoTime2;
        zzpp.zzB = j;
        zzpp.zzD = zzf2;
        return j;
    }

    public final void zzb(long j) {
        this.zzz = zzk();
        this.zzx = zzet.zzr(SystemClock.elapsedRealtime());
        this.zzA = j;
    }

    public final void zzc() {
        zzm();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r7
            com.google.android.gms.internal.ads.zzpn r0 = new com.google.android.gms.internal.ads.zzpn
            r0.<init>(r3)
            r2.zze = r0
            int r3 = r3.getSampleRate()
            r2.zzf = r3
            r3 = 0
            if (r4 == 0) goto L_0x0023
            int r4 = com.google.android.gms.internal.ads.zzet.zza
            r0 = 23
            if (r4 >= r0) goto L_0x0023
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L_0x0024
            r4 = 6
            if (r5 != r4) goto L_0x0023
            r5 = r4
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            r2.zzg = r0
            boolean r4 = com.google.android.gms.internal.ads.zzet.zzK(r5)
            r2.zzp = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x003c
            int r7 = r7 / r6
            long r4 = (long) r7
            int r6 = r2.zzf
            long r4 = com.google.android.gms.internal.ads.zzet.zzs(r4, r6)
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            r2.zzh = r4
            r4 = 0
            r2.zzs = r4
            r2.zzt = r4
            r2.zzG = r3
            r2.zzH = r4
            r2.zzu = r4
            r2.zzo = r3
            r2.zzx = r0
            r2.zzy = r0
            r2.zzq = r4
            r2.zzn = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpp.zzd(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zze() {
        if (this.zzx != -9223372036854775807L) {
            this.zzx = zzet.zzr(SystemClock.elapsedRealtime());
        }
        zzpn zzpn = this.zze;
        zzpn.getClass();
        zzpn.zze();
    }

    public final boolean zzf(long j) {
        if (j > zzet.zzo(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && zzk() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean zzg() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            return true;
        }
        return false;
    }

    public final boolean zzh(long j) {
        if (this.zzy == -9223372036854775807L || j <= 0 || SystemClock.elapsedRealtime() - this.zzy < 200) {
            return false;
        }
        return true;
    }

    public final boolean zzi(long j) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzg) {
            if (playState == 2) {
                this.zzo = false;
                return false;
            } else if (playState == 1) {
                if (zzk() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzo;
        boolean zzf2 = zzf(j);
        this.zzo = zzf2;
        if (z && !zzf2 && playState != 1) {
            zzpo zzpo = this.zza;
            int i = this.zzd;
            long zzu2 = zzet.zzu(this.zzh);
            zzqk zzqk = (zzqk) zzpo;
            zzqp zzqp = zzqk.zza;
            if (zzqp.zzp != null) {
                ((zzqu) zzqk.zza.zzp).zza.zzc.zzx(i, zzu2, SystemClock.elapsedRealtime() - zzqp.zzV);
            }
        }
        return true;
    }

    public final boolean zzj() {
        zzm();
        if (this.zzx == -9223372036854775807L) {
            zzpn zzpn = this.zze;
            zzpn.getClass();
            zzpn.zze();
            return true;
        }
        this.zzz = zzk();
        return false;
    }
}
