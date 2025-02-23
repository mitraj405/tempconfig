package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;

/* renamed from: Qv  reason: default package */
/* compiled from: SegmentPool */
public final class Qv {
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static Ov f3779a;

    public static void a(Ov ov) {
        if (ov.f3743a != null || ov.f3746b != null) {
            throw new IllegalArgumentException();
        } else if (!ov.f3744a) {
            synchronized (Qv.class) {
                long j = a + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                if (j <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    a = j;
                    ov.f3743a = f3779a;
                    ov.b = 0;
                    ov.a = 0;
                    f3779a = ov;
                }
            }
        }
    }

    public static Ov b() {
        synchronized (Qv.class) {
            Ov ov = f3779a;
            if (ov == null) {
                return new Ov();
            }
            f3779a = ov.f3743a;
            ov.f3743a = null;
            a -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return ov;
        }
    }
}
