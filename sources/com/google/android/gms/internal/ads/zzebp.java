package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzebp implements zzfio {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfju zzc;
    private final zzfkf zzd;

    public zzebp(String str, zzfkf zzfkf, zzfju zzfju) {
        this.zzb = str;
        this.zzd = zzfkf;
        this.zzc = zzfju;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzdwl zzdwl;
        String str;
        zzebo zzebo = (zzebo) obj;
        int optInt = zzebo.zza.optInt("http_timeout_millis", 60000);
        zzbvd zza2 = zzebo.zzb;
        String str2 = "";
        if (zza2.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzebo.zzb.zzj() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) zzba.zzc().zza(zzbbw.zzaG)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = str2;
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = str2;
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null) {
                                Locale locale = Locale.ROOT;
                                if (group.toLowerCase(locale).startsWith("id=") || group.toLowerCase(locale).startsWith("ide=")) {
                                    if (!TextUtils.isEmpty(str)) {
                                        str = str.concat("; ");
                                    }
                                    str = str.concat(group);
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(HttpHeaders.COOKIE, str);
                    }
                } else {
                    hashMap.put(HttpHeaders.COOKIE, this.zzb);
                }
            }
            if (zzebo.zzb.zzk()) {
                zzebq.zza(hashMap, zzebo.zza);
            }
            if (zzebo.zzb != null && !TextUtils.isEmpty(zzebo.zzb.zzf())) {
                str2 = zzebo.zzb.zzf();
            }
            zzfkf zzfkf = this.zzd;
            zzfju zzfju = this.zzc;
            zzfju.zzg(true);
            zzfkf.zza(zzfju);
            return new zzebk(zzebo.zzb.zzg(), optInt, hashMap, str2.getBytes(zzfuj.zzc), "", zzebo.zzb.zzk());
        }
        if (zza2.zza() == 1) {
            if (zza2.zzh() != null) {
                str2 = TextUtils.join(", ", zza2.zzh());
                zzm.zzg(str2);
            }
            zzdwl = new zzdwl(2, "Error building request URL: ".concat(String.valueOf(str2)));
        } else {
            zzdwl = new zzdwl(1);
        }
        zzfkf zzfkf2 = this.zzd;
        zzfju zzfju2 = this.zzc;
        zzfju2.zzh(zzdwl);
        zzfju2.zzg(false);
        zzfkf2.zza(zzfju2);
        throw zzdwl;
    }
}
