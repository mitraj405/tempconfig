package defpackage;

import android.view.View;
import androidx.constraintlayout.motion.widget.c;
import com.google.firebase.perf.session.gauges.CpuGaugeCollector;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.RemoteConfigKt$configUpdates$1$registration$1;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import in.juspay.hypersdk.analytics.LogChannelExp;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.safe.JuspayWebView;
import in.juspay.services.HyperServices;
import kotlinx.coroutines.channels.ProducerScope;

/* renamed from: PC  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class PC implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    public /* synthetic */ PC(int i, Object obj, Object obj2) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                c cVar = (c) obj2;
                View[] viewArr = (View[]) obj;
                if (cVar.j != -1) {
                    for (View tag : viewArr) {
                        tag.setTag(cVar.j, Long.valueOf(System.nanoTime()));
                    }
                }
                if (cVar.k != -1) {
                    for (View tag2 : viewArr) {
                        tag2.setTag(cVar.k, (Object) null);
                    }
                    return;
                }
                return;
            case 1:
                ((CpuGaugeCollector) obj2).lambda$scheduleCpuMetricCollectionOnce$1((Timer) obj);
                return;
            case 2:
                RemoteConfigKt$configUpdates$1$registration$1.onUpdate$lambda$0((ProducerScope) obj2, (ConfigUpdate) obj);
                return;
            case 3:
                ((RolloutsStateSubscriber) obj2).onRolloutsStateChanged((RolloutsState) obj);
                return;
            case 4:
                LogPusherExp.lambda$static$0((String) obj2, (LogChannelExp) obj);
                return;
            case 5:
                ((JuspayWebView) obj2).lambda$addJsToWebView$0((String) obj);
                return;
            default:
                ((HyperServices) obj2).lambda$uncaughtException$8((Throwable) obj);
                return;
        }
    }
}
