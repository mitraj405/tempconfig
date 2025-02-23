package cris.org.in.ima.adaptors;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.AvailabilityViewHolder;
import cris.org.in.ima.adaptors.AvlClassViewHolder;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.AllTrainListFragment;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import rx.Subscriber;

public class TrainListViewHolder extends RecyclerView.Adapter<TrainListItemHolder> {
    /* access modifiers changed from: private */
    public static final String TAG = C1354qp.R(TrainListViewHolder.class);
    static TrainBtwnStnsModel currentItem;
    private String arrivalDate;
    List<TrainBtwnStnsModel> aternatetrainBtwnStnsModels;
    AvailabilitywithClassFareViewHolder availabilitywithClassFareViewHolder;
    private String departureDate;
    ProgressDialog dialog;
    private GoogleAdParamDTO googleAd;
    TrainListHolderListener listener;
    /* access modifiers changed from: private */
    public TrainTypeAdaptor mAdapter;
    AvailabilityViewHolder.AvailabilityViewHolderListener mAvailabilityListener;
    public AvlClassViewHolder.AvlClassViewHolderListener mAvlClsHolderListener = new AvlClassViewHolder.AvlClassViewHolderListener() {
        public void onItemClick(AvlClassModel avlClassModel) {
            Iterator<TrainBtwnStnsModel> it = TrainListViewHolder.this.trainBtwnStnsModels.iterator();
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
                    TrainListHolderListener trainListHolderListener = TrainListViewHolder.this.listener;
                    if (trainListHolderListener != null) {
                        trainListHolderListener.onTrainLayoutClick(AllTrainListFragment.f4414b, true, true);
                    }
                }
            }
            if (AllTrainListFragment.f4414b != null) {
                TrainListViewHolder.this.notifyItemChanged(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;
    private ArrayList<C0503FA> mTrainList;
    int retryCount = 0;
    /* access modifiers changed from: private */
    public String selectedQuota;
    String spConcession = "";
    StationDb stationDb = C0793b1.a.f3911a;
    List<TrainBtwnStnsModel> trainBtwnStnsModels;
    /* access modifiers changed from: private */
    public int updateavlshowValue = 12;
    ArrayList<WrapperAvailablityWithClassFareModel> wrapperAvailablityWithClassFareModels = null;

    public interface TrainListHolderListener {
        void onTrainLayoutClick(TrainBtwnStnsModel trainBtwnStnsModel, boolean z, boolean z2);

        void onTrainLayoutNotify(TrainBtwnStnsModel trainBtwnStnsModel, boolean z, boolean z2);
    }

    public class TrainListItemHolder extends RecyclerView.ViewHolder {
        TextView arrDate;
        TextView arvTime;
        LinearLayout avl_other_date_ll;
        LinearLayout cnf_probability_ll;
        TextView depDate;
        TextView depTime;
        TextView friday;
        TextView fromCityCode;
        TextView fromCityName;
        TextView monday;
        LinearLayout other_dates_cnf_update_ll;
        ImageView routMap;
        RecyclerView rvAvailabilityList;
        RecyclerView rvClassFareAvl;
        RecyclerView rvTrainClass;
        TextView saturday;
        TextView sunday;
        TextView thursday;
        TextView toCityCode;
        TextView toCityName;
        CardView trainDetail;
        AdManagerAdView trainListCenter;
        TextView trainName;
        TextView trainNo;
        ImageView traintyColor;
        TextView travelTime;
        TextView tuesday;
        TextView tv_avl_updates;
        TextView tv_close;
        TextView tv_cnf_probability;
        ImageView tv_favpnricon;
        TextView tv_otherdate;
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
            this.tv_favpnricon = (ImageView) view.findViewById(R.id.tv_favpnricon);
            this.depDate = (TextView) view.findViewById(R.id.tv_dep_date);
            this.arrDate = (TextView) view.findViewById(R.id.tv_arr_date);
            this.trainListCenter = (AdManagerAdView) view.findViewById(R.id.train_list_center);
        }
    }

    public TrainListViewHolder(Context context, List<TrainBtwnStnsModel> list, List<TrainBtwnStnsModel> list2, TrainListHolderListener trainListHolderListener, String str) {
        this.trainBtwnStnsModels = list;
        this.aternatetrainBtwnStnsModels = list2;
        this.mContext = context;
        this.listener = trainListHolderListener;
        this.selectedQuota = str;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3 A[SYNTHETIC, Splitter:B:28:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd A[Catch:{ Exception -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3 A[Catch:{ Exception -> 0x0151 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0 A[Catch:{ Exception -> 0x0151 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void availabilityClicked(cris.org.in.ima.model.AvlClassModel r15, boolean r16, boolean r17, androidx.recyclerview.widget.RecyclerView r18, android.widget.TextView r19) {
        /*
            r14 = this;
            r9 = r14
            cris.org.in.ima.model.TrainBtwnStnsModel r6 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            r0 = 0
            cris.org.in.ima.fragment.AllTrainListFragment.f4415b = r0
            android.content.Context r0 = r9.mContext
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.content.Context r1 = r9.mContext
            boolean r0 = defpackage.C0535I5.O(r0, r1)
            if (r0 != 0) goto L_0x0028
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            cris.org.in.ima.adaptors.TrainListViewHolder$12 r1 = new cris.org.in.ima.adaptors.TrainListViewHolder$12
            r1.<init>()
            r2 = 5000(0x1388, double:2.4703E-320)
            r0.postDelayed(r1, r2)
            return
        L_0x0028:
            boolean r0 = defpackage.C0535I5.M()
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0046
            boolean r3 = defpackage.C0535I5.R()
            if (r3 != 0) goto L_0x0046
            long r3 = defpackage.C1450w1.f7005a
            r5 = 2
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x0042
            cris.org.in.ima.activities.HomeActivity.A(r1)
            goto L_0x0045
        L_0x0042:
            cris.org.in.ima.activities.HomeActivity.A(r2)
        L_0x0045:
            return
        L_0x0046:
            android.app.ProgressDialog r3 = r9.dialog     // Catch:{ Exception -> 0x0151 }
            if (r3 == 0) goto L_0x0050
            boolean r3 = r3.isShowing()     // Catch:{ Exception -> 0x0151 }
            if (r3 != 0) goto L_0x0073
        L_0x0050:
            android.content.Context r3 = r9.mContext     // Catch:{ Exception -> 0x0151 }
            android.content.res.Resources r4 = r3.getResources()     // Catch:{ Exception -> 0x0151 }
            r5 = 2131951654(0x7f130026, float:1.9539729E38)
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x0151 }
            android.content.Context r5 = r9.mContext     // Catch:{ Exception -> 0x0151 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0151 }
            r7 = 2131953495(0x7f130757, float:1.9543463E38)
            java.lang.String r5 = r5.getString(r7)     // Catch:{ Exception -> 0x0151 }
            android.app.ProgressDialog r3 = android.app.ProgressDialog.show(r3, r4, r5)     // Catch:{ Exception -> 0x0151 }
            r9.dialog = r3     // Catch:{ Exception -> 0x0151 }
            r3.show()     // Catch:{ Exception -> 0x0151 }
        L_0x0073:
            Ga r3 = new Ga     // Catch:{ Exception -> 0x0151 }
            r3.<init>()     // Catch:{ Exception -> 0x0151 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0151 }
            r3.setMoreThanOneDay(r4)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = cris.org.in.ima.fragment.AllTrainListFragment.m     // Catch:{ Exception -> 0x0151 }
            java.lang.String r5 = "Y"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0151 }
            r5 = 0
            if (r4 != 0) goto L_0x0095
            java.lang.String r4 = cris.org.in.ima.fragment.AllTrainListFragment.l     // Catch:{ Exception -> 0x0151 }
            java.lang.String r7 = "HP"
            boolean r4 = r4.equals(r7)     // Catch:{ Exception -> 0x0151 }
            if (r4 == 0) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r4 = r5
            goto L_0x0096
        L_0x0095:
            r4 = r2
        L_0x0096:
            r3.setConcessionBooking(r4)     // Catch:{ Exception -> 0x0151 }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r6.f5342a     // Catch:{ Exception -> 0x0151 }
            java.util.Date r4 = r4.getJourneyDate()     // Catch:{ Exception -> 0x0151 }
            cris.prs.webservices.dto.TrainBtwnStnsDTO r7 = r6.f5342a
            if (r4 == 0) goto L_0x00bd
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0151 }
            java.lang.String r8 = "yyyyMMdd"
            r4.<init>(r8)     // Catch:{ Exception -> 0x0151 }
            java.util.Date r8 = r7.getJourneyDate()     // Catch:{ Exception -> 0x0151 }
            long r10 = r8.getTime()     // Catch:{ Exception -> 0x0151 }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = r4.format(r8)     // Catch:{ Exception -> 0x0151 }
            cris.org.in.ima.fragment.AllTrainListFragment.j = r4     // Catch:{ Exception -> 0x0151 }
            goto L_0x00c1
        L_0x00bd:
            java.lang.String r4 = cris.org.in.ima.fragment.AllTrainListFragment.k     // Catch:{ Exception -> 0x0151 }
            cris.org.in.ima.fragment.AllTrainListFragment.j = r4     // Catch:{ Exception -> 0x0151 }
        L_0x00c1:
            if (r0 != 0) goto L_0x00d1
            boolean r0 = defpackage.C0535I5.R()     // Catch:{ Exception -> 0x0151 }
            if (r0 == 0) goto L_0x00ca
            goto L_0x00d1
        L_0x00ca:
            java.lang.Object r0 = defpackage.C0657Qt.b()     // Catch:{ Exception -> 0x0151 }
            Om r0 = (defpackage.Om) r0     // Catch:{ Exception -> 0x0151 }
            goto L_0x00db
        L_0x00d1:
            b1 r0 = defpackage.C0793b1.a     // Catch:{ Exception -> 0x0151 }
            kn r0 = r0.f3912a     // Catch:{ Exception -> 0x0151 }
            java.lang.Object r0 = defpackage.C0657Qt.c(r0)     // Catch:{ Exception -> 0x0151 }
            Om r0 = (defpackage.Om) r0     // Catch:{ Exception -> 0x0151 }
        L_0x00db:
            r4 = r15
            java.lang.String r8 = r4.c     // Catch:{ Exception -> 0x0151 }
            if (r8 == 0) goto L_0x00e2
            defpackage.C0535I5.k = r8     // Catch:{ Exception -> 0x0151 }
        L_0x00e2:
            java.lang.String r8 = defpackage.C0657Qt.f()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r10 = "avlFarenquiry"
            java.lang.String r11 = "/%s/%s/%s/%s/%s/%s/%s"
            r12 = 7
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0151 }
            java.lang.String r13 = r7.getTrainNumber()     // Catch:{ Exception -> 0x0151 }
            r12[r5] = r13     // Catch:{ Exception -> 0x0151 }
            java.lang.String r5 = cris.org.in.ima.fragment.AllTrainListFragment.j     // Catch:{ Exception -> 0x0151 }
            r12[r2] = r5     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r7.getFromStnCode()     // Catch:{ Exception -> 0x0151 }
            r12[r1] = r2     // Catch:{ Exception -> 0x0151 }
            java.lang.String r1 = r7.getToStnCode()     // Catch:{ Exception -> 0x0151 }
            r2 = 3
            r12[r2] = r1     // Catch:{ Exception -> 0x0151 }
            java.lang.String r1 = defpackage.C0535I5.k     // Catch:{ Exception -> 0x0151 }
            r2 = 4
            r12[r2] = r1     // Catch:{ Exception -> 0x0151 }
            java.lang.String r1 = cris.org.in.ima.fragment.AllTrainListFragment.l     // Catch:{ Exception -> 0x0151 }
            r2 = 5
            r12[r2] = r1     // Catch:{ Exception -> 0x0151 }
            java.lang.String r1 = "N"
            r2 = 6
            r12[r2] = r1     // Catch:{ Exception -> 0x0151 }
            java.lang.String r1 = java.lang.String.format(r11, r12)     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r2.<init>()     // Catch:{ Exception -> 0x0151 }
            r2.append(r8)     // Catch:{ Exception -> 0x0151 }
            r2.append(r10)     // Catch:{ Exception -> 0x0151 }
            r2.append(r1)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0151 }
            rx.Observable r0 = r0.c1(r1, r3)     // Catch:{ Exception -> 0x0151 }
            Lm r1 = defpackage.C1181iv.a()     // Catch:{ Exception -> 0x0151 }
            rx.Observable r0 = r0.c(r1)     // Catch:{ Exception -> 0x0151 }
            Yi r1 = defpackage.E0.a()     // Catch:{ Exception -> 0x0151 }
            rx.Observable r0 = r0.a(r1)     // Catch:{ Exception -> 0x0151 }
            cris.org.in.ima.adaptors.TrainListViewHolder$13 r10 = new cris.org.in.ima.adaptors.TrainListViewHolder$13     // Catch:{ Exception -> 0x0151 }
            r1 = r10
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r7 = r18
            r8 = r19
            r1.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0151 }
            r0.b(r10)     // Catch:{ Exception -> 0x0151 }
            goto L_0x0166
        L_0x0151:
            r0 = move-exception
            r0.getMessage()
            android.app.ProgressDialog r0 = r9.dialog
            r0.dismiss()
            android.content.Context r0 = r9.mContext
            r1 = 2131953492(0x7f130754, float:1.9543457E38)
            java.lang.String r1 = r0.getString(r1)
            defpackage.C0535I5.t0(r0, r1)
        L_0x0166:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.adaptors.TrainListViewHolder.availabilityClicked(cris.org.in.ima.model.AvlClassModel, boolean, boolean, androidx.recyclerview.widget.RecyclerView, android.widget.TextView):void");
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
            C0535I5.t0(context, context.getResources().getString(R.string.class_selection_error_message));
        } else {
            Context context2 = this.mContext;
            final ProgressDialog show = ProgressDialog.show(context2, context2.getResources().getString(R.string.add_fav_jrny_list), this.mContext.getResources().getString(R.string.please_wait_text));
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).q1(str, str2, str3, str4, str5).c(C1181iv.a()).a(E0.a()).b(new Subscriber<StatusDTO>() {
                public void onCompleted() {
                    String unused = TrainListViewHolder.TAG;
                    show.dismiss();
                }

                public void onError(Throwable th) {
                    String unused = TrainListViewHolder.TAG;
                    String unused2 = TrainListViewHolder.TAG;
                    th.getMessage();
                    show.dismiss();
                    Lt.a(true, th);
                }

                public void onNext(final StatusDTO statusDTO) {
                    String next;
                    String str;
                    String str2;
                    String unused = TrainListViewHolder.TAG;
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
                                C0535I5.p(TrainListViewHolder.this.mContext, false, str3, TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                            } else if (statusDTO.getError() == null || statusDTO.getError().equals("")) {
                                show.dismiss();
                                C0535I5.p(TrainListViewHolder.this.mContext, false, statusDTO.getStatus(), TrainListViewHolder.this.mContext.getResources().getString(R.string.confirmation), TrainListViewHolder.this.mContext.getResources().getString(R.string.OK), new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        C0535I5.f3640e.clear();
                                        if (statusDTO.getStatus().equals("Journey List Saved Successfully ...")) {
                                            AnonymousClass15 r2 = AnonymousClass15.this;
                                            imageView.setColorFilter(TrainListViewHolder.this.mContext.getResources().getColor(R.color.red));
                                            AllTrainListFragment.f4417k = true;
                                            return;
                                        }
                                        AnonymousClass15 r22 = AnonymousClass15.this;
                                        imageView.setColorFilter(TrainListViewHolder.this.mContext.getResources().getColor(R.color.grey));
                                        AllTrainListFragment.f4417k = false;
                                    }
                                }, (String) null, (DialogInterface.OnClickListener) null).show();
                            } else {
                                show.dismiss();
                                C0535I5.m(TrainListViewHolder.this.mContext, false, statusDTO.getError(), TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                            }
                        } catch (Exception e) {
                            String unused2 = TrainListViewHolder.TAG;
                            e.getMessage();
                            show.dismiss();
                            C0535I5.m(TrainListViewHolder.this.mContext, false, TrainListViewHolder.this.mContext.getResources().getString(R.string.Unable_process_request), TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                    } else {
                        show.dismiss();
                        C0535I5.m(TrainListViewHolder.this.mContext, false, TrainListViewHolder.this.mContext.getResources().getString(R.string.Unable_process_request), TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                }
            });
        }
    }

    public void allLapAvlEnqService(AvlClassModel avlClassModel, boolean z, boolean z2, RecyclerView recyclerView, boolean z3) {
        Om om;
        final TrainBtwnStnsModel trainBtwnStnsModel = AllTrainListFragment.f4414b;
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
                    String unused = TrainListViewHolder.TAG;
                    TrainListViewHolder.this.dialog.dismiss();
                }

                public void onError(Throwable th) {
                    String unused = TrainListViewHolder.TAG;
                    String unused2 = TrainListViewHolder.TAG;
                    th.getMessage();
                    TrainListViewHolder.this.dialog.dismiss();
                    Lt.a(true, th);
                }

                public void onNext(TrainBtwnStnsRespDto trainBtwnStnsRespDto) {
                    String unused = TrainListViewHolder.TAG;
                    Objects.toString(trainBtwnStnsRespDto);
                    if (trainBtwnStnsRespDto != null) {
                        C0657Qt.h();
                        try {
                            if (trainBtwnStnsRespDto.getErrorMessage() == null) {
                                TrainListViewHolder.this.dialog.dismiss();
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
                                            for (TrainBtwnStnsModel next3 : TrainListViewHolder.this.trainBtwnStnsModels) {
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
                                                            TrainListViewHolder.this.trainBtwnStnsModels.get(i).f5342a.getClassAvlDTO().set(i2, next.getClassAvlDTO().get(0));
                                                            C0535I5.h = next4.getEnqClass();
                                                            C0535I5.i = trainBtwnStnsDTO2.getTrainNumber();
                                                            TrainBtwnStnsModel trainBtwnStnsModel = TrainListViewHolder.this.trainBtwnStnsModels.get(i);
                                                            trainBtwnStnsModel.getClass();
                                                            trainBtwnStnsModel.f5348c = next4.getEnqClass();
                                                            AllTrainListFragment.f4414b = trainBtwnStnsModel;
                                                            TrainListHolderListener trainListHolderListener = TrainListViewHolder.this.listener;
                                                            if (trainListHolderListener != null) {
                                                                trainListHolderListener.onTrainLayoutClick(trainBtwnStnsModel, true, false);
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
                                        C0535I5.m(TrainListViewHolder.this.mContext, false, str, TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                                        return;
                                    }
                                    TrainListHolderListener trainListHolderListener2 = TrainListViewHolder.this.listener;
                                    if (trainListHolderListener2 == null || !AllTrainListFragment.f4418l) {
                                        trainListHolderListener2.onTrainLayoutClick(AllTrainListFragment.f4414b, true, false);
                                    } else {
                                        trainListHolderListener2.onTrainLayoutClick(AllTrainListFragment.f4414b, true, false);
                                    }
                                }
                                TrainListViewHolder.this.notifyDataSetChanged();
                                return;
                            }
                            TrainListViewHolder.this.dialog.dismiss();
                            C0535I5.m(TrainListViewHolder.this.mContext, false, trainBtwnStnsRespDto.getErrorMessage(), TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        } catch (Exception e) {
                            String unused2 = TrainListViewHolder.TAG;
                            e.getMessage();
                            TrainListViewHolder.this.dialog.dismiss();
                            C0535I5.m(TrainListViewHolder.this.mContext, false, TrainListViewHolder.this.mContext.getResources().getString(R.string.Unable_process_request), TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                    } else {
                        TrainListViewHolder.this.dialog.dismiss();
                        C0535I5.m(TrainListViewHolder.this.mContext, false, TrainListViewHolder.this.mContext.getResources().getString(R.string.Unable_process_request), TrainListViewHolder.this.mContext.getResources().getString(R.string.error), TrainListViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
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
        return new TrainListItemHolder(C1058d.s(viewGroup, R.layout.item_train_list1, viewGroup, false));
    }

    public void onRunningDayStatus(TrainListItemHolder trainListItemHolder, TrainBtwnStnsDTO trainBtwnStnsDTO) {
        if (trainBtwnStnsDTO.getRunningSun() != null) {
            if (trainBtwnStnsDTO.getRunningSun().equals("Y")) {
                trainListItemHolder.sunday.setEnabled(true);
                trainListItemHolder.sunday.setContentDescription("sunday");
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
                trainListItemHolder.monday.setContentDescription("monday");
                trainListItemHolder.monday.setText("M");
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
                trainListItemHolder.tuesday.setContentDescription("tuesday");
                trainListItemHolder.tuesday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
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
                trainListItemHolder.wednesday.setContentDescription("wednesday");
                trainListItemHolder.wednesday.setText("W");
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
        trainListItemHolder.saturday.setContentDescription("saturday");
        trainListItemHolder.saturday.setText("S");
        trainListItemHolder.saturday.setEnabled(false);
        TextView textView14 = trainListItemHolder.saturday;
        Context context14 = this.mContext;
        Object obj14 = d7.a;
        textView14.setTextColor(d7.b.a(context14, R.color.shadow_line2));
    }

    public void onSetListeners(final TrainListItemHolder trainListItemHolder, final TrainBtwnStnsModel trainBtwnStnsModel) {
        trainListItemHolder.routMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Om om;
                if (trainBtwnStnsModel.f5342a.getJourneyDate() != null) {
                    AllTrainListFragment.j = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(trainBtwnStnsModel.f5342a.getJourneyDate());
                } else {
                    AllTrainListFragment.j = AllTrainListFragment.k;
                }
                String trainNumber = trainBtwnStnsModel.f5342a.getTrainNumber();
                String fromStnCode = trainBtwnStnsModel.f5342a.getFromStnCode();
                String str = AllTrainListFragment.j;
                Context access$000 = TrainListViewHolder.this.mContext;
                if (!C0535I5.O((ConnectivityManager) access$000.getSystemService("connectivity"), access$000)) {
                    new Handler().postDelayed(new C1417u0(), 5000);
                    return;
                }
                C0535I5.Y(AllTrainListFragment.f4409a, AllTrainListFragment.f4411a, AllTrainListFragment.f4412a);
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
                                om.h0(f + "trnscheduleenquiry" + format, fromStnCode, str).c(C1181iv.a()).a(E0.a()).b(new C1434v0(progressDialog, trainNumber, access$000));
                            }
                        }
                        om = (Om) C0657Qt.c(C0793b1.a.f3912a);
                        String f2 = C0657Qt.f();
                        String format2 = String.format("/%s", new Object[]{trainNumber});
                        om.h0(f2 + "trnscheduleenquiry" + format2, fromStnCode, str).c(C1181iv.a()).a(E0.a()).b(new C1434v0(progressDialog, trainNumber, access$000));
                    } else if (C1450w1.f7005a == 2) {
                        HomeActivity.A(2);
                    } else {
                        HomeActivity.A(1);
                    }
                } catch (Exception e) {
                    e.getMessage();
                    C0535I5.t0(access$000, access$000.getString(R.string.please_try_again));
                }
            }
        });
        trainListItemHolder.traintyColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TrainListViewHolder.this.mContext);
                builder.setTitle(TrainListViewHolder.this.mContext.getString(R.string.train_type));
                builder.setAdapter(TrainListViewHolder.this.mAdapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton(TrainListViewHolder.this.mContext.getString(R.string.ok), new DialogInterface.OnClickListener() {
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
                TrainListViewHolder trainListViewHolder = TrainListViewHolder.this;
                AvlClassModel avlClassModel = new AvlClassModel(AllTrainListFragment.f4414b.f5348c);
                TrainListItemHolder trainListItemHolder = trainListItemHolder;
                trainListViewHolder.availabilityClicked(avlClassModel, true, false, trainListItemHolder.rvAvailabilityList, trainListItemHolder.tv_avl_updates);
            }
        });
        trainListItemHolder.tv_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                trainListItemHolder.avl_other_date_ll.setVisibility(8);
                trainListItemHolder.rvClassFareAvl.setVisibility(0);
                trainListItemHolder.other_dates_cnf_update_ll.setVisibility(0);
                trainListItemHolder.tv_otherdate.setVisibility(0);
                trainListItemHolder.tv_avl_updates.setVisibility(0);
                int i = -1;
                if (trainBtwnStnsModel.f5342a.getClassAvlDTO() != null) {
                    for (ClassAvlDTO enqClass : trainBtwnStnsModel.f5342a.getClassAvlDTO()) {
                        i++;
                        if (enqClass.getEnqClass().equalsIgnoreCase(AllTrainListFragment.f4414b.f5348c)) {
                            break;
                        }
                    }
                }
                if (!(trainBtwnStnsModel.f5342a.getClassAvlDTO() == null || trainBtwnStnsModel.f5342a.getClassAvlDTO().get(i).getErrorMessage() == null)) {
                    trainListItemHolder.tv_otherdate.setVisibility(8);
                    trainListItemHolder.tv_avl_updates.setVisibility(8);
                }
                if (trainBtwnStnsModel.f5342a.getClassAvlDTO() == null) {
                    trainListItemHolder.tv_otherdate.setVisibility(8);
                    trainListItemHolder.tv_avl_updates.setVisibility(8);
                }
            }
        });
        trainListItemHolder.tv_favpnricon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TrainBtwnStnsModel trainBtwnStnsModel = AllTrainListFragment.f4414b;
                if (trainBtwnStnsModel != null) {
                    TrainListViewHolder trainListViewHolder = TrainListViewHolder.this;
                    String fromStnCode = trainBtwnStnsModel.f5342a.getFromStnCode();
                    TrainBtwnStnsDTO trainBtwnStnsDTO = trainBtwnStnsModel.f5342a;
                    trainListViewHolder.addFavouriteList(fromStnCode, trainBtwnStnsDTO.getToStnCode(), trainBtwnStnsDTO.getTrainNumber(), TrainListViewHolder.this.selectedQuota, trainBtwnStnsModel.f5348c, trainListItemHolder.tv_favpnricon);
                    return;
                }
                C0535I5.t0(TrainListViewHolder.this.mContext, TrainListViewHolder.this.mContext.getResources().getString(R.string.class_selection_error_message));
            }
        });
    }

    public void reCallAvlEnq(final AvlClassModel avlClassModel, AvlFareResponseDTO avlFareResponseDTO, final boolean z, final boolean z2) {
        int i;
        try {
            AnonymousClass9 r1 = new Runnable() {
                public void run() {
                    TrainListViewHolder.this.availabilityClicked(avlClassModel, z, z2, (RecyclerView) null, (TextView) null);
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

    /* JADX WARNING: Removed duplicated region for block: B:110:0x057e  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x06af  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x03c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(final cris.org.in.ima.adaptors.TrainListViewHolder.TrainListItemHolder r14, int r15) {
        /*
            r13 = this;
            java.lang.String r0 = "yyyyMMdd"
            java.util.List<cris.org.in.ima.model.TrainBtwnStnsModel> r1 = r13.trainBtwnStnsModels
            java.lang.Object r1 = r1.get(r15)
            cris.org.in.ima.model.TrainBtwnStnsModel r1 = (cris.org.in.ima.model.TrainBtwnStnsModel) r1
            currentItem = r1
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "spConcession"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            r13.spConcession = r2
            cris.org.in.ima.model.TrainBtwnStnsModel r2 = currentItem
            cris.prs.webservices.dto.AvlFareResponseDTO r2 = r2.a
            if (r2 == 0) goto L_0x0026
            cris.prs.webservices.dto.AvlFareResponseDTO r2 = r1.a
            r2.toString()
        L_0x0026:
            android.widget.TextView r2 = r14.trainNo
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            cris.prs.webservices.dto.TrainBtwnStnsDTO r4 = r1.f5342a
            java.lang.String r4 = r4.getTrainNumber()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.setText(r3)
            android.widget.TextView r2 = r14.trainNo
            cris.prs.webservices.dto.TrainBtwnStnsDTO r3 = r1.f5342a
            java.lang.String r4 = r3.getTrainNumber()
            java.lang.String r5 = ""
            java.lang.String r6 = " "
            java.lang.String r4 = r4.replace(r5, r6)
            java.lang.String r4 = r4.trim()
            r2.setContentDescription(r4)
            android.widget.TextView r2 = r14.trainName
            java.lang.String r4 = r3.getTrainName()
            r2.setText(r4)
            android.widget.TextView r2 = r14.fromCityName
            cris.org.in.ima.db.StationDb r4 = r13.stationDb
            java.lang.String r7 = r3.getFromStnCode()
            java.lang.String r4 = r4.m(r7)
            java.lang.String r4 = defpackage.C0535I5.s0(r4)
            r2.setText(r4)
            android.widget.TextView r2 = r14.fromCityCode
            r4 = 8
            r2.setVisibility(r4)
            android.widget.TextView r2 = r14.toCityName
            cris.org.in.ima.db.StationDb r7 = r13.stationDb
            java.lang.String r8 = r3.getToStnCode()
            java.lang.String r7 = r7.m(r8)
            java.lang.String r7 = defpackage.C0535I5.s0(r7)
            r2.setText(r7)
            android.widget.TextView r2 = r14.toCityCode
            r2.setVisibility(r4)
            android.widget.TextView r2 = r14.depTime
            java.lang.String r4 = r3.getDepartureTime()
            r2.setText(r4)
            android.widget.TextView r2 = r14.arvTime
            java.lang.String r4 = r3.getArrivalTime()
            r2.setText(r4)
            java.lang.String r2 = r3.getDuration()
            java.lang.String r4 = ":"
            java.lang.String[] r2 = r2.split(r4)
            int r4 = r2.length
            r7 = 3
            r8 = 1
            r9 = 0
            r10 = 2
            java.lang.String r11 = "h:"
            if (r4 != r10) goto L_0x00d1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r10 = r2[r9]
            r4.append(r10)
            r4.append(r11)
            r2 = r2[r8]
            java.lang.String r10 = "m"
            java.lang.String r2 = defpackage.C0709Uj.j(r4, r2, r10)
            goto L_0x00ff
        L_0x00d1:
            int r4 = r2.length
            if (r4 != r7) goto L_0x00f4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r12 = r2[r9]
            r4.append(r12)
            r4.append(r11)
            r11 = r2[r8]
            r4.append(r11)
            java.lang.String r11 = "m:"
            r4.append(r11)
            r2 = r2[r10]
            java.lang.String r10 = "s"
            java.lang.String r2 = defpackage.C0709Uj.j(r4, r2, r10)
            goto L_0x00ff
        L_0x00f4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r2 = r2[r9]
            java.lang.String r2 = defpackage.C0709Uj.j(r4, r2, r11)
        L_0x00ff:
            android.widget.TextView r4 = r14.travelTime
            r4.setText(r2)
            java.lang.String r2 = cris.org.in.ima.IrctcImaApplication.e
            java.lang.String r4 = "hi"
            boolean r2 = r2.equals(r4)
            java.lang.String r10 = "IN"
            java.lang.String r11 = "dd-MM-yyyy"
            if (r2 == 0) goto L_0x011d
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r4, r10)
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat
            r12.<init>(r11, r2)
            goto L_0x0124
        L_0x011d:
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            r12.<init>(r11, r2)
        L_0x0124:
            java.util.Date r2 = r3.getJourneyDate()
            if (r2 == 0) goto L_0x017e
            java.lang.String r2 = cris.org.in.ima.IrctcImaApplication.e
            boolean r2 = r2.equals(r4)
            java.lang.String r11 = "EEE, dd MMM"
            if (r2 == 0) goto L_0x013f
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r4, r10)
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            r4.<init>(r11, r2)
            goto L_0x0146
        L_0x013f:
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            r4.<init>(r11, r2)
        L_0x0146:
            java.util.Date r2 = r3.getJourneyDate()
            java.lang.String r2 = r4.format(r2)
            r13.departureDate = r2
            java.util.Date r2 = r3.getJourneyDate()
            java.lang.String r2 = r12.format(r2)
            java.lang.String r4 = r3.getDepartureTime()
            java.lang.String r10 = r3.getDuration()
            java.lang.String r2 = r13.getArvDate(r2, r4, r10)
            r13.arrivalDate = r2
            android.widget.TextView r2 = r14.depDate
            java.lang.String r4 = r13.departureDate
            r2.setText(r4)
            android.widget.TextView r2 = r14.arrDate
            java.lang.String r4 = r13.arrivalDate
            r2.setText(r4)
            android.widget.TextView r2 = r14.depDate
            r2.setVisibility(r9)
            android.widget.TextView r2 = r14.arrDate
            r2.setVisibility(r9)
        L_0x017e:
            java.lang.String r2 = r1.f
            r4 = 0
            if (r2 == 0) goto L_0x01df
            java.lang.String r2 = r3.getDepartureTime()
            if (r2 == 0) goto L_0x01df
            java.lang.String r2 = r3.getDuration()
            if (r2 == 0) goto L_0x01df
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x01b3 }
            r2.<init>(r0)     // Catch:{ ParseException -> 0x01b3 }
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x01b3 }
            java.lang.String r11 = "EEE, dd MMM  yyyy"
            r10.<init>(r11)     // Catch:{ ParseException -> 0x01b3 }
            java.lang.String r11 = r1.f     // Catch:{ ParseException -> 0x01b3 }
            java.util.Date r2 = r2.parse(r11)     // Catch:{ ParseException -> 0x01b3 }
            java.lang.String r2 = r10.format(r2)     // Catch:{ ParseException -> 0x01b3 }
            java.text.SimpleDateFormat r10 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x01b1 }
            r10.<init>(r0)     // Catch:{ ParseException -> 0x01b1 }
            java.lang.String r0 = r1.f     // Catch:{ ParseException -> 0x01b1 }
            java.util.Date r0 = r10.parse(r0)     // Catch:{ ParseException -> 0x01b1 }
            goto L_0x01b9
        L_0x01b1:
            r0 = move-exception
            goto L_0x01b5
        L_0x01b3:
            r0 = move-exception
            r2 = r5
        L_0x01b5:
            r0.getMessage()
            r0 = r4
        L_0x01b9:
            java.lang.String r0 = r12.format(r0)
            java.lang.String r10 = r3.getDepartureTime()
            java.lang.String r11 = r3.getDuration()
            java.lang.String r0 = r13.getArvDate(r0, r10, r11)
            r13.arrivalDate = r0
            android.widget.TextView r10 = r14.arrDate
            r10.setText(r0)
            android.widget.TextView r0 = r14.depDate
            r0.setText(r2)
            android.widget.TextView r0 = r14.depDate
            r0.setVisibility(r9)
            android.widget.TextView r0 = r14.arrDate
            r0.setVisibility(r9)
        L_0x01df:
            r13.initList()
            cris.org.in.ima.adaptors.TrainTypeAdaptor r0 = new cris.org.in.ima.adaptors.TrainTypeAdaptor
            android.content.Context r2 = r13.mContext
            java.util.ArrayList<FA> r10 = r13.mTrainList
            r0.<init>(r2, r10)
            r13.mAdapter = r0
            java.util.List r0 = r3.getTrainType()
            if (r0 == 0) goto L_0x0369
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "O"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x020b
            android.widget.ImageView r0 = r14.traintyColor
            r2 = 4
            r0.setVisibility(r2)
        L_0x020b:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "R"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0232
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131100337(0x7f0602b1, float:1.7813053E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x0232:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "G"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0259
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131100595(0x7f0603b3, float:1.7813576E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x0259:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "SP"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0280
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131100338(0x7f0602b2, float:1.7813055E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x0280:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "ST"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02a7
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131099891(0x7f0600f3, float:1.7812148E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x02a7:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "D"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02ce
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131100662(0x7f0603f6, float:1.7813712E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x02ce:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "SV"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02f5
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131099851(0x7f0600cb, float:1.7812067E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x02f5:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "S"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x031c
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131099651(0x7f060003, float:1.7811661E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x031c:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "JS"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0342
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131099648(0x7f060000, float:1.7811655E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x0342:
            java.util.List r0 = r3.getTrainType()
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "Y"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0369
            android.widget.ImageView r0 = r14.traintyColor
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.traintyColor
            android.content.Context r2 = r13.mContext
            java.lang.Object r10 = defpackage.d7.a
            r10 = 2131099653(0x7f060005, float:1.7811665E38)
            int r2 = defpackage.d7.b.a(r2, r10)
            r0.setColorFilter(r2)
        L_0x0369:
            r13.onRunningDayStatus(r14, r3)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = new cris.org.in.ima.dto.oauth2.GoogleAdParamDTO
            r0.<init>()
            r13.googleAd = r0
            java.lang.String r2 = defpackage.C1450w1.f7009a
            r0.setAge(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r13.googleAd
            java.lang.String r2 = defpackage.C1450w1.f7021c
            r0.setGender(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r13.googleAd
            java.lang.String r2 = cris.org.in.ima.fragment.AllTrainListFragment.q
            r0.setSource(r2)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r0 = r13.googleAd
            java.lang.String r2 = cris.org.in.ima.fragment.AllTrainListFragment.r
            r0.setDestination(r2)
            if (r15 == 0) goto L_0x03a3
            int r15 = r15 + 1
            int r15 = r15 % r7
            if (r15 != 0) goto L_0x03a3
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = r14.trainListCenter
            r15.setVisibility(r9)
            androidx.fragment.app.FragmentActivity r15 = cris.org.in.ima.fragment.AllTrainListFragment.f4409a
            com.google.android.gms.ads.admanager.AdManagerAdView r0 = r14.trainListCenter
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r2 = r13.googleAd
            defpackage.C0535I5.Y(r15, r0, r2)
            goto L_0x03aa
        L_0x03a3:
            com.google.android.gms.ads.admanager.AdManagerAdView r15 = r14.trainListCenter
            r0 = 8
            r15.setVisibility(r0)
        L_0x03aa:
            r3.getTrainType()
            r3.getDepartureDate()
            cris.org.in.ima.adaptors.TrainListViewHolder$1 r15 = new cris.org.in.ima.adaptors.TrainListViewHolder$1
            r15.<init>(r14)
            java.lang.Boolean r0 = r1.f5344a
            boolean r0 = r0.booleanValue()
            java.util.ArrayList r2 = r1.f5346a
            r7 = 5
            java.lang.String r10 = " ago"
            if (r0 == 0) goto L_0x057e
            java.lang.Boolean r0 = r1.b
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0491
            android.widget.ImageView r15 = r14.tv_favpnricon
            r15.setVisibility(r9)
            android.widget.LinearLayout r15 = r14.avl_other_date_ll
            r15.setVisibility(r9)
            android.widget.LinearLayout r15 = r14.other_dates_cnf_update_ll
            r15.setVisibility(r9)
            android.widget.LinearLayout r15 = r14.other_dates_cnf_update_ll
            android.content.Context r0 = r13.mContext
            java.lang.Object r3 = defpackage.d7.a
            r3 = 2131099766(0x7f060076, float:1.7811894E38)
            int r0 = defpackage.d7.b.a(r0, r3)
            r15.setBackgroundColor(r0)
            android.widget.LinearLayout r15 = r14.cnf_probability_ll
            r0 = 8
            r15.setVisibility(r0)
            android.widget.TextView r15 = r14.tv_avl_updates
            r15.setVisibility(r9)
            android.widget.TextView r15 = r14.tv_otherdate
            r15.setVisibility(r0)
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvClassFareAvl
            r15.setVisibility(r0)
            java.util.Iterator r15 = r2.iterator()
        L_0x0403:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x0425
            java.lang.Object r0 = r15.next()
            cris.org.in.ima.model.AvlClassModel r0 = (cris.org.in.ima.model.AvlClassModel) r0
            cris.org.in.ima.model.TrainBtwnStnsModel r3 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            java.lang.String r3 = r3.f5348c
            java.lang.String r4 = r0.c
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0420
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.a = r3
            goto L_0x0403
        L_0x0420:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r0.a = r3
            goto L_0x0403
        L_0x0425:
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvTrainClass
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r13.mContext
            r0.<init>(r3, r9, r9)
            r15.setLayoutManager(r0)
            cris.org.in.ima.adaptors.AvlClassViewHolder r15 = new cris.org.in.ima.adaptors.AvlClassViewHolder
            android.content.Context r0 = r13.mContext
            cris.org.in.ima.adaptors.AvlClassViewHolder$AvlClassViewHolderListener r3 = r13.mAvlClsHolderListener
            r15.<init>(r0, r2, r3)
            androidx.recyclerview.widget.RecyclerView r0 = r14.rvTrainClass
            r0.setAdapter(r15)
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvAvailabilityList
            r0 = 8
            r15.setVisibility(r0)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            cris.org.in.ima.model.TrainBtwnStnsModel r0 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            cris.prs.webservices.dto.AvlFareResponseDTO r0 = r0.a
            java.util.ArrayList r0 = r0.getAvlDayList()
            java.util.Iterator r0 = r0.iterator()
        L_0x0457:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x046e
            java.lang.Object r3 = r0.next()
            d2 r3 = (defpackage.C1060d2) r3
            cris.org.in.ima.model.WrapperAvailablityModel r4 = new cris.org.in.ima.model.WrapperAvailablityModel
            r4.<init>()
            r4.a = r3
            r15.add(r4)
            goto L_0x0457
        L_0x046e:
            androidx.recyclerview.widget.RecyclerView r0 = r14.rvAvailabilityList
            r0.setVisibility(r9)
            androidx.recyclerview.widget.RecyclerView r0 = r14.rvAvailabilityList
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r13.mContext
            r3.<init>(r4, r9, r9)
            r0.setLayoutManager(r3)
            cris.org.in.ima.adaptors.AvailabilityViewHolder r0 = new cris.org.in.ima.adaptors.AvailabilityViewHolder
            android.content.Context r3 = r13.mContext
            cris.org.in.ima.adaptors.AvailabilityViewHolder$AvailabilityViewHolderListener r4 = r13.mAvailabilityListener
            cris.org.in.ima.model.TrainBtwnStnsModel r5 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            r0.<init>(r3, r15, r4, r5)
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvAvailabilityList
            r15.setAdapter(r0)
            goto L_0x06a7
        L_0x0491:
            android.widget.LinearLayout r0 = r14.other_dates_cnf_update_ll
            r0.setVisibility(r9)
            android.widget.LinearLayout r0 = r14.other_dates_cnf_update_ll
            android.content.Context r4 = r13.mContext
            java.lang.Object r5 = defpackage.d7.a
            r5 = 2131100644(0x7f0603e4, float:1.7813675E38)
            int r4 = defpackage.d7.b.a(r4, r5)
            r0.setBackgroundColor(r4)
            android.widget.LinearLayout r0 = r14.cnf_probability_ll
            r4 = 8
            r0.setVisibility(r4)
            android.widget.TextView r0 = r14.tv_avl_updates
            r0.setVisibility(r9)
            android.widget.TextView r0 = r14.tv_otherdate
            r0.setVisibility(r9)
            android.widget.ImageView r0 = r14.tv_favpnricon
            r0.setVisibility(r9)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r13.wrapperAvailablityWithClassFareModels = r0
            java.util.List r0 = r3.getClassAvlDTO()
            if (r0 == 0) goto L_0x0560
            java.util.List r0 = r3.getClassAvlDTO()
            int r0 = r0.size()
            int r0 = r0 - r8
        L_0x04d2:
            if (r0 < 0) goto L_0x0560
            java.util.List r4 = r3.getClassAvlDTO()
            java.lang.Object r4 = r4.get(r0)
            cris.prs.webservices.dto.ClassAvlDTO r4 = (cris.prs.webservices.dto.ClassAvlDTO) r4
            cris.org.in.ima.model.WrapperAvailablityWithClassFareModel r5 = new cris.org.in.ima.model.WrapperAvailablityWithClassFareModel
            r5.<init>()
            java.lang.String r11 = r4.getEnqClass()
            cris.org.in.ima.model.TrainBtwnStnsModel r12 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            java.lang.String r12 = r12.f5348c
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x0547
            r5.f5353a = r8
            java.lang.String r8 = r4.getLastUpdateTime()
            if (r8 == 0) goto L_0x0549
            android.widget.TextView r8 = r14.tv_avl_updates
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r4.getLastUpdateTime()
            r11.append(r12)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r8.setText(r11)
            java.lang.String r8 = r4.getLastUpdateTime()
            java.lang.String[] r8 = r8.split(r6)
            int r8 = r8.length
            if (r8 != r7) goto L_0x0549
            java.lang.String r8 = r4.getLastUpdateTime()     // Catch:{ Exception -> 0x0542 }
            java.lang.String[] r8 = r8.split(r6)     // Catch:{ Exception -> 0x0542 }
            r11 = r8[r9]     // Catch:{ Exception -> 0x0542 }
            r12 = 3
            r8 = r8[r12]     // Catch:{ Exception -> 0x0542 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0542 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x0542 }
            int r11 = r11 * 60
            int r12 = r13.updateavlshowValue     // Catch:{ Exception -> 0x0542 }
            if (r11 > r12) goto L_0x0539
            if (r8 <= r12) goto L_0x0549
        L_0x0539:
            android.widget.TextView r8 = r14.tv_avl_updates     // Catch:{ Exception -> 0x0542 }
            r11 = 2131232040(0x7f080528, float:1.8080178E38)
            r8.setCompoundDrawablesWithIntrinsicBounds(r9, r9, r11, r9)     // Catch:{ Exception -> 0x0542 }
            goto L_0x0549
        L_0x0542:
            r8 = move-exception
            r8.getMessage()
            goto L_0x0549
        L_0x0547:
            r5.f5353a = r9
        L_0x0549:
            r5.f5352a = r4
            cris.org.in.ima.model.AvlClassModel r8 = new cris.org.in.ima.model.AvlClassModel
            java.lang.String r4 = r4.getEnqClass()
            r8.<init>(r4)
            r5.a = r8
            java.util.ArrayList<cris.org.in.ima.model.WrapperAvailablityWithClassFareModel> r4 = r13.wrapperAvailablityWithClassFareModels
            r4.add(r5)
            int r0 = r0 + -1
            r8 = 1
            goto L_0x04d2
        L_0x0560:
            androidx.recyclerview.widget.RecyclerView r0 = r14.rvClassFareAvl
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r13.mContext
            r3.<init>(r4, r9, r9)
            r0.setLayoutManager(r3)
            cris.org.in.ima.adaptors.AvailabilitywithClassFareViewHolder r0 = new cris.org.in.ima.adaptors.AvailabilitywithClassFareViewHolder
            android.content.Context r3 = r13.mContext
            java.util.ArrayList<cris.org.in.ima.model.WrapperAvailablityWithClassFareModel> r4 = r13.wrapperAvailablityWithClassFareModels
            r0.<init>(r3, r4, r15, r1)
            r13.availabilitywithClassFareViewHolder = r0
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvClassFareAvl
            r15.setAdapter(r0)
            goto L_0x06a7
        L_0x057e:
            android.widget.ImageView r0 = r14.tv_favpnricon
            r8 = 8
            r0.setVisibility(r8)
            android.widget.LinearLayout r0 = r14.avl_other_date_ll
            r0.setVisibility(r8)
            androidx.recyclerview.widget.RecyclerView r0 = r14.rvClassFareAvl
            r0.setVisibility(r9)
            android.widget.LinearLayout r0 = r14.other_dates_cnf_update_ll
            r0.setVisibility(r8)
            android.widget.TextView r0 = r14.tv_otherdate
            r0.setVisibility(r9)
            android.widget.TextView r0 = r14.tv_avl_updates
            r0.setVisibility(r9)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r13.wrapperAvailablityWithClassFareModels = r0
            java.util.List r0 = r3.getClassAvlDTO()
            if (r0 == 0) goto L_0x065b
            java.util.List r0 = r3.getClassAvlDTO()
            int r0 = r0.size()
            int r0 = r0 + -1
        L_0x05b5:
            if (r0 < 0) goto L_0x068a
            java.util.List r4 = r3.getClassAvlDTO()
            java.lang.Object r4 = r4.get(r0)
            cris.prs.webservices.dto.ClassAvlDTO r4 = (cris.prs.webservices.dto.ClassAvlDTO) r4
            cris.org.in.ima.model.WrapperAvailablityWithClassFareModel r8 = new cris.org.in.ima.model.WrapperAvailablityWithClassFareModel
            r8.<init>()
            java.lang.String r11 = defpackage.C0535I5.i
            java.lang.String r12 = r3.getTrainNumber()
            boolean r11 = r11.equalsIgnoreCase(r12)
            if (r11 == 0) goto L_0x05ed
            java.lang.String r11 = defpackage.C0535I5.h
            java.lang.String r12 = r4.getEnqClass()
            boolean r11 = r11.equalsIgnoreCase(r12)
            if (r11 == 0) goto L_0x05ed
            r11 = 1
            r8.f5353a = r11
            defpackage.C0535I5.h = r5
            defpackage.C0535I5.i = r5
            android.widget.LinearLayout r11 = r14.other_dates_cnf_update_ll
            r11.setVisibility(r9)
            android.widget.TextView r9 = cris.org.in.ima.fragment.AllTrainListFragment.f4408a
            goto L_0x05ef
        L_0x05ed:
            r8.f5353a = r9
        L_0x05ef:
            r8.f5352a = r4
            cris.org.in.ima.model.AvlClassModel r9 = new cris.org.in.ima.model.AvlClassModel
            java.lang.String r11 = r4.getEnqClass()
            r9.<init>(r11)
            r8.a = r9
            java.lang.String r9 = r4.getLastUpdateTime()
            if (r9 == 0) goto L_0x0651
            android.widget.TextView r9 = r14.tv_avl_updates
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r4.getLastUpdateTime()
            r11.append(r12)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r9.setText(r11)
            java.lang.String r9 = r4.getLastUpdateTime()
            java.lang.String[] r9 = r9.split(r6)
            int r9 = r9.length
            if (r9 != r7) goto L_0x0651
            java.lang.String r4 = r4.getLastUpdateTime()     // Catch:{ Exception -> 0x064d }
            java.lang.String[] r4 = r4.split(r6)     // Catch:{ Exception -> 0x064d }
            r9 = 0
            r9 = r4[r9]     // Catch:{ Exception -> 0x064d }
            r11 = 3
            r4 = r4[r11]     // Catch:{ Exception -> 0x064d }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x064d }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x064d }
            int r9 = r9 * 60
            int r11 = r13.updateavlshowValue     // Catch:{ Exception -> 0x064d }
            if (r9 > r11) goto L_0x0643
            if (r4 <= r11) goto L_0x0651
        L_0x0643:
            android.widget.TextView r4 = r14.tv_avl_updates     // Catch:{ Exception -> 0x064d }
            r9 = 2131232040(0x7f080528, float:1.8080178E38)
            r11 = 0
            r4.setCompoundDrawablesWithIntrinsicBounds(r11, r11, r9, r11)     // Catch:{ Exception -> 0x064d }
            goto L_0x0651
        L_0x064d:
            r4 = move-exception
            r4.getMessage()
        L_0x0651:
            java.util.ArrayList<cris.org.in.ima.model.WrapperAvailablityWithClassFareModel> r4 = r13.wrapperAvailablityWithClassFareModels
            r4.add(r8)
            int r0 = r0 + -1
            r9 = 0
            goto L_0x05b5
        L_0x065b:
            java.util.List r0 = r3.getAvlClasses()
            int r0 = r0.size()
            int r0 = r0 + -1
        L_0x0665:
            if (r0 < 0) goto L_0x068a
            java.util.List r5 = r3.getAvlClasses()
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            cris.org.in.ima.model.WrapperAvailablityWithClassFareModel r6 = new cris.org.in.ima.model.WrapperAvailablityWithClassFareModel
            r6.<init>()
            r7 = 0
            r6.f5353a = r7
            r6.f5352a = r4
            cris.org.in.ima.model.AvlClassModel r7 = new cris.org.in.ima.model.AvlClassModel
            r7.<init>(r5)
            r6.a = r7
            java.util.ArrayList<cris.org.in.ima.model.WrapperAvailablityWithClassFareModel> r5 = r13.wrapperAvailablityWithClassFareModels
            r5.add(r6)
            int r0 = r0 + -1
            goto L_0x0665
        L_0x068a:
            androidx.recyclerview.widget.RecyclerView r0 = r14.rvClassFareAvl
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r13.mContext
            r5 = 0
            r3.<init>(r4, r5, r5)
            r0.setLayoutManager(r3)
            cris.org.in.ima.adaptors.AvailabilitywithClassFareViewHolder r0 = new cris.org.in.ima.adaptors.AvailabilitywithClassFareViewHolder
            android.content.Context r3 = r13.mContext
            java.util.ArrayList<cris.org.in.ima.model.WrapperAvailablityWithClassFareModel> r4 = r13.wrapperAvailablityWithClassFareModels
            r0.<init>(r3, r4, r15, r1)
            r13.availabilitywithClassFareViewHolder = r0
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvClassFareAvl
            r15.setAdapter(r0)
        L_0x06a7:
            java.lang.Boolean r15 = r1.c
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0732
            android.widget.ImageView r15 = r14.tv_favpnricon
            r0 = 0
            r15.setVisibility(r0)
            android.widget.LinearLayout r15 = r14.avl_other_date_ll
            r15.setVisibility(r0)
            android.widget.LinearLayout r15 = r14.other_dates_cnf_update_ll
            r15.setVisibility(r0)
            android.widget.LinearLayout r15 = r14.cnf_probability_ll
            r3 = 8
            r15.setVisibility(r3)
            android.widget.TextView r15 = r14.tv_avl_updates
            r15.setVisibility(r0)
            android.widget.TextView r15 = r14.tv_otherdate
            r15.setVisibility(r3)
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvClassFareAvl
            r15.setVisibility(r3)
            java.util.Iterator r15 = r2.iterator()
        L_0x06d9:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x06fd
            java.lang.Object r0 = r15.next()
            cris.org.in.ima.model.AvlClassModel r0 = (cris.org.in.ima.model.AvlClassModel) r0
            cris.org.in.ima.model.TrainBtwnStnsModel r3 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            java.lang.String r3 = r3.f5348c
            if (r3 == 0) goto L_0x06f8
            java.lang.String r4 = r0.c
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x06f8
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.a = r3
            goto L_0x06d9
        L_0x06f8:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r0.a = r3
            goto L_0x06d9
        L_0x06fd:
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvTrainClass
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r13.mContext
            r4 = 0
            r0.<init>(r3, r4, r4)
            r15.setLayoutManager(r0)
            cris.org.in.ima.adaptors.AvlClassViewHolder r15 = new cris.org.in.ima.adaptors.AvlClassViewHolder
            android.content.Context r0 = r13.mContext
            cris.org.in.ima.adaptors.AvlClassViewHolder$AvlClassViewHolderListener r3 = r13.mAvlClsHolderListener
            r15.<init>(r0, r2, r3)
            androidx.recyclerview.widget.RecyclerView r0 = r14.rvTrainClass
            r0.setAdapter(r15)
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvAvailabilityList
            r0 = 8
            r15.setVisibility(r0)
            cris.org.in.ima.model.AvlClassModel r3 = new cris.org.in.ima.model.AvlClassModel
            cris.org.in.ima.model.TrainBtwnStnsModel r15 = cris.org.in.ima.fragment.AllTrainListFragment.f4414b
            java.lang.String r15 = r15.f5348c
            r3.<init>(r15)
            r4 = 1
            r5 = 0
            androidx.recyclerview.widget.RecyclerView r6 = r14.rvAvailabilityList
            android.widget.TextView r7 = r14.tv_avl_updates
            r2 = r13
            r2.availabilityClicked(r3, r4, r5, r6, r7)
        L_0x0732:
            android.widget.TextView r15 = r14.tv_otherdate
            cris.org.in.ima.adaptors.TrainListViewHolder$2 r0 = new cris.org.in.ima.adaptors.TrainListViewHolder$2
            r0.<init>(r14, r1)
            r15.setOnClickListener(r0)
            r13.onSetListeners(r14, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.adaptors.TrainListViewHolder.onBindViewHolder(cris.org.in.ima.adaptors.TrainListViewHolder$TrainListItemHolder, int):void");
    }

    public String format(String str, String str2) {
        new SimpleDateFormat();
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat(str2).format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }
}
