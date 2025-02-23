package cris.org.in.ima.activities;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class BookingOtpActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public BookingOtpActivity f4153a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ BookingOtpActivity a;

        public a(BookingOtpActivity bookingOtpActivity) {
            this.a = bookingOtpActivity;
        }

        public final void doClick(View view) {
            this.a.resendOtp();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ BookingOtpActivity a;

        public b(BookingOtpActivity bookingOtpActivity) {
            this.a = bookingOtpActivity;
        }

        public final void doClick(View view) {
            this.a.VerifyOtp();
        }
    }

    public BookingOtpActivity_ViewBinding(BookingOtpActivity bookingOtpActivity, View view) {
        this.f4153a = bookingOtpActivity;
        bookingOtpActivity.otpInput = (EditText) Utils.findRequiredViewAsType(view, R.id.otp_input, "field 'otpInput'", EditText.class);
        bookingOtpActivity.header_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.header_msg, "field 'header_msg'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.resend_opt, "method 'resendOtp'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(bookingOtpActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.verify_otp, "method 'VerifyOtp'");
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(bookingOtpActivity));
    }

    public final void unbind() {
        BookingOtpActivity bookingOtpActivity = this.f4153a;
        if (bookingOtpActivity != null) {
            this.f4153a = null;
            bookingOtpActivity.otpInput = null;
            bookingOtpActivity.header_msg = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
