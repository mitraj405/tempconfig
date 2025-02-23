package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbav {
    private final zzbbb zza;
    private final zzbbc.zzt.zza zzb;
    private final boolean zzc;

    private zzbav() {
        this.zzb = zzbbc.zzt.zzj();
        this.zzc = false;
        this.zza = new zzbbb();
    }

    public static zzbav zza() {
        return new zzbav();
    }

    private final synchronized String zzd(int i) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzb.zzah(), Long.valueOf(zzu.zzB().elapsedRealtime()), Integer.valueOf(i - 1), Base64.encodeToString(((zzbbc.zzt) this.zzb.zzbr()).zzaV(), 3)});
    }

    private final synchronized void zze(int i) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(zzfqu.zza(zzfqt.zza(), externalStorageDirectory, "clearcut_events.txt")), true);
                try {
                    fileOutputStream.write(zzd(i).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zze.zza("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zze.zza("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized void zzf(int i) {
        zzbbc.zzt.zza zza2 = this.zzb;
        zza2.zzq();
        zza2.zzj(zzt.zzd());
        zzbba zzbba = new zzbba(this.zza, ((zzbbc.zzt) this.zzb.zzbr()).zzaV(), (zzbaz) null);
        int i2 = i - 1;
        zzbba.zza(i2);
        zzbba.zzc();
        zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i2, 10))));
    }

    public final synchronized void zzb(zzbau zzbau) {
        if (this.zzc) {
            try {
                zzbau.zza(this.zzb);
            } catch (NullPointerException e) {
                zzu.zzo().zzw(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i) {
        if (this.zzc) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzeu)).booleanValue()) {
                zze(i);
            } else {
                zzf(i);
            }
        }
    }

    public zzbav(zzbbb zzbbb) {
        this.zzb = zzbbc.zzt.zzj();
        this.zza = zzbbb;
        this.zzc = ((Boolean) zzba.zzc().zza(zzbbw.zzet)).booleanValue();
    }
}
