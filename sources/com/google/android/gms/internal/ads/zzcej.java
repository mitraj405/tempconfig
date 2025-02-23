package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public interface zzcej extends zza, zzdeq, zzcea, zzbls, zzcfm, zzcfq, zzbme, zzaxw, zzcft, zzm, zzcfw, zzcfx, zzcbk, zzcfy {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    boolean isAttachedToWindow();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zzC(zzcfl zzcfl);

    zzfel zzD();

    Context zzE();

    View zzF();

    WebView zzG();

    WebViewClient zzH();

    zzauo zzI();

    zzazj zzJ();

    zzber zzK();

    com.google.android.gms.ads.internal.overlay.zzm zzL();

    com.google.android.gms.ads.internal.overlay.zzm zzM();

    zzcgb zzN();

    zzcgd zzO();

    zzeem zzP();

    zzeeo zzQ();

    zzfeo zzR();

    zzffk zzS();

    ListenableFuture zzT();

    String zzU();

    List zzV();

    void zzW(zzfel zzfel, zzfeo zzfeo);

    void zzX();

    void zzY();

    void zzZ(int i);

    void zzaA(String str, Predicate predicate);

    boolean zzaB();

    boolean zzaC();

    boolean zzaD(boolean z, int i);

    boolean zzaE();

    boolean zzaF();

    boolean zzaG();

    boolean zzaH();

    void zzaa();

    void zzab();

    void zzac(boolean z);

    void zzad();

    void zzae(String str, String str2, String str3);

    void zzaf();

    void zzag(String str, zzbix zzbix);

    void zzah();

    void zzai(com.google.android.gms.ads.internal.overlay.zzm zzm);

    void zzaj(zzcgd zzcgd);

    void zzak(zzazj zzazj);

    void zzal(boolean z);

    void zzam();

    void zzan(Context context);

    void zzao(boolean z);

    void zzap(zzbep zzbep);

    void zzaq(boolean z);

    void zzar(zzber zzber);

    void zzas(zzeem zzeem);

    void zzat(zzeeo zzeeo);

    void zzau(int i);

    void zzav(boolean z);

    void zzaw(com.google.android.gms.ads.internal.overlay.zzm zzm);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzaz(String str, zzbix zzbix);

    Activity zzi();

    com.google.android.gms.ads.internal.zza zzj();

    zzbcj zzm();

    VersionInfoParcel zzn();

    zzcfl zzq();

    void zzt(String str, zzccv zzccv);
}
