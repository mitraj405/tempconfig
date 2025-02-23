package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
public final class a implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat.h a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2236a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f2237c;
    public final /* synthetic */ int d;

    public a(int i, int i2, Bundle bundle, MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar, String str) {
        this.a = hVar;
        this.f2236a = jVar;
        this.f2237c = str;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        MediaBrowserServiceCompat.i iVar = this.f2236a;
        IBinder a2 = ((MediaBrowserServiceCompat.j) iVar).a();
        MediaBrowserServiceCompat.h hVar = this.a;
        MediaBrowserServiceCompat.this.a.remove(a2);
        MediaBrowserServiceCompat.b bVar = new MediaBrowserServiceCompat.b(this.f2237c, this.c, this.d, this.f2236a);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.getClass();
        bVar.f2228a = mediaBrowserServiceCompat.a();
        mediaBrowserServiceCompat.getClass();
        if (bVar.f2228a == null) {
            try {
                MediaBrowserServiceCompat.j jVar = (MediaBrowserServiceCompat.j) iVar;
                jVar.getClass();
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.arg1 = 2;
                obtain.setData((Bundle) null);
                jVar.a.send(obtain);
            } catch (RemoteException unused) {
            }
        } else {
            try {
                mediaBrowserServiceCompat.a.put(a2, bVar);
                a2.linkToDeath(bVar, 0);
                mediaBrowserServiceCompat.getClass();
            } catch (RemoteException unused2) {
                mediaBrowserServiceCompat.a.remove(a2);
            }
        }
    }
}
