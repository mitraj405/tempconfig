package cris.org.in.ima.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MpPassengerFragment extends Fragment {
    public Yl a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f4818a;

    /* renamed from: a  reason: collision with other field name */
    public PassengerDetailDTO f4819a;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f4820a = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4821a;
    public ArrayList<String> b;
    @BindView(2131364492)
    TextView mpCardExpiryDate;
    @BindView(2131363246)
    CheckBox mpCheckBox;
    @BindView(2131364493)
    TextView mpConcessionTypeCardNumber;
    @BindView(2131364494)
    TextView mpDob;
    @BindView(2131364495)
    TextView mpNameAgeGender;
    @BindView(2131363253)
    TextView mpSansademailMsg;
    @BindView(2131364606)
    TextView spouseCardExpiryDate;
    @BindView(2131363999)
    CheckBox spouseCheckBox;
    @BindView(2131364607)
    TextView spouseConcessionTypeCardNumber;
    @BindView(2131364608)
    TextView spouseDob;
    @BindView(2131364000)
    LinearLayout spouseLayout;
    @BindView(2131364609)
    TextView spouseNameAgeGender;
    @BindView(2131364001)
    View spouseViewLine;

    static {
        C1354qp.R(MpPassengerFragment.class);
    }

    @OnClick({2131361802})
    public void ContinueButtonClick() {
        short s;
        this.f4821a = new ArrayList<>();
        short shortValue = this.a.getMpStatus().shortValue();
        SimpleDateFormat simpleDateFormat = this.f4820a;
        if (shortValue != 1 || !this.mpCheckBox.isChecked()) {
            s = 0;
        } else {
            PassengerDetailDTO passengerDetailDTO = new PassengerDetailDTO();
            this.f4819a = passengerDetailDTO;
            passengerDetailDTO.setPassengerName(this.a.getBookingName());
            if (this.a.getDateOfBirth() != null) {
                this.f4819a.setPassengerAge(Short.valueOf((short) C0535I5.f(this.a.getDateOfBirth())));
            }
            this.f4819a.setPassengerGender(this.a.getGender());
            this.f4819a.setPsgnConcDOB(simpleDateFormat.format(this.a.getDateOfBirth()));
            this.f4819a.setPsgnConcType(this.a.getConcType());
            this.f4819a.setPsgnConcCardId(this.a.getIdCardNumber());
            this.f4819a.setDateOfBirth(this.a.getDateOfBirth());
            s = (short) 1;
            this.f4819a.setPassengerSerialNumber(Short.valueOf(s));
            if (this.a.getCardExpiryDate() != null) {
                this.f4819a.setPsgnConcCardExpiryDate(simpleDateFormat.format(this.a.getCardExpiryDate()));
            }
            this.f4819a.setPassengerNationality("IN");
            this.f4821a.add(this.f4819a);
        }
        if (this.a.getSpouseStatus().shortValue() == 1 && this.spouseCheckBox.isChecked()) {
            PassengerDetailDTO passengerDetailDTO2 = new PassengerDetailDTO();
            this.f4819a = passengerDetailDTO2;
            passengerDetailDTO2.setPassengerName("Spouse");
            this.f4819a.setPassengerAge(Short.valueOf("99"));
            this.f4819a.setPassengerGender(this.a.getSpouseGender());
            if (this.a.getSpouseDateOfBirth() != null) {
                this.f4819a.setPsgnConcDOB(simpleDateFormat.format(this.a.getSpouseDateOfBirth()));
            }
            this.f4819a.setPsgnConcType(this.a.getSpouseConcType());
            this.f4819a.setPsgnConcCardId(this.a.getSpouseCardNumber());
            this.f4819a.setDateOfBirth(this.a.getSpouseDateOfBirth());
            this.f4819a.setPassengerSerialNumber(Short.valueOf((short) (s + 1)));
            if (this.a.getSpouseCardExpiryDate() != null) {
                this.f4819a.setPsgnConcCardExpiryDate(simpleDateFormat.format(this.a.getSpouseCardExpiryDate()));
            }
            this.f4819a.setPassengerNationality("IN");
            this.f4821a.add(this.f4819a);
        }
        PassengerDetailFragment passengerDetailFragment = new PassengerDetailFragment();
        this.f4818a.putSerializable("psgnDetails", this.f4821a);
        this.f4818a.putSerializable("mpPsgnDetails", this.b);
        passengerDetailFragment.setArguments(this.f4818a);
        HomeActivity.n(getContext(), passengerDetailFragment, C1218kf.ADD_PASSENGER.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnClick({2131363246})
    public void mpCheckBoxClick() {
        if (this.mpCheckBox.isChecked()) {
            this.mpCheckBox.setChecked(true);
        } else {
            this.mpCheckBox.setChecked(false);
        }
    }

    @OnClick({2131363250})
    public void mpLayoutClick() {
        if (!this.mpCheckBox.isChecked()) {
            this.mpCheckBox.setChecked(true);
        } else {
            this.mpCheckBox.setChecked(false);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.fragment_mp_passenger, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        HomeActivity.f4185b.setVisibility(8);
        HomeActivity.K();
        Yl yl = C1450w1.f7007a;
        this.a = yl;
        yl.toString();
        StringBuffer stringBuffer = new StringBuffer(this.a.getBookingName() + " ");
        if (this.a.getDateOfBirth() != null) {
            stringBuffer.append(C0535I5.f(this.a.getDateOfBirth()) + " Years,");
        } else {
            stringBuffer.append(",");
        }
        String str2 = "Male";
        if (this.a.getGender().equals("M")) {
            str = str2;
        } else {
            str = "Female";
        }
        stringBuffer.append(str);
        this.mpNameAgeGender.setText(stringBuffer);
        TextView textView = this.mpConcessionTypeCardNumber;
        textView.setText(this.a.getConcType() + " | " + this.a.getIdCardNumber());
        StringBuffer stringBuffer2 = new StringBuffer("Card Expiry Date | ");
        if (this.a.getCardExpiryDate() != null) {
            stringBuffer2.append(C0535I5.j(this.a.getCardExpiryDate()));
        }
        this.mpCardExpiryDate.setText(stringBuffer2);
        StringBuffer stringBuffer3 = new StringBuffer("Date of Birth | ");
        if (this.a.getDateOfBirth() != null) {
            stringBuffer3.append(C0535I5.j(this.a.getDateOfBirth()));
        }
        this.mpDob.setText(stringBuffer3);
        if (this.a.getMpStatus().shortValue() != 1) {
            this.mpCheckBox.setEnabled(false);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        this.b = arrayList;
        arrayList.add(this.a.getIdCardNumber());
        ArrayList<String> arrayList2 = this.b;
        SimpleDateFormat simpleDateFormat = this.f4820a;
        arrayList2.add(simpleDateFormat.format(this.a.getDateOfBirth()));
        this.b.add(simpleDateFormat.format(this.a.getCardExpiryDate()));
        if (this.a.getSpouseBookingName() == null || this.a.getSpouseBookingName().trim().equals("")) {
            this.spouseLayout.setVisibility(8);
            this.spouseViewLine.setVisibility(8);
        } else {
            this.spouseLayout.setVisibility(0);
            StringBuffer stringBuffer4 = new StringBuffer(this.a.getSpouseBookingName() + " ");
            if (this.a.getSpouseDateOfBirth() != null) {
                stringBuffer4.append(C0535I5.f(this.a.getSpouseDateOfBirth()) + " Years,");
            } else {
                stringBuffer4.append(",");
            }
            if (!this.a.getSpouseGender().equals("M")) {
                str2 = "Female";
            }
            stringBuffer4.append(str2);
            this.spouseNameAgeGender.setText(stringBuffer4);
            TextView textView2 = this.spouseConcessionTypeCardNumber;
            textView2.setText(this.a.getSpouseConcType() + " | " + this.a.getSpouseCardNumber());
            StringBuffer stringBuffer5 = new StringBuffer("Card Expiry Date | ");
            if (this.a.getSpouseCardExpiryDate() != null) {
                stringBuffer5.append(C0535I5.j(this.a.getSpouseCardExpiryDate()));
            }
            this.spouseCardExpiryDate.setText(stringBuffer5);
            StringBuffer stringBuffer6 = new StringBuffer("Date of Birth | ");
            if (this.a.getSpouseDateOfBirth() != null) {
                stringBuffer6.append(C0535I5.j(this.a.getSpouseDateOfBirth()));
            }
            this.spouseDob.setText(stringBuffer6);
            if (this.a.getSpouseStatus().shortValue() != 1) {
                this.spouseCheckBox.setEnabled(false);
            }
        }
        this.f4818a = getArguments();
        StringBuilder n = lf.n("<html><body><div>" + getResources().getString(R.string.mp_booking_msg), " <font color='#47afff'><a href='mailto:");
        n.append(getResources().getString(R.string.mp_booking_msg_email));
        n.append("'>");
        n.append(getResources().getString(R.string.mp_booking_msg_email));
        n.append("</a></font>");
        String sb = n.toString();
        this.mpSansademailMsg.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = this.mpSansademailMsg;
        textView3.setText(Html.fromHtml(sb + "</div></body></html>"));
        return inflate;
    }

    @OnClick({2131363999})
    public void spouseCheckBoxClick() {
        if (this.spouseCheckBox.isChecked()) {
            this.spouseCheckBox.setChecked(true);
        } else {
            this.spouseCheckBox.setChecked(false);
        }
    }

    @OnClick({2131364000})
    public void spouseLayoutClick() {
        if (!this.spouseCheckBox.isChecked()) {
            this.spouseCheckBox.setChecked(true);
        } else {
            this.spouseCheckBox.setChecked(false);
        }
    }
}
