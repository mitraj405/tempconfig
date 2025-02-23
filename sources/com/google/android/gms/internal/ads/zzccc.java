package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzccc extends zzcaq implements TextureView.SurfaceTextureListener, zzcba {
    private final zzcbk zzc;
    private final zzcbl zzd;
    private final zzcbj zze;
    private zzcap zzf;
    private Surface zzg;
    private zzcbb zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl = 1;
    private zzcbi zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzccc(Context context, zzcbl zzcbl, zzcbk zzcbk, boolean z, boolean z2, zzcbj zzcbj) {
        super(context);
        this.zzc = zzcbk;
        this.zzd = zzcbl;
        this.zzn = z;
        this.zze = zzcbj;
        setSurfaceTextureListener(this);
        zzcbl.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + RemoteSettings.FORWARD_SLASH_STRING + canonicalName + ":" + message;
    }

    private final void zzU() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            zzcbb.zzQ(true);
        }
    }

    private final void zzV() {
        if (!this.zzo) {
            this.zzo = true;
            zzt.zza.post(new zzccb(this));
            zzn();
            this.zzd.zzb();
            if (this.zzp) {
                zzp();
            }
        }
    }

    private final void zzW(boolean z, Integer num) {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null && !z) {
            zzcbb.zzP(num);
        } else if (this.zzi != null && this.zzg != null) {
            if (z) {
                if (zzad()) {
                    zzcbb.zzU();
                    zzY();
                } else {
                    zzm.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzi.startsWith("cache:")) {
                zzccv zzp2 = this.zzc.zzp(this.zzi);
                if (zzp2 instanceof zzcde) {
                    zzcbb zza = ((zzcde) zzp2).zza();
                    this.zzh = zza;
                    zza.zzP(num);
                    if (!this.zzh.zzV()) {
                        zzm.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzp2 instanceof zzcdb) {
                    zzcdb zzcdb = (zzcdb) zzp2;
                    String zzF = zzF();
                    ByteBuffer zzk2 = zzcdb.zzk();
                    boolean zzl2 = zzcdb.zzl();
                    String zzi2 = zzcdb.zzi();
                    if (zzi2 == null) {
                        zzm.zzj("Stream cache URL is null.");
                        return;
                    }
                    zzcbb zzE = zzE(num);
                    this.zzh = zzE;
                    zzE.zzG(new Uri[]{Uri.parse(zzi2)}, zzF, zzk2, zzl2);
                } else {
                    zzm.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
            } else {
                this.zzh = zzE(num);
                String zzF2 = zzF();
                Uri[] uriArr = new Uri[this.zzj.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzj;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzh.zzF(uriArr, zzF2);
            }
            this.zzh.zzL(this);
            zzZ(this.zzg, false);
            if (this.zzh.zzV()) {
                int zzt = this.zzh.zzt();
                this.zzl = zzt;
                if (zzt == 3) {
                    zzV();
                }
            }
        }
    }

    private final void zzX() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            zzcbb.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ((Surface) null, true);
            zzcbb zzcbb = this.zzh;
            if (zzcbb != null) {
                zzcbb.zzL((zzcba) null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            try {
                zzcbb.zzS(surface, z);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set surface before player is initialized.");
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i, int i2) {
        float f;
        if (i2 > 0) {
            f = ((float) i) / ((float) i2);
        } else {
            f = 1.0f;
        }
        if (this.zzs != f) {
            this.zzs = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        if (!zzad() || this.zzl == 1) {
            return false;
        }
        return true;
    }

    private final boolean zzad() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb == null || !zzcbb.zzV() || this.zzk) {
            return false;
        }
        return true;
    }

    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzs;
        if (f != 0.0f && this.zzm == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcbi zzcbi = this.zzm;
        if (zzcbi != null) {
            zzcbi.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzn) {
            zzcbi zzcbi = new zzcbi(getContext());
            this.zzm = zzcbi;
            zzcbi.zzd(surfaceTexture, i, i2);
            this.zzm.start();
            SurfaceTexture zzb = this.zzm.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, (Integer) null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        zzt.zza.post(new zzcby(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcbi zzcbi = this.zzm;
        if (zzcbi != null) {
            zzcbi.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ((Surface) null, true);
        }
        zzt.zza.post(new zzcbu(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzcbi zzcbi = this.zzm;
        if (zzcbi != null) {
            zzcbi.zzc(i, i2);
        }
        zzt.zza.post(new zzcbt(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    public final void onWindowVisibilityChanged(int i) {
        zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        zzt.zza.post(new zzcbs(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzA(int i) {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            zzcbb.zzN(i);
        }
    }

    public final void zzB(int i) {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            zzcbb.zzR(i);
        }
    }

    public final void zzC(String str, String[] strArr, Integer num) {
        if (str != null) {
            boolean z = true;
            if (strArr == null) {
                this.zzj = new String[]{str};
            } else {
                this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            String str2 = this.zzi;
            if (!this.zze.zzk || str2 == null || str.equals(str2) || this.zzl != 4) {
                z = false;
            }
            this.zzi = str;
            zzW(z, num);
        }
    }

    public final void zzD(int i, int i2) {
        this.zzq = i;
        this.zzr = i2;
        zzaa();
    }

    public final zzcbb zzE(Integer num) {
        zzcbj zzcbj = this.zze;
        zzcbk zzcbk = this.zzc;
        zzcdw zzcdw = new zzcdw(zzcbk.getContext(), zzcbj, zzcbk, num);
        zzm.zzi("ExoPlayerAdapter initialized.");
        return zzcdw;
    }

    public final String zzF() {
        zzcbk zzcbk = this.zzc;
        return zzu.zzp().zzc(zzcbk.getContext(), zzcbk.zzn().afmaVersion);
    }

    public final /* synthetic */ void zzG(String str) {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzb("ExoPlayerAdapter error", str);
        }
    }

    public final /* synthetic */ void zzH() {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zza();
        }
    }

    public final /* synthetic */ void zzI() {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzf();
        }
    }

    public final /* synthetic */ void zzJ(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    public final /* synthetic */ void zzK(String str) {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzc("ExoPlayerAdapter exception", str);
        }
    }

    public final /* synthetic */ void zzL() {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzg();
        }
    }

    public final /* synthetic */ void zzM() {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzh();
        }
    }

    public final /* synthetic */ void zzN() {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzi();
        }
    }

    public final /* synthetic */ void zzO(int i, int i2) {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzj(i, i2);
        }
    }

    public final /* synthetic */ void zzP() {
        float zza = this.zzb.zza();
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            try {
                zzcbb.zzT(zza, false);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set volume before player is initialized.");
        }
    }

    public final /* synthetic */ void zzQ(int i) {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.onWindowVisibilityChanged(i);
        }
    }

    public final /* synthetic */ void zzR() {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zzd();
        }
    }

    public final /* synthetic */ void zzS() {
        zzcap zzcap = this.zzf;
        if (zzcap != null) {
            zzcap.zze();
        }
    }

    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    public final int zzb() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            return zzcbb.zzr();
        }
        return -1;
    }

    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    public final int zzd() {
        return this.zzr;
    }

    public final int zze() {
        return this.zzq;
    }

    public final long zzf() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            return zzcbb.zzx();
        }
        return -1;
    }

    public final long zzg() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            return zzcbb.zzA();
        }
        return -1;
    }

    public final long zzh() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            return zzcbb.zzB();
        }
        return -1;
    }

    public final void zzi(boolean z, long j) {
        if (this.zzc != null) {
            zzbzo.zze.execute(new zzcbv(this, z, j));
        }
    }

    public final String zzj() {
        String str;
        if (true != this.zzn) {
            str = "";
        } else {
            str = " spherical";
        }
        return "ExoPlayer/2".concat(str);
    }

    public final void zzk(String str, Exception exc) {
        String zzT = zzT(str, exc);
        zzm.zzj("ExoPlayerAdapter error: ".concat(zzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        zzt.zza.post(new zzcbz(this, zzT));
        zzu.zzo().zzv(exc, "AdExoPlayerView.onError");
    }

    public final void zzl(String str, Exception exc) {
        String zzT = zzT("onLoadException", exc);
        zzm.zzj("ExoPlayerAdapter exception: ".concat(zzT));
        zzu.zzo().zzv(exc, "AdExoPlayerView.onException");
        zzt.zza.post(new zzcbw(this, zzT));
    }

    public final void zzm(int i) {
        if (this.zzl != i) {
            this.zzl = i;
            if (i == 3) {
                zzV();
            } else if (i == 4) {
                if (this.zze.zza) {
                    zzX();
                }
                this.zzd.zze();
                this.zzb.zzc();
                zzt.zza.post(new zzcca(this));
            }
        }
    }

    public final void zzn() {
        zzt.zza.post(new zzcbr(this));
    }

    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            zzt.zza.post(new zzcbx(this));
        }
    }

    public final void zzp() {
        if (zzac()) {
            if (this.zze.zza) {
                zzU();
            }
            this.zzh.zzO(true);
            this.zzd.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            zzt.zza.post(new zzcbq(this));
            return;
        }
        this.zzp = true;
    }

    public final void zzq(int i) {
        if (zzac()) {
            this.zzh.zzI((long) i);
        }
    }

    public final void zzr(zzcap zzcap) {
        this.zzf = zzcap;
    }

    public final void zzs(String str) {
        if (str != null) {
            zzC(str, (String[]) null, (Integer) null);
        }
    }

    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    public final void zzu(float f, float f2) {
        zzcbi zzcbi = this.zzm;
        if (zzcbi != null) {
            zzcbi.zzf(f, f2);
        }
    }

    public final void zzv() {
        zzt.zza.post(new zzcbp(this));
    }

    public final Integer zzw() {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            return zzcbb.zzC();
        }
        return null;
    }

    public final void zzx(int i) {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            zzcbb.zzJ(i);
        }
    }

    public final void zzy(int i) {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            zzcbb.zzK(i);
        }
    }

    public final void zzz(int i) {
        zzcbb zzcbb = this.zzh;
        if (zzcbb != null) {
            zzcbb.zzM(i);
        }
    }
}
