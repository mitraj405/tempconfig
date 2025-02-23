package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdme {
    private final Context zza;
    private final zzdln zzb;
    private final zzauo zzc;
    private final VersionInfoParcel zzd;
    private final zza zze;
    private final zzbav zzf;
    private final Executor zzg;
    private final zzbes zzh;
    private final zzdmw zzi;
    private final zzdpl zzj;
    private final ScheduledExecutorService zzk;
    private final zzdog zzl;
    private final zzdsk zzm;
    private final zzfll zzn;
    private final zzedh zzo;
    private final zzeds zzp;
    private final zzffk zzq;

    public zzdme(Context context, zzdln zzdln, zzauo zzauo, VersionInfoParcel versionInfoParcel, zza zza2, zzbav zzbav, Executor executor, zzffg zzffg, zzdmw zzdmw, zzdpl zzdpl, ScheduledExecutorService scheduledExecutorService, zzdsk zzdsk, zzfll zzfll, zzedh zzedh, zzdog zzdog, zzeds zzeds, zzffk zzffk) {
        this.zza = context;
        this.zzb = zzdln;
        this.zzc = zzauo;
        this.zzd = versionInfoParcel;
        this.zze = zza2;
        this.zzf = zzbav;
        this.zzg = executor;
        this.zzh = zzffg.zzi;
        this.zzi = zzdmw;
        this.zzj = zzdpl;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdsk;
        this.zzn = zzfll;
        this.zzo = zzedh;
        this.zzl = zzdog;
        this.zzp = zzeds;
        this.zzq = zzffk;
    }

    public static final zzel zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzfxr.zzm();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfxr.zzm();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzel zzr = zzr(optJSONArray.optJSONObject(i));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzfxr.zzk(arrayList);
    }

    private final zzq zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return zzq.zzc();
            }
            i = 0;
        }
        return new zzq(this.zza, new AdSize(i, i2));
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, Object obj) {
        return zzgcj.zzf(listenableFuture, Exception.class, new zzdmc((Object) null), zzbzo.zzf);
    }

    private static ListenableFuture zzm(boolean z, ListenableFuture listenableFuture, Object obj) {
        if (z) {
            return zzgcj.zzn(listenableFuture, new zzdmd(listenableFuture), zzbzo.zzf);
        }
        return zzl(listenableFuture, (Object) null);
    }

    private final ListenableFuture zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzgcj.zzh((Object) null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzgcj.zzh((Object) null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzgcj.zzh(new zzbeq((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzgcj.zzm(this.zzb.zzb(optString, optDouble, optBoolean), new zzdlu(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private final ListenableFuture zzo(JSONArray jSONArray, boolean z, boolean z2) {
        int i;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgcj.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        if (z2) {
            i = jSONArray.length();
        } else {
            i = 1;
        }
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i2), z));
        }
        return zzgcj.zzm(zzgcj.zzd(arrayList), new zzdlz(), this.zzg);
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzfel zzfel, zzfeo zzfeo) {
        ListenableFuture zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfel, zzfeo, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgcj.zzn(zzb2, new zzdlv(zzb2), zzbzo.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final zzel zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzel(optString, optString2);
    }

    public final /* synthetic */ zzben zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzq2 = zzq(jSONObject, "bg_color");
        Integer zzq3 = zzq(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzben(optString, list, zzq2, zzq3, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }

    public final /* synthetic */ ListenableFuture zzb(zzq zzq2, zzfel zzfel, zzfeo zzfeo, String str, String str2, Object obj) throws Exception {
        zzcej zza2 = this.zzj.zza(zzq2, zzfel, zzfeo);
        zzbzs zza3 = zzbzs.zza(zza2);
        zzdod zzb2 = this.zzl.zzb();
        zzdod zzdod = zzb2;
        zzcgb zzN = zza2.zzN();
        zzb zzb3 = r3;
        zzb zzb4 = new zzb(this.zza, (zzbxl) null, (zzbue) null);
        zzN.zzR(zzb2, zzdod, zzb2, zzb2, zzb2, false, (zzbja) null, zzb3, (zzbrr) null, (zzbxl) null, this.zzo, this.zzn, this.zzm, (zzbjr) null, zzb2, (zzbjq) null, (zzbjk) null, (zzbiy) null, (zzcni) null);
        zza2.zzag("/getNativeAdViewSignals", zzbiw.zzs);
        zza2.zzag("/getNativeClickMeta", zzbiw.zzt);
        zza2.zzN().zzB(new zzdly(zza3));
        zza2.zzae(str, str2, (String) null);
        return zza3;
    }

    public final /* synthetic */ ListenableFuture zzc(String str, Object obj) throws Exception {
        zzu.zzz();
        zzcej zza2 = zzcew.zza(this.zza, zzcgd.zza(), "native-omid", false, false, this.zzc, (zzbcz) null, this.zzd, (zzbcl) null, (zzm) null, this.zze, this.zzf, (zzfel) null, (zzfeo) null, this.zzp, this.zzq);
        zzbzs zza3 = zzbzs.zza(zza2);
        zza2.zzN().zzB(new zzdma(zza3));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeE)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        } else {
            zza2.loadData(str, "text/html", "UTF-8");
        }
        return zza3;
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzgcj.zzh((Object) null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzgcj.zzm(zzo(optJSONArray, false, true), new zzdmb(this, optJSONObject), this.zzg), (Object) null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str) {
        zzbes zzbes = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbes.zzb, zzbes.zzd);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, zzfel zzfel, zzfeo zzfeo) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjf)).booleanValue()) {
            return zzgcj.zzh((Object) null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzgcj.zzh((Object) null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzgcj.zzh((Object) null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString("html");
        zzq zzk2 = zzk(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzgcj.zzh((Object) null);
        }
        ListenableFuture zzn2 = zzgcj.zzn(zzgcj.zzh((Object) null), new zzdlw(this, zzk2, zzfel, zzfeo, optString, optString2), zzbzo.zze);
        return zzgcj.zzn(zzn2, new zzdlx(zzn2), zzbzo.zzf);
    }

    public final ListenableFuture zzh(JSONObject jSONObject, zzfel zzfel, zzfeo zzfeo) {
        ListenableFuture listenableFuture;
        JSONObject zzh2 = zzbs.zzh(jSONObject, "html_containers", "instream");
        if (zzh2 != null) {
            return zzp(zzh2, zzfel, zzfeo);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzgcj.zzh((Object) null);
        }
        String optString = optJSONObject.optString("vast_xml");
        boolean z = false;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzje)).booleanValue() && optJSONObject.has("html")) {
            z = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzgcj.zzh((Object) null);
            }
        } else if (!z) {
            listenableFuture = this.zzi.zza(optJSONObject);
            zzbbn zzbbn = zzbbw.zzdt;
            return zzl(zzgcj.zzo(listenableFuture, (long) ((Integer) zzba.zzc().zza(zzbbn)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        listenableFuture = zzp(optJSONObject, zzfel, zzfeo);
        zzbbn zzbbn2 = zzbbw.zzdt;
        return zzl(zzgcj.zzo(listenableFuture, (long) ((Integer) zzba.zzc().zza(zzbbn2)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }
}
