package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzga implements zzfs {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzfs zzc;
    private zzfs zzd;
    private zzfs zze;
    private zzfs zzf;
    private zzfs zzg;
    private zzfs zzh;
    private zzfs zzi;
    private zzfs zzj;
    private zzfs zzk;

    public zzga(Context context, zzfs zzfs) {
        this.zza = context.getApplicationContext();
        this.zzc = zzfs;
    }

    private final zzfs zzg() {
        if (this.zze == null) {
            zzfk zzfk = new zzfk(this.zza);
            this.zze = zzfk;
            zzh(zzfk);
        }
        return this.zze;
    }

    private final void zzh(zzfs zzfs) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzfs.zzf((zzgu) this.zzb.get(i));
        }
    }

    private static final void zzi(zzfs zzfs, zzgu zzgu) {
        if (zzfs != null) {
            zzfs.zzf(zzgu);
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzfs zzfs = this.zzk;
        zzfs.getClass();
        return zzfs.zza(bArr, i, i2);
    }

    public final long zzb(zzfy zzfy) throws IOException {
        boolean z;
        zzfs zzfs;
        if (this.zzk == null) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        String scheme = zzfy.zza.getScheme();
        Uri uri = zzfy.zza;
        int i = zzet.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || "file".equals(scheme2)) {
            String path = zzfy.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzgj zzgj = new zzgj();
                    this.zzd = zzgj;
                    zzh(zzgj);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            if (this.zzf == null) {
                zzfp zzfp = new zzfp(this.zza);
                this.zzf = zzfp;
                zzh(zzfp);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzfs zzfs2 = (zzfs) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.zzg = zzfs2;
                    zzh(zzfs2);
                } catch (ClassNotFoundException unused) {
                    zzea.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzgw zzgw = new zzgw(2000);
                this.zzh = zzgw;
                zzh(zzgw);
            }
            this.zzk = this.zzh;
        } else if (Constants.ScionAnalytics.MessageType.DATA_MESSAGE.equals(scheme)) {
            if (this.zzi == null) {
                zzfq zzfq = new zzfq();
                this.zzi = zzfq;
                zzh(zzfq);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzgs zzgs = new zzgs(this.zza);
                    this.zzj = zzgs;
                    zzh(zzgs);
                }
                zzfs = this.zzj;
            } else {
                zzfs = this.zzc;
            }
            this.zzk = zzfs;
        }
        return this.zzk.zzb(zzfy);
    }

    public final Uri zzc() {
        zzfs zzfs = this.zzk;
        if (zzfs == null) {
            return null;
        }
        return zzfs.zzc();
    }

    public final void zzd() throws IOException {
        zzfs zzfs = this.zzk;
        if (zzfs != null) {
            try {
                zzfs.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    public final Map zze() {
        zzfs zzfs = this.zzk;
        if (zzfs == null) {
            return Collections.emptyMap();
        }
        return zzfs.zze();
    }

    public final void zzf(zzgu zzgu) {
        zzgu.getClass();
        this.zzc.zzf(zzgu);
        this.zzb.add(zzgu);
        zzi(this.zzd, zzgu);
        zzi(this.zze, zzgu);
        zzi(this.zzf, zzgu);
        zzi(this.zzg, zzgu);
        zzi(this.zzh, zzgu);
        zzi(this.zzi, zzgu);
        zzi(this.zzj, zzgu);
    }
}
