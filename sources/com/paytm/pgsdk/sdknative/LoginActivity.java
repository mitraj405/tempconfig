package com.paytm.pgsdk.sdknative;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.pgsdk.BaseActivity;
import com.paytm.pgsdk.PaytmClientCertificate;
import com.paytm.pgsdk.sdknative.modal.BaseResponseModal;
import com.paytm.pgsdk.sdknative.modal.ResponseCheckBalance;
import com.paytm.pgsdk.sdknative.modal.ResponseGenerateOTP;
import com.paytm.pgsdk.sdknative.modal.ResponseValidateOTP;
import com.paytm.pgsdk.sdknative.modal.Tokens;
import defpackage.C1310ov;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity implements View.OnClickListener, C1310ov.c {
    public static final String CERTIFICATE_FILENAME = "filename";
    public static final String CERTIFICATE_PASSWORD = "ptm_password";
    public static final String CHECKSUM_GENERATION_URL = "checksumURL";
    public static String GENERATE_OTP_ACCOUNT_BLOCKED = "433";
    public static String GENERATE_OTP_INVALID_AUTHORIZATION = "430";
    public static String GENERATE_OTP_INVALID_EMAIL = "465";
    public static String GENERATE_OTP_NUMBER_NOT_REGISTERED = "432";
    public static String GENERATE_OTP_OTP_LIMIT_REACHED = "531";
    public static final String MOBILE_KEY = "mobile";
    public static final String MOBILE_OTP_DELIVERY_METHOD_CALL = "OBD";
    public static final String MOBILE_OTP_DELIVERY_METHOD_SMS = "SMS";
    public static final String PASSED_MID = "mid";
    public static String VALIDATE_OTP_INVALID_OTP = "403";
    public static String VALIDATE_OTP_LOGIN_FAILED = "432";
    private ImageButton backIcon;
    private C1310ov.b checkBalanceRequestprovider = new e();
    /* access modifiers changed from: private */
    public String enteredMobileNumber;
    private C1310ov.b generateOTPrequestProvider = new i();
    /* access modifiers changed from: private */
    public String generatedChecksum;
    private BaseActivity.a genericDialogparams;
    private ImageView heading;
    private boolean isActivityStopped = false;
    /* access modifiers changed from: private */
    public boolean isOTPoncallClicked;
    private Button loginBTN;
    private TextView loginwithDiffID;
    private n mCountdown;
    private ProgressBar mProgressBar;
    private EditText mobileET;
    private String originalPassesNumber;
    /* access modifiers changed from: private */
    public EditText otpET;
    private RelativeLayout otpSendModeRL;
    private TextView resendOTP;
    private C1310ov.b resendOTPrequestProvider = new k();
    private TextView screenactionHint;
    private String state;
    private Button submitBTN;
    private TextView termcondition;
    private final TextWatcher textWatcher = new a();
    private TextView timer;
    /* access modifiers changed from: private */
    public TextView tvError;
    private C1310ov.b validateOTPrequestProvider = new j();

    public class d implements TextView.OnEditorActionListener {
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    public class e implements C1310ov.b {
        public final HashMap<String, String> a() {
            HashMap<String, String> hashMap = new HashMap<>();
            if (!(Tokens.getValidateResponse() == null || Tokens.getValidateResponse().TokenDetails == null || Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN == null)) {
                hashMap.put("ssotoken", Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
            }
            return hashMap;
        }

        public final Object b() {
            return " ";
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

    public class f implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public f(Dialog dialog) {
            this.a = dialog;
        }

        public final void onClick(View view) {
            LoginActivity.this.openLoginLayout();
            this.a.dismiss();
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public g(Dialog dialog) {
            this.a = dialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
            LoginActivity.this.finish();
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public h(Dialog dialog) {
            this.a = dialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class i implements C1310ov.b {
        public i() {
        }

        public final HashMap<String, String> a() {
            return null;
        }

        public final Object b() {
            LoginActivity loginActivity = LoginActivity.this;
            if (loginActivity.isOTPoncallClicked) {
                StringBuilder sb = new StringBuilder("JsonData=");
                C1487xt b = C1487xt.b();
                String access$200 = loginActivity.enteredMobileNumber;
                String mid = loginActivity.getMid();
                String access$300 = loginActivity.generatedChecksum;
                b.getClass();
                sb.append(C1155he.a(C1487xt.a(access$200, mid, access$300, LoginActivity.MOBILE_OTP_DELIVERY_METHOD_CALL)));
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder("JsonData=");
            C1487xt b2 = C1487xt.b();
            String access$2002 = loginActivity.enteredMobileNumber;
            String mid2 = loginActivity.getMid();
            String access$3002 = loginActivity.generatedChecksum;
            b2.getClass();
            sb2.append(C1155he.a(C1487xt.a(access$2002, mid2, access$3002, LoginActivity.MOBILE_OTP_DELIVERY_METHOD_SMS)));
            return sb2.toString();
        }

        public final String getRequestUrl() {
            return C1488xu.i().concat("/HANDLER_INTERNAL/GENERATE_OTP");
        }
    }

    public class j implements C1310ov.b {
        public j() {
        }

        public final HashMap<String, String> a() {
            return new HashMap<>();
        }

        public final Object b() {
            StringBuilder sb = new StringBuilder("JsonData=");
            C1487xt b = C1487xt.b();
            LoginActivity loginActivity = LoginActivity.this;
            String obj = loginActivity.otpET.getText().toString();
            String access$500 = loginActivity.getState();
            String mid = loginActivity.getMid();
            b.getClass();
            TreeMap treeMap = new TreeMap();
            try {
                treeMap.put("OTP", obj);
                treeMap.put("MID", mid);
                treeMap.put("STATE", access$500);
            } catch (Exception unused) {
            }
            sb.append(C1155he.a(treeMap));
            return sb.toString();
        }

        public final String getRequestUrl() {
            return C1488xu.i().concat("/HANDLER_INTERNAL/VALIDATE_OTP");
        }
    }

    public class k implements C1310ov.b {
        public final HashMap<String, String> a() {
            return new HashMap<>();
        }

        public final Object b() {
            return null;
        }

        public final String getRequestUrl() {
            return null;
        }
    }

    public class l implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public l(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class m implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public m(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
            Intent intent = new Intent();
            intent.putExtra("flow", "cancel");
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.setResult(-3, intent);
            loginActivity.finish();
        }
    }

    private void HandleKeyboardEventDialog(EditText editText) {
        editText.setOnEditorActionListener(new d());
    }

    private void cancelTimer() {
        n nVar = this.mCountdown;
        if (nVar != null) {
            nVar.cancel();
        }
    }

    private void clearActionMessage() {
        this.screenactionHint.setText("");
    }

    private void clearCheckSum() {
        this.generatedChecksum = "";
    }

    private TreeMap<String, String> generateCheckSumData(String str, String str2, String str3) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("PHONE", str);
        treeMap.put("USER_TYPE", "01");
        treeMap.put("RESPONSE_TYPE", "token");
        treeMap.put("SCOPE", "paytm,txn");
        treeMap.put("MID", str2);
        treeMap.put("OTP_DELIVERY_METHOD", str3);
        return treeMap;
    }

    private void generateOTP(C1310ov.b bVar) {
        new C1310ov(this, new ResponseGenerateOTP(), this, bVar, 1).execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public String getState() {
        return this.state;
    }

    private void initviews() {
        this.otpET = (EditText) findViewById(C0501Er.otp_et);
        this.submitBTN = (Button) findViewById(C0501Er.otp_submit_screen_submit_btn);
        this.resendOTP = (TextView) findViewById(C0501Er.otp_submit_screen_resend_otp_tv);
        this.loginwithDiffID = (TextView) findViewById(C0501Er.otp_submit_screen_desc_hint_tv);
        this.otpSendModeRL = (RelativeLayout) findViewById(C0501Er.otp_submit_screen_timer_parent_rl);
        this.screenactionHint = (TextView) findViewById(C0501Er.user_action_desc_tv);
        this.tvError = (TextView) findViewById(C0501Er.otp_submit_error);
        this.mProgressBar = (ProgressBar) findViewById(C0501Er.progress_bar_login);
        this.termcondition = (TextView) findViewById(C0501Er.termcondition_string);
        this.loginBTN = (Button) findViewById(C0501Er.otp_submit_screen_login_btn);
        this.mobileET = (EditText) findViewById(C0501Er.mobile_et);
        this.timer = (TextView) findViewById(C0501Er.otp_submit_screen_timer_tv);
        this.heading = (ImageView) findViewById(C0501Er.tv_left_heading);
        ImageButton imageButton = (ImageButton) findViewById(C0501Er.header_back_button);
        this.backIcon = imageButton;
        int i2 = C1073dl.a;
        if (i2 > 0) {
            imageButton.setImageResource(i2);
        }
        this.submitBTN.setOnClickListener(this);
        this.loginBTN.setOnClickListener(this);
        this.resendOTP.setOnClickListener(this);
        this.loginwithDiffID.setOnClickListener(this);
        this.backIcon.setOnClickListener(this);
        this.termcondition.setText(Html.fromHtml(getString(C0787as.term_condition)));
        this.termcondition.setClickable(true);
        this.termcondition.setMovementMethod(LinkMovementMethod.getInstance());
        this.genericDialogparams = setGenericDialog();
        this.mobileET.addTextChangedListener(this.textWatcher);
        this.otpET.addTextChangedListener(this.textWatcher);
        setText(getString(C0787as.payment_progress));
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        registerSMSReceiver();
        this.originalPassesNumber = getpassedMobileNumber();
        if (TB.b(this.enteredMobileNumber)) {
            this.mobileET.setEnabled(true);
            this.mobileET.setText(this.enteredMobileNumber);
            String str = getchecksumgenerationUrl();
            TreeMap<String, String> generateCheckSumData = generateCheckSumData(this.enteredMobileNumber, getMid(), MOBILE_OTP_DELIVERY_METHOD_SMS);
            getpaytmClientCertificate();
            new C1155he(generateCheckSumData, str, this, this).execute(new String[0]);
        }
        TB.c(this.mobileET, true, this);
        openLoginLayout();
    }

    public static boolean isVersionMarshmallowAndAbove() {
        return true;
    }

    /* access modifiers changed from: private */
    public void openLoginLayout() {
        this.otpET.setVisibility(8);
        this.submitBTN.setVisibility(8);
        this.resendOTP.setVisibility(8);
        this.otpSendModeRL.setVisibility(8);
        this.loginwithDiffID.setVisibility(8);
        findViewById(C0501Er.otp_submit_screen_otp_sent_tv).setVisibility(8);
        this.termcondition.setVisibility(0);
        this.loginBTN.setVisibility(0);
        this.mobileET.setVisibility(0);
        setActionMessage(getString(C0787as.logn_screen_heading));
        this.otpET.setText("");
        removeAutoreadOTPfunctionality();
    }

    private void openSubmitOTPLayout() {
        this.otpET.setVisibility(0);
        this.submitBTN.setVisibility(0);
        this.resendOTP.setVisibility(0);
        this.otpSendModeRL.setVisibility(0);
        this.loginwithDiffID.setVisibility(0);
        this.termcondition.setVisibility(8);
        this.loginBTN.setVisibility(8);
        this.mobileET.setVisibility(8);
        addAutoreadOTPfunctionality();
        TB.c(this.otpET, false, this);
    }

    private void setActionMessage(CharSequence charSequence) {
        this.screenactionHint.setText(charSequence);
    }

    private void setCheckSum(String str) {
        this.generatedChecksum = str;
    }

    private BaseActivity.a setGenericDialog() {
        BaseActivity.a dialogParams = getDialogParams();
        dialogParams.f4097b = getString(C0787as.generic_err_heading);
        dialogParams.f4096a = getString(C0787as.generic_err_message);
        dialogParams.c = getString(C0787as.generic_err_right_btn);
        dialogParams.a = new b();
        dialogParams.b = new c();
        return dialogParams;
    }

    private void showCancelTransactionAlert() {
        synchronized (C1354qp.class) {
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(C0697Tr.alert_back_dialog, (ViewGroup) null);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        ((TextView) inflate.findViewById(C0501Er.bttn_no)).setOnClickListener(new l(create));
        ((TextView) inflate.findViewById(C0501Er.bttn_yes)).setOnClickListener(new m(create));
        create.show();
    }

    private void showErrorDialog(CharSequence charSequence) {
        if (!isFinishing() || !this.isActivityStopped) {
            try {
                Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(1);
                dialog.setContentView(C0697Tr.login_error_dialog);
                ((TextView) dialog.findViewById(C0501Er.login_error_screen_error_msg_tv)).setText(charSequence);
                LinearLayout linearLayout = (LinearLayout) dialog.findViewById(C0501Er.login_error_screen_try_oter_opt_parent);
                if (linearLayout != null && C1073dl.d) {
                    linearLayout.setVisibility(8);
                }
                ((Button) dialog.findViewById(C0501Er.login_error_screen_action_btn)).setOnClickListener(new f(dialog));
                TextView textView = (TextView) dialog.findViewById(C0501Er.login_error_screen_try_oter_opt_tv);
                textView.setText(Html.fromHtml(getString(C0787as.try_othr_options)));
                textView.setOnClickListener(new g(dialog));
                ((ImageView) dialog.findViewById(C0501Er.login_error_screen_cancel)).setOnClickListener(new h(dialog));
                dialog.show();
            } catch (Exception unused) {
            }
        }
    }

    private void showeditTextError(String str) {
        this.tvError.setText(str);
        this.tvError.setVisibility(0);
        TextView textView = this.tvError;
        textView.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(new ScaleAnimation(0.0f, 0.0f, 1.0f, 1.0f));
        animationSet.setAnimationListener(new C0678SB());
        textView.startAnimation(animationSet);
    }

    private void startTimer() {
        findViewById(C0501Er.otp_submit_screen_resend_otp_tv).setVisibility(8);
        findViewById(C0501Er.otp_submit_screen_otp_sent_tv).setVisibility(0);
        n nVar = new n();
        this.mCountdown = nVar;
        nVar.start();
    }

    /* access modifiers changed from: private */
    public void updateOTPLayoutEnable(boolean z) {
        if (this.mobileET.getVisibility() == 0) {
            findViewById(C0501Er.otp_submit_screen_resend_otp_tv).setVisibility(8);
        } else {
            findViewById(C0501Er.otp_submit_screen_resend_otp_tv).setVisibility(0);
        }
        findViewById(C0501Er.otp_submit_screen_otp_sent_tv).setVisibility(8);
    }

    public String checkSms(String str) {
        Matcher matcher = Pattern.compile("(|^)\\d{6}").matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    public void fetchBalance() {
        this.mProgressBar.setVisibility(0);
        new C1310ov(this, new ResponseCheckBalance(), this, this.checkBalanceRequestprovider, 2).execute(new String[0]);
    }

    public String getMid() {
        try {
            return getIntent().getStringExtra(PASSED_MID);
        } catch (Exception unused) {
            return "";
        }
    }

    public String getchecksumgenerationUrl() {
        String stringExtra = getIntent().getStringExtra(CHECKSUM_GENERATION_URL);
        if (stringExtra == null) {
            return "";
        }
        return stringExtra;
    }

    public String getpassedMobileNumber() {
        String str = "";
        try {
            str = getIntent().getStringExtra(MOBILE_KEY);
            if (!TextUtils.isEmpty(str)) {
                this.enteredMobileNumber = str.substring(str.length() - 10, str.length());
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public PaytmClientCertificate getpaytmClientCertificate() {
        Intent intent = getIntent();
        return new PaytmClientCertificate(intent.getStringExtra(CERTIFICATE_PASSWORD), intent.getStringExtra(CERTIFICATE_FILENAME));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 115 && intent != null) {
            Bundle extras = intent.getExtras();
            Intent intent2 = new Intent();
            intent2.putExtra("flow", extras.getString("flow"));
            intent2.putExtra(PaymentConstants.Event.SCREEN, extras.getString(PaymentConstants.Event.SCREEN));
            setResult(-1, intent2);
            finish();
        } else if (i3 == -1 && i2 == 116 && intent != null) {
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
            setResult(-2, intent3);
            finish();
        } else if (i3 != -3) {
        } else {
            if (C1073dl.d) {
                openLoginLayout();
                showCancelTransactionAlert();
                return;
            }
            finish();
        }
    }

    public void onBackPressed() {
        cancelTimer();
        if (this.otpET.getVisibility() == 0 && !TextUtils.isEmpty(this.mobileET.getText())) {
            openLoginLayout();
        } else if (C1073dl.d) {
            showCancelTransactionAlert();
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        clearActionMessage();
        if (view == this.loginBTN) {
            this.mProgressBar.setVisibility(0);
            String obj = this.mobileET.getText().toString();
            this.enteredMobileNumber = obj;
            this.originalPassesNumber = obj;
            if (TB.b(obj)) {
                String str = getchecksumgenerationUrl();
                TreeMap<String, String> generateCheckSumData = generateCheckSumData(this.enteredMobileNumber, getMid(), MOBILE_OTP_DELIVERY_METHOD_SMS);
                getpaytmClientCertificate();
                new C1155he(generateCheckSumData, str, this, this).execute(new String[0]);
                this.loginBTN.setEnabled(false);
                TB.c(this.mobileET, false, this);
                return;
            }
            this.mProgressBar.setVisibility(8);
            showeditTextError(getString(C0787as.error_msg_invalid_mobile_no));
        } else if (view == this.submitBTN) {
            this.mProgressBar.setVisibility(0);
            if (!TextUtils.isEmpty(this.otpET.getText().toString())) {
                new C1310ov(this, new ResponseValidateOTP(), this, this.validateOTPrequestProvider, 1).execute(new String[0]);
                this.submitBTN.setEnabled(false);
                TB.c(this.otpET, false, this);
                return;
            }
            this.tvError.setText(getString(C0787as.error_wrong_otp));
            this.tvError.setVisibility(0);
            this.mProgressBar.setVisibility(8);
        } else if (view == this.resendOTP) {
            this.mProgressBar.setVisibility(0);
            this.otpET.setText("");
            String str2 = getchecksumgenerationUrl();
            TreeMap<String, String> generateCheckSumData2 = generateCheckSumData(this.enteredMobileNumber, getMid(), MOBILE_OTP_DELIVERY_METHOD_SMS);
            getpaytmClientCertificate();
            new C1155he(generateCheckSumData2, str2, this, this).execute(new String[0]);
        } else if (view == this.loginwithDiffID) {
            openLoginLayout();
            this.mProgressBar.setVisibility(8);
        } else if (view == this.backIcon) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0697Tr.login);
        Bundle extras = getIntent().getExtras();
        if (extras.containsKey("balance_available")) {
            if (extras.getBoolean("balance_available")) {
                startActivityForResult(new Intent(this, PaymentBalanceAvailableActivity.class), 115);
            } else {
                startActivityForResult(new Intent(this, PaytmSavedCardActivity.class), 116);
            }
        }
        checkSMSPermission();
        initviews();
        setDynamicPermissions();
    }

    public void onDestroy() {
        super.onDestroy();
        removeAutoreadOTPfunctionality();
    }

    public void onOTPreceived(String str) {
        this.otpET.setText(checkSms(str));
    }

    public void onPostResponse(BaseResponseModal baseResponseModal) {
        ProgressBar progressBar;
        Double d2;
        try {
            this.mProgressBar.setVisibility(8);
            if (baseResponseModal == null) {
                this.mobileET.setEnabled(true);
                this.submitBTN.setEnabled(true);
                this.isOTPoncallClicked = false;
            } else if (baseResponseModal instanceof ResponseGenerateOTP) {
                this.loginBTN.setEnabled(true);
                ResponseGenerateOTP responseGenerateOTP = (ResponseGenerateOTP) baseResponseModal;
                String str = responseGenerateOTP.successStatus;
                if (str != null) {
                    if (str.equalsIgnoreCase("SUCCESS")) {
                        openSubmitOTPLayout();
                        setActionMessage(responseGenerateOTP.ServersuccessStatus);
                        setState(responseGenerateOTP);
                        if (this.isOTPoncallClicked) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(getString(C0787as.msg_action_otp_on_call_sent));
                            sb.append(String.format(" <b>" + this.enteredMobileNumber + "</b>", new Object[0]));
                            setActionMessage(Html.fromHtml(sb.toString()));
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(getString(C0787as.msg_action_otp_sent));
                            sb2.append(String.format(" <b>" + this.enteredMobileNumber + "</b>", new Object[0]));
                            setActionMessage(Html.fromHtml(sb2.toString()));
                        }
                        startTimer();
                        this.mobileET.setEnabled(true);
                        this.submitBTN.setEnabled(true);
                        this.isOTPoncallClicked = false;
                    }
                }
                String str2 = responseGenerateOTP.errorStatus;
                if (str2 != null && str2.equalsIgnoreCase("FAILURE")) {
                    if (responseGenerateOTP.serverErrorCode.equalsIgnoreCase(GENERATE_OTP_NUMBER_NOT_REGISTERED)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(getString(C0787as.temp_string_notregistered_part1));
                        sb3.append(String.format(" <b>" + this.originalPassesNumber + "</b> " + getString(C0787as.temp_string_notregistered_part2), new Object[0]));
                        showErrorDialog(Html.fromHtml(sb3.toString()));
                    } else if (responseGenerateOTP.serverErrorCode.equalsIgnoreCase(GENERATE_OTP_OTP_LIMIT_REACHED)) {
                        showeditTextError(responseGenerateOTP.serverErrorMessage);
                    } else if (responseGenerateOTP.serverErrorCode.equalsIgnoreCase(GENERATE_OTP_INVALID_EMAIL)) {
                        showeditTextError(responseGenerateOTP.serverErrorMessage);
                    } else if (responseGenerateOTP.serverErrorCode.equalsIgnoreCase(GENERATE_OTP_INVALID_AUTHORIZATION)) {
                        showeditTextError(responseGenerateOTP.serverErrorMessage);
                    } else if (responseGenerateOTP.serverErrorCode.equalsIgnoreCase(GENERATE_OTP_ACCOUNT_BLOCKED)) {
                        showeditTextError(responseGenerateOTP.serverErrorMessage);
                    } else {
                        openGenericDialog(this.genericDialogparams).show();
                    }
                }
                this.mobileET.setEnabled(true);
                this.submitBTN.setEnabled(true);
                this.isOTPoncallClicked = false;
            } else {
                if (baseResponseModal instanceof ResponseValidateOTP) {
                    this.submitBTN.setEnabled(true);
                    ResponseValidateOTP responseValidateOTP = (ResponseValidateOTP) baseResponseModal;
                    String str3 = responseValidateOTP.STATUS;
                    if (str3 == null || !str3.equalsIgnoreCase("SUCCESS")) {
                        String str4 = responseValidateOTP.STATUS;
                        if (str4 == null || !str4.equalsIgnoreCase("FAILURE")) {
                            openGenericDialog(this.genericDialogparams).show();
                        } else if (responseValidateOTP.ErrorCode.equalsIgnoreCase(VALIDATE_OTP_INVALID_OTP)) {
                            showeditTextError(responseValidateOTP.ErrorMsg);
                        } else if (responseValidateOTP.ErrorCode.equalsIgnoreCase(VALIDATE_OTP_LOGIN_FAILED)) {
                            showeditTextError(responseValidateOTP.ErrorMsg);
                        } else {
                            openGenericDialog(this.genericDialogparams).show();
                        }
                    } else {
                        addAutoreadOTPfunctionality();
                        Tokens.setValidateResponse((ResponseValidateOTP) baseResponseModal);
                        fetchBalance();
                    }
                } else if (baseResponseModal instanceof ResponseCheckBalance) {
                    try {
                        ResponseCheckBalance responseCheckBalance = (ResponseCheckBalance) baseResponseModal;
                        if (responseCheckBalance.statusCode.equalsIgnoreCase("SUCCESS")) {
                            Double valueOf = Double.valueOf(Double.parseDouble(responseCheckBalance.response.amount));
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
                            C1073dl.a().f5444a = valueOf;
                            C1073dl.a().f5447b = String.valueOf(d2);
                            if (d2.doubleValue() <= valueOf.doubleValue()) {
                                startActivityForResult(new Intent(this, PaymentBalanceAvailableActivity.class), 115);
                            } else {
                                startActivityForResult(new Intent(this, PaytmSavedCardActivity.class), 116);
                            }
                        } else {
                            openGenericDialog(this.genericDialogparams).show();
                        }
                        progressBar = this.mProgressBar;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        openGenericDialog(this.genericDialogparams).show();
                        progressBar = this.mProgressBar;
                    }
                    progressBar.setVisibility(8);
                }
                this.mobileET.setEnabled(true);
                this.submitBTN.setEnabled(true);
                this.isOTPoncallClicked = false;
            }
        } catch (Exception e3) {
            try {
                e3.printStackTrace();
            } catch (Throwable th) {
                this.mobileET.setEnabled(true);
                this.submitBTN.setEnabled(true);
                this.isOTPoncallClicked = false;
                throw th;
            }
        } catch (Throwable th2) {
            this.mProgressBar.setVisibility(8);
            throw th2;
        }
    }

    public void onStart() {
        super.onStart();
        this.isActivityStopped = false;
    }

    public void onStop() {
        super.onStop();
        this.isActivityStopped = true;
    }

    public void postHttpError(BaseResponseModal baseResponseModal) {
        String str;
        this.mProgressBar.setVisibility(8);
        if (!(baseResponseModal == null || (str = baseResponseModal.error) == null)) {
            showErrorDialog(str);
        }
        this.mobileET.setEnabled(true);
        this.submitBTN.setEnabled(true);
    }

    public void setDynamicPermissions() {
        String str = C1073dl.c;
        if (str != null) {
            this.submitBTN.setBackgroundColor(Color.parseColor(str));
            this.loginBTN.setBackgroundColor(Color.parseColor(C1073dl.c));
            this.resendOTP.setTextColor(Color.parseColor(C1073dl.c));
            this.loginwithDiffID.setTextColor(Color.parseColor(C1073dl.c));
        }
    }

    public void setState(ResponseGenerateOTP responseGenerateOTP) {
        this.state = responseGenerateOTP.state;
    }

    private void addAutoreadOTPfunctionality() {
    }

    private void checkSMSPermission() {
    }

    private void registerSMSReceiver() {
    }

    private void removeAutoreadOTPfunctionality() {
    }

    public class n extends CountDownTimer {
        public n() {
            super(5000, 1000);
        }

        public final void onFinish() {
            LoginActivity.this.updateOTPLayoutEnable(true);
        }

        public final void onTick(long j) {
        }
    }

    private void setText(String str) {
    }

    public class b implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onPostResponse(String str) {
        try {
            this.mProgressBar.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = C1155he.a;
                setCheckSum(jSONObject.optJSONObject("response").optString("CHECKSUMHASH"));
                String optString = jSONObject.optString("error");
                if (jSONObject.optInt("errorCode") != 200) {
                    Toast.makeText(this, optString, 1).show();
                    this.loginBTN.setEnabled(true);
                    this.submitBTN.setEnabled(true);
                } else if (TB.b(this.enteredMobileNumber)) {
                    this.mProgressBar.setVisibility(0);
                    generateOTP(this.generateOTPrequestProvider);
                } else {
                    this.mProgressBar.setVisibility(8);
                    showeditTextError(getString(C0787as.error_msg_invalid_mobile_no));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            this.mobileET.setEnabled(true);
            this.submitBTN.setEnabled(true);
            throw th;
        }
        this.mobileET.setEnabled(true);
        this.submitBTN.setEnabled(true);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public class a implements TextWatcher {
        public a() {
        }

        public final void afterTextChanged(Editable editable) {
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.tvError.setText("");
            loginActivity.tvError.setVisibility(8);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
