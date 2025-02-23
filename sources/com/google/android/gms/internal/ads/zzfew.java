package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfew {
    public final List zza;
    public final zzfeo zzb;
    public final List zzc;
    public final zzbvb zzd;

    public zzfew(JsonReader jsonReader, zzbvb zzbvb) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List list;
        ArrayList arrayList;
        Bundle bundle;
        this.zzd = zzbvb;
        if (!(!((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue() || zzbvb == null || (bundle = zzbvb.zzm) == null)) {
            bundle.putLong(zzdrt.SERVER_RESPONSE_PARSE_START.zza(), zzu.zzB().currentTimeMillis());
        }
        List emptyList = Collections.emptyList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        zzfeo zzfeo = null;
        List list2 = emptyList;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                List list3 = list2;
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        ArrayList arrayList3 = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList3.add(new zzfel(jsonReader));
                        }
                        jsonReader.endArray();
                        arrayList = arrayList3;
                    } else if (nextName2.equals("common")) {
                        zzfeo = new zzfeo(jsonReader);
                        arrayList = list3;
                    } else {
                        jsonReader.skipValue();
                        arrayList = list3;
                    }
                    list3 = arrayList;
                }
                jsonReader.endObject();
                jsonReader.endArray();
                list = list3;
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    JSONObject jSONObject = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if (AppMeasurementSdk.ConditionalUserProperty.NAME.equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if ("info".equals(nextName3)) {
                            jSONObject = zzbs.zzi(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList2.add(new zzfev(str, jSONObject));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
                list = list2;
            } else {
                list = list2;
            }
            list2 = list;
        }
        this.zzc = arrayList2;
        this.zza = list2;
        this.zzb = zzfeo == null ? new zzfeo(new JsonReader(new StringReader("{}"))) : zzfeo;
    }

    public static zzfew zza(Reader reader, zzbvb zzbvb) throws zzfep {
        try {
            zzfew zzfew = new zzfew(new JsonReader(reader), zzbvb);
            IOUtils.closeQuietly((Closeable) reader);
            return zzfew;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzfep("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
