package com.google.android.gms.ads.identifier;

import com.google.android.gms.internal.ads_identifier.zzi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public final class zzc {
    public static final void zza(String str) {
        HttpURLConnection httpURLConnection;
        try {
            zzi.zzb(263);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                new StringBuilder(String.valueOf(str).length() + 65);
            }
            httpURLConnection.disconnect();
            zzi.zza();
        } catch (IndexOutOfBoundsException e) {
            new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(e.getMessage()).length());
            zzi.zza();
        } catch (IOException | RuntimeException e2) {
            try {
                new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(e2.getMessage()).length());
            } finally {
                zzi.zza();
            }
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
