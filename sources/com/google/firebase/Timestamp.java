package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import java.time.Instant;
import java.util.Date;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Timestamp.kt */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    public static final Parcelable.Creator<Timestamp> CREATOR = new Timestamp$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int nanoseconds;
    private final long seconds;

    /* compiled from: Timestamp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Pair<Long, Integer> toPreciseTime(Date date) {
            long j = (long) 1000;
            long time = date.getTime() / j;
            int time2 = (int) ((date.getTime() % j) * ((long) 1000000));
            if (time2 < 0) {
                return new Pair<>(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000));
            }
            return new Pair<>(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* access modifiers changed from: private */
        public final void validateRange(long j, int i) {
            boolean z;
            boolean z2 = true;
            if (i < 0 || i >= 1000000000) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (-62135596800L > j || j >= 253402300800L) {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalArgumentException(C0709Uj.h("Timestamp seconds out of range: ", j).toString());
                }
                return;
            }
            throw new IllegalArgumentException(lf.h("Timestamp nanoseconds out of range: ", i).toString());
        }

        public final Timestamp now() {
            return new Timestamp(new Date());
        }
    }

    public Timestamp(long j, int i) {
        Companion.validateRange(j, i);
        this.seconds = j;
        this.nanoseconds = i;
    }

    public static final Timestamp now() {
        return Companion.now();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0)) {
            return true;
        }
        return false;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j = this.seconds;
        return (((((int) j) * 37 * 37) + ((int) (j >> 32))) * 37) + this.nanoseconds;
    }

    public final Date toDate() {
        return new Date((this.seconds * ((long) 1000)) + ((long) (this.nanoseconds / 1000000)));
    }

    public final Instant toInstant() {
        Instant ofEpochSecond = Instant.ofEpochSecond(this.seconds, (long) this.nanoseconds);
        C1177ig.e(ofEpochSecond, "ofEpochSecond(seconds, nanoseconds.toLong())");
        return ofEpochSecond;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1177ig.f(parcel, "dest");
        parcel.writeLong(this.seconds);
        parcel.writeInt(this.nanoseconds);
    }

    public int compareTo(Timestamp timestamp) {
        C1177ig.f(timestamp, "other");
        Function1[] function1Arr = {Timestamp$compareTo$1.INSTANCE, Timestamp$compareTo$2.INSTANCE};
        for (int i = 0; i < 2; i++) {
            Function1 function1 = function1Arr[i];
            Comparable comparable = (Comparable) function1.invoke(this);
            Comparable comparable2 = (Comparable) function1.invoke(timestamp);
            int compareTo = comparable == comparable2 ? 0 : comparable == null ? -1 : comparable2 == null ? 1 : comparable.compareTo(comparable2);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public Timestamp(Date date) {
        C1177ig.f(date, "date");
        Companion companion = Companion;
        Pair access$toPreciseTime = companion.toPreciseTime(date);
        long longValue = ((Number) access$toPreciseTime.a).longValue();
        int intValue = ((Number) access$toPreciseTime.b).intValue();
        companion.validateRange(longValue, intValue);
        this.seconds = longValue;
        this.nanoseconds = intValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Timestamp(Instant instant) {
        this(instant.getEpochSecond(), instant.getNano());
        C1177ig.f(instant, "time");
    }
}
