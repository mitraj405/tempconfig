package defpackage;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

/* renamed from: Rk  reason: default package */
/* compiled from: MediaSessionManager */
public final class Rk {
    public final Tk a;

    public Rk(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.a = new Sk(str, i, i2);
        } else {
            this.a = new Tk(str, i, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rk)) {
            return false;
        }
        return this.a.equals(((Rk) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public Rk(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String q = remoteUserInfo.getPackageName();
        if (q == null) {
            throw new NullPointerException("package shouldn't be null");
        } else if (!TextUtils.isEmpty(q)) {
            this.a = new Sk(remoteUserInfo);
        } else {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
    }
}
