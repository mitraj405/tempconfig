package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.LastYearCnfTrendActivity;
import cris.org.in.ima.adaptors.FavoritepnrAdaptor;
import cris.org.in.ima.adaptors.TrainListViewHolder;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.model.PnrModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import rx.Subscriber;

public class PnrEnquiryFragment extends Fragment {
    public static InterstitialAd a;

    /* renamed from: a  reason: collision with other field name */
    public Context f5033a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5034a;

    /* renamed from: a  reason: collision with other field name */
    public FavoritepnrAdaptor f5035a;

    /* renamed from: a  reason: collision with other field name */
    public StationDb f5036a = null;

    /* renamed from: a  reason: collision with other field name */
    public final GoogleAdParamDTO f5037a = new GoogleAdParamDTO();

    /* renamed from: a  reason: collision with other field name */
    public final d f5038a = new d();

    /* renamed from: a  reason: collision with other field name */
    public PassengerDetailDTO f5039a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<PnrModel> f5040a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public Date f5041a = null;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5042a = false;
    public String c = null;
    @BindView(2131362263)
    LinearLayout cnfBtnLayout;
    @BindView(2131362264)
    TextView cnfCheckCetails;
    @BindView(2131362403)
    TextView destArrDate;
    @BindView(2131362404)
    TextView destArrTime;
    @BindView(2131364404)
    ImageView favIconImage;
    @BindView(2131364402)
    RecyclerView favPnrList;
    @BindView(2131362715)
    TextView fromStation;
    @BindView(2131362925)
    TextView journeyTime;
    @BindView(2131362920)
    TextView jrnyDate;
    @BindView(2131363019)
    LinearLayout ll_delay_msg;
    @BindView(2131363020)
    LinearLayout ll_delay_value;
    @BindView(2131363511)
    AdManagerAdView pnrEquiryBottom;
    @BindView(2131363513)
    AdManagerAdView pnrEquiryTop;
    @BindView(2131363506)
    TextView pnrNumber;
    @BindView(2131363512)
    AdManagerAdView pnrResultTop;
    @BindView(2131364532)
    EditText pnr_view;
    @BindView(2131363527)
    TextView pre;
    @BindView(2131363556)
    RecyclerView psgnList;
    @BindView(2131364541)
    LinearLayout psgn_layout;
    @BindView(2131363673)
    RelativeLayout remarks_rl;
    @BindView(2131363674)
    TextView remarks_tv;
    @BindView(2131364534)
    LinearLayout selectFavPnr;
    @BindView(2131364139)
    LinearLayout ticketfare;
    @BindView(2131364156)
    TextView tktDetails;
    @BindView(2131364169)
    TextView toStation;
    @BindView(2131364184)
    TextView total_fare;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364203)
    TextView trainNumber;
    @BindView(2131364248)
    LinearLayout travelTimeLL;
    @BindView(2131364337)
    TextView tv_chart_status;
    @BindView(2131364358)
    TextView tv_delay_msg;
    @BindView(2131364359)
    TextView tv_delay_value;
    @BindView(2131364440)
    TextView tv_ir_recovers;

    public class a implements View.OnClickListener {
        public final /* synthetic */ TextView a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ PnrEnquiryResponseDTO f5044a;

        public a(PnrEnquiryResponseDTO pnrEnquiryResponseDTO, TextView textView) {
            this.f5044a = pnrEnquiryResponseDTO;
            this.a = textView;
        }

        public final void onClick(View view) {
            PnrEnquiryFragment pnrEnquiryFragment = PnrEnquiryFragment.this;
            LinearLayout linearLayout = pnrEnquiryFragment.cnfBtnLayout;
            Context context = pnrEnquiryFragment.f5033a;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            new SimpleDateFormat("dd-MM-yyyy");
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            KD kd = new KD();
            PnrEnquiryResponseDTO pnrEnquiryResponseDTO = this.f5044a;
            kd.setBookingDate(pnrEnquiryResponseDTO.getBookingDate());
            kd.setTrainNumber(pnrEnquiryResponseDTO.getTrainNumber());
            kd.setCurrentStatus(TrainListViewHolder.getWlStatus(pnrEnquiryFragment.f5039a.getCurrentStatus()));
            kd.setCurrentStatusNumber(Integer.valueOf(TrainListViewHolder.getWlStatusNumber(pnrEnquiryFragment.f5039a.getCurrentStatusDetails())));
            kd.setFromStnCode(pnrEnquiryResponseDTO.getSourceStation());
            kd.setToStnCode(pnrEnquiryResponseDTO.getDestinationStation());
            kd.setJourneyClass(pnrEnquiryResponseDTO.getJourneyClass());
            kd.setJourneyDate(simpleDateFormat.format(pnrEnquiryResponseDTO.getDateOfJourney()));
            kd.setQuota(pnrEnquiryResponseDTO.getQuota());
            kd.setRunningStatus(TrainListViewHolder.getWlStatus(pnrEnquiryFragment.f5039a.getBookingStatus()));
            kd.setRunningStatusNumber(Integer.valueOf(TrainListViewHolder.getWlStatusNumber(pnrEnquiryFragment.f5039a.getBookingStatusDetails())));
            kd.setSiteId(pnrEnquiryResponseDTO.getTrainSiteId());
            kd.setWlType(Integer.valueOf(pnrEnquiryFragment.f5039a.getPsgnwlType()));
            C0535I5.f3626b = "pnrEnquiry";
            C0535I5.f0(kd, this.a, pnrEnquiryFragment.cnfCheckCetails, context);
            pnrEnquiryFragment.pre.setEnabled(true);
        }
    }

    public class c extends Subscriber<PnrEnquiryResponseDTO> {
        public final /* synthetic */ ProgressDialog a;

        public c(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        /* JADX WARNING: Removed duplicated region for block: B:112:0x0524 A[Catch:{ Exception -> 0x056f, all -> 0x056c }] */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x0564 A[Catch:{ Exception -> 0x056f, all -> 0x056c }] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0438 A[SYNTHETIC, Splitter:B:77:0x0438] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x04b3 A[Catch:{ Exception -> 0x056f, all -> 0x056c }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x04c2 A[SYNTHETIC, Splitter:B:95:0x04c2] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(cris.prs.webservices.dto.PnrEnquiryResponseDTO r21) {
            /*
                r20 = this;
                r1 = r21
                java.lang.String r2 = "RAC"
                java.lang.String r3 = "CNF"
                java.lang.String r4 = "-"
                java.lang.String r5 = " ("
                java.lang.String r6 = ")"
                java.lang.String r7 = "("
                if (r1 == 0) goto L_0x0578
                com.fasterxml.jackson.databind.ObjectMapper r8 = defpackage.C0657Qt.h()
                java.lang.String r9 = r21.getErrorMessage()     // Catch:{ Exception -> 0x056f }
                r10 = 8
                r11 = 0
                r12 = r20
                cris.org.in.ima.fragment.PnrEnquiryFragment r13 = cris.org.in.ima.fragment.PnrEnquiryFragment.this
                if (r9 == 0) goto L_0x0069
                android.widget.LinearLayout r2 = r13.psgn_layout     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                androidx.recyclerview.widget.RecyclerView r2 = r13.psgnList     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r21.getErrorMessage()     // Catch:{ Exception -> 0x056f }
                r2.split(r4)     // Catch:{ Exception -> 0x056f }
                androidx.fragment.app.FragmentActivity r14 = r13.getActivity()     // Catch:{ Exception -> 0x056f }
                r15 = 1
                java.lang.String r1 = r21.getErrorMessage()     // Catch:{ Exception -> 0x056f }
                java.lang.String[] r1 = r1.split(r4)     // Catch:{ Exception -> 0x056f }
                r16 = r1[r11]     // Catch:{ Exception -> 0x056f }
                r1 = 2131952688(0x7f130430, float:1.9541826E38)
                java.lang.String r17 = r13.getString(r1)     // Catch:{ Exception -> 0x056f }
                r1 = 2131951928(0x7f130138, float:1.9540284E38)
                java.lang.String r18 = r13.getString(r1)     // Catch:{ Exception -> 0x056f }
                r19 = 0
                android.app.AlertDialog r1 = defpackage.C0535I5.m(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x056f }
                r1.show()     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r1 = r13.pre     // Catch:{ Exception -> 0x056f }
                r1.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r1 = r13.cnfCheckCetails     // Catch:{ Exception -> 0x056f }
                r1.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                android.widget.LinearLayout r1 = r13.ticketfare     // Catch:{ Exception -> 0x056f }
                r1.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                goto L_0x0578
            L_0x0069:
                android.widget.LinearLayout r4 = r13.psgn_layout     // Catch:{ Exception -> 0x056f }
                cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r9 = r13.f5037a
                r4.setVisibility(r11)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r21.getSourceStation()     // Catch:{ Exception -> 0x056f }
                r9.setSource(r4)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r21.getDestinationStation()     // Catch:{ Exception -> 0x056f }
                r9.setDestination(r4)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r21.getQuota()     // Catch:{ Exception -> 0x056f }
                r9.setQuata(r4)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r21.getJourneyClass()     // Catch:{ Exception -> 0x056f }
                r9.setjClass(r4)     // Catch:{ Exception -> 0x056f }
                java.util.Date r4 = r21.getDateOfJourney()     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = defpackage.C0535I5.x(r4)     // Catch:{ Exception -> 0x056f }
                r9.setDepartureDate(r4)     // Catch:{ Exception -> 0x056f }
                java.util.ArrayList r4 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                java.lang.Object r4 = r4.get(r11)     // Catch:{ Exception -> 0x056f }
                cris.prs.webservices.dto.PassengerDetailDTO r4 = (cris.prs.webservices.dto.PassengerDetailDTO) r4     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r4.getCurrentStatus()     // Catch:{ Exception -> 0x056f }
                boolean r4 = r4.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r14 = "WL"
                if (r4 == 0) goto L_0x00b1
                r9.setTicketStatus(r3)     // Catch:{ Exception -> 0x056f }
                goto L_0x00cc
            L_0x00b1:
                java.util.ArrayList r3 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                java.lang.Object r3 = r3.get(r11)     // Catch:{ Exception -> 0x056f }
                cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r3.getCurrentStatus()     // Catch:{ Exception -> 0x056f }
                boolean r3 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x056f }
                if (r3 == 0) goto L_0x00c9
                r9.setTicketStatus(r2)     // Catch:{ Exception -> 0x056f }
                goto L_0x00cc
            L_0x00c9:
                r9.setTicketStatus(r14)     // Catch:{ Exception -> 0x056f }
            L_0x00cc:
                androidx.fragment.app.FragmentActivity r2 = r13.getActivity()     // Catch:{ Exception -> 0x056f }
                com.google.android.gms.ads.admanager.AdManagerAdView r3 = r13.pnrResultTop     // Catch:{ Exception -> 0x056f }
                defpackage.C0535I5.Y(r2, r3, r9)     // Catch:{ Exception -> 0x056f }
                com.google.android.gms.ads.admanager.AdManagerAdView r2 = r13.pnrEquiryBottom     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                androidx.recyclerview.widget.RecyclerView r2 = r13.psgnList     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r11)     // Catch:{ Exception -> 0x056f }
                r8.writeValueAsString(r1)     // Catch:{ Exception -> 0x056f }
                com.google.android.gms.ads.interstitial.InterstitialAd r2 = cris.org.in.ima.fragment.PnrEnquiryFragment.a     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r21.getPnrNumber()     // Catch:{ Exception -> 0x056f }
                r13.c = r2     // Catch:{ Exception -> 0x056f }
                java.util.Date r2 = r21.getDateOfJourney()     // Catch:{ Exception -> 0x056f }
                r13.f5041a = r2     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.pnrNumber     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r21.getPnrNumber()     // Catch:{ Exception -> 0x056f }
                r2.setText(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r21.getTrainName()     // Catch:{ Exception -> 0x056f }
                defpackage.C0535I5.q0(r2)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.trainNumber     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r3.<init>(r7)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r21.getTrainNumber()     // Catch:{ Exception -> 0x056f }
                r3.append(r4)     // Catch:{ Exception -> 0x056f }
                r3.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x056f }
                r2.setText(r3)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.trainName     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r21.getTrainName()     // Catch:{ Exception -> 0x056f }
                r2.setText(r3)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.fromStation     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r3.<init>()     // Catch:{ Exception -> 0x056f }
                cris.org.in.ima.db.StationDb r4 = r13.f5036a     // Catch:{ Exception -> 0x056f }
                java.lang.String r8 = r21.getBoardingPoint()     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r4.m(r8)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = defpackage.C0535I5.s0(r4)     // Catch:{ Exception -> 0x056f }
                r3.append(r4)     // Catch:{ Exception -> 0x056f }
                r3.append(r5)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r21.getBoardingPoint()     // Catch:{ Exception -> 0x056f }
                r3.append(r4)     // Catch:{ Exception -> 0x056f }
                r3.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x056f }
                r2.setText(r3)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.toStation     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r3.<init>()     // Catch:{ Exception -> 0x056f }
                cris.org.in.ima.db.StationDb r4 = r13.f5036a     // Catch:{ Exception -> 0x056f }
                java.lang.String r8 = r21.getDestinationStation()     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r4.m(r8)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = defpackage.C0535I5.s0(r4)     // Catch:{ Exception -> 0x056f }
                r3.append(r4)     // Catch:{ Exception -> 0x056f }
                r3.append(r5)     // Catch:{ Exception -> 0x056f }
                java.lang.String r4 = r21.getDestinationStation()     // Catch:{ Exception -> 0x056f }
                r3.append(r4)     // Catch:{ Exception -> 0x056f }
                r3.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x056f }
                r2.setText(r3)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.destArrDate     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.destArrTime     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.journeyTime     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                android.widget.LinearLayout r2 = r13.travelTimeLL     // Catch:{ Exception -> 0x056f }
                r2.setVisibility(r10)     // Catch:{ Exception -> 0x056f }
                java.util.ArrayList r2 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x056f }
            L_0x0197:
                boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x056f }
                if (r3 == 0) goto L_0x01b5
                java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x056f }
                cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3     // Catch:{ Exception -> 0x056f }
                java.lang.Short r4 = r3.getPassengerAge()     // Catch:{ Exception -> 0x056f }
                short r4 = r4.shortValue()     // Catch:{ Exception -> 0x056f }
                if (r4 < 0) goto L_0x0197
                java.lang.Short r3 = r3.getPassengerAge()     // Catch:{ Exception -> 0x056f }
                r3.shortValue()     // Catch:{ Exception -> 0x056f }
                goto L_0x0197
            L_0x01b5:
                java.lang.String r2 = r21.getJourneyClass()     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = " | "
                java.lang.String r4 = ""
                if (r2 == 0) goto L_0x01fb
                java.lang.String r2 = r21.getJourneyClass()     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = defpackage.xx.e(r2)     // Catch:{ Exception -> 0x056f }
                if (r2 == 0) goto L_0x01e4
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r2.<init>()     // Catch:{ Exception -> 0x056f }
                r2.append(r4)     // Catch:{ Exception -> 0x056f }
                r2.append(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r8 = r21.getJourneyClass()     // Catch:{ Exception -> 0x056f }
                java.lang.String r8 = defpackage.xx.e(r8)     // Catch:{ Exception -> 0x056f }
                r2.append(r8)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x056f }
                goto L_0x01fc
            L_0x01e4:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r2.<init>()     // Catch:{ Exception -> 0x056f }
                r2.append(r4)     // Catch:{ Exception -> 0x056f }
                r2.append(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r8 = r21.getJourneyClass()     // Catch:{ Exception -> 0x056f }
                r2.append(r8)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x056f }
                goto L_0x01fc
            L_0x01fb:
                r2 = r4
            L_0x01fc:
                java.lang.String r8 = r21.getQuota()     // Catch:{ Exception -> 0x056f }
                H9 r8 = defpackage.H9.f(r8)     // Catch:{ Exception -> 0x056f }
                java.lang.String r9 = ") "
                java.lang.String r10 = "  "
                java.lang.String r11 = " "
                if (r8 != 0) goto L_0x027e
                android.widget.TextView r8 = r13.tktDetails     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r15.<init>()     // Catch:{ Exception -> 0x056f }
                java.util.ArrayList r16 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                int r12 = r16.size()     // Catch:{ Exception -> 0x056f }
                r15.append(r12)     // Catch:{ Exception -> 0x056f }
                r15.append(r11)     // Catch:{ Exception -> 0x056f }
                r12 = 2131952264(0x7f130288, float:1.9540966E38)
                java.lang.String r12 = r13.getString(r12)     // Catch:{ Exception -> 0x056f }
                r15.append(r12)     // Catch:{ Exception -> 0x056f }
                r15.append(r10)     // Catch:{ Exception -> 0x056f }
                r10 = 2131952451(0x7f130343, float:1.9541345E38)
                java.lang.String r10 = r13.getString(r10)     // Catch:{ Exception -> 0x056f }
                r15.append(r10)     // Catch:{ Exception -> 0x056f }
                r15.append(r11)     // Catch:{ Exception -> 0x056f }
                r15.append(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r10 = r21.getQuota()     // Catch:{ Exception -> 0x056f }
                r15.append(r10)     // Catch:{ Exception -> 0x056f }
                r15.append(r2)     // Catch:{ Exception -> 0x056f }
                r15.append(r7)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r21.getJourneyClass()     // Catch:{ Exception -> 0x056f }
                r15.append(r2)     // Catch:{ Exception -> 0x056f }
                r15.append(r6)     // Catch:{ Exception -> 0x056f }
                r15.append(r3)     // Catch:{ Exception -> 0x056f }
                cris.org.in.ima.db.StationDb r2 = r13.f5036a     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r21.getSourceStation()     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r2.m(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = defpackage.C0535I5.s0(r2)     // Catch:{ Exception -> 0x056f }
                r15.append(r2)     // Catch:{ Exception -> 0x056f }
                r15.append(r5)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r21.getSourceStation()     // Catch:{ Exception -> 0x056f }
                r15.append(r2)     // Catch:{ Exception -> 0x056f }
                r15.append(r9)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r15.toString()     // Catch:{ Exception -> 0x056f }
                r8.setText(r2)     // Catch:{ Exception -> 0x056f }
                goto L_0x02f7
            L_0x027e:
                android.widget.TextView r8 = r13.tktDetails     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r12.<init>()     // Catch:{ Exception -> 0x056f }
                java.util.ArrayList r15 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                int r15 = r15.size()     // Catch:{ Exception -> 0x056f }
                r12.append(r15)     // Catch:{ Exception -> 0x056f }
                r12.append(r11)     // Catch:{ Exception -> 0x056f }
                r15 = 2131952264(0x7f130288, float:1.9540966E38)
                java.lang.String r15 = r13.getString(r15)     // Catch:{ Exception -> 0x056f }
                r12.append(r15)     // Catch:{ Exception -> 0x056f }
                r12.append(r10)     // Catch:{ Exception -> 0x056f }
                r10 = 2131952451(0x7f130343, float:1.9541345E38)
                java.lang.String r10 = r13.getString(r10)     // Catch:{ Exception -> 0x056f }
                r12.append(r10)     // Catch:{ Exception -> 0x056f }
                r12.append(r11)     // Catch:{ Exception -> 0x056f }
                r12.append(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r10 = r21.getQuota()     // Catch:{ Exception -> 0x056f }
                H9 r10 = defpackage.H9.f(r10)     // Catch:{ Exception -> 0x056f }
                java.lang.String r10 = r10.a()     // Catch:{ Exception -> 0x056f }
                r12.append(r10)     // Catch:{ Exception -> 0x056f }
                r12.append(r2)     // Catch:{ Exception -> 0x056f }
                r12.append(r7)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r21.getJourneyClass()     // Catch:{ Exception -> 0x056f }
                r12.append(r2)     // Catch:{ Exception -> 0x056f }
                r12.append(r6)     // Catch:{ Exception -> 0x056f }
                r12.append(r3)     // Catch:{ Exception -> 0x056f }
                cris.org.in.ima.db.StationDb r2 = r13.f5036a     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r21.getSourceStation()     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r2.m(r3)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = defpackage.C0535I5.s0(r2)     // Catch:{ Exception -> 0x056f }
                r12.append(r2)     // Catch:{ Exception -> 0x056f }
                r12.append(r5)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r21.getSourceStation()     // Catch:{ Exception -> 0x056f }
                r12.append(r2)     // Catch:{ Exception -> 0x056f }
                r12.append(r9)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r12.toString()     // Catch:{ Exception -> 0x056f }
                r8.setText(r2)     // Catch:{ Exception -> 0x056f }
            L_0x02f7:
                android.widget.LinearLayout r2 = r13.ticketfare     // Catch:{ Exception -> 0x056f }
                r3 = 0
                r2.setVisibility(r3)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.total_fare     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r3.<init>()     // Catch:{ Exception -> 0x056f }
                java.lang.Integer r5 = r21.getTicketFare()     // Catch:{ Exception -> 0x056f }
                r3.append(r5)     // Catch:{ Exception -> 0x056f }
                r3.append(r4)     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x056f }
                r2.setText(r3)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.tv_chart_status     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = r21.getChartStatus()     // Catch:{ Exception -> 0x056f }
                r2.setText(r3)     // Catch:{ Exception -> 0x056f }
                java.util.ArrayList r2 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x056f }
            L_0x0326:
                boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x056f }
                if (r3 == 0) goto L_0x034b
                java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x056f }
                cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r5.<init>()     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = "Passenger "
                r5.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.Short r6 = r3.getPassengerSerialNumber()     // Catch:{ Exception -> 0x056f }
                r5.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x056f }
                r3.setPassengerName(r5)     // Catch:{ Exception -> 0x056f }
                goto L_0x0326
            L_0x034b:
                java.util.ArrayList r2 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x056f }
            L_0x0353:
                boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x056f }
                if (r3 == 0) goto L_0x0395
                java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x056f }
                cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3     // Catch:{ Exception -> 0x056f }
                java.lang.String r5 = r3.getCurrentStatus()     // Catch:{ Exception -> 0x056f }
                boolean r5 = r5.contains(r14)     // Catch:{ Exception -> 0x056f }
                if (r5 == 0) goto L_0x0388
                java.lang.String r5 = r21.getChartStatus()     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = "Chart Not Prepared"
                boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x056f }
                if (r5 == 0) goto L_0x0388
                android.widget.LinearLayout r5 = r13.cnfBtnLayout     // Catch:{ Exception -> 0x056f }
                r6 = 0
                r5.setVisibility(r6)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r5 = r13.pre     // Catch:{ Exception -> 0x056f }
                r5.setVisibility(r6)     // Catch:{ Exception -> 0x056f }
                r13.f5039a = r3     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r3 = r13.pre     // Catch:{ Exception -> 0x056f }
                r13.k(r1, r3)     // Catch:{ Exception -> 0x056f }
                goto L_0x0353
            L_0x0388:
                android.widget.LinearLayout r3 = r13.cnfBtnLayout     // Catch:{ Exception -> 0x056f }
                r5 = 8
                r3.setVisibility(r5)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r3 = r13.pre     // Catch:{ Exception -> 0x056f }
                r3.setVisibility(r5)     // Catch:{ Exception -> 0x056f }
                goto L_0x0353
            L_0x0395:
                androidx.recyclerview.widget.RecyclerView r2 = r13.psgnList     // Catch:{ Exception -> 0x056f }
                androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x056f }
                android.content.Context r5 = r13.getContext()     // Catch:{ Exception -> 0x056f }
                r3.<init>(r5)     // Catch:{ Exception -> 0x056f }
                r2.setLayoutManager(r3)     // Catch:{ Exception -> 0x056f }
                cris.org.in.ima.view_holder.PassangerViewHolder r2 = new cris.org.in.ima.view_holder.PassangerViewHolder     // Catch:{ Exception -> 0x056f }
                android.content.Context r3 = r13.f5033a     // Catch:{ Exception -> 0x056f }
                java.util.ArrayList r5 = r21.getPassengerList()     // Catch:{ Exception -> 0x056f }
                r2.<init>(r3, r5)     // Catch:{ Exception -> 0x056f }
                r13.getClass()     // Catch:{ Exception -> 0x056f }
                androidx.recyclerview.widget.RecyclerView r3 = r13.psgnList     // Catch:{ Exception -> 0x056f }
                r3.setAdapter(r2)     // Catch:{ Exception -> 0x056f }
                android.text.SpannableString r2 = new android.text.SpannableString     // Catch:{ Exception -> 0x056f }
                java.util.Date r3 = r21.getDateOfJourney()     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = defpackage.C0535I5.U(r3)     // Catch:{ Exception -> 0x056f }
                r2.<init>(r3)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r3 = r13.jrnyDate     // Catch:{ Exception -> 0x056f }
                r3.setText(r2)     // Catch:{ Exception -> 0x056f }
                java.lang.String[] r2 = r21.getInformationMessage()     // Catch:{ Exception -> 0x056f }
                if (r2 == 0) goto L_0x03fb
                int r3 = r2.length     // Catch:{ Exception -> 0x056f }
                r5 = 0
                r6 = r4
            L_0x03d3:
                if (r5 >= r3) goto L_0x03fc
                r7 = r2[r5]     // Catch:{ Exception -> 0x056f }
                if (r7 == 0) goto L_0x03fc
                java.lang.String r8 = r7.trim()     // Catch:{ Exception -> 0x056f }
                boolean r8 = r8.equals(r4)     // Catch:{ Exception -> 0x056f }
                if (r8 == 0) goto L_0x03e4
                goto L_0x03fc
            L_0x03e4:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r8.<init>()     // Catch:{ Exception -> 0x056f }
                r8.append(r6)     // Catch:{ Exception -> 0x056f }
                r8.append(r7)     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = "\n"
                r8.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x056f }
                int r5 = r5 + 1
                goto L_0x03d3
            L_0x03fb:
                r6 = r4
            L_0x03fc:
                java.lang.String r2 = "You are likely"
                java.lang.String r3 = "You likely"
                if (r6 == r4) goto L_0x0418
                boolean r5 = r6.isEmpty()     // Catch:{ Exception -> 0x056f }
                if (r5 != 0) goto L_0x0418
                android.widget.TextView r5 = r13.remarks_tv     // Catch:{ Exception -> 0x056f }
                java.lang.String r7 = r6.replace(r3, r2)     // Catch:{ Exception -> 0x056f }
                r5.setText(r7)     // Catch:{ Exception -> 0x056f }
                android.widget.RelativeLayout r5 = r13.remarks_rl     // Catch:{ Exception -> 0x056f }
                r7 = 0
                r5.setVisibility(r7)     // Catch:{ Exception -> 0x056f }
                goto L_0x0424
            L_0x0418:
                android.widget.TextView r5 = r13.remarks_tv     // Catch:{ Exception -> 0x056f }
                r5.setText(r4)     // Catch:{ Exception -> 0x056f }
                android.widget.RelativeLayout r5 = r13.remarks_rl     // Catch:{ Exception -> 0x056f }
                r7 = 8
                r5.setVisibility(r7)     // Catch:{ Exception -> 0x056f }
            L_0x0424:
                android.widget.TextView r5 = r13.tv_ir_recovers     // Catch:{ Exception -> 0x056f }
                r7 = 2131952959(0x7f13053f, float:1.9542375E38)
                java.lang.String r7 = r13.getString(r7)     // Catch:{ Exception -> 0x056f }
                r5.setText(r7)     // Catch:{ Exception -> 0x056f }
                java.lang.String r5 = r21.getTrainCancelStatus()     // Catch:{ Exception -> 0x056f }
                java.lang.String r7 = ":"
                if (r5 == 0) goto L_0x04a2
                java.lang.String r5 = r21.getTrainCancelStatus()     // Catch:{ Exception -> 0x056f }
                boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x056f }
                if (r5 != 0) goto L_0x04a2
                java.lang.String r5 = r21.getTrainCancelStatus()     // Catch:{ Exception -> 0x056f }
                boolean r5 = r5.contains(r7)     // Catch:{ Exception -> 0x056f }
                if (r5 == 0) goto L_0x0471
                java.lang.String r5 = r21.getTrainCancelStatus()     // Catch:{ Exception -> 0x056f }
                java.lang.String[] r5 = r5.split(r7)     // Catch:{ Exception -> 0x056f }
                r8 = 1
                r5 = r5[r8]     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r9.<init>()     // Catch:{ Exception -> 0x056f }
                r9.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = r21.getTrainCancelStatus()     // Catch:{ Exception -> 0x056f }
                java.lang.String[] r6 = r6.split(r7)     // Catch:{ Exception -> 0x056f }
                r6 = r6[r8]     // Catch:{ Exception -> 0x056f }
                r9.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = r9.toString()     // Catch:{ Exception -> 0x056f }
                goto L_0x0488
            L_0x0471:
                java.lang.String r5 = r21.getTrainCancelStatus()     // Catch:{ Exception -> 0x056f }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r8.<init>()     // Catch:{ Exception -> 0x056f }
                r8.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = r21.getTrainCancelStatus()     // Catch:{ Exception -> 0x056f }
                r8.append(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x056f }
            L_0x0488:
                boolean r8 = r5.equals(r4)     // Catch:{ Exception -> 0x056f }
                if (r8 != 0) goto L_0x049a
                android.widget.LinearLayout r8 = r13.ll_delay_msg     // Catch:{ Exception -> 0x056f }
                r9 = 0
                r8.setVisibility(r9)     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r8 = r13.tv_delay_msg     // Catch:{ Exception -> 0x056f }
                r8.setText(r5)     // Catch:{ Exception -> 0x056f }
                goto L_0x04a9
            L_0x049a:
                android.widget.LinearLayout r5 = r13.ll_delay_msg     // Catch:{ Exception -> 0x056f }
                r8 = 8
                r5.setVisibility(r8)     // Catch:{ Exception -> 0x056f }
                goto L_0x04a9
            L_0x04a2:
                android.widget.LinearLayout r5 = r13.ll_delay_msg     // Catch:{ Exception -> 0x056f }
                r8 = 8
                r5.setVisibility(r8)     // Catch:{ Exception -> 0x056f }
            L_0x04a9:
                java.lang.String r5 = r6.trim()     // Catch:{ Exception -> 0x056f }
                boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x056f }
                if (r5 != 0) goto L_0x04b6
                r6.replace(r3, r2)     // Catch:{ Exception -> 0x056f }
            L_0x04b6:
                com.google.android.gms.ads.interstitial.InterstitialAd r2 = cris.org.in.ima.fragment.PnrEnquiryFragment.a     // Catch:{ Exception -> 0x056f }
                java.lang.Short r2 = r21.getDelay()     // Catch:{ Exception -> 0x056f }
                java.lang.String r3 = "0"
                r5 = 10
                if (r2 == 0) goto L_0x050d
                java.lang.Short r2 = r21.getDelay()     // Catch:{ Exception -> 0x056f }
                short r2 = r2.shortValue()     // Catch:{ Exception -> 0x056f }
                if (r2 <= 0) goto L_0x050d
                android.widget.LinearLayout r2 = r13.ll_delay_value     // Catch:{ Exception -> 0x056f }
                r6 = 0
                r2.setVisibility(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.Short r2 = r21.getDelay()     // Catch:{ Exception -> 0x056f }
                short r2 = r2.shortValue()     // Catch:{ Exception -> 0x056f }
                int r6 = r2 / 60
                int r8 = r6 * 60
                int r2 = r2 - r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r8.<init>()     // Catch:{ Exception -> 0x056f }
                if (r6 >= r5) goto L_0x04e8
                r9 = r3
                goto L_0x04e9
            L_0x04e8:
                r9 = r4
            L_0x04e9:
                r8.append(r9)     // Catch:{ Exception -> 0x056f }
                r8.append(r4)     // Catch:{ Exception -> 0x056f }
                r8.append(r6)     // Catch:{ Exception -> 0x056f }
                r8.append(r7)     // Catch:{ Exception -> 0x056f }
                if (r2 >= r5) goto L_0x04f9
                r6 = r3
                goto L_0x04fa
            L_0x04f9:
                r6 = r4
            L_0x04fa:
                r8.append(r6)     // Catch:{ Exception -> 0x056f }
                r8.append(r4)     // Catch:{ Exception -> 0x056f }
                r8.append(r2)     // Catch:{ Exception -> 0x056f }
                java.lang.String r2 = r8.toString()     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r6 = r13.tv_delay_value     // Catch:{ Exception -> 0x056f }
                r6.setText(r2)     // Catch:{ Exception -> 0x056f }
                goto L_0x0514
            L_0x050d:
                android.widget.LinearLayout r2 = r13.ll_delay_value     // Catch:{ Exception -> 0x056f }
                r6 = 8
                r2.setVisibility(r6)     // Catch:{ Exception -> 0x056f }
            L_0x0514:
                java.lang.Short r2 = r21.getDelay()     // Catch:{ Exception -> 0x056f }
                if (r2 == 0) goto L_0x0564
                java.lang.Short r2 = r21.getDelay()     // Catch:{ Exception -> 0x056f }
                short r2 = r2.shortValue()     // Catch:{ Exception -> 0x056f }
                if (r2 <= 0) goto L_0x0564
                android.widget.LinearLayout r2 = r13.ll_delay_value     // Catch:{ Exception -> 0x056f }
                r6 = 0
                r2.setVisibility(r6)     // Catch:{ Exception -> 0x056f }
                java.lang.Short r1 = r21.getDelay()     // Catch:{ Exception -> 0x056f }
                short r1 = r1.shortValue()     // Catch:{ Exception -> 0x056f }
                int r2 = r1 / 60
                int r6 = r2 * 60
                int r1 = r1 - r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x056f }
                r6.<init>()     // Catch:{ Exception -> 0x056f }
                if (r2 >= r5) goto L_0x0540
                r8 = r3
                goto L_0x0541
            L_0x0540:
                r8 = r4
            L_0x0541:
                r6.append(r8)     // Catch:{ Exception -> 0x056f }
                r6.append(r4)     // Catch:{ Exception -> 0x056f }
                r6.append(r2)     // Catch:{ Exception -> 0x056f }
                r6.append(r7)     // Catch:{ Exception -> 0x056f }
                if (r1 >= r5) goto L_0x0550
                goto L_0x0551
            L_0x0550:
                r3 = r4
            L_0x0551:
                r6.append(r3)     // Catch:{ Exception -> 0x056f }
                r6.append(r4)     // Catch:{ Exception -> 0x056f }
                r6.append(r1)     // Catch:{ Exception -> 0x056f }
                java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x056f }
                android.widget.TextView r2 = r13.tv_delay_value     // Catch:{ Exception -> 0x056f }
                r2.setText(r1)     // Catch:{ Exception -> 0x056f }
                goto L_0x0578
            L_0x0564:
                android.widget.LinearLayout r1 = r13.ll_delay_value     // Catch:{ Exception -> 0x056f }
                r2 = 8
                r1.setVisibility(r2)     // Catch:{ Exception -> 0x056f }
                goto L_0x0578
            L_0x056c:
                r0 = move-exception
                r1 = r0
                goto L_0x0577
            L_0x056f:
                r0 = move-exception
                r1 = r0
                com.google.android.gms.ads.interstitial.InterstitialAd r2 = cris.org.in.ima.fragment.PnrEnquiryFragment.a     // Catch:{ all -> 0x056c }
                r1.getMessage()     // Catch:{ all -> 0x056c }
                goto L_0x0578
            L_0x0577:
                throw r1
            L_0x0578:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PnrEnquiryFragment.c.onNext(cris.prs.webservices.dto.PnrEnquiryResponseDTO):void");
        }

        public final void onCompleted() {
            InterstitialAd interstitialAd = PnrEnquiryFragment.a;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            InterstitialAd interstitialAd = PnrEnquiryFragment.a;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            PnrEnquiryFragment pnrEnquiryFragment = PnrEnquiryFragment.this;
            pnrEnquiryFragment.psgn_layout.setVisibility(8);
            HomeActivity.B(pnrEnquiryFragment.getActivity());
            Lt.a(true, th);
        }
    }

    public class d implements FavoritepnrAdaptor.PnrListAdapterStnSelectListener {
        public d() {
        }

        public final void onDeleteClick(PnrModel pnrModel) {
            if (C0535I5.R()) {
                PnrEnquiryFragment pnrEnquiryFragment = PnrEnquiryFragment.this;
                pnrEnquiryFragment.favIconImage.setImageResource(R.mipmap.ic_fav_icon1);
                pnrEnquiryFragment.j(pnrModel);
                return;
            }
            HomeActivity.A(2);
        }

        public final void onPnrClick(PnrModel pnrModel) {
            if (C0535I5.R()) {
                InterstitialAd interstitialAd = PnrEnquiryFragment.a;
                PnrEnquiryFragment pnrEnquiryFragment = PnrEnquiryFragment.this;
                pnrEnquiryFragment.getClass();
                pnrEnquiryFragment.favIconImage.setImageResource(R.mipmap.ic_fav_icon);
                pnrEnquiryFragment.pnr_view.setText(pnrModel.a);
                if (lf.e(pnrEnquiryFragment.pnr_view) == 10) {
                    C0535I5.Z(pnrEnquiryFragment.getActivity(), PnrEnquiryFragment.a, false);
                    pnrEnquiryFragment.l();
                    pnrEnquiryFragment.i();
                    return;
                }
                return;
            }
            HomeActivity.A(2);
        }
    }

    static {
        C1354qp.R(PnrEnquiryFragment.class);
    }

    @OnClick({2131362264})
    public void cnfCheckCetails() {
        Context context = this.f5033a;
        C0549JD jd = C0535I5.f3617a;
        if (jd == null || jd.getMaxRacCnfList() == null || C0535I5.f3618a == null) {
            Toast.makeText(context, context.getString(R.string.last_Year_data_not_found), 0).show();
            return;
        }
        C0535I5.f3627b = C0535I5.f3617a.maxWlRacCnfList;
        Intent intent = new Intent(context, LastYearCnfTrendActivity.class);
        String[] split = ("" + ((C0535I5.f3617a.getProbability().doubleValue() * 100.0d) + 0.5d)).split("\\.");
        intent.putExtra("train_name", C0535I5.f3631c);
        intent.putExtra("train_no", C0535I5.f3618a.getTrainNumber());
        intent.putExtra("FromStnCode", C0535I5.f3618a.getFromStnCode());
        intent.putExtra("toStnCode", C0535I5.f3618a.getToStnCode());
        intent.putExtra("cnf_chance", split[0] + "% *");
        intent.putExtra("cnf_status", C0535I5.f3617a.getPassengerChartStatus());
        intent.putExtra("tv_class", C0535I5.f3618a.getJourneyClass());
        if (C0535I5.f3626b.equalsIgnoreCase("pnrEnquiry")) {
            intent.putExtra("current_avl_status", "");
            intent.putExtra("current_avl_date", "");
        } else if (C0535I5.f3626b.equalsIgnoreCase("ticketViewHolder")) {
            intent.putExtra("current_avl_status", "");
            intent.putExtra("current_avl_date", "");
        }
        context.startActivity(intent);
    }

    public final void i() {
        this.pre.setText("Cnf Probability");
        this.pre.setTextSize(10.0f);
        this.pre.setTextColor(getResources().getColor(R.color.blue));
        this.cnfCheckCetails.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r1.isOpen() != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002a, code lost:
        if (r1.isOpen() != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(cris.org.in.ima.model.PnrModel r5) {
        /*
            r4 = this;
            b1 r0 = defpackage.C0793b1.a
            Wb r0 = r0.f3910a
            java.util.ArrayList<cris.org.in.ima.model.PnrModel> r1 = r4.f5040a
            boolean r1 = r1.contains(r5)
            if (r1 == 0) goto L_0x0057
            java.lang.String r5 = r5.a
            r0.getClass()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r1 = r0.getReadableDatabase()     // Catch:{ SQLiteException -> 0x003a, all -> 0x002d }
            java.lang.String r0 = "userPnr=?"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x003a, all -> 0x002d }
            r3 = 0
            r2[r3] = r5     // Catch:{ SQLiteException -> 0x003a, all -> 0x002d }
            java.lang.String r5 = "pnr_detail"
            r1.delete(r5, r0, r2)     // Catch:{ SQLiteException -> 0x003a, all -> 0x002d }
            r1.close()     // Catch:{ SQLiteException -> 0x003a, all -> 0x002d }
            boolean r5 = r1.isOpen()
            if (r5 == 0) goto L_0x0045
            goto L_0x0042
        L_0x002d:
            r5 = move-exception
            if (r1 == 0) goto L_0x0039
            boolean r0 = r1.isOpen()
            if (r0 == 0) goto L_0x0039
            r1.close()
        L_0x0039:
            throw r5
        L_0x003a:
            if (r1 == 0) goto L_0x0045
            boolean r5 = r1.isOpen()
            if (r5 == 0) goto L_0x0045
        L_0x0042:
            r1.close()
        L_0x0045:
            r4.m()
            android.content.Context r5 = r4.getContext()
            r0 = 2131951945(0x7f130149, float:1.9540319E38)
            java.lang.String r0 = r4.getString(r0)
            defpackage.C0535I5.t0(r5, r0)
            goto L_0x0065
        L_0x0057:
            android.content.Context r5 = r4.getContext()
            r0 = 2131951947(0x7f13014b, float:1.9540323E38)
            java.lang.String r0 = r4.getString(r0)
            defpackage.C0535I5.t0(r5, r0)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PnrEnquiryFragment.j(cris.org.in.ima.model.PnrModel):void");
    }

    public final void k(PnrEnquiryResponseDTO pnrEnquiryResponseDTO, TextView textView) {
        this.pre.setOnClickListener(new a(pnrEnquiryResponseDTO, textView));
    }

    public final void l() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new b(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticketdetails), getString(R.string.please_wait_text));
        String f = C0657Qt.f();
        String format = String.format("/%s", new Object[]{this.pnr_view.getText().toString()});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).W(f + "pnrenq" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new c(show));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r0 != null) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r6 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r6.favPnrList
            r1 = 0
            r0.setVisibility(r1)
            b1 r0 = defpackage.C0793b1.a
            Wb r0 = r0.f3910a
            r0.getClass()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            java.lang.String r3 = "select * from pnr_detail"
            android.database.Cursor r2 = r0.rawQuery(r3, r2)     // Catch:{ Exception -> 0x003d }
        L_0x001d:
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x003d }
            if (r3 == 0) goto L_0x004a
            cris.org.in.ima.model.PnrModel r3 = new cris.org.in.ima.model.PnrModel     // Catch:{ Exception -> 0x003d }
            r3.<init>()     // Catch:{ Exception -> 0x003d }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x003d }
            r3.a = r4     // Catch:{ Exception -> 0x003d }
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x003d }
            r3.b = r4     // Catch:{ Exception -> 0x003d }
            r1.add(r3)     // Catch:{ Exception -> 0x003d }
            goto L_0x001d
        L_0x003a:
            r1 = move-exception
            r2 = r0
            goto L_0x005b
        L_0x003d:
            r2 = move-exception
            goto L_0x0045
        L_0x003f:
            r0 = move-exception
            goto L_0x005c
        L_0x0041:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L_0x0045:
            r2.getMessage()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x004d
        L_0x004a:
            r0.close()
        L_0x004d:
            java.util.ArrayList<cris.org.in.ima.model.PnrModel> r0 = r6.f5040a
            r0.clear()
            r0.addAll(r1)
            cris.org.in.ima.adaptors.FavoritepnrAdaptor r0 = r6.f5035a
            r0.notifyDataSetChanged()
            return
        L_0x005b:
            r0 = r1
        L_0x005c:
            if (r2 == 0) goto L_0x0061
            r2.close()
        L_0x0061:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PnrEnquiryFragment.m():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    @butterknife.OnClick({2131364534})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClickFavoritePnr() {
        /*
            r6 = this;
            android.widget.ImageView r0 = r6.favIconImage
            r1 = 2131755009(0x7f100001, float:1.9140885E38)
            r0.setImageResource(r1)
            b1 r0 = defpackage.C0793b1.a
            Wb r0 = r0.f3910a
            cris.org.in.ima.model.PnrModel r1 = new cris.org.in.ima.model.PnrModel
            r1.<init>()
            java.lang.String r2 = r6.c
            r1.a = r2
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r3 = "dd-MMM-yyyy"
            r2.<init>(r3)
            java.util.Date r3 = r6.f5041a
            java.lang.String r2 = r2.format(r3)
            r1.b = r2
            java.util.ArrayList<cris.org.in.ima.model.PnrModel> r1 = r6.f5040a
            java.util.Iterator r2 = r1.iterator()
        L_0x002a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r2.next()
            cris.org.in.ima.model.PnrModel r3 = (cris.org.in.ima.model.PnrModel) r3
            java.lang.String r3 = r3.a
            java.lang.String r4 = r6.c
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x002a
            r2 = 0
            goto L_0x0043
        L_0x0042:
            r2 = 1
        L_0x0043:
            if (r2 == 0) goto L_0x00ad
            int r2 = r1.size()
            r3 = 6
            if (r2 < r3) goto L_0x0056
            r2 = 5
            java.lang.Object r1 = r1.get(r2)
            cris.org.in.ima.model.PnrModel r1 = (cris.org.in.ima.model.PnrModel) r1
            r6.j(r1)
        L_0x0056:
            java.lang.String r1 = r6.c
            java.util.Date r2 = r6.f5041a
            r0.getClass()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ Exception -> 0x0088 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            r4.<init>()     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            java.lang.String r5 = "userPnr"
            r4.put(r5, r1)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            java.lang.String r1 = "jDATE"
            java.text.SimpleDateFormat r5 = defpackage.C0735Wb.a     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            java.lang.String r5 = r5.format(r2)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            r4.put(r1, r5)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            java.lang.String r1 = "pnr_detail"
            r0.insert(r1, r3, r4)     // Catch:{ Exception -> 0x0082, all -> 0x0080 }
            r0.close()
            goto L_0x0094
        L_0x0080:
            r1 = move-exception
            goto L_0x00a7
        L_0x0082:
            r1 = move-exception
            r3 = r0
            goto L_0x0089
        L_0x0085:
            r0 = move-exception
            r1 = r0
            goto L_0x00a6
        L_0x0088:
            r1 = move-exception
        L_0x0089:
            java.util.Objects.toString(r2)     // Catch:{ all -> 0x0085 }
            r1.getMessage()     // Catch:{ all -> 0x0085 }
            if (r3 == 0) goto L_0x0094
            r3.close()
        L_0x0094:
            r6.m()
            android.content.Context r0 = r6.getContext()
            r1 = 2131953516(0x7f13076c, float:1.9543505E38)
            java.lang.String r1 = r6.getString(r1)
            defpackage.C0535I5.t0(r0, r1)
            goto L_0x00bb
        L_0x00a6:
            r0 = r3
        L_0x00a7:
            if (r0 == 0) goto L_0x00ac
            r0.close()
        L_0x00ac:
            throw r1
        L_0x00ad:
            android.content.Context r0 = r6.getContext()
            r1 = 2131953507(0x7f130763, float:1.9543487E38)
            java.lang.String r1 = r6.getString(r1)
            defpackage.C0535I5.t0(r0, r1)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.PnrEnquiryFragment.onClickFavoritePnr():void");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_pnrenquiry, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        C0499Ep ep = new C0499Ep();
        AdRequest build = new AdRequest.Builder().build();
        InterstitialAd.load(getActivity(), getResources().getString(R.string.pnr_interstitial_add), build, new C0508Fp(ep));
        C0535I5.Z(getActivity(), a, false);
        this.f5033a = getContext();
        this.pnr_view.addTextChangedListener(new C0479D5(getActivity(), 10));
        this.f5034a = getActivity();
        this.f5036a = C0793b1.a.f3911a;
        this.pnr_view.requestFocus();
        this.selectFavPnr.setVisibility(0);
        this.favIconImage.setImageResource(R.mipmap.ic_fav_icon1);
        this.favPnrList.setLayoutManager(new LinearLayoutManager(this.f5033a));
        FavoritepnrAdaptor favoritepnrAdaptor = new FavoritepnrAdaptor(this.f5033a, this.f5038a, this.f5040a);
        this.f5035a = favoritepnrAdaptor;
        this.favPnrList.setAdapter(favoritepnrAdaptor);
        m();
        HomeActivity.J();
        HomeActivity.p();
        String str = C1450w1.f7009a;
        GoogleAdParamDTO googleAdParamDTO = this.f5037a;
        googleAdParamDTO.setAge(str);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.pnrEquiryTop, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.pnrEquiryBottom, googleAdParamDTO);
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        HomeActivity.p();
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        HomeActivity.p();
    }

    @OnClick({2131364586})
    public void onSearchClick() {
        try {
            if (this.pnr_view.getText().toString().compareToIgnoreCase("") == 0) {
                C0535I5.o(getActivity(), getString(R.string.Please_Enter_PNR), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else if (this.pnr_view.getText().toString().length() != 10) {
                C0535I5.o(getActivity(), getString(R.string.PNR_10_digits), getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else if (C0535I5.R()) {
                ArrayList<PnrModel> arrayList = this.f5040a;
                if (arrayList != null) {
                    Iterator<PnrModel> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (this.pnr_view.getText().toString().equalsIgnoreCase(it.next().a)) {
                            this.f5042a = true;
                        }
                    }
                }
                if (this.f5042a) {
                    this.favIconImage.setImageResource(R.mipmap.ic_fav_icon);
                } else {
                    this.favIconImage.setImageResource(R.mipmap.ic_fav_icon1);
                }
                C0535I5.Z(getActivity(), a, false);
                l();
                i();
            } else {
                HomeActivity.A(2);
            }
        } catch (Exception e) {
            e.getMessage();
            i();
        }
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    public class b implements Runnable {
        public final void run() {
        }
    }
}
