package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfnt implements zzfmu {
    private static final zzfnt zza = new zzfnt();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzd = new zzfnp();
    /* access modifiers changed from: private */
    public static final Runnable zze = new zzfnq();
    private final List zzf = new ArrayList();
    private int zzg;
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfmw zzj = new zzfmw();
    private final zzfnm zzk = new zzfnm();
    /* access modifiers changed from: private */
    public final zzfnn zzl = new zzfnn(new zzfnw());
    private long zzm;

    public static zzfnt zzd() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzfnt zzfnt) {
        zzfnt.zzg = 0;
        zzfnt.zzi.clear();
        zzfnt.zzh = false;
        for (zzflu zzflu : zzfml.zza().zzb()) {
        }
        zzfnt.zzm = System.nanoTime();
        zzfnt.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzfmv zza2 = zzfnt.zzj.zza();
        if (zzfnt.zzk.zze().size() > 0) {
            Iterator it = zzfnt.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject zza3 = zza2.zza((View) null);
                View zza4 = zzfnt.zzk.zza(str);
                zzfmv zzb2 = zzfnt.zzj.zzb();
                String zzc2 = zzfnt.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzfnf.zzb(zza5, str);
                    try {
                        zza5.put("notVisibleReason", zzc2);
                    } catch (JSONException e) {
                        zzfng.zza("Error with setting not visible reason", e);
                    }
                    zzfnf.zzc(zza3, zza5);
                }
                zzfnf.zzf(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfnt.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfnt.zzk.zzf().size() > 0) {
            JSONObject zza6 = zza2.zza((View) null);
            zzfnt.zzk((View) null, zza2, zza6, 1, false);
            zzfnf.zzf(zza6);
            zzfnt.zzl.zzd(zza6, zzfnt.zzk.zzf(), nanoTime);
        } else {
            zzfnt.zzl.zzb();
        }
        zzfnt.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzfnt.zzm;
        if (zzfnt.zzf.size() > 0) {
            for (zzfns zzfns : zzfnt.zzf) {
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzfns.zzb();
                if (zzfns instanceof zzfnr) {
                    ((zzfnr) zzfns).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfmv zzfmv, JSONObject jSONObject, int i, boolean z) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        zzfmv.zzb(view, jSONObject, this, z2, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zza(View view, zzfmv zzfmv, JSONObject jSONObject, boolean z) {
        int zzk2;
        boolean z2;
        boolean z3;
        if (zzfnk.zza(view) == null && (zzk2 = this.zzk.zzk(view)) != 3) {
            JSONObject zza2 = zzfmv.zza(view);
            zzfnf.zzc(jSONObject, zza2);
            String zzd2 = this.zzk.zzd(view);
            if (zzd2 != null) {
                zzfnf.zzb(zza2, zzd2);
                try {
                    zza2.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
                } catch (JSONException e) {
                    zzfng.zza("Error with setting has window focus", e);
                }
                this.zzk.zzh();
            } else {
                zzfnl zzb2 = this.zzk.zzb(view);
                if (zzb2 != null) {
                    zzfmo zza3 = zzb2.zza();
                    JSONArray jSONArray = new JSONArray();
                    ArrayList zzb3 = zzb2.zzb();
                    int size = zzb3.size();
                    for (int i = 0; i < size; i++) {
                        jSONArray.put((String) zzb3.get(i));
                    }
                    try {
                        zza2.put("isFriendlyObstructionFor", jSONArray);
                        zza2.put("friendlyObstructionClass", zza3.zzd());
                        zza2.put("friendlyObstructionPurpose", zza3.zza());
                        zza2.put("friendlyObstructionReason", zza3.zzc());
                    } catch (JSONException e2) {
                        zzfng.zza("Error with setting friendly obstruction", e2);
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z || z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzk(view, zzfmv, zza2, zzk2, z3);
            }
            this.zzg++;
        }
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfno(this));
    }
}
