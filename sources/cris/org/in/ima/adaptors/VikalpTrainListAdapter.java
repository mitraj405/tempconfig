package cris.org.in.ima.adaptors;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import cris.org.in.ima.model.VikalpTrainListModel;
import uk.co.ribot.easyadapter.PositionInfo;

@C0708Uh(2131558620)
public class VikalpTrainListAdapter extends C1424ug<VikalpTrainListModel> {
    private static final String TAG = C1354qp.R(VikalpTrainListAdapter.class);
    @C1456wC(2131362386)
    TextView depTimeAndarvTime;
    @C1456wC(2131364420)
    TextView fromCityName;
    @C1456wC(2131362907)
    CheckBox selectTrain;
    @C1456wC(2131364670)
    TextView toCityName;
    @C1456wC(2131363768)
    LinearLayout trainDetail;
    @C1456wC(2131364686)
    TextView trainName;
    @C1456wC(2131364688)
    TextView trainNo;
    @C1456wC(2131364249)
    TextView travelDateAndTime;

    public interface VikalpTrainListListener {
        void onSelectMaxTrain();

        void onSelectVikalpTrain(Integer num, boolean z);
    }

    public VikalpTrainListAdapter(View view) {
        super(view);
    }

    /* access modifiers changed from: private */
    public void selectVikalpTrain() {
        VikalpTrainListListener vikalpTrainListListener = (VikalpTrainListListener) getListener(VikalpTrainListListener.class);
        if (!((VikalpTrainListModel) getItem()).f5350a) {
            C0535I5.a--;
            if (vikalpTrainListListener != null) {
                vikalpTrainListListener.onSelectVikalpTrain(((VikalpTrainListModel) getItem()).a.getsNo(), ((VikalpTrainListModel) getItem()).f5350a);
            }
        } else if (C0535I5.a < C0535I5.b) {
            C0535I5.a++;
            if (vikalpTrainListListener != null) {
                vikalpTrainListListener.onSelectVikalpTrain(((VikalpTrainListModel) getItem()).a.getsNo(), ((VikalpTrainListModel) getItem()).f5350a);
            }
        } else {
            ((VikalpTrainListModel) getItem()).f5350a = false;
            this.selectTrain.setChecked(false);
            if (vikalpTrainListListener != null) {
                vikalpTrainListListener.onSelectMaxTrain();
            }
        }
    }

    public void onSetListeners() {
        this.trainDetail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (VikalpTrainListAdapter.this.selectTrain.isChecked()) {
                    VikalpTrainListAdapter.this.selectTrain.setChecked(false);
                } else {
                    VikalpTrainListAdapter.this.selectTrain.setChecked(true);
                }
                ((VikalpTrainListModel) VikalpTrainListAdapter.this.getItem()).f5350a = VikalpTrainListAdapter.this.selectTrain.isChecked();
                VikalpTrainListAdapter.this.selectVikalpTrain();
            }
        });
        this.selectTrain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((VikalpTrainListModel) VikalpTrainListAdapter.this.getItem()).f5350a = VikalpTrainListAdapter.this.selectTrain.isChecked();
                VikalpTrainListAdapter.this.selectVikalpTrain();
            }
        });
    }

    public void onSetValues(VikalpTrainListModel vikalpTrainListModel, PositionInfo positionInfo) {
        if (vikalpTrainListModel.f5350a) {
            this.selectTrain.setChecked(true);
        } else {
            this.selectTrain.setChecked(false);
        }
        TextView textView = this.trainNo;
        textView.setText("(" + vikalpTrainListModel.a.getTrainNumber() + ")");
        this.trainName.setText(vikalpTrainListModel.a.getTrainName());
        this.fromCityName.setText(vikalpTrainListModel.a.getFromStnCode());
        this.toCityName.setText(vikalpTrainListModel.a.getToStnCode());
        TextView textView2 = this.depTimeAndarvTime;
        textView2.setText(vikalpTrainListModel.a.getDepartureTime() + "-" + vikalpTrainListModel.a.getArrivalTime());
        TextView textView3 = this.travelDateAndTime;
        textView3.setText("Journey date: " + vikalpTrainListModel.a.getDepartureDate() + "   |   Travel Time: " + vikalpTrainListModel.a.getDuration());
    }
}
