package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import cris.prs.webservices.dto.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

public class FavouriteJourneyActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public FavouriteJourneyActivity f4168a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4169a;

    /* renamed from: a  reason: collision with other field name */
    public b.a f4170a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4171a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, String> f4172a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4173a;
    public final ArrayList<String> b = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    public String f4174c = "NC";

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<H9> f4175c;
    public String d;

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList<String> f4176d;
    public String e;
    @BindView(2131362585)
    EditText et_train_number;
    public String f;
    public String g;
    @BindView(2131363809)
    RelativeLayout rv_class;
    @BindView(2131363817)
    RelativeLayout rv_fromstn;
    @BindView(2131363828)
    RelativeLayout rv_quaota;
    @BindView(2131363839)
    RelativeLayout rv_tostn;
    @BindView(2131364037)
    TextView submit;
    @BindView(2131364339)
    TextView tv_class;
    @BindView(2131364426)
    TextView tv_fromstan;
    @BindView(2131364549)
    TextView tv_quota;
    @BindView(2131364675)
    TextView tv_tostan;

    public class a implements OnSelectionListener {
        public a() {
        }

        public final void onClick(String str) {
            FavouriteJourneyActivity favouriteJourneyActivity = FavouriteJourneyActivity.this;
            favouriteJourneyActivity.tv_class.setText(str);
            favouriteJourneyActivity.f4169a.dismiss();
            if (favouriteJourneyActivity.f4172a.size() > 0) {
                favouriteJourneyActivity.getClass();
                favouriteJourneyActivity.tv_class.setError((CharSequence) null);
                return;
            }
            favouriteJourneyActivity.getClass();
            favouriteJourneyActivity.tv_class.setError("Select Classes");
        }
    }

    public class b implements OnSelectionListener {
        public b() {
        }

        public final void onClick(String str) {
            FavouriteJourneyActivity favouriteJourneyActivity = FavouriteJourneyActivity.this;
            favouriteJourneyActivity.tv_quota.setText(str);
            favouriteJourneyActivity.f4169a.dismiss();
            favouriteJourneyActivity.f4174c = String.valueOf(H9.i(str).f3610c);
        }
    }

    public class d extends Subscriber<StatusDTO> {
        public d() {
        }

        public final void onCompleted() {
            int i = FavouriteJourneyActivity.c;
            FavouriteJourneyActivity.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = FavouriteJourneyActivity.c;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            String next;
            String str;
            String str2;
            StatusDTO statusDTO = (StatusDTO) obj;
            int i = FavouriteJourneyActivity.c;
            Objects.toString(statusDTO);
            FavouriteJourneyActivity favouriteJourneyActivity = FavouriteJourneyActivity.this;
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
                        favouriteJourneyActivity.a.dismiss();
                        C0535I5.p(favouriteJourneyActivity.f4168a, false, str3, favouriteJourneyActivity.getString(R.string.error), favouriteJourneyActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                    } else if (statusDTO.getError() == null || statusDTO.getError().equals("")) {
                        favouriteJourneyActivity.a.dismiss();
                        C0535I5.f3640e.clear();
                        C0535I5.p(favouriteJourneyActivity.f4168a, false, statusDTO.getStatus(), favouriteJourneyActivity.getString(R.string.confirmation_title), favouriteJourneyActivity.getString(R.string.OK), new C0844a(this), (String) null, (DialogInterface.OnClickListener) null).show();
                    } else {
                        favouriteJourneyActivity.a.dismiss();
                        C0535I5.m(favouriteJourneyActivity.f4168a, false, statusDTO.getError(), favouriteJourneyActivity.getString(R.string.error), favouriteJourneyActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    }
                } catch (Exception e) {
                    int i2 = FavouriteJourneyActivity.c;
                    e.getMessage();
                    favouriteJourneyActivity.a.dismiss();
                    C0535I5.m(favouriteJourneyActivity.f4168a, false, favouriteJourneyActivity.getString(R.string.Unable_process_request), favouriteJourneyActivity.getString(R.string.error), favouriteJourneyActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else {
                favouriteJourneyActivity.a.dismiss();
                C0535I5.m(favouriteJourneyActivity.f4168a, false, favouriteJourneyActivity.getString(R.string.Unable_process_request), favouriteJourneyActivity.getString(R.string.error), favouriteJourneyActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    static {
        C1354qp.R(FavouriteJourneyActivity.class);
    }

    public FavouriteJourneyActivity() {
        new ArrayList();
        this.f4176d = new ArrayList<>();
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.f4173a = false;
    }

    @OnClick({2131364037})
    public void addFavouriteJourney() {
        try {
            if (!this.f4173a) {
                this.f4173a = true;
                l();
                this.a.dismiss();
            }
        } catch (Exception e2) {
            this.f4173a = false;
            ProgressDialog progressDialog = this.a;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            e2.getMessage();
            C0535I5.m(this, false, getString(R.string.Unable_process_request), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public final void init() {
        this.et_train_number.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        EditText editText = this.et_train_number;
        editText.setInputType(2);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
    }

    public final void l() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (!C0535I5.O((ConnectivityManager) getSystemService("connectivity"), getBaseContext())) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        this.a = ProgressDialog.show(this, "Add Fevourite Journey list", getString(R.string.please_wait_text));
        b.a aVar = new b.a();
        this.f4170a = aVar;
        aVar.setTrainNumber(this.et_train_number.getText().toString());
        this.f4170a.setFromStnCode(this.g);
        this.f4170a.setToStnCode(this.f);
        this.f4170a.setCls(this.f4172a.get(this.tv_class.getText()));
        this.f4170a.setQuota(this.f4174c);
        if (this.f4170a.getTrainNumber() == null || this.f4170a.getTrainNumber().equals("")) {
            str = getString(R.string.please_enter_train_number);
        } else {
            str = "";
        }
        String str8 = "\n* ";
        String str9 = "* ";
        if (this.f4170a.getFromStnCode() == null || this.f4170a.getFromStnCode().equals("")) {
            StringBuilder sb = new StringBuilder();
            if (str.length() <= 1 || str.charAt(0) == '*') {
                str6 = "";
            } else {
                str6 = str9;
            }
            sb.append(str6);
            sb.append(str);
            if (str.length() > 1) {
                str7 = str8;
            } else {
                str7 = "";
            }
            str = C0709Uj.j(sb, str7, "Please Enter From Station");
        }
        if (this.f4170a.getToStnCode() == null || this.f4170a.getToStnCode().equals("")) {
            StringBuilder sb2 = new StringBuilder();
            if (str.length() <= 1 || str.charAt(0) == '*') {
                str4 = "";
            } else {
                str4 = str9;
            }
            sb2.append(str4);
            sb2.append(str);
            if (str.length() > 1) {
                str5 = str8;
            } else {
                str5 = "";
            }
            str = C0709Uj.j(sb2, str5, "Please Enter to Station");
        }
        if (this.f4170a.getQuota() == null || this.f4170a.getQuota().equalsIgnoreCase("Select Quota")) {
            StringBuilder sb3 = new StringBuilder();
            if (str.length() <= 1 || str.charAt(0) == '*') {
                str2 = "";
            } else {
                str2 = str9;
            }
            sb3.append(str2);
            sb3.append(str);
            if (str.length() > 1) {
                str3 = str8;
            } else {
                str3 = "";
            }
            str = C0709Uj.j(sb3, str3, "Please Enter Quota");
        }
        if (this.f4170a.getCls() == null || this.f4170a.getCls().equalsIgnoreCase("Select Classes")) {
            StringBuilder sb4 = new StringBuilder();
            if (str.length() <= 1 || str.charAt(0) == '*') {
                str9 = "";
            }
            sb4.append(str9);
            sb4.append(str);
            if (str.length() <= 1) {
                str8 = "";
            }
            str = C0709Uj.j(sb4, str8, "Please Enter Class");
        }
        if (str.equals("")) {
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).q1(this.f4170a.getFromStnCode(), this.f4170a.getToStnCode(), this.f4170a.getTrainNumber(), this.f4170a.getQuota(), this.f4170a.getCls()).c(C1181iv.a()).a(E0.a()).b(new d());
            return;
        }
        C0535I5.o(this.f4168a, str, getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        this.f4173a = false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        if (i2 == 0 || i2 == 2) {
            if (intent.getStringExtra("fromStationCode") != null) {
                String stringExtra = intent.getStringExtra("fromStationCode");
                this.d = stringExtra;
                this.tv_fromstan.setText(C0535I5.s0(stringExtra.substring(stringExtra.indexOf("-") + 1)));
                String str = this.d;
                this.g = str.substring(0, str.indexOf("-"));
            }
            if (intent.getStringExtra("toStationCode") != null) {
                String stringExtra2 = intent.getStringExtra("toStationCode");
                this.e = stringExtra2;
                this.tv_tostan.setText(C0535I5.s0(stringExtra2.substring(stringExtra2.indexOf("-") + 1)));
                String str2 = this.e;
                this.f = str2.substring(0, str2.indexOf("-"));
            }
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_add_favourite_journey);
        ButterKnife.bind((Activity) this);
        getWindow().setLayout(-1, -2);
        setFinishOnTouchOutside(true);
        this.f4168a = this;
        init();
        ArrayList<H9> arrayList = new ArrayList<>();
        arrayList.add(H9.a);
        arrayList.add(H9.b);
        arrayList.add(H9.c);
        arrayList.add(H9.d);
        arrayList.add(H9.e);
        arrayList.add(H9.f);
        arrayList.add(H9.g);
        arrayList.add(H9.i);
        this.f4175c = arrayList;
        ArrayList<String> arrayList2 = this.f4171a;
        if (arrayList2.isEmpty() || this.b.isEmpty()) {
            HashMap<String, String> hashMap = this.f4172a;
            hashMap.clear();
            hashMap.put("Anubhuti Class(EA)", "EA");
            hashMap.put("AC First Class(1A)", "1A");
            hashMap.put("AC 2 Tier(2A)", "2A");
            hashMap.put("AC 3 Tier(3A)", "3A");
            hashMap.put("AC Chair car(CC)", "CC");
            hashMap.put("AC 3 Economy(3E)", "3E");
            hashMap.put("Exec. Chair Car(EC)", "EC");
            hashMap.put("Sleeper(SL)", "SL");
            hashMap.put("First Class(FC)", "FC");
            hashMap.put("Second Sitting(2S)", "2S");
            arrayList2.add("Anubhuti Class(EA)");
            arrayList2.add("AC First Class(1A)");
            arrayList2.add("AC 2 Tier(2A)");
            arrayList2.add("AC 3 Tier(3A)");
            arrayList2.add("AC Chair car(CC)");
            arrayList2.add("AC 3 Economy(3E)");
            arrayList2.add("Exec. Chair Car(EC)");
            arrayList2.add("Sleeper(SL)");
            arrayList2.add("First Class(FC)");
            arrayList2.add("Second Sitting(2S)");
            this.tv_class.setText("Select Classes");
        }
        ArrayList<String> arrayList3 = this.f4176d;
        arrayList3.clear();
        this.tv_quota.setText("Select Quota");
        Iterator<H9> it = this.f4175c.iterator();
        while (it.hasNext()) {
            arrayList3.add(it.next().a());
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.I(this);
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363817})
    public void onFromStationClick(View view) {
        Intent intent = new Intent(this, StationListActivity.class);
        intent.putExtra("stationView", 0);
        intent.putExtra("FromStationHint", this.d);
        intent.putExtra("ToStationHint", this.e);
        intent.putExtra("toStnClickFavFlag", "true");
        startActivityForResult(intent, 0);
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        C0535I5.I(this);
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363828})
    public void onQuotaClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4169a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4169a.show(getSupportFragmentManager(), "");
        this.f4169a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getBaseContext(), this.f4176d, new b());
        this.f4169a.g().setText("Select Quoat");
        this.f4169a.f().setAdapter(customAdapter);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    @OnClick({2131363809})
    public void onSelectClassClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4169a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4169a.show(getSupportFragmentManager(), "");
        this.f4169a.setCancelable(true);
        getSupportFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(this.f4168a, this.f4171a, new a());
        this.f4169a.g().setText("Select Class");
        this.f4169a.f().setAdapter(customAdapter);
    }

    public final void onStop() {
        super.onStop();
        C0535I5.I(this);
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363839})
    public void onToStationClick(View view) {
        Intent intent = new Intent(this, StationListActivity.class);
        intent.putExtra("stationView", 1);
        intent.putExtra("FromStationHint", this.d);
        intent.putExtra("ToStationHint", this.e);
        intent.putExtra("toStnClickFavFlag", "false");
        startActivityForResult(intent, 1);
    }

    @OnTextChanged({2131362585})
    public void onTrainNumberTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        if (charSequence.length() == 5) {
            if (lf.e(this.et_train_number) == 0) {
                str = "Enter Train Number";
            } else if (lf.e(this.et_train_number) != 5) {
                str = "Invalid Train Number";
            } else {
                str = "ok";
            }
            if (str.equalsIgnoreCase("ok")) {
                this.et_train_number.setError((CharSequence) null);
                this.et_train_number.setTextColor(-16777216);
            } else {
                this.et_train_number.setError(str);
                this.et_train_number.setTextColor(-65536);
            }
            this.et_train_number.clearFocus();
        }
    }

    public class c implements Runnable {
        public final void run() {
        }
    }
}
