package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.MealDetaillViewHolder;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.InformationMessageDTO;
import cris.prs.webservices.dto.MealItemDetails;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Subscriber;

public class ReviewAndPayFragment extends Fragment {
    public static String x = null;
    @BindView(2131364256)
    TextView ConvenienceFee;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5074a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentManager f5075a;

    /* renamed from: a  reason: collision with other field name */
    public C0822cf f5076a;

    /* renamed from: a  reason: collision with other field name */
    public GoogleAdParamDTO f5077a;

    /* renamed from: a  reason: collision with other field name */
    public final v f5078a = new v();

    /* renamed from: a  reason: collision with other field name */
    public final w f5079a = new w();

    /* renamed from: a  reason: collision with other field name */
    public TrainBtwnStnsModel f5080a;

    /* renamed from: a  reason: collision with other field name */
    public AvlFareResponseDTO f5081a;

    /* renamed from: a  reason: collision with other field name */
    public TrainBtwnStnsDTO f5082a;

    /* renamed from: a  reason: collision with other field name */
    public C1100f2 f5083a;

    /* renamed from: a  reason: collision with other field name */
    public Double f5084a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f5085a;

    /* renamed from: a  reason: collision with other field name */
    public List<AvlFareResponseDTO> f5086a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public C1225kp f5087a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5088a = false;
    @BindView(2131361901)
    LinearLayout add_meal_ll;
    @BindView(2131361903)
    LinearLayout add_meal_ll_lap2;
    @BindView(2131364297)
    TextView arrivalDateView;
    @BindView(2131364299)
    TextView arrivalTimeView;
    public AvlFareResponseDTO b;

    /* renamed from: b  reason: collision with other field name */
    public TrainBtwnStnsDTO f5089b;

    /* renamed from: b  reason: collision with other field name */
    public Double f5090b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f5091b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f5092b = false;
    @BindView(2131362064)
    TextView bookingStatusView;
    @BindView(2131362065)
    TextView booking_status_lap2;
    public int c = -1;

    /* renamed from: c  reason: collision with other field name */
    public String f5093c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<InformationMessageDTO> f5094c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f5095c = false;
    @BindView(2131362125)
    ImageView captcha;
    @BindView(2131362128)
    EditText captchaInput;
    @BindView(2131362129)
    ImageView captchaRefresh;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f5096d;

    /* renamed from: d  reason: collision with other field name */
    public ArrayList<MealItemDetails> f5097d = new ArrayList<>();

    /* renamed from: d  reason: collision with other field name */
    public boolean f5098d = false;
    @BindView(2131364360)
    TextView departureDateView;
    @BindView(2131364362)
    TextView departureTimeView;
    public String e;

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<MealItemDetails> f5099e = new ArrayList<>();

    /* renamed from: e  reason: collision with other field name */
    public boolean f5100e = true;
    public String f;

    /* renamed from: f  reason: collision with other field name */
    public final ArrayList f5101f = new ArrayList();
    @BindView(2131362633)
    LinearLayout fare_backup_single_jrny;
    @BindView(2131362638)
    RecyclerView farebreakup;
    @BindView(2131362637)
    RelativeLayout farelayout;
    @BindView(2131362640)
    TextView fastestcharge;
    @BindView(2131364424)
    TextView fromStation;
    public String g;
    public String h;
    @BindView(2131362760)
    TextView header_Via;
    @BindView(2131362765)
    TextView header_fromstn;
    @BindView(2131362768)
    TextView header_tomstn;
    @BindView(2131362769)
    TextView header_total_duration;
    public String i;
    @BindView(2131364437)
    TextView insurance_opt;
    @BindView(2131362852)
    TextView insurancecharge;
    @BindView(2131362905)
    ImageView iv_routmap;
    @BindView(2131362906)
    ImageView iv_routmap_lap2;
    public String j;
    public String k;
    public String l;
    @BindView(2131362935)
    TextView lap1_heading;
    @BindView(2131362938)
    TextView lap2_heading;
    @BindView(2131363012)
    LinearLayout llCaptchaInput;
    @BindView(2131363405)
    LinearLayout llOtpInput;
    @BindView(2131363030)
    LinearLayout ll_from_to_header_lap;
    @BindView(2131363050)
    LinearLayout ll_payment_method_label;
    @BindView(2131363084)
    LinearLayout ll_tainname_haedind_lap1;
    @BindView(2131363085)
    LinearLayout ll_tainname_haedind_lap2;
    @BindView(2131363094)
    LinearLayout ll_travel_insurance;
    @BindView(2131363100)
    LinearLayout ll_wait_duration_lap1;
    @BindView(2131363102)
    TextView loadingCaptcha;
    public String m;
    @BindView(2131363169)
    TextView makePaymentButton;
    public String n = null;
    @BindView(2131363309)
    TextView netAmount;
    @BindView(2131363323)
    LinearLayout nlpCaptchaLayout;
    @BindView(2131363321)
    LinearLayout nlp_heading;
    public String o = null;
    @BindView(2131363404)
    EditText otpInput;
    public String p = null;
    @BindView(2131363442)
    LinearLayout passanger_detail_lap2;
    @BindView(2131363456)
    RecyclerView passengerListView;
    @BindView(2131363453)
    LinearLayout passenger_detail_lap1;
    @BindView(2131363457)
    RecyclerView passenger_list2;
    @BindView(2131363547)
    TextView psgnCountClassQuotaView;
    @BindView(2131363548)
    TextView psgnCount_Class_Quota_lap2;
    @BindView(2131363553)
    TextView psgn_detail_heading;
    @BindView(2131363554)
    TextView psgn_detail_lap1;
    public String q = "";
    @BindView(2131364549)
    TextView quota;
    public String r = "";
    @BindView(2131363678)
    TextView reSendOtp;
    @BindView(2131363696)
    AdManagerAdView reviewJourneyBotAd;
    @BindView(2131363803)
    RecyclerView rv_addmeal_list;
    @BindView(2131363804)
    RecyclerView rv_addmeal_list_lap2;
    public String s;
    @BindView(2131363937)
    TextView selected_train_name_lap2;
    @BindView(2131363939)
    TextView selected_train_number_lap2;
    @BindView(2131363946)
    TextView servicecharges;
    public String t;
    @BindView(2131364063)
    LinearLayout tain_detail_ll_lap2;
    @BindView(2131364081)
    TextView termcondition;
    @BindView(2131364141)
    TextView ticketSentLevelView;
    @BindView(2131364673)
    TextView toStation;
    @BindView(2131364677)
    TextView total_amount;
    @BindView(2131364183)
    TextView totalamount;
    @BindView(2131363936)
    TextView trainNameView;
    @BindView(2131363938)
    TextView trainNumberView;
    @BindView(2131364207)
    ImageView train_type_lap1;
    @BindView(2131364208)
    ImageView train_type_lap2;
    @BindView(2131364234)
    TextView travelTimeView;
    @BindView(2131364235)
    TextView travel_Time_lap2;
    @BindView(2131364238)
    LinearLayout travel_insurance_ll;
    @BindView(2131364239)
    LinearLayout travel_insurance_ll_lap1;
    @BindView(2131364240)
    LinearLayout travel_insurance_ll_lap2;
    @BindView(2131364243)
    RelativeLayout travel_insurance_rl;
    @BindView(2131364298)
    TextView tv_arv_date_lap2;
    @BindView(2131364300)
    TextView tv_arv_timee_lap2;
    @BindView(2131364361)
    TextView tv_dep_date_lap2;
    @BindView(2131364363)
    TextView tv_dep_time_lap2;
    @BindView(2131364425)
    TextView tv_from_stationname_lap2;
    @BindView(2131364438)
    TextView tv_insurance_opt_lap1;
    @BindView(2131364439)
    TextView tv_insurance_opt_lap2;
    @BindView(2131364524)
    TextView tv_payment_method_label;
    @BindView(2131364550)
    TextView tv_quota_lap2;
    @BindView(2131364674)
    TextView tv_to_stationname_lap2;
    @BindView(2131364730)
    TextView tv_wait_duration;
    public String u;
    public String v;
    public String w = "";

    public class c extends Subscriber<E4> {
        public c() {
        }

        public final void onCompleted() {
            String str = ReviewAndPayFragment.x;
        }

        public final void onError(Throwable th) {
            String str = ReviewAndPayFragment.x;
            th.getClass();
            th.getMessage();
            ReviewAndPayFragment.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            if (e4 != null) {
                ObjectMapper h = C0657Qt.h();
                try {
                    if (e4.getError() == null) {
                        reviewAndPayFragment.c = e4.getCaptcha().intValue();
                        C1450w1.f7025d = System.currentTimeMillis();
                        h.writeValueAsString(e4);
                        String str = ReviewAndPayFragment.x;
                        C0535I5.o(reviewAndPayFragment.getActivity(), e4.getStatus(), reviewAndPayFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        reviewAndPayFragment.a.dismiss();
                        return;
                    }
                    reviewAndPayFragment.a.dismiss();
                    C0535I5.m(reviewAndPayFragment.getActivity(), false, e4.getError(), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), reviewAndPayFragment.f5079a).show();
                } catch (Exception e) {
                    reviewAndPayFragment.a.dismiss();
                    String str2 = ReviewAndPayFragment.x;
                    e.getMessage();
                }
            } else {
                reviewAndPayFragment.a.dismiss();
                C0535I5.m(reviewAndPayFragment.getActivity(), false, reviewAndPayFragment.getResources().getString(R.string.unable_process_message), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), reviewAndPayFragment.f5078a).show();
            }
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            HomeActivity.n((AppCompatActivity) reviewAndPayFragment.getActivity(), new NewBookingFragment(), C1218kf.NEW_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
            FragmentManager fragmentManager = reviewAndPayFragment.f5075a;
            fragmentManager.getClass();
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
            aVar.n(reviewAndPayFragment);
            aVar.c();
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            ReviewAndPayFragment.this.r();
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ String c;

        public h(String str) {
            this.c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment.this.n(this.c);
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ String c;

        public i(String str) {
            this.c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment.this.n(this.c);
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ ProgressDialog a;
        public final /* synthetic */ String c;

        public class a extends Subscriber<E4> {
            public a() {
            }

            public final void onCompleted() {
                String str = ReviewAndPayFragment.x;
            }

            public final void onError(Throwable th) {
                String str = ReviewAndPayFragment.x;
                th.getClass();
                th.getMessage();
                k.this.a.dismiss();
                Lt.a(true, th);
            }

            public final void onNext(Object obj) {
                E4 e4 = (E4) obj;
                k kVar = k.this;
                if (e4 != null) {
                    ObjectMapper h = C0657Qt.h();
                    try {
                        if (e4.getError() == null) {
                            h.writeValueAsString(e4);
                            String str = ReviewAndPayFragment.x;
                            kVar.a.dismiss();
                            new Bundle();
                            boolean z = C1450w1.f7024c;
                            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
                            if (z) {
                                if (reviewAndPayFragment.f5081a.getTotalCollectibleAmount().doubleValue() == 0.0d) {
                                    reviewAndPayFragment.g();
                                    return;
                                }
                            }
                            if (!ReviewAndPayFragment.x.equals("S") || reviewAndPayFragment.f5081a.getTotalCollectibleAmount().doubleValue() != 0.0d) {
                                reviewAndPayFragment.f5088a = true;
                                reviewAndPayFragment.d = 0;
                                C0535I5.e = 0;
                                Bundle bundle = new Bundle();
                                String string = reviewAndPayFragment.getString(R.string.make_payment);
                                MakePaymentNewFragment makePaymentNewFragment = new MakePaymentNewFragment();
                                bundle.putString("TotalFare", reviewAndPayFragment.f5083a.getTotalCollectibleAmount().toString());
                                String str2 = reviewAndPayFragment.w;
                                if ((str2 == null || str2.equals("skip")) && reviewAndPayFragment.f5100e && reviewAndPayFragment.f5083a.getJuspayLoadDTO() != null) {
                                    bundle.putSerializable("JuspayLoadDTO", reviewAndPayFragment.f5083a.getJuspayLoadDTO());
                                    string = "";
                                }
                                bundle.putSerializable("BankDetailDto", reviewAndPayFragment.f5083a.getBankDetailDTO());
                                bundle.putSerializable("eWalletDto", reviewAndPayFragment.f5083a.getEwalletDTO());
                                bundle.putSerializable("SoftPaymentDtos", (Serializable) reviewAndPayFragment.f5083a.getSoftPaymentDTOs());
                                bundle.putString("loyaltyBookingType", reviewAndPayFragment.w);
                                bundle.putString("ClientTxnId", reviewAndPayFragment.m);
                                bundle.putString("JourneyDate", reviewAndPayFragment.n);
                                bundle.putSerializable("googleAd", reviewAndPayFragment.f5077a);
                                makePaymentNewFragment.setArguments(bundle);
                                HomeActivity.n(reviewAndPayFragment.getActivity(), makePaymentNewFragment, string, Boolean.TRUE, Boolean.FALSE);
                                return;
                            }
                            reviewAndPayFragment.g();
                            return;
                        }
                        ReviewAndPayFragment.this.d = 0;
                        Integer captcha = e4.getCaptcha();
                        ReviewAndPayFragment reviewAndPayFragment2 = ReviewAndPayFragment.this;
                        if (captcha != null) {
                            reviewAndPayFragment2.c = e4.getCaptcha().intValue();
                        }
                        kVar.a.dismiss();
                        C0535I5.m(reviewAndPayFragment2.getActivity(), false, e4.getError(), reviewAndPayFragment2.getString(R.string.error), reviewAndPayFragment2.getString(R.string.ok), new C1030j0(this, e4)).show();
                    } catch (Exception e) {
                        kVar.a.dismiss();
                        String str3 = ReviewAndPayFragment.x;
                        e.getMessage();
                    }
                } else {
                    kVar.a.dismiss();
                    ReviewAndPayFragment reviewAndPayFragment3 = ReviewAndPayFragment.this;
                    C0535I5.m(reviewAndPayFragment3.getActivity(), false, reviewAndPayFragment3.getResources().getString(R.string.unable_process_message), reviewAndPayFragment3.getString(R.string.error), reviewAndPayFragment3.getString(R.string.OK), reviewAndPayFragment3.f5078a).show();
                }
            }
        }

        public k(String str, ProgressDialog progressDialog) {
            this.c = str;
            this.a = progressDialog;
        }

        public final void run() {
            String f = C0657Qt.f();
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            String format = String.format("/%s/%s/%s", new Object[]{reviewAndPayFragment.m, reviewAndPayFragment.f5083a.getCaptchaDto().getCaptchaType(), this.c});
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).t(f + "captchaverify" + format).c(C1181iv.a()).a(E0.a()).b(new a());
        }
    }

    public class m extends Subscriber<C1225kp> {
        public m() {
        }

        public final void onCompleted() {
            String str = ReviewAndPayFragment.x;
            ReviewAndPayFragment.this.a.dismiss();
            AlertDialog alertDialog = C0535I5.f3619a;
        }

        public final void onError(Throwable th) {
            String str = ReviewAndPayFragment.x;
            th.getClass();
            th.getMessage();
            ReviewAndPayFragment.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C1225kp kpVar = (C1225kp) obj;
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            String str = ReviewAndPayFragment.x;
            kpVar.getTxnStatus();
            ObjectMapper h = C0657Qt.h();
            try {
                C1450w1.e = System.currentTimeMillis();
                h.writeValueAsString(kpVar);
                reviewAndPayFragment.a.dismiss();
                if (kpVar.getTxnStatus() != 14) {
                    if (kpVar.getErrorMsg() == null) {
                        reviewAndPayFragment.f5087a.setParamList(kpVar.getParamList());
                        reviewAndPayFragment.k(kpVar.getParamList());
                        return;
                    }
                    String errorMsg = kpVar.getErrorMsg();
                    if (errorMsg.split("-")[0].contains("You have exhausted")) {
                        Html.fromHtml("");
                        Spanned fromHtml = Html.fromHtml(errorMsg);
                        TextView textView = new TextView(reviewAndPayFragment.getActivity());
                        textView.setText(fromHtml);
                        textView.setGravity(3);
                        textView.setPadding(50, 10, 50, 20);
                        textView.setTextSize(15.0f);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        C0535I5.s(reviewAndPayFragment.getActivity(), textView, reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), (C1444vl) null).show();
                    }
                }
            } catch (Exception e) {
                reviewAndPayFragment.a.dismiss();
                String str2 = ReviewAndPayFragment.x;
                e.getMessage();
            }
        }
    }

    public class o implements Runnable {
        public final /* synthetic */ Context a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f5104a;

        public class a extends Subscriber<C1074dm> {
            public a() {
            }

            public final void onCompleted() {
                String str = ReviewAndPayFragment.x;
            }

            public final void onError(Throwable th) {
                String str = ReviewAndPayFragment.x;
                th.getClass();
                th.getMessage();
                ReviewAndPayFragment.this.a.dismiss();
                Lt.a(true, th);
            }

            public final void onNext(Object obj) {
                C1074dm dmVar = (C1074dm) obj;
                o oVar = o.this;
                ReviewAndPayFragment.this.a.dismiss();
                ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
                if (dmVar != null) {
                    try {
                        C0657Qt.h().writeValueAsString(dmVar);
                        String str = ReviewAndPayFragment.x;
                        if (dmVar.getErrorMessage() != null) {
                            C0535I5.m(reviewAndPayFragment.getContext(), false, dmVar.getErrorMessage(), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                            return;
                        }
                        boolean z = C0535I5.f3647h;
                        ArrayList arrayList = oVar.f5104a;
                        Context context = oVar.a;
                        if (!z) {
                            reviewAndPayFragment.f(context, arrayList, dmVar.getBookingResponseDTO().get(0), dmVar);
                        } else if (dmVar.getBookingResponseDTO().size() > 1) {
                            BookingResponseDTO bookingResponseDTO = dmVar.getBookingResponseDTO().get(0);
                            BookingResponseDTO bookingResponseDTO2 = dmVar.getBookingResponseDTO().get(1);
                            if (bookingResponseDTO.getErrorMessage() == null || bookingResponseDTO2.getErrorMessage() == null) {
                                TicketHistoryUtil.c();
                                if (C1058d.d(reviewAndPayFragment.f5087a.getBankId()) == 3) {
                                    TicketHistoryUtil.f5371a = null;
                                }
                                Bundle bundle = new Bundle();
                                ERSFragment eRSFragment = new ERSFragment();
                                bundle.putSerializable("FinalBookingSummary", dmVar);
                                eRSFragment.setArguments(bundle);
                                HomeActivity.n(context, eRSFragment, reviewAndPayFragment.getResources().getString(R.string.booking_detail_title), Boolean.TRUE, Boolean.FALSE);
                                return;
                            }
                            reviewAndPayFragment.f(context, arrayList, bookingResponseDTO, dmVar);
                        }
                    } catch (Exception e) {
                        String str2 = ReviewAndPayFragment.x;
                        e.getMessage();
                        C0535I5.m(reviewAndPayFragment.getContext(), false, reviewAndPayFragment.getString(R.string.Some_error_occurred_Payment_not_verified), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                } else {
                    C0535I5.m(reviewAndPayFragment.getContext(), false, reviewAndPayFragment.getString(R.string.Some_error_occurred_Please_try_again), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            }
        }

        public o(FragmentActivity fragmentActivity, ArrayList arrayList) {
            this.a = fragmentActivity;
            this.f5104a = arrayList;
        }

        public final void run() {
            C1507z0.b();
            Om om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            String f = C0657Qt.f();
            if (C1450w1.f7032f) {
                f = C0657Qt.k();
            }
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            om.J(xx.D(f, "verifyPayment", String.format("/%s", new Object[]{reviewAndPayFragment.m})), reviewAndPayFragment.f5087a).c(C1181iv.a()).a(E0.a()).b(new a());
        }
    }

    public class p implements DialogInterface.OnClickListener {
        public p() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment.this.getActivity().onBackPressed();
        }
    }

    public class q implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f5105a;

        public q(ArrayList arrayList) {
            this.f5105a = arrayList;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment.this.k(this.f5105a);
        }
    }

    public class r implements DialogInterface.OnClickListener {
        public r() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            HomeActivity.B(reviewAndPayFragment.getActivity());
            FragmentActivity activity = reviewAndPayFragment.getActivity();
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            String a2 = C1218kf.NEW_BOOKING.a();
            Boolean bool = Boolean.TRUE;
            HomeActivity.n(activity, newBookingFragment, a2, bool, bool);
        }
    }

    public class s implements DialogInterface.OnClickListener {
        public s() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            HomeActivity.B(reviewAndPayFragment.getActivity());
            FragmentActivity activity = reviewAndPayFragment.getActivity();
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            String a2 = C1218kf.NEW_BOOKING.a();
            Boolean bool = Boolean.TRUE;
            HomeActivity.n(activity, newBookingFragment, a2, bool, bool);
        }
    }

    public class u implements DialogInterface.OnClickListener {
        public u() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment.this.getActivity().onBackPressed();
        }
    }

    public class v implements DialogInterface.OnClickListener {
        public v() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment.this.l("");
        }
    }

    public class w implements DialogInterface.OnClickListener {
        public w() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ReviewAndPayFragment.this.getActivity().onBackPressed();
        }
    }

    public class y extends Subscriber<E4> {
        public y() {
        }

        public final void onCompleted() {
            String str = ReviewAndPayFragment.x;
        }

        public final void onError(Throwable th) {
            String str = ReviewAndPayFragment.x;
            th.getClass();
            th.getMessage();
            ReviewAndPayFragment.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            E4 e4 = (E4) obj;
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            if (e4 != null) {
                C0657Qt.h();
                try {
                    String str = ReviewAndPayFragment.x;
                    reviewAndPayFragment.h();
                    if (e4.getError() == null) {
                        int intValue = e4.getCaptcha().intValue();
                        reviewAndPayFragment.c = intValue;
                        if (10 == intValue) {
                            C1450w1.f7025d = System.currentTimeMillis();
                            reviewAndPayFragment.q(e4.getCaptchaQuestion());
                            reviewAndPayFragment.a.dismiss();
                            return;
                        }
                        return;
                    }
                    reviewAndPayFragment.a.dismiss();
                    C0535I5.m(reviewAndPayFragment.getActivity(), false, e4.getError(), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), reviewAndPayFragment.f5079a).show();
                } catch (Exception e) {
                    reviewAndPayFragment.a.dismiss();
                    String str2 = ReviewAndPayFragment.x;
                    e.getMessage();
                }
            } else {
                reviewAndPayFragment.a.dismiss();
                C0535I5.m(reviewAndPayFragment.getActivity(), false, reviewAndPayFragment.getResources().getString(R.string.unable_process_message), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), reviewAndPayFragment.f5078a).show();
            }
        }
    }

    static {
        C1354qp.R(ReviewAndPayFragment.class);
    }

    public final void f(Context context, ArrayList<Do> arrayList, BookingResponseDTO bookingResponseDTO, C1074dm dmVar) {
        String str;
        if (bookingResponseDTO.getErrorMessage() != null && !C0535I5.f3647h && bookingResponseDTO.getRetryBooking().booleanValue()) {
            if (bookingResponseDTO.getErrorMessage().contains("-")) {
                str = bookingResponseDTO.getErrorMessage().split("-")[0];
            } else {
                str = bookingResponseDTO.getErrorMessage();
            }
            StringBuilder n2 = lf.n(str, "\n");
            n2.append(getResources().getString(R.string.booking_without_choice));
            C0535I5.p(context, false, n2.toString(), getString(R.string.Retry_Booking_Confirmation), getString(R.string.no), new p(), getString(R.string.yes), new q(arrayList)).show();
        } else if (bookingResponseDTO.getErrorMessage() != null && bookingResponseDTO.getReservationId() != null) {
            TicketHistoryUtil.c();
            Context context2 = getContext();
            C0535I5.o(context2, bookingResponseDTO.getErrorMessage() + "\n" + getString(R.string.check_bookings_failed_PNR_generated), getString(R.string.OK), new r()).show();
        } else if (C0535I5.f3647h || bookingResponseDTO.getErrorMessage() != null || bookingResponseDTO.getReservationId() == null) {
            String errorMessage = bookingResponseDTO.getErrorMessage();
            if (errorMessage.contains("55002") || errorMessage.contains("55001")) {
                C0535I5.m(getContext(), false, errorMessage.split(" - ")[0], getString(R.string.error), getString(R.string.OK), new s()).show();
            } else if (errorMessage.contains("SAME COACH") || errorMessage.contains("not met")) {
                C0535I5.m(getContext(), false, errorMessage, getString(R.string.error), getString(R.string.OK), new u()).show();
            }
        } else {
            TicketHistoryUtil.c();
            if (C1058d.d(this.f5087a.getBankId()) == 3) {
                TicketHistoryUtil.f5371a = null;
            }
            Bundle bundle = new Bundle();
            ERSFragment eRSFragment = new ERSFragment();
            bundle.putSerializable("FinalBookingSummary", dmVar);
            eRSFragment.setArguments(bundle);
            HomeActivity.n(context, eRSFragment, getActivity().getResources().getString(R.string.booking_detail_title), Boolean.TRUE, Boolean.FALSE);
        }
    }

    public final void g() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f5074a)) {
            new Handler().postDelayed(new l(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            this.a = ProgressDialog.show(getActivity(), getString(R.string.processing_text), getString(R.string.please_wait_text));
            C1225kp kpVar = new C1225kp();
            this.f5087a = kpVar;
            kpVar.setAmount(this.f5083a.getTotalCollectibleAmount().doubleValue());
            this.f5087a.setBankId(-1);
            this.f5087a.setTxnStatus(1);
            this.f5087a.setParamList(new ArrayList());
            ((Om) C0657Qt.c(b1Var.f3912a)).s(xx.D(C0657Qt.f(), "bookingInitPayment", String.format("/%s", new Object[]{this.m})), C1480xl.d, this.f5087a).c(C1181iv.a()).a(E0.a()).b(new m());
            return;
        }
        C0535I5.m(getContext(), false, getActivity().getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
    }

    public final void h() {
        this.llOtpInput.setVisibility(8);
        this.llCaptchaInput.setVisibility(8);
        this.nlpCaptchaLayout.setVisibility(8);
        this.nlp_heading.setVisibility(8);
        this.reviewJourneyBotAd.setVisibility(0);
        C0535I5.Y(getActivity(), this.reviewJourneyBotAd, this.f5077a);
    }

    public final void i(C0824ch chVar) {
        try {
            if (C0535I5.f3649j) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("requestId", UUID.randomUUID().toString());
                jSONObject.put(PaymentConstants.SERVICE, chVar.getServiceUrl());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(LogCategory.ACTION, "healthCheck");
                jSONObject2.put(PaymentConstants.ENV, chVar.getEnvironment());
                jSONObject2.put("customerId", C1450w1.f7026d);
                jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
                if (this.f5076a == null) {
                    this.f5076a = new C0822cf(getActivity());
                }
                this.f5076a.setCallback(new C0728Vt(this));
                C0822cf cfVar = this.f5076a;
                cfVar.getClass();
                jSONObject.toString();
                cfVar.getHyperServices().process(cfVar.f3937a, jSONObject);
            }
        } catch (JSONException e2) {
            e2.getMessage();
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    public final Date j(Date date, Date date2) {
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

    /* JADX WARNING: Removed duplicated region for block: B:13:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(java.util.ArrayList<defpackage.Do> r11) {
        /*
            r10 = this;
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            androidx.fragment.app.FragmentActivity r1 = r10.f5074a
            boolean r0 = defpackage.C0535I5.O(r0, r1)
            if (r0 != 0) goto L_0x0024
            android.os.Handler r11 = new android.os.Handler
            r11.<init>()
            cris.org.in.ima.fragment.ReviewAndPayFragment$n r0 = new cris.org.in.ima.fragment.ReviewAndPayFragment$n
            r0.<init>()
            r1 = 5000(0x1388, double:2.4703E-320)
            r11.postDelayed(r0, r1)
            return
        L_0x0024:
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            b1 r1 = defpackage.C0793b1.a
            kn r1 = r1.f3912a
            if (r1 == 0) goto L_0x00ab
            kp r1 = r10.f5087a
            r2 = 1
            r1.setTxnStatus(r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            Do r3 = new Do
            java.lang.String r4 = "OTP"
            java.lang.String r5 = ""
            r3.<init>(r4, r5)
            r1.add(r3)
            Do r3 = new Do
            java.lang.String r4 = "Success"
            java.lang.String r5 = "000"
            r3.<init>(r4, r5)
            r1.add(r3)
            Do r3 = new Do
            java.lang.String r5 = "Message"
            r3.<init>(r5, r4)
            r1.add(r3)
            kp r3 = r10.f5087a
            r3.setParamList(r1)
            androidx.fragment.app.FragmentActivity r1 = r10.getActivity()
            r3 = 2131953534(0x7f13077e, float:1.9543542E38)
            java.lang.String r3 = r10.getString(r3)
            r4 = 2131953495(0x7f130757, float:1.9543463E38)
            java.lang.String r4 = r10.getString(r4)
            android.app.ProgressDialog r1 = android.app.ProgressDialog.show(r1, r3, r4)
            r10.a = r1
            tl r1 = defpackage.C1450w1.f7012a
            r3 = 0
            if (r1 == 0) goto L_0x0099
            java.lang.Integer r4 = r1.getMinmPaymentTime()
            int r4 = r4.intValue()
            java.lang.Integer r1 = r1.getPaymentCompletCheckEnable()
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x0099
            long r1 = java.lang.System.currentTimeMillis()
            long r5 = defpackage.C1450w1.e
            long r1 = r1 - r5
            int r1 = (int) r1
            int r4 = r4 - r1
            goto L_0x009a
        L_0x0099:
            r4 = r3
        L_0x009a:
            if (r4 <= 0) goto L_0x009d
            r3 = r4
        L_0x009d:
            cris.org.in.ima.fragment.ReviewAndPayFragment$o r1 = new cris.org.in.ima.fragment.ReviewAndPayFragment$o
            r1.<init>(r0, r11)
            cB r11 = new cB
            r11.<init>(r1, r3)
            r11.a()
            goto L_0x00d5
        L_0x00ab:
            android.content.Context r4 = r10.getContext()
            r5 = 0
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            android.content.res.Resources r11 = r11.getResources()
            r0 = 2131952536(0x7f130398, float:1.9541518E38)
            java.lang.String r6 = r11.getString(r0)
            r11 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r7 = r10.getString(r11)
            r11 = 2131953334(0x7f1306b6, float:1.9543136E38)
            java.lang.String r8 = r10.getString(r11)
            r9 = 0
            android.app.AlertDialog r11 = defpackage.C0535I5.m(r4, r5, r6, r7, r8, r9)
            r11.show()
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ReviewAndPayFragment.k(java.util.ArrayList):void");
    }

    public final void l(String str) {
        this.captchaInput.setText("");
        this.d = 0;
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new x(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            this.captcha.setVisibility(8);
            this.loadingCaptcha.setVisibility(0);
            this.a = ProgressDialog.show(this.f5074a, getString(R.string.refresh_Captcha), getString(R.string.please_wait_text), false, false);
            String f2 = C0657Qt.f();
            String format = String.format("/%s/%s", new Object[]{this.m, this.f5083a.getCaptchaDto().getCaptchaType()});
            ((Om) C0657Qt.c(b1Var.f3912a)).D(f2 + "captchaganetate" + format, str).c(C1181iv.a()).a(E0.a()).b(new y());
            return;
        }
        C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public final void m() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f5074a)) {
            new Handler().postDelayed(new b(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            this.a = ProgressDialog.show(this.f5074a, getString(R.string.resend_OTP), getString(R.string.please_wait_text), false, false);
            String f2 = C0657Qt.f();
            String format = String.format("/%s", new Object[]{this.f5083a.getCaptchaDto().getCaptchaType()});
            ((Om) C0657Qt.c(b1Var.f3912a)).S0(f2 + "generateOTP" + format).c(C1181iv.a()).a(E0.a()).b(new c());
            return;
        }
        C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r12) {
        /*
            r11 = this;
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            androidx.fragment.app.FragmentActivity r1 = r11.f5074a
            boolean r0 = defpackage.C0535I5.O(r0, r1)
            if (r0 != 0) goto L_0x0024
            android.os.Handler r12 = new android.os.Handler
            r12.<init>()
            cris.org.in.ima.fragment.ReviewAndPayFragment$j r0 = new cris.org.in.ima.fragment.ReviewAndPayFragment$j
            r0.<init>()
            r1 = 5000(0x1388, double:2.4703E-320)
            r12.postDelayed(r0, r1)
            return
        L_0x0024:
            android.app.ProgressDialog r0 = new android.app.ProgressDialog
            androidx.fragment.app.FragmentActivity r1 = r11.getActivity()
            r0.<init>(r1)
            r1 = 1
            r0.requestWindowFeature(r1)
            r1 = 2131953495(0x7f130757, float:1.9543463E38)
            java.lang.String r1 = r11.getString(r1)
            r0.setMessage(r1)
            r1 = 0
            r0.setCancelable(r1)
            r0.show()
            android.widget.LinearLayout r2 = r11.llCaptchaInput
            r3 = 8
            r2.setVisibility(r3)
            tl r2 = defpackage.C1450w1.f7012a
            if (r2 == 0) goto L_0x0088
            java.lang.Integer r3 = r2.getCaptchaFillCheckStartTime()
            int r3 = r3.intValue()
            java.lang.Integer r4 = r2.getCaptchaFillCheckEndTime()
            int r4 = r4.intValue()
            java.lang.Integer r2 = r2.getMinmCaptchaInputTime()
            int r2 = r2.intValue()
            long r5 = defpackage.C1450w1.f
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = defpackage.C1450w1.f7020c
            long r7 = r7 - r9
            long r7 = r7 + r5
            r5 = 60000(0xea60, double:2.9644E-319)
            long r7 = r7 / r5
            long r5 = (long) r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0088
            long r3 = (long) r4
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0088
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = defpackage.C1450w1.f7025d
            long r3 = r3 - r5
            long r5 = (long) r2
            long r5 = r5 - r3
            int r2 = (int) r5
            goto L_0x0089
        L_0x0088:
            r2 = r1
        L_0x0089:
            if (r2 <= 0) goto L_0x008c
            r1 = r2
        L_0x008c:
            int r2 = r11.d
            defpackage.C0535I5.e = r2
            int r2 = r11.c
            r3 = 20
            if (r3 == r2) goto L_0x009a
            r3 = 10
            if (r3 != r2) goto L_0x00ae
        L_0x009a:
            cris.org.in.ima.fragment.ReviewAndPayFragment$k r2 = new cris.org.in.ima.fragment.ReviewAndPayFragment$k
            r2.<init>(r12, r0)
            cB r12 = new cB
            r12.<init>(r2, r1)
            r12.a()
            android.widget.EditText r12 = r11.captchaInput
            java.lang.String r0 = ""
            r12.setText(r0)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ReviewAndPayFragment.n(java.lang.String):void");
    }

    public final void o() {
        InformationMessageDTO informationMessageDTO;
        String str;
        if (C1450w1.f7024c && this.f5081a.getTotalCollectibleAmount().doubleValue() == 0.0d) {
            this.makePaymentButton.setText("Book Ticket");
        }
        Iterator<InformationMessageDTO> it = this.f5094c.iterator();
        while (true) {
            if (!it.hasNext()) {
                informationMessageDTO = null;
                break;
            }
            informationMessageDTO = it.next();
            if (informationMessageDTO.getParamName().equalsIgnoreCase("REVIEW_MSG_INIT")) {
                break;
            }
        }
        if (informationMessageDTO != null && informationMessageDTO.getMessage() != null) {
            String string = getString(R.string.OK);
            if (informationMessageDTO.getAcceptButton() != null) {
                string = informationMessageDTO.getAcceptButton().split("_")[0];
            }
            String str2 = string;
            if (informationMessageDTO.getRejectButton() != null) {
                str = informationMessageDTO.getRejectButton().split("_")[0];
            } else {
                str = "";
            }
            Spanned fromHtml = Html.fromHtml(informationMessageDTO.getMessage());
            C0535I5.n(getActivity(), fromHtml, getString(R.string.confirmation), str2, new d(), str, new e()).show();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0508  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x058c  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x05b8  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x05bf  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x05f3  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x05fc A[SYNTHETIC, Splitter:B:128:0x05fc] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0666  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0807  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0817  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0847  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0871  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x08cc  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x091e  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0960 A[Catch:{ Exception -> 0x097c }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x096e A[Catch:{ Exception -> 0x097c }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x09a6  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x09be  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x09ff  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0a1a  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0a20  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0a29  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0a68  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0ac3  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0acf  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0ae5  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0af0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x04ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r19, android.view.ViewGroup r20, android.os.Bundle r21) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = ""
            r0 = 2131558468(0x7f0d0044, float:1.8742253E38)
            r3 = 0
            r4 = r19
            android.view.View r3 = r4.inflate(r0, r3)
            butterknife.ButterKnife.bind((java.lang.Object) r1, (android.view.View) r3)
            androidx.fragment.app.FragmentActivity r0 = r18.getActivity()
            r1.f5074a = r0
            android.os.Bundle r0 = r18.getArguments()
            androidx.fragment.app.FragmentManager r4 = r18.getFragmentManager()
            r1.f5075a = r4
            androidx.fragment.app.FragmentActivity r4 = r18.getActivity()
            android.view.View r5 = r18.getView()
            defpackage.C0535I5.H(r4, r5)
            android.widget.EditText r4 = r1.captchaInput
            r4.requestFocus()
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L_0x017c
            java.lang.String r6 = "showMeal"
            java.io.Serializable r6 = r0.getSerializable(r6)
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            r1.f5097d = r6
            java.lang.String r6 = "showMealLap2"
            java.io.Serializable r6 = r0.getSerializable(r6)
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            r1.f5099e = r6
            java.lang.String r6 = "SummaryDetails"
            java.io.Serializable r6 = r0.getSerializable(r6)
            f2 r6 = (defpackage.C1100f2) r6
            r1.f5083a = r6
            java.util.List r6 = r6.getAvlFareResponseDTO()
            r1.f5086a = r6
            java.lang.Object r6 = r6.get(r5)
            cris.prs.webservices.dto.AvlFareResponseDTO r6 = (cris.prs.webservices.dto.AvlFareResponseDTO) r6
            r1.f5081a = r6
            boolean r6 = defpackage.C0535I5.f3647h
            if (r6 == 0) goto L_0x006f
            java.util.List<cris.prs.webservices.dto.AvlFareResponseDTO> r6 = r1.f5086a
            java.lang.Object r6 = r6.get(r4)
            cris.prs.webservices.dto.AvlFareResponseDTO r6 = (cris.prs.webservices.dto.AvlFareResponseDTO) r6
            r1.b = r6
        L_0x006f:
            java.lang.String r6 = "googleAd"
            java.io.Serializable r6 = r0.getSerializable(r6)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r6 = (cris.org.in.ima.dto.oauth2.GoogleAdParamDTO) r6
            r1.f5077a = r6
            java.lang.String r6 = "TrainBtwnStnsDTO"
            java.io.Serializable r6 = r0.getSerializable(r6)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = (cris.prs.webservices.dto.TrainBtwnStnsDTO) r6
            r1.f5082a = r6
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r7 = r1.f5077a
            java.util.List r6 = r6.getTrainType()
            java.lang.Object r6 = r6.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            r7.setTrainType(r6)
            java.lang.String r6 = "TrainBtwnStnsModel"
            java.io.Serializable r6 = r0.getSerializable(r6)
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = (cris.org.in.ima.model.TrainBtwnStnsModel) r6
            r1.f5080a = r6
            boolean r6 = defpackage.C0535I5.f3647h
            if (r6 == 0) goto L_0x00aa
            java.lang.String r6 = "TrainBtwnStnsDTOlap2"
            java.io.Serializable r6 = r0.getSerializable(r6)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = (cris.prs.webservices.dto.TrainBtwnStnsDTO) r6
            r1.f5089b = r6
        L_0x00aa:
            java.lang.String r6 = "PassengerList"
            java.io.Serializable r6 = r0.getSerializable(r6)
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            r1.f5085a = r6
            boolean r6 = defpackage.C0535I5.f3647h
            if (r6 == 0) goto L_0x00c2
            java.lang.String r6 = "PassengerListlap2"
            java.io.Serializable r6 = r0.getSerializable(r6)
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            r1.f5091b = r6
        L_0x00c2:
            java.lang.String r6 = "ClientTxnId"
            java.lang.String r6 = r0.getString(r6)
            r1.m = r6
            java.lang.String r6 = "SelectedClass"
            java.lang.String r6 = r0.getString(r6)
            r1.f5093c = r6
            java.lang.String r6 = "SelectedQuotaString"
            java.lang.String r6 = r0.getString(r6)
            r1.f5096d = r6
            java.lang.String r6 = "selectQuotalap2"
            java.lang.String r6 = r0.getString(r6)
            r1.e = r6
            java.lang.String r6 = "jDate"
            java.lang.String r6 = r0.getString(r6)
            r1.f = r6
            java.lang.String r6 = "ArrivalvDate"
            java.lang.String r6 = r0.getString(r6)
            r1.h = r6
            boolean r6 = defpackage.C0535I5.f3647h
            if (r6 == 0) goto L_0x0106
            java.lang.String r6 = "arrivalDatelap2"
            java.lang.String r6 = r0.getString(r6)
            r1.i = r6
            java.lang.String r6 = "jDatelp2"
            java.lang.String r6 = r0.getString(r6)
            r1.g = r6
        L_0x0106:
            java.lang.String r6 = "PassengerCount"
            java.lang.String r6 = r0.getString(r6)
            r1.j = r6
            java.lang.String r6 = "ChildCount"
            java.lang.String r6 = r0.getString(r6)
            r1.k = r6
            java.lang.String r6 = "JourneyDate"
            java.lang.String r6 = r0.getString(r6)
            r1.n = r6
            java.lang.String r6 = "boadingStationAndDateTime"
            java.lang.String r6 = r0.getString(r6)
            r1.o = r6
            java.lang.String r6 = "mobileNumber"
            java.lang.String r6 = r0.getString(r6)
            r1.p = r6
            java.lang.String r6 = "boadingpointchange"
            boolean r6 = r0.getBoolean(r6)
            r1.f5092b = r6
            java.lang.String r6 = "mpUserMsg"
            java.io.Serializable r6 = r0.getSerializable(r6)
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            r1.f5094c = r6
            java.lang.String r6 = "paymentLabel"
            boolean r7 = r0.containsKey(r6)
            if (r7 == 0) goto L_0x014e
            java.lang.String r6 = r0.getString(r6)
            r1.q = r6
        L_0x014e:
            java.lang.String r6 = "paymentDesc"
            boolean r7 = r0.containsKey(r6)
            if (r7 == 0) goto L_0x015c
            java.lang.String r6 = r0.getString(r6)
            r1.r = r6
        L_0x015c:
            java.lang.String r6 = "travelinsuranceopt"
            boolean r6 = r0.getBoolean(r6)
            r1.f5095c = r6
            java.lang.String r6 = "travelinsuranceoptlap2"
            boolean r6 = r0.getBoolean(r6)
            r1.f5098d = r6
            java.lang.String r6 = "spConcession"
            java.lang.String r6 = r0.getString(r6)
            x = r6
            java.lang.String r6 = "loyaltyBookingType"
            java.lang.String r0 = r0.getString(r6)
            r1.w = r0
        L_0x017c:
            boolean r0 = defpackage.C0535I5.f3649j
            if (r0 == 0) goto L_0x0191
            f2 r0 = r1.f5083a
            ch r0 = r0.getJuspayLoadDTO()
            if (r0 == 0) goto L_0x0191
            f2 r0 = r1.f5083a
            ch r0 = r0.getJuspayLoadDTO()
            r1.i(r0)
        L_0x0191:
            r0 = 2131363322(0x7f0a05fa, float:1.834645E38)
            android.view.View r0 = r3.findViewById(r0)
            cris.org.in.ima.NLPCaptchaWebView r0 = (cris.org.in.ima.NLPCaptchaWebView) r0
            java.lang.String r0 = r1.o
            java.lang.String r6 = "-"
            java.lang.String[] r0 = r0.split(r6)
            if (r0 == 0) goto L_0x01b6
            r7 = r0[r5]
            r1.s = r7
            r4 = r0[r4]
            r1.t = r4
            r4 = 2
            r4 = r0[r4]
            r1.u = r4
            r4 = 3
            r0 = r0[r4]
            r1.v = r0
        L_0x01b6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f5082a
            java.lang.String r4 = r4.getFromStnCode()
            r0.append(r4)
            java.lang.String r4 = " "
            r0.append(r4)
            r7 = 2131953827(0x7f1308a3, float:1.9544136E38)
            java.lang.String r7 = r1.getString(r7)
            r0.append(r7)
            r0.append(r4)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r7 = r1.f5082a
            java.lang.String r7 = r7.getToStnCode()
            r0.append(r7)
            java.lang.String r7 = " | "
            r0.append(r7)
            java.lang.String r8 = r1.f
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            cris.org.in.ima.activities.HomeActivity.H(r0)
            java.lang.String r8 = "h"
            java.lang.String r9 = "EEE, dd MMM"
            b1 r0 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r0 = r0.f3911a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r10 = r1.f5082a
            java.lang.String r10 = r10.getFromStnCode()
            java.lang.String r10 = r0.m(r10)
            java.lang.String r10 = defpackage.C0535I5.s0(r10)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r11 = r1.f5082a
            java.lang.String r11 = r11.getToStnCode()
            java.lang.String r11 = r0.m(r11)
            android.widget.TextView r0 = r1.trainNameView
            cris.prs.webservices.dto.TrainBtwnStnsDTO r12 = r1.f5082a
            java.lang.String r12 = r12.getTrainName()
            r0.setText(r12)
            android.widget.TextView r0 = r1.trainNumberView
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "("
            r12.<init>(r13)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r13 = r1.f5082a
            java.lang.String r13 = r13.getTrainNumber()
            r12.append(r13)
            java.lang.String r13 = ")"
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r1.f5081a
            java.util.ArrayList r0 = r0.getAvlDayList()
            java.lang.Object r0 = r0.get(r5)
            d2 r0 = (defpackage.C1060d2) r0
            java.lang.String r0 = r0.getAvailablityStatus()
            r1.l = r0
            java.lang.String r0 = r1.q
            if (r0 == 0) goto L_0x0273
            java.lang.String r0 = r1.r
            if (r0 == 0) goto L_0x0273
            android.widget.TextView r0 = r1.tv_payment_method_label
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r12 = r1.q
            r5.append(r12)
            java.lang.String r12 = "\n("
            r5.append(r12)
            java.lang.String r12 = r1.r
            r5.append(r12)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r0.setText(r5)
        L_0x0273:
            boolean r0 = r1.f5095c
            if (r0 == 0) goto L_0x0284
            android.widget.TextView r0 = r1.insurance_opt
            r5 = 2131954004(0x7f130954, float:1.9544495E38)
            java.lang.String r5 = r1.getString(r5)
            r0.setText(r5)
            goto L_0x0290
        L_0x0284:
            android.widget.TextView r0 = r1.insurance_opt
            r5 = 2131953281(0x7f130681, float:1.9543029E38)
            java.lang.String r5 = r1.getString(r5)
            r0.setText(r5)
        L_0x0290:
            android.widget.TextView r0 = r1.bookingStatusView
            java.lang.String r5 = r1.l
            r0.setText(r5)
            java.lang.String r0 = r1.l
            java.lang.String r5 = "WL"
            boolean r0 = r0.contains(r5)
            r5 = 2131100596(0x7f0603b4, float:1.7813578E38)
            if (r0 == 0) goto L_0x02b4
            android.widget.TextView r0 = r1.bookingStatusView
            android.content.Context r12 = r18.getContext()
            java.lang.Object r14 = defpackage.d7.a
            int r5 = defpackage.d7.b.a(r12, r5)
            r0.setTextColor(r5)
            goto L_0x02ea
        L_0x02b4:
            java.lang.String r0 = r1.l
            java.lang.String r12 = "RAC"
            boolean r0 = r0.contains(r12)
            if (r0 == 0) goto L_0x02d1
            android.widget.TextView r0 = r1.bookingStatusView
            android.content.Context r5 = r18.getContext()
            java.lang.Object r12 = defpackage.d7.a
            r12 = 2131099850(0x7f0600ca, float:1.7812065E38)
            int r5 = defpackage.d7.b.a(r5, r12)
            r0.setTextColor(r5)
            goto L_0x02ea
        L_0x02d1:
            java.lang.String r0 = r1.l
            java.lang.String r12 = "NOT AVAILABLE"
            boolean r0 = r0.contains(r12)
            if (r0 == 0) goto L_0x02ea
            android.widget.TextView r0 = r1.bookingStatusView
            android.content.Context r12 = r18.getContext()
            java.lang.Object r14 = defpackage.d7.a
            int r5 = defpackage.d7.b.a(r12, r5)
            r0.setTextColor(r5)
        L_0x02ea:
            android.widget.TextView r0 = r1.quota
            java.lang.String r5 = r1.f5096d
            r0.setText(r5)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x031c }
            java.lang.String r5 = "dd MMM EEEE yyyy"
            r0.<init>(r5)     // Catch:{ Exception -> 0x031c }
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x031c }
            java.lang.String r12 = "dd MMM yyyy"
            r5.<init>(r12)     // Catch:{ Exception -> 0x031c }
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x031c }
            r5.<init>(r9)     // Catch:{ Exception -> 0x031c }
            java.lang.String r12 = r1.f     // Catch:{ Exception -> 0x031c }
            java.util.Date r0 = r0.parse(r12)     // Catch:{ Exception -> 0x031c }
            java.lang.String r12 = defpackage.C0535I5.h(r0)     // Catch:{ Exception -> 0x031c }
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x031a }
            java.lang.String r14 = r1.u     // Catch:{ Exception -> 0x031a }
            r0.<init>(r14)     // Catch:{ Exception -> 0x031a }
            java.lang.String r0 = r5.format(r0)     // Catch:{ Exception -> 0x031a }
            goto L_0x0322
        L_0x031a:
            r0 = move-exception
            goto L_0x031e
        L_0x031c:
            r0 = move-exception
            r12 = r2
        L_0x031e:
            r0.getMessage()
            r0 = r2
        L_0x0322:
            android.widget.TextView r5 = r1.departureDateView
            r5.setText(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            r0.<init>(r9)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            java.lang.String r9 = "EEE, dd MMM yyyy"
            r5.<init>(r9)
            android.widget.TextView r9 = r1.arrivalDateView     // Catch:{ Exception -> 0x0343 }
            java.lang.String r14 = r1.h     // Catch:{ Exception -> 0x0343 }
            java.util.Date r14 = r5.parse(r14)     // Catch:{ Exception -> 0x0343 }
            java.lang.String r0 = r0.format(r14)     // Catch:{ Exception -> 0x0343 }
            r9.setText(r0)     // Catch:{ Exception -> 0x0343 }
            goto L_0x0347
        L_0x0343:
            r0 = move-exception
            r0.getMessage()
        L_0x0347:
            java.lang.String r0 = r1.v
            java.lang.String r9 = "null"
            if (r0 == 0) goto L_0x035b
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x035b
            android.widget.TextView r0 = r1.departureTimeView
            java.lang.String r14 = r1.v
            r0.setText(r14)
            goto L_0x0360
        L_0x035b:
            android.widget.TextView r0 = r1.departureTimeView
            r0.setText(r2)
        L_0x0360:
            android.widget.TextView r0 = r1.arrivalTimeView
            cris.prs.webservices.dto.TrainBtwnStnsDTO r14 = r1.f5082a
            java.lang.String r14 = r14.getArrivalTime()
            r0.setText(r14)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f5082a
            java.lang.String r0 = r0.getDuration()
            java.lang.String r14 = ":"
            java.lang.String[] r0 = r0.split(r14)
            boolean r15 = r1.f5092b
            r19 = r3
            java.lang.String r3 = "h:"
            r20 = r6
            java.lang.String r6 = "m"
            if (r15 == 0) goto L_0x04ac
            java.lang.String r0 = r1.v
            if (r0 == 0) goto L_0x049f
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f5082a
            java.lang.String r0 = r0.getArrivalTime()
            if (r0 == 0) goto L_0x049f
            android.widget.TextView r0 = r1.travelTimeView     // Catch:{ Exception -> 0x0497 }
            r15 = 0
            r0.setVisibility(r15)     // Catch:{ Exception -> 0x0497 }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0497 }
            java.lang.String r15 = "HH:mm"
            r0.<init>(r15)     // Catch:{ Exception -> 0x0497 }
            java.lang.String r15 = "Asia/Kolkata"
            java.util.TimeZone r15 = java.util.TimeZone.getTimeZone(r15)     // Catch:{ Exception -> 0x0497 }
            r0.setTimeZone(r15)     // Catch:{ Exception -> 0x0497 }
            java.lang.String r15 = r1.v     // Catch:{ Exception -> 0x0497 }
            java.util.Date r15 = r0.parse(r15)     // Catch:{ Exception -> 0x0497 }
            r21 = r4
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f5082a     // Catch:{ Exception -> 0x0491 }
            java.lang.String r4 = r4.getArrivalTime()     // Catch:{ Exception -> 0x0491 }
            java.util.Date r0 = r0.parse(r4)     // Catch:{ Exception -> 0x0491 }
            android.widget.TextView r4 = r1.travelTimeView     // Catch:{ Exception -> 0x0491 }
            r16 = r12
            java.util.Date r12 = new java.util.Date     // Catch:{ Exception -> 0x048d }
            r17 = r7
            java.lang.String r7 = r1.u     // Catch:{ Exception -> 0x048b }
            r12.<init>(r7)     // Catch:{ Exception -> 0x048b }
            java.util.Date r7 = r1.j(r12, r15)     // Catch:{ Exception -> 0x048b }
            java.lang.String r12 = r1.h     // Catch:{ Exception -> 0x048b }
            java.util.Date r12 = r5.parse(r12)     // Catch:{ Exception -> 0x048b }
            java.util.Date r12 = r1.j(r12, r0)     // Catch:{ Exception -> 0x048b }
            java.lang.String r7 = defpackage.C0535I5.A(r7, r12)     // Catch:{ Exception -> 0x048b }
            r4.setText(r7)     // Catch:{ Exception -> 0x048b }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f5089b     // Catch:{ Exception -> 0x048b }
            java.lang.String r4 = r4.getDuration()     // Catch:{ Exception -> 0x048b }
            java.lang.String[] r4 = r4.split(r14)     // Catch:{ Exception -> 0x048b }
            java.util.Date r7 = new java.util.Date     // Catch:{ Exception -> 0x048b }
            java.lang.String r12 = r1.u     // Catch:{ Exception -> 0x048b }
            r7.<init>(r12)     // Catch:{ Exception -> 0x048b }
            java.util.Date r7 = r1.j(r7, r15)     // Catch:{ Exception -> 0x048b }
            java.lang.String r12 = r1.h     // Catch:{ Exception -> 0x048b }
            java.util.Date r5 = r5.parse(r12)     // Catch:{ Exception -> 0x048b }
            java.util.Date r0 = r1.j(r5, r0)     // Catch:{ Exception -> 0x048b }
            java.lang.String r0 = defpackage.C0535I5.A(r7, r0)     // Catch:{ Exception -> 0x048b }
            java.lang.String[] r0 = r0.split(r14)     // Catch:{ Exception -> 0x048b }
            r5 = 0
            r5 = r0[r5]     // Catch:{ Exception -> 0x0485 }
            java.lang.String r5 = r5.replace(r8, r2)     // Catch:{ Exception -> 0x0485 }
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x0485 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0485 }
            int r5 = r5 * 60
            r7 = 1
            r7 = r0[r7]     // Catch:{ Exception -> 0x0485 }
            java.lang.String r7 = r7.replace(r6, r2)     // Catch:{ Exception -> 0x0485 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0485 }
            int r5 = r5 + r7
            cris.org.in.ima.model.TrainBtwnStnsModel r7 = r1.f5080a     // Catch:{ Exception -> 0x0485 }
            java.lang.Integer r7 = r7.f5345a     // Catch:{ Exception -> 0x0485 }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x0485 }
            java.lang.String r7 = defpackage.C0535I5.z(r7)     // Catch:{ Exception -> 0x0485 }
            java.lang.String[] r7 = r7.split(r14)     // Catch:{ Exception -> 0x0485 }
            r12 = 0
            r7 = r7[r12]     // Catch:{ Exception -> 0x0485 }
            java.lang.String r7 = r7.replace(r8, r2)     // Catch:{ Exception -> 0x0485 }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x0485 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0485 }
            int r7 = r7 * 60
            r8 = 1
            r0 = r0[r8]     // Catch:{ Exception -> 0x0485 }
            java.lang.String r0 = r0.replace(r6, r2)     // Catch:{ Exception -> 0x0485 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0485 }
            int r7 = r7 + r0
            r0 = 0
            r0 = r4[r0]     // Catch:{ Exception -> 0x0485 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0485 }
            int r0 = r0 * 60
            r8 = 1
            r4 = r4[r8]     // Catch:{ Exception -> 0x0485 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0485 }
            int r0 = r0 + r4
            int r5 = r5 + r7
            int r5 = r5 + r0
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0485 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0485 }
            int r4 = r0 / 60
            int r0 = r0 % 60
            android.widget.TextView r5 = r1.header_total_duration     // Catch:{ Exception -> 0x0485 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0485 }
            r7.<init>()     // Catch:{ Exception -> 0x0485 }
            r7.append(r4)     // Catch:{ Exception -> 0x0485 }
            r7.append(r3)     // Catch:{ Exception -> 0x0485 }
            r7.append(r0)     // Catch:{ Exception -> 0x0485 }
            r7.append(r6)     // Catch:{ Exception -> 0x0485 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0485 }
            r5.setText(r0)     // Catch:{ Exception -> 0x0485 }
            goto L_0x0502
        L_0x0485:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x048b }
            goto L_0x0502
        L_0x048b:
            r0 = move-exception
            goto L_0x049b
        L_0x048d:
            r0 = move-exception
            r17 = r7
            goto L_0x049b
        L_0x0491:
            r0 = move-exception
        L_0x0492:
            r17 = r7
            r16 = r12
            goto L_0x049b
        L_0x0497:
            r0 = move-exception
            r21 = r4
            goto L_0x0492
        L_0x049b:
            r0.getMessage()
            goto L_0x0502
        L_0x049f:
            r21 = r4
            r17 = r7
            r16 = r12
            android.widget.TextView r0 = r1.travelTimeView
            r3 = 4
            r0.setVisibility(r3)
            goto L_0x0502
        L_0x04ac:
            r21 = r4
            r17 = r7
            r16 = r12
            android.widget.TextView r4 = r1.travelTimeView
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r7 = 0
            r7 = r0[r7]
            r5.append(r7)
            java.lang.String r7 = "h : "
            r5.append(r7)
            r7 = 1
            r0 = r0[r7]
            r5.append(r0)
            r5.append(r6)
            java.lang.String r0 = r5.toString()
            r4.setText(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0502
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = r1.f5080a
            java.lang.Integer r0 = r0.f5347b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r0 = java.lang.Integer.parseInt(r0)
            int r4 = r0 / 60
            int r0 = r0 % 60
            android.widget.TextView r5 = r1.header_total_duration
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            r7.append(r3)
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = r7.toString()
            r5.setText(r0)
        L_0x0502:
            boolean r0 = r1.f5092b
            java.lang.String r3 = " ("
            if (r0 == 0) goto L_0x0535
            java.lang.String r0 = r1.v
            if (r0 == 0) goto L_0x051a
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x051a
            android.widget.TextView r0 = r1.departureTimeView
            java.lang.String r4 = r1.v
            r0.setText(r4)
            goto L_0x051f
        L_0x051a:
            android.widget.TextView r0 = r1.departureTimeView
            r0.setText(r2)
        L_0x051f:
            android.widget.TextView r0 = r1.fromStation
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r1.s
            java.lang.String r5 = defpackage.C0535I5.s0(r5)
            r4.append(r5)
            java.lang.String r5 = r1.t
            defpackage.lf.x(r4, r5, r0)
            goto L_0x0564
        L_0x0535:
            android.widget.TextView r0 = r1.departureTimeView
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f5082a
            java.lang.String r4 = r4.getDepartureTime()
            r0.setText(r4)
            android.widget.TextView r0 = r1.fromStation
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = defpackage.C0535I5.s0(r10)
            r4.append(r5)
            r4.append(r3)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r1.f5082a
            java.lang.String r5 = r5.getFromStnCode()
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.setText(r4)
        L_0x0564:
            android.widget.TextView r0 = r1.toStation
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = defpackage.C0535I5.s0(r11)
            r4.append(r5)
            r4.append(r3)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r1.f5082a
            java.lang.String r5 = r5.getToStnCode()
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r0.setText(r4)
            java.lang.String r0 = r1.f5093c
            if (r0 == 0) goto L_0x05b8
            java.lang.String r0 = defpackage.xx.e(r0)
            if (r0 == 0) goto L_0x05a7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r4 = r17
            r0.<init>(r4)
            java.lang.String r5 = r1.f5093c
            java.lang.String r5 = defpackage.xx.e(r5)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            goto L_0x05bb
        L_0x05a7:
            r4 = r17
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            java.lang.String r5 = r1.f5093c
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            goto L_0x05bb
        L_0x05b8:
            r4 = r17
            r0 = r2
        L_0x05bb:
            java.lang.String r5 = r1.f5096d
            if (r5 == 0) goto L_0x05f3
            H9 r5 = defpackage.H9.f(r5)
            if (r5 == 0) goto L_0x05e0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r6 = r1.f5096d
            H9 r6 = defpackage.H9.f(r6)
            java.lang.String r6 = r6.a()
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            goto L_0x05f4
        L_0x05e0:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r6 = r1.f5096d
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            goto L_0x05f4
        L_0x05f3:
            r5 = r2
        L_0x05f4:
            boolean r6 = r1.f5092b
            java.lang.String r7 = ") | "
            java.lang.String r8 = ", "
            if (r6 == 0) goto L_0x0666
            android.widget.TextView r6 = r1.psgnCountClassQuotaView     // Catch:{ Exception -> 0x065f }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x065f }
            r9.<init>()     // Catch:{ Exception -> 0x065f }
            java.lang.String r11 = r1.j     // Catch:{ Exception -> 0x065f }
            r9.append(r11)     // Catch:{ Exception -> 0x065f }
            r9.append(r8)     // Catch:{ Exception -> 0x065f }
            java.lang.String r8 = r1.k     // Catch:{ Exception -> 0x065f }
            r9.append(r8)     // Catch:{ Exception -> 0x065f }
            r9.append(r0)     // Catch:{ Exception -> 0x065f }
            r9.append(r3)     // Catch:{ Exception -> 0x065f }
            java.lang.String r0 = r1.f5093c     // Catch:{ Exception -> 0x065f }
            r9.append(r0)     // Catch:{ Exception -> 0x065f }
            r9.append(r13)     // Catch:{ Exception -> 0x065f }
            r9.append(r5)     // Catch:{ Exception -> 0x065f }
            r9.append(r3)     // Catch:{ Exception -> 0x065f }
            java.lang.String r0 = r1.f5096d     // Catch:{ Exception -> 0x065f }
            r9.append(r0)     // Catch:{ Exception -> 0x065f }
            r9.append(r7)     // Catch:{ Exception -> 0x065f }
            r9.append(r10)     // Catch:{ Exception -> 0x065f }
            java.lang.String r0 = "( "
            r9.append(r0)     // Catch:{ Exception -> 0x065f }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f5082a     // Catch:{ Exception -> 0x065f }
            java.lang.String r0 = r0.getFromStnCode()     // Catch:{ Exception -> 0x065f }
            r9.append(r0)     // Catch:{ Exception -> 0x065f }
            java.lang.String r0 = " ) | "
            r9.append(r0)     // Catch:{ Exception -> 0x065f }
            r12 = r16
            r9.append(r12)     // Catch:{ Exception -> 0x065f }
            r10 = r21
            r9.append(r10)     // Catch:{ Exception -> 0x065d }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f5082a     // Catch:{ Exception -> 0x065d }
            java.lang.String r0 = r0.getDepartureTime()     // Catch:{ Exception -> 0x065d }
            r9.append(r0)     // Catch:{ Exception -> 0x065d }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x065d }
            r6.setText(r0)     // Catch:{ Exception -> 0x065d }
            goto L_0x06bd
        L_0x065d:
            r0 = move-exception
            goto L_0x0662
        L_0x065f:
            r0 = move-exception
            r10 = r21
        L_0x0662:
            r0.getMessage()
            goto L_0x06bd
        L_0x0666:
            r10 = r21
            r12 = r16
            android.widget.TextView r6 = r1.psgnCountClassQuotaView
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = r1.j
            r9.append(r11)
            r9.append(r8)
            java.lang.String r8 = r1.k
            r9.append(r8)
            r9.append(r0)
            r9.append(r3)
            java.lang.String r0 = r1.f5093c
            r9.append(r0)
            r9.append(r13)
            r9.append(r5)
            r9.append(r3)
            java.lang.String r0 = r1.f5096d
            r9.append(r0)
            r9.append(r7)
            java.lang.String r0 = r1.s
            r9.append(r0)
            java.lang.String r0 = r1.t
            r9.append(r0)
            r9.append(r4)
            r9.append(r12)
            r9.append(r10)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r1.f5082a
            java.lang.String r0 = r0.getDepartureTime()
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r6.setText(r0)
        L_0x06bd:
            android.widget.TextView r0 = r1.netAmount
            android.content.res.Resources r3 = r18.getResources()
            r5 = 2131952833(0x7f1304c1, float:1.954212E38)
            java.lang.String r3 = r3.getString(r5)
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            f2 r8 = r1.f5083a
            java.lang.Double r8 = r8.getTotalCollectibleAmount()
            r9 = 0
            r7[r9] = r8
            java.lang.String r3 = java.lang.String.format(r3, r7)
            r0.setText(r3)
            android.widget.TextView r0 = r1.fastestcharge
            android.content.res.Resources r3 = r18.getResources()
            java.lang.String r3 = r3.getString(r5)
            java.lang.Object[] r6 = new java.lang.Object[r6]
            cris.prs.webservices.dto.AvlFareResponseDTO r7 = r1.f5081a
            java.lang.Integer r7 = r7.getTotalFare()
            int r7 = r7.intValue()
            double r7 = (double) r7
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r8 = 0
            r6[r8] = r7
            java.lang.String r3 = java.lang.String.format(r3, r6)
            r0.setText(r3)
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r1.f5081a
            java.lang.Double r0 = r0.getWpServiceCharge()
            double r6 = r0.doubleValue()
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r1.f5081a
            java.lang.Double r0 = r0.getWpServiceTax()
            double r8 = r0.doubleValue()
            double r8 = r8 + r6
            java.lang.Double r0 = java.lang.Double.valueOf(r8)
            r1.f5084a = r0
            android.widget.TextView r0 = r1.ConvenienceFee
            android.content.res.Resources r3 = r18.getResources()
            java.lang.String r3 = r3.getString(r5)
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Double r8 = r1.f5084a
            r9 = 0
            r7[r9] = r8
            java.lang.String r3 = java.lang.String.format(r3, r7)
            r0.setText(r3)
            android.widget.TextView r0 = r1.totalamount
            android.content.res.Resources r3 = r18.getResources()
            java.lang.String r3 = r3.getString(r5)
            java.lang.Object[] r6 = new java.lang.Object[r6]
            f2 r7 = r1.f5083a
            java.lang.Double r7 = r7.getTotalCollectibleAmount()
            r6[r9] = r7
            java.lang.String r3 = java.lang.String.format(r3, r6)
            r0.setText(r3)
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r1.f5081a
            java.lang.Double r0 = r0.getTravelInsuranceCharge()
            double r6 = r0.doubleValue()
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r1.f5081a
            java.lang.Double r0 = r0.getTravelInsuranceServiceTax()
            double r8 = r0.doubleValue()
            double r8 = r8 + r6
            java.lang.Double r0 = java.lang.Double.valueOf(r8)
            r1.f5090b = r0
            android.widget.TextView r0 = r1.insurancecharge
            android.content.res.Resources r3 = r18.getResources()
            java.lang.String r3 = r3.getString(r5)
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Double r6 = r1.f5090b
            r7 = 0
            r5[r7] = r6
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r0.setText(r3)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r3 = r18.getContext()
            java.lang.Object r5 = defpackage.d7.a
            r5 = 2131099739(0x7f06005b, float:1.781184E38)
            int r3 = defpackage.d7.b.a(r3, r5)
            r0.<init>(r3)
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            android.content.Context r6 = r18.getContext()
            int r6 = defpackage.d7.b.a(r6, r5)
            r3.<init>(r6)
            android.text.style.ForegroundColorSpan r6 = new android.text.style.ForegroundColorSpan
            android.content.Context r7 = r18.getContext()
            int r5 = defpackage.d7.b.a(r7, r5)
            r6.<init>(r5)
            android.text.SpannableStringBuilder r5 = new android.text.SpannableStringBuilder
            r5.<init>()
            r7 = 2131954017(0x7f130961, float:1.9544521E38)
            java.lang.String r7 = r1.getString(r7)
            android.text.SpannableString r8 = new android.text.SpannableString
            r8.<init>(r7)
            r5.append(r8)
            android.content.Context r7 = r18.getContext()
            Bw r7 = defpackage.Bw.e(r7)
            java.lang.String r7 = r7.j()
            java.lang.String r7 = defpackage.C0535I5.d0(r7)
            android.text.SpannableString r8 = new android.text.SpannableString
            r8.<init>(r7)
            int r7 = r8.length()
            r9 = 0
            r8.setSpan(r0, r9, r7, r9)
            r5.append(r8)
            android.text.SpannableString r0 = new android.text.SpannableString
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r10)
            r8 = 2131952285(0x7f13029d, float:1.9541008E38)
            java.lang.String r8 = r1.getString(r8)
            r7.append(r8)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            r5.append(r0)
            int r0 = defpackage.C0535I5.d
            if (r0 == 0) goto L_0x0817
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r7 = "+"
            r0.<init>(r7)
            int r7 = defpackage.C0535I5.d
            r8 = r20
            java.lang.String r0 = defpackage.lf.k(r0, r7, r8)
            goto L_0x0818
        L_0x0817:
            r0 = r2
        L_0x0818:
            android.text.SpannableString r7 = new android.text.SpannableString
            r7.<init>(r0)
            int r0 = r7.length()
            r8 = 0
            r7.setSpan(r3, r8, r0, r8)
            r5.append(r7)
            java.lang.String r0 = r1.p
            java.lang.String r0 = defpackage.C0535I5.e0(r0)
            android.text.SpannableString r3 = new android.text.SpannableString
            r3.<init>(r0)
            int r0 = r3.length()
            r3.setSpan(r6, r8, r0, r8)
            r5.append(r3)
            java.lang.String r0 = cris.org.in.ima.IrctcImaApplication.e
            java.lang.String r3 = "hi"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x0862
            android.text.SpannableString r0 = new android.text.SpannableString
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r10)
            r7 = 2131953717(0x7f130835, float:1.9543913E38)
            java.lang.String r7 = r1.getString(r7)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r0.<init>(r6)
            r5.append(r0)
        L_0x0862:
            android.widget.TextView r0 = r1.ticketSentLevelView
            android.widget.TextView$BufferType r6 = android.widget.TextView.BufferType.SPANNABLE
            r0.setText(r5, r6)
            java.lang.String r0 = r1.p
            defpackage.C0535I5.f3639e = r0
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x08aa
            r18.t()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r1.f5082a
            java.lang.String r5 = r5.getFromStnCode()
            r0.append(r5)
            r0.append(r10)
            r5 = 2131953827(0x7f1308a3, float:1.9544136E38)
            java.lang.String r5 = r1.getString(r5)
            r0.append(r5)
            r0.append(r10)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r1.f5089b
            java.lang.String r5 = r5.getToStnCode()
            r0.append(r5)
            r0.append(r4)
            java.lang.String r4 = r1.f
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            cris.org.in.ima.activities.HomeActivity.H(r0)
        L_0x08aa:
            cris.org.in.ima.adaptors.ReviewPassengerAdapter r0 = new cris.org.in.ima.adaptors.ReviewPassengerAdapter
            androidx.fragment.app.FragmentActivity r4 = r1.f5074a
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r5 = r1.f5085a
            r0.<init>(r4, r5)
            androidx.recyclerview.widget.RecyclerView r4 = r1.passengerListView
            androidx.recyclerview.widget.LinearLayoutManager r5 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r6 = r18.getContext()
            r5.<init>(r6)
            r4.setLayoutManager(r5)
            androidx.recyclerview.widget.RecyclerView r4 = r1.passengerListView
            r4.setAdapter(r0)
            boolean r0 = defpackage.C0535I5.f3647h
            r4 = 8
            if (r0 == 0) goto L_0x091e
            android.widget.LinearLayout r0 = r1.fare_backup_single_jrny
            r0.setVisibility(r4)
            androidx.recyclerview.widget.RecyclerView r0 = r1.farebreakup
            r5 = 0
            r0.setVisibility(r5)
            cris.org.in.ima.adaptors.ReviewPassengerAdapterLap2 r0 = new cris.org.in.ima.adaptors.ReviewPassengerAdapterLap2
            androidx.fragment.app.FragmentActivity r5 = r1.f5074a
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r6 = r1.f5091b
            r0.<init>(r5, r6)
            androidx.recyclerview.widget.RecyclerView r5 = r1.passenger_list2
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r7 = r18.getContext()
            r6.<init>(r7)
            r5.setLayoutManager(r6)
            androidx.recyclerview.widget.RecyclerView r5 = r1.passenger_list2
            r5.setAdapter(r0)
            java.util.ArrayList r0 = r1.f5101f
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r1.f5082a
            r0.add(r5)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r1.f5089b
            r0.add(r5)
            cris.org.in.ima.adaptors.ReviewFarebreakupAdapter r5 = new cris.org.in.ima.adaptors.ReviewFarebreakupAdapter
            androidx.fragment.app.FragmentActivity r6 = r1.f5074a
            java.util.List<cris.prs.webservices.dto.AvlFareResponseDTO> r7 = r1.f5086a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r5.<init>(r6, r7, r0)
            androidx.recyclerview.widget.RecyclerView r0 = r1.farebreakup
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r7 = r18.getContext()
            r6.<init>(r7)
            r0.setLayoutManager(r6)
            androidx.recyclerview.widget.RecyclerView r0 = r1.farebreakup
            r0.setAdapter(r5)
            goto L_0x0929
        L_0x091e:
            android.widget.LinearLayout r0 = r1.fare_backup_single_jrny
            r5 = 0
            r0.setVisibility(r5)
            androidx.recyclerview.widget.RecyclerView r0 = r1.farebreakup
            r0.setVisibility(r4)
        L_0x0929:
            android.text.SpannableStringBuilder r5 = new android.text.SpannableStringBuilder
            android.content.res.Resources r0 = r18.getResources()
            r6 = 2131952933(0x7f130525, float:1.9542323E38)
            java.lang.String r0 = r0.getString(r6)
            r5.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r6 = r18.getContext()
            r7 = 2131099733(0x7f060055, float:1.7811828E38)
            int r6 = defpackage.d7.b.a(r6, r7)
            r0.<init>(r6)
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r7 = 1
            r6.<init>(r7)
            cris.org.in.ima.fragment.ReviewAndPayFragment$a r7 = new cris.org.in.ima.fragment.ReviewAndPayFragment$a
            r7.<init>()
            java.lang.String r8 = cris.org.in.ima.IrctcImaApplication.e     // Catch:{ Exception -> 0x097c }
            boolean r3 = r8.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x097c }
            r8 = 33
            r9 = 18
            if (r3 == 0) goto L_0x096e
            r3 = 62
            r10 = 45
            r5.setSpan(r6, r10, r3, r9)     // Catch:{ Exception -> 0x097c }
            r5.setSpan(r7, r10, r3, r8)     // Catch:{ Exception -> 0x097c }
            r5.setSpan(r0, r10, r3, r9)     // Catch:{ Exception -> 0x097c }
            goto L_0x0980
        L_0x096e:
            r3 = 65
            r10 = 47
            r5.setSpan(r6, r10, r3, r9)     // Catch:{ Exception -> 0x097c }
            r5.setSpan(r7, r10, r3, r8)     // Catch:{ Exception -> 0x097c }
            r5.setSpan(r0, r10, r3, r9)     // Catch:{ Exception -> 0x097c }
            goto L_0x0980
        L_0x097c:
            r0 = move-exception
            r0.getMessage()
        L_0x0980:
            android.widget.TextView r0 = r1.termcondition
            r0.setText(r5)
            android.widget.TextView r0 = r1.termcondition
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r3)
            f2 r0 = r1.f5083a
            E4 r0 = r0.getCaptchaDto()
            java.lang.Integer r0 = r0.getCaptcha()
            int r0 = r0.intValue()
            r1.c = r0
            boolean r0 = r1.f5088a
            r3 = 10
            r5 = 20
            if (r0 == 0) goto L_0x09be
            r18.h()
            int r0 = r1.c
            if (r5 != r0) goto L_0x09b7
            r18.m()
            android.widget.LinearLayout r0 = r1.llOtpInput
            r2 = 0
            r0.setVisibility(r2)
            goto L_0x09f7
        L_0x09b7:
            if (r3 != r0) goto L_0x09f7
            r0 = 0
            r1.l(r0)
            goto L_0x09f7
        L_0x09be:
            r0 = 0
            r18.h()
            int r6 = r1.c
            if (r5 != r6) goto L_0x09cc
            android.widget.LinearLayout r2 = r1.llOtpInput
            r2.setVisibility(r0)
            goto L_0x09f7
        L_0x09cc:
            if (r3 != r6) goto L_0x09f7
            f2 r0 = r1.f5083a
            E4 r0 = r0.getCaptchaDto()
            java.lang.String r0 = r0.getCaptchaQuestion()
            if (r0 == 0) goto L_0x09f7
            f2 r0 = r1.f5083a
            E4 r0 = r0.getCaptchaDto()
            java.lang.String r0 = r0.getCaptchaQuestion()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x09f7
            f2 r0 = r1.f5083a
            E4 r0 = r0.getCaptchaDto()
            java.lang.String r0 = r0.getCaptchaQuestion()
            r1.q(r0)
        L_0x09f7:
            java.util.ArrayList<cris.prs.webservices.dto.MealItemDetails> r0 = r1.f5097d
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0a02
            r18.s()
        L_0x0a02:
            r18.o()
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r0 = r1.f5085a
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            cris.prs.webservices.dto.PassengerDetailDTO r0 = (cris.prs.webservices.dto.PassengerDetailDTO) r0
            java.lang.String r0 = r0.getPassengerNationality()
            java.lang.String r3 = "IN"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0a20
            android.widget.LinearLayout r0 = r1.travel_insurance_ll
            r0.setVisibility(r4)
            goto L_0x0a25
        L_0x0a20:
            android.widget.LinearLayout r0 = r1.travel_insurance_ll
            r0.setVisibility(r2)
        L_0x0a25:
            boolean r0 = defpackage.C0535I5.f3647h
            if (r0 == 0) goto L_0x0a68
            android.widget.LinearLayout r0 = r1.ll_wait_duration_lap1
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.ll_from_to_header_lap
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.lap1_heading
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.ll_tainname_haedind_lap2
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.tain_detail_ll_lap2
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.passenger_detail_lap1
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.passanger_detail_lap2
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.travel_insurance_ll_lap1
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.travel_insurance_ll_lap2
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.psgn_detail_heading
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.tv_insurance_opt_lap1
            r2 = 2131952135(0x7f130207, float:1.9540704E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            goto L_0x0ab7
        L_0x0a68:
            android.widget.LinearLayout r0 = r1.ll_wait_duration_lap1
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_from_to_header_lap
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.lap1_heading
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_tainname_haedind_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.tain_detail_ll_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.passenger_detail_lap1
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.passanger_detail_lap2
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.travel_insurance_ll_lap1
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.travel_insurance_ll_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.psgn_detail_heading
            r2 = 0
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.ll_tainname_haedind_lap1
            android.content.res.Resources r2 = r18.getResources()
            r3 = 2131100644(0x7f0603e4, float:1.7813675E38)
            int r2 = r2.getColor(r3)
            r0.setBackgroundColor(r2)
            android.widget.TextView r0 = r1.tv_insurance_opt_lap1
            r2 = 2131952134(0x7f130206, float:1.9540702E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
        L_0x0ab7:
            boolean r0 = r1.f5095c
            if (r0 == 0) goto L_0x0acf
            java.lang.String r0 = r1.q
            if (r0 == 0) goto L_0x0acf
            java.lang.String r0 = r1.r
            if (r0 == 0) goto L_0x0acf
            android.widget.LinearLayout r0 = r1.ll_payment_method_label
            r2 = 0
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.ll_travel_insurance
            r0.setVisibility(r2)
            goto L_0x0ad9
        L_0x0acf:
            android.widget.LinearLayout r0 = r1.ll_payment_method_label
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_travel_insurance
            r0.setVisibility(r4)
        L_0x0ad9:
            java.lang.String r0 = r1.w
            if (r0 == 0) goto L_0x0af0
            java.lang.String r2 = "redemption"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0af0
            android.widget.LinearLayout r0 = r1.ll_payment_method_label
            r0.setVisibility(r4)
            android.widget.LinearLayout r0 = r1.ll_travel_insurance
            r0.setVisibility(r4)
            goto L_0x0afb
        L_0x0af0:
            android.widget.LinearLayout r0 = r1.ll_payment_method_label
            r2 = 0
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r1.ll_travel_insurance
            r0.setVisibility(r2)
        L_0x0afb:
            android.widget.EditText r0 = r1.captchaInput
            cris.org.in.ima.fragment.ReviewAndPayFragment$t r2 = new cris.org.in.ima.fragment.ReviewAndPayFragment$t
            r2.<init>()
            r0.addTextChangedListener(r2)
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ReviewAndPayFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131362637})
    public void onFareBackClose(View view) {
        this.farelayout.setVisibility(8);
    }

    @OnClick({2131362632})
    public void onFareBackUp(View view) {
        this.farelayout.setVisibility(0);
        if (!this.f5085a.get(0).getPassengerNationality().equals("IN")) {
            this.travel_insurance_rl.setVisibility(8);
        }
    }

    @OnClick({2131363169})
    public void onMakePaymentClick(View view) {
        InformationMessageDTO informationMessageDTO;
        String str;
        String str2;
        Iterator<InformationMessageDTO> it = C1450w1.f7010a.iterator();
        while (true) {
            if (!it.hasNext()) {
                informationMessageDTO = null;
                break;
            }
            informationMessageDTO = it.next();
            if (informationMessageDTO.getParamName().equalsIgnoreCase("REVIEW_MSG") && informationMessageDTO.getPopup().booleanValue()) {
                break;
            }
        }
        if (informationMessageDTO == null || !informationMessageDTO.getPopup().booleanValue() || informationMessageDTO.getMessage() == null) {
            r();
            return;
        }
        if (informationMessageDTO.getAcceptButton() != null) {
            str = informationMessageDTO.getAcceptButton().split("_")[0];
        } else {
            str = "OK";
        }
        String str3 = str;
        if (informationMessageDTO.getRejectButton() != null) {
            str2 = informationMessageDTO.getRejectButton().split("_")[0];
        } else {
            str2 = "";
        }
        Spanned fromHtml = Html.fromHtml(informationMessageDTO.getMessage());
        C0535I5.n(getActivity(), fromHtml, getString(R.string.Alert), str3, new f(), str2, new g()).show();
    }

    @OnClick({2131363678})
    public void onOtpResend(View view) {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f5074a)) {
            new Handler().postDelayed(new C0741Wt(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            this.a = ProgressDialog.show(this.f5074a, getString(R.string.Resending_OTP), getString(R.string.please_wait_text), false, false);
            String f2 = C0657Qt.f();
            String format = String.format("/%s", new Object[]{this.f5083a.getCaptchaDto().getCaptchaType()});
            ((Om) C0657Qt.c(b1Var.f3912a)).T(f2 + "resendOTP" + format).c(C1181iv.a()).a(E0.a()).b(new Xt(this));
            return;
        }
        C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        this.d = 0;
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    public final boolean p() {
        if (this.farelayout.getVisibility() != 0) {
            return false;
        }
        this.farelayout.setVisibility(8);
        return true;
    }

    public final void q(String str) {
        this.llCaptchaInput.setVisibility(0);
        if (str == null || str.equals("")) {
            this.captcha.setVisibility(8);
            this.loadingCaptcha.setVisibility(0);
            return;
        }
        this.loadingCaptcha.setVisibility(8);
        byte[] decode = Base64.decode(str.getBytes(), 0);
        this.captcha.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        this.captcha.setVisibility(0);
    }

    public final void r() {
        Context context = getContext();
        View view = getView();
        AlertDialog alertDialog = C0535I5.f3619a;
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        if (C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            int i2 = this.c;
            C0793b1 b1Var = C0793b1.a;
            if (20 == i2) {
                String obj = this.otpInput.getText().toString();
                if (obj == null || TextUtils.isEmpty(obj) || TextUtils.getTrimmedLength(obj) <= 0) {
                    C0535I5.m(getActivity(), false, getString(R.string.enter_valid_otp), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else if (b1Var.f3912a != null) {
                    String str = PassengerDetailFragment.U;
                    if (!str.equals("")) {
                        C0535I5.p(getActivity(), false, str.replace("%s", this.netAmount.getText().toString()), getString(R.string.confirmation), getString(R.string.yes), new h(obj), getString(R.string.no), (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    n(obj);
                } else {
                    C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else if (10 == i2) {
                String obj2 = this.captchaInput.getText().toString();
                if (obj2 == null || TextUtils.isEmpty(obj2) || TextUtils.getTrimmedLength(obj2) <= 0) {
                    C0535I5.m(getActivity(), false, getResources().getString(R.string.blank_captcha), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else if (b1Var.f3912a != null) {
                    String str2 = PassengerDetailFragment.U;
                    if (!str2.equals("")) {
                        C0535I5.p(getActivity(), false, str2.replace("%s", this.netAmount.getText().toString()), getString(R.string.confirmation), getString(R.string.yes), new i(obj2), getString(R.string.no), (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    n(obj2);
                } else {
                    C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            }
        }
    }

    @OnClick({2131362129})
    public void refreshCaptchaCNFPwd(View view) {
        l(this.f5083a.getCaptchaDto().getCaptchaType());
    }

    public final void s() {
        this.add_meal_ll.setVisibility(0);
        this.rv_addmeal_list.setVisibility(0);
        C0535I5.f3643f = true;
        C0535I5.f3645g = false;
        this.rv_addmeal_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_addmeal_list.setAdapter(new MealDetaillViewHolder(this.f5074a, this.f5097d, (MealDetaillViewHolder.AddMealHolderListener) null));
        if (C0535I5.f3647h) {
            this.add_meal_ll_lap2.setVisibility(0);
            this.rv_addmeal_list_lap2.setLayoutManager(new LinearLayoutManager(getContext()));
            this.rv_addmeal_list_lap2.setAdapter(new MealDetaillViewHolder(this.f5074a, this.f5099e, (MealDetaillViewHolder.AddMealHolderListener) null));
        }
        Iterator<MealItemDetails> it = this.f5097d.iterator();
        double d2 = 0.0d;
        double d3 = 0.0d;
        while (it.hasNext()) {
            MealItemDetails next = it.next();
            d3 += (double) (next.getMealRate() * ((float) next.getQuantity()));
        }
        if (C0535I5.f3647h) {
            Iterator<MealItemDetails> it2 = this.f5099e.iterator();
            while (it2.hasNext()) {
                MealItemDetails next2 = it2.next();
                d2 += (double) (next2.getMealRate() * ((float) next2.getQuantity()));
            }
        }
        if (C0535I5.f3647h) {
            TextView textView = this.total_amount;
            textView.setText(String.valueOf("₹ " + (d3 + d2)));
            return;
        }
        this.total_amount.setText(String.valueOf("₹ " + d3));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x04a1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x04de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t() {
        /*
            r14 = this;
            java.lang.String r0 = "EEE, dd MMM"
            java.lang.String r1 = ""
            b1 r2 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r2 = r2.f3911a
            cris.prs.webservices.dto.TrainBtwnStnsDTO r3 = r14.f5089b
            java.lang.String r3 = r3.getFromStnCode()
            java.lang.String r3 = r2.m(r3)
            java.lang.String r3 = defpackage.C0535I5.s0(r3)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r14.f5082a
            java.lang.String r4 = r4.getFromStnCode()
            java.lang.String r4 = r2.m(r4)
            java.lang.String r4 = defpackage.C0535I5.s0(r4)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r5 = r14.f5089b
            java.lang.String r5 = r5.getToStnCode()
            java.lang.String r2 = r2.m(r5)
            android.widget.TextView r5 = r14.selected_train_name_lap2
            cris.prs.webservices.dto.TrainBtwnStnsDTO r6 = r14.f5089b
            java.lang.String r6 = r6.getTrainName()
            r5.setText(r6)
            android.widget.TextView r5 = r14.selected_train_number_lap2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "("
            r6.<init>(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r8 = r14.f5089b
            java.lang.String r8 = r8.getTrainNumber()
            r6.append(r8)
            java.lang.String r8 = ")"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r5.setText(r6)
            android.widget.TextView r5 = r14.tv_wait_duration
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r9 = 2131952164(0x7f130224, float:1.9540763E38)
            java.lang.String r9 = r14.getString(r9)
            r6.append(r9)
            cris.org.in.ima.model.TrainBtwnStnsModel r9 = r14.f5080a
            java.lang.Integer r9 = r9.f5345a
            int r9 = r9.intValue()
            java.lang.String r9 = defpackage.C0535I5.z(r9)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r5.setText(r6)
            cris.prs.webservices.dto.AvlFareResponseDTO r5 = r14.b
            java.util.ArrayList r5 = r5.getAvlDayList()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            d2 r5 = (defpackage.C1060d2) r5
            java.lang.String r5 = r5.getAvailablityStatus()
            r14.l = r5
            boolean r5 = r14.f5098d
            if (r5 == 0) goto L_0x00a2
            android.widget.TextView r5 = r14.tv_insurance_opt_lap2
            r9 = 2131954004(0x7f130954, float:1.9544495E38)
            java.lang.String r9 = r14.getString(r9)
            r5.setText(r9)
            goto L_0x00ae
        L_0x00a2:
            android.widget.TextView r5 = r14.tv_insurance_opt_lap2
            r9 = 2131953281(0x7f130681, float:1.9543029E38)
            java.lang.String r9 = r14.getString(r9)
            r5.setText(r9)
        L_0x00ae:
            android.widget.TextView r5 = r14.booking_status_lap2
            java.lang.String r9 = r14.l
            r5.setText(r9)
            java.lang.String r5 = r14.l
            java.lang.String r9 = "WL"
            boolean r5 = r5.contains(r9)
            r9 = 2131100596(0x7f0603b4, float:1.7813578E38)
            if (r5 == 0) goto L_0x00d2
            android.widget.TextView r5 = r14.booking_status_lap2
            android.content.Context r10 = r14.getContext()
            java.lang.Object r11 = defpackage.d7.a
            int r9 = defpackage.d7.b.a(r10, r9)
            r5.setTextColor(r9)
            goto L_0x0108
        L_0x00d2:
            java.lang.String r5 = r14.l
            java.lang.String r10 = "RAC"
            boolean r5 = r5.contains(r10)
            if (r5 == 0) goto L_0x00ef
            android.widget.TextView r5 = r14.booking_status_lap2
            android.content.Context r9 = r14.getContext()
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131099850(0x7f0600ca, float:1.7812065E38)
            int r9 = defpackage.d7.b.a(r9, r10)
            r5.setTextColor(r9)
            goto L_0x0108
        L_0x00ef:
            java.lang.String r5 = r14.l
            java.lang.String r10 = "NOT AVAILABLE"
            boolean r5 = r5.contains(r10)
            if (r5 == 0) goto L_0x0108
            android.widget.TextView r5 = r14.bookingStatusView
            android.content.Context r10 = r14.getContext()
            java.lang.Object r11 = defpackage.d7.a
            int r9 = defpackage.d7.b.a(r10, r9)
            r5.setTextColor(r9)
        L_0x0108:
            android.widget.TextView r5 = r14.tv_quota_lap2
            java.lang.String r9 = r14.f5096d
            r5.setText(r9)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0142 }
            java.lang.String r9 = "dd MMM EEEE yyyy"
            r5.<init>(r9)     // Catch:{ Exception -> 0x0142 }
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0142 }
            java.lang.String r10 = "dd MMM yyyy"
            r9.<init>(r10)     // Catch:{ Exception -> 0x0142 }
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0142 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x0142 }
            java.lang.String r10 = r14.g     // Catch:{ Exception -> 0x0142 }
            java.util.Date r5 = r5.parse(r10)     // Catch:{ Exception -> 0x0142 }
            java.lang.String r5 = defpackage.C0535I5.h(r5)     // Catch:{ Exception -> 0x0142 }
            java.util.Date r10 = new java.util.Date     // Catch:{ Exception -> 0x0140 }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r11 = r14.f5089b     // Catch:{ Exception -> 0x0140 }
            java.util.Date r11 = r11.getJourneyDate()     // Catch:{ Exception -> 0x0140 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0140 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0140 }
            java.lang.String r9 = r9.format(r10)     // Catch:{ Exception -> 0x0140 }
            goto L_0x0149
        L_0x0140:
            r9 = move-exception
            goto L_0x0145
        L_0x0142:
            r5 = move-exception
            r9 = r5
            r5 = r1
        L_0x0145:
            r9.getMessage()
            r9 = r1
        L_0x0149:
            android.widget.TextView r10 = r14.tv_dep_date_lap2
            r10.setText(r9)
            java.text.SimpleDateFormat r9 = new java.text.SimpleDateFormat
            r9.<init>(r0)
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r10 = "EEE, dd MMM yyyy"
            r0.<init>(r10)
            android.widget.TextView r10 = r14.tv_arv_date_lap2     // Catch:{ Exception -> 0x016a }
            java.lang.String r11 = r14.i     // Catch:{ Exception -> 0x016a }
            java.util.Date r0 = r0.parse(r11)     // Catch:{ Exception -> 0x016a }
            java.lang.String r0 = r9.format(r0)     // Catch:{ Exception -> 0x016a }
            r10.setText(r0)     // Catch:{ Exception -> 0x016a }
            goto L_0x016e
        L_0x016a:
            r0 = move-exception
            r0.getMessage()
        L_0x016e:
            java.lang.String r0 = r14.v
            if (r0 == 0) goto L_0x0186
            java.lang.String r9 = "null"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x0186
            android.widget.TextView r0 = r14.tv_dep_time_lap2
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r14.f5089b
            java.lang.String r9 = r9.getDepartureTime()
            r0.setText(r9)
            goto L_0x018b
        L_0x0186:
            android.widget.TextView r0 = r14.tv_dep_time_lap2
            r0.setText(r1)
        L_0x018b:
            android.widget.TextView r0 = r14.tv_arv_timee_lap2
            cris.prs.webservices.dto.TrainBtwnStnsDTO r9 = r14.f5089b
            java.lang.String r9 = r9.getArrivalTime()
            r0.setText(r9)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r0 = r14.f5089b
            java.lang.String r0 = r0.getDuration()
            java.lang.String r9 = ":"
            java.lang.String[] r0 = r0.split(r9)
            boolean r9 = r14.f5092b
            java.lang.String r10 = "m"
            r11 = 1
            if (r9 == 0) goto L_0x01ca
            android.widget.TextView r9 = r14.travel_Time_lap2
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r13 = r0[r6]
            r12.append(r13)
            java.lang.String r13 = "h : "
            r12.append(r13)
            r0 = r0[r11]
            r12.append(r0)
            r12.append(r10)
            java.lang.String r0 = r12.toString()
            r9.setText(r0)
            goto L_0x01ea
        L_0x01ca:
            android.widget.TextView r9 = r14.travel_Time_lap2
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r13 = r0[r6]
            r12.append(r13)
            java.lang.String r13 = "h "
            r12.append(r13)
            r0 = r0[r11]
            r12.append(r0)
            r12.append(r10)
            java.lang.String r0 = r12.toString()
            r9.setText(r0)
        L_0x01ea:
            android.widget.TextView r0 = r14.tv_from_stationname_lap2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = defpackage.C0535I5.s0(r3)
            r9.append(r10)
            java.lang.String r10 = " ("
            r9.append(r10)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r12 = r14.f5089b
            java.lang.String r12 = r12.getFromStnCode()
            r9.append(r12)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            r0.setText(r9)
            android.widget.TextView r0 = r14.tv_to_stationname_lap2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = defpackage.C0535I5.s0(r2)
            r9.append(r12)
            r9.append(r10)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r12 = r14.f5089b
            java.lang.String r12 = r12.getToStnCode()
            r9.append(r12)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            r0.setText(r9)
            android.widget.TextView r0 = r14.header_fromstn
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r4 = defpackage.C0535I5.s0(r4)
            r9.append(r4)
            r9.append(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r14.f5082a
            java.lang.String r4 = r4.getFromStnCode()
            r9.append(r4)
            r9.append(r8)
            java.lang.String r4 = r9.toString()
            r0.setText(r4)
            android.widget.TextView r0 = r14.header_tomstn
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = defpackage.C0535I5.s0(r2)
            r4.append(r2)
            r4.append(r10)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r2 = r14.f5089b
            java.lang.String r2 = r2.getToStnCode()
            r4.append(r2)
            r4.append(r8)
            java.lang.String r2 = r4.toString()
            r0.setText(r2)
            android.widget.TextView r0 = r14.header_Via
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "VIA: "
            r2.<init>(r4)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r14.f5082a
            java.lang.String r4 = r4.getToStnCode()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.setText(r2)
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r14.b
            java.lang.String r0 = r0.getEnqClass()
            if (r0 == 0) goto L_0x02d5
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r14.b
            java.lang.String r0 = r0.getEnqClass()
            java.lang.String r0 = defpackage.xx.e(r0)
            java.lang.String r2 = " | "
            if (r0 == 0) goto L_0x02c2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            cris.prs.webservices.dto.AvlFareResponseDTO r2 = r14.b
            java.lang.String r2 = r2.getEnqClass()
            java.lang.String r2 = defpackage.xx.e(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x02d6
        L_0x02c2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            cris.prs.webservices.dto.AvlFareResponseDTO r2 = r14.b
            java.lang.String r2 = r2.getEnqClass()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x02d6
        L_0x02d5:
            r0 = r1
        L_0x02d6:
            java.lang.String r2 = r14.f5096d
            if (r2 == 0) goto L_0x02f3
            H9 r2 = defpackage.H9.f(r2)
            if (r2 == 0) goto L_0x02ee
            java.lang.String r2 = r14.f5096d
            H9 r2 = defpackage.H9.f(r2)
            java.lang.String r2 = r2.a()
            defpackage.C0535I5.s0(r2)
            goto L_0x02f3
        L_0x02ee:
            java.lang.String r2 = r14.f5096d
            defpackage.C0535I5.s0(r2)
        L_0x02f3:
            android.widget.TextView r2 = r14.psgnCount_Class_Quota_lap2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = r14.j
            r4.append(r8)
            java.lang.String r8 = ", "
            r4.append(r8)
            java.lang.String r8 = r14.k
            r4.append(r8)
            r4.append(r0)
            r4.append(r10)
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r14.b
            java.lang.String r0 = r0.getEnqClass()
            r4.append(r0)
            java.lang.String r0 = ") | "
            r4.append(r0)
            java.lang.String r8 = r14.e
            H9 r8 = defpackage.H9.f(r8)
            java.lang.String r8 = r8.a()
            r4.append(r8)
            r4.append(r10)
            java.lang.String r8 = r14.e
            r4.append(r8)
            r4.append(r0)
            r4.append(r3)
            r4.append(r7)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r3 = r14.f5089b
            java.lang.String r3 = r3.getFromStnCode()
            r4.append(r3)
            r4.append(r0)
            r4.append(r5)
            java.lang.String r0 = " "
            r4.append(r0)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r3 = r14.f5089b
            java.lang.String r3 = r3.getDepartureTime()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.setText(r3)
            android.widget.TextView r2 = r14.netAmount
            android.content.res.Resources r3 = r14.getResources()
            r4 = 2131952833(0x7f1304c1, float:1.954212E38)
            java.lang.String r3 = r3.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r11]
            f2 r7 = r14.f5083a
            java.lang.Double r7 = r7.getTotalCollectibleAmount()
            r5[r6] = r7
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r2.setText(r3)
            android.widget.TextView r2 = r14.fastestcharge
            android.content.res.Resources r3 = r14.getResources()
            java.lang.String r3 = r3.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r11]
            cris.prs.webservices.dto.AvlFareResponseDTO r7 = r14.f5081a
            java.lang.Integer r7 = r7.getTotalFare()
            int r7 = r7.intValue()
            double r7 = (double) r7
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r5[r6] = r7
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r2.setText(r3)
            cris.prs.webservices.dto.AvlFareResponseDTO r2 = r14.f5081a
            java.lang.Double r2 = r2.getWpServiceCharge()
            double r2 = r2.doubleValue()
            cris.prs.webservices.dto.AvlFareResponseDTO r5 = r14.f5081a
            java.lang.Double r5 = r5.getWpServiceTax()
            double r7 = r5.doubleValue()
            double r7 = r7 + r2
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
            r14.f5084a = r2
            android.widget.TextView r2 = r14.ConvenienceFee
            android.content.res.Resources r3 = r14.getResources()
            java.lang.String r3 = r3.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r11]
            java.lang.Double r7 = r14.f5084a
            r5[r6] = r7
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r2.setText(r3)
            android.widget.TextView r2 = r14.totalamount
            android.content.res.Resources r3 = r14.getResources()
            java.lang.String r3 = r3.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r11]
            f2 r7 = r14.f5083a
            java.lang.Double r7 = r7.getTotalCollectibleAmount()
            r5[r6] = r7
            java.lang.String r3 = java.lang.String.format(r3, r5)
            r2.setText(r3)
            cris.prs.webservices.dto.AvlFareResponseDTO r2 = r14.f5081a
            java.lang.Double r2 = r2.getTravelInsuranceCharge()
            double r2 = r2.doubleValue()
            cris.prs.webservices.dto.AvlFareResponseDTO r5 = r14.f5081a
            java.lang.Double r5 = r5.getTravelInsuranceServiceTax()
            double r7 = r5.doubleValue()
            double r7 = r7 + r2
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
            r14.f5090b = r2
            android.widget.TextView r2 = r14.insurancecharge
            android.content.res.Resources r3 = r14.getResources()
            java.lang.String r3 = r3.getString(r4)
            java.lang.Object[] r4 = new java.lang.Object[r11]
            java.lang.Double r5 = r14.f5090b
            r4[r6] = r5
            java.lang.String r3 = java.lang.String.format(r3, r4)
            r2.setText(r3)
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan
            android.content.Context r3 = r14.getContext()
            java.lang.Object r4 = defpackage.d7.a
            r4 = 2131099739(0x7f06005b, float:1.781184E38)
            int r3 = defpackage.d7.b.a(r3, r4)
            r2.<init>(r3)
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            android.content.Context r5 = r14.getContext()
            int r5 = defpackage.d7.b.a(r5, r4)
            r3.<init>(r5)
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            android.content.Context r7 = r14.getContext()
            int r4 = defpackage.d7.b.a(r7, r4)
            r5.<init>(r4)
            android.text.SpannableStringBuilder r4 = new android.text.SpannableStringBuilder
            r4.<init>()
            r7 = 2131954017(0x7f130961, float:1.9544521E38)
            java.lang.String r7 = r14.getString(r7)
            android.text.SpannableString r8 = new android.text.SpannableString
            r8.<init>(r7)
            r4.append(r8)
            android.content.Context r7 = r14.getContext()
            Bw r7 = defpackage.Bw.e(r7)
            java.lang.String r7 = r7.j()
            java.lang.String r7 = defpackage.C0535I5.d0(r7)
            android.text.SpannableString r8 = new android.text.SpannableString
            r8.<init>(r7)
            int r7 = r8.length()
            r8.setSpan(r2, r6, r7, r6)
            r4.append(r8)
            android.text.SpannableString r2 = new android.text.SpannableString
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            r8 = 2131952285(0x7f13029d, float:1.9541008E38)
            java.lang.String r8 = r14.getString(r8)
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r2.<init>(r7)
            r4.append(r2)
            int r2 = defpackage.C0535I5.d
            if (r2 == 0) goto L_0x04b0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "+"
            r1.<init>(r2)
            int r2 = defpackage.C0535I5.d
            java.lang.String r7 = "-"
            java.lang.String r1 = defpackage.lf.k(r1, r2, r7)
        L_0x04b0:
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r1)
            int r1 = r2.length()
            r2.setSpan(r3, r6, r1, r6)
            r4.append(r2)
            java.lang.String r1 = r14.p
            java.lang.String r1 = defpackage.C0535I5.e0(r1)
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r1)
            int r1 = r2.length()
            r2.setSpan(r5, r6, r1, r6)
            r4.append(r2)
            java.lang.String r1 = cris.org.in.ima.IrctcImaApplication.e
            java.lang.String r2 = "hi"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x04f9
            android.text.SpannableString r1 = new android.text.SpannableString
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            r0 = 2131953717(0x7f130835, float:1.9543913E38)
            java.lang.String r0 = r14.getString(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r4.append(r1)
        L_0x04f9:
            android.widget.TextView r0 = r14.ticketSentLevelView
            android.widget.TextView$BufferType r1 = android.widget.TextView.BufferType.SPANNABLE
            r0.setText(r4, r1)
            java.lang.String r0 = r14.p
            defpackage.C0535I5.f3639e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ReviewAndPayFragment.t():void");
    }

    public class a extends ClickableSpan {
        public a() {
        }

        public final void onClick(View view) {
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            if (!C0535I5.O((ConnectivityManager) reviewAndPayFragment.getActivity().getSystemService("connectivity"), reviewAndPayFragment.f5074a)) {
                new Handler().postDelayed(new C0069a(), 5000);
            } else {
                reviewAndPayFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(reviewAndPayFragment.getString(R.string.tnc_general))));
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }

        /* renamed from: cris.org.in.ima.fragment.ReviewAndPayFragment$a$a  reason: collision with other inner class name */
        public class C0069a implements Runnable {
            public final void run() {
            }
        }
    }

    public class b implements Runnable {
        public final void run() {
        }
    }

    public class j implements Runnable {
        public final void run() {
        }
    }

    public class l implements Runnable {
        public final void run() {
        }
    }

    public class n implements Runnable {
        public final void run() {
        }
    }

    public class x implements Runnable {
        public final void run() {
        }
    }

    public class t implements TextWatcher {
        public t() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            charSequence.length();
            String str = ReviewAndPayFragment.x;
            ReviewAndPayFragment.this.getClass();
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ReviewAndPayFragment.this.d++;
        }

        public final void afterTextChanged(Editable editable) {
        }
    }
}
