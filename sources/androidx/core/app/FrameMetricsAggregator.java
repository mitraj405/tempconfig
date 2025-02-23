package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class FrameMetricsAggregator {
    public final a a = new a();

    public static class a extends b {
        public static Handler a;

        /* renamed from: a  reason: collision with other field name */
        public static HandlerThread f1724a;

        /* renamed from: a  reason: collision with other field name */
        public final int f1725a = 1;

        /* renamed from: a  reason: collision with other field name */
        public final C0008a f1726a = new C0008a();

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<WeakReference<Activity>> f1727a = new ArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        public SparseIntArray[] f1728a = new SparseIntArray[9];

        /* renamed from: androidx.core.app.FrameMetricsAggregator$a$a  reason: collision with other inner class name */
        public class C0008a implements Window.OnFrameMetricsAvailableListener {
            public C0008a() {
            }

            public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                a aVar = a.this;
                if ((aVar.f1725a & 1) != 0) {
                    a.a(aVar.f1728a[0], frameMetrics.getMetric(8));
                }
                int i2 = aVar.f1725a;
                if ((i2 & 2) != 0) {
                    a.a(aVar.f1728a[1], frameMetrics.getMetric(1));
                }
                if ((i2 & 4) != 0) {
                    a.a(aVar.f1728a[2], frameMetrics.getMetric(3));
                }
                if ((i2 & 8) != 0) {
                    a.a(aVar.f1728a[3], frameMetrics.getMetric(4));
                }
                if ((i2 & 16) != 0) {
                    a.a(aVar.f1728a[4], frameMetrics.getMetric(5));
                }
                if ((i2 & 64) != 0) {
                    a.a(aVar.f1728a[6], frameMetrics.getMetric(7));
                }
                if ((i2 & 32) != 0) {
                    a.a(aVar.f1728a[5], frameMetrics.getMetric(6));
                }
                if ((i2 & 128) != 0) {
                    a.a(aVar.f1728a[7], frameMetrics.getMetric(0));
                }
                if ((i2 & 256) != 0) {
                    a.a(aVar.f1728a[8], frameMetrics.getMetric(2));
                }
            }
        }

        public static void a(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }
    }

    public static class b {
    }

    public final void a(Activity activity) {
        a aVar = this.a;
        ArrayList<WeakReference<Activity>> arrayList = aVar.f1727a;
        Iterator<WeakReference<Activity>> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference next = it.next();
            if (next.get() == activity) {
                arrayList.remove(next);
                break;
            }
        }
        activity.getWindow().removeOnFrameMetricsAvailableListener(aVar.f1726a);
    }
}
