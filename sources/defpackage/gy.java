package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: gy  reason: default package */
/* compiled from: StorageNotLowTracker */
public final class gy extends n3<Boolean> {
    static {
        zi.e("StorageNotLowTracker");
    }

    public gy(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public final Object a() {
        Intent registerReceiver = this.f492a.registerReceiver((BroadcastReceiver) null, e());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = registerReceiver.getAction();
        action.getClass();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return null;
        }
        return Boolean.TRUE;
    }

    public final IntentFilter e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    public final void f(Intent intent) {
        if (intent.getAction() != null) {
            zi c = zi.c();
            String.format("Received %s", new Object[]{intent.getAction()});
            c.a(new Throwable[0]);
            String action = intent.getAction();
            action.getClass();
            if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                b(Boolean.FALSE);
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                b(Boolean.TRUE);
            }
        }
    }
}
