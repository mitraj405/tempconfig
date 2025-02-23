package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class AboutUsFragment_ViewBinding implements Unbinder {
    public AboutUsFragment a;

    public AboutUsFragment_ViewBinding(AboutUsFragment aboutUsFragment, View view) {
        this.a = aboutUsFragment;
        Class cls = TextView.class;
        aboutUsFragment.appVersionText = (TextView) Utils.findRequiredViewAsType(view, R.id.appVersionText, "field 'appVersionText'", cls);
        aboutUsFragment.appVersionTextHi = (TextView) Utils.findRequiredViewAsType(view, R.id.appVersionText_hindi, "field 'appVersionTextHi'", cls);
        Class cls2 = ImageView.class;
        aboutUsFragment.crisLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.cris_logo, "field 'crisLogo'", cls2);
        aboutUsFragment.crisLogoHi = (ImageView) Utils.findRequiredViewAsType(view, R.id.cris_logo_for_hindi, "field 'crisLogoHi'", cls2);
        aboutUsFragment.about_us_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.about_us_bottom, "field 'about_us_bottom'", AdManagerAdView.class);
    }

    public final void unbind() {
        AboutUsFragment aboutUsFragment = this.a;
        if (aboutUsFragment != null) {
            this.a = null;
            aboutUsFragment.appVersionText = null;
            aboutUsFragment.appVersionTextHi = null;
            aboutUsFragment.crisLogo = null;
            aboutUsFragment.crisLogoHi = null;
            aboutUsFragment.about_us_bottom = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
