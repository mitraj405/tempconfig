package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzags implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, zzagu.class.getClassLoader());
        return new zzagv(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzagv[i];
    }
}
