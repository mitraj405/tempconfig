package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzaqm extends zzaph {
    private final Object zza = new Object();
    private final zzapm zzb;

    public zzaqm(int i, String str, zzapm zzapm, zzapl zzapl) {
        super(i, str, zzapl);
        this.zzb = zzapm;
    }

    public final zzapn zzh(zzapd zzapd) {
        String str;
        try {
            byte[] bArr = zzapd.zzb;
            Map map = zzapd.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = (String) map.get(HttpHeaders.CONTENT_TYPE);
                if (str3 != null) {
                    String[] split = str3.split(";", 0);
                    int i = 1;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        String[] split2 = split[i].trim().split("=", 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapd.zzb);
        }
        return zzapn.zzb(str, zzaqe.zzb(zzapd));
    }

    /* renamed from: zzz */
    public void zzo(String str) {
        zzapm zzapm;
        synchronized (this.zza) {
            zzapm = this.zzb;
        }
        zzapm.zza(str);
    }
}
