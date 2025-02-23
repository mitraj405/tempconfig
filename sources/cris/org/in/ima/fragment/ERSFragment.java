package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.gson.Gson;
import cris.org.in.ima.FeedbackActivity;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.adaptors.MealDetaillViewHolder;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.ima.model.StationModel;
import cris.org.in.ima.view_holder.ErsPassengerViewHolder;
import cris.org.in.ima.view_holder.ErsTrainDeatilLapwiseViewHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.MealItemDetails;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import cris.prs.webservices.dto.StatusDTO;
import defpackage.d7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import rx.Subscriber;

public class ERSFragment extends Fragment {
    public static int c;
    @BindView(2131364781)
    TextView UgstAmt;
    @BindView(2131364784)
    TextView UgstRate;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public ImageView f4546a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4547a;

    /* renamed from: a  reason: collision with other field name */
    public BookingResponseDTO f4548a;

    /* renamed from: a  reason: collision with other field name */
    public C1074dm f4549a;

    /* renamed from: a  reason: collision with other field name */
    public Double f4550a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<MealItemDetails> f4551a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4552a = false;
    @BindView(2131361906)
    RelativeLayout add_meal_rl;
    @BindView(2131362749)
    TextView address;
    @BindView(2131361933)
    LinearLayout allGstDtlLayout;
    @BindView(2131361960)
    TextView arvDate;
    @BindView(2131361961)
    TextView arvTime;
    @BindView(2131361998)
    TextView attention_msg;
    @BindView(2131361999)
    TextView attention_msg1;
    public ImageView b;

    /* renamed from: b  reason: collision with other field name */
    public BookingResponseDTO f4553b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<String> f4554b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4555b = false;
    @BindView(2131362024)
    TextView basefare;

    /* renamed from: c  reason: collision with other field name */
    public ImageView f4556c;

    /* renamed from: c  reason: collision with other field name */
    public String f4557c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<String> f4558c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4559c;
    @BindView(2131362160)
    TextView cgstAmt;
    @BindView(2131362162)
    RelativeLayout cgstLayout;
    @BindView(2131362163)
    TextView cgstRate;
    @BindView(2131362748)
    TextView city;
    @BindView(2131362262)
    TextView clsQtBoarding;
    @BindView(2131362263)
    LinearLayout cnfBtnLayout;
    @BindView(2131362264)
    TextView cnfCheckCetails;
    @BindView(2131362295)
    TextView connectingPnr;
    @BindView(2131362297)
    LinearLayout connectingPnrLayout;
    @BindView(2131362315)
    TextView conviencefee;
    public ImageView d;

    /* renamed from: d  reason: collision with other field name */
    public final String f4560d;
    @BindView(2131362395)
    TextView deptDate;
    @BindView(2131362396)
    TextView deptTime;
    @BindView(2131362447)
    ImageView downloadpdf;
    public ImageView e;

    /* renamed from: e  reason: collision with other field name */
    public String f4561e;
    @BindView(2131364395)
    TextView ersMsg;
    @BindView(2131362509)
    AdManagerAdView ersPageCenterAds;
    @BindView(2131362643)
    LinearLayout feedback_ll;
    @BindView(2131362712)
    TextView fromStation;
    @BindView(2131362720)
    LinearLayout funda_duty_detail_ll;
    @BindView(2131362722)
    RelativeLayout funda_duty_ll;
    @BindView(2131362723)
    TextView funda_duty_msg;
    @BindView(2131363033)
    LinearLayout gstBreakupLayout;
    @BindView(2131362751)
    TextView gstnRceiptId;
    @BindView(2131362752)
    LinearLayout gstnRecptInfo;
    @BindView(2131362755)
    TextView gstnStateName;
    @BindView(2131362754)
    TextView gstnSuplierCode;
    @BindView(2131362817)
    TextView igstAmt;
    @BindView(2131362819)
    RelativeLayout igstLayout;
    @BindView(2131362820)
    TextView igstRate;
    @BindView(2131362843)
    LinearLayout informationLayout;
    @BindView(2131362844)
    LinearLayout informationLayout_lap2;
    @BindView(2131362845)
    TextView informationMsg;
    @BindView(2131362846)
    TextView informationMsg_lap2;
    @BindView(2131362934)
    TextView lap1;
    @BindView(2131362937)
    TextView lap2;
    @BindView(2131362942)
    TextView lapType;
    @BindView(2131363124)
    RecyclerView lvaddmeal;
    @BindView(2131363202)
    LinearLayout meal_detail_lap2;
    @BindView(2131363203)
    LinearLayout mealdetail_ll;
    @BindView(2131363213)
    LinearLayout messages_lap1;
    @BindView(2131363214)
    LinearLayout messages_lap2;
    @BindView(2131363248)
    ImageView mpImage;
    @BindView(2131363249)
    LinearLayout mpImageLayout;
    @BindView(2131363296)
    TextView name;
    @BindView(2131363386)
    TextView orderfood_Pantry_Car;
    @BindView(2131363474)
    RelativeLayout payment_from;
    @BindView(2131363475)
    TextView paymentmode;
    @BindView(2131362750)
    TextView pincode;
    @BindView(2131363518)
    TextView pnrNo;
    @BindView(2131363527)
    TextView pre;
    @BindView(2131363546)
    LinearLayout psgnCount;
    @BindView(2131363549)
    RecyclerView psgnList;
    @BindView(2131363550)
    RecyclerView psgnList_lap2;
    @BindView(2131363574)
    ImageView qr_code;
    @BindView(2131363598)
    View recipient_view;
    @BindView(2131363675)
    TextView replan;
    @BindView(2131363759)
    RelativeLayout rl_psgnlisr;
    @BindView(2131363803)
    RecyclerView rv_addmeal_list;
    @BindView(2131363804)
    RecyclerView rv_addmeal_list_lap2;
    @BindView(2131364194)
    RecyclerView rv_train_detail;
    @BindView(2131363843)
    TextView sacNumber;
    @BindView(2131364155)
    NestedScrollView scrollView;
    @BindView(2131363943)
    ImageView send_mail_pdf;
    @BindView(2131363948)
    TextView sgstAmt;
    @BindView(2131363950)
    RelativeLayout sgstLayoutId;
    @BindView(2131363951)
    TextView sgstRate;
    @BindView(2131362753)
    TextView state;
    @BindView(2131364062)
    LinearLayout tain_detail_ll;
    @BindView(2131364137)
    RelativeLayout ticket_charge_rl;
    @BindView(2131364160)
    TextView tktSentMsg;
    @BindView(2131364167)
    TextView toStation;
    @BindView(2131364184)
    TextView totalFare;
    @BindView(2131364187)
    TextView totalTax;
    @BindView(2131364068)
    TextView totalValuableTax;
    @BindView(2131364677)
    TextView total_amount;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364203)
    TextView trainNo;
    @BindView(2131364214)
    TextView transactionId;
    @BindView(2131364236)
    TextView travelInsurance;
    @BindView(2131364247)
    TextView travelTime;
    @BindView(2131364250)
    LinearLayout traveltime_ll;
    @BindView(2131364323)
    TextView tv_bus;
    @BindView(2131364325)
    TextView tv_cancellation_policy;
    @BindView(2131364383)
    TextView tv_done_meal;
    @BindView(2131364396)
    TextView tv_ers_msgs_lap2;
    @BindView(2131364626)
    TextView tv_tab_delhi_metro;
    @BindView(2131364648)
    TextView tv_tab_upcoming_journey_hotel;
    @BindView(2131364649)
    TextView tv_tab_upcoming_journey_mot;
    @BindView(2131364651)
    TextView tv_tab_upcoming_journey_retroom;
    @BindView(2131364783)
    RelativeLayout ugstLayout;
    @BindView(2131364725)
    TextView vigilanceMsg;

    public class a implements OnSelectionListener {

        /* renamed from: cris.org.in.ima.fragment.ERSFragment$a$a  reason: collision with other inner class name */
        public class C0062a implements Runnable {
            public final /* synthetic */ Toast a;

            public C0062a(Toast toast) {
                this.a = toast;
            }

            public final void run() {
                if (ERSFragment.this.f4559c) {
                    try {
                        Thread.sleep(100);
                        this.a.show();
                        Thread.sleep(100);
                    } catch (Exception e) {
                        int i = ERSFragment.c;
                        e.getMessage();
                    }
                }
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ Toast a;

            public b(Toast toast) {
                this.a = toast;
            }

            public final void run() {
                if (ERSFragment.this.f4559c) {
                    try {
                        Thread.sleep(100);
                        this.a.show();
                        Thread.sleep(100);
                    } catch (Exception e) {
                        int i = ERSFragment.c;
                        e.getMessage();
                    }
                }
            }
        }

        public a() {
        }

        public final void onClick(String str) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4547a.dismiss();
            if (str.equalsIgnoreCase("Destination-1")) {
                if (eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YY") || eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YN")) {
                    C0535I5.o(eRSFragment.a, eRSFragment.getResources().getString(R.string.hotel_covid19_msg), eRSFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    new Thread(new C0062a(Toast.makeText(eRSFragment.getContext(), eRSFragment.getString(R.string.unble_toconnect_server2), 1))).start();
                    return;
                }
                C0535I5.p(eRSFragment.getActivity(), false, eRSFragment.getString(R.string.this_facility_not_available_LAP_1), eRSFragment.getString(R.string.info), eRSFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
            } else if (eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YY") || eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YN")) {
                C0535I5.o(eRSFragment.a, eRSFragment.getResources().getString(R.string.hotel_covid19_msg), eRSFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                new Thread(new b(Toast.makeText(eRSFragment.getContext(), eRSFragment.getString(R.string.unble_toconnect_server2), 1))).start();
            } else {
                C0535I5.p(eRSFragment.getActivity(), false, eRSFragment.getString(R.string.this_facility_not_available_LAP_2), eRSFragment.getString(R.string.info), eRSFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Toast a;

        public b(Toast toast) {
            this.a = toast;
        }

        public final void run() {
            Toast toast = this.a;
            ERSFragment eRSFragment = ERSFragment.this;
            try {
                ERSFragment eRSFragment2 = ERSFragment.this;
                eRSFragment2.j("HB", eRSFragment2.f4548a.getPnrNumber(), eRSFragment.f4548a.getReservationId(), C0535I5.y(eRSFragment.f4548a.getDestArrvDate()), eRSFragment.f4548a.getDestStn());
            } catch (Exception e) {
                if (eRSFragment.f4559c) {
                    try {
                        Thread.sleep(100);
                        toast.show();
                        Thread.sleep(100);
                    } catch (Exception e2) {
                        int i = ERSFragment.c;
                        e2.getMessage();
                    }
                }
                int i2 = ERSFragment.c;
                e.getMessage();
            }
            if (eRSFragment.f4559c) {
                try {
                    Thread.sleep(100);
                    toast.show();
                    Thread.sleep(100);
                } catch (Exception e3) {
                    int i3 = ERSFragment.c;
                    e3.getMessage();
                }
            }
        }
    }

    public class c implements OnSelectionListener {

        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                c cVar = c.this;
                try {
                    ERSFragment eRSFragment = ERSFragment.this;
                    eRSFragment.j("RR", eRSFragment.f4548a.getPnrNumber(), ERSFragment.this.f4548a.getReservationId(), C0535I5.y(ERSFragment.this.f4548a.getDestArrvDate()), ERSFragment.this.f4548a.getDestStn());
                } catch (Exception e) {
                    int i = ERSFragment.c;
                    e.getMessage();
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public final void run() {
                c cVar = c.this;
                try {
                    ERSFragment eRSFragment = ERSFragment.this;
                    eRSFragment.j("RR", eRSFragment.f4553b.getPnrNumber(), ERSFragment.this.f4553b.getReservationId(), C0535I5.y(ERSFragment.this.f4553b.getDestArrvDate()), ERSFragment.this.f4553b.getDestStn());
                } catch (Exception e) {
                    int i = ERSFragment.c;
                    e.getMessage();
                }
            }
        }

        public c() {
        }

        public final void onClick(String str) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4547a.dismiss();
            if (str.equalsIgnoreCase("Destination-1")) {
                if (eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YY") || eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YN")) {
                    new Thread(new a()).start();
                } else {
                    C0535I5.p(eRSFragment.getActivity(), false, eRSFragment.getString(R.string.this_facility_not_available_LAP_1), eRSFragment.getString(R.string.info), eRSFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                }
            } else if (eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YY") || eRSFragment.f4548a.getRrHbFlag().equalsIgnoreCase("YN")) {
                new Thread(new b()).start();
            } else {
                C0535I5.p(eRSFragment.getActivity(), false, eRSFragment.getString(R.string.this_facility_not_available_LAP_2), eRSFragment.getString(R.string.info), eRSFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public final void run() {
            ERSFragment eRSFragment = ERSFragment.this;
            try {
                ERSFragment eRSFragment2 = ERSFragment.this;
                eRSFragment2.j("RR", eRSFragment2.f4548a.getPnrNumber(), eRSFragment.f4548a.getReservationId(), C0535I5.y(eRSFragment.f4548a.getDestArrvDate()), eRSFragment.f4548a.getDestStn());
            } catch (Exception e) {
                int i = ERSFragment.c;
                e.getMessage();
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public final void run() {
            ERSFragment eRSFragment = ERSFragment.this;
            try {
                eRSFragment.f(eRSFragment.f4548a.getPnrNumber(), eRSFragment.f4548a.getReservationId(), C0535I5.y(eRSFragment.f4548a.getDestArrvDate()), eRSFragment.f4548a.getDestStn());
            } catch (Exception e) {
                int i = ERSFragment.c;
                e.getMessage();
            }
        }
    }

    public class f implements OnSelectionListener {
        public f() {
        }

        public final void onClick(String str) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4547a.dismiss();
            if (str.equalsIgnoreCase("LAP-1")) {
                C0535I5.o(eRSFragment.a, eRSFragment.getString(R.string.Catering_Meal_COVID_19_situation), eRSFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else if (C0535I5.f3647h) {
                C0535I5.o(eRSFragment.a, eRSFragment.getString(R.string.Catering_Meal_COVID_19_situation), eRSFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class g extends ClickableSpan {
        public g() {
        }

        public final void onClick(View view) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(eRSFragment.getString(R.string.tnc_vikalp))));
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    public class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ BookingResponseDTO f4565a;

        public h(BookingResponseDTO bookingResponseDTO) {
            this.f4565a = bookingResponseDTO;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2 = ERSFragment.c;
            ERSFragment eRSFragment = ERSFragment.this;
            if (!C0535I5.O((ConnectivityManager) eRSFragment.getActivity().getSystemService("connectivity"), eRSFragment.getContext())) {
                new Handler().postDelayed(new O9(), 5000);
                return;
            }
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                ProgressDialog progressDialog = new ProgressDialog(eRSFragment.getActivity());
                progressDialog.requestWindowFeature(1);
                progressDialog.setMessage(eRSFragment.getString(R.string.please_wait_text));
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                String f = C0657Qt.f();
                BookingResponseDTO bookingResponseDTO = this.f4565a;
                String format = String.format("/%s", new Object[]{Long.valueOf(Long.parseLong(bookingResponseDTO.getReservationId()))});
                ((Om) C0657Qt.c(b1Var.f3912a)).x1(f + "vikalpTrainList" + format).c(C1181iv.a()).a(E0.a()).b(new P9(eRSFragment, progressDialog, bookingResponseDTO));
                return;
            }
            C0535I5.m(eRSFragment.getActivity(), false, eRSFragment.getResources().getString(R.string.data_connection_error_message), eRSFragment.getString(R.string.error), eRSFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public class j implements DialogInterface.OnClickListener {
        public j() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ERSFragment eRSFragment = ERSFragment.this;
            ERSFragment.g(eRSFragment.a, eRSFragment.f4548a, eRSFragment.f4561e);
        }
    }

    public class l extends Subscriber<StatusDTO> {
        public final void onCompleted() {
            int i = ERSFragment.c;
        }

        public final void onError(Throwable th) {
            int i = ERSFragment.c;
            xx.S(th, true, th);
        }

        public final /* bridge */ /* synthetic */ void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
        }
    }

    public class n implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        public final void onClick(View view) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4557c = C0515Ga.AVLBLTY_ONLY;
            eRSFragment.o(1);
            Intent intent = new Intent(eRSFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", eRSFragment.f4557c);
            intent.putExtra("camefrompage", eRSFragment.f4560d);
            eRSFragment.startActivity(intent);
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        public final void onClick(View view) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4557c = C0515Ga.FARE_ONLY;
            eRSFragment.o(2);
            Intent intent = new Intent(eRSFragment.a, FeedbackActivity.class);
            intent.putExtra("message_key", eRSFragment.f4557c);
            intent.putExtra("camefrompage", eRSFragment.f4560d);
            eRSFragment.startActivity(intent);
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        public final void onClick(View view) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4557c = C0515Ga.FARE_AVLBLTY;
            eRSFragment.o(3);
            Intent intent = new Intent(eRSFragment.getContext(), FeedbackActivity.class);
            intent.putExtra("message_key", eRSFragment.f4557c);
            intent.putExtra("camefrompage", eRSFragment.f4560d);
            eRSFragment.startActivity(intent);
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        public final void onClick(View view) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4557c = "4";
            eRSFragment.o(4);
            Intent intent = new Intent(eRSFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", eRSFragment.f4557c);
            intent.putExtra("camefrompage", eRSFragment.f4560d);
            eRSFragment.startActivity(intent);
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        public final void onClick(View view) {
            ERSFragment eRSFragment = ERSFragment.this;
            eRSFragment.f4557c = "5";
            eRSFragment.o(5);
            Intent intent = new Intent(eRSFragment.getActivity(), FeedbackActivity.class);
            intent.putExtra("message_key", eRSFragment.f4557c);
            intent.putExtra("camefrompage", eRSFragment.f4560d);
            eRSFragment.startActivity(intent);
        }
    }

    public class t extends Subscriber<Wp> {
        public final /* synthetic */ Context a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ BookingResponseDTO f4566a;
        public final /* synthetic */ String c;

        public t(Context context, BookingResponseDTO bookingResponseDTO, String str) {
            this.a = context;
            this.f4566a = bookingResponseDTO;
            this.c = str;
        }

        public final void onCompleted() {
            int i = ERSFragment.c;
        }

        public final void onError(Throwable th) {
            int i = ERSFragment.c;
            th.getMessage();
        }

        public final void onNext(Object obj) {
            Wp wp = (Wp) obj;
            int i = ERSFragment.c;
            Context context = this.a;
            if (wp == null) {
                C0535I5.m(context, false, context.getString(R.string.unable_process_message), context.getString(R.string.error), context.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (wp.isDirectBooking()) {
                C0535I5.p(this.a, true, wp.getMessage(), context.getString(R.string.confirmation), context.getString(R.string.retry), new G(this), context.getString(R.string.cancel), new H()).show();
            } else if (wp.getError() == null) {
                Bw e = Bw.e(context);
                boolean isEmpty = e.b().isEmpty();
                String str = this.c;
                BookingResponseDTO bookingResponseDTO = this.f4566a;
                if (isEmpty || e.b() == null || e.a().isEmpty() || e.a() == null) {
                    C1223kn knVar = C0793b1.a.f3912a;
                    if (knVar != null) {
                        String j = C0657Qt.j();
                        ((Om) C0657Qt.c(knVar)).l0(j + "dmrcStations").c(C1181iv.a()).a(E0.a()).b(new L9(context, bookingResponseDTO, str));
                        return;
                    }
                    C0535I5.m(context, false, context.getResources().getString(R.string.data_connection_error_message), context.getString(R.string.error), context.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("pnr", bookingResponseDTO.getPnrNumber());
                    bundle.putString("insuranceOpted", bookingResponseDTO.getInsuranceOpted());
                    bundle.putSerializable("deptDate", bookingResponseDTO.getBoardingDate());
                    bundle.putSerializable("arvDate", bookingResponseDTO.getDestArrvDate());
                    if (bookingResponseDTO.getNoOfBkdPsgn() != null) {
                        if (bookingResponseDTO.getTransactionId() != null) {
                            bundle.putString("noOfBkdPsgn", bookingResponseDTO.getNoOfBkdPsgn());
                            bundle.putString("noOfBkdChild", bookingResponseDTO.getNoOfBkdChild());
                            bundle.putString("transactionId", bookingResponseDTO.getTransactionId());
                            bundle.putString("fromStnCode", bookingResponseDTO.getFromStn());
                            bundle.putString("toStnCode", bookingResponseDTO.getDestStn());
                            DelhiMetroFragment delhiMetroFragment = new DelhiMetroFragment();
                            delhiMetroFragment.setArguments(bundle);
                            HomeActivity.B(context);
                            HomeActivity.n(context, delhiMetroFragment, C1218kf.SEARCH_METRO.a(), Boolean.TRUE, Boolean.FALSE);
                        }
                    }
                    bundle.putString("noOfBkdPsgn", String.valueOf(bookingResponseDTO.getNumberOfpassenger()));
                    bundle.putString("noOfBkdChild", String.valueOf(bookingResponseDTO.getNumberOfChilds()));
                    bundle.putString("transactionId", str);
                    bundle.putString("fromStnCode", bookingResponseDTO.getFromStn());
                    bundle.putString("toStnCode", bookingResponseDTO.getDestStn());
                    DelhiMetroFragment delhiMetroFragment2 = new DelhiMetroFragment();
                    delhiMetroFragment2.setArguments(bundle);
                    HomeActivity.B(context);
                    HomeActivity.n(context, delhiMetroFragment2, C1218kf.SEARCH_METRO.a(), Boolean.TRUE, Boolean.FALSE);
                } catch (Exception e2) {
                    int i2 = ERSFragment.c;
                    e2.getMessage();
                }
            } else {
                C0535I5.m(this.a, false, wp.getError(), context.getString(R.string.information), context.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    static {
        C1354qp.R(ERSFragment.class);
    }

    public ERSFragment() {
        new SimpleDateFormat("HH:mm");
        this.f4551a = new ArrayList<>();
        this.f4554b = null;
        this.f4558c = null;
        this.f4559c = false;
        this.f4557c = "";
        this.f4560d = String.valueOf(1);
    }

    public static void g(Context context, BookingResponseDTO bookingResponseDTO, String str) {
        C1223kn knVar = C0793b1.a.f3912a;
        if (knVar != null) {
            String z = C1058d.z(C0657Qt.j(), "checkForDMRC");
            C0766Zb zb = new C0766Zb();
            zb.setPnrNumber(bookingResponseDTO.getPnrNumber());
            zb.setTxnId(bookingResponseDTO.getTransactionId());
            ((Om) C0657Qt.c(knVar)).E(z, zb).c(C1181iv.a()).a(E0.a()).b(new t(context, bookingResponseDTO, str));
            return;
        }
        C0535I5.m(context, false, context.getString(R.string.data_connection_error_message), context.getString(R.string.error), context.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public final void f(String str, String str2, String str3, String str4) {
        OutputStream outputStream;
        BufferedReader bufferedReader;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://www.bus.irctc.co.in/IrctcBus/api/busIrctc/swtchBus").openConnection()));
            httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json, text/plain, */*");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "utf-8, deflate, br");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5");
            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
            HashMap hashMap = new HashMap();
            hashMap.put("uname", Bw.e(getContext()).h());
            hashMap.put("stCode", str4);
            hashMap.put("tkn", C0793b1.a.f3912a.getAccess_token());
            hashMap.put("pnr", str);
            hashMap.put("jdt", str3);
            hashMap.put("tid", str2);
            hashMap.put("type", "BUS");
            String json = new Gson().toJson((Object) hashMap);
            outputStream = httpURLConnection.getOutputStream();
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                C0535I5.t0(this.a, getResources().getString(R.string.unble_toconnect_server));
                return;
            }
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            new String(readLine.getBytes(StandardCharsets.UTF_8));
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(readLine));
                            startActivity(intent);
                        } else {
                            bufferedReader.close();
                            inputStreamReader.close();
                            httpURLConnection.disconnect();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    inputStreamReader.close();
                    throw th;
                }
            } catch (Throwable th2) {
                httpURLConnection.disconnect();
                throw th2;
            }
            throw th;
            throw th;
        } catch (Exception e2) {
            e2.getMessage();
            this.f4559c = true;
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    public final Date h(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        instance.set(11, instance2.get(11));
        instance.set(12, instance2.get(12));
        instance.set(13, instance2.get(13));
        instance.set(14, instance2.get(14));
        return instance.getTime();
    }

    public final void i(BookingResponseDTO bookingResponseDTO) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.vikalpMessage));
        Context context = this.a;
        Object obj = d7.a;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.light_yellow));
        StyleSpan styleSpan = new StyleSpan(1);
        g gVar = new g();
        try {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                spannableStringBuilder.setSpan(styleSpan, 66, 81, 18);
                spannableStringBuilder.setSpan(gVar, 66, 81, 33);
                spannableStringBuilder.setSpan(foregroundColorSpan, 66, 81, 18);
            } else {
                spannableStringBuilder.setSpan(styleSpan, 40, 50, 18);
                spannableStringBuilder.setSpan(gVar, 40, 50, 33);
                spannableStringBuilder.setSpan(foregroundColorSpan, 40, 50, 18);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        TextView textView = new TextView(this.a);
        builder.setTitle((CharSequence) getResources().getString(R.string.terms_tnc_vikalp));
        textView.setPadding(40, 30, 40, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(40, 30, 40, 0);
        textView.setLayoutParams(layoutParams);
        builder.setView((View) textView);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        builder.setPositiveButton((CharSequence) getString(R.string.accept), (DialogInterface.OnClickListener) new h(bookingResponseDTO));
        builder.setNegativeButton((CharSequence) getString(R.string.decline), (DialogInterface.OnClickListener) new i());
        builder.show();
    }

    public final void j(String str, String str2, String str3, String str4, String str5) {
        OutputStream outputStream;
        BufferedReader bufferedReader;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL("https://www.rr.irctc.co.in/RetServc/Irctc/swtch").openConnection()));
            httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json, text/plain, */*");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "utf-8, deflate, br");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5");
            httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
            HashMap hashMap = new HashMap();
            hashMap.put("tkn", C0793b1.a.f3912a.getAccess_token());
            hashMap.put("tid", str3);
            hashMap.put("uname", Bw.e(getContext()).h());
            hashMap.put("type", str);
            hashMap.put("pnr", str2);
            if (str.equals("HB")) {
                hashMap.put("stCode", str5);
                hashMap.put("jdt", str4);
            }
            String json = new Gson().toJson((Object) hashMap);
            outputStream = httpURLConnection.getOutputStream();
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                C0535I5.t0(this.a, getResources().getString(R.string.unble_toconnect_server));
                return;
            }
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            new String(readLine.getBytes(StandardCharsets.UTF_8));
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(readLine));
                            startActivity(intent);
                        } else {
                            bufferedReader.close();
                            inputStreamReader.close();
                            httpURLConnection.disconnect();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    inputStreamReader.close();
                    throw th;
                }
            } catch (Throwable th2) {
                httpURLConnection.disconnect();
                throw th2;
            }
            throw th;
            throw th;
        } catch (Exception e2) {
            e2.getMessage();
            this.f4559c = true;
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[Catch:{ WriterException -> 0x007f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k() {
        /*
            r10 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = ""
            dm r2 = r10.f4549a
            java.lang.String r2 = r2.getQrCodeText()
            byte[] r2 = r2.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0023 }
            java.lang.String r3 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0023 }
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ UnsupportedEncodingException -> 0x0023 }
            r3.<init>(r2, r0)     // Catch:{ UnsupportedEncodingException -> 0x0023 }
            java.lang.String r0 = "₹"
            java.lang.String r1 = "Rs."
            java.lang.String r0 = r3.replaceAll(r0, r1)     // Catch:{ UnsupportedEncodingException -> 0x0020 }
            goto L_0x0028
        L_0x0020:
            r0 = move-exception
            r1 = r3
            goto L_0x0024
        L_0x0023:
            r0 = move-exception
        L_0x0024:
            r0.getMessage()
            r0 = r1
        L_0x0028:
            java.lang.StringBuilder r0 = defpackage.xx.J(r0)
            com.google.zxing.MultiFormatWriter r1 = new com.google.zxing.MultiFormatWriter
            r1.<init>()
            java.lang.String r0 = r0.toString()     // Catch:{ WriterException -> 0x007f }
            com.google.zxing.BarcodeFormat r2 = com.google.zxing.BarcodeFormat.QR_CODE     // Catch:{ WriterException -> 0x007f }
            r3 = 300(0x12c, float:4.2E-43)
            com.google.zxing.common.BitMatrix r0 = r1.encode(r0, r2, r3, r3)     // Catch:{ WriterException -> 0x007f }
            int r7 = r0.getWidth()     // Catch:{ WriterException -> 0x007f }
            int r8 = r0.getHeight()     // Catch:{ WriterException -> 0x007f }
            int r1 = r7 * r8
            int[] r2 = new int[r1]     // Catch:{ WriterException -> 0x007f }
            r9 = 0
            r1 = r9
        L_0x004b:
            if (r1 >= r8) goto L_0x0066
            int r3 = r1 * r7
            r4 = r9
        L_0x0050:
            if (r4 >= r7) goto L_0x0063
            int r5 = r3 + r4
            boolean r6 = r0.get(r4, r1)     // Catch:{ WriterException -> 0x007f }
            if (r6 == 0) goto L_0x005d
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x005e
        L_0x005d:
            r6 = -1
        L_0x005e:
            r2[r5] = r6     // Catch:{ WriterException -> 0x007f }
            int r4 = r4 + 1
            goto L_0x0050
        L_0x0063:
            int r1 = r1 + 1
            goto L_0x004b
        L_0x0066:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ WriterException -> 0x007f }
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r7, r8, r0)     // Catch:{ WriterException -> 0x007f }
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r0
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ WriterException -> 0x007f }
            android.widget.ImageView r1 = r10.qr_code     // Catch:{ WriterException -> 0x007f }
            r1.setImageBitmap(r0)     // Catch:{ WriterException -> 0x007f }
            android.widget.ImageView r0 = r10.qr_code     // Catch:{ WriterException -> 0x007f }
            r0.setVisibility(r9)     // Catch:{ WriterException -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            r0.getMessage()
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ERSFragment.k():void");
    }

    public final void l(BookingResponseDTO bookingResponseDTO) {
        if (bookingResponseDTO.getGstFlag() == null || !bookingResponseDTO.getGstFlag().booleanValue()) {
            this.allGstDtlLayout.setVisibility(8);
            return;
        }
        this.allGstDtlLayout.setVisibility(0);
        if (bookingResponseDTO.getGstCharge().getGstinSuplier() != null) {
            this.gstnSuplierCode.setVisibility(0);
            this.gstnSuplierCode.setText(bookingResponseDTO.getGstCharge().getGstinSuplier());
        }
        if (bookingResponseDTO.getGstCharge().getSacCode() != null) {
            this.sacNumber.setText(String.valueOf(bookingResponseDTO.getGstCharge().getSacCode()));
            this.sacNumber.setVisibility(0);
        }
        if (bookingResponseDTO.getGstCharge().getPrsSuplierState() != null) {
            this.gstnStateName.setText(bookingResponseDTO.getGstCharge().getPrsSuplierState());
            this.gstnStateName.setVisibility(0);
        }
        if (bookingResponseDTO.getGstCharge().getPrsSgstCharge() != null && bookingResponseDTO.getGstCharge().getPrsSgstCharge().floatValue() > 0.0f) {
            this.sgstAmt.setText(String.valueOf(bookingResponseDTO.getGstCharge().getPrsSgstCharge()));
            this.sgstRate.setText(String.valueOf(bookingResponseDTO.getGstCharge().getSgstRate()).concat("%"));
            this.gstBreakupLayout.setVisibility(0);
            this.sgstLayoutId.setVisibility(0);
        }
        if (bookingResponseDTO.getGstCharge().getPrsUgstCharge() != null && bookingResponseDTO.getGstCharge().getPrsUgstCharge().floatValue() > 0.0f) {
            this.UgstAmt.setText(String.valueOf(bookingResponseDTO.getGstCharge().getPrsUgstCharge()));
            this.UgstRate.setText(String.valueOf(bookingResponseDTO.getGstCharge().getUgstRate()).concat("%"));
            this.gstBreakupLayout.setVisibility(0);
            this.ugstLayout.setVisibility(0);
        }
        if (bookingResponseDTO.getGstCharge().getPrsCgstCharge() != null && bookingResponseDTO.getGstCharge().getPrsCgstCharge().floatValue() > 0.0f) {
            this.cgstAmt.setText(String.valueOf(bookingResponseDTO.getGstCharge().getPrsCgstCharge()));
            this.cgstRate.setText(String.valueOf(bookingResponseDTO.getGstCharge().getCgstRate()).concat("%"));
            this.gstBreakupLayout.setVisibility(0);
            this.cgstLayout.setVisibility(0);
        }
        if (bookingResponseDTO.getGstCharge().getPrsIgstCharge() != null && bookingResponseDTO.getGstCharge().getPrsIgstCharge().floatValue() > 0.0f) {
            this.igstAmt.setText(String.valueOf(bookingResponseDTO.getGstCharge().getPrsIgstCharge()));
            this.igstRate.setText(String.valueOf(bookingResponseDTO.getGstCharge().getIgstRate()).concat("%"));
            this.gstBreakupLayout.setVisibility(0);
            this.igstLayout.setVisibility(0);
            this.sgstLayoutId.setVisibility(8);
            this.cgstLayout.setVisibility(8);
            this.ugstLayout.setVisibility(8);
        }
        if (bookingResponseDTO.getServiceTax() != null) {
            this.totalTax.setText("₹  ".concat(String.valueOf(bookingResponseDTO.getServiceTax())));
            this.totalTax.setVisibility(0);
        }
        if (bookingResponseDTO.getGstCharge().getTaxableAmt() != null) {
            this.totalValuableTax.setText("₹  ".concat(String.valueOf(new DecimalFormat("#.##").format(bookingResponseDTO.getGstCharge().getTaxableAmt()))));
            this.totalValuableTax.setVisibility(0);
        }
        if (bookingResponseDTO.getGstDetailsDTO() == null) {
            this.gstnRecptInfo.setVisibility(8);
            this.recipient_view.setVisibility(8);
            return;
        }
        if (bookingResponseDTO.getGstDetailsDTO().getGstIn() != null) {
            this.gstnRceiptId.setText(String.valueOf(bookingResponseDTO.getGstDetailsDTO().getGstIn()));
            this.gstnRecptInfo.setVisibility(0);
            this.recipient_view.setVisibility(0);
        }
        if (bookingResponseDTO.getGstDetailsDTO().getArea() != null) {
            this.address.setText(String.valueOf(bookingResponseDTO.getGstDetailsDTO().getFlat()));
        }
        if (bookingResponseDTO.getGstDetailsDTO().getStreet() != null) {
            this.address.setText(String.valueOf(bookingResponseDTO.getGstDetailsDTO().getFlat()));
        }
        if (bookingResponseDTO.getGstDetailsDTO().getCity() != null) {
            this.city.setText(String.valueOf(bookingResponseDTO.getGstDetailsDTO().getArea()));
        }
        if (bookingResponseDTO.getGstDetailsDTO().getState() != null) {
            this.state.setText(String.valueOf(bookingResponseDTO.getGstDetailsDTO().getState()).concat("-"));
        }
        if (bookingResponseDTO.getGstDetailsDTO().getPin() != null) {
            this.pincode.setText(String.valueOf(bookingResponseDTO.getGstDetailsDTO().getPin()));
        }
        if (bookingResponseDTO.getGstDetailsDTO().getNameOnGst() != null) {
            this.name.setText(String.valueOf(bookingResponseDTO.getGstDetailsDTO().getNameOnGst()));
            this.gstnRecptInfo.setVisibility(0);
        }
    }

    public final void m() {
        this.rv_addmeal_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_addmeal_list.setAdapter(new MealDetaillViewHolder(this.a, this.f4551a, (MealDetaillViewHolder.AddMealHolderListener) null));
        q();
    }

    public final void n() {
        this.rv_addmeal_list_lap2.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_addmeal_list_lap2.setAdapter(new MealDetaillViewHolder(this.a, this.f4551a, (MealDetaillViewHolder.AddMealHolderListener) null));
        q();
    }

    public final void o(int i2) {
        this.f4546a.setImageResource(R.drawable.star_outline);
        this.b.setImageResource(R.drawable.star_outline);
        this.f4556c.setImageResource(R.drawable.star_outline);
        this.d.setImageResource(R.drawable.star_outline);
        this.e.setImageResource(R.drawable.star_outline);
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            this.e.setImageResource(R.drawable.star_filled);
                        } else {
                            return;
                        }
                    }
                    this.d.setImageResource(R.drawable.star_filled);
                }
                this.f4556c.setImageResource(R.drawable.star_filled);
            }
            this.b.setImageResource(R.drawable.star_filled);
        }
        this.f4546a.setImageResource(R.drawable.star_filled);
    }

    @OnClick({2131362722})
    public void onClicfundadutymsg(View view) {
        if (this.funda_duty_detail_ll.getVisibility() == 0) {
            this.funda_duty_detail_ll.setVisibility(8);
        } else {
            this.funda_duty_detail_ll.setVisibility(0);
        }
    }

    @OnClick({2131364626})
    public void onClickDelhiMetroIcon(View view) {
        g(this.a, this.f4548a, this.f4561e);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        StringBuilder sb;
        String str3;
        String str4;
        String str5;
        View inflate = layoutInflater.inflate(R.layout.activity_ercticket, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        if (C1450w1.f7028d) {
            this.feedback_ll.setVisibility(0);
        } else {
            this.feedback_ll.setVisibility(8);
        }
        Bundle arguments = getArguments();
        this.a = getContext();
        C0535I5.H(getActivity(), getView());
        if (C1450w1.c == 1) {
            this.downloadpdf.setVisibility(0);
        } else {
            this.downloadpdf.setVisibility(8);
        }
        if (C1450w1.d == 1) {
            this.send_mail_pdf.setVisibility(0);
        } else {
            this.send_mail_pdf.setVisibility(8);
        }
        if (arguments != null) {
            C1074dm dmVar = (C1074dm) arguments.getSerializable("FinalBookingSummary");
            this.f4549a = dmVar;
            this.f4548a = dmVar.getBookingResponseDTO().get(0);
            this.f4561e = String.valueOf(this.f4549a.getTransactionId());
            if (C0535I5.f3647h) {
                this.f4553b = this.f4549a.getBookingResponseDTO().get(1);
            }
        }
        this.f4554b = new ArrayList<>();
        this.f4558c = new ArrayList<>();
        this.f4554b.add("LAP-1");
        this.f4554b.add("LAP-2");
        this.f4558c.add("Destination-1");
        this.f4558c.add("Destination-2");
        C0535I5.f3624a.clear();
        C0535I5.f3650k = false;
        this.attention_msg1.setVisibility(8);
        this.attention_msg.setVisibility(8);
        C0535I5.f3651l = true;
        ArrayList<StationModel> arrayList = C0535I5.f3636d;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<RecentTransactionsDTO> arrayList2 = C0535I5.f3642f;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        ArrayList<RecentTransactionsDTO> arrayList3 = C0535I5.f3644g;
        if (arrayList3 != null) {
            arrayList3.clear();
        }
        if (this.f4548a.isMetroServiceOpted() || !this.f4548a.isEligibleForMetro()) {
            this.tv_tab_delhi_metro.setVisibility(8);
        } else {
            this.tv_tab_delhi_metro.setVisibility(0);
        }
        C0535I5.f3644g = null;
        C0535I5.f3615a = null;
        BookingResponseDTO bookingResponseDTO = this.f4548a;
        if (C1450w1.f7024c && C1450w1.f7029e != null) {
            this.mpImageLayout.setVisibility(0);
            byte[] decode = Base64.decode(C1450w1.f7029e.split(",")[1].getBytes(), 0);
            this.mpImage.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        }
        C0535I5.f3616a.a = this.f4549a.getUserDetail().getShowLastTxn();
        C0535I5.f3616a.f3653a = this.f4549a.getUserDetail().getLastTxnId();
        C0535I5.f3616a.f3654a = this.f4549a.getUserDetail().getLastTxnStatus();
        C0535I5.f3616a.f3655a = this.f4549a.getUserDetail().getLastTxnTimeStamp();
        StationDb stationDb = C0793b1.a.f3911a;
        if (bookingResponseDTO.getDepartureTime() == null || bookingResponseDTO.getArrivalTime() == null) {
            this.travelTime.setVisibility(8);
        } else {
            this.travelTime.setVisibility(0);
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                this.travelTime.setText(C0535I5.A(h(bookingResponseDTO.getBoardingDate(), simpleDateFormat.parse(bookingResponseDTO.getDepartureTime())), h(bookingResponseDTO.getDestArrvDate(), simpleDateFormat.parse(bookingResponseDTO.getArrivalTime()))));
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        this.trainName.setText(bookingResponseDTO.getTrainName());
        this.trainNo.setText("(" + bookingResponseDTO.getTrainNumber() + ")");
        this.pnrNo.setText(bookingResponseDTO.getPnrNumber());
        bookingResponseDTO.getPnrNumber();
        this.fromStation.setText(C0535I5.s0(stationDb.m(bookingResponseDTO.getBoardingStn())) + " (" + bookingResponseDTO.getBoardingStn() + ")");
        this.toStation.setText(C0535I5.s0(stationDb.m(bookingResponseDTO.getDestStn())) + " (" + bookingResponseDTO.getDestStn() + ")");
        this.deptDate.setText(C0535I5.d(bookingResponseDTO.getBoardingDate()));
        if (bookingResponseDTO.getScheduleDepartureFlag() == null || !bookingResponseDTO.getScheduleDepartureFlag().booleanValue()) {
            this.deptTime.setText(" *N.A.");
        } else {
            this.deptTime.setText(C0535I5.g0(bookingResponseDTO.getDepartureTime()));
        }
        this.arvDate.setText(C0535I5.d(bookingResponseDTO.getDestArrvDate()));
        if (bookingResponseDTO.getScheduleArrivalFlag() == null || !bookingResponseDTO.getScheduleArrivalFlag().booleanValue()) {
            this.arvTime.setText(" *N.A.");
        } else {
            this.arvTime.setText(C0535I5.g0(bookingResponseDTO.getArrivalTime()));
        }
        this.transactionId.setText(getString(R.string.Transaction_ID) + this.f4549a.getTransactionId());
        if (bookingResponseDTO.getTotalCollectibleAmount() != null) {
            this.totalFare.setText("₹  " + bookingResponseDTO.getTotalCollectibleAmount().toString());
        }
        if (!(this.f4548a.getWpServiceCharge() == null || this.f4548a.getWpServiceTax() == null)) {
            this.f4550a = Double.valueOf(this.f4548a.getWpServiceTax().doubleValue() + this.f4548a.getWpServiceCharge().doubleValue());
        }
        this.basefare.setText(getString(R.string.rupees) + " " + bookingResponseDTO.getTotalFare().toString());
        Double d2 = this.f4550a;
        if (d2 != null) {
            if (String.valueOf(d2).split("\\.")[1].length() < 2) {
                this.conviencefee.setText("₹  " + String.valueOf(this.f4550a) + "0");
            } else {
                this.conviencefee.setText("₹  ".concat(String.valueOf(this.f4550a)));
            }
        }
        if (bookingResponseDTO.getBankName() != null) {
            this.payment_from.setVisibility(0);
            this.paymentmode.setText(bookingResponseDTO.getBankName());
        } else {
            this.paymentmode.setVisibility(8);
        }
        this.travelInsurance.setVisibility(0);
        if (bookingResponseDTO.getInsuredPsgnCount() == null || bookingResponseDTO.getInsuredPsgnCount().shortValue() <= 0) {
            String str6 = C1480xl.d;
            if (str6 == null || !str6.equals("NA")) {
                this.travelInsurance.setVisibility(0);
                this.travelInsurance.setText(" No");
            } else {
                this.travelInsurance.setVisibility(0);
                this.travelInsurance.setText(" N/A");
            }
        } else {
            this.travelInsurance.setVisibility(0);
            this.travelInsurance.setText(" Yes");
        }
        HashMap<String, String> hashMap = C1450w1.f7018b;
        if ((bookingResponseDTO.getErsGovMsg() == null || !bookingResponseDTO.getErsGovMsg().booleanValue()) && hashMap != null && hashMap.containsKey("ersPopupMsg") && (str5 = hashMap.get("ersPopupMsg")) != null && !str5.equals("")) {
            C0535I5.p(getActivity(), false, str5, "Alert", getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
        }
        if (bookingResponseDTO.getInformationMessage() != null) {
            str = "";
            for (String str7 : bookingResponseDTO.getInformationMessage()) {
                if (str7 != null && !str7.trim().equals("")) {
                    StringBuilder sb2 = new StringBuilder();
                    if (str.length() <= 1 || str.charAt(0) == '*') {
                        str3 = "";
                    } else {
                        str3 = "* ";
                    }
                    sb2.append(str3);
                    sb2.append(str);
                    if (str.length() > 1) {
                        str4 = "\n* ";
                    } else {
                        str4 = "";
                    }
                    str = C0709Uj.j(sb2, str4, str7);
                }
            }
        } else {
            str = "";
        }
        if (!str.trim().equals("")) {
            this.informationLayout.setVisibility(0);
            this.informationMsg.setText(str);
        }
        if (bookingResponseDTO.getErsDisplayMessage() != null) {
            String str8 = "";
            for (String z : this.f4548a.getErsDisplayMessage()) {
                str8 = C1058d.z(C1058d.z(str8, z), "\n\n");
            }
            this.ersMsg.setText(str8);
            this.ersMsg.setVisibility(0);
        } else {
            this.ersMsg.setVisibility(8);
        }
        if (C0535I5.f3647h) {
            if (this.f4553b.getErsDisplayMessage() != null) {
                String str9 = "";
                for (String z2 : this.f4553b.getErsDisplayMessage()) {
                    str9 = C1058d.z(C1058d.z(str9, z2), "\n\n");
                }
                this.tv_ers_msgs_lap2.setText(str9);
                this.tv_ers_msgs_lap2.setVisibility(0);
            } else {
                this.tv_ers_msgs_lap2.setVisibility(8);
            }
        }
        if (this.f4548a.getDutiesMessage() != null) {
            boolean z3 = false;
            String str10 = "";
            for (String next : this.f4548a.getDutiesMessage()) {
                if (z3) {
                    str10 = C1058d.z(C1058d.z(str10, next), "\n");
                }
                z3 = true;
            }
            this.funda_duty_msg.setText(str10);
        } else {
            this.funda_duty_ll.setVisibility(8);
        }
        HashMap<String, String> hashMap2 = C1450w1.f7018b;
        if (hashMap2 == null || !hashMap2.containsKey("pledgeLableMsg") || C1450w1.f7018b.get("pledgeLableMsg") == null) {
            this.vigilanceMsg.setVisibility(8);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.vigilance_msg));
            Context context = getContext();
            Object obj = d7.a;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.blue));
            StyleSpan styleSpan = new StyleSpan(1);
            C0647Q9 q9 = new C0647Q9(this);
            try {
                spannableStringBuilder.setSpan(styleSpan, 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(q9, 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.setSpan(foregroundColorSpan, 0, spannableStringBuilder.length(), 18);
            } catch (Exception e3) {
                e3.getMessage();
            }
            this.vigilanceMsg.setText(spannableStringBuilder);
            this.vigilanceMsg.setMovementMethod(LinkMovementMethod.getInstance());
            this.vigilanceMsg.setVisibility(0);
        }
        C0535I5.f3652m = true;
        ArrayList arrayList4 = new ArrayList();
        for (BookingResponseDTO next2 : this.f4549a.getBookingResponseDTO()) {
            if (next2.getPsgnDtlList() != null && next2.getPsgnDtlList().size() > 0) {
                arrayList4.addAll(next2.getPsgnDtlList());
            }
        }
        if (C0535I5.f3647h) {
            Context context2 = this.a;
            this.f4548a.getPnrNumber();
            ErsPassengerViewHolder ersPassengerViewHolder = new ErsPassengerViewHolder(context2, arrayList4, this.f4553b.getPnrNumber(), true);
            this.psgnList.setLayoutManager(new LinearLayoutManager(getContext()));
            this.psgnList.setAdapter(ersPassengerViewHolder);
        } else {
            ErsPassengerViewHolder ersPassengerViewHolder2 = new ErsPassengerViewHolder(this.a, arrayList4, (String) null, true);
            this.psgnList.setLayoutManager(new LinearLayoutManager(getContext()));
            this.psgnList.setAdapter(ersPassengerViewHolder2);
        }
        if (bookingResponseDTO.getTktLegendMessage() != null && !bookingResponseDTO.getTktLegendMessage().trim().equals("")) {
            this.informationLayout.setVisibility(0);
            this.informationMsg.setText(this.f4548a.getTktLegendMessage());
        }
        if (C0535I5.f3647h && this.f4553b.getTktLegendMessage() != null && !this.f4553b.getTktLegendMessage().trim().equals("")) {
            this.informationLayout_lap2.setVisibility(0);
            this.informationMsg_lap2.setText(this.f4553b.getTktLegendMessage());
        }
        C1408tl tlVar = C1450w1.f7012a;
        if (this.f4548a.getArrivalTime() != null) {
            String[] split = this.f4548a.getArrivalTime().split(":");
            Calendar instance = Calendar.getInstance();
            instance.setTime(this.f4548a.getDestArrvDate());
            instance.set(11, 0);
            instance.set(12, Integer.valueOf(split[1]).intValue() + (Integer.valueOf(split[0]).intValue() * 60));
            instance.set(13, 0);
            instance.set(14, 0);
            this.f4548a.setDestArrvDate(instance.getTime());
            String[] split2 = this.f4548a.getDepartureTime().split(":");
            instance.setTime(this.f4548a.getBoardingDate());
            instance.set(11, 0);
            instance.set(12, Integer.valueOf(split2[1]).intValue() + (Integer.valueOf(split2[0]).intValue() * 60));
            instance.set(13, 0);
            instance.set(14, 0);
            this.f4548a.setBoardingDate(instance.getTime());
        }
        if (this.f4548a.getAvlForVikalp() == null || !this.f4548a.getAvlForVikalp().booleanValue()) {
            HashMap<String, String> hashMap3 = C1450w1.f7018b;
            if (hashMap3 != null && hashMap3.containsKey("pledgePopupMsg") && C1450w1.f7018b.get("pledgePopupMsg") != null) {
                C0535I5.p(this.a, true, C1450w1.f7018b.get("pledgePopupMsg"), getResources().getString(R.string.pledge_title), getString(R.string.visit), new C0588M9(this), getString(R.string.no_thanks), new N9(this)).show();
            } else if (this.f4548a.isEligibleForMetro()) {
                Context context3 = this.a;
                C0535I5.p(context3, false, "Do you want to book a metro ticket for your journey?", context3.getResources().getString(R.string.Info), this.a.getResources().getString(R.string.yes), new j(), this.a.getResources().getString(R.string.no), new n()).show();
            }
        } else {
            i(this.f4548a);
        }
        TextView textView = this.tktSentMsg;
        if (this.f4549a.getUserDetail().getLastName() == null || this.f4549a.getUserDetail().getLastName() == "") {
            sb = new StringBuilder();
            sb.append(getString(R.string.thank_you));
            sb.append(" ");
            sb.append(this.f4549a.getUserDetail().getFirstName());
            str2 = getString(R.string.tkt_sent_msg, C0535I5.d0(this.f4549a.getUserDetail().getEmail()), "+" + C0535I5.d + "-" + C0535I5.e0(C0535I5.f3639e));
        } else {
            sb = new StringBuilder();
            sb.append(getString(R.string.thank_you));
            sb.append(" ");
            sb.append(this.f4549a.getUserDetail().getFirstName());
            sb.append(" ");
            sb.append(this.f4549a.getUserDetail().getLastName());
            str2 = getString(R.string.tkt_sent_msg, C0535I5.d0(this.f4549a.getUserDetail().getEmail()), "+" + C0535I5.d + "-" + C0535I5.e0(C0535I5.f3639e));
        }
        lf.x(sb, str2, textView);
        l(this.f4548a);
        BookingResponseDTO bookingResponseDTO2 = this.f4548a;
        if (bookingResponseDTO2.getPnrLinkStatus() == null || bookingResponseDTO2.getPnrLinkStatus().intValue() != 1) {
            this.connectingPnrLayout.setVisibility(8);
        } else {
            this.connectingPnrLayout.setVisibility(0);
            this.connectingPnr.setText(bookingResponseDTO2.getConnectingPnrNumber());
            if (bookingResponseDTO2.getJourneyLap().intValue() == 1) {
                this.lapType.setText("(Main Journey)");
            } else if (bookingResponseDTO2.getJourneyLap().intValue() == 2) {
                this.lapType.setText("(Sub Journey)");
            }
        }
        this.ersPageCenterAds.setVisibility(0);
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setGender(C1450w1.f7021c);
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setDestination(this.f4548a.getDestStn());
        googleAdParamDTO.setSource(this.f4548a.getFromStn());
        googleAdParamDTO.setQuata(this.f4548a.getJourneyQuota());
        googleAdParamDTO.setjClass(this.f4548a.getJourneyClass());
        googleAdParamDTO.setTrainType(this.f4548a.getTrainTypeCode());
        if (this.f4548a.getPsgnDtlList() != null) {
            Iterator<PassengerDetailDTO> it = this.f4548a.getPsgnDtlList().iterator();
            while (it.hasNext()) {
                PassengerDetailDTO next3 = it.next();
                if (next3.getFoodChoice() != null && next3.getFoodChoice().contains("N")) {
                    googleAdParamDTO.setMealType("NV");
                } else if (next3.getFoodChoice() == null || !next3.getFoodChoice().contains("V")) {
                    googleAdParamDTO.setMealType((String) null);
                } else {
                    googleAdParamDTO.setMealType("V");
                }
                if (next3.getCurrentStatus().contains("C")) {
                    googleAdParamDTO.setTicketStatus("CNF");
                } else if (next3.getCurrentStatus().contains("W")) {
                    googleAdParamDTO.setTicketStatus("WL");
                } else if (next3.getCurrentStatus().contains("R")) {
                    googleAdParamDTO.setTicketStatus("RAC");
                } else {
                    googleAdParamDTO.setTicketStatus((String) null);
                }
            }
        }
        C0535I5.Y(getActivity(), this.ersPageCenterAds, googleAdParamDTO);
        HomeActivity.J();
        if (this.f4549a.getQrCodeText() != null && !this.f4549a.getQrCodeText().equals("")) {
            k();
            this.qr_code.setVisibility(0);
        }
        C0597Mk mealTransaction = this.f4548a.getMealTransaction();
        ArrayList<MealItemDetails> arrayList5 = this.f4551a;
        if (mealTransaction == null || !this.f4548a.getMealTransaction().isMealBooked()) {
            this.mealdetail_ll.setVisibility(8);
        } else {
            this.mealdetail_ll.setVisibility(0);
            arrayList5.addAll(this.f4548a.getMealTransaction().getAddMealDetail());
            m();
            if (C0535I5.f3647h) {
                n();
            }
        }
        if (C0535I5.f3647h) {
            if (this.f4553b.getMealTransaction() == null || !this.f4553b.getMealTransaction().isMealBooked()) {
                this.meal_detail_lap2.setVisibility(8);
            } else {
                this.meal_detail_lap2.setVisibility(0);
                arrayList5.addAll(this.f4553b.getMealTransaction().getAddMealDetail());
                m();
                n();
            }
        }
        C0535I5.f3643f = true;
        C0535I5.f3645g = false;
        if (this.f4548a.getRrHbFlag() == null) {
            this.tv_tab_upcoming_journey_hotel.setEnabled(false);
            this.tv_tab_upcoming_journey_retroom.setEnabled(false);
            return inflate;
        }
        if (this.f4548a.getRrHbFlag().equalsIgnoreCase("YY")) {
            this.tv_tab_upcoming_journey_hotel.setBackgroundColor(Color.parseColor("#343434"));
            this.tv_tab_upcoming_journey_retroom.setBackgroundColor(Color.parseColor("#343434"));
        } else if (this.f4548a.getRrHbFlag().equalsIgnoreCase("YN")) {
            this.tv_tab_upcoming_journey_hotel.setEnabled(false);
            this.tv_tab_upcoming_journey_retroom.setEnabled(true);
            this.tv_tab_upcoming_journey_hotel.setBackgroundColor(this.a.getResources().getColor(R.color.light_grey));
            this.tv_tab_upcoming_journey_retroom.setBackgroundColor(Color.parseColor("#343434"));
        } else if (this.f4548a.getRrHbFlag().equalsIgnoreCase("NY")) {
            this.tv_tab_upcoming_journey_retroom.setEnabled(false);
            this.tv_tab_upcoming_journey_hotel.setEnabled(true);
            this.tv_tab_upcoming_journey_hotel.setBackgroundColor(Color.parseColor("#343434"));
            this.tv_tab_upcoming_journey_retroom.setBackgroundColor(this.a.getResources().getColor(R.color.light_grey));
        } else if (this.f4548a.getRrHbFlag().equalsIgnoreCase("NN")) {
            this.tv_tab_upcoming_journey_hotel.setEnabled(false);
            this.tv_tab_upcoming_journey_retroom.setEnabled(false);
        }
        this.tv_tab_upcoming_journey_mot.setBackgroundColor(Color.parseColor("#343434"));
        this.tv_tab_delhi_metro.setBackgroundColor(Color.parseColor("#dc3545"));
        this.tv_bus.setBackgroundColor(Color.parseColor("#343434"));
        this.tv_cancellation_policy.setVisibility(0);
        ArrayList arrayList6 = new ArrayList();
        for (BookingResponseDTO bookingResponseDTO3 : this.f4549a.getBookingResponseDTO()) {
            C1188j3 j3Var = new C1188j3();
            j3Var.a = bookingResponseDTO3;
            arrayList6.add(j3Var);
        }
        ErsTrainDeatilLapwiseViewHolder ersTrainDeatilLapwiseViewHolder = new ErsTrainDeatilLapwiseViewHolder(this.a, arrayList6, (ErsDisplayFragment.q) null);
        this.rv_train_detail.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_train_detail.setAdapter(ersTrainDeatilLapwiseViewHolder);
        if (!C0535I5.f3647h || ((C1188j3) arrayList6.get(1)).a.getPnrNumber() == null) {
            this.psgnCount.setVisibility(0);
            this.tain_detail_ll.setVisibility(8);
            this.rl_psgnlisr.setVisibility(8);
            this.rv_addmeal_list_lap2.setVisibility(8);
            this.messages_lap2.setVisibility(8);
        } else {
            this.messages_lap2.setVisibility(0);
            this.rl_psgnlisr.setVisibility(0);
            this.rv_addmeal_list_lap2.setVisibility(0);
            this.tain_detail_ll.setVisibility(8);
            this.psgnCount.setVisibility(8);
        }
        if (this.f4549a.getBookingResponseDTO().size() > 1) {
            C0535I5.f3647h = true;
        }
        if (this.f4548a.getTktLegendMessage() == null && this.f4548a.getErsDisplayMessage() == null) {
            this.messages_lap1.setVisibility(8);
        } else {
            this.messages_lap1.setVisibility(0);
        }
        if (!C0535I5.f3647h) {
            this.lap1.setText(R.string.info_msg_head);
        }
        this.f4546a = (ImageView) inflate.findViewById(R.id.star_1);
        this.b = (ImageView) inflate.findViewById(R.id.star_2);
        this.f4556c = (ImageView) inflate.findViewById(R.id.star_3);
        this.d = (ImageView) inflate.findViewById(R.id.star_4);
        this.e = (ImageView) inflate.findViewById(R.id.star_5);
        this.f4546a.setOnClickListener(new o());
        this.b.setOnClickListener(new p());
        this.f4556c.setOnClickListener(new q());
        this.d.setOnClickListener(new r());
        this.e.setOnClickListener(new s());
        return inflate;
    }

    @OnClick({2131364383})
    public void onDoneAddMealClick(View view) {
        ArrayList<MealItemDetails> arrayList = this.f4551a;
        arrayList.clear();
        arrayList.addAll(C0535I5.f3624a);
        m();
        C0535I5.f3643f = true;
        C0535I5.f3645g = false;
        this.add_meal_rl.setVisibility(8);
        this.rv_addmeal_list.setVisibility(0);
    }

    @OnClick({2131362447})
    public void onDownloadPdfClick() {
        this.f4552a = false;
        if (Build.VERSION.SDK_INT > 32 || !(d7.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") == -1 || d7.a(this.a, "android.permission.READ_EXTERNAL_STORAGE") == -1)) {
            C0746Xa.a(this.f4548a, this.a, this.f4552a);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 16);
        }
    }

    @OnClick({2131364649})
    public void onMealClick() {
        if (C0535I5.f3647h) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4547a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4547a.show(getActivity().getSupportFragmentManager(), "");
            this.f4547a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4554b, new f());
            this.f4547a.g().setText("Select Meal");
            this.f4547a.f().setAdapter(customAdapter);
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(lf.j("https://www.ecatering.irctc.co.in/", this.f4548a.getPnrNumber(), "/outlets?utm_source=irctc&utm_medium=android_app&utm_campaign=booking_page"))));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131364648})
    public void onRRHotelClick() {
        if (C0535I5.f3647h) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4547a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4547a.show(getActivity().getSupportFragmentManager(), "");
            this.f4547a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4558c, new a());
            this.f4547a.g().setText(getString(R.string.Select_Destination_for_Hotel_Booking));
            this.f4547a.f().setAdapter(customAdapter);
            return;
        }
        new Thread(new b(Toast.makeText(getContext(), getString(R.string.unble_toconnect_server2), 1))).start();
    }

    @OnClick({2131364651})
    public void onRRRoomClick() {
        if (C0535I5.f3647h) {
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            this.f4547a = customDialogFragment;
            customDialogFragment.setShowsDialog(true);
            this.f4547a.show(getActivity().getSupportFragmentManager(), "");
            this.f4547a.setCancelable(true);
            getActivity().getSupportFragmentManager().z();
            CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f4558c, new c());
            this.f4547a.g().setText(getString(R.string.Select_Destination_for_Hotel_Booking));
            this.f4547a.f().setAdapter(customAdapter);
            return;
        }
        new Thread(new d()).start();
    }

    @OnClick({2131363675})
    public void onReplanClick() {
        boolean z;
        Bundle bundle = new Bundle();
        Iterator<BookingResponseDTO> it = this.f4549a.getBookingResponseDTO().iterator();
        loop0:
        while (true) {
            z = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else if (it.next().getPnrNumber() == null) {
                    z = false;
                }
            }
        }
        C1218kf kfVar = C1218kf.NEW_BOOKING;
        if (z) {
            bundle.putSerializable("ReturnFromStn", this.f4548a.getFromStn());
            if (C0535I5.f3647h) {
                bundle.putSerializable("ReturnDestStn", this.f4553b.getDestStn());
            } else {
                bundle.putSerializable("ReturnDestStn", this.f4548a.getDestStn());
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            if (C0535I5.f3647h) {
                bundle.putString("ReturnDate", simpleDateFormat.format(this.f4553b.getDestArrvDate()));
            } else {
                bundle.putString("ReturnDate", simpleDateFormat.format(this.f4548a.getDestArrvDate()));
            }
            Boolean bool = Boolean.TRUE;
            bundle.putSerializable("ReturnJourneyFlag", bool);
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            newBookingFragment.setArguments(bundle);
            HomeActivity.B(getActivity());
            HomeActivity.n(getActivity(), newBookingFragment, kfVar.a(), bool, bool);
            return;
        }
        NewBookingFragment newBookingFragment2 = new NewBookingFragment();
        HomeActivity.B(getActivity());
        FragmentActivity activity = getActivity();
        String a2 = kfVar.a();
        Boolean bool2 = Boolean.TRUE;
        HomeActivity.n(activity, newBookingFragment2, a2, bool2, bool2);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        switch (i2) {
            case 15:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    Toast.makeText(getActivity(), "Ticket Cannot be downloaded without storage permission.", 0).show();
                    return;
                } else {
                    onSaveERSClick();
                    return;
                }
            case 16:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    Toast.makeText(getActivity(), "Ticket(pdf) Cannot be downloaded without storage permission.", 0).show();
                    return;
                } else {
                    onDownloadPdfClick();
                    return;
                }
            case 17:
                if (iArr.length <= 0 || iArr[0] != 0) {
                    Toast.makeText(getActivity(), "Ticket Cannot be Shared without storage permission.", 0).show();
                    return;
                } else {
                    onShareButtonClick();
                    return;
                }
            default:
                return;
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.f4555b && this.f4548a.getAvlForVikalp().booleanValue()) {
            i(this.f4548a);
        }
        int i2 = c;
        if (i2 <= 5 || i2 >= 1) {
            o(i2);
            String.valueOf(c);
        }
    }

    @OnClick({2131363846})
    public void onSaveERSClick() {
        this.f4552a = false;
        if (Build.VERSION.SDK_INT > 32 || !(d7.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") == -1 || d7.a(this.a, "android.permission.READ_EXTERNAL_STORAGE") == -1)) {
            C0746Xa.b(this.a, this.scrollView, this.f4552a, this.pnrNo);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 15);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.clear();
    }

    @OnClick({2131363943})
    public void onSendMailPdfClick() {
        C0746Xa.d(this.f4548a, this.a);
    }

    @OnClick({2131363953})
    public void onShareButtonClick() {
        this.f4552a = true;
        if (Build.VERSION.SDK_INT > 32 || !(d7.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") == -1 || d7.a(this.a, "android.permission.READ_EXTERNAL_STORAGE") == -1)) {
            C0746Xa.a(this.f4548a, this.a, this.f4552a);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 17);
        }
    }

    public final void onStart() {
        super.onStart();
    }

    @OnClick({2131364323})
    public void onbusClick() {
        new Thread(new e()).start();
    }

    @OnClick({2131364325})
    public void oncancellationpolicylick() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.a)) {
            new Handler().postDelayed(new m(), 5000);
        } else {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/REFUND%20RULES%20wef%2012-Nov-15.pdf")));
        }
    }

    @OnClick({2131363386})
    public void orderfoodPantryCarClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctctourism.com/BookFood/")));
    }

    public final void p(C0486Dp dp) {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new k(), 5000);
            return;
        }
        C1223kn knVar = C0793b1.a.f3912a;
        if (knVar != null) {
            String l2 = C0657Qt.l();
            ((Om) C0657Qt.c(knVar)).u(l2 + "addPledge", dp).c(C1181iv.a()).a(E0.a()).b(new l());
        }
    }

    public final void q() {
        Iterator<MealItemDetails> it = this.f4551a.iterator();
        double d2 = 0.0d;
        while (it.hasNext()) {
            MealItemDetails next = it.next();
            d2 += (double) (next.getMealRate() * ((float) next.getQuantity()));
        }
        TextView textView = this.total_amount;
        textView.setText(String.valueOf("₹ " + d2));
    }

    public class k implements Runnable {
        public final void run() {
        }
    }

    public class m implements Runnable {
        public final void run() {
        }
    }
}
