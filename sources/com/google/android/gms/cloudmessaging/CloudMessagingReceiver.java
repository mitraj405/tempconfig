package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private static SoftReference zza;
    private static SoftReference zzb;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
    public static final class IntentActionKeys {
        public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";

        private IntentActionKeys() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
    public static final class IntentKeys {
        public static final String PENDING_INTENT = "pending_intent";
        public static final String WRAPPED_INTENT = "wrapped_intent";

        private IntentKeys() {
        }
    }

    private final int zzb(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(IntentKeys.PENDING_INTENT);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove(IntentKeys.PENDING_INTENT);
        } else {
            extras = new Bundle();
        }
        if (!Objects.equals(intent.getAction(), IntentActionKeys.NOTIFICATION_DISMISS)) {
            return 500;
        }
        onNotificationDismissed(context, extras);
        return -1;
    }

    public Executor getBroadcastExecutor() {
        ExecutorService executorService;
        synchronized (CloudMessagingReceiver.class) {
            SoftReference softReference = zza;
            if (softReference != null) {
                executorService = (ExecutorService) softReference.get();
            } else {
                executorService = null;
            }
            if (executorService == null) {
                zze.zza();
                executorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory("firebase-iid-executor")));
                zza = new SoftReference(executorService);
            }
        }
        return executorService;
    }

    public abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            getBroadcastExecutor().execute(new zzh(this, intent, context, isOrderedBroadcast(), goAsync()));
        }
    }

    public final /* synthetic */ void zza(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        Intent intent2;
        int i;
        Intent intent3 = intent;
        Context context2 = context;
        BroadcastReceiver.PendingResult pendingResult2 = pendingResult;
        try {
            Parcelable parcelableExtra = intent3.getParcelableExtra(IntentKeys.WRAPPED_INTENT);
            Executor executor = null;
            if (parcelableExtra instanceof Intent) {
                intent2 = (Intent) parcelableExtra;
            } else {
                intent2 = null;
            }
            if (intent2 != null) {
                i = zzb(context2, intent2);
            } else if (intent.getExtras() == null) {
                i = 500;
            } else {
                CloudMessage cloudMessage = new CloudMessage(intent3);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                synchronized (CloudMessagingReceiver.class) {
                    SoftReference softReference = zzb;
                    if (softReference != null) {
                        executor = (Executor) softReference.get();
                    }
                    if (executor == null) {
                        zze.zza();
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("pscm-ack-executor"));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        executor = Executors.unconfigurableExecutorService(threadPoolExecutor);
                        zzb = new SoftReference(executor);
                    }
                }
                executor.execute(new zzg(context2, cloudMessage, countDownLatch));
                int onMessageReceive = onMessageReceive(context2, cloudMessage);
                boolean await = countDownLatch.await(TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS);
                i = onMessageReceive;
            }
        } catch (InterruptedException e) {
            "Message ack failed: ".concat(e.toString());
        } catch (Throwable th) {
            if (pendingResult2 != null) {
                pendingResult.finish();
            }
            throw th;
        }
        if (z && pendingResult2 != null) {
            pendingResult2.setResultCode(i);
        }
        if (pendingResult2 != null) {
            pendingResult.finish();
        }
    }

    public void onNotificationDismissed(Context context, Bundle bundle) {
    }
}
