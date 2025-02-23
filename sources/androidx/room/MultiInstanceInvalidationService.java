package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {
    public final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f2408a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<Integer, String> f2409a = new HashMap<>();
    public int c = 0;

    public class a extends RemoteCallbackList<Cif> {
        public a() {
        }

        public final void onCallbackDied(IInterface iInterface, Object obj) {
            Cif ifVar = (Cif) iInterface;
            MultiInstanceInvalidationService.this.f2409a.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends jf {
        public b() {
        }

        public final void b(String[] strArr, int i) {
            synchronized (MultiInstanceInvalidationService.this.a) {
                String str = MultiInstanceInvalidationService.this.f2409a.get(Integer.valueOf(i));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.a.beginBroadcast();
                    int i2 = 0;
                    while (i2 < beginBroadcast) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.a.getBroadcastCookie(i2)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.f2409a.get(Integer.valueOf(intValue));
                            if (i != intValue && str.equals(str2)) {
                                try {
                                    ((Cif) MultiInstanceInvalidationService.this.a.getBroadcastItem(i2)).a(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                            i2++;
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.a.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.a.finishBroadcast();
                }
            }
        }

        public final int c(Cif ifVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.a) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.c + 1;
                multiInstanceInvalidationService.c = i;
                if (multiInstanceInvalidationService.a.register(ifVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.f2409a.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.c--;
                return 0;
            }
        }
    }

    public final IBinder onBind(Intent intent) {
        return this.f2408a;
    }
}
