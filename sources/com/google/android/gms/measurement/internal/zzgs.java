package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbz;
import com.google.android.gms.internal.measurement.zzoj;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzgs implements Runnable {
    private final /* synthetic */ zzbz zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzgp zzc;

    public zzgs(zzgp zzgp, zzbz zzbz, ServiceConnection serviceConnection) {
        this.zza = zzbz;
        this.zzb = serviceConnection;
        this.zzc = zzgp;
    }

    public final void run() {
        boolean z;
        boolean z2;
        zzgp zzgp = this.zzc;
        zzgq zzgq = zzgp.zza;
        String zza2 = zzgp.zzb;
        zzbz zzbz = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza3 = zzgq.zza(zza2, zzbz);
        zzgq.zza.zzl().zzt();
        zzgq.zza.zzy();
        if (zza3 != null) {
            long j = zza3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzgq.zza.zzj().zzu().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzgq.zza.zzj().zzg().zza("No referrer defined in Install Referrer response");
                } else {
                    zzgq.zza.zzj().zzp().zza("InstallReferrer API result", string);
                    if (!zzoj.zza() || !zzgq.zza.zzf().zza(zzbf.zzcm)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Bundle zza4 = zzgq.zza.zzt().zza(Uri.parse("?".concat(string)), z);
                    if (zza4 == null) {
                        zzgq.zza.zzj().zzg().zza("No campaign params defined in Install Referrer result");
                    } else {
                        if (z) {
                            long j2 = zza3.getLong("referrer_click_timestamp_server_seconds", 0) * 1000;
                            if (j2 > 0) {
                                zza4.putLong("click_timestamp", j2);
                            }
                        } else {
                            String string2 = zza4.getString("medium");
                            if (string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                long j3 = zza3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                                if (j3 == 0) {
                                    zzgq.zza.zzj().zzg().zza("Install Referrer is missing click timestamp for ad campaign");
                                } else {
                                    zza4.putLong("click_timestamp", j3);
                                }
                            }
                        }
                        if (j == zzgq.zza.zzn().zzd.zza()) {
                            zzgq.zza.zzj().zzp().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzgq.zza.zzac()) {
                            zzgq.zza.zzn().zzd.zza(j);
                            zzgq.zza.zzj().zzp().zza("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zza4.putString("_cis", "referrer API v2");
                            zzgq.zza.zzp().zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zza4, zza2);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzgq.zza.zza(), serviceConnection);
        }
    }
}
