package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaBrowserServiceCompat */
public final class c implements Runnable {
    public final /* synthetic */ Bundle a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ IBinder f2239a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f2240a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2241a;
    public final /* synthetic */ String c;

    public c(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar, String str, IBinder iBinder, Bundle bundle) {
        this.f2240a = hVar;
        this.f2241a = jVar;
        this.c = str;
        this.f2239a = iBinder;
        this.a = bundle;
    }

    public final void run() {
        IBinder a2 = ((MediaBrowserServiceCompat.j) this.f2241a).a();
        MediaBrowserServiceCompat.h hVar = this.f2240a;
        MediaBrowserServiceCompat.b orDefault = MediaBrowserServiceCompat.this.a.getOrDefault(a2, null);
        if (orDefault != null) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.getClass();
            HashMap<String, List<Pair<IBinder, Bundle>>> hashMap = orDefault.f2232a;
            String str = this.c;
            List list = hashMap.get(str);
            if (list == null) {
                list = new ArrayList();
            }
            Iterator it = list.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                Bundle bundle = this.a;
                F f = this.f2239a;
                if (hasNext) {
                    Pair pair = (Pair) it.next();
                    if (f == pair.a && r1.e(bundle, (Bundle) pair.b)) {
                        return;
                    }
                } else {
                    list.add(new Pair(f, bundle));
                    hashMap.put(str, list);
                    if (bundle == null) {
                        mediaBrowserServiceCompat.b();
                    } else {
                        mediaBrowserServiceCompat.b();
                    }
                    throw new IllegalStateException(C1058d.B(new StringBuilder("onLoadChildren must call detach() or sendResult() before returning for package="), orDefault.f2231a, " id=", str));
                }
            }
        }
    }
}
