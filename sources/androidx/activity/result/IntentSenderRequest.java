package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: IntentSenderRequest.kt */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();
    public final Intent a;

    /* renamed from: a  reason: collision with other field name */
    public final IntentSender f830a;
    public final int c;
    public final int d;

    /* compiled from: IntentSenderRequest.kt */
    public static final class a implements Parcelable.Creator<IntentSenderRequest> {
        public final Object createFromParcel(Parcel parcel) {
            C1177ig.f(parcel, "inParcel");
            Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
            C1177ig.c(readParcelable);
            return new IntentSenderRequest((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        public final Object[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i, int i2) {
        C1177ig.f(intentSender, "intentSender");
        this.f830a = intentSender;
        this.a = intent;
        this.c = i;
        this.d = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        C1177ig.f(parcel, "dest");
        parcel.writeParcelable(this.f830a, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
