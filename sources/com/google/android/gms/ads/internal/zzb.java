package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzbxl;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbxl zzc;
    private final zzbue zzd = new zzbue(false, Collections.emptyList());

    public zzb(Context context, zzbxl zzbxl, zzbue zzbue) {
        this.zza = context;
        this.zzc = zzbxl;
    }

    private final boolean zzd() {
        zzbxl zzbxl = this.zzc;
        if ((zzbxl == null || !zzbxl.zza().zzf) && !this.zzd.zza) {
            return false;
        }
        return true;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbxl zzbxl = this.zzc;
            if (zzbxl != null) {
                zzbxl.zzd(str, (Map) null, 3);
                return;
            }
            zzbue zzbue = this.zzd;
            if (zzbue.zza && (list = zzbue.zzb) != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        Context context = this.zza;
                        zzu.zzp();
                        zzt.zzL(context, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzc() {
        if (!zzd() || this.zzb) {
            return true;
        }
        return false;
    }
}
