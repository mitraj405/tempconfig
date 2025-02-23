package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
public final class e implements Runnable {
    public final /* synthetic */ ResultReceiver a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f2244a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2245a;

    public e(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar, String str, ResultReceiver resultReceiver) {
        this.f2244a = hVar;
        this.f2245a = jVar;
        this.a = resultReceiver;
    }

    public final void run() {
        IBinder a2 = ((MediaBrowserServiceCompat.j) this.f2245a).a();
        MediaBrowserServiceCompat.h hVar = this.f2244a;
        if (MediaBrowserServiceCompat.this.a.getOrDefault(a2, null) != null) {
            MediaBrowserServiceCompat.this.getClass();
            boolean z = true & true;
            ResultReceiver resultReceiver = this.a;
            if (z) {
                resultReceiver.send(-1, (Bundle) null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", (Parcelable) null);
            resultReceiver.send(0, bundle);
        }
    }
}
