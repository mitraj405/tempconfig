package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzccw implements zzbix {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zzm.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzccv zzccv;
        zzccn zzccn;
        Map map2 = map;
        zzcbk zzcbk = (zzcbk) obj;
        if (zzm.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map2);
            jSONObject.remove("google.afma.Notify_dt");
            zzm.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcco zzy = zzu.zzy();
        if (!map2.containsKey("abort")) {
            String str = (String) map2.get("src");
            Integer zzb = zzb(map2, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map2, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map2, "exoPlayerIdleIntervalMs");
            zzcbj zzcbj = new zzcbj((String) map2.get("flags"));
            boolean z = zzcbj.zzk;
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map2.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        zzm.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (z) {
                    Iterator it = zzy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzccn = null;
                            break;
                        }
                        zzccn zzccn2 = (zzccn) it.next();
                        if (zzccn2.zza == zzcbk && str.equals(zzccn2.zze())) {
                            zzccn = zzccn2;
                            break;
                        }
                    }
                } else {
                    zzccn = zzy.zza(zzcbk);
                }
                if (zzccn != null) {
                    zzm.zzj("Precache task is already running.");
                    return;
                } else if (zzcbk.zzj() == null) {
                    zzm.zzj("Precache requires a dependency provider.");
                    return;
                } else {
                    Integer zzb4 = zzb(map2, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzcbk.zzA(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzcbk.zzy(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzcbk.zzx(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzcch zzcch = zzcbk.zzj().zzb;
                    if (intValue > 0) {
                        int i2 = zzcbj.zzg;
                        int zzu = zzcbb.zzu();
                        if (zzu < i2) {
                            zzccv = new zzcde(zzcbk, zzcbj);
                        } else if (zzu < zzcbj.zzb) {
                            zzccv = new zzcdb(zzcbk, zzcbj);
                        } else {
                            zzccv = new zzccz(zzcbk);
                        }
                    } else {
                        zzccv = new zzccy(zzcbk);
                    }
                    new zzccn(zzcbk, zzccv, str, strArr).zzb();
                }
            } else {
                zzccn zza = zzy.zza(zzcbk);
                if (zza != null) {
                    zzccv = zza.zzb;
                } else {
                    zzm.zzj("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map2, "minBufferMs");
            if (zzb5 != null) {
                zzccv.zzs(zzb5.intValue());
            }
            Integer zzb6 = zzb(map2, "maxBufferMs");
            if (zzb6 != null) {
                zzccv.zzr(zzb6.intValue());
            }
            Integer zzb7 = zzb(map2, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzccv.zzp(zzb7.intValue());
            }
            Integer zzb8 = zzb(map2, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzccv.zzq(zzb8.intValue());
            }
        } else if (!zzy.zzd(zzcbk)) {
            zzm.zzj("Precache abort but no precache task running.");
        }
    }
}
