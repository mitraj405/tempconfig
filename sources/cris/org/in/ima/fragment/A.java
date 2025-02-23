package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.adaptors.CancelTicketPassengerAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.ArrayList;
import java.util.Collections;
import rx.Subscriber;

/* compiled from: CancelTicketDetailsFragment */
public final class A extends Subscriber<C0707Ue> {
    public final /* synthetic */ CancelTicketDetailsFragment a;

    public A(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
        this.a = cancelTicketDetailsFragment;
    }

    public final void onCompleted() {
        int i = CancelTicketDetailsFragment.f;
    }

    public final void onError(Throwable th) {
        CancelTicketDetailsFragment cancelTicketDetailsFragment = this.a;
        ProgressDialog progressDialog = cancelTicketDetailsFragment.f4478a;
        CancelTicketDetailsFragment cancelTicketDetailsFragment2 = cancelTicketDetailsFragment.f4482a;
        progressDialog.dismiss();
        int i = CancelTicketDetailsFragment.f;
        th.getClass();
        th.getMessage();
        try {
            if (cancelTicketDetailsFragment2.getFragmentManager() != null && cancelTicketDetailsFragment2.getFragmentManager().F() > 0) {
                cancelTicketDetailsFragment2.getFragmentManager().Q();
            }
        } catch (IllegalStateException e) {
            int i2 = CancelTicketDetailsFragment.f;
            e.getMessage();
        }
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        String str;
        String str2;
        String str3;
        C0707Ue ue = (C0707Ue) obj;
        int i = CancelTicketDetailsFragment.f;
        CancelTicketDetailsFragment cancelTicketDetailsFragment = this.a;
        if (ue == null) {
            cancelTicketDetailsFragment.f4478a.dismiss();
            C0535I5.m(cancelTicketDetailsFragment.f4479a, false, cancelTicketDetailsFragment.getString(R.string.unable_process_message), cancelTicketDetailsFragment.getString(R.string.error), cancelTicketDetailsFragment.getString(R.string.OK), new C1062d4(this)).show();
        } else if (ue.getErrorMsg() == null) {
            BookingResponseDTO bookingResponseDTO = ue.getBookingResponseList().get(0);
            cancelTicketDetailsFragment.b = bookingResponseDTO;
            bookingResponseDTO.toString();
            if (bookingResponseDTO.getPnrLinkStatus() == null || bookingResponseDTO.getPnrLinkStatus().intValue() != 1) {
                cancelTicketDetailsFragment.connectingPnrLayout.setVisibility(8);
                cancelTicketDetailsFragment.f4486b = false;
            } else {
                cancelTicketDetailsFragment.connectingPnrLayout.setVisibility(0);
                cancelTicketDetailsFragment.connectingPnr.setText(bookingResponseDTO.getConnectingPnrNumber());
                if (bookingResponseDTO.getJourneyLap().intValue() == 1) {
                    cancelTicketDetailsFragment.f4486b = true;
                    cancelTicketDetailsFragment.lapType.setText(cancelTicketDetailsFragment.getString(R.string.Sub_Journey));
                } else if (bookingResponseDTO.getJourneyLap().intValue() == 2) {
                    cancelTicketDetailsFragment.f4486b = true;
                    cancelTicketDetailsFragment.lapType.setText(cancelTicketDetailsFragment.getString(R.string.Main_Journey));
                } else {
                    cancelTicketDetailsFragment.f4486b = false;
                }
            }
            cancelTicketDetailsFragment.f4485a = cancelTicketDetailsFragment.b.getCanSpouseFlag().booleanValue();
            cancelTicketDetailsFragment.f4483a = new BookingResponseDTO();
            if (ue.getBookingResponseList().get(0).getScheduleArrivalFlag().booleanValue() && ue.getBookingResponseList().get(0).getScheduleDepartureFlag().booleanValue()) {
                cancelTicketDetailsFragment.f4483a.setBoardingDate(ue.getBookingResponseList().get(0).getBoardingDate());
                cancelTicketDetailsFragment.f4483a.setDestArrvDate(ue.getBookingResponseList().get(0).getDestArrvDate());
                cancelTicketDetailsFragment.journeyDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getBoardingDate()));
                cancelTicketDetailsFragment.destArrDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getDestArrvDate()));
                cancelTicketDetailsFragment.journeyTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getBoardingDate()));
                cancelTicketDetailsFragment.destArrTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getDestArrvDate()));
            } else if (ue.getBookingResponseList().get(0).getScheduleArrivalFlag().booleanValue()) {
                cancelTicketDetailsFragment.f4483a.setBoardingDate(ue.getBookingResponseList().get(0).getBoardingDate());
                cancelTicketDetailsFragment.journeyDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getBoardingDate()));
                cancelTicketDetailsFragment.journeyTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getBoardingDate()));
                cancelTicketDetailsFragment.destArrDate.setText("*N.A.");
                cancelTicketDetailsFragment.destArrTime.setText("*N.A.");
            } else if (ue.getBookingResponseList().get(0).getScheduleDepartureFlag().booleanValue()) {
                cancelTicketDetailsFragment.f4483a.setDestArrvDate(ue.getBookingResponseList().get(0).getDestArrvDate());
                cancelTicketDetailsFragment.journeyDate.setText("*N.A.");
                cancelTicketDetailsFragment.journeyTime.setText("*N.A.");
                cancelTicketDetailsFragment.destArrDate.setText(C0535I5.U(ue.getBookingResponseList().get(0).getDestArrvDate()));
                cancelTicketDetailsFragment.destArrTime.setText(C0535I5.V(ue.getBookingResponseList().get(0).getDestArrvDate()));
            } else {
                cancelTicketDetailsFragment.journeyDate.setText("*N.A.");
                cancelTicketDetailsFragment.journeyTime.setText("*N.A.");
                cancelTicketDetailsFragment.destArrDate.setText("*N.A.");
                cancelTicketDetailsFragment.destArrTime.setText("*N.A.");
            }
            if (ue.getBookingResponseList().get(0).getBoardingDate() == null || ue.getBookingResponseList().get(0).getDestArrvDate() == null) {
                cancelTicketDetailsFragment.travel_time.setVisibility(4);
            } else {
                cancelTicketDetailsFragment.travel_time.setVisibility(0);
                cancelTicketDetailsFragment.travel_time.setText(C0535I5.A(ue.getBookingResponseList().get(0).getBoardingDate(), ue.getBookingResponseList().get(0).getDestArrvDate()));
            }
            ArrayList<PassengerDetailDTO> psgnDtlList = ue.getBookingResponseList().get(0).getPsgnDtlList();
            cancelTicketDetailsFragment.f4484a = psgnDtlList;
            Collections.sort(psgnDtlList, new C0795b4());
            cancelTicketDetailsFragment.tv_chart_status.setText(cancelTicketDetailsFragment.b.getTrainChartStatus());
            if (cancelTicketDetailsFragment.b.getJourneyClass() == null) {
                str = "";
            } else if (xx.e(cancelTicketDetailsFragment.b.getJourneyClass()) != null) {
                str = " | " + xx.e(cancelTicketDetailsFragment.b.getJourneyClass());
            } else {
                str = " | " + cancelTicketDetailsFragment.b.getJourneyClass();
            }
            int size = cancelTicketDetailsFragment.b.getPsgnDtlList().size();
            StationDb stationDb = cancelTicketDetailsFragment.f4481a;
            if (size > 1) {
                cancelTicketDetailsFragment.tktDetails.setText(cancelTicketDetailsFragment.b.getPsgnDtlList().size() + " " + cancelTicketDetailsFragment.getString(R.string.passengers) + " | " + cancelTicketDetailsFragment.b.getBookedQuota() + str + " | " + C0535I5.s0(stationDb.m(cancelTicketDetailsFragment.b.getFromStn())) + "(" + cancelTicketDetailsFragment.b.getFromStn() + ") | " + C0535I5.h(cancelTicketDetailsFragment.b.getJourneyDate()));
            } else {
                cancelTicketDetailsFragment.tktDetails.setText(cancelTicketDetailsFragment.b.getPsgnDtlList().size() + " " + cancelTicketDetailsFragment.getString(R.string.passenger) + " | " + cancelTicketDetailsFragment.b.getBookedQuota() + str + " | " + C0535I5.s0(stationDb.m(cancelTicketDetailsFragment.b.getFromStn())) + "(" + cancelTicketDetailsFragment.b.getFromStn() + ") | " + C0535I5.h(cancelTicketDetailsFragment.b.getJourneyDate()));
            }
            cancelTicketDetailsFragment.fromcitycode.setText(C0535I5.s0(C0793b1.a.f3911a.m(cancelTicketDetailsFragment.b.getBoardingStn())) + "(" + cancelTicketDetailsFragment.b.getBoardingStn() + ")");
            cancelTicketDetailsFragment.f4480a = new CancelTicketPassengerAdapter(cancelTicketDetailsFragment.f4482a, cancelTicketDetailsFragment.f4484a);
            if (ue.getBookingResponseList().get(0).getReasonType() == null || !ue.getBookingResponseList().get(0).getReasonType().equalsIgnoreCase("C")) {
                cancelTicketDetailsFragment.f4480a.setCantegency(false);
            } else {
                cancelTicketDetailsFragment.f4480a.setSelectAll(true);
                cancelTicketDetailsFragment.f4480a.setCantegency(true);
                cancelTicketDetailsFragment.b.setErrorMessage(cancelTicketDetailsFragment.getString(R.string.Full_cancellation_allowed));
            }
            cancelTicketDetailsFragment.passengerList.setAdapter(cancelTicketDetailsFragment.f4480a);
            cancelTicketDetailsFragment.f4478a.dismiss();
            String[] informationMessage = ue.getBookingResponseList().get(0).getInformationMessage();
            if (informationMessage != null) {
                str2 = "";
                for (String str4 : informationMessage) {
                    if (str4 == null || str4.trim().equals("")) {
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    String str5 = "* ";
                    if (str2.length() <= 1 || str2.charAt(0) == '*') {
                        str3 = "";
                    } else {
                        str3 = str5;
                    }
                    sb.append(str3);
                    sb.append(str2);
                    if (str2.length() <= 1) {
                        str5 = "";
                    }
                    str2 = C1058d.B(sb, str5, str4, "\n");
                }
            } else {
                str2 = "";
            }
            int i2 = CancelTicketDetailsFragment.f;
            if (!str2.trim().equals("")) {
                String replace = str2.replace("You likely", "You are likely");
                cancelTicketDetailsFragment.errmessage.setVisibility(0);
                cancelTicketDetailsFragment.errmessage.setText(replace.toUpperCase());
                cancelTicketDetailsFragment.b.setErrorMessage(str2);
            }
            if (cancelTicketDetailsFragment.b.getMetroServiceDetail() != null) {
                cancelTicketDetailsFragment.selection_checkbox_ll.setVisibility(0);
                cancelTicketDetailsFragment.no_of_passenger_ll.setVisibility(0);
                cancelTicketDetailsFragment.fromStnDmrc.setText(cancelTicketDetailsFragment.b.getMetroServiceDetail().getMetroFromStation());
                cancelTicketDetailsFragment.toStnDmrc.setText(cancelTicketDetailsFragment.b.getMetroServiceDetail().getMetroToStation());
                cancelTicketDetailsFragment.f4488c = cancelTicketDetailsFragment.b.getMetroServiceDetail().getMetroFromStation();
                cancelTicketDetailsFragment.f4489d = cancelTicketDetailsFragment.b.getMetroServiceDetail().getMetroToStation();
                cancelTicketDetailsFragment.no_of_psgn.setText("Total Passenger: " + (cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfPassengerOpted().shortValue() - cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfCancelPsgn().shortValue()));
                cancelTicketDetailsFragment.d = cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfPassengerOpted().shortValue();
                cancelTicketDetailsFragment.e = cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfCancelPsgn().shortValue();
                cancelTicketDetailsFragment.no_of_can_psgn.setText("Cancelled Passenger : " + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfCancelPsgn());
                cancelTicketDetailsFragment.selected_psgn.setText("(" + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfCancelPsgn() + RemoteSettings.FORWARD_SLASH_STRING + cancelTicketDetailsFragment.b.getMetroServiceDetail().getNumberOfPassengerOpted() + ")");
            }
        } else {
            ue.getErrorMsg();
            cancelTicketDetailsFragment.f4478a.dismiss();
            C0535I5.m(cancelTicketDetailsFragment.f4479a, false, ue.getErrorMsg().split("- ")[0], cancelTicketDetailsFragment.getString(R.string.error), cancelTicketDetailsFragment.getString(R.string.OK), new C0814c4(this)).show();
        }
    }
}
