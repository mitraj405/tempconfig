package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();
    public final CharSequence a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f2032a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2033a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f2034a;
    public final CharSequence b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<String> f2035b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f2036b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f2037c;

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f2038c;

    /* renamed from: c  reason: collision with other field name */
    public final int[] f2039c;
    public final int d;
    public final int e;
    public final int f;

    public class a implements Parcelable.Creator<BackStackState> {
        public final Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public final Object[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(a aVar) {
        int size = aVar.f2118a.size();
        this.f2034a = new int[(size * 5)];
        if (aVar.f2119a) {
            this.f2032a = new ArrayList<>(size);
            this.f2036b = new int[size];
            this.f2039c = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                FragmentTransaction.a aVar2 = aVar.f2118a.get(i);
                int i3 = i2 + 1;
                this.f2034a[i2] = aVar2.a;
                ArrayList<String> arrayList = this.f2032a;
                Fragment fragment = aVar2.f2125a;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f2034a;
                int i4 = i3 + 1;
                iArr[i3] = aVar2.b;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.d;
                iArr[i6] = aVar2.e;
                this.f2036b[i] = aVar2.f2126a.ordinal();
                this.f2039c[i] = aVar2.f2127b.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.c = aVar.e;
            this.f2037c = aVar.f2117a;
            this.d = aVar.h;
            this.e = aVar.f;
            this.a = aVar.f2116a;
            this.f = aVar.g;
            this.b = aVar.f2120b;
            this.f2035b = aVar.f2121b;
            this.f2038c = aVar.f2123c;
            this.f2033a = aVar.f2124c;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f2034a);
        parcel.writeStringList(this.f2032a);
        parcel.writeIntArray(this.f2036b);
        parcel.writeIntArray(this.f2039c);
        parcel.writeInt(this.c);
        parcel.writeString(this.f2037c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        TextUtils.writeToParcel(this.a, parcel, 0);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.b, parcel, 0);
        parcel.writeStringList(this.f2035b);
        parcel.writeStringList(this.f2038c);
        parcel.writeInt(this.f2033a ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f2034a = parcel.createIntArray();
        this.f2032a = parcel.createStringArrayList();
        this.f2036b = parcel.createIntArray();
        this.f2039c = parcel.createIntArray();
        this.c = parcel.readInt();
        this.f2037c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f = parcel.readInt();
        this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2035b = parcel.createStringArrayList();
        this.f2038c = parcel.createStringArrayList();
        this.f2033a = parcel.readInt() != 0;
    }
}
