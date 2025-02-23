package defpackage;

import android.content.Context;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import kotlin.jvm.functions.Function0;

/* renamed from: eq  reason: default package */
/* compiled from: PreferenceDataStoreDelegate.kt */
public final class eq extends C0595Mh implements Function0<File> {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ fq f2914a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public eq(Context context, fq fqVar) {
        super(0);
        this.a = context;
        this.f2914a = fqVar;
    }

    public final Object invoke() {
        Context context = this.a;
        C1177ig.e(context, "applicationContext");
        String str = this.f2914a.f2945a;
        C1177ig.f(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        String j = C1177ig.j(".preferences_pb", str);
        C1177ig.f(j, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), C1177ig.j(j, "datastore/"));
    }
}
