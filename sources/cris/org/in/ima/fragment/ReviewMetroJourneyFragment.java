package cris.org.in.ima.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import defpackage.d7;
import java.security.SecureRandom;
import java.util.ArrayList;

public class ReviewMetroJourneyFragment extends Fragment {
    public static int c;

    /* renamed from: c  reason: collision with other field name */
    public static String f5107c = null;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public C0781ac a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<C0781ac> f5108a;
    @BindView(2131362271)
    TextView cnvnce_fare;
    @BindView(2131362421)
    TextView dmrcFare;
    @BindView(2131363215)
    TextView dmrcFromStnLine;
    @BindView(2131362418)
    TextView dmrcJdate;
    @BindView(2131362432)
    TextView dmrcTicketSentLevelView;
    @BindView(2131364163)
    TextView dmrcToStnLine;
    @BindView(2131362425)
    TextView dmrcmakepayment;
    @BindView(2131362635)
    RelativeLayout fare_enquiry_bottom_ll;
    @BindView(2131362710)
    TextView fromStnDmrc;
    @BindView(2131363519)
    TextView pnrNumber;
    @BindView(2131363560)
    TextView psgn_with_tkt;
    @BindView(2131364081)
    TextView termcondition;
    @BindView(2131364158)
    TextView tkt_fare;
    @BindView(2131364165)
    TextView toStnDmrc;
    @BindView(2131364183)
    TextView total_amount;
    @BindView(2131363334)
    TextView totalpsng;

    static {
        C1354qp.R(ReviewMetroJourneyFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.fragment_review_metro_journey, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        HomeActivity.K();
        Bundle arguments = getArguments();
        if (arguments != null) {
            f5107c = arguments.getString("JourneyDate");
            d = arguments.getString("FromStationString");
            g = arguments.getString("FromStationMetroLine");
            e = arguments.getString("ToStationString");
            f = arguments.getString("ToStationMetroLine");
            this.a = (C0781ac) getArguments().getSerializable("fetchFareResponseDTO");
            c = arguments.getInt("noOfPsng");
            h = arguments.getString("pnr");
            arguments.getString("transactionId");
            i = arguments.getString("TotalFare");
            arguments.getString("TotalStation");
            arguments.getString("metroDeffTime");
            this.f5108a = (ArrayList) arguments.getSerializable("bankDetailsDTO");
        }
        this.fromStnDmrc.setText(d);
        int parseInt = Integer.parseInt(g);
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            String str2 = g;
            if (str2 != null && !str2.isEmpty()) {
                if (parseInt == 1) {
                    C0709Uj.r(this, R.string.red_line, this.dmrcFromStnLine);
                    TextView textView = this.dmrcFromStnLine;
                    FragmentActivity activity = getActivity();
                    Object obj = d7.a;
                    textView.setTextColor(d7.b.a(activity, R.color.red));
                }
                if (parseInt == 2) {
                    C0709Uj.r(this, R.string.yellow_line, this.dmrcFromStnLine);
                    TextView textView2 = this.dmrcFromStnLine;
                    FragmentActivity activity2 = getActivity();
                    Object obj2 = d7.a;
                    textView2.setTextColor(d7.b.a(activity2, R.color.yellow_color1));
                }
                if (parseInt == 3) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcFromStnLine);
                    TextView textView3 = this.dmrcFromStnLine;
                    FragmentActivity activity3 = getActivity();
                    Object obj3 = d7.a;
                    textView3.setTextColor(d7.b.a(activity3, R.color.app_theme_blue));
                }
                if (parseInt == 4) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcFromStnLine);
                    TextView textView4 = this.dmrcFromStnLine;
                    FragmentActivity activity4 = getActivity();
                    Object obj4 = d7.a;
                    textView4.setTextColor(d7.b.a(activity4, R.color.app_theme_blue));
                }
                if (parseInt == 5) {
                    C0709Uj.r(this, R.string.green_line, this.dmrcFromStnLine);
                    TextView textView5 = this.dmrcFromStnLine;
                    FragmentActivity activity5 = getActivity();
                    Object obj5 = d7.a;
                    textView5.setTextColor(d7.b.a(activity5, R.color.green));
                }
                if (parseInt == 6) {
                    C0709Uj.r(this, R.string.violet_line, this.dmrcFromStnLine);
                    TextView textView6 = this.dmrcFromStnLine;
                    FragmentActivity activity6 = getActivity();
                    Object obj6 = d7.a;
                    textView6.setTextColor(d7.b.a(activity6, R.color.violet));
                }
                if (parseInt == 7) {
                    C0709Uj.r(this, R.string.pink_line, this.dmrcFromStnLine);
                    TextView textView7 = this.dmrcFromStnLine;
                    FragmentActivity activity7 = getActivity();
                    Object obj7 = d7.a;
                    textView7.setTextColor(d7.b.a(activity7, R.color.light_pink));
                }
                if (parseInt == 8) {
                    C0709Uj.r(this, R.string.magenta_line, this.dmrcFromStnLine);
                    TextView textView8 = this.dmrcFromStnLine;
                    FragmentActivity activity8 = getActivity();
                    Object obj8 = d7.a;
                    textView8.setTextColor(d7.b.a(activity8, R.color.magenta));
                }
                if (parseInt == 9) {
                    C0709Uj.r(this, R.string.grey_line, this.dmrcFromStnLine);
                    TextView textView9 = this.dmrcFromStnLine;
                    FragmentActivity activity9 = getActivity();
                    Object obj9 = d7.a;
                    textView9.setTextColor(d7.b.a(activity9, R.color.lightdark));
                }
                if (parseInt == 29) {
                    C0709Uj.r(this, R.string.rmgl_line, this.dmrcFromStnLine);
                    TextView textView10 = this.dmrcFromStnLine;
                    FragmentActivity activity10 = getActivity();
                    Object obj10 = d7.a;
                    textView10.setTextColor(d7.b.a(activity10, R.color.dark));
                }
            }
        } else {
            String str3 = g;
            if (str3 != null && !str3.isEmpty()) {
                if (parseInt == 1) {
                    C0709Uj.r(this, R.string.red_line, this.dmrcFromStnLine);
                    TextView textView11 = this.dmrcFromStnLine;
                    FragmentActivity activity11 = getActivity();
                    Object obj11 = d7.a;
                    textView11.setTextColor(d7.b.a(activity11, R.color.red));
                }
                if (parseInt == 2) {
                    C0709Uj.r(this, R.string.yellow_line, this.dmrcFromStnLine);
                    TextView textView12 = this.dmrcFromStnLine;
                    FragmentActivity activity12 = getActivity();
                    Object obj12 = d7.a;
                    textView12.setTextColor(d7.b.a(activity12, R.color.yellow_color1));
                }
                if (parseInt == 3) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcFromStnLine);
                    TextView textView13 = this.dmrcFromStnLine;
                    FragmentActivity activity13 = getActivity();
                    Object obj13 = d7.a;
                    textView13.setTextColor(d7.b.a(activity13, R.color.app_theme_blue));
                }
                if (parseInt == 4) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcFromStnLine);
                    TextView textView14 = this.dmrcFromStnLine;
                    FragmentActivity activity14 = getActivity();
                    Object obj14 = d7.a;
                    textView14.setTextColor(d7.b.a(activity14, R.color.app_theme_blue));
                }
                if (parseInt == 5) {
                    C0709Uj.r(this, R.string.green_line, this.dmrcFromStnLine);
                    TextView textView15 = this.dmrcFromStnLine;
                    FragmentActivity activity15 = getActivity();
                    Object obj15 = d7.a;
                    textView15.setTextColor(d7.b.a(activity15, R.color.green));
                }
                if (parseInt == 6) {
                    C0709Uj.r(this, R.string.violet_line, this.dmrcFromStnLine);
                    TextView textView16 = this.dmrcFromStnLine;
                    FragmentActivity activity16 = getActivity();
                    Object obj16 = d7.a;
                    textView16.setTextColor(d7.b.a(activity16, R.color.violet));
                }
                if (parseInt == 7) {
                    C0709Uj.r(this, R.string.pink_line, this.dmrcFromStnLine);
                    TextView textView17 = this.dmrcFromStnLine;
                    FragmentActivity activity17 = getActivity();
                    Object obj17 = d7.a;
                    textView17.setTextColor(d7.b.a(activity17, R.color.light_pink));
                }
                if (parseInt == 8) {
                    C0709Uj.r(this, R.string.magenta_line, this.dmrcFromStnLine);
                    TextView textView18 = this.dmrcFromStnLine;
                    FragmentActivity activity18 = getActivity();
                    Object obj18 = d7.a;
                    textView18.setTextColor(d7.b.a(activity18, R.color.magenta));
                }
                if (parseInt == 9) {
                    C0709Uj.r(this, R.string.grey_line, this.dmrcFromStnLine);
                    TextView textView19 = this.dmrcFromStnLine;
                    FragmentActivity activity19 = getActivity();
                    Object obj19 = d7.a;
                    textView19.setTextColor(d7.b.a(activity19, R.color.lightdark));
                }
                if (parseInt == 29) {
                    C0709Uj.r(this, R.string.rmgl_line, this.dmrcFromStnLine);
                    TextView textView20 = this.dmrcFromStnLine;
                    FragmentActivity activity20 = getActivity();
                    Object obj20 = d7.a;
                    textView20.setTextColor(d7.b.a(activity20, R.color.dark));
                }
            }
        }
        int parseInt2 = Integer.parseInt(f);
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            String str4 = f;
            if (str4 != null && !str4.isEmpty()) {
                if (parseInt2 == 1) {
                    C0709Uj.r(this, R.string.red_line, this.dmrcToStnLine);
                    TextView textView21 = this.dmrcToStnLine;
                    FragmentActivity activity21 = getActivity();
                    Object obj21 = d7.a;
                    textView21.setTextColor(d7.b.a(activity21, R.color.red));
                }
                if (parseInt2 == 2) {
                    C0709Uj.r(this, R.string.yellow_line, this.dmrcToStnLine);
                    TextView textView22 = this.dmrcToStnLine;
                    FragmentActivity activity22 = getActivity();
                    Object obj22 = d7.a;
                    textView22.setTextColor(d7.b.a(activity22, R.color.yellow_color1));
                }
                if (parseInt2 == 3) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcToStnLine);
                    TextView textView23 = this.dmrcToStnLine;
                    FragmentActivity activity23 = getActivity();
                    Object obj23 = d7.a;
                    textView23.setTextColor(d7.b.a(activity23, R.color.app_theme_blue));
                }
                if (parseInt2 == 4) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcToStnLine);
                    TextView textView24 = this.dmrcToStnLine;
                    FragmentActivity activity24 = getActivity();
                    Object obj24 = d7.a;
                    textView24.setTextColor(d7.b.a(activity24, R.color.app_theme_blue));
                }
                if (parseInt2 == 5) {
                    C0709Uj.r(this, R.string.green_line, this.dmrcToStnLine);
                    TextView textView25 = this.dmrcToStnLine;
                    FragmentActivity activity25 = getActivity();
                    Object obj25 = d7.a;
                    textView25.setTextColor(d7.b.a(activity25, R.color.green));
                }
                if (parseInt2 == 6) {
                    C0709Uj.r(this, R.string.violet_line, this.dmrcToStnLine);
                    TextView textView26 = this.dmrcToStnLine;
                    FragmentActivity activity26 = getActivity();
                    Object obj26 = d7.a;
                    textView26.setTextColor(d7.b.a(activity26, R.color.violet));
                }
                if (parseInt2 == 7) {
                    C0709Uj.r(this, R.string.pink_line, this.dmrcToStnLine);
                    TextView textView27 = this.dmrcToStnLine;
                    FragmentActivity activity27 = getActivity();
                    Object obj27 = d7.a;
                    textView27.setTextColor(d7.b.a(activity27, R.color.light_pink));
                }
                if (parseInt2 == 8) {
                    C0709Uj.r(this, R.string.magenta_line, this.dmrcToStnLine);
                    TextView textView28 = this.dmrcToStnLine;
                    FragmentActivity activity28 = getActivity();
                    Object obj28 = d7.a;
                    textView28.setTextColor(d7.b.a(activity28, R.color.magenta));
                }
                if (parseInt2 == 9) {
                    C0709Uj.r(this, R.string.grey_line, this.dmrcToStnLine);
                    TextView textView29 = this.dmrcToStnLine;
                    FragmentActivity activity29 = getActivity();
                    Object obj29 = d7.a;
                    textView29.setTextColor(d7.b.a(activity29, R.color.lightdark));
                }
                if (parseInt2 == 29) {
                    C0709Uj.r(this, R.string.rmgl_line, this.dmrcToStnLine);
                    TextView textView30 = this.dmrcToStnLine;
                    FragmentActivity activity30 = getActivity();
                    Object obj30 = d7.a;
                    textView30.setTextColor(d7.b.a(activity30, R.color.dark));
                }
            }
        } else {
            String str5 = f;
            if (str5 != null && !str5.isEmpty()) {
                if (parseInt2 == 1) {
                    C0709Uj.r(this, R.string.red_line, this.dmrcToStnLine);
                    TextView textView31 = this.dmrcToStnLine;
                    FragmentActivity activity31 = getActivity();
                    Object obj31 = d7.a;
                    textView31.setTextColor(d7.b.a(activity31, R.color.red));
                }
                if (parseInt2 == 2) {
                    C0709Uj.r(this, R.string.yellow_line, this.dmrcToStnLine);
                    TextView textView32 = this.dmrcToStnLine;
                    FragmentActivity activity32 = getActivity();
                    Object obj32 = d7.a;
                    textView32.setTextColor(d7.b.a(activity32, R.color.yellow_color1));
                }
                if (parseInt2 == 3) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcToStnLine);
                    TextView textView33 = this.dmrcToStnLine;
                    FragmentActivity activity33 = getActivity();
                    Object obj33 = d7.a;
                    textView33.setTextColor(d7.b.a(activity33, R.color.app_theme_blue));
                }
                if (parseInt2 == 4) {
                    C0709Uj.r(this, R.string.blue_line, this.dmrcToStnLine);
                    TextView textView34 = this.dmrcToStnLine;
                    FragmentActivity activity34 = getActivity();
                    Object obj34 = d7.a;
                    textView34.setTextColor(d7.b.a(activity34, R.color.app_theme_blue));
                }
                if (parseInt2 == 5) {
                    C0709Uj.r(this, R.string.green_line, this.dmrcToStnLine);
                    TextView textView35 = this.dmrcToStnLine;
                    FragmentActivity activity35 = getActivity();
                    Object obj35 = d7.a;
                    textView35.setTextColor(d7.b.a(activity35, R.color.green));
                }
                if (parseInt2 == 6) {
                    C0709Uj.r(this, R.string.violet_line, this.dmrcToStnLine);
                    TextView textView36 = this.dmrcToStnLine;
                    FragmentActivity activity36 = getActivity();
                    Object obj36 = d7.a;
                    textView36.setTextColor(d7.b.a(activity36, R.color.violet));
                }
                if (parseInt2 == 7) {
                    C0709Uj.r(this, R.string.pink_line, this.dmrcToStnLine);
                    TextView textView37 = this.dmrcToStnLine;
                    FragmentActivity activity37 = getActivity();
                    Object obj37 = d7.a;
                    textView37.setTextColor(d7.b.a(activity37, R.color.light_pink));
                }
                if (parseInt2 == 8) {
                    C0709Uj.r(this, R.string.magenta_line, this.dmrcToStnLine);
                    TextView textView38 = this.dmrcToStnLine;
                    FragmentActivity activity38 = getActivity();
                    Object obj38 = d7.a;
                    textView38.setTextColor(d7.b.a(activity38, R.color.magenta));
                }
                if (parseInt2 == 9) {
                    C0709Uj.r(this, R.string.grey_line, this.dmrcToStnLine);
                    TextView textView39 = this.dmrcToStnLine;
                    FragmentActivity activity39 = getActivity();
                    Object obj39 = d7.a;
                    textView39.setTextColor(d7.b.a(activity39, R.color.lightdark));
                }
                if (parseInt2 == 29) {
                    C0709Uj.r(this, R.string.rmgl_line, this.dmrcToStnLine);
                    TextView textView40 = this.dmrcToStnLine;
                    FragmentActivity activity40 = getActivity();
                    Object obj40 = d7.a;
                    textView40.setTextColor(d7.b.a(activity40, R.color.dark));
                }
            }
        }
        this.toStnDmrc.setText(e);
        TextView textView41 = this.totalpsng;
        textView41.setText("Total Passenger: " + c);
        this.pnrNumber.setText(h);
        lf.x(new StringBuilder("₹ "), i, this.dmrcFare);
        this.dmrcJdate.setText(f5107c);
        Context context = getContext();
        Object obj41 = d7.a;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.bottom_sheet_element));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(d7.b.a(getContext(), R.color.bottom_sheet_element));
        ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(d7.b.a(getContext(), R.color.bottom_sheet_element));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(new SpannableString(C0709Uj.i(" ", getString(R.string.your_metro_ticket_willbe_sent_to))));
        SpannableString spannableString = new SpannableString(" ".concat(C0535I5.d0(Bw.e(getContext()).j())));
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 0);
        spannableStringBuilder.append(spannableString);
        spannableStringBuilder.append(new SpannableString(" " + getString(R.string.and) + " \n"));
        if (C0535I5.d != 0) {
            str = lf.k(new StringBuilder("+"), C0535I5.d, "-");
        } else {
            str = "";
        }
        SpannableString spannableString2 = new SpannableString(str);
        spannableString2.setSpan(foregroundColorSpan2, 0, spannableString2.length(), 0);
        spannableStringBuilder.append(spannableString2);
        SpannableString spannableString3 = new SpannableString(C0535I5.e0(Bw.e(getContext()).k()));
        spannableString3.setSpan(foregroundColorSpan3, 0, spannableString3.length(), 0);
        spannableStringBuilder.append(spannableString3);
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            spannableStringBuilder.append(new SpannableString(" " + getString(R.string.sent_to)));
        }
        this.dmrcTicketSentLevelView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getResources().getString(R.string.insurance_terms_conditions_dmrc));
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.terms_conditions));
        ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(d7.b.a(getContext(), R.color.blue));
        ForegroundColorSpan foregroundColorSpan5 = new ForegroundColorSpan(d7.b.a(getContext(), R.color.blue));
        StyleSpan styleSpan = new StyleSpan(1);
        StyleSpan styleSpan2 = new StyleSpan(1);
        a aVar = new a();
        try {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                spannableStringBuilder2.setSpan(styleSpan, 45, 62, 18);
                spannableStringBuilder2.setSpan(aVar, 45, 62, 33);
                spannableStringBuilder2.setSpan(foregroundColorSpan4, 45, 62, 18);
            } else {
                spannableStringBuilder2.setSpan(styleSpan, 55, 76, 18);
                spannableStringBuilder2.setSpan(aVar, 55, 76, 33);
                spannableStringBuilder2.setSpan(foregroundColorSpan4, 55, 76, 18);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        b bVar = new b();
        try {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                spannableStringBuilder3.setSpan(styleSpan2, 0, 20, 18);
                spannableStringBuilder3.setSpan(bVar, 0, 20, 33);
                spannableStringBuilder3.setSpan(foregroundColorSpan5, 0, 20, 18);
            } else {
                spannableStringBuilder3.setSpan(styleSpan2, 0, 20, 18);
                spannableStringBuilder3.setSpan(bVar, 0, 20, 33);
                spannableStringBuilder3.setSpan(foregroundColorSpan5, 0, 20, 18);
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        this.termcondition.setText(new SpannableStringBuilder().append(spannableStringBuilder2).append(" ").append(spannableStringBuilder3));
        this.termcondition.setMovementMethod(LinkMovementMethod.getInstance());
        return inflate;
    }

    @OnClick({2131362425})
    public void onDmrcMakePayment() {
        String.valueOf(((long) (new SecureRandom().nextDouble() * 9.0E9d)) + 1000000000);
        Bundle bundle = new Bundle();
        MakePaymentNewFragment makePaymentNewFragment = new MakePaymentNewFragment();
        bundle.putString("TotalFare", i);
        bundle.putSerializable("BankDetailDto", this.f5108a);
        bundle.putString("ClientTxnId", "POST_BOOKING");
        bundle.putBoolean("dmrcPaymentMode", true);
        makePaymentNewFragment.setArguments(bundle);
        HomeActivity.n(getActivity(), makePaymentNewFragment, C1218kf.MAKE_PAYMENT.a(), Boolean.TRUE, Boolean.FALSE);
    }

    @OnClick({2131362635})
    public void onFare(View view) {
        this.fare_enquiry_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362634})
    public void onFareBrakeUp(View view) {
        if (this.fare_enquiry_bottom_ll.getVisibility() == 8) {
            this.fare_enquiry_bottom_ll.setVisibility(0);
            TextView textView = this.tkt_fare;
            textView.setText(getString(R.string.rupees) + " " + (this.a.getTicketCharge() * ((double) this.a.getPsgnCount())));
            TextView textView2 = this.cnvnce_fare;
            textView2.setText(getString(R.string.rupees) + " " + (this.a.getServiceChargeGST() + this.a.getServiceCharge()));
            TextView textView3 = this.total_amount;
            textView3.setText(getString(R.string.rupees) + " " + this.a.getTotalPayableAmount());
            TextView textView4 = this.psgn_with_tkt;
            textView4.setText(getString(R.string.ticket_fare) + " (" + this.a.getPsgnCount() + " * " + getString(R.string.rupees) + " " + this.a.getTicketCharge() + ")");
            return;
        }
        this.fare_enquiry_bottom_ll.setVisibility(8);
    }

    public class a extends ClickableSpan {
        public a() {
        }

        public final void onClick(View view) {
            ReviewMetroJourneyFragment reviewMetroJourneyFragment = ReviewMetroJourneyFragment.this;
            if (!C0535I5.O((ConnectivityManager) reviewMetroJourneyFragment.getActivity().getSystemService("connectivity"), reviewMetroJourneyFragment.getContext())) {
                new Handler().postDelayed(new C0070a(), 5000);
            } else {
                reviewMetroJourneyFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(reviewMetroJourneyFragment.getString(R.string.link_for_irctc))));
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }

        /* renamed from: cris.org.in.ima.fragment.ReviewMetroJourneyFragment$a$a  reason: collision with other inner class name */
        public class C0070a implements Runnable {
            public final void run() {
            }
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        public final void onClick(View view) {
            ReviewMetroJourneyFragment reviewMetroJourneyFragment = ReviewMetroJourneyFragment.this;
            if (!C0535I5.O((ConnectivityManager) reviewMetroJourneyFragment.getActivity().getSystemService("connectivity"), reviewMetroJourneyFragment.getContext())) {
                new Handler().postDelayed(new a(), 5000);
            } else {
                reviewMetroJourneyFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(reviewMetroJourneyFragment.getString(R.string.tnc_general))));
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }

        public class a implements Runnable {
            public final void run() {
            }
        }
    }
}
