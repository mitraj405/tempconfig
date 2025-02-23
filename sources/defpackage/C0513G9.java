package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: G9  reason: default package and case insensitive filesystem */
/* compiled from: DurationUnitJvm.kt */
public enum C0513G9 {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    

    /* renamed from: a  reason: collision with other field name */
    public final TimeUnit f3590a;

    /* access modifiers changed from: public */
    C0513G9(TimeUnit timeUnit) {
        this.f3590a = timeUnit;
    }
}
