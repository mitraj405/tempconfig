package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.ImageDownload;
import com.google.firebase.perf.config.DeviceCacheManager;
import com.google.firebase.perf.session.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ktx.RemoteConfigKt$configUpdates$1$registration$1;
import com.journeyapps.barcodescanner.camera.CameraManager;
import com.momagic.B;
import in.juspay.hypernfc.NfcActivity;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogSessioniserExp;
import in.juspay.hypersdk.core.JBridge;
import in.juspay.hypersdk.core.JuspayServices;
import java.util.Random;
import kotlinx.coroutines.channels.ProducerScope;
import org.json.JSONObject;

/* renamed from: zq  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0428zq implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    public /* synthetic */ C0428zq(int i, Object obj, Object obj2) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
    }

    public final void run() {
        Handler handler;
        int i = this.c;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                Context context = (Context) obj;
                ((ProfileInstallerInitializer) obj2).getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = ProfileInstallerInitializer.b.a(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new i1(context, 1), (long) (new Random().nextInt(Math.max(1000, 1)) + 5000));
                return;
            case 1:
                ((RemovalListener) obj2).onRemoval((RemovalNotification) obj);
                return;
            case 2:
                ((FirebaseMessaging) obj2).lambda$deleteToken$8((TaskCompletionSource) obj);
                return;
            case 3:
                ((ImageDownload) obj2).lambda$start$0((TaskCompletionSource) obj);
                return;
            case 4:
                ((DeviceCacheManager) obj2).lambda$setContext$0((Context) obj);
                return;
            case 5:
                ((MemoryGaugeCollector) obj2).lambda$scheduleMemoryMetricCollectionWithRate$0((Timer) obj);
                return;
            case 6:
                RemoteConfigKt$configUpdates$1$registration$1.onUpdate$lambda$0((ProducerScope) obj2, (ConfigUpdate) obj);
                return;
            case 7:
                C1287nq nqVar = (C1287nq) obj;
                CameraManager cameraManager = ((O3) obj2).f3731a;
                Camera camera = cameraManager.f3987a;
                if (camera != null && cameraManager.f3994a) {
                    CameraManager.a aVar = cameraManager.f3989a;
                    aVar.f3996a = nqVar;
                    camera.setOneShotPreviewCallback(aVar);
                    return;
                }
                return;
            case 8:
                ((B.b) obj2).b((String) obj);
                return;
            case 9:
                ((NfcActivity) obj2).lambda$onCreate$0((ImageView) obj);
                return;
            case 10:
                LogPusher.lambda$setHeaders$6((String) obj2, (JSONObject) obj);
                return;
            case 11:
                ((LogSessioniserExp) obj2).lambda$addLogLine$1((JSONObject) obj);
                return;
            case 12:
                ((JBridge) obj2).lambda$hideJuspayLoader$1((String) obj);
                return;
            default:
                ((JuspayServices) obj2).lambda$new$0((JSONObject) obj);
                return;
        }
    }
}
