package cris.org.in.ima.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.DashboardPremiumPartnersAdapter;
import cris.org.in.ima.adaptors.InformationMsgAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.PremiumPartnerImageModel;
import cris.org.in.ima.payment.CashOnDeliveryActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.InformationMessageDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class HomeFragment extends Fragment {
    public static ImageView a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4649a;

    /* renamed from: a  reason: collision with other field name */
    public final b f4650a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final c f4651a = new c();

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f4652a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4653a = true;
    @BindView(2131361939)
    RecyclerView amazon_recharge_layout_rv;
    @BindView(2131361998)
    TextView attention_msg;
    @BindView(2131364318)
    TextView bkgStatus;
    @BindView(2131362051)
    LinearLayout bookMeal;
    @BindView(2131362309)
    LinearLayout content_Cube_Ad;
    @BindView(2131362310)
    WebView content_Cube_WebView;
    @BindView(2131362368)
    AdManagerAdView dashboard_ads;
    @BindView(2131362687)
    LinearLayout flights;
    @BindView(2131364436)
    TextView informationHeading;
    @BindView(2131363819)
    View information_view;
    @BindView(2131362861)
    LinearLayout irctTourism;
    @BindView(2131362944)
    RelativeLayout lastLoginDetail;
    @BindView(2131362946)
    RelativeLayout lastTransationDtail;
    @BindView(2131364661)
    TextView lastTransationTimeStamp;
    @BindView(2131362947)
    AdManagerAdView last_txn_bottom;
    @BindView(2131362948)
    LinearLayout last_txn_layout;
    @BindView(2131362949)
    RelativeLayout last_txn_ll;
    @BindView(2131363010)
    LinearLayout ll_bus;
    @BindView(2131363036)
    LinearLayout ll_hotel;
    @BindView(2131363070)
    LinearLayout ll_tab_dashboard;
    @BindView(2131364468)
    TextView loginDate;
    @BindView(2131364470)
    TextView loginTime;
    @BindView(2131363818)
    RecyclerView rv_infomation;
    @BindView(2131363834)
    RecyclerView rv_specialtrainlist;
    @BindView(2131363996)
    RelativeLayout specialtrain_list_rl;
    @SuppressLint({"NonConstantResourceId"})
    @BindView(2131364694)
    TextView transactionNumber;
    @BindView(2131364724)
    TextView viewTkt;

    public class b implements InformationMsgAdapter.InformationMsgListener {
        public b() {
        }

        public final void onItemClick(InformationMessageDTO informationMessageDTO) {
            HomeFragment homeFragment = HomeFragment.this;
            if (informationMessageDTO != null && informationMessageDTO.getUrl() != null && informationMessageDTO.getUrl().contains("http")) {
                try {
                    String url = informationMessageDTO.getUrl();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(url));
                    homeFragment.startActivity(intent);
                } catch (Exception e) {
                    ImageView imageView = HomeFragment.a;
                    e.getMessage();
                    C0535I5.t0(homeFragment.getContext(), homeFragment.getString(R.string.unable_to_open_link));
                }
            }
        }
    }

    public class c implements DashboardPremiumPartnersAdapter.PrimuimPartner {
        public c() {
        }

        public final void onItemClick(PremiumPartnerImageModel premiumPartnerImageModel) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(premiumPartnerImageModel.e));
            HomeFragment.this.startActivity(intent);
        }
    }

    static {
        C1354qp.R(HomeFragment.class);
    }

    @OnClick({2131361938})
    public void amazon_daily_deals(View view) {
        try {
            this.f4649a.startActivity(Intent.parseUri("https://contents.irctc.co.in/en/andMobSale.html", 1));
        } catch (Exception unused) {
        }
    }

    @OnClick({2131361995})
    public void askDisha(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://askdisha.irctc.co.in/eticket/#app")));
        } catch (Exception unused) {
        }
    }

    @OnClick({2131362051})
    public void bookMeal(View view) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.ecatering.irctc.co.in/?utm_source=irctc&utm_medium=android_app&utm_campaign=dashboard")));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @OnClick({2131363010})
    public void bus(View view) {
        try {
            Intent parseUri = Intent.parseUri("https://www.bus.irctc.co.in/home?utm_source=dashboard", 1);
            Intent launchIntentForPackage = this.f4649a.getPackageManager().getLaunchIntentForPackage("home?utm_source=dashboard");
            if (launchIntentForPackage != null) {
                this.f4649a.startActivity(launchIntentForPackage);
            } else {
                this.f4649a.startActivity(parseUri);
            }
        } catch (Exception unused) {
            C0535I5.t0(this.f4649a, getString(R.string.error_opening_bus_app));
        }
    }

    public final void f() {
        if (this.lastLoginDetail.getVisibility() == 0) {
            this.lastLoginDetail.setVisibility(8);
        }
        if (this.lastTransationDtail.getVisibility() == 0) {
            this.lastTransationDtail.setVisibility(8);
        }
    }

    @OnClick({2131362687})
    public void flights(View view) {
        try {
            this.f4649a.startActivity(Intent.parseUri("https://www.air.irctc.co.in/?utm_source=dashboard", 1));
        } catch (Exception unused) {
            C0535I5.t0(this.f4649a, getString(R.string.error_opening_air_app));
        }
    }

    public final void g(String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        SharedPreferences.Editor edit = getContext().getSharedPreferences("Settings", 0).edit();
        edit.putString("My_Lang", str);
        edit.apply();
        IrctcImaApplication.e = str;
    }

    @OnClick({2131363036})
    public void hotel(View view) {
        try {
            Intent parseUri = Intent.parseUri("https://www.hotels.irctc.co.in/hotel?utm_source=dashboard", 1);
            Intent launchIntentForPackage = this.f4649a.getPackageManager().getLaunchIntentForPackage("com.irctc.hotel");
            if (launchIntentForPackage != null) {
                this.f4649a.startActivity(launchIntentForPackage);
            } else {
                this.f4649a.startActivity(parseUri);
            }
        } catch (Exception unused) {
            C0535I5.t0(this.f4649a, getString(R.string.error_opening_hotel_app));
        }
    }

    @OnClick({2131362861})
    public void irctTourism(View view) {
        try {
            this.f4649a.startActivity(Intent.parseUri("https://www.irctctourism.com/?utm_source=dashboard", 1));
        } catch (Exception unused) {
            C0535I5.t0(this.f4649a, getString(R.string.error_opening_tourism_app));
        }
    }

    @OnClick({2131362862})
    public void irctc_channel(View view) {
        try {
            this.f4649a.startActivity(Intent.parseUri("https://www.youtube.com/c/IRCTCOFFICIAL", 1));
        } catch (Exception unused) {
        }
    }

    @OnClick({2131363286})
    public void myJourney(View view) {
        HomeActivity.n(this.f4649a, new TrainDashboardFragment(), C1218kf.TRAIN.a(), Boolean.TRUE, Boolean.FALSE);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.train_ticketing, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        this.f4649a = getContext();
        getFragmentManager();
        this.lastLoginDetail.setOnClickListener(new C0757Ye(this));
        this.lastTransationDtail.setOnClickListener(new C0768Ze(this));
        a = (ImageView) getActivity().findViewById(R.id.languageChange);
        CashOnDeliveryActivity cashOnDeliveryActivity = HomeActivity.f4183a;
        a.setOnClickListener(new a());
        AlertDialog alertDialog = C0535I5.f3619a;
        this.attention_msg.setVisibility(8);
        this.content_Cube_Ad.getViewTreeObserver().addOnGlobalLayoutListener(new S(this));
        this.content_Cube_WebView.getSettings().setJavaScriptEnabled(true);
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.dashboard_ads, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.last_txn_bottom, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.last_txn_bottom, googleAdParamDTO);
        String str = C0535I5.f3635d;
        if (str != null && str.length() > 0) {
            try {
                String[] split = String.valueOf(C0535I5.f3635d).split(" ", 2);
                Date parse = new SimpleDateFormat("HH:mm:ss").parse(split[1]);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
                this.loginDate.setText(split[0]);
                this.loginTime.setText(String.valueOf(simpleDateFormat.format(parse)));
                if (this.f4653a) {
                    this.lastLoginDetail.setVisibility(8);
                }
                this.f4653a = false;
            } catch (ParseException e) {
                e.getMessage();
            }
        }
        ArrayList arrayList = this.f4652a;
        arrayList.clear();
        Iterator<InformationMessageDTO> it = C1450w1.f7010a.iterator();
        while (it.hasNext()) {
            InformationMessageDTO next = it.next();
            if (next.getParamName().equalsIgnoreCase("DASHBOARD")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            this.informationHeading.setVisibility(8);
            this.rv_infomation.setVisibility(8);
            this.information_view.setVisibility(8);
        }
        this.rv_infomation.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.rv_infomation.setAdapter(new InformationMsgAdapter(this.f4649a, arrayList, this.f4650a));
        HomeActivity.z();
        HomeActivity.d.setVisibility(8);
        HomeActivity.o();
        HomeActivity.x();
        HomeActivity.J();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new PremiumPartnerImageModel(getString(R.string.rechargeBills), String.valueOf(R.drawable.amazon_recharge), "https://contents.irctc.co.in/en/andMobBill.html"));
        arrayList2.add(new PremiumPartnerImageModel(getString(R.string.grocery), String.valueOf(R.drawable.amazon_grocery), "https://contents.irctc.co.in/en/andMobGrocery.html"));
        arrayList2.add(new PremiumPartnerImageModel(getString(R.string.kitchen), String.valueOf(R.drawable.amazon_kitchen), "https://contents.irctc.co.in/en/andMobKitchen.html"));
        arrayList2.add(new PremiumPartnerImageModel(getString(R.string.apparel), String.valueOf(R.drawable.amazon_apparel), "https://contents.irctc.co.in/en/andMobApparel.html"));
        arrayList2.add(new PremiumPartnerImageModel(getString(R.string.yatri), String.valueOf(R.drawable.amazon_yatri), "https://contents.irctc.co.in/en/andMobYatrimall.html"));
        this.amazon_recharge_layout_rv.setLayoutManager(new GridLayoutManager(this.f4649a));
        this.amazon_recharge_layout_rv.setAdapter(new DashboardPremiumPartnersAdapter(this.f4649a, arrayList2, this.f4651a));
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
        HomeActivity.e.setVisibility(8);
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
        HomeActivity.e.setVisibility(8);
    }

    public final void onResume() {
        super.onResume();
        if (C0535I5.R()) {
            if (C0535I5.f3630b) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Long l = C0535I5.f3616a.f3653a;
                Boolean bool = C0535I5.f3616a.a;
                if (bool == null || !bool.booleanValue()) {
                    C0535I5.f3616a.a = Boolean.FALSE;
                } else {
                    this.lastTransationDtail.setVisibility(0);
                    this.last_txn_layout.setVisibility(0);
                    this.last_txn_ll.setVisibility(0);
                    this.transactionNumber.setText(String.valueOf(C0535I5.f3616a.f3653a));
                    this.bkgStatus.setText(String.valueOf(C0535I5.f3616a.f3654a));
                    String[] split = String.valueOf(simpleDateFormat.format(C0535I5.f3616a.f3655a)).split(" ");
                    TextView textView = this.lastTransationTimeStamp;
                    textView.setText(split[0] + "," + split[1] + "Hrs");
                    C0535I5.f3630b = false;
                    this.viewTkt.setOnClickListener(new Q(this));
                }
            }
            HomeActivity.p();
            return;
        }
        HomeActivity.I();
    }

    public final void onStart() {
        super.onStart();
        try {
            if (this.f4649a.getPackageManager().getLaunchIntentForPackage("com.irctc.fot") != null) {
                ((ImageView) getActivity().findViewById(R.id.book_meal_logo)).setImageResource(R.drawable.book_meal_fot);
            } else {
                ((ImageView) getActivity().findViewById(R.id.book_meal_logo)).setImageResource(R.drawable.book_meal);
            }
        } catch (Exception unused) {
            C0535I5.t0(this.f4649a, getString(R.string.error));
        }
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
        HomeActivity.e.setVisibility(8);
    }

    @OnClick({2131363690})
    public void ret_room(View view) {
        try {
            this.f4649a.startActivity(Intent.parseUri("https://www.rr.irctc.co.in", 1));
        } catch (Exception unused) {
        }
    }

    @OnClick({2131363996})
    public void specialtrainListClick() {
        if (this.specialtrain_list_rl.getVisibility() == 0) {
            this.specialtrain_list_rl.setVisibility(8);
        } else {
            this.specialtrain_list_rl.setVisibility(0);
        }
    }

    public class a implements View.OnClickListener {

        /* renamed from: cris.org.in.ima.fragment.HomeFragment$a$a  reason: collision with other inner class name */
        public class C0065a implements DialogInterface.OnClickListener {
            public C0065a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                a aVar = a.this;
                C0535I5.i0(HomeFragment.this.getContext(), "en");
                ImageView imageView = HomeFragment.a;
                HomeFragment homeFragment = HomeFragment.this;
                homeFragment.g("en");
                homeFragment.getActivity().recreate();
                String string = homeFragment.getContext().getSharedPreferences("Settings", 0).getString("My_Lang", "en");
                IrctcImaApplication.e = string;
                homeFragment.g(string);
                C0535I5.a0(homeFragment.getContext());
                Bw.e(homeFragment.getContext()).y("en");
                C0535I5.v(homeFragment.getActivity());
            }
        }

        public class c implements DialogInterface.OnClickListener {
            public c() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                a aVar = a.this;
                C0535I5.i0(HomeFragment.this.getContext(), "hi");
                HomeFragment homeFragment = HomeFragment.this;
                homeFragment.getActivity().recreate();
                String string = homeFragment.getContext().getSharedPreferences("Settings", 0).getString("My_Lang", "en");
                IrctcImaApplication.e = string;
                homeFragment.g(string);
                C0535I5.a0(homeFragment.getContext());
                Bw.e(homeFragment.getContext()).y("hi");
                C0535I5.v(homeFragment.getActivity());
            }
        }

        public a() {
        }

        public final void onClick(View view) {
            boolean equalsIgnoreCase = IrctcImaApplication.e.equalsIgnoreCase("hi");
            HomeFragment homeFragment = HomeFragment.this;
            if (equalsIgnoreCase) {
                C0535I5.p(homeFragment.getContext(), false, "Kindly re-launch the app for changes to take effect", "Confirmation", "OK", new C0065a(), "NO", new b()).show();
            } else {
                C0535I5.p(homeFragment.getContext(), false, "परिवर्तनों को प्रभावी करने के लिए कृपया ऐप को फिर से लॉन्च करें।", "पुष्टि", "ठीक है", new c(), "नहीं", new d()).show();
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public class d implements DialogInterface.OnClickListener {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }
    }
}
