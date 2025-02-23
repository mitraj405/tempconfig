package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.LoginActivity;
import cris.org.in.ima.activities.PinValidationActivity;
import cris.org.in.prs.ima.R;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

/* renamed from: Lt  reason: default package */
/* compiled from: RestErrorHandler */
public final class Lt {
    static {
        C1354qp.R(Lt.class);
    }

    public static void a(boolean z, Throwable th) {
        Response<?> response;
        int i;
        boolean c = c(th);
        Context context = IrctcImaApplication.a;
        Bw e = Bw.e(context);
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
        if (i == 204 || i == 502 || i == 504) {
            z = false;
        } else {
            if (i == 401) {
                z = true;
            }
            C0657Qt.a();
            C1228kw a = C1228kw.a();
            if (a != null) {
                a.f5570a = null;
                a.b = null;
                a.f5571a = null;
            }
        }
        if (i == 404 || i == 406 || i == 409 || i == 500 || i == 503 || i == 401) {
            if (!c) {
                d(context, i);
            }
            if (C0535I5.f3625a) {
                new C0816cB(new Kt(), 4200).a();
            }
            if (z) {
                HomeActivity.c = 0;
                if (TextUtils.isEmpty(e.f3534a.getString("alfiler", ""))) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.setFlags(32768);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(context, PinValidationActivity.class);
                intent2.setFlags(32768);
                intent2.setFlags(268435456);
                context.startActivity(intent2);
            }
        }
    }

    public static void b(Throwable th, AppCompatActivity appCompatActivity) {
        Response<?> response;
        int i;
        boolean c = c(th);
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
        if (!(i == 204 || i == 502 || i == 504)) {
            C0657Qt.a();
            C1228kw a = C1228kw.a();
            if (a != null) {
                a.f5570a = null;
                a.b = null;
                a.f5571a = null;
            }
        }
        if (i == 404 || i == 406 || i == 409 || i == 500 || i == 503 || i == 401) {
            if (!c) {
                d(context, i);
            }
            appCompatActivity.finish();
        }
    }

    public static boolean c(Throwable th) {
        Response<?> response;
        C1223kn knVar;
        boolean z = th instanceof HttpException;
        if (z) {
            if (z) {
                response = ((HttpException) th).response();
            } else {
                response = null;
            }
            if (response != null) {
                try {
                    int code = response.code();
                    if (!(code == 500 || code == 503 || code == 404)) {
                        String string = response.errorBody().string();
                        if (!string.contains("claim time") && (knVar = (C1223kn) C0657Qt.h().readValue(string, C1223kn.class)) != null) {
                            C0535I5.t0(IrctcImaApplication.a, knVar.getErrorMessage());
                            return true;
                        }
                    }
                } catch (Exception unused) {
                    Context context = IrctcImaApplication.a;
                    C0535I5.t0(context, context.getString(R.string.unable_process));
                }
            }
        } else if (C0535I5.O((ConnectivityManager) IrctcImaApplication.a.getSystemService("connectivity"), IrctcImaApplication.a)) {
            if ((th instanceof ConnectException) || (th instanceof NoRouteToHostException)) {
                th.getMessage();
                Context context2 = IrctcImaApplication.a;
                C0535I5.t0(context2, context2.getString(R.string.data_connection_error_message));
                return true;
            }
            if (th instanceof SocketException) {
                th.getMessage();
                Context context3 = IrctcImaApplication.a;
                C0535I5.t0(context3, context3.getString(R.string.data_connection_error_message));
            } else if (th instanceof UnknownHostException) {
                th.getMessage();
                Context context4 = IrctcImaApplication.a;
                C0535I5.t0(context4, context4.getString(R.string.unable_to_process_pls_try_after));
            } else if (th instanceof SocketTimeoutException) {
                th.getMessage();
                Context context5 = IrctcImaApplication.a;
                C0535I5.t0(context5, context5.getString(R.string.unable_to_process_timeout));
            } else if (th instanceof IOException) {
                th.getMessage();
                Context context6 = IrctcImaApplication.a;
                C0535I5.t0(context6, context6.getString(R.string.Unable_to_retrieve_data_Please_try_again));
            } else if (th instanceof NullPointerException) {
                Context context7 = IrctcImaApplication.a;
                C0535I5.t0(context7, context7.getString(R.string.unable_to_process_request));
            }
            return true;
        }
        return false;
    }

    public static void d(Context context, int i) {
        if (i == 401) {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.unauthorized));
        } else if (i == 406) {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.either_your_session_expired_or_time_on_device));
        } else if (i == 409) {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.login_detected_on_multiple_devices));
        } else if (i != 500) {
            if (i == 503) {
                C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.service_tempararinly_unavailable));
            }
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.unable_process_message));
        } else {
            C0535I5.t0(IrctcImaApplication.a, context.getString(R.string.your_session_is_expired));
        }
    }
}
