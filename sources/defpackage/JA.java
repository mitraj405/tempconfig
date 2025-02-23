package defpackage;

import android.content.Context;
import androidx.transition.Transition;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* renamed from: JA  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class JA implements Transition.TransitionNotification, ShapeAppearanceModel.CornerSizeUnaryOperator, LibraryVersionComponent.VersionExtractor, ComponentRegistrarProcessor, Continuation, Transformer, Authenticator {
    public final CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    public final Request authenticate(Route route, Response response) {
        return Authenticator.lambda$static$0(route, response);
    }

    public final void b(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionPause(transition);
    }

    public final String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$3((Context) obj);
    }

    public final List processRegistrar(ComponentRegistrar componentRegistrar) {
        return componentRegistrar.getComponents();
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$bindToMessagingService$3(task);
    }

    public final Object apply(Object obj) {
        return ((PerfMetric) obj).toByteArray();
    }
}
