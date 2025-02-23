package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.StatusDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public class TDRTicketDetailsFragment extends Fragment {
    public static final /* synthetic */ int e = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f5123a;

    /* renamed from: a  reason: collision with other field name */
    public StationDb f5124a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f5125a;

    /* renamed from: a  reason: collision with other field name */
    public final e f5126a = new e();

    /* renamed from: a  reason: collision with other field name */
    public TDRTicketPassengerAdapter f5127a;

    /* renamed from: a  reason: collision with other field name */
    public BookingResponseDTO f5128a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f5129a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f5130a = new SimpleDateFormat("dd MMM yyyy HH:mm");

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f5131a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5132a = false;
    public final BookingResponseDTO b = new BookingResponseDTO();

    /* renamed from: b  reason: collision with other field name */
    public final SimpleDateFormat f5133b = new SimpleDateFormat("dd MMM yyyy");

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<String> f5134b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f5135b = false;
    @BindView(2131362020)
    TextView bankname;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public String f5136c = "";

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<C0502Ez> f5137c;
    @BindView(2131362105)
    ImageView calender_carddob_rl;
    @BindView(2131364337)
    TextView chartstatus;
    @BindView(2131362284)
    TextView confirm;
    @BindView(2131362288)
    RelativeLayout confirm_ll;
    public int d = 2;
    @BindView(2131362403)
    TextView destArrDate;
    @BindView(2131362404)
    TextView destArrTime;
    @BindView(2131362527)
    EditText et_eftGCnumber;
    @BindView(2131362528)
    LinearLayout et_eftdetail_ll;
    @BindView(2131362536)
    EditText et_gc_amount;
    @BindView(2131362537)
    EditText et_gc_date;
    @BindView(2131362654)
    TextView fileTdrSuccessMsg;
    @BindView(2131362653)
    AdManagerAdView filetdr_reason_bottom;
    @BindView(2131362659)
    RelativeLayout filledLl;
    @BindView(2131362715)
    TextView fromcitycode;
    @BindView(2131362920)
    TextView journeyDate;
    @BindView(2131362925)
    TextView journeyTime;
    @BindView(2131363825)
    RecyclerView passengerList;
    @BindView(2131363506)
    TextView pnr;
    @BindView(2131364534)
    LinearLayout pnrFav;
    @BindView(2131362150)
    CheckBox selectall;
    @BindView(2131364073)
    TextView tdrReason;
    @BindView(2131364074)
    RelativeLayout tdrReasonLl;
    @BindView(2131364069)
    AdManagerAdView tdr_confirmation_bottom;
    @BindView(2131364156)
    TextView tktDetails;
    @BindView(2131364169)
    TextView tocitycode;
    @BindView(2131364201)
    TextView trainName;
    @BindView(2131364203)
    TextView trainno;
    @BindView(2131364247)
    TextView traveltime;
    @BindView(2131364726)
    TextView vikalpopt;

    public class a implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public final void onClick(View view) {
            CheckBox checkBox;
            int i = TDRTicketDetailsFragment.e;
            TDRTicketDetailsFragment tDRTicketDetailsFragment = TDRTicketDetailsFragment.this;
            TDRTicketPassengerAdapter tDRTicketPassengerAdapter = tDRTicketDetailsFragment.f5127a;
            if (tDRTicketPassengerAdapter != null) {
                boolean isChecked = tDRTicketDetailsFragment.selectall.isChecked();
                if (isChecked && (checkBox = tDRTicketPassengerAdapter.a.selectall) != null) {
                    checkBox.setChecked(true);
                }
                ArrayList<PassengerDetailDTO> arrayList = tDRTicketPassengerAdapter.f5145a;
                if (arrayList != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (!arrayList.get(i2).getCurrentStatusDetails().equalsIgnoreCase("can")) {
                            tDRTicketPassengerAdapter.b.set(i2, Boolean.valueOf(isChecked));
                        }
                    }
                    tDRTicketPassengerAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public class d implements View.OnClickListener {

        public class a implements DatePickerDialog.OnDateSetListener {
            public a() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Object obj;
                Object obj2;
                int i4 = TDRTicketDetailsFragment.e;
                d dVar = d.this;
                EditText editText = TDRTicketDetailsFragment.this.et_gc_date;
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
                TDRTicketDetailsFragment.this.et_gc_date.getText().toString();
                TDRTicketDetailsFragment.this.et_gc_date.setError((CharSequence) null);
            }
        }

        public d() {
        }

        public final void onClick(View view) {
            int i = TDRTicketDetailsFragment.e;
            Calendar instance = Calendar.getInstance();
            TDRTicketDetailsFragment tDRTicketDetailsFragment = TDRTicketDetailsFragment.this;
            DatePickerDialog datePickerDialog = new DatePickerDialog(tDRTicketDetailsFragment.f5123a, new a(), instance.get(1), instance.get(2), instance.get(5));
            Calendar instance2 = Calendar.getInstance();
            Calendar instance3 = Calendar.getInstance();
            instance2.add(1, 120);
            datePickerDialog.getDatePicker().setMaxDate(instance2.getTime().getTime());
            datePickerDialog.getDatePicker().setMinDate(instance3.getTime().getTime());
            datePickerDialog.setTitle(tDRTicketDetailsFragment.getString(R.string.select_date));
            datePickerDialog.show();
        }
    }

    public class g extends Subscriber<C0707Ue> {
        public g() {
        }

        public final void onCompleted() {
            int i = TDRTicketDetailsFragment.e;
        }

        public final void onError(Throwable th) {
            int i = TDRTicketDetailsFragment.e;
            th.getClass();
            th.getMessage();
            TDRTicketDetailsFragment tDRTicketDetailsFragment = TDRTicketDetailsFragment.this;
            tDRTicketDetailsFragment.a.dismiss();
            tDRTicketDetailsFragment.getFragmentManager().Q();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            String str;
            C0707Ue ue = (C0707Ue) obj;
            int i = TDRTicketDetailsFragment.e;
            TDRTicketDetailsFragment tDRTicketDetailsFragment = TDRTicketDetailsFragment.this;
            if (ue != null && ue.getErrorMsg() == null) {
                BookingResponseDTO bookingResponseDTO = ue.getBookingResponseList().get(0);
                if (ue.getBookingResponseList().get(0).getScheduleArrivalFlag().booleanValue() && ue.getBookingResponseList().get(0).getScheduleDepartureFlag().booleanValue()) {
                    tDRTicketDetailsFragment.journeyDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getBoardingDate()));
                    tDRTicketDetailsFragment.destArrDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getDestArrvDate()));
                    tDRTicketDetailsFragment.journeyTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getBoardingDate()));
                    tDRTicketDetailsFragment.destArrTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getDestArrvDate()));
                } else if (ue.getBookingResponseList().get(0).getScheduleArrivalFlag().booleanValue()) {
                    tDRTicketDetailsFragment.journeyDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getBoardingDate()));
                    tDRTicketDetailsFragment.journeyTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getBoardingDate()));
                    tDRTicketDetailsFragment.destArrDate.setText("*N.A.");
                    tDRTicketDetailsFragment.destArrTime.setText("*N.A.");
                } else if (ue.getBookingResponseList().get(0).getScheduleDepartureFlag().booleanValue()) {
                    tDRTicketDetailsFragment.journeyDate.setText("*N.A.");
                    tDRTicketDetailsFragment.journeyTime.setText("*N.A.");
                    tDRTicketDetailsFragment.destArrDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getDestArrvDate()));
                    tDRTicketDetailsFragment.destArrTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getDestArrvDate()));
                } else {
                    tDRTicketDetailsFragment.journeyDate.setText("*N.A.");
                    tDRTicketDetailsFragment.journeyTime.setText("*N.A.");
                    tDRTicketDetailsFragment.destArrDate.setText("*N.A.");
                    tDRTicketDetailsFragment.destArrTime.setText("*N.A.");
                }
                if (ue.getTdrReasonList() != null && ue.getTdrReasonList().size() > 0) {
                    tDRTicketDetailsFragment.f5137c = ue.getTdrReasonList();
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<C0502Ez> it = tDRTicketDetailsFragment.f5137c.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getTdrReason());
                    }
                    tDRTicketDetailsFragment.f5134b = arrayList;
                }
                ArrayList<PassengerDetailDTO> psgnDtlList = ue.getBookingResponseList().get(0).getPsgnDtlList();
                tDRTicketDetailsFragment.f5131a = psgnDtlList;
                Collections.sort(psgnDtlList, new C1045r0());
                TDRTicketPassengerAdapter tDRTicketPassengerAdapter = new TDRTicketPassengerAdapter(tDRTicketDetailsFragment, tDRTicketDetailsFragment.f5131a);
                tDRTicketDetailsFragment.f5127a = tDRTicketPassengerAdapter;
                tDRTicketDetailsFragment.passengerList.setAdapter(tDRTicketPassengerAdapter);
                bookingResponseDTO.setJourneyClass(ue.getBookingResponseList().get(0).getJourneyClass());
                bookingResponseDTO.setJourneyQuota(ue.getBookingResponseList().get(0).getJourneyQuota());
                if (bookingResponseDTO.getVikalpStatus() != null) {
                    tDRTicketDetailsFragment.vikalpopt.setText(bookingResponseDTO.getVikalpStatus());
                }
                if (bookingResponseDTO.getTrainChartStatus() != null) {
                    tDRTicketDetailsFragment.chartstatus.setText(bookingResponseDTO.getTrainChartStatus());
                }
                if (bookingResponseDTO.getBankName() != null) {
                    tDRTicketDetailsFragment.bankname.setText(bookingResponseDTO.getBankName());
                }
                if (bookingResponseDTO.getJourneyClass() == null) {
                    str = "";
                } else if (xx.e(bookingResponseDTO.getJourneyClass()) != null) {
                    str = " | " + xx.e(bookingResponseDTO.getJourneyClass());
                } else {
                    str = " | " + bookingResponseDTO.getJourneyClass();
                }
                Iterator<PassengerDetailDTO> it2 = tDRTicketDetailsFragment.f5131a.iterator();
                int i2 = 0;
                while (it2.hasNext()) {
                    PassengerDetailDTO next = it2.next();
                    if (next.getPassengerAge().shortValue() >= 0 && next.getPassengerAge().shortValue() <= 4) {
                        i2++;
                    }
                }
                tDRTicketDetailsFragment.tktDetails.setText(tDRTicketDetailsFragment.f5131a.size() + " " + tDRTicketDetailsFragment.getString(R.string.adult) + " " + i2 + " " + tDRTicketDetailsFragment.getString(R.string.child) + "  | " + bookingResponseDTO.getJourneyQuota() + str + " | " + tDRTicketDetailsFragment.f5124a.m(bookingResponseDTO.getBoardingStn()) + "( " + bookingResponseDTO.getBoardingStn() + " ) | " + C0535I5.h(bookingResponseDTO.getBoardingDate()));
                if (ue.getBookingResponseList().get(0).getBoardingDate() == null || ue.getBookingResponseList().get(0).getDestArrvDate() == null) {
                    tDRTicketDetailsFragment.traveltime.setVisibility(4);
                } else {
                    tDRTicketDetailsFragment.traveltime.setVisibility(0);
                    tDRTicketDetailsFragment.traveltime.setText(C0535I5.A(ue.getBookingResponseList().get(0).getBoardingDate(), ue.getBookingResponseList().get(0).getDestArrvDate()));
                }
                tDRTicketDetailsFragment.tktDetails.setText(tDRTicketDetailsFragment.f5131a.size() + " " + tDRTicketDetailsFragment.getString(R.string.adult) + " " + i2 + " " + tDRTicketDetailsFragment.getString(R.string.child) + "  | " + bookingResponseDTO.getJourneyQuota() + str + " | " + tDRTicketDetailsFragment.f5124a.m(bookingResponseDTO.getBoardingStn()) + "( " + bookingResponseDTO.getBoardingStn() + " ) | " + C0535I5.h(bookingResponseDTO.getBoardingDate()));
                Date boardingDate = ue.getBookingResponseList().get(0).getBoardingDate();
                BookingResponseDTO bookingResponseDTO2 = tDRTicketDetailsFragment.b;
                bookingResponseDTO2.setBoardingDate(boardingDate);
                bookingResponseDTO2.setDestArrvDate(ue.getBookingResponseList().get(0).getDestArrvDate());
                bookingResponseDTO2.setJourneyClass(ue.getBookingResponseList().get(0).getJourneyClass());
                bookingResponseDTO2.setJourneyQuota(ue.getBookingResponseList().get(0).getJourneyQuota());
                bookingResponseDTO2.setTrainChartStatus(ue.getBookingResponseList().get(0).getTrainChartStatus());
                tDRTicketDetailsFragment.a.dismiss();
            } else if (ue == null || ue.getErrorMsg() == null) {
                tDRTicketDetailsFragment.a.dismiss();
                C0535I5.m(tDRTicketDetailsFragment.f5123a, false, tDRTicketDetailsFragment.getString(R.string.unable_process_message), tDRTicketDetailsFragment.getString(R.string.error), tDRTicketDetailsFragment.getString(R.string.OK), new t0(this)).show();
            } else {
                ue.getErrorMsg();
                tDRTicketDetailsFragment.a.dismiss();
                C0535I5.m(tDRTicketDetailsFragment.f5123a, false, ue.getErrorMsg().split("-")[0], tDRTicketDetailsFragment.getString(R.string.error), tDRTicketDetailsFragment.getString(R.string.OK), new C1047s0(this)).show();
            }
        }
    }

    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            TDRTicketDetailsFragment.this.confirmHide();
        }
    }

    public class i implements DialogInterface.OnClickListener {
        public i() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            TDRTicketDetailsFragment.this.confirmHide();
        }
    }

    public class j implements OnSelectionListener {
        public j() {
        }

        public final void onClick(String str) {
            TDRTicketDetailsFragment tDRTicketDetailsFragment = TDRTicketDetailsFragment.this;
            tDRTicketDetailsFragment.tdrReason.setText(str);
            tDRTicketDetailsFragment.f5125a.dismiss();
            if (str.compareToIgnoreCase("TDR Reason") != 0) {
                tDRTicketDetailsFragment.getClass();
                tDRTicketDetailsFragment.c = C1450w1.f7011a.get(tDRTicketDetailsFragment.tdrReason.getText().toString()).intValue();
                int i = tDRTicketDetailsFragment.c;
                int i2 = 0;
                while (true) {
                    if (i2 >= tDRTicketDetailsFragment.f5137c.size()) {
                        break;
                    } else if (tDRTicketDetailsFragment.f5137c.get(i2).getReasonIndex() == tDRTicketDetailsFragment.c) {
                        tDRTicketDetailsFragment.d = tDRTicketDetailsFragment.f5137c.get(i2).getEftFlag();
                        break;
                    } else {
                        i2++;
                    }
                }
                if (tDRTicketDetailsFragment.d == 1) {
                    tDRTicketDetailsFragment.et_eftdetail_ll.setVisibility(0);
                    tDRTicketDetailsFragment.d = 1;
                    tDRTicketDetailsFragment.f5132a = true;
                } else {
                    tDRTicketDetailsFragment.et_eftdetail_ll.setVisibility(8);
                    tDRTicketDetailsFragment.d = 2;
                    tDRTicketDetailsFragment.f5132a = false;
                }
                tDRTicketDetailsFragment.tdrReason.setError((CharSequence) null);
                return;
            }
            tDRTicketDetailsFragment.getClass();
            tDRTicketDetailsFragment.tdrReason.setError("Select TDR Reason");
        }
    }

    public class k implements DialogInterface.OnClickListener {
        public k() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            TDRTicketDetailsFragment tDRTicketDetailsFragment = TDRTicketDetailsFragment.this;
            if (tDRTicketDetailsFragment.f5132a) {
                if (!xx.T(tDRTicketDetailsFragment.et_gc_amount, "")) {
                    tDRTicketDetailsFragment.f5129a = Integer.valueOf(Integer.parseInt(tDRTicketDetailsFragment.et_gc_amount.getText().toString()));
                } else {
                    C0535I5.t0(tDRTicketDetailsFragment.f5123a, tDRTicketDetailsFragment.getString(R.string.Please_Enter_GC_Amount));
                }
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);
                try {
                    tDRTicketDetailsFragment.f5136c = new SimpleDateFormat("yyyyMMdd", locale).format(simpleDateFormat.parse(tDRTicketDetailsFragment.et_gc_date.getText().toString()));
                } catch (ParseException e) {
                    int i2 = TDRTicketDetailsFragment.e;
                    e.getMessage();
                }
                TDRTicketDetailsFragment.f(tDRTicketDetailsFragment, Long.valueOf(tDRTicketDetailsFragment.f5128a.getReservationId()), tDRTicketDetailsFragment.f5127a.getPassengerToken(), tDRTicketDetailsFragment.c, tDRTicketDetailsFragment.d, tDRTicketDetailsFragment.f5129a, tDRTicketDetailsFragment.et_eftGCnumber.getText().toString(), tDRTicketDetailsFragment.f5136c);
                return;
            }
            TDRTicketDetailsFragment.f(tDRTicketDetailsFragment, Long.valueOf(tDRTicketDetailsFragment.f5128a.getReservationId()), tDRTicketDetailsFragment.f5127a.getPassengerToken(), tDRTicketDetailsFragment.c, tDRTicketDetailsFragment.d, -1, "", "");
        }
    }

    static {
        C1354qp.R(TDRTicketDetailsFragment.class);
    }

    public static void f(TDRTicketDetailsFragment tDRTicketDetailsFragment, Long l, String str, int i2, int i3, Integer num, String str2, String str3) {
        Observable<StatusDTO> observable;
        if (!C0535I5.O((ConnectivityManager) tDRTicketDetailsFragment.getActivity().getSystemService("connectivity"), tDRTicketDetailsFragment.getContext())) {
            new Handler().postDelayed(new C1142gz(), 5000);
            return;
        }
        tDRTicketDetailsFragment.a = ProgressDialog.show(tDRTicketDetailsFragment.getActivity(), tDRTicketDetailsFragment.getString(R.string.file_tdr_txt), tDRTicketDetailsFragment.getString(R.string.please_wait_text));
        Om om = (Om) C0657Qt.c(C0793b1.a.f3912a);
        String f2 = C0657Qt.f();
        String format = String.format("/%s/%s/%s", new Object[]{l, str, Integer.valueOf(i2)});
        if (tDRTicketDetailsFragment.f5132a) {
            observable = om.x0(xx.D(f2, "fileTDR", format), Integer.valueOf(i3), num, str2, str3, "");
        } else {
            observable = om.x0(xx.D(f2, "fileTDR", format), Integer.valueOf(i3), -1, "", "", "");
        }
        observable.c(C1181iv.a()).a(E0.a()).b(new C1044q0(tDRTicketDetailsFragment));
    }

    @OnClick({2131362284})
    public void confirmCancelTicket() {
        if (this.f5128a.getReservationId() == null) {
            C0535I5.m(getActivity(), false, getString(R.string.invalid_transaction_id), getString(R.string.error), getString(R.string.OK), new a()).show();
        } else if (this.f5127a.getPassengerToken().equalsIgnoreCase("NNNNNN")) {
            C0535I5.m(getActivity(), false, getString(R.string.select_passengers_for_TDR), getString(R.string.error), getString(R.string.OK), new b()).show();
        } else {
            this.tdrReasonLl.setVisibility(0);
        }
    }

    @OnClick({2131362287})
    public void confirmFileTdrReasonClick() {
        long j2;
        if (this.c != 0) {
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);
            try {
                this.f5136c = new SimpleDateFormat("yyyyMMdd", locale).format(simpleDateFormat.parse(this.et_gc_date.getText().toString()));
            } catch (ParseException e2) {
                e2.getMessage();
            }
            String str = this.f5136c;
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
            Date journeyDate2 = this.f5128a.getJourneyDate();
            AlertDialog alertDialog = C0535I5.f3619a;
            new SimpleDateFormat("yyyy-MM-dd");
            try {
                j2 = TimeUnit.DAYS.convert(simpleDateFormat2.parse(str).getTime() - simpleDateFormat2.parse(new SimpleDateFormat("yyyyMMdd").format(journeyDate2)).getTime(), TimeUnit.MILLISECONDS);
            } catch (ParseException e3) {
                e3.getMessage();
                j2 = 0;
            }
            if (j2 > 7) {
                C0535I5.o(getActivity(), "please enter valid date", getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                this.f5135b = true;
            } else {
                this.f5135b = false;
            }
            if (!this.f5135b) {
                C0535I5.p(getActivity(), false, getString(R.string.do_you_want_TDR), getString(R.string.FILE_TDR_CONFIRMATION), getString(R.string.yes), new k(), getString(R.string.no), (DialogInterface.OnClickListener) null).show();
                return;
            }
            return;
        }
        C0535I5.m(getActivity(), false, getString(R.string.Please_select_TDR_reason), getString(R.string.file_tdr_txt), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    @OnClick({2131362288})
    public void confirmHide() {
        this.confirm_ll.setVisibility(8);
        this.tdrReasonLl.setVisibility(8);
        this.filledLl.setVisibility(8);
    }

    @OnClick({2131362671})
    public void finishedClick() {
        HomeActivity.B(getActivity());
        HomeActivity.n((AppCompatActivity) getActivity(), new TDRTicketFragment(), C1218kf.TDR_TICKET.a(), Boolean.TRUE, Boolean.FALSE);
    }

    public final void g(String str) {
        if (!C0535I5.O((ConnectivityManager) this.f5123a.getSystemService("connectivity"), this.f5123a)) {
            new Handler().postDelayed(new f(), 5000);
            return;
        }
        this.a = ProgressDialog.show(getActivity(), getString(R.string.Fetching_Ticket_Details), getString(R.string.please_wait_text));
        String f2 = C0657Qt.f();
        String format = String.format("/%s", new Object[]{str});
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).M0(f2 + "historySearchByTxnId" + format, RequestConfiguration.MAX_AD_CONTENT_RATING_T).c(C1181iv.a()).a(E0.a()).b(new g());
    }

    @OnClick({2131363324})
    public void noClick() {
        confirmHide();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.tdr_ticket_details_fragment, (ViewGroup) null);
        this.f5123a = getActivity();
        ButterKnife.bind((Object) this, inflate);
        this.f5124a = C0793b1.a.f3911a;
        BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) getArguments().getSerializable("tkt");
        this.f5128a = bookingResponseDTO;
        if (bookingResponseDTO.getDestArrvDate() != null) {
            C0535I5.f3621a.format(this.f5128a.getDestArrvDate());
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.filetdr_reason_bottom, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.tdr_confirmation_bottom, googleAdParamDTO);
        this.pnrFav.setVisibility(8);
        this.passengerList.setLayoutManager(new LinearLayoutManager(this.f5123a));
        this.pnr.setText(this.f5128a.getPnrNumber());
        this.trainName.setText(this.f5128a.getTrainName());
        TextView textView = this.trainno;
        textView.setText(" (" + this.f5128a.getTrainNumber() + ")");
        Date boardingDate = this.f5128a.getBoardingDate();
        SimpleDateFormat simpleDateFormat = this.f5130a;
        SimpleDateFormat simpleDateFormat2 = this.f5133b;
        if (boardingDate != null) {
            if (this.f5128a.getScheduleDepartureFlag().booleanValue()) {
                this.journeyTime.setText(simpleDateFormat.format(Long.valueOf(this.f5128a.getBoardingDate().getTime())));
            } else {
                TextView textView2 = this.journeyTime;
                textView2.setText(simpleDateFormat2.format(Long.valueOf(this.f5128a.getBoardingDate().getTime())) + "  *N.A.");
            }
        }
        if (this.f5128a.getDestArrvDate() != null) {
            if (this.f5128a.getScheduleDepartureFlag().booleanValue()) {
                this.destArrTime.setText(simpleDateFormat.format(this.f5128a.getDestArrvDate()));
            } else {
                TextView textView3 = this.destArrTime;
                textView3.setText(simpleDateFormat2.format(this.f5128a.getDestArrvDate()) + "  *N.A.");
            }
        }
        if (this.f5128a.getBoardingDate() != null) {
            this.journeyDate.setText(C0535I5.U(this.f5128a.getBoardingDate()));
        } else {
            this.journeyDate.setText(C0535I5.U(this.f5128a.getJourneyDate()));
        }
        TextView textView4 = this.fromcitycode;
        textView4.setText(this.f5124a.m(this.f5128a.getFromStn()) + " (" + this.f5128a.getFromStn() + ")");
        TextView textView5 = this.tocitycode;
        textView5.setText(this.f5124a.m(this.f5128a.getDestStn()) + " (" + this.f5128a.getDestStn() + ")");
        if (this.f5131a != null) {
            TDRTicketPassengerAdapter tDRTicketPassengerAdapter = new TDRTicketPassengerAdapter(this, this.f5131a);
            this.f5127a = tDRTicketPassengerAdapter;
            this.passengerList.setAdapter(tDRTicketPassengerAdapter);
            BookingResponseDTO bookingResponseDTO2 = this.f5128a;
            BookingResponseDTO bookingResponseDTO3 = this.b;
            bookingResponseDTO2.setJourneyClass(bookingResponseDTO3.getJourneyClass());
            this.f5128a.setJourneyQuota(bookingResponseDTO3.getJourneyQuota());
        } else if (TicketHistoryUtil.f5370a == TicketHistoryUtil.SortFor.TDR_HISTORY) {
            g(this.f5128a.getReservationId());
        } else {
            g(this.f5128a.getReservationId());
        }
        this.selectall.setOnClickListener(new c());
        this.et_gc_date.addTextChangedListener(this.f5126a);
        this.calender_carddob_rl.setOnClickListener(new d());
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
        this.selectall.setChecked(false);
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.a.dismiss();
        }
        C0535I5.u();
    }

    @OnClick({2131364073})
    public void tdrReasonClick() {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f5125a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f5125a.show(getFragmentManager(), "");
        this.f5125a.setCancelable(true);
        getFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(this.f5123a, this.f5134b, new j());
        this.f5125a.g().setText(getString(R.string.Select_TDR_Reason));
        this.f5125a.f().setAdapter(customAdapter);
    }

    @OnClick({2131364074})
    public void tdrResonLayoutHide() {
        this.tdrReasonLl.setVisibility(8);
    }

    @OnClick({2131364922})
    public void yesConfirm() {
        if (this.f5128a.getReservationId() == null) {
            C0535I5.m(getActivity(), false, getString(R.string.invalid_transaction_id), getString(R.string.error), getString(R.string.OK), new h()).show();
        } else if (this.f5127a.getPassengerToken().equalsIgnoreCase("NNNNNN")) {
            C0535I5.m(getActivity(), false, getString(R.string.select_passengers_for_TDR), getString(R.string.error), getString(R.string.OK), new i()).show();
        } else {
            this.tdrReasonLl.setVisibility(0);
        }
    }

    public class f implements Runnable {
        public final void run() {
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() == 10) {
                TDRTicketDetailsFragment tDRTicketDetailsFragment = TDRTicketDetailsFragment.this;
                C0535I5.I(tDRTicketDetailsFragment.getActivity());
                tDRTicketDetailsFragment.et_gc_date.clearFocus();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[Catch:{ NumberFormatException -> 0x00b0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00bf  */
        /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTextChanged(java.lang.CharSequence r7, int r8, int r9, int r10) {
            /*
                r6 = this;
                java.lang.String r7 = r7.toString()
                java.lang.String r8 = ""
                java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat
                java.lang.String r0 = "dd/mm/yyyy"
                r10.<init>(r0)
                r10 = 10
                int r0 = r7.length()     // Catch:{ NumberFormatException -> 0x00b2 }
                r1 = 2
                r2 = 1
                cris.org.in.ima.fragment.TDRTicketDetailsFragment r3 = cris.org.in.ima.fragment.TDRTicketDetailsFragment.this
                java.lang.String r4 = "/"
                if (r0 != r1) goto L_0x0042
                if (r9 != 0) goto L_0x0042
                int r0 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x00b2 }
                if (r0 < r2) goto L_0x003f
                int r0 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x00b2 }
                r1 = 31
                if (r0 <= r1) goto L_0x002c
                goto L_0x003f
            L_0x002c:
                java.lang.String r7 = r7.concat(r4)     // Catch:{ NumberFormatException -> 0x00b2 }
                android.widget.EditText r0 = r3.et_gc_date     // Catch:{ NumberFormatException -> 0x00b2 }
                r0.setText(r7)     // Catch:{ NumberFormatException -> 0x00b2 }
                android.widget.EditText r0 = r3.et_gc_date     // Catch:{ NumberFormatException -> 0x00b2 }
                int r1 = r7.length()     // Catch:{ NumberFormatException -> 0x00b2 }
                r0.setSelection(r1)     // Catch:{ NumberFormatException -> 0x00b2 }
                goto L_0x0042
            L_0x003f:
                java.lang.String r0 = " Enter Date between 1 to 31"
                goto L_0x0043
            L_0x0042:
                r0 = r8
            L_0x0043:
                int r1 = r7.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r5 = 5
                if (r1 != r5) goto L_0x0075
                if (r9 != 0) goto L_0x0075
                r1 = 3
                java.lang.String r1 = r7.substring(r1)     // Catch:{ NumberFormatException -> 0x00b0 }
                int r5 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r5 < r2) goto L_0x0073
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x00b0 }
                r5 = 12
                if (r1 <= r5) goto L_0x0060
                goto L_0x0073
            L_0x0060:
                java.lang.String r7 = r7.concat(r4)     // Catch:{ NumberFormatException -> 0x00b0 }
                android.widget.EditText r1 = r3.et_gc_date     // Catch:{ NumberFormatException -> 0x00b0 }
                r1.setText(r7)     // Catch:{ NumberFormatException -> 0x00b0 }
                android.widget.EditText r1 = r3.et_gc_date     // Catch:{ NumberFormatException -> 0x00b0 }
                int r4 = r7.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r1.setSelection(r4)     // Catch:{ NumberFormatException -> 0x00b0 }
                goto L_0x0075
            L_0x0073:
                java.lang.String r0 = "Enter Month Between 1 to 12"
            L_0x0075:
                int r1 = r7.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r1 != r10) goto L_0x00ad
                if (r9 != 0) goto L_0x00ad
                r9 = 6
                java.lang.String r9 = r7.substring(r9)     // Catch:{ NumberFormatException -> 0x00b0 }
                java.util.Calendar r1 = java.util.Calendar.getInstance()     // Catch:{ NumberFormatException -> 0x00b0 }
                int r1 = r1.get(r2)     // Catch:{ NumberFormatException -> 0x00b0 }
                int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x00b0 }
                r4 = 1900(0x76c, float:2.662E-42)
                if (r2 <= r4) goto L_0x00aa
                int r2 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r2 <= r1) goto L_0x00a0
                r1 = 0
                char r9 = r9.charAt(r1)     // Catch:{ NumberFormatException -> 0x00b0 }
                if (r9 != 0) goto L_0x00a0
                goto L_0x00aa
            L_0x00a0:
                android.widget.EditText r9 = r3.et_gc_date     // Catch:{ NumberFormatException -> 0x00b0 }
                int r1 = r7.length()     // Catch:{ NumberFormatException -> 0x00b0 }
                r9.setSelection(r1)     // Catch:{ NumberFormatException -> 0x00b0 }
                goto L_0x00b9
            L_0x00aa:
                java.lang.String r0 = "Please Enter Valid Year "
                goto L_0x00b9
            L_0x00ad:
                java.lang.String r0 = "Invalid Date Format"
                goto L_0x00b9
            L_0x00b0:
                r9 = move-exception
                goto L_0x00b4
            L_0x00b2:
                r9 = move-exception
                r0 = r8
            L_0x00b4:
                int r1 = cris.org.in.ima.fragment.TDRTicketDetailsFragment.e
                r9.getMessage()
            L_0x00b9:
                int r7 = r7.length()
                if (r7 == r10) goto L_0x00c2
                r0.equalsIgnoreCase(r8)
            L_0x00c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.TDRTicketDetailsFragment.e.onTextChanged(java.lang.CharSequence, int, int, int):void");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
