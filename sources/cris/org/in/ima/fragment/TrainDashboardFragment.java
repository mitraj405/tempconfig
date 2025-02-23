package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
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
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.InformationMsgAdapter;
import cris.org.in.ima.adaptors.LastTxnDashbordViewHolder;
import cris.org.in.ima.adaptors.TrainDashboardAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.TrainDashboardImageModel;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.UpcomingJourneyItemHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;
import cris.prs.webservices.dto.InformationMessageDTO;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import rx.Subscriber;

public class TrainDashboardFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f5164a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentManager f5165a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5166a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final c f5167a = new c();

    /* renamed from: a  reason: collision with other field name */
    public d f5168a;

    /* renamed from: a  reason: collision with other field name */
    public final e f5169a = new e();

    /* renamed from: a  reason: collision with other field name */
    public EwalletProfileDTO f5170a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<RecentTransactionsDTO> f5171a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f5172a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5173a = false;
    @BindView(2131361998)
    TextView attention_msg;
    public ArrayList<RecentTransactionsDTO> b = new ArrayList<>();
    @BindView(2131364318)
    TextView bkgStatus;

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList f5174c = new ArrayList();
    @BindView(2131364436)
    TextView informationHeading;
    @BindView(2131363819)
    View information_view;
    @BindView(2131362946)
    RelativeLayout lastTransationDtail;
    @BindView(2131364661)
    TextView lastTransationTimeStamp;
    @BindView(2131362948)
    LinearLayout last_txn_layout;
    @BindView(2131362949)
    RelativeLayout last_txn_ll;
    @BindView(2131363043)
    LinearLayout ll_nolast_txn;
    @BindView(2131363070)
    LinearLayout ll_tab_dashboard;
    @BindView(2131363071)
    LinearLayout ll_tab_last_txn;
    @BindView(2131363072)
    LinearLayout ll_tab_lasttxn_bookingdate;
    @BindView(2131363074)
    LinearLayout ll_tab_lasttxn_date;
    @BindView(2131363075)
    LinearLayout ll_tab_lasttxn_from;
    @BindView(2131363076)
    LinearLayout ll_tab_lasttxn_pnr;
    @BindView(2131363077)
    LinearLayout ll_tab_lasttxn_status;
    @BindView(2131363078)
    LinearLayout ll_tab_lasttxn_to;
    @BindView(2131363079)
    LinearLayout ll_tab_lasttxn_txnid;
    @BindView(2131363081)
    LinearLayout ll_tab_upcoming_journey;
    @BindView(2131363818)
    RecyclerView rv_infomation;
    @BindView(2131363821)
    RecyclerView rv_lasttxn;
    @BindView(2131363834)
    RecyclerView rv_specialtrainlist;
    @BindView(2131363837)
    RecyclerView rv_tab_upcoming_journey_items;
    @BindView(2131363996)
    RelativeLayout specialtrain_list_rl;
    @BindView(2131364192)
    AdManagerAdView trainDashboardAds;
    @BindView(2131364193)
    RecyclerView train_dashboard_image_layout_rv;
    @BindView(2131364694)
    TextView transationNumber;
    @BindView(2131364503)
    TextView tv_no_upcomingjourney;
    @BindView(2131364636)
    TextView tv_tab_lasttxn_pnr_value;
    @BindView(2131364643)
    TextView tv_tab_lasttxn_view_details;
    @BindView(2131364900)
    WebView webView;
    @BindView(2131364902)
    RelativeLayout webView_ll;

    public class a implements InformationMsgAdapter.InformationMsgListener {
        public a() {
        }

        public final void onItemClick(InformationMessageDTO informationMessageDTO) {
            TrainDashboardFragment trainDashboardFragment = TrainDashboardFragment.this;
            if (informationMessageDTO != null && informationMessageDTO.getUrl() != null && informationMessageDTO.getUrl().contains("http")) {
                try {
                    String url = informationMessageDTO.getUrl();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(url));
                    trainDashboardFragment.startActivity(intent);
                } catch (Exception e) {
                    int i = TrainDashboardFragment.c;
                    e.getMessage();
                    C0535I5.t0(trainDashboardFragment.getContext(), trainDashboardFragment.getString(R.string.unable_to_open_link));
                }
            }
        }
    }

    public class b extends Subscriber<C0488Ds> {
        public final /* synthetic */ String c;

        public b(String str) {
            this.c = str;
        }

        public final void onCompleted() {
            TrainDashboardFragment.this.a.dismiss();
        }

        public final void onError(Throwable th) {
            TrainDashboardFragment.this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C0488Ds ds = (C0488Ds) obj;
            String str = this.c;
            TrainDashboardFragment trainDashboardFragment = TrainDashboardFragment.this;
            trainDashboardFragment.a.dismiss();
            if (ds != null) {
                int i = TrainDashboardFragment.c;
                ds.toString();
                ds.getUpcomingjourneyList().toString();
                ds.getLastTxnList().toString();
                if (ds.getErrorMsg() == null) {
                    try {
                        C0535I5.f3615a = ds;
                        if (ds.getUpcomingjourneyList() != null) {
                            trainDashboardFragment.f5171a.clear();
                            ArrayList<RecentTransactionsDTO> upcomingjourneyList = ds.getUpcomingjourneyList();
                            trainDashboardFragment.f5171a = upcomingjourneyList;
                            C0535I5.f3642f = upcomingjourneyList;
                        }
                        if (ds.getLastTxnList() != null) {
                            trainDashboardFragment.b.clear();
                            ArrayList<RecentTransactionsDTO> lastTxnList = ds.getLastTxnList();
                            trainDashboardFragment.b = lastTxnList;
                            C0535I5.f3644g = lastTxnList;
                        }
                        if (str.equalsIgnoreCase("Upcoming Journey")) {
                            if (ds.getUpcomingjourneyInfoMsg() == null || ds.getUpcomingjourneyInfoMsg() == "") {
                                trainDashboardFragment.l();
                                trainDashboardFragment.j(str);
                            } else {
                                C0535I5.p(trainDashboardFragment.getActivity(), false, ds.getUpcomingjourneyInfoMsg(), trainDashboardFragment.getString(R.string.Info), trainDashboardFragment.getString(R.string.ok), new C0(), "", (DialogInterface.OnClickListener) null).show();
                                return;
                            }
                        } else if (str.equalsIgnoreCase("Last Transaction")) {
                            if (ds.getLastTxnListInfoMsg() == null || ds.getLastTxnListInfoMsg() == "") {
                                trainDashboardFragment.k();
                                trainDashboardFragment.j(str);
                            } else {
                                C0535I5.p(trainDashboardFragment.getActivity(), false, ds.getLastTxnListInfoMsg(), trainDashboardFragment.getString(R.string.Info), trainDashboardFragment.getString(R.string.ok), new D0(), "", (DialogInterface.OnClickListener) null).show();
                                return;
                            }
                        }
                    } catch (Exception e) {
                        int i2 = TrainDashboardFragment.c;
                        e.getMessage();
                    }
                    ds.toString();
                    return;
                }
                C0535I5.m(trainDashboardFragment.getActivity(), false, ds.getErrorMsg(), trainDashboardFragment.getString(R.string.error), trainDashboardFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class d implements UpcomingJourneyItemHolder.a {
        public d() {
        }
    }

    public class e implements TrainDashboardAdapter.TrainDashboard {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (C0535I5.R()) {
                    HomeActivity.p();
                    C0535I5.f3652m = false;
                    TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.BOOKINGS;
                    HomeActivity.n((AppCompatActivity) TrainDashboardFragment.this.f5164a, new BookingHistoryFragment(), C1218kf.MY_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
                    return;
                }
                HomeActivity.A(1);
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        public e() {
        }

        public final void onItemClick(TrainDashboardImageModel trainDashboardImageModel) {
            TrainDashboardImageModel trainDashboardImageModel2 = trainDashboardImageModel;
            String str = trainDashboardImageModel2.e;
            TrainDashboardFragment trainDashboardFragment = TrainDashboardFragment.this;
            if (str != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(trainDashboardImageModel2.e));
                trainDashboardFragment.startActivity(intent);
                return;
            }
            String string = trainDashboardFragment.getString(R.string.book);
            String str2 = trainDashboardImageModel2.c;
            if (str2.equalsIgnoreCase(string)) {
                HomeActivity.n(trainDashboardFragment.f5164a, new NewBookingFragment(), C1218kf.NEW_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.my_Bookings))) {
                if (C0535I5.R()) {
                    HomeActivity.p();
                    C0535I5.f3652m = false;
                    TicketHistoryUtil.f5370a = TicketHistoryUtil.SortFor.BOOKINGS;
                    HomeActivity.n((AppCompatActivity) trainDashboardFragment.f5164a, new BookingHistoryFragment(), C1218kf.MY_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
                    return;
                }
                HomeActivity.A(1);
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.pnr_Enquiry))) {
                HomeActivity.p();
                HomeActivity.n((AppCompatActivity) trainDashboardFragment.f5164a, new PnrEnquiryFragment(), C1218kf.PNR_ENQUIRY.a(), Boolean.TRUE, Boolean.FALSE);
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.Last_Transaction))) {
                if (C0535I5.R()) {
                    C0488Ds ds = C0535I5.f3615a;
                    if (ds == null) {
                        trainDashboardFragment.g("Last Transaction");
                    } else if (ds.getLastTxnListInfoMsg() == null || C0535I5.f3615a.getLastTxnListInfoMsg() == "") {
                        ArrayList<RecentTransactionsDTO> arrayList = C0535I5.f3644g;
                        if (arrayList != null && !arrayList.isEmpty() && C0535I5.f3644g.size() > 0) {
                            trainDashboardFragment.b = C0535I5.f3644g;
                            trainDashboardFragment.k();
                            trainDashboardFragment.j("Last Transaction");
                        }
                    } else {
                        C0535I5.p(trainDashboardFragment.getActivity(), false, C0535I5.f3615a.getLastTxnListInfoMsg(), trainDashboardFragment.getString(R.string.Info), trainDashboardFragment.getString(R.string.ok), new C0482DA(), "", (DialogInterface.OnClickListener) null).show();
                    }
                } else {
                    HomeActivity.A(1);
                }
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.upcoming_journey))) {
                if (C0535I5.R()) {
                    C0488Ds ds2 = C0535I5.f3615a;
                    if (ds2 == null) {
                        trainDashboardFragment.g("Upcoming Journey");
                    } else if (ds2.getUpcomingjourneyInfoMsg() == null || C0535I5.f3615a.getUpcomingjourneyInfoMsg() == "") {
                        ArrayList<RecentTransactionsDTO> arrayList2 = C0535I5.f3642f;
                        if (arrayList2 != null && !arrayList2.isEmpty() && C0535I5.f3642f.size() > 0) {
                            trainDashboardFragment.f5171a = C0535I5.f3642f;
                            trainDashboardFragment.l();
                            trainDashboardFragment.j("Upcoming Journey");
                        }
                    } else {
                        C0535I5.p(trainDashboardFragment.getActivity(), false, C0535I5.f3615a.getUpcomingjourneyInfoMsg(), trainDashboardFragment.getString(R.string.Info), trainDashboardFragment.getString(R.string.ok), new C0470CA(), "", (DialogInterface.OnClickListener) null).show();
                    }
                } else {
                    HomeActivity.A(1);
                }
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.cncel_Ticket))) {
                if (C0535I5.R()) {
                    HomeActivity.p();
                    HomeActivity.n((AppCompatActivity) trainDashboardFragment.f5164a, new CancelTktFragment(), C1218kf.CANCEL_TICKET.a(), Boolean.TRUE, Boolean.FALSE);
                    return;
                }
                HomeActivity.A(1);
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.file_TDR))) {
                if (C0535I5.R()) {
                    HomeActivity.p();
                    HomeActivity.n((AppCompatActivity) trainDashboardFragment.f5164a, new TDRTicketFragment(), C1218kf.FILE_TDR.a(), Boolean.TRUE, Boolean.FALSE);
                    return;
                }
                HomeActivity.A(1);
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.ask_Disha))) {
                try {
                    trainDashboardFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://askdisha.irctc.co.in/eticket/#app")));
                } catch (Exception unused) {
                    int i = TrainDashboardFragment.c;
                }
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.delhi_metro))) {
                try {
                    C0535I5.p(trainDashboardFragment.f5164a, false, trainDashboardFragment.getResources().getString(R.string.you_can_book_delhi_metro_ticket), trainDashboardFragment.f5164a.getResources().getString(R.string.Info), trainDashboardFragment.f5164a.getResources().getString(R.string.OK), new a(), trainDashboardFragment.f5164a.getResources().getString(R.string.cancel), new b()).show();
                } catch (Exception unused2) {
                    int i2 = TrainDashboardFragment.c;
                }
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.Refund_History))) {
                if (C0535I5.R()) {
                    HomeActivity.p();
                    HomeActivity.n((AppCompatActivity) trainDashboardFragment.f5164a, new RefundTxnHistoryFragment(), C1218kf.TICKET_REFUND_HISTORY.a(), Boolean.TRUE, Boolean.FALSE);
                    return;
                }
                HomeActivity.A(1);
            } else if (str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.irctc_e_wallet))) {
                if (C0535I5.R()) {
                    EwalletProfileDTO ewalletProfileDTO = trainDashboardFragment.f5170a;
                    if (ewalletProfileDTO == null) {
                        C0494EB eb = C1450w1.f7006a;
                        eb.f3576a = true;
                        int i3 = eb.a;
                        if ((i3 == 0 || i3 == 1) && ewalletProfileDTO == null) {
                            ProgressDialog show = ProgressDialog.show(trainDashboardFragment.getActivity(), trainDashboardFragment.getString(R.string.loading), trainDashboardFragment.getString(R.string.please_wait_text));
                            String g = C0657Qt.g();
                            ((Om) C0657Qt.c(C0793b1.a.f3912a)).a0(g + "ewalletRegisterNow").c(C1181iv.a()).a(E0.a()).b(new C0458BA(trainDashboardFragment, show));
                        }
                    }
                    C0494EB eb2 = C1450w1.f7006a;
                    eb2.f3576a = true;
                    int i4 = eb2.a;
                    if (i4 == 0 || i4 == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("ewalletProfileDTO", trainDashboardFragment.f5170a);
                        AadhaarKYCFragment aadhaarKYCFragment = new AadhaarKYCFragment();
                        aadhaarKYCFragment.setArguments(bundle);
                        bundle.putString("type", "ewallet");
                        aadhaarKYCFragment.setArguments(bundle);
                        HomeActivity.n((AppCompatActivity) trainDashboardFragment.getActivity(), aadhaarKYCFragment, C1218kf.AADHAARPANKYC.a(), Boolean.TRUE, Boolean.FALSE);
                        FragmentManager fragmentManager = trainDashboardFragment.f5165a;
                        fragmentManager.getClass();
                        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
                        aVar.n(trainDashboardFragment);
                        aVar.c();
                    } else if (i4 >= 2) {
                        HomeActivity.B(trainDashboardFragment.getActivity());
                        HomeActivity.n((AppCompatActivity) trainDashboardFragment.getActivity(), new EwalletStatementFragment(), C1218kf.EWALLET_STMT.a(), Boolean.TRUE, Boolean.FALSE);
                    }
                } else {
                    HomeActivity.A(1);
                }
            } else if (!str2.equalsIgnoreCase(trainDashboardFragment.getString(R.string.train_schedule))) {
            } else {
                if (!C0535I5.M() || C0535I5.R()) {
                    HomeActivity.n((AppCompatActivity) trainDashboardFragment.getContext(), new TrainScheduleFragment(), trainDashboardFragment.getString(R.string.train_schedule), Boolean.TRUE, Boolean.FALSE);
                } else if (C1450w1.f7005a == 2) {
                    HomeActivity.A(2);
                } else {
                    HomeActivity.A(1);
                }
            }
        }
    }

    static {
        C1354qp.R(TrainDashboardFragment.class);
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
                C0535I5.t0(this.f5164a, getResources().getString(R.string.unble_toconnect_server));
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
            this.f5173a = true;
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    public final void g(String str) {
        this.a = ProgressDialog.show(getActivity(), getString(R.string.fetching_details_dashboard), getString(R.string.please_wait_text));
        if (C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            try {
                C0793b1 b1Var = C0793b1.a;
                if (b1Var.f3912a != null) {
                    this.a.show();
                    String f = C0657Qt.f();
                    ((Om) C0657Qt.c(b1Var.f3912a)).R(f + "recentTxnsDetails").c(C1181iv.a()).a(E0.a()).b(new b(str));
                }
            } catch (Exception e2) {
                e2.getMessage();
                this.a.dismiss();
                C0535I5.t0(getActivity(), getString(R.string.please_try_again));
            }
        }
    }

    public final void h(String str, String str2, String str3, String str4, String str5) {
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
                C0535I5.t0(this.f5164a, getResources().getString(R.string.unble_toconnect_server));
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
            this.f5173a = true;
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    public final boolean i() {
        if (this.ll_tab_upcoming_journey.getVisibility() != 0 && this.ll_tab_last_txn.getVisibility() != 0) {
            return false;
        }
        this.ll_tab_upcoming_journey.setVisibility(8);
        this.ll_tab_last_txn.setVisibility(8);
        this.ll_tab_dashboard.setVisibility(0);
        HomeActivity.F(C1218kf.TRAIN.a());
        return true;
    }

    public final void j(String str) {
        str.getClass();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -78850884:
                if (str.equals("Upcoming Journey")) {
                    c2 = 0;
                    break;
                }
                break;
            case 956107380:
                if (str.equals("Dashboard")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1722862676:
                if (str.equals("Last Transaction")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.ll_tab_dashboard.setVisibility(8);
                this.ll_tab_upcoming_journey.setVisibility(0);
                HomeActivity.F(C1218kf.upcomingjourney.a());
                this.ll_tab_last_txn.setVisibility(8);
                return;
            case 1:
                this.ll_tab_dashboard.setVisibility(0);
                this.ll_tab_upcoming_journey.setVisibility(8);
                this.ll_tab_last_txn.setVisibility(8);
                return;
            case 2:
                this.ll_tab_dashboard.setVisibility(8);
                this.ll_tab_upcoming_journey.setVisibility(8);
                this.ll_tab_last_txn.setVisibility(0);
                HomeActivity.F(C1218kf.LAST_TXN.a());
                return;
            default:
                return;
        }
    }

    public final void k() {
        ArrayList<RecentTransactionsDTO> arrayList = this.b;
        if (arrayList == null || arrayList.size() <= 0) {
            this.ll_tab_lasttxn_date.setVisibility(8);
            this.tv_tab_lasttxn_view_details.setVisibility(8);
            this.ll_tab_lasttxn_pnr.setVisibility(8);
            this.ll_tab_lasttxn_txnid.setVisibility(8);
            this.ll_tab_lasttxn_status.setVisibility(8);
            this.ll_tab_lasttxn_bookingdate.setVisibility(8);
            this.ll_tab_lasttxn_from.setVisibility(8);
            this.ll_tab_lasttxn_to.setVisibility(8);
            this.tv_tab_lasttxn_pnr_value.setVisibility(8);
            this.ll_nolast_txn.setVisibility(0);
        } else {
            this.ll_nolast_txn.setVisibility(8);
            this.ll_tab_lasttxn_date.setVisibility(0);
            this.tv_tab_lasttxn_view_details.setVisibility(0);
            this.ll_tab_lasttxn_pnr.setVisibility(0);
            this.ll_tab_lasttxn_txnid.setVisibility(0);
            this.ll_tab_lasttxn_status.setVisibility(0);
            this.ll_tab_lasttxn_bookingdate.setVisibility(0);
            this.ll_tab_lasttxn_from.setVisibility(0);
            this.ll_tab_lasttxn_to.setVisibility(0);
            this.tv_tab_lasttxn_pnr_value.setVisibility(0);
        }
        this.rv_lasttxn.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_lasttxn.setAdapter(new LastTxnDashbordViewHolder(this.f5164a, this.b, this.f5167a));
    }

    public final void l() {
        ArrayList<RecentTransactionsDTO> arrayList = this.f5171a;
        if (arrayList == null || arrayList.size() <= 0) {
            this.rv_tab_upcoming_journey_items.setVisibility(8);
            this.tv_no_upcomingjourney.setVisibility(0);
            return;
        }
        this.rv_tab_upcoming_journey_items.setVisibility(0);
        this.tv_no_upcomingjourney.setVisibility(8);
        this.rv_tab_upcoming_journey_items.setAdapter(new UpcomingJourneyItemHolder(this.f5171a, this.f5168a));
        this.rv_tab_upcoming_journey_items.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick({2131362946})
    public void onClickTransationView(View view) {
        if (this.lastTransationDtail.getVisibility() == 8) {
            this.lastTransationDtail.setVisibility(0);
        } else {
            this.lastTransationDtail.setVisibility(8);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.train_dashboard, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        this.f5164a = getContext();
        this.f5165a = getFragmentManager();
        this.lastTransationDtail.setOnClickListener(new C1019e(this, 1));
        AlertDialog alertDialog = C0535I5.f3619a;
        this.attention_msg.setVisibility(8);
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.trainDashboardAds, googleAdParamDTO);
        ArrayList arrayList = this.f5174c;
        arrayList.clear();
        Iterator<InformationMessageDTO> it = C1450w1.f7010a.iterator();
        while (it.hasNext()) {
            InformationMessageDTO next = it.next();
            if (next.getParamName().equalsIgnoreCase("TRAIN_SEARCH")) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            this.informationHeading.setVisibility(8);
            this.rv_infomation.setVisibility(8);
            this.information_view.setVisibility(8);
        }
        this.rv_infomation.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.rv_infomation.setAdapter(new InformationMsgAdapter(this.f5164a, arrayList, this.f5166a));
        HomeActivity.z();
        HomeActivity.o();
        HomeActivity.x();
        HomeActivity.J();
        this.f5168a = new d();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.book), String.valueOf(R.drawable.book_ticket), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.my_Bookings), String.valueOf(R.drawable.my_booking), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.pnr_Enquiry), String.valueOf(R.drawable.pnr_enquiry), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.Last_Transaction), String.valueOf(R.drawable.last_transaction_home), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.upcoming_journey), String.valueOf(R.drawable.upcoming_journey), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.cncel_Ticket), String.valueOf(R.drawable.file_tdr), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.file_TDR), String.valueOf(R.drawable.cancel_ticket), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.Refund_History), String.valueOf(R.drawable.refund_history), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.faq), String.valueOf(R.drawable.faq), "https://contents.irctc.co.in/en/FAQ.pdf"));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.irctc_e_wallet), String.valueOf(R.drawable.about_ewallet), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.Chart_Vacancy), String.valueOf(R.drawable.chart_vacancy5), "https://www.irctc.co.in/online-charts/"));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.train_schedule), String.valueOf(R.drawable.route_icon5), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.track_your_train), String.valueOf(R.drawable.track_your_train), "https://enquiry.indianrail.gov.in/ntes/index.html"));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.ask_Disha), String.valueOf(R.drawable.askdishanew), (String) null));
        arrayList2.add(new TrainDashboardImageModel(getString(R.string.delhi_metro), String.valueOf(R.drawable.dmrc_icon), (String) null));
        this.train_dashboard_image_layout_rv.setLayoutManager(new GridLayoutManager(this.f5164a));
        this.train_dashboard_image_layout_rv.setAdapter(new TrainDashboardAdapter(this.f5164a, arrayList2, this.f5169a));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setUseWideViewPort(true);
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new E0(this));
        this.webView.setOnTouchListener(new C0447AA(this));
        this.webView.loadUrl("https://contents.irctc.co.in/en/TopDeal_1071x200.jpeg");
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
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
        if (C0535I5.R()) {
            if (C0535I5.f3630b) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Long l = C0535I5.f3616a.f3653a;
                Boolean bool = C0535I5.f3616a.a;
                if (bool == null || !bool.booleanValue()) {
                    C0535I5.f3616a.a = Boolean.FALSE;
                } else {
                    this.lastTransationDtail.setVisibility(0);
                    this.last_txn_layout.setVisibility(0);
                    this.last_txn_ll.setVisibility(0);
                    this.transationNumber.setText(String.valueOf(C0535I5.f3616a.f3653a));
                    this.bkgStatus.setText(String.valueOf(C0535I5.f3616a.f3654a));
                    String[] split = String.valueOf(simpleDateFormat.format(C0535I5.f3616a.f3655a)).split(" ");
                    TextView textView = this.lastTransationTimeStamp;
                    textView.setText(split[0] + "," + split[1] + "Hrs");
                    C0535I5.f3630b = false;
                }
            }
            HomeActivity.p();
            return;
        }
        HomeActivity.I();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131363996})
    public void specialtrainListClick() {
        if (this.specialtrain_list_rl.getVisibility() == 0) {
            this.specialtrain_list_rl.setVisibility(8);
        } else {
            this.specialtrain_list_rl.setVisibility(0);
        }
    }

    public class c implements LastTxnDashbordViewHolder.LasttxnrHolderListener {
        public final void onViewDetailClick(RecentTransactionsDTO recentTransactionsDTO, Integer num) {
        }
    }
}
