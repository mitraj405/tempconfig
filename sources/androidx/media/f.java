package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

/* compiled from: MediaBrowserServiceCompat */
public final class f implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.h a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2246a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f2247c;
    public final /* synthetic */ int d;

    public f(int i, int i2, Bundle bundle, MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar, String str) {
        this.a = hVar;
        this.f2246a = jVar;
        this.c = i;
        this.f2247c = str;
        this.d = i2;
    }

    public final void run() {
        MediaBrowserServiceCompat.b bVar;
        IBinder a2 = ((MediaBrowserServiceCompat.j) this.f2246a).a();
        MediaBrowserServiceCompat.h hVar = this.a;
        MediaBrowserServiceCompat.this.a.remove(a2);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        Iterator<MediaBrowserServiceCompat.b> it = mediaBrowserServiceCompat.f2226a.iterator();
        while (true) {
            bVar = null;
            if (!it.hasNext()) {
                break;
            }
            MediaBrowserServiceCompat.b next = it.next();
            if (next.b == this.c) {
                if (TextUtils.isEmpty(this.f2247c) || this.d <= 0) {
                    bVar = new MediaBrowserServiceCompat.b(next.f2231a, next.a, next.b, this.f2246a);
                }
                it.remove();
            }
        }
        if (bVar == null) {
            bVar = new MediaBrowserServiceCompat.b(this.f2247c, this.d, this.c, this.f2246a);
        }
        mediaBrowserServiceCompat.a.put(a2, bVar);
        try {
            a2.linkToDeath(bVar, 0);
        } catch (RemoteException unused) {
        }
    }
}
