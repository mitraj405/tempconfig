package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaun extends zzaum {
    public zzaun(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzaun zzt(String str, Context context, boolean z) {
        zzaum.zzr(context, false);
        return new zzaun(context, str, false);
    }

    @Deprecated
    public static zzaun zzu(String str, Context context, boolean z, int i) {
        zzaum.zzr(context, z);
        return new zzaun(context, str, z);
    }

    public final List zzp(zzavp zzavp, Context context, zzaro zzaro, zzarh zzarh) {
        if (zzavp.zzk() == null || !this.zzu) {
            return super.zzp(zzavp, context, zzaro, (zzarh) null);
        }
        int zza = zzavp.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzavp, context, zzaro, (zzarh) null));
        arrayList.add(new zzawh(zzavp, "FLgp79R6LGLnWDio6G1XBjsjORgKSjLkdakyn5bigQludVyQtVZMhDAlppvakfKf", "oPDFFWKd1EuWWR8iem/Fb2LK/5grpy+LhaDBlMcgIHs=", zzaro, zza, 24));
        return arrayList;
    }
}
