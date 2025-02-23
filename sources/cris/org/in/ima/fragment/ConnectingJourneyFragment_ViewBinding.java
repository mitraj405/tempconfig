package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class ConnectingJourneyFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ConnectingJourneyFragment f4528a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ConnectingJourneyFragment a;

        public a(ConnectingJourneyFragment connectingJourneyFragment) {
            this.a = connectingJourneyFragment;
        }

        public final void doClick(View view) {
            this.a.onOtpResendClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ConnectingJourneyFragment a;

        public b(ConnectingJourneyFragment connectingJourneyFragment) {
            this.a = connectingJourneyFragment;
        }

        public final void doClick(View view) {
            this.a.onSearchClick();
        }
    }

    public ConnectingJourneyFragment_ViewBinding(ConnectingJourneyFragment connectingJourneyFragment, View view) {
        this.f4528a = connectingJourneyFragment;
        connectingJourneyFragment.pnr_input_bottom_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.pnr_input_bottom_rl, "field 'pnr_input_bottom_rl'", RelativeLayout.class);
        Class cls = LinearLayout.class;
        connectingJourneyFragment.ll_aadhaar_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_aadhaar_layout, "field 'll_aadhaar_layout'", cls);
        Class cls2 = EditText.class;
        connectingJourneyFragment.tv_pnr = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_pnr, "field 'tv_pnr'", cls2);
        connectingJourneyFragment.ll_otp = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_otp, "field 'll_otp'", cls);
        connectingJourneyFragment.tv_otp = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_otp, "field 'tv_otp'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.resend_opt, "field 'resend_opt' and method 'onOtpResendClick'");
        Class cls3 = TextView.class;
        connectingJourneyFragment.resend_opt = (TextView) Utils.castView(findRequiredView, R.id.resend_opt, "field 'resend_opt'", cls3);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(connectingJourneyFragment));
        connectingJourneyFragment.ll_status = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_status, "field 'll_status'", cls);
        connectingJourneyFragment.status = (TextView) Utils.findRequiredViewAsType(view, R.id.status, "field 'status'", cls3);
        connectingJourneyFragment.ll_submit = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_submit, "field 'll_submit'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_submit_btn, "field 'tv_submit_btn' and method 'onSearchClick'");
        connectingJourneyFragment.tv_submit_btn = (TextView) Utils.castView(findRequiredView2, R.id.tv_submit_btn, "field 'tv_submit_btn'", cls3);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(connectingJourneyFragment));
    }

    public final void unbind() {
        ConnectingJourneyFragment connectingJourneyFragment = this.f4528a;
        if (connectingJourneyFragment != null) {
            this.f4528a = null;
            connectingJourneyFragment.pnr_input_bottom_rl = null;
            connectingJourneyFragment.ll_aadhaar_layout = null;
            connectingJourneyFragment.tv_pnr = null;
            connectingJourneyFragment.ll_otp = null;
            connectingJourneyFragment.tv_otp = null;
            connectingJourneyFragment.resend_opt = null;
            connectingJourneyFragment.ll_status = null;
            connectingJourneyFragment.status = null;
            connectingJourneyFragment.ll_submit = null;
            connectingJourneyFragment.tv_submit_btn = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
