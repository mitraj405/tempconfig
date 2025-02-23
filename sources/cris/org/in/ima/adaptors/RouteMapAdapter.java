package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.db.StationDb;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainScheduleViewDTO;
import defpackage.d7;

public class RouteMapAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private TrainScheduleViewDTO trainRouteDto;
    View view;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView arrvTime;
        TextView dayCount;
        TextView deptTime;
        View itemView;
        RelativeLayout route_rl;
        TextView stnNameAndCode;
        TextView stnNamewithStar;
        TextView trainNoName;

        public ViewHolder(View view) {
            super(view);
            this.itemView = view;
            this.route_rl = (RelativeLayout) view.findViewById(R.id.route_rl);
            this.trainNoName = (TextView) view.findViewById(R.id.tv_train_name);
            this.stnNameAndCode = (TextView) view.findViewById(R.id.tv_stn_name_and_code);
            this.stnNamewithStar = (TextView) view.findViewById(R.id.tv_stn_star);
            this.arrvTime = (TextView) view.findViewById(R.id.tv_arr_time);
            this.deptTime = (TextView) view.findViewById(R.id.tv_dep_time);
            this.dayCount = (TextView) view.findViewById(R.id.tv_day_no);
        }
    }

    public RouteMapAdapter(Context context, TrainScheduleViewDTO trainScheduleViewDTO) {
        this.trainRouteDto = trainScheduleViewDTO;
        this.mContext = context;
    }

    public int getItemCount() {
        return this.trainRouteDto.getStationList().size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.view = C1058d.s(viewGroup, R.layout.item_train_details, (ViewGroup) null, false);
        return new ViewHolder(this.view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        StationDb stationDb = C0793b1.a.f3911a;
        if (i % 2 == 0) {
            viewHolder.route_rl.setBackgroundResource(R.color.white);
        } else {
            viewHolder.route_rl.setBackgroundResource(R.color.color_search_train);
        }
        if (this.trainRouteDto.getStationList().get(i).getBoardingDisabled().booleanValue()) {
            viewHolder.stnNamewithStar.setVisibility(0);
            TextView textView = viewHolder.stnNamewithStar;
            Context context = viewHolder.itemView.getContext();
            Object obj = d7.a;
            textView.setTextColor(d7.b.a(context, R.color.red));
            viewHolder.stnNameAndCode.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.red));
            viewHolder.arrvTime.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.red));
            viewHolder.deptTime.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.red));
            viewHolder.dayCount.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.red));
        } else if (this.trainRouteDto.getStationList().get(i).getArrivalTime().equalsIgnoreCase("--")) {
            viewHolder.arrvTime.setText("N.A");
            viewHolder.deptTime.setText(this.trainRouteDto.getStationList().get(i).getDepartureTime());
            TextView textView2 = viewHolder.stnNameAndCode;
            Context context2 = viewHolder.itemView.getContext();
            Object obj2 = d7.a;
            textView2.setTextColor(d7.b.a(context2, R.color.Shatabdi_color));
            viewHolder.arrvTime.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.deptTime.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.dayCount.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.stnNameAndCode.setTextSize(12.0f);
            viewHolder.arrvTime.setTextSize(12.0f);
            viewHolder.deptTime.setTextSize(12.0f);
            viewHolder.dayCount.setTextSize(12.0f);
        } else if (this.trainRouteDto.getStationList().get(i).getDepartureTime().equalsIgnoreCase("--")) {
            viewHolder.deptTime.setText("N.A");
            viewHolder.arrvTime.setText(this.trainRouteDto.getStationList().get(i).getArrivalTime());
            TextView textView3 = viewHolder.stnNameAndCode;
            Context context3 = viewHolder.itemView.getContext();
            Object obj3 = d7.a;
            textView3.setTextColor(d7.b.a(context3, R.color.Shatabdi_color));
            viewHolder.arrvTime.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.deptTime.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.dayCount.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.stnNameAndCode.setTextSize(12.0f);
            viewHolder.arrvTime.setTextSize(12.0f);
            viewHolder.deptTime.setTextSize(12.0f);
            viewHolder.dayCount.setTextSize(12.0f);
        } else {
            viewHolder.deptTime.setText(this.trainRouteDto.getStationList().get(i).getDepartureTime());
            viewHolder.arrvTime.setText(this.trainRouteDto.getStationList().get(i).getArrivalTime());
        }
        TextView textView4 = viewHolder.stnNameAndCode;
        textView4.setText(stationDb.m(this.trainRouteDto.getStationList().get(i).getStationCode()) + " - " + this.trainRouteDto.getStationList().get(i).getStationCode());
        TextView textView5 = viewHolder.dayCount;
        textView5.setText(this.mContext.getResources().getString(R.string.day) + this.trainRouteDto.getStationList().get(i).getDayCount());
    }
}
