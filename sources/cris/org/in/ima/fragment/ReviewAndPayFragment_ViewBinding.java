package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class ReviewAndPayFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ReviewAndPayFragment f5106a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewAndPayFragment a;

        public a(ReviewAndPayFragment reviewAndPayFragment) {
            this.a = reviewAndPayFragment;
        }

        public final void doClick(View view) {
            this.a.onOtpResend(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewAndPayFragment a;

        public b(ReviewAndPayFragment reviewAndPayFragment) {
            this.a = reviewAndPayFragment;
        }

        public final void doClick(View view) {
            this.a.refreshCaptchaCNFPwd(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewAndPayFragment a;

        public c(ReviewAndPayFragment reviewAndPayFragment) {
            this.a = reviewAndPayFragment;
        }

        public final void doClick(View view) {
            this.a.onFareBackClose(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewAndPayFragment a;

        public d(ReviewAndPayFragment reviewAndPayFragment) {
            this.a = reviewAndPayFragment;
        }

        public final void doClick(View view) {
            this.a.onMakePaymentClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewAndPayFragment a;

        public e(ReviewAndPayFragment reviewAndPayFragment) {
            this.a = reviewAndPayFragment;
        }

        public final void doClick(View view) {
            this.a.onFareBackUp(view);
        }
    }

    public ReviewAndPayFragment_ViewBinding(ReviewAndPayFragment reviewAndPayFragment, View view) {
        this.f5106a = reviewAndPayFragment;
        Class cls = TextView.class;
        reviewAndPayFragment.trainNameView = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_train_name, "field 'trainNameView'", cls);
        reviewAndPayFragment.trainNumberView = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_train_number, "field 'trainNumberView'", cls);
        reviewAndPayFragment.bookingStatusView = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_status, "field 'bookingStatusView'", cls);
        reviewAndPayFragment.departureDateView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dep_date, "field 'departureDateView'", cls);
        reviewAndPayFragment.arrivalDateView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arv_date, "field 'arrivalDateView'", cls);
        reviewAndPayFragment.departureTimeView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dep_time, "field 'departureTimeView'", cls);
        reviewAndPayFragment.arrivalTimeView = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arv_timee, "field 'arrivalTimeView'", cls);
        reviewAndPayFragment.travelTimeView = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_Time, "field 'travelTimeView'", cls);
        reviewAndPayFragment.fromStation = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_from_stationname, "field 'fromStation'", cls);
        reviewAndPayFragment.toStation = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_to_stationname, "field 'toStation'", cls);
        reviewAndPayFragment.psgnCountClassQuotaView = (TextView) Utils.findRequiredViewAsType(view, R.id.psgnCount_Class_Quota, "field 'psgnCountClassQuotaView'", cls);
        Class cls2 = RecyclerView.class;
        reviewAndPayFragment.passengerListView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.passenger_list, "field 'passengerListView'", cls2);
        reviewAndPayFragment.ticketSentLevelView = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_sent_level, "field 'ticketSentLevelView'", cls);
        Class cls3 = EditText.class;
        reviewAndPayFragment.otpInput = (EditText) Utils.findRequiredViewAsType(view, R.id.otp_input, "field 'otpInput'", cls3);
        View findRequiredView = Utils.findRequiredView(view, R.id.resend_opt, "field 'reSendOtp' and method 'onOtpResend'");
        reviewAndPayFragment.reSendOtp = (TextView) Utils.castView(findRequiredView, R.id.resend_opt, "field 'reSendOtp'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(reviewAndPayFragment));
        reviewAndPayFragment.netAmount = (TextView) Utils.findRequiredViewAsType(view, R.id.net_amount, "field 'netAmount'", cls);
        Class cls4 = ImageView.class;
        reviewAndPayFragment.captcha = (ImageView) Utils.findRequiredViewAsType(view, R.id.captcha, "field 'captcha'", cls4);
        reviewAndPayFragment.captchaInput = (EditText) Utils.findRequiredViewAsType(view, R.id.captcha_input, "field 'captchaInput'", cls3);
        reviewAndPayFragment.loadingCaptcha = (TextView) Utils.findRequiredViewAsType(view, R.id.loading_captcha, "field 'loadingCaptcha'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.captcharefresh, "field 'captchaRefresh' and method 'refreshCaptchaCNFPwd'");
        reviewAndPayFragment.captchaRefresh = (ImageView) Utils.castView(findRequiredView2, R.id.captcharefresh, "field 'captchaRefresh'", cls4);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(reviewAndPayFragment));
        reviewAndPayFragment.fastestcharge = (TextView) Utils.findRequiredViewAsType(view, R.id.fastest_charge, "field 'fastestcharge'", cls);
        reviewAndPayFragment.servicecharges = (TextView) Utils.findRequiredViewAsType(view, R.id.service_charges, "field 'servicecharges'", cls);
        reviewAndPayFragment.ConvenienceFee = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ConvenienceFee, "field 'ConvenienceFee'", cls);
        reviewAndPayFragment.totalamount = (TextView) Utils.findRequiredViewAsType(view, R.id.total_amount, "field 'totalamount'", cls);
        reviewAndPayFragment.insurancecharge = (TextView) Utils.findRequiredViewAsType(view, R.id.insurance_charge, "field 'insurancecharge'", cls);
        Class cls5 = LinearLayout.class;
        reviewAndPayFragment.llOtpInput = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.otp_input_layout, "field 'llOtpInput'", cls5);
        reviewAndPayFragment.llCaptchaInput = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_captch_input, "field 'llCaptchaInput'", cls5);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.fare_layout, "field 'farelayout' and method 'onFareBackClose'");
        Class cls6 = RelativeLayout.class;
        reviewAndPayFragment.farelayout = (RelativeLayout) Utils.castView(findRequiredView3, R.id.fare_layout, "field 'farelayout'", cls6);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(reviewAndPayFragment));
        reviewAndPayFragment.quota = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_quota, "field 'quota'", cls);
        reviewAndPayFragment.termcondition = (TextView) Utils.findRequiredViewAsType(view, R.id.termcondition, "field 'termcondition'", cls);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.make_payment, "field 'makePaymentButton' and method 'onMakePaymentClick'");
        reviewAndPayFragment.makePaymentButton = (TextView) Utils.castView(findRequiredView4, R.id.make_payment, "field 'makePaymentButton'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(reviewAndPayFragment));
        reviewAndPayFragment.rv_addmeal_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_addmeal_list, "field 'rv_addmeal_list'", cls2);
        reviewAndPayFragment.add_meal_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.add_meal_ll, "field 'add_meal_ll'", cls5);
        reviewAndPayFragment.total_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_amount, "field 'total_amount'", cls);
        reviewAndPayFragment.insurance_opt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_insurance_opt, "field 'insurance_opt'", cls);
        reviewAndPayFragment.nlpCaptchaLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.nlpcaptcha_layout, "field 'nlpCaptchaLayout'", cls5);
        reviewAndPayFragment.nlp_heading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.nlp_heading, "field 'nlp_heading'", cls5);
        reviewAndPayFragment.travel_insurance_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_ll, "field 'travel_insurance_ll'", cls5);
        reviewAndPayFragment.travel_insurance_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_rl, "field 'travel_insurance_rl'", cls6);
        reviewAndPayFragment.ll_tainname_haedind_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tainname_haedind_lap1, "field 'll_tainname_haedind_lap1'", cls5);
        reviewAndPayFragment.psgn_detail_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_detail_heading, "field 'psgn_detail_heading'", cls);
        reviewAndPayFragment.ll_travel_insurance = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_travel_insurance, "field 'll_travel_insurance'", cls5);
        reviewAndPayFragment.ll_from_to_header_lap = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_from_to_header_lap, "field 'll_from_to_header_lap'", cls5);
        reviewAndPayFragment.train_type_lap1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.train_type_lap1, "field 'train_type_lap1'", cls4);
        reviewAndPayFragment.header_fromstn = (TextView) Utils.findRequiredViewAsType(view, R.id.header_fromstn, "field 'header_fromstn'", cls);
        reviewAndPayFragment.header_tomstn = (TextView) Utils.findRequiredViewAsType(view, R.id.header_tomstn, "field 'header_tomstn'", cls);
        reviewAndPayFragment.header_Via = (TextView) Utils.findRequiredViewAsType(view, R.id.header_Via, "field 'header_Via'", cls);
        reviewAndPayFragment.header_total_duration = (TextView) Utils.findRequiredViewAsType(view, R.id.header_total_duration, "field 'header_total_duration'", cls);
        reviewAndPayFragment.lap1_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.lap1_heading, "field 'lap1_heading'", cls);
        reviewAndPayFragment.iv_routmap = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_routmap, "field 'iv_routmap'", cls4);
        reviewAndPayFragment.ll_wait_duration_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_wait_duration_lap1, "field 'll_wait_duration_lap1'", cls5);
        reviewAndPayFragment.tv_wait_duration = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wait_duration, "field 'tv_wait_duration'", cls);
        reviewAndPayFragment.ll_tainname_haedind_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tainname_haedind_lap2, "field 'll_tainname_haedind_lap2'", cls5);
        reviewAndPayFragment.lap2_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.lap2_heading, "field 'lap2_heading'", cls);
        reviewAndPayFragment.iv_routmap_lap2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_routmap_lap2, "field 'iv_routmap_lap2'", cls4);
        reviewAndPayFragment.tain_detail_ll_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tain_detail_ll_lap2, "field 'tain_detail_ll_lap2'", cls5);
        reviewAndPayFragment.tv_dep_time_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dep_time_lap2, "field 'tv_dep_time_lap2'", cls);
        reviewAndPayFragment.tv_dep_date_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dep_date_lap2, "field 'tv_dep_date_lap2'", cls);
        reviewAndPayFragment.tv_arv_date_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arv_date_lap2, "field 'tv_arv_date_lap2'", cls);
        reviewAndPayFragment.tv_from_stationname_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_from_stationname_lap2, "field 'tv_from_stationname_lap2'", cls);
        reviewAndPayFragment.tv_to_stationname_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_to_stationname_lap2, "field 'tv_to_stationname_lap2'", cls);
        reviewAndPayFragment.booking_status_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_status_lap2, "field 'booking_status_lap2'", cls);
        reviewAndPayFragment.tv_quota_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_quota_lap2, "field 'tv_quota_lap2'", cls);
        reviewAndPayFragment.psgnCount_Class_Quota_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.psgnCount_Class_Quota_lap2, "field 'psgnCount_Class_Quota_lap2'", cls);
        reviewAndPayFragment.psgn_detail_lap1 = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_detail_lap1, "field 'psgn_detail_lap1'", cls);
        reviewAndPayFragment.passanger_detail_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.passanger_detail_lap2, "field 'passanger_detail_lap2'", cls5);
        reviewAndPayFragment.passenger_list2 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.passenger_list2, "field 'passenger_list2'", cls2);
        reviewAndPayFragment.add_meal_ll_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.add_meal_ll_lap2, "field 'add_meal_ll_lap2'", cls5);
        reviewAndPayFragment.rv_addmeal_list_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_addmeal_list_lap2, "field 'rv_addmeal_list_lap2'", cls2);
        reviewAndPayFragment.ll_payment_method_label = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_payment_method_label, "field 'll_payment_method_label'", cls5);
        reviewAndPayFragment.tv_payment_method_label = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_method_label, "field 'tv_payment_method_label'", cls);
        reviewAndPayFragment.travel_insurance_ll_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_ll_lap1, "field 'travel_insurance_ll_lap1'", cls5);
        reviewAndPayFragment.travel_insurance_ll_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_ll_lap2, "field 'travel_insurance_ll_lap2'", cls5);
        reviewAndPayFragment.tv_insurance_opt_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_insurance_opt_lap2, "field 'tv_insurance_opt_lap2'", cls);
        reviewAndPayFragment.selected_train_name_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_train_name_lap2, "field 'selected_train_name_lap2'", cls);
        reviewAndPayFragment.selected_train_number_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_train_number_lap2, "field 'selected_train_number_lap2'", cls);
        reviewAndPayFragment.travel_Time_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_Time_lap2, "field 'travel_Time_lap2'", cls);
        reviewAndPayFragment.tv_arv_timee_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arv_timee_lap2, "field 'tv_arv_timee_lap2'", cls);
        reviewAndPayFragment.passenger_detail_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.passenger_detail_lap1, "field 'passenger_detail_lap1'", cls5);
        reviewAndPayFragment.train_type_lap2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.train_type_lap2, "field 'train_type_lap2'", cls4);
        reviewAndPayFragment.farebreakup = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.farebreakup, "field 'farebreakup'", cls2);
        reviewAndPayFragment.fare_backup_single_jrny = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.fare_backup_single_jrny, "field 'fare_backup_single_jrny'", cls5);
        reviewAndPayFragment.tv_insurance_opt_lap1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_insurance_opt_lap1, "field 'tv_insurance_opt_lap1'", cls);
        reviewAndPayFragment.reviewJourneyBotAd = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.review_journey_bot_ad, "field 'reviewJourneyBotAd'", AdManagerAdView.class);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.fare_backup, "method 'onFareBackUp'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(reviewAndPayFragment));
    }

    public final void unbind() {
        ReviewAndPayFragment reviewAndPayFragment = this.f5106a;
        if (reviewAndPayFragment != null) {
            this.f5106a = null;
            reviewAndPayFragment.trainNameView = null;
            reviewAndPayFragment.trainNumberView = null;
            reviewAndPayFragment.bookingStatusView = null;
            reviewAndPayFragment.departureDateView = null;
            reviewAndPayFragment.arrivalDateView = null;
            reviewAndPayFragment.departureTimeView = null;
            reviewAndPayFragment.arrivalTimeView = null;
            reviewAndPayFragment.travelTimeView = null;
            reviewAndPayFragment.fromStation = null;
            reviewAndPayFragment.toStation = null;
            reviewAndPayFragment.psgnCountClassQuotaView = null;
            reviewAndPayFragment.passengerListView = null;
            reviewAndPayFragment.ticketSentLevelView = null;
            reviewAndPayFragment.otpInput = null;
            reviewAndPayFragment.reSendOtp = null;
            reviewAndPayFragment.netAmount = null;
            reviewAndPayFragment.captcha = null;
            reviewAndPayFragment.captchaInput = null;
            reviewAndPayFragment.loadingCaptcha = null;
            reviewAndPayFragment.captchaRefresh = null;
            reviewAndPayFragment.fastestcharge = null;
            reviewAndPayFragment.servicecharges = null;
            reviewAndPayFragment.ConvenienceFee = null;
            reviewAndPayFragment.totalamount = null;
            reviewAndPayFragment.insurancecharge = null;
            reviewAndPayFragment.llOtpInput = null;
            reviewAndPayFragment.llCaptchaInput = null;
            reviewAndPayFragment.farelayout = null;
            reviewAndPayFragment.quota = null;
            reviewAndPayFragment.termcondition = null;
            reviewAndPayFragment.makePaymentButton = null;
            reviewAndPayFragment.rv_addmeal_list = null;
            reviewAndPayFragment.add_meal_ll = null;
            reviewAndPayFragment.total_amount = null;
            reviewAndPayFragment.insurance_opt = null;
            reviewAndPayFragment.nlpCaptchaLayout = null;
            reviewAndPayFragment.nlp_heading = null;
            reviewAndPayFragment.travel_insurance_ll = null;
            reviewAndPayFragment.travel_insurance_rl = null;
            reviewAndPayFragment.ll_tainname_haedind_lap1 = null;
            reviewAndPayFragment.psgn_detail_heading = null;
            reviewAndPayFragment.ll_travel_insurance = null;
            reviewAndPayFragment.ll_from_to_header_lap = null;
            reviewAndPayFragment.train_type_lap1 = null;
            reviewAndPayFragment.header_fromstn = null;
            reviewAndPayFragment.header_tomstn = null;
            reviewAndPayFragment.header_Via = null;
            reviewAndPayFragment.header_total_duration = null;
            reviewAndPayFragment.lap1_heading = null;
            reviewAndPayFragment.iv_routmap = null;
            reviewAndPayFragment.ll_wait_duration_lap1 = null;
            reviewAndPayFragment.tv_wait_duration = null;
            reviewAndPayFragment.ll_tainname_haedind_lap2 = null;
            reviewAndPayFragment.lap2_heading = null;
            reviewAndPayFragment.iv_routmap_lap2 = null;
            reviewAndPayFragment.tain_detail_ll_lap2 = null;
            reviewAndPayFragment.tv_dep_time_lap2 = null;
            reviewAndPayFragment.tv_dep_date_lap2 = null;
            reviewAndPayFragment.tv_arv_date_lap2 = null;
            reviewAndPayFragment.tv_from_stationname_lap2 = null;
            reviewAndPayFragment.tv_to_stationname_lap2 = null;
            reviewAndPayFragment.booking_status_lap2 = null;
            reviewAndPayFragment.tv_quota_lap2 = null;
            reviewAndPayFragment.psgnCount_Class_Quota_lap2 = null;
            reviewAndPayFragment.psgn_detail_lap1 = null;
            reviewAndPayFragment.passanger_detail_lap2 = null;
            reviewAndPayFragment.passenger_list2 = null;
            reviewAndPayFragment.add_meal_ll_lap2 = null;
            reviewAndPayFragment.rv_addmeal_list_lap2 = null;
            reviewAndPayFragment.ll_payment_method_label = null;
            reviewAndPayFragment.tv_payment_method_label = null;
            reviewAndPayFragment.travel_insurance_ll_lap1 = null;
            reviewAndPayFragment.travel_insurance_ll_lap2 = null;
            reviewAndPayFragment.tv_insurance_opt_lap2 = null;
            reviewAndPayFragment.selected_train_name_lap2 = null;
            reviewAndPayFragment.selected_train_number_lap2 = null;
            reviewAndPayFragment.travel_Time_lap2 = null;
            reviewAndPayFragment.tv_arv_timee_lap2 = null;
            reviewAndPayFragment.passenger_detail_lap1 = null;
            reviewAndPayFragment.train_type_lap2 = null;
            reviewAndPayFragment.farebreakup = null;
            reviewAndPayFragment.fare_backup_single_jrny = null;
            reviewAndPayFragment.tv_insurance_opt_lap1 = null;
            reviewAndPayFragment.reviewJourneyBotAd = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
