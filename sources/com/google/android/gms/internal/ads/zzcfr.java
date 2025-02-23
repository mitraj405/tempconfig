package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzcfr extends zzcer {
    public zzcfr(zzcej zzcej, zzbav zzbav, boolean z, zzeds zzeds) {
        super(zzcej, zzbav, z, new zzbrp(zzcej, zzcej.zzE(), new zzbbe(zzcej.getContext())), (zzbrk) null, zzeds);
    }

    public final WebResourceResponse zzS(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcej)) {
            zzm.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcej zzcej = (zzcej) webView;
        zzbxl zzbxl = this.zza;
        if (zzbxl != null) {
            zzbxl.zzd(str, map, 1);
        }
        zzfqt.zza();
        int i = zzfqy.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcej.zzN() != null) {
            zzcej.zzN().zzF();
        }
        if (zzcej.zzO().zzi()) {
            str2 = (String) zzba.zzc().zza(zzbbw.zzH);
        } else if (zzcej.zzaF()) {
            str2 = (String) zzba.zzc().zza(zzbbw.zzG);
        } else {
            str2 = (String) zzba.zzc().zza(zzbbw.zzF);
        }
        zzu.zzp();
        return zzt.zzx(zzcej.getContext(), zzcej.zzn().afmaVersion, str2);
    }
}
