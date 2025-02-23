package cris.org.in.ima.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;

public class ContactUsFragment extends Fragment {
    @BindView(2131362301)
    AdManagerAdView contact_us_bottom;
    @BindView(2131362302)
    WebView mWebView;

    public class a extends WebViewClient {
        public a() {
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            boolean startsWith = str.startsWith("tel:");
            ContactUsFragment contactUsFragment = ContactUsFragment.this;
            if (startsWith) {
                contactUsFragment.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                return true;
            } else if (str.startsWith("mailto:")) {
                contactUsFragment.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                return true;
            } else if (!str.startsWith("https:")) {
                return false;
            } else {
                contactUsFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }
    }

    static {
        C1354qp.R(ContactUsFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_contactus, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.contact_us_bottom, googleAdParamDTO);
        this.mWebView.setWebViewClient(new a());
        if (Bw.e(requireContext()).f().equalsIgnoreCase("hi")) {
            this.mWebView.loadUrl("https://contents.irctc.co.in/hi/ContactUsHi.html");
        } else {
            this.mWebView.loadUrl("https://contents.irctc.co.in/en/ContactUsEn.html");
        }
        this.mWebView.requestFocusFromTouch();
        return inflate;
    }
}
