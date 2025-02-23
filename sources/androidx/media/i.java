package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Objects;

/* compiled from: MediaBrowserServiceCompat */
public final class i implements Runnable {
    public final /* synthetic */ Bundle a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ResultReceiver f2251a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f2252a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2253a;

    public i(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.f2252a = hVar;
        this.f2253a = jVar;
        this.a = bundle;
        this.f2251a = resultReceiver;
    }

    public final void run() {
        IBinder a2 = ((MediaBrowserServiceCompat.j) this.f2253a).a();
        MediaBrowserServiceCompat.h hVar = this.f2252a;
        if (MediaBrowserServiceCompat.this.a.getOrDefault(a2, null) == null) {
            Objects.toString(this.a);
            return;
        }
        MediaBrowserServiceCompat.this.getClass();
        this.f2251a.send(-1, (Bundle) null);
    }
}
