package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();
    public ArrayList<FragmentState> a;

    /* renamed from: a  reason: collision with other field name */
    public BackStackState[] f2100a;
    public ArrayList<String> b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f2101c = null;

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f2102c = new ArrayList<>();
    public final ArrayList<Bundle> d = new ArrayList<>();
    public ArrayList<FragmentManager.LaunchedFragmentInfo> e;

    public class a implements Parcelable.Creator<FragmentManagerState> {
        public final Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public final Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
        parcel.writeStringList(this.b);
        parcel.writeTypedArray(this.f2100a, i);
        parcel.writeInt(this.c);
        parcel.writeString(this.f2101c);
        parcel.writeStringList(this.f2102c);
        parcel.writeTypedList(this.d);
        parcel.writeTypedList(this.e);
    }

    public FragmentManagerState(Parcel parcel) {
        this.a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.b = parcel.createStringArrayList();
        this.f2100a = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.c = parcel.readInt();
        this.f2101c = parcel.readString();
        this.f2102c = parcel.createStringArrayList();
        this.d = parcel.createTypedArrayList(Bundle.CREATOR);
        this.e = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
