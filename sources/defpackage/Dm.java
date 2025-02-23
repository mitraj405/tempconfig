package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: Dm  reason: default package */
/* compiled from: NetworkStateTracker */
public final class Dm extends R6<Cm> {
    public static final /* synthetic */ int b = 0;
    public final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final ConnectivityManager f123a = ((ConnectivityManager) this.f492a.getSystemService("connectivity"));

    /* renamed from: Dm$a */
    /* compiled from: NetworkStateTracker */
    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            zi c = zi.c();
            int i = Dm.b;
            String.format("Network capabilities changed: %s", new Object[]{networkCapabilities});
            c.a(new Throwable[0]);
            Dm dm = Dm.this;
            dm.b(dm.e());
        }

        public final void onLost(Network network) {
            zi c = zi.c();
            int i = Dm.b;
            c.a(new Throwable[0]);
            Dm dm = Dm.this;
            dm.b(dm.e());
        }
    }

    static {
        zi.e("NetworkStateTracker");
    }

    public Dm(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public final Object a() {
        return e();
    }

    public final void c() {
        try {
            zi.c().a(new Throwable[0]);
            this.f123a.registerDefaultNetworkCallback(this.a);
        } catch (IllegalArgumentException | SecurityException e) {
            zi.c().b(e);
        }
    }

    public final void d() {
        try {
            zi.c().a(new Throwable[0]);
            this.f123a.unregisterNetworkCallback(this.a);
        } catch (IllegalArgumentException | SecurityException e) {
            zi.c().b(e);
        }
    }

    public final Cm e() {
        boolean z;
        boolean z2;
        ConnectivityManager connectivityManager = this.f123a;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z3 = true;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z = false;
        } else {
            z = true;
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                z2 = true;
                boolean isActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
                if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
                    z3 = false;
                }
                return new Cm(z, z2, isActiveNetworkMetered, z3);
            }
        } catch (SecurityException e) {
            zi.c().b(e);
        }
        z2 = false;
        boolean isActiveNetworkMetered2 = connectivityManager.isActiveNetworkMetered();
        z3 = false;
        return new Cm(z, z2, isActiveNetworkMetered2, z3);
    }
}
