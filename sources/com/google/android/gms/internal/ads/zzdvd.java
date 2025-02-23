package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdvd {
    private final zzdun zza;
    private final zzdpy zzb;
    private final Object zzc = new Object();
    private final List zzd;
    private boolean zze;

    public zzdvd(zzdun zzdun, zzdpy zzdpy) {
        this.zza = zzdun;
        this.zzb = zzdpy;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    public final void zzd(List list) {
        String str;
        boolean z;
        synchronized (this.zzc) {
            if (!this.zze) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbkv zzbkv = (zzbkv) it.next();
                    if (((Boolean) zzba.zzc().zza(zzbbw.zziw)).booleanValue()) {
                        zzdpx zza2 = this.zzb.zza(zzbkv.zza);
                        if (zza2 != null) {
                            zzbra zzbra = zza2.zzc;
                            if (zzbra != null) {
                                str = zzbra.toString();
                            }
                        }
                        str = "";
                    } else {
                        str = "";
                    }
                    String str2 = str;
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzix)).booleanValue()) {
                        zzdpx zza3 = this.zzb.zza(zzbkv.zza);
                        if (zza3 != null) {
                            if (zza3.zzd) {
                                z = true;
                                List list2 = this.zzd;
                                String str3 = zzbkv.zza;
                                list2.add(new zzdvc(str3, str2, this.zzb.zzb(str3), zzbkv.zzb ? 1 : 0, zzbkv.zzd, zzbkv.zzc, z));
                            }
                        }
                    }
                    z = false;
                    List list22 = this.zzd;
                    String str32 = zzbkv.zza;
                    list22.add(new zzdvc(str32, str2, this.zzb.zzb(str32), zzbkv.zzb ? 1 : 0, zzbkv.zzd, zzbkv.zzc, z));
                }
                this.zze = true;
            }
        }
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zzt()) {
                    zzd(this.zza.zzg());
                } else {
                    zzc();
                }
            }
            for (zzdvc zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
        }
        return jSONArray;
    }

    public final void zzc() {
        this.zza.zzs(new zzdvb(this));
    }
}
