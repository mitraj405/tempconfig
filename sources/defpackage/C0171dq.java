package defpackage;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import kotlin.jvm.functions.Function0;

/* renamed from: dq  reason: default package and case insensitive filesystem */
/* compiled from: PreferenceDataStoreFactory.kt */
public final class C0171dq extends C0595Mh implements Function0<File> {
    public final /* synthetic */ Function0<File> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0171dq(eq eqVar) {
        super(0);
        this.a = eqVar;
    }

    public final Object invoke() {
        File invoke = this.a.invoke();
        C1177ig.f(invoke, "<this>");
        String name = invoke.getName();
        C1177ig.e(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (C1177ig.a(C1337py.b1(name, ""), "preferences_pb")) {
            return invoke;
        }
        throw new IllegalStateException(("File extension for file: " + invoke + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
