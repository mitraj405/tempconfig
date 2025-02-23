package cris.org.in.ima.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.messaging.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.StationListActivity;
import cris.org.in.ima.adaptors.FavourtyListJPPageAdapter;
import cris.org.in.ima.adaptors.InformationMsgAdapter;
import cris.org.in.ima.adaptors.RecentSearchStnAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.model.AvlClassModel;
import cris.org.in.ima.model.FevJourneyModel;
import cris.org.in.ima.model.RecentSearchStationModel;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.ima.services.StationListFetch;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.InformationMessageDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import defpackage.C0535I5;
import defpackage.d7;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

public class NewBookingFragment extends Fragment {
    public static boolean k;
    public static boolean l;
    public static String z = "GN";
    @BindView(2131361793)
    LinearLayout Allclass_ll;
    @BindView(2131364204)
    AdManagerAdView PublisherAdview;
    @BindView(2131363365)
    LinearLayout SpecialConc;
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public final Bw f4843a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4844a = null;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f4845a = null;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f4846a;

    /* renamed from: a  reason: collision with other field name */
    public Gson f4847a = null;

    /* renamed from: a  reason: collision with other field name */
    public FavourtyListJPPageAdapter f4848a;

    /* renamed from: a  reason: collision with other field name */
    public RecentSearchStnAdapter f4849a;

    /* renamed from: a  reason: collision with other field name */
    public k f4850a;

    /* renamed from: a  reason: collision with other field name */
    public final m f4851a;

    /* renamed from: a  reason: collision with other field name */
    public final q f4852a;

    /* renamed from: a  reason: collision with other field name */
    public final r f4853a;

    /* renamed from: a  reason: collision with other field name */
    public AvlClassModel f4854a = null;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4855a = null;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, Boolean> f4856a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f4857a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4858a = false;
    @BindView(2131361932)
    LinearLayout all_class;
    public final ArrayList<RecentSearchStationModel> b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public final HashMap<String, Boolean> f4859b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4860b = false;
    @BindView(2131364318)
    TextView bkgStatus;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4861c;

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f4862c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    public boolean f4863c = false;
    @BindView(2131362102)
    ImageView calender;
    @BindView(2131362198)
    CheckBox class_1A;
    @BindView(2131362199)
    LinearLayout class_1A_ll;
    @BindView(2131362200)
    CheckBox class_2A;
    @BindView(2131362201)
    LinearLayout class_2A_ll;
    @BindView(2131362202)
    CheckBox class_2S;
    @BindView(2131362203)
    LinearLayout class_2S_ll;
    @BindView(2131362204)
    CheckBox class_3A;
    @BindView(2131362205)
    LinearLayout class_3A_ll;
    @BindView(2131362206)
    CheckBox class_AC;
    @BindView(2131362207)
    LinearLayout class_AC_ll;
    @BindView(2131362208)
    CheckBox class_CC;
    @BindView(2131362209)
    LinearLayout class_CC_ll;
    @BindView(2131362210)
    CheckBox class_EC;
    @BindView(2131362211)
    LinearLayout class_EC_ll;
    @BindView(2131362213)
    CheckBox class_FC;
    @BindView(2131362214)
    LinearLayout class_FC_ll;
    @BindView(2131362215)
    CheckBox class_SL;
    @BindView(2131362216)
    LinearLayout class_SL_ll;
    @BindView(2131362219)
    RelativeLayout class_bottom_rl;
    @BindView(2131362221)
    LinearLayout classlayout_ll;
    @BindView(2131362292)
    CheckBox connectingJourney;
    @BindView(2131362293)
    LinearLayout connectingJourneyLl;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f4864d;

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList f4865d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f4866d = false;
    @BindView(2131362376)
    LinearLayout dayAfterTomorrow;
    @BindView(2131362375)
    TextView dayAfterTomorrow_label;
    @BindView(2131362374)
    TextView dayAfterTomorrowdate;
    @BindView(2131364387)
    TextView dutypass;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public String f4867e;

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<FevJourneyModel> f4868e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f4869e = false;
    public String f;

    /* renamed from: f  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4870f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f4871f = false;
    @BindView(2131362641)
    RelativeLayout fav_heading_rl;
    @BindView(2131362686)
    CheckBox flexiableDate;
    @BindView(2131362711)
    TextView fromStnCodeID;
    @BindView(2131362709)
    TextView fromStnNameID;
    public String g = "";

    /* renamed from: g  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4872g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f4873g = false;
    public String h = "";

    /* renamed from: h  reason: collision with other field name */
    public final ArrayList<String> f4874h;

    /* renamed from: h  reason: collision with other field name */
    public boolean f4875h = true;
    public String i = null;

    /* renamed from: i  reason: collision with other field name */
    public boolean f4876i;
    @BindView(2131364436)
    TextView informationHeading;
    public String j;

    /* renamed from: j  reason: collision with other field name */
    public boolean f4877j;
    @BindView(2131362919)
    LinearLayout journalist_booking_ll;
    @BindView(2131362918)
    CheckBox journalistbooking;
    @BindView(2131362920)
    TextView journeyDate;
    @BindView(2131362921)
    TextView journeyDateLabel;

    /* renamed from: k  reason: collision with other field name */
    public String f4878k = "N";

    /* renamed from: l  reason: collision with other field name */
    public String f4879l = "";
    @BindView(2131362946)
    RelativeLayout lastTransationDtail;
    @BindView(2131364661)
    TextView lastTransationTimeStamp;
    @BindView(2131362948)
    LinearLayout last_txn_layout;
    @BindView(2131362949)
    RelativeLayout last_txn_ll;
    @BindView(2131363056)
    LinearLayout ll_quota;
    public String m = "";
    public String n = "";
    public String o = "";
    @BindView(2131363367)
    LinearLayout onflexiableDateClick;
    public String p = "";
    @BindView(2131364522)
    TextView parliamentHouse;
    @BindView(2131364529)
    TextView phHandicap;
    @BindView(2131364537)
    TextView premiumTatkal;
    public String q = "";
    @BindView(2131363578)
    LinearLayout quota_bottom;
    @BindView(2131363579)
    RelativeLayout quota_bottom_ll;
    public String r = "";
    @BindView(2131363590)
    LinearLayout railway_pass_ll;
    @BindView(2131363591)
    CheckBox railway_passbooking;
    @BindView(2131364551)
    TextView rebookFavJourney;
    @BindView(2131364552)
    TextView recentSearchHeader;
    @BindView(2131363830)
    RecyclerView recentSearchRecycleview;
    @BindView(2131363814)
    RecyclerView rvFevJourney;
    @BindView(2131363802)
    RecyclerView rv_Favourty;
    @BindView(2131363818)
    RecyclerView rv_infomation;
    public String s = "";
    @BindView(2131364586)
    TextView search;
    @BindView(2131364590)
    TextView selectFevJourneylist;
    @BindView(2131363901)
    LinearLayout selectJourneyDate;
    @BindView(2131363896)
    RelativeLayout select_fevjournet_Rl;
    @BindView(2131364594)
    TextView select_quota;
    @BindView(2131364597)
    TextView seniorCitizen;
    @BindView(2131363984)
    CheckBox specialConcessioncheckbox;
    @BindView(2131364032)
    LinearLayout stnRotation;
    public String t;
    @BindView(2131364166)
    TextView toStnCodeID;
    @BindView(2131364164)
    TextView toStnNameID;
    @BindView(2131364177)
    LinearLayout tomorrow;
    @BindView(2131364175)
    TextView tomorrowDate;
    @BindView(2131364176)
    TextView tomorrowLabel;
    @BindView(2131364189)
    CheckBox trainAvailableBerth;
    @BindView(2131364694)
    TextView transationNumber;
    @BindView(2131364429)
    TextView tvGeneral;
    @BindView(2131364452)
    TextView tvLadies;
    @BindView(2131364655)
    TextView tvTatkal;
    @BindView(2131364253)
    TextView tv_2tier_class;
    @BindView(2131364254)
    TextView tv_3Tier_class;
    @BindView(2131364255)
    TextView tv_Anubhuti_class;
    @BindView(2131364259)
    TextView tv_acchair_car_class;
    @BindView(2131364262)
    TextView tv_aceconomy_class;
    @BindView(2131364263)
    TextView tv_acfirst_class;
    @BindView(2131364287)
    TextView tv_all_class;
    @BindView(2131364288)
    TextView tv_allview_fav;
    @BindView(2131364400)
    TextView tv_exec_chair_class;
    @BindView(2131364411)
    TextView tv_first_class;
    @BindView(2131364589)
    TextView tv_second_sitting_class;
    @BindView(2131364596)
    TextView tv_selectclass;
    @BindView(2131364602)
    TextView tv_sleeper_class;
    @BindView(2131364727)
    TextView tv_vistadome_ac;
    @BindView(2131364728)
    TextView tv_vistadome_chair_car;
    @BindView(2131364729)
    TextView tv_vistadome_non_ac;
    @BindView(2131364736)
    LinearLayout twoDaysAfterTomorrow;
    @BindView(2131364734)
    TextView twoDaysAfterTomorrowDate;
    @BindView(2131364735)
    TextView twoDaysAfterTomorrowLabel;
    public String u;
    public String v;
    public String w;
    public final String x;
    public String y;

    public class b implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            NewBookingFragment newBookingFragment = NewBookingFragment.this;
            newBookingFragment.railway_passbooking.setChecked(false);
            newBookingFragment.n();
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            NewBookingFragment.this.railway_passbooking.setChecked(true);
        }
    }

    public class k extends CountDownTimer {
        public final /* synthetic */ ProgressDialog a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ String f4881a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str, ProgressDialog progressDialog) {
            super(10000, 1000);
            this.f4881a = str;
            this.a = progressDialog;
        }

        public final void onFinish() {
            NewBookingFragment newBookingFragment = NewBookingFragment.this;
            if (!newBookingFragment.f4877j) {
                this.a.dismiss();
                if (StationListFetch.c == 1) {
                    C0535I5.t0(newBookingFragment.getActivity(), newBookingFragment.getString(R.string.Unable_to_retrieve_data_Please_try_again));
                    return;
                }
                Intent intent = new Intent(newBookingFragment.getActivity(), StationListFetch.class);
                intent.putExtra("stationHash", newBookingFragment.f4843a.i());
                newBookingFragment.getActivity().startService(intent);
            }
        }

        public final void onTick(long j) {
            NewBookingFragment newBookingFragment = NewBookingFragment.this;
            if (newBookingFragment.f4843a.i() != null) {
                k kVar = newBookingFragment.f4850a;
                if (kVar != null) {
                    kVar.cancel();
                    newBookingFragment.f4877j = true;
                }
                Class<StationListActivity> cls = StationListActivity.class;
                if (this.f4881a == Constants.MessagePayloadKeys.FROM) {
                    Intent intent = new Intent(newBookingFragment.getActivity(), cls);
                    intent.putExtra("stationView", 0);
                    intent.putExtra("FromStationHint", newBookingFragment.g);
                    intent.putExtra("ToStationHint", newBookingFragment.h);
                    intent.putExtra("toStnClickFavFlag", "true");
                    newBookingFragment.startActivityForResult(intent, 0);
                } else {
                    Intent intent2 = new Intent(newBookingFragment.getActivity(), cls);
                    intent2.putExtra("stationView", 1);
                    intent2.putExtra("FromStationHint", newBookingFragment.g);
                    intent2.putExtra("ToStationHint", newBookingFragment.h);
                    intent2.putExtra("toStnClickFavFlag", "false");
                    newBookingFragment.startActivityForResult(intent2, 1);
                }
                this.a.dismiss();
            }
        }
    }

    public class l implements DatePickerDialog.OnDateSetListener {
        public l() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            NewBookingFragment newBookingFragment = NewBookingFragment.this;
            newBookingFragment.c = i;
            newBookingFragment.d = i2;
            newBookingFragment.e = i3;
            newBookingFragment.getClass();
            GregorianCalendar gregorianCalendar = new GregorianCalendar(newBookingFragment.c, newBookingFragment.d, newBookingFragment.e);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE dd MMM");
            newBookingFragment.journeyDate.setContentDescription(new SimpleDateFormat("EEEE").format(gregorianCalendar.getTime()));
            newBookingFragment.journeyDate.setText(simpleDateFormat2.format(gregorianCalendar.getTime()));
            newBookingFragment.f4861c = simpleDateFormat.format(gregorianCalendar.getTime());
            newBookingFragment.g();
        }
    }

    public class m implements FavourtyListJPPageAdapter.fevJourneyListener {
        public m() {
        }

        public final void OnItemClick(FevJourneyModel fevJourneyModel) {
            String[] split = fevJourneyModel.d.split("-");
            NewBookingFragment newBookingFragment = NewBookingFragment.this;
            newBookingFragment.fromStnNameID.setText(C0535I5.s0(split[0]));
            newBookingFragment.fromStnCodeID.setText(split[1].trim());
            newBookingFragment.g = split[1].trim() + "-" + C0535I5.s0(split[0]);
            String[] split2 = fevJourneyModel.e.split("-");
            newBookingFragment.toStnNameID.setText(C0535I5.s0(split2[0].trim()));
            newBookingFragment.toStnCodeID.setText(split2[1].trim());
            newBookingFragment.h = split2[1].trim() + "-" + C0535I5.s0(split2[0].trim());
            newBookingFragment.tv_selectclass.setText(xx.e(fevJourneyModel.f));
            String str = fevJourneyModel.f;
            if (str != null) {
                newBookingFragment.s = str;
            } else {
                newBookingFragment.s = "";
            }
            newBookingFragment.select_quota.setText(C0535I5.s0(H9.f(fevJourneyModel.g).a()));
            String str2 = fevJourneyModel.g;
            NewBookingFragment.z = str2;
            newBookingFragment.l(newBookingFragment.getView(), str2);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public final void run() {
            NewBookingFragment.this.f4858a = false;
        }
    }

    public class p extends Subscriber<TrainBtwnStnsRespDto> {
        public p() {
        }

        public final void onCompleted() {
            boolean z = NewBookingFragment.k;
        }

        public final void onError(Throwable th) {
            boolean z = NewBookingFragment.k;
            th.getClass();
            th.getMessage();
            NewBookingFragment.this.f4844a.dismiss();
            Lt.a(true, th);
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x01af A[Catch:{ Exception -> 0x0402 }] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x024f A[Catch:{ Exception -> 0x0402 }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x036a A[Catch:{ Exception -> 0x0402 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                r0 = r17
                cris.prs.webservices.dto.TrainBtwnStnsRespDto r0 = (cris.prs.webservices.dto.TrainBtwnStnsRespDto) r0
                java.lang.String r2 = ""
                r3 = 2131951928(0x7f130138, float:1.9540284E38)
                r4 = 2131952688(0x7f130430, float:1.9541826E38)
                cris.org.in.ima.fragment.NewBookingFragment r5 = cris.org.in.ima.fragment.NewBookingFragment.this
                if (r0 == 0) goto L_0x0424
                defpackage.C0657Qt.h()
                java.lang.String r6 = r5.f4867e
                java.lang.String r7 = r5.f
                java.lang.String r8 = r5.f4861c
                int r9 = defpackage.C1507z0.a
                android.os.Bundle r9 = new android.os.Bundle
                r9.<init>()
                java.lang.String r10 = "origin"
                r9.putString(r10, r6)
                java.lang.String r6 = "destination"
                r9.putString(r6, r7)
                java.lang.String r6 = "start_date"
                java.lang.String r7 = defpackage.C1507z0.a(r8)
                r9.putString(r6, r7)
                com.google.firebase.analytics.FirebaseAnalytics r6 = cris.org.in.ima.IrctcImaApplication.f4146a
                java.lang.String r7 = "view_search_results"
                r6.logEvent(r7, r9)
                java.lang.Boolean r6 = r0.getOneStopJourny()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x0084
                java.lang.Boolean r6 = r0.getOneStopJourny()     // Catch:{ Exception -> 0x0402 }
                boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x0084
                java.lang.String r6 = r0.getErrorMessage()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x0084
                android.content.Context r7 = r5.getContext()     // Catch:{ Exception -> 0x0402 }
                r8 = 0
                r6 = 2131953290(0x7f13068a, float:1.9543047E38)
                java.lang.String r9 = r5.getString(r6)     // Catch:{ Exception -> 0x0402 }
                r6 = 2131952514(0x7f130382, float:1.9541473E38)
                java.lang.String r10 = r5.getString(r6)     // Catch:{ Exception -> 0x0402 }
                r6 = 2131954004(0x7f130954, float:1.9544495E38)
                java.lang.String r11 = r5.getString(r6)     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.fragment.Y r12 = new cris.org.in.ima.fragment.Y     // Catch:{ Exception -> 0x0402 }
                r12.<init>(r1)     // Catch:{ Exception -> 0x0402 }
                r6 = 2131953281(0x7f130681, float:1.9543029E38)
                java.lang.String r13 = r5.getString(r6)     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.fragment.Z r14 = new cris.org.in.ima.fragment.Z     // Catch:{ Exception -> 0x0402 }
                r14.<init>(r1)     // Catch:{ Exception -> 0x0402 }
                android.app.AlertDialog r6 = defpackage.C0535I5.p(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0402 }
                r6.show()     // Catch:{ Exception -> 0x0402 }
            L_0x0084:
                java.lang.Boolean r6 = r0.getOneStopJourny()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x009c
                java.lang.Boolean r6 = r0.getOneStopJourny()     // Catch:{ Exception -> 0x0402 }
                boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x009c
                java.lang.String r6 = r0.getErrorMessage()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x009c
                goto L_0x0449
            L_0x009c:
                java.lang.String r6 = r0.getErrorMessage()     // Catch:{ Exception -> 0x0402 }
                r7 = 0
                if (r6 != 0) goto L_0x038a
                java.util.List r6 = r0.getTrainBtwnStnsList()     // Catch:{ Exception -> 0x0402 }
                if (r6 != 0) goto L_0x00d2
                java.util.List r6 = r0.getAlternateTrainBtwnStnsList()     // Catch:{ Exception -> 0x0402 }
                if (r6 != 0) goto L_0x00d2
                android.app.ProgressDialog r0 = r5.f4844a     // Catch:{ Exception -> 0x0402 }
                r0.dismiss()     // Catch:{ Exception -> 0x0402 }
                androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x0402 }
                r7 = 0
                r0 = 2131953850(0x7f1308ba, float:1.9544183E38)
                java.lang.String r8 = r5.getString(r0)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r9 = r5.getString(r4)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r10 = r5.getString(r3)     // Catch:{ Exception -> 0x0402 }
                r11 = 0
                android.app.AlertDialog r0 = defpackage.C0535I5.m(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0402 }
                r0.show()     // Catch:{ Exception -> 0x0402 }
                goto L_0x0449
            L_0x00d2:
                android.os.Bundle r3 = new android.os.Bundle     // Catch:{ Exception -> 0x0402 }
                r3.<init>()     // Catch:{ Exception -> 0x0402 }
                wA r4 = new wA     // Catch:{ Exception -> 0x0402 }
                r4.<init>(r0)     // Catch:{ Exception -> 0x0402 }
                java.util.LinkedHashSet r0 = new java.util.LinkedHashSet     // Catch:{ Exception -> 0x0402 }
                r0.<init>()     // Catch:{ Exception -> 0x0402 }
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r6 = r5.f4870f     // Catch:{ Exception -> 0x0402 }
                r6.clear()     // Catch:{ Exception -> 0x0402 }
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r6 = r5.f4872g     // Catch:{ Exception -> 0x0402 }
                r6.clear()     // Catch:{ Exception -> 0x0402 }
                java.lang.String r6 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r6 = r6.equals(r2)     // Catch:{ Exception -> 0x0402 }
                java.util.HashSet r8 = r5.f4857a
                java.util.ArrayList<java.lang.String> r9 = r5.f4874h
                java.util.HashMap<java.lang.String, java.lang.Boolean> r10 = r5.f4856a
                java.util.HashMap<java.lang.String, java.lang.Boolean> r11 = r5.f4859b
                if (r6 != 0) goto L_0x0186
                java.util.List r6 = r4.getTrainBtwnStnsList()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x0186
                java.util.List r6 = r4.getTrainBtwnStnsList()     // Catch:{ Exception -> 0x0402 }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0402 }
                r13 = r7
            L_0x010a:
                boolean r14 = r6.hasNext()     // Catch:{ Exception -> 0x0402 }
                if (r14 == 0) goto L_0x017e
                java.lang.Object r14 = r6.next()     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.model.TrainBtwnStnsModel r14 = (cris.org.in.ima.model.TrainBtwnStnsModel) r14     // Catch:{ Exception -> 0x0402 }
                cris.prs.webservices.dto.TrainBtwnStnsDTO r15 = r14.f5342a     // Catch:{ Exception -> 0x0402 }
                java.util.List r15 = r15.getTrainType()     // Catch:{ Exception -> 0x0402 }
                java.lang.Object r15 = r15.get(r7)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0402 }
                java.lang.Boolean r12 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0402 }
                r10.put(r15, r12)     // Catch:{ Exception -> 0x0402 }
                cris.prs.webservices.dto.TrainBtwnStnsDTO r12 = r14.f5342a     // Catch:{ Exception -> 0x0402 }
                java.util.List r12 = r12.getTrainType()     // Catch:{ Exception -> 0x0402 }
                java.lang.Object r12 = r12.get(r7)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0402 }
                r9.add(r12)     // Catch:{ Exception -> 0x0402 }
                java.util.ArrayList r12 = r14.f5346a     // Catch:{ Exception -> 0x0402 }
                java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0402 }
            L_0x013c:
                boolean r15 = r12.hasNext()     // Catch:{ Exception -> 0x0402 }
                if (r15 == 0) goto L_0x017b
                java.lang.Object r15 = r12.next()     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.model.AvlClassModel r15 = (cris.org.in.ima.model.AvlClassModel) r15     // Catch:{ Exception -> 0x0402 }
                java.lang.String r7 = r15.c     // Catch:{ Exception -> 0x0402 }
                java.lang.String r1 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r1 = r7.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0402 }
                if (r1 == 0) goto L_0x0156
                r0.add(r14)     // Catch:{ Exception -> 0x0402 }
                r13 = 1
            L_0x0156:
                java.lang.String r1 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r7 = r15.c
                if (r1 != 0) goto L_0x016f
                java.lang.String r1 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r1 = r1.equals(r7)     // Catch:{ Exception -> 0x0402 }
                if (r1 == 0) goto L_0x0169
                goto L_0x016f
            L_0x0169:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0402 }
                r11.put(r7, r1)     // Catch:{ Exception -> 0x0402 }
                goto L_0x0174
            L_0x016f:
                java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0402 }
                r11.put(r7, r1)     // Catch:{ Exception -> 0x0402 }
            L_0x0174:
                r8.add(r7)     // Catch:{ Exception -> 0x0402 }
                r1 = r16
                r7 = 0
                goto L_0x013c
            L_0x017b:
                r1 = r16
                goto L_0x010a
            L_0x017e:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0402 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0402 }
                r5.f4870f = r1     // Catch:{ Exception -> 0x0402 }
                goto L_0x0187
            L_0x0186:
                r13 = 0
            L_0x0187:
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0402 }
                r0.<init>()     // Catch:{ Exception -> 0x0402 }
                r5.f4872g = r0     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0402 }
                if (r0 != 0) goto L_0x0220
                java.util.List r0 = r4.getAlternateTrainBtwnStnsList()     // Catch:{ Exception -> 0x0402 }
                if (r0 == 0) goto L_0x0220
                java.util.LinkedHashSet r0 = new java.util.LinkedHashSet     // Catch:{ Exception -> 0x0402 }
                r0.<init>()     // Catch:{ Exception -> 0x0402 }
                java.util.List r1 = r4.getAlternateTrainBtwnStnsList()     // Catch:{ Exception -> 0x0402 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0402 }
            L_0x01a9:
                boolean r6 = r1.hasNext()     // Catch:{ Exception -> 0x0402 }
                if (r6 == 0) goto L_0x0219
                java.lang.Object r6 = r1.next()     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.model.TrainBtwnStnsModel r6 = (cris.org.in.ima.model.TrainBtwnStnsModel) r6     // Catch:{ Exception -> 0x0402 }
                cris.prs.webservices.dto.TrainBtwnStnsDTO r7 = r6.f5342a     // Catch:{ Exception -> 0x0402 }
                java.util.List r7 = r7.getTrainType()     // Catch:{ Exception -> 0x0402 }
                r12 = 0
                java.lang.Object r7 = r7.get(r12)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0402 }
                r9.add(r7)     // Catch:{ Exception -> 0x0402 }
                cris.prs.webservices.dto.TrainBtwnStnsDTO r7 = r6.f5342a     // Catch:{ Exception -> 0x0402 }
                java.util.List r7 = r7.getTrainType()     // Catch:{ Exception -> 0x0402 }
                r12 = 0
                java.lang.Object r7 = r7.get(r12)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0402 }
                java.lang.Boolean r12 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0402 }
                r10.put(r7, r12)     // Catch:{ Exception -> 0x0402 }
                java.util.ArrayList r7 = r6.f5346a     // Catch:{ Exception -> 0x0402 }
                java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0402 }
            L_0x01dd:
                boolean r12 = r7.hasNext()     // Catch:{ Exception -> 0x0402 }
                if (r12 == 0) goto L_0x01a9
                java.lang.Object r12 = r7.next()     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.model.AvlClassModel r12 = (cris.org.in.ima.model.AvlClassModel) r12     // Catch:{ Exception -> 0x0402 }
                java.lang.String r14 = r12.c     // Catch:{ Exception -> 0x0402 }
                java.lang.String r15 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r14 = r14.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0402 }
                if (r14 == 0) goto L_0x01f7
                r0.add(r6)     // Catch:{ Exception -> 0x0402 }
                r13 = 1
            L_0x01f7:
                java.lang.String r14 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r14 = r14.equals(r2)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r12 = r12.c
                if (r14 != 0) goto L_0x0210
                java.lang.String r14 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r14 = r14.equals(r12)     // Catch:{ Exception -> 0x0402 }
                if (r14 == 0) goto L_0x020a
                goto L_0x0210
            L_0x020a:
                java.lang.Boolean r14 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0402 }
                r11.put(r12, r14)     // Catch:{ Exception -> 0x0402 }
                goto L_0x0215
            L_0x0210:
                java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0402 }
                r11.put(r12, r14)     // Catch:{ Exception -> 0x0402 }
            L_0x0215:
                r8.add(r12)     // Catch:{ Exception -> 0x0402 }
                goto L_0x01dd
            L_0x0219:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0402 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0402 }
                r5.f4872g = r1     // Catch:{ Exception -> 0x0402 }
            L_0x0220:
                java.lang.String r0 = r5.s     // Catch:{ Exception -> 0x0402 }
                boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0402 }
                r1 = 2131953334(0x7f1306b6, float:1.9543136E38)
                r2 = 0
                if (r0 != 0) goto L_0x024b
                if (r13 != 0) goto L_0x024b
                android.app.ProgressDialog r0 = r5.f4844a     // Catch:{ Exception -> 0x0402 }
                r0.dismiss()     // Catch:{ Exception -> 0x0402 }
                androidx.fragment.app.FragmentActivity r0 = r5.getActivity()     // Catch:{ Exception -> 0x0402 }
                r3 = 2131953851(0x7f1308bb, float:1.9544185E38)
                java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r1 = r5.getString(r1)     // Catch:{ Exception -> 0x0402 }
                android.app.AlertDialog r0 = defpackage.C0535I5.o(r0, r3, r1, r2)     // Catch:{ Exception -> 0x0402 }
                r0.show()     // Catch:{ Exception -> 0x0402 }
                goto L_0x0449
            L_0x024b:
                boolean r0 = r5.f4866d     // Catch:{ Exception -> 0x0402 }
                if (r0 == 0) goto L_0x02a3
                java.util.List r0 = r4.getTrainBtwnStnsList()     // Catch:{ Exception -> 0x0402 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0402 }
                r7 = r2
                r6 = 1
            L_0x0259:
                boolean r12 = r0.hasNext()     // Catch:{ Exception -> 0x0402 }
                if (r12 == 0) goto L_0x0283
                java.lang.Object r12 = r0.next()     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.model.TrainBtwnStnsModel r12 = (cris.org.in.ima.model.TrainBtwnStnsModel) r12     // Catch:{ Exception -> 0x0402 }
                cris.prs.webservices.dto.TrainBtwnStnsDTO r13 = r12.f5342a     // Catch:{ Exception -> 0x0402 }
                java.lang.String r13 = r13.getTrainNumber()     // Catch:{ Exception -> 0x0402 }
                java.lang.String r14 = r5.r     // Catch:{ Exception -> 0x0402 }
                boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0402 }
                if (r13 == 0) goto L_0x0259
                cris.org.in.ima.model.AvlClassModel r6 = new cris.org.in.ima.model.AvlClassModel     // Catch:{ Exception -> 0x0402 }
                java.lang.String r7 = r5.q     // Catch:{ Exception -> 0x0402 }
                r6.<init>(r7)     // Catch:{ Exception -> 0x0402 }
                r5.f4854a = r6     // Catch:{ Exception -> 0x0402 }
                java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0402 }
                r6.a = r7     // Catch:{ Exception -> 0x0402 }
                r7 = r12
                r6 = 0
                goto L_0x0259
            L_0x0283:
                if (r6 == 0) goto L_0x02a2
                android.app.ProgressDialog r0 = r5.f4844a     // Catch:{ Exception -> 0x0402 }
                r0.dismiss()     // Catch:{ Exception -> 0x0402 }
                androidx.fragment.app.FragmentActivity r0 = r5.getActivity()     // Catch:{ Exception -> 0x0402 }
                r3 = 2131953852(0x7f1308bc, float:1.9544187E38)
                java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r1 = r5.getString(r1)     // Catch:{ Exception -> 0x0402 }
                android.app.AlertDialog r0 = defpackage.C0535I5.o(r0, r3, r1, r2)     // Catch:{ Exception -> 0x0402 }
                r0.show()     // Catch:{ Exception -> 0x0402 }
                goto L_0x0449
            L_0x02a2:
                r2 = r7
            L_0x02a3:
                r0 = 0
                defpackage.C0535I5.f3647h = r0     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = r5.f4861c     // Catch:{ Exception -> 0x0402 }
                r5.f4864d = r0     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "Response"
                r3.putSerializable(r0, r4)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "trainBtwnStnsModelsListFilter"
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r1 = r5.f4870f     // Catch:{ Exception -> 0x0402 }
                r3.putSerializable(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "alternateTrainBtwnStnsListFilter"
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r1 = r5.f4872g     // Catch:{ Exception -> 0x0402 }
                r3.putSerializable(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "JourneyDate"
                java.lang.String r1 = r5.f4861c     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "FromStationCode"
                java.lang.String r1 = r5.f4867e     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "ToStationCode"
                java.lang.String r1 = r5.f     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "FromStationString"
                java.lang.String r1 = r5.g     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "ToStationString"
                java.lang.String r1 = r5.h     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "flexiableWithDate"
                java.lang.String r1 = r5.j     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "flexiableDateFlag"
                android.widget.CheckBox r1 = r5.flexiableDate     // Catch:{ Exception -> 0x0402 }
                boolean r1 = r1.isChecked()     // Catch:{ Exception -> 0x0402 }
                r3.putBoolean(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "isConnectingJourney"
                boolean r1 = cris.org.in.ima.fragment.NewBookingFragment.k     // Catch:{ Exception -> 0x0402 }
                r3.putBoolean(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "spConcession"
                java.lang.String r1 = r5.f4878k     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "journalistconcession"
                boolean r1 = r5.f4863c     // Catch:{ Exception -> 0x0402 }
                r3.putBoolean(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "divyanconcession"
                boolean r1 = r5.f4860b     // Catch:{ Exception -> 0x0402 }
                r3.putBoolean(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "jrnyClass"
                java.lang.String r1 = r5.s     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "rebookClass"
                java.lang.String r1 = r5.q     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "rebookFlag"
                boolean r1 = r5.f4866d     // Catch:{ Exception -> 0x0402 }
                r3.putBoolean(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "avlClassModel"
                cris.org.in.ima.model.AvlClassModel r1 = r5.f4854a     // Catch:{ Exception -> 0x0402 }
                r3.putSerializable(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "trainBtwnStnsModel"
                r3.putSerializable(r0, r2)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "reebookPsgnList"
                java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r1 = r5.f4855a     // Catch:{ Exception -> 0x0402 }
                r3.putSerializable(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "selectedQuota"
                java.lang.String r1 = cris.org.in.ima.fragment.NewBookingFragment.z     // Catch:{ Exception -> 0x0402 }
                r3.putString(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "trainAvailableBerthIsChecked"
                android.widget.CheckBox r1 = r5.trainAvailableBerth     // Catch:{ Exception -> 0x0402 }
                boolean r1 = r1.isChecked()     // Catch:{ Exception -> 0x0402 }
                r3.putBoolean(r0, r1)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "trainTypeListData"
                r3.putSerializable(r0, r9)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "trainTypeFlag"
                r3.putSerializable(r0, r10)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "classFlag"
                r3.putSerializable(r0, r11)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r0 = "avlClassHashSet"
                r3.putSerializable(r0, r8)     // Catch:{ Exception -> 0x0402 }
                r0 = 0
                r5.f4876i = r0     // Catch:{ Exception -> 0x0402 }
                r0 = 1
                r5.f4873g = r0     // Catch:{ Exception -> 0x0402 }
                android.app.ProgressDialog r0 = r5.f4844a     // Catch:{ Exception -> 0x0402 }
                boolean r0 = r0.isShowing()     // Catch:{ Exception -> 0x0402 }
                if (r0 == 0) goto L_0x036f
                android.app.ProgressDialog r0 = r5.f4844a     // Catch:{ Exception -> 0x0402 }
                r0.dismiss()     // Catch:{ Exception -> 0x0402 }
            L_0x036f:
                cris.org.in.ima.fragment.AllTrainListFragment r0 = new cris.org.in.ima.fragment.AllTrainListFragment     // Catch:{ Exception -> 0x0402 }
                r0.<init>()     // Catch:{ Exception -> 0x0402 }
                r0.setArguments(r3)     // Catch:{ Exception -> 0x0402 }
                androidx.fragment.app.FragmentActivity r1 = r5.getActivity()     // Catch:{ Exception -> 0x0402 }
                kf r2 = defpackage.C1218kf.TRAIN_LIST     // Catch:{ Exception -> 0x0402 }
                java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x0402 }
                java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0402 }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0402 }
                cris.org.in.ima.activities.HomeActivity.n(r1, r0, r2, r3, r4)     // Catch:{ Exception -> 0x0402 }
                goto L_0x0449
            L_0x038a:
                android.app.ProgressDialog r1 = r5.f4844a     // Catch:{ Exception -> 0x0402 }
                r1.dismiss()     // Catch:{ Exception -> 0x0402 }
                java.lang.String r1 = r0.getErrorMessage()     // Catch:{ Exception -> 0x0402 }
                java.lang.String r2 = "50035"
                boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r2 = "-"
                if (r1 == 0) goto L_0x03e1
                short r1 = defpackage.C1450w1.f7013a     // Catch:{ Exception -> 0x0402 }
                r6 = 3
                if (r1 != r6) goto L_0x03c0
                androidx.fragment.app.FragmentActivity r7 = r5.getActivity()     // Catch:{ Exception -> 0x0402 }
                r8 = 0
                r0 = 2131954013(0x7f13095d, float:1.9544513E38)
                java.lang.String r9 = r5.getString(r0)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r10 = r5.getString(r4)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r11 = r5.getString(r3)     // Catch:{ Exception -> 0x0402 }
                r12 = 0
                android.app.AlertDialog r0 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0402 }
                r0.show()     // Catch:{ Exception -> 0x0402 }
                goto L_0x0449
            L_0x03c0:
                androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x0402 }
                r7 = 0
                java.lang.String r0 = r0.getErrorMessage()     // Catch:{ Exception -> 0x0402 }
                java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0402 }
                r1 = 0
                r8 = r0[r1]     // Catch:{ Exception -> 0x0402 }
                java.lang.String r9 = r5.getString(r4)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r10 = r5.getString(r3)     // Catch:{ Exception -> 0x0402 }
                r11 = 0
                android.app.AlertDialog r0 = defpackage.C0535I5.m(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0402 }
                r0.show()     // Catch:{ Exception -> 0x0402 }
                goto L_0x0449
            L_0x03e1:
                androidx.fragment.app.FragmentActivity r6 = r5.getActivity()     // Catch:{ Exception -> 0x0402 }
                r7 = 0
                java.lang.String r0 = r0.getErrorMessage()     // Catch:{ Exception -> 0x0402 }
                java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0402 }
                r1 = 0
                r8 = r0[r1]     // Catch:{ Exception -> 0x0402 }
                java.lang.String r9 = r5.getString(r4)     // Catch:{ Exception -> 0x0402 }
                java.lang.String r10 = r5.getString(r3)     // Catch:{ Exception -> 0x0402 }
                r11 = 0
                android.app.AlertDialog r0 = defpackage.C0535I5.m(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0402 }
                r0.show()     // Catch:{ Exception -> 0x0402 }
                goto L_0x0449
            L_0x0402:
                r0 = move-exception
                boolean r1 = cris.org.in.ima.fragment.NewBookingFragment.k
                r0.getMessage()
                android.app.ProgressDialog r0 = r5.f4844a
                boolean r0 = r0.isShowing()
                if (r0 == 0) goto L_0x0415
                android.app.ProgressDialog r0 = r5.f4844a
                r0.dismiss()
            L_0x0415:
                androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
                r1 = 2131953492(0x7f130754, float:1.9543457E38)
                java.lang.String r1 = r5.getString(r1)
                defpackage.C0535I5.t0(r0, r1)
                goto L_0x0449
            L_0x0424:
                android.app.ProgressDialog r0 = r5.f4844a
                r0.dismiss()
                androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
                r7 = 0
                android.content.res.Resources r0 = r5.getResources()
                r1 = 2131953888(0x7f1308e0, float:1.954426E38)
                java.lang.String r8 = r0.getString(r1)
                java.lang.String r9 = r5.getString(r4)
                java.lang.String r10 = r5.getString(r3)
                r11 = 0
                android.app.AlertDialog r0 = defpackage.C0535I5.m(r6, r7, r8, r9, r10, r11)
                r0.show()
            L_0x0449:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.NewBookingFragment.p.onNext(java.lang.Object):void");
        }
    }

    public class q implements InformationMsgAdapter.InformationMsgListener {
        public q() {
        }

        public final void onItemClick(InformationMessageDTO informationMessageDTO) {
            if (informationMessageDTO != null && informationMessageDTO.getUrl() != null && informationMessageDTO.getUrl().contains("http")) {
                boolean contains = informationMessageDTO.getUrl().contains("play.google.com");
                NewBookingFragment newBookingFragment = NewBookingFragment.this;
                if (contains) {
                    try {
                        Intent parseUri = Intent.parseUri(informationMessageDTO.getUrl(), 1);
                        Intent launchIntentForPackage = newBookingFragment.getActivity().getPackageManager().getLaunchIntentForPackage("nic.goi.aarogyasetu");
                        if (launchIntentForPackage != null) {
                            newBookingFragment.startActivity(launchIntentForPackage);
                        } else {
                            newBookingFragment.startActivity(parseUri);
                        }
                    } catch (Exception e) {
                        boolean z = NewBookingFragment.k;
                        e.getMessage();
                    }
                } else {
                    try {
                        String url = informationMessageDTO.getUrl();
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(url));
                        newBookingFragment.startActivity(intent);
                    } catch (Exception e2) {
                        boolean z2 = NewBookingFragment.k;
                        e2.getMessage();
                        C0535I5.t0(newBookingFragment.getContext(), newBookingFragment.getString(R.string.unable_to_open_link));
                    }
                }
            }
        }
    }

    public class r implements RecentSearchStnAdapter.RecentSearchStnListener {
        public r() {
        }

        public final void onItemClick(RecentSearchStationModel recentSearchStationModel) {
            NewBookingFragment newBookingFragment = NewBookingFragment.this;
            newBookingFragment.f4866d = false;
            newBookingFragment.f4869e = true;
            try {
                String[] split = recentSearchStationModel.a.split("-");
                newBookingFragment.fromStnNameID.setText(C0535I5.s0(split[1]));
                newBookingFragment.fromStnCodeID.setText(split[0].trim());
                newBookingFragment.g = recentSearchStationModel.a;
                String str = recentSearchStationModel.b;
                newBookingFragment.h = str;
                String[] split2 = str.split("-");
                newBookingFragment.toStnNameID.setText(C0535I5.s0(split2[1].trim()));
                newBookingFragment.toStnCodeID.setText(split2[0].trim());
                newBookingFragment.tv_selectclass.setText(recentSearchStationModel.d);
                String str2 = recentSearchStationModel.e;
                if (str2 != null) {
                    newBookingFragment.s = str2;
                } else {
                    newBookingFragment.s = "";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                Date parse = simpleDateFormat.parse(recentSearchStationModel.c);
                Calendar instance = Calendar.getInstance();
                Date parse2 = simpleDateFormat.parse(simpleDateFormat.format(instance.getTime()));
                if (instance.getTime().before(parse) || parse2.equals(parse)) {
                    instance.setTime(parse);
                    newBookingFragment.f4861c = new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
                    newBookingFragment.journeyDate.setText(new SimpleDateFormat("EEE dd MMM").format(instance.getTime()));
                    newBookingFragment.g();
                }
            } catch (Exception e) {
                boolean z = NewBookingFragment.k;
                e.getMessage();
            }
            newBookingFragment.f4876i = false;
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class t extends TypeToken<ArrayList<RecentSearchStationModel>> {
    }

    public class u implements Runnable {
        public u() {
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis() + C1450w1.f7015b;
            NewBookingFragment newBookingFragment = NewBookingFragment.this;
            newBookingFragment.a = currentTimeMillis;
            String format = new SimpleDateFormat("dd-MMM-yyyy [HH:mm:ss]").format(Long.valueOf(newBookingFragment.a));
            if (HomeActivity.f4189c == C1218kf.NEW_BOOKING.a()) {
                HomeActivity.H(format);
                newBookingFragment.f4846a.postDelayed(this, 1000);
            }
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class x implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class y implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class z implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    static {
        C1354qp.R(NewBookingFragment.class);
    }

    public NewBookingFragment() {
        new ArrayList();
        this.f4865d = new ArrayList();
        new ArrayList();
        this.f4868e = new ArrayList<>();
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.f4876i = false;
        this.f4870f = new ArrayList<>();
        this.f4872g = new ArrayList<>();
        this.f4874h = new ArrayList<>();
        this.f4856a = new HashMap<>();
        this.f4859b = new HashMap<>();
        this.f4857a = new HashSet();
        this.x = C0515Ga.AVLBLTY_ONLY;
        this.y = "";
        this.f4846a = new Handler();
        this.f4877j = false;
        this.f4843a = Bw.e(getContext());
        this.f4851a = new m();
        this.f4852a = new q();
        this.f4853a = new r();
    }

    public static void f(NewBookingFragment newBookingFragment) {
        if (newBookingFragment.lastTransationDtail.getVisibility() == 0) {
            newBookingFragment.lastTransationDtail.setVisibility(8);
        }
    }

    @OnClick({2131362686})
    public void flexiableDateClick() {
        if (!this.flexiableDate.isChecked()) {
            this.flexiableDate.setChecked(false);
            this.j = "N";
            return;
        }
        this.flexiableDate.setChecked(true);
        this.j = "Y";
    }

    public final void g() {
        ImageView imageView = this.calender;
        FragmentActivity activity = getActivity();
        Object obj = d7.a;
        imageView.setColorFilter(d7.b.a(activity, R.color.red), PorterDuff.Mode.MULTIPLY);
        lf.t(this, R.color.dark, this.journeyDate);
        lf.t(this, R.color.dark, this.journeyDateLabel);
        this.tomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.tomorrowDate);
        lf.t(this, R.color.colorAccent, this.tomorrowLabel);
        this.dayAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.dayAfterTomorrowdate);
        lf.t(this, R.color.colorAccent, this.dayAfterTomorrow_label);
        this.twoDaysAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.twoDaysAfterTomorrowDate);
        lf.t(this, R.color.colorAccent, this.twoDaysAfterTomorrowLabel);
        this.selectJourneyDate.setBackground(d7.a.b(getActivity(), R.drawable.round_red_corner));
    }

    public final void h() {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE dd MMM");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(instance.getTime());
        this.journeyDate.setContentDescription(new SimpleDateFormat("EEEE").format(instance.getTime()));
        this.journeyDate.setText(format);
        this.f4861c = simpleDateFormat2.format(instance.getTime());
    }

    public final ArrayList<RecentSearchStationModel> i() {
        try {
            if (this.f4845a == null) {
                this.f4845a = PreferenceManager.getDefaultSharedPreferences(getContext());
            }
            if (this.f4847a == null) {
                this.f4847a = new Gson();
            }
            return (ArrayList) this.f4847a.fromJson(this.f4845a.getString("stnpair", ""), new t().getType());
        } catch (Exception e2) {
            e2.getMessage();
            e2.getMessage();
            return null;
        }
    }

    public final void j(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7;
        String str8 = str;
        String str9 = str2;
        ArrayList<RecentSearchStationModel> i2 = i();
        Objects.toString(i2);
        if (i2 != null) {
            boolean z2 = false;
            if (i2.size() >= 8) {
                Iterator<RecentSearchStationModel> it = i2.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        RecentSearchStationModel next = it.next();
                        String str10 = next.a;
                        if (str10 != null && (str7 = next.b) != null && next.c != null && next.d != null) {
                            if (str10.equalsIgnoreCase(str) && str7.equalsIgnoreCase(str9)) {
                                i2.set(i3, new RecentSearchStationModel(str, str2, str3, str4, str5));
                                z2 = true;
                                break;
                            }
                            i3++;
                        } else {
                            i2.remove(next);
                        }
                    } else {
                        break;
                    }
                }
                if (!z2) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<RecentSearchStationModel> it2 = i2.iterator();
                    int i4 = 2;
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                        i4++;
                        if (i4 == 8) {
                            break;
                        }
                    }
                    arrayList.add(new RecentSearchStationModel(str, str2, str3, str4, str5));
                    k(arrayList);
                    return;
                }
                k(i2);
                return;
            }
            Iterator<RecentSearchStationModel> it3 = i2.iterator();
            int i5 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                RecentSearchStationModel next2 = it3.next();
                if (next2.a != null && (str6 = next2.b) != null && next2.c != null) {
                    next2.toString();
                    if (next2.a.equalsIgnoreCase(str) && str6.equalsIgnoreCase(str9)) {
                        i2.set(i5, new RecentSearchStationModel(str, str2, str3, str4, str5));
                        z2 = true;
                        break;
                    }
                    i5++;
                } else {
                    i2.remove(next2);
                }
            }
            if (!z2) {
                i2.add(new RecentSearchStationModel(str, str2, str3, str4, str5));
            }
            k(i2);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new RecentSearchStationModel(str, str2, str3, str4, str5));
        k(arrayList2);
    }

    public final void k(ArrayList<RecentSearchStationModel> arrayList) {
        try {
            if (this.f4845a == null) {
                this.f4845a = PreferenceManager.getDefaultSharedPreferences(getContext());
            }
            if (this.f4847a == null) {
                this.f4847a = new Gson();
            }
            SharedPreferences.Editor edit = this.f4845a.edit();
            edit.putString("stnpair", this.f4847a.toJson((Object) arrayList));
            edit.apply();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public final void l(View view, String str) {
        str.getClass();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 2188:
                if (str.equals("DP")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2312:
                if (str.equals("HP")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2424:
                if (str.equals("LD")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2564:
                if (str.equals("PT")) {
                    c2 = 5;
                    break;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2685:
                if (str.equals("TQ")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                onDutyPassClick(view);
                return;
            case 1:
                onGeneralClick(view);
                return;
            case 2:
                onHandicapClick(view);
                return;
            case 3:
                onLadiesQuotaClick(view);
                return;
            case 4:
                onParliamentHouseClick(view);
                return;
            case 5:
                onPremiumTatkalClick(view);
                return;
            case 6:
                onSeniorCitizenClick(view);
                return;
            case 7:
                onTatkalClick(view);
                return;
            default:
                return;
        }
    }

    public final void m() {
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.dutypass.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        q(this.tvGeneral, R.color.white);
        q(this.tvLadies, R.color.white);
        q(this.seniorCitizen, R.color.white);
        q(this.tvTatkal, R.color.white);
        q(this.premiumTatkal, R.color.white);
        q(this.phHandicap, R.color.white);
        q(this.parliamentHouse, R.color.white);
        q(this.dutypass, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.dutypass.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
    }

    public final void n() {
        m();
        z = getString(R.string.generalCode);
        getString(R.string.generalString);
        this.quota_bottom_ll.setVisibility(8);
        this.SpecialConc.setVisibility(0);
        this.select_quota.setText(getString(R.string.generalString));
        this.railway_pass_ll.setClickable(true);
        this.railway_passbooking.setChecked(false);
        q(this.tvGeneral, R.color.dark);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    public final void o() {
        this.tv_all_class.setSelected(false);
        this.tv_Anubhuti_class.setSelected(false);
        this.tv_acfirst_class.setSelected(false);
        this.tv_2tier_class.setSelected(false);
        this.tv_3Tier_class.setSelected(false);
        this.tv_acchair_car_class.setSelected(false);
        this.tv_aceconomy_class.setSelected(false);
        this.tv_exec_chair_class.setSelected(false);
        this.tv_sleeper_class.setSelected(false);
        this.tv_first_class.setSelected(false);
        this.tv_second_sitting_class.setSelected(false);
        this.tv_vistadome_non_ac.setSelected(false);
        this.tv_vistadome_chair_car.setSelected(false);
        this.tv_vistadome_ac.setSelected(false);
        q(this.tv_all_class, R.color.white);
        q(this.tv_Anubhuti_class, R.color.white);
        q(this.tv_acfirst_class, R.color.white);
        q(this.tv_2tier_class, R.color.white);
        q(this.tv_3Tier_class, R.color.white);
        q(this.tv_acchair_car_class, R.color.white);
        q(this.tv_aceconomy_class, R.color.white);
        q(this.tv_exec_chair_class, R.color.white);
        q(this.tv_sleeper_class, R.color.white);
        q(this.tv_first_class, R.color.white);
        q(this.tv_second_sitting_class, R.color.white);
        q(this.tv_vistadome_non_ac, R.color.white);
        q(this.tv_vistadome_chair_car, R.color.white);
        q(this.tv_vistadome_ac, R.color.white);
        this.tv_all_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_Anubhuti_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_acfirst_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_2tier_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_3Tier_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_acchair_car_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_aceconomy_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_exec_chair_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_sleeper_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_first_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_second_sitting_class.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_vistadome_non_ac.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_vistadome_chair_car.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_vistadome_ac.setTextAppearance(getActivity(), R.style.fontForNormal);
    }

    @OnClick({2131364262})
    public void onAC3EconomyClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.three_E));
        this.s = "3E";
        o();
        this.tv_aceconomy_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_aceconomy_class, R.color.dark);
        this.tv_aceconomy_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364259})
    public void onACChairClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.cc));
        this.s = "CC";
        o();
        this.tv_acchair_car_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_acchair_car_class, R.color.dark);
        this.tv_acchair_car_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364253})
    public void onAc2TierClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.two_a));
        this.s = "2A";
        o();
        this.tv_2tier_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_2tier_class, R.color.dark);
        this.tv_2tier_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364254})
    public void onAc3TierClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.three_a));
        this.s = "3A";
        o();
        this.tv_3Tier_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_3Tier_class, R.color.dark);
        this.tv_3Tier_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364263})
    public void onAcFistClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.one_A));
        this.s = "1A";
        o();
        this.tv_acfirst_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_acfirst_class, R.color.dark);
        this.tv_acfirst_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent == null) {
            return;
        }
        if (i3 != 0 && i3 != 2) {
            return;
        }
        if (intent.getStringExtra("favouritelist").equals("true")) {
            String stringExtra = intent.getStringExtra("fromStationCode");
            this.g = stringExtra;
            String[] split = stringExtra.split("-");
            this.fromStnNameID.setText(C0535I5.s0(split[0].trim()));
            this.fromStnCodeID.setText(split[1].trim().split(" ")[0]);
            this.g = split[1].trim() + " - " + split[0].trim();
            String stringExtra2 = intent.getStringExtra("toStationCode");
            this.h = stringExtra2;
            String[] split2 = stringExtra2.split("-");
            this.toStnNameID.setText(C0535I5.s0(split2[0].trim()));
            this.toStnCodeID.setText(split2[1].trim().split(" ")[0]);
            this.h = split2[1].trim() + " - " + split2[0].trim();
            return;
        }
        if (intent.getStringExtra("fromStationCode") != null) {
            String stringExtra3 = intent.getStringExtra("fromStationCode");
            this.g = stringExtra3;
            this.fromStnNameID.setText(C0535I5.s0(stringExtra3.substring(stringExtra3.indexOf("-") + 1)));
            TextView textView = this.fromStnCodeID;
            String str = this.g;
            textView.setText(str.substring(0, str.indexOf("-")));
        }
        if (intent.getStringExtra("toStationCode") != null) {
            String stringExtra4 = intent.getStringExtra("toStationCode");
            this.h = stringExtra4;
            this.toStnNameID.setText(C0535I5.s0(stringExtra4.substring(stringExtra4.indexOf("-") + 1)));
            TextView textView2 = this.toStnCodeID;
            String str2 = this.h;
            textView2.setText(str2.substring(0, str2.indexOf("-")));
        }
    }

    @OnClick({2131364287})
    public void onAllClassClick(View view) {
        this.s = "";
        o();
        this.tv_selectclass.setText(getString(R.string.all_Classes));
        this.tv_all_class.setSelected(true);
        q(this.tv_all_class, R.color.dark);
        this.tv_all_class.setTextAppearance(getActivity(), R.style.fontForbold);
        this.class_bottom_rl.setVisibility(8);
    }

    @OnClick({2131364255})
    public void onAnubhutiClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.EA));
        this.s = "EA";
        o();
        this.tv_Anubhuti_class.setSelected(true);
        q(this.tv_Anubhuti_class, R.color.dark);
        this.tv_Anubhuti_class.setTextAppearance(getActivity(), R.style.fontForbold);
        this.class_bottom_rl.setVisibility(8);
    }

    @OnClick({2131362198})
    public void onClass1ASelect() {
        boolean isChecked = this.class_1A.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("1A");
        } else {
            arrayList.remove("1A");
        }
        p(arrayList);
    }

    @OnClick({2131362200})
    public void onClass2ASelect() {
        boolean isChecked = this.class_2A.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("2A");
        } else {
            arrayList.remove("2A");
        }
        p(arrayList);
    }

    @OnClick({2131362202})
    public void onClass2Select() {
        boolean isChecked = this.class_2S.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("2S");
        } else {
            arrayList.remove("2S");
        }
        p(arrayList);
    }

    @OnClick({2131362204})
    public void onClass3ASelect() {
        boolean isChecked = this.class_3A.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("3A");
        } else {
            arrayList.remove("3A");
        }
        p(arrayList);
    }

    @OnClick({2131362206})
    public void onClassACSelect() {
        boolean isChecked = this.class_AC.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("AC");
        } else {
            arrayList.remove("AC");
        }
        p(arrayList);
    }

    @OnClick({2131362208})
    public void onClassCCSelect() {
        boolean isChecked = this.class_CC.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("CC");
        } else {
            arrayList.remove("CC");
        }
        p(arrayList);
    }

    @OnClick({2131362210})
    public void onClassECSelect() {
        boolean isChecked = this.class_EC.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("EC");
        } else {
            arrayList.remove("EC");
        }
        p(arrayList);
    }

    @OnClick({2131362213})
    public void onClassFCSelect() {
        boolean isChecked = this.class_FC.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("FC");
        } else {
            arrayList.remove("FC");
        }
        p(arrayList);
    }

    @OnClick({2131362219})
    public void onClassLayout() {
        if (this.class_bottom_rl.getVisibility() == 0) {
            this.class_bottom_rl.setVisibility(8);
        } else {
            this.class_bottom_rl.setVisibility(0);
        }
    }

    @OnClick({2131362215})
    public void onClassSLSelect() {
        boolean isChecked = this.class_SL.isChecked();
        ArrayList<String> arrayList = this.f4862c;
        if (isChecked) {
            arrayList.add("SL");
        } else {
            arrayList.remove("SL");
        }
        p(arrayList);
    }

    @OnClick({2131361932})
    public void onClickAllClass(View view) {
        if (this.class_bottom_rl.getVisibility() == 0) {
            this.class_bottom_rl.setVisibility(8);
        } else {
            this.class_bottom_rl.setVisibility(0);
        }
    }

    @OnClick({2131363056})
    public void onClickQuota(View view) {
        if (this.quota_bottom_ll.getVisibility() == 0) {
            this.quota_bottom_ll.setVisibility(8);
        } else {
            this.quota_bottom_ll.setVisibility(0);
        }
    }

    @OnClick({2131362946})
    public void onClickTransationView(View view) {
        if (this.lastTransationDtail.getVisibility() == 8) {
            this.lastTransationDtail.setVisibility(0);
        } else {
            this.lastTransationDtail.setVisibility(8);
        }
    }

    @OnClick({2131362293})
    public void onConnectingJourneyClick() {
        if (this.connectingJourney.isChecked()) {
            this.connectingJourney.setChecked(false);
            k = false;
            this.railway_pass_ll.setBackgroundColor(getResources().getColor(R.color.white));
        } else if (l) {
            this.connectingJourney.setChecked(false);
        } else {
            this.railway_pass_ll.setBackgroundColor(getResources().getColor(R.color.sr_ctzn_msg));
            this.connectingJourney.setChecked(true);
            k = true;
            C0535I5.p(getActivity(), false, getString(R.string.connecting_journey_msg), getString(R.string.confirmation), getString(R.string.ok), new y(), "", new z()).show();
        }
    }

    @OnClick({2131362292})
    public void onConnectingboxClick() {
        if (!this.connectingJourney.isChecked()) {
            this.connectingJourney.setChecked(false);
            k = false;
        } else if (l) {
            this.connectingJourney.setChecked(false);
        } else {
            this.connectingJourney.setChecked(true);
            k = true;
            C0535I5.p(getActivity(), false, getString(R.string.connecting_journey_msg), getString(R.string.confirmation), getString(R.string.ok), new w(), "", new x()).show();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x05ef, code lost:
        if (r0.equals("FC") == false) goto L_0x05d9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r17, android.view.ViewGroup r18, android.os.Bundle r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = 2131558550(0x7f0d0096, float:1.8742419E38)
            r2 = 0
            r3 = r17
            android.view.View r3 = r3.inflate(r0, r2)
            butterknife.ButterKnife.bind((java.lang.Object) r1, (android.view.View) r3)
            r4 = 0
            defpackage.C0535I5.f3647h = r4
            android.widget.TextView r0 = cris.org.in.ima.activities.HomeActivity.f4185b
            r5 = 8
            r0.setVisibility(r5)
            cris.org.in.ima.activities.HomeActivity.K()
            android.widget.RelativeLayout r0 = r1.lastTransationDtail
            zk r6 = new zk
            r7 = 1
            r6.<init>(r1, r7)
            r0.setOnClickListener(r6)
            java.util.ArrayList r0 = r1.f4865d
            r0.clear()
            java.util.ArrayList<cris.prs.webservices.dto.InformationMessageDTO> r6 = defpackage.C1450w1.f7010a
            java.util.Iterator r6 = r6.iterator()
        L_0x0032:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x005a
            java.lang.Object r8 = r6.next()
            cris.prs.webservices.dto.InformationMessageDTO r8 = (cris.prs.webservices.dto.InformationMessageDTO) r8
            java.lang.String r9 = r8.getParamName()
            java.lang.String r10 = "TRAIN_SEARCH"
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x0032
            java.lang.String r9 = r8.getMessage()
            java.lang.String r10 = "iOS"
            boolean r9 = r9.contains(r10)
            if (r9 != 0) goto L_0x0032
            r0.add(r8)
            goto L_0x0032
        L_0x005a:
            int r6 = r0.size()
            if (r6 != 0) goto L_0x006a
            android.widget.TextView r6 = r1.informationHeading
            r6.setVisibility(r5)
            androidx.recyclerview.widget.RecyclerView r6 = r1.rv_infomation
            r6.setVisibility(r5)
        L_0x006a:
            androidx.recyclerview.widget.RecyclerView r6 = r1.rv_infomation
            androidx.recyclerview.widget.LinearLayoutManager r8 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r9 = r16.getContext()
            r8.<init>(r9, r7, r4)
            r6.setLayoutManager(r8)
            cris.org.in.ima.adaptors.InformationMsgAdapter r6 = new cris.org.in.ima.adaptors.InformationMsgAdapter
            android.content.Context r8 = r16.getContext()
            cris.org.in.ima.fragment.NewBookingFragment$q r9 = r1.f4852a
            r6.<init>(r8, r0, r9)
            androidx.recyclerview.widget.RecyclerView r0 = r1.rv_infomation
            r0.setAdapter(r6)
            android.widget.TextView r0 = r1.toStnNameID
            r0.setAllCaps(r4)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = new cris.org.in.ima.dto.oauth2.GoogleAdParamDTO
            r0.<init>()
            java.lang.String r6 = defpackage.C1450w1.f7009a
            r0.setAge(r6)
            java.lang.String r6 = defpackage.C1450w1.f7021c
            r0.setGender(r6)
            androidx.fragment.app.FragmentActivity r6 = r16.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r8 = r1.PublisherAdview
            defpackage.C0535I5.Y(r6, r8, r0)
            r16.h()
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r6 = 5
            r0.add(r6, r7)
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat
            java.lang.String r9 = "dd MMM"
            r8.<init>(r9)
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat
            java.lang.String r11 = "EEEE"
            r10.<init>(r11)
            java.util.Date r12 = r0.getTime()
            java.lang.String r8 = r8.format(r12)
            android.widget.TextView r12 = r1.tomorrowDate
            r12.setText(r8)
            android.widget.TextView r8 = r1.tomorrowLabel
            java.util.Date r0 = r0.getTime()
            java.lang.String r0 = r10.format(r0)
            r8.setText(r0)
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r8 = 2
            r0.add(r6, r8)
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat
            r10.<init>(r9)
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat
            r12.<init>(r11)
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
            r13.<init>(r11)
            java.util.Date r14 = r0.getTime()
            java.lang.String r10 = r10.format(r14)
            android.widget.TextView r14 = r1.dayAfterTomorrowdate
            r14.setText(r10)
            android.widget.TextView r10 = r1.dayAfterTomorrow_label
            java.util.Date r14 = r0.getTime()
            java.lang.String r13 = r13.format(r14)
            r10.setContentDescription(r13)
            android.widget.TextView r10 = r1.dayAfterTomorrow_label
            java.util.Date r0 = r0.getTime()
            java.lang.String r0 = r12.format(r0)
            r10.setText(r0)
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r10 = 3
            r0.add(r6, r10)
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat
            r12.<init>(r9)
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat
            r9.<init>(r11)
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
            r13.<init>(r11)
            java.util.Date r11 = r0.getTime()
            java.lang.String r11 = r12.format(r11)
            android.widget.TextView r12 = r1.twoDaysAfterTomorrowDate
            r12.setText(r11)
            android.widget.TextView r11 = r1.twoDaysAfterTomorrowLabel
            java.util.Date r12 = r0.getTime()
            java.lang.String r12 = r13.format(r12)
            r11.setContentDescription(r12)
            android.widget.TextView r11 = r1.twoDaysAfterTomorrowLabel
            java.util.Date r0 = r0.getTime()
            java.lang.String r0 = r9.format(r0)
            r11.setText(r0)
            r16.g()
            android.os.Bundle r0 = r16.getArguments()
            if (r0 == 0) goto L_0x0239
            boolean r9 = r0.isEmpty()
            if (r9 != 0) goto L_0x0239
            java.lang.String r9 = "fevJourneyfromcode"
            java.lang.String r9 = r0.getString(r9)
            r1.t = r9
            java.lang.String r9 = "fevJourneyto"
            java.lang.String r9 = r0.getString(r9)
            r1.u = r9
            java.lang.String r9 = "fevJourneytrainnumber"
            r0.getString(r9)
            java.lang.String r9 = "fevJourneyjourneyclass"
            java.lang.String r9 = r0.getString(r9)
            r1.v = r9
            java.lang.String r9 = "fevJourneyquota"
            java.lang.String r9 = r0.getString(r9)
            r1.w = r9
            java.lang.String r9 = "fevJourneycheck"
            boolean r9 = r0.getBoolean(r9)
            r1.f4876i = r9
            java.lang.String r9 = "last_login"
            java.lang.String r9 = r0.getString(r9)
            java.lang.String r11 = "fromStn"
            java.lang.String r11 = r0.getString(r11)
            r1.f4879l = r11
            java.lang.String r11 = "toStn"
            java.lang.String r11 = r0.getString(r11)
            r1.m = r11
            java.lang.String r11 = "ReturnJourneyFlag"
            boolean r12 = r0.containsKey(r11)
            if (r12 == 0) goto L_0x01b4
            boolean r11 = r0.getBoolean(r11)
            r1.f4871f = r11
        L_0x01b4:
            java.lang.String r11 = "ReturnFromStn"
            boolean r12 = r0.containsKey(r11)
            if (r12 == 0) goto L_0x01d2
            java.lang.String r12 = r0.getString(r11)
            if (r12 == 0) goto L_0x01d2
            java.lang.String r12 = r0.getString(r11)
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x01d2
            java.lang.String r11 = r0.getString(r11)
            r1.n = r11
        L_0x01d2:
            java.lang.String r11 = "ReturnDestStn"
            boolean r12 = r0.containsKey(r11)
            if (r12 == 0) goto L_0x01f0
            java.lang.String r12 = r0.getString(r11)
            if (r12 == 0) goto L_0x01f0
            java.lang.String r12 = r0.getString(r11)
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x01f0
            java.lang.String r11 = r0.getString(r11)
            r1.o = r11
        L_0x01f0:
            java.lang.String r11 = "ReturnDate"
            boolean r12 = r0.containsKey(r11)
            if (r12 == 0) goto L_0x020e
            java.lang.String r12 = r0.getString(r11)
            if (r12 == 0) goto L_0x020e
            java.lang.String r12 = r0.getString(r11)
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x020e
            java.lang.String r11 = r0.getString(r11)
            r1.y = r11
        L_0x020e:
            java.lang.String r11 = "rebookDate"
            java.lang.String r11 = r0.getString(r11)
            r1.p = r11
            java.lang.String r11 = "rebookClass"
            java.lang.String r11 = r0.getString(r11)
            r1.q = r11
            java.lang.String r11 = "rebookTrainNo"
            java.lang.String r11 = r0.getString(r11)
            r1.r = r11
            java.lang.String r11 = "rebookFlag"
            boolean r11 = r0.getBoolean(r11)
            r1.f4866d = r11
            java.lang.String r11 = "reebookPsgnList"
            java.io.Serializable r0 = r0.getSerializable(r11)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r1.f4855a = r0
            goto L_0x023a
        L_0x0239:
            r9 = r2
        L_0x023a:
            android.widget.CheckBox r0 = r1.class_1A
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_2A
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_3A
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_EC
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_CC
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_SL
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_2S
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_AC
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.class_FC
            r0.setChecked(r4)
            android.widget.CheckBox r0 = r1.trainAvailableBerth
            r0.setChecked(r4)
            boolean r0 = r1.f4869e
            if (r0 == 0) goto L_0x0272
            r1.f4866d = r4
        L_0x0272:
            boolean r0 = r1.f4875h
            if (r0 == 0) goto L_0x02c1
            if (r9 == 0) goto L_0x02c1
            int r0 = r9.length()
            if (r0 <= 0) goto L_0x02c1
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            android.content.Context r11 = r16.getContext()
            r0.<init>(r11)
            r11 = 2131953010(0x7f130572, float:1.9542479E38)
            java.lang.String r11 = r1.getString(r11)
            r0.setTitle(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r9 = 2131952885(0x7f1304f5, float:1.9542225E38)
            java.lang.String r9 = r1.getString(r9)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r0.setMessage(r9)
            cris.org.in.ima.fragment.NewBookingFragment$s r9 = new cris.org.in.ima.fragment.NewBookingFragment$s
            r9.<init>()
            java.lang.String r11 = "Ok"
            r0.setPositiveButton(r11, r9)
            cris.org.in.ima.fragment.NewBookingFragment$v r9 = new cris.org.in.ima.fragment.NewBookingFragment$v
            r9.<init>()
            r0.setNegativeButton(r2, r9)
            r0.show()
            r1.f4875h = r4
        L_0x02c1:
            boolean r0 = defpackage.C1450w1.f7024c
            if (r0 == 0) goto L_0x02cb
            android.widget.LinearLayout r0 = r1.SpecialConc
            r0.setVisibility(r5)
            goto L_0x02d0
        L_0x02cb:
            android.widget.LinearLayout r0 = r1.SpecialConc
            r0.setVisibility(r4)
        L_0x02d0:
            b1 r0 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r2 = r0.f3911a
            boolean r0 = r1.f4866d
            java.lang.String r9 = "EEE dd MMM"
            java.lang.String r11 = "yyyyMMdd"
            java.lang.String r12 = ""
            java.lang.String r13 = "-"
            if (r0 == 0) goto L_0x03a2
            java.lang.String r0 = r1.f4879l
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x02fc
            java.lang.String r0 = r1.f4879l
            if (r0 == 0) goto L_0x02fc
            android.widget.TextView r14 = r1.fromStnNameID
            java.lang.String r0 = r2.m(r0)
            r14.setText(r0)
            android.widget.TextView r0 = r1.fromStnCodeID
            java.lang.String r14 = r1.f4879l
            r0.setText(r14)
        L_0x02fc:
            java.lang.String r0 = r1.m
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x0318
            java.lang.String r0 = r1.m
            if (r0 == 0) goto L_0x0318
            android.widget.TextView r14 = r1.toStnNameID
            java.lang.String r0 = r2.m(r0)
            r14.setText(r0)
            android.widget.TextView r0 = r1.toStnCodeID
            java.lang.String r14 = r1.m
            r0.setText(r14)
        L_0x0318:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r14 = r1.f4879l
            r0.append(r14)
            r0.append(r13)
            java.lang.String r14 = r1.f4879l
            java.lang.String r14 = r2.m(r14)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            r1.g = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r14 = r1.m
            r0.append(r14)
            r0.append(r13)
            java.lang.String r13 = r1.m
            java.lang.String r13 = r2.m(r13)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            r1.h = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x039c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x039c }
            java.lang.String r13 = r1.p     // Catch:{ Exception -> 0x039c }
            java.util.Date r0 = r0.parse(r13)     // Catch:{ Exception -> 0x039c }
            java.util.Calendar r13 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x039c }
            r13.setTime(r0)     // Catch:{ Exception -> 0x039c }
            java.util.Date r0 = r13.getTime()     // Catch:{ Exception -> 0x039c }
            java.util.Date r14 = new java.util.Date     // Catch:{ Exception -> 0x039c }
            r14.<init>()     // Catch:{ Exception -> 0x039c }
            boolean r0 = r0.before(r14)     // Catch:{ Exception -> 0x039c }
            if (r0 != 0) goto L_0x0534
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x039c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x039c }
            java.util.Date r14 = r13.getTime()     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = r0.format(r14)     // Catch:{ Exception -> 0x039c }
            r1.f4861c = r0     // Catch:{ Exception -> 0x039c }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x039c }
            r0.<init>(r9)     // Catch:{ Exception -> 0x039c }
            android.widget.TextView r14 = r1.journeyDate     // Catch:{ Exception -> 0x039c }
            java.util.Date r13 = r13.getTime()     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = r0.format(r13)     // Catch:{ Exception -> 0x039c }
            r14.setText(r0)     // Catch:{ Exception -> 0x039c }
            goto L_0x0534
        L_0x039c:
            r0 = move-exception
            r0.getMessage()
            goto L_0x0534
        L_0x03a2:
            java.lang.String r0 = r2.a()     // Catch:{ Exception -> 0x03a9 }
            r1.i = r0     // Catch:{ Exception -> 0x03a9 }
            goto L_0x03ad
        L_0x03a9:
            r0 = move-exception
            r0.getMessage()
        L_0x03ad:
            boolean r0 = r1.f4876i
            if (r0 == 0) goto L_0x0457
            java.lang.String r0 = r1.t
            java.lang.String[] r0 = r0.split(r13)
            android.widget.TextView r14 = r1.fromStnNameID
            r15 = r0[r4]
            java.lang.String r15 = defpackage.C0535I5.s0(r15)
            r14.setText(r15)
            android.widget.TextView r14 = r1.fromStnCodeID
            r15 = r0[r7]
            java.lang.String r15 = r15.trim()
            r14.setText(r15)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r15 = r0[r7]
            java.lang.String r15 = r15.trim()
            r14.append(r15)
            r14.append(r13)
            r0 = r0[r4]
            java.lang.String r0 = defpackage.C0535I5.s0(r0)
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            r1.g = r0
            java.lang.String r0 = r1.u
            java.lang.String[] r0 = r0.split(r13)
            android.widget.TextView r14 = r1.toStnNameID
            r15 = r0[r4]
            java.lang.String r15 = r15.trim()
            java.lang.String r15 = defpackage.C0535I5.s0(r15)
            r14.setText(r15)
            android.widget.TextView r14 = r1.toStnCodeID
            r15 = r0[r7]
            java.lang.String r15 = r15.trim()
            r14.setText(r15)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r15 = r0[r7]
            java.lang.String r15 = r15.trim()
            r14.append(r15)
            r14.append(r13)
            r0 = r0[r4]
            java.lang.String r0 = r0.trim()
            java.lang.String r0 = defpackage.C0535I5.s0(r0)
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            r1.h = r0
            android.widget.TextView r0 = r1.tv_selectclass
            java.lang.String r13 = r1.v
            java.lang.String r13 = defpackage.xx.e(r13)
            r0.setText(r13)
            java.lang.String r0 = r1.v
            if (r0 == 0) goto L_0x0442
            r1.s = r0
        L_0x0442:
            android.widget.TextView r0 = r1.select_quota
            java.lang.String r13 = r1.w
            H9 r13 = defpackage.H9.f(r13)
            java.lang.String r13 = r13.a()
            r0.setText(r13)
            java.lang.String r0 = r1.w
            z = r0
            goto L_0x0534
        L_0x0457:
            java.lang.String r0 = r1.i
            if (r0 == 0) goto L_0x0474
            java.lang.String r14 = ":"
            int r15 = r0.indexOf(r14)
            java.lang.String r0 = r0.substring(r4, r15)
            r1.g = r0
            java.lang.String r0 = r1.i
            int r14 = r0.indexOf(r14)
            int r14 = r14 + r7
            java.lang.String r0 = r0.substring(r14)
            r1.h = r0
        L_0x0474:
            java.lang.String r0 = r1.g
            boolean r0 = r0.equals(r12)
            java.lang.String r14 = "("
            if (r0 != 0) goto L_0x04d5
            java.lang.String r0 = r1.g
            if (r0 == 0) goto L_0x04d5
            boolean r0 = r0.contains(r14)
            if (r0 == 0) goto L_0x04af
            android.widget.TextView r0 = r1.fromStnNameID
            java.lang.String r15 = r1.g
            int r6 = r15.indexOf(r14)
            java.lang.String r6 = r15.substring(r4, r6)
            java.lang.String r6 = r2.n(r6)
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r0.setText(r6)
            android.widget.TextView r0 = r1.fromStnCodeID
            java.lang.String r6 = r1.g
            int r15 = r6.indexOf(r14)
            java.lang.String r6 = r6.substring(r4, r15)
            r0.setText(r6)
            goto L_0x04d5
        L_0x04af:
            android.widget.TextView r0 = r1.fromStnNameID
            java.lang.String r6 = r1.g
            int r15 = r6.indexOf(r13)
            java.lang.String r6 = r6.substring(r4, r15)
            java.lang.String r6 = r2.n(r6)
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r0.setText(r6)
            android.widget.TextView r0 = r1.fromStnCodeID
            java.lang.String r6 = r1.g
            int r15 = r6.indexOf(r13)
            java.lang.String r6 = r6.substring(r4, r15)
            r0.setText(r6)
        L_0x04d5:
            java.lang.String r0 = r1.h
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x0534
            java.lang.String r0 = r1.h
            if (r0 == 0) goto L_0x0534
            boolean r0 = r0.contains(r14)
            if (r0 == 0) goto L_0x050e
            android.widget.TextView r0 = r1.toStnNameID
            java.lang.String r6 = r1.h
            int r13 = r6.indexOf(r14)
            java.lang.String r6 = r6.substring(r4, r13)
            java.lang.String r6 = r2.n(r6)
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r0.setText(r6)
            android.widget.TextView r0 = r1.toStnCodeID
            java.lang.String r6 = r1.h
            int r13 = r6.indexOf(r14)
            java.lang.String r6 = r6.substring(r4, r13)
            r0.setText(r6)
            goto L_0x0534
        L_0x050e:
            android.widget.TextView r0 = r1.toStnNameID
            java.lang.String r6 = r1.h
            int r14 = r6.indexOf(r13)
            java.lang.String r6 = r6.substring(r4, r14)
            java.lang.String r6 = r2.n(r6)
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r0.setText(r6)
            android.widget.TextView r0 = r1.toStnCodeID
            java.lang.String r6 = r1.h
            int r13 = r6.indexOf(r13)
            java.lang.String r6 = r6.substring(r4, r13)
            r0.setText(r6)
        L_0x0534:
            java.util.ArrayList<cris.org.in.ima.model.RecentSearchStationModel> r0 = r1.b
            r0.clear()
            java.util.ArrayList r6 = r16.i()
            r13 = 4
            if (r6 == 0) goto L_0x055d
            java.util.ArrayList r6 = r16.i()
            java.lang.Object r6 = r6.get(r4)
            cris.org.in.ima.model.RecentSearchStationModel r6 = (cris.org.in.ima.model.RecentSearchStationModel) r6
            java.lang.String r14 = r6.a
            if (r14 != 0) goto L_0x0552
            java.lang.String r6 = r6.b
            if (r6 == 0) goto L_0x0562
        L_0x0552:
            java.util.ArrayList r6 = r16.i()
            r0.addAll(r6)
            java.util.Collections.reverse(r0)
            goto L_0x0562
        L_0x055d:
            android.widget.TextView r6 = r1.recentSearchHeader
            r6.setVisibility(r13)
        L_0x0562:
            cris.org.in.ima.adaptors.RecentSearchStnAdapter r6 = new cris.org.in.ima.adaptors.RecentSearchStnAdapter
            android.content.Context r14 = r16.getContext()
            cris.org.in.ima.fragment.NewBookingFragment$r r15 = r1.f4853a
            r6.<init>(r14, r0, r15)
            r1.f4849a = r6
            androidx.recyclerview.widget.RecyclerView r0 = r1.recentSearchRecycleview
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r14 = r16.getContext()
            r6.<init>(r14, r4, r4)
            r0.setLayoutManager(r6)
            androidx.recyclerview.widget.RecyclerView r0 = r1.recentSearchRecycleview
            cris.org.in.ima.adaptors.RecentSearchStnAdapter r6 = r1.f4849a
            r0.setAdapter(r6)
            android.content.SharedPreferences r0 = r1.f4845a
            java.lang.String r6 = "firstTime"
            boolean r0 = r0.getBoolean(r6, r4)
            if (r0 != 0) goto L_0x059a
            android.content.SharedPreferences r0 = r1.f4845a
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r6, r7)
            r0.commit()
        L_0x059a:
            java.util.ArrayList<cris.org.in.ima.model.FevJourneyModel> r0 = r1.f4868e
            if (r0 == 0) goto L_0x05aa
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x05aa
            android.widget.RelativeLayout r0 = r1.fav_heading_rl
            r0.setVisibility(r4)
            goto L_0x05af
        L_0x05aa:
            android.widget.RelativeLayout r0 = r1.fav_heading_rl
            r0.setVisibility(r5)
        L_0x05af:
            boolean r0 = r1.f4873g
            if (r0 == 0) goto L_0x06ce
            java.lang.String r0 = z
            if (r0 == 0) goto L_0x05c2
            boolean r0 = r0.equalsIgnoreCase(r12)
            if (r0 != 0) goto L_0x05c2
            java.lang.String r0 = z
            r1.l(r3, r0)
        L_0x05c2:
            java.lang.String r0 = r1.s
            if (r0 == 0) goto L_0x0678
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x0678
            java.lang.String r0 = r1.s
            r0.getClass()
            int r6 = r0.hashCode()
            r12 = -1
            switch(r6) {
                case 1584: goto L_0x063f;
                case 1615: goto L_0x0634;
                case 1633: goto L_0x0629;
                case 1646: goto L_0x061e;
                case 1650: goto L_0x0613;
                case 2144: goto L_0x0608;
                case 2204: goto L_0x05fd;
                case 2206: goto L_0x05f2;
                case 2237: goto L_0x05e9;
                case 2649: goto L_0x05dc;
                default: goto L_0x05d9;
            }
        L_0x05d9:
            r5 = r12
            goto L_0x0649
        L_0x05dc:
            java.lang.String r5 = "SL"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x05e5
            goto L_0x05d9
        L_0x05e5:
            r5 = 9
            goto L_0x0649
        L_0x05e9:
            java.lang.String r6 = "FC"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0649
            goto L_0x05d9
        L_0x05f2:
            java.lang.String r5 = "EC"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x05fb
            goto L_0x05d9
        L_0x05fb:
            r5 = 7
            goto L_0x0649
        L_0x05fd:
            java.lang.String r5 = "EA"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0606
            goto L_0x05d9
        L_0x0606:
            r5 = 6
            goto L_0x0649
        L_0x0608:
            java.lang.String r5 = "CC"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0611
            goto L_0x05d9
        L_0x0611:
            r5 = 5
            goto L_0x0649
        L_0x0613:
            java.lang.String r5 = "3E"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x061c
            goto L_0x05d9
        L_0x061c:
            r5 = r13
            goto L_0x0649
        L_0x061e:
            java.lang.String r5 = "3A"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0627
            goto L_0x05d9
        L_0x0627:
            r5 = r10
            goto L_0x0649
        L_0x0629:
            java.lang.String r5 = "2S"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0632
            goto L_0x05d9
        L_0x0632:
            r5 = r8
            goto L_0x0649
        L_0x0634:
            java.lang.String r5 = "2A"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x063d
            goto L_0x05d9
        L_0x063d:
            r5 = r7
            goto L_0x0649
        L_0x063f:
            java.lang.String r5 = "1A"
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0648
            goto L_0x05d9
        L_0x0648:
            r5 = r4
        L_0x0649:
            switch(r5) {
                case 0: goto L_0x0674;
                case 1: goto L_0x0670;
                case 2: goto L_0x066c;
                case 3: goto L_0x0668;
                case 4: goto L_0x0664;
                case 5: goto L_0x0660;
                case 6: goto L_0x065c;
                case 7: goto L_0x0658;
                case 8: goto L_0x0654;
                case 9: goto L_0x0650;
                default: goto L_0x064c;
            }
        L_0x064c:
            r1.onAllClassClick(r3)
            goto L_0x0684
        L_0x0650:
            r1.onSleeperClassClick(r3)
            goto L_0x0684
        L_0x0654:
            r1.onFirstClassClick(r3)
            goto L_0x0684
        L_0x0658:
            r1.onExecChairClassClick(r3)
            goto L_0x0684
        L_0x065c:
            r1.onAnubhutiClassClick(r3)
            goto L_0x0684
        L_0x0660:
            r1.onACChairClassClick(r3)
            goto L_0x0684
        L_0x0664:
            r1.onAC3EconomyClassClick(r3)
            goto L_0x0684
        L_0x0668:
            r1.onAc3TierClassClick(r3)
            goto L_0x0684
        L_0x066c:
            r1.onSecondSittingClassClick(r3)
            goto L_0x0684
        L_0x0670:
            r1.onAc2TierClassClick(r3)
            goto L_0x0684
        L_0x0674:
            r1.onAcFistClassClick(r3)
            goto L_0x0684
        L_0x0678:
            android.widget.TextView r0 = r1.tv_selectclass
            r5 = 2131952272(0x7f130290, float:1.9540982E38)
            java.lang.String r5 = r1.getString(r5)
            r0.setText(r5)
        L_0x0684:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x06ca }
            r0.<init>(r11)     // Catch:{ Exception -> 0x06ca }
            java.lang.String r5 = r1.f4864d     // Catch:{ Exception -> 0x06ca }
            java.util.Date r0 = r0.parse(r5)     // Catch:{ Exception -> 0x06ca }
            java.util.Calendar r5 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x06ca }
            r5.setTime(r0)     // Catch:{ Exception -> 0x06ca }
            java.util.Date r0 = r5.getTime()     // Catch:{ Exception -> 0x06ca }
            java.util.Date r6 = new java.util.Date     // Catch:{ Exception -> 0x06ca }
            r6.<init>()     // Catch:{ Exception -> 0x06ca }
            boolean r0 = r0.before(r6)     // Catch:{ Exception -> 0x06ca }
            if (r0 != 0) goto L_0x06ce
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x06ca }
            r0.<init>(r11)     // Catch:{ Exception -> 0x06ca }
            java.util.Date r6 = r5.getTime()     // Catch:{ Exception -> 0x06ca }
            java.lang.String r0 = r0.format(r6)     // Catch:{ Exception -> 0x06ca }
            r1.f4861c = r0     // Catch:{ Exception -> 0x06ca }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x06ca }
            r0.<init>(r9)     // Catch:{ Exception -> 0x06ca }
            android.widget.TextView r6 = r1.journeyDate     // Catch:{ Exception -> 0x06ca }
            java.util.Date r5 = r5.getTime()     // Catch:{ Exception -> 0x06ca }
            java.lang.String r0 = r0.format(r5)     // Catch:{ Exception -> 0x06ca }
            r6.setText(r0)     // Catch:{ Exception -> 0x06ca }
            r16.h()     // Catch:{ Exception -> 0x06ca }
            goto L_0x06ce
        L_0x06ca:
            r0 = move-exception
            r0.getMessage()
        L_0x06ce:
            boolean r0 = r1.f4871f
            if (r0 == 0) goto L_0x0757
            java.lang.String r0 = r1.n
            if (r0 == 0) goto L_0x06f0
            java.lang.String r0 = r1.o
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06f0
            android.widget.TextView r0 = r1.fromStnNameID
            java.lang.String r5 = r1.o
            java.lang.String r5 = r2.m(r5)
            r0.setText(r5)
            android.widget.TextView r0 = r1.fromStnCodeID
            java.lang.String r5 = r1.o
            r0.setText(r5)
        L_0x06f0:
            java.lang.String r0 = r1.o
            if (r0 == 0) goto L_0x070e
            java.lang.String r0 = r1.n
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x070e
            android.widget.TextView r0 = r1.toStnNameID
            java.lang.String r5 = r1.n
            java.lang.String r2 = r2.m(r5)
            r0.setText(r2)
            android.widget.TextView r0 = r1.toStnCodeID
            java.lang.String r2 = r1.n
            r0.setText(r2)
        L_0x070e:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0751 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x0751 }
            java.lang.String r2 = r1.y     // Catch:{ Exception -> 0x0751 }
            java.util.Date r0 = r0.parse(r2)     // Catch:{ Exception -> 0x0751 }
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0751 }
            r2.setTime(r0)     // Catch:{ Exception -> 0x0751 }
            java.util.Date r0 = r2.getTime()     // Catch:{ Exception -> 0x0751 }
            java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x0751 }
            r5.<init>()     // Catch:{ Exception -> 0x0751 }
            boolean r0 = r0.before(r5)     // Catch:{ Exception -> 0x0751 }
            if (r0 != 0) goto L_0x0755
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0751 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x0751 }
            java.util.Date r5 = r2.getTime()     // Catch:{ Exception -> 0x0751 }
            java.lang.String r0 = r0.format(r5)     // Catch:{ Exception -> 0x0751 }
            r1.f4861c = r0     // Catch:{ Exception -> 0x0751 }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0751 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x0751 }
            android.widget.TextView r5 = r1.journeyDate     // Catch:{ Exception -> 0x0751 }
            java.util.Date r2 = r2.getTime()     // Catch:{ Exception -> 0x0751 }
            java.lang.String r0 = r0.format(r2)     // Catch:{ Exception -> 0x0751 }
            r5.setText(r0)     // Catch:{ Exception -> 0x0751 }
            goto L_0x0755
        L_0x0751:
            r0 = move-exception
            r0.getMessage()
        L_0x0755:
            r1.f4871f = r4
        L_0x0757:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.NewBookingFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @OnClick({2131362376})
    public void onDayAfterTomorrowClick() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, 2);
        this.f4861c = new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
        ImageView imageView = this.calender;
        FragmentActivity activity = getActivity();
        Object obj = d7.a;
        imageView.setColorFilter(d7.b.a(activity, R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
        lf.t(this, R.color.colorAccent, this.journeyDate);
        lf.t(this, R.color.colorAccent, this.journeyDateLabel);
        this.tomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.tomorrowDate);
        lf.t(this, R.color.colorAccent, this.tomorrowLabel);
        this.dayAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_red_corner));
        lf.t(this, R.color.dark, this.dayAfterTomorrowdate);
        lf.t(this, R.color.dark, this.dayAfterTomorrow_label);
        this.twoDaysAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.twoDaysAfterTomorrowDate);
        lf.t(this, R.color.colorAccent, this.twoDaysAfterTomorrowLabel);
        this.selectJourneyDate.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4844a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4844a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364387})
    public void onDutyPassClick(View view) {
        onRailWayPass();
        m();
        z = getString(R.string.Dutypasscode);
        getString(R.string.duty_pass);
        view.setSelected(true);
        this.select_quota.setText(getString(R.string.duty_pass));
        this.quota_bottom_ll.setVisibility(8);
        this.railway_pass_ll.setClickable(true);
        q(this.dutypass, R.color.dark);
        this.dutypass.setTextAppearance(getActivity(), R.style.fontForbold);
        this.railway_passbooking.setChecked(true);
    }

    @OnClick({2131364400})
    public void onExecChairClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.EC));
        this.s = "EC";
        o();
        this.tv_exec_chair_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_exec_chair_class, R.color.dark);
        this.tv_exec_chair_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131363896})
    public void onFevouriteJourneyLayoutClick(View view) {
        this.select_fevjournet_Rl.setVisibility(8);
    }

    @OnClick({2131364411})
    public void onFirstClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.FC));
        this.s = "FC";
        o();
        this.tv_first_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_first_class, R.color.dark);
        this.tv_first_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131363029})
    public void onFromStationClick(View view) {
        if (this.f4843a.i() == null) {
            r(Constants.MessagePayloadKeys.FROM);
            return;
        }
        Intent intent = new Intent(getActivity(), StationListActivity.class);
        intent.putExtra("stationView", 0);
        intent.putExtra("FromStationHint", this.g);
        intent.putExtra("ToStationHint", this.h);
        intent.putExtra("toStnClickFavFlag", "true");
        startActivityForResult(intent, 0);
    }

    @OnClick({2131364429})
    public void onGeneralClick(View view) {
        m();
        z = getString(R.string.generalCode);
        getString(R.string.generalString);
        this.quota_bottom_ll.setVisibility(8);
        this.select_quota.setText(getString(R.string.generalString));
        this.railway_pass_ll.setClickable(true);
        this.railway_passbooking.setChecked(false);
        q(this.tvGeneral, R.color.dark);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364529})
    public void onHandicapClick(View view) {
        m();
        z = getString(R.string.physicalhandicapCode);
        getString(R.string.DivyangjanString);
        view.setSelected(true);
        this.select_quota.setText(getString(R.string.DivyangjanString));
        this.quota_bottom_ll.setVisibility(8);
        this.SpecialConc.setVisibility(0);
        this.railway_pass_ll.setClickable(false);
        this.railway_passbooking.setChecked(false);
        q(this.phHandicap, R.color.dark);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForbold);
        C0535I5.p(getContext(), false, getResources().getString(R.string.spc_popUp_Msgs), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131363901})
    public void onJourneyDateClick() {
        Calendar instance = Calendar.getInstance();
        this.c = instance.get(1);
        this.d = instance.get(2);
        this.e = instance.get(5);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new l(), this.c, this.d, this.e);
        datePickerDialog.getDatePicker().setMinDate(instance.getTimeInMillis() - 1000);
        String str = "66";
        try {
            String str2 = C1450w1.f7023c.get("CALENDAR_DAYS");
            if (str2 != null) {
                str = str2;
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        instance.add(5, Integer.parseInt(str));
        datePickerDialog.getDatePicker().setMaxDate(instance.getTimeInMillis());
        datePickerDialog.show();
    }

    @OnClick({2131364452})
    public void onLadiesQuotaClick(View view) {
        m();
        z = getString(R.string.ladiesCode);
        getString(R.string.ladiesString);
        view.setSelected(true);
        this.select_quota.setText(getString(R.string.ladiesString));
        this.railway_pass_ll.setClickable(true);
        this.railway_passbooking.setChecked(false);
        this.quota_bottom_ll.setVisibility(8);
        q(this.tvLadies, R.color.dark);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364522})
    public void onParliamentHouseClick(View view) {
        m();
        z = getString(R.string.parliamentHouseCode);
        getString(R.string.parliamentHouseString);
        view.setSelected(true);
        this.select_quota.setText(getString(R.string.parliamentHouseString));
        this.quota_bottom_ll.setVisibility(8);
        this.railway_pass_ll.setVisibility(8);
        this.dutypass.setVisibility(8);
        q(this.parliamentHouse, R.color.dark);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4844a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4844a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364537})
    public void onPremiumTatkalClick(View view) {
        m();
        z = getString(R.string.premiumTatkalCode);
        getString(R.string.premiumTatkalString);
        view.setSelected(true);
        this.select_quota.setText(getString(R.string.premiumTatkalString));
        this.quota_bottom_ll.setVisibility(8);
        this.railway_pass_ll.setClickable(false);
        this.railway_passbooking.setChecked(false);
        q(this.premiumTatkal, R.color.dark);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131363579})
    public void onQuotaLayout() {
        if (this.quota_bottom_ll.getVisibility() == 0) {
            this.quota_bottom_ll.setVisibility(8);
        } else {
            this.quota_bottom_ll.setVisibility(0);
        }
    }

    @OnClick({2131363590})
    public void onRailWayPass() {
        if (!this.railway_passbooking.isChecked()) {
            C0535I5.p(getContext(), false, getResources().getString(R.string.duty_pass_con_mgs), "Confirmation", getString(R.string.no), new i(), getString(R.string.yes), new j()).show();
        }
        if (this.railway_passbooking.isChecked()) {
            n();
            this.railway_passbooking.setChecked(false);
            this.f4878k = "N";
            l = false;
            this.select_quota.setText(getString(R.string.general));
            m();
            this.tvGeneral.setSelected(true);
            q(this.tvGeneral, R.color.dark);
            this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
            return;
        }
        this.f4878k = "S";
        if (k) {
            this.railway_passbooking.setChecked(false);
            l = false;
            return;
        }
        this.railway_passbooking.setChecked(true);
        l = true;
    }

    @OnClick({2131363591})
    public void onRailWayPasscheck() {
        if (!this.railway_passbooking.isChecked()) {
            this.railway_passbooking.setChecked(false);
            this.f4878k = "N";
            l = false;
            this.select_quota.setText(getString(R.string.general));
            m();
            this.tvGeneral.setSelected(true);
            q(this.tvGeneral, R.color.dark);
            this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
            return;
        }
        this.f4878k = "S";
        if (k) {
            this.railway_passbooking.setChecked(false);
            l = false;
            return;
        }
        this.railway_passbooking.setChecked(true);
        l = true;
    }

    public final void onResume() {
        Boolean bool;
        m();
        n();
        this.f4846a.postDelayed(new u(), 1000);
        super.onResume();
        if (!C0535I5.R() || !C1450w1.f7030e) {
            C0535I5.f3636d.clear();
            C0535I5.f3640e.clear();
        } else {
            if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                new Handler().postDelayed(new Gm(), 5000);
            } else {
                ArrayList<FevJourneyModel> arrayList = C0535I5.f3640e;
                this.f4868e = arrayList;
                if (arrayList == null || arrayList.size() == 0) {
                    if (this.f4868e == null) {
                        this.f4868e = new ArrayList<>();
                    }
                    ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.loading), getString(R.string.please_wait_text));
                    ((Om) C0657Qt.c(C0793b1.a.f3912a)).Y(C0657Qt.f() + "fetchJourneyDetails").c(C1181iv.a()).a(E0.a()).b(new C1012a0(this, show));
                } else {
                    this.fav_heading_rl.setVisibility(0);
                    this.rv_Favourty.setVisibility(0);
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<FevJourneyModel> it = this.f4868e.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        FevJourneyModel next = it.next();
                        if (i2 > 7) {
                            break;
                        }
                        i2++;
                        arrayList2.add(next);
                    }
                    this.f4848a = new FavourtyListJPPageAdapter(getContext(), arrayList2, this.f4851a);
                    this.rv_Favourty.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                    this.rv_Favourty.setAdapter(this.f4848a);
                }
            }
            if (C1450w1.f7024c) {
                z = getString(R.string.parliamentHouseCode);
            }
            String str = z;
            if (str != null && !str.equalsIgnoreCase("")) {
                l(getView(), z);
            }
        }
        if (C0535I5.R()) {
            if (C0535I5.f3630b) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                C0535I5.b bVar = C0535I5.f3616a;
                if (bVar == null || (bool = bVar.a) == null || !bool.booleanValue()) {
                    C0535I5.f3616a.a = Boolean.FALSE;
                } else {
                    this.lastTransationDtail.setVisibility(0);
                    this.last_txn_layout.setVisibility(0);
                    this.last_txn_ll.setVisibility(0);
                    this.transationNumber.setText(String.valueOf(C0535I5.f3616a.f3653a));
                    this.bkgStatus.setText(String.valueOf(C0535I5.f3616a.f3654a));
                    String[] split = String.valueOf(simpleDateFormat.format(C0535I5.f3616a.f3655a)).split(" ");
                    this.lastTransationTimeStamp.setText(split[0] + "," + split[1] + "Hrs");
                    C0535I5.f3630b = false;
                }
            }
            HomeActivity.p();
        } else {
            HomeActivity.I();
        }
        if (C1450w1.f7024c && !this.f4873g) {
            z = getString(R.string.parliamentHouseCode);
        }
        String str2 = z;
        if (str2 != null && !str2.equalsIgnoreCase("")) {
            l(getView(), z);
        }
        if (C1450w1.f7024c) {
            this.parliamentHouse.setVisibility(0);
            this.railway_pass_ll.setVisibility(8);
            this.connectingJourneyLl.setVisibility(8);
            this.SpecialConc.setVisibility(8);
        } else {
            this.parliamentHouse.setVisibility(8);
            this.SpecialConc.setVisibility(0);
            this.railway_pass_ll.setVisibility(0);
            this.connectingJourneyLl.setVisibility(0);
        }
        if (C1450w1.f7014a) {
            this.connectingJourneyLl.setVisibility(0);
        } else {
            this.connectingJourneyLl.setVisibility(8);
        }
    }

    @OnClick({2131364586})
    public void onSearchClick() {
        try {
            if (!this.f4858a) {
                this.f4858a = true;
                s();
                new C0816cB(new n(), 3000).a();
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131364589})
    public void onSecondSittingClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.two_s));
        this.s = "2S";
        o();
        this.tv_second_sitting_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_second_sitting_class, R.color.dark);
        this.tv_second_sitting_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364597})
    public void onSeniorCitizenClick(View view) {
        m();
        z = getString(R.string.seniorCitizenCode);
        getString(R.string.seniorCitizenString);
        view.setSelected(true);
        this.select_quota.setText(getString(R.string.seniorCitizenString));
        this.railway_pass_ll.setClickable(true);
        this.railway_passbooking.setChecked(false);
        this.quota_bottom_ll.setVisibility(8);
        q(this.seniorCitizen, R.color.dark);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForbold);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
        String str = z;
        if (str == null || !this.f4873g) {
            C0535I5.p(getContext(), false, getResources().getString(R.string.senior_citizen_msg), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        } else if (str.equalsIgnoreCase("SS")) {
            C0535I5.p(getContext(), false, getResources().getString(R.string.senior_citizen_msg), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).hide();
        }
    }

    @OnClick({2131364602})
    public void onSleeperClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.SL));
        this.s = "SL";
        o();
        this.tv_sleeper_class.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_sleeper_class, R.color.dark);
        this.tv_sleeper_class.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131363984})
    public void onSpcConcessionClick() {
        if (!this.specialConcessioncheckbox.isChecked()) {
            this.specialConcessioncheckbox.setChecked(false);
            this.f4878k = "N";
            return;
        }
        this.specialConcessioncheckbox.setChecked(true);
        this.journalistbooking.setChecked(false);
        this.f4878k = "Y";
        this.f4860b = true;
        this.f4863c = false;
        C0535I5.f3638d = true;
        C0535I5.f3641e = false;
        C0535I5.p(getActivity(), false, getString(R.string.spc_popUp_Msgs), getString(R.string.confirmation), getString(R.string.ok), new a(), "", new b()).show();
    }

    @OnClick({2131363365})
    public void onSpecialConc() {
        if (this.specialConcessioncheckbox.isChecked()) {
            this.specialConcessioncheckbox.setChecked(false);
            this.f4878k = "N";
            return;
        }
        this.specialConcessioncheckbox.setChecked(true);
        this.journalistbooking.setChecked(false);
        this.f4860b = true;
        this.f4863c = false;
        C0535I5.f3638d = true;
        C0535I5.f3641e = false;
        this.f4878k = "Y";
        C0535I5.p(getActivity(), false, getString(R.string.spc_popUp_Msgs), getString(R.string.confirmation), getString(R.string.ok), new c(), "", new d()).show();
    }

    @OnClick({2131364032})
    public void onStnRotationClick() {
        if (!this.fromStnNameID.getText().toString().equals("") && this.fromStnNameID.getText().toString() != null && !this.toStnNameID.getText().toString().equals("") && this.toStnNameID.getText().toString() != null) {
            String charSequence = this.fromStnNameID.getText().toString();
            String charSequence2 = this.fromStnCodeID.getText().toString();
            this.fromStnNameID.setText(this.toStnNameID.getText().toString());
            this.toStnNameID.setText(charSequence);
            this.fromStnCodeID.setText(this.toStnCodeID.getText().toString());
            this.toStnCodeID.setText(charSequence2);
            this.g = this.fromStnCodeID.getText().toString() + "-" + this.fromStnNameID.getText().toString();
            this.h = this.toStnCodeID.getText().toString() + "-" + this.toStnNameID.getText().toString();
        }
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4844a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4844a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364655})
    public void onTatkalClick(View view) {
        m();
        z = getString(R.string.tatkalCode);
        getString(R.string.tatkalString);
        view.setSelected(true);
        this.railway_pass_ll.setClickable(false);
        this.railway_passbooking.setChecked(false);
        this.select_quota.setText(getString(R.string.tatkalString));
        this.quota_bottom_ll.setVisibility(8);
        this.SpecialConc.setVisibility(0);
        q(this.tvTatkal, R.color.dark);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131363089})
    public void onToStationClick(View view) {
        if (this.f4843a.i() == null) {
            r("to");
            return;
        }
        Intent intent = new Intent(getActivity(), StationListActivity.class);
        intent.putExtra("stationView", 1);
        intent.putExtra("FromStationHint", this.g);
        intent.putExtra("ToStationHint", this.h);
        intent.putExtra("toStnClickFavFlag", "false");
        startActivityForResult(intent, 1);
    }

    @OnClick({2131364177})
    public void onTomorrowClick() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, 1);
        this.f4861c = new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
        ImageView imageView = this.calender;
        FragmentActivity activity = getActivity();
        Object obj = d7.a;
        imageView.setColorFilter(d7.b.a(activity, R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
        lf.t(this, R.color.colorAccent, this.journeyDate);
        lf.t(this, R.color.colorAccent, this.journeyDateLabel);
        this.tomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_red_corner));
        lf.t(this, R.color.dark, this.tomorrowDate);
        lf.t(this, R.color.dark, this.tomorrowLabel);
        this.dayAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.dayAfterTomorrowdate);
        lf.t(this, R.color.colorAccent, this.dayAfterTomorrow_label);
        this.twoDaysAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.twoDaysAfterTomorrowDate);
        lf.t(this, R.color.colorAccent, this.twoDaysAfterTomorrowLabel);
        this.selectJourneyDate.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
    }

    @OnClick({2131364736})
    public void onTwoDaysAfterTomorrowClick() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, 3);
        this.f4861c = new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
        ImageView imageView = this.calender;
        FragmentActivity activity = getActivity();
        Object obj = d7.a;
        imageView.setColorFilter(d7.b.a(activity, R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
        lf.t(this, R.color.colorAccent, this.journeyDate);
        lf.t(this, R.color.colorAccent, this.journeyDateLabel);
        this.tomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.tomorrowDate);
        lf.t(this, R.color.colorAccent, this.tomorrowLabel);
        this.dayAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        lf.t(this, R.color.colorAccent, this.dayAfterTomorrowdate);
        lf.t(this, R.color.colorAccent, this.dayAfterTomorrow_label);
        this.twoDaysAfterTomorrow.setBackground(d7.a.b(getActivity(), R.drawable.round_red_corner));
        lf.t(this, R.color.dark, this.twoDaysAfterTomorrowDate);
        lf.t(this, R.color.dark, this.twoDaysAfterTomorrowLabel);
        this.selectJourneyDate.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
    }

    @OnClick({2131364288})
    public void onViewAllFevouriteJourneyClick(View view) {
        C0535I5.f3640e.clear();
        HomeActivity.n((AppCompatActivity) getActivity(), new FevouriteJourneyFragment(), C1218kf.FAV_JOURNEY.a(), Boolean.TRUE, Boolean.FALSE);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        aVar.n(this);
        aVar.c();
    }

    @OnClick({2131364728})
    public void onVistadomeChairCarClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.vistadome_chair_car));
        this.s = "VC";
        o();
        this.tv_vistadome_chair_car.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_vistadome_chair_car, R.color.dark);
        this.tv_vistadome_chair_car.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364727})
    public void onVistadomeClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.vistadome_ac));
        this.s = "EV";
        o();
        this.tv_vistadome_ac.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_vistadome_ac, R.color.dark);
        this.tv_vistadome_ac.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131364729})
    public void onVistadomeNonAcClassClick(View view) {
        this.tv_selectclass.setText(getString(R.string.vistadome_non_ac));
        this.s = "VS";
        o();
        this.tv_vistadome_non_ac.setSelected(true);
        this.class_bottom_rl.setVisibility(8);
        q(this.tv_vistadome_non_ac, R.color.dark);
        this.tv_vistadome_non_ac.setTextAppearance(getActivity(), R.style.fontForbold);
    }

    @OnClick({2131363367})
    public void onflexiableDateClick() {
        if (this.flexiableDate.isChecked()) {
            this.flexiableDate.setChecked(false);
            this.j = "N";
            return;
        }
        this.flexiableDate.setChecked(true);
        this.j = "Y";
    }

    @OnClick({2131362918})
    public void onjournachocklist() {
        if (!this.journalistbooking.isChecked()) {
            this.journalistbooking.setChecked(false);
            this.f4878k = "N";
            return;
        }
        this.journalistbooking.setChecked(true);
        this.specialConcessioncheckbox.setChecked(false);
        this.f4878k = "Y";
        this.f4860b = false;
        this.f4863c = true;
        C0535I5.f3641e = true;
        C0535I5.f3638d = false;
        C0535I5.p(getActivity(), false, getString(R.string.journalist_booking), getString(R.string.confirmation), getString(R.string.ok), new g(), "", new h()).show();
    }

    @OnClick({2131362919})
    public void onjournalist() {
        if (this.journalistbooking.isChecked()) {
            this.journalistbooking.setChecked(false);
            this.f4878k = "N";
            return;
        }
        this.journalistbooking.setChecked(true);
        this.specialConcessioncheckbox.setChecked(false);
        this.f4878k = "Y";
        this.f4860b = false;
        this.f4863c = true;
        C0535I5.f3641e = true;
        C0535I5.f3638d = false;
        C0535I5.p(getActivity(), false, getString(R.string.journalist_booking), getString(R.string.confirmation), getString(R.string.ok), new e(), "", new f()).show();
    }

    public final void p(ArrayList<String> arrayList) {
        String str;
        Iterator<String> it = arrayList.iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = xx.D(str2, ", ", it.next());
        }
        if (str2.equalsIgnoreCase("")) {
            str = getString(R.string.select_class);
        } else {
            str = str2.substring(1, str2.length());
        }
        this.tv_selectclass.setText(str);
    }

    public final void q(TextView textView, int i2) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i2), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void r(String str) {
        ProgressDialog show = ProgressDialog.show(getContext(), getString(R.string.loading_only), getString(R.string.fetching_details_dashboard), false, false);
        show.show();
        k kVar = new k(str, show);
        this.f4850a = kVar;
        kVar.start();
    }

    public final void s() {
        Om om;
        if ((this.f4866d && this.specialConcessioncheckbox.isChecked()) || this.trainAvailableBerth.isChecked() || this.connectingJourney.isChecked()) {
            this.f4866d = false;
            this.f4855a = null;
        }
        boolean M = C0535I5.M();
        if (!M || C0535I5.R()) {
            if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                new Handler().postDelayed(new o(), 5000);
                return;
            }
            String str = this.g;
            if (str == null || this.h == null || str.equals("") || this.h.equals("")) {
                C0535I5.m(getActivity(), false, getResources().getString(R.string.station_selection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
            this.f4867e = this.fromStnCodeID.getText().toString().trim();
            this.f = this.toStnCodeID.getText().toString().trim();
            if (this.f4866d && !this.f4867e.trim().equalsIgnoreCase(this.f4879l.trim()) && !this.f.trim().equalsIgnoreCase(this.m.trim())) {
                this.f4866d = false;
            }
            C0793b1 b1Var = C0793b1.a;
            StationDb stationDb = b1Var.f3911a;
            try {
                String str2 = this.f4867e;
                int i2 = 0;
                for (int i3 = 0; i3 < str2.length(); i3++) {
                    if (Character.isLetter(str2.charAt(i3))) {
                        i2++;
                    }
                }
                String str3 = this.f;
                int i4 = 0;
                for (int i5 = 0; i5 < str3.length(); i5++) {
                    if (Character.isLetter(str3.charAt(i5))) {
                        i4++;
                    }
                }
                if (i2 <= 4 && i4 <= 4) {
                    stationDb.r(this.g.trim(), this.h.trim());
                    stationDb.q(this.fromStnNameID.getText().toString().trim(), this.f4867e.trim());
                    stationDb.q(this.toStnNameID.getText().toString().trim(), this.f.trim());
                    j((this.f4867e + "-" + this.fromStnNameID.getText().toString()).trim(), (this.f + "-" + this.toStnNameID.getText().toString()).trim(), this.f4861c, this.tv_selectclass.getText().toString().trim(), this.s);
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
            try {
                if (z.equalsIgnoreCase("TQ") || z.equalsIgnoreCase("PT")) {
                    if ((new SimpleDateFormat("yyyyMMdd").parse(this.f4861c).getTime() - Calendar.getInstance().getTime().getTime()) / 86400000 > 4) {
                        C0535I5.o(getActivity(), getString(R.string.TQ_pt_message_first) + " " + this.x + " " + getString(R.string.TQ_pt_message_second), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                }
            } catch (Exception e3) {
                e3.getMessage();
            }
            try {
                ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.train_Search), getString(R.string.please_wait_text));
                this.f4844a = show;
                show.show();
                C1469x0 x0Var = new C1469x0();
                x0Var.setDestStn(this.f);
                x0Var.setSrcStn(this.f4867e);
                x0Var.setJrnyDate(this.f4861c);
                x0Var.setJrnyClass(this.s);
                x0Var.setQuotaCode(z);
                x0Var.setFlexiJrnyDate(this.f4861c);
                x0Var.setFlexiFlag(this.flexiableDate.isChecked());
                x0Var.setTicketType("E");
                Boolean bool = Boolean.FALSE;
                x0Var.setHandicapFlag(bool);
                x0Var.setLoyaltyRedemptionBooking(bool);
                x0Var.setFtBooking(false);
                x0Var.setCurrentBooking(bool);
                if (!M) {
                    if (!C0535I5.R()) {
                        om = (Om) C0657Qt.b();
                        om.b(x0Var, "TC").c(C1181iv.a()).a(E0.a()).b(new p());
                    }
                }
                om = (Om) C0657Qt.c(b1Var.f3912a);
                om.b(x0Var, "TC").c(C1181iv.a()).a(E0.a()).b(new p());
            } catch (Exception e4) {
                e4.getMessage();
                this.f4844a.dismiss();
                C0535I5.t0(getActivity(), getString(R.string.please_try_again));
            }
        } else if (C1450w1.f7005a == 2) {
            HomeActivity.A(2);
        } else {
            HomeActivity.A(1);
        }
    }

    @OnClick({2131364590})
    public void selectFevJourneylistClicl() {
        this.select_fevjournet_Rl.setVisibility(0);
        Toast.makeText(getContext(), getString(R.string.no_data), 1).show();
    }

    @OnClick({2131364189})
    public void trainAvailableBerthChClick() {
        if (!this.trainAvailableBerth.isChecked()) {
            this.trainAvailableBerth.setChecked(false);
        } else {
            this.trainAvailableBerth.setChecked(true);
        }
    }

    @OnClick({2131364190})
    public void trainAvailableBerthLlClick() {
        if (this.trainAvailableBerth.isChecked()) {
            this.trainAvailableBerth.setChecked(false);
        } else {
            this.trainAvailableBerth.setChecked(true);
        }
    }

    public class o implements Runnable {
        public final void run() {
        }
    }

    public class a implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
