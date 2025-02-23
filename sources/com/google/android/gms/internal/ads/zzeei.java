package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeei implements zzeej {
    public static /* synthetic */ zzeeo zzc(String str, String str2, String str3, zzeek zzeek, String str4, WebView webView, String str5, String str6, zzeel zzeel) {
        zzfmd zza = zzfmd.zza("Google", str2);
        zzfmc zzp = zzp("javascript");
        zzflv zzn = zzn(zzeek.toString());
        zzfmc zzfmc = zzfmc.NONE;
        if (zzp == zzfmc) {
            zzm.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzn == null) {
            zzm.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(zzeek)));
            return null;
        } else {
            zzfmc zzp2 = zzp(str4);
            if (zzn == zzflv.VIDEO && zzp2 == zzfmc) {
                zzm.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
                return null;
            }
            zzfls zzb = zzfls.zzb(zza, webView, str5, "");
            return new zzeeo(zzflq.zza(zzflr.zza(zzn, zzo(zzeel.toString()), zzp, zzp2, true), zzb), zzb);
        }
    }

    public static /* synthetic */ zzeeo zzd(String str, String str2, String str3, String str4, zzeek zzeek, WebView webView, String str5, String str6, zzeel zzeel) {
        zzfmd zza = zzfmd.zza(str, str2);
        zzfmc zzp = zzp("javascript");
        zzfmc zzp2 = zzp(str4);
        zzflv zzn = zzn(zzeek.toString());
        zzfmc zzfmc = zzfmc.NONE;
        if (zzp == zzfmc) {
            zzm.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzn == null) {
            zzm.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(zzeek)));
            return null;
        } else if (zzn == zzflv.VIDEO && zzp2 == zzfmc) {
            zzm.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        } else {
            zzfls zzc = zzfls.zzc(zza, webView, str5, "");
            return new zzeeo(zzflq.zza(zzflr.zza(zzn, zzo(zzeel.toString()), zzp, zzp2, true), zzc), zzc);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzflv zzn(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzflv r4 = com.google.android.gms.internal.ads.zzflv.VIDEO
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzflv r4 = com.google.android.gms.internal.ads.zzflv.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzflv r4 = com.google.android.gms.internal.ads.zzflv.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeei.zzn(java.lang.String):com.google.android.gms.internal.ads.zzflv");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfly zzo(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzfly r4 = com.google.android.gms.internal.ads.zzfly.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeei.zzo(java.lang.String):com.google.android.gms.internal.ads.zzfly");
    }

    private static zzfmc zzp(String str) {
        if ("native".equals(str)) {
            return zzfmc.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfmc.JAVASCRIPT;
        }
        return zzfmc.NONE;
    }

    private static final Object zzq(zzeeh zzeeh) {
        try {
            return zzeeh.zza();
        } catch (RuntimeException e) {
            zzu.zzo().zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzr(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            zzu.zzo().zzv(e, "omid exception");
        }
    }

    public final zzeeo zza(String str, WebView webView, String str2, String str3, String str4, zzeel zzeel, zzeek zzeek, String str5) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzez)).booleanValue() || !zzflo.zzb()) {
            return null;
        }
        return (zzeeo) zzq(new zzedx("Google", str, "javascript", zzeek, str4, webView, str5, "", zzeel));
    }

    public final zzeeo zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzeel zzeel, zzeek zzeek, String str6) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzez)).booleanValue() || !zzflo.zzb()) {
            return null;
        }
        return (zzeeo) zzq(new zzeea(str5, str, "javascript", str4, zzeek, webView, str6, "", zzeel));
    }

    public final zzfmb zze(VersionInfoParcel versionInfoParcel, WebView webView, boolean z) {
        return (zzfmb) zzq(new zzeef(versionInfoParcel, webView, true));
    }

    public final String zzf(Context context) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzez)).booleanValue()) {
            return null;
        }
        return (String) zzq(new zzeed());
    }

    public final void zzg(zzflq zzflq, View view) {
        zzr(new zzedw(zzflq, view));
    }

    public final void zzh(zzfmb zzfmb, View view) {
        zzr(new zzeec(zzfmb, view));
    }

    public final void zzi(zzflq zzflq) {
        zzr(new zzeeg(zzflq));
    }

    public final void zzj(zzflq zzflq, View view) {
        zzr(new zzedy(zzflq, view));
    }

    public final void zzk(zzflq zzflq) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzez)).booleanValue() && zzflo.zzb()) {
            Objects.requireNonNull(zzflq);
            zzr(new zzedz(zzflq));
        }
    }

    public final boolean zzl(Context context) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzez)).booleanValue()) {
            zzm.zzj("Omid flag is disabled");
            return false;
        }
        Boolean bool = (Boolean) zzq(new zzeeb(context));
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public final void zzm(zzfmb zzfmb, zzcey zzcey) {
        zzr(new zzeee(zzfmb, zzcey));
    }
}
