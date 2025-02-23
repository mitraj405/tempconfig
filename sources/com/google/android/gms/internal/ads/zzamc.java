package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamc implements zzanr {
    private final List zza;

    public zzamc(int i, List list) {
        this.zza = list;
    }

    private final zzani zzb(zzanq zzanq) {
        return new zzani(zzd(zzanq));
    }

    private final zzanv zzc(zzanq zzanq) {
        return new zzanv(zzd(zzanq));
    }

    private final List zzd(zzanq zzanq) {
        ArrayList arrayList;
        boolean z;
        String str;
        int i;
        List list;
        zzek zzek = new zzek(zzanq.zze);
        List list2 = this.zza;
        while (zzek.zzb() > 0) {
            int zzm = zzek.zzm();
            int zzd = zzek.zzd() + zzek.zzm();
            if (zzm == 134) {
                ArrayList arrayList2 = new ArrayList();
                int zzm2 = zzek.zzm() & 31;
                for (int i2 = 0; i2 < zzm2; i2++) {
                    String zzA = zzek.zzA(3, zzfuj.zzc);
                    int zzm3 = zzek.zzm();
                    if ((zzm3 & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i = zzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte zzm4 = (byte) zzek.zzm();
                    zzek.zzL(1);
                    if (z) {
                        list = Collections.singletonList((zzm4 & SignedBytes.MAX_POWER_OF_TWO) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzad zzad = new zzad();
                    zzad.zzX(str);
                    zzad.zzO(zzA);
                    zzad.zzw(i);
                    zzad.zzL(list);
                    arrayList2.add(zzad.zzad());
                }
                arrayList = arrayList2;
            } else {
                arrayList = list2;
            }
            zzek.zzK(zzd);
            list2 = arrayList;
        }
        return list2;
    }

    public final zzant zza(int i, zzanq zzanq) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzamz(new zzamr(zzanq.zzb, zzanq.zza()));
            }
            if (i == 21) {
                return new zzamz(new zzamp());
            }
            if (i == 27) {
                return new zzamz(new zzamm(zzb(zzanq), false, false));
            }
            if (i == 36) {
                return new zzamz(new zzamo(zzb(zzanq)));
            }
            if (i == 45) {
                return new zzamz(new zzams());
            }
            if (i == 89) {
                return new zzamz(new zzame(zzanq.zzd));
            }
            if (i == 172) {
                return new zzamz(new zzalz(zzanq.zzb, zzanq.zza()));
            }
            if (i == 257) {
                return new zzanh(new zzamy("application/vnd.dvb.ait"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzamz(new zzamd(zzanq.zzb, zzanq.zza(), 5408));
                        }
                        switch (i) {
                            case 15:
                                return new zzamz(new zzamb(false, zzanq.zzb, zzanq.zza()));
                            case 16:
                                return new zzamz(new zzamk(zzc(zzanq)));
                            case 17:
                                return new zzamz(new zzamq(zzanq.zzb, zzanq.zza()));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzanh(new zzamy("application/x-scte35"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                        }
                    }
                    return new zzamz(new zzamd(zzanq.zzb, zzanq.zza(), 4096));
                }
                return new zzamz(new zzalx(zzanq.zzb, zzanq.zza()));
            }
        }
        return new zzamz(new zzamh(zzc(zzanq)));
    }

    public zzamc() {
        this(0);
    }

    public zzamc(int i) {
        this.zza = zzfxr.zzm();
    }
}
