package cris.org.in.ima.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.JourneyDetailsAdapter;
import cris.org.in.ima.adaptors.ViaStationListAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.AvlClassModel;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.ima.model.ViaStationModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.JourneyDetailDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import defpackage.d7;
import in.juspay.hypersdk.core.PaymentConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import rx.Subscriber;

public class JourneyDetailsFragment extends Fragment {
    public static RelativeLayout a;

    /* renamed from: a  reason: collision with other field name */
    public static FragmentActivity f4661a;
    public static String g = null;
    public static String h;
    public static String i;
    public static String j;
    @BindView(2131361794)
    LinearLayout Allclass_ll;

    /* renamed from: a  reason: collision with other field name */
    public Cf f4662a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4663a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4664a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f4665a;

    /* renamed from: a  reason: collision with other field name */
    public JourneyDetailsAdapter f4666a;

    /* renamed from: a  reason: collision with other field name */
    public ViaStationListAdapter f4667a;

    /* renamed from: a  reason: collision with other field name */
    public final h f4668a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4669a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, Boolean> f4670a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f4671a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f4672a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4673a;
    @BindView(2131364290)
    TextView alterTrainListShow;
    @BindView(2131361957)
    TextView arrival;
    @BindView(2131361958)
    TextView arrivalEarlyFirst;
    @BindView(2131361959)
    TextView arrivalLateFirst;
    @BindView(2131364301)
    TextView available;
    public JourneyDetailsAdapter b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<String> f4674b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public final HashMap<String, Boolean> f4675b;

    /* renamed from: b  reason: collision with other field name */
    public List<TrainBtwnStnsModel> f4676b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4677b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4678c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList f4679c = new ArrayList();

    /* renamed from: c  reason: collision with other field name */
    public List<JourneyDetailDTO> f4680c;
    @BindView(2131362103)
    ImageView calander;
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
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f4681d;

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList f4682d;

    /* renamed from: d  reason: collision with other field name */
    public List<JourneyDetailDTO> f4683d;
    @BindView(2131362388)
    TextView departure;
    @BindView(2131362389)
    TextView departureEarlyFirst;
    @BindView(2131364364)
    TextView departureFrom;
    @BindView(2131362390)
    TextView departureLateFirst;
    @BindView(2131362460)
    ImageView duranto_img;
    @BindView(2131362461)
    TextView durationEarlyFirst;
    @BindView(2131362462)
    TextView durationLateFirst;
    @BindView(2131362463)
    RelativeLayout duronto_rl;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public String f4684e;

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<ViaStationModel> f4685e;

    /* renamed from: e  reason: collision with other field name */
    public List<JourneyDetailDTO> f4686e;
    @BindView(2131362466)
    LinearLayout earlyMorning_ll;
    public String f;

    /* renamed from: f  reason: collision with other field name */
    public ArrayList f4687f;
    @BindView(2131362660)
    ImageView filter;
    @BindView(2131362662)
    RelativeLayout filter_ll;
    @BindView(2131362663)
    LinearLayout filter_ll_ll;
    @BindView(2131362664)
    ScrollView filter_ll_scroll;
    @BindView(2131362724)
    ImageView garibrath_img;
    @BindView(2131362725)
    RelativeLayout garibrath_rl;
    @BindView(2131362776)
    RelativeLayout hide_ll;
    @BindView(2131362916)
    ImageView janshatabdi_img;
    @BindView(2131362917)
    RelativeLayout janshatabdi_rl;
    @BindView(2131363221)
    LinearLayout midDay_ll;
    @BindView(2131363244)
    LinearLayout morning_ll;
    @BindView(2131363320)
    LinearLayout night_ll;
    @BindView(2131363395)
    RelativeLayout others_rl;
    @BindView(2131364522)
    TextView parliamentHouse;
    @BindView(2131364529)
    TextView phHandicap;
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
    @BindView(2131363579)
    RelativeLayout quota_bottom_ll;
    @BindView(2131363592)
    ImageView rajdhani_img;
    @BindView(2131363593)
    RelativeLayout rajdhani_rl;
    @BindView(2131363842)
    RecyclerView rvViaStation;
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
    @BindView(2131364045)
    ImageView suvidha_train_img;
    @BindView(2131364046)
    RelativeLayout suvidha_train_rl;
    @BindView(2131363127)
    RecyclerView trainList;
    @BindView(2131363128)
    RecyclerView trainListAternate;
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
    @BindView(2131364549)
    TextView tv_quota;
    @BindView(2131364723)
    TextView viaStnHeading;
    @BindView(2131364923)
    ImageView yuva_express_img;
    @BindView(2131364924)
    RelativeLayout yuva_express_rl;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_others.isChecked()) {
                journeyDetailsFragment.ch_others.setChecked(false);
            } else {
                journeyDetailsFragment.ch_others.setChecked(true);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_earlyMorning.isChecked()) {
                journeyDetailsFragment.ch_earlyMorning.setChecked(false);
            } else {
                journeyDetailsFragment.ch_earlyMorning.setChecked(true);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_morning.isChecked()) {
                journeyDetailsFragment.ch_morning.setChecked(false);
            } else {
                journeyDetailsFragment.ch_morning.setChecked(true);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_midDay.isChecked()) {
                journeyDetailsFragment.ch_midDay.setChecked(false);
            } else {
                journeyDetailsFragment.ch_midDay.setChecked(true);
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_night.isChecked()) {
                journeyDetailsFragment.ch_night.setChecked(false);
            } else {
                journeyDetailsFragment.ch_night.setChecked(true);
            }
        }
    }

    public class f implements ViaStationListAdapter.ViaStnListener {
        public f() {
        }

        public final void onItemClick(ViaStationModel viaStationModel) {
            Iterator<ViaStationModel> it = JourneyDetailsFragment.this.f4685e.iterator();
            while (it.hasNext()) {
                ViaStationModel next = it.next();
                if (viaStationModel.a.equalsIgnoreCase(next.a)) {
                    if (next.f5349a) {
                        next.f5349a = false;
                    } else {
                        next.f5349a = true;
                    }
                }
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public final void onClick(View view) {
            int visibility = JourneyDetailsFragment.a.getVisibility();
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (visibility == 0 || journeyDetailsFragment.filter_ll.getVisibility() == 0) {
                journeyDetailsFragment.f();
            } else {
                HomeActivity.A(2);
            }
        }
    }

    public class h implements JourneyDetailsAdapter.Lap1TrainListAdapterListener {
        public h() {
        }

        public final void onTrainLayoutClick(JourneyDetailDTO journeyDetailDTO) {
            LapAllTrainListFragment lapAllTrainListFragment = new LapAllTrainListFragment();
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            journeyDetailsFragment.f4665a.putSerializable("journeyDetailDTO", journeyDetailDTO);
            journeyDetailsFragment.f4665a.putSerializable("JourneyDate", JourneyDetailsFragment.g);
            journeyDetailsFragment.f4665a.putSerializable("selectedQuota", JourneyDetailsFragment.h);
            lapAllTrainListFragment.setArguments(journeyDetailsFragment.f4665a);
            HomeActivity.n(journeyDetailsFragment.getActivity(), lapAllTrainListFragment, C1218kf.TRAIN_LIST.a(), Boolean.TRUE, Boolean.FALSE);
        }
    }

    public class i implements Comparator<JourneyDetailDTO> {
        public final int compare(Object obj, Object obj2) {
            return ((JourneyDetailDTO) obj).getWaitingTime().compareTo(((JourneyDetailDTO) obj2).getWaitingTime());
        }
    }

    public class j implements Comparator<JourneyDetailDTO> {
        public final int compare(Object obj, Object obj2) {
            return ((JourneyDetailDTO) obj2).getWaitingTime().compareTo(((JourneyDetailDTO) obj).getWaitingTime());
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_rajdhani.isChecked()) {
                journeyDetailsFragment.ch_rajdhani.setChecked(false);
            } else {
                journeyDetailsFragment.ch_rajdhani.setChecked(true);
            }
        }
    }

    public class l implements Comparator<JourneyDetailDTO> {
        public final int compare(Object obj, Object obj2) {
            return ((JourneyDetailDTO) obj).getTrainBtwnStnsDTO().get(0).getDepartureTime().compareTo(((JourneyDetailDTO) obj2).getTrainBtwnStnsDTO().get(0).getDepartureTime());
        }
    }

    public class m implements Comparator<JourneyDetailDTO> {
        public final int compare(Object obj, Object obj2) {
            return ((JourneyDetailDTO) obj2).getTrainBtwnStnsDTO().get(0).getDepartureTime().compareTo(((JourneyDetailDTO) obj).getTrainBtwnStnsDTO().get(0).getDepartureTime());
        }
    }

    public class n implements Comparator<JourneyDetailDTO> {
        public final int compare(Object obj, Object obj2) {
            return ((JourneyDetailDTO) obj).getTrainBtwnStnsDTO().get(1).getArrivalTime().compareTo(((JourneyDetailDTO) obj2).getTrainBtwnStnsDTO().get(1).getArrivalTime());
        }
    }

    public class o implements Comparator<JourneyDetailDTO> {
        public final int compare(Object obj, Object obj2) {
            return ((JourneyDetailDTO) obj2).getTrainBtwnStnsDTO().get(1).getArrivalTime().compareTo(((JourneyDetailDTO) obj).getTrainBtwnStnsDTO().get(1).getArrivalTime());
        }
    }

    public class p implements DatePickerDialog.OnDateSetListener {
        public p() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str;
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            journeyDetailsFragment.c = i;
            journeyDetailsFragment.d = i2;
            journeyDetailsFragment.e = i3;
            journeyDetailsFragment.getClass();
            GregorianCalendar gregorianCalendar = new GregorianCalendar(journeyDetailsFragment.c, journeyDetailsFragment.d, journeyDetailsFragment.e);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            new SimpleDateFormat("EEE dd MMM");
            journeyDetailsFragment.f = simpleDateFormat.format(gregorianCalendar.getTime());
            try {
                str = new SimpleDateFormat("EEE, dd MMM  yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(journeyDetailsFragment.f));
            } catch (ParseException e) {
                e.getMessage();
                str = "";
            }
            HomeActivity.H(JourneyDetailsFragment.i + " 2131953827 " + JourneyDetailsFragment.j + " | " + str);
            journeyDetailsFragment.g();
        }
    }

    public class q extends Subscriber<Cf> {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1469x0 f4688a;

        public q(C1469x0 x0Var) {
            this.f4688a = x0Var;
        }

        public final void onCompleted() {
            FragmentActivity fragmentActivity = JourneyDetailsFragment.f4661a;
        }

        public final void onError(Throwable th) {
            FragmentActivity fragmentActivity = JourneyDetailsFragment.f4661a;
            th.getClass();
            th.getMessage();
            JourneyDetailsFragment.this.f4663a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            Cf cf = (Cf) obj;
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (cf != null) {
                journeyDetailsFragment.f4663a.dismiss();
                try {
                    boolean z = false;
                    if (cf.getErrorMessage() != null) {
                        journeyDetailsFragment.f4663a.dismiss();
                        if (!cf.getErrorMessage().contains("50035")) {
                            C0535I5.m(journeyDetailsFragment.getActivity(), false, cf.getErrorMessage().split("-")[0], journeyDetailsFragment.getString(R.string.error), journeyDetailsFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else if (C1450w1.f7013a == 3) {
                            C0535I5.m(journeyDetailsFragment.getActivity(), false, journeyDetailsFragment.getString(R.string.your_account_has_been_suspended), journeyDetailsFragment.getString(R.string.error), journeyDetailsFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else {
                            C0535I5.m(journeyDetailsFragment.getActivity(), false, cf.getErrorMessage().split("-")[0], journeyDetailsFragment.getString(R.string.error), journeyDetailsFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        }
                    } else if (cf.getJourneyDetailDTO() == null) {
                        C0535I5.m(journeyDetailsFragment.getActivity(), false, journeyDetailsFragment.getString(R.string.train_no_found), journeyDetailsFragment.getString(R.string.error), journeyDetailsFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        if (!journeyDetailsFragment.f4681d.equals("") && cf.getJourneyDetailDTO().get(0).getTrainBtwnStnsDTO().get(0).getAvlClasses() != null) {
                            for (TrainBtwnStnsDTO next : cf.getJourneyDetailDTO().get(0).getTrainBtwnStnsDTO()) {
                                for (String next2 : next.getAvlClasses()) {
                                    if (journeyDetailsFragment.f4681d.equalsIgnoreCase(next2)) {
                                        linkedHashSet.add(next);
                                        z = true;
                                    }
                                    boolean equals = journeyDetailsFragment.f4681d.equals("");
                                    HashMap<String, Boolean> hashMap = journeyDetailsFragment.f4675b;
                                    if (!equals) {
                                        if (!journeyDetailsFragment.f4681d.equals(next.getAvlClasses())) {
                                            hashMap.put(next2, Boolean.FALSE);
                                            journeyDetailsFragment.f4671a.add(next2);
                                        }
                                    }
                                    hashMap.put(next2, Boolean.TRUE);
                                    journeyDetailsFragment.f4671a.add(next2);
                                }
                            }
                            journeyDetailsFragment.f4676b = new ArrayList(linkedHashSet);
                        }
                        if (journeyDetailsFragment.f4681d.equals("") || z) {
                            C0535I5.f3647h = true;
                            Bundle bundle = new Bundle();
                            journeyDetailsFragment.f4680c = cf.getJourneyDetailDTO();
                            journeyDetailsFragment.f4683d = cf.getAlternateJourneyDetailDTO();
                            C0535I5.f3648i = cf.isBookingEnable();
                            bundle.putBoolean("indirectjourneyBookingEnable", cf.isBookingEnable());
                            if (!(cf.getInfo() == null || cf.getInfo() == "")) {
                                C0535I5.g = cf.getInfo();
                                bundle.putString("indirectjourneyInfo", cf.getInfo());
                            }
                            JourneyDetailsFragment.g = journeyDetailsFragment.f;
                            JourneyDetailsFragment.i = JourneyDetailsFragment.i;
                            JourneyDetailsFragment.j = JourneyDetailsFragment.j;
                            journeyDetailsFragment.f4678c = journeyDetailsFragment.f4678c;
                            journeyDetailsFragment.f4681d = journeyDetailsFragment.f4681d;
                            this.f4688a.getJrnyClass();
                            journeyDetailsFragment.f4684e = JourneyDetailsFragment.h;
                            journeyDetailsFragment.f4673a = true;
                            if (journeyDetailsFragment.f4663a.isShowing()) {
                                journeyDetailsFragment.f4663a.dismiss();
                            }
                            journeyDetailsFragment.f4677b = true;
                            List<JourneyDetailDTO> list = journeyDetailsFragment.f4680c;
                            if (list != null && list.size() > 0) {
                                journeyDetailsFragment.m(journeyDetailsFragment.f4680c);
                            }
                            List<JourneyDetailDTO> list2 = journeyDetailsFragment.f4683d;
                            if (list2 != null && list2.size() > 0) {
                                journeyDetailsFragment.k(journeyDetailsFragment.f4683d);
                                return;
                            }
                            return;
                        }
                        journeyDetailsFragment.f4663a.dismiss();
                        C0535I5.o(journeyDetailsFragment.getActivity(), journeyDetailsFragment.getString(R.string.train_not_found_selectclass), journeyDetailsFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                } catch (Exception e) {
                    FragmentActivity fragmentActivity = JourneyDetailsFragment.f4661a;
                    e.getMessage();
                    if (journeyDetailsFragment.f4663a.isShowing()) {
                        journeyDetailsFragment.f4663a.dismiss();
                    }
                    C0535I5.t0(journeyDetailsFragment.getActivity(), journeyDetailsFragment.getString(R.string.please_try_again));
                }
            } else {
                journeyDetailsFragment.f4663a.dismiss();
                C0535I5.m(journeyDetailsFragment.getActivity(), false, journeyDetailsFragment.getResources().getString(R.string.unable_process_message), journeyDetailsFragment.getString(R.string.error), journeyDetailsFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_shatabdi.isChecked()) {
                journeyDetailsFragment.ch_shatabdi.setChecked(false);
            } else {
                journeyDetailsFragment.ch_shatabdi.setChecked(true);
            }
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_duranto.isChecked()) {
                journeyDetailsFragment.ch_duranto.setChecked(false);
            } else {
                journeyDetailsFragment.ch_duranto.setChecked(true);
            }
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_special_train.isChecked()) {
                journeyDetailsFragment.ch_special_train.setChecked(false);
            } else {
                journeyDetailsFragment.ch_special_train.setChecked(true);
            }
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_special_tatkal.isChecked()) {
                journeyDetailsFragment.ch_special_tatkal.setChecked(false);
            } else {
                journeyDetailsFragment.ch_special_tatkal.setChecked(true);
            }
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_garibrath.isChecked()) {
                journeyDetailsFragment.ch_garibrath.setChecked(false);
            } else {
                journeyDetailsFragment.ch_garibrath.setChecked(true);
            }
        }
    }

    public class w implements View.OnClickListener {
        public w() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_suvidha_train.isChecked()) {
                journeyDetailsFragment.ch_suvidha_train.setChecked(false);
            } else {
                journeyDetailsFragment.ch_suvidha_train.setChecked(true);
            }
        }
    }

    public class x implements View.OnClickListener {
        public x() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_janshatabdi.isChecked()) {
                journeyDetailsFragment.ch_janshatabdi.setChecked(false);
            } else {
                journeyDetailsFragment.ch_janshatabdi.setChecked(true);
            }
        }
    }

    public class y implements View.OnClickListener {
        public y() {
        }

        public final void onClick(View view) {
            JourneyDetailsFragment journeyDetailsFragment = JourneyDetailsFragment.this;
            if (journeyDetailsFragment.ch_yuva_express.isChecked()) {
                journeyDetailsFragment.ch_yuva_express.setChecked(false);
            } else {
                journeyDetailsFragment.ch_yuva_express.setChecked(true);
            }
        }
    }

    static {
        View.MeasureSpec.makeMeasureSpec(0, 0);
        C1354qp.R(JourneyDetailsFragment.class);
    }

    public JourneyDetailsFragment() {
        new ArrayList();
        new HashMap();
        new ArrayList();
        this.f4681d = "";
        this.f4671a = new HashSet();
        this.f4676b = new ArrayList();
        this.f4682d = new ArrayList();
        new ArrayList();
        new HashMap();
        this.f4673a = false;
        this.f4684e = "";
        this.f4670a = new HashMap<>();
        this.f4675b = new HashMap<>();
        this.f4677b = false;
        this.f4665a = null;
        new ArrayList();
        new ArrayList();
        this.f4668a = new h();
        this.f4686e = new ArrayList();
        this.f4687f = new ArrayList();
    }

    @OnClick({2131361959})
    public void ArrivalLateFirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        j(this.durationLateFirst, R.color.white);
        j(this.durationEarlyFirst, R.color.white);
        j(this.arrivalEarlyFirst, R.color.white);
        j(this.arrivalLateFirst, R.color.dark);
        j(this.departureEarlyFirst, R.color.white);
        j(this.departureLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        o(5);
    }

    @OnClick({2131362198})
    public void Class1AClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("1A")) {
            boolean isChecked = this.class_1A.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_1A.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("1A", Boolean.FALSE);
                return;
            }
            this.class_1A.setChecked(true);
            hashMap.replace("1A", Boolean.TRUE);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362200})
    public void Class2AClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("2A")) {
            boolean isChecked = this.class_2A.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_2A.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("2A", Boolean.FALSE);
                return;
            }
            hashMap.replace("2A", Boolean.TRUE);
            this.class_2A.setChecked(true);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362202})
    public void Class2SClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("2S")) {
            boolean isChecked = this.class_2S.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_2S.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("2S", Boolean.FALSE);
                return;
            }
            hashMap.replace("2S", Boolean.TRUE);
            this.class_2S.setChecked(true);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362204})
    public void Class3AClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("3A")) {
            boolean isChecked = this.class_3A.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_3A.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("3A", Boolean.FALSE);
                return;
            }
            hashMap.replace("3A", Boolean.TRUE);
            this.class_3A.setChecked(true);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362206})
    public void ClassACClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("AC")) {
            boolean isChecked = this.class_AC.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_AC.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("AC", Boolean.FALSE);
                return;
            }
            hashMap.replace("AC", Boolean.TRUE);
            this.class_AC.setChecked(true);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362208})
    public void ClassCCClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("CC")) {
            boolean isChecked = this.class_CC.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_CC.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("CC", Boolean.FALSE);
                return;
            }
            this.class_CC.setChecked(true);
            hashMap.replace("CC", Boolean.TRUE);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362210})
    public void ClassECClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("EC")) {
            boolean isChecked = this.class_EC.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_EC.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("EC", Boolean.FALSE);
            } else {
                hashMap.replace("EC", Boolean.TRUE);
            }
            this.class_EC.setChecked(true);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362213})
    public void ClassFCClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("FC")) {
            boolean isChecked = this.class_FC.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_FC.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("FC", Boolean.FALSE);
                return;
            }
            hashMap.replace("FC", Boolean.TRUE);
            this.class_FC.setChecked(true);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131362215})
    public void ClassSLClick() {
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (arrayList.contains("SL")) {
            boolean isChecked = this.class_SL.isChecked();
            HashMap<String, Boolean> hashMap = this.f4675b;
            if (!isChecked) {
                this.class_SL.setChecked(false);
                this.cbclass.setChecked(false);
                hashMap.replace("SL", Boolean.FALSE);
                return;
            }
            hashMap.replace("SL", Boolean.TRUE);
            this.class_SL.setChecked(true);
            if (h()) {
                this.cbclass.setChecked(true);
            }
        }
    }

    @OnClick({2131361954})
    public void applyFinterClick() {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (this.ch_rajdhani.isChecked() || this.ch_shatabdi.isChecked() || this.ch_duranto.isChecked() || this.ch_special_train.isChecked() || this.ch_special_tatkal.isChecked() || this.ch_garibrath.isChecked() || this.ch_suvidha_train.isChecked() || this.ch_others.isChecked() || this.ch_janshatabdi.isChecked() || this.ch_yuva_express.isChecked() || this.class_1A.isChecked() || this.class_2A.isChecked() || this.class_3A.isChecked() || this.class_EC.isChecked() || this.class_CC.isChecked() || this.class_SL.isChecked() || this.class_2S.isChecked() || this.class_AC.isChecked() || this.class_FC.isChecked()) {
            List<JourneyDetailDTO> list = this.f4686e;
            if (list != null) {
                list.clear();
            }
            ArrayList arrayList3 = this.f4687f;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            ArrayList<String> arrayList4 = this.f4669a;
            arrayList4.clear();
            if (this.ch_rajdhani.isChecked()) {
                arrayList4.add("R");
            }
            if (this.ch_shatabdi.isChecked()) {
                arrayList4.add("S");
            }
            if (this.ch_duranto.isChecked()) {
                arrayList4.add("D");
            }
            if (this.ch_special_train.isChecked()) {
                arrayList4.add("SP");
            }
            if (this.ch_special_tatkal.isChecked()) {
                arrayList4.add("ST");
            }
            if (this.ch_garibrath.isChecked()) {
                arrayList4.add(RequestConfiguration.MAX_AD_CONTENT_RATING_G);
            }
            if (this.ch_others.isChecked()) {
                arrayList4.add("O");
            }
            if (this.ch_suvidha_train.isChecked()) {
                arrayList4.add("SV");
            }
            if (this.ch_janshatabdi.isChecked()) {
                arrayList4.add(PaymentConstants.Category.JS);
            }
            if (this.ch_yuva_express.isChecked()) {
                arrayList4.add("Y");
            }
            this.f4679c.clear();
            if (this.class_1A.isChecked()) {
                this.f4679c.add("1A");
            }
            if (this.class_2A.isChecked()) {
                this.f4679c.add("2A");
            }
            if (this.class_3A.isChecked()) {
                this.f4679c.add("3A");
            }
            if (this.class_EC.isChecked()) {
                this.f4679c.add("EC");
            }
            if (this.class_CC.isChecked()) {
                this.f4679c.add("CC");
            }
            if (this.class_SL.isChecked()) {
                this.f4679c.add("SL");
            }
            if (this.class_2S.isChecked()) {
                this.f4679c.add("2S");
            }
            if (this.class_AC.isChecked()) {
                this.f4679c.add("AC");
            }
            if (this.class_FC.isChecked()) {
                this.f4679c.add("FC");
            }
            ArrayList arrayList5 = new ArrayList();
            if (this.ch_earlyMorning.isChecked()) {
                arrayList5.add(1);
            }
            if (this.ch_morning.isChecked()) {
                arrayList5.add(2);
            }
            if (this.ch_midDay.isChecked()) {
                arrayList5.add(3);
            }
            if (this.ch_night.isChecked()) {
                arrayList5.add(4);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (JourneyDetailDTO next : this.f4680c) {
                for (TrainBtwnStnsDTO next2 : next.getTrainBtwnStnsDTO()) {
                    if (arrayList4.contains(next2.getTrainType().get(0))) {
                        Iterator<ViaStationModel> it = this.f4685e.iterator();
                        while (it.hasNext()) {
                            ViaStationModel next3 = it.next();
                            if (!(!next3.f5349a || !next.getTrainBtwnStnsDTO().get(0).getToStnCode().equalsIgnoreCase(next3.a) || (arrayList2 = this.f4679c) == null || arrayList2.size() == 0 || next2.getAvlClasses() == null)) {
                                for (String contains : next2.getAvlClasses()) {
                                    if (this.f4679c.contains(contains)) {
                                        linkedHashSet.add(next);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList6 = new ArrayList(linkedHashSet);
            this.f4686e = arrayList6;
            m(arrayList6);
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            for (JourneyDetailDTO next4 : this.f4683d) {
                for (TrainBtwnStnsDTO next5 : next4.getTrainBtwnStnsDTO()) {
                    Iterator<ViaStationModel> it2 = this.f4685e.iterator();
                    while (it2.hasNext()) {
                        ViaStationModel next6 = it2.next();
                        if (next6.f5349a && next5.getToStnCode().equalsIgnoreCase(next6.a) && arrayList4.contains(next5.getTrainType().get(0)) && (arrayList = this.f4679c) != null && arrayList.size() != 0 && next5.getAvlClasses() != null) {
                            for (String contains2 : next5.getAvlClasses()) {
                                if (this.f4679c.contains(contains2)) {
                                    linkedHashSet2.add(next4);
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList7 = new ArrayList(linkedHashSet2);
            this.f4687f = arrayList7;
            k(arrayList7);
            if (this.f4686e.size() == 0 && this.f4687f.size() == 0) {
                C0535I5.t0(getContext(), getString(R.string.no_train_available_you_selected));
                this.hide_ll.setVisibility(8);
                return;
            }
            linkedHashSet2.clear();
            this.filter_ll.setVisibility(8);
            this.filter_ll_ll.setVisibility(8);
            this.filter_ll_scroll.setVisibility(8);
            if (this.f4686e.size() <= 3 || (this.f4687f.size() > 0 && this.f4687f.size() <= 3)) {
                this.hide_ll.setVisibility(0);
            } else {
                this.hide_ll.setVisibility(8);
            }
        } else {
            List<JourneyDetailDTO> list2 = this.f4686e;
            if (list2 != null) {
                list2.clear();
            }
            ArrayList arrayList8 = this.f4687f;
            if (arrayList8 != null) {
                arrayList8.clear();
            }
            m(this.f4680c);
            k(this.f4683d);
            this.filter_ll.setVisibility(8);
            this.filter_ll_ll.setVisibility(8);
            this.filter_ll_scroll.setVisibility(8);
        }
    }

    @OnClick({2131361958})
    public void arrivalEarlyirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        j(this.durationLateFirst, R.color.white);
        j(this.durationEarlyFirst, R.color.white);
        j(this.arrivalEarlyFirst, R.color.dark);
        j(this.arrivalLateFirst, R.color.white);
        j(this.departureEarlyFirst, R.color.white);
        j(this.departureLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        o(4);
    }

    @OnClick({2131362389})
    public void departureEarlyirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        j(this.durationLateFirst, R.color.white);
        j(this.durationEarlyFirst, R.color.white);
        j(this.arrivalEarlyFirst, R.color.white);
        j(this.arrivalLateFirst, R.color.white);
        j(this.departureEarlyFirst, R.color.dark);
        j(this.departureLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        o(2);
    }

    @OnClick({2131362390})
    public void departureLateFirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        j(this.durationLateFirst, R.color.white);
        j(this.durationEarlyFirst, R.color.white);
        j(this.arrivalEarlyFirst, R.color.white);
        j(this.arrivalLateFirst, R.color.white);
        j(this.departureEarlyFirst, R.color.white);
        j(this.departureLateFirst, R.color.dark);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        o(3);
    }

    @OnClick({2131362461})
    public void durationEarlyFirst() {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        j(this.durationLateFirst, R.color.white);
        j(this.durationEarlyFirst, R.color.dark);
        j(this.departureEarlyFirst, R.color.white);
        j(this.departureLateFirst, R.color.white);
        j(this.arrivalEarlyFirst, R.color.white);
        j(this.arrivalLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        o(0);
    }

    @OnClick({2131362462})
    public void durationLateFirst() {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        j(this.durationLateFirst, R.color.dark);
        j(this.durationEarlyFirst, R.color.white);
        j(this.departureEarlyFirst, R.color.white);
        j(this.departureLateFirst, R.color.white);
        j(this.arrivalEarlyFirst, R.color.white);
        j(this.arrivalLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        o(1);
    }

    public final void f() {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
    }

    @OnClick({2131362662})
    public void filterBottomLLClick() {
        f();
    }

    @OnClick({2131362660})
    public void filterClick() {
        ImageView imageView = this.rajdhani_img;
        Context context = getContext();
        Object obj = d7.a;
        imageView.setColorFilter(d7.b.a(context, R.color.majenta_color));
        this.shatabdi_img.setColorFilter(d7.b.a(getContext(), R.color.Shatabdi_color));
        this.duranto_img.setColorFilter(d7.b.a(getContext(), R.color.yellow_color1));
        this.special_trian_img.setColorFilter(d7.b.a(getContext(), R.color.maroon_color));
        this.special_tatkal_img.setColorFilter(d7.b.a(getContext(), R.color.light_green_color));
        this.garibrath_img.setColorFilter(d7.b.a(getContext(), R.color.radium_color));
        this.suvidha_train_img.setColorFilter(d7.b.a(getContext(), R.color.green_color));
        this.janshatabdi_img.setColorFilter(d7.b.a(getContext(), R.color.Janshatabdi_color));
        this.yuva_express_img.setColorFilter(d7.b.a(getContext(), R.color.Yuva_train_color));
        f();
        if (this.filter_ll.getVisibility() == 8) {
            this.filter_ll.setVisibility(0);
        } else {
            this.filter_ll.setVisibility(8);
        }
        this.filter_ll_ll.setBackground(getResources().getDrawable(R.drawable.below_popup_white_bg));
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(0);
        this.filter_ll_ll.setVisibility(0);
        this.filter_ll_scroll.setVisibility(0);
    }

    public final void g() {
        Om om;
        ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.train_Search), getString(R.string.please_wait_text));
        this.f4663a = show;
        show.show();
        C1469x0 x0Var = new C1469x0();
        x0Var.setDestStn(j);
        x0Var.setSrcStn(i);
        x0Var.setJrnyDate(this.f);
        x0Var.setFlexiFlag(Boolean.parseBoolean(this.f4678c));
        x0Var.setFlexiJrnyDate(this.f);
        if (C0535I5.R()) {
            om = (Om) C0657Qt.c(C0793b1.a.f3912a);
        } else {
            om = (Om) C0657Qt.b();
        }
        String f2 = C0657Qt.f();
        om.G0(f2 + "indirectTBIS", x0Var).c(C1181iv.a()).a(E0.a()).b(new q(x0Var));
    }

    public final boolean h() {
        this.f4679c = new ArrayList(this.f4671a);
        for (int i2 = 0; i2 < this.f4679c.size(); i2++) {
            if (!this.f4675b.get(this.f4679c.get(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final boolean i() {
        if (this.sortby_bottom_ll.getVisibility() != 0 && this.filter_ll.getVisibility() != 0) {
            return false;
        }
        f();
        return true;
    }

    public final void j(TextView textView, int i2) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i2), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void k(List<JourneyDetailDTO> list) {
        String str = this.f4678c;
        if (str != null && str.equalsIgnoreCase("Y")) {
            this.alterTrainListShow.setVisibility(0);
            if (list.size() == 0) {
                this.tv_alter_train_list_msg.setVisibility(0);
            }
            if (list.size() == 0) {
                this.trainListAternate.setVisibility(8);
                this.tv_alter_train_list_msg.setVisibility(0);
                return;
            }
            this.trainListAternate.setVisibility(0);
            this.tv_alter_train_list_msg.setVisibility(0);
            this.b = new JourneyDetailsAdapter(this.f4664a, list, this.f4668a, this.f4684e, this.f4662a.getFromStation().get(0), this.f4662a.getToStation().get(0));
            this.trainListAternate.setLayoutManager(new LinearLayoutManager(this.f4664a));
            this.trainListAternate.setAdapter(this.b);
        }
    }

    public final void l(String str) {
        if (str != null) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case 2279:
                    if (str.equals("GN")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 2312:
                    if (str.equals("HP")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2424:
                    if (str.equals("LD")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2552:
                    if (str.equals("PH")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 2564:
                    if (str.equals("PT")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2656:
                    if (str.equals("SS")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 2685:
                    if (str.equals("TQ")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    j(this.tvGeneral, R.color.dark);
                    this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.tvGeneral.setVisibility(0);
                    return;
                case 1:
                    j(this.phHandicap, R.color.dark);
                    this.phHandicap.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.phHandicap.setVisibility(0);
                    return;
                case 2:
                    j(this.tvLadies, R.color.dark);
                    this.tvLadies.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.tvLadies.setVisibility(0);
                    return;
                case 3:
                    j(this.parliamentHouse, R.color.dark);
                    this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.parliamentHouse.setVisibility(0);
                    return;
                case 4:
                    j(this.premiumTatkal, R.color.dark);
                    this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.premiumTatkal.setVisibility(0);
                    return;
                case 5:
                    j(this.seniorCitizen, R.color.dark);
                    this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.seniorCitizen.setVisibility(0);
                    return;
                case 6:
                    j(this.tvTatkal, R.color.dark);
                    this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.tvTatkal.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m(List<JourneyDetailDTO> list) {
        if (list.size() == 0) {
            this.trainList.setVisibility(8);
            this.tv_alter_train_list_msg.setVisibility(0);
            return;
        }
        this.trainList.setVisibility(0);
        this.tv_alter_train_list_msg.setVisibility(8);
        this.f4666a = new JourneyDetailsAdapter(this.f4664a, list, this.f4668a, this.f4684e, this.f4662a.getFromStation().get(0), this.f4662a.getToStation().get(0));
        this.trainList.setLayoutManager(new LinearLayoutManager(this.f4664a));
        this.trainList.setAdapter(this.f4666a);
    }

    public final List<JourneyDetailDTO> n(int i2, List<JourneyDetailDTO> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (i2 == 0) {
            Collections.sort(this.f4680c, new i());
        } else if (i2 == 1) {
            Collections.sort(this.f4680c, new j());
        } else if (i2 == 2) {
            Collections.sort(list, new l());
        } else if (i2 == 3) {
            Collections.sort(list, new m());
        } else if (i2 == 4) {
            Collections.sort(list, new n());
        } else if (i2 == 5) {
            Collections.sort(list, new o());
        }
        return list;
    }

    public final void o(int i2) {
        List<JourneyDetailDTO> list = this.f4686e;
        if (list == null || list.size() <= 0) {
            this.f4680c = n(i2, this.f4680c);
            this.f4666a.notifyDataSetChanged();
            return;
        }
        this.f4686e = n(i2, this.f4686e);
        this.f4666a.notifyDataSetChanged();
    }

    @OnClick({2131362147})
    public void onAllClassSelect() {
        boolean isChecked = this.cbclass.isChecked();
        HashMap<String, Boolean> hashMap = this.f4675b;
        if (!isChecked) {
            Boolean bool = Boolean.FALSE;
            hashMap.replace("1A", bool);
            hashMap.replace("2A", bool);
            hashMap.replace("3A", bool);
            hashMap.replace("EC", bool);
            hashMap.replace("CC", bool);
            hashMap.replace("SL", bool);
            hashMap.replace("2S", bool);
            hashMap.replace("AC", bool);
            hashMap.replace("FC", bool);
            this.class_1A.setChecked(false);
            this.class_2A.setChecked(false);
            this.class_3A.setChecked(false);
            this.class_EC.setChecked(false);
            this.class_CC.setChecked(false);
            this.class_SL.setChecked(false);
            this.class_2S.setChecked(false);
            this.class_AC.setChecked(false);
            this.class_FC.setChecked(false);
            return;
        }
        ArrayList arrayList = new ArrayList(this.f4671a);
        this.f4679c = arrayList;
        if (!arrayList.contains("1A")) {
            this.class_1A_ll.setVisibility(8);
        } else {
            this.class_1A.setChecked(true);
            hashMap.replace("1A", Boolean.TRUE);
        }
        if (!this.f4679c.contains("2A")) {
            this.class_2A_ll.setVisibility(8);
        } else {
            this.class_2A.setChecked(true);
            hashMap.replace("2A", Boolean.FALSE);
        }
        if (!this.f4679c.contains("3A")) {
            this.class_3A_ll.setVisibility(8);
        } else {
            this.class_3A.setChecked(true);
            hashMap.replace("3A", Boolean.FALSE);
        }
        if (!this.f4679c.contains("EC")) {
            this.class_EC_ll.setVisibility(8);
        } else {
            this.class_EC.setChecked(true);
            hashMap.replace("EC", Boolean.FALSE);
        }
        if (!this.f4679c.contains("CC")) {
            this.class_CC_ll.setVisibility(8);
        } else {
            this.class_CC.setChecked(true);
            hashMap.replace("CC", Boolean.FALSE);
        }
        if (!this.f4679c.contains("SL")) {
            this.class_SL_ll.setVisibility(8);
        } else {
            this.class_SL.setChecked(true);
            hashMap.replace("SL", Boolean.FALSE);
        }
        if (!this.f4679c.contains("2S")) {
            this.class_2S_ll.setVisibility(8);
        } else {
            this.class_2S.setChecked(true);
            hashMap.replace("2S", Boolean.FALSE);
        }
        if (!this.f4679c.contains("AC")) {
            this.class_AC_ll.setVisibility(8);
        } else {
            this.class_AC.setChecked(true);
            hashMap.replace("AC", Boolean.FALSE);
        }
        if (!this.f4679c.contains("FC")) {
            this.class_FC_ll.setVisibility(8);
            return;
        }
        this.class_FC.setChecked(true);
        hashMap.replace("FC", Boolean.FALSE);
    }

    @OnClick({2131364549})
    public void onClickQuota(View view) {
        if (C1450w1.f7024c) {
            this.parliamentHouse.setVisibility(0);
        } else {
            this.parliamentHouse.setVisibility(8);
        }
        this.tvLadies.setVisibility(0);
        this.tvTatkal.setVisibility(0);
        this.seniorCitizen.setVisibility(0);
        this.premiumTatkal.setVisibility(0);
        this.phHandicap.setVisibility(0);
        this.f = g;
        l(h);
        if (this.quota_bottom_ll.getVisibility() == 0) {
            this.quota_bottom_ll.setVisibility(8);
        } else {
            this.quota_bottom_ll.setVisibility(0);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.activity_train_list, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4664a = getContext();
        f4661a = getActivity();
        getFragmentManager();
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_station_list);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_train_name);
        a = (RelativeLayout) inflate.findViewById(R.id.route_rl);
        this.durationEarlyFirst.setVisibility(0);
        this.durationLateFirst.setVisibility(0);
        this.departureEarlyFirst.setVisibility(0);
        this.departureLateFirst.setVisibility(0);
        this.arrivalEarlyFirst.setVisibility(0);
        this.arrivalLateFirst.setVisibility(0);
        this.departure.setVisibility(8);
        this.arrival.setVisibility(8);
        this.travelTime.setVisibility(8);
        this.available.setVisibility(8);
        this.earlyMorning_ll.setVisibility(8);
        this.morning_ll.setVisibility(8);
        this.midDay_ll.setVisibility(8);
        this.night_ll.setVisibility(8);
        this.alterTrainListShow.setVisibility(8);
        this.trainTypeHeading.setVisibility(0);
        this.viaStnHeading.setVisibility(0);
        this.rvViaStation.setVisibility(0);
        Bundle arguments = getArguments();
        this.f4665a = arguments;
        if (!this.f4677b && arguments != null) {
            Cf cf = (Cf) arguments.getSerializable("indirectTbisResponse");
            this.f4662a = cf;
            this.f4680c = cf.getJourneyDetailDTO();
            this.f4683d = this.f4662a.getAlternateJourneyDetailDTO();
            ArrayList arrayList = (ArrayList) this.f4665a.getSerializable("trainBtwnStnsModelsListFilter");
            ArrayList arrayList2 = (ArrayList) this.f4665a.getSerializable("alternateTrainBtwnStnsListFilter");
            i = this.f4665a.getString("FromStationCode");
            j = this.f4665a.getString("ToStationCode");
            this.f4665a.getString("FromStationString");
            this.f4665a.getString("ToStationString");
            this.f4678c = this.f4665a.getString("flexiableWithDate");
            this.f4665a.getString("spConcession");
            g = this.f4665a.getString("JourneyDate");
            this.f4665a.getBoolean("isConnectingJourney");
            this.f4665a.getBoolean("rebookFlag");
            this.f4681d = this.f4665a.getString("jrnyClass");
            this.f4665a.getBoolean("rebookFlag");
            AvlClassModel avlClassModel = (AvlClassModel) this.f4665a.getSerializable("avlClassModel");
            TrainBtwnStnsModel trainBtwnStnsModel = (TrainBtwnStnsModel) this.f4665a.getSerializable("trainBtwnStnsModel");
            this.f4665a.getBoolean("altAvlEnqFlag");
            this.f4665a.getBoolean("trainAvailableBerthIsChecked");
            this.f4665a.getString("altAvlClass");
            this.f4684e = this.f4665a.getString("selectedQuota");
            ArrayList arrayList3 = (ArrayList) this.f4665a.getSerializable("reebookPsgnList");
            this.f4672a = this.f4662a.getQuotaList();
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        googleAdParamDTO.setSource(i);
        googleAdParamDTO.setDestination(j);
        C0535I5.Y(getActivity(), this.publisherAdViewtop, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.publisherAdViewcenter, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.publisherAdViewbottom, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.publisherAdViewbottomrout_map, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.train_list_filter, googleAdParamDTO);
        String str2 = "";
        if (this.f4681d.equals(str2)) {
            this.cbclass.setChecked(true);
        }
        ArrayList arrayList4 = new ArrayList();
        List<JourneyDetailDTO> list = this.f4680c;
        HashSet hashSet = this.f4671a;
        HashMap<String, Boolean> hashMap = this.f4670a;
        ArrayList<String> arrayList5 = this.f4674b;
        HashMap<String, Boolean> hashMap2 = this.f4675b;
        if (list != null) {
            for (JourneyDetailDTO next : list) {
                for (TrainBtwnStnsDTO next2 : next.getTrainBtwnStnsDTO()) {
                    if (!arrayList4.contains(next.getTrainBtwnStnsDTO().get(0).getToStnCode())) {
                        arrayList4.add(next.getTrainBtwnStnsDTO().get(0).getToStnCode());
                    }
                    arrayList5.add(next2.getTrainType().get(0));
                    hashMap.put(next2.getTrainType().get(0), Boolean.TRUE);
                    if (next2.getAvlClasses() != null) {
                        for (String next3 : next2.getAvlClasses()) {
                            if (this.f4681d.equals(str2) || this.f4681d.equals(next3)) {
                                hashMap2.put(next3, Boolean.TRUE);
                            } else {
                                hashMap2.put(next3, Boolean.FALSE);
                            }
                            this.f4679c.add(next3);
                            hashSet.add(next3);
                        }
                    }
                }
            }
        }
        List<JourneyDetailDTO> list2 = this.f4683d;
        if (list2 != null) {
            for (JourneyDetailDTO next4 : list2) {
                for (TrainBtwnStnsDTO next5 : next4.getTrainBtwnStnsDTO()) {
                    if (!arrayList4.contains(next4.getTrainBtwnStnsDTO().get(0).getToStnCode())) {
                        arrayList4.add(next4.getTrainBtwnStnsDTO().get(0).getToStnCode());
                    }
                    arrayList5.add(next5.getTrainType().get(0));
                    hashMap.put(next5.getTrainType().get(0), Boolean.TRUE);
                    if (next5.getAvlClasses() != null) {
                        for (String next6 : next5.getAvlClasses()) {
                            if (this.f4681d.equals(str2) || this.f4681d.equals(next6)) {
                                hashMap2.put(next6, Boolean.TRUE);
                            } else {
                                hashMap2.put(next6, Boolean.FALSE);
                            }
                            this.f4679c.add(next6);
                            hashSet.add(next6);
                        }
                    }
                }
            }
        }
        if (!arrayList5.contains("R")) {
            this.rajdhani_rl.setVisibility(8);
        } else if (hashMap.get("R").booleanValue()) {
            this.ch_rajdhani.setChecked(true);
        } else {
            this.ch_rajdhani.setChecked(false);
        }
        if (!arrayList5.contains("S")) {
            this.shatabdi_rl.setVisibility(8);
        } else if (hashMap.get("S").booleanValue()) {
            this.ch_shatabdi.setChecked(true);
        } else {
            this.ch_shatabdi.setChecked(false);
        }
        if (!arrayList5.contains("D")) {
            this.duronto_rl.setVisibility(8);
        } else if (hashMap.get("D").booleanValue()) {
            this.ch_duranto.setChecked(true);
        } else {
            this.ch_duranto.setChecked(false);
        }
        if (!arrayList5.contains("SP")) {
            this.special_trian_rl.setVisibility(8);
        } else if (hashMap.get("SP").booleanValue()) {
            this.ch_special_train.setChecked(true);
        } else {
            this.ch_special_train.setChecked(false);
        }
        if (!arrayList5.contains("ST")) {
            this.special_tatkal_rl.setVisibility(8);
        } else if (hashMap.get("ST").booleanValue()) {
            this.ch_special_tatkal.setChecked(true);
        } else {
            this.ch_special_tatkal.setChecked(false);
        }
        if (!arrayList5.contains(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
            this.garibrath_rl.setVisibility(8);
        } else if (hashMap.get(RequestConfiguration.MAX_AD_CONTENT_RATING_G).booleanValue()) {
            this.ch_garibrath.setChecked(true);
        } else {
            this.ch_garibrath.setChecked(false);
        }
        if (!arrayList5.contains("SV")) {
            this.suvidha_train_rl.setVisibility(8);
        } else if (hashMap.get("SV").booleanValue()) {
            this.ch_suvidha_train.setChecked(true);
        } else {
            this.ch_suvidha_train.setChecked(false);
        }
        if (!arrayList5.contains(PaymentConstants.Category.JS)) {
            this.janshatabdi_rl.setVisibility(8);
        } else if (hashMap.get(PaymentConstants.Category.JS).booleanValue()) {
            this.ch_janshatabdi.setChecked(true);
        } else {
            this.ch_janshatabdi.setChecked(false);
        }
        if (!arrayList5.contains("Y")) {
            this.yuva_express_rl.setVisibility(8);
        } else if (hashMap.get("Y").booleanValue()) {
            this.ch_yuva_express.setChecked(true);
        } else {
            this.ch_yuva_express.setChecked(false);
        }
        if (!arrayList5.contains("O")) {
            this.others_rl.setVisibility(8);
        } else if (hashMap.get("O").booleanValue()) {
            this.ch_others.setChecked(true);
        } else {
            this.ch_others.setChecked(false);
        }
        if (!this.f4679c.contains("1A")) {
            this.class_1A_ll.setVisibility(8);
        } else if (hashMap2.get("1A").booleanValue()) {
            this.class_1A.setChecked(true);
        } else {
            this.class_1A.setChecked(false);
        }
        if (!this.f4679c.contains("2A")) {
            this.class_2A_ll.setVisibility(8);
        } else if (hashMap2.get("2A").booleanValue()) {
            this.class_2A.setChecked(true);
        } else {
            this.class_2A.setChecked(false);
        }
        if (!this.f4679c.contains("3A")) {
            this.class_3A_ll.setVisibility(8);
        } else if (hashMap2.get("3A").booleanValue()) {
            this.class_3A.setChecked(true);
        } else {
            this.class_3A.setChecked(false);
        }
        if (!this.f4679c.contains("EC")) {
            this.class_EC_ll.setVisibility(8);
        } else if (hashMap2.get("EC").booleanValue()) {
            this.class_EC.setChecked(true);
        } else {
            this.class_EC.setChecked(false);
        }
        if (!this.f4679c.contains("CC")) {
            this.class_CC_ll.setVisibility(8);
        } else if (hashMap2.get("CC").booleanValue()) {
            this.class_CC.setChecked(true);
        } else {
            this.class_EC.setChecked(false);
        }
        if (!this.f4679c.contains("SL")) {
            this.class_SL_ll.setVisibility(8);
        } else if (hashMap2.get("SL").booleanValue()) {
            this.class_SL.setChecked(true);
        } else {
            this.class_SL.setChecked(false);
        }
        if (!this.f4679c.contains("2S")) {
            this.class_2S_ll.setVisibility(8);
        } else if (hashMap2.get("2S").booleanValue()) {
            this.class_2S.setChecked(true);
        } else {
            this.class_2S.setChecked(false);
        }
        if (!this.f4679c.contains("AC")) {
            this.class_AC_ll.setVisibility(8);
        } else if (hashMap2.get("AC").booleanValue()) {
            this.class_AC.setChecked(true);
        } else {
            this.class_AC.setChecked(false);
        }
        if (!this.f4679c.contains("FC")) {
            this.class_FC_ll.setVisibility(8);
        } else if (hashMap2.get("FC").booleanValue()) {
            this.class_FC.setChecked(true);
        } else {
            this.class_FC.setChecked(false);
        }
        this.rajdhani_rl.setOnClickListener(new k());
        this.shatabdi_rl.setOnClickListener(new r());
        this.duronto_rl.setOnClickListener(new s());
        this.special_trian_rl.setOnClickListener(new t());
        this.special_tatkal_rl.setOnClickListener(new u());
        this.garibrath_rl.setOnClickListener(new v());
        this.suvidha_train_rl.setOnClickListener(new w());
        this.janshatabdi_rl.setOnClickListener(new x());
        this.yuva_express_rl.setOnClickListener(new y());
        this.others_rl.setOnClickListener(new a());
        this.earlyMorning_ll.setOnClickListener(new b());
        this.morning_ll.setOnClickListener(new c());
        this.midDay_ll.setOnClickListener(new d());
        this.night_ll.setOnClickListener(new e());
        try {
            str = new SimpleDateFormat("EEE, dd MMM  yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(g));
        } catch (ParseException e2) {
            e2.getMessage();
            str = str2;
        }
        HomeActivity.H(i + " 2131953827 " + j + " | " + str);
        lf.x(new StringBuilder("Departure From "), i, this.departureFrom);
        this.departureFrom.setVisibility(8);
        if (this.f4680c == null) {
            this.f4680c = new ArrayList();
        }
        m(this.f4680c);
        if (this.f4683d == null) {
            this.f4683d = new ArrayList();
        }
        k(this.f4683d);
        if (this.f4680c.size() > 0) {
            durationEarlyFirst();
        }
        if (!this.f4673a) {
            this.f4685e = new ArrayList<>();
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                ViaStationModel viaStationModel = new ViaStationModel((String) it.next());
                viaStationModel.f5349a = true;
                this.f4685e.add(viaStationModel);
            }
        }
        this.f4667a = new ViaStationListAdapter(this.f4664a, this.f4685e, new f());
        this.rvViaStation.setLayoutManager(new LinearLayoutManager(this.f4664a));
        this.rvViaStation.setAdapter(this.f4667a);
        String str3 = this.f4684e;
        h = str3;
        l(str3);
        HomeActivity.f4191e.setOnClickListener(new g());
        if (H9.f(this.f4684e) != null) {
            str2 = " " + C0535I5.s0(H9.f(this.f4684e).a());
        }
        this.tv_quota.setText(str2);
        if (str2.equals(" Parliament House")) {
            this.tv_quota.setTextSize(13.0f);
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4663a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4663a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364429})
    public void onGeneralClick(View view) {
        h = "GN";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.a.a();
        }
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.quota_bottom_ll.setVisibility(8);
        this.tv_quota.setText(getString(R.string.generalString));
        j(this.tvGeneral, R.color.dark);
        j(this.tvLadies, R.color.white);
        j(this.seniorCitizen, R.color.white);
        j(this.tvTatkal, R.color.white);
        j(this.premiumTatkal, R.color.white);
        j(this.phHandicap, R.color.white);
        j(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
        g();
    }

    @OnClick({2131364529})
    public void onHandicapClick(View view) {
        h = "HP";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.e.a();
        }
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.tv_quota.setText(getString(R.string.DivyangjanString));
        this.quota_bottom_ll.setVisibility(8);
        j(this.tvGeneral, R.color.white);
        j(this.tvLadies, R.color.white);
        j(this.seniorCitizen, R.color.white);
        j(this.tvTatkal, R.color.white);
        j(this.premiumTatkal, R.color.white);
        j(this.phHandicap, R.color.dark);
        j(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForbold);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
        C0535I5.p(getContext(), false, getResources().getString(R.string.spc_popUp_Msgs), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        g();
    }

    @OnClick({2131362103})
    public void onJourneyDateClick() {
        Date date;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.get(1);
        gregorianCalendar.get(2);
        gregorianCalendar.get(5);
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(g);
        } catch (Exception e2) {
            e2.getMessage();
            date = null;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTime(date);
        this.c = gregorianCalendar2.get(1);
        this.d = gregorianCalendar2.get(2);
        this.e = gregorianCalendar2.get(5);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new p(), this.c, this.d, this.e);
        datePickerDialog.getDatePicker().setMinDate(gregorianCalendar.getTimeInMillis() - 1000);
        String str = "66";
        try {
            String str2 = C1450w1.f7023c.get("CALENDAR_DAYS");
            if (str2 != null) {
                str = str2;
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        gregorianCalendar.add(5, Integer.parseInt(str));
        datePickerDialog.getDatePicker().setMaxDate(gregorianCalendar.getTimeInMillis());
        datePickerDialog.show();
    }

    @OnClick({2131364452})
    public void onLadiesQuotaClick(View view) {
        h = "LD";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.b.a();
        }
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.tv_quota.setText(getString(R.string.ladiesString));
        this.quota_bottom_ll.setVisibility(8);
        j(this.tvGeneral, R.color.white);
        j(this.tvLadies, R.color.dark);
        j(this.seniorCitizen, R.color.white);
        j(this.tvTatkal, R.color.white);
        j(this.premiumTatkal, R.color.white);
        j(this.phHandicap, R.color.white);
        j(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForbold);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
        g();
    }

    @OnClick({2131364522})
    public void onParliamentHouseClick(View view) {
        h = "PH";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.h.a();
        }
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.tv_quota.setText(getString(R.string.parliamentHouseString));
        this.quota_bottom_ll.setVisibility(8);
        j(this.tvGeneral, R.color.white);
        j(this.tvLadies, R.color.white);
        j(this.seniorCitizen, R.color.white);
        j(this.tvTatkal, R.color.white);
        j(this.premiumTatkal, R.color.white);
        j(this.phHandicap, R.color.white);
        j(this.parliamentHouse, R.color.dark);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
        g();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4663a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4663a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364537})
    public void onPremiumTatkalClick(View view) {
        h = "PT";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.g.a();
        }
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.tv_quota.setText(getString(R.string.premiumTatkalString));
        this.quota_bottom_ll.setVisibility(8);
        j(this.tvGeneral, R.color.white);
        j(this.tvLadies, R.color.white);
        j(this.seniorCitizen, R.color.white);
        j(this.tvTatkal, R.color.white);
        j(this.premiumTatkal, R.color.dark);
        j(this.phHandicap, R.color.white);
        j(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
        g();
    }

    @OnClick({2131363579})
    public void onQuotaLayout() {
        if (this.quota_bottom_ll.getVisibility() == 0) {
            this.quota_bottom_ll.setVisibility(8);
        } else {
            this.quota_bottom_ll.setVisibility(0);
        }
    }

    public final void onResume() {
        super.onResume();
        if (HomeActivity.f4186b) {
            HomeActivity.f4186b = false;
        }
    }

    @OnClick({2131364597})
    public void onSeniorCitizenClick(View view) {
        h = "SS";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.d.a();
        }
        view.setSelected(true);
        this.tvLadies.setSelected(false);
        this.tvGeneral.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.tv_quota.setText(getString(R.string.seniorCitizenString));
        this.quota_bottom_ll.setVisibility(8);
        j(this.tvGeneral, R.color.white);
        j(this.tvLadies, R.color.white);
        j(this.seniorCitizen, R.color.dark);
        j(this.tvTatkal, R.color.white);
        j(this.premiumTatkal, R.color.white);
        j(this.phHandicap, R.color.white);
        j(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForbold);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
        C0535I5.p(getContext(), false, getResources().getString(R.string.senior_citizen_msg), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        g();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4663a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4663a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364655})
    public void onTatkalClick(View view) {
        h = "TQ";
        if (!IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            H9.c.a();
        }
        view.setSelected(true);
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        this.tv_quota.setText(getString(R.string.tatkalString));
        this.quota_bottom_ll.setVisibility(8);
        j(this.tvGeneral, R.color.white);
        j(this.tvLadies, R.color.white);
        j(this.seniorCitizen, R.color.white);
        j(this.tvTatkal, R.color.dark);
        j(this.premiumTatkal, R.color.white);
        j(this.phHandicap, R.color.white);
        j(this.parliamentHouse, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
        g();
    }

    @OnClick({2131363579})
    public void quotaBottomLLClick() {
        f();
    }

    @OnClick({2131363686})
    public void resetFilter() {
        this.ch_rajdhani.setChecked(false);
        this.ch_shatabdi.setChecked(false);
        this.ch_duranto.setChecked(false);
        this.ch_special_train.setChecked(false);
        this.ch_special_tatkal.setChecked(false);
        this.ch_garibrath.setChecked(false);
        this.ch_yuva_express.setChecked(false);
        this.ch_janshatabdi.setChecked(false);
        this.ch_suvidha_train.setChecked(false);
        this.ch_others.setChecked(false);
        this.class_1A.setChecked(false);
        this.class_2A.setChecked(false);
        this.class_3A.setChecked(false);
        this.class_EC.setChecked(false);
        this.class_CC.setChecked(false);
        this.class_SL.setChecked(false);
        this.class_2S.setChecked(false);
        this.class_AC.setChecked(false);
        this.class_FC.setChecked(false);
        this.ch_earlyMorning.setChecked(true);
        this.ch_morning.setChecked(true);
        this.ch_midDay.setChecked(true);
        this.ch_night.setChecked(true);
        ArrayList<String> arrayList = this.f4674b;
        if (!arrayList.contains("R")) {
            this.rajdhani_rl.setVisibility(8);
        } else {
            this.ch_rajdhani.setChecked(true);
        }
        if (!arrayList.contains("S")) {
            this.shatabdi_rl.setVisibility(8);
        } else {
            this.ch_shatabdi.setChecked(true);
        }
        if (!arrayList.contains("D")) {
            this.duronto_rl.setVisibility(8);
        } else {
            this.ch_duranto.setChecked(true);
        }
        if (!arrayList.contains("SP")) {
            this.special_trian_rl.setVisibility(8);
        } else {
            this.ch_special_train.setChecked(true);
        }
        if (!arrayList.contains("ST")) {
            this.special_tatkal_rl.setVisibility(8);
        } else {
            this.ch_special_tatkal.setChecked(true);
        }
        if (!arrayList.contains(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
            this.garibrath_rl.setVisibility(8);
        } else {
            this.ch_garibrath.setChecked(true);
        }
        if (!arrayList.contains("SV")) {
            this.suvidha_train_rl.setVisibility(8);
        } else {
            this.ch_suvidha_train.setChecked(true);
        }
        if (!arrayList.contains(PaymentConstants.Category.JS)) {
            this.janshatabdi_rl.setVisibility(8);
        } else {
            this.ch_janshatabdi.setChecked(true);
        }
        if (!arrayList.contains("Y")) {
            this.yuva_express_rl.setVisibility(8);
        } else {
            this.ch_yuva_express.setChecked(true);
        }
        if (!arrayList.contains("O")) {
            this.others_rl.setVisibility(8);
        } else {
            this.ch_others.setChecked(true);
        }
        ArrayList arrayList2 = new ArrayList(this.f4671a);
        this.f4679c = arrayList2;
        if (!arrayList2.contains("1A")) {
            this.class_1A_ll.setVisibility(8);
        } else {
            this.class_1A.setChecked(true);
        }
        if (!this.f4679c.contains("2A")) {
            this.class_2A_ll.setVisibility(8);
        } else {
            this.class_2A.setChecked(true);
        }
        if (!this.f4679c.contains("3A")) {
            this.class_3A_ll.setVisibility(8);
        } else {
            this.class_3A.setChecked(true);
        }
        if (!this.f4679c.contains("EC")) {
            this.class_EC_ll.setVisibility(8);
        } else {
            this.class_EC.setChecked(true);
        }
        if (!this.f4679c.contains("CC")) {
            this.class_CC_ll.setVisibility(8);
        } else {
            this.class_CC.setChecked(true);
        }
        if (!this.f4679c.contains("SL")) {
            this.class_SL_ll.setVisibility(8);
        } else {
            this.class_SL.setChecked(true);
        }
        if (!this.f4679c.contains("2S")) {
            this.class_2S_ll.setVisibility(8);
        } else {
            this.class_2S.setChecked(true);
        }
        if (!this.f4679c.contains("AC")) {
            this.class_AC_ll.setVisibility(8);
        } else {
            this.class_AC.setChecked(true);
        }
        if (!this.f4679c.contains("FC")) {
            this.class_FC_ll.setVisibility(8);
        } else {
            this.class_FC.setChecked(true);
        }
        List<TrainBtwnStnsModel> list = this.f4676b;
        if (list != null) {
            list.clear();
        }
        ArrayList arrayList3 = this.f4682d;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        Iterator<ViaStationModel> it = this.f4685e.iterator();
        while (it.hasNext()) {
            it.next().f5349a = true;
        }
        this.f4667a.notifyDataSetChanged();
    }

    @OnClick({2131363978})
    public void sortBottomLLClick() {
        f();
    }

    @OnClick({2131363976})
    public void sortbyLLClick() {
        f();
        if (this.sortby_bottom_ll.getVisibility() == 8) {
            this.sortby_bottom_ll.setVisibility(0);
        } else {
            this.sortby_bottom_ll.setVisibility(8);
        }
        this.filter_ll.setVisibility(8);
    }
}
