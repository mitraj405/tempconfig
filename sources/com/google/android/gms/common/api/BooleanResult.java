package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public class BooleanResult implements Result {
    private final Status zaa;
    private final boolean zab;

    @ShowFirstParty
    @KeepForSdk
    public BooleanResult(Status status, boolean z) {
        this.zaa = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.zab = z;
    }

    @KeepForSdk
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        if (!this.zaa.equals(booleanResult.zaa) || this.zab != booleanResult.zab) {
            return false;
        }
        return true;
    }

    @KeepForSdk
    public Status getStatus() {
        return this.zaa;
    }

    @KeepForSdk
    public boolean getValue() {
        return this.zab;
    }

    @KeepForSdk
    public final int hashCode() {
        return ((this.zaa.hashCode() + 527) * 31) + (this.zab ? 1 : 0);
    }
}
