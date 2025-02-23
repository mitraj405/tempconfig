package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();
    public final Bundle a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2103a;
    public Bundle b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f2104b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f2105c;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f2106c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public final String f2107d;

    /* renamed from: d  reason: collision with other field name */
    public final boolean f2108d;
    public final int e;

    /* renamed from: e  reason: collision with other field name */
    public final String f2109e;

    /* renamed from: e  reason: collision with other field name */
    public final boolean f2110e;

    public class a implements Parcelable.Creator<FragmentState> {
        public final Object createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public final Object[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f2105c = fragment.getClass().getName();
        this.f2107d = fragment.mWho;
        this.f2103a = fragment.mFromLayout;
        this.c = fragment.mFragmentId;
        this.d = fragment.mContainerId;
        this.f2109e = fragment.mTag;
        this.f2104b = fragment.mRetainInstance;
        this.f2106c = fragment.mRemoving;
        this.f2108d = fragment.mDetached;
        this.a = fragment.mArguments;
        this.f2110e = fragment.mHidden;
        this.e = fragment.mMaxState.ordinal();
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2105c);
        sb.append(" (");
        sb.append(this.f2107d);
        sb.append(")}:");
        if (this.f2103a) {
            sb.append(" fromLayout");
        }
        int i = this.d;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.f2109e;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f2104b) {
            sb.append(" retainInstance");
        }
        if (this.f2106c) {
            sb.append(" removing");
        }
        if (this.f2108d) {
            sb.append(" detached");
        }
        if (this.f2110e) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2105c);
        parcel.writeString(this.f2107d);
        parcel.writeInt(this.f2103a ? 1 : 0);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.f2109e);
        parcel.writeInt(this.f2104b ? 1 : 0);
        parcel.writeInt(this.f2106c ? 1 : 0);
        parcel.writeInt(this.f2108d ? 1 : 0);
        parcel.writeBundle(this.a);
        parcel.writeInt(this.f2110e ? 1 : 0);
        parcel.writeBundle(this.b);
        parcel.writeInt(this.e);
    }

    public FragmentState(Parcel parcel) {
        this.f2105c = parcel.readString();
        this.f2107d = parcel.readString();
        boolean z = true;
        this.f2103a = parcel.readInt() != 0;
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.f2109e = parcel.readString();
        this.f2104b = parcel.readInt() != 0;
        this.f2106c = parcel.readInt() != 0;
        this.f2108d = parcel.readInt() != 0;
        this.a = parcel.readBundle();
        this.f2110e = parcel.readInt() == 0 ? false : z;
        this.b = parcel.readBundle();
        this.e = parcel.readInt();
    }
}
