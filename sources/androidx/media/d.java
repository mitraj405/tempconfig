package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: MediaBrowserServiceCompat */
public final class d implements Runnable {
    public final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.h f2242a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MediaBrowserServiceCompat.i f2243a;
    public final /* synthetic */ String c;

    public d(MediaBrowserServiceCompat.h hVar, MediaBrowserServiceCompat.j jVar, String str, IBinder iBinder) {
        this.f2242a = hVar;
        this.f2243a = jVar;
        this.c = str;
        this.a = iBinder;
    }

    public final void run() {
        IBinder a2 = ((MediaBrowserServiceCompat.j) this.f2243a).a();
        MediaBrowserServiceCompat.h hVar = this.f2242a;
        MediaBrowserServiceCompat.b orDefault = MediaBrowserServiceCompat.this.a.getOrDefault(a2, null);
        if (orDefault != null) {
            MediaBrowserServiceCompat.this.getClass();
            HashMap<String, List<Pair<IBinder, Bundle>>> hashMap = orDefault.f2232a;
            String str = this.c;
            F f = this.a;
            if (f == null) {
                hashMap.remove(str);
                return;
            }
            List list = hashMap.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (f == ((Pair) it.next()).a) {
                        it.remove();
                    }
                }
                if (list.size() == 0) {
                    hashMap.remove(str);
                }
            }
        }
    }
}
