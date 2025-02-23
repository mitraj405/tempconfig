package com.paytm.pgsdk.sdknative;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.paytm.pgsdk.sdknative.PaytmPaymentActivity;
import com.paytm.pgsdk.sdknative.a;
import com.paytm.pgsdk.sdknative.modal.BaseResponseModal;
import com.paytm.pgsdk.sdknative.modal.PostConvenienceModal;
import com.paytm.pgsdk.sdknative.modal.ResponseCheckBalance;
import com.paytm.pgsdk.sdknative.modal.ResponseSavedCardBin;
import com.paytm.pgsdk.sdknative.modal.Tokens;
import defpackage.C1310ov;
import in.juspay.hypersdk.core.PaymentConstants;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PaytmSavedCardActivity extends FragmentActivity implements a.C0055a, View.OnClickListener, C1310ov.c, Mn, Ln {
    public static final String OTHER = "OTHER";
    public static TreeMap<Integer, Integer> cardCvv = new TreeMap<>();
    private C1233l2 adapter;
    private RelativeLayout cardRelativeLayout;
    private C1310ov.b checkBalanceRequestprovider = new a();
    private C1470x1 currentDownloadingBank;
    /* access modifiers changed from: private */
    public TextView errorCVV;
    /* access modifiers changed from: private */
    public TextView errorCard;
    /* access modifiers changed from: private */
    public TextView errorDate;
    private TableLayout gridview;
    private LayoutInflater inflater;
    boolean isSavedCard = false;
    private String mAmount;
    private ImageView mBackButton;
    private ImageView mBackIcon;
    /* access modifiers changed from: private */
    public ArrayList<C1145h2> mBankArrayListPaytm;
    /* access modifiers changed from: private */
    public ArrayList<C1145h2> mBankArrayListmerchant;
    private Spinner mBankSpinner;
    private EditText mCVVNumberEditText;
    private EditText mCardNumberEditText;
    private Button mCardProceedButton;
    private ImageView mCardTypeImageView;
    /* access modifiers changed from: private */
    public CheckBox mCheckBoxStoreCard;
    /* access modifiers changed from: private */
    public CheckBox mCheckUseWallet;
    private C1168i2 mDBoperation;
    private AlertDialog mDlg;
    private TextView mFare;
    /* access modifiers changed from: private */
    public ArrayList<C1145h2> mFastForwardBanksPaytm;
    /* access modifiers changed from: private */
    public ArrayList<C1145h2> mFastForwardBanksmerchant;
    private RelativeLayout mMonthRelativelayout;
    private Spinner mMonthSpinner;
    private RelativeLayout mNBLayout;
    private Button mNBProceedButton;
    /* access modifiers changed from: private */
    public double mRemainingBalance;
    private ResponseSavedCardBin mResponseSavedCardBin;
    private List<Fragment> mSavedCardFragments;
    /* access modifiers changed from: private */
    public TextView mSeriveChargeLabel;
    /* access modifiers changed from: private */
    public TextView mServiceCharge;
    /* access modifiers changed from: private */
    public TextView mTextBalanceRemaining;
    /* access modifiers changed from: private */
    public TextView mTextTotal;
    private TextView mTextUseSavedCard;
    private TextView mTextWalletAmount;
    /* access modifiers changed from: private */
    public TextView mTextbalanceRemainingLabel;
    private RelativeLayout mToggleRL;
    /* access modifiers changed from: private */
    public TextView mTotalAmountLabel;
    private View mViewLineSavedCard;
    private RelativeLayout mYearRelativelayout;
    private Spinner mYearSpinner;
    Su pageAdapter;
    private ViewPager pager;
    private ProgressBar progressLoader;
    private RelativeLayout relBankDialog;
    private CheckBox resizeCardlayoutCB;
    private CheckBox resizeNBLayoutCB;
    private CheckBox resizesavedcardCB;
    private RelativeLayout savedCardHeader;
    private C1310ov.b savedCardRequestProvider = new b();
    /* access modifiers changed from: private */
    public C1145h2 selectedBank;
    int selectedCard = 0;

    public class a implements C1310ov.b {
        public final HashMap<String, String> a() {
            return new HashMap<>();
        }

        public final Object b() {
            C1487xt.b().getClass();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("MID", C1073dl.a().f5446a.get("MID"));
                if (!(Tokens.getValidateResponse() == null || Tokens.getValidateResponse().TokenDetails == null || Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN == null)) {
                    jSONObject.put("TOKEN", Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
                }
                return "JsonData=" + jSONObject.toString();
            } catch (Exception unused) {
                return "";
            }
        }

        public final String getRequestUrl() {
            String str;
            if (C1488xu.a) {
                str = "https://trust.paytm.in";
            } else {
                str = "http://trust-uat.paytm.in";
            }
            return str.concat("/wallet-web/checkBalance");
        }
    }

    public class b implements C1310ov.b {
        public final HashMap<String, String> a() {
            return new HashMap<>();
        }

        public final Object b() {
            C1487xt.b().getClass();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("SSOToken", Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
                return "JsonData=" + jSONObject.toString();
            } catch (Exception unused) {
                return "";
            }
        }

        public final String getRequestUrl() {
            return C1488xu.i().concat("/HANDLER_INTERNAL/BIN_INFO");
        }
    }

    public class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f4121a;

        public f(ArrayList arrayList) {
            this.f4121a = arrayList;
        }

        public final void onClick(View view) {
            CheckBox checkBox = (CheckBox) view.findViewById(C0501Er.check_bank);
            boolean isChecked = checkBox.isChecked();
            int intValue = ((Integer) view.getTag()).intValue();
            ArrayList arrayList = this.f4121a;
            PaytmSavedCardActivity paytmSavedCardActivity = PaytmSavedCardActivity.this;
            if (!isChecked) {
                ((C1145h2) arrayList.get(intValue)).a = true;
                paytmSavedCardActivity.uncheckOthers(intValue, arrayList);
                checkBox.setChecked(true);
            } else {
                ((C1145h2) arrayList.get(intValue)).a = false;
                checkBox.setChecked(false);
            }
            String str = "NB-" + ((C1145h2) arrayList.get(intValue)).c;
            if (paytmSavedCardActivity.mCheckUseWallet.isChecked()) {
                if (C0709Uj.u(str)) {
                    paytmSavedCardActivity.changeServiceCharge("PPI");
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
                }
            } else if (C0709Uj.u(str)) {
                paytmSavedCardActivity.changeServiceCharge(str);
            } else if (C0709Uj.u("NB-NA")) {
                paytmSavedCardActivity.changeServiceCharge("NB-NA");
            } else if (C0709Uj.u("DEFAULTFEE")) {
                paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
            }
            paytmSavedCardActivity.resetBankSpinner();
            paytmSavedCardActivity.resetNonFastForwardBanks();
            paytmSavedCardActivity.RefreshTablelayout(arrayList);
        }
    }

    public class g implements CompoundButton.OnCheckedChangeListener {
        public g() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PaytmSavedCardActivity paytmSavedCardActivity = PaytmSavedCardActivity.this;
            if (z) {
                paytmSavedCardActivity.mServiceCharge.setVisibility(0);
                paytmSavedCardActivity.mTextTotal.setVisibility(0);
                paytmSavedCardActivity.mTotalAmountLabel.setVisibility(0);
                paytmSavedCardActivity.mTextbalanceRemainingLabel.setVisibility(0);
                paytmSavedCardActivity.mTextBalanceRemaining.setVisibility(0);
                TextView access$400 = paytmSavedCardActivity.mTextBalanceRemaining;
                StringBuilder sb = new StringBuilder();
                Resources resources = paytmSavedCardActivity.getResources();
                int i = C0787as.paytm_rs;
                sb.append(resources.getString(i));
                sb.append(paytmSavedCardActivity.mRemainingBalance);
                access$400.setText(sb.toString());
                paytmSavedCardActivity.mCheckBoxStoreCard.setVisibility(0);
                paytmSavedCardActivity.mCheckBoxStoreCard.setChecked(z);
                C1073dl.a();
                if (C1073dl.b().containsKey("PPI")) {
                    TextView access$000 = paytmSavedCardActivity.mServiceCharge;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(paytmSavedCardActivity.getResources().getString(i));
                    C1073dl.a();
                    sb2.append(C1073dl.b().get("PPI").getFee());
                    access$000.setText(sb2.toString());
                    TextView access$100 = paytmSavedCardActivity.mTextTotal;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(paytmSavedCardActivity.getString(i));
                    C1073dl.a();
                    sb3.append(C1073dl.b().get("PPI").getTxnAmount());
                    access$100.setText(sb3.toString());
                    C1073dl.a();
                    double unused = paytmSavedCardActivity.mRemainingBalance = TB.d(Double.parseDouble(C1073dl.b().get("PPI").getTxnAmount()) - C1073dl.a().f5444a.doubleValue());
                    TextView access$4002 = paytmSavedCardActivity.mTextBalanceRemaining;
                    access$4002.setText(paytmSavedCardActivity.getResources().getString(i) + paytmSavedCardActivity.mRemainingBalance);
                    paytmSavedCardActivity.mSeriveChargeLabel.setText(paytmSavedCardActivity.getResources().getString(C0787as.payment_charges_wallet));
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    TextView access$0002 = paytmSavedCardActivity.mServiceCharge;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(paytmSavedCardActivity.getResources().getString(i));
                    C1073dl.a();
                    sb4.append(C1073dl.b().get("DEFAULTFEE").getFee());
                    access$0002.setText(sb4.toString());
                    TextView access$1002 = paytmSavedCardActivity.mTextTotal;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(paytmSavedCardActivity.getString(i));
                    C1073dl.a();
                    sb5.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
                    access$1002.setText(sb5.toString());
                    C1073dl.a();
                    double unused2 = paytmSavedCardActivity.mRemainingBalance = TB.d(Double.parseDouble(C1073dl.b().get("DEFAULTFEE").getTxnAmount()) - C1073dl.a().f5444a.doubleValue());
                    TextView access$4003 = paytmSavedCardActivity.mTextBalanceRemaining;
                    access$4003.setText(paytmSavedCardActivity.getResources().getString(i) + paytmSavedCardActivity.mRemainingBalance);
                } else {
                    TextView access$1003 = paytmSavedCardActivity.mTextTotal;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(paytmSavedCardActivity.getString(i));
                    lf.x(sb6, C1073dl.a().f5445a, access$1003);
                }
                paytmSavedCardActivity.updateBanks(paytmSavedCardActivity.mBankArrayListPaytm, paytmSavedCardActivity.mFastForwardBanksPaytm);
            } else {
                if (TextUtils.isEmpty(C1073dl.a().f5447b)) {
                    paytmSavedCardActivity.mTextBalanceRemaining.setText("");
                } else {
                    TextView access$4004 = paytmSavedCardActivity.mTextBalanceRemaining;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(paytmSavedCardActivity.getResources().getString(C0787as.paytm_rs));
                    lf.x(sb7, C1073dl.a().f5447b, access$4004);
                }
                paytmSavedCardActivity.mCheckBoxStoreCard.setVisibility(8);
                paytmSavedCardActivity.mCheckBoxStoreCard.setChecked(z);
                paytmSavedCardActivity.mTextbalanceRemainingLabel.setVisibility(0);
                paytmSavedCardActivity.mTextBalanceRemaining.setVisibility(0);
                C1073dl.a();
                if (C1073dl.b().containsKey("CC")) {
                    TextView access$0003 = paytmSavedCardActivity.mServiceCharge;
                    StringBuilder sb8 = new StringBuilder();
                    Resources resources2 = paytmSavedCardActivity.getResources();
                    int i2 = C0787as.paytm_rs;
                    sb8.append(resources2.getString(i2));
                    C1073dl.a();
                    sb8.append(C1073dl.b().get("CC").getFee());
                    access$0003.setText(sb8.toString());
                    TextView access$1004 = paytmSavedCardActivity.mTextTotal;
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(paytmSavedCardActivity.getString(i2));
                    C1073dl.a();
                    sb9.append(C1073dl.b().get("CC").getTxnAmount());
                    access$1004.setText(sb9.toString());
                    TextView access$4005 = paytmSavedCardActivity.mTextBalanceRemaining;
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(paytmSavedCardActivity.getResources().getString(i2));
                    C1073dl.a();
                    sb10.append(C1073dl.b().get("CC").getTxnAmount());
                    access$4005.setText(sb10.toString());
                    TextView access$700 = paytmSavedCardActivity.mSeriveChargeLabel;
                    Resources resources3 = paytmSavedCardActivity.getResources();
                    int i3 = C0787as.payment_charges_card;
                    access$700.setText(resources3.getString(i3));
                    paytmSavedCardActivity.mServiceCharge.setVisibility(8);
                    paytmSavedCardActivity.mTextTotal.setVisibility(8);
                    paytmSavedCardActivity.mTotalAmountLabel.setVisibility(8);
                    paytmSavedCardActivity.mTextbalanceRemainingLabel.setVisibility(8);
                    paytmSavedCardActivity.mTextBalanceRemaining.setVisibility(8);
                    paytmSavedCardActivity.mSeriveChargeLabel.setText(paytmSavedCardActivity.getResources().getString(i3));
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    TextView access$0004 = paytmSavedCardActivity.mServiceCharge;
                    StringBuilder sb11 = new StringBuilder();
                    Resources resources4 = paytmSavedCardActivity.getResources();
                    int i4 = C0787as.paytm_rs;
                    sb11.append(resources4.getString(i4));
                    C1073dl.a();
                    sb11.append(C1073dl.b().get("DEFAULTFEE").getFee());
                    access$0004.setText(sb11.toString());
                    TextView access$1005 = paytmSavedCardActivity.mTextTotal;
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append(paytmSavedCardActivity.getString(i4));
                    C1073dl.a();
                    sb12.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
                    access$1005.setText(sb12.toString());
                    TextView access$4006 = paytmSavedCardActivity.mTextBalanceRemaining;
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(paytmSavedCardActivity.getResources().getString(i4));
                    C1073dl.a();
                    sb13.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
                    access$4006.setText(sb13.toString());
                } else {
                    TextView access$1006 = paytmSavedCardActivity.mTextTotal;
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append(paytmSavedCardActivity.getString(C0787as.paytm_rs));
                    lf.x(sb14, C1073dl.a().f5445a, access$1006);
                }
                paytmSavedCardActivity.updateBanks(paytmSavedCardActivity.mBankArrayListmerchant, paytmSavedCardActivity.mFastForwardBanksmerchant);
            }
            paytmSavedCardActivity.setDynamicPermissions();
        }
    }

    public class h implements CompoundButton.OnCheckedChangeListener {
        public h() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PaytmSavedCardActivity.this.resizeCardlayout(z);
        }
    }

    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PaytmSavedCardActivity.this.resizeNBlayout(z);
        }
    }

    public class j implements CompoundButton.OnCheckedChangeListener {
        public j() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PaytmSavedCardActivity.this.resizesavedcardlayout(z);
        }
    }

    public class k implements View.OnFocusChangeListener {
        public k() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                PaytmSavedCardActivity paytmSavedCardActivity = PaytmSavedCardActivity.this;
                if (paytmSavedCardActivity.mCheckUseWallet.isChecked()) {
                    if (C0709Uj.u("PPI")) {
                        paytmSavedCardActivity.changeServiceCharge("PPI");
                    } else if (C0709Uj.u("DEFAULTFEE")) {
                        paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
                    }
                } else if (C0709Uj.u("CC")) {
                    paytmSavedCardActivity.changeServiceCharge("CC");
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
                }
            }
        }
    }

    public class l implements View.OnLongClickListener {
        public final boolean onLongClick(View view) {
            return true;
        }
    }

    public class m implements View.OnFocusChangeListener {
        public m() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                PaytmSavedCardActivity paytmSavedCardActivity = PaytmSavedCardActivity.this;
                if (paytmSavedCardActivity.mCheckUseWallet.isChecked()) {
                    if (C0709Uj.u("PPI")) {
                        paytmSavedCardActivity.changeServiceCharge("PPI");
                    } else if (C0709Uj.u("DEFAULTFEE")) {
                        paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
                    }
                } else if (C0709Uj.u("CC")) {
                    paytmSavedCardActivity.changeServiceCharge("CC");
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
                }
            }
        }
    }

    public class n implements View.OnLongClickListener {
        public final boolean onLongClick(View view) {
            return true;
        }
    }

    public enum p {
    }

    public class q implements ViewPager.j {
        public q() {
        }
    }

    /* access modifiers changed from: private */
    public void RefreshTablelayout(ArrayList<C1145h2> arrayList) {
        TableRow tableRow;
        if (arrayList == null || !arrayList.isEmpty()) {
            int childCount = this.gridview.getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.gridview.getChildAt(i3);
                if ((childAt instanceof TableRow) && (tableRow = (TableRow) childAt) != null) {
                    int childCount2 = tableRow.getChildCount();
                    for (int i4 = 0; i4 < childCount2; i4++) {
                        View childAt2 = tableRow.getChildAt(i4);
                        if (childAt2 != null && (childAt2 instanceof RelativeLayout)) {
                            getView(i2, childAt2, arrayList);
                        }
                        i2++;
                    }
                }
            }
        }
    }

    private boolean checkFirstTwoDigitForMaestro(String str) {
        int parseInt;
        if (str.length() < 2 || (parseInt = Integer.parseInt(str.substring(0, 2))) < 58 || parseInt > 62) {
            return false;
        }
        return true;
    }

    private int getCVVCheckDigit(int i2) {
        Integer num = cardCvv.get(Integer.valueOf(i2));
        if (num == null) {
            return 3;
        }
        return num.intValue();
    }

    /* access modifiers changed from: private */
    public String getCardNumber(String str) {
        return str.replaceAll(" ", "");
    }

    /* access modifiers changed from: private */
    public p getCardType(String str) {
        return getCardTypeName(str);
    }

    private p getCardTypeName(String str) {
        String[] strArr = {"^(5018|5020|5038|5612|5893|6304|6759|676[1-3]|0604|6220|6390|6002).*", "^4.*", "^5[1-5].*", "^(36|38|30[0-5]).*", "^35.*", "^(6011|65|64[4-9]|622[1-9]).*", "^3[47].*", ".*", ".*"};
        for (int i2 = 0; i2 < PaytmPaymentActivity.t.values().length; i2++) {
            if (i2 == 7) {
                if (TB.a(str.substring(0, Math.min(str.length(), 6)))) {
                    setCardTypeImage(i2);
                    return p.values()[i2];
                }
            } else if (i2 != 0 || !checkFirstTwoDigitForMaestro(str)) {
                if (Pattern.compile(strArr[i2], 2).matcher(str).matches()) {
                    setCardTypeImage(i2);
                    return p.values()[i2];
                }
            } else if (TB.a(str)) {
                setCardTypeImage(7);
                return p.values()[7];
            } else {
                setCardTypeImage(i2);
                return p.values()[i2];
            }
        }
        return p.values()[8];
    }

    private void initializeCVVCheck() {
        cardCvv.put(0, 0);
        cardCvv.put(6, 4);
        cardCvv.put(0, 3);
    }

    private void proceedToPayViaCardDetails() {
        try {
            this.isSavedCard = false;
            String cardNumber = getCardNumber(this.mCardNumberEditText.getText().toString());
            String obj = this.mCVVNumberEditText.getText().toString();
            String obj2 = this.mMonthSpinner.getSelectedItem().toString();
            String obj3 = this.mYearSpinner.getSelectedItem().toString();
            if (this.selectedCard == 0) {
                if (obj2.equalsIgnoreCase("MM")) {
                    obj2 = "";
                }
                if (obj3.equalsIgnoreCase("YY")) {
                    obj3 = "";
                }
            }
            new C1176ie(this, "CUST_ID=" + URLEncoder.encode(C1073dl.a().f5446a.get("CUST_ID"), "UTF-8") + "&MID=" + URLEncoder.encode(C1073dl.a().f5446a.get("MID"), "UTF-8") + "&CARD_EXPIRY_YEAR=" + URLEncoder.encode(obj3, "UTF-8") + "&CARD_EXPIRY_MONTH=" + URLEncoder.encode(obj2, "UTF-8") + "&CARD_NUMBER=" + URLEncoder.encode(cardNumber, "UTF-8") + "&CVV=" + URLEncoder.encode(obj, "UTF-8")).execute(new String[]{"jsonobject"});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void removeSavedCardLayout(boolean z) {
        int i2;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById(C0501Er.line_card_netbanking).setVisibility(i2);
        findViewById(C0501Er.saved_card_header).setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public void resizeCardlayout(boolean z) {
        if (z) {
            ((TextView) findViewById(C0501Er.txt_card_header_title)).setTypeface((Typeface) null, 1);
            ((TextView) findViewById(C0501Er.txt_use_saved_card)).setTypeface((Typeface) null, 0);
            ((TextView) findViewById(C0501Er.txt_net_banking_header_title)).setTypeface((Typeface) null, 0);
            findViewById(C0501Er.rel_card_expand_layout).setVisibility(0);
            findViewById(C0501Er.rel_powered_by).setVisibility(0);
            this.mNBLayout.setVisibility(8);
            this.pager.setVisibility(8);
            this.resizeNBLayoutCB.setChecked(false);
            this.resizesavedcardCB.setChecked(false);
            if (this.mCheckUseWallet.isChecked()) {
                clearAll(this.mFastForwardBanksPaytm);
            } else {
                clearAll(this.mFastForwardBanksmerchant);
            }
            resetBankSpinner();
            changeServiceCharge("CC");
            return;
        }
        findViewById(C0501Er.rel_card_expand_layout).setVisibility(8);
        findViewById(C0501Er.rel_powered_by).setVisibility(8);
        ((TextView) findViewById(C0501Er.txt_card_header_title)).setTypeface((Typeface) null, 0);
    }

    /* access modifiers changed from: private */
    public void resizeNBlayout(boolean z) {
        if (z) {
            ((TextView) findViewById(C0501Er.txt_card_header_title)).setTypeface((Typeface) null, 0);
            ((TextView) findViewById(C0501Er.txt_use_saved_card)).setTypeface((Typeface) null, 0);
            ((TextView) findViewById(C0501Er.txt_net_banking_header_title)).setTypeface((Typeface) null, 1);
            this.mNBLayout.setVisibility(0);
            findViewById(C0501Er.rel_card_expand_layout).setVisibility(8);
            this.pager.setVisibility(8);
            this.resizeCardlayoutCB.setChecked(false);
            this.resizesavedcardCB.setChecked(false);
            changeServiceCharge("NB-NA");
            return;
        }
        this.mNBLayout.setVisibility(8);
        ((TextView) findViewById(C0501Er.txt_net_banking_header_title)).setTypeface((Typeface) null, 0);
        if (this.mCheckUseWallet.isChecked()) {
            clearAll(this.mFastForwardBanksPaytm);
        } else {
            clearAll(this.mFastForwardBanksmerchant);
        }
        resetBankSpinner();
    }

    /* access modifiers changed from: private */
    public void resizesavedcardlayout(boolean z) {
        if (z) {
            ((TextView) findViewById(C0501Er.txt_card_header_title)).setTypeface((Typeface) null, 0);
            ((TextView) findViewById(C0501Er.txt_use_saved_card)).setTypeface((Typeface) null, 1);
            ((TextView) findViewById(C0501Er.txt_net_banking_header_title)).setTypeface((Typeface) null, 0);
            this.pager.setVisibility(0);
            findViewById(C0501Er.rel_card_expand_layout).setVisibility(8);
            this.mNBLayout.setVisibility(8);
            this.resizeCardlayoutCB.setChecked(false);
            this.resizeNBLayoutCB.setChecked(false);
            return;
        }
        this.pager.setVisibility(8);
        ((TextView) findViewById(C0501Er.txt_use_saved_card)).setTypeface((Typeface) null, 0);
    }

    private void setCVVTextwatcher() {
        this.mCVVNumberEditText.addTextChangedListener(new e());
    }

    private void setCardTypeImage(int i2) {
        switch (i2) {
            case 0:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1502yr.maestro_icon, 0);
                this.selectedCard = 0;
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(22)});
                return;
            case 1:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1502yr.visa_icon, 0);
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                this.selectedCard = 1;
                return;
            case 2:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1502yr.master_icon, 0);
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                this.selectedCard = 2;
                return;
            case 3:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1502yr.diners, 0);
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                this.selectedCard = 3;
                return;
            case 4:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1502yr.jcb, 0);
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                this.selectedCard = 4;
                return;
            case 6:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1502yr.amex, 0);
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
                this.selectedCard = 6;
                return;
            case 7:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1502yr.card_rupay_normal, 0);
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                this.selectedCard = 7;
                return;
            case 8:
                this.mCardNumberEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.mCardNumberEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                this.selectedCard = 8;
                return;
            default:
                return;
        }
    }

    private void setCellClickListener(View view, ArrayList<C1145h2> arrayList) {
        view.setOnClickListener(new f(arrayList));
    }

    private void setItemSelectListener(Spinner spinner, ArrayList<C1145h2> arrayList, ArrayList<C1145h2> arrayList2) {
        spinner.setOnItemSelectedListener(new c(arrayList, arrayList2));
    }

    private void setMonthAdapter() {
        this.mMonthSpinner.setAdapter(new ArrayAdapter(this, C0697Tr.date_spinner, getResources().getStringArray(Yq.month_array)));
    }

    private void setSpinnerSelectListener(Spinner spinner) {
        spinner.setOnItemSelectedListener(new d());
    }

    private void setTableGridadapter(ArrayList<C1145h2> arrayList) {
        if (this.gridview.getChildCount() > 0) {
            this.gridview.removeAllViews();
        }
        if (arrayList.size() > 0) {
            double ceil = Math.ceil((double) (((float) arrayList.size()) / 3.0f));
            int i2 = 0;
            for (int i3 = 0; ((double) i3) <= ceil; i3++) {
                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new TableRow.LayoutParams(-1, -2));
                tableRow.setBackgroundColor(0);
                for (int i4 = 0; i4 < 3 && i2 < arrayList.size(); i4++) {
                    tableRow.addView(getView(i2, this.inflater.inflate(C0697Tr.bank_grid_item, (ViewGroup) null), arrayList));
                    i2++;
                }
                this.gridview.addView(tableRow);
            }
        }
    }

    private Spannable setWalletBalanceText(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = C0787as.use_paytm_wallet;
        sb.append(getString(i2));
        sb.append("\n ");
        sb.append(getString(C0787as.your_current_balance));
        String format = String.format(sb.toString(), new Object[]{str});
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(C1309or.text_grey_subdued)), getString(i2).length(), format.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), getString(i2).length(), format.length(), 33);
        return spannableString;
    }

    /* access modifiers changed from: private */
    public void updateBanks(ArrayList<C1145h2> arrayList, ArrayList<C1145h2> arrayList2) {
        setTableGridadapter(arrayList2);
        getResources();
        C1233l2 l2Var = new C1233l2(this, C0697Tr.bank_spinner, arrayList);
        this.adapter = l2Var;
        this.mBankSpinner.setAdapter(l2Var);
        if (arrayList.size() > 0) {
            setItemSelectListener(this.mBankSpinner, arrayList, arrayList2);
        }
    }

    private boolean validateCardData() {
        if (this.selectedCard == 0) {
            if (TextUtils.isEmpty(getCardNumber(this.mCardNumberEditText.getText().toString()))) {
                this.errorCard.setText(getString(C0787as.empty_card_no));
                this.errorCard.setVisibility(0);
                return false;
            } else if (!luhnCheck(getCardNumber(this.mCardNumberEditText.getText().toString()))) {
                this.errorCard.setText(getString(C0787as.invalid_card_no));
                this.errorCard.setVisibility(0);
                return false;
            } else {
                int i2 = this.selectedCard;
                if (i2 == 0 || getCVVCheckDigit(i2) == lf.e(this.mCVVNumberEditText)) {
                    return true;
                }
                this.errorCVV.setText(getString(C0787as.error_cvv));
                this.errorCVV.setVisibility(0);
                return false;
            }
        } else if (TextUtils.isEmpty(getCardNumber(this.mCardNumberEditText.getText().toString()))) {
            this.errorCard.setText(getString(C0787as.empty_card_no));
            this.errorCard.setVisibility(0);
            return false;
        } else if (!luhnCheck(getCardNumber(this.mCardNumberEditText.getText().toString()))) {
            this.errorCard.setText(getString(C0787as.invalid_card_no));
            this.errorCard.setVisibility(0);
            return false;
        } else if (!validateExpiry()) {
            this.errorDate.setVisibility(0);
            return false;
        } else if (getCVVCheckDigit(this.selectedCard) == lf.e(this.mCVVNumberEditText)) {
            return true;
        } else {
            this.errorCVV.setText(getString(C0787as.error_cvv));
            this.errorCVV.setVisibility(0);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void zoomOutPagerAnimation(View view, float f2) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f2 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f2 <= 1.0f) {
            float max = Math.max(0.85f, 1.0f - Math.abs(f2));
            float f3 = 1.0f - max;
            float f4 = (((float) height) * f3) / 2.0f;
            float f5 = (((float) width) * f3) / 2.0f;
            if (f2 < 0.0f) {
                view.setTranslationX(f5 - (f4 / 2.0f));
            } else {
                view.setTranslationX((f4 / 2.0f) + (-f5));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            view.setAlpha((((max - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
        } else {
            view.setAlpha(0.0f);
        }
    }

    public void OnBankListFetchResponse(String str) {
        if (str != null && !TextUtils.isEmpty(str) && this.mDBoperation != null) {
            if (this.currentDownloadingBank == C1470x1.PAYTM) {
                C1168i2.a(str, "PAYTM");
                parseBankListResponse(str, this.mBankArrayListPaytm, this.mFastForwardBanksPaytm);
                fetchBankList(C1073dl.a().f5446a.get("MID"));
                return;
            }
            C1168i2.a(str, "IRCTC");
            parseBankListResponse(str, this.mBankArrayListmerchant, this.mFastForwardBanksmerchant);
            this.mCheckUseWallet.setChecked(true);
        }
    }

    public void changeServiceCharge(String str) {
        if (this.mCheckUseWallet.isChecked()) {
            str = "PPI";
        }
        C1073dl.a();
        if (C1073dl.b().get(str) != null) {
            C1073dl.a();
            String fee = C1073dl.b().get(str).getFee();
            Double valueOf = Double.valueOf(Double.parseDouble(fee));
            Double valueOf2 = Double.valueOf(valueOf.doubleValue() + Double.parseDouble(C1073dl.a().f5445a));
            C1073dl.a().getClass();
            C1073dl.a().getClass();
            C1073dl a2 = C1073dl.a();
            a2.f5447b = "" + valueOf2;
            TextView textView = this.mTextTotal;
            StringBuilder sb = new StringBuilder();
            int i2 = C0787as.paytm_rs;
            sb.append(getString(i2));
            C1073dl.a();
            sb.append(C1073dl.b().get(str).getTxnAmount());
            textView.setText(sb.toString());
            TextView textView2 = this.mServiceCharge;
            textView2.setText(getResources().getString(i2) + fee);
            if (str.equalsIgnoreCase("NB-NA")) {
                this.mSeriveChargeLabel.setText(getResources().getString(C0787as.payment_charges_net_banking));
                this.mServiceCharge.setVisibility(8);
                this.mTextTotal.setVisibility(8);
                this.mTotalAmountLabel.setVisibility(8);
                this.mTextbalanceRemainingLabel.setVisibility(8);
                this.mTextBalanceRemaining.setVisibility(8);
            } else if (str.equalsIgnoreCase("CC") || str.equalsIgnoreCase("DC")) {
                TextView textView3 = this.mSeriveChargeLabel;
                Resources resources = getResources();
                int i3 = C0787as.payment_charges_card;
                textView3.setText(resources.getString(i3));
                this.mServiceCharge.setVisibility(8);
                this.mTextTotal.setVisibility(8);
                this.mTotalAmountLabel.setVisibility(8);
                this.mTextbalanceRemainingLabel.setVisibility(8);
                this.mTextBalanceRemaining.setVisibility(8);
                this.mSeriveChargeLabel.setText(getResources().getString(i3));
            } else if (str.equalsIgnoreCase("PPI")) {
                this.mSeriveChargeLabel.setText(getResources().getString(C0787as.payment_charges_wallet));
                this.mServiceCharge.setVisibility(0);
                this.mTextTotal.setVisibility(0);
                this.mTotalAmountLabel.setVisibility(0);
            }
        }
    }

    public void clearAll(ArrayList<C1145h2> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).a = false;
        }
        RefreshTablelayout(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e0, code lost:
        if (r16 > (r3.a + 86400000)) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0045, code lost:
        if (r16 > (r2.a + 86400000)) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fetchBankList(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            java.lang.String r2 = "INDUSTRY_TYPE_ID"
            java.lang.String r3 = "Retail"
            java.lang.String r4 = "scwpay09224240900570"
            boolean r4 = r0.equalsIgnoreCase(r4)
            java.lang.String r6 = "/HANDLER_INTERNAL/BANK_LIST?"
            r7 = 1
            java.lang.String r8 = "CHANNEL"
            java.lang.String r9 = "INDUSTRY"
            r10 = 86400000(0x5265c00, double:4.2687272E-316)
            r12 = 0
            java.lang.String r13 = "MID"
            java.lang.String r14 = "CHANNEL_ID"
            java.lang.String r15 = "JsonData="
            if (r4 == 0) goto L_0x00bb
            x1 r2 = defpackage.C1470x1.PAYTM
            r1.currentDownloadingBank = r2
            i2 r2 = r1.mDBoperation
            r2.getClass()
            java.lang.String r2 = "PAYTM"
            i2$a r2 = defpackage.C1168i2.b(r2)
            long r16 = java.lang.System.currentTimeMillis()
            if (r2 == 0) goto L_0x0053
            java.lang.String r4 = r2.f5483a
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0048
            r18 = r6
            long r5 = r2.a
            long r5 = r5 + r10
            int r5 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0048
            goto L_0x0055
        L_0x0048:
            java.lang.String r0 = r2.f5483a
            java.util.ArrayList<h2> r2 = r1.mBankArrayListPaytm
            java.util.ArrayList<h2> r3 = r1.mFastForwardBanksPaytm
            r1.parseBankListResponse(r0, r2, r3)
            goto L_0x017c
        L_0x0053:
            r18 = r6
        L_0x0055:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x009e }
            r2.<init>()     // Catch:{ Exception -> 0x009e }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x009e }
            if (r5 != 0) goto L_0x0063
            r2.put(r9, r3)     // Catch:{ Exception -> 0x009e }
        L_0x0063:
            dl r3 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x009e }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r3 = r3.f5446a     // Catch:{ Exception -> 0x009e }
            if (r3 == 0) goto L_0x008d
            r2.put(r13, r0)     // Catch:{ Exception -> 0x009e }
            dl r0 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x009e }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r0 = r0.f5446a     // Catch:{ Exception -> 0x009e }
            java.lang.Object r0 = r0.get(r14)     // Catch:{ Exception -> 0x009e }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x009e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x009e }
            if (r0 != 0) goto L_0x008d
            dl r0 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x009e }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r0 = r0.f5446a     // Catch:{ Exception -> 0x009e }
            java.lang.Object r0 = r0.get(r14)     // Catch:{ Exception -> 0x009e }
            r2.put(r8, r0)     // Catch:{ Exception -> 0x009e }
        L_0x008d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e }
            r0.<init>(r15)     // Catch:{ Exception -> 0x009e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009e }
            r0.append(r2)     // Catch:{ Exception -> 0x009e }
            java.lang.String r12 = r0.toString()     // Catch:{ Exception -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a2:
            Yb r0 = new Yb
            r0.<init>(r1, r12)
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r3 = defpackage.C1488xu.i()
            r5 = r18
            java.lang.String r3 = r3.concat(r5)
            r4 = 0
            r2[r4] = r3
            r0.execute(r2)
            goto L_0x017c
        L_0x00bb:
            r5 = r6
            x1 r3 = defpackage.C1470x1.IRCTC
            r1.currentDownloadingBank = r3
            i2 r3 = r1.mDBoperation
            r3.getClass()
            java.lang.String r3 = "IRCTC"
            i2$a r3 = defpackage.C1168i2.b(r3)
            long r16 = java.lang.System.currentTimeMillis()
            if (r3 == 0) goto L_0x00ee
            java.lang.String r6 = r3.f5483a
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x00e3
            r18 = r5
            long r4 = r3.a
            long r4 = r4 + r10
            int r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e3
            goto L_0x00f0
        L_0x00e3:
            java.lang.String r0 = r3.f5483a
            java.util.ArrayList<h2> r2 = r1.mBankArrayListmerchant
            java.util.ArrayList<h2> r3 = r1.mFastForwardBanksmerchant
            r1.parseBankListResponse(r0, r2, r3)
            goto L_0x017c
        L_0x00ee:
            r18 = r5
        L_0x00f0:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0161 }
            r3.<init>()     // Catch:{ Exception -> 0x0161 }
            dl r4 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x0161 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r4 = r4.f5446a     // Catch:{ Exception -> 0x0161 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ Exception -> 0x0161 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0161 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0161 }
            if (r4 != 0) goto L_0x0114
            dl r4 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x0161 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r4 = r4.f5446a     // Catch:{ Exception -> 0x0161 }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ Exception -> 0x0161 }
            r3.put(r9, r2)     // Catch:{ Exception -> 0x0161 }
        L_0x0114:
            dl r2 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x0161 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r2 = r2.f5446a     // Catch:{ Exception -> 0x0161 }
            if (r2 == 0) goto L_0x0150
            dl r2 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x0161 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r2 = r2.f5446a     // Catch:{ Exception -> 0x0161 }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ Exception -> 0x0161 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x0161 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0161 }
            if (r2 != 0) goto L_0x0131
            r3.put(r13, r0)     // Catch:{ Exception -> 0x0161 }
        L_0x0131:
            dl r0 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x0161 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r0 = r0.f5446a     // Catch:{ Exception -> 0x0161 }
            java.lang.Object r0 = r0.get(r14)     // Catch:{ Exception -> 0x0161 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x0161 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0161 }
            if (r0 != 0) goto L_0x0150
            dl r0 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x0161 }
            java.util.LinkedHashMap<java.lang.String, java.lang.String> r0 = r0.f5446a     // Catch:{ Exception -> 0x0161 }
            java.lang.Object r0 = r0.get(r14)     // Catch:{ Exception -> 0x0161 }
            r3.put(r8, r0)     // Catch:{ Exception -> 0x0161 }
        L_0x0150:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0161 }
            r0.<init>(r15)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0161 }
            r0.append(r2)     // Catch:{ Exception -> 0x0161 }
            java.lang.String r12 = r0.toString()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0165
        L_0x0161:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0165:
            Yb r0 = new Yb
            r0.<init>(r1, r12)
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r3 = defpackage.C1488xu.i()
            r4 = r18
            java.lang.String r3 = r3.concat(r4)
            r4 = 0
            r2[r4] = r3
            r0.execute(r2)
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.sdknative.PaytmSavedCardActivity.fetchBankList(java.lang.String):void");
    }

    public void fetchSavedCard() {
        new C1310ov(this, new ResponseSavedCardBin(), this, this.savedCardRequestProvider, 1).execute(new String[0]);
    }

    public C1145h2 getSelectedBank(ArrayList<C1145h2> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            C1145h2 h2Var = arrayList.get(i2);
            if (h2Var.a) {
                return h2Var;
            }
        }
        return null;
    }

    public View getView(int i2, View view, ArrayList<C1145h2> arrayList) {
        view.setTag(Integer.valueOf(i2));
        ImageView imageView = (ImageView) view.findViewById(C0501Er.img_bank);
        CheckBox checkBox = (CheckBox) view.findViewById(C0501Er.check_bank);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C0501Er.bank_grid_parent_rl);
        setCellClickListener(relativeLayout, arrayList);
        checkBox.setChecked(arrayList.get(i2).a);
        checkBox.setEnabled(false);
        relativeLayout.setTag(Integer.valueOf(i2));
        imageView.setTag(Integer.valueOf(i2));
        checkBox.setTag(Integer.valueOf(i2));
        if (arrayList.get(i2).c.equalsIgnoreCase("ICICI")) {
            imageView.setImageResource(C1502yr.icici_bank_logo);
        } else if (arrayList.get(i2).c.equalsIgnoreCase("HDFC")) {
            imageView.setImageResource(C1502yr.hdfc_bank_logo);
        } else if (arrayList.get(i2).c.equalsIgnoreCase("HSBC")) {
            imageView.setImageResource(C1502yr.hsbc_logo);
        } else if (arrayList.get(i2).c.equalsIgnoreCase("SBI")) {
            imageView.setImageResource(C1502yr.sbi_logo);
        } else if (arrayList.get(i2).c.equalsIgnoreCase("CITI")) {
            imageView.setImageResource(C1502yr.citibank_logo);
        } else if (arrayList.get(i2).c.equalsIgnoreCase("BOB")) {
            imageView.setImageResource(C1502yr.bank_of_baroda_logo);
        }
        return view;
    }

    public ResponseSavedCardBin.SavedCardBinDetails getmResponseSavedCardBin(int i2) {
        return this.mResponseSavedCardBin.savedCardBinDetailsArrayList.get(i2);
    }

    public void handleCCDCPayment(String str) {
        Intent intent = new Intent();
        intent.putExtra("token", str);
        if (this.mCheckUseWallet.isChecked()) {
            intent.putExtra("flow", "addPay");
        } else {
            intent.putExtra("flow", "normal");
        }
        intent.putExtra("type", "CC");
        intent.putExtra(PaymentConstants.Event.SCREEN, "insufficient");
        if (this.isSavedCard) {
            intent.putExtra("IS_SAVED_CARD", C0515Ga.AVLBLTY_ONLY);
        } else if (this.mCheckBoxStoreCard.isChecked()) {
            intent.putExtra("STORE_CARD", C0515Ga.AVLBLTY_ONLY);
        }
        setResult(-1, intent);
        finish();
    }

    public void handleNBPayment(String str) {
        Intent intent = new Intent();
        intent.putExtra("token", str);
        if (this.mCheckUseWallet.isChecked()) {
            intent.putExtra("flow", "addPay");
        } else {
            intent.putExtra("flow", "normal");
        }
        intent.putExtra("type", "NB");
        intent.putExtra("bank_code", str);
        intent.putExtra(PaymentConstants.Event.SCREEN, "insufficient");
        setResult(-1, intent);
        finish();
    }

    public boolean luhnCheck(String str) {
        int i2 = 0;
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (z && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i2 += parseInt;
            z = !z;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(PaymentConstants.Event.SCREEN, "mainscreen");
        setResult(-3, intent);
        finish();
    }

    public void onClick(View view) {
        C1145h2 h2Var;
        String str;
        if (view.getId() == C0501Er.bttn_proceed_to_pay_card) {
            if (validateCardData()) {
                proceedToPayViaCardDetails();
            }
        } else if (view.getId() == C0501Er.rel_month) {
            this.mMonthSpinner.performClick();
        } else if (view.getId() == C0501Er.rel_year) {
            this.mYearSpinner.performClick();
        } else if (view.getId() == C0501Er.bttn_proceed_to_pay_netbanking) {
            C1145h2 h2Var2 = this.selectedBank;
            if (this.mCheckUseWallet.isChecked()) {
                h2Var = getSelectedBank(this.mFastForwardBanksPaytm);
            } else {
                h2Var = getSelectedBank(this.mFastForwardBanksmerchant);
            }
            if (h2Var != null) {
                str = h2Var.c;
            } else if (h2Var2 == null || h2Var2.d.equalsIgnoreCase("OTHER")) {
                Toast.makeText(this, getString(C0787as.err_select_bank), 1).show();
                return;
            } else {
                str = h2Var2.c;
            }
            handleNBPayment(str);
        } else if (view.getId() == C0501Er.rel_net_banking_header) {
            CheckBox checkBox = this.resizeNBLayoutCB;
            checkBox.setChecked(!checkBox.isChecked());
        } else if (view == this.cardRelativeLayout) {
            CheckBox checkBox2 = this.resizeCardlayoutCB;
            checkBox2.setChecked(!checkBox2.isChecked());
        } else if (view == this.savedCardHeader) {
            CheckBox checkBox3 = this.resizesavedcardCB;
            checkBox3.setChecked(!checkBox3.isChecked());
        } else if (view.getId() == C0501Er.header_back_button) {
            Intent intent = new Intent();
            intent.putExtra(PaymentConstants.Event.SCREEN, "mainscreen");
            setResult(-3, intent);
            finish();
        } else if (view.getId() == C0501Er.rel_bank_spinner_parent) {
            showBankDialog();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0697Tr.activity_paytm_saved_card);
        this.inflater = (LayoutInflater) getSystemService("layout_inflater");
        if (C1168i2.f5481a == null) {
            C1168i2.f5481a = new C1168i2(this);
        }
        C1168i2 i2Var = C1168i2.f5481a;
        this.mDBoperation = i2Var;
        C1168i2.a = i2Var.f5482a.getWritableDatabase();
        this.mBankArrayListPaytm = new ArrayList<>();
        this.mFastForwardBanksPaytm = new ArrayList<>();
        this.mBankArrayListmerchant = new ArrayList<>();
        this.mFastForwardBanksmerchant = new ArrayList<>();
        initializeCVVCheck();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        this.mYearSpinner = (Spinner) findViewById(C0501Er.year_spinner);
        this.mMonthSpinner = (Spinner) findViewById(C0501Er.month_spinner);
        this.mFare = (TextView) findViewById(C0501Er.txt_amount_ticket_fare);
        this.mServiceCharge = (TextView) findViewById(C0501Er.txt_service_amount_ticket_fare);
        this.mSeriveChargeLabel = (TextView) findViewById(C0501Er.txt_service_ticket_fare);
        this.mTextTotal = (TextView) findViewById(C0501Er.txt_pay_amount);
        this.mTotalAmountLabel = (TextView) findViewById(C0501Er.txt_pay);
        this.mTextBalanceRemaining = (TextView) findViewById(C0501Er.txt_remaining_balance_amount);
        this.mTextbalanceRemainingLabel = (TextView) findViewById(C0501Er.txt_select_payment_method);
        this.mCheckUseWallet = (CheckBox) findViewById(C0501Er.check_use_paytm_wallet);
        int i2 = C0501Er.bttn_proceed_to_pay_card;
        this.mCardProceedButton = (Button) findViewById(i2);
        this.mNBProceedButton = (Button) findViewById(C0501Er.bttn_proceed_to_pay_netbanking);
        this.mCardNumberEditText = (EditText) findViewById(C0501Er.edit_enter_card_number);
        this.mCVVNumberEditText = (EditText) findViewById(C0501Er.edit_cvv);
        this.mMonthRelativelayout = (RelativeLayout) findViewById(C0501Er.rel_month);
        this.mYearRelativelayout = (RelativeLayout) findViewById(C0501Er.rel_year);
        this.mCardTypeImageView = (ImageView) findViewById(C0501Er.img_card_type);
        this.mCardProceedButton = (Button) findViewById(i2);
        this.mTextWalletAmount = (TextView) findViewById(C0501Er.txt_wallet_amount);
        this.cardRelativeLayout = (RelativeLayout) findViewById(C0501Er.rel_card_header);
        this.savedCardHeader = (RelativeLayout) findViewById(C0501Er.saved_card_header);
        this.mViewLineSavedCard = findViewById(C0501Er.line_used_card);
        this.mTextUseSavedCard = (TextView) findViewById(C0501Er.txt_use_saved_card);
        this.pager = (ViewPager) findViewById(C0501Er.pager);
        this.mCheckBoxStoreCard = (CheckBox) findViewById(C0501Er.check_store_card);
        int i3 = C0501Er.header_back_button;
        ImageView imageView = (ImageView) findViewById(i3);
        this.mBackIcon = imageView;
        int i4 = C1073dl.a;
        if (i4 > 0) {
            imageView.setImageResource(i4);
        }
        this.mBankSpinner = (Spinner) findViewById(C0501Er.bank_spinner);
        this.mNBLayout = (RelativeLayout) findViewById(C0501Er.rel_net_banking_expand_layout);
        this.mToggleRL = (RelativeLayout) findViewById(C0501Er.rel_net_banking_header);
        this.progressLoader = (ProgressBar) findViewById(C0501Er.progress_bar_paytmpayment);
        this.gridview = (TableLayout) findViewById(C0501Er.gridview);
        this.resizeCardlayoutCB = (CheckBox) findViewById(C0501Er.toggle_expand_contract);
        this.resizeNBLayoutCB = (CheckBox) findViewById(C0501Er.toggle_expand_contract_2);
        this.resizesavedcardCB = (CheckBox) findViewById(C0501Er.toggle_expand_contract_savedcard);
        this.errorDate = (TextView) findViewById(C0501Er.error_rel_year);
        this.errorCVV = (TextView) findViewById(C0501Er.error_edit_cvv);
        this.errorCard = (TextView) findViewById(C0501Er.error_card_number);
        this.relBankDialog = (RelativeLayout) findViewById(C0501Er.rel_bank_spinner_parent);
        C1073dl.a().getClass();
        TextView textView = this.mFare;
        StringBuilder sb = new StringBuilder();
        Resources resources = getResources();
        int i5 = C0787as.paytm_rs;
        sb.append(resources.getString(i5));
        sb.append(C1073dl.a().f5445a);
        textView.setText(sb.toString());
        String string = getResources().getString(C0787as.your_current_balance);
        String.format(string, new Object[]{getResources().getString(i5) + C1073dl.a().f5444a});
        this.mCheckUseWallet.setText(setWalletBalanceText(getResources().getString(i5) + C1073dl.a().f5444a));
        TextView textView2 = this.mTextWalletAmount;
        textView2.setText("-" + getResources().getString(i5) + C1073dl.a().f5444a);
        if (TextUtils.isEmpty(C1073dl.a().f5447b)) {
            this.mRemainingBalance = 0.0d;
        } else {
            this.mRemainingBalance = TB.d(Double.parseDouble(C1073dl.a().f5447b) - C1073dl.a().f5444a.doubleValue());
        }
        this.mCheckBoxStoreCard.setChecked(true);
        C1073dl.a();
        if (C1073dl.b().containsKey("PPI")) {
            TextView textView3 = this.mServiceCharge;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString(i5));
            C1073dl.a();
            sb2.append(C1073dl.b().get("PPI").getFee());
            textView3.setText(sb2.toString());
            this.mSeriveChargeLabel.setText(getResources().getString(C0787as.payment_charges_wallet));
            TextView textView4 = this.mTextTotal;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getString(i5));
            C1073dl.a();
            sb3.append(C1073dl.b().get("PPI").getTxnAmount());
            textView4.setText(sb3.toString());
            C1073dl.a();
            this.mRemainingBalance = TB.d(Double.parseDouble(C1073dl.b().get("PPI").getTxnAmount()) - C1073dl.a().f5444a.doubleValue());
            TextView textView5 = this.mTextBalanceRemaining;
            textView5.setText(getResources().getString(i5) + this.mRemainingBalance);
        } else if (C0709Uj.u("DEFAULTFEE")) {
            TextView textView6 = this.mServiceCharge;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(getResources().getString(i5));
            C1073dl.a();
            sb4.append(C1073dl.b().get("DEFAULTFEE").getFee());
            textView6.setText(sb4.toString());
            TextView textView7 = this.mTextTotal;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getString(i5));
            C1073dl.a();
            sb5.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
            textView7.setText(sb5.toString());
            C1073dl.a();
            this.mRemainingBalance = TB.d(Double.parseDouble(C1073dl.b().get("DEFAULTFEE").getTxnAmount()) - C1073dl.a().f5444a.doubleValue());
            TextView textView8 = this.mTextBalanceRemaining;
            textView8.setText(getResources().getString(i5) + this.mRemainingBalance);
        } else {
            TextView textView9 = this.mTextTotal;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(getString(i5));
            lf.x(sb6, C1073dl.a().f5445a, textView9);
        }
        if (this.mCheckUseWallet.isChecked()) {
            this.mServiceCharge.setVisibility(0);
            this.mTextTotal.setVisibility(0);
            this.mTotalAmountLabel.setVisibility(0);
            this.mTextbalanceRemainingLabel.setVisibility(0);
            this.mTextBalanceRemaining.setVisibility(0);
            C1073dl.a();
            if (C1073dl.b().containsKey("PPI")) {
                TextView textView10 = this.mServiceCharge;
                StringBuilder sb7 = new StringBuilder();
                sb7.append(getResources().getString(i5));
                C1073dl.a();
                sb7.append(C1073dl.b().get("PPI").getFee());
                textView10.setText(sb7.toString());
                this.mSeriveChargeLabel.setText(getResources().getString(C0787as.payment_charges_wallet));
                TextView textView11 = this.mTextTotal;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(getString(i5));
                C1073dl.a();
                sb8.append(C1073dl.b().get("PPI").getTxnAmount());
                textView11.setText(sb8.toString());
                C1073dl.a();
                this.mRemainingBalance = TB.d(Double.parseDouble(C1073dl.b().get("PPI").getTxnAmount()) - C1073dl.a().f5444a.doubleValue());
                TextView textView12 = this.mTextBalanceRemaining;
                textView12.setText(getResources().getString(i5) + this.mRemainingBalance);
            } else if (C0709Uj.u("DEFAULTFEE")) {
                TextView textView13 = this.mServiceCharge;
                StringBuilder sb9 = new StringBuilder();
                sb9.append(getResources().getString(i5));
                C1073dl.a();
                sb9.append(C1073dl.b().get("DEFAULTFEE").getFee());
                textView13.setText(sb9.toString());
                TextView textView14 = this.mTextTotal;
                StringBuilder sb10 = new StringBuilder();
                sb10.append(getString(i5));
                C1073dl.a();
                sb10.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
                textView14.setText(sb10.toString());
                C1073dl.a();
                this.mRemainingBalance = TB.d(Double.parseDouble(C1073dl.b().get("DEFAULTFEE").getTxnAmount()) - C1073dl.a().f5444a.doubleValue());
                TextView textView15 = this.mTextBalanceRemaining;
                textView15.setText(getResources().getString(i5) + this.mRemainingBalance);
            } else {
                TextView textView16 = this.mTextTotal;
                StringBuilder sb11 = new StringBuilder();
                sb11.append(getString(i5));
                lf.x(sb11, C1073dl.a().f5445a, textView16);
            }
        } else {
            this.mServiceCharge.setVisibility(8);
            this.mTextTotal.setVisibility(8);
            this.mTotalAmountLabel.setVisibility(8);
            this.mTextbalanceRemainingLabel.setVisibility(8);
            this.mTextBalanceRemaining.setVisibility(8);
            C1073dl.a();
            if (C1073dl.b().containsKey("CC")) {
                TextView textView17 = this.mServiceCharge;
                StringBuilder sb12 = new StringBuilder();
                sb12.append(getResources().getString(i5));
                C1073dl.a();
                sb12.append(C1073dl.b().get("CC").getFee());
                textView17.setText(sb12.toString());
                TextView textView18 = this.mTextTotal;
                StringBuilder sb13 = new StringBuilder();
                sb13.append(getString(i5));
                C1073dl.a();
                sb13.append(C1073dl.b().get("CC").getTxnAmount());
                textView18.setText(sb13.toString());
                TextView textView19 = this.mTextBalanceRemaining;
                StringBuilder sb14 = new StringBuilder();
                sb14.append(getResources().getString(i5));
                C1073dl.a();
                sb14.append(C1073dl.b().get("CC").getTxnAmount());
                textView19.setText(sb14.toString());
                TextView textView20 = this.mSeriveChargeLabel;
                Resources resources2 = getResources();
                int i6 = C0787as.payment_charges_card;
                textView20.setText(resources2.getString(i6));
                this.mServiceCharge.setVisibility(8);
                this.mTextTotal.setVisibility(8);
                this.mTotalAmountLabel.setVisibility(8);
                this.mTextbalanceRemainingLabel.setVisibility(8);
                this.mTextBalanceRemaining.setVisibility(8);
                this.mSeriveChargeLabel.setText(getResources().getString(i6));
            } else if (C0709Uj.u("DEFAULTFEE")) {
                TextView textView21 = this.mServiceCharge;
                StringBuilder sb15 = new StringBuilder();
                sb15.append(getResources().getString(i5));
                C1073dl.a();
                sb15.append(C1073dl.b().get("DEFAULTFEE").getFee());
                textView21.setText(sb15.toString());
                TextView textView22 = this.mTextTotal;
                StringBuilder sb16 = new StringBuilder();
                sb16.append(getString(i5));
                C1073dl.a();
                sb16.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
                textView22.setText(sb16.toString());
                TextView textView23 = this.mTextBalanceRemaining;
                StringBuilder sb17 = new StringBuilder();
                sb17.append(getResources().getString(i5));
                C1073dl.a();
                sb17.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
                textView23.setText(sb17.toString());
            } else {
                TextView textView24 = this.mTextTotal;
                StringBuilder sb18 = new StringBuilder();
                sb18.append(getString(i5));
                lf.x(sb18, C1073dl.a().f5445a, textView24);
            }
        }
        fetchSavedCard();
        setYearAdapter();
        this.mCardProceedButton.setOnClickListener(this);
        this.mMonthRelativelayout.setOnClickListener(this);
        this.mYearRelativelayout.setOnClickListener(this);
        this.cardRelativeLayout.setOnClickListener(this);
        this.savedCardHeader.setOnClickListener(this);
        this.mCheckUseWallet.setOnCheckedChangeListener(new g());
        this.mCardNumberEditText.addTextChangedListener(new r());
        setCVVTextwatcher();
        this.mToggleRL.setOnClickListener(this);
        this.mCardProceedButton.setOnClickListener(this);
        this.mNBProceedButton.setOnClickListener(this);
        this.mMonthRelativelayout.setOnClickListener(this);
        this.mYearRelativelayout.setOnClickListener(this);
        this.relBankDialog.setOnClickListener(this);
        setSpinnerSelectListener(this.mMonthSpinner);
        setSpinnerSelectListener(this.mYearSpinner);
        this.resizeCardlayoutCB.setOnCheckedChangeListener(new h());
        this.resizeNBLayoutCB.setOnCheckedChangeListener(new i());
        this.resizesavedcardCB.setOnCheckedChangeListener(new j());
        this.mCardNumberEditText.setOnFocusChangeListener(new k());
        this.mCardNumberEditText.setOnLongClickListener(new l());
        this.mCVVNumberEditText.setOnFocusChangeListener(new m());
        this.mCVVNumberEditText.setOnLongClickListener(new n());
        getMerchantData();
        setYearAdapter();
        setMonthAdapter();
        fetchBankList("scwpay09224240900570");
        ImageView imageView2 = (ImageView) findViewById(i3);
        this.mBackButton = imageView2;
        imageView2.setOnClickListener(this);
        this.mBackIcon.setOnClickListener(this);
        this.mCardNumberEditText.setCustomSelectionActionModeCallback(new o());
    }

    public void onDestroy() {
        super.onDestroy();
        C1310ov.c();
    }

    public void onPostResponse(String str) {
    }

    public void onTokenGenerateCallback(String str) {
        handleCCDCPayment(str);
    }

    public void parseBankListResponse(String str, ArrayList<C1145h2> arrayList, ArrayList<C1145h2> arrayList2) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("BANK_LIST");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                C1145h2 h2Var = new C1145h2();
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                h2Var.c = jSONObject.getString("BANK_CODE");
                h2Var.d = jSONObject.getString("BANK_NAME");
                jSONObject.getBoolean("IS_ATM");
                if (!h2Var.c.equalsIgnoreCase("ICICI") && !h2Var.c.equalsIgnoreCase("HDFC") && !h2Var.c.equalsIgnoreCase("SBI") && !h2Var.c.equalsIgnoreCase("HSBC") && !h2Var.c.equalsIgnoreCase("CITI")) {
                    if (!h2Var.c.equalsIgnoreCase("BOB")) {
                        arrayList.add(h2Var);
                    }
                }
                arrayList2.add(h2Var);
            }
            Collections.sort(arrayList);
            C1145h2 h2Var2 = new C1145h2();
            h2Var2.d = "OTHER";
            arrayList.add(0, h2Var2);
            updateBanks(arrayList, arrayList2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void parsePostConvenienceResponse(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("paymentCharges");
            jSONObject.keys();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Iterator<String> keys = jSONObject2.keys();
                String str = "";
                while (keys.hasNext()) {
                    str = keys.next();
                }
                JSONObject jSONObject3 = jSONObject2.getJSONArray(str).getJSONObject(0);
                PostConvenienceModal postConvenienceModal = new PostConvenienceModal();
                postConvenienceModal.setKey(str);
                postConvenienceModal.setTxnAmount(jSONObject3.getString("txnAmount"));
                postConvenienceModal.setBaseAmount(jSONObject3.getString("baseAmount"));
                postConvenienceModal.setFee(jSONObject3.getString("fee"));
                postConvenienceModal.setText(jSONObject3.getString("text"));
                C1073dl.a();
                C1073dl.b().put(str, postConvenienceModal);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void postHttpError(BaseResponseModal baseResponseModal) {
        if (baseResponseModal != null && (baseResponseModal instanceof ResponseSavedCardBin)) {
            this.resizesavedcardCB.setChecked(false);
        }
    }

    public void proceedToPayViaSavedCardDetails(String str, String str2) {
        try {
            this.isSavedCard = true;
            getCardNumber(this.mCardNumberEditText.getText().toString());
            this.mCVVNumberEditText.getText().toString();
            this.mMonthSpinner.getSelectedItem().toString();
            this.mYearSpinner.getSelectedItem().toString();
            new C1176ie(this, "CUST_ID=" + URLEncoder.encode(C1073dl.a().f5446a.get("CUST_ID"), "UTF-8") + "&MID=" + URLEncoder.encode(C1073dl.a().f5446a.get("MID"), "UTF-8") + "&SAVED_CARD_ID=" + URLEncoder.encode(str, "UTF-8") + "&CVV=" + URLEncoder.encode(str2, "UTF-8")).execute(new String[]{"jsonobject"});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resetBankSpinner() {
        Spinner spinner = this.mBankSpinner;
        if (spinner != null) {
            spinner.setSelection(0);
        }
    }

    public void resetNonFastForwardBanks() {
        this.selectedBank = null;
    }

    public void setDynamicPermissions() {
        if (!C1073dl.f5442a && !C1073dl.f5443c) {
            this.mCheckUseWallet.setChecked(true);
            this.mCheckUseWallet.setEnabled(false);
        }
        if (this.mCheckUseWallet.isChecked()) {
            findViewById(C0501Er.rel_card).setVisibility(0);
            findViewById(C0501Er.line_netbanking).setVisibility(0);
            findViewById(C0501Er.rel_net_banking).setVisibility(0);
            findViewById(C0501Er.rel_card_header).setVisibility(0);
            findViewById(C0501Er.layout_card_netbanking).setVisibility(0);
            findViewById(C0501Er.line_card_netbanking).setVisibility(0);
            List<Fragment> list = this.mSavedCardFragments;
            if (list != null && list.size() > 0) {
                findViewById(C0501Er.line_used_card).setVisibility(0);
                findViewById(C0501Er.rel_powered_by_saved_card).setVisibility(0);
                findViewById(C0501Er.saved_card_header).setVisibility(0);
                findViewById(C0501Er.pager).setVisibility(0);
            }
        } else {
            if (C1073dl.f5442a) {
                findViewById(C0501Er.rel_card).setVisibility(0);
                findViewById(C0501Er.line_card_netbanking).setVisibility(0);
            } else {
                findViewById(C0501Er.rel_card).setVisibility(8);
                findViewById(C0501Er.line_card_netbanking).setVisibility(8);
                findViewById(C0501Er.rel_card_header).setVisibility(8);
                findViewById(C0501Er.line_used_card).setVisibility(8);
                findViewById(C0501Er.rel_powered_by_saved_card).setVisibility(8);
                findViewById(C0501Er.saved_card_header).setVisibility(8);
                findViewById(C0501Er.pager).setVisibility(8);
            }
            if (C1073dl.f5443c) {
                findViewById(C0501Er.rel_net_banking).setVisibility(0);
            } else {
                findViewById(C0501Er.rel_net_banking).setVisibility(8);
                findViewById(C0501Er.line_netbanking).setVisibility(8);
            }
        }
        String str = C1073dl.c;
        if (str != null) {
            this.mCardProceedButton.setBackgroundColor(Color.parseColor(str));
            this.mNBProceedButton.setBackgroundColor(Color.parseColor(C1073dl.c));
        }
    }

    public void setSelectedBank(C1145h2 h2Var) {
        this.selectedBank = h2Var;
        if (this.mCheckUseWallet.isChecked()) {
            clearAll(this.mFastForwardBanksPaytm);
        } else {
            clearAll(this.mFastForwardBanksmerchant);
        }
    }

    public void setYearAdapter() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        Calendar.getInstance().get(1);
        arrayList.add("YY");
        for (int i2 = 2016; i2 <= 2050; i2++) {
            arrayList.add(Integer.toString(i2));
        }
        this.mYearSpinner.setAdapter(new ArrayAdapter(this, C0697Tr.date_spinner, arrayList));
    }

    public void showBankDialog() {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (this.mCheckUseWallet.isChecked()) {
            ArrayList<C1145h2> arrayList = this.mBankArrayListPaytm;
            if (arrayList != null) {
                C1208k2 k2Var = new C1208k2();
                C1208k2.a = arrayList;
                k2Var.show(beginTransaction, "bank_dialog");
                return;
            }
            return;
        }
        ArrayList<C1145h2> arrayList2 = this.mBankArrayListmerchant;
        if (arrayList2 != null) {
            C1208k2 k2Var2 = new C1208k2();
            C1208k2.a = arrayList2;
            k2Var2.show(beginTransaction, "bank_dialog");
        }
    }

    public void uncheckOthers(int i2, ArrayList<C1145h2> arrayList) {
        int i3 = 0;
        while (i3 < arrayList.size()) {
            try {
                if (i3 != i2) {
                    arrayList.get(i3).a = false;
                }
                i3++;
            } catch (Exception unused) {
                return;
            }
        }
    }

    public boolean validateExpiry() {
        if (this.mMonthSpinner.getSelectedItem().toString().equalsIgnoreCase("MM") || this.mYearSpinner.getSelectedItem().toString().equalsIgnoreCase("YY")) {
            return false;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
            simpleDateFormat.setLenient(false);
            Date parse = simpleDateFormat.parse(this.mMonthSpinner.getSelectedItem().toString() + RemoteSettings.FORWARD_SLASH_STRING + this.mYearSpinner.getSelectedItem().toString());
            Date parse2 = simpleDateFormat.parse(new SimpleDateFormat("MM/yyyy").format(new Date()));
            if (parse == parse2) {
                return true;
            }
            return !parse.before(parse2);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void onPostResponse(BaseResponseModal baseResponseModal) {
        ArrayList<ResponseSavedCardBin.SavedCardBinDetails> arrayList;
        if (!(baseResponseModal instanceof ResponseCheckBalance) && (baseResponseModal instanceof ResponseSavedCardBin)) {
            this.mSavedCardFragments = new ArrayList();
            ResponseSavedCardBin responseSavedCardBin = (ResponseSavedCardBin) baseResponseModal;
            this.mResponseSavedCardBin = responseSavedCardBin;
            if (responseSavedCardBin == null || (arrayList = responseSavedCardBin.savedCardBinDetailsArrayList) == null || arrayList.size() <= 0) {
                removeSavedCardLayout(false);
                return;
            }
            int size = this.mResponseSavedCardBin.savedCardBinDetailsArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = new a();
                Bundle bundle = new Bundle();
                bundle.putInt("position", i2);
                aVar.setArguments(bundle);
                this.mSavedCardFragments.add(aVar);
            }
            this.pageAdapter = new Su(getSupportFragmentManager(), this.mSavedCardFragments);
            this.pager.setClipToPadding(false);
            this.pager.setAdapter(this.pageAdapter);
            if (this.pageAdapter.getCount() > 1) {
                this.pager.setPageTransformer(true, new q());
                this.pager.setPageMargin(-((int) ((((float) getResources().getDisplayMetrics().densityDpi) / 160.0f) * 20.0f)));
            }
            this.resizesavedcardCB.setChecked(true);
        }
    }

    private void getMerchantData() {
    }

    public class c implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f4120a;
        public final /* synthetic */ ArrayList b;

        public c(ArrayList arrayList, ArrayList arrayList2) {
            this.f4120a = arrayList;
            this.b = arrayList2;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ArrayList arrayList = this.f4120a;
            if (arrayList != null && arrayList.size() > 0) {
                String str = "NB-" + ((C1145h2) arrayList.get(i)).c;
                PaytmSavedCardActivity paytmSavedCardActivity = PaytmSavedCardActivity.this;
                if (paytmSavedCardActivity.mCheckUseWallet.isChecked()) {
                    if (C0709Uj.u("PPI")) {
                        paytmSavedCardActivity.changeServiceCharge("PPI");
                    } else if (C0709Uj.u("DEFAULTFEE")) {
                        paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
                    }
                } else if (C0709Uj.u(str)) {
                    paytmSavedCardActivity.changeServiceCharge(str);
                } else if (C0709Uj.u("NB-NA")) {
                    paytmSavedCardActivity.changeServiceCharge("NB-NA");
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    paytmSavedCardActivity.changeServiceCharge("DEFAULTFEE");
                }
                if (i != 0) {
                    paytmSavedCardActivity.clearAll(this.b);
                    C1145h2 unused = paytmSavedCardActivity.selectedBank = (C1145h2) arrayList.get(i);
                    return;
                }
                C1145h2 unused2 = paytmSavedCardActivity.selectedBank = null;
            }
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class d implements AdapterView.OnItemSelectedListener {
        public d() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            PaytmSavedCardActivity.this.errorDate.setVisibility(8);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class o implements ActionMode.Callback {
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
        }
    }

    public void onFragmentInteraction(Uri uri) {
    }

    public class e implements TextWatcher {
        public e() {
        }

        public final void afterTextChanged(Editable editable) {
            PaytmSavedCardActivity.this.errorCVV.setVisibility(8);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class r implements TextWatcher {
        public r() {
        }

        public final void afterTextChanged(Editable editable) {
            int length = editable.length();
            PaytmSavedCardActivity paytmSavedCardActivity = PaytmSavedCardActivity.this;
            if (length == 7 || editable.length() == 0) {
                p unused = paytmSavedCardActivity.getCardType(paytmSavedCardActivity.getCardNumber(editable.toString()));
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && ' ' == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(' ')).length <= 3) {
                editable.insert(editable.length() - 1, String.valueOf(' '));
            }
            paytmSavedCardActivity.errorCard.setVisibility(8);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
