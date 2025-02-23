package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
public final class b implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.h a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2238a;

    public b(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar) {
        this.a = hVar;
        this.f2238a = jVar;
    }

    public final void run() {
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.a.remove(((MediaBrowserServiceCompat.j) this.f2238a).a());
        if (remove != null) {
            ((MediaBrowserServiceCompat.j) remove.f2229a).a().unlinkToDeath(remove, 0);
        }
    }
}
