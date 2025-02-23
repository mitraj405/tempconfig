package defpackage;

import android.content.Context;
import androidx.transition.Transition;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import defpackage.C0114a9;

/* renamed from: Z8  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Z8 implements C0114a9.b, Transition.TransitionNotification, LibraryVersionComponent.VersionExtractor, SuccessContinuation {
    public final /* synthetic */ int a;

    public /* synthetic */ Z8(int i) {
        this.a = i;
    }

    public final void b(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        switch (this.a) {
            case 1:
                transitionListener.onTransitionStart(transition, z);
                return;
            default:
                transitionListener.onTransitionResume(transition);
                return;
        }
    }

    public final String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$0((Context) obj);
    }

    public final Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
