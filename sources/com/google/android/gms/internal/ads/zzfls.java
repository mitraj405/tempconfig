package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfls {
    private final zzfmd zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzflt zzg;

    private zzfls(zzfmd zzfmd, WebView webView, String str, List list, String str2, String str3, zzflt zzflt) {
        this.zza = zzfmd;
        this.zzb = webView;
        this.zzg = zzflt;
        this.zzf = str2;
        this.zze = str3;
    }

    public static zzfls zzb(zzfmd zzfmd, WebView webView, String str, String str2) {
        if (str2 != null) {
            zzfnj.zzd(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new zzfls(zzfmd, webView, (String) null, (List) null, str, str2, zzflt.HTML);
    }

    public static zzfls zzc(zzfmd zzfmd, WebView webView, String str, String str2) {
        zzfnj.zzd("", 256, "CustomReferenceData is greater than 256 characters");
        return new zzfls(zzfmd, webView, (String) null, (List) null, str, "", zzflt.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzflt zzd() {
        return this.zzg;
    }

    public final zzfmd zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
