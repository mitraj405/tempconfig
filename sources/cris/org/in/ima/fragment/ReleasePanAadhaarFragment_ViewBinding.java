package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class ReleasePanAadhaarFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ReleasePanAadhaarFragment f5073a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ReleasePanAadhaarFragment a;

        public a(ReleasePanAadhaarFragment releasePanAadhaarFragment) {
            this.a = releasePanAadhaarFragment;
        }

        public final void doClick(View view) {
            this.a.tv_release_pan_aadhaar_click();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ReleasePanAadhaarFragment a;

        public b(ReleasePanAadhaarFragment releasePanAadhaarFragment) {
            this.a = releasePanAadhaarFragment;
        }

        public final void doClick(View view) {
            this.a.tv_tnc_click();
        }
    }

    public ReleasePanAadhaarFragment_ViewBinding(ReleasePanAadhaarFragment releasePanAadhaarFragment, View view) {
        this.f5073a = releasePanAadhaarFragment;
        Class cls = TextView.class;
        releasePanAadhaarFragment.user_name_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.user_name_tv, "field 'user_name_tv'", cls);
        releasePanAadhaarFragment.aadhaar_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.aadhaar_tv, "field 'aadhaar_tv'", cls);
        releasePanAadhaarFragment.pan_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.pan_tv, "field 'pan_tv'", cls);
        releasePanAadhaarFragment.balance_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.balance_tv, "field 'balance_tv'", cls);
        releasePanAadhaarFragment.et_login_pass = (EditText) Utils.findRequiredViewAsType(view, R.id.et_login_pass, "field 'et_login_pass'", EditText.class);
        releasePanAadhaarFragment.cb_tnc = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_tnc, "field 'cb_tnc'", CheckBox.class);
        releasePanAadhaarFragment.mPublisherAdview = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.multiple_ad_sizes_view, "field 'mPublisherAdview'", AdManagerAdView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_release_pan_aadhaar, "method 'tv_release_pan_aadhaar_click'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(releasePanAadhaarFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_tnc, "method 'tv_tnc_click'");
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(releasePanAadhaarFragment));
    }

    public final void unbind() {
        ReleasePanAadhaarFragment releasePanAadhaarFragment = this.f5073a;
        if (releasePanAadhaarFragment != null) {
            this.f5073a = null;
            releasePanAadhaarFragment.user_name_tv = null;
            releasePanAadhaarFragment.aadhaar_tv = null;
            releasePanAadhaarFragment.pan_tv = null;
            releasePanAadhaarFragment.balance_tv = null;
            releasePanAadhaarFragment.et_login_pass = null;
            releasePanAadhaarFragment.cb_tnc = null;
            releasePanAadhaarFragment.mPublisherAdview = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
