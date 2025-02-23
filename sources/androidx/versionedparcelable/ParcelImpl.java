package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
    public final C0201gC a;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        public final Object createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        public final Object[] newArray(int i) {
            return new ParcelImpl[i];
        }
    }

    public ParcelImpl(C0201gC gCVar) {
        this.a = gCVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        new C0192fC(parcel).w(this.a);
    }

    public ParcelImpl(Parcel parcel) {
        this.a = new C0192fC(parcel).n();
    }
}
