package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgej {
    private final zzgth zza;
    private final List zzb;
    private final zzgln zzc;

    public /* synthetic */ zzgej(zzgth zzgth, List list, zzgln zzgln, zzgei zzgei) {
        this.zza = zzgth;
        this.zzb = list;
        this.zzc = zzgln;
    }

    public static final zzgej zza(zzgth zzgth) throws GeneralSecurityException {
        zzh(zzgth);
        return new zzgej(zzgth, zzg(zzgth));
    }

    public static final zzgej zzb(zzgen zzgen) throws GeneralSecurityException {
        zzgef zzgef = new zzgef();
        zzged zzged = new zzged(zzgen, (zzgec) null);
        zzged.zzd();
        zzged.zzc();
        zzgef.zza(zzged);
        return zzgef.zzb();
    }

    private final Object zzf(zzgkx zzgkx, Class cls, Class cls2) throws GeneralSecurityException {
        boolean z;
        int i = zzgeu.zza;
        zzgth zzgth = this.zza;
        int zzc2 = zzgth.zzc();
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = true;
        for (zzgtg zzgtg : zzgth.zzh()) {
            if (zzgtg.zzk() == 3) {
                if (!zzgtg.zzj()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzgtg.zza())}));
                } else if (zzgtg.zzf() == zzgtz.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzgtg.zza())}));
                } else if (zzgtg.zzk() != 2) {
                    if (zzgtg.zza() == zzc2) {
                        if (!z2) {
                            z2 = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (zzgtg.zzc().zzc() != zzgsu.ASYMMETRIC_PUBLIC) {
                        z = false;
                    } else {
                        z = true;
                    }
                    z3 &= z;
                    i2++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzgtg.zza())}));
                }
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (z2 || z3) {
            zzgnf zzb2 = zzgnj.zzb(cls2);
            zzb2.zzc(this.zzc);
            for (int i3 = 0; i3 < this.zzb.size(); i3++) {
                zzgtg zze = this.zza.zze(i3);
                if (zze.zzk() == 3) {
                    zzgeh zzgeh = (zzgeh) this.zzb.get(i3);
                    if (zzgeh != null) {
                        zzgdy zza2 = zzgeh.zza();
                        try {
                            Object zzc3 = zzgmh.zza().zzc(zza2, cls2);
                            if (zze.zza() == this.zza.zzc()) {
                                zzb2.zzb(zzc3, zza2, zze);
                            } else {
                                zzb2.zza(zzc3, zza2, zze);
                            }
                        } catch (GeneralSecurityException e) {
                            throw new GeneralSecurityException(C1058d.A("Unable to get primitive ", cls2.toString(), " for key of type ", zze.zzc().zzg(), ", see https://developers.google.com/tink/faq/registration_errors"), e);
                        }
                    } else {
                        throw new GeneralSecurityException("Key parsing of key with index " + i3 + " and type_url " + zze.zzc().zzg() + " failed, unable to get primitive");
                    }
                }
            }
            zzgnj zzd = zzb2.zzd();
            int i4 = zzgeq.zza;
            return zzgmh.zza().zzd(zzd, cls);
        } else {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }

    private static List zzg(zzgth zzgth) {
        Integer num;
        zzgdy zzgdy;
        zzgea zzgea;
        boolean z;
        ArrayList arrayList = new ArrayList(zzgth.zza());
        for (zzgtg zzgtg : zzgth.zzh()) {
            int zza2 = zzgtg.zza();
            try {
                int zza3 = zzgtg.zza();
                if (zzgtg.zzf() == zzgtz.RAW) {
                    num = null;
                } else {
                    num = Integer.valueOf(zza3);
                }
                zzgnl zza4 = zzgnl.zza(zzgtg.zzc().zzg(), zzgtg.zzc().zzf(), zzgtg.zzc().zzc(), zzgtg.zzf(), num);
                zzgmk zzc2 = zzgmk.zzc();
                zzger zza5 = zzger.zza();
                if (!zzc2.zzj(zza4)) {
                    zzgdy = new zzglj(zza4, zza5);
                } else {
                    zzgdy = zzc2.zza(zza4, zza5);
                }
                int zzk = zzgtg.zzk() - 2;
                if (zzk == 1) {
                    zzgea = zzgea.zza;
                } else if (zzk == 2) {
                    zzgea = zzgea.zzb;
                } else if (zzk == 3) {
                    zzgea = zzgea.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                zzgea zzgea2 = zzgea;
                if (zza2 == zzgth.zzc()) {
                    z = true;
                } else {
                    z = false;
                }
                arrayList.add(new zzgeh(zzgdy, zzgea2, zza2, z, (zzgeg) null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public static void zzh(zzgth zzgth) throws GeneralSecurityException {
        if (zzgth == null || zzgth.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        int i = zzgeu.zza;
        zzgtj zza2 = zzgtm.zza();
        zzgth zzgth = this.zza;
        zza2.zzb(zzgth.zzc());
        for (zzgtg zzgtg : zzgth.zzh()) {
            zzgtk zza3 = zzgtl.zza();
            zza3.zzc(zzgtg.zzc().zzg());
            zza3.zzd(zzgtg.zzk());
            zza3.zzb(zzgtg.zzf());
            zza3.zza(zzgtg.zza());
            zza2.zza((zzgtl) zza3.zzbr());
        }
        return ((zzgtm) zza2.zzbr()).toString();
    }

    public final zzgth zzc() {
        return this.zza;
    }

    public final Object zzd(zzgds zzgds, Class cls) throws GeneralSecurityException {
        Class zza2 = zzgeq.zza(cls);
        if (zza2 != null) {
            return zzf((zzgkx) zzgds, cls, zza2);
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
    }

    private zzgej(zzgth zzgth, List list) {
        this.zza = zzgth;
        this.zzb = list;
        this.zzc = zzgln.zza;
    }
}
