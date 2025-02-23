package defpackage;

import android.content.Context;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.prs.ima.R;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

/* renamed from: Mt  reason: default package */
/* compiled from: RestErrorHandlerVikalp */
public final class Mt {
    static {
        C1354qp.R(Mt.class);
    }

    public static void a(Throwable th) {
        Response<?> response;
        int i;
        Context context = IrctcImaApplication.a;
        if (th instanceof HttpException) {
            response = ((HttpException) th).response();
        } else {
            response = null;
        }
        if (response != null) {
            i = response.code();
        } else {
            i = -1;
        }
        if (i != 404 && i != 406 && i != 409 && i != 500) {
            return;
        }
        if (i == 404) {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.service_not_available));
        } else if (i == 406) {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.either_your_session_expired_or_time_on_device));
        } else if (i == 409) {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.login_detected_on_multiple_devices));
        } else if (i != 500) {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.unable_process_message));
        } else {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.your_session_is_expired));
        }
    }
}
