package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdkb {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final zzg zzb;
    private final zzffg zzc;
    private final zzdjg zzd;
    private final zzdjb zze;
    private final zzdkn zzf;
    private final zzdkv zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbes zzj;
    private final zzdiy zzk;

    public zzdkb(zzg zzg2, zzffg zzffg, zzdjg zzdjg, zzdjb zzdjb, zzdkn zzdkn, zzdkv zzdkv, Executor executor, Executor executor2, zzdiy zzdiy) {
        this.zzb = zzg2;
        this.zzc = zzffg;
        this.zzj = zzffg.zzi;
        this.zzd = zzdjg;
        this.zze = zzdjb;
        this.zzf = zzdkn;
        this.zzg = zzdkv;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdiy;
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        View view;
        FrameLayout.LayoutParams layoutParams;
        if (z) {
            view = this.zze.zzf();
        } else {
            view = this.zze.zzg();
        }
        if (view == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdw)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(view, layoutParams);
        return true;
    }

    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        boolean z;
        zzdjb zzdjb = this.zze;
        if (zzdjb.zzf() != null) {
            if (viewGroup != null) {
                z = true;
            } else {
                z = false;
            }
            if (zzdjb.zzc() == 2 || zzdjb.zzc() == 1) {
                this.zzb.zzK(this.zzc.zzf, String.valueOf(zzdjb.zzc()), z);
            } else if (zzdjb.zzc() == 6) {
                this.zzb.zzK(this.zzc.zzf, C0515Ga.FARE_ONLY, z);
                this.zzb.zzK(this.zzc.zzf, C0515Ga.AVLBLTY_ONLY, z);
            }
        }
    }

    public final /* synthetic */ void zzb(zzdkx zzdkx) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzbfa zza2;
        Drawable drawable;
        Context context = null;
        if (this.zzd.zzf() || this.zzd.zze()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                View zzg2 = zzdkx.zzg(strArr[i]);
                if (zzg2 != null && (zzg2 instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzg2;
                    break;
                }
                i++;
            }
        }
        viewGroup = null;
        Context context2 = zzdkx.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdjb zzdjb = this.zze;
        if (zzdjb.zze() != null) {
            zzbes zzbes = this.zzj;
            view = zzdjb.zze();
            if (zzbes != null && viewGroup == null) {
                zzh(layoutParams, zzbes.zze);
                view.setLayoutParams(layoutParams);
                viewGroup = null;
            }
        } else if (!(zzdjb.zzl() instanceof zzben)) {
            view = null;
        } else {
            zzben zzben = (zzben) zzdjb.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzben.zzc());
                viewGroup = null;
            }
            zzbeo zzbeo = new zzbeo(context2, zzben, layoutParams);
            zzbeo.setContentDescription((CharSequence) zzba.zzc().zza(zzbbw.zzdu));
            view = zzbeo;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                zza zza3 = new zza(zzdkx.zzf().getContext());
                zza3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zza3.addView(view);
                FrameLayout zzh2 = zzdkx.zzh();
                if (zzh2 != null) {
                    zzh2.addView(zza3);
                }
            }
            zzdkx.zzq(zzdkx.zzk(), view, true);
        }
        zzfxr zzfxr = zzdjx.zza;
        int size = zzfxr.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View zzg3 = zzdkx.zzg((String) zzfxr.get(i2));
            i2++;
            if (zzg3 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzg3;
                break;
            }
        }
        this.zzi.execute(new zzdjy(this, viewGroup2));
        if (viewGroup2 != null) {
            if (zzi(viewGroup2, true)) {
                zzdjb zzdjb2 = this.zze;
                if (zzdjb2.zzs() != null) {
                    zzdjb2.zzs().zzar(new zzdka(zzdkx, viewGroup2));
                    return;
                }
                return;
            }
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzjf)).booleanValue() || !zzi(viewGroup2, false)) {
                viewGroup2.removeAllViews();
                View zzf2 = zzdkx.zzf();
                if (zzf2 != null) {
                    context = zzf2.getContext();
                }
                if (context != null && (zza2 = this.zzk.zza()) != null) {
                    try {
                        IObjectWrapper zzi2 = zza2.zzi();
                        if (zzi2 != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzi2)) != null) {
                            ImageView imageView = new ImageView(context);
                            imageView.setImageDrawable(drawable);
                            IObjectWrapper zzj2 = zzdkx.zzj();
                            if (zzj2 != null) {
                                if (((Boolean) zzba.zzc().zza(zzbbw.zzfA)).booleanValue()) {
                                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzj2));
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                            imageView.setScaleType(zza);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    } catch (RemoteException unused) {
                        zzm.zzj("Could not get main image drawable");
                    }
                }
            } else {
                zzdjb zzdjb3 = this.zze;
                if (zzdjb3.zzq() != null) {
                    zzdjb3.zzq().zzar(new zzdka(zzdkx, viewGroup2));
                }
            }
        }
    }

    public final void zzc(zzdkx zzdkx) {
        if (zzdkx != null && this.zzf != null && zzdkx.zzh() != null && this.zzd.zzg()) {
            try {
                zzdkx.zzh().addView(this.zzf.zza());
            } catch (zzcev e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(zzdkx zzdkx) {
        if (zzdkx != null) {
            Context context = zzdkx.zzf().getContext();
            if (!zzbv.zzh(context, this.zzd.zza)) {
                return;
            }
            if (!(context instanceof Activity)) {
                zzm.zze("Activity context is needed for policy validator.");
            } else if (this.zzg != null && zzdkx.zzh() != null) {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    windowManager.addView(this.zzg.zza(zzdkx.zzh(), windowManager), zzbv.zzb());
                } catch (zzcev e) {
                    zze.zzb("web view can not be obtained", e);
                }
            }
        }
    }

    public final void zze(zzdkx zzdkx) {
        this.zzh.execute(new zzdjz(this, zzdkx));
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }
}
