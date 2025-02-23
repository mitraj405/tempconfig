package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbav;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcer;
import com.google.android.gms.internal.ads.zzcfs;
import com.google.android.gms.internal.ads.zzeds;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzu extends zzab {
    public zzu() {
        super((zzaa) null);
    }

    public final CookieManager zza(Context context) {
        com.google.android.gms.ads.internal.zzu.zzp();
        if (zzt.zzF()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzm.zzh("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzu.zzo().zzv(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final WebResourceResponse zzb(String str, String str2, int i, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }

    public final zzcer zzc(zzcej zzcej, zzbav zzbav, boolean z, zzeds zzeds) {
        return new zzcfs(zzcej, zzbav, z, zzeds);
    }
}
