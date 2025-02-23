package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainScheduleViewDTO;
import defpackage.d7;

public class TrainScheduleAdapterNew extends RecyclerView.Adapter<ViewHolder> {
    private TrainScheduleViewDTO trainRouteDto;
    View view;

    public class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        RelativeLayout route_rl;
        TextView tv_arr_time;
        TextView tv_day_no;
        TextView tv_dep_time;
        TextView tv_dist;
        TextView tv_stn_name_and_code;

        public ViewHolder(View view) {
            super(view);
            this.itemView = view;
            this.route_rl = (RelativeLayout) view.findViewById(R.id.route_rl);
            this.tv_stn_name_and_code = (TextView) view.findViewById(R.id.tv_stn_name_and_code);
            this.tv_arr_time = (TextView) view.findViewById(R.id.tv_arr_time);
            this.tv_dep_time = (TextView) view.findViewById(R.id.tv_dep_time);
            this.tv_day_no = (TextView) view.findViewById(R.id.tv_day_no);
            this.tv_dist = (TextView) view.findViewById(R.id.tv_dist);
        }
    }

    public TrainScheduleAdapterNew(TrainScheduleViewDTO trainScheduleViewDTO) {
        this.trainRouteDto = trainScheduleViewDTO;
    }

    public int getItemCount() {
        return this.trainRouteDto.getStationList().size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.view = C1058d.s(viewGroup, R.layout.item_train_schedule_new, (ViewGroup) null, false);
        return new ViewHolder(this.view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (i % 2 == 0) {
            viewHolder.route_rl.setBackgroundResource(R.color.white);
        } else {
            viewHolder.route_rl.setBackgroundResource(R.color.color_search_train);
        }
        if (this.trainRouteDto.getStationList().get(i).getArrivalTime().equalsIgnoreCase("--") || this.trainRouteDto.getStationList().get(i).getDepartureTime().equalsIgnoreCase("--")) {
            TextView textView = viewHolder.tv_stn_name_and_code;
            Context context = viewHolder.itemView.getContext();
            Object obj = d7.a;
            textView.setTextColor(d7.b.a(context, R.color.Shatabdi_color));
            viewHolder.tv_arr_time.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.tv_dep_time.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.tv_day_no.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
            viewHolder.tv_dist.setTextColor(d7.b.a(viewHolder.itemView.getContext(), R.color.Shatabdi_color));
        }
        TextView textView2 = viewHolder.tv_stn_name_and_code;
        textView2.setText(this.trainRouteDto.getStationList().get(i).getStationName() + " - " + this.trainRouteDto.getStationList().get(i).getStationCode());
        viewHolder.tv_arr_time.setText(this.trainRouteDto.getStationList().get(i).getArrivalTime());
        viewHolder.tv_dep_time.setText(this.trainRouteDto.getStationList().get(i).getDepartureTime());
        viewHolder.tv_day_no.setText(this.trainRouteDto.getStationList().get(i).getDayCount());
        viewHolder.tv_dist.setText(this.trainRouteDto.getStationList().get(i).getDistance());
    }
}
