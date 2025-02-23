package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.RequestConfiguration;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import defpackage.d7;
import in.juspay.hypersdk.core.PaymentConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class SpecialTrainListViewHolder extends RecyclerView.Adapter<SpecialTrainListItemHolder> {
    private static final String TAG = C1354qp.R(SpecialTrainListViewHolder.class);
    private Context mContext;
    private ArrayList<C0503FA> mTrainList;
    StationDb stationDb = C0793b1.a.f3911a;
    List<TrainBtwnStnsModel> trainBtwnStnsModels;

    public class SpecialTrainListItemHolder extends RecyclerView.ViewHolder {
        TextView arvTime;
        TextView depTime;
        TextView friday;
        TextView fromCityName;
        TextView monday;
        TextView saturday;
        TextView sunday;
        TextView thursday;
        TextView toCityName;
        CardView trainDetail;
        TextView trainName;
        TextView trainNo;
        ImageView traintyColor;
        TextView travelTime;
        TextView tuesday;
        TextView wednesday;

        public SpecialTrainListItemHolder(View view) {
            super(view);
            this.trainDetail = (CardView) view.findViewById(R.id.rl_train_detail_parent_layout);
            this.trainNo = (TextView) view.findViewById(R.id.tv_train_no);
            this.trainName = (TextView) view.findViewById(R.id.tv_train_name);
            this.fromCityName = (TextView) view.findViewById(R.id.tv_from_city_name);
            this.toCityName = (TextView) view.findViewById(R.id.tv_to_city_name);
            this.depTime = (TextView) view.findViewById(R.id.dep_time);
            this.arvTime = (TextView) view.findViewById(R.id.arv_time);
            this.travelTime = (TextView) view.findViewById(R.id.travel_time);
            this.sunday = (TextView) view.findViewById(R.id.tv_sunday);
            this.monday = (TextView) view.findViewById(R.id.tv_monday);
            this.tuesday = (TextView) view.findViewById(R.id.tv_tuesday);
            this.wednesday = (TextView) view.findViewById(R.id.tv_wednesday);
            this.thursday = (TextView) view.findViewById(R.id.tv_thursday);
            this.friday = (TextView) view.findViewById(R.id.tv_friday);
            this.saturday = (TextView) view.findViewById(R.id.tv_saturday);
            this.traintyColor = (ImageView) view.findViewById(R.id.tv_color);
        }
    }

    public interface TrainListHolderListener {
        void onGetAvailabilityDetails();

        void onTrainLayoutClick(TrainBtwnStnsModel trainBtwnStnsModel);
    }

    public SpecialTrainListViewHolder(Context context, List<TrainBtwnStnsModel> list) {
        this.trainBtwnStnsModels = list;
        this.mContext = context;
    }

    public static String format(String str) {
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat("EEE dd MMM yy").format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
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

    public int getItemCount() {
        return this.trainBtwnStnsModels.size();
    }

    public SpecialTrainListItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SpecialTrainListItemHolder(C1058d.s(viewGroup, R.layout.item_spesialtrain_list, viewGroup, false));
    }

    public void onRunningDayStatus(SpecialTrainListItemHolder specialTrainListItemHolder, TrainBtwnStnsDTO trainBtwnStnsDTO) {
        if (trainBtwnStnsDTO.getRunningSun().equals("Y")) {
            specialTrainListItemHolder.sunday.setEnabled(true);
            specialTrainListItemHolder.sunday.setText("S");
            TextView textView = specialTrainListItemHolder.sunday;
            Context context = this.mContext;
            Object obj = d7.a;
            textView.setTextColor(d7.b.a(context, R.color.black_85_opa));
        } else {
            specialTrainListItemHolder.sunday.setEnabled(false);
            specialTrainListItemHolder.sunday.setText("S");
            TextView textView2 = specialTrainListItemHolder.sunday;
            Context context2 = this.mContext;
            Object obj2 = d7.a;
            textView2.setTextColor(d7.b.a(context2, R.color.shadow_line2));
        }
        if (trainBtwnStnsDTO.getRunningMon().equals("Y")) {
            specialTrainListItemHolder.monday.setText("M");
            specialTrainListItemHolder.monday.setEnabled(true);
            specialTrainListItemHolder.monday.setTextColor(d7.b.a(this.mContext, R.color.black_85_opa));
        } else {
            specialTrainListItemHolder.monday.setText("M");
            specialTrainListItemHolder.monday.setEnabled(false);
            specialTrainListItemHolder.monday.setTextColor(d7.b.a(this.mContext, R.color.shadow_line2));
        }
        if (trainBtwnStnsDTO.getRunningTue().equals("Y")) {
            specialTrainListItemHolder.tuesday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            specialTrainListItemHolder.tuesday.setEnabled(true);
            specialTrainListItemHolder.tuesday.setTextColor(d7.b.a(this.mContext, R.color.black_85_opa));
        } else {
            specialTrainListItemHolder.tuesday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            specialTrainListItemHolder.tuesday.setEnabled(false);
            specialTrainListItemHolder.tuesday.setTextColor(d7.b.a(this.mContext, R.color.shadow_line2));
        }
        if (trainBtwnStnsDTO.getRunningWed().equals("Y")) {
            specialTrainListItemHolder.wednesday.setText("W");
            specialTrainListItemHolder.wednesday.setEnabled(true);
            specialTrainListItemHolder.wednesday.setTextColor(d7.b.a(this.mContext, R.color.black_85_opa));
        } else {
            specialTrainListItemHolder.wednesday.setText("W");
            specialTrainListItemHolder.wednesday.setEnabled(false);
            specialTrainListItemHolder.wednesday.setTextColor(d7.b.a(this.mContext, R.color.shadow_line2));
        }
        if (trainBtwnStnsDTO.getRunningThu().equals("Y")) {
            specialTrainListItemHolder.thursday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            specialTrainListItemHolder.thursday.setEnabled(true);
            specialTrainListItemHolder.thursday.setTextColor(d7.b.a(this.mContext, R.color.black_85_opa));
        } else {
            specialTrainListItemHolder.thursday.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_T);
            specialTrainListItemHolder.thursday.setEnabled(false);
            specialTrainListItemHolder.thursday.setTextColor(d7.b.a(this.mContext, R.color.shadow_line2));
        }
        if (trainBtwnStnsDTO.getRunningFri().equals("Y")) {
            specialTrainListItemHolder.friday.setText("F");
            specialTrainListItemHolder.friday.setEnabled(true);
            specialTrainListItemHolder.friday.setTextColor(d7.b.a(this.mContext, R.color.black_85_opa));
        } else {
            specialTrainListItemHolder.friday.setText("F");
            specialTrainListItemHolder.friday.setEnabled(false);
            specialTrainListItemHolder.friday.setTextColor(d7.b.a(this.mContext, R.color.shadow_line2));
        }
        if (trainBtwnStnsDTO.getRunningSat().equals("Y")) {
            specialTrainListItemHolder.saturday.setText("S");
            specialTrainListItemHolder.saturday.setEnabled(true);
            specialTrainListItemHolder.saturday.setTextColor(d7.b.a(this.mContext, R.color.black_85_opa));
            return;
        }
        specialTrainListItemHolder.saturday.setText("S");
        specialTrainListItemHolder.saturday.setEnabled(false);
        specialTrainListItemHolder.saturday.setTextColor(d7.b.a(this.mContext, R.color.shadow_line2));
    }

    public void onBindViewHolder(SpecialTrainListItemHolder specialTrainListItemHolder, int i) {
        TrainBtwnStnsModel trainBtwnStnsModel = this.trainBtwnStnsModels.get(i);
        Objects.toString(trainBtwnStnsModel);
        TextView textView = specialTrainListItemHolder.trainNo;
        textView.setText("(" + trainBtwnStnsModel.f5342a.getTrainNumber() + ")");
        TextView textView2 = specialTrainListItemHolder.trainName;
        TrainBtwnStnsDTO trainBtwnStnsDTO = trainBtwnStnsModel.f5342a;
        textView2.setText(trainBtwnStnsDTO.getTrainName());
        specialTrainListItemHolder.fromCityName.setText(C0535I5.s0(this.stationDb.m(trainBtwnStnsDTO.getFromStnCode())));
        specialTrainListItemHolder.toCityName.setText(C0535I5.s0(this.stationDb.m(trainBtwnStnsDTO.getToStnCode())));
        specialTrainListItemHolder.depTime.setText(trainBtwnStnsDTO.getDepartureTime());
        specialTrainListItemHolder.arvTime.setText(trainBtwnStnsDTO.getArrivalTime());
        initList();
        if (trainBtwnStnsDTO.getTrainType() != null) {
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("O")) {
                specialTrainListItemHolder.traintyColor.setVisibility(8);
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("R")) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView = specialTrainListItemHolder.traintyColor;
                Context context = this.mContext;
                Object obj = d7.a;
                imageView.setColorFilter(d7.b.a(context, R.color.majenta_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView2 = specialTrainListItemHolder.traintyColor;
                Context context2 = this.mContext;
                Object obj2 = d7.a;
                imageView2.setColorFilter(d7.b.a(context2, R.color.radium_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("SP")) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView3 = specialTrainListItemHolder.traintyColor;
                Context context3 = this.mContext;
                Object obj3 = d7.a;
                imageView3.setColorFilter(d7.b.a(context3, R.color.maroon_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("ST")) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView4 = specialTrainListItemHolder.traintyColor;
                Context context4 = this.mContext;
                Object obj4 = d7.a;
                imageView4.setColorFilter(d7.b.a(context4, R.color.light_green_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("D")) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView5 = specialTrainListItemHolder.traintyColor;
                Context context5 = this.mContext;
                Object obj5 = d7.a;
                imageView5.setColorFilter(d7.b.a(context5, R.color.yellow_color1));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("SV")) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView6 = specialTrainListItemHolder.traintyColor;
                Context context6 = this.mContext;
                Object obj6 = d7.a;
                imageView6.setColorFilter(d7.b.a(context6, R.color.green_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("S")) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView7 = specialTrainListItemHolder.traintyColor;
                Context context7 = this.mContext;
                Object obj7 = d7.a;
                imageView7.setColorFilter(d7.b.a(context7, R.color.Shatabdi_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals(PaymentConstants.Category.JS)) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView8 = specialTrainListItemHolder.traintyColor;
                Context context8 = this.mContext;
                Object obj8 = d7.a;
                imageView8.setColorFilter(d7.b.a(context8, R.color.Janshatabdi_color));
            }
            if (trainBtwnStnsDTO.getTrainType().get(0).equals("Y")) {
                specialTrainListItemHolder.traintyColor.setVisibility(0);
                ImageView imageView9 = specialTrainListItemHolder.traintyColor;
                Context context9 = this.mContext;
                Object obj9 = d7.a;
                imageView9.setColorFilter(d7.b.a(context9, R.color.Yuva_train_color));
            }
        }
        onRunningDayStatus(specialTrainListItemHolder, trainBtwnStnsDTO);
        trainBtwnStnsDTO.getTrainType();
        trainBtwnStnsDTO.getDepartureDate();
    }

    public String format(String str, String str2) {
        new SimpleDateFormat();
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat(str2).format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }
}
