package cris.org.in.ima.view_holder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import defpackage.d7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ErsTravelnsuranceViewHolder extends RecyclerView.Adapter<ErsTravelInsuranceItemHolder> {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final Context f5391a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<PassengerDetailDTO> f5392a = null;

    /* renamed from: a  reason: collision with other field name */
    public final List<BookingResponseDTO> f5393a;

    public class ErsTravelInsuranceItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131362853)
        TextView insurance_compay_name;
        @BindView(2131362854)
        LinearLayout insurance_compay_name_ll;
        @BindView(2131363025)
        LinearLayout ll_fill_nominee_details;
        @BindView(2131363460)
        RelativeLayout passenger_name_rl;
        @BindView(2131364697)
        TextView travelInsuranceHeading;
        @BindView(2131364236)
        TextView travel_insurance;
        @BindView(2131364243)
        RelativeLayout travel_insurance_rl;
        @BindView(2131364409)
        TextView tv_fill_nominee_details;
        @BindView(2131364523)
        TextView tv_passenger_name;
        @BindView(2131364698)
        TextView tv_travel_Insurance_name;

        public ErsTravelInsuranceItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }
    }

    public class ErsTravelInsuranceItemHolder_ViewBinding implements Unbinder {
        public ErsTravelInsuranceItemHolder a;

        public ErsTravelInsuranceItemHolder_ViewBinding(ErsTravelInsuranceItemHolder ersTravelInsuranceItemHolder, View view) {
            this.a = ersTravelInsuranceItemHolder;
            Class cls = TextView.class;
            ersTravelInsuranceItemHolder.travel_insurance = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_insurance, "field 'travel_insurance'", cls);
            ersTravelInsuranceItemHolder.tv_travel_Insurance_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_travel_Insurance_name, "field 'tv_travel_Insurance_name'", cls);
            ersTravelInsuranceItemHolder.tv_passenger_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_passenger_name, "field 'tv_passenger_name'", cls);
            ersTravelInsuranceItemHolder.tv_fill_nominee_details = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fill_nominee_details, "field 'tv_fill_nominee_details'", cls);
            Class cls2 = RelativeLayout.class;
            ersTravelInsuranceItemHolder.travel_insurance_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.travel_insurance_rl, "field 'travel_insurance_rl'", cls2);
            ersTravelInsuranceItemHolder.travelInsuranceHeading = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_travel_Insurance_heading, "field 'travelInsuranceHeading'", cls);
            ersTravelInsuranceItemHolder.insurance_compay_name = (TextView) Utils.findRequiredViewAsType(view, R.id.insurance_compay_name, "field 'insurance_compay_name'", cls);
            Class cls3 = LinearLayout.class;
            ersTravelInsuranceItemHolder.insurance_compay_name_ll = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.insurance_compay_name_ll, "field 'insurance_compay_name_ll'", cls3);
            ersTravelInsuranceItemHolder.passenger_name_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.passenger_name_rl, "field 'passenger_name_rl'", cls2);
            ersTravelInsuranceItemHolder.ll_fill_nominee_details = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_fill_nominee_details, "field 'll_fill_nominee_details'", cls3);
        }

        public final void unbind() {
            ErsTravelInsuranceItemHolder ersTravelInsuranceItemHolder = this.a;
            if (ersTravelInsuranceItemHolder != null) {
                this.a = null;
                ersTravelInsuranceItemHolder.travel_insurance = null;
                ersTravelInsuranceItemHolder.tv_travel_Insurance_name = null;
                ersTravelInsuranceItemHolder.tv_passenger_name = null;
                ersTravelInsuranceItemHolder.tv_fill_nominee_details = null;
                ersTravelInsuranceItemHolder.travel_insurance_rl = null;
                ersTravelInsuranceItemHolder.travelInsuranceHeading = null;
                ersTravelInsuranceItemHolder.insurance_compay_name = null;
                ersTravelInsuranceItemHolder.insurance_compay_name_ll = null;
                ersTravelInsuranceItemHolder.passenger_name_rl = null;
                ersTravelInsuranceItemHolder.ll_fill_nominee_details = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static {
        C1354qp.R(ErsTravelnsuranceViewHolder.class);
    }

    public ErsTravelnsuranceViewHolder(Context context, ArrayList arrayList) {
        this.f5391a = context;
        this.f5393a = arrayList;
    }

    public final int getItemCount() {
        return this.f5393a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ErsTravelInsuranceItemHolder ersTravelInsuranceItemHolder = (ErsTravelInsuranceItemHolder) viewHolder;
        List<BookingResponseDTO> list = this.f5393a;
        BookingResponseDTO bookingResponseDTO = list.get(i);
        ersTravelInsuranceItemHolder.getClass();
        if (bookingResponseDTO != null) {
            bookingResponseDTO.toString();
            if (C0535I5.f3647h) {
                if (i == 0) {
                    ersTravelInsuranceItemHolder.travel_insurance_rl.setVisibility(0);
                    TextView textView = ersTravelInsuranceItemHolder.travelInsuranceHeading;
                    textView.setText("Travel Insurance For Lap " + (i + 1) + " ");
                } else if (i == list.size() / 2) {
                    ersTravelInsuranceItemHolder.travel_insurance_rl.setVisibility(0);
                    ersTravelInsuranceItemHolder.travelInsuranceHeading.setText("Travel Insurance For Lap 2 ");
                } else {
                    ersTravelInsuranceItemHolder.travel_insurance_rl.setVisibility(8);
                }
            }
            ersTravelInsuranceItemHolder.travel_insurance.setVisibility(8);
            if (bookingResponseDTO.getInsuranceOpted() != null) {
                ersTravelInsuranceItemHolder.travel_insurance.setVisibility(0);
                ersTravelInsuranceItemHolder.travel_insurance.setText(bookingResponseDTO.getInsuranceOpted());
            } else {
                ersTravelInsuranceItemHolder.travel_insurance.setVisibility(0);
                ersTravelInsuranceItemHolder.travel_insurance.setText("N/A");
            }
            ersTravelInsuranceItemHolder.tv_travel_Insurance_name.setText(bookingResponseDTO.getInsuranceCompany());
            this.f5392a = list.get(0).getPsgnDtlList();
            if (bookingResponseDTO.getInsuranceOpted() != null && !bookingResponseDTO.getInsuranceOpted().equalsIgnoreCase("NO") && !bookingResponseDTO.getInsuranceOpted().equalsIgnoreCase("N/A")) {
                ersTravelInsuranceItemHolder.insurance_compay_name_ll.setVisibility(0);
                ersTravelInsuranceItemHolder.insurance_compay_name.setVisibility(0);
                ersTravelInsuranceItemHolder.tv_travel_Insurance_name.setText(bookingResponseDTO.getInsuranceCompany());
                if (bookingResponseDTO.getInsuranceCompanyUrl() == null || bookingResponseDTO.getInsuranceCompanyUrl().trim().compareToIgnoreCase("") == 0) {
                    ersTravelInsuranceItemHolder.tv_fill_nominee_details.setVisibility(8);
                } else {
                    ersTravelInsuranceItemHolder.tv_fill_nominee_details.setVisibility(0);
                    ersTravelInsuranceItemHolder.ll_fill_nominee_details.setVisibility(0);
                    Context context = this.f5391a;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getString(R.string.Click_here_to_fill_the_nominee_detail));
                    Object obj = d7.a;
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.primary_blue));
                    try {
                        spannableStringBuilder.setSpan(new a(this, bookingResponseDTO), 0, 37, 33);
                        spannableStringBuilder.setSpan(foregroundColorSpan, 0, 37, 18);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    ersTravelInsuranceItemHolder.tv_fill_nominee_details.setText(spannableStringBuilder);
                    ersTravelInsuranceItemHolder.tv_fill_nominee_details.setMovementMethod(LinkMovementMethod.getInstance());
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("");
                ArrayList<PassengerDetailDTO> arrayList = this.f5392a;
                if (arrayList != null) {
                    Iterator<PassengerDetailDTO> it = arrayList.iterator();
                    while (it.hasNext()) {
                        PassengerDetailDTO next = it.next();
                        spannableStringBuilder2.append("Policy Number of " + next.getPassengerName() + " : ");
                        if (next.getPolicyNumber() != null) {
                            spannableStringBuilder2.append(next.getPolicyNumber() + " \n");
                        } else {
                            spannableStringBuilder2.append("NOT APPLICABLE \n");
                        }
                    }
                }
                ersTravelInsuranceItemHolder.passenger_name_rl.setVisibility(0);
                ersTravelInsuranceItemHolder.tv_passenger_name.setText(spannableStringBuilder2);
            }
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.ers_travel_insurance, (ViewGroup) null);
        ErsTravelInsuranceItemHolder ersTravelInsuranceItemHolder = new ErsTravelInsuranceItemHolder(r);
        xx.O(-1, -2, r);
        return ersTravelInsuranceItemHolder;
    }
}
