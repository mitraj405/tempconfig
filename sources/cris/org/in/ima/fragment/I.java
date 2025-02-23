package cris.org.in.ima.fragment;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cris.org.in.ima.adaptors.TrainListViewHolder;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import java.text.SimpleDateFormat;

/* compiled from: ErsDisplayFragment */
public final class I implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ErsDisplayFragment f4655a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PnrEnquiryResponseDTO f4656a;

    public I(ErsDisplayFragment ersDisplayFragment, PnrEnquiryResponseDTO pnrEnquiryResponseDTO, TextView textView) {
        this.f4655a = ersDisplayFragment;
        this.f4656a = pnrEnquiryResponseDTO;
        this.a = textView;
    }

    public final void onClick(View view) {
        ErsDisplayFragment ersDisplayFragment = this.f4655a;
        LinearLayout linearLayout = ersDisplayFragment.cnfBtnLayout;
        Context context = ersDisplayFragment.f4569a;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        new SimpleDateFormat("dd-MM-yyyy");
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        KD kd = new KD();
        PnrEnquiryResponseDTO pnrEnquiryResponseDTO = this.f4656a;
        kd.setBookingDate(pnrEnquiryResponseDTO.getBookingDate());
        kd.setTrainNumber(pnrEnquiryResponseDTO.getTrainNumber());
        kd.setCurrentStatus(TrainListViewHolder.getWlStatus(ersDisplayFragment.f4578a.getCurrentStatus()));
        kd.setCurrentStatusNumber(Integer.valueOf(TrainListViewHolder.getWlStatusNumber(ersDisplayFragment.f4578a.getCurrentStatusDetails())));
        kd.setFromStnCode(pnrEnquiryResponseDTO.getSourceStation());
        kd.setToStnCode(pnrEnquiryResponseDTO.getDestinationStation());
        kd.setJourneyClass(pnrEnquiryResponseDTO.getJourneyClass());
        kd.setJourneyDate(simpleDateFormat.format(pnrEnquiryResponseDTO.getDateOfJourney()));
        kd.setQuota(pnrEnquiryResponseDTO.getQuota());
        kd.setRunningStatus(TrainListViewHolder.getWlStatus(ersDisplayFragment.f4578a.getBookingStatus()));
        kd.setRunningStatusNumber(Integer.valueOf(TrainListViewHolder.getWlStatusNumber(ersDisplayFragment.f4578a.getBookingStatusDetails())));
        kd.setSiteId(pnrEnquiryResponseDTO.getTrainSiteId());
        kd.setWlType(Integer.valueOf(ersDisplayFragment.f4578a.getPsgnwlType()));
        C0535I5.f3626b = "pnrEnquiry";
        C0535I5.f3631c = pnrEnquiryResponseDTO.getTrainName();
        C0535I5.f0(kd, this.a, ersDisplayFragment.cnfCheckCetails, context);
        ersDisplayFragment.pre.setEnabled(true);
    }
}
