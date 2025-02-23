package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdx;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class TaggingLibraryJsInterface {
    private final Context zza;
    /* access modifiers changed from: private */
    public final WebView zzb;
    private final zzauo zzc;
    private final zzffk zzd;
    private final int zze;
    private final zzdsp zzf;
    private final boolean zzg;
    /* access modifiers changed from: private */
    public final zzgcu zzh = zzbzo.zze;
    private final zzfll zzi;
    private final zze zzj;

    public TaggingLibraryJsInterface(WebView webView, zzauo zzauo, zzdsp zzdsp, zzfll zzfll, zzffk zzffk, zze zze2) {
        this.zzb = webView;
        Context context = webView.getContext();
        this.zza = context;
        this.zzc = zzauo;
        this.zzf = zzdsp;
        zzbbw.zza(context);
        this.zze = ((Integer) zzba.zzc().zza(zzbbw.zziI)).intValue();
        this.zzg = ((Boolean) zzba.zzc().zza(zzbbw.zziJ)).booleanValue();
        this.zzi = zzfll;
        this.zzd = zzffk;
        this.zzj = zze2;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getClickSignals(String str) {
        try {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            String zze2 = this.zzc.zzc().zze(this.zza, str, this.zzb);
            if (this.zzg) {
                long currentTimeMillis2 = zzu.zzB().currentTimeMillis() - currentTimeMillis;
                zzq.zzd(this.zzf, (zzdsf) null, "csg", new Pair("clat", String.valueOf(currentTimeMillis2)));
            }
            return zze2;
        } catch (RuntimeException e) {
            zzm.zzh("Exception getting click signals. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getClickSignalsWithTimeout(String str, int i) {
        if (i <= 0) {
            zzm.zzg("Invalid timeout for getting click signals. Timeout=" + i);
            return "";
        }
        int min = Math.min(i, this.zze);
        try {
            return (String) zzbzo.zza.zzb(new zzbb(this, str)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzm.zzh("Exception getting click signals with timeout. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getQueryInfo() {
        zzu.zzp();
        String uuid = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        zzbf zzbf = new zzbf(this, uuid);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            this.zzj.zzg(this.zzb, zzbf);
        } else {
            if (((Boolean) zzba.zzc().zza(zzbbw.zziL)).booleanValue()) {
                this.zzh.execute(new zzbc(this, bundle, zzbf));
            } else {
                QueryInfo.generate(this.zza, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), zzbf);
            }
        }
        return uuid;
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getViewSignals() {
        try {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            String zzh2 = this.zzc.zzc().zzh(this.zza, this.zzb, (Activity) null);
            if (this.zzg) {
                long currentTimeMillis2 = zzu.zzB().currentTimeMillis() - currentTimeMillis;
                zzq.zzd(this.zzf, (zzdsf) null, "vsg", new Pair("vlat", String.valueOf(currentTimeMillis2)));
            }
            return zzh2;
        } catch (RuntimeException e) {
            zzm.zzh("Exception getting view signals. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public String getViewSignalsWithTimeout(int i) {
        if (i <= 0) {
            zzm.zzg("Invalid timeout for getting view signals. Timeout=" + i);
            return "";
        }
        int min = Math.min(i, this.zze);
        try {
            return (String) zzbzo.zza.zzb(new zzaz(this)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzm.zzh("Exception getting view signals with timeout. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public void recordClick(String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zziN)).booleanValue() && !TextUtils.isEmpty(str)) {
            zzbzo.zza.execute(new zzba(this, str));
        }
    }

    @JavascriptInterface
    @TargetApi(21)
    @KeepForSdk
    public void reportTouchEvent(String str) {
        int i;
        int i2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("x");
            int i4 = jSONObject.getInt("y");
            int i5 = jSONObject.getInt("duration_ms");
            float f = (float) jSONObject.getDouble("force");
            int i6 = jSONObject.getInt("type");
            if (i6 != 0) {
                int i7 = 1;
                if (i6 != 1) {
                    i7 = 2;
                    if (i6 != 2) {
                        i7 = 3;
                        if (i6 != 3) {
                            i2 = -1;
                        }
                    }
                }
                i = i7;
                this.zzc.zzd(MotionEvent.obtain(0, (long) i5, i, (float) i3, (float) i4, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            }
            i2 = 0;
            i = i2;
            try {
                this.zzc.zzd(MotionEvent.obtain(0, (long) i5, i, (float) i3, (float) i4, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException | JSONException e) {
                e = e;
                zzm.zzh("Failed to parse the touch string. ", e);
                zzu.zzo().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException | JSONException e2) {
            e = e2;
            zzm.zzh("Failed to parse the touch string. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
        }
    }

    public final /* synthetic */ void zzc(Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        boolean z;
        CookieManager zza2 = zzu.zzq().zza(this.zza);
        if (zza2 != null) {
            z = zza2.acceptThirdPartyCookies(this.zzb);
        } else {
            z = false;
        }
        bundle.putBoolean("accept_3p_cookie", z);
        QueryInfo.generate(this.zza, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), queryInfoGenerationCallback);
    }

    public final /* synthetic */ void zzd(String str) {
        zzffk zzffk;
        Uri parse = Uri.parse(str);
        try {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzla)).booleanValue() || (zzffk = this.zzd) == null) {
                parse = this.zzc.zza(parse, this.zza, this.zzb, (Activity) null);
            } else {
                parse = zzffk.zza(parse, this.zza, this.zzb, (Activity) null);
            }
        } catch (zzaup e) {
            zzm.zzf("Failed to append the click signal to URL: ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.recordClick");
        }
        this.zzi.zzc(parse.toString(), (zzfkf) null);
    }
}
