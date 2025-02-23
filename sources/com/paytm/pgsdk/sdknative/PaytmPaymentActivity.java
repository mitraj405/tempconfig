package com.paytm.pgsdk.sdknative;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.paytm.pgsdk.BaseActivity;
import com.paytm.pgsdk.sdknative.modal.BaseResponseModal;
import com.paytm.pgsdk.sdknative.modal.PostConvenienceModal;
import com.paytm.pgsdk.sdknative.modal.ResponseCheckBalance;
import com.paytm.pgsdk.sdknative.modal.ResponseConvinenceFee;
import com.paytm.pgsdk.sdknative.modal.ResponseValidateOTP;
import com.paytm.pgsdk.sdknative.modal.Tokens;
import defpackage.C1168i2;
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
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class PaytmPaymentActivity extends BaseActivity implements Ln, Mn, View.OnClickListener, C1310ov.c {
    public static final String OTHER = "OTHER";
    private static final int PERMISSIONS_REQUEST_RECEIVE_SMS_N_GET_LOCATION = 101;
    public static TreeMap<Integer, Integer> cardCvv = new TreeMap<>();
    private String MID;
    private C1233l2 adapter;
    private RelativeLayout cardRelativeLayout;
    private String channel;
    private C1310ov.b checkBalanceRequestprovider = new f();
    private String custID;
    /* access modifiers changed from: private */
    public TextView errorCVV;
    /* access modifiers changed from: private */
    public TextView errorCard;
    /* access modifiers changed from: private */
    public TextView errorDate;
    private BaseActivity.a genericDialogparams;
    private TableLayout gridview;
    private String industryType;
    private LayoutInflater inflater;
    /* access modifiers changed from: private */
    public String mAmount;
    private TextView mAmountTV;
    private ImageView mBackButton;
    /* access modifiers changed from: private */
    public ArrayList<C1145h2> mBankArrayList;
    private Spinner mBankSpinner;
    private EditText mCVVNumberEditText;
    private EditText mCardNumberEditText;
    private Button mCardProceedButton;
    private C1168i2 mDBoperation;
    private AlertDialog mDlg;
    private TextView mFare;
    /* access modifiers changed from: private */
    public ArrayList<C1145h2> mFastForwardBanks;
    private ImageButton mHeaderButton;
    /* access modifiers changed from: private */
    public String mID;
    private RelativeLayout mMonthRelativelayout;
    private Spinner mMonthSpinner;
    private RelativeLayout mNBLayout;
    private Button mNBProceedButton;
    private TextView mSeriveChargeLabel;
    private TextView mServiceCharge;
    private TextView mSlectedBankTextView;
    private RelativeLayout mToggleRL;
    private Double mTotalAmount;
    private TextView mTotalAmountLabel;
    private RelativeLayout mWalletRelativelayout;
    private RelativeLayout mYearRelativelayout;
    private Spinner mYearSpinner;
    private String mobileNumber;
    private C1310ov.b postConvenienceFeeRequestProvider = new c();
    private ProgressBar progressLoader;
    private RelativeLayout relBankDialog;
    private CheckBox resizeCardlayoutCB;
    private CheckBox resizeNBLayoutCB;
    private C1145h2 selectedBank;
    int selectedCard = 0;

    public class a implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public a(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public b(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
            Intent intent = new Intent();
            intent.putExtra("flow", "cancel");
            PaytmPaymentActivity paytmPaymentActivity = PaytmPaymentActivity.this;
            paytmPaymentActivity.setResult(-1, intent);
            paytmPaymentActivity.finish();
        }
    }

    public class c implements C1310ov.b {
        public c() {
        }

        public final HashMap<String, String> a() {
            return new HashMap<>();
        }

        public final Object b() {
            JSONObject jSONObject;
            PaytmPaymentActivity paytmPaymentActivity = PaytmPaymentActivity.this;
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("BASE_AMOUNT", paytmPaymentActivity.mAmount);
                    jSONObject.put("INDUSTRY", C1073dl.a().f5446a.get("INDUSTRY_TYPE_ID"));
                    jSONObject.put("CHANNEL_ID", C1073dl.a().f5446a.get("CHANNEL_ID"));
                    jSONObject.put("PAYMENT_MODE", "");
                    jSONObject.put("AUTH_MODE", "");
                    jSONObject.put("DISABLED_PAYMENT_MODE", "");
                    jSONObject.put("MID", paytmPaymentActivity.mID);
                } catch (Exception e) {
                    e = e;
                    jSONObject2 = jSONObject;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                jSONObject = jSONObject2;
                return "JsonData=" + jSONObject.toString();
            }
            return "JsonData=" + jSONObject.toString();
        }

        public final String getRequestUrl() {
            return C1488xu.i().concat("/HANDLER_INTERNAL/GET_POST_CONVENIENCE_FEE_MAP");
        }
    }

    public class f implements C1310ov.b {
        public final HashMap<String, String> a() {
            HashMap<String, String> hashMap = new HashMap<>();
            if (!(Tokens.getValidateResponse() == null || Tokens.getValidateResponse().TokenDetails == null || Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN == null)) {
                hashMap.put("ssotoken", Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
            }
            return hashMap;
        }

        public final Object b() {
            return "";
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

    public class h implements View.OnClickListener {
        public h() {
        }

        public final void onClick(View view) {
            CheckBox checkBox = (CheckBox) view.findViewById(C0501Er.check_bank);
            boolean isChecked = checkBox.isChecked();
            int intValue = ((Integer) view.getTag()).intValue();
            PaytmPaymentActivity paytmPaymentActivity = PaytmPaymentActivity.this;
            if (!isChecked) {
                ((C1145h2) paytmPaymentActivity.mFastForwardBanks.get(intValue)).a = true;
                paytmPaymentActivity.uncheckOthers(intValue);
                checkBox.setChecked(true);
            } else {
                ((C1145h2) paytmPaymentActivity.mFastForwardBanks.get(intValue)).a = false;
                checkBox.setChecked(false);
            }
            String str = "NB-" + ((C1145h2) paytmPaymentActivity.mFastForwardBanks.get(intValue)).c;
            C1073dl.a();
            if (C1073dl.b().containsKey(str)) {
                paytmPaymentActivity.changeServiceCharge(str);
            } else if (C0709Uj.u("NB-NA")) {
                paytmPaymentActivity.changeServiceCharge("NB-NA");
            } else if (C0709Uj.u("DEFAULTFEE")) {
                paytmPaymentActivity.changeServiceCharge("DEFAULTFEE");
            }
            paytmPaymentActivity.resetBankSpinner();
            paytmPaymentActivity.resetNonFastForwardBanks();
            paytmPaymentActivity.RefreshTablelayout();
        }
    }

    public class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PaytmPaymentActivity.this.resizeCardlayout(z);
        }
    }

    public class l implements CompoundButton.OnCheckedChangeListener {
        public l() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            PaytmPaymentActivity.this.resizeNBlayout(z);
        }
    }

    public class m implements View.OnFocusChangeListener {
        public m() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                boolean u = C0709Uj.u("CC");
                PaytmPaymentActivity paytmPaymentActivity = PaytmPaymentActivity.this;
                if (u) {
                    paytmPaymentActivity.changeServiceCharge("CC");
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    paytmPaymentActivity.changeServiceCharge("DEFAULTFEE");
                }
            }
        }
    }

    public class o implements View.OnLongClickListener {
        public final boolean onLongClick(View view) {
            return true;
        }
    }

    public class q implements View.OnLongClickListener {
        public final boolean onLongClick(View view) {
            return true;
        }
    }

    public class r implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public r(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class s implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public s(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
            Intent intent = new Intent();
            intent.putExtra("flow", "cancel");
            PaytmPaymentActivity paytmPaymentActivity = PaytmPaymentActivity.this;
            paytmPaymentActivity.setResult(-1, intent);
            paytmPaymentActivity.finish();
        }
    }

    public enum t {
    }

    /* access modifiers changed from: private */
    public void RefreshTablelayout() {
        TableRow tableRow;
        int childCount = this.gridview.getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.gridview.getChildAt(i3);
            if ((childAt instanceof TableRow) && (tableRow = (TableRow) childAt) != null) {
                int childCount2 = tableRow.getChildCount();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    View childAt2 = tableRow.getChildAt(i4);
                    if (childAt2 != null && (childAt2 instanceof RelativeLayout)) {
                        getView(i2, childAt2);
                    }
                    i2++;
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
    public t getCardType(String str) {
        return getCardTypeName(str);
    }

    private t getCardTypeName(String str) {
        String[] strArr = {"^(5018|5020|5038|5612|5893|6304|6759|676[1-3]|0604|6220|6390|6002).*", "^4.*", "^5[1-5].*", "^(36|38|30[0-5]).*", "^35.*", "^(6011|65|64[4-9]|622[1-9]).*", "^3[47].*", ".*", ".*"};
        for (int i2 = 0; i2 < t.values().length; i2++) {
            if (i2 == 7) {
                if (TB.a(str.substring(0, Math.min(str.length(), 6)))) {
                    setCardTypeImage(i2);
                    return t.values()[i2];
                }
            } else if (i2 != 0 || !checkFirstTwoDigitForMaestro(str)) {
                if (Pattern.compile(strArr[i2], 2).matcher(str).matches()) {
                    setCardTypeImage(i2);
                    return t.values()[i2];
                }
            } else if (TB.a(str)) {
                setCardTypeImage(7);
                return t.values()[7];
            } else {
                setCardTypeImage(i2);
                return t.values()[i2];
            }
        }
        return t.values()[8];
    }

    private void getMerchantData() {
        this.custID = getIntent().getStringExtra("cust_id");
        this.mID = getIntent().getStringExtra("MID");
        this.industryType = getIntent().getStringExtra("industry");
        this.mAmount = getIntent().getStringExtra(PaymentConstants.AMOUNT);
        this.mobileNumber = getIntent().getStringExtra(LoginActivity.MOBILE_KEY);
        Double valueOf = Double.valueOf(TB.d(Double.parseDouble(this.mAmount)));
        TextView textView = this.mAmountTV;
        StringBuilder sb = new StringBuilder();
        int i2 = C0787as.paytm_rs;
        sb.append(getString(i2));
        sb.append(TB.d(valueOf.doubleValue()));
        textView.setText(sb.toString());
        TextView textView2 = this.mFare;
        textView2.setText(getString(i2) + this.mAmount);
        C1073dl a2 = C1073dl.a();
        a2.f5445a = "" + this.mAmount;
    }

    private void initializeCVVCheck() {
        cardCvv.put(0, 0);
        cardCvv.put(6, 4);
        cardCvv.put(0, 3);
    }

    private void launchWalletActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(LoginActivity.PASSED_MID, this.mID);
        intent.putExtra(LoginActivity.MOBILE_KEY, this.mobileNumber);
        if (C1286np.a().f5601a == null || C1286np.a().f5601a.mPassword == null || C1286np.a().f5601a.mFileName == null) {
            Toast.makeText(this, "PaytmClientCertificate is not initialized", 0).show();
            return;
        }
        intent.putExtra(LoginActivity.CERTIFICATE_PASSWORD, C1286np.a().f5601a.mPassword);
        intent.putExtra(LoginActivity.CERTIFICATE_FILENAME, C1286np.a().f5601a.mFileName);
        intent.putExtra(LoginActivity.CHECKSUM_GENERATION_URL, C1286np.a().f5604a);
        startActivityForResult(intent, 117);
    }

    private void proceedToPayViaCardDetails() {
        try {
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
            new C1176ie(this, "CUST_ID=" + URLEncoder.encode(this.custID, "UTF-8") + "&MID=" + URLEncoder.encode(this.mID, "UTF-8") + "&CARD_EXPIRY_YEAR=" + URLEncoder.encode(obj3, "UTF-8") + "&CARD_EXPIRY_MONTH=" + URLEncoder.encode(obj2, "UTF-8") + "&CARD_NUMBER=" + URLEncoder.encode(cardNumber, "UTF-8") + "&CVV=" + URLEncoder.encode(obj, "UTF-8")).execute(new String[]{"jsonobject"});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void resizeCardlayout(boolean z) {
        if (z) {
            ((TextView) findViewById(C0501Er.txt_card_header_title)).setTypeface((Typeface) null, 1);
            ((TextView) findViewById(C0501Er.txt_net_banking_header_title)).setTypeface((Typeface) null, 0);
            this.cardRelativeLayout.setBackgroundColor(-1);
            findViewById(C0501Er.rel_card_expand_layout).setVisibility(0);
            this.mNBLayout.setVisibility(8);
            this.resizeNBLayoutCB.setChecked(false);
            clearAll();
            resetBankSpinner();
            changeServiceCharge("CC");
            return;
        }
        findViewById(C0501Er.rel_card_expand_layout).setVisibility(8);
        ((TextView) findViewById(C0501Er.txt_card_header_title)).setTypeface((Typeface) null, 0);
        this.mToggleRL.setBackgroundColor(-1);
    }

    /* access modifiers changed from: private */
    public void resizeNBlayout(boolean z) {
        if (z) {
            ((TextView) findViewById(C0501Er.txt_card_header_title)).setTypeface((Typeface) null, 0);
            ((TextView) findViewById(C0501Er.txt_net_banking_header_title)).setTypeface((Typeface) null, 1);
            this.mToggleRL.setBackgroundColor(-1);
            this.mNBLayout.setVisibility(0);
            findViewById(C0501Er.rel_card_expand_layout).setVisibility(8);
            this.resizeCardlayoutCB.setChecked(false);
            changeServiceCharge("NB-NA");
            return;
        }
        this.mNBLayout.setVisibility(8);
        ((TextView) findViewById(C0501Er.txt_net_banking_header_title)).setTypeface((Typeface) null, 0);
        this.cardRelativeLayout.setBackgroundColor(-1);
        clearAll();
        resetBankSpinner();
    }

    private void setCVVTextwatcher() {
        this.mCVVNumberEditText.addTextChangedListener(new g());
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

    private void setCellClickListener(View view) {
        view.setOnClickListener(new h());
    }

    private BaseActivity.a setGenericDialog() {
        BaseActivity.a dialogParams = getDialogParams();
        dialogParams.f4097b = getString(C0787as.generic_err_heading);
        dialogParams.f4096a = getString(C0787as.generic_err_message);
        dialogParams.c = getString(C0787as.generic_err_right_btn);
        dialogParams.a = new i();
        dialogParams.b = new j();
        return dialogParams;
    }

    private void setItemSelectListener(Spinner spinner) {
        spinner.setOnItemSelectedListener(new d());
    }

    private void setMonthAdapter() {
        this.mMonthSpinner.setAdapter(new ArrayAdapter(this, C0697Tr.date_spinner, getResources().getStringArray(Yq.month_array)));
    }

    private void setSpinnerSelectListener(Spinner spinner) {
        spinner.setOnItemSelectedListener(new e());
    }

    private void setTableGridadapter() {
        double ceil = Math.ceil((double) (((float) this.mFastForwardBanks.size()) / 3.0f));
        int i2 = 0;
        for (int i3 = 0; ((double) i3) <= ceil; i3++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(-1, -2));
            tableRow.setBackgroundColor(0);
            for (int i4 = 0; i4 < 3 && i2 < this.mFastForwardBanks.size(); i4++) {
                tableRow.addView(getView(i2, this.inflater.inflate(C0697Tr.bank_grid_item, (ViewGroup) null)));
                i2++;
            }
            this.gridview.addView(tableRow);
        }
    }

    private int updateAdapterposition(String str, ArrayList<C1145h2> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).d.equalsIgnoreCase(str)) {
                return i2;
            }
        }
        return 0;
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
        } else if (this.selectedCard == 0 || validateExpiry()) {
            int i3 = this.selectedCard;
            if (i3 == 0 || getCVVCheckDigit(i3) == lf.e(this.mCVVNumberEditText)) {
                return true;
            }
            this.errorCVV.setText(getString(C0787as.error_cvv));
            this.errorCVV.setVisibility(0);
            return false;
        } else {
            this.errorDate.setVisibility(0);
            return false;
        }
    }

    public void OnBankListFetchResponse(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mDBoperation.getClass();
            C1168i2.a(str, "IRCTC");
            parseBankListResponse(str);
        }
    }

    public void changeServiceCharge(String str) {
        C1073dl.a();
        if (C1073dl.b().get(str) != null) {
            C1073dl.a();
            String fee = C1073dl.b().get(str).getFee();
            Double valueOf = Double.valueOf(Double.parseDouble(fee));
            Double valueOf2 = Double.valueOf(valueOf.doubleValue() + Double.parseDouble(this.mAmount));
            C1073dl.a().getClass();
            C1073dl.a().getClass();
            C1073dl a2 = C1073dl.a();
            a2.f5447b = "" + valueOf2;
            C1073dl.a();
            Double valueOf3 = Double.valueOf(TB.d(Double.parseDouble(C1073dl.b().get(str).getTxnAmount())));
            TextView textView = this.mAmountTV;
            StringBuilder sb = new StringBuilder();
            Resources resources = getResources();
            int i2 = C0787as.paytm_rs;
            sb.append(resources.getString(i2));
            sb.append(valueOf3);
            textView.setText(sb.toString());
            TextView textView2 = this.mServiceCharge;
            textView2.setText(getResources().getString(i2) + fee);
            if (str.equalsIgnoreCase("NB-NA")) {
                this.mAmountTV.setVisibility(8);
                this.mTotalAmountLabel.setVisibility(8);
                this.mSeriveChargeLabel.setText(getResources().getString(C0787as.payment_charges_net_banking));
            } else if (str.equalsIgnoreCase("CC") || str.equalsIgnoreCase("DC")) {
                this.mTotalAmountLabel.setVisibility(8);
                this.mServiceCharge.setVisibility(8);
                this.mAmountTV.setVisibility(8);
                this.mSeriveChargeLabel.setText(getResources().getString(C0787as.payment_charges_card));
            }
        }
    }

    public void clearAll() {
        for (int i2 = 0; i2 < this.mFastForwardBanks.size(); i2++) {
            this.mFastForwardBanks.get(i2).a = false;
        }
        RefreshTablelayout();
    }

    public void fetchBankList() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.industryType)) {
                jSONObject.put("INDUSTRY", this.industryType);
            }
            if (C1073dl.a().f5446a != null) {
                if (!TextUtils.isEmpty(C1073dl.a().f5446a.get("MID"))) {
                    jSONObject.put("MID", C1073dl.a().f5446a.get("MID"));
                }
                if (!TextUtils.isEmpty(C1073dl.a().f5446a.get("CHANNEL_ID"))) {
                    jSONObject.put("CHANNEL", C1073dl.a().f5446a.get("CHANNEL_ID"));
                }
            }
            str = "JsonData=" + jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        this.mDBoperation.getClass();
        C1168i2.a b2 = C1168i2.b("IRCTC");
        long currentTimeMillis = System.currentTimeMillis();
        if (b2 == null || (TextUtils.isEmpty(b2.f5483a) && currentTimeMillis > b2.a + 86400000)) {
            new C0755Yb(this, str).execute(new String[]{C1488xu.i().concat("/HANDLER_INTERNAL/BANK_LIST?")});
            return;
        }
        parseBankListResponse(b2.f5483a);
    }

    public void fetchPostConvenience() {
        this.progressLoader.setVisibility(0);
        new C1310ov(this, new ResponseConvinenceFee(), this, this.postConvenienceFeeRequestProvider, 1).execute(new String[0]);
    }

    public C1145h2 getSelectedBank() {
        for (int i2 = 0; i2 < this.mFastForwardBanks.size(); i2++) {
            C1145h2 h2Var = this.mFastForwardBanks.get(i2);
            if (h2Var.a) {
                return h2Var;
            }
        }
        return null;
    }

    public View getView(int i2, View view) {
        view.setTag(Integer.valueOf(i2));
        ImageView imageView = (ImageView) view.findViewById(C0501Er.img_bank);
        CheckBox checkBox = (CheckBox) view.findViewById(C0501Er.check_bank);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C0501Er.bank_grid_parent_rl);
        setCellClickListener(relativeLayout);
        checkBox.setChecked(this.mFastForwardBanks.get(i2).a);
        checkBox.setEnabled(false);
        relativeLayout.setTag(Integer.valueOf(i2));
        imageView.setTag(Integer.valueOf(i2));
        checkBox.setTag(Integer.valueOf(i2));
        if (this.mFastForwardBanks.get(i2).c.equalsIgnoreCase("ICICI")) {
            imageView.setImageResource(C1502yr.icici_bank_logo);
        } else if (this.mFastForwardBanks.get(i2).c.equalsIgnoreCase("HDFC")) {
            imageView.setImageResource(C1502yr.hdfc_bank_logo);
        } else if (this.mFastForwardBanks.get(i2).c.equalsIgnoreCase("HSBC")) {
            imageView.setImageResource(C1502yr.hsbc_logo);
        } else if (this.mFastForwardBanks.get(i2).c.equalsIgnoreCase("SBI")) {
            imageView.setImageResource(C1502yr.sbi_logo);
        } else if (this.mFastForwardBanks.get(i2).c.equalsIgnoreCase("CITI")) {
            imageView.setImageResource(C1502yr.citibank_logo);
        } else if (this.mFastForwardBanks.get(i2).c.equalsIgnoreCase("BOB")) {
            imageView.setImageResource(C1502yr.bank_of_baroda_logo);
        }
        return view;
    }

    public boolean luhnCheck(String str) {
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (length >= 0) {
            try {
                int parseInt = Integer.parseInt(str.substring(length, length + 1));
                if (z && (parseInt = parseInt * 2) > 9) {
                    parseInt = (parseInt % 10) + 1;
                }
                i2 += parseInt;
                z = !z;
                length--;
            } catch (Exception unused) {
                return false;
            }
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 117 && intent != null) {
            Bundle extras = intent.getExtras();
            Intent intent2 = new Intent();
            intent2.putExtra("flow", extras.getString("flow"));
            intent2.putExtra(PaymentConstants.Event.SCREEN, extras.getString(PaymentConstants.Event.SCREEN));
            setResult(-2, intent2);
            finish();
        } else if (i3 == -2 && i2 == 117 && intent != null) {
            Bundle extras2 = intent.getExtras();
            Intent intent3 = new Intent();
            if (extras2.containsKey("token")) {
                intent3.putExtra("token", extras2.getString("token"));
                if (extras2.containsKey("IS_SAVED_CARD")) {
                    intent3.putExtra("IS_SAVED_CARD", extras2.getString("IS_SAVED_CARD"));
                }
                if (extras2.containsKey("STORE_CARD")) {
                    intent3.putExtra("STORE_CARD", extras2.getString("STORE_CARD"));
                }
            }
            if (extras2.containsKey("bank_code")) {
                intent3.putExtra("bank_code", extras2.getString("bank_code"));
            }
            intent3.putExtra("type", extras2.getString("type"));
            intent3.putExtra("flow", extras2.getString("flow"));
            intent3.putExtra(PaymentConstants.Event.SCREEN, extras2.getString(PaymentConstants.Event.SCREEN));
            setResult(-3, intent3);
            finish();
        } else if (i3 == -3 && i2 == 117 && intent != null) {
            Intent intent4 = new Intent();
            intent4.putExtra("flow", "cancel");
            setResult(-1, intent4);
            finish();
        }
    }

    public void onBackPressed() {
        synchronized (C1354qp.class) {
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(C0697Tr.alert_back_dialog, (ViewGroup) null);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        ((TextView) inflate.findViewById(C0501Er.bttn_no)).setOnClickListener(new a(create));
        ((TextView) inflate.findViewById(C0501Er.bttn_yes)).setOnClickListener(new b(create));
        create.show();
    }

    public void onClick(View view) {
        ResponseValidateOTP.TokenDetails tokenDetails;
        if (view.getId() == C0501Er.bttn_proceed_to_pay_card) {
            if (validateCardData()) {
                proceedToPayViaCardDetails();
            }
        } else if (view.getId() == C0501Er.bttn_proceed_to_pay_netbanking) {
            C1145h2 h2Var = this.selectedBank;
            C1145h2 selectedBank2 = getSelectedBank();
            Intent intent = new Intent();
            if (selectedBank2 != null) {
                String str = selectedBank2.c;
                if (str != null) {
                    intent.putExtra("bank_code", str);
                }
            } else if (h2Var == null || h2Var.c == null || h2Var.d.equalsIgnoreCase("OTHER")) {
                Toast.makeText(this, getString(C0787as.err_select_bank), 1).show();
                return;
            } else {
                intent.putExtra("bank_code", h2Var.c);
            }
            intent.putExtra("flow", "NB");
            setResult(-1, intent);
            finish();
        } else if (view.getId() == C0501Er.rel_saved_card_wallet) {
            ResponseValidateOTP validateResponse = Tokens.getValidateResponse();
            if (validateResponse == null || (tokenDetails = validateResponse.TokenDetails) == null || TextUtils.isEmpty(tokenDetails.PAYTM_TOKEN) || TextUtils.isEmpty(validateResponse.TokenDetails.TXN_TOKEN)) {
                launchWalletActivity();
                return;
            }
            new C1310ov(this, new ResponseCheckBalance(), this, this.checkBalanceRequestprovider, 2).execute(new String[0]);
            this.progressLoader.setVisibility(0);
        } else if (view.getId() == C0501Er.rel_month) {
            TB.c(this.mMonthSpinner, false, this);
            this.mMonthSpinner.performClick();
        } else if (view.getId() == C0501Er.rel_year) {
            TB.c(this.mYearSpinner, false, this);
            this.mYearSpinner.performClick();
        } else if (view.getId() == C0501Er.header_back_button) {
            synchronized (C1354qp.class) {
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View inflate = getLayoutInflater().inflate(C0697Tr.alert_back_dialog, (ViewGroup) null);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            ((TextView) inflate.findViewById(C0501Er.bttn_no)).setOnClickListener(new r(create));
            ((TextView) inflate.findViewById(C0501Er.bttn_yes)).setOnClickListener(new s(create));
            create.show();
        } else if (view.getId() == C0501Er.rel_net_banking_header) {
            CheckBox checkBox = this.resizeNBLayoutCB;
            checkBox.setChecked(!checkBox.isChecked());
        } else if (view == this.cardRelativeLayout) {
            CheckBox checkBox2 = this.resizeCardlayoutCB;
            checkBox2.setChecked(!checkBox2.isChecked());
        } else if (view.getId() == C0501Er.rel_bank_spinner_parent) {
            showBankDialog();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0697Tr.activity_paytm_payment);
        this.inflater = (LayoutInflater) getSystemService("layout_inflater");
        if (C1168i2.f5481a == null) {
            C1168i2.f5481a = new C1168i2(this);
        }
        C1168i2 i2Var = C1168i2.f5481a;
        this.mDBoperation = i2Var;
        C1168i2.a = i2Var.f5482a.getWritableDatabase();
        initializeCVVCheck();
        this.mYearSpinner = (Spinner) findViewById(C0501Er.year_spinner);
        this.mMonthSpinner = (Spinner) findViewById(C0501Er.month_spinner);
        this.mBankSpinner = (Spinner) findViewById(C0501Er.bank_spinner);
        this.mCardProceedButton = (Button) findViewById(C0501Er.bttn_proceed_to_pay_card);
        this.mNBProceedButton = (Button) findViewById(C0501Er.bttn_proceed_to_pay_netbanking);
        this.mWalletRelativelayout = (RelativeLayout) findViewById(C0501Er.rel_saved_card_wallet);
        this.mMonthRelativelayout = (RelativeLayout) findViewById(C0501Er.rel_month);
        this.mYearRelativelayout = (RelativeLayout) findViewById(C0501Er.rel_year);
        this.mCardNumberEditText = (EditText) findViewById(C0501Er.edit_enter_card_number);
        this.mCVVNumberEditText = (EditText) findViewById(C0501Er.edit_cvv);
        this.mAmountTV = (TextView) findViewById(C0501Er.txt_pay_amount);
        this.mTotalAmountLabel = (TextView) findViewById(C0501Er.txt_pay);
        this.mNBLayout = (RelativeLayout) findViewById(C0501Er.rel_net_banking_expand_layout);
        this.mToggleRL = (RelativeLayout) findViewById(C0501Er.rel_net_banking_header);
        this.mCardNumberEditText.addTextChangedListener(new u());
        this.mFare = (TextView) findViewById(C0501Er.txt_fare_amount);
        this.mServiceCharge = (TextView) findViewById(C0501Er.txt_service_amount);
        this.mSeriveChargeLabel = (TextView) findViewById(C0501Er.txt_service);
        this.progressLoader = (ProgressBar) findViewById(C0501Er.progress_bar_paytmpayment);
        this.gridview = (TableLayout) findViewById(C0501Er.gridview);
        this.resizeCardlayoutCB = (CheckBox) findViewById(C0501Er.toggle_expand_contract);
        this.resizeNBLayoutCB = (CheckBox) findViewById(C0501Er.toggle_expand_contract_2);
        this.cardRelativeLayout = (RelativeLayout) findViewById(C0501Er.rel_card_header);
        this.relBankDialog = (RelativeLayout) findViewById(C0501Er.rel_bank_spinner_parent);
        this.errorDate = (TextView) findViewById(C0501Er.error_rel_year);
        this.errorCVV = (TextView) findViewById(C0501Er.error_edit_cvv);
        this.errorCard = (TextView) findViewById(C0501Er.error_card_number);
        this.mSlectedBankTextView = (TextView) findViewById(C0501Er.txt_select_bank1);
        int i2 = C0501Er.header_back_button;
        ImageButton imageButton = (ImageButton) findViewById(i2);
        this.mHeaderButton = imageButton;
        int i3 = C1073dl.a;
        if (i3 > 0) {
            imageButton.setImageResource(i3);
        }
        setCVVTextwatcher();
        this.mFastForwardBanks = new ArrayList<>();
        this.mToggleRL.setOnClickListener(this);
        this.mCardProceedButton.setOnClickListener(this);
        this.mNBProceedButton.setOnClickListener(this);
        this.mWalletRelativelayout.setOnClickListener(this);
        this.mMonthRelativelayout.setOnClickListener(this);
        this.mYearRelativelayout.setOnClickListener(this);
        this.cardRelativeLayout.setOnClickListener(this);
        this.relBankDialog.setOnClickListener(this);
        setSpinnerSelectListener(this.mMonthSpinner);
        setSpinnerSelectListener(this.mYearSpinner);
        setItemSelectListener(this.mBankSpinner);
        this.resizeCardlayoutCB.setOnCheckedChangeListener(new k());
        this.resizeNBLayoutCB.setOnCheckedChangeListener(new l());
        this.mCardNumberEditText.setOnFocusChangeListener(new m());
        this.mCardNumberEditText.setCustomSelectionActionModeCallback(new n());
        this.mCardNumberEditText.setOnLongClickListener(new o());
        this.mCVVNumberEditText.setCustomSelectionActionModeCallback(new p());
        this.mCVVNumberEditText.setOnLongClickListener(new q());
        getMerchantData();
        if (C1073dl.d) {
            launchWalletActivity();
        }
        setYearAdapter();
        setMonthAdapter();
        fetchBankList();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ImageView imageView = (ImageView) findViewById(i2);
        this.mBackButton = imageView;
        imageView.setOnClickListener(this);
        fetchPostConvenience();
        this.genericDialogparams = setGenericDialog();
        setDynamicPermissions();
    }

    public void onPostResponse(String str) {
        synchronized (C1354qp.class) {
        }
    }

    public void onTokenGenerateCallback(String str) {
        Intent intent = new Intent();
        intent.putExtra("token", str);
        intent.putExtra("flow", "CARD");
        setResult(-1, intent);
        finish();
    }

    public void parseBankListResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mBankArrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("BANK_LIST");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                C1145h2 h2Var = new C1145h2();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                h2Var.c = jSONObject2.getString("BANK_CODE");
                h2Var.d = jSONObject2.getString("BANK_NAME");
                jSONObject2.getBoolean("IS_ATM");
                if (!h2Var.c.equalsIgnoreCase("ICICI") && !h2Var.c.equalsIgnoreCase("HDFC") && !h2Var.c.equalsIgnoreCase("SBI") && !h2Var.c.equalsIgnoreCase("HSBC") && !h2Var.c.equalsIgnoreCase("CITI")) {
                    if (!h2Var.c.equalsIgnoreCase("BOB")) {
                        this.mBankArrayList.add(h2Var);
                    }
                }
                this.mFastForwardBanks.add(h2Var);
            }
            getResources();
            Collections.sort(this.mBankArrayList);
            C1145h2 h2Var2 = new C1145h2();
            h2Var2.d = "OTHER";
            this.mBankArrayList.add(0, h2Var2);
            C1233l2 l2Var = new C1233l2(this, C0697Tr.bank_spinner, this.mBankArrayList);
            this.adapter = l2Var;
            this.mBankSpinner.setAdapter(l2Var);
            setTableGridadapter();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void parsePostConvenienceResponse(JSONObject jSONObject) {
        try {
            if (jSONObject.optString("STATUS").equalsIgnoreCase("FAILURE")) {
                openGenericDialog(this.genericDialogparams).show();
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("paymentCharges");
            jSONObject.keys();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
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
                    synchronized (C1354qp.class) {
                    }
                    C1073dl.a();
                    C1073dl.b().put(str, postConvenienceModal);
                }
            }
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
        this.mSlectedBankTextView.setText(this.mBankArrayList.get(0).d);
    }

    public void setDynamicPermissions() {
        int i2 = C0501Er.rel_card;
        findViewById(i2).setVisibility(0);
        if (C1073dl.f5442a) {
            findViewById(i2).setVisibility(0);
        } else {
            findViewById(i2).setVisibility(8);
            findViewById(C0501Er.line_netbanking).setVisibility(8);
            findViewById(C0501Er.card_view_netbanking).setVisibility(8);
        }
        if (C1073dl.f5443c) {
            findViewById(C0501Er.rel_net_banking).setVisibility(0);
        } else {
            findViewById(C0501Er.rel_net_banking).setVisibility(8);
            findViewById(C0501Er.line_netbanking).setVisibility(8);
        }
        if (C1073dl.b) {
            findViewById(C0501Er.card_view_saved_card_wallet).setVisibility(0);
        } else {
            findViewById(C0501Er.card_view_saved_card_wallet).setVisibility(8);
        }
        String str = C1073dl.c;
        if (str != null) {
            this.mCardProceedButton.setBackgroundColor(Color.parseColor(str));
            this.mNBProceedButton.setBackgroundColor(Color.parseColor(C1073dl.c));
        }
    }

    public void setSelectedBank(C1145h2 h2Var) {
        this.selectedBank = h2Var;
        this.mSlectedBankTextView.setText(h2Var.d);
        clearAll();
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
        ArrayList<C1145h2> arrayList = this.mBankArrayList;
        if (arrayList != null) {
            C1208k2 k2Var = new C1208k2();
            C1208k2.a = arrayList;
            k2Var.show(beginTransaction, "bank_dialog");
        }
    }

    public void uncheckOthers(int i2) {
        int i3 = 0;
        while (i3 < this.mFastForwardBanks.size()) {
            try {
                if (i3 != i2) {
                    this.mFastForwardBanks.get(i3).a = false;
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
        Double d2;
        this.progressLoader.setVisibility(8);
        if (baseResponseModal instanceof ResponseConvinenceFee) {
            try {
                JSONObject jSONObject = new JSONObject(((ResponseConvinenceFee) baseResponseModal).jsonObject);
                parsePostConvenienceResponse(jSONObject);
                if (jSONObject.getString("STATUS").equalsIgnoreCase("FAILURE")) {
                    TextView textView = this.mServiceCharge;
                    textView.setText(getResources().getString(C0787as.paytm_rs) + "0");
                    C1073dl.a().f5447b = this.mAmount;
                    return;
                }
                C1073dl.a();
                if (C1073dl.b().get("CC") != null) {
                    C1073dl.a();
                    String fee = C1073dl.b().get("CC").getFee();
                    Double valueOf = Double.valueOf(Double.parseDouble(this.mAmount) + Double.valueOf(Double.parseDouble(fee)).doubleValue());
                    C1073dl.a().getClass();
                    C1073dl.a().getClass();
                    C1073dl a2 = C1073dl.a();
                    a2.f5447b = "" + valueOf;
                    TextView textView2 = this.mAmountTV;
                    StringBuilder sb = new StringBuilder();
                    int i2 = C0787as.paytm_rs;
                    sb.append(getString(i2));
                    sb.append(TB.d(valueOf.doubleValue()));
                    textView2.setText(sb.toString());
                    TextView textView3 = this.mServiceCharge;
                    textView3.setText(getString(i2) + fee);
                    this.mTotalAmountLabel.setVisibility(8);
                    this.mServiceCharge.setVisibility(8);
                    this.mAmountTV.setVisibility(8);
                    this.mSeriveChargeLabel.setText(getResources().getString(C0787as.payment_charges_card));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (baseResponseModal instanceof ResponseCheckBalance) {
            try {
                ResponseCheckBalance responseCheckBalance = (ResponseCheckBalance) baseResponseModal;
                if (responseCheckBalance.statusCode.equalsIgnoreCase("SUCCESS")) {
                    Double valueOf2 = Double.valueOf(Double.parseDouble(responseCheckBalance.response.amount));
                    C1073dl.a();
                    if (C1073dl.b().containsKey("PPI")) {
                        C1073dl.a();
                        d2 = Double.valueOf(Double.parseDouble(C1073dl.b().get("PPI").getTxnAmount()));
                    } else {
                        C1073dl.a();
                        if (C1073dl.b().containsKey("DEFAULTFEE")) {
                            C1073dl.a();
                            d2 = Double.valueOf(Double.parseDouble(C1073dl.b().get("DEFAULTFEE").getTxnAmount()));
                        } else {
                            d2 = null;
                        }
                    }
                    C1073dl.a().f5444a = valueOf2;
                    Class<LoginActivity> cls = LoginActivity.class;
                    if (d2.doubleValue() <= valueOf2.doubleValue()) {
                        Intent intent = new Intent(this, cls);
                        intent.putExtra("balance_available", true);
                        startActivityForResult(intent, 117);
                        return;
                    }
                    Intent intent2 = new Intent(this, cls);
                    intent2.putExtra("balance_available", false);
                    startActivityForResult(intent2, 117);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void genrateJsonDataForBank() {
    }

    public class d implements AdapterView.OnItemSelectedListener {
        public d() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            PaytmPaymentActivity paytmPaymentActivity = PaytmPaymentActivity.this;
            if (paytmPaymentActivity.mBankArrayList != null && paytmPaymentActivity.mBankArrayList.size() > 0) {
                String str = "NB-" + ((C1145h2) paytmPaymentActivity.mBankArrayList.get(i)).c;
                C1073dl.a();
                if (C1073dl.b().containsKey(str)) {
                    paytmPaymentActivity.changeServiceCharge(str);
                } else if (C0709Uj.u("NB-NA")) {
                    paytmPaymentActivity.changeServiceCharge("NB-NA");
                } else if (C0709Uj.u("DEFAULTFEE")) {
                    paytmPaymentActivity.changeServiceCharge("DEFAULTFEE");
                }
                if (i != 0) {
                    paytmPaymentActivity.clearAll();
                }
            }
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class e implements AdapterView.OnItemSelectedListener {
        public e() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            PaytmPaymentActivity.this.errorDate.setVisibility(8);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class n implements ActionMode.Callback {
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

    public class p implements ActionMode.Callback {
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

    public void postHttpError(BaseResponseModal baseResponseModal) {
    }

    public class i implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements TextWatcher {
        public g() {
        }

        public final void afterTextChanged(Editable editable) {
            PaytmPaymentActivity.this.errorCVV.setVisibility(8);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class u implements TextWatcher {
        public u() {
        }

        public final void afterTextChanged(Editable editable) {
            int length = editable.length();
            PaytmPaymentActivity paytmPaymentActivity = PaytmPaymentActivity.this;
            if (length == 7 || editable.length() == 0) {
                t unused = paytmPaymentActivity.getCardType(paytmPaymentActivity.getCardNumber(editable.toString()));
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && ' ' == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(' ')).length <= 3) {
                editable.insert(editable.length() - 1, String.valueOf(' '));
            }
            paytmPaymentActivity.errorCard.setVisibility(8);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
