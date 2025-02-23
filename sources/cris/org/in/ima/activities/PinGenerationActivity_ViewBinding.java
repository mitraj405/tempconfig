package cris.org.in.ima.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class PinGenerationActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public PinGenerationActivity f4275a;

    /* renamed from: a  reason: collision with other field name */
    public f f4276a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public a(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onAirAppClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public b(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onBUSAppClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public c(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onhotelAppClick(view);
        }
    }

    public class d implements View.OnFocusChangeListener {
        public final /* synthetic */ PinGenerationActivity a;

        public d(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.validatePin(view);
        }
    }

    public class e implements View.OnFocusChangeListener {
        public final /* synthetic */ PinGenerationActivity a;

        public e(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.validateRePin(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public g(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.authFingerSwitch();
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public h(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onUserGuideClick();
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public i(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onSubmitClick(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public j(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onCateringAppClick(view);
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public k(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onTourismAppClick(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ PinGenerationActivity a;

        public l(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void doClick(View view) {
            this.a.onUtsAppClick(view);
        }
    }

    public PinGenerationActivity_ViewBinding(PinGenerationActivity pinGenerationActivity, View view) {
        this.f4275a = pinGenerationActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.et_pin, "field 'editTextPin' and method 'validatePin'");
        Class cls = EditText.class;
        pinGenerationActivity.editTextPin = (EditText) Utils.castView(findRequiredView, R.id.et_pin, "field 'editTextPin'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnFocusChangeListener(new d(pinGenerationActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_re_enter_pin, "field 'editTextReEnterPin', method 'validateRePin', and method 'onPinCodeTextChanged'");
        pinGenerationActivity.editTextReEnterPin = (EditText) Utils.castView(findRequiredView2, R.id.et_re_enter_pin, "field 'editTextReEnterPin'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnFocusChangeListener(new e(pinGenerationActivity));
        f fVar = new f(pinGenerationActivity);
        this.f4276a = fVar;
        ((TextView) findRequiredView2).addTextChangedListener(fVar);
        pinGenerationActivity.pingeneration_bottom_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.pingeneration_bottom_ads, "field 'pingeneration_bottom_ads'", AdManagerAdView.class);
        pinGenerationActivity.fingerprintAuthenticationLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_fingerprint_authentication, "field 'fingerprintAuthenticationLayout'", RelativeLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.fingerAuthSwitch, "field 'fingerAuthSwitch' and method 'authFingerSwitch'");
        pinGenerationActivity.fingerAuthSwitch = (Switch) Utils.castView(findRequiredView3, R.id.fingerAuthSwitch, "field 'fingerAuthSwitch'", Switch.class);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new g(pinGenerationActivity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_user_guide, "method 'onUserGuideClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new h(pinGenerationActivity));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.tv_submit, "method 'onSubmitClick'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new i(pinGenerationActivity));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.rl_book_meal, "method 'onCateringAppClick'");
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new j(pinGenerationActivity));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.rl_irctc_tourism, "method 'onTourismAppClick'");
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new k(pinGenerationActivity));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.rl_uts_ticket, "method 'onUtsAppClick'");
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new l(pinGenerationActivity));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.rl_air_ticket, "method 'onAirAppClick'");
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new a(pinGenerationActivity));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.ll_bus, "method 'onBUSAppClick'");
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new b(pinGenerationActivity));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.rl_hotel, "method 'onhotelAppClick'");
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new c(pinGenerationActivity));
    }

    public final void unbind() {
        PinGenerationActivity pinGenerationActivity = this.f4275a;
        if (pinGenerationActivity != null) {
            this.f4275a = null;
            pinGenerationActivity.editTextPin = null;
            pinGenerationActivity.editTextReEnterPin = null;
            pinGenerationActivity.pingeneration_bottom_ads = null;
            pinGenerationActivity.fingerprintAuthenticationLayout = null;
            pinGenerationActivity.fingerAuthSwitch = null;
            this.a.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.a = null;
            this.b.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.b).removeTextChangedListener(this.f4276a);
            this.f4276a = null;
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class f implements TextWatcher {
        public final /* synthetic */ PinGenerationActivity a;

        public f(PinGenerationActivity pinGenerationActivity) {
            this.a = pinGenerationActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onPinCodeTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
