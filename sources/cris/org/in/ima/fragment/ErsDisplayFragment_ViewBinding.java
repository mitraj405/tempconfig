package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class ErsDisplayFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ErsDisplayFragment f4605a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View r;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public a(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onMealClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public b(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onbusClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public c(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.orderfoodPantryCarClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public d(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.oncancellationpolicylick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public e(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onSendMailPdfClick();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public f(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onDownloadPdfClick();
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public g(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onprinClick();
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public h(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.updateBoadingPoint();
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public i(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onSaveERSClick();
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public j(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.changeBoadingClick();
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public k(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onDelhiMetroClick(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public l(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onConnectingClick();
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public m(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onShareButtonClick();
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public n(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onClicfundadutymsg(view);
        }
    }

    public class o extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public o(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onIndianQrTxtClick(view);
        }
    }

    public class p extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public p(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onDoneAddMealClick(view);
        }
    }

    public class q extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public q(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onRRClick();
        }
    }

    public class r extends DebouncingOnClickListener {
        public final /* synthetic */ ErsDisplayFragment a;

        public r(ErsDisplayFragment ersDisplayFragment) {
            this.a = ersDisplayFragment;
        }

        public final void doClick(View view) {
            this.a.onHotelClick();
        }
    }

    public ErsDisplayFragment_ViewBinding(ErsDisplayFragment ersDisplayFragment, View view) {
        this.f4605a = ersDisplayFragment;
        Class cls = TextView.class;
        ersDisplayFragment.trainNo = (TextView) Utils.findOptionalViewAsType(view, R.id.train_no, "field 'trainNo'", cls);
        ersDisplayFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        ersDisplayFragment.pnrNo = (TextView) Utils.findOptionalViewAsType(view, R.id.pnr_no, "field 'pnrNo'", cls);
        ersDisplayFragment.fromStation = (TextView) Utils.findOptionalViewAsType(view, R.id.from_station, "field 'fromStation'", cls);
        ersDisplayFragment.toStation = (TextView) Utils.findOptionalViewAsType(view, R.id.to_station, "field 'toStation'", cls);
        ersDisplayFragment.deptDate = (TextView) Utils.findOptionalViewAsType(view, R.id.dept_date, "field 'deptDate'", cls);
        ersDisplayFragment.arvDate = (TextView) Utils.findOptionalViewAsType(view, R.id.arv_date, "field 'arvDate'", cls);
        ersDisplayFragment.deptTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dept_time, "field 'deptTime'", cls);
        ersDisplayFragment.arvTime = (TextView) Utils.findOptionalViewAsType(view, R.id.arv_time, "field 'arvTime'", cls);
        ersDisplayFragment.travelTime = (TextView) Utils.findOptionalViewAsType(view, R.id.travel_time, "field 'travelTime'", cls);
        Class cls2 = LinearLayout.class;
        ersDisplayFragment.traveltime_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_time_ll, "field 'traveltime_ll'", cls2);
        ersDisplayFragment.clsQtBoarding = (TextView) Utils.findOptionalViewAsType(view, R.id.cls_qt_stn, "field 'clsQtBoarding'", cls);
        ersDisplayFragment.transactionId = (TextView) Utils.findOptionalViewAsType(view, R.id.transaction_id, "field 'transactionId'", cls);
        ersDisplayFragment.totalFare = (TextView) Utils.findOptionalViewAsType(view, R.id.total_fare, "field 'totalFare'", cls);
        ersDisplayFragment.ersMsgs = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ers_msgs, "field 'ersMsgs'", cls);
        Class cls3 = RecyclerView.class;
        ersDisplayFragment.psgnList = (RecyclerView) Utils.findOptionalViewAsType(view, R.id.psgnList, "field 'psgnList'", cls3);
        ersDisplayFragment.header = (LinearLayout) Utils.findOptionalViewAsType(view, R.id.header, "field 'header'", cls2);
        ersDisplayFragment.pre = (TextView) Utils.findRequiredViewAsType(view, R.id.pre, "field 'pre'", cls);
        ersDisplayFragment.cnfCheckCetails = (TextView) Utils.findRequiredViewAsType(view, R.id.cnf_check_details, "field 'cnfCheckCetails'", cls);
        ersDisplayFragment.cnfBtnLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cnf_btn_layout, "field 'cnfBtnLayout'", cls2);
        ersDisplayFragment.scrollView = (NestedScrollView) Utils.findOptionalViewAsType(view, R.id.tkt, "field 'scrollView'", NestedScrollView.class);
        ersDisplayFragment.tktSentMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_sent_msg, "field 'tktSentMsg'", cls);
        ersDisplayFragment.replan = (TextView) Utils.findRequiredViewAsType(view, R.id.replan, "field 'replan'", cls);
        ersDisplayFragment.travelInsurance = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_insurance, "field 'travelInsurance'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.change_boarding_ll, "field 'changeBoardingLl' and method 'changeBoadingClick'");
        Class cls4 = RelativeLayout.class;
        ersDisplayFragment.changeBoardingLl = (RelativeLayout) Utils.castView(findRequiredView, R.id.change_boarding_ll, "field 'changeBoardingLl'", cls4);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new j(ersDisplayFragment));
        ersDisplayFragment.boardingStnView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.boarding_stn, "field 'boardingStnView'", cls3);
        ersDisplayFragment.vikalpOpt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vikalp_opt, "field 'vikalpOpt'", cls);
        ersDisplayFragment.chartStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chart_status, "field 'chartStatus'", cls);
        ersDisplayFragment.currentStatusLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.current_status_ll, "field 'currentStatusLl'", cls2);
        ersDisplayFragment.travelInsurancelayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_layout, "field 'travelInsurancelayout'", cls2);
        ersDisplayFragment.travelInsuranceName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_travel_Insurance_name, "field 'travelInsuranceName'", cls);
        ersDisplayFragment.fillNomineeDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fill_nominee_details, "field 'fillNomineeDetails'", cls);
        ersDisplayFragment.passengerName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_passenger_name, "field 'passengerName'", cls);
        ersDisplayFragment.gstnStateName = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_supplier_state_name, "field 'gstnStateName'", cls);
        ersDisplayFragment.gstnSuplierCode = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_supplier_Id, "field 'gstnSuplierCode'", cls);
        ersDisplayFragment.sacNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.sac_id_supplier, "field 'sacNumber'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_tab_delhi_metro, "field 'tv_tab_delhi_metro' and method 'onDelhiMetroClick'");
        ersDisplayFragment.tv_tab_delhi_metro = (TextView) Utils.castView(findRequiredView2, R.id.tv_tab_delhi_metro, "field 'tv_tab_delhi_metro'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new k(ersDisplayFragment));
        ersDisplayFragment.cgstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.cgst_amt, "field 'cgstAmt'", cls);
        ersDisplayFragment.cgstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.cgst_rate, "field 'cgstRate'", cls);
        ersDisplayFragment.sgstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.sgst_amt, "field 'sgstAmt'", cls);
        ersDisplayFragment.sgstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.sgst_rate, "field 'sgstRate'", cls);
        ersDisplayFragment.UgstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.ugst_amt, "field 'UgstAmt'", cls);
        ersDisplayFragment.UgstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.ugst_rate, "field 'UgstRate'", cls);
        ersDisplayFragment.igstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.igst_amt, "field 'igstAmt'", cls);
        ersDisplayFragment.igstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.igst_rate, "field 'igstRate'", cls);
        ersDisplayFragment.address = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_address, "field 'address'", cls);
        ersDisplayFragment.city = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_add_city, "field 'city'", cls);
        ersDisplayFragment.name = (TextView) Utils.findRequiredViewAsType(view, R.id.name_id, "field 'name'", cls);
        ersDisplayFragment.state = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_state, "field 'state'", cls);
        ersDisplayFragment.pincode = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_pincode, "field 'pincode'", cls);
        ersDisplayFragment.totalTax = (TextView) Utils.findRequiredViewAsType(view, R.id.total_tax, "field 'totalTax'", cls);
        ersDisplayFragment.totalValuableTax = (TextView) Utils.findRequiredViewAsType(view, R.id.tax_val, "field 'totalValuableTax'", cls);
        ersDisplayFragment.gstnRceiptId = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_recpt_id, "field 'gstnRceiptId'", cls);
        ersDisplayFragment.gstnRecptInfo = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.gstn_recpt_item, "field 'gstnRecptInfo'", cls2);
        ersDisplayFragment.sgstLayoutId = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.sgst_layout_id, "field 'sgstLayoutId'", cls4);
        ersDisplayFragment.cgstLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.cgst_layout_id, "field 'cgstLayout'", cls4);
        ersDisplayFragment.ugstLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ugst_layout_id, "field 'ugstLayout'", cls4);
        ersDisplayFragment.igstLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.igst_layout_id, "field 'igstLayout'", cls4);
        ersDisplayFragment.allGstDtlLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.all_gst_detail_layout, "field 'allGstDtlLayout'", cls2);
        ersDisplayFragment.gstBreakupLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_gst_breakup, "field 'gstBreakupLayout'", cls2);
        ersDisplayFragment.connectingPnrLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.connecting_pnr_layout, "field 'connectingPnrLayout'", cls2);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.connecting_pnr, "field 'connectingPnr' and method 'onConnectingClick'");
        ersDisplayFragment.connectingPnr = (TextView) Utils.castView(findRequiredView3, R.id.connecting_pnr, "field 'connectingPnr'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new l(ersDisplayFragment));
        ersDisplayFragment.lapType = (TextView) Utils.findRequiredViewAsType(view, R.id.lap_type, "field 'lapType'", cls);
        ersDisplayFragment.recipient_view = Utils.findRequiredView(view, R.id.recipient_view, "field 'recipient_view'");
        ersDisplayFragment.informationLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.informationLayout, "field 'informationLayout'", cls2);
        ersDisplayFragment.informationMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.informationMsg, "field 'informationMsg'", cls);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.shareButton, "field 'shareButton' and method 'onShareButtonClick'");
        Class cls5 = ImageView.class;
        ersDisplayFragment.shareButton = (ImageView) Utils.castView(findRequiredView4, R.id.shareButton, "field 'shareButton'", cls5);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new m(ersDisplayFragment));
        ersDisplayFragment.conviencefee = (TextView) Utils.findRequiredViewAsType(view, R.id.convience_fee, "field 'conviencefee'", cls);
        ersDisplayFragment.basefare = (TextView) Utils.findRequiredViewAsType(view, R.id.base_fare, "field 'basefare'", cls);
        ersDisplayFragment.policyopt = (TextView) Utils.findRequiredViewAsType(view, R.id.policy_opt, "field 'policyopt'", cls);
        ersDisplayFragment.ticketcharge = (TextView) Utils.findRequiredViewAsType(view, R.id.ticket_charge, "field 'ticketcharge'", cls);
        ersDisplayFragment.rl_bank_name = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rl_bank_name, "field 'rl_bank_name'", cls2);
        ersDisplayFragment.bankname = (TextView) Utils.findRequiredViewAsType(view, R.id.bank_name, "field 'bankname'", cls);
        ersDisplayFragment.rl_booked_from = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_booked_from, "field 'rl_booked_from'", cls4);
        ersDisplayFragment.bookedfrom = (TextView) Utils.findRequiredViewAsType(view, R.id.booked_from, "field 'bookedfrom'", cls);
        ersDisplayFragment.payment_from = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.payment_from, "field 'payment_from'", cls4);
        ersDisplayFragment.paymentmode = (TextView) Utils.findRequiredViewAsType(view, R.id.payment_mode, "field 'paymentmode'", cls);
        ersDisplayFragment.myBookingDetailCenter = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.my_booking_detail_center, "field 'myBookingDetailCenter'", AdManagerAdView.class);
        ersDisplayFragment.vigilanceMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vigilanceMsg, "field 'vigilanceMsg'", cls);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.funda_duty_ll, "field 'funda_duty_ll' and method 'onClicfundadutymsg'");
        ersDisplayFragment.funda_duty_ll = (RelativeLayout) Utils.castView(findRequiredView5, R.id.funda_duty_ll, "field 'funda_duty_ll'", cls4);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new n(ersDisplayFragment));
        ersDisplayFragment.funda_duty_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.funda_duty_detail_ll, "field 'funda_duty_detail_ll'", cls2);
        ersDisplayFragment.funda_duty_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.funda_duty_msg, "field 'funda_duty_msg'", cls);
        ersDisplayFragment.qr_code = (ImageView) Utils.findRequiredViewAsType(view, R.id.qr_code, "field 'qr_code'", cls5);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.indian_railway_qrtxt, "field 'indian_railway_qrtxt' and method 'onIndianQrTxtClick'");
        ersDisplayFragment.indian_railway_qrtxt = (TextView) Utils.castView(findRequiredView6, R.id.indian_railway_qrtxt, "field 'indian_railway_qrtxt'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new o(ersDisplayFragment));
        ersDisplayFragment.qr_view = Utils.findRequiredView(view, R.id.qr_view, "field 'qr_view'");
        ersDisplayFragment.from_stn = (TextView) Utils.findRequiredViewAsType(view, R.id.from_stn, "field 'from_stn'", cls);
        ersDisplayFragment.journey_date = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journey_date'", cls);
        ersDisplayFragment.active_date = (TextView) Utils.findRequiredViewAsType(view, R.id.active_date, "field 'active_date'", cls);
        ersDisplayFragment.toStn = (TextView) Utils.findRequiredViewAsType(view, R.id.toStn, "field 'toStn'", cls);
        ersDisplayFragment.mealdetail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mealdetail_ll, "field 'mealdetail_ll'", cls2);
        ersDisplayFragment.rv_addmeal_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_addmeal_list, "field 'rv_addmeal_list'", cls3);
        ersDisplayFragment.mpImageLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mp_image_layout, "field 'mpImageLayout'", cls2);
        ersDisplayFragment.mpImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.mp_image, "field 'mpImage'", cls5);
        ersDisplayFragment.lvaddmeal = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.lv_addmeal, "field 'lvaddmeal'", cls3);
        ersDisplayFragment.add_meal_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.add_meal_rl, "field 'add_meal_rl'", cls4);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.tv_done_meal, "field 'tv_done_meal' and method 'onDoneAddMealClick'");
        ersDisplayFragment.tv_done_meal = (TextView) Utils.castView(findRequiredView7, R.id.tv_done_meal, "field 'tv_done_meal'", cls);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new p(ersDisplayFragment));
        ersDisplayFragment.total_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_amount, "field 'total_amount'", cls);
        ersDisplayFragment.returnjourney_view = Utils.findRequiredView(view, R.id.return_journey_view, "field 'returnjourney_view'");
        ersDisplayFragment.returnjourney_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.return_journey_rl, "field 'returnjourney_rl'", cls4);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_retroom, "field 'tv_tab_upcoming_journey_retroom' and method 'onRRClick'");
        ersDisplayFragment.tv_tab_upcoming_journey_retroom = (TextView) Utils.castView(findRequiredView8, R.id.tv_tab_upcoming_journey_retroom, "field 'tv_tab_upcoming_journey_retroom'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new q(ersDisplayFragment));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_hotel, "field 'tv_tab_upcoming_journey_hotel' and method 'onHotelClick'");
        ersDisplayFragment.tv_tab_upcoming_journey_hotel = (TextView) Utils.castView(findRequiredView9, R.id.tv_tab_upcoming_journey_hotel, "field 'tv_tab_upcoming_journey_hotel'", cls);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new r(ersDisplayFragment));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_mot, "field 'tv_tab_upcoming_journey_mot' and method 'onMealClick'");
        ersDisplayFragment.tv_tab_upcoming_journey_mot = (TextView) Utils.castView(findRequiredView10, R.id.tv_tab_upcoming_journey_mot, "field 'tv_tab_upcoming_journey_mot'", cls);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new a(ersDisplayFragment));
        ersDisplayFragment.rv_train_detail = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.train_detail, "field 'rv_train_detail'", cls3);
        ersDisplayFragment.psgnList_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.psgnList_lap2, "field 'psgnList_lap2'", cls3);
        ersDisplayFragment.meal_detail_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.meal_detail_lap2, "field 'meal_detail_lap2'", cls2);
        ersDisplayFragment.rv_addmeal_list_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_addmeal_list_lap2, "field 'rv_addmeal_list_lap2'", cls3);
        ersDisplayFragment.tain_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tain_detail_ll, "field 'tain_detail_ll'", cls2);
        ersDisplayFragment.messages_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.messages_lap1, "field 'messages_lap1'", cls2);
        ersDisplayFragment.lap1 = (TextView) Utils.findRequiredViewAsType(view, R.id.lap1, "field 'lap1'", cls);
        ersDisplayFragment.messages_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.messages_lap2, "field 'messages_lap2'", cls2);
        ersDisplayFragment.lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.lap2, "field 'lap2'", cls);
        ersDisplayFragment.informationLayout_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.informationLayout_lap2, "field 'informationLayout_lap2'", cls2);
        ersDisplayFragment.informationMsg_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.informationMsg_lap2, "field 'informationMsg_lap2'", cls);
        ersDisplayFragment.tv_ers_msgs_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ers_msgs_lap2, "field 'tv_ers_msgs_lap2'", cls);
        ersDisplayFragment.attention_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.attention_msg, "field 'attention_msg'", cls);
        ersDisplayFragment.attention_msg1 = (TextView) Utils.findRequiredViewAsType(view, R.id.attention_msg1, "field 'attention_msg1'", cls);
        ersDisplayFragment.travel_insurance_rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.travel_insurance_rv, "field 'travel_insurance_rv'", cls3);
        ersDisplayFragment.travel_insurance_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_ll, "field 'travel_insurance_ll'", cls2);
        View findRequiredView11 = Utils.findRequiredView(view, R.id.tv_bus, "field 'tv_bus' and method 'onbusClick'");
        ersDisplayFragment.tv_bus = (TextView) Utils.castView(findRequiredView11, R.id.tv_bus, "field 'tv_bus'", cls);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new b(ersDisplayFragment));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.orderfood_Pantry_Car, "field 'orderfood_Pantry_Car' and method 'orderfoodPantryCarClick'");
        ersDisplayFragment.orderfood_Pantry_Car = (TextView) Utils.castView(findRequiredView12, R.id.orderfood_Pantry_Car, "field 'orderfood_Pantry_Car'", cls);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new c(ersDisplayFragment));
        View findRequiredView13 = Utils.findRequiredView(view, R.id.tv_cancellation_policy, "field 'tv_cancellation_policy' and method 'oncancellationpolicylick'");
        ersDisplayFragment.tv_cancellation_policy = (TextView) Utils.castView(findRequiredView13, R.id.tv_cancellation_policy, "field 'tv_cancellation_policy'", cls);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new d(ersDisplayFragment));
        ersDisplayFragment.ersmsg_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ers_msg_ll, "field 'ersmsg_ll'", cls2);
        ersDisplayFragment.feedback_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.feedback_ll, "field 'feedback_ll'", cls2);
        View findRequiredView14 = Utils.findRequiredView(view, R.id.send_mail_pdf, "field 'send_mail_pdf' and method 'onSendMailPdfClick'");
        ersDisplayFragment.send_mail_pdf = (ImageView) Utils.castView(findRequiredView14, R.id.send_mail_pdf, "field 'send_mail_pdf'", cls5);
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new e(ersDisplayFragment));
        ersDisplayFragment.dmrcQrCodeViewPager = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.dmrc_qr_code_view_pager, "field 'dmrcQrCodeViewPager'", cls3);
        ersDisplayFragment.ersDisplayFragment = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ersDisplayFragment, "field 'ersDisplayFragment'", cls2);
        ersDisplayFragment.qrImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.qrImg, "field 'qrImg'", cls5);
        ersDisplayFragment.qrImgCross = (ImageView) Utils.findRequiredViewAsType(view, R.id.qrImgCross, "field 'qrImgCross'", cls5);
        ersDisplayFragment.qrImagelayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.qrImage_layout, "field 'qrImagelayout'", cls2);
        ersDisplayFragment.qr_no = (TextView) Utils.findRequiredViewAsType(view, R.id.qr_no, "field 'qr_no'", cls);
        ersDisplayFragment.right_arrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.right_arrow, "field 'right_arrow'", cls5);
        ersDisplayFragment.left_arrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.left_arrow, "field 'left_arrow'", cls5);
        View findRequiredView15 = Utils.findRequiredView(view, R.id.downloadpdf, "field 'downloadpdf' and method 'onDownloadPdfClick'");
        ersDisplayFragment.downloadpdf = (ImageView) Utils.castView(findRequiredView15, R.id.downloadpdf, "field 'downloadpdf'", cls5);
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new f(ersDisplayFragment));
        ersDisplayFragment.qrTicketDetails_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.qr_ticket_details_ll, "field 'qrTicketDetails_ll'", cls2);
        ersDisplayFragment.qrCancelMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.qr_cancel_msg, "field 'qrCancelMsg'", cls);
        View findRequiredView16 = Utils.findRequiredView(view, R.id.print_ticket, "method 'onprinClick'");
        this.p = findRequiredView16;
        findRequiredView16.setOnClickListener(new g(ersDisplayFragment));
        View findRequiredView17 = Utils.findRequiredView(view, R.id.update_boading_point, "method 'updateBoadingPoint'");
        this.q = findRequiredView17;
        findRequiredView17.setOnClickListener(new h(ersDisplayFragment));
        View findRequiredView18 = Utils.findRequiredView(view, R.id.save_ers, "method 'onSaveERSClick'");
        this.r = findRequiredView18;
        findRequiredView18.setOnClickListener(new i(ersDisplayFragment));
    }

    public final void unbind() {
        ErsDisplayFragment ersDisplayFragment = this.f4605a;
        if (ersDisplayFragment != null) {
            this.f4605a = null;
            ersDisplayFragment.trainNo = null;
            ersDisplayFragment.trainName = null;
            ersDisplayFragment.pnrNo = null;
            ersDisplayFragment.fromStation = null;
            ersDisplayFragment.toStation = null;
            ersDisplayFragment.deptDate = null;
            ersDisplayFragment.arvDate = null;
            ersDisplayFragment.deptTime = null;
            ersDisplayFragment.arvTime = null;
            ersDisplayFragment.travelTime = null;
            ersDisplayFragment.traveltime_ll = null;
            ersDisplayFragment.clsQtBoarding = null;
            ersDisplayFragment.transactionId = null;
            ersDisplayFragment.totalFare = null;
            ersDisplayFragment.ersMsgs = null;
            ersDisplayFragment.psgnList = null;
            ersDisplayFragment.header = null;
            ersDisplayFragment.pre = null;
            ersDisplayFragment.cnfCheckCetails = null;
            ersDisplayFragment.cnfBtnLayout = null;
            ersDisplayFragment.scrollView = null;
            ersDisplayFragment.tktSentMsg = null;
            ersDisplayFragment.replan = null;
            ersDisplayFragment.travelInsurance = null;
            ersDisplayFragment.changeBoardingLl = null;
            ersDisplayFragment.boardingStnView = null;
            ersDisplayFragment.vikalpOpt = null;
            ersDisplayFragment.chartStatus = null;
            ersDisplayFragment.currentStatusLl = null;
            ersDisplayFragment.travelInsurancelayout = null;
            ersDisplayFragment.travelInsuranceName = null;
            ersDisplayFragment.fillNomineeDetails = null;
            ersDisplayFragment.passengerName = null;
            ersDisplayFragment.gstnStateName = null;
            ersDisplayFragment.gstnSuplierCode = null;
            ersDisplayFragment.sacNumber = null;
            ersDisplayFragment.tv_tab_delhi_metro = null;
            ersDisplayFragment.cgstAmt = null;
            ersDisplayFragment.cgstRate = null;
            ersDisplayFragment.sgstAmt = null;
            ersDisplayFragment.sgstRate = null;
            ersDisplayFragment.UgstAmt = null;
            ersDisplayFragment.UgstRate = null;
            ersDisplayFragment.igstAmt = null;
            ersDisplayFragment.igstRate = null;
            ersDisplayFragment.address = null;
            ersDisplayFragment.city = null;
            ersDisplayFragment.name = null;
            ersDisplayFragment.state = null;
            ersDisplayFragment.pincode = null;
            ersDisplayFragment.totalTax = null;
            ersDisplayFragment.totalValuableTax = null;
            ersDisplayFragment.gstnRceiptId = null;
            ersDisplayFragment.gstnRecptInfo = null;
            ersDisplayFragment.sgstLayoutId = null;
            ersDisplayFragment.cgstLayout = null;
            ersDisplayFragment.ugstLayout = null;
            ersDisplayFragment.igstLayout = null;
            ersDisplayFragment.allGstDtlLayout = null;
            ersDisplayFragment.gstBreakupLayout = null;
            ersDisplayFragment.connectingPnrLayout = null;
            ersDisplayFragment.connectingPnr = null;
            ersDisplayFragment.lapType = null;
            ersDisplayFragment.recipient_view = null;
            ersDisplayFragment.informationLayout = null;
            ersDisplayFragment.informationMsg = null;
            ersDisplayFragment.shareButton = null;
            ersDisplayFragment.conviencefee = null;
            ersDisplayFragment.basefare = null;
            ersDisplayFragment.policyopt = null;
            ersDisplayFragment.ticketcharge = null;
            ersDisplayFragment.rl_bank_name = null;
            ersDisplayFragment.bankname = null;
            ersDisplayFragment.rl_booked_from = null;
            ersDisplayFragment.bookedfrom = null;
            ersDisplayFragment.payment_from = null;
            ersDisplayFragment.paymentmode = null;
            ersDisplayFragment.myBookingDetailCenter = null;
            ersDisplayFragment.vigilanceMsg = null;
            ersDisplayFragment.funda_duty_ll = null;
            ersDisplayFragment.funda_duty_detail_ll = null;
            ersDisplayFragment.funda_duty_msg = null;
            ersDisplayFragment.qr_code = null;
            ersDisplayFragment.indian_railway_qrtxt = null;
            ersDisplayFragment.qr_view = null;
            ersDisplayFragment.from_stn = null;
            ersDisplayFragment.journey_date = null;
            ersDisplayFragment.active_date = null;
            ersDisplayFragment.toStn = null;
            ersDisplayFragment.mealdetail_ll = null;
            ersDisplayFragment.rv_addmeal_list = null;
            ersDisplayFragment.mpImageLayout = null;
            ersDisplayFragment.mpImage = null;
            ersDisplayFragment.lvaddmeal = null;
            ersDisplayFragment.add_meal_rl = null;
            ersDisplayFragment.tv_done_meal = null;
            ersDisplayFragment.total_amount = null;
            ersDisplayFragment.returnjourney_view = null;
            ersDisplayFragment.returnjourney_rl = null;
            ersDisplayFragment.tv_tab_upcoming_journey_retroom = null;
            ersDisplayFragment.tv_tab_upcoming_journey_hotel = null;
            ersDisplayFragment.tv_tab_upcoming_journey_mot = null;
            ersDisplayFragment.rv_train_detail = null;
            ersDisplayFragment.psgnList_lap2 = null;
            ersDisplayFragment.meal_detail_lap2 = null;
            ersDisplayFragment.rv_addmeal_list_lap2 = null;
            ersDisplayFragment.tain_detail_ll = null;
            ersDisplayFragment.messages_lap1 = null;
            ersDisplayFragment.lap1 = null;
            ersDisplayFragment.messages_lap2 = null;
            ersDisplayFragment.lap2 = null;
            ersDisplayFragment.informationLayout_lap2 = null;
            ersDisplayFragment.informationMsg_lap2 = null;
            ersDisplayFragment.tv_ers_msgs_lap2 = null;
            ersDisplayFragment.attention_msg = null;
            ersDisplayFragment.attention_msg1 = null;
            ersDisplayFragment.travel_insurance_rv = null;
            ersDisplayFragment.travel_insurance_ll = null;
            ersDisplayFragment.tv_bus = null;
            ersDisplayFragment.orderfood_Pantry_Car = null;
            ersDisplayFragment.tv_cancellation_policy = null;
            ersDisplayFragment.ersmsg_ll = null;
            ersDisplayFragment.feedback_ll = null;
            ersDisplayFragment.send_mail_pdf = null;
            ersDisplayFragment.dmrcQrCodeViewPager = null;
            ersDisplayFragment.ersDisplayFragment = null;
            ersDisplayFragment.qrImg = null;
            ersDisplayFragment.qrImgCross = null;
            ersDisplayFragment.qrImagelayout = null;
            ersDisplayFragment.qr_no = null;
            ersDisplayFragment.right_arrow = null;
            ersDisplayFragment.left_arrow = null;
            ersDisplayFragment.downloadpdf = null;
            ersDisplayFragment.qrTicketDetails_ll = null;
            ersDisplayFragment.qrCancelMsg = null;
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
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
            this.n.setOnClickListener((View.OnClickListener) null);
            this.n = null;
            this.o.setOnClickListener((View.OnClickListener) null);
            this.o = null;
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
            this.q.setOnClickListener((View.OnClickListener) null);
            this.q = null;
            this.r.setOnClickListener((View.OnClickListener) null);
            this.r = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
