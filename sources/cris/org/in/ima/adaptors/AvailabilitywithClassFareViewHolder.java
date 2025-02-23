package cris.org.in.ima.adaptors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.AllTrainListFragment;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.ima.model.WrapperAvailablityWithClassFareModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.ClassAvlDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import defpackage.d7;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

public class AvailabilitywithClassFareViewHolder extends RecyclerView.Adapter<AvailabilityItemHolder> {
    /* access modifiers changed from: private */
    public static final String TAG = C1354qp.R(AvailabilitywithClassFareViewHolder.class);
    AvailabilityViewHolderListener listener;
    Context mContext;
    TrainBtwnStnsModel trainBtwnStnsModel;
    public ArrayList<WrapperAvailablityWithClassFareModel> wrapperAvailablityWithClassFareModels;

    public class AvailabilityItemHolder extends RecyclerView.ViewHolder {
        TextView avlDate;
        TextView avlDetails;
        LinearLayout class_fare_ll;
        TextView cnfProbability;
        LinearLayout main_layout;
        LinearLayout main_ll;
        LinearLayout refresh_ll;
        TextView tv_class;
        TextView tv_fare;

        public AvailabilityItemHolder(View view) {
            super(view);
            this.tv_fare = (TextView) view.findViewById(R.id.tv_fare);
            this.tv_class = (TextView) view.findViewById(R.id.tv_class);
            this.main_ll = (LinearLayout) view.findViewById(R.id.main_ll);
            this.class_fare_ll = (LinearLayout) view.findViewById(R.id.class_fare_ll);
            this.avlDate = (TextView) view.findViewById(R.id.tv_journeyDate);
            this.avlDetails = (TextView) view.findViewById(R.id.tv_avl_detail);
            this.main_layout = (LinearLayout) view.findViewById(R.id.main_layout);
            this.refresh_ll = (LinearLayout) view.findViewById(R.id.refresh_ll);
            this.cnfProbability = (TextView) view.findViewById(R.id.tv_cnf_probability);
        }
    }

    public interface AvailabilityViewHolderListener {
        void onItemClick(WrapperAvailablityWithClassFareModel wrapperAvailablityWithClassFareModel, TrainBtwnStnsModel trainBtwnStnsModel, boolean z);
    }

    public AvailabilitywithClassFareViewHolder(Context context, ArrayList<WrapperAvailablityWithClassFareModel> arrayList, AvailabilityViewHolderListener availabilityViewHolderListener, TrainBtwnStnsModel trainBtwnStnsModel2) {
        this.wrapperAvailablityWithClassFareModels = arrayList;
        this.mContext = context;
        this.listener = availabilityViewHolderListener;
        this.trainBtwnStnsModel = trainBtwnStnsModel2;
    }

    public void allLapAvlEnqService(final ClassAvlDTO classAvlDTO) {
        Om om;
        TrainBtwnStnsModel trainBtwnStnsModel2 = AllTrainListFragment.f4414b;
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
            x0Var.setTrainNo(trainBtwnStnsModel2.f5342a.getTrainNumber());
            TrainBtwnStnsDTO trainBtwnStnsDTO = trainBtwnStnsModel2.f5342a;
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
            x0Var.setQuotaCode(trainBtwnStnsModel2.d);
            x0Var.setSrcStn(trainBtwnStnsDTO.getFromStnCode());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(trainBtwnStnsModel2.f5348c);
            x0Var.setAvlClasses(arrayList2);
            arrayList.add(x0Var);
            e2Var.setAlternateAvlInputDTO(arrayList);
            Context context = this.mContext;
            final ProgressDialog show = ProgressDialog.show(context, context.getResources().getString(R.string.Availability_Search), this.mContext.getResources().getString(R.string.please_wait_text));
            show.show();
            if (M || C0535I5.R()) {
                om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            } else {
                om = (Om) C0657Qt.b();
            }
            String f = C0657Qt.f();
            om.z1(f + "allLapAvlEnq", e2Var).c(C1181iv.a()).a(E0.a()).b(new Subscriber<TrainBtwnStnsRespDto>() {
                public void onCompleted() {
                    String unused = AvailabilitywithClassFareViewHolder.TAG;
                    show.dismiss();
                }

                public void onError(Throwable th) {
                    String unused = AvailabilitywithClassFareViewHolder.TAG;
                    String unused2 = AvailabilitywithClassFareViewHolder.TAG;
                    th.getMessage();
                    show.dismiss();
                    Lt.a(true, th);
                }

                public void onNext(TrainBtwnStnsRespDto trainBtwnStnsRespDto) {
                    String unused = AvailabilitywithClassFareViewHolder.TAG;
                    Objects.toString(trainBtwnStnsRespDto);
                    if (trainBtwnStnsRespDto != null) {
                        C0657Qt.h();
                        try {
                            if (trainBtwnStnsRespDto.getErrorMessage() == null) {
                                show.dismiss();
                                if (trainBtwnStnsRespDto.getTrainBtwnStnsList() != null && trainBtwnStnsRespDto.getTrainBtwnStnsList().size() > 0) {
                                    String str = "";
                                    Iterator<TrainBtwnStnsDTO> it = trainBtwnStnsRespDto.getTrainBtwnStnsList().iterator();
                                    boolean z = false;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        TrainBtwnStnsDTO next = it.next();
                                        Iterator<ClassAvlDTO> it2 = next.getClassAvlDTO().iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            ClassAvlDTO next2 = it2.next();
                                            if (next2.getErrorMessage() != null) {
                                                str = next2.getErrorMessage();
                                                z = true;
                                                continue;
                                                break;
                                            }
                                        }
                                        if (!z) {
                                            Iterator<WrapperAvailablityWithClassFareModel> it3 = AvailabilitywithClassFareViewHolder.this.wrapperAvailablityWithClassFareModels.iterator();
                                            while (it3.hasNext()) {
                                                WrapperAvailablityWithClassFareModel next3 = it3.next();
                                                if (classAvlDTO.getEnqClass().equals(next3.f5352a.getEnqClass())) {
                                                    next3.f5352a = next.getClassAvlDTO().get(0);
                                                    next3.f5353a = true;
                                                } else {
                                                    next3.f5353a = false;
                                                }
                                            }
                                            AvailabilitywithClassFareViewHolder.this.notifyDataSetChanged();
                                        }
                                    }
                                    boolean z2 = z;
                                    String str2 = str;
                                    if (z2) {
                                        Context context = AvailabilitywithClassFareViewHolder.this.mContext;
                                        C0535I5.m(context, false, str2, context.getResources().getString(R.string.error), AvailabilitywithClassFareViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                                        return;
                                    }
                                }
                                AvailabilitywithClassFareViewHolder.this.notifyDataSetChanged();
                                return;
                            }
                            show.dismiss();
                            C0535I5.m(AvailabilitywithClassFareViewHolder.this.mContext, false, trainBtwnStnsRespDto.getErrorMessage(), AvailabilitywithClassFareViewHolder.this.mContext.getResources().getString(R.string.error), AvailabilitywithClassFareViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        } catch (Exception e) {
                            String unused2 = AvailabilitywithClassFareViewHolder.TAG;
                            e.getMessage();
                            show.dismiss();
                            Context context2 = AvailabilitywithClassFareViewHolder.this.mContext;
                            C0535I5.m(context2, false, context2.getResources().getString(R.string.Unable_process_request), AvailabilitywithClassFareViewHolder.this.mContext.getResources().getString(R.string.error), AvailabilitywithClassFareViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                        }
                    } else {
                        show.dismiss();
                        Context context3 = AvailabilitywithClassFareViewHolder.this.mContext;
                        C0535I5.m(context3, false, context3.getResources().getString(R.string.Unable_process_request), AvailabilitywithClassFareViewHolder.this.mContext.getResources().getString(R.string.error), AvailabilitywithClassFareViewHolder.this.mContext.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    }
                }
            });
        } else if (C1450w1.f7005a == 2) {
            HomeActivity.A(2);
        } else {
            HomeActivity.A(1);
        }
    }

    public String format(String str) {
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat(" dd MMM, EEE ").format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }

    public int getItemCount() {
        return this.wrapperAvailablityWithClassFareModels.size();
    }

    public AvailabilityItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AvailabilityItemHolder(C1058d.s(viewGroup, R.layout.item_class_with_fare, viewGroup, false));
    }

    public void onSetListeners(AvailabilityItemHolder availabilityItemHolder, final WrapperAvailablityWithClassFareModel wrapperAvailablityWithClassFareModel, final TrainBtwnStnsModel trainBtwnStnsModel2) {
        availabilityItemHolder.main_ll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AvailabilityViewHolderListener availabilityViewHolderListener = AvailabilitywithClassFareViewHolder.this.listener;
                if (availabilityViewHolderListener != null) {
                    availabilityViewHolderListener.onItemClick(wrapperAvailablityWithClassFareModel, trainBtwnStnsModel2, true);
                }
                if (wrapperAvailablityWithClassFareModel.f5352a != null) {
                    Iterator<WrapperAvailablityWithClassFareModel> it = AvailabilitywithClassFareViewHolder.this.wrapperAvailablityWithClassFareModels.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        WrapperAvailablityWithClassFareModel next = it.next();
                        if (!wrapperAvailablityWithClassFareModel.f5352a.getEnqClass().equals(next.f5352a.getEnqClass()) || wrapperAvailablityWithClassFareModel.f5352a.getErrorMessage() != null) {
                            next.f5353a = false;
                        } else {
                            next.f5353a = true;
                            z = true;
                        }
                    }
                    AvailabilitywithClassFareViewHolder availabilitywithClassFareViewHolder = AvailabilitywithClassFareViewHolder.this;
                    ArrayList<WrapperAvailablityWithClassFareModel> arrayList = availabilitywithClassFareViewHolder.wrapperAvailablityWithClassFareModels;
                    TextView textView = AllTrainListFragment.f4408a;
                    if (z) {
                        availabilitywithClassFareViewHolder.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    public void onBindViewHolder(AvailabilityItemHolder availabilityItemHolder, int i) {
        C1060d2 d2Var;
        WrapperAvailablityWithClassFareModel wrapperAvailablityWithClassFareModel = this.wrapperAvailablityWithClassFareModels.get(i);
        availabilityItemHolder.avlDate.setVisibility(8);
        ClassAvlDTO classAvlDTO = wrapperAvailablityWithClassFareModel.f5352a;
        if (classAvlDTO == null || classAvlDTO.getAvlDayList() == null || wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().size() <= 0) {
            ClassAvlDTO classAvlDTO2 = wrapperAvailablityWithClassFareModel.f5352a;
            if (classAvlDTO2 == null || !(classAvlDTO2.getAvlDayList() == null || wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().size() == 0)) {
                availabilityItemHolder.refresh_ll.setVisibility(0);
                availabilityItemHolder.tv_class.setVisibility(0);
                availabilityItemHolder.tv_fare.setVisibility(8);
                availabilityItemHolder.avlDetails.setVisibility(8);
                if (xx.e(wrapperAvailablityWithClassFareModel.a.c) != null) {
                    availabilityItemHolder.tv_class.setText(wrapperAvailablityWithClassFareModel.a.c);
                }
            } else {
                String e = xx.e(wrapperAvailablityWithClassFareModel.f5352a.getEnqClass());
                if (e != null) {
                    availabilityItemHolder.tv_class.setText(e);
                } else {
                    availabilityItemHolder.tv_class.setText(wrapperAvailablityWithClassFareModel.f5352a.getEnqClass());
                }
                availabilityItemHolder.refresh_ll.setVisibility(0);
                availabilityItemHolder.tv_class.setVisibility(0);
                availabilityItemHolder.tv_fare.setVisibility(8);
                availabilityItemHolder.avlDetails.setVisibility(8);
            }
            d2Var = null;
        } else {
            availabilityItemHolder.refresh_ll.setVisibility(8);
            availabilityItemHolder.tv_class.setVisibility(0);
            availabilityItemHolder.tv_fare.setVisibility(0);
            availabilityItemHolder.avlDetails.setVisibility(0);
            ClassAvlDTO classAvlDTO3 = wrapperAvailablityWithClassFareModel.f5352a;
            if (classAvlDTO3 != null) {
                availabilityItemHolder.tv_class.setText(classAvlDTO3.getEnqClass());
            } else {
                availabilityItemHolder.tv_class.setText(wrapperAvailablityWithClassFareModel.a.c);
            }
            availabilityItemHolder.tv_fare.setText("₹ ".concat(String.valueOf(wrapperAvailablityWithClassFareModel.f5352a.getTotalFare())));
            String availablityStatus = wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getAvailablityStatus();
            int i2 = 13;
            if (availablityStatus.contains("AVAIL") && !availablityStatus.contains("WL") && availablityStatus.contains("-")) {
                availablityStatus = "AVL " + availablityStatus.split("-")[1];
            } else if (availablityStatus.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                availablityStatus = availablityStatus.split(RemoteSettings.FORWARD_SLASH_STRING)[1];
            } else if (availablityStatus.contains("DEPARTED")) {
                i2 = 12;
            } else if (availablityStatus.contains("Exist")) {
                i2 = 10;
            }
            availabilityItemHolder.avlDetails.setText(availablityStatus);
            availabilityItemHolder.avlDetails.setTextSize((float) i2);
            d2Var = wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0);
            if (wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getReasonType().equals("W")) {
                TextView textView = availabilityItemHolder.avlDetails;
                Context context = this.mContext;
                Object obj = d7.a;
                textView.setTextColor(d7.b.a(context, R.color.divider_ine));
            } else if (!wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getAvailablityStatus().contains("WL")) {
                TextView textView2 = availabilityItemHolder.avlDetails;
                Context context2 = this.mContext;
                Object obj2 = d7.a;
                textView2.setTextColor(d7.b.a(context2, R.color.green));
            } else if (wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getAvailablityStatus().contains("AVAILABLE") || wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getAvailablityStatus().contains("RAC")) {
                TextView textView3 = availabilityItemHolder.avlDetails;
                Context context3 = this.mContext;
                Object obj3 = d7.a;
                textView3.setTextColor(d7.b.a(context3, R.color.green));
            } else {
                TextView textView4 = availabilityItemHolder.avlDetails;
                Context context4 = this.mContext;
                Object obj4 = d7.a;
                textView4.setTextColor(d7.b.a(context4, R.color.red));
            }
            if (wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getProbability() != null) {
                if (wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getAvailablityStatus().contains("RAC")) {
                    availabilityItemHolder.cnfProbability.setVisibility(8);
                } else {
                    availabilityItemHolder.cnfProbability.setVisibility(0);
                    TextView textView5 = availabilityItemHolder.cnfProbability;
                    StringBuilder sb = new StringBuilder();
                    sb.append(("" + ((wrapperAvailablityWithClassFareModel.f5352a.getAvlDayList().get(0).getProbability().doubleValue() * 100.0d) + 0.5d)).split("\\.")[0]);
                    sb.append("%");
                    textView5.setText(sb.toString());
                    availabilityItemHolder.cnfProbability.setVisibility(0);
                }
            }
        }
        if (wrapperAvailablityWithClassFareModel.f5353a) {
            AllTrainListFragment.f4415b = d2Var;
            LinearLayout linearLayout = availabilityItemHolder.main_ll;
            Context context5 = this.mContext;
            Object obj5 = d7.a;
            linearLayout.setBackground(d7.a.b(context5, R.drawable.round_light_corner3));
        } else {
            LinearLayout linearLayout2 = availabilityItemHolder.main_ll;
            Context context6 = this.mContext;
            Object obj6 = d7.a;
            linearLayout2.setBackground(d7.a.b(context6, R.drawable.round_light_corner2));
        }
        onSetListeners(availabilityItemHolder, wrapperAvailablityWithClassFareModel, this.trainBtwnStnsModel);
    }
}
