package cris.org.in.ima.fragment;

import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import java.text.SimpleDateFormat;
import rx.Subscriber;

/* compiled from: ErsDisplayFragment */
public final class J extends Subscriber<PnrEnquiryResponseDTO> {
    public final /* synthetic */ ErsDisplayFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f4659a;

    public J(ErsDisplayFragment ersDisplayFragment, BookingResponseDTO bookingResponseDTO) {
        this.a = ersDisplayFragment;
        this.f4659a = bookingResponseDTO;
    }

    public final void onCompleted() {
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        this.a.f4568a.dismiss();
    }

    public final void onError(Throwable th) {
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        th.getClass();
        th.getMessage();
        this.a.f4568a.dismiss();
        Lt.a(true, th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x01bb A[Catch:{ Exception -> 0x02ad, all -> 0x02ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01c0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNext(java.lang.Object r13) {
        /*
            r12 = this;
            cris.prs.webservices.dto.PnrEnquiryResponseDTO r13 = (cris.prs.webservices.dto.PnrEnquiryResponseDTO) r13
            cris.org.in.ima.fragment.ErsDisplayFragment r0 = r12.a
            cris.prs.webservices.dto.BookingResponseDTO r1 = r12.f4659a
            if (r13 == 0) goto L_0x02bf
            com.fasterxml.jackson.databind.ObjectMapper r2 = defpackage.C0657Qt.h()
            java.lang.String r3 = r13.getErrorMessage()     // Catch:{ Exception -> 0x02ad }
            r4 = 2131951928(0x7f130138, float:1.9540284E38)
            r5 = 0
            if (r3 == 0) goto L_0x003c
            androidx.fragment.app.FragmentActivity r6 = r0.getActivity()     // Catch:{ Exception -> 0x02ad }
            r7 = 1
            java.lang.String r13 = r13.getErrorMessage()     // Catch:{ Exception -> 0x02ad }
            java.lang.String r1 = "-"
            java.lang.String[] r13 = r13.split(r1)     // Catch:{ Exception -> 0x02ad }
            r8 = r13[r5]     // Catch:{ Exception -> 0x02ad }
            r13 = 2131952926(0x7f13051e, float:1.9542309E38)
            java.lang.String r9 = r0.getString(r13)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r10 = r0.getString(r4)     // Catch:{ Exception -> 0x02ad }
            r11 = 0
            android.app.AlertDialog r13 = defpackage.C0535I5.m(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x02ad }
            r13.show()     // Catch:{ Exception -> 0x02ad }
            goto L_0x02b3
        L_0x003c:
            r2.writeValueAsString(r13)     // Catch:{ Exception -> 0x02ad }
            java.text.SimpleDateFormat r2 = cris.org.in.ima.fragment.ErsDisplayFragment.d     // Catch:{ Exception -> 0x02ad }
            java.lang.String r2 = r13.getChartStatus()     // Catch:{ Exception -> 0x02ad }
            r1.setTrainChartStatus(r2)     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r2 = r13.getPassengerList()     // Catch:{ Exception -> 0x02ad }
            int r3 = r2.size()     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            int r6 = r6.size()     // Catch:{ Exception -> 0x02ad }
            if (r3 != r6) goto L_0x028c
            r2.toString()     // Catch:{ Exception -> 0x02ad }
            java.lang.String r3 = r13.getQuota()     // Catch:{ Exception -> 0x02ad }
            r1.setQuota(r3)     // Catch:{ Exception -> 0x02ad }
            r3 = r5
        L_0x0065:
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            int r6 = r6.size()     // Catch:{ Exception -> 0x02ad }
            r7 = 1
            java.lang.String r8 = "WL"
            java.lang.String r9 = ""
            if (r3 >= r6) goto L_0x01c4
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.lang.Short r6 = r6.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            short r6 = r6.shortValue()     // Catch:{ Exception -> 0x02ad }
            int r6 = r6 - r7
            java.lang.Object r6 = r2.get(r6)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.lang.String r6 = r6.getPassengerCabinCoupe()     // Catch:{ Exception -> 0x02ad }
            if (r6 == r9) goto L_0x0114
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.lang.Short r6 = r6.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            short r6 = r6.shortValue()     // Catch:{ Exception -> 0x02ad }
            int r6 = r6 - r7
            java.lang.Object r6 = r2.get(r6)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.lang.String r6 = r6.getPassengerCabinCoupe()     // Catch:{ Exception -> 0x02ad }
            if (r6 != 0) goto L_0x00b3
            goto L_0x0114
        L_0x00b3:
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ad }
            r9.<init>()     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r10 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r10 = r10.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r10 = (cris.prs.webservices.dto.PassengerDetailDTO) r10     // Catch:{ Exception -> 0x02ad }
            java.lang.Short r10 = r10.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            short r10 = r10.shortValue()     // Catch:{ Exception -> 0x02ad }
            int r10 = r10 - r7
            java.lang.Object r10 = r2.get(r10)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r10 = (cris.prs.webservices.dto.PassengerDetailDTO) r10     // Catch:{ Exception -> 0x02ad }
            java.lang.String r10 = r10.getCurrentStatusDetails()     // Catch:{ Exception -> 0x02ad }
            r9.append(r10)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r10 = " ("
            r9.append(r10)     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r10 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r10 = r10.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r10 = (cris.prs.webservices.dto.PassengerDetailDTO) r10     // Catch:{ Exception -> 0x02ad }
            java.lang.Short r10 = r10.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            short r10 = r10.shortValue()     // Catch:{ Exception -> 0x02ad }
            int r10 = r10 - r7
            java.lang.Object r10 = r2.get(r10)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r10 = (cris.prs.webservices.dto.PassengerDetailDTO) r10     // Catch:{ Exception -> 0x02ad }
            java.lang.String r10 = r10.getPassengerCabinCoupe()     // Catch:{ Exception -> 0x02ad }
            r9.append(r10)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r10 = ")"
            r9.append(r10)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02ad }
            r6.setCurrentStatusDetails(r9)     // Catch:{ Exception -> 0x02ad }
            goto L_0x013e
        L_0x0114:
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r9 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r9 = r9.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r9 = (cris.prs.webservices.dto.PassengerDetailDTO) r9     // Catch:{ Exception -> 0x02ad }
            java.lang.Short r9 = r9.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            short r9 = r9.shortValue()     // Catch:{ Exception -> 0x02ad }
            int r9 = r9 - r7
            java.lang.Object r9 = r2.get(r9)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r9 = (cris.prs.webservices.dto.PassengerDetailDTO) r9     // Catch:{ Exception -> 0x02ad }
            java.lang.String r9 = r9.getCurrentStatusDetails()     // Catch:{ Exception -> 0x02ad }
            r6.setCurrentStatusDetails(r9)     // Catch:{ Exception -> 0x02ad }
        L_0x013e:
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r9 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r9 = r9.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r9 = (cris.prs.webservices.dto.PassengerDetailDTO) r9     // Catch:{ Exception -> 0x02ad }
            java.lang.Short r9 = r9.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            short r9 = r9.shortValue()     // Catch:{ Exception -> 0x02ad }
            int r9 = r9 - r7
            java.lang.Object r9 = r2.get(r9)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r9 = (cris.prs.webservices.dto.PassengerDetailDTO) r9     // Catch:{ Exception -> 0x02ad }
            short r9 = r9.getPsgnwlType()     // Catch:{ Exception -> 0x02ad }
            r6.setPsgnwlType(r9)     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.util.Date r9 = r13.getTimeStamp()     // Catch:{ Exception -> 0x02ad }
            java.lang.String r9 = defpackage.C0535I5.i(r9)     // Catch:{ Exception -> 0x02ad }
            r6.setPassengerCancellationDate(r9)     // Catch:{ Exception -> 0x02ad }
            java.text.SimpleDateFormat r6 = cris.org.in.ima.fragment.ErsDisplayFragment.d     // Catch:{ Exception -> 0x02ad }
            r1.getReservationId()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r2.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            r6.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r2.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            short r6 = r6.getCurrentBerthNo()     // Catch:{ Exception -> 0x02ad }
            java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r6 = r1.getPsgnDtlList()     // Catch:{ Exception -> 0x02ad }
            java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.lang.Short r6 = r6.getPassengerSerialNumber()     // Catch:{ Exception -> 0x02ad }
            short r6 = r6.shortValue()     // Catch:{ Exception -> 0x02ad }
            int r6 = r6 - r7
            java.lang.Object r6 = r2.get(r6)     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r6 = (cris.prs.webservices.dto.PassengerDetailDTO) r6     // Catch:{ Exception -> 0x02ad }
            java.lang.String r6 = r6.getCurrentStatusDetails()     // Catch:{ Exception -> 0x02ad }
            boolean r6 = r6.contains(r8)     // Catch:{ Exception -> 0x02ad }
            if (r6 == 0) goto L_0x01c0
            android.widget.LinearLayout r6 = r0.cnfBtnLayout     // Catch:{ Exception -> 0x02ad }
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x02ad }
        L_0x01c0:
            int r3 = r3 + 1
            goto L_0x0065
        L_0x01c4:
            java.lang.String r2 = r13.getTrainName()     // Catch:{ Exception -> 0x02ad }
            defpackage.C0535I5.f3631c = r2     // Catch:{ Exception -> 0x02ad }
            java.util.ArrayList r2 = r13.getPassengerList()     // Catch:{ Exception -> 0x02ad }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x02ad }
        L_0x01d2:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x02ad }
            if (r3 == 0) goto L_0x020b
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x02ad }
            cris.prs.webservices.dto.PassengerDetailDTO r3 = (cris.prs.webservices.dto.PassengerDetailDTO) r3     // Catch:{ Exception -> 0x02ad }
            java.lang.String r6 = r3.getCurrentStatus()     // Catch:{ Exception -> 0x02ad }
            boolean r6 = r6.contains(r8)     // Catch:{ Exception -> 0x02ad }
            if (r6 != 0) goto L_0x01f4
            java.lang.String r6 = r3.getCurrentStatus()     // Catch:{ Exception -> 0x02ad }
            java.lang.String r10 = "RAC"
            boolean r6 = r6.contains(r10)     // Catch:{ Exception -> 0x02ad }
            if (r6 == 0) goto L_0x01d2
        L_0x01f4:
            android.widget.LinearLayout r6 = r0.cnfBtnLayout     // Catch:{ Exception -> 0x02ad }
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x02ad }
            android.widget.TextView r6 = r0.pre     // Catch:{ Exception -> 0x02ad }
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x02ad }
            r0.f4578a = r3     // Catch:{ Exception -> 0x02ad }
            android.widget.TextView r3 = r0.pre     // Catch:{ Exception -> 0x02ad }
            cris.org.in.ima.fragment.I r6 = new cris.org.in.ima.fragment.I     // Catch:{ Exception -> 0x02ad }
            r6.<init>(r0, r13, r3)     // Catch:{ Exception -> 0x02ad }
            r3.setOnClickListener(r6)     // Catch:{ Exception -> 0x02ad }
            goto L_0x01d2
        L_0x020b:
            defpackage.C0535I5.f3652m = r7     // Catch:{ Exception -> 0x02ad }
            androidx.recyclerview.widget.RecyclerView r2 = r0.psgnList     // Catch:{ Exception -> 0x02ad }
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r2.getAdapter()     // Catch:{ Exception -> 0x02ad }
            r2.notifyDataSetChanged()     // Catch:{ Exception -> 0x02ad }
            java.lang.String r2 = r13.getTrainSiteId()     // Catch:{ Exception -> 0x02ad }
            r1.setServerId(r2)     // Catch:{ Exception -> 0x02ad }
            java.lang.String[] r1 = r13.getInformationMessage()     // Catch:{ Exception -> 0x02ad }
            if (r1 == 0) goto L_0x024d
            int r2 = r1.length     // Catch:{ Exception -> 0x02ad }
            r3 = r9
        L_0x0225:
            if (r5 >= r2) goto L_0x024e
            r6 = r1[r5]     // Catch:{ Exception -> 0x02ad }
            if (r6 == 0) goto L_0x024e
            java.lang.String r7 = r6.trim()     // Catch:{ Exception -> 0x02ad }
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x02ad }
            if (r7 == 0) goto L_0x0236
            goto L_0x024e
        L_0x0236:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ad }
            r7.<init>()     // Catch:{ Exception -> 0x02ad }
            r7.append(r3)     // Catch:{ Exception -> 0x02ad }
            r7.append(r6)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r3 = "\n"
            r7.append(r3)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x02ad }
            int r5 = r5 + 1
            goto L_0x0225
        L_0x024d:
            r3 = r9
        L_0x024e:
            java.lang.String r1 = r13.getTrainCancelStatus()     // Catch:{ Exception -> 0x02ad }
            if (r1 == 0) goto L_0x0271
            java.lang.String r1 = r13.getTrainCancelStatus()     // Catch:{ Exception -> 0x02ad }
            boolean r1 = r1.equals(r9)     // Catch:{ Exception -> 0x02ad }
            if (r1 != 0) goto L_0x0271
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ad }
            r1.<init>()     // Catch:{ Exception -> 0x02ad }
            r1.append(r3)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r13 = r13.getTrainCancelStatus()     // Catch:{ Exception -> 0x02ad }
            r1.append(r13)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x02ad }
        L_0x0271:
            java.text.SimpleDateFormat r13 = cris.org.in.ima.fragment.ErsDisplayFragment.d     // Catch:{ Exception -> 0x02ad }
            java.lang.String r13 = r3.trim()     // Catch:{ Exception -> 0x02ad }
            boolean r13 = r13.equals(r9)     // Catch:{ Exception -> 0x02ad }
            if (r13 != 0) goto L_0x02b3
            android.content.Context r13 = r0.f4569a     // Catch:{ Exception -> 0x02ad }
            java.lang.String r1 = r0.getString(r4)     // Catch:{ Exception -> 0x02ad }
            r2 = 0
            android.app.AlertDialog r13 = defpackage.C0535I5.o(r13, r3, r1, r2)     // Catch:{ Exception -> 0x02ad }
            r13.show()     // Catch:{ Exception -> 0x02ad }
            goto L_0x02b3
        L_0x028c:
            android.content.Context r1 = r0.f4569a     // Catch:{ Exception -> 0x02ad }
            r2 = 0
            r13 = 2131952145(0x7f130211, float:1.9540724E38)
            java.lang.String r3 = r0.getString(r13)     // Catch:{ Exception -> 0x02ad }
            r13 = 2131952688(0x7f130430, float:1.9541826E38)
            java.lang.String r13 = r0.getString(r13)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r5 = r0.getString(r4)     // Catch:{ Exception -> 0x02ad }
            r6 = 0
            r4 = r13
            android.app.AlertDialog r13 = defpackage.C0535I5.m(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x02ad }
            r13.show()     // Catch:{ Exception -> 0x02ad }
            goto L_0x02b3
        L_0x02ab:
            r13 = move-exception
            goto L_0x02b9
        L_0x02ad:
            r13 = move-exception
            java.text.SimpleDateFormat r1 = cris.org.in.ima.fragment.ErsDisplayFragment.d     // Catch:{ all -> 0x02ab }
            r13.getMessage()     // Catch:{ all -> 0x02ab }
        L_0x02b3:
            android.app.ProgressDialog r13 = r0.f4568a
            r13.dismiss()
            goto L_0x02bf
        L_0x02b9:
            android.app.ProgressDialog r0 = r0.f4568a
            r0.dismiss()
            throw r13
        L_0x02bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.J.onNext(java.lang.Object):void");
    }
}
