package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* renamed from: fC  reason: default package and case insensitive filesystem */
/* compiled from: VersionedParcelParcel */
public final class C0192fC extends C0177eC {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Parcel f2927a;

    /* renamed from: a  reason: collision with other field name */
    public final SparseIntArray f2928a;

    /* renamed from: a  reason: collision with other field name */
    public final String f2929a;
    public final int b;
    public int c;
    public int d;
    public int e;

    public C0192fC(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public final C0192fC a() {
        Parcel parcel = this.f2927a;
        int dataPosition = parcel.dataPosition();
        int i = this.d;
        if (i == this.a) {
            i = this.b;
        }
        return new C0192fC(parcel, dataPosition, i, C0709Uj.j(new StringBuilder(), this.f2929a, "  "), this.a, this.b, this.c);
    }

    public final boolean e() {
        if (this.f2927a.readInt() != 0) {
            return true;
        }
        return false;
    }

    public final byte[] f() {
        Parcel parcel = this.f2927a;
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        parcel.readByteArray(bArr);
        return bArr;
    }

    public final CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2927a);
    }

    public final boolean h(int i) {
        while (this.d < this.b) {
            int i2 = this.e;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            int i3 = this.d;
            Parcel parcel = this.f2927a;
            parcel.setDataPosition(i3);
            int readInt = parcel.readInt();
            this.e = parcel.readInt();
            this.d += readInt;
        }
        if (this.e == i) {
            return true;
        }
        return false;
    }

    public final int i() {
        return this.f2927a.readInt();
    }

    public final <T extends Parcelable> T k() {
        return this.f2927a.readParcelable(C0192fC.class.getClassLoader());
    }

    public final String m() {
        return this.f2927a.readString();
    }

    public final void o(int i) {
        x();
        this.c = i;
        this.f2928a.put(i, this.f2927a.dataPosition());
        s(0);
        s(i);
    }

    public final void p(boolean z) {
        this.f2927a.writeInt(z ? 1 : 0);
    }

    public final void q(byte[] bArr) {
        Parcel parcel = this.f2927a;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
            return;
        }
        parcel.writeInt(-1);
    }

    public final void r(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2927a, 0);
    }

    public final void s(int i) {
        this.f2927a.writeInt(i);
    }

    public final void u(Parcelable parcelable) {
        this.f2927a.writeParcelable(parcelable, 0);
    }

    public final void v(String str) {
        this.f2927a.writeString(str);
    }

    public final void x() {
        int i = this.c;
        if (i >= 0) {
            int i2 = this.f2928a.get(i);
            Parcel parcel = this.f2927a;
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i2);
            parcel.writeInt(dataPosition - i2);
            parcel.setDataPosition(dataPosition);
        }
    }

    public C0192fC(Parcel parcel, int i, int i2, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f2928a = new SparseIntArray();
        this.c = -1;
        this.e = -1;
        this.f2927a = parcel;
        this.a = i;
        this.b = i2;
        this.d = i;
        this.f2929a = str;
    }
}
