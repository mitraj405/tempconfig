package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.google.firebase.crashlytics.internal.common.IdManager;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class PurchaseLoyaltyPointsFragment extends Fragment {
    public static Pattern a = Pattern.compile("[0-3]{1}[0-9]{1}[A-Za-z]{5}\\d{4}[A-Za-z]{1}[a-zA-Z0-9]{1}[zZ]{1}[0-9]{1}");

    /* renamed from: a  reason: collision with other field name */
    public long f5051a = 0;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f5052a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5053a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f5054a;

    /* renamed from: a  reason: collision with other field name */
    public C1133ge f5055a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f5056a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public C1432ux f5057a = null;
    @BindView(2131361956)
    EditText areaLocality;
    public final ArrayList<String> b = new ArrayList<>();
    public final String c = "^[^a-zA-Z]+$";
    @BindView(2131362197)
    TextView city;
    public final String d = "^[0]+$";
    public String e = "";
    @BindView(2131362685)
    EditText flatDoorBlock;
    @BindView(2131362742)
    LinearLayout gst_rl;
    @BindView(2131362744)
    RelativeLayout gstcolumnShow;
    @BindView(2131362747)
    EditText gstinNumber;
    @BindView(2131362746)
    LinearLayout gstin_detail_ll;
    @BindView(2131362743)
    EditText gstpassengerName;
    @BindView(2131362570)
    EditText pinCode;
    @BindView(2131362576)
    EditText rewardPoint;
    @BindView(2131362583)
    TextView state;
    @BindView(2131364034)
    EditText streetLane;
    @BindView(2131364685)
    TextView totalValue;

    public class a implements OnSelectionListener {
        public a() {
        }

        public final void onClick(String str) {
            PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment = PurchaseLoyaltyPointsFragment.this;
            purchaseLoyaltyPointsFragment.city.setText(str);
            Boolean bool = Boolean.TRUE;
            purchaseLoyaltyPointsFragment.pinCode.getText().toString().getClass();
            purchaseLoyaltyPointsFragment.city.getText().toString().getClass();
            String B = xx.B(purchaseLoyaltyPointsFragment.pinCode);
            String trim = purchaseLoyaltyPointsFragment.city.getText().toString().trim();
            String f = C0657Qt.f();
            String format = String.format("/%s", new Object[]{B});
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).j(f + "pin" + format, trim).c(C1181iv.a()).a(E0.a()).b(new C1022f0(purchaseLoyaltyPointsFragment, bool));
            purchaseLoyaltyPointsFragment.f5054a.dismiss();
        }
    }

    static {
        C1354qp.R(PurchaseLoyaltyPointsFragment.class);
    }

    @OnFocusChange({2131361956})
    public void areaLocalityVerify(View view) {
        if (!this.areaLocality.hasFocus()) {
            String l = l(this.areaLocality.getText().toString(), "Area/Locality");
            if (l.equalsIgnoreCase("ok")) {
                i(4);
                this.f5055a.setArea(this.areaLocality.getText().toString());
                return;
            }
            k(4, l);
        }
    }

    public final void f(int i, String str) {
        ((TextView) this.f5053a.findViewById(i)).setBackground(getResources().getDrawable(getResources().getIdentifier(str, "drawable", this.f5053a.getPackageName())));
    }

    @OnFocusChange({2131362685})
    public void flaDoorBlockVerify(View view) {
        if (!this.flatDoorBlock.hasFocus()) {
            String o = o(this.flatDoorBlock.getText().toString());
            if (o.equalsIgnoreCase("ok")) {
                i(2);
                this.f5055a.setFlat(this.flatDoorBlock.getText().toString());
                return;
            }
            k(2, o);
        }
    }

    public final void g() {
        f(R.id.gst_passenger_name, "@color/disable_gstin");
        f(R.id.flat_door_block, "@color/disable_gstin");
        f(R.id.street_lane, "@color/disable_gstin");
        f(R.id.area_locality, "@color/disable_gstin");
        f(R.id.et_pincode, "@color/disable_gstin");
        f(R.id.et_state_reg, "@color/disable_gstin");
        f(R.id.city_reg, "@color/disable_gstin");
    }

    @OnFocusChange({2131362747})
    public void gstinValidate(View view) {
        if (!this.gstinNumber.hasFocus()) {
            if (this.gstinNumber.length() == 0) {
                this.gstpassengerName.setText("");
                this.flatDoorBlock.setText("");
                this.streetLane.setText("");
                this.areaLocality.setText("");
                this.pinCode.setText("");
                this.state.setText("");
                this.city.setText("City");
                this.gstpassengerName.setEnabled(false);
                this.flatDoorBlock.setEnabled(false);
                this.streetLane.setEnabled(false);
                this.areaLocality.setEnabled(false);
                this.pinCode.setEnabled(false);
                this.state.setEnabled(false);
                this.city.setEnabled(false);
                g();
                i(1);
                i(2);
                i(3);
                i(4);
                i(6);
                i(7);
                i(8);
                return;
            }
            String m = m();
            if (m.equalsIgnoreCase("ok")) {
                C1133ge geVar = new C1133ge();
                this.f5055a = geVar;
                geVar.setGstIn(this.gstinNumber.getText().toString());
                this.gstpassengerName.setEnabled(true);
                this.flatDoorBlock.setEnabled(true);
                this.streetLane.setEnabled(true);
                this.areaLocality.setEnabled(true);
                this.pinCode.setEnabled(true);
                this.state.setEnabled(true);
                this.city.setEnabled(true);
                h();
                i(8);
                return;
            }
            this.gstpassengerName.setEnabled(false);
            this.flatDoorBlock.setEnabled(false);
            this.streetLane.setEnabled(false);
            this.areaLocality.setEnabled(false);
            this.pinCode.setEnabled(false);
            this.state.setEnabled(false);
            this.city.setEnabled(false);
            g();
            k(8, m);
        }
    }

    public final void h() {
        f(R.id.flat_door_block, "@color/transparent");
        f(R.id.street_lane, "@color/transparent");
        f(R.id.area_locality, "@color/transparent");
        f(R.id.et_pincode, "@color/transparent");
        f(R.id.et_state_reg, "@color/transparent");
        f(R.id.city_reg, "@color/white_90_opa");
    }

    public final void i(int i) {
        switch (i) {
            case 1:
                this.pinCode.setError((CharSequence) null);
                this.pinCode.setTextColor(-16777216);
                return;
            case 2:
                this.flatDoorBlock.setError((CharSequence) null);
                this.flatDoorBlock.setTextColor(-16777216);
                return;
            case 3:
                this.streetLane.setError((CharSequence) null);
                this.streetLane.setTextColor(-16777216);
                return;
            case 4:
                this.areaLocality.setError((CharSequence) null);
                this.areaLocality.setTextColor(-16777216);
                return;
            case 6:
                this.gstpassengerName.setError((CharSequence) null);
                this.gstpassengerName.setTextColor(-16777216);
                return;
            case 7:
                this.city.setError((CharSequence) null);
                this.city.setTextColor(-16777216);
                return;
            case 8:
                this.gstinNumber.setError((CharSequence) null);
                this.gstinNumber.setTextColor(-16777216);
                return;
            default:
                return;
        }
    }

    public final void j(long j, boolean z) {
        double d2 = (double) (((float) j) * 1.5f);
        if (z) {
            this.rewardPoint.setText(String.valueOf(j));
        }
        this.totalValue.setText(String.format(getResources().getString(R.string.format_zerotimes), new Object[]{Double.valueOf(d2)}));
    }

    public final void k(int i, String str) {
        switch (i) {
            case 1:
                this.pinCode.setError(str);
                this.pinCode.setTextColor(-65536);
                return;
            case 2:
                this.flatDoorBlock.setError(str);
                this.flatDoorBlock.setTextColor(-65536);
                return;
            case 3:
                this.streetLane.setError(str);
                this.streetLane.setTextColor(-65536);
                return;
            case 4:
                this.areaLocality.setError(str);
                this.areaLocality.setTextColor(-65536);
                return;
            case 6:
                this.gstpassengerName.setError(str);
                this.gstpassengerName.setTextColor(-65536);
                return;
            case 7:
                this.city.setError(str);
                this.city.setTextColor(-65536);
                return;
            case 8:
                this.gstinNumber.setError(str);
                this.gstinNumber.setTextColor(-65536);
                return;
            default:
                return;
        }
    }

    public final String l(String str, String str2) {
        String trim = str.trim();
        if (trim == null || trim.equals("")) {
            return "ok";
        }
        if (trim.matches(this.c)) {
            return str2.concat(" should contain at least one alphabet.");
        }
        if (str2.compareToIgnoreCase("Area/Locality") == 0 && (trim.length() < 3 || trim.length() > 100)) {
            return str2.concat("  length should be between 3 and 100 characters.");
        }
        if (trim.length() < 3 || trim.length() > 30) {
            return str2.concat("  length should be between 3 and 30 characters.");
        }
        return "ok";
    }

    public final String m() {
        if (this.gstinNumber.getText().toString() == null || this.gstinNumber.getText().toString().trim().equals("")) {
            return "Enter GSTIN Number";
        }
        if (a.matcher(this.gstinNumber.getText().toString()).find()) {
            return "ok";
        }
        return "Invalid GSTIN";
    }

    public final String n(String str) {
        if (str == null || str.equals("")) {
            return getString(R.string.enter_pin_code);
        }
        if (str.matches(this.d)) {
            return getString(R.string.zero_not_allowed);
        }
        if (str.length() != 6) {
            return "Pin code must be 6 characters.";
        }
        return "ok";
    }

    public final String o(String str) {
        String trim = str.trim();
        if (trim == null || trim.equals("")) {
            return "Please Enter Flat/Door/Block Details";
        }
        if (trim.matches(this.c)) {
            return getString(R.string.enter_atleast_onealphabet);
        }
        if (trim.length() < 3 || trim.length() > 30) {
            return "Flat/Door/Block  length should be between 3 and 30 characters.";
        }
        return "ok";
    }

    @OnClick({2131362197})
    public void onCityClick(View view) {
        ArrayList<String> arrayList = this.b;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f5054a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f5054a.show(getActivity().getSupportFragmentManager(), "");
            this.f5054a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getContext(), arrayList, new a());
            this.f5054a.g().setText("Select City");
            this.f5054a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131362746})
    public void onClicfundadutymsg(View view) {
        if (this.gst_rl.getVisibility() == 0) {
            this.gst_rl.setVisibility(8);
        } else {
            this.gst_rl.setVisibility(0);
        }
    }

    @OnClick({2131362895})
    public void onClickMin(View view) {
        long j = this.f5051a;
        if (j > 0) {
            long j2 = j - 1;
            this.f5051a = j2;
            j(j2, true);
        }
    }

    @OnClick({2131362901})
    public void onClickPlus(View view) {
        long j = this.f5051a;
        if (j >= 0) {
            long j2 = j + 1;
            this.f5051a = j2;
            j(j2, true);
        }
    }

    @OnClick({2131362744})
    public void onClickgst(View view) {
        if (this.gst_rl.getVisibility() == 8) {
            this.gst_rl.setVisibility(0);
            if (!this.gstinNumber.hasFocus() && this.gstinNumber.length() == 0) {
                this.gstpassengerName.setText("");
                this.flatDoorBlock.setText("");
                this.streetLane.setText("");
                this.areaLocality.setText("");
                this.pinCode.setText("");
                this.state.setText("");
                this.city.setText("City");
                this.gstpassengerName.setEnabled(false);
                this.flatDoorBlock.setEnabled(false);
                this.streetLane.setEnabled(false);
                this.areaLocality.setEnabled(false);
                this.pinCode.setEnabled(false);
                this.state.setEnabled(false);
                this.city.setEnabled(false);
                g();
                return;
            }
            return;
        }
        this.gst_rl.setVisibility(8);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_purchase_loyalty_points, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5053a = getActivity();
        this.gstpassengerName.setEnabled(false);
        this.flatDoorBlock.setEnabled(false);
        this.streetLane.setEnabled(false);
        this.areaLocality.setEnabled(false);
        this.pinCode.setEnabled(false);
        this.state.setEnabled(false);
        this.city.setEnabled(false);
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), (Context) null)) {
            new Handler().postDelayed(new C0671Rq(), 5000);
        } else {
            this.f5052a = ProgressDialog.show(getActivity(), "Fetching data...", getString(R.string.please_wait_text));
            String i = C0657Qt.i();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).u1(i + "initLoyaltyPurchase").c(C1181iv.a()).a(E0.a()).b(new Tq(this));
        }
        return inflate;
    }

    @OnTextChanged({2131362747})
    public void onGstinNumberTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 15) {
            this.gstpassengerName.setEnabled(true);
            this.flatDoorBlock.setEnabled(true);
            this.streetLane.setEnabled(true);
            this.areaLocality.setEnabled(true);
            this.pinCode.setEnabled(true);
            this.state.setEnabled(true);
            this.city.setEnabled(true);
            this.gstpassengerName.requestFocus();
            h();
        }
    }

    @OnTextChanged({2131362570})
    public void onPinCodeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() == 6) {
            this.pinCode.clearFocus();
        }
    }

    @OnFocusChange({2131362570})
    public void pinCodeValidate(View view) {
        if (!this.pinCode.hasFocus()) {
            String n = n(this.pinCode.getText().toString());
            if (n.equalsIgnoreCase("ok")) {
                EditText editText = this.pinCode;
                TextView textView = this.state;
                TextView textView2 = this.city;
                editText.getText().toString();
                String trim = editText.getText().toString().trim();
                if (!trim.equals(this.e) && trim.length() == 6) {
                    this.f5052a = ProgressDialog.show(getActivity(), getString(R.string.validating_Pin_code), getString(R.string.please_wait_text));
                    textView.setText((CharSequence) null);
                    textView2.setText("City");
                    String f = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{trim});
                    ((Om) C0657Qt.c(C0793b1.a.f3912a)).j(f + "pin" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new C0656Qq(this, textView, trim, editText));
                }
                this.f5055a.setPin(this.pinCode.getText().toString());
                i(1);
                C0535I5.H(getActivity(), view);
                return;
            }
            k(1, n);
        }
    }

    @OnClick({2131363564})
    public void purchaseLoyaltyPointsClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        boolean z5;
        String str2;
        boolean z6;
        boolean z7;
        C0535I5.H(getActivity(), getView());
        C1416tx txVar = new C1416tx();
        long j = this.f5051a;
        if (j < 0 || j < 1) {
            C0535I5.o(getActivity(), getString(R.string.enter_reward_point), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (this.gstinNumber.getText() != null && !this.gstinNumber.getText().toString().trim().equals("")) {
            if (!m().equalsIgnoreCase("ok")) {
                C0535I5.o(getActivity(), getString(R.string.invalid_gstin), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
            String n = n(this.pinCode.getText().toString());
            boolean z8 = false;
            if (n.equalsIgnoreCase("ok")) {
                i(1);
                z = true;
            } else {
                k(1, n);
                z = false;
            }
            String o = o(this.flatDoorBlock.getText().toString());
            if (o.equalsIgnoreCase("ok")) {
                i(2);
                z2 = true;
            } else {
                k(2, o);
                z2 = false;
            }
            String l = l(this.streetLane.getText().toString(), "Street/Lane");
            if (l.equalsIgnoreCase("ok")) {
                i(3);
                z3 = true;
            } else {
                k(3, l);
                z3 = false;
            }
            String l2 = l(this.areaLocality.getText().toString(), "Area/Locality");
            if (l2.equalsIgnoreCase("ok")) {
                i(4);
                z4 = true;
            } else {
                k(4, l2);
                z4 = false;
            }
            if (lf.e(this.gstpassengerName) == 0) {
                str = getString(R.string.enter_name_on_gstin);
            } else if (lf.e(this.gstpassengerName) < 3 || lf.e(this.gstpassengerName) > 90) {
                str = getString(R.string.name_3to90_lenght);
            } else {
                str = "ok";
            }
            if (str.equalsIgnoreCase("ok")) {
                i(6);
                z5 = true;
            } else {
                k(6, str);
                z5 = false;
            }
            if (this.city.getText().toString() == "City") {
                str2 = "Please Select City";
            } else {
                str2 = "ok";
            }
            if (str2.equalsIgnoreCase("ok")) {
                i(7);
                z6 = true;
            } else {
                k(7, str2);
                z6 = false;
            }
            String m = m();
            if (m.equalsIgnoreCase("ok")) {
                i(8);
                z7 = true;
            } else {
                k(8, m);
                z7 = false;
            }
            this.f5055a.setState(this.state.getText().toString());
            this.f5055a.setCity(this.city.getText().toString());
            this.f5055a.setGstIn(this.gstinNumber.getText().toString());
            if (z && z2 && z3 && z4 && z5 && z6 && z7) {
                z8 = true;
            }
            if (z8) {
                txVar.setNameOnGst(this.gstinNumber.getText().toString());
                txVar.setCity(this.city.getText().toString());
                txVar.setPin(this.pinCode.getText().toString());
                txVar.setStreet(this.streetLane.getText().toString());
                txVar.setArea(this.areaLocality.getText().toString());
                txVar.setState(this.state.getText().toString());
                txVar.setFlat(this.flatDoorBlock.getText().toString());
            }
        }
        txVar.setPointsToPurchase(Long.valueOf(this.f5051a));
        txVar.setGstEnableFlag(this.f5057a.getSoftPointsPurchaseView().getGstEnableFlag());
        C1432ux uxVar = new C1432ux();
        uxVar.setSoftPointsPurchaseView(txVar);
        String valueOf = String.valueOf(((long) (new SecureRandom().nextDouble() * 9.0E9d)) + 1000000000);
        Bundle bundle = new Bundle();
        MakePaymentNewFragment makePaymentNewFragment = new MakePaymentNewFragment();
        makePaymentNewFragment.f4778a = uxVar;
        bundle.putSerializable("BankDetailDto", this.f5057a.getBankDetailDTO());
        bundle.putSerializable("eWalletDto", this.f5057a.getEwalletDTO());
        bundle.putString("TotalFare", this.totalValue.getText().toString());
        bundle.putString("ClientTxnId", valueOf);
        bundle.putBoolean("purchaseLoyaltyPoint", true);
        makePaymentNewFragment.setArguments(bundle);
        HomeActivity.n(getActivity(), makePaymentNewFragment, C1218kf.MAKE_PAYMENT.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnTextChanged({2131362576})
    public void rewardPointTextChange() {
        String B = xx.B(this.rewardPoint);
        if (B.equals("")) {
            this.totalValue.setText(IdManager.DEFAULT_VERSION_NAME);
            return;
        }
        long longValue = Long.valueOf(B).longValue();
        this.f5051a = longValue;
        if (longValue >= 0) {
            j(longValue, false);
        }
    }

    @OnFocusChange({2131364034})
    public void streetLaneVerify(View view) {
        if (!this.streetLane.hasFocus()) {
            String l = l(this.streetLane.getText().toString(), "Street/Lane");
            if (l.equalsIgnoreCase("ok")) {
                i(3);
                this.f5055a.setStreet(this.streetLane.getText().toString());
                return;
            }
            k(3, l);
        }
    }
}
