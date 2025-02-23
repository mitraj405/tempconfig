package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.material.textfield.TextInputLayout;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.PgWebViewActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.payment.CashOnDeliveryActivity;
import cris.org.in.prs.ima.R;
import defpackage.C1421u9;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class MakePaymentNewFragment extends Fragment implements C1245lp {
    public static boolean d = false;
    public static boolean e = false;
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4766a;

    /* renamed from: a  reason: collision with other field name */
    public View f4767a;

    /* renamed from: a  reason: collision with other field name */
    public LinearLayout f4768a;

    /* renamed from: a  reason: collision with other field name */
    public RadioButton f4769a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f4770a;

    /* renamed from: a  reason: collision with other field name */
    public C0822cf f4771a;

    /* renamed from: a  reason: collision with other field name */
    public C0824ch f4772a;

    /* renamed from: a  reason: collision with other field name */
    public GoogleAdParamDTO f4773a;

    /* renamed from: a  reason: collision with other field name */
    public C1087eb f4774a = null;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<C1187j2> f4775a;

    /* renamed from: a  reason: collision with other field name */
    public LinkedHashMap f4776a = null;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashSet f4777a;

    /* renamed from: a  reason: collision with other field name */
    public C1432ux f4778a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4779a;
    @BindView(2131361862)
    LinearLayout accural_msg_ll;
    @BindView(2131362337)
    RelativeLayout airPayMppRl;
    @BindView(2131362338)
    RelativeLayout amexMppRl;
    @BindView(2131364291)
    TextView amountToDeducted;
    @BindView(2131361946)
    LinearLayout amountToDeductedLl;
    public View b;

    /* renamed from: b  reason: collision with other field name */
    public LinearLayout f4780b;

    /* renamed from: b  reason: collision with other field name */
    public RadioButton f4781b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f4782b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<C1187j2> f4783b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4784b;
    @BindView(2131362339)
    LinearLayout bajajEmiLl;
    @BindView(2131362340)
    LinearLayout bhanixLl;
    @BindView(2131363711)
    RelativeLayout bhimUpiLl;
    @BindView(2131362884)
    ImageView bhimUpiPgArrow;
    @BindView(2131363007)
    LinearLayout bhimUpiSection;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public View f4785c;

    /* renamed from: c  reason: collision with other field name */
    public LinearLayout f4786c;

    /* renamed from: c  reason: collision with other field name */
    public RadioButton f4787c;

    /* renamed from: c  reason: collision with other field name */
    public TextView f4788c;

    /* renamed from: c  reason: collision with other field name */
    public String f4789c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<C1187j2> f4790c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4791c;
    @BindView(2131362341)
    RelativeLayout cashFreeRl;
    @BindView(2131362274)
    ImageView codArrow;
    @BindView(2131362342)
    LinearLayout codLayout;
    @BindView(2131362275)
    RelativeLayout codLayoutHead;
    @BindView(2131364330)
    TextView codOfferTv;

    /* renamed from: d  reason: collision with other field name */
    public View f4792d;

    /* renamed from: d  reason: collision with other field name */
    public LinearLayout f4793d;

    /* renamed from: d  reason: collision with other field name */
    public RadioButton f4794d;

    /* renamed from: d  reason: collision with other field name */
    public TextView f4795d;

    /* renamed from: d  reason: collision with other field name */
    public String f4796d;

    /* renamed from: d  reason: collision with other field name */
    public ArrayList<C1398sx> f4797d;

    /* renamed from: e  reason: collision with other field name */
    public View f4798e;

    /* renamed from: e  reason: collision with other field name */
    public LinearLayout f4799e;

    /* renamed from: e  reason: collision with other field name */
    public RadioButton f4800e;

    /* renamed from: e  reason: collision with other field name */
    public TextView f4801e;

    /* renamed from: e  reason: collision with other field name */
    public String f4802e;

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<String> f4803e;
    @BindView(2131364399)
    TextView eWalletTxnChrg;
    @BindView(2131362344)
    RelativeLayout easeBuzzRl;
    @BindView(2131362489)
    ImageView emiArrow;
    @BindView(2131362491)
    LinearLayout emiGroup;
    @BindView(2131362490)
    RelativeLayout emiLayoutHead;
    @BindView(2131362345)
    LinearLayout epayLaterLayout;
    @BindView(2131362604)
    TextView ewalletAvlBalance;
    @BindView(2131362863)
    EditText ewalletOtp;
    @BindView(2131364397)
    TextView ewalletOtpNote;
    @BindView(2131362867)
    TextView ewalletSendOtp;
    @BindView(2131362615)
    EditText ewalletTxnPassword;
    @BindView(2131362616)
    TextInputLayout ewalletTxnPasswordLL;
    @BindView(2131362619)
    TextView ewalletUserId;
    @BindView(2131364599)
    TextView ewalletWebServiceMsg;
    public View f;

    /* renamed from: f  reason: collision with other field name */
    public LinearLayout f4804f;

    /* renamed from: f  reason: collision with other field name */
    public RadioButton f4805f;

    /* renamed from: f  reason: collision with other field name */
    public String f4806f;
    @BindView(2131364756)
    TextView fareAmount;
    public String g;
    @BindView(2131362346)
    RelativeLayout hdfcMppRl;
    @BindView(2131362793)
    ImageView iPayPaymentArrow;
    @BindView(2131362796)
    LinearLayout iPayPaymentLL;
    @BindView(2131362795)
    RelativeLayout iPayPaymentLl;
    @BindView(2131362349)
    RelativeLayout iPayRl;
    @BindView(2131362347)
    LinearLayout iciciMppLl;
    @BindView(2131364432)
    TextView iciciMppOfferTv;
    @BindView(2131362348)
    RelativeLayout indusIndMppRl;
    @BindView(2131362849)
    LinearLayout insufficientBalanceLl;
    @BindView(2131364441)
    TextView irctcEwalletHeading;
    @BindView(2131363119)
    View loyaltyLayoutView;
    @BindView(2131363170)
    AdManagerAdView makePaymentBottom;
    @BindView(2131362350)
    LinearLayout mobiMppLl;
    @BindView(2131363388)
    ImageView otherPaymentArrow;
    @BindView(2131363390)
    RelativeLayout otherPaymentHeadRl;
    @BindView(2131363391)
    LinearLayout otherPaymentLL;
    @BindView(2131362351)
    RelativeLayout payGlocalRl;
    @BindView(2131363468)
    LinearLayout payLaterGroup;
    @BindView(2131362352)
    RelativeLayout payTenRl;
    @BindView(2131363535)
    TextView paymentAmountTv;
    @BindView(2131362353)
    LinearLayout paytmLl;
    @BindView(2131362354)
    LinearLayout paytmPayLaterLl;
    @BindView(2131362355)
    RelativeLayout paytmUpiRl;
    @BindView(2131362356)
    LinearLayout payuMppLl;
    @BindView(2131363755)
    RelativeLayout phonePeOfferBalloon;
    @BindView(2131362357)
    RelativeLayout phonePeRl;
    @BindView(2131362358)
    LinearLayout pineLabLl;
    @BindView(2131362612)
    RelativeLayout proceedEwalletPayment;
    @BindView(2131364891)
    RelativeLayout proceedWalletPayment;
    @BindView(2131362359)
    LinearLayout razorPayLl;
    @BindView(2131362360)
    RelativeLayout razorPayUpiRl;
    @BindView(2131363600)
    LinearLayout redeemLoyaltyLayout;
    @BindView(2131363601)
    RelativeLayout redeemLoyaltyPaymentLayout;
    @BindView(2131364563)
    TextView remainingBalance;
    @BindView(2131363672)
    LinearLayout remainingBalanceLayout;
    @BindView(2131362361)
    RelativeLayout safexPayRl;
    @BindView(2131362362)
    RelativeLayout sbiePayRl;
    @BindView(2131363881)
    RadioButton selectAirpayMpp;
    @BindView(2131363884)
    RadioButton selectAmexMpp;
    @BindView(2131363885)
    RadioButton selectBajajEmi;
    @BindView(2131363887)
    RadioButton selectBhanix;
    @BindView(2131363890)
    RadioButton selectCashFree;
    @BindView(2131363891)
    RadioButton selectCod;
    @BindView(2131363893)
    RadioButton selectEaseBuzz;
    @BindView(2131363894)
    RadioButton selectEpayLater;
    @BindView(2131363897)
    RadioButton selectHdfcMpp;
    @BindView(2131363900)
    RadioButton selectIPay;
    @BindView(2131363898)
    RadioButton selectIciciMpp;
    @BindView(2131363899)
    RadioButton selectIndusIndMpp;
    @BindView(2131363906)
    RadioButton selectMobiMpp;
    @BindView(2131363909)
    RadioButton selectPayGlocal;
    @BindView(2131363910)
    RadioButton selectPayTen;
    @BindView(2131363911)
    RadioButton selectPaytm;
    @BindView(2131363912)
    RadioButton selectPaytmPaylater;
    @BindView(2131363913)
    RadioButton selectPaytmUpi;
    @BindView(2131363915)
    RadioButton selectPayuMpp;
    @BindView(2131363061)
    LinearLayout selectPgMethodHead;
    @BindView(2131363917)
    RadioButton selectPhonePe;
    @BindView(2131363918)
    RadioButton selectPineLab;
    @BindView(2131363921)
    RadioButton selectRazorPay;
    @BindView(2131363922)
    RadioButton selectRazorpayUpi;
    @BindView(2131363923)
    RadioButton selectSafexPay;
    @BindView(2131363925)
    RadioButton selectSbiePay;
    @BindView(2131363927)
    RadioButton selectStashFin;
    @BindView(2131363930)
    RadioButton selectTestBank;
    @BindView(2131363831)
    RelativeLayout selectWallet;
    @BindView(2131363932)
    ImageView selectWalletImage;
    @BindView(2131362363)
    LinearLayout stashFinLl;
    @BindView(2131362365)
    LinearLayout testBankLl;
    @BindView(2131364680)
    TextView totalPointBalance;
    @BindView(2131364260)
    TextView tv_accural_msg;
    @BindView(2131364704)
    TextView txnChargesTv;
    @BindView(2131364714)
    TextView userName;
    @BindView(2131364797)
    LinearLayout userNameLl;
    @BindView(2131364861)
    LinearLayout walletContainer1;
    @BindView(2131364862)
    LinearLayout walletContainer10;
    @BindView(2131364863)
    LinearLayout walletContainer11;
    @BindView(2131364865)
    LinearLayout walletContainer12;
    @BindView(2131364866)
    LinearLayout walletContainer13;
    @BindView(2131364868)
    LinearLayout walletContainer14;
    @BindView(2131364877)
    LinearLayout walletContainer2;
    @BindView(2131364879)
    LinearLayout walletContainer3;
    @BindView(2131364881)
    LinearLayout walletContainer4;
    @BindView(2131364882)
    LinearLayout walletContainer5;
    @BindView(2131364884)
    LinearLayout walletContainer6;
    @BindView(2131364885)
    LinearLayout walletContainer7;
    @BindView(2131364887)
    LinearLayout walletContainer8;
    @BindView(2131364888)
    LinearLayout walletContainer9;
    @BindView(2131364892)
    LinearLayout walletListLl;
    @BindView(2131364893)
    ImageView walletLogo;
    @BindView(2131364894)
    EditText walletMobno;
    @BindView(2131364895)
    EditText walletOtp;
    @BindView(2131364896)
    TextView walletSendOtp;
    @BindView(2131364897)
    TextView walletTextView;
    @BindView(2131364898)
    TextView walletTxnChargeCommon;

    public class b extends C1421u9.a {
        public b(EditText editText) {
            super(editText);
        }

        public final void a() {
            MakePaymentNewFragment makePaymentNewFragment = MakePaymentNewFragment.this;
            int i = 0;
            if (makePaymentNewFragment.ewalletTxnPassword.getInputType() == 145) {
                makePaymentNewFragment.ewalletTxnPassword.setInputType(129);
                EditText editText = makePaymentNewFragment.ewalletTxnPassword;
                editText.setSelection(editText.getText().length());
                makePaymentNewFragment.ewalletTxnPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.show, 0);
                Drawable[] compoundDrawables = makePaymentNewFragment.ewalletTxnPassword.getCompoundDrawables();
                int length = compoundDrawables.length;
                while (i < length) {
                    Drawable drawable = compoundDrawables[i];
                    if (drawable != null) {
                        drawable.setColorFilter(new PorterDuffColorFilter(makePaymentNewFragment.getActivity().getApplicationContext().getResources().getColor(R.color.lightdark), PorterDuff.Mode.SRC_IN));
                    }
                    i++;
                }
                return;
            }
            makePaymentNewFragment.ewalletTxnPassword.setInputType(145);
            EditText editText2 = makePaymentNewFragment.ewalletTxnPassword;
            editText2.setSelection(editText2.getText().length());
            makePaymentNewFragment.ewalletTxnPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.show, 0);
            Drawable[] compoundDrawables2 = makePaymentNewFragment.ewalletTxnPassword.getCompoundDrawables();
            int length2 = compoundDrawables2.length;
            while (i < length2) {
                Drawable drawable2 = compoundDrawables2[i];
                if (drawable2 != null) {
                    drawable2.setColorFilter(new PorterDuffColorFilter(makePaymentNewFragment.getActivity().getApplicationContext().getResources().getColor(R.color.dark), PorterDuff.Mode.SRC_IN));
                }
                i++;
            }
        }
    }

    static {
        C1354qp.R(MakePaymentNewFragment.class);
    }

    public MakePaymentNewFragment() {
        new LinkedHashMap();
        this.f4802e = "";
        this.f4768a = null;
        this.f4769a = null;
        this.f4780b = null;
        this.f4781b = null;
        this.f4786c = null;
        this.f4787c = null;
        this.f4793d = null;
        this.f4794d = null;
        this.f4799e = null;
        this.f4800e = null;
        this.f4804f = null;
        this.f4805f = null;
        this.f4777a = new LinkedHashSet();
        this.f4778a = null;
        this.f4806f = "";
        this.g = "";
        this.f4772a = null;
        this.f4766a = null;
        this.f4779a = false;
        this.f4784b = false;
        this.f4791c = false;
    }

    public static String l(String str) {
        return lf.j("Please enter your registered ", str, " mobile number.\nAn OTP will be sent to your mobile number");
    }

    public static Spanned u(C1187j2 j2Var) {
        j2Var.getBankName();
        j2Var.getBankId();
        j2Var.getPaymentMode();
        j2Var.isEnableFlag();
        if (!j2Var.isEnableFlag() || j2Var.getOfferMsg() == null || j2Var.getOfferUrl() == null) {
            return null;
        }
        String offerUrl = j2Var.getOfferUrl();
        return (Spanned) TextUtils.concat(new CharSequence[]{Html.fromHtml("<a href=\"" + offerUrl + "\">Offer</a>")});
    }

    public final void b() {
        String str;
        C1480xl xlVar = C1480xl.f7038a;
        if (xlVar.f7042a.getErrorMsg() != null) {
            str = xlVar.f7042a.getErrorMsg();
        } else {
            str = "UNKNOWN_FAILURE";
        }
        C0535I5.W(str, false, this.f4771a, (String) null, (String) null);
    }

    public final void e() {
        C1480xl xlVar = C1480xl.f7038a;
        if (xlVar.f7042a.getErrorMsg() == null) {
            this.f4791c = true;
            C0535I5.W("PROCEED_TO_PAY", true, this.f4771a, xlVar.f7042a.getJuspayLoadDTO().getOrderDetails(), xlVar.f7042a.getJuspayLoadDTO().getSignature());
        }
    }

    public final void f() {
        this.txnChargesTv.setVisibility(8);
        this.paymentAmountTv.setVisibility(8);
        RadioButton radioButton = this.selectPaytm;
        if (radioButton != null) {
            radioButton.setChecked(false);
        }
        RadioButton radioButton2 = this.selectIPay;
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
        }
        RadioButton radioButton3 = this.selectAmexMpp;
        if (radioButton3 != null) {
            radioButton3.setChecked(false);
        }
        RadioButton radioButton4 = this.selectIndusIndMpp;
        if (radioButton4 != null) {
            radioButton4.setChecked(false);
        }
        RadioButton radioButton5 = this.selectPayGlocal;
        if (radioButton5 != null) {
            radioButton5.setChecked(false);
        }
        RadioButton radioButton6 = this.selectSafexPay;
        if (radioButton6 != null) {
            radioButton6.setChecked(false);
        }
        RadioButton radioButton7 = this.selectSbiePay;
        if (radioButton7 != null) {
            radioButton7.setChecked(false);
        }
        RadioButton radioButton8 = this.selectCashFree;
        if (radioButton8 != null) {
            radioButton8.setChecked(false);
        }
        RadioButton radioButton9 = this.selectPayTen;
        if (radioButton9 != null) {
            radioButton9.setChecked(false);
        }
        RadioButton radioButton10 = this.selectEaseBuzz;
        if (radioButton10 != null) {
            radioButton10.setChecked(false);
        }
        RadioButton radioButton11 = this.selectPaytmUpi;
        if (radioButton11 != null) {
            radioButton11.setChecked(false);
        }
        RadioButton radioButton12 = this.selectRazorpayUpi;
        if (radioButton12 != null) {
            radioButton12.setChecked(false);
        }
        RadioButton radioButton13 = this.selectIciciMpp;
        if (radioButton13 != null) {
            radioButton13.setChecked(false);
        }
        RadioButton radioButton14 = this.selectAirpayMpp;
        if (radioButton14 != null) {
            radioButton14.setChecked(false);
        }
        RadioButton radioButton15 = this.selectHdfcMpp;
        if (radioButton15 != null) {
            radioButton15.setChecked(false);
        }
        RadioButton radioButton16 = this.selectRazorPay;
        if (radioButton16 != null) {
            radioButton16.setChecked(false);
        }
        RadioButton radioButton17 = this.selectPhonePe;
        if (radioButton17 != null) {
            radioButton17.setChecked(false);
        }
        RadioButton radioButton18 = this.selectMobiMpp;
        if (radioButton18 != null) {
            radioButton18.setChecked(false);
        }
        RadioButton radioButton19 = this.selectPayuMpp;
        if (radioButton19 != null) {
            radioButton19.setChecked(false);
        }
        RadioButton radioButton20 = this.selectCod;
        if (radioButton20 != null) {
            radioButton20.setChecked(false);
        }
        RadioButton radioButton21 = this.selectEpayLater;
        if (radioButton21 != null) {
            radioButton21.setChecked(false);
        }
        RadioButton radioButton22 = this.selectStashFin;
        if (radioButton22 != null) {
            radioButton22.setChecked(false);
        }
        RadioButton radioButton23 = this.selectPaytmPaylater;
        if (radioButton23 != null) {
            radioButton23.setChecked(false);
        }
        RadioButton radioButton24 = this.selectPineLab;
        if (radioButton24 != null) {
            radioButton24.setChecked(false);
        }
        RadioButton radioButton25 = this.selectBajajEmi;
        if (radioButton25 != null) {
            radioButton25.setChecked(false);
        }
        RadioButton radioButton26 = this.selectBhanix;
        if (radioButton26 != null) {
            radioButton26.setChecked(false);
        }
        RadioButton radioButton27 = this.selectTestBank;
        if (radioButton27 != null) {
            radioButton27.setChecked(false);
        }
        RadioButton radioButton28 = this.f4781b;
        if (radioButton28 != null) {
            radioButton28.setChecked(false);
        }
        RadioButton radioButton29 = this.f4800e;
        if (radioButton29 != null) {
            radioButton29.setChecked(false);
        }
        if (this.f4769a != null) {
            this.proceedWalletPayment.setVisibility(8);
            this.f4769a.setChecked(false);
        }
        RadioButton radioButton30 = this.f4787c;
        if (radioButton30 != null) {
            radioButton30.setChecked(false);
        }
        RadioButton radioButton31 = this.f4805f;
        if (radioButton31 != null) {
            radioButton31.setChecked(false);
        }
        RadioButton radioButton32 = this.f4794d;
        if (radioButton32 != null) {
            radioButton32.setChecked(false);
        }
    }

    public final void g(int i) {
        this.f4802e = "";
        C1480xl.f7038a.f7039a = 0;
        if (!k(C1058d.h(this.c))) {
            Spanned fromHtml = Html.fromHtml("");
            String j = j(C1058d.h(this.c));
            if (j != null) {
                fromHtml = Html.fromHtml(j);
            }
            TextView textView = new TextView(getContext());
            textView.setText(fromHtml);
            textView.setGravity(3);
            textView.setPadding(50, 10, 50, 20);
            textView.setTextSize(14.0f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            C0535I5.q(getActivity(), textView, getString(R.string.ok)).show();
            f();
            return;
        }
        f();
        this.txnChargesTv.setText(n(i));
        if (i == 1000 || i == 76 || i == 74 || i == 91) {
            this.txnChargesTv.setVisibility(8);
            this.paymentAmountTv.setVisibility(8);
        } else {
            this.paymentAmountTv.setVisibility(0);
            this.txnChargesTv.setVisibility(0);
        }
        if (i == 99) {
            this.selectTestBank.setChecked(true);
        } else if (i == 77) {
            this.selectPaytm.setChecked(true);
        } else if (i == 118) {
            this.selectIPay.setChecked(true);
        } else if (i == 124) {
            this.selectAmexMpp.setChecked(true);
        } else if (i == 125) {
            this.selectIndusIndMpp.setChecked(true);
        } else if (i == 140) {
            this.selectPayGlocal.setChecked(true);
        } else if (i == 138) {
            this.selectSafexPay.setChecked(true);
        } else if (i == 142) {
            this.selectSbiePay.setChecked(true);
        } else if (i == 147) {
            this.selectCashFree.setChecked(true);
        } else if (i == 152) {
            this.selectPayTen.setChecked(true);
        } else if (i == 144) {
            this.selectEaseBuzz.setChecked(true);
        } else if (i == 119) {
            this.selectPaytmUpi.setChecked(true);
        } else if (i == 141) {
            this.selectRazorpayUpi.setChecked(true);
        } else if (i == 120) {
            this.selectIciciMpp.setChecked(true);
        } else if (i == 122) {
            this.selectHdfcMpp.setChecked(true);
        } else if (i == 121) {
            this.selectAirpayMpp.setChecked(true);
        } else if (i == 106) {
            this.selectRazorPay.setChecked(true);
        } else if (i == 111) {
            this.selectPhonePe.setChecked(true);
        } else if (i == 101) {
            this.selectMobiMpp.setChecked(true);
        } else if (i == 108) {
            this.selectPayuMpp.setChecked(true);
        } else if (i == 95) {
            this.selectCod.setChecked(true);
        } else if (i == 127) {
            this.selectEpayLater.setChecked(true);
        } else if (i == 131) {
            this.selectStashFin.setChecked(true);
        } else if (i == 135) {
            this.selectPaytmPaylater.setChecked(true);
        } else if (i == 133) {
            this.selectPineLab.setChecked(true);
        } else if (i == 148) {
            this.selectBajajEmi.setChecked(true);
        } else if (i == 139) {
            this.selectBhanix.setChecked(true);
        }
        if (i == 1000) {
            if (this.f4774a.getTxnPwdFlag().equalsIgnoreCase("true")) {
                this.ewalletTxnPasswordLL.setVisibility(8);
            }
            this.ewalletSendOtp.setText(getString(R.string.send_otp));
            this.ewalletOtp.setInputType(130);
            this.ewalletUserId.setText(Bw.e(getContext()).h());
            TextView textView2 = this.ewalletAvlBalance;
            textView2.setText(getString(R.string.available_balance_in_wallet) + " " + this.f4774a.getCurrentBalance());
            this.eWalletTxnChrg.setText(m(C1058d.h(this.c)));
            TextView textView3 = this.f4782b;
            if (textView3 != null) {
                textView3.setText(m(C1058d.h(this.c)));
            }
            if (d) {
                this.paymentAmountTv.setVisibility(8);
            } else {
                this.paymentAmountTv.setVisibility(0);
            }
            C0535I5.I(getActivity());
            this.proceedEwalletPayment.setVisibility(0);
            RadioButton radioButton = this.f4781b;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else if (i == 76) {
            onClickWallet();
            this.walletTextView.setText(l("Pay U"));
            this.walletLogo.setImageResource(R.drawable.ic_payumoney);
            this.proceedWalletPayment.setVisibility(0);
            this.walletTxnChargeCommon.setText(m(i));
            RadioButton radioButton2 = this.f4787c;
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
        } else if (i == 74) {
            onClickWallet();
            this.walletTextView.setText(l("Mobikwik"));
            this.walletLogo.setImageResource(R.drawable.mobikwik_logo);
            this.proceedWalletPayment.setVisibility(0);
            this.walletTxnChargeCommon.setText(m(i));
            RadioButton radioButton3 = this.f4769a;
            if (radioButton3 != null) {
                radioButton3.setChecked(true);
            }
        } else if (i == 91) {
            onClickWallet();
            this.walletTextView.setText(l("airtel money"));
            this.walletLogo.setImageResource(R.drawable.ic_logo_airtel_money);
            this.proceedWalletPayment.setVisibility(0);
            this.walletTxnChargeCommon.setText(m(i));
            RadioButton radioButton4 = this.f4805f;
            if (radioButton4 != null) {
                radioButton4.setChecked(true);
            }
        } else if (i == 104) {
            this.f4794d.setChecked(true);
        }
        if (!d && i == 1000) {
            onOTPSendeWallet();
        }
        this.walletSendOtp.setClickable(true);
        this.f4802e = "";
    }

    public final void h() {
        if (this.iPayPaymentLL.getVisibility() == 8) {
            this.g = null;
            o();
            this.iPayPaymentLL.setVisibility(0);
            this.iPayPaymentArrow.setImageResource(R.drawable.spinner_upwards);
            return;
        }
        o();
    }

    public final C1187j2 i(int i) {
        ArrayList<C1187j2> arrayList = this.f4775a;
        C1187j2 j2Var = null;
        if (arrayList != null) {
            Iterator<C1187j2> it = arrayList.iterator();
            while (it.hasNext()) {
                C1187j2 next = it.next();
                if (next.getBankId() == i) {
                    j2Var = next;
                }
            }
        }
        return j2Var;
    }

    public final String j(int i) {
        ArrayList<C1187j2> arrayList = this.f4775a;
        String str = "This option is currently disabled";
        if (arrayList != null) {
            Iterator<C1187j2> it = arrayList.iterator();
            while (it.hasNext()) {
                C1187j2 next = it.next();
                next.getBankName();
                next.getBankId();
                next.getPaymentMode();
                next.isEnableFlag();
                if (next.getBankId() == i) {
                    str = next.getDisableReason();
                }
            }
        }
        return str;
    }

    public final boolean k(int i) {
        ArrayList<C1187j2> arrayList = this.f4775a;
        boolean z = false;
        if (arrayList != null) {
            Iterator<C1187j2> it = arrayList.iterator();
            while (it.hasNext()) {
                C1187j2 next = it.next();
                next.getBankName();
                next.getBankId();
                next.getPaymentMode();
                next.isEnableFlag();
                if (next.getBankId() == i) {
                    z = next.isEnableFlag();
                }
            }
        }
        return z;
    }

    public final String m(int i) {
        ArrayList<C1187j2> arrayList = this.f4775a;
        String str = "PG charge information NOT FOUND";
        if (arrayList != null) {
            Iterator<C1187j2> it = arrayList.iterator();
            while (it.hasNext()) {
                C1187j2 next = it.next();
                next.getBankName();
                next.getBankId();
                next.getPaymentMode();
                next.isEnableFlag();
                if (next.getBankId() == i) {
                    str = next.getMessage();
                    if (!next.isEnableFlag() && next.getBankId() != 1000) {
                        str = "";
                    }
                }
            }
        }
        return str;
    }

    public final String n(int i) {
        String m = m(i);
        if (i(i) == null || !i(i).isEnableFlag() || i(i).getOfferUrl() == null) {
            return m;
        }
        StringBuilder n = lf.n(m, "\n");
        n.append(getString(R.string.offer_tnc));
        return n.toString();
    }

    public final void o() {
        f();
        this.bhimUpiSection.setVisibility(8);
        this.payLaterGroup.setVisibility(8);
        this.iPayPaymentLL.setVisibility(8);
        this.otherPaymentLL.setVisibility(8);
        this.walletListLl.setVisibility(8);
        this.emiGroup.setVisibility(8);
        this.bhimUpiPgArrow.setImageResource(R.drawable.spinner_downwards);
        this.codArrow.setImageResource(R.drawable.spinner_downwards);
        this.iPayPaymentArrow.setImageResource(R.drawable.spinner_downwards);
        this.otherPaymentArrow.setImageResource(R.drawable.spinner_downwards);
        this.selectWalletImage.setImageResource(R.drawable.spinner_downwards);
        this.emiArrow.setImageResource(R.drawable.spinner_downwards);
    }

    @OnClick({2131362223})
    public void onAirpayMppClick() {
        this.c = 17;
        g(121);
    }

    @OnClick({2131362225})
    public void onAmexMppClick() {
        this.c = 19;
        g(124);
    }

    @OnClick({2131362226})
    public void onBajajEmiClick() {
        this.c = 40;
        g(148);
    }

    @OnClick({2131362227})
    public void onBhanixCasheClick() {
        this.c = 31;
        g(139);
    }

    @OnClick({2131363711})
    public void onBhimUpiClick() {
        if (this.bhimUpiSection.getVisibility() == 8) {
            o();
            this.bhimUpiSection.setVisibility(0);
            this.bhimUpiPgArrow.setImageResource(R.drawable.spinner_upwards);
            return;
        }
        o();
    }

    @OnClick({2131362275})
    public void onCODClick() {
        if (this.payLaterGroup.getVisibility() == 8) {
            o();
            this.payLaterGroup.setVisibility(0);
            this.codArrow.setImageResource(R.drawable.spinner_upwards);
            return;
        }
        o();
    }

    @OnClick({2131362228})
    public void onCashFreeClick() {
        this.c = 36;
        g(147);
    }

    @OnClick({2131362620})
    public void onClickEWalletView(View view) {
        p();
    }

    public final void onClickWallet() {
        this.walletSendOtp.setText(getString(R.string.send_otp));
        this.walletMobno.setText(Bw.e(getContext()).k());
        this.walletMobno.setEnabled(true);
        this.walletOtp.setEnabled(false);
        this.walletOtp.setInputType(130);
        EditText editText = this.walletMobno;
        FragmentActivity activity = getActivity();
        AlertDialog alertDialog = C0535I5.f3619a;
        editText.addTextChangedListener(new C0479D5(activity, 10));
        this.walletOtp.addTextChangedListener(new a());
    }

    @OnClick({2131364899})
    public void onClickWalletView(View view) {
        p();
    }

    @OnClick({2131362229})
    public void onCodClick() {
        this.c = 8;
        g(95);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0199 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0271 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x02e3 A[Catch:{ Exception -> 0x02ec }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, android.os.Bundle r10) {
        /*
            r7 = this;
            r9 = 2131558452(0x7f0d0034, float:1.874222E38)
            r10 = 0
            android.view.View r8 = r8.inflate(r9, r10)
            butterknife.ButterKnife.bind((java.lang.Object) r7, (android.view.View) r8)     // Catch:{ Exception -> 0x02ec }
            android.os.Bundle r9 = r7.getArguments()     // Catch:{ Exception -> 0x02ec }
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()     // Catch:{ Exception -> 0x02ec }
            android.view.View r1 = r7.getView()     // Catch:{ Exception -> 0x02ec }
            defpackage.C0535I5.H(r0, r1)     // Catch:{ Exception -> 0x02ec }
            defpackage.C0535I5.f3644g = r10     // Catch:{ Exception -> 0x02ec }
            defpackage.C0535I5.f3615a = r10     // Catch:{ Exception -> 0x02ec }
            android.app.ProgressDialog r0 = new android.app.ProgressDialog     // Catch:{ Exception -> 0x02ec }
            android.view.ContextThemeWrapper r1 = new android.view.ContextThemeWrapper     // Catch:{ Exception -> 0x02ec }
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()     // Catch:{ Exception -> 0x02ec }
            r3 = 2132017745(0x7f140251, float:1.9673777E38)
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x02ec }
            r0.<init>(r1)     // Catch:{ Exception -> 0x02ec }
            r7.f4766a = r0     // Catch:{ Exception -> 0x02ec }
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()     // Catch:{ Exception -> 0x02ec }
            java.lang.String r1 = "Loading..."
            java.lang.String r2 = "Please wait..."
            android.app.ProgressDialog r0 = android.app.ProgressDialog.show(r0, r1, r2)     // Catch:{ Exception -> 0x02ec }
            r7.f4766a = r0     // Catch:{ Exception -> 0x02ec }
            if (r9 == 0) goto L_0x02e8
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x02ec }
            r0.<init>()     // Catch:{ Exception -> 0x02ec }
            r7.f4776a = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "TotalFare"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x02ec }
            r7.f4789c = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "dmrcPaymentMode"
            boolean r0 = r9.getBoolean(r0)     // Catch:{ Exception -> 0x02ec }
            e = r0     // Catch:{ Exception -> 0x02ec }
            android.widget.TextView r0 = r7.fareAmount     // Catch:{ Exception -> 0x02ec }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ec }
            r1.<init>()     // Catch:{ Exception -> 0x02ec }
            r2 = 2131953645(0x7f1307ed, float:1.9543767E38)
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x02ec }
            r1.append(r2)     // Catch:{ Exception -> 0x02ec }
            java.lang.String r2 = r7.f4789c     // Catch:{ Exception -> 0x02ec }
            r1.append(r2)     // Catch:{ Exception -> 0x02ec }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02ec }
            r0.setText(r1)     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "ClientTxnId"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x02ec }
            r7.f4796d = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "BankDetailDto"
            java.io.Serializable r0 = r9.getSerializable(r0)     // Catch:{ Exception -> 0x02ec }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x02ec }
            r7.f4775a = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "purchaseLoyaltyPoint"
            boolean r0 = r9.getBoolean(r0)     // Catch:{ Exception -> 0x02ec }
            d = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "eWalletDto"
            java.io.Serializable r0 = r9.getSerializable(r0)     // Catch:{ Exception -> 0x02ec }
            eb r0 = (defpackage.C1087eb) r0     // Catch:{ Exception -> 0x02ec }
            r7.f4774a = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "SoftPaymentDtos"
            java.io.Serializable r0 = r9.getSerializable(r0)     // Catch:{ Exception -> 0x02ec }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ Exception -> 0x02ec }
            r7.f4797d = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "loyaltyBookingType"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x02ec }
            r7.f4806f = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = "JuspayLoadDTO"
            java.io.Serializable r0 = r9.getSerializable(r0)     // Catch:{ Exception -> 0x02ec }
            ch r0 = (defpackage.C0824ch) r0     // Catch:{ Exception -> 0x02ec }
            r7.f4772a = r0     // Catch:{ Exception -> 0x02ec }
            boolean r0 = d     // Catch:{ Exception -> 0x02ec }
            r1 = 8
            if (r0 == 0) goto L_0x00c0
            android.widget.LinearLayout r0 = r7.testBankLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
        L_0x00c0:
            java.lang.String r0 = r7.f4806f     // Catch:{ Exception -> 0x02ec }
            r2 = 0
            if (r0 == 0) goto L_0x00d8
            java.lang.String r3 = "redemption"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x02ec }
            if (r0 == 0) goto L_0x00d8
            android.widget.RelativeLayout r0 = r7.redeemLoyaltyPaymentLayout     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x02ec }
            android.view.View r0 = r7.loyaltyLayoutView     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x02ec }
            goto L_0x00e2
        L_0x00d8:
            android.widget.RelativeLayout r0 = r7.redeemLoyaltyPaymentLayout     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.view.View r0 = r7.loyaltyLayoutView     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
        L_0x00e2:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ec }
            r0.<init>()     // Catch:{ Exception -> 0x02ec }
            r7.f4803e = r0     // Catch:{ Exception -> 0x02ec }
            java.lang.String r0 = r7.f4806f     // Catch:{ Exception -> 0x02ec }
            java.lang.String r3 = "accural"
            if (r0 == 0) goto L_0x00fb
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x02ec }
            if (r0 == 0) goto L_0x00fb
            android.widget.LinearLayout r0 = r7.accural_msg_ll     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x02ec }
            goto L_0x0100
        L_0x00fb:
            android.widget.LinearLayout r0 = r7.accural_msg_ll     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
        L_0x0100:
            android.widget.LinearLayout r0 = r7.codLayout     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.testBankLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.paytmLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.mobiMppLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.razorPayLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.payuMppLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.phonePeRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.iPayRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.amexMppRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.indusIndMppRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.payGlocalRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.safexPayRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.sbiePayRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.cashFreeRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.payTenRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.easeBuzzRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.iciciMppLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.paytmUpiRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.razorPayUpiRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.hdfcMppRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.RelativeLayout r0 = r7.airPayMppRl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.epayLaterLayout     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.stashFinLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.paytmPayLaterLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.pineLabLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.bhanixLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r0 = r7.bajajEmiLl     // Catch:{ Exception -> 0x02ec }
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x02ec }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ec }
            r0.<init>()     // Catch:{ Exception -> 0x02ec }
            r7.f4783b = r0     // Catch:{ Exception -> 0x02ec }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ec }
            r0.<init>()     // Catch:{ Exception -> 0x02ec }
            r7.f4790c = r0     // Catch:{ Exception -> 0x02ec }
            java.util.ArrayList<j2> r0 = r7.f4775a     // Catch:{ Exception -> 0x02ec }
            if (r0 == 0) goto L_0x0269
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02ec }
        L_0x019d:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x02ec }
            if (r1 == 0) goto L_0x01fb
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x02ec }
            j2 r1 = (defpackage.C1187j2) r1     // Catch:{ Exception -> 0x02ec }
            int r4 = r1.getDisplaySection()     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashSet r5 = r7.f4777a
            r6 = 54
            if (r4 != r6) goto L_0x01cf
            java.lang.String r4 = r7.f4806f     // Catch:{ Exception -> 0x02ec }
            if (r4 == 0) goto L_0x01be
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x02ec }
            if (r4 == 0) goto L_0x01be
            goto L_0x019d
        L_0x01be:
            java.util.ArrayList<j2> r4 = r7.f4783b     // Catch:{ Exception -> 0x02ec }
            r4.add(r1)     // Catch:{ Exception -> 0x02ec }
            int r1 = r1.getDisplaySection()     // Catch:{ Exception -> 0x02ec }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x02ec }
            r5.add(r1)     // Catch:{ Exception -> 0x02ec }
            goto L_0x019d
        L_0x01cf:
            java.lang.String r4 = r7.f4806f     // Catch:{ Exception -> 0x02ec }
            if (r4 == 0) goto L_0x01ea
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x02ec }
            if (r4 == 0) goto L_0x01ea
            int r4 = r1.getBankId()     // Catch:{ Exception -> 0x02ec }
            r6 = 124(0x7c, float:1.74E-43)
            if (r4 == r6) goto L_0x019d
            int r4 = r1.getBankId()     // Catch:{ Exception -> 0x02ec }
            r6 = 101(0x65, float:1.42E-43)
            if (r4 != r6) goto L_0x01ea
            goto L_0x019d
        L_0x01ea:
            java.util.ArrayList<j2> r4 = r7.f4790c     // Catch:{ Exception -> 0x02ec }
            r4.add(r1)     // Catch:{ Exception -> 0x02ec }
            int r1 = r1.getDisplaySection()     // Catch:{ Exception -> 0x02ec }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x02ec }
            r5.add(r1)     // Catch:{ Exception -> 0x02ec }
            goto L_0x019d
        L_0x01fb:
            java.util.ArrayList<j2> r0 = r7.f4783b     // Catch:{ Exception -> 0x02ec }
            r0.size()     // Catch:{ Exception -> 0x02ec }
            java.util.ArrayList<j2> r0 = r7.f4790c     // Catch:{ Exception -> 0x02ec }
            r0.size()     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer1     // Catch:{ Exception -> 0x02ec }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer2     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer3     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer4     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer5     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer6     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer7     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer8     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer9     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer10     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer11     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer12     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer13     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
            java.util.LinkedHashMap r0 = r7.f4776a     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r1 = r7.walletContainer14     // Catch:{ Exception -> 0x02ec }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02ec }
        L_0x0269:
            xl r0 = defpackage.C1480xl.f7038a     // Catch:{ Exception -> 0x02ec }
            r0.f7046c = r10     // Catch:{ Exception -> 0x02ec }
            boolean r10 = r7.f4779a     // Catch:{ Exception -> 0x02ec }
            if (r10 != 0) goto L_0x02e3
            boolean r10 = d     // Catch:{ Exception -> 0x02ec }
            if (r10 != 0) goto L_0x029e
            boolean r10 = e     // Catch:{ Exception -> 0x02ec }
            if (r10 != 0) goto L_0x029e
            boolean r10 = defpackage.C0535I5.f3649j     // Catch:{ Exception -> 0x02ec }
            if (r10 == 0) goto L_0x029e
            ch r10 = r7.f4772a     // Catch:{ Exception -> 0x02ec }
            if (r10 == 0) goto L_0x029e
            cf r9 = new cf     // Catch:{ Exception -> 0x02ec }
            androidx.fragment.app.FragmentActivity r10 = r7.getActivity()     // Catch:{ Exception -> 0x02ec }
            r9.<init>(r10)     // Catch:{ Exception -> 0x02ec }
            r7.f4771a = r9     // Catch:{ Exception -> 0x02ec }
            bk r10 = new bk     // Catch:{ Exception -> 0x02ec }
            r10.<init>(r7)     // Catch:{ Exception -> 0x02ec }
            r9.setCallback(r10)     // Catch:{ Exception -> 0x02ec }
            java.util.ArrayList<j2> r9 = r7.f4775a     // Catch:{ Exception -> 0x02ec }
            java.lang.String r10 = r7.f4789c     // Catch:{ Exception -> 0x02ec }
            ch r0 = r7.f4772a     // Catch:{ Exception -> 0x02ec }
            r7.s(r9, r10, r0)     // Catch:{ Exception -> 0x02ec }
            goto L_0x02e8
        L_0x029e:
            android.app.ProgressDialog r10 = r7.f4766a     // Catch:{ Exception -> 0x02ec }
            r10.dismiss()     // Catch:{ Exception -> 0x02ec }
            boolean r10 = d     // Catch:{ Exception -> 0x02ec }
            if (r10 != 0) goto L_0x02b1
            java.lang.String r10 = "googleAd"
            java.io.Serializable r9 = r9.getSerializable(r10)     // Catch:{ Exception -> 0x02ec }
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r9 = (cris.org.in.ima.dto.oauth2.GoogleAdParamDTO) r9     // Catch:{ Exception -> 0x02ec }
            r7.f4773a = r9     // Catch:{ Exception -> 0x02ec }
        L_0x02b1:
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r9 = r7.f4773a     // Catch:{ Exception -> 0x02ec }
            if (r9 != 0) goto L_0x02bc
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r9 = new cris.org.in.ima.dto.oauth2.GoogleAdParamDTO     // Catch:{ Exception -> 0x02ec }
            r9.<init>()     // Catch:{ Exception -> 0x02ec }
            r7.f4773a = r9     // Catch:{ Exception -> 0x02ec }
        L_0x02bc:
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r9 = r7.f4773a     // Catch:{ Exception -> 0x02ec }
            java.lang.String r10 = defpackage.C1450w1.f7009a     // Catch:{ Exception -> 0x02ec }
            r9.setAge(r10)     // Catch:{ Exception -> 0x02ec }
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r9 = r7.f4773a     // Catch:{ Exception -> 0x02ec }
            java.lang.String r10 = defpackage.C1450w1.f7021c     // Catch:{ Exception -> 0x02ec }
            r9.setGender(r10)     // Catch:{ Exception -> 0x02ec }
            com.google.android.gms.ads.admanager.AdManagerAdView r9 = r7.makePaymentBottom     // Catch:{ Exception -> 0x02ec }
            r9.setVisibility(r2)     // Catch:{ Exception -> 0x02ec }
            android.widget.LinearLayout r9 = r7.selectPgMethodHead     // Catch:{ Exception -> 0x02ec }
            r9.setVisibility(r2)     // Catch:{ Exception -> 0x02ec }
            androidx.fragment.app.FragmentActivity r9 = r7.getActivity()     // Catch:{ Exception -> 0x02ec }
            com.google.android.gms.ads.admanager.AdManagerAdView r10 = r7.makePaymentBottom     // Catch:{ Exception -> 0x02ec }
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r7.f4773a     // Catch:{ Exception -> 0x02ec }
            defpackage.C0535I5.Y(r9, r10, r0)     // Catch:{ Exception -> 0x02ec }
            r7.r()     // Catch:{ Exception -> 0x02ec }
            goto L_0x02e8
        L_0x02e3:
            android.app.ProgressDialog r9 = r7.f4766a     // Catch:{ Exception -> 0x02ec }
            r9.dismiss()     // Catch:{ Exception -> 0x02ec }
        L_0x02e8:
            r9 = 1
            r7.f4779a = r9     // Catch:{ Exception -> 0x02ec }
            goto L_0x02f0
        L_0x02ec:
            r9 = move-exception
            r9.getMessage()
        L_0x02f0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.MakePaymentNewFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    @OnClick({2131362230})
    public void onEaseBuzzClick() {
        this.c = 33;
        g(144);
    }

    @OnClick({2131362490})
    public void onEmiClick() {
        if (this.emiGroup.getVisibility() == 8) {
            o();
            this.emiGroup.setVisibility(0);
            this.emiArrow.setImageResource(R.drawable.spinner_upwards);
            return;
        }
        o();
    }

    @OnClick({2131362231})
    public void onEpayLaterClick() {
        this.c = 21;
        g(127);
    }

    @OnClick({2131362233})
    public void onHdfcMppClick() {
        this.c = 18;
        g(122);
    }

    @OnClick({2131362234})
    public void onIciciMppClick() {
        this.c = 15;
        g(120);
    }

    @OnClick({2131362235})
    public void onIndusIndMppClick() {
        this.c = 20;
        g(125);
    }

    @OnClick({2131362236})
    public void onIpayClick() {
        this.c = 13;
        g(118);
    }

    @OnClick({2131363601})
    public void onLoyaltyBankClick(View view) {
        if (this.f4797d != null) {
            this.f4803e.clear();
            Iterator<C1398sx> it = this.f4797d.iterator();
            while (it.hasNext()) {
                String f2 = C1058d.f(String.valueOf(it.next().getLoyaltyBankId()));
                if (f2 != null) {
                    this.f4803e.add(f2);
                }
            }
        }
        this.g = C1058d.e(LoyalityPassengerDetailFragment.l);
        Iterator<C1398sx> it2 = this.f4797d.iterator();
        while (it2.hasNext()) {
            C1398sx next = it2.next();
            if (this.g.contains(next.getLoyaltyBankId().toString())) {
                this.a = next.getLoyalityNumberSoft();
            }
        }
        if (this.g != null) {
            Iterator<C1398sx> it3 = this.f4797d.iterator();
            while (it3.hasNext()) {
                C1398sx next2 = it3.next();
                long parseLong = Long.parseLong(this.g);
                if (next2.getLoyaltyBankId().equals(Long.valueOf(parseLong))) {
                    this.totalPointBalance.setText(String.valueOf(next2.getLoyaltyPointBalance()));
                }
                if (next2.getLoyaltyBankId().equals(Long.valueOf(parseLong)) && this.g.equals(String.valueOf(101))) {
                    if (((float) next2.getLoyaltyPointBalance().longValue()) < Float.parseFloat(this.f4789c)) {
                        this.irctcEwalletHeading.setText(getString(R.string.redeem_pay_opt));
                        this.proceedEwalletPayment.setVisibility(0);
                        this.redeemLoyaltyLayout.setVisibility(0);
                        this.insufficientBalanceLl.setVisibility(0);
                        this.userNameLl.setVisibility(8);
                        this.amountToDeductedLl.setVisibility(8);
                        this.userName.setVisibility(8);
                        this.amountToDeducted.setVisibility(8);
                        this.remainingBalanceLayout.setVisibility(8);
                        this.ewalletTxnPassword.setVisibility(8);
                        this.ewalletSendOtp.setVisibility(8);
                        this.ewalletOtp.setVisibility(8);
                        this.ewalletTxnPasswordLL.setVisibility(8);
                        this.ewalletAvlBalance.setVisibility(8);
                        this.ewalletUserId.setVisibility(8);
                    } else {
                        this.irctcEwalletHeading.setText(getString(R.string.redeem_pay_opt));
                        this.ewalletAvlBalance.setVisibility(8);
                        this.ewalletUserId.setVisibility(8);
                        this.proceedEwalletPayment.setVisibility(0);
                        this.redeemLoyaltyLayout.setVisibility(0);
                        this.userName.setVisibility(0);
                        this.amountToDeducted.setVisibility(0);
                        this.ewalletTxnPasswordLL.setVisibility(8);
                        this.ewalletTxnPassword.setVisibility(8);
                        this.ewalletTxnPassword.setEnabled(true);
                    }
                }
            }
            this.userName.setText(Bw.e(getContext()).h());
            TextView textView = this.amountToDeducted;
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.rupees));
            lf.x(sb, this.f4789c, textView);
            this.remainingBalanceLayout.setVisibility(8);
            this.c = 25;
            this.ewalletOtp.setVisibility(8);
            this.ewalletOtp.setEnabled(false);
            this.ewalletSendOtp.setText(getString(R.string.send_otp));
            if (this.f4784b) {
                this.ewalletOtp.setVisibility(0);
                this.paymentAmountTv.setVisibility(0);
            }
        }
    }

    @OnClick({2131362238})
    public void onMobiMppClick() {
        this.c = 10;
        g(101);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = defpackage.C1480xl.f7038a;
     */
    @butterknife.OnClick({2131364896})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOTPSendWallet() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f4802e
            android.widget.EditText r1 = r4.walletMobno
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0022
            xl r0 = defpackage.C1480xl.f7038a
            int r1 = r0.f7039a
            r2 = 14
            if (r1 == r2) goto L_0x0022
            if (r1 == 0) goto L_0x0022
            android.widget.TextView r1 = r4.walletSendOtp
            r0.e(r4, r1)
            goto L_0x0025
        L_0x0022:
            r4.q()
        L_0x0025:
            xl r0 = defpackage.C1480xl.f7038a
            r1 = 0
            r0.f7039a = r1
            int r2 = r4.c
            r3 = 3
            if (r2 != r3) goto L_0x0049
            kp r0 = r0.f7042a
            boolean r0 = r0.isWithoutOTP()
            if (r0 == 0) goto L_0x0049
            android.widget.EditText r0 = r4.walletOtp
            r0.setEnabled(r1)
            android.widget.EditText r0 = r4.walletOtp
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r4.ewalletSendOtp
            r0.setVisibility(r1)
            goto L_0x005b
        L_0x0049:
            android.widget.EditText r0 = r4.walletOtp
            r1 = 1
            r0.setEnabled(r1)
            android.widget.EditText r0 = r4.walletMobno
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r4.f4802e = r0
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.MakePaymentNewFragment.onOTPSendWallet():void");
    }

    @OnClick({2131362867})
    public void onOTPSendeWallet() {
        this.f4784b = true;
        if (!this.ewalletOtp.isEnabled()) {
            q();
        } else {
            C1480xl.f7038a.e(this, this.ewalletSendOtp);
        }
    }

    @OnClick({2131363390})
    public void onOtherPaymentClick() {
        if (this.otherPaymentLL.getVisibility() == 8) {
            this.g = null;
            o();
            this.otherPaymentLL.setVisibility(0);
            this.otherPaymentArrow.setImageResource(R.drawable.spinner_upwards);
            return;
        }
        o();
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    @OnClick({2131362239})
    public void onPayGlocalClick() {
        this.c = 32;
        g(140);
    }

    @OnClick({2131362240})
    public void onPayTenClick() {
        this.c = 37;
        g(152);
    }

    @OnClick({2131362241})
    public void onPaytmClick() {
        this.c = 5;
        g(77);
    }

    @OnClick({2131362242})
    public void onPaytmPaylaterClick() {
        this.c = 24;
        g(135);
    }

    @OnClick({2131362243})
    public void onPaytmUpiClick() {
        this.c = 14;
        g(119);
    }

    @OnClick({2131362246})
    public void onPayuMppClick() {
        this.c = 11;
        g(108);
    }

    @OnClick({2131362247})
    public void onPhonePeClick() {
        this.c = 12;
        g(111);
    }

    @OnClick({2131362248})
    public void onPineLabClick() {
        this.c = 23;
        g(133);
    }

    @OnClick({2131362249})
    public void onRazorPayClick() {
        this.c = 9;
        g(106);
    }

    @OnClick({2131362250})
    public void onRazorPayUpiClick() {
        this.c = 34;
        g(141);
    }

    public final void onResume() {
        super.onResume();
    }

    @OnClick({2131362251})
    public void onSafexPayClick() {
        this.c = 30;
        g(138);
    }

    @OnClick({2131362252})
    public void onSbiePayClick() {
        this.c = 35;
        g(142);
    }

    @OnClick({2131362254})
    public void onStashFinClick() {
        this.c = 22;
        g(131);
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    @OnClick({2131362255})
    public void onTestBankClick() {
        this.c = 2;
        g(99);
    }

    @OnClick({2131363831})
    public void onWalletClick() {
        if (this.walletListLl.getVisibility() == 8) {
            o();
            this.walletListLl.setVisibility(0);
            this.selectWalletImage.setImageResource(R.drawable.spinner_upwards);
            return;
        }
        o();
    }

    @OnClick({2131363535})
    public void onclickVerify(View view) {
        String str;
        int i = this.c;
        if (i == 0) {
            Toast.makeText(getContext(), getString(R.string.please_select_one_payment_option), 1).show();
        } else if (i != 16 && i != 2 && i != 5 && i != 10 && i != 11 && i != 9 && i != 12 && i != 8 && i != 13 && i != 15 && i != 14 && i != 18 && i != 17 && i != 19 && i != 20 && i != 32 && i != 30 && i != 35 && i != 33 && i != 36 && i != 40 && i != 37 && i != 21 && i != 22 && i != 34 && i != 24 && i != 23 && i != 31) {
            if (i == 3 || i == 25) {
                str = this.ewalletOtp.getText().toString();
            } else {
                str = this.walletOtp.getText().toString();
            }
            if (((this.c != 3 || C1480xl.f7038a.f7042a.isWithoutOTP()) && this.c == 3) || (TextUtils.isDigitsOnly(str) && TextUtils.getTrimmedLength(str) != 0)) {
                C0535I5.H(getActivity(), getView());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Do("OTP", str));
                this.walletOtp.setText("");
                this.ewalletOtp.setText("");
                C1480xl.f7038a.c(this, arrayList);
                return;
            }
            C0535I5.m(getActivity(), false, getString(R.string.please_provide_otp), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (k(C1058d.h(i))) {
            t(this.c, (String) null, (String) null);
        } else {
            Spanned fromHtml = Html.fromHtml("");
            String j = j(C1058d.h(this.c));
            if (j != null) {
                fromHtml = Html.fromHtml(j);
            }
            TextView textView = new TextView(getContext());
            textView.setText(fromHtml);
            textView.setGravity(3);
            textView.setPadding(50, 10, 50, 20);
            textView.setTextSize(14.0f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            C0535I5.q(getActivity(), textView, getString(R.string.ok)).show();
        }
    }

    @OnClick({2131362795})
    public void oniPayPaymentLayout() {
        h();
    }

    public final void p() {
        this.paymentAmountTv.setVisibility(8);
        this.c = 0;
        f();
        this.proceedWalletPayment.setVisibility(8);
        this.proceedEwalletPayment.setVisibility(8);
        this.walletMobno.setText("");
        this.walletOtp.setText("");
        this.ewalletTxnPassword.setText((CharSequence) null);
        this.ewalletOtp.setText((CharSequence) null);
    }

    public final void q() {
        int i = this.c;
        if (i == 0) {
            Toast.makeText(getContext(), getString(R.string.please_select_one_payment_option), 1).show();
        } else if (i == 25 || k(C1058d.h(i))) {
            int i2 = this.c;
            if (Double.parseDouble(this.f4789c) <= 0.0d) {
                Toast.makeText(getContext(), getString(R.string.payment_detail_not_found), 1).show();
            } else if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                new Handler().postDelayed(new C0825ck(), 5000);
            } else if (C0793b1.a.f3912a != null) {
                C1225kp kpVar = new C1225kp();
                kpVar.setAmount(Double.parseDouble(this.f4789c));
                String str = this.f4806f;
                if (str == null || !str.equals("redemption")) {
                    kpVar.setBankId(C1058d.h(i2));
                } else {
                    kpVar.setBankId(Integer.parseInt(this.g));
                    kpVar.setLoyaltyNum(this.a);
                }
                kpVar.setTxnType(C1058d.m(i2));
                C1480xl xlVar = C1480xl.f7038a;
                xlVar.f7042a = kpVar;
                xlVar.f7041a = this.f4796d;
                int h = C1058d.h(i2);
                xlVar.f7045b = m(h);
                C1480xl.a = Boolean.valueOf(e);
                String str2 = null;
                if (d) {
                    this.f4778a.setBankId(Integer.valueOf(h));
                    xlVar.f7043a = this.f4778a;
                    xlVar.f7044a = d;
                } else {
                    xlVar.f7043a = null;
                    xlVar.f7044a = false;
                }
                if (i2 == 25) {
                    xlVar.d(this, new ArrayList(), this.ewalletSendOtp, this.ewalletOtp, this.ewalletTxnPassword, this.ewalletOtpNote);
                    this.paymentAmountTv.setVisibility(0);
                    return;
                }
                if (i2 == 3) {
                    str2 = this.ewalletTxnPassword.getText().toString();
                }
                if (i2 != 3 && !C0535I5.N(this.walletMobno.getText().toString())) {
                    C0535I5.m(getActivity(), false, "Please enter valid Mobile Number", getString(R.string.error), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                } else if (1000 != h || !this.f4774a.getTxnPwdFlag().equalsIgnoreCase("false") || (!TextUtils.isEmpty(str2) && TextUtils.getTrimmedLength(str2) != 0)) {
                    ArrayList arrayList = new ArrayList();
                    if (i2 == 3) {
                        arrayList.add(new Do("TXN_PASSWORD", str2));
                    } else {
                        arrayList.add(new Do("MOBILE", this.walletMobno.getText().toString()));
                    }
                    xlVar.d(this, arrayList, this.ewalletSendOtp, this.ewalletOtp, this.ewalletTxnPassword, this.ewalletOtpNote);
                    this.paymentAmountTv.setVisibility(0);
                } else {
                    C0535I5.m(getActivity(), false, getString(R.string.please_provide_txn_pass), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else {
                C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            Spanned fromHtml = Html.fromHtml("");
            String j = j(C1058d.h(this.c));
            if (j != null) {
                fromHtml = Html.fromHtml(j);
            }
            TextView textView = new TextView(getContext());
            textView.setText(fromHtml);
            textView.setGravity(3);
            textView.setPadding(50, 10, 50, 20);
            textView.setTextSize(14.0f);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            C0535I5.q(getActivity(), textView, getString(R.string.ok)).show();
        }
    }

    public final void r() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        new LinearLayout.LayoutParams(0, -1, 3.0f);
        Iterator<C1187j2> it = this.f4775a.iterator();
        while (it.hasNext()) {
            C1187j2 next = it.next();
            String str = this.f4806f;
            if (str == null || !str.equals("accural") || !(next.getBankId() == 124 || next.getBankId() == 101)) {
                Html.fromHtml("");
                if (!(!next.isEnableFlag() || next.getOfferMsg() == null || next.getOfferUrl() == null)) {
                    String offerMsg = next.getOfferMsg();
                    String offerUrl = next.getOfferUrl();
                    Spanned spanned = (Spanned) TextUtils.concat(new CharSequence[]{Html.fromHtml("<a href=\"" + offerUrl + "\">" + offerMsg + "</a>")});
                }
                next.getBankId();
                if (next.getBankId() == 77) {
                    this.selectPaytm.setClickable(next.isEnableFlag());
                    this.paytmLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.paytmLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 118) {
                    this.selectIPay.setClickable(next.isEnableFlag());
                    this.iPayRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.iPayRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 124) {
                    this.selectAmexMpp.setClickable(next.isEnableFlag());
                    this.amexMppRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.amexMppRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 125) {
                    this.selectIndusIndMpp.setClickable(next.isEnableFlag());
                    this.indusIndMppRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.indusIndMppRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 142) {
                    this.selectSbiePay.setClickable(next.isEnableFlag());
                    this.sbiePayRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.sbiePayRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 147) {
                    this.selectCashFree.setClickable(next.isEnableFlag());
                    this.cashFreeRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.cashFreeRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    }
                }
                if (next.getBankId() == 152) {
                    this.selectPayTen.setClickable(next.isEnableFlag());
                    this.payTenRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.payTenRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    }
                }
                if (next.getBankId() == 144) {
                    this.selectEaseBuzz.setClickable(next.isEnableFlag());
                    this.easeBuzzRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.easeBuzzRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 119) {
                    this.selectPaytmUpi.setClickable(next.isEnableFlag());
                    this.paytmUpiRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.paytmUpiRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 141) {
                    this.selectRazorpayUpi.setClickable(next.isEnableFlag());
                    this.razorPayUpiRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.razorPayUpiRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 120) {
                    this.selectIciciMpp.setClickable(next.isEnableFlag());
                    this.iciciMppLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.iciciMppLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 122) {
                    this.selectHdfcMpp.setClickable(next.isEnableFlag());
                    this.hdfcMppRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.hdfcMppRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 121) {
                    this.selectAirpayMpp.setClickable(next.isEnableFlag());
                    this.airPayMppRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.airPayMppRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 101) {
                    this.selectMobiMpp.setClickable(next.isEnableFlag());
                    this.mobiMppLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.mobiMppLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 108) {
                    this.selectPayuMpp.setClickable(next.isEnableFlag());
                    this.payuMppLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.payuMppLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    }
                }
                if (next.getBankId() == 106) {
                    this.selectRazorPay.setClickable(next.isEnableFlag());
                    this.razorPayLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.razorPayLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    }
                }
                if (next.getBankId() == 111) {
                    this.selectPhonePe.setClickable(next.isEnableFlag());
                    this.phonePeRl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.phonePeRl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else if (u(next) != null) {
                        this.phonePeOfferBalloon.setVisibility(0);
                    }
                }
                if (next.getBankId() == 95) {
                    this.selectCod.setClickable(next.isEnableFlag());
                    this.codLayout.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.codLayout.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 127) {
                    this.selectEpayLater.setClickable(next.isEnableFlag());
                    this.epayLaterLayout.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.epayLaterLayout.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 131) {
                    this.selectStashFin.setClickable(next.isEnableFlag());
                    this.stashFinLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.stashFinLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 135) {
                    this.selectPaytmPaylater.setClickable(next.isEnableFlag());
                    this.paytmPayLaterLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.paytmPayLaterLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 133) {
                    this.selectPineLab.setClickable(next.isEnableFlag());
                    this.pineLabLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.pineLabLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 148) {
                    this.selectBajajEmi.setClickable(next.isEnableFlag());
                    this.bajajEmiLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.bajajEmiLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    }
                }
                if (next.getBankId() == 139) {
                    this.selectBhanix.setClickable(next.isEnableFlag());
                    this.bhanixLl.setVisibility(0);
                    if (!next.isEnableFlag()) {
                        this.bhanixLl.setBackgroundResource(R.drawable.backgound_white_border_squre_solid);
                    } else {
                        u(next);
                    }
                }
                if (next.getBankId() == 1000) {
                    Iterator it2 = this.f4776a.keySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        LinearLayout linearLayout = (LinearLayout) it2.next();
                        Objects.toString(linearLayout);
                        Objects.toString(this.f4776a.get(linearLayout));
                        linearLayout.getId();
                        if (!((Boolean) this.f4776a.get(linearLayout)).booleanValue()) {
                            View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.irctc_e_wallet, (ViewGroup) null, false);
                            this.b = inflate;
                            if (inflate != null) {
                                linearLayout.addView(inflate, layoutParams);
                                if (((LinearLayout) linearLayout.getParent().getParent()).getVisibility() != 0) {
                                    ((LinearLayout) linearLayout.getParent().getParent()).setVisibility(0);
                                }
                                this.f4776a.put(linearLayout, Boolean.TRUE);
                                this.f4780b = (LinearLayout) this.b.findViewById(R.id.click_ewallet);
                                this.f4781b = (RadioButton) this.b.findViewById(R.id.select_ewallet);
                                this.f4782b = (TextView) this.b.findViewById(R.id.w_irctc_txn);
                                if (next.isEnableFlag()) {
                                    u(next);
                                    EditText editText = this.ewalletTxnPassword;
                                    editText.setOnTouchListener(new b(editText));
                                } else if (next.getDisableReason().indexOf("register for IRCTC") == -1 && next.getDisableReason().indexOf("expired") == -1 && next.getDisableReason().indexOf("Insufficient") == -1) {
                                    this.f4780b.setBackgroundResource(R.drawable.bank_disable_indicator);
                                }
                            }
                        }
                    }
                } else if (next.getBankId() == 74) {
                    Iterator it3 = this.f4776a.keySet().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        LinearLayout linearLayout2 = (LinearLayout) it3.next();
                        Objects.toString(linearLayout2);
                        Objects.toString(this.f4776a.get(linearLayout2));
                        if (!((Boolean) this.f4776a.get(linearLayout2)).booleanValue()) {
                            View inflate2 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.mobikwik_wallet, (ViewGroup) null, false);
                            this.f4767a = inflate2;
                            if (inflate2 != null) {
                                linearLayout2.addView(inflate2, layoutParams);
                                this.f4776a.put(linearLayout2, Boolean.TRUE);
                                if (((LinearLayout) linearLayout2.getParent().getParent()).getVisibility() != 0) {
                                    ((LinearLayout) linearLayout2.getParent().getParent()).setVisibility(0);
                                }
                                this.f4768a = (LinearLayout) this.f4767a.findViewById(R.id.click_mobikwik);
                                this.f4769a = (RadioButton) this.f4767a.findViewById(R.id.select_mobiwik);
                                TextView textView = (TextView) this.f4767a.findViewById(R.id.w_mobikwik_txn);
                                this.f4770a = (TextView) this.f4767a.findViewById(R.id.w_mobikwik_offer);
                                if (!next.isEnableFlag()) {
                                    this.f4768a.setBackgroundResource(R.drawable.bank_disable_indicator);
                                } else {
                                    this.txnChargesTv.setText(n(74));
                                    this.f4770a.setText(u(next));
                                    this.f4770a.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.f4770a.setLinkTextColor(getResources().getColor(R.color.blue));
                                    this.f4770a.setTextSize(9.0f);
                                }
                            }
                        }
                    }
                } else if (next.getBankId() == 76) {
                    Iterator it4 = this.f4776a.keySet().iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        LinearLayout linearLayout3 = (LinearLayout) it4.next();
                        Objects.toString(linearLayout3);
                        Objects.toString(this.f4776a.get(linearLayout3));
                        if (!((Boolean) this.f4776a.get(linearLayout3)).booleanValue()) {
                            View inflate3 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.payu_wallet, (ViewGroup) null, false);
                            this.f4785c = inflate3;
                            if (inflate3 != null) {
                                linearLayout3.addView(inflate3, layoutParams);
                                this.f4776a.put(linearLayout3, Boolean.TRUE);
                                if (((LinearLayout) linearLayout3.getParent().getParent()).getVisibility() != 0) {
                                    ((LinearLayout) linearLayout3.getParent().getParent()).setVisibility(0);
                                }
                                this.f4786c = (LinearLayout) this.f4785c.findViewById(R.id.click_payu);
                                this.f4787c = (RadioButton) this.f4785c.findViewById(R.id.select_payumoney);
                                TextView textView2 = (TextView) this.f4785c.findViewById(R.id.w_payu_txn);
                                this.f4788c = (TextView) this.f4785c.findViewById(R.id.w_payu_offer);
                                if (!next.isEnableFlag()) {
                                    this.f4786c.setBackgroundResource(R.drawable.bank_disable_indicator);
                                } else {
                                    this.txnChargesTv.setText(n(76));
                                    this.f4788c.setText(u(next));
                                    this.f4788c.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.f4788c.setLinkTextColor(getResources().getColor(R.color.blue));
                                    this.f4788c.setTextSize(9.0f);
                                }
                            }
                        }
                    }
                } else if (next.getBankId() == 73) {
                    Iterator it5 = this.f4776a.keySet().iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        LinearLayout linearLayout4 = (LinearLayout) it5.next();
                        Objects.toString(linearLayout4);
                        Objects.toString(this.f4776a.get(linearLayout4));
                        if (!((Boolean) this.f4776a.get(linearLayout4)).booleanValue()) {
                            View inflate4 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.sbi_buddy_wallet, (ViewGroup) null, false);
                            this.f4798e = inflate4;
                            if (inflate4 != null) {
                                linearLayout4.addView(inflate4, layoutParams);
                                this.f4776a.put(linearLayout4, Boolean.TRUE);
                                if (((LinearLayout) linearLayout4.getParent().getParent()).getVisibility() != 0) {
                                    ((LinearLayout) linearLayout4.getParent().getParent()).setVisibility(0);
                                }
                                this.f4799e = (LinearLayout) this.f4798e.findViewById(R.id.click_sbibuddy);
                                this.f4800e = (RadioButton) this.f4798e.findViewById(R.id.select_sbi);
                                TextView textView3 = (TextView) this.f4798e.findViewById(R.id.w_sbi_txn);
                                this.f4801e = (TextView) this.f4798e.findViewById(R.id.w_sbi_offer);
                                if (!next.isEnableFlag()) {
                                    this.f4799e.setBackgroundResource(R.drawable.bank_disable_indicator);
                                } else {
                                    this.txnChargesTv.setText(n(73));
                                    this.f4801e.setText(u(next));
                                    this.f4801e.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.f4801e.setLinkTextColor(getResources().getColor(R.color.blue));
                                    this.f4801e.setTextSize(9.0f);
                                }
                            }
                        }
                    }
                } else if (next.getBankId() == 91) {
                    Iterator it6 = this.f4776a.keySet().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        LinearLayout linearLayout5 = (LinearLayout) it6.next();
                        Objects.toString(linearLayout5);
                        Objects.toString(this.f4776a.get(linearLayout5));
                        if (!((Boolean) this.f4776a.get(linearLayout5)).booleanValue()) {
                            View inflate5 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.airtel_wallet, (ViewGroup) null, false);
                            this.f = inflate5;
                            if (inflate5 != null) {
                                linearLayout5.addView(inflate5, layoutParams);
                                this.f4776a.put(linearLayout5, Boolean.TRUE);
                                if (((LinearLayout) linearLayout5.getParent().getParent()).getVisibility() != 0) {
                                    ((LinearLayout) linearLayout5.getParent().getParent()).setVisibility(0);
                                }
                                this.f4804f = (LinearLayout) this.f.findViewById(R.id.click_airtel);
                                this.f4805f = (RadioButton) this.f.findViewById(R.id.select_airtel_money);
                                TextView textView4 = (TextView) this.f.findViewById(R.id.w_airtel_txn);
                                if (!next.isEnableFlag()) {
                                    this.f4804f.setBackgroundResource(R.drawable.bank_disable_indicator);
                                } else {
                                    this.txnChargesTv.setText(n(91));
                                    u(next);
                                }
                            }
                        }
                    }
                } else if (next.getBankId() == 104) {
                    Iterator it7 = this.f4776a.keySet().iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            break;
                        }
                        LinearLayout linearLayout6 = (LinearLayout) it7.next();
                        Objects.toString(linearLayout6);
                        Objects.toString(this.f4776a.get(linearLayout6));
                        if (!((Boolean) this.f4776a.get(linearLayout6)).booleanValue()) {
                            View inflate6 = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.paytm_wallet, (ViewGroup) null, false);
                            this.f4792d = inflate6;
                            if (inflate6 != null) {
                                linearLayout6.addView(inflate6, layoutParams);
                                this.f4776a.put(linearLayout6, Boolean.TRUE);
                                if (((LinearLayout) linearLayout6.getParent().getParent()).getVisibility() != 0) {
                                    ((LinearLayout) linearLayout6.getParent().getParent()).setVisibility(0);
                                }
                                this.f4793d = (LinearLayout) this.f4792d.findViewById(R.id.click_paytm_wallet);
                                this.f4794d = (RadioButton) this.f4792d.findViewById(R.id.select_paytm_wallet);
                                TextView textView5 = (TextView) this.f4792d.findViewById(R.id.w_paytm_txn);
                                this.f4795d = (TextView) this.f4792d.findViewById(R.id.w_paytm_offer);
                                if (!next.isEnableFlag()) {
                                    this.f4793d.setBackgroundResource(R.drawable.bank_disable_indicator);
                                } else {
                                    this.f4795d.setText(u(next));
                                    this.f4795d.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.f4795d.setLinkTextColor(getResources().getColor(R.color.blue));
                                    this.f4795d.setTextSize(9.0f);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.paymentAmountTv.setVisibility(8);
        TextView textView6 = this.paymentAmountTv;
        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.pay));
        sb.append(" ");
        sb.append(getResources().getString(R.string.rupees));
        lf.x(sb, this.f4789c, textView6);
        LinkedHashSet linkedHashSet = this.f4777a;
        if (linkedHashSet.contains(54)) {
            this.selectWallet.setVisibility(0);
        }
        if (linkedHashSet.contains(518)) {
            this.iPayPaymentLl.setVisibility(0);
            h();
            onIpayClick();
        }
        if (linkedHashSet.contains(59)) {
            this.otherPaymentHeadRl.setVisibility(0);
        }
        if (linkedHashSet.contains(517)) {
            this.bhimUpiLl.setVisibility(0);
        }
        if (linkedHashSet.contains(516)) {
            this.codLayoutHead.setVisibility(0);
        }
        if (linkedHashSet.contains(58)) {
            this.emiLayoutHead.setVisibility(0);
        }
        LinearLayout linearLayout7 = this.f4768a;
        if (!(linearLayout7 == null || this.f4769a == null)) {
            linearLayout7.setOnClickListener(new C1093ek(this));
            this.f4769a.setOnClickListener(new C1115fk(this));
        }
        LinearLayout linearLayout8 = this.f4780b;
        if (!(linearLayout8 == null || this.f4781b == null)) {
            linearLayout8.setOnClickListener(new C1135gk(this));
            this.f4781b.setOnClickListener(new C1158hk(this));
        }
        LinearLayout linearLayout9 = this.f4786c;
        if (!(linearLayout9 == null || this.f4787c == null)) {
            linearLayout9.setOnClickListener(new C1179ik(this));
            this.f4787c.setOnClickListener(new C1199jk(this));
        }
        LinearLayout linearLayout10 = this.f4799e;
        if (!(linearLayout10 == null || this.f4800e == null)) {
            linearLayout10.setOnClickListener(new C1221kk(this));
            this.f4800e.setOnClickListener(new C1241lk(this));
        }
        LinearLayout linearLayout11 = this.f4804f;
        if (!(linearLayout11 == null || this.f4805f == null)) {
            linearLayout11.setOnClickListener(new C0749Xj(this));
            this.f4805f.setOnClickListener(new C0759Yj(this));
        }
        LinearLayout linearLayout12 = this.f4793d;
        if (!(linearLayout12 == null || this.f4794d == null)) {
            linearLayout12.setOnClickListener(new C0770Zj(this));
            this.f4794d.setOnClickListener(new C0784ak(this));
        }
        EditText editText2 = this.ewalletTxnPassword;
        editText2.setOnTouchListener(new V(this, editText2));
    }

    @OnClick({2131363881})
    public void radioBtnAirpayMppClick() {
        this.c = 17;
        g(121);
    }

    @OnClick({2131363884})
    public void radioBtnAmexMppClick() {
        this.c = 19;
        g(124);
    }

    @OnClick({2131363885})
    public void radioBtnBajajEmiClick() {
        this.c = 40;
        g(148);
    }

    @OnClick({2131363887})
    public void radioBtnBhanixCasheClick() {
        this.c = 31;
        g(139);
    }

    @OnClick({2131363890})
    public void radioBtnCashFreeClick() {
        this.c = 36;
        g(147);
    }

    @OnClick({2131363891})
    public void radioBtnCodClick() {
        this.c = 8;
        g(95);
    }

    @OnClick({2131363893})
    public void radioBtnEaseBuzzClick() {
        this.c = 33;
        g(144);
    }

    @OnClick({2131363894})
    public void radioBtnEpayLaterClick() {
        this.c = 21;
        g(127);
    }

    @OnClick({2131363897})
    public void radioBtnHdfcMppClick() {
        this.c = 18;
        g(122);
    }

    @OnClick({2131363898})
    public void radioBtnIciciMppClick() {
        this.c = 15;
        g(120);
    }

    @OnClick({2131363899})
    public void radioBtnIndusIndMppClick() {
        this.c = 20;
        g(125);
    }

    @OnClick({2131363900})
    public void radioBtnIpayClick() {
        this.c = 13;
        g(118);
    }

    @OnClick({2131363906})
    public void radioBtnMobiMppClick() {
        this.c = 10;
        g(101);
    }

    @OnClick({2131363909})
    public void radioBtnPayGlocalClick() {
        this.c = 32;
        g(140);
    }

    @OnClick({2131363910})
    public void radioBtnPayTenClick() {
        this.c = 37;
        g(152);
    }

    @OnClick({2131363911})
    public void radioBtnPaytmClick() {
        this.c = 5;
        g(77);
    }

    @OnClick({2131363912})
    public void radioBtnPaytmPaylaterClick() {
        this.c = 24;
        g(135);
    }

    @OnClick({2131363913})
    public void radioBtnPaytmUpiClick() {
        this.c = 14;
        g(119);
    }

    @OnClick({2131363915})
    public void radioBtnPayuMppClick() {
        this.c = 11;
        g(108);
    }

    @OnClick({2131363917})
    public void radioBtnPhonePeClick() {
        this.c = 12;
        g(111);
    }

    @OnClick({2131363918})
    public void radioBtnPineLabClick() {
        this.c = 23;
        g(133);
    }

    @OnClick({2131363921})
    public void radioBtnRazorPayClick() {
        this.c = 9;
        g(106);
    }

    @OnClick({2131363922})
    public void radioBtnRazorPayUpiClick() {
        this.c = 34;
        g(141);
    }

    @OnClick({2131363923})
    public void radioBtnSafexClick() {
        this.c = 30;
        g(138);
    }

    @OnClick({2131363925})
    public void radioBtnSbiePayClick() {
        this.c = 35;
        g(142);
    }

    @OnClick({2131363927})
    public void radioBtnStashFinClick() {
        this.c = 22;
        g(131);
    }

    @OnClick({2131363930})
    public void radioBtnTestBankClick() {
        this.c = 2;
        g(99);
    }

    public final void s(ArrayList<C1187j2> arrayList, String str, C0824ch chVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", UUID.randomUUID().toString());
            jSONObject.put(PaymentConstants.SERVICE, C1450w1.f7008a.getServiceUrl());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LogCategory.ACTION, "gatewaySelection");
            jSONObject2.put(PaymentConstants.MERCHANT_ID_CAMEL, chVar.getMerchant_id());
            jSONObject2.put(PaymentConstants.CLIENT_ID_CAMEL, C1450w1.f7008a.getClientId());
            jSONObject2.put(PaymentConstants.AMOUNT, str);
            jSONObject2.put("customerId", C1450w1.f7026d);
            jSONObject2.put("customerEmail", "irctc@juspay.com");
            jSONObject2.put("customerMobile", Bw.e(getContext()).k());
            jSONObject2.put(PaymentConstants.ORDER_DETAILS_CAMEL, chVar.getOrderDetails());
            jSONObject2.put(PaymentConstants.SIGNATURE, chVar.getSignature());
            jSONObject2.put("merchantKeyId", chVar.getMerchantKeyID());
            if (Bw.e(getContext()).f().equalsIgnoreCase("hi")) {
                jSONObject2.put("language", "hindi");
            } else {
                jSONObject2.put("language", "english");
            }
            jSONObject2.put(PaymentConstants.ENV, chVar.getEnvironment());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                HashMap hashMap = new HashMap();
                hashMap.put("bankId", String.valueOf(arrayList.get(i).getBankId()));
                hashMap.put("bankName", String.valueOf(arrayList.get(i).getBankName()));
                hashMap.put("bankDisplayName", String.valueOf(arrayList.get(i).getBankDisplayName()));
                hashMap.put("disableReason", String.valueOf(arrayList.get(i).getDisableReason()));
                hashMap.put("displaySequence", String.valueOf(arrayList.get(i).getDisplaySequence()));
                hashMap.put("enableFlag", String.valueOf(arrayList.get(i).isEnableFlag()));
                hashMap.put("message", String.valueOf(arrayList.get(i).getMessage()));
                hashMap.put("mobileType", String.valueOf(arrayList.get(i).getMobileType()));
                hashMap.put("paymentMode", String.valueOf(arrayList.get(i).getPaymentMode()));
                hashMap.put("txnPasswordMandatory", String.valueOf(arrayList.get(i).isTxnPasswordMandatory()));
                hashMap.put("displaySection", String.valueOf(arrayList.get(i).getJuspayEnabledMode()));
                hashMap.put("juspayEnableFlag", String.valueOf(arrayList.get(i).getJuspayEnableFlag()));
                jSONArray.put(new JSONObject(hashMap));
            }
            jSONObject2.put("paymentOptions", jSONArray);
            jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
        } catch (Exception e2) {
            e2.getMessage();
        }
        C0822cf cfVar = this.f4771a;
        cfVar.getClass();
        jSONObject.toString();
        cfVar.getHyperServices().process(cfVar.f3937a, jSONObject);
    }

    public final void t(int i, String str, String str2) {
        String str3;
        String str4 = str;
        String str5 = str2;
        if (Double.parseDouble(this.f4789c) <= 0.0d) {
            Toast.makeText(getContext(), getString(R.string.payment_detail_not_found), 1).show();
        } else if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new C1072dk(), 5000);
        } else if (C0793b1.a.f3912a != null) {
            C1225kp kpVar = new C1225kp();
            kpVar.setAmount(Double.parseDouble(this.f4789c));
            kpVar.setBankId(C1058d.h(i));
            if (!(this.g == null || (str3 = this.f4806f) == null || !str3.equals("redemption"))) {
                kpVar.setLoyaltyNum(this.a);
            }
            kpVar.setTxnType(C1058d.m(i));
            C1480xl xlVar = C1480xl.f7038a;
            xlVar.f7042a = kpVar;
            xlVar.f7041a = this.f4796d;
            int h = C1058d.h(i);
            xlVar.f7045b = m(h);
            C1480xl.a = Boolean.valueOf(e);
            if (d) {
                this.f4778a.setBankId(Integer.valueOf(h));
                xlVar.f7043a = this.f4778a;
                xlVar.f7044a = d;
            } else {
                xlVar.f7043a = null;
                xlVar.f7044a = false;
            }
            if (str5 != null && str5.equals(C0515Ga.AVLBLTY_ONLY)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Do("gatewayId", str4));
                arrayList.add(new Do("JUSPAY_FLOW", C0515Ga.AVLBLTY_ONLY));
                xlVar.d(this, arrayList, (TextView) null, (EditText) null, (EditText) null, (TextView) null);
            } else if (h != 99) {
                if (h == 95) {
                    CashOnDeliveryActivity cashOnDeliveryActivity = CashOnDeliveryActivity.a;
                    HomeActivity.f4183a = cashOnDeliveryActivity;
                    cashOnDeliveryActivity.f5355a = this;
                    xlVar.d(cashOnDeliveryActivity, new ArrayList(), (TextView) null, (EditText) null, (EditText) null, (TextView) null);
                } else if (h == 104) {
                    C1332pp ppVar = new C1332pp();
                    ppVar.a = this;
                    xlVar.d(ppVar, (ArrayList) null, (TextView) null, (EditText) null, (EditText) null, (TextView) null);
                } else if (h == 101) {
                    PgWebViewActivity pgWebViewActivity = PgWebViewActivity.a;
                    HomeActivity.f4181a = pgWebViewActivity;
                    pgWebViewActivity.f4270a = this;
                    ArrayList arrayList2 = new ArrayList();
                    pgWebViewActivity.c = str4;
                    xlVar.d(pgWebViewActivity, arrayList2, (TextView) null, (EditText) null, (EditText) null, (TextView) null);
                } else if (h == 108) {
                    C1464wp wpVar = new C1464wp();
                    wpVar.a = this;
                    xlVar.d(wpVar, (ArrayList) null, (TextView) null, (EditText) null, (EditText) null, (TextView) null);
                } else if (h == 111 || h == 118 || h == 119 || h == 120 || h == 122 || h == 121 || h == 127 || h == 131 || h == 135 || h == 124 || h == 125 || h == 133 || h == 148 || h == 140 || h == 139 || h == 138 || h == 142 || h == 147 || h == 152 || h == 144 || h == 77 || h == 106 || h == 141) {
                    PgWebViewActivity pgWebViewActivity2 = PgWebViewActivity.a;
                    HomeActivity.f4181a = pgWebViewActivity2;
                    pgWebViewActivity2.f4270a = this;
                    ArrayList arrayList3 = new ArrayList();
                    pgWebViewActivity2.c = str4;
                    xlVar.d(pgWebViewActivity2, arrayList3, (TextView) null, (EditText) null, (EditText) null, (TextView) null);
                }
            }
        } else {
            C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), "Error", getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public final Fragment a() {
        return this;
    }

    public final void c(String str) {
    }

    public class a implements TextWatcher {
        public a() {
        }

        public final void afterTextChanged(Editable editable) {
            int length = editable.length();
            MakePaymentNewFragment makePaymentNewFragment = MakePaymentNewFragment.this;
            if (length == 6) {
                C0535I5.I(makePaymentNewFragment.getActivity());
            }
            if (editable.length() >= 4) {
                makePaymentNewFragment.paymentAmountTv.setVisibility(0);
            } else {
                makePaymentNewFragment.paymentAmountTv.setVisibility(8);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
