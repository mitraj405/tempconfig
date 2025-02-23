package com.paytm.pgsdk.sdknative;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.pgsdk.BaseActivity;
import in.juspay.hypersdk.core.PaymentConstants;

public class PaymentBalanceAvailableActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton backIcon;
    private TextView mFare;
    private TextView mPaytmBalanceTxt;
    private RelativeLayout mRelativeProceed;
    private TextView mServiceCharge;
    private TextView mTextProceed;
    private TextView mTextTotal;

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(PaymentConstants.Event.SCREEN, "mainscreen");
        setResult(-3, intent);
        finish();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C0501Er.rel_proceed_pay || id == C0501Er.txt_proceed_to_pay) {
            Intent intent = new Intent();
            intent.putExtra("flow", "sufficient");
            intent.putExtra(PaymentConstants.Event.SCREEN, "balance_available");
            setResult(-1, intent);
            finish();
        }
        if (view == this.backIcon) {
            Intent intent2 = new Intent();
            intent2.putExtra(PaymentConstants.Event.SCREEN, "mainscreen");
            setResult(-3, intent2);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0697Tr.activity_payment_balance_available);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        this.mFare = (TextView) findViewById(C0501Er.txt_amount_ticket_fare);
        this.mServiceCharge = (TextView) findViewById(C0501Er.txt_service_amount_ticket_fare);
        this.mTextTotal = (TextView) findViewById(C0501Er.txt_total_amount);
        this.mPaytmBalanceTxt = (TextView) findViewById(C0501Er.txt_amount_paytm_balance);
        this.mRelativeProceed = (RelativeLayout) findViewById(C0501Er.rel_proceed_pay);
        this.mTextProceed = (TextView) findViewById(C0501Er.txt_proceed_to_pay);
        ImageButton imageButton = (ImageButton) findViewById(C0501Er.header_back_button);
        this.backIcon = imageButton;
        int i = C1073dl.a;
        if (i > 0) {
            imageButton.setImageResource(i);
        }
        TextView textView = this.mFare;
        StringBuilder sb = new StringBuilder();
        int i2 = C0787as.paytm_rs;
        sb.append(getString(i2));
        sb.append(C1073dl.a().f5445a);
        textView.setText(sb.toString());
        C1073dl.a();
        if (C1073dl.b().containsKey("PPI")) {
            TextView textView2 = this.mServiceCharge;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString(i2));
            C1073dl.a();
            sb2.append(C1073dl.b().get("PPI").getFee());
            textView2.setText(sb2.toString());
            TextView textView3 = this.mTextTotal;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getString(i2));
            C1073dl.a();
            sb3.append(C1073dl.b().get("PPI").getTxnAmount());
            textView3.setText(sb3.toString());
        } else if (C0709Uj.u("DEFAULTFEE")) {
            TextView textView4 = this.mServiceCharge;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(getResources().getString(i2));
            C1073dl.a();
            sb4.append(C1073dl.b().get("DEFAULTFEE").getFee());
            textView4.setText(sb4.toString());
            TextView textView5 = this.mTextTotal;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getString(i2));
            C1073dl.a();
            sb5.append(C1073dl.b().get("DEFAULTFEE").getTxnAmount());
            textView5.setText(sb5.toString());
        } else {
            TextView textView6 = this.mTextTotal;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(getString(i2));
            lf.x(sb6, C1073dl.a().f5445a, textView6);
        }
        TextView textView7 = this.mPaytmBalanceTxt;
        textView7.setText(getString(i2) + C1073dl.a().f5444a);
        this.mRelativeProceed.setOnClickListener(this);
        this.mTextProceed.setOnClickListener(this);
        this.backIcon.setOnClickListener(this);
        setDynamicPermissions();
    }

    public void setDynamicPermissions() {
        this.mRelativeProceed.setBackgroundColor(Color.parseColor(C1073dl.c));
    }
}
