package cris.org.in.ima.adaptors;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.ima.model.WrapperBoardingStationModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class BoardingStationChangeAdapter extends RecyclerView.Adapter<BoardingStationChangeItemHolder> {
    /* access modifiers changed from: private */
    public StationListSelectListener listener;
    private Context mContext;
    private ArrayList<WrapperBoardingStationModel> wrapperBoardingStationModelArrayList;

    public class BoardingStationChangeItemHolder extends RecyclerView.ViewHolder {
        WrapperBoardingStationModel item;
        @BindView(2131363764)
        RelativeLayout stationListRelativeLayout;
        @BindView(2131364620)
        TextView stnNamedate;
        @BindView(2131364159)
        LinearLayout tkt_layout_id;

        public BoardingStationChangeItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364159})
        public void tktLayoutClick(View view) {
            if (BoardingStationChangeAdapter.this.listener != null) {
                BoardingStationChangeAdapter.this.listener.onStnClick(this.item);
            }
        }
    }

    public class BoardingStationChangeItemHolder_ViewBinding implements Unbinder {
        private BoardingStationChangeItemHolder target;
        private View view7f0a093f;

        public BoardingStationChangeItemHolder_ViewBinding(final BoardingStationChangeItemHolder boardingStationChangeItemHolder, View view) {
            this.target = boardingStationChangeItemHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.tkt_layout_id, "field 'tkt_layout_id' and method 'tktLayoutClick'");
            boardingStationChangeItemHolder.tkt_layout_id = (LinearLayout) Utils.castView(findRequiredView, R.id.tkt_layout_id, "field 'tkt_layout_id'", LinearLayout.class);
            this.view7f0a093f = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    boardingStationChangeItemHolder.tktLayoutClick(view);
                }
            });
            boardingStationChangeItemHolder.stnNamedate = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_stnname_time, "field 'stnNamedate'", TextView.class);
            boardingStationChangeItemHolder.stationListRelativeLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_selected_stn, "field 'stationListRelativeLayout'", RelativeLayout.class);
        }

        public void unbind() {
            BoardingStationChangeItemHolder boardingStationChangeItemHolder = this.target;
            if (boardingStationChangeItemHolder != null) {
                this.target = null;
                boardingStationChangeItemHolder.tkt_layout_id = null;
                boardingStationChangeItemHolder.stnNamedate = null;
                boardingStationChangeItemHolder.stationListRelativeLayout = null;
                this.view7f0a093f.setOnClickListener((View.OnClickListener) null);
                this.view7f0a093f = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface StationListSelectListener {
        void onStnClick(WrapperBoardingStationModel wrapperBoardingStationModel);
    }

    public BoardingStationChangeAdapter(Context context, ArrayList<WrapperBoardingStationModel> arrayList, StationListSelectListener stationListSelectListener) {
        this.mContext = context;
        this.listener = stationListSelectListener;
        this.wrapperBoardingStationModelArrayList = arrayList;
    }

    public int getItemCount() {
        return this.wrapperBoardingStationModelArrayList.size();
    }

    public BoardingStationChangeItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_boarding_station_view, (ViewGroup) null);
        BoardingStationChangeItemHolder boardingStationChangeItemHolder = new BoardingStationChangeItemHolder(r);
        xx.O(-1, -2, r);
        return boardingStationChangeItemHolder;
    }

    public void onBindViewHolder(BoardingStationChangeItemHolder boardingStationChangeItemHolder, int i) {
        WrapperBoardingStationModel wrapperBoardingStationModel = this.wrapperBoardingStationModelArrayList.get(i);
        boardingStationChangeItemHolder.item = wrapperBoardingStationModel;
        StationDb stationDb = C0793b1.a.f3911a;
        TextView textView = boardingStationChangeItemHolder.stnNamedate;
        textView.setText(stationDb.m(wrapperBoardingStationModel.a.getStnNameCode().split("-")[1]) + wrapperBoardingStationModel.a.getStnNameCode().split("-")[1] + ", " + wrapperBoardingStationModel.a.getDepartureTime());
        boardingStationChangeItemHolder.stationListRelativeLayout.setTag(Integer.valueOf(i));
        if (wrapperBoardingStationModel.f5354a) {
            C1058d.H(this.mContext, R.color.dark, boardingStationChangeItemHolder.stnNamedate);
            boardingStationChangeItemHolder.stnNamedate.setTypeface((Typeface) null, 1);
        } else {
            C1058d.H(this.mContext, R.color.dark, boardingStationChangeItemHolder.stnNamedate);
            boardingStationChangeItemHolder.stnNamedate.setTypeface((Typeface) null, 0);
        }
        if (i == 0) {
            C1058d.H(this.mContext, R.color.Shatabdi_color, boardingStationChangeItemHolder.stnNamedate);
        }
        if (i == PassengerDetailFragment.o) {
            C1058d.H(this.mContext, R.color.Shatabdi_color, boardingStationChangeItemHolder.stnNamedate);
        }
    }
}
