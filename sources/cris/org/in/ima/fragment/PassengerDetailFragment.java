package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.logging.type.LogSeverity;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.AddMealViewHolder;
import cris.org.in.ima.adaptors.AddPassengerViewHolder;
import cris.org.in.ima.adaptors.BoardingStationChangeAdapter;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.adaptors.Lap1MealDetaillViewHolder;
import cris.org.in.ima.adaptors.Lap2MealDetaillViewHolder;
import cris.org.in.ima.adaptors.MasterPassengerViewHolder;
import cris.org.in.ima.adaptors.MealDetaillViewHolder;
import cris.org.in.ima.adaptors.OtherPreferenceLapwiseAdapter;
import cris.org.in.ima.adaptors.PaymentOptionAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.ima.model.MasterPassengerModel;
import cris.org.in.ima.model.OtherPreferenceModel;
import cris.org.in.ima.model.PaymentOptionModel;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.ima.model.WrapperBoardingStationModel;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.InformationMessageDTO;
import cris.prs.webservices.dto.MealDetails;
import cris.prs.webservices.dto.MealItemDetails;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import defpackage.C1262mo;
import defpackage.C1426uk;
import defpackage.Z2;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Subscriber;

public class PassengerDetailFragment<all_laps_ll> extends Fragment {
    public static ArrayList<MasterPassengerModel> G = null;
    public static String O;
    public static String P = null;
    public static String Q;
    public static String R;
    public static String S = null;
    public static String T = null;
    public static String U = "";
    public static TextView a;

    /* renamed from: a  reason: collision with other field name */
    public static C0794b3 f4886a;

    /* renamed from: a  reason: collision with other field name */
    public static Pattern f4887a = Pattern.compile("[0-3]{1}[0-9]{1}[A-Za-z]{5}\\d{4}[A-Za-z]{1}[a-zA-Z0-9]{1}[zZ]{1}[0-9]{1}");
    public static C0794b3 b = new C0794b3();

    /* renamed from: b  reason: collision with other field name */
    public static HashMap<Short, Short> f4888b;
    public static HashMap<Short, Short> c;

    /* renamed from: c  reason: collision with other field name */
    public static List<C0794b3> f4889c;
    public static int l;
    public static int m;
    public static int n;
    public static int o;
    public static final int p = 1;
    public static boolean s = false;
    public static boolean t;
    public static boolean u;
    public String A;

    /* renamed from: A  reason: collision with other field name */
    public final ArrayList<MealItemDetails> f4890A;
    public String B;

    /* renamed from: B  reason: collision with other field name */
    public final ArrayList<MealItemDetails> f4891B;
    public String C;

    /* renamed from: C  reason: collision with other field name */
    public ArrayList<String> f4892C;
    public String D;

    /* renamed from: D  reason: collision with other field name */
    public final ArrayList<String> f4893D;
    public String E;

    /* renamed from: E  reason: collision with other field name */
    public final ArrayList<Long> f4894E;
    public String F;

    /* renamed from: F  reason: collision with other field name */
    public final ArrayList<Long> f4895F;

    /* renamed from: G  reason: collision with other field name */
    public String f4896G;
    public final String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;

    /* renamed from: a  reason: collision with other field name */
    public long f4897a;

    /* renamed from: a  reason: collision with other field name */
    public final Bw f4898a;

    /* renamed from: a  reason: collision with other field name */
    public Df f4899a;

    /* renamed from: a  reason: collision with other field name */
    public final C0668Rh f4900a;

    /* renamed from: a  reason: collision with other field name */
    public Z2.a f4901a;

    /* renamed from: a  reason: collision with other field name */
    public Z2 f4902a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4903a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4904a;

    /* renamed from: a  reason: collision with other field name */
    public TextWatcher f4905a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4906a;

    /* renamed from: a  reason: collision with other field name */
    public C0822cf f4907a;

    /* renamed from: a  reason: collision with other field name */
    public AddPassengerViewHolder f4908a;

    /* renamed from: a  reason: collision with other field name */
    public BoardingStationChangeAdapter f4909a;

    /* renamed from: a  reason: collision with other field name */
    public OtherPreferenceLapwiseAdapter f4910a;

    /* renamed from: a  reason: collision with other field name */
    public PaymentOptionAdapter f4911a;

    /* renamed from: a  reason: collision with other field name */
    public StationDb f4912a;

    /* renamed from: a  reason: collision with other field name */
    public GoogleAdParamDTO f4913a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4914a;

    /* renamed from: a  reason: collision with other field name */
    public final d0 f4915a;

    /* renamed from: a  reason: collision with other field name */
    public final C0950g f4916a;

    /* renamed from: a  reason: collision with other field name */
    public final C0951h f4917a;

    /* renamed from: a  reason: collision with other field name */
    public final C0952i f4918a;

    /* renamed from: a  reason: collision with other field name */
    public final C0960q f4919a;

    /* renamed from: a  reason: collision with other field name */
    public final C0962s f4920a;

    /* renamed from: a  reason: collision with other field name */
    public final C0963t f4921a;

    /* renamed from: a  reason: collision with other field name */
    public final C0964u f4922a;

    /* renamed from: a  reason: collision with other field name */
    public final C0965v f4923a;

    /* renamed from: a  reason: collision with other field name */
    public final C0966w f4924a;

    /* renamed from: a  reason: collision with other field name */
    public final C0967x f4925a;

    /* renamed from: a  reason: collision with other field name */
    public final C0968y f4926a;

    /* renamed from: a  reason: collision with other field name */
    public final C0969z f4927a;

    /* renamed from: a  reason: collision with other field name */
    public TrainBtwnStnsModel f4928a;

    /* renamed from: a  reason: collision with other field name */
    public AvlFareResponseDTO f4929a;

    /* renamed from: a  reason: collision with other field name */
    public PassengerDetailDTO f4930a;

    /* renamed from: a  reason: collision with other field name */
    public TrainBtwnStnsDTO f4931a;

    /* renamed from: a  reason: collision with other field name */
    public C1060d2 f4932a;

    /* renamed from: a  reason: collision with other field name */
    public final C1081e2 f4933a;

    /* renamed from: a  reason: collision with other field name */
    public C1100f2 f4934a;

    /* renamed from: a  reason: collision with other field name */
    public C1133ge f4935a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f4936a;

    /* renamed from: a  reason: collision with other field name */
    public Byte f4937a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f4938a;

    /* renamed from: a  reason: collision with other field name */
    public Short f4939a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4940a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, String> f4941a;

    /* renamed from: a  reason: collision with other field name */
    public List<InformationMessageDTO> f4942a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4943a = false;
    @BindView(2131364434)
    TextView addInfantPsgnList;
    @BindView(2131364477)
    TextView addMasterPsgnList;
    @BindView(2131361909)
    AdManagerAdView addPassengerBottom;
    @BindView(2131364275)
    TextView addPsgnDetails;
    @BindView(2131361914)
    RelativeLayout addPsgnLayout;
    @BindView(2131364267)
    TextView add_brackfast;
    @BindView(2131364269)
    TextView add_dinner;
    @BindView(2131364271)
    TextView add_infant_with_berth;
    @BindView(2131364272)
    TextView add_lunch;
    @BindView(2131361901)
    LinearLayout add_meal_ll;
    @BindView(2131361902)
    LinearLayout add_meal_ll_lap;
    @BindView(2131361905)
    LinearLayout add_meal_popupll_lap;
    @BindView(2131361906)
    RelativeLayout add_meal_rl;
    @BindView(2131361907)
    RelativeLayout add_meal_rl_lap;
    @BindView(2131364278)
    TextView add_snack;
    @BindView(2131361915)
    ImageView addfev_journey;
    @BindView(2131361916)
    ImageView addfev_journey_lap2;
    @BindView(2131361911)
    RelativeLayout addpassenger_rl;
    @BindView(2131364285)
    TextView allBerthConfirm;
    @BindView(2131361934)
    TextView all_laps_ll;
    @BindView(2131361951)
    TextView any_lap;
    @BindView(2131361956)
    EditText areaLocality;
    @BindView(2131364295)
    TextView arrTime;
    @BindView(2131364297)
    TextView arrivalDateView;
    @BindView(2131362008)
    LinearLayout auto_upgra_layout;
    @BindView(2131364304)
    TextView avlClass;

    /* renamed from: b  reason: collision with other field name */
    public final long f4944b;

    /* renamed from: b  reason: collision with other field name */
    public final C0668Rh f4945b;

    /* renamed from: b  reason: collision with other field name */
    public AddPassengerViewHolder f4946b;

    /* renamed from: b  reason: collision with other field name */
    public TrainBtwnStnsModel f4947b;

    /* renamed from: b  reason: collision with other field name */
    public AvlFareResponseDTO f4948b;

    /* renamed from: b  reason: collision with other field name */
    public PassengerDetailDTO f4949b;

    /* renamed from: b  reason: collision with other field name */
    public C1060d2 f4950b;

    /* renamed from: b  reason: collision with other field name */
    public Boolean f4951b;

    /* renamed from: b  reason: collision with other field name */
    public Short f4952b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<String> f4953b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public List<String> f4954b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4955b;
    @BindView(2131362868)
    CheckBox bedRoll;
    @BindView(2131362870)
    LinearLayout bedRollLayout;
    @BindView(2131362033)
    TextView berthPreference;
    @BindView(2131362035)
    RelativeLayout berthPreferenceClick;
    @BindView(2131362030)
    LinearLayout berthPreferenceLayout;
    @BindView(2131362031)
    LinearLayout berth_choice_ll_lap2;
    @BindView(2131362034)
    TextView berth_preference_lap2;
    @BindView(2131362036)
    RelativeLayout berth_preference_rl_lap2;
    @BindView(2131362042)
    RelativeLayout boadring_change_rl;
    @BindView(2131362049)
    TextView boardingStnName;
    @BindView(2131362048)
    RecyclerView boardingStnView;
    @BindView(2131362046)
    AdManagerAdView boarding_station_top;
    @BindView(2131362054)
    LinearLayout bookOnlyCnfLayout;
    @BindView(2131362057)
    RelativeLayout booking_choice;
    @BindView(2131362058)
    TextView booking_choise_txt;

    /* renamed from: c  reason: collision with other field name */
    public int f4956c;

    /* renamed from: c  reason: collision with other field name */
    public long f4957c;

    /* renamed from: c  reason: collision with other field name */
    public AvlFareResponseDTO f4958c;

    /* renamed from: c  reason: collision with other field name */
    public PassengerDetailDTO f4959c;

    /* renamed from: c  reason: collision with other field name */
    public Boolean f4960c;

    /* renamed from: c  reason: collision with other field name */
    public Short f4961c;

    /* renamed from: c  reason: collision with other field name */
    public final String f4962c = "";

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<PassengerDetailDTO> f4963c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4964c;
    @BindView(2131363048)
    LinearLayout cardIDLayout;
    @BindView(2131363450)
    TextView childAge;
    @BindView(2131363171)
    TextView childMale;
    @BindView(2131363459)
    EditText childPassengerName;
    @BindView(2131364223)
    TextView childTrangender;
    @BindView(2131362644)
    TextView childfeMale;
    @BindView(2131362197)
    TextView city;
    @BindView(2131362285)
    RelativeLayout confirm_berth_choice_rl;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public PassengerDetailDTO f4965d;

    /* renamed from: d  reason: collision with other field name */
    public Short f4966d;

    /* renamed from: d  reason: collision with other field name */
    public String f4967d = "";

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList<PassengerDetailDTO> f4968d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f4969d;
    @BindView(2131364365)
    TextView depTime;
    @BindView(2131364360)
    TextView departureDateView;
    @BindView(2131364385)
    TextView donePsgnDetail;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public Short f4970e;

    /* renamed from: e  reason: collision with other field name */
    public String f4971e = "";

    /* renamed from: e  reason: collision with other field name */
    public final ArrayList<Df> f4972e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f4973e;
    @BindView(2131364394)
    TextView errorMessage;
    @BindView(2131362514)
    EditText et_address1;
    @BindView(2131362515)
    EditText et_address2;
    @BindView(2131362516)
    EditText et_address3;
    @BindView(2131362522)
    TextView et_city_town;
    @BindView(2131362564)
    EditText et_pass_booking_code;
    @BindView(2131362565)
    EditText et_pass_booking_code_lap2;
    @BindView(2131362566)
    EditText et_pass_upn;
    @BindView(2131362567)
    EditText et_pass_upn_lap2;
    @BindView(2131362573)
    TextView et_post_office;
    @BindView(2131362574)
    EditText et_psgn_pincode;
    @BindView(2131362581)
    TextView et_state;
    @BindView(2131362621)
    RelativeLayout existingpassenger_ll;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public String f4974f = "";

    /* renamed from: f  reason: collision with other field name */
    public ArrayList<Z2.a> f4975f;

    /* renamed from: f  reason: collision with other field name */
    public final boolean f4976f;
    @BindView(2131364401)
    TextView farePerPerson;
    @BindView(2131364405)
    TextView feMale;
    @BindView(2131362685)
    EditText flatDoorBlock;
    @BindView(2131362690)
    TextView foodChoice;
    @BindView(2131362692)
    RelativeLayout foodChoiceclick;
    @BindView(2131362691)
    TextView food_choice_lap2;
    @BindView(2131362693)
    RelativeLayout food_choice_rl_lap2;
    @BindView(2131364424)
    TextView fromStation;
    @BindView(2131364422)
    TextView fromStationCode;
    public int g;

    /* renamed from: g  reason: collision with other field name */
    public final String f4977g = "^[^a-zA-Z]+$";

    /* renamed from: g  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4978g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f4979g;
    @BindView(2131362727)
    RadioGroup genderChildGroup;
    @BindView(2131362726)
    RadioGroup genderGroup;
    @BindView(2131362742)
    LinearLayout gst_rl;
    @BindView(2131362744)
    RelativeLayout gstcolumnShow;
    @BindView(2131362747)
    EditText gstinNumber;
    @BindView(2131362743)
    EditText gstpassengerName;
    public int h;

    /* renamed from: h  reason: collision with other field name */
    public String f4980h;

    /* renamed from: h  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4981h;

    /* renamed from: h  reason: collision with other field name */
    public boolean f4982h;
    @BindView(2131362758)
    TextView header;
    @BindView(2131362770)
    TextView headind_travelinsurance_lap1;
    @BindView(2131362774)
    TextView heading_travelInsurance;
    public int i;

    /* renamed from: i  reason: collision with other field name */
    public String f4983i;

    /* renamed from: i  reason: collision with other field name */
    public ArrayList<C1426uk.a> f4984i;

    /* renamed from: i  reason: collision with other field name */
    public boolean f4985i;
    @BindView(2131362809)
    RelativeLayout idCardLayoutClick;
    @BindView(2131362804)
    EditText idCardNumber;
    @BindView(2131362807)
    TextView idCardType;
    @BindView(2131362806)
    EditText id_card_number_lap2;
    @BindView(2131362808)
    TextView id_card_types_lap2;
    @BindView(2131362810)
    RelativeLayout id_card_types_rl_lap2;
    @BindView(2131362813)
    LinearLayout idadd_passenger_ll;
    @BindView(2131364433)
    TextView infantInfo;
    @BindView(2131361910)
    RelativeLayout infantLayout;
    @BindView(2131364276)
    TextView infantTitle;
    @BindView(2131362850)
    LinearLayout insuranceLayout;
    @BindView(2131362851)
    LinearLayout insuranceLayout_lap2;
    @BindView(2131362855)
    RadioButton insuranceOpt;
    @BindView(2131362857)
    TextView insuranceTexts;
    @BindView(2131362856)
    RadioButton insurance_opt_lap2;
    @BindView(2131362858)
    TextView insurance_text_lap2;
    @BindView(2131362009)
    CheckBox isAutoUpgradation;
    @BindView(2131362874)
    CheckBox isChildBerthReq;
    @BindView(2131362872)
    LinearLayout isChildBerthll;
    @BindView(2131362053)
    CheckBox isIgnoreChoiceIfWl;
    @BindView(2131362869)
    CheckBox is_bad_berth_lap2;
    @BindView(2131362871)
    LinearLayout is_bedroll_ll_lap2;
    @BindView(2131362873)
    LinearLayout is_childBerth_ll_lap2;
    @BindView(2131362875)
    CheckBox is_childBerth_req_lap2;
    @BindView(2131364445)
    TextView isdCode;
    public int j;

    /* renamed from: j  reason: collision with other field name */
    public String f4986j;

    /* renamed from: j  reason: collision with other field name */
    public ArrayList f4987j;

    /* renamed from: j  reason: collision with other field name */
    public boolean f4988j;
    @BindView(2131362922)
    TextView journey_detail;
    @BindView(2131362923)
    LinearLayout journey_detail_ll;
    public int k;

    /* renamed from: k  reason: collision with other field name */
    public String f4989k;

    /* renamed from: k  reason: collision with other field name */
    public ArrayList f4990k;

    /* renamed from: k  reason: collision with other field name */
    public boolean f4991k;

    /* renamed from: l  reason: collision with other field name */
    public String f4992l;

    /* renamed from: l  reason: collision with other field name */
    public ArrayList<String> f4993l;

    /* renamed from: l  reason: collision with other field name */
    public boolean f4994l;
    @BindView(2131362936)
    TextView lap1_ll;
    @BindView(2131362939)
    LinearLayout lap2_heading_ll;
    @BindView(2131362940)
    TextView lap2_rb;
    @BindView(2131363024)
    LinearLayout ll_fare_per_person;
    @BindView(2131363042)
    LinearLayout ll_meal_preference_lap2;
    @BindView(2131363049)
    LinearLayout ll_passport_lap2;
    @BindView(2131363067)
    LinearLayout ll_srctzn_concession_lap2;
    @BindView(2131363100)
    LinearLayout ll_wait_duration_lap1;
    @BindView(2131363125)
    RecyclerView lv_addmeal_lap;
    @BindView(2131363126)
    RecyclerView lv_addmeal_lap2;
    @BindView(2131363124)
    RecyclerView lvaddmeal;

    /* renamed from: m  reason: collision with other field name */
    public String f4995m;

    /* renamed from: m  reason: collision with other field name */
    public ArrayList<String> f4996m;

    /* renamed from: m  reason: collision with other field name */
    public boolean f4997m;
    @BindView(2131364475)
    TextView male;
    @BindView(2131363177)
    RecyclerView masterpassengetList;
    @BindView(2131363041)
    LinearLayout mealPreferenceLayout;
    @BindView(2131362547)
    EditText mobileNumber;

    /* renamed from: n  reason: collision with other field name */
    public String f4998n;

    /* renamed from: n  reason: collision with other field name */
    public ArrayList<String> f4999n;

    /* renamed from: n  reason: collision with other field name */
    public boolean f5000n;
    @BindView(2131363298)
    TextView nationality;
    @BindView(2131363300)
    LinearLayout nationalityLayout;
    @BindView(2131363301)
    RelativeLayout nationalityRl;
    @BindView(2131363328)
    RadioButton noInsuranceOpt;
    @BindView(2131363329)
    RadioButton no_insurance_opt_lap2;
    @BindView(2131363336)
    TextView nonText;
    @BindView(2131363338)
    TextView none_ll;

    /* renamed from: o  reason: collision with other field name */
    public String f5001o;

    /* renamed from: o  reason: collision with other field name */
    public ArrayList<String> f5002o;

    /* renamed from: o  reason: collision with other field name */
    public boolean f5003o;
    @BindView(2131363762)
    TextView onSave;
    @BindView(2131364515)
    TextView oneLowerBerth;
    @BindView(2131363392)
    RecyclerView other_preference;
    @BindView(2131363393)
    RelativeLayout other_preference_bottom_rl;

    /* renamed from: p  reason: collision with other field name */
    public String f5004p;

    /* renamed from: p  reason: collision with other field name */
    public ArrayList<K9> f5005p;

    /* renamed from: p  reason: collision with other field name */
    public boolean f5006p;
    @BindView(2131363440)
    TextView pass_booking_opt_msg;
    @BindView(2131363444)
    TextView passbooking_concession_list;
    @BindView(2131363445)
    LinearLayout passbooking_concession_ll;
    @BindView(2131363446)
    RelativeLayout passbooking_concession_rl;
    @BindView(2131363447)
    LinearLayout passengerAddressHeadingLl;
    @BindView(2131363448)
    LinearLayout passengerAddressInputLl;
    @BindView(2131363449)
    EditText passengerAge;
    @BindView(2131363451)
    AdManagerAdView passengerCenter;
    @BindView(2131363825)
    RecyclerView passengerList;
    @BindView(2131363458)
    EditText passengerName;
    @BindView(2131363452)
    AdManagerAdView passenger_detail_existing;
    @BindView(2131362811)
    EditText passportnumber_ft;
    @BindView(2131363483)
    LinearLayout paymentOptionll;
    @BindView(2131363482)
    RecyclerView paymentoptionView;
    @BindView(2131362570)
    EditText pinCode;
    @BindView(2131363529)
    LinearLayout preference_ll;
    @BindView(2131363530)
    EditText preferredCoach;
    @BindView(2131363531)
    EditText preferred_coach_lap2;
    @BindView(2131363548)
    TextView psgnCount_Class_Quota_lap2;
    @BindView(2131363547)
    TextView psgndetail;
    public String q;

    /* renamed from: q  reason: collision with other field name */
    public ArrayList<String> f5007q;

    /* renamed from: q  reason: collision with other field name */
    public boolean f5008q;
    @BindView(2131364549)
    TextView quota;
    public String r;

    /* renamed from: r  reason: collision with other field name */
    public ArrayList<String> f5009r;

    /* renamed from: r  reason: collision with other field name */
    public boolean f5010r;
    @BindView(2131363587)
    RadioGroup radioInsurance;
    @BindView(2131363588)
    RadioGroup radio_insurance_lap2;
    @BindView(2131363602)
    LinearLayout redemption_msg_ll;
    @BindView(2131363642)
    RelativeLayout regervation_choice_ll_lap2;
    @BindView(2131363641)
    RelativeLayout regervationchoice_ll;
    @BindView(2131364570)
    TextView reservationChoiceClick;
    @BindView(2131363679)
    RelativeLayout reservationChoiceLayout;
    @BindView(2131363680)
    RelativeLayout reservation_choice_rl_lap2;
    @BindView(2131363683)
    TextView reservation_txt_lap2;
    @BindView(2131363685)
    View reservation_view_lap2;
    @BindView(2131363803)
    RecyclerView rv_addmeal_list;
    @BindView(2131363826)
    RecyclerView rv_passenger_list_lap2;
    @BindView(2131363832)
    RecyclerView rv_selectmeal_lap1;
    @BindView(2131363833)
    RecyclerView rv_selectmeal_lap2;

    /* renamed from: s  reason: collision with other field name */
    public String f5011s;

    /* renamed from: s  reason: collision with other field name */
    public ArrayList<String> f5012s;
    @BindView(2131363886)
    RelativeLayout select_berth_choice;
    @BindView(2131363889)
    RelativeLayout select_booking_ll;
    @BindView(2131363904)
    TextView select_meal_lap1;
    @BindView(2131363905)
    TextView select_meal_lap2;
    @BindView(2131363908)
    LinearLayout select_passenger_lap2;
    @BindView(2131363919)
    TextView select_psgn_lap1;
    @BindView(2131363920)
    TextView select_psgn_lap2;
    @BindView(2131363928)
    RelativeLayout selectstation_ll;
    @BindView(2131363985)
    LinearLayout spConcessionLayout;
    @BindView(2131363982)
    EditText spcCardnumber;
    @BindView(2131363983)
    EditText spc_card_number_lap2;
    @BindView(2131363986)
    LinearLayout spc_concession_layout_lap2;
    @BindView(2131363987)
    TextView specialConcesionType;
    @BindView(2131363989)
    RelativeLayout specialConcessionRl;
    @BindView(2131363988)
    TextView special_concession_list_lap2;
    @BindView(2131363990)
    RelativeLayout special_concession_rl_lap2;
    @BindView(2131364348)
    EditText splCardValidity;
    @BindView(2131364350)
    EditText splDOB;
    @BindView(2131364012)
    RelativeLayout srctznConcClick;
    @BindView(2131363066)
    LinearLayout srctznConcLayout;
    @BindView(2131364010)
    TextView srctznConcession;
    @BindView(2131364011)
    TextView srctzn_concession_lap2;
    @BindView(2131364013)
    RelativeLayout srctzn_concession_rl_lap2;
    @BindView(2131362583)
    TextView state;
    @BindView(2131364034)
    EditText streetLane;

    /* renamed from: t  reason: collision with other field name */
    public String f5013t;

    /* renamed from: t  reason: collision with other field name */
    public ArrayList<String> f5014t;
    @BindView(2131364081)
    TextView termcondition;
    @BindView(2131364082)
    TextView termcondition_lap2;
    @BindView(2131364083)
    LinearLayout termcondition_ll;
    @BindView(2131364141)
    TextView ticketSentLevelView;
    @BindView(2131361913)
    TextView titleName;
    @BindView(2131364671)
    TextView toStatinCode;
    @BindView(2131364673)
    TextView toStation;
    @BindView(2131364686)
    TextView trainName;
    @BindView(2131364689)
    TextView trainNumber;
    @BindView(2131364195)
    LinearLayout train_detail_lap2;
    @BindView(2131364205)
    ImageView train_type;
    @BindView(2131364208)
    ImageView train_type_lap2;
    @BindView(2131364209)
    LinearLayout traindetail_ll;
    @BindView(2131364695)
    TextView transGender;
    @BindView(2131364699)
    TextView travelTime;
    @BindView(2131364241)
    LinearLayout travel_insurance_no_ll;
    @BindView(2131364242)
    LinearLayout travel_insurance_no_ll_lap2;
    @BindView(2131364245)
    LinearLayout travel_insurance_yes_ll;
    @BindView(2131364246)
    LinearLayout travel_insurance_yes_ll_lap2;
    @BindView(2131364251)
    TextView travel_waitingtime;
    @BindView(2131364319)
    TextView tvBoardingStation;
    @BindView(2131364268)
    TextView tv_add_brackfast_lap;
    @BindView(2131364270)
    TextView tv_add_dinner_lap;
    @BindView(2131364273)
    TextView tv_add_lunch_lap;
    @BindView(2131364279)
    TextView tv_add_snack_lap;
    @BindView(2131364286)
    TextView tv_all_berth_confirm_lap2;
    @BindView(2131364296)
    TextView tv_arrival_time_lap2;
    @BindView(2131364298)
    TextView tv_arv_date_lap2;
    @BindView(2131364302)
    TextView tv_available_lastupdate;
    @BindView(2131364303)
    TextView tv_available_lastupdate_lap2;
    @BindView(2131364305)
    TextView tv_avl_class_lap;
    @BindView(2131364349)
    EditText tv_conc_cardvalidity_lap2;
    @BindView(2131364351)
    EditText tv_conc_dob_lap2;
    @BindView(2131364361)
    TextView tv_dep_date_lap2;
    @BindView(2131364366)
    TextView tv_departure_time_lap2;
    @BindView(2131364378)
    EditText tv_dob_ft;
    @BindView(2131364383)
    TextView tv_done_meal;
    @BindView(2131364384)
    TextView tv_done_meal_lap;
    @BindView(2131364423)
    TextView tv_from_stationcode_lap2;
    @BindView(2131364425)
    TextView tv_from_stationname_lap2;
    @BindView(2131364454)
    TextView tv_lap;
    @BindView(2131364455)
    TextView tv_lap1heading;
    @BindView(2131364456)
    TextView tv_lap2;
    @BindView(2131364479)
    TextView tv_masterpasscancel;
    @BindView(2131364505)
    TextView tv_none_lap2;
    @BindView(2131364507)
    TextView tv_none_selected_lap2;
    @BindView(2131364516)
    TextView tv_one_lower_berth_lap2;
    @BindView(2131364550)
    TextView tv_quota_lap2;
    @BindView(2131364556)
    TextView tv_redemption_msg;
    @BindView(2131364571)
    TextView tv_reservation_choice_lap2;
    @BindView(2131364591)
    TextView tv_select_booking_choise;
    @BindView(2131364592)
    TextView tv_select_confirm_berth_Choice;
    @BindView(2131364593)
    TextView tv_select_psgn;
    @BindView(2131364672)
    TextView tv_to_stationcode_lap2;
    @BindView(2131364674)
    TextView tv_to_stationname_lap2;
    @BindView(2131364687)
    TextView tv_train_name_lap2;
    @BindView(2131364690)
    TextView tv_train_number_lap2;
    @BindView(2131364700)
    TextView tv_travel_time_lap2;
    @BindView(2131364703)
    TextView tv_two_lower_berth_lap2;
    @BindView(2131364504)
    TextView tvnone;
    @BindView(2131364702)
    TextView twoLowerBerth;

    /* renamed from: u  reason: collision with other field name */
    public final String f5015u;

    /* renamed from: u  reason: collision with other field name */
    public ArrayList<String> f5016u;
    public String v;

    /* renamed from: v  reason: collision with other field name */
    public ArrayList<String> f5017v;
    @BindView(2131364826)
    View view_confirm_berth_choice;
    public String w;

    /* renamed from: w  reason: collision with other field name */
    public ArrayList<String> f5018w;
    public String x;

    /* renamed from: x  reason: collision with other field name */
    public ArrayList<String> f5019x;
    public String y;

    /* renamed from: y  reason: collision with other field name */
    public final ArrayList<String> f5020y;
    public String z;

    /* renamed from: z  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f5021z;

    public class A implements View.OnClickListener {
        public A() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            C0535I5.o(passengerDetailFragment.f4906a, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.name_change), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null);
        }
    }

    public class B implements View.OnClickListener {
        public B() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            C0535I5.o(passengerDetailFragment.f4906a, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.age_change), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null);
        }
    }

    public class C implements View.OnClickListener {
        public C() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            C0535I5.o(passengerDetailFragment.f4906a, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.anationality_change), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null);
        }
    }

    public class D implements View.OnClickListener {
        public D() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            C0535I5.o(passengerDetailFragment.f4906a, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.name_change), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null);
        }
    }

    public class E implements RadioGroup.OnCheckedChangeListener {
        public E() {
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (i == cris.org.in.prs.ima.R.id.insurance_opt_lap2) {
                passengerDetailFragment.f5013t = "true";
                passengerDetailFragment.f4945b.setTravelInsuranceOpted(Boolean.TRUE);
            } else if (i == cris.org.in.prs.ima.R.id.no_insurance_opt_lap2) {
                passengerDetailFragment.f5013t = "false";
                passengerDetailFragment.f4945b.setTravelInsuranceOpted(Boolean.FALSE);
                passengerDetailFragment.termcondition_ll.setVisibility(8);
            }
        }
    }

    public class F implements View.OnClickListener {
        public F() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            C0535I5.o(passengerDetailFragment.f4906a, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.age_change), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null);
        }
    }

    public class G implements View.OnClickListener {
        public G() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            C0535I5.o(passengerDetailFragment.f4906a, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.anationality_change), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null);
        }
    }

    public class H implements OnSelectionListener {
        public H() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.et_city_town.setText(str);
            if (!str.equals("City")) {
                if (!passengerDetailFragment.f4962c.equals(str)) {
                    passengerDetailFragment.f5020y.clear();
                    passengerDetailFragment.et_post_office.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.post_office));
                    PassengerDetailFragment.V(passengerDetailFragment, Boolean.FALSE);
                    passengerDetailFragment.f4967d = str;
                }
                passengerDetailFragment.f4943a = true;
                passengerDetailFragment.et_city_town.setError((CharSequence) null);
            } else {
                passengerDetailFragment.f4943a = false;
                passengerDetailFragment.et_city_town.setError(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Select_City));
            }
            passengerDetailFragment.f4914a.dismiss();
        }
    }

    public class I implements OnSelectionListener {
        public I() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.et_post_office.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            if (!str.equals("Post Office")) {
                passengerDetailFragment.et_post_office.setError((CharSequence) null);
                passengerDetailFragment.f4985i = true;
                passengerDetailFragment.et_city_town.setError((CharSequence) null);
                passengerDetailFragment.f4974f = str;
                return;
            }
            passengerDetailFragment.f4985i = false;
            passengerDetailFragment.et_post_office.setError(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Select_Post_Office));
        }
    }

    public class J implements OnSelectionListener {
        public J() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.idCardType.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            K9 i = K9.i(str);
            K9 k9 = K9.NULL_IDCARD;
            if (k9.f3678c.compareToIgnoreCase(passengerDetailFragment.idCardType.getText().toString()) == 0) {
                passengerDetailFragment.idCardNumber.setVisibility(8);
            } else {
                passengerDetailFragment.idCardNumber.setVisibility(0);
            }
            if (!passengerDetailFragment.C.equals(String.valueOf(i.f3678c))) {
                passengerDetailFragment.C = String.valueOf(i.f3678c);
                EditText editText = (EditText) passengerDetailFragment.f4906a.findViewById(cris.org.in.prs.ima.R.id.id_card_number);
                if (i.f3678c == K9.UNIQUE_ICARD.f3678c) {
                    passengerDetailFragment.idCardNumber.setText((CharSequence) null);
                    TextWatcher textWatcher = passengerDetailFragment.f4905a;
                    if (textWatcher != null) {
                        passengerDetailFragment.idCardNumber.removeTextChangedListener(textWatcher);
                    }
                    FragmentActivity activity = passengerDetailFragment.getActivity();
                    AlertDialog alertDialog = C0535I5.f3619a;
                    C0479D5 d5 = new C0479D5(activity, 12);
                    passengerDetailFragment.f4905a = d5;
                    passengerDetailFragment.idCardNumber.addTextChangedListener(d5);
                    editText.setInputType(2);
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                } else if (k9.f3678c.compareToIgnoreCase(passengerDetailFragment.idCardType.getText().toString()) == 0) {
                    passengerDetailFragment.C = "NC";
                    passengerDetailFragment.idCardNumber.setText((CharSequence) null);
                } else {
                    passengerDetailFragment.idCardNumber.setText((CharSequence) null);
                    TextWatcher textWatcher2 = passengerDetailFragment.f4905a;
                    if (textWatcher2 != null) {
                        passengerDetailFragment.idCardNumber.removeTextChangedListener(textWatcher2);
                    }
                    FragmentActivity activity2 = passengerDetailFragment.getActivity();
                    AlertDialog alertDialog2 = C0535I5.f3619a;
                    C0479D5 d52 = new C0479D5(activity2, 16);
                    passengerDetailFragment.f4905a = d52;
                    passengerDetailFragment.idCardNumber.addTextChangedListener(d52);
                    editText.setInputType(1);
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16), new InputFilter.AllCaps()});
                }
            }
        }
    }

    public class K implements OnSelectionListener {
        public K() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.id_card_types_lap2.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            K9 i = K9.i(str);
            K9 k9 = K9.NULL_IDCARD;
            if (k9.f3678c.compareToIgnoreCase(passengerDetailFragment.id_card_types_lap2.getText().toString()) == 0) {
                passengerDetailFragment.id_card_number_lap2.setVisibility(8);
            } else {
                passengerDetailFragment.id_card_number_lap2.setVisibility(0);
            }
            if (!passengerDetailFragment.D.equals(String.valueOf(i.f3678c))) {
                passengerDetailFragment.D = String.valueOf(i.f3678c);
                EditText editText = (EditText) passengerDetailFragment.f4906a.findViewById(cris.org.in.prs.ima.R.id.id_card_number);
                if (i.f3678c == K9.UNIQUE_ICARD.f3678c) {
                    passengerDetailFragment.id_card_number_lap2.setText((CharSequence) null);
                    TextWatcher textWatcher = passengerDetailFragment.f4905a;
                    if (textWatcher != null) {
                        passengerDetailFragment.id_card_number_lap2.removeTextChangedListener(textWatcher);
                    }
                    FragmentActivity activity = passengerDetailFragment.getActivity();
                    AlertDialog alertDialog = C0535I5.f3619a;
                    C0479D5 d5 = new C0479D5(activity, 12);
                    passengerDetailFragment.f4905a = d5;
                    passengerDetailFragment.id_card_number_lap2.addTextChangedListener(d5);
                    editText.setInputType(2);
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                } else if (k9.f3678c.compareToIgnoreCase(passengerDetailFragment.id_card_types_lap2.getText().toString()) == 0) {
                    passengerDetailFragment.D = "NC";
                    passengerDetailFragment.id_card_number_lap2.setText((CharSequence) null);
                } else {
                    passengerDetailFragment.id_card_number_lap2.setText((CharSequence) null);
                    TextWatcher textWatcher2 = passengerDetailFragment.f4905a;
                    if (textWatcher2 != null) {
                        passengerDetailFragment.id_card_number_lap2.removeTextChangedListener(textWatcher2);
                    }
                    FragmentActivity activity2 = passengerDetailFragment.getActivity();
                    AlertDialog alertDialog2 = C0535I5.f3619a;
                    C0479D5 d52 = new C0479D5(activity2, 16);
                    passengerDetailFragment.f4905a = d52;
                    passengerDetailFragment.id_card_number_lap2.addTextChangedListener(d52);
                    editText.setInputType(1);
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16), new InputFilter.AllCaps()});
                }
            }
        }
    }

    public class L implements OnSelectionListener {
        public L() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4914a.dismiss();
            if (str.equals("Show all")) {
                passengerDetailFragment.nationality.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.select_Nationality));
                passengerDetailFragment.nationality.setError((CharSequence) null);
                passengerDetailFragment.f4903a = ProgressDialog.show(passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.loading), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Loading_Country));
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap.put(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.India), "IN");
                hashMap2.put("IN", passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.India));
                ArrayList arrayList = new ArrayList();
                String f = C0657Qt.f();
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).i1(f + "country").c(C1181iv.a()).a(E0.a()).b(new Mo(passengerDetailFragment, arrayList, hashMap, hashMap2));
                return;
            }
            passengerDetailFragment.g0(str);
        }
    }

    public class M extends ClickableSpan {
        public M() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.tnc_insurance))));
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    public class N implements OnSelectionListener {
        public N() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.foodChoice.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            J9 j = J9.j(str);
            passengerDetailFragment.y = String.valueOf(j.f3664a);
            ArrayList<InformationMessageDTO> informationMessage = passengerDetailFragment.f4929a.getInformationMessage();
            if (informationMessage != null) {
                Iterator<InformationMessageDTO> it = informationMessage.iterator();
                while (it.hasNext()) {
                    InformationMessageDTO next = it.next();
                    if (!next.getParamName().equalsIgnoreCase("NON_VEG_SELECTION") || !j.toString().equals("NON_VEG")) {
                        passengerDetailFragment.nonText.setVisibility(8);
                    } else {
                        String message = next.getMessage();
                        passengerDetailFragment.nonText.setVisibility(0);
                        passengerDetailFragment.nonText.setText(message);
                        return;
                    }
                }
            }
        }
    }

    public class O implements OnSelectionListener {
        public O() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.food_choice_lap2.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            passengerDetailFragment.z = String.valueOf(J9.j(str).f3664a);
        }
    }

    public class P implements OnSelectionListener {
        public P() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4914a.dismiss();
            int i = xx.i(str);
            if (i == 0) {
                passengerDetailFragment.E = str;
            } else {
                passengerDetailFragment.E = xx.p(i);
            }
            if (C1450w1.f7024c || passengerDetailFragment.E.equalsIgnoreCase("HANDICAP")) {
                passengerDetailFragment.specialConcesionType.setText(passengerDetailFragment.E);
            } else {
                passengerDetailFragment.specialConcesionType.setText(str);
            }
            passengerDetailFragment.Y0(true);
        }
    }

    public class Q implements OnSelectionListener {
        public Q() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4914a.dismiss();
            String p = xx.p(xx.i(str));
            passengerDetailFragment.E = p;
            if (C1450w1.f7024c) {
                passengerDetailFragment.special_concession_list_lap2.setText(p);
            } else {
                passengerDetailFragment.special_concession_list_lap2.setText(str);
            }
            if (!(PassengerDetailFragment.f4886a.getConcessionalPassengerType() == null || PassengerDetailFragment.b.getConcessionalPassengerType() == null)) {
                if (passengerDetailFragment.f4928a.d.equals("HP")) {
                    PassengerDetailFragment.P = passengerDetailFragment.f4928a.d;
                } else if (passengerDetailFragment.f4947b.d.equals("HP")) {
                    PassengerDetailFragment.P = passengerDetailFragment.f4947b.d;
                }
                if ((PassengerDetailFragment.S.equals("Y") || PassengerDetailFragment.P.equals("HP")) && PassengerDetailFragment.b.getConcessionalPassengerType() != null && passengerDetailFragment.special_concession_list_lap2.getText().toString().equalsIgnoreCase(passengerDetailFragment.specialConcesionType.getText().toString())) {
                    passengerDetailFragment.spc_card_number_lap2.setText(passengerDetailFragment.spcCardnumber.getText().toString());
                    passengerDetailFragment.tv_conc_dob_lap2.setText(passengerDetailFragment.splDOB.getText().toString());
                    passengerDetailFragment.tv_conc_cardvalidity_lap2.setText(passengerDetailFragment.splCardValidity.getText().toString());
                    passengerDetailFragment.id_card_types_lap2.setText(passengerDetailFragment.idCardType.getText().toString());
                    passengerDetailFragment.id_card_number_lap2.setText(passengerDetailFragment.idCardNumber.getText().toString());
                    passengerDetailFragment.tv_conc_dob_lap2.setEnabled(false);
                    passengerDetailFragment.tv_conc_cardvalidity_lap2.setEnabled(false);
                    passengerDetailFragment.id_card_types_lap2.setEnabled(false);
                    passengerDetailFragment.spc_card_number_lap2.setEnabled(false);
                    passengerDetailFragment.id_card_number_lap2.setEnabled(false);
                    passengerDetailFragment.id_card_types_rl_lap2.setClickable(false);
                    passengerDetailFragment.D = passengerDetailFragment.C;
                }
            }
            passengerDetailFragment.Y0(true);
        }
    }

    public class R implements Runnable {
        public R() {
        }

        public final void run() {
            PassengerDetailFragment.this.f5000n = true;
        }
    }

    public class S implements OnSelectionListener {
        public S() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.srctznConcession.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            int V = xx.V(xx.f(str));
            passengerDetailFragment.g = V;
            if (V == 1) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.avail_conc_msgs), (DialogInterface.OnClickListener) null);
            } else if (V == 2) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.forgo_conce_msgs), (DialogInterface.OnClickListener) null);
            } else if (V == 3) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.forgo_full_conc_msgs), (DialogInterface.OnClickListener) null);
            }
        }
    }

    public class T implements Runnable {
        public T() {
        }

        public final void run() {
            PassengerDetailFragment.this.f5000n = true;
        }
    }

    public class U implements OnSelectionListener {
        public U() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.srctzn_concession_lap2.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            int V = xx.V(xx.f(str));
            passengerDetailFragment.h = V;
            if (V == 1) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.avail_conc_msgs), (DialogInterface.OnClickListener) null);
            } else if (V == 2) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.forgo_conce_msgs), (DialogInterface.OnClickListener) null);
            } else if (V == 3) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.forgo_full_conc_msgs), (DialogInterface.OnClickListener) null);
            }
        }
    }

    public class V implements OnSelectionListener {
        public V() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.passbooking_concession_list.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            if (str.equalsIgnoreCase("General Booking")) {
                passengerDetailFragment.et_pass_booking_code.setVisibility(8);
                passengerDetailFragment.et_pass_upn.setVisibility(8);
                passengerDetailFragment.pass_booking_opt_msg.setVisibility(8);
                return;
            }
            passengerDetailFragment.et_pass_booking_code.setVisibility(0);
            passengerDetailFragment.et_pass_upn.setVisibility(0);
            passengerDetailFragment.pass_booking_opt_msg.setVisibility(0);
        }
    }

    public class W implements OnSelectionListener {
        public W() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.berthPreference.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            I9 i = I9.i(str);
            if (i != null) {
                passengerDetailFragment.A = String.valueOf(i.f3658c);
            } else {
                passengerDetailFragment.A = "NC";
            }
        }
    }

    public class X implements View.OnFocusChangeListener {
        public X() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                EditText editText = PassengerDetailFragment.this.passengerName;
                editText.setText(editText.getText().toString().replaceAll("\\s+", " ").trim());
            }
        }
    }

    public class Y implements OnSelectionListener {
        public Y() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.berth_preference_lap2.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            passengerDetailFragment.B = String.valueOf(I9.i(str).f3658c);
        }
    }

    public class Z implements OnSelectionListener {
        public Z() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.passengerAge.setInputType(0);
            passengerDetailFragment.passengerAge.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            Short.parseShort(str);
            passengerDetailFragment.getClass();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$a  reason: case insensitive filesystem */
    public class C0944a implements View.OnClickListener {

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$a$a  reason: collision with other inner class name */
        public class C0067a implements DatePickerDialog.OnDateSetListener {
            public C0067a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                TextView textView = PassengerDetailFragment.a;
                C0944a aVar = C0944a.this;
                EditText editText = PassengerDetailFragment.this.splDOB;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i4 = i2 + 1;
                if (i4 > 9) {
                    obj2 = Integer.valueOf(i4);
                } else {
                    obj2 = lf.h("0", i4);
                }
                sb.append(obj2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(i);
                editText.setText(sb);
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                passengerDetailFragment.splDOB.getText().toString();
                passengerDetailFragment.splDOB.setError((CharSequence) null);
                passengerDetailFragment.passengerAge.setText(String.valueOf(PassengerDetailFragment.o0(i, i2, i3)));
            }
        }

        public C0944a() {
        }

        public final void onClick(View view) {
            TextView textView = PassengerDetailFragment.a;
            Calendar instance = Calendar.getInstance();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(passengerDetailFragment.getActivity(), new C0067a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance2.add(1, -5);
            instance3.add(1, -143);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
            datePickerDialog.setTitle(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Select_Date_of_Birth));
            datePickerDialog.show();
        }
    }

    public class a0 implements OnSelectionListener {
        public a0() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.childAge.setText(str);
            passengerDetailFragment.f4914a.dismiss();
            if (str.equals("Below 1 Year")) {
                passengerDetailFragment.f4937a = (byte) 0;
            } else {
                passengerDetailFragment.f4937a = Byte.valueOf(Byte.parseByte(str));
            }
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$b  reason: case insensitive filesystem */
    public class C0945b implements View.OnClickListener {

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$b$a */
        public class a implements DatePickerDialog.OnDateSetListener {
            public a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                TextView textView = PassengerDetailFragment.a;
                C0945b bVar = C0945b.this;
                EditText editText = PassengerDetailFragment.this.tv_dob_ft;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i4 = i2 + 1;
                if (i4 > 9) {
                    obj2 = Integer.valueOf(i4);
                } else {
                    obj2 = lf.h("0", i4);
                }
                sb.append(obj2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(i);
                editText.setText(sb);
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                passengerDetailFragment.tv_dob_ft.getText().toString();
                passengerDetailFragment.tv_dob_ft.setError((CharSequence) null);
                passengerDetailFragment.passengerAge.setText(String.valueOf(PassengerDetailFragment.o0(i, i2, i3)));
            }
        }

        public C0945b() {
        }

        public final void onClick(View view) {
            TextView textView = PassengerDetailFragment.a;
            Calendar instance = Calendar.getInstance();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(passengerDetailFragment.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance2.add(1, -5);
            instance3.add(1, -143);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
            datePickerDialog.setTitle(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Select_Date_of_Birth));
            datePickerDialog.show();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$c  reason: case insensitive filesystem */
    public class C0946c implements View.OnClickListener {

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$c$a */
        public class a implements DatePickerDialog.OnDateSetListener {
            public a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                TextView textView = PassengerDetailFragment.a;
                C0946c cVar = C0946c.this;
                EditText editText = PassengerDetailFragment.this.tv_conc_dob_lap2;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i4 = i2 + 1;
                if (i4 > 9) {
                    obj2 = Integer.valueOf(i4);
                } else {
                    obj2 = lf.h("0", i4);
                }
                sb.append(obj2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(i);
                editText.setText(sb);
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                passengerDetailFragment.tv_conc_dob_lap2.getText().toString();
                passengerDetailFragment.tv_conc_dob_lap2.setError((CharSequence) null);
                passengerDetailFragment.passengerAge.setText(String.valueOf(PassengerDetailFragment.o0(i, i2, i3)));
            }
        }

        public C0946c() {
        }

        public final void onClick(View view) {
            TextView textView = PassengerDetailFragment.a;
            Calendar instance = Calendar.getInstance();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(passengerDetailFragment.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance2.add(1, -5);
            instance3.add(1, -143);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
            datePickerDialog.setTitle(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Select_Date_of_Birth));
            datePickerDialog.show();
        }
    }

    public class c0 extends Subscriber<C1426uk> {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ boolean f5022a;

        public c0(boolean z) {
            this.f5022a = z;
        }

        public final void onCompleted() {
            TextView textView = PassengerDetailFragment.a;
            PassengerDetailFragment.this.f4903a.dismiss();
        }

        public final void onError(Throwable th) {
            TextView textView = PassengerDetailFragment.a;
            th.getClass();
            th.getMessage();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.masterpassengetList.setVisibility(8);
            passengerDetailFragment.errorMessage.setVisibility(0);
            passengerDetailFragment.f4903a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C1426uk ukVar = (C1426uk) obj;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (ukVar != null) {
                ObjectMapper h = C0657Qt.h();
                try {
                    String errorMessage = ukVar.getErrorMessage();
                    boolean z = this.f5022a;
                    if (errorMessage == null) {
                        passengerDetailFragment.errorMessage.setVisibility(8);
                        passengerDetailFragment.masterpassengetList.setVisibility(0);
                        h.writeValueAsString(ukVar);
                        Iterator<C1426uk.a> it = ukVar.getPassengerDetailList().iterator();
                        while (it.hasNext()) {
                            MasterPassengerModel masterPassengerModel = new MasterPassengerModel();
                            masterPassengerModel.a = it.next();
                            PassengerDetailFragment.G.add(masterPassengerModel);
                        }
                        ArrayList<MasterPassengerModel> arrayList = PassengerDetailFragment.G;
                        if (arrayList != null && arrayList.size() != 0) {
                            C0535I5.f3632c = PassengerDetailFragment.G;
                            if (z) {
                                passengerDetailFragment.existingpassenger_ll.setVisibility(0);
                                passengerDetailFragment.f4991k = true;
                            } else {
                                passengerDetailFragment.existingpassenger_ll.setVisibility(8);
                                passengerDetailFragment.f4991k = false;
                            }
                            if (passengerDetailFragment.f4991k) {
                                passengerDetailFragment.masterpassengetList.setLayoutManager(new LinearLayoutManager(passengerDetailFragment.getContext()));
                                passengerDetailFragment.masterpassengetList.setAdapter(new MasterPassengerViewHolder(passengerDetailFragment.f4904a, PassengerDetailFragment.G, passengerDetailFragment.f4915a));
                            }
                            passengerDetailFragment.f4903a.dismiss();
                        }
                    } else if (z) {
                        passengerDetailFragment.existingpassenger_ll.setVisibility(8);
                        passengerDetailFragment.masterpassengetList.setVisibility(8);
                        passengerDetailFragment.errorMessage.setVisibility(8);
                    } else {
                        passengerDetailFragment.existingpassenger_ll.setVisibility(0);
                        passengerDetailFragment.masterpassengetList.setVisibility(8);
                        passengerDetailFragment.errorMessage.setVisibility(0);
                        TextView textView = passengerDetailFragment.errorMessage;
                        textView.setText(ukVar.getErrorMessage() + ". Please add passenger in Master List by using menu option \"My Master List\" displayed under \"My Account\".");
                        passengerDetailFragment.f4903a.dismiss();
                    }
                } catch (Exception e) {
                    TextView textView2 = PassengerDetailFragment.a;
                    e.getMessage();
                    passengerDetailFragment.masterpassengetList.setVisibility(8);
                    passengerDetailFragment.errorMessage.setVisibility(0);
                    passengerDetailFragment.errorMessage.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.unble_to_request_try_sometime));
                    passengerDetailFragment.f4903a.dismiss();
                }
            }
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$d  reason: case insensitive filesystem */
    public class C0947d implements View.OnClickListener {

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$d$a */
        public class a implements DatePickerDialog.OnDateSetListener {
            public a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                TextView textView = PassengerDetailFragment.a;
                C0947d dVar = C0947d.this;
                EditText editText = PassengerDetailFragment.this.splCardValidity;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i4 = i2 + 1;
                if (i4 > 9) {
                    obj2 = Integer.valueOf(i4);
                } else {
                    obj2 = lf.h("0", i4);
                }
                sb.append(obj2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(i);
                editText.setText(sb);
                PassengerDetailFragment.this.splCardValidity.getText().toString();
                PassengerDetailFragment.this.splCardValidity.setError((CharSequence) null);
            }
        }

        public C0947d() {
        }

        public final void onClick(View view) {
            TextView textView = PassengerDetailFragment.a;
            Calendar instance = Calendar.getInstance();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(passengerDetailFragment.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar.getInstance();
            instance2.add(1, 120);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(new Date().getTime() - passengerDetailFragment.f4944b);
            datePickerDialog.setTitle(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Select_Expiry_Date));
            datePickerDialog.show();
        }
    }

    public class d0 implements MasterPassengerViewHolder.MasterPsgnHolderListener {
        public d0() {
        }

        public final void onMasterPsgnClick() {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            Toast.makeText(passengerDetailFragment.getContext(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.master_passenger_validation), 1).show();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$e  reason: case insensitive filesystem */
    public class C0948e implements View.OnClickListener {

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$e$a */
        public class a implements DatePickerDialog.OnDateSetListener {
            public a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                TextView textView = PassengerDetailFragment.a;
                C0948e eVar = C0948e.this;
                EditText editText = PassengerDetailFragment.this.tv_conc_cardvalidity_lap2;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i4 = i2 + 1;
                if (i4 > 9) {
                    obj2 = Integer.valueOf(i4);
                } else {
                    obj2 = lf.h("0", i4);
                }
                sb.append(obj2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(i);
                editText.setText(sb);
                PassengerDetailFragment.this.tv_conc_cardvalidity_lap2.getText().toString();
                PassengerDetailFragment.this.tv_conc_cardvalidity_lap2.setError((CharSequence) null);
            }
        }

        public C0948e() {
        }

        public final void onClick(View view) {
            TextView textView = PassengerDetailFragment.a;
            Calendar instance = Calendar.getInstance();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(passengerDetailFragment.getActivity(), new a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar.getInstance();
            instance2.add(1, 120);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(new Date().getTime() - passengerDetailFragment.f4944b);
            datePickerDialog.setTitle(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Select_Expiry_Date));
            datePickerDialog.show();
        }
    }

    public class e0 extends Subscriber<C0812c0> {
        public final /* synthetic */ EditText a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ TextView f5023a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ boolean f5025a;

        public e0(TextView textView, String str, boolean z, EditText editText) {
            this.f5023a = textView;
            this.f5025a = z;
            this.a = editText;
        }

        public final void onCompleted() {
            TextView textView = PassengerDetailFragment.a;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (passengerDetailFragment.f4903a.isShowing()) {
                passengerDetailFragment.f4903a.dismiss();
            }
        }

        public final void onError(Throwable th) {
            TextView textView = PassengerDetailFragment.a;
            th.getClass();
            th.getMessage();
            PassengerDetailFragment.this.f4903a.dismiss();
            Lt.a(false, th);
        }

        public final void onNext(Object obj) {
            C0812c0 c0Var = (C0812c0) obj;
            TextView textView = PassengerDetailFragment.a;
            EditText editText = this.a;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (c0Var != null) {
                c0Var.toString();
                String error = c0Var.getError();
                TextView textView2 = this.f5023a;
                if (error == null) {
                    textView2.setTextColor(Color.parseColor("#000000"));
                    passengerDetailFragment.f0(cris.org.in.prs.ima.R.id.city_reg, "@color/white_90_opa");
                    passengerDetailFragment.f0(cris.org.in.prs.ima.R.id.et_state_reg, "@color/white_90_opa");
                    passengerDetailFragment.f4903a.dismiss();
                    ArrayList<String> arrayList = passengerDetailFragment.f5020y;
                    if (!this.f5025a) {
                        ArrayList<String> arrayList2 = passengerDetailFragment.f4940a;
                        arrayList2.clear();
                        for (int i = 0; i < c0Var.getCityList().size(); i++) {
                            arrayList2.add(c0Var.getCityList().get(i));
                        }
                        passengerDetailFragment.f4971e = c0Var.getState();
                        if (arrayList2.size() == 1) {
                            passengerDetailFragment.et_city_town.setText(arrayList2.get(0));
                            arrayList.clear();
                            passengerDetailFragment.et_post_office.setText("Post Office");
                            PassengerDetailFragment.V(passengerDetailFragment, Boolean.FALSE);
                            passengerDetailFragment.f4967d = arrayList2.get(0);
                            passengerDetailFragment.f4943a = true;
                            passengerDetailFragment.et_city_town.setError((CharSequence) null);
                        } else if (arrayList2.size() > 1) {
                            passengerDetailFragment.onCittownyClick((View) null);
                        }
                    } else {
                        ArrayList<String> arrayList3 = passengerDetailFragment.f4953b;
                        arrayList3.clear();
                        arrayList.clear();
                        for (int i2 = 0; i2 < c0Var.getCityList().size(); i2++) {
                            arrayList3.add(c0Var.getCityList().get(i2));
                        }
                    }
                } else {
                    passengerDetailFragment.getClass();
                    passengerDetailFragment.f4940a.clear();
                    passengerDetailFragment.f5020y.clear();
                    textView2.setText((CharSequence) null);
                    passengerDetailFragment.f0(cris.org.in.prs.ima.R.id.city_reg, "@color/white_10_opa");
                    editText.setError(c0Var.getError());
                    passengerDetailFragment.f4903a.dismiss();
                    C0535I5.m(passengerDetailFragment.getActivity(), true, c0Var.getError(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.error), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else {
                editText.setError("");
            }
            passengerDetailFragment.f4903a.dismiss();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$f  reason: case insensitive filesystem */
    public class C0949f implements View.OnFocusChangeListener {
        public C0949f() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                EditText editText = PassengerDetailFragment.this.childPassengerName;
                editText.setText(editText.getText().toString().replaceAll("\\s+", " ").trim());
            }
        }
    }

    public class f0 implements OnSelectionListener {
        public f0() {
        }

        public final void onClick(String str) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.city.setText(str);
            PassengerDetailFragment.V(passengerDetailFragment, Boolean.TRUE);
            passengerDetailFragment.f4914a.dismiss();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$g  reason: case insensitive filesystem */
    public class C0950g implements PaymentOptionAdapter.PaymentOptionAdapterListener {
        public C0950g() {
        }

        public final void onItemClick(PaymentOptionModel paymentOptionModel) {
            boolean z = paymentOptionModel.f5340a;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (!z) {
                Iterator it = passengerDetailFragment.f4987j.iterator();
                while (it.hasNext()) {
                    ((PaymentOptionModel) it.next()).f5340a = false;
                }
                paymentOptionModel.f5340a = true;
            }
            String str = passengerDetailFragment.M;
            if (str == null || !str.equalsIgnoreCase("accural") || !paymentOptionModel.a.getLabel().equalsIgnoreCase("Pay through BHIM/UPI")) {
                C0709Uj.p(passengerDetailFragment, cris.org.in.prs.ima.R.color.red, passengerDetailFragment.journey_detail_ll);
                passengerDetailFragment.journey_detail_ll.setClickable(true);
                passengerDetailFragment.journey_detail_ll.setEnabled(true);
                passengerDetailFragment.journey_detail.setTextColor(passengerDetailFragment.getResources().getColor(cris.org.in.prs.ima.R.color.white));
                passengerDetailFragment.journey_detail.setClickable(true);
                passengerDetailFragment.journey_detail.setEnabled(true);
            } else {
                C0535I5.o(passengerDetailFragment.f4904a, passengerDetailFragment.getResources().getString(cris.org.in.prs.ima.R.string.accrul_bookint_notallow), "OK", (DialogInterface.OnClickListener) null).show();
                C0709Uj.p(passengerDetailFragment, cris.org.in.prs.ima.R.color.red_light, passengerDetailFragment.journey_detail_ll);
                passengerDetailFragment.journey_detail_ll.setClickable(false);
                passengerDetailFragment.journey_detail_ll.setEnabled(false);
                passengerDetailFragment.journey_detail.setTextColor(passengerDetailFragment.getResources().getColor(cris.org.in.prs.ima.R.color.red_light));
                passengerDetailFragment.journey_detail.setClickable(false);
                passengerDetailFragment.journey_detail.setEnabled(false);
            }
            passengerDetailFragment.v = paymentOptionModel.a.getLabel();
            passengerDetailFragment.w = paymentOptionModel.a.getDesc();
            passengerDetailFragment.f4961c = paymentOptionModel.a.getValue();
            passengerDetailFragment.f4911a.notifyDataSetChanged();
        }
    }

    public class g0 implements DialogInterface.OnClickListener {
        public g0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4900a.setSsQuotaSplitCoach("Y");
            if (C0535I5.f3647h) {
                passengerDetailFragment.f4945b.setSsQuotaSplitCoach("Y");
            }
            passengerDetailFragment.B0();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$h  reason: case insensitive filesystem */
    public class C0951h implements OtherPreferenceLapwiseAdapter.OtherOptionAdapterListener {
        public C0951h() {
        }

        public final void onItemClick(OtherPreferenceModel otherPreferenceModel) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            Iterator it = passengerDetailFragment.f4990k.iterator();
            while (it.hasNext()) {
                OtherPreferenceModel otherPreferenceModel2 = (OtherPreferenceModel) it.next();
                otherPreferenceModel2.f5339a = false;
                if (otherPreferenceModel2.a.getValue() == otherPreferenceModel.a.getValue()) {
                    otherPreferenceModel2.f5339a = true;
                }
            }
            passengerDetailFragment.f4910a.notifyDataSetChanged();
            passengerDetailFragment.other_preference_bottom_rl.setVisibility(8);
            passengerDetailFragment.tv_select_booking_choise.setText(otherPreferenceModel.a.getDesc());
            passengerDetailFragment.f4966d = otherPreferenceModel.a.getValue();
        }
    }

    public class h0 implements DialogInterface.OnClickListener {
        public h0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4900a.setSsQuotaSplitCoach("N");
            if (C0535I5.f3647h) {
                passengerDetailFragment.f4945b.setSsQuotaSplitCoach("N");
            }
            passengerDetailFragment.B0();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$i  reason: case insensitive filesystem */
    public class C0952i implements BoardingStationChangeAdapter.StationListSelectListener {
        public C0952i() {
        }

        public final void onStnClick(WrapperBoardingStationModel wrapperBoardingStationModel) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4982h = true;
            Z2.a aVar = wrapperBoardingStationModel.a;
            passengerDetailFragment.f4901a = aVar;
            passengerDetailFragment.tvBoardingStation.setText(C0535I5.s0(aVar.getStnNameCode()));
            passengerDetailFragment.boardingStnName.setText(wrapperBoardingStationModel.a.getStnNameCode());
            String charSequence = passengerDetailFragment.tvBoardingStation.getText().toString();
            if (charSequence.equals("") || charSequence.contains("(")) {
                String str = passengerDetailFragment.f4983i;
                passengerDetailFragment.f4983i = str.substring(str.indexOf(40) + 1, passengerDetailFragment.f4983i.indexOf(41)).toUpperCase();
            } else {
                passengerDetailFragment.f4983i = charSequence.substring(charSequence.indexOf(45) + 2).toUpperCase();
            }
            passengerDetailFragment.f4933a.setBoardingStation(passengerDetailFragment.f4983i);
            passengerDetailFragment.f4909a.notifyDataSetChanged();
            passengerDetailFragment.boardingStnView.setVisibility(8);
            passengerDetailFragment.selectstation_ll.setVisibility(8);
            passengerDetailFragment.K = wrapperBoardingStationModel.a.getStnNameCode().split("-")[0] + "-(" + wrapperBoardingStationModel.a.getStnNameCode().split("-")[1] + ")-" + wrapperBoardingStationModel.a.getBoardingDate() + "-" + wrapperBoardingStationModel.a.getDepartureTime();
        }
    }

    public class i0 implements View.OnFocusChangeListener {
        public i0() {
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                passengerDetailFragment.e0();
                if (lf.e(passengerDetailFragment.passengerAge) != 0 && C0709Uj.m(passengerDetailFragment.passengerAge) <= PassengerDetailFragment.f4886a.getMaxChildAge() && C0709Uj.m(passengerDetailFragment.passengerAge) >= PassengerDetailFragment.f4886a.getMinPassengerAge() && passengerDetailFragment.f4997m && !PassengerDetailFragment.f4886a.isChildBerthMandatory()) {
                    C0535I5.o(view.getContext(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Full_fare_charged_allotted_for_child), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            }
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$j  reason: case insensitive filesystem */
    public class C0953j implements RadioGroup.OnCheckedChangeListener {
        public C0953j() {
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (i == cris.org.in.prs.ima.R.id.insurance_opt) {
                passengerDetailFragment.f5011s = "true";
                passengerDetailFragment.f4900a.setTravelInsuranceOpted(Boolean.TRUE);
            } else if (i == cris.org.in.prs.ima.R.id.no_insurance_opt) {
                passengerDetailFragment.f5011s = "false";
                passengerDetailFragment.f4900a.setTravelInsuranceOpted(Boolean.FALSE);
                passengerDetailFragment.termcondition_ll.setVisibility(8);
            }
        }
    }

    public class j0 implements DialogInterface.OnClickListener {
        public j0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4900a.setSsQuotaSplitCoach("Y");
            if (C0535I5.f3647h) {
                passengerDetailFragment.f4945b.setSsQuotaSplitCoach("Y");
            }
            passengerDetailFragment.B0();
        }
    }

    public class k0 implements DialogInterface.OnClickListener {
        public k0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4945b.setSsQuotaSplitCoach("N");
            if (C0535I5.f3647h) {
                passengerDetailFragment.f4945b.setSsQuotaSplitCoach("N");
            }
            passengerDetailFragment.B0();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$l  reason: case insensitive filesystem */
    public class C0955l implements Comparator<MealDetails> {
        public final int compare(Object obj, Object obj2) {
            return ((MealDetails) obj).getMealType().compareTo(((MealDetails) obj2).getMealType());
        }
    }

    public class l0 implements DialogInterface.OnClickListener {
        public l0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Boolean bool = Boolean.FALSE;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4960c = bool;
            passengerDetailFragment.B0();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$m  reason: case insensitive filesystem */
    public class C0956m implements Comparator<MealDetails> {
        public final int compare(Object obj, Object obj2) {
            return ((MealDetails) obj).getMealType().compareTo(((MealDetails) obj2).getMealType());
        }
    }

    public class m0 implements Runnable {
        public final /* synthetic */ ProgressDialog a;

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PassengerDetailFragment.X(PassengerDetailFragment.this);
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PassengerDetailFragment.X(PassengerDetailFragment.this);
            }
        }

        public m0(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void run() {
            this.a.dismiss();
            TextView textView = PassengerDetailFragment.a;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            String str = passengerDetailFragment.r;
            if (str == null || str.equals("")) {
                PassengerDetailFragment.X(passengerDetailFragment);
            } else if (PassengerDetailFragment.f4889c.get(0).getUidVerificationPsgnInputFlag() <= 0 || passengerDetailFragment.r.indexOf("Aadhaar") <= -1) {
                C0535I5.p(passengerDetailFragment.getActivity(), false, passengerDetailFragment.r, "Add Passenger", passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.yes), new b(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.no), (DialogInterface.OnClickListener) null).show();
            } else if ((PassengerDetailFragment.f4889c.get(0).getUidVerificationPsgnInputFlag() != 1 || !passengerDetailFragment.f4969d) && PassengerDetailFragment.f4889c.get(0).getUidVerificationPsgnInputFlag() != 2) {
                PassengerDetailFragment.X(passengerDetailFragment);
            } else {
                C0535I5.o(passengerDetailFragment.getActivity(), passengerDetailFragment.r, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.OK), new a()).show();
            }
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$n  reason: case insensitive filesystem */
    public class C0957n implements Comparator<MealDetails> {
        public final int compare(Object obj, Object obj2) {
            return ((MealDetails) obj).getMealType().compareTo(((MealDetails) obj2).getMealType());
        }
    }

    public class n0 implements DialogInterface.OnClickListener {
        public n0() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4933a.setGeneralistChildConfirm(true);
            passengerDetailFragment.C0();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$o  reason: case insensitive filesystem */
    public class C0958o implements Comparator<MealDetails> {
        public final int compare(Object obj, Object obj2) {
            return ((MealDetails) obj).getMealType().compareTo(((MealDetails) obj2).getMealType());
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$p  reason: case insensitive filesystem */
    public class C0959p implements Comparator<MealItemDetails> {
        public final int compare(Object obj, Object obj2) {
            MealItemDetails mealItemDetails = (MealItemDetails) obj;
            MealItemDetails mealItemDetails2 = (MealItemDetails) obj2;
            if (mealItemDetails.getMealTypeId() > mealItemDetails2.getMealTypeId()) {
                return 1;
            }
            if (mealItemDetails.getMealTypeId() < mealItemDetails2.getMealTypeId()) {
                return -1;
            }
            return 0;
        }
    }

    public class p0 implements View.OnClickListener {
        public p0() {
        }

        public final void onClick(View view) {
            boolean isChildBerthMandatory = PassengerDetailFragment.f4886a.isChildBerthMandatory();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (isChildBerthMandatory && passengerDetailFragment.isChildBerthReq.isChecked()) {
                passengerDetailFragment.isChildBerthReq.setChecked(true);
                C0535I5.o(view.getContext(), passengerDetailFragment.getResources().getString(cris.org.in.prs.ima.R.string.mandatory_child_berth), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (passengerDetailFragment.passengerAge.getText() != null && !passengerDetailFragment.passengerAge.getText().toString().trim().equals("")) {
                PassengerDetailFragment.W(passengerDetailFragment, true);
            }
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$q  reason: case insensitive filesystem */
    public class C0960q implements MealDetaillViewHolder.AddMealHolderListener {
        public C0960q() {
        }

        public final void MinClick(MealItemDetails mealItemDetails) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4890A.clear();
            passengerDetailFragment.f4890A.addAll(C0535I5.f3624a);
            passengerDetailFragment.P0();
        }
    }

    public class q0 implements View.OnClickListener {
        public q0() {
        }

        public final void onClick(View view) {
            boolean isChildBerthMandatory = PassengerDetailFragment.b.isChildBerthMandatory();
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (isChildBerthMandatory && passengerDetailFragment.is_childBerth_req_lap2.isChecked()) {
                passengerDetailFragment.is_childBerth_req_lap2.setChecked(true);
                C0535I5.o(view.getContext(), passengerDetailFragment.getResources().getString(cris.org.in.prs.ima.R.string.mandatory_child_berth), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (passengerDetailFragment.passengerAge.getText() != null && !passengerDetailFragment.passengerAge.getText().toString().trim().equals("")) {
                PassengerDetailFragment.f(passengerDetailFragment, true);
            }
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$r  reason: case insensitive filesystem */
    public class C0961r implements Comparator<MealItemDetails> {
        public final int compare(Object obj, Object obj2) {
            MealItemDetails mealItemDetails = (MealItemDetails) obj;
            MealItemDetails mealItemDetails2 = (MealItemDetails) obj2;
            if (mealItemDetails.getMealTypeId() > mealItemDetails2.getMealTypeId()) {
                return 1;
            }
            if (mealItemDetails.getMealTypeId() < mealItemDetails2.getMealTypeId()) {
                return -1;
            }
            return 0;
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$s  reason: case insensitive filesystem */
    public class C0962s implements Lap1MealDetaillViewHolder.AddMealHolderListener {
        public C0962s() {
        }

        public final void MinClick(MealItemDetails mealItemDetails) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4890A.clear();
            passengerDetailFragment.f4890A.addAll(C0535I5.f3624a);
            passengerDetailFragment.P0();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$t  reason: case insensitive filesystem */
    public class C0963t implements Lap2MealDetaillViewHolder.AddMealHolderListener {
        public C0963t() {
        }

        public final void MinClick(MealItemDetails mealItemDetails) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4891B.clear();
            passengerDetailFragment.f4891B.addAll(C0535I5.f3629b);
            passengerDetailFragment.Q0();
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$z  reason: case insensitive filesystem */
    public class C0969z implements AddPassengerViewHolder.AddPassengerHolderListener {

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$z$a */
        public class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ PassengerDetailDTO f5027a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ Integer f5028a;

            public a(PassengerDetailDTO passengerDetailDTO, Integer num) {
                this.f5027a = passengerDetailDTO;
                this.f5028a = num;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PassengerDetailFragment passengerDetailFragment;
                boolean z = C1450w1.f7024c;
                Integer num = this.f5028a;
                PassengerDetailDTO passengerDetailDTO = this.f5027a;
                C0969z zVar = C0969z.this;
                if ((!z || passengerDetailDTO.getPassengerAge() != null) && passengerDetailDTO.getPassengerAge().shortValue() < PassengerDetailFragment.f4889c.get(0).getMinPassengerAge() && (passengerDetailDTO.getChildBerthFlag() == null || !passengerDetailDTO.getChildBerthFlag().booleanValue())) {
                    PassengerDetailFragment.this.f4972e.remove(passengerDetailDTO.getPassengerSerialNumber().shortValue() - 1);
                    int i2 = 0;
                    while (true) {
                        passengerDetailFragment = PassengerDetailFragment.this;
                        if (i2 >= passengerDetailFragment.f4972e.size()) {
                            break;
                        }
                        int i3 = i2 + 1;
                        passengerDetailFragment.f4972e.get(i2).setInfantSerialNumber(Short.valueOf((short) i3));
                        ArrayList<Df> arrayList = passengerDetailFragment.f4972e;
                        arrayList.set(i2, arrayList.get(i2));
                        i2 = i3;
                    }
                    passengerDetailFragment.e--;
                } else {
                    Short passengerSerialNumber = passengerDetailDTO.getPassengerSerialNumber();
                    if (PassengerDetailFragment.f4888b.containsKey(passengerSerialNumber)) {
                        PassengerDetailFragment.f4888b.remove(passengerSerialNumber);
                        PassengerDetailFragment.f4888b.put((short) 100, Short.valueOf((short) (PassengerDetailFragment.f4888b.get((short) 100).shortValue() - 1)));
                    }
                    PassengerDetailFragment.this.f4963c.remove(passengerSerialNumber.shortValue() - 1);
                    boolean z2 = C0535I5.f3647h;
                    PassengerDetailFragment passengerDetailFragment2 = PassengerDetailFragment.this;
                    if (z2) {
                        passengerDetailFragment2.f4968d.remove(passengerSerialNumber.shortValue() - 1);
                    }
                    int size = passengerDetailFragment2.f4963c.size();
                    int i4 = 0;
                    while (i4 < size) {
                        int i5 = i4 + 1;
                        short s = (short) i5;
                        passengerDetailFragment2.f4963c.get(i4).setPassengerSerialNumber(Short.valueOf(s));
                        ArrayList<PassengerDetailDTO> arrayList2 = passengerDetailFragment2.f4963c;
                        arrayList2.set(i4, arrayList2.get(i4));
                        if (C0535I5.f3647h) {
                            passengerDetailFragment2.f4968d.get(i4).setPassengerSerialNumber(Short.valueOf(s));
                            ArrayList<PassengerDetailDTO> arrayList3 = passengerDetailFragment2.f4968d;
                            arrayList3.set(i4, arrayList3.get(i4));
                        }
                        if (passengerSerialNumber.shortValue() < i5 && PassengerDetailFragment.f4888b.containsKey(Short.valueOf(s))) {
                            PassengerDetailFragment.f4888b.put(Short.valueOf((short) i4), PassengerDetailFragment.f4888b.get(Short.valueOf(s)));
                            PassengerDetailFragment.f4888b.remove(Short.valueOf(s));
                        }
                        i4 = i5;
                    }
                    short s2 = (short) (size + 1);
                    if (PassengerDetailFragment.f4888b.containsKey(Short.valueOf(s2))) {
                        PassengerDetailFragment.f4888b.put(Short.valueOf((short) size), PassengerDetailFragment.f4888b.get(Short.valueOf(s2)));
                        PassengerDetailFragment.f4888b.remove(Short.valueOf(s2));
                    }
                    PassengerDetailFragment.l--;
                    HashMap<String, ArrayList<String>> hashMap = C0535I5.f3637d;
                    if (hashMap != null && hashMap.containsKey(Integer.valueOf(PassengerDetailFragment.l + 1))) {
                        C0535I5.f3637d.remove(Integer.valueOf(PassengerDetailFragment.l + 1));
                    }
                    passengerDetailFragment2.f4894E.remove(passengerDetailDTO.getMpID());
                    passengerDetailFragment2.f4895F.remove(passengerDetailDTO.getMpID());
                    Iterator<MasterPassengerModel> it = PassengerDetailFragment.G.iterator();
                    while (it.hasNext()) {
                        MasterPassengerModel next = it.next();
                        if (passengerDetailFragment2.f4978g.get(num.intValue()).getMpID() != null && passengerDetailFragment2.f4978g.get(num.intValue()).getMpID().equals(next.a.getMasterListId())) {
                            next.f5338a = false;
                        }
                    }
                }
                if (PassengerDetailFragment.l == 0) {
                    PassengerDetailFragment passengerDetailFragment3 = PassengerDetailFragment.this;
                    if (passengerDetailFragment3.e == 0) {
                        passengerDetailFragment3.passengerCenter.setVisibility(0);
                        PassengerDetailFragment passengerDetailFragment4 = PassengerDetailFragment.this;
                        passengerDetailFragment4.passengerList.setVisibility(8);
                        passengerDetailFragment4.select_psgn_lap1.setVisibility(8);
                        if (C0535I5.f3647h) {
                            passengerDetailFragment4.rv_passenger_list_lap2.setVisibility(8);
                            passengerDetailFragment4.select_passenger_lap2.setVisibility(8);
                        }
                    }
                }
                RecyclerView recyclerView = PassengerDetailFragment.this.masterpassengetList;
                PassengerDetailFragment passengerDetailFragment5 = PassengerDetailFragment.this;
                if (!(recyclerView == null || recyclerView.getAdapter() == null)) {
                    passengerDetailFragment5.masterpassengetList.getAdapter().notifyDataSetChanged();
                }
                passengerDetailFragment5.f4978g.remove(num.intValue());
                ArrayList<PassengerDetailDTO> arrayList4 = passengerDetailFragment5.f4978g;
                PassengerDetailFragment.b1(arrayList4);
                passengerDetailFragment5.f4978g = arrayList4;
                if (C0535I5.f3647h) {
                    passengerDetailFragment5.f4981h.remove(num.intValue());
                    ArrayList<PassengerDetailDTO> arrayList5 = passengerDetailFragment5.f4981h;
                    PassengerDetailFragment.b1(arrayList5);
                    passengerDetailFragment5.f4981h = arrayList5;
                    passengerDetailFragment5.rv_passenger_list_lap2.getAdapter().notifyDataSetChanged();
                }
                passengerDetailFragment5.passengerList.getAdapter().notifyDataSetChanged();
            }
        }

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$z$b */
        public class b implements Runnable {
            public b() {
            }

            public final void run() {
                PassengerDetailFragment.this.f4973e = false;
            }
        }

        public C0969z() {
        }

        public final void onDeleteClick(PassengerDetailDTO passengerDetailDTO, Integer num) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            try {
                if (!passengerDetailFragment.f4973e) {
                    passengerDetailFragment.f4973e = true;
                    FragmentActivity activity = passengerDetailFragment.getActivity();
                    C0535I5.p(activity, false, "Do you want to remove " + passengerDetailDTO.getPassengerName() + " from passenger list?", "Delete Passenger", passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.yes), new a(passengerDetailDTO, num), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.no), (DialogInterface.OnClickListener) null).show();
                    C0816cB cBVar = new C0816cB(new b(), 2000);
                    passengerDetailFragment.getClass();
                    cBVar.a();
                }
            } catch (Exception e) {
                TextView textView = PassengerDetailFragment.a;
                e.getMessage();
            }
        }

        public final void onEditClick(PassengerDetailDTO passengerDetailDTO, Integer num, String str) {
            int i;
            int i2;
            I9 i9;
            boolean z;
            int i3;
            I9 i92;
            boolean z2;
            int i4;
            int i5;
            String str2;
            String str3;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            passengerDetailFragment.f4938a = num;
            passengerDetailFragment.f4994l = true;
            passengerDetailFragment.f4930a = (PassengerDetailDTO) passengerDetailFragment.f4978g.get(num.intValue());
            if (passengerDetailFragment.f4981h != null && !passengerDetailFragment.f4981h.isEmpty()) {
                passengerDetailFragment.f4949b = (PassengerDetailDTO) passengerDetailFragment.f4981h.get(num.intValue());
            }
            int i6 = 0;
            if ((!C1450w1.e() || passengerDetailDTO.getPassengerAge() != null) && passengerDetailDTO.getPassengerAge().shortValue() < ((C0794b3) PassengerDetailFragment.f4889c.get(0)).getMinPassengerAge() && (passengerDetailDTO.getChildBerthFlag() == null || !passengerDetailDTO.getChildBerthFlag().booleanValue())) {
                passengerDetailFragment.infantLayout.setVisibility(0);
                passengerDetailFragment.addpassenger_rl.setVisibility(8);
                passengerDetailFragment.infantTitle.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.EDIT_INFANT));
                passengerDetailFragment.passengerName.setText(passengerDetailFragment.f4930a.getPassengerName());
                passengerDetailFragment.f5018w = new ArrayList();
                passengerDetailFragment.f5018w.add(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Below_1_Year));
                for (int i7 = 1; i7 < PassengerDetailFragment.f4886a.getMinPassengerAge(); i7++) {
                    passengerDetailFragment.f5018w.add(String.valueOf(i7));
                }
                if (passengerDetailFragment.f4930a.getPassengerAge().toString().equals("0")) {
                    passengerDetailFragment.childAge.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Below_1_Year));
                    passengerDetailFragment.f4937a = (byte) 0;
                } else {
                    passengerDetailFragment.childAge.setText(passengerDetailFragment.f4930a.getPassengerAge().toString());
                    passengerDetailFragment.f4937a = Byte.valueOf(passengerDetailFragment.f4930a.getPassengerAge().byteValue());
                }
                if (passengerDetailFragment.f4930a.getPassengerGender().equals("M")) {
                    passengerDetailFragment.childMale.performClick();
                } else if (passengerDetailFragment.f4930a.getPassengerGender().equals("F")) {
                    passengerDetailFragment.childfeMale.performClick();
                } else if (passengerDetailFragment.f4930a.getPassengerGender().equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                    passengerDetailFragment.childTrangender.performClick();
                }
                passengerDetailFragment.onSave.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Done));
                passengerDetailFragment.h0();
                return;
            }
            if (passengerDetailDTO.getPassengerAge().shortValue() >= ((C0794b3) PassengerDetailFragment.f4889c.get(0)).getMinPassengerAge()) {
                passengerDetailFragment.titleName.setText(passengerDetailFragment.getResources().getString(cris.org.in.prs.ima.R.string.edit_passenger));
                PassengerDetailFragment.s = false;
            } else if (passengerDetailDTO.getPassengerAge().shortValue() < ((C0794b3) PassengerDetailFragment.f4889c.get(0)).getMinPassengerAge()) {
                passengerDetailFragment.titleName.setText(passengerDetailFragment.getResources().getString(cris.org.in.prs.ima.R.string.edit_infant_passenger));
                PassengerDetailFragment.s = true;
                passengerDetailFragment.f5018w = new ArrayList();
                for (int i8 = 1; i8 < PassengerDetailFragment.f4886a.getMinPassengerAge(); i8++) {
                    passengerDetailFragment.f5018w.add(String.valueOf(i8));
                }
            }
            passengerDetailFragment.addpassenger_rl.setVisibility(0);
            passengerDetailFragment.infantLayout.setVisibility(8);
            passengerDetailFragment.donePsgnDetail.setText(passengerDetailFragment.getResources().getString(cris.org.in.prs.ima.R.string.Done));
            passengerDetailFragment.spcCardnumber.setText(passengerDetailDTO.getPsgnConcCardId());
            if (passengerDetailDTO.getPsgnConcCardExpiryDate() != null) {
                try {
                    passengerDetailFragment.splCardValidity.setText(passengerDetailDTO.getPsgnConcCardExpiryDate());
                } catch (Exception e) {
                    TextView textView = PassengerDetailFragment.a;
                    e.getMessage();
                }
            }
            passengerDetailFragment.splDOB.setText(passengerDetailDTO.getPsgnConcDOB());
            passengerDetailFragment.specialConcesionType.setText(passengerDetailDTO.getPsgnConcType());
            passengerDetailFragment.idCardType.setText(passengerDetailDTO.getPassengerCardType());
            passengerDetailFragment.passengerName.setText(passengerDetailDTO.getPassengerName());
            if (passengerDetailDTO.getPassengerAge() != null) {
                passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailDTO.getPassengerAge()));
            }
            passengerDetailFragment.idCardNumber.setText(passengerDetailDTO.getPassengerCardNumber());
            passengerDetailFragment.splDOB.addTextChangedListener(passengerDetailFragment.f4925a);
            passengerDetailFragment.x = passengerDetailDTO.getPassengerNationality();
            if (!PassengerDetailFragment.S.equals("S") || passengerDetailDTO.getPassUPN() == null) {
                passengerDetailFragment.passbooking_concession_list.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.General_Booking));
                passengerDetailFragment.et_pass_booking_code.setVisibility(8);
                passengerDetailFragment.et_pass_upn.setVisibility(8);
                passengerDetailFragment.pass_booking_opt_msg.setVisibility(8);
            } else {
                passengerDetailFragment.passbooking_concession_list.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Pass_Booking));
                passengerDetailFragment.et_pass_booking_code.setVisibility(0);
                passengerDetailFragment.et_pass_upn.setVisibility(0);
                if (passengerDetailDTO.getPassUPN().toString().contains("0")) {
                    passengerDetailFragment.et_pass_upn.setText("");
                } else {
                    passengerDetailFragment.et_pass_upn.setText(passengerDetailDTO.getPassUPN().toString());
                }
                passengerDetailFragment.et_pass_booking_code.setText(passengerDetailDTO.getPassBookingCode());
                passengerDetailFragment.pass_booking_opt_msg.setVisibility(0);
            }
            passengerDetailFragment.E = "";
            passengerDetailFragment.getClass();
            if (passengerDetailDTO.getPassengerGender().equals("M")) {
                passengerDetailFragment.F = "M";
                passengerDetailFragment.male.performClick();
            } else if (passengerDetailDTO.getPassengerGender().equals("F")) {
                passengerDetailFragment.F = "F";
                passengerDetailFragment.feMale.performClick();
            } else if (passengerDetailDTO.getPassengerGender().equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                passengerDetailFragment.F = RequestConfiguration.MAX_AD_CONTENT_RATING_T;
                passengerDetailFragment.transGender.performClick();
            }
            boolean z3 = C0535I5.f3647h;
            if (z3) {
                if (z3) {
                    passengerDetailFragment.spc_card_number_lap2.setText(passengerDetailFragment.f4949b.getPsgnConcCardId());
                }
                if (passengerDetailFragment.f4949b.getPsgnConcCardExpiryDate() != null) {
                    try {
                        passengerDetailFragment.tv_conc_cardvalidity_lap2.setText(passengerDetailFragment.f4949b.getPsgnConcCardExpiryDate());
                    } catch (Exception e2) {
                        TextView textView2 = PassengerDetailFragment.a;
                        e2.getMessage();
                    }
                }
                passengerDetailFragment.tv_conc_dob_lap2.setText(passengerDetailFragment.f4949b.getPsgnConcDOB());
                passengerDetailFragment.special_concession_list_lap2.setText(passengerDetailFragment.f4949b.getPsgnConcType());
                passengerDetailFragment.id_card_types_lap2.setText(passengerDetailFragment.f4949b.getPassengerCardType());
                passengerDetailFragment.id_card_number_lap2.setText(passengerDetailDTO.getPassengerCardNumber());
                passengerDetailFragment.tv_conc_dob_lap2.addTextChangedListener(passengerDetailFragment.f4926a);
            }
            if (passengerDetailFragment.f4994l) {
                if (passengerDetailFragment.f4930a.getVerificationStatusString() == null || passengerDetailFragment.f4930a.getVerificationStatusString().trim().equals("") || !passengerDetailFragment.f4930a.getVerificationStatusString().trim().equalsIgnoreCase("Verified")) {
                    passengerDetailFragment.passengerName.setEnabled(true);
                    passengerDetailFragment.passengerAge.setEnabled(true);
                    passengerDetailFragment.male.setEnabled(true);
                    passengerDetailFragment.feMale.setEnabled(true);
                    passengerDetailFragment.transGender.setEnabled(true);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, passengerDetailFragment.passengerName);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, passengerDetailFragment.passengerAge);
                } else {
                    passengerDetailFragment.passengerName.setEnabled(false);
                    passengerDetailFragment.passengerAge.setEnabled(false);
                    passengerDetailFragment.male.setEnabled(false);
                    passengerDetailFragment.feMale.setEnabled(false);
                    passengerDetailFragment.transGender.setEnabled(false);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.color.light_gray, passengerDetailFragment.passengerName);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.color.light_gray, passengerDetailFragment.passengerAge);
                }
                if (passengerDetailFragment.M == null || ((!passengerDetailFragment.M.equals("redemption") && !passengerDetailFragment.M.equals("accural")) || passengerDetailDTO.getSoftMemberId() == null)) {
                    passengerDetailFragment.passengerName.setEnabled(true);
                    passengerDetailFragment.passengerAge.setEnabled(true);
                    passengerDetailFragment.male.setEnabled(true);
                    passengerDetailFragment.feMale.setEnabled(true);
                    passengerDetailFragment.transGender.setEnabled(true);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, passengerDetailFragment.passengerName);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, passengerDetailFragment.passengerAge);
                } else {
                    passengerDetailFragment.passengerName.setEnabled(false);
                    passengerDetailFragment.passengerAge.setEnabled(false);
                    passengerDetailFragment.male.setEnabled(false);
                    passengerDetailFragment.feMale.setEnabled(false);
                    passengerDetailFragment.transGender.setEnabled(false);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.color.light_gray, passengerDetailFragment.passengerName);
                    lf.r(passengerDetailFragment.f4904a, cris.org.in.prs.ima.R.color.light_gray, passengerDetailFragment.passengerAge);
                }
            }
            if (passengerDetailFragment.f4994l) {
                ArrayList<String> concessionalPassengerType = PassengerDetailFragment.f4886a.getConcessionalPassengerType();
                K9 k9 = K9.UNIQUE_ICARD;
                if (!(concessionalPassengerType == null || passengerDetailFragment.f4930a.getPsgnConcType() == null || !passengerDetailFragment.f4930a.getPsgnConcType().trim().equals("ESCORT"))) {
                    if (passengerDetailFragment.f4930a.getPassengerCardType() != null && !passengerDetailFragment.f4930a.getPassengerCardType().trim().equals("")) {
                        try {
                            String unused = passengerDetailFragment.C;
                            String str4 = passengerDetailFragment.f4930a.getPassengerCardType().toString();
                            K9[] values = K9.values();
                            int length = values.length;
                            while (true) {
                                if (i6 >= length) {
                                    str3 = "";
                                    break;
                                }
                                K9 k92 = values[i6];
                                if (k92.f3678c.equalsIgnoreCase(str4)) {
                                    str3 = k92.f3678c;
                                    break;
                                }
                                i6++;
                            }
                            passengerDetailFragment.C = str3;
                            passengerDetailFragment.idCardType.setText(passengerDetailFragment.C);
                            K9 i10 = K9.i(passengerDetailFragment.C);
                            EditText editText = (EditText) passengerDetailFragment.f4906a.findViewById(cris.org.in.prs.ima.R.id.id_card_number);
                            if (i10.f() == k9.f()) {
                                if (passengerDetailFragment.f4905a != null) {
                                    passengerDetailFragment.idCardNumber.removeTextChangedListener(passengerDetailFragment.f4905a);
                                }
                                passengerDetailFragment.f4905a = C0535I5.G(passengerDetailFragment.getActivity(), 12);
                                passengerDetailFragment.idCardNumber.addTextChangedListener(passengerDetailFragment.f4905a);
                                editText.setInputType(2);
                                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                            } else {
                                if (passengerDetailFragment.f4905a != null) {
                                    passengerDetailFragment.idCardNumber.removeTextChangedListener(passengerDetailFragment.f4905a);
                                }
                                passengerDetailFragment.f4905a = C0535I5.G(passengerDetailFragment.getActivity(), 16);
                                passengerDetailFragment.idCardNumber.addTextChangedListener(passengerDetailFragment.f4905a);
                                editText.setInputType(1);
                                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16), new InputFilter.AllCaps()});
                            }
                        } catch (Exception e3) {
                            TextView textView3 = PassengerDetailFragment.a;
                            e3.getMessage();
                        }
                    }
                    passengerDetailFragment.idCardType.setVisibility(0);
                    passengerDetailFragment.cardIDLayout.setVisibility(0);
                }
                if (C0535I5.f3647h && PassengerDetailFragment.b.getConcessionalPassengerType() != null && passengerDetailFragment.f4949b.getPsgnConcType() != null && passengerDetailFragment.f4949b.getPsgnConcType().trim().equals("ESCORT")) {
                    if (passengerDetailFragment.f4949b.getPassengerCardType() != null && !passengerDetailFragment.f4949b.getPassengerCardType().trim().equals("")) {
                        try {
                            String unused2 = passengerDetailFragment.C;
                            if (C0535I5.f3647h) {
                                String str5 = passengerDetailFragment.f4949b.getPassengerCardType().toString();
                                K9[] values2 = K9.values();
                                int length2 = values2.length;
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= length2) {
                                        str2 = "";
                                        break;
                                    }
                                    K9 k93 = values2[i11];
                                    if (k93.f3678c.equalsIgnoreCase(str5)) {
                                        str2 = k93.f3678c;
                                        break;
                                    }
                                    i11++;
                                }
                                passengerDetailFragment.D = str2;
                                passengerDetailFragment.id_card_types_lap2.setText(passengerDetailFragment.D);
                            }
                            K9 i12 = K9.i(passengerDetailFragment.D);
                            EditText editText2 = (EditText) passengerDetailFragment.f4906a.findViewById(cris.org.in.prs.ima.R.id.id_card_number_lap2);
                            if (i12.f() == k9.f()) {
                                if (passengerDetailFragment.f4905a != null && C0535I5.f3647h) {
                                    passengerDetailFragment.id_card_number_lap2.removeTextChangedListener(passengerDetailFragment.f4905a);
                                }
                                passengerDetailFragment.f4905a = C0535I5.G(passengerDetailFragment.getActivity(), 12);
                                passengerDetailFragment.idCardNumber.addTextChangedListener(passengerDetailFragment.f4905a);
                                if (C0535I5.f3647h) {
                                    passengerDetailFragment.id_card_number_lap2.addTextChangedListener(passengerDetailFragment.f4905a);
                                }
                                editText2.setInputType(2);
                                editText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                            } else {
                                if (passengerDetailFragment.f4905a != null && C0535I5.f3647h) {
                                    passengerDetailFragment.id_card_number_lap2.removeTextChangedListener(passengerDetailFragment.f4905a);
                                }
                                passengerDetailFragment.f4905a = C0535I5.G(passengerDetailFragment.getActivity(), 16);
                                if (C0535I5.f3647h) {
                                    passengerDetailFragment.id_card_number_lap2.addTextChangedListener(passengerDetailFragment.f4905a);
                                }
                                editText2.setInputType(1);
                                editText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16), new InputFilter.AllCaps()});
                            }
                        } catch (Exception e4) {
                            TextView textView4 = PassengerDetailFragment.a;
                            e4.getMessage();
                        }
                    }
                    if (C0535I5.f3647h) {
                        passengerDetailFragment.id_card_types_lap2.setVisibility(0);
                        passengerDetailFragment.ll_passport_lap2.setVisibility(0);
                    }
                }
            }
            if (passengerDetailFragment.f4994l) {
                if (passengerDetailFragment.f4930a.getChildBerthFlag() == null || !passengerDetailFragment.f4930a.getChildBerthFlag().booleanValue() || passengerDetailFragment.f4930a.getPassengerAge().shortValue() < PassengerDetailFragment.f4886a.getMinPassengerAge()) {
                    i2 = 0;
                } else {
                    i2 = 0;
                    passengerDetailFragment.isChildBerthll.setVisibility(0);
                }
                passengerDetailFragment.berthPreferenceLayout.setVisibility(i2);
                if (passengerDetailFragment.f4930a.getPassengerBerthChoice() != null) {
                    i9 = I9.j(passengerDetailFragment.f4930a.getPassengerBerthChoice());
                } else {
                    i9 = I9.j("NC");
                }
                passengerDetailFragment.berthPreference.setText(i9.a());
                passengerDetailFragment.A = i9.f();
                if (passengerDetailFragment.isChildBerthReq.isChecked() || (passengerDetailFragment.f4930a.getChildBerthFlag() != null && passengerDetailFragment.f4930a.getChildBerthFlag().booleanValue())) {
                    z = false;
                    passengerDetailFragment.isChildBerthReq.setChecked(true);
                } else {
                    z = false;
                    passengerDetailFragment.isChildBerthReq.setChecked(false);
                }
                if (passengerDetailFragment.f4930a.getPassengerAge() != null) {
                    PassengerDetailFragment.W(passengerDetailFragment, z);
                }
                if (PassengerDetailFragment.f4886a.isChildBerthMandatory()) {
                    if (!passengerDetailFragment.f4994l) {
                        i5 = 0;
                        passengerDetailFragment.isChildBerthReq.setChecked(true);
                    } else if (passengerDetailFragment.isChildBerthReq.isChecked() || (passengerDetailFragment.f4930a.getChildBerthFlag() != null && passengerDetailFragment.f4930a.getChildBerthFlag().booleanValue())) {
                        i5 = 0;
                        passengerDetailFragment.isChildBerthReq.setChecked(true);
                    } else {
                        i5 = 0;
                        passengerDetailFragment.isChildBerthReq.setChecked(false);
                    }
                    passengerDetailFragment.berthPreference.setVisibility(i5);
                }
                if (C0535I5.f3647h) {
                    if (passengerDetailFragment.f4949b.getChildBerthFlag() == null || !passengerDetailFragment.f4949b.getChildBerthFlag().booleanValue()) {
                        i3 = 0;
                    } else {
                        i3 = 0;
                        passengerDetailFragment.is_childBerth_ll_lap2.setVisibility(0);
                    }
                    passengerDetailFragment.berth_choice_ll_lap2.setVisibility(i3);
                    if (passengerDetailFragment.f4949b.getPassengerBerthChoice() != null) {
                        i92 = I9.j(passengerDetailFragment.f4949b.getPassengerBerthChoice());
                    } else {
                        i92 = I9.j("NC");
                    }
                    passengerDetailFragment.berth_preference_lap2.setText(i92.a());
                    passengerDetailFragment.B = i92.f();
                    if (passengerDetailFragment.is_childBerth_req_lap2.isChecked() || (passengerDetailFragment.f4949b.getChildBerthFlag() != null && passengerDetailFragment.f4949b.getChildBerthFlag().booleanValue())) {
                        z2 = false;
                        passengerDetailFragment.is_childBerth_req_lap2.setChecked(true);
                    } else {
                        z2 = false;
                        passengerDetailFragment.is_childBerth_req_lap2.setChecked(false);
                    }
                    if (passengerDetailFragment.f4949b.getPassengerAge() != null) {
                        PassengerDetailFragment.f(passengerDetailFragment, z2);
                    }
                    if (PassengerDetailFragment.b.isChildBerthMandatory()) {
                        if (!passengerDetailFragment.f4994l) {
                            i4 = 0;
                            passengerDetailFragment.is_childBerth_req_lap2.setChecked(true);
                        } else if (passengerDetailFragment.is_childBerth_req_lap2.isChecked() || (passengerDetailFragment.f4949b.getChildBerthFlag() != null && passengerDetailFragment.f4949b.getChildBerthFlag().booleanValue())) {
                            i4 = 0;
                            passengerDetailFragment.is_childBerth_req_lap2.setChecked(true);
                        } else {
                            i4 = 0;
                            passengerDetailFragment.is_childBerth_req_lap2.setChecked(false);
                        }
                        passengerDetailFragment.berth_preference_lap2.setVisibility(i4);
                    }
                }
            }
            if (passengerDetailFragment.f4994l) {
                if (passengerDetailFragment.f4930a.getPsgnConcType() == null || PassengerDetailFragment.f4886a.getConcessionalPassengerType() == null || (!passengerDetailFragment.f4930a.getPsgnConcType().equalsIgnoreCase("MPPASS") && !passengerDetailFragment.f4930a.getPsgnConcType().equalsIgnoreCase("MPSPOS") && !passengerDetailFragment.f4930a.getPsgnConcType().equalsIgnoreCase("HANDICAP"))) {
                    passengerDetailFragment.specialConcesionType.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Concession_Option));
                } else {
                    Locale locale = Locale.ENGLISH;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", locale);
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy", locale);
                    try {
                        if (passengerDetailFragment.f4930a.getPsgnConcDOB() != null) {
                            passengerDetailFragment.splDOB.setText(simpleDateFormat2.format(simpleDateFormat.parse(passengerDetailFragment.f4930a.getPsgnConcDOB())));
                        } else {
                            passengerDetailFragment.splDOB.setText("");
                        }
                        passengerDetailFragment.splCardValidity.setText(simpleDateFormat2.format(simpleDateFormat.parse(passengerDetailFragment.f4930a.getPsgnConcCardExpiryDate())));
                    } catch (ParseException e5) {
                        TextView textView5 = PassengerDetailFragment.a;
                        e5.getMessage();
                    } catch (Exception e6) {
                        TextView textView6 = PassengerDetailFragment.a;
                        e6.getMessage();
                    }
                    int g = xx.g(passengerDetailFragment.f4930a.getPsgnConcType());
                    if (C1450w1.e()) {
                        if (g != 0) {
                            if (passengerDetailFragment.f4930a.getPsgnConcType().equalsIgnoreCase("MPPASS")) {
                                passengerDetailFragment.specialConcesionType.setEnabled(false);
                                passengerDetailFragment.specialConcesionType.setText(xx.c(g));
                            } else {
                                passengerDetailFragment.specialConcesionType.setEnabled(false);
                                passengerDetailFragment.specialConcesionType.setText(xx.b(g));
                            }
                        }
                    } else if (g != 0) {
                        passengerDetailFragment.specialConcesionType.setText(xx.b(g));
                    }
                    passengerDetailFragment.E = String.valueOf(passengerDetailFragment.f4930a.getPsgnConcType());
                    passengerDetailFragment.spcCardnumber.setText(passengerDetailFragment.f4930a.getPsgnConcCardId());
                }
                if (C0535I5.f3647h) {
                    if (passengerDetailFragment.f4949b.getPsgnConcType() != null) {
                        Locale locale2 = Locale.ENGLISH;
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd", locale2);
                        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("dd/MM/yyyy", locale2);
                        try {
                            if (passengerDetailFragment.f4949b.getPsgnConcDOB() != null) {
                                if (C0535I5.f3647h) {
                                    passengerDetailFragment.tv_conc_dob_lap2.setText(simpleDateFormat4.format(simpleDateFormat3.parse(passengerDetailFragment.f4949b.getPsgnConcDOB())));
                                }
                            } else if (C0535I5.f3647h) {
                                passengerDetailFragment.tv_conc_dob_lap2.setText("");
                            }
                            if (C0535I5.f3647h) {
                                passengerDetailFragment.tv_conc_cardvalidity_lap2.setText(simpleDateFormat4.format(simpleDateFormat3.parse(passengerDetailFragment.f4949b.getPsgnConcCardExpiryDate())));
                            }
                        } catch (ParseException e7) {
                            TextView textView7 = PassengerDetailFragment.a;
                            e7.getMessage();
                        } catch (Exception e8) {
                            TextView textView8 = PassengerDetailFragment.a;
                            e8.getMessage();
                        }
                        int g2 = xx.g(passengerDetailFragment.f4949b.getPsgnConcType());
                        if (C1450w1.e()) {
                            if (g2 != 0) {
                                passengerDetailFragment.special_concession_list_lap2.setText(xx.b(g2));
                            }
                        } else if (g2 != 0) {
                            passengerDetailFragment.special_concession_list_lap2.setText(xx.c(g2));
                        }
                        if (C0535I5.f3647h) {
                            passengerDetailFragment.E = String.valueOf(passengerDetailFragment.f4949b.getPsgnConcType());
                            passengerDetailFragment.spc_card_number_lap2.setText(passengerDetailFragment.f4949b.getPsgnConcCardId());
                        }
                    } else if (C0535I5.f3647h) {
                        passengerDetailFragment.special_concession_list_lap2.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Concession_Option));
                    }
                }
            }
            if (passengerDetailFragment.f4994l) {
                if (passengerDetailFragment.f4941a != null && !passengerDetailFragment.f4941a.isEmpty() && passengerDetailFragment.f4941a.containsValue(passengerDetailFragment.f4930a.getPassengerNationality())) {
                    Iterator it = passengerDetailFragment.f4941a.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (passengerDetailFragment.f4930a.getPassengerNationality().equals(entry.getValue())) {
                            passengerDetailFragment.nationality.setText((CharSequence) entry.getKey());
                            break;
                        }
                    }
                    passengerDetailFragment.x = passengerDetailFragment.f4930a.getPassengerNationality();
                }
                passengerDetailFragment.g0(passengerDetailFragment.nationality.getText().toString());
            }
            if (passengerDetailFragment.f4994l && !passengerDetailFragment.x.equals("IN")) {
                Locale locale3 = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat("yyyyMMdd", locale3);
                SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("dd/MM/yyyy", locale3);
                try {
                    Date parse = simpleDateFormat5.parse(passengerDetailFragment.f4930a.getPsgnConcDOB());
                    passengerDetailFragment.tv_dob_ft.setText(simpleDateFormat6.format(parse));
                    passengerDetailFragment.splDOB.setText(simpleDateFormat6.format(parse));
                    if (C0535I5.f3647h) {
                        passengerDetailFragment.tv_conc_dob_lap2.setText(simpleDateFormat6.format(simpleDateFormat5.parse(passengerDetailFragment.f4949b.getPsgnConcDOB())));
                    }
                } catch (ParseException e9) {
                    TextView textView9 = PassengerDetailFragment.a;
                    e9.getMessage();
                } catch (Exception e10) {
                    TextView textView10 = PassengerDetailFragment.a;
                    e10.getMessage();
                }
            }
            if (passengerDetailFragment.f4930a.getPassengerFoodChoice() != null) {
                if (!PassengerDetailFragment.f4886a.isFoodChoiceEnabled() || !passengerDetailFragment.f4994l || passengerDetailFragment.f4930a.getPassengerFoodChoice() == null) {
                    passengerDetailFragment.foodChoice.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.catering_service_option));
                } else {
                    passengerDetailFragment.foodChoice.setText(J9.i(passengerDetailFragment.f4930a.getPassengerFoodChoice().charAt(0)).f());
                    passengerDetailFragment.y = Character.toString(passengerDetailFragment.f4930a.getPassengerFoodChoice().charAt(0));
                    passengerDetailFragment.mealPreferenceLayout.setVisibility(0);
                }
            }
            if (C0535I5.f3647h && passengerDetailFragment.f4949b.getPassengerFoodChoice() != null) {
                if (!PassengerDetailFragment.b.isFoodChoiceEnabled() || !passengerDetailFragment.f4994l || passengerDetailFragment.f4949b.getPassengerFoodChoice() == null) {
                    passengerDetailFragment.food_choice_lap2.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.catering_service_option));
                } else {
                    passengerDetailFragment.food_choice_lap2.setText(J9.i(passengerDetailFragment.f4949b.getPassengerFoodChoice().charAt(0)).f());
                    passengerDetailFragment.z = Character.toString(passengerDetailFragment.f4949b.getPassengerFoodChoice().charAt(0));
                    passengerDetailFragment.ll_meal_preference_lap2.setVisibility(0);
                }
            }
            if (passengerDetailFragment.f4930a.getPassengerAge() != null) {
                if (!PassengerDetailFragment.f4886a.isBedRollFlagEnabled()) {
                    passengerDetailFragment.bedRollLayout.setVisibility(8);
                } else if (!passengerDetailFragment.f4994l || passengerDetailFragment.f4930a.getPassengerAge().shortValue() < PassengerDetailFragment.f4886a.getMinPassengerAge() || passengerDetailFragment.f4930a.getPassengerAge().shortValue() > PassengerDetailFragment.f4886a.getMaxChildAge()) {
                    passengerDetailFragment.bedRollLayout.setVisibility(0);
                } else if (passengerDetailFragment.f4930a.getChildBerthFlag() == null || !passengerDetailFragment.f4930a.getChildBerthFlag().booleanValue()) {
                    passengerDetailFragment.bedRollLayout.setVisibility(8);
                } else {
                    passengerDetailFragment.bedRollLayout.setVisibility(0);
                }
            }
            if (passengerDetailFragment.f4994l) {
                if (passengerDetailFragment.f4930a.getPassengerBedrollChoice() == null || !passengerDetailFragment.f4930a.getPassengerBedrollChoice().equals("true")) {
                    passengerDetailFragment.bedRoll.setChecked(false);
                } else {
                    passengerDetailFragment.bedRoll.setChecked(true);
                }
            }
            if (C0535I5.L()) {
                if (!PassengerDetailFragment.b.isBedRollFlagEnabled()) {
                    passengerDetailFragment.is_bedroll_ll_lap2.setVisibility(8);
                } else if (!passengerDetailFragment.f4994l || passengerDetailFragment.f4949b.getPassengerAge().shortValue() < PassengerDetailFragment.b.getMinPassengerAge() || passengerDetailFragment.f4949b.getPassengerAge().shortValue() > PassengerDetailFragment.b.getMaxChildAge()) {
                    passengerDetailFragment.is_bedroll_ll_lap2.setVisibility(0);
                } else if (passengerDetailFragment.f4949b.getChildBerthFlag() == null || !passengerDetailFragment.f4949b.getChildBerthFlag().booleanValue()) {
                    passengerDetailFragment.is_bedroll_ll_lap2.setVisibility(8);
                } else {
                    passengerDetailFragment.is_bedroll_ll_lap2.setVisibility(0);
                }
                if (passengerDetailFragment.f4994l) {
                    if (passengerDetailFragment.f4949b.getPassengerBedrollChoice() == null || !passengerDetailFragment.f4949b.getPassengerBedrollChoice().equals("true")) {
                        passengerDetailFragment.is_bad_berth_lap2.setChecked(false);
                    } else {
                        passengerDetailFragment.is_bad_berth_lap2.setChecked(true);
                    }
                }
            }
            if ((!passengerDetailFragment.f4994l || passengerDetailFragment.f4930a.getConcessionOpted() == null || passengerDetailFragment.f4930a.getForGoConcessionOpted() == null) && (passengerDetailFragment.f4949b.getConcessionOpted() == null || passengerDetailFragment.f4949b.getForGoConcessionOpted() == null)) {
                passengerDetailFragment.srctznConcession.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
                if (C0535I5.L()) {
                    passengerDetailFragment.srctzn_concession_lap2.setText(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
                }
            } else {
                if (passengerDetailFragment.f4930a.getConcessionOpted() == null || passengerDetailFragment.f4930a.getForGoConcessionOpted() == null) {
                    passengerDetailFragment.srctznConcLayout.setVisibility(8);
                } else {
                    passengerDetailFragment.g = 0;
                    if (((C0709Uj.m(passengerDetailFragment.passengerAge) >= PassengerDetailFragment.f4886a.getSrctznAge() && passengerDetailFragment.F.equals("M")) || ((C0709Uj.m(passengerDetailFragment.passengerAge) >= PassengerDetailFragment.f4886a.getSrctnwAge() && passengerDetailFragment.F.equals("F")) || (C0709Uj.m(passengerDetailFragment.passengerAge) >= PassengerDetailFragment.f4886a.getSrctzTAge() && passengerDetailFragment.F.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)))) && PassengerDetailFragment.f4886a.isSeniorCitizenApplicable() && C1058d.g(passengerDetailFragment.f4930a.getPassengerConcession()) != 0) {
                        passengerDetailFragment.g = C1058d.c(C1058d.g(passengerDetailFragment.f4930a.getPassengerConcession()));
                    }
                    passengerDetailFragment.srctznConcession.setText(xx.a(xx.j(passengerDetailFragment.g)));
                }
                if (C0535I5.f3647h) {
                    if (passengerDetailFragment.f4949b.getConcessionOpted() == null || passengerDetailFragment.f4949b.getForGoConcessionOpted() == null) {
                        passengerDetailFragment.ll_srctzn_concession_lap2.setVisibility(8);
                    } else {
                        passengerDetailFragment.h = 0;
                        if (((C0709Uj.m(passengerDetailFragment.passengerAge) >= PassengerDetailFragment.f4886a.getSrctznAge() && passengerDetailFragment.F.equals("M")) || ((C0709Uj.m(passengerDetailFragment.passengerAge) >= PassengerDetailFragment.f4886a.getSrctnwAge() && passengerDetailFragment.F.equals("F")) || (C0709Uj.m(passengerDetailFragment.passengerAge) >= PassengerDetailFragment.f4886a.getSrctzTAge() && passengerDetailFragment.F.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)))) && PassengerDetailFragment.f4886a.isSeniorCitizenApplicable() && C1058d.g(passengerDetailFragment.f4949b.getPassengerConcession()) != 0) {
                            passengerDetailFragment.h = C1058d.c(C1058d.g(passengerDetailFragment.f4949b.getPassengerConcession()));
                        }
                        passengerDetailFragment.srctzn_concession_lap2.setText(xx.a(xx.j(passengerDetailFragment.h)));
                    }
                }
            }
            passengerDetailFragment.i0();
            if (C1450w1.e()) {
                passengerDetailFragment.spcCardnumber.setEnabled(false);
                passengerDetailFragment.splDOB.setEnabled(false);
                passengerDetailFragment.splCardValidity.setEnabled(false);
                if (C0535I5.f3647h) {
                    passengerDetailFragment.spc_card_number_lap2.setEnabled(false);
                    passengerDetailFragment.tv_conc_dob_lap2.setEnabled(false);
                    passengerDetailFragment.tv_conc_cardvalidity_lap2.setEnabled(false);
                    EditText editText3 = passengerDetailFragment.spc_card_number_lap2;
                    i = cris.org.in.prs.ima.R.color.light_gray;
                    C0709Uj.o(passengerDetailFragment, cris.org.in.prs.ima.R.color.light_gray, editText3);
                    C0709Uj.o(passengerDetailFragment, cris.org.in.prs.ima.R.color.light_gray, passengerDetailFragment.tv_conc_cardvalidity_lap2);
                    C0709Uj.o(passengerDetailFragment, cris.org.in.prs.ima.R.color.light_gray, passengerDetailFragment.tv_conc_dob_lap2);
                } else {
                    i = cris.org.in.prs.ima.R.color.light_gray;
                }
                C0709Uj.o(passengerDetailFragment, i, passengerDetailFragment.spcCardnumber);
                C0709Uj.o(passengerDetailFragment, i, passengerDetailFragment.splCardValidity);
                C0709Uj.o(passengerDetailFragment, i, passengerDetailFragment.splDOB);
                passengerDetailFragment.nationalityLayout.setEnabled(false);
                C0709Uj.p(passengerDetailFragment, i, passengerDetailFragment.nationalityLayout);
                passengerDetailFragment.nationalityRl.setEnabled(false);
                if (passengerDetailFragment.E.equals("")) {
                    passengerDetailFragment.spcCardnumber.setText("");
                    passengerDetailFragment.splDOB.setText("");
                    passengerDetailFragment.splCardValidity.setText("");
                    if (C0535I5.f3647h) {
                        passengerDetailFragment.spc_card_number_lap2.setText("");
                        passengerDetailFragment.tv_conc_dob_lap2.setText("");
                        passengerDetailFragment.tv_conc_cardvalidity_lap2.setText("");
                    }
                }
            }
        }
    }

    static {
        C1354qp.R(PassengerDetailFragment.class);
    }

    public PassengerDetailFragment() {
        Boolean bool = Boolean.FALSE;
        this.f4936a = bool;
        this.f4939a = 99;
        this.f4952b = 99;
        this.f4980h = null;
        this.f4899a = new Df();
        this.f4963c = new ArrayList<>();
        this.f4968d = new ArrayList<>();
        this.f4930a = new PassengerDetailDTO();
        this.f4949b = new PassengerDetailDTO();
        this.f4959c = new PassengerDetailDTO();
        this.f4965d = new PassengerDetailDTO();
        new PassengerDetailDTO();
        this.f4972e = new ArrayList<>();
        this.f4951b = bool;
        this.f4960c = bool;
        new ArrayList();
        this.f4975f = new ArrayList<>();
        new C0515Ga();
        this.f4933a = new C1081e2();
        this.f4900a = new C0668Rh();
        this.f4945b = new C0668Rh();
        this.f5004p = "";
        this.f4978g = new ArrayList<>();
        this.f4981h = new ArrayList<>();
        this.f = 0;
        this.f4973e = false;
        this.r = "";
        this.f5011s = null;
        this.f4976f = true;
        this.f5013t = null;
        this.f4979g = false;
        this.f4982h = false;
        this.f4985i = false;
        this.f5015u = "^[0-9a-zA-Z.]{1}[0-9a-zA-Z.\\s,\\-_:()\\/]{2,224}$";
        this.v = "";
        this.w = "";
        this.f4961c = 1;
        this.f4988j = false;
        this.f4991k = false;
        this.f4966d = 0;
        this.f4970e = 0;
        new ArrayList();
        this.f4993l = null;
        this.f4954b = null;
        this.f4996m = null;
        this.f4999n = null;
        this.f5002o = null;
        this.f5007q = null;
        this.f4994l = false;
        this.f4997m = false;
        this.x = "IN";
        this.y = null;
        this.z = null;
        this.g = 0;
        this.h = 0;
        this.A = "NC";
        this.B = "NC";
        this.C = "NC";
        this.D = "NC";
        this.E = "";
        this.f5000n = true;
        this.f5014t = null;
        this.f5016u = null;
        this.f4905a = null;
        this.f4944b = 10368000000L;
        this.H = "^[0]+$";
        this.f4898a = Bw.e(this.f4904a);
        this.f5018w = null;
        this.f4937a = (byte) -1;
        this.J = null;
        this.f5006p = false;
        this.f5020y = new ArrayList<>();
        this.k = 0;
        this.f5008q = false;
        this.f5021z = null;
        this.f4934a = null;
        this.f4890A = new ArrayList<>();
        this.f4891B = new ArrayList<>();
        this.M = "";
        this.N = "";
        this.f4892C = null;
        this.f4893D = new ArrayList<>();
        this.f4894E = new ArrayList<>();
        this.f4895F = new ArrayList<>();
        this.f4916a = new C0950g();
        this.f4917a = new C0951h();
        this.f4918a = new C0952i();
        this.f4919a = new C0960q();
        this.f4920a = new C0962s();
        this.f4921a = new C0963t();
        this.f4922a = new C0964u();
        this.f4923a = new C0965v();
        this.f4924a = new C0966w();
        this.f4925a = new C0967x();
        this.f4926a = new C0968y();
        this.f4927a = new C0969z();
        this.f4915a = new d0();
    }

    public static void L0(C0794b3 b3Var) {
        f4886a = b3Var;
    }

    public static void M0(C0794b3 b3Var) {
        b = b3Var;
    }

    public static void O0(int i2) {
        m = i2;
    }

    public static void R0(int i2) {
        n = i2;
    }

    public static void S0(int i2) {
        l = i2;
    }

    public static void V(PassengerDetailFragment passengerDetailFragment, Boolean bool) {
        passengerDetailFragment.f4903a = ProgressDialog.show(passengerDetailFragment.f4904a, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.loading), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.please_wait_text));
        String B2 = xx.B(passengerDetailFragment.et_psgn_pincode);
        String trim = passengerDetailFragment.et_city_town.getText().toString().trim();
        if (bool.booleanValue()) {
            B2 = xx.B(passengerDetailFragment.pinCode);
            trim = passengerDetailFragment.city.getText().toString().trim();
        }
        String f2 = C0657Qt.f();
        String format = String.format("/%s", new Object[]{B2});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).j(f2 + "pin" + format, trim).c(C1181iv.a()).a(E0.a()).b(new C1016c0(passengerDetailFragment, bool));
    }

    public static void W(PassengerDetailFragment passengerDetailFragment, boolean z2) {
        if (!passengerDetailFragment.f4994l || (C0709Uj.m(passengerDetailFragment.passengerAge) <= f4886a.getMaxChildAge() && C0709Uj.m(passengerDetailFragment.passengerAge) >= f4886a.getMinPassengerAge() && passengerDetailFragment.f4994l)) {
            passengerDetailFragment.bedRoll.setChecked(false);
            if (!passengerDetailFragment.isChildBerthReq.isChecked()) {
                passengerDetailFragment.bedRollLayout.setVisibility(8);
                passengerDetailFragment.isChildBerthReq.setVisibility(0);
                passengerDetailFragment.isChildBerthll.setVisibility(0);
                C0535I5.p(passengerDetailFragment.getContext(), false, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.No_berth_allotted_for_child), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Info), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                return;
            }
            passengerDetailFragment.berthPreference.setVisibility(0);
            if (z2) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Full_fare_charged_allotted_for_child), (DialogInterface.OnClickListener) null);
            }
            if (f4886a.isBedRollFlagEnabled()) {
                passengerDetailFragment.bedRollLayout.setVisibility(0);
                passengerDetailFragment.bedRoll.setVisibility(0);
                return;
            }
            passengerDetailFragment.bedRoll.setChecked(false);
            passengerDetailFragment.bedRollLayout.setVisibility(8);
        }
    }

    public static void X(PassengerDetailFragment passengerDetailFragment) {
        if (!C0535I5.O((ConnectivityManager) passengerDetailFragment.getActivity().getSystemService("connectivity"), passengerDetailFragment.f4904a)) {
            new Handler().postDelayed(new Oo(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.book), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.please_wait_text), false, false);
        show.show();
        C1133ge geVar = passengerDetailFragment.f4935a;
        C1081e2 e2Var = passengerDetailFragment.f4933a;
        e2Var.setGstDetails(geVar);
        try {
            if (passengerDetailFragment.f4989k.compareToIgnoreCase(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.seniorCitizenCode)) == 0) {
                passengerDetailFragment.f4989k = passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.generalCode);
            }
            if ((S.equals("Y") || P.equals("HP")) && f4886a.getConcessionalPassengerType() != null && passengerDetailFragment.f4959c.getPsgnConcType().equals("HANDICAP")) {
                passengerDetailFragment.f4959c.setPassengerCardType((String) null);
                passengerDetailFragment.f4959c.setPassengerCardNumber((String) null);
                passengerDetailFragment.f4959c.setPassengerIcardFlag(false);
            }
            C0657Qt.f();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).H(String.format("Y", new Object[0]), e2Var).c(C1181iv.a()).a(E0.a()).b(new So(passengerDetailFragment, show));
        } catch (Exception e2) {
            e2.getMessage();
            show.dismiss();
            C0535I5.t0(passengerDetailFragment.getActivity(), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.please_try_again));
        }
    }

    public static boolean Z(ArrayList arrayList) {
        boolean z2;
        Iterator it = arrayList.iterator();
        do {
            z2 = true;
            if (!it.hasNext()) {
                return true;
            }
            PassengerDetailDTO passengerDetailDTO = (PassengerDetailDTO) it.next();
            if ((passengerDetailDTO.getPassengerAge().shortValue() < 60 || !passengerDetailDTO.getPassengerGender().equals("M")) && ((passengerDetailDTO.getPassengerAge().shortValue() < 45 || !passengerDetailDTO.getPassengerGender().equals("F")) && (passengerDetailDTO.getPassengerAge().shortValue() < f4886a.getSrctzTAge() || !passengerDetailDTO.getPassengerGender().equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)))) {
                z2 = false;
                continue;
            }
        } while (z2);
        return false;
    }

    public static GregorianCalendar a0(String str, String str2, String str3) {
        int indexOf = str.indexOf(45);
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(45, i2);
        int z2 = xx.z(indexOf2, 1, str);
        int parseInt = Integer.parseInt(str.substring(i2, indexOf2));
        int parseInt2 = Integer.parseInt(str.substring(0, indexOf));
        int indexOf3 = str3.indexOf(":");
        int parseInt3 = Integer.parseInt(str3.substring(0, indexOf3));
        int z3 = xx.z(indexOf3, 1, str3);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(z2, parseInt - 1, parseInt2, Integer.parseInt(str2.substring(0, 2)), Integer.parseInt(str2.substring(3)));
        gregorianCalendar.add(10, parseInt3);
        gregorianCalendar.add(12, z3);
        return gregorianCalendar;
    }

    public static void b1(ArrayList arrayList) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            PassengerDetailDTO passengerDetailDTO = (PassengerDetailDTO) arrayList.get(i4);
            if (passengerDetailDTO.getPassengerAge().shortValue() >= f4889c.get(0).getMinPassengerAge()) {
                i3++;
                passengerDetailDTO.setPassengerSerialNumber(Short.valueOf((short) i3));
            } else {
                i2++;
                passengerDetailDTO.setPassengerSerialNumber(Short.valueOf((short) i2));
            }
            arrayList.set(i4, passengerDetailDTO);
        }
    }

    public static void f(PassengerDetailFragment passengerDetailFragment, boolean z2) {
        if (!passengerDetailFragment.f4994l || (C0709Uj.m(passengerDetailFragment.passengerAge) <= b.getMaxChildAge() && C0709Uj.m(passengerDetailFragment.passengerAge) >= b.getMinPassengerAge() && passengerDetailFragment.f4994l)) {
            passengerDetailFragment.bedRoll.setChecked(false);
            if (!passengerDetailFragment.is_childBerth_req_lap2.isChecked()) {
                passengerDetailFragment.is_bedroll_ll_lap2.setVisibility(8);
                passengerDetailFragment.is_childBerth_req_lap2.setVisibility(0);
                passengerDetailFragment.is_childBerth_ll_lap2.setVisibility(0);
                C0535I5.p(passengerDetailFragment.getContext(), false, passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.No_berth_allotted_for_child), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Info), passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.ok), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                return;
            }
            if (z2) {
                C0709Uj.q(passengerDetailFragment, cris.org.in.prs.ima.R.string.OK, passengerDetailFragment.getActivity(), "Full fare will be charged and seat/berth will be allotted for child.", (DialogInterface.OnClickListener) null);
            }
            if (!C0535I5.f3647h) {
                return;
            }
            if (b.isBedRollFlagEnabled()) {
                passengerDetailFragment.is_bedroll_ll_lap2.setVisibility(0);
                passengerDetailFragment.is_bad_berth_lap2.setVisibility(0);
                return;
            }
            passengerDetailFragment.is_bad_berth_lap2.setChecked(false);
            passengerDetailFragment.is_bedroll_ll_lap2.setVisibility(8);
        }
    }

    public static int o0(int i2, int i3, int i4) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i5 = gregorianCalendar.get(1);
        int i6 = gregorianCalendar.get(2);
        int i7 = gregorianCalendar.get(5);
        gregorianCalendar.set(i2, i3, i4);
        int i8 = i5 - gregorianCalendar.get(1);
        if (i6 < gregorianCalendar.get(2) || (i6 == gregorianCalendar.get(2) && i7 < gregorianCalendar.get(5))) {
            i8--;
        }
        if (i8 >= 0) {
            return i8;
        }
        throw new IllegalArgumentException("Age < 0");
    }

    public static String p0(String str, String str2, String str3) {
        return new SimpleDateFormat("EEE, dd MMM yyyy").format(a0(str, str2, str3).getTime());
    }

    public static C0794b3 q0() {
        return f4886a;
    }

    public static int t0() {
        return l;
    }

    public static HashMap<Short, Short> u0() {
        return f4888b;
    }

    public final void A0() {
        if (this.F == null || lf.e(this.passengerAge) == 0) {
            X0(false);
        } else if (((C0709Uj.m(this.passengerAge) < f4886a.getSrctznAge() || !this.F.equals("M")) && ((C0709Uj.m(this.passengerAge) < f4886a.getSrctnwAge() || !this.F.equals("F")) && (C0709Uj.m(this.passengerAge) < f4886a.getSrctzTAge() || !this.F.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)))) || !f4886a.isSeniorCitizenApplicable()) {
            X0(false);
        } else {
            X0(true);
            String str = this.x;
            if (str != null && !str.equals("IN")) {
                if (!(this.g == 0 && this.h == 0)) {
                    C0709Uj.q(this, cris.org.in.prs.ima.R.string.OK, getActivity(), getString(cris.org.in.prs.ima.R.string.Senior_Citizen_concession_applicable_only_indian), (DialogInterface.OnClickListener) null);
                    this.g = 0;
                    this.srctznConcession.setText(xx.a(xx.j(0)));
                    if (C0535I5.f3647h) {
                        this.h = 0;
                        this.srctzn_concession_lap2.setText(xx.a(xx.j(0)));
                    }
                }
                X0(false);
            }
        }
    }

    public final void B0() {
        String str;
        if (!(!S.equals("Y") || this.f4963c == null || this.f4959c.getPsgnConcType() == null)) {
            String psgnConcType = this.f4959c.getPsgnConcType();
            int[] _values$1 = xx._values$1();
            int length = _values$1.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str = "";
                    break;
                }
                int i3 = _values$1[i2];
                if (xx.U(i3).equalsIgnoreCase("PRESCH")) {
                    str = xx.p(i3);
                    break;
                }
                i2++;
            }
            if (psgnConcType.equals(str)) {
                C0535I5.p(getContext(), false, getString(cris.org.in.prs.ima.R.string.concession_child_decl), "Declaration", getString(cris.org.in.prs.ima.R.string.yes), new n0(), getString(cris.org.in.prs.ima.R.string.no), (DialogInterface.OnClickListener) null).show();
                return;
            }
        }
        this.f4933a.setGeneralistChildConfirm(false);
        C0();
    }

    public final void C0() {
        int i2;
        String str;
        if (this.f4979g) {
            return;
        }
        if (C0793b1.a.f3912a != null) {
            int i3 = 0;
            ProgressDialog show = ProgressDialog.show(getActivity(), "Book Ticket", getString(cris.org.in.prs.ima.R.string.please_wait_text), false, false);
            short shortValue = this.f4961c.shortValue();
            C1081e2 e2Var = this.f4933a;
            e2Var.setPaymentType(shortValue);
            e2Var.setMoreThanOneDay(Boolean.FALSE);
            ArrayList<PassengerDetailDTO> arrayList = this.f4963c;
            C0668Rh rh = this.f4900a;
            rh.setPassengerList(arrayList);
            ArrayList<Df> arrayList2 = this.f4972e;
            rh.setInfantList(arrayList2);
            boolean z2 = C0535I5.f3647h;
            C0668Rh rh2 = this.f4945b;
            if (z2) {
                e2Var.setBookingChoice(this.f4966d.shortValue());
                e2Var.setBookingConfirmChoice(this.f4970e.shortValue());
                rh2.setPassengerList(this.f4968d);
                rh2.setInfantList(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(rh);
            if (C0535I5.f3647h) {
                arrayList3.add(rh2);
            }
            e2Var.setLapAvlRequestDTO(arrayList3);
            e2Var.setWsUserLogin(Bw.e(getContext()).h());
            e2Var.setMobileNumber(this.mobileNumber.getText().toString());
            e2Var.setTicketType("E");
            String str2 = this.M;
            int i4 = 1;
            if (str2 != null && str2.equals("redemption")) {
                e2Var.setLoyaltyRedemptionBooking(true);
            }
            if (this.N != null && (this.M.equals("accural") || this.M.equals("redemption"))) {
                e2Var.setBankId(Integer.parseInt(this.N));
            }
            Iterator<PassengerDetailDTO> it = rh.getPassengerList().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                PassengerDetailDTO next = it.next();
                if (next.getPassengerFoodChoice() == null) {
                    this.f4913a.setMealType((String) null);
                } else if (rh.getPassengerList().size() != 1 || !next.getPassengerFoodChoice().equals("N")) {
                    this.f4913a.setMealType("V");
                } else {
                    this.f4913a.setMealType("NV");
                }
                if (next.getPsgnConcType() != null && next.getPsgnConcType().equalsIgnoreCase("GENERAL")) {
                    i5++;
                }
            }
            if (S.equals("Y") || P.equals("HP")) {
                if (i5 == rh.getPassengerList().size()) {
                    rh.setConcessionBooking(false);
                } else {
                    rh.setConcessionBooking(true);
                }
            }
            if (C0535I5.f3647h) {
                Iterator<PassengerDetailDTO> it2 = rh2.getPassengerList().iterator();
                while (it2.hasNext()) {
                    PassengerDetailDTO next2 = it2.next();
                    if (next2.getPassengerFoodChoice() == null) {
                        this.f4913a.setMealType((String) null);
                    } else if (rh2.getPassengerList().size() != i4 || !next2.getPassengerFoodChoice().equals("N")) {
                        this.f4913a.setMealType("V");
                    } else {
                        this.f4913a.setMealType("NV");
                    }
                    if (next2.getPsgnConcType() != null && next2.getPsgnConcType().equalsIgnoreCase("GENERAL")) {
                        i3++;
                    }
                    i4 = 1;
                }
                if (S.equals("Y") || P.equals("HP")) {
                    if (i3 == rh2.getPassengerList().size()) {
                        rh2.setConcessionBooking(false);
                    } else {
                        rh2.setConcessionBooking(true);
                    }
                }
            }
            this.q = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            StringBuilder J2 = xx.J("" + Settings.Secure.getString(this.f4904a.getContentResolver(), "android_id"));
            J2.append(Bw.e(getContext()).h());
            J2.append(this.q);
            String sb = J2.toString();
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                instance.update(this.q.getBytes());
                e2Var.setClientTransactionId(new BigInteger(1, instance.digest(sb.getBytes())).toString(16).substring(0, 8));
                e2Var.setBoardingStation(this.f4983i);
                if (rh.getReservationChoice() == null) {
                    rh.setReservationChoice(99);
                }
                if (C0535I5.f3647h && rh2.getReservationChoice() == null) {
                    rh2.setReservationChoice(99);
                }
                this.f = 0;
                C1408tl tlVar = C1450w1.f7012a;
                if (tlVar == null || tlVar.getFormFillCheckEnable().intValue() != 1) {
                    i2 = 0;
                } else {
                    int intValue = tlVar.getFormFillCheckStartTime().intValue();
                    int intValue2 = tlVar.getFormFillCheckEndTime().intValue();
                    if (tlVar.getMinmPsgnInputTime().contains("#")) {
                        i2 = 0;
                        str = tlVar.getMinmPsgnInputTime().split("#")[e2Var.getLapAvlRequestDTO().get(0).getPassengerList().size() - 1];
                    } else {
                        i2 = 0;
                        str = tlVar.getMinmPsgnInputTime();
                    }
                    int intValue3 = Integer.valueOf(str).intValue();
                    long currentTimeMillis = ((System.currentTimeMillis() - C1450w1.f7020c) + C1450w1.f) / 60000;
                    if (((long) intValue) <= currentTimeMillis && ((long) intValue2) >= currentTimeMillis) {
                        this.f = (int) (((long) intValue3) - (System.currentTimeMillis() - C1450w1.f7020c));
                    }
                }
                int i6 = this.f;
                if (i6 > 0) {
                    i2 = i6;
                }
                this.f = i2;
                new C0816cB(new m0(show), i2).a();
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            C0535I5.m(getActivity(), false, getResources().getString(cris.org.in.prs.ima.R.string.data_connection_error_message), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public final void D0(C1100f2 f2Var) {
        C1507z0.c(this.f4931a.getTrainNumber(), n0(this.f4992l, "yyyyMMdd"), this.f4931a.getFromStnCode(), this.f4931a.getToStnCode(), this.f4986j, this.f4989k, this.f4929a.getTotalFare().toString(), String.valueOf(this.d), String.valueOf(this.f4956c), "Y");
        String trainNumber2 = this.f4931a.getTrainNumber();
        String n02 = n0(this.f4992l, "yyyyMMdd");
        String fromStnCode = this.f4931a.getFromStnCode();
        String toStnCode = this.f4931a.getToStnCode();
        String str = this.f4986j;
        C1081e2 e2Var = this.f4933a;
        String clientTransactionId = e2Var.getClientTransactionId();
        String d2 = f2Var.getAvlFareResponseDTO().get(0).getTotalCollectibleAmount().toString();
        String valueOf = String.valueOf(this.d + this.f4956c);
        String str2 = this.f4989k;
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.FLIGHT_NUMBER, trainNumber2);
        bundle.putString(FirebaseAnalytics.Param.START_DATE, C1507z0.a(n02));
        bundle.putString("origin", fromStnCode);
        bundle.putString(FirebaseAnalytics.Param.DESTINATION, toStnCode);
        bundle.putString(FirebaseAnalytics.Param.TRAVEL_CLASS, str);
        bundle.putString(FirebaseAnalytics.Param.TRANSACTION_ID, clientTransactionId);
        bundle.putString(FirebaseAnalytics.Param.QUANTITY, C0515Ga.AVLBLTY_ONLY);
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
        bundle.putString(FirebaseAnalytics.Param.PRICE, d2);
        bundle.putString(FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS, valueOf);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, str2);
        IrctcImaApplication.f4146a.logEvent(FirebaseAnalytics.Event.BEGIN_CHECKOUT, bundle);
        C1450w1.f7025d = System.currentTimeMillis();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("showMeal", this.f4890A);
        bundle2.putSerializable("SummaryDetails", f2Var);
        bundle2.putSerializable("TrainBtwnStnsDTO", this.f4931a);
        if (C0535I5.f3647h) {
            bundle2.putSerializable("TrainBtwnStnsDTOlap2", this.f4947b.f5342a);
            bundle2.putSerializable("TrainBtwnStnsModel", this.f4947b);
            bundle2.putString("arrivalDatelap2", R);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C0668Rh> it = e2Var.getLapAvlRequestDTO().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        bundle2.putSerializable("PassengerList", arrayList);
        bundle2.putSerializable("PassengerList", e2Var.getLapAvlRequestDTO().get(0).getPassengerList());
        if (C0535I5.f3647h) {
            bundle2.putSerializable("showMealLap2", this.f4891B);
            bundle2.putSerializable("PassengerListlap2", e2Var.getLapAvlRequestDTO().get(1).getPassengerList());
            String n03 = n0(this.f4995m, "dd MMM EEEE yyyy");
            this.f4998n = n03;
            bundle2.putString("jDatelp2", n03);
            bundle2.putString("selectQuotalap2", this.f4947b.d);
        }
        bundle2.putSerializable("googleAd", this.f4913a);
        bundle2.putString("SelectedClass", this.f4986j);
        bundle2.putString("SelectedQuotaString", this.f4928a.d);
        String n04 = n0(this.f4992l, "dd MMM EEEE yyyy");
        this.f4998n = n04;
        bundle2.putString("jDate", n04);
        bundle2.putString("ArrivalvDate", this.f5001o);
        if (this.d == 1) {
            bundle2.putString("PassengerCount", this.d + " " + getString(cris.org.in.prs.ima.R.string.adult) + " ");
        } else {
            bundle2.putString("PassengerCount", this.d + " " + getString(cris.org.in.prs.ima.R.string.adult) + " ");
        }
        bundle2.putString("ChildCount", this.f4956c + " " + getString(cris.org.in.prs.ima.R.string.child) + " ");
        bundle2.putString("ClientTxnId", e2Var.getClientTransactionId());
        bundle2.putString("SinglePsgnTotalfare", this.f4929a.getTotalFare().toString());
        bundle2.putString("JourneyDate", this.I);
        bundle2.putSerializable("mpUserMsg", this.f4929a.getInformationMessage());
        bundle2.putString("boadingStationAndDateTime", this.K);
        bundle2.putString("mobileNumber", Bw.e(getContext()).k().toString());
        bundle2.putBoolean("boadingpointchange", this.f4982h);
        bundle2.putSerializable("spConcession", S);
        C0668Rh rh = this.f4900a;
        if (rh.getTravelInsuranceOpted() == null) {
            bundle2.putBoolean("travelinsuranceopt", false);
        } else {
            bundle2.putBoolean("travelinsuranceopt", rh.getTravelInsuranceOpted().booleanValue());
        }
        if (C0535I5.f3647h) {
            C0668Rh rh2 = this.f4945b;
            if (rh2.getTravelInsuranceOpted() == null) {
                bundle2.putBoolean("travelinsuranceoptlap2", false);
            } else {
                bundle2.putBoolean("travelinsuranceoptlap2", rh2.getTravelInsuranceOpted().booleanValue());
            }
        }
        bundle2.putString("loyaltyBookingType", this.M);
        bundle2.putString("paymentLabel", this.v);
        bundle2.putString("paymentDesc", this.w);
        ReviewAndPayFragment reviewAndPayFragment = new ReviewAndPayFragment();
        reviewAndPayFragment.setArguments(bundle2);
        FragmentActivity activity = getActivity();
        String a2 = C1218kf.REVIEW_JOURNEY.a();
        Boolean bool = Boolean.TRUE;
        HomeActivity.n(activity, reviewAndPayFragment, a2, bool, Boolean.FALSE);
        this.f4936a = bool;
    }

    public final void E0(String str) {
        boolean z2 = this.f4994l;
        ArrayList<PassengerDetailDTO> arrayList = this.f4968d;
        ArrayList<PassengerDetailDTO> arrayList2 = this.f4963c;
        ArrayList<Df> arrayList3 = this.f4972e;
        if (!z2) {
            if (str.equalsIgnoreCase("infantPsgn")) {
                this.f4899a.setInfantSerialNumber(Short.valueOf((short) (arrayList3.size() + 1)));
                arrayList3.add(arrayList3.size(), this.f4899a);
                PassengerDetailDTO passengerDetailDTO = new PassengerDetailDTO();
                passengerDetailDTO.setPassengerName(this.f4899a.getName());
                passengerDetailDTO.setPassengerAge(Short.valueOf((short) this.f4899a.getAge().byteValue()));
                passengerDetailDTO.setPassengerGender(this.f4899a.getGender());
                passengerDetailDTO.setPassengerSerialNumber(this.f4899a.getInfantSerialNumber());
                ArrayList<PassengerDetailDTO> arrayList4 = this.f4978g;
                arrayList4.add(arrayList4.size(), passengerDetailDTO);
                if (C0535I5.f3647h) {
                    ArrayList<PassengerDetailDTO> arrayList5 = this.f4981h;
                    arrayList5.add(arrayList5.size(), passengerDetailDTO);
                }
                AddPassengerViewHolder addPassengerViewHolder = this.f4908a;
                if (addPassengerViewHolder == null) {
                    J0();
                    if (C0535I5.f3647h) {
                        K0();
                    }
                } else {
                    addPassengerViewHolder.notifyDataSetChanged();
                    if (C0535I5.f3647h) {
                        this.f4946b.notifyDataSetChanged();
                    }
                }
                this.e++;
                this.passengerCenter.setVisibility(8);
                this.passengerList.setVisibility(0);
                if (C0535I5.f3647h) {
                    this.select_passenger_lap2.setVisibility(0);
                    this.rv_passenger_list_lap2.setVisibility(0);
                }
            } else {
                this.f4959c.setPassengerSerialNumber(Short.valueOf((short) (arrayList2.size() + 1)));
                if (this.f4959c.getPassengerBerthChoice() != null && this.f4959c.getPassengerBerthChoice().equalsIgnoreCase("NC")) {
                    this.f4959c.setPassengerBerthChoice((String) null);
                }
                arrayList2.add(arrayList2.size(), this.f4959c);
                ArrayList<PassengerDetailDTO> arrayList6 = this.f4978g;
                arrayList6.add(arrayList6.size(), this.f4959c);
                l++;
                this.passengerCenter.setVisibility(8);
                this.passengerList.setVisibility(0);
                if (C0535I5.f3647h) {
                    this.select_passenger_lap2.setVisibility(0);
                    this.rv_passenger_list_lap2.setVisibility(0);
                    this.f4965d.setPassengerSerialNumber(Short.valueOf((short) (arrayList.size() + 1)));
                    if (this.f4965d.getPassengerBerthChoice() != null && this.f4965d.getPassengerBerthChoice().equalsIgnoreCase("NC")) {
                        this.f4965d.setPassengerBerthChoice((String) null);
                    }
                    arrayList.add(arrayList.size(), this.f4965d);
                    ArrayList<PassengerDetailDTO> arrayList7 = this.f4981h;
                    arrayList7.add(arrayList7.size(), this.f4965d);
                }
                AddPassengerViewHolder addPassengerViewHolder2 = this.f4908a;
                if (addPassengerViewHolder2 == null) {
                    J0();
                    if (C0535I5.f3647h) {
                        K0();
                    }
                } else {
                    addPassengerViewHolder2.notifyDataSetChanged();
                    if (C0535I5.f3647h) {
                        this.f4946b.notifyDataSetChanged();
                    }
                }
            }
        } else if (str.equalsIgnoreCase("infantPsgn")) {
            arrayList3.set(this.f4899a.getInfantSerialNumber().shortValue() - 1, this.f4899a);
            PassengerDetailDTO passengerDetailDTO2 = new PassengerDetailDTO();
            passengerDetailDTO2.setPassengerName(this.f4899a.getName());
            passengerDetailDTO2.setPassengerAge(Short.valueOf((short) this.f4899a.getAge().byteValue()));
            passengerDetailDTO2.setPassengerGender(this.f4899a.getGender());
            passengerDetailDTO2.setPassengerSerialNumber(this.f4899a.getInfantSerialNumber());
            this.f4978g.set(this.f4938a.intValue(), passengerDetailDTO2);
            if (C0535I5.f3647h) {
                this.f4981h.set(this.f4938a.intValue(), passengerDetailDTO2);
            }
            this.f4908a.notifyDataSetChanged();
            if (C0535I5.f3647h) {
                this.f4946b.notifyDataSetChanged();
            }
        } else {
            if (this.f4959c.getPassengerBerthChoice().equals("NC")) {
                this.f4959c.setPassengerBerthChoice((String) null);
            }
            arrayList2.set(this.f4959c.getPassengerSerialNumber().shortValue() - 1, this.f4959c);
            this.f4978g.set(this.f4938a.intValue(), this.f4959c);
            this.f4908a.notifyDataSetChanged();
            if (C0535I5.f3647h) {
                if (this.f4965d.getPassengerBerthChoice().equals("NC")) {
                    this.f4965d.setPassengerBerthChoice((String) null);
                }
                arrayList.set(this.f4965d.getPassengerSerialNumber().shortValue() - 1, this.f4965d);
                this.f4981h.set(this.f4938a.intValue(), this.f4965d);
                this.f4946b.notifyDataSetChanged();
            }
        }
        if (str.equalsIgnoreCase("normalPsgn")) {
            if (this.f4959c.getPsgnConcType() != null) {
                ArrayList arrayList8 = new ArrayList();
                arrayList8.add(l + "");
                arrayList8.add(this.f4959c.getPsgnConcCardId());
                arrayList8.add(this.f4959c.getPsgnConcDOB());
                arrayList8.add(this.f4959c.getPsgnConcCardExpiryDate());
                C0535I5.f3637d.put(l + "", arrayList8);
            }
            if (!(!C0535I5.f3647h || b.getConcessionalPassengerType() == null || this.f4965d.getPsgnConcType() == null)) {
                ArrayList arrayList9 = new ArrayList();
                arrayList9.add(l + "");
                arrayList9.add(this.f4965d.getPsgnConcCardId());
                arrayList9.add(this.f4965d.getPsgnConcDOB());
                arrayList9.add(this.f4965d.getPsgnConcCardExpiryDate());
                C0535I5.f3637d.put(l + "", arrayList9);
            }
        }
        this.f4930a = new PassengerDetailDTO();
    }

    public final void F0() {
        ArrayList<String> arrayList = this.f4893D;
        arrayList.add("Pass Booking");
        arrayList.add("General Booking");
    }

    public final void G0(int i2) {
        switch (i2) {
            case 1:
                this.pinCode.setError((CharSequence) null);
                this.pinCode.setTextColor(-16777216);
                return;
            case 2:
                this.flatDoorBlock.setError((CharSequence) null);
                this.flatDoorBlock.setTextColor(-16777216);
                return;
            case 3:
                this.streetLane.setError((CharSequence) null);
                this.streetLane.setTextColor(-16777216);
                return;
            case 4:
                this.areaLocality.setError((CharSequence) null);
                this.areaLocality.setTextColor(-16777216);
                return;
            case 6:
                this.gstpassengerName.setError((CharSequence) null);
                this.gstpassengerName.setTextColor(-16777216);
                return;
            case 7:
                this.city.setError((CharSequence) null);
                this.city.setTextColor(-16777216);
                return;
            case 8:
                this.gstinNumber.setError((CharSequence) null);
                this.gstinNumber.setTextColor(-16777216);
                return;
            case 9:
                this.et_address1.setError((CharSequence) null);
                this.et_address1.setTextColor(-16777216);
                return;
            case 10:
                this.et_psgn_pincode.setError((CharSequence) null);
                this.et_psgn_pincode.setTextColor(-16777216);
                return;
            default:
                return;
        }
    }

    public final void H0() {
        this.srctznConcession.setText(getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
        if (C0535I5.f3647h) {
            this.srctzn_concession_lap2.setText(getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
        }
        for (String f2 : getResources().getStringArray(cris.org.in.prs.ima.R.array.srctzn_conc)) {
            this.f4996m.add(xx.a(xx.f(f2)));
        }
    }

    public final void I0() {
        ArrayList arrayList = new ArrayList();
        Iterator<Z2.a> it = this.f4975f.iterator();
        while (it.hasNext()) {
            WrapperBoardingStationModel wrapperBoardingStationModel = new WrapperBoardingStationModel();
            wrapperBoardingStationModel.a = it.next();
            arrayList.add(wrapperBoardingStationModel);
        }
        o = arrayList.size() - 1;
        this.boardingStnView.setLayoutManager(new LinearLayoutManager(getContext()));
        BoardingStationChangeAdapter boardingStationChangeAdapter = new BoardingStationChangeAdapter(this.f4904a, arrayList, this.f4918a);
        this.f4909a = boardingStationChangeAdapter;
        this.boardingStnView.setAdapter(boardingStationChangeAdapter);
        WrapperBoardingStationModel wrapperBoardingStationModel2 = (WrapperBoardingStationModel) arrayList.get(0);
        if (!this.f4982h && wrapperBoardingStationModel2 != null) {
            this.K = wrapperBoardingStationModel2.a.getStnNameCode().split("-")[0] + "-(" + wrapperBoardingStationModel2.a.getStnNameCode().split("-")[1] + ")-" + wrapperBoardingStationModel2.a.getBoardingDate() + "-" + wrapperBoardingStationModel2.a.getDepartureTime();
        }
    }

    public final void J0() {
        if (C0535I5.f3647h) {
            ArrayList<PassengerDetailDTO> arrayList = this.f4978g;
            if (arrayList == null || arrayList.size() <= 0) {
                this.select_psgn_lap1.setVisibility(8);
            } else {
                this.select_psgn_lap1.setVisibility(0);
            }
        }
        this.passengerList.setLayoutManager(new LinearLayoutManager(getContext()));
        AddPassengerViewHolder addPassengerViewHolder = new AddPassengerViewHolder(this.f4904a, this.f4978g, this.f4927a, "lap1");
        this.f4908a = addPassengerViewHolder;
        this.passengerList.setAdapter(addPassengerViewHolder);
        if (C0535I5.f3647h) {
            K0();
        }
    }

    public final void K0() {
        ArrayList<PassengerDetailDTO> arrayList = this.f4981h;
        if (arrayList == null || arrayList.size() <= 0) {
            this.select_psgn_lap2.setVisibility(8);
        } else {
            this.select_psgn_lap2.setVisibility(0);
        }
        this.rv_passenger_list_lap2.setVisibility(0);
        this.select_passenger_lap2.setVisibility(0);
        this.rv_passenger_list_lap2.setLayoutManager(new LinearLayoutManager(getContext()));
        AddPassengerViewHolder addPassengerViewHolder = new AddPassengerViewHolder(this.f4904a, this.f4981h, this.f4927a, "lap2");
        this.f4946b = addPassengerViewHolder;
        this.rv_passenger_list_lap2.setAdapter(addPassengerViewHolder);
    }

    public final void N0(int i2, String str) {
        switch (i2) {
            case 1:
                this.pinCode.setError(str);
                this.pinCode.setTextColor(-65536);
                return;
            case 2:
                this.flatDoorBlock.setError(str);
                this.flatDoorBlock.setTextColor(-65536);
                return;
            case 3:
                this.streetLane.setError(str);
                this.streetLane.setTextColor(-65536);
                return;
            case 4:
                this.areaLocality.setError(str);
                this.areaLocality.setTextColor(-65536);
                return;
            case 6:
                this.gstpassengerName.setError(str);
                this.gstpassengerName.setTextColor(-65536);
                return;
            case 7:
                this.city.setError(str);
                this.city.setTextColor(-65536);
                return;
            case 8:
                this.gstinNumber.setError(str);
                this.gstinNumber.setTextColor(-65536);
                return;
            case 9:
                this.et_address1.setError(str);
                this.et_address1.setTextColor(-65536);
                return;
            case 10:
                this.et_psgn_pincode.setError(str);
                this.et_psgn_pincode.setTextColor(-65536);
                return;
            default:
                return;
        }
    }

    public final void P0() {
        this.rv_addmeal_list.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<MealItemDetails> arrayList = this.f4890A;
        Collections.sort(arrayList, new C0959p());
        this.rv_addmeal_list.setAdapter(new MealDetaillViewHolder(this.f4904a, arrayList, this.f4919a));
        a1();
    }

    public final void Q0() {
        ArrayList<MealItemDetails> arrayList = this.f4891B;
        if (arrayList.size() > 0) {
            this.select_meal_lap2.setVisibility(0);
        } else {
            this.select_meal_lap2.setVisibility(8);
        }
        this.rv_selectmeal_lap2.setLayoutManager(new LinearLayoutManager(getContext()));
        Collections.sort(arrayList, new C0961r());
        this.rv_selectmeal_lap2.setAdapter(new Lap2MealDetaillViewHolder(this.f4904a, arrayList, this.f4921a));
        a1();
    }

    public final void T0(String str) {
        this.w = str;
    }

    public final void U0(String str) {
        this.v = str;
    }

    public final void V0(Short sh) {
        this.f4961c = sh;
    }

    public final void W0(TextView textView, int i2) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i2), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void X0(boolean z2) {
        String str;
        if (!z2 || !((str = this.E) == null || str == "" || str.equals("GENERAL"))) {
            this.srctznConcLayout.setVisibility(8);
            this.srctznConcession.setVisibility(8);
            this.g = 0;
            this.srctznConcession.setText(xx.a(xx.j(0)));
            if (C0535I5.f3647h) {
                this.h = 0;
                this.srctzn_concession_lap2.setText(xx.a(xx.j(0)));
                this.srctzn_concession_lap2.setVisibility(8);
                this.ll_srctzn_concession_lap2.setVisibility(8);
                return;
            }
            return;
        }
        this.srctznConcession.setVisibility(0);
        this.srctznConcLayout.setVisibility(0);
        if (C0535I5.f3647h) {
            this.srctzn_concession_lap2.setVisibility(0);
            this.ll_srctzn_concession_lap2.setVisibility(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:361:0x117e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:525:0x1a04  */
    /* JADX WARNING: Removed duplicated region for block: B:528:0x1a0d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x035e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y0(boolean r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "ESCORT"
            java.lang.String r3 = "Y"
            r0 = 8
            r4 = 0
            if (r18 == 0) goto L_0x1985
            boolean r5 = defpackage.C0535I5.f3647h
            java.lang.String r6 = "HP"
            if (r5 == 0) goto L_0x003a
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4928a
            java.lang.String r5 = r5.c()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0026
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4928a
            java.lang.String r5 = r5.c()
            P = r5
            goto L_0x003a
        L_0x0026:
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            java.lang.String r5 = r5.c()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x003a
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            java.lang.String r5 = r5.c()
            P = r5
        L_0x003a:
            boolean r5 = defpackage.C1450w1.e()
            java.lang.String r7 = "MPCOMP"
            java.lang.String r8 = "MPSPOS"
            java.lang.String r9 = "MPPASS"
            java.lang.String r10 = "GENERAL"
            java.lang.String r11 = "HANDICAP"
            java.lang.String r12 = "dd/MM/yyyy"
            java.lang.String r13 = "yyyyMMdd"
            java.lang.String r14 = ""
            if (r5 != 0) goto L_0x00b7
            java.lang.String r5 = S
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x0060
            java.lang.String r5 = P
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0071
        L_0x0060:
            b3 r5 = f4886a
            java.util.ArrayList r5 = r5.getConcessionalPassengerType()
            if (r5 != 0) goto L_0x00b7
            b3 r5 = b
            java.util.ArrayList r5 = r5.getConcessionalPassengerType()
            if (r5 == 0) goto L_0x0071
            goto L_0x00b7
        L_0x0071:
            android.widget.LinearLayout r4 = r1.spConcessionLayout
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.specialConcesionType
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.spcCardnumber
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.splCardValidity
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.splDOB
            r4.setVisibility(r0)
            android.widget.LinearLayout r4 = r1.cardIDLayout
            r4.setVisibility(r0)
            boolean r4 = defpackage.C0535I5.f3647h
            if (r4 == 0) goto L_0x00b1
            android.widget.LinearLayout r4 = r1.spc_concession_layout_lap2
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.special_concession_list_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.tv_conc_dob_lap2
            r4.setVisibility(r0)
            android.widget.LinearLayout r4 = r1.ll_passport_lap2
            r4.setVisibility(r0)
        L_0x00b1:
            r16 = r6
            r18 = r11
            goto L_0x117a
        L_0x00b7:
            b3 r5 = f4886a
            java.util.ArrayList r5 = r5.getConcessionalPassengerType()
            if (r5 == 0) goto L_0x015a
            android.widget.TextView r5 = r1.specialConcesionType
            r5.setVisibility(r4)
            android.widget.LinearLayout r5 = r1.spConcessionLayout
            r5.setVisibility(r4)
            android.widget.EditText r5 = r1.spcCardnumber
            r5.setVisibility(r4)
            android.widget.EditText r5 = r1.splCardValidity
            r5.setVisibility(r4)
            android.widget.EditText r5 = r1.splDOB
            r5.setVisibility(r4)
            android.widget.TextView r5 = r1.idCardType
            r5.setVisibility(r0)
            android.widget.EditText r5 = r1.idCardNumber
            r5.setVisibility(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 1
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.splDOB
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            android.content.Context r4 = r1.f4904a
            r5 = 2131231032(0x7f080138, float:1.8078134E38)
            defpackage.lf.r(r4, r5, r0)
            android.widget.EditText r0 = r1.splCardValidity
            android.content.Context r4 = r1.f4904a
            defpackage.lf.r(r4, r5, r0)
            android.widget.EditText r0 = r1.splDOB
            android.content.Context r4 = r1.f4904a
            defpackage.lf.r(r4, r5, r0)
            android.widget.RadioGroup r0 = r1.genderGroup
            r4 = 1
            r0.setEnabled(r4)
            android.widget.RadioGroup r0 = r1.genderGroup
            android.content.res.Resources r5 = r17.getResources()
            r15 = 2131100644(0x7f0603e4, float:1.7813675E38)
            int r5 = r5.getColor(r15)
            r0.setBackgroundColor(r5)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            r0.setEnabled(r4)
            boolean r0 = r1.f4988j
            if (r0 == 0) goto L_0x0144
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            android.content.res.Resources r4 = r17.getResources()
            r5 = 2131100612(0x7f0603c4, float:1.781361E38)
            int r4 = r4.getColor(r5)
            r0.setBackgroundColor(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            defpackage.C0709Uj.p(r1, r5, r0)
            goto L_0x015a
        L_0x0144:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 2131100644(0x7f0603e4, float:1.7813675E38)
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            android.content.res.Resources r5 = r17.getResources()
            int r5 = r5.getColor(r4)
            r0.setBackgroundColor(r5)
            goto L_0x015d
        L_0x015a:
            r4 = 2131100644(0x7f0603e4, float:1.7813675E38)
        L_0x015d:
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r4 = 1
            r0.setEnabled(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x01d6
            b3 r0 = b
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x01d6
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            r0.setEnabled(r4)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            android.content.res.Resources r4 = r17.getResources()
            r5 = 2131100644(0x7f0603e4, float:1.7813675E38)
            int r4 = r4.getColor(r5)
            r0.setBackgroundColor(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            android.content.Context r4 = r1.f4904a
            r5 = 2131231032(0x7f080138, float:1.8078134E38)
            defpackage.lf.r(r4, r5, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            android.content.Context r4 = r1.f4904a
            defpackage.lf.r(r4, r5, r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            android.content.Context r4 = r1.f4904a
            defpackage.lf.r(r4, r5, r0)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r4 = 0
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r5 = 2131100644(0x7f0603e4, float:1.7813675E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.EditText r0 = r1.id_card_number_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r4 = 8
            r0.setVisibility(r4)
        L_0x01d6:
            java.lang.String r0 = r1.E
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x035e
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x0324
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x0324
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x0324
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object r0 = r0.get(r4)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.HashMap r4 = defpackage.C0535I5.D()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r15 = r1.f4949b
            java.lang.Short r15 = r15.getPassengerSerialNumber()
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            java.lang.Object r4 = r4.get(r5)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            android.widget.EditText r5 = r1.spcCardnumber
            r15 = 1
            java.lang.Object r15 = r0.get(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r5.setText(r15)
            boolean r5 = defpackage.C0535I5.f3647h
            if (r5 == 0) goto L_0x0258
            android.widget.EditText r5 = r1.spc_card_number_lap2
            r15 = 1
            java.lang.Object r15 = r4.get(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r5.setText(r15)
        L_0x0258:
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            r15 = 0
            r5.setPassengerCardType(r15)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            r5.setPassengerCardNumber(r15)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            r15 = 0
            r5.setPassengerIcardFlag(r15)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r13)
            java.text.SimpleDateFormat r15 = new java.text.SimpleDateFormat
            r15.<init>(r12)
            r18 = r11
            r11 = 2
            java.lang.Object r16 = r0.get(r11)     // Catch:{ ParseException -> 0x031d }
            if (r16 == 0) goto L_0x02c6
            java.lang.Object r11 = r0.get(r11)     // Catch:{ ParseException -> 0x031d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ParseException -> 0x031d }
            boolean r11 = r11.equals(r14)     // Catch:{ ParseException -> 0x031d }
            if (r11 != 0) goto L_0x02c6
            r11 = 3
            java.lang.Object r16 = r0.get(r11)     // Catch:{ ParseException -> 0x031d }
            if (r16 == 0) goto L_0x02c6
            java.lang.Object r11 = r0.get(r11)     // Catch:{ ParseException -> 0x031d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ParseException -> 0x031d }
            boolean r11 = r11.equals(r14)     // Catch:{ ParseException -> 0x031d }
            if (r11 != 0) goto L_0x02c6
            r11 = 2
            java.lang.Object r11 = r0.get(r11)     // Catch:{ ParseException -> 0x031d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ParseException -> 0x031d }
            java.util.Date r11 = r5.parse(r11)     // Catch:{ ParseException -> 0x031d }
            java.lang.String r11 = r15.format(r11)     // Catch:{ ParseException -> 0x031d }
            r16 = r6
            android.widget.EditText r6 = r1.splDOB     // Catch:{ ParseException -> 0x031b }
            r6.setText(r11)     // Catch:{ ParseException -> 0x031b }
            r6 = 3
            java.lang.Object r0 = r0.get(r6)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ParseException -> 0x031b }
            java.util.Date r0 = r5.parse(r0)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = r15.format(r0)     // Catch:{ ParseException -> 0x031b }
            android.widget.EditText r6 = r1.splCardValidity     // Catch:{ ParseException -> 0x031b }
            r6.setText(r0)     // Catch:{ ParseException -> 0x031b }
            goto L_0x02c8
        L_0x02c6:
            r16 = r6
        L_0x02c8:
            boolean r0 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x031b }
            if (r0 == 0) goto L_0x034c
            r0 = 2
            java.lang.Object r6 = r4.get(r0)     // Catch:{ ParseException -> 0x031b }
            if (r6 == 0) goto L_0x034c
            java.lang.Object r0 = r4.get(r0)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ParseException -> 0x031b }
            boolean r0 = r0.equals(r14)     // Catch:{ ParseException -> 0x031b }
            if (r0 != 0) goto L_0x034c
            r0 = 3
            java.lang.Object r6 = r4.get(r0)     // Catch:{ ParseException -> 0x031b }
            if (r6 == 0) goto L_0x034c
            java.lang.Object r0 = r4.get(r0)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ParseException -> 0x031b }
            boolean r0 = r0.equals(r14)     // Catch:{ ParseException -> 0x031b }
            if (r0 != 0) goto L_0x034c
            r0 = 2
            java.lang.Object r0 = r4.get(r0)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ParseException -> 0x031b }
            java.util.Date r0 = r5.parse(r0)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = r15.format(r0)     // Catch:{ ParseException -> 0x031b }
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x031b }
            r6.setText(r0)     // Catch:{ ParseException -> 0x031b }
            r0 = 3
            java.lang.Object r0 = r4.get(r0)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ParseException -> 0x031b }
            java.util.Date r0 = r5.parse(r0)     // Catch:{ ParseException -> 0x031b }
            java.lang.String r0 = r15.format(r0)     // Catch:{ ParseException -> 0x031b }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x031b }
            r4.setText(r0)     // Catch:{ ParseException -> 0x031b }
            goto L_0x034c
        L_0x031b:
            r0 = move-exception
            goto L_0x0320
        L_0x031d:
            r0 = move-exception
            r16 = r6
        L_0x0320:
            r0.getMessage()
            goto L_0x034c
        L_0x0324:
            r16 = r6
            r18 = r11
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            r4 = 0
            r0.setPassengerCardType(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            r0.setPassengerCardNumber(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            r5 = 0
            r0.setPassengerIcardFlag(r5)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x034c
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r0.setPassengerCardType(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r0.setPassengerCardNumber(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r0.setPassengerIcardFlag(r5)
        L_0x034c:
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r4 = 8
            r0.setVisibility(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r4)
            goto L_0x117a
        L_0x035e:
            r16 = r6
            r18 = r11
            java.lang.String r0 = r1.E
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x04a6
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x045c
            java.util.HashMap r0 = defpackage.C0535I5.D()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x045c
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L_0x0387:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x039a
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            goto L_0x0387
        L_0x039a:
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x03dc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x03dc
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 0
            r0.setText(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setText(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setText(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setText(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setText(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setText(r4)
            goto L_0x045c
        L_0x03dc:
            if (r4 == 0) goto L_0x045c
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 1
            java.lang.Object r6 = r4.get(r5)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            java.lang.Object r5 = r4.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r13)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12)
            r6 = 2
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x0458 }
            if (r11 == 0) goto L_0x045c
            java.lang.Object r6 = r4.get(r6)     // Catch:{ ParseException -> 0x0458 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x0458 }
            boolean r6 = r6.equals(r14)     // Catch:{ ParseException -> 0x0458 }
            if (r6 != 0) goto L_0x045c
            r6 = 3
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x0458 }
            if (r11 == 0) goto L_0x045c
            java.lang.Object r6 = r4.get(r6)     // Catch:{ ParseException -> 0x0458 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x0458 }
            boolean r6 = r6.equals(r14)     // Catch:{ ParseException -> 0x0458 }
            if (r6 != 0) goto L_0x045c
            r6 = 2
            java.lang.Object r6 = r4.get(r6)     // Catch:{ ParseException -> 0x0458 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x0458 }
            java.util.Date r6 = r0.parse(r6)     // Catch:{ ParseException -> 0x0458 }
            java.lang.String r6 = r5.format(r6)     // Catch:{ ParseException -> 0x0458 }
            android.widget.EditText r11 = r1.splDOB     // Catch:{ ParseException -> 0x0458 }
            r11.setText(r6)     // Catch:{ ParseException -> 0x0458 }
            android.widget.EditText r11 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x0458 }
            r11.setText(r6)     // Catch:{ ParseException -> 0x0458 }
            r6 = 3
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x0458 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x0458 }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ ParseException -> 0x0458 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x0458 }
            android.widget.EditText r4 = r1.splCardValidity     // Catch:{ ParseException -> 0x0458 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x0458 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x0458 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x0458 }
            goto L_0x045c
        L_0x0458:
            r0 = move-exception
            r0.getMessage()
        L_0x045c:
            android.widget.TextView r0 = r1.idCardType
            java.lang.CharSequence r4 = r0.getText()
            java.lang.String r4 = r4.toString()
            r0.setText(r4)
            android.widget.EditText r0 = r1.idCardNumber
            defpackage.lf.s(r0)
            android.widget.TextView r0 = r1.idCardType
            r4 = 0
            r0.setVisibility(r4)
            b3 r0 = f4886a
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x0481
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r0.setVisibility(r4)
        L_0x0481:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.TextView r0 = r1.id_card_types_lap2
            java.lang.CharSequence r5 = r0.getText()
            java.lang.String r5 = r5.toString()
            r0.setText(r5)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            b3 r0 = b
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r4)
            goto L_0x117a
        L_0x04a6:
            r0 = 0
            java.lang.String r4 = r1.E
            boolean r4 = r4.equals(r10)
            if (r4 == 0) goto L_0x04f3
            android.widget.LinearLayout r4 = r1.cardIDLayout
            r5 = 8
            r4.setVisibility(r5)
            android.widget.LinearLayout r4 = r1.spConcessionLayout
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.spcCardnumber
            r4.setVisibility(r5)
            android.widget.EditText r4 = r1.splCardValidity
            r4.setVisibility(r5)
            android.widget.EditText r4 = r1.splDOB
            r4.setVisibility(r5)
            android.widget.TextView r4 = r1.specialConcesionType
            r4.setVisibility(r0)
            boolean r4 = defpackage.C0535I5.f3647h
            if (r4 == 0) goto L_0x117a
            android.widget.TextView r4 = r1.special_concession_list_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.tv_conc_dob_lap2
            r4.setVisibility(r5)
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2
            r4.setVisibility(r5)
            android.widget.LinearLayout r4 = r1.ll_passport_lap2
            r4.setVisibility(r5)
            android.widget.LinearLayout r4 = r1.spc_concession_layout_lap2
            r4.setVisibility(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r5)
            goto L_0x117a
        L_0x04f3:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "PRESSC"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x05f0
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x0580
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x0580
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x0580
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object r0 = r0.get(r4)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            android.widget.EditText r4 = r1.spcCardnumber
            r5 = 1
            java.lang.Object r5 = r0.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            r4.<init>(r13)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12)
            r6 = 3
            java.lang.Object r11 = r0.get(r6)     // Catch:{ ParseException -> 0x057c }
            if (r11 == 0) goto L_0x0580
            java.lang.Object r11 = r0.get(r6)     // Catch:{ ParseException -> 0x057c }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ParseException -> 0x057c }
            boolean r11 = r11.equals(r14)     // Catch:{ ParseException -> 0x057c }
            if (r11 != 0) goto L_0x0580
            java.lang.Object r0 = r0.get(r6)     // Catch:{ ParseException -> 0x057c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ParseException -> 0x057c }
            java.util.Date r0 = r4.parse(r0)     // Catch:{ ParseException -> 0x057c }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x057c }
            android.widget.EditText r4 = r1.splCardValidity     // Catch:{ ParseException -> 0x057c }
            r4.setText(r0)     // Catch:{ ParseException -> 0x057c }
            goto L_0x0580
        L_0x057c:
            r0 = move-exception
            r0.getMessage()
        L_0x0580:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r4 = 8
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.lf.s(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r4 = 0
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            goto L_0x117a
        L_0x05f0:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "PRESCH"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x071b
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x06a6
            java.util.HashMap r0 = defpackage.C0535I5.D()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06a6
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L_0x0617:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x062a
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            goto L_0x0617
        L_0x062a:
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x0657
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0657
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 0
            r0.setText(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setText(r4)
            goto L_0x06a6
        L_0x0657:
            if (r4 == 0) goto L_0x06a6
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 0
            r0.setEnabled(r5)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r13)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12)
            r6 = 3
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x06a2 }
            if (r11 == 0) goto L_0x06a6
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x06a2 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ParseException -> 0x06a2 }
            boolean r11 = r11.equals(r14)     // Catch:{ ParseException -> 0x06a2 }
            if (r11 != 0) goto L_0x06a6
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x06a2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x06a2 }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ ParseException -> 0x06a2 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x06a2 }
            android.widget.EditText r4 = r1.splCardValidity     // Catch:{ ParseException -> 0x06a2 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x06a2 }
            android.widget.EditText r0 = r1.splCardValidity     // Catch:{ ParseException -> 0x06a2 }
            r4 = 0
            r0.setEnabled(r4)     // Catch:{ ParseException -> 0x06a2 }
            goto L_0x06a6
        L_0x06a2:
            r0 = move-exception
            r0.getMessage()
        L_0x06a6:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r4 = 8
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.lf.s(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            goto L_0x117a
        L_0x071b:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "PRESSS"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0846
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x07d1
            java.util.HashMap r0 = defpackage.C0535I5.D()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x07d1
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L_0x0742:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0755
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            goto L_0x0742
        L_0x0755:
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x0782
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0782
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 0
            r0.setText(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setText(r4)
            goto L_0x07d1
        L_0x0782:
            if (r4 == 0) goto L_0x07d1
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 0
            r0.setEnabled(r5)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r13)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12)
            r6 = 3
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x07cd }
            if (r11 == 0) goto L_0x07d1
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x07cd }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ParseException -> 0x07cd }
            boolean r11 = r11.equals(r14)     // Catch:{ ParseException -> 0x07cd }
            if (r11 != 0) goto L_0x07d1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x07cd }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x07cd }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ ParseException -> 0x07cd }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x07cd }
            android.widget.EditText r4 = r1.splCardValidity     // Catch:{ ParseException -> 0x07cd }
            r4.setText(r0)     // Catch:{ ParseException -> 0x07cd }
            android.widget.EditText r0 = r1.splCardValidity     // Catch:{ ParseException -> 0x07cd }
            r4 = 0
            r0.setEnabled(r4)     // Catch:{ ParseException -> 0x07cd }
            goto L_0x07d1
        L_0x07cd:
            r0 = move-exception
            r0.getMessage()
        L_0x07d1:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r4 = 8
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.lf.s(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            goto L_0x117a
        L_0x0846:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "PRESCO"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x096c
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x08fc
            java.util.HashMap r0 = defpackage.C0535I5.D()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x08fc
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L_0x086d:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0880
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            goto L_0x086d
        L_0x0880:
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x08ad
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4930a
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x08ad
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 0
            r0.setText(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setText(r4)
            goto L_0x08fc
        L_0x08ad:
            if (r4 == 0) goto L_0x08fc
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            android.widget.EditText r0 = r1.spcCardnumber
            r5 = 0
            r0.setEnabled(r5)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r13)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12)
            r6 = 3
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x08f8 }
            if (r11 == 0) goto L_0x08fc
            java.lang.Object r11 = r4.get(r6)     // Catch:{ ParseException -> 0x08f8 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ ParseException -> 0x08f8 }
            boolean r11 = r11.equals(r14)     // Catch:{ ParseException -> 0x08f8 }
            if (r11 != 0) goto L_0x08fc
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x08f8 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x08f8 }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ ParseException -> 0x08f8 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x08f8 }
            android.widget.EditText r4 = r1.splCardValidity     // Catch:{ ParseException -> 0x08f8 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x08f8 }
            android.widget.EditText r0 = r1.splCardValidity     // Catch:{ ParseException -> 0x08f8 }
            r4 = 0
            r0.setEnabled(r4)     // Catch:{ ParseException -> 0x08f8 }
            goto L_0x08fc
        L_0x08f8:
            r0 = move-exception
            r0.getMessage()
        L_0x08fc:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.lf.s(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            goto L_0x117a
        L_0x096c:
            java.lang.String r0 = r1.E
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0abf
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r4 = 8
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 0
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splDOB
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.passengerName
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.passengerAge
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.passengerName
            r4 = 0
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.passengerAge
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.passengerAge
            r5 = 0
            r0.setError(r5)
            android.widget.RadioGroup r0 = r1.genderGroup
            r0.setEnabled(r4)
            android.widget.RadioGroup r0 = r1.genderGroup
            android.content.res.Resources r5 = r17.getResources()
            r6 = 2131099888(0x7f0600f0, float:1.7812142E38)
            int r5 = r5.getColor(r6)
            r0.setBackgroundColor(r5)
            android.widget.TextView r0 = r1.male
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.feMale
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.transGender
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            r0.setEnabled(r4)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            android.content.res.Resources r6 = r17.getResources()
            int r6 = r6.getColor(r5)
            r0.setBackgroundColor(r6)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 0
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r5 = 0
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            r0.setEnabled(r5)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            android.content.res.Resources r5 = r17.getResources()
            int r4 = r5.getColor(r4)
            r0.setBackgroundColor(r4)
            goto L_0x117a
        L_0x0abf:
            r0 = 0
            java.lang.String r4 = r1.E
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0cde
            android.widget.LinearLayout r4 = r1.spConcessionLayout
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.specialConcesionType
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.spcCardnumber
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.splCardValidity
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.idCardType
            r4.setVisibility(r0)
            android.widget.LinearLayout r4 = r1.cardIDLayout
            r5 = 8
            r4.setVisibility(r5)
            boolean r4 = defpackage.C0535I5.f3647h
            if (r4 == 0) goto L_0x0b0c
            android.widget.LinearLayout r4 = r1.spc_concession_layout_lap2
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.special_concession_list_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.id_card_types_lap2
            r4.setVisibility(r0)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
        L_0x0b0c:
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            if (r0 == 0) goto L_0x0b9d
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            short r0 = r0.shortValue()
            if (r0 != 0) goto L_0x0b9d
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x0b9d
            android.widget.EditText r4 = r1.spcCardnumber
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0b45
            android.widget.EditText r0 = r1.spc_card_number_lap2
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x
            java.lang.Object r4 = r4.get(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L_0x0b45:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            android.widget.EditText r6 = r1.splDOB     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.lang.String r11 = r5.format(r4)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            r6.setText(r11)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            r11 = 2
            java.lang.Object r6 = r6.get(r11)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            android.widget.EditText r6 = r1.splCardValidity     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.lang.String r11 = r5.format(r0)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            r6.setText(r11)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            boolean r6 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            if (r6 == 0) goto L_0x0b9d
            android.widget.EditText r6 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            r6.setText(r0)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            android.widget.EditText r0 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            r0.setText(r4)     // Catch:{ ParseException -> 0x0b99, Exception -> 0x0b94 }
            goto L_0x0b9d
        L_0x0b94:
            r0 = move-exception
            r0.getMessage()
            goto L_0x0b9d
        L_0x0b99:
            r0 = move-exception
            r0.getMessage()
        L_0x0b9d:
            android.widget.EditText r0 = r1.spcCardnumber
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 0
            r0.setEnabled(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0bc2
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 0
            r0.setEnabled(r4)
            goto L_0x0bc3
        L_0x0bc2:
            r4 = 0
        L_0x0bc3:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            java.lang.String r0 = r0.getPsgnConcDOB()
            if (r0 == 0) goto L_0x0bfe
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.splDOB
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splDOB
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r5, r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0c18
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x0c18
        L_0x0bfe:
            android.widget.EditText r0 = r1.splDOB
            r0.setText(r14)
            android.widget.EditText r0 = r1.splDOB
            r4 = 8
            r0.setVisibility(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0c18
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setText(r14)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
        L_0x0c18:
            android.widget.EditText r0 = r1.splCardValidity
            r4 = 0
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.C0709Uj.o(r1, r4, r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0c3f
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r5 = 0
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
        L_0x0c3f:
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 0
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            android.content.res.Resources r5 = r17.getResources()
            int r4 = r5.getColor(r4)
            r0.setBackgroundColor(r4)
            Yl r0 = defpackage.C1450w1.c()
            if (r0 == 0) goto L_0x0cd6
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            if (r0 == 0) goto L_0x0cd6
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            short r0 = r0.shortValue()
            r4 = 1
            if (r0 != r4) goto L_0x0cd6
            android.widget.RadioGroup r0 = r1.genderGroup
            r4 = 0
            r0.setEnabled(r4)
            android.widget.RadioGroup r0 = r1.genderGroup
            android.content.res.Resources r5 = r17.getResources()
            r6 = 2131099888(0x7f0600f0, float:1.7812142E38)
            int r5 = r5.getColor(r6)
            r0.setBackgroundColor(r5)
            android.widget.TextView r0 = r1.male
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.feMale
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.transGender
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            r0.setEnabled(r4)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            android.content.res.Resources r6 = r17.getResources()
            int r6 = r6.getColor(r5)
            r0.setBackgroundColor(r6)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0cd7
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            r0.setEnabled(r4)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            android.content.res.Resources r6 = r17.getResources()
            int r5 = r6.getColor(r5)
            r0.setBackgroundColor(r5)
            goto L_0x0cd7
        L_0x0cd6:
            r4 = 0
        L_0x0cd7:
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            goto L_0x117a
        L_0x0cde:
            java.lang.String r0 = r1.E
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x1060
            java.lang.String r0 = r1.E
            java.lang.String r4 = "MPNTSP"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0cf2
            goto L_0x1060
        L_0x0cf2:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "MPBLES"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0e18
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x0d75
            android.widget.EditText r4 = r1.spcCardnumber
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0d1d
            android.widget.EditText r0 = r1.spc_card_number_lap2
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x
            java.lang.Object r4 = r4.get(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L_0x0d1d:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            android.widget.EditText r6 = r1.splDOB     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.lang.String r11 = r5.format(r4)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            r6.setText(r11)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            r11 = 2
            java.lang.Object r6 = r6.get(r11)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            android.widget.EditText r6 = r1.splCardValidity     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.lang.String r11 = r5.format(r0)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            r6.setText(r11)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            boolean r6 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            if (r6 == 0) goto L_0x0d75
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            r6.setText(r4)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            r4.setText(r0)     // Catch:{ ParseException -> 0x0d71, Exception -> 0x0d6c }
            goto L_0x0d75
        L_0x0d6c:
            r0 = move-exception
            r0.getMessage()
            goto L_0x0d75
        L_0x0d71:
            r0 = move-exception
            r0.getMessage()
        L_0x0d75:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splDOB
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 0
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r5)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x117a
        L_0x0e18:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "EXMP"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0f3e
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x0e9b
            android.widget.EditText r4 = r1.spcCardnumber
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0e43
            android.widget.EditText r0 = r1.spc_card_number_lap2
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x
            java.lang.Object r4 = r4.get(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L_0x0e43:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            android.widget.EditText r6 = r1.splDOB     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.lang.String r11 = r5.format(r4)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            r6.setText(r11)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            r11 = 2
            java.lang.Object r6 = r6.get(r11)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            android.widget.EditText r6 = r1.splCardValidity     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.lang.String r11 = r5.format(r0)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            r6.setText(r11)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            boolean r6 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            if (r6 == 0) goto L_0x0e9b
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            r6.setText(r4)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x0e97, Exception -> 0x0e92 }
            goto L_0x0e9b
        L_0x0e92:
            r0 = move-exception
            r0.getMessage()
            goto L_0x0e9b
        L_0x0e97:
            r0 = move-exception
            r0.getMessage()
        L_0x0e9b:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splDOB
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 0
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r5)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x117a
        L_0x0f3e:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "EXCOMP"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x117a
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x0fbd
            android.widget.EditText r4 = r1.spcCardnumber
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0f69
            android.widget.EditText r0 = r1.spc_card_number_lap2
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x
            java.lang.Object r4 = r4.get(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L_0x0f69:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            android.widget.EditText r6 = r1.splDOB     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.lang.String r11 = r5.format(r4)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            r6.setText(r11)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            r6.setText(r4)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            r6 = 2
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            android.widget.EditText r4 = r1.splCardValidity     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.lang.String r6 = r5.format(r0)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            r4.setText(r6)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x0fb9, Exception -> 0x0fb4 }
            goto L_0x0fbd
        L_0x0fb4:
            r0 = move-exception
            r0.getMessage()
            goto L_0x0fbd
        L_0x0fb9:
            r0 = move-exception
            r0.getMessage()
        L_0x0fbd:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splDOB
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 0
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r5)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x117a
        L_0x1060:
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x10d9
            android.widget.EditText r4 = r1.spcCardnumber
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x1081
            android.widget.EditText r0 = r1.spc_card_number_lap2
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x
            java.lang.Object r4 = r4.get(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L_0x1081:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            android.widget.EditText r6 = r1.splDOB     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.lang.String r11 = r5.format(r4)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            r6.setText(r11)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            r11 = 2
            java.lang.Object r6 = r6.get(r11)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            android.widget.EditText r6 = r1.splCardValidity     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.lang.String r11 = r5.format(r0)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            r6.setText(r11)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            boolean r6 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            if (r6 == 0) goto L_0x10d9
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            r6.setText(r4)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x10d5, Exception -> 0x10d0 }
            goto L_0x10d9
        L_0x10d0:
            r0 = move-exception
            r0.getMessage()
            goto L_0x10d9
        L_0x10d5:
            r0 = move-exception
            r0.getMessage()
        L_0x10d9:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splCardValidity
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.splDOB
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 0
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r5)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x117a
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
        L_0x117a:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x19c7
            boolean r0 = defpackage.C1450w1.e()
            if (r0 != 0) goto L_0x11c1
            java.lang.String r0 = S
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x1196
            java.lang.String r0 = P
            r4 = r16
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x119f
        L_0x1196:
            b3 r0 = b
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x119f
            goto L_0x11c1
        L_0x119f:
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r4)
            goto L_0x19c7
        L_0x11c1:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x1250
            b3 r0 = b
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x1250
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            r4 = 1
            r0.setEnabled(r4)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            android.content.res.Resources r4 = r17.getResources()
            r5 = 2131100644(0x7f0603e4, float:1.7813675E38)
            int r4 = r4.getColor(r5)
            r0.setBackgroundColor(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            android.content.Context r4 = r1.f4904a
            r5 = 2131231032(0x7f080138, float:1.8078134E38)
            defpackage.lf.r(r4, r5, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            android.content.Context r4 = r1.f4904a
            defpackage.lf.r(r4, r5, r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            android.content.Context r4 = r1.f4904a
            defpackage.lf.r(r4, r5, r0)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r4 = 0
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r5 = 2131100644(0x7f0603e4, float:1.7813675E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.EditText r0 = r1.id_card_number_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.RadioGroup r0 = r1.genderGroup
            r4 = 1
            r0.setEnabled(r4)
            android.widget.RadioGroup r0 = r1.genderGroup
            android.content.res.Resources r5 = r17.getResources()
            r6 = 2131100644(0x7f0603e4, float:1.7813675E38)
            int r5 = r5.getColor(r6)
            r0.setBackgroundColor(r5)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r6, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
        L_0x1250:
            java.lang.String r0 = r1.E
            r4 = r18
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x1331
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x1317
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x1317
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4949b
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x1317
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4949b
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object r0 = r0.get(r4)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r5 = 1
            java.lang.Object r5 = r0.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            cris.prs.webservices.dto.PassengerDetailDTO r4 = r1.f4949b
            r5 = 0
            r4.setPassengerCardType(r5)
            cris.prs.webservices.dto.PassengerDetailDTO r4 = r1.f4949b
            r4.setPassengerCardNumber(r5)
            cris.prs.webservices.dto.PassengerDetailDTO r4 = r1.f4949b
            r5 = 0
            r4.setPassengerIcardFlag(r5)
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            r4.<init>(r13)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12)
            r6 = 2
            java.lang.Object r7 = r0.get(r6)     // Catch:{ ParseException -> 0x1312 }
            if (r7 == 0) goto L_0x1328
            java.lang.Object r6 = r0.get(r6)     // Catch:{ ParseException -> 0x1312 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1312 }
            boolean r6 = r6.equals(r14)     // Catch:{ ParseException -> 0x1312 }
            if (r6 != 0) goto L_0x1328
            r6 = 3
            java.lang.Object r7 = r0.get(r6)     // Catch:{ ParseException -> 0x1312 }
            if (r7 == 0) goto L_0x1328
            java.lang.Object r6 = r0.get(r6)     // Catch:{ ParseException -> 0x1312 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1312 }
            boolean r6 = r6.equals(r14)     // Catch:{ ParseException -> 0x1312 }
            if (r6 != 0) goto L_0x1328
            r6 = 2
            java.lang.Object r6 = r0.get(r6)     // Catch:{ ParseException -> 0x1312 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1312 }
            java.util.Date r6 = r4.parse(r6)     // Catch:{ ParseException -> 0x1312 }
            java.lang.String r6 = r5.format(r6)     // Catch:{ ParseException -> 0x1312 }
            android.widget.EditText r7 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x1312 }
            r7.setText(r6)     // Catch:{ ParseException -> 0x1312 }
            r6 = 3
            java.lang.Object r0 = r0.get(r6)     // Catch:{ ParseException -> 0x1312 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ParseException -> 0x1312 }
            java.util.Date r0 = r4.parse(r0)     // Catch:{ ParseException -> 0x1312 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x1312 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x1312 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x1312 }
            goto L_0x1328
        L_0x1312:
            r0 = move-exception
            r0.getMessage()
            goto L_0x1328
        L_0x1317:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r4 = 0
            r0.setPassengerCardType(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r0.setPassengerCardNumber(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r4 = 0
            r0.setPassengerIcardFlag(r4)
        L_0x1328:
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            goto L_0x19c7
        L_0x1331:
            java.lang.String r0 = r1.E
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x142a
            java.util.HashMap r0 = defpackage.C0535I5.D()
            if (r0 == 0) goto L_0x1406
            java.util.HashMap r0 = defpackage.C0535I5.D()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x1406
            java.util.HashMap r0 = defpackage.C0535I5.D()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r4 = 0
        L_0x1356:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x1369
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r4 = r4.getValue()
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            goto L_0x1356
        L_0x1369:
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x139b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            cris.prs.webservices.dto.PassengerDetailDTO r5 = r1.f4949b
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x139b
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 0
            r0.setText(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setText(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setText(r4)
            goto L_0x1406
        L_0x139b:
            if (r4 == 0) goto L_0x1406
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r5 = 1
            java.lang.Object r5 = r4.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r13)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12)
            r6 = 2
            java.lang.Object r7 = r4.get(r6)     // Catch:{ ParseException -> 0x1402 }
            if (r7 == 0) goto L_0x1406
            java.lang.Object r6 = r4.get(r6)     // Catch:{ ParseException -> 0x1402 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1402 }
            boolean r6 = r6.equals(r14)     // Catch:{ ParseException -> 0x1402 }
            if (r6 != 0) goto L_0x1406
            r6 = 3
            java.lang.Object r7 = r4.get(r6)     // Catch:{ ParseException -> 0x1402 }
            if (r7 == 0) goto L_0x1406
            java.lang.Object r6 = r4.get(r6)     // Catch:{ ParseException -> 0x1402 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1402 }
            boolean r6 = r6.equals(r14)     // Catch:{ ParseException -> 0x1402 }
            if (r6 != 0) goto L_0x1406
            r6 = 2
            java.lang.Object r6 = r4.get(r6)     // Catch:{ ParseException -> 0x1402 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1402 }
            java.util.Date r6 = r0.parse(r6)     // Catch:{ ParseException -> 0x1402 }
            java.lang.String r6 = r5.format(r6)     // Catch:{ ParseException -> 0x1402 }
            android.widget.EditText r7 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x1402 }
            r7.setText(r6)     // Catch:{ ParseException -> 0x1402 }
            r6 = 3
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x1402 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x1402 }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ ParseException -> 0x1402 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x1402 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x1402 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x1402 }
            goto L_0x1406
        L_0x1402:
            r0 = move-exception
            r0.getMessage()
        L_0x1406:
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 0
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.id_card_number_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            java.lang.CharSequence r5 = r0.getText()
            java.lang.String r5 = r5.toString()
            r0.setText(r5)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r4)
            goto L_0x19c7
        L_0x142a:
            r0 = 0
            java.lang.String r4 = r1.E
            boolean r4 = r4.equals(r10)
            if (r4 == 0) goto L_0x1455
            android.widget.TextView r4 = r1.special_concession_list_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.tv_conc_dob_lap2
            r5 = 8
            r4.setVisibility(r5)
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2
            r4.setVisibility(r5)
            android.widget.LinearLayout r4 = r1.ll_passport_lap2
            r4.setVisibility(r5)
            android.widget.LinearLayout r4 = r1.spc_concession_layout_lap2
            r4.setVisibility(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r5)
            goto L_0x19c7
        L_0x1455:
            java.lang.String r0 = r1.E
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x154d
            android.widget.EditText r0 = r1.passengerName
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.passengerAge
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.passengerName
            r4 = 0
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.passengerAge
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.passengerAge
            r5 = 0
            r0.setError(r5)
            android.widget.RadioGroup r0 = r1.genderGroup
            r0.setEnabled(r4)
            android.widget.RadioGroup r0 = r1.genderGroup
            android.content.res.Resources r5 = r17.getResources()
            r6 = 2131099888(0x7f0600f0, float:1.7812142E38)
            int r5 = r5.getColor(r6)
            r0.setBackgroundColor(r5)
            android.widget.TextView r0 = r1.male
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.feMale
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.transGender
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            r0.setEnabled(r4)
            android.widget.RelativeLayout r0 = r1.specialConcessionRl
            android.content.res.Resources r6 = r17.getResources()
            int r6 = r6.getColor(r5)
            r0.setBackgroundColor(r6)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x19c7
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 0
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r5 = 0
            r0.setEnabled(r5)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            defpackage.C0709Uj.p(r1, r4, r0)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            r0.setEnabled(r5)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            android.content.res.Resources r5 = r17.getResources()
            int r4 = r5.getColor(r4)
            r0.setBackgroundColor(r4)
            goto L_0x19c7
        L_0x154d:
            r0 = 0
            java.lang.String r4 = r1.E
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x16ad
            android.widget.LinearLayout r4 = r1.spc_concession_layout_lap2
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.special_concession_list_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r4.setVisibility(r0)
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2
            r4.setVisibility(r0)
            android.widget.TextView r4 = r1.id_card_types_lap2
            r4.setVisibility(r0)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r4 = 8
            r0.setVisibility(r4)
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            if (r0 == 0) goto L_0x15e0
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            short r0 = r0.shortValue()
            if (r0 != 0) goto L_0x15e0
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x15e0
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            r7 = 2
            java.lang.Object r6 = r6.get(r7)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            android.widget.EditText r6 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            r6.setText(r0)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            android.widget.EditText r0 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            r0.setText(r4)     // Catch:{ ParseException -> 0x15dc, Exception -> 0x15d7 }
            goto L_0x15e0
        L_0x15d7:
            r0 = move-exception
            r0.getMessage()
            goto L_0x15e0
        L_0x15dc:
            r0 = move-exception
            r0.getMessage()
        L_0x15e0:
            android.widget.EditText r0 = r1.spc_card_number_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 0
            r0.setEnabled(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            java.lang.String r0 = r0.getPsgnConcDOB()
            if (r0 == 0) goto L_0x1610
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.lf.s(r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x161c
        L_0x1610:
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setText(r14)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r4 = 8
            r0.setVisibility(r4)
        L_0x161c:
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r4 = 0
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r5, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r5, r0)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            android.content.res.Resources r4 = r17.getResources()
            int r4 = r4.getColor(r5)
            r0.setBackgroundColor(r4)
            Yl r0 = defpackage.C1450w1.c()
            if (r0 == 0) goto L_0x16a5
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            if (r0 == 0) goto L_0x16a5
            Yl r0 = defpackage.C1450w1.c()
            java.lang.Short r0 = r0.getSpouseStatus()
            short r0 = r0.shortValue()
            r4 = 1
            if (r0 != r4) goto L_0x16a5
            android.widget.RadioGroup r0 = r1.genderGroup
            r4 = 0
            r0.setEnabled(r4)
            android.widget.RadioGroup r0 = r1.genderGroup
            android.content.res.Resources r5 = r17.getResources()
            r6 = 2131099888(0x7f0600f0, float:1.7812142E38)
            int r5 = r5.getColor(r6)
            r0.setBackgroundColor(r5)
            android.widget.TextView r0 = r1.male
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.feMale
            r0.setEnabled(r4)
            android.widget.TextView r0 = r1.transGender
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            r0.setEnabled(r4)
            android.widget.RelativeLayout r0 = r1.special_concession_rl_lap2
            android.content.res.Resources r6 = r17.getResources()
            int r5 = r6.getColor(r5)
            r0.setBackgroundColor(r5)
            goto L_0x16a6
        L_0x16a5:
            r4 = 0
        L_0x16a6:
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            goto L_0x19c7
        L_0x16ad:
            java.lang.String r4 = r1.E
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x1761
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x
            if (r4 == 0) goto L_0x1706
            android.widget.EditText r5 = r1.spc_card_number_lap2
            java.lang.Object r0 = r4.get(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            r7 = 2
            java.lang.Object r6 = r6.get(r7)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            r6.setText(r4)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            r4.setText(r0)     // Catch:{ ParseException -> 0x1702, Exception -> 0x16fd }
            goto L_0x1706
        L_0x16fd:
            r0 = move-exception
            r0.getMessage()
            goto L_0x1706
        L_0x1702:
            r0 = move-exception
            r0.getMessage()
        L_0x1706:
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r4 = 0
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x19c7
        L_0x1761:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "MPBLES"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x1818
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x17bd
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            r7 = 2
            java.lang.Object r6 = r6.get(r7)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            r6.setText(r4)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x17b9, Exception -> 0x17b4 }
            goto L_0x17bd
        L_0x17b4:
            r0 = move-exception
            r0.getMessage()
            goto L_0x17bd
        L_0x17b9:
            r0 = move-exception
            r0.getMessage()
        L_0x17bd:
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r4 = 0
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x19c7
        L_0x1818:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "EXMP"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x18cf
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x1874
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            r7 = 2
            java.lang.Object r6 = r6.get(r7)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            r6.setText(r4)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            r4.setText(r0)     // Catch:{ ParseException -> 0x1870, Exception -> 0x186b }
            goto L_0x1874
        L_0x186b:
            r0 = move-exception
            r0.getMessage()
            goto L_0x1874
        L_0x1870:
            r0 = move-exception
            r0.getMessage()
        L_0x1874:
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r4 = 0
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x19c7
        L_0x18cf:
            java.lang.String r0 = r1.E
            java.lang.String r4 = "EXCOMP"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x19c7
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x192b
            android.widget.EditText r4 = r1.spc_card_number_lap2
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r13, r4)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r12, r4)
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            r6 = 1
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            android.widget.EditText r6 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            r6.setText(r4)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            java.util.ArrayList<java.lang.String> r4 = r1.f5019x     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            r6 = 2
            java.lang.Object r4 = r4.get(r6)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            android.widget.EditText r4 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            r4.setText(r0)     // Catch:{ ParseException -> 0x1927, Exception -> 0x1922 }
            goto L_0x192b
        L_0x1922:
            r0 = move-exception
            r0.getMessage()
            goto L_0x192b
        L_0x1927:
            r0 = move-exception
            r0.getMessage()
        L_0x192b:
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r4 = 0
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.nationalityLayout
            r5 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.p(r1, r5, r0)
            android.widget.RelativeLayout r0 = r1.nationalityRl
            r0.setEnabled(r4)
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r5 = 8
            r0.setVisibility(r5)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setEnabled(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r4 = 2131099888(0x7f0600f0, float:1.7812142E38)
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            defpackage.C0709Uj.o(r1, r4, r0)
            goto L_0x19c7
        L_0x1985:
            android.widget.LinearLayout r0 = r1.spConcessionLayout
            r4 = 8
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.specialConcesionType
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spcCardnumber
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splCardValidity
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.splDOB
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r0.setVisibility(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x19c7
            android.widget.LinearLayout r0 = r1.spc_concession_layout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.special_concession_list_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.spc_card_number_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            r0.setVisibility(r4)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r4)
        L_0x19c7:
            java.lang.String r0 = S
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1a25
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            if (r0 == 0) goto L_0x1a25
            java.lang.String r0 = r0.getPsgnConcType()
            if (r0 == 0) goto L_0x1a25
            java.lang.String r0 = r1.E
            java.lang.String r2 = r2.trim()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x1a25
            android.widget.EditText r0 = r1.idCardNumber
            r2 = 2131951781(0x7f1300a5, float:1.9539986E38)
            java.lang.String r3 = r1.getString(r2)
            r0.setHint(r3)
            android.widget.EditText r0 = r1.idCardNumber
            r3 = 0
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.idCardType
            r0.setVisibility(r3)
            b3 r0 = f4886a
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x1a09
            android.widget.LinearLayout r0 = r1.cardIDLayout
            r0.setVisibility(r3)
        L_0x1a09:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x1a25
            android.widget.EditText r0 = r1.id_card_number_lap2
            java.lang.String r2 = r1.getString(r2)
            r0.setHint(r2)
            android.widget.EditText r0 = r1.id_card_number_lap2
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.id_card_types_lap2
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.ll_passport_lap2
            r0.setVisibility(r3)
        L_0x1a25:
            r17.A0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PassengerDetailFragment.Y0(boolean):void");
    }

    public final void Z0() {
        if (f4886a.getConcessionalPassengerType() != null) {
            Iterator<String> it = f4886a.getConcessionalPassengerType().iterator();
            while (it.hasNext()) {
                String next = it.next();
                int g2 = xx.g(next);
                if (g2 != 0) {
                    this.f4999n.add(xx.t(g2));
                } else {
                    this.f4999n.add(next);
                }
            }
            if (!this.f4936a.booleanValue()) {
                if (this.f4928a.d.equals("PH")) {
                    this.j = this.f4999n.size() + this.j;
                } else {
                    this.j = f4889c.get(0).getMaxPassengers();
                }
            }
        }
        if (C0535I5.f3647h && b.getConcessionalPassengerType() != null) {
            Iterator<String> it2 = b.getConcessionalPassengerType().iterator();
            while (it2.hasNext()) {
                this.f5002o.add(xx.t(xx.g(it2.next())));
            }
            if (!this.f4936a.booleanValue()) {
                this.j = this.f5002o.size() + this.j;
            }
        }
    }

    public final void a1() {
        Iterator<MealItemDetails> it = this.f4890A.iterator();
        while (it.hasNext()) {
            MealItemDetails next = it.next();
            next.getMealRate();
            next.getQuantity();
        }
    }

    @OnFocusChange({2131361956})
    public void areaLocalityVerify(View view) {
        if (!this.areaLocality.hasFocus()) {
            String d1 = d1(this.areaLocality.getText().toString(), "Area/Locality");
            if (d1.equalsIgnoreCase("ok")) {
                G0(4);
                this.f4935a.setArea(this.areaLocality.getText().toString());
                return;
            }
            N0(4, d1);
        }
    }

    public final void b0() {
        if (!f4886a.isBedRollFlagEnabled()) {
            this.bedRollLayout.setVisibility(8);
        } else if (!this.f4994l || this.f4930a.getPassengerAge().shortValue() < f4886a.getMinPassengerAge() || this.f4930a.getPassengerAge().shortValue() > f4886a.getMaxChildAge()) {
            this.bedRollLayout.setVisibility(0);
        } else if (this.f4930a.getChildBerthFlag() == null || !this.f4930a.getChildBerthFlag().booleanValue()) {
            this.bedRollLayout.setVisibility(8);
        } else {
            this.bedRollLayout.setVisibility(0);
        }
        if (this.f4994l) {
            if (this.f4930a.getPassengerBedrollChoice() == null || !this.f4930a.getPassengerBedrollChoice().equals("true")) {
                this.bedRoll.setChecked(false);
            } else {
                this.bedRoll.setChecked(true);
            }
        }
        if (C0535I5.f3647h) {
            if (!b.isBedRollFlagEnabled()) {
                this.is_bedroll_ll_lap2.setVisibility(8);
            } else if (!this.f4994l || this.f4949b.getPassengerAge().shortValue() < b.getMinPassengerAge() || this.f4949b.getPassengerAge().shortValue() > b.getMaxChildAge()) {
                this.is_bedroll_ll_lap2.setVisibility(0);
            } else if (this.f4949b.getChildBerthFlag() == null || !this.f4949b.getChildBerthFlag().booleanValue()) {
                this.is_bedroll_ll_lap2.setVisibility(8);
            } else {
                this.is_bedroll_ll_lap2.setVisibility(0);
            }
            if (!this.f4994l) {
                return;
            }
            if (this.f4949b.getPassengerBedrollChoice() == null || !this.f4949b.getPassengerBedrollChoice().equals("true")) {
                this.is_bad_berth_lap2.setChecked(false);
            } else {
                this.is_bad_berth_lap2.setChecked(true);
            }
        }
    }

    public final void c0() {
        this.f5014t.add(getString(cris.org.in.prs.ima.R.string.No_Preference));
        this.berthPreference.setText(getString(cris.org.in.prs.ima.R.string.Select_Berth_Preference));
        if (C0535I5.f3647h) {
            this.f5016u.add(getString(cris.org.in.prs.ima.R.string.No_Preference));
            this.berth_preference_lap2.setText(getString(cris.org.in.prs.ima.R.string.Select_Berth_Preference));
            ArrayList<String> arrayList = this.f5012s;
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f5016u.add(I9.j(it.next()).a());
                }
            }
        }
        ArrayList<String> arrayList2 = this.f5009r;
        if (arrayList2 != null) {
            Iterator<String> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                this.f5014t.add(I9.j(it2.next()).a());
            }
        }
        if (f4886a.isChildBerthMandatory()) {
            if (!this.f4994l) {
                this.isChildBerthReq.setChecked(true);
            } else if (this.isChildBerthReq.isChecked() || (this.f4930a.getChildBerthFlag() != null && this.f4930a.getChildBerthFlag().booleanValue())) {
                this.isChildBerthReq.setChecked(true);
            } else {
                this.isChildBerthReq.setChecked(false);
            }
            this.berthPreference.setVisibility(0);
        }
        if (C0535I5.f3647h && b.isChildBerthMandatory()) {
            if (!this.f4994l) {
                this.is_childBerth_req_lap2.setChecked(false);
            } else if (this.is_childBerth_req_lap2.isChecked() || (this.f4949b.getChildBerthFlag() != null && this.f4949b.getChildBerthFlag().booleanValue())) {
                this.is_childBerth_req_lap2.setChecked(true);
            } else {
                this.is_childBerth_req_lap2.setChecked(false);
            }
            this.berthPreference.setVisibility(0);
        }
    }

    public final String c1() {
        String obj = this.et_address1.getText().toString();
        if (obj.equalsIgnoreCase("")) {
            return getString(cris.org.in.prs.ima.R.string.Enter_Address);
        }
        if (obj.matches(this.f5015u)) {
            return "ok";
        }
        return getString(cris.org.in.prs.ima.R.string.invalid_character);
    }

    public final void d0() {
        Iterator<PassengerDetailDTO> it = this.f4963c.iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (it.hasNext()) {
            PassengerDetailDTO next = it.next();
            if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals(ExpandedProductParsedResult.POUND)) {
                i2++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("MB")) {
                i3++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("UB")) {
                i4++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("SL")) {
                i5++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("SU")) {
                i6++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("WS")) {
                i7++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("AS")) {
                i8++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("CB")) {
                i9++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("CP")) {
                i10++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("HB")) {
                i11++;
            } else if (next.getPassengerBerthChoice() != null && next.getPassengerBerthChoice().equals("SM")) {
                i12++;
            }
            Bw bw = this.f4898a;
            if (Integer.parseInt(bw.t()) > 0 && i6 > Integer.parseInt(bw.t())) {
                x0(I9.e.a(), Integer.valueOf(Integer.parseInt(bw.t())));
                return;
            } else if (Integer.parseInt(bw.r()) > 0 && i5 > Integer.parseInt(bw.r())) {
                x0(I9.d.a(), Integer.valueOf(Integer.parseInt(bw.r())));
                return;
            } else if (Integer.parseInt(bw.p()) > 0 && i2 > Integer.parseInt(bw.p())) {
                x0(I9.a.a(), Integer.valueOf(Integer.parseInt(bw.p())));
                return;
            } else if (Integer.parseInt(bw.u()) > 0 && i4 > Integer.parseInt(bw.u())) {
                x0(I9.c.a(), Integer.valueOf(Integer.parseInt(bw.u())));
                return;
            } else if (Integer.parseInt(bw.q()) > 0 && i3 > Integer.parseInt(bw.q())) {
                x0(I9.b.a(), Integer.valueOf(Integer.parseInt(bw.q())));
                return;
            } else if (Integer.parseInt(bw.v()) > 0 && i7 > Integer.parseInt(bw.v())) {
                x0(I9.f.a(), Integer.valueOf(Integer.parseInt(bw.v())));
                return;
            } else if (Integer.parseInt(bw.l()) > 0 && i8 > Integer.parseInt(bw.l())) {
                x0(I9.g.a(), Integer.valueOf(Integer.parseInt(bw.l())));
                return;
            } else if (Integer.parseInt(bw.m()) > 0 && i9 > Integer.parseInt(bw.m())) {
                x0(I9.h.a(), Integer.valueOf(Integer.parseInt(bw.m())));
                return;
            } else if (Integer.parseInt(bw.n()) > 0 && i10 > Integer.parseInt(bw.n())) {
                x0(I9.i.a(), Integer.valueOf(Integer.parseInt(bw.n())));
                return;
            } else if (Integer.parseInt(bw.o()) > 0 && i11 > Integer.parseInt(bw.o())) {
                x0(I9.j.a(), Integer.valueOf(Integer.parseInt(bw.o())));
                return;
            } else if (Integer.parseInt(bw.s()) > 0 && i12 > Integer.parseInt(bw.s())) {
                x0(I9.k.a(), Integer.valueOf(Integer.parseInt(bw.s())));
                return;
            }
        }
    }

    public final String d1(String str, String str2) {
        String trim = str.trim();
        if (trim == null || trim.equals("")) {
            return "ok";
        }
        if (trim.matches(this.f4977g)) {
            StringBuilder J2 = xx.J(str2);
            J2.append(getString(cris.org.in.prs.ima.R.string.should_contain_least_one_alphabet));
            return J2.toString();
        } else if (str2.compareToIgnoreCase("Area/Locality") == 0 && (trim.length() < 3 || trim.length() > 100)) {
            StringBuilder n2 = lf.n(str2, " ");
            n2.append(getString(cris.org.in.prs.ima.R.string.length_3_100_characters));
            return n2.toString();
        } else if (trim.length() >= 3 && trim.length() <= 30) {
            return "ok";
        } else {
            StringBuilder n3 = lf.n(str2, " ");
            n3.append(getString(cris.org.in.prs.ima.R.string.length_3_30_characters));
            return n3.toString();
        }
    }

    public final void e0() {
        if (lf.e(this.passengerAge) != 0) {
            if (C0709Uj.m(this.passengerAge) > f4886a.getMaxChildAge() || C0709Uj.m(this.passengerAge) < f4886a.getMinPassengerAge() || s) {
                this.isChildBerthReq.setChecked(false);
                this.isChildBerthReq.setVisibility(8);
                this.isChildBerthll.setVisibility(8);
            } else if (!f4886a.isChildBerthMandatory() || C0709Uj.m(this.passengerAge) > f4886a.getMaxChildAge()) {
                this.isChildBerthll.setVisibility(0);
                this.isChildBerthReq.setVisibility(0);
                this.isChildBerthReq.setChecked(false);
                if (!this.isChildBerthReq.isChecked()) {
                    this.isChildBerthReq.setChecked(true);
                    this.isChildBerthReq.setVisibility(0);
                    this.isChildBerthll.setVisibility(0);
                } else {
                    this.isChildBerthReq.setChecked(false);
                    this.isChildBerthReq.setVisibility(0);
                    this.isChildBerthll.setVisibility(0);
                }
            } else {
                this.isChildBerthReq.setVisibility(8);
                this.isChildBerthll.setVisibility(8);
                this.isChildBerthReq.setChecked(true);
            }
            if (!C0535I5.f3647h) {
                return;
            }
            if (C0709Uj.m(this.passengerAge) > b.getMaxChildAge() || C0709Uj.m(this.passengerAge) < b.getMinPassengerAge()) {
                this.is_childBerth_req_lap2.setChecked(false);
                this.is_childBerth_req_lap2.setVisibility(8);
                this.is_childBerth_ll_lap2.setVisibility(8);
            } else if (!b.isChildBerthMandatory() || C0709Uj.m(this.passengerAge) > b.getMaxChildAge()) {
                this.is_childBerth_ll_lap2.setVisibility(0);
                this.is_childBerth_req_lap2.setVisibility(0);
                if (!this.is_childBerth_req_lap2.isChecked()) {
                    this.is_childBerth_req_lap2.setVisibility(0);
                    this.is_childBerth_ll_lap2.setVisibility(0);
                    return;
                }
                this.is_childBerth_req_lap2.setVisibility(0);
                this.is_childBerth_ll_lap2.setVisibility(0);
            } else {
                this.is_childBerth_req_lap2.setVisibility(8);
                this.is_childBerth_ll_lap2.setVisibility(8);
                this.is_childBerth_req_lap2.setChecked(true);
            }
        } else {
            this.isChildBerthReq.setVisibility(0);
            this.isChildBerthll.setVisibility(0);
            this.isChildBerthReq.setChecked(false);
            if (C0535I5.f3647h) {
                this.is_childBerth_req_lap2.setVisibility(0);
                this.is_childBerth_ll_lap2.setVisibility(0);
            }
        }
    }

    public final boolean e1() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String c1 = c1();
        if (c1.equalsIgnoreCase("ok")) {
            G0(9);
            z2 = true;
        } else {
            N0(9, c1);
            z2 = false;
        }
        String i1 = i1(this.et_psgn_pincode.getText().toString());
        if (i1.equalsIgnoreCase("ok")) {
            G0(10);
            z3 = true;
        } else {
            N0(10, i1);
            z3 = false;
        }
        if (!this.f4943a) {
            this.et_city_town.setError("Select City");
            z4 = false;
        } else {
            this.et_city_town.setError((CharSequence) null);
            z4 = true;
        }
        if (!this.f4985i) {
            this.et_post_office.setError("Select Post Office");
            z5 = false;
        } else {
            this.et_post_office.setError((CharSequence) null);
            z5 = true;
        }
        if (!z2 || !z3 || !z4 || !z5) {
            return false;
        }
        return true;
    }

    @OnFocusChange({2131362514})
    public void et_address(View view) {
        if (!this.et_address1.hasFocus()) {
            String c1 = c1();
            if (c1.equalsIgnoreCase("ok")) {
                G0(9);
            } else {
                N0(9, c1);
            }
        }
    }

    public final void f0(int i2, String str) {
        ((TextView) this.f4906a.findViewById(i2)).setBackground(getResources().getDrawable(getResources().getIdentifier(str, "drawable", this.f4906a.getPackageName())));
    }

    public final String f1() {
        if (this.gstinNumber.getText().toString() == null || this.gstinNumber.getText().toString().trim().equals("")) {
            return getString(cris.org.in.prs.ima.R.string.Enter_GSTIN_Number);
        }
        if (f4887a.matcher(this.gstinNumber.getText().toString()).find()) {
            return "ok";
        }
        return getString(cris.org.in.prs.ima.R.string.Invalid_GSTIN);
    }

    @OnFocusChange({2131362685})
    public void flaDoorBlockVerify(View view) {
        if (!this.flatDoorBlock.hasFocus()) {
            String j1 = j1(this.flatDoorBlock.getText().toString());
            if (j1.equalsIgnoreCase("ok")) {
                G0(2);
                this.f4935a.setFlat(this.flatDoorBlock.getText().toString());
                return;
            }
            N0(2, j1);
        }
    }

    public final void g0(String str) {
        if (str.equals(getString(cris.org.in.prs.ima.R.string.India)) || !f4889c.get(0).isTravelInsuranceEnabled()) {
            this.nationality.setText(str);
        } else {
            C0709Uj.q(this, cris.org.in.prs.ima.R.string.OK, getActivity(), getString(cris.org.in.prs.ima.R.string.insurance_foreigner), (DialogInterface.OnClickListener) null);
            this.nationality.setText(str);
        }
        HashMap<String, String> hashMap = this.f4941a;
        if (hashMap != null && hashMap.containsKey(str)) {
            this.x = this.f4941a.get(str);
        }
        if (!this.x.equals("IN")) {
            if (!(this.g == 0 || this.h == 0)) {
                C0709Uj.q(this, cris.org.in.prs.ima.R.string.OK, getActivity(), getString(cris.org.in.prs.ima.R.string.Senior_Citizen_concession_applicable_only_indian), (DialogInterface.OnClickListener) null);
                this.g = 0;
                this.h = 0;
                this.srctznConcession.setText(xx.a(xx.j(0)));
                if (C0535I5.f3647h) {
                    this.srctzn_concession_lap2.setText(xx.a(xx.j(this.g)));
                }
            }
            Y0(false);
            this.passportnumber_ft.setHint(getString(cris.org.in.prs.ima.R.string.id_card_number));
            this.idCardType.setVisibility(8);
            this.id_card_types_lap2.setVisibility(8);
            this.passportnumber_ft.setVisibility(0);
            this.cardIDLayout.setVisibility(8);
            this.ll_passport_lap2.setVisibility(8);
            this.tv_dob_ft.setVisibility(0);
            this.tv_dob_ft.setText("");
            EditText editText = this.passportnumber_ft;
            FragmentActivity activity = getActivity();
            short maxPassportLength = f4886a.getMaxPassportLength();
            AlertDialog alertDialog = C0535I5.f3619a;
            editText.addTextChangedListener(new C0479D5(activity, maxPassportLength));
            ((EditText) this.f4906a.findViewById(cris.org.in.prs.ima.R.id.id_passportnumber_ft)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(f4886a.getMaxPassportLength())});
            return;
        }
        this.passportnumber_ft.setVisibility(8);
        this.tv_dob_ft.setVisibility(8);
        this.idCardNumber.setVisibility(8);
        this.id_card_number_lap2.setVisibility(8);
        if (xx.T(this.passengerAge, "") || this.F == null || (((C0709Uj.m(this.passengerAge) < f4886a.getSrctznAge() || !this.F.equals("M")) && ((C0709Uj.m(this.passengerAge) < f4886a.getSrctnwAge() || !this.F.equals("F")) && (C0709Uj.m(this.passengerAge) < f4886a.getSrctzTAge() || !this.F.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T)))) || !f4886a.isSeniorCitizenApplicable())) {
            X0(false);
        } else {
            X0(true);
        }
        Y0(true);
    }

    public final boolean g1() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        boolean z7;
        boolean z8;
        String i1 = i1(this.pinCode.getText().toString());
        if (i1.equalsIgnoreCase("ok")) {
            G0(1);
            z2 = true;
        } else {
            N0(1, i1);
            z2 = false;
        }
        String j1 = j1(this.flatDoorBlock.getText().toString());
        if (j1.equalsIgnoreCase("ok")) {
            G0(2);
            z3 = true;
        } else {
            N0(2, j1);
            z3 = false;
        }
        String d1 = d1(this.streetLane.getText().toString(), "Street/Lane");
        if (d1.equalsIgnoreCase("ok")) {
            G0(3);
            z4 = true;
        } else {
            N0(3, d1);
            z4 = false;
        }
        String d12 = d1(this.areaLocality.getText().toString(), "Area/Locality");
        if (d12.equalsIgnoreCase("ok")) {
            G0(4);
            z5 = true;
        } else {
            N0(4, d12);
            z5 = false;
        }
        String h1 = h1();
        if (h1.equalsIgnoreCase("ok")) {
            G0(6);
            z6 = true;
        } else {
            N0(6, h1);
            z6 = false;
        }
        if (this.city.getText().toString() == "City") {
            str = "Please Select City";
        } else {
            str = "ok";
        }
        if (str.equalsIgnoreCase("ok")) {
            G0(7);
            z7 = true;
        } else {
            N0(7, str);
            z7 = false;
        }
        String f1 = f1();
        if (f1.equalsIgnoreCase("ok")) {
            G0(8);
            z8 = true;
        } else {
            N0(8, f1);
            z8 = false;
        }
        this.f4935a.setState(this.state.getText().toString());
        this.f4935a.setCity(this.city.getText().toString());
        this.f4935a.setGstIn(this.gstinNumber.getText().toString());
        if (!z2 || !z3 || !z4 || !z5 || !z6 || !z7 || !z8) {
            return false;
        }
        return true;
    }

    @OnFocusChange({2131362747})
    public void gstinValidate(View view) {
        if (!this.gstinNumber.hasFocus()) {
            if (this.gstinNumber.length() == 0) {
                this.gstpassengerName.setText("");
                this.flatDoorBlock.setText("");
                this.streetLane.setText("");
                this.areaLocality.setText("");
                this.pinCode.setText("");
                this.state.setText("");
                this.city.setText("City");
                this.gstpassengerName.setEnabled(false);
                this.flatDoorBlock.setEnabled(false);
                this.streetLane.setEnabled(false);
                this.areaLocality.setEnabled(false);
                this.pinCode.setEnabled(false);
                this.state.setEnabled(false);
                this.city.setEnabled(false);
                j0();
                G0(1);
                G0(2);
                G0(3);
                G0(4);
                G0(6);
                G0(7);
                G0(8);
                return;
            }
            String f1 = f1();
            if (f1.equalsIgnoreCase("ok")) {
                C1133ge geVar = new C1133ge();
                this.f4935a = geVar;
                geVar.setGstIn(this.gstinNumber.getText().toString());
                this.gstpassengerName.setEnabled(true);
                this.flatDoorBlock.setEnabled(true);
                this.streetLane.setEnabled(true);
                this.areaLocality.setEnabled(true);
                this.pinCode.setEnabled(true);
                this.state.setEnabled(true);
                this.city.setEnabled(true);
                k0();
                G0(8);
                return;
            }
            this.gstpassengerName.setEnabled(false);
            this.flatDoorBlock.setEnabled(false);
            this.streetLane.setEnabled(false);
            this.areaLocality.setEnabled(false);
            this.pinCode.setEnabled(false);
            this.state.setEnabled(false);
            this.city.setEnabled(false);
            j0();
            N0(8, f1);
        }
    }

    public final void h0() {
        if (AllTrainListFragment.i) {
            this.passengerName.setEnabled(false);
            this.passengerName.setOnClickListener(new A());
            C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.passengerName);
            this.childAge.setEnabled(false);
            this.childAge.setOnClickListener(new B());
            this.childAge.setBackgroundColor(getResources().getColor(cris.org.in.prs.ima.R.color.light_gray));
            this.childMale.setEnabled(false);
            this.childfeMale.setEnabled(false);
            this.childTrangender.setEnabled(false);
            this.nationality.setEnabled(false);
            this.nationality.setOnClickListener(new C());
            this.nationality.setBackgroundColor(getResources().getColor(cris.org.in.prs.ima.R.color.light_gray));
        }
    }

    public final String h1() {
        if (lf.e(this.gstpassengerName) == 0) {
            return getString(cris.org.in.prs.ima.R.string.enter_name_on_GSTIN);
        }
        if (lf.e(this.gstpassengerName) < 3 || lf.e(this.gstpassengerName) > 90) {
            return getString(cris.org.in.prs.ima.R.string.name_length_3_90_characters);
        }
        return "ok";
    }

    public final void i0() {
        if (AllTrainListFragment.i) {
            this.passengerName.setEnabled(false);
            this.passengerName.setOnClickListener(new D());
            C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.passengerName);
            this.passengerAge.setEnabled(false);
            this.passengerAge.setOnClickListener(new F());
            C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.passengerAge);
            this.male.setEnabled(false);
            this.feMale.setEnabled(false);
            this.transGender.setEnabled(false);
            this.nationality.setEnabled(false);
            this.nationality.setOnClickListener(new G());
            this.nationality.setBackgroundColor(getResources().getColor(cris.org.in.prs.ima.R.color.light_gray));
        }
    }

    public final String i1(String str) {
        if (str == null || str.equals("")) {
            return getString(cris.org.in.prs.ima.R.string.enter_PIN_code);
        }
        if (str.matches(this.H)) {
            return getString(cris.org.in.prs.ima.R.string.All_zeros_not_allowed);
        }
        if (str.length() != 6) {
            return "Pin code must be 6 characters.";
        }
        return "ok";
    }

    public final void j0() {
        f0(cris.org.in.prs.ima.R.id.gst_passenger_name, "@color/disable_gstin");
        f0(cris.org.in.prs.ima.R.id.flat_door_block, "@color/disable_gstin");
        f0(cris.org.in.prs.ima.R.id.street_lane, "@color/disable_gstin");
        f0(cris.org.in.prs.ima.R.id.area_locality, "@color/disable_gstin");
        f0(cris.org.in.prs.ima.R.id.et_pincode, "@color/disable_gstin");
        f0(cris.org.in.prs.ima.R.id.et_state_reg, "@color/disable_gstin");
        f0(cris.org.in.prs.ima.R.id.city_reg, "@color/disable_gstin");
    }

    public final String j1(String str) {
        String trim = str.trim();
        if (trim == null || trim.equals("")) {
            return "Please Enter Flat/Door/Block Details";
        }
        if (trim.matches(this.f4977g)) {
            return "Enter At least one alphabet.";
        }
        if (trim.length() < 3 || trim.length() > 30) {
            return "Flat/Door/Block  length should be between 3 and 30 characters.";
        }
        return "ok";
    }

    public final void k0() {
        f0(cris.org.in.prs.ima.R.id.passenger_name, "@color/transparent");
        f0(cris.org.in.prs.ima.R.id.flat_door_block, "@color/transparent");
        f0(cris.org.in.prs.ima.R.id.street_lane, "@color/transparent");
        f0(cris.org.in.prs.ima.R.id.area_locality, "@color/transparent");
        f0(cris.org.in.prs.ima.R.id.et_pincode, "@color/transparent");
        f0(cris.org.in.prs.ima.R.id.et_state_reg, "@color/transparent");
        f0(cris.org.in.prs.ima.R.id.city_reg, "@color/white_90_opa");
    }

    public final void l0(boolean z2) {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4904a)) {
            new Handler().postDelayed(new b0(), 5000);
            return;
        }
        G = C0535I5.f3632c;
        if (C1450w1.b > f4886a.getMaxMasterListPsgn().intValue()) {
            this.existingpassenger_ll.setVisibility(8);
            this.masterpassengetList.setVisibility(8);
            this.errorMessage.setVisibility(8);
            if (!z2) {
                this.errorMessage.setVisibility(0);
                TextView textView = this.errorMessage;
                textView.setText(getString(cris.org.in.prs.ima.R.string.Your_masterlist_prescribed_limit) + " " + f4886a.getMaxMasterListPsgn() + " " + getString(cris.org.in.prs.ima.R.string.prescribed_limit_masterlist));
            }
            this.f4903a.dismiss();
            return;
        }
        ArrayList<MasterPassengerModel> arrayList = G;
        if (arrayList == null || arrayList.size() == 0) {
            if (G == null) {
                G = new ArrayList<>();
            }
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                this.f4903a = ProgressDialog.show(getActivity(), getString(cris.org.in.prs.ima.R.string.fetch_master_psgn), getString(cris.org.in.prs.ima.R.string.please_wait_text));
                Objects.toString(b1Var.f3912a);
                String f2 = C0657Qt.f();
                ((Om) C0657Qt.c(b1Var.f3912a)).A(f2 + "masterpsgnlistenquiry").c(C1181iv.a()).a(E0.a()).b(new c0(z2));
                return;
            }
            return;
        }
        this.existingpassenger_ll.setVisibility(0);
        this.f4991k = true;
        this.errorMessage.setVisibility(8);
        this.masterpassengetList.setVisibility(0);
        this.masterpassengetList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.masterpassengetList.setAdapter(new MasterPassengerViewHolder(this.f4904a, G, this.f4915a));
    }

    public final void m0() {
        if (f4886a.isFoodChoiceEnabled()) {
            this.mealPreferenceLayout.setVisibility(0);
            this.foodChoice.setVisibility(0);
            List<String> foodDetails = f4886a.getFoodDetails();
            this.f4954b = foodDetails;
            for (String charAt : foodDetails) {
                J9 i2 = J9.i(charAt.charAt(0));
                if (i2 != null) {
                    this.f4993l.add(i2.f());
                }
            }
            if (this.f4994l && this.f4930a.getPassengerFoodChoice() != null) {
                this.foodChoice.setText(J9.i(this.f4930a.getPassengerFoodChoice().charAt(0)).f());
                this.y = Character.toString(this.f4930a.getPassengerFoodChoice().charAt(0));
            }
        } else {
            this.mealPreferenceLayout.setVisibility(8);
        }
        if (!C0535I5.f3647h) {
            return;
        }
        if (b.isFoodChoiceEnabled()) {
            this.ll_meal_preference_lap2.setVisibility(0);
            this.f4954b = b.getFoodDetails();
            this.food_choice_lap2.setVisibility(0);
            for (String charAt2 : this.f4954b) {
                this.f4993l.add(J9.i(charAt2.charAt(0)).f());
            }
            if (this.f4994l && this.f4930a.getPassengerFoodChoice() != null) {
                this.food_choice_lap2.setText(J9.i(this.f4930a.getPassengerFoodChoice().charAt(0)).f());
                this.y = Character.toString(this.f4930a.getPassengerFoodChoice().charAt(0));
                return;
            }
            return;
        }
        this.ll_meal_preference_lap2.setVisibility(8);
    }

    public final String n0(String str, String str2) {
        new SimpleDateFormat();
        int indexOf = str.indexOf(45);
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(45, i2);
        return new SimpleDateFormat(str2).format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i2, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }

    @OnClick({2131364267})
    public void onAddBrackfastClick(View view) {
        this.add_meal_rl.setVisibility(0);
        this.lvaddmeal.setLayoutManager(new LinearLayoutManager(getContext()));
        Collections.sort(this.f4902a.getMealDetailsDTO().get(0).getMealDetailList(), new C0955l());
        this.lvaddmeal.setAdapter(new AddMealViewHolder(this.f4904a, this.f4902a.getMealDetailsDTO().get(0).getMealDetailList().get(0).getMealDetailList()));
    }

    @OnClick({2131364269})
    public void onAddDinnerClick(View view) {
        this.add_meal_rl.setVisibility(0);
        this.lvaddmeal.setLayoutManager(new LinearLayoutManager(getContext()));
        Collections.sort(this.f4902a.getMealDetailsDTO().get(0).getMealDetailList(), new C0958o());
        this.lvaddmeal.setAdapter(new AddMealViewHolder(this.f4904a, this.f4902a.getMealDetailsDTO().get(0).getMealDetailList().get(3).getMealDetailList()));
    }

    @OnClick({2131361915})
    public void onAddFevJourneyClocl(View view) {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4904a)) {
            new Handler().postDelayed(new To(), 5000);
            return;
        }
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).q1(this.f4929a.getFrom(), this.f4929a.getTo(), this.f4929a.getTrainNo(), this.f4929a.getQuota(), this.f4929a.getEnqClass()).c(C1181iv.a()).a(E0.a()).b(new C0710Uo(this, ProgressDialog.show(getActivity(), getString(cris.org.in.prs.ima.R.string.add_fav_jrny_list), getString(cris.org.in.prs.ima.R.string.please_wait_text))));
    }

    @OnClick({2131364434})
    public void onAddInfantClick(View view) {
        if (this.e < f4889c.get(0).getMaxInfants()) {
            s = false;
            this.f4994l = false;
            this.childAge.clearFocus();
            this.childPassengerName.getText().clear();
            this.genderChildGroup.clearCheck();
            this.childAge.setHint(getString(cris.org.in.prs.ima.R.string.Select_age_infant));
            this.childAge.setText("");
            this.f4937a = (byte) -1;
            this.f4896G = "";
            if (this.infantLayout.getVisibility() == 8) {
                this.infantLayout.setVisibility(0);
                ArrayList<String> arrayList = new ArrayList<>();
                this.f5018w = arrayList;
                arrayList.add(getString(cris.org.in.prs.ima.R.string.Below_1_Year));
                for (int i2 = 1; i2 < f4886a.getMinPassengerAge(); i2++) {
                    this.f5018w.add(String.valueOf(i2));
                }
                return;
            }
            this.infantLayout.setVisibility(8);
            return;
        }
        C0535I5.m(getActivity(), false, getResources().getString(cris.org.in.prs.ima.R.string.add_child_validation), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131364271})
    public void onAddInfantWithBerthDetailClick(View view) {
        s = true;
        this.titleName.setText(getResources().getString(cris.org.in.prs.ima.R.string.add_infant_with_berth_title));
        onAddPsgnDetailClick(view);
    }

    @OnClick({2131364272})
    public void onAddLunchClick(View view) {
        this.add_meal_rl.setVisibility(0);
        this.lvaddmeal.setLayoutManager(new LinearLayoutManager(getContext()));
        Collections.sort(this.f4902a.getMealDetailsDTO().get(0).getMealDetailList(), new C0956m());
        this.lvaddmeal.setAdapter(new AddMealViewHolder(this.f4904a, this.f4902a.getMealDetailsDTO().get(0).getMealDetailList().get(1).getMealDetailList()));
    }

    @OnClick({2131364477})
    public void onAddMasterPsgnClick(View view) {
        String Q2 = C0535I5.Q("SELECT_MASTER_LIST");
        if (Q2 != null) {
            FragmentActivity activity = getActivity();
            C0535I5.o(activity, getString(cris.org.in.prs.ima.R.string.master_list_not_allowed) + " " + Q2, "Ok", (DialogInterface.OnClickListener) null).show();
            return;
        }
        int i2 = C1450w1.b;
        if (i2 == 0) {
            C0709Uj.q(this, cris.org.in.prs.ima.R.string.OK, getActivity(), getString(cris.org.in.prs.ima.R.string.masterlist_no_psgn) + " " + getString(cris.org.in.prs.ima.R.string.add_passenger_for_masterlist), (DialogInterface.OnClickListener) null);
        } else if (i2 > f4886a.getMaxMasterListPsgn().intValue()) {
            C0709Uj.q(this, cris.org.in.prs.ima.R.string.OK, getActivity(), getString(cris.org.in.prs.ima.R.string.Your_masterlist_prescribed_limit) + " " + f4886a.getMaxMasterListPsgn() + " " + getString(cris.org.in.prs.ima.R.string.prescribed_limit_masterlist), (DialogInterface.OnClickListener) null);
        } else {
            this.f4991k = true;
            l0(false);
            MasterPassengerViewHolder.setNoOfMasterPsgnSelected(0);
            if (G.size() > 0) {
                Iterator<MasterPassengerModel> it = G.iterator();
                while (it.hasNext()) {
                    if (it.next().f5338a) {
                        a.setClickable(true);
                        C1058d.H(this.f4904a, cris.org.in.prs.ima.R.color.white, a);
                    } else {
                        a.setClickable(false);
                        C1058d.H(this.f4904a, cris.org.in.prs.ima.R.color.colorAccent, a);
                    }
                }
                this.existingpassenger_ll.setVisibility(0);
                return;
            }
            this.existingpassenger_ll.setVisibility(8);
        }
    }

    @OnClick({2131362621})
    public void onAddMasterPsgnGone(View view) {
        if (this.f4978g.size() == 0) {
            Iterator<MasterPassengerModel> it = G.iterator();
            while (it.hasNext()) {
                MasterPassengerModel next = it.next();
                if (next.f5338a) {
                    next.f5338a = false;
                }
            }
        } else {
            Iterator<MasterPassengerModel> it2 = G.iterator();
            while (it2.hasNext()) {
                MasterPassengerModel next2 = it2.next();
                if (this.f4894E.contains(next2.a.getMasterListId())) {
                    next2.f5338a = true;
                } else {
                    next2.f5338a = false;
                }
            }
        }
        this.existingpassenger_ll.setVisibility(8);
        MasterPassengerViewHolder.setNoOfMasterPsgnSelected(0);
    }

    @OnClick({2131364275})
    public void onAddPsgnDetailClick(View view) {
        if (!C1450w1.f7024c ? l < f4889c.get(0).getMaxPassengers() : l < this.j) {
            this.f4994l = false;
            this.et_pass_upn.getText().clear();
            this.et_pass_upn.setEnabled(true);
            this.et_pass_booking_code.getText().clear();
            this.et_pass_booking_code.setEnabled(true);
            if (s) {
                this.passengerAge.setHint(getResources().getString(cris.org.in.prs.ima.R.string.Age));
                this.passengerAge.setInputType(0);
                this.f5018w = new ArrayList<>();
                for (int i2 = 1; i2 < f4886a.getMinPassengerAge(); i2++) {
                    this.f5018w.add(String.valueOf(i2));
                }
            } else {
                this.passengerAge.setHint(getResources().getString(cris.org.in.prs.ima.R.string.Add_new_Age));
                this.passengerAge.setInputType(4098);
            }
            this.passengerAge.getText().clear();
            this.passengerAge.setError((CharSequence) null);
            this.passengerName.getText().clear();
            this.passengerName.setEnabled(true);
            this.passengerAge.setEnabled(true);
            this.male.setEnabled(true);
            this.feMale.setEnabled(true);
            this.transGender.setEnabled(true);
            lf.r(this.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, this.passengerName);
            lf.r(this.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, this.passengerAge);
            this.splDOB.getText().clear();
            this.splCardValidity.getText().clear();
            this.idCardNumber.getText().clear();
            this.spcCardnumber.getText().clear();
            this.berthPreference.setText(getString(cris.org.in.prs.ima.R.string.Select_Berth_Preference));
            this.srctznConcLayout.setVisibility(8);
            this.srctznConcession.setText(getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
            this.specialConcesionType.setText(getString(cris.org.in.prs.ima.R.string.Concession_Option));
            this.foodChoice.setText(getString(cris.org.in.prs.ima.R.string.catering_service_option));
            this.genderGroup.clearCheck();
            this.berthPreference.onCheckIsTextEditor();
            this.F = "";
            this.y = null;
            this.A = "NC";
            this.bedRoll.setChecked(false);
            this.isChildBerthReq.setChecked(false);
            this.isChildBerthll.setVisibility(8);
            this.donePsgnDetail.setText(getString(cris.org.in.prs.ima.R.string.add_psgn));
            this.E = "";
            y0();
            g0(this.nationality.getText().toString());
            this.spcCardnumber.setEnabled(true);
            this.splDOB.setEnabled(true);
            this.splCardValidity.setEnabled(true);
            this.titleName.requestFocus();
            this.idCardNumber.setVisibility(8);
            this.tv_dob_ft.setVisibility(8);
            this.tv_dob_ft.getText().clear();
            this.tv_dob_ft.setEnabled(true);
            this.passportnumber_ft.setVisibility(8);
            this.passportnumber_ft.getText().clear();
            this.passportnumber_ft.setEnabled(true);
            this.berthPreferenceLayout.setVisibility(0);
            this.passbooking_concession_list.setText("Pass Booking");
            if (S.equals("S")) {
                this.et_pass_booking_code.setVisibility(0);
                this.et_pass_upn.setVisibility(0);
                this.pass_booking_opt_msg.setVisibility(0);
            } else {
                this.et_pass_booking_code.setVisibility(8);
                this.et_pass_upn.setVisibility(8);
                this.pass_booking_opt_msg.setVisibility(8);
                if (C0535I5.f3647h) {
                    this.is_bad_berth_lap2.setChecked(false);
                    this.tv_lap1heading.setVisibility(0);
                    this.lap2_heading_ll.setVisibility(0);
                    this.berth_choice_ll_lap2.setVisibility(0);
                    this.tv_conc_dob_lap2.getText().clear();
                    this.tv_conc_cardvalidity_lap2.getText().clear();
                    this.id_card_number_lap2.getText().clear();
                    this.spc_card_number_lap2.getText().clear();
                    this.ll_srctzn_concession_lap2.setVisibility(8);
                    this.srctzn_concession_lap2.setText(getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
                    this.special_concession_list_lap2.setText(getString(cris.org.in.prs.ima.R.string.Concession_Option));
                    this.food_choice_lap2.setText(getString(cris.org.in.prs.ima.R.string.catering_service_option));
                    this.berth_preference_lap2.setText(getString(cris.org.in.prs.ima.R.string.Select_Berth_Preference));
                    this.berth_preference_lap2.onCheckIsTextEditor();
                    this.z = null;
                    this.is_childBerth_req_lap2.setChecked(false);
                    this.is_childBerth_ll_lap2.setVisibility(8);
                    this.spc_card_number_lap2.setEnabled(true);
                    this.tv_conc_dob_lap2.setEnabled(true);
                    this.tv_conc_cardvalidity_lap2.setEnabled(true);
                    this.id_card_number_lap2.setVisibility(8);
                }
            }
            lf.r(this.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, this.passengerName);
            lf.r(this.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, this.passengerAge);
            this.passengerName.setEnabled(true);
            this.passengerAge.setEnabled(true);
            this.male.setEnabled(true);
            this.feMale.setEnabled(true);
            this.transGender.setEnabled(true);
            this.spConcessionLayout.setEnabled(true);
            this.genderGroup.setEnabled(true);
            this.genderGroup.setBackgroundColor(getResources().getColor(cris.org.in.prs.ima.R.color.white));
            C0709Uj.p(this, cris.org.in.prs.ima.R.color.white, this.spConcessionLayout);
            this.nationalityRl.setEnabled(true);
            if (C0535I5.f3647h) {
                this.spc_concession_layout_lap2.setEnabled(true);
                C0709Uj.p(this, cris.org.in.prs.ima.R.color.white, this.spc_concession_layout_lap2);
            }
            if (C1450w1.f7024c) {
                this.spcCardnumber.setEnabled(false);
                this.splDOB.setEnabled(false);
                this.splCardValidity.setEnabled(false);
                C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.spcCardnumber);
                C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.splCardValidity);
                C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.splDOB);
                this.nationalityLayout.setEnabled(false);
                C0709Uj.p(this, cris.org.in.prs.ima.R.color.light_gray, this.nationalityLayout);
                this.nationalityRl.setEnabled(false);
                this.F = "M";
                this.male.performClick();
                this.male.setSelected(true);
                if (C0535I5.f3647h) {
                    this.spc_card_number_lap2.setEnabled(false);
                    this.tv_conc_dob_lap2.setEnabled(false);
                    this.tv_conc_cardvalidity_lap2.setEnabled(false);
                    C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.spc_card_number_lap2);
                    C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.tv_conc_cardvalidity_lap2);
                    C0709Uj.o(this, cris.org.in.prs.ima.R.color.light_gray, this.tv_conc_dob_lap2);
                }
            }
            if (this.addpassenger_rl.getVisibility() == 8) {
                this.addpassenger_rl.setVisibility(0);
            } else {
                this.addpassenger_rl.setVisibility(8);
            }
        } else if (!C0535I5.f3647h) {
            C0535I5.m(getActivity(), false, getResources().getString(cris.org.in.prs.ima.R.string.add_passenger_validation), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (this.f4928a.d.equals("TQ") || this.f4947b.d.equals("TQ")) {
            C0535I5.m(getActivity(), false, getResources().getString(cris.org.in.prs.ima.R.string.Max_passenger_limit_exceeded_TQ), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            C0535I5.m(getActivity(), false, getResources().getString(cris.org.in.prs.ima.R.string.add_passenger_validation), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
        if (f4886a.isFoodChoiceEnabled()) {
            this.mealPreferenceLayout.setVisibility(0);
        } else {
            this.mealPreferenceLayout.setVisibility(8);
        }
        if (!C0535I5.f3647h) {
            return;
        }
        if (b.isFoodChoiceEnabled()) {
            this.ll_meal_preference_lap2.setVisibility(0);
        } else {
            this.ll_meal_preference_lap2.setVisibility(8);
        }
    }

    @OnClick({2131361910})
    public void onAddPsgnInfantGone(View view) {
        this.infantLayout.setVisibility(8);
    }

    @OnClick({2131364278})
    public void onAddSnacksClick(View view) {
        this.add_meal_rl.setVisibility(0);
        this.lvaddmeal.setLayoutManager(new LinearLayoutManager(getContext()));
        Collections.sort(this.f4902a.getMealDetailsDTO().get(0).getMealDetailList(), new C0957n());
        this.lvaddmeal.setAdapter(new AddMealViewHolder(this.f4904a, this.f4902a.getMealDetailsDTO().get(0).getMealDetailList().get(2).getMealDetailList()));
    }

    @OnClick({2131361911})
    public void onAddpsgndetailgone(View view) {
        this.addpassenger_rl.setVisibility(8);
        this.titleName.setText(getString(cris.org.in.prs.ima.R.string.Add_Passenger_Details));
        s = false;
    }

    @OnClick({2131361934})
    public void onAllLapselectbookClick(View view) {
        this.f4970e = 1;
        this.select_berth_choice.setVisibility(8);
        this.tv_select_confirm_berth_Choice.setText(getString(cris.org.in.prs.ima.R.string.both_laps));
        this.none_ll.setSelected(false);
        this.lap1_ll.setSelected(false);
        this.lap2_rb.setSelected(false);
        this.any_lap.setSelected(false);
        W0(this.none_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.all_laps_ll, cris.org.in.prs.ima.R.color.dark);
        W0(this.lap1_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap2_rb, cris.org.in.prs.ima.R.color.white);
        W0(this.any_lap, cris.org.in.prs.ima.R.color.white);
        this.none_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.all_laps_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForbold);
        this.lap1_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap2_rb.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.any_lap.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
    }

    @OnClick({2131361951})
    public void onAnyLapselectbookClick(View view) {
        this.f4970e = 4;
        this.select_berth_choice.setVisibility(8);
        this.tv_select_confirm_berth_Choice.setText(getString(cris.org.in.prs.ima.R.string.Any_Lap));
        this.all_laps_ll.setSelected(false);
        this.none_ll.setSelected(false);
        this.lap1_ll.setSelected(false);
        this.lap2_rb.setSelected(false);
        W0(this.none_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.all_laps_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap1_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap2_rb, cris.org.in.prs.ima.R.color.white);
        W0(this.any_lap, cris.org.in.prs.ima.R.color.dark);
        this.none_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.all_laps_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap1_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap2_rb.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.any_lap.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForbold);
    }

    @OnClick({2131362035})
    public void onBerthPreferenceClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), this.f5014t, new W());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.berth_Preference));
        this.f4914a.f().setAdapter(customAdapter);
    }

    @OnClick({2131364319})
    public void onBoardingStationClick(View view) {
        if (this.selectstation_ll.getVisibility() == 8) {
            this.selectstation_ll.setVisibility(0);
            this.boardingStnView.setVisibility(0);
            return;
        }
        this.selectstation_ll.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:329:0x08eb  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0950  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0a0b  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x0ab1  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0b62  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0b81  */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x0aa0 A[EDGE_INSN: B:458:0x0aa0->B:379:0x0aa0 ?: BREAK  , SYNTHETIC] */
    @butterknife.OnClick({2131362922})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBookNowClick(android.view.View r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = 0
            r0.f4979g = r1
            r0.f4956c = r1
            r0.d = r1
            r0.f4955b = r1
            r0.f4964c = r1
            r0.f4969d = r1
            Z2 r2 = r0.f4902a
            boolean r2 = r2.isMealChoiceenable()
            Rh r3 = r0.f4900a
            if (r2 == 0) goto L_0x001e
            java.util.ArrayList<cris.prs.webservices.dto.MealItemDetails> r2 = r0.f4890A
            r3.setAddMealDetail(r2)
        L_0x001e:
            android.widget.CheckBox r2 = r0.isIgnoreChoiceIfWl
            boolean r2 = r2.isChecked()
            r4 = 1
            r2 = r2 ^ r4
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3.setIgnoreChoiceIfWl(r2)
            android.widget.CheckBox r2 = r0.isIgnoreChoiceIfWl
            boolean r2 = r2.isChecked()
            r5 = 4
            r6 = 99
            if (r2 == 0) goto L_0x004e
            java.lang.Short r2 = r0.f4939a
            short r2 = r2.shortValue()
            if (r2 != r6) goto L_0x0048
            java.lang.Short r2 = java.lang.Short.valueOf(r5)
            r3.setReservationChoice(r2)
            goto L_0x0053
        L_0x0048:
            java.lang.Short r2 = r0.f4939a
            r3.setReservationChoice(r2)
            goto L_0x0053
        L_0x004e:
            java.lang.Short r2 = r0.f4939a
            r3.setReservationChoice(r2)
        L_0x0053:
            java.lang.Short r2 = r3.getReservationChoice()
            boolean r7 = defpackage.C0535I5.f3647h
            Rh r8 = r0.f4945b
            if (r7 == 0) goto L_0x0062
            java.util.ArrayList<cris.prs.webservices.dto.MealItemDetails> r7 = r0.f4891B
            r8.setAddMealDetail(r7)
        L_0x0062:
            boolean r7 = defpackage.C0535I5.f3647h
            e2 r9 = r0.f4933a
            if (r7 == 0) goto L_0x00ac
            android.widget.CheckBox r7 = r0.isIgnoreChoiceIfWl
            boolean r7 = r7.isChecked()
            r7 = r7 ^ r4
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r8.setIgnoreChoiceIfWl(r7)
            android.widget.CheckBox r7 = r0.isIgnoreChoiceIfWl
            boolean r7 = r7.isChecked()
            if (r7 == 0) goto L_0x0094
            java.lang.Short r7 = r0.f4952b
            short r7 = r7.shortValue()
            if (r7 != r6) goto L_0x008e
            java.lang.Short r5 = java.lang.Short.valueOf(r5)
            r8.setReservationChoice(r5)
            goto L_0x0099
        L_0x008e:
            java.lang.Short r5 = r0.f4952b
            r8.setReservationChoice(r5)
            goto L_0x0099
        L_0x0094:
            java.lang.Short r5 = r0.f4952b
            r8.setReservationChoice(r5)
        L_0x0099:
            android.widget.CheckBox r5 = r0.isAutoUpgradation
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x00a7
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r9.setAutoUpgradationSelected(r5)
            goto L_0x00ac
        L_0x00a7:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r9.setAutoUpgradationSelected(r5)
        L_0x00ac:
            java.lang.Short r5 = r8.getReservationChoice()
            androidx.fragment.app.FragmentActivity r6 = r33.getActivity()
            android.view.View r7 = r33.getView()
            defpackage.C0535I5.H(r6, r7)
            androidx.fragment.app.FragmentActivity r6 = r33.getActivity()
            defpackage.C0535I5.I(r6)
            android.widget.EditText r6 = r0.gstinNumber
            android.text.Editable r6 = r6.getText()
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x00e1
            android.widget.EditText r6 = r0.gstinNumber
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            int r6 = r6.compareToIgnoreCase(r7)
            if (r6 == 0) goto L_0x00e1
            boolean r6 = r33.g1()
            goto L_0x00e2
        L_0x00e1:
            r6 = r1
        L_0x00e2:
            if (r6 != r4) goto L_0x0174
            ge r6 = r0.f4935a
            android.widget.TextView r10 = r0.state
            java.lang.CharSequence r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r10.trim()
            r6.setState(r10)
            ge r6 = r0.f4935a
            android.widget.TextView r10 = r0.city
            java.lang.CharSequence r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r10.trim()
            r6.setCity(r10)
            ge r6 = r0.f4935a
            android.widget.EditText r10 = r0.gstinNumber
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            r6.setGstIn(r10)
            ge r6 = r0.f4935a
            android.widget.EditText r10 = r0.areaLocality
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r10.trim()
            r6.setArea(r10)
            ge r6 = r0.f4935a
            android.widget.EditText r10 = r0.flatDoorBlock
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r10.trim()
            r6.setFlat(r10)
            ge r6 = r0.f4935a
            android.widget.EditText r10 = r0.gstpassengerName
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r10.trim()
            r6.setNameOnGst(r10)
            ge r6 = r0.f4935a
            android.widget.EditText r10 = r0.streetLane
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r10.trim()
            r6.setStreet(r10)
            ge r6 = r0.f4935a
            android.widget.EditText r10 = r0.pinCode
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            r6.setPin(r10)
        L_0x0174:
            r6 = 6
            r10 = 7
            if (r2 == 0) goto L_0x0186
            short r11 = r2.shortValue()
            if (r11 == r10) goto L_0x0184
            short r11 = r2.shortValue()
            if (r11 != r6) goto L_0x0186
        L_0x0184:
            r11 = r4
            goto L_0x0187
        L_0x0186:
            r11 = r1
        L_0x0187:
            if (r5 == 0) goto L_0x0196
            short r12 = r5.shortValue()
            if (r12 == r10) goto L_0x0195
            short r10 = r5.shortValue()
            if (r10 != r6) goto L_0x0196
        L_0x0195:
            r11 = r4
        L_0x0196:
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r6 = r0.f4963c
            java.util.Iterator r10 = r6.iterator()
            r12 = r1
            r13 = r12
            r15 = r13
            r22 = r15
            r17 = r2
            r19 = r3
            r14 = r4
            r16 = r5
            r34 = r6
            r20 = r7
            r18 = r8
            r21 = r9
            r2 = r22
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
        L_0x01b9:
            boolean r23 = r10.hasNext()
            I9 r24 = defpackage.I9.d
            I9 r25 = defpackage.I9.a
            r26 = r13
            r13 = 2131952688(0x7f130430, float:1.9541826E38)
            if (r23 == 0) goto L_0x037f
            java.lang.Object r23 = r10.next()
            cris.prs.webservices.dto.PassengerDetailDTO r23 = (cris.prs.webservices.dto.PassengerDetailDTO) r23
            java.lang.Long r24 = r23.getPassUPN()
            if (r24 != 0) goto L_0x01da
            java.lang.String r24 = r23.getPassBookingCode()
            if (r24 == 0) goto L_0x01dc
        L_0x01da:
            r0.f5008q = r14
        L_0x01dc:
            r23.getBookingBerthCode()
            r23.getPassengerCardNumber()
            r23.getPassengerCardType()
            java.lang.Short r14 = r23.getPassengerAge()
            if (r14 != 0) goto L_0x0208
            androidx.fragment.app.FragmentActivity r27 = r33.getActivity()
            r28 = 0
            java.lang.String r29 = "Please provide passenger Age."
            java.lang.String r30 = r0.getString(r13)
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r31 = r0.getString(r1)
            r32 = 0
            android.app.AlertDialog r1 = defpackage.C0535I5.m(r27, r28, r29, r30, r31, r32)
            r1.show()
            return
        L_0x0208:
            java.lang.Short r13 = r23.getPassengerAge()
            short r13 = r13.shortValue()
            java.util.List<b3> r14 = f4889c
            r27 = r10
            r10 = 0
            java.lang.Object r10 = r14.get(r10)
            b3 r10 = (defpackage.C0794b3) r10
            short r10 = r10.getMaxChildAge()
            if (r13 > r10) goto L_0x023c
            int r10 = r0.f4956c
            int r10 = r10 + 1
            r0.f4956c = r10
            java.lang.Boolean r10 = r23.getChildBerthFlag()
            if (r10 == 0) goto L_0x0242
            java.lang.Boolean r10 = r23.getChildBerthFlag()
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x0242
            int r15 = r15 + 1
            short r10 = (short) r15
            r15 = r10
            goto L_0x0242
        L_0x023c:
            int r10 = r0.d
            int r10 = r10 + 1
            r0.d = r10
        L_0x0242:
            java.lang.String r10 = "SL"
            java.lang.String r13 = "LB"
            if (r11 == 0) goto L_0x0265
            java.lang.String r14 = r23.getPassengerBerthChoice()
            if (r14 == 0) goto L_0x0265
            java.lang.String r14 = r23.getPassengerBerthChoice()
            boolean r14 = r14.equals(r13)
            if (r14 != 0) goto L_0x0262
            java.lang.String r14 = r23.getPassengerBerthChoice()
            boolean r14 = r14.equals(r10)
            if (r14 == 0) goto L_0x0265
        L_0x0262:
            int r2 = r2 + 1
            short r2 = (short) r2
        L_0x0265:
            java.lang.String r14 = r23.getPassengerBerthChoice()
            if (r14 == 0) goto L_0x0278
            java.lang.String r14 = r23.getPassengerBerthChoice()
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x0278
            int r5 = r5 + 1
            short r5 = (short) r5
        L_0x0278:
            java.lang.String r13 = r23.getPassengerBerthChoice()
            if (r13 == 0) goto L_0x028d
            java.lang.String r13 = r23.getPassengerBerthChoice()
            java.lang.String r14 = "MB"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x028d
            int r6 = r6 + 1
            short r6 = (short) r6
        L_0x028d:
            java.lang.String r13 = r23.getPassengerBerthChoice()
            if (r13 == 0) goto L_0x02a2
            java.lang.String r13 = r23.getPassengerBerthChoice()
            java.lang.String r14 = "UB"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x02a2
            int r8 = r8 + 1
            short r8 = (short) r8
        L_0x02a2:
            java.lang.String r13 = r23.getPassengerBerthChoice()
            if (r13 == 0) goto L_0x02b5
            java.lang.String r13 = r23.getPassengerBerthChoice()
            boolean r10 = r13.equals(r10)
            if (r10 == 0) goto L_0x02b5
            int r3 = r3 + 1
            short r3 = (short) r3
        L_0x02b5:
            java.lang.String r10 = r23.getPassengerBerthChoice()
            if (r10 == 0) goto L_0x02ca
            java.lang.String r10 = r23.getPassengerBerthChoice()
            java.lang.String r13 = "SU"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x02ca
            int r7 = r7 + 1
            short r7 = (short) r7
        L_0x02ca:
            java.lang.String r10 = r23.getPassengerBerthChoice()
            if (r10 == 0) goto L_0x02df
            java.lang.String r10 = r23.getPassengerBerthChoice()
            java.lang.String r13 = "WS"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x02df
            int r9 = r9 + 1
            short r9 = (short) r9
        L_0x02df:
            java.lang.String r10 = r23.getPassengerBerthChoice()
            if (r10 == 0) goto L_0x02f4
            java.lang.String r10 = r23.getPassengerBerthChoice()
            java.lang.String r13 = "AS"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x02f4
            int r1 = r1 + 1
            short r1 = (short) r1
        L_0x02f4:
            java.lang.String r10 = r23.getPassengerBerthChoice()
            if (r10 == 0) goto L_0x0309
            java.lang.String r10 = r23.getPassengerBerthChoice()
            java.lang.String r13 = "CB"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x0309
            int r4 = r4 + 1
            short r4 = (short) r4
        L_0x0309:
            java.lang.String r10 = r23.getPassengerBerthChoice()
            if (r10 == 0) goto L_0x031f
            java.lang.String r10 = r23.getPassengerBerthChoice()
            java.lang.String r13 = "CP"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x031f
            int r12 = r12 + 1
            short r10 = (short) r12
            r12 = r10
        L_0x031f:
            java.lang.String r10 = r23.getPassengerBerthChoice()
            if (r10 == 0) goto L_0x0336
            java.lang.String r10 = r23.getPassengerBerthChoice()
            java.lang.String r13 = "HB"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x0336
            int r13 = r26 + 1
            short r10 = (short) r13
            r13 = r10
            goto L_0x0338
        L_0x0336:
            r13 = r26
        L_0x0338:
            java.lang.String r10 = r23.getPassengerBerthChoice()
            if (r10 == 0) goto L_0x034f
            java.lang.String r10 = r23.getPassengerBerthChoice()
            java.lang.String r14 = "SM"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x034f
            int r10 = r22 + 1
            short r10 = (short) r10
            r22 = r10
        L_0x034f:
            java.lang.String r10 = r23.getPassengerNationality()
            if (r10 == 0) goto L_0x0365
            java.lang.String r10 = r23.getPassengerNationality()
            java.lang.String r14 = "IN"
            boolean r10 = r10.equalsIgnoreCase(r14)
            if (r10 != 0) goto L_0x0365
            r10 = 1
            r0.f4964c = r10
            goto L_0x0368
        L_0x0365:
            r10 = 1
            r0.f4955b = r10
        L_0x0368:
            java.lang.Boolean r14 = r23.getConcessionOpted()
            if (r14 == 0) goto L_0x037a
            java.lang.Boolean r14 = r23.getConcessionOpted()
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x037a
            r0.f4969d = r10
        L_0x037a:
            r14 = 1
            r10 = r27
            goto L_0x01b9
        L_0x037f:
            android.widget.CheckBox r10 = r0.isAutoUpgradation
            boolean r10 = r10.isChecked()
            if (r10 == 0) goto L_0x038f
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r13 = r21
            r13.setAutoUpgradationSelected(r10)
            goto L_0x0396
        L_0x038f:
            r13 = r21
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r13.setAutoUpgradationSelected(r10)
        L_0x0396:
            d2 r10 = r0.f4932a
            short r10 = r10.getAvailablityType()
            r14 = 1
            if (r10 != r14) goto L_0x03ab
            android.widget.EditText r10 = r0.preferredCoach
            android.text.Editable r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            r0.f4980h = r10
        L_0x03ab:
            java.lang.String r10 = r0.f4980h
            if (r10 == 0) goto L_0x03ec
            r14 = r20
            boolean r10 = r10.equals(r14)
            if (r10 != 0) goto L_0x03ea
            java.lang.String r10 = r0.f4980h
            boolean r10 = defpackage.C0535I5.S(r10)
            if (r10 != 0) goto L_0x03ea
            androidx.fragment.app.FragmentActivity r27 = r33.getActivity()
            r28 = 0
            android.content.res.Resources r10 = r33.getResources()
            r20 = r14
            r14 = 2131952477(0x7f13035d, float:1.9541398E38)
            java.lang.String r29 = r10.getString(r14)
            r10 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r30 = r0.getString(r10)
            r10 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r31 = r0.getString(r10)
            r32 = 0
            android.app.AlertDialog r10 = defpackage.C0535I5.m(r27, r28, r29, r30, r31, r32)
            r10.show()
            goto L_0x03ec
        L_0x03ea:
            r20 = r14
        L_0x03ec:
            java.lang.String r10 = r0.f4980h
            r14 = r19
            r14.setCoachId(r10)
            boolean r10 = defpackage.C0535I5.f3647h
            if (r10 == 0) goto L_0x0401
            java.lang.String r10 = r0.f4980h
            r19 = r14
            r14 = r18
            r14.setCoachId(r10)
            goto L_0x0405
        L_0x0401:
            r19 = r14
            r14 = r18
        L_0x0405:
            java.lang.String r10 = r0.f5004p
            r13.setBoardingStation(r10)
            java.util.HashMap<java.lang.Short, java.lang.Short> r10 = f4888b
            r18 = 100
            r21 = r14
            java.lang.Short r14 = java.lang.Short.valueOf(r18)
            boolean r10 = r10.containsKey(r14)
            if (r10 == 0) goto L_0x0437
            java.util.HashMap<java.lang.Short, java.lang.Short> r10 = f4888b
            java.lang.Short r14 = java.lang.Short.valueOf(r18)
            java.lang.Object r10 = r10.get(r14)
            java.lang.Short r10 = (java.lang.Short) r10
            short r10 = r10.shortValue()
            if (r10 <= 0) goto L_0x0437
            r1 = 2131951990(0x7f130176, float:1.954041E38)
            java.lang.String r1 = r0.getString(r1)
        L_0x0433:
            r3 = r20
            goto L_0x08bb
        L_0x0437:
            int r10 = l
            if (r10 != 0) goto L_0x044b
            int r14 = r0.e
            if (r14 != 0) goto L_0x044b
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131952365(0x7f1302ed, float:1.954117E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x044b:
            if (r10 != 0) goto L_0x045d
            int r10 = r0.e
            if (r10 == 0) goto L_0x045d
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131952364(0x7f1302ec, float:1.9541169E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x045d:
            int r10 = r0.k
            r14 = 1
            if (r10 != r14) goto L_0x0470
            boolean r10 = r33.e1()
            if (r10 != 0) goto L_0x0470
            r1 = 2131953388(0x7f1306ec, float:1.9543246E38)
            java.lang.String r1 = r0.getString(r1)
            goto L_0x0433
        L_0x0470:
            java.lang.String r10 = r0.M
            if (r10 == 0) goto L_0x0499
            java.lang.String r14 = "redemption"
            boolean r10 = r10.equals(r14)
            if (r10 != 0) goto L_0x0499
            b3 r10 = f4886a
            mo r10 = r10.getPaymentOption()
            if (r10 == 0) goto L_0x0499
            java.lang.Short r10 = r0.f4961c
            short r10 = r10.shortValue()
            r14 = 1
            if (r10 != r14) goto L_0x0499
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131953695(0x7f13081f, float:1.9543868E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x0499:
            java.lang.String r10 = r0.M
            if (r10 == 0) goto L_0x04c3
            java.lang.String r14 = "accural"
            boolean r10 = r10.equals(r14)
            if (r10 == 0) goto L_0x04c3
            b3 r10 = f4886a
            mo r10 = r10.getPaymentOption()
            if (r10 == 0) goto L_0x04c3
            java.lang.Short r10 = r0.f4961c
            short r10 = r10.shortValue()
            r14 = 2
            if (r10 != r14) goto L_0x04c3
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131953694(0x7f13081e, float:1.9543866E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x04c3:
            int r10 = l
            int r10 = r10 - r15
            if (r15 <= r10) goto L_0x04d5
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131953019(0x7f13057b, float:1.9542497E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x04d5:
            if (r11 == 0) goto L_0x04ee
            short r10 = r17.shortValue()
            r14 = 6
            if (r10 != r14) goto L_0x04ee
            r10 = 1
            if (r2 >= r10) goto L_0x04ee
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131951670(0x7f130036, float:1.9539761E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x04ee:
            Bw r10 = r0.f4898a
            java.lang.String r14 = r10.p()
            int r14 = java.lang.Integer.parseInt(r14)
            r15 = 2131952346(0x7f1302da, float:1.9541132E38)
            if (r14 <= 0) goto L_0x0530
            java.lang.String r14 = r10.p()
            int r14 = java.lang.Integer.parseInt(r14)
            if (r5 <= r14) goto L_0x0530
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.p()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = r25.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x0530:
            java.lang.String r5 = r10.q()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 <= 0) goto L_0x056f
            java.lang.String r5 = r10.q()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r6 <= r5) goto L_0x056f
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.q()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.b
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x056f:
            java.lang.String r5 = r10.u()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 <= 0) goto L_0x05ae
            java.lang.String r5 = r10.u()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r8 <= r5) goto L_0x05ae
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.u()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.c
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x05ae:
            java.lang.String r5 = r10.r()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 <= 0) goto L_0x05eb
            java.lang.String r5 = r10.r()
            int r5 = java.lang.Integer.parseInt(r5)
            if (r3 <= r5) goto L_0x05eb
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.r()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = r24.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x05eb:
            java.lang.String r3 = r10.t()
            int r3 = java.lang.Integer.parseInt(r3)
            if (r3 <= 0) goto L_0x062a
            java.lang.String r3 = r10.t()
            int r3 = java.lang.Integer.parseInt(r3)
            if (r7 <= r3) goto L_0x062a
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.t()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.e
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x062a:
            java.lang.String r3 = r10.v()
            int r3 = java.lang.Integer.parseInt(r3)
            if (r3 <= 0) goto L_0x0669
            java.lang.String r3 = r10.v()
            int r3 = java.lang.Integer.parseInt(r3)
            if (r9 <= r3) goto L_0x0669
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.v()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.f
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x0669:
            java.lang.String r3 = r10.l()
            int r3 = java.lang.Integer.parseInt(r3)
            if (r3 <= 0) goto L_0x06a8
            java.lang.String r3 = r10.l()
            int r3 = java.lang.Integer.parseInt(r3)
            if (r1 <= r3) goto L_0x06a8
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.l()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.g
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x06a8:
            java.lang.String r1 = r10.m()
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 <= 0) goto L_0x06e7
            java.lang.String r1 = r10.m()
            int r1 = java.lang.Integer.parseInt(r1)
            if (r4 <= r1) goto L_0x06e7
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.m()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.h
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x06e7:
            java.lang.String r1 = r10.n()
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 <= 0) goto L_0x0726
            java.lang.String r1 = r10.n()
            int r1 = java.lang.Integer.parseInt(r1)
            if (r12 <= r1) goto L_0x0726
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.n()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.i
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x0726:
            java.lang.String r1 = r10.o()
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 <= 0) goto L_0x0767
            java.lang.String r1 = r10.o()
            int r1 = java.lang.Integer.parseInt(r1)
            r3 = r26
            if (r3 <= r1) goto L_0x0767
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.o()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.j
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x0767:
            java.lang.String r1 = r10.s()
            int r1 = java.lang.Integer.parseInt(r1)
            if (r1 <= 0) goto L_0x07a8
            java.lang.String r1 = r10.s()
            int r1 = java.lang.Integer.parseInt(r1)
            r3 = r22
            if (r3 <= r1) goto L_0x07a8
            android.content.Context r1 = r0.f4904a
            android.content.res.Resources r1 = r1.getResources()
            java.lang.String r1 = r1.getString(r15)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r10.s()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            I9 r4 = defpackage.I9.k
            java.lang.String r4 = r4.a()
            r5 = 1
            r3[r5] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
            goto L_0x0433
        L_0x07a8:
            if (r11 == 0) goto L_0x07c3
            short r1 = r17.shortValue()
            r3 = 7
            if (r1 != r3) goto L_0x07c3
            int r1 = l
            r3 = 2
            if (r1 >= r3) goto L_0x07c4
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131951667(0x7f130033, float:1.9539755E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x07c3:
            r3 = 2
        L_0x07c4:
            if (r11 == 0) goto L_0x07dc
            short r1 = r17.shortValue()
            r4 = 7
            if (r1 != r4) goto L_0x07dc
            if (r2 >= r3) goto L_0x07dc
            android.content.res.Resources r1 = r33.getResources()
            r3 = 2131951668(0x7f130034, float:1.9539757E38)
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0433
        L_0x07dc:
            android.widget.EditText r1 = r0.mobileNumber
            r3 = r20
            boolean r1 = defpackage.xx.T(r1, r3)
            if (r1 == 0) goto L_0x07f3
            android.content.res.Resources r1 = r33.getResources()
            r4 = 2131952362(0x7f1302ea, float:1.9541165E38)
            java.lang.String r1 = r1.getString(r4)
            goto L_0x08bb
        L_0x07f3:
            int r1 = defpackage.C0535I5.d
            r4 = 91
            if (r1 != r4) goto L_0x0810
            android.widget.EditText r1 = r0.mobileNumber
            int r1 = defpackage.lf.e(r1)
            r4 = 10
            if (r1 == r4) goto L_0x0810
            android.content.res.Resources r1 = r33.getResources()
            r4 = 2131953142(0x7f1305f6, float:1.9542747E38)
            java.lang.String r1 = r1.getString(r4)
            goto L_0x08bb
        L_0x0810:
            int r1 = defpackage.C0535I5.d
            r4 = 91
            if (r1 != r4) goto L_0x0833
            android.widget.EditText r1 = r0.mobileNumber
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = defpackage.C0535I5.N(r1)
            if (r1 != 0) goto L_0x0833
            android.content.res.Resources r1 = r33.getResources()
            r4 = 2131953943(0x7f130917, float:1.9544371E38)
            java.lang.String r1 = r1.getString(r4)
            goto L_0x08bb
        L_0x0833:
            android.widget.EditText r1 = r0.mobileNumber
            int r1 = defpackage.lf.e(r1)
            r4 = 3
            if (r1 < r4) goto L_0x08b0
            android.widget.EditText r1 = r0.mobileNumber
            int r1 = defpackage.lf.e(r1)
            r4 = 15
            if (r1 <= r4) goto L_0x0847
            goto L_0x08b0
        L_0x0847:
            boolean r1 = r0.f4955b
            if (r1 == 0) goto L_0x0870
            java.util.List<b3> r1 = f4889c
            r4 = 0
            java.lang.Object r1 = r1.get(r4)
            b3 r1 = (defpackage.C0794b3) r1
            boolean r1 = r1.isTravelInsuranceEnabled()
            if (r1 == 0) goto L_0x0870
            java.lang.String r1 = r0.f5011s
            if (r1 == 0) goto L_0x0864
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0870
        L_0x0864:
            android.content.res.Resources r1 = r33.getResources()
            r4 = 2131952930(0x7f130522, float:1.9542317E38)
            java.lang.String r1 = r1.getString(r4)
            goto L_0x08bb
        L_0x0870:
            java.lang.String r1 = S
            java.lang.String r4 = "S"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x08ae
            boolean r1 = r0.f5008q
            if (r1 != 0) goto L_0x0886
            r1 = 2131951632(0x7f130010, float:1.9539684E38)
            java.lang.String r1 = r0.getString(r1)
            goto L_0x08bb
        L_0x0886:
            java.util.HashMap<java.lang.Short, java.lang.Short> r1 = c
            r4 = 100
            java.lang.Short r5 = java.lang.Short.valueOf(r4)
            boolean r1 = r1.containsKey(r5)
            if (r1 == 0) goto L_0x08ae
            java.util.HashMap<java.lang.Short, java.lang.Short> r1 = c
            java.lang.Short r4 = java.lang.Short.valueOf(r4)
            java.lang.Object r1 = r1.get(r4)
            java.lang.Short r1 = (java.lang.Short) r1
            short r1 = r1.shortValue()
            if (r1 <= 0) goto L_0x08ae
            r1 = 2131951990(0x7f130176, float:1.954041E38)
            java.lang.String r1 = r0.getString(r1)
            goto L_0x08bb
        L_0x08ae:
            r1 = r3
            goto L_0x08bb
        L_0x08b0:
            android.content.res.Resources r1 = r33.getResources()
            r4 = 2131953943(0x7f130917, float:1.9544371E38)
            java.lang.String r1 = r1.getString(r4)
        L_0x08bb:
            boolean r4 = defpackage.C0535I5.f3647h
            if (r4 == 0) goto L_0x08e7
            boolean r4 = r0.f4955b
            if (r4 == 0) goto L_0x08e7
            java.util.List<b3> r4 = f4889c
            r5 = 1
            java.lang.Object r4 = r4.get(r5)
            b3 r4 = (defpackage.C0794b3) r4
            boolean r4 = r4.isTravelInsuranceEnabled()
            if (r4 == 0) goto L_0x08e7
            java.lang.String r4 = r0.f5013t
            if (r4 == 0) goto L_0x08dc
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L_0x08e7
        L_0x08dc:
            android.content.res.Resources r1 = r33.getResources()
            r4 = 2131952930(0x7f130522, float:1.9542317E38)
            java.lang.String r1 = r1.getString(r4)
        L_0x08e7:
            boolean r4 = defpackage.C0535I5.f3647h
            if (r4 == 0) goto L_0x0934
            if (r11 == 0) goto L_0x0903
            short r4 = r16.shortValue()
            r5 = 2
            if (r4 != r5) goto L_0x0903
            r4 = 1
            if (r2 >= r4) goto L_0x0903
            android.content.res.Resources r1 = r33.getResources()
            r2 = 2131951670(0x7f130036, float:1.9539761E38)
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0934
        L_0x0903:
            if (r11 == 0) goto L_0x091d
            short r4 = r16.shortValue()
            r5 = 3
            if (r4 != r5) goto L_0x091d
            int r4 = l
            r5 = 2
            if (r4 >= r5) goto L_0x091e
            android.content.res.Resources r1 = r33.getResources()
            r2 = 2131951667(0x7f130033, float:1.9539755E38)
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0934
        L_0x091d:
            r5 = 2
        L_0x091e:
            if (r11 == 0) goto L_0x0934
            short r4 = r16.shortValue()
            r6 = 3
            if (r4 != r6) goto L_0x0934
            if (r2 >= r5) goto L_0x0934
            android.content.res.Resources r1 = r33.getResources()
            r2 = 2131951668(0x7f130034, float:1.9539757E38)
            java.lang.String r1 = r1.getString(r2)
        L_0x0934:
            cris.org.in.ima.model.TrainBtwnStnsModel r2 = r0.f4928a
            java.lang.String r2 = r2.d
            r4 = 2131952997(0x7f130565, float:1.9542453E38)
            java.lang.String r5 = r0.getString(r4)
            boolean r2 = r2.equals(r5)
            java.lang.String r5 = "T"
            java.lang.String r6 = "M"
            java.lang.String r7 = " yr."
            java.lang.String r8 = " "
            r9 = 2131952999(0x7f130567, float:1.9542457E38)
            if (r2 == 0) goto L_0x09ef
            java.util.Iterator r2 = r34.iterator()
        L_0x0954:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x09ef
            java.lang.Object r10 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r10 = (cris.prs.webservices.dto.PassengerDetailDTO) r10
            java.lang.Short r11 = r10.getPassengerAge()
            short r11 = r11.shortValue()
            java.util.List<b3> r12 = f4889c
            r14 = 0
            java.lang.Object r12 = r12.get(r14)
            b3 r12 = (defpackage.C0794b3) r12
            short r12 = r12.getMaxChildAge()
            if (r11 <= r12) goto L_0x09a8
            java.lang.String r11 = r10.getPassengerGender()
            boolean r11 = r11.equals(r6)
            if (r11 == 0) goto L_0x09a8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getString(r9)
            r1.append(r2)
            r1.append(r8)
            java.util.List<b3> r2 = f4889c
            r10 = 0
            java.lang.Object r2 = r2.get(r10)
            b3 r2 = (defpackage.C0794b3) r2
            short r2 = r2.getMaxChildAge()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            goto L_0x09ef
        L_0x09a8:
            java.lang.Short r11 = r10.getPassengerAge()
            short r11 = r11.shortValue()
            java.util.List<b3> r12 = f4889c
            r14 = 0
            java.lang.Object r12 = r12.get(r14)
            b3 r12 = (defpackage.C0794b3) r12
            short r12 = r12.getMaxChildAge()
            if (r11 <= r12) goto L_0x0954
            java.lang.String r10 = r10.getPassengerGender()
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x0954
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getString(r9)
            r1.append(r2)
            r1.append(r8)
            java.util.List<b3> r2 = f4889c
            r10 = 0
            java.lang.Object r2 = r2.get(r10)
            b3 r2 = (defpackage.C0794b3) r2
            short r2 = r2.getMaxChildAge()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
        L_0x09ef:
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x0aa0
            cris.org.in.ima.model.TrainBtwnStnsModel r2 = r0.f4947b
            java.lang.String r2 = r2.d
            java.lang.String r4 = r0.getString(r4)
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0aa0
            java.util.Iterator r2 = r34.iterator()
        L_0x0a05:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0aa0
            java.lang.Object r4 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r4 = (cris.prs.webservices.dto.PassengerDetailDTO) r4
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            java.util.List<b3> r11 = f4889c
            r12 = 0
            java.lang.Object r11 = r11.get(r12)
            b3 r11 = (defpackage.C0794b3) r11
            short r11 = r11.getMaxChildAge()
            if (r10 <= r11) goto L_0x0a59
            java.lang.String r10 = r4.getPassengerGender()
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0a59
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getString(r9)
            r1.append(r2)
            r1.append(r8)
            java.util.List<b3> r2 = f4889c
            r4 = 0
            java.lang.Object r2 = r2.get(r4)
            b3 r2 = (defpackage.C0794b3) r2
            short r2 = r2.getMaxChildAge()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            goto L_0x0aa0
        L_0x0a59:
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            java.util.List<b3> r11 = f4889c
            r12 = 0
            java.lang.Object r11 = r11.get(r12)
            b3 r11 = (defpackage.C0794b3) r11
            short r11 = r11.getMaxChildAge()
            if (r10 <= r11) goto L_0x0a05
            java.lang.String r4 = r4.getPassengerGender()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0a05
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getString(r9)
            r1.append(r2)
            r1.append(r8)
            java.util.List<b3> r2 = f4889c
            r4 = 0
            java.lang.Object r2 = r2.get(r4)
            b3 r2 = (defpackage.C0794b3) r2
            short r2 = r2.getMaxChildAge()
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
        L_0x0aa0:
            cris.org.in.ima.model.TrainBtwnStnsModel r2 = r0.f4928a
            java.lang.String r2 = r2.d
            r4 = 2131951763(0x7f130093, float:1.953995E38)
            java.lang.String r4 = r0.getString(r4)
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0ae2
            java.util.Iterator r2 = r34.iterator()
            r4 = 0
        L_0x0ab6:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0ad9
            java.lang.Object r5 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r5 = (cris.prs.webservices.dto.PassengerDetailDTO) r5
            java.lang.Long r6 = r5.getPassUPN()
            if (r6 == 0) goto L_0x0ab6
            java.lang.Long r5 = r5.getPassUPN()
            long r5 = r5.longValue()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0ab6
            int r4 = r4 + 1
            goto L_0x0ab6
        L_0x0ad9:
            if (r4 != 0) goto L_0x0ae2
            r1 = 2131952591(0x7f1303cf, float:1.954163E38)
            java.lang.String r1 = r0.getString(r1)
        L_0x0ae2:
            r6 = r1
            boolean r1 = Z(r34)
            boolean r2 = r6.equals(r3)
            if (r2 == 0) goto L_0x0b5c
            int r2 = r0.k
            if (r2 == 0) goto L_0x0b5c
            nf r2 = new nf
            r2.<init>()
            android.widget.EditText r4 = r0.et_address1
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r2.setAddress(r4)
            android.widget.EditText r4 = r0.et_address2
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r2.setStreet(r4)
            android.widget.EditText r4 = r0.et_address3
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r2.setColony(r4)
            android.widget.TextView r4 = r0.et_city_town
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r2.setCity(r4)
            android.widget.TextView r4 = r0.et_state
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r2.setStateName(r4)
            android.widget.EditText r4 = r0.et_psgn_pincode
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.setPinCode(r4)
            android.widget.TextView r4 = r0.et_post_office
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r2.setPostOffice(r4)
            r13.setTktAddress(r2)
        L_0x0b5c:
            boolean r2 = r6.equals(r3)
            if (r2 != 0) goto L_0x0b81
            r1 = 1
            r0.f4979g = r1
            androidx.fragment.app.FragmentActivity r4 = r33.getActivity()
            r5 = 0
            r1 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r7 = r0.getString(r1)
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r8 = r0.getString(r1)
            r9 = 0
            android.app.AlertDialog r1 = defpackage.C0535I5.m(r4, r5, r6, r7, r8, r9)
            r1.show()
            return
        L_0x0b81:
            boolean r2 = r0.f4964c
            r3 = 2131953751(0x7f130857, float:1.9543982E38)
            r4 = 2131952516(0x7f130384, float:1.9541477E38)
            java.lang.String r5 = "N"
            if (r2 == 0) goto L_0x0bf7
            java.lang.String r2 = r0.f5011s
            if (r2 == 0) goto L_0x0bf7
            java.lang.String r6 = "true"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0bf7
            boolean r1 = Z(r34)
            int r2 = r34.size()
            r6 = 2
            if (r2 != r6) goto L_0x0be4
            if (r1 == 0) goto L_0x0be4
            androidx.fragment.app.FragmentActivity r7 = r33.getActivity()
            r8 = 0
            android.content.res.Resources r1 = r33.getResources()
            java.lang.String r9 = r1.getString(r3)
            android.content.res.Resources r1 = r33.getResources()
            java.lang.String r10 = r1.getString(r4)
            android.content.res.Resources r1 = r33.getResources()
            r2 = 2131954004(0x7f130954, float:1.9544495E38)
            java.lang.String r11 = r1.getString(r2)
            cris.org.in.ima.fragment.PassengerDetailFragment$g0 r12 = new cris.org.in.ima.fragment.PassengerDetailFragment$g0
            r12.<init>()
            android.content.res.Resources r1 = r33.getResources()
            r2 = 2131953281(0x7f130681, float:1.9543029E38)
            java.lang.String r13 = r1.getString(r2)
            cris.org.in.ima.fragment.PassengerDetailFragment$h0 r14 = new cris.org.in.ima.fragment.PassengerDetailFragment$h0
            r14.<init>()
            android.app.AlertDialog r1 = defpackage.C0535I5.p(r7, r8, r9, r10, r11, r12, r13, r14)
            r1.show()
            goto L_0x0d12
        L_0x0be4:
            r2 = r19
            r2.setSsQuotaSplitCoach(r5)
            boolean r1 = defpackage.C0535I5.f3647h
            if (r1 == 0) goto L_0x0bf2
            r6 = r21
            r6.setSsQuotaSplitCoach(r5)
        L_0x0bf2:
            r33.B0()
            goto L_0x0d12
        L_0x0bf7:
            r2 = r19
            r6 = r21
            int r7 = r34.size()
            r8 = 2
            if (r7 != r8) goto L_0x0c44
            if (r1 == 0) goto L_0x0c44
            androidx.fragment.app.FragmentActivity r9 = r33.getActivity()
            r10 = 0
            android.content.res.Resources r1 = r33.getResources()
            java.lang.String r11 = r1.getString(r3)
            android.content.res.Resources r1 = r33.getResources()
            java.lang.String r12 = r1.getString(r4)
            android.content.res.Resources r1 = r33.getResources()
            r2 = 2131954004(0x7f130954, float:1.9544495E38)
            java.lang.String r13 = r1.getString(r2)
            cris.org.in.ima.fragment.PassengerDetailFragment$j0 r14 = new cris.org.in.ima.fragment.PassengerDetailFragment$j0
            r14.<init>()
            android.content.res.Resources r1 = r33.getResources()
            r2 = 2131953281(0x7f130681, float:1.9543029E38)
            java.lang.String r15 = r1.getString(r2)
            cris.org.in.ima.fragment.PassengerDetailFragment$k0 r1 = new cris.org.in.ima.fragment.PassengerDetailFragment$k0
            r1.<init>()
            r16 = r1
            android.app.AlertDialog r1 = defpackage.C0535I5.p(r9, r10, r11, r12, r13, r14, r15, r16)
            r1.show()
            goto L_0x0d12
        L_0x0c44:
            java.util.List<cris.prs.webservices.dto.InformationMessageDTO> r1 = r0.f4942a
            if (r1 == 0) goto L_0x0d05
            r3 = 0
            java.lang.Object r1 = r1.get(r3)
            cris.prs.webservices.dto.InformationMessageDTO r1 = (cris.prs.webservices.dto.InformationMessageDTO) r1
            java.lang.String r1 = r1.getParamName()
            java.lang.String r3 = "FOOD_ALERT"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0d05
            Rh r1 = new Rh
            r1.<init>()
            r2 = r34
            r1.setPassengerList(r2)
            java.util.ArrayList<Df> r2 = r0.f4972e
            r1.setInfantList(r2)
            r2 = 0
        L_0x0c6b:
            java.util.ArrayList r3 = r1.getPassengerList()
            int r3 = r3.size()
            if (r2 >= r3) goto L_0x0caf
            java.util.ArrayList r3 = r1.getPassengerList()
            java.lang.Object r3 = r3.get(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3
            java.lang.String r3 = r3.getPassengerFoodChoice()
            if (r3 == 0) goto L_0x0c94
            java.util.ArrayList r3 = r1.getPassengerList()
            java.lang.Object r3 = r3.get(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3
            java.lang.String r3 = r3.getPassengerFoodChoice()
            goto L_0x0c95
        L_0x0c94:
            r3 = 0
        L_0x0c95:
            if (r3 == 0) goto L_0x0cab
            r5 = 68
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 == 0) goto L_0x0ca4
            goto L_0x0cab
        L_0x0ca4:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r0.f4951b = r3
            int r2 = r2 + 1
            goto L_0x0c6b
        L_0x0cab:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.f4951b = r1
        L_0x0caf:
            java.lang.Boolean r1 = r0.f4951b
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0d01
            java.lang.Boolean r1 = r0.f4960c
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0d01
            android.content.Context r5 = r0.f4904a
            r6 = 0
            java.util.List<cris.prs.webservices.dto.InformationMessageDTO> r1 = r0.f4942a
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            cris.prs.webservices.dto.InformationMessageDTO r1 = (cris.prs.webservices.dto.InformationMessageDTO) r1
            java.lang.String r7 = r1.getMessage()
            java.lang.String r8 = r0.getString(r4)
            java.util.List<cris.prs.webservices.dto.InformationMessageDTO> r1 = r0.f4942a
            java.lang.Object r1 = r1.get(r2)
            cris.prs.webservices.dto.InformationMessageDTO r1 = (cris.prs.webservices.dto.InformationMessageDTO) r1
            java.lang.String r1 = r1.getAcceptButton()
            java.lang.String r9 = r1.toString()
            r10 = 0
            java.util.List<cris.prs.webservices.dto.InformationMessageDTO> r1 = r0.f4942a
            java.lang.Object r1 = r1.get(r2)
            cris.prs.webservices.dto.InformationMessageDTO r1 = (cris.prs.webservices.dto.InformationMessageDTO) r1
            java.lang.String r1 = r1.getRejectButton()
            java.lang.String r11 = r1.toString()
            cris.org.in.ima.fragment.PassengerDetailFragment$l0 r12 = new cris.org.in.ima.fragment.PassengerDetailFragment$l0
            r12.<init>()
            android.app.AlertDialog r1 = defpackage.C0535I5.p(r5, r6, r7, r8, r9, r10, r11, r12)
            r1.show()
            goto L_0x0d12
        L_0x0d01:
            r33.B0()
            goto L_0x0d12
        L_0x0d05:
            r2.setSsQuotaSplitCoach(r5)
            boolean r1 = defpackage.C0535I5.f3647h
            if (r1 == 0) goto L_0x0d0f
            r6.setSsQuotaSplitCoach(r5)
        L_0x0d0f:
            r33.B0()
        L_0x0d12:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PassengerDetailFragment.onBookNowClick(android.view.View):void");
    }

    @OnClick({2131363450})
    public void onChildAgeClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f5018w, new a0());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Child_Age));
        this.f4914a.f().setAdapter(customAdapter);
    }

    @OnClick({2131362644})
    public void onChildFemaleBtnClick(View view) {
        this.childMale.setSelected(true);
        this.childfeMale.setSelected(false);
        this.childTrangender.setSelected(false);
        this.f4896G = "F";
    }

    @OnClick({2131363171})
    public void onChildMaleBtnClick(View view) {
        this.childMale.setSelected(true);
        this.childfeMale.setSelected(false);
        this.childTrangender.setSelected(false);
        this.f4896G = "M";
    }

    @OnClick({2131364223})
    public void onChildTransgenderBtnClick(View view) {
        this.childMale.setSelected(true);
        this.childfeMale.setSelected(false);
        this.childTrangender.setSelected(false);
        this.f4896G = RequestConfiguration.MAX_AD_CONTENT_RATING_T;
    }

    @OnClick({2131362522})
    public void onCittownyClick(View view) {
        if (this.et_psgn_pincode.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this.f4904a, getString(cris.org.in.prs.ima.R.string.Please_provide_Pin_Number), 1).show();
            return;
        }
        ArrayList<String> arrayList = this.f4940a;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4914a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4914a.show(getActivity().getSupportFragmentManager(), "");
            this.f4914a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getContext(), arrayList, new H());
            this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Select_City));
            this.f4914a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131362197})
    public void onCityClick(View view) {
        ArrayList<String> arrayList = this.f4953b;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4914a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4914a.show(getActivity().getSupportFragmentManager(), "");
            this.f4914a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getContext(), arrayList, new f0());
            this.f4914a.g().setText("Select City");
            this.f4914a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131364382})
    public void onClickMasterpsgnList() {
        this.f4984i = new ArrayList<>();
        if (G.size() > 0) {
            PassengerDetailFragment passengerDetailFragment = (PassengerDetailFragment) getFragmentManager().C(C1218kf.ADD_PASSENGER.a());
            Iterator<MasterPassengerModel> it = G.iterator();
            while (it.hasNext()) {
                MasterPassengerModel next = it.next();
                if (next.f5338a) {
                    this.f4984i.add(next.a);
                }
            }
            passengerDetailFragment.r0(this.f4984i);
        }
        this.existingpassenger_ll.setVisibility(8);
        J0();
        if (C0535I5.f3647h) {
            K0();
        }
    }

    @OnClick({2131362744})
    public void onClickgst(View view) {
        String gstinPattern = f4886a.getGstinPattern();
        if (gstinPattern != null) {
            f4887a = Pattern.compile(gstinPattern);
        }
        if (this.gst_rl.getVisibility() == 8) {
            this.gst_rl.setVisibility(0);
            if (!this.gstinNumber.hasFocus() && this.gstinNumber.length() == 0) {
                this.gstpassengerName.setText("");
                this.flatDoorBlock.setText("");
                this.streetLane.setText("");
                this.areaLocality.setText("");
                this.pinCode.setText("");
                this.state.setText("");
                this.city.setText("City");
                this.gstpassengerName.setEnabled(false);
                this.flatDoorBlock.setEnabled(false);
                this.streetLane.setEnabled(false);
                this.areaLocality.setEnabled(false);
                this.pinCode.setEnabled(false);
                this.state.setEnabled(false);
                this.city.setEnabled(false);
                j0();
                return;
            }
            return;
        }
        this.gst_rl.setVisibility(8);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
        G = new ArrayList<>();
        MasterPassengerViewHolder.setNoOfMasterPsgnSelected(0);
        l = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:522:0x1505  */
    /* JADX WARNING: Removed duplicated region for block: B:523:0x1510  */
    /* JADX WARNING: Removed duplicated region for block: B:526:0x1527  */
    /* JADX WARNING: Removed duplicated region for block: B:529:0x153b  */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x15bc  */
    /* JADX WARNING: Removed duplicated region for block: B:569:0x1690  */
    /* JADX WARNING: Removed duplicated region for block: B:577:0x16ff  */
    /* JADX WARNING: Removed duplicated region for block: B:616:0x1897  */
    /* JADX WARNING: Removed duplicated region for block: B:626:0x18de  */
    /* JADX WARNING: Removed duplicated region for block: B:627:0x18eb  */
    /* JADX WARNING: Removed duplicated region for block: B:640:0x194e  */
    /* JADX WARNING: Removed duplicated region for block: B:643:0x19f6  */
    /* JADX WARNING: Removed duplicated region for block: B:644:0x19ff  */
    /* JADX WARNING: Removed duplicated region for block: B:647:0x1a0c  */
    /* JADX WARNING: Removed duplicated region for block: B:653:0x1a39  */
    /* JADX WARNING: Removed duplicated region for block: B:670:0x1afb  */
    /* JADX WARNING: Removed duplicated region for block: B:671:0x1b11  */
    /* JADX WARNING: Removed duplicated region for block: B:674:0x1b4d  */
    /* JADX WARNING: Removed duplicated region for block: B:677:0x1b7d  */
    /* JADX WARNING: Removed duplicated region for block: B:709:0x1d03  */
    /* JADX WARNING: Removed duplicated region for block: B:714:0x1d6c  */
    /* JADX WARNING: Removed duplicated region for block: B:721:0x1dd4  */
    /* JADX WARNING: Removed duplicated region for block: B:732:0x1e99  */
    /* JADX WARNING: Removed duplicated region for block: B:733:0x1eac  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r22, android.view.ViewGroup r23, android.os.Bundle r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = 2131558457(0x7f0d0039, float:1.874223E38)
            r2 = 0
            r3 = r22
            android.view.View r2 = r3.inflate(r0, r2)
            butterknife.ButterKnife.bind((java.lang.Object) r1, (android.view.View) r2)
            android.widget.TextView r0 = cris.org.in.ima.activities.HomeActivity.f4185b
            r3 = 8
            r0.setVisibility(r3)
            cris.org.in.ima.activities.HomeActivity.K()
            android.app.ProgressDialog r0 = new android.app.ProgressDialog
            androidx.fragment.app.FragmentActivity r4 = r21.getActivity()
            r0.<init>(r4)
            r1.f4903a = r0
            androidx.fragment.app.FragmentActivity r0 = r21.getActivity()
            r1.f4906a = r0
            android.content.Context r0 = r21.getContext()
            r1.f4904a = r0
            android.os.Bundle r0 = r21.getArguments()
            b1 r4 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r4 = r4.a()
            r1.f4912a = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f4993l = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f4996m = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f4999n = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f5002o = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f5007q = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f5014t = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f5016u = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f5018w = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f4954b = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f4892C = r4
            r4 = 0
            java.lang.Short r5 = java.lang.Short.valueOf(r4)
            r1.f4994l = r4
            r6 = 2131364382(0x7f0a0a1e, float:1.83486E38)
            android.view.View r6 = r2.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            a = r6
            r6 = 1
            java.lang.Short r7 = java.lang.Short.valueOf(r6)
            java.lang.String r8 = "ddMMyyyy"
            if (r0 == 0) goto L_0x0291
            java.lang.String r9 = "TrainBtwnStnsDTOList"
            java.io.Serializable r9 = r0.getSerializable(r9)
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            r1.f5021z = r9
            java.lang.String r9 = "avlResponseDTO"
            java.io.Serializable r9 = r0.getSerializable(r9)
            f2 r9 = (defpackage.C1100f2) r9
            r1.f4934a = r9
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r9 = r1.f5021z
            java.lang.Object r9 = r9.get(r4)
            cris.org.in.ima.model.TrainBtwnStnsModel r9 = (cris.org.in.ima.model.TrainBtwnStnsModel) r9
            r1.f4928a = r9
            boolean r9 = defpackage.C0535I5.f3647h
            if (r9 == 0) goto L_0x00d3
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r9 = r1.f5021z
            java.lang.Object r9 = r9.get(r6)
            cris.org.in.ima.model.TrainBtwnStnsModel r9 = (cris.org.in.ima.model.TrainBtwnStnsModel) r9
            r1.f4947b = r9
        L_0x00d3:
            cris.org.in.ima.model.TrainBtwnStnsModel r9 = r1.f4928a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r9.d()
            r1.f4931a = r9
            java.lang.String r9 = "selectedQuota"
            java.lang.String r9 = r0.getString(r9)
            O = r9
            f2 r9 = r1.f4934a
            java.util.List r9 = r9.getAvlFareResponseDTO()
            java.lang.Object r9 = r9.get(r4)
            cris.prs.webservices.dto.AvlFareResponseDTO r9 = (cris.prs.webservices.dto.AvlFareResponseDTO) r9
            r1.f4948b = r9
            boolean r9 = defpackage.C0535I5.f3647h
            if (r9 == 0) goto L_0x0103
            f2 r9 = r1.f4934a
            java.util.List r9 = r9.getAvlFareResponseDTO()
            java.lang.Object r9 = r9.get(r6)
            cris.prs.webservices.dto.AvlFareResponseDTO r9 = (cris.prs.webservices.dto.AvlFareResponseDTO) r9
            r1.f4958c = r9
        L_0x0103:
            cris.prs.webservices.dto.AvlFareResponseDTO r9 = r1.f4948b
            r1.f4929a = r9
            java.lang.String r9 = "AvailablityDTOTrain1"
            java.io.Serializable r9 = r0.getSerializable(r9)
            d2 r9 = (defpackage.C1060d2) r9
            boolean r9 = defpackage.C0535I5.f3647h
            if (r9 == 0) goto L_0x0121
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r9 = r1.f5021z
            java.lang.Object r9 = r9.get(r6)
            cris.org.in.ima.model.TrainBtwnStnsModel r9 = (cris.org.in.ima.model.TrainBtwnStnsModel) r9
            d2 r9 = r9.a()
            r1.f4950b = r9
        L_0x0121:
            java.util.ArrayList<cris.org.in.ima.model.TrainBtwnStnsModel> r9 = r1.f5021z
            java.lang.Object r9 = r9.get(r4)
            cris.org.in.ima.model.TrainBtwnStnsModel r9 = (cris.org.in.ima.model.TrainBtwnStnsModel) r9
            d2 r9 = r9.a()
            r1.f4932a = r9
            java.lang.String r9 = "boardingStnListDTO"
            java.io.Serializable r9 = r0.getSerializable(r9)
            Z2 r9 = (defpackage.Z2) r9
            r1.f4902a = r9
            java.util.List r9 = r9.getBkgCfgs()
            java.lang.Object r9 = r9.get(r4)
            b3 r9 = (defpackage.C0794b3) r9
            java.util.List r9 = r9.getInformationMessageDTO()
            if (r9 == 0) goto L_0x015b
            Z2 r9 = r1.f4902a
            java.util.List r9 = r9.getBkgCfgs()
            java.lang.Object r9 = r9.get(r4)
            b3 r9 = (defpackage.C0794b3) r9
            java.util.List r9 = r9.getInformationMessageDTO()
            r1.f4942a = r9
        L_0x015b:
            java.lang.String r9 = "selectedQuota"
            java.lang.String r9 = r0.getString(r9)
            P = r9
            java.lang.String r9 = "spConcession"
            java.lang.String r9 = r0.getString(r9)
            S = r9
            java.lang.String r9 = "journalistconcession"
            boolean r9 = r0.getBoolean(r9)
            t = r9
            java.lang.String r9 = "divyanconcession"
            boolean r9 = r0.getBoolean(r9)
            u = r9
            Z2 r9 = r1.f4902a
            java.util.List r9 = r9.getBkgCfgs()
            f4889c = r9
            f2 r10 = r1.f4934a
            java.lang.Object r9 = r9.get(r4)
            b3 r9 = (defpackage.C0794b3) r9
            mo r9 = r9.getPaymentOption()
            r10.setPaymentOption(r9)
            java.util.List<b3> r9 = f4889c
            java.lang.Object r9 = r9.get(r4)
            b3 r9 = (defpackage.C0794b3) r9
            f4886a = r9
            boolean r9 = defpackage.C0535I5.f3647h
            if (r9 == 0) goto L_0x01aa
            java.util.List<b3> r9 = f4889c
            java.lang.Object r9 = r9.get(r6)
            b3 r9 = (defpackage.C0794b3) r9
            b = r9
        L_0x01aa:
            java.lang.String r9 = "AvailLastUpdate"
            java.lang.String r9 = r0.getString(r9)
            T = r9
            d2 r9 = r1.f4932a
            java.lang.String r9 = r9.getAvailablityDate()
            r1.f4992l = r9
            boolean r9 = defpackage.C0535I5.f3647h
            if (r9 == 0) goto L_0x01c6
            d2 r9 = r1.f4950b
            java.lang.String r9 = r9.getAvailablityDate()
            r1.f4995m = r9
        L_0x01c6:
            r1.V0(r7)
            cris.org.in.ima.activities.HomeActivity.t()
            java.lang.String r9 = "mainPnr"
            boolean r9 = r0.containsKey(r9)
            if (r9 == 0) goto L_0x01dc
            java.lang.String r9 = "mainPnr"
            java.lang.String r9 = r0.getString(r9)
            r1.J = r9
        L_0x01dc:
            java.lang.String r9 = r1.f4992l
            cris.prs.webservices.dto.TrainBtwnStnsDTO r10 = r1.f4931a
            java.lang.String r10 = r10.getDepartureTime()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r11 = r1.f4931a
            java.lang.String r11 = r11.getDuration()
            java.util.GregorianCalendar r9 = a0(r9, r10, r11)
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat
            r10.<init>(r8)
            java.util.Date r9 = r9.getTime()
            java.lang.String r9 = r10.format(r9)
            Q = r9
            java.lang.String r9 = r1.f4992l
            cris.prs.webservices.dto.TrainBtwnStnsDTO r10 = r1.f4931a
            java.lang.String r10 = r10.getArrivalTime()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r11 = r1.f4931a
            java.lang.String r11 = r11.getDuration()
            java.util.GregorianCalendar r9 = a0(r9, r10, r11)
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat
            r10.<init>(r8)
            java.util.Date r9 = r9.getTime()
            java.lang.String r9 = r10.format(r9)
            Q = r9
            java.lang.String r9 = r1.f4992l
            cris.prs.webservices.dto.TrainBtwnStnsDTO r10 = r1.f4931a
            java.lang.String r10 = r10.getDepartureTime()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r11 = r1.f4931a
            java.lang.String r11 = r11.getDuration()
            java.lang.String r9 = p0(r9, r10, r11)
            r1.f5001o = r9
            boolean r9 = defpackage.C0535I5.f3647h
            if (r9 == 0) goto L_0x0252
            java.lang.String r9 = r1.f4995m
            cris.org.in.ima.model.TrainBtwnStnsModel r10 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r10 = r10.d()
            java.lang.String r10 = r10.getDepartureTime()
            cris.org.in.ima.model.TrainBtwnStnsModel r11 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r11 = r11.d()
            java.lang.String r11 = r11.getDuration()
            java.lang.String r9 = p0(r9, r10, r11)
            R = r9
        L_0x0252:
            cris.prs.webservices.dto.AvlFareResponseDTO r9 = r1.f4929a
            java.lang.String r9 = r9.getEnqClass()
            r1.f4986j = r9
            cris.prs.webservices.dto.AvlFareResponseDTO r9 = r1.f4929a
            java.lang.String r9 = r9.getQuota()
            r1.f4989k = r9
            java.lang.String r9 = "JourneyDate"
            java.lang.String r9 = r0.getString(r9)
            r1.I = r9
            java.lang.String r9 = "highestClass"
            java.lang.String r9 = r0.getString(r9)
            r1.L = r9
            java.lang.String r9 = "isLoyalty"
            boolean r9 = r0.getBoolean(r9)
            r1.f5010r = r9
            java.lang.String r9 = "loyaltyBookingType"
            java.lang.String r9 = r0.getString(r9)
            r1.M = r9
            java.lang.String r9 = "softBankId"
            java.lang.String r9 = r0.getString(r9)
            r1.N = r9
            android.widget.TextView r9 = r1.quota
            java.lang.String r10 = P
            r9.setText(r10)
        L_0x0291:
            java.lang.String r9 = S
            java.lang.String r10 = "S"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x02b0
            android.widget.EditText r9 = r1.et_pass_booking_code
            r9.setVisibility(r4)
            android.widget.LinearLayout r9 = r1.passbooking_concession_ll
            r9.setVisibility(r4)
            android.widget.EditText r9 = r1.et_pass_upn
            r9.setVisibility(r4)
            android.widget.TextView r9 = r1.pass_booking_opt_msg
            r9.setVisibility(r4)
            goto L_0x02b5
        L_0x02b0:
            android.widget.LinearLayout r9 = r1.passbooking_concession_ll
            r9.setVisibility(r3)
        L_0x02b5:
            f2 r9 = r1.f4934a
            mo r9 = r9.getPaymentOption()
            if (r9 == 0) goto L_0x035e
            f2 r9 = r1.f4934a
            mo r9 = r9.getPaymentOption()
            java.lang.String r9 = r9.getHeader()
            if (r9 == 0) goto L_0x035e
            android.widget.LinearLayout r9 = r1.paymentOptionll
            r9.setVisibility(r4)
            androidx.recyclerview.widget.RecyclerView r9 = r1.paymentoptionView
            r9.setVisibility(r4)
            android.widget.TextView r9 = r1.header
            f2 r11 = r1.f4934a
            mo r11 = r11.getPaymentOption()
            java.lang.String r11 = r11.getHeader()
            r9.setText(r11)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r1.f4987j = r9
            f2 r9 = r1.f4934a
            mo r9 = r9.getPaymentOption()
            java.util.List r9 = r9.getOptions()
            java.util.Iterator r9 = r9.iterator()
        L_0x02f7:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x033d
            java.lang.Object r11 = r9.next()
            mo$a r11 = (defpackage.C1262mo.a) r11
            cris.org.in.ima.model.PaymentOptionModel r12 = new cris.org.in.ima.model.PaymentOptionModel
            r12.<init>()
            r12.c(r11)
            java.util.ArrayList r11 = r1.f4987j
            int r11 = r11.size()
            if (r11 != 0) goto L_0x0337
            r12.b()
            mo$a r11 = r12.a()
            java.lang.String r11 = r11.getLabel()
            r1.U0(r11)
            mo$a r11 = r12.a()
            java.lang.String r11 = r11.getDesc()
            r1.T0(r11)
            mo$a r11 = r12.a()
            java.lang.Short r11 = r11.getValue()
            r1.V0(r11)
        L_0x0337:
            java.util.ArrayList r11 = r1.f4987j
            r11.add(r12)
            goto L_0x02f7
        L_0x033d:
            androidx.recyclerview.widget.RecyclerView r9 = r1.paymentoptionView
            androidx.recyclerview.widget.LinearLayoutManager r11 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r12 = r21.getContext()
            r11.<init>(r12, r6, r4)
            r9.setLayoutManager(r11)
            cris.org.in.ima.adaptors.PaymentOptionAdapter r6 = new cris.org.in.ima.adaptors.PaymentOptionAdapter
            android.content.Context r9 = r1.f4904a
            java.util.ArrayList r11 = r1.f4987j
            cris.org.in.ima.fragment.PassengerDetailFragment$g r12 = r1.f4916a
            r6.<init>(r9, r11, r12)
            r1.f4911a = r6
            androidx.recyclerview.widget.RecyclerView r9 = r1.paymentoptionView
            r9.setAdapter(r6)
            goto L_0x0363
        L_0x035e:
            android.widget.LinearLayout r6 = r1.paymentOptionll
            r6.setVisibility(r3)
        L_0x0363:
            java.lang.String r6 = r1.M
            if (r6 == 0) goto L_0x0388
            java.lang.String r9 = "redemption"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x0388
            r1.f4961c = r7
            android.widget.LinearLayout r6 = r1.paymentOptionll
            r6.setVisibility(r3)
            android.widget.LinearLayout r6 = r1.redemption_msg_ll
            r6.setVisibility(r4)
            android.widget.TextView r6 = r1.tv_redemption_msg
            r9 = 2131953069(0x7f1305ad, float:1.9542599E38)
            java.lang.String r9 = r1.getString(r9)
            r6.setText(r9)
            goto L_0x038d
        L_0x0388:
            android.widget.LinearLayout r6 = r1.redemption_msg_ll
            r6.setVisibility(r3)
        L_0x038d:
            java.lang.Boolean r6 = r1.f4936a
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x03b3
            java.util.ArrayList r6 = defpackage.C0535I5.B()
            java.util.Iterator r6 = r6.iterator()
        L_0x039d:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x03b3
            java.lang.Object r9 = r6.next()
            cris.org.in.ima.model.MasterPassengerModel r9 = (cris.org.in.ima.model.MasterPassengerModel) r9
            boolean r11 = r9.a()
            if (r11 == 0) goto L_0x039d
            r9.b()
            goto L_0x039d
        L_0x03b3:
            java.lang.Boolean r6 = r1.f4936a
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x03de
            Z2 r6 = r1.f4902a
            boolean r6 = r6.isMealChoiceenable()
            if (r6 == 0) goto L_0x03de
            java.util.ArrayList<cris.prs.webservices.dto.MealItemDetails> r6 = r1.f4890A
            r6.clear()
            java.util.ArrayList<cris.prs.webservices.dto.MealItemDetails> r6 = r1.f4890A
            java.util.concurrent.CopyOnWriteArrayList r9 = defpackage.C0535I5.C()
            r6.addAll(r9)
            r21.P0()
            android.widget.RelativeLayout r6 = r1.add_meal_rl
            r6.setVisibility(r3)
            androidx.recyclerview.widget.RecyclerView r6 = r1.rv_addmeal_list
            r6.setVisibility(r4)
        L_0x03de:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            f4888b = r4
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            c = r4
            java.lang.String r4 = "rebookFlag"
            boolean r4 = r0.getBoolean(r4)
            r1.f5006p = r4
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r6 = r1.f4968d
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r9 = r1.f4963c
            java.lang.String r11 = "HP"
            java.lang.String r12 = "F"
            java.lang.String r13 = "M"
            java.lang.String r14 = "Y"
            if (r4 == 0) goto L_0x0610
            java.lang.String r4 = "reebookPsgnList"
            java.io.Serializable r4 = r0.getSerializable(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r1.f4978g = r4
            android.widget.RelativeLayout r4 = r1.addPsgnLayout
            r4.setVisibility(r3)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r3 = r1.f4978g
            int r3 = r3.size()
            S0(r3)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r3 = r1.f4978g
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L_0x0421:
            boolean r16 = r3.hasNext()
            if (r16 == 0) goto L_0x050e
            java.lang.Object r16 = r3.next()
            r15 = r16
            cris.prs.webservices.dto.PassengerDetailDTO r15 = (cris.prs.webservices.dto.PassengerDetailDTO) r15
            r9.add(r15)
            boolean r16 = defpackage.C0535I5.f3647h
            if (r16 == 0) goto L_0x0439
            r6.add(r15)
        L_0x0439:
            r23 = r3
            java.util.HashMap<java.lang.Short, java.lang.Short> r3 = f4888b
            r24 = r2
            java.lang.Short r2 = r15.getPassengerSerialNumber()
            r3.put(r2, r5)
            b3 r2 = f4886a
            boolean r2 = r2.isBedRollFlagEnabled()
            if (r2 != 0) goto L_0x04ce
            b3 r2 = f4886a
            boolean r2 = r2.isSeniorCitizenApplicable()
            if (r2 == 0) goto L_0x0490
            java.lang.String r2 = r15.getPassengerGender()
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0470
            java.lang.Short r2 = r15.getPassengerAge()
            short r2 = r2.shortValue()
            b3 r3 = f4886a
            short r3 = r3.getSrctznAge()
            if (r2 >= r3) goto L_0x048a
        L_0x0470:
            java.lang.String r2 = r15.getPassengerGender()
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0490
            java.lang.Short r2 = r15.getPassengerAge()
            short r2 = r2.shortValue()
            b3 r3 = f4886a
            short r3 = r3.getSrctnwAge()
            if (r2 < r3) goto L_0x0490
        L_0x048a:
            java.lang.Boolean r2 = r15.getConcessionOpted()
            if (r2 == 0) goto L_0x04ce
        L_0x0490:
            b3 r2 = f4886a
            boolean r2 = r2.isChildBerthMandatory()
            if (r2 != 0) goto L_0x04a8
            java.lang.Short r2 = r15.getPassengerAge()
            short r2 = r2.shortValue()
            b3 r3 = f4886a
            short r3 = r3.getMaxChildAge()
            if (r2 <= r3) goto L_0x04ce
        L_0x04a8:
            b3 r2 = f4886a
            boolean r2 = r2.isFoodChoiceEnabled()
            if (r2 == 0) goto L_0x04b8
            b3 r2 = f4886a
            java.util.List r2 = r2.getFoodDetails()
            if (r2 != 0) goto L_0x04ce
        L_0x04b8:
            java.lang.String r2 = S
            boolean r2 = r2.equalsIgnoreCase(r14)
            if (r2 != 0) goto L_0x04ce
            java.lang.String r2 = P
            boolean r2 = r2.equalsIgnoreCase(r11)
            if (r2 != 0) goto L_0x04ce
            java.lang.String r2 = r15.getPassengerNationality()
            if (r2 != 0) goto L_0x0508
        L_0x04ce:
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            r3 = 100
            java.lang.Short r4 = java.lang.Short.valueOf(r3)
            boolean r2 = r2.containsKey(r4)
            if (r2 == 0) goto L_0x04fd
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r4 = java.lang.Short.valueOf(r3)
            java.lang.Object r2 = r2.get(r4)
            java.lang.Short r2 = (java.lang.Short) r2
            short r2 = r2.shortValue()
            java.util.HashMap<java.lang.Short, java.lang.Short> r4 = f4888b
            java.lang.Short r15 = java.lang.Short.valueOf(r3)
            int r2 = r2 + 1
            short r2 = (short) r2
            java.lang.Short r2 = java.lang.Short.valueOf(r2)
            r4.put(r15, r2)
            goto L_0x0506
        L_0x04fd:
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r4 = java.lang.Short.valueOf(r3)
            r2.put(r4, r7)
        L_0x0506:
            r2 = 1
            r4 = r2
        L_0x0508:
            r3 = r23
            r2 = r24
            goto L_0x0421
        L_0x050e:
            r24 = r2
            if (r4 == 0) goto L_0x05f4
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            java.util.Iterator r2 = r2.iterator()
        L_0x0518:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x05e2
            java.lang.Object r3 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3
            b3 r4 = f4886a
            boolean r4 = r4.isBedRollFlagEnabled()
            if (r4 != 0) goto L_0x05be
            b3 r4 = f4886a
            boolean r4 = r4.isSeniorCitizenApplicable()
            if (r4 == 0) goto L_0x054e
            java.lang.String r4 = r3.getPassengerGender()
            boolean r4 = r4.equals(r13)
            if (r4 == 0) goto L_0x054e
            java.lang.Short r4 = r3.getPassengerAge()
            short r4 = r4.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctznAge()
            if (r4 >= r15) goto L_0x05be
        L_0x054e:
            java.lang.String r4 = r3.getPassengerGender()
            boolean r4 = r4.equals(r12)
            if (r4 == 0) goto L_0x056e
            java.lang.Short r4 = r3.getPassengerAge()
            short r4 = r4.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctnwAge()
            if (r4 < r15) goto L_0x056e
            java.lang.Boolean r4 = r3.getConcessionOpted()
            if (r4 == 0) goto L_0x05be
        L_0x056e:
            b3 r4 = f4886a
            boolean r4 = r4.isChildBerthMandatory()
            if (r4 != 0) goto L_0x0586
            java.lang.Short r4 = r3.getPassengerAge()
            short r4 = r4.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getMaxChildAge()
            if (r4 <= r15) goto L_0x05be
        L_0x0586:
            b3 r4 = f4886a
            boolean r4 = r4.isFoodChoiceEnabled()
            if (r4 == 0) goto L_0x0596
            b3 r4 = f4886a
            java.util.List r4 = r4.getFoodDetails()
            if (r4 != 0) goto L_0x05be
        L_0x0596:
            java.lang.String r4 = S
            boolean r4 = r4.equalsIgnoreCase(r14)
            if (r4 != 0) goto L_0x05be
            java.lang.String r4 = P
            boolean r4 = r4.equalsIgnoreCase(r11)
            if (r4 != 0) goto L_0x05be
            java.lang.String r4 = r3.getPassengerNationality()
            if (r4 == 0) goto L_0x05be
            java.lang.String r4 = r3.getPassengerBerthChoice()
            if (r4 == 0) goto L_0x0518
            java.lang.String r4 = r3.getPassengerBerthChoice()
            java.lang.String r15 = "NC"
            boolean r4 = r4.equalsIgnoreCase(r15)
            if (r4 == 0) goto L_0x0518
        L_0x05be:
            java.lang.Short r3 = r3.getPassengerSerialNumber()
            short r3 = r3.shortValue()
            r4 = 4
            if (r3 <= r4) goto L_0x0518
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r21.getContext()
            r2.<init>(r3)
            androidx.recyclerview.widget.RecyclerView r3 = r1.passengerList
            r3.setLayoutManager(r2)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r3 = r1.f4978g
            int r3 = r3.size()
            int r3 = r3 + -1
            r2.scrollToPosition(r3)
        L_0x05e2:
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            r3 = 2131951990(0x7f130176, float:1.954041E38)
            java.lang.String r3 = r1.getString(r3)
            r4 = 2131953334(0x7f1306b6, float:1.9543136E38)
            r15 = 0
            defpackage.C0709Uj.q(r1, r4, r2, r3, r15)
        L_0x05f4:
            com.google.android.gms.ads.admanager.AdManagerAdView r2 = r1.passengerCenter
            r3 = 8
            r2.setVisibility(r3)
            androidx.recyclerview.widget.RecyclerView r2 = r1.passengerList
            r3 = 0
            r2.setVisibility(r3)
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x0612
            androidx.recyclerview.widget.RecyclerView r2 = r1.rv_passenger_list_lap2
            r2.setVisibility(r3)
            android.widget.LinearLayout r2 = r1.select_passenger_lap2
            r2.setVisibility(r3)
            goto L_0x0612
        L_0x0610:
            r24 = r2
        L_0x0612:
            java.lang.String r2 = "isLinkedJoureny"
            boolean r2 = r0.getBoolean(r2)
            r1.f5003o = r2
            java.lang.Boolean r2 = r1.f4936a
            boolean r2 = r2.booleanValue()
            e2 r3 = r1.f4933a
            if (r2 != 0) goto L_0x0753
            boolean r2 = r1.f5003o
            if (r2 == 0) goto L_0x0753
            java.lang.String r2 = "psgnSetails"
            java.io.Serializable r2 = r0.getSerializable(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r1.f4978g = r2
            android.widget.RelativeLayout r2 = r1.addPsgnLayout
            r4 = 8
            r2.setVisibility(r4)
            android.widget.RelativeLayout r2 = r1.existingpassenger_ll
            r2.setVisibility(r4)
            java.lang.String r2 = r1.J
            r3.setMainJourneyPnr(r2)
            r2 = 1
            r3.setConnectingJourney(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r1.passengerList
            r15 = 0
            r2.setVisibility(r15)
            android.widget.TextView r2 = r1.add_infant_with_berth
            r2.setVisibility(r4)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            int r2 = r2.size()
            S0(r2)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            java.util.Iterator r2 = r2.iterator()
            r4 = 0
        L_0x0662:
            boolean r15 = r2.hasNext()
            if (r15 == 0) goto L_0x06d9
            java.lang.Object r15 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r15 = (cris.prs.webservices.dto.PassengerDetailDTO) r15
            r9.add(r15)
            r23 = r2
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r15 = r15.getPassengerSerialNumber()
            r2.put(r15, r5)
            b3 r2 = f4886a
            java.util.ArrayList r2 = r2.getApplicableBerthTypes()
            if (r2 != 0) goto L_0x06d2
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            r15 = 0
            java.lang.Object r2 = r2.get(r15)
            cris.prs.webservices.dto.PassengerDetailDTO r2 = (cris.prs.webservices.dto.PassengerDetailDTO) r2
            java.lang.String r2 = r2.getBookingBerthCode()
            if (r2 == 0) goto L_0x06d2
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            r4 = 100
            java.lang.Short r15 = java.lang.Short.valueOf(r4)
            boolean r2 = r2.containsKey(r15)
            if (r2 == 0) goto L_0x06c4
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r15 = java.lang.Short.valueOf(r4)
            java.lang.Object r2 = r2.get(r15)
            java.lang.Short r2 = (java.lang.Short) r2
            short r2 = r2.shortValue()
            java.util.HashMap<java.lang.Short, java.lang.Short> r15 = f4888b
            r16 = r10
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            int r2 = r2 + 1
            short r2 = (short) r2
            java.lang.Short r2 = java.lang.Short.valueOf(r2)
            r15.put(r10, r2)
            goto L_0x06cf
        L_0x06c4:
            r16 = r10
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            r2.put(r10, r7)
        L_0x06cf:
            r2 = 1
            r4 = r2
            goto L_0x06d4
        L_0x06d2:
            r16 = r10
        L_0x06d4:
            r2 = r23
            r10 = r16
            goto L_0x0662
        L_0x06d9:
            r16 = r10
            if (r4 == 0) goto L_0x073c
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            java.util.Iterator r2 = r2.iterator()
        L_0x06e3:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x072a
            java.lang.Object r4 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r4 = (cris.prs.webservices.dto.PassengerDetailDTO) r4
            b3 r10 = f4886a
            java.util.ArrayList r10 = r10.getApplicableBerthTypes()
            if (r10 != 0) goto L_0x06e3
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r10 = r1.f4978g
            r15 = 0
            java.lang.Object r10 = r10.get(r15)
            cris.prs.webservices.dto.PassengerDetailDTO r10 = (cris.prs.webservices.dto.PassengerDetailDTO) r10
            java.lang.String r10 = r10.getBookingBerthCode()
            if (r10 == 0) goto L_0x06e3
            java.lang.Short r4 = r4.getPassengerSerialNumber()
            short r4 = r4.shortValue()
            r10 = 4
            if (r4 <= r10) goto L_0x06e3
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r21.getContext()
            r2.<init>(r4)
            androidx.recyclerview.widget.RecyclerView r4 = r1.passengerList
            r4.setLayoutManager(r2)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r4 = r1.f4978g
            int r4 = r4.size()
            int r4 = r4 + -1
            r2.scrollToPosition(r4)
        L_0x072a:
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            r4 = 2131951990(0x7f130176, float:1.954041E38)
            java.lang.String r4 = r1.getString(r4)
            r10 = 2131953334(0x7f1306b6, float:1.9543136E38)
            r15 = 0
            defpackage.C0709Uj.q(r1, r10, r2, r4, r15)
        L_0x073c:
            com.google.android.gms.ads.admanager.AdManagerAdView r2 = r1.passengerCenter
            r4 = 8
            r2.setVisibility(r4)
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x075e
            android.widget.LinearLayout r2 = r1.select_passenger_lap2
            r4 = 0
            r2.setVisibility(r4)
            androidx.recyclerview.widget.RecyclerView r2 = r1.rv_passenger_list_lap2
            r2.setVisibility(r4)
            goto L_0x075e
        L_0x0753:
            r16 = r10
            r2 = 0
            r3.setConnectingJourney(r2)
            android.widget.RelativeLayout r4 = r1.addPsgnLayout
            r4.setVisibility(r2)
        L_0x075e:
            java.lang.Boolean r2 = r1.f4936a
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0977
            boolean r2 = defpackage.C1450w1.e()
            if (r2 == 0) goto L_0x0977
            java.lang.String r2 = "psgnDetails"
            java.io.Serializable r2 = r0.getSerializable(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r1.f4978g = r2
            java.lang.String r2 = "mpPsgnDetails"
            java.io.Serializable r2 = r0.getSerializable(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r1.f5019x = r2
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            int r2 = r2.size()
            r1.j = r2
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            int r2 = r2.size()
            S0(r2)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            java.util.Iterator r2 = r2.iterator()
            r4 = 0
        L_0x0798:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x0883
            java.lang.Object r10 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r10 = (cris.prs.webservices.dto.PassengerDetailDTO) r10
            r9.add(r10)
            boolean r15 = defpackage.C0535I5.f3647h
            if (r15 == 0) goto L_0x07ae
            r6.add(r10)
        L_0x07ae:
            java.util.HashMap<java.lang.Short, java.lang.Short> r15 = f4888b
            r23 = r2
            java.lang.Short r2 = r10.getPassengerSerialNumber()
            r15.put(r2, r5)
            boolean r2 = defpackage.C1450w1.e()
            if (r2 == 0) goto L_0x07c5
            java.lang.Short r2 = r10.getPassengerAge()
            if (r2 == 0) goto L_0x0845
        L_0x07c5:
            b3 r2 = f4886a
            boolean r2 = r2.isBedRollFlagEnabled()
            if (r2 != 0) goto L_0x0845
            b3 r2 = f4886a
            boolean r2 = r2.isSeniorCitizenApplicable()
            if (r2 == 0) goto L_0x0809
            java.lang.String r2 = r10.getPassengerGender()
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x07ef
            java.lang.Short r2 = r10.getPassengerAge()
            short r2 = r2.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctznAge()
            if (r2 >= r15) goto L_0x0845
        L_0x07ef:
            java.lang.String r2 = r10.getPassengerGender()
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0809
            java.lang.Short r2 = r10.getPassengerAge()
            short r2 = r2.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctnwAge()
            if (r2 >= r15) goto L_0x0845
        L_0x0809:
            b3 r2 = f4886a
            boolean r2 = r2.isChildBerthMandatory()
            if (r2 != 0) goto L_0x0821
            java.lang.Short r2 = r10.getPassengerAge()
            short r2 = r2.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getMaxChildAge()
            if (r2 <= r15) goto L_0x0845
        L_0x0821:
            b3 r2 = f4886a
            boolean r2 = r2.isFoodChoiceEnabled()
            if (r2 == 0) goto L_0x082f
            java.lang.String r2 = r10.getPassengerFoodChoice()
            if (r2 == 0) goto L_0x0845
        L_0x082f:
            java.lang.String r2 = S
            boolean r2 = r2.equalsIgnoreCase(r14)
            if (r2 != 0) goto L_0x0845
            java.lang.String r2 = P
            boolean r2 = r2.equalsIgnoreCase(r11)
            if (r2 != 0) goto L_0x0845
            java.lang.String r2 = r10.getPassengerNationality()
            if (r2 != 0) goto L_0x087f
        L_0x0845:
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            r4 = 100
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            boolean r2 = r2.containsKey(r10)
            if (r2 == 0) goto L_0x0874
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            java.lang.Object r2 = r2.get(r10)
            java.lang.Short r2 = (java.lang.Short) r2
            short r2 = r2.shortValue()
            java.util.HashMap<java.lang.Short, java.lang.Short> r10 = f4888b
            java.lang.Short r15 = java.lang.Short.valueOf(r4)
            int r2 = r2 + 1
            short r2 = (short) r2
            java.lang.Short r2 = java.lang.Short.valueOf(r2)
            r10.put(r15, r2)
            goto L_0x087d
        L_0x0874:
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            r2.put(r10, r7)
        L_0x087d:
            r2 = 1
            r4 = r2
        L_0x087f:
            r2 = r23
            goto L_0x0798
        L_0x0883:
            if (r4 == 0) goto L_0x095b
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            java.util.Iterator r2 = r2.iterator()
        L_0x088b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0949
            java.lang.Object r4 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r4 = (cris.prs.webservices.dto.PassengerDetailDTO) r4
            boolean r10 = defpackage.C1450w1.e()
            if (r10 == 0) goto L_0x08a3
            java.lang.Short r10 = r4.getPassengerAge()
            if (r10 == 0) goto L_0x0925
        L_0x08a3:
            b3 r10 = f4886a
            boolean r10 = r10.isBedRollFlagEnabled()
            if (r10 != 0) goto L_0x0925
            b3 r10 = f4886a
            boolean r10 = r10.isSeniorCitizenApplicable()
            if (r10 == 0) goto L_0x08cd
            java.lang.String r10 = r4.getPassengerGender()
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x08cd
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctznAge()
            if (r10 >= r15) goto L_0x0925
        L_0x08cd:
            java.lang.String r10 = r4.getPassengerGender()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x08e7
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctnwAge()
            if (r10 >= r15) goto L_0x0925
        L_0x08e7:
            b3 r10 = f4886a
            boolean r10 = r10.isChildBerthMandatory()
            if (r10 != 0) goto L_0x08ff
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getMaxChildAge()
            if (r10 <= r15) goto L_0x0925
        L_0x08ff:
            b3 r10 = f4886a
            boolean r10 = r10.isFoodChoiceEnabled()
            if (r10 == 0) goto L_0x090f
            b3 r10 = f4886a
            java.util.List r10 = r10.getFoodDetails()
            if (r10 != 0) goto L_0x0925
        L_0x090f:
            java.lang.String r10 = S
            boolean r10 = r10.equalsIgnoreCase(r14)
            if (r10 != 0) goto L_0x0925
            java.lang.String r10 = P
            boolean r10 = r10.equalsIgnoreCase(r11)
            if (r10 != 0) goto L_0x0925
            java.lang.String r10 = r4.getPassengerNationality()
            if (r10 != 0) goto L_0x088b
        L_0x0925:
            java.lang.Short r4 = r4.getPassengerSerialNumber()
            short r4 = r4.shortValue()
            r10 = 4
            if (r4 <= r10) goto L_0x088b
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r21.getContext()
            r2.<init>(r4)
            androidx.recyclerview.widget.RecyclerView r4 = r1.passengerList
            r4.setLayoutManager(r2)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r4 = r1.f4978g
            int r4 = r4.size()
            int r4 = r4 + -1
            r2.scrollToPosition(r4)
        L_0x0949:
            androidx.fragment.app.FragmentActivity r2 = r21.getActivity()
            r4 = 2131951990(0x7f130176, float:1.954041E38)
            java.lang.String r4 = r1.getString(r4)
            r10 = 2131951928(0x7f130138, float:1.9540284E38)
            r15 = 0
            defpackage.C0709Uj.q(r1, r10, r2, r4, r15)
        L_0x095b:
            com.google.android.gms.ads.admanager.AdManagerAdView r2 = r1.passengerCenter
            r4 = 8
            r2.setVisibility(r4)
            androidx.recyclerview.widget.RecyclerView r2 = r1.passengerList
            r4 = 0
            r2.setVisibility(r4)
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x0978
            android.widget.LinearLayout r2 = r1.select_passenger_lap2
            r2.setVisibility(r4)
            androidx.recyclerview.widget.RecyclerView r2 = r1.rv_passenger_list_lap2
            r2.setVisibility(r4)
            goto L_0x0978
        L_0x0977:
            r4 = 0
        L_0x0978:
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x0986
            android.widget.LinearLayout r2 = r1.select_passenger_lap2
            r2.setVisibility(r4)
            androidx.recyclerview.widget.RecyclerView r2 = r1.rv_passenger_list_lap2
            r2.setVisibility(r4)
        L_0x0986:
            java.lang.Boolean r2 = r1.f4936a
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0b7d
            boolean r2 = r1.f5010r
            if (r2 == 0) goto L_0x0b7d
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            r2.clear()
            java.lang.String r2 = "loyaltypsgnlist"
            java.io.Serializable r0 = r0.getSerializable(r2)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r1.f4978g = r0
            int r0 = r0.size()
            S0(r0)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r0 = r1.f4978g
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x09af:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0a95
            java.lang.Object r4 = r0.next()
            cris.prs.webservices.dto.PassengerDetailDTO r4 = (cris.prs.webservices.dto.PassengerDetailDTO) r4
            r9.add(r4)
            boolean r10 = defpackage.C0535I5.f3647h
            if (r10 == 0) goto L_0x09c5
            r6.add(r4)
        L_0x09c5:
            java.util.HashMap<java.lang.Short, java.lang.Short> r10 = f4888b
            java.lang.Short r15 = r4.getPassengerSerialNumber()
            r10.put(r15, r5)
            boolean r10 = defpackage.C1450w1.e()
            if (r10 == 0) goto L_0x09da
            java.lang.Short r10 = r4.getPassengerAge()
            if (r10 == 0) goto L_0x0a5a
        L_0x09da:
            b3 r10 = f4886a
            boolean r10 = r10.isBedRollFlagEnabled()
            if (r10 != 0) goto L_0x0a5a
            b3 r10 = f4886a
            boolean r10 = r10.isSeniorCitizenApplicable()
            if (r10 == 0) goto L_0x0a1e
            java.lang.String r10 = r4.getPassengerGender()
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x0a04
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctznAge()
            if (r10 >= r15) goto L_0x0a5a
        L_0x0a04:
            java.lang.String r10 = r4.getPassengerGender()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x0a1e
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getSrctnwAge()
            if (r10 >= r15) goto L_0x0a5a
        L_0x0a1e:
            b3 r10 = f4886a
            boolean r10 = r10.isChildBerthMandatory()
            if (r10 != 0) goto L_0x0a36
            java.lang.Short r10 = r4.getPassengerAge()
            short r10 = r10.shortValue()
            b3 r15 = f4886a
            short r15 = r15.getMaxChildAge()
            if (r10 <= r15) goto L_0x0a5a
        L_0x0a36:
            b3 r10 = f4886a
            boolean r10 = r10.isFoodChoiceEnabled()
            if (r10 == 0) goto L_0x0a44
            java.lang.String r10 = r4.getPassengerFoodChoice()
            if (r10 == 0) goto L_0x0a5a
        L_0x0a44:
            java.lang.String r10 = S
            boolean r10 = r10.equalsIgnoreCase(r14)
            if (r10 != 0) goto L_0x0a5a
            java.lang.String r10 = P
            boolean r10 = r10.equalsIgnoreCase(r11)
            if (r10 != 0) goto L_0x0a5a
            java.lang.String r4 = r4.getPassengerNationality()
            if (r4 != 0) goto L_0x09af
        L_0x0a5a:
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            r4 = 100
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            boolean r2 = r2.containsKey(r10)
            if (r2 == 0) goto L_0x0a89
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            java.lang.Object r2 = r2.get(r10)
            java.lang.Short r2 = (java.lang.Short) r2
            short r2 = r2.shortValue()
            java.util.HashMap<java.lang.Short, java.lang.Short> r10 = f4888b
            java.lang.Short r15 = java.lang.Short.valueOf(r4)
            int r2 = r2 + 1
            short r2 = (short) r2
            java.lang.Short r2 = java.lang.Short.valueOf(r2)
            r10.put(r15, r2)
            goto L_0x0a92
        L_0x0a89:
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = f4888b
            java.lang.Short r10 = java.lang.Short.valueOf(r4)
            r2.put(r10, r7)
        L_0x0a92:
            r2 = 1
            goto L_0x09af
        L_0x0a95:
            if (r2 == 0) goto L_0x0b61
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r0 = r1.f4978g
            java.util.Iterator r0 = r0.iterator()
        L_0x0a9d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0b4f
            java.lang.Object r2 = r0.next()
            cris.prs.webservices.dto.PassengerDetailDTO r2 = (cris.prs.webservices.dto.PassengerDetailDTO) r2
            b3 r4 = f4886a
            boolean r4 = r4.isBedRollFlagEnabled()
            if (r4 != 0) goto L_0x0b2b
            b3 r4 = f4886a
            boolean r4 = r4.isSeniorCitizenApplicable()
            if (r4 == 0) goto L_0x0ad3
            java.lang.String r4 = r2.getPassengerGender()
            boolean r4 = r4.equals(r13)
            if (r4 == 0) goto L_0x0ad3
            java.lang.Short r4 = r2.getPassengerAge()
            short r4 = r4.shortValue()
            b3 r6 = f4886a
            short r6 = r6.getSrctznAge()
            if (r4 >= r6) goto L_0x0b2b
        L_0x0ad3:
            java.lang.String r4 = r2.getPassengerGender()
            boolean r4 = r4.equals(r12)
            if (r4 == 0) goto L_0x0aed
            java.lang.Short r4 = r2.getPassengerAge()
            short r4 = r4.shortValue()
            b3 r6 = f4886a
            short r6 = r6.getSrctnwAge()
            if (r4 >= r6) goto L_0x0b2b
        L_0x0aed:
            b3 r4 = f4886a
            boolean r4 = r4.isChildBerthMandatory()
            if (r4 != 0) goto L_0x0b05
            java.lang.Short r4 = r2.getPassengerAge()
            short r4 = r4.shortValue()
            b3 r6 = f4886a
            short r6 = r6.getMaxChildAge()
            if (r4 <= r6) goto L_0x0b2b
        L_0x0b05:
            b3 r4 = f4886a
            boolean r4 = r4.isFoodChoiceEnabled()
            if (r4 == 0) goto L_0x0b15
            b3 r4 = f4886a
            java.util.List r4 = r4.getFoodDetails()
            if (r4 != 0) goto L_0x0b2b
        L_0x0b15:
            java.lang.String r4 = S
            boolean r4 = r4.equalsIgnoreCase(r14)
            if (r4 != 0) goto L_0x0b2b
            java.lang.String r4 = P
            boolean r4 = r4.equalsIgnoreCase(r11)
            if (r4 != 0) goto L_0x0b2b
            java.lang.String r4 = r2.getPassengerNationality()
            if (r4 != 0) goto L_0x0a9d
        L_0x0b2b:
            java.lang.Short r2 = r2.getPassengerSerialNumber()
            short r2 = r2.shortValue()
            r4 = 4
            if (r2 <= r4) goto L_0x0a9d
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r21.getContext()
            r0.<init>(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r1.passengerList
            r2.setLayoutManager(r0)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            int r2 = r2.size()
            int r2 = r2 + -1
            r0.scrollToPosition(r2)
        L_0x0b4f:
            androidx.fragment.app.FragmentActivity r0 = r21.getActivity()
            r2 = 2131951990(0x7f130176, float:1.954041E38)
            java.lang.String r2 = r1.getString(r2)
            r4 = 2131951928(0x7f130138, float:1.9540284E38)
            r6 = 0
            defpackage.C0709Uj.q(r1, r4, r0, r2, r6)
        L_0x0b61:
            com.google.android.gms.ads.admanager.AdManagerAdView r0 = r1.passengerCenter
            r2 = 8
            r0.setVisibility(r2)
            androidx.recyclerview.widget.RecyclerView r0 = r1.passengerList
            r2 = 0
            r0.setVisibility(r2)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0b7e
            androidx.recyclerview.widget.RecyclerView r0 = r1.rv_passenger_list_lap2
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.select_passenger_lap2
            r0.setVisibility(r2)
            goto L_0x0b7e
        L_0x0b7d:
            r2 = 0
        L_0x0b7e:
            Z2 r0 = r1.f4902a
            boolean r0 = r0.isMealChoiceenable()
            if (r0 == 0) goto L_0x0b8c
            android.widget.LinearLayout r0 = r1.add_meal_ll
            r0.setVisibility(r2)
            goto L_0x0b93
        L_0x0b8c:
            android.widget.LinearLayout r0 = r1.add_meal_ll
            r2 = 8
            r0.setVisibility(r2)
        L_0x0b93:
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = new cris.org.in.ima.dto.oauth2.GoogleAdParamDTO
            r0.<init>()
            r1.f4913a = r0
            java.lang.String r2 = defpackage.C1450w1.a()
            r0.setAge(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r1.f4913a
            java.lang.String r2 = defpackage.C1450w1.b()
            r0.setGender(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r1.f4913a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r1.f4931a
            java.lang.String r2 = r2.getFromStnCode()
            r0.setSource(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r1.f4913a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r1.f4931a
            java.util.List r2 = r2.getTrainType()
            r4 = 0
            java.lang.Object r2 = r2.get(r4)
            java.lang.String r2 = (java.lang.String) r2
            r0.setTrainType(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r1.f4913a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r1.f4931a
            java.lang.String r2 = r2.getToStnCode()
            r0.setDestination(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r1.f4913a
            java.lang.String r2 = Q
            r0.setArrivalDate(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r1.f4913a
            java.lang.String r2 = r1.f4986j
            r0.setjClass(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r1.f4913a
            java.lang.String r2 = O
            r0.setQuata(r2)
            java.lang.String r0 = r1.f4992l     // Catch:{ Exception -> 0x0bf3 }
            java.lang.String r0 = r1.n0(r0, r8)     // Catch:{ Exception -> 0x0bf3 }
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r2 = r1.f4913a     // Catch:{ Exception -> 0x0bf3 }
            r2.setDepartureDate(r0)     // Catch:{ Exception -> 0x0bf3 }
            goto L_0x0bf7
        L_0x0bf3:
            r0 = move-exception
            r0.getMessage()
        L_0x0bf7:
            androidx.fragment.app.FragmentActivity r0 = r21.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r2 = r1.passengerCenter
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r4 = r1.f4913a
            defpackage.C0535I5.Y(r0, r2, r4)
            androidx.fragment.app.FragmentActivity r0 = r21.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r2 = r1.addPassengerBottom
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r4 = r1.f4913a
            defpackage.C0535I5.Y(r0, r2, r4)
            androidx.fragment.app.FragmentActivity r0 = r21.getActivity()
            com.google.android.gms.ads.admanager.AdManagerAdView r2 = r1.passenger_detail_existing
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r4 = r1.f4913a
            defpackage.C0535I5.Y(r0, r2, r4)
            java.lang.String r0 = r1.f4992l
            java.lang.String r2 = " EEE, dd MMM  yyyy"
            java.lang.String r0 = r1.n0(r0, r2)
            r1.f4998n = r0
            boolean r0 = defpackage.C0535I5.f3647h
            java.lang.String r2 = " "
            if (r0 == 0) goto L_0x0c65
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f4931a
            java.lang.String r4 = r4.getFromStnCode()
            r0.append(r4)
            r0.append(r2)
            r4 = 2131953827(0x7f1308a3, float:1.9544136E38)
            java.lang.String r4 = r1.getString(r4)
            r0.append(r4)
            r0.append(r2)
            cris.org.in.ima.model.TrainBtwnStnsModel r4 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r4.d()
            java.lang.String r4 = r4.getToStnCode()
            r0.append(r4)
            java.lang.String r4 = " | "
            r0.append(r4)
            java.lang.String r4 = r1.f4998n
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            cris.org.in.ima.activities.HomeActivity.H(r0)
            goto L_0x0c9d
        L_0x0c65:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f4931a
            java.lang.String r4 = r4.getFromStnCode()
            r0.append(r4)
            r0.append(r2)
            r4 = 2131953827(0x7f1308a3, float:1.9544136E38)
            java.lang.String r4 = r1.getString(r4)
            r0.append(r4)
            r0.append(r2)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f4931a
            java.lang.String r4 = r4.getToStnCode()
            r0.append(r4)
            java.lang.String r4 = " | "
            r0.append(r4)
            java.lang.String r4 = r1.f4998n
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            cris.org.in.ima.activities.HomeActivity.H(r0)
        L_0x0c9d:
            java.lang.String r0 = r1.f4992l
            java.lang.String r4 = "EEE, dd MMM"
            java.lang.String r0 = r1.n0(r0, r4)
            r1.f4998n = r0
            Z2 r0 = r1.f4902a
            java.util.ArrayList r0 = r0.getBoardingStationList()
            r1.f4975f = r0
            android.widget.TextView r0 = r1.tvBoardingStation
            cris.org.in.ima.db.StationDb r6 = r1.f4912a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r7 = r1.f4931a
            java.lang.String r7 = r7.getFromStnCode()
            java.lang.String r6 = r6.m(r7)
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r0.setText(r6)
            android.widget.TextView r0 = r1.trainName
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = r1.f4931a
            java.lang.String r6 = r6.getTrainName()
            r0.setText(r6)
            android.widget.TextView r0 = r1.trainNumber
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "("
            r6.<init>(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r8 = r1.f4931a
            java.lang.String r8 = r8.getTrainNumber()
            r6.append(r8)
            java.lang.String r8 = ")"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r0.setText(r6)
            android.widget.TextView r0 = r1.fromStationCode
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r1.f4931a
            java.lang.String r9 = r9.getFromStnCode()
            r6.append(r9)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r0.setText(r6)
            android.widget.TextView r0 = r1.toStatinCode
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r1.f4931a
            java.lang.String r9 = r9.getToStnCode()
            r6.append(r9)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r0.setText(r6)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.lang.String r0 = r0.getDuration()
            java.lang.String r6 = ":"
            java.lang.String[] r6 = r0.split(r6)
            int r0 = r6.length
            r9 = 3
            r10 = 2
            java.lang.String r11 = "h:"
            if (r0 != r10) goto L_0x0d4c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r9 = 0
            r9 = r6[r9]
            r0.append(r9)
            r0.append(r11)
            r9 = 1
            r9 = r6[r9]
            java.lang.String r10 = "m."
            java.lang.String r0 = defpackage.C0709Uj.j(r0, r9, r10)
            goto L_0x0d7d
        L_0x0d4c:
            int r0 = r6.length
            if (r0 != r9) goto L_0x0d71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r9 = 0
            r9 = r6[r9]
            r0.append(r9)
            r0.append(r11)
            r9 = 1
            r9 = r6[r9]
            r0.append(r9)
            java.lang.String r9 = "m:"
            r0.append(r9)
            r9 = r6[r10]
            java.lang.String r10 = "s"
            java.lang.String r0 = defpackage.C0709Uj.j(r0, r9, r10)
            goto L_0x0d7d
        L_0x0d71:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r9 = 0
            r9 = r6[r9]
            java.lang.String r0 = defpackage.C0709Uj.j(r0, r9, r11)
        L_0x0d7d:
            android.widget.TextView r9 = r1.travelTime
            r9.setText(r0)
            android.widget.TextView r0 = r1.depTime
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r1.f4931a
            java.lang.String r9 = r9.getDepartureTime()
            r0.setText(r9)
            android.widget.TextView r0 = r1.arrTime
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r1.f4931a
            java.lang.String r9 = r9.getArrivalTime()
            r0.setText(r9)
            android.widget.TextView r0 = r1.departureDateView
            java.lang.String r9 = r1.f4998n
            r0.setText(r9)
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat
            r9.<init>(r4)
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat
            java.lang.String r0 = "EEE, dd MMM yyyy"
            r10.<init>(r0)
            android.widget.TextView r0 = r1.arrivalDateView     // Catch:{ Exception -> 0x0dbb }
            java.lang.String r12 = r1.f5001o     // Catch:{ Exception -> 0x0dbb }
            java.util.Date r12 = r10.parse(r12)     // Catch:{ Exception -> 0x0dbb }
            java.lang.String r12 = r9.format(r12)     // Catch:{ Exception -> 0x0dbb }
            r0.setText(r12)     // Catch:{ Exception -> 0x0dbb }
            goto L_0x0dbf
        L_0x0dbb:
            r0 = move-exception
            r0.getMessage()
        L_0x0dbf:
            android.widget.TextView r0 = r1.fromStation
            cris.org.in.ima.db.StationDb r12 = r1.f4912a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r13 = r1.f4931a
            java.lang.String r13 = r13.getFromStnCode()
            java.lang.String r12 = r12.m(r13)
            java.lang.String r12 = defpackage.C0535I5.s0(r12)
            r0.setText(r12)
            android.widget.TextView r0 = r1.toStation
            cris.org.in.ima.db.StationDb r12 = r1.f4912a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r13 = r1.f4931a
            java.lang.String r13 = r13.getToStnCode()
            java.lang.String r12 = r12.m(r13)
            java.lang.String r12 = defpackage.C0535I5.s0(r12)
            r0.setText(r12)
            android.widget.TextView r0 = r1.boardingStnName
            cris.org.in.ima.db.StationDb r12 = r1.f4912a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r13 = r1.f4931a
            java.lang.String r13 = r13.getFromStnCode()
            java.lang.String r12 = r12.m(r13)
            r0.setText(r12)
            android.widget.TextView r0 = r1.psgndetail
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            cris.prs.webservices.dto.AvlFareResponseDTO r13 = r1.f4929a
            java.lang.String r13 = r13.getEnqClass()
            java.lang.String r13 = defpackage.xx.e(r13)
            r12.append(r13)
            r12.append(r7)
            cris.prs.webservices.dto.AvlFareResponseDTO r13 = r1.f4929a
            java.lang.String r13 = r13.getEnqClass()
            r12.append(r13)
            java.lang.String r13 = ") | "
            r12.append(r13)
            cris.org.in.ima.model.TrainBtwnStnsModel r13 = r1.f4928a
            java.lang.String r13 = r13.c()
            H9 r13 = defpackage.H9.f(r13)
            java.lang.String r13 = r13.a()
            r12.append(r13)
            r12.append(r7)
            cris.org.in.ima.model.TrainBtwnStnsModel r13 = r1.f4928a
            java.lang.String r13 = r13.c()
            r12.append(r13)
            r12.append(r8)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            int r0 = defpackage.C0535I5.E()
            java.lang.String r12 = "-"
            if (r0 == 0) goto L_0x0e69
            android.widget.TextView r0 = r1.isdCode
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r15 = "+"
            r13.<init>(r15)
            int r15 = defpackage.C0535I5.E()
            r13.append(r15)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            r0.setText(r13)
            goto L_0x0e6f
        L_0x0e69:
            android.widget.TextView r0 = r1.isdCode
            r13 = 4
            r0.setVisibility(r13)
        L_0x0e6f:
            android.widget.EditText r0 = r1.mobileNumber
            android.content.Context r13 = r21.getContext()
            Bw r13 = defpackage.Bw.e(r13)
            java.lang.String r13 = r13.k()
            r0.setText(r13)
            android.widget.EditText r0 = r1.mobileNumber
            android.content.Context r13 = r21.getContext()
            Bw r13 = defpackage.Bw.e(r13)
            java.lang.String r13 = r13.k()
            java.lang.String r15 = ""
            java.lang.String r13 = r13.replace(r15, r2)
            java.lang.String r13 = r13.trim()
            r0.setContentDescription(r13)
            java.lang.String r0 = T
            if (r0 == 0) goto L_0x0ead
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0ead
            android.widget.TextView r0 = r1.tv_available_lastupdate
            java.lang.String r13 = T
            r0.setText(r13)
            goto L_0x0eb2
        L_0x0ead:
            android.widget.TextView r0 = r1.tv_available_lastupdate
            r0.setText(r15)
        L_0x0eb2:
            d2 r0 = r1.f4932a
            java.lang.String r0 = r0.getAvailablityStatus()
            java.lang.String r13 = "WL"
            boolean r0 = r0.contains(r13)
            r22 = r14
            java.lang.String r14 = "RAC"
            if (r0 == 0) goto L_0x0ee0
            android.widget.TextView r0 = r1.avlClass
            r23 = r2
            android.content.Context r2 = r21.getContext()
            r17 = r12
            r12 = 2131100596(0x7f0603b4, float:1.7813578E38)
            int r2 = defpackage.d7.b(r2, r12)
            r0.setTextColor(r2)
            android.widget.CheckBox r0 = r1.isIgnoreChoiceIfWl
            r2 = 8
            r0.setVisibility(r2)
            goto L_0x0f00
        L_0x0ee0:
            r23 = r2
            r17 = r12
            d2 r0 = r1.f4932a
            java.lang.String r0 = r0.getAvailablityStatus()
            boolean r0 = r0.contains(r14)
            if (r0 == 0) goto L_0x0f00
            android.widget.TextView r0 = r1.avlClass
            android.content.Context r2 = r21.getContext()
            r12 = 2131099850(0x7f0600ca, float:1.7812065E38)
            int r2 = defpackage.d7.b(r2, r12)
            r0.setTextColor(r2)
        L_0x0f00:
            android.widget.TextView r0 = r1.avlClass
            d2 r2 = r1.f4932a
            java.lang.String r2 = r2.getAvailablityStatus()
            r0.setText(r2)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMdd"
            r0.<init>(r2)
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat
            r18 = r15
            java.lang.String r15 = "dd-MM-yyyy"
            r12.<init>(r15)
            java.lang.String r15 = r1.f4992l     // Catch:{ ParseException -> 0x0f26 }
            java.util.Date r12 = r12.parse(r15)     // Catch:{ ParseException -> 0x0f26 }
            java.lang.String r0 = r0.format(r12)     // Catch:{ ParseException -> 0x0f26 }
            goto L_0x0f2c
        L_0x0f26:
            r0 = move-exception
            r0.getMessage()
            r0 = r18
        L_0x0f2c:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r12 = r1.f4931a
            java.lang.String r12 = r12.getTrainNumber()
            Rh r15 = r1.f4900a
            r15.setTrainNo(r12)
            r15.setJourneyDate(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4928a
            java.lang.String r0 = r0.b()
            r15.setJourneyClass(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4928a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r0.d()
            java.lang.String r0 = r0.getFromStnCode()
            r15.setFromStation(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4928a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r0.d()
            java.lang.String r0 = r0.getToStnCode()
            r15.setToStation(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4928a
            java.lang.String r0 = r0.c()
            java.lang.String r12 = "SS"
            boolean r0 = r0.equalsIgnoreCase(r12)
            if (r0 == 0) goto L_0x0f71
            java.lang.String r0 = "GN"
            r15.setQuota(r0)
            goto L_0x0f7a
        L_0x0f71:
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4928a
            java.lang.String r0 = r0.c()
            r15.setQuota(r0)
        L_0x0f7a:
            boolean r0 = defpackage.C0535I5.f3647h
            Rh r12 = r1.f4945b
            if (r0 == 0) goto L_0x123e
            android.widget.EditText r0 = r1.preferredCoach
            r19 = r15
            r15 = 2131951787(0x7f1300ab, float:1.9539998E38)
            java.lang.String r15 = r1.getString(r15)
            r0.setHint(r15)
            android.widget.TextView r0 = r1.booking_choise_txt
            r15 = 0
            r0.setVisibility(r15)
            android.widget.TextView r0 = r1.tv_train_name_lap2
            cris.org.in.ima.model.TrainBtwnStnsModel r15 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r15 = r15.d()
            java.lang.String r15 = r15.getTrainName()
            r0.setText(r15)
            android.widget.TextView r0 = r1.tv_train_number_lap2
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r7)
            r20 = r5
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r5.d()
            java.lang.String r5 = r5.getTrainNumber()
            r15.append(r5)
            r15.append(r8)
            java.lang.String r5 = r15.toString()
            r0.setText(r5)
            android.widget.TextView r0 = r1.tv_departure_time_lap2
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r5.d()
            java.lang.String r5 = r5.getDepartureTime()
            r0.setText(r5)
            android.widget.TextView r0 = r1.tv_arrival_time_lap2
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r5.d()
            java.lang.String r5 = r5.getArrivalTime()
            r0.setText(r5)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r0.d()
            java.lang.String r0 = r0.getDuration()
            java.lang.String r5 = ":"
            java.lang.String[] r0 = r0.split(r5)
            int r5 = r6.length
            r15 = 2
            if (r5 != r15) goto L_0x100d
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 0
            r6 = r0[r6]
            r5.append(r6)
            r5.append(r11)
            r6 = 1
            r0 = r0[r6]
            java.lang.String r6 = "m."
            java.lang.String r0 = defpackage.C0709Uj.j(r5, r0, r6)
            goto L_0x1040
        L_0x100d:
            int r5 = r6.length
            r6 = 3
            if (r5 != r6) goto L_0x1034
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 0
            r6 = r0[r6]
            r5.append(r6)
            r5.append(r11)
            r6 = 1
            r6 = r0[r6]
            r5.append(r6)
            java.lang.String r6 = "m:"
            r5.append(r6)
            r6 = 2
            r0 = r0[r6]
            java.lang.String r6 = "s"
            java.lang.String r0 = defpackage.C0709Uj.j(r5, r0, r6)
            goto L_0x1040
        L_0x1034:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 0
            r0 = r0[r6]
            java.lang.String r0 = defpackage.C0709Uj.j(r5, r0, r11)
        L_0x1040:
            android.widget.TextView r5 = r1.tv_travel_time_lap2
            r5.setText(r0)
            android.widget.TextView r0 = r1.tv_from_stationname_lap2
            cris.org.in.ima.db.StationDb r5 = r1.f4912a
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = r6.d()
            java.lang.String r6 = r6.getFromStnCode()
            java.lang.String r5 = r5.m(r6)
            java.lang.String r5 = defpackage.C0535I5.s0(r5)
            r0.setText(r5)
            android.widget.TextView r0 = r1.tv_to_stationname_lap2
            cris.org.in.ima.db.StationDb r5 = r1.f4912a
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = r6.d()
            java.lang.String r6 = r6.getToStnCode()
            java.lang.String r5 = r5.m(r6)
            java.lang.String r5 = defpackage.C0535I5.s0(r5)
            r0.setText(r5)
            android.widget.TextView r0 = r1.tv_from_stationcode_lap2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = r6.d()
            java.lang.String r6 = r6.getFromStnCode()
            r5.append(r6)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            r0.setText(r5)
            android.widget.TextView r0 = r1.tv_to_stationcode_lap2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r7)
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = r6.d()
            java.lang.String r6 = r6.getToStnCode()
            r5.append(r6)
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            r0.setText(r5)
            java.lang.String r0 = r1.f4995m
            java.lang.String r0 = r1.n0(r0, r4)
            r1.f4998n = r0
            android.widget.TextView r4 = r1.tv_dep_date_lap2
            r4.setText(r0)
            java.lang.String r0 = r1.f4995m
            cris.org.in.ima.model.TrainBtwnStnsModel r4 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r4.d()
            java.lang.String r4 = r4.getDepartureTime()
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r5.d()
            java.lang.String r5 = r5.getDuration()
            java.lang.String r0 = p0(r0, r4, r5)
            android.widget.TextView r4 = r1.tv_arv_date_lap2     // Catch:{ Exception -> 0x10e8 }
            java.util.Date r0 = r10.parse(r0)     // Catch:{ Exception -> 0x10e8 }
            java.lang.String r0 = r9.format(r0)     // Catch:{ Exception -> 0x10e8 }
            r4.setText(r0)     // Catch:{ Exception -> 0x10e8 }
            goto L_0x10ec
        L_0x10e8:
            r0 = move-exception
            r0.getMessage()
        L_0x10ec:
            d2 r0 = r1.f4950b
            java.lang.String r0 = r0.getAvailablityStatus()
            boolean r0 = r0.contains(r13)
            if (r0 == 0) goto L_0x111b
            android.widget.TextView r0 = r1.tv_avl_class_lap
            android.content.Context r4 = r21.getContext()
            r5 = 2131100596(0x7f0603b4, float:1.7813578E38)
            int r4 = defpackage.d7.b(r4, r5)
            r0.setTextColor(r4)
            android.widget.TextView r0 = r1.tv_avl_class_lap
            d2 r4 = r1.f4950b
            java.lang.String r4 = r4.getAvailablityStatus()
            r0.setText(r4)
            android.widget.CheckBox r0 = r1.isIgnoreChoiceIfWl
            r4 = 8
            r0.setVisibility(r4)
            goto L_0x1142
        L_0x111b:
            d2 r0 = r1.f4950b
            java.lang.String r0 = r0.getAvailablityStatus()
            boolean r0 = r0.contains(r14)
            if (r0 == 0) goto L_0x1142
            android.widget.TextView r0 = r1.tv_avl_class_lap
            android.content.Context r4 = r21.getContext()
            r5 = 2131099850(0x7f0600ca, float:1.7812065E38)
            int r4 = defpackage.d7.b(r4, r5)
            r0.setTextColor(r4)
            android.widget.TextView r0 = r1.tv_avl_class_lap
            d2 r4 = r1.f4950b
            java.lang.String r4 = r4.getAvailablityStatus()
            r0.setText(r4)
        L_0x1142:
            android.widget.TextView r0 = r1.psgnCount_Class_Quota_lap2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            cris.prs.webservices.dto.AvlFareResponseDTO r5 = r1.f4958c
            java.lang.String r5 = r5.getEnqClass()
            java.lang.String r5 = defpackage.xx.e(r5)
            r4.append(r5)
            r4.append(r7)
            cris.prs.webservices.dto.AvlFareResponseDTO r5 = r1.f4958c
            java.lang.String r5 = r5.getEnqClass()
            r4.append(r5)
            java.lang.String r5 = ") | "
            r4.append(r5)
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            java.lang.String r5 = r5.c()
            H9 r5 = defpackage.H9.f(r5)
            java.lang.String r5 = r5.a()
            r4.append(r5)
            r4.append(r7)
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = r1.f4947b
            java.lang.String r5 = r5.c()
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            r0.setText(r4)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r4 = java.util.Locale.ENGLISH
            r0.<init>(r2, r4)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r2)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "dd-MM-yyyy"
            r2.<init>(r4)
            java.lang.String r4 = r1.f4995m     // Catch:{ ParseException -> 0x11ac }
            java.util.Date r2 = r2.parse(r4)     // Catch:{ ParseException -> 0x11ac }
            java.lang.String r0 = r0.format(r2)     // Catch:{ ParseException -> 0x11ac }
            goto L_0x11b2
        L_0x11ac:
            r0 = move-exception
            r0.getMessage()
            r0 = r18
        L_0x11b2:
            cris.org.in.ima.model.TrainBtwnStnsModel r2 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r2.d()
            java.lang.String r2 = r2.getTrainNumber()
            r12.setTrainNo(r2)
            r12.setJourneyDate(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4947b
            java.lang.String r0 = r0.b()
            r12.setJourneyClass(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r0.d()
            java.lang.String r0 = r0.getFromStnCode()
            r12.setFromStation(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r0.d()
            java.lang.String r0 = r0.getToStnCode()
            r12.setToStation(r0)
            android.widget.TextView r0 = r1.travel_waitingtime
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4 = 2131952164(0x7f130224, float:1.9540763E38)
            java.lang.String r4 = r1.getString(r4)
            r2.append(r4)
            cris.org.in.ima.model.TrainBtwnStnsModel r4 = r1.f4928a
            java.lang.Integer r4 = r4.e()
            int r4 = r4.intValue()
            java.lang.String r4 = defpackage.C0535I5.z(r4)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.setText(r2)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4947b
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r0.d()
            java.lang.String r0 = r0.getToStnCode()
            r3.setReservationUptoStation(r0)
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4947b
            java.lang.String r0 = r0.c()
            java.lang.String r2 = "SS"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x122f
            java.lang.String r0 = "GN"
            r12.setQuota(r0)
            goto L_0x1238
        L_0x122f:
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f4947b
            java.lang.String r0 = r0.c()
            r12.setQuota(r0)
        L_0x1238:
            r2 = r20
            r3.setWarrentType(r2)
            goto L_0x1240
        L_0x123e:
            r19 = r15
        L_0x1240:
            java.lang.Boolean r0 = r1.f4936a
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x1310
            boolean r0 = r1.f4982h
            if (r0 == 0) goto L_0x1310
            android.widget.TextView r0 = r1.tvBoardingStation
            Z2$a r2 = r1.f4901a
            java.lang.String r2 = r2.getStnNameCode()
            java.lang.String r2 = defpackage.C0535I5.s0(r2)
            r0.setText(r2)
            android.widget.TextView r0 = r1.boardingStnName
            Z2$a r2 = r1.f4901a
            java.lang.String r2 = r2.getStnNameCode()
            r0.setText(r2)
            android.widget.TextView r0 = r1.tvBoardingStation
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r2 = r18
            boolean r4 = r0.equals(r2)
            if (r4 != 0) goto L_0x1291
            boolean r4 = r0.contains(r7)
            if (r4 != 0) goto L_0x1291
            r4 = 45
            int r4 = r0.indexOf(r4)
            int r4 = r4 + 2
            java.lang.String r0 = r0.substring(r4)
            java.lang.String r0 = r0.toUpperCase()
            r1.f4983i = r0
            goto L_0x12ad
        L_0x1291:
            java.lang.String r0 = r1.f4983i
            r4 = 40
            int r4 = r0.indexOf(r4)
            int r4 = r4 + 1
            java.lang.String r5 = r1.f4983i
            r6 = 41
            int r5 = r5.indexOf(r6)
            java.lang.String r0 = r0.substring(r4, r5)
            java.lang.String r0 = r0.toUpperCase()
            r1.f4983i = r0
        L_0x12ad:
            java.lang.String r0 = r1.f4983i
            r3.setBoardingStation(r0)
            cris.org.in.ima.adaptors.BoardingStationChangeAdapter r0 = r1.f4909a
            r0.notifyDataSetChanged()
            androidx.recyclerview.widget.RecyclerView r0 = r1.boardingStnView
            r4 = 8
            r0.setVisibility(r4)
            android.widget.RelativeLayout r0 = r1.selectstation_ll
            r0.setVisibility(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            Z2$a r4 = r1.f4901a
            java.lang.String r4 = r4.getStnNameCode()
            r5 = r17
            java.lang.String[] r4 = r4.split(r5)
            r6 = 0
            r4 = r4[r6]
            r0.append(r4)
            java.lang.String r4 = "-("
            r0.append(r4)
            Z2$a r4 = r1.f4901a
            java.lang.String r4 = r4.getStnNameCode()
            java.lang.String[] r4 = r4.split(r5)
            r6 = 1
            r4 = r4[r6]
            r0.append(r4)
            java.lang.String r4 = ")-"
            r0.append(r4)
            Z2$a r4 = r1.f4901a
            java.util.Date r4 = r4.getBoardingDate()
            r0.append(r4)
            r0.append(r5)
            Z2$a r4 = r1.f4901a
            java.lang.String r4 = r4.getDepartureTime()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r1.K = r0
            goto L_0x1314
        L_0x1310:
            r5 = r17
            r2 = r18
        L_0x1314:
            java.lang.String r0 = r1.f5004p
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x1324
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.lang.String r0 = r0.getFromStnCode()
            r1.f5004p = r0
        L_0x1324:
            java.util.List<b3> r0 = f4889c
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            b3 r0 = (defpackage.C0794b3) r0
            L0(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x1340
            java.util.List<b3> r0 = f4889c
            r4 = 1
            java.lang.Object r0 = r0.get(r4)
            b3 r0 = (defpackage.C0794b3) r0
            M0(r0)
        L_0x1340:
            java.util.List<b3> r0 = f4889c
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            b3 r0 = (defpackage.C0794b3) r0
            short r0 = r0.getMaxPassengers()
            O0(r0)
            java.util.List<b3> r0 = f4889c
            java.lang.Object r0 = r0.get(r4)
            b3 r0 = (defpackage.C0794b3) r0
            short r0 = r0.getMinPassengerAge()
            R0(r0)
            java.lang.String r0 = r1.L
            if (r0 == 0) goto L_0x1372
            java.lang.String r4 = r1.f4986j
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x1372
            android.widget.LinearLayout r0 = r1.auto_upgra_layout
            r4 = 8
            r0.setVisibility(r4)
        L_0x1372:
            java.lang.Boolean r0 = r3.getAutoUpgradationSelected()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x1383
            android.widget.CheckBox r0 = r1.isAutoUpgradation
            r3 = 1
            r0.setChecked(r3)
            goto L_0x1384
        L_0x1383:
            r3 = 1
        L_0x1384:
            java.lang.Boolean r0 = r19.getIgnoreChoiceIfWl()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x1395
            android.widget.CheckBox r0 = r1.isIgnoreChoiceIfWl
            r4 = 0
            r0.setChecked(r4)
            goto L_0x139b
        L_0x1395:
            r4 = 0
            android.widget.CheckBox r0 = r1.isIgnoreChoiceIfWl
            r0.setChecked(r3)
        L_0x139b:
            java.lang.Boolean r0 = r12.getIgnoreChoiceIfWl()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x13ab
            android.widget.CheckBox r0 = r1.isIgnoreChoiceIfWl
            r0.setChecked(r4)
            goto L_0x13b0
        L_0x13ab:
            android.widget.CheckBox r0 = r1.isIgnoreChoiceIfWl
            r0.setChecked(r3)
        L_0x13b0:
            java.lang.Short r0 = r1.f4939a
            if (r0 == 0) goto L_0x13fd
            short r0 = r0.shortValue()
            r3 = 5
            if (r0 != r3) goto L_0x13cb
            android.widget.TextView r0 = r1.reservationChoiceClick
            android.widget.TextView r3 = r1.allBerthConfirm
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
            goto L_0x140c
        L_0x13cb:
            java.lang.Short r0 = r1.f4939a
            short r0 = r0.shortValue()
            r3 = 6
            if (r0 != r3) goto L_0x13e4
            android.widget.TextView r0 = r1.reservationChoiceClick
            android.widget.TextView r3 = r1.oneLowerBerth
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
            goto L_0x140c
        L_0x13e4:
            java.lang.Short r0 = r1.f4939a
            short r0 = r0.shortValue()
            r3 = 7
            if (r0 != r3) goto L_0x140c
            android.widget.TextView r0 = r1.reservationChoiceClick
            android.widget.TextView r3 = r1.twoLowerBerth
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
            goto L_0x140c
        L_0x13fd:
            android.widget.TextView r0 = r1.reservationChoiceClick
            android.widget.TextView r3 = r1.tvnone
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
        L_0x140c:
            d2 r0 = r1.f4932a
            short r0 = r0.getAvailablityType()
            r3 = 1
            if (r0 != r3) goto L_0x1444
            android.widget.LinearLayout r0 = r1.bookOnlyCnfLayout
            r3 = 0
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r1.reservationChoiceLayout
            r0.setVisibility(r3)
            android.widget.EditText r0 = r1.preferredCoach
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.reservationChoiceClick
            r0.setVisibility(r3)
            java.lang.String r0 = r19.getCoachId()
            if (r0 == 0) goto L_0x145a
            java.lang.String r0 = r19.getCoachId()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x145a
            android.widget.EditText r0 = r1.preferredCoach
            java.lang.String r3 = r19.getCoachId()
            r0.setText(r3)
            goto L_0x145a
        L_0x1444:
            android.widget.LinearLayout r0 = r1.bookOnlyCnfLayout
            r3 = 8
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r1.reservationChoiceLayout
            r0.setVisibility(r3)
            android.widget.EditText r0 = r1.preferredCoach
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.reservationChoiceClick
            r0.setVisibility(r3)
        L_0x145a:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x14ba
            java.lang.Short r0 = r1.f4952b
            if (r0 == 0) goto L_0x14ab
            short r0 = r0.shortValue()
            r3 = 1
            if (r0 != r3) goto L_0x1479
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            android.widget.TextView r3 = r1.tv_all_berth_confirm_lap2
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
            goto L_0x14ba
        L_0x1479:
            java.lang.Short r0 = r1.f4952b
            short r0 = r0.shortValue()
            r3 = 2
            if (r0 != r3) goto L_0x1492
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            android.widget.TextView r3 = r1.tv_one_lower_berth_lap2
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
            goto L_0x14ba
        L_0x1492:
            java.lang.Short r0 = r1.f4952b
            short r0 = r0.shortValue()
            r3 = 3
            if (r0 != r3) goto L_0x14ba
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            android.widget.TextView r3 = r1.tv_two_lower_berth_lap2
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
            goto L_0x14ba
        L_0x14ab:
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            android.widget.TextView r3 = r1.tvnone
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
        L_0x14ba:
            boolean r0 = defpackage.C0535I5.L()
            if (r0 == 0) goto L_0x14fb
            d2 r0 = r1.f4950b
            short r0 = r0.getAvailablityType()
            r3 = 1
            if (r0 != r3) goto L_0x14ee
            android.widget.EditText r0 = r1.preferred_coach_lap2
            r3 = 0
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            r0.setVisibility(r3)
            java.lang.String r0 = r12.getCoachId()
            if (r0 == 0) goto L_0x14fb
            java.lang.String r0 = r12.getCoachId()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x14fb
            android.widget.EditText r0 = r1.preferred_coach_lap2
            java.lang.String r3 = r12.getCoachId()
            r0.setText(r3)
            goto L_0x14fb
        L_0x14ee:
            android.widget.EditText r0 = r1.preferred_coach_lap2
            r3 = 8
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            r0.setVisibility(r3)
            goto L_0x14fd
        L_0x14fb:
            r3 = 8
        L_0x14fd:
            b3 r0 = f4886a
            boolean r0 = r0.isLowerBerthApplicable()
            if (r0 != 0) goto L_0x1510
            android.widget.TextView r0 = r1.oneLowerBerth
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.twoLowerBerth
            r0.setVisibility(r3)
            goto L_0x151b
        L_0x1510:
            android.widget.TextView r0 = r1.oneLowerBerth
            r3 = 0
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.twoLowerBerth
            r0.setVisibility(r3)
        L_0x151b:
            b3 r0 = f4886a
            java.util.ArrayList r0 = r0.getApplicableBerthTypes()
            r1.f5009r = r0
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x152f
            b3 r0 = b
            java.util.ArrayList r0 = r0.getApplicableBerthTypes()
            r1.f5012s = r0
        L_0x152f:
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r1.f4929a
            java.util.ArrayList r0 = r0.getInformationMessage()
            r1.r = r2
            U = r2
            if (r0 == 0) goto L_0x15a7
            java.util.Iterator r0 = r0.iterator()
            r3 = r2
        L_0x1540:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x1590
            java.lang.Object r4 = r0.next()
            cris.prs.webservices.dto.InformationMessageDTO r4 = (cris.prs.webservices.dto.InformationMessageDTO) r4
            java.lang.String r6 = r4.getParamName()
            java.lang.String r7 = "ADD_PASSENGER_INIT"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x155c
            java.lang.String r3 = r4.getMessage()
        L_0x155c:
            java.lang.String r6 = r4.getParamName()
            java.lang.String r7 = "ADD_PASSENGER_BUTTON_PRESS"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x156e
            java.lang.String r6 = r4.getMessage()
            r1.r = r6
        L_0x156e:
            java.lang.String r6 = r4.getParamName()
            java.lang.String r7 = "PAYMENT_INIT"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x1580
            java.lang.String r6 = r4.getMessage()
            U = r6
        L_0x1580:
            java.lang.String r6 = r4.getParamName()
            java.lang.String r7 = "FORGO_CONC"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x1540
            r4.getMessage()
            goto L_0x1540
        L_0x1590:
            if (r3 == 0) goto L_0x15a7
            java.lang.String r0 = r3.trim()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x15a7
            androidx.fragment.app.FragmentActivity r0 = r21.getActivity()
            r4 = 2131951928(0x7f130138, float:1.9540284E38)
            r6 = 0
            defpackage.C0709Uj.q(r1, r4, r0, r3, r6)
        L_0x15a7:
            java.util.List<b3> r0 = f4889c
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            b3 r0 = (defpackage.C0794b3) r0
            boolean r0 = r0.isTravelInsuranceEnabled()
            java.lang.String r4 = "NA"
            java.lang.String r6 = "true"
            java.lang.String r7 = "#"
            if (r0 == 0) goto L_0x1690
            java.util.List<b3> r0 = f4889c
            java.lang.Object r0 = r0.get(r3)
            b3 r0 = (defpackage.C0794b3) r0
            java.lang.String r0 = r0.getTravelInsuranceFareMsg()
            java.lang.String r8 = "\n"
            r9 = r23
            java.lang.String r0 = r0.replaceAll(r8, r9)
            if (r0 == 0) goto L_0x168d
            boolean r8 = r0.contains(r7)
            if (r8 == 0) goto L_0x160e
            defpackage.C1480xl.f(r2)
            android.widget.LinearLayout r8 = r1.insuranceLayout
            r8.setVisibility(r3)
            android.widget.TextView r8 = r1.insuranceTexts
            r8.setText(r0)
            java.lang.String r0 = r0.replace(r7, r2)
            android.widget.TextView r8 = r1.insuranceTexts
            r8.setText(r0)
            android.widget.RadioButton r0 = r1.noInsuranceOpt
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.travel_insurance_no_ll
            r0.setEnabled(r3)
            android.widget.RadioButton r0 = r1.noInsuranceOpt
            r0.setEnabled(r3)
            android.widget.RadioButton r0 = r1.insuranceOpt
            r3 = 1
            r0.setChecked(r3)
            r1.f5011s = r6
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r3 = r19
            r3.setTravelInsuranceOpted(r0)
            goto L_0x168d
        L_0x160e:
            r3 = r19
            d2 r8 = r1.f4932a
            java.lang.String r8 = r8.getAvailablityStatus()
            boolean r8 = r8.contains(r14)
            if (r8 != 0) goto L_0x164b
            d2 r8 = r1.f4932a
            java.lang.String r8 = r8.getAvailablityStatus()
            java.lang.String r10 = "AVAILABLE"
            boolean r8 = r8.contains(r10)
            if (r8 != 0) goto L_0x164b
            d2 r8 = r1.f4932a
            java.lang.String r8 = r8.getAvailablityStatus()
            java.lang.String r10 = "CURR_AVBL"
            boolean r8 = r8.contains(r10)
            if (r8 == 0) goto L_0x1639
            goto L_0x164b
        L_0x1639:
            android.widget.LinearLayout r0 = r1.insuranceLayout
            r8 = 8
            r0.setVisibility(r8)
            android.widget.LinearLayout r0 = r1.termcondition_ll
            r0.setVisibility(r8)
            defpackage.C1480xl.f(r4)
            r1.f5011s = r6
            goto L_0x166a
        L_0x164b:
            defpackage.C1480xl.f(r2)
            android.widget.LinearLayout r8 = r1.insuranceLayout
            r10 = 0
            r8.setVisibility(r10)
            android.widget.TextView r8 = r1.insuranceTexts
            r8.setText(r0)
            boolean r0 = r1.f4976f
            if (r0 == 0) goto L_0x166a
            r1.f5011s = r6
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r3.setTravelInsuranceOpted(r0)
            android.widget.RadioButton r0 = r1.insuranceOpt
            r8 = 1
            r0.setChecked(r8)
        L_0x166a:
            java.lang.String r0 = S
            r8 = r16
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x16a3
            android.widget.LinearLayout r0 = r1.insuranceLayout
            r10 = 8
            r0.setVisibility(r10)
            android.widget.LinearLayout r0 = r1.termcondition_ll
            r0.setVisibility(r10)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r3.setTravelInsuranceOpted(r0)
            defpackage.C1480xl.f(r2)
            java.lang.String r0 = "false"
            r1.f5011s = r0
            goto L_0x16a3
        L_0x168d:
            r8 = r16
            goto L_0x16a3
        L_0x1690:
            r9 = r23
            r8 = r16
            r0 = 8
            android.widget.LinearLayout r3 = r1.insuranceLayout
            r3.setVisibility(r0)
            android.widget.LinearLayout r3 = r1.termcondition_ll
            r3.setVisibility(r0)
            defpackage.C1480xl.f(r4)
        L_0x16a3:
            android.widget.RadioGroup r0 = r1.radioInsurance
            cris.org.in.ima.fragment.PassengerDetailFragment$j r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$j
            r3.<init>()
            r0.setOnCheckedChangeListener(r3)
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            android.content.res.Resources r0 = r21.getResources()
            r10 = 2131953874(0x7f1308d2, float:1.9544231E38)
            java.lang.String r0 = r0.getString(r10)
            r3.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r10 = r21.getContext()
            r11 = 2131099733(0x7f060055, float:1.7811828E38)
            int r10 = defpackage.d7.b(r10, r11)
            r0.<init>(r10)
            android.text.style.StyleSpan r10 = new android.text.style.StyleSpan
            r11 = 1
            r10.<init>(r11)
            cris.org.in.ima.fragment.PassengerDetailFragment$k r11 = new cris.org.in.ima.fragment.PassengerDetailFragment$k
            r11.<init>()
            r15 = 18
            r23 = r13
            r13 = 0
            r3.setSpan(r10, r13, r15, r15)     // Catch:{ Exception -> 0x16e9 }
            r10 = 33
            r3.setSpan(r11, r13, r15, r10)     // Catch:{ Exception -> 0x16e9 }
            r3.setSpan(r0, r13, r15, r15)     // Catch:{ Exception -> 0x16e9 }
            goto L_0x16ed
        L_0x16e9:
            r0 = move-exception
            r0.getMessage()
        L_0x16ed:
            android.widget.TextView r0 = r1.termcondition
            r0.setText(r3)
            android.widget.TextView r0 = r1.termcondition
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r3)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x1822
            java.util.List<b3> r0 = f4889c
            r3 = 1
            java.lang.Object r0 = r0.get(r3)
            b3 r0 = (defpackage.C0794b3) r0
            boolean r0 = r0.isTravelInsuranceEnabled()
            if (r0 == 0) goto L_0x17bf
            java.util.List<b3> r0 = f4889c
            java.lang.Object r0 = r0.get(r3)
            b3 r0 = (defpackage.C0794b3) r0
            java.lang.String r0 = r0.getTravelInsuranceFareMsg()
            java.lang.String r3 = "\n"
            java.lang.String r0 = r0.replaceAll(r3, r9)
            if (r0 == 0) goto L_0x17ce
            boolean r3 = r0.contains(r7)
            if (r3 == 0) goto L_0x1755
            defpackage.C1480xl.f(r2)
            android.widget.LinearLayout r3 = r1.insuranceLayout_lap2
            r4 = 0
            r3.setVisibility(r4)
            android.widget.TextView r3 = r1.insurance_text_lap2
            r3.setText(r0)
            java.lang.String r0 = r0.replace(r7, r2)
            android.widget.TextView r3 = r1.insurance_text_lap2
            r3.setText(r0)
            android.widget.RadioButton r0 = r1.no_insurance_opt_lap2
            r3 = 8
            r0.setVisibility(r3)
            android.widget.RadioButton r0 = r1.insurance_opt_lap2
            r3 = 1
            r0.setChecked(r3)
            r1.f5011s = r6
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r12.setTravelInsuranceOpted(r0)
            goto L_0x17ce
        L_0x1755:
            d2 r3 = r1.f4950b
            java.lang.String r3 = r3.getAvailablityStatus()
            boolean r3 = r3.contains(r14)
            if (r3 != 0) goto L_0x1790
            d2 r3 = r1.f4950b
            java.lang.String r3 = r3.getAvailablityStatus()
            java.lang.String r10 = "AVAILABLE"
            boolean r3 = r3.contains(r10)
            if (r3 != 0) goto L_0x1790
            d2 r3 = r1.f4950b
            java.lang.String r3 = r3.getAvailablityStatus()
            java.lang.String r10 = "CURR_AVBL"
            boolean r3 = r3.contains(r10)
            if (r3 == 0) goto L_0x177e
            goto L_0x1790
        L_0x177e:
            android.widget.LinearLayout r0 = r1.insuranceLayout_lap2
            r3 = 8
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.termcondition_ll
            r0.setVisibility(r3)
            defpackage.C1480xl.f(r4)
            r1.f5013t = r6
            goto L_0x179e
        L_0x1790:
            defpackage.C1480xl.f(r2)
            android.widget.LinearLayout r3 = r1.insuranceLayout_lap2
            r4 = 0
            r3.setVisibility(r4)
            android.widget.TextView r3 = r1.insurance_text_lap2
            r3.setText(r0)
        L_0x179e:
            java.lang.String r0 = S
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x17ce
            android.widget.LinearLayout r0 = r1.insuranceLayout_lap2
            r3 = 8
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.termcondition_ll
            r0.setVisibility(r3)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r12.setTravelInsuranceOpted(r0)
            defpackage.C1480xl.f(r2)
            java.lang.String r0 = "false"
            r1.f5013t = r0
            goto L_0x17ce
        L_0x17bf:
            r0 = 8
            android.widget.LinearLayout r3 = r1.insuranceLayout_lap2
            r3.setVisibility(r0)
            android.widget.LinearLayout r3 = r1.termcondition_ll
            r3.setVisibility(r0)
            defpackage.C1480xl.f(r4)
        L_0x17ce:
            android.widget.RadioGroup r0 = r1.radio_insurance_lap2
            cris.org.in.ima.fragment.PassengerDetailFragment$E r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$E
            r3.<init>()
            r0.setOnCheckedChangeListener(r3)
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            android.content.res.Resources r0 = r21.getResources()
            r4 = 2131953874(0x7f1308d2, float:1.9544231E38)
            java.lang.String r0 = r0.getString(r4)
            r3.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r4 = r21.getContext()
            r6 = 2131099733(0x7f060055, float:1.7811828E38)
            int r4 = defpackage.d7.b(r4, r6)
            r0.<init>(r4)
            android.text.style.StyleSpan r4 = new android.text.style.StyleSpan
            r6 = 1
            r4.<init>(r6)
            cris.org.in.ima.fragment.PassengerDetailFragment$M r6 = new cris.org.in.ima.fragment.PassengerDetailFragment$M
            r6.<init>()
            r10 = 0
            r3.setSpan(r4, r10, r15, r15)     // Catch:{ Exception -> 0x1810 }
            r4 = 33
            r3.setSpan(r6, r10, r15, r4)     // Catch:{ Exception -> 0x1810 }
            r3.setSpan(r0, r10, r15, r15)     // Catch:{ Exception -> 0x1810 }
            goto L_0x1814
        L_0x1810:
            r0 = move-exception
            r0.getMessage()
        L_0x1814:
            android.widget.TextView r0 = r1.termcondition_lap2
            r0.setText(r3)
            android.widget.TextView r0 = r1.termcondition_lap2
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r3)
        L_0x1822:
            boolean r0 = defpackage.C1450w1.e()
            if (r0 != 0) goto L_0x1856
            b3 r0 = f4886a
            boolean r0 = r0.isSeniorCitizenApplicable()
            if (r0 != 0) goto L_0x1856
            android.content.Context r10 = r21.getContext()
            r11 = 0
            r0 = 2131951918(0x7f13012e, float:1.9540264E38)
            java.lang.String r12 = r1.getString(r0)
            r0 = 2131951855(0x7f1300ef, float:1.9540136E38)
            java.lang.String r13 = r1.getString(r0)
            r0 = 2131953334(0x7f1306b6, float:1.9543136E38)
            java.lang.String r14 = r1.getString(r0)
            r15 = 0
            r16 = 0
            r17 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.p(r10, r11, r12, r13, r14, r15, r16, r17)
            r0.show()
        L_0x1856:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x188e
            boolean r0 = defpackage.C1450w1.e()
            if (r0 != 0) goto L_0x188e
            b3 r0 = b
            boolean r0 = r0.isSeniorCitizenApplicable()
            if (r0 != 0) goto L_0x188e
            android.content.Context r10 = r21.getContext()
            r11 = 0
            r0 = 2131951918(0x7f13012e, float:1.9540264E38)
            java.lang.String r12 = r1.getString(r0)
            r0 = 2131951855(0x7f1300ef, float:1.9540136E38)
            java.lang.String r13 = r1.getString(r0)
            r0 = 2131953334(0x7f1306b6, float:1.9543136E38)
            java.lang.String r14 = r1.getString(r0)
            r15 = 0
            r16 = 0
            r17 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.p(r10, r11, r12, r13, r14, r15, r16, r17)
            r0.show()
        L_0x188e:
            r21.I0()
            int r0 = t0()
            if (r0 == 0) goto L_0x18d0
            r21.J0()
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x18ad
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r0 = r1.f4981h
            r0.clear()
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r0 = r1.f4981h
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r3 = r1.f4978g
            r0.addAll(r3)
            r21.K0()
        L_0x18ad:
            java.lang.Boolean r0 = r1.f4936a
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x18d0
            com.google.android.gms.ads.admanager.AdManagerAdView r0 = r1.passengerCenter
            r3 = 8
            r0.setVisibility(r3)
            androidx.recyclerview.widget.RecyclerView r0 = r1.passengerList
            r3 = 0
            r0.setVisibility(r3)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x18d0
            androidx.recyclerview.widget.RecyclerView r0 = r1.rv_passenger_list_lap2
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.select_passenger_lap2
            r0.setVisibility(r3)
        L_0x18d0:
            b3 r0 = f4886a
            java.lang.Integer r0 = r0.getCaptureAddress()
            int r0 = r0.intValue()
            r1.k = r0
            if (r0 != 0) goto L_0x18eb
            android.widget.LinearLayout r0 = r1.passengerAddressHeadingLl
            r3 = 8
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.passengerAddressInputLl
            r0.setVisibility(r3)
            goto L_0x192b
        L_0x18eb:
            android.widget.LinearLayout r0 = r1.passengerAddressHeadingLl
            r3 = 0
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.passengerAddressInputLl
            r0.setVisibility(r3)
            java.lang.Boolean r0 = r1.f4936a
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x192b
            java.lang.String r0 = r1.f4967d
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x190d
            android.widget.TextView r0 = r1.et_city_town
            java.lang.String r3 = r1.f4967d
            r0.setText(r3)
        L_0x190d:
            java.lang.String r0 = r1.f4971e
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x191c
            android.widget.TextView r0 = r1.et_state
            java.lang.String r3 = r1.f4971e
            r0.setText(r3)
        L_0x191c:
            java.lang.String r0 = r1.f4974f
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x192b
            android.widget.TextView r0 = r1.et_post_office
            java.lang.String r3 = r1.f4974f
            r0.setText(r3)
        L_0x192b:
            java.util.ArrayList r0 = r21.s0()
            r1.f5005p = r0
            r21.c0()
            r21.Z0()
            r21.v0()
            r21.y0()
            r21.m0()
            r21.b0()
            r21.H0()
            java.lang.Boolean r0 = r1.f4936a
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x1951
            r21.F0()
        L_0x1951:
            r0 = 1
            r1.f4997m = r0
            android.widget.EditText r0 = r1.splDOB
            cris.org.in.ima.fragment.PassengerDetailFragment$x r3 = r1.f4925a
            r0.addTextChangedListener(r3)
            android.widget.EditText r0 = r1.tv_dob_ft
            cris.org.in.ima.fragment.PassengerDetailFragment$w r3 = r1.f4924a
            r0.addTextChangedListener(r3)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            cris.org.in.ima.fragment.PassengerDetailFragment$y r3 = r1.f4926a
            r0.addTextChangedListener(r3)
            android.widget.EditText r0 = r1.splCardValidity
            cris.org.in.ima.fragment.PassengerDetailFragment$u r3 = r1.f4922a
            r0.addTextChangedListener(r3)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            cris.org.in.ima.fragment.PassengerDetailFragment$v r3 = r1.f4923a
            r0.addTextChangedListener(r3)
            android.widget.EditText r0 = r1.passengerName
            r3 = 524432(0x80090, float:7.34886E-40)
            r0.setInputType(r3)
            android.widget.EditText r0 = r1.passengerName
            r3 = 0
            r0.setLongClickable(r3)
            android.widget.EditText r0 = r1.passengerName
            cris.org.in.ima.fragment.PassengerDetailFragment$X r4 = new cris.org.in.ima.fragment.PassengerDetailFragment$X
            r4.<init>()
            r0.setOnFocusChangeListener(r4)
            android.widget.EditText r0 = r1.passengerAge
            r0.setLongClickable(r3)
            android.widget.EditText r0 = r1.passengerAge
            cris.org.in.ima.fragment.PassengerDetailFragment$i0 r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$i0
            r3.<init>()
            r0.setOnFocusChangeListener(r3)
            android.widget.EditText r0 = r1.passengerAge
            cris.org.in.ima.fragment.PassengerDetailFragment$o0 r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$o0
            r3.<init>()
            r0.addTextChangedListener(r3)
            android.widget.CheckBox r0 = r1.isChildBerthReq
            cris.org.in.ima.fragment.PassengerDetailFragment$p0 r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$p0
            r3.<init>()
            r0.setOnClickListener(r3)
            android.widget.CheckBox r0 = r1.is_childBerth_req_lap2
            cris.org.in.ima.fragment.PassengerDetailFragment$q0 r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$q0
            r3.<init>()
            r0.setOnClickListener(r3)
            android.widget.EditText r0 = r1.splDOB
            cris.org.in.ima.fragment.PassengerDetailFragment$a r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$a
            r3.<init>()
            r0.setOnClickListener(r3)
            android.widget.EditText r0 = r1.tv_dob_ft
            cris.org.in.ima.fragment.PassengerDetailFragment$b r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$b
            r3.<init>()
            r0.setOnClickListener(r3)
            android.widget.EditText r0 = r1.tv_conc_dob_lap2
            cris.org.in.ima.fragment.PassengerDetailFragment$c r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$c
            r3.<init>()
            r0.setOnClickListener(r3)
            android.widget.EditText r0 = r1.splCardValidity
            cris.org.in.ima.fragment.PassengerDetailFragment$d r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$d
            r3.<init>()
            r0.setOnClickListener(r3)
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2
            cris.org.in.ima.fragment.PassengerDetailFragment$e r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$e
            r3.<init>()
            r0.setOnClickListener(r3)
            b3 r0 = f4886a
            boolean r0 = r0.isFoodChoiceEnabled()
            if (r0 == 0) goto L_0x19ff
            android.widget.LinearLayout r0 = r1.mealPreferenceLayout
            r3 = 0
            r0.setVisibility(r3)
            r0 = 8
            goto L_0x1a08
        L_0x19ff:
            r3 = 0
            android.widget.LinearLayout r0 = r1.mealPreferenceLayout
            r4 = 8
            r0.setVisibility(r4)
            r0 = r4
        L_0x1a08:
            boolean r4 = defpackage.C0535I5.f3647h
            if (r4 == 0) goto L_0x1a1f
            b3 r4 = b
            boolean r4 = r4.isFoodChoiceEnabled()
            if (r4 == 0) goto L_0x1a1a
            android.widget.LinearLayout r0 = r1.ll_meal_preference_lap2
            r0.setVisibility(r3)
            goto L_0x1a1f
        L_0x1a1a:
            android.widget.LinearLayout r3 = r1.ll_meal_preference_lap2
            r3.setVisibility(r0)
        L_0x1a1f:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            defpackage.C0535I5.o0(r0)
            android.widget.EditText r0 = r1.childPassengerName
            cris.org.in.ima.fragment.PassengerDetailFragment$f r3 = new cris.org.in.ima.fragment.PassengerDetailFragment$f
            r3.<init>()
            r0.setOnFocusChangeListener(r3)
            java.lang.Boolean r0 = r1.f4936a
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x1a79
            boolean r0 = r1.f5006p
            if (r0 != 0) goto L_0x1a6c
            boolean r0 = r1.f5003o
            if (r0 == 0) goto L_0x1a42
            goto L_0x1a6c
        L_0x1a42:
            int r0 = defpackage.C1450w1.d()
            r3 = -1
            if (r0 == r3) goto L_0x1a67
            int r0 = defpackage.C1450w1.d()
            if (r0 <= 0) goto L_0x1a73
            int r0 = defpackage.C1450w1.d()
            b3 r3 = f4886a
            java.lang.Integer r3 = r3.getMaxMasterListPsgn()
            int r3 = r3.intValue()
            if (r0 > r3) goto L_0x1a73
            java.lang.String r0 = "SELECT_MASTER_LIST"
            java.lang.String r0 = defpackage.C0535I5.Q(r0)
            if (r0 != 0) goto L_0x1a73
        L_0x1a67:
            r0 = 1
            r1.l0(r0)
            goto L_0x1a73
        L_0x1a6c:
            android.widget.RelativeLayout r0 = r1.existingpassenger_ll
            r3 = 8
            r0.setVisibility(r3)
        L_0x1a73:
            android.widget.TextView r0 = a
            r3 = 0
            r0.setClickable(r3)
        L_0x1a79:
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r3 = r21.getContext()
            r4 = 2131099739(0x7f06005b, float:1.781184E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.<init>(r3)
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            android.content.Context r6 = r21.getContext()
            int r6 = defpackage.d7.b(r6, r4)
            r3.<init>(r6)
            android.text.style.ForegroundColorSpan r6 = new android.text.style.ForegroundColorSpan
            android.content.Context r10 = r21.getContext()
            int r4 = defpackage.d7.b(r10, r4)
            r6.<init>(r4)
            android.text.SpannableStringBuilder r4 = new android.text.SpannableStringBuilder
            r4.<init>()
            r10 = 2131954017(0x7f130961, float:1.9544521E38)
            java.lang.String r10 = r1.getString(r10)
            android.text.SpannableString r11 = new android.text.SpannableString
            r11.<init>(r10)
            r4.append(r11)
            android.content.Context r10 = r21.getContext()
            Bw r10 = defpackage.Bw.e(r10)
            java.lang.String r10 = r10.j()
            java.lang.String r10 = defpackage.C0535I5.d0(r10)
            android.text.SpannableString r11 = new android.text.SpannableString
            r11.<init>(r10)
            int r10 = r11.length()
            r12 = 0
            r11.setSpan(r0, r12, r10, r12)
            r4.append(r11)
            android.text.SpannableString r0 = new android.text.SpannableString
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r9)
            r11 = 2131952285(0x7f13029d, float:1.9541008E38)
            java.lang.String r11 = r1.getString(r11)
            r10.append(r11)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            r0.<init>(r10)
            r4.append(r0)
            int r0 = defpackage.C0535I5.E()
            if (r0 == 0) goto L_0x1b11
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "+"
            r0.<init>(r2)
            int r2 = defpackage.C0535I5.E()
            r0.append(r2)
            r0.append(r5)
            java.lang.String r15 = r0.toString()
            goto L_0x1b12
        L_0x1b11:
            r15 = r2
        L_0x1b12:
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r15)
            int r2 = r0.length()
            r5 = 0
            r0.setSpan(r3, r5, r2, r5)
            r4.append(r0)
            android.content.Context r0 = r21.getContext()
            Bw r0 = defpackage.Bw.e(r0)
            java.lang.String r0 = r0.k()
            java.lang.String r0 = defpackage.C0535I5.e0(r0)
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r0)
            int r0 = r2.length()
            r2.setSpan(r6, r5, r0, r5)
            r4.append(r2)
            java.lang.String r0 = cris.org.in.ima.IrctcImaApplication.a()
            java.lang.String r2 = "hi"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x1b68
            android.text.SpannableString r0 = new android.text.SpannableString
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r3 = 2131953717(0x7f130835, float:1.9543913E38)
            java.lang.String r3 = r1.getString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            r4.append(r0)
        L_0x1b68:
            android.widget.TextView r0 = r1.ticketSentLevelView
            android.widget.TextView$BufferType r2 = android.widget.TextView.BufferType.SPANNABLE
            r0.setText(r4, r2)
            defpackage.C0535I5.n0()
            defpackage.C0535I5.p0()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            if (r0 == 0) goto L_0x1cfd
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "O"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x1ba0
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r2 = r1.f4904a
            r3 = 2131100644(0x7f0603e4, float:1.7813675E38)
            int r2 = defpackage.d7.b(r2, r3)
            r0.setColorFilter(r2)
        L_0x1ba0:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "R"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1bc8
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131100337(0x7f0602b1, float:1.7813053E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1bc8:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "G"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1bef
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131100595(0x7f0603b3, float:1.7813576E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1bef:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "SP"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1c16
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131100338(0x7f0602b2, float:1.7813055E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1c16:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "ST"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1c3d
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131099891(0x7f0600f3, float:1.7812148E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1c3d:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "D"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1c64
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131100662(0x7f0603f6, float:1.7813712E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1c64:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "SV"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1c8b
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131099851(0x7f0600cb, float:1.7812067E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1c8b:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x1cb0
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131099651(0x7f060003, float:1.7811661E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1cb0:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r3 = "JS"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1cd6
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r3 = r1.f4904a
            r4 = 2131099648(0x7f060000, float:1.7811655E38)
            int r3 = defpackage.d7.b(r3, r4)
            r0.setColorFilter(r3)
        L_0x1cd6:
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f4931a
            java.util.List r0 = r0.getTrainType()
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            r3 = r22
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x1cfd
            android.widget.ImageView r0 = r1.train_type
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r1.train_type
            android.content.Context r2 = r1.f4904a
            r3 = 2131099653(0x7f060005, float:1.7811665E38)
            int r2 = defpackage.d7.b(r2, r3)
            r0.setColorFilter(r2)
        L_0x1cfd:
            boolean r0 = defpackage.C0535I5.L()
            if (r0 == 0) goto L_0x1d6c
            android.widget.LinearLayout r0 = r1.lap2_heading_ll
            r2 = 0
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.tv_lap1heading
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.bookOnlyCnfLayout
            r3 = 8
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.heading_travelInsurance
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.headind_travelinsurance_lap1
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r1.select_booking_ll
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r1.booking_choice
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.tv_lap
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.train_detail_lap2
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.select_passenger_lap2
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.traindetail_ll
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.add_meal_ll
            r0.setVisibility(r3)
            Z2 r0 = r1.f4902a
            boolean r0 = r0.isMealChoiceenable()
            if (r0 == 0) goto L_0x1d50
            android.widget.LinearLayout r0 = r1.add_meal_ll_lap
            r0.setVisibility(r2)
            goto L_0x1d55
        L_0x1d50:
            android.widget.LinearLayout r0 = r1.add_meal_ll_lap
            r0.setVisibility(r3)
        L_0x1d55:
            android.widget.RelativeLayout r0 = r1.reservation_choice_rl_lap2
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.ll_wait_duration_lap1
            r0.setVisibility(r2)
            android.widget.EditText r0 = r1.preferred_coach_lap2
            r0.setVisibility(r2)
            r0 = 8
            goto L_0x1dd0
        L_0x1d6c:
            r0 = 0
            android.widget.LinearLayout r2 = r1.lap2_heading_ll
            r3 = 8
            r2.setVisibility(r3)
            android.widget.TextView r2 = r1.tv_lap1heading
            r2.setVisibility(r3)
            android.widget.LinearLayout r2 = r1.bookOnlyCnfLayout
            r2.setVisibility(r0)
            android.widget.EditText r0 = r1.preferred_coach_lap2
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r1.select_booking_ll
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r1.booking_choice
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.ll_wait_duration_lap1
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.tv_lap
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            r0.setVisibility(r3)
            android.widget.RelativeLayout r0 = r1.reservation_choice_rl_lap2
            r0.setVisibility(r3)
            Z2 r0 = r1.f4902a
            boolean r0 = r0.isMealChoiceenable()
            if (r0 == 0) goto L_0x1db0
            android.widget.LinearLayout r0 = r1.add_meal_ll
            r2 = 0
            r0.setVisibility(r2)
            goto L_0x1db6
        L_0x1db0:
            r2 = 0
            android.widget.LinearLayout r0 = r1.add_meal_ll
            r0.setVisibility(r3)
        L_0x1db6:
            android.widget.LinearLayout r0 = r1.traindetail_ll
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.select_passenger_lap2
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r1.train_detail_lap2
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.headind_travelinsurance_lap1
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.heading_travelInsurance
            r0.setVisibility(r2)
            r0 = r3
        L_0x1dd0:
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x1e50
            d2 r2 = r1.f4950b
            java.lang.String r2 = r2.getAvailablityStatus()
            r3 = r23
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x1dfc
            android.widget.TextView r2 = r1.all_laps_ll
            r2.setVisibility(r0)
            android.widget.TextView r2 = r1.lap2_rb
            r2.setVisibility(r0)
            android.widget.EditText r2 = r1.preferred_coach_lap2
            r2.setVisibility(r0)
            android.widget.RelativeLayout r2 = r1.reservation_choice_rl_lap2
            r2.setVisibility(r0)
            android.widget.TextView r2 = r1.tv_reservation_choice_lap2
            r2.setVisibility(r0)
            goto L_0x1e50
        L_0x1dfc:
            d2 r2 = r1.f4932a
            java.lang.String r2 = r2.getAvailablityStatus()
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x1e22
            android.widget.TextView r2 = r1.all_laps_ll
            r2.setVisibility(r0)
            android.widget.TextView r2 = r1.lap1_ll
            r2.setVisibility(r0)
            android.widget.EditText r2 = r1.preferredCoach
            r2.setVisibility(r0)
            android.widget.RelativeLayout r2 = r1.reservationChoiceLayout
            r2.setVisibility(r0)
            android.widget.TextView r2 = r1.reservationChoiceClick
            r2.setVisibility(r0)
            goto L_0x1e50
        L_0x1e22:
            android.widget.TextView r0 = r1.all_laps_ll
            r2 = 0
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.lap2_rb
            r0.setVisibility(r2)
            android.widget.EditText r0 = r1.preferred_coach_lap2
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r1.reservation_choice_rl_lap2
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.tv_reservation_choice_lap2
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.lap1_ll
            r0.setVisibility(r2)
            android.widget.EditText r0 = r1.preferredCoach
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r1.reservationChoiceLayout
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.reservationChoiceClick
            r0.setVisibility(r2)
        L_0x1e50:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r1.f4931a
            java.lang.String r2 = r2.getFromStnCode()
            r0.append(r2)
            r0.append(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r1.f4931a
            java.lang.String r2 = r2.getToStnCode()
            r0.append(r2)
            r0.append(r7)
            java.lang.String r2 = r1.f4986j
            r0.append(r2)
            r0.append(r7)
            java.lang.String r2 = P
            r0.append(r2)
            r0.append(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r1.f4931a
            java.lang.String r2 = r2.getTrainNumber()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.util.ArrayList<java.lang.String> r2 = defpackage.C0535I5.f3646h
            boolean r0 = r2.contains(r0)
            if (r0 != 0) goto L_0x1eac
            boolean r0 = cris.org.in.ima.fragment.AllTrainListFragment.i()
            if (r0 == 0) goto L_0x1e99
            goto L_0x1eac
        L_0x1e99:
            android.widget.ImageView r0 = r1.addfev_journey
            android.content.Context r2 = r1.f4904a
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131099852(0x7f0600cc, float:1.7812069E38)
            int r2 = r2.getColor(r3)
            r0.setColorFilter(r2)
            goto L_0x1ebe
        L_0x1eac:
            android.widget.ImageView r0 = r1.addfev_journey
            android.content.Context r2 = r1.f4904a
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131100596(0x7f0603b4, float:1.7813578E38)
            int r2 = r2.getColor(r3)
            r0.setColorFilter(r2)
        L_0x1ebe:
            return r24
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PassengerDetailFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    @OnClick({2131364383})
    public void onDoneAddMealClick(View view) {
        ArrayList<MealItemDetails> arrayList = this.f4890A;
        arrayList.clear();
        arrayList.addAll(C0535I5.f3624a);
        P0();
        this.add_meal_rl.setVisibility(8);
        this.rv_addmeal_list.setVisibility(0);
    }

    @OnClick({2131364405})
    public void onFemaleBtnClick(View view) {
        this.male.setSelected(false);
        this.feMale.setSelected(true);
        this.transGender.setSelected(false);
        this.F = "F";
        A0();
    }

    @OnClick({2131362692})
    public void onFoodChoiceClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4993l, new N());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Food_Preference));
        this.f4914a.f().setAdapter(customAdapter);
    }

    @OnTextChanged({2131362747})
    public void onGstinNumberTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (charSequence.length() == 15) {
            this.gstpassengerName.setEnabled(true);
            this.flatDoorBlock.setEnabled(true);
            this.streetLane.setEnabled(true);
            this.areaLocality.setEnabled(true);
            this.pinCode.setEnabled(true);
            this.state.setEnabled(true);
            this.city.setEnabled(true);
            this.gstpassengerName.requestFocus();
            k0();
        }
    }

    @OnClick({2131362809})
    public void onIdCardClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), this.f5007q, new J());
        this.f4914a.g().setText("Card Type");
        this.f4914a.f().setAdapter(customAdapter);
    }

    @OnClick({2131364268})
    public void onLap1AddBrackfastClick(View view) {
        C0535I5.o(this.f4904a, getResources().getString(cris.org.in.prs.ima.R.string.hb_covid19_msg), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131364273})
    public void onLap1AddLunchClick(View view) {
        C0535I5.o(this.f4904a, getResources().getString(cris.org.in.prs.ima.R.string.hb_covid19_msg), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131362936})
    public void onLap1selectbookClick(View view) {
        this.f4970e = 2;
        this.select_berth_choice.setVisibility(8);
        this.tv_select_confirm_berth_Choice.setText(getString(cris.org.in.prs.ima.R.string.First_Lap));
        this.all_laps_ll.setSelected(false);
        this.none_ll.setSelected(false);
        this.lap2_rb.setSelected(false);
        this.any_lap.setSelected(false);
        W0(this.none_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.all_laps_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap1_ll, cris.org.in.prs.ima.R.color.dark);
        W0(this.lap2_rb, cris.org.in.prs.ima.R.color.white);
        W0(this.any_lap, cris.org.in.prs.ima.R.color.white);
        this.none_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.all_laps_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap1_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForbold);
        this.lap2_rb.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.any_lap.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
    }

    @OnClick({2131362036})
    public void onLap2BerthPreferenceClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), this.f5016u, new Y());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.berth_Preference));
        this.f4914a.f().setAdapter(customAdapter);
    }

    @OnClick({2131362693})
    public void onLap2FoodChoiceClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4993l, new O());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Food_Preference));
        this.f4914a.f().setAdapter(customAdapter);
    }

    @OnClick({2131362810})
    public void onLap2IdCardClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), this.f5007q, new K());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Card_Type));
        this.f4914a.f().setAdapter(customAdapter);
    }

    @OnClick({2131363329})
    public void onLap2NoInsuranceClick(View view) {
        this.insurance_opt_lap2.setChecked(false);
        this.f5013t = "false";
        this.f4945b.setTravelInsuranceOpted(Boolean.FALSE);
        this.termcondition_ll.setVisibility(8);
    }

    @OnClick({2131364242})
    public void onLap2NoInsurancelayoutClick(View view) {
        this.insurance_opt_lap2.setChecked(false);
        this.no_insurance_opt_lap2.setChecked(true);
        this.f5013t = "false";
        this.f4945b.setTravelInsuranceOpted(Boolean.FALSE);
        this.termcondition_ll.setVisibility(8);
    }

    @OnClick({2131363067})
    public void onLap2SeniorCtznConcessionClick(View view) {
        try {
            C0535I5.H(this.f4906a, view);
            if (this.f5000n) {
                this.f5000n = false;
                if (!this.x.equals("IN")) {
                    X0(false);
                    C0535I5.t0(getContext(), getString(cris.org.in.prs.ima.R.string.Applicable_only_Indian_nationals));
                }
                new C0816cB(new T(), LogSeverity.CRITICAL_VALUE).a();
                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                this.f4914a = customDialogFragment;
                customDialogFragment.setShowsDialog(true);
                this.f4914a.show(getActivity().getSupportFragmentManager(), "");
                this.f4914a.setCancelable(true);
                getActivity().getSupportFragmentManager().z();
                CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4996m, new U());
                this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Senior_Citizen_Concession));
                this.f4914a.f().setAdapter(customAdapter);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363990})
    public void onLap2SpecialConcession(View view) {
        if ((S.equals("Y") || P.equals("HP")) && b.getConcessionalPassengerType() != null && this.E.equals("HANDICAP")) {
            this.f4965d.setPassengerCardType((String) null);
            this.f4965d.setPassengerCardNumber((String) null);
            this.f4965d.setPassengerIcardFlag(false);
        }
        C0535I5.H(this.f4906a, view);
        if (!this.x.equals("IN")) {
            C0535I5.t0(getContext(), getString(cris.org.in.prs.ima.R.string.Applicable_only_Indian_nationals));
            return;
        }
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        ArrayList<String> arrayList = new ArrayList<>();
        if (f4886a.getConcessionalPassengerType() == null || b.getConcessionalPassengerType() == null) {
            arrayList = this.f5002o;
        } else if (this.E.equals("HANDICAP")) {
            arrayList.add("Person with disability");
        } else if (this.E.equals("ESCORT")) {
            arrayList.add("Escort");
        } else {
            arrayList = this.f5002o;
        }
        CustomAdapter customAdapter = new CustomAdapter(getContext(), arrayList, new Q());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Select_Concession_Type));
        this.f4914a.f().setAdapter(customAdapter);
        if (t && this.f4999n.size() == 7) {
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Divyangjan));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Escort));
            this.f4999n.removeAll(this.f4892C);
        }
        if (u && this.f4999n.size() == 7) {
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Person));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Spouse));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Child));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Companion));
            this.f4999n.removeAll(this.f4892C);
        }
    }

    @OnClick({2131362856})
    public void onLap2YesInsuranceClick(View view) {
        this.no_insurance_opt_lap2.setChecked(false);
        this.f5013t = "true";
        this.f4945b.setTravelInsuranceOpted(Boolean.TRUE);
    }

    @OnClick({2131364246})
    public void onLap2YesInsurancelayoutClick(View view) {
        this.no_insurance_opt_lap2.setChecked(false);
        this.insurance_opt_lap2.setChecked(true);
        this.f5013t = "true";
        this.f4945b.setTravelInsuranceOpted(Boolean.TRUE);
    }

    @OnClick({2131362940})
    public void onLap2selectbookClick(View view) {
        this.f4970e = 3;
        this.select_berth_choice.setVisibility(8);
        this.tv_select_confirm_berth_Choice.setText(getString(cris.org.in.prs.ima.R.string.Second_Lap));
        this.all_laps_ll.setSelected(false);
        this.none_ll.setSelected(false);
        this.lap1_ll.setSelected(false);
        this.any_lap.setSelected(false);
        W0(this.none_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.all_laps_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap1_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap2_rb, cris.org.in.prs.ima.R.color.dark);
        W0(this.any_lap, cris.org.in.prs.ima.R.color.white);
        this.none_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.all_laps_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap1_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap2_rb.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForbold);
        this.any_lap.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
    }

    @OnClick({2131364270})
    public void onLapAddDinnerClick(View view) {
        C0535I5.o(this.f4904a, getResources().getString(cris.org.in.prs.ima.R.string.hb_covid19_msg), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131364279})
    public void onLapAddSnacksClick(View view) {
        C0535I5.o(this.f4904a, getResources().getString(cris.org.in.prs.ima.R.string.hb_covid19_msg), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131364384})
    public void onLapDoneAddMealClick(View view) {
        ArrayList<MealItemDetails> arrayList = this.f4890A;
        arrayList.clear();
        ArrayList<MealItemDetails> arrayList2 = this.f4891B;
        arrayList2.clear();
        arrayList.addAll(C0535I5.f3624a);
        arrayList2.addAll(C0535I5.f3629b);
        if (arrayList.size() > 0) {
            this.select_meal_lap1.setVisibility(0);
        } else {
            this.select_meal_lap1.setVisibility(8);
        }
        this.rv_selectmeal_lap1.setLayoutManager(new LinearLayoutManager(getContext()));
        Collections.sort(arrayList, new C0544Io());
        this.rv_selectmeal_lap1.setAdapter(new Lap1MealDetaillViewHolder(this.f4904a, arrayList, this.f4920a));
        a1();
        Q0();
        this.add_meal_rl_lap.setVisibility(8);
        this.rv_selectmeal_lap1.setVisibility(0);
        this.rv_selectmeal_lap2.setVisibility(0);
    }

    @OnClick({2131364475})
    public void onMaleBtnClick(View view) {
        this.male.setSelected(true);
        this.feMale.setSelected(false);
        this.transGender.setSelected(false);
        this.F = "M";
        A0();
    }

    @OnClick({2131364478})
    public void onMasterPassAddNewClick(View view) {
        this.existingpassenger_ll.setVisibility(8);
        if (l < f4889c.get(0).getMaxPassengers()) {
            this.f4994l = false;
            this.et_pass_upn.setText("");
            this.et_pass_upn.setEnabled(true);
            this.et_pass_booking_code.setText("");
            this.et_pass_booking_code.setEnabled(true);
            this.passengerAge.getText().clear();
            this.passengerAge.setError((CharSequence) null);
            this.passengerName.getText().clear();
            this.passengerName.setEnabled(true);
            this.passengerAge.setEnabled(true);
            this.male.setEnabled(true);
            this.feMale.setEnabled(true);
            this.transGender.setEnabled(true);
            lf.r(this.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, this.passengerName);
            lf.r(this.f4904a, cris.org.in.prs.ima.R.drawable.edittextborder, this.passengerAge);
            this.splDOB.getText().clear();
            this.splCardValidity.getText().clear();
            this.idCardNumber.getText().clear();
            this.spcCardnumber.getText().clear();
            this.berthPreference.setText(getString(cris.org.in.prs.ima.R.string.Select_Berth_Preference));
            this.srctznConcLayout.setVisibility(8);
            this.srctznConcession.setText(getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
            this.specialConcesionType.setText(getString(cris.org.in.prs.ima.R.string.Concession_Option));
            this.foodChoice.setText(getString(cris.org.in.prs.ima.R.string.catering_service_option));
            this.genderGroup.clearCheck();
            this.berthPreference.onCheckIsTextEditor();
            this.F = "";
            this.y = null;
            this.A = "NC";
            this.bedRoll.setChecked(false);
            this.isChildBerthReq.setChecked(false);
            this.isChildBerthll.setVisibility(8);
            this.donePsgnDetail.setText(getString(cris.org.in.prs.ima.R.string.add_Passenger));
            this.E = "";
            y0();
            g0(this.nationality.getText().toString());
            this.spcCardnumber.setEnabled(true);
            this.splDOB.setEnabled(true);
            this.splCardValidity.setEnabled(true);
            this.titleName.requestFocus();
            this.idCardNumber.setVisibility(8);
            if (C0535I5.f3647h) {
                this.is_bad_berth_lap2.setChecked(false);
                this.tv_conc_dob_lap2.getText().clear();
                this.tv_conc_cardvalidity_lap2.getText().clear();
                this.id_card_number_lap2.getText().clear();
                this.spc_card_number_lap2.getText().clear();
                this.ll_srctzn_concession_lap2.setVisibility(8);
                this.srctzn_concession_lap2.setText(getString(cris.org.in.prs.ima.R.string.Option_Senior_Citizen_Concession));
                this.special_concession_list_lap2.setText(getString(cris.org.in.prs.ima.R.string.Concession_Option));
                this.food_choice_lap2.setText(getString(cris.org.in.prs.ima.R.string.catering_service_option));
                this.z = null;
                this.berth_preference_lap2.setText(getString(cris.org.in.prs.ima.R.string.Select_Berth_Preference));
                this.berth_preference_lap2.onCheckIsTextEditor();
                this.B = "NC";
                this.is_childBerth_req_lap2.setChecked(false);
                this.is_childBerth_ll_lap2.setVisibility(8);
                this.spc_card_number_lap2.setEnabled(true);
                this.tv_conc_dob_lap2.setEnabled(true);
                this.tv_conc_cardvalidity_lap2.setEnabled(true);
                this.id_card_number_lap2.setVisibility(8);
            }
            if (this.addpassenger_rl.getVisibility() == 8) {
                this.addpassenger_rl.setVisibility(0);
            } else {
                this.addpassenger_rl.setVisibility(8);
            }
        } else if (!C0535I5.f3647h) {
            C0535I5.m(getActivity(), false, getResources().getString(cris.org.in.prs.ima.R.string.add_passenger_validation), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (this.f4928a.d.equals("TQ") || this.f4947b.d.equals("TQ")) {
            C0535I5.m(getActivity(), false, getString(cris.org.in.prs.ima.R.string.Max_passenger_limit_exceeded_TQ), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else {
            C0535I5.m(getActivity(), false, getResources().getString(cris.org.in.prs.ima.R.string.add_passenger_validation), getString(cris.org.in.prs.ima.R.string.error), getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    @OnClick({2131364479})
    public void onMasterPassCancelClick(View view) {
        if (this.f4978g.size() == 0) {
            Iterator<MasterPassengerModel> it = G.iterator();
            while (it.hasNext()) {
                MasterPassengerModel next = it.next();
                if (next.f5338a) {
                    next.f5338a = false;
                }
            }
        } else {
            Iterator<MasterPassengerModel> it2 = G.iterator();
            while (it2.hasNext()) {
                MasterPassengerModel next2 = it2.next();
                if (this.f4894E.contains(next2.a.getMasterListId())) {
                    next2.f5338a = true;
                } else {
                    next2.f5338a = false;
                }
            }
        }
        this.existingpassenger_ll.setVisibility(8);
        MasterPassengerViewHolder.setNoOfMasterPsgnSelected(0);
    }

    @OnClick({2131363301})
    public void onNationalityClick(View view) {
        this.f4941a = C0535I5.f3628b;
        this.f5017v = C0535I5.f3622a;
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f5017v, new L());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.select_Nationality));
        this.f4914a.f().setAdapter(customAdapter);
        this.idCardNumber.setText("");
        this.id_card_number_lap2.setText("");
    }

    @OnClick({2131363328})
    public void onNoInsuranceClick(View view) {
        this.insuranceOpt.setChecked(false);
        this.f5011s = "false";
        this.f4900a.setTravelInsuranceOpted(Boolean.FALSE);
        this.termcondition_ll.setVisibility(8);
    }

    @OnClick({2131364241})
    public void onNoInsurancelayoutClick(View view) {
        this.insuranceOpt.setChecked(false);
        this.noInsuranceOpt.setChecked(true);
        this.f5011s = "false";
        this.f4900a.setTravelInsuranceOpted(Boolean.FALSE);
        this.termcondition_ll.setVisibility(8);
    }

    @OnClick({2131364506})
    public void onNoneBerthClick(View view) {
        this.tvnone.setText(getString(cris.org.in.prs.ima.R.string.None));
        this.reservationChoiceClick.setText(this.tvnone.getText().toString());
        this.f4939a = 99;
        this.regervationchoice_ll.setVisibility(8);
    }

    @OnClick({2131364507})
    public void onNoneBerthLap2Click(View view) {
        this.tv_none_lap2.setText(getString(cris.org.in.prs.ima.R.string.None));
        this.f4952b = 99;
        this.regervation_choice_ll_lap2.setVisibility(8);
        if (C0535I5.f3647h) {
            this.tv_reservation_choice_lap2.setText(this.tv_none_lap2.getText().toString());
        }
    }

    @OnClick({2131363338})
    public void onNonselectbookClick(View view) {
        this.f4970e = 0;
        this.select_berth_choice.setVisibility(8);
        this.tv_select_confirm_berth_Choice.setText(getString(cris.org.in.prs.ima.R.string.No_cofirm_berth_choice_bothlaps));
        this.all_laps_ll.setSelected(false);
        this.lap1_ll.setSelected(false);
        this.lap2_rb.setSelected(false);
        this.any_lap.setSelected(false);
        W0(this.none_ll, cris.org.in.prs.ima.R.color.dark);
        W0(this.all_laps_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap1_ll, cris.org.in.prs.ima.R.color.white);
        W0(this.lap2_rb, cris.org.in.prs.ima.R.color.white);
        W0(this.any_lap, cris.org.in.prs.ima.R.color.white);
        this.none_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForbold);
        this.all_laps_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap1_ll.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.lap2_rb.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
        this.any_lap.setTextAppearance(getActivity(), cris.org.in.prs.ima.R.style.fontForNormal);
    }

    @OnClick({2131364515})
    public void onOneLowerBerthClick(View view) {
        this.tvnone.setText(this.oneLowerBerth.getText().toString());
        this.reservationChoiceClick.setText(this.oneLowerBerth.getText().toString());
        this.f4939a = 6;
        this.regervationchoice_ll.setVisibility(8);
    }

    @OnClick({2131364516})
    public void onOneLowerBerthLpap2Click(View view) {
        this.tv_none_lap2.setText(this.tv_one_lower_berth_lap2.getText().toString());
        this.f4952b = 6;
        this.regervation_choice_ll_lap2.setVisibility(8);
        if (C0535I5.f3647h) {
            this.tv_reservation_choice_lap2.setText(this.tv_one_lower_berth_lap2.getText().toString());
        }
    }

    @OnClick({2131362057})
    public void onOtherPreferenceClick(View view) {
        if (this.other_preference_bottom_rl.getVisibility() == 8) {
            this.other_preference_bottom_rl.setVisibility(0);
            if (this.f4934a.getBookingChoice() != null && this.f4934a.getBookingChoice().getHeader() != null) {
                ArrayList arrayList = this.f4990k;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f4990k = new ArrayList();
                    for (C1262mo.a aVar : this.f4934a.getBookingChoice().getOptions()) {
                        OtherPreferenceModel otherPreferenceModel = new OtherPreferenceModel();
                        otherPreferenceModel.a = aVar;
                        if (this.f4990k.size() == 0) {
                            otherPreferenceModel.f5339a = true;
                            this.f4966d = otherPreferenceModel.a.getValue();
                        }
                        this.f4990k.add(otherPreferenceModel);
                    }
                }
                this.other_preference.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
                OtherPreferenceLapwiseAdapter otherPreferenceLapwiseAdapter = new OtherPreferenceLapwiseAdapter(this.f4904a, this.f4990k, this.f4917a);
                this.f4910a = otherPreferenceLapwiseAdapter;
                this.other_preference.setAdapter(otherPreferenceLapwiseAdapter);
                return;
            }
            return;
        }
        this.other_preference_bottom_rl.setVisibility(8);
    }

    @OnClick({2131363449})
    public void onPassangerAgeClick(View view) {
        if (s) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4914a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4914a.show(getActivity().getSupportFragmentManager(), "");
            this.f4914a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f5018w, new Z());
            this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Age));
            this.f4914a.f().setAdapter(customAdapter);
        }
    }

    @OnClick({2131363446})
    public void onPassbookingconcessionClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), this.f4893D, new V());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.pass_booking));
        this.f4914a.f().setAdapter(customAdapter);
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    @OnTextChanged({2131362570})
    public void onPinCodeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (charSequence.length() == 6) {
            this.pinCode.clearFocus();
        }
    }

    @OnClick({2131362573})
    public void onPostOfficeClick(View view) {
        if (this.et_city_town.getText().toString().equalsIgnoreCase("") || this.et_city_town.getText().toString().equalsIgnoreCase("City")) {
            Toast.makeText(this.f4904a, getString(cris.org.in.prs.ima.R.string.Please_Select_City), 1).show();
            return;
        }
        ArrayList<String> arrayList = this.f5020y;
        if (arrayList != null && !arrayList.isEmpty()) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4914a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4914a.show(getActivity().getSupportFragmentManager(), "");
            this.f4914a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getActivity(), arrayList, new I());
            this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Select_Post_Office));
            this.f4914a.f().setAdapter(customAdapter);
        }
    }

    @OnTextChanged({2131362574})
    public void onPsgnPinCodeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (charSequence.length() == 6) {
            this.et_psgn_pincode.clearFocus();
        }
    }

    @OnClick({2131363641})
    public void onRegervationClick(View view) {
        this.regervationchoice_ll.setVisibility(8);
    }

    @OnClick({2131364570})
    public void onReservationChoiceClick(View view) {
        if (this.regervationchoice_ll.getVisibility() == 8) {
            this.regervationchoice_ll.setVisibility(0);
        } else {
            this.regervationchoice_ll.setVisibility(8);
        }
    }

    @OnClick({2131364571})
    public void onReservationChoiceLap2Click(View view) {
        if (this.regervation_choice_ll_lap2.getVisibility() == 8) {
            this.regervation_choice_ll_lap2.setVisibility(0);
        } else {
            this.regervation_choice_ll_lap2.setVisibility(8);
        }
    }

    @OnClick({2131363642})
    public void onReservationChoicelayoutLap2Click(View view) {
        this.regervation_choice_ll_lap2.setVisibility(8);
    }

    public final void onResume() {
        super.onResume();
        Context context = this.f4904a;
        View view = getView();
        AlertDialog alertDialog = C0535I5.f3619a;
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        if (C0535I5.f3649j) {
            C0822cf cfVar = this.f4907a;
            if (cfVar == null || !cfVar.getHyperServices().isInitialised()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("requestId", UUID.randomUUID().toString());
                    jSONObject.put(PaymentConstants.SERVICE, C1450w1.f7008a.getServiceUrl());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(LogCategory.ACTION, Labels.HyperSdk.INITIATE);
                    jSONObject2.put(PaymentConstants.MERCHANT_ID_CAMEL, C1450w1.f7008a.getMerchant_id());
                    jSONObject2.put(PaymentConstants.CLIENT_ID_CAMEL, C1450w1.f7008a.getClientId());
                    jSONObject2.put(PaymentConstants.ENV, C1450w1.f7008a.getEnvironment());
                    jSONObject2.put("customerId", C1450w1.f7026d);
                    jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
                    if (this.f4907a == null) {
                        this.f4907a = new C0822cf(getActivity());
                    }
                    this.f4907a.setCallback(new C0725Vo());
                    C0822cf cfVar2 = this.f4907a;
                    cfVar2.getClass();
                    jSONObject.toString();
                    cfVar2.getHyperServices().initiate(jSONObject, cfVar2);
                } catch (JSONException e2) {
                    e2.getMessage();
                } catch (Exception e3) {
                    e3.getMessage();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:178:0x0509  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0512  */
    @butterknife.OnClick({2131364385})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSaveBtnClick(android.view.View r18) {
        /*
            r17 = this;
            r1 = r17
            androidx.fragment.app.FragmentActivity r0 = r17.getActivity()
            defpackage.C0535I5.I(r0)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = new cris.prs.webservices.dto.PassengerDetailDTO
            r0.<init>()
            r1.f4959c = r0
            cris.prs.webservices.dto.PassengerDetailDTO r0 = new cris.prs.webservices.dto.PassengerDetailDTO
            r0.<init>()
            r1.f4965d = r0
            android.widget.EditText r0 = r1.splDOB
            cris.org.in.ima.fragment.PassengerDetailFragment$x r2 = r1.f4925a
            r0.addTextChangedListener(r2)
            android.widget.EditText r0 = r1.passengerName
            r0.clearFocus()
            android.widget.EditText r0 = r1.passengerAge
            int r0 = defpackage.lf.e(r0)
            if (r0 == 0) goto L_0x0032
            android.widget.EditText r0 = r1.passengerAge
            short r0 = defpackage.C0709Uj.m(r0)
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            java.lang.String r2 = r1.E
            java.lang.String r3 = "ESCORT"
            java.lang.String r4 = "GENERAL"
            java.lang.String r5 = "Y"
            java.lang.String r6 = ""
            if (r2 == 0) goto L_0x0067
            java.lang.String r2 = S
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0067
            java.lang.String r2 = r1.E
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0067
            java.lang.String r2 = r1.E
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0067
            int r2 = r1.i
            if (r2 == r0) goto L_0x0067
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131953942(0x7f130916, float:1.954437E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x0068
        L_0x0067:
            r2 = r6
        L_0x0068:
            android.widget.EditText r7 = r1.passengerName
            boolean r7 = defpackage.xx.T(r7, r6)
            r8 = 2131952363(0x7f1302eb, float:1.9541167E38)
            if (r7 == 0) goto L_0x0083
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getString(r8)
            android.content.Context r2 = r17.getContext()
            defpackage.C0535I5.t0(r2, r0)
            return
        L_0x0083:
            android.widget.EditText r7 = r1.passengerAge
            boolean r7 = defpackage.xx.T(r7, r6)
            r8 = 2131952358(0x7f1302e6, float:1.9541156E38)
            if (r7 == 0) goto L_0x009e
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getString(r8)
            android.content.Context r2 = r17.getContext()
            defpackage.C0535I5.t0(r2, r0)
            return
        L_0x009e:
            boolean r7 = s
            r8 = 2131953253(0x7f130665, float:1.9542972E38)
            java.lang.String r9 = "."
            int r10 = p
            r11 = 2131952360(0x7f1302e8, float:1.954116E38)
            r12 = 1
            r13 = 2131953827(0x7f1308a3, float:1.9544136E38)
            java.lang.String r14 = "IN"
            java.lang.String r15 = " "
            if (r7 != 0) goto L_0x0105
            b3 r7 = f4886a
            short r7 = r7.getMinPassengerAge()
            if (r0 < r7) goto L_0x00c4
            b3 r7 = f4886a
            short r7 = r7.getMaxPassengerAge()
            if (r0 <= r7) goto L_0x0105
        L_0x00c4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r7 = 2131951791(0x7f1300af, float:1.9540006E38)
            java.lang.String r7 = r1.getString(r7)
            r2.append(r7)
            b3 r7 = f4886a
            short r7 = r7.getMinPassengerAge()
            r2.append(r7)
            r2.append(r15)
            java.lang.String r7 = r1.getString(r13)
            r2.append(r7)
            r2.append(r15)
            b3 r7 = f4886a
            short r7 = r7.getMaxPassengerAge()
            r2.append(r7)
            r2.append(r9)
            r7 = 2131952919(0x7f130517, float:1.9542294E38)
            java.lang.String r7 = r1.getString(r7)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            goto L_0x02bd
        L_0x0105:
            boolean r7 = s
            if (r7 != r12) goto L_0x0145
            if (r0 < r10) goto L_0x0113
            b3 r7 = f4886a
            short r7 = r7.getMinPassengerAge()
            if (r0 < r7) goto L_0x0145
        L_0x0113:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r7 = 2131951854(0x7f1300ee, float:1.9540134E38)
            java.lang.String r7 = r1.getString(r7)
            r2.append(r7)
            r2.append(r10)
            r2.append(r15)
            java.lang.String r7 = r1.getString(r13)
            r2.append(r7)
            r2.append(r15)
            b3 r7 = f4886a
            short r7 = r7.getMinPassengerAge()
            int r7 = r7 - r12
            r2.append(r7)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            goto L_0x02bd
        L_0x0145:
            android.widget.EditText r7 = r1.passengerName
            int r7 = defpackage.lf.e(r7)
            b3 r9 = f4886a
            short r9 = r9.getMinNameLength()
            if (r7 < r9) goto L_0x028b
            android.widget.EditText r7 = r1.passengerName
            int r7 = defpackage.lf.e(r7)
            b3 r9 = f4886a
            short r9 = r9.getMaxNameLength()
            if (r7 <= r9) goto L_0x0163
            goto L_0x028b
        L_0x0163:
            android.widget.EditText r7 = r1.passengerName
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = defpackage.C0535I5.P(r7)
            if (r7 != 0) goto L_0x017d
            android.content.res.Resources r2 = r17.getResources()
            java.lang.String r2 = r2.getString(r8)
            goto L_0x02bd
        L_0x017d:
            java.lang.String r7 = r1.F
            if (r7 == 0) goto L_0x027f
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0189
            goto L_0x027f
        L_0x0189:
            android.widget.TextView r7 = r1.srctznConcession
            int r7 = r7.getVisibility()
            r8 = 2131953713(0x7f130831, float:1.9543905E38)
            if (r7 == 0) goto L_0x019c
            android.widget.LinearLayout r7 = r1.srctznConcLayout
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x01aa
        L_0x019c:
            int r7 = r1.g
            if (r7 != 0) goto L_0x01aa
            android.content.res.Resources r2 = r17.getResources()
            java.lang.String r2 = r2.getString(r8)
            goto L_0x02bd
        L_0x01aa:
            boolean r7 = defpackage.C0535I5.f3647h
            if (r7 == 0) goto L_0x01cc
            android.widget.TextView r7 = r1.srctzn_concession_lap2
            int r7 = r7.getVisibility()
            if (r7 == 0) goto L_0x01be
            android.widget.LinearLayout r7 = r1.ll_srctzn_concession_lap2
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x01cc
        L_0x01be:
            int r7 = r1.h
            if (r7 != 0) goto L_0x01cc
            android.content.res.Resources r2 = r17.getResources()
            java.lang.String r2 = r2.getString(r8)
            goto L_0x02bd
        L_0x01cc:
            b3 r7 = f4886a
            boolean r7 = r7.isFoodChoiceEnabled()
            if (r7 == 0) goto L_0x01e8
            java.lang.String r7 = r1.y
            if (r7 == 0) goto L_0x01de
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x01e8
        L_0x01de:
            android.content.res.Resources r2 = r17.getResources()
            java.lang.String r2 = r2.getString(r11)
            goto L_0x02bd
        L_0x01e8:
            boolean r7 = defpackage.C0535I5.f3647h
            if (r7 == 0) goto L_0x0208
            b3 r7 = b
            boolean r7 = r7.isFoodChoiceEnabled()
            if (r7 == 0) goto L_0x0208
            java.lang.String r7 = r1.z
            if (r7 == 0) goto L_0x01fe
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0208
        L_0x01fe:
            android.content.res.Resources r2 = r17.getResources()
            java.lang.String r2 = r2.getString(r11)
            goto L_0x02bd
        L_0x0208:
            java.lang.String r7 = r1.x
            boolean r7 = r7.equals(r14)
            if (r7 != 0) goto L_0x02bd
            android.widget.EditText r7 = r1.passportnumber_ft
            int r7 = defpackage.lf.e(r7)
            if (r7 != 0) goto L_0x0225
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131952366(0x7f1302ee, float:1.9541173E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x02bd
        L_0x0225:
            android.widget.EditText r7 = r1.passportnumber_ft
            int r7 = defpackage.lf.e(r7)
            r8 = 6
            if (r7 < r8) goto L_0x0273
            android.widget.EditText r7 = r1.passportnumber_ft
            int r7 = defpackage.lf.e(r7)
            r8 = 10
            if (r7 <= r8) goto L_0x0239
            goto L_0x0273
        L_0x0239:
            android.widget.EditText r7 = r1.passportnumber_ft
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = r1.H
            boolean r7 = r7.matches(r8)
            if (r7 == 0) goto L_0x0257
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131953283(0x7f130683, float:1.9543033E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x02bd
        L_0x0257:
            android.widget.EditText r7 = r1.passportnumber_ft
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = defpackage.C0535I5.T(r7)
            if (r7 != 0) goto L_0x02bd
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131953389(0x7f1306ed, float:1.9543248E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x02bd
        L_0x0273:
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131953390(0x7f1306ee, float:1.954325E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x02bd
        L_0x027f:
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131953688(0x7f130818, float:1.9543854E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x02bd
        L_0x028b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r7 = 2131951907(0x7f130123, float:1.9540242E38)
            java.lang.String r7 = r1.getString(r7)
            r2.append(r7)
            b3 r7 = f4886a
            short r7 = r7.getMinNameLength()
            r2.append(r7)
            r2.append(r15)
            java.lang.String r7 = r1.getString(r13)
            r2.append(r7)
            r2.append(r15)
            b3 r7 = f4886a
            short r7 = r7.getMaxNameLength()
            r2.append(r7)
            java.lang.String r2 = r2.toString()
        L_0x02bd:
            android.widget.TextView r7 = r1.passbooking_concession_list
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "General Booking"
            boolean r7 = r7.equalsIgnoreCase(r8)
            java.lang.String r8 = "S"
            r9 = 0
            if (r7 == 0) goto L_0x02e4
            java.lang.String r7 = S
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x02e4
            cris.prs.webservices.dto.PassengerDetailDTO r7 = r1.f4959c
            r7.setPassUPN(r9)
            cris.prs.webservices.dto.PassengerDetailDTO r7 = r1.f4959c
            r7.setPassBookingCode(r9)
        L_0x02e4:
            java.lang.String r7 = r1.E
            java.lang.String r9 = "HP"
            java.lang.String r11 = "Concession Option"
            if (r7 == 0) goto L_0x0589
            java.lang.String r7 = S
            boolean r7 = r7.equals(r5)
            if (r7 != 0) goto L_0x02fc
            java.lang.String r7 = P
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0589
        L_0x02fc:
            cris.prs.webservices.dto.PassengerDetailDTO r7 = r1.f4965d
            java.lang.String r12 = r1.E
            r7.setPsgnConcType(r12)
            cris.prs.webservices.dto.PassengerDetailDTO r7 = r1.f4959c
            java.lang.String r12 = r1.E
            r7.setPsgnConcType(r12)
            java.lang.String r7 = r1.E
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0334
            android.widget.EditText r7 = r1.spcCardnumber
            r7.setText(r6)
            android.widget.EditText r7 = r1.splDOB
            r7.setText(r6)
            android.widget.EditText r7 = r1.splCardValidity
            r7.setText(r6)
            boolean r7 = defpackage.C0535I5.f3647h
            if (r7 == 0) goto L_0x0334
            android.widget.EditText r7 = r1.spc_card_number_lap2
            r7.setText(r6)
            android.widget.EditText r7 = r1.tv_conc_dob_lap2
            r7.setText(r6)
            android.widget.EditText r7 = r1.tv_conc_cardvalidity_lap2
            r7.setText(r6)
        L_0x0334:
            android.widget.EditText r7 = r1.passengerAge
            int r7 = defpackage.lf.e(r7)
            if (r7 == 0) goto L_0x0342
            android.widget.EditText r0 = r1.passengerAge
            short r0 = defpackage.C0709Uj.m(r0)
        L_0x0342:
            android.widget.EditText r7 = r1.passengerName
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x0357
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131952363(0x7f1302eb, float:1.9541167E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x0433
        L_0x0357:
            android.widget.EditText r7 = r1.passengerAge
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x036c
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131952358(0x7f1302e6, float:1.9541156E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x0433
        L_0x036c:
            if (r0 >= r10) goto L_0x0376
            b3 r7 = f4886a
            short r7 = r7.getMinPassengerAge()
            if (r0 < r7) goto L_0x037e
        L_0x0376:
            b3 r7 = f4886a
            short r7 = r7.getMaxPassengerAge()
            if (r0 <= r7) goto L_0x03b2
        L_0x037e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r7 = 2131951639(0x7f130017, float:1.9539698E38)
            java.lang.String r7 = r1.getString(r7)
            r2.append(r7)
            b3 r7 = f4886a
            short r7 = r7.getMinPassengerAge()
            r2.append(r7)
            r2.append(r15)
            java.lang.String r7 = r1.getString(r13)
            r2.append(r7)
            r2.append(r15)
            b3 r7 = f4886a
            short r7 = r7.getMaxPassengerAge()
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            goto L_0x0433
        L_0x03b2:
            android.widget.EditText r7 = r1.passengerName
            int r7 = defpackage.lf.e(r7)
            b3 r10 = f4886a
            short r10 = r10.getMinNameLength()
            if (r7 < r10) goto L_0x0401
            android.widget.EditText r7 = r1.passengerName
            int r7 = defpackage.lf.e(r7)
            b3 r10 = f4886a
            short r10 = r10.getMaxNameLength()
            if (r7 <= r10) goto L_0x03cf
            goto L_0x0401
        L_0x03cf:
            android.widget.EditText r7 = r1.passengerName
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = defpackage.C0535I5.P(r7)
            if (r7 != 0) goto L_0x03eb
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131953253(0x7f130665, float:1.9542972E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x0433
        L_0x03eb:
            java.lang.String r7 = r1.F
            if (r7 == 0) goto L_0x03f5
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0433
        L_0x03f5:
            android.content.res.Resources r2 = r17.getResources()
            r7 = 2131953688(0x7f130818, float:1.9543854E38)
            java.lang.String r2 = r2.getString(r7)
            goto L_0x0433
        L_0x0401:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r7 = 2131951907(0x7f130123, float:1.9540242E38)
            java.lang.String r7 = r1.getString(r7)
            r2.append(r7)
            b3 r7 = f4886a
            short r7 = r7.getMinNameLength()
            r2.append(r7)
            r2.append(r15)
            java.lang.String r7 = r1.getString(r13)
            r2.append(r7)
            r2.append(r15)
            b3 r7 = f4886a
            short r7 = r7.getMaxNameLength()
            r2.append(r7)
            java.lang.String r2 = r2.toString()
        L_0x0433:
            java.lang.String r7 = r1.E
            boolean r7 = r7.equalsIgnoreCase(r4)
            if (r7 == 0) goto L_0x043f
            r18 = r8
            goto L_0x0591
        L_0x043f:
            android.widget.TextView r7 = r1.donePsgnDetail
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r10 = "Add Passenger"
            r7.equals(r10)
            b3 r7 = f4886a
            java.util.ArrayList r7 = r7.getConcessionalPassengerType()
            r12 = 2131951790(0x7f1300ae, float:1.9540004E38)
            if (r7 == 0) goto L_0x04db
            android.widget.TextView r7 = r1.specialConcesionType
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x046e
            r2 = 2131951979(0x7f13016b, float:1.9540388E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x04db
        L_0x046e:
            android.widget.EditText r7 = r1.spcCardnumber
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x047e
            r2 = 2131951782(0x7f1300a6, float:1.9539988E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x04db
        L_0x047e:
            android.widget.EditText r7 = r1.splDOB
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x048e
            r2 = 2131952532(0x7f130394, float:1.954151E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x04db
        L_0x048e:
            android.widget.EditText r7 = r1.splCardValidity
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x049e
            r2 = 2131951691(0x7f13004b, float:1.9539804E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x04db
        L_0x049e:
            java.lang.String r7 = r1.E
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x04c3
            android.widget.EditText r7 = r1.idCardNumber
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 != 0) goto L_0x04be
            android.widget.EditText r7 = r1.idCardNumber
            android.text.Editable r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = defpackage.C0535I5.K(r7)
            if (r7 != 0) goto L_0x04c3
        L_0x04be:
            java.lang.String r2 = r1.getString(r12)
            goto L_0x04db
        L_0x04c3:
            long r12 = r1.f4957c
            r18 = r8
            long r7 = r1.f4944b
            long r12 = r12 - r7
            r7 = 1
            long r12 = r12 - r7
            long r7 = r1.f4897a
            int r7 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x04dd
            r2 = 2131952166(0x7f130226, float:1.9540767E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x04dd
        L_0x04db:
            r18 = r8
        L_0x04dd:
            boolean r7 = defpackage.C0535I5.L()
            if (r7 == 0) goto L_0x0591
            android.widget.TextView r7 = r1.donePsgnDetail
            java.lang.CharSequence r7 = r7.getText()
            boolean r7 = r7.equals(r10)
            if (r7 != 0) goto L_0x04f1
            goto L_0x0591
        L_0x04f1:
            b3 r7 = b
            java.util.ArrayList r7 = r7.getConcessionalPassengerType()
            if (r7 == 0) goto L_0x0591
            android.widget.TextView r7 = r1.special_concession_list_lap2
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x0512
            r2 = 2131951979(0x7f13016b, float:1.9540388E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x0591
        L_0x0512:
            android.widget.EditText r7 = r1.spc_card_number_lap2
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x0523
            r2 = 2131951782(0x7f1300a6, float:1.9539988E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x0591
        L_0x0523:
            android.widget.EditText r7 = r1.tv_conc_dob_lap2
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x0533
            r2 = 2131952532(0x7f130394, float:1.954151E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x0591
        L_0x0533:
            android.widget.EditText r7 = r1.tv_conc_cardvalidity_lap2
            boolean r7 = defpackage.xx.T(r7, r6)
            if (r7 == 0) goto L_0x0543
            r2 = 2131951691(0x7f13004b, float:1.9539804E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x0591
        L_0x0543:
            b3 r7 = b
            boolean r7 = r7.isFoodChoiceEnabled()
            if (r7 == 0) goto L_0x0561
            java.lang.String r7 = r1.z
            if (r7 == 0) goto L_0x0555
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0561
        L_0x0555:
            android.content.res.Resources r2 = r17.getResources()
            r3 = 2131952360(0x7f1302e8, float:1.954116E38)
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0591
        L_0x0561:
            java.lang.String r7 = r1.E
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0591
            android.widget.EditText r3 = r1.id_card_number_lap2
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 != 0) goto L_0x0581
            android.widget.EditText r3 = r1.id_card_number_lap2
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            boolean r3 = defpackage.C0535I5.K(r3)
            if (r3 != 0) goto L_0x0591
        L_0x0581:
            r2 = 2131951790(0x7f1300ae, float:1.9540004E38)
            java.lang.String r2 = r1.getString(r2)
            goto L_0x0591
        L_0x0589:
            r18 = r8
            cris.prs.webservices.dto.PassengerDetailDTO r3 = r1.f4959c
            r7 = 0
            r3.setPsgnConcType(r7)
        L_0x0591:
            r16 = r2
            r2 = r0
            r0 = r16
            java.lang.String r3 = r1.x
            boolean r3 = r3.equals(r14)
            if (r3 != 0) goto L_0x05ad
            android.widget.EditText r3 = r1.tv_dob_ft
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 == 0) goto L_0x05ad
            r0 = 2131952532(0x7f130394, float:1.954151E38)
            java.lang.String r0 = r1.getString(r0)
        L_0x05ad:
            android.widget.EditText r3 = r1.et_pass_upn
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 == 0) goto L_0x05c4
            android.widget.EditText r3 = r1.et_pass_booking_code
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 != 0) goto L_0x05c4
            r0 = 2131951789(0x7f1300ad, float:1.9540002E38)
            java.lang.String r0 = r1.getString(r0)
        L_0x05c4:
            android.widget.EditText r3 = r1.et_pass_upn
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 != 0) goto L_0x05db
            android.widget.EditText r3 = r1.et_pass_booking_code
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 == 0) goto L_0x05db
            r0 = 2131951777(0x7f1300a1, float:1.9539978E38)
            java.lang.String r0 = r1.getString(r0)
        L_0x05db:
            boolean r3 = defpackage.C1450w1.e()
            if (r3 == 0) goto L_0x067b
            cris.prs.webservices.dto.PassengerDetailDTO r3 = r1.f4959c
            java.lang.String r7 = r1.E
            r3.setPsgnConcType(r7)
            cris.prs.webservices.dto.PassengerDetailDTO r3 = r1.f4965d
            java.lang.String r7 = r1.E
            r3.setPsgnConcType(r7)
            java.lang.String r3 = r1.E
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x05f9
            goto L_0x067b
        L_0x05f9:
            b3 r3 = f4886a
            java.util.ArrayList r3 = r3.getConcessionalPassengerType()
            if (r3 == 0) goto L_0x0638
            android.widget.TextView r3 = r1.specialConcesionType
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x0619
            r0 = 2131951979(0x7f13016b, float:1.9540388E38)
            java.lang.String r0 = r1.getString(r0)
            goto L_0x0638
        L_0x0619:
            android.widget.EditText r3 = r1.spcCardnumber
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 == 0) goto L_0x0629
            r0 = 2131951782(0x7f1300a6, float:1.9539988E38)
            java.lang.String r0 = r1.getString(r0)
            goto L_0x0638
        L_0x0629:
            android.widget.EditText r3 = r1.splCardValidity
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 == 0) goto L_0x0638
            r0 = 2131951691(0x7f13004b, float:1.9539804E38)
            java.lang.String r0 = r1.getString(r0)
        L_0x0638:
            boolean r3 = defpackage.C0535I5.f3647h
            if (r3 == 0) goto L_0x067b
            b3 r3 = b
            java.util.ArrayList r3 = r3.getConcessionalPassengerType()
            if (r3 == 0) goto L_0x067b
            android.widget.TextView r3 = r1.special_concession_list_lap2
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x065c
            r0 = 2131951979(0x7f13016b, float:1.9540388E38)
            java.lang.String r0 = r1.getString(r0)
            goto L_0x067b
        L_0x065c:
            android.widget.EditText r3 = r1.spc_card_number_lap2
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 == 0) goto L_0x066c
            r0 = 2131951782(0x7f1300a6, float:1.9539988E38)
            java.lang.String r0 = r1.getString(r0)
            goto L_0x067b
        L_0x066c:
            android.widget.EditText r3 = r1.tv_conc_cardvalidity_lap2
            boolean r3 = defpackage.xx.T(r3, r6)
            if (r3 == 0) goto L_0x067b
            r0 = 2131951691(0x7f13004b, float:1.9539804E38)
            java.lang.String r0 = r1.getString(r0)
        L_0x067b:
            boolean r3 = r0.equals(r6)
            if (r3 != 0) goto L_0x068a
            android.content.Context r3 = r17.getContext()
            defpackage.C0535I5.t0(r3, r0)
            r0 = 1
            goto L_0x068b
        L_0x068a:
            r0 = 0
        L_0x068b:
            if (r0 != 0) goto L_0x0db5
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            android.widget.EditText r3 = r1.passengerName
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setPassengerName(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Short r3 = java.lang.Short.valueOf(r2)
            r0.setPassengerAge(r3)
            android.widget.TextView r0 = r1.passbooking_concession_list
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "Pass Booking"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x06f0
            java.lang.String r0 = S
            r3 = r18
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x06f0
            android.widget.EditText r0 = r1.et_pass_upn
            boolean r0 = defpackage.xx.T(r0, r6)
            if (r0 != 0) goto L_0x06f0
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            android.widget.EditText r3 = r1.et_pass_upn
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            long r7 = java.lang.Long.parseLong(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r0.setPassUPN(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            android.widget.EditText r3 = r1.et_pass_booking_code
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setPassBookingCode(r3)
            goto L_0x06fb
        L_0x06f0:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r3 = 0
            r0.setPassUPN(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setPassBookingCode(r3)
        L_0x06fb:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            android.widget.EditText r3 = r1.spcCardnumber
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setPsgnConcCardId(r3)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x071d
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            android.widget.EditText r3 = r1.spc_card_number_lap2
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setPsgnConcCardId(r3)
        L_0x071d:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r3 = r1.F
            r0.setPassengerGender(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r3 = r1.f4930a
            java.lang.Long r3 = r3.getMpID()
            r0.setMpID(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r3 = r1.f4930a
            java.lang.Long r3 = r3.getSoftMemberId()
            r0.setSoftMemberId(r3)
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r7 = "dd/MM/yyyy"
            r3.<init>(r7, r0)
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
            java.lang.String r8 = "yyyyMMdd"
            r7.<init>(r8, r0)
            android.widget.EditText r0 = r1.splDOB     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            if (r0 == 0) goto L_0x0782
            android.widget.EditText r0 = r1.splDOB     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.trim()     // Catch:{ ParseException -> 0x084b }
            boolean r0 = r0.equals(r6)     // Catch:{ ParseException -> 0x084b }
            if (r0 != 0) goto L_0x0782
            android.widget.EditText r0 = r1.splDOB     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.util.Date r0 = r3.parse(r0)     // Catch:{ ParseException -> 0x084b }
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4959c     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r7.format(r0)     // Catch:{ ParseException -> 0x084b }
            r8.setPsgnConcDOB(r0)     // Catch:{ ParseException -> 0x084b }
            goto L_0x0788
        L_0x0782:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c     // Catch:{ ParseException -> 0x084b }
            r8 = 0
            r0.setPsgnConcDOB(r8)     // Catch:{ ParseException -> 0x084b }
        L_0x0788:
            boolean r0 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x084b }
            if (r0 == 0) goto L_0x07ca
            android.widget.EditText r0 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            if (r0 == 0) goto L_0x07c4
            android.widget.EditText r0 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.trim()     // Catch:{ ParseException -> 0x084b }
            boolean r0 = r0.equals(r6)     // Catch:{ ParseException -> 0x084b }
            if (r0 != 0) goto L_0x07c4
            android.widget.EditText r0 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.util.Date r0 = r3.parse(r0)     // Catch:{ ParseException -> 0x084b }
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4965d     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r7.format(r0)     // Catch:{ ParseException -> 0x084b }
            r8.setPsgnConcDOB(r0)     // Catch:{ ParseException -> 0x084b }
            goto L_0x07ca
        L_0x07c4:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d     // Catch:{ ParseException -> 0x084b }
            r8 = 0
            r0.setPsgnConcDOB(r8)     // Catch:{ ParseException -> 0x084b }
        L_0x07ca:
            android.widget.EditText r0 = r1.splCardValidity     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            if (r0 == 0) goto L_0x0802
            android.widget.EditText r0 = r1.splCardValidity     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.trim()     // Catch:{ ParseException -> 0x084b }
            boolean r0 = r0.equals(r6)     // Catch:{ ParseException -> 0x084b }
            if (r0 != 0) goto L_0x0802
            android.widget.EditText r0 = r1.splCardValidity     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.util.Date r0 = r3.parse(r0)     // Catch:{ ParseException -> 0x084b }
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4959c     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r7.format(r0)     // Catch:{ ParseException -> 0x084b }
            r8.setPsgnConcCardExpiryDate(r0)     // Catch:{ ParseException -> 0x084b }
            goto L_0x0808
        L_0x0802:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c     // Catch:{ ParseException -> 0x084b }
            r8 = 0
            r0.setPsgnConcCardExpiryDate(r8)     // Catch:{ ParseException -> 0x084b }
        L_0x0808:
            boolean r0 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x084b }
            if (r0 == 0) goto L_0x084f
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            if (r0 == 0) goto L_0x0844
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.trim()     // Catch:{ ParseException -> 0x084b }
            boolean r0 = r0.equals(r6)     // Catch:{ ParseException -> 0x084b }
            if (r0 != 0) goto L_0x0844
            android.widget.EditText r0 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x084b }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x084b }
            java.util.Date r0 = r3.parse(r0)     // Catch:{ ParseException -> 0x084b }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = r1.f4965d     // Catch:{ ParseException -> 0x084b }
            java.lang.String r0 = r7.format(r0)     // Catch:{ ParseException -> 0x084b }
            r6.setPsgnConcCardExpiryDate(r0)     // Catch:{ ParseException -> 0x084b }
            goto L_0x084f
        L_0x0844:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d     // Catch:{ ParseException -> 0x084b }
            r6 = 0
            r0.setPsgnConcCardExpiryDate(r6)     // Catch:{ ParseException -> 0x084b }
            goto L_0x084f
        L_0x084b:
            r0 = move-exception
            r0.getMessage()
        L_0x084f:
            int r0 = r1.g
            java.lang.String r6 = "NOCONC"
            r8 = 3
            java.lang.String r10 = "PSRCTN"
            r11 = 2
            java.lang.String r12 = "SRCTZN"
            r13 = 1
            if (r0 == r13) goto L_0x0891
            if (r0 == r11) goto L_0x087f
            if (r0 == r8) goto L_0x086d
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            r0.setConcessionOpted(r13)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setForGoConcessionOpted(r13)
            goto L_0x08a4
        L_0x086d:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            r0.setPassengerConcession(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            r0.setConcessionOpted(r13)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setForGoConcessionOpted(r13)
            goto L_0x08a4
        L_0x087f:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            r0.setPassengerConcession(r10)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            r0.setConcessionOpted(r13)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setForGoConcessionOpted(r13)
            goto L_0x08a4
        L_0x0891:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4930a
            r0.setPassengerConcession(r12)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            r0.setConcessionOpted(r13)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            r0.setForGoConcessionOpted(r13)
        L_0x08a4:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x08f5
            int r0 = r1.h
            r13 = 1
            if (r0 == r13) goto L_0x08e2
            if (r0 == r11) goto L_0x08d0
            if (r0 == r8) goto L_0x08be
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r0.setConcessionOpted(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r0.setForGoConcessionOpted(r6)
            goto L_0x08f5
        L_0x08be:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r0.setPassengerConcession(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r0.setConcessionOpted(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r0.setForGoConcessionOpted(r6)
            goto L_0x08f5
        L_0x08d0:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r0.setPassengerConcession(r10)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r0.setConcessionOpted(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r0.setForGoConcessionOpted(r6)
            goto L_0x08f5
        L_0x08e2:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            r0.setPassengerConcession(r12)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r0.setConcessionOpted(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r0.setForGoConcessionOpted(r6)
        L_0x08f5:
            boolean r0 = r1.f4994l
            java.lang.String r6 = "UNIQUE_ICARD"
            if (r0 == 0) goto L_0x0957
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.Short r8 = r8.getPassengerSerialNumber()
            r0.setPassengerSerialNumber(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerCardType()
            r0.setPassengerCardType(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getVerificationStatusString()
            r0.setVerificationStatusString(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerConcession()
            r0.setPassengerConcession(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r0 = r0.getPassengerCardType()
            if (r0 == 0) goto L_0x0957
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r0 = r0.getPassengerCardType()
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0957
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerCardType()
            r0.setPassengerCardType(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerCardNumber()
            r0.setPassengerCardNumber(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r8 = 1
            r0.setPassengerIcardFlag(r8)
        L_0x0957:
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x0a17
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.Short r8 = r8.getPassengerSerialNumber()
            r0.setPassengerSerialNumber(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerCardType()
            r0.setPassengerCardType(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getVerificationStatusString()
            r0.setVerificationStatusString(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerConcession()
            r0.setPassengerConcession(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r0 = r0.getPassengerCardType()
            if (r0 == 0) goto L_0x09b7
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r0 = r0.getPassengerCardType()
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x09b7
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerCardType()
            r0.setPassengerCardType(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4930a
            java.lang.String r8 = r8.getPassengerCardNumber()
            r0.setPassengerCardNumber(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r8 = 1
            r0.setPassengerIcardFlag(r8)
        L_0x09b7:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0a17
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4949b
            java.lang.Short r8 = r8.getPassengerSerialNumber()
            r0.setPassengerSerialNumber(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4949b
            java.lang.String r8 = r8.getPassengerCardType()
            r0.setPassengerCardType(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4949b
            java.lang.String r8 = r8.getVerificationStatusString()
            r0.setVerificationStatusString(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r8 = r1.f4949b
            java.lang.String r8 = r8.getPassengerConcession()
            r0.setPassengerConcession(r8)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.String r0 = r0.getPassengerCardType()
            if (r0 == 0) goto L_0x0a17
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4949b
            java.lang.String r0 = r0.getPassengerCardType()
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0a17
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r6 = r1.f4949b
            java.lang.String r6 = r6.getPassengerCardType()
            r0.setPassengerCardType(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r6 = r1.f4949b
            java.lang.String r6 = r6.getPassengerCardNumber()
            r0.setPassengerCardNumber(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r6 = 1
            r0.setPassengerIcardFlag(r6)
        L_0x0a17:
            java.lang.String r0 = S
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0a27
            java.lang.String r0 = P
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0a4a
        L_0x0a27:
            b3 r0 = f4886a
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x0a4a
            java.lang.String r0 = r1.E
            java.lang.String r6 = "HANDICAP"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0a4a
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r6 = 0
            r0.setPassengerCardType(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setPassengerCardNumber(r6)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r6 = 0
            r0.setPassengerIcardFlag(r6)
        L_0x0a4a:
            java.util.HashMap r0 = u0()
            if (r0 == 0) goto L_0x0aa1
            java.util.HashMap r0 = u0()
            cris.prs.webservices.dto.PassengerDetailDTO r6 = r1.f4959c
            java.lang.Short r6 = r6.getPassengerSerialNumber()
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x0aa1
            java.util.HashMap r0 = u0()
            cris.prs.webservices.dto.PassengerDetailDTO r6 = r1.f4959c
            java.lang.Short r6 = r6.getPassengerSerialNumber()
            r0.remove(r6)
            java.util.HashMap r0 = u0()
            r6 = 100
            java.lang.Short r8 = java.lang.Short.valueOf(r6)
            boolean r0 = r0.containsKey(r8)
            if (r0 == 0) goto L_0x0aa1
            java.util.HashMap r0 = u0()
            java.lang.Short r8 = java.lang.Short.valueOf(r6)
            java.lang.Object r0 = r0.get(r8)
            java.lang.Short r0 = (java.lang.Short) r0
            short r0 = r0.shortValue()
            java.util.HashMap r8 = u0()
            java.lang.Short r6 = java.lang.Short.valueOf(r6)
            int r0 = r0 + -1
            short r0 = (short) r0
            java.lang.Short r0 = java.lang.Short.valueOf(r0)
            r8.put(r6, r0)
        L_0x0aa1:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            android.widget.CheckBox r6 = r1.bedRoll
            boolean r6 = r6.isChecked()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.setPassengerBedrollChoice(r6)
            boolean r0 = defpackage.C0535I5.L()
            if (r0 == 0) goto L_0x0ac5
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            android.widget.CheckBox r6 = r1.is_bad_berth_lap2
            boolean r6 = r6.isChecked()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.setPassengerBedrollChoice(r6)
        L_0x0ac5:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Short r0 = r0.getPassengerAge()
            java.lang.String r6 = "NC"
            if (r0 == 0) goto L_0x0b10
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Short r0 = r0.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r8 = f4886a
            short r8 = r8.getMaxChildAge()
            if (r0 > r8) goto L_0x0b10
            android.widget.CheckBox r0 = r1.isChildBerthReq
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L_0x0aef
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setPassengerBerthChoice(r6)
            goto L_0x0af6
        L_0x0aef:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r8 = r1.A
            r0.setPassengerBerthChoice(r8)
        L_0x0af6:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0b22
            android.widget.CheckBox r0 = r1.is_childBerth_req_lap2
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L_0x0b08
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r0.setPassengerBerthChoice(r6)
            goto L_0x0b22
        L_0x0b08:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.String r8 = r1.B
            r0.setPassengerBerthChoice(r8)
            goto L_0x0b22
        L_0x0b10:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r8 = r1.A
            r0.setPassengerBerthChoice(r8)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0b22
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.String r8 = r1.B
            r0.setPassengerBerthChoice(r8)
        L_0x0b22:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r8 = r1.x
            r0.setPassengerNationality(r8)
            java.lang.String r0 = r1.x
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x0b99
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r4 = "PASSPORT"
            r0.setPassengerCardType(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            android.widget.EditText r4 = r1.passportnumber_ft
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r0.setPassengerCardNumber(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r4 = 1
            r0.setPassengerIcardFlag(r4)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0b6d
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.String r4 = "PASSPORT"
            r0.setPassengerCardType(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            android.widget.EditText r4 = r1.passportnumber_ft
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            r0.setPassengerCardNumber(r4)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r4 = 1
            r0.setPassengerIcardFlag(r4)
        L_0x0b6d:
            android.widget.EditText r0 = r1.tv_dob_ft     // Catch:{ ParseException -> 0x0b93 }
            android.text.Editable r0 = r0.getText()     // Catch:{ ParseException -> 0x0b93 }
            java.lang.String r0 = r0.toString()     // Catch:{ ParseException -> 0x0b93 }
            java.util.Date r0 = r3.parse(r0)     // Catch:{ ParseException -> 0x0b93 }
            cris.prs.webservices.dto.PassengerDetailDTO r3 = r1.f4959c     // Catch:{ ParseException -> 0x0b93 }
            java.lang.String r4 = r7.format(r0)     // Catch:{ ParseException -> 0x0b93 }
            r3.setPsgnConcDOB(r4)     // Catch:{ ParseException -> 0x0b93 }
            boolean r3 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x0b93 }
            if (r3 == 0) goto L_0x0c51
            cris.prs.webservices.dto.PassengerDetailDTO r3 = r1.f4965d     // Catch:{ ParseException -> 0x0b93 }
            java.lang.String r0 = r7.format(r0)     // Catch:{ ParseException -> 0x0b93 }
            r3.setPsgnConcDOB(r0)     // Catch:{ ParseException -> 0x0b93 }
            goto L_0x0c51
        L_0x0b93:
            r0 = move-exception
            r0.getMessage()
            goto L_0x0c51
        L_0x0b99:
            java.lang.String r0 = r1.x
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0c51
            java.lang.String r0 = r1.C
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 != 0) goto L_0x0c51
            java.lang.String r0 = S
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0bcb
            java.lang.String r0 = r1.E
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x0bcb
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r3 = 0
            r0.setPassengerCardType(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setPassengerCardNumber(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r3 = 0
            r0.setPassengerIcardFlag(r3)
            goto L_0x0bef
        L_0x0bcb:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r3 = r1.C
            K9 r3 = defpackage.K9.i(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setPassengerCardType(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            android.widget.EditText r3 = r1.idCardNumber
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setPassengerCardNumber(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r3 = 1
            r0.setPassengerIcardFlag(r3)
        L_0x0bef:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0c51
            java.lang.String r0 = S
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0c03
            java.lang.String r0 = P
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0c51
        L_0x0c03:
            b3 r0 = b
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x0c51
            java.lang.String r0 = S
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0c2d
            java.lang.String r0 = r1.E
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x0c2d
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r3 = 0
            r0.setPassengerCardType(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r0.setPassengerCardNumber(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r3 = 0
            r0.setPassengerIcardFlag(r3)
            goto L_0x0c51
        L_0x0c2d:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.String r3 = r1.D
            K9 r3 = defpackage.K9.i(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setPassengerCardType(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            android.widget.EditText r3 = r1.id_card_number_lap2
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setPassengerCardNumber(r3)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r3 = 1
            r0.setPassengerIcardFlag(r3)
        L_0x0c51:
            b3 r0 = q0()
            boolean r0 = r0.isFoodChoiceEnabled()
            if (r0 != 0) goto L_0x0c5f
            java.lang.String r0 = r1.y
            if (r0 == 0) goto L_0x0c66
        L_0x0c5f:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r3 = r1.y
            r0.setPassengerFoodChoice(r3)
        L_0x0c66:
            b3 r0 = q0()
            boolean r0 = r0.isFoodChoiceEnabled()
            if (r0 != 0) goto L_0x0c74
            java.lang.String r0 = r1.z
            if (r0 == 0) goto L_0x0c7b
        L_0x0c74:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.String r3 = r1.z
            r0.setPassengerFoodChoice(r3)
        L_0x0c7b:
            android.widget.CheckBox r0 = r1.isChildBerthReq
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L_0x0c9c
            boolean r0 = s
            if (r0 != 0) goto L_0x0c9c
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x0c94
            b3 r0 = f4886a
            short r0 = r0.getMinPassengerAge()
            if (r2 >= r0) goto L_0x0c94
            goto L_0x0c9c
        L_0x0c94:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r0.setChildBerthFlag(r3)
            goto L_0x0ca3
        L_0x0c9c:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.setChildBerthFlag(r3)
        L_0x0ca3:
            boolean r0 = defpackage.C0535I5.L()
            if (r0 == 0) goto L_0x0cd1
            android.widget.CheckBox r0 = r1.is_childBerth_req_lap2
            boolean r0 = r0.isChecked()
            if (r0 != 0) goto L_0x0cca
            boolean r0 = s
            if (r0 != 0) goto L_0x0cca
            boolean r0 = r1.f4994l
            if (r0 == 0) goto L_0x0cc2
            b3 r0 = f4886a
            short r0 = r0.getMinPassengerAge()
            if (r2 >= r0) goto L_0x0cc2
            goto L_0x0cca
        L_0x0cc2:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.setChildBerthFlag(r2)
            goto L_0x0cd1
        L_0x0cca:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.setChildBerthFlag(r2)
        L_0x0cd1:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.String r0 = r0.getPassengerNationality()
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x0cf5
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r0 = r0.getConcessionOpted()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0cf5
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.setConcessionOpted(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4959c
            r0.setForGoConcessionOpted(r2)
        L_0x0cf5:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            java.lang.String r2 = r2.getPassengerName()
            r0.setPassengerName(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            java.lang.Short r2 = r2.getPassengerAge()
            java.lang.String r2 = r2.toString()
            short r2 = java.lang.Short.parseShort(r2)
            java.lang.Short r2 = java.lang.Short.valueOf(r2)
            r0.setPassengerAge(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            java.lang.String r2 = r2.getPassengerGender()
            r0.setPassengerGender(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            java.lang.String r2 = r2.getPassengerNationality()
            r0.setPassengerNationality(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            java.lang.Long r2 = r2.getMpID()
            r0.setMpID(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            java.lang.String r2 = r2.getPassengerCardNumber()
            r0.setPassengerCardNumber(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            java.lang.String r2 = r2.getPsgnConcDOB()
            r0.setPsgnConcDOB(r2)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0d6f
            b3 r0 = b
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 != 0) goto L_0x0d61
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r2 = 0
            r0.setPassengerIcardFlag(r2)
            goto L_0x0d6f
        L_0x0d61:
            r0 = 0
            b3 r2 = f4886a
            java.util.ArrayList r2 = r2.getConcessionalPassengerType()
            if (r2 != 0) goto L_0x0d6f
            cris.prs.webservices.dto.PassengerDetailDTO r2 = r1.f4959c
            r2.setPassengerIcardFlag(r0)
        L_0x0d6f:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0d81
            java.lang.String r0 = r1.x
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x0d81
            cris.prs.webservices.dto.PassengerDetailDTO r0 = r1.f4965d
            r2 = 1
            r0.setPassengerIcardFlag(r2)
        L_0x0d81:
            r0 = 0
            s = r0
            android.widget.TextView r2 = r1.titleName
            r3 = 2131951633(0x7f130011, float:1.9539686E38)
            java.lang.String r3 = r1.getString(r3)
            r2.setText(r3)
            android.widget.RelativeLayout r2 = r1.addpassenger_rl
            r3 = 8
            r2.setVisibility(r3)
            java.lang.String r2 = "normalPsgn"
            r1.E0(r2)
            s = r0
            android.widget.TextView r0 = r1.titleName
            r2 = 2131951633(0x7f130011, float:1.9539686E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            android.widget.RelativeLayout r0 = r1.addpassenger_rl
            r2 = 8
            r0.setVisibility(r2)
            r17.d0()
            return
        L_0x0db5:
            r0 = 0
            android.widget.RelativeLayout r2 = r1.addpassenger_rl
            r2.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PassengerDetailFragment.onSaveBtnClick(android.view.View):void");
    }

    @OnClick({2131363762})
    public void onSaveChildClick(View view) {
        String str;
        boolean z2;
        C0535I5.I(getActivity());
        this.childPassengerName.clearFocus();
        this.f4899a = new Df();
        if (xx.T(this.childPassengerName, "")) {
            str = getResources().getString(cris.org.in.prs.ima.R.string.blank_name_validation);
        } else if (this.f4937a.byteValue() == -1) {
            str = getResources().getString(cris.org.in.prs.ima.R.string.blank_age_validation);
        } else if (lf.e(this.childPassengerName) < f4886a.getMinNameLength() || lf.e(this.childPassengerName) > f4886a.getMaxNameLength()) {
            str = getString(cris.org.in.prs.ima.R.string.Name_length_must_between) + f4886a.getMinNameLength() + " " + getString(cris.org.in.prs.ima.R.string.to_se) + " " + f4886a.getMaxNameLength();
        } else if (!C0535I5.P(this.childPassengerName.getText().toString())) {
            str = getResources().getString(cris.org.in.prs.ima.R.string.name_onlyAlphabet_validation);
        } else {
            String str2 = this.f4896G;
            if (str2 == null || str2.equals("")) {
                str = getResources().getString(cris.org.in.prs.ima.R.string.select_gender);
            } else {
                str = "";
            }
        }
        if (!str.equals("")) {
            C0535I5.t0(getContext(), str);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.f4899a.setName(this.childPassengerName.getText().toString());
            this.f4899a.setAge(this.f4937a);
            this.f4899a.setGender(this.f4896G);
            if (this.f4994l) {
                this.f4899a.setInfantSerialNumber(this.f4930a.getPassengerSerialNumber());
            }
            this.infantLayout.setVisibility(8);
            E0("infantPsgn");
        }
    }

    @OnClick({2131364012})
    public void onSeniorCtznConcessionClick(View view) {
        try {
            C0535I5.H(this.f4906a, view);
            if (this.f5000n) {
                this.f5000n = false;
                if (!this.x.equals("IN")) {
                    X0(false);
                    C0535I5.t0(getContext(), getString(cris.org.in.prs.ima.R.string.Applicable_only_Indian_nationals));
                }
                new C0816cB(new R(), LogSeverity.CRITICAL_VALUE).a();
                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                this.f4914a = customDialogFragment;
                customDialogFragment.setShowsDialog(true);
                this.f4914a.show(getActivity().getSupportFragmentManager(), "");
                this.f4914a.setCancelable(true);
                getActivity().getSupportFragmentManager().z();
                CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4996m, new S());
                this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Senior_Citizen_Concession));
                this.f4914a.f().setAdapter(customAdapter);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363989})
    public void onSpecialConcession(View view) {
        if ((S.equals("Y") || P.equals("HP")) && f4886a.getConcessionalPassengerType() != null && this.E.equals("HANDICAP")) {
            this.f4959c.setPassengerCardType((String) null);
            this.f4959c.setPassengerCardNumber((String) null);
            this.f4959c.setPassengerIcardFlag(false);
        }
        C0535I5.H(this.f4906a, view);
        if (!this.x.equals("IN")) {
            C0535I5.t0(getContext(), getString(cris.org.in.prs.ima.R.string.Applicable_only_Indian_nationals));
            return;
        }
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4914a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4914a.show(getActivity().getSupportFragmentManager(), "");
        this.f4914a.setCancelable(true);
        getActivity().getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4999n, new P());
        this.f4914a.g().setText(getString(cris.org.in.prs.ima.R.string.Select_Concession_Type));
        this.f4914a.f().setAdapter(customAdapter);
        if (t && this.f4999n.size() == 7) {
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Divyangjan));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Escort));
            this.f4999n.removeAll(this.f4892C);
        }
        if (u && this.f4999n.size() == 7) {
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Person));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Spouse));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Child));
            this.f4892C.add(getString(cris.org.in.prs.ima.R.string.Press_Companion));
            this.f4999n.removeAll(this.f4892C);
        }
    }

    @OnClick({2131363928})
    public void onStationClick(View view) {
        if (this.selectstation_ll.getVisibility() == 8) {
            this.selectstation_ll.setVisibility(0);
            this.boardingStnView.setVisibility(0);
            C0535I5.Y(getActivity(), this.boarding_station_top, this.f4913a);
            return;
        }
        this.selectstation_ll.setVisibility(8);
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    @OnClick({2131364285})
    public void onTAllBerthClick(View view) {
        this.tvnone.setText(this.allBerthConfirm.getText().toString());
        this.reservationChoiceClick.setText(this.allBerthConfirm.getText().toString());
        this.f4939a = 5;
        this.regervationchoice_ll.setVisibility(8);
    }

    @OnClick({2131364286})
    public void onTAllBerthLap2Click(View view) {
        this.tv_none_lap2.setText(this.tv_all_berth_confirm_lap2.getText().toString());
        this.f4952b = 5;
        this.regervation_choice_ll_lap2.setVisibility(8);
        if (C0535I5.f3647h) {
            this.tv_reservation_choice_lap2.setText(this.tv_all_berth_confirm_lap2.getText().toString());
        }
    }

    @OnClick({2131364695})
    public void onTransgenderBtnClick(View view) {
        this.male.setSelected(false);
        this.feMale.setSelected(false);
        this.transGender.setSelected(true);
        this.F = RequestConfiguration.MAX_AD_CONTENT_RATING_T;
        A0();
    }

    @OnClick({2131364702})
    public void onTwoLowerBerthClick(View view) {
        this.tvnone.setText(this.twoLowerBerth.getText().toString());
        this.reservationChoiceClick.setText(this.twoLowerBerth.getText().toString());
        this.f4939a = 7;
        this.regervationchoice_ll.setVisibility(8);
    }

    @OnClick({2131364703})
    public void onTwoLowerBerthLap2Click(View view) {
        this.tv_none_lap2.setText(this.tv_two_lower_berth_lap2.getText().toString());
        this.f4952b = 7;
        this.regervation_choice_ll_lap2.setVisibility(8);
        if (C0535I5.f3647h) {
            this.tv_reservation_choice_lap2.setText(this.tv_two_lower_berth_lap2.getText().toString());
        }
    }

    @OnClick({2131362855})
    public void onYesInsuranceClick(View view) {
        this.noInsuranceOpt.setChecked(false);
        this.f5011s = "true";
        this.f4900a.setTravelInsuranceOpted(Boolean.TRUE);
    }

    @OnClick({2131364245})
    public void onYesInsurancelayoutClick(View view) {
        this.noInsuranceOpt.setChecked(false);
        this.insuranceOpt.setChecked(true);
        this.f5011s = "true";
        this.f4900a.setTravelInsuranceOpted(Boolean.TRUE);
    }

    @OnClick({2131362285})
    public void onconfirmberthchoiceClick(View view) {
        if (this.select_berth_choice.getVisibility() == 8) {
            this.select_berth_choice.setVisibility(0);
        } else {
            this.select_berth_choice.setVisibility(8);
        }
    }

    @OnClick({2131361906})
    public void ongoneaddmeallay() {
        this.add_meal_rl.setVisibility(8);
    }

    @OnClick({2131363393})
    public void onllClick(View view) {
        if (this.other_preference_bottom_rl.getVisibility() == 8) {
            this.other_preference_bottom_rl.setVisibility(0);
        } else {
            this.other_preference_bottom_rl.setVisibility(8);
        }
    }

    @OnClick({2131363889})
    public void onselectbookClick(View view) {
        if (this.select_berth_choice.getVisibility() == 8) {
            this.select_berth_choice.setVisibility(0);
        } else {
            this.select_berth_choice.setVisibility(8);
        }
    }

    @OnClick({2131363886})
    public void onselectbookGoneClick(View view) {
        if (this.select_berth_choice.getVisibility() == 8) {
            this.select_berth_choice.setVisibility(0);
        } else {
            this.select_berth_choice.setVisibility(8);
        }
    }

    @OnClick({2131363447})
    public void passengerAddressHeadingClick() {
        if (this.passengerAddressInputLl.getVisibility() == 8) {
            this.passengerAddressInputLl.setVisibility(0);
        } else {
            this.passengerAddressInputLl.setVisibility(8);
        }
    }

    @OnFocusChange({2131363458})
    public void passengerNameVerify(View view) {
        if (!this.gstpassengerName.hasFocus()) {
            String h1 = h1();
            if (h1.equalsIgnoreCase("ok")) {
                G0(6);
                this.f4935a.setNameOnGst(this.gstpassengerName.getText().toString());
                return;
            }
            N0(6, h1);
        }
    }

    @OnFocusChange({2131362570})
    public void pinCodeValidate(View view) {
        if (!this.pinCode.hasFocus()) {
            String i1 = i1(this.pinCode.getText().toString());
            if (i1.equalsIgnoreCase("ok")) {
                w0(this.pinCode, this.state, this.city, (TextView) null, true);
                this.f4935a.setPin(this.pinCode.getText().toString());
                G0(1);
                return;
            }
            N0(1, i1);
        }
    }

    @OnFocusChange({2131362574})
    public void psgnPinCodeValidate(View view) {
        if (!this.et_psgn_pincode.hasFocus()) {
            String i1 = i1(this.et_psgn_pincode.getText().toString());
            if (i1.equalsIgnoreCase("ok")) {
                w0(this.et_psgn_pincode, this.et_state, this.et_city_town, this.et_post_office, false);
                G0(10);
                C0535I5.H(getActivity(), view);
                return;
            }
            N0(10, i1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0459  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0492  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0531  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x054c  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x056a  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0642  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0656  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x06d5  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x06f0  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0852  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0856  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x085a  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x086f  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0a01  */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x0a0c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r0(java.util.ArrayList<defpackage.C1426uk.a> r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "3"
            java.lang.String r3 = "2"
            r0 = 0
            java.lang.Short r4 = java.lang.Short.valueOf(r0)
            r5 = r0
            r6 = r5
            r7 = r6
        L_0x000e:
            int r0 = r23.size()
            java.lang.String r8 = "M"
            java.lang.String r9 = "HP"
            java.lang.String r10 = "F"
            java.lang.String r11 = "Y"
            if (r5 >= r0) goto L_0x0a14
            r12 = r23
            java.lang.Object r0 = r12.get(r5)
            r13 = r0
            uk$a r13 = (defpackage.C1426uk.a) r13
            cris.prs.webservices.dto.PassengerDetailDTO r14 = new cris.prs.webservices.dto.PassengerDetailDTO
            r14.<init>()
            cris.prs.webservices.dto.PassengerDetailDTO r15 = new cris.prs.webservices.dto.PassengerDetailDTO
            r15.<init>()
            java.lang.String r0 = S
            boolean r0 = r0.equals(r11)
            java.lang.String r12 = "dd/MM/yyyy"
            if (r0 != 0) goto L_0x0046
            java.lang.String r0 = P
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0042
            goto L_0x0046
        L_0x0042:
            r16 = r7
            goto L_0x01f5
        L_0x0046:
            b3 r0 = f4886a
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 != 0) goto L_0x0056
            b3 r0 = b
            java.util.ArrayList r0 = r0.getConcessionalPassengerType()
            if (r0 == 0) goto L_0x0042
        L_0x0056:
            java.lang.String r0 = r13.getUserType()     // Catch:{ Exception -> 0x01ef }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x01ef }
            if (r0 == 0) goto L_0x00bc
            java.lang.String r0 = r13.getRailwayIsuedCardNo()     // Catch:{ Exception -> 0x01ef }
            r14.setPsgnConcCardId(r0)     // Catch:{ Exception -> 0x01ef }
            java.util.Date r0 = r13.getDateValid()     // Catch:{ Exception -> 0x01ef }
            if (r0 == 0) goto L_0x0087
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ef }
            r16 = r7
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDateValid()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x0082 }
            r14.setPsgnConcCardExpiryDate(r0)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0089
        L_0x0082:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
            goto L_0x0089
        L_0x0087:
            r16 = r7
        L_0x0089:
            java.util.Date r0 = r13.getDobOnID()     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x00a6
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ed }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDobOnID()     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x00a2 }
            r14.setPsgnConcDOB(r0)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
        L_0x00a6:
            java.lang.String r0 = r13.getSrCtznConc()     // Catch:{ Exception -> 0x01ed }
            r14.setPsgnConcType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardType()     // Catch:{ Exception -> 0x01ed }
            r14.setPassengerCardType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardNumber()     // Catch:{ Exception -> 0x01ed }
            r14.setPassengerCardNumber(r0)     // Catch:{ Exception -> 0x01ed }
            goto L_0x00be
        L_0x00bc:
            r16 = r7
        L_0x00be:
            boolean r0 = defpackage.C0535I5.f3647h     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = r13.getUserType()     // Catch:{ Exception -> 0x01ed }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = r13.getRailwayIsuedCardNo()     // Catch:{ Exception -> 0x01ed }
            r15.setPsgnConcCardId(r0)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r0 = r13.getDateValid()     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x00f0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ed }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDateValid()     // Catch:{ Exception -> 0x00ec }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x00ec }
            r15.setPsgnConcCardExpiryDate(r0)     // Catch:{ Exception -> 0x00ec }
            goto L_0x00f0
        L_0x00ec:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
        L_0x00f0:
            java.util.Date r0 = r13.getDobOnID()     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x010d
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ed }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDobOnID()     // Catch:{ Exception -> 0x0109 }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x0109 }
            r15.setPsgnConcDOB(r0)     // Catch:{ Exception -> 0x0109 }
            goto L_0x010d
        L_0x0109:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
        L_0x010d:
            java.lang.String r0 = r13.getSrCtznConc()     // Catch:{ Exception -> 0x01ed }
            r15.setPsgnConcType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardType()     // Catch:{ Exception -> 0x01ed }
            r15.setPassengerCardType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardNumber()     // Catch:{ Exception -> 0x01ed }
            r15.setPassengerCardNumber(r0)     // Catch:{ Exception -> 0x01ed }
        L_0x0122:
            java.lang.String r0 = r13.getUserType()     // Catch:{ Exception -> 0x01ed }
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x0185
            r0 = 1
            r1.f4988j = r0     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getRailwayIsuedCardNo()     // Catch:{ Exception -> 0x01ed }
            r14.setPsgnConcCardId(r0)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r0 = r13.getDateValid()     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x0153
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ed }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDateValid()     // Catch:{ Exception -> 0x014f }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x014f }
            r14.setPsgnConcCardExpiryDate(r0)     // Catch:{ Exception -> 0x014f }
            goto L_0x0153
        L_0x014f:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
        L_0x0153:
            java.util.Date r0 = r13.getDobOnID()     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x0170
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ed }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDobOnID()     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x016c }
            r14.setPsgnConcDOB(r0)     // Catch:{ Exception -> 0x016c }
            goto L_0x0170
        L_0x016c:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
        L_0x0170:
            java.lang.String r0 = r13.getSrCtznConc()     // Catch:{ Exception -> 0x01ed }
            r14.setPsgnConcType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardType()     // Catch:{ Exception -> 0x01ed }
            r14.setPassengerCardType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardNumber()     // Catch:{ Exception -> 0x01ed }
            r14.setPassengerCardNumber(r0)     // Catch:{ Exception -> 0x01ed }
        L_0x0185:
            boolean r0 = defpackage.C0535I5.f3647h     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x01f5
            java.lang.String r0 = r13.getUserType()     // Catch:{ Exception -> 0x01ed }
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x01f5
            r0 = 1
            r1.f4988j = r0     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getRailwayIsuedCardNo()     // Catch:{ Exception -> 0x01ed }
            r15.setPsgnConcCardId(r0)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r0 = r13.getDateValid()     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x01ba
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ed }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDateValid()     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x01b6 }
            r15.setPsgnConcCardExpiryDate(r0)     // Catch:{ Exception -> 0x01b6 }
            goto L_0x01ba
        L_0x01b6:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
        L_0x01ba:
            java.util.Date r0 = r13.getDobOnID()     // Catch:{ Exception -> 0x01ed }
            if (r0 == 0) goto L_0x01d7
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01ed }
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x01ed }
            r0.<init>(r12, r7)     // Catch:{ Exception -> 0x01ed }
            java.util.Date r7 = r13.getDobOnID()     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r0 = r0.format(r7)     // Catch:{ Exception -> 0x01d3 }
            r15.setPsgnConcDOB(r0)     // Catch:{ Exception -> 0x01d3 }
            goto L_0x01d7
        L_0x01d3:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x01ed }
        L_0x01d7:
            java.lang.String r0 = r13.getSrCtznConc()     // Catch:{ Exception -> 0x01ed }
            r15.setPsgnConcType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardType()     // Catch:{ Exception -> 0x01ed }
            r15.setPassengerCardType(r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = r13.getIdCardNumber()     // Catch:{ Exception -> 0x01ed }
            r15.setPassengerCardNumber(r0)     // Catch:{ Exception -> 0x01ed }
            goto L_0x01f5
        L_0x01ed:
            r0 = move-exception
            goto L_0x01f2
        L_0x01ef:
            r0 = move-exception
            r16 = r7
        L_0x01f2:
            r0.getMessage()
        L_0x01f5:
            java.lang.String r0 = r13.getName()
            int r0 = r0.length()
            b3 r7 = f4886a
            short r7 = r7.getMaxNameLength()
            if (r0 <= r7) goto L_0x021a
            java.lang.String r0 = r13.getName()
            b3 r7 = f4886a
            short r7 = r7.getMaxNameLength()
            r17 = r2
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r7)
            r14.setPassengerName(r0)
            goto L_0x0223
        L_0x021a:
            r17 = r2
            java.lang.String r0 = r13.getName()
            r14.setPassengerName(r0)
        L_0x0223:
            short r0 = r13.getAge()
            java.lang.Short r0 = java.lang.Short.valueOf(r0)
            r14.setPassengerAge(r0)
            java.lang.String r0 = r13.getGender()
            r14.setPassengerGender(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0275
            java.lang.String r0 = r13.getName()
            int r0 = r0.length()
            b3 r2 = b
            short r2 = r2.getMaxNameLength()
            if (r0 <= r2) goto L_0x025c
            java.lang.String r0 = r13.getName()
            b3 r2 = b
            short r2 = r2.getMaxNameLength()
            r7 = 0
            java.lang.String r0 = r0.substring(r7, r2)
            r15.setPassengerName(r0)
            goto L_0x0263
        L_0x025c:
            java.lang.String r0 = r13.getName()
            r15.setPassengerName(r0)
        L_0x0263:
            short r0 = r13.getAge()
            java.lang.Short r0 = java.lang.Short.valueOf(r0)
            r15.setPassengerAge(r0)
            java.lang.String r0 = r13.getGender()
            r15.setPassengerGender(r0)
        L_0x0275:
            java.lang.String r0 = r13.getIdCardType()
            java.lang.String r2 = "UNIQUE_ICARD"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0293
            java.lang.String r0 = r13.getIdCardType()
            r14.setPassengerCardType(r0)
            java.lang.String r0 = r13.getIdCardNumber()
            r14.setPassengerCardNumber(r0)
            r0 = 1
            r14.setPassengerIcardFlag(r0)
        L_0x0293:
            int r0 = r13.getVerificationStatus()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r14.setVerificationStatus(r0)
            java.lang.String r0 = r13.getVerificationStatusString()
            r14.setVerificationStatusString(r0)
            java.util.List<b3> r0 = f4889c
            r7 = 0
            java.lang.Object r0 = r0.get(r7)
            b3 r0 = (defpackage.C0794b3) r0
            java.util.ArrayList r0 = r0.getApplicableBerthTypes()
            if (r0 == 0) goto L_0x02eb
            java.util.List<b3> r0 = f4889c
            java.lang.Object r0 = r0.get(r7)
            b3 r0 = (defpackage.C0794b3) r0
            java.util.ArrayList r0 = r0.getApplicableBerthTypes()
            java.util.Iterator r0 = r0.iterator()
        L_0x02c4:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x02eb
            java.lang.Object r7 = r0.next()
            java.lang.String r7 = (java.lang.String) r7
            r18 = r0
            java.lang.String r0 = r13.getBerthPreference()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x02e4
            java.lang.String r0 = r13.getBerthPreference()
            r14.setPassengerBerthChoice(r0)
            goto L_0x02eb
        L_0x02e4:
            r0 = 0
            r14.setPassengerBerthChoice(r0)
            r0 = r18
            goto L_0x02c4
        L_0x02eb:
            java.lang.String r0 = "IN"
            r14.setPassengerNationality(r0)
            java.util.List<b3> r7 = f4889c
            r18 = r3
            r3 = 0
            java.lang.Object r3 = r7.get(r3)
            b3 r3 = (defpackage.C0794b3) r3
            boolean r3 = r3.isFoodChoiceEnabled()
            java.lang.String r7 = "T"
            if (r3 == 0) goto L_0x0371
            java.lang.String r3 = r13.getFoodPreference()
            r19 = r6
            java.lang.String r6 = "NON_VEG"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x0314
            java.lang.String r3 = "N"
            goto L_0x036d
        L_0x0314:
            java.lang.String r3 = r13.getFoodPreference()
            java.lang.String r6 = "VEG"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x0323
            java.lang.String r3 = "V"
            goto L_0x036d
        L_0x0323:
            java.lang.String r3 = r13.getFoodPreference()
            java.lang.String r6 = "JAIN_MEAL"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x0332
            java.lang.String r3 = "J"
            goto L_0x036d
        L_0x0332:
            java.lang.String r3 = r13.getFoodPreference()
            java.lang.String r6 = "DIABETIC_VEG"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x0340
            r3 = r10
            goto L_0x036d
        L_0x0340:
            java.lang.String r3 = r13.getFoodPreference()
            java.lang.String r6 = "DIABETIC_NON_VEG"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x034f
            java.lang.String r3 = "G"
            goto L_0x036d
        L_0x034f:
            java.lang.String r3 = r13.getFoodPreference()
            java.lang.String r6 = "TEA_COFFEE"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x035d
            r3 = r7
            goto L_0x036d
        L_0x035d:
            java.lang.String r3 = r13.getFoodPreference()
            java.lang.String r6 = "SNACKS"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x036c
            java.lang.String r3 = "E"
            goto L_0x036d
        L_0x036c:
            r3 = 0
        L_0x036d:
            r14.setPassengerFoodChoice(r3)
            goto L_0x0373
        L_0x0371:
            r19 = r6
        L_0x0373:
            boolean r3 = defpackage.C0535I5.f3647h
            if (r3 == 0) goto L_0x0413
            java.lang.String r3 = r13.getIdCardType()
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0394
            java.lang.String r2 = r13.getIdCardType()
            r15.setPassengerCardType(r2)
            java.lang.String r2 = r13.getIdCardNumber()
            r15.setPassengerCardNumber(r2)
            r2 = 1
            r15.setPassengerIcardFlag(r2)
            goto L_0x0395
        L_0x0394:
            r2 = 1
        L_0x0395:
            int r3 = r13.getVerificationStatus()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r15.setVerificationStatus(r3)
            java.lang.String r3 = r13.getVerificationStatusString()
            r15.setVerificationStatusString(r3)
            java.util.List<b3> r3 = f4889c
            java.lang.Object r3 = r3.get(r2)
            b3 r3 = (defpackage.C0794b3) r3
            java.util.ArrayList r3 = r3.getApplicableBerthTypes()
            if (r3 == 0) goto L_0x03e8
            java.util.List<b3> r3 = f4889c
            java.lang.Object r2 = r3.get(r2)
            b3 r2 = (defpackage.C0794b3) r2
            java.util.ArrayList r2 = r2.getApplicableBerthTypes()
            java.util.Iterator r2 = r2.iterator()
        L_0x03c5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03e8
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r6 = r13.getBerthPreference()
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x03e3
            java.lang.String r2 = r13.getBerthPreference()
            r15.setPassengerBerthChoice(r2)
            goto L_0x03e8
        L_0x03e3:
            r3 = 0
            r15.setPassengerBerthChoice(r3)
            goto L_0x03c5
        L_0x03e8:
            r15.setPassengerNationality(r0)
            java.util.List<b3> r0 = f4889c
            r2 = 1
            java.lang.Object r0 = r0.get(r2)
            b3 r0 = (defpackage.C0794b3) r0
            boolean r0 = r0.isFoodChoiceEnabled()
            if (r0 == 0) goto L_0x0413
            java.lang.String r0 = r13.getFoodPreference()
            r2 = 0
            char r0 = r0.charAt(r2)
            J9 r0 = defpackage.J9.i(r0)
            char r0 = r0.a()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r15.setPassengerFoodChoice(r0)
            goto L_0x0414
        L_0x0413:
            r2 = 0
        L_0x0414:
            short r0 = r13.getAge()
            java.util.List<b3> r3 = f4889c
            java.lang.Object r2 = r3.get(r2)
            b3 r2 = (defpackage.C0794b3) r2
            short r2 = r2.getMaxChildAge()
            if (r0 <= r2) goto L_0x0431
            boolean r0 = s
            if (r0 == 0) goto L_0x042b
            goto L_0x0431
        L_0x042b:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14.setChildBerthFlag(r0)
            goto L_0x0436
        L_0x0431:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r14.setChildBerthFlag(r0)
        L_0x0436:
            java.lang.String r0 = r13.getSrCtznConc()
            r14.setPassengerConcession(r0)
            java.lang.String r0 = r13.getSrCtznConc()
            java.lang.String r2 = "NOCONC"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x048a
            java.util.List<b3> r0 = f4889c
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            b3 r0 = (defpackage.C0794b3) r0
            boolean r0 = r0.isSeniorCitizenApplicable()
            if (r0 != 0) goto L_0x0459
            goto L_0x048a
        L_0x0459:
            short r0 = r13.getAge()
            java.util.List<b3> r6 = f4889c
            java.lang.Object r6 = r6.get(r3)
            b3 r6 = (defpackage.C0794b3) r6
            short r6 = r6.getSrctznAge()
            if (r0 >= r6) goto L_0x0484
            short r0 = r13.getAge()
            java.util.List<b3> r6 = f4889c
            java.lang.Object r3 = r6.get(r3)
            b3 r3 = (defpackage.C0794b3) r3
            short r3 = r3.getSrctnwAge()
            if (r0 < r3) goto L_0x047e
            goto L_0x0484
        L_0x047e:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14.setConcessionOpted(r0)
            goto L_0x048e
        L_0x0484:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r14.setConcessionOpted(r0)
            goto L_0x048e
        L_0x048a:
            r0 = 0
            r14.setConcessionOpted(r0)
        L_0x048e:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x050b
            short r0 = r13.getAge()
            java.util.List<b3> r3 = f4889c
            r6 = 1
            java.lang.Object r3 = r3.get(r6)
            b3 r3 = (defpackage.C0794b3) r3
            short r3 = r3.getMaxChildAge()
            if (r0 <= r3) goto L_0x04b0
            boolean r0 = s
            if (r0 == 0) goto L_0x04aa
            goto L_0x04b0
        L_0x04aa:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r15.setChildBerthFlag(r0)
            goto L_0x04b5
        L_0x04b0:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r15.setChildBerthFlag(r0)
        L_0x04b5:
            java.lang.String r0 = r13.getSrCtznConc()
            r15.setPassengerConcession(r0)
            java.lang.String r0 = r13.getSrCtznConc()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0507
            java.util.List<b3> r0 = f4889c
            r2 = 1
            java.lang.Object r0 = r0.get(r2)
            b3 r0 = (defpackage.C0794b3) r0
            boolean r0 = r0.isSeniorCitizenApplicable()
            if (r0 != 0) goto L_0x04d6
            goto L_0x0507
        L_0x04d6:
            short r0 = r13.getAge()
            java.util.List<b3> r3 = f4889c
            java.lang.Object r3 = r3.get(r2)
            b3 r3 = (defpackage.C0794b3) r3
            short r3 = r3.getSrctznAge()
            if (r0 >= r3) goto L_0x0501
            short r0 = r13.getAge()
            java.util.List<b3> r3 = f4889c
            java.lang.Object r2 = r3.get(r2)
            b3 r2 = (defpackage.C0794b3) r2
            short r2 = r2.getSrctnwAge()
            if (r0 < r2) goto L_0x04fb
            goto L_0x0501
        L_0x04fb:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r15.setConcessionOpted(r0)
            goto L_0x050b
        L_0x0501:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r15.setConcessionOpted(r0)
            goto L_0x050b
        L_0x0507:
            r0 = 0
            r15.setConcessionOpted(r0)
        L_0x050b:
            boolean r0 = defpackage.C1450w1.e()
            java.lang.String r2 = "yyyyMMdd"
            if (r0 == 0) goto L_0x0616
            java.lang.String r0 = r14.getPsgnConcType()
            if (r0 != 0) goto L_0x0616
            java.util.ArrayList<java.lang.String> r0 = r1.f4999n
            int r0 = r0.size()
            r3 = 1
            if (r0 != r3) goto L_0x0616
            java.util.ArrayList<java.lang.String> r0 = r1.f4999n
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = defpackage.xx.i(r0)
            if (r0 == 0) goto L_0x054c
            android.widget.TextView r3 = r1.specialConcesionType
            java.lang.String r6 = defpackage.xx.b(r0)
            r3.setText(r6)
            android.widget.TextView r3 = r1.special_concession_list_lap2
            java.lang.String r6 = defpackage.xx.b(r0)
            r3.setText(r6)
            java.lang.String r0 = defpackage.xx.b(r0)
            r14.setPsgnConcType(r0)
            r0 = 0
            goto L_0x0566
        L_0x054c:
            android.widget.TextView r0 = r1.specialConcesionType
            java.util.ArrayList<java.lang.String> r3 = r1.f4999n
            r6 = 0
            java.lang.Object r3 = r3.get(r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            java.util.ArrayList<java.lang.String> r0 = r1.f4999n
            java.lang.Object r0 = r0.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            r14.setPsgnConcType(r0)
            r0 = r6
        L_0x0566:
            java.util.ArrayList<java.lang.String> r3 = r1.f5019x
            if (r3 == 0) goto L_0x0616
            android.widget.EditText r6 = r1.spcCardnumber
            java.lang.Object r3 = r3.get(r0)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setText(r3)
            boolean r3 = defpackage.C0535I5.f3647h
            if (r3 == 0) goto L_0x0586
            android.widget.EditText r3 = r1.spc_card_number_lap2
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x
            java.lang.Object r6 = r6.get(r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x0586:
            java.util.ArrayList<java.lang.String> r3 = r1.f5019x
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r14.setPsgnConcCardId(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            r0.<init>(r2, r3)
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat
            r6.<init>(r12, r3)
            java.util.ArrayList<java.lang.String> r3 = r1.f5019x     // Catch:{ ParseException -> 0x060e, Exception -> 0x0606 }
            r20 = r5
            r5 = 1
            java.lang.Object r3 = r3.get(r5)     // Catch:{ ParseException -> 0x0602, Exception -> 0x05fe }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ ParseException -> 0x0602, Exception -> 0x05fe }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x0602, Exception -> 0x05fe }
            r21 = r9
            java.util.ArrayList<java.lang.String> r9 = r1.f5019x     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.Object r5 = r9.get(r5)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            r14.setPsgnConcDOB(r5)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            android.widget.EditText r5 = r1.splDOB     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.String r9 = r6.format(r3)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            r5.setText(r9)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.util.ArrayList<java.lang.String> r5 = r1.f5019x     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            r9 = 2
            java.lang.Object r5 = r5.get(r9)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.util.Date r0 = r0.parse(r5)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.util.ArrayList<java.lang.String> r5 = r1.f5019x     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.Object r5 = r5.get(r9)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            r14.setPsgnConcCardExpiryDate(r5)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            android.widget.EditText r5 = r1.splCardValidity     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.String r9 = r6.format(r0)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            r5.setText(r9)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            boolean r5 = defpackage.C0535I5.f3647h     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            if (r5 == 0) goto L_0x061a
            android.widget.EditText r5 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.String r3 = r6.format(r3)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            r5.setText(r3)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            android.widget.EditText r3 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            java.lang.String r0 = r6.format(r0)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            r3.setText(r0)     // Catch:{ ParseException -> 0x05fc, Exception -> 0x05fa }
            goto L_0x061a
        L_0x05fa:
            r0 = move-exception
            goto L_0x060a
        L_0x05fc:
            r0 = move-exception
            goto L_0x0612
        L_0x05fe:
            r0 = move-exception
        L_0x05ff:
            r21 = r9
            goto L_0x060a
        L_0x0602:
            r0 = move-exception
        L_0x0603:
            r21 = r9
            goto L_0x0612
        L_0x0606:
            r0 = move-exception
            r20 = r5
            goto L_0x05ff
        L_0x060a:
            r0.getMessage()
            goto L_0x061a
        L_0x060e:
            r0 = move-exception
            r20 = r5
            goto L_0x0603
        L_0x0612:
            r0.getMessage()
            goto L_0x061a
        L_0x0616:
            r20 = r5
            r21 = r9
        L_0x061a:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x06c5
            boolean r0 = defpackage.C1450w1.e()
            if (r0 == 0) goto L_0x06c5
            java.lang.String r0 = r15.getPsgnConcType()
            if (r0 != 0) goto L_0x06c5
            java.util.ArrayList<java.lang.String> r0 = r1.f5002o
            int r0 = r0.size()
            r3 = 1
            if (r0 != r3) goto L_0x06c5
            java.util.ArrayList<java.lang.String> r0 = r1.f5002o
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = defpackage.xx.i(r0)
            if (r0 == 0) goto L_0x0652
            android.widget.TextView r3 = r1.special_concession_list_lap2
            java.lang.String r5 = defpackage.xx.b(r0)
            r3.setText(r5)
            java.lang.String r0 = defpackage.xx.b(r0)
            r15.setPsgnConcType(r0)
        L_0x0652:
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            if (r0 == 0) goto L_0x06c5
            android.widget.EditText r3 = r1.spc_card_number_lap2
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
            java.util.ArrayList<java.lang.String> r0 = r1.f5019x
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            r15.setPsgnConcCardId(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            r0.<init>(r2, r3)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            r2.<init>(r12, r3)
            java.util.ArrayList<java.lang.String> r3 = r1.f5019x     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            r5 = 1
            java.lang.Object r3 = r3.get(r5)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.util.ArrayList<java.lang.String> r6 = r1.f5019x     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            r15.setPsgnConcDOB(r5)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.util.ArrayList<java.lang.String> r5 = r1.f5019x     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            r6 = 2
            java.lang.Object r5 = r5.get(r6)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.util.Date r0 = r0.parse(r5)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.util.ArrayList<java.lang.String> r5 = r1.f5019x     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            r15.setPsgnConcCardExpiryDate(r5)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            android.widget.EditText r5 = r1.tv_conc_dob_lap2     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.String r3 = r2.format(r3)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            r5.setText(r3)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            android.widget.EditText r3 = r1.tv_conc_cardvalidity_lap2     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            java.lang.String r0 = r2.format(r0)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            r3.setText(r0)     // Catch:{ ParseException -> 0x06c1, Exception -> 0x06bc }
            goto L_0x06c5
        L_0x06bc:
            r0 = move-exception
            r0.getMessage()
            goto L_0x06c5
        L_0x06c1:
            r0 = move-exception
            r0.getMessage()
        L_0x06c5:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14.setForGoConcessionOpted(r0)
            java.lang.Long r2 = r13.getMasterListId()
            r14.setMpID(r2)
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x06df
            r15.setForGoConcessionOpted(r0)
            java.lang.Long r0 = r13.getMasterListId()
            r15.setMpID(r0)
        L_0x06df:
            java.util.ArrayList<java.lang.Long> r0 = r1.f4894E
            java.lang.Long r2 = r14.getMpID()
            boolean r2 = r0.contains(r2)
            r3 = 2131953103(0x7f1305cf, float:1.9542668E38)
            r5 = 100
            if (r2 != 0) goto L_0x085a
            boolean r2 = defpackage.C1450w1.e()
            if (r2 == 0) goto L_0x0710
            int r2 = t0()
            r6 = 1
            int r2 = r2 + r6
            int r9 = r1.j
            if (r2 <= r9) goto L_0x0711
            android.content.Context r0 = r22.getContext()
            java.lang.String r2 = r1.getString(r3)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r6)
            r0.show()
            return
        L_0x0710:
            r6 = 1
        L_0x0711:
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4963c
            int r9 = r2.size()
            int r9 = r9 + r6
            short r9 = (short) r9
            java.lang.Short r9 = java.lang.Short.valueOf(r9)
            r14.setPassengerSerialNumber(r9)
            int r9 = r2.size()
            r2.add(r9, r14)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4978g
            int r9 = r2.size()
            r2.add(r9, r14)
            int r2 = t0()
            int r2 = r2 + r6
            S0(r2)
            java.lang.Long r2 = r14.getMpID()
            r0.add(r2)
            java.util.HashMap<java.lang.Short, java.lang.Short> r0 = f4888b
            java.lang.Short r2 = r14.getPassengerSerialNumber()
            r0.put(r2, r4)
            b3 r0 = f4886a
            boolean r0 = r0.isBedRollFlagEnabled()
            if (r0 != 0) goto L_0x0810
            b3 r0 = f4886a
            boolean r0 = r0.isSeniorCitizenApplicable()
            if (r0 == 0) goto L_0x07ac
            java.lang.String r0 = r14.getPassengerGender()
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0772
            java.lang.Short r0 = r14.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r2 = f4886a
            short r2 = r2.getSrctznAge()
            if (r0 >= r2) goto L_0x07a6
        L_0x0772:
            java.lang.String r0 = r14.getPassengerGender()
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x078c
            java.lang.Short r0 = r14.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r2 = f4886a
            short r2 = r2.getSrctnwAge()
            if (r0 >= r2) goto L_0x07a6
        L_0x078c:
            java.lang.String r0 = r14.getPassengerGender()
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x07ac
            java.lang.Short r0 = r14.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r2 = f4886a
            short r2 = r2.getSrctznAge()
            if (r0 < r2) goto L_0x07ac
        L_0x07a6:
            java.lang.Boolean r0 = r14.getConcessionOpted()
            if (r0 == 0) goto L_0x0810
        L_0x07ac:
            b3 r0 = f4886a
            boolean r0 = r0.isChildBerthMandatory()
            if (r0 != 0) goto L_0x07c4
            java.lang.Short r0 = r14.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r2 = f4886a
            short r2 = r2.getMaxChildAge()
            if (r0 <= r2) goto L_0x0810
        L_0x07c4:
            java.lang.Boolean r0 = r14.getChildBerthFlag()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x07de
            java.lang.Short r0 = r14.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r2 = f4886a
            short r2 = r2.getMinPassengerAge()
            if (r0 < r2) goto L_0x0810
        L_0x07de:
            b3 r0 = f4886a
            boolean r0 = r0.isFoodChoiceEnabled()
            if (r0 == 0) goto L_0x07ee
            b3 r0 = f4886a
            java.util.List r0 = r0.getFoodDetails()
            if (r0 != 0) goto L_0x0810
        L_0x07ee:
            java.lang.String r0 = S
            boolean r0 = r0.equalsIgnoreCase(r11)
            if (r0 != 0) goto L_0x0810
            java.lang.String r0 = P
            r2 = r21
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x0812
            boolean r0 = defpackage.C1450w1.e()
            if (r0 == 0) goto L_0x080d
            java.lang.String r0 = r14.getPsgnConcType()
            if (r0 != 0) goto L_0x080d
            goto L_0x0812
        L_0x080d:
            r6 = r19
            goto L_0x084e
        L_0x0810:
            r2 = r21
        L_0x0812:
            java.util.HashMap<java.lang.Short, java.lang.Short> r0 = f4888b
            java.lang.Short r6 = java.lang.Short.valueOf(r5)
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x083f
            java.util.HashMap<java.lang.Short, java.lang.Short> r0 = f4888b
            java.lang.Short r6 = java.lang.Short.valueOf(r5)
            java.lang.Object r0 = r0.get(r6)
            java.lang.Short r0 = (java.lang.Short) r0
            short r0 = r0.shortValue()
            java.util.HashMap<java.lang.Short, java.lang.Short> r6 = f4888b
            java.lang.Short r9 = java.lang.Short.valueOf(r5)
            int r0 = r0 + 1
            short r0 = (short) r0
            java.lang.Short r0 = java.lang.Short.valueOf(r0)
            r6.put(r9, r0)
            goto L_0x084d
        L_0x083f:
            r0 = 1
            java.util.HashMap<java.lang.Short, java.lang.Short> r6 = f4888b
            java.lang.Short r9 = java.lang.Short.valueOf(r5)
            java.lang.Short r0 = java.lang.Short.valueOf(r0)
            r6.put(r9, r0)
        L_0x084d:
            r6 = 1
        L_0x084e:
            cris.org.in.ima.adaptors.AddPassengerViewHolder r0 = r1.f4908a
            if (r0 != 0) goto L_0x0856
            r22.J0()
            goto L_0x085e
        L_0x0856:
            r0.notifyDataSetChanged()
            goto L_0x085e
        L_0x085a:
            r2 = r21
            r6 = r19
        L_0x085e:
            com.google.android.gms.ads.admanager.AdManagerAdView r0 = r1.passengerCenter
            r9 = 8
            r0.setVisibility(r9)
            androidx.recyclerview.widget.RecyclerView r0 = r1.passengerList
            r9 = 0
            r0.setVisibility(r9)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x09fb
            java.util.ArrayList<java.lang.Long> r0 = r1.f4895F
            java.lang.Long r9 = r14.getMpID()
            boolean r9 = r0.contains(r9)
            if (r9 != 0) goto L_0x09fb
            boolean r9 = defpackage.C1450w1.e()
            if (r9 == 0) goto L_0x089b
            int r9 = t0()
            r12 = 1
            int r9 = r9 + r12
            int r13 = r1.j
            if (r9 <= r13) goto L_0x089c
            android.content.Context r0 = r22.getContext()
            java.lang.String r2 = r1.getString(r3)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r12)
            r0.show()
            return
        L_0x089b:
            r12 = 1
        L_0x089c:
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r3 = r1.f4968d
            int r9 = r3.size()
            int r9 = r9 + r12
            short r9 = (short) r9
            java.lang.Short r9 = java.lang.Short.valueOf(r9)
            r15.setPassengerSerialNumber(r9)
            int r9 = r3.size()
            r3.add(r9, r15)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r3 = r1.f4981h
            int r9 = r3.size()
            r3.add(r9, r15)
            java.lang.Long r3 = r15.getMpID()
            r0.add(r3)
            java.util.HashMap<java.lang.Short, java.lang.Short> r0 = c
            java.lang.Short r3 = r15.getPassengerSerialNumber()
            r0.put(r3, r4)
            b3 r0 = b
            boolean r0 = r0.isBedRollFlagEnabled()
            if (r0 != 0) goto L_0x09a3
            b3 r0 = b
            boolean r0 = r0.isSeniorCitizenApplicable()
            if (r0 == 0) goto L_0x092f
            java.lang.String r0 = r15.getPassengerGender()
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x08f5
            java.lang.Short r0 = r15.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r3 = b
            short r3 = r3.getSrctznAge()
            if (r0 >= r3) goto L_0x0929
        L_0x08f5:
            java.lang.String r0 = r15.getPassengerGender()
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x090f
            java.lang.Short r0 = r15.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r3 = b
            short r3 = r3.getSrctnwAge()
            if (r0 >= r3) goto L_0x0929
        L_0x090f:
            java.lang.String r0 = r15.getPassengerGender()
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x092f
            java.lang.Short r0 = r15.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r3 = b
            short r3 = r3.getSrctznAge()
            if (r0 < r3) goto L_0x092f
        L_0x0929:
            java.lang.Boolean r0 = r15.getConcessionOpted()
            if (r0 == 0) goto L_0x09a3
        L_0x092f:
            b3 r0 = b
            boolean r0 = r0.isChildBerthMandatory()
            if (r0 != 0) goto L_0x0947
            java.lang.Short r0 = r15.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r3 = b
            short r3 = r3.getMaxChildAge()
            if (r0 <= r3) goto L_0x09a3
        L_0x0947:
            java.lang.Boolean r0 = r15.getChildBerthFlag()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0961
            java.lang.Short r0 = r15.getPassengerAge()
            short r0 = r0.shortValue()
            b3 r3 = b
            short r3 = r3.getMinPassengerAge()
            if (r0 < r3) goto L_0x09a3
        L_0x0961:
            b3 r0 = b
            boolean r0 = r0.isFoodChoiceEnabled()
            if (r0 == 0) goto L_0x0983
            b3 r0 = b
            java.util.List r0 = r0.getFoodDetails()
            int r0 = r0.size()
            r3 = 3
            if (r0 == r3) goto L_0x09a3
            b3 r0 = b
            java.util.List r0 = r0.getFoodDetails()
            int r0 = r0.size()
            r3 = 2
            if (r0 == r3) goto L_0x09a3
        L_0x0983:
            java.lang.String r0 = S
            boolean r0 = r0.equalsIgnoreCase(r11)
            if (r0 != 0) goto L_0x09a3
            java.lang.String r0 = P
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x09a3
            boolean r0 = defpackage.C1450w1.e()
            if (r0 == 0) goto L_0x09a0
            java.lang.String r0 = r15.getPsgnConcType()
            if (r0 != 0) goto L_0x09a0
            goto L_0x09a3
        L_0x09a0:
            r7 = r16
            goto L_0x09df
        L_0x09a3:
            java.util.HashMap<java.lang.Short, java.lang.Short> r0 = c
            java.lang.Short r2 = java.lang.Short.valueOf(r5)
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x09d0
            java.util.HashMap<java.lang.Short, java.lang.Short> r0 = c
            java.lang.Short r2 = java.lang.Short.valueOf(r5)
            java.lang.Object r0 = r0.get(r2)
            java.lang.Short r0 = (java.lang.Short) r0
            short r0 = r0.shortValue()
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = c
            java.lang.Short r3 = java.lang.Short.valueOf(r5)
            int r0 = r0 + 1
            short r0 = (short) r0
            java.lang.Short r0 = java.lang.Short.valueOf(r0)
            r2.put(r3, r0)
            goto L_0x09de
        L_0x09d0:
            r0 = 1
            java.util.HashMap<java.lang.Short, java.lang.Short> r2 = c
            java.lang.Short r3 = java.lang.Short.valueOf(r5)
            java.lang.Short r0 = java.lang.Short.valueOf(r0)
            r2.put(r3, r0)
        L_0x09de:
            r7 = 1
        L_0x09df:
            cris.org.in.ima.adaptors.AddPassengerViewHolder r0 = r1.f4908a
            if (r0 != 0) goto L_0x09ee
            r22.J0()
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x09fd
            r22.K0()
            goto L_0x09fd
        L_0x09ee:
            r0.notifyDataSetChanged()
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x09fd
            cris.org.in.ima.adaptors.AddPassengerViewHolder r0 = r1.f4946b
            r0.notifyDataSetChanged()
            goto L_0x09fd
        L_0x09fb:
            r7 = r16
        L_0x09fd:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0a0c
            android.widget.LinearLayout r0 = r1.select_passenger_lap2
            r2 = 0
            r0.setVisibility(r2)
            androidx.recyclerview.widget.RecyclerView r0 = r1.rv_passenger_list_lap2
            r0.setVisibility(r2)
        L_0x0a0c:
            int r5 = r20 + 1
            r2 = r17
            r3 = r18
            goto L_0x000e
        L_0x0a14:
            r19 = r6
            r16 = r7
            r2 = r9
            r0 = 4
            r3 = 2131951928(0x7f130138, float:1.9540284E38)
            r4 = 2131951990(0x7f130176, float:1.954041E38)
            if (r19 == 0) goto L_0x0b17
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r5 = r1.f4978g
            java.util.Iterator r5 = r5.iterator()
        L_0x0a28:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0b0b
            java.lang.Object r6 = r5.next()
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6
            boolean r7 = defpackage.C1450w1.e()
            if (r7 == 0) goto L_0x0a40
            java.lang.Short r7 = r6.getPassengerAge()
            if (r7 == 0) goto L_0x0ae8
        L_0x0a40:
            b3 r7 = f4886a
            boolean r7 = r7.isBedRollFlagEnabled()
            if (r7 != 0) goto L_0x0ae8
            b3 r7 = f4886a
            boolean r7 = r7.isSeniorCitizenApplicable()
            if (r7 == 0) goto L_0x0a6a
            java.lang.String r7 = r6.getPassengerGender()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0a6a
            java.lang.Short r7 = r6.getPassengerAge()
            short r7 = r7.shortValue()
            b3 r9 = f4886a
            short r9 = r9.getSrctznAge()
            if (r7 >= r9) goto L_0x0ae8
        L_0x0a6a:
            java.lang.String r7 = r6.getPassengerGender()
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x0a84
            java.lang.Short r7 = r6.getPassengerAge()
            short r7 = r7.shortValue()
            b3 r9 = f4886a
            short r9 = r9.getSrctnwAge()
            if (r7 >= r9) goto L_0x0ae8
        L_0x0a84:
            b3 r7 = f4886a
            boolean r7 = r7.isChildBerthMandatory()
            if (r7 != 0) goto L_0x0a9c
            java.lang.Short r7 = r6.getPassengerAge()
            short r7 = r7.shortValue()
            b3 r9 = f4886a
            short r9 = r9.getMaxChildAge()
            if (r7 <= r9) goto L_0x0ae8
        L_0x0a9c:
            java.lang.Boolean r7 = r6.getChildBerthFlag()
            if (r7 == 0) goto L_0x0abc
            java.lang.Boolean r7 = r6.getChildBerthFlag()
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0abc
            java.lang.Short r7 = r6.getPassengerAge()
            short r7 = r7.shortValue()
            b3 r9 = f4886a
            short r9 = r9.getMinPassengerAge()
            if (r7 < r9) goto L_0x0ae8
        L_0x0abc:
            b3 r7 = f4886a
            boolean r7 = r7.isFoodChoiceEnabled()
            if (r7 == 0) goto L_0x0acc
            b3 r7 = f4886a
            java.util.List r7 = r7.getFoodDetails()
            if (r7 != 0) goto L_0x0ae8
        L_0x0acc:
            java.lang.String r7 = S
            boolean r7 = r7.equalsIgnoreCase(r11)
            if (r7 != 0) goto L_0x0ae8
            java.lang.String r7 = P
            boolean r7 = r7.equalsIgnoreCase(r2)
            if (r7 != 0) goto L_0x0ae8
            boolean r7 = defpackage.C1450w1.e()
            if (r7 == 0) goto L_0x0a28
            java.lang.String r7 = r6.getPsgnConcType()
            if (r7 != 0) goto L_0x0a28
        L_0x0ae8:
            java.lang.Short r6 = r6.getPassengerSerialNumber()
            short r6 = r6.shortValue()
            if (r6 <= r0) goto L_0x0a28
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r5 = r22.getContext()
            r2.<init>(r5)
            androidx.recyclerview.widget.RecyclerView r5 = r1.passengerList
            r5.setLayoutManager(r2)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r5 = r1.f4978g
            int r5 = r5.size()
            int r5 = r5 + -1
            r2.scrollToPosition(r5)
        L_0x0b0b:
            androidx.fragment.app.FragmentActivity r2 = r22.getActivity()
            java.lang.String r5 = r1.getString(r4)
            r6 = 0
            defpackage.C0709Uj.q(r1, r3, r2, r5, r6)
        L_0x0b17:
            boolean r2 = defpackage.C0535I5.f3647h
            if (r2 == 0) goto L_0x0c0f
            if (r16 == 0) goto L_0x0c0f
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4981h
            java.util.Iterator r2 = r2.iterator()
        L_0x0b23:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0c03
            java.lang.Object r5 = r2.next()
            cris.prs.webservices.dto.PassengerDetailDTO r5 = (cris.prs.webservices.dto.PassengerDetailDTO) r5
            boolean r6 = defpackage.C1450w1.e()
            if (r6 == 0) goto L_0x0b3b
            java.lang.Short r6 = r5.getPassengerAge()
            if (r6 == 0) goto L_0x0be0
        L_0x0b3b:
            b3 r6 = b
            boolean r6 = r6.isBedRollFlagEnabled()
            if (r6 != 0) goto L_0x0be0
            b3 r6 = b
            boolean r6 = r6.isSeniorCitizenApplicable()
            if (r6 == 0) goto L_0x0b65
            java.lang.String r6 = r5.getPassengerGender()
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x0b65
            java.lang.Short r6 = r5.getPassengerAge()
            short r6 = r6.shortValue()
            b3 r7 = b
            short r7 = r7.getSrctznAge()
            if (r6 >= r7) goto L_0x0be0
        L_0x0b65:
            java.lang.String r6 = r5.getPassengerGender()
            boolean r6 = r6.equals(r10)
            if (r6 == 0) goto L_0x0b7f
            java.lang.Short r6 = r5.getPassengerAge()
            short r6 = r6.shortValue()
            b3 r7 = b
            short r7 = r7.getSrctnwAge()
            if (r6 >= r7) goto L_0x0be0
        L_0x0b7f:
            b3 r6 = b
            boolean r6 = r6.isChildBerthMandatory()
            if (r6 != 0) goto L_0x0b97
            java.lang.Short r6 = r5.getPassengerAge()
            short r6 = r6.shortValue()
            b3 r7 = b
            short r7 = r7.getMaxChildAge()
            if (r6 <= r7) goto L_0x0be0
        L_0x0b97:
            java.lang.Boolean r6 = r5.getChildBerthFlag()
            if (r6 == 0) goto L_0x0bb7
            java.lang.Boolean r6 = r5.getChildBerthFlag()
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0bb7
            java.lang.Short r6 = r5.getPassengerAge()
            short r6 = r6.shortValue()
            b3 r7 = b
            short r7 = r7.getMinPassengerAge()
            if (r6 < r7) goto L_0x0be0
        L_0x0bb7:
            b3 r6 = b
            boolean r6 = r6.isFoodChoiceEnabled()
            if (r6 == 0) goto L_0x0bcc
            b3 r6 = b
            java.util.List r6 = r6.getFoodDetails()
            int r6 = r6.size()
            r7 = 3
            if (r6 == r7) goto L_0x0be0
        L_0x0bcc:
            java.lang.String r6 = S
            boolean r6 = r6.equalsIgnoreCase(r11)
            if (r6 != 0) goto L_0x0be0
            boolean r6 = defpackage.C1450w1.e()
            if (r6 == 0) goto L_0x0b23
            java.lang.String r6 = r5.getPsgnConcType()
            if (r6 != 0) goto L_0x0b23
        L_0x0be0:
            java.lang.Short r5 = r5.getPassengerSerialNumber()
            short r5 = r5.shortValue()
            if (r5 <= r0) goto L_0x0b23
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r22.getContext()
            r0.<init>(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r1.rv_passenger_list_lap2
            r2.setLayoutManager(r0)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r2 = r1.f4981h
            int r2 = r2.size()
            int r2 = r2 + -1
            r0.scrollToPosition(r2)
        L_0x0c03:
            androidx.fragment.app.FragmentActivity r0 = r22.getActivity()
            java.lang.String r2 = r1.getString(r4)
            r4 = 0
            defpackage.C0709Uj.q(r1, r3, r0, r2, r4)
        L_0x0c0f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PassengerDetailFragment.r0(java.util.ArrayList):void");
    }

    public final ArrayList<K9> s0() {
        return new ArrayList<>(Arrays.asList(K9.values()));
    }

    @OnFocusChange({2131364034})
    public void streetLaneVerify(View view) {
        if (!this.streetLane.hasFocus()) {
            String d1 = d1(this.streetLane.getText().toString(), "Street/Lane");
            if (d1.equalsIgnoreCase("ok")) {
                G0(3);
                this.f4935a.setStreet(this.streetLane.getText().toString());
                return;
            }
            N0(3, d1);
        }
    }

    public final void v0() {
        if (f4886a.getValidIdCardTypes() != null) {
            this.idCardType.setText(getString(cris.org.in.prs.ima.R.string.Card_type));
            if (C0535I5.f3647h) {
                this.id_card_types_lap2.setText(getString(cris.org.in.prs.ima.R.string.Card_type));
            }
            Iterator<K9> it = this.f5005p.iterator();
            while (it.hasNext()) {
                this.f5007q.add(String.valueOf(it.next().f3678c));
            }
        }
    }

    public final void w0(EditText editText, TextView textView, TextView textView2, TextView textView3, boolean z2) {
        editText.getText().toString();
        String trim = editText.getText().toString().trim();
        if (trim.length() == 6) {
            this.f4903a = ProgressDialog.show(getActivity(), getString(cris.org.in.prs.ima.R.string.validating_Pin_code), getString(cris.org.in.prs.ima.R.string.please_wait_text));
            textView.setText((CharSequence) null);
            if (z2) {
                textView2.setText("City");
            } else {
                textView2.setText("City");
                textView3.setText("Post Office");
            }
            this.f4943a = true;
            this.f4985i = true;
            String f2 = C0657Qt.f();
            String format = String.format("/%s", new Object[]{trim});
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).j(f2 + "pin" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new e0(textView, trim, z2, editText));
        }
    }

    public final void x0(String str, Integer num) {
        Context context = this.f4904a;
        C0535I5.m(context, true, String.format(context.getResources().getString(cris.org.in.prs.ima.R.string.berthCheckErrorMsg), new Object[]{num, str}), getString(cris.org.in.prs.ima.R.string.error), this.f4904a.getString(cris.org.in.prs.ima.R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public final void y0() {
        this.x = "IN";
        this.nationality.setText(getString(cris.org.in.prs.ima.R.string.India));
        if (this.f4941a == null) {
            this.f4941a = C0535I5.f3628b;
        }
        g0(this.nationality.getText().toString());
    }

    public final boolean z0() {
        if (this.addpassenger_rl.getVisibility() != 0 && this.infantLayout.getVisibility() != 0 && this.existingpassenger_ll.getVisibility() != 0 && this.selectstation_ll.getVisibility() != 0 && this.regervationchoice_ll.getVisibility() != 0) {
            return false;
        }
        this.addpassenger_rl.setVisibility(8);
        this.infantLayout.setVisibility(8);
        this.existingpassenger_ll.setVisibility(8);
        this.selectstation_ll.setVisibility(8);
        this.regervationchoice_ll.setVisibility(8);
        return true;
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$k  reason: case insensitive filesystem */
    public class C0954k extends ClickableSpan {
        public C0954k() {
        }

        public final void onClick(View view) {
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (!C0535I5.O((ConnectivityManager) passengerDetailFragment.getActivity().getSystemService("connectivity"), passengerDetailFragment.f4904a)) {
                new Handler().postDelayed(new a(), 5000);
            } else {
                passengerDetailFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.tnc_insurance))));
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }

        /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$k$a */
        public class a implements Runnable {
            public final void run() {
            }
        }
    }

    public class b0 implements Runnable {
        public final void run() {
        }
    }

    public class o0 implements TextWatcher {
        public o0() {
        }

        public final void afterTextChanged(Editable editable) {
            short s;
            PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
            if (lf.e(passengerDetailFragment.passengerAge) != 0) {
                s = C0709Uj.m(passengerDetailFragment.passengerAge);
            } else {
                s = -1;
            }
            if (s == -1) {
                passengerDetailFragment.passengerAge.setError(passengerDetailFragment.getResources().getString(cris.org.in.prs.ima.R.string.blank_age_validation));
                passengerDetailFragment.isChildBerthReq.setChecked(false);
                passengerDetailFragment.isChildBerthReq.setVisibility(8);
                passengerDetailFragment.isChildBerthll.setVisibility(8);
            } else if ((s >= PassengerDetailFragment.p || s >= PassengerDetailFragment.f4886a.getMinPassengerAge()) && s <= PassengerDetailFragment.f4886a.getMaxPassengerAge()) {
                passengerDetailFragment.e0();
                passengerDetailFragment.A0();
            } else {
                passengerDetailFragment.passengerAge.setError(passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.Age_should_between) + PassengerDetailFragment.f4886a.getMinPassengerAge() + passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.to_small) + PassengerDetailFragment.f4886a.getMaxPassengerAge() + "." + passengerDetailFragment.getString(cris.org.in.prs.ima.R.string.in_case_of_child_below_five_year));
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$u  reason: case insensitive filesystem */
    public class C0964u implements TextWatcher {
        public C0964u() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                C0535I5.I(passengerDetailFragment.getActivity());
                passengerDetailFragment.splCardValidity.clearFocus();
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            try {
                int length = charSequence2.length();
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                if (length == 2) {
                    if (Integer.parseInt(charSequence2) >= 1) {
                        if (Integer.parseInt(charSequence2) <= 31) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.splCardValidity.setText(charSequence2);
                            passengerDetailFragment.splCardValidity.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 5) {
                    String substring = charSequence2.substring(3);
                    if (Integer.parseInt(substring) >= 1) {
                        if (Integer.parseInt(substring) <= 12) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.splCardValidity.setText(charSequence2);
                            passengerDetailFragment.splCardValidity.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 10) {
                    passengerDetailFragment.f4897a = new SimpleDateFormat("dd/MM/yyyy").parse(passengerDetailFragment.splCardValidity.getText().toString()).getTime();
                    passengerDetailFragment.f4957c = Calendar.getInstance().getTimeInMillis();
                    passengerDetailFragment.splCardValidity.setSelection(charSequence2.length());
                }
            } catch (NumberFormatException e) {
                TextView textView = PassengerDetailFragment.a;
                e.getMessage();
            } catch (ParseException e2) {
                TextView textView2 = PassengerDetailFragment.a;
                e2.getMessage();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$v  reason: case insensitive filesystem */
    public class C0965v implements TextWatcher {
        public C0965v() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                C0535I5.I(passengerDetailFragment.getActivity());
                passengerDetailFragment.tv_conc_cardvalidity_lap2.clearFocus();
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            try {
                int length = charSequence2.length();
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                if (length == 2) {
                    if (Integer.parseInt(charSequence2) >= 1) {
                        if (Integer.parseInt(charSequence2) <= 31) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.tv_conc_cardvalidity_lap2.setText(charSequence2);
                            passengerDetailFragment.tv_conc_cardvalidity_lap2.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 5) {
                    String substring = charSequence2.substring(3);
                    if (Integer.parseInt(substring) >= 1) {
                        if (Integer.parseInt(substring) <= 12) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.tv_conc_cardvalidity_lap2.setText(charSequence2);
                            passengerDetailFragment.tv_conc_cardvalidity_lap2.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 10) {
                    passengerDetailFragment.f4897a = new SimpleDateFormat("dd/MM/yyyy").parse(passengerDetailFragment.tv_conc_cardvalidity_lap2.getText().toString()).getTime();
                    passengerDetailFragment.f4957c = Calendar.getInstance().getTimeInMillis();
                    passengerDetailFragment.tv_conc_cardvalidity_lap2.setSelection(charSequence2.length());
                }
            } catch (NumberFormatException e) {
                TextView textView = PassengerDetailFragment.a;
                e.getMessage();
            } catch (ParseException e2) {
                TextView textView2 = PassengerDetailFragment.a;
                e2.getMessage();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$w  reason: case insensitive filesystem */
    public class C0966w implements TextWatcher {
        public C0966w() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                C0535I5.I(passengerDetailFragment.f4906a);
                passengerDetailFragment.tv_dob_ft.clearFocus();
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            try {
                int length = charSequence2.length();
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                if (length == 2) {
                    if (Integer.parseInt(charSequence2) >= 1) {
                        if (Integer.parseInt(charSequence2) <= 31) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.tv_dob_ft.setText(charSequence2);
                            passengerDetailFragment.tv_dob_ft.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 5) {
                    String substring = charSequence2.substring(3);
                    if (Integer.parseInt(substring) >= 1) {
                        if (Integer.parseInt(substring) <= 12) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.tv_dob_ft.setText(charSequence2);
                            passengerDetailFragment.tv_dob_ft.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 10) {
                    Date parse = new SimpleDateFormat("dd/MM/yyyy").parse(passengerDetailFragment.tv_dob_ft.getText().toString());
                    if (!passengerDetailFragment.x.equals("IN")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_dob_ft.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    }
                }
            } catch (NumberFormatException e) {
                TextView textView = PassengerDetailFragment.a;
                e.getMessage();
            } catch (ParseException e2) {
                TextView textView2 = PassengerDetailFragment.a;
                e2.getMessage();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$x  reason: case insensitive filesystem */
    public class C0967x implements TextWatcher {
        public C0967x() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                C0535I5.I(passengerDetailFragment.f4906a);
                passengerDetailFragment.splDOB.clearFocus();
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            try {
                int length = charSequence2.length();
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                if (length == 2) {
                    if (Integer.parseInt(charSequence2) >= 1) {
                        if (Integer.parseInt(charSequence2) <= 31) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.splDOB.setText(charSequence2);
                            passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 5) {
                    String substring = charSequence2.substring(3);
                    if (Integer.parseInt(substring) >= 1) {
                        if (Integer.parseInt(substring) <= 12) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.splDOB.setText(charSequence2);
                            passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 10) {
                    Date parse = new SimpleDateFormat("dd/MM/yyyy").parse(passengerDetailFragment.splDOB.getText().toString());
                    passengerDetailFragment.i = C0535I5.f(parse);
                    if (passengerDetailFragment.E.equals("HANDICAP")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("ESCORT")) {
                        passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.getText().toString();
                    } else if (passengerDetailFragment.E.equals("PRESSC")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("PRESCH")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("PRESSS")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("PRESCO")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.splDOB.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (!passengerDetailFragment.x.equals("IN")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_dob_ft.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    }
                }
            } catch (NumberFormatException e) {
                TextView textView = PassengerDetailFragment.a;
                e.getMessage();
            } catch (ParseException e2) {
                TextView textView2 = PassengerDetailFragment.a;
                e2.getMessage();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment$y  reason: case insensitive filesystem */
    public class C0968y implements TextWatcher {
        public C0968y() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                C0535I5.I(passengerDetailFragment.f4906a);
                passengerDetailFragment.tv_conc_dob_lap2.clearFocus();
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            try {
                int length = charSequence2.length();
                PassengerDetailFragment passengerDetailFragment = PassengerDetailFragment.this;
                if (length == 2) {
                    if (Integer.parseInt(charSequence2) >= 1) {
                        if (Integer.parseInt(charSequence2) <= 31) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.tv_conc_dob_lap2.setText(charSequence2);
                            passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 5) {
                    String substring = charSequence2.substring(3);
                    if (Integer.parseInt(substring) >= 1) {
                        if (Integer.parseInt(substring) <= 12) {
                            charSequence2 = charSequence2.concat(RemoteSettings.FORWARD_SLASH_STRING);
                            passengerDetailFragment.tv_conc_dob_lap2.setText(charSequence2);
                            passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        }
                    }
                }
                if (charSequence2.length() == 10) {
                    Date parse = new SimpleDateFormat("dd/MM/yyyy").parse(passengerDetailFragment.tv_conc_dob_lap2.getText().toString());
                    if (passengerDetailFragment.E.equals("HANDICAP")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("ESCORT")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(passengerDetailFragment.passengerAge.getText().toString());
                    } else if (passengerDetailFragment.E.equals("PRESSC")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("PRESCH")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("PRESSS")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (passengerDetailFragment.E.equals("PRESCO")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_conc_dob_lap2.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    } else if (!passengerDetailFragment.x.equals("IN")) {
                        passengerDetailFragment.i = C0535I5.f(parse);
                        passengerDetailFragment.tv_dob_ft.setSelection(charSequence2.length());
                        passengerDetailFragment.passengerAge.setText(String.valueOf(passengerDetailFragment.i));
                    }
                }
            } catch (NumberFormatException e) {
                TextView textView = PassengerDetailFragment.a;
                e.getMessage();
            } catch (ParseException e2) {
                TextView textView2 = PassengerDetailFragment.a;
                e2.getMessage();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
