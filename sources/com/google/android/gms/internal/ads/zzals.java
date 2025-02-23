package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzals implements zzaka {
    private final zzek zza = new zzek();
    private final zzali zzb = new zzali();

    public final void zza(byte[] bArr, int i, int i2, zzajz zzajz, zzdn zzdn) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        try {
            zzek zzek = this.zza;
            int zzd = zzek.zzd();
            Charset charset = zzfuj.zzc;
            String zzy = zzek.zzy(charset);
            if (zzy == null || !zzy.startsWith("WEBVTT")) {
                zzek.zzK(zzd);
                throw zzbo.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzek.zzy(charset))), (Throwable) null);
            }
            do {
            } while (!TextUtils.isEmpty(this.zza.zzy(zzfuj.zzc)));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzek zzek2 = this.zza;
                char c = 65535;
                int i3 = 0;
                while (c == 65535) {
                    i3 = zzek2.zzd();
                    String zzy2 = zzek2.zzy(zzfuj.zzc);
                    if (zzy2 == null) {
                        c = 0;
                    } else if ("STYLE".equals(zzy2)) {
                        c = 2;
                    } else if (zzy2.startsWith("NOTE")) {
                        c = 1;
                    } else {
                        c = 3;
                    }
                }
                zzek2.zzK(i3);
                if (c == 0) {
                    zzaju.zza(new zzalv(arrayList2), zzajz, zzdn);
                    return;
                } else if (c == 1) {
                    do {
                    } while (!TextUtils.isEmpty(this.zza.zzy(zzfuj.zzc)));
                } else if (c != 2) {
                    zzalk zzc = zzalr.zzc(this.zza, arrayList);
                    if (zzc != null) {
                        arrayList2.add(zzc);
                    }
                } else if (arrayList2.isEmpty()) {
                    this.zza.zzy(zzfuj.zzc);
                    arrayList.addAll(this.zzb.zzb(this.zza));
                } else {
                    throw new IllegalArgumentException("A style block was found after the first cue.");
                }
            }
        } catch (zzbo e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final /* synthetic */ void zzb() {
    }
}
