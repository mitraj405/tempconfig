package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.util.ArrayList;
import java.util.Iterator;

public class ReviewFarebreakupAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(ReviewFarebreakupAdapter.class);
    private ArrayList<AvlFareResponseDTO> avlFareResponseDTOArrayList;
    private double granttotal = 0.0d;
    private Context mContext;
    private Double serviceChargesAmount;
    private ArrayList<TrainBtwnStnsDTO> trainBtwnStnsModelArrayList;
    private Double travalInsCharges;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fastest_charge;
        RelativeLayout grand_total_rl;
        TextView heading;
        TextView insurance_charge;
        TextView total_amount;
        TextView tv_ConvenienceFee;
        TextView tv_grand_total;

        public ViewHolder(View view) {
            super(view);
            this.heading = (TextView) view.findViewById(R.id.heading);
            this.fastest_charge = (TextView) view.findViewById(R.id.fastest_charge);
            this.insurance_charge = (TextView) view.findViewById(R.id.insurance_charge);
            this.tv_ConvenienceFee = (TextView) view.findViewById(R.id.tv_ConvenienceFee);
            this.total_amount = (TextView) view.findViewById(R.id.total_amount);
            this.tv_grand_total = (TextView) view.findViewById(R.id.tv_grand_total);
            this.grand_total_rl = (RelativeLayout) view.findViewById(R.id.grand_total_rl);
        }
    }

    public ReviewFarebreakupAdapter(Context context, ArrayList<AvlFareResponseDTO> arrayList, ArrayList<TrainBtwnStnsDTO> arrayList2) {
        this.mContext = context;
        this.avlFareResponseDTOArrayList = arrayList;
        this.trainBtwnStnsModelArrayList = arrayList2;
    }

    public int getItemCount() {
        return this.avlFareResponseDTOArrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.s(viewGroup, R.layout.item_farebreakup_review, (ViewGroup) null, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        AvlFareResponseDTO avlFareResponseDTO = this.avlFareResponseDTOArrayList.get(i);
        if (avlFareResponseDTO.getTotalCollectibleAmount() != null) {
            TrainBtwnStnsDTO trainBtwnStnsDTO = this.trainBtwnStnsModelArrayList.get(i);
            TextView textView = viewHolder.heading;
            textView.setText(this.mContext.getResources().getString(R.string.Fare_breakup_LAP) + (i + 1) + " " + trainBtwnStnsDTO.getTrainName() + "(" + trainBtwnStnsDTO.getTrainNumber() + ")");
            viewHolder.fastest_charge.setText(String.format(this.mContext.getResources().getString(R.string.format_rupees), new Object[]{Double.valueOf((double) avlFareResponseDTO.getTotalFare().intValue())}));
            this.travalInsCharges = Double.valueOf(avlFareResponseDTO.getTravelInsuranceServiceTax().doubleValue() + avlFareResponseDTO.getTravelInsuranceCharge().doubleValue());
            viewHolder.insurance_charge.setText(String.format(this.mContext.getResources().getString(R.string.format_rupees), new Object[]{this.travalInsCharges}));
            this.serviceChargesAmount = Double.valueOf(avlFareResponseDTO.getWpServiceTax().doubleValue() + avlFareResponseDTO.getWpServiceCharge().doubleValue());
            viewHolder.tv_ConvenienceFee.setText(String.format(this.mContext.getResources().getString(R.string.format_rupees), new Object[]{this.serviceChargesAmount}));
            viewHolder.total_amount.setText(String.format(this.mContext.getResources().getString(R.string.format_rupees), new Object[]{avlFareResponseDTO.getTotalCollectibleAmount()}));
            if (i == this.avlFareResponseDTOArrayList.size() - 1) {
                Iterator<AvlFareResponseDTO> it = this.avlFareResponseDTOArrayList.iterator();
                while (it.hasNext()) {
                    this.granttotal = it.next().getTotalCollectibleAmount().doubleValue() + this.granttotal;
                }
                viewHolder.grand_total_rl.setVisibility(0);
                TextView textView2 = viewHolder.tv_grand_total;
                textView2.setText("₹ " + String.valueOf(this.granttotal));
                return;
            }
            viewHolder.grand_total_rl.setVisibility(8);
        }
    }
}
