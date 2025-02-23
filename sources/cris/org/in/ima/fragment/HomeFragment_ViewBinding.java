package cris.org.in.ima.fragment;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class HomeFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public HomeFragment f4654a;
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

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public a(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.ret_room(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public b(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.irctc_channel(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public c(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.bookMeal(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public d(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.flights(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public e(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.irctTourism(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public f(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.specialtrainListClick();
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public g(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.bus(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public h(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.hotel(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public i(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.myJourney(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public j(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.askDisha(view);
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public k(HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        public final void doClick(View view) {
            this.a.amazon_daily_deals(view);
        }
    }

    public HomeFragment_ViewBinding(HomeFragment homeFragment, View view) {
        this.f4654a = homeFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.book_meal_ll, "field 'bookMeal' and method 'bookMeal'");
        Class cls = LinearLayout.class;
        homeFragment.bookMeal = (LinearLayout) Utils.castView(findRequiredView, R.id.book_meal_ll, "field 'bookMeal'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new c(homeFragment));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.flights_ll, "field 'flights' and method 'flights'");
        homeFragment.flights = (LinearLayout) Utils.castView(findRequiredView2, R.id.flights_ll, "field 'flights'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new d(homeFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.irctTourism_ll, "field 'irctTourism' and method 'irctTourism'");
        homeFragment.irctTourism = (LinearLayout) Utils.castView(findRequiredView3, R.id.irctTourism_ll, "field 'irctTourism'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new e(homeFragment));
        Class cls2 = RelativeLayout.class;
        homeFragment.lastTransationDtail = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.last_transation_detail_ll, "field 'lastTransationDtail'", cls2);
        Class cls3 = TextView.class;
        homeFragment.viewTkt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_view_last_transation_tkt, "field 'viewTkt'", cls3);
        homeFragment.lastLoginDetail = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.last_login_detail_ll, "field 'lastLoginDetail'", cls2);
        homeFragment.loginDate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_login_date, "field 'loginDate'", cls3);
        homeFragment.loginTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_login_time, "field 'loginTime'", cls3);
        Class cls4 = AdManagerAdView.class;
        homeFragment.dashboard_ads = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.dashboard_ads, "field 'dashboard_ads'", cls4);
        homeFragment.last_txn_bottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.last_txn_bottom, "field 'last_txn_bottom'", cls4);
        homeFragment.last_txn_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.last_txn_layout, "field 'last_txn_layout'", cls);
        homeFragment.last_txn_ll = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.last_txn_ll, "field 'last_txn_ll'", cls2);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.specialtrain_list_rl, "field 'specialtrain_list_rl' and method 'specialtrainListClick'");
        homeFragment.specialtrain_list_rl = (RelativeLayout) Utils.castView(findRequiredView4, R.id.specialtrain_list_rl, "field 'specialtrain_list_rl'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new f(homeFragment));
        Class cls5 = RecyclerView.class;
        homeFragment.rv_specialtrainlist = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_specialtrainlist, "field 'rv_specialtrainlist'", cls5);
        homeFragment.rv_infomation = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_information, "field 'rv_infomation'", cls5);
        homeFragment.informationHeading = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_information_heading, "field 'informationHeading'", cls3);
        homeFragment.information_view = Utils.findRequiredView(view, R.id.rv_information_view, "field 'information_view'");
        homeFragment.ll_tab_dashboard = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tab_dashboard, "field 'll_tab_dashboard'", cls);
        homeFragment.attention_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.attention_msg, "field 'attention_msg'", cls3);
        View findRequiredView5 = Utils.findRequiredView(view, R.id.ll_bus, "field 'll_bus' and method 'bus'");
        homeFragment.ll_bus = (LinearLayout) Utils.castView(findRequiredView5, R.id.ll_bus, "field 'll_bus'", cls);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new g(homeFragment));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.ll_hotel, "field 'll_hotel' and method 'hotel'");
        homeFragment.ll_hotel = (LinearLayout) Utils.castView(findRequiredView6, R.id.ll_hotel, "field 'll_hotel'", cls);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new h(homeFragment));
        homeFragment.transactionNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_transation_number, "field 'transactionNumber'", cls3);
        homeFragment.bkgStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bkg_status, "field 'bkgStatus'", cls3);
        homeFragment.lastTransationTimeStamp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timestamp, "field 'lastTransationTimeStamp'", cls3);
        homeFragment.content_Cube_Ad = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content_Cube_Ad, "field 'content_Cube_Ad'", cls);
        homeFragment.content_Cube_WebView = (WebView) Utils.findRequiredViewAsType(view, R.id.content_Cube_WebView, "field 'content_Cube_WebView'", WebView.class);
        homeFragment.amazon_recharge_layout_rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.amazon_recharge_layout_rv, "field 'amazon_recharge_layout_rv'", cls5);
        View findRequiredView7 = Utils.findRequiredView(view, R.id.my_journey_ll, "method 'myJourney'");
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new i(homeFragment));
        View findRequiredView8 = Utils.findRequiredView(view, R.id.askdisha_ll, "method 'askDisha'");
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new j(homeFragment));
        View findRequiredView9 = Utils.findRequiredView(view, R.id.amazon_daily_deals, "method 'amazon_daily_deals'");
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new k(homeFragment));
        View findRequiredView10 = Utils.findRequiredView(view, R.id.ret_room, "method 'ret_room'");
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new a(homeFragment));
        View findRequiredView11 = Utils.findRequiredView(view, R.id.irctc_channel, "method 'irctc_channel'");
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new b(homeFragment));
    }

    public final void unbind() {
        HomeFragment homeFragment = this.f4654a;
        if (homeFragment != null) {
            this.f4654a = null;
            homeFragment.bookMeal = null;
            homeFragment.flights = null;
            homeFragment.irctTourism = null;
            homeFragment.lastTransationDtail = null;
            homeFragment.viewTkt = null;
            homeFragment.lastLoginDetail = null;
            homeFragment.loginDate = null;
            homeFragment.loginTime = null;
            homeFragment.dashboard_ads = null;
            homeFragment.last_txn_bottom = null;
            homeFragment.last_txn_layout = null;
            homeFragment.last_txn_ll = null;
            homeFragment.specialtrain_list_rl = null;
            homeFragment.rv_specialtrainlist = null;
            homeFragment.rv_infomation = null;
            homeFragment.informationHeading = null;
            homeFragment.information_view = null;
            homeFragment.ll_tab_dashboard = null;
            homeFragment.attention_msg = null;
            homeFragment.ll_bus = null;
            homeFragment.ll_hotel = null;
            homeFragment.transactionNumber = null;
            homeFragment.bkgStatus = null;
            homeFragment.lastTransationTimeStamp = null;
            homeFragment.content_Cube_Ad = null;
            homeFragment.content_Cube_WebView = null;
            homeFragment.amazon_recharge_layout_rv = null;
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
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
