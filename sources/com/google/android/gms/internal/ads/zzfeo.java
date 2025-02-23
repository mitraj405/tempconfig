package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbs;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfeo {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final long zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzfen zzj;
    public final Bundle zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;
    public final JSONObject zzo;
    public final JSONObject zzp;
    public final String zzq;
    public final int zzr;

    public zzfeo(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List emptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jsonReader.beginObject();
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        zzfen zzfen = null;
        long j = 0;
        int i3 = -1;
        int i4 = 1;
        String str6 = str5;
        String str7 = str6;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (Objects.equals(nextName, "nofill_urls")) {
                emptyList = zzbs.zzd(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if (Objects.equals(nextName, "refresh_load_delay_time_interval")) {
                i3 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str6 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if ("latency".equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                String str8 = str5;
                if (!((Boolean) zzba.zzc().zza(zzbbw.zzhw)).booleanValue() || !"public_error".equals(nextName) || jsonReader.peek() != JsonToken.BEGIN_OBJECT) {
                    JsonReader jsonReader2 = jsonReader;
                    if ("bidding_data".equals(nextName)) {
                        str7 = jsonReader.nextString();
                    } else {
                        if (((Boolean) zzba.zzc().zza(zzbbw.zzjz)).booleanValue() && Objects.equals(nextName, "topics_should_record_observation")) {
                            jsonReader.nextBoolean();
                        } else if ("adapter_response_replacement_key".equals(nextName)) {
                            str5 = jsonReader.nextString();
                        } else if ("response_info_extras".equals(nextName)) {
                            if (((Boolean) zzba.zzc().zza(zzbbw.zzgf)).booleanValue()) {
                                try {
                                    Bundle zza2 = zzbs.zza(zzbs.zzi(jsonReader));
                                    if (zza2 != null) {
                                        bundle = zza2;
                                    }
                                } catch (IOException | JSONException unused) {
                                } catch (IllegalStateException unused2) {
                                    jsonReader.skipValue();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if ("adRequestPostBody".equals(nextName)) {
                            if (((Boolean) zzba.zzc().zza(zzbbw.zzit)).booleanValue()) {
                                str3 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if ("adRequestUrl".equals(nextName)) {
                            if (((Boolean) zzba.zzc().zza(zzbbw.zzit)).booleanValue()) {
                                str2 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else {
                            zzbbn zzbbn = zzbbw.zziu;
                            if (((Boolean) zzba.zzc().zza(zzbbn)).booleanValue() && Objects.equals(nextName, "adResponseBody")) {
                                str4 = jsonReader.nextString();
                            } else if (((Boolean) zzba.zzc().zza(zzbbn)).booleanValue() && Objects.equals(nextName, "adResponseHeaders")) {
                                jSONObject = zzbs.zzi(jsonReader);
                            } else if (Objects.equals(nextName, "max_parallel_renderers")) {
                                i4 = Math.max(1, jsonReader.nextInt());
                            } else {
                                if (!((Boolean) zzba.zzc().zza(zzbbw.zziB)).booleanValue() || !Objects.equals(nextName, "inspector_ad_transaction_extras")) {
                                    jsonReader.skipValue();
                                } else {
                                    jSONObject2 = zzbs.zzi(jsonReader);
                                }
                            }
                        }
                    }
                } else {
                    zzfen = new zzfen(jsonReader);
                }
                str5 = str8;
            }
        }
        String str9 = str5;
        jsonReader.endObject();
        this.zza = emptyList;
        this.zzc = i;
        if (((Boolean) zzbdy.zzd.zze()).booleanValue()) {
            this.zzd = -1;
        } else {
            zzbdc zzbdc = zzbdg.zza;
            if (((Long) zzbdc.zze()).longValue() > -1) {
                this.zzd = ((Long) zzbdc.zze()).intValue();
            } else {
                this.zzd = i3;
            }
        }
        this.zzb = str;
        this.zze = str6;
        this.zzf = i2;
        this.zzg = j;
        this.zzj = zzfen;
        this.zzh = z;
        this.zzi = str7;
        this.zzk = bundle;
        this.zzl = str2;
        this.zzm = str3;
        this.zzn = str4;
        this.zzo = jSONObject;
        this.zzp = jSONObject2;
        this.zzq = str9;
        zzbdc zzbdc2 = zzbdw.zza;
        this.zzr = ((Long) zzbdc2.zze()).longValue() > 0 ? ((Long) zzbdc2.zze()).intValue() : i4;
    }
}
