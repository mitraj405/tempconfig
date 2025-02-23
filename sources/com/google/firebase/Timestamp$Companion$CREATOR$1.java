package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Timestamp.kt */
public final class Timestamp$Companion$CREATOR$1 implements Parcelable.Creator<Timestamp> {
    public Timestamp createFromParcel(Parcel parcel) {
        C1177ig.f(parcel, "source");
        return new Timestamp(parcel.readLong(), parcel.readInt());
    }

    public Timestamp[] newArray(int i) {
        return new Timestamp[i];
    }
}
