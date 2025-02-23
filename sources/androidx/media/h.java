package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
public final class h implements Runnable {
    public final /* synthetic */ ResultReceiver a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f2249a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2250a;

    public h(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f2249a = hVar;
        this.f2250a = jVar;
        this.a = resultReceiver;
    }

    public final void run() {
        IBinder a2 = ((MediaBrowserServiceCompat.j) this.f2250a).a();
        MediaBrowserServiceCompat.h hVar = this.f2249a;
        if (MediaBrowserServiceCompat.this.a.getOrDefault(a2, null) != null) {
            MediaBrowserServiceCompat.this.getClass();
            this.a.send(-1, (Bundle) null);
        }
    }
}
