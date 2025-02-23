package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbw;
import java.util.Locale;

@TargetApi(28)
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzy extends zzw {
    public static final /* synthetic */ WindowInsets zzl(Activity activity, View view, WindowInsets windowInsets) {
        if (zzu.zzo().zzi().zzm() == null) {
            DisplayCutout d = windowInsets.getDisplayCutout();
            String str = "";
            if (d != null) {
                zzg zzi = zzu.zzo().zzi();
                for (Rect rect : d.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
                    if (!TextUtils.isEmpty(str)) {
                        str = str.concat("|");
                    }
                    str = str.concat(String.valueOf(format));
                }
                zzi.zzD(str);
            } else {
                zzu.zzo().zzi().zzD(str);
            }
        }
        zzn(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static final void zzn(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int b = attributes.layoutInDisplayCutoutMode;
        int i = 1;
        if (true != z) {
            i = 2;
        }
        if (i != b) {
            attributes.layoutInDisplayCutoutMode = i;
            window.setAttributes(attributes);
        }
    }

    public final int zzj(AudioManager audioManager) {
        return audioManager.getStreamMinVolume(3);
    }

    public final void zzk(Activity activity) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzaW)).booleanValue() && zzu.zzo().zzi().zzm() == null && !activity.isInMultiWindowMode()) {
            zzn(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new zzx(this, activity));
        }
    }
}
