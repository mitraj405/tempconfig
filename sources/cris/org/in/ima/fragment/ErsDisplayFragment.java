package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.StrictMode;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.BoardingStationChangeAdapter;
import cris.org.in.ima.adaptors.DmrcQRPagerAdapter;
import cris.org.in.ima.adaptors.MealDetaillViewHolder;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.WrapperBoardingStationModel;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.ErsPassengerViewHolder;
import cris.org.in.ima.view_holder.ErsTrainDeatilLapwiseViewHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.MealItemDetails;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import cris.prs.webservices.dto.StatusDTO;
import defpackage.Up;
import defpackage.Z2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import rx.Subscriber;

public class ErsDisplayFragment extends Fragment {
    public static final SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd");
    public static boolean e = false;
    @BindView(2131364781)
    TextView UgstAmt;
    @BindView(2131364784)
    TextView UgstRate;
    public C0707Ue a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4568a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4569a;

    /* renamed from: a  reason: collision with other field name */
    public BoardingStationChangeAdapter f4570a;

    /* renamed from: a  reason: collision with other field name */
    public StationDb f4571a = null;

    /* renamed from: a  reason: collision with other field name */
    public final k f4572a = new k();

    /* renamed from: a  reason: collision with other field name */
    public final p f4573a = new p();

    /* renamed from: a  reason: collision with other field name */
    public final q f4574a = new q();

    /* renamed from: a  reason: collision with other field name */
    public WrapperBoardingStationModel f4575a;

    /* renamed from: a  reason: collision with other field name */
    public ErsTrainDeatilLapwiseViewHolder f4576a;

    /* renamed from: a  reason: collision with other field name */
    public BookingResponseDTO f4577a;

    /* renamed from: a  reason: collision with other field name */
    public PassengerDetailDTO f4578a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f4579a = Boolean.FALSE;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f4580a = new SimpleDateFormat("EEE, dd MMM");

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4581a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public Date f4582a = null;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, String> f4583a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public List<C1283nl> f4584a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f4585a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4586a = false;
    @BindView(2131361895)
    TextView active_date;
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
    public BookingResponseDTO b;

    /* renamed from: b  reason: collision with other field name */
    public Boolean f4587b;

    /* renamed from: b  reason: collision with other field name */
    public final SimpleDateFormat f4588b = new SimpleDateFormat("HH:mm");

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Z2.a> f4589b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f4590b = false;
    @BindView(2131362020)
    TextView bankname;
    @BindView(2131362024)
    TextView basefare;
    @BindView(2131362048)
    RecyclerView boardingStnView;
    @BindView(2131362055)
    TextView bookedfrom;
    public BookingResponseDTO c = new BookingResponseDTO();

    /* renamed from: c  reason: collision with other field name */
    public String f4591c;

    /* renamed from: c  reason: collision with other field name */
    public final SimpleDateFormat f4592c = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f4593c = null;

    /* renamed from: c  reason: collision with other field name */
    public boolean f4594c = true;
    @BindView(2131362160)
    TextView cgstAmt;
    @BindView(2131362162)
    RelativeLayout cgstLayout;
    @BindView(2131362163)
    TextView cgstRate;
    @BindView(2131362182)
    RelativeLayout changeBoardingLl;
    @BindView(2131364337)
    TextView chartStatus;
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
    @BindView(2131362333)
    LinearLayout currentStatusLl;

    /* renamed from: d  reason: collision with other field name */
    public String f4595d;

    /* renamed from: d  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f4596d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f4597d = false;
    @BindView(2131362395)
    TextView deptDate;
    @BindView(2131362396)
    TextView deptTime;
    @BindView(2131362427)
    RecyclerView dmrcQrCodeViewPager;
    @BindView(2131362447)
    ImageView downloadpdf;

    /* renamed from: e  reason: collision with other field name */
    public String f4598e;

    /* renamed from: e  reason: collision with other field name */
    public ArrayList<C1188j3> f4599e;
    @BindView(2131362506)
    LinearLayout ersDisplayFragment;
    @BindView(2131364395)
    TextView ersMsgs;
    @BindView(2131362507)
    LinearLayout ersmsg_ll;
    public String f = null;

    /* renamed from: f  reason: collision with other field name */
    public final ArrayList<WrapperBoardingStationModel> f4600f = new ArrayList<>();
    @BindView(2131362643)
    LinearLayout feedback_ll;
    @BindView(2131364409)
    TextView fillNomineeDetails;
    @BindView(2131362712)
    TextView fromStation;
    @BindView(2131362713)
    TextView from_stn;
    @BindView(2131362720)
    LinearLayout funda_duty_detail_ll;
    @BindView(2131362722)
    RelativeLayout funda_duty_ll;
    @BindView(2131362723)
    TextView funda_duty_msg;
    public final ArrayList<MealItemDetails> g = new ArrayList<>();
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
    @BindView(2131362758)
    LinearLayout header;
    @BindView(2131362817)
    TextView igstAmt;
    @BindView(2131362819)
    RelativeLayout igstLayout;
    @BindView(2131362820)
    TextView igstRate;
    @BindView(2131362839)
    TextView indian_railway_qrtxt;
    @BindView(2131362843)
    LinearLayout informationLayout;
    @BindView(2131362844)
    LinearLayout informationLayout_lap2;
    @BindView(2131362845)
    TextView informationMsg;
    @BindView(2131362846)
    TextView informationMsg_lap2;
    @BindView(2131362920)
    TextView journey_date;
    @BindView(2131362934)
    TextView lap1;
    @BindView(2131362937)
    TextView lap2;
    @BindView(2131362942)
    TextView lapType;
    @BindView(2131362976)
    ImageView left_arrow;
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
    @BindView(2131363283)
    AdManagerAdView myBookingDetailCenter;
    @BindView(2131363296)
    TextView name;
    @BindView(2131363386)
    TextView orderfood_Pantry_Car;
    @BindView(2131364523)
    TextView passengerName;
    @BindView(2131363474)
    RelativeLayout payment_from;
    @BindView(2131363475)
    TextView paymentmode;
    @BindView(2131362750)
    TextView pincode;
    @BindView(2131363518)
    TextView pnrNo;
    @BindView(2131363520)
    TextView policyopt;
    @BindView(2131363527)
    TextView pre;
    @BindView(2131363549)
    RecyclerView psgnList;
    @BindView(2131363550)
    RecyclerView psgnList_lap2;
    @BindView(2131363573)
    TextView qrCancelMsg;
    @BindView(2131363567)
    LinearLayout qrImagelayout;
    @BindView(2131363568)
    ImageView qrImg;
    @BindView(2131363569)
    ImageView qrImgCross;
    @BindView(2131363576)
    LinearLayout qrTicketDetails_ll;
    @BindView(2131363574)
    ImageView qr_code;
    @BindView(2131363575)
    TextView qr_no;
    @BindView(2131363577)
    View qr_view;
    @BindView(2131363598)
    View recipient_view;
    @BindView(2131363675)
    TextView replan;
    @BindView(2131363691)
    RelativeLayout returnjourney_rl;
    @BindView(2131363692)
    View returnjourney_view;
    @BindView(2131363699)
    ImageView right_arrow;
    @BindView(2131363710)
    LinearLayout rl_bank_name;
    @BindView(2131363715)
    RelativeLayout rl_booked_from;
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
    @BindView(2131363953)
    ImageView shareButton;
    @BindView(2131362753)
    TextView state;
    @BindView(2131364062)
    LinearLayout tain_detail_ll;
    @BindView(2131364136)
    TextView ticketcharge;
    @BindView(2131364160)
    TextView tktSentMsg;
    @BindView(2131364167)
    TextView toStation;
    @BindView(2131364164)
    TextView toStn;
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
    @BindView(2131364698)
    TextView travelInsuranceName;
    @BindView(2131364237)
    LinearLayout travelInsurancelayout;
    @BindView(2131364247)
    TextView travelTime;
    @BindView(2131364238)
    LinearLayout travel_insurance_ll;
    @BindView(2131364244)
    RecyclerView travel_insurance_rv;
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
    @BindView(2131364726)
    TextView vikalpOpt;

    public class c implements View.OnClickListener {
        public c() {
        }

        public final void onClick(View view) {
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            int findFirstVisibleItemPosition = ((LinearLayoutManager) ersDisplayFragment.dmrcQrCodeViewPager.getLayoutManager()).findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < ersDisplayFragment.a.getBookingResponseList().get(0).getMetroServiceDetail().getNumberOfPassengerOpted().shortValue()) {
                ersDisplayFragment.dmrcQrCodeViewPager.smoothScrollToPosition(findFirstVisibleItemPosition);
            }
        }
    }

    public class d extends Subscriber<StatusDTO> {
        public final void onCompleted() {
            SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        }

        public final void onError(Throwable th) {
            SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
            xx.S(th, true, th);
        }

        public final /* bridge */ /* synthetic */ void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
        }
    }

    public class e extends ClickableSpan {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ BookingResponseDTO f4601a;

        public e(BookingResponseDTO bookingResponseDTO) {
            this.f4601a = bookingResponseDTO;
        }

        public final void onClick(View view) {
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f4601a.getInsuranceCompanyUrl()));
                ersDisplayFragment.getContext().startActivity(intent);
            } catch (Exception e) {
                SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                e.getMessage();
                C0535I5.t0(ersDisplayFragment.getContext(), ersDisplayFragment.getString(R.string.Unable_open_link));
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    public class f extends ClickableSpan {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ BookingResponseDTO f4602a;

        public f(BookingResponseDTO bookingResponseDTO) {
            this.f4602a = bookingResponseDTO;
        }

        public final void onClick(View view) {
            C0486Dp dp = new C0486Dp();
            SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
            BookingResponseDTO bookingResponseDTO = this.f4602a;
            bookingResponseDTO.toString();
            dp.setLocation("ERS_LINK");
            dp.setPnr(bookingResponseDTO.getPnrNumber());
            dp.setReservationId(Long.valueOf(Long.parseLong(bookingResponseDTO.getReservationId())));
            dp.setPsgnCount(Integer.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdChild()) + Integer.parseInt(bookingResponseDTO.getNoOfBkdPsgn())));
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            ersDisplayFragment.r(dp);
            ersDisplayFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(C1450w1.f7018b.get("pledgeUrl"))));
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    public class h extends Subscriber<PnrEnquiryResponseDTO> {
        public final /* synthetic */ ProgressDialog a;
        public final /* synthetic */ String c;

        public h(ProgressDialog progressDialog, String str) {
            this.a = progressDialog;
            this.c = str;
        }

        public final void onCompleted() {
            SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            String str;
            PnrEnquiryResponseDTO pnrEnquiryResponseDTO = (PnrEnquiryResponseDTO) obj;
            if (pnrEnquiryResponseDTO != null) {
                try {
                    C0657Qt.h().writeValueAsString(pnrEnquiryResponseDTO);
                    SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                    String errorMessage = pnrEnquiryResponseDTO.getErrorMessage();
                    int i = 0;
                    ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
                    if (errorMessage == null) {
                        String[] informationMessage = pnrEnquiryResponseDTO.getInformationMessage();
                        if (informationMessage != null) {
                            int length = informationMessage.length;
                            str = "";
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                String str2 = informationMessage[i];
                                if (str2 == null) {
                                    break;
                                } else if (str2.trim().equals("")) {
                                    break;
                                } else {
                                    str = str + str2 + "\n";
                                    i++;
                                }
                            }
                        } else {
                            str = "";
                        }
                        if (pnrEnquiryResponseDTO.getTrainCancelStatus() != null && !pnrEnquiryResponseDTO.getTrainCancelStatus().equals("")) {
                            if (pnrEnquiryResponseDTO.getTrainCancelStatus().contains(":")) {
                                str = str + pnrEnquiryResponseDTO.getTrainCancelStatus().split(":")[1];
                            } else {
                                str = str + pnrEnquiryResponseDTO.getTrainCancelStatus();
                            }
                        }
                        String str3 = str;
                        boolean equals = str3.trim().equals("");
                        String str4 = this.c;
                        if (!equals && str4 != "M") {
                            C0535I5.p(ersDisplayFragment.getActivity(), false, str3, ersDisplayFragment.getString(R.string.confirmation), ersDisplayFragment.getString(R.string.yes), new K(this), ersDisplayFragment.getString(R.string.no), new L()).show();
                        } else if (str4 == "M") {
                            ErsDisplayFragment.g(ersDisplayFragment, pnrEnquiryResponseDTO);
                        } else {
                            ErsDisplayFragment.f(ersDisplayFragment, ersDisplayFragment.f4577a);
                        }
                        SimpleDateFormat simpleDateFormat2 = ErsDisplayFragment.d;
                        return;
                    }
                    C0535I5.m(ersDisplayFragment.getActivity(), true, pnrEnquiryResponseDTO.getErrorMessage().split("-")[0], ersDisplayFragment.getString(R.string.Info), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    SimpleDateFormat simpleDateFormat3 = ErsDisplayFragment.d;
                    e.getMessage();
                }
            }
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public final void onClick(View view) {
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            int findFirstVisibleItemPosition = ((LinearLayoutManager) ersDisplayFragment.dmrcQrCodeViewPager.getLayoutManager()).findFirstVisibleItemPosition() - 1;
            if (findFirstVisibleItemPosition >= 0) {
                ersDisplayFragment.dmrcQrCodeViewPager.smoothScrollToPosition(findFirstVisibleItemPosition);
            }
        }
    }

    public class k implements BoardingStationChangeAdapter.StationListSelectListener {
        public k() {
        }

        public final void onStnClick(WrapperBoardingStationModel wrapperBoardingStationModel) {
            boolean z = wrapperBoardingStationModel.f5354a;
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            if (!z) {
                Iterator<WrapperBoardingStationModel> it = ersDisplayFragment.f4600f.iterator();
                while (it.hasNext()) {
                    it.next().f5354a = false;
                }
                wrapperBoardingStationModel.f5354a = true;
            }
            ersDisplayFragment.f4575a = wrapperBoardingStationModel;
            ersDisplayFragment.f4570a.notifyDataSetChanged();
            ersDisplayFragment.f4595d = wrapperBoardingStationModel.a.getStnNameCode();
            String str = ersDisplayFragment.f4595d;
            ersDisplayFragment.f4595d = str.substring(str.indexOf(45) + 2);
            String str2 = ersDisplayFragment.f4595d;
        }
    }

    public class l implements DialogInterface.OnClickListener {
        public l() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            if (!C0535I5.O((ConnectivityManager) ersDisplayFragment.getActivity().getSystemService("connectivity"), ersDisplayFragment.getContext())) {
                new Handler().postDelayed(new C0679Sa(), 5000);
                return;
            }
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                ProgressDialog progressDialog = new ProgressDialog(ersDisplayFragment.getActivity());
                progressDialog.requestWindowFeature(1);
                progressDialog.setMessage(ersDisplayFragment.getString(R.string.please_wait_text));
                progressDialog.show();
                String f = C0657Qt.f();
                String format = String.format("/%s/%s", new Object[]{ersDisplayFragment.f4577a.getPnrNumber(), ersDisplayFragment.f4595d});
                ((Om) C0657Qt.c(b1Var.f3912a)).G(f + "changeBDPoint" + format).c(C1181iv.a()).a(E0.a()).b(new C0705Ua(ersDisplayFragment, progressDialog));
                return;
            }
            C0535I5.m(ersDisplayFragment.getActivity(), false, ersDisplayFragment.getResources().getString(R.string.data_connection_error_message), ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        public final void onClick(View view) {
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            ersDisplayFragment.qrImagelayout.setVisibility(8);
            ersDisplayFragment.ersDisplayFragment.setVisibility(0);
        }
    }

    public class o implements View.OnClickListener {

        public class a implements Up.a {
            public a() {
            }
        }

        public o() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00ed A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ee  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r10) {
            /*
                r9 = this;
                cris.org.in.ima.fragment.ErsDisplayFragment r10 = cris.org.in.ima.fragment.ErsDisplayFragment.this
                java.lang.Boolean r0 = r10.f4587b
                boolean r0 = r0.booleanValue()
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x0040
                java.util.ArrayList<j3> r0 = r10.f4599e
                java.util.Iterator r0 = r0.iterator()
            L_0x0012:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0024
                java.lang.Object r3 = r0.next()
                j3 r3 = (defpackage.C1188j3) r3
                boolean r3 = r3.f5519a
                if (r3 == 0) goto L_0x0012
                r0 = r1
                goto L_0x0025
            L_0x0024:
                r0 = r2
            L_0x0025:
                if (r0 == 0) goto L_0x0040
                android.content.Context r0 = r10.f4569a
                r1 = 2131953689(0x7f130819, float:1.9543856E38)
                java.lang.String r1 = r10.getString(r1)
                r2 = 2131953334(0x7f1306b6, float:1.9543136E38)
                java.lang.String r10 = r10.getString(r2)
                r2 = 0
                android.app.AlertDialog r10 = defpackage.C0535I5.o(r0, r1, r10, r2)
                r10.show()
                return
            L_0x0040:
                Up r0 = new Up
                android.content.Context r3 = r10.f4569a
                android.widget.ImageView r4 = cris.org.in.ima.activities.HomeActivity.a
                r0.<init>(r3, r4)
                Iy r4 = new Iy
                r4.<init>(r3)
                androidx.appcompat.view.menu.MenuBuilder r3 = r0.f579a
                r5 = 2131689472(0x7f0f0000, float:1.900796E38)
                r4.inflate(r5, r3)
                java.lang.Boolean r4 = r10.f4587b
                boolean r4 = r4.booleanValue()
                r5 = 2131363596(0x7f0a070c, float:1.8347005E38)
                if (r4 == 0) goto L_0x0068
                android.view.MenuItem r4 = r3.findItem(r5)
                r4.setVisible(r1)
                goto L_0x006f
            L_0x0068:
                android.view.MenuItem r4 = r3.findItem(r5)
                r4.setVisible(r2)
            L_0x006f:
                boolean r4 = cris.org.in.ima.fragment.ErsDisplayFragment.e
                r5 = 2131363382(0x7f0a0636, float:1.8346571E38)
                r6 = 2131362181(0x7f0a0185, float:1.8344135E38)
                r7 = 2131363366(0x7f0a0626, float:1.8346539E38)
                r8 = 2131362110(0x7f0a013e, float:1.8343991E38)
                if (r4 == 0) goto L_0x009c
                android.view.MenuItem r4 = r3.findItem(r7)
                r4.setVisible(r1)
                android.view.MenuItem r4 = r3.findItem(r8)
                r4.setVisible(r1)
                android.view.MenuItem r4 = r3.findItem(r6)
                r4.setVisible(r1)
                android.view.MenuItem r4 = r3.findItem(r5)
                r4.setVisible(r1)
                goto L_0x00b8
            L_0x009c:
                android.view.MenuItem r4 = r3.findItem(r8)
                r4.setVisible(r2)
                android.view.MenuItem r4 = r3.findItem(r7)
                r4.setVisible(r2)
                android.view.MenuItem r4 = r3.findItem(r6)
                r4.setVisible(r2)
                android.view.MenuItem r4 = r3.findItem(r5)
                r4.setVisible(r2)
            L_0x00b8:
                java.lang.Boolean r10 = r10.f4579a
                boolean r10 = r10.booleanValue()
                r4 = 2131361900(0x7f0a006c, float:1.8343565E38)
                if (r10 == 0) goto L_0x00cb
                android.view.MenuItem r10 = r3.findItem(r4)
                r10.setVisible(r2)
                goto L_0x00d2
            L_0x00cb:
                android.view.MenuItem r10 = r3.findItem(r4)
                r10.setVisible(r1)
            L_0x00d2:
                cris.org.in.ima.fragment.ErsDisplayFragment$o$a r10 = new cris.org.in.ima.fragment.ErsDisplayFragment$o$a
                r10.<init>()
                r0.a = r10
                androidx.appcompat.view.menu.g r10 = r0.f580a
                boolean r0 = r10.b()
                if (r0 == 0) goto L_0x00e2
                goto L_0x00ea
            L_0x00e2:
                android.view.View r0 = r10.f1072a
                if (r0 != 0) goto L_0x00e7
                goto L_0x00eb
            L_0x00e7:
                r10.d(r1, r1, r1, r1)
            L_0x00ea:
                r1 = r2
            L_0x00eb:
                if (r1 == 0) goto L_0x00ee
                return
            L_0x00ee:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "MenuPopupHelper cannot be used without an anchor"
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ErsDisplayFragment.o.onClick(android.view.View):void");
        }
    }

    public class p implements DmrcQRPagerAdapter.QrClickListener {
        public p() {
        }

        public final void onQrClickListener(String str, int i) {
            String str2;
            int i2;
            HomeActivity.t();
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            ersDisplayFragment.qrImagelayout.setVisibility(0);
            ersDisplayFragment.qr_no.setText("QR No : " + ersDisplayFragment.f4584a.get(i).getMetroQrTicketNo());
            if (ersDisplayFragment.f4584a.get(i).getCancelStatus() == null || ersDisplayFragment.f4584a.get(i).getCancelStatus().intValue() <= 0) {
                ersDisplayFragment.qrCancelMsg.setVisibility(8);
            } else {
                ersDisplayFragment.qrCancelMsg.setVisibility(0);
                ersDisplayFragment.qrCancelMsg.setText(ersDisplayFragment.f4584a.get(i).getCancelStatusString());
            }
            String metroQrTicketBlock = ersDisplayFragment.f4584a.get(i).getMetroQrTicketBlock();
            ersDisplayFragment.getClass();
            try {
                str2 = new String(metroQrTicketBlock.getBytes("UTF-8"), Charset.forName("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.getMessage();
                str2 = "";
            }
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str2, BarcodeFormat.QR_CODE, 300, 300);
                int width = encode.getWidth();
                int height = encode.getHeight();
                int[] iArr = new int[(width * height)];
                for (int i3 = 0; i3 < height; i3++) {
                    int i4 = i3 * width;
                    for (int i5 = 0; i5 < width; i5++) {
                        int i6 = i4 + i5;
                        if (encode.get(i5, i3)) {
                            i2 = -16777216;
                        } else {
                            i2 = -1;
                        }
                        iArr[i6] = i2;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                ersDisplayFragment.qrImg.setImageBitmap(createBitmap);
                ersDisplayFragment.qrImg.setVisibility(0);
            } catch (WriterException e2) {
                e2.getMessage();
            }
        }
    }

    public class q implements ErsTrainDeatilLapwiseViewHolder.a {
        public q() {
        }
    }

    public class r implements Runnable {
        public final /* synthetic */ Toast a;

        public r(Toast toast) {
            this.a = toast;
        }

        public final void run() {
            Toast toast = this.a;
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            try {
                ErsDisplayFragment ersDisplayFragment2 = ErsDisplayFragment.this;
                ersDisplayFragment2.m("HB", ersDisplayFragment2.f4591c, ersDisplayFragment2.f4577a.getReservationId(), ersDisplayFragment.f4592c.format(ersDisplayFragment.f4577a.getDestArrvDate()), ersDisplayFragment.f4577a.getDestStn());
            } catch (Exception e) {
                if (ersDisplayFragment.f4597d) {
                    try {
                        Thread.sleep(100);
                        toast.show();
                        Thread.sleep(100);
                    } catch (Exception e2) {
                        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                        e2.getMessage();
                    }
                }
                SimpleDateFormat simpleDateFormat2 = ErsDisplayFragment.d;
                e.getMessage();
            }
            if (ersDisplayFragment.f4597d) {
                try {
                    Thread.sleep(100);
                    toast.show();
                    Thread.sleep(100);
                } catch (Exception e3) {
                    SimpleDateFormat simpleDateFormat3 = ErsDisplayFragment.d;
                    e3.getMessage();
                }
            }
        }
    }

    public class s implements Runnable {
        public s() {
        }

        public final void run() {
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            try {
                ErsDisplayFragment ersDisplayFragment2 = ErsDisplayFragment.this;
                ersDisplayFragment2.m("RR", ersDisplayFragment2.f4591c, ersDisplayFragment2.f4577a.getReservationId(), ersDisplayFragment.f4592c.format(ersDisplayFragment.f4577a.getDestArrvDate()), ersDisplayFragment.f4577a.getDestStn());
            } catch (Exception e) {
                SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                e.getMessage();
            }
        }
    }

    public class t implements Runnable {
        public t() {
        }

        public final void run() {
            ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
            try {
                ersDisplayFragment.i(ersDisplayFragment.f4591c, ersDisplayFragment.f4577a.getReservationId(), ersDisplayFragment.f4592c.format(ersDisplayFragment.f4577a.getDestArrvDate()), ersDisplayFragment.f4577a.getDestStn());
            } catch (Exception e) {
                SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                e.getMessage();
            }
        }
    }

    static {
        C1354qp.R(ErsDisplayFragment.class);
    }

    public ErsDisplayFragment() {
        new SimpleDateFormat("dd MMM yyyy HH:mm");
    }

    public static void f(ErsDisplayFragment ersDisplayFragment2, BookingResponseDTO bookingResponseDTO) {
        if (!C0535I5.O((ConnectivityManager) ersDisplayFragment2.getActivity().getSystemService("connectivity"), ersDisplayFragment2.f4569a)) {
            new Handler().postDelayed(new C0650Qa(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            ProgressDialog progressDialog = new ProgressDialog(ersDisplayFragment2.getActivity());
            progressDialog.requestWindowFeature(1);
            progressDialog.setMessage(ersDisplayFragment2.getString(R.string.please_wait_text));
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            String f2 = C0657Qt.f();
            String format = String.format("/%s/%s/%s/%s/%s", new Object[]{bookingResponseDTO.getTrainNumber(), d.format(bookingResponseDTO.getJourneyDate()), bookingResponseDTO.getBoardingStn(), bookingResponseDTO.getDestStn(), bookingResponseDTO.getJourneyClass()});
            ((Om) C0657Qt.c(b1Var.f3912a)).C0(f2 + "boardingstationenquiry" + format).c(C1181iv.a()).a(E0.a()).b(new M(ersDisplayFragment2, progressDialog));
            return;
        }
        C0535I5.m(ersDisplayFragment2.getActivity(), false, ersDisplayFragment2.getResources().getString(R.string.data_connection_error_message), ersDisplayFragment2.getString(R.string.error), ersDisplayFragment2.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public static void g(ErsDisplayFragment ersDisplayFragment2, PnrEnquiryResponseDTO pnrEnquiryResponseDTO) {
        if (!C0535I5.O((ConnectivityManager) ersDisplayFragment2.getActivity().getSystemService("connectivity"), ersDisplayFragment2.f4569a)) {
            new Handler().postDelayed(new C0634Pa(), 5000);
            return;
        }
        Bundle bundle = new Bundle();
        if (ersDisplayFragment2.f4577a.getTransactionId() != null) {
            bundle.putString("txnId", ersDisplayFragment2.f4577a.getTransactionId());
        } else {
            bundle.putString("txnId", ersDisplayFragment2.f4577a.getResvDetails().get(0).getReservationId());
        }
        bundle.putSerializable("tkt", pnrEnquiryResponseDTO);
        BookMealFragment bookMealFragment = new BookMealFragment();
        bookMealFragment.setArguments(bundle);
        HomeActivity.B(ersDisplayFragment2.f4569a);
        HomeActivity.n(ersDisplayFragment2.getActivity(), bookMealFragment, xx.d(3), Boolean.TRUE, Boolean.FALSE);
    }

    public static void h(ErsDisplayFragment ersDisplayFragment2, BookingResponseDTO bookingResponseDTO, BookingResponseDTO bookingResponseDTO2, Date date) {
        ersDisplayFragment2.getClass();
        bookingResponseDTO.setConnectingPnrNumber(bookingResponseDTO2.getConnectingPnrNumber());
        bookingResponseDTO.setJourneyLap(bookingResponseDTO2.getJourneyLap());
        bookingResponseDTO.setPnrLinkStatus(bookingResponseDTO2.getPnrLinkStatus());
        bookingResponseDTO.setVikalpDTO(bookingResponseDTO2.getVikalpDTO());
        bookingResponseDTO.setVikalpStatus(bookingResponseDTO2.getVikalpStatus());
        bookingResponseDTO.setTrainChartStatus(bookingResponseDTO2.getTrainChartStatus());
        bookingResponseDTO.setInsuranceOpted(bookingResponseDTO2.getInsuranceOpted());
        bookingResponseDTO.setInsuranceCompany(bookingResponseDTO2.getInsuranceCompany());
        bookingResponseDTO.setInsuranceOpted(bookingResponseDTO2.getInsuranceOpted());
        bookingResponseDTO.setInsuranceCharge(bookingResponseDTO2.getInsuranceCharge());
        bookingResponseDTO.setPolicyIssueDate(bookingResponseDTO2.getPolicyIssueDate());
        bookingResponseDTO.setInsuranceCompanyUrl(bookingResponseDTO2.getInsuranceCompanyUrl());
        bookingResponseDTO.setRequestedClientTransactionId(bookingResponseDTO2.getRequestedClientTransactionId());
        bookingResponseDTO.setNumberOfpassenger(bookingResponseDTO2.getNumberOfpassenger());
        bookingResponseDTO.setGstCharge(bookingResponseDTO2.getGstCharge());
        bookingResponseDTO.setGstDetailsDTO(bookingResponseDTO2.getGstDetailsDTO());
        bookingResponseDTO.setGstFlag(bookingResponseDTO2.getGstFlag());
        bookingResponseDTO.setBankName(bookingResponseDTO2.getBankName());
        bookingResponseDTO.setTimeTableFlag(bookingResponseDTO2.getTimeTableFlag());
        bookingResponseDTO.setPnrNumber(bookingResponseDTO2.getPnrNumber());
        bookingResponseDTO.setDepartureTime(bookingResponseDTO2.getDepartureTime());
        bookingResponseDTO.setArrivalTime(bookingResponseDTO2.getArrivalTime());
        bookingResponseDTO.setReasonType(bookingResponseDTO2.getReasonType());
        bookingResponseDTO.setReasonIndex(bookingResponseDTO2.getReasonIndex());
        bookingResponseDTO.setErrorMessage(bookingResponseDTO2.getErrorMessage());
        bookingResponseDTO.setInformationMessage(bookingResponseDTO2.getInformationMessage());
        bookingResponseDTO.setJourneyDate(bookingResponseDTO2.getJourneyDate());
        bookingResponseDTO.setBoardingDate(bookingResponseDTO2.getBoardingDate());
        bookingResponseDTO.setDestArrvDate(bookingResponseDTO2.getDestArrvDate());
        bookingResponseDTO.setBookingDate(bookingResponseDTO2.getBookingDate());
        bookingResponseDTO.setNumberOfChilds(bookingResponseDTO2.getNumberOfChilds());
        bookingResponseDTO.setNumberOfAdults(bookingResponseDTO2.getNumberOfAdults());
        bookingResponseDTO.setTrainNumber(bookingResponseDTO2.getTrainNumber());
        bookingResponseDTO.setFromStn(bookingResponseDTO2.getFromStn());
        bookingResponseDTO.setDestStn(bookingResponseDTO2.getDestStn());
        bookingResponseDTO.setBoardingStn(bookingResponseDTO2.getBoardingStn());
        bookingResponseDTO.setErsGovMsg(bookingResponseDTO2.getErsGovMsg());
        bookingResponseDTO.setResvnUptoStn(bookingResponseDTO2.getResvnUptoStn());
        bookingResponseDTO.setJourneyClass(bookingResponseDTO2.getJourneyClass());
        bookingResponseDTO.setJourneyQuota(bookingResponseDTO2.getJourneyQuota());
        bookingResponseDTO.setTotalCollectibleAmount(bookingResponseDTO2.getTotalCollectibleAmount());
        bookingResponseDTO.setTotalFare(bookingResponseDTO2.getTotalFare());
        bookingResponseDTO.setPsgnDtlList(bookingResponseDTO2.getPsgnDtlList());
        bookingResponseDTO.setRetryBooking(bookingResponseDTO2.getRetryBooking());
        bookingResponseDTO.setClientTransactionId(bookingResponseDTO2.getClientTransactionId());
        bookingResponseDTO.setBookingErrorMessage(bookingResponseDTO2.getBookingErrorMessage());
        bookingResponseDTO.setScheduleDepartureFlag(bookingResponseDTO2.getScheduleDepartureFlag());
        bookingResponseDTO.setScheduleArrivalFlag(bookingResponseDTO2.getScheduleArrivalFlag());
        bookingResponseDTO.setCancellationDetails(bookingResponseDTO2.getCancellationDetails());
        bookingResponseDTO.setResvDetails(bookingResponseDTO2.getResvDetails());
        bookingResponseDTO.setInfantDetails(bookingResponseDTO2.getInfantDetails());
        bookingResponseDTO.setNoOfCanPsgn(bookingResponseDTO2.getNoOfCanPsgn());
        bookingResponseDTO.setNoOfCanChild(bookingResponseDTO2.getNoOfCanChild());
        bookingResponseDTO.setTransactionStatusEtTkt(bookingResponseDTO2.getTransactionStatusEtTkt());
        bookingResponseDTO.setTrainChartStatus(bookingResponseDTO2.getTrainChartStatus());
        bookingResponseDTO.setCurrentPrsAmt(bookingResponseDTO2.getCurrentPrsAmt());
        bookingResponseDTO.setTaServiceCharge(bookingResponseDTO2.getTaServiceCharge());
        bookingResponseDTO.setServiceChargeTotal(bookingResponseDTO2.getServiceChargeTotal());
        bookingResponseDTO.setServiceTax(bookingResponseDTO2.getServiceTax());
        bookingResponseDTO.setPrsBookingResponse(bookingResponseDTO2.getPrsBookingResponse());
        bookingResponseDTO.setTrainStartDate(bookingResponseDTO2.getTrainStartDate());
        bookingResponseDTO.setTktLegendMessage(bookingResponseDTO2.getTktLegendMessage());
        bookingResponseDTO.setBookingTatkalCharge(bookingResponseDTO2.getBookingTatkalCharge());
        bookingResponseDTO.setBookingResvCharge(bookingResponseDTO2.getBookingResvCharge());
        bookingResponseDTO.setBookingFuelCharge(bookingResponseDTO2.getBookingFuelCharge());
        bookingResponseDTO.setBookingSuperFastCharge(bookingResponseDTO2.getBookingSuperFastCharge());
        bookingResponseDTO.setCurTatkalCharge(bookingResponseDTO2.getCurTatkalCharge());
        bookingResponseDTO.setCurResvCharge(bookingResponseDTO2.getCurResvCharge());
        bookingResponseDTO.setCurFuelCharge(bookingResponseDTO2.getCurFuelCharge());
        bookingResponseDTO.setCurSuperFastCharge(bookingResponseDTO2.getCurSuperFastCharge());
        bookingResponseDTO.setRefundStatusEtTkt(bookingResponseDTO2.getRefundStatusEtTkt());
        bookingResponseDTO.setTicketType(bookingResponseDTO2.getTicketType());
        bookingResponseDTO.setRetryWithoutChoice(bookingResponseDTO2.getRetryWithoutChoice());
        bookingResponseDTO.setTimeTableFlag(bookingResponseDTO2.getTimeTableFlag());
        bookingResponseDTO.setFailureReason(bookingResponseDTO2.getFailureReason());
        bookingResponseDTO.setPaymentStatus(bookingResponseDTO2.getPaymentStatus());
        bookingResponseDTO.setTransactionAmt(bookingResponseDTO2.getTransactionAmt());
        bookingResponseDTO.setTransactionDate(bookingResponseDTO2.getTransactionDate());
        bookingResponseDTO.setCancellationId(bookingResponseDTO2.getCancellationId());
        bookingResponseDTO.setTicketAmount(bookingResponseDTO2.getTicketAmount());
        bookingResponseDTO.setRefundAmount(bookingResponseDTO2.getRefundAmount());
        bookingResponseDTO.setCancellationStatus(bookingResponseDTO2.getCancellationStatus());
        bookingResponseDTO.setCancellationDate(bookingResponseDTO2.getCancellationDate());
        bookingResponseDTO.setTdrFilingDate(bookingResponseDTO2.getTdrFilingDate());
        bookingResponseDTO.setLapNumberEtTkt(bookingResponseDTO2.getLapNumberEtTkt());
        bookingResponseDTO.setPrefCoachId(bookingResponseDTO2.getPrefCoachId());
        bookingResponseDTO.setIgnoreChoiceIf(bookingResponseDTO2.getIgnoreChoiceIf());
        bookingResponseDTO.setAutoUpgradeChoice(bookingResponseDTO2.getAutoUpgradeChoice());
        bookingResponseDTO.setGnToCkOpt(bookingResponseDTO2.getGnToCkOpt());
        bookingResponseDTO.setTicketChoiceBerth(bookingResponseDTO2.getTicketChoiceBerth());
        bookingResponseDTO.setTicketChoiceCoach(bookingResponseDTO2.getTicketChoiceCoach());
        bookingResponseDTO.setDispatchDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS").format(date));
        bookingResponseDTO.setBookedQuota(bookingResponseDTO2.getBookedQuota());
        bookingResponseDTO.setReservationUpTo(bookingResponseDTO2.getReservationUpTo());
        bookingResponseDTO.setNoOfBkdChild(bookingResponseDTO2.getNoOfBkdChild());
        bookingResponseDTO.setNoOfBkdPsgn(bookingResponseDTO2.getNoOfBkdPsgn());
        bookingResponseDTO.setScheduleArrivalFlag(bookingResponseDTO2.getScheduleArrivalFlag());
        bookingResponseDTO.setScheduleDepartureFlag(bookingResponseDTO2.getScheduleDepartureFlag());
        bookingResponseDTO.setAvlForVikalp(bookingResponseDTO2.getAvlForVikalp());
        bookingResponseDTO.setVikalpStatus(bookingResponseDTO2.getVikalpStatus());
        bookingResponseDTO.setErsDisplayMessage(bookingResponseDTO2.getErsDisplayMessage());
        bookingResponseDTO.setDutiesMessage(bookingResponseDTO2.getDutiesMessage());
        bookingResponseDTO.setQrCodeText(bookingResponseDTO2.getQrCodeText());
        bookingResponseDTO.setMealTransaction(bookingResponseDTO2.getMealTransaction());
        bookingResponseDTO.setMealChoiceEnable(bookingResponseDTO2.isMealChoiceEnable());
        bookingResponseDTO.setRrHbFlag(bookingResponseDTO2.getRrHbFlag());
        bookingResponseDTO.setTrainName(bookingResponseDTO2.getTrainName());
    }

    @OnClick({2131362182})
    public void changeBoadingClick() {
        this.changeBoardingLl.setVisibility(8);
    }

    public final void i(String str, String str2, String str3, String str4) {
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
                C0535I5.t0(this.f4569a, getResources().getString(R.string.unble_toconnect_server));
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
            this.f4597d = true;
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    public final void j() {
        ProgressDialog progressDialog = this.f4568a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4568a.dismiss();
        }
    }

    public final void k(String str, String str2) {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new g(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text));
        String f2 = C0657Qt.f();
        String format = String.format("/%s", new Object[]{str});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).W(f2 + "pnrenq" + format, str2).c(C1181iv.a()).a(E0.a()).b(new h(show, str2));
    }

    public final String l(String str, C0707Ue ue) {
        String str2 = "";
        if (!(ue.getBookingResponseList() == null || str == null || str.isEmpty())) {
            Iterator<BookingResponseDTO> it = ue.getBookingResponseList().iterator();
            while (it.hasNext()) {
                BookingResponseDTO next = it.next();
                if (str.equalsIgnoreCase(next.getPnrNumber())) {
                    str2 = next.getReservationId();
                }
            }
        }
        return str2;
    }

    public final void m(String str, String str2, String str3, String str4, String str5) {
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
                C0535I5.t0(this.f4569a, getResources().getString(R.string.unble_toconnect_server));
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
            this.f4597d = true;
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ WriterException -> 0x008e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r10 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = ""
            java.lang.Boolean r2 = r10.f4587b
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0013
            Ue r2 = r10.a
            java.lang.String r2 = r2.getQrCodeTextMultiLap()
            goto L_0x0019
        L_0x0013:
            cris.prs.webservices.dto.BookingResponseDTO r2 = r10.f4577a
            java.lang.String r2 = r2.getQrCodeText()
        L_0x0019:
            byte[] r2 = r2.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0032 }
            java.lang.String r3 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0032 }
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch:{ UnsupportedEncodingException -> 0x0032 }
            r3.<init>(r2, r0)     // Catch:{ UnsupportedEncodingException -> 0x0032 }
            java.lang.String r0 = "₹"
            java.lang.String r1 = "Rs."
            java.lang.String r0 = r3.replaceAll(r0, r1)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            goto L_0x0037
        L_0x002f:
            r0 = move-exception
            r1 = r3
            goto L_0x0033
        L_0x0032:
            r0 = move-exception
        L_0x0033:
            r0.getMessage()
            r0 = r1
        L_0x0037:
            java.lang.StringBuilder r0 = defpackage.xx.J(r0)
            com.google.zxing.MultiFormatWriter r1 = new com.google.zxing.MultiFormatWriter
            r1.<init>()
            java.lang.String r0 = r0.toString()     // Catch:{ WriterException -> 0x008e }
            com.google.zxing.BarcodeFormat r2 = com.google.zxing.BarcodeFormat.QR_CODE     // Catch:{ WriterException -> 0x008e }
            r3 = 300(0x12c, float:4.2E-43)
            com.google.zxing.common.BitMatrix r0 = r1.encode(r0, r2, r3, r3)     // Catch:{ WriterException -> 0x008e }
            int r7 = r0.getWidth()     // Catch:{ WriterException -> 0x008e }
            int r8 = r0.getHeight()     // Catch:{ WriterException -> 0x008e }
            int r1 = r7 * r8
            int[] r2 = new int[r1]     // Catch:{ WriterException -> 0x008e }
            r9 = 0
            r1 = r9
        L_0x005a:
            if (r1 >= r8) goto L_0x0075
            int r3 = r1 * r7
            r4 = r9
        L_0x005f:
            if (r4 >= r7) goto L_0x0072
            int r5 = r3 + r4
            boolean r6 = r0.get(r4, r1)     // Catch:{ WriterException -> 0x008e }
            if (r6 == 0) goto L_0x006c
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x006d
        L_0x006c:
            r6 = -1
        L_0x006d:
            r2[r5] = r6     // Catch:{ WriterException -> 0x008e }
            int r4 = r4 + 1
            goto L_0x005f
        L_0x0072:
            int r1 = r1 + 1
            goto L_0x005a
        L_0x0075:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ WriterException -> 0x008e }
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r7, r8, r0)     // Catch:{ WriterException -> 0x008e }
            r3 = 0
            r5 = 0
            r6 = 0
            r1 = r0
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ WriterException -> 0x008e }
            android.widget.ImageView r1 = r10.qr_code     // Catch:{ WriterException -> 0x008e }
            r1.setImageBitmap(r0)     // Catch:{ WriterException -> 0x008e }
            android.widget.ImageView r0 = r10.qr_code     // Catch:{ WriterException -> 0x008e }
            r0.setVisibility(r9)     // Catch:{ WriterException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r0 = move-exception
            r0.getMessage()
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ErsDisplayFragment.n():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x04a1  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x050a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x053d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0550  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0571  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0689  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x06b2  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x06bf  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x06fd  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0727  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x073f A[LOOP:5: B:186:0x0739->B:188:0x073f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x077e  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x07a4  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0872  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x08cc  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x042f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(cris.prs.webservices.dto.BookingResponseDTO r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r22.toString()
            boolean r0 = defpackage.C1450w1.f7024c
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = defpackage.C1450w1.f7029e
            if (r0 == 0) goto L_0x0032
            android.widget.LinearLayout r0 = r1.mpImageLayout
            r0.setVisibility(r4)
            java.lang.String r0 = defpackage.C1450w1.f7029e
            java.lang.String r5 = ","
            java.lang.String[] r0 = r0.split(r5)
            r0 = r0[r3]
            byte[] r0 = r0.getBytes()
            byte[] r0 = android.util.Base64.decode(r0, r4)
            android.widget.ImageView r5 = r1.mpImage
            int r6 = r0.length
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r4, r6)
            r5.setImageBitmap(r0)
        L_0x0032:
            android.widget.TextView r0 = r1.replan
            r5 = 8
            r0.setVisibility(r5)
            Ue r0 = r1.a
            java.util.ArrayList r0 = r0.getBookingResponseList()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0097
            Ue r0 = r1.a
            java.util.ArrayList r0 = r0.getBookingResponseList()
            java.lang.Object r0 = r0.get(r4)
            cris.prs.webservices.dto.BookingResponseDTO r0 = (cris.prs.webservices.dto.BookingResponseDTO) r0
            java.util.ArrayList r0 = r0.getButtons()
            if (r0 == 0) goto L_0x0097
            Ue r0 = r1.a
            java.util.ArrayList r0 = r0.getBookingResponseList()
            java.lang.Object r0 = r0.get(r4)
            cris.prs.webservices.dto.BookingResponseDTO r0 = (cris.prs.webservices.dto.BookingResponseDTO) r0
            java.util.ArrayList r0 = r0.getButtons()
            int r0 = r0.size()
            r6 = 10
            if (r0 <= r6) goto L_0x0097
            Ue r0 = r1.a
            java.util.ArrayList r0 = r0.getBookingResponseList()
            java.lang.Object r0 = r0.get(r4)
            cris.prs.webservices.dto.BookingResponseDTO r0 = (cris.prs.webservices.dto.BookingResponseDTO) r0
            java.util.ArrayList r0 = r0.getButtons()
            java.lang.Object r0 = r0.get(r6)
            java.lang.Short r0 = (java.lang.Short) r0
            short r0 = r0.shortValue()
            if (r0 != r3) goto L_0x0097
            boolean r0 = r22.isMetroServiceOpted()
            if (r0 != 0) goto L_0x0097
            android.widget.TextView r0 = r1.tv_tab_delhi_metro
            r0.setVisibility(r4)
            goto L_0x009c
        L_0x0097:
            android.widget.TextView r0 = r1.tv_tab_delhi_metro
            r0.setVisibility(r5)
        L_0x009c:
            android.widget.TextView r0 = r1.tv_cancellation_policy
            r0.setVisibility(r4)
            android.view.View r0 = r1.returnjourney_view
            r0.setVisibility(r5)
            b1 r0 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r6 = r0.f3911a
            android.widget.TextView r0 = r1.trainName
            java.lang.String r7 = r22.getTrainName()
            r0.setText(r7)
            android.widget.TextView r0 = r1.trainNo
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "("
            r7.<init>(r8)
            java.lang.String r8 = r22.getTrainNumber()
            r7.append(r8)
            java.lang.String r8 = ")"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r0.setText(r7)
            android.widget.TextView r0 = r1.pnrNo
            java.lang.String r7 = r22.getPnrNumber()
            r0.setText(r7)
            android.widget.TextView r0 = r1.fromStation
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r22.getBoardingStn()
            java.lang.String r9 = r6.m(r9)
            java.lang.String r9 = defpackage.C0535I5.s0(r9)
            r7.append(r9)
            java.lang.String r9 = " ("
            r7.append(r9)
            java.lang.String r10 = r22.getBoardingStn()
            r7.append(r10)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r0.setText(r7)
            android.widget.TextView r0 = r1.toStation
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = r22.getDestStn()
            java.lang.String r10 = r6.m(r10)
            java.lang.String r10 = defpackage.C0535I5.s0(r10)
            r7.append(r10)
            r7.append(r9)
            java.lang.String r10 = r22.getDestStn()
            r7.append(r10)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r0.setText(r7)
            r6.close()
            java.util.Date r0 = r22.getBoardingDate()
            java.text.SimpleDateFormat r7 = r1.f4580a
            java.text.SimpleDateFormat r10 = r1.f4588b
            java.lang.String r11 = " *N.A."
            if (r0 == 0) goto L_0x0174
            android.widget.TextView r0 = r1.deptDate
            java.util.Date r12 = r22.getBoardingDate()
            java.lang.String r12 = r7.format(r12)
            r0.setText(r12)
            java.lang.Boolean r0 = r22.getScheduleDepartureFlag()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x016a
            android.widget.TextView r0 = r1.deptTime
            java.util.Date r12 = r22.getBoardingDate()
            long r12 = r12.getTime()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            java.lang.String r12 = r10.format(r12)
            r0.setText(r12)
            goto L_0x0174
        L_0x016a:
            android.widget.TextView r0 = r1.deptTime
            r0.setText(r11)
            android.widget.LinearLayout r0 = r1.traveltime_ll
            r0.setVisibility(r5)
        L_0x0174:
            java.util.Date r0 = r22.getDestArrvDate()
            if (r0 == 0) goto L_0x01a9
            android.widget.TextView r0 = r1.arvDate
            java.util.Date r12 = r22.getDestArrvDate()
            java.lang.String r7 = r7.format(r12)
            r0.setText(r7)
            java.lang.Boolean r0 = r22.getScheduleArrivalFlag()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x019f
            android.widget.TextView r0 = r1.arvTime
            java.util.Date r7 = r22.getDestArrvDate()
            java.lang.String r7 = r10.format(r7)
            r0.setText(r7)
            goto L_0x01a9
        L_0x019f:
            android.widget.TextView r0 = r1.arvTime
            r0.setText(r11)
            android.widget.LinearLayout r0 = r1.traveltime_ll
            r0.setVisibility(r5)
        L_0x01a9:
            java.util.Date r0 = r22.getBoardingDate()
            if (r0 == 0) goto L_0x01cc
            java.util.Date r0 = r22.getDestArrvDate()
            if (r0 == 0) goto L_0x01cc
            android.widget.TextView r0 = r1.travelTime
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.travelTime
            java.util.Date r7 = r22.getBoardingDate()
            java.util.Date r11 = r22.getDestArrvDate()
            java.lang.String r7 = defpackage.C0535I5.A(r7, r11)
            r0.setText(r7)
            goto L_0x01d2
        L_0x01cc:
            android.widget.TextView r0 = r1.travelTime
            r7 = 4
            r0.setVisibility(r7)
        L_0x01d2:
            java.lang.String r0 = r22.getNoOfBkdChild()     // Catch:{ NumberFormatException -> 0x01e4 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x01e4 }
            java.lang.String r7 = r22.getNoOfCanChild()     // Catch:{ NumberFormatException -> 0x01e4 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x01e4 }
            int r0 = r0 - r7
            goto L_0x01e9
        L_0x01e4:
            r0 = move-exception
            r0.getMessage()
            r0 = r4
        L_0x01e9:
            java.lang.String r7 = r22.getNoOfBkdPsgn()
            java.lang.String r11 = " "
            java.lang.String r12 = ""
            if (r7 == 0) goto L_0x023f
            java.lang.String r7 = r22.getNoOfCanPsgn()
            if (r7 == 0) goto L_0x023f
            java.lang.String r7 = r22.getNoOfBkdPsgn()
            java.lang.String r7 = r7.trim()
            boolean r7 = r7.equalsIgnoreCase(r12)
            if (r7 != 0) goto L_0x023f
            java.lang.String r7 = r22.getNoOfCanPsgn()
            java.lang.String r7 = r7.trim()
            boolean r7 = r7.equalsIgnoreCase(r12)
            if (r7 != 0) goto L_0x023f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r12)
            java.lang.String r13 = r22.getNoOfBkdPsgn()
            int r13 = java.lang.Integer.parseInt(r13)
            int r13 = r13 - r0
            java.lang.String r0 = java.lang.String.valueOf(r13)
            r7.append(r0)
            r7.append(r11)
            r0 = 2131952264(0x7f130288, float:1.9540966E38)
            java.lang.String r0 = r1.getString(r0)
            r7.append(r0)
            r7.append(r11)
            java.lang.String r0 = r7.toString()
            goto L_0x0240
        L_0x023f:
            r0 = r12
        L_0x0240:
            java.lang.String r7 = r22.getNoOfBkdChild()
            if (r7 == 0) goto L_0x0277
            java.lang.String r7 = r22.getNoOfCanChild()
            if (r7 == 0) goto L_0x0277
            java.lang.StringBuilder r0 = defpackage.xx.J(r0)
            java.lang.String r7 = r22.getNoOfBkdChild()
            java.lang.String r7 = r7.trim()
            int r7 = java.lang.Integer.parseInt(r7)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.append(r7)
            r0.append(r11)
            r7 = 2131952451(0x7f130343, float:1.9541345E38)
            java.lang.String r7 = r1.getString(r7)
            r0.append(r7)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
        L_0x0277:
            java.lang.String r7 = r22.getJourneyClass()
            java.lang.String r13 = " | "
            if (r7 == 0) goto L_0x02ac
            java.lang.String r7 = r22.getJourneyClass()
            java.lang.String r7 = defpackage.xx.e(r7)
            if (r7 == 0) goto L_0x029d
            java.lang.StringBuilder r0 = defpackage.lf.n(r0, r13)
            java.lang.String r7 = r22.getJourneyClass()
            java.lang.String r7 = defpackage.xx.e(r7)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            goto L_0x02ac
        L_0x029d:
            java.lang.StringBuilder r0 = defpackage.lf.n(r0, r13)
            java.lang.String r7 = r22.getJourneyClass()
            r0.append(r7)
            java.lang.String r0 = r0.toString()
        L_0x02ac:
            java.lang.String r7 = r22.getJourneyQuota()
            if (r7 == 0) goto L_0x02c1
            java.lang.StringBuilder r0 = defpackage.lf.n(r0, r13)
            java.lang.String r7 = r22.getJourneyQuota()
            r0.append(r7)
            java.lang.String r0 = r0.toString()
        L_0x02c1:
            java.lang.StringBuilder r0 = defpackage.lf.n(r0, r13)
            java.lang.String r7 = r22.getFromStn()
            java.lang.String r6 = r6.m(r7)
            java.lang.String r6 = defpackage.C0535I5.s0(r6)
            r0.append(r6)
            r0.append(r9)
            java.lang.String r6 = r22.getFromStn()
            r0.append(r6)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = defpackage.lf.n(r0, r13)
            java.util.Date r6 = r22.getBoardingDate()
            java.lang.String r6 = defpackage.C0535I5.h(r6)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = defpackage.lf.n(r0, r13)
            java.util.Date r6 = r22.getBoardingDate()
            long r6 = r6.getTime()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.String r6 = r10.format(r6)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            android.widget.TextView r6 = r1.clsQtBoarding
            r6.setText(r0)
            java.lang.String r0 = r22.getTransactionId()
            r6 = 2131952131(0x7f130203, float:1.9540696E38)
            if (r0 == 0) goto L_0x0342
            android.widget.TextView r0 = r1.transactionId
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r6 = r1.getString(r6)
            r7.append(r6)
            java.lang.String r6 = r22.getTransactionId()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r0.setText(r6)
            goto L_0x036c
        L_0x0342:
            android.widget.TextView r0 = r1.transactionId
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r6 = r1.getString(r6)
            r7.append(r6)
            java.util.ArrayList r6 = r22.getResvDetails()
            java.lang.Object r6 = r6.get(r4)
            GA r6 = (defpackage.C0514GA) r6
            java.lang.String r6 = r6.getReservationId()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r0.setText(r6)
        L_0x036c:
            java.lang.Double r0 = r22.getTotalCollectibleAmount()
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "0"
            java.lang.String r7 = "\\."
            r8 = 2
            if (r0 != 0) goto L_0x037c
            goto L_0x03e7
        L_0x037c:
            java.lang.String[] r0 = r0.split(r7)     // Catch:{ NullPointerException -> 0x03e3 }
            if (r0 == 0) goto L_0x03e7
            r9 = r0[r4]     // Catch:{ NullPointerException -> 0x03e3 }
            if (r9 == 0) goto L_0x03e7
            int r9 = r0.length     // Catch:{ NullPointerException -> 0x03e3 }
            if (r9 <= r3) goto L_0x038e
            r9 = r0[r3]     // Catch:{ NullPointerException -> 0x03e3 }
            if (r9 == 0) goto L_0x038e
            goto L_0x038f
        L_0x038e:
            r9 = r12
        L_0x038f:
            int r10 = r9.length()     // Catch:{ NullPointerException -> 0x03e3 }
            java.lang.String r13 = "."
            if (r10 >= r8) goto L_0x03c4
            int r10 = r9.length()     // Catch:{ NullPointerException -> 0x03e3 }
        L_0x039b:
            if (r10 >= r8) goto L_0x03af
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x03e3 }
            r14.<init>()     // Catch:{ NullPointerException -> 0x03e3 }
            r14.append(r9)     // Catch:{ NullPointerException -> 0x03e3 }
            r14.append(r6)     // Catch:{ NullPointerException -> 0x03e3 }
            java.lang.String r9 = r14.toString()     // Catch:{ NullPointerException -> 0x03e3 }
            int r10 = r10 + 1
            goto L_0x039b
        L_0x03af:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x03e3 }
            r10.<init>()     // Catch:{ NullPointerException -> 0x03e3 }
            r0 = r0[r4]     // Catch:{ NullPointerException -> 0x03e3 }
            r10.append(r0)     // Catch:{ NullPointerException -> 0x03e3 }
            r10.append(r13)     // Catch:{ NullPointerException -> 0x03e3 }
            r10.append(r9)     // Catch:{ NullPointerException -> 0x03e3 }
            java.lang.String r0 = r10.toString()     // Catch:{ NullPointerException -> 0x03e3 }
            goto L_0x03e8
        L_0x03c4:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x03e3 }
            r9.<init>()     // Catch:{ NullPointerException -> 0x03e3 }
            r10 = r0[r4]     // Catch:{ NullPointerException -> 0x03e3 }
            r9.append(r10)     // Catch:{ NullPointerException -> 0x03e3 }
            r9.append(r13)     // Catch:{ NullPointerException -> 0x03e3 }
            r0 = r0[r3]     // Catch:{ NullPointerException -> 0x03e3 }
            java.lang.String r0 = r0.trim()     // Catch:{ NullPointerException -> 0x03e3 }
            java.lang.String r0 = r0.substring(r4, r8)     // Catch:{ NullPointerException -> 0x03e3 }
            r9.append(r0)     // Catch:{ NullPointerException -> 0x03e3 }
            java.lang.String r0 = r9.toString()     // Catch:{ NullPointerException -> 0x03e3 }
            goto L_0x03e8
        L_0x03e3:
            r0 = move-exception
            r0.toString()
        L_0x03e7:
            r0 = r12
        L_0x03e8:
            android.widget.TextView r9 = r1.totalFare
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r13 = 2131953645(0x7f1307ed, float:1.9543767E38)
            java.lang.String r14 = r1.getString(r13)
            r10.append(r14)
            r10.append(r11)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r9.setText(r0)
            android.widget.TextView r0 = r1.basefare
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r1.getString(r13)
            r9.append(r10)
            r9.append(r11)
            java.lang.Integer r10 = r22.getTotalFare()
            java.lang.String r10 = r10.toString()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r0.setText(r9)
            java.lang.Double r0 = r22.getServiceChargeTotal()
            if (r0 == 0) goto L_0x0475
            java.lang.Double r0 = r22.getServiceChargeTotal()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String[] r0 = r0.split(r7)
            r0 = r0[r3]
            int r0 = r0.length()
            if (r0 >= r8) goto L_0x0462
            android.widget.TextView r0 = r1.conviencefee
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "₹  "
            r7.<init>(r8)
            java.lang.Double r8 = r22.getServiceChargeTotal()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r0.setText(r6)
            goto L_0x0475
        L_0x0462:
            android.widget.TextView r0 = r1.conviencefee
            java.lang.Double r6 = r22.getServiceChargeTotal()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "₹ "
            java.lang.String r6 = r7.concat(r6)
            r0.setText(r6)
        L_0x0475:
            android.widget.TextView r0 = r1.travelInsurance
            r0.setVisibility(r5)
            java.lang.String r0 = r22.getInsuranceOpted()
            java.lang.String r6 = "N/A"
            if (r0 == 0) goto L_0x0491
            android.widget.TextView r0 = r1.travelInsurance
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.travelInsurance
            java.lang.String r7 = r22.getInsuranceOpted()
            r0.setText(r7)
            goto L_0x049b
        L_0x0491:
            android.widget.TextView r0 = r1.travelInsurance
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.travelInsurance
            r0.setText(r6)
        L_0x049b:
            java.lang.String r0 = r22.getBankName()
            if (r0 == 0) goto L_0x04b0
            android.widget.RelativeLayout r0 = r1.payment_from
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.paymentmode
            java.lang.String r7 = r22.getBankName()
            r0.setText(r7)
            goto L_0x04ba
        L_0x04b0:
            android.widget.TextView r0 = r1.paymentmode
            r0.setVisibility(r5)
            android.widget.RelativeLayout r0 = r1.payment_from
            r0.setVisibility(r5)
        L_0x04ba:
            android.widget.LinearLayout r0 = r1.currentStatusLl
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.vikalpOpt
            java.lang.String r7 = r22.getVikalpStatus()
            r0.setText(r7)
            android.widget.TextView r0 = r1.chartStatus
            java.lang.String r7 = r22.getTrainChartStatus()
            r0.setText(r7)
            java.lang.String r0 = r22.getInsuranceOpted()
            if (r0 == 0) goto L_0x04e6
            android.widget.LinearLayout r0 = r1.currentStatusLl
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.policyopt
            java.lang.String r7 = r22.getInsuranceOpted()
            r0.setText(r7)
            goto L_0x04eb
        L_0x04e6:
            android.widget.TextView r0 = r1.policyopt
            r0.setVisibility(r5)
        L_0x04eb:
            java.lang.String r0 = r22.getTktBookedFrom()
            if (r0 == 0) goto L_0x050a
            java.lang.String r0 = r22.getTktBookedFrom()
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x050a
            android.widget.LinearLayout r0 = r1.currentStatusLl
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.bookedfrom
            java.lang.String r7 = r22.getTktBookedFrom()
            r0.setText(r7)
            goto L_0x0514
        L_0x050a:
            android.widget.TextView r0 = r1.bookedfrom
            r0.setVisibility(r5)
            android.widget.RelativeLayout r0 = r1.rl_booked_from
            r0.setVisibility(r5)
        L_0x0514:
            java.lang.String r0 = r22.getBankName()
            if (r0 == 0) goto L_0x052d
            android.widget.LinearLayout r0 = r1.currentStatusLl
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.bankname
            java.lang.String r7 = r22.getBankName()
            java.lang.String r7 = r7.toString()
            r0.setText(r7)
            goto L_0x0537
        L_0x052d:
            android.widget.TextView r0 = r1.bankname
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.rl_bank_name
            r0.setVisibility(r5)
        L_0x0537:
            java.lang.Double r0 = r22.getTotalCollectibleAmount()
            if (r0 == 0) goto L_0x0550
            android.widget.LinearLayout r0 = r1.currentStatusLl
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.ticketcharge
            java.lang.Double r7 = r22.getTotalCollectibleAmount()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.setText(r7)
            goto L_0x0555
        L_0x0550:
            android.widget.TextView r0 = r1.ticketcharge
            r0.setVisibility(r5)
        L_0x0555:
            java.util.Date r0 = r22.getJourneyDate()
            java.util.Date r7 = r1.f4582a
            boolean r0 = r0.before(r7)
            r7 = 33
            r8 = 18
            if (r0 == 0) goto L_0x0571
            android.widget.LinearLayout r0 = r1.travelInsurancelayout
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.travel_insurance_ll
            r0.setVisibility(r5)
            goto L_0x0681
        L_0x0571:
            android.widget.LinearLayout r0 = r1.travelInsurancelayout
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r1.travel_insurance_ll
            r0.setVisibility(r4)
            cris.org.in.ima.view_holder.ErsTravelnsuranceViewHolder r0 = new cris.org.in.ima.view_holder.ErsTravelnsuranceViewHolder
            android.content.Context r9 = r1.f4569a
            java.util.ArrayList<cris.prs.webservices.dto.BookingResponseDTO> r10 = r1.f4596d
            r0.<init>(r9, r10)
            androidx.recyclerview.widget.RecyclerView r9 = r1.travel_insurance_rv
            androidx.recyclerview.widget.LinearLayoutManager r10 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r11 = r21.getContext()
            r10.<init>(r11)
            r9.setLayoutManager(r10)
            androidx.recyclerview.widget.RecyclerView r9 = r1.travel_insurance_rv
            r9.setAdapter(r0)
            java.lang.String r0 = r22.getInsuranceOpted()
            if (r0 == 0) goto L_0x067c
            java.lang.String r0 = r22.getInsuranceOpted()
            java.lang.String r9 = "NO"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x067c
            java.lang.String r0 = r22.getInsuranceOpted()
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 != 0) goto L_0x067c
            android.widget.LinearLayout r0 = r1.travelInsurancelayout
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.travelInsuranceName
            java.lang.String r6 = r22.getInsuranceCompany()
            r0.setText(r6)
            java.lang.String r0 = r22.getInsuranceCompanyUrl()
            if (r0 == 0) goto L_0x0619
            java.lang.String r0 = r22.getInsuranceCompanyUrl()
            java.lang.String r0 = r0.trim()
            int r0 = r0.compareToIgnoreCase(r12)
            if (r0 == 0) goto L_0x0619
            android.widget.TextView r0 = r1.fillNomineeDetails
            r0.setVisibility(r4)
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder
            r0 = 2131951705(0x7f130059, float:1.9539832E38)
            java.lang.String r0 = r1.getString(r0)
            r6.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r9 = r21.getContext()
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131100583(0x7f0603a7, float:1.7813552E38)
            int r9 = defpackage.d7.b.a(r9, r10)
            r0.<init>(r9)
            cris.org.in.ima.fragment.ErsDisplayFragment$e r9 = new cris.org.in.ima.fragment.ErsDisplayFragment$e
            r9.<init>(r2)
            r10 = 37
            r6.setSpan(r9, r4, r10, r7)     // Catch:{ Exception -> 0x0606 }
            r6.setSpan(r0, r4, r10, r8)     // Catch:{ Exception -> 0x0606 }
            goto L_0x060a
        L_0x0606:
            r0 = move-exception
            r0.getMessage()
        L_0x060a:
            android.widget.TextView r0 = r1.fillNomineeDetails
            r0.setText(r6)
            android.widget.TextView r0 = r1.fillNomineeDetails
            android.text.method.MovementMethod r6 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r6)
            goto L_0x061e
        L_0x0619:
            android.widget.TextView r0 = r1.fillNomineeDetails
            r0.setVisibility(r5)
        L_0x061e:
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>(r12)
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r6 = r1.f4593c
            if (r6 == 0) goto L_0x0676
            java.util.Iterator r6 = r6.iterator()
        L_0x062b:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0676
            java.lang.Object r9 = r6.next()
            cris.prs.webservices.dto.PassengerDetailDTO r9 = (cris.prs.webservices.dto.PassengerDetailDTO) r9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Policy Number of "
            r10.<init>(r11)
            java.lang.String r11 = r9.getPassengerName()
            r10.append(r11)
            java.lang.String r11 = " : "
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r0.append(r10)
            java.lang.String r10 = r9.getPolicyNumber()
            if (r10 == 0) goto L_0x0670
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPolicyNumber()
            r10.append(r9)
            java.lang.String r9 = " \n"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r0.append(r9)
            goto L_0x062b
        L_0x0670:
            java.lang.String r9 = "NOT APPLICABLE \n"
            r0.append(r9)
            goto L_0x062b
        L_0x0676:
            android.widget.TextView r6 = r1.passengerName
            r6.setText(r0)
            goto L_0x0681
        L_0x067c:
            android.widget.LinearLayout r0 = r1.travelInsurancelayout
            r0.setVisibility(r5)
        L_0x0681:
            java.util.List r0 = r22.getErsDisplayMessage()
            java.lang.String r6 = "\n\n"
            if (r0 == 0) goto L_0x06b2
            java.util.List r0 = r22.getErsDisplayMessage()
            java.util.Iterator r0 = r0.iterator()
            r9 = r12
        L_0x0692:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x06a7
            java.lang.Object r10 = r0.next()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r9 = defpackage.C1058d.z(r9, r10)
            java.lang.String r9 = defpackage.C1058d.z(r9, r6)
            goto L_0x0692
        L_0x06a7:
            android.widget.TextView r0 = r1.ersMsgs
            r0.setText(r9)
            android.widget.TextView r0 = r1.ersMsgs
            r0.setVisibility(r4)
            goto L_0x06b7
        L_0x06b2:
            android.widget.TextView r0 = r1.ersMsgs
            r0.setVisibility(r5)
        L_0x06b7:
            java.lang.Boolean r0 = r1.f4587b
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x06f7
            cris.prs.webservices.dto.BookingResponseDTO r0 = r1.b
            java.util.List r0 = r0.getErsDisplayMessage()
            if (r0 == 0) goto L_0x06f2
            cris.prs.webservices.dto.BookingResponseDTO r0 = r1.b
            java.util.List r0 = r0.getErsDisplayMessage()
            java.util.Iterator r0 = r0.iterator()
            r9 = r12
        L_0x06d2:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x06e7
            java.lang.Object r10 = r0.next()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r9 = defpackage.C1058d.z(r9, r10)
            java.lang.String r9 = defpackage.C1058d.z(r9, r6)
            goto L_0x06d2
        L_0x06e7:
            android.widget.TextView r0 = r1.tv_ers_msgs_lap2
            r0.setText(r9)
            android.widget.TextView r0 = r1.tv_ers_msgs_lap2
            r0.setVisibility(r4)
            goto L_0x06f7
        L_0x06f2:
            android.widget.TextView r0 = r1.tv_ers_msgs_lap2
            r0.setVisibility(r5)
        L_0x06f7:
            java.util.List r0 = r22.getDutiesMessage()
            if (r0 == 0) goto L_0x0727
            java.util.List r0 = r22.getDutiesMessage()
            java.util.Iterator r0 = r0.iterator()
            r9 = r4
            r6 = r12
        L_0x0707:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x0721
            java.lang.Object r10 = r0.next()
            java.lang.String r10 = (java.lang.String) r10
            if (r9 == 0) goto L_0x071f
            java.lang.String r6 = defpackage.C1058d.z(r6, r10)
            java.lang.String r9 = "\n"
            java.lang.String r6 = defpackage.C1058d.z(r6, r9)
        L_0x071f:
            r9 = r3
            goto L_0x0707
        L_0x0721:
            android.widget.TextView r0 = r1.funda_duty_msg
            r0.setText(r6)
            goto L_0x072c
        L_0x0727:
            android.widget.RelativeLayout r0 = r1.funda_duty_ll
            r0.setVisibility(r5)
        L_0x072c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.f4599e = r0
            java.util.ArrayList<cris.prs.webservices.dto.BookingResponseDTO> r0 = r1.f4596d
            java.util.Iterator r0 = r0.iterator()
        L_0x0739:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0754
            java.lang.Object r6 = r0.next()
            cris.prs.webservices.dto.BookingResponseDTO r6 = (cris.prs.webservices.dto.BookingResponseDTO) r6
            j3 r9 = new j3
            r9.<init>()
            r9.a = r6
            r9.f5519a = r4
            java.util.ArrayList<j3> r6 = r1.f4599e
            r6.add(r9)
            goto L_0x0739
        L_0x0754:
            cris.org.in.ima.view_holder.ErsTrainDeatilLapwiseViewHolder r0 = new cris.org.in.ima.view_holder.ErsTrainDeatilLapwiseViewHolder
            android.content.Context r6 = r1.f4569a
            java.util.ArrayList<j3> r9 = r1.f4599e
            cris.org.in.ima.fragment.ErsDisplayFragment$q r10 = r1.f4574a
            r0.<init>(r6, r9, r10)
            r1.f4576a = r0
            androidx.recyclerview.widget.RecyclerView r0 = r1.rv_train_detail
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r9 = r21.getContext()
            r6.<init>(r9)
            r0.setLayoutManager(r6)
            androidx.recyclerview.widget.RecyclerView r0 = r1.rv_train_detail
            cris.org.in.ima.view_holder.ErsTrainDeatilLapwiseViewHolder r6 = r1.f4576a
            r0.setAdapter(r6)
            java.lang.Boolean r0 = r1.f4587b
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x07a4
            cris.org.in.ima.view_holder.ErsPassengerViewHolder r0 = new cris.org.in.ima.view_holder.ErsPassengerViewHolder
            android.content.Context r6 = r1.f4569a
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r9 = r1.f4593c
            r22.getPnrNumber()
            cris.prs.webservices.dto.BookingResponseDTO r10 = r1.b
            java.lang.String r10 = r10.getPnrNumber()
            r0.<init>(r6, r9, r10, r4)
            androidx.recyclerview.widget.RecyclerView r6 = r1.psgnList
            androidx.recyclerview.widget.LinearLayoutManager r9 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r10 = r21.getContext()
            r9.<init>(r10)
            r6.setLayoutManager(r9)
            androidx.recyclerview.widget.RecyclerView r6 = r1.psgnList
            r6.setAdapter(r0)
            goto L_0x07c1
        L_0x07a4:
            cris.org.in.ima.view_holder.ErsPassengerViewHolder r0 = new cris.org.in.ima.view_holder.ErsPassengerViewHolder
            android.content.Context r6 = r1.f4569a
            java.util.ArrayList<cris.prs.webservices.dto.PassengerDetailDTO> r9 = r1.f4593c
            r10 = 0
            r0.<init>(r6, r9, r10, r4)
            androidx.recyclerview.widget.RecyclerView r6 = r1.psgnList
            androidx.recyclerview.widget.LinearLayoutManager r9 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r10 = r21.getContext()
            r9.<init>(r10)
            r6.setLayoutManager(r9)
            androidx.recyclerview.widget.RecyclerView r6 = r1.psgnList
            r6.setAdapter(r0)
        L_0x07c1:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = defpackage.C1450w1.f7018b
            java.lang.Boolean r6 = r22.getErsGovMsg()
            if (r6 == 0) goto L_0x07d3
            java.lang.Boolean r6 = r22.getErsGovMsg()
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x080c
        L_0x07d3:
            if (r0 == 0) goto L_0x080c
            java.lang.String r6 = "ersPopupMsg"
            boolean r9 = r0.containsKey(r6)
            if (r9 == 0) goto L_0x080c
            java.lang.Object r0 = r0.get(r6)
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x080c
            boolean r0 = r15.equals(r12)
            if (r0 != 0) goto L_0x080c
            androidx.fragment.app.FragmentActivity r13 = r21.getActivity()
            r14 = 0
            r0 = 2131951640(0x7f130018, float:1.95397E38)
            java.lang.String r16 = r1.getString(r0)
            r0 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r17 = r1.getString(r0)
            r18 = 0
            r19 = 0
            r20 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.p(r13, r14, r15, r16, r17, r18, r19, r20)
            r0.show()
        L_0x080c:
            java.lang.String r0 = r22.getTktLegendMessage()
            if (r0 == 0) goto L_0x082e
            java.lang.String r0 = r22.getTktLegendMessage()
            java.lang.String r0 = r0.trim()
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x082e
            android.widget.LinearLayout r0 = r1.informationLayout
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.informationMsg
            java.lang.String r6 = r22.getTktLegendMessage()
            r0.setText(r6)
        L_0x082e:
            java.lang.Boolean r0 = r1.f4587b
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x085e
            cris.prs.webservices.dto.BookingResponseDTO r0 = r1.b
            java.lang.String r0 = r0.getTktLegendMessage()
            if (r0 == 0) goto L_0x085e
            cris.prs.webservices.dto.BookingResponseDTO r0 = r1.b
            java.lang.String r0 = r0.getTktLegendMessage()
            java.lang.String r0 = r0.trim()
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x085e
            android.widget.LinearLayout r0 = r1.informationLayout_lap2
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.informationMsg_lap2
            cris.prs.webservices.dto.BookingResponseDTO r6 = r1.b
            java.lang.String r6 = r6.getTktLegendMessage()
            r0.setText(r6)
        L_0x085e:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = defpackage.C1450w1.f7018b
            if (r0 == 0) goto L_0x08cc
            java.lang.String r6 = "pledgeLableMsg"
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x08cc
            java.util.HashMap<java.lang.String, java.lang.String> r0 = defpackage.C1450w1.f7018b
            java.lang.Object r0 = r0.get(r6)
            if (r0 == 0) goto L_0x08cc
            android.text.SpannableStringBuilder r5 = new android.text.SpannableStringBuilder
            android.content.res.Resources r0 = r21.getResources()
            r6 = 2131953975(0x7f130937, float:1.9544436E38)
            java.lang.String r0 = r0.getString(r6)
            r5.<init>(r0)
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            android.content.Context r6 = r21.getContext()
            java.lang.Object r9 = defpackage.d7.a
            r9 = 2131099733(0x7f060055, float:1.7811828E38)
            int r6 = defpackage.d7.b.a(r6, r9)
            r0.<init>(r6)
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r3)
            cris.org.in.ima.fragment.ErsDisplayFragment$f r3 = new cris.org.in.ima.fragment.ErsDisplayFragment$f
            r3.<init>(r2)
            int r2 = r5.length()     // Catch:{ Exception -> 0x08b4 }
            r5.setSpan(r6, r4, r2, r8)     // Catch:{ Exception -> 0x08b4 }
            int r2 = r5.length()     // Catch:{ Exception -> 0x08b4 }
            r5.setSpan(r3, r4, r2, r7)     // Catch:{ Exception -> 0x08b4 }
            int r2 = r5.length()     // Catch:{ Exception -> 0x08b4 }
            r5.setSpan(r0, r4, r2, r8)     // Catch:{ Exception -> 0x08b4 }
            goto L_0x08b8
        L_0x08b4:
            r0 = move-exception
            r0.getMessage()
        L_0x08b8:
            android.widget.TextView r0 = r1.vigilanceMsg
            r0.setText(r5)
            android.widget.TextView r0 = r1.vigilanceMsg
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r2)
            android.widget.TextView r0 = r1.vigilanceMsg
            r0.setVisibility(r4)
            goto L_0x08d1
        L_0x08cc:
            android.widget.TextView r0 = r1.vigilanceMsg
            r0.setVisibility(r5)
        L_0x08d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.ErsDisplayFragment.o(cris.prs.webservices.dto.BookingResponseDTO):void");
    }

    @OnClick({2131362722})
    public void onClicfundadutymsg(View view) {
        if (this.funda_duty_detail_ll.getVisibility() == 0) {
            this.funda_duty_detail_ll.setVisibility(8);
        } else {
            this.funda_duty_detail_ll.setVisibility(0);
        }
    }

    @OnClick({2131362295})
    public void onConnectingClick() {
        String str = this.f;
        if (str != null && !str.isEmpty()) {
            String str2 = this.f;
            BookingResponseDTO bookingResponseDTO = this.c;
            if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4569a)) {
                new Handler().postDelayed(new C0721Va(), 5000);
            } else if (bookingResponseDTO.getPsgnDtlList() == null || bookingResponseDTO.getPsgnDtlList().size() <= 0) {
                ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.fetching_Connecting_Journey), getString(R.string.please_wait_text));
                this.f4568a = show;
                C1223kn knVar = C0793b1.a.f3912a;
                this.f4585a = knVar;
                if (knVar != null) {
                    try {
                        show.show();
                        String f2 = C0657Qt.f();
                        String format = String.format("/%s", new Object[]{str2});
                        ((Om) C0657Qt.c(this.f4585a)).F0(f2 + "historySearchByTxnId" + format).c(C1181iv.a()).a(E0.a()).b(new C0734Wa(this, bookingResponseDTO));
                    } catch (Exception unused) {
                        j();
                        C0535I5.t0(getActivity(), getString(R.string.please_try_again));
                    }
                } else {
                    C0535I5.m(getActivity(), false, getResources().getString(R.string.unable_process_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } else {
                if (bookingResponseDTO.getConnectingPnrNumber() != null && !bookingResponseDTO.getConnectingPnrNumber().isEmpty()) {
                    this.f = l(bookingResponseDTO.getConnectingPnrNumber(), TicketHistoryUtil.b);
                }
                q(bookingResponseDTO, this.f);
                this.f = null;
            }
            this.c = null;
            this.f = null;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Date date;
        long j2;
        BookingResponseDTO bookingResponseDTO;
        View inflate = layoutInflater.inflate(R.layout.activity_ercticket, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        this.f4569a = getContext();
        StrictMode.setVmPolicy(builder.build());
        C0535I5.H(getActivity(), getView());
        this.payment_from.setVisibility(8);
        this.feedback_ll.setVisibility(8);
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
        TextView textView = this.fillNomineeDetails;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        try {
            SimpleDateFormat simpleDateFormat = this.f4592c;
            this.f4582a = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        } catch (ParseException e2) {
            e2.getMessage();
        }
        AlertDialog alertDialog = C0535I5.f3619a;
        this.attention_msg1.setVisibility(8);
        this.attention_msg.setVisibility(8);
        C0535I5.f3652m = false;
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<BookingResponseDTO> arrayList = (ArrayList) arguments.getSerializable("TicketErs");
            this.f4596d = arrayList;
            this.f4577a = arrayList.get(0);
            this.f4587b = Boolean.valueOf(arguments.getBoolean("multiLapFlag"));
            if (this.f4596d.size() > 1) {
                this.f4587b = Boolean.TRUE;
            } else {
                this.f4587b = Boolean.FALSE;
            }
            if (this.f4587b.booleanValue()) {
                this.b = this.f4596d.get(1);
            }
            this.f4591c = this.f4577a.getPnrNumber();
            this.f4577a.getTrainNumber();
            this.f4598e = this.f4577a.getTransactionId();
            this.f4593c = this.f4596d.get(0).getPsgnDtlList();
            C0707Ue ue = (C0707Ue) arguments.getSerializable("historyEnquiryDTO");
            this.a = ue;
            if (ue.getBookingResponseList().size() <= 0 || this.a.getBookingResponseList().get(0).getButtons() == null || this.a.getBookingResponseList().get(0).getButtons().size() <= 9 || this.a.getBookingResponseList().get(0).getButtons().get(9).shortValue() != 1) {
                this.f4579a = Boolean.FALSE;
            } else {
                this.f4579a = Boolean.TRUE;
            }
            if (this.f4577a.isMetroServiceOpted()) {
                this.qrTicketDetails_ll.setVisibility(0);
                this.f4584a = this.a.getBookingResponseList().get(0).getMetroServiceDetail().getMetroPassengerList();
                DmrcQRPagerAdapter dmrcQRPagerAdapter = new DmrcQRPagerAdapter(getContext(), this.f4584a, this.f4573a);
                this.dmrcQrCodeViewPager.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                this.dmrcQrCodeViewPager.setAdapter(dmrcQRPagerAdapter);
                TextView textView2 = this.from_stn;
                textView2.setText(" " + this.a.getBookingResponseList().get(0).getMetroServiceDetail().getMetroFromStation());
                TextView textView3 = this.toStn;
                textView3.setText(" " + this.a.getBookingResponseList().get(0).getMetroServiceDetail().getMetroToStation());
                if (this.a.getBookingResponseList().get(0).getMetroServiceDetail().getMetroJourneyDate() != null) {
                    this.journey_date.setText(C0535I5.F(this.a.getBookingResponseList().get(0).getMetroServiceDetail().getMetroJourneyDate()));
                    LocalDate localDate = ZonedDateTime.parse(String.valueOf(this.a.getBookingResponseList().get(0).getMetroServiceDetail().getMetroJourneyDate()), DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss 'GMT'xxx yyyy", Locale.ENGLISH)).toLocalDate();
                    LocalDate minusDays = localDate.minusDays(1);
                    LocalDate plusDays = localDate.plusDays(2);
                    DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("MMM dd, yyyy ");
                    String format = minusDays.format(ofPattern);
                    String format2 = plusDays.format(ofPattern);
                    TextView textView4 = this.active_date;
                    textView4.setText("  " + format + " - " + format2);
                }
            } else {
                this.qrTicketDetails_ll.setVisibility(8);
            }
            if (arguments.containsKey("connectingTxnId") && arguments.getString("connectingTxnId") != null) {
                this.f = arguments.getString("connectingTxnId");
            }
            o(this.f4577a);
        }
        C0535I5.f3651l = false;
        if (TicketHistoryUtil.f5370a != TicketHistoryUtil.SortFor.LAST_TXN) {
            HomeActivity.a.setVisibility(0);
        }
        HashMap<String, String> hashMap = C1450w1.f7018b;
        if (hashMap != null && hashMap.containsKey("pledgePopupMsg") && C1450w1.f7018b.get("pledgePopupMsg") != null && this.f4594c) {
            C0535I5.p(this.f4569a, true, C1450w1.f7018b.get("pledgePopupMsg"), getResources().getString(R.string.pledge_title), getString(R.string.visit), new C0589Ma(this), getString(R.string.no_thanks), new C0605Na()).show();
        }
        this.right_arrow.setOnClickListener(new c());
        this.left_arrow.setOnClickListener(new j());
        this.qrImgCross.setOnClickListener(new n());
        HomeActivity.a.setOnClickListener(new o());
        if (Bw.e(getContext()).k() != null) {
            this.tktSentMsg.setVisibility(0);
        }
        BookingResponseDTO bookingResponseDTO2 = this.f4577a;
        if (bookingResponseDTO2.getGstFlag() == null || !bookingResponseDTO2.getGstFlag().booleanValue()) {
            this.allGstDtlLayout.setVisibility(8);
        } else {
            this.allGstDtlLayout.setVisibility(0);
            if (bookingResponseDTO2.getGstCharge().getGstinSuplier() != null) {
                this.gstnSuplierCode.setVisibility(0);
                this.gstnSuplierCode.setText(bookingResponseDTO2.getGstCharge().getGstinSuplier());
            }
            if (bookingResponseDTO2.getGstCharge().getSacCode() != null) {
                this.sacNumber.setText(String.valueOf(bookingResponseDTO2.getGstCharge().getSacCode()));
                this.sacNumber.setVisibility(0);
            }
            if (bookingResponseDTO2.getGstCharge().getPrsSuplierState() != null) {
                this.gstnStateName.setText(bookingResponseDTO2.getGstCharge().getPrsSuplierState());
                this.gstnStateName.setVisibility(0);
            }
            if (bookingResponseDTO2.getGstCharge().getPrsSgstCharge() != null && bookingResponseDTO2.getGstCharge().getPrsSgstCharge().floatValue() > 0.0f) {
                this.sgstAmt.setText(String.valueOf(bookingResponseDTO2.getGstCharge().getPrsSgstCharge()));
                TextView textView5 = this.sgstRate;
                textView5.setText("(@" + String.valueOf(bookingResponseDTO2.getGstCharge().getSgstRate()) + "%)");
                this.gstBreakupLayout.setVisibility(0);
                this.sgstLayoutId.setVisibility(0);
            }
            if (bookingResponseDTO2.getGstCharge().getPrsUgstCharge() != null && bookingResponseDTO2.getGstCharge().getPrsUgstCharge().floatValue() > 0.0f) {
                this.UgstAmt.setText(String.valueOf(bookingResponseDTO2.getGstCharge().getPrsUgstCharge()));
                TextView textView6 = this.UgstRate;
                textView6.setText("(@" + String.valueOf(bookingResponseDTO2.getGstCharge().getUgstRate()) + "%)");
                this.gstBreakupLayout.setVisibility(0);
                this.ugstLayout.setVisibility(0);
            }
            if (bookingResponseDTO2.getGstCharge().getPrsCgstCharge() != null && bookingResponseDTO2.getGstCharge().getPrsCgstCharge().floatValue() > 0.0f) {
                this.cgstAmt.setText(String.valueOf(bookingResponseDTO2.getGstCharge().getPrsCgstCharge()));
                TextView textView7 = this.cgstRate;
                textView7.setText("(@" + String.valueOf(bookingResponseDTO2.getGstCharge().getCgstRate()) + "%)");
                this.gstBreakupLayout.setVisibility(0);
                this.cgstLayout.setVisibility(0);
            }
            if (bookingResponseDTO2.getGstCharge().getPrsIgstCharge() != null && bookingResponseDTO2.getGstCharge().getPrsIgstCharge().floatValue() > 0.0f) {
                this.igstAmt.setText(String.valueOf(bookingResponseDTO2.getGstCharge().getPrsIgstCharge()));
                TextView textView8 = this.igstRate;
                textView8.setText("(@" + String.valueOf(bookingResponseDTO2.getGstCharge().getIgstRate()) + "%)");
                this.gstBreakupLayout.setVisibility(0);
                this.igstLayout.setVisibility(0);
                this.sgstLayoutId.setVisibility(8);
                this.cgstLayout.setVisibility(8);
                this.ugstLayout.setVisibility(8);
            }
            if (bookingResponseDTO2.getServiceTax() != null) {
                this.totalTax.setText("₹  ".concat(String.valueOf(bookingResponseDTO2.getServiceTax())));
                this.totalTax.setVisibility(0);
            }
            if (bookingResponseDTO2.getGstCharge().getTaxableAmt() != null) {
                this.totalValuableTax.setText("₹  ".concat(String.valueOf(new DecimalFormat("#.##").format(bookingResponseDTO2.getGstCharge().getTaxableAmt()))));
                this.totalValuableTax.setVisibility(0);
            }
            if (bookingResponseDTO2.getGstDetailsDTO() == null) {
                this.gstnRecptInfo.setVisibility(8);
                this.recipient_view.setVisibility(8);
            } else {
                if (bookingResponseDTO2.getGstDetailsDTO().getGstIn() != null) {
                    this.gstnRceiptId.setText(String.valueOf(bookingResponseDTO2.getGstDetailsDTO().getGstIn()));
                    this.gstnRecptInfo.setVisibility(0);
                    this.recipient_view.setVisibility(0);
                }
                if (bookingResponseDTO2.getGstDetailsDTO().getArea() != null) {
                    this.address.setText(String.valueOf(bookingResponseDTO2.getGstDetailsDTO().getFlat()));
                }
                if (bookingResponseDTO2.getGstDetailsDTO().getStreet() != null) {
                    this.address.setText(String.valueOf(bookingResponseDTO2.getGstDetailsDTO().getFlat()));
                }
                if (bookingResponseDTO2.getGstDetailsDTO().getCity() != null) {
                    this.city.setText(String.valueOf(bookingResponseDTO2.getGstDetailsDTO().getArea()));
                }
                if (bookingResponseDTO2.getGstDetailsDTO().getState() != null) {
                    this.state.setText(String.valueOf(bookingResponseDTO2.getGstDetailsDTO().getState()).concat("-"));
                }
                if (bookingResponseDTO2.getGstDetailsDTO().getPin() != null) {
                    this.pincode.setText(String.valueOf(bookingResponseDTO2.getGstDetailsDTO().getPin()));
                }
                if (bookingResponseDTO2.getGstDetailsDTO().getNameOnGst() != null) {
                    this.name.setText(String.valueOf(bookingResponseDTO2.getGstDetailsDTO().getNameOnGst()));
                    this.gstnRecptInfo.setVisibility(0);
                    this.recipient_view.setVisibility(0);
                }
            }
        }
        this.f4571a = C0793b1.a.f3911a;
        this.myBookingDetailCenter.setVisibility(0);
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setGender(C1450w1.f7021c);
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setSource(this.f4577a.getFromStn());
        googleAdParamDTO.setDestination(this.f4577a.getDestStn());
        SimpleDateFormat simpleDateFormat2 = C0535I5.f3621a;
        googleAdParamDTO.setDepartureDate(simpleDateFormat2.format(this.f4577a.getBoardingDate()));
        googleAdParamDTO.setArrivalDate(simpleDateFormat2.format(this.f4577a.getDestArrvDate()));
        if (!(this.f4577a.getJourneyQuota() == null || H9.i(this.f4577a.getJourneyQuota()) == null)) {
            googleAdParamDTO.setQuata(H9.i(this.f4577a.getJourneyQuota()).f3610c);
        }
        googleAdParamDTO.setjClass(this.f4577a.getJourneyClass());
        googleAdParamDTO.setTrainType(this.f4577a.getTrainTypeCode());
        Iterator<PassengerDetailDTO> it = this.f4593c.iterator();
        while (it.hasNext()) {
            PassengerDetailDTO next = it.next();
            if (next.getFoodChoice() != null && next.getFoodChoice().contains("N")) {
                googleAdParamDTO.setMealType("NV");
            } else if (next.getFoodChoice() == null || !next.getFoodChoice().contains("V")) {
                googleAdParamDTO.setMealType((String) null);
            } else {
                googleAdParamDTO.setMealType("V");
            }
            if (next.getCurrentStatus().contains("C")) {
                googleAdParamDTO.setTicketStatus("CNF");
            } else if (next.getCurrentStatus().contains("W")) {
                googleAdParamDTO.setTicketStatus("WL");
            } else if (next.getCurrentStatus().contains("R")) {
                googleAdParamDTO.setTicketStatus("RAC");
            } else {
                googleAdParamDTO.setTicketStatus((String) null);
            }
        }
        C0535I5.Y(getActivity(), this.myBookingDetailCenter, googleAdParamDTO);
        this.f4571a.close();
        BookingResponseDTO bookingResponseDTO3 = this.f4577a;
        bookingResponseDTO3.toString();
        if (bookingResponseDTO3.getPnrLinkStatus() == null || bookingResponseDTO3.getPnrLinkStatus().intValue() != 1) {
            this.connectingPnrLayout.setVisibility(8);
        } else {
            this.connectingPnrLayout.setVisibility(0);
            this.connectingPnr.setText(bookingResponseDTO3.getConnectingPnrNumber());
            if (bookingResponseDTO3.getJourneyLap().intValue() == 1) {
                this.lapType.setText("(Sub Journey)");
            } else if (bookingResponseDTO3.getJourneyLap().intValue() == 2) {
                this.lapType.setText("(Main Journey)");
            }
        }
        HomeActivity.J();
        if (this.f4577a.getMealTransaction() == null || !this.f4577a.getMealTransaction().isMealBooked()) {
            this.mealdetail_ll.setVisibility(8);
        } else {
            this.mealdetail_ll.setVisibility(0);
            this.g.addAll(this.f4577a.getMealTransaction().getAddMealDetail());
            p();
        }
        C0535I5.f3643f = true;
        C0535I5.f3645g = false;
        try {
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy/MM/dd");
            Date parse = simpleDateFormat3.parse(this.f4580a.format(this.f4577a.getBoardingDate()));
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.add(6, 1);
            if (simpleDateFormat3.format(instance.getTime()) != null) {
                this.tv_tab_upcoming_journey_hotel.setEnabled(false);
                this.tv_tab_upcoming_journey_retroom.setEnabled(false);
                return inflate;
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        if (this.f4577a.getRrHbFlag() == null) {
            this.tv_tab_upcoming_journey_hotel.setEnabled(false);
            this.tv_tab_upcoming_journey_retroom.setEnabled(false);
            return inflate;
        }
        if (e || ((bookingResponseDTO = this.b) != null && this.f4577a != null && bookingResponseDTO.getReservationStatus().equalsIgnoreCase(getString(R.string.cancelled)) && this.f4577a.getReservationStatus().equalsIgnoreCase(getString(R.string.cancelled)))) {
            this.tv_tab_upcoming_journey_hotel.setEnabled(false);
            this.tv_tab_upcoming_journey_hotel.setBackgroundColor(this.f4569a.getResources().getColor(R.color.light_grey));
            this.tv_tab_upcoming_journey_retroom.setEnabled(false);
            this.tv_tab_upcoming_journey_retroom.setBackgroundColor(this.f4569a.getResources().getColor(R.color.light_grey));
            this.tv_tab_upcoming_journey_mot.setEnabled(false);
            this.tv_tab_upcoming_journey_mot.setBackgroundColor(this.f4569a.getResources().getColor(R.color.light_grey));
        } else {
            if (this.f4577a.getRrHbFlag().equalsIgnoreCase("YY")) {
                this.tv_tab_upcoming_journey_hotel.setBackgroundColor(this.f4569a.getResources().getColor(R.color.bottom_dark));
                this.tv_tab_upcoming_journey_retroom.setBackgroundColor(this.f4569a.getResources().getColor(R.color.bottom_dark));
            } else if (this.f4577a.getRrHbFlag().equalsIgnoreCase("YN")) {
                this.tv_tab_upcoming_journey_hotel.setEnabled(false);
                this.tv_tab_upcoming_journey_retroom.setEnabled(true);
                this.tv_tab_upcoming_journey_hotel.setBackgroundColor(this.f4569a.getResources().getColor(R.color.light_grey));
                this.tv_tab_upcoming_journey_retroom.setBackgroundColor(this.f4569a.getResources().getColor(R.color.bottom_dark));
            } else if (this.f4577a.getRrHbFlag().equalsIgnoreCase("NY")) {
                this.tv_tab_upcoming_journey_retroom.setEnabled(false);
                this.tv_tab_upcoming_journey_hotel.setEnabled(true);
                this.tv_tab_upcoming_journey_hotel.setBackgroundColor(this.f4569a.getResources().getColor(R.color.bottom_dark));
                this.tv_tab_upcoming_journey_retroom.setBackgroundColor(this.f4569a.getResources().getColor(R.color.light_grey));
            } else if (this.f4577a.getRrHbFlag().equalsIgnoreCase("NN")) {
                this.tv_tab_upcoming_journey_hotel.setEnabled(false);
                this.tv_tab_upcoming_journey_retroom.setEnabled(false);
            }
            this.tv_tab_upcoming_journey_mot.setBackgroundColor(this.f4569a.getResources().getColor(R.color.bottom_dark));
            this.tv_bus.setBackgroundColor(this.f4569a.getResources().getColor(R.color.bottom_dark));
            this.tv_tab_delhi_metro.setBackgroundColor(this.f4569a.getResources().getColor(R.color.crimson_red));
        }
        this.psgnList_lap2.setVisibility(0);
        this.rv_train_detail.setVisibility(0);
        this.meal_detail_lap2.setVisibility(8);
        this.rv_addmeal_list_lap2.setVisibility(8);
        ArrayList arrayList2 = new ArrayList();
        this.f4599e = new ArrayList<>();
        Iterator<BookingResponseDTO> it2 = this.f4596d.iterator();
        while (it2.hasNext()) {
            BookingResponseDTO next2 = it2.next();
            C1188j3 j3Var = new C1188j3();
            j3Var.a = next2;
            j3Var.f5519a = false;
            this.f4599e.add(j3Var);
            if (next2.getPsgnDtlList() != null) {
                arrayList2.addAll(next2.getPsgnDtlList());
            }
        }
        this.f4576a = new ErsTrainDeatilLapwiseViewHolder(this.f4569a, this.f4599e, this.f4574a);
        this.rv_train_detail.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_train_detail.setAdapter(this.f4576a);
        if (this.f4587b.booleanValue()) {
            Context context = this.f4569a;
            this.f4577a.getPnrNumber();
            ErsPassengerViewHolder ersPassengerViewHolder = new ErsPassengerViewHolder(context, arrayList2, this.b.getPnrNumber(), false);
            this.psgnList.setLayoutManager(new LinearLayoutManager(getContext()));
            this.psgnList.setAdapter(ersPassengerViewHolder);
        } else {
            ErsPassengerViewHolder ersPassengerViewHolder2 = new ErsPassengerViewHolder(this.f4569a, arrayList2, (String) null, false);
            this.psgnList.setLayoutManager(new LinearLayoutManager(getContext()));
            this.psgnList.setAdapter(ersPassengerViewHolder2);
        }
        this.tain_detail_ll.setVisibility(8);
        if (this.f4587b.booleanValue()) {
            C0535I5.f3650k = true;
            this.messages_lap2.setVisibility(0);
        } else {
            C0535I5.f3650k = false;
            this.messages_lap2.setVisibility(8);
        }
        if (this.f4577a.getTktLegendMessage() == null && this.f4577a.getErsDisplayMessage() == null) {
            this.messages_lap1.setVisibility(8);
        } else {
            this.messages_lap1.setVisibility(0);
        }
        if (this.f4587b.booleanValue()) {
            if (this.b.getTktLegendMessage() == null && this.b.getErsDisplayMessage() == null) {
                this.messages_lap2.setVisibility(8);
            } else {
                this.messages_lap2.setVisibility(0);
            }
        }
        if (!this.f4587b.booleanValue()) {
            this.lap1.setText(R.string.info_msg_head);
        }
        BookingResponseDTO bookingResponseDTO4 = this.b;
        if (bookingResponseDTO4 == null || this.f4577a == null || !bookingResponseDTO4.getReservationStatus().equalsIgnoreCase(getString(R.string.cancelled)) || !this.f4577a.getReservationStatus().equalsIgnoreCase(getString(R.string.cancelled))) {
            HomeActivity.a.setVisibility(0);
        } else {
            HomeActivity.x();
        }
        if (this.f4587b.booleanValue()) {
            date = this.f4599e.get(1).a.getBoardingDate();
        } else {
            date = this.f4599e.get(0).a.getBoardingDate();
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        instance2.add(5, 2);
        Calendar.getInstance().getTime();
        try {
            new SimpleDateFormat("yyyyMMdd");
            Date time = Calendar.getInstance().getTime();
            instance2.getTime();
            j2 = (time.getTime() - date.getTime()) / 86400000;
        } catch (Exception e4) {
            e4.getMessage();
            j2 = 0;
        }
        if (j2 > 5) {
            if (this.f4587b.booleanValue()) {
                HomeActivity.x();
            }
            e = true;
        } else {
            HomeActivity.a.setVisibility(0);
            e = false;
        }
        this.ersmsg_ll.setVisibility(8);
        return inflate;
    }

    @OnClick({2131364626})
    public void onDelhiMetroClick(View view) {
        ERSFragment.g(this.f4569a, this.f4577a, this.f4598e);
    }

    @OnClick({2131364383})
    public void onDoneAddMealClick(View view) {
        ArrayList<MealItemDetails> arrayList = this.g;
        arrayList.clear();
        arrayList.addAll(C0535I5.f3624a);
        p();
        C0535I5.f3643f = true;
        C0535I5.f3645g = false;
        this.add_meal_rl.setVisibility(8);
        this.rv_addmeal_list.setVisibility(0);
    }

    @OnClick({2131362447})
    public void onDownloadPdfClick() {
        this.f4586a = false;
        if (Build.VERSION.SDK_INT > 32 || !(d7.a(this.f4569a, "android.permission.WRITE_EXTERNAL_STORAGE") == -1 || d7.a(this.f4569a, "android.permission.READ_EXTERNAL_STORAGE") == -1)) {
            C0746Xa.a(this.f4577a, this.f4569a, this.f4586a);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 16);
        }
    }

    @OnClick({2131364648})
    public void onHotelClick() {
        new Thread(new r(Toast.makeText(getContext(), getString(R.string.unble_toconnect_server2), 1))).start();
    }

    @OnClick({2131362839})
    public void onIndianQrTxtClick(View view) {
        if (this.f4587b.booleanValue()) {
            if (this.a.getQrCodeTextMultiLap() == null || this.qr_code.getVisibility() != 8) {
                this.qr_code.setVisibility(8);
                this.qr_view.setVisibility(8);
                return;
            }
            n();
            this.qr_code.setVisibility(0);
            this.qr_view.setVisibility(0);
        } else if (this.f4577a.getQrCodeText() == null || this.qr_code.getVisibility() != 8) {
            this.qr_code.setVisibility(8);
            this.qr_view.setVisibility(8);
        } else {
            n();
            this.qr_code.setVisibility(0);
            this.qr_view.setVisibility(0);
        }
    }

    @OnClick({2131364649})
    public void onMealClick() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(lf.j("https://www.ecatering.irctc.co.in/", this.f4591c, "/outlets?utm_source=irctc&utm_medium=android_app&utm_campaign=booking_page"))));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131364651})
    public void onRRClick() {
        new Thread(new s()).start();
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

    @OnClick({2131363846})
    public void onSaveERSClick() {
        this.f4586a = false;
        if (Build.VERSION.SDK_INT > 32 || !(d7.a(this.f4569a, "android.permission.WRITE_EXTERNAL_STORAGE") == -1 || d7.a(this.f4569a, "android.permission.READ_EXTERNAL_STORAGE") == -1)) {
            C0746Xa.b(this.f4569a, this.scrollView, this.f4586a, this.pnrNo);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 15);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.clear();
        super.onSaveInstanceState(bundle);
    }

    @OnClick({2131363943})
    public void onSendMailPdfClick() {
        C0746Xa.d(this.f4577a, this.f4569a);
    }

    @OnClick({2131363953})
    public void onShareButtonClick() {
        this.f4586a = true;
        if (Build.VERSION.SDK_INT > 32 || !(d7.a(this.f4569a, "android.permission.WRITE_EXTERNAL_STORAGE") == -1 || d7.a(this.f4569a, "android.permission.READ_EXTERNAL_STORAGE") == -1)) {
            C0746Xa.a(this.f4577a, this.f4569a, this.f4586a);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 17);
        }
    }

    @OnClick({2131364323})
    public void onbusClick() {
        new Thread(new t()).start();
    }

    @OnClick({2131364325})
    public void oncancellationpolicylick() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4569a)) {
            new Handler().postDelayed(new i(), 5000);
        } else {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/REFUND%20RULES%20wef%2012-Nov-15.pdf")));
        }
    }

    @OnClick({2131363533})
    public void onprinClick() {
        ((PrintManager) getActivity().getSystemService("print")).print(getActivity().getString(R.string.app_name) + " Document", new a(), (PrintAttributes) null);
    }

    @OnClick({2131363386})
    public void orderfoodPantryCarClick(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctctourism.com/BookFood/")));
    }

    public final void p() {
        this.rv_addmeal_list.setLayoutManager(new LinearLayoutManager(getContext()));
        Context context = this.f4569a;
        ArrayList<MealItemDetails> arrayList = this.g;
        this.rv_addmeal_list.setAdapter(new MealDetaillViewHolder(context, arrayList, (MealDetaillViewHolder.AddMealHolderListener) null));
        Iterator<MealItemDetails> it = arrayList.iterator();
        double d2 = 0.0d;
        while (it.hasNext()) {
            MealItemDetails next = it.next();
            d2 += (double) (next.getMealRate() * ((float) next.getQuantity()));
        }
        TextView textView = this.total_amount;
        textView.setText(String.valueOf("₹ " + d2));
    }

    public final void q(BookingResponseDTO bookingResponseDTO, String str) {
        ArrayList arrayList = new ArrayList();
        if (bookingResponseDTO.getPsgnDtlList() != null) {
            Iterator<PassengerDetailDTO> it = bookingResponseDTO.getPsgnDtlList().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("TicketErs", bookingResponseDTO);
        bundle.putSerializable("TicketPassenger", arrayList);
        if (str != null && !str.isEmpty()) {
            bundle.putSerializable("connectingTxnId", str);
        }
        ErsDisplayFragment ersDisplayFragment2 = new ErsDisplayFragment();
        ersDisplayFragment2.setArguments(bundle);
        FragmentActivity activity = getActivity();
        String a2 = C1218kf.TicketDetails.a();
        Boolean bool = Boolean.TRUE;
        HomeActivity.n(activity, ersDisplayFragment2, a2, bool, bool);
    }

    public final void r(C0486Dp dp) {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new b(), 5000);
            return;
        }
        C1223kn knVar = C0793b1.a.f3912a;
        if (knVar != null) {
            String l2 = C0657Qt.l();
            ((Om) C0657Qt.c(knVar)).u(l2 + "addPledge", dp).c(C1181iv.a()).a(E0.a()).b(new d());
        }
    }

    @OnClick({2131364791})
    public void updateBoadingPoint() {
        WrapperBoardingStationModel wrapperBoardingStationModel = this.f4575a;
        if (wrapperBoardingStationModel == null) {
            Toast.makeText(getContext(), getString(R.string.select_Boading_station), 0).show();
        } else if (!wrapperBoardingStationModel.f5354a) {
            Toast.makeText(getContext(), getString(R.string.select_Boading_station), 0).show();
        } else if (this.f4577a.getBoardingStn().equals(this.f4595d.trim())) {
            C0535I5.o(getActivity(), getString(R.string.Old_Boarding_station_same_New_Boarding_station), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        } else {
            FragmentActivity activity = getActivity();
            C0535I5.p(activity, false, getString(R.string.process_new_boarding_station) + " " + this.f4571a.m(this.f4595d), getString(R.string.confirm), getString(R.string.confirm), new l(), getString(R.string.cancel), new m()).show();
        }
    }

    public class b implements Runnable {
        public final void run() {
        }
    }

    public class g implements Runnable {
        public final void run() {
        }
    }

    public class i implements Runnable {
        public final void run() {
        }
    }

    public class a extends PrintDocumentAdapter {
        public final void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        }

        public final void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        }
    }
}
