package cris.org.in.ima.view_holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

public final class ErsTrainDeatilLapwiseViewHolder extends RecyclerView.Adapter<ErsPassengerItemHolder> {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5386a;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f5387a = new SimpleDateFormat("HH:mm");

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<C1188j3> f5388a;

    public class ErsPassengerItemHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with other field name */
        public C1188j3 f5389a;
        @BindView(2131362066)
        LinearLayout booking_status_ll;
        @BindView(2131362765)
        TextView header_fromstn;
        @BindView(2131362768)
        TextView header_tomstn;
        @BindView(2131362769)
        TextView header_total_duration;
        @BindView(2131362935)
        TextView lap1_heading;
        @BindView(2131363030)
        LinearLayout ll_from_to_header_lap;
        @BindView(2131363084)
        LinearLayout ll_tainname_haedind_lap1;
        @BindView(2131363209)
        RadioButton menu_option_lapwise;
        @BindView(2131363509)
        RelativeLayout pnr_detail;
        @BindView(2131363518)
        TextView pnr_no;
        @BindView(2131363547)
        TextView psgnCount_Class_Quota;
        @BindView(2131363586)
        LinearLayout radio_button_ll;
        @BindView(2131363936)
        TextView selected_train_name;
        @BindView(2131363938)
        TextView selected_train_number;
        @BindView(2131364062)
        LinearLayout tain_detail_ll;
        @BindView(2131364234)
        TextView travel_Time;
        @BindView(2131364250)
        LinearLayout travel_time_ll;
        @BindView(2131364297)
        TextView tv_arv_date;
        @BindView(2131364299)
        TextView tv_arv_timee;
        @BindView(2131364320)
        TextView tv_bookstatus;
        @BindView(2131364360)
        TextView tv_dep_date;
        @BindView(2131364362)
        TextView tv_dep_time;
        @BindView(2131364424)
        TextView tv_from_stationname;
        @BindView(2131364540)
        TextView tv_prs_failmsg;
        @BindView(2131364673)
        TextView tv_to_stationname;

        public ErsPassengerItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131363209})
        public void radiobuttonClick(View view) {
            a aVar = ErsTrainDeatilLapwiseViewHolder.this.f5386a;
            if (aVar != null) {
                C1188j3 j3Var = this.f5389a;
                ErsDisplayFragment.q qVar = (ErsDisplayFragment.q) aVar;
                qVar.getClass();
                BookingResponseDTO bookingResponseDTO = j3Var.a;
                ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
                ersDisplayFragment.f4577a = bookingResponseDTO;
                Iterator<C1188j3> it = ersDisplayFragment.f4599e.iterator();
                while (it.hasNext()) {
                    C1188j3 next = it.next();
                    next.f5519a = false;
                    if (j3Var.a.getTrainNumber().equalsIgnoreCase(next.a.getTrainNumber())) {
                        j3Var.f5519a = true;
                    }
                }
                ersDisplayFragment.f4576a.notifyDataSetChanged();
            }
        }
    }

    public class ErsPassengerItemHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ErsPassengerItemHolder f5390a;

        /* compiled from: ErsTrainDeatilLapwiseViewHolder$ErsPassengerItemHolder_ViewBinding */
        public class a extends DebouncingOnClickListener {
            public final /* synthetic */ ErsPassengerItemHolder a;

            public a(ErsPassengerItemHolder ersPassengerItemHolder) {
                this.a = ersPassengerItemHolder;
            }

            public final void doClick(View view) {
                this.a.radiobuttonClick(view);
            }
        }

        public ErsPassengerItemHolder_ViewBinding(ErsPassengerItemHolder ersPassengerItemHolder, View view) {
            this.f5390a = ersPassengerItemHolder;
            Class cls = LinearLayout.class;
            ersPassengerItemHolder.ll_from_to_header_lap = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_from_to_header_lap, "field 'll_from_to_header_lap'", cls);
            Class cls2 = TextView.class;
            ersPassengerItemHolder.header_fromstn = (TextView) Utils.findRequiredViewAsType(view, R.id.header_fromstn, "field 'header_fromstn'", cls2);
            ersPassengerItemHolder.header_tomstn = (TextView) Utils.findRequiredViewAsType(view, R.id.header_tomstn, "field 'header_tomstn'", cls2);
            ersPassengerItemHolder.header_total_duration = (TextView) Utils.findRequiredViewAsType(view, R.id.header_total_duration, "field 'header_total_duration'", cls2);
            ersPassengerItemHolder.ll_tainname_haedind_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_tainname_haedind_lap1, "field 'll_tainname_haedind_lap1'", cls);
            ersPassengerItemHolder.lap1_heading = (TextView) Utils.findRequiredViewAsType(view, R.id.lap1_heading, "field 'lap1_heading'", cls2);
            ersPassengerItemHolder.selected_train_name = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_train_name, "field 'selected_train_name'", cls2);
            ersPassengerItemHolder.selected_train_number = (TextView) Utils.findRequiredViewAsType(view, R.id.selected_train_number, "field 'selected_train_number'", cls2);
            ersPassengerItemHolder.pnr_detail = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.pnr_detail, "field 'pnr_detail'", RelativeLayout.class);
            ersPassengerItemHolder.tain_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tain_detail_ll, "field 'tain_detail_ll'", cls);
            ersPassengerItemHolder.tv_dep_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dep_time, "field 'tv_dep_time'", cls2);
            ersPassengerItemHolder.travel_Time = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_Time, "field 'travel_Time'", cls2);
            ersPassengerItemHolder.tv_arv_timee = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arv_timee, "field 'tv_arv_timee'", cls2);
            ersPassengerItemHolder.tv_dep_date = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dep_date, "field 'tv_dep_date'", cls2);
            ersPassengerItemHolder.tv_arv_date = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_arv_date, "field 'tv_arv_date'", cls2);
            ersPassengerItemHolder.tv_from_stationname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_from_stationname, "field 'tv_from_stationname'", cls2);
            ersPassengerItemHolder.tv_to_stationname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_to_stationname, "field 'tv_to_stationname'", cls2);
            ersPassengerItemHolder.psgnCount_Class_Quota = (TextView) Utils.findRequiredViewAsType(view, R.id.psgnCount_Class_Quota, "field 'psgnCount_Class_Quota'", cls2);
            ersPassengerItemHolder.pnr_no = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr_no, "field 'pnr_no'", cls2);
            ersPassengerItemHolder.travel_time_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_time_ll, "field 'travel_time_ll'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.menu_option_lapwise, "field 'menu_option_lapwise' and method 'radiobuttonClick'");
            ersPassengerItemHolder.menu_option_lapwise = (RadioButton) Utils.castView(findRequiredView, R.id.menu_option_lapwise, "field 'menu_option_lapwise'", RadioButton.class);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(ersPassengerItemHolder));
            ersPassengerItemHolder.radio_button_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.radio_button_ll, "field 'radio_button_ll'", cls);
            ersPassengerItemHolder.tv_prs_failmsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_prs_failmsg, "field 'tv_prs_failmsg'", cls2);
            ersPassengerItemHolder.tv_bookstatus = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bookstatus, "field 'tv_bookstatus'", cls2);
            ersPassengerItemHolder.booking_status_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.booking_status_ll, "field 'booking_status_ll'", cls);
        }

        public final void unbind() {
            ErsPassengerItemHolder ersPassengerItemHolder = this.f5390a;
            if (ersPassengerItemHolder != null) {
                this.f5390a = null;
                ersPassengerItemHolder.ll_from_to_header_lap = null;
                ersPassengerItemHolder.header_fromstn = null;
                ersPassengerItemHolder.header_tomstn = null;
                ersPassengerItemHolder.header_total_duration = null;
                ersPassengerItemHolder.ll_tainname_haedind_lap1 = null;
                ersPassengerItemHolder.lap1_heading = null;
                ersPassengerItemHolder.selected_train_name = null;
                ersPassengerItemHolder.selected_train_number = null;
                ersPassengerItemHolder.pnr_detail = null;
                ersPassengerItemHolder.tain_detail_ll = null;
                ersPassengerItemHolder.tv_dep_time = null;
                ersPassengerItemHolder.travel_Time = null;
                ersPassengerItemHolder.tv_arv_timee = null;
                ersPassengerItemHolder.tv_dep_date = null;
                ersPassengerItemHolder.tv_arv_date = null;
                ersPassengerItemHolder.tv_from_stationname = null;
                ersPassengerItemHolder.tv_to_stationname = null;
                ersPassengerItemHolder.psgnCount_Class_Quota = null;
                ersPassengerItemHolder.pnr_no = null;
                ersPassengerItemHolder.travel_time_ll = null;
                ersPassengerItemHolder.menu_option_lapwise = null;
                ersPassengerItemHolder.radio_button_ll = null;
                ersPassengerItemHolder.tv_prs_failmsg = null;
                ersPassengerItemHolder.tv_bookstatus = null;
                ersPassengerItemHolder.booking_status_ll = null;
                this.a.setOnClickListener((View.OnClickListener) null);
                this.a = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface a {
    }

    static {
        C1354qp.R(ErsTrainDeatilLapwiseViewHolder.class);
    }

    public ErsTrainDeatilLapwiseViewHolder(Context context, ArrayList arrayList, ErsDisplayFragment.q qVar) {
        this.a = context;
        this.f5386a = qVar;
        this.f5388a = arrayList;
    }

    public static Date a(Date date, Date date2) {
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

    public final int getItemCount() {
        return this.f5388a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        int i3;
        int i4;
        ErsPassengerItemHolder ersPassengerItemHolder = (ErsPassengerItemHolder) viewHolder;
        C1188j3 j3Var = this.f5388a.get(i);
        BookingResponseDTO bookingResponseDTO = j3Var.a;
        ersPassengerItemHolder.f5389a = j3Var;
        new ErsDisplayFragment();
        if (bookingResponseDTO != null) {
            bookingResponseDTO.toString();
            if (C0535I5.f3650k || C0535I5.f3647h) {
                ersPassengerItemHolder.lap1_heading.setVisibility(0);
                ersPassengerItemHolder.lap1_heading.setText("LAP " + (i + 1) + " ");
            } else {
                ersPassengerItemHolder.lap1_heading.setVisibility(8);
            }
            ersPassengerItemHolder.pnr_no.setText(bookingResponseDTO.getPnrNumber());
            ersPassengerItemHolder.selected_train_name.setText(bookingResponseDTO.getTrainName());
            ersPassengerItemHolder.selected_train_number.setText("(" + bookingResponseDTO.getTrainNumber() + ")");
            Boolean scheduleDepartureFlag = bookingResponseDTO.getScheduleDepartureFlag();
            Context context = this.a;
            if (scheduleDepartureFlag == null || !bookingResponseDTO.getScheduleDepartureFlag().booleanValue()) {
                ersPassengerItemHolder.tv_dep_time.setText(" *N.A.");
                ersPassengerItemHolder.travel_time_ll.setVisibility(8);
                xx.P(context, R.string.total_duration, ersPassengerItemHolder.header_total_duration);
            } else {
                if (bookingResponseDTO.getDepartureTime() != null) {
                    ersPassengerItemHolder.tv_dep_time.setText(C0535I5.b(bookingResponseDTO.getDepartureTime()));
                } else if (bookingResponseDTO.getBoardingDate() != null) {
                    TextView textView = ersPassengerItemHolder.tv_dep_time;
                    Date boardingDate = bookingResponseDTO.getBoardingDate();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
                    textView.setText(simpleDateFormat.format(boardingDate));
                }
                ersPassengerItemHolder.travel_time_ll.setVisibility(0);
            }
            if (bookingResponseDTO.getScheduleArrivalFlag() == null || !bookingResponseDTO.getScheduleArrivalFlag().booleanValue()) {
                ersPassengerItemHolder.tv_arv_timee.setText(" *N.A.");
                ersPassengerItemHolder.travel_time_ll.setVisibility(8);
                xx.P(context, R.string.total_duration, ersPassengerItemHolder.header_total_duration);
            } else {
                if (bookingResponseDTO.getArrivalTime() != null) {
                    ersPassengerItemHolder.tv_arv_timee.setText(C0535I5.b(bookingResponseDTO.getArrivalTime()));
                } else if (bookingResponseDTO.getDestArrvDate() != null) {
                    TextView textView2 = ersPassengerItemHolder.tv_arv_timee;
                    Date destArrvDate = bookingResponseDTO.getDestArrvDate();
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
                    simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
                    textView2.setText(simpleDateFormat2.format(destArrvDate));
                }
                ersPassengerItemHolder.travel_time_ll.setVisibility(0);
            }
            ersPassengerItemHolder.tv_dep_date.setText(C0535I5.d(bookingResponseDTO.getBoardingDate()));
            ersPassengerItemHolder.tv_arv_date.setText(C0535I5.d(bookingResponseDTO.getDestArrvDate()));
            StationDb stationDb = C0793b1.a.f3911a;
            ersPassengerItemHolder.tv_from_stationname.setText(C0535I5.s0(stationDb.m(bookingResponseDTO.getBoardingStn())) + " (" + bookingResponseDTO.getBoardingStn() + ")");
            ersPassengerItemHolder.tv_to_stationname.setText(C0535I5.s0(stationDb.m(bookingResponseDTO.getDestStn())) + " (" + bookingResponseDTO.getDestStn() + ")");
            ersPassengerItemHolder.header_fromstn.setText(bookingResponseDTO.getFromStn());
            ersPassengerItemHolder.header_tomstn.setText(bookingResponseDTO.getDestStn());
            if (bookingResponseDTO.getReservationStatus() != null && bookingResponseDTO.getReservationStatus().equalsIgnoreCase("cancelled")) {
                xx.P(context, R.string.CANCELLED, ersPassengerItemHolder.tv_bookstatus);
                C1058d.H(context, R.color.dark_red, ersPassengerItemHolder.tv_bookstatus);
            } else if (bookingResponseDTO.getReservationStatus() != null && bookingResponseDTO.getReservationStatus().equalsIgnoreCase("Booked")) {
                xx.P(context, R.string.BOOKED, ersPassengerItemHolder.tv_bookstatus);
                C1058d.H(context, R.color.green, ersPassengerItemHolder.tv_bookstatus);
            } else if (bookingResponseDTO.getReservationStatus() != null && bookingResponseDTO.getReservationStatus().equalsIgnoreCase("Partial Cancelled")) {
                xx.P(context, R.string.Partial_Cancelled, ersPassengerItemHolder.tv_bookstatus);
                C1058d.H(context, R.color.green, ersPassengerItemHolder.tv_bookstatus);
            } else if (bookingResponseDTO.getReservationStatus() == null || !bookingResponseDTO.getReservationStatus().equalsIgnoreCase("TDR Entered")) {
                ersPassengerItemHolder.booking_status_ll.setVisibility(8);
            } else {
                xx.P(context, R.string.TDR_ENTERED, ersPassengerItemHolder.tv_bookstatus);
                C1058d.H(context, R.color.bg_passenger_transgender1, ersPassengerItemHolder.tv_bookstatus);
            }
            if (bookingResponseDTO.getJourneyQuota() == null || !bookingResponseDTO.getJourneyQuota().equals("PQ")) {
                H9.f(bookingResponseDTO.getJourneyQuota());
            } else {
                H9.f("GN");
            }
            String str = "";
            if (C0535I5.f3650k) {
                try {
                    i4 = Integer.parseInt(bookingResponseDTO.getNoOfBkdChild()) - Integer.parseInt(bookingResponseDTO.getNoOfCanChild());
                } catch (NumberFormatException e) {
                    e.getMessage();
                    i4 = 0;
                }
                if (bookingResponseDTO.getNoOfBkdPsgn() != null && bookingResponseDTO.getNoOfCanPsgn() != null && !bookingResponseDTO.getNoOfBkdPsgn().trim().equalsIgnoreCase(str) && !bookingResponseDTO.getNoOfCanPsgn().trim().equalsIgnoreCase(str)) {
                    str = str + String.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdPsgn()) - i4) + " " + context.getResources().getString(R.string.adult) + " ";
                }
                if (!(bookingResponseDTO.getNoOfBkdChild() == null || bookingResponseDTO.getNoOfCanChild() == null)) {
                    StringBuilder J = xx.J(str);
                    J.append(String.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdChild().trim())));
                    J.append(" ");
                    J.append(context.getResources().getString(R.string.child));
                    J.append(" ");
                    str = J.toString();
                }
                if (bookingResponseDTO.getJourneyClass() != null) {
                    if (xx.e(bookingResponseDTO.getJourneyClass()) != null) {
                        StringBuilder n = lf.n(str, " | ");
                        n.append(xx.e(bookingResponseDTO.getJourneyClass()));
                        str = n.toString();
                    } else {
                        StringBuilder n2 = lf.n(str, " | ");
                        n2.append(bookingResponseDTO.getJourneyClass());
                        str = n2.toString();
                    }
                }
                if (bookingResponseDTO.getJourneyQuota() != null) {
                    if (H9.f(bookingResponseDTO.getJourneyQuota()) != null) {
                        StringBuilder n3 = lf.n(str, " | ");
                        n3.append(H9.f(bookingResponseDTO.getJourneyQuota()));
                        str = n3.toString();
                    } else {
                        StringBuilder n4 = lf.n(str, " | ");
                        n4.append(bookingResponseDTO.getJourneyQuota());
                        str = n4.toString();
                    }
                }
                StringBuilder n5 = lf.n(str, " | ");
                n5.append(C0535I5.s0(stationDb.m(bookingResponseDTO.getFromStn())));
                n5.append(" (");
                n5.append(bookingResponseDTO.getFromStn());
                n5.append(")");
                StringBuilder n6 = lf.n(n5.toString(), " | ");
                n6.append(C0535I5.h(bookingResponseDTO.getBoardingDate()));
                String sb = n6.toString();
                if (bookingResponseDTO.getBoardingDate() != null) {
                    StringBuilder n7 = lf.n(sb, " | ");
                    n7.append(this.f5387a.format(bookingResponseDTO.getBoardingDate()));
                    sb = n7.toString();
                }
                ersPassengerItemHolder.psgnCount_Class_Quota.setText(sb);
            } else {
                if (!C0535I5.f3651l) {
                    try {
                        i3 = Integer.parseInt(bookingResponseDTO.getNoOfBkdChild()) - Integer.parseInt(bookingResponseDTO.getNoOfCanChild());
                    } catch (NumberFormatException e2) {
                        e2.getMessage();
                        i3 = 0;
                    }
                    if (bookingResponseDTO.getNoOfBkdPsgn() != null && bookingResponseDTO.getNoOfCanPsgn() != null && !bookingResponseDTO.getNoOfBkdPsgn().trim().equalsIgnoreCase(str) && !bookingResponseDTO.getNoOfCanPsgn().trim().equalsIgnoreCase(str)) {
                        str = str + String.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdPsgn()) - i3) + " " + context.getResources().getString(R.string.adult) + " ";
                    }
                    if (!(bookingResponseDTO.getNoOfBkdChild() == null || bookingResponseDTO.getNoOfCanChild() == null)) {
                        StringBuilder J2 = xx.J(str);
                        J2.append(String.valueOf(Integer.parseInt(bookingResponseDTO.getNoOfBkdChild().trim())));
                        J2.append(" ");
                        J2.append(context.getResources().getString(R.string.child));
                        J2.append(" ");
                        str = J2.toString();
                    }
                } else if (bookingResponseDTO.getNumberOfAdults() != null) {
                    StringBuilder J3 = xx.J(str + bookingResponseDTO.getNumberOfAdults().toString() + " " + context.getResources().getString(R.string.adult) + " ");
                    J3.append(bookingResponseDTO.getNumberOfChilds().toString());
                    J3.append(" ");
                    J3.append(context.getResources().getString(R.string.child));
                    J3.append(" ");
                    str = J3.toString();
                }
                if (bookingResponseDTO.getJourneyClass() != null) {
                    StringBuilder n8 = lf.n(str, " | ");
                    n8.append(bookingResponseDTO.getJourneyClass());
                    str = n8.toString();
                }
                if (bookingResponseDTO.getJourneyQuota() != null) {
                    if (H9.f(bookingResponseDTO.getJourneyQuota()) != null) {
                        StringBuilder n9 = lf.n(str, " | ");
                        n9.append(H9.f(bookingResponseDTO.getJourneyQuota()).a());
                        str = n9.toString();
                    } else {
                        StringBuilder n10 = lf.n(str, " | ");
                        n10.append(bookingResponseDTO.getJourneyQuota());
                        str = n10.toString();
                    }
                }
                StringBuilder n11 = lf.n(str, " | ");
                n11.append(C0535I5.s0(stationDb.m(bookingResponseDTO.getFromStn())));
                n11.append(" (");
                n11.append(bookingResponseDTO.getFromStn());
                n11.append(")");
                String sb2 = n11.toString();
                if (bookingResponseDTO.getJourneyDate() != null) {
                    StringBuilder n12 = lf.n(sb2, " | ");
                    n12.append(C0535I5.h(bookingResponseDTO.getJourneyDate()));
                    sb2 = n12.toString();
                }
                ersPassengerItemHolder.psgnCount_Class_Quota.setText(sb2);
            }
            if (bookingResponseDTO.getScheduleArrivalFlag() != null && bookingResponseDTO.getScheduleArrivalFlag().booleanValue()) {
                if (bookingResponseDTO.getDepartureTime() != null && bookingResponseDTO.getArrivalTime() != null) {
                    ersPassengerItemHolder.travel_Time.setVisibility(0);
                    ersPassengerItemHolder.header_total_duration.setVisibility(0);
                    try {
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("HH:mm");
                        Date parse = simpleDateFormat3.parse(bookingResponseDTO.getDepartureTime());
                        Date parse2 = simpleDateFormat3.parse(bookingResponseDTO.getArrivalTime());
                        ersPassengerItemHolder.header_total_duration.setText(context.getResources().getString(R.string.Total_Duration) + C0535I5.A(a(bookingResponseDTO.getBoardingDate(), parse), a(bookingResponseDTO.getDestArrvDate(), parse2)));
                        ersPassengerItemHolder.travel_Time.setText(C0535I5.A(a(bookingResponseDTO.getBoardingDate(), parse), a(bookingResponseDTO.getDestArrvDate(), parse2)));
                    } catch (Exception e3) {
                        e3.getMessage();
                    }
                } else if (bookingResponseDTO.getBoardingDate() == null || bookingResponseDTO.getDestArrvDate() == null) {
                    ersPassengerItemHolder.travel_Time.setVisibility(8);
                    ersPassengerItemHolder.header_total_duration.setVisibility(8);
                } else {
                    ersPassengerItemHolder.travel_Time.setVisibility(0);
                    ersPassengerItemHolder.header_total_duration.setVisibility(0);
                    ersPassengerItemHolder.header_total_duration.setText(context.getResources().getString(R.string.Total_Duration) + C0535I5.A(bookingResponseDTO.getBoardingDate(), bookingResponseDTO.getDestArrvDate()));
                    ersPassengerItemHolder.travel_Time.setText(C0535I5.A(bookingResponseDTO.getBoardingDate(), bookingResponseDTO.getDestArrvDate()));
                }
            }
            if (j3Var.f5519a) {
                ersPassengerItemHolder.menu_option_lapwise.setChecked(true);
            } else {
                ersPassengerItemHolder.menu_option_lapwise.setChecked(false);
            }
            if (C0535I5.f3650k || C0535I5.f3647h) {
                ersPassengerItemHolder.ll_from_to_header_lap.setVisibility(0);
                i2 = 0;
            } else {
                ersPassengerItemHolder.ll_tainname_haedind_lap1.setBackgroundColor(context.getResources().getColor(R.color.white));
                ersPassengerItemHolder.ll_from_to_header_lap.setVisibility(8);
                i2 = 0;
            }
            if (C0535I5.f3650k) {
                ersPassengerItemHolder.menu_option_lapwise.setVisibility(i2);
            } else {
                ersPassengerItemHolder.menu_option_lapwise.setVisibility(8);
            }
            if (bookingResponseDTO.getPnrNumber() == null) {
                ersPassengerItemHolder.tv_prs_failmsg.setText(context.getResources().getString(R.string.ticket_not_book_for_lap) + (i + 1));
                ersPassengerItemHolder.tv_prs_failmsg.setVisibility(0);
            } else {
                ersPassengerItemHolder.tv_prs_failmsg.setVisibility(8);
            }
            if ((bookingResponseDTO.getReservationStatus() != null && bookingResponseDTO.getReservationStatus().equalsIgnoreCase("cancelled")) || bookingResponseDTO.getPnrNumber() == null || ErsDisplayFragment.e) {
                ersPassengerItemHolder.menu_option_lapwise.setVisibility(8);
            } else if (C0535I5.f3650k) {
                ersPassengerItemHolder.menu_option_lapwise.setVisibility(0);
            }
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.ers_train_detail_lapwise, (ViewGroup) null);
        ErsPassengerItemHolder ersPassengerItemHolder = new ErsPassengerItemHolder(r);
        xx.O(-1, -2, r);
        return ersPassengerItemHolder;
    }
}
