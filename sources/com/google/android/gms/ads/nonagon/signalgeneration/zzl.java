package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzdsp;
import in.juspay.hyper.constants.LogCategory;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzl {
    /* access modifiers changed from: private */
    public final int zza;
    private final long zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final Map zze;
    /* access modifiers changed from: private */
    public final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();
    private final zzdsp zzh;
    private Map zzi;

    public zzl(zzdsp zzdsp) {
        this.zzh = zzdsp;
        this.zza = ((Integer) zzba.zzc().zza(zzbbw.zzgm)).intValue();
        this.zzb = ((Long) zzba.zzc().zza(zzbbw.zzgn)).longValue();
        this.zzc = ((Boolean) zzba.zzc().zza(zzbbw.zzgr)).booleanValue();
        this.zzd = ((Boolean) zzba.zzc().zza(zzbbw.zzgq)).booleanValue();
        this.zze = Collections.synchronizedMap(new zzj(this));
    }

    private final synchronized void zzi(zzdsf zzdsf) {
        if (this.zzc) {
            ArrayDeque arrayDeque = this.zzg;
            ArrayDeque clone = arrayDeque.clone();
            arrayDeque.clear();
            ArrayDeque arrayDeque2 = this.zzf;
            ArrayDeque clone2 = arrayDeque2.clone();
            arrayDeque2.clear();
            zzbzo.zza.execute(new zzi(this, zzdsf, clone, clone2));
        }
    }

    private final void zzj(zzdsf zzdsf, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdsf.zzb());
            this.zzi = concurrentHashMap;
            concurrentHashMap.put(LogCategory.ACTION, "ev");
            this.zzi.put("e_r", str);
            this.zzi.put("e_id", (String) pair2.first);
            if (this.zzd) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzq.zzb(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                zzl(this.zzi, "e_type", (String) pair.first);
                zzl(this.zzi, "e_agent", (String) pair.second);
            }
            this.zzh.zzf(this.zzi);
        }
    }

    private final synchronized void zzk() {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        try {
            Iterator it = this.zze.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (currentTimeMillis - ((zzk) entry.getValue()).zza.longValue() <= this.zzb) {
                    break;
                }
                this.zzg.add(new Pair((String) entry.getKey(), ((zzk) entry.getValue()).zzb));
                it.remove();
            }
        } catch (ConcurrentModificationException e) {
            zzu.zzo().zzw(e, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private static final void zzl(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public final synchronized String zzb(String str, zzdsf zzdsf) {
        zzk zzk = (zzk) this.zze.get(str);
        zzdsf.zzb().put("request_id", str);
        if (zzk != null) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzgL)).booleanValue()) {
                this.zze.remove(str);
            }
            String str2 = zzk.zzb;
            zzdsf.zzb().put("mhit", "true");
            return str2;
        }
        zzdsf.zzb().put("mhit", "false");
        return null;
    }

    public final synchronized void zzd(String str, String str2, zzdsf zzdsf) {
        this.zze.put(str, new zzk(Long.valueOf(zzu.zzB().currentTimeMillis()), str2, new HashSet()));
        zzk();
        zzi(zzdsf);
    }

    public final /* synthetic */ void zze(zzdsf zzdsf, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        zzj(zzdsf, arrayDeque, "to");
        zzj(zzdsf, arrayDeque2, "of");
    }

    public final synchronized void zzf(String str) {
        this.zze.remove(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (r3.zzc.size() >= r5) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzg(java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map r0 = r2.zze     // Catch:{ all -> 0x001f }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x001f }
            com.google.android.gms.ads.nonagon.signalgeneration.zzk r3 = (com.google.android.gms.ads.nonagon.signalgeneration.zzk) r3     // Catch:{ all -> 0x001f }
            r0 = 0
            if (r3 == 0) goto L_0x001d
            java.util.Set r1 = r3.zzc     // Catch:{ all -> 0x001f }
            r1.add(r4)     // Catch:{ all -> 0x001f }
            java.util.Set r3 = r3.zzc     // Catch:{ all -> 0x001f }
            int r3 = r3.size()     // Catch:{ all -> 0x001f }
            monitor-exit(r2)
            if (r3 >= r5) goto L_0x001c
            r3 = 1
            return r3
        L_0x001c:
            return r0
        L_0x001d:
            monitor-exit(r2)
            return r0
        L_0x001f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzl.zzg(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzh(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map r0 = r1.zze     // Catch:{ all -> 0x0019 }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0019 }
            com.google.android.gms.ads.nonagon.signalgeneration.zzk r2 = (com.google.android.gms.ads.nonagon.signalgeneration.zzk) r2     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x0016
            java.util.Set r2 = r2.zzc     // Catch:{ all -> 0x0019 }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x0016
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x0016:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzl.zzh(java.lang.String, java.lang.String):boolean");
    }
}
