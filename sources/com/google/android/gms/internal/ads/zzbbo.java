package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbbo {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (zzbbn zza2 : this.zzb) {
            String str = (String) zzba.zzc().zza(zza2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbbx.zza());
        return arrayList;
    }

    public final List zzb() {
        List zza2 = zza();
        for (zzbbn zza3 : this.zzc) {
            String str = (String) zzba.zzc().zza(zza3);
            if (!TextUtils.isEmpty(str)) {
                zza2.add(str);
            }
        }
        zza2.addAll(zzbbx.zzb());
        return zza2;
    }

    public final void zzc(zzbbn zzbbn) {
        this.zzb.add(zzbbn);
    }

    public final void zzd(zzbbn zzbbn) {
        this.zza.add(zzbbn);
    }

    public final void zze(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbbn zzbbn : this.zza) {
            if (zzbbn.zze() == 1) {
                zzbbn.zzd(editor, zzbbn.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzm.zzg("Flag Json is null.");
        }
    }
}
