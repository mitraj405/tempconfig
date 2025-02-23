package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.juspay.hyper.constants.LogCategory;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbcl {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbcl(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put(LogCategory.ACTION, "make_wv");
        linkedHashMap.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public static final zzbci zzf() {
        return new zzbci(zzu.zzB().elapsedRealtime(), (String) null, (zzbci) null);
    }

    public final zzbck zza() {
        zzbck zzbck;
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzbG)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzbci zzbci : this.zza) {
                long zza2 = zzbci.zza();
                String zzc2 = zzbci.zzc();
                zzbci zzb2 = zzbci.zzb();
                if (zzb2 != null && zza2 > 0) {
                    sb.append(zzc2);
                    sb.append('.');
                    sb.append(zza2 - zzb2.zza());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzb2.zza()))) {
                            hashMap.put(Long.valueOf(zzb2.zza()), new StringBuilder(zzc2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzb2.zza()));
                            sb2.append('+');
                            sb2.append(zzc2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzu.zzB().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzu.zzB().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzbck = new zzbck(sb.toString(), str);
        }
        return zzbck;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            zzu.zzo().zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbcl zzbcl) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbcb zzg;
        if (!TextUtils.isEmpty(str2) && (zzg = zzu.zzo().zzg()) != null) {
            synchronized (this.zzc) {
                zzbch zza2 = zzg.zza(str);
                Map map = this.zzb;
                map.put(str, zza2.zza((String) map.get(str), str2));
            }
        }
    }

    public final boolean zze(zzbci zzbci, long j, String... strArr) {
        synchronized (this.zzc) {
            this.zza.add(new zzbci(j, strArr[0], zzbci));
        }
        return true;
    }
}
