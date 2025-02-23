package androidx.work;

import android.app.Notification;

public final class ForegroundInfo {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Notification f2636a;
    public final int b;

    public ForegroundInfo(int i, int i2, Notification notification) {
        this.a = i;
        this.f2636a = notification;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ForegroundInfo.class != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.a == foregroundInfo.a && this.b == foregroundInfo.b) {
            return this.f2636a.equals(foregroundInfo.f2636a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2636a.hashCode() + (((this.a * 31) + this.b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.f2636a + '}';
    }
}
