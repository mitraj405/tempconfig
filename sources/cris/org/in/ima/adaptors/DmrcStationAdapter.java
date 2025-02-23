package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.DmrcStationActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.DmrcstatsionDto;
import defpackage.d7;
import java.util.ArrayList;

public class DmrcStationAdapter extends RecyclerView.Adapter<stationListViewHolder> {
    Context context;
    ArrayList<DmrcstatsionDto> dmrcstatsionDtoArrayList;
    DmrcStationListAdapterStnSelectListener listener;
    private int metroLineTxt;

    public interface DmrcStationListAdapterStnSelectListener {
        void onStationClick(DmrcstatsionDto dmrcstatsionDto);
    }

    public class stationListViewHolder extends RecyclerView.ViewHolder {
        TextView dmrcLineColor;
        TextView dmrcfromdistance;
        TextView dmrcstationname;
        LinearLayout stationListRelativeLayout;

        public stationListViewHolder(View view) {
            super(view);
            this.dmrcstationname = (TextView) view.findViewById(R.id.tv_dmrc_station_name);
            this.dmrcfromdistance = (TextView) view.findViewById(R.id.tv_dmrc_from_distance);
            this.dmrcLineColor = (TextView) view.findViewById(R.id.dmrc_line_color);
            this.stationListRelativeLayout = (LinearLayout) view.findViewById(R.id.stnListRelLayout);
        }
    }

    public DmrcStationAdapter(DmrcStationActivity dmrcStationActivity, ArrayList<DmrcstatsionDto> arrayList, DmrcStationListAdapterStnSelectListener dmrcStationListAdapterStnSelectListener) {
        this.context = dmrcStationActivity;
        this.dmrcstatsionDtoArrayList = arrayList;
        this.listener = dmrcStationListAdapterStnSelectListener;
    }

    public void OnClickListener(LinearLayout linearLayout, final DmrcStationListAdapterStnSelectListener dmrcStationListAdapterStnSelectListener, final DmrcstatsionDto dmrcstatsionDto) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dmrcStationListAdapterStnSelectListener.onStationClick(dmrcstatsionDto);
            }
        });
    }

    public int getItemCount() {
        return this.dmrcstatsionDtoArrayList.size();
    }

    public stationListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new stationListViewHolder(C1058d.s(viewGroup, R.layout.dmrc_item_station, viewGroup, false));
    }

    public void onBindViewHolder(stationListViewHolder stationlistviewholder, int i) {
        stationlistviewholder.dmrcstationname.setText(this.dmrcstatsionDtoArrayList.get(i).getDmrcstationname());
        this.metroLineTxt = this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode();
        if (((double) this.dmrcstatsionDtoArrayList.get(i).getDistance()) != 0.0d) {
            TextView textView = stationlistviewholder.dmrcfromdistance;
            textView.setText(String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDistance()) + " KM");
        }
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            this.metroLineTxt = this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode();
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 1) {
                xx.P(this.context, R.string.red_line, stationlistviewholder.dmrcLineColor);
                TextView textView2 = stationlistviewholder.dmrcLineColor;
                Context context2 = this.context;
                Object obj = d7.a;
                textView2.setTextColor(d7.b.a(context2, R.color.red));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 2) {
                xx.P(this.context, R.string.yellow_line, stationlistviewholder.dmrcLineColor);
                TextView textView3 = stationlistviewholder.dmrcLineColor;
                Context context3 = this.context;
                Object obj2 = d7.a;
                textView3.setTextColor(d7.b.a(context3, R.color.yellow_color1));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 3) {
                xx.P(this.context, R.string.blue_line, stationlistviewholder.dmrcLineColor);
                TextView textView4 = stationlistviewholder.dmrcLineColor;
                Context context4 = this.context;
                Object obj3 = d7.a;
                textView4.setTextColor(d7.b.a(context4, R.color.app_theme_blue));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 4) {
                xx.P(this.context, R.string.blue_line, stationlistviewholder.dmrcLineColor);
                TextView textView5 = stationlistviewholder.dmrcLineColor;
                Context context5 = this.context;
                Object obj4 = d7.a;
                textView5.setTextColor(d7.b.a(context5, R.color.app_theme_blue));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 5) {
                xx.P(this.context, R.string.green_line, stationlistviewholder.dmrcLineColor);
                TextView textView6 = stationlistviewholder.dmrcLineColor;
                Context context6 = this.context;
                Object obj5 = d7.a;
                textView6.setTextColor(d7.b.a(context6, R.color.green));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 6) {
                xx.P(this.context, R.string.violet_line, stationlistviewholder.dmrcLineColor);
                TextView textView7 = stationlistviewholder.dmrcLineColor;
                Context context7 = this.context;
                Object obj6 = d7.a;
                textView7.setTextColor(d7.b.a(context7, R.color.violet));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 7) {
                xx.P(this.context, R.string.pink_line, stationlistviewholder.dmrcLineColor);
                TextView textView8 = stationlistviewholder.dmrcLineColor;
                Context context8 = this.context;
                Object obj7 = d7.a;
                textView8.setTextColor(d7.b.a(context8, R.color.light_pink));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 8) {
                xx.P(this.context, R.string.magenta_line, stationlistviewholder.dmrcLineColor);
                TextView textView9 = stationlistviewholder.dmrcLineColor;
                Context context9 = this.context;
                Object obj8 = d7.a;
                textView9.setTextColor(d7.b.a(context9, R.color.magenta));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 9) {
                xx.P(this.context, R.string.grey_line, stationlistviewholder.dmrcLineColor);
                TextView textView10 = stationlistviewholder.dmrcLineColor;
                Context context10 = this.context;
                Object obj9 = d7.a;
                textView10.setTextColor(d7.b.a(context10, R.color.lightdark));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 29) {
                xx.P(this.context, R.string.rmgl_line, stationlistviewholder.dmrcLineColor);
                TextView textView11 = stationlistviewholder.dmrcLineColor;
                Context context11 = this.context;
                Object obj10 = d7.a;
                textView11.setTextColor(d7.b.a(context11, R.color.dark));
            }
        } else {
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 1) {
                xx.P(this.context, R.string.red_line, stationlistviewholder.dmrcLineColor);
                TextView textView12 = stationlistviewholder.dmrcLineColor;
                Context context12 = this.context;
                Object obj11 = d7.a;
                textView12.setTextColor(d7.b.a(context12, R.color.red));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 2) {
                xx.P(this.context, R.string.yellow_line, stationlistviewholder.dmrcLineColor);
                TextView textView13 = stationlistviewholder.dmrcLineColor;
                Context context13 = this.context;
                Object obj12 = d7.a;
                textView13.setTextColor(d7.b.a(context13, R.color.yellow_color1));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 3) {
                xx.P(this.context, R.string.blue_line, stationlistviewholder.dmrcLineColor);
                TextView textView14 = stationlistviewholder.dmrcLineColor;
                Context context14 = this.context;
                Object obj13 = d7.a;
                textView14.setTextColor(d7.b.a(context14, R.color.app_theme_blue));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 4) {
                xx.P(this.context, R.string.blue_line, stationlistviewholder.dmrcLineColor);
                TextView textView15 = stationlistviewholder.dmrcLineColor;
                Context context15 = this.context;
                Object obj14 = d7.a;
                textView15.setTextColor(d7.b.a(context15, R.color.app_theme_blue));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 5) {
                xx.P(this.context, R.string.green_line, stationlistviewholder.dmrcLineColor);
                TextView textView16 = stationlistviewholder.dmrcLineColor;
                Context context16 = this.context;
                Object obj15 = d7.a;
                textView16.setTextColor(d7.b.a(context16, R.color.green));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 6) {
                xx.P(this.context, R.string.violet_line, stationlistviewholder.dmrcLineColor);
                TextView textView17 = stationlistviewholder.dmrcLineColor;
                Context context17 = this.context;
                Object obj16 = d7.a;
                textView17.setTextColor(d7.b.a(context17, R.color.violet));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 7) {
                xx.P(this.context, R.string.pink_line, stationlistviewholder.dmrcLineColor);
                TextView textView18 = stationlistviewholder.dmrcLineColor;
                Context context18 = this.context;
                Object obj17 = d7.a;
                textView18.setTextColor(d7.b.a(context18, R.color.light_pink));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 8) {
                xx.P(this.context, R.string.magenta_line, stationlistviewholder.dmrcLineColor);
                TextView textView19 = stationlistviewholder.dmrcLineColor;
                Context context19 = this.context;
                Object obj18 = d7.a;
                textView19.setTextColor(d7.b.a(context19, R.color.magenta));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 9) {
                xx.P(this.context, R.string.grey_line, stationlistviewholder.dmrcLineColor);
                TextView textView20 = stationlistviewholder.dmrcLineColor;
                Context context20 = this.context;
                Object obj19 = d7.a;
                textView20.setTextColor(d7.b.a(context20, R.color.lightdark));
            }
            if (String.valueOf(this.dmrcstatsionDtoArrayList.get(i).getDmrclinecolorcode()) != null && !C1058d.K(this.dmrcstatsionDtoArrayList.get(i)) && this.metroLineTxt == 29) {
                xx.P(this.context, R.string.rmgl_line, stationlistviewholder.dmrcLineColor);
                TextView textView21 = stationlistviewholder.dmrcLineColor;
                Context context21 = this.context;
                Object obj20 = d7.a;
                textView21.setTextColor(d7.b.a(context21, R.color.dark));
            }
        }
        OnClickListener(stationlistviewholder.stationListRelativeLayout, this.listener, this.dmrcstatsionDtoArrayList.get(i));
    }
}
