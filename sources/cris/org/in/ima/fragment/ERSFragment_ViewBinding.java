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

public class ERSFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ERSFragment f4567a;
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

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public a(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onSendMailPdfClick();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public b(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onDownloadPdfClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public c(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onClickDelhiMetroIcon(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public d(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onSaveERSClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public e(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onShareButtonClick();
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public f(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onReplanClick();
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public g(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onClicfundadutymsg(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public h(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onDoneAddMealClick(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public i(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onRRRoomClick();
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public j(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onRRHotelClick();
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public k(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onMealClick();
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public l(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.oncancellationpolicylick();
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public m(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.onbusClick();
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ ERSFragment a;

        public n(ERSFragment eRSFragment) {
            this.a = eRSFragment;
        }

        public final void doClick(View view) {
            this.a.orderfoodPantryCarClick(view);
        }
    }

    public ERSFragment_ViewBinding(ERSFragment eRSFragment, View view) {
        this.f4567a = eRSFragment;
        Class cls = TextView.class;
        eRSFragment.trainNo = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainNo'", cls);
        eRSFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        eRSFragment.pnrNo = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr_no, "field 'pnrNo'", cls);
        eRSFragment.fromStation = (TextView) Utils.findRequiredViewAsType(view, R.id.from_station, "field 'fromStation'", cls);
        eRSFragment.toStation = (TextView) Utils.findRequiredViewAsType(view, R.id.to_station, "field 'toStation'", cls);
        eRSFragment.deptDate = (TextView) Utils.findRequiredViewAsType(view, R.id.dept_date, "field 'deptDate'", cls);
        eRSFragment.arvDate = (TextView) Utils.findOptionalViewAsType(view, R.id.arv_date, "field 'arvDate'", cls);
        eRSFragment.deptTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dept_time, "field 'deptTime'", cls);
        eRSFragment.arvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.arv_time, "field 'arvTime'", cls);
        eRSFragment.clsQtBoarding = (TextView) Utils.findRequiredViewAsType(view, R.id.cls_qt_stn, "field 'clsQtBoarding'", cls);
        eRSFragment.transactionId = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id, "field 'transactionId'", cls);
        eRSFragment.totalFare = (TextView) Utils.findRequiredViewAsType(view, R.id.total_fare, "field 'totalFare'", cls);
        eRSFragment.travelTime = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_time, "field 'travelTime'", cls);
        Class cls2 = LinearLayout.class;
        eRSFragment.traveltime_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_time_ll, "field 'traveltime_ll'", cls2);
        Class cls3 = RecyclerView.class;
        eRSFragment.psgnList = (RecyclerView) Utils.findOptionalViewAsType(view, R.id.psgnList, "field 'psgnList'", cls3);
        View findRequiredView = Utils.findRequiredView(view, R.id.replan, "field 'replan' and method 'onReplanClick'");
        eRSFragment.replan = (TextView) Utils.castView(findRequiredView, R.id.replan, "field 'replan'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new f(eRSFragment));
        eRSFragment.travelInsurance = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_insurance, "field 'travelInsurance'", cls);
        eRSFragment.informationLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.informationLayout, "field 'informationLayout'", cls2);
        eRSFragment.informationMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.informationMsg, "field 'informationMsg'", cls);
        eRSFragment.ersMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ers_msgs, "field 'ersMsg'", cls);
        eRSFragment.scrollView = (NestedScrollView) Utils.findOptionalViewAsType(view, R.id.tkt, "field 'scrollView'", NestedScrollView.class);
        eRSFragment.tktSentMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_sent_msg, "field 'tktSentMsg'", cls);
        eRSFragment.gstnStateName = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_supplier_state_name, "field 'gstnStateName'", cls);
        eRSFragment.gstnSuplierCode = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_supplier_Id, "field 'gstnSuplierCode'", cls);
        eRSFragment.sacNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.sac_id_supplier, "field 'sacNumber'", cls);
        eRSFragment.cgstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.cgst_amt, "field 'cgstAmt'", cls);
        eRSFragment.cgstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.cgst_rate, "field 'cgstRate'", cls);
        eRSFragment.sgstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.sgst_amt, "field 'sgstAmt'", cls);
        eRSFragment.sgstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.sgst_rate, "field 'sgstRate'", cls);
        eRSFragment.UgstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.ugst_amt, "field 'UgstAmt'", cls);
        eRSFragment.UgstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.ugst_rate, "field 'UgstRate'", cls);
        eRSFragment.igstAmt = (TextView) Utils.findRequiredViewAsType(view, R.id.igst_amt, "field 'igstAmt'", cls);
        eRSFragment.igstRate = (TextView) Utils.findRequiredViewAsType(view, R.id.igst_rate, "field 'igstRate'", cls);
        eRSFragment.address = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_address, "field 'address'", cls);
        eRSFragment.city = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_add_city, "field 'city'", cls);
        eRSFragment.name = (TextView) Utils.findRequiredViewAsType(view, R.id.name_id, "field 'name'", cls);
        eRSFragment.state = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_state, "field 'state'", cls);
        eRSFragment.pincode = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_pincode, "field 'pincode'", cls);
        eRSFragment.totalTax = (TextView) Utils.findRequiredViewAsType(view, R.id.total_tax, "field 'totalTax'", cls);
        eRSFragment.totalValuableTax = (TextView) Utils.findRequiredViewAsType(view, R.id.tax_val, "field 'totalValuableTax'", cls);
        eRSFragment.gstnRceiptId = (TextView) Utils.findRequiredViewAsType(view, R.id.gstn_recpt_id, "field 'gstnRceiptId'", cls);
        Class cls4 = RelativeLayout.class;
        eRSFragment.sgstLayoutId = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.sgst_layout_id, "field 'sgstLayoutId'", cls4);
        eRSFragment.cgstLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.cgst_layout_id, "field 'cgstLayout'", cls4);
        eRSFragment.ugstLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ugst_layout_id, "field 'ugstLayout'", cls4);
        eRSFragment.igstLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.igst_layout_id, "field 'igstLayout'", cls4);
        eRSFragment.allGstDtlLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.all_gst_detail_layout, "field 'allGstDtlLayout'", cls2);
        eRSFragment.gstnRecptInfo = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.gstn_recpt_item, "field 'gstnRecptInfo'", cls2);
        eRSFragment.recipient_view = Utils.findRequiredView(view, R.id.recipient_view, "field 'recipient_view'");
        eRSFragment.gstBreakupLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_gst_breakup, "field 'gstBreakupLayout'", cls2);
        eRSFragment.pre = (TextView) Utils.findRequiredViewAsType(view, R.id.pre, "field 'pre'", cls);
        eRSFragment.cnfCheckCetails = (TextView) Utils.findRequiredViewAsType(view, R.id.cnf_check_details, "field 'cnfCheckCetails'", cls);
        eRSFragment.cnfBtnLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.cnf_btn_layout, "field 'cnfBtnLayout'", cls2);
        eRSFragment.connectingPnrLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.connecting_pnr_layout, "field 'connectingPnrLayout'", cls2);
        eRSFragment.connectingPnr = (TextView) Utils.findRequiredViewAsType(view, R.id.connecting_pnr, "field 'connectingPnr'", cls);
        eRSFragment.lapType = (TextView) Utils.findRequiredViewAsType(view, R.id.lap_type, "field 'lapType'", cls);
        eRSFragment.conviencefee = (TextView) Utils.findRequiredViewAsType(view, R.id.convience_fee, "field 'conviencefee'", cls);
        eRSFragment.basefare = (TextView) Utils.findRequiredViewAsType(view, R.id.base_fare, "field 'basefare'", cls);
        eRSFragment.ersPageCenterAds = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.erspage_center_ads, "field 'ersPageCenterAds'", AdManagerAdView.class);
        eRSFragment.paymentmode = (TextView) Utils.findRequiredViewAsType(view, R.id.payment_mode, "field 'paymentmode'", cls);
        eRSFragment.payment_from = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.payment_from, "field 'payment_from'", cls4);
        eRSFragment.vigilanceMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_vigilanceMsg, "field 'vigilanceMsg'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.funda_duty_ll, "field 'funda_duty_ll' and method 'onClicfundadutymsg'");
        eRSFragment.funda_duty_ll = (RelativeLayout) Utils.castView(findRequiredView2, R.id.funda_duty_ll, "field 'funda_duty_ll'", cls4);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new g(eRSFragment));
        eRSFragment.funda_duty_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.funda_duty_detail_ll, "field 'funda_duty_detail_ll'", cls2);
        eRSFragment.funda_duty_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.funda_duty_msg, "field 'funda_duty_msg'", cls);
        Class cls5 = ImageView.class;
        eRSFragment.qr_code = (ImageView) Utils.findRequiredViewAsType(view, R.id.qr_code, "field 'qr_code'", cls5);
        eRSFragment.mpImageLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mp_image_layout, "field 'mpImageLayout'", cls2);
        eRSFragment.mpImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.mp_image, "field 'mpImage'", cls5);
        eRSFragment.mealdetail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mealdetail_ll, "field 'mealdetail_ll'", cls2);
        eRSFragment.rv_addmeal_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_addmeal_list, "field 'rv_addmeal_list'", cls3);
        eRSFragment.lvaddmeal = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.lv_addmeal, "field 'lvaddmeal'", cls3);
        eRSFragment.add_meal_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.add_meal_rl, "field 'add_meal_rl'", cls4);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_done_meal, "field 'tv_done_meal' and method 'onDoneAddMealClick'");
        eRSFragment.tv_done_meal = (TextView) Utils.castView(findRequiredView3, R.id.tv_done_meal, "field 'tv_done_meal'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new h(eRSFragment));
        eRSFragment.total_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_amount, "field 'total_amount'", cls);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_retroom, "field 'tv_tab_upcoming_journey_retroom' and method 'onRRRoomClick'");
        eRSFragment.tv_tab_upcoming_journey_retroom = (TextView) Utils.castView(findRequiredView4, R.id.tv_tab_upcoming_journey_retroom, "field 'tv_tab_upcoming_journey_retroom'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new i(eRSFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_hotel, "field 'tv_tab_upcoming_journey_hotel' and method 'onRRHotelClick'");
        eRSFragment.tv_tab_upcoming_journey_hotel = (TextView) Utils.castView(findRequiredView5, R.id.tv_tab_upcoming_journey_hotel, "field 'tv_tab_upcoming_journey_hotel'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new j(eRSFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_mot, "field 'tv_tab_upcoming_journey_mot' and method 'onMealClick'");
        eRSFragment.tv_tab_upcoming_journey_mot = (TextView) Utils.castView(findRequiredView6, R.id.tv_tab_upcoming_journey_mot, "field 'tv_tab_upcoming_journey_mot'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new k(eRSFragment));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.tv_cancellation_policy, "field 'tv_cancellation_policy' and method 'oncancellationpolicylick'");
        eRSFragment.tv_cancellation_policy = (TextView) Utils.castView(findRequiredView7, R.id.tv_cancellation_policy, "field 'tv_cancellation_policy'", cls);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new l(eRSFragment));
        eRSFragment.tain_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tain_detail_ll, "field 'tain_detail_ll'", cls2);
        eRSFragment.psgnCount = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.psgnCount, "field 'psgnCount'", cls2);
        eRSFragment.ticket_charge_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ticket_charge_rl, "field 'ticket_charge_rl'", cls4);
        eRSFragment.feedback_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.feedback_ll, "field 'feedback_ll'", cls2);
        eRSFragment.rv_train_detail = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.train_detail, "field 'rv_train_detail'", cls3);
        eRSFragment.psgnList_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.psgnList_lap2, "field 'psgnList_lap2'", cls3);
        eRSFragment.rl_psgnlisr = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_psgnlisr, "field 'rl_psgnlisr'", cls4);
        eRSFragment.meal_detail_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.meal_detail_lap2, "field 'meal_detail_lap2'", cls2);
        eRSFragment.rv_addmeal_list_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_addmeal_list_lap2, "field 'rv_addmeal_list_lap2'", cls3);
        eRSFragment.messages_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.messages_lap1, "field 'messages_lap1'", cls2);
        eRSFragment.lap1 = (TextView) Utils.findRequiredViewAsType(view, R.id.lap1, "field 'lap1'", cls);
        eRSFragment.messages_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.messages_lap2, "field 'messages_lap2'", cls2);
        eRSFragment.lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.lap2, "field 'lap2'", cls);
        eRSFragment.informationLayout_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.informationLayout_lap2, "field 'informationLayout_lap2'", cls2);
        eRSFragment.informationMsg_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.informationMsg_lap2, "field 'informationMsg_lap2'", cls);
        eRSFragment.tv_ers_msgs_lap2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ers_msgs_lap2, "field 'tv_ers_msgs_lap2'", cls);
        eRSFragment.attention_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.attention_msg, "field 'attention_msg'", cls);
        eRSFragment.attention_msg1 = (TextView) Utils.findRequiredViewAsType(view, R.id.attention_msg1, "field 'attention_msg1'", cls);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.tv_bus, "field 'tv_bus' and method 'onbusClick'");
        eRSFragment.tv_bus = (TextView) Utils.castView(findRequiredView8, R.id.tv_bus, "field 'tv_bus'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new m(eRSFragment));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.orderfood_Pantry_Car, "field 'orderfood_Pantry_Car' and method 'orderfoodPantryCarClick'");
        eRSFragment.orderfood_Pantry_Car = (TextView) Utils.castView(findRequiredView9, R.id.orderfood_Pantry_Car, "field 'orderfood_Pantry_Car'", cls);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new n(eRSFragment));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.send_mail_pdf, "field 'send_mail_pdf' and method 'onSendMailPdfClick'");
        eRSFragment.send_mail_pdf = (ImageView) Utils.castView(findRequiredView10, R.id.send_mail_pdf, "field 'send_mail_pdf'", cls5);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new a(eRSFragment));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.downloadpdf, "field 'downloadpdf' and method 'onDownloadPdfClick'");
        eRSFragment.downloadpdf = (ImageView) Utils.castView(findRequiredView11, R.id.downloadpdf, "field 'downloadpdf'", cls5);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new b(eRSFragment));
        View findRequiredView12 = Utils.findRequiredView(view, R.id.tv_tab_delhi_metro, "field 'tv_tab_delhi_metro' and method 'onClickDelhiMetroIcon'");
        eRSFragment.tv_tab_delhi_metro = (TextView) Utils.castView(findRequiredView12, R.id.tv_tab_delhi_metro, "field 'tv_tab_delhi_metro'", cls);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new c(eRSFragment));
        View findRequiredView13 = Utils.findRequiredView(view, R.id.save_ers, "method 'onSaveERSClick'");
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new d(eRSFragment));
        View findRequiredView14 = Utils.findRequiredView(view, R.id.shareButton, "method 'onShareButtonClick'");
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new e(eRSFragment));
    }

    public final void unbind() {
        ERSFragment eRSFragment = this.f4567a;
        if (eRSFragment != null) {
            this.f4567a = null;
            eRSFragment.trainNo = null;
            eRSFragment.trainName = null;
            eRSFragment.pnrNo = null;
            eRSFragment.fromStation = null;
            eRSFragment.toStation = null;
            eRSFragment.deptDate = null;
            eRSFragment.arvDate = null;
            eRSFragment.deptTime = null;
            eRSFragment.arvTime = null;
            eRSFragment.clsQtBoarding = null;
            eRSFragment.transactionId = null;
            eRSFragment.totalFare = null;
            eRSFragment.travelTime = null;
            eRSFragment.traveltime_ll = null;
            eRSFragment.psgnList = null;
            eRSFragment.replan = null;
            eRSFragment.travelInsurance = null;
            eRSFragment.informationLayout = null;
            eRSFragment.informationMsg = null;
            eRSFragment.ersMsg = null;
            eRSFragment.scrollView = null;
            eRSFragment.tktSentMsg = null;
            eRSFragment.gstnStateName = null;
            eRSFragment.gstnSuplierCode = null;
            eRSFragment.sacNumber = null;
            eRSFragment.cgstAmt = null;
            eRSFragment.cgstRate = null;
            eRSFragment.sgstAmt = null;
            eRSFragment.sgstRate = null;
            eRSFragment.UgstAmt = null;
            eRSFragment.UgstRate = null;
            eRSFragment.igstAmt = null;
            eRSFragment.igstRate = null;
            eRSFragment.address = null;
            eRSFragment.city = null;
            eRSFragment.name = null;
            eRSFragment.state = null;
            eRSFragment.pincode = null;
            eRSFragment.totalTax = null;
            eRSFragment.totalValuableTax = null;
            eRSFragment.gstnRceiptId = null;
            eRSFragment.sgstLayoutId = null;
            eRSFragment.cgstLayout = null;
            eRSFragment.ugstLayout = null;
            eRSFragment.igstLayout = null;
            eRSFragment.allGstDtlLayout = null;
            eRSFragment.gstnRecptInfo = null;
            eRSFragment.recipient_view = null;
            eRSFragment.gstBreakupLayout = null;
            eRSFragment.pre = null;
            eRSFragment.cnfCheckCetails = null;
            eRSFragment.cnfBtnLayout = null;
            eRSFragment.connectingPnrLayout = null;
            eRSFragment.connectingPnr = null;
            eRSFragment.lapType = null;
            eRSFragment.conviencefee = null;
            eRSFragment.basefare = null;
            eRSFragment.ersPageCenterAds = null;
            eRSFragment.paymentmode = null;
            eRSFragment.payment_from = null;
            eRSFragment.vigilanceMsg = null;
            eRSFragment.funda_duty_ll = null;
            eRSFragment.funda_duty_detail_ll = null;
            eRSFragment.funda_duty_msg = null;
            eRSFragment.qr_code = null;
            eRSFragment.mpImageLayout = null;
            eRSFragment.mpImage = null;
            eRSFragment.mealdetail_ll = null;
            eRSFragment.rv_addmeal_list = null;
            eRSFragment.lvaddmeal = null;
            eRSFragment.add_meal_rl = null;
            eRSFragment.tv_done_meal = null;
            eRSFragment.total_amount = null;
            eRSFragment.tv_tab_upcoming_journey_retroom = null;
            eRSFragment.tv_tab_upcoming_journey_hotel = null;
            eRSFragment.tv_tab_upcoming_journey_mot = null;
            eRSFragment.tv_cancellation_policy = null;
            eRSFragment.tain_detail_ll = null;
            eRSFragment.psgnCount = null;
            eRSFragment.ticket_charge_rl = null;
            eRSFragment.feedback_ll = null;
            eRSFragment.rv_train_detail = null;
            eRSFragment.psgnList_lap2 = null;
            eRSFragment.rl_psgnlisr = null;
            eRSFragment.meal_detail_lap2 = null;
            eRSFragment.rv_addmeal_list_lap2 = null;
            eRSFragment.messages_lap1 = null;
            eRSFragment.lap1 = null;
            eRSFragment.messages_lap2 = null;
            eRSFragment.lap2 = null;
            eRSFragment.informationLayout_lap2 = null;
            eRSFragment.informationMsg_lap2 = null;
            eRSFragment.tv_ers_msgs_lap2 = null;
            eRSFragment.attention_msg = null;
            eRSFragment.attention_msg1 = null;
            eRSFragment.tv_bus = null;
            eRSFragment.orderfood_Pantry_Car = null;
            eRSFragment.send_mail_pdf = null;
            eRSFragment.downloadpdf = null;
            eRSFragment.tv_tab_delhi_metro = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
