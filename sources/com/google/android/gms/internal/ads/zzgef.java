package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgef {
    private final List zza = new ArrayList();
    private final zzgln zzb = zzgln.zza;
    private boolean zzc = false;

    /* access modifiers changed from: private */
    public final void zzd() {
        for (zzged zzi : this.zza) {
            zzi.zza = false;
        }
    }

    public final zzgef zza(zzged zzged) {
        if (zzged.zzf == null) {
            if (zzged.zza) {
                zzd();
            }
            zzged.zzf = this;
            this.zza.add(zzged);
            return this;
        }
        throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
    }

    public final zzgej zzb() throws GeneralSecurityException {
        Integer num;
        int i;
        if (!this.zzc) {
            char c = 1;
            this.zzc = true;
            List list = this.zza;
            zzgte zzd = zzgth.zzd();
            ArrayList arrayList = new ArrayList(list.size());
            List list2 = this.zza;
            byte b = 0;
            int i2 = 0;
            while (i2 < list2.size() - 1) {
                int i3 = i2 + 1;
                if (((zzged) list2.get(i2)).zze != zzgee.zza || ((zzged) list2.get(i3)).zze == zzgee.zza) {
                    i2 = i3;
                } else {
                    throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
                }
            }
            HashSet hashSet = new HashSet();
            Integer num2 = null;
            for (zzged zzged : this.zza) {
                zzgea unused = zzged.zzb;
                if (zzged.zze != null) {
                    int i4 = 4;
                    if (zzged.zze == zzgee.zza) {
                        byte b2 = b;
                        while (true) {
                            if (b != 0 && !hashSet.contains(Integer.valueOf(b))) {
                                break;
                            }
                            SecureRandom secureRandom = new SecureRandom();
                            byte[] bArr = new byte[i4];
                            int i5 = i4;
                            byte b3 = b2;
                            while (b2 == 0) {
                                secureRandom.nextBytes(bArr);
                                b2 = ((bArr[b3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[c] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[3] & UnsignedBytes.MAX_VALUE);
                                b3 = 0;
                                i5 = 4;
                            }
                            b = b2;
                            b2 = b3;
                            i4 = i5;
                        }
                    } else {
                        zzgee unused2 = zzged.zze;
                        b = 0;
                    }
                    Integer valueOf = Integer.valueOf(b);
                    if (!hashSet.contains(valueOf)) {
                        hashSet.add(valueOf);
                        zzgdy unused3 = zzged.zzc;
                        if (c != zzged.zzd.zza()) {
                            num = null;
                        } else {
                            num = valueOf;
                        }
                        zzgdy zza2 = zzgma.zzb().zza(zzged.zzd, num);
                        HashSet hashSet2 = hashSet;
                        zzgeh zzgeh = r9;
                        zzgeh zzgeh2 = new zzgeh(zza2, zzged.zzb, b, zzged.zza, (zzgeg) null);
                        zzgea zzb2 = zzged.zzb;
                        zzgnl zzgnl = (zzgnl) zzgmk.zzc().zzd(zza2, zzgnl.class, zzger.zza());
                        Integer zzf = zzgnl.zzf();
                        if (zzf == null || zzf.intValue() == b) {
                            zzgea zzgea = zzgea.zza;
                            if (zzgea.equals(zzb2)) {
                                i = 3;
                            } else if (zzgea.zzb.equals(zzb2)) {
                                i = 4;
                            } else if (zzgea.zzc.equals(zzb2)) {
                                i = 5;
                            } else {
                                throw new IllegalStateException("Unknown key status");
                            }
                            zzgtf zzd2 = zzgtg.zzd();
                            zzgst zza3 = zzgsv.zza();
                            zza3.zzb(zzgnl.zzg());
                            zza3.zzc(zzgnl.zze());
                            zza3.zza(zzgnl.zzb());
                            zzd2.zza(zza3);
                            zzd2.zzd(i);
                            zzd2.zzb(b);
                            zzd2.zzc(zzgnl.zzc());
                            zzd.zza((zzgtg) zzd2.zzbr());
                            if (zzged.zza) {
                                if (num2 != null) {
                                    throw new GeneralSecurityException("Two primaries were set");
                                } else if (zzged.zzb == zzgea) {
                                    num2 = valueOf;
                                } else {
                                    throw new GeneralSecurityException("Primary key is not enabled");
                                }
                            }
                            arrayList.add(zzgeh);
                            c = 1;
                            b = 0;
                            hashSet = hashSet2;
                        } else {
                            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
                        }
                    } else {
                        throw new GeneralSecurityException(C1058d.y("Id ", b, " is used twice in the keyset"));
                    }
                } else {
                    throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
                }
            }
            if (num2 != null) {
                zzd.zzb(num2.intValue());
                zzgth zzgth = (zzgth) zzd.zzbr();
                zzgej.zzh(zzgth);
                return new zzgej(zzgth, arrayList, this.zzb, (zzgei) null);
            }
            throw new GeneralSecurityException("No primary was set");
        }
        throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
    }
}
