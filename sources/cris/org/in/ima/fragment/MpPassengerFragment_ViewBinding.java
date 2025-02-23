package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class MpPassengerFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public MpPassengerFragment f4822a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MpPassengerFragment a;

        public a(MpPassengerFragment mpPassengerFragment) {
            this.a = mpPassengerFragment;
        }

        public final void doClick(View view) {
            this.a.mpCheckBoxClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MpPassengerFragment a;

        public b(MpPassengerFragment mpPassengerFragment) {
            this.a = mpPassengerFragment;
        }

        public final void doClick(View view) {
            this.a.spouseLayoutClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MpPassengerFragment a;

        public c(MpPassengerFragment mpPassengerFragment) {
            this.a = mpPassengerFragment;
        }

        public final void doClick(View view) {
            this.a.spouseCheckBoxClick();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MpPassengerFragment a;

        public d(MpPassengerFragment mpPassengerFragment) {
            this.a = mpPassengerFragment;
        }

        public final void doClick(View view) {
            this.a.mpLayoutClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MpPassengerFragment a;

        public e(MpPassengerFragment mpPassengerFragment) {
            this.a = mpPassengerFragment;
        }

        public final void doClick(View view) {
            this.a.ContinueButtonClick();
        }
    }

    public MpPassengerFragment_ViewBinding(MpPassengerFragment mpPassengerFragment, View view) {
        this.f4822a = mpPassengerFragment;
        Class cls = TextView.class;
        mpPassengerFragment.mpNameAgeGender = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mp_name_age_gender, "field 'mpNameAgeGender'", cls);
        mpPassengerFragment.mpConcessionTypeCardNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mp_concessionType_cardNumber, "field 'mpConcessionTypeCardNumber'", cls);
        mpPassengerFragment.mpCardExpiryDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mp_Card_Expiry_Date, "field 'mpCardExpiryDate'", cls);
        mpPassengerFragment.mpDob = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mp_dob, "field 'mpDob'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.mp_checkBox, "field 'mpCheckBox' and method 'mpCheckBoxClick'");
        Class cls2 = CheckBox.class;
        mpPassengerFragment.mpCheckBox = (CheckBox) Utils.castView(findRequiredView, R.id.mp_checkBox, "field 'mpCheckBox'", cls2);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(mpPassengerFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.spouse_layout, "field 'spouseLayout' and method 'spouseLayoutClick'");
        mpPassengerFragment.spouseLayout = (LinearLayout) Utils.castView(findRequiredView2, R.id.spouse_layout, "field 'spouseLayout'", LinearLayout.class);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(mpPassengerFragment));
        mpPassengerFragment.spouseViewLine = Utils.findRequiredView(view, R.id.spouse_viewLine, "field 'spouseViewLine'");
        mpPassengerFragment.spouseNameAgeGender = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_spouse_name_age_gender, "field 'spouseNameAgeGender'", cls);
        mpPassengerFragment.spouseConcessionTypeCardNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_spouse_concessionType_cardNumber, "field 'spouseConcessionTypeCardNumber'", cls);
        mpPassengerFragment.spouseCardExpiryDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_spouse_Card_Expiry_Date, "field 'spouseCardExpiryDate'", cls);
        mpPassengerFragment.spouseDob = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_spouse_dob, "field 'spouseDob'", cls);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.spouse_checkBox, "field 'spouseCheckBox' and method 'spouseCheckBoxClick'");
        mpPassengerFragment.spouseCheckBox = (CheckBox) Utils.castView(findRequiredView3, R.id.spouse_checkBox, "field 'spouseCheckBox'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(mpPassengerFragment));
        mpPassengerFragment.mpSansademailMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.mp_sansademail_msg, "field 'mpSansademailMsg'", cls);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.mp_layout, "method 'mpLayoutClick'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(mpPassengerFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.Continue_btn, "method 'ContinueButtonClick'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(mpPassengerFragment));
    }

    public final void unbind() {
        MpPassengerFragment mpPassengerFragment = this.f4822a;
        if (mpPassengerFragment != null) {
            this.f4822a = null;
            mpPassengerFragment.mpNameAgeGender = null;
            mpPassengerFragment.mpConcessionTypeCardNumber = null;
            mpPassengerFragment.mpCardExpiryDate = null;
            mpPassengerFragment.mpDob = null;
            mpPassengerFragment.mpCheckBox = null;
            mpPassengerFragment.spouseLayout = null;
            mpPassengerFragment.spouseViewLine = null;
            mpPassengerFragment.spouseNameAgeGender = null;
            mpPassengerFragment.spouseConcessionTypeCardNumber = null;
            mpPassengerFragment.spouseCardExpiryDate = null;
            mpPassengerFragment.spouseDob = null;
            mpPassengerFragment.spouseCheckBox = null;
            mpPassengerFragment.mpSansademailMsg = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
