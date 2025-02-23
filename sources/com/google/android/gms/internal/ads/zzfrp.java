package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzfrp extends zzfrd {
    private zzfvk<Integer> zza;
    private zzfvk<Integer> zzb;
    private zzfro zzc;
    private HttpURLConnection zzd;

    public zzfrp(zzfvk<Integer> zzfvk, zzfvk<Integer> zzfvk2, zzfro zzfro) {
        this.zza = zzfvk;
        this.zzb = zzfvk2;
        this.zzc = zzfro;
    }

    public static /* synthetic */ Integer zzf() {
        return -1;
    }

    public static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfre.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfre.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfro zzfro = this.zzc;
        zzfro.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfro.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfro zzfro, int i, int i2) throws IOException {
        this.zza = new zzfrh(i);
        this.zzb = new zzfri(i2);
        this.zzc = zzfro;
        return zzm();
    }

    public HttpURLConnection zzo(Network network, URL url, int i, int i2) throws IOException {
        this.zza = new zzfrj(i);
        this.zzb = new zzfrk(i2);
        this.zzc = new zzfrl(network, url);
        return zzm();
    }

    public URLConnection zzr(URL url, int i) throws IOException {
        this.zza = new zzfrm(i);
        this.zzc = new zzfrn(url);
        return zzm();
    }

    public zzfrp() {
        this(new zzfrf(), new zzfrg(), (zzfro) null);
    }
}
