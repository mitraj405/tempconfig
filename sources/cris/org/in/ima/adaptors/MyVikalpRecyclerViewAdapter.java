package cris.org.in.ima.adaptors;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.c;
import java.util.List;

public class MyVikalpRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<c> mValues;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView fromStn;
        public final TextView jDate;
        public final View mView;
        public final TextView toStn;
        public final TextView trainNo;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.trainNo = (TextView) view.findViewById(R.id.train_no);
            this.fromStn = (TextView) view.findViewById(R.id.from_stn);
            this.toStn = (TextView) view.findViewById(R.id.to_stn);
            this.jDate = (TextView) view.findViewById(R.id.journey_date);
        }

        public String toString() {
            return "ViewHolder{trainNo=" + this.trainNo + ", fromStn=" + this.fromStn + ", jDate=" + this.jDate + ", toStn=" + this.toStn + '}';
        }
    }

    public MyVikalpRecyclerViewAdapter(List<c> list) {
        this.mValues = list;
    }

    public int getItemCount() {
        return this.mValues.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.s(viewGroup, R.layout.fragment_vikalp, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        c cVar = this.mValues.get(i);
        viewHolder.trainNo.setText(cVar.getTrainNo());
        viewHolder.fromStn.setText(cVar.getFrom());
        viewHolder.toStn.setText(cVar.getTo());
        viewHolder.jDate.setText(cVar.getJourneyDate());
    }
}
