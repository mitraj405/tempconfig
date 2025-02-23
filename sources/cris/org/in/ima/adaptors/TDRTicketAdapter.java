package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TDRTicketAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(TDRTicketAdapter.class);
    /* access modifiers changed from: private */
    public FileTdrListener fileTdrListener;
    private GoogleAdParamDTO googleAd;
    private Context mContext;
    private ArrayList<BookingResponseDTO> tdrTktList;

    public interface FileTdrListener {
        void onLayoutClick(BookingResponseDTO bookingResponseDTO);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362060)
        TextView bookingdate;
        @BindView(2131362652)
        LinearLayout fileTdrll;
        @BindView(2131362715)
        TextView fromcitycode;
        @BindView(2131362920)
        TextView jrnyDate;
        @BindView(2131363506)
        TextView pnr;
        BookingResponseDTO tkt;
        @BindView(2131364169)
        TextView tocitycode;
        @BindView(2131364201)
        TextView trainName;
        @BindView(2131364203)
        TextView trainno;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362652})
        public void onCancelClick(View view) {
            TDRTicketAdapter.this.fileTdrListener.onLayoutClick(this.tkt);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a035c;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.file_tdr_ll, "field 'fileTdrll' and method 'onCancelClick'");
            viewHolder.fileTdrll = (LinearLayout) Utils.castView(findRequiredView, R.id.file_tdr_ll, "field 'fileTdrll'", LinearLayout.class);
            this.view7f0a035c = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onCancelClick(view);
                }
            });
            Class cls = TextView.class;
            viewHolder.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
            viewHolder.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
            viewHolder.trainno = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainno'", cls);
            viewHolder.jrnyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'jrnyDate'", cls);
            viewHolder.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'tocitycode'", cls);
            viewHolder.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromcitycode'", cls);
            viewHolder.bookingdate = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date, "field 'bookingdate'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.fileTdrll = null;
                viewHolder.pnr = null;
                viewHolder.trainName = null;
                viewHolder.trainno = null;
                viewHolder.jrnyDate = null;
                viewHolder.tocitycode = null;
                viewHolder.fromcitycode = null;
                viewHolder.bookingdate = null;
                this.view7f0a035c.setOnClickListener((View.OnClickListener) null);
                this.view7f0a035c = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public TDRTicketAdapter(Context context, FileTdrListener fileTdrListener2, ArrayList<BookingResponseDTO> arrayList) {
        this.mContext = context;
        this.fileTdrListener = fileTdrListener2;
        this.tdrTktList = arrayList;
    }

    public int getItemCount() {
        return this.tdrTktList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_file_tdr, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String str;
        StationDb stationDb = C0793b1.a.f3911a;
        viewHolder.tkt = this.tdrTktList.get(i);
        viewHolder.pnr.setText(this.tdrTktList.get(i).getPnrNumber());
        viewHolder.trainName.setText(this.tdrTktList.get(i).getTrainName());
        TextView textView = viewHolder.trainno;
        textView.setText(" (" + this.tdrTktList.get(i).getTrainNumber() + ")");
        viewHolder.jrnyDate.setText(C0535I5.U(this.tdrTktList.get(i).getJourneyDate()));
        BookingResponseDTO bookingResponseDTO = this.tdrTktList.get(i);
        viewHolder.fromcitycode.setText(stationDb.m(this.tdrTktList.get(i).getFromStn()));
        viewHolder.tocitycode.setText(stationDb.m(this.tdrTktList.get(i).getDestStn()));
        TextView textView2 = viewHolder.bookingdate;
        Date bookingDate = this.tdrTktList.get(i).getBookingDate();
        if (bookingDate == null) {
            str = "";
        } else {
            new SimpleDateFormat("yyyy-MM-dd");
            str = new SimpleDateFormat("dd, EEE, MMM, yyyy").format(bookingDate);
        }
        textView2.setText(str);
    }
}
