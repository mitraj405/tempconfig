package cris.org.in.ima;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.fragment.ERSFragment;
import cris.org.in.ima.fragment.TicketStatusFragment;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import rx.Subscriber;

public class FeedbackActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final /* synthetic */ int g = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public ImageView f4129a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4130a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4131a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, Integer> f4132a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final C1395ss f4133a = new C1395ss();
    public ImageView b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<C1413ts> f4134b = new ArrayList<>();
    @BindView(2131362015)
    ImageView back_btn;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public ImageView f4135c;
    @BindView(2131362323)
    TextView criteria;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public ImageView f4136d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public ImageView f4137e;
    public int f;
    @BindView(2131364114)
    TextView tv_remarks;
    @BindView(2131364601)
    TextView tv_skip;
    @BindView(2131364622)
    TextView tv_submit;

    public class a implements View.OnClickListener {
        public final /* synthetic */ TextView a;

        /* renamed from: cris.org.in.ima.FeedbackActivity$a$a  reason: collision with other inner class name */
        public class C0056a implements OnSelectionListener {
            public C0056a() {
            }

            public final void onClick(String str) {
                a aVar = a.this;
                aVar.a.setText(str);
                FeedbackActivity feedbackActivity = FeedbackActivity.this;
                feedbackActivity.d = feedbackActivity.f4132a.get(str).intValue();
                FeedbackActivity.this.f4130a.dismiss();
            }
        }

        public a(TextView textView) {
            this.a = textView;
        }

        public final void onClick(View view) {
            int i = FeedbackActivity.g;
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.m();
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            feedbackActivity.f4130a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            feedbackActivity.f4130a.show(feedbackActivity.getSupportFragmentManager(), "");
            feedbackActivity.f4130a.setCancelable(true);
            feedbackActivity.getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(feedbackActivity.getBaseContext(), feedbackActivity.f4131a, new C0056a());
            feedbackActivity.f4130a.g().setText(feedbackActivity.getString(R.string.select_rating_criteria));
            feedbackActivity.f4130a.f().setAdapter(customAdapter);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;

        public c(TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        public final void onClick(View view) {
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.c = 1;
            FeedbackActivity.l(feedbackActivity, 1);
            this.a.setHint(R.string.remarks_mdt);
            this.b.setVisibility(0);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;

        public d(TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        public final void onClick(View view) {
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.c = 2;
            FeedbackActivity.l(feedbackActivity, 2);
            this.a.setHint(R.string.remarks_mdt);
            this.b.setVisibility(0);
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;

        public e(TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        public final void onClick(View view) {
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.c = 3;
            FeedbackActivity.l(feedbackActivity, 3);
            this.a.setHint(R.string.remarks_mdt);
            this.b.setVisibility(0);
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;

        public f(TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        public final void onClick(View view) {
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.c = 4;
            FeedbackActivity.l(feedbackActivity, 4);
            this.a.setHint(R.string.remarks_mdt);
            this.b.setVisibility(0);
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;

        public g(TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        public final void onClick(View view) {
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            feedbackActivity.c = 5;
            FeedbackActivity.l(feedbackActivity, 5);
            this.a.setHint(R.string.remarks_opt);
            this.b.setVisibility(8);
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ TextView b;

        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                h.this.b.setEnabled(true);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public final void run() {
                h.this.b.setEnabled(true);
            }
        }

        public class c extends Subscriber<StatusDTO> {

            public class a implements Runnable {
                public a() {
                }

                public final void run() {
                    FeedbackActivity.this.finish();
                }
            }

            public c() {
            }

            public final void onCompleted() {
                int i = FeedbackActivity.g;
                FeedbackActivity.this.a.dismiss();
            }

            public final void onError(Throwable th) {
                int i = FeedbackActivity.g;
                th.getClass();
                th.getMessage();
                FeedbackActivity.this.a.dismiss();
                Lt.a(true, th);
                new Handler().postDelayed(new a(), 1000);
            }

            public final void onNext(Object obj) {
                StatusDTO statusDTO = (StatusDTO) obj;
                h hVar = h.this;
                if (statusDTO != null) {
                    try {
                        if (statusDTO.getError() != null) {
                            FeedbackActivity feedbackActivity = FeedbackActivity.this;
                            FeedbackActivity feedbackActivity2 = FeedbackActivity.this;
                            feedbackActivity.a.dismiss();
                            statusDTO.getError();
                            statusDTO.getError();
                            C0535I5.m(FeedbackActivity.this, false, statusDTO.getError(), feedbackActivity2.getString(R.string.error), feedbackActivity2.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        } else if (statusDTO.getError() == null) {
                            String status = statusDTO.getStatus();
                            FeedbackActivity feedbackActivity3 = FeedbackActivity.this;
                            int i = feedbackActivity3.f;
                            if (i == 1) {
                                ERSFragment.c = feedbackActivity3.c;
                            } else if (i == 2) {
                                TicketStatusFragment.d = feedbackActivity3.c;
                            }
                            C0535I5.o(feedbackActivity3, status, feedbackActivity3.getString(R.string.ok), new a(this)).show();
                        } else {
                            FeedbackActivity.this.getClass();
                            C0535I5.t0((Context) null, "ERROR");
                            int i2 = FeedbackActivity.g;
                            FeedbackActivity.this.a.dismiss();
                        }
                    } catch (Exception e) {
                        int i3 = FeedbackActivity.g;
                        e.getMessage();
                        FeedbackActivity.this.a.dismiss();
                    }
                    int i4 = FeedbackActivity.g;
                    statusDTO.toString();
                    return;
                }
                FeedbackActivity.this.getClass();
                C0535I5.t0((Context) null, "ERROR");
                int i5 = FeedbackActivity.g;
                FeedbackActivity.this.a.dismiss();
            }
        }

        public h(TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        public final void onClick(View view) {
            String charSequence = this.a.getText().toString();
            FeedbackActivity feedbackActivity = FeedbackActivity.this;
            int i = feedbackActivity.c;
            if (i >= 5 || feedbackActivity.d >= 1) {
                C1395ss ssVar = feedbackActivity.f4133a;
                ssVar.setRating(i);
                ssVar.setRatingReason(feedbackActivity.d);
                ssVar.setRemarks(charSequence);
                ssVar.setPage(feedbackActivity.f);
                ssVar.setApplication(feedbackActivity.e);
                ProgressDialog show = ProgressDialog.show(feedbackActivity, feedbackActivity.getString(R.string.submtd), feedbackActivity.getString(R.string.please_wait_text));
                feedbackActivity.a = show;
                show.setProgressStyle(0);
                String f = C0657Qt.f();
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).U0(f + "rateUs", ssVar).c(C1181iv.a()).a(E0.a()).b(new c());
                return;
            }
            this.b.setEnabled(false);
            new Handler().postDelayed(new a(), 2000);
            new Handler().postDelayed(new b(), 2000);
            C0535I5.m(feedbackActivity, false, feedbackActivity.getString(R.string.please_select_a_reason), feedbackActivity.getString(R.string.error), feedbackActivity.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public final void onClick(View view) {
            FeedbackActivity.this.finish();
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public final void onClick(View view) {
            FeedbackActivity.this.finish();
        }
    }

    static {
        C1354qp.R(FeedbackActivity.class);
    }

    public static void l(FeedbackActivity feedbackActivity, int i2) {
        feedbackActivity.f4129a.setImageResource(R.drawable.star_outline);
        feedbackActivity.b.setImageResource(R.drawable.star_outline);
        feedbackActivity.f4135c.setImageResource(R.drawable.star_outline);
        feedbackActivity.f4136d.setImageResource(R.drawable.star_outline);
        feedbackActivity.f4137e.setImageResource(R.drawable.star_outline);
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            feedbackActivity.f4137e.setImageResource(R.drawable.star_filled);
                        } else {
                            return;
                        }
                    }
                    feedbackActivity.f4136d.setImageResource(R.drawable.star_filled);
                }
                feedbackActivity.f4135c.setImageResource(R.drawable.star_filled);
            }
            feedbackActivity.b.setImageResource(R.drawable.star_filled);
        }
        feedbackActivity.f4129a.setImageResource(R.drawable.star_filled);
    }

    public final void m() {
        HashMap<String, Integer> hashMap = this.f4132a;
        hashMap.clear();
        ArrayList<String> arrayList = this.f4131a;
        arrayList.clear();
        for (int i2 = 0; i2 < this.f4134b.size(); i2++) {
            hashMap.put(this.f4134b.get(i2).getEn(), Integer.valueOf(this.f4134b.get(i2).getV()));
            arrayList.add(this.f4134b.get(i2).getEn());
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_feedback);
        TextView textView = (TextView) findViewById(R.id.textView_remarks);
        textView.setHint(R.string.remarks_mdt);
        textView.addTextChangedListener(new b(textView));
        TextView textView2 = (TextView) findViewById(R.id.criteria_Rating);
        this.f4134b = C1450w1.f7027d;
        m();
        this.f4129a = (ImageView) findViewById(R.id.star_1);
        this.b = (ImageView) findViewById(R.id.star_2);
        this.f4135c = (ImageView) findViewById(R.id.star_3);
        this.f4136d = (ImageView) findViewById(R.id.star_4);
        this.f4137e = (ImageView) findViewById(R.id.star_5);
        this.f4129a.setOnClickListener(new c(textView, textView2));
        this.b.setOnClickListener(new d(textView, textView2));
        this.f4135c.setOnClickListener(new e(textView, textView2));
        this.f4136d.setOnClickListener(new f(textView, textView2));
        this.f4137e.setOnClickListener(new g(textView, textView2));
        Intent intent = getIntent();
        int parseInt = Integer.parseInt(intent.getStringExtra("message_key"));
        if (parseInt == 1) {
            this.f4129a.callOnClick();
        } else if (parseInt == 2) {
            this.b.callOnClick();
        } else if (parseInt == 3) {
            this.f4135c.callOnClick();
        } else if (parseInt == 4) {
            this.f4136d.callOnClick();
        } else if (parseInt == 5) {
            this.f4137e.callOnClick();
        }
        this.e = 1;
        if (C0535I5.f3625a) {
            this.e = 2;
        }
        this.f = Integer.parseInt(intent.getStringExtra("camefrompage"));
        TextView textView3 = (TextView) findViewById(R.id.tv_submit);
        textView3.setOnClickListener(new h(textView, textView3));
        ((TextView) findViewById(R.id.tv_skip)).setOnClickListener(new i());
        ((ImageView) findViewById(R.id.back)).setOnClickListener(new j());
        ((TextView) findViewById(R.id.criteria_Rating)).setOnClickListener(new a(textView2));
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    public class b implements TextWatcher {
        public final /* synthetic */ TextView a;

        public b(TextView textView) {
            this.a = textView;
        }

        public final void afterTextChanged(Editable editable) {
            Boolean bool;
            String obj = editable.toString();
            int i = FeedbackActivity.g;
            FeedbackActivity.this.getClass();
            if (!Pattern.compile("^[A-Za-z\\s]*$").matcher(obj).matches()) {
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
            boolean booleanValue = bool.booleanValue();
            TextView textView = this.a;
            if (!booleanValue) {
                textView.setError("No Special Character and Numeric values Allowed.");
            } else {
                textView.setError((CharSequence) null);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
    }
}
