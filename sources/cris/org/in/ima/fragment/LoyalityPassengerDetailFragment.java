package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import defpackage.d7;
import java.util.ArrayList;
import java.util.Iterator;
import rx.Subscriber;

public class LoyalityPassengerDetailFragment extends Fragment {
    public static C0794b3 a;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static String j = null;
    public static String k;
    public static String l;

    /* renamed from: a  reason: collision with other field name */
    public final C0515Ga f4724a = new C0515Ga();

    /* renamed from: a  reason: collision with other field name */
    public Z2 f4725a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4726a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4727a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f4728a = null;

    /* renamed from: a  reason: collision with other field name */
    public EditText f4729a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f4730a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4731a;

    /* renamed from: a  reason: collision with other field name */
    public GoogleAdParamDTO f4732a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4733a;

    /* renamed from: a  reason: collision with other field name */
    public PassengerDetailDTO f4734a;

    /* renamed from: a  reason: collision with other field name */
    public C1100f2 f4735a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f4736a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final C1358qx f4737a = new C1358qx();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4738a = false;
    @BindView(2131364261)
    RadioButton accural;
    @BindView(2131364281)
    TextView addLink;
    @BindView(2131361918)
    RelativeLayout addremove_loyaltyid_rl;
    public EditText b;

    /* renamed from: b  reason: collision with other field name */
    public PassengerDetailDTO f4739b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<PassengerDetailDTO> f4740b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f4741b;

    /* renamed from: c  reason: collision with other field name */
    public int f4742c = 1;

    /* renamed from: c  reason: collision with other field name */
    public String f4743c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<String> f4744c = new ArrayList<>();
    @BindView(2131362299)
    LinearLayout contact_detail;
    @BindView(2131362300)
    RelativeLayout contact_detail_rl;

    /* renamed from: d  reason: collision with other field name */
    public int f4745d = 0;

    /* renamed from: d  reason: collision with other field name */
    public String f4746d = null;

    /* renamed from: d  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4747d = null;

    /* renamed from: e  reason: collision with other field name */
    public final String f4748e = "";

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4749e = null;
    public String f;

    /* renamed from: f  reason: collision with other field name */
    public ArrayList<String> f4750f;
    public String g;

    /* renamed from: g  reason: collision with other field name */
    public ArrayList<C1311ox> f4751g;
    public String h = "";
    @BindView(2131362772)
    LinearLayout heading_loyaltyno_ll;
    public String i;
    @BindView(2131362991)
    LinearLayout linear;
    @BindView(2131362990)
    LinearLayout linear1;
    @BindView(2131363057)
    LinearLayout ll_radiogroup;
    @BindView(2131364472)
    TextView loyalityNumber;
    @BindView(2131363112)
    TextView loyalty_bank;
    @BindView(2131363120)
    LinearLayout loyalty_membership_detail_ll;
    @BindView(2131363589)
    RadioGroup radioGroup;
    @BindView(2131364555)
    RadioButton redemption;
    @BindView(2131364564)
    TextView removeLink;
    @BindView(2131364582)
    TextView sbiRewardPts;
    @BindView(2131364601)
    TextView skip;
    @BindView(2131364583)
    TextView tatalSbiPts;
    @BindView(2131364679)
    TextView totalAvlPts;
    @BindView(2131364442)
    TextView totalPurchasePts;
    @BindView(2131364676)
    TextView totalRedeemPts;

    public class b extends Subscriber<C1358qx> {
        public b() {
        }

        public final void onCompleted() {
            String str = LoyalityPassengerDetailFragment.j;
        }

        public final void onError(Throwable th) {
            String str = LoyalityPassengerDetailFragment.j;
            th.getClass();
            th.getMessage();
            LoyalityPassengerDetailFragment.this.f4726a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            ArrayList<PassengerDetailDTO> arrayList;
            C1358qx qxVar = (C1358qx) obj;
            LoyalityPassengerDetailFragment loyalityPassengerDetailFragment = LoyalityPassengerDetailFragment.this;
            if (qxVar == null) {
                loyalityPassengerDetailFragment.f4726a.dismiss();
                C0535I5.m(loyalityPassengerDetailFragment.f4727a, false, loyalityPassengerDetailFragment.getResources().getString(R.string.unable_process_message), loyalityPassengerDetailFragment.getString(R.string.error), loyalityPassengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (qxVar.getError() == null) {
                loyalityPassengerDetailFragment.f4740b.clear();
                Iterator<PassengerDetailDTO> it = qxVar.getPassengerDetailDTO().iterator();
                short s = 0;
                while (true) {
                    boolean hasNext = it.hasNext();
                    arrayList = loyalityPassengerDetailFragment.f4740b;
                    if (!hasNext) {
                        break;
                    }
                    PassengerDetailDTO next = it.next();
                    PassengerDetailDTO passengerDetailDTO = new PassengerDetailDTO();
                    loyalityPassengerDetailFragment.f4739b = passengerDetailDTO;
                    passengerDetailDTO.setPassengerAge(next.getPassengerAge());
                    loyalityPassengerDetailFragment.f4739b.setPassengerName(next.getPassengerName());
                    loyalityPassengerDetailFragment.f4739b.setSoftMemberFlag(Boolean.TRUE);
                    loyalityPassengerDetailFragment.f4739b.setPassengerGender(next.getPassengerGender());
                    PassengerDetailDTO passengerDetailDTO2 = loyalityPassengerDetailFragment.f4739b;
                    Boolean bool = Boolean.FALSE;
                    passengerDetailDTO2.setConcessionOpted(bool);
                    loyalityPassengerDetailFragment.f4739b.setForGoConcessionOpted(bool);
                    s = (short) (s + 1);
                    loyalityPassengerDetailFragment.f4739b.setPassengerSerialNumber(Short.valueOf(s));
                    loyalityPassengerDetailFragment.f4739b.setPassengerNationality("IN");
                    loyalityPassengerDetailFragment.f4739b.setSoftMemberId(next.getSoftMemberId());
                    arrayList.add(loyalityPassengerDetailFragment.f4739b);
                }
                if (loyalityPassengerDetailFragment.f4728a == null) {
                    loyalityPassengerDetailFragment.f4728a = new Bundle();
                }
                loyalityPassengerDetailFragment.f4728a.putSerializable("boardingStnListDTO", loyalityPassengerDetailFragment.f4725a);
                loyalityPassengerDetailFragment.f4728a.putSerializable("avlResponseDTO", loyalityPassengerDetailFragment.f4735a);
                loyalityPassengerDetailFragment.f4728a.putSerializable("TrainBtwnStnsDTOList", loyalityPassengerDetailFragment.f4749e);
                loyalityPassengerDetailFragment.f4728a.putSerializable("ssConcForgoText", loyalityPassengerDetailFragment.f4748e);
                loyalityPassengerDetailFragment.f4728a.putSerializable("selectedQuotaString", loyalityPassengerDetailFragment.f4743c);
                loyalityPassengerDetailFragment.f4728a.putSerializable("selectedQuota", LoyalityPassengerDetailFragment.j);
                loyalityPassengerDetailFragment.f4728a.putSerializable("googleAdParamDTO", loyalityPassengerDetailFragment.f4732a);
                loyalityPassengerDetailFragment.f4728a.putSerializable("enquiryRequestDTO", loyalityPassengerDetailFragment.f4724a);
                loyalityPassengerDetailFragment.f4728a.putSerializable("loyaltypsgnlist", arrayList);
                loyalityPassengerDetailFragment.f4728a.putSerializable("highestClass", loyalityPassengerDetailFragment.g);
                loyalityPassengerDetailFragment.f4728a.putString("JourneyDate", loyalityPassengerDetailFragment.f);
                loyalityPassengerDetailFragment.f4728a.putString("loyaltyBookingType", LoyalityPassengerDetailFragment.k);
                loyalityPassengerDetailFragment.f4728a.putSerializable("BookingConfig", LoyalityPassengerDetailFragment.a);
                loyalityPassengerDetailFragment.f4728a.putBoolean("isLoyalty", true);
                loyalityPassengerDetailFragment.f4728a.putString("AvailLastUpdate", loyalityPassengerDetailFragment.h);
                loyalityPassengerDetailFragment.f4728a.putBoolean("rebookFlag", LoyalityPassengerDetailFragment.c);
                loyalityPassengerDetailFragment.f4728a.putSerializable("reebookPsgnList", loyalityPassengerDetailFragment.f4747d);
                loyalityPassengerDetailFragment.f4728a.putString("softBankId", loyalityPassengerDetailFragment.i);
                loyalityPassengerDetailFragment.f4738a = true;
                loyalityPassengerDetailFragment.f4745d = 0;
                PassengerDetailFragment passengerDetailFragment = new PassengerDetailFragment();
                passengerDetailFragment.setArguments(loyalityPassengerDetailFragment.f4728a);
                loyalityPassengerDetailFragment.f4741b = false;
                HomeActivity.n(loyalityPassengerDetailFragment.f4727a, passengerDetailFragment, C1218kf.ADD_PASSENGER.a(), Boolean.TRUE, Boolean.FALSE);
                loyalityPassengerDetailFragment.f4726a.dismiss();
            } else {
                loyalityPassengerDetailFragment.f4726a.dismiss();
                C0535I5.m(loyalityPassengerDetailFragment.f4727a, false, qxVar.getError(), loyalityPassengerDetailFragment.getString(R.string.error), loyalityPassengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class c implements OnSelectionListener {
        public final /* synthetic */ View a;

        public c(View view) {
            this.a = view;
        }

        public final void onClick(String str) {
            String str2 = str;
            LoyalityPassengerDetailFragment loyalityPassengerDetailFragment = LoyalityPassengerDetailFragment.this;
            loyalityPassengerDetailFragment.loyalty_bank.setText(str2);
            String str3 = LoyalityPassengerDetailFragment.l;
            ArrayList arrayList = loyalityPassengerDetailFragment.f4736a;
            if (str3 != null && !str3.equals(str2)) {
                if (loyalityPassengerDetailFragment.f4745d >= 1) {
                    loyalityPassengerDetailFragment.linear.removeViewAt(0);
                    loyalityPassengerDetailFragment.linear1.removeViewAt(0);
                    loyalityPassengerDetailFragment.f4745d = 0;
                }
                arrayList.clear();
            }
            LoyalityPassengerDetailFragment.k = "";
            loyalityPassengerDetailFragment.accural.setChecked(false);
            loyalityPassengerDetailFragment.redemption.setChecked(false);
            loyalityPassengerDetailFragment.accural.setClickable(true);
            loyalityPassengerDetailFragment.redemption.setClickable(true);
            loyalityPassengerDetailFragment.skip.setClickable(true);
            loyalityPassengerDetailFragment.heading_loyaltyno_ll.setVisibility(8);
            loyalityPassengerDetailFragment.addremove_loyaltyid_rl.setVisibility(8);
            loyalityPassengerDetailFragment.linear.setVisibility(8);
            loyalityPassengerDetailFragment.linear1.setVisibility(8);
            loyalityPassengerDetailFragment.i = C1058d.e(str);
            LoyalityPassengerDetailFragment.l = str2;
            Iterator<C0471CB> it = C1450w1.f7017b.iterator();
            while (it.hasNext()) {
                C0471CB next = it.next();
                if (LoyalityPassengerDetailFragment.l.contains(next.getSoftAccountSummaryDTO().getBankName())) {
                    loyalityPassengerDetailFragment.f4733a.dismiss();
                    if (!next.getLoyaltyRedemptionBookingAllowed().booleanValue() && !next.getLoyaltyAccrualBookingAllowed().booleanValue()) {
                        Toast.makeText(loyalityPassengerDetailFragment.f4731a, loyalityPassengerDetailFragment.getString(R.string.accural_and_redemption_not_allowed_for_the_selected_bank), 1).show();
                        loyalityPassengerDetailFragment.ll_radiogroup.setVisibility(0);
                        loyalityPassengerDetailFragment.accural.setVisibility(8);
                        loyalityPassengerDetailFragment.redemption.setVisibility(8);
                        loyalityPassengerDetailFragment.addremove_loyaltyid_rl.setVisibility(8);
                    }
                    if (!next.getLoyaltyRedemptionBookingAllowed().booleanValue()) {
                        loyalityPassengerDetailFragment.redemption.setVisibility(8);
                        loyalityPassengerDetailFragment.ll_radiogroup.setVisibility(0);
                    } else if (!LoyalityPassengerDetailFragment.l.contains("SBI")) {
                        loyalityPassengerDetailFragment.redemption.setVisibility(8);
                        loyalityPassengerDetailFragment.ll_radiogroup.setVisibility(0);
                        loyalityPassengerDetailFragment.accural.setVisibility(0);
                    } else {
                        loyalityPassengerDetailFragment.f4733a.dismiss();
                        loyalityPassengerDetailFragment.ll_radiogroup.setVisibility(0);
                        loyalityPassengerDetailFragment.addremove_loyaltyid_rl.setVisibility(0);
                        loyalityPassengerDetailFragment.redemption.setVisibility(0);
                    }
                    if (!next.getLoyaltyAccrualBookingAllowed().booleanValue()) {
                        loyalityPassengerDetailFragment.accural.setVisibility(8);
                    } else {
                        loyalityPassengerDetailFragment.accural.setVisibility(0);
                        loyalityPassengerDetailFragment.addremove_loyaltyid_rl.setVisibility(0);
                    }
                }
            }
            if (loyalityPassengerDetailFragment.i != null) {
                boolean equals = LoyalityPassengerDetailFragment.k.equals("accural");
                View view = this.a;
                if (equals) {
                    loyalityPassengerDetailFragment.onAccuralBtnClick(view);
                    loyalityPassengerDetailFragment.f4729a.setVisibility(0);
                    loyalityPassengerDetailFragment.linear1.setVisibility(0);
                    loyalityPassengerDetailFragment.removeLink.setVisibility(0);
                    loyalityPassengerDetailFragment.addLink.setVisibility(0);
                    loyalityPassengerDetailFragment.f4742c = 40;
                    int i = 1;
                    for (int i2 = 0; i2 < loyalityPassengerDetailFragment.f4744c.size(); i2++) {
                        EditText editText = new EditText(loyalityPassengerDetailFragment.f4727a);
                        loyalityPassengerDetailFragment.f4729a = editText;
                        editText.setId(loyalityPassengerDetailFragment.f4742c + i + 1);
                        loyalityPassengerDetailFragment.f4729a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                        loyalityPassengerDetailFragment.f4729a.setFilterTouchesWhenObscured(true);
                        loyalityPassengerDetailFragment.f4729a.setPadding(3, 10, 5, 5);
                        loyalityPassengerDetailFragment.f4729a.setLayoutParams(new LinearLayout.LayoutParams(-1, 120));
                        EditText editText2 = loyalityPassengerDetailFragment.f4729a;
                        Context context = loyalityPassengerDetailFragment.f4727a;
                        Object obj = d7.a;
                        editText2.setBackground(d7.a.b(context, R.drawable.edittextborder));
                        loyalityPassengerDetailFragment.f4729a.setTextColor(d7.b.a(loyalityPassengerDetailFragment.f4727a, R.color.dark));
                        loyalityPassengerDetailFragment.f4729a.setHintTextColor(d7.b.a(loyalityPassengerDetailFragment.f4727a, R.color.dark));
                        loyalityPassengerDetailFragment.f4729a.setTextSize(14.0f);
                        String str4 = loyalityPassengerDetailFragment.f4744c.get(i2);
                        loyalityPassengerDetailFragment.f4729a.setContentDescription(str4.replace("", " ").trim());
                        loyalityPassengerDetailFragment.f4729a.setText(str4);
                        i++;
                        loyalityPassengerDetailFragment.f4729a.setHint(loyalityPassengerDetailFragment.getString(R.string.Enter_Loyality_Number));
                        loyalityPassengerDetailFragment.f4729a.setInputType(4098);
                        TextView textView = new TextView(loyalityPassengerDetailFragment.f4727a);
                        textView.setText(String.valueOf(arrayList.size() + 1));
                        textView.setTextSize(15.0f);
                        textView.setPadding(25, 18, 0, 5);
                        textView.setTextColor(d7.b.a(loyalityPassengerDetailFragment.f4727a, R.color.dark));
                        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, 120));
                        loyalityPassengerDetailFragment.linear.addView(loyalityPassengerDetailFragment.f4729a);
                        loyalityPassengerDetailFragment.linear.setContentDescription(loyalityPassengerDetailFragment.f4729a.toString().replace("", " ").trim());
                        loyalityPassengerDetailFragment.linear1.addView(textView);
                        arrayList.add(loyalityPassengerDetailFragment.f4729a);
                    }
                } else if (LoyalityPassengerDetailFragment.k.equals("redemption")) {
                    loyalityPassengerDetailFragment.onRedemptionBtnClick(view);
                    loyalityPassengerDetailFragment.removeLink.setVisibility(8);
                    loyalityPassengerDetailFragment.addLink.setVisibility(8);
                    loyalityPassengerDetailFragment.linear1.setVisibility(8);
                } else {
                    loyalityPassengerDetailFragment.removeLink.setVisibility(8);
                    loyalityPassengerDetailFragment.addLink.setVisibility(8);
                    loyalityPassengerDetailFragment.linear1.setVisibility(8);
                }
                Iterator<C0471CB> it2 = C1450w1.f7017b.iterator();
                while (it2.hasNext()) {
                    C0471CB next2 = it2.next();
                    if (LoyalityPassengerDetailFragment.l.contains(next2.getSoftAccountSummaryDTO().getBankName())) {
                        if (next2.getLoyaltyRedemptionBookingAllowed().booleanValue() || next2.getLoyaltyAccrualBookingAllowed().booleanValue()) {
                            loyalityPassengerDetailFragment.loyalty_membership_detail_ll.setVisibility(0);
                            Iterator<C0471CB> it3 = C1450w1.f7017b.iterator();
                            while (it3.hasNext()) {
                                C0471CB next3 = it3.next();
                                if (LoyalityPassengerDetailFragment.l.contains(next3.getSoftAccountSummaryDTO().getBankName())) {
                                    if (next3.getSoftMemberId() != null) {
                                        loyalityPassengerDetailFragment.loyalityNumber.setText(next3.getSoftMemberId().toString());
                                    }
                                    if (!(next3.getSoftAccountSummaryDTO() == null || next3.getSoftAccountSummaryDTO().getTotalPointsAvailable() == null)) {
                                        loyalityPassengerDetailFragment.totalAvlPts.setText(next3.getSoftAccountSummaryDTO().getTotalPointsAvailable().toString());
                                    }
                                    if (next3.getSoftAccountSummaryDTO().getTotalPointsAvailableToRedeem() != null) {
                                        loyalityPassengerDetailFragment.totalRedeemPts.setText(next3.getSoftAccountSummaryDTO().getTotalPointsAvailableToRedeem().toString());
                                    }
                                    if (next3.getSoftAccountSummaryDTO().getTotalPartnerPoints() != null) {
                                        loyalityPassengerDetailFragment.sbiRewardPts.setText(next3.getSoftAccountSummaryDTO().getTotalPartnerPoints().toString());
                                    }
                                    if (next3.getSoftAccountSummaryDTO().getTotalPartnerPoints() != null) {
                                        loyalityPassengerDetailFragment.tatalSbiPts.setText(next3.getSoftAccountSummaryDTO().getTotalPartnerPoints().toString());
                                    }
                                    if (next3.getSoftAccountSummaryDTO().getTotalPurchasePoints() != null) {
                                        loyalityPassengerDetailFragment.totalPurchasePts.setText(next3.getSoftAccountSummaryDTO().getTotalPurchasePoints().toString());
                                    }
                                }
                            }
                        } else {
                            loyalityPassengerDetailFragment.loyalty_membership_detail_ll.setVisibility(8);
                        }
                    }
                }
                return;
            }
            loyalityPassengerDetailFragment.loyalty_membership_detail_ll.setVisibility(8);
        }
    }

    static {
        C1354qp.R(LoyalityPassengerDetailFragment.class);
    }

    @OnClick({2131364281})
    public void addMore() {
        int i2;
        int i3;
        int i4;
        if (this.f4743c.equals("TQ")) {
            i2 = 4;
        } else {
            i2 = 6;
        }
        if ((!this.f4743c.equals("TQ") || (i4 = this.f4745d) < 1 || i4 >= 4) && (this.f4743c.equals("TQ") || (i3 = this.f4745d) < 1 || i3 >= 6)) {
            C0535I5.t0(this.f4727a, "Maximum " + i2 + " passengers limit reached");
        } else if (this.f4745d == 6) {
            C0535I5.t0(this.f4727a, "Maximum 6 passengers limit reached");
        } else {
            new RelativeLayout.LayoutParams(-1, -2).addRule(9);
            EditText editText = new EditText(getContext());
            this.b = editText;
            editText.setPadding(3, 10, 5, 5);
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, 120));
            this.f4745d++;
            this.b.setInputType(1);
            this.b.setTextSize(2, 14.0f);
            this.b.setId(this.f4745d);
            EditText editText2 = this.b;
            Context context = this.f4727a;
            Object obj = d7.a;
            editText2.setBackground(d7.a.b(context, R.drawable.edittextborder));
            this.b.setHint("Enter Loyalty Number");
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
            TextView textView = new TextView(this.f4727a);
            this.f4730a = textView;
            textView.setText(String.valueOf(this.f4745d));
            this.f4730a.setTextSize(15.0f);
            this.f4730a.setPadding(25, 20, 0, 5);
            this.f4730a.setTextColor(d7.b.a(this.f4727a, R.color.dark));
            this.f4730a.setLayoutParams(new LinearLayout.LayoutParams(-1, 120));
            this.linear.addView(this.b);
            this.linear1.addView(this.f4730a);
            this.f4736a.add(this.b);
        }
    }

    public final void f() {
        if (this.f4745d >= 1) {
            this.linear.removeViewAt(0);
            this.linear1.removeViewAt(0);
            this.f4745d = 0;
        }
        this.accural.setClickable(false);
        new RelativeLayout.LayoutParams(-1, -2).addRule(9);
        EditText editText = new EditText(getContext());
        this.b = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        this.b.setPadding(3, 10, 5, 5);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, 120));
        this.f4745d++;
        this.b.setInputType(1);
        this.b.setTextSize(2, 14.0f);
        this.b.setId(this.f4745d);
        EditText editText2 = this.b;
        Context context = this.f4727a;
        Object obj = d7.a;
        editText2.setBackground(d7.a.b(context, R.drawable.edittextborder));
        Iterator<C0471CB> it = C1450w1.f7017b.iterator();
        while (it.hasNext()) {
            C0471CB next = it.next();
            String str = l;
            if (!(str == null || !str.contains(next.getSoftAccountSummaryDTO().getBankName()) || next.getSoftMemberId() == null)) {
                this.b.setContentDescription(next.getSoftMemberId().toString().replace("", " ").trim());
                next.getSoftMemberId().getClass();
                this.b.setText(next.getSoftMemberId().toString());
            }
        }
        this.b.getText().toString();
        this.b.getText().toString();
        ArrayList arrayList = this.f4736a;
        arrayList.size();
        this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        TextView textView = new TextView(this.f4727a);
        textView.setText(String.valueOf(this.f4745d));
        textView.setTextSize(15.0f);
        textView.setPadding(25, 20, 0, 5);
        textView.setTextColor(d7.b.a(this.f4727a, R.color.dark));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, 120));
        this.linear.addView(this.b);
        this.linear1.addView(textView);
        arrayList.add(this.b);
    }

    @OnClick({2131364261})
    public void onAccuralBtnClick(View view) {
        k = "accural";
        C0535I5.H(this.f4731a, view);
        view.setSelected(true);
        view.setClickable(true);
        this.radioGroup.clearCheck();
        this.accural.setChecked(true);
        this.redemption.setSelected(false);
        f();
        this.heading_loyaltyno_ll.setVisibility(0);
        this.addremove_loyaltyid_rl.setVisibility(0);
        this.removeLink.setVisibility(0);
        this.addLink.setVisibility(0);
        this.linear.setVisibility(0);
        this.linear1.setVisibility(0);
    }

    @OnClick({2131362300})
    public void onClicfundadutymsg(View view) {
        if (this.contact_detail.getVisibility() == 0) {
            this.contact_detail.setVisibility(8);
        } else {
            this.contact_detail.setVisibility(0);
        }
    }

    @OnClick({2131362922})
    public void onClick() {
        boolean z;
        if (l == null) {
            C0535I5.m(this.f4727a, false, getString(R.string.select_bank_name_msg), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        this.f4744c = arrayList;
        arrayList.clear();
        if (!C0535I5.O((ConnectivityManager) this.f4727a.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new a(), 5000);
            return;
        }
        Om om = (Om) C0657Qt.c(C0793b1.a.f3912a);
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        this.f4741b = false;
        boolean equals = k.equals("accural");
        C1358qx qxVar = this.f4737a;
        if (equals) {
            Iterator it = this.f4736a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                EditText editText = (EditText) it.next();
                String str = editText.getText() + "";
                z = true;
                if (str.equals("")) {
                    break;
                } else if (this.f4744c.contains(str)) {
                    this.f4741b = true;
                    break;
                } else {
                    long longValue = Long.valueOf(editText.getText().toString()).longValue();
                    this.f4744c.add(String.valueOf(longValue));
                    PassengerDetailDTO passengerDetailDTO = new PassengerDetailDTO();
                    this.f4734a = passengerDetailDTO;
                    passengerDetailDTO.setSoftMemberId(Long.valueOf(longValue));
                    arrayList2.add(this.f4734a);
                }
            }
            z = false;
            qxVar.setPassengerDetailDTO(arrayList2);
            qxVar.setCls(this.f4749e.get(0).f5348c);
            String str2 = this.i;
            if (str2 != null) {
                qxVar.setBankId(Integer.parseInt(str2));
            }
            z2 = z;
        } else if (k.equals("redemption")) {
            this.f4734a = new PassengerDetailDTO();
            Iterator<C0471CB> it2 = C1450w1.f7017b.iterator();
            long j2 = 0;
            while (it2.hasNext()) {
                C0471CB next = it2.next();
                if (l.contains(next.getSoftAccountSummaryDTO().getBankName()) && next.getSoftMemberId() != null) {
                    j2 = next.getSoftMemberId().longValue();
                }
            }
            this.f4734a.setSoftMemberId(Long.valueOf(j2));
            arrayList2.clear();
            arrayList2.add(this.f4734a);
            qxVar.setPassengerDetailDTO(arrayList2);
            qxVar.setCls(this.f4749e.get(0).f5348c);
            String str3 = this.i;
            if (str3 != null) {
                qxVar.setBankId(Integer.parseInt(str3));
            }
        } else {
            C0535I5.m(this.f4727a, false, getString(R.string.Please_Select_Loyalty_Booking_Type), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (this.f4741b) {
            C0535I5.m(this.f4727a, false, getString(R.string.Duplicate_Loyalty_not_allowed), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (z2) {
            C0535I5.m(this.f4727a, false, getString(R.string.please_Enter_Loyality_Number), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (this.i != null || (!k.equals("accural") && !k.equals("redemption"))) {
            Context context = this.f4727a;
            this.f4726a = ProgressDialog.show(context, context.getString(R.string.processing_text), this.f4727a.getString(R.string.please_wait_text));
            om.N0(C0657Qt.i() + "fetchLoyaltyDetails", qxVar).c(C1181iv.a()).a(E0.a()).b(new b());
        } else {
            C0535I5.o(getActivity(), getString(R.string.select_bank_name_msg), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z;
        View inflate = layoutInflater.inflate(R.layout.fragment_loyality_passenger_detail, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4727a = getContext();
        this.f4731a = getActivity();
        if (!this.f4738a) {
            l = null;
            k = "null";
        }
        this.f4726a = new ProgressDialog(this.f4727a);
        this.f4750f = new ArrayList<>();
        this.f4751g = new ArrayList<>();
        Iterator<C0471CB> it = C1450w1.f7017b.iterator();
        while (it.hasNext()) {
            this.f4751g.add(it.next().getSoftAccountSummaryDTO());
        }
        this.f4728a = getArguments();
        HomeActivity.f4185b.setVisibility(8);
        HomeActivity.K();
        Bundle bundle2 = this.f4728a;
        if (bundle2 != null) {
            this.f4749e = (ArrayList) bundle2.getSerializable("TrainBtwnStnsDTOList");
            this.f4735a = (C1100f2) this.f4728a.getSerializable("avlResponseDTO");
            this.f4743c = this.f4728a.getString("selectedQuotaString");
            j = this.f4728a.getString("selectedQuota");
            this.f4725a = (Z2) this.f4728a.getSerializable("boardingStnListDTO");
            if (this.f4728a.getString("spConcession").equals("Y") || j.equals("HP")) {
                z = true;
            } else {
                z = false;
            }
            this.f4724a.setConcessionBooking(z);
            this.f4732a = (GoogleAdParamDTO) this.f4728a.getSerializable("googleAdParamDTO");
            this.f = this.f4728a.getString("JourneyDate");
            this.g = this.f4728a.getString("highestClass");
            a = (C0794b3) this.f4728a.getSerializable("BookingConfig");
            this.h = this.f4728a.getString("AvailLastUpdate");
            this.f4747d = (ArrayList) this.f4728a.getSerializable("reebookPsgnList");
            c = this.f4728a.getBoolean("rebookFlag");
            d = this.f4728a.getBoolean("isLoyaltyAccrualBookingAllowed");
            e = this.f4728a.getBoolean("isLoyaltyRedemptionBookingAllowed");
        }
        if (!d) {
            this.accural.setEnabled(false);
        }
        if (!e) {
            this.redemption.setEnabled(false);
        }
        if (C0535I5.f3647h) {
            this.redemption.setBackgroundColor(getResources().getColor(R.color.grey));
            this.redemption.setEnabled(false);
        }
        this.loyalty_membership_detail_ll.setVisibility(8);
        if (this.f4738a) {
            this.f4744c.clear();
            this.f4736a.clear();
            this.loyalty_bank.setText(l);
            this.loyalty_membership_detail_ll.setVisibility(0);
            this.ll_radiogroup.setVisibility(0);
            if (l.contains("BOB")) {
                this.redemption.setVisibility(8);
            }
            Iterator<C0471CB> it2 = C1450w1.f7017b.iterator();
            while (it2.hasNext()) {
                C0471CB next = it2.next();
                if (l.contains(next.getSoftAccountSummaryDTO().getBankName())) {
                    if (next.getSoftMemberId() != null) {
                        this.loyalityNumber.setText(next.getSoftMemberId().toString());
                    }
                    if (!(next.getSoftAccountSummaryDTO() == null || next.getSoftAccountSummaryDTO().getTotalPointsAvailable() == null)) {
                        this.totalAvlPts.setText(next.getSoftAccountSummaryDTO().getTotalPointsAvailable().toString());
                    }
                    if (next.getSoftAccountSummaryDTO().getTotalPointsAvailableToRedeem() != null) {
                        this.totalRedeemPts.setText(next.getSoftAccountSummaryDTO().getTotalPointsAvailableToRedeem().toString());
                    }
                    if (next.getSoftAccountSummaryDTO().getTotalPartnerPoints() != null) {
                        this.sbiRewardPts.setText(next.getSoftAccountSummaryDTO().getTotalPartnerPoints().toString());
                    }
                    if (next.getSoftAccountSummaryDTO().getTotalPartnerPoints() != null) {
                        this.tatalSbiPts.setText(next.getSoftAccountSummaryDTO().getTotalPartnerPoints().toString());
                    }
                    if (next.getSoftAccountSummaryDTO().getTotalPurchasePoints() != null) {
                        this.totalPurchasePts.setText(next.getSoftAccountSummaryDTO().getTotalPurchasePoints().toString());
                    }
                }
            }
            if (k.equals("redemption")) {
                this.redemption.setSelected(true);
                this.addremove_loyaltyid_rl.setVisibility(8);
            }
            if (k.equals("accural")) {
                this.accural.setSelected(true);
                this.heading_loyaltyno_ll.setVisibility(0);
                this.linear.setVisibility(0);
                this.linear1.setVisibility(0);
                this.addremove_loyaltyid_rl.setVisibility(0);
                f();
            }
            if (k.equals("skip")) {
                this.skip.setSelected(true);
                this.addremove_loyaltyid_rl.setVisibility(8);
            }
        }
        if (l == null) {
            this.ll_radiogroup.setVisibility(8);
            this.addremove_loyaltyid_rl.setVisibility(8);
        }
        return inflate;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ProgressDialog progressDialog = this.f4726a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4726a.dismiss();
        }
    }

    @OnClick({2131363103})
    public void onLoyaltyBankClick(View view) {
        if (this.f4751g != null) {
            this.f4750f.clear();
            Iterator<C1311ox> it = this.f4751g.iterator();
            while (it.hasNext()) {
                this.f4750f.add(it.next().getBankName());
            }
        }
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4733a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4733a.show(getActivity().getSupportFragmentManager(), "");
        this.f4733a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), this.f4750f, new c(view));
        this.f4733a.g().setText(getString(R.string.select_bank_name));
        this.f4733a.f().setAdapter(customAdapter);
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4726a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4726a.dismiss();
        }
    }

    @OnClick({2131364555})
    public void onRedemptionBtnClick(View view) {
        this.linear.setVisibility(8);
        this.linear1.setVisibility(8);
        k = "redemption";
        this.radioGroup.clearCheck();
        this.redemption.setChecked(true);
        this.accural.setSelected(false);
        this.redemption.setSelected(true);
        this.redemption.setClickable(true);
        this.accural.setClickable(true);
        this.heading_loyaltyno_ll.setVisibility(8);
        this.addremove_loyaltyid_rl.setVisibility(0);
        EditText editText = this.f4729a;
        if (editText != null) {
            editText.setVisibility(8);
        }
        this.removeLink.setVisibility(8);
        this.addLink.setVisibility(8);
        this.f4724a.setLoyaltyRedemptionBooking(true);
    }

    @OnClick({2131364601})
    public void onSkipBtnClick(View view) {
        k = "skip";
        C0535I5.H(this.f4731a, view);
        this.radioGroup.clearCheck();
        this.removeLink.setVisibility(8);
        this.addLink.setVisibility(8);
        this.heading_loyaltyno_ll.setVisibility(8);
        this.addremove_loyaltyid_rl.setVisibility(0);
        this.f4746d = "true";
        ArrayList<PassengerDetailDTO> arrayList = this.f4740b;
        arrayList.clear();
        if (this.f4735a.getAvlFareResponseDTO() != null) {
            for (AvlFareResponseDTO next : this.f4735a.getAvlFareResponseDTO()) {
            }
        }
        if (this.f4725a.getBkgCfgs() != null) {
            for (int i2 = 0; i2 < this.f4725a.getBkgCfgs().size(); i2++) {
                Boolean bool = Boolean.FALSE;
                this.f4725a.getBkgCfgs().get(i2).setAcuralBooking(bool);
                this.f4725a.getBkgCfgs().get(i2).setRedemptionBooking(bool);
            }
        }
        this.f4736a.clear();
        if (this.f4728a == null) {
            this.f4728a = new Bundle();
        }
        this.f4728a.putSerializable("TrainBtwnStnsDTOList", this.f4749e);
        this.f4728a.putSerializable("avlResponseDTO", this.f4735a);
        this.f4728a.putSerializable("ssConcForgoText", this.f4748e);
        this.f4728a.putSerializable("selectedQuotaString", this.f4743c);
        this.f4728a.putSerializable("selectedQuota", j);
        this.f4728a.putSerializable("psgnDTO", arrayList);
        this.f4728a.putSerializable("loyalityBkgType", this.f4746d);
        this.f4728a.putSerializable("highestClass", this.g);
        this.f4728a.putString("JourneyDate", this.f);
        this.f4728a.putString("AvailLastUpdate", this.h);
        this.f4728a.putBoolean("rebookFlag", c);
        this.f4728a.putSerializable("reebookPsgnList", this.f4747d);
        this.f4728a.putString("loyaltyBookingType", k);
        this.f4728a.putString("softBankId", this.i);
        this.f4745d = 0;
        PassengerDetailFragment passengerDetailFragment = new PassengerDetailFragment();
        passengerDetailFragment.setArguments(this.f4728a);
        HomeActivity.n(this.f4727a, passengerDetailFragment, C1218kf.ADD_PASSENGER.a(), Boolean.TRUE, Boolean.FALSE);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4726a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4726a.dismiss();
        }
    }

    @OnClick({2131364564})
    public void removeEditBox() {
        if (this.f4745d > 1) {
            LinearLayout linearLayout = this.linear;
            if (linearLayout == null || linearLayout.getChildCount() == 1) {
                C0535I5.t0(this.f4727a, getString(R.string.Atleast_one_Loyalty_mandatory));
                return;
            }
            LinearLayout linearLayout2 = this.linear;
            linearLayout2.removeViewAt(linearLayout2.getChildCount() - 1);
            LinearLayout linearLayout3 = this.linear1;
            linearLayout3.removeViewAt(linearLayout3.getChildCount() - 1);
            ArrayList arrayList = this.f4736a;
            arrayList.remove(arrayList.size() - 1);
            this.f4745d--;
            return;
        }
        C0535I5.t0(this.f4727a, getString(R.string.Atleast_one_Loyalty_mandatory));
    }

    public class a implements Runnable {
        public final void run() {
        }
    }
}
