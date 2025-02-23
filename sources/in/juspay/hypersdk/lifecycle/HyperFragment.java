package in.juspay.hypersdk.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Iterator;
import java.util.LinkedList;

public class HyperFragment extends Fragment {
    private final LinkedList<ActivityResultHolder> onActivityResultListeners = new LinkedList<>();
    private final LinkedList<EventListener> onAttachListeners = new LinkedList<>();
    private final LinkedList<EventListener> onDestroyListeners = new LinkedList<>();
    private final LinkedList<EventListener> onPauseListeners = new LinkedList<>();
    private final LinkedList<RequestPermissionResult> onRequestPermissionsResultListeners = new LinkedList<>();
    private final LinkedList<EventListener> onResumeListeners = new LinkedList<>();
    private final LinkedList<EventListener> onSaveInstanceListeners = new LinkedList<>();
    private final LinkedList<EventListener> onStopListeners = new LinkedList<>();

    /* renamed from: in.juspay.hypersdk.lifecycle.HyperFragment$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                in.juspay.hypersdk.lifecycle.FragmentEvent[] r0 = in.juspay.hypersdk.lifecycle.FragmentEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent = r0
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onPause     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onResume     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x0028 }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onStop     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x0033 }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onDestroy     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x003e }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.OnSavedStateInstance     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x0049 }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onAttach     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x0054 }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onActivityResult     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x0060 }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onRequestPermissionResult     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.lifecycle.HyperFragment.AnonymousClass1.<clinit>():void");
        }
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.a.a;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<ActivityResultHolder> it = this.onActivityResultListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Iterator<EventListener> it = this.onAttachListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Iterator<EventListener> it = this.onDestroyListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}");
        }
        for (FragmentEvent unRegisterForEvent : FragmentEvent.values()) {
            unRegisterForEvent(unRegisterForEvent);
        }
    }

    public void onPause() {
        super.onPause();
        Iterator<EventListener> it = this.onPauseListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Iterator<RequestPermissionResult> it = this.onRequestPermissionsResultListeners.iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        Iterator<EventListener> it = this.onResumeListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Iterator<EventListener> it = this.onSaveInstanceListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}");
        }
    }

    public void onStop() {
        super.onStop();
        Iterator<EventListener> it = this.onStopListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent("{}");
        }
    }

    public void registerForEvent(FragmentEvent fragmentEvent, EventListener eventListener) {
        LinkedList<EventListener> linkedList;
        switch (AnonymousClass1.$SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent[fragmentEvent.ordinal()]) {
            case 1:
                linkedList = this.onPauseListeners;
                break;
            case 2:
                linkedList = this.onResumeListeners;
                break;
            case 3:
                linkedList = this.onStopListeners;
                break;
            case 4:
                linkedList = this.onDestroyListeners;
                break;
            case 5:
                linkedList = this.onSaveInstanceListeners;
                break;
            case 6:
                linkedList = this.onAttachListeners;
                break;
            default:
                return;
        }
        linkedList.add(eventListener);
    }

    public void registerOnActivityResult(ActivityResultHolder activityResultHolder) {
        this.onActivityResultListeners.add(activityResultHolder);
    }

    public void registerOnRequestPermissionResult(RequestPermissionResult requestPermissionResult) {
        this.onRequestPermissionsResultListeners.add(requestPermissionResult);
    }

    public void unRegisterForEvent(FragmentEvent fragmentEvent) {
        LinkedList linkedList;
        switch (AnonymousClass1.$SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent[fragmentEvent.ordinal()]) {
            case 1:
                linkedList = this.onPauseListeners;
                break;
            case 2:
                linkedList = this.onResumeListeners;
                break;
            case 3:
                linkedList = this.onStopListeners;
                break;
            case 4:
                linkedList = this.onDestroyListeners;
                break;
            case 5:
                linkedList = this.onSaveInstanceListeners;
                break;
            case 6:
                linkedList = this.onAttachListeners;
                break;
            case 7:
                linkedList = this.onActivityResultListeners;
                break;
            case 8:
                linkedList = this.onRequestPermissionsResultListeners;
                break;
            default:
                return;
        }
        linkedList.clear();
    }
}
