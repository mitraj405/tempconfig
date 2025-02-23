package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdx;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzbtl;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzdoa;
import com.google.android.gms.internal.ads.zzdrt;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzfgf;
import com.google.android.gms.internal.ads.zzfjt;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzgca;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzak extends zzbyl {
    protected static final List zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click", "/dbm/clk"}));
    protected static final List zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"}));
    protected static final List zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    /* access modifiers changed from: private */
    public final String zzA;
    private final List zzB;
    private final List zzC;
    private final List zzD;
    private final List zzE;
    private final AtomicBoolean zzF = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean zzG = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicInteger zzH = new AtomicInteger(0);
    private final zzbcx zzI;
    private final zze zzJ;
    private final zzcgj zzf;
    /* access modifiers changed from: private */
    public Context zzg;
    private final zzauo zzh;
    private final zzffk zzi;
    private final zzfgf zzj;
    private final zzgcu zzk;
    private final ScheduledExecutorService zzl;
    private zzbtl zzm;
    private Point zzn = new Point();
    private Point zzo = new Point();
    /* access modifiers changed from: private */
    public final zzdsp zzp;
    /* access modifiers changed from: private */
    public final zzfll zzq;
    /* access modifiers changed from: private */
    public final boolean zzr;
    /* access modifiers changed from: private */
    public final boolean zzs;
    /* access modifiers changed from: private */
    public final boolean zzt;
    /* access modifiers changed from: private */
    public final boolean zzu;
    /* access modifiers changed from: private */
    public final String zzv;
    /* access modifiers changed from: private */
    public final String zzw;
    /* access modifiers changed from: private */
    public final AtomicInteger zzx = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzy;
    /* access modifiers changed from: private */
    public String zzz;

    public zzak(zzcgj zzcgj, Context context, zzauo zzauo, zzfgf zzfgf, zzgcu zzgcu, ScheduledExecutorService scheduledExecutorService, zzdsp zzdsp, zzfll zzfll, VersionInfoParcel versionInfoParcel, zzbcx zzbcx, zzffk zzffk, zze zze2) {
        List list;
        this.zzf = zzcgj;
        this.zzg = context;
        this.zzh = zzauo;
        this.zzi = zzffk;
        this.zzj = zzfgf;
        this.zzk = zzgcu;
        this.zzl = scheduledExecutorService;
        this.zzp = zzdsp;
        this.zzq = zzfll;
        this.zzy = versionInfoParcel;
        this.zzI = zzbcx;
        this.zzr = ((Boolean) zzba.zzc().zza(zzbbw.zzgx)).booleanValue();
        this.zzs = ((Boolean) zzba.zzc().zza(zzbbw.zzgw)).booleanValue();
        this.zzt = ((Boolean) zzba.zzc().zza(zzbbw.zzgz)).booleanValue();
        this.zzu = ((Boolean) zzba.zzc().zza(zzbbw.zzgB)).booleanValue();
        this.zzv = (String) zzba.zzc().zza(zzbbw.zzgA);
        this.zzw = (String) zzba.zzc().zza(zzbbw.zzgC);
        this.zzA = (String) zzba.zzc().zza(zzbbw.zzgD);
        this.zzJ = zze2;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgE)).booleanValue()) {
            this.zzB = zzaa((String) zzba.zzc().zza(zzbbw.zzgF));
            this.zzC = zzaa((String) zzba.zzc().zza(zzbbw.zzgG));
            this.zzD = zzaa((String) zzba.zzc().zza(zzbbw.zzgH));
            list = zzaa((String) zzba.zzc().zza(zzbbw.zzgI));
        } else {
            this.zzB = zza;
            this.zzC = zzb;
            this.zzD = zzc;
            list = zzd;
        }
        this.zzE = list;
    }

    public static /* bridge */ /* synthetic */ void zzH(zzak zzak, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzak.zzO((Uri) it.next())) {
                zzak.zzx.getAndIncrement();
                return;
            }
        }
    }

    public static final /* synthetic */ Uri zzQ(Uri uri, String str) {
        if (!TextUtils.isEmpty(str)) {
            return zzZ(uri, "nas", str);
        }
        return uri;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzs zzR(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.google.android.gms.ads.internal.client.zzq r11, com.google.android.gms.ads.internal.client.zzl r12, android.os.Bundle r13) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzffe r0 = new com.google.android.gms.internal.ads.zzffe
            r0.<init>()
            java.lang.String r1 = "REWARDED"
            boolean r2 = r1.equals(r10)
            java.lang.String r3 = "REWARDED_INTERSTITIAL"
            r4 = 3
            r5 = 2
            if (r2 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzfer r2 = r0.zzp()
            r2.zza(r5)
            goto L_0x0026
        L_0x0019:
            boolean r2 = r3.equals(r10)
            if (r2 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzfer r2 = r0.zzp()
            r2.zza(r4)
        L_0x0026:
            com.google.android.gms.internal.ads.zzcgj r2 = r7.zzf
            com.google.android.gms.ads.nonagon.signalgeneration.zzr r2 = r2.zzp()
            com.google.android.gms.internal.ads.zzcvy r6 = new com.google.android.gms.internal.ads.zzcvy
            r6.<init>()
            r6.zze(r8)
            if (r9 != 0) goto L_0x0038
            java.lang.String r9 = "adUnitId"
        L_0x0038:
            r0.zzt(r9)
            if (r12 != 0) goto L_0x0046
            com.google.android.gms.ads.internal.client.zzm r9 = new com.google.android.gms.ads.internal.client.zzm
            r9.<init>()
            com.google.android.gms.ads.internal.client.zzl r12 = r9.zza()
        L_0x0046:
            r0.zzH(r12)
            r9 = 1
            if (r11 != 0) goto L_0x00aa
            int r11 = r10.hashCode()
            r12 = 4
            switch(r11) {
                case -1999289321: goto L_0x0079;
                case -428325382: goto L_0x006f;
                case 543046670: goto L_0x0067;
                case 1854800829: goto L_0x005f;
                case 1951953708: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0083
        L_0x0055:
            java.lang.String r11 = "BANNER"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = 0
            goto L_0x0084
        L_0x005f:
            boolean r11 = r10.equals(r3)
            if (r11 == 0) goto L_0x0083
            r11 = r5
            goto L_0x0084
        L_0x0067:
            boolean r11 = r10.equals(r1)
            if (r11 == 0) goto L_0x0083
            r11 = r9
            goto L_0x0084
        L_0x006f:
            java.lang.String r11 = "APP_OPEN_AD"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = r12
            goto L_0x0084
        L_0x0079:
            java.lang.String r11 = "NATIVE"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = r4
            goto L_0x0084
        L_0x0083:
            r11 = -1
        L_0x0084:
            if (r11 == 0) goto L_0x00a3
            if (r11 == r9) goto L_0x009e
            if (r11 == r5) goto L_0x009e
            if (r11 == r4) goto L_0x0099
            if (r11 == r12) goto L_0x0094
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            r11.<init>()
            goto L_0x00aa
        L_0x0094:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzb()
            goto L_0x00aa
        L_0x0099:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzc()
            goto L_0x00aa
        L_0x009e:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzd()
            goto L_0x00aa
        L_0x00a3:
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.AdSize.BANNER
            r11.<init>((android.content.Context) r8, (com.google.android.gms.ads.AdSize) r12)
        L_0x00aa:
            r0.zzs(r11)
            r0.zzz(r9)
            r0.zzA(r13)
            com.google.android.gms.internal.ads.zzffg r8 = r0.zzJ()
            r6.zzi(r8)
            com.google.android.gms.internal.ads.zzcwa r8 = r6.zzj()
            r2.zza(r8)
            com.google.android.gms.ads.nonagon.signalgeneration.zzan r8 = new com.google.android.gms.ads.nonagon.signalgeneration.zzan
            r8.<init>()
            r8.zza(r10)
            com.google.android.gms.ads.nonagon.signalgeneration.zzap r9 = new com.google.android.gms.ads.nonagon.signalgeneration.zzap
            r10 = 0
            r9.<init>(r8, r10)
            r2.zzb(r9)
            com.google.android.gms.internal.ads.zzdci r8 = new com.google.android.gms.internal.ads.zzdci
            r8.<init>()
            com.google.android.gms.ads.nonagon.signalgeneration.zzs r8 = r2.zzc()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzak.zzR(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.ads.internal.client.zzl, android.os.Bundle):com.google.android.gms.ads.nonagon.signalgeneration.zzs");
    }

    private final ListenableFuture zzS(String str) {
        zzdoa[] zzdoaArr = new zzdoa[1];
        ListenableFuture zzn2 = zzgcj.zzn(this.zzj.zza(), new zzv(this, zzdoaArr, str), this.zzk);
        zzn2.addListener(new zzw(this, zzdoaArr), this.zzk);
        return zzgcj.zze(zzgcj.zzm((zzgca) zzgcj.zzo(zzgca.zzu(zzn2), (long) ((Integer) zzba.zzc().zza(zzbbw.zzgP)).intValue(), TimeUnit.MILLISECONDS, this.zzl), new zzac(), this.zzk), Exception.class, new zzad(), this.zzk);
    }

    /* access modifiers changed from: private */
    public final void zzT() {
        ListenableFuture listenableFuture;
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            this.zzJ.zzb();
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkg)).booleanValue()) {
            listenableFuture = zzgcj.zzk(new zzt(this), zzbzo.zza);
        } else {
            listenableFuture = zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null, new Bundle()).zzb();
        }
        zzgcj.zzr(listenableFuture, new zzaj(this), this.zzf.zzB());
    }

    private final void zzU() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zziH)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zziK)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbbw.zziO)).booleanValue() || !this.zzF.getAndSet(true)) {
                    zzT();
                }
            }
        }
    }

    private final void zzV(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc, boolean z) {
        ListenableFuture listenableFuture;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            zzm.zzj("The updating URL feature is not enabled.");
            try {
                zzbtc.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
        } else {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (zzO((Uri) it.next())) {
                    i++;
                }
            }
            if (i > 1) {
                zzm.zzj("Multiple google urls found: ".concat(String.valueOf(list)));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uri = (Uri) it2.next();
                if (!zzO(uri)) {
                    zzm.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                    listenableFuture = zzgcj.zzh(uri);
                } else {
                    listenableFuture = this.zzk.zzb(new zzx(this, uri, iObjectWrapper));
                    if (zzY()) {
                        listenableFuture = zzgcj.zzn(listenableFuture, new zzy(this), this.zzk);
                    } else {
                        zzm.zzi("Asset view map is empty.");
                    }
                }
                arrayList.add(listenableFuture);
            }
            zzgcj.zzr(zzgcj.zzd(arrayList), new zzai(this, zzbtc, z), this.zzf.zzB());
        }
    }

    private final void zzW(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc, boolean z) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            try {
                zzbtc.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
        } else {
            ListenableFuture zzb2 = this.zzk.zzb(new zzae(this, list, iObjectWrapper));
            if (zzY()) {
                zzb2 = zzgcj.zzn(zzb2, new zzaf(this), this.zzk);
            } else {
                zzm.zzi("Asset view map is empty.");
            }
            zzgcj.zzr(zzb2, new zzah(this, zzbtc, z), this.zzf.zzB());
        }
    }

    private static boolean zzX(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final boolean zzY() {
        Map map;
        zzbtl zzbtl = this.zzm;
        if (zzbtl == null || (map = zzbtl.zzb) == null || map.isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final Uri zzZ(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    private static final List zzaa(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfvj.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static /* bridge */ /* synthetic */ zzfkf zzr(ListenableFuture listenableFuture, zzbyq zzbyq) {
        String str;
        if (!zzfki.zza() || !((Boolean) zzbdl.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfkf zza2 = ((zzs) zzgcj.zzp(listenableFuture)).zza();
            zza2.zzd(new ArrayList(Collections.singletonList(zzbyq.zzb)));
            zzl zzl2 = zzbyq.zzd;
            if (zzl2 == null) {
                str = "";
            } else {
                str = zzl2.zzp;
            }
            zza2.zzb(str);
            zza2.zzf(zzbyq.zzd.zzm);
            return zza2;
        } catch (ExecutionException e) {
            zzu.zzo().zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    public final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzP(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzZ(uri, "nas", str));
            }
        }
        return arrayList;
    }

    public final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String str;
        if (this.zzh.zzc() != null) {
            str = this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzP(uri)) {
                    zzm.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzZ(uri, "ms", str));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    public final /* synthetic */ void zzJ(zzdoa[] zzdoaArr) {
        zzdoa zzdoa = zzdoaArr[0];
        if (zzdoa != null) {
            this.zzj.zzb(zzgcj.zzh(zzdoa));
        }
    }

    public final boolean zzO(Uri uri) {
        return zzX(uri, this.zzB, this.zzC);
    }

    public final boolean zzP(Uri uri) {
        return zzX(uri, this.zzD, this.zzE);
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zziR)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        this.zzI.zzg((Context) ObjectWrapper.unwrap(iObjectWrapper), (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2), str, (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3));
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            this.zzJ.zzb();
        }
        return ObjectWrapper.wrap(this.zzI.zzb());
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbyq zzbyq, zzbyj zzbyj) {
        ListenableFuture listenableFuture;
        ListenableFuture listenableFuture2;
        ListenableFuture listenableFuture3;
        ListenableFuture listenableFuture4;
        Bundle bundle = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue()) {
            bundle.putLong(zzdrt.PUBLIC_API_CALL.zza(), zzbyq.zzd.zzz);
            bundle.putLong(zzdrt.DYNAMITE_ENTER.zza(), zzu.zzB().currentTimeMillis());
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfju zza2 = zzfjt.zza(context, 22);
        zza2.zzi();
        if ("UNKNOWN".equals(zzbyq.zzb)) {
            List arrayList = new ArrayList();
            zzbbn zzbbn = zzbbw.zzgN;
            if (!((String) zzba.zzc().zza(zzbbn)).isEmpty()) {
                arrayList = Arrays.asList(((String) zzba.zzc().zza(zzbbn)).split(","));
            }
            if (arrayList.contains(zzq.zzc(zzbyq.zzd))) {
                ListenableFuture zzg2 = zzgcj.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture2 = zzg2;
                listenableFuture = zzgcj.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                zzgcj.zzr(listenableFuture, new zzag(this, listenableFuture2, zzbyq, zzbyj, zza2), this.zzf.zzB());
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkg)).booleanValue()) {
            zzgcu zzgcu = zzbzo.zza;
            listenableFuture3 = zzgcu.zzb(new zzaa(this, zzbyq, bundle));
            listenableFuture4 = zzgcj.zzn(listenableFuture3, new zzab(), zzgcu);
        } else {
            zzs zzR = zzR(this.zzg, zzbyq.zza, zzbyq.zzb, zzbyq.zzc, zzbyq.zzd, bundle);
            listenableFuture3 = zzgcj.zzh(zzR);
            listenableFuture4 = zzR.zzb();
        }
        listenableFuture = listenableFuture4;
        listenableFuture2 = listenableFuture3;
        zzgcj.zzr(listenableFuture, new zzag(this, listenableFuture2, zzbyq, zzbyj, zza2), this.zzf.zzB());
    }

    public final void zzg(zzbtl zzbtl) {
        this.zzm = zzbtl;
        this.zzj.zzc(1);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) {
        zzV(list, iObjectWrapper, zzbtc, true);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) {
        zzW(list, iObjectWrapper, zzbtc, true);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zziG)).booleanValue()) {
            zzbbn zzbbn = zzbbw.zzgM;
            if (!((Boolean) zzba.zzc().zza(zzbbn)).booleanValue()) {
                zzU();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzm.zzg("The webView cannot be null.");
                return;
            }
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzp, this.zzq, this.zzi, this.zzJ), "gmaSdk");
            if (((Boolean) zzba.zzc().zza(zzbbw.zziQ)).booleanValue()) {
                zzu.zzo().zzs();
            }
            if (((Boolean) zzba.zzc().zza(zzbbn)).booleanValue()) {
                zzU();
            }
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgO)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbtl zzbtl = this.zzm;
            if (zzbtl == null) {
                view = null;
            } else {
                view = zzbtl.zza;
            }
            this.zzn = zzbv.zza(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzn;
            obtain.setLocation((float) point.x, (float) point.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) {
        zzV(list, iObjectWrapper, zzbtc, false);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtc) {
        zzW(list, iObjectWrapper, zzbtc, false);
    }

    public final /* synthetic */ Uri zzn(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzffk zzffk;
        try {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzla)).booleanValue() || (zzffk = this.zzi) == null) {
                uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            } else {
                uri = zzffk.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            }
        } catch (zzaup e) {
            zzm.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    public final /* synthetic */ zzs zzq(zzbyq zzbyq, Bundle bundle) throws Exception {
        return zzR(this.zzg, zzbyq.zza, zzbyq.zzb, zzbyq.zzc, zzbyq.zzd, bundle);
    }

    public final /* synthetic */ ListenableFuture zzu() throws Exception {
        return zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null, new Bundle()).zzb();
    }

    public final /* synthetic */ ListenableFuture zzv(zzdoa[] zzdoaArr, String str, zzdoa zzdoa) throws Exception {
        zzdoaArr[0] = zzdoa;
        Context context = this.zzg;
        zzbtl zzbtl = this.zzm;
        Map map = zzbtl.zzb;
        JSONObject zzd2 = zzbv.zzd(context, map, map, zzbtl.zza, (ImageView.ScaleType) null);
        JSONObject zzg2 = zzbv.zzg(this.zzg, this.zzm.zza);
        JSONObject zzf2 = zzbv.zzf(this.zzm.zza);
        JSONObject zze2 = zzbv.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzg2);
        jSONObject.put("scroll_view_signal", zzf2);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbv.zzc((String) null, this.zzg, this.zzo, this.zzn));
        }
        return zzdoa.zzg(str, jSONObject);
    }

    public final /* synthetic */ ListenableFuture zzw(ArrayList arrayList) throws Exception {
        return zzgcj.zzm(zzS("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzu(this, arrayList), this.zzk);
    }
}
