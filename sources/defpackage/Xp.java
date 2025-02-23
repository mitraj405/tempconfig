package defpackage;

import cris.prs.webservices.dto.PassengerDetailDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Xp  reason: default package */
/* compiled from: PostBookingServiceDTO */
public final class Xp implements Serializable {
    private static final long serialVersionUID = 1;
    private int noOfPsgnOptedService;
    private ArrayList<PassengerDetailDTO> passengerList;
    private int serviceId;

    public int getNoOfPsgnOptedService() {
        return this.noOfPsgnOptedService;
    }

    public ArrayList<PassengerDetailDTO> getPassengerList() {
        return this.passengerList;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public void setNoOfPsgnOptedService(int i) {
        this.noOfPsgnOptedService = i;
    }

    public void setPassengerList(ArrayList<PassengerDetailDTO> arrayList) {
        this.passengerList = arrayList;
    }

    public void setServiceId(int i) {
        this.serviceId = i;
    }
}
