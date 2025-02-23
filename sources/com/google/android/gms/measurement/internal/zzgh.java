package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzin;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzgh extends zzii {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private long zzaa;
    public zzgl zzb;
    public final zzgm zzc = new zzgm(this, "first_open_time", 0);
    public final zzgm zzd = new zzgm(this, "app_install_time", 0);
    public final zzgn zze = new zzgn(this, "app_instance_id", (String) null);
    public final zzgm zzf = new zzgm(this, "session_timeout", 1800000);
    public final zzgk zzg = new zzgk(this, "start_new_session", true);
    public final zzgn zzh = new zzgn(this, "non_personalized_ads", (String) null);
    public final zzgj zzi = new zzgj(this, "last_received_uri_timestamps_by_source", (Bundle) null);
    public final zzgk zzj = new zzgk(this, "allow_remote_dynamite", false);
    public final zzgm zzk = new zzgm(this, "last_pause_time", 0);
    public final zzgm zzl = new zzgm(this, "session_id", 0);
    public boolean zzm;
    public zzgk zzn = new zzgk(this, "app_backgrounded", false);
    public zzgk zzo = new zzgk(this, "deep_link_retrieval_complete", false);
    public zzgm zzp = new zzgm(this, "deep_link_retrieval_attempts", 0);
    public final zzgn zzq = new zzgn(this, "firebase_feature_rollouts", (String) null);
    public final zzgn zzr = new zzgn(this, "deferred_attribution_cache", (String) null);
    public final zzgm zzs = new zzgm(this, "deferred_attribution_cache_timestamp", 0);
    public final zzgj zzt = new zzgj(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzv;
    private Object zzw = new Object();
    private SharedPreferences zzx;
    private String zzy;
    private boolean zzz;

    public zzgh(zzhj zzhj) {
        super(zzhj);
    }

    public final Pair<String, Boolean> zza(String str) {
        zzt();
        if (!zzn().zza(zzin.zza.AD_STORAGE)) {
            return new Pair<>("", Boolean.FALSE);
        }
        long elapsedRealtime = zzb().elapsedRealtime();
        if (this.zzy != null && elapsedRealtime < this.zzaa) {
            return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
        }
        this.zzaa = zze().zzd(str) + elapsedRealtime;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            this.zzy = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzy = id;
            }
            this.zzz = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            this.zzy = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
    }

    public final void zzaa() {
        SharedPreferences sharedPreferences = zza().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzv.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzgl(this, "health_monitor", Math.max(0, zzbf.zzc.zza(null).longValue()));
    }

    public final boolean zzab() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final void zzb(String str) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    public final SharedPreferences zzc() {
        zzt();
        zzac();
        if (this.zzx == null) {
            synchronized (this.zzw) {
                if (this.zzx == null) {
                    String str = zza().getPackageName() + "_preferences";
                    zzj().zzp().zza("Default prefs file", str);
                    this.zzx = zza().getSharedPreferences(str, 0);
                }
            }
        }
        return this.zzx;
    }

    @VisibleForTesting
    public final SharedPreferences zzg() {
        zzt();
        zzac();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    public final SparseArray<Long> zzh() {
        Bundle zza2 = this.zzi.zza();
        if (zza2 == null) {
            return new SparseArray<>();
        }
        int[] intArray = zza2.getIntArray("uriSources");
        long[] longArray = zza2.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            zzj().zzg().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    public final zzav zzm() {
        zzt();
        return zzav.zza(zzg().getString("dma_consent_settings", (String) null));
    }

    public final zzin zzn() {
        zzt();
        return zzin.zza(zzg().getString("consent_settings", "G1"), zzg().getInt("consent_source", 100));
    }

    public final boolean zzo() {
        return true;
    }

    public final Boolean zzp() {
        zzt();
        if (!zzg().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzg().getBoolean("use_service", false));
    }

    public final Boolean zzu() {
        zzt();
        if (zzg().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    public final Boolean zzv() {
        zzt();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final String zzw() {
        zzt();
        String string = zzg().getString("previous_os_version", (String) null);
        zzf().zzac();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzg().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    public final String zzx() {
        zzt();
        return zzg().getString("admob_app_id", (String) null);
    }

    public final String zzy() {
        zzt();
        return zzg().getString("gmp_app_id", (String) null);
    }

    public final void zzz() {
        zzt();
        Boolean zzv2 = zzv();
        SharedPreferences.Editor edit = zzg().edit();
        edit.clear();
        edit.apply();
        if (zzv2 != null) {
            zza(zzv2);
        }
    }

    public final void zzb(Boolean bool) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled_from_api");
        }
        edit.apply();
    }

    public final void zzb(boolean z) {
        zzt();
        zzj().zzp().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    public final void zzc(String str) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    public final void zza(Boolean bool) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    public final void zza(boolean z) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    public final void zza(SparseArray<Long> sparseArray) {
        if (sparseArray == null) {
            this.zzi.zza((Bundle) null);
            return;
        }
        int[] iArr = new int[sparseArray.size()];
        long[] jArr = new long[sparseArray.size()];
        for (int i = 0; i < sparseArray.size(); i++) {
            iArr[i] = sparseArray.keyAt(i);
            jArr[i] = sparseArray.valueAt(i).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        this.zzi.zza(bundle);
    }

    public final boolean zza(long j) {
        return j - this.zzf.zza() > this.zzk.zza();
    }

    public final boolean zza(zzav zzav) {
        zzt();
        if (!zzin.zza(zzav.zza(), zzm().zza())) {
            return false;
        }
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("dma_consent_settings", zzav.zzf());
        edit.apply();
        return true;
    }

    public final boolean zza(zzin zzin) {
        zzt();
        int zza2 = zzin.zza();
        if (!zza(zza2)) {
            return false;
        }
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("consent_settings", zzin.zzh());
        edit.putInt("consent_source", zza2);
        edit.apply();
        return true;
    }

    public final boolean zza(int i) {
        return zzin.zza(i, zzg().getInt("consent_source", 100));
    }

    public final boolean zza(zzms zzms) {
        zzt();
        String string = zzg().getString("stored_tcf_param", "");
        String zzc2 = zzms.zzc();
        if (zzc2.equals(string)) {
            return false;
        }
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("stored_tcf_param", zzc2);
        edit.apply();
        return true;
    }
}
