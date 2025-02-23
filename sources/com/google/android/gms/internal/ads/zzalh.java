package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzalh implements zzaka {
    private final zzek zza = new zzek();

    public final void zza(byte[] bArr, int i, int i2, zzajz zzajz, zzdn zzdn) {
        boolean z;
        zzdb zzdb;
        boolean z2;
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzek zzek = this.zza;
            if (zzek.zzb() > 0) {
                if (zzek.zzb() >= 8) {
                    z = true;
                } else {
                    z = false;
                }
                zzdi.zze(z, "Incomplete Mp4Webvtt Top Level box header found.");
                zzek zzek2 = this.zza;
                int zzg = zzek2.zzg() - 8;
                if (zzek2.zzg() == 1987343459) {
                    zzek zzek3 = this.zza;
                    CharSequence charSequence = null;
                    zzcz zzcz = null;
                    while (zzg > 0) {
                        if (zzg >= 8) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zzdi.zze(z2, "Incomplete vtt cue box header found.");
                        int zzg2 = zzek3.zzg();
                        int zzg3 = zzek3.zzg();
                        int i3 = zzg - 8;
                        int i4 = zzg2 - 8;
                        String zzB = zzet.zzB(zzek3.zzM(), zzek3.zzd(), i4);
                        zzek3.zzL(i4);
                        if (zzg3 == 1937011815) {
                            zzcz = zzalr.zzb(zzB);
                        } else if (zzg3 == 1885436268) {
                            charSequence = zzalr.zza((String) null, zzB.trim(), Collections.emptyList());
                        }
                        zzg = i3 - i4;
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (zzcz != null) {
                        zzcz.zzl(charSequence);
                        zzdb = zzcz.zzp();
                    } else {
                        zzalq zzalq = new zzalq();
                        zzalq.zzc = charSequence;
                        zzdb = zzalq.zza().zzp();
                    }
                    arrayList.add(zzdb);
                } else {
                    this.zza.zzL(zzg);
                }
            } else {
                zzdn.zza(new zzajs(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }

    public final /* synthetic */ void zzb() {
    }
}
