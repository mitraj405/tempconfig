package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzedt;
import com.google.android.gms.internal.ads.zzedu;
import com.google.android.gms.internal.ads.zzeem;
import com.google.android.gms.internal.ads.zzeeo;
import com.google.android.gms.internal.ads.zzfru;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzm extends zzbsm implements zzae {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcej zzd;
    zzi zze;
    zzs zzf;
    boolean zzg = false;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    boolean zzj = false;
    boolean zzk = false;
    zzh zzl;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private final View.OnClickListener zzp = new zzf(this);
    private Runnable zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt = false;
    private boolean zzu = false;
    private boolean zzv = true;
    private Toolbar zzw;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    private final void zzJ(View view) {
        zzeeo zzQ;
        zzeem zzP;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzeC)).booleanValue() || (zzP = this.zzd.zzP()) == null) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzeB)).booleanValue() && (zzQ = this.zzd.zzQ()) != null && zzQ.zzb()) {
                zzu.zzA().zzg(zzQ.zza(), view);
                return;
            }
            return;
        }
        zzP.zza(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzax)).booleanValue() != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzaw)).booleanValue() != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzK(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzc
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzk r0 = r0.zzo
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            android.app.Activity r3 = r5.zzb
            com.google.android.gms.ads.internal.util.zzab r4 = com.google.android.gms.ads.internal.zzu.zzq()
            boolean r6 = r4.zzd(r3, r6)
            boolean r3 = r5.zzk
            if (r3 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzax
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0048
        L_0x0033:
            if (r6 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzaw
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r0.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r1 = r2
            goto L_0x0057
        L_0x004a:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzc
            if (r6 == 0) goto L_0x0057
            com.google.android.gms.ads.internal.zzk r6 = r6.zzo
            if (r6 == 0) goto L_0x0057
            boolean r6 = r6.zzg
            if (r6 == 0) goto L_0x0057
            r2 = r1
        L_0x0057:
            android.app.Activity r6 = r5.zzb
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzaV
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0083
            android.view.View r6 = r6.getDecorView()
            if (r1 == 0) goto L_0x007d
            if (r2 == 0) goto L_0x007a
            r0 = 5894(0x1706, float:8.259E-42)
            goto L_0x007f
        L_0x007a:
            r0 = 5380(0x1504, float:7.539E-42)
            goto L_0x007f
        L_0x007d:
            r0 = 256(0x100, float:3.59E-43)
        L_0x007f:
            r6.setSystemUiVisibility(r0)
            return
        L_0x0083:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x009b
            r6.addFlags(r0)
            r6.clearFlags(r3)
            if (r2 == 0) goto L_0x009a
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
        L_0x009a:
            return
        L_0x009b:
            r6.addFlags(r3)
            r6.clearFlags(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzK(android.content.res.Configuration):void");
    }

    private static final void zzL(zzeeo zzeeo, View view) {
        if (zzeeo != null && view != null) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzeB)).booleanValue() || !zzeeo.zzb()) {
                zzu.zzA().zzj(zzeeo.zza(), view);
            }
        }
    }

    public final void zzA(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.zzc().zza(zzbbw.zzfq)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.zzc().zza(zzbbw.zzfr)).intValue()) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= ((Integer) zzba.zzc().zza(zzbbw.zzfs)).intValue()) {
                    if (i2 <= ((Integer) zzba.zzc().zza(zzbbw.zzft)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzu.zzo().zzv(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(-16777216);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzs = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[SYNTHETIC, Splitter:B:38:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0275  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzD(boolean r27) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            r26 = this;
            r1 = r26
            boolean r0 = r1.zzs
            r2 = 1
            if (r0 != 0) goto L_0x000c
            android.app.Activity r0 = r1.zzb
            r0.requestWindowFeature(r2)
        L_0x000c:
            android.app.Activity r0 = r1.zzb
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x02a4
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzc
            com.google.android.gms.internal.ads.zzcej r3 = r3.zzd
            r4 = 0
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzcgb r3 = r3.zzN()
            goto L_0x0021
        L_0x0020:
            r3 = r4
        L_0x0021:
            r5 = 0
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.zzP()
            if (r3 == 0) goto L_0x002c
            r3 = r2
            goto L_0x002d
        L_0x002c:
            r3 = r5
        L_0x002d:
            r1.zzm = r5
            if (r3 == 0) goto L_0x0064
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzc
            int r6 = r6.zzj
            r7 = 6
            if (r6 != r7) goto L_0x004c
            android.app.Activity r6 = r1.zzb
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 != r2) goto L_0x0048
            r6 = r2
            goto L_0x0049
        L_0x0048:
            r6 = r5
        L_0x0049:
            r1.zzm = r6
            goto L_0x0065
        L_0x004c:
            r7 = 7
            if (r6 != r7) goto L_0x0064
            android.app.Activity r6 = r1.zzb
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            r7 = 2
            if (r6 != r7) goto L_0x0060
            r6 = r2
            goto L_0x0061
        L_0x0060:
            r6 = r5
        L_0x0061:
            r1.zzm = r6
            goto L_0x0065
        L_0x0064:
            r6 = r5
        L_0x0065:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Delay onShow to next orientation change: "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zze(r6)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzc
            int r6 = r6.zzj
            r1.zzA(r6)
            r6 = 16777216(0x1000000, float:2.3509887E-38)
            r0.setFlags(r6, r6)
            java.lang.String r0 = "Hardware acceleration on the AdActivity window enabled."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)
            boolean r0 = r1.zzk
            if (r0 != 0) goto L_0x0093
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setBackgroundColor(r6)
            goto L_0x009a
        L_0x0093:
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            int r6 = zza
            r0.setBackgroundColor(r6)
        L_0x009a:
            android.app.Activity r0 = r1.zzb
            com.google.android.gms.ads.internal.overlay.zzh r6 = r1.zzl
            r0.setContentView(r6)
            r1.zzs = r2
            if (r27 == 0) goto L_0x016c
            com.google.android.gms.ads.internal.zzu.zzz()     // Catch:{ Exception -> 0x015e }
            android.app.Activity r6 = r1.zzb     // Catch:{ Exception -> 0x015e }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x015e }
            com.google.android.gms.internal.ads.zzcej r0 = r0.zzd     // Catch:{ Exception -> 0x015e }
            if (r0 == 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zzcgd r0 = r0.zzO()     // Catch:{ Exception -> 0x015e }
            r7 = r0
            goto L_0x00b7
        L_0x00b6:
            r7 = r4
        L_0x00b7:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x015e }
            com.google.android.gms.internal.ads.zzcej r0 = r0.zzd     // Catch:{ Exception -> 0x015e }
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = r0.zzU()     // Catch:{ Exception -> 0x015e }
            r8 = r0
            goto L_0x00c4
        L_0x00c3:
            r8 = r4
        L_0x00c4:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x015e }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r13 = r0.zzm     // Catch:{ Exception -> 0x015e }
            com.google.android.gms.internal.ads.zzcej r0 = r0.zzd     // Catch:{ Exception -> 0x015e }
            if (r0 == 0) goto L_0x00d3
            com.google.android.gms.ads.internal.zza r0 = r0.zzj()     // Catch:{ Exception -> 0x015e }
            r16 = r0
            goto L_0x00d5
        L_0x00d3:
            r16 = r4
        L_0x00d5:
            r9 = 1
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            com.google.android.gms.internal.ads.zzbav r17 = com.google.android.gms.internal.ads.zzbav.zza()     // Catch:{ Exception -> 0x015e }
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r10 = r3
            com.google.android.gms.internal.ads.zzcej r0 = com.google.android.gms.internal.ads.zzcew.zza(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x015e }
            r1.zzd = r0     // Catch:{ Exception -> 0x015e }
            com.google.android.gms.internal.ads.zzcgb r6 = r0.zzN()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzbhn r8 = r0.zzp
            com.google.android.gms.internal.ads.zzbhp r10 = r0.zze
            com.google.android.gms.ads.internal.overlay.zzaa r11 = r0.zzi
            com.google.android.gms.internal.ads.zzcej r0 = r0.zzd
            if (r0 == 0) goto L_0x0105
            com.google.android.gms.internal.ads.zzcgb r0 = r0.zzN()
            com.google.android.gms.ads.internal.zzb r4 = r0.zzd()
        L_0x0105:
            r14 = r4
            r7 = 0
            r9 = 0
            r12 = 1
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r6.zzR(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzd
            com.google.android.gms.internal.ads.zzcgb r0 = r0.zzN()
            com.google.android.gms.ads.internal.overlay.zze r4 = new com.google.android.gms.ads.internal.overlay.zze
            r4.<init>(r1)
            r0.zzB(r4)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r4 = r0.zzl
            if (r4 == 0) goto L_0x013c
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzd
            r0.loadUrl(r4)
            goto L_0x014c
        L_0x013c:
            java.lang.String r8 = r0.zzh
            if (r8 == 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzcej r6 = r1.zzd
            java.lang.String r7 = r0.zzf
            java.lang.String r9 = "text/html"
            java.lang.String r10 = "UTF-8"
            r11 = 0
            r6.loadDataWithBaseURL(r7, r8, r9, r10, r11)
        L_0x014c:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzcej r0 = r0.zzd
            if (r0 == 0) goto L_0x0177
            r0.zzaw(r1)
            goto L_0x0177
        L_0x0156:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "No URL or HTML to display in ad overlay."
            r0.<init>(r2)
            throw r0
        L_0x015e:
            r0 = move-exception
            java.lang.String r2 = "Error obtaining webview."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = "Could not obtain webview for the overlay."
            r2.<init>(r3, r0)
            throw r2
        L_0x016c:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzcej r0 = r0.zzd
            r1.zzd = r0
            android.app.Activity r4 = r1.zzb
            r0.zzan(r4)
        L_0x0177:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            boolean r0 = r0.zzw
            if (r0 == 0) goto L_0x018a
            android.webkit.CookieManager r0 = android.webkit.CookieManager.getInstance()
            com.google.android.gms.internal.ads.zzcej r4 = r1.zzd
            android.webkit.WebView r4 = r4.zzG()
            r0.setAcceptThirdPartyCookies(r4, r5)
        L_0x018a:
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzd
            r0.zzai(r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzcej r0 = r0.zzd
            if (r0 == 0) goto L_0x019e
            com.google.android.gms.internal.ads.zzeeo r0 = r0.zzQ()
            com.google.android.gms.ads.internal.overlay.zzh r4 = r1.zzl
            zzL(r0, r4)
        L_0x019e:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            int r0 = r0.zzk
            r4 = 5
            if (r0 == r4) goto L_0x0257
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzd
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x01bc
            boolean r6 = r0 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x01bc
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            com.google.android.gms.internal.ads.zzcej r6 = r1.zzd
            android.view.View r6 = r6.zzF()
            r0.removeView(r6)
        L_0x01bc:
            boolean r0 = r1.zzk
            if (r0 == 0) goto L_0x01c5
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzd
            r0.zzam()
        L_0x01c5:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            boolean r0 = r0.zzw
            r6 = -1
            if (r0 == 0) goto L_0x024c
            android.app.Activity r0 = r1.zzb
            android.widget.Toolbar r7 = new android.widget.Toolbar
            r7.<init>(r0)
            r1.zzw = r7
            int r0 = android.view.View.generateViewId()
            r7.setId(r0)
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzd
            android.view.View r0 = r0.zzF()
            int r7 = android.view.View.generateViewId()
            r0.setId(r7)
            android.widget.Toolbar r0 = r1.zzw
            r7 = -12303292(0xffffffffff444444, float:-2.6088314E38)
            r0.setBackgroundColor(r7)
            android.widget.Toolbar r0 = r1.zzw
            r0.setVisibility(r5)
            com.google.android.gms.internal.ads.zzbze r0 = com.google.android.gms.ads.internal.zzu.zzo()
            android.content.res.Resources r0 = r0.zze()
            int r7 = com.google.android.gms.ads.impl.R.drawable.admob_close_button_white_cross
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r7)
            android.widget.Toolbar r7 = r1.zzw
            r7.setNavigationIcon(r0)
            android.widget.Toolbar r0 = r1.zzw
            android.view.View$OnClickListener r7 = r1.zzp
            r0.setNavigationOnClickListener(r7)
            android.widget.Toolbar r0 = r1.zzw
            r0.setTitleMarginStart(r5)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r0.<init>(r6, r5)
            r7 = 10
            r0.addRule(r7)
            com.google.android.gms.ads.internal.overlay.zzh r7 = r1.zzl
            android.widget.Toolbar r8 = r1.zzw
            r7.addView(r8, r0)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r0.<init>(r6, r5)
            android.widget.Toolbar r5 = r1.zzw
            int r5 = r5.getId()
            r6 = 3
            r0.addRule(r6, r5)
            r5 = 12
            r0.addRule(r5)
            com.google.android.gms.ads.internal.overlay.zzh r5 = r1.zzl
            com.google.android.gms.internal.ads.zzcej r6 = r1.zzd
            android.view.View r6 = r6.zzF()
            r5.addView(r6, r0)
            android.widget.Toolbar r0 = r1.zzw
            r1.zzJ(r0)
            goto L_0x0257
        L_0x024c:
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            com.google.android.gms.internal.ads.zzcej r5 = r1.zzd
            android.view.View r5 = r5.zzF()
            r0.addView(r5, r6, r6)
        L_0x0257:
            if (r27 != 0) goto L_0x0260
            boolean r0 = r1.zzm
            if (r0 != 0) goto L_0x0260
            r26.zze()
        L_0x0260:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            int r0 = r0.zzk
            if (r0 == r4) goto L_0x0275
            r1.zzw(r3)
            com.google.android.gms.internal.ads.zzcej r0 = r1.zzd
            boolean r0 = r0.zzaB()
            if (r0 == 0) goto L_0x0274
            r1.zzy(r3, r2)
        L_0x0274:
            return
        L_0x0275:
            android.app.Activity r0 = r1.zzb
            com.google.android.gms.internal.ads.zzedt r2 = com.google.android.gms.internal.ads.zzedu.zze()
            r2.zza(r0)
            r2.zzb(r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r0 = r0.zzq
            r2.zzc(r0)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r0 = r0.zzr
            r2.zzd(r0)
            com.google.android.gms.internal.ads.zzedu r0 = r2.zze()
            r1.zzf(r0)     // Catch:{ zzg -> 0x0299, RemoteException -> 0x0297 }
            return
        L_0x0297:
            r0 = move-exception
            goto L_0x029a
        L_0x0299:
            r0 = move-exception
        L_0x029a:
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x02a4:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "Invalid activity, no window available."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzD(boolean):void");
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzr = true;
            Runnable runnable = this.zzq;
            if (runnable != null) {
                zzfru zzfru = zzt.zza;
                zzfru.removeCallbacks(runnable);
                zzfru.post(this.zzq);
            }
        }
    }

    public final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzp zzp2;
        if (this.zzb.isFinishing() && !this.zzt) {
            this.zzt = true;
            zzcej zzcej = this.zzd;
            if (zzcej != null) {
                zzcej.zzZ(this.zzn - 1);
                synchronized (this.zzo) {
                    if (!this.zzr && this.zzd.zzaC()) {
                        if (((Boolean) zzba.zzc().zza(zzbbw.zzen)).booleanValue() && !this.zzu && (adOverlayInfoParcel = this.zzc) != null && (zzp2 = adOverlayInfoParcel.zzc) != null) {
                            zzp2.zzdq();
                        }
                        zzd zzd2 = new zzd(this);
                        this.zzq = zzd2;
                        zzt.zza.postDelayed(zzd2, ((Long) zzba.zzc().zza(zzbbw.zzaO)).longValue());
                        return;
                    }
                }
            }
            zzc();
        }
    }

    public final void zzG(String str) {
        Toolbar toolbar = this.zzw;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzia)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzaH = this.zzd.zzaH();
            if (!zzaH) {
                this.zzd.zzd("onbackblocked", Collections.emptyMap());
            }
            return zzaH;
        }
        this.zzd.goBack();
        return false;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    public final void zzc() {
        zzcej zzcej;
        zzp zzp2;
        if (!this.zzu) {
            this.zzu = true;
            zzcej zzcej2 = this.zzd;
            if (zzcej2 != null) {
                this.zzl.removeView(zzcej2.zzF());
                zzi zzi2 = this.zze;
                if (zzi2 != null) {
                    this.zzd.zzan(zzi2.zzd);
                    this.zzd.zzaq(false);
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzlJ)).booleanValue() && this.zzd.getParent() != null) {
                        ((ViewGroup) this.zzd.getParent()).removeView(this.zzd.zzF());
                    }
                    ViewGroup viewGroup = this.zze.zzc;
                    View zzF = this.zzd.zzF();
                    zzi zzi3 = this.zze;
                    viewGroup.addView(zzF, zzi3.zza, zzi3.zzb);
                    this.zze = null;
                } else if (this.zzb.getApplicationContext() != null) {
                    this.zzd.zzan(this.zzb.getApplicationContext());
                }
                this.zzd = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
                zzp2.zzdu(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzcej = adOverlayInfoParcel2.zzd) != null) {
                zzL(zzcej.zzQ(), this.zzc.zzd.zzF());
            }
        }
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    public final void zze() {
        this.zzd.zzaa();
    }

    public final void zzf(zzedu zzedu) throws zzg, RemoteException {
        zzbsg zzbsg;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbsg = adOverlayInfoParcel.zzv) == null) {
            throw new zzg("noioou");
        }
        zzbsg.zzg(ObjectWrapper.wrap(zzedu));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzs = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzi() {
        this.zzn = 1;
    }

    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzK((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A[Catch:{ zzg -> 0x0116 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e5 A[Catch:{ zzg -> 0x0116 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010a A[Catch:{ zzg -> 0x0116 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzl(android.os.Bundle r9) {
        /*
            r8 = this;
            boolean r0 = r8.zzs
            r1 = 1
            if (r0 != 0) goto L_0x000a
            android.app.Activity r0 = r8.zzb
            r0.requestWindowFeature(r1)
        L_0x000a:
            r0 = 0
            if (r9 == 0) goto L_0x0017
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r9.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0017
            r2 = r1
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            r8.zzj = r2
            r2 = 4
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0116 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzg -> 0x0116 }
            r8.zzc = r3     // Catch:{ zzg -> 0x0116 }
            if (r3 == 0) goto L_0x010e
            boolean r3 = r3.zzw     // Catch:{ zzg -> 0x0116 }
            if (r3 == 0) goto L_0x0044
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ zzg -> 0x0116 }
            r4 = 28
            if (r3 < r4) goto L_0x0039
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0116 }
            r3.setShowWhenLocked(r1)     // Catch:{ zzg -> 0x0116 }
            goto L_0x0044
        L_0x0039:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0116 }
            android.view.Window r3 = r3.getWindow()     // Catch:{ zzg -> 0x0116 }
            r4 = 524288(0x80000, float:7.34684E-40)
            r3.addFlags(r4)     // Catch:{ zzg -> 0x0116 }
        L_0x0044:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r3.zzm     // Catch:{ zzg -> 0x0116 }
            int r3 = r3.clientJarVersion     // Catch:{ zzg -> 0x0116 }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x0051
            r8.zzn = r2     // Catch:{ zzg -> 0x0116 }
        L_0x0051:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0116 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0116 }
            if (r3 == 0) goto L_0x0067
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0116 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0116 }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzg -> 0x0116 }
            r8.zzv = r3     // Catch:{ zzg -> 0x0116 }
        L_0x0067:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.zzk r4 = r3.zzo     // Catch:{ zzg -> 0x0116 }
            r5 = 5
            if (r4 == 0) goto L_0x0075
            boolean r6 = r4.zza     // Catch:{ zzg -> 0x0116 }
            r8.zzk = r6     // Catch:{ zzg -> 0x0116 }
            if (r6 == 0) goto L_0x0090
            goto L_0x007b
        L_0x0075:
            int r6 = r3.zzk     // Catch:{ zzg -> 0x0116 }
            if (r6 != r5) goto L_0x008e
            r8.zzk = r1     // Catch:{ zzg -> 0x0116 }
        L_0x007b:
            int r3 = r3.zzk     // Catch:{ zzg -> 0x0116 }
            if (r3 == r5) goto L_0x0090
            int r3 = r4.zzf     // Catch:{ zzg -> 0x0116 }
            r4 = -1
            if (r3 == r4) goto L_0x0090
            com.google.android.gms.ads.internal.overlay.zzl r3 = new com.google.android.gms.ads.internal.overlay.zzl     // Catch:{ zzg -> 0x0116 }
            r4 = 0
            r3.<init>(r8, r4)     // Catch:{ zzg -> 0x0116 }
            r3.zzb()     // Catch:{ zzg -> 0x0116 }
            goto L_0x0090
        L_0x008e:
            r8.zzk = r0     // Catch:{ zzg -> 0x0116 }
        L_0x0090:
            if (r9 != 0) goto L_0x00be
            boolean r9 = r8.zzv     // Catch:{ zzg -> 0x0116 }
            if (r9 == 0) goto L_0x00a8
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.internal.ads.zzcxd r9 = r9.zzt     // Catch:{ zzg -> 0x0116 }
            if (r9 == 0) goto L_0x009f
            r9.zze()     // Catch:{ zzg -> 0x0116 }
        L_0x009f:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.overlay.zzp r9 = r9.zzc     // Catch:{ zzg -> 0x0116 }
            if (r9 == 0) goto L_0x00a8
            r9.zzdr()     // Catch:{ zzg -> 0x0116 }
        L_0x00a8:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            int r3 = r9.zzk     // Catch:{ zzg -> 0x0116 }
            if (r3 == r1) goto L_0x00be
            com.google.android.gms.ads.internal.client.zza r9 = r9.zzb     // Catch:{ zzg -> 0x0116 }
            if (r9 == 0) goto L_0x00b5
            r9.onAdClicked()     // Catch:{ zzg -> 0x0116 }
        L_0x00b5:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.internal.ads.zzdeq r9 = r9.zzu     // Catch:{ zzg -> 0x0116 }
            if (r9 == 0) goto L_0x00be
            r9.zzdG()     // Catch:{ zzg -> 0x0116 }
        L_0x00be:
            com.google.android.gms.ads.internal.overlay.zzh r9 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzg -> 0x0116 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            java.lang.String r6 = r4.zzn     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r7 = r4.zzm     // Catch:{ zzg -> 0x0116 }
            java.lang.String r7 = r7.afmaVersion     // Catch:{ zzg -> 0x0116 }
            java.lang.String r4 = r4.zzs     // Catch:{ zzg -> 0x0116 }
            r9.<init>(r3, r6, r7, r4)     // Catch:{ zzg -> 0x0116 }
            r8.zzl = r9     // Catch:{ zzg -> 0x0116 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9.setId(r3)     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.util.zzab r9 = com.google.android.gms.ads.internal.zzu.zzq()     // Catch:{ zzg -> 0x0116 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzg -> 0x0116 }
            r9.zzk(r3)     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzg -> 0x0116 }
            int r3 = r9.zzk     // Catch:{ zzg -> 0x0116 }
            if (r3 == r1) goto L_0x010a
            r4 = 2
            if (r3 == r4) goto L_0x00fd
            r9 = 3
            if (r3 == r9) goto L_0x00f9
            if (r3 != r5) goto L_0x00f1
            r8.zzD(r0)     // Catch:{ zzg -> 0x0116 }
            return
        L_0x00f1:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x0116 }
            java.lang.String r0 = "Could not determine ad overlay type."
            r9.<init>(r0)     // Catch:{ zzg -> 0x0116 }
            throw r9     // Catch:{ zzg -> 0x0116 }
        L_0x00f9:
            r8.zzD(r1)     // Catch:{ zzg -> 0x0116 }
            return
        L_0x00fd:
            com.google.android.gms.ads.internal.overlay.zzi r1 = new com.google.android.gms.ads.internal.overlay.zzi     // Catch:{ zzg -> 0x0116 }
            com.google.android.gms.internal.ads.zzcej r9 = r9.zzd     // Catch:{ zzg -> 0x0116 }
            r1.<init>(r9)     // Catch:{ zzg -> 0x0116 }
            r8.zze = r1     // Catch:{ zzg -> 0x0116 }
            r8.zzD(r0)     // Catch:{ zzg -> 0x0116 }
            return
        L_0x010a:
            r8.zzD(r0)     // Catch:{ zzg -> 0x0116 }
            return
        L_0x010e:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x0116 }
            java.lang.String r0 = "Could not get info for ad overlay."
            r9.<init>(r0)     // Catch:{ zzg -> 0x0116 }
            throw r9     // Catch:{ zzg -> 0x0116 }
        L_0x0116:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r9)
            r8.zzn = r2
            android.app.Activity r9 = r8.zzb
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzl(android.os.Bundle):void");
    }

    public final void zzm() {
        zzcej zzcej = this.zzd;
        if (zzcej != null) {
            try {
                this.zzl.removeView(zzcej.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    public final void zzo() {
        zzp zzp2;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
            zzp2.zzdk();
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzep)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzp(int i, String[] strArr, int[] iArr) {
        zzm zzm2;
        if (i == 12345) {
            Activity activity = this.zzb;
            zzedt zze2 = zzedu.zze();
            zze2.zza(activity);
            if (this.zzc.zzk == 5) {
                zzm2 = this;
            } else {
                zzm2 = null;
            }
            zze2.zzb(zzm2);
            try {
                this.zzc.zzv.zzf(strArr, iArr, ObjectWrapper.wrap(zze2.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    public final void zzr() {
        zzp zzp2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
            zzp2.zzdH();
        }
        zzK(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzep)).booleanValue()) {
            zzcej zzcej = this.zzd;
            if (zzcej == null || zzcej.zzaE()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzt() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzep)).booleanValue()) {
            zzcej zzcej = this.zzd;
            if (zzcej == null || zzcej.zzaE()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzu() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzep)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzv() {
        zzp zzp2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzp2 = adOverlayInfoParcel.zzc) != null) {
            zzp2.zzdt();
        }
    }

    public final void zzw(boolean z) {
        boolean z2;
        int i;
        int i2;
        if (!this.zzc.zzw) {
            int intValue = ((Integer) zzba.zzc().zza(zzbbw.zzes)).intValue();
            int i3 = 0;
            if (((Boolean) zzba.zzc().zza(zzbbw.zzaR)).booleanValue() || z) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzr zzr2 = new zzr();
            zzr2.zzd = 50;
            if (true != z2) {
                i = 0;
            } else {
                i = intValue;
            }
            zzr2.zza = i;
            if (true != z2) {
                i3 = intValue;
            }
            zzr2.zzb = i3;
            zzr2.zzc = intValue;
            this.zzf = new zzs(this.zzb, zzr2, this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            if (true != z2) {
                i2 = 9;
            } else {
                i2 = 11;
            }
            layoutParams.addRule(i2);
            zzy(z, this.zzc.zzg);
            this.zzl.addView(this.zzf, layoutParams);
            zzJ(this.zzf);
        }
    }

    public final void zzx() {
        this.zzs = true;
    }

    public final void zzy(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzk zzk2;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzk zzk3;
        boolean z5 = true;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzaP)).booleanValue() || (adOverlayInfoParcel2 = this.zzc) == null || (zzk3 = adOverlayInfoParcel2.zzo) == null || !zzk3.zzh) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzaQ)).booleanValue() || (adOverlayInfoParcel = this.zzc) == null || (zzk2 = adOverlayInfoParcel.zzo) == null || !zzk2.zzi) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z && z2 && z3 && !z4) {
            new zzbrq(this.zzd, "useCustomClose").zzh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzs zzs2 = this.zzf;
        if (zzs2 != null) {
            if (!z4 && (!z2 || z3)) {
                z5 = false;
            }
            zzs2.zzb(z5);
        }
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }

    public final void zzq() {
    }

    public final void zzh(int i, int i2, Intent intent) {
    }
}
