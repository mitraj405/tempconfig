package cris.org.in.ima.view_holder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.fragment.A0;
import cris.org.in.ima.fragment.B0;
import cris.org.in.ima.fragment.TrainDashboardFragment;
import cris.org.in.ima.fragment.z0;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import java.util.ArrayList;

public final class UpcomingJourneyItemHolder extends RecyclerView.Adapter<ViewHolder> {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5425a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<RecentTransactionsDTO> f5426a;

    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with other field name */
        public RecentTransactionsDTO f5427a;
        @BindView(2131362364)
        CardView cv_tab_upcoming_journey;
        @BindView(2131363083)
        LinearLayout ll_tab_upcoming_journey_item_ticket;
        @BindView(2131363386)
        TextView orderfood_Pantry_Car;
        @BindView(2131364323)
        TextView tv_bus;
        @BindView(2131364626)
        TextView tv_tab_delhi_metro;
        @BindView(2131364646)
        TextView tv_tab_upcoming_journey_date;
        @BindView(2131364647)
        TextView tv_tab_upcoming_journey_from;
        @BindView(2131364648)
        TextView tv_tab_upcoming_journey_hotel;
        @BindView(2131364649)
        TextView tv_tab_upcoming_journey_mot;
        @BindView(2131364650)
        TextView tv_tab_upcoming_journey_pnr;
        @BindView(2131364651)
        TextView tv_tab_upcoming_journey_retroom;
        @BindView(2131364652)
        TextView tv_tab_upcoming_journey_to;
        @BindView(2131364653)
        TextView tv_tab_upcoming_journey_train;
        @BindView(2131364654)
        TextView tv_tab_upcoming_journey_train_num;
        @BindView(2131364661)
        TextView tv_timestamp;
        @BindView(2131364847)
        TextView visit_booking_history;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364626})
        public void UpcomingDelhiMetro(View view) {
            a aVar = UpcomingJourneyItemHolder.this.f5425a;
            if (aVar != null) {
                RecentTransactionsDTO recentTransactionsDTO = this.f5427a;
                int i = TrainDashboardFragment.c;
                TrainDashboardFragment trainDashboardFragment = TrainDashboardFragment.this;
                trainDashboardFragment.getClass();
                C1223kn knVar = C0793b1.a.f3912a;
                trainDashboardFragment.f5172a = knVar;
                if (knVar != null) {
                    String z = C1058d.z(C0657Qt.j(), "checkForDMRC");
                    C0766Zb zb = new C0766Zb();
                    zb.setPnrNumber(recentTransactionsDTO.getPnrNumber());
                    zb.setTxnId(String.valueOf(recentTransactionsDTO.getTransactionId()));
                    ((Om) C0657Qt.c(knVar)).E(z, zb).c(C1181iv.a()).a(E0.a()).b(new C1495yA(trainDashboardFragment, recentTransactionsDTO));
                    return;
                }
                C0535I5.m(trainDashboardFragment.getActivity(), false, trainDashboardFragment.getResources().getString(R.string.data_connection_error_message), trainDashboardFragment.getString(R.string.error), trainDashboardFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }

        @OnClick({2131364847})
        public void UpcomingDownloadDmrcTktDetails(View view) {
            UpcomingJourneyItemHolder.this.f5425a.getClass();
        }

        @OnClick({2131364323})
        public void UpcomingJourneyBus(View view) {
            a aVar = UpcomingJourneyItemHolder.this.f5425a;
            if (aVar != null) {
                RecentTransactionsDTO recentTransactionsDTO = this.f5427a;
                TrainDashboardFragment.d dVar = (TrainDashboardFragment.d) aVar;
                TrainDashboardFragment trainDashboardFragment = TrainDashboardFragment.this;
                Toast.makeText(trainDashboardFragment.getContext(), trainDashboardFragment.getResources().getString(R.string.unble_toconnect_server), 1);
                new Thread(new B0(dVar, recentTransactionsDTO)).start();
            }
        }

        @OnClick({2131364648})
        public void UpcomingJourneyHotel(View view) {
            a aVar = UpcomingJourneyItemHolder.this.f5425a;
            if (aVar != null) {
                RecentTransactionsDTO recentTransactionsDTO = this.f5427a;
                TrainDashboardFragment.d dVar = (TrainDashboardFragment.d) aVar;
                dVar.getClass();
                if (recentTransactionsDTO.getRrHotelFlag().charAt(1) == 'Y') {
                    TrainDashboardFragment trainDashboardFragment = TrainDashboardFragment.this;
                    new Thread(new A0(dVar, recentTransactionsDTO, Toast.makeText(trainDashboardFragment.getContext(), trainDashboardFragment.getResources().getString(R.string.unble_toconnect_server), 1))).start();
                }
            }
        }

        @OnClick({2131364649})
        public void UpcomingJourneyMoT(View view) {
            a aVar = UpcomingJourneyItemHolder.this.f5425a;
            if (aVar != null) {
                RecentTransactionsDTO recentTransactionsDTO = this.f5427a;
                TrainDashboardFragment.d dVar = (TrainDashboardFragment.d) aVar;
                dVar.getClass();
                String pnrNumber = recentTransactionsDTO.getPnrNumber();
                TrainDashboardFragment trainDashboardFragment = TrainDashboardFragment.this;
                trainDashboardFragment.getClass();
                try {
                    trainDashboardFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.ecatering.irctc.co.in/" + pnrNumber + "/outlets?utm_source=irctc&utm_medium=android_app&utm_campaign=booking_page")));
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }

        @OnClick({2131364651})
        public void UpcomingJourneyRR(View view) {
            a aVar = UpcomingJourneyItemHolder.this.f5425a;
            if (aVar != null) {
                RecentTransactionsDTO recentTransactionsDTO = this.f5427a;
                TrainDashboardFragment.d dVar = (TrainDashboardFragment.d) aVar;
                dVar.getClass();
                if (recentTransactionsDTO.getRrHotelFlag().charAt(0) == 'Y') {
                    new Thread(new z0(dVar, recentTransactionsDTO)).start();
                }
            }
        }

        @OnClick({2131363083})
        public void UpcomingJourneyTicket(View view) {
            a aVar = UpcomingJourneyItemHolder.this.f5425a;
            if (aVar != null) {
                aVar.getClass();
            }
        }

        @OnClick({2131363386})
        public void orderfoodPantryCarClick(View view) {
            a aVar = UpcomingJourneyItemHolder.this.f5425a;
            if (aVar != null) {
                TrainDashboardFragment.d dVar = (TrainDashboardFragment.d) aVar;
                dVar.getClass();
                TrainDashboardFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctctourism.com/BookFood/")));
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ViewHolder f5428a;
        public View b;
        public View c;
        public View d;
        public View e;
        public View f;
        public View g;
        public View h;

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class a extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.UpcomingJourneyRR(view);
            }
        }

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class b extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public b(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.UpcomingJourneyHotel(view);
            }
        }

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class c extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public c(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.UpcomingJourneyMoT(view);
            }
        }

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class d extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public d(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.UpcomingJourneyTicket(view);
            }
        }

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class e extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public e(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.UpcomingJourneyBus(view);
            }
        }

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class f extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public f(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.orderfoodPantryCarClick(view);
            }
        }

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class g extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public g(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.UpcomingDelhiMetro(view);
            }
        }

        /* compiled from: UpcomingJourneyItemHolder$ViewHolder_ViewBinding */
        public class h extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public h(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.UpcomingDownloadDmrcTktDetails(view);
            }
        }

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f5428a = viewHolder;
            Class cls = TextView.class;
            viewHolder.tv_tab_upcoming_journey_train = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_upcoming_journey_train, "field 'tv_tab_upcoming_journey_train'", cls);
            viewHolder.tv_tab_upcoming_journey_train_num = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_upcoming_journey_train_num, "field 'tv_tab_upcoming_journey_train_num'", cls);
            viewHolder.tv_tab_upcoming_journey_pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_upcoming_journey_pnr, "field 'tv_tab_upcoming_journey_pnr'", cls);
            viewHolder.tv_tab_upcoming_journey_date = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_upcoming_journey_date, "field 'tv_tab_upcoming_journey_date'", cls);
            viewHolder.tv_timestamp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timestamp, "field 'tv_timestamp'", cls);
            viewHolder.tv_tab_upcoming_journey_from = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_upcoming_journey_from, "field 'tv_tab_upcoming_journey_from'", cls);
            viewHolder.tv_tab_upcoming_journey_to = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_upcoming_journey_to, "field 'tv_tab_upcoming_journey_to'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_retroom, "field 'tv_tab_upcoming_journey_retroom' and method 'UpcomingJourneyRR'");
            viewHolder.tv_tab_upcoming_journey_retroom = (TextView) Utils.castView(findRequiredView, R.id.tv_tab_upcoming_journey_retroom, "field 'tv_tab_upcoming_journey_retroom'", cls);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(viewHolder));
            View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_hotel, "field 'tv_tab_upcoming_journey_hotel' and method 'UpcomingJourneyHotel'");
            viewHolder.tv_tab_upcoming_journey_hotel = (TextView) Utils.castView(findRequiredView2, R.id.tv_tab_upcoming_journey_hotel, "field 'tv_tab_upcoming_journey_hotel'", cls);
            this.b = findRequiredView2;
            findRequiredView2.setOnClickListener(new b(viewHolder));
            View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_tab_upcoming_journey_mot, "field 'tv_tab_upcoming_journey_mot' and method 'UpcomingJourneyMoT'");
            viewHolder.tv_tab_upcoming_journey_mot = (TextView) Utils.castView(findRequiredView3, R.id.tv_tab_upcoming_journey_mot, "field 'tv_tab_upcoming_journey_mot'", cls);
            this.c = findRequiredView3;
            findRequiredView3.setOnClickListener(new c(viewHolder));
            viewHolder.cv_tab_upcoming_journey = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_tab_upcoming_journey, "field 'cv_tab_upcoming_journey'", CardView.class);
            View findRequiredView4 = Utils.findRequiredView(view, R.id.ll_tab_upcoming_journey_item_ticket, "field 'll_tab_upcoming_journey_item_ticket' and method 'UpcomingJourneyTicket'");
            viewHolder.ll_tab_upcoming_journey_item_ticket = (LinearLayout) Utils.castView(findRequiredView4, R.id.ll_tab_upcoming_journey_item_ticket, "field 'll_tab_upcoming_journey_item_ticket'", LinearLayout.class);
            this.d = findRequiredView4;
            findRequiredView4.setOnClickListener(new d(viewHolder));
            View findRequiredView5 = Utils.findRequiredView(view, R.id.tv_bus, "field 'tv_bus' and method 'UpcomingJourneyBus'");
            viewHolder.tv_bus = (TextView) Utils.castView(findRequiredView5, R.id.tv_bus, "field 'tv_bus'", cls);
            this.e = findRequiredView5;
            findRequiredView5.setOnClickListener(new e(viewHolder));
            View findRequiredView6 = Utils.findRequiredView(view, R.id.orderfood_Pantry_Car, "field 'orderfood_Pantry_Car' and method 'orderfoodPantryCarClick'");
            viewHolder.orderfood_Pantry_Car = (TextView) Utils.castView(findRequiredView6, R.id.orderfood_Pantry_Car, "field 'orderfood_Pantry_Car'", cls);
            this.f = findRequiredView6;
            findRequiredView6.setOnClickListener(new f(viewHolder));
            View findRequiredView7 = Utils.findRequiredView(view, R.id.tv_tab_delhi_metro, "field 'tv_tab_delhi_metro' and method 'UpcomingDelhiMetro'");
            viewHolder.tv_tab_delhi_metro = (TextView) Utils.castView(findRequiredView7, R.id.tv_tab_delhi_metro, "field 'tv_tab_delhi_metro'", cls);
            this.g = findRequiredView7;
            findRequiredView7.setOnClickListener(new g(viewHolder));
            View findRequiredView8 = Utils.findRequiredView(view, R.id.visit_booking_history, "field 'visit_booking_history' and method 'UpcomingDownloadDmrcTktDetails'");
            viewHolder.visit_booking_history = (TextView) Utils.castView(findRequiredView8, R.id.visit_booking_history, "field 'visit_booking_history'", cls);
            this.h = findRequiredView8;
            findRequiredView8.setOnClickListener(new h(viewHolder));
        }

        public final void unbind() {
            ViewHolder viewHolder = this.f5428a;
            if (viewHolder != null) {
                this.f5428a = null;
                viewHolder.tv_tab_upcoming_journey_train = null;
                viewHolder.tv_tab_upcoming_journey_train_num = null;
                viewHolder.tv_tab_upcoming_journey_pnr = null;
                viewHolder.tv_tab_upcoming_journey_date = null;
                viewHolder.tv_timestamp = null;
                viewHolder.tv_tab_upcoming_journey_from = null;
                viewHolder.tv_tab_upcoming_journey_to = null;
                viewHolder.tv_tab_upcoming_journey_retroom = null;
                viewHolder.tv_tab_upcoming_journey_hotel = null;
                viewHolder.tv_tab_upcoming_journey_mot = null;
                viewHolder.cv_tab_upcoming_journey = null;
                viewHolder.ll_tab_upcoming_journey_item_ticket = null;
                viewHolder.tv_bus = null;
                viewHolder.orderfood_Pantry_Car = null;
                viewHolder.tv_tab_delhi_metro = null;
                viewHolder.visit_booking_history = null;
                this.a.setOnClickListener((View.OnClickListener) null);
                this.a = null;
                this.b.setOnClickListener((View.OnClickListener) null);
                this.b = null;
                this.c.setOnClickListener((View.OnClickListener) null);
                this.c = null;
                this.d.setOnClickListener((View.OnClickListener) null);
                this.d = null;
                this.e.setOnClickListener((View.OnClickListener) null);
                this.e = null;
                this.f.setOnClickListener((View.OnClickListener) null);
                this.f = null;
                this.g.setOnClickListener((View.OnClickListener) null);
                this.g = null;
                this.h.setOnClickListener((View.OnClickListener) null);
                this.h = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface a {
    }

    static {
        C1354qp.R(UpcomingJourneyItemHolder.class);
    }

    public UpcomingJourneyItemHolder(ArrayList arrayList, TrainDashboardFragment.d dVar) {
        this.f5426a = arrayList;
        this.f5425a = dVar;
    }

    public final int getItemCount() {
        ArrayList<RecentTransactionsDTO> arrayList = this.f5426a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        RecentTransactionsDTO recentTransactionsDTO = this.f5426a.get(i);
        recentTransactionsDTO.toString();
        viewHolder2.f5427a = recentTransactionsDTO;
        viewHolder2.tv_tab_upcoming_journey_train.setText(recentTransactionsDTO.getTrainName());
        TextView textView = viewHolder2.tv_tab_upcoming_journey_train_num;
        textView.setText("(" + recentTransactionsDTO.getTrainNumber() + ")");
        viewHolder2.tv_tab_upcoming_journey_pnr.setText(recentTransactionsDTO.getPnrNumber());
        viewHolder2.tv_tab_upcoming_journey_date.setText(C0535I5.F(recentTransactionsDTO.getBoardingDate()));
        viewHolder2.tv_timestamp.setText(C0535I5.V(recentTransactionsDTO.getBoardingDate()));
        viewHolder2.tv_tab_upcoming_journey_from.setText(recentTransactionsDTO.getFromStation());
        viewHolder2.tv_tab_upcoming_journey_to.setText(recentTransactionsDTO.getToStation());
        if (recentTransactionsDTO.getRrHotelFlag().equalsIgnoreCase("YY")) {
            viewHolder2.tv_tab_upcoming_journey_retroom.setBackgroundColor(Color.parseColor("#343434"));
            viewHolder2.tv_tab_upcoming_journey_hotel.setBackgroundColor(Color.parseColor("#343434"));
        } else if (recentTransactionsDTO.getRrHotelFlag().equalsIgnoreCase("YN")) {
            viewHolder2.tv_tab_upcoming_journey_hotel.setBackgroundColor(this.a.getResources().getColor(R.color.light_grey));
            viewHolder2.tv_tab_upcoming_journey_retroom.setBackgroundColor(Color.parseColor("#343434"));
        } else if (recentTransactionsDTO.getRrHotelFlag().equalsIgnoreCase("NY")) {
            viewHolder2.tv_tab_upcoming_journey_hotel.setBackgroundColor(Color.parseColor("#343434"));
            viewHolder2.tv_tab_upcoming_journey_retroom.setBackgroundColor(this.a.getResources().getColor(R.color.light_grey));
        }
        viewHolder2.tv_tab_upcoming_journey_mot.setBackgroundColor(Color.parseColor("#343434"));
        viewHolder2.tv_bus.setBackgroundColor(Color.parseColor("#343434"));
        viewHolder2.orderfood_Pantry_Car.setBackgroundColor(Color.parseColor("#343434"));
        viewHolder2.tv_tab_delhi_metro.setBackgroundColor(Color.parseColor("#dc3545"));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_upcoming_journey, (ViewGroup) null);
        this.a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
