package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzann implements zzang {
    final /* synthetic */ zzano zza;
    private final zzej zzb = new zzej(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzann(zzano zzano, int i) {
        this.zza = zzano;
        this.zze = i;
    }

    public final void zza(zzek zzek) {
        zzer zzer;
        zzer zzer2;
        int i;
        zzek zzek2 = zzek;
        if (zzek.zzm() == 2) {
            zzer zzer3 = (zzer) this.zza.zzb.get(0);
            if ((zzek.zzm() & 128) != 0) {
                zzek2.zzL(1);
                int zzq = zzek.zzq();
                int i2 = 3;
                zzek2.zzL(3);
                zzek2.zzF(this.zzb, 2);
                this.zzb.zzn(3);
                int i3 = 13;
                this.zza.zzr = this.zzb.zzd(13);
                zzek2.zzF(this.zzb, 2);
                int i4 = 4;
                this.zzb.zzn(4);
                int i5 = 12;
                zzek2.zzL(this.zzb.zzd(12));
                this.zzc.clear();
                this.zzd.clear();
                int zzb2 = zzek.zzb();
                while (zzb2 > 0) {
                    int i6 = 5;
                    zzek2.zzF(this.zzb, 5);
                    zzej zzej = this.zzb;
                    int zzd2 = zzej.zzd(8);
                    zzej.zzn(i2);
                    int zzd3 = this.zzb.zzd(i3);
                    this.zzb.zzn(i4);
                    int zzd4 = this.zzb.zzd(i5);
                    int zzd5 = zzek.zzd();
                    int i7 = zzd5 + zzd4;
                    int i8 = 0;
                    String str = null;
                    ArrayList arrayList = null;
                    int i9 = -1;
                    while (zzek.zzd() < i7) {
                        int zzm = zzek.zzm();
                        int zzd6 = zzek.zzd() + zzek.zzm();
                        if (zzd6 > i7) {
                            break;
                        }
                        if (zzm == i6) {
                            long zzu = zzek.zzu();
                            if (zzu != 1094921523) {
                                if (zzu != 1161904947) {
                                    if (zzu != 1094921524) {
                                        if (zzu == 1212503619) {
                                            i = 36;
                                            zzer2 = zzer3;
                                            i9 = i;
                                            zzek2.zzL(zzd6 - zzek.zzd());
                                            zzer3 = zzer2;
                                            i2 = 3;
                                            i4 = 4;
                                            i6 = 5;
                                        }
                                        zzer2 = zzer3;
                                        zzek2.zzL(zzd6 - zzek.zzd());
                                        zzer3 = zzer2;
                                        i2 = 3;
                                        i4 = 4;
                                        i6 = 5;
                                    }
                                }
                                zzer2 = zzer3;
                                i9 = 135;
                                zzek2.zzL(zzd6 - zzek.zzd());
                                zzer3 = zzer2;
                                i2 = 3;
                                i4 = 4;
                                i6 = 5;
                            }
                            zzer2 = zzer3;
                            i9 = 129;
                            zzek2.zzL(zzd6 - zzek.zzd());
                            zzer3 = zzer2;
                            i2 = 3;
                            i4 = 4;
                            i6 = 5;
                        } else {
                            if (zzm != 106) {
                                if (zzm != 122) {
                                    if (zzm == 127) {
                                        int zzm2 = zzek.zzm();
                                        if (zzm2 != 21) {
                                            if (zzm2 == 14) {
                                                i = 136;
                                            } else {
                                                if (zzm2 == 33) {
                                                    i = 139;
                                                }
                                                zzer2 = zzer3;
                                                zzek2.zzL(zzd6 - zzek.zzd());
                                                zzer3 = zzer2;
                                                i2 = 3;
                                                i4 = 4;
                                                i6 = 5;
                                            }
                                        }
                                    } else if (zzm == 123) {
                                        i = 138;
                                    } else {
                                        if (zzm == 10) {
                                            String trim = zzek2.zzA(i2, zzfuj.zzc).trim();
                                            i8 = zzek.zzm();
                                            zzer2 = zzer3;
                                            str = trim;
                                        } else if (zzm == 89) {
                                            ArrayList arrayList2 = new ArrayList();
                                            while (zzek.zzd() < zzd6) {
                                                String trim2 = zzek2.zzA(i2, zzfuj.zzc).trim();
                                                int zzm3 = zzek.zzm();
                                                zzer zzer4 = zzer3;
                                                byte[] bArr = new byte[i4];
                                                zzek2.zzG(bArr, 0, i4);
                                                arrayList2.add(new zzanp(trim2, zzm3, bArr));
                                                zzer3 = zzer4;
                                                i2 = 3;
                                                i4 = 4;
                                            }
                                            zzer2 = zzer3;
                                            arrayList = arrayList2;
                                            i9 = 89;
                                        } else {
                                            zzer2 = zzer3;
                                            if (zzm == 111) {
                                                i9 = 257;
                                            }
                                        }
                                        zzek2.zzL(zzd6 - zzek.zzd());
                                        zzer3 = zzer2;
                                        i2 = 3;
                                        i4 = 4;
                                        i6 = 5;
                                    }
                                    zzer2 = zzer3;
                                    i9 = i;
                                    zzek2.zzL(zzd6 - zzek.zzd());
                                    zzer3 = zzer2;
                                    i2 = 3;
                                    i4 = 4;
                                    i6 = 5;
                                }
                                zzer2 = zzer3;
                                i9 = 135;
                                zzek2.zzL(zzd6 - zzek.zzd());
                                zzer3 = zzer2;
                                i2 = 3;
                                i4 = 4;
                                i6 = 5;
                            }
                            zzer2 = zzer3;
                            i9 = 129;
                            zzek2.zzL(zzd6 - zzek.zzd());
                            zzer3 = zzer2;
                            i2 = 3;
                            i4 = 4;
                            i6 = 5;
                        }
                        zzer2 = zzer3;
                        i9 = 172;
                        zzek2.zzL(zzd6 - zzek.zzd());
                        zzer3 = zzer2;
                        i2 = 3;
                        i4 = 4;
                        i6 = 5;
                    }
                    zzer zzer5 = zzer3;
                    zzek2.zzK(i7);
                    zzanq zzanq = new zzanq(i9, str, i8, arrayList, Arrays.copyOfRange(zzek.zzM(), zzd5, i7));
                    if (zzd2 == 6 || zzd2 == 5) {
                        zzd2 = zzanq.zza;
                    }
                    zzb2 -= zzd4 + 5;
                    if (!this.zza.zzh.get(zzd3)) {
                        zzant zza2 = this.zza.zze.zza(zzd2, zzanq);
                        this.zzd.put(zzd3, zzd3);
                        this.zzc.put(zzd3, zza2);
                    }
                    zzer3 = zzer5;
                    i2 = 3;
                    i4 = 4;
                    i5 = 12;
                    i3 = 13;
                }
                zzer zzer6 = zzer3;
                int size = this.zzd.size();
                int i10 = 0;
                while (i10 < size) {
                    SparseIntArray sparseIntArray = this.zzd;
                    zzano zzano = this.zza;
                    int keyAt = sparseIntArray.keyAt(i10);
                    int valueAt = sparseIntArray.valueAt(i10);
                    zzano.zzh.put(keyAt, true);
                    this.zza.zzi.put(valueAt, true);
                    zzant zzant = (zzant) this.zzc.valueAt(i10);
                    if (zzant != null) {
                        zzacn zzl = this.zza.zzl;
                        zzans zzans = new zzans(zzq, keyAt, UserMetadata.MAX_INTERNAL_KEY_SIZE);
                        zzer = zzer6;
                        zzant.zzb(zzer, zzl, zzans);
                        this.zza.zzg.put(valueAt, zzant);
                    } else {
                        zzer = zzer6;
                    }
                    i10++;
                    zzer6 = zzer;
                }
                this.zza.zzg.remove(this.zze);
                this.zza.zzm = 0;
                zzano zzano2 = this.zza;
                if (zzano2.zzm == 0) {
                    zzano2.zzl.zzD();
                    this.zza.zzn = true;
                }
            }
        }
    }

    public final void zzb(zzer zzer, zzacn zzacn, zzans zzans) {
    }
}
