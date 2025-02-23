package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class LapAllTrainListFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public LapAllTrainListFragment f4723a;
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

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public a(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.trainNo(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public b(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.connectionJourneyLayoutClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public c(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.OnQuotaBackroundClick();
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public d(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.OnRoutMapBackroundClick();
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public e(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onFareBackUp(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public f(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.ContinueButtonClick();
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public g(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onGeneralClick(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public h(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onSeniorCitizenClick(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public i(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onTrainNoClick(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public j(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onTatkalClick(view);
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public k(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onPremiumTatkalClick(view);
        }
    }

    public class l extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public l(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onHandicapClick(view);
        }
    }

    public class m extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public m(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.onParliamentHouseClick(view);
        }
    }

    public class n extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public n(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.departure(view);
        }
    }

    public class o extends DebouncingOnClickListener {
        public final /* synthetic */ LapAllTrainListFragment a;

        public o(LapAllTrainListFragment lapAllTrainListFragment) {
            this.a = lapAllTrainListFragment;
        }

        public final void doClick(View view) {
            this.a.arrival(view);
        }
    }

    public LapAllTrainListFragment_ViewBinding(LapAllTrainListFragment lapAllTrainListFragment, View view) {
        this.f4723a = lapAllTrainListFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_general, "field 'tvGeneral' and method 'onGeneralClick'");
        Class cls = TextView.class;
        lapAllTrainListFragment.tvGeneral = (TextView) Utils.castView(findRequiredView, R.id.tv_general, "field 'tvGeneral'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new g(lapAllTrainListFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_senior_citizen, "field 'seniorCitizen' and method 'onSeniorCitizenClick'");
        lapAllTrainListFragment.seniorCitizen = (TextView) Utils.castView(findRequiredView2, R.id.tv_senior_citizen, "field 'seniorCitizen'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new h(lapAllTrainListFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_ladies, "field 'tvLadies' and method 'onTrainNoClick'");
        lapAllTrainListFragment.tvLadies = (TextView) Utils.castView(findRequiredView3, R.id.tv_ladies, "field 'tvLadies'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new i(lapAllTrainListFragment));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.tv_tatkal, "field 'tvTatkal' and method 'onTatkalClick'");
        lapAllTrainListFragment.tvTatkal = (TextView) Utils.castView(findRequiredView4, R.id.tv_tatkal, "field 'tvTatkal'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new j(lapAllTrainListFragment));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.tv_premium_tatkal, "field 'premiumTatkal' and method 'onPremiumTatkalClick'");
        lapAllTrainListFragment.premiumTatkal = (TextView) Utils.castView(findRequiredView5, R.id.tv_premium_tatkal, "field 'premiumTatkal'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new k(lapAllTrainListFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.tv_ph_handicap, "field 'phHandicap' and method 'onHandicapClick'");
        lapAllTrainListFragment.phHandicap = (TextView) Utils.castView(findRequiredView6, R.id.tv_ph_handicap, "field 'phHandicap'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new l(lapAllTrainListFragment));
        View findRequiredView7 = Utils.findRequiredView(view, R.id.tv_parliamentHouse, "field 'parliamentHouse' and method 'onParliamentHouseClick'");
        lapAllTrainListFragment.parliamentHouse = (TextView) Utils.castView(findRequiredView7, R.id.tv_parliamentHouse, "field 'parliamentHouse'", cls);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new m(lapAllTrainListFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.departure, "field 'departure' and method 'departure'");
        lapAllTrainListFragment.departure = (TextView) Utils.castView(findRequiredView8, R.id.departure, "field 'departure'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new n(lapAllTrainListFragment));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.arrival, "field 'arrival' and method 'arrival'");
        lapAllTrainListFragment.arrival = (TextView) Utils.castView(findRequiredView9, R.id.arrival, "field 'arrival'", cls);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new o(lapAllTrainListFragment));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.travel_time, "field 'travelTime' and method 'trainNo'");
        lapAllTrainListFragment.travelTime = (TextView) Utils.castView(findRequiredView10, R.id.travel_time, "field 'travelTime'", cls);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new a(lapAllTrainListFragment));
        lapAllTrainListFragment.alterTrainListShow = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alter_train_list_show, "field 'alterTrainListShow'", cls);
        Class cls2 = RecyclerView.class;
        lapAllTrainListFragment.trainList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.lv_train_list, "field 'trainList'", cls2);
        lapAllTrainListFragment.trainListAternate = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.lv_train_list_aternate, "field 'trainListAternate'", cls2);
        lapAllTrainListFragment.trainClassRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.train_class, "field 'trainClassRecyclerView'", cls2);
        lapAllTrainListFragment.availabilityView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.availability_list, "field 'availabilityView'", cls2);
        Class cls3 = RelativeLayout.class;
        lapAllTrainListFragment.sortby_bottom_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.sortby_bottom_ll, "field 'sortby_bottom_ll'", cls3);
        View findRequiredView11 = Utils.findRequiredView(view, R.id.pnr_input_bottom_rl, "field 'pnr_input_bottom_rl' and method 'connectionJourneyLayoutClick'");
        lapAllTrainListFragment.pnr_input_bottom_rl = (RelativeLayout) Utils.castView(findRequiredView11, R.id.pnr_input_bottom_rl, "field 'pnr_input_bottom_rl'", cls3);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new b(lapAllTrainListFragment));
        Class cls4 = LinearLayout.class;
        lapAllTrainListFragment.sortby_bottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.sortby_bottom, "field 'sortby_bottom'", cls4);
        lapAllTrainListFragment.filter_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.filter_ll, "field 'filter_ll'", cls3);
        lapAllTrainListFragment.filter_ll_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.filter_ll_ll, "field 'filter_ll_ll'", cls4);
        lapAllTrainListFragment.filter_ll_scroll = (ScrollView) Utils.findRequiredViewAsType(view, R.id.filter_ll_scroll, "field 'filter_ll_scroll'", ScrollView.class);
        View findRequiredView12 = Utils.findRequiredView(view, R.id.quota_bottom_ll, "field 'quota_bottom_ll' and method 'OnQuotaBackroundClick'");
        lapAllTrainListFragment.quota_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView12, R.id.quota_bottom_ll, "field 'quota_bottom_ll'", cls3);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new c(lapAllTrainListFragment));
        lapAllTrainListFragment.quota_bottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.quota_bottom, "field 'quota_bottom'", cls4);
        lapAllTrainListFragment.bottomFareAndButtonLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.bottom, "field 'bottomFareAndButtonLayout'", cls4);
        Class cls5 = ImageView.class;
        lapAllTrainListFragment.filter = (ImageView) Utils.findRequiredViewAsType(view, R.id.filter, "field 'filter'", cls5);
        View findRequiredView13 = Utils.findRequiredView(view, R.id.route_rl, "field 'route_rl' and method 'OnRoutMapBackroundClick'");
        lapAllTrainListFragment.route_rl = (RelativeLayout) Utils.castView(findRequiredView13, R.id.route_rl, "field 'route_rl'", cls3);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new d(lapAllTrainListFragment));
        lapAllTrainListFragment.goTopassangerDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.passanger_detail, "field 'goTopassangerDetail'", cls);
        lapAllTrainListFragment.totalFare = (TextView) Utils.findRequiredViewAsType(view, R.id.total_fare, "field 'totalFare'", cls);
        lapAllTrainListFragment.fare_backup = (TextView) Utils.findRequiredViewAsType(view, R.id.fare_backup, "field 'fare_backup'", cls);
        lapAllTrainListFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        lapAllTrainListFragment.trainNo = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_train_no, "field 'trainNo'", cls);
        View findRequiredView14 = Utils.findRequiredView(view, R.id.total_fare_ll, "field 'totalFareLl' and method 'onFareBackUp'");
        lapAllTrainListFragment.totalFareLl = (LinearLayout) Utils.castView(findRequiredView14, R.id.total_fare_ll, "field 'totalFareLl'", cls4);
        this.n = findRequiredView14;
        findRequiredView14.setOnClickListener(new e(lapAllTrainListFragment));
        lapAllTrainListFragment.passangerDetailLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.passanger_detail_ll, "field 'passangerDetailLl'", cls4);
        Class cls6 = CheckBox.class;
        lapAllTrainListFragment.ch_rajdhani = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_rajdhani, "field 'ch_rajdhani'", cls6);
        lapAllTrainListFragment.ch_shatabdi = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_shatabdi, "field 'ch_shatabdi'", cls6);
        lapAllTrainListFragment.ch_duranto = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_duranto, "field 'ch_duranto'", cls6);
        lapAllTrainListFragment.ch_special_train = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_special_train, "field 'ch_special_train'", cls6);
        lapAllTrainListFragment.ch_special_tatkal = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_special_tatkal, "field 'ch_special_tatkal'", cls6);
        lapAllTrainListFragment.ch_garibrath = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_garibrath, "field 'ch_garibrath'", cls6);
        lapAllTrainListFragment.ch_suvidha_train = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_suvidha_train, "field 'ch_suvidha_train'", cls6);
        lapAllTrainListFragment.ch_janshatabdi = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_janshatabdi, "field 'ch_janshatabdi'", cls6);
        lapAllTrainListFragment.ch_yuva_express = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_yuva_express, "field 'ch_yuva_express'", cls6);
        lapAllTrainListFragment.ch_others = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_others, "field 'ch_others'", cls6);
        lapAllTrainListFragment.rajdhani_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.rajdhani_img, "field 'rajdhani_img'", cls5);
        lapAllTrainListFragment.shatabdi_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.shatabdi_img, "field 'shatabdi_img'", cls5);
        lapAllTrainListFragment.duranto_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.duranto_img, "field 'duranto_img'", cls5);
        lapAllTrainListFragment.special_trian_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.special_trian_img, "field 'special_trian_img'", cls5);
        lapAllTrainListFragment.special_tatkal_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.special_tatkal_img, "field 'special_tatkal_img'", cls5);
        lapAllTrainListFragment.garibrath_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.garibrath_img, "field 'garibrath_img'", cls5);
        lapAllTrainListFragment.suvidha_train_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.suvidha_train_img, "field 'suvidha_train_img'", cls5);
        lapAllTrainListFragment.janshatabdi_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.janshatabdi_img, "field 'janshatabdi_img'", cls5);
        lapAllTrainListFragment.yuva_express_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.yuva_express_img, "field 'yuva_express_img'", cls5);
        lapAllTrainListFragment.class_1A = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_1A, "field 'class_1A'", cls6);
        lapAllTrainListFragment.class_2A = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_2A, "field 'class_2A'", cls6);
        lapAllTrainListFragment.class_3A = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_3A, "field 'class_3A'", cls6);
        lapAllTrainListFragment.class_EC = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_EC, "field 'class_EC'", cls6);
        lapAllTrainListFragment.class_CC = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_CC, "field 'class_CC'", cls6);
        lapAllTrainListFragment.class_SL = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_SL, "field 'class_SL'", cls6);
        lapAllTrainListFragment.class_2S = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_2S, "field 'class_2S'", cls6);
        lapAllTrainListFragment.class_AC = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_AC, "field 'class_AC'", cls6);
        lapAllTrainListFragment.class_FC = (CheckBox) Utils.findRequiredViewAsType(view, R.id.class_FC, "field 'class_FC'", cls6);
        lapAllTrainListFragment.class_1A_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_1A_ll, "field 'class_1A_ll'", cls4);
        lapAllTrainListFragment.class_2A_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_2A_ll, "field 'class_2A_ll'", cls4);
        lapAllTrainListFragment.class_3A_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_3A_ll, "field 'class_3A_ll'", cls4);
        lapAllTrainListFragment.class_EC_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_EC_ll, "field 'class_EC_ll'", cls4);
        lapAllTrainListFragment.class_CC_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_CC_ll, "field 'class_CC_ll'", cls4);
        lapAllTrainListFragment.class_SL_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_SL_ll, "field 'class_SL_ll'", cls4);
        lapAllTrainListFragment.class_2S_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_2S_ll, "field 'class_2S_ll'", cls4);
        lapAllTrainListFragment.class_AC_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_AC_ll, "field 'class_AC_ll'", cls4);
        lapAllTrainListFragment.class_FC_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.class_FC_ll, "field 'class_FC_ll'", cls4);
        lapAllTrainListFragment.rajdhani_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rajdhani_rl, "field 'rajdhani_rl'", cls3);
        lapAllTrainListFragment.shatabdi_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.shatabdi_rl, "field 'shatabdi_rl'", cls3);
        lapAllTrainListFragment.duronto_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.duronto_rl, "field 'duronto_rl'", cls3);
        lapAllTrainListFragment.special_trian_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.special_trian_rl, "field 'special_trian_rl'", cls3);
        lapAllTrainListFragment.special_tatkal_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.special_tatkal_rl, "field 'special_tatkal_rl'", cls3);
        lapAllTrainListFragment.garibrath_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.garibrath_rl, "field 'garibrath_rl'", cls3);
        lapAllTrainListFragment.suvidha_train_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.suvidha_train_rl, "field 'suvidha_train_rl'", cls3);
        lapAllTrainListFragment.janshatabdi_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.janshatabdi_rl, "field 'janshatabdi_rl'", cls3);
        lapAllTrainListFragment.yuva_express_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.yuva_express_rl, "field 'yuva_express_rl'", cls3);
        lapAllTrainListFragment.ch_earlyMorning = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_earlyMorning, "field 'ch_earlyMorning'", cls6);
        lapAllTrainListFragment.ch_morning = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_morning, "field 'ch_morning'", cls6);
        lapAllTrainListFragment.ch_midDay = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_midDay, "field 'ch_midDay'", cls6);
        lapAllTrainListFragment.ch_night = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ch_night, "field 'ch_night'", cls6);
        lapAllTrainListFragment.others_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.others_rl, "field 'others_rl'", cls3);
        lapAllTrainListFragment.hide_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.hide_ll, "field 'hide_ll'", cls3);
        lapAllTrainListFragment.earlyMorning_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.earlyMorning_ll, "field 'earlyMorning_ll'", cls4);
        lapAllTrainListFragment.morning_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.morning_ll, "field 'morning_ll'", cls4);
        lapAllTrainListFragment.midDay_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.midDay_ll, "field 'midDay_ll'", cls4);
        lapAllTrainListFragment.night_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.night_ll, "field 'night_ll'", cls4);
        lapAllTrainListFragment.Allclass_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.Allclass_ll, "field 'Allclass_ll'", cls4);
        lapAllTrainListFragment.cbclass = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_class, "field 'cbclass'", cls6);
        Class cls7 = AdManagerAdView.class;
        lapAllTrainListFragment.publisherAdViewtop = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.publisherAdView, "field 'publisherAdViewtop'", cls7);
        lapAllTrainListFragment.publisherAdViewcenter = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.publisherAdView_center, "field 'publisherAdViewcenter'", cls7);
        lapAllTrainListFragment.publisherAdViewbottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.publisherAdView_bottom, "field 'publisherAdViewbottom'", cls7);
        lapAllTrainListFragment.train_list_filter = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.train_list_filter, "field 'train_list_filter'", cls7);
        lapAllTrainListFragment.publisherAdViewbottomrout_map = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.rout_map, "field 'publisherAdViewbottomrout_map'", cls7);
        Class cls8 = EditText.class;
        lapAllTrainListFragment.inputPnr = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_pnr, "field 'inputPnr'", cls8);
        lapAllTrainListFragment.otp = (EditText) Utils.findRequiredViewAsType(view, R.id.tv_otp, "field 'otp'", cls8);
        lapAllTrainListFragment.otpLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_otp, "field 'otpLayout'", cls4);
        lapAllTrainListFragment.status = (TextView) Utils.findRequiredViewAsType(view, R.id.status, "field 'status'", cls);
        lapAllTrainListFragment.submit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_submit_btn, "field 'submit'", cls);
        lapAllTrainListFragment.tv_alter_train_list_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_alter_train_list_msg, "field 'tv_alter_train_list_msg'", cls);
        lapAllTrainListFragment.departureFrom = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_departure_from, "field 'departureFrom'", cls);
        lapAllTrainListFragment.trainTypeHeading = (TextView) Utils.findRequiredViewAsType(view, R.id.train_type_heading, "field 'trainTypeHeading'", cls);
        lapAllTrainListFragment.quotaRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_quota, "field 'quotaRecyclerView'", cls2);
        View findRequiredView15 = Utils.findRequiredView(view, R.id.tv_continue, "field 'tv_continue' and method 'ContinueButtonClick'");
        lapAllTrainListFragment.tv_continue = (TextView) Utils.castView(findRequiredView15, R.id.tv_continue, "field 'tv_continue'", cls);
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new f(lapAllTrainListFragment));
        lapAllTrainListFragment.trainSeatAvailabilityLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_train_seat_availability_layout, "field 'trainSeatAvailabilityLayout'", cls4);
        lapAllTrainListFragment.mainLayoutSortAndFilter = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.main_layout, "field 'mainLayoutSortAndFilter'", cls3);
    }

    public final void unbind() {
        LapAllTrainListFragment lapAllTrainListFragment = this.f4723a;
        if (lapAllTrainListFragment != null) {
            this.f4723a = null;
            lapAllTrainListFragment.tvGeneral = null;
            lapAllTrainListFragment.seniorCitizen = null;
            lapAllTrainListFragment.tvLadies = null;
            lapAllTrainListFragment.tvTatkal = null;
            lapAllTrainListFragment.premiumTatkal = null;
            lapAllTrainListFragment.phHandicap = null;
            lapAllTrainListFragment.parliamentHouse = null;
            lapAllTrainListFragment.departure = null;
            lapAllTrainListFragment.arrival = null;
            lapAllTrainListFragment.travelTime = null;
            lapAllTrainListFragment.alterTrainListShow = null;
            lapAllTrainListFragment.trainList = null;
            lapAllTrainListFragment.trainListAternate = null;
            lapAllTrainListFragment.trainClassRecyclerView = null;
            lapAllTrainListFragment.availabilityView = null;
            lapAllTrainListFragment.sortby_bottom_ll = null;
            lapAllTrainListFragment.pnr_input_bottom_rl = null;
            lapAllTrainListFragment.sortby_bottom = null;
            lapAllTrainListFragment.filter_ll = null;
            lapAllTrainListFragment.filter_ll_ll = null;
            lapAllTrainListFragment.filter_ll_scroll = null;
            lapAllTrainListFragment.quota_bottom_ll = null;
            lapAllTrainListFragment.quota_bottom = null;
            lapAllTrainListFragment.bottomFareAndButtonLayout = null;
            lapAllTrainListFragment.filter = null;
            lapAllTrainListFragment.route_rl = null;
            lapAllTrainListFragment.goTopassangerDetail = null;
            lapAllTrainListFragment.totalFare = null;
            lapAllTrainListFragment.fare_backup = null;
            lapAllTrainListFragment.trainName = null;
            lapAllTrainListFragment.trainNo = null;
            lapAllTrainListFragment.totalFareLl = null;
            lapAllTrainListFragment.passangerDetailLl = null;
            lapAllTrainListFragment.ch_rajdhani = null;
            lapAllTrainListFragment.ch_shatabdi = null;
            lapAllTrainListFragment.ch_duranto = null;
            lapAllTrainListFragment.ch_special_train = null;
            lapAllTrainListFragment.ch_special_tatkal = null;
            lapAllTrainListFragment.ch_garibrath = null;
            lapAllTrainListFragment.ch_suvidha_train = null;
            lapAllTrainListFragment.ch_janshatabdi = null;
            lapAllTrainListFragment.ch_yuva_express = null;
            lapAllTrainListFragment.ch_others = null;
            lapAllTrainListFragment.rajdhani_img = null;
            lapAllTrainListFragment.shatabdi_img = null;
            lapAllTrainListFragment.duranto_img = null;
            lapAllTrainListFragment.special_trian_img = null;
            lapAllTrainListFragment.special_tatkal_img = null;
            lapAllTrainListFragment.garibrath_img = null;
            lapAllTrainListFragment.suvidha_train_img = null;
            lapAllTrainListFragment.janshatabdi_img = null;
            lapAllTrainListFragment.yuva_express_img = null;
            lapAllTrainListFragment.class_1A = null;
            lapAllTrainListFragment.class_2A = null;
            lapAllTrainListFragment.class_3A = null;
            lapAllTrainListFragment.class_EC = null;
            lapAllTrainListFragment.class_CC = null;
            lapAllTrainListFragment.class_SL = null;
            lapAllTrainListFragment.class_2S = null;
            lapAllTrainListFragment.class_AC = null;
            lapAllTrainListFragment.class_FC = null;
            lapAllTrainListFragment.class_1A_ll = null;
            lapAllTrainListFragment.class_2A_ll = null;
            lapAllTrainListFragment.class_3A_ll = null;
            lapAllTrainListFragment.class_EC_ll = null;
            lapAllTrainListFragment.class_CC_ll = null;
            lapAllTrainListFragment.class_SL_ll = null;
            lapAllTrainListFragment.class_2S_ll = null;
            lapAllTrainListFragment.class_AC_ll = null;
            lapAllTrainListFragment.class_FC_ll = null;
            lapAllTrainListFragment.rajdhani_rl = null;
            lapAllTrainListFragment.shatabdi_rl = null;
            lapAllTrainListFragment.duronto_rl = null;
            lapAllTrainListFragment.special_trian_rl = null;
            lapAllTrainListFragment.special_tatkal_rl = null;
            lapAllTrainListFragment.garibrath_rl = null;
            lapAllTrainListFragment.suvidha_train_rl = null;
            lapAllTrainListFragment.janshatabdi_rl = null;
            lapAllTrainListFragment.yuva_express_rl = null;
            lapAllTrainListFragment.ch_earlyMorning = null;
            lapAllTrainListFragment.ch_morning = null;
            lapAllTrainListFragment.ch_midDay = null;
            lapAllTrainListFragment.ch_night = null;
            lapAllTrainListFragment.others_rl = null;
            lapAllTrainListFragment.hide_ll = null;
            lapAllTrainListFragment.earlyMorning_ll = null;
            lapAllTrainListFragment.morning_ll = null;
            lapAllTrainListFragment.midDay_ll = null;
            lapAllTrainListFragment.night_ll = null;
            lapAllTrainListFragment.Allclass_ll = null;
            lapAllTrainListFragment.cbclass = null;
            lapAllTrainListFragment.publisherAdViewtop = null;
            lapAllTrainListFragment.publisherAdViewcenter = null;
            lapAllTrainListFragment.publisherAdViewbottom = null;
            lapAllTrainListFragment.train_list_filter = null;
            lapAllTrainListFragment.publisherAdViewbottomrout_map = null;
            lapAllTrainListFragment.inputPnr = null;
            lapAllTrainListFragment.otp = null;
            lapAllTrainListFragment.otpLayout = null;
            lapAllTrainListFragment.status = null;
            lapAllTrainListFragment.submit = null;
            lapAllTrainListFragment.tv_alter_train_list_msg = null;
            lapAllTrainListFragment.departureFrom = null;
            lapAllTrainListFragment.trainTypeHeading = null;
            lapAllTrainListFragment.quotaRecyclerView = null;
            lapAllTrainListFragment.tv_continue = null;
            lapAllTrainListFragment.trainSeatAvailabilityLayout = null;
            lapAllTrainListFragment.mainLayoutSortAndFilter = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
