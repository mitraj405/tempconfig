package cris.org.in.ima.activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.adaptors.FareBreakupAdapter;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.InformationMessageDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.util.Iterator;
import java.util.List;

public class FareBreakupActivity extends AppCompatActivity {
    @BindView(2131362025)
    RelativeLayout Basefare1;
    public AvlFareResponseDTO a;

    /* renamed from: a  reason: collision with other field name */
    public TrainBtwnStnsDTO f4166a;
    @BindView(2131362024)
    TextView base_fare;
    @BindView(2131364310)
    TextView basicPay;
    public String c;
    @BindView(2131364332)
    TextView cateringCharges;
    @BindView(2131362145)
    RelativeLayout cateringcharge_ll;
    @BindView(2131364389)
    TextView dynamicCharges;
    @BindView(2131362464)
    RelativeLayout dynamiccharge_ll;
    @BindView(2131362496)
    TextView enqClass;
    @BindView(2131362636)
    TextView fareLableMessage;
    @BindView(2131363212)
    LinearLayout messageLable;
    @BindView(2131364498)
    TextView netpayCharges;
    @BindView(2131363394)
    RelativeLayout otherCharge_ll;
    @BindView(2131364518)
    TextView otherCharges;
    @BindView(2131364569)
    TextView reservationCharges;
    @BindView(2131363681)
    RelativeLayout reservationll;
    @BindView(2131363812)
    RecyclerView rvFareBackup;
    @BindView(2131363866)
    ScrollView scrollViewDirect;
    @BindView(2131363867)
    ScrollView scrollViewInDirect;
    @BindView(2131364598)
    TextView serviceCharges;
    @BindView(2131363946)
    RelativeLayout service_charges;
    @BindView(2131364043)
    RelativeLayout super_fast_charge_ll;
    @BindView(2131364625)
    TextView superfastCharges;
    @BindView(2131364656)
    TextView tatkalCharges;
    @BindView(2131364067)
    RelativeLayout tatkalcharge_ll;
    @BindView(2131364203)
    TextView train_no;
    @BindView(2131364621)
    TextView tv_sub_title_name;
    @BindView(2131364814)
    View view1;
    @BindView(2131364815)
    View view11;
    @BindView(2131364816)
    View view2;
    @BindView(2131364817)
    View view3;
    @BindView(2131364818)
    View view4;
    @BindView(2131364819)
    View view5;
    @BindView(2131364820)
    View view6;
    @BindView(2131364821)
    View view66;

    static {
        C1354qp.R(FareBreakupActivity.class);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131362015})
    public void onBackArrowClick() {
        onBackPressed();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fare_breakup1);
        ButterKnife.bind((Activity) this);
        Intent intent = getIntent();
        if (intent != null) {
            intent.getStringExtra("jDateString");
            this.a = (AvlFareResponseDTO) intent.getSerializableExtra("FareResponse");
            this.f4166a = (TrainBtwnStnsDTO) getIntent().getExtras().getSerializable("TrainBtwnStnsDTO");
            List list = (List) intent.getSerializableExtra("FareResponseList");
            List list2 = (List) intent.getSerializableExtra("trainBtwnStnsModelsList");
            if (list != null) {
                this.scrollViewDirect.setVisibility(8);
                this.scrollViewInDirect.setVisibility(0);
                FareBreakupAdapter fareBreakupAdapter = new FareBreakupAdapter(getApplicationContext(), list, list2);
                this.rvFareBackup.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                this.rvFareBackup.setAdapter(fareBreakupAdapter);
                return;
            }
            this.c = intent.getStringExtra("toolbarSubtitle");
            AvlFareResponseDTO avlFareResponseDTO = this.a;
            if (avlFareResponseDTO != null && avlFareResponseDTO.getBaseFare() != null) {
                if (this.f4166a.getTrainOwner().byteValue() == 1) {
                    this.base_fare.setText(getString(R.string.Ticket_Fare));
                    this.cateringcharge_ll.setVisibility(8);
                    this.view6.setVisibility(8);
                }
                this.tv_sub_title_name.setText(this.c);
                if (this.a.getBaseFare().intValue() != 0 || this.a.getBaseFare() == null) {
                    this.Basefare1.setVisibility(0);
                } else {
                    this.Basefare1.setVisibility(8);
                }
                if (this.a.getReservationCharge().intValue() != 0 || this.a.getReservationCharge() == null) {
                    this.reservationll.setVisibility(0);
                } else {
                    this.reservationll.setVisibility(8);
                    this.view1.setVisibility(8);
                }
                if (this.a.getSuperfastCharge().intValue() != 0 || this.a.getSuperfastCharge() == null) {
                    this.super_fast_charge_ll.setVisibility(0);
                } else {
                    this.super_fast_charge_ll.setVisibility(8);
                    this.view2.setVisibility(8);
                }
                if (this.a.getTatkalFare().intValue() != 0 || this.a.getTatkalFare() == null) {
                    this.tatkalcharge_ll.setVisibility(0);
                } else {
                    this.tatkalcharge_ll.setVisibility(8);
                    this.view3.setVisibility(8);
                }
                if (this.a.getDynamicFare().intValue() != 0 || this.a.getDynamicFare() == null) {
                    this.dynamiccharge_ll.setVisibility(0);
                } else {
                    this.dynamiccharge_ll.setVisibility(8);
                    this.view4.setVisibility(8);
                }
                if (this.a.getOtherCharge().intValue() != 0 || this.a.getOtherCharge() == null) {
                    this.otherCharge_ll.setVisibility(0);
                } else {
                    this.otherCharge_ll.setVisibility(8);
                    this.view5.setVisibility(8);
                }
                if (this.a.getServiceTax().floatValue() != 0.0f || this.a.getServiceTax() == null) {
                    this.service_charges.setVisibility(0);
                } else {
                    this.service_charges.setVisibility(8);
                    this.view66.setVisibility(8);
                }
                if (this.a.getCateringCharge().intValue() != 0 || this.a.getCateringCharge() == null) {
                    this.cateringcharge_ll.setVisibility(0);
                } else {
                    this.cateringcharge_ll.setVisibility(8);
                    this.view6.setVisibility(8);
                }
                this.train_no.setText(this.a.getTrainNo());
                this.enqClass.setText(this.a.getEnqClass());
                TextView textView = this.basicPay;
                textView.setText(getString(R.string.rupees) + this.a.getBaseFare().toString());
                TextView textView2 = this.reservationCharges;
                textView2.setText(getString(R.string.rupees) + this.a.getReservationCharge().toString());
                TextView textView3 = this.superfastCharges;
                textView3.setText(getString(R.string.rupees) + this.a.getSuperfastCharge().toString());
                TextView textView4 = this.tatkalCharges;
                textView4.setText(getString(R.string.rupees) + this.a.getTatkalFare().toString());
                if (this.a.getServiceTax().intValue() == ((int) Math.ceil((double) this.a.getServiceTax().floatValue()))) {
                    TextView textView5 = this.serviceCharges;
                    textView5.setText(getString(R.string.rupees) + ((int) Math.ceil((double) this.a.getServiceTax().floatValue())));
                } else {
                    TextView textView6 = this.serviceCharges;
                    textView6.setText(getString(R.string.rupees) + this.a.getServiceTax());
                }
                TextView textView7 = this.cateringCharges;
                textView7.setText(getString(R.string.rupees) + this.a.getCateringCharge().toString());
                TextView textView8 = this.netpayCharges;
                textView8.setText(getString(R.string.rupees) + this.a.getTotalFare().toString());
                TextView textView9 = this.otherCharges;
                textView9.setText(getString(R.string.rupees) + this.a.getOtherCharge().toString());
                TextView textView10 = this.dynamicCharges;
                textView10.setText(getString(R.string.rupees) + this.a.getDynamicFare().toString());
                Iterator<InformationMessageDTO> it = this.a.getInformationMessage().iterator();
                String str = "";
                String str2 = str;
                while (it.hasNext()) {
                    InformationMessageDTO next = it.next();
                    if (next.getParamName().equalsIgnoreCase("FARE_BREAKUP")) {
                        if (next.getPopup().booleanValue()) {
                            str2 = next.getMessage();
                        } else {
                            str = next.getMessage();
                        }
                    }
                }
                if (!str.trim().equals("")) {
                    this.messageLable.setVisibility(0);
                    this.fareLableMessage.setText(str.replace("Rs.", getString(R.string.rupees)));
                }
                if (!str2.trim().equals("")) {
                    C0535I5.o(this, str2, getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                }
            }
        }
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }
}
