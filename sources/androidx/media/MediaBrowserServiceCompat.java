package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    public final ArrayMap<IBinder, b> a = new ArrayMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final b f2222a = new b("android.media.session.MediaController", -1, -1, (i) null);

    /* renamed from: a  reason: collision with other field name */
    public e f2223a;

    /* renamed from: a  reason: collision with other field name */
    public final h f2224a = new h();

    /* renamed from: a  reason: collision with other field name */
    public final k f2225a = new k(this);

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f2226a = new ArrayList<>();

    public static final class a {
        public final Bundle a;

        /* renamed from: a  reason: collision with other field name */
        public final String f2227a;

        public a(String str, Bundle bundle) {
            if (str != null) {
                this.f2227a = str;
                this.a = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        }
    }

    public class b implements IBinder.DeathRecipient {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public a f2228a;

        /* renamed from: a  reason: collision with other field name */
        public final i f2229a;

        /* renamed from: a  reason: collision with other field name */
        public final String f2231a;

        /* renamed from: a  reason: collision with other field name */
        public final HashMap<String, List<Pair<IBinder, Bundle>>> f2232a = new HashMap<>();
        public final int b;

        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                b bVar = b.this;
                MediaBrowserServiceCompat.this.a.remove(((j) bVar.f2229a).a());
            }
        }

        public b(String str, int i, int i2, i iVar) {
            this.f2231a = str;
            this.a = i;
            this.b = i2;
            if (str == null) {
                throw new NullPointerException("package shouldn't be null");
            } else if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 28) {
                    new Sk(str, i, i2);
                }
                this.f2229a = iVar;
            } else {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
        }

        public final void binderDied() {
            MediaBrowserServiceCompat.this.f2225a.post(new a());
        }
    }

    public class c {
        public Messenger a;

        /* renamed from: a  reason: collision with other field name */
        public a f2233a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList f2235a = new ArrayList();

        public class a extends MediaBrowserService {
            public a(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
                attachBaseContext(mediaBrowserServiceCompat);
            }

            public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
                Bundle bundle2;
                Bundle bundle3;
                a aVar;
                MediaSessionCompat.ensureClassLoader(bundle);
                if (bundle == null) {
                    bundle2 = null;
                } else {
                    bundle2 = new Bundle(bundle);
                }
                c cVar = c.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                int i2 = -1;
                if (bundle2 == null || bundle2.getInt("extra_client_version", 0) == 0) {
                    bundle3 = null;
                } else {
                    bundle2.remove("extra_client_version");
                    cVar.a = new Messenger(mediaBrowserServiceCompat.f2225a);
                    bundle3 = new Bundle();
                    bundle3.putInt("extra_service_version", 2);
                    bundle3.putBinder("extra_messenger", cVar.a.getBinder());
                    cVar.f2235a.add(bundle3);
                    i2 = bundle2.getInt("extra_calling_pid", -1);
                    bundle2.remove("extra_calling_pid");
                }
                b bVar = new b(str, i2, i, (i) null);
                mediaBrowserServiceCompat.getClass();
                a a2 = mediaBrowserServiceCompat.a();
                if (a2 == null) {
                    aVar = null;
                } else {
                    if (cVar.a != null) {
                        mediaBrowserServiceCompat.f2226a.add(bVar);
                    }
                    Bundle bundle4 = a2.a;
                    if (bundle3 == null) {
                        bundle3 = bundle4;
                    } else if (bundle4 != null) {
                        bundle3.putAll(bundle4);
                    }
                    aVar = new a(a2.f2227a, bundle3);
                }
                if (aVar == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(aVar.f2227a, aVar.a);
            }

            public final void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
                c cVar = c.this;
                cVar.getClass();
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                b bVar = mediaBrowserServiceCompat.f2222a;
                mediaBrowserServiceCompat.b();
            }
        }

        public c() {
        }
    }

    public class d extends c {

        public class a extends c.a {
            public a(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
                super(mediaBrowserServiceCompat);
            }

            public final void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
                g gVar = new g(result);
                b bVar = MediaBrowserServiceCompat.this.f2222a;
                gVar.a(null);
            }
        }

        public d() {
            super();
        }
    }

    public class e extends d {

        public class a extends d.a {
            public a(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
                super(mediaBrowserServiceCompat);
            }

            public final void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                e eVar = e.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                b bVar = mediaBrowserServiceCompat.f2222a;
                mediaBrowserServiceCompat.b();
                MediaBrowserServiceCompat.this.getClass();
            }
        }

        public e() {
            super();
        }

        public final void a() {
            a aVar = new a(MediaBrowserServiceCompat.this);
            this.f2233a = aVar;
            aVar.onCreate();
        }
    }

    public class f extends e {
        public f(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super();
        }
    }

    public static class g<T> {
        public final MediaBrowserService.Result a;

        public g(MediaBrowserService.Result result) {
            this.a = result;
        }

        public final void a(T t) {
            boolean z = t instanceof List;
            ArrayList arrayList = null;
            MediaBrowserService.Result result = this.a;
            if (z) {
                List<Parcel> list = (List) t;
                if (list != null) {
                    arrayList = new ArrayList(list.size());
                    for (Parcel parcel : list) {
                        parcel.setDataPosition(0);
                        arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                        parcel.recycle();
                    }
                }
                result.sendResult(arrayList);
            } else if (t instanceof Parcel) {
                Parcel parcel2 = (Parcel) t;
                parcel2.setDataPosition(0);
                result.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel2));
                parcel2.recycle();
            } else {
                result.sendResult((Object) null);
            }
        }
    }

    public class h {
        public h() {
        }
    }

    public interface i {
    }

    public static class j implements i {
        public final Messenger a;

        public j(Messenger messenger) {
            this.a = messenger;
        }

        public final IBinder a() {
            return this.a.getBinder();
        }
    }

    public static final class k extends Handler {
        public MediaBrowserServiceCompat a;

        public k(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.a = mediaBrowserServiceCompat;
        }

        public final void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public final void handleMessage(Message message) {
            Message message2 = message;
            MediaBrowserServiceCompat mediaBrowserServiceCompat = this.a;
            if (mediaBrowserServiceCompat != null) {
                Bundle data = message.getData();
                int i = message2.what;
                h hVar = mediaBrowserServiceCompat.f2224a;
                switch (i) {
                    case 1:
                        Bundle bundle = data.getBundle("data_root_hints");
                        MediaSessionCompat.ensureClassLoader(bundle);
                        String string = data.getString("data_package_name");
                        int i2 = data.getInt("data_calling_pid");
                        int i3 = data.getInt("data_calling_uid");
                        j jVar = new j(message2.replyTo);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                        boolean z = false;
                        if (string == null) {
                            mediaBrowserServiceCompat2.getClass();
                        } else {
                            String[] packagesForUid = mediaBrowserServiceCompat2.getPackageManager().getPackagesForUid(i3);
                            int length = packagesForUid.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 < length) {
                                    if (packagesForUid[i4].equals(string)) {
                                        z = true;
                                    } else {
                                        i4++;
                                    }
                                }
                            }
                        }
                        if (z) {
                            mediaBrowserServiceCompat2.f2225a.a(new a(i2, i3, bundle, hVar, jVar, string));
                            return;
                        }
                        throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + string);
                    case 2:
                        MediaBrowserServiceCompat.this.f2225a.a(new b(hVar, new j(message2.replyTo)));
                        return;
                    case 3:
                        Bundle bundle2 = data.getBundle("data_options");
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        MediaBrowserServiceCompat.this.f2225a.a(new c(hVar, new j(message2.replyTo), data.getString("data_media_item_id"), data.getBinder("data_callback_token"), bundle2));
                        return;
                    case 4:
                        MediaBrowserServiceCompat.this.f2225a.a(new d(hVar, new j(message2.replyTo), data.getString("data_media_item_id"), data.getBinder("data_callback_token")));
                        return;
                    case 5:
                        String string2 = data.getString("data_media_item_id");
                        ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                        j jVar2 = new j(message2.replyTo);
                        hVar.getClass();
                        if (!TextUtils.isEmpty(string2) && resultReceiver != null) {
                            MediaBrowserServiceCompat.this.f2225a.a(new e(hVar, jVar2, string2, resultReceiver));
                            return;
                        }
                        return;
                    case 6:
                        Bundle bundle3 = data.getBundle("data_root_hints");
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        j jVar3 = new j(message2.replyTo);
                        String string3 = data.getString("data_package_name");
                        MediaBrowserServiceCompat.this.f2225a.a(new f(data.getInt("data_calling_uid"), data.getInt("data_calling_pid"), bundle3, hVar, jVar3, string3));
                        return;
                    case 7:
                        MediaBrowserServiceCompat.this.f2225a.a(new g(hVar, new j(message2.replyTo)));
                        return;
                    case 8:
                        Bundle bundle4 = data.getBundle("data_search_extras");
                        MediaSessionCompat.ensureClassLoader(bundle4);
                        String string4 = data.getString("data_search_query");
                        ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                        j jVar4 = new j(message2.replyTo);
                        hVar.getClass();
                        if (!TextUtils.isEmpty(string4) && resultReceiver2 != null) {
                            MediaBrowserServiceCompat.this.f2225a.a(new h(hVar, jVar4, string4, bundle4, resultReceiver2));
                            return;
                        }
                        return;
                    case 9:
                        Bundle bundle5 = data.getBundle("data_custom_action_extras");
                        MediaSessionCompat.ensureClassLoader(bundle5);
                        String string5 = data.getString("data_custom_action");
                        ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                        j jVar5 = new j(message2.replyTo);
                        hVar.getClass();
                        if (!TextUtils.isEmpty(string5) && resultReceiver3 != null) {
                            MediaBrowserServiceCompat.this.f2225a.a(new i(hVar, jVar5, string5, bundle5, resultReceiver3));
                            return;
                        }
                        return;
                    default:
                        message.toString();
                        return;
                }
            } else {
                removeCallbacksAndMessages((Object) null);
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j);
        }
    }

    static {
        Log.isLoggable("MBServiceCompat", 3);
    }

    public abstract a a();

    public abstract void b();

    public final IBinder onBind(Intent intent) {
        return this.f2223a.f2233a.onBind(intent);
    }

    public final void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2223a = new f(this);
        } else {
            this.f2223a = new e();
        }
        this.f2223a.a();
    }

    public final void onDestroy() {
        this.f2225a.a = null;
    }

    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
