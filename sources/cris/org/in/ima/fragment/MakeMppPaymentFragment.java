package cris.org.in.ima.fragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.ZaakpayActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class MakeMppPaymentFragment extends Fragment implements C1245lp {
    public static final /* synthetic */ int d = 0;
    public final char a = ' ';

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<C0489Dv> f4762a;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public String f4763c;
    @BindView(2131363014)
    LinearLayout cardInputLayout;
    @BindView(2131362520)
    EditText cardNumber;
    @BindView(2131362521)
    TextView cardValidity;
    @BindView(2131362525)
    EditText cvvNo;

    /* renamed from: d  reason: collision with other field name */
    public String f4764d;
    public String e;
    public String f = "";
    @BindView(2131363013)
    LinearLayout llCardDetailsInput;
    @BindView(2131362549)
    EditText nameOnCard;
    @BindView(2131363469)
    TextView payNowButton;
    @BindView(2131363052)
    LinearLayout paymentOptionCards;
    @BindView(2131363053)
    RelativeLayout paymentOptionNetbanking;
    @BindView(2131363054)
    RelativeLayout paymentOptionWallet;
    @BindView(2131363480)
    AdManagerAdView paymentoptionbottom;
    @BindView(2131364528)
    TextView pgOptionWalletTv;
    @BindView(2131364678)
    TextView totalFare;

    public class a implements Ev<Mv> {
        public a() {
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            TextView textView = MakeMppPaymentFragment.this.cardValidity;
            textView.setText(i2 + RemoteSettings.FORWARD_SLASH_STRING + i);
        }
    }

    static {
        C1354qp.R(MakeMppPaymentFragment.class);
    }

    public static String f(String str, boolean z) {
        String str2;
        String str3 = null;
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray names = jSONObject.names();
                for (int i = 0; i < names.length(); i++) {
                    if (jSONObject.get(names.getString(i)) != null) {
                        if (str3 == null) {
                            str2 = "";
                        } else {
                            str2 = str3 + "&";
                        }
                        str3 = str2 + names.getString(i) + "=" + URLEncoder.encode(jSONObject.get(names.getString(i)).toString(), "UTF-8");
                    }
                }
                return str3;
            } catch (Exception e2) {
                e2.getMessage();
                return null;
            }
        } else {
            return "encdata=" + URLEncoder.encode(str, "UTF-8");
        }
    }

    public final void e() {
        String str;
        ArrayList<Do> paramList = C1480xl.f7038a.f7042a.getParamList();
        if (paramList != null && paramList.get(0) != null) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            for (int i = 0; i < paramList.size(); i++) {
                if (paramList.get(i).getKey().equalsIgnoreCase("DO_REDIRECT")) {
                    str3 = paramList.get(i).getValue();
                } else if (paramList.get(i).getKey().equalsIgnoreCase("POST_URL")) {
                    str6 = paramList.get(i).getValue();
                } else if (paramList.get(i).getKey().equalsIgnoreCase("bankUrl")) {
                    str6 = paramList.get(i).getValue();
                } else if (paramList.get(i).getKey().equalsIgnoreCase("POST_DATA")) {
                    str5 = paramList.get(i).getValue();
                } else if (paramList.get(i).getKey().equalsIgnoreCase("encdata")) {
                    str5 = paramList.get(i).getValue();
                } else if (paramList.get(i).getKey().equalsIgnoreCase("RESPONSE")) {
                    str4 = paramList.get(i).getValue();
                }
            }
            if (str3 == null || !str3.equalsIgnoreCase("true")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Do("RESPONSE", str4));
                C1480xl.f7038a.c(this, arrayList);
                return;
            }
            C1480xl xlVar = C1480xl.f7038a;
            xlVar.f7042a.getTransationId();
            ZaakpayActivity zaakpayActivity = ZaakpayActivity.a;
            HomeActivity.f4182a = zaakpayActivity;
            if (xlVar.f7042a.getBankId() == 101) {
                str2 = f(str5, true);
                str = "Zaakpay";
            } else if (xlVar.f7042a.getBankId() == 108) {
                str2 = f(str5, false);
                str = "PAYU_MOB_AG";
            } else {
                str = null;
            }
            zaakpayActivity.f4373a = this;
            Intent intent = new Intent(getActivity(), ZaakpayActivity.class);
            intent.putExtra("post_data", str2);
            intent.putExtra("post_url", str6);
            intent.putExtra("js_routine", str);
            xlVar.f7042a.getBankId();
            getActivity().startActivityForResult(intent, xlVar.f7042a.getBankId());
        }
    }

    public final void g() {
        this.llCardDetailsInput.setVisibility(8);
        this.cardNumber.setText("");
        this.nameOnCard.setText("");
        this.cardValidity.setText("");
        this.cvvNo.setText("");
    }

    @OnClick({2131363718})
    public void onCardClick() {
        if (this.llCardDetailsInput.getVisibility() == 8) {
            this.cardNumber.addTextChangedListener(new T(this));
            this.cvvNo.setOnFocusChangeListener(new U(this));
            this.llCardDetailsInput.setVisibility(0);
            this.payNowButton.setVisibility(0);
            return;
        }
        g();
    }

    @OnClick({2131363053})
    public void onClickNetBanking() {
        g();
        this.payNowButton.setVisibility(8);
        new C0714Uw(getContext(), this.f4762a, new a()).show();
    }

    @OnClick({2131363469})
    public void onClickPayButton() {
        boolean z;
        String str;
        String str2;
        this.c = 0;
        String replaceAll = this.cardNumber.getText().toString().toString().replaceAll("[^0-9]", "");
        if (replaceAll.length() < 13 || replaceAll.length() > 19) {
            C0535I5.m(getActivity(), false, "Invalid card number", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            this.cardNumber.requestFocus();
            this.c++;
        } else {
            String E = C1354qp.E(replaceAll);
            this.e = E;
            E.equalsIgnoreCase("rupay");
            int i = 0;
            boolean z2 = false;
            for (int length = replaceAll.length() - 1; length >= 0; length--) {
                int parseInt = Integer.parseInt(replaceAll.substring(length, length + 1));
                if (z2 && (parseInt = parseInt * 2) > 9) {
                    parseInt = (parseInt % 10) + 1;
                }
                i += parseInt;
                z2 = !z2;
            }
            if (i % 10 == 0) {
                z = true;
            } else {
                z = false;
            }
            int i2 = this.c;
            if (i2 != 0 || !z) {
                this.c = i2 + 1;
                C0535I5.m(getActivity(), false, "Invalid card number", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                this.cardNumber.requestFocus();
            } else {
                boolean equalsIgnoreCase = "maestro".equalsIgnoreCase(this.e);
                String charSequence = this.cardValidity.getText().toString();
                if (charSequence == null || charSequence.trim().equalsIgnoreCase("")) {
                    str2 = null;
                    str = null;
                } else {
                    str2 = charSequence.split(RemoteSettings.FORWARD_SLASH_STRING)[0];
                    if (str2.length() == 1) {
                        str2 = "0".concat(str2);
                    }
                    str = charSequence.split(RemoteSettings.FORWARD_SLASH_STRING)[1];
                }
                if (equalsIgnoreCase) {
                    if (C0572L5.b(str2) && !C0572L5.b(str)) {
                        C0535I5.m(getActivity(), false, "Select month", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        this.cardValidity.requestFocus();
                        this.c++;
                    } else if (!C0572L5.b(str2) && C0572L5.b(str)) {
                        C0535I5.m(getActivity(), false, "Select year", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        this.cardValidity.requestFocus();
                        this.c++;
                    } else if (!C0572L5.b(str2) || !C0572L5.b(str)) {
                        int i3 = Calendar.getInstance().get(2) + 1;
                        int i4 = Calendar.getInstance().get(1) - 2000;
                        if (Integer.parseInt(str2) < i3) {
                            if (str.compareTo("20" + i4) == 0) {
                                C0535I5.m(getActivity(), false, "Select month", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                                this.cardValidity.requestFocus();
                                this.c++;
                            }
                        }
                    } else {
                        str2 = "";
                        str = str2;
                    }
                } else if (C0572L5.b(str2)) {
                    C0535I5.m(getActivity(), false, "Select month", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    this.cardValidity.requestFocus();
                    this.c++;
                } else if (C0572L5.b(str)) {
                    C0535I5.m(getActivity(), false, "Select year", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    this.cardValidity.requestFocus();
                    this.c++;
                } else {
                    int i5 = Calendar.getInstance().get(2) + 1;
                    int i6 = Calendar.getInstance().get(1) - 2000;
                    if (Integer.parseInt(str2) < i5) {
                        if (str.compareTo("20" + i6) == 0) {
                            C0535I5.m(getActivity(), false, "Select month", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                            this.cardValidity.requestFocus();
                            this.c++;
                        }
                    }
                }
                if (this.c == 0) {
                    this.f4763c = str2;
                    this.f4764d = str;
                    String obj = this.cvvNo.getText().toString();
                    boolean equalsIgnoreCase2 = "amex".equalsIgnoreCase(this.e);
                    if (obj.length() == 0) {
                        if (!equalsIgnoreCase) {
                            C0535I5.m(getActivity(), false, "Enter valid CVV", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                            this.cvvNo.requestFocus();
                            this.c++;
                        }
                    } else if ((!equalsIgnoreCase2 && obj.length() != 3) || (equalsIgnoreCase2 && obj.length() != 4)) {
                        C0535I5.m(getActivity(), false, "Enter valid CVV", getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        this.cvvNo.requestFocus();
                        this.c++;
                    }
                }
            }
        }
        if (this.c == 0) {
            Objects.toString(this.cardNumber.getText());
            Objects.toString(this.nameOnCard.getText());
            this.cvvNo.getText().toString();
            C1480xl xlVar = C1480xl.f7038a;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Do("MOBILE", "9999999999"));
            arrayList.add(new Do("EMAIL", "abc@xyz.com"));
            arrayList.add(new Do("PAYMENT_MODE", "card"));
            arrayList.add(new Do("SAVED_CARD", "false"));
            arrayList.add(new Do("CARD_NUMBER", this.cardNumber.getText().toString().replace(" ", "")));
            arrayList.add(new Do("NAME_ON_CARD", this.nameOnCard.getText().toString()));
            arrayList.add(new Do("EXPIRY_MONTH", this.f4763c));
            arrayList.add(new Do("EXPIRY_YEAR", this.f4764d));
            arrayList.add(new Do("CVV", this.cvvNo.getText().toString()));
            arrayList.add(new Do("SAVE_CARD", "false"));
            xlVar.g(this, arrayList);
        }
    }

    @OnClick({2131362521})
    public void onClickValidilityCard() {
        b bVar = new b();
        Rl rl = new Rl();
        rl.a = bVar;
        rl.show(getFragmentManager(), "MonthYearPickerDialog");
    }

    @OnClick({2131363054})
    public void onClickWallet() {
        g();
        this.payNowButton.setVisibility(8);
        C1480xl xlVar = C1480xl.f7038a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Do("PAYMENT_MODE", "wallet"));
        arrayList.add(new Do("MOBILE", Bw.e(getContext()).k()));
        arrayList.add(new Do("EMAIL", "abc@xyz.com"));
        xlVar.g(this, arrayList);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        View inflate = layoutInflater.inflate(R.layout.activity_make_payment_mpp, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        Bundle arguments = getArguments();
        String string = arguments.getString("netbanking");
        String string2 = arguments.getString("enabled_cards");
        if (arguments.getString("netbanking_flag") == null || !arguments.getString("netbanking_flag").toString().equalsIgnoreCase("true")) {
            z = false;
        } else {
            z = true;
        }
        if (arguments.getString("card_flag") == null || !arguments.getString("card_flag").toString().equalsIgnoreCase("true")) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (arguments.getString("wallet_flag") == null || !arguments.getString("wallet_flag").toString().equalsIgnoreCase("true")) {
            z3 = false;
        } else {
            z3 = true;
        }
        C1480xl xlVar = C1480xl.f7038a;
        if (xlVar.f7042a.getBankId() == 101) {
            this.pgOptionWalletTv.setText(getString(R.string.payment_option_mobikwik));
        } else {
            this.pgOptionWalletTv.setText(getString(R.string.payment_option_payumpp));
        }
        if (z3) {
            this.paymentOptionWallet.setVisibility(0);
        }
        if (!z) {
            this.paymentOptionNetbanking.setVisibility(8);
        }
        if (!z2) {
            this.paymentOptionCards.setVisibility(8);
        }
        this.totalFare.setText(getString(R.string.ticket_fare) + getString(R.string.colon) + getString(R.string.rupees) + xlVar.f7042a.getAmount());
        if (xlVar.f7042a.getBankId() != 101) {
            xlVar.f7042a.getBankId();
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.paymentoptionbottom, googleAdParamDTO);
        int i = Calendar.getInstance().get(1) - 2000;
        ArrayList arrayList = new ArrayList();
        for (int i2 = i; i2 < i + 30; i2++) {
            arrayList.add("20" + i2);
        }
        if (string != null) {
            try {
                if (string.trim().length() != 0) {
                    JSONObject jSONObject = new JSONObject(string);
                    this.f4762a = new ArrayList<>();
                    for (int i3 = 0; i3 < jSONObject.length(); i3++) {
                        this.f4762a.add(new C0489Dv(jSONObject.getString(jSONObject.names().get(i3).toString()), jSONObject.names().get(i3).toString()));
                    }
                    Collections.sort(this.f4762a, new C0738Wj());
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        if (!(string2 == null || string2.trim().length() == 0)) {
            JSONArray jSONArray = new JSONArray(string2);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String str = (String) jSONArray.get(i4);
            }
        }
        this.cardNumber.addTextChangedListener(new T(this));
        this.cvvNo.setOnFocusChangeListener(new U(this));
        return inflate;
    }

    public final Fragment a() {
        return this;
    }

    public final void b() {
    }

    public final void c(String str) {
    }
}
