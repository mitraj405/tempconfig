package defpackage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.StatusDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import okhttp3.ResponseBody;
import rx.Subscriber;

/* renamed from: Xa  reason: default package and case insensitive filesystem */
/* compiled from: ErsTicket */
public final class C0746Xa {
    public static File a;

    /* renamed from: a  reason: collision with other field name */
    public static String f3829a;

    /* renamed from: Xa$a */
    /* compiled from: ErsTicket */
    public class a extends Subscriber<StatusDTO> {
        public final /* synthetic */ ProgressDialog a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Context f3830a;

        public a(ProgressDialog progressDialog, Context context) {
            this.a = progressDialog;
            this.f3830a = context;
        }

        public final void onCompleted() {
            this.a.dismiss();
            File file = C0746Xa.a;
        }

        public final void onError(Throwable th) {
            this.a.dismiss();
            File file = C0746Xa.a;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
            Context context = this.f3830a;
            ProgressDialog progressDialog = this.a;
            if (statusDTO != null) {
                C0657Qt.h();
                try {
                    progressDialog.dismiss();
                    if (statusDTO.getError() != null) {
                        C0535I5.o(context, statusDTO.getError(), context.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    } else {
                        C0535I5.o(context, statusDTO.getStatus(), context.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                } catch (Exception e) {
                    progressDialog.dismiss();
                    File file = C0746Xa.a;
                    e.getMessage();
                }
            } else {
                progressDialog.dismiss();
                C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), context.getResources().getString(R.string.error), context.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    /* renamed from: Xa$b */
    /* compiled from: ErsTicket */
    public class b extends Subscriber<ResponseBody> {
        public final /* synthetic */ ProgressDialog a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Context f3831a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ BookingResponseDTO f3832a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ boolean f3833a;

        public b(ProgressDialog progressDialog, Context context, BookingResponseDTO bookingResponseDTO, boolean z) {
            this.a = progressDialog;
            this.f3831a = context;
            this.f3832a = bookingResponseDTO;
            this.f3833a = z;
        }

        public final void onCompleted() {
            this.a.dismiss();
            File file = C0746Xa.a;
        }

        public final void onError(Throwable th) {
            this.a.dismiss();
            File file = C0746Xa.a;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            BufferedReader bufferedReader;
            ResponseBody responseBody = (ResponseBody) obj;
            Context context = this.f3831a;
            if (responseBody != null) {
                try {
                    if (responseBody.contentType() != null && responseBody.contentType().subtype() != null && responseBody.contentType().subtype().equalsIgnoreCase("json")) {
                        InputStream byteStream = responseBody.byteStream();
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(byteStream));
                            C0535I5.m(context, false, (String) ((Stream) bufferedReader.lines().parallel()).collect(Collectors.joining("\n")), context.getResources().getString(R.string.error), context.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                            bufferedReader.close();
                            if (byteStream != null) {
                                byteStream.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            if (byteStream != null) {
                                byteStream.close();
                            }
                            throw th;
                        }
                    } else if (responseBody.contentType() == null || responseBody.contentType().subtype() == null || !responseBody.contentType().subtype().equalsIgnoreCase("pdf")) {
                        C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), context.getResources().getString(R.string.error), context.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        return;
                    } else {
                        C0746Xa.c(context, responseBody, this.f3832a);
                        if (this.f3833a) {
                            C0746Xa.e(context, C0746Xa.a, C0746Xa.f3829a);
                            return;
                        }
                        return;
                    }
                } catch (Exception e) {
                    File file = C0746Xa.a;
                    e.getMessage();
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                this.a.dismiss();
                C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), context.getResources().getString(R.string.error), context.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
            throw th;
        }
    }

    static {
        C1354qp.R(C0535I5.class);
    }

    public static void a(BookingResponseDTO bookingResponseDTO, Context context, boolean z) {
        if (C0535I5.O((ConnectivityManager) context.getSystemService("connectivity"), context)) {
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.requestWindowFeature(1);
                progressDialog.setMessage(context.getResources().getString(R.string.please_wait_text));
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                ((Om) C0657Qt.c(b1Var.f3912a)).l(xx.D(C0657Qt.f(), "downloadErs", String.format("/%s", new Object[]{bookingResponseDTO.getPnrNumber()})), 6, "en").c(C1181iv.a()).a(E0.a()).b(new b(progressDialog, context, bookingResponseDTO, z));
                return;
            }
            C0535I5.m(context, false, context.getResources().getString(R.string.data_connection_error_message), context.getResources().getString(R.string.error), context.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public static void b(Context context, NestedScrollView nestedScrollView, boolean z, TextView textView) {
        try {
            nestedScrollView.setDrawingCacheEnabled(true);
            nestedScrollView.buildDrawingCache();
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/IRCTC ERS");
            a = file;
            if (!file.exists()) {
                a.mkdirs();
            }
            String str = textView.getText().toString() + ".png";
            f3829a = str;
            f(nestedScrollView, a, str, Boolean.valueOf(z), context);
        } catch (OutOfMemoryError e) {
            e.getMessage();
            C0535I5.t0(context, context.getResources().getString(R.string.Unable_save_ERS_Please_try_again));
        }
    }

    public static void c(Context context, ResponseBody responseBody, BookingResponseDTO bookingResponseDTO) {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/IRCTC ERS");
            a = file;
            if (!file.exists()) {
                a.mkdirs();
            }
            String str = bookingResponseDTO.getPnrNumber() + ".pdf";
            f3829a = str;
            g(a, str, context, responseBody);
        } catch (OutOfMemoryError e) {
            e.getMessage();
            C0535I5.t0(context, context.getResources().getString(R.string.Unable_save_ERS_Please_try_again));
        }
    }

    public static void d(BookingResponseDTO bookingResponseDTO, Context context) {
        if (C0535I5.O((ConnectivityManager) context.getSystemService("connectivity"), context)) {
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.requestWindowFeature(1);
                progressDialog.setMessage(context.getResources().getString(R.string.please_wait_text));
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                String f = C0657Qt.f();
                String format = String.format("/%s/%s", new Object[]{bookingResponseDTO.getPnrNumber(), "en"});
                ((Om) C0657Qt.c(b1Var.f3912a)).K(f + "sendBookedEmailPdf" + format).c(C1181iv.a()).a(E0.a()).b(new a(progressDialog, context));
                return;
            }
            C0535I5.m(context, false, context.getResources().getString(R.string.data_connection_error_message), context.getResources().getString(R.string.error), context.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public static void e(Context context, File file, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(1);
            intent.setType("application/pdf");
            intent.putExtra("android.intent.extra.STREAM", FileProvider.c(context, 0, "cris.org.in.prs.ima.provider").b(new File(file, str)));
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.share_tkt)));
            return;
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("application/pdf");
        intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(file, str)));
        context.startActivity(Intent.createChooser(intent2, context.getString(R.string.share_tkt)));
    }

    public static void f(NestedScrollView nestedScrollView, File file, String str, Boolean bool, Context context) {
        FileOutputStream fileOutputStream;
        AlertDialog alertDialog = C0535I5.f3619a;
        Bitmap createBitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), nestedScrollView.getChildAt(0).getHeight(), Bitmap.Config.ARGB_8888);
        nestedScrollView.draw(new Canvas(createBitmap));
        try {
            fileOutputStream = new FileOutputStream(new File(file, str));
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            createBitmap.recycle();
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(str);
            intent.setData(Uri.fromFile(new File(sb.toString())));
            context.sendBroadcast(intent);
            if (!bool.booleanValue()) {
                C0535I5.o(context, context.getString(R.string.ticket_has_been_saved) + file + str2 + str, context.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            }
            fileOutputStream.close();
            return;
        } catch (Exception e) {
            e.getMessage();
            Toast makeText = Toast.makeText(context, e.getMessage(), 1);
            makeText.setGravity(1, 0, 0);
            makeText.show();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static void g(File file, String str, Context context, ResponseBody responseBody) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(file, str));
            fileOutputStream.write(responseBody.bytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            StringBuilder sb = new StringBuilder();
            sb.append(file);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(str);
            intent.setData(Uri.fromFile(new File(sb.toString())));
            context.sendBroadcast(intent);
            C0535I5.o(context, context.getString(R.string.ticket_has_been_saved) + file + str2 + str, context.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            fileOutputStream.close();
            return;
        } catch (Exception e) {
            e.getMessage();
            Toast.makeText(context, context.getResources().getString(R.string.unable_process), 1).show();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
