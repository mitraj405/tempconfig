package defpackage;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.profileinstaller.c;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.transport.TransportManager;
import com.momagic.B;
import com.momagic.C0835h;
import com.momagic.DATBMessagingService;
import com.momagic.H;
import com.momagic.v;
import com.momagic.x;
import cris.org.in.ima.activities.LoginActivity;
import in.juspay.services.HyperServices;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: gA  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class gA implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ gA(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        String l;
        String str;
        int i = this.c;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((Toolbar) obj).collapseActionView();
                return;
            case 1:
                ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) obj;
                int i2 = ContentLoadingProgressBar.c;
                contentLoadingProgressBar.getClass();
                System.currentTimeMillis();
                contentLoadingProgressBar.setVisibility(0);
                return;
            case 2:
                c.b((Context) obj, new F1(4), c.a, false);
                return;
            case 3:
                ((WorkInitializer) obj).lambda$ensureContextsScheduled$1();
                return;
            case 4:
                ((View) obj).requestLayout();
                return;
            case 5:
                ((CarouselLayoutManager) obj).refreshKeylineState();
                return;
            case 6:
                ((MaterialBackOrchestrator) obj).startListeningForBackCallbacksWithPriorityOverlay();
                return;
            case 7:
                ((MaterialTimePicker) obj).lambda$onViewCreated$0();
                return;
            case 8:
                ((FirebaseInstallations) obj).lambda$getId$1();
                return;
            case 9:
                ((AppStartTrace) obj).logAppStartTrace();
                return;
            case 10:
                ((TransportManager) obj).lambda$onUpdateAppState$1();
                return;
            case 11:
                DATBMessagingService dATBMessagingService = (DATBMessagingService) obj;
                C1203jp jpVar = dATBMessagingService.f4011a;
                if (!(jpVar == null || (l = H.l(jpVar.l)) == null || l.isEmpty())) {
                    String valueOf = String.valueOf(l.charAt(l.length() - 1));
                    String valueOf2 = String.valueOf(l.charAt(l.length() - 11));
                    if (valueOf.equalsIgnoreCase(C0515Ga.AVLBLTY_ONLY)) {
                        if (valueOf2.equalsIgnoreCase(C0515Ga.AVLBLTY_ONLY)) {
                            Context context = C0835h.f4046a;
                            if (context != null) {
                                try {
                                    C1139gq c2 = C1139gq.c(context);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("pid", c2.b());
                                    hashMap.put("cid", jpVar.f5529c);
                                    hashMap.put("bKey", "" + H.g(C0835h.f4046a));
                                    hashMap.put("rid", "" + jpVar.f5530d);
                                    hashMap.put("ver", "2.4.0");
                                    hashMap.put("op", "view");
                                    hashMap.put("push_type", "fcm");
                                    B.c("https://irctc.truenotify.in/momagicflow/appimpr", hashMap, (JSONObject) null, new v());
                                } catch (Exception e) {
                                    H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "cImpression");
                                }
                            }
                        } else if (C0835h.f4046a != null) {
                            int i3 = H.i(jpVar.l);
                            if (i3 > 0) {
                                str = lf.i("https://impr", i3, ".izooto.com/imp", i3);
                            } else {
                                str = "https://impr.izooto.com/imp";
                            }
                            x.k(str, jpVar.f5529c, jpVar.f5530d);
                        }
                    }
                }
                C0835h.j(C0835h.f4046a, dATBMessagingService.f4011a);
                return;
            case 12:
                LoginActivity.m((LoginActivity) obj);
                return;
            default:
                ((HyperServices) obj).lambda$runProcessWaitQueue$4();
                return;
        }
    }
}
