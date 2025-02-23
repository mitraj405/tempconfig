package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.FareBreakupActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.LapTrainListAdapter;
import cris.org.in.ima.adaptors.QuotaSelectionAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.AvlClassModel;
import cris.org.in.ima.model.QuotaModel;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.ClassAvlDTO;
import cris.prs.webservices.dto.JourneyDetailDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import rx.Subscriber;

public class LapAllTrainListFragment extends Fragment {
    public static RelativeLayout a;

    /* renamed from: a  reason: collision with other field name */
    public static TextView f4690a;

    /* renamed from: a  reason: collision with other field name */
    public static FragmentActivity f4691a;

    /* renamed from: a  reason: collision with other field name */
    public static RecyclerView f4692a;

    /* renamed from: a  reason: collision with other field name */
    public static TrainBtwnStnsModel f4693a;

    /* renamed from: a  reason: collision with other field name */
    public static AvlFareResponseDTO f4694a;
    public static boolean e;
    public static boolean f;
    public static String h = null;
    public static String i = null;
    public static String j;
    public static String k = "";
    public static String l;
    public static String m;
    @BindView(2131361794)
    LinearLayout Allclass_ll;

    /* renamed from: a  reason: collision with other field name */
    public Cf f4695a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4696a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4697a;

    /* renamed from: a  reason: collision with other field name */
    public LapTrainListAdapter f4698a;

    /* renamed from: a  reason: collision with other field name */
    public QuotaSelectionAdapter f4699a;

    /* renamed from: a  reason: collision with other field name */
    public final k f4700a;

    /* renamed from: a  reason: collision with other field name */
    public JourneyDetailDTO f4701a;

    /* renamed from: a  reason: collision with other field name */
    public C1060d2 f4702a;

    /* renamed from: a  reason: collision with other field name */
    public C1081e2 f4703a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f4704a = Boolean.FALSE;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4705a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, String> f4706a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public List<String> f4707a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4708a = false;
    @BindView(2131364290)
    TextView alterTrainListShow;
    @BindView(2131361957)
    TextView arrival;
    @BindView(2131362011)
    RecyclerView availabilityView;
    public final ArrayList b = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    public List<TrainBtwnStnsModel> f4709b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4710b = true;
    @BindView(2131362070)
    LinearLayout bottomFareAndButtonLayout;
    public String c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4711c;

    /* renamed from: c  reason: collision with other field name */
    public List<TrainBtwnStnsModel> f4712c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4713c = true;
    @BindView(2131362147)
    CheckBox cbclass;
    @BindView(2131362164)
    CheckBox ch_duranto;
    @BindView(2131362165)
    CheckBox ch_earlyMorning;
    @BindView(2131362166)
    CheckBox ch_garibrath;
    @BindView(2131362167)
    CheckBox ch_janshatabdi;
    @BindView(2131362168)
    CheckBox ch_midDay;
    @BindView(2131362169)
    CheckBox ch_morning;
    @BindView(2131362170)
    CheckBox ch_night;
    @BindView(2131362171)
    CheckBox ch_others;
    @BindView(2131362172)
    CheckBox ch_rajdhani;
    @BindView(2131362173)
    CheckBox ch_shatabdi;
    @BindView(2131362174)
    CheckBox ch_special_tatkal;
    @BindView(2131362175)
    CheckBox ch_special_train;
    @BindView(2131362176)
    CheckBox ch_suvidha_train;
    @BindView(2131362177)
    CheckBox ch_yuva_express;
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
    public String d;

    /* renamed from: d  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4714d;

    /* renamed from: d  reason: collision with other field name */
    public List<JourneyDetailDTO> f4715d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f4716d;
    @BindView(2131362388)
    TextView departure;
    @BindView(2131364364)
    TextView departureFrom;
    @BindView(2131362460)
    ImageView duranto_img;
    @BindView(2131362463)
    RelativeLayout duronto_rl;

    /* renamed from: e  reason: collision with other field name */
    public String f4717e;
    @BindView(2131362466)
    LinearLayout earlyMorning_ll;

    /* renamed from: f  reason: collision with other field name */
    public String f4718f;
    @BindView(2131362632)
    TextView fare_backup;
    @BindView(2131362660)
    ImageView filter;
    @BindView(2131362662)
    RelativeLayout filter_ll;
    @BindView(2131362663)
    LinearLayout filter_ll_ll;
    @BindView(2131362664)
    ScrollView filter_ll_scroll;
    public String g;
    @BindView(2131362724)
    ImageView garibrath_img;
    @BindView(2131362725)
    RelativeLayout garibrath_rl;
    @BindView(2131363441)
    TextView goTopassangerDetail;
    @BindView(2131362776)
    RelativeLayout hide_ll;
    @BindView(2131364532)
    EditText inputPnr;
    @BindView(2131362916)
    ImageView janshatabdi_img;
    @BindView(2131362917)
    RelativeLayout janshatabdi_rl;
    @BindView(2131363166)
    RelativeLayout mainLayoutSortAndFilter;
    @BindView(2131363221)
    LinearLayout midDay_ll;
    @BindView(2131363244)
    LinearLayout morning_ll;
    @BindView(2131363320)
    LinearLayout night_ll;
    @BindView(2131363395)
    RelativeLayout others_rl;
    @BindView(2131364520)
    EditText otp;
    @BindView(2131363044)
    LinearLayout otpLayout;
    @BindView(2131364522)
    TextView parliamentHouse;
    @BindView(2131363443)
    LinearLayout passangerDetailLl;
    @BindView(2131364529)
    TextView phHandicap;
    @BindView(2131363515)
    RelativeLayout pnr_input_bottom_rl;
    @BindView(2131364537)
    TextView premiumTatkal;
    @BindView(2131363562)
    AdManagerAdView publisherAdViewbottom;
    @BindView(2131363775)
    AdManagerAdView publisherAdViewbottomrout_map;
    @BindView(2131363563)
    AdManagerAdView publisherAdViewcenter;
    @BindView(2131363561)
    AdManagerAdView publisherAdViewtop;
    @BindView(2131363829)
    RecyclerView quotaRecyclerView;
    @BindView(2131363578)
    LinearLayout quota_bottom;
    @BindView(2131363579)
    RelativeLayout quota_bottom_ll;
    @BindView(2131363592)
    ImageView rajdhani_img;
    @BindView(2131363593)
    RelativeLayout rajdhani_rl;
    @BindView(2131363777)
    RelativeLayout route_rl;
    @BindView(2131364597)
    TextView seniorCitizen;
    @BindView(2131363956)
    ImageView shatabdi_img;
    @BindView(2131363957)
    RelativeLayout shatabdi_rl;
    @BindView(2131363977)
    LinearLayout sortby_bottom;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;
    @BindView(2131363992)
    ImageView special_tatkal_img;
    @BindView(2131363993)
    RelativeLayout special_tatkal_rl;
    @BindView(2131363994)
    ImageView special_trian_img;
    @BindView(2131363995)
    RelativeLayout special_trian_rl;
    @BindView(2131364028)
    TextView status;
    @BindView(2131364623)
    TextView submit;
    @BindView(2131364045)
    ImageView suvidha_train_img;
    @BindView(2131364046)
    RelativeLayout suvidha_train_rl;
    @BindView(2131364184)
    TextView totalFare;
    @BindView(2131364185)
    LinearLayout totalFareLl;
    @BindView(2131364191)
    RecyclerView trainClassRecyclerView;
    @BindView(2131363127)
    RecyclerView trainList;
    @BindView(2131363128)
    RecyclerView trainListAternate;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364688)
    TextView trainNo;
    @BindView(2131363093)
    LinearLayout trainSeatAvailabilityLayout;
    @BindView(2131364206)
    TextView trainTypeHeading;
    @BindView(2131364200)
    AdManagerAdView train_list_filter;
    @BindView(2131364247)
    TextView travelTime;
    @BindView(2131364429)
    TextView tvGeneral;
    @BindView(2131364452)
    TextView tvLadies;
    @BindView(2131364655)
    TextView tvTatkal;
    @BindView(2131364289)
    TextView tv_alter_train_list_msg;
    @BindView(2131364354)
    TextView tv_continue;
    @BindView(2131364923)
    ImageView yuva_express_img;
    @BindView(2131364924)
    RelativeLayout yuva_express_rl;

    public class a implements Comparator<TrainBtwnStnsModel> {
        public a() {
        }

        public final int compare(Object obj, Object obj2) {
            TrainBtwnStnsModel trainBtwnStnsModel = (TrainBtwnStnsModel) obj;
            TrainBtwnStnsModel trainBtwnStnsModel2 = (TrainBtwnStnsModel) obj2;
            if (!LapAllTrainListFragment.this.f4710b) {
                if (trainBtwnStnsModel.f5342a.getArrivalTime().compareTo(trainBtwnStnsModel2.f5342a.getArrivalTime()) > 0) {
                    return 1;
                }
            } else if (trainBtwnStnsModel.f5342a.getArrivalTime().compareTo(trainBtwnStnsModel2.f5342a.getArrivalTime()) < 0) {
                return 1;
            }
            return -1;
        }
    }

    public class b implements Comparator<TrainBtwnStnsModel> {
        public b() {
        }

        public final int compare(Object obj, Object obj2) {
            TrainBtwnStnsModel trainBtwnStnsModel = (TrainBtwnStnsModel) obj;
            TrainBtwnStnsModel trainBtwnStnsModel2 = (TrainBtwnStnsModel) obj2;
            if (!LapAllTrainListFragment.this.f4713c) {
                if (trainBtwnStnsModel.f5342a.getDuration().compareTo(trainBtwnStnsModel2.f5342a.getDuration()) > 0) {
                    return 1;
                }
            } else if (trainBtwnStnsModel.f5342a.getDuration().compareTo(trainBtwnStnsModel2.f5342a.getDuration()) < 0) {
                return 1;
            }
            return -1;
        }
    }

    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1100f2 f4719a;

        public c(C1100f2 f2Var) {
            this.f4719a = f2Var;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            LapAllTrainListFragment.this.k(this.f4719a);
        }
    }

    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1100f2 f4720a;

        public d(C1100f2 f2Var) {
            this.f4720a = f2Var;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            LapAllTrainListFragment.this.k(this.f4720a);
        }
    }

    public class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1100f2 f4721a;

        public e(C1100f2 f2Var) {
            this.f4721a = f2Var;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            LapAllTrainListFragment.this.o(this.f4721a);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class g implements LapTrainListAdapter.Lap2TrainListHAdapterListener {
        public g() {
        }

        public final void onCheckAvailbialityClick(TrainBtwnStnsModel trainBtwnStnsModel) {
            String str;
            LapAllTrainListFragment lapAllTrainListFragment = LapAllTrainListFragment.this;
            lapAllTrainListFragment.bottomFareAndButtonLayout.setVisibility(8);
            if (C0535I5.f3647h && !C0535I5.f3648i && (str = C0535I5.g) != null) {
                C0535I5.o(lapAllTrainListFragment.f4697a, str, lapAllTrainListFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            }
        }

        public final void onQuotaClick(TrainBtwnStnsModel trainBtwnStnsModel) {
            LapAllTrainListFragment lapAllTrainListFragment = LapAllTrainListFragment.this;
            Iterator it = lapAllTrainListFragment.b.iterator();
            while (it.hasNext()) {
                QuotaModel quotaModel = (QuotaModel) it.next();
                quotaModel.a = Boolean.FALSE;
                if (quotaModel.c.equalsIgnoreCase(trainBtwnStnsModel.d)) {
                    quotaModel.a = Boolean.TRUE;
                }
            }
            lapAllTrainListFragment.f4699a.notifyDataSetChanged();
            lapAllTrainListFragment.quota_bottom_ll.setVisibility(0);
            lapAllTrainListFragment.quotaRecyclerView.setVisibility(0);
            LapAllTrainListFragment.f4693a = trainBtwnStnsModel;
        }

        public final void onTrainLayoutClick(TrainBtwnStnsModel trainBtwnStnsModel, boolean z, boolean z2) {
            Boolean bool = Boolean.TRUE;
            LapAllTrainListFragment lapAllTrainListFragment = LapAllTrainListFragment.this;
            lapAllTrainListFragment.f4704a = bool;
            lapAllTrainListFragment.getClass();
            String str = trainBtwnStnsModel.f5348c;
            lapAllTrainListFragment.getClass();
            lapAllTrainListFragment.bottomFareAndButtonLayout.setVisibility(8);
            TrainBtwnStnsDTO trainBtwnStnsDTO = trainBtwnStnsModel.f5342a;
            if (trainBtwnStnsDTO.getClassAvlDTO() != null) {
                for (ClassAvlDTO next : trainBtwnStnsDTO.getClassAvlDTO()) {
                    if (next.getErrorMessage() == null && next.getEnqClass().equalsIgnoreCase(trainBtwnStnsModel.f5348c)) {
                        C1060d2 d2Var = next.getAvlDayList().get(0);
                        FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
                        AvlFareResponseDTO avlFareResponseDTO = new AvlFareResponseDTO();
                        avlFareResponseDTO.setBaseFare(next.getBaseFare());
                        avlFareResponseDTO.setReservationCharge(next.getReservationCharge());
                        avlFareResponseDTO.setSuperfastCharge(next.getSuperfastCharge());
                        avlFareResponseDTO.setTatkalFare(next.getTatkalFare());
                        avlFareResponseDTO.setServiceTax(next.getServiceTax());
                        avlFareResponseDTO.setCateringCharge(next.getCateringCharge());
                        avlFareResponseDTO.setTotalFare(next.getTotalFare());
                        avlFareResponseDTO.setDynamicFare(next.getDynamicFare());
                        avlFareResponseDTO.setInformationMessage((ArrayList) next.getInformationMessage());
                        LapAllTrainListFragment.f4694a = avlFareResponseDTO;
                        lapAllTrainListFragment.bottomFareAndButtonLayout.setVisibility(0);
                    }
                }
            } else {
                lapAllTrainListFragment.bottomFareAndButtonLayout.setVisibility(8);
            }
            Integer num = 0;
            Iterator<TrainBtwnStnsModel> it = lapAllTrainListFragment.f4714d.iterator();
            while (it.hasNext()) {
                TrainBtwnStnsModel next2 = it.next();
                if (next2.f5342a.getClassAvlDTO() != null) {
                    for (ClassAvlDTO next3 : next2.f5342a.getClassAvlDTO()) {
                        if (next3.getErrorMessage() == null && next3.getEnqClass().equalsIgnoreCase(next2.f5348c)) {
                            num = Integer.valueOf(next3.getTotalFare().intValue() + num.intValue());
                        }
                    }
                }
            }
            if (num.intValue() > 0) {
                lapAllTrainListFragment.totalFareLl.setVisibility(0);
                TextView textView = lapAllTrainListFragment.totalFare;
                textView.setText("₹ " + num);
            }
        }
    }

    public class i extends Subscriber<Z2> {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1100f2 f4722a;

        public i(C1100f2 f2Var) {
            this.f4722a = f2Var;
        }

        public final void onCompleted() {
            FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
        }

        public final void onError(Throwable th) {
            LapAllTrainListFragment.this.f4696a.dismiss();
            FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
            xx.S(th, true, th);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0319, code lost:
            if (r0.getBkgCfgs().get(0).getAcuralBooking().booleanValue() != false) goto L_0x031b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0323 A[SYNTHETIC, Splitter:B:82:0x0323] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                r0 = r20
                Z2 r0 = (defpackage.Z2) r0
                java.lang.String r2 = "IN"
                java.lang.String r3 = "India"
                java.lang.String r4 = "Show all"
                cris.org.in.ima.fragment.LapAllTrainListFragment r6 = cris.org.in.ima.fragment.LapAllTrainListFragment.this
                if (r0 == 0) goto L_0x03c5
                defpackage.C0657Qt.h()
                java.lang.String r7 = r0.getErrorMessage()     // Catch:{ Exception -> 0x03a0 }
                if (r7 != 0) goto L_0x037c
                java.util.ArrayList<java.lang.String> r7 = r6.f4705a     // Catch:{ Exception -> 0x03a0 }
                r7.clear()     // Catch:{ Exception -> 0x03a0 }
                java.util.HashMap<java.lang.String, java.lang.String> r7 = r6.f4706a
                r7.clear()     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList r8 = r0.getBoardingStationList()     // Catch:{ Exception -> 0x03a0 }
                java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x03a0 }
            L_0x002b:
                boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x03a0 }
                if (r9 == 0) goto L_0x005c
                java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x03a0 }
                Z2$a r9 = (defpackage.Z2.a) r9     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList<java.lang.String> r10 = r6.f4705a     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r11 = r9.getStnNameCode()     // Catch:{ Exception -> 0x03a0 }
                r10.add(r11)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r10 = r9.getStnNameCode()     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r11 = r9.getStnNameCode()     // Catch:{ Exception -> 0x03a0 }
                r12 = 45
                int r11 = r11.indexOf(r12)     // Catch:{ Exception -> 0x03a0 }
                int r11 = r11 + 2
                java.lang.String r10 = r10.substring(r11)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r9 = r9.getStnNameCode()     // Catch:{ Exception -> 0x03a0 }
                r7.put(r10, r9)     // Catch:{ Exception -> 0x03a0 }
                goto L_0x002b
            L_0x005c:
                java.util.Calendar r7 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x03a0 }
                java.util.Date r8 = r0.getTimeStamp()     // Catch:{ Exception -> 0x03a0 }
                long r8 = r8.getTime()     // Catch:{ Exception -> 0x03a0 }
                r7.setTimeInMillis(r8)     // Catch:{ Exception -> 0x03a0 }
                r8 = 11
                int r8 = r7.get(r8)     // Catch:{ Exception -> 0x03a0 }
                int r8 = r8 * 60
                r9 = 12
                int r9 = r7.get(r9)     // Catch:{ Exception -> 0x03a0 }
                int r8 = r8 + r9
                int r8 = r8 * 60
                r9 = 13
                int r9 = r7.get(r9)     // Catch:{ Exception -> 0x03a0 }
                int r8 = r8 + r9
                int r8 = r8 * 1000
                r9 = 14
                int r7 = r7.get(r9)     // Catch:{ Exception -> 0x03a0 }
                int r8 = r8 + r7
                long r7 = (long) r8     // Catch:{ Exception -> 0x03a0 }
                defpackage.C1450w1.f = r7     // Catch:{ Exception -> 0x03a0 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x03a0 }
                defpackage.C1450w1.f7020c = r7     // Catch:{ Exception -> 0x03a0 }
                Z2 r7 = new Z2     // Catch:{ Exception -> 0x03a0 }
                r7.<init>()     // Catch:{ Exception -> 0x03a0 }
                java.util.List r8 = r0.getBkgCfgs()     // Catch:{ Exception -> 0x03a0 }
                r7.setBkgCfgs(r8)     // Catch:{ Exception -> 0x03a0 }
                r0.getBkgCfgs()     // Catch:{ Exception -> 0x03a0 }
                java.util.HashMap<java.lang.String, java.lang.String> r8 = defpackage.C0535I5.f3628b     // Catch:{ Exception -> 0x03a0 }
                java.util.HashMap<java.lang.String, java.lang.String> r9 = defpackage.C0535I5.f3633c     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList<java.lang.String> r10 = defpackage.C0535I5.f3622a     // Catch:{ Exception -> 0x03a0 }
                if (r8 == 0) goto L_0x00b0
                if (r10 == 0) goto L_0x00b0
                if (r9 != 0) goto L_0x00d7
            L_0x00b0:
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x03a0 }
                r8.<init>()     // Catch:{ Exception -> 0x03a0 }
                java.util.HashMap r9 = new java.util.HashMap     // Catch:{ Exception -> 0x03a0 }
                r9.<init>()     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x03a0 }
                r10.<init>()     // Catch:{ Exception -> 0x03a0 }
                r8.put(r3, r2)     // Catch:{ Exception -> 0x03a0 }
                r9.put(r2, r3)     // Catch:{ Exception -> 0x03a0 }
                r8.put(r4, r4)     // Catch:{ Exception -> 0x03a0 }
                r9.put(r4, r4)     // Catch:{ Exception -> 0x03a0 }
                r10.add(r3)     // Catch:{ Exception -> 0x03a0 }
                r10.add(r4)     // Catch:{ Exception -> 0x03a0 }
                defpackage.C0535I5.f3628b = r8     // Catch:{ Exception -> 0x03a0 }
                defpackage.C0535I5.f3628b = r8     // Catch:{ Exception -> 0x03a0 }
                defpackage.C0535I5.f3622a = r10     // Catch:{ Exception -> 0x03a0 }
            L_0x00d7:
                boolean r2 = cris.org.in.ima.fragment.LapAllTrainListFragment.e     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r3 = "AvailLastUpdate"
                java.lang.String r9 = "reebookPsgnList"
                java.lang.String r10 = "rebookFlag"
                java.lang.String r11 = "boardingStnListBkgCfg"
                java.lang.String r12 = "highestClass"
                java.lang.String r13 = "JourneyDate"
                java.lang.String r14 = "boardingStnListDTO"
                java.lang.String r15 = "selectedQuota"
                java.lang.String r5 = "spConcession"
                java.lang.String r4 = "googleAdParamDTO"
                java.lang.String r8 = "selectedQuotaString"
                r16 = r7
                f2 r7 = r1.f4722a
                java.lang.String r1 = "avlResponseDTO"
                r17 = r11
                java.lang.String r11 = "TrainBtwnStnsDTOList"
                if (r2 == 0) goto L_0x0189
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r2 = r6.f4714d     // Catch:{ Exception -> 0x03a0 }
                r18 = r3
                r3 = 0
                java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.model.TrainBtwnStnsModel r2 = (cris.org.in.ima.model.TrainBtwnStnsModel) r2     // Catch:{ Exception -> 0x03a0 }
                d2 r2 = r2.f5343a     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r2 = r2.getAvailablityStatus()     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r3 = "RAC"
                boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x03a0 }
                if (r2 != 0) goto L_0x018b
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r2 = r6.f4714d     // Catch:{ Exception -> 0x03a0 }
                r3 = 0
                java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.model.TrainBtwnStnsModel r2 = (cris.org.in.ima.model.TrainBtwnStnsModel) r2     // Catch:{ Exception -> 0x03a0 }
                d2 r2 = r2.f5343a     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r2 = r2.getAvailablityStatus()     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r3 = "CUR"
                boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x03a0 }
                if (r2 != 0) goto L_0x018b
                android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x03a0 }
                r2.<init>()     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r3 = r6.f4714d     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r11, r3)     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r1, r7)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.AllTrainListFragment.n     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r8, r1)     // Catch:{ Exception -> 0x03a0 }
                r1 = 0
                r2.putSerializable(r4, r1)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.k     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r5, r1)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.j     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r15, r1)     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r14, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = cris.org.in.ima.fragment.LapAllTrainListFragment.i     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r13, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = r6.f4718f     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r12, r0)     // Catch:{ Exception -> 0x03a0 }
                boolean r0 = cris.org.in.ima.fragment.LapAllTrainListFragment.f     // Catch:{ Exception -> 0x03a0 }
                r2.putBoolean(r10, r0)     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r0 = r6.f4711c     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r9, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = r6.f4717e     // Catch:{ Exception -> 0x03a0 }
                r3 = r18
                r2.putString(r3, r0)     // Catch:{ Exception -> 0x03a0 }
                r0 = r16
                r1 = r17
                r2.putSerializable(r1, r0)     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.fragment.ConnectingJourneyFragment r0 = new cris.org.in.ima.fragment.ConnectingJourneyFragment     // Catch:{ Exception -> 0x03a0 }
                r0.<init>()     // Catch:{ Exception -> 0x03a0 }
                r0.setArguments(r2)     // Catch:{ Exception -> 0x03a0 }
                android.content.Context r1 = r6.f4697a     // Catch:{ Exception -> 0x03a0 }
                kf r2 = defpackage.C1218kf.Connecting_journey     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.activities.HomeActivity.n(r1, r0, r2, r3, r4)     // Catch:{ Exception -> 0x03a0 }
                goto L_0x0376
            L_0x0189:
                r18 = r3
            L_0x018b:
                r2 = r16
                r3 = r17
                boolean r16 = defpackage.C1450w1.f7024c     // Catch:{ Exception -> 0x03a0 }
                if (r16 == 0) goto L_0x01dc
                android.os.Bundle r9 = new android.os.Bundle     // Catch:{ Exception -> 0x03a0 }
                r9.<init>()     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r10 = r6.f4714d     // Catch:{ Exception -> 0x03a0 }
                r9.putSerializable(r11, r10)     // Catch:{ Exception -> 0x03a0 }
                r9.putSerializable(r1, r7)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.AllTrainListFragment.n     // Catch:{ Exception -> 0x03a0 }
                r9.putString(r8, r1)     // Catch:{ Exception -> 0x03a0 }
                r1 = 0
                r9.putSerializable(r4, r1)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.k     // Catch:{ Exception -> 0x03a0 }
                r9.putString(r5, r1)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.j     // Catch:{ Exception -> 0x03a0 }
                r9.putString(r15, r1)     // Catch:{ Exception -> 0x03a0 }
                r9.putSerializable(r14, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = cris.org.in.ima.fragment.LapAllTrainListFragment.i     // Catch:{ Exception -> 0x03a0 }
                r9.putString(r13, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = r6.f4718f     // Catch:{ Exception -> 0x03a0 }
                r9.putSerializable(r12, r0)     // Catch:{ Exception -> 0x03a0 }
                r9.putSerializable(r3, r2)     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.fragment.MpPassengerFragment r0 = new cris.org.in.ima.fragment.MpPassengerFragment     // Catch:{ Exception -> 0x03a0 }
                r0.<init>()     // Catch:{ Exception -> 0x03a0 }
                r0.setArguments(r9)     // Catch:{ Exception -> 0x03a0 }
                android.content.Context r1 = r6.f4697a     // Catch:{ Exception -> 0x03a0 }
                kf r2 = defpackage.C1218kf.MP_PASSENGERS_LIST     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.activities.HomeActivity.n(r1, r0, r2, r3, r4)     // Catch:{ Exception -> 0x03a0 }
                goto L_0x0376
            L_0x01dc:
                r16 = r2
                android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x03a0 }
                r2.<init>()     // Catch:{ Exception -> 0x03a0 }
                r17 = r3
                java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r3 = r6.f4714d     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r11, r3)     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r1, r7)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.j     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r8, r1)     // Catch:{ Exception -> 0x03a0 }
                r1 = 0
                r2.putSerializable(r4, r1)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.k     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r5, r1)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.j     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r15, r1)     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r14, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = cris.org.in.ima.fragment.LapAllTrainListFragment.i     // Catch:{ Exception -> 0x03a0 }
                r2.putString(r13, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = r6.f4718f     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r12, r0)     // Catch:{ Exception -> 0x03a0 }
                boolean r0 = cris.org.in.ima.fragment.LapAllTrainListFragment.f     // Catch:{ Exception -> 0x03a0 }
                r2.putBoolean(r10, r0)     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r0 = r6.f4711c     // Catch:{ Exception -> 0x03a0 }
                r2.putSerializable(r9, r0)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = r6.f4717e     // Catch:{ Exception -> 0x03a0 }
                r1 = r18
                r2.putString(r1, r0)     // Catch:{ Exception -> 0x03a0 }
                r0 = r16
                r1 = r17
                r2.putSerializable(r1, r0)     // Catch:{ Exception -> 0x03a0 }
                r3 = 1
                r6.f4716d = r3     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x03a0 }
                r4 = 0
            L_0x022f:
                r5 = 0
            L_0x0230:
                boolean r7 = r1.hasNext()     // Catch:{ Exception -> 0x03a0 }
                if (r7 == 0) goto L_0x026e
                java.lang.Object r7 = r1.next()     // Catch:{ Exception -> 0x03a0 }
                CB r7 = (defpackage.C0471CB) r7     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r8 = r7.getLoyaltyAccrualBookingAllowed()     // Catch:{ Exception -> 0x03a0 }
                boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r8 == 0) goto L_0x0256
                if (r4 != 0) goto L_0x0255
                java.lang.Boolean r4 = r7.getLoyaltyAccrualBookingAllowed()     // Catch:{ Exception -> 0x03a0 }
                boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r4 == 0) goto L_0x0253
                goto L_0x0255
            L_0x0253:
                r4 = 0
                goto L_0x0256
            L_0x0255:
                r4 = r3
            L_0x0256:
                java.lang.Boolean r8 = r7.getLoyaltyRedemptionBookingAllowed()     // Catch:{ Exception -> 0x03a0 }
                boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r8 == 0) goto L_0x0230
                if (r5 != 0) goto L_0x026c
                java.lang.Boolean r5 = r7.getLoyaltyRedemptionBookingAllowed()     // Catch:{ Exception -> 0x03a0 }
                boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r5 == 0) goto L_0x022f
            L_0x026c:
                r5 = r3
                goto L_0x0230
            L_0x026e:
                java.lang.String r1 = "isLoyaltyAccrualBookingAllowed"
                r2.putBoolean(r1, r4)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r1 = "isLoyaltyRedemptionBookingAllowed"
                r2.putBoolean(r1, r5)     // Catch:{ Exception -> 0x03a0 }
                boolean r1 = defpackage.C0535I5.f3647h     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x02e5
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x02e3
                int r1 = r1.size()     // Catch:{ Exception -> 0x03a0 }
                if (r1 <= 0) goto L_0x02e3
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                r4 = 0
                java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x03a0 }
                CB r1 = (defpackage.C0471CB) r1     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r1 = r1.getSoftUser()     // Catch:{ Exception -> 0x03a0 }
                boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x02e3
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x03a0 }
                CB r1 = (defpackage.C0471CB) r1     // Catch:{ Exception -> 0x03a0 }
                java.util.ArrayList r1 = r1.getAccrualClassList()     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x02e3
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x03a0 }
                CB r1 = (defpackage.C0471CB) r1     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r1 = r1.getLoyaltyAccrualBookingAllowed()     // Catch:{ Exception -> 0x03a0 }
                boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x02e3
                java.util.List r1 = r0.getBkgCfgs()     // Catch:{ Exception -> 0x03a0 }
                java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x03a0 }
                b3 r1 = (defpackage.C0794b3) r1     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r1 = r1.getAcuralBooking()     // Catch:{ Exception -> 0x03a0 }
                boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x02e3
                java.util.List r0 = r0.getBkgCfgs()     // Catch:{ Exception -> 0x03a0 }
                r1 = 0
                java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x03a0 }
                b3 r0 = (defpackage.C0794b3) r0     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r0 = r0.getAcuralBooking()     // Catch:{ Exception -> 0x03a0 }
                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r0 == 0) goto L_0x02e3
                goto L_0x031b
            L_0x02e3:
                r8 = 0
                goto L_0x031f
            L_0x02e5:
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x031d
                int r1 = r1.size()     // Catch:{ Exception -> 0x03a0 }
                if (r1 <= 0) goto L_0x031d
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                r7 = 0
                java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x03a0 }
                CB r1 = (defpackage.C0471CB) r1     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r1 = r1.getSoftUser()     // Catch:{ Exception -> 0x03a0 }
                boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x031d
                if (r4 != 0) goto L_0x0306
                if (r5 == 0) goto L_0x031d
            L_0x0306:
                java.util.List r0 = r0.getBkgCfgs()     // Catch:{ Exception -> 0x03a0 }
                r1 = 0
                java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x03a0 }
                b3 r0 = (defpackage.C0794b3) r0     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r0 = r0.getAcuralBooking()     // Catch:{ Exception -> 0x03a0 }
                boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r0 == 0) goto L_0x031e
            L_0x031b:
                r8 = r3
                goto L_0x031f
            L_0x031d:
                r1 = 0
            L_0x031e:
                r8 = r1
            L_0x031f:
                kf r0 = defpackage.C1218kf.ADD_PASSENGER
                if (r8 == 0) goto L_0x0361
                java.util.ArrayList<CB> r1 = defpackage.C1450w1.f7017b     // Catch:{ Exception -> 0x03a0 }
                int r1 = r1.size()     // Catch:{ Exception -> 0x03a0 }
                if (r1 <= 0) goto L_0x0361
                java.lang.Boolean r1 = r6.f4704a     // Catch:{ Exception -> 0x03a0 }
                boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x03a0 }
                if (r1 == 0) goto L_0x0349
                cris.org.in.ima.fragment.PassengerDetailFragment r1 = new cris.org.in.ima.fragment.PassengerDetailFragment     // Catch:{ Exception -> 0x03a0 }
                r1.<init>()     // Catch:{ Exception -> 0x03a0 }
                r1.setArguments(r2)     // Catch:{ Exception -> 0x03a0 }
                android.content.Context r2 = r6.f4697a     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.activities.HomeActivity.n(r2, r1, r0, r3, r4)     // Catch:{ Exception -> 0x03a0 }
                goto L_0x0376
            L_0x0349:
                cris.org.in.ima.fragment.LoyalityPassengerDetailFragment r0 = new cris.org.in.ima.fragment.LoyalityPassengerDetailFragment     // Catch:{ Exception -> 0x03a0 }
                r0.<init>()     // Catch:{ Exception -> 0x03a0 }
                r0.setArguments(r2)     // Catch:{ Exception -> 0x03a0 }
                android.content.Context r1 = r6.f4697a     // Catch:{ Exception -> 0x03a0 }
                kf r2 = defpackage.C1218kf.LOYALTY_DETAIL     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.activities.HomeActivity.n(r1, r0, r2, r3, r4)     // Catch:{ Exception -> 0x03a0 }
                goto L_0x0376
            L_0x0361:
                cris.org.in.ima.fragment.PassengerDetailFragment r1 = new cris.org.in.ima.fragment.PassengerDetailFragment     // Catch:{ Exception -> 0x03a0 }
                r1.<init>()     // Catch:{ Exception -> 0x03a0 }
                r1.setArguments(r2)     // Catch:{ Exception -> 0x03a0 }
                android.content.Context r2 = r6.f4697a     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x03a0 }
                java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x03a0 }
                cris.org.in.ima.activities.HomeActivity.n(r2, r1, r0, r3, r4)     // Catch:{ Exception -> 0x03a0 }
            L_0x0376:
                android.app.ProgressDialog r0 = r6.f4696a     // Catch:{ Exception -> 0x03a0 }
                r0.dismiss()     // Catch:{ Exception -> 0x03a0 }
                goto L_0x03e3
            L_0x037c:
                android.app.ProgressDialog r1 = r6.f4696a     // Catch:{ Exception -> 0x03a0 }
                r1.dismiss()     // Catch:{ Exception -> 0x03a0 }
                android.content.Context r7 = r6.f4697a     // Catch:{ Exception -> 0x03a0 }
                r8 = 0
                java.lang.String r9 = r0.getErrorMessage()     // Catch:{ Exception -> 0x03a0 }
                android.content.Context r0 = r6.f4697a     // Catch:{ Exception -> 0x03a0 }
                android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x03a0 }
                r1 = 2131952688(0x7f130430, float:1.9541826E38)
                java.lang.String r10 = r0.getString(r1)     // Catch:{ Exception -> 0x03a0 }
                java.lang.String r11 = "OK"
                r12 = 0
                android.app.AlertDialog r0 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x03a0 }
                r0.show()     // Catch:{ Exception -> 0x03a0 }
                goto L_0x03e3
            L_0x03a0:
                r0 = move-exception
                android.app.ProgressDialog r1 = r6.f4696a
                r1.dismiss()
                android.content.Context r7 = r6.f4697a
                r8 = 0
                android.content.res.Resources r1 = r7.getResources()
                r2 = 2131953888(0x7f1308e0, float:1.954426E38)
                java.lang.String r9 = r1.getString(r2)
                r10 = 0
                java.lang.String r11 = "OK"
                r12 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)
                r1.show()
                androidx.fragment.app.FragmentActivity r1 = cris.org.in.ima.fragment.LapAllTrainListFragment.f4691a
                r0.getMessage()
                goto L_0x03e3
            L_0x03c5:
                android.app.ProgressDialog r0 = r6.f4696a
                r0.dismiss()
                android.content.Context r7 = r6.f4697a
                r8 = 0
                android.content.res.Resources r0 = r7.getResources()
                r1 = 2131953888(0x7f1308e0, float:1.954426E38)
                java.lang.String r9 = r0.getString(r1)
                r10 = 0
                java.lang.String r11 = "OK"
                r12 = 0
                android.app.AlertDialog r0 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)
                r0.show()
            L_0x03e3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.LapAllTrainListFragment.i.onNext(java.lang.Object):void");
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public final void onClick(View view) {
            int visibility = LapAllTrainListFragment.a.getVisibility();
            LapAllTrainListFragment lapAllTrainListFragment = LapAllTrainListFragment.this;
            if (visibility == 0 || lapAllTrainListFragment.filter_ll.getVisibility() == 0 || lapAllTrainListFragment.pnr_input_bottom_rl.getVisibility() == 0) {
                lapAllTrainListFragment.i();
            } else {
                HomeActivity.A(2);
            }
        }
    }

    public class k implements QuotaSelectionAdapter.QuotaSelectListener {
        public k() {
        }

        public final void onQuotaClick(QuotaModel quotaModel) {
            LapAllTrainListFragment lapAllTrainListFragment = LapAllTrainListFragment.this;
            Iterator it = lapAllTrainListFragment.b.iterator();
            while (it.hasNext()) {
                QuotaModel quotaModel2 = (QuotaModel) it.next();
                quotaModel2.a = Boolean.FALSE;
                String str = quotaModel.c;
                String str2 = quotaModel2.c;
                if (str2.equals(str)) {
                    quotaModel2.a = Boolean.TRUE;
                    LapAllTrainListFragment.j = str2;
                }
            }
            Integer num = 0;
            Iterator<TrainBtwnStnsModel> it2 = lapAllTrainListFragment.f4714d.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                TrainBtwnStnsModel next = it2.next();
                if (next.f5342a.getTrainNumber().equals(LapAllTrainListFragment.f4693a.f5342a.getTrainNumber())) {
                    next.f5343a = null;
                    next.d = LapAllTrainListFragment.j;
                    next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                    break;
                }
                i++;
            }
            lapAllTrainListFragment.f4698a.notifyItemChanged(i);
            lapAllTrainListFragment.quota_bottom_ll.setVisibility(8);
            Iterator<TrainBtwnStnsModel> it3 = lapAllTrainListFragment.f4714d.iterator();
            while (it3.hasNext()) {
                TrainBtwnStnsModel next2 = it3.next();
                if (next2.f5342a.getClassAvlDTO() != null) {
                    for (ClassAvlDTO next3 : next2.f5342a.getClassAvlDTO()) {
                        if (next3.getEnqClass().equalsIgnoreCase(next2.f5348c) && next3.getTotalFare() != null) {
                            num = Integer.valueOf(next3.getTotalFare().intValue() + num.intValue());
                        }
                    }
                }
            }
            if (num.intValue() > 0) {
                lapAllTrainListFragment.bottomFareAndButtonLayout.setVisibility(0);
                lapAllTrainListFragment.totalFareLl.setVisibility(0);
                lapAllTrainListFragment.totalFare.setText("₹ " + num);
                return;
            }
            lapAllTrainListFragment.bottomFareAndButtonLayout.setVisibility(8);
        }
    }

    public class l implements Comparator<TrainBtwnStnsModel> {
        public l() {
        }

        public final int compare(Object obj, Object obj2) {
            TrainBtwnStnsModel trainBtwnStnsModel = (TrainBtwnStnsModel) obj;
            TrainBtwnStnsModel trainBtwnStnsModel2 = (TrainBtwnStnsModel) obj2;
            if (!LapAllTrainListFragment.this.f4708a) {
                if (trainBtwnStnsModel.f5342a.getDepartureTime().compareTo(trainBtwnStnsModel2.f5342a.getDepartureTime()) > 0) {
                    return 1;
                }
            } else if (trainBtwnStnsModel.f5342a.getDepartureTime().compareTo(trainBtwnStnsModel2.f5342a.getDepartureTime()) < 0) {
                return 1;
            }
            return -1;
        }
    }

    static {
        View.MeasureSpec.makeMeasureSpec(0, 0);
        C1354qp.R(LapAllTrainListFragment.class);
    }

    public LapAllTrainListFragment() {
        new C0573L6();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        new HashSet();
        this.f4709b = new ArrayList();
        this.f4712c = new ArrayList();
        new ArrayList();
        new HashMap();
        this.f4717e = "";
        this.f4716d = false;
        this.g = "";
        this.f4711c = null;
        new HashMap();
        new HashMap();
        this.f4714d = null;
        this.f4698a = null;
        this.f4703a = null;
        this.f4700a = new k();
    }

    @OnClick({2131364354})
    public void ContinueButtonClick() {
        boolean z;
        if (C1450w1.f7013a == 5 && C0535I5.R()) {
            C0535I5.o(getActivity(), getString(R.string.incomplete_registration), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (!C0535I5.f3647h || C0535I5.f3648i) {
            this.f4714d.get(0).toString();
            C1081e2 e2Var = new C1081e2();
            this.f4703a = e2Var;
            e2Var.setFtBooking(false);
            this.f4703a.setLoyaltyRedemptionBooking(false);
            this.f4703a.setMoreThanOneDay(Boolean.TRUE);
            this.f4703a.setTicketType("E");
            ArrayList arrayList = new ArrayList();
            Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
            while (it.hasNext()) {
                TrainBtwnStnsModel next = it.next();
                C1060d2 d2Var = next.f5343a;
                this.f4702a = d2Var;
                if (d2Var == null) {
                    Toast.makeText(this.f4697a, getString(R.string.select_both_lap), 0).show();
                    return;
                } else if (d2Var.getAvailablityStatus().equalsIgnoreCase("TRAIN DEPARTED") || this.f4702a.getAvailablityStatus().equalsIgnoreCase("NOT AVAILABLE") || this.f4702a.getReasonType().equals("W") || this.f4702a.getAvailablityStatus().equalsIgnoreCase("TRAIN CANCELLED") || this.f4702a.getAvailablityStatus().equalsIgnoreCase("RESVN SUSPENDED") || this.f4702a.getAvailablityStatus().contains("REGRET")) {
                    Toast.makeText(this.f4697a, getString(R.string.no_seat_available), 0).show();
                    return;
                } else {
                    C0668Rh rh = new C0668Rh();
                    TrainBtwnStnsDTO trainBtwnStnsDTO = next.f5342a;
                    rh.setTrainNo(trainBtwnStnsDTO.getTrainNumber());
                    rh.setFromStation(trainBtwnStnsDTO.getFromStnCode());
                    rh.setJourneyDate(new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(trainBtwnStnsDTO.getJourneyDate()));
                    rh.setQuota(next.d);
                    rh.setToStation(trainBtwnStnsDTO.getToStnCode());
                    rh.setJourneyClass(next.f5348c);
                    if (k.equals("Y")) {
                        if (k.equals("Y") || j.equals("HP")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        rh.setConcessionBooking(z);
                    }
                    arrayList.add(rh);
                }
            }
            this.f4703a.setLapAvlRequestDTO(arrayList);
        } else {
            String str = C0535I5.g;
            if (str != null) {
                Context context = this.f4697a;
                C0535I5.o(context, str, context.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    @OnClick({2131363579})
    public void OnQuotaBackroundClick() {
        i();
    }

    @OnClick({2131363777})
    public void OnRoutMapBackroundClick() {
        i();
    }

    @OnClick({2131361957})
    public void arrival(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.quota_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        l(this.arrival, R.color.dark);
        l(this.departure, R.color.white);
        l(this.travelTime, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrival.setTextAppearance(getActivity(), R.style.fontForbold);
        this.travelTime.setTextAppearance(getActivity(), R.style.fontForNormal);
        if (this.f4710b) {
            this.f4710b = false;
        } else {
            this.f4710b = true;
        }
        n(1);
    }

    @OnClick({2131363515})
    public void connectionJourneyLayoutClick() {
        i();
    }

    @OnClick({2131362388})
    public void departure(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.quota_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        l(this.arrival, R.color.white);
        l(this.departure, R.color.dark);
        l(this.travelTime, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.arrival.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.travelTime.setTextAppearance(getActivity(), R.style.fontForNormal);
        if (this.f4708a) {
            this.f4708a = false;
        } else {
            this.f4708a = true;
        }
        n(0);
    }

    public final void f() {
        Om om;
        if (!C0535I5.O((ConnectivityManager) this.f4697a.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new C0640Ph(), 5000);
        } else if (!C0535I5.M() || C0535I5.R()) {
            Context context = this.f4697a;
            ProgressDialog show = ProgressDialog.show(context, context.getResources().getString(R.string.Check_Availability), this.f4697a.getResources().getString(R.string.please_wait_text));
            if (C0535I5.R()) {
                om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            } else {
                om = (Om) C0657Qt.b();
            }
            om.H("N", this.f4703a).c(C1181iv.a()).a(E0.a()).b(new C0654Qh(this, show));
        } else if (C1450w1.f7005a == 2) {
            HomeActivity.A(2);
        } else {
            HomeActivity.A(1);
        }
    }

    public final void g(C1100f2 f2Var) {
        String str;
        if (C0535I5.f3634c) {
            str = C1450w1.f7023c.get("BOOKNOW_MSG");
        } else {
            str = "";
        }
        if (!str.equals("")) {
            Spanned fromHtml = Html.fromHtml(str);
            Context context = this.f4697a;
            C0535I5.n(context, fromHtml, context.getResources().getString(R.string.confirmation), this.f4697a.getResources().getString(R.string.I_Agree), new e(f2Var), this.f4697a.getResources().getString(R.string.I_Dont_Agree), new f()).show();
            return;
        }
        o(f2Var);
    }

    public final String h(String str, String str2) {
        new SimpleDateFormat();
        int indexOf = str.indexOf(45);
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(45, i2);
        return new SimpleDateFormat("yyyyMMdd").format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i2, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }

    public final void i() {
        this.f4702a = null;
        this.route_rl.setVisibility(8);
        this.sortby_bottom_ll.setVisibility(8);
        this.quota_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        this.pnr_input_bottom_rl.setVisibility(8);
    }

    public final boolean j() {
        if (a.getVisibility() != 0 && this.quota_bottom_ll.getVisibility() != 0 && this.pnr_input_bottom_rl.getVisibility() != 0) {
            return false;
        }
        i();
        return true;
    }

    public final void k(C1100f2 f2Var) {
        if (!C0535I5.O((ConnectivityManager) this.f4697a.getSystemService("connectivity"), this.f4697a)) {
            new Handler().postDelayed(new h(), 5000);
        } else if (C0535I5.R()) {
            Context context = this.f4697a;
            this.f4696a = ProgressDialog.show(context, context.getString(R.string.processing_text), this.f4697a.getString(R.string.please_wait_text));
            C1081e2 e2Var = new C1081e2();
            ArrayList arrayList = new ArrayList();
            Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
            while (it.hasNext()) {
                TrainBtwnStnsModel next = it.next();
                C1469x0 x0Var = new C1469x0();
                x0Var.setTrainNo(next.f5342a.getTrainNumber());
                TrainBtwnStnsDTO trainBtwnStnsDTO = next.f5342a;
                x0Var.setSrcStn(trainBtwnStnsDTO.getFromStnCode());
                x0Var.setDestStn(trainBtwnStnsDTO.getToStnCode());
                String str = k;
                if (str != null || str == "Y") {
                    x0Var.setConcessionPassengers(true);
                } else if (str != null || str == "N") {
                    x0Var.setConcessionPassengers(false);
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
                if (!C0535I5.f3647h) {
                    x0Var.setJrnyDate(i);
                } else if (trainBtwnStnsDTO.getJourneyDate() != null) {
                    x0Var.setJrnyDate(simpleDateFormat.format(trainBtwnStnsDTO.getJourneyDate()));
                } else {
                    x0Var.setJrnyDate(i);
                }
                x0Var.setJrnyClass(next.f5348c);
                String str2 = "GN";
                if (C0535I5.f3647h) {
                    if (!next.d.equals("SS")) {
                        str2 = next.d;
                    }
                    x0Var.setQuotaCode(str2);
                } else {
                    if (!j.equals("SS")) {
                        str2 = j;
                    }
                    x0Var.setQuotaCode(str2);
                }
                arrayList.add(x0Var);
            }
            e2Var.setAlternateAvlInputDTO(arrayList);
            String f2 = C0657Qt.f();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).D0(f2 + "boardingStationEnq", e2Var).c(C1181iv.a()).a(E0.a()).b(new i(f2Var));
        } else if (C1450w1.f7005a == 2) {
            HomeActivity.A(2);
        } else {
            HomeActivity.A(1);
        }
    }

    public final void l(TextView textView, int i2) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i2), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final List<TrainBtwnStnsModel> m(int i2, List<TrainBtwnStnsModel> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (i2 == 0) {
            Collections.sort(list, new l());
        } else if (i2 == 1) {
            Collections.sort(list, new a());
        } else if (i2 == 2) {
            Collections.sort(list, new b());
        }
        return list;
    }

    public final void n(int i2) {
        List<TrainBtwnStnsModel> list = this.f4709b;
        if (list == null || list.size() <= 0) {
            throw null;
        }
        List<TrainBtwnStnsModel> list2 = this.f4709b;
        List<TrainBtwnStnsModel> list3 = this.f4712c;
        this.f4709b = m(i2, list2);
        this.f4712c = m(i2, list3);
        this.f4698a.notifyDataSetChanged();
    }

    public final void o(C1100f2 f2Var) {
        TrainBtwnStnsModel trainBtwnStnsModel;
        String str;
        C1100f2 f2Var2 = f2Var;
        if (this.f4714d.size() == 1) {
            trainBtwnStnsModel = this.f4714d.get(0);
        } else {
            trainBtwnStnsModel = this.f4714d.get(1);
        }
        if (!this.f4714d.get(0).f5342a.getFromStnCode().equals(l) || !trainBtwnStnsModel.f5342a.getToStnCode().equals(m)) {
            Bw.e(getContext()).f();
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                str = "आपने " + l + " से " + m + " तक की ट्रेनों की खोज की लेकिन " + this.f4714d.get(0).f5342a.getFromStnCode() + " से " + trainBtwnStnsModel.f5342a.getToStnCode() + " तक बुकिंग कर रहे हैं.\n\nक्या आप इसे जारी रखना चाहते हैं?";
            } else {
                str = this.f4697a.getResources().getString(R.string.you_have_to_select_train) + " " + l + " " + this.f4697a.getResources().getString(R.string.to_se) + " " + m + ". " + this.f4697a.getResources().getString(R.string.but_you_booking_in_train_between) + " " + this.f4714d.get(0).f5342a.getFromStnCode() + " " + this.f4697a.getResources().getString(R.string.to_se) + " " + trainBtwnStnsModel.f5342a.getToStnCode() + ".\n\n" + this.f4697a.getResources().getString(R.string.confirm_selected_Train);
            }
            Context context = this.f4697a;
            C0535I5.p(context, false, str, context.getResources().getString(R.string.confirm_selected_Train), this.f4697a.getResources().getString(R.string.confirm), new c(f2Var2), this.f4697a.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
            return;
        }
        try {
            this.c = h(this.f4714d.get(0).f5343a.getAvailablityDate(), "yyyyMMdd");
            this.d = new SimpleDateFormat("dd-MM-yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(i));
        } catch (Exception e2) {
            e2.getMessage();
        }
        new SimpleDateFormat("dd-MM-yyyy");
        if (!this.c.equals(i)) {
            C0535I5.p(this.f4697a, false, getString(R.string.you_have_to_select_train) + " " + this.d + getString(R.string.but_you_booking_in_train_between) + " " + this.c + ".\n\n" + getString(R.string.Do_you_want_to_continue_with_the_same_train), getString(R.string.confirm_selected_Train), this.f4697a.getResources().getString(R.string.confirm), new d(f2Var2), this.f4697a.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
            return;
        }
        k(f2Var);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.activity_train_list, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4697a = getContext();
        f4691a = getActivity();
        getFragmentManager();
        f4692a = (RecyclerView) inflate.findViewById(R.id.rv_station_list);
        f4690a = (TextView) inflate.findViewById(R.id.tv_train_name);
        a = (RelativeLayout) inflate.findViewById(R.id.route_rl);
        Bundle arguments = getArguments();
        new ArrayList();
        new ArrayList();
        if (arguments != null) {
            Cf cf = (Cf) arguments.getSerializable("indirectTbisResponse");
            this.f4695a = cf;
            this.f4715d = cf.getJourneyDetailDTO();
            this.f4701a = (JourneyDetailDTO) arguments.getSerializable("journeyDetailDTO");
            l = arguments.getString("FromStationCode");
            m = arguments.getString("ToStationCode");
            arguments.getString("FromStationString");
            arguments.getString("ToStationString");
            arguments.getString("flexiableWithDate");
            k = arguments.getString("spConcession");
            i = arguments.getString("JourneyDate");
            e = arguments.getBoolean("isConnectingJourney");
            f = arguments.getBoolean("rebookFlag");
            arguments.getString("jrnyClass");
            f = arguments.getBoolean("rebookFlag");
            AvlClassModel avlClassModel = (AvlClassModel) arguments.getSerializable("avlClassModel");
            TrainBtwnStnsModel trainBtwnStnsModel = (TrainBtwnStnsModel) arguments.getSerializable("trainBtwnStnsModel");
            arguments.getBoolean("altAvlEnqFlag");
            arguments.getBoolean("trainAvailableBerthIsChecked");
            arguments.getString("altAvlClass");
            this.g = arguments.getString("selectedQuota");
            this.f4711c = (ArrayList) arguments.getSerializable("reebookPsgnList");
            ArrayList arrayList = (ArrayList) arguments.getSerializable("trainTypeListData");
            HashMap hashMap = (HashMap) arguments.getSerializable("trainTypeFlag");
            HashMap hashMap2 = (HashMap) arguments.getSerializable("classFlag");
            Set set = (Set) arguments.getSerializable("avlClassHashSet");
            this.f4707a = this.f4695a.getQuotaList();
            StationDb stationDb = C0793b1.a.f3911a;
            HomeActivity.F(stationDb.m(l) + " 2131952107 " + stationDb.m(m));
            GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
            googleAdParamDTO.setAge(C1450w1.f7009a);
            googleAdParamDTO.setGender(C1450w1.f7021c);
            googleAdParamDTO.setSource(l);
            googleAdParamDTO.setDestination(m);
            C0535I5.Y(getActivity(), this.publisherAdViewtop, googleAdParamDTO);
            C0535I5.Y(getActivity(), this.publisherAdViewcenter, googleAdParamDTO);
            C0535I5.Y(getActivity(), this.publisherAdViewbottom, googleAdParamDTO);
            C0535I5.Y(getActivity(), this.publisherAdViewbottomrout_map, googleAdParamDTO);
            C0535I5.Y(getActivity(), this.train_list_filter, googleAdParamDTO);
        }
        this.mainLayoutSortAndFilter.setVisibility(8);
        this.alterTrainListShow.setVisibility(8);
        try {
            str = new SimpleDateFormat("EEE, dd MMM  yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(i));
        } catch (ParseException e2) {
            e2.getMessage();
            str = "";
        }
        HomeActivity.H(l + " 2131953827 " + m + " | " + str);
        lf.x(new StringBuilder("Departure From "), l, this.departureFrom);
        this.departureFrom.setVisibility(8);
        this.trainTypeHeading.setVisibility(8);
        g gVar = new g();
        List<String> list = this.f4707a;
        boolean z = this.f4716d;
        ArrayList arrayList2 = this.b;
        if (!z) {
            for (String quotaModel : list) {
                arrayList2.add(new QuotaModel(quotaModel));
            }
        }
        this.quotaRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        QuotaSelectionAdapter quotaSelectionAdapter = new QuotaSelectionAdapter(this.f4697a, arrayList2, this.f4700a);
        this.f4699a = quotaSelectionAdapter;
        this.quotaRecyclerView.setAdapter(quotaSelectionAdapter);
        this.tvGeneral.setVisibility(8);
        this.parliamentHouse.setVisibility(8);
        if (!this.f4716d) {
            ArrayList<TrainBtwnStnsModel> arrayList3 = new ArrayList<>();
            this.f4714d = arrayList3;
            arrayList3.clear();
            for (TrainBtwnStnsDTO next : this.f4701a.getTrainBtwnStnsDTO()) {
                TrainBtwnStnsModel trainBtwnStnsModel2 = new TrainBtwnStnsModel(next);
                trainBtwnStnsModel2.d = this.g;
                next.setClassAvlDTO((List<ClassAvlDTO>) null);
                trainBtwnStnsModel2.f5343a = null;
                trainBtwnStnsModel2.f5345a = this.f4701a.getWaitingTime();
                trainBtwnStnsModel2.f5347b = this.f4701a.getTotalDuration();
                trainBtwnStnsModel2.e = this.f4701a.getInfo();
                this.f4714d.add(trainBtwnStnsModel2);
            }
        }
        this.f4698a = new LapTrainListAdapter(this.f4697a, this.f4714d, gVar, this.g, this.f4695a.getFromStation().get(0), this.f4695a.getToStation().get(0), this.f4701a.getWaitingTime(), this.f4701a.getTotalDuration());
        this.trainList.setLayoutManager(new LinearLayoutManager(this.f4697a));
        this.trainList.setAdapter(this.f4698a);
        j = this.g;
        HomeActivity.f4191e.setOnClickListener(new j());
        if (C0535I5.f3647h && !C0535I5.f3648i) {
            this.tv_continue.setVisibility(8);
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4696a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4696a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364185})
    public void onFareBackUp(View view) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        while (it.hasNext()) {
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getClassAvlDTO() != null) {
                for (ClassAvlDTO next2 : next.f5342a.getClassAvlDTO()) {
                    if (next2.getEnqClass().equalsIgnoreCase(next.f5348c)) {
                        AvlFareResponseDTO avlFareResponseDTO = new AvlFareResponseDTO();
                        avlFareResponseDTO.setBaseFare(next2.getBaseFare());
                        avlFareResponseDTO.setReservationCharge(next2.getReservationCharge());
                        avlFareResponseDTO.setSuperfastCharge(next2.getSuperfastCharge());
                        avlFareResponseDTO.setTatkalFare(next2.getTatkalFare());
                        avlFareResponseDTO.setServiceTax(next2.getServiceTax());
                        avlFareResponseDTO.setCateringCharge(next2.getCateringCharge());
                        avlFareResponseDTO.setTotalFare(next2.getTotalFare());
                        avlFareResponseDTO.setDynamicFare(next2.getDynamicFare());
                        avlFareResponseDTO.setEnqClass(next2.getEnqClass());
                        avlFareResponseDTO.setInformationMessage((ArrayList) next2.getInformationMessage());
                        f4694a = avlFareResponseDTO;
                        arrayList.add(avlFareResponseDTO);
                    }
                }
            }
        }
        try {
            str = new SimpleDateFormat("dd MMM EEEE yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(i));
        } catch (ParseException e2) {
            e2.getMessage();
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append(" 2131953827 ");
        String B = C1058d.B(sb, m, " | ", str);
        Intent intent = new Intent(getContext(), FareBreakupActivity.class);
        intent.putExtra("googleAdParamDTO", (Serializable) null);
        intent.putExtra("FareResponse", f4694a);
        intent.putExtra("FareResponseList", arrayList);
        intent.putExtra("trainBtwnStnsModelsList", this.f4714d);
        intent.putExtra("jDateString", h);
        intent.putExtra("toolbarSubtitle", B);
        startActivity(intent);
    }

    @OnClick({2131364429})
    public void onGeneralClick(View view) {
        j = "GN";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.a.a();
        }
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getTrainNumber().equals(f4693a.f5342a.getTrainNumber())) {
                next.d = j;
                next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                break;
            }
            i2++;
        }
        this.f4698a.notifyItemChanged(i2);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.quota_bottom_ll.setVisibility(8);
        l(this.tvGeneral, R.color.dark);
        l(this.tvLadies, R.color.white);
        l(this.seniorCitizen, R.color.white);
        l(this.tvTatkal, R.color.white);
        l(this.premiumTatkal, R.color.white);
        l(this.phHandicap, R.color.white);
        l(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
    }

    @OnClick({2131364529})
    public void onHandicapClick(View view) {
        j = "HP";
        H9.e.a();
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getTrainNumber().equals(f4693a.f5342a.getTrainNumber())) {
                next.d = j;
                next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                break;
            }
            i2++;
        }
        this.f4698a.notifyItemChanged(i2);
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.quota_bottom_ll.setVisibility(8);
        l(this.tvGeneral, R.color.white);
        l(this.tvLadies, R.color.white);
        l(this.seniorCitizen, R.color.white);
        l(this.tvTatkal, R.color.white);
        l(this.premiumTatkal, R.color.white);
        l(this.phHandicap, R.color.dark);
        l(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForbold);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
        C0535I5.p(getContext(), false, getResources().getString(R.string.spc_popUp_Msgs), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131364522})
    public void onParliamentHouseClick(View view) {
        j = "PH";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.h.a();
        }
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getTrainNumber().equals(f4693a.f5342a.getTrainNumber())) {
                next.d = j;
                next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                break;
            }
            i2++;
        }
        this.f4698a.notifyItemChanged(i2);
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.premiumTatkal.setSelected(false);
        l(this.tvGeneral, R.color.white);
        l(this.tvLadies, R.color.white);
        l(this.seniorCitizen, R.color.white);
        l(this.tvTatkal, R.color.white);
        l(this.premiumTatkal, R.color.white);
        l(this.phHandicap, R.color.white);
        l(this.parliamentHouse, R.color.dark);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
        this.quota_bottom_ll.setVisibility(8);
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4696a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4696a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364537})
    public void onPremiumTatkalClick(View view) {
        j = "PT";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.g.a();
        }
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getTrainNumber().equals(f4693a.f5342a.getTrainNumber())) {
                next.d = j;
                next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                break;
            }
            i2++;
        }
        this.f4698a.notifyItemChanged(i2);
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.quota_bottom_ll.setVisibility(8);
        l(this.tvGeneral, R.color.white);
        l(this.tvLadies, R.color.white);
        l(this.seniorCitizen, R.color.white);
        l(this.tvTatkal, R.color.white);
        l(this.premiumTatkal, R.color.dark);
        l(this.phHandicap, R.color.white);
        l(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
    }

    public final void onResume() {
        super.onResume();
        if (HomeActivity.f4186b) {
            HomeActivity.f4186b = false;
            if (this.f4703a != null) {
                f();
            }
        }
        HomeActivity.f4186b = false;
        if (C0535I5.R()) {
            this.goTopassangerDetail.setText(getString(R.string.book_now));
        }
    }

    @OnClick({2131364597})
    public void onSeniorCitizenClick(View view) {
        j = "SS";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.d.a();
        }
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getTrainNumber().equals(f4693a.f5342a.getTrainNumber())) {
                next.d = j;
                next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                break;
            }
            i2++;
        }
        this.f4698a.notifyItemChanged(i2);
        view.setSelected(true);
        this.tvLadies.setSelected(false);
        this.tvGeneral.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.quota_bottom_ll.setVisibility(8);
        l(this.tvGeneral, R.color.white);
        l(this.tvLadies, R.color.white);
        l(this.seniorCitizen, R.color.dark);
        l(this.tvTatkal, R.color.white);
        l(this.premiumTatkal, R.color.white);
        l(this.phHandicap, R.color.white);
        l(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForbold);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
        C0535I5.p(getContext(), false, getResources().getString(R.string.senior_citizen_msg), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4696a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4696a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364655})
    public void onTatkalClick(View view) {
        j = "TQ";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.c.a();
        }
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getTrainNumber().equals(f4693a.f5342a.getTrainNumber())) {
                next.d = j;
                next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                break;
            }
            i2++;
        }
        this.f4698a.notifyItemChanged(i2);
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.quota_bottom_ll.setVisibility(8);
        l(this.tvGeneral, R.color.white);
        l(this.tvLadies, R.color.white);
        l(this.seniorCitizen, R.color.white);
        l(this.tvTatkal, R.color.dark);
        l(this.premiumTatkal, R.color.white);
        l(this.phHandicap, R.color.white);
        l(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
    }

    @OnClick({2131364452})
    public void onTrainNoClick(View view) {
        j = "LD";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.b.a();
        }
        Iterator<TrainBtwnStnsModel> it = this.f4714d.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrainBtwnStnsModel next = it.next();
            if (next.f5342a.getTrainNumber().equals(f4693a.f5342a.getTrainNumber())) {
                next.d = j;
                next.f5342a.setClassAvlDTO((List<ClassAvlDTO>) null);
                break;
            }
            i2++;
        }
        this.f4698a.notifyItemChanged(i2);
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.quota_bottom_ll.setVisibility(8);
        l(this.tvGeneral, R.color.white);
        l(this.tvLadies, R.color.dark);
        l(this.seniorCitizen, R.color.white);
        l(this.tvTatkal, R.color.white);
        l(this.premiumTatkal, R.color.white);
        l(this.phHandicap, R.color.white);
        l(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForbold);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
    }

    @OnClick({2131364247})
    public void trainNo(View view) {
        n(2);
        this.sortby_bottom_ll.setVisibility(8);
        this.quota_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        l(this.arrival, R.color.white);
        l(this.departure, R.color.white);
        l(this.travelTime, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrival.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.travelTime.setTextAppearance(getActivity(), R.style.fontForbold);
        if (this.f4713c) {
            this.f4713c = false;
        } else {
            this.f4713c = true;
        }
        n(2);
    }

    public class h implements Runnable {
        public final void run() {
        }
    }
}
