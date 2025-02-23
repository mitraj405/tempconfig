package cris.org.in.ima.adaptors;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.RequestConfiguration;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.AvailabilityViewHolder;
import cris.org.in.ima.adaptors.AvailabilitywithClassFareViewHolder;
import cris.org.in.ima.adaptors.AvlClassViewHolder;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.fragment.AllTrainListFragment;
import cris.org.in.ima.fragment.LapAllTrainListFragment;
import cris.org.in.ima.model.AvlClassModel;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.ima.model.WrapperAvailablityWithClassFareModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.ClassAvlDTO;
import cris.prs.webservices.dto.StatusDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import defpackage.d7;
import in.juspay.hypersdk.core.PaymentConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import rx.Subscriber;

public class LapTrainListAdapter extends RecyclerView.Adapter<TrainListItemHolder> {
    /* access modifiers changed from: private */
    public static final String TAG = C1354qp.R(LapTrainListAdapter.class);
    static TrainBtwnStnsModel currentItem;
    private AvailabilitywithClassFareViewHolder.AvailabilityViewHolderListener availabilityClassFareListener = new AvailabilitywithClassFareViewHolder.AvailabilityViewHolderListener() {
        public void onItemClick(WrapperAvailablityWithClassFareModel wrapperAvailablityWithClassFareModel, TrainBtwnStnsModel trainBtwnStnsModel, boolean z) {
        }
    };
    AvailabilitywithClassFareViewHolder availabilitywithClassFareViewHolder;
    ProgressDialog dialog;
    private String fromStn;
    Lap2TrainListHAdapterListener listener;
    /* access modifiers changed from: private */
    public TrainTypeAdaptor mAdapter;
    AvailabilityViewHolder.AvailabilityViewHolderListener mAvailabilityListener;
    public AvlClassViewHolder.AvlClassViewHolderListener mAvlClsHolderListener = new AvlClassViewHolder.AvlClassViewHolderListener() {
        public void onItemClick(AvlClassModel avlClassModel) {
            Iterator<TrainBtwnStnsModel> it = LapTrainListAdapter.this.trainBtwnStnsModels.iterator();
            int i = -1;
            while (true) {
                if (!it.hasNext()) {
                    i = 0;
                    break;
                }
                TrainBtwnStnsModel next = it.next();
                i++;
                Boolean bool = Boolean.FALSE;
                next.f5344a = bool;
                next.c = bool;
                if (AllTrainListFragment.f4414b != null && next.f5342a.getTrainNumber().equals(AllTrainListFragment.f4414b.f5342a.getTrainNumber())) {
                    next.c = Boolean.TRUE;
                    Lap2TrainListHAdapterListener lap2TrainListHAdapterListener = LapTrainListAdapter.this.listener;
                    if (lap2TrainListHAdapterListener != null) {
                        lap2TrainListHAdapterListener.onTrainLayoutClick(AllTrainListFragment.f4414b, true, true);
                    }
                }
            }
            if (AllTrainListFragment.f4414b != null) {
                LapTrainListAdapter.this.notifyItemChanged(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;
    private ArrayList<C0503FA> mTrainList;
    int retryCount = 0;
    private String selectedQuota;
    String spConcession = "";
    StationDb stationDb = C0793b1.a.f3911a;
    private String toStn;
    private Integer totalDuration;
    List<TrainBtwnStnsModel> trainBtwnStnsModels;
    private Integer waitingTime;

    public interface Lap2TrainListHAdapterListener {
        void onCheckAvailbialityClick(TrainBtwnStnsModel trainBtwnStnsModel);

        void onQuotaClick(TrainBtwnStnsModel trainBtwnStnsModel);

        void onTrainLayoutClick(TrainBtwnStnsModel trainBtwnStnsModel, boolean z, boolean z2);
    }

    public class TrainListItemHolder extends RecyclerView.ViewHolder {
        TextView arrDate;
        TextView arvTime;
        LinearLayout avl_other_date_ll;
        TextView checkAvailiability;
        LinearLayout cnf_probability_ll;
        TextView depDate;
        TextView depTime;
        TextView friday;
        TextView fromCityCode;
        TextView fromCityName;
        TextView journeyDateViaDuration;
        TextView lapHeading;
        LinearLayout llCheckAvailability;
        LinearLayout llWaitDuration;
        LinearLayout ll_changeover_msg;
        TextView monday;
        LinearLayout other_dates_cnf_update_ll;
        TextView quota;
        LinearLayout quotaLayout;
        ImageView routMap;
        RecyclerView rvAvailabilityList;
        RecyclerView rvClassFareAvl;
        RecyclerView rvTrainClass;
        TextView saturday;
        LinearLayout sourceDestHeadingLayout;
        TextView sourceDestStn;
        TextView sunday;
        TextView thursday;
        TextView toCityCode;
        TextView toCityName;
        CardView trainDetail;
        TextView trainName;
        TextView trainNo;
        ImageView traintyColor;
        TextView travelTime;
        TextView tuesday;
        TextView tv_avl_updates;
        TextView tv_changeover_msg;
        TextView tv_close;
        TextView tv_cnf_probability;
        ImageView tv_favpnricon;
        TextView tv_otherdate;
        TextView waitDuration;
        TextView wednesday;

        public TrainListItemHolder(View view) {
            super(view);
            this.trainDetail = (CardView) view.findViewById(R.id.rl_train_detail_parent_layout);
            this.trainNo = (TextView) view.findViewById(R.id.tv_train_no);
            this.trainName = (TextView) view.findViewById(R.id.tv_train_name);
            this.fromCityName = (TextView) view.findViewById(R.id.tv_from_city_name);
            this.fromCityCode = (TextView) view.findViewById(R.id.tv_from_city_code);
            this.toCityName = (TextView) view.findViewById(R.id.tv_to_city_name);
            this.toCityCode = (TextView) view.findViewById(R.id.tv_to_city_code);
            this.depTime = (TextView) view.findViewById(R.id.dep_time);
            this.arvTime = (TextView) view.findViewById(R.id.arv_time);
            this.travelTime = (TextView) view.findViewById(R.id.travel_time);
            this.routMap = (ImageView) view.findViewById(R.id.iv_routmap);
            this.sunday = (TextView) view.findViewById(R.id.tv_sunday);
            this.monday = (TextView) view.findViewById(R.id.tv_monday);
            this.tuesday = (TextView) view.findViewById(R.id.tv_tuesday);
            this.wednesday = (TextView) view.findViewById(R.id.tv_wednesday);
            this.thursday = (TextView) view.findViewById(R.id.tv_thursday);
            this.friday = (TextView) view.findViewById(R.id.tv_friday);
            this.saturday = (TextView) view.findViewById(R.id.tv_saturday);
            this.traintyColor = (ImageView) view.findViewById(R.id.tv_color);
            this.rvClassFareAvl = (RecyclerView) view.findViewById(R.id.rv_class_fare_avl);
            this.rvTrainClass = (RecyclerView) view.findViewById(R.id.rv_train_class);
            this.rvAvailabilityList = (RecyclerView) view.findViewById(R.id.rv_availability_list);
            this.tv_otherdate = (TextView) view.findViewById(R.id.tv_otherdate);
            this.tv_cnf_probability = (TextView) view.findViewById(R.id.tv_cnf_probability);
            this.tv_avl_updates = (TextView) view.findViewById(R.id.tv_avl_updates);
            this.tv_close = (TextView) view.findViewById(R.id.tv_close);
            this.avl_other_date_ll = (LinearLayout) view.findViewById(R.id.avl_other_date_ll);
            this.other_dates_cnf_update_ll = (LinearLayout) view.findViewById(R.id.other_dates_cnf_update_ll);
            this.cnf_probability_ll = (LinearLayout) view.findViewById(R.id.cnf_probability_ll);
            this.depDate = (TextView) view.findViewById(R.id.tv_dep_date);
            this.arrDate = (TextView) view.findViewById(R.id.tv_arr_date);
            this.llCheckAvailability = (LinearLayout) view.findViewById(R.id.ll_check_availiability);
            this.checkAvailiability = (TextView) view.findViewById(R.id.tv_check_availiability);
            this.sourceDestStn = (TextView) view.findViewById(R.id.tv_source_dest_stn);
            this.waitDuration = (TextView) view.findViewById(R.id.tv_wait_duration);
            this.sourceDestHeadingLayout = (LinearLayout) view.findViewById(R.id.tv_source_dest_heading_layout);
            this.llWaitDuration = (LinearLayout) view.findViewById(R.id.ll_wait_duration);
            this.lapHeading = (TextView) view.findViewById(R.id.tv_lap_heading);
            this.journeyDateViaDuration = (TextView) view.findViewById(R.id.tv_journeyDate_via_duration);
            this.quota = (TextView) view.findViewById(R.id.tv_quota);
            this.quotaLayout = (LinearLayout) view.findViewById(R.id.ll_quota);
            this.ll_changeover_msg = (LinearLayout) view.findViewById(R.id.ll_changeover_msg);
            this.tv_changeover_msg = (TextView) view.findViewById(R.id.tv_changeover_msg);
        }
    }

    public LapTrainListAdapter(Context context, List<TrainBtwnStnsModel> list, Lap2TrainListHAdapterListener lap2TrainListHAdapterListener, String str, String str2, String str3, Integer num, Integer num2) {
        this.trainBtwnStnsModels = list;
        this.mContext = context;
        this.listener = lap2TrainListHAdapterListener;
        this.mAvailabilityListener = this.mAvailabilityListener;
        this.selectedQuota = str;
        this.fromStn = str2;
        this.toStn = str3;
        this.waitingTime = num;
        this.totalDuration = num2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a0 A[SYNTHETIC, Splitter:B:28:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba A[Catch:{ Exception -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c0 A[Catch:{ Exception -> 0x0145 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void availabilityClicked(cris.org.in.ima.model.AvlClassModel r14, boolean r15, boolean r16, androidx.recyclerview.widget.RecyclerView r17) {
        /*
            r13 = this;
            r8 = r13
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            android.content.Context r0 = r8.mContext
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.content.Context r1 = r8.mContext
            boolean r0 = defpackage.C0535I5.O(r0, r1)
            if (r0 != 0) goto L_0x0025
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            cris.org.in.ima.adaptors.LapTrainListAdapter$11 r1 = new cris.org.in.ima.adaptors.LapTrainListAdapter$11
            r1.<init>()
            r2 = 5000(0x1388, double:2.4703E-320)
            r0.postDelayed(r1, r2)
            return
        L_0x0025:
            boolean r0 = defpackage.C0535I5.M()
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0043
            boolean r3 = defpackage.C0535I5.R()
            if (r3 != 0) goto L_0x0043
            long r3 = defpackage.C1450w1.f7005a
            r5 = 2
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x003f
            cris.org.in.ima.activities.HomeActivity.A(r1)
            goto L_0x0042
        L_0x003f:
            cris.org.in.ima.activities.HomeActivity.A(r2)
        L_0x0042:
            return
        L_0x0043:
            android.app.ProgressDialog r3 = r8.dialog     // Catch:{ Exception -> 0x0145 }
            if (r3 == 0) goto L_0x004d
            boolean r3 = r3.isShowing()     // Catch:{ Exception -> 0x0145 }
            if (r3 != 0) goto L_0x0070
        L_0x004d:
            android.content.Context r3 = r8.mContext     // Catch:{ Exception -> 0x0145 }
            android.content.res.Resources r4 = r3.getResources()     // Catch:{ Exception -> 0x0145 }
            r5 = 2131951654(0x7f130026, float:1.9539729E38)
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0145 }
            android.content.Context r5 = r8.mContext     // Catch:{ Exception -> 0x0145 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0145 }
            r7 = 2131953495(0x7f130757, float:1.9543463E38)
            java.lang.String r5 = r5.getString(r7)     // Catch:{ Exception -> 0x0145 }
            android.app.ProgressDialog r3 = android.app.ProgressDialog.show(r3, r4, r5)     // Catch:{ Exception -> 0x0145 }
            r8.dialog = r3     // Catch:{ Exception -> 0x0145 }
            r3.show()     // Catch:{ Exception -> 0x0145 }
        L_0x0070:
            Ga r3 = new Ga     // Catch:{ Exception -> 0x0145 }
            r3.<init>()     // Catch:{ Exception -> 0x0145 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0145 }
            r3.setMoreThanOneDay(r4)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r4 = cris.org.in.ima.fragment.AllTrainListFragment.m     // Catch:{ Exception -> 0x0145 }
            java.lang.String r5 = "Y"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0145 }
            r5 = 0
            if (r4 != 0) goto L_0x0092
            java.lang.String r4 = cris.org.in.ima.fragment.AllTrainListFragment.l     // Catch:{ Exception -> 0x0145 }
            java.lang.String r7 = "HP"
            boolean r4 = r4.equals(r7)     // Catch:{ Exception -> 0x0145 }
            if (r4 == 0) goto L_0x0090
            goto L_0x0092
        L_0x0090:
            r4 = r5
            goto L_0x0093
        L_0x0092:
            r4 = r2
        L_0x0093:
            r3.setConcessionBooking(r4)     // Catch:{ Exception -> 0x0145 }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r6.f5342a     // Catch:{ Exception -> 0x0145 }
            java.util.Date r4 = r4.getJourneyDate()     // Catch:{ Exception -> 0x0145 }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r7 = r6.f5342a
            if (r4 == 0) goto L_0x00ba
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0145 }
            java.lang.String r9 = "yyyyMMdd"
            r4.<init>(r9)     // Catch:{ Exception -> 0x0145 }
            java.util.Date r9 = r7.getJourneyDate()     // Catch:{ Exception -> 0x0145 }
            long r9 = r9.getTime()     // Catch:{ Exception -> 0x0145 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r4 = r4.format(r9)     // Catch:{ Exception -> 0x0145 }
            cris.org.in.ima.fragment.AllTrainListFragment.j = r4     // Catch:{ Exception -> 0x0145 }
            goto L_0x00be
        L_0x00ba:
            java.lang.String r4 = cris.org.in.ima.fragment.AllTrainListFragment.k     // Catch:{ Exception -> 0x0145 }
            cris.org.in.ima.fragment.AllTrainListFragment.j = r4     // Catch:{ Exception -> 0x0145 }
        L_0x00be:
            if (r0 != 0) goto L_0x00ce
            boolean r0 = defpackage.C0535I5.R()     // Catch:{ Exception -> 0x0145 }
            if (r0 == 0) goto L_0x00c7
            goto L_0x00ce
        L_0x00c7:
            java.lang.Object r0 = defpackage.C0657Qt.b()     // Catch:{ Exception -> 0x0145 }
            Om r0 = (defpackage.Om) r0     // Catch:{ Exception -> 0x0145 }
            goto L_0x00d8
        L_0x00ce:
            b1 r0 = defpackage.C0793b1.a     // Catch:{ Exception -> 0x0145 }
            kn r0 = r0.f3912a     // Catch:{ Exception -> 0x0145 }
            java.lang.Object r0 = defpackage.C0657Qt.c(r0)     // Catch:{ Exception -> 0x0145 }
            Om r0 = (defpackage.Om) r0     // Catch:{ Exception -> 0x0145 }
        L_0x00d8:
            java.lang.String r4 = defpackage.C0657Qt.f()     // Catch:{ Exception -> 0x0145 }
            java.lang.String r9 = "avlFareenquiry"
            java.lang.String r10 = "/%s/%s/%s/%s/%s/%s/%s"
            r11 = 7
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0145 }
            java.lang.String r12 = r7.getTrainNumber()     // Catch:{ Exception -> 0x0145 }
            r11[r5] = r12     // Catch:{ Exception -> 0x0145 }
            java.lang.String r5 = cris.org.in.ima.fragment.AllTrainListFragment.j     // Catch:{ Exception -> 0x0145 }
            r11[r2] = r5     // Catch:{ Exception -> 0x0145 }
            java.lang.String r2 = r7.getFromStnCode()     // Catch:{ Exception -> 0x0145 }
            r11[r1] = r2     // Catch:{ Exception -> 0x0145 }
            java.lang.String r1 = r7.getToStnCode()     // Catch:{ Exception -> 0x0145 }
            r2 = 3
            r11[r2] = r1     // Catch:{ Exception -> 0x0145 }
            r5 = r14
            java.lang.String r1 = r5.c     // Catch:{ Exception -> 0x0145 }
            r2 = 4
            r11[r2] = r1     // Catch:{ Exception -> 0x0145 }
            java.lang.String r1 = cris.org.in.ima.fragment.AllTrainListFragment.l     // Catch:{ Exception -> 0x0145 }
            r2 = 5
            r11[r2] = r1     // Catch:{ Exception -> 0x0145 }
            java.lang.String r1 = "N"
            r2 = 6
            r11[r2] = r1     // Catch:{ Exception -> 0x0145 }
            java.lang.String r1 = java.lang.String.format(r10, r11)     // Catch:{ Exception -> 0x0145 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0145 }
            r2.<init>()     // Catch:{ Exception -> 0x0145 }
            r2.append(r4)     // Catch:{ Exception -> 0x0145 }
            r2.append(r9)     // Catch:{ Exception -> 0x0145 }
            r2.append(r1)     // Catch:{ Exception -> 0x0145 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0145 }
            rx.Observable r0 = r0.c1(r1, r3)     // Catch:{ Exception -> 0x0145 }
            Lm r1 = defpackage.C1181iv.a()     // Catch:{ Exception -> 0x0145 }
            rx.Observable r0 = r0.c(r1)     // Catch:{ Exception -> 0x0145 }
            Yi r1 = defpackage.E0.a()     // Catch:{ Exception -> 0x0145 }
            rx.Observable r0 = r0.a(r1)     // Catch:{ Exception -> 0x0145 }
            cris.org.in.ima.adaptors.LapTrainListAdapter$12 r9 = new cris.org.in.ima.adaptors.LapTrainListAdapter$12     // Catch:{ Exception -> 0x0145 }
            r1 = r9
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r7 = r17
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0145 }
            r0.b(r9)     // Catch:{ Exception -> 0x0145 }
            goto L_0x015a
        L_0x0145:
            r0 = move-exception
            r0.getMessage()
            android.app.ProgressDialog r0 = r8.dialog
            r0.dismiss()
            android.content.Context r0 = r8.mContext
            r1 = 2131953492(0x7f130754, float:1.9543457E38)
            java.lang.String r1 = r0.getString(r1)
            defpackage.C0535I5.t0(r0, r1)
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.adaptors.LapTrainListAdapter.availabilityClicked(cris.org.in.ima.model.AvlClassModel, boolean, boolean, androidx.recyclerview.widget.RecyclerView):void");
    }

    public static String format(String str) {
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat("EEE dd MMM yy").format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }

    public static String getWlStatus(String str) {
        if (str.contains("WL")) {
            return "W";
        }
        if (str.contains("RAC")) {
            return "R";
        }
        return str.substring(0, 1);
    }

    public static int getWlStatusNumber(String str) {
        String replaceAll = str.replaceAll("[^0-9]", "");
        if (replaceAll.equals("")) {
            return 0;
        }
        return Integer.parseInt(replaceAll);
    }

    private void initList() {
        ArrayList<C0503FA> arrayList = new ArrayList<>();
        this.mTrainList = arrayList;
        lf.v("OTHER", R.color.white_other, arrayList);
        lf.v("RAJDHANI", R.color.majenta_color, this.mTrainList);
        lf.v("GARIB RATH", R.color.radium_color, this.mTrainList);
        lf.v("SPECIAL TRAIN", R.color.maroon_color, this.mTrainList);
        lf.v("SPECIAL TATKAL", R.color.light_green_color, this.mTrainList);
        lf.v("DURONTO", R.color.yellow_color1, this.mTrainList);
        lf.v("SUVIDHA TRAIN", R.color.green_color, this.mTrainList);
        lf.v("SHATABDI", R.color.Shatabdi_color, this.mTrainList);
        lf.v("JANSHATABDI", R.color.Janshatabdi_color, this.mTrainList);
        lf.v("YUVA EXPRESS", R.color.Yuva_train_color, this.mTrainList);
    }

    public void addFavouriteList(String str, String str2, String str3, String str4, String str5, final ImageView imageView) {
        if (!C0535I5.O((ConnectivityManager) this.mContext.getSystemService("connectivity"), this.mContext)) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                }
            }, 5000);
        } else if (str5 == null) {
            Context context = this.mContext;
            C0535I5.t0(context, context.getString(R.string.Please_Select_Class));
        } else {
            Context context2 = this.mContext;
            final ProgressDialog show = ProgressDialog.show(context2, context2.getString(R.string.add_fav_jrny_list), this.mContext.getString(R.string.please_wait_text));
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).q1(str, str2, str3, str4, str5).c(C1181iv.a()).a(E0.a()).b(new Subscriber<StatusDTO>() {
                public void onCompleted() {
                    String unused = LapTrainListAdapter.TAG;
                    show.dismiss();
                }

                public void onError(Throwable th) {
                    String unused = LapTrainListAdapter.TAG;
                    String unused2 = LapTrainListAdapter.TAG;
                    th.getMessage();
                    show.dismiss();
                    Lt.a(true, th);
                }

                public void onNext(final StatusDTO statusDTO) {
                    String next;
                    String str;
                    String str2;
                    String unused = LapTrainListAdapter.TAG;
                    Objects.toString(statusDTO);
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
                                show.dismiss();
                                C0535I5.p(LapTrainListAdapter.this.mContext, false, str3, LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                            } else if (statusDTO.getError() == null || statusDTO.getError().equals("")) {
                                show.dismiss();
                                C0535I5.p(LapTrainListAdapter.this.mContext, false, statusDTO.getStatus(), LapTrainListAdapter.this.mContext.getResources().getString(R.string.confirmation), LapTrainListAdapter.this.mContext.getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        C0535I5.f3640e.clear();
                                        if (statusDTO.getStatus().equals("Journey List Saved Successfully ...")) {
                                            AnonymousClass14 r2 = AnonymousClass14.this;
                                            imageView.setColorFilter(LapTrainListAdapter.this.mContext.getResources().getColor(R.color.red));
                                            return;
                                        }
                                        AnonymousClass14 r22 = AnonymousClass14.this;
                                        imageView.setColorFilter(LapTrainListAdapter.this.mContext.getResources().getColor(R.color.grey));
                                    }
                                }, (String) null, (DialogInterface.OnClickListener) null).show();
                            } else {
                                show.dismiss();
                                C0535I5.m(LapTrainListAdapter.this.mContext, false, statusDTO.getError(), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                            }
                        } catch (Exception e) {
                            String unused2 = LapTrainListAdapter.TAG;
                            e.getMessage();
                            show.dismiss();
                            C0535I5.m(LapTrainListAdapter.this.mContext, false, LapTrainListAdapter.this.mContext.getResources().getString(R.string.Unable_process_request), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                    } else {
                        show.dismiss();
                        C0535I5.m(LapTrainListAdapter.this.mContext, false, LapTrainListAdapter.this.mContext.getResources().getString(R.string.Unable_process_request), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                }
            });
        }
    }

    public void allLapAvlEnqService(TextView textView, final RecyclerView recyclerView) {
        Om om;
        if (!C0535I5.O((ConnectivityManager) this.mContext.getSystemService("connectivity"), this.mContext)) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                }
            }, 5000);
            return;
        }
        boolean M = C0535I5.M();
        if (!M || C0535I5.R()) {
            C1081e2 e2Var = new C1081e2();
            ArrayList arrayList = new ArrayList();
            for (TrainBtwnStnsModel next : this.trainBtwnStnsModels) {
                C1469x0 x0Var = new C1469x0();
                x0Var.setTrainNo(next.f5342a.getTrainNumber());
                TrainBtwnStnsDTO trainBtwnStnsDTO = next.f5342a;
                x0Var.setDestStn(trainBtwnStnsDTO.getToStnCode());
                x0Var.setFtBooking(false);
                x0Var.setJrnyDate(new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(trainBtwnStnsDTO.getJourneyDate()));
                x0Var.setQuotaCode(next.d);
                x0Var.setSrcStn(trainBtwnStnsDTO.getFromStnCode());
                if (trainBtwnStnsDTO.getAvlClasses() != null) {
                    x0Var.setAvlClasses(trainBtwnStnsDTO.getAvlClasses());
                }
                arrayList.add(x0Var);
            }
            e2Var.setAlternateAvlInputDTO(arrayList);
            Context context = this.mContext;
            final ProgressDialog show = ProgressDialog.show(context, context.getResources().getString(R.string.Check_Availability), this.mContext.getResources().getString(R.string.please_wait_text));
            if (M || C0535I5.R()) {
                om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            } else {
                om = (Om) C0657Qt.b();
            }
            String f = C0657Qt.f();
            om.z1(f + "allLapAvlEnq", e2Var).c(C1181iv.a()).a(E0.a()).b(new Subscriber<TrainBtwnStnsRespDto>() {
                public void onCompleted() {
                    String unused = LapTrainListAdapter.TAG;
                    show.dismiss();
                }

                public void onError(Throwable th) {
                    String unused = LapTrainListAdapter.TAG;
                    String unused2 = LapTrainListAdapter.TAG;
                    th.getMessage();
                    show.dismiss();
                    Lt.a(true, th);
                }

                public void onNext(TrainBtwnStnsRespDto trainBtwnStnsRespDto) {
                    String unused = LapTrainListAdapter.TAG;
                    Objects.toString(trainBtwnStnsRespDto);
                    if (trainBtwnStnsRespDto != null) {
                        C0657Qt.h();
                        try {
                            if (trainBtwnStnsRespDto.getErrorMessage() == null) {
                                show.dismiss();
                                if (trainBtwnStnsRespDto.getTrainBtwnStnsList() != null && trainBtwnStnsRespDto.getTrainBtwnStnsList().size() > 0) {
                                    String str = "";
                                    boolean z = false;
                                    int i = 0;
                                    for (TrainBtwnStnsDTO next : trainBtwnStnsRespDto.getTrainBtwnStnsList()) {
                                        ArrayList arrayList = new ArrayList();
                                        new ClassAvlDTO();
                                        if (next.getClassAvlDTO() != null) {
                                            for (int size = next.getClassAvlDTO().size() - 1; size >= 0; size--) {
                                                arrayList.add(next.getClassAvlDTO().get(size));
                                            }
                                        }
                                        int i2 = i + 1;
                                        LapTrainListAdapter.this.trainBtwnStnsModels.get(i).f5342a.setClassAvlDTO(arrayList);
                                        for (ClassAvlDTO next2 : next.getClassAvlDTO()) {
                                            if (next2.getErrorMessage() != null) {
                                                str = next2.getErrorMessage();
                                                z = true;
                                            }
                                        }
                                        i = i2;
                                    }
                                    LapTrainListAdapter.this.notifyDataSetChanged();
                                    if (z) {
                                        C0535I5.m(LapTrainListAdapter.this.mContext, false, str, LapTrainListAdapter.this.mContext.getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                                        return;
                                    }
                                }
                                recyclerView.setVisibility(0);
                                LapTrainListAdapter.this.notifyDataSetChanged();
                                return;
                            }
                            show.dismiss();
                            recyclerView.setVisibility(8);
                            C0535I5.m(LapTrainListAdapter.this.mContext, false, trainBtwnStnsRespDto.getErrorMessage(), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        } catch (Exception e) {
                            String unused2 = LapTrainListAdapter.TAG;
                            e.getMessage();
                            show.dismiss();
                            C0535I5.m(LapTrainListAdapter.this.mContext, false, LapTrainListAdapter.this.mContext.getResources().getString(R.string.Unable_process_request), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                    } else {
                        show.dismiss();
                        C0535I5.m(LapTrainListAdapter.this.mContext, false, LapTrainListAdapter.this.mContext.getResources().getString(R.string.Unable_process_request), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                }
            });
        } else if (C1450w1.f7005a == 2) {
            HomeActivity.A(2);
        } else {
            HomeActivity.A(1);
        }
    }

    public void allLapAvlEnqService2(final TrainBtwnStnsModel trainBtwnStnsModel) {
        Om om;
        if (!C0535I5.O((ConnectivityManager) this.mContext.getSystemService("connectivity"), this.mContext)) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                }
            }, 5000);
            return;
        }
        boolean M = C0535I5.M();
        if (!M || C0535I5.R()) {
            C1081e2 e2Var = new C1081e2();
            ArrayList arrayList = new ArrayList();
            C1469x0 x0Var = new C1469x0();
            x0Var.setTrainNo(trainBtwnStnsModel.f5342a.getTrainNumber());
            TrainBtwnStnsDTO trainBtwnStnsDTO = trainBtwnStnsModel.f5342a;
            x0Var.setDestStn(trainBtwnStnsDTO.getToStnCode());
            x0Var.setFtBooking(false);
            if (trainBtwnStnsDTO.getJourneyDate() != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                AllTrainListFragment.j = simpleDateFormat.format(Long.valueOf(trainBtwnStnsDTO.getJourneyDate().getTime()));
                x0Var.setJrnyDate(simpleDateFormat.format(Long.valueOf(trainBtwnStnsDTO.getJourneyDate().getTime())));
            } else {
                new SimpleDateFormat("yyyyMMdd");
                String str = AllTrainListFragment.k;
                AllTrainListFragment.j = str;
                x0Var.setJrnyDate(str);
            }
            x0Var.setQuotaCode(trainBtwnStnsModel.d);
            x0Var.setSrcStn(trainBtwnStnsDTO.getFromStnCode());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(trainBtwnStnsModel.f5348c);
            x0Var.setAvlClasses(arrayList2);
            arrayList.add(x0Var);
            e2Var.setAlternateAvlInputDTO(arrayList);
            ProgressDialog progressDialog = this.dialog;
            if (progressDialog == null || !progressDialog.isShowing()) {
                Context context = this.mContext;
                ProgressDialog show = ProgressDialog.show(context, context.getResources().getString(R.string.Availability_Search), this.mContext.getResources().getString(R.string.please_wait_text));
                this.dialog = show;
                show.show();
            }
            if (M || C0535I5.R()) {
                om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            } else {
                om = (Om) C0657Qt.b();
            }
            String f = C0657Qt.f();
            om.z1(f + "allLapAvlEnq", e2Var).c(C1181iv.a()).a(E0.a()).b(new Subscriber<TrainBtwnStnsRespDto>() {
                public void onCompleted() {
                    String unused = LapTrainListAdapter.TAG;
                    LapTrainListAdapter.this.dialog.dismiss();
                }

                public void onError(Throwable th) {
                    String unused = LapTrainListAdapter.TAG;
                    String unused2 = LapTrainListAdapter.TAG;
                    th.getMessage();
                    LapTrainListAdapter.this.dialog.dismiss();
                    Lt.a(true, th);
                }

                public void onNext(TrainBtwnStnsRespDto trainBtwnStnsRespDto) {
                    String unused = LapTrainListAdapter.TAG;
                    Objects.toString(trainBtwnStnsRespDto);
                    if (trainBtwnStnsRespDto != null) {
                        C0657Qt.h();
                        try {
                            if (trainBtwnStnsRespDto.getErrorMessage() == null) {
                                LapTrainListAdapter.this.dialog.dismiss();
                                if (trainBtwnStnsRespDto.getTrainBtwnStnsList() != null && trainBtwnStnsRespDto.getTrainBtwnStnsList().size() > 0) {
                                    String str = "";
                                    boolean z = false;
                                    for (TrainBtwnStnsDTO next : trainBtwnStnsRespDto.getTrainBtwnStnsList()) {
                                        Iterator<ClassAvlDTO> it = next.getClassAvlDTO().iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            ClassAvlDTO next2 = it.next();
                                            if (next2.getErrorMessage() != null) {
                                                str = next2.getErrorMessage();
                                                z = true;
                                                break;
                                            }
                                        }
                                        if (!z) {
                                            int i = 0;
                                            for (TrainBtwnStnsModel next3 : LapTrainListAdapter.this.trainBtwnStnsModels) {
                                                TrainBtwnStnsDTO trainBtwnStnsDTO = next3.f5342a;
                                                TrainBtwnStnsDTO trainBtwnStnsDTO2 = next3.f5342a;
                                                if (trainBtwnStnsDTO.getTrainNumber().equalsIgnoreCase(trainBtwnStnsModel.f5342a.getTrainNumber())) {
                                                    Iterator<ClassAvlDTO> it2 = trainBtwnStnsDTO2.getClassAvlDTO().iterator();
                                                    int i2 = 0;
                                                    while (true) {
                                                        if (!it2.hasNext()) {
                                                            break;
                                                        }
                                                        ClassAvlDTO next4 = it2.next();
                                                        if (next4.getEnqClass().equalsIgnoreCase(trainBtwnStnsModel.f5348c)) {
                                                            LapTrainListAdapter.this.trainBtwnStnsModels.get(i).f5342a.getClassAvlDTO().set(i2, next.getClassAvlDTO().get(0));
                                                            C0535I5.h = next4.getEnqClass();
                                                            C0535I5.i = trainBtwnStnsDTO2.getTrainNumber();
                                                            LapTrainListAdapter.this.trainBtwnStnsModels.get(i).f5343a = next.getClassAvlDTO().get(0).getAvlDayList().get(0);
                                                            LapTrainListAdapter.this.trainBtwnStnsModels.get(i).f5348c = next4.getEnqClass();
                                                            LapTrainListAdapter lapTrainListAdapter = LapTrainListAdapter.this;
                                                            Lap2TrainListHAdapterListener lap2TrainListHAdapterListener = lapTrainListAdapter.listener;
                                                            if (lap2TrainListHAdapterListener != null) {
                                                                lap2TrainListHAdapterListener.onTrainLayoutClick(lapTrainListAdapter.trainBtwnStnsModels.get(i), true, false);
                                                            }
                                                        } else {
                                                            i2++;
                                                        }
                                                    }
                                                }
                                                i++;
                                            }
                                        }
                                    }
                                    if (z) {
                                        C0535I5.m(LapTrainListAdapter.this.mContext, false, str, LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                                        return;
                                    }
                                }
                                LapTrainListAdapter.this.notifyDataSetChanged();
                                return;
                            }
                            LapTrainListAdapter.this.dialog.dismiss();
                            C0535I5.m(LapTrainListAdapter.this.mContext, false, trainBtwnStnsRespDto.getErrorMessage(), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        } catch (Exception e) {
                            String unused2 = LapTrainListAdapter.TAG;
                            e.getMessage();
                            LapTrainListAdapter.this.dialog.dismiss();
                            C0535I5.m(LapTrainListAdapter.this.mContext, false, LapTrainListAdapter.this.mContext.getResources().getString(R.string.Unable_process_request), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                    } else {
                        LapTrainListAdapter.this.dialog.dismiss();
                        C0535I5.m(LapTrainListAdapter.this.mContext, false, LapTrainListAdapter.this.mContext.getResources().getString(R.string.Unable_process_request), LapTrainListAdapter.this.mContext.getResources().getString(R.string.error), LapTrainListAdapter.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                }
            });
        } else if (C1450w1.f7005a == 2) {
            HomeActivity.A(2);
        } else {
            HomeActivity.A(1);
        }
    }

    public GregorianCalendar arrDateCommon(String str, String str2, String str3) {
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        int z = xx.z(indexOf2, 1, str);
        int parseInt = Integer.parseInt(str.substring(i, indexOf2));
        int parseInt2 = Integer.parseInt(str.substring(0, indexOf));
        int indexOf3 = str3.indexOf(":");
        int parseInt3 = Integer.parseInt(str3.substring(0, indexOf3));
        int z2 = xx.z(indexOf3, 1, str3);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(z, parseInt - 1, parseInt2, Integer.parseInt(str2.substring(0, 2)), Integer.parseInt(str2.substring(3)));
        gregorianCalendar.add(10, parseInt3);
        gregorianCalendar.add(12, z2);
        return gregorianCalendar;
    }

    public String getArvDate(String str, String str2, String str3) {
        return new SimpleDateFormat("EEE, dd MMM").format(arrDateCommon(str, str2, str3).getTime());
    }

    public int getItemCount() {
        return this.trainBtwnStnsModels.size();
    }

    public TrainListItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TrainListItemHolder(C1058d.s(viewGroup, R.layout.item_train_list_lap_adapter, viewGroup, false));
    }

    public void onRunningDayStatus(TrainListItemHolder trainListItemHolder, TrainBtwnStnsDTO trainBtwnStnsDTO) {
        if (trainBtwnStnsDTO.getRunningSun() != null) {
            if (trainBtwnStnsDTO.getRunningSun().equals("Y")) {
                trainListItemHolder.sunday.setContentDescription("sunday");
                trainListItemHolder.sunday.setEnabled(true);
                trainListItemHolder.sunday.setText("S");
                TextView textView = trainListItemHolder.sunday;
                Context context = this.mContext;
                Object obj = d7.a;
                textView.setTextColor(d7.b.a(context, R.color.black_85_opa));
            } else {
                trainListItemHolder.sunday.setEnabled(false);
                trainListItemHolder.sunday.setContentDescription("sunday");
                trainListItemHolder.sunday.setText("S");
                TextView textView2 = trainListItemHolder.sunday;
                Context context2 = this.mContext;
                Object obj2 = d7.a;
                textView2.setTextColor(d7.b.a(context2, R.color.shadow_line2));
            }
        }
        if (trainBtwnStnsDTO.getRunningMon() != null) {
            if (trainBtwnStnsDTO.getRunningMon().equals("Y")) {
                trainListItemHolder.monday.setContentDescription("monday");
                trainListItemHolder.monday.setText("M");
                trainListItemHolder.monday.setEnabled(true);
                TextView textView3 = trainListItemHolder.monday;
                Context context3 = this.mContext;
                Object obj3 = d7.a;
                textView3.setTextColor(d7.b.a(context3, R.color.black_85_opa));
            } else {
                trainListItemHolder.monday.setText("M");
                trainListItemHolder.monday.setContentDescription("monday");
                trainListItemHolder.monday.setEnabled(false);
                TextView textView4 = trainListItemHolder.monday;
                Context context4 = this.mContext;
                Object obj4 = d7.a;
                textView4.setTextColor(d7.b.a(context4, R.color.shadow_line2));
            }
        }
        if (trainBtwnStnsDTO.getRunningTue() != null) {
            if (trainBtwnStnsDTO.getRunningTue().equals("Y")) {
                trainListItemHolder.tuesday.setContentDescription("tuesday");
                trainListItemHolder.tuesday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
                trainListItemHolder.tuesday.setEnabled(true);
                TextView textView5 = trainListItemHolder.tuesday;
                Context context5 = this.mContext;
                Object obj5 = d7.a;
                textView5.setTextColor(d7.b.a(context5, R.color.black_85_opa));
            } else {
                trainListItemHolder.tuesday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
                trainListItemHolder.tuesday.setContentDescription("tuesday");
                trainListItemHolder.tuesday.setEnabled(false);
                TextView textView6 = trainListItemHolder.tuesday;
                Context context6 = this.mContext;
                Object obj6 = d7.a;
                textView6.setTextColor(d7.b.a(context6, R.color.shadow_line2));
            }
        }
        if (trainBtwnStnsDTO.getRunningWed() != null) {
            if (trainBtwnStnsDTO.getRunningWed().equals("Y")) {
                trainListItemHolder.wednesday.setContentDescription("wednesday");
                trainListItemHolder.wednesday.setText("W");
                trainListItemHolder.wednesday.setEnabled(true);
                TextView textView7 = trainListItemHolder.wednesday;
                Context context7 = this.mContext;
                Object obj7 = d7.a;
                textView7.setTextColor(d7.b.a(context7, R.color.black_85_opa));
            } else {
                trainListItemHolder.wednesday.setText("W");
                trainListItemHolder.wednesday.setContentDescription("wednesday");
                trainListItemHolder.wednesday.setEnabled(false);
                TextView textView8 = trainListItemHolder.wednesday;
                Context context8 = this.mContext;
                Object obj8 = d7.a;
                textView8.setTextColor(d7.b.a(context8, R.color.shadow_line2));
            }
        }
        if (trainBtwnStnsDTO.getRunningThu() != null) {
            if (trainBtwnStnsDTO.getRunningThu().equals("Y")) {
                trainListItemHolder.thursday.setContentDescription("thursday");
                trainListItemHolder.thursday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
                trainListItemHolder.thursday.setEnabled(true);
                TextView textView9 = trainListItemHolder.thursday;
                Context context9 = this.mContext;
                Object obj9 = d7.a;
                textView9.setTextColor(d7.b.a(context9, R.color.black_85_opa));
            } else {
                trainListItemHolder.thursday.setContentDescription("thursday");
                trainListItemHolder.thursday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
                trainListItemHolder.thursday.setEnabled(false);
                TextView textView10 = trainListItemHolder.thursday;
                Context context10 = this.mContext;
                Object obj10 = d7.a;
                textView10.setTextColor(d7.b.a(context10, R.color.shadow_line2));
            }
        }
        if (trainBtwnStnsDTO.getRunningFri() != null) {
            if (trainBtwnStnsDTO.getRunningFri().equals("Y")) {
                trainListItemHolder.friday.setContentDescription("friday");
                trainListItemHolder.friday.setText("F");
                trainListItemHolder.friday.setEnabled(true);
                TextView textView11 = trainListItemHolder.friday;
                Context context11 = this.mContext;
                Object obj11 = d7.a;
                textView11.setTextColor(d7.b.a(context11, R.color.black_85_opa));
            } else {
                trainListItemHolder.friday.setContentDescription("friday");
                trainListItemHolder.friday.setText("F");
                trainListItemHolder.friday.setEnabled(false);
                TextView textView12 = trainListItemHolder.friday;
                Context context12 = this.mContext;
                Object obj12 = d7.a;
                textView12.setTextColor(d7.b.a(context12, R.color.shadow_line2));
            }
        }
        if (trainBtwnStnsDTO.getRunningSat() == null) {
            return;
        }
        if (trainBtwnStnsDTO.getRunningSat().equals("Y")) {
            trainListItemHolder.saturday.setContentDescription("saturday");
            trainListItemHolder.saturday.setText("S");
            trainListItemHolder.saturday.setEnabled(true);
            TextView textView13 = trainListItemHolder.saturday;
            Context context13 = this.mContext;
            Object obj13 = d7.a;
            textView13.setTextColor(d7.b.a(context13, R.color.black_85_opa));
            return;
        }
        trainListItemHolder.saturday.setText("S");
        trainListItemHolder.saturday.setContentDescription("saturday");
        trainListItemHolder.saturday.setEnabled(false);
        TextView textView14 = trainListItemHolder.saturday;
        Context context14 = this.mContext;
        Object obj14 = d7.a;
        textView14.setTextColor(d7.b.a(context14, R.color.shadow_line2));
    }

    public void onSetListeners(final TrainListItemHolder trainListItemHolder, final TrainBtwnStnsModel trainBtwnStnsModel) {
        trainListItemHolder.quotaLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Lap2TrainListHAdapterListener lap2TrainListHAdapterListener = LapTrainListAdapter.this.listener;
                if (lap2TrainListHAdapterListener != null) {
                    lap2TrainListHAdapterListener.onQuotaClick(trainBtwnStnsModel);
                }
            }
        });
        trainListItemHolder.routMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Om om;
                if (trainBtwnStnsModel.f5342a.getJourneyDate() != null) {
                    LapAllTrainListFragment.h = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(trainBtwnStnsModel.f5342a.getJourneyDate());
                } else {
                    LapAllTrainListFragment.h = LapAllTrainListFragment.i;
                }
                String trainNumber = trainBtwnStnsModel.f5342a.getTrainNumber();
                String fromStnCode = trainBtwnStnsModel.f5342a.getFromStnCode();
                String str = AllTrainListFragment.j;
                Context access$000 = LapTrainListAdapter.this.mContext;
                if (!C0535I5.O((ConnectivityManager) access$000.getSystemService("connectivity"), access$000)) {
                    new Handler().postDelayed(new C0611Nh(), 5000);
                    return;
                }
                try {
                    boolean M = C0535I5.M();
                    if (!M || C0535I5.R()) {
                        ProgressDialog progressDialog = new ProgressDialog(access$000);
                        progressDialog.requestWindowFeature(1);
                        progressDialog.setMessage(access$000.getString(R.string.please_wait_text));
                        progressDialog.show();
                        if (!M) {
                            if (!C0535I5.R()) {
                                om = (Om) C0657Qt.b();
                                String f = C0657Qt.f();
                                String format = String.format("/%s", new Object[]{trainNumber});
                                om.h0(f + "trnscheduleenquiry" + format, fromStnCode, str).c(C1181iv.a()).a(E0.a()).b(new C0627Oh(progressDialog, trainNumber, access$000));
                            }
                        }
                        om = (Om) C0657Qt.c(C0793b1.a.f3912a);
                        String f2 = C0657Qt.f();
                        String format2 = String.format("/%s", new Object[]{trainNumber});
                        om.h0(f2 + "trnscheduleenquiry" + format2, fromStnCode, str).c(C1181iv.a()).a(E0.a()).b(new C0627Oh(progressDialog, trainNumber, access$000));
                    } else if (C1450w1.f7005a == 2) {
                        HomeActivity.A(2);
                    } else {
                        HomeActivity.A(1);
                    }
                } catch (Exception e) {
                    e.getMessage();
                    C0535I5.t0(access$000, access$000.getResources().getString(R.string.please_try_again));
                }
            }
        });
        trainListItemHolder.traintyColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LapTrainListAdapter.this.mContext);
                builder.setTitle(LapTrainListAdapter.this.mContext.getString(R.string.train_type));
                builder.setAdapter(LapTrainListAdapter.this.mAdapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton(LapTrainListAdapter.this.mContext.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton((CharSequence) null, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
        trainListItemHolder.tv_cnf_probability.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        trainListItemHolder.tv_avl_updates.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        trainListItemHolder.tv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                trainListItemHolder.avl_other_date_ll.setVisibility(8);
                trainListItemHolder.rvClassFareAvl.setVisibility(0);
                trainListItemHolder.other_dates_cnf_update_ll.setVisibility(0);
                trainListItemHolder.tv_otherdate.setVisibility(0);
                trainListItemHolder.tv_avl_updates.setVisibility(0);
            }
        });
    }

    public void reCallAvlEnq(final AvlClassModel avlClassModel, AvlFareResponseDTO avlFareResponseDTO, final boolean z, final boolean z2) {
        int i;
        try {
            AnonymousClass10 r1 = new Runnable() {
                public void run() {
                    LapTrainListAdapter.this.availabilityClicked(avlClassModel, z, z2, (RecyclerView) null);
                }
            };
            if (avlFareResponseDTO.getRetryAfterTime() == null || avlFareResponseDTO.getRetryAfterTime().intValue() >= 0) {
                i = avlFareResponseDTO.getRetryAfterTime().intValue();
            } else {
                i = 0;
            }
            new C0816cB(r1, i).a();
        } catch (Exception e) {
            e.getMessage();
            Context context = this.mContext;
            C0535I5.t0(context, context.getString(R.string.please_try_again));
        }
    }

    public void onBindViewHolder(final TrainListItemHolder trainListItemHolder, int i) {
        String str;
        String str2;
        String str3;
        final TrainBtwnStnsModel trainBtwnStnsModel = this.trainBtwnStnsModels.get(i);
        currentItem = trainBtwnStnsModel;
        if (i == 0) {
            trainListItemHolder.sourceDestHeadingLayout.setVisibility(0);
            TextView textView = trainListItemHolder.sourceDestStn;
            StringBuilder sb = new StringBuilder();
            sb.append(this.fromStn);
            sb.append(" - ");
            lf.x(sb, this.toStn, textView);
            trainListItemHolder.llWaitDuration.setVisibility(0);
            List<TrainBtwnStnsModel> list = this.trainBtwnStnsModels;
            if (list != null && !list.isEmpty() && this.trainBtwnStnsModels.size() > 1) {
                if (this.trainBtwnStnsModels.get(0) == null || this.trainBtwnStnsModels.get(0).f5342a == null) {
                    str2 = "";
                } else {
                    str2 = this.trainBtwnStnsModels.get(0).f5342a.getToStnCode();
                }
                if (this.trainBtwnStnsModels.get(1) == null || this.trainBtwnStnsModels.get(1).f5342a == null) {
                    str3 = "";
                } else {
                    str3 = this.trainBtwnStnsModels.get(1).f5342a.getFromStnCode();
                }
                if (!str2.equalsIgnoreCase(str3)) {
                    trainListItemHolder.ll_changeover_msg.setVisibility(0);
                    String str4 = trainBtwnStnsModel.e;
                    if (str4 != null) {
                        trainListItemHolder.tv_changeover_msg.setText(str4);
                    }
                }
            }
        } else {
            trainListItemHolder.sourceDestHeadingLayout.setVisibility(8);
            trainListItemHolder.llWaitDuration.setVisibility(8);
        }
        TextView textView2 = trainListItemHolder.lapHeading;
        textView2.setText(this.mContext.getResources().getString(R.string.LAP) + (i + 1));
        if (i == this.trainBtwnStnsModels.size() - 1) {
            trainListItemHolder.llCheckAvailability.setVisibility(0);
        } else {
            trainListItemHolder.llCheckAvailability.setVisibility(8);
        }
        String[] split = trainBtwnStnsModel.f5342a.getDuration().split(":");
        if (split.length == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(split[0]);
            sb2.append("h:");
            str = C0709Uj.j(sb2, split[1], "m");
        } else if (split.length == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(split[0]);
            sb3.append("h:");
            sb3.append(split[1]);
            sb3.append("m:");
            str = C0709Uj.j(sb3, split[2], "s");
        } else {
            str = C0709Uj.j(new StringBuilder(), split[0], "h:");
        }
        trainListItemHolder.travelTime.setText(str);
        int parseInt = Integer.parseInt(String.valueOf(this.totalDuration));
        Locale locale = Locale.ENGLISH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM", locale);
        TrainBtwnStnsDTO trainBtwnStnsDTO = trainBtwnStnsModel.f5342a;
        String format = simpleDateFormat.format(trainBtwnStnsDTO.getJourneyDate());
        TextView textView3 = trainListItemHolder.journeyDateViaDuration;
        StringBuilder J = xx.J(format);
        J.append(this.mContext.getResources().getString(R.string.VIA));
        J.append(this.stationDb.m(trainBtwnStnsDTO.getToStnCode()));
        J.append(this.mContext.getResources().getString(R.string.Duration));
        J.append(parseInt / 60);
        J.append("h:");
        J.append(parseInt % 60);
        J.append("m");
        textView3.setText(J.toString());
        TextView textView4 = trainListItemHolder.waitDuration;
        textView4.setText(this.mContext.getResources().getString(R.string.Wait_Duration) + C0535I5.z(this.waitingTime.intValue()));
        this.spConcession = (String) new Bundle().get("spConcession");
        if (currentItem.a != null) {
            trainBtwnStnsModel.a.toString();
        }
        TextView textView5 = trainListItemHolder.trainNo;
        textView5.setText("(" + trainBtwnStnsDTO.getTrainNumber() + ")");
        trainListItemHolder.trainNo.setContentDescription(trainBtwnStnsDTO.getTrainNumber().replace("", " ").trim());
        trainListItemHolder.trainName.setText(trainBtwnStnsDTO.getTrainName());
        trainListItemHolder.fromCityName.setText(C0535I5.s0(this.stationDb.m(trainBtwnStnsDTO.getFromStnCode())));
        trainListItemHolder.toCityName.setText(C0535I5.s0(this.stationDb.m(trainBtwnStnsDTO.getToStnCode())));
        trainListItemHolder.depTime.setText(trainBtwnStnsDTO.getDepartureTime());
        trainListItemHolder.arvTime.setText(trainBtwnStnsDTO.getArrivalTime());
        trainListItemHolder.arrDate.setText(getArvDate(new SimpleDateFormat("dd-MM-yyyy", locale).format(trainBtwnStnsDTO.getJourneyDate()), trainBtwnStnsDTO.getDepartureTime(), trainBtwnStnsDTO.getDuration()));
        trainListItemHolder.depDate.setText(format);
        initList();
        trainListItemHolder.avl_other_date_ll.setVisibility(8);
        String str5 = trainBtwnStnsModel.d;
        if (str5 != null) {
            if (str5.equalsIgnoreCase("SS")) {
                trainListItemHolder.quota.setText(R.string.senior_citizen);
            } else {
                H9 f = H9.f(trainBtwnStnsModel.d);
                if (f == null) {
                    trainListItemHolder.quota.setText(trainBtwnStnsModel.d);
                } else if (IrctcImaApplication.e.equals("hi")) {
                    trainListItemHolder.quota.setText(f.f3612e);
                } else {
                    trainListItemHolder.quota.setText(f.a());
                }
            }
        }
        AnonymousClass1 r15 = new AvailabilitywithClassFareViewHolder.AvailabilityViewHolderListener() {
            public void onItemClick(WrapperAvailablityWithClassFareModel wrapperAvailablityWithClassFareModel, TrainBtwnStnsModel trainBtwnStnsModel, boolean z) {
                ClassAvlDTO classAvlDTO = wrapperAvailablityWithClassFareModel.f5352a;
                if (classAvlDTO == null) {
                    trainBtwnStnsModel.f5348c = wrapperAvailablityWithClassFareModel.a.c;
                    LapAllTrainListFragment.f4693a = trainBtwnStnsModel;
                    trainListItemHolder.avl_other_date_ll.setVisibility(0);
                    trainListItemHolder.other_dates_cnf_update_ll.setVisibility(0);
                    trainListItemHolder.cnf_probability_ll.setVisibility(8);
                    trainListItemHolder.tv_avl_updates.setVisibility(0);
                    trainListItemHolder.tv_otherdate.setVisibility(8);
                    trainListItemHolder.rvClassFareAvl.setVisibility(8);
                    ArrayList arrayList = trainBtwnStnsModel.f5346a;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AvlClassModel avlClassModel = (AvlClassModel) it.next();
                        if (LapAllTrainListFragment.f4693a.f5348c.equals(avlClassModel.c)) {
                            avlClassModel.a = Boolean.TRUE;
                        } else {
                            avlClassModel.a = Boolean.FALSE;
                        }
                    }
                    trainListItemHolder.rvTrainClass.setLayoutManager(new LinearLayoutManager(LapTrainListAdapter.this.mContext, 0, false));
                    trainListItemHolder.rvTrainClass.setAdapter(new AvlClassViewHolder(LapTrainListAdapter.this.mContext, arrayList, LapTrainListAdapter.this.mAvlClsHolderListener));
                    trainListItemHolder.rvAvailabilityList.setVisibility(8);
                } else if (classAvlDTO.getErrorMessage() != null) {
                    trainBtwnStnsModel.f5348c = wrapperAvailablityWithClassFareModel.f5352a.getEnqClass();
                    LapTrainListAdapter.this.allLapAvlEnqService2(trainBtwnStnsModel);
                } else {
                    trainListItemHolder.avl_other_date_ll.setVisibility(8);
                    trainListItemHolder.other_dates_cnf_update_ll.setVisibility(8);
                    trainListItemHolder.cnf_probability_ll.setVisibility(8);
                    trainListItemHolder.tv_avl_updates.setVisibility(8);
                    trainListItemHolder.tv_otherdate.setVisibility(8);
                    trainBtwnStnsModel.f5348c = wrapperAvailablityWithClassFareModel.f5352a.getEnqClass();
                    trainBtwnStnsModel.f5343a = wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0);
                    Iterator<TrainBtwnStnsModel> it2 = LapTrainListAdapter.this.trainBtwnStnsModels.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        TrainBtwnStnsModel next = it2.next();
                        if (next.f5342a.getTrainNumber().equalsIgnoreCase(trainBtwnStnsModel.f5342a.getTrainNumber())) {
                            next.f5343a = trainBtwnStnsModel.f5343a;
                            next.f5348c = trainBtwnStnsModel.f5348c;
                            break;
                        }
                    }
                    Lap2TrainListHAdapterListener lap2TrainListHAdapterListener = LapTrainListAdapter.this.listener;
                    if (lap2TrainListHAdapterListener != null) {
                        lap2TrainListHAdapterListener.onTrainLayoutClick(trainBtwnStnsModel, true, true);
                    }
                    trainListItemHolder.other_dates_cnf_update_ll.setVisibility(0);
                }
            }
        };
        ArrayList arrayList = new ArrayList();
        if (trainBtwnStnsDTO.getClassAvlDTO() != null) {
            for (ClassAvlDTO next : trainBtwnStnsDTO.getClassAvlDTO()) {
                WrapperAvailablityWithClassFareModel wrapperAvailablityWithClassFareModel = new WrapperAvailablityWithClassFareModel();
                if (!C0535I5.i.equalsIgnoreCase(trainBtwnStnsDTO.getTrainNumber()) || !C0535I5.h.equalsIgnoreCase(next.getEnqClass())) {
                    wrapperAvailablityWithClassFareModel.f5353a = false;
                } else {
                    wrapperAvailablityWithClassFareModel.f5353a = true;
                    C0535I5.h = "";
                    C0535I5.i = "";
                }
                wrapperAvailablityWithClassFareModel.f5352a = next;
                arrayList.add(wrapperAvailablityWithClassFareModel);
            }
            trainListItemHolder.rvClassFareAvl.setVisibility(0);
        } else {
            if (trainBtwnStnsDTO.getAvlClasses() != null) {
                for (String avlClassModel : trainBtwnStnsDTO.getAvlClasses()) {
                    WrapperAvailablityWithClassFareModel wrapperAvailablityWithClassFareModel2 = new WrapperAvailablityWithClassFareModel();
                    wrapperAvailablityWithClassFareModel2.f5353a = false;
                    wrapperAvailablityWithClassFareModel2.f5352a = null;
                    wrapperAvailablityWithClassFareModel2.a = new AvlClassModel(avlClassModel);
                    arrayList.add(wrapperAvailablityWithClassFareModel2);
                }
            }
            trainListItemHolder.rvClassFareAvl.setVisibility(8);
        }
        trainListItemHolder.rvClassFareAvl.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        AvailabilitywithClassFareViewHolder availabilitywithClassFareViewHolder2 = new AvailabilitywithClassFareViewHolder(this.mContext, arrayList, r15, trainBtwnStnsModel);
        this.availabilitywithClassFareViewHolder = availabilitywithClassFareViewHolder2;
        trainListItemHolder.rvClassFareAvl.setAdapter(availabilitywithClassFareViewHolder2);
        trainListItemHolder.traintyColor.setVisibility(4);
        this.mAdapter = new TrainTypeAdaptor(this.mContext, this.mTrainList);
        if (trainBtwnStnsDTO.getTrainType() != null) {
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("O")) {
                trainListItemHolder.traintyColor.setVisibility(4);
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("R")) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView = trainListItemHolder.traintyColor;
                Context context = this.mContext;
                Object obj = d7.a;
                imageView.setColorFilter(d7.b.a(context, R.color.majenta_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView2 = trainListItemHolder.traintyColor;
                Context context2 = this.mContext;
                Object obj2 = d7.a;
                imageView2.setColorFilter(d7.b.a(context2, R.color.radium_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("SP")) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView3 = trainListItemHolder.traintyColor;
                Context context3 = this.mContext;
                Object obj3 = d7.a;
                imageView3.setColorFilter(d7.b.a(context3, R.color.maroon_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("ST")) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView4 = trainListItemHolder.traintyColor;
                Context context4 = this.mContext;
                Object obj4 = d7.a;
                imageView4.setColorFilter(d7.b.a(context4, R.color.light_green_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("D")) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView5 = trainListItemHolder.traintyColor;
                Context context5 = this.mContext;
                Object obj5 = d7.a;
                imageView5.setColorFilter(d7.b.a(context5, R.color.yellow_color1));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("SV")) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView6 = trainListItemHolder.traintyColor;
                Context context6 = this.mContext;
                Object obj6 = d7.a;
                imageView6.setColorFilter(d7.b.a(context6, R.color.green_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("S")) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView7 = trainListItemHolder.traintyColor;
                Context context7 = this.mContext;
                Object obj7 = d7.a;
                imageView7.setColorFilter(d7.b.a(context7, R.color.Shatabdi_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals(PaymentConstants.Category.JS)) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView8 = trainListItemHolder.traintyColor;
                Context context8 = this.mContext;
                Object obj8 = d7.a;
                imageView8.setColorFilter(d7.b.a(context8, R.color.Janshatabdi_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("Y")) {
                trainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView9 = trainListItemHolder.traintyColor;
                Context context9 = this.mContext;
                Object obj9 = d7.a;
                imageView9.setColorFilter(d7.b.a(context9, R.color.Yuva_train_color));
            }
        }
        onRunningDayStatus(trainListItemHolder, trainBtwnStnsDTO);
        trainBtwnStnsDTO.getTrainType();
        trainBtwnStnsDTO.getDepartureDate();
        trainListItemHolder.checkAvailiability.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LapTrainListAdapter lapTrainListAdapter = LapTrainListAdapter.this;
                TrainListItemHolder trainListItemHolder = trainListItemHolder;
                lapTrainListAdapter.allLapAvlEnqService(trainListItemHolder.checkAvailiability, trainListItemHolder.rvClassFareAvl);
                Lap2TrainListHAdapterListener lap2TrainListHAdapterListener = LapTrainListAdapter.this.listener;
                if (lap2TrainListHAdapterListener != null) {
                    lap2TrainListHAdapterListener.onCheckAvailbialityClick(trainBtwnStnsModel);
                }
            }
        });
        onSetListeners(trainListItemHolder, trainBtwnStnsModel);
    }

    public String format(String str, String str2) {
        new SimpleDateFormat();
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat(str2).format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }
}
