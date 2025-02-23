package cris.org.in.ima.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class VikalpSystemFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public VikalpSystemFragment f5203a;

    /* renamed from: a  reason: collision with other field name */
    public a f5204a;

    /* renamed from: a  reason: collision with other field name */
    public b f5205a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpSystemFragment a;

        public c(VikalpSystemFragment vikalpSystemFragment) {
            this.a = vikalpSystemFragment;
        }

        public final void doClick(View view) {
            this.a.onCaptchaRefreshClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpSystemFragment a;

        public d(VikalpSystemFragment vikalpSystemFragment) {
            this.a = vikalpSystemFragment;
        }

        public final void doClick(View view) {
            this.a.onResendOtpClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpSystemFragment a;

        public e(VikalpSystemFragment vikalpSystemFragment) {
            this.a = vikalpSystemFragment;
        }

        public final void doClick(View view) {
            this.a.onNext(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ VikalpSystemFragment a;

        public f(VikalpSystemFragment vikalpSystemFragment) {
            this.a = vikalpSystemFragment;
        }

        public final void doClick(View view) {
            this.a.otpLayoutClick(view);
        }
    }

    public VikalpSystemFragment_ViewBinding(VikalpSystemFragment vikalpSystemFragment, View view) {
        this.f5203a = vikalpSystemFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_pnr, "field 'pnrNumber' and method 'onPnrTextChanged'");
        Class cls = EditText.class;
        vikalpSystemFragment.pnrNumber = (EditText) Utils.castView(findRequiredView, R.id.et_pnr, "field 'pnrNumber'", cls);
        this.a = findRequiredView;
        a aVar = new a(vikalpSystemFragment);
        this.f5204a = aVar;
        ((TextView) findRequiredView).addTextChangedListener(aVar);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_train_number, "field 'trainNumber' and method 'onTrainNumberTextChanged'");
        vikalpSystemFragment.trainNumber = (EditText) Utils.castView(findRequiredView2, R.id.et_train_number, "field 'trainNumber'", cls);
        this.b = findRequiredView2;
        b bVar = new b(vikalpSystemFragment);
        this.f5205a = bVar;
        ((TextView) findRequiredView2).addTextChangedListener(bVar);
        vikalpSystemFragment.captchaInput = (EditText) Utils.findRequiredViewAsType(view, R.id.captcha_input, "field 'captchaInput'", cls);
        Class cls2 = ImageView.class;
        vikalpSystemFragment.captcha = (ImageView) Utils.findRequiredViewAsType(view, R.id.captcha, "field 'captcha'", cls2);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.captchaRefresh, "field 'captchaRefresh' and method 'onCaptchaRefreshClick'");
        vikalpSystemFragment.captchaRefresh = (ImageView) Utils.castView(findRequiredView3, R.id.captchaRefresh, "field 'captchaRefresh'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(vikalpSystemFragment));
        Class cls3 = TextView.class;
        vikalpSystemFragment.loadingCaptcha = (TextView) Utils.findRequiredViewAsType(view, R.id.loading_captcha, "field 'loadingCaptcha'", cls3);
        vikalpSystemFragment.termsAndConditions = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_terms_conditions, "field 'termsAndConditions'", cls3);
        vikalpSystemFragment.vikalpOtp = (EditText) Utils.findRequiredViewAsType(view, R.id.vikalp_otp, "field 'vikalpOtp'", cls);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_resend_otp, "field 'resendOtp' and method 'onResendOtpClick'");
        vikalpSystemFragment.resendOtp = (TextView) Utils.castView(findRequiredView4, R.id.tv_resend_otp, "field 'resendOtp'", cls3);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(vikalpSystemFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.verify_otp, "field 'verifyOtp' and method 'onNext'");
        vikalpSystemFragment.verifyOtp = (TextView) Utils.castView(findRequiredView5, R.id.verify_otp, "field 'verifyOtp'", cls3);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(vikalpSystemFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.otp_ll, "field 'otpLayout' and method 'otpLayoutClick'");
        vikalpSystemFragment.otpLayout = (RelativeLayout) Utils.castView(findRequiredView6, R.id.otp_ll, "field 'otpLayout'", RelativeLayout.class);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(vikalpSystemFragment));
        Class cls4 = AdManagerAdView.class;
        vikalpSystemFragment.optvikalp_otp = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.opt_vikalp_otp, "field 'optvikalp_otp'", cls4);
        vikalpSystemFragment.optvikalpbottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.opt_vikalp_bottom, "field 'optvikalpbottom'", cls4);
    }

    public final void unbind() {
        VikalpSystemFragment vikalpSystemFragment = this.f5203a;
        if (vikalpSystemFragment != null) {
            this.f5203a = null;
            vikalpSystemFragment.pnrNumber = null;
            vikalpSystemFragment.trainNumber = null;
            vikalpSystemFragment.captchaInput = null;
            vikalpSystemFragment.captcha = null;
            vikalpSystemFragment.captchaRefresh = null;
            vikalpSystemFragment.loadingCaptcha = null;
            vikalpSystemFragment.termsAndConditions = null;
            vikalpSystemFragment.vikalpOtp = null;
            vikalpSystemFragment.resendOtp = null;
            vikalpSystemFragment.verifyOtp = null;
            vikalpSystemFragment.otpLayout = null;
            vikalpSystemFragment.optvikalp_otp = null;
            vikalpSystemFragment.optvikalpbottom = null;
            ((TextView) this.a).removeTextChangedListener(this.f5204a);
            this.f5204a = null;
            this.a = null;
            ((TextView) this.b).removeTextChangedListener(this.f5205a);
            this.f5205a = null;
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class a implements TextWatcher {
        public final /* synthetic */ VikalpSystemFragment a;

        public a(VikalpSystemFragment vikalpSystemFragment) {
            this.a = vikalpSystemFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onPnrTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements TextWatcher {
        public final /* synthetic */ VikalpSystemFragment a;

        public b(VikalpSystemFragment vikalpSystemFragment) {
            this.a = vikalpSystemFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onTrainNumberTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
