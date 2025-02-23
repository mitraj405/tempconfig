package defpackage;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.ComponentMonitor;

/* renamed from: Wh  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Wh implements ComponentFactory {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f635a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f636a;

    public /* synthetic */ Wh(String str, Object obj, int i) {
        this.a = i;
        this.f636a = str;
        this.f635a = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        int i = this.a;
        String str = this.f636a;
        Object obj = this.f635a;
        switch (i) {
            case 0:
                return LibraryVersion.create(str, ((LibraryVersionComponent.VersionExtractor) obj).extract((Context) componentContainer.get(Context.class)));
            default:
                return ComponentMonitor.lambda$processRegistrar$0(str, (Component) obj, componentContainer);
        }
    }
}
