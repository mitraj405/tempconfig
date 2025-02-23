package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgwx implements zzgzw {
    private final zzgww zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgwx(zzgww zzgww) {
        zzgyl.zzc(zzgww, "input");
        this.zza = zzgww;
        zzgww.zzc = this;
    }

    private final void zzO(Object obj, zzhae zzhae, zzgxi zzgxi) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzhae.zzh(obj, this, zzgxi);
            if (this.zzb != this.zzc) {
                throw zzgyn.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzP(Object obj, zzhae zzhae, zzgxi zzgxi) throws IOException {
        zzgww zzgww = this.zza;
        int zzm = zzgww.zzm();
        if (zzgww.zza < zzgww.zzb) {
            int zzd2 = this.zza.zzd(zzm);
            this.zza.zza++;
            zzhae.zzh(obj, this, zzgxi);
            this.zza.zzy(0);
            zzgww zzgww2 = this.zza;
            zzgww2.zza--;
            zzgww2.zzz(zzd2);
            return;
        }
        throw new zzgyn("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzQ(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw zzgyn.zzi();
        }
    }

    private final void zzR(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzgyn.zza();
        }
    }

    private static final void zzS(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzgyn.zzg();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzgyn.zzg();
        }
    }

    public static zzgwx zzq(zzgww zzgww) {
        zzgwx zzgwx = zzgww.zzc;
        if (zzgwx != null) {
            return zzgwx;
        }
        return new zzgwx(zzgww);
    }

    public final void zzA(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgyy.zzg(this.zza.zzn());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzT(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgyy.zzg(this.zza.zzn());
                } while (this.zza.zzc() < zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzT(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzB(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxp) {
            zzgxp zzgxp = (zzgxp) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzS(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgxp.zzh(this.zza.zzb());
                } while (this.zza.zzc() < zzc2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgxp.zzh(this.zza.zzb());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzS(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    @Deprecated
    public final void zzC(List list, zzhae zzhae, zzgxi zzgxi) throws IOException {
        int zzl;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                Object zze = zzhae.zze();
                zzO(zze, zzhae, zzgxi);
                zzhae.zzf(zze);
                list.add(zze);
                if (!this.zza.zzA() && this.zzd == 0) {
                    zzl = this.zza.zzl();
                } else {
                    return;
                }
            } while (zzl == i);
            this.zzd = zzl;
            return;
        }
        throw zzgyn.zza();
    }

    public final void zzD(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgxz.zzi(this.zza.zzg());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgxz.zzi(this.zza.zzg());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzE(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgyy.zzg(this.zza.zzo());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgyy.zzg(this.zza.zzo());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzF(List list, zzhae zzhae, zzgxi zzgxi) throws IOException {
        int zzl;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                Object zze = zzhae.zze();
                zzP(zze, zzhae, zzgxi);
                zzhae.zzf(zze);
                list.add(zze);
                if (!this.zza.zzA() && this.zzd == 0) {
                    zzl = this.zza.zzl();
                } else {
                    return;
                }
            } while (zzl == i);
            this.zzd = zzl;
            return;
        }
        throw zzgyn.zza();
    }

    public final void zzG(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzS(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgxz.zzi(this.zza.zzj());
                } while (this.zza.zzc() < zzc2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgxz.zzi(this.zza.zzj());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzS(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzH(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgyy.zzg(this.zza.zzs());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzT(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgyy.zzg(this.zza.zzs());
                } while (this.zza.zzc() < zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzs()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzT(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzs()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzI(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgxz.zzi(this.zza.zzk());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgxz.zzi(this.zza.zzk());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzJ(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgyy.zzg(this.zza.zzt());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgyy.zzg(this.zza.zzt());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzK(List list, boolean z) throws IOException {
        String str;
        int zzl;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzgyv) && !z) {
                zzgyv zzgyv = (zzgyv) list;
                do {
                    zzp();
                    zzgyv.zzb();
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                do {
                    if (z) {
                        str = zzs();
                    } else {
                        str = zzr();
                    }
                    list.add(str);
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            }
            this.zzd = i;
            return;
        }
        throw zzgyn.zza();
    }

    public final void zzL(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgxz.zzi(this.zza.zzm());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgxz.zzi(this.zza.zzm());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzM(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgyy.zzg(this.zza.zzu());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgyy.zzg(this.zza.zzu());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final boolean zzN() throws IOException {
        zzR(0);
        return this.zza.zzB();
    }

    public final double zza() throws IOException {
        zzR(1);
        return this.zza.zza();
    }

    public final float zzb() throws IOException {
        zzR(5);
        return this.zza.zzb();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzl();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzR(0);
        return this.zza.zze();
    }

    public final int zzf() throws IOException {
        zzR(5);
        return this.zza.zzf();
    }

    public final int zzg() throws IOException {
        zzR(0);
        return this.zza.zzg();
    }

    public final int zzh() throws IOException {
        zzR(5);
        return this.zza.zzj();
    }

    public final int zzi() throws IOException {
        zzR(0);
        return this.zza.zzk();
    }

    public final int zzj() throws IOException {
        zzR(0);
        return this.zza.zzm();
    }

    public final long zzk() throws IOException {
        zzR(1);
        return this.zza.zzn();
    }

    public final long zzl() throws IOException {
        zzR(0);
        return this.zza.zzo();
    }

    public final long zzm() throws IOException {
        zzR(1);
        return this.zza.zzs();
    }

    public final long zzn() throws IOException {
        zzR(0);
        return this.zza.zzt();
    }

    public final long zzo() throws IOException {
        zzR(0);
        return this.zza.zzu();
    }

    public final zzgwm zzp() throws IOException {
        zzR(2);
        return this.zza.zzv();
    }

    public final String zzr() throws IOException {
        zzR(2);
        return this.zza.zzw();
    }

    public final String zzs() throws IOException {
        zzR(2);
        return this.zza.zzx();
    }

    public final void zzt(Object obj, zzhae zzhae, zzgxi zzgxi) throws IOException {
        zzR(3);
        zzO(obj, zzhae, zzgxi);
    }

    public final void zzu(Object obj, zzhae zzhae, zzgxi zzgxi) throws IOException {
        zzR(2);
        zzP(obj, zzhae, zzgxi);
    }

    public final void zzv(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgwc) {
            zzgwc zzgwc = (zzgwc) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgwc.zzg(this.zza.zzB());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgwc.zzg(this.zza.zzB());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzB()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzB()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzw(List list) throws IOException {
        int zzl;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzA()) {
                    zzl = this.zza.zzl();
                } else {
                    return;
                }
            } while (zzl == this.zzb);
            this.zzd = zzl;
            return;
        }
        throw zzgyn.zza();
    }

    public final void zzx(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxf) {
            zzgxf zzgxf = (zzgxf) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzgxf.zzh(this.zza.zza());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzT(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgxf.zzh(this.zza.zza());
                } while (this.zza.zzc() < zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzT(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzy(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgxz.zzi(this.zza.zze());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzgww zzgww = this.zza;
                int zzc2 = zzgww.zzc() + zzgww.zzm();
                do {
                    zzgxz.zzi(this.zza.zze());
                } while (this.zza.zzc() < zzc2);
                zzQ(zzc2);
                return;
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else if (i3 == 2) {
                zzgww zzgww2 = this.zza;
                int zzc3 = zzgww2.zzc() + zzgww2.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < zzc3);
                zzQ(zzc3);
                return;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzz(List list) throws IOException {
        int i;
        int zzl;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm = this.zza.zzm();
                zzS(zzm);
                int zzc2 = this.zza.zzc() + zzm;
                do {
                    zzgxz.zzi(this.zza.zzf());
                } while (this.zza.zzc() < zzc2);
                return;
            } else if (i2 == 5) {
                do {
                    zzgxz.zzi(this.zza.zzf());
                    if (!this.zza.zzA()) {
                        i = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzgyn.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzm2 = this.zza.zzm();
                zzS(zzm2);
                int zzc3 = this.zza.zzc() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < zzc3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzA()) {
                        zzl = this.zza.zzl();
                    } else {
                        return;
                    }
                } while (zzl == this.zzb);
                i = zzl;
            } else {
                throw zzgyn.zza();
            }
        }
        this.zzd = i;
    }
}
