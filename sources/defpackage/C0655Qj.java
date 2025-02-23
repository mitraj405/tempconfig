package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Qj  reason: default package and case insensitive filesystem */
/* compiled from: LoyaltyTxnDetailsDTO */
public final class C0655Qj implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<C1377rx> accrualBookings;
    private ArrayList<C1377rx> partnerTxns;
    private ArrayList<C1377rx> purchasePoints;
    private ArrayList<C1377rx> redemptionBookings;

    public ArrayList<C1377rx> getAccrualBookings() {
        return this.accrualBookings;
    }

    public ArrayList<C1377rx> getPartnerTxns() {
        return this.partnerTxns;
    }

    public ArrayList<C1377rx> getPurchasePoints() {
        return this.purchasePoints;
    }

    public ArrayList<C1377rx> getRedemptionBookings() {
        return this.redemptionBookings;
    }

    public void setAccrualBookings(ArrayList<C1377rx> arrayList) {
        this.accrualBookings = arrayList;
    }

    public void setPartnerTxns(ArrayList<C1377rx> arrayList) {
        this.partnerTxns = arrayList;
    }

    public void setPurchasePoints(ArrayList<C1377rx> arrayList) {
        this.purchasePoints = arrayList;
    }

    public void setRedemptionBookings(ArrayList<C1377rx> arrayList) {
        this.redemptionBookings = arrayList;
    }

    public String toString() {
        return "LoyaltyTxnDetailsDTO [accrualBookings=" + this.accrualBookings + ", redemptionBookings=" + this.redemptionBookings + ", purchasePoints=" + this.purchasePoints + ", partnerTxns=" + this.partnerTxns + "]";
    }
}
