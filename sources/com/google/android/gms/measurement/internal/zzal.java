package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.messaging.Constants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzal extends zzmx {
    /* access modifiers changed from: private */
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzar zzl = new zzar(this, zza(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzmr zzm = new zzmr(zzb());

    public zzal(zznc zznc) {
        super(zznc);
    }

    public final long b_() {
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return -1;
            }
            long j = cursor.getLong(0);
            cursor.close();
            return j;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0025, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0027
        L_0x0020:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003b
        L_0x0025:
            r2 = move-exception
            r0 = r1
        L_0x0027:
            com.google.android.gms.measurement.internal.zzfw r3 = r6.zzj()     // Catch:{ all -> 0x003a }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()
        L_0x0040:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.f_():java.lang.String");
    }

    public final boolean zzaa() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX INFO: finally extract failed */
    public final long zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        long j = 0;
        try {
            long zza2 = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1);
            if (zza2 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (e_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    zzj().zzg().zza("Failed to insert column (got -1). appId", zzfw.zza(str), str2);
                    e_.endTransaction();
                    return -1;
                }
                zza2 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza2));
                if (((long) e_.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzfw.zza(str), str2);
                    e_.endTransaction();
                    return -1;
                }
                e_.setTransactionSuccessful();
                e_.endTransaction();
                return zza2;
            } catch (SQLiteException e) {
                e = e;
                j = zza2;
                try {
                    zzj().zzg().zza("Error inserting column. appId", zzfw.zza(str), str2, e);
                    e_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    e_.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            zzj().zzg().zza("Error inserting column. appId", zzfw.zza(str), str2, e);
            e_.endTransaction();
            return j;
        }
    }

    public final boolean zzc() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzd(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzt()
            r5.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.e_()     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            r4 = 0
            r3[r4] = r6     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0069 }
            if (r2 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzfw r6 = r5.zzj()     // Catch:{ SQLiteException -> 0x0069 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch:{ SQLiteException -> 0x0069 }
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch:{ SQLiteException -> 0x0069 }
            r1.close()
            return r0
        L_0x002e:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0069 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r3 = com.google.android.gms.internal.measurement.zzfn.zzf.zze()     // Catch:{ IOException -> 0x0053 }
            com.google.android.gms.internal.measurement.zzks r2 = com.google.android.gms.measurement.internal.zznl.zza(r3, (byte[]) r2)     // Catch:{ IOException -> 0x0053 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2     // Catch:{ IOException -> 0x0053 }
            com.google.android.gms.internal.measurement.zzkt r2 = r2.zzai()     // Catch:{ IOException -> 0x0053 }
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch:{ IOException -> 0x0053 }
            com.google.android.gms.internal.measurement.zzfn$zzf r2 = (com.google.android.gms.internal.measurement.zzfn.zzf) r2     // Catch:{ IOException -> 0x0053 }
            r5.g_()     // Catch:{ SQLiteException -> 0x0069 }
            java.util.List r6 = r2.zzh()     // Catch:{ SQLiteException -> 0x0069 }
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zznl.zza((java.util.List<com.google.android.gms.internal.measurement.zzfn.zzh>) r6)     // Catch:{ SQLiteException -> 0x0069 }
            r1.close()
            return r6
        L_0x0053:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfw r3 = r5.zzj()     // Catch:{ SQLiteException -> 0x0069 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ SQLiteException -> 0x0069 }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0069 }
            r3.zza(r4, r6, r2)     // Catch:{ SQLiteException -> 0x0069 }
            r1.close()
            return r0
        L_0x0069:
            r6 = move-exception
            goto L_0x006f
        L_0x006b:
            r6 = move-exception
            goto L_0x0084
        L_0x006d:
            r6 = move-exception
            r1 = r0
        L_0x006f:
            com.google.android.gms.measurement.internal.zzfw r2 = r5.zzj()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0081
            r1.close()
        L_0x0081:
            return r0
        L_0x0082:
            r6 = move-exception
            r0 = r1
        L_0x0084:
            if (r0 == 0) goto L_0x0089
            r0.close()
        L_0x0089:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzd(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0308 A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0319 A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0363 A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0177 A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x017b A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01af A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01cd A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01d0 A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01df A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0235 A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02bd A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x02bf A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02cb A[Catch:{ SQLiteException -> 0x0378 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02cd A[Catch:{ SQLiteException -> 0x0378 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zze(java.lang.String r51) {
        /*
            r50 = this;
            r1 = r50
            r2 = r51
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r51)
            r50.zzt()
            r50.zzal()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r50.e_()     // Catch:{ SQLiteException -> 0x037c, all -> 0x037a }
            java.lang.String r5 = "apps"
            java.lang.String r6 = "app_instance_id"
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r8 = "resettable_device_id_hash"
            java.lang.String r9 = "last_bundle_index"
            java.lang.String r10 = "last_bundle_start_timestamp"
            java.lang.String r11 = "last_bundle_end_timestamp"
            java.lang.String r12 = "app_version"
            java.lang.String r13 = "app_store"
            java.lang.String r14 = "gmp_version"
            java.lang.String r15 = "dev_cert_hash"
            java.lang.String r16 = "measurement_enabled"
            java.lang.String r17 = "day"
            java.lang.String r18 = "daily_public_events_count"
            java.lang.String r19 = "daily_events_count"
            java.lang.String r20 = "daily_conversions_count"
            java.lang.String r21 = "config_fetched_time"
            java.lang.String r22 = "failed_config_fetch_time"
            java.lang.String r23 = "app_version_int"
            java.lang.String r24 = "firebase_instance_id"
            java.lang.String r25 = "daily_error_events_count"
            java.lang.String r26 = "daily_realtime_events_count"
            java.lang.String r27 = "health_monitor_sample"
            java.lang.String r28 = "android_id"
            java.lang.String r29 = "adid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String r34 = "session_stitching_token"
            java.lang.String r35 = "sgtm_upload_enabled"
            java.lang.String r36 = "target_os_version"
            java.lang.String r37 = "session_stitching_token_hash"
            java.lang.String r38 = "ad_services_version"
            java.lang.String r39 = "unmatched_first_open_without_ad_id"
            java.lang.String r40 = "npa_metadata_value"
            java.lang.String r41 = "attribution_eligibility_status"
            java.lang.String r42 = "sgtm_preview_key"
            java.lang.String r43 = "dma_consent_state"
            java.lang.String r44 = "daily_realtime_dcu_count"
            java.lang.String r45 = "bundle_delivery_index"
            java.lang.String r46 = "serialized_npa_metadata"
            java.lang.String r47 = "unmatched_pfo"
            java.lang.String r48 = "unmatched_uwa"
            java.lang.String r49 = "ad_campaign_info"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49}     // Catch:{ SQLiteException -> 0x037c, all -> 0x037a }
            java.lang.String r7 = "app_id=?"
            r0 = 1
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x037c, all -> 0x037a }
            r12 = 0
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x037c, all -> 0x037a }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x037c, all -> 0x037a }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0378 }
            if (r5 != 0) goto L_0x0089
            r4.close()
            return r3
        L_0x0089:
            com.google.android.gms.measurement.internal.zzg r5 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zznc r6 = r1.zzf     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzhj r6 = r6.zzk()     // Catch:{ SQLiteException -> 0x0378 }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = com.google.android.gms.internal.measurement.zznk.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x00b4
            com.google.android.gms.measurement.internal.zzag r6 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzcv     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x00b4
            com.google.android.gms.measurement.internal.zznc r6 = r1.zzf     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzin r6 = r6.zzb((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzin$zza r7 = com.google.android.gms.measurement.internal.zzin.zza.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzin.zza) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x00bb
        L_0x00b4:
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x00bb:
            java.lang.String r6 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzf((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = com.google.android.gms.internal.measurement.zznk.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzag r6 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzcv     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zznc r6 = r1.zzf     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzin r6 = r6.zzb((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzin$zza r7 = com.google.android.gms.measurement.internal.zzin.zza.AD_STORAGE     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzin.zza) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x00ea
        L_0x00e2:
            r6 = 2
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzh((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x00ea:
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzq(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 4
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzr(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 5
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzp(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 6
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzd((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 7
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzc((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 8
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzn(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 9
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzk((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 10
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 != 0) goto L_0x0135
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0133
            goto L_0x0135
        L_0x0133:
            r6 = r12
            goto L_0x0136
        L_0x0135:
            r6 = r0
        L_0x0136:
            r5.zzb((boolean) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 11
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzj((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 12
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzh((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 13
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzg((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 14
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zze((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 15
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzd((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 16
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzm(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 17
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 == 0) goto L_0x017b
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0180
        L_0x017b:
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x0378 }
        L_0x0180:
            r5.zzb((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 18
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zze((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 19
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzf((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 20
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzi((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 21
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzg((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 23
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 != 0) goto L_0x01b8
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r6 = r12
            goto L_0x01b9
        L_0x01b8:
            r6 = r0
        L_0x01b9:
            r5.zza((boolean) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 24
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 25
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 == 0) goto L_0x01d0
            r6 = 0
            goto L_0x01d4
        L_0x01d0:
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x01d4:
            r5.zzl(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 26
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 != 0) goto L_0x01f1
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            java.lang.String r7 = ","
            r8 = -1
            java.lang.String[] r6 = r6.split(r7, r8)     // Catch:{ SQLiteException -> 0x0378 }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zza((java.util.List<java.lang.String>) r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x01f1:
            boolean r6 = com.google.android.gms.internal.measurement.zznk.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.zzag r6 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzcv     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.zznc r6 = r1.zzf     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzin r6 = r6.zzb((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzin$zza r7 = com.google.android.gms.measurement.internal.zzin.zza.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzin.zza) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x021a
        L_0x0211:
            r6 = 28
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzj((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x021a:
            boolean r6 = com.google.android.gms.internal.measurement.zzpn.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0267
            com.google.android.gms.measurement.internal.zzag r6 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzbs     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0267
            r50.zzq()     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = com.google.android.gms.measurement.internal.zznp.zzf(r51)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0267
            r6 = 29
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 != 0) goto L_0x0245
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0245
            r6 = r0
            goto L_0x0246
        L_0x0245:
            r6 = r12
        L_0x0246:
            r5.zzc((boolean) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 39
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzo(r6)     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzag r6 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzbt     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x0267
            r6 = 36
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzk((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x0267:
            r6 = 30
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 31
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzs(r6)     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x029d
            com.google.android.gms.measurement.internal.zzag r6 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzbz     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zze(r2, r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x029d
            r6 = 32
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zza((int) r6)     // Catch:{ SQLiteException -> 0x0378 }
            r6 = 35
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzc((long) r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x029d:
            boolean r6 = com.google.android.gms.internal.measurement.zznl.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x02c3
            com.google.android.gms.measurement.internal.zzag r6 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbf.zzck     // Catch:{ SQLiteException -> 0x0378 }
            boolean r6 = r6.zze(r2, r7)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x02c3
            r6 = 33
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 != 0) goto L_0x02bf
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x02bf
            r6 = r0
            goto L_0x02c0
        L_0x02bf:
            r6 = r12
        L_0x02c0:
            r5.zzd((boolean) r6)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x02c3:
            r6 = 34
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r7 == 0) goto L_0x02cd
            r0 = r3
            goto L_0x02d9
        L_0x02cd:
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 == 0) goto L_0x02d4
            goto L_0x02d5
        L_0x02d4:
            r0 = r12
        L_0x02d5:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x02d9:
            r5.zza((java.lang.Boolean) r0)     // Catch:{ SQLiteException -> 0x0378 }
            r0 = 37
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzc((int) r0)     // Catch:{ SQLiteException -> 0x0378 }
            r0 = 38
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzb((int) r0)     // Catch:{ SQLiteException -> 0x0378 }
            boolean r0 = com.google.android.gms.internal.measurement.zzne.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r0 == 0) goto L_0x030d
            com.google.android.gms.measurement.internal.zzag r0 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzbf.zzcp     // Catch:{ SQLiteException -> 0x0378 }
            boolean r0 = r0.zze(r2, r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r0 == 0) goto L_0x030d
            r0 = 40
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x0378 }
            if (r0 != 0) goto L_0x030a
            java.lang.String r0 = ""
        L_0x030a:
            r5.zzi((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x030d:
            com.google.android.gms.measurement.internal.zzag r0 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzbf.zzcs     // Catch:{ SQLiteException -> 0x0378 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r0 == 0) goto L_0x033f
            r0 = 41
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 != 0) goto L_0x032c
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0378 }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zza((java.lang.Long) r0)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x032c:
            r0 = 42
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x0378 }
            if (r6 != 0) goto L_0x033f
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x0378 }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zzb((java.lang.Long) r0)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x033f:
            boolean r0 = com.google.android.gms.internal.measurement.zzoj.zza()     // Catch:{ SQLiteException -> 0x0378 }
            if (r0 == 0) goto L_0x035a
            com.google.android.gms.measurement.internal.zzag r0 = r50.zze()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzbf.zzcm     // Catch:{ SQLiteException -> 0x0378 }
            boolean r0 = r0.zze(r2, r6)     // Catch:{ SQLiteException -> 0x0378 }
            if (r0 == 0) goto L_0x035a
            r0 = 43
            byte[] r0 = r4.getBlob(r0)     // Catch:{ SQLiteException -> 0x0378 }
            r5.zza((byte[]) r0)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x035a:
            r5.zzao()     // Catch:{ SQLiteException -> 0x0378 }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0378 }
            if (r0 == 0) goto L_0x0374
            com.google.android.gms.measurement.internal.zzfw r0 = r50.zzj()     // Catch:{ SQLiteException -> 0x0378 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x0378 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r51)     // Catch:{ SQLiteException -> 0x0378 }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0378 }
        L_0x0374:
            r4.close()
            return r5
        L_0x0378:
            r0 = move-exception
            goto L_0x037e
        L_0x037a:
            r0 = move-exception
            goto L_0x0397
        L_0x037c:
            r0 = move-exception
            r4 = r3
        L_0x037e:
            com.google.android.gms.measurement.internal.zzfw r5 = r50.zzj()     // Catch:{ all -> 0x0395 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzg()     // Catch:{ all -> 0x0395 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r51)     // Catch:{ all -> 0x0395 }
            r5.zza(r6, r2, r0)     // Catch:{ all -> 0x0395 }
            if (r4 == 0) goto L_0x0394
            r4.close()
        L_0x0394:
            return r3
        L_0x0395:
            r0 = move-exception
            r3 = r4
        L_0x0397:
            if (r3 == 0) goto L_0x039c
            r3.close()
        L_0x039c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzan zzf(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzt()
            r11.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.e_()     // Catch:{ SQLiteException -> 0x006a, all -> 0x0068 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch:{ SQLiteException -> 0x006a, all -> 0x0068 }
            java.lang.String r4 = "app_id=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x006a, all -> 0x0068 }
            r10 = 0
            r5[r10] = r12     // Catch:{ SQLiteException -> 0x006a, all -> 0x0068 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x006a, all -> 0x0068 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0066 }
            if (r2 != 0) goto L_0x0033
            r1.close()
            return r0
        L_0x0033:
            byte[] r2 = r1.getBlob(r10)     // Catch:{ SQLiteException -> 0x0066 }
            java.lang.String r3 = r1.getString(r9)     // Catch:{ SQLiteException -> 0x0066 }
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLiteException -> 0x0066 }
            boolean r5 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0066 }
            if (r5 == 0) goto L_0x0057
            com.google.android.gms.measurement.internal.zzfw r5 = r11.zzj()     // Catch:{ SQLiteException -> 0x0066 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzg()     // Catch:{ SQLiteException -> 0x0066 }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0066 }
            r5.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0066 }
        L_0x0057:
            if (r2 != 0) goto L_0x005d
            r1.close()
            return r0
        L_0x005d:
            com.google.android.gms.measurement.internal.zzan r5 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ SQLiteException -> 0x0066 }
            r5.<init>(r2, r3, r4)     // Catch:{ SQLiteException -> 0x0066 }
            r1.close()
            return r5
        L_0x0066:
            r2 = move-exception
            goto L_0x006c
        L_0x0068:
            r12 = move-exception
            goto L_0x0085
        L_0x006a:
            r2 = move-exception
            r1 = r0
        L_0x006c:
            com.google.android.gms.measurement.internal.zzfw r3 = r11.zzj()     // Catch:{ all -> 0x0083 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r12)     // Catch:{ all -> 0x0083 }
            r3.zza(r4, r12, r2)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0082
            r1.close()
        L_0x0082:
            return r0
        L_0x0083:
            r12 = move-exception
            r0 = r1
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.close()
        L_0x008a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzf(java.lang.String):com.google.android.gms.measurement.internal.zzan");
    }

    public final zzav zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzav.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzin zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        return zzin.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzin zzi(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzal();
        zzin zzin = (zzin) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzao());
        return zzin == null ? zzin.zza : zzin;
    }

    public final List<zzmu> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", (String) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                if (string == null) {
                    string = "";
                }
                arrayList.add(new zzmu(string, cursor.getLong(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
            cursor.close();
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying trigger uris. appId", zzfw.zza(str), e);
            List<zzmu> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zznq> zzk(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                if (string2 == null) {
                    string2 = "";
                }
                String str2 = string2;
                long j = cursor.getLong(2);
                Object zza2 = zza(cursor, 3);
                if (zza2 == null) {
                    zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzfw.zza(str));
                } else {
                    arrayList.add(new zznq(str, str2, string, j, zza2));
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying user properties. appId", zzfw.zza(str), e);
            List<zznq> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final Map<Integer, zzfn.zzm> zzl(String str) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, zzfn.zzm> emptyMap = Collections.emptyMap();
                cursor.close();
                return emptyMap;
            }
            ArrayMap arrayMap = new ArrayMap();
            do {
                int i = cursor.getInt(0);
                try {
                    arrayMap.put(Integer.valueOf(i), (zzfn.zzm) ((zzjk) ((zzfn.zzm.zza) zznl.zza(zzfn.zzm.zze(), cursor.getBlob(1))).zzai()));
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzfw.zza(str), Integer.valueOf(i), e);
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filter results. appId", zzfw.zza(str), e2);
            Map<Integer, zzfn.zzm> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzff.zzb>> zzm(java.lang.String r13) {
        /*
            r12 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.e_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.String r4 = "app_id=?"
            r10 = 1
            java.lang.String[] r5 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0094 }
            r11 = 0
            r5[r11] = r13     // Catch:{ SQLiteException -> 0x0094 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0094 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            if (r2 != 0) goto L_0x0034
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            r1.close()
            return r13
        L_0x0034:
            byte[] r2 = r1.getBlob(r10)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            com.google.android.gms.internal.measurement.zzff$zzb$zza r3 = com.google.android.gms.internal.measurement.zzff.zzb.zzc()     // Catch:{ IOException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzks r2 = com.google.android.gms.measurement.internal.zznl.zza(r3, (byte[]) r2)     // Catch:{ IOException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzff$zzb$zza r2 = (com.google.android.gms.internal.measurement.zzff.zzb.zza) r2     // Catch:{ IOException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzkt r2 = r2.zzai()     // Catch:{ IOException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch:{ IOException -> 0x0070 }
            com.google.android.gms.internal.measurement.zzff$zzb r2 = (com.google.android.gms.internal.measurement.zzff.zzb) r2     // Catch:{ IOException -> 0x0070 }
            boolean r3 = r2.zzk()     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            if (r3 == 0) goto L_0x0082
            int r3 = r1.getInt(r11)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            java.lang.Object r4 = r0.getOrDefault(r4, r9)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            if (r4 != 0) goto L_0x006c
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            r4.<init>()     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
        L_0x006c:
            r4.add(r2)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            goto L_0x0082
        L_0x0070:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfw r3 = r12.zzj()     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            java.lang.String r4 = "Failed to merge filter. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            r3.zza(r4, r5, r2)     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
        L_0x0082:
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x008f, all -> 0x008c }
            if (r2 != 0) goto L_0x0034
            r1.close()
            return r0
        L_0x008c:
            r13 = move-exception
            r9 = r1
            goto L_0x00b0
        L_0x008f:
            r0 = move-exception
            r9 = r1
            goto L_0x0095
        L_0x0092:
            r13 = move-exception
            goto L_0x00b0
        L_0x0094:
            r0 = move-exception
        L_0x0095:
            com.google.android.gms.measurement.internal.zzfw r1 = r12.zzj()     // Catch:{ all -> 0x0092 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ all -> 0x0092 }
            r1.zza(r2, r13, r0)     // Catch:{ all -> 0x0092 }
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0092 }
            if (r9 == 0) goto L_0x00af
            r9.close()
        L_0x00af:
            return r13
        L_0x00b0:
            if (r9 == 0) goto L_0x00b5
            r9.close()
        L_0x00b5:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzm(java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzn(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzal()
            r7.zzt()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.e_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0069 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x0069 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x0069 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0069 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            if (r3 != 0) goto L_0x0030
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            r1.close()
            return r8
        L_0x0030:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            java.lang.Object r4 = r0.getOrDefault(r4, r2)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            if (r4 != 0) goto L_0x004c
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
        L_0x004c:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0064, all -> 0x0061 }
            if (r3 != 0) goto L_0x0030
            r1.close()
            return r0
        L_0x0061:
            r8 = move-exception
            r2 = r1
            goto L_0x0085
        L_0x0064:
            r0 = move-exception
            r2 = r1
            goto L_0x006a
        L_0x0067:
            r8 = move-exception
            goto L_0x0085
        L_0x0069:
            r0 = move-exception
        L_0x006a:
            com.google.android.gms.measurement.internal.zzfw r1 = r7.zzj()     // Catch:{ all -> 0x0067 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x0067 }
            java.lang.String r3 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ all -> 0x0067 }
            r1.zza(r3, r8, r0)     // Catch:{ all -> 0x0067 }
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x0084
            r2.close()
        L_0x0084:
            return r8
        L_0x0085:
            if (r2 == 0) goto L_0x008a
            r2.close()
        L_0x008a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzn(java.lang.String):java.util.Map");
    }

    public final void zzo(String str) {
        zzaz zzd2;
        zzi("events_snapshot", str);
        Cursor cursor = null;
        try {
            cursor = e_().query("events", (String[]) Collections.singletonList(AppMeasurementSdk.ConditionalUserProperty.NAME).toArray(new String[0]), "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return;
            }
            do {
                String string = cursor.getString(0);
                if (!(string == null || (zzd2 = zzd(str, string)) == null)) {
                    zza("events_snapshot", zzd2);
                }
            } while (cursor.moveToNext());
            cursor.close();
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error creating snapshot. appId", zzfw.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzp() {
        zzal();
        e_().beginTransaction();
    }

    public final void zzu() {
        zzal();
        e_().endTransaction();
    }

    public final void zzv() {
        int delete;
        zzt();
        zzal();
        if (zzaa()) {
            long zza2 = zzn().zza.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzbf.zzy.zza(null).longValue()) {
                zzn().zza.zza(elapsedRealtime);
                zzt();
                zzal();
                if (zzaa() && (delete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzag.zzm())})) > 0) {
                    zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final void zzw() {
        zzal();
        e_().setTransactionSuccessful();
    }

    public final boolean zzx() {
        if (zzb("select count(1) > 0 from raw_events", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzy() {
        if (zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzz() {
        if (zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzfw.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        if ("_v".equals(r13) != false) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fe A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "events_snapshot"
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r4 = "name"
            java.lang.String r5 = "lifetime_count"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r0.<init>(r4)
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzaz r5 = r1.zzd(r2, r4)
            java.lang.String r6 = "_v"
            com.google.android.gms.measurement.internal.zzaz r7 = r1.zzd(r2, r6)
            java.lang.String r8 = "events"
            r1.zzi(r8, r2)
            r9 = 0
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.e_()     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            java.lang.String r12 = "events_snapshot"
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            java.lang.Object[] r0 = r0.toArray(r13)     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            r13 = r0
            java.lang.String[] r13 = (java.lang.String[]) r13     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            java.lang.String r14 = "app_id=?"
            r0 = 1
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            r15[r9] = r2     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r10 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x00cb, all -> 0x00c8 }
            if (r11 != 0) goto L_0x0062
            r10.close()
            if (r5 == 0) goto L_0x0059
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r5)
            goto L_0x005e
        L_0x0059:
            if (r7 == 0) goto L_0x005e
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r7)
        L_0x005e:
            r1.zzi(r3, r2)
            return
        L_0x0062:
            r11 = r9
            r12 = r11
        L_0x0064:
            java.lang.String r13 = r10.getString(r9)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzag r14 = r19.zze()     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzbf.zzcx     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            boolean r14 = r14.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r15)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            if (r14 == 0) goto L_0x008c
            long r14 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            r16 = 1
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 < 0) goto L_0x009b
            boolean r14 = r4.equals(r13)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            if (r14 == 0) goto L_0x0085
            goto L_0x0092
        L_0x0085:
            boolean r14 = r6.equals(r13)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            if (r14 == 0) goto L_0x009b
            goto L_0x009a
        L_0x008c:
            boolean r14 = r4.equals(r13)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            if (r14 == 0) goto L_0x0094
        L_0x0092:
            r11 = r0
            goto L_0x009b
        L_0x0094:
            boolean r14 = r6.equals(r13)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            if (r14 == 0) goto L_0x009b
        L_0x009a:
            r12 = r0
        L_0x009b:
            if (r13 == 0) goto L_0x00a6
            com.google.android.gms.measurement.internal.zzaz r13 = r1.zzc(r3, r2, r13)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            if (r13 == 0) goto L_0x00a6
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r13)     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
        L_0x00a6:
            boolean r13 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x00c5, all -> 0x00c2 }
            if (r13 != 0) goto L_0x0064
            r10.close()
            if (r11 != 0) goto L_0x00b7
            if (r5 == 0) goto L_0x00b7
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r5)
            goto L_0x00be
        L_0x00b7:
            if (r12 != 0) goto L_0x00be
            if (r7 == 0) goto L_0x00be
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r7)
        L_0x00be:
            r1.zzi(r3, r2)
            return
        L_0x00c2:
            r0 = move-exception
            r9 = r11
            goto L_0x00f7
        L_0x00c5:
            r0 = move-exception
            r9 = r11
            goto L_0x00cd
        L_0x00c8:
            r0 = move-exception
            r12 = r9
            goto L_0x00f7
        L_0x00cb:
            r0 = move-exception
            r12 = r9
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzfw r4 = r19.zzj()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzg()     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = "Error querying snapshot. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r20)     // Catch:{ all -> 0x00f6 }
            r4.zza(r6, r11, r0)     // Catch:{ all -> 0x00f6 }
            if (r10 == 0) goto L_0x00e3
            r10.close()
        L_0x00e3:
            if (r9 != 0) goto L_0x00eb
            if (r5 == 0) goto L_0x00eb
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r5)
            goto L_0x00f2
        L_0x00eb:
            if (r12 != 0) goto L_0x00f2
            if (r7 == 0) goto L_0x00f2
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r7)
        L_0x00f2:
            r1.zzi(r3, r2)
            return
        L_0x00f6:
            r0 = move-exception
        L_0x00f7:
            if (r10 == 0) goto L_0x00fc
            r10.close()
        L_0x00fc:
            if (r9 != 0) goto L_0x0105
            if (r5 != 0) goto L_0x0101
            goto L_0x0105
        L_0x0101:
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r5)
            goto L_0x010c
        L_0x0105:
            if (r12 != 0) goto L_0x010c
            if (r7 == 0) goto L_0x010c
            r1.zza((java.lang.String) r8, (com.google.android.gms.measurement.internal.zzaz) r7)
        L_0x010c:
            r1.zzi(r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzp(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzae zzc(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzt()
            r29.zzal()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.e_()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            if (r3 != 0) goto L_0x004c
            r9.close()
            return r8
        L_0x004c:
            java.lang.String r3 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00f4, all -> 0x00f0 }
            if (r3 != 0) goto L_0x0054
            java.lang.String r3 = ""
        L_0x0054:
            r10 = r29
            r16 = r3
            java.lang.Object r5 = r10.zza((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x00ee }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00ee }
            if (r0 == 0) goto L_0x0065
            r20 = r2
            goto L_0x0067
        L_0x0065:
            r20 = r1
        L_0x0067:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00ee }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ee }
            com.google.android.gms.measurement.internal.zznl r0 = r29.g_()     // Catch:{ SQLiteException -> 0x00ee }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ee }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbd> r2 = com.google.android.gms.measurement.internal.zzbd.CREATOR     // Catch:{ SQLiteException -> 0x00ee }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ee }
            r22 = r0
            com.google.android.gms.measurement.internal.zzbd r22 = (com.google.android.gms.measurement.internal.zzbd) r22     // Catch:{ SQLiteException -> 0x00ee }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ee }
            com.google.android.gms.measurement.internal.zznl r0 = r29.g_()     // Catch:{ SQLiteException -> 0x00ee }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ee }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ee }
            r25 = r0
            com.google.android.gms.measurement.internal.zzbd r25 = (com.google.android.gms.measurement.internal.zzbd) r25     // Catch:{ SQLiteException -> 0x00ee }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ee }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00ee }
            com.google.android.gms.measurement.internal.zznl r0 = r29.g_()     // Catch:{ SQLiteException -> 0x00ee }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00ee }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00ee }
            r28 = r0
            com.google.android.gms.measurement.internal.zzbd r28 = (com.google.android.gms.measurement.internal.zzbd) r28     // Catch:{ SQLiteException -> 0x00ee }
            com.google.android.gms.measurement.internal.zzno r17 = new com.google.android.gms.measurement.internal.zzno     // Catch:{ SQLiteException -> 0x00ee }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00ee }
            com.google.android.gms.measurement.internal.zzae r0 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ SQLiteException -> 0x00ee }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00ee }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00ee }
            if (r1 == 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.zzfw r1 = r29.zzj()     // Catch:{ SQLiteException -> 0x00ee }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ SQLiteException -> 0x00ee }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r30)     // Catch:{ SQLiteException -> 0x00ee }
            com.google.android.gms.measurement.internal.zzfr r4 = r29.zzi()     // Catch:{ SQLiteException -> 0x00ee }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x00ee }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00ee }
        L_0x00ea:
            r9.close()
            return r0
        L_0x00ee:
            r0 = move-exception
            goto L_0x0100
        L_0x00f0:
            r0 = move-exception
            r10 = r29
            goto L_0x0120
        L_0x00f4:
            r0 = move-exception
            r10 = r29
            goto L_0x0100
        L_0x00f8:
            r0 = move-exception
            r10 = r29
            goto L_0x0121
        L_0x00fc:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x0100:
            com.google.android.gms.measurement.internal.zzfw r1 = r29.zzj()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x011f }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r30)     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzfr r4 = r29.zzi()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x011f }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x011f }
            if (r9 == 0) goto L_0x011e
            r9.close()
        L_0x011e:
            return r8
        L_0x011f:
            r0 = move-exception
        L_0x0120:
            r8 = r9
        L_0x0121:
            if (r8 == 0) goto L_0x0126
            r8.close()
        L_0x0126:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzae");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzff.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzal()
            r12.zzt()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.e_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x009a }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x009a }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x009a }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009a }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r14.close()
            return r13
        L_0x0040:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            com.google.android.gms.internal.measurement.zzff$zze$zza r2 = com.google.android.gms.internal.measurement.zzff.zze.zzc()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzks r1 = com.google.android.gms.measurement.internal.zznl.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzff$zze$zza r1 = (com.google.android.gms.internal.measurement.zzff.zze.zza) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzkt r1 = r1.zzai()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjk r1 = (com.google.android.gms.internal.measurement.zzjk) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzff$zze r1 = (com.google.android.gms.internal.measurement.zzff.zze) r1     // Catch:{ IOException -> 0x0076 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.Object r3 = r0.getOrDefault(r3, r9)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r3 != 0) goto L_0x0072
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
        L_0x0072:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            goto L_0x0088
        L_0x0076:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfw r2 = r12.zzj()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            r14.close()
            return r0
        L_0x0092:
            r13 = move-exception
            r9 = r14
            goto L_0x00b6
        L_0x0095:
            r0 = move-exception
            r9 = r14
            goto L_0x009b
        L_0x0098:
            r13 = move-exception
            goto L_0x00b6
        L_0x009a:
            r0 = move-exception
        L_0x009b:
            com.google.android.gms.measurement.internal.zzfw r14 = r12.zzj()     // Catch:{ all -> 0x0098 }
            com.google.android.gms.measurement.internal.zzfy r14 = r14.zzg()     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ all -> 0x0098 }
            r14.zza(r1, r13, r0)     // Catch:{ all -> 0x0098 }
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0098 }
            if (r9 == 0) goto L_0x00b5
            r9.close()
        L_0x00b5:
            return r13
        L_0x00b6:
            if (r9 == 0) goto L_0x00bb
            r9.close()
        L_0x00bb:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzfw.zza(str), zzi().zzc(str2), e);
        }
    }

    private final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzal();
        try {
            e_().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzfw.zza(str2), e);
        }
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        try {
            return (long) e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zze().zzb(str, zzbf.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzfw.zza(str), e);
            return 0;
        }
    }

    public final zzaz zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    public final long zza(zzfn.zzk zzk2) throws IOException {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzk2);
        Preconditions.checkNotEmpty(zzk2.zzz());
        byte[] zzbz = zzk2.zzbz();
        long zza2 = g_().zza(zzbz);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzk2.zzz());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza2));
        contentValues.put("metadata", zzbz);
        try {
            e_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzfw.zza(zzk2.zzz()), e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzff.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzal()
            r12.zzt()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.e_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x009a }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x009a }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x009a }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009a }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r14.close()
            return r13
        L_0x0040:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            com.google.android.gms.internal.measurement.zzff$zzb$zza r2 = com.google.android.gms.internal.measurement.zzff.zzb.zzc()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzks r1 = com.google.android.gms.measurement.internal.zznl.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzff$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzff.zzb.zza) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzkt r1 = r1.zzai()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjk r1 = (com.google.android.gms.internal.measurement.zzjk) r1     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzff$zzb r1 = (com.google.android.gms.internal.measurement.zzff.zzb) r1     // Catch:{ IOException -> 0x0076 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.Object r3 = r0.getOrDefault(r3, r9)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r3 != 0) goto L_0x0072
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
        L_0x0072:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            goto L_0x0088
        L_0x0076:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfw r2 = r12.zzj()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0095, all -> 0x0092 }
            if (r1 != 0) goto L_0x0040
            r14.close()
            return r0
        L_0x0092:
            r13 = move-exception
            r9 = r14
            goto L_0x00b6
        L_0x0095:
            r0 = move-exception
            r9 = r14
            goto L_0x009b
        L_0x0098:
            r13 = move-exception
            goto L_0x00b6
        L_0x009a:
            r0 = move-exception
        L_0x009b:
            com.google.android.gms.measurement.internal.zzfw r14 = r12.zzj()     // Catch:{ all -> 0x0098 }
            com.google.android.gms.measurement.internal.zzfy r14 = r14.zzg()     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r13)     // Catch:{ all -> 0x0098 }
            r14.zza(r1, r13, r0)     // Catch:{ all -> 0x0098 }
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0098 }
            if (r9 == 0) goto L_0x00b5
            r9.close()
        L_0x00b5:
            return r13
        L_0x00b6:
            if (r9 == 0) goto L_0x00bb
            r9.close()
        L_0x00bb:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                cursor.close();
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzaz zzc(java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
            r25 = this;
            r15 = r28
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            r25.zzt()
            r25.zzal()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r1 = "lifetime_count"
            java.lang.String r2 = "current_bundle_count"
            java.lang.String r3 = "last_fire_timestamp"
            java.lang.String r4 = "last_bundled_timestamp"
            java.lang.String r5 = "last_bundled_day"
            java.lang.String r6 = "last_sampled_complex_event_id"
            java.lang.String r7 = "last_sampling_rate"
            java.lang.String r8 = "last_exempt_from_sampling"
            java.lang.String r9 = "current_session_count"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r1 = r25.e_()     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r9 = 0
            java.lang.String[] r2 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.Object[] r0 = r0.toArray(r2)     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r3 = r0
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            java.lang.String r4 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r5[r9] = r27     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r10 = 1
            r5[r10] = r15     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r26
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0122, all -> 0x0120 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r1 != 0) goto L_0x005a
            r14.close()
            return r18
        L_0x005a:
            long r4 = r14.getLong(r9)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            long r6 = r14.getLong(r10)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            long r11 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r0 = 3
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r2 = 0
            if (r1 == 0) goto L_0x0072
            r16 = r2
            goto L_0x0078
        L_0x0072:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r16 = r0
        L_0x0078:
            r0 = 4
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r1 == 0) goto L_0x0082
            r0 = r18
            goto L_0x008a
        L_0x0082:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
        L_0x008a:
            r1 = 5
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x0094
            r19 = r18
            goto L_0x009e
        L_0x0094:
            long r19 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r1 = java.lang.Long.valueOf(r19)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r19 = r1
        L_0x009e:
            r1 = 6
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x00a8
            r20 = r18
            goto L_0x00b2
        L_0x00a8:
            long r20 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            java.lang.Long r1 = java.lang.Long.valueOf(r20)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r20 = r1
        L_0x00b2:
            r1 = 7
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 != 0) goto L_0x00cd
            long r21 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x00cb }
            r23 = 1
            int r1 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x00c4
            r9 = r10
        L_0x00c4:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)     // Catch:{ SQLiteException -> 0x00cb }
            r21 = r1
            goto L_0x00cf
        L_0x00cb:
            r0 = move-exception
            goto L_0x0125
        L_0x00cd:
            r21 = r18
        L_0x00cf:
            r1 = 8
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            if (r8 == 0) goto L_0x00d9
            r8 = r2
            goto L_0x00de
        L_0x00d9:
            long r1 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r8 = r1
        L_0x00de:
            com.google.android.gms.measurement.internal.zzaz r22 = new com.google.android.gms.measurement.internal.zzaz     // Catch:{ SQLiteException -> 0x011c, all -> 0x0116 }
            r1 = r22
            r2 = r27
            r3 = r28
            r10 = r11
            r12 = r16
            r23 = r14
            r14 = r0
            r15 = r19
            r16 = r20
            r17 = r21
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            boolean r0 = r23.moveToNext()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            if (r0 == 0) goto L_0x010c
            com.google.android.gms.measurement.internal.zzfw r0 = r25.zzj()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r27)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0110 }
        L_0x010c:
            r23.close()
            return r22
        L_0x0110:
            r0 = move-exception
            goto L_0x0119
        L_0x0112:
            r0 = move-exception
            r14 = r23
            goto L_0x0125
        L_0x0116:
            r0 = move-exception
            r23 = r14
        L_0x0119:
            r18 = r23
            goto L_0x0149
        L_0x011c:
            r0 = move-exception
            r23 = r14
            goto L_0x0125
        L_0x0120:
            r0 = move-exception
            goto L_0x0149
        L_0x0122:
            r0 = move-exception
            r14 = r18
        L_0x0125:
            com.google.android.gms.measurement.internal.zzfw r1 = r25.zzj()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r27)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.measurement.internal.zzfr r4 = r25.zzi()     // Catch:{ all -> 0x0146 }
            r5 = r28
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0146 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0146 }
            if (r14 == 0) goto L_0x0145
            r14.close()
        L_0x0145:
            return r18
        L_0x0146:
            r0 = move-exception
            r18 = r14
        L_0x0149:
            if (r18 == 0) goto L_0x014e
            r18.close()
        L_0x014e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzc(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaz");
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = e_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            }
            rawQuery.close();
            return j;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f2, code lost:
        r13 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fa, code lost:
        r13 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fe, code lost:
        r13 = r22;
        r12 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0122, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v3 android.database.Cursor) = (r2v0 android.database.Cursor), (r2v0 android.database.Cursor), (r2v0 android.database.Cursor), (r2v5 android.database.Cursor), (r2v0 android.database.Cursor) binds: [B:1:0x0011, B:2:?, B:4:0x0019, B:18:0x008f, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zznq> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            r22 = this;
            r0 = r25
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzt()
            r22.zzal()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00f9 }
            r4 = 3
            r3.<init>(r4)     // Catch:{ SQLiteException -> 0x00fd, all -> 0x00f9 }
            r12 = r23
            r3.add(r12)     // Catch:{ SQLiteException -> 0x00f5, all -> 0x00f9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00f5, all -> 0x00f9 }
            java.lang.String r6 = "app_id=?"
            r5.<init>(r6)     // Catch:{ SQLiteException -> 0x00f5, all -> 0x00f9 }
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x00f5, all -> 0x00f9 }
            if (r6 != 0) goto L_0x0034
            r6 = r24
            r3.add(r6)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String r7 = " and origin=?"
            r5.append(r7)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            goto L_0x0036
        L_0x0034:
            r6 = r24
        L_0x0036:
            boolean r7 = android.text.TextUtils.isEmpty(r25)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            if (r7 != 0) goto L_0x0055
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r7.append(r0)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String r8 = "*"
            r7.append(r8)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r3.add(r7)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String r7 = " and name glob ?"
            r5.append(r7)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
        L_0x0055:
            int r7 = r3.size()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.Object[] r3 = r3.toArray(r7)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r17 = r3
            java.lang.String[] r17 = (java.lang.String[]) r17     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            android.database.sqlite.SQLiteDatabase r13 = r22.e_()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String r14 = "user_attributes"
            java.lang.String r3 = "name"
            java.lang.String r7 = "set_timestamp"
            java.lang.String r8 = "value"
            java.lang.String r9 = "origin"
            java.lang.String[] r15 = new java.lang.String[]{r3, r7, r8, r9}     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String r16 = r5.toString()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "1001"
            android.database.Cursor r2 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            if (r3 != 0) goto L_0x008f
            r2.close()
            return r1
        L_0x008f:
            int r3 = r1.size()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r5) goto L_0x00ab
            com.google.android.gms.measurement.internal.zzfw r0 = r22.zzj()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r0.zza(r3, r4)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r13 = r22
            goto L_0x00e6
        L_0x00ab:
            r3 = 0
            java.lang.String r8 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r3 = 1
            long r9 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x00f9 }
            r3 = 2
            r13 = r22
            java.lang.Object r11 = r13.zza((android.database.Cursor) r2, (int) r3)     // Catch:{ SQLiteException -> 0x00ef }
            java.lang.String r3 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x00ef }
            if (r11 != 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzfw r5 = r22.zzj()     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzg()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r6 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r23)     // Catch:{ SQLiteException -> 0x00ec }
            r5.zza(r6, r7, r3, r0)     // Catch:{ SQLiteException -> 0x00ec }
            goto L_0x00e0
        L_0x00d4:
            com.google.android.gms.measurement.internal.zznq r14 = new com.google.android.gms.measurement.internal.zznq     // Catch:{ SQLiteException -> 0x00ec }
            r5 = r14
            r6 = r23
            r7 = r3
            r5.<init>(r6, r7, r8, r9, r11)     // Catch:{ SQLiteException -> 0x00ec }
            r1.add(r14)     // Catch:{ SQLiteException -> 0x00ec }
        L_0x00e0:
            boolean r5 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00ec }
            if (r5 != 0) goto L_0x00ea
        L_0x00e6:
            r2.close()
            return r1
        L_0x00ea:
            r6 = r3
            goto L_0x008f
        L_0x00ec:
            r0 = move-exception
            r6 = r3
            goto L_0x0104
        L_0x00ef:
            r0 = move-exception
            goto L_0x0104
        L_0x00f1:
            r0 = move-exception
            r13 = r22
            goto L_0x0104
        L_0x00f5:
            r0 = move-exception
            r13 = r22
            goto L_0x0102
        L_0x00f9:
            r0 = move-exception
            r13 = r22
            goto L_0x0120
        L_0x00fd:
            r0 = move-exception
            r13 = r22
            r12 = r23
        L_0x0102:
            r6 = r24
        L_0x0104:
            com.google.android.gms.measurement.internal.zzfw r1 = r22.zzj()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r23)     // Catch:{ all -> 0x011f }
            r1.zza(r3, r4, r6, r0)     // Catch:{ all -> 0x011f }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x011e
            r2.close()
        L_0x011e:
            return r0
        L_0x011f:
            r0 = move-exception
        L_0x0120:
            if (r2 == 0) goto L_0x0125
            r2.close()
        L_0x0125:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzfn.zzf, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzt()
            r7.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.e_()     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0075, all -> 0x0073 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0071 }
            if (r2 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzfw r8 = r7.zzj()     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzp()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r0
        L_0x0035:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0071 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r4 = com.google.android.gms.internal.measurement.zzfn.zzf.zze()     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzks r2 = com.google.android.gms.measurement.internal.zznl.zza(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzfn$zzf$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zzf.zza) r2     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzkt r2 = r2.zzai()     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch:{ IOException -> 0x005b }
            com.google.android.gms.internal.measurement.zzfn$zzf r2 = (com.google.android.gms.internal.measurement.zzfn.zzf) r2     // Catch:{ IOException -> 0x005b }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r8
        L_0x005b:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfw r3 = r7.zzj()     // Catch:{ SQLiteException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch:{ SQLiteException -> 0x0071 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0071 }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0071 }
            r1.close()
            return r0
        L_0x0071:
            r8 = move-exception
            goto L_0x0077
        L_0x0073:
            r8 = move-exception
            goto L_0x008c
        L_0x0075:
            r8 = move-exception
            r1 = r0
        L_0x0077:
            com.google.android.gms.measurement.internal.zzfw r9 = r7.zzj()     // Catch:{ all -> 0x008a }
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzg()     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            return r0
        L_0x008a:
            r8 = move-exception
            r0 = r1
        L_0x008c:
            if (r0 == 0) goto L_0x0091
            r0.close()
        L_0x0091:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final zzaq zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return zza(j, str, 1, false, false, z3, false, z5, z6);
    }

    public final zzaq zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        String[] strArr = {str};
        zzaq zzaq = new zzaq();
        Cursor cursor = null;
        try {
            SQLiteDatabase e_ = e_();
            cursor = e_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzfw.zza(str));
                cursor.close();
                return zzaq;
            }
            if (cursor.getLong(0) == j) {
                zzaq.zzb = cursor.getLong(1);
                zzaq.zza = cursor.getLong(2);
                zzaq.zzc = cursor.getLong(3);
                zzaq.zzd = cursor.getLong(4);
                zzaq.zze = cursor.getLong(5);
                zzaq.zzf = cursor.getLong(6);
            }
            if (z) {
                zzaq.zzb += j2;
            }
            if (z2) {
                zzaq.zza += j2;
            }
            if (z3) {
                zzaq.zzc += j2;
            }
            if (z4) {
                zzaq.zzd += j2;
            }
            if (z5) {
                zzaq.zze += j2;
            }
            if (z6) {
                zzaq.zzf += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzaq.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzaq.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzaq.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzaq.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzaq.zze));
            contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzaq.zzf));
            e_.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return zzaq;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error updating daily counts. appId", zzfw.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzaq;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zznq zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzt()
            r18.zzal()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.e_()     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0084, all -> 0x0080 }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x007c, all -> 0x0078 }
            if (r3 != 0) goto L_0x003d
            r10.close()
            return r9
        L_0x003d:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x007c, all -> 0x0078 }
            r11 = r18
            java.lang.Object r7 = r11.zza((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x0076 }
            if (r7 != 0) goto L_0x004d
            r10.close()
            return r9
        L_0x004d:
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zznq r0 = new com.google.android.gms.measurement.internal.zznq     // Catch:{ SQLiteException -> 0x0076 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0076 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0076 }
            if (r1 == 0) goto L_0x0072
            com.google.android.gms.measurement.internal.zzfw r1 = r18.zzj()     // Catch:{ SQLiteException -> 0x0076 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0076 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0076 }
        L_0x0072:
            r10.close()
            return r0
        L_0x0076:
            r0 = move-exception
            goto L_0x0088
        L_0x0078:
            r0 = move-exception
            r11 = r18
            goto L_0x00a8
        L_0x007c:
            r0 = move-exception
            r11 = r18
            goto L_0x0088
        L_0x0080:
            r0 = move-exception
            r11 = r18
            goto L_0x00a9
        L_0x0084:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0088:
            com.google.android.gms.measurement.internal.zzfw r1 = r18.zzj()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r19)     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzfr r4 = r18.zzi()     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00a7 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00a7 }
            if (r10 == 0) goto L_0x00a6
            r10.close()
        L_0x00a6:
            return r9
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            r9 = r10
        L_0x00a9:
            if (r9 == 0) goto L_0x00ae
            r9.close()
        L_0x00ae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zznq");
    }

    public final void zzb(String str, zzin zzin) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzin);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzin.zzh());
        contentValues.put("consent_source", Integer.valueOf(zzin.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzal();
        zzt();
        SQLiteDatabase e_ = e_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zze().zzb(str, zzbf.zzaf)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            return e_.delete("audience_filter_values", lf.j("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", lf.j("(", TextUtils.join(",", arrayList), ")"), " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzas<T> r5) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.e_()     // Catch:{ SQLiteException -> 0x002c, all -> 0x002a }
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x002c, all -> 0x002a }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0028 }
            if (r4 != 0) goto L_0x0020
            com.google.android.gms.measurement.internal.zzfw r4 = r2.zzj()     // Catch:{ SQLiteException -> 0x0028 }
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzp()     // Catch:{ SQLiteException -> 0x0028 }
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch:{ SQLiteException -> 0x0028 }
            r3.close()
            return r0
        L_0x0020:
            java.lang.Object r4 = r5.zza(r3)     // Catch:{ SQLiteException -> 0x0028 }
            r3.close()
            return r4
        L_0x0028:
            r4 = move-exception
            goto L_0x002e
        L_0x002a:
            r4 = move-exception
            goto L_0x0043
        L_0x002c:
            r4 = move-exception
            r3 = r0
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfw r5 = r2.zzj()     // Catch:{ all -> 0x0041 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzg()     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x0040
            r3.close()
        L_0x0040:
            return r0
        L_0x0041:
            r4 = move-exception
            r0 = r3
        L_0x0043:
            if (r0 == 0) goto L_0x0048
            r0.close()
        L_0x0048:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzas):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzt()
            r4.zzal()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.e_()     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003e, all -> 0x003c }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003a }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzfw r6 = r4.zzj()     // Catch:{ SQLiteException -> 0x003a }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch:{ SQLiteException -> 0x003a }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003a }
            r5.close()
            return r0
        L_0x0032:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003a }
            r5.close()
            return r6
        L_0x003a:
            r6 = move-exception
            goto L_0x0040
        L_0x003c:
            r6 = move-exception
            goto L_0x0055
        L_0x003e:
            r6 = move-exception
            r5 = r0
        L_0x0040:
            com.google.android.gms.measurement.internal.zzfw r1 = r4.zzj()     // Catch:{ all -> 0x0053 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0053 }
            if (r5 == 0) goto L_0x0052
            r5.close()
        L_0x0052:
            return r0
        L_0x0053:
            r6 = move-exception
            r0 = r5
        L_0x0055:
            if (r0 == 0) goto L_0x005a
            r0.close()
        L_0x005a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(long):java.lang.String");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = e_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                rawQuery.close();
                return string;
            }
            rawQuery.close();
            return str2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x016f A[EDGE_INSN: B:84:0x016f->B:72:0x016f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzfn.zzk, java.lang.Long>> zza(java.lang.String r19, int r20, int r21) {
        /*
            r18 = this;
            r1 = r21
            r18.zzt()
            r18.zzal()
            r2 = 1
            r3 = 0
            if (r20 <= 0) goto L_0x000e
            r0 = r2
            goto L_0x000f
        L_0x000e:
            r0 = r3
        L_0x000f:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            if (r1 <= 0) goto L_0x0016
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            r4 = 0
            android.database.sqlite.SQLiteDatabase r5 = r18.e_()     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r6 = "queue"
            java.lang.String r0 = "rowid"
            java.lang.String r7 = "data"
            java.lang.String r8 = "retry_count"
            java.lang.String[] r7 = new java.lang.String[]{r0, r7, r8}     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r8 = "app_id=?"
            java.lang.String[] r9 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0175 }
            r9[r3] = r19     // Catch:{ SQLiteException -> 0x0175 }
            r10 = 0
            r11 = 0
            java.lang.String r12 = "rowid"
            java.lang.String r13 = java.lang.String.valueOf(r20)     // Catch:{ SQLiteException -> 0x0175 }
            android.database.Cursor r4 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x0175 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0175 }
            if (r0 != 0) goto L_0x004e
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0175 }
            r4.close()
            return r0
        L_0x004e:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0175 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0175 }
            r6 = r3
        L_0x0054:
            long r7 = r4.getLong(r3)     // Catch:{ SQLiteException -> 0x0175 }
            byte[] r0 = r4.getBlob(r2)     // Catch:{ IOException -> 0x0151 }
            com.google.android.gms.measurement.internal.zznl r9 = r18.g_()     // Catch:{ IOException -> 0x0151 }
            byte[] r0 = r9.zzc((byte[]) r0)     // Catch:{ IOException -> 0x0151 }
            boolean r9 = r5.isEmpty()     // Catch:{ SQLiteException -> 0x0175 }
            if (r9 != 0) goto L_0x006e
            int r9 = r0.length     // Catch:{ SQLiteException -> 0x0175 }
            int r9 = r9 + r6
            if (r9 > r1) goto L_0x016f
        L_0x006e:
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r9 = com.google.android.gms.internal.measurement.zzfn.zzk.zzw()     // Catch:{ IOException -> 0x013e }
            com.google.android.gms.internal.measurement.zzks r9 = com.google.android.gms.measurement.internal.zznl.zza(r9, (byte[]) r0)     // Catch:{ IOException -> 0x013e }
            com.google.android.gms.internal.measurement.zzfn$zzk$zza r9 = (com.google.android.gms.internal.measurement.zzfn.zzk.zza) r9     // Catch:{ IOException -> 0x013e }
            boolean r10 = r5.isEmpty()     // Catch:{ SQLiteException -> 0x0175 }
            if (r10 != 0) goto L_0x011a
            java.lang.Object r10 = r5.get(r3)     // Catch:{ SQLiteException -> 0x0175 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.Object r10 = r10.first     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfn$zzk r10 = (com.google.android.gms.internal.measurement.zzfn.zzk) r10     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzkt r11 = r9.zzai()     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzjk r11 = (com.google.android.gms.internal.measurement.zzjk) r11     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfn$zzk r11 = (com.google.android.gms.internal.measurement.zzfn.zzk) r11     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r12 = r10.zzae()     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r13 = r11.zzae()     // Catch:{ SQLiteException -> 0x0175 }
            boolean r12 = r12.equals(r13)     // Catch:{ SQLiteException -> 0x0175 }
            if (r12 == 0) goto L_0x0117
            java.lang.String r12 = r10.zzad()     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r13 = r11.zzad()     // Catch:{ SQLiteException -> 0x0175 }
            boolean r12 = r12.equals(r13)     // Catch:{ SQLiteException -> 0x0175 }
            if (r12 == 0) goto L_0x0117
            boolean r12 = r10.zzau()     // Catch:{ SQLiteException -> 0x0175 }
            boolean r13 = r11.zzau()     // Catch:{ SQLiteException -> 0x0175 }
            if (r12 != r13) goto L_0x0117
            java.lang.String r12 = r10.zzaf()     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r13 = r11.zzaf()     // Catch:{ SQLiteException -> 0x0175 }
            boolean r12 = r12.equals(r13)     // Catch:{ SQLiteException -> 0x0175 }
            if (r12 == 0) goto L_0x0117
            java.util.List r10 = r10.zzas()     // Catch:{ SQLiteException -> 0x0175 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ SQLiteException -> 0x0175 }
        L_0x00cc:
            boolean r12 = r10.hasNext()     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r13 = "_npa"
            r14 = -1
            if (r12 == 0) goto L_0x00ed
            java.lang.Object r12 = r10.next()     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfn$zzo r12 = (com.google.android.gms.internal.measurement.zzfn.zzo) r12     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r2 = r12.zzg()     // Catch:{ SQLiteException -> 0x0175 }
            boolean r2 = r13.equals(r2)     // Catch:{ SQLiteException -> 0x0175 }
            if (r2 == 0) goto L_0x00eb
            long r16 = r12.zzc()     // Catch:{ SQLiteException -> 0x0175 }
            goto L_0x00ef
        L_0x00eb:
            r2 = 1
            goto L_0x00cc
        L_0x00ed:
            r16 = r14
        L_0x00ef:
            java.util.List r2 = r11.zzas()     // Catch:{ SQLiteException -> 0x0175 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ SQLiteException -> 0x0175 }
        L_0x00f7:
            boolean r10 = r2.hasNext()     // Catch:{ SQLiteException -> 0x0175 }
            if (r10 == 0) goto L_0x0111
            java.lang.Object r10 = r2.next()     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfn$zzo r10 = (com.google.android.gms.internal.measurement.zzfn.zzo) r10     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r11 = r10.zzg()     // Catch:{ SQLiteException -> 0x0175 }
            boolean r11 = r13.equals(r11)     // Catch:{ SQLiteException -> 0x0175 }
            if (r11 == 0) goto L_0x00f7
            long r14 = r10.zzc()     // Catch:{ SQLiteException -> 0x0175 }
        L_0x0111:
            int r2 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x0117
            r2 = 1
            goto L_0x0118
        L_0x0117:
            r2 = r3
        L_0x0118:
            if (r2 == 0) goto L_0x016f
        L_0x011a:
            r2 = 2
            boolean r10 = r4.isNull(r2)     // Catch:{ SQLiteException -> 0x0175 }
            if (r10 != 0) goto L_0x0128
            int r2 = r4.getInt(r2)     // Catch:{ SQLiteException -> 0x0175 }
            r9.zzi((int) r2)     // Catch:{ SQLiteException -> 0x0175 }
        L_0x0128:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0175 }
            int r6 = r6 + r0
            com.google.android.gms.internal.measurement.zzkt r0 = r9.zzai()     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzjk r0 = (com.google.android.gms.internal.measurement.zzjk) r0     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.internal.measurement.zzfn$zzk r0 = (com.google.android.gms.internal.measurement.zzfn.zzk) r0     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x0175 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0175 }
            r5.add(r0)     // Catch:{ SQLiteException -> 0x0175 }
            goto L_0x0163
        L_0x013e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r2 = r18.zzj()     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r7 = "Failed to merge queued bundle. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0175 }
            r2.zza(r7, r8, r0)     // Catch:{ SQLiteException -> 0x0175 }
            goto L_0x0163
        L_0x0151:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r2 = r18.zzj()     // Catch:{ SQLiteException -> 0x0175 }
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch:{ SQLiteException -> 0x0175 }
            java.lang.String r7 = "Failed to unzip queued bundle. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0175 }
            r2.zza(r7, r8, r0)     // Catch:{ SQLiteException -> 0x0175 }
        L_0x0163:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0175 }
            if (r0 == 0) goto L_0x016f
            if (r6 <= r1) goto L_0x016c
            goto L_0x016f
        L_0x016c:
            r2 = 1
            goto L_0x0054
        L_0x016f:
            r4.close()
            return r5
        L_0x0173:
            r0 = move-exception
            goto L_0x0191
        L_0x0175:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r1 = r18.zzj()     // Catch:{ all -> 0x0173 }
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch:{ all -> 0x0173 }
            java.lang.String r2 = "Error querying bundles. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r19)     // Catch:{ all -> 0x0173 }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x0173 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0173 }
            if (r4 == 0) goto L_0x0190
            r4.close()
        L_0x0190:
            return r0
        L_0x0191:
            if (r4 == 0) goto L_0x0196
            r4.close()
        L_0x0196:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(java.lang.String, int, int):java.util.List");
    }

    public final List<zzae> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzae> zza(String str, String[] strArr) {
        zzt();
        zzal();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("conditional_properties", new String[]{"app_id", "origin", AppMeasurementSdk.ConditionalUserProperty.NAME, "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza2 = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    zznl g_ = g_();
                    byte[] blob = cursor.getBlob(7);
                    Parcelable.Creator creator = zzbd.CREATOR;
                    boolean z2 = z;
                    zzae zzae = r3;
                    zzae zzae2 = new zzae(string, string2, new zzno(string3, cursor.getLong(10), zza2, string2), cursor.getLong(8), z2, string4, (zzbd) g_.zza(blob, creator), j, (zzbd) g_().zza(cursor.getBlob(9), creator), cursor.getLong(11), (zzbd) g_().zza(cursor.getBlob(12), creator));
                    arrayList.add(zzae);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying conditional user property value", e);
            List<zzae> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(List<Long> list) {
        zzt();
        zzal();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzaa()) {
            String j = lf.j("(", TextUtils.join(",", list), ")");
            if (zzb(lf.j("SELECT COUNT(1) FROM queue WHERE rowid IN ", j, " AND retry_count =  2147483647 LIMIT 1"), (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase e_ = e_();
                e_.execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + j + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public final void zza(String str, List<zzff.zza> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<zzff.zza> list2 = list;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzff.zza.C0040zza zza2 = (zzff.zza.C0040zza) list2.get(i).zzcc();
            if (zza2.zza() != 0) {
                for (int i2 = 0; i2 < zza2.zza(); i2++) {
                    zzff.zzb.zza zza3 = (zzff.zzb.zza) zza2.zza(i2).zzcc();
                    zzff.zzb.zza zza4 = (zzff.zzb.zza) ((zzjk.zzb) zza3.clone());
                    String zzb2 = zziq.zzb(zza3.zzb());
                    if (zzb2 != null) {
                        zza4.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza3.zza(); i3++) {
                        zzff.zzc zza5 = zza3.zza(i3);
                        String zza6 = zzip.zza(zza5.zze());
                        if (zza6 != null) {
                            zza4.zza(i3, (zzff.zzc) ((zzjk) ((zzff.zzc.zza) zza5.zzcc()).zza(zza6).zzai()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza2 = zza2.zza(i2, zza4);
                        list2.set(i, (zzff.zza) ((zzjk) zza2.zzai()));
                    }
                }
            }
            if (zza2.zzb() != 0) {
                for (int i4 = 0; i4 < zza2.zzb(); i4++) {
                    zzff.zze zzb3 = zza2.zzb(i4);
                    String zza7 = zzis.zza(zzb3.zze());
                    if (zza7 != null) {
                        zza2 = zza2.zza(i4, ((zzff.zze.zza) zzb3.zzcc()).zza(zza7));
                        list2.set(i, (zzff.zza) ((zzjk) zza2.zzai()));
                    }
                }
            }
        }
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        try {
            zzal();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase e_2 = e_();
            e_2.delete("property_filters", "app_id=?", new String[]{str2});
            e_2.delete("event_filters", "app_id=?", new String[]{str2});
            for (zzff.zza next : list) {
                zzal();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(next);
                if (!next.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzfw.zza(str));
                } else {
                    int zza8 = next.zza();
                    Iterator<zzff.zzb> it = next.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfw.zza(str), Integer.valueOf(zza8));
                                break;
                            }
                        } else {
                            Iterator<zzff.zze> it2 = next.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfw.zza(str), Integer.valueOf(zza8));
                                        break;
                                    }
                                } else {
                                    Iterator<zzff.zzb> it3 = next.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str2, zza8, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzff.zze> it4 = next.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str2, zza8, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzal();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase e_3 = e_();
                                        e_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zza8)});
                                        e_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zza8)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzff.zza next2 : list) {
                arrayList.add(next2.zzg() ? Integer.valueOf(next2.zza()) : null);
            }
            zzb(str2, (List<Integer>) arrayList);
            e_.setTransactionSuccessful();
        } finally {
            e_.endTransaction();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
        if (r7.zzf.zzb(r0).zza(com.google.android.gms.measurement.internal.zzin.zza.ANALYTICS_STORAGE) != false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x034c A[Catch:{ SQLiteException -> 0x035e }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzg r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r10 = "apps"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            r7.zzt()
            r7.zzal()
            java.lang.String r0 = r8.zzac()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.String r2 = "app_id"
            r1.put(r2, r0)
            boolean r2 = com.google.android.gms.internal.measurement.zznk.zza()
            java.lang.String r3 = "app_instance_id"
            r4 = 0
            if (r2 == 0) goto L_0x0045
            com.google.android.gms.measurement.internal.zzag r2 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzbf.zzcv
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r5)
            if (r2 == 0) goto L_0x0045
            if (r9 == 0) goto L_0x0037
            r1.put(r3, r4)
            goto L_0x004c
        L_0x0037:
            com.google.android.gms.measurement.internal.zznc r9 = r7.zzf
            com.google.android.gms.measurement.internal.zzin r9 = r9.zzb((java.lang.String) r0)
            com.google.android.gms.measurement.internal.zzin$zza r2 = com.google.android.gms.measurement.internal.zzin.zza.ANALYTICS_STORAGE
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzin.zza) r2)
            if (r9 == 0) goto L_0x004c
        L_0x0045:
            java.lang.String r9 = r8.zzad()
            r1.put(r3, r9)
        L_0x004c:
            java.lang.String r9 = "gmp_app_id"
            java.lang.String r2 = r8.zzah()
            r1.put(r9, r2)
            boolean r9 = com.google.android.gms.internal.measurement.zznk.zza()
            if (r9 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzcv
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r2)
            if (r9 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zznc r9 = r7.zzf
            com.google.android.gms.measurement.internal.zzin r9 = r9.zzb((java.lang.String) r0)
            com.google.android.gms.measurement.internal.zzin$zza r2 = com.google.android.gms.measurement.internal.zzin.zza.AD_STORAGE
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzin.zza) r2)
            if (r9 == 0) goto L_0x007e
        L_0x0075:
            java.lang.String r9 = "resettable_device_id_hash"
            java.lang.String r2 = r8.zzaj()
            r1.put(r9, r2)
        L_0x007e:
            long r2 = r8.zzt()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_index"
            r1.put(r2, r9)
            long r2 = r8.zzu()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_start_timestamp"
            r1.put(r2, r9)
            long r2 = r8.zzs()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "last_bundle_end_timestamp"
            r1.put(r2, r9)
            java.lang.String r9 = "app_version"
            java.lang.String r2 = r8.zzaf()
            r1.put(r9, r2)
            java.lang.String r9 = "app_store"
            java.lang.String r2 = r8.zzae()
            r1.put(r9, r2)
            long r2 = r8.zzq()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "gmp_version"
            r1.put(r2, r9)
            long r2 = r8.zzn()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "dev_cert_hash"
            r1.put(r2, r9)
            boolean r9 = r8.zzar()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "measurement_enabled"
            r1.put(r2, r9)
            long r2 = r8.zzm()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "day"
            r1.put(r2, r9)
            long r2 = r8.zzk()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_public_events_count"
            r1.put(r2, r9)
            long r2 = r8.zzj()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_events_count"
            r1.put(r2, r9)
            long r2 = r8.zzh()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_conversions_count"
            r1.put(r2, r9)
            long r2 = r8.zzg()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "config_fetched_time"
            r1.put(r2, r9)
            long r2 = r8.zzp()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "failed_config_fetch_time"
            r1.put(r2, r9)
            long r2 = r8.zze()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "app_version_int"
            r1.put(r2, r9)
            java.lang.String r9 = "firebase_instance_id"
            java.lang.String r2 = r8.zzag()
            r1.put(r9, r2)
            long r2 = r8.zzi()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_error_events_count"
            r1.put(r2, r9)
            long r2 = r8.zzl()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "daily_realtime_events_count"
            r1.put(r2, r9)
            java.lang.String r9 = "health_monitor_sample"
            java.lang.String r2 = r8.zzai()
            r1.put(r9, r2)
            long r2 = r8.zzd()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "android_id"
            r1.put(r2, r9)
            boolean r9 = r8.zzaq()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "adid_reporting_enabled"
            r1.put(r2, r9)
            java.lang.String r9 = "admob_app_id"
            java.lang.String r2 = r8.zzaa()
            r1.put(r9, r2)
            long r2 = r8.zzo()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "dynamite_version"
            r1.put(r2, r9)
            boolean r9 = com.google.android.gms.internal.measurement.zznk.zza()
            if (r9 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzcv
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r2)
            if (r9 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.zznc r9 = r7.zzf
            com.google.android.gms.measurement.internal.zzin r9 = r9.zzb((java.lang.String) r0)
            com.google.android.gms.measurement.internal.zzin$zza r2 = com.google.android.gms.measurement.internal.zzin.zza.ANALYTICS_STORAGE
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzin.zza) r2)
            if (r9 == 0) goto L_0x01be
        L_0x01b5:
            java.lang.String r9 = "session_stitching_token"
            java.lang.String r2 = r8.zzal()
            r1.put(r9, r2)
        L_0x01be:
            boolean r9 = r8.zzat()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "sgtm_upload_enabled"
            r1.put(r2, r9)
            long r2 = r8.zzw()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "target_os_version"
            r1.put(r2, r9)
            long r2 = r8.zzv()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "session_stitching_token_hash"
            r1.put(r2, r9)
            boolean r9 = com.google.android.gms.internal.measurement.zzpg.zza()
            if (r9 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzbz
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x0211
            int r9 = r8.zza()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "ad_services_version"
            r1.put(r2, r9)
            long r2 = r8.zzf()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "attribution_eligibility_status"
            r1.put(r2, r9)
        L_0x0211:
            boolean r9 = com.google.android.gms.internal.measurement.zznl.zza()
            if (r9 == 0) goto L_0x0230
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzck
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x0230
            boolean r9 = r8.zzau()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.String r2 = "unmatched_first_open_without_ad_id"
            r1.put(r2, r9)
        L_0x0230:
            java.lang.String r9 = "npa_metadata_value"
            java.lang.Boolean r2 = r8.zzx()
            r1.put(r9, r2)
            boolean r9 = com.google.android.gms.internal.measurement.zzpn.zza()
            if (r9 == 0) goto L_0x0261
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzbs
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x0261
            r7.zzq()
            boolean r9 = com.google.android.gms.measurement.internal.zznp.zzf(r0)
            if (r9 == 0) goto L_0x0261
            long r2 = r8.zzr()
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "bundle_delivery_index"
            r1.put(r2, r9)
        L_0x0261:
            boolean r9 = com.google.android.gms.internal.measurement.zzpn.zza()
            if (r9 == 0) goto L_0x027c
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzbt
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x027c
            java.lang.String r9 = "sgtm_preview_key"
            java.lang.String r2 = r8.zzam()
            r1.put(r9, r2)
        L_0x027c:
            int r9 = r8.zzc()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "dma_consent_state"
            r1.put(r2, r9)
            int r9 = r8.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "daily_realtime_dcu_count"
            r1.put(r2, r9)
            boolean r9 = com.google.android.gms.internal.measurement.zzne.zza()
            if (r9 == 0) goto L_0x02b1
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzcp
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x02b1
            java.lang.String r9 = "serialized_npa_metadata"
            java.lang.String r2 = r8.zzak()
            r1.put(r9, r2)
        L_0x02b1:
            java.util.List r9 = r8.zzan()
            java.lang.String r2 = "safelisted_events"
            if (r9 == 0) goto L_0x02d6
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L_0x02cd
            com.google.android.gms.measurement.internal.zzfw r9 = r7.zzj()
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzu()
            java.lang.String r3 = "Safelisted events should not be an empty list. appId"
            r9.zza(r3, r0)
            goto L_0x02d6
        L_0x02cd:
            java.lang.String r3 = ","
            java.lang.String r9 = android.text.TextUtils.join(r3, r9)
            r1.put(r2, r9)
        L_0x02d6:
            boolean r9 = com.google.android.gms.internal.measurement.zznw.zza()
            if (r9 == 0) goto L_0x02f1
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbf.zzbp
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r3)
            if (r9 == 0) goto L_0x02f1
            boolean r9 = r1.containsKey(r2)
            if (r9 != 0) goto L_0x02f1
            r1.put(r2, r4)
        L_0x02f1:
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzcs
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r2)
            if (r9 == 0) goto L_0x030f
            java.lang.String r9 = "unmatched_pfo"
            java.lang.Long r2 = r8.zzy()
            r1.put(r9, r2)
            java.lang.String r9 = "unmatched_uwa"
            java.lang.Long r2 = r8.zzz()
            r1.put(r9, r2)
        L_0x030f:
            boolean r9 = com.google.android.gms.internal.measurement.zzoj.zza()
            if (r9 == 0) goto L_0x032a
            com.google.android.gms.measurement.internal.zzag r9 = r7.zze()
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzbf.zzcm
            boolean r9 = r9.zze(r0, r2)
            if (r9 == 0) goto L_0x032a
            java.lang.String r9 = "ad_campaign_info"
            byte[] r8 = r8.zzav()
            r1.put(r9, r8)
        L_0x032a:
            android.database.sqlite.SQLiteDatabase r8 = r7.e_()     // Catch:{ SQLiteException -> 0x035e }
            java.lang.String r9 = "app_id = ?"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x035e }
            r3 = 0
            r2[r3] = r0     // Catch:{ SQLiteException -> 0x035e }
            int r9 = r8.update(r10, r1, r9, r2)     // Catch:{ SQLiteException -> 0x035e }
            long r2 = (long) r9     // Catch:{ SQLiteException -> 0x035e }
            r5 = 0
            int r9 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x035d
            r9 = 5
            long r8 = r8.insertWithOnConflict(r10, r4, r1, r9)     // Catch:{ SQLiteException -> 0x035e }
            r1 = -1
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x035d
            com.google.android.gms.measurement.internal.zzfw r8 = r7.zzj()     // Catch:{ SQLiteException -> 0x035e }
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzg()     // Catch:{ SQLiteException -> 0x035e }
            java.lang.String r9 = "Failed to insert/update app (got -1). appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x035e }
            r8.zza(r9, r10)     // Catch:{ SQLiteException -> 0x035e }
        L_0x035d:
            return
        L_0x035e:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzfw r9 = r7.zzj()
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzg()
            java.lang.String r10 = "Error storing app. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r0)
            r9.zza(r10, r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(com.google.android.gms.measurement.internal.zzg, boolean, boolean):void");
    }

    public final void zza(String str, zzav zzav) {
        zzin zzin;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzav);
        zzt();
        zzal();
        if (zze().zza(zzbf.zzcj) && zzi(str) == (zzin = zzin.zza)) {
            zzb(str, zzin);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzav.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzaz zzaz) {
        zza("events", zzaz);
    }

    private final void zza(String str, zzaz zzaz) {
        Preconditions.checkNotNull(zzaz);
        zzt();
        zzal();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaz.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaz.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzaz.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzaz.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzaz.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzaz.zzg));
        contentValues.put("last_bundled_day", zzaz.zzh);
        contentValues.put("last_sampled_complex_event_id", zzaz.zzi);
        contentValues.put("last_sampling_rate", zzaz.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzaz.zze));
        Boolean bool = zzaz.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzfw.zza(zzaz.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzfw.zza(zzaz.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase e_ = e_();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzfw.zza(str2));
                return;
            }
            if (((long) e_.update(str, contentValues, str2 + " = ?", new String[]{asString})) == 0 && e_.insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzfw.zza(str), zzfw.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzfw.zza(str), zzfw.zza(str2), e);
        }
    }

    public final void zza(String str, zzin zzin) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzin);
        zzt();
        zzal();
        zzb(str, zzi(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzin.zzh());
        zza("consent_settings", "app_id", contentValues);
    }

    public final boolean zza(zzfn.zzk zzk2, boolean z) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzk2);
        Preconditions.checkNotEmpty(zzk2.zzz());
        Preconditions.checkState(zzk2.zzbi());
        zzv();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzk2.zzm() < currentTimeMillis - zzag.zzm() || zzk2.zzm() > zzag.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfw.zza(zzk2.zzz()), Long.valueOf(currentTimeMillis), Long.valueOf(zzk2.zzm()));
        }
        try {
            byte[] zzb2 = g_().zzb(zzk2.zzbz());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(zzb2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzk2.zzz());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzk2.zzm()));
            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzb2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzk2.zzbp()) {
                contentValues.put("retry_count", Integer.valueOf(zzk2.zzg()));
            }
            try {
                if (e_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzfw.zza(zzk2.zzz()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzfw.zza(zzk2.zzz()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzfw.zza(zzk2.zzz()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zzb zzb2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (zzb2.zzf().isEmpty()) {
            zzfy zzu = zzj().zzu();
            Object zza2 = zzfw.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zzl()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzu.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbz = zzb2.zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zzl() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzf());
        contentValues.put("session_scoped", zzb2.zzm() ? Boolean.valueOf(zzb2.zzj()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzbz);
        try {
            if (e_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzfw.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zze zze2) {
        zzal();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (zze2.zze().isEmpty()) {
            zzfy zzu = zzj().zzu();
            Object zza2 = zzfw.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zzi()) {
                num = Integer.valueOf(zze2.zza());
            }
            zzu.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbz = zze2.zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zzi() ? Integer.valueOf(zze2.zza()) : null);
        contentValues.put("property_name", zze2.zze());
        contentValues.put("session_scoped", zze2.zzj() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzbz);
        try {
            if (e_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzba zzba, long j, boolean z) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzba);
        Preconditions.checkNotEmpty(zzba.zza);
        byte[] zzbz = g_().zza(zzba).zzbz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzba.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzba.zzb);
        contentValues.put(PaymentConstants.TIMESTAMP, Long.valueOf(zzba.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzbz);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (e_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzfw.zza(zzba.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzfw.zza(zzba.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzmu zzmu) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzmu);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzmu.zzb < currentTimeMillis - zzag.zzm() || zzmu.zzb > zzag.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzfw.zza(str), Long.valueOf(currentTimeMillis), Long.valueOf(zzmu.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmu.zza);
        contentValues.put("source", Integer.valueOf(zzmu.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmu.zzb));
        try {
            if (e_().insert("trigger_uris", (String) null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j, zzfn.zzf zzf) {
        zzt();
        zzal();
        Preconditions.checkNotNull(zzf);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbz = zzf.zzbz();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(zzbz.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbz);
        try {
            if (e_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzae zzae) {
        Preconditions.checkNotNull(zzae);
        zzt();
        zzal();
        String str = zzae.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzae.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzae.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzae.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzae.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzae.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzae.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzae.zzh));
        zzq();
        contentValues.put("timed_out_event", zznp.zza((Parcelable) zzae.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzae.zzd));
        zzq();
        contentValues.put("triggered_event", zznp.zza((Parcelable) zzae.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzae.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzae.zzj));
        zzq();
        contentValues.put("expired_event", zznp.zza((Parcelable) zzae.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzfw.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzfw.zza(str), e);
        }
        return true;
    }

    public final boolean zza(String str, Bundle bundle) {
        zzt();
        zzal();
        byte[] zzbz = g_().zza(new zzba(this.zzu, "", str, "dep", 0, 0, bundle)).zzbz();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(zzbz.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbz);
        try {
            if (e_().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zznq zznq) {
        Preconditions.checkNotNull(zznq);
        zzt();
        zzal();
        if (zze(zznq.zza, zznq.zzc) == null) {
            if (zznp.zzh(zznq.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zznq.zza}) >= ((long) zze().zza(zznq.zza, zzbf.zzag, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zznq.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zznq.zza, zznq.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zznq.zza);
        contentValues.put("origin", zznq.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zznq.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zznq.zzd));
        zza(contentValues, "value", zznq.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzfw.zza(zznq.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzfw.zza(zznq.zza), e);
        }
        return true;
    }
}
