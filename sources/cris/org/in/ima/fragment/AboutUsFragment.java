package cris.org.in.ima.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;

public class AboutUsFragment extends Fragment {
    @BindView(2131361824)
    AdManagerAdView about_us_bottom;
    @BindView(2131361952)
    TextView appVersionText;
    @BindView(2131361953)
    TextView appVersionTextHi;
    @BindView(2131362321)
    ImageView crisLogo;
    @BindView(2131362322)
    ImageView crisLogoHi;

    static {
        C1354qp.R(AboutUsFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_about_us, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        TextView textView = this.appVersionText;
        textView.setText(this.appVersionText.getText() + " : 4.2.28(271)");
        TextView textView2 = this.appVersionTextHi;
        textView2.setText(this.appVersionTextHi.getText() + " : 4.2.28(271)");
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            this.appVersionTextHi.setVisibility(0);
            this.crisLogoHi.setVisibility(0);
            this.appVersionText.setVisibility(8);
            this.crisLogo.setVisibility(8);
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.about_us_bottom, googleAdParamDTO);
        return inflate;
    }
}
