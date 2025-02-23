package androidx.media;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
public final class g implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.h a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2248a;

    public g(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar) {
        this.a = hVar;
        this.f2248a = jVar;
    }

    public final void run() {
        IBinder a2 = ((MediaBrowserServiceCompat.j) this.f2248a).a();
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.a.remove(a2);
        if (remove != null) {
            a2.unlinkToDeath(remove, 0);
        }
    }
}
