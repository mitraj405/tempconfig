package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaxc {
    private final zzavp zza;
    private final String zzb;
    private final String zzc;
    private volatile Method zzd = null;
    private final Class[] zze;
    private final CountDownLatch zzf = new CountDownLatch(1);

    public zzaxc(zzavp zzavp, String str, String str2, Class... clsArr) {
        this.zza = zzavp;
        this.zzb = str;
        this.zzc = str2;
        this.zze = clsArr;
        zzavp.zzk().submit(new zzaxb(this));
    }

    public static /* bridge */ /* synthetic */ void zzb(zzaxc zzaxc) {
        try {
            zzavp zzavp = zzaxc.zza;
            Class<?> loadClass = zzavp.zzi().loadClass(zzaxc.zzc(zzavp.zzu(), zzaxc.zzb));
            if (loadClass != null) {
                zzaxc.zzd = loadClass.getMethod(zzaxc.zzc(zzaxc.zza.zzu(), zzaxc.zzc), zzaxc.zze);
            }
        } catch (zzaut | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            zzaxc.zzf.countDown();
            throw th;
        }
        zzaxc.zzf.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzaut, UnsupportedEncodingException {
        return new String(this.zza.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            if (!this.zzf.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zzd;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
