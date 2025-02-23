package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdkv {
    private final zzdpl zza;
    private final zzdoa zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdkv(zzdpl zzdpl, zzdoa zzdoa) {
        this.zza = zzdpl;
        this.zzb = zzdoa;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzay.zzb();
        return zzf.zzy(context, i);
    }

    public final View zza(View view, WindowManager windowManager) throws zzcev {
        zzcej zza2 = this.zza.zza(zzq.zzc(), (zzfel) null, (zzfeo) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzag("/sendMessageToSdk", new zzdkp(this));
        zza2.zzag("/hideValidatorOverlay", new zzdkq(this, windowManager, view));
        zza2.zzag("/open", new zzbjj((zzb) null, (zzbrk) null, (zzedh) null, (zzdsk) null, (zzcni) null));
        this.zzb.zzm(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdkr(this, view, windowManager));
        this.zzb.zzm(new WeakReference(zza2), "/showValidatorOverlay", new zzdks());
        return (View) zza2;
    }

    public final /* synthetic */ void zzb(zzcej zzcej, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcej zzcej, Map map) {
        zzm.zze("Hide native ad policy validator overlay.");
        zzcej.zzF().setVisibility(8);
        if (zzcej.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcej.zzF());
        }
        zzcej.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put(FacebookMediationAdapter.KEY_ID, (String) map.get(FacebookMediationAdapter.KEY_ID));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    public final /* synthetic */ void zze(View view, WindowManager windowManager, zzcej zzcej, Map map) {
        int i;
        zzcej.zzN().zzB(new zzdku(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzba.zzc().zza(zzbbw.zzhl)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzba.zzc().zza(zzbbw.zzhm)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzcej.zzaj(zzcgd.zzb(zzf, zzf2));
            try {
                zzcej.zzG().getSettings().setUseWideViewPort(((Boolean) zzba.zzc().zza(zzbbw.zzhn)).booleanValue());
                zzcej.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzba.zzc().zza(zzbbw.zzho)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzb2 = zzbv.zzb();
            zzb2.x = zzf3;
            zzb2.y = zzf4;
            windowManager.updateViewLayout(zzcej.zzF(), zzb2);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if (C0515Ga.AVLBLTY_ONLY.equals(str) || C0515Ga.FARE_ONLY.equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.zzc = new zzdkt(view, zzcej, str, zzb2, i - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzcej.loadUrl(str2);
            }
        }
    }
}
