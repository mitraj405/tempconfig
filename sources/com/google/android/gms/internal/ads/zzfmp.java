package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfmp {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, zzflx zzflx, String str) {
        zzfmo zzfmo;
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        } else if (zza.matcher("Ad overlay").matches()) {
            Iterator it = this.zzb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzfmo = null;
                    break;
                }
                zzfmo = (zzfmo) it.next();
                if (zzfmo.zzb().get() == view) {
                    break;
                }
            }
            if (zzfmo == null) {
                this.zzb.add(new zzfmo(view, zzflx, "Ad overlay"));
            }
        } else {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
