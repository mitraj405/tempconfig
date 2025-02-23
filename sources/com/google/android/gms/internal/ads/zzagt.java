package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzagt implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzagu(parcel.readLong(), parcel.readLong(), parcel.readInt());
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzagu[i];
    }
}
