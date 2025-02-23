package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.logging.type.LogSeverity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import defpackage.C1426uk;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import rx.Subscriber;

public class MasterPassengerNewActivity extends AppCompatActivity {
    public static final /* synthetic */ int d = 0;
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4233a = null;

    /* renamed from: a  reason: collision with other field name */
    public TextWatcher f4234a;

    /* renamed from: a  reason: collision with other field name */
    public C0816cB f4235a;

    /* renamed from: a  reason: collision with other field name */
    public final n f4236a;

    /* renamed from: a  reason: collision with other field name */
    public final o f4237a;

    /* renamed from: a  reason: collision with other field name */
    public final p f4238a;

    /* renamed from: a  reason: collision with other field name */
    public MasterPassengerNewActivity f4239a;

    /* renamed from: a  reason: collision with other field name */
    public GoogleAdParamDTO f4240a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4241a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4242a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, String> f4243a;

    /* renamed from: a  reason: collision with other field name */
    public C1426uk.a f4244a;

    /* renamed from: a  reason: collision with other field name */
    public short f4245a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4246a;
    public long b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<String> f4247b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4248b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4249c;

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<String> f4250c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4251c;
    @BindView(2131362104)
    ImageView calender;
    @BindView(2131362105)
    ImageView calender_carddob_rl;
    @BindView(2131362106)
    ImageView calendervaliddate;
    @BindView(2131362136)
    View cardBorder;
    @BindView(2131362135)
    EditText cardNumber;
    @BindView(2131364348)
    EditText conc_cardvalidity;
    @BindView(2131364350)
    EditText conc_dob;
    @BindView(2131362281)
    RelativeLayout conc_dob_rl;

    /* renamed from: d  reason: collision with other field name */
    public final String f4252d;

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList<String> f4253d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f4254d;
    @BindView(2131362381)
    TextView delete;
    @BindView(2131364372)
    RadioButton divyaang_pasg;
    public String e;

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<I9> f4255e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f4256e;
    @BindView(2131362513)
    EditText et_aadhar_vid;
    public String f;

    /* renamed from: f  reason: collision with other field name */
    public ArrayList<K9> f4257f;
    public String g;

    /* renamed from: g  reason: collision with other field name */
    public ArrayList<String> f4258g;
    @BindView(2131362733)
    LinearLayout govt_card_ll;
    public String h;

    /* renamed from: h  reason: collision with other field name */
    public final ArrayList<String> f4259h;
    public String i;

    /* renamed from: i  reason: collision with other field name */
    public ArrayList<Integer> f4260i;
    @BindView(2131362805)
    LinearLayout id_card_number11;
    @BindView(2131364448)
    RadioButton journalist_pasg;
    @BindView(2131363047)
    RadioGroup llPassengerGender;
    @BindView(2131363066)
    LinearLayout llSrctznConcession;
    @BindView(2131363022)
    RadioGroup ll_divyaang_fecility;
    @BindView(2131363298)
    TextView nationality;
    @BindView(2131363300)
    LinearLayout nationality_ll;
    @BindView(2131363301)
    RelativeLayout nationality_rl;
    @BindView(2131364508)
    RadioButton normal_pasg;
    @BindView(2131363454)
    EditText passengerDob;
    @BindView(2131363458)
    EditText passengerName;
    @BindView(2131363455)
    RelativeLayout passenger_dob_rl;
    @BindView(2131363806)
    RelativeLayout rvBerthPref;
    @BindView(2131363808)
    RelativeLayout rvCardType;
    @BindView(2131363816)
    RelativeLayout rvFoodPref;
    @BindView(2131363835)
    RelativeLayout rvSrctznConcession;
    @BindView(2131363982)
    EditText spc_card_number;
    @BindView(2131363985)
    LinearLayout spc_concession_ll;
    @BindView(2131363987)
    TextView specialConcesionType;
    @BindView(2131363989)
    RelativeLayout special_concession_rl;
    @BindView(2131364037)
    TextView submit;
    @BindView(2131364431)
    TextView titleName;
    @BindView(2131364314)
    TextView tvBerthPreference;
    @BindView(2131364329)
    TextView tvCardType;
    @BindView(2131364405)
    RadioButton tvFemale;
    @BindView(2131364412)
    TextView tvFoodPref;
    @BindView(2131364475)
    RadioButton tvMale;
    @BindView(2131364612)
    TextView tvSrctznConcession;
    @BindView(2131364695)
    RadioButton tvTransgender;
    @BindView(2131364435)
    TextView tv_info_msg;
    @BindView(2131364804)
    RelativeLayout valid_carddate_rl;

    public class a implements OnSelectionListener {
        public a() {
        }

        public final void onClick(String str) {
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.tvSrctznConcession.setText(str);
            masterPassengerNewActivity.f4241a.dismiss();
            int V = xx.V(xx.f(str));
            masterPassengerNewActivity.c = V;
            if (V == 1) {
                C0535I5.o(masterPassengerNewActivity, masterPassengerNewActivity.getString(R.string.avail_conc_msgs), "OK", (DialogInterface.OnClickListener) null).show();
            } else if (V == 2) {
                C0535I5.o(masterPassengerNewActivity, masterPassengerNewActivity.getString(R.string.forgo_conce_msgs), "OK", (DialogInterface.OnClickListener) null).show();
            } else if (V == 3) {
                C0535I5.o(masterPassengerNewActivity, masterPassengerNewActivity.getString(R.string.forgo_full_conc_msgs), "OK", (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class b implements OnSelectionListener {
        public b() {
        }

        public final void onClick(String str) {
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.specialConcesionType.setText(str);
            masterPassengerNewActivity.f4241a.dismiss();
            String p = xx.p(xx.i(str));
            masterPassengerNewActivity.i = p;
            if (p.equals("ESCORT")) {
                masterPassengerNewActivity.id_card_number11.setVisibility(0);
                masterPassengerNewActivity.et_aadhar_vid.setVisibility(8);
                masterPassengerNewActivity.conc_dob_rl.setVisibility(0);
            } else {
                masterPassengerNewActivity.id_card_number11.setVisibility(8);
                masterPassengerNewActivity.cardNumber.setVisibility(8);
            }
            if (masterPassengerNewActivity.i.equals("PRESSC") || masterPassengerNewActivity.i.equals("PRESSS") || masterPassengerNewActivity.i.equals("PRESCO") || masterPassengerNewActivity.i.equals("PRESCH")) {
                masterPassengerNewActivity.conc_dob_rl.setVisibility(8);
                masterPassengerNewActivity.cardNumber.setVisibility(8);
                masterPassengerNewActivity.et_aadhar_vid.setVisibility(0);
            } else {
                masterPassengerNewActivity.conc_dob_rl.setVisibility(0);
            }
            if (masterPassengerNewActivity.i.equals("HANDICAP")) {
                masterPassengerNewActivity.conc_dob_rl.setVisibility(8);
                masterPassengerNewActivity.et_aadhar_vid.setVisibility(0);
            }
            masterPassengerNewActivity.specialConcesionType.setText(str);
        }
    }

    public class c implements OnSelectionListener {
        public c() {
        }

        public final void onClick(String str) {
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.f4241a.dismiss();
            masterPassengerNewActivity.nationality.setText(str);
            HashMap<String, String> hashMap = masterPassengerNewActivity.f4243a;
            if (hashMap == null) {
                masterPassengerNewActivity.nationality.setError("Select Nationality");
            } else if (hashMap.get(str).equals("Show all")) {
                masterPassengerNewActivity.nationality.setText(R.string.select_Nationality);
                masterPassengerNewActivity.nationality.setError((CharSequence) null);
                C0535I5.b0(masterPassengerNewActivity.f4239a);
                masterPassengerNewActivity.nationality.setText(R.string.select_Nationality);
            } else if (Integer.valueOf(masterPassengerNewActivity.f4243a.get(str)).intValue() != 94 && Integer.valueOf(masterPassengerNewActivity.f4243a.get(str)).intValue() >= 1) {
                masterPassengerNewActivity.nationality.setError((CharSequence) null);
                C0535I5.m(masterPassengerNewActivity, false, "International user registration facility is available on IRCTC website www.irctc.co.in only.", masterPassengerNewActivity.getString(R.string.error), masterPassengerNewActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class d implements OnSelectionListener {
        public d() {
        }

        public final void onClick(String str) {
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.tvFoodPref.setText(str);
            masterPassengerNewActivity.f4241a.dismiss();
            String.valueOf(J9.j(str).f3664a);
            masterPassengerNewActivity.getClass();
        }
    }

    public class e implements OnSelectionListener {
        public e() {
        }

        public final void onClick(String str) {
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.tvBerthPreference.setText(str);
            masterPassengerNewActivity.f4241a.dismiss();
            I9.i(str).a();
            masterPassengerNewActivity.getClass();
        }
    }

    public class f implements OnSelectionListener {
        public f() {
        }

        public final void onClick(String str) {
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.tvCardType.setText(str);
            masterPassengerNewActivity.f4241a.dismiss();
            K9 i = K9.i(str);
            K9 k9 = K9.NULL_IDCARD;
            if (k9.f3678c.compareToIgnoreCase(masterPassengerNewActivity.tvCardType.getText().toString()) == 0) {
                masterPassengerNewActivity.rvCardType.setVisibility(8);
                masterPassengerNewActivity.cardNumber.setVisibility(8);
                masterPassengerNewActivity.cardBorder.setVisibility(8);
            } else {
                masterPassengerNewActivity.rvCardType.setVisibility(0);
                masterPassengerNewActivity.cardNumber.setVisibility(0);
                masterPassengerNewActivity.cardBorder.setVisibility(0);
            }
            if (!masterPassengerNewActivity.e.equals(String.valueOf(i.f3678c))) {
                masterPassengerNewActivity.e = String.valueOf(i.f3678c);
                if (i.f3678c == K9.UNIQUE_ICARD.f3678c) {
                    masterPassengerNewActivity.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
                    masterPassengerNewActivity.cardNumber.setInputType(18);
                    EditText editText = masterPassengerNewActivity.cardNumber;
                    editText.setOnTouchListener(new y(masterPassengerNewActivity, editText));
                    masterPassengerNewActivity.cardNumber.setText((CharSequence) null);
                    TextWatcher textWatcher = masterPassengerNewActivity.f4234a;
                    if (textWatcher != null) {
                        masterPassengerNewActivity.cardNumber.removeTextChangedListener(textWatcher);
                    }
                    AlertDialog alertDialog = C0535I5.f3619a;
                    C0479D5 d5 = new C0479D5(masterPassengerNewActivity, 12);
                    masterPassengerNewActivity.f4234a = d5;
                    masterPassengerNewActivity.cardNumber.addTextChangedListener(d5);
                    masterPassengerNewActivity.cardNumber.setInputType(18);
                    masterPassengerNewActivity.cardNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                } else if (k9.f3678c.compareToIgnoreCase(masterPassengerNewActivity.tvCardType.getText().toString()) == 0) {
                    masterPassengerNewActivity.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    masterPassengerNewActivity.e = "NC";
                    masterPassengerNewActivity.cardNumber.setText((CharSequence) null);
                } else {
                    masterPassengerNewActivity.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    masterPassengerNewActivity.cardNumber.setText((CharSequence) null);
                    TextWatcher textWatcher2 = masterPassengerNewActivity.f4234a;
                    if (textWatcher2 != null) {
                        masterPassengerNewActivity.cardNumber.removeTextChangedListener(textWatcher2);
                    }
                    AlertDialog alertDialog2 = C0535I5.f3619a;
                    C0479D5 d52 = new C0479D5(masterPassengerNewActivity, 16);
                    masterPassengerNewActivity.f4234a = d52;
                    masterPassengerNewActivity.cardNumber.addTextChangedListener(d52);
                    masterPassengerNewActivity.cardNumber.setInputType(1);
                    masterPassengerNewActivity.cardNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16), new InputFilter.AllCaps()});
                }
            }
        }
    }

    public class h extends Subscriber<StatusDTO> {

        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                MasterPassengerNewActivity.this.f4251c = false;
            }
        }

        public h() {
        }

        public final void onCompleted() {
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.f4233a.dismiss();
            if (masterPassengerNewActivity.f4235a == null) {
                masterPassengerNewActivity.f4235a = new C0816cB(new a(), 5000);
            }
            masterPassengerNewActivity.f4235a.a();
            int i = MasterPassengerNewActivity.d;
        }

        public final void onError(Throwable th) {
            int i = MasterPassengerNewActivity.d;
            th.getClass();
            th.getMessage();
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            masterPassengerNewActivity.f4233a.dismiss();
            masterPassengerNewActivity.f4251c = false;
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            String next;
            String str;
            String str2;
            StatusDTO statusDTO = (StatusDTO) obj;
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            if (statusDTO != null) {
                C0657Qt.h();
                try {
                    if (statusDTO.getErrorList() != null) {
                        Iterator<String> it = statusDTO.getErrorList().iterator();
                        String str3 = "";
                        while (true) {
                            if (!it.hasNext() || (next = it.next()) == null) {
                                break;
                            } else if (next.trim().equals("")) {
                                break;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                if (str3.length() <= 1 || str3.charAt(0) == '*') {
                                    str = "";
                                } else {
                                    str = "* ";
                                }
                                sb.append(str);
                                sb.append(str3);
                                if (str3.length() > 1) {
                                    str2 = "\n* ";
                                } else {
                                    str2 = "";
                                }
                                sb.append(str2);
                                sb.append(next);
                                str3 = sb.toString();
                            }
                        }
                        masterPassengerNewActivity.f4233a.dismiss();
                        C0535I5.p(masterPassengerNewActivity.f4239a, false, str3, masterPassengerNewActivity.getString(R.string.error), masterPassengerNewActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                        masterPassengerNewActivity.f4251c = false;
                    } else if (statusDTO.getError() == null || statusDTO.getError().equals("")) {
                        masterPassengerNewActivity.f4233a.dismiss();
                        C0535I5.f3632c.clear();
                        C0535I5.p(masterPassengerNewActivity.f4239a, false, statusDTO.getStatus(), masterPassengerNewActivity.getString(R.string.confirmation), masterPassengerNewActivity.getString(R.string.OK), new z(this), (String) null, (DialogInterface.OnClickListener) null).show();
                    } else {
                        masterPassengerNewActivity.f4233a.dismiss();
                        C0535I5.m(masterPassengerNewActivity.f4239a, false, statusDTO.getError(), masterPassengerNewActivity.getString(R.string.error), masterPassengerNewActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        masterPassengerNewActivity.f4251c = false;
                    }
                } catch (Exception e) {
                    int i = MasterPassengerNewActivity.d;
                    e.getMessage();
                    masterPassengerNewActivity.f4233a.dismiss();
                    C0535I5.m(masterPassengerNewActivity.f4239a, false, masterPassengerNewActivity.getString(R.string.unable_process_message), masterPassengerNewActivity.getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                }
            } else {
                masterPassengerNewActivity.f4233a.dismiss();
                C0535I5.m(masterPassengerNewActivity.f4239a, false, masterPassengerNewActivity.getString(R.string.unable_process_message), masterPassengerNewActivity.getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                masterPassengerNewActivity.f4251c = false;
            }
        }
    }

    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1426uk.a f4261a;

        public i(C1426uk.a aVar) {
            this.f4261a = aVar;
        }

        public final void onClick(View view) {
            String l = this.f4261a.getMasterListId().toString();
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            if (!C0535I5.O((ConnectivityManager) masterPassengerNewActivity.f4239a.getSystemService("connectivity"), masterPassengerNewActivity.f4239a)) {
                new Handler().postDelayed(new C1443vk(), 5000);
            } else if (l != null && !l.equals("")) {
                C0793b1 b1Var = C0793b1.a;
                if (b1Var.f3912a != null) {
                    masterPassengerNewActivity.f4233a = ProgressDialog.show(masterPassengerNewActivity.f4239a, masterPassengerNewActivity.getString(R.string.deleting_passenger), masterPassengerNewActivity.getString(R.string.please_wait_text));
                    Objects.toString(b1Var.f3912a);
                    String f = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{l});
                    ((Om) C0657Qt.c(b1Var.f3912a)).v(f + "masterpsgnlistdelete" + format).c(C1181iv.a()).a(E0.a()).b(new C1479xk(masterPassengerNewActivity));
                }
            }
        }
    }

    public class j implements View.OnFocusChangeListener {
        public j() {
        }

        public final void onFocusChange(View view, boolean z) {
            String str;
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            if (!z) {
                String obj = masterPassengerNewActivity.passengerName.getText().toString();
                if (obj == null || obj.equals("") || !obj.matches("^[A-Za-z\\s]+$")) {
                    str = masterPassengerNewActivity.getString(R.string.invalid_Name);
                } else {
                    str = "ok";
                }
                if (obj != null) {
                    if (obj.length() < 3) {
                        str = "At least 3 characters required for Passenger Name.";
                    } else if (obj.length() > 60) {
                        str = "At most 60 characters required for Passenger Name ";
                    }
                }
                String str2 = str;
                if (!str2.equalsIgnoreCase("ok")) {
                    MasterPassengerNewActivity masterPassengerNewActivity2 = MasterPassengerNewActivity.this;
                    C0535I5.m(masterPassengerNewActivity2, false, str2, masterPassengerNewActivity2.getString(R.string.error), masterPassengerNewActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
                EditText editText = masterPassengerNewActivity.passengerName;
                editText.setText(editText.getText().toString().replaceAll("\\s+", " ").trim());
            } else if (masterPassengerNewActivity.f4246a) {
                C0535I5.I(masterPassengerNewActivity);
            }
        }
    }

    public class k implements View.OnClickListener {

        public class a implements DatePickerDialog.OnDateSetListener {
            public a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                int i4 = MasterPassengerNewActivity.d;
                k kVar = k.this;
                EditText editText = MasterPassengerNewActivity.this.conc_cardvalidity;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i5 = i2 + 1;
                if (i5 > 9) {
                    obj2 = Integer.valueOf(i5);
                } else {
                    obj2 = lf.h("0", i5);
                }
                sb.append(obj2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(i);
                editText.setText(sb);
                MasterPassengerNewActivity.this.conc_cardvalidity.getText().toString();
                MasterPassengerNewActivity.this.conc_cardvalidity.setError((CharSequence) null);
            }
        }

        public k() {
        }

        public final void onClick(View view) {
            int i = MasterPassengerNewActivity.d;
            Calendar instance = Calendar.getInstance();
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(masterPassengerNewActivity.f4239a, new a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance2.add(1, 120);
            datePickerDialog.getDatePicker().setMinDate(instance3.getTimeInMillis() - 1000);
            datePickerDialog.setTitle(masterPassengerNewActivity.getString(R.string.Select_Expiry_Date));
            datePickerDialog.show();
        }
    }

    public class l implements View.OnClickListener {

        public class a implements DatePickerDialog.OnDateSetListener {
            public a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                int i4 = MasterPassengerNewActivity.d;
                l lVar = l.this;
                EditText editText = MasterPassengerNewActivity.this.conc_dob;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                int i5 = i2 + 1;
                if (i5 > 9) {
                    obj2 = Integer.valueOf(i5);
                } else {
                    obj2 = lf.h("0", i5);
                }
                sb.append(obj2);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(i);
                editText.setText(sb);
                MasterPassengerNewActivity.this.conc_dob.getText().toString();
                MasterPassengerNewActivity.this.conc_dob.setError((CharSequence) null);
                MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
                EditText editText2 = masterPassengerNewActivity.passengerDob;
                masterPassengerNewActivity.getClass();
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                int i6 = gregorianCalendar.get(1);
                int i7 = gregorianCalendar.get(2);
                int i8 = gregorianCalendar.get(5);
                gregorianCalendar.set(i, i2, i3);
                int i9 = i6 - gregorianCalendar.get(1);
                if (i7 < gregorianCalendar.get(2) || (i7 == gregorianCalendar.get(2) && i8 < gregorianCalendar.get(5))) {
                    i9--;
                }
                if (i9 >= 0) {
                    editText2.setText(String.valueOf(i9));
                    return;
                }
                throw new IllegalArgumentException("Age < 0");
            }
        }

        public l() {
        }

        public final void onClick(View view) {
            int i = MasterPassengerNewActivity.d;
            Calendar instance = Calendar.getInstance();
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(masterPassengerNewActivity.f4239a, new a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance2.add(1, -1);
            instance3.add(1, -143);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
            datePickerDialog.setTitle(masterPassengerNewActivity.getString(R.string.Select_Date_of_Birth));
            datePickerDialog.show();
        }
    }

    public class m implements DatePickerDialog.OnDateSetListener {
        public m() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = MasterPassengerNewActivity.d;
            MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
            EditText editText = masterPassengerNewActivity.passengerDob;
            StringBuilder sb = new StringBuilder();
            if (i3 > 9) {
                obj = Integer.valueOf(i3);
            } else {
                obj = lf.h("0", i3);
            }
            sb.append(obj);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            int i5 = i2 + 1;
            if (i5 > 9) {
                obj2 = Integer.valueOf(i5);
            } else {
                obj2 = lf.h("0", i5);
            }
            sb.append(obj2);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(i);
            editText.setText(sb);
            masterPassengerNewActivity.passengerDob.getText().toString();
            masterPassengerNewActivity.passengerDob.setError((CharSequence) null);
            try {
                masterPassengerNewActivity.f4245a = (short) (Math.round((float) Long.valueOf((new Date().getTime() / 1000) - (new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(masterPassengerNewActivity.passengerDob.getText().toString()).getTime() / 1000)).longValue()) / 31536000);
                masterPassengerNewActivity.n();
            } catch (ParseException e) {
                int i6 = MasterPassengerNewActivity.d;
                e.getMessage();
            }
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public final void run() {
            MasterPassengerNewActivity.this.f4248b = true;
        }
    }

    static {
        C1354qp.R(MasterPassengerNewActivity.class);
    }

    public MasterPassengerNewActivity() {
        new ArrayList();
        this.f4247b = new ArrayList<>();
        this.f4250c = new ArrayList<>();
        this.f4253d = new ArrayList<>();
        this.f4246a = false;
        this.f4245a = 0;
        this.f4249c = "";
        this.f4248b = true;
        this.f4252d = "IN";
        this.c = 0;
        this.e = "NC";
        this.f = "";
        this.f4234a = null;
        this.f4251c = false;
        this.f4254d = false;
        this.f4256e = false;
        this.g = null;
        this.f4243a = new HashMap<>();
        this.f4258g = new ArrayList<>();
        this.f4259h = new ArrayList<>();
        new ArrayList();
        this.h = C0515Ga.AVLBLTY_ONLY;
        this.f4260i = null;
        this.i = "";
        this.f4236a = new n();
        this.f4237a = new o();
        this.f4238a = new p();
    }

    @OnClick({2131362104})
    public void dobCalender() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new m(), instance.get(1), instance.get(2), instance.get(5));
        Calendar instance2 = Calendar.getInstance();
        Calendar instance3 = Calendar.getInstance();
        instance2.add(1, -1);
        instance3.add(1, -143);
        datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
        datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
        datePickerDialog.setTitle(getString(R.string.Select_Date_of_Birth));
        datePickerDialog.show();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ba, code lost:
        if (defpackage.C1488xu.k(r1) != false) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0100  */
    @butterknife.OnFocusChange({2131363808})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void idCardValidate(android.view.View r6) {
        /*
            r5 = this;
            android.widget.EditText r6 = r5.cardNumber
            boolean r6 = r6.hasFocus()
            if (r6 == 0) goto L_0x0009
            return
        L_0x0009:
            boolean r6 = r5.f4256e
            if (r6 == 0) goto L_0x0035
            android.widget.EditText r6 = r5.cardNumber
            java.lang.String r6 = defpackage.xx.B(r6)
            java.lang.String r0 = r5.g
            java.lang.String r0 = r0.trim()
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 != 0) goto L_0x010c
            android.widget.EditText r6 = r5.cardNumber
            java.lang.String r6 = defpackage.xx.B(r6)
            java.lang.String r0 = r5.g
            java.lang.String r0 = r0.trim()
            java.lang.String r0 = defpackage.C0535I5.c0(r0)
            boolean r6 = r6.equalsIgnoreCase(r0)
            if (r6 != 0) goto L_0x010c
        L_0x0035:
            uk$a r6 = new uk$a
            r6.<init>()
            android.widget.TextView r0 = r5.tvCardType
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            K9 r1 = defpackage.K9.NULL_IDCARD
            java.lang.String r1 = r1.f3678c
            int r1 = r0.compareToIgnoreCase(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0052
            r0 = 0
            r1 = r2
            goto L_0x0062
        L_0x0052:
            K9 r0 = defpackage.K9.i(r0)
            int r0 = r0.c
            android.widget.EditText r1 = r5.cardNumber
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
        L_0x0062:
            android.widget.TextView r3 = r5.tvCardType
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r4 = 2131953676(0x7f13080c, float:1.954383E38)
            java.lang.String r4 = r5.getString(r4)
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 != 0) goto L_0x009e
            android.widget.TextView r2 = r5.tvCardType
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            K9 r2 = defpackage.K9.i(r2)
            int r2 = r2.c
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.setIdCardType(r2)
            android.widget.EditText r2 = r5.cardNumber
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r6.setIdCardNumber(r2)
            goto L_0x00a1
        L_0x009e:
            r6.setIdCardType(r2)
        L_0x00a1:
            java.lang.String r6 = "ok"
            if (r0 == 0) goto L_0x00f4
            r2 = 9
            if (r0 != r2) goto L_0x00ca
            r0 = 2131952937(0x7f130529, float:1.954233E38)
            if (r1 == 0) goto L_0x00bc
            int r2 = r1.length()     // Catch:{ Exception -> 0x00c1 }
            r3 = 12
            if (r2 != r3) goto L_0x00bc
            boolean r1 = defpackage.C1488xu.k(r1)     // Catch:{ Exception -> 0x00c1 }
            if (r1 != 0) goto L_0x00f4
        L_0x00bc:
            java.lang.String r0 = r5.getString(r0)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00f5
        L_0x00c1:
            r1 = move-exception
            r1.getMessage()     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00f5
        L_0x00ca:
            r2 = 99
            if (r0 != r2) goto L_0x00cf
            goto L_0x00f4
        L_0x00cf:
            if (r1 == 0) goto L_0x00e8
            java.lang.String r0 = ""
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x00f0 }
            if (r0 != 0) goto L_0x00e8
            int r0 = r1.length()     // Catch:{ Exception -> 0x00f0 }
            r2 = 4
            if (r0 < r2) goto L_0x00e8
            int r0 = r1.length()     // Catch:{ Exception -> 0x00f0 }
            r1 = 16
            if (r0 <= r1) goto L_0x00f4
        L_0x00e8:
            r0 = 2131952942(0x7f13052e, float:1.954234E38)
            java.lang.String r0 = r5.getString(r0)     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00f5
        L_0x00f0:
            r0 = move-exception
            r0.getMessage()
        L_0x00f4:
            r0 = r6
        L_0x00f5:
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0100
            r6 = 2
            r5.p(r6)
            goto L_0x010c
        L_0x0100:
            android.widget.EditText r6 = r5.cardNumber
            r6.setError(r0)
            android.widget.EditText r6 = r5.cardNumber
            r0 = -65536(0xffffffffffff0000, float:NaN)
            r6.setTextColor(r0)
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.MasterPassengerNewActivity.idCardValidate(android.view.View):void");
    }

    public final void l(C1426uk.a aVar) {
        String str;
        this.delete.setOnClickListener(new i(aVar));
        this.delete.setVisibility(8);
        ArrayList<I9> arrayList = new ArrayList<>();
        arrayList.add(I9.l);
        arrayList.add(I9.a);
        arrayList.add(I9.b);
        arrayList.add(I9.c);
        arrayList.add(I9.d);
        arrayList.add(I9.k);
        arrayList.add(I9.e);
        arrayList.add(I9.f);
        arrayList.add(I9.h);
        arrayList.add(I9.i);
        this.f4255e = arrayList;
        this.f4257f = new ArrayList<>(Arrays.asList(K9.values()));
        if (this.f4254d) {
            GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
            this.f4240a = googleAdParamDTO;
            googleAdParamDTO.setAge(C1450w1.f7009a);
            this.f4240a.setGender(C1450w1.f7021c);
            this.titleName.setText(getResources().getString(R.string.edit_passenger));
            this.submit.setText(getString(R.string.Update));
            if (aVar.getIdCardType().trim().equals("")) {
                this.cardNumber.setVisibility(8);
            }
        } else {
            this.titleName.setText(getResources().getString(R.string.add_passenger_details));
            this.submit.setText(getString(R.string.add_Passenger));
        }
        ArrayList<String> arrayList2 = this.f4247b;
        arrayList2.clear();
        this.tvBerthPreference.setText(getString(R.string.Select_Berth_Preference));
        Iterator<I9> it = this.f4255e.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().a());
        }
        ArrayList<String> arrayList3 = this.f4250c;
        arrayList3.clear();
        this.tvCardType.setText(getString(R.string.select_IDCard_type));
        Iterator<K9> it2 = this.f4257f.iterator();
        while (it2.hasNext()) {
            arrayList3.add(String.valueOf(it2.next().f3678c));
        }
        ArrayList<String> arrayList4 = this.f4242a;
        arrayList4.clear();
        Iterator it3 = new ArrayList(Arrays.asList(J9.values())).iterator();
        while (it3.hasNext()) {
            arrayList4.add(((J9) it3.next()).f());
        }
        this.tvFoodPref.setText(R.string.catering_service_option);
        ArrayList<String> arrayList5 = this.f4253d;
        arrayList5.clear();
        this.tvSrctznConcession.setText(getString(R.string.Option_Senior_Citizen_Concession));
        for (String f2 : getResources().getStringArray(R.array.srctzn_conc)) {
            arrayList5.add(xx.a(xx.f(f2)));
        }
        this.passengerName.setOnFocusChangeListener(new j());
        this.calendervaliddate.setOnClickListener(new k());
        this.calender_carddob_rl.setOnClickListener(new l());
        if (this.f4254d && aVar != null) {
            this.ll_divyaang_fecility.setBackgroundColor(getResources().getColor(R.color.sr_ctzn_msg));
            this.spc_concession_ll.setBackgroundColor(getResources().getColor(R.color.sr_ctzn_msg));
            this.f = String.valueOf(aVar.getMasterListId());
            this.passengerName.setText(aVar.getMasterPassengerName());
            if (aVar.getDateOfBirth() != null) {
                this.f4245a = aVar.getAge();
                try {
                    this.passengerDob.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(aVar.getDateOfBirth()));
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
            this.f4249c = aVar.getGender();
            if (aVar.getGender().equalsIgnoreCase("M")) {
                o("M");
            } else if (aVar.getGender().equalsIgnoreCase("F")) {
                o("F");
            } else if (aVar.getGender().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                o(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            }
            if (aVar.getIdCardType() != null && !aVar.getIdCardType().trim().equals("")) {
                this.e = K9.a(aVar.getIdCardType()).f3678c;
                this.tvCardType.setText(K9.a(aVar.getIdCardType()).f3678c);
                this.cardNumber.setVisibility(0);
                String name = K9.a(aVar.getIdCardType()).name();
                if ((name.equalsIgnoreCase("Aadhaar ID") || name.equalsIgnoreCase("UNIQUE_ICARD")) && aVar.getIdCardNumber() != null && !aVar.getIdCardNumber().trim().equalsIgnoreCase("")) {
                    this.f4256e = true;
                    String idCardNumber = aVar.getIdCardNumber();
                    this.g = idCardNumber;
                    this.cardNumber.setText(idCardNumber);
                    this.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
                    this.cardNumber.setInputType(18);
                    EditText editText = this.cardNumber;
                    editText.setOnTouchListener(new y(this, editText));
                } else {
                    this.cardNumber.setText(aVar.getIdCardNumber());
                }
                if (K9.i(this.e).f3678c == K9.UNIQUE_ICARD.f3678c) {
                    TextWatcher textWatcher = this.f4234a;
                    if (textWatcher != null) {
                        this.cardNumber.removeTextChangedListener(textWatcher);
                    }
                    AlertDialog alertDialog = C0535I5.f3619a;
                    C0479D5 d5 = new C0479D5(this, 12);
                    this.f4234a = d5;
                    this.cardNumber.addTextChangedListener(d5);
                    this.cardNumber.setInputType(18);
                    this.cardNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
                } else {
                    TextWatcher textWatcher2 = this.f4234a;
                    if (textWatcher2 != null) {
                        this.cardNumber.removeTextChangedListener(textWatcher2);
                    }
                    AlertDialog alertDialog2 = C0535I5.f3619a;
                    C0479D5 d52 = new C0479D5(this, 16);
                    this.f4234a = d52;
                    this.cardNumber.addTextChangedListener(d52);
                    this.cardNumber.setInputType(1);
                    this.cardNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16), new InputFilter.AllCaps()});
                }
            }
            if (aVar.getBerthPreference() != null && !aVar.getBerthPreference().trim().equals("")) {
                this.tvBerthPreference.setText(I9.j(aVar.getBerthPreference()).a());
            }
            if (aVar.getFoodPreference() != null && !aVar.getFoodPreference().trim().equals("")) {
                TextView textView = this.tvFoodPref;
                String foodPreference = aVar.getFoodPreference();
                J9[] values = J9.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str = "";
                        break;
                    }
                    J9 j9 = values[i2];
                    if (j9.name().equalsIgnoreCase(foodPreference)) {
                        str = j9.f();
                        break;
                    }
                    i2++;
                }
                textView.setText(str);
            }
            String userType = aVar.getUserType();
            this.h = userType;
            if (userType == null) {
                this.h = C0515Ga.AVLBLTY_ONLY;
                this.normal_pasg.setChecked(true);
                this.divyaang_pasg.setChecked(false);
                this.journalist_pasg.setChecked(false);
                this.journalist_pasg.setClickable(false);
                this.divyaang_pasg.setClickable(false);
                this.et_aadhar_vid.setVisibility(8);
            }
            if (this.h.equals(C0515Ga.AVLBLTY_ONLY)) {
                if (aVar.getSrCtznConc() != null) {
                    this.tvSrctznConcession.setText(xx.a(xx.j(C1058d.o(C1058d.g(aVar.getSrCtznConc())))));
                }
            } else if (this.h.equals(C0515Ga.FARE_ONLY)) {
                this.normal_pasg.setChecked(false);
                this.normal_pasg.setClickable(false);
                this.divyaang_pasg.setChecked(true);
                this.divyaang_pasg.performClick();
                this.journalist_pasg.setChecked(false);
                this.journalist_pasg.setClickable(false);
                t();
                this.llSrctznConcession.setVisibility(8);
                this.spc_concession_ll.setVisibility(0);
                this.spc_card_number.setVisibility(0);
                this.tv_info_msg.setVisibility(0);
                this.conc_dob_rl.setVisibility(0);
                this.valid_carddate_rl.setVisibility(0);
                this.nationality_ll.setVisibility(8);
                this.id_card_number11.setVisibility(8);
                if (aVar.getIdCardType() == null || aVar.getIdCardType().trim().equals("") || aVar.getSrCtznConc().equalsIgnoreCase("HANDICAP")) {
                    this.cardNumber.setVisibility(8);
                } else {
                    this.cardNumber.setVisibility(0);
                }
                this.spc_card_number.setText(aVar.getRailwayIsuedCardNo());
                if (this.f4256e) {
                    this.cardNumber.setText(C0535I5.c0(this.g));
                } else {
                    this.cardNumber.setText(aVar.getIdCardNumber());
                }
                this.special_concession_rl.setFocusableInTouchMode(false);
                this.special_concession_rl.setFocusable(false);
                this.special_concession_rl.setClickable(false);
                if (aVar.getDateValid() != null) {
                    try {
                        this.conc_cardvalidity.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(aVar.getDateValid()));
                    } catch (Exception e3) {
                        e3.getMessage();
                    }
                }
                this.specialConcesionType.setText(xx.t(xx.g(aVar.getSrCtznConc())));
                if (xx.t(xx.g(aVar.getSrCtznConc())).equalsIgnoreCase("Escort")) {
                    this.id_card_number11.setVisibility(0);
                    if (aVar.getIdCardType().equals(" ")) {
                        this.tvCardType.setText(aVar.getIdCardType().replace(" ", ""));
                    } else {
                        this.tvCardType.setText(K9.a(aVar.getIdCardType()).f3678c);
                    }
                    this.et_aadhar_vid.setVisibility(8);
                } else {
                    this.et_aadhar_vid.setVisibility(0);
                    if (this.f4256e) {
                        this.et_aadhar_vid.setText(C0535I5.c0(this.g));
                    } else {
                        this.et_aadhar_vid.setText(aVar.getIdCardNumber().toString().replace(" ", ""));
                    }
                }
                aVar.setValidDate(aVar.getValidDate());
                aVar.setRailwayIsuedCardNo(aVar.getRailwayIsuedCardNo());
                aVar.setIdCardNumber(aVar.getIdCardNumber());
                if (aVar.getDobOnID() != null) {
                    try {
                        this.conc_dob.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(aVar.getDobOnID()));
                    } catch (Exception e4) {
                        e4.getMessage();
                    }
                }
            } else if (this.h.equals(C0515Ga.FARE_AVLBLTY)) {
                this.journalist_pasg.setChecked(true);
                x();
                this.normal_pasg.setChecked(false);
                this.divyaang_pasg.setChecked(false);
                this.llSrctznConcession.setVisibility(8);
                this.spc_concession_ll.setVisibility(0);
                this.spc_card_number.setVisibility(0);
                this.tv_info_msg.setVisibility(0);
                this.conc_dob_rl.setVisibility(8);
                this.valid_carddate_rl.setVisibility(0);
                this.nationality_ll.setVisibility(8);
                this.id_card_number11.setVisibility(8);
                this.et_aadhar_vid.setVisibility(0);
                this.specialConcesionType.setText(xx.t(xx.g(aVar.getSrCtznConc())));
                this.special_concession_rl.setFocusableInTouchMode(false);
                this.special_concession_rl.setFocusable(false);
                this.special_concession_rl.setClickable(false);
                this.normal_pasg.setClickable(false);
                this.divyaang_pasg.setClickable(false);
                if (this.f4256e) {
                    this.et_aadhar_vid.setText(C0535I5.c0(this.g));
                } else {
                    this.et_aadhar_vid.setText(aVar.getIdCardNumber().toString().replace(" ", ""));
                }
                if (aVar.getDateValid() != null) {
                    try {
                        this.conc_cardvalidity.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(aVar.getDateValid()));
                    } catch (Exception e5) {
                        e5.getMessage();
                    }
                }
                if (aVar.getStrDobOnID() != null) {
                    try {
                        this.conc_dob.setText(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(aVar.getStrDobOnID()));
                    } catch (Exception e6) {
                        e6.getMessage();
                    }
                }
                aVar.setValidDate(aVar.getValidDate());
                this.spc_card_number.setText(aVar.getRailwayIsuedCardNo());
                if (this.f4256e) {
                    this.cardNumber.setText(C0535I5.c0(this.g));
                } else {
                    this.cardNumber.setText(aVar.getIdCardNumber());
                }
                aVar.setRailwayIsuedCardNo(aVar.getRailwayIsuedCardNo());
                aVar.setIdCardNumber(aVar.getIdCardNumber());
            }
            if (aVar.getVerificationStatusString().equalsIgnoreCase("Verified")) {
                this.f4246a = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0417  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x04ec A[Catch:{ Exception -> 0x05fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0504  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x058f A[Catch:{ Exception -> 0x05fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x05db A[Catch:{ Exception -> 0x05fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x05dd A[Catch:{ Exception -> 0x05fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x05ea A[Catch:{ Exception -> 0x05fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x05ec A[Catch:{ Exception -> 0x05fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x063b  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0952  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x04f6 A[EDGE_INSN: B:366:0x04f6->B:194:0x04f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0270  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r15 = this;
            cris.org.in.ima.activities.MasterPassengerNewActivity r0 = r15.f4239a
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            cris.org.in.ima.activities.MasterPassengerNewActivity r1 = r15.f4239a
            boolean r0 = defpackage.C0535I5.O(r0, r1)
            if (r0 != 0) goto L_0x0022
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            cris.org.in.ima.activities.MasterPassengerNewActivity$g r1 = new cris.org.in.ima.activities.MasterPassengerNewActivity$g
            r1.<init>()
            r2 = 5000(0x1388, double:2.4703E-320)
            r0.postDelayed(r1, r2)
            return
        L_0x0022:
            defpackage.C0535I5.I(r15)
            boolean r0 = r15.f4254d
            r1 = 2131953495(0x7f130757, float:1.9543463E38)
            if (r0 == 0) goto L_0x003e
            r0 = 2131953911(0x7f1308f7, float:1.9544306E38)
            java.lang.String r0 = r15.getString(r0)
            java.lang.String r1 = r15.getString(r1)
            android.app.ProgressDialog r0 = android.app.ProgressDialog.show(r15, r0, r1)
            r15.f4233a = r0
            goto L_0x004f
        L_0x003e:
            r0 = 2131952247(0x7f130277, float:1.9540931E38)
            java.lang.String r0 = r15.getString(r0)
            java.lang.String r1 = r15.getString(r1)
            android.app.ProgressDialog r0 = android.app.ProgressDialog.show(r15, r0, r1)
            r15.f4233a = r0
        L_0x004f:
            cris.prs.webservices.dto.PassengerDetailDTO r0 = new cris.prs.webservices.dto.PassengerDetailDTO
            r0.<init>()
            android.widget.EditText r0 = r15.passengerName
            r0.clearFocus()
            uk$a r0 = new uk$a
            r0.<init>()
            r15.f4244a = r0
            java.lang.String r1 = r15.h
            r0.setUserType(r1)
            uk$a r0 = r15.f4244a
            short r1 = r15.f4245a
            r0.setAge(r1)
            uk$a r0 = r15.f4244a
            android.widget.EditText r1 = r15.passengerName
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.setName(r1)
            uk$a r0 = r15.f4244a
            java.lang.String r1 = r15.f4249c
            r0.setGender(r1)
            uk$a r0 = r15.f4244a
            android.widget.EditText r1 = r15.passengerName
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.trim()
            r0.setMasterPassengerName(r1)
            uk$a r0 = r15.f4244a
            r1 = 0
            r0.setVerificationStatus(r1)
            java.lang.String r0 = r15.e
            java.lang.String r2 = "NC"
            boolean r0 = r0.equalsIgnoreCase(r2)
            r2 = 0
            if (r0 != 0) goto L_0x00e9
            uk$a r0 = r15.f4244a
            java.lang.String r3 = r15.e
            K9 r3 = defpackage.K9.i(r3)
            int r3 = r3.c
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.setIdCardType(r3)
            boolean r0 = r15.f4256e
            if (r0 == 0) goto L_0x00d9
            android.widget.EditText r0 = r15.cardNumber
            java.lang.String r0 = defpackage.xx.B(r0)
            java.lang.String r3 = r15.g
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = defpackage.C0535I5.c0(r3)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x00d9
            uk$a r0 = r15.f4244a
            java.lang.String r3 = r15.g
            r0.setIdCardNumber(r3)
            goto L_0x00ee
        L_0x00d9:
            uk$a r0 = r15.f4244a
            android.widget.EditText r3 = r15.cardNumber
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r0.setIdCardNumber(r3)
            goto L_0x00ee
        L_0x00e9:
            uk$a r0 = r15.f4244a
            r0.setIdCardType(r2)
        L_0x00ee:
            android.widget.EditText r0 = r15.passengerDob
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            java.lang.String r3 = ""
            boolean r0 = r0.equals(r3)
            java.lang.String r4 = "yyyyMMdd"
            java.lang.String r5 = "dd/MM/yyyy"
            if (r0 != 0) goto L_0x0136
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r6 = java.util.Locale.ENGLISH
            r0.<init>(r5, r6)
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
            r7.<init>(r4, r6)
            android.widget.EditText r6 = r15.passengerDob     // Catch:{ ParseException -> 0x0131 }
            android.text.Editable r6 = r6.getText()     // Catch:{ ParseException -> 0x0131 }
            java.lang.String r6 = r6.toString()     // Catch:{ ParseException -> 0x0131 }
            java.util.Date r0 = r0.parse(r6)     // Catch:{ ParseException -> 0x0131 }
            uk$a r6 = r15.f4244a     // Catch:{ ParseException -> 0x0131 }
            r6.setDateOfBirth(r0)     // Catch:{ ParseException -> 0x0131 }
            uk$a r6 = r15.f4244a     // Catch:{ ParseException -> 0x0131 }
            java.lang.String r0 = r7.format(r0)     // Catch:{ ParseException -> 0x0131 }
            r6.setStrDOB(r0)     // Catch:{ ParseException -> 0x0131 }
            goto L_0x0140
        L_0x0131:
            r0 = move-exception
            r0.getMessage()
            goto L_0x0140
        L_0x0136:
            uk$a r0 = r15.f4244a
            r0.setDateOfBirth(r2)
            uk$a r0 = r15.f4244a
            r0.setStrDOB(r2)
        L_0x0140:
            android.widget.TextView r0 = r15.tvBerthPreference
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "Select Berth Preference"
            int r0 = r0.compareTo(r6)
            if (r0 == 0) goto L_0x016c
            uk$a r0 = r15.f4244a
            android.widget.TextView r6 = r15.tvBerthPreference
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            I9 r6 = defpackage.I9.i(r6)
            int r6 = r6.f3657c
            java.lang.String r6 = java.lang.Integer.toString(r6)
            r0.setBerthPreference(r6)
            goto L_0x0171
        L_0x016c:
            uk$a r0 = r15.f4244a
            r0.setBerthPreference(r2)
        L_0x0171:
            android.widget.TextView r0 = r15.tvFoodPref
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "Catering Service Option"
            int r0 = r0.compareTo(r6)
            if (r0 == 0) goto L_0x019d
            uk$a r0 = r15.f4244a
            android.widget.TextView r2 = r15.tvFoodPref
            java.lang.CharSequence r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            J9 r2 = defpackage.J9.j(r2)
            int r2 = r2.c
            java.lang.String r2 = java.lang.Integer.toString(r2)
            r0.setFoodPreference(r2)
            goto L_0x01a2
        L_0x019d:
            uk$a r0 = r15.f4244a
            r0.setFoodPreference(r2)
        L_0x01a2:
            java.lang.String r0 = r15.h
            java.lang.String r2 = "2"
            boolean r0 = r0.equals(r2)
            java.lang.String r6 = "3"
            r7 = 2131953460(0x7f130734, float:1.9543392E38)
            if (r0 != 0) goto L_0x01b9
            java.lang.String r0 = r15.h
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0209
        L_0x01b9:
            android.widget.TextView r0 = r15.specialConcesionType
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x020b
            android.widget.TextView r0 = r15.specialConcesionType
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r8 = "Select Concession Type"
            boolean r0 = r0.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x01dc
            goto L_0x020b
        L_0x01dc:
            android.widget.EditText r0 = r15.conc_cardvalidity
            boolean r0 = defpackage.xx.T(r0, r3)
            if (r0 == 0) goto L_0x01ec
            r0 = 2131951691(0x7f13004b, float:1.9539804E38)
            java.lang.String r0 = r15.getString(r0)
            goto L_0x0212
        L_0x01ec:
            android.widget.EditText r0 = r15.spc_card_number
            boolean r0 = defpackage.xx.T(r0, r3)
            if (r0 == 0) goto L_0x01f9
            java.lang.String r0 = r15.getString(r7)
            goto L_0x0212
        L_0x01f9:
            long r8 = r15.b
            long r10 = r15.a
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0209
            r0 = 2131952166(0x7f130226, float:1.9540767E38)
            java.lang.String r0 = r15.getString(r0)
            goto L_0x0212
        L_0x0209:
            r0 = r3
            goto L_0x0212
        L_0x020b:
            r0 = 2131951979(0x7f13016b, float:1.9540388E38)
            java.lang.String r0 = r15.getString(r0)
        L_0x0212:
            java.lang.String r8 = r15.i
            java.lang.String r9 = "ESCORT"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0237
            android.widget.TextView r8 = r15.tvCardType
            java.lang.CharSequence r8 = r8.getText()
            java.lang.String r8 = r8.toString()
            r9 = 2131953676(0x7f13080c, float:1.954383E38)
            java.lang.String r9 = r15.getString(r9)
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x0237
            java.lang.String r0 = r15.getString(r7)
        L_0x0237:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getMasterPassengerName()
            if (r7 == 0) goto L_0x0259
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getMasterPassengerName()
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0259
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getMasterPassengerName()
            java.lang.String r8 = "^[A-Za-z\\s]+$"
            boolean r7 = r7.matches(r8)
            if (r7 != 0) goto L_0x0260
        L_0x0259:
            r0 = 2131952943(0x7f13052f, float:1.9542343E38)
            java.lang.String r0 = r15.getString(r0)
        L_0x0260:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getMasterPassengerName()
            r8 = 1
            r9 = 3
            r10 = 42
            java.lang.String r11 = "\n* "
            java.lang.String r12 = "* "
            if (r7 == 0) goto L_0x02dd
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getMasterPassengerName()
            int r7 = r7.length()
            if (r7 >= r9) goto L_0x02a6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r9 = r0.length()
            if (r9 <= r8) goto L_0x028f
            char r9 = r0.charAt(r1)
            if (r9 == r10) goto L_0x028f
            r9 = r12
            goto L_0x0290
        L_0x028f:
            r9 = r3
        L_0x0290:
            r7.append(r9)
            r7.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x029e
            r0 = r11
            goto L_0x029f
        L_0x029e:
            r0 = r3
        L_0x029f:
            java.lang.String r9 = "At least 3 characters required for Passenger Name."
            java.lang.String r0 = defpackage.C0709Uj.j(r7, r0, r9)
            goto L_0x02dd
        L_0x02a6:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getMasterPassengerName()
            int r7 = r7.length()
            r9 = 60
            if (r7 <= r9) goto L_0x02dd
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r9 = r0.length()
            if (r9 <= r8) goto L_0x02c7
            char r9 = r0.charAt(r1)
            if (r9 == r10) goto L_0x02c7
            r9 = r12
            goto L_0x02c8
        L_0x02c7:
            r9 = r3
        L_0x02c8:
            r7.append(r9)
            r7.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x02d6
            r0 = r11
            goto L_0x02d7
        L_0x02d6:
            r0 = r3
        L_0x02d7:
            java.lang.String r9 = "At most 60 characters required for Passenger Name "
            java.lang.String r0 = defpackage.C0709Uj.j(r7, r0, r9)
        L_0x02dd:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getGender()
            if (r7 == 0) goto L_0x030f
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getGender()
            java.lang.String r9 = "M"
            boolean r7 = r7.equalsIgnoreCase(r9)
            if (r7 != 0) goto L_0x0343
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getGender()
            java.lang.String r9 = "F"
            boolean r7 = r7.equalsIgnoreCase(r9)
            if (r7 != 0) goto L_0x0343
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getGender()
            java.lang.String r9 = "T"
            boolean r7 = r7.equalsIgnoreCase(r9)
            if (r7 != 0) goto L_0x0343
        L_0x030f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r9 = r0.length()
            if (r9 <= r8) goto L_0x0322
            char r9 = r0.charAt(r1)
            if (r9 == r10) goto L_0x0322
            r9 = r12
            goto L_0x0323
        L_0x0322:
            r9 = r3
        L_0x0323:
            r7.append(r9)
            r7.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x0331
            r0 = r11
            goto L_0x0332
        L_0x0331:
            r0 = r3
        L_0x0332:
            r7.append(r0)
            r0 = 2131952941(0x7f13052d, float:1.9542339E38)
            java.lang.String r0 = r15.getString(r0)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x0343:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getBerthPreference()
            if (r7 == 0) goto L_0x0357
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getBerthPreference()
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x038b
        L_0x0357:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r9 = r0.length()
            if (r9 <= r8) goto L_0x036a
            char r9 = r0.charAt(r1)
            if (r9 == r10) goto L_0x036a
            r9 = r12
            goto L_0x036b
        L_0x036a:
            r9 = r3
        L_0x036b:
            r7.append(r9)
            r7.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x0379
            r0 = r11
            goto L_0x037a
        L_0x0379:
            r0 = r3
        L_0x037a:
            r7.append(r0)
            r0 = 2131952938(0x7f13052a, float:1.9542333E38)
            java.lang.String r0 = r15.getString(r0)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x038b:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getFoodPreference()
            if (r7 == 0) goto L_0x039f
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getFoodPreference()
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x03d3
        L_0x039f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r9 = r0.length()
            if (r9 <= r8) goto L_0x03b2
            char r9 = r0.charAt(r1)
            if (r9 == r10) goto L_0x03b2
            r9 = r12
            goto L_0x03b3
        L_0x03b2:
            r9 = r3
        L_0x03b3:
            r7.append(r9)
            r7.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x03c1
            r0 = r11
            goto L_0x03c2
        L_0x03c1:
            r0 = r3
        L_0x03c2:
            r7.append(r0)
            r0 = 2131952940(0x7f13052c, float:1.9542337E38)
            java.lang.String r0 = r15.getString(r0)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x03d3:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getSrCtznConc()
            if (r7 == 0) goto L_0x03f5
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getSrCtznConc()
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x03f5
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getSrCtznConc()
            java.lang.String r9 = "0#1#2#3#4#5#6#7"
            boolean r7 = r9.contains(r7)
            if (r7 != 0) goto L_0x0429
        L_0x03f5:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r9 = r0.length()
            if (r9 <= r8) goto L_0x0408
            char r9 = r0.charAt(r1)
            if (r9 == r10) goto L_0x0408
            r9 = r12
            goto L_0x0409
        L_0x0408:
            r9 = r3
        L_0x0409:
            r7.append(r9)
            r7.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x0417
            r0 = r11
            goto L_0x0418
        L_0x0417:
            r0 = r3
        L_0x0418:
            r7.append(r0)
            r0 = 2131952945(0x7f130531, float:1.9542347E38)
            java.lang.String r0 = r15.getString(r0)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x0429:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getStrDOB()
            if (r7 == 0) goto L_0x043d
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getStrDOB()
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0471
        L_0x043d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r9 = r0.length()
            if (r9 <= r8) goto L_0x0450
            char r9 = r0.charAt(r1)
            if (r9 == r10) goto L_0x0450
            r9 = r12
            goto L_0x0451
        L_0x0450:
            r9 = r3
        L_0x0451:
            r7.append(r9)
            r7.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x045f
            r0 = r11
            goto L_0x0460
        L_0x045f:
            r0 = r3
        L_0x0460:
            r7.append(r0)
            r0 = 2131952939(0x7f13052b, float:1.9542335E38)
            java.lang.String r0 = r15.getString(r0)
            r7.append(r0)
            java.lang.String r0 = r7.toString()
        L_0x0471:
            boolean r7 = r15.f4256e
            java.lang.String r9 = "0"
            if (r7 == 0) goto L_0x04c7
            android.widget.EditText r7 = r15.cardNumber
            java.lang.String r7 = defpackage.xx.B(r7)
            java.lang.String r10 = r15.g
            java.lang.String r10 = r10.trim()
            boolean r7 = r7.equalsIgnoreCase(r10)
            if (r7 != 0) goto L_0x049f
            android.widget.EditText r7 = r15.cardNumber
            java.lang.String r7 = defpackage.xx.B(r7)
            java.lang.String r10 = r15.g
            java.lang.String r10 = r10.trim()
            java.lang.String r10 = defpackage.C0535I5.c0(r10)
            boolean r7 = r7.equalsIgnoreCase(r10)
            if (r7 == 0) goto L_0x04c7
        L_0x049f:
            android.widget.EditText r7 = r15.et_aadhar_vid
            java.lang.String r7 = defpackage.xx.B(r7)
            java.lang.String r10 = r15.g
            java.lang.String r10 = r10.trim()
            boolean r7 = r7.equalsIgnoreCase(r10)
            if (r7 != 0) goto L_0x0633
            android.widget.EditText r7 = r15.et_aadhar_vid
            java.lang.String r7 = defpackage.xx.B(r7)
            java.lang.String r10 = r15.g
            java.lang.String r10 = r10.trim()
            java.lang.String r10 = defpackage.C0535I5.c0(r10)
            boolean r7 = r7.equalsIgnoreCase(r10)
            if (r7 != 0) goto L_0x0633
        L_0x04c7:
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getIdCardType()
            if (r7 == 0) goto L_0x0633
            uk$a r7 = r15.f4244a
            java.lang.String r7 = r7.getIdCardType()
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0633
            uk$a r7 = r15.f4244a     // Catch:{ Exception -> 0x05fa }
            java.lang.String r7 = r7.getIdCardType()     // Catch:{ Exception -> 0x05fa }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x05fa }
            K9[] r10 = defpackage.K9.values()     // Catch:{ Exception -> 0x05fa }
            int r13 = r10.length     // Catch:{ Exception -> 0x05fa }
        L_0x04ea:
            if (r1 >= r13) goto L_0x04f6
            r14 = r10[r1]     // Catch:{ Exception -> 0x05fa }
            int r14 = r14.c     // Catch:{ Exception -> 0x05fa }
            if (r14 != r7) goto L_0x04f3
            goto L_0x04f6
        L_0x04f3:
            int r1 = r1 + 1
            goto L_0x04ea
        L_0x04f6:
            uk$a r1 = r15.f4244a     // Catch:{ Exception -> 0x05fa }
            java.lang.String r1 = r1.getIdCardType()     // Catch:{ Exception -> 0x05fa }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x05fa }
            r7 = 9
            if (r7 != r1) goto L_0x058f
            r1 = 2131952937(0x7f130529, float:1.954233E38)
            uk$a r7 = r15.f4244a     // Catch:{ Exception -> 0x0556 }
            java.lang.String r7 = r7.getIdCardNumber()     // Catch:{ Exception -> 0x0556 }
            int r7 = r7.length()     // Catch:{ Exception -> 0x0556 }
            r10 = 12
            if (r7 != r10) goto L_0x0521
            uk$a r7 = r15.f4244a     // Catch:{ Exception -> 0x0556 }
            java.lang.String r7 = r7.getIdCardNumber()     // Catch:{ Exception -> 0x0556 }
            boolean r7 = defpackage.C1488xu.k(r7)     // Catch:{ Exception -> 0x0556 }
            if (r7 != 0) goto L_0x0598
        L_0x0521:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0556 }
            r7.<init>()     // Catch:{ Exception -> 0x0556 }
            int r10 = r0.length()     // Catch:{ Exception -> 0x0556 }
            if (r10 <= r8) goto L_0x0537
            r10 = 0
            char r10 = r0.charAt(r10)     // Catch:{ Exception -> 0x0556 }
            r13 = 42
            if (r10 == r13) goto L_0x0537
            r10 = r12
            goto L_0x0538
        L_0x0537:
            r10 = r3
        L_0x0538:
            r7.append(r10)     // Catch:{ Exception -> 0x0556 }
            r7.append(r0)     // Catch:{ Exception -> 0x0556 }
            int r10 = r0.length()     // Catch:{ Exception -> 0x0556 }
            if (r10 <= r8) goto L_0x0546
            r10 = r11
            goto L_0x0547
        L_0x0546:
            r10 = r3
        L_0x0547:
            r7.append(r10)     // Catch:{ Exception -> 0x0556 }
            java.lang.String r10 = r15.getString(r1)     // Catch:{ Exception -> 0x0556 }
            r7.append(r10)     // Catch:{ Exception -> 0x0556 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0556 }
            goto L_0x0598
        L_0x0556:
            r7 = move-exception
            r7.getMessage()     // Catch:{ Exception -> 0x05fa }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fa }
            r7.<init>()     // Catch:{ Exception -> 0x05fa }
            int r10 = r0.length()     // Catch:{ Exception -> 0x05fa }
            if (r10 <= r8) goto L_0x0570
            r10 = 0
            char r10 = r0.charAt(r10)     // Catch:{ Exception -> 0x05fa }
            r13 = 42
            if (r10 == r13) goto L_0x0570
            r10 = r12
            goto L_0x0571
        L_0x0570:
            r10 = r3
        L_0x0571:
            r7.append(r10)     // Catch:{ Exception -> 0x05fa }
            r7.append(r0)     // Catch:{ Exception -> 0x05fa }
            int r10 = r0.length()     // Catch:{ Exception -> 0x05fa }
            if (r10 <= r8) goto L_0x057f
            r10 = r11
            goto L_0x0580
        L_0x057f:
            r10 = r3
        L_0x0580:
            r7.append(r10)     // Catch:{ Exception -> 0x05fa }
            java.lang.String r1 = r15.getString(r1)     // Catch:{ Exception -> 0x05fa }
            r7.append(r1)     // Catch:{ Exception -> 0x05fa }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x05fa }
            goto L_0x0598
        L_0x058f:
            uk$a r1 = r15.f4244a     // Catch:{ Exception -> 0x05fa }
            java.lang.String r1 = r1.getIdCardType()     // Catch:{ Exception -> 0x05fa }
            java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x05fa }
        L_0x0598:
            uk$a r1 = r15.f4244a     // Catch:{ Exception -> 0x05fa }
            java.lang.String r1 = r1.getIdCardNumber()     // Catch:{ Exception -> 0x05fa }
            if (r1 == 0) goto L_0x05c7
            uk$a r1 = r15.f4244a     // Catch:{ Exception -> 0x05fa }
            java.lang.String r1 = r1.getIdCardNumber()     // Catch:{ Exception -> 0x05fa }
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x05fa }
            if (r1 != 0) goto L_0x05c7
            uk$a r1 = r15.f4244a     // Catch:{ Exception -> 0x05fa }
            java.lang.String r1 = r1.getIdCardNumber()     // Catch:{ Exception -> 0x05fa }
            int r1 = r1.length()     // Catch:{ Exception -> 0x05fa }
            r7 = 4
            if (r1 < r7) goto L_0x05c7
            uk$a r1 = r15.f4244a     // Catch:{ Exception -> 0x05fa }
            java.lang.String r1 = r1.getIdCardNumber()     // Catch:{ Exception -> 0x05fa }
            int r1 = r1.length()     // Catch:{ Exception -> 0x05fa }
            r7 = 16
            if (r1 <= r7) goto L_0x0633
        L_0x05c7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05fa }
            r1.<init>()     // Catch:{ Exception -> 0x05fa }
            int r7 = r0.length()     // Catch:{ Exception -> 0x05fa }
            if (r7 <= r8) goto L_0x05dd
            r7 = 0
            char r7 = r0.charAt(r7)     // Catch:{ Exception -> 0x05fa }
            r10 = 42
            if (r7 == r10) goto L_0x05dd
            r7 = r12
            goto L_0x05de
        L_0x05dd:
            r7 = r3
        L_0x05de:
            r1.append(r7)     // Catch:{ Exception -> 0x05fa }
            r1.append(r0)     // Catch:{ Exception -> 0x05fa }
            int r7 = r0.length()     // Catch:{ Exception -> 0x05fa }
            if (r7 <= r8) goto L_0x05ec
            r7 = r11
            goto L_0x05ed
        L_0x05ec:
            r7 = r3
        L_0x05ed:
            r1.append(r7)     // Catch:{ Exception -> 0x05fa }
            java.lang.String r7 = "Invalid Passenger IDcard number"
            r1.append(r7)     // Catch:{ Exception -> 0x05fa }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x05fa }
            goto L_0x0633
        L_0x05fa:
            r1 = move-exception
            r1.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r7 = r0.length()
            if (r7 <= r8) goto L_0x0613
            r7 = 0
            char r7 = r0.charAt(r7)
            r10 = 42
            if (r7 == r10) goto L_0x0613
            goto L_0x0614
        L_0x0613:
            r12 = r3
        L_0x0614:
            r1.append(r12)
            r1.append(r0)
            int r0 = r0.length()
            if (r0 <= r8) goto L_0x0621
            goto L_0x0622
        L_0x0621:
            r11 = r3
        L_0x0622:
            r1.append(r11)
            r0 = 2131952950(0x7f130536, float:1.9542357E38)
            java.lang.String r0 = r15.getString(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0633:
            boolean r1 = r0.equals(r3)
            java.lang.String r7 = "OK"
            if (r1 == 0) goto L_0x0952
            java.lang.String r0 = r15.h
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            java.lang.String r10 = "6"
            java.lang.String r11 = "4"
            r12 = 2
            java.lang.String r13 = "5"
            r14 = 5
            if (r0 == 0) goto L_0x06bf
            android.widget.LinearLayout r0 = r15.llSrctznConcession
            int r0 = r0.getVisibility()
            r3 = 8
            if (r0 != r3) goto L_0x065b
            r0 = 0
            r15.c = r0
            goto L_0x066f
        L_0x065b:
            android.widget.TextView r0 = r15.tvSrctznConcession
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = defpackage.xx.f(r0)
            int r0 = defpackage.xx.V(r0)
            r15.c = r0
        L_0x066f:
            int r0 = r15.c
            if (r0 != 0) goto L_0x067a
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r9)
            goto L_0x08cf
        L_0x067a:
            if (r0 != r8) goto L_0x0683
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r1)
            goto L_0x08cf
        L_0x0683:
            if (r0 != r12) goto L_0x068c
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r2)
            goto L_0x08cf
        L_0x068c:
            r1 = 3
            if (r0 != r1) goto L_0x0696
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r6)
            goto L_0x08cf
        L_0x0696:
            r1 = 4
            if (r0 != r1) goto L_0x06a0
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r11)
            goto L_0x08cf
        L_0x06a0:
            if (r0 != r14) goto L_0x06a9
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r13)
            goto L_0x08cf
        L_0x06a9:
            r1 = 6
            if (r0 != r1) goto L_0x06b3
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r10)
            goto L_0x08cf
        L_0x06b3:
            r1 = 7
            if (r0 != r1) goto L_0x08cf
            uk$a r0 = r15.f4244a
            java.lang.String r1 = "7"
            r0.setSrCtznConc(r1)
            goto L_0x08cf
        L_0x06bf:
            java.lang.String r0 = r15.h
            boolean r0 = r0.equals(r2)
            java.lang.String r9 = "9"
            java.lang.String r14 = "99"
            if (r0 == 0) goto L_0x0803
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r6 = java.util.Locale.ENGLISH
            r0.<init>(r5, r6)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r4, r6)
            android.widget.EditText r4 = r15.conc_cardvalidity     // Catch:{ ParseException -> 0x06ef }
            android.text.Editable r4 = r4.getText()     // Catch:{ ParseException -> 0x06ef }
            java.lang.String r4 = r4.toString()     // Catch:{ ParseException -> 0x06ef }
            java.util.Date r4 = r0.parse(r4)     // Catch:{ ParseException -> 0x06ef }
            uk$a r6 = r15.f4244a     // Catch:{ ParseException -> 0x06ef }
            java.lang.String r4 = r5.format(r4)     // Catch:{ ParseException -> 0x06ef }
            r6.setValidDate(r4)     // Catch:{ ParseException -> 0x06ef }
            goto L_0x06f3
        L_0x06ef:
            r4 = move-exception
            r4.getMessage()
        L_0x06f3:
            uk$a r4 = r15.f4244a
            android.widget.EditText r6 = r15.spc_card_number
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            r4.setRailwayIsuedCardNo(r6)
            boolean r4 = r15.f4256e
            if (r4 == 0) goto L_0x0724
            android.widget.EditText r4 = r15.cardNumber
            java.lang.String r4 = defpackage.xx.B(r4)
            java.lang.String r6 = r15.g
            java.lang.String r6 = r6.trim()
            java.lang.String r6 = defpackage.C0535I5.c0(r6)
            boolean r4 = r4.equalsIgnoreCase(r6)
            if (r4 == 0) goto L_0x0724
            uk$a r4 = r15.f4244a
            java.lang.String r6 = r15.g
            r4.setIdCardNumber(r6)
            goto L_0x0733
        L_0x0724:
            uk$a r4 = r15.f4244a
            android.widget.EditText r6 = r15.cardNumber
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            r4.setIdCardNumber(r6)
        L_0x0733:
            android.widget.TextView r4 = r15.specialConcesionType
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r4 = r4.toString()
            int r4 = defpackage.xx.i(r4)
            int r4 = defpackage.xx.x(r4)
            if (r4 != r8) goto L_0x07a8
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r1)
            android.widget.EditText r0 = r15.et_aadhar_vid
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L_0x07a1
            android.widget.EditText r0 = r15.et_aadhar_vid
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x07a1
            uk$a r0 = r15.f4244a
            r0.setIdCardType(r9)
            boolean r0 = r15.f4256e
            if (r0 == 0) goto L_0x0790
            android.widget.EditText r0 = r15.et_aadhar_vid
            java.lang.String r0 = defpackage.xx.B(r0)
            java.lang.String r1 = r15.g
            java.lang.String r1 = r1.trim()
            java.lang.String r1 = defpackage.C0535I5.c0(r1)
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0790
            uk$a r0 = r15.f4244a
            java.lang.String r1 = r15.g
            r0.setIdCardNumber(r1)
            goto L_0x08cf
        L_0x0790:
            uk$a r0 = r15.f4244a
            android.widget.EditText r1 = r15.et_aadhar_vid
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.setIdCardNumber(r1)
            goto L_0x08cf
        L_0x07a1:
            uk$a r0 = r15.f4244a
            r0.setIdCardType(r14)
            goto L_0x08cf
        L_0x07a8:
            if (r4 != r12) goto L_0x08cf
            uk$a r1 = r15.f4244a
            r1.setSrCtznConc(r2)
            uk$a r1 = r15.f4244a
            android.widget.EditText r2 = r15.conc_dob
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            r1.setStrDobOnID(r2)
            android.widget.EditText r1 = r15.conc_dob
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.trim()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x07f6
            android.widget.EditText r1 = r15.conc_dob     // Catch:{ ParseException -> 0x07f0 }
            android.text.Editable r1 = r1.getText()     // Catch:{ ParseException -> 0x07f0 }
            java.lang.String r1 = r1.toString()     // Catch:{ ParseException -> 0x07f0 }
            java.util.Date r0 = r0.parse(r1)     // Catch:{ ParseException -> 0x07f0 }
            uk$a r1 = r15.f4244a     // Catch:{ ParseException -> 0x07f0 }
            r1.setDateOfBirth(r0)     // Catch:{ ParseException -> 0x07f0 }
            uk$a r1 = r15.f4244a     // Catch:{ ParseException -> 0x07f0 }
            java.lang.String r0 = r5.format(r0)     // Catch:{ ParseException -> 0x07f0 }
            r1.setStrDobOnID(r0)     // Catch:{ ParseException -> 0x07f0 }
            goto L_0x08cf
        L_0x07f0:
            r0 = move-exception
            r0.getMessage()
            goto L_0x08cf
        L_0x07f6:
            uk$a r0 = r15.f4244a
            r1 = 0
            r0.setDateOfBirth(r1)
            uk$a r0 = r15.f4244a
            r0.setStrDobOnID(r1)
            goto L_0x08cf
        L_0x0803:
            java.lang.String r0 = r15.h
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x08cf
            android.widget.TextView r0 = r15.specialConcesionType
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = defpackage.xx.i(r0)
            int r0 = defpackage.xx.x(r0)
            r1 = 4
            if (r0 != r1) goto L_0x0826
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r6)
            goto L_0x0840
        L_0x0826:
            r1 = 5
            if (r0 != r1) goto L_0x082f
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r13)
            goto L_0x0840
        L_0x082f:
            r1 = 6
            if (r0 != r1) goto L_0x0838
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r11)
            goto L_0x0840
        L_0x0838:
            r1 = 7
            if (r0 != r1) goto L_0x0840
            uk$a r0 = r15.f4244a
            r0.setSrCtznConc(r10)
        L_0x0840:
            android.widget.EditText r0 = r15.et_aadhar_vid
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L_0x0893
            android.widget.EditText r0 = r15.et_aadhar_vid
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x0893
            uk$a r0 = r15.f4244a
            r0.setIdCardType(r9)
            boolean r0 = r15.f4256e
            if (r0 == 0) goto L_0x0883
            android.widget.EditText r0 = r15.et_aadhar_vid
            java.lang.String r0 = defpackage.xx.B(r0)
            java.lang.String r1 = r15.g
            java.lang.String r1 = r1.trim()
            java.lang.String r1 = defpackage.C0535I5.c0(r1)
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0883
            uk$a r0 = r15.f4244a
            java.lang.String r1 = r15.g
            r0.setIdCardNumber(r1)
            goto L_0x0898
        L_0x0883:
            uk$a r0 = r15.f4244a
            android.widget.EditText r1 = r15.et_aadhar_vid
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.setIdCardNumber(r1)
            goto L_0x0898
        L_0x0893:
            uk$a r0 = r15.f4244a
            r0.setIdCardType(r14)
        L_0x0898:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r0.<init>(r5, r1)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            r2.<init>(r4, r1)
            android.widget.EditText r1 = r15.conc_cardvalidity     // Catch:{ ParseException -> 0x08bc }
            android.text.Editable r1 = r1.getText()     // Catch:{ ParseException -> 0x08bc }
            java.lang.String r1 = r1.toString()     // Catch:{ ParseException -> 0x08bc }
            java.util.Date r0 = r0.parse(r1)     // Catch:{ ParseException -> 0x08bc }
            uk$a r1 = r15.f4244a     // Catch:{ ParseException -> 0x08bc }
            java.lang.String r0 = r2.format(r0)     // Catch:{ ParseException -> 0x08bc }
            r1.setValidDate(r0)     // Catch:{ ParseException -> 0x08bc }
            goto L_0x08c0
        L_0x08bc:
            r0 = move-exception
            r0.getMessage()
        L_0x08c0:
            uk$a r0 = r15.f4244a
            android.widget.EditText r1 = r15.spc_card_number
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.setRailwayIsuedCardNo(r1)
        L_0x08cf:
            uk r0 = new uk
            r0.<init>()
            boolean r1 = r15.f4254d
            if (r1 == 0) goto L_0x08df
            uk$a r1 = r15.f4244a
            java.lang.String r2 = r15.f
            r1.setEditMasterListId(r2)
        L_0x08df:
            java.util.ArrayList r1 = r0.getPassengerDetailList()
            uk$a r2 = r15.f4244a
            r1.add(r2)
            b1 r1 = defpackage.C0793b1.a
            kn r1 = r1.f3912a
            if (r1 == 0) goto L_0x0940
            java.lang.Object r1 = defpackage.C0657Qt.c(r1)
            Om r1 = (defpackage.Om) r1
            java.lang.String r2 = defpackage.C0657Qt.f()
            boolean r3 = r15.f4254d
            if (r3 == 0) goto L_0x0912
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "masterpsgnlistedit"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            rx.Observable r0 = r1.d1(r2, r0)
            goto L_0x0927
        L_0x0912:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "masterpsgnlistadd"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            rx.Observable r0 = r1.w0(r2, r0)
        L_0x0927:
            Lm r1 = defpackage.C1181iv.a()
            rx.Observable r0 = r0.c(r1)
            Yi r1 = defpackage.E0.a()
            rx.Observable r0 = r0.a(r1)
            cris.org.in.ima.activities.MasterPassengerNewActivity$h r1 = new cris.org.in.ima.activities.MasterPassengerNewActivity$h
            r1.<init>()
            r0.b(r1)
            goto L_0x095f
        L_0x0940:
            cris.org.in.ima.activities.MasterPassengerNewActivity r0 = r15.f4239a
            r1 = 2131951653(0x7f130025, float:1.9539727E38)
            java.lang.String r1 = r15.getString(r1)
            r2 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.o(r0, r1, r7, r2)
            r0.show()
            goto L_0x095f
        L_0x0952:
            r1 = 0
            cris.org.in.ima.activities.MasterPassengerNewActivity r2 = r15.f4239a
            android.app.AlertDialog r0 = defpackage.C0535I5.o(r2, r0, r7, r1)
            r0.show()
            r0 = 0
            r15.f4251c = r0
        L_0x095f:
            android.app.ProgressDialog r0 = r15.f4233a
            r0.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.MasterPassengerNewActivity.m():void");
    }

    public final void n() {
        String str;
        if (this.f4245a == 0) {
            this.llSrctznConcession.setVisibility(8);
        } else if (this.h.equals(C0515Ga.FARE_ONLY) || this.h.equals(C0515Ga.FARE_AVLBLTY) || (str = this.f4249c) == null || ((this.f4245a < 60 || !str.equals("M")) && ((this.f4245a < 58 || !this.f4249c.equals("F")) && (this.f4245a < 60 || !this.f4249c.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_T))))) {
            this.llSrctznConcession.setVisibility(8);
        } else {
            this.llSrctznConcession.setVisibility(0);
            this.tvSrctznConcession.setText(getString(R.string.Option_Senior_Citizen_Concession));
            this.llSrctznConcession.setEnabled(true);
        }
    }

    public final void o(String str) {
        if (this.f4246a) {
            C0535I5.t0(this.f4239a, getString(R.string.verify_psgn_not_chnage_gender));
            return;
        }
        if (str.equalsIgnoreCase("M")) {
            this.tvMale.setChecked(true);
            this.tvFemale.setChecked(false);
            this.tvTransgender.setChecked(false);
            this.f4249c = "M";
        } else if (str.equalsIgnoreCase("F")) {
            this.tvMale.setChecked(false);
            this.tvFemale.setChecked(true);
            this.tvTransgender.setChecked(false);
            this.f4249c = "F";
        } else {
            this.tvMale.setChecked(false);
            this.tvFemale.setChecked(false);
            this.tvTransgender.setChecked(true);
            this.f4249c = RequestConfiguration.MAX_AD_CONTENT_RATING_T;
        }
        n();
    }

    public final void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick({2131363806})
    public void onBerthPreferenceClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4241a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4241a.show(getSupportFragmentManager(), "");
        this.f4241a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4247b, new e());
        this.f4241a.g().setText(getString(R.string.berth_Preference));
        this.f4241a.f().setAdapter(customAdapter);
    }

    @OnClick({2131364210})
    public void onClickOutSide() {
        onBackPressed();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_add_master_passenger);
        ButterKnife.bind((Activity) this);
        getWindow().setLayout(-1, -2);
        setFinishOnTouchOutside(true);
        this.f4239a = this;
        this.delete.setVisibility(8);
        HashMap<String, String> hashMap = C0535I5.f3623a;
        this.f4243a = hashMap;
        ArrayList<String> arrayList = C0535I5.f3622a;
        this.f4258g = arrayList;
        if (hashMap == null || arrayList == null) {
            this.f4243a = new HashMap<>();
            this.f4258g = new ArrayList<>();
            this.f4243a.put("India", "94");
            this.f4243a.put("Show all", "Show all");
            this.f4258g.add("India");
            this.f4258g.add("Show all");
            C0535I5.f3623a = this.f4243a;
            C0535I5.f3622a = this.f4258g;
        }
        this.nationality.setText(R.string.select_Nationality);
        this.f4260i = new ArrayList<>();
        Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("isEdit", false);
            this.f4254d = booleanExtra;
            if (booleanExtra) {
                this.f4244a = (C1426uk.a) intent.getSerializableExtra("MasterPassengerDetail");
                this.titleName.setText(getResources().getString(R.string.edit_passenger));
                this.submit.setText(getString(R.string.Update));
                l(this.f4244a);
                this.delete.setVisibility(0);
            } else {
                this.normal_pasg.setChecked(true);
                this.titleName.setText(getResources().getString(R.string.add_passenger_details));
                this.submit.setText(getString(R.string.add_Passenger));
                l((C1426uk.a) null);
            }
        }
        C1426uk.a aVar = this.f4244a;
        if (aVar != null && aVar.getVerificationStatusString().trim().equalsIgnoreCase("Verified")) {
            this.passengerName.setEnabled(false);
            this.passengerDob.setEnabled(false);
            this.tvMale.setEnabled(false);
            this.tvFemale.setEnabled(false);
            this.tvTransgender.setEnabled(false);
            this.id_card_number11.setEnabled(false);
            this.calender.setEnabled(false);
            this.cardNumber.setEnabled(false);
            this.passengerName.setBackground(this.f4239a.getResources().getDrawable(R.color.light_gray));
            this.passengerDob.setBackground(this.f4239a.getResources().getDrawable(R.color.light_gray));
            this.id_card_number11.setBackground(this.f4239a.getResources().getDrawable(R.color.light_gray));
            this.cardNumber.setBackground(this.f4239a.getResources().getDrawable(R.color.light_gray));
        }
        this.passengerDob.addTextChangedListener(this.f4236a);
        this.conc_cardvalidity.addTextChangedListener(this.f4238a);
        this.conc_dob.addTextChangedListener(this.f4237a);
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.I(this);
        ProgressDialog progressDialog = this.f4233a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4233a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364372})
    public void onDivyaangClick(View view) {
        this.h = C0515Ga.FARE_ONLY;
        t();
        this.specialConcesionType.setText(getString(R.string.Select_Concession_Type));
        this.normal_pasg.setChecked(false);
        this.journalist_pasg.setChecked(false);
        this.spc_concession_ll.setVisibility(0);
        this.spc_card_number.setVisibility(0);
        this.tv_info_msg.setVisibility(0);
        this.valid_carddate_rl.setVisibility(0);
        this.nationality_ll.setVisibility(8);
        this.id_card_number11.setVisibility(8);
        this.cardNumber.setVisibility(8);
        this.llSrctznConcession.setVisibility(8);
        this.et_aadhar_vid.setVisibility(8);
    }

    @OnClick({2131364037})
    public void onDoneClick() {
        try {
            if (!this.f4251c) {
                this.f4251c = true;
                m();
                this.f4233a.dismiss();
            }
        } catch (Exception e2) {
            this.f4251c = false;
            ProgressDialog progressDialog = this.f4233a;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            e2.getMessage();
            C0535I5.m(this, false, getString(R.string.unable_process), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    @OnClick({2131364405})
    public void onFemaleBtnClick(View view) {
        C0535I5.H(this, view);
        o("F");
    }

    @OnClick({2131364406})
    public void onFemaleLableClick(View view) {
        C0535I5.H(this, view);
        o("F");
    }

    @OnClick({2131363816})
    public void onFoodChoiceClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4241a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4241a.show(getSupportFragmentManager(), "");
        this.f4241a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4242a, new d());
        this.f4241a.g().setText(getString(R.string.mealPreference));
        this.f4241a.f().setAdapter(customAdapter);
    }

    @OnClick({2131363808})
    public void onIdCardClick(View view) {
        if (this.f4246a) {
            C0535I5.t0(this.f4239a, getString(R.string.verify_psgn_not_chnage_other_card));
            return;
        }
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4241a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4241a.show(getSupportFragmentManager(), "");
        this.f4241a.setCancelable(true);
        getSupportFragmentManager().z();
        Context baseContext = getBaseContext();
        ArrayList<String> arrayList = this.f4250c;
        CustomAdapter customAdapter = new CustomAdapter(baseContext, arrayList, new f());
        this.f4241a.g().setText(getString(R.string.select_IDCard_type));
        this.f4241a.f().setAdapter(customAdapter);
        if (arrayList.size() >= 10) {
            arrayList.remove(0);
        }
    }

    @OnClick({2131364448})
    public void onJournalistClick(View view) {
        this.h = C0515Ga.FARE_AVLBLTY;
        x();
        this.specialConcesionType.setText(getString(R.string.Select_Concession_Type));
        this.normal_pasg.setChecked(false);
        this.divyaang_pasg.setChecked(false);
        this.spc_concession_ll.setVisibility(0);
        this.spc_card_number.setVisibility(0);
        this.tv_info_msg.setVisibility(0);
        this.conc_dob_rl.setVisibility(8);
        this.llSrctznConcession.setVisibility(8);
        this.valid_carddate_rl.setVisibility(0);
        this.nationality_ll.setVisibility(8);
        this.id_card_number11.setVisibility(8);
        this.cardNumber.setVisibility(8);
        this.et_aadhar_vid.setVisibility(0);
    }

    @OnClick({2131364475})
    public void onMaleBtnClick(View view) {
        C0535I5.H(this, view);
        o("M");
    }

    @OnClick({2131364476})
    public void onMaleLableClick(View view) {
        C0535I5.H(this, view);
        o("M");
    }

    @OnClick({2131363298})
    public void onNationalityClick(View view) {
        this.f4243a = C0535I5.f3623a;
        this.f4258g = C0535I5.f3622a;
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4241a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4241a.show(getSupportFragmentManager(), "");
        this.f4241a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4258g, new c());
        this.f4241a.g().setText(R.string.select_Nationality);
        this.f4241a.f().setAdapter(customAdapter);
    }

    @OnClick({2131364508})
    public void onNormalPassClick(View view) {
        this.h = C0515Ga.AVLBLTY_ONLY;
        this.journalist_pasg.setChecked(false);
        this.divyaang_pasg.setChecked(false);
        this.spc_concession_ll.setVisibility(8);
        this.spc_card_number.setVisibility(8);
        this.tv_info_msg.setVisibility(8);
        this.conc_dob_rl.setVisibility(8);
        this.valid_carddate_rl.setVisibility(8);
        this.nationality_ll.setVisibility(8);
        this.id_card_number11.setVisibility(0);
        this.cardNumber.setVisibility(8);
        this.et_aadhar_vid.setVisibility(8);
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        C0535I5.I(this);
        ProgressDialog progressDialog = this.f4233a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4233a.dismiss();
        }
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    @OnClick({2131363835})
    public void onSeniorCtznConcessionClick(View view) {
        try {
            C0535I5.H(this, view);
            if (this.f4248b) {
                this.f4248b = false;
                if (!this.f4252d.equals("IN")) {
                    this.llSrctznConcession.setVisibility(8);
                    this.c = 0;
                    this.tvSrctznConcession.setText(xx.a(xx.j(0)));
                    C0535I5.t0(this, getString(R.string.applicable_only_indian));
                }
                C0816cB cBVar = new C0816cB(new q(), LogSeverity.CRITICAL_VALUE);
                this.f4235a = cBVar;
                cBVar.a();
                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                this.f4241a = customDialogFragment;
                customDialogFragment.setShowsDialog(true);
                this.f4241a.show(getSupportFragmentManager(), "");
                this.f4241a.setCancelable(true);
                getSupportFragmentManager().z();
                CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4253d, new a());
                this.f4241a.g().setText(getString(R.string.Senior_Citizen_Concession));
                this.f4241a.f().setAdapter(customAdapter);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363989})
    public void onSpecialConcession(View view) {
        C0535I5.H(this, view);
        if (!this.f4252d.equals("IN")) {
            C0535I5.t0(this.f4239a, getString(R.string.applicable_only_indian));
            return;
        }
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4241a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4241a.show(getSupportFragmentManager(), "");
        this.f4241a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(this.f4239a, this.f4259h, new b());
        this.f4241a.g().setText(getString(R.string.Select_Concession_Type));
        this.f4241a.f().setAdapter(customAdapter);
    }

    public final void onStop() {
        super.onStop();
        C0535I5.I(this);
        ProgressDialog progressDialog = this.f4233a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4233a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364695})
    public void onTransgenderBtnClick(View view) {
        C0535I5.H(this, view);
        o(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
    }

    @OnClick({2131364696})
    public void onTransgenderLableClick(View view) {
        C0535I5.H(this, view);
        o(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
    }

    public final void p(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    this.passengerDob.setError((CharSequence) null);
                    this.passengerDob.setTextColor(getResources().getColor(R.color.black_90_opa));
                } else {
                    return;
                }
            }
            this.cardNumber.setError((CharSequence) null);
            this.cardNumber.setTextColor(getResources().getColor(R.color.black_90_opa));
            return;
        }
        this.passengerName.setError((CharSequence) null);
        this.passengerName.setTextColor(getResources().getColor(R.color.black_90_opa));
    }

    public final void t() {
        ArrayList<String> arrayList = this.f4259h;
        arrayList.clear();
        this.f4260i.clear();
        this.f4260i.add(1);
        this.f4260i.add(2);
        Iterator<Integer> it = this.f4260i.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            int[] _values$1 = xx._values$1();
            int length = _values$1.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int i4 = _values$1[i3];
                if (xx.x(i4) == intValue) {
                    i2 = i4;
                    break;
                }
                i3++;
            }
            arrayList.add(xx.t(i2));
        }
    }

    public final void x() {
        ArrayList<String> arrayList = this.f4259h;
        arrayList.clear();
        this.f4260i.clear();
        this.f4260i.add(4);
        this.f4260i.add(5);
        this.f4260i.add(6);
        this.f4260i.add(7);
        Iterator<Integer> it = this.f4260i.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            int[] _values$1 = xx._values$1();
            int length = _values$1.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int i4 = _values$1[i3];
                if (xx.x(i4) == intValue) {
                    i2 = i4;
                    break;
                }
                i3++;
            }
            arrayList.add(xx.t(i2));
        }
    }

    public class g implements Runnable {
        public final void run() {
        }
    }

    public class n implements TextWatcher {
        public n() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
                C0535I5.I(masterPassengerNewActivity);
                try {
                    masterPassengerNewActivity.f4245a = (short) (Math.round((float) Long.valueOf((new Date().getTime() / 1000) - (new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(masterPassengerNewActivity.passengerDob.getText().toString()).getTime() / 1000)).longValue()) / 31536000);
                    masterPassengerNewActivity.n();
                } catch (ParseException e) {
                    int i = MasterPassengerNewActivity.d;
                    e.getMessage();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[Catch:{ NumberFormatException -> 0x00b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(java.lang.CharSequence r8, int r9, int r10, int r11) {
            /*
                r7 = this;
                cris.org.in.ima.activities.MasterPassengerNewActivity r9 = cris.org.in.ima.activities.MasterPassengerNewActivity.this
                java.lang.String r8 = r8.toString()
                java.lang.String r11 = ""
                java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
                java.lang.String r1 = "dd/mm/yyyy"
                r0.<init>(r1)
                r0 = 3
                r1 = 10
                int r2 = r8.length()     // Catch:{ NumberFormatException -> 0x00b2 }
                r3 = 2
                r4 = 1
                java.lang.String r5 = "/"
                if (r2 != r3) goto L_0x0043
                if (r10 != 0) goto L_0x0043
                int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00b2 }
                if (r2 < r4) goto L_0x0040
                int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00b2 }
                r3 = 31
                if (r2 <= r3) goto L_0x002d
                goto L_0x0040
            L_0x002d:
                java.lang.String r8 = r8.concat(r5)     // Catch:{ NumberFormatException -> 0x00b2 }
                android.widget.EditText r2 = r9.passengerDob     // Catch:{ NumberFormatException -> 0x00b2 }
                r2.setText(r8)     // Catch:{ NumberFormatException -> 0x00b2 }
                android.widget.EditText r2 = r9.passengerDob     // Catch:{ NumberFormatException -> 0x00b2 }
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b2 }
                r2.setSelection(r3)     // Catch:{ NumberFormatException -> 0x00b2 }
                goto L_0x0043
            L_0x0040:
                java.lang.String r2 = " Enter Date between 1 to 31"
                goto L_0x0044
            L_0x0043:
                r2 = r11
            L_0x0044:
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r6 = 5
                if (r3 != r6) goto L_0x0075
                if (r10 != 0) goto L_0x0075
                java.lang.String r3 = r8.substring(r0)     // Catch:{ NumberFormatException -> 0x00b0 }
                int r6 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r6 < r4) goto L_0x0073
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                r6 = 12
                if (r3 <= r6) goto L_0x0060
                goto L_0x0073
            L_0x0060:
                java.lang.String r8 = r8.concat(r5)     // Catch:{ NumberFormatException -> 0x00b0 }
                android.widget.EditText r3 = r9.passengerDob     // Catch:{ NumberFormatException -> 0x00b0 }
                r3.setText(r8)     // Catch:{ NumberFormatException -> 0x00b0 }
                android.widget.EditText r3 = r9.passengerDob     // Catch:{ NumberFormatException -> 0x00b0 }
                int r5 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r3.setSelection(r5)     // Catch:{ NumberFormatException -> 0x00b0 }
                goto L_0x0075
            L_0x0073:
                java.lang.String r2 = "Enter Month Between 1 to 12"
            L_0x0075:
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r3 != r1) goto L_0x00ad
                if (r10 != 0) goto L_0x00ad
                r10 = 6
                java.lang.String r10 = r8.substring(r10)     // Catch:{ NumberFormatException -> 0x00b0 }
                java.util.Calendar r3 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException -> 0x00b0 }
                int r3 = r3.get(r4)     // Catch:{ NumberFormatException -> 0x00b0 }
                int r4 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x00b0 }
                r5 = 1900(0x76c, float:2.662E-42)
                if (r4 <= r5) goto L_0x00aa
                int r4 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r4 <= r3) goto L_0x00a0
                r3 = 0
                char r10 = r10.charAt(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r10 != 0) goto L_0x00a0
                goto L_0x00aa
            L_0x00a0:
                android.widget.EditText r10 = r9.passengerDob     // Catch:{ NumberFormatException -> 0x00b0 }
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r10.setSelection(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                goto L_0x00b9
            L_0x00aa:
                java.lang.String r2 = "Please Enter Valid Year "
                goto L_0x00b9
            L_0x00ad:
                java.lang.String r2 = "Invalid Date Format"
                goto L_0x00b9
            L_0x00b0:
                r10 = move-exception
                goto L_0x00b4
            L_0x00b2:
                r10 = move-exception
                r2 = r11
            L_0x00b4:
                int r3 = cris.org.in.ima.activities.MasterPassengerNewActivity.d
                r10.getMessage()
            L_0x00b9:
                int r8 = r8.length()
                if (r8 == r1) goto L_0x00c5
                boolean r8 = r2.equalsIgnoreCase(r11)
                if (r8 == 0) goto L_0x00ca
            L_0x00c5:
                int r8 = cris.org.in.ima.activities.MasterPassengerNewActivity.d
                r9.p(r0)
            L_0x00ca:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.MasterPassengerNewActivity.n.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class o implements TextWatcher {
        public o() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
                C0535I5.I(masterPassengerNewActivity);
                masterPassengerNewActivity.conc_dob.clearFocus();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[Catch:{ NumberFormatException -> 0x00b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(java.lang.CharSequence r8, int r9, int r10, int r11) {
            /*
                r7 = this;
                cris.org.in.ima.activities.MasterPassengerNewActivity r9 = cris.org.in.ima.activities.MasterPassengerNewActivity.this
                java.lang.String r8 = r8.toString()
                java.lang.String r11 = ""
                java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
                java.lang.String r1 = "dd/mm/yyyy"
                r0.<init>(r1)
                r0 = 3
                r1 = 10
                int r2 = r8.length()     // Catch:{ NumberFormatException -> 0x00b2 }
                r3 = 2
                r4 = 1
                java.lang.String r5 = "/"
                if (r2 != r3) goto L_0x0043
                if (r10 != 0) goto L_0x0043
                int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00b2 }
                if (r2 < r4) goto L_0x0040
                int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00b2 }
                r3 = 31
                if (r2 <= r3) goto L_0x002d
                goto L_0x0040
            L_0x002d:
                java.lang.String r8 = r8.concat(r5)     // Catch:{ NumberFormatException -> 0x00b2 }
                android.widget.EditText r2 = r9.conc_dob     // Catch:{ NumberFormatException -> 0x00b2 }
                r2.setText(r8)     // Catch:{ NumberFormatException -> 0x00b2 }
                android.widget.EditText r2 = r9.conc_dob     // Catch:{ NumberFormatException -> 0x00b2 }
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b2 }
                r2.setSelection(r3)     // Catch:{ NumberFormatException -> 0x00b2 }
                goto L_0x0043
            L_0x0040:
                java.lang.String r2 = " Enter Date between 1 to 31"
                goto L_0x0044
            L_0x0043:
                r2 = r11
            L_0x0044:
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r6 = 5
                if (r3 != r6) goto L_0x0075
                if (r10 != 0) goto L_0x0075
                java.lang.String r3 = r8.substring(r0)     // Catch:{ NumberFormatException -> 0x00b0 }
                int r6 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r6 < r4) goto L_0x0073
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                r6 = 12
                if (r3 <= r6) goto L_0x0060
                goto L_0x0073
            L_0x0060:
                java.lang.String r8 = r8.concat(r5)     // Catch:{ NumberFormatException -> 0x00b0 }
                android.widget.EditText r3 = r9.conc_dob     // Catch:{ NumberFormatException -> 0x00b0 }
                r3.setText(r8)     // Catch:{ NumberFormatException -> 0x00b0 }
                android.widget.EditText r3 = r9.conc_dob     // Catch:{ NumberFormatException -> 0x00b0 }
                int r5 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r3.setSelection(r5)     // Catch:{ NumberFormatException -> 0x00b0 }
                goto L_0x0075
            L_0x0073:
                java.lang.String r2 = "Enter Month Between 1 to 12"
            L_0x0075:
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r3 != r1) goto L_0x00ad
                if (r10 != 0) goto L_0x00ad
                r10 = 6
                java.lang.String r10 = r8.substring(r10)     // Catch:{ NumberFormatException -> 0x00b0 }
                java.util.Calendar r3 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException -> 0x00b0 }
                int r3 = r3.get(r4)     // Catch:{ NumberFormatException -> 0x00b0 }
                int r4 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x00b0 }
                r5 = 1900(0x76c, float:2.662E-42)
                if (r4 <= r5) goto L_0x00aa
                int r4 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r4 <= r3) goto L_0x00a0
                r3 = 0
                char r10 = r10.charAt(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r10 != 0) goto L_0x00a0
                goto L_0x00aa
            L_0x00a0:
                android.widget.EditText r10 = r9.conc_dob     // Catch:{ NumberFormatException -> 0x00b0 }
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r10.setSelection(r3)     // Catch:{ NumberFormatException -> 0x00b0 }
                goto L_0x00b9
            L_0x00aa:
                java.lang.String r2 = "Please Enter Valid Year "
                goto L_0x00b9
            L_0x00ad:
                java.lang.String r2 = "Invalid Date Format"
                goto L_0x00b9
            L_0x00b0:
                r10 = move-exception
                goto L_0x00b4
            L_0x00b2:
                r10 = move-exception
                r2 = r11
            L_0x00b4:
                int r3 = cris.org.in.ima.activities.MasterPassengerNewActivity.d
                r10.getMessage()
            L_0x00b9:
                int r8 = r8.length()
                if (r8 == r1) goto L_0x00c5
                boolean r8 = r2.equalsIgnoreCase(r11)
                if (r8 == 0) goto L_0x00ca
            L_0x00c5:
                int r8 = cris.org.in.ima.activities.MasterPassengerNewActivity.d
                r9.p(r0)
            L_0x00ca:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.MasterPassengerNewActivity.o.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class p implements TextWatcher {
        public p() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                MasterPassengerNewActivity masterPassengerNewActivity = MasterPassengerNewActivity.this;
                C0535I5.I(masterPassengerNewActivity);
                masterPassengerNewActivity.conc_cardvalidity.clearFocus();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00af A[Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(java.lang.CharSequence r8, int r9, int r10, int r11) {
            /*
                r7 = this;
                cris.org.in.ima.activities.MasterPassengerNewActivity r9 = cris.org.in.ima.activities.MasterPassengerNewActivity.this
                java.lang.String r8 = r8.toString()
                java.lang.String r11 = ""
                r0 = 3
                r1 = 10
                int r2 = r8.length()     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                r3 = 2
                r4 = 1
                java.lang.String r5 = "/"
                if (r2 != r3) goto L_0x003c
                if (r10 != 0) goto L_0x003c
                int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                if (r2 < r4) goto L_0x0039
                int r2 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                r3 = 31
                if (r2 <= r3) goto L_0x0026
                goto L_0x0039
            L_0x0026:
                java.lang.String r8 = r8.concat(r5)     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                android.widget.EditText r2 = r9.conc_cardvalidity     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                r2.setText(r8)     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                android.widget.EditText r2 = r9.conc_cardvalidity     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                r2.setSelection(r3)     // Catch:{ NumberFormatException -> 0x00ea, ParseException -> 0x00e2 }
                goto L_0x003c
            L_0x0039:
                java.lang.String r2 = " Enter Date between 1 to 31"
                goto L_0x003d
            L_0x003c:
                r2 = r11
            L_0x003d:
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r6 = 5
                if (r3 != r6) goto L_0x006e
                if (r10 != 0) goto L_0x006e
                java.lang.String r3 = r8.substring(r0)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                int r6 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                if (r6 < r4) goto L_0x006c
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r6 = 12
                if (r3 <= r6) goto L_0x0059
                goto L_0x006c
            L_0x0059:
                java.lang.String r8 = r8.concat(r5)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                android.widget.EditText r3 = r9.conc_cardvalidity     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r3.setText(r8)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                android.widget.EditText r3 = r9.conc_cardvalidity     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                int r5 = r8.length()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r3.setSelection(r5)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                goto L_0x006e
            L_0x006c:
                java.lang.String r2 = "Enter Month Between 1 to 12"
            L_0x006e:
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                if (r3 != r1) goto L_0x00a6
                if (r10 != 0) goto L_0x00a6
                r10 = 6
                java.lang.String r10 = r8.substring(r10)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                java.util.Calendar r3 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                int r3 = r3.get(r4)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                int r4 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r5 = 1900(0x76c, float:2.662E-42)
                if (r4 <= r5) goto L_0x00a3
                int r4 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                if (r4 <= r3) goto L_0x0099
                r3 = 0
                char r10 = r10.charAt(r3)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                if (r10 != 0) goto L_0x0099
                goto L_0x00a3
            L_0x0099:
                android.widget.EditText r10 = r9.conc_cardvalidity     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r10.setSelection(r3)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                goto L_0x00a9
            L_0x00a3:
                java.lang.String r2 = "Please Enter Valid Year "
                goto L_0x00a9
            L_0x00a6:
                java.lang.String r10 = "Invalid Date Format"
                r2 = r10
            L_0x00a9:
                int r10 = r8.length()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                if (r10 != r1) goto L_0x00f1
                android.widget.EditText r10 = r9.conc_cardvalidity     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                android.text.Editable r10 = r10.getText()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                java.lang.String r10 = r10.toString()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                java.lang.String r4 = "dd/MM/yyyy"
                r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                java.util.Date r10 = r3.parse(r10)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                long r3 = r10.getTime()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r9.a = r3     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                java.util.Calendar r10 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                long r3 = r10.getTimeInMillis()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r9.b = r3     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                android.widget.EditText r10 = r9.conc_cardvalidity     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                int r3 = r8.length()     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                r10.setSelection(r3)     // Catch:{ NumberFormatException -> 0x00e0, ParseException -> 0x00de }
                goto L_0x00f1
            L_0x00de:
                r10 = move-exception
                goto L_0x00e4
            L_0x00e0:
                r10 = move-exception
                goto L_0x00ec
            L_0x00e2:
                r10 = move-exception
                r2 = r11
            L_0x00e4:
                int r3 = cris.org.in.ima.activities.MasterPassengerNewActivity.d
                r10.getMessage()
                goto L_0x00f1
            L_0x00ea:
                r10 = move-exception
                r2 = r11
            L_0x00ec:
                int r3 = cris.org.in.ima.activities.MasterPassengerNewActivity.d
                r10.getMessage()
            L_0x00f1:
                int r8 = r8.length()
                if (r8 == r1) goto L_0x00fd
                boolean r8 = r2.equalsIgnoreCase(r11)
                if (r8 == 0) goto L_0x0102
            L_0x00fd:
                int r8 = cris.org.in.ima.activities.MasterPassengerNewActivity.d
                r9.p(r0)
            L_0x0102:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.MasterPassengerNewActivity.p.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
