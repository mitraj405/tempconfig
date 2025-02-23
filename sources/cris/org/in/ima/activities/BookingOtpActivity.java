package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

public class BookingOtpActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4150a;

    /* renamed from: a  reason: collision with other field name */
    public final c f4151a = new c();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4152a = false;
    public boolean b = false;
    @BindView(2131362766)
    TextView header_msg;
    @BindView(2131363404)
    EditText otpInput;

    public class b extends Subscriber<E4> {
        public b() {
        }

        public final void onCompleted() {
            int i = BookingOtpActivity.c;
        }

        public final void onError(Throwable th) {
            int i = BookingOtpActivity.c;
            th.getClass();
            th.getMessage();
            BookingOtpActivity.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            BookingOtpActivity bookingOtpActivity = BookingOtpActivity.this;
            if (e4 != null) {
                ObjectMapper h = C0657Qt.h();
                try {
                    if (e4.getError() == null) {
                        C1450w1.f7025d = System.currentTimeMillis();
                        h.writeValueAsString(e4);
                        int i = BookingOtpActivity.c;
                        if (e4.getStatus() != null) {
                            C0535I5.m(BookingOtpActivity.this, false, e4.getStatus(), bookingOtpActivity.getString(R.string.OK), bookingOtpActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        }
                        bookingOtpActivity.otpInput.setText("");
                        bookingOtpActivity.a.dismiss();
                        return;
                    }
                    bookingOtpActivity.a.dismiss();
                    C0535I5.m(bookingOtpActivity.getApplicationContext(), false, e4.getError(), bookingOtpActivity.getString(R.string.error), bookingOtpActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    bookingOtpActivity.a.dismiss();
                    int i2 = BookingOtpActivity.c;
                    e.getMessage();
                }
            } else {
                bookingOtpActivity.a.dismiss();
                C0535I5.m(bookingOtpActivity.getApplicationContext(), false, bookingOtpActivity.getResources().getString(R.string.unable_process_message), bookingOtpActivity.getString(R.string.error), bookingOtpActivity.getString(R.string.OK), bookingOtpActivity.f4151a).show();
            }
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            BookingOtpActivity.this.resendOtp();
        }
    }

    static {
        C1354qp.R(BookingOtpActivity.class);
    }

    @OnClick({2131364810})
    public void VerifyOtp() {
        int i;
        if (xx.T(this.otpInput, "") || this.otpInput.getText().toString() == null) {
            C0535I5.t0(getBaseContext(), getString(R.string.please_enter_otp_value));
        } else if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getApplicationContext())) {
            new Handler().postDelayed(new C1146h3(), 5000);
        } else {
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                this.a = ProgressDialog.show(this, getString(R.string.Getting_User_Profile), getString(R.string.please_wait_text));
                if (C0535I5.f3625a) {
                    i = 2;
                } else {
                    i = 1;
                }
                ((Om) C0657Qt.c(b1Var.f3912a)).m(C1058d.z(C0657Qt.f(), "validateUser"), String.valueOf(i), this.otpInput.getText().toString()).c(C1181iv.a()).a(E0.a()).b(new C1169i3(this));
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_booking_otp);
        ButterKnife.bind((Activity) this);
        this.f4150a = getApplicationContext();
        Bundle extras = getIntent().getExtras();
        this.f4152a = extras.getBoolean("fromLoginActivity");
        this.b = extras.getBoolean("fromPinValidationActivity");
        this.header_msg.setText(extras.getString("msg"));
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    @OnClick({2131363678})
    public void resendOtp() {
        if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getApplicationContext())) {
            new Handler().postDelayed(new a(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            this.a = ProgressDialog.show(this, getString(R.string.Resending_OTP), getString(R.string.please_wait_text), false, false);
            String f = C0657Qt.f();
            String format = String.format("/%s", new Object[]{"LOGIN"});
            ((Om) C0657Qt.c(b1Var.f3912a)).T(f + "resendOTP" + format).c(C1181iv.a()).a(E0.a()).b(new b());
            return;
        }
        C0535I5.m(this, false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public class a implements Runnable {
        public final void run() {
        }
    }
}
