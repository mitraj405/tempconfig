package defpackage;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;

/* renamed from: ot  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class ot implements BiConsumer {
    public final /* synthetic */ Personalization a;

    public /* synthetic */ ot(Personalization personalization) {
        this.a = personalization;
    }

    public final void accept(Object obj, Object obj2) {
        this.a.logArmActive((String) obj, (ConfigContainer) obj2);
    }
}
