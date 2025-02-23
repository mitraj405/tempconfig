package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.AdError;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfqf {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfqg zzc;
    private final zzfoh zzd;
    private final zzfoc zze;
    private zzfpu zzf;
    private final Object zzg = new Object();

    public zzfqf(Context context, zzfqg zzfqg, zzfoh zzfoh, zzfoc zzfoc) {
        this.zzb = context;
        this.zzc = zzfqg;
        this.zzd = zzfoh;
        this.zze = zzfoc;
    }

    private final synchronized Class zzd(zzfpv zzfpv) throws zzfqe {
        String zzk = zzfpv.zza().zzk();
        HashMap hashMap = zza;
        Class cls = (Class) hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfpv.zzc())) {
                File zzb2 = zzfpv.zzb();
                if (!zzb2.exists()) {
                    zzb2.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzfpv.zzc().getAbsolutePath(), zzb2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zzk, loadClass);
                return loadClass;
            }
            throw new zzfqe(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e) {
            throw new zzfqe(2026, (Throwable) e);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
            throw new zzfqe((int) AdError.REMOTE_ADS_SERVICE_ERROR, e2);
        }
    }

    public final zzfok zza() {
        zzfpu zzfpu;
        synchronized (this.zzg) {
            zzfpu = this.zzf;
        }
        return zzfpu;
    }

    public final zzfpv zzb() {
        synchronized (this.zzg) {
            zzfpu zzfpu = this.zzf;
            if (zzfpu == null) {
                return null;
            }
            zzfpv zzf2 = zzfpu.zzf();
            return zzf2;
        }
    }

    public final boolean zzc(zzfpv zzfpv) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class zzd2 = zzd(zzfpv);
            zzfpu zzfpu = new zzfpu(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzfpv.zze(), null, new Bundle(), 2}), zzfpv, this.zzc, this.zzd);
            if (zzfpu.zzh()) {
                int zze2 = zzfpu.zze();
                if (zze2 == 0) {
                    synchronized (this.zzg) {
                        zzfpu zzfpu2 = this.zzf;
                        if (zzfpu2 != null) {
                            try {
                                zzfpu2.zzg();
                            } catch (zzfqe e) {
                                this.zzd.zzc(e.zza(), -1, e);
                            }
                        }
                        this.zzf = zzfpu;
                    }
                    this.zzd.zzd(3000, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                throw new zzfqe(4001, "ci: " + zze2);
            }
            throw new zzfqe(4000, "init failed");
        } catch (Exception e2) {
            throw new zzfqe((int) AdError.INTERNAL_ERROR_2004, (Throwable) e2);
        } catch (zzfqe e3) {
            this.zzd.zzc(e3.zza(), System.currentTimeMillis() - currentTimeMillis, e3);
            return false;
        } catch (Exception e4) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e4);
            return false;
        }
    }
}
