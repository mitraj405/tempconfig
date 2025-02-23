package cris.prs.webservices.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class AvlFareResponseDTO extends C0693Tb {
    private static final long serialVersionUID = 1;
    private String accountLink;
    private C0812c0 addressDTO;
    private Boolean altAvlEnabled;
    private Boolean altClsEnabled;
    private Boolean altTrainEnabled;
    private ArrayList<C1060d2> avlDayList;
    private ArrayList<C1187j2> bankDetailDTO;
    private C0794b3 bkgCfg;
    private E4 captchaDto;
    private String confirmation;
    private C1087eb ewalletDTO;
    private Boolean ftBookingMsgFlag;
    private ArrayList<InformationMessageDTO> informationMessage;
    private C1281nf itTicketDetailsDTO;
    private C0824ch juspayLoadDTO;
    private String lastUpdateTime;
    private ArrayList<C1187j2> preferedBankDetailDTO;
    private ArrayList<PassengerDetailDTO> psgnDtlList;
    private ArrayList<Object> pymtOptionList;
    private Boolean rdsTxnPwdFlag;
    private Boolean reTry;
    private Integer retryAfterTime;
    private Integer retryCount;
    private C1262mo secQ;
    private C1398sx softPaymentDTO;
    private List<C1398sx> softPaymentDTOs;
    private Boolean taRdsFlag;
    private Double totalCollectibleAmount;
    private String trainsiteId;
    private Boolean upiRdsFlag;
    private Boolean zeroFareBooking;

    public AvlFareResponseDTO() {
        Boolean bool = Boolean.FALSE;
        this.taRdsFlag = bool;
        this.upiRdsFlag = bool;
        this.rdsTxnPwdFlag = bool;
        this.ftBookingMsgFlag = bool;
    }

    public String getAccountLink() {
        return this.accountLink;
    }

    public C0812c0 getAddressDTO() {
        return this.addressDTO;
    }

    public Boolean getAltAvlEnabled() {
        return this.altAvlEnabled;
    }

    public Boolean getAltClsEnabled() {
        return this.altClsEnabled;
    }

    public Boolean getAltTrainEnabled() {
        return this.altTrainEnabled;
    }

    public ArrayList<C1060d2> getAvlDayList() {
        return this.avlDayList;
    }

    public ArrayList<C1187j2> getBankDetailDTO() {
        return this.bankDetailDTO;
    }

    public C0794b3 getBkgCfg() {
        return this.bkgCfg;
    }

    public E4 getCaptchaDto() {
        return this.captchaDto;
    }

    public String getConfirmation() {
        return this.confirmation;
    }

    public C1087eb getEwalletDTO() {
        return this.ewalletDTO;
    }

    public Boolean getFtBookingMsgFlag() {
        return this.ftBookingMsgFlag;
    }

    public ArrayList<InformationMessageDTO> getInformationMessage() {
        return this.informationMessage;
    }

    public C1281nf getItTicketDetailsDTO() {
        return this.itTicketDetailsDTO;
    }

    public C0824ch getJuspayLoadDTO() {
        return this.juspayLoadDTO;
    }

    public String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public ArrayList<C1187j2> getPreferedBankDetailDTO() {
        return this.preferedBankDetailDTO;
    }

    public ArrayList<PassengerDetailDTO> getPsgnDtlList() {
        return this.psgnDtlList;
    }

    public ArrayList<Object> getPymtOptionList() {
        return this.pymtOptionList;
    }

    public Boolean getRdsTxnPwdFlag() {
        return this.rdsTxnPwdFlag;
    }

    public Boolean getReTry() {
        return this.reTry;
    }

    public Integer getRetryAfterTime() {
        return this.retryAfterTime;
    }

    public Integer getRetryCount() {
        return this.retryCount;
    }

    public C1262mo getSecQ() {
        return this.secQ;
    }

    public C1398sx getSoftPaymentDTO() {
        return this.softPaymentDTO;
    }

    public List<C1398sx> getSoftPaymentDTOs() {
        return this.softPaymentDTOs;
    }

    public Boolean getTaRdsFlag() {
        return this.taRdsFlag;
    }

    public Double getTotalCollectibleAmount() {
        return this.totalCollectibleAmount;
    }

    public String getTrainsiteId() {
        return this.trainsiteId;
    }

    public Boolean getUpiRdsFlag() {
        return this.upiRdsFlag;
    }

    public Boolean getZeroFareBooking() {
        return this.zeroFareBooking;
    }

    public void setAccountLink(String str) {
        this.accountLink = str;
    }

    public void setAddressDTO(C0812c0 c0Var) {
        this.addressDTO = c0Var;
    }

    public void setAltAvlEnabled(Boolean bool) {
        this.altAvlEnabled = bool;
    }

    public void setAltClsEnabled(Boolean bool) {
        this.altClsEnabled = bool;
    }

    public void setAltTrainEnabled(Boolean bool) {
        this.altTrainEnabled = bool;
    }

    public void setAvlDayList(ArrayList<C1060d2> arrayList) {
        this.avlDayList = arrayList;
    }

    public void setBankDetailDTO(ArrayList<C1187j2> arrayList) {
        this.bankDetailDTO = arrayList;
    }

    public void setBkgCfg(C0794b3 b3Var) {
        this.bkgCfg = b3Var;
    }

    public void setCaptchaDto(E4 e4) {
        this.captchaDto = e4;
    }

    public void setConfirmation(String str) {
        this.confirmation = str;
    }

    public void setEwalletDTO(C1087eb ebVar) {
        this.ewalletDTO = ebVar;
    }

    public void setFtBookingMsgFlag(Boolean bool) {
        this.ftBookingMsgFlag = bool;
    }

    public void setInformationMessage(ArrayList<InformationMessageDTO> arrayList) {
        this.informationMessage = arrayList;
    }

    public void setItTicketDetailsDTO(C1281nf nfVar) {
        this.itTicketDetailsDTO = nfVar;
    }

    public void setJuspayLoadDTO(C0824ch chVar) {
        this.juspayLoadDTO = chVar;
    }

    public void setLastUpdateTime(String str) {
        this.lastUpdateTime = str;
    }

    public void setPreferedBankDetailDTO(ArrayList<C1187j2> arrayList) {
        this.preferedBankDetailDTO = arrayList;
    }

    public void setPsgnDtlList(ArrayList<PassengerDetailDTO> arrayList) {
        this.psgnDtlList = arrayList;
    }

    public void setPymtOptionList(ArrayList<Object> arrayList) {
        this.pymtOptionList = arrayList;
    }

    public void setRdsTxnPwdFlag(Boolean bool) {
        this.rdsTxnPwdFlag = bool;
    }

    public void setReTry(Boolean bool) {
        this.reTry = bool;
    }

    public void setRetryAfterTime(Integer num) {
        this.retryAfterTime = num;
    }

    public void setRetryCount(Integer num) {
        this.retryCount = num;
    }

    public void setSecQ(C1262mo moVar) {
        this.secQ = moVar;
    }

    public void setSoftPaymentDTO(C1398sx sxVar) {
        this.softPaymentDTO = sxVar;
    }

    public void setSoftPaymentDTOs(List<C1398sx> list) {
        this.softPaymentDTOs = list;
    }

    public void setTaRdsFlag(Boolean bool) {
        this.taRdsFlag = bool;
    }

    public void setTotalCollectibleAmount(Double d) {
        this.totalCollectibleAmount = d;
    }

    public void setTrainsiteId(String str) {
        this.trainsiteId = str;
    }

    public void setUpiRdsFlag(Boolean bool) {
        this.upiRdsFlag = bool;
    }

    public void setZeroFareBooking(Boolean bool) {
        this.zeroFareBooking = bool;
    }

    public String toString() {
        return "AvlFareResponseDTO [totalCollectibleAmount=" + this.totalCollectibleAmount + ", bkgCfg=" + this.bkgCfg + ", avlDayList=" + this.avlDayList + ", bankDetailDTO=" + this.bankDetailDTO + ", preferedBankDetailDTO=" + this.preferedBankDetailDTO + ", ewalletDTO=" + this.ewalletDTO + ", captchaDto=" + this.captchaDto + ", softPaymentDTO=" + this.softPaymentDTO + ", softPaymentDTOs=" + this.softPaymentDTOs + ", informationMessage=" + this.informationMessage + ", reTry=" + this.reTry + ", retryAfterTime=" + this.retryAfterTime + ", retryCount=" + this.retryCount + ", itTicketDetailsDTO=" + this.itTicketDetailsDTO + ", addressDTO=" + this.addressDTO + ", altAvlEnabled=" + this.altAvlEnabled + ", altTrainEnabled=" + this.altTrainEnabled + ", altClsEnabled=" + this.altClsEnabled + ", accountLink=" + this.accountLink + ", zeroFareBooking=" + this.zeroFareBooking + ", taRdsFlag=" + this.taRdsFlag + ", upiRdsFlag=" + this.upiRdsFlag + ", rdsTxnPwdFlag=" + this.rdsTxnPwdFlag + ", ftBookingMsgFlag=" + this.ftBookingMsgFlag + ", secQ=" + this.secQ + ", lastUpdateTime=" + this.lastUpdateTime + ", trainsiteId=" + this.trainsiteId + ", psgnDtlList=" + this.psgnDtlList + ", juspayLoadDTO=" + this.juspayLoadDTO + ", confirmation=" + this.confirmation + ", pymtOptionList=" + this.pymtOptionList + "]";
    }
}
