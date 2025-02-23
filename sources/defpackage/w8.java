package defpackage;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.utils.LogType;
import in.juspay.hypersdk.utils.TrackerFallback;
import in.juspay.services.HyperServices;
import org.json.JSONObject;

/* renamed from: w8  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class w8 implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f3388c;
    public final /* synthetic */ Object d;

    public /* synthetic */ w8(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
        this.f3388c = obj3;
        this.d = obj4;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.d;
        Object obj2 = this.f3388c;
        Object obj3 = this.b;
        Object obj4 = this.a;
        switch (i) {
            case 0:
                ((DefaultScheduler) obj4).lambda$schedule$1((TransportContext) obj3, (TransportScheduleCallback) obj2, (EventInternal) obj);
                return;
            case 1:
                ((TrackerFallback) obj4).lambda$log$0((JuspayServices) obj3, (JSONObject) obj2, (LogType) obj);
                return;
            default:
                ((HyperServices) obj4).lambda$process$5((FragmentActivity) obj3, (ViewGroup) obj2, (JSONObject) obj);
                return;
        }
    }
}
