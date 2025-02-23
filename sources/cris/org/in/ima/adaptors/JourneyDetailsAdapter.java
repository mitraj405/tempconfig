package cris.org.in.ima.adaptors;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.adaptors.AvailabilityViewHolder;
import cris.org.in.ima.db.StationDb;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.JourneyDetailDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class JourneyDetailsAdapter extends RecyclerView.Adapter<TrainListItemHolder> {
    private static final String TAG = C1354qp.R(JourneyDetailsAdapter.class);
    private String fromStn;
    List<JourneyDetailDTO> journeyDetailDTOS;
    Lap1TrainListAdapterListener listener;
    private TrainTypeAdaptor mAdapter;
    AvailabilityViewHolder.AvailabilityViewHolderListener mAvailabilityListener;
    private Context mContext;
    private ArrayList<C0503FA> mTrainList;
    private String selectedQuota;
    String spConcession = "";
    StationDb stationDb = C0793b1.a.f3911a;
    private String toStn;
    private String waitingTime;

    public interface Lap1TrainListAdapterListener {
        void onTrainLayoutClick(JourneyDetailDTO journeyDetailDTO);
    }

    public class TrainListItemHolder extends RecyclerView.ViewHolder {
        TextView arrDate;
        TextView arvTime;
        LinearLayout avl_other_date_ll;
        LinearLayout cnf_probability_ll;
        TextView depDate;
        TextView depTime;
        TextView fromCityCode;
        TextView fromCityName;
        LinearLayout mainLayout;
        LinearLayout other_dates_cnf_update_ll;
        RecyclerView rvAvailabilityList;
        RecyclerView rvClassFareAvl;
        RecyclerView rvTrainClass;
        TextView sourceDestStn;
        TextView toCityCode;
        TextView toCityName;
        CardView trainDetail;
        TextView trainName;
        TextView trainNo;
        TextView travelTime;
        TextView tv_avl_updates;
        TextView tv_close;
        TextView tv_cnf_probability;
        ImageView tv_favpnricon;
        TextView tv_layover;
        TextView tv_otherdate;
        TextView via;
        TextView waitDuration;

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
            this.mainLayout = (LinearLayout) view.findViewById(R.id.main_view);
            this.depDate = (TextView) view.findViewById(R.id.tv_dep_date);
            this.arrDate = (TextView) view.findViewById(R.id.tv_arr_date);
            this.via = (TextView) view.findViewById(R.id.tv_via);
            this.sourceDestStn = (TextView) view.findViewById(R.id.tv_source_dest_stn);
            this.waitDuration = (TextView) view.findViewById(R.id.tv_wait_duration);
            this.tv_layover = (TextView) view.findViewById(R.id.tv_layover);
        }
    }

    public JourneyDetailsAdapter(Context context, List<JourneyDetailDTO> list, Lap1TrainListAdapterListener lap1TrainListAdapterListener, String str, String str2, String str3) {
        this.journeyDetailDTOS = list;
        this.mContext = context;
        this.listener = lap1TrainListAdapterListener;
        this.mAvailabilityListener = this.mAvailabilityListener;
        this.selectedQuota = str;
        this.fromStn = str2;
        this.toStn = str3;
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

    public String format(String str) {
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat("EEE, dd MMM").format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }

    public String getArvDate(String str, String str2, String str3) {
        return new SimpleDateFormat("EEE, dd MMM").format(arrDateCommon(str, str2, str3).getTime());
    }

    public int getItemCount() {
        return this.journeyDetailDTOS.size();
    }

    public TrainListItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TrainListItemHolder(C1058d.s(viewGroup, R.layout.item_journey_detail_adapter, viewGroup, false));
    }

    public void onSetListeners(TrainListItemHolder trainListItemHolder, final JourneyDetailDTO journeyDetailDTO) {
        trainListItemHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Lap1TrainListAdapterListener lap1TrainListAdapterListener = JourneyDetailsAdapter.this.listener;
                if (lap1TrainListAdapterListener != null) {
                    lap1TrainListAdapterListener.onTrainLayoutClick(journeyDetailDTO);
                }
            }
        });
    }

    public void onBindViewHolder(TrainListItemHolder trainListItemHolder, int i) {
        JourneyDetailDTO journeyDetailDTO = this.journeyDetailDTOS.get(i);
        this.spConcession = (String) new Bundle().get("spConcession");
        TrainBtwnStnsDTO trainBtwnStnsDTO = journeyDetailDTO.getTrainBtwnStnsDTO().get(0);
        TrainBtwnStnsDTO trainBtwnStnsDTO2 = journeyDetailDTO.getTrainBtwnStnsDTO().get(journeyDetailDTO.getTrainBtwnStnsDTO().size() - 1);
        trainListItemHolder.fromCityName.setText(C0535I5.s0(this.stationDb.m(this.fromStn)));
        trainListItemHolder.fromCityCode.setVisibility(8);
        trainListItemHolder.toCityName.setText(C0535I5.s0(this.stationDb.m(this.toStn)));
        trainListItemHolder.toCityCode.setVisibility(8);
        trainListItemHolder.depTime.setText(trainBtwnStnsDTO.getDepartureTime());
        trainListItemHolder.arvTime.setText(trainBtwnStnsDTO2.getArrivalTime());
        trainListItemHolder.via.setText(trainBtwnStnsDTO.getToStnCode());
        Locale locale = Locale.ENGLISH;
        trainListItemHolder.arrDate.setText(getArvDate(new SimpleDateFormat("dd-MM-yyyy", locale).format(trainBtwnStnsDTO2.getJourneyDate()), trainBtwnStnsDTO2.getDepartureTime(), trainBtwnStnsDTO2.getDuration()));
        trainListItemHolder.depDate.setText(new SimpleDateFormat("EEE, dd MMM", locale).format(trainBtwnStnsDTO.getJourneyDate()));
        onSetListeners(trainListItemHolder, journeyDetailDTO);
        int parseInt = Integer.parseInt(String.valueOf(journeyDetailDTO.getTotalDuration()));
        TextView textView = trainListItemHolder.travelTime;
        textView.setText((parseInt / 60) + "h:" + (parseInt % 60) + "m");
    }

    public String format(String str, String str2) {
        new SimpleDateFormat();
        int indexOf = str.indexOf(45);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(45, i);
        return new SimpleDateFormat(str2).format(new GregorianCalendar(xx.z(indexOf2, 1, str), Integer.parseInt(str.substring(i, indexOf2)) - 1, Integer.parseInt(str.substring(0, indexOf))).getTime());
    }
}
