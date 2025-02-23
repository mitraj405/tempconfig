package cris.org.in.ima.fragment;

import android.app.DatePickerDialog;
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
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
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
import butterknife.OnClick;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.FareBreakupActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.TrainListViewHolder;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.AvlClassModel;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.ClassAvlDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import defpackage.d7;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import rx.Subscriber;

public class AllTrainListFragment extends Fragment {
    public static RelativeLayout a;

    /* renamed from: a  reason: collision with other field name */
    public static TextView f4408a;

    /* renamed from: a  reason: collision with other field name */
    public static FragmentActivity f4409a;

    /* renamed from: a  reason: collision with other field name */
    public static RecyclerView f4410a;

    /* renamed from: a  reason: collision with other field name */
    public static AdManagerAdView f4411a;

    /* renamed from: a  reason: collision with other field name */
    public static final GoogleAdParamDTO f4412a = new GoogleAdParamDTO();

    /* renamed from: a  reason: collision with other field name */
    public static AvlFareResponseDTO f4413a;
    public static TextView b;

    /* renamed from: b  reason: collision with other field name */
    public static TrainBtwnStnsModel f4414b;

    /* renamed from: b  reason: collision with other field name */
    public static C1060d2 f4415b;
    public static boolean i;
    public static String j = null;

    /* renamed from: j  reason: collision with other field name */
    public static boolean f4416j;
    public static String k = null;

    /* renamed from: k  reason: collision with other field name */
    public static boolean f4417k = false;
    public static String l;

    /* renamed from: l  reason: collision with other field name */
    public static boolean f4418l;
    public static String m = "";
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    @BindView(2131361794)
    LinearLayout Allclass_ll;

    /* renamed from: a  reason: collision with other field name */
    public final C0573L6 f4419a = new C0573L6();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4420a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4421a;

    /* renamed from: a  reason: collision with other field name */
    public TrainListViewHolder f4422a;

    /* renamed from: a  reason: collision with other field name */
    public final g f4423a;

    /* renamed from: a  reason: collision with other field name */
    public AvlClassModel f4424a;

    /* renamed from: a  reason: collision with other field name */
    public TrainBtwnStnsModel f4425a;

    /* renamed from: a  reason: collision with other field name */
    public C1060d2 f4426a;

    /* renamed from: a  reason: collision with other field name */
    public C1081e2 f4427a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4428a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, ArrayList> f4429a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f4430a;

    /* renamed from: a  reason: collision with other field name */
    public Set<String> f4431a;

    /* renamed from: a  reason: collision with other field name */
    public C1455wA f4432a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4433a;
    @BindView(2131364290)
    TextView alterTrainListShow;
    @BindView(2131361957)
    TextView arrival;
    @BindView(2131361958)
    TextView arrivalEarlyFirst;
    @BindView(2131361959)
    TextView arrivalLateFirst;
    @BindView(2131362011)
    RecyclerView availabilityView;
    @BindView(2131364301)
    TextView availableButton;

    /* renamed from: b  reason: collision with other field name */
    public TrainListViewHolder f4434b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<String> f4435b;

    /* renamed from: b  reason: collision with other field name */
    public HashMap<String, Boolean> f4436b;

    /* renamed from: b  reason: collision with other field name */
    public List<TrainBtwnStnsModel> f4437b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4438b;
    @BindView(2131364318)
    TextView bkgStatus;
    @BindView(2131362070)
    LinearLayout bottomFareAndButtonLayout;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4439c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList f4440c;

    /* renamed from: c  reason: collision with other field name */
    public HashMap<String, Boolean> f4441c;

    /* renamed from: c  reason: collision with other field name */
    public List<TrainBtwnStnsModel> f4442c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4443c;
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
    @BindView(2131362212)
    CheckBox class_EV;
    @BindView(2131362213)
    CheckBox class_FC;
    @BindView(2131362214)
    LinearLayout class_FC_ll;
    @BindView(2131362215)
    CheckBox class_SL;
    @BindView(2131362216)
    LinearLayout class_SL_ll;
    @BindView(2131362217)
    CheckBox class_VC;
    @BindView(2131362218)
    CheckBox class_VS;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f4444d;

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList f4445d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f4446d;
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
    public String f4447e;

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4448e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f4449e;
    @BindView(2131362466)
    LinearLayout earlyMorning_ll;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public String f4450f;

    /* renamed from: f  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4451f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f4452f;
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

    /* renamed from: g  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4453g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f4454g;
    @BindView(2131362724)
    ImageView garibrath_img;
    @BindView(2131362725)
    RelativeLayout garibrath_rl;
    @BindView(2131363441)
    TextView goTopassangerDetail;
    public String h;

    /* renamed from: h  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4455h;

    /* renamed from: h  reason: collision with other field name */
    public boolean f4456h;
    @BindView(2131362776)
    RelativeLayout hide_ll;

    /* renamed from: i  reason: collision with other field name */
    public final String f4457i;
    @BindView(2131364532)
    EditText inputPnr;
    @BindView(2131362916)
    ImageView janshatabdi_img;
    @BindView(2131362917)
    RelativeLayout janshatabdi_rl;
    @BindView(2131362946)
    RelativeLayout lastTransationDtail;
    @BindView(2131364661)
    TextView lastTransationTimeStamp;
    @BindView(2131362948)
    LinearLayout last_txn_layout;
    @BindView(2131362949)
    RelativeLayout last_txn_ll;
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
    @BindView(2131363563)
    AdManagerAdView publisherAdViewcenter;
    @BindView(2131363561)
    AdManagerAdView publisherAdViewtop;
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
    @BindView(2131364186)
    TextView total_fare_lll;
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
    @BindView(2131364200)
    AdManagerAdView train_list_filter;
    @BindView(2131364694)
    TextView transationNumber;
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
    @BindView(2131364388)
    TextView tv_dutypass_l;
    @BindView(2131364549)
    TextView tv_quota;
    @BindView(2131364848)
    LinearLayout vistadome_ac_ll;
    @BindView(2131364849)
    LinearLayout vistadome_chair_car_ll;
    @BindView(2131364850)
    LinearLayout vistadome_non_ac_ll;
    @BindView(2131364923)
    ImageView yuva_express_img;
    @BindView(2131364924)
    RelativeLayout yuva_express_rl;

    public class a implements Comparator<TrainBtwnStnsModel> {
        public final int compare(Object obj, Object obj2) {
            return ((TrainBtwnStnsModel) obj2).f5342a.getDuration().compareTo(((TrainBtwnStnsModel) obj).f5342a.getDuration());
        }
    }

    public class b implements Comparator<TrainBtwnStnsModel> {
        public final int compare(Object obj, Object obj2) {
            return ((TrainBtwnStnsModel) obj).f5342a.getDepartureTime().compareTo(((TrainBtwnStnsModel) obj2).f5342a.getDepartureTime());
        }
    }

    public class c implements Comparator<TrainBtwnStnsModel> {
        public final int compare(Object obj, Object obj2) {
            return ((TrainBtwnStnsModel) obj2).f5342a.getDepartureTime().compareTo(((TrainBtwnStnsModel) obj).f5342a.getDepartureTime());
        }
    }

    public class d implements Comparator<TrainBtwnStnsModel> {
        public final int compare(Object obj, Object obj2) {
            return ((TrainBtwnStnsModel) obj).f5342a.getArrivalTime().compareTo(((TrainBtwnStnsModel) obj2).f5342a.getArrivalTime());
        }
    }

    public class e implements Comparator<TrainBtwnStnsModel> {
        public final int compare(Object obj, Object obj2) {
            return ((TrainBtwnStnsModel) obj2).f5342a.getArrivalTime().compareTo(((TrainBtwnStnsModel) obj).f5342a.getArrivalTime());
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public final void onClick(View view) {
            int visibility = AllTrainListFragment.a.getVisibility();
            AllTrainListFragment allTrainListFragment = AllTrainListFragment.this;
            if (visibility == 0 || allTrainListFragment.filter_ll.getVisibility() == 0 || allTrainListFragment.pnr_input_bottom_rl.getVisibility() == 0) {
                allTrainListFragment.g();
                return;
            }
            HomeActivity.A(2);
            TrainBtwnStnsModel trainBtwnStnsModel = AllTrainListFragment.f4414b;
            if (trainBtwnStnsModel != null) {
                trainBtwnStnsModel.a = null;
            }
        }
    }

    public class g implements TrainListViewHolder.TrainListHolderListener {
        public g() {
        }

        public final void onTrainLayoutClick(TrainBtwnStnsModel trainBtwnStnsModel, boolean z, boolean z2) {
            AllTrainListFragment allTrainListFragment = AllTrainListFragment.this;
            allTrainListFragment.f4425a = trainBtwnStnsModel;
            String str = trainBtwnStnsModel.f5348c;
            allTrainListFragment.f4424a = new AvlClassModel(str);
            AllTrainListFragment.f4414b.f5348c = str;
            allTrainListFragment.bottomFareAndButtonLayout.setVisibility(8);
            TrainBtwnStnsDTO trainBtwnStnsDTO = trainBtwnStnsModel.f5342a;
            if (trainBtwnStnsDTO.getClassAvlDTO() == null || !z) {
                AvlFareResponseDTO avlFareResponseDTO = trainBtwnStnsModel.a;
                if (avlFareResponseDTO != null) {
                    AllTrainListFragment.f4415b = avlFareResponseDTO.getAvlDayList().get(0);
                    AllTrainListFragment.f4413a = trainBtwnStnsModel.a;
                    allTrainListFragment.bottomFareAndButtonLayout.setVisibility(0);
                    allTrainListFragment.totalFareLl.setVisibility(0);
                    TextView textView = allTrainListFragment.totalFare;
                    textView.setText("₹ " + AllTrainListFragment.f4413a.getTotalFare());
                    if (AllTrainListFragment.f4413a.getTotalFare().intValue() == 0) {
                        allTrainListFragment.totalFare.setVisibility(8);
                        allTrainListFragment.total_fare_lll.setVisibility(8);
                        return;
                    }
                    allTrainListFragment.total_fare_lll.setVisibility(0);
                    allTrainListFragment.totalFare.setVisibility(0);
                    return;
                }
                allTrainListFragment.bottomFareAndButtonLayout.setVisibility(8);
                return;
            }
            for (ClassAvlDTO next : trainBtwnStnsDTO.getClassAvlDTO()) {
                if (next.getErrorMessage() == null && next.getEnqClass().equalsIgnoreCase(trainBtwnStnsModel.f5348c)) {
                    AvlFareResponseDTO avlFareResponseDTO2 = new AvlFareResponseDTO();
                    avlFareResponseDTO2.setBaseFare(next.getBaseFare());
                    avlFareResponseDTO2.setReservationCharge(next.getReservationCharge());
                    avlFareResponseDTO2.setSuperfastCharge(next.getSuperfastCharge());
                    avlFareResponseDTO2.setTatkalFare(next.getTatkalFare());
                    avlFareResponseDTO2.setServiceTax(next.getServiceTax());
                    avlFareResponseDTO2.setCateringCharge(next.getCateringCharge());
                    avlFareResponseDTO2.setTotalFare(next.getTotalFare());
                    avlFareResponseDTO2.setOtherCharge(next.getOtherCharge());
                    avlFareResponseDTO2.setDynamicFare(next.getDynamicFare());
                    avlFareResponseDTO2.setInformationMessage((ArrayList) next.getInformationMessage());
                    avlFareResponseDTO2.setTrainNo(trainBtwnStnsDTO.getTrainNumber());
                    avlFareResponseDTO2.setEnqClass(next.getEnqClass());
                    allTrainListFragment.g = next.getLastUpdateTime();
                    AllTrainListFragment.f4413a = avlFareResponseDTO2;
                    AllTrainListFragment.f4414b.a = null;
                    allTrainListFragment.totalFareLl.setVisibility(0);
                    TextView textView2 = allTrainListFragment.totalFare;
                    textView2.setText("₹ " + AllTrainListFragment.f4413a.getTotalFare());
                    allTrainListFragment.bottomFareAndButtonLayout.setVisibility(0);
                }
            }
            allTrainListFragment.bottomFareAndButtonLayout.setVisibility(0);
        }

        public final void onTrainLayoutNotify(TrainBtwnStnsModel trainBtwnStnsModel, boolean z, boolean z2) {
            AllTrainListFragment allTrainListFragment = AllTrainListFragment.this;
            TrainListViewHolder trainListViewHolder = allTrainListFragment.f4422a;
            if (trainListViewHolder != null) {
                trainListViewHolder.notifyDataSetChanged();
            }
            TrainListViewHolder trainListViewHolder2 = allTrainListFragment.f4434b;
            if (trainListViewHolder2 != null) {
                trainListViewHolder2.notifyDataSetChanged();
            }
        }
    }

    public class h implements DatePickerDialog.OnDateSetListener {
        public h() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str;
            AllTrainListFragment allTrainListFragment = AllTrainListFragment.this;
            allTrainListFragment.d = i;
            allTrainListFragment.e = i2;
            allTrainListFragment.f = i3;
            allTrainListFragment.getClass();
            GregorianCalendar gregorianCalendar = new GregorianCalendar(allTrainListFragment.d, allTrainListFragment.e, allTrainListFragment.f);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            new SimpleDateFormat("EEE dd MMM");
            allTrainListFragment.f4439c = simpleDateFormat.format(gregorianCalendar.getTime());
            try {
                str = new SimpleDateFormat("EEE, dd MMM  yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(allTrainListFragment.f4439c));
            } catch (ParseException e) {
                e.getMessage();
                str = "";
            }
            HomeActivity.H(AllTrainListFragment.o + " " + allTrainListFragment.getString(R.string.to_se) + " " + AllTrainListFragment.p + " | " + str);
            allTrainListFragment.u();
        }
    }

    public class i extends Subscriber<TrainBtwnStnsRespDto> {
        public i() {
        }

        public final void onCompleted() {
            TextView textView = AllTrainListFragment.f4408a;
        }

        public final void onError(Throwable th) {
            TextView textView = AllTrainListFragment.f4408a;
            th.getClass();
            th.getMessage();
            AllTrainListFragment.this.f4420a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            boolean z;
            TrainBtwnStnsRespDto trainBtwnStnsRespDto = (TrainBtwnStnsRespDto) obj;
            AllTrainListFragment allTrainListFragment = AllTrainListFragment.this;
            if (trainBtwnStnsRespDto != null) {
                C0657Qt.h();
                try {
                    if (!(trainBtwnStnsRespDto.getOneStopJourny() == null || !trainBtwnStnsRespDto.getOneStopJourny().booleanValue() || trainBtwnStnsRespDto.getErrorMessage() == null)) {
                        C0535I5.p(allTrainListFragment.getContext(), false, allTrainListFragment.getString(R.string.no_direct_train_msg), allTrainListFragment.getString(R.string.confirmation), allTrainListFragment.getString(R.string.yes), new C1048t(this), allTrainListFragment.getString(R.string.no), new C1049u(this)).show();
                    }
                    if (trainBtwnStnsRespDto.getOneStopJourny() != null && trainBtwnStnsRespDto.getOneStopJourny().booleanValue() && trainBtwnStnsRespDto.getErrorMessage() != null) {
                        return;
                    }
                    if (trainBtwnStnsRespDto.getErrorMessage() != null) {
                        allTrainListFragment.f4420a.dismiss();
                        if (!trainBtwnStnsRespDto.getErrorMessage().contains("50035")) {
                            C0535I5.m(allTrainListFragment.getActivity(), false, trainBtwnStnsRespDto.getErrorMessage().split("-")[0], allTrainListFragment.getString(R.string.error), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else if (C1450w1.f7013a == 3) {
                            C0535I5.m(allTrainListFragment.getActivity(), false, allTrainListFragment.getString(R.string.your_account_has_been_suspended), allTrainListFragment.getString(R.string.error), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else {
                            C0535I5.m(allTrainListFragment.getActivity(), false, trainBtwnStnsRespDto.getErrorMessage().split("-")[0], allTrainListFragment.getString(R.string.error), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        }
                    } else if (trainBtwnStnsRespDto.getTrainBtwnStnsList() == null && trainBtwnStnsRespDto.getAlternateTrainBtwnStnsList() == null) {
                        allTrainListFragment.f4420a.dismiss();
                        C0535I5.m(allTrainListFragment.getActivity(), false, allTrainListFragment.getString(R.string.train_no_found), allTrainListFragment.getString(R.string.error), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else {
                        new Bundle();
                        TextView textView = AllTrainListFragment.f4408a;
                        C1455wA wAVar = new C1455wA(trainBtwnStnsRespDto);
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        allTrainListFragment.f4437b.clear();
                        allTrainListFragment.f4455h.clear();
                        if (allTrainListFragment.f4447e.equals("") || wAVar.getTrainBtwnStnsList() == null) {
                            z = false;
                        } else {
                            z = false;
                            for (TrainBtwnStnsModel next : wAVar.getTrainBtwnStnsList()) {
                                allTrainListFragment.f4436b.put(next.f5342a.getTrainType().get(0), Boolean.TRUE);
                                allTrainListFragment.f4435b.add(next.f5342a.getTrainType().get(0));
                                Iterator it = next.f5346a.iterator();
                                while (it.hasNext()) {
                                    AvlClassModel avlClassModel = (AvlClassModel) it.next();
                                    if (avlClassModel.c.equalsIgnoreCase(allTrainListFragment.f4447e)) {
                                        linkedHashSet.add(next);
                                        z = true;
                                    }
                                    boolean equals = allTrainListFragment.f4447e.equals("");
                                    String str = avlClassModel.c;
                                    if (!equals) {
                                        if (!allTrainListFragment.f4447e.equals(str)) {
                                            allTrainListFragment.f4441c.put(str, Boolean.FALSE);
                                            allTrainListFragment.f4431a.add(str);
                                        }
                                    }
                                    allTrainListFragment.f4441c.put(str, Boolean.TRUE);
                                    allTrainListFragment.f4431a.add(str);
                                }
                            }
                            allTrainListFragment.f4437b = new ArrayList(linkedHashSet);
                        }
                        allTrainListFragment.f4455h = new ArrayList<>();
                        if (!allTrainListFragment.f4447e.equals("") && wAVar.getAlternateTrainBtwnStnsList() != null) {
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                            for (TrainBtwnStnsModel next2 : wAVar.getAlternateTrainBtwnStnsList()) {
                                allTrainListFragment.f4435b.add(next2.f5342a.getTrainType().get(0));
                                allTrainListFragment.f4436b.put(next2.f5342a.getTrainType().get(0), Boolean.TRUE);
                                Iterator it2 = next2.f5346a.iterator();
                                while (it2.hasNext()) {
                                    AvlClassModel avlClassModel2 = (AvlClassModel) it2.next();
                                    if (avlClassModel2.c.equalsIgnoreCase(allTrainListFragment.f4447e)) {
                                        linkedHashSet2.add(next2);
                                        z = true;
                                    }
                                    boolean equals2 = allTrainListFragment.f4447e.equals("");
                                    String str2 = avlClassModel2.c;
                                    if (!equals2) {
                                        if (!allTrainListFragment.f4447e.equals(str2)) {
                                            allTrainListFragment.f4441c.put(str2, Boolean.FALSE);
                                            allTrainListFragment.f4431a.add(str2);
                                        }
                                    }
                                    allTrainListFragment.f4441c.put(str2, Boolean.TRUE);
                                    allTrainListFragment.f4431a.add(str2);
                                }
                            }
                            allTrainListFragment.f4455h = new ArrayList<>(linkedHashSet2);
                        }
                        if (allTrainListFragment.f4447e.equals("") || z) {
                            allTrainListFragment.f4432a = wAVar;
                            allTrainListFragment.f4451f = (ArrayList) allTrainListFragment.f4437b;
                            allTrainListFragment.f4453g = allTrainListFragment.f4455h;
                            AllTrainListFragment.k = allTrainListFragment.f4439c;
                            AllTrainListFragment.o = AllTrainListFragment.o;
                            AllTrainListFragment.p = AllTrainListFragment.p;
                            AllTrainListFragment.q = AllTrainListFragment.q;
                            AllTrainListFragment.r = AllTrainListFragment.r;
                            allTrainListFragment.f4444d = allTrainListFragment.f4444d;
                            AllTrainListFragment.i = AllTrainListFragment.i;
                            AllTrainListFragment.m = AllTrainListFragment.m;
                            allTrainListFragment.f4447e = allTrainListFragment.f4447e;
                            allTrainListFragment.f4450f = allTrainListFragment.f4450f;
                            AllTrainListFragment.f4418l = AllTrainListFragment.f4418l;
                            allTrainListFragment.f4424a = allTrainListFragment.f4424a;
                            allTrainListFragment.f4448e = allTrainListFragment.f4448e;
                            String str3 = AllTrainListFragment.l;
                            AllTrainListFragment.l = str3;
                            allTrainListFragment.f4435b = allTrainListFragment.f4435b;
                            allTrainListFragment.f4436b = allTrainListFragment.f4436b;
                            allTrainListFragment.f4441c = allTrainListFragment.f4441c;
                            allTrainListFragment.f4431a = allTrainListFragment.f4431a;
                            allTrainListFragment.h = str3;
                            for (TrainBtwnStnsModel trainBtwnStnsModel : wAVar.getTrainBtwnStnsList()) {
                                trainBtwnStnsModel.f = AllTrainListFragment.k;
                            }
                            allTrainListFragment.f4446d = true;
                            allTrainListFragment.p();
                            allTrainListFragment.f4454g = true;
                            if (allTrainListFragment.f4420a.isShowing()) {
                                allTrainListFragment.f4420a.dismiss();
                                return;
                            }
                            return;
                        }
                        allTrainListFragment.f4420a.dismiss();
                        C0535I5.o(allTrainListFragment.getActivity(), allTrainListFragment.getString(R.string.train_not_found_selectclass), allTrainListFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                } catch (Exception e) {
                    TextView textView2 = AllTrainListFragment.f4408a;
                    e.getMessage();
                    if (allTrainListFragment.f4420a.isShowing()) {
                        allTrainListFragment.f4420a.dismiss();
                    }
                    C0535I5.t0(allTrainListFragment.getActivity(), allTrainListFragment.getString(R.string.please_try_again));
                }
            } else {
                allTrainListFragment.f4420a.dismiss();
                C0535I5.m(allTrainListFragment.getActivity(), false, allTrainListFragment.getResources().getString(R.string.unable_process_message), allTrainListFragment.getString(R.string.error), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class k extends Subscriber<PnrEnquiryResponseDTO> {
        public final /* synthetic */ ProgressDialog a;

        public k(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            TextView textView = AllTrainListFragment.f4408a;
        }

        public final void onError(Throwable th) {
            TextView textView = AllTrainListFragment.f4408a;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            HomeActivity.B(AllTrainListFragment.this.getActivity());
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            PnrEnquiryResponseDTO pnrEnquiryResponseDTO = (PnrEnquiryResponseDTO) obj;
            this.a.dismiss();
            if (pnrEnquiryResponseDTO != null) {
                C0657Qt.h();
                try {
                    String errorMessage = pnrEnquiryResponseDTO.getErrorMessage();
                    AllTrainListFragment allTrainListFragment = AllTrainListFragment.this;
                    if (errorMessage != null) {
                        C0535I5.m(allTrainListFragment.getActivity(), true, pnrEnquiryResponseDTO.getErrorMessage().split("-")[0], allTrainListFragment.getString(R.string.error), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else if (pnrEnquiryResponseDTO.getStatus() != null) {
                        C0535I5.o(allTrainListFragment.getActivity(), pnrEnquiryResponseDTO.getStatus(), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        allTrainListFragment.status.setVisibility(0);
                        allTrainListFragment.status.setText(pnrEnquiryResponseDTO.getStatus());
                    } else {
                        allTrainListFragment.status.setVisibility(8);
                    }
                } catch (Exception e) {
                    TextView textView = AllTrainListFragment.f4408a;
                    e.getMessage();
                }
            }
        }
    }

    public class l implements Comparator<TrainBtwnStnsModel> {
        public final int compare(Object obj, Object obj2) {
            return ((TrainBtwnStnsModel) obj).f5342a.getDuration().compareTo(((TrainBtwnStnsModel) obj2).f5342a.getDuration());
        }
    }

    static {
        View.MeasureSpec.makeMeasureSpec(0, 0);
        C1354qp.R(AllTrainListFragment.class);
    }

    public AllTrainListFragment() {
        new ArrayList();
        new HashMap();
        this.f4433a = false;
        this.f4438b = true;
        this.f4443c = true;
        this.f4420a = null;
        this.f4428a = new ArrayList<>();
        this.f4435b = new ArrayList<>();
        this.f4440c = new ArrayList();
        this.f4445d = new ArrayList();
        this.f4447e = "";
        this.f4450f = "";
        this.f4431a = new HashSet();
        this.f4437b = new ArrayList();
        this.f4442c = new ArrayList();
        new ArrayList();
        this.f4429a = new HashMap<>();
        this.g = "";
        this.f4446d = false;
        this.f4449e = false;
        this.h = "";
        this.f4448e = null;
        this.f4452f = false;
        this.f4436b = new HashMap<>();
        this.f4441c = new HashMap<>();
        this.f4454g = false;
        this.f4451f = new ArrayList<>();
        this.f4453g = new ArrayList<>();
        this.f4427a = null;
        this.f4457i = C0515Ga.AVLBLTY_ONLY;
        this.f4455h = new ArrayList<>();
        this.f4423a = new g();
        this.f4456h = true;
    }

    public static boolean i() {
        return f4417k;
    }

    @OnClick({2131361959})
    public void ArrivalLateFirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.durationLateFirst, R.color.white);
        n(this.durationEarlyFirst, R.color.white);
        n(this.arrivalEarlyFirst, R.color.white);
        n(this.arrivalLateFirst, R.color.dark);
        n(this.departureEarlyFirst, R.color.white);
        n(this.departureLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        t(5);
    }

    @OnClick({2131362198})
    public void Class1AClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("1A")) {
            return;
        }
        if (!this.class_1A.isChecked()) {
            this.class_1A.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("1A", Boolean.FALSE);
            return;
        }
        this.class_1A.setChecked(true);
        this.f4441c.replace("1A", Boolean.TRUE);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362200})
    public void Class2AClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("2A")) {
            return;
        }
        if (!this.class_2A.isChecked()) {
            this.class_2A.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("2A", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("2A", Boolean.TRUE);
        this.class_2A.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362202})
    public void Class2SClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("2S")) {
            return;
        }
        if (!this.class_2S.isChecked()) {
            this.class_2S.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("2S", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("2S", Boolean.TRUE);
        this.class_2S.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362204})
    public void Class3AClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("3A")) {
            return;
        }
        if (!this.class_3A.isChecked()) {
            this.class_3A.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("3A", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("3A", Boolean.TRUE);
        this.class_3A.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362206})
    public void ClassACClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("AC")) {
            return;
        }
        if (!this.class_AC.isChecked()) {
            this.class_AC.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("AC", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("AC", Boolean.TRUE);
        this.class_AC.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362208})
    public void ClassCCClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("CC")) {
            return;
        }
        if (!this.class_CC.isChecked()) {
            this.class_CC.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("CC", Boolean.FALSE);
            return;
        }
        this.class_CC.setChecked(true);
        this.f4441c.replace("CC", Boolean.TRUE);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362210})
    public void ClassECClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("EC")) {
            return;
        }
        if (!this.class_EC.isChecked()) {
            this.class_EC.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("EC", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("EC", Boolean.TRUE);
        this.class_EC.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362212})
    public void ClassEVClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("EV")) {
            return;
        }
        if (!this.class_EV.isChecked()) {
            this.class_EV.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("EV", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("EV", Boolean.TRUE);
        this.class_EV.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362213})
    public void ClassFCClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("FC")) {
            return;
        }
        if (!this.class_FC.isChecked()) {
            this.class_FC.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("FC", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("FC", Boolean.TRUE);
        this.class_FC.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362215})
    public void ClassSLClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("SL")) {
            return;
        }
        if (!this.class_SL.isChecked()) {
            this.class_SL.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("SL", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("SL", Boolean.TRUE);
        this.class_SL.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362217})
    public void ClassVCClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("VC")) {
            return;
        }
        if (!this.class_VC.isChecked()) {
            this.class_VC.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("VC", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("VC", Boolean.TRUE);
        this.class_VC.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131362218})
    public void ClassVSClick() {
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("VS")) {
            return;
        }
        if (!this.class_VS.isChecked()) {
            this.class_VS.setChecked(false);
            this.cbclass.setChecked(false);
            this.f4441c.replace("VS", Boolean.FALSE);
            return;
        }
        this.f4441c.replace("VS", Boolean.TRUE);
        this.class_VS.setChecked(true);
        if (h()) {
            this.cbclass.setChecked(true);
        }
    }

    @OnClick({2131364354})
    public void ContinueButtonClick() {
        TrainBtwnStnsModel trainBtwnStnsModel;
        if (C1450w1.f7013a != 5 || !C0535I5.R()) {
            C1060d2 d2Var = f4415b;
            this.f4426a = d2Var;
            boolean z = false;
            if (d2Var == null) {
                Toast.makeText(this.f4421a, getString(R.string.please_select_juryDate_availability), 0).show();
            } else if (d2Var.getAvailablityStatus().contains("#") && !this.f4426a.getAvailablityStatus().contains("NOT") && this.f4426a.getAvailablityStatus().contains("AVAIL") && this.f4426a.getReasonType().equals("W")) {
                C0535I5.o(getActivity(), getString(R.string.booking_not_start), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else if (this.f4426a.getAvailablityStatus().equalsIgnoreCase("TRAIN DEPARTED") || this.f4426a.getAvailablityStatus().equalsIgnoreCase("NOT AVAILABLE") || this.f4426a.getReasonType().equals("W") || this.f4426a.getAvailablityStatus().equalsIgnoreCase("TRAIN CANCELLED") || this.f4426a.getAvailablityStatus().equalsIgnoreCase("RESVN SUSPENDED") || this.f4426a.getAvailablityStatus().contains("REGRET")) {
                Toast.makeText(this.f4421a, getString(R.string.no_seat_available), 0).show();
            } else if (C0535I5.R()) {
                this.f4424a = new AvlClassModel(f4414b.f5348c);
                C1081e2 e2Var = new C1081e2();
                this.f4427a = e2Var;
                e2Var.setFtBooking(false);
                this.f4427a.setLoyaltyRedemptionBooking(false);
                this.f4427a.setMoreThanOneDay(Boolean.TRUE);
                this.f4427a.setTicketType("E");
                ArrayList arrayList = new ArrayList();
                C0668Rh rh = new C0668Rh();
                rh.setTrainNo(f4414b.f5342a.getTrainNumber());
                rh.setFromStation(f4414b.f5342a.getFromStnCode());
                new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
                rh.setJourneyDate(f(f4415b.getAvailablityDate(), "yyyyMMdd"));
                rh.setQuota(l);
                rh.setToStation(f4414b.f5342a.getToStnCode());
                rh.setJourneyClass(f4414b.f5348c);
                if (m.equals("Y")) {
                    if (m.equals("Y") || l.equals("HP")) {
                        z = true;
                    }
                    rh.setConcessionBooking(z);
                }
                arrayList.add(rh);
                this.f4427a.setLapAvlRequestDTO(arrayList);
                LapAllTrainListFragment lapAllTrainListFragment = new LapAllTrainListFragment();
                lapAllTrainListFragment.f4703a = this.f4427a;
                LapAllTrainListFragment.j = l;
                LapAllTrainListFragment.k = m;
                lapAllTrainListFragment.f4718f = null;
                LapAllTrainListFragment.f = f4418l;
                LapAllTrainListFragment.l = o;
                LapAllTrainListFragment.m = p;
                lapAllTrainListFragment.f4711c = this.f4448e;
                lapAllTrainListFragment.f4717e = this.g;
                lapAllTrainListFragment.f4697a = this.f4421a;
                ArrayList<TrainBtwnStnsModel> arrayList2 = new ArrayList<>();
                TrainBtwnStnsModel trainBtwnStnsModel2 = f4414b;
                trainBtwnStnsModel2.f5343a = this.f4426a;
                trainBtwnStnsModel2.d = l;
                arrayList2.add(trainBtwnStnsModel2);
                lapAllTrainListFragment.f4714d = arrayList2;
                LapAllTrainListFragment.i = f(f4415b.getAvailablityDate(), "yyyyMMdd");
                LapAllTrainListFragment.e = i;
                if (l.equalsIgnoreCase("PT") || ((trainBtwnStnsModel = f4414b) != null && trainBtwnStnsModel.a == null)) {
                    lapAllTrainListFragment.f();
                    return;
                }
                C1100f2 f2Var = new C1100f2();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(f4414b.a);
                f2Var.setAvlFareResponseDTO(arrayList3);
                lapAllTrainListFragment.g(f2Var);
            } else if (C1450w1.f7005a == 2) {
                HomeActivity.A(2);
            } else {
                HomeActivity.A(1);
            }
        } else {
            C0535I5.o(getActivity(), getString(R.string.incomplete_registration), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    @OnClick({2131361954})
    public void applyFinterClick() {
        Date date;
        Date date2;
        ArrayList arrayList;
        Date parse;
        Date parse2;
        ArrayList arrayList2;
        if (this.ch_rajdhani.isChecked() || this.ch_shatabdi.isChecked() || this.ch_duranto.isChecked() || this.ch_special_train.isChecked() || this.ch_special_tatkal.isChecked() || this.ch_garibrath.isChecked() || this.ch_suvidha_train.isChecked() || this.ch_others.isChecked() || this.ch_janshatabdi.isChecked() || this.ch_yuva_express.isChecked() || this.class_1A.isChecked() || this.class_2A.isChecked() || this.class_3A.isChecked() || this.class_EC.isChecked() || this.class_CC.isChecked() || this.class_SL.isChecked() || this.class_2S.isChecked() || this.class_AC.isChecked() || this.class_FC.isChecked() || this.class_VS.isChecked() || this.class_VC.isChecked() || this.class_EV.isChecked() || this.ch_earlyMorning.isChecked() || this.ch_morning.isChecked() || this.ch_midDay.isChecked() || this.ch_night.isChecked()) {
            List<TrainBtwnStnsModel> list = this.f4437b;
            if (list != null) {
                list.clear();
            }
            List<TrainBtwnStnsModel> list2 = this.f4442c;
            if (list2 != null) {
                list2.clear();
            }
            ArrayList<String> arrayList3 = this.f4428a;
            arrayList3.clear();
            if (this.ch_rajdhani.isChecked()) {
                arrayList3.add("R");
            }
            if (this.ch_shatabdi.isChecked()) {
                arrayList3.add("S");
            }
            if (this.ch_duranto.isChecked()) {
                arrayList3.add("D");
            }
            if (this.ch_special_train.isChecked()) {
                arrayList3.add("SP");
            }
            if (this.ch_special_tatkal.isChecked()) {
                arrayList3.add("ST");
            }
            if (this.ch_garibrath.isChecked()) {
                arrayList3.add(RequestConfiguration.MAX_AD_CONTENT_RATING_G);
            }
            if (this.ch_others.isChecked()) {
                arrayList3.add("O");
            }
            if (this.ch_suvidha_train.isChecked()) {
                arrayList3.add("SV");
            }
            if (this.ch_janshatabdi.isChecked()) {
                arrayList3.add(PaymentConstants.Category.JS);
            }
            if (this.ch_yuva_express.isChecked()) {
                arrayList3.add("Y");
            }
            this.f4440c.clear();
            if (this.class_1A.isChecked()) {
                this.f4440c.add("1A");
            }
            if (this.class_2A.isChecked()) {
                this.f4440c.add("2A");
            }
            if (this.class_3A.isChecked()) {
                this.f4440c.add("3A");
            }
            if (this.class_EC.isChecked()) {
                this.f4440c.add("EC");
            }
            if (this.class_CC.isChecked()) {
                this.f4440c.add("CC");
            }
            if (this.class_SL.isChecked()) {
                this.f4440c.add("SL");
            }
            if (this.class_2S.isChecked()) {
                this.f4440c.add("2S");
            }
            if (this.class_AC.isChecked()) {
                this.f4440c.add("AC");
            }
            if (this.class_FC.isChecked()) {
                this.f4440c.add("FC");
            }
            if (this.class_VS.isChecked()) {
                this.f4440c.add("VS");
            }
            if (this.class_VC.isChecked()) {
                this.f4440c.add("VC");
            }
            if (this.class_EV.isChecked()) {
                this.f4440c.add("EV");
            }
            ArrayList arrayList4 = new ArrayList();
            int i2 = 1;
            if (this.ch_earlyMorning.isChecked()) {
                arrayList4.add(1);
            }
            int i3 = 2;
            if (this.ch_morning.isChecked()) {
                arrayList4.add(2);
            }
            int i4 = 3;
            if (this.ch_midDay.isChecked()) {
                arrayList4.add(3);
            }
            if (this.ch_night.isChecked()) {
                arrayList4.add(4);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (!(arrayList3.size() == 0 || (arrayList2 = this.f4440c) == null || arrayList2.size() == 0 || this.f4432a.getTrainBtwnStnsList() == null)) {
                for (TrainBtwnStnsModel next : this.f4432a.getTrainBtwnStnsList()) {
                    if (arrayList3.contains(next.f5342a.getTrainType().get(0))) {
                        ArrayList arrayList5 = this.f4440c;
                        if (!(arrayList5 == null || arrayList5.size() == 0)) {
                            Iterator it = next.f5346a.iterator();
                            while (it.hasNext()) {
                                if (this.f4440c.contains(((AvlClassModel) it.next()).c)) {
                                    linkedHashSet.add(next);
                                }
                            }
                        }
                        if (this.f4440c.size() == 0) {
                            linkedHashSet.add(next);
                        }
                    }
                }
            }
            ArrayList arrayList6 = new ArrayList(linkedHashSet);
            this.f4437b = arrayList6;
            if (arrayList6.size() > 0 && arrayList4.size() > 0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                Iterator it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    int intValue = ((Integer) it2.next()).intValue();
                    if (intValue == i2) {
                        try {
                            parse = simpleDateFormat.parse("00:00");
                            parse2 = simpleDateFormat.parse("06:00");
                        } catch (ParseException e2) {
                            e2.getMessage();
                        }
                    } else if (intValue == i3) {
                        parse = simpleDateFormat.parse("06:00");
                        parse2 = simpleDateFormat.parse("12:00");
                    } else if (intValue == i4) {
                        parse = simpleDateFormat.parse("12:00");
                        parse2 = simpleDateFormat.parse("18:00");
                    } else {
                        parse = simpleDateFormat.parse("18:00");
                        parse2 = simpleDateFormat.parse("24:00");
                    }
                    Date date3 = parse2;
                    for (TrainBtwnStnsModel next2 : this.f4437b) {
                        Date parse3 = simpleDateFormat.parse(next2.f5342a.getDepartureTime());
                        if (parse3.after(parse) && parse3.before(date3)) {
                            linkedHashSet2.add(next2);
                        }
                    }
                    i2 = 1;
                    i3 = 2;
                    i4 = 3;
                }
                this.f4437b = new ArrayList(linkedHashSet2);
                linkedHashSet = linkedHashSet2;
            }
            this.f4442c = new ArrayList();
            if (this.f4432a.getAlternateTrainBtwnStnsList() != null) {
                linkedHashSet = new LinkedHashSet();
                if (!(arrayList3.size() == 0 || (arrayList = this.f4440c) == null || arrayList.size() == 0)) {
                    for (TrainBtwnStnsModel next3 : this.f4432a.getAlternateTrainBtwnStnsList()) {
                        if (arrayList3.contains(next3.f5342a.getTrainType().get(0))) {
                            ArrayList arrayList7 = this.f4440c;
                            if (!(arrayList7 == null || arrayList7.size() == 0)) {
                                Iterator it3 = next3.f5346a.iterator();
                                while (it3.hasNext()) {
                                    if (this.f4440c.contains(((AvlClassModel) it3.next()).c)) {
                                        linkedHashSet.add(next3);
                                    }
                                }
                            }
                            if (this.f4440c.size() == 0) {
                                linkedHashSet.add(next3);
                            }
                        }
                    }
                }
                ArrayList arrayList8 = new ArrayList(linkedHashSet);
                this.f4442c = arrayList8;
                if (arrayList8.size() > 0 && arrayList4.size() > 0) {
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
                    LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                    Iterator it4 = arrayList4.iterator();
                    while (it4.hasNext()) {
                        int intValue2 = ((Integer) it4.next()).intValue();
                        if (intValue2 == 1) {
                            try {
                                date2 = simpleDateFormat2.parse("00:00");
                                date = simpleDateFormat2.parse("06:00");
                            } catch (ParseException e3) {
                                e = e3;
                                e.getMessage();
                            }
                        } else if (intValue2 == 2) {
                            try {
                                date2 = simpleDateFormat2.parse("06:00");
                                date = simpleDateFormat2.parse("12:00");
                            } catch (ParseException e4) {
                                e = e4;
                                e.getMessage();
                            }
                        } else if (intValue2 == 3) {
                            date2 = simpleDateFormat2.parse("12:00");
                            date = simpleDateFormat2.parse("18:00");
                        } else {
                            date2 = simpleDateFormat2.parse("18:00");
                            date = simpleDateFormat2.parse("24:00");
                        }
                        for (TrainBtwnStnsModel next4 : this.f4442c) {
                            Date parse4 = simpleDateFormat2.parse(next4.f5342a.getDepartureTime());
                            if (parse4.after(date2) && parse4.before(date)) {
                                linkedHashSet3.add(next4);
                            }
                        }
                    }
                    this.f4442c = new ArrayList(linkedHashSet3);
                    linkedHashSet = linkedHashSet3;
                }
            }
            q();
            if (this.f4437b.size() == 0 && (this.f4432a.getAlternateTrainBtwnStnsList() == null || this.f4442c.size() == 0)) {
                C0535I5.t0(getContext(), getString(R.string.no_train_available_you_selected));
                this.hide_ll.setVisibility(8);
                return;
            }
            linkedHashSet.clear();
            this.filter_ll.setVisibility(8);
            this.filter_ll_ll.setVisibility(8);
            this.filter_ll_scroll.setVisibility(8);
            if (this.f4437b.size() <= 3 || (this.f4442c.size() > 0 && this.f4442c.size() <= 3)) {
                this.hide_ll.setVisibility(0);
            } else {
                this.hide_ll.setVisibility(8);
            }
        } else {
            List<TrainBtwnStnsModel> list3 = this.f4437b;
            if (list3 != null) {
                list3.clear();
            }
            List<TrainBtwnStnsModel> list4 = this.f4442c;
            if (list4 != null) {
                list4.clear();
            }
            p();
            this.filter_ll.setVisibility(8);
            this.filter_ll_ll.setVisibility(8);
            this.filter_ll_scroll.setVisibility(8);
        }
    }

    @OnClick({2131361957})
    public void arrival(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.arrival, R.color.dark);
        n(this.departure, R.color.white);
        n(this.travelTime, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrival.setTextAppearance(getActivity(), R.style.fontForbold);
        this.travelTime.setTextAppearance(getActivity(), R.style.fontForNormal);
        if (this.f4438b) {
            this.f4438b = false;
        } else {
            this.f4438b = true;
        }
        t(1);
    }

    @OnClick({2131361958})
    public void arrivalEarlyirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.durationLateFirst, R.color.white);
        n(this.durationEarlyFirst, R.color.white);
        n(this.arrivalEarlyFirst, R.color.dark);
        n(this.arrivalLateFirst, R.color.white);
        n(this.departureEarlyFirst, R.color.white);
        n(this.departureLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        t(4);
    }

    @OnClick({2131363515})
    public void connectionJourneyLayoutClick() {
        g();
    }

    @OnClick({2131362388})
    public void departure(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.arrival, R.color.white);
        n(this.departure, R.color.dark);
        n(this.travelTime, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.arrival.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.travelTime.setTextAppearance(getActivity(), R.style.fontForNormal);
        if (this.f4433a) {
            this.f4433a = false;
        } else {
            this.f4433a = true;
        }
        t(0);
    }

    @OnClick({2131362389})
    public void departureEarlyirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.durationLateFirst, R.color.white);
        n(this.durationEarlyFirst, R.color.white);
        n(this.arrivalEarlyFirst, R.color.white);
        n(this.arrivalLateFirst, R.color.white);
        n(this.departureEarlyFirst, R.color.dark);
        n(this.departureLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        t(2);
    }

    @OnClick({2131362390})
    public void departureLateFirst(View view) {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.durationLateFirst, R.color.white);
        n(this.durationEarlyFirst, R.color.white);
        n(this.arrivalEarlyFirst, R.color.white);
        n(this.arrivalLateFirst, R.color.white);
        n(this.departureEarlyFirst, R.color.white);
        n(this.departureLateFirst, R.color.dark);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        t(3);
    }

    @OnClick({2131362461})
    public void durationEarlyFirst() {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.durationLateFirst, R.color.white);
        n(this.durationEarlyFirst, R.color.dark);
        n(this.departureEarlyFirst, R.color.white);
        n(this.departureLateFirst, R.color.white);
        n(this.arrivalEarlyFirst, R.color.white);
        n(this.arrivalLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        t(0);
    }

    @OnClick({2131362462})
    public void durationLateFirst() {
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.durationLateFirst, R.color.dark);
        n(this.durationEarlyFirst, R.color.white);
        n(this.departureEarlyFirst, R.color.white);
        n(this.departureLateFirst, R.color.white);
        n(this.arrivalEarlyFirst, R.color.white);
        n(this.arrivalLateFirst, R.color.white);
        this.durationLateFirst.setTextAppearance(getActivity(), R.style.fontForbold);
        this.durationEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.departureLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalEarlyFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrivalLateFirst.setTextAppearance(getActivity(), R.style.fontForNormal);
        t(1);
    }

    public final String f(String str, String str2) {
        new SimpleDateFormat();
        int indexOf = str.indexOf(45);
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(45, i2);
        return new SimpleDateFormat("yyyyMMdd").format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i2, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }

    @OnClick({2131362662})
    public void filterBottomLLClick() {
        g();
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
        g();
        if (this.filter_ll.getVisibility() == 8) {
            this.filter_ll.setVisibility(0);
            C0535I5.Y(getActivity(), this.train_list_filter, f4412a);
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
        this.f4426a = null;
        this.route_rl.setVisibility(8);
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        this.pnr_input_bottom_rl.setVisibility(8);
    }

    public final boolean h() {
        this.f4440c = new ArrayList(this.f4431a);
        for (int i2 = 0; i2 < this.f4440c.size(); i2++) {
            if (!this.f4441c.get(this.f4440c.get(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final boolean j() {
        if (a.getVisibility() != 0 && this.sortby_bottom_ll.getVisibility() != 0 && this.filter_ll.getVisibility() != 0 && this.pnr_input_bottom_rl.getVisibility() != 0) {
            return false;
        }
        g();
        return true;
    }

    public final void k() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new j(), 5000);
            return;
        }
        C0573L6 l6 = new C0573L6();
        l6.setPnrNumber(this.inputPnr.getText().toString());
        l6.setOtpResend(1);
        ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text));
        String f2 = C0657Qt.f();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).f1(f2 + "linkpnrenq", l6).c(C1181iv.a()).a(E0.a()).b(new k(show));
    }

    public final void l() {
        this.tvGeneral.setSelected(false);
        this.seniorCitizen.setSelected(false);
        this.tvLadies.setSelected(false);
        this.tvTatkal.setSelected(false);
        this.tv_dutypass_l.setSelected(false);
        this.premiumTatkal.setSelected(false);
        this.phHandicap.setSelected(false);
        this.parliamentHouse.setSelected(false);
        n(this.tvGeneral, R.color.white);
        n(this.tvLadies, R.color.white);
        n(this.seniorCitizen, R.color.white);
        n(this.tvTatkal, R.color.white);
        n(this.premiumTatkal, R.color.white);
        n(this.phHandicap, R.color.white);
        n(this.parliamentHouse, R.color.white);
        n(this.tv_dutypass_l, R.color.white);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.tv_dutypass_l.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForNormal);
    }

    public final void m() {
        TrainBtwnStnsRespDto trainBtwnStnsRespDto = this.f4432a.getTrainBtwnStnsRespDto();
        boolean z = NewBookingFragment.k;
        C1455wA wAVar = new C1455wA(trainBtwnStnsRespDto);
        this.f4432a = wAVar;
        if (wAVar.getTrainBtwnStnsList() != null && !this.f4432a.getTrainBtwnStnsList().isEmpty()) {
            for (TrainBtwnStnsModel trainBtwnStnsModel : this.f4432a.getTrainBtwnStnsList()) {
                trainBtwnStnsModel.f = k;
            }
        }
    }

    public final void n(TextView textView, int i2) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i2), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void o(String str) {
        if (str != null) {
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
                    n(this.tv_dutypass_l, R.color.dark);
                    this.tv_dutypass_l.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.tv_dutypass_l.setVisibility(0);
                    return;
                case 1:
                    n(this.tvGeneral, R.color.dark);
                    this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.tvGeneral.setVisibility(0);
                    return;
                case 2:
                    n(this.phHandicap, R.color.dark);
                    this.phHandicap.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.phHandicap.setVisibility(0);
                    return;
                case 3:
                    n(this.tvLadies, R.color.dark);
                    this.tvLadies.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.tvLadies.setVisibility(0);
                    return;
                case 4:
                    n(this.parliamentHouse, R.color.dark);
                    this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.parliamentHouse.setVisibility(0);
                    return;
                case 5:
                    n(this.premiumTatkal, R.color.dark);
                    this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.premiumTatkal.setVisibility(0);
                    return;
                case 6:
                    n(this.seniorCitizen, R.color.dark);
                    this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.seniorCitizen.setVisibility(0);
                    return;
                case 7:
                    n(this.tvTatkal, R.color.dark);
                    this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
                    this.tvTatkal.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    @OnClick({2131362147})
    public void onAllClassSelect() {
        if (!this.cbclass.isChecked()) {
            this.class_1A.setChecked(false);
            HashMap<String, Boolean> hashMap = this.f4441c;
            Boolean bool = Boolean.FALSE;
            hashMap.replace("1A", bool);
            this.class_2A.setChecked(false);
            this.f4441c.replace("2A", bool);
            this.class_3A.setChecked(false);
            this.f4441c.replace("3A", bool);
            this.class_EC.setChecked(false);
            this.f4441c.replace("EC", bool);
            this.class_CC.setChecked(false);
            this.f4441c.replace("CC", bool);
            this.class_SL.setChecked(false);
            this.f4441c.replace("SL", bool);
            this.class_2S.setChecked(false);
            this.f4441c.replace("2S", bool);
            this.class_AC.setChecked(false);
            this.f4441c.replace("AC", bool);
            this.class_FC.setChecked(false);
            this.f4441c.replace("FC", bool);
            this.class_VS.setChecked(false);
            this.f4441c.replace("VS", bool);
            this.class_VC.setChecked(false);
            this.f4441c.replace("VC", bool);
            this.class_EV.setChecked(false);
            this.f4441c.replace("EV", bool);
            return;
        }
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("1A")) {
            this.class_1A_ll.setVisibility(8);
        } else {
            this.class_1A.setChecked(true);
        }
        if (!this.f4440c.contains("2A")) {
            this.class_2A_ll.setVisibility(8);
        } else {
            this.class_2A.setChecked(true);
        }
        if (!this.f4440c.contains("3A")) {
            this.class_3A_ll.setVisibility(8);
        } else {
            this.class_3A.setChecked(true);
        }
        if (!this.f4440c.contains("EC")) {
            this.class_EC_ll.setVisibility(8);
        } else {
            this.class_EC.setChecked(true);
        }
        if (!this.f4440c.contains("CC")) {
            this.class_CC_ll.setVisibility(8);
        } else {
            this.class_CC.setChecked(true);
        }
        if (!this.f4440c.contains("SL")) {
            this.class_SL_ll.setVisibility(8);
        } else {
            this.class_SL.setChecked(true);
        }
        if (!this.f4440c.contains("2S")) {
            this.class_2S_ll.setVisibility(8);
        } else {
            this.class_2S.setChecked(true);
        }
        if (!this.f4440c.contains("AC")) {
            this.class_AC_ll.setVisibility(8);
        } else {
            this.class_AC.setChecked(true);
        }
        if (!this.f4440c.contains("FC")) {
            this.class_FC_ll.setVisibility(8);
        } else {
            this.class_FC.setChecked(true);
        }
        if (!this.f4440c.contains("VS")) {
            this.vistadome_non_ac_ll.setVisibility(8);
        } else {
            this.class_VS.setChecked(true);
        }
        if (!this.f4440c.contains("VC")) {
            this.vistadome_chair_car_ll.setVisibility(8);
        } else {
            this.class_VC.setChecked(true);
        }
        if (!this.f4440c.contains("EV")) {
            this.vistadome_ac_ll.setVisibility(8);
        } else {
            this.class_EV.setChecked(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012b, code lost:
        r10 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0061 A[SYNTHETIC] */
    @butterknife.OnClick({2131364301})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAvailableClick(android.view.View r15) {
        /*
            r14 = this;
            android.widget.LinearLayout r0 = r14.bottomFareAndButtonLayout
            r1 = 8
            r0.setVisibility(r1)
            r0 = 0
            f4414b = r0
            boolean r2 = r14.f4456h
            r3 = 2131232051(0x7f080533, float:1.80802E38)
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x01a3
            r14.f4456h = r5
            android.widget.TextView r15 = r14.availableButton
            android.content.Context r2 = r14.f4421a
            java.lang.Object r6 = defpackage.d7.a
            r6 = 2131232052(0x7f080534, float:1.8080202E38)
            android.graphics.drawable.Drawable r2 = defpackage.d7.a.b(r2, r6)
            r15.setBackground(r2)
            java.util.LinkedHashSet r15 = new java.util.LinkedHashSet
            r15.<init>()
            r14.m()
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r2 = r14.f4437b
            if (r2 == 0) goto L_0x003b
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r2 = r14.f4437b
            goto L_0x0041
        L_0x003b:
            wA r2 = r14.f4432a
            java.util.List r2 = r2.getTrainBtwnStnsList()
        L_0x0041:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r6 = r14.f4442c
            if (r6 == 0) goto L_0x004f
            int r6 = r6.size()
            if (r6 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r6 = r14.f4442c
            goto L_0x0055
        L_0x004f:
            wA r6 = r14.f4432a
            java.util.List r6 = r6.getAlternateTrainBtwnStnsList()
        L_0x0055:
            java.lang.String r7 = "AVAIL"
            java.lang.String r8 = "CURR"
            java.lang.String r9 = "NOT"
            if (r2 == 0) goto L_0x00c5
            java.util.Iterator r2 = r2.iterator()
        L_0x0061:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x00be
            java.lang.Object r10 = r2.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r10 = (cris.org.in.ima.model.TrainBtwnStnsModel) r10
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r10.f5344a = r11
            r10.c = r11
            cris.prs.webservices.dto.TrainBtwnStnsDTO r11 = r10.f5342a
            java.util.List r12 = r11.getClassAvlDTO()
            if (r12 == 0) goto L_0x00b7
            java.util.List r11 = r11.getClassAvlDTO()
            java.util.Iterator r11 = r11.iterator()
        L_0x0083:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x00b7
            java.lang.Object r12 = r11.next()
            cris.prs.webservices.dto.ClassAvlDTO r12 = (cris.prs.webservices.dto.ClassAvlDTO) r12
            java.lang.String r13 = r12.getErrorMessage()
            if (r13 != 0) goto L_0x0083
            java.util.List r12 = r12.getAvlDayList()
            java.lang.Object r12 = r12.get(r5)
            d2 r12 = (defpackage.C1060d2) r12
            java.lang.String r12 = r12.getAvailablityStatus()
            boolean r13 = r12.contains(r9)
            if (r13 != 0) goto L_0x00af
            boolean r13 = r12.contains(r7)
            if (r13 != 0) goto L_0x00b5
        L_0x00af:
            boolean r12 = r12.contains(r8)
            if (r12 == 0) goto L_0x0083
        L_0x00b5:
            r11 = r4
            goto L_0x00b8
        L_0x00b7:
            r11 = r5
        L_0x00b8:
            if (r11 == 0) goto L_0x0061
            r15.add(r10)
            goto L_0x0061
        L_0x00be:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r15)
            r14.f4437b = r2
        L_0x00c5:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r14.f4442c = r15
            if (r6 == 0) goto L_0x013b
            java.util.LinkedHashSet r15 = new java.util.LinkedHashSet
            r15.<init>()
            java.util.Iterator r2 = r6.iterator()
        L_0x00d7:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0134
            java.lang.Object r6 = r2.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = (cris.org.in.ima.model.TrainBtwnStnsModel) r6
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r6.c = r10
            r6.f5344a = r10
            cris.prs.webservices.dto.TrainBtwnStnsDTO r10 = r6.f5342a
            java.util.List r11 = r10.getClassAvlDTO()
            if (r11 == 0) goto L_0x012d
            java.util.List r10 = r10.getClassAvlDTO()
            java.util.Iterator r10 = r10.iterator()
        L_0x00f9:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x012d
            java.lang.Object r11 = r10.next()
            cris.prs.webservices.dto.ClassAvlDTO r11 = (cris.prs.webservices.dto.ClassAvlDTO) r11
            java.lang.String r12 = r11.getErrorMessage()
            if (r12 != 0) goto L_0x00f9
            java.util.List r11 = r11.getAvlDayList()
            java.lang.Object r11 = r11.get(r5)
            d2 r11 = (defpackage.C1060d2) r11
            java.lang.String r11 = r11.getAvailablityStatus()
            boolean r12 = r11.contains(r9)
            if (r12 != 0) goto L_0x0125
            boolean r12 = r11.contains(r7)
            if (r12 != 0) goto L_0x012b
        L_0x0125:
            boolean r11 = r11.contains(r8)
            if (r11 == 0) goto L_0x00f9
        L_0x012b:
            r10 = r4
            goto L_0x012e
        L_0x012d:
            r10 = r5
        L_0x012e:
            if (r10 == 0) goto L_0x00d7
            r15.add(r6)
            goto L_0x00d7
        L_0x0134:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r15)
            r14.f4442c = r2
        L_0x013b:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r15 = r14.f4437b
            int r15 = r15.size()
            if (r15 > 0) goto L_0x019f
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r15 = r14.f4442c
            int r15 = r15.size()
            if (r15 <= 0) goto L_0x014c
            goto L_0x019f
        L_0x014c:
            boolean r15 = r14.f4452f
            if (r15 == 0) goto L_0x0172
            androidx.recyclerview.widget.RecyclerView r15 = r14.trainList
            r15.setVisibility(r1)
            wA r15 = r14.f4432a
            java.util.List r15 = r15.getAlternateTrainBtwnStnsList()
            if (r15 != 0) goto L_0x0168
            android.widget.TextView r15 = r14.alterTrainListShow
            r15.setVisibility(r1)
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = r14.publisherAdViewcenter
            r15.setVisibility(r1)
            goto L_0x0172
        L_0x0168:
            android.widget.TextView r15 = r14.alterTrainListShow
            r15.setVisibility(r5)
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = r14.publisherAdViewcenter
            r15.setVisibility(r5)
        L_0x0172:
            android.widget.TextView r15 = r14.availableButton
            android.content.Context r1 = r14.f4421a
            java.lang.Object r2 = defpackage.d7.a
            android.graphics.drawable.Drawable r1 = defpackage.d7.a.b(r1, r3)
            r15.setBackground(r1)
            boolean r15 = r14.f4456h
            if (r15 == 0) goto L_0x01f4
            r14.f4456h = r4
            androidx.fragment.app.FragmentActivity r15 = r14.getActivity()
            r1 = 2131953296(0x7f130690, float:1.9543059E38)
            java.lang.String r1 = r14.getString(r1)
            r2 = 2131953334(0x7f1306b6, float:1.9543136E38)
            java.lang.String r2 = r14.getString(r2)
            android.app.AlertDialog r15 = defpackage.C0535I5.o(r15, r1, r2, r0)
            r15.show()
            goto L_0x01f4
        L_0x019f:
            r14.q()
            goto L_0x01f4
        L_0x01a3:
            boolean r0 = r14.f4452f
            if (r0 == 0) goto L_0x01c9
            androidx.recyclerview.widget.RecyclerView r0 = r14.trainList
            r0.setVisibility(r5)
            wA r0 = r14.f4432a
            java.util.List r0 = r0.getAlternateTrainBtwnStnsList()
            if (r0 != 0) goto L_0x01bf
            android.widget.TextView r0 = r14.alterTrainListShow
            r0.setVisibility(r1)
            com.google.android.gms.ads.admanager.AdManagerAdView r0 = r14.publisherAdViewcenter
            r0.setVisibility(r1)
            goto L_0x01c9
        L_0x01bf:
            android.widget.TextView r0 = r14.alterTrainListShow
            r0.setVisibility(r5)
            com.google.android.gms.ads.admanager.AdManagerAdView r0 = r14.publisherAdViewcenter
            r0.setVisibility(r5)
        L_0x01c9:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r0 = r14.f4442c
            if (r0 == 0) goto L_0x01d0
            r0.clear()
        L_0x01d0:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r0 = r14.f4437b
            if (r0 == 0) goto L_0x01d7
            r0.clear()
        L_0x01d7:
            r14.f4456h = r4
            r14.m()
            r14.p()
            cris.org.in.ima.adaptors.TrainListViewHolder r0 = r14.f4422a
            r0.notifyDataSetChanged()
            cris.org.in.ima.adaptors.TrainListViewHolder r0 = r14.f4434b
            r0.notifyDataSetChanged()
            android.content.Context r0 = r14.f4421a
            java.lang.Object r1 = defpackage.d7.a
            android.graphics.drawable.Drawable r0 = defpackage.d7.a.b(r0, r3)
            r15.setBackground(r0)
        L_0x01f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.AllTrainListFragment.onAvailableClick(android.view.View):void");
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
        this.tv_dutypass_l.setVisibility(0);
        this.f4439c = k;
        o(l);
        if (this.quota_bottom_ll.getVisibility() == 0) {
            this.quota_bottom_ll.setVisibility(8);
        } else {
            this.quota_bottom_ll.setVisibility(0);
        }
    }

    @OnClick({2131362946})
    public void onClickTRansactionView(View view) {
        if (this.lastTransationDtail.getVisibility() == 8) {
            this.lastTransationDtail.setVisibility(0);
        } else {
            this.lastTransationDtail.setVisibility(8);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:260:0x08cc, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x094b  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x08f2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r13, android.view.ViewGroup r14, android.os.Bundle r15) {
        /*
            r12 = this;
            java.lang.String r14 = "hi"
            r15 = 2131558474(0x7f0d004a, float:1.8742265E38)
            r0 = 0
            android.view.View r13 = r13.inflate(r15, r0)
            butterknife.ButterKnife.bind((java.lang.Object) r12, (android.view.View) r13)
            android.widget.TextView r15 = cris.org.in.ima.activities.HomeActivity.f4180a
            r1 = 8
            r15.setVisibility(r1)
            android.content.Context r15 = r12.getContext()
            r12.f4421a = r15
            androidx.fragment.app.FragmentActivity r15 = r12.getActivity()
            f4409a = r15
            r12.getFragmentManager()
            android.widget.RelativeLayout r15 = r12.lastTransationDtail
            cris.org.in.ima.fragment.e r2 = new cris.org.in.ima.fragment.e
            r3 = 0
            r2.<init>(r12, r3)
            r15.setOnClickListener(r2)
            r15 = 2131363775(0x7f0a07bf, float:1.8347368E38)
            android.view.View r15 = r13.findViewById(r15)
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = (com.google.android.gms.ads.admanager.AdManagerAdView) r15
            f4411a = r15
            r15 = 2131363836(0x7f0a07fc, float:1.8347492E38)
            android.view.View r15 = r13.findViewById(r15)
            androidx.recyclerview.widget.RecyclerView r15 = (androidx.recyclerview.widget.RecyclerView) r15
            f4410a = r15
            r15 = 2131364686(0x7f0a0b4e, float:1.8349216E38)
            android.view.View r15 = r13.findViewById(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            b = r15
            r15 = 2131363777(0x7f0a07c1, float:1.8347372E38)
            android.view.View r15 = r13.findViewById(r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            a = r15
            r15 = 2131362045(0x7f0a00fd, float:1.834386E38)
            android.view.View r15 = r13.findViewById(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            f4408a = r15
            android.widget.TextView r15 = r12.durationEarlyFirst
            r15.setVisibility(r3)
            android.widget.TextView r15 = r12.durationLateFirst
            r15.setVisibility(r3)
            android.widget.TextView r15 = r12.departureEarlyFirst
            r15.setVisibility(r3)
            android.widget.TextView r15 = r12.departureLateFirst
            r15.setVisibility(r3)
            android.widget.TextView r15 = r12.arrivalEarlyFirst
            r15.setVisibility(r3)
            android.widget.TextView r15 = r12.arrivalLateFirst
            r15.setVisibility(r3)
            android.widget.TextView r15 = r12.departure
            r15.setVisibility(r1)
            android.widget.TextView r15 = r12.arrival
            r15.setVisibility(r1)
            android.widget.TextView r15 = r12.travelTime
            r15.setVisibility(r1)
            android.os.Bundle r15 = r12.getArguments()
            boolean r2 = r12.f4454g
            if (r2 != 0) goto L_0x0195
            if (r15 == 0) goto L_0x0195
            java.lang.String r2 = "Response"
            java.io.Serializable r2 = r15.getSerializable(r2)
            wA r2 = (defpackage.C1455wA) r2
            r12.f4432a = r2
            java.lang.String r2 = "trainBtwnStnsModelsListFilter"
            java.io.Serializable r2 = r15.getSerializable(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r12.f4451f = r2
            java.lang.String r2 = "alternateTrainBtwnStnsListFilter"
            java.io.Serializable r2 = r15.getSerializable(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r12.f4453g = r2
            java.lang.String r2 = "FromStationCode"
            java.lang.String r2 = r15.getString(r2)
            o = r2
            java.lang.String r2 = "ToStationCode"
            java.lang.String r2 = r15.getString(r2)
            p = r2
            java.lang.String r2 = "FromStationString"
            java.lang.String r2 = r15.getString(r2)
            q = r2
            java.lang.String r2 = "ToStationString"
            java.lang.String r2 = r15.getString(r2)
            r = r2
            java.lang.String r2 = "flexiableWithDate"
            java.lang.String r2 = r15.getString(r2)
            r12.f4444d = r2
            java.lang.String r2 = "flexiableDateFlag"
            boolean r2 = r15.getBoolean(r2)
            f4416j = r2
            java.lang.String r2 = "spConcession"
            java.lang.String r2 = r15.getString(r2)
            m = r2
            java.lang.String r2 = "JourneyDate"
            java.lang.String r2 = r15.getString(r2)
            k = r2
            java.lang.String r2 = "isConnectingJourney"
            boolean r2 = r15.getBoolean(r2)
            i = r2
            java.lang.String r2 = "journalistconcession"
            r15.getBoolean(r2)
            java.lang.String r2 = "divyanconcession"
            r15.getBoolean(r2)
            java.lang.String r2 = "rebookFlag"
            boolean r4 = r15.getBoolean(r2)
            f4418l = r4
            java.lang.String r4 = "jrnyClass"
            java.lang.String r4 = r15.getString(r4)
            r12.f4447e = r4
            java.lang.String r4 = "rebookClass"
            java.lang.String r4 = r15.getString(r4)
            r12.f4450f = r4
            boolean r2 = r15.getBoolean(r2)
            f4418l = r2
            java.lang.String r2 = "avlClassModel"
            java.io.Serializable r2 = r15.getSerializable(r2)
            cris.org.in.ima.model.AvlClassModel r2 = (cris.org.in.ima.model.AvlClassModel) r2
            r12.f4424a = r2
            java.lang.String r2 = "trainBtwnStnsModel"
            java.io.Serializable r2 = r15.getSerializable(r2)
            cris.org.in.ima.model.TrainBtwnStnsModel r2 = (cris.org.in.ima.model.TrainBtwnStnsModel) r2
            r12.f4425a = r2
            java.lang.String r2 = "altAvlEnqFlag"
            boolean r2 = r15.getBoolean(r2)
            r12.f4449e = r2
            java.lang.String r2 = "trainAvailableBerthIsChecked"
            boolean r2 = r15.getBoolean(r2)
            r12.f4452f = r2
            java.lang.String r2 = "altAvlClass"
            r15.getString(r2)
            java.lang.String r2 = "selectedQuota"
            java.lang.String r2 = r15.getString(r2)
            r12.h = r2
            java.lang.String r2 = "reebookPsgnList"
            java.io.Serializable r2 = r15.getSerializable(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r12.f4448e = r2
            java.lang.String r2 = "trainTypeListData"
            java.io.Serializable r2 = r15.getSerializable(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r12.f4435b = r2
            java.lang.String r2 = "trainTypeFlag"
            java.io.Serializable r2 = r15.getSerializable(r2)
            java.util.HashMap r2 = (java.util.HashMap) r2
            r12.f4436b = r2
            java.lang.String r2 = "classFlag"
            java.io.Serializable r2 = r15.getSerializable(r2)
            java.util.HashMap r2 = (java.util.HashMap) r2
            r12.f4441c = r2
            java.lang.String r2 = "avlClassHashSet"
            java.io.Serializable r15 = r15.getSerializable(r2)
            java.util.Set r15 = (java.util.Set) r15
            r12.f4431a = r15
            wA r15 = r12.f4432a
            java.util.List r15 = r15.getQuotaList()
            r12.f4430a = r15
        L_0x0195:
            b1 r15 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r15 = r15.f3911a
            android.widget.TextView r2 = cris.org.in.ima.activities.HomeActivity.f4185b
            r2.setVisibility(r3)
            android.widget.TextView r2 = cris.org.in.ima.activities.HomeActivity.f4185b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = o
            java.lang.String r5 = r15.m(r5)
            r4.append(r5)
            java.lang.String r5 = " "
            r4.append(r5)
            r6 = 2131952107(0x7f1301eb, float:1.9540647E38)
            java.lang.String r6 = r12.getString(r6)
            r4.append(r6)
            r4.append(r5)
            java.lang.String r6 = p
            java.lang.String r15 = r15.m(r6)
            r4.append(r15)
            java.lang.String r15 = r4.toString()
            r2.setText(r15)
            java.lang.String r15 = defpackage.C1450w1.f7009a
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r2 = f4412a
            r2.setAge(r15)
            java.lang.String r15 = defpackage.C1450w1.f7021c
            r2.setGender(r15)
            java.lang.String r15 = o
            r2.setSource(r15)
            java.lang.String r15 = p
            r2.setDestination(r15)
            androidx.fragment.app.FragmentActivity r15 = r12.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r4 = r12.publisherAdViewtop
            defpackage.C0535I5.Y(r15, r4, r2)
            androidx.fragment.app.FragmentActivity r15 = r12.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r4 = r12.publisherAdViewcenter
            defpackage.C0535I5.Y(r15, r4, r2)
            androidx.fragment.app.FragmentActivity r15 = r12.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r4 = r12.publisherAdViewbottom
            defpackage.C0535I5.Y(r15, r4, r2)
            java.lang.String r15 = r12.f4447e
            java.lang.String r4 = ""
            r6 = 1
            if (r15 == 0) goto L_0x0216
            boolean r15 = r15.equals(r4)
            if (r15 != 0) goto L_0x0216
            java.util.ArrayList r15 = r12.f4445d
            java.lang.String r7 = r12.f4447e
            r15.add(r7)
            goto L_0x021b
        L_0x0216:
            android.widget.CheckBox r15 = r12.cbclass
            r15.setChecked(r6)
        L_0x021b:
            java.lang.String r15 = r12.f4447e
            boolean r15 = r15.equals(r4)
            if (r15 == 0) goto L_0x02a7
            wA r15 = r12.f4432a
            java.util.List r15 = r15.getTrainBtwnStnsList()
            if (r15 == 0) goto L_0x02a7
            wA r15 = r12.f4432a
            java.util.List r15 = r15.getTrainBtwnStnsList()
            java.util.Iterator r15 = r15.iterator()
        L_0x0235:
            boolean r7 = r15.hasNext()
            if (r7 == 0) goto L_0x02a7
            java.lang.Object r7 = r15.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r7 = (cris.org.in.ima.model.TrainBtwnStnsModel) r7
            java.lang.String r8 = k
            r7.f = r8
            java.util.ArrayList<java.lang.String> r8 = r12.f4435b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r7.f5342a
            java.util.List r10 = r9.getTrainType()
            java.lang.Object r10 = r10.get(r3)
            java.lang.String r10 = (java.lang.String) r10
            r8.add(r10)
            java.util.HashMap<java.lang.String, java.lang.Boolean> r8 = r12.f4436b
            java.util.List r9 = r9.getTrainType()
            java.lang.Object r9 = r9.get(r3)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r8.put(r9, r10)
            java.util.ArrayList r7 = r7.f5346a
            java.util.Iterator r7 = r7.iterator()
        L_0x026d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0235
            java.lang.Object r8 = r7.next()
            cris.org.in.ima.model.AvlClassModel r8 = (cris.org.in.ima.model.AvlClassModel) r8
            java.lang.String r9 = r12.f4447e
            boolean r9 = r9.equals(r4)
            if (r9 != 0) goto L_0x0296
            java.lang.String r9 = r12.f4447e
            java.lang.String r10 = r8.c
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x028c
            goto L_0x0296
        L_0x028c:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r9 = r12.f4441c
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            java.lang.String r11 = r8.c
            r9.put(r11, r10)
            goto L_0x029f
        L_0x0296:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r9 = r12.f4441c
            java.lang.String r10 = r8.c
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r9.put(r10, r11)
        L_0x029f:
            java.util.Set<java.lang.String> r9 = r12.f4431a
            java.lang.String r8 = r8.c
            r9.add(r8)
            goto L_0x026d
        L_0x02a7:
            java.lang.String r15 = r12.f4447e
            boolean r15 = r15.equals(r4)
            if (r15 == 0) goto L_0x0331
            wA r15 = r12.f4432a
            java.util.List r15 = r15.getAlternateTrainBtwnStnsList()
            if (r15 == 0) goto L_0x0331
            wA r15 = r12.f4432a
            java.util.List r15 = r15.getAlternateTrainBtwnStnsList()
            java.util.Iterator r15 = r15.iterator()
        L_0x02c1:
            boolean r7 = r15.hasNext()
            if (r7 == 0) goto L_0x0331
            java.lang.Object r7 = r15.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r7 = (cris.org.in.ima.model.TrainBtwnStnsModel) r7
            java.util.ArrayList<java.lang.String> r8 = r12.f4435b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r7.f5342a
            java.util.List r9 = r9.getTrainType()
            java.lang.Object r9 = r9.get(r3)
            java.lang.String r9 = (java.lang.String) r9
            r8.add(r9)
            java.util.HashMap<java.lang.String, java.lang.Boolean> r8 = r12.f4436b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r7.f5342a
            java.util.List r9 = r9.getTrainType()
            java.lang.Object r9 = r9.get(r3)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r8.put(r9, r10)
            java.util.ArrayList r7 = r7.f5346a
            java.util.Iterator r7 = r7.iterator()
        L_0x02f7:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x02c1
            java.lang.Object r8 = r7.next()
            cris.org.in.ima.model.AvlClassModel r8 = (cris.org.in.ima.model.AvlClassModel) r8
            java.lang.String r9 = r12.f4447e
            boolean r9 = r9.equals(r4)
            if (r9 != 0) goto L_0x0320
            java.lang.String r9 = r12.f4447e
            java.lang.String r10 = r8.c
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0316
            goto L_0x0320
        L_0x0316:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r9 = r12.f4441c
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            java.lang.String r11 = r8.c
            r9.put(r11, r10)
            goto L_0x0329
        L_0x0320:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r9 = r12.f4441c
            java.lang.String r10 = r8.c
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r9.put(r10, r11)
        L_0x0329:
            java.util.Set<java.lang.String> r9 = r12.f4431a
            java.lang.String r8 = r8.c
            r9.add(r8)
            goto L_0x02f7
        L_0x0331:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "R"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0341
            android.widget.RelativeLayout r15 = r12.rajdhani_rl
            r15.setVisibility(r1)
            goto L_0x035a
        L_0x0341:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0355
            android.widget.CheckBox r15 = r12.ch_rajdhani
            r15.setChecked(r6)
            goto L_0x035a
        L_0x0355:
            android.widget.CheckBox r15 = r12.ch_rajdhani
            r15.setChecked(r3)
        L_0x035a:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "S"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x036a
            android.widget.RelativeLayout r15 = r12.shatabdi_rl
            r15.setVisibility(r1)
            goto L_0x0383
        L_0x036a:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x037e
            android.widget.CheckBox r15 = r12.ch_shatabdi
            r15.setChecked(r6)
            goto L_0x0383
        L_0x037e:
            android.widget.CheckBox r15 = r12.ch_shatabdi
            r15.setChecked(r3)
        L_0x0383:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "D"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0393
            android.widget.RelativeLayout r15 = r12.duronto_rl
            r15.setVisibility(r1)
            goto L_0x03ac
        L_0x0393:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x03a7
            android.widget.CheckBox r15 = r12.ch_duranto
            r15.setChecked(r6)
            goto L_0x03ac
        L_0x03a7:
            android.widget.CheckBox r15 = r12.ch_duranto
            r15.setChecked(r3)
        L_0x03ac:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "SP"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x03bc
            android.widget.RelativeLayout r15 = r12.special_trian_rl
            r15.setVisibility(r1)
            goto L_0x03d5
        L_0x03bc:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x03d0
            android.widget.CheckBox r15 = r12.ch_special_train
            r15.setChecked(r6)
            goto L_0x03d5
        L_0x03d0:
            android.widget.CheckBox r15 = r12.ch_special_train
            r15.setChecked(r3)
        L_0x03d5:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "ST"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x03e5
            android.widget.RelativeLayout r15 = r12.special_tatkal_rl
            r15.setVisibility(r1)
            goto L_0x03fe
        L_0x03e5:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x03f9
            android.widget.CheckBox r15 = r12.ch_special_tatkal
            r15.setChecked(r6)
            goto L_0x03fe
        L_0x03f9:
            android.widget.CheckBox r15 = r12.ch_special_tatkal
            r15.setChecked(r3)
        L_0x03fe:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "G"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x040e
            android.widget.RelativeLayout r15 = r12.garibrath_rl
            r15.setVisibility(r1)
            goto L_0x0427
        L_0x040e:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0422
            android.widget.CheckBox r15 = r12.ch_garibrath
            r15.setChecked(r6)
            goto L_0x0427
        L_0x0422:
            android.widget.CheckBox r15 = r12.ch_garibrath
            r15.setChecked(r3)
        L_0x0427:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "SV"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0437
            android.widget.RelativeLayout r15 = r12.suvidha_train_rl
            r15.setVisibility(r1)
            goto L_0x0450
        L_0x0437:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x044b
            android.widget.CheckBox r15 = r12.ch_suvidha_train
            r15.setChecked(r6)
            goto L_0x0450
        L_0x044b:
            android.widget.CheckBox r15 = r12.ch_suvidha_train
            r15.setChecked(r3)
        L_0x0450:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "JS"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0460
            android.widget.RelativeLayout r15 = r12.janshatabdi_rl
            r15.setVisibility(r1)
            goto L_0x0479
        L_0x0460:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0474
            android.widget.CheckBox r15 = r12.ch_janshatabdi
            r15.setChecked(r6)
            goto L_0x0479
        L_0x0474:
            android.widget.CheckBox r15 = r12.ch_janshatabdi
            r15.setChecked(r3)
        L_0x0479:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "Y"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0489
            android.widget.RelativeLayout r15 = r12.yuva_express_rl
            r15.setVisibility(r1)
            goto L_0x04a2
        L_0x0489:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x049d
            android.widget.CheckBox r15 = r12.ch_yuva_express
            r15.setChecked(r6)
            goto L_0x04a2
        L_0x049d:
            android.widget.CheckBox r15 = r12.ch_yuva_express
            r15.setChecked(r3)
        L_0x04a2:
            java.util.ArrayList<java.lang.String> r15 = r12.f4435b
            java.lang.String r7 = "O"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x04b2
            android.widget.RelativeLayout r15 = r12.others_rl
            r15.setVisibility(r1)
            goto L_0x04cb
        L_0x04b2:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4436b
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x04c6
            android.widget.CheckBox r15 = r12.ch_others
            r15.setChecked(r6)
            goto L_0x04cb
        L_0x04c6:
            android.widget.CheckBox r15 = r12.ch_others
            r15.setChecked(r3)
        L_0x04cb:
            java.util.ArrayList r15 = new java.util.ArrayList
            java.util.Set<java.lang.String> r7 = r12.f4431a
            r15.<init>(r7)
            r12.f4440c = r15
            java.lang.String r7 = "1A"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x04e2
            android.widget.LinearLayout r15 = r12.class_1A_ll
            r15.setVisibility(r1)
            goto L_0x04fb
        L_0x04e2:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x04f6
            android.widget.CheckBox r15 = r12.class_1A
            r15.setChecked(r6)
            goto L_0x04fb
        L_0x04f6:
            android.widget.CheckBox r15 = r12.class_1A
            r15.setChecked(r3)
        L_0x04fb:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "2A"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x050b
            android.widget.LinearLayout r15 = r12.class_2A_ll
            r15.setVisibility(r1)
            goto L_0x0524
        L_0x050b:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x051f
            android.widget.CheckBox r15 = r12.class_2A
            r15.setChecked(r6)
            goto L_0x0524
        L_0x051f:
            android.widget.CheckBox r15 = r12.class_2A
            r15.setChecked(r3)
        L_0x0524:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "3A"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0534
            android.widget.LinearLayout r15 = r12.class_3A_ll
            r15.setVisibility(r1)
            goto L_0x054d
        L_0x0534:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0548
            android.widget.CheckBox r15 = r12.class_3A
            r15.setChecked(r6)
            goto L_0x054d
        L_0x0548:
            android.widget.CheckBox r15 = r12.class_3A
            r15.setChecked(r3)
        L_0x054d:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "EC"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x055d
            android.widget.LinearLayout r15 = r12.class_EC_ll
            r15.setVisibility(r1)
            goto L_0x0576
        L_0x055d:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0571
            android.widget.CheckBox r15 = r12.class_EC
            r15.setChecked(r6)
            goto L_0x0576
        L_0x0571:
            android.widget.CheckBox r15 = r12.class_EC
            r15.setChecked(r3)
        L_0x0576:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "CC"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0586
            android.widget.LinearLayout r15 = r12.class_CC_ll
            r15.setVisibility(r1)
            goto L_0x059f
        L_0x0586:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x059a
            android.widget.CheckBox r15 = r12.class_CC
            r15.setChecked(r6)
            goto L_0x059f
        L_0x059a:
            android.widget.CheckBox r15 = r12.class_EC
            r15.setChecked(r3)
        L_0x059f:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "SL"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x05af
            android.widget.LinearLayout r15 = r12.class_SL_ll
            r15.setVisibility(r1)
            goto L_0x05c8
        L_0x05af:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x05c3
            android.widget.CheckBox r15 = r12.class_SL
            r15.setChecked(r6)
            goto L_0x05c8
        L_0x05c3:
            android.widget.CheckBox r15 = r12.class_SL
            r15.setChecked(r3)
        L_0x05c8:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "2S"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x05d8
            android.widget.LinearLayout r15 = r12.class_2S_ll
            r15.setVisibility(r1)
            goto L_0x05f1
        L_0x05d8:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x05ec
            android.widget.CheckBox r15 = r12.class_2S
            r15.setChecked(r6)
            goto L_0x05f1
        L_0x05ec:
            android.widget.CheckBox r15 = r12.class_2S
            r15.setChecked(r3)
        L_0x05f1:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "AC"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0601
            android.widget.LinearLayout r15 = r12.class_AC_ll
            r15.setVisibility(r1)
            goto L_0x061a
        L_0x0601:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0615
            android.widget.CheckBox r15 = r12.class_AC
            r15.setChecked(r6)
            goto L_0x061a
        L_0x0615:
            android.widget.CheckBox r15 = r12.class_AC
            r15.setChecked(r3)
        L_0x061a:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "FC"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x062a
            android.widget.LinearLayout r15 = r12.class_FC_ll
            r15.setVisibility(r1)
            goto L_0x0643
        L_0x062a:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x063e
            android.widget.CheckBox r15 = r12.class_FC
            r15.setChecked(r6)
            goto L_0x0643
        L_0x063e:
            android.widget.CheckBox r15 = r12.class_FC
            r15.setChecked(r3)
        L_0x0643:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "VS"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x0653
            android.widget.LinearLayout r15 = r12.vistadome_non_ac_ll
            r15.setVisibility(r1)
            goto L_0x066c
        L_0x0653:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0667
            android.widget.CheckBox r15 = r12.class_VS
            r15.setChecked(r6)
            goto L_0x066c
        L_0x0667:
            android.widget.CheckBox r15 = r12.class_VS
            r15.setChecked(r3)
        L_0x066c:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "VC"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x067c
            android.widget.LinearLayout r15 = r12.vistadome_chair_car_ll
            r15.setVisibility(r1)
            goto L_0x0695
        L_0x067c:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0690
            android.widget.CheckBox r15 = r12.class_VC
            r15.setChecked(r6)
            goto L_0x0695
        L_0x0690:
            android.widget.CheckBox r15 = r12.class_VC
            r15.setChecked(r3)
        L_0x0695:
            java.util.ArrayList r15 = r12.f4440c
            java.lang.String r7 = "EV"
            boolean r15 = r15.contains(r7)
            if (r15 != 0) goto L_0x06a5
            android.widget.LinearLayout r15 = r12.vistadome_chair_car_ll
            r15.setVisibility(r1)
            goto L_0x06be
        L_0x06a5:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r15 = r12.f4441c
            java.lang.Object r15 = r15.get(r7)
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x06b9
            android.widget.CheckBox r15 = r12.class_EV
            r15.setChecked(r6)
            goto L_0x06be
        L_0x06b9:
            android.widget.CheckBox r15 = r12.class_EV
            r15.setChecked(r3)
        L_0x06be:
            android.widget.RelativeLayout r15 = r12.rajdhani_rl
            cris.org.in.ima.fragment.f r1 = new cris.org.in.ima.fragment.f
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.shatabdi_rl
            cris.org.in.ima.fragment.g r1 = new cris.org.in.ima.fragment.g
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.duronto_rl
            cris.org.in.ima.fragment.h r1 = new cris.org.in.ima.fragment.h
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.special_trian_rl
            cris.org.in.ima.fragment.i r1 = new cris.org.in.ima.fragment.i
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.special_tatkal_rl
            cris.org.in.ima.fragment.j r1 = new cris.org.in.ima.fragment.j
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.garibrath_rl
            cris.org.in.ima.fragment.k r1 = new cris.org.in.ima.fragment.k
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.suvidha_train_rl
            cris.org.in.ima.fragment.l r1 = new cris.org.in.ima.fragment.l
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.janshatabdi_rl
            cris.org.in.ima.fragment.m r1 = new cris.org.in.ima.fragment.m
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.yuva_express_rl
            cris.org.in.ima.fragment.n r1 = new cris.org.in.ima.fragment.n
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.RelativeLayout r15 = r12.others_rl
            cris.org.in.ima.fragment.o r1 = new cris.org.in.ima.fragment.o
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.LinearLayout r15 = r12.earlyMorning_ll
            cris.org.in.ima.fragment.p r1 = new cris.org.in.ima.fragment.p
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.LinearLayout r15 = r12.morning_ll
            cris.org.in.ima.fragment.q r1 = new cris.org.in.ima.fragment.q
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.LinearLayout r15 = r12.midDay_ll
            cris.org.in.ima.fragment.r r1 = new cris.org.in.ima.fragment.r
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            android.widget.LinearLayout r15 = r12.night_ll
            cris.org.in.ima.fragment.s r1 = new cris.org.in.ima.fragment.s
            r1.<init>(r12)
            r15.setOnClickListener(r1)
            java.lang.String r15 = cris.org.in.ima.IrctcImaApplication.e     // Catch:{ ParseException -> 0x0788 }
            boolean r15 = r15.equalsIgnoreCase(r14)     // Catch:{ ParseException -> 0x0788 }
            java.lang.String r1 = "EEE, dd MMM  yyyy"
            java.lang.String r7 = "yyyyMMdd"
            if (r15 == 0) goto L_0x0772
            java.util.Locale r15 = new java.util.Locale     // Catch:{ ParseException -> 0x0788 }
            java.lang.String r8 = "IN"
            r15.<init>(r14, r8)     // Catch:{ ParseException -> 0x0788 }
            java.text.SimpleDateFormat r14 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0788 }
            r14.<init>(r7, r15)     // Catch:{ ParseException -> 0x0788 }
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0788 }
            r7.<init>(r1, r15)     // Catch:{ ParseException -> 0x0788 }
            java.lang.String r15 = k     // Catch:{ ParseException -> 0x0788 }
            java.util.Date r14 = r14.parse(r15)     // Catch:{ ParseException -> 0x0788 }
            java.lang.String r14 = r7.format(r14)     // Catch:{ ParseException -> 0x0788 }
            goto L_0x0786
        L_0x0772:
            java.text.SimpleDateFormat r14 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0788 }
            r14.<init>(r7)     // Catch:{ ParseException -> 0x0788 }
            java.text.SimpleDateFormat r15 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0788 }
            r15.<init>(r1)     // Catch:{ ParseException -> 0x0788 }
            java.lang.String r1 = k     // Catch:{ ParseException -> 0x0788 }
            java.util.Date r14 = r14.parse(r1)     // Catch:{ ParseException -> 0x0788 }
            java.lang.String r14 = r15.format(r14)     // Catch:{ ParseException -> 0x0788 }
        L_0x0786:
            r4 = r14
            goto L_0x078c
        L_0x0788:
            r14 = move-exception
            r14.getMessage()
        L_0x078c:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = o
            r14.append(r15)
            r14.append(r5)
            r15 = 2131953827(0x7f1308a3, float:1.9544136E38)
            java.lang.String r15 = r12.getString(r15)
            r14.append(r15)
            r14.append(r5)
            java.lang.String r15 = p
            r14.append(r15)
            java.lang.String r15 = " | "
            r14.append(r15)
            r14.append(r4)
            java.lang.String r14 = r14.toString()
            cris.org.in.ima.activities.HomeActivity.H(r14)
            android.widget.TextView r14 = r12.departureFrom
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r1 = 2131951743(0x7f13007f, float:1.953991E38)
            java.lang.String r1 = r12.getString(r1)
            r15.append(r1)
            java.lang.String r1 = o
            defpackage.lf.x(r15, r1, r14)
            android.widget.TextView r14 = r12.departureFrom
            r15 = 4
            r14.setVisibility(r15)
            boolean r14 = f4418l
            if (r14 == 0) goto L_0x0817
            wA r14 = r12.f4432a
            java.util.List r14 = r14.getTrainBtwnStnsList()
            if (r14 == 0) goto L_0x0817
            wA r14 = r12.f4432a
            java.util.List r14 = r14.getTrainBtwnStnsList()
            java.util.Iterator r14 = r14.iterator()
        L_0x07ec:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0817
            java.lang.Object r15 = r14.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r15 = (cris.org.in.ima.model.TrainBtwnStnsModel) r15
            cris.prs.webservices.dto.TrainBtwnStnsDTO r1 = r15.f5342a
            java.lang.String r1 = r1.getTrainNumber()
            cris.org.in.ima.model.TrainBtwnStnsModel r4 = r12.f4425a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r4.f5342a
            java.lang.String r4 = r4.getTrainNumber()
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x07ec
            f4414b = r15
            java.lang.String r1 = r12.f4450f
            r15.f5348c = r1
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r15.c = r1
            goto L_0x07ec
        L_0x0817:
            boolean r14 = r12.f4452f
            if (r14 != 0) goto L_0x084c
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4451f
            int r14 = r14.size()
            if (r14 >= r6) goto L_0x0831
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4453g
            int r14 = r14.size()
            if (r14 < r6) goto L_0x082c
            goto L_0x0831
        L_0x082c:
            r12.p()
            goto L_0x0987
        L_0x0831:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4437b
            if (r14 == 0) goto L_0x083c
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r15 = r12.f4451f
            if (r15 == 0) goto L_0x083c
            r14.addAll(r15)
        L_0x083c:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4442c
            if (r14 == 0) goto L_0x0847
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r15 = r12.f4453g
            if (r15 == 0) goto L_0x0847
            r14.addAll(r15)
        L_0x0847:
            r12.q()
            goto L_0x0987
        L_0x084c:
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4451f
            int r14 = r14.size()
            if (r14 >= r6) goto L_0x0865
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4453g
            int r14 = r14.size()
            if (r14 < r6) goto L_0x085d
            goto L_0x0865
        L_0x085d:
            r12.p()
            r12.onAvailableClick(r13)
            goto L_0x0987
        L_0x0865:
            java.util.LinkedHashSet r14 = new java.util.LinkedHashSet
            r14.<init>()
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r15 = r12.f4451f
            java.lang.String r1 = "AVAIL"
            java.lang.String r4 = "CURR"
            java.lang.String r7 = "NOT"
            if (r15 == 0) goto L_0x08dc
            java.util.Iterator r15 = r15.iterator()
        L_0x0878:
            boolean r8 = r15.hasNext()
            if (r8 == 0) goto L_0x08d5
            java.lang.Object r8 = r15.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r8 = (cris.org.in.ima.model.TrainBtwnStnsModel) r8
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r8.f5342a
            java.util.List r9 = r9.getClassAvlDTO()
            if (r9 == 0) goto L_0x08ce
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r8.f5342a
            java.util.List r9 = r9.getClassAvlDTO()
            java.util.Iterator r9 = r9.iterator()
        L_0x0896:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x08ce
            java.lang.Object r10 = r9.next()
            cris.prs.webservices.dto.ClassAvlDTO r10 = (cris.prs.webservices.dto.ClassAvlDTO) r10
            java.util.List r11 = r10.getAvlDayList()
            java.lang.Object r11 = r11.get(r3)
            if (r11 == 0) goto L_0x0896
            java.util.List r10 = r10.getAvlDayList()
            java.lang.Object r10 = r10.get(r3)
            d2 r10 = (defpackage.C1060d2) r10
            java.lang.String r10 = r10.getAvailablityStatus()
            boolean r11 = r10.contains(r7)
            if (r11 != 0) goto L_0x08c6
            boolean r11 = r10.contains(r1)
            if (r11 != 0) goto L_0x08cc
        L_0x08c6:
            boolean r10 = r10.contains(r4)
            if (r10 == 0) goto L_0x0896
        L_0x08cc:
            r9 = r6
            goto L_0x08cf
        L_0x08ce:
            r9 = r3
        L_0x08cf:
            if (r9 == 0) goto L_0x0878
            r14.add(r8)
            goto L_0x0878
        L_0x08d5:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>(r14)
            r12.f4437b = r15
        L_0x08dc:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r12.f4442c = r14
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4453g
            if (r14 == 0) goto L_0x0956
            java.util.LinkedHashSet r14 = new java.util.LinkedHashSet
            r14.<init>()
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r15 = r12.f4453g
            java.util.Iterator r15 = r15.iterator()
        L_0x08f2:
            boolean r8 = r15.hasNext()
            if (r8 == 0) goto L_0x094f
            java.lang.Object r8 = r15.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r8 = (cris.org.in.ima.model.TrainBtwnStnsModel) r8
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r8.f5342a
            java.util.List r9 = r9.getClassAvlDTO()
            if (r9 == 0) goto L_0x0948
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r8.f5342a
            java.util.List r9 = r9.getClassAvlDTO()
            java.util.Iterator r9 = r9.iterator()
        L_0x0910:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0948
            java.lang.Object r10 = r9.next()
            cris.prs.webservices.dto.ClassAvlDTO r10 = (cris.prs.webservices.dto.ClassAvlDTO) r10
            java.util.List r11 = r10.getAvlDayList()
            java.lang.Object r11 = r11.get(r3)
            if (r11 == 0) goto L_0x0910
            java.util.List r10 = r10.getAvlDayList()
            java.lang.Object r10 = r10.get(r3)
            d2 r10 = (defpackage.C1060d2) r10
            java.lang.String r10 = r10.getAvailablityStatus()
            boolean r11 = r10.contains(r7)
            if (r11 != 0) goto L_0x0940
            boolean r11 = r10.contains(r1)
            if (r11 != 0) goto L_0x0946
        L_0x0940:
            boolean r10 = r10.contains(r4)
            if (r10 == 0) goto L_0x0910
        L_0x0946:
            r9 = r6
            goto L_0x0949
        L_0x0948:
            r9 = r3
        L_0x0949:
            if (r9 == 0) goto L_0x08f2
            r14.add(r8)
            goto L_0x08f2
        L_0x094f:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>(r14)
            r12.f4442c = r15
        L_0x0956:
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4437b
            int r14 = r14.size()
            if (r14 > 0) goto L_0x0981
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r14 = r12.f4442c
            int r14 = r14.size()
            if (r14 <= 0) goto L_0x0967
            goto L_0x0981
        L_0x0967:
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            r15 = 2131953296(0x7f130690, float:1.9543059E38)
            java.lang.String r15 = r12.getString(r15)
            r1 = 2131953334(0x7f1306b6, float:1.9543136E38)
            java.lang.String r1 = r12.getString(r1)
            android.app.AlertDialog r14 = defpackage.C0535I5.o(r14, r15, r1, r0)
            r14.show()
            goto L_0x0984
        L_0x0981:
            r12.q()
        L_0x0984:
            r12.q()
        L_0x0987:
            r12.durationEarlyFirst()
            java.lang.String r14 = r12.h
            l = r14
            r12.o(r14)
            boolean r14 = r12.f4446d
            if (r14 == 0) goto L_0x099a
            f4418l = r3
            r12.m()
        L_0x099a:
            boolean r14 = f4418l
            if (r14 == 0) goto L_0x09dd
            wA r14 = r12.f4432a
            java.util.List r14 = r14.getTrainBtwnStnsList()
            if (r14 == 0) goto L_0x09dd
            wA r14 = r12.f4432a
            java.util.List r14 = r14.getTrainBtwnStnsList()
            java.util.Iterator r14 = r14.iterator()
        L_0x09b0:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x09dd
            java.lang.Object r15 = r14.next()
            cris.org.in.ima.model.TrainBtwnStnsModel r15 = (cris.org.in.ima.model.TrainBtwnStnsModel) r15
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r15.f5342a
            java.lang.String r0 = r0.getTrainNumber()
            cris.org.in.ima.model.TrainBtwnStnsModel r1 = r12.f4425a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r1 = r1.f5342a
            java.lang.String r1 = r1.getTrainNumber()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x09b0
            f4414b = r15
            cris.org.in.ima.model.AvlClassModel r0 = r12.f4424a
            java.lang.String r0 = r0.c
            r15.f5348c = r0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r15.c = r0
            goto L_0x09b0
        L_0x09dd:
            android.widget.TextView r14 = cris.org.in.ima.activities.HomeActivity.f4191e
            cris.org.in.ima.fragment.AllTrainListFragment$f r15 = new cris.org.in.ima.fragment.AllTrainListFragment$f
            r15.<init>()
            r14.setOnClickListener(r15)
            java.lang.String r14 = r12.h
            H9 r14 = defpackage.H9.f(r14)
            if (r14 == 0) goto L_0x0a0a
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r5)
            java.lang.String r15 = r12.h
            H9 r15 = defpackage.H9.f(r15)
            java.lang.String r15 = r15.a()
            java.lang.String r15 = defpackage.C0535I5.s0(r15)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            goto L_0x0a18
        L_0x0a0a:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r5)
            java.lang.String r15 = r12.h
            r14.append(r15)
            java.lang.String r14 = r14.toString()
        L_0x0a18:
            android.widget.TextView r15 = r12.tv_quota
            r15.setText(r14)
            java.lang.String r15 = " Parliament House"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0a2c
            android.widget.TextView r14 = r12.tv_quota
            r15 = 1095761920(0x41500000, float:13.0)
            r14.setTextSize(r15)
        L_0x0a2c:
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = r12.publisherAdViewtop
            defpackage.C0535I5.Y(r14, r15, r2)
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = r12.publisherAdViewcenter
            defpackage.C0535I5.Y(r14, r15, r2)
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = r12.publisherAdViewbottom
            defpackage.C0535I5.Y(r14, r15, r2)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.AllTrainListFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4420a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4420a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364388})
    public void onDutypassClickl(View view) {
        l();
        C0535I5.p(getContext(), false, getResources().getString(R.string.duty_pass_mgs), "Confirmation", getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        l = "DP";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "ड्यूटी पास";
        } else {
            n = H9.i.a();
        }
        view.setSelected(true);
        this.tv_quota.setText(getString(R.string.duty_pass));
        m = "S";
        this.quota_bottom_ll.setVisibility(8);
        n(this.tv_dutypass_l, R.color.dark);
        this.tv_dutypass_l.setTextAppearance(getActivity(), R.style.fontForbold);
        u();
    }

    @OnClick({2131364185})
    public void onFareBackUp(View view) {
        String str;
        if (!this.f4449e) {
            try {
                str = new SimpleDateFormat("dd MMM EEEE yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(k));
            } catch (ParseException e2) {
                e2.getMessage();
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(o);
            sb.append(" ");
            sb.append(getString(R.string.to_se));
            sb.append(" ");
            String B = C1058d.B(sb, p, " | ", str);
            Intent intent = new Intent(getContext(), FareBreakupActivity.class);
            intent.putExtra("googleAdParamDTO", (Serializable) null);
            intent.putExtra("FareResponse", f4413a);
            intent.putExtra("TrainBtwnStnsDTO", f4414b.f5342a);
            intent.putExtra("jDateString", j);
            intent.putExtra("toolbarSubtitle", B);
            startActivity(intent);
        }
    }

    @OnClick({2131364429})
    public void onGeneralClick(View view) {
        l();
        l = "GN";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "सामान्य";
        } else {
            n = H9.a.a();
        }
        view.setSelected(true);
        m = "N";
        this.quota_bottom_ll.setVisibility(8);
        this.tv_quota.setText(getString(R.string.generalString));
        n(this.tvGeneral, R.color.dark);
        this.tvGeneral.setTextAppearance(getActivity(), R.style.fontForbold);
        u();
    }

    @OnClick({2131364529})
    public void onHandicapClick(View view) {
        l();
        l = "HP";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "दिव्यांग ";
        } else {
            n = H9.e.a();
        }
        view.setSelected(true);
        m = "N";
        this.tv_quota.setText(getString(R.string.DivyangjanString));
        this.quota_bottom_ll.setVisibility(8);
        n(this.phHandicap, R.color.dark);
        this.phHandicap.setTextAppearance(getActivity(), R.style.fontForbold);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
        C0535I5.p(getContext(), false, getResources().getString(R.string.spc_popUp_Msgs), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        u();
    }

    @OnClick({2131362103})
    public void onJourneyDateClick() {
        Date date;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.get(1);
        gregorianCalendar.get(2);
        gregorianCalendar.get(5);
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(k);
        } catch (Exception e2) {
            e2.getMessage();
            date = null;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTime(date);
        this.d = gregorianCalendar2.get(1);
        this.e = gregorianCalendar2.get(2);
        this.f = gregorianCalendar2.get(5);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new h(), this.d, this.e, this.f);
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
        l();
        l = "LD";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "महिला";
        } else {
            n = H9.b.a();
        }
        view.setSelected(true);
        m = "N";
        this.tv_quota.setText(getString(R.string.ladiesString));
        this.quota_bottom_ll.setVisibility(8);
        n(this.tvLadies, R.color.dark);
        this.tvLadies.setTextAppearance(getActivity(), R.style.fontForbold);
        u();
    }

    @OnClick({2131363678})
    public void onOtpResendClick() {
        try {
            k();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131364522})
    public void onParliamentHouseClick(View view) {
        l();
        l = "PH";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "PARLIAMENT HOUSE";
        } else {
            n = H9.h.a();
        }
        view.setSelected(true);
        this.tv_quota.setText(getString(R.string.parliamentHouseString));
        this.quota_bottom_ll.setVisibility(8);
        n(this.parliamentHouse, R.color.dark);
        this.parliamentHouse.setTextAppearance(getActivity(), R.style.fontForbold);
        u();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4420a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4420a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364537})
    public void onPremiumTatkalClick(View view) {
        l();
        l = "PT";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "प्रीमियम तत्काल";
        } else {
            n = H9.g.a();
        }
        view.setSelected(true);
        m = "N";
        this.tv_quota.setText(getString(R.string.premiumTatkalString));
        this.quota_bottom_ll.setVisibility(8);
        n(this.premiumTatkal, R.color.dark);
        this.premiumTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
        u();
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
        ProgressDialog progressDialog;
        super.onResume();
        if (HomeActivity.f4186b) {
            HomeActivity.f4186b = false;
            this.f4429a.clear();
            ProgressDialog progressDialog2 = this.f4420a;
            if (progressDialog2 != null && progressDialog2.isShowing()) {
                this.f4420a.dismiss();
            }
            if (!(this.f4424a == null || this.f4426a == null || a.getVisibility() == 0 || this.f4426a == null || (progressDialog = this.f4420a) == null || !progressDialog.isShowing())) {
                this.f4420a.dismiss();
            }
        }
        HomeActivity.f4186b = false;
    }

    @OnClick({2131364623})
    public void onSearchClick() {
        C0573L6 l6 = this.f4419a;
        try {
            if (this.c == 1) {
                if (this.inputPnr.getText().toString().compareToIgnoreCase("") == 0) {
                    C0535I5.o(getActivity(), getString(R.string.Please_Enter_PNR), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                } else if (this.inputPnr.getText().toString().length() != 10) {
                    C0535I5.o(getActivity(), getString(R.string.PNR_10_digits), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                } else {
                    f4414b.a.getEnqClass();
                    throw null;
                }
            } else if (this.otp.getText().toString().compareToIgnoreCase("") == 0) {
                C0535I5.o(getActivity(), getString(R.string.Please_Enter_PNR), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else {
                l6.setOtpCode(this.otp.getText().toString());
                if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                    new Handler().postDelayed(new C1449w0(), 5000);
                    return;
                }
                ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text));
                String f2 = C0657Qt.f();
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).f1(f2 + "linkpnrenq", l6).c(C1181iv.a()).a(E0.a()).b(new C1050v(this, show));
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131364597})
    public void onSeniorCitizenClick(View view) {
        l();
        l = "SS";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "वरिष्ठ नागरिक";
        } else {
            n = H9.d.a();
        }
        view.setSelected(true);
        m = "N";
        this.tv_quota.setText(getString(R.string.seniorCitizenString));
        this.quota_bottom_ll.setVisibility(8);
        n(this.seniorCitizen, R.color.dark);
        this.seniorCitizen.setTextAppearance(getActivity(), R.style.fontForbold);
        C0535I5.p(getContext(), false, getResources().getString(R.string.senior_citizen_msg), getString(R.string.confirmation_title), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        u();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4420a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4420a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364655})
    public void onTatkalClick(View view) {
        l();
        l = "TQ";
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            n = "तत्काल";
        } else {
            n = H9.c.a();
        }
        view.setSelected(true);
        m = "N";
        this.tv_quota.setText(getString(R.string.tatkalString));
        this.quota_bottom_ll.setVisibility(8);
        n(this.tvTatkal, R.color.dark);
        this.tvTatkal.setTextAppearance(getActivity(), R.style.fontForbold);
        u();
    }

    public final void p() {
        if (this.f4432a.getTrainBtwnStnsList() != null && this.f4432a.getTrainBtwnStnsList().size() == 0) {
            m();
        }
        this.f4422a = r(this.f4432a.getTrainBtwnStnsList(), this.f4432a.getAlternateTrainBtwnStnsList(), this.trainList);
        this.f4434b = r(this.f4432a.getAlternateTrainBtwnStnsList(), this.f4432a.getTrainBtwnStnsList(), this.trainListAternate);
        this.trainList.setLayoutManager(new LinearLayoutManager(this.f4421a));
        if (this.f4432a.getAlternateTrainBtwnStnsList() == null) {
            this.alterTrainListShow.setVisibility(8);
            this.publisherAdViewcenter.setVisibility(8);
        } else {
            this.alterTrainListShow.setVisibility(0);
            this.publisherAdViewcenter.setVisibility(0);
        }
        String str = this.f4444d;
        if (str != null && str.equalsIgnoreCase("Y")) {
            this.alterTrainListShow.setVisibility(0);
            if (this.f4432a.getAlternateTrainBtwnStnsList() == null) {
                this.tv_alter_train_list_msg.setVisibility(0);
            }
        }
        this.trainListAternate.setLayoutManager(new LinearLayoutManager(this.f4421a));
    }

    public final void q() {
        this.f4422a = r(this.f4437b, this.f4442c, this.trainList);
        List<TrainBtwnStnsModel> list = this.f4437b;
        if (list == null || list.size() != 0) {
            this.trainList.setVisibility(0);
        } else {
            this.trainList.setVisibility(8);
        }
        this.f4434b = r(this.f4442c, this.f4437b, this.trainListAternate);
        this.trainList.setLayoutManager(new LinearLayoutManager(this.f4421a));
        if (this.f4432a.getAlternateTrainBtwnStnsList() == null) {
            this.alterTrainListShow.setVisibility(8);
        } else {
            this.alterTrainListShow.setVisibility(0);
        }
        List<TrainBtwnStnsModel> list2 = this.f4442c;
        if (list2 == null || list2.size() != 0) {
            this.alterTrainListShow.setVisibility(0);
        } else {
            this.alterTrainListShow.setVisibility(8);
        }
        this.trainListAternate.setLayoutManager(new LinearLayoutManager(this.f4421a));
    }

    @OnClick({2131364549})
    public void quotaBottomLLClick() {
        this.quota_bottom_ll.setVisibility(0);
    }

    public final TrainListViewHolder r(List<TrainBtwnStnsModel> list, List<TrainBtwnStnsModel> list2, RecyclerView recyclerView) {
        TrainListViewHolder trainListViewHolder = new TrainListViewHolder(this.f4421a, list, list2, this.f4423a, this.h);
        if (list == null) {
            return trainListViewHolder;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f4421a));
        recyclerView.setAdapter(trainListViewHolder);
        return trainListViewHolder;
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
        this.class_VS.setChecked(false);
        this.class_VC.setChecked(false);
        this.class_EV.setChecked(false);
        this.ch_earlyMorning.setChecked(true);
        this.ch_morning.setChecked(true);
        this.ch_midDay.setChecked(true);
        this.ch_night.setChecked(true);
        if (!this.f4435b.contains("R")) {
            this.rajdhani_rl.setVisibility(8);
        } else {
            this.ch_rajdhani.setChecked(true);
        }
        if (!this.f4435b.contains("S")) {
            this.shatabdi_rl.setVisibility(8);
        } else {
            this.ch_shatabdi.setChecked(true);
        }
        if (!this.f4435b.contains("D")) {
            this.duronto_rl.setVisibility(8);
        } else {
            this.ch_duranto.setChecked(true);
        }
        if (!this.f4435b.contains("SP")) {
            this.special_trian_rl.setVisibility(8);
        } else {
            this.ch_special_train.setChecked(true);
        }
        if (!this.f4435b.contains("ST")) {
            this.special_tatkal_rl.setVisibility(8);
        } else {
            this.ch_special_tatkal.setChecked(true);
        }
        if (!this.f4435b.contains(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
            this.garibrath_rl.setVisibility(8);
        } else {
            this.ch_garibrath.setChecked(true);
        }
        if (!this.f4435b.contains("SV")) {
            this.suvidha_train_rl.setVisibility(8);
        } else {
            this.ch_suvidha_train.setChecked(true);
        }
        if (!this.f4435b.contains(PaymentConstants.Category.JS)) {
            this.janshatabdi_rl.setVisibility(8);
        } else {
            this.ch_janshatabdi.setChecked(true);
        }
        if (!this.f4435b.contains("Y")) {
            this.yuva_express_rl.setVisibility(8);
        } else {
            this.ch_yuva_express.setChecked(true);
        }
        if (!this.f4435b.contains("O")) {
            this.others_rl.setVisibility(8);
        } else {
            this.ch_others.setChecked(true);
        }
        ArrayList arrayList = new ArrayList(this.f4431a);
        this.f4440c = arrayList;
        if (!arrayList.contains("1A")) {
            this.class_1A_ll.setVisibility(8);
        } else {
            this.class_1A.setChecked(true);
        }
        if (!this.f4440c.contains("2A")) {
            this.class_2A_ll.setVisibility(8);
        } else {
            this.class_2A.setChecked(true);
        }
        if (!this.f4440c.contains("3A")) {
            this.class_3A_ll.setVisibility(8);
        } else {
            this.class_3A.setChecked(true);
        }
        if (!this.f4440c.contains("EC")) {
            this.class_EC_ll.setVisibility(8);
        } else {
            this.class_EC.setChecked(true);
        }
        if (!this.f4440c.contains("CC")) {
            this.class_CC_ll.setVisibility(8);
        } else {
            this.class_CC.setChecked(true);
        }
        if (!this.f4440c.contains("SL")) {
            this.class_SL_ll.setVisibility(8);
        } else {
            this.class_SL.setChecked(true);
        }
        if (!this.f4440c.contains("2S")) {
            this.class_2S_ll.setVisibility(8);
        } else {
            this.class_2S.setChecked(true);
        }
        if (!this.f4440c.contains("AC")) {
            this.class_AC_ll.setVisibility(8);
        } else {
            this.class_AC.setChecked(true);
        }
        if (!this.f4440c.contains("FC")) {
            this.class_FC_ll.setVisibility(8);
        } else {
            this.class_FC.setChecked(true);
        }
        if (!this.f4440c.contains("VS")) {
            this.vistadome_non_ac_ll.setVisibility(8);
        } else {
            this.class_VS.setChecked(true);
        }
        if (!this.f4440c.contains("VC")) {
            this.vistadome_chair_car_ll.setVisibility(8);
        } else {
            this.class_VC.setChecked(true);
        }
        if (!this.f4440c.contains("EV")) {
            this.vistadome_ac_ll.setVisibility(8);
        } else {
            this.class_EV.setChecked(true);
        }
        List<TrainBtwnStnsModel> list = this.f4437b;
        if (list != null) {
            list.clear();
        }
        List<TrainBtwnStnsModel> list2 = this.f4442c;
        if (list2 != null) {
            list2.clear();
        }
    }

    @OnClick({2131363777})
    public void rootLLClick() {
        g();
    }

    public final List<TrainBtwnStnsModel> s(int i2, List<TrainBtwnStnsModel> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (i2 == 0) {
            Collections.sort(list, new l());
        } else if (i2 == 1) {
            Collections.sort(list, new a());
        } else if (i2 == 2) {
            Collections.sort(list, new b());
        } else if (i2 == 3) {
            Collections.sort(list, new c());
        } else if (i2 == 4) {
            Collections.sort(list, new d());
        } else if (i2 == 5) {
            Collections.sort(list, new e());
        }
        return list;
    }

    @OnClick({2131363978})
    public void sortBottomLLClick() {
        g();
    }

    @OnClick({2131363976})
    public void sortbyLLClick() {
        this.bottomFareAndButtonLayout.setVisibility(8);
        g();
        if (this.sortby_bottom_ll.getVisibility() == 8) {
            this.sortby_bottom_ll.setVisibility(0);
        } else {
            this.sortby_bottom_ll.setVisibility(8);
        }
        this.filter_ll.setVisibility(8);
    }

    public final void t(int i2) {
        List<TrainBtwnStnsModel> list = this.f4437b;
        if (list == null || list.size() <= 0) {
            List<TrainBtwnStnsModel> trainBtwnStnsList = this.f4432a.getTrainBtwnStnsList();
            List<TrainBtwnStnsModel> alternateTrainBtwnStnsList = this.f4432a.getAlternateTrainBtwnStnsList();
            this.f4432a.setTrainBtwnStnsList(s(i2, trainBtwnStnsList));
            this.f4432a.setAlternateTrainBtwnStnsList(s(i2, alternateTrainBtwnStnsList));
            this.f4422a.notifyDataSetChanged();
            this.f4434b.notifyDataSetChanged();
            return;
        }
        List<TrainBtwnStnsModel> list2 = this.f4437b;
        List<TrainBtwnStnsModel> list3 = this.f4442c;
        this.f4437b = s(i2, list2);
        this.f4442c = s(i2, list3);
        this.f4422a.notifyDataSetChanged();
        this.f4434b.notifyDataSetChanged();
    }

    @OnClick({2131364247})
    public void trainNo(View view) {
        t(2);
        this.sortby_bottom_ll.setVisibility(8);
        this.filter_ll.setVisibility(8);
        n(this.arrival, R.color.white);
        n(this.departure, R.color.white);
        n(this.travelTime, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.arrival.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.travelTime.setTextAppearance(getActivity(), R.style.fontForbold);
        if (this.f4443c) {
            this.f4443c = false;
        } else {
            this.f4443c = true;
        }
        t(2);
    }

    public final void u() {
        Om om;
        boolean M = C0535I5.M();
        if (!M || C0535I5.R()) {
            if (C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
                String str = o;
                if (str == null || r == null || str.equals("") || r.equals("")) {
                    C0535I5.m(getActivity(), false, getResources().getString(R.string.station_selection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                try {
                    String str2 = o;
                    for (int i2 = 0; i2 < str2.length(); i2++) {
                        Character.isLetter(str2.charAt(i2));
                    }
                    String str3 = p;
                    for (int i3 = 0; i3 < str3.length(); i3++) {
                        Character.isLetter(str3.charAt(i3));
                    }
                } catch (Exception e2) {
                    e2.toString();
                }
                try {
                    if (l.equalsIgnoreCase("TQ") || l.equalsIgnoreCase("PT")) {
                        if ((new SimpleDateFormat("yyyyMMdd").parse(this.f4439c).getTime() - Calendar.getInstance().getTime().getTime()) / 86400000 > 4) {
                            C0535I5.o(getActivity(), getString(R.string.TQ_pt_message_first) + " " + this.f4457i + " " + getString(R.string.TQ_pt_message_second), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e3.getMessage();
                }
                try {
                    ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.train_Search), getString(R.string.please_wait_text));
                    this.f4420a = show;
                    show.show();
                    C1469x0 x0Var = new C1469x0();
                    x0Var.setDestStn(p);
                    x0Var.setSrcStn(o);
                    x0Var.setJrnyDate(this.f4439c);
                    x0Var.setJrnyClass(this.f4447e);
                    x0Var.setQuotaCode(l);
                    x0Var.setFlexiJrnyDate(this.f4439c);
                    x0Var.setFlexiFlag(f4416j);
                    x0Var.setTicketType("E");
                    Boolean bool = Boolean.FALSE;
                    x0Var.setHandicapFlag(bool);
                    x0Var.setLoyaltyRedemptionBooking(bool);
                    x0Var.setFtBooking(false);
                    x0Var.setCurrentBooking(bool);
                    if (!M) {
                        if (!C0535I5.R()) {
                            om = (Om) C0657Qt.b();
                            om.b(x0Var, "TC").c(C1181iv.a()).a(E0.a()).b(new i());
                        }
                    }
                    om = (Om) C0657Qt.c(C0793b1.a.f3912a);
                    om.b(x0Var, "TC").c(C1181iv.a()).a(E0.a()).b(new i());
                } catch (Exception e4) {
                    e4.getMessage();
                    this.f4420a.dismiss();
                    C0535I5.t0(getActivity(), getString(R.string.please_try_again));
                }
            }
        } else if (C1450w1.f7005a == 2) {
            HomeActivity.A(2);
        } else {
            HomeActivity.A(1);
        }
    }

    public class j implements Runnable {
        public final void run() {
        }
    }
}
