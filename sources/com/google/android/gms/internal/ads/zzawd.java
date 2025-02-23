package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawd extends zzaxd {
    private static final zzaxe zzh = new zzaxe();
    private final Context zzi;

    public zzawd(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, Context context, zzarh zzarh) {
        super(zzavp, "iz9pI8M74OdFMOjBXhk6CVKK/c29GtinDT3TfbuphLdYOSnoV+Rg8WuW9whaa7rD", "AMztxBQmasdCMrU1nlH2RhtlfSPsjcYFxTHFmKvCDYM=", zzaro, i, 27);
        this.zzi = context;
    }

    private final String zzc() {
        try {
            if (this.zza.zzl() != null) {
                this.zza.zzl().get();
            }
            zzasj zzc = this.zza.zzc();
            if (zzc == null || !zzc.zzaj()) {
                return null;
            }
            return zzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzata zzata;
        int i;
        boolean z;
        String str;
        Boolean bool;
        AtomicReference zza = zzh.zza(this.zzi.getPackageName());
        synchronized (zza) {
            zzata zzata2 = (zzata) zza.get();
            if (zzata2 == null || zzavs.zzd(zzata2.zza) || zzata2.zza.equals("E") || zzata2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzavs.zzd((String) null)) {
                    i = 5;
                } else {
                    if (!zzavs.zzd((String) null)) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.FALSE;
                    }
                    bool.booleanValue();
                    i = 3;
                }
                if (i == 3) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                Boolean bool2 = (Boolean) zzba.zzc().zza(zzbbw.zzch);
                if (((Boolean) zzba.zzc().zza(zzbbw.zzcg)).booleanValue()) {
                    str = zzb();
                } else {
                    str = null;
                }
                if (bool2.booleanValue() && this.zza.zzp() && zzavs.zzd(str)) {
                    str = zzc();
                }
                zzata zzata3 = new zzata((String) this.zze.invoke((Object) null, new Object[]{this.zzi, valueOf, str}));
                if (zzavs.zzd(zzata3.zza) || zzata3.zza.equals("E")) {
                    int i2 = i - 1;
                    if (i2 == 3) {
                        String zzc = zzc();
                        if (!zzavs.zzd(zzc)) {
                            zzata3.zza = zzc;
                        }
                    } else if (i2 == 4) {
                        throw null;
                    }
                }
                zza.set(zzata3);
            }
            zzata = (zzata) zza.get();
        }
        synchronized (this.zzd) {
            if (zzata != null) {
                this.zzd.zzx(zzata.zza);
                this.zzd.zzX(zzata.zzb);
                this.zzd.zzZ(zzata.zzc);
                this.zzd.zzi(zzata.zzd);
                this.zzd.zzw(zzata.zze);
            }
        }
    }

    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzavs.zzf((String) zzba.zzc().zza(zzbbw.zzci));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals(LogSubCategory.Action.USER)) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzavs.zzf((String) zzba.zzc().zza(zzbbw.zzcj)))));
            }
            Context context = this.zzi;
            String packageName = context.getPackageName();
            this.zza.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            zzgdc zze = zzgdc.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzaxf(zze));
            return (String) zze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
        }
    }
}
