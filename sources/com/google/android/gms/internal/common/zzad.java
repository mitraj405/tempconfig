package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class zzad extends zzaa {
    public zzad() {
        super(4);
    }

    @CanIgnoreReturnValue
    public final zzad zzb(Object obj) {
        super.zza(obj);
        return this;
    }

    @CanIgnoreReturnValue
    public final zzad zzc(Iterator it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }

    public zzad(int i) {
        super(4);
    }
}
