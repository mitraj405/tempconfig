package defpackage;

import cris.prs.webservices.dto.a;
import java.util.Arrays;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: z4  reason: default package and case insensitive filesystem */
/* compiled from: CancellationResponseDTO */
public final class C1510z4 extends a {
    private static final long serialVersionUID = 1;
    private String NoOfPsgn;
    private String addonBank;
    private Integer addonBookibgAmount;
    private Date addonCancelDate;
    private Long addonCancellationid;
    private Integer addonDeductAmount;
    private Integer addonRefundAmount;
    private String addonRefundStatus;
    private int addonServiceFlag = 0;
    private Integer amountCollected;
    private String canPsgnFare;
    private long cancellationChargeMetro;
    private String cancellationDate;
    private Long cancellationId;
    private String cancellationStatusEtCancel;
    private Date cancelledDate;
    private Integer cashCollected;
    private Integer cashDeducted;
    private String[] currentStatus;
    private long dmrcCanPsgnFare;
    private String dmrcCanStatus;
    private long dmrcCancellationId;
    private int dmrcErrorCode;
    private String dmrcErrorMessage;
    private int dmrcFlag;
    private String dmrcRefundBank;
    private String dmrcServiceid;
    private C1110fe gstChargeDTO;
    private Boolean gstFlag;
    private String message;
    private long metroBookingAmnt;
    private String[] name;
    private String pnrNo;
    private String prsCancelCharge;
    private Short[] psgnAmountDeducted;
    private Short[] psgnAmountRefunded;
    private long refundAmntMetro;
    private Integer refundAmount;
    private C0613Ns refundDetails;
    private String refundStatusEtCancel;
    private String serverId;
    private boolean success;
    private Date timeStamp;
    private int totalCanCountMetro;
    private float travelinsuranceRefundAmount;
    private String userNameForCancelTkt;

    public String getAddonBank() {
        return this.addonBank;
    }

    public Integer getAddonBookibgAmount() {
        return this.addonBookibgAmount;
    }

    public Date getAddonCancelDate() {
        return this.addonCancelDate;
    }

    public Long getAddonCancellationid() {
        return this.addonCancellationid;
    }

    public Integer getAddonDeductAmount() {
        return this.addonDeductAmount;
    }

    public Integer getAddonRefundAmount() {
        return this.addonRefundAmount;
    }

    public String getAddonRefundStatus() {
        return this.addonRefundStatus;
    }

    public int getAddonServiceFlag() {
        return this.addonServiceFlag;
    }

    public Integer getAmountCollected() {
        return this.amountCollected;
    }

    public String getCanPsgnFare() {
        return this.canPsgnFare;
    }

    public long getCancellationChargeMetro() {
        return this.cancellationChargeMetro;
    }

    public String getCancellationDate() {
        return this.cancellationDate;
    }

    public Long getCancellationId() {
        return this.cancellationId;
    }

    public String getCancellationStatusEtCancel() {
        return this.cancellationStatusEtCancel;
    }

    public Date getCancelledDate() {
        return this.cancelledDate;
    }

    public Integer getCashCollected() {
        return this.cashCollected;
    }

    public Integer getCashDeducted() {
        return this.cashDeducted;
    }

    public String[] getCurrentStatus() {
        return this.currentStatus;
    }

    public long getDmrcCanPsgnFare() {
        return this.dmrcCanPsgnFare;
    }

    public String getDmrcCanStatus() {
        return this.dmrcCanStatus;
    }

    public long getDmrcCancellationId() {
        return this.dmrcCancellationId;
    }

    public int getDmrcErrorCode() {
        return this.dmrcErrorCode;
    }

    public String getDmrcErrorMessage() {
        return this.dmrcErrorMessage;
    }

    public int getDmrcFlag() {
        return this.dmrcFlag;
    }

    public String getDmrcRefundBank() {
        return this.dmrcRefundBank;
    }

    public String getDmrcServiceid() {
        return this.dmrcServiceid;
    }

    public C1110fe getGstChargeDTO() {
        return this.gstChargeDTO;
    }

    public Boolean getGstFlag() {
        return this.gstFlag;
    }

    public String getMessage() {
        return this.message;
    }

    public long getMetroBookingAmnt() {
        return this.metroBookingAmnt;
    }

    public String[] getName() {
        return this.name;
    }

    public String getNoOfPsgn() {
        return this.NoOfPsgn;
    }

    public String getPnrNo() {
        return this.pnrNo;
    }

    public String getPrsCancelCharge() {
        return this.prsCancelCharge;
    }

    public Short[] getPsgnAmountDeducted() {
        return this.psgnAmountDeducted;
    }

    public Short[] getPsgnAmountRefunded() {
        return this.psgnAmountRefunded;
    }

    public long getRefundAmntMetro() {
        return this.refundAmntMetro;
    }

    public Integer getRefundAmount() {
        return this.refundAmount;
    }

    public C0613Ns getRefundDetails() {
        return this.refundDetails;
    }

    public String getRefundStatusEtCancel() {
        return this.refundStatusEtCancel;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public int getTotalCanCountMetro() {
        return this.totalCanCountMetro;
    }

    public float getTravelinsuranceRefundAmount() {
        return this.travelinsuranceRefundAmount;
    }

    public String getUserNameForCancelTkt() {
        return this.userNameForCancelTkt;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAddonBank(String str) {
        this.addonBank = str;
    }

    public void setAddonBookibgAmount(Integer num) {
        this.addonBookibgAmount = num;
    }

    public void setAddonCancelDate(Date date) {
        this.addonCancelDate = date;
    }

    public void setAddonCancellationid(Long l) {
        this.addonCancellationid = l;
    }

    public void setAddonDeductAmount(Integer num) {
        this.addonDeductAmount = num;
    }

    public void setAddonRefundAmount(Integer num) {
        this.addonRefundAmount = num;
    }

    public void setAddonRefundStatus(String str) {
        this.addonRefundStatus = str;
    }

    public void setAddonServiceFlag(int i) {
        this.addonServiceFlag = i;
    }

    public void setAmountCollected(Integer num) {
        this.amountCollected = num;
    }

    public void setCanPsgnFare(String str) {
        this.canPsgnFare = str;
    }

    public void setCancellationChargeMetro(long j) {
        this.cancellationChargeMetro = j;
    }

    public void setCancellationDate(String str) {
        this.cancellationDate = str;
    }

    public void setCancellationId(Long l) {
        this.cancellationId = l;
    }

    public void setCancellationStatusEtCancel(String str) {
        this.cancellationStatusEtCancel = str;
    }

    public void setCancelledDate(Date date) {
        this.cancelledDate = date;
    }

    public void setCashCollected(Integer num) {
        this.cashCollected = num;
    }

    public void setCashDeducted(Integer num) {
        this.cashDeducted = num;
    }

    public void setCurrentStatus(String[] strArr) {
        this.currentStatus = strArr;
    }

    public void setDmrcCanPsgnFare(long j) {
        this.dmrcCanPsgnFare = j;
    }

    public void setDmrcCanStatus(String str) {
        this.dmrcCanStatus = str;
    }

    public void setDmrcCancellationId(long j) {
        this.dmrcCancellationId = j;
    }

    public void setDmrcErrorCode(int i) {
        this.dmrcErrorCode = i;
    }

    public void setDmrcErrorMessage(String str) {
        this.dmrcErrorMessage = str;
    }

    public void setDmrcFlag(int i) {
        this.dmrcFlag = i;
    }

    public void setDmrcRefundBank(String str) {
        this.dmrcRefundBank = str;
    }

    public void setDmrcServiceid(String str) {
        this.dmrcServiceid = str;
    }

    public void setGstChargeDTO(C1110fe feVar) {
        this.gstChargeDTO = feVar;
    }

    public void setGstFlag(Boolean bool) {
        this.gstFlag = bool;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMetroBookingAmnt(long j) {
        this.metroBookingAmnt = j;
    }

    public void setName(String[] strArr) {
        this.name = strArr;
    }

    public void setNoOfPsgn(String str) {
        this.NoOfPsgn = str;
    }

    public void setPnrNo(String str) {
        this.pnrNo = str;
    }

    public void setPrsCancelCharge(String str) {
        this.prsCancelCharge = str;
    }

    public void setPsgnAmountDeducted(Short[] shArr) {
        this.psgnAmountDeducted = shArr;
    }

    public void setPsgnAmountRefunded(Short[] shArr) {
        this.psgnAmountRefunded = shArr;
    }

    public void setRefundAmntMetro(long j) {
        this.refundAmntMetro = j;
    }

    public void setRefundAmount(Integer num) {
        this.refundAmount = num;
    }

    public void setRefundDetails(C0613Ns ns) {
        this.refundDetails = ns;
    }

    public void setRefundStatusEtCancel(String str) {
        this.refundStatusEtCancel = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTotalCanCountMetro(int i) {
        this.totalCanCountMetro = i;
    }

    public void setTravelinsuranceRefundAmount(float f) {
        this.travelinsuranceRefundAmount = f;
    }

    public void setUserNameForCancelTkt(String str) {
        this.userNameForCancelTkt = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CancellationResponseDTO [success=");
        sb.append(this.success);
        sb.append(", refundAmount=");
        sb.append(this.refundAmount);
        sb.append(", pnrNo=");
        sb.append(this.pnrNo);
        sb.append(", amountCollected=");
        sb.append(this.amountCollected);
        sb.append(", cashDeducted=");
        sb.append(this.cashDeducted);
        sb.append(", cashCollected=");
        sb.append(this.cashCollected);
        sb.append(", cancelledDate=");
        sb.append(this.cancelledDate);
        sb.append(", name=");
        sb.append(Arrays.toString(this.name));
        sb.append(", currentStatus=");
        sb.append(Arrays.toString(this.currentStatus));
        sb.append(", psgnAmountDeducted=");
        sb.append(Arrays.toString(this.psgnAmountDeducted));
        sb.append(", psgnAmountRefunded=");
        sb.append(Arrays.toString(this.psgnAmountRefunded));
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", cancellationId=");
        sb.append(this.cancellationId);
        sb.append(", NoOfPsgn=");
        sb.append(this.NoOfPsgn);
        sb.append(", prsCancelCharge=");
        sb.append(this.prsCancelCharge);
        sb.append(", canPsgnFare=");
        sb.append(this.canPsgnFare);
        sb.append(", refundStatusEtCancel=");
        sb.append(this.refundStatusEtCancel);
        sb.append(", cancellationStatusEtCancel=");
        sb.append(this.cancellationStatusEtCancel);
        sb.append(", cancellationDate=");
        sb.append(this.cancellationDate);
        sb.append(", refundDetails=");
        sb.append(this.refundDetails);
        sb.append(", gstChargeDTO=");
        sb.append(this.gstChargeDTO);
        sb.append(", gstFlag=");
        sb.append(this.gstFlag);
        sb.append(", serverId=");
        sb.append(this.serverId);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", userNameForCancelTkt=");
        return C0709Uj.j(sb, this.userNameForCancelTkt, "]");
    }
}
