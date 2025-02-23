package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzu;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcrg extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcrg(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcrg zza(Context context, View view, zzfel zzfel) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcrg zzcrg = new zzcrg(context);
        if (!(zzfel.zzu.isEmpty() || (resources = zzcrg.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzfem zzfem = (zzfem) zzfel.zzu.get(0);
            float f = displayMetrics.density;
            zzcrg.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzfem.zza) * f), (int) (((float) zzfem.zzb) * f)));
        }
        zzcrg.zzb = view;
        zzcrg.addView(view);
        zzu.zzx();
        zzcab.zzb(zzcrg, zzcrg);
        zzu.zzx();
        zzcab.zza(zzcrg, zzcrg);
        JSONObject jSONObject = zzfel.zzah;
        RelativeLayout relativeLayout = new RelativeLayout(zzcrg.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzcrg.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcrg.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzcrg.addView(relativeLayout);
        return zzcrg;
    }

    private final int zzb(double d) {
        zzay.zzb();
        return zzf.zzy(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb2 = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, zzb2, 0, zzb2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
