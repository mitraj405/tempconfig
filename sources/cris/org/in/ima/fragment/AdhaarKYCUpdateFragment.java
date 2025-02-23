package cris.org.in.ima.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.LoginActivity;
import cris.org.in.prs.ima.R;
import defpackage.d7;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdhaarKYCUpdateFragment extends Fragment {
    public Jh a = null;

    /* renamed from: a  reason: collision with other field name */
    public C1122g f4406a = null;
    @BindView(2131361822)
    TextView aadharNo;
    @BindView(2131361919)
    TextView address;
    public String c = null;
    @BindView(2131362277)
    TextView colony;
    public String d = null;
    @BindView(2131362417)
    TextView district;
    @BindView(2131362442)
    TextView dob;
    public String e = null;
    @BindView(2131362726)
    TextView gender;
    @BindView(2131363295)
    TextView name;
    @BindView(2131363503)
    TextView pinCode;
    @BindView(2131364025)
    TextView state;
    @BindView(2131364030)
    TextView status_msg;
    @BindView(2131364798)
    TextView user_name_tv;
    @BindView(2131364799)
    TextView user_num_tv;

    public class a extends ClickableSpan {
        public final /* synthetic */ String c;

        public a(String str) {
            this.c = str;
        }

        public final void onClick(View view) {
            AdhaarKYCUpdateFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.c)));
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    static {
        C1354qp.R(AdhaarKYCUpdateFragment.class);
    }

    public static String g(String str) {
        Matcher matcher = Pattern.compile("<a[^>]*>(.*?)</a>").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static String h(String str) {
        int indexOf = str.indexOf("href=\"") + 6;
        return str.substring(indexOf, str.indexOf("\"", indexOf));
    }

    public final SpannableStringBuilder f(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf = str.indexOf(str2);
        int length = str2.length() + indexOf;
        FragmentActivity activity = getActivity();
        Object obj = d7.a;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(activity, R.color.light_blue));
        StyleSpan styleSpan = new StyleSpan(1);
        a aVar = new a(str3);
        if (indexOf >= 0 && length <= str.length()) {
            spannableStringBuilder.setSpan(styleSpan, indexOf, length, 18);
            spannableStringBuilder.setSpan(aVar, indexOf, length, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, length, 18);
        }
        return spannableStringBuilder;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String[] strArr;
        String str;
        String str2;
        String str3;
        String str4;
        SpannableStringBuilder spannableStringBuilder;
        String str5;
        String[] strArr2;
        String str6;
        String str7;
        String str8;
        String str9;
        SpannableStringBuilder spannableStringBuilder2;
        View inflate = layoutInflater.inflate(R.layout.activity_aadhar_kyc_update, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        Bundle arguments = getArguments();
        HomeActivity.t();
        HomeActivity.G((String) null);
        if (arguments != null) {
            this.f4406a = (C1122g) arguments.getSerializable("AadharKYCDTO");
            this.a = (Jh) arguments.getSerializable("kycOtpDTO");
            this.c = (String) arguments.getSerializable("successMsgForPanKyc");
            this.d = (String) arguments.getSerializable("successMsgForPanKyc1");
            this.e = (String) arguments.getSerializable("successMsgForPanKyc2");
            C1122g gVar = this.f4406a;
            if (gVar != null) {
                gVar.toString();
                this.user_name_tv.setText(R.string.name_as_per_Aadhaar);
                this.user_num_tv.setText(R.string.adhar_num);
                this.f4406a.toString();
                this.name.setText(this.f4406a.getAadhaarName());
                this.aadharNo.setText(C0535I5.c0(this.f4406a.getAadhaarNumber()));
                TextView textView = this.gender;
                textView.setText(getString(R.string.gender) + this.f4406a.getGender());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                try {
                    TextView textView2 = this.dob;
                    textView2.setText(getString(R.string.dob) + simpleDateFormat.format(this.f4406a.getDateOfBirth()));
                } catch (Exception e2) {
                    e2.getMessage();
                }
                if (this.f4406a.getAddress() != null && !this.f4406a.getAddress().isEmpty()) {
                    TextView textView3 = this.address;
                    textView3.setText(getString(R.string.address) + this.f4406a.getAddress());
                    this.address.setVisibility(0);
                }
                if (this.f4406a.getColony() != null && !this.f4406a.getColony().isEmpty()) {
                    TextView textView4 = this.colony;
                    textView4.setText(getString(R.string.colony) + this.f4406a.getColony());
                    this.colony.setVisibility(0);
                }
                if (this.f4406a.getDistrict() != null && !this.f4406a.getDistrict().isEmpty()) {
                    TextView textView5 = this.district;
                    textView5.setText(getString(R.string.district) + this.f4406a.getDistrict());
                    this.district.setVisibility(0);
                }
                if (this.f4406a.getState() != null && !this.f4406a.getState().isEmpty()) {
                    TextView textView6 = this.state;
                    textView6.setText(getString(R.string.state_kyc) + this.f4406a.getState());
                    this.state.setVisibility(0);
                }
                if (this.f4406a.getPincode() != null && !this.f4406a.getPincode().isEmpty()) {
                    TextView textView7 = this.pinCode;
                    textView7.setText(getString(R.string.pin_code_kyc) + this.f4406a.getPincode());
                    this.pinCode.setVisibility(0);
                }
                if (this.f4406a.getStatus2() == null && this.f4406a.getStatus1() == null) {
                    str5 = this.f4406a.getStatus();
                } else {
                    str5 = this.f4406a.getStatus2();
                }
                if (str5.contains("<br>")) {
                    strArr2 = str5.replace("<br>", "\n\n").split("\n\n");
                } else {
                    strArr2 = new String[]{str5};
                }
                String str10 = strArr2[0];
                if (strArr2.length > 1) {
                    str6 = strArr2[1];
                } else {
                    str6 = "";
                }
                String h = h(str10);
                if (!str6.isEmpty()) {
                    str7 = h(str6);
                } else {
                    str7 = "";
                }
                String replaceAll = str10.replaceAll("<a[^>]*>(.*?)</a>", "$1");
                if (!str6.isEmpty()) {
                    str8 = str6.replaceAll("<a[^>]*>(.*?)</a>", "$1");
                } else {
                    str8 = "";
                }
                String g = g(str10);
                if (!str6.isEmpty()) {
                    str9 = g(str6);
                } else {
                    str9 = "";
                }
                SpannableStringBuilder f = f(replaceAll, g, h);
                if (!str6.isEmpty()) {
                    spannableStringBuilder2 = f(str8, str9, str7);
                } else {
                    spannableStringBuilder2 = new SpannableStringBuilder("");
                }
                this.status_msg.setText("");
                if (!(this.f4406a.getStatus2() == null && this.f4406a.getStatus1() == null)) {
                    this.status_msg.append(this.f4406a.getStatus() + "\n\n" + this.f4406a.getStatus1());
                    this.status_msg.append("\n\n");
                }
                if (f.length() > 0) {
                    this.status_msg.append(f);
                }
                if (spannableStringBuilder2.length() > 0) {
                    this.status_msg.append("\n\n");
                    this.status_msg.append(spannableStringBuilder2);
                }
                this.status_msg.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.gender.setVisibility(8);
                this.user_name_tv.setText(R.string.name_as_per_Pan);
                this.user_num_tv.setText(R.string.pan_num);
                this.name.setText(this.a.getKycUserName());
                this.aadharNo.setText(C0535I5.c0(this.a.getKycCardId()));
                TextView textView8 = this.dob;
                textView8.setText(getString(R.string.dob) + this.a.getKycUserDOB());
                String str11 = this.e;
                if (str11 == null && this.d == null) {
                    str11 = this.c;
                }
                if (str11.contains("<br>")) {
                    strArr = str11.replace("<br>", "\n\n").split("\n\n");
                } else {
                    strArr = new String[]{str11};
                }
                String str12 = strArr[0];
                if (strArr.length > 1) {
                    str = strArr[1];
                } else {
                    str = "";
                }
                String h2 = h(str12);
                if (!str.isEmpty()) {
                    str2 = h(str);
                } else {
                    str2 = "";
                }
                String replaceAll2 = str12.replaceAll("<a[^>]*>(.*?)</a>", "$1");
                if (!str.isEmpty()) {
                    str3 = str.replaceAll("<a[^>]*>(.*?)</a>", "$1");
                } else {
                    str3 = "";
                }
                String g2 = g(str12);
                if (!str.isEmpty()) {
                    str4 = g(str);
                } else {
                    str4 = "";
                }
                SpannableStringBuilder f2 = f(replaceAll2, g2, h2);
                if (!str.isEmpty()) {
                    spannableStringBuilder = f(str3, str4, str2);
                } else {
                    spannableStringBuilder = new SpannableStringBuilder("");
                }
                this.status_msg.setText("");
                if (!(this.e == null && this.d == null)) {
                    this.status_msg.append(this.c + "\n\n" + this.d);
                    this.status_msg.append("\n\n");
                }
                if (f2.length() > 0) {
                    this.status_msg.append(f2);
                }
                if (spannableStringBuilder.length() > 0) {
                    this.status_msg.append("\n\n");
                    this.status_msg.append(spannableStringBuilder);
                }
                this.status_msg.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        return inflate;
    }

    @OnClick({2131363361})
    public void onOkClick() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}
