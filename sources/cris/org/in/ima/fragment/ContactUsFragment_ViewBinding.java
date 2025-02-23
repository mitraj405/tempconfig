package cris.org.in.ima.fragment;

import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class ContactUsFragment_ViewBinding implements Unbinder {
    public ContactUsFragment a;

    public ContactUsFragment_ViewBinding(ContactUsFragment contactUsFragment, View view) {
        this.a = contactUsFragment;
        contactUsFragment.mWebView = (WebView) Utils.findRequiredViewAsType(view, R.id.contact_us_view, "field 'mWebView'", WebView.class);
        contactUsFragment.contact_us_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.contact_us_bottom, "field 'contact_us_bottom'", AdManagerAdView.class);
    }

    public final void unbind() {
        ContactUsFragment contactUsFragment = this.a;
        if (contactUsFragment != null) {
            this.a = null;
            contactUsFragment.mWebView = null;
            contactUsFragment.contact_us_bottom = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
