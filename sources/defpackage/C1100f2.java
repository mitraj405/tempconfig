package defpackage;

import cris.prs.webservices.dto.AvlFareResponseDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: f2  reason: default package and case insensitive filesystem */
/* compiled from: AvlResponseDTO */
public final class C1100f2 implements Serializable {
    private static final long serialVersionUID = 1;
    private List<C1262mo> addOnsService;
    private C0812c0 addressDTO;
    private List<AvlFareResponseDTO> avlFareResponseDTO;
    private ArrayList<C1187j2> bankDetailDTO;
    private C1262mo bookingChoice;
    private E4 captchaDto;
    private String confirmation;
    private String errorMessage;
    private C1087eb ewalletDTO;
    private C1281nf itTicketDetailsDTO;
    private C0824ch juspayLoadDTO;
    private C1262mo paymentOption;
    private ArrayList<C1187j2> preferedBankDetailDTO;
    private Boolean reTry;
    private C1262mo secQ;
    private C1398sx softPaymentDTO;
    private List<C1398sx> softPaymentDTOs;
    private Double totalCollectibleAmount;
    private Boolean zeroFareBooking;

    public List<C1262mo> getAddOnsService() {
        return this.addOnsService;
    }

    public C0812c0 getAddressDTO() {
        return this.addressDTO;
    }

    public List<AvlFareResponseDTO> getAvlFareResponseDTO() {
        return this.avlFareResponseDTO;
    }

    public ArrayList<C1187j2> getBankDetailDTO() {
        return this.bankDetailDTO;
    }

    public C1262mo getBookingChoice() {
        return this.bookingChoice;
    }

    public E4 getCaptchaDto() {
        return this.captchaDto;
    }

    public String getConfirmation() {
        return this.confirmation;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public C1087eb getEwalletDTO() {
        return this.ewalletDTO;
    }

    public C1281nf getItTicketDetailsDTO() {
        return this.itTicketDetailsDTO;
    }

    public C0824ch getJuspayLoadDTO() {
        return this.juspayLoadDTO;
    }

    public C1262mo getPaymentOption() {
        return this.paymentOption;
    }

    public ArrayList<C1187j2> getPreferedBankDetailDTO() {
        return this.preferedBankDetailDTO;
    }

    public Boolean getReTry() {
        return this.reTry;
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

    public Double getTotalCollectibleAmount() {
        return this.totalCollectibleAmount;
    }

    public Boolean getZeroFareBooking() {
        return this.zeroFareBooking;
    }

    public void setAddOnsService(List<C1262mo> list) {
        this.addOnsService = list;
    }

    public void setAddressDTO(C0812c0 c0Var) {
        this.addressDTO = c0Var;
    }

    public void setAvlFareResponseDTO(List<AvlFareResponseDTO> list) {
        this.avlFareResponseDTO = list;
    }

    public void setBankDetailDTO(ArrayList<C1187j2> arrayList) {
        this.bankDetailDTO = arrayList;
    }

    public void setBookingChoice(C1262mo moVar) {
        this.bookingChoice = moVar;
    }

    public void setCaptchaDto(E4 e4) {
        this.captchaDto = e4;
    }

    public void setConfirmation(String str) {
        this.confirmation = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setEwalletDTO(C1087eb ebVar) {
        this.ewalletDTO = ebVar;
    }

    public void setItTicketDetailsDTO(C1281nf nfVar) {
        this.itTicketDetailsDTO = nfVar;
    }

    public void setJuspayLoadDTO(C0824ch chVar) {
        this.juspayLoadDTO = chVar;
    }

    public void setPaymentOption(C1262mo moVar) {
        this.paymentOption = moVar;
    }

    public void setPreferedBankDetailDTO(ArrayList<C1187j2> arrayList) {
        this.preferedBankDetailDTO = arrayList;
    }

    public void setReTry(Boolean bool) {
        this.reTry = bool;
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

    public void setTotalCollectibleAmount(Double d) {
        this.totalCollectibleAmount = d;
    }

    public void setZeroFareBooking(Boolean bool) {
        this.zeroFareBooking = bool;
    }

    public String toString() {
        return "AvlResponseDTO [avlFareResponseDTO=" + this.avlFareResponseDTO + ", totalCollectibleAmount=" + this.totalCollectibleAmount + ", bankDetailDTO=" + this.bankDetailDTO + ", preferedBankDetailDTO=" + this.preferedBankDetailDTO + ", ewalletDTO=" + this.ewalletDTO + ", captchaDto=" + this.captchaDto + ", softPaymentDTO=" + this.softPaymentDTO + ", softPaymentDTOs=" + this.softPaymentDTOs + ", itTicketDetailsDTO=" + this.itTicketDetailsDTO + ", addressDTO=" + this.addressDTO + ", zeroFareBooking=" + this.zeroFareBooking + ", secQ=" + this.secQ + ", errorMessage=" + this.errorMessage + ", reTry=" + this.reTry + ", paymentOption=" + this.paymentOption + ", bookingChoice=" + this.bookingChoice + ", confirmation=" + this.confirmation + ", juspayLoadDTO=" + this.juspayLoadDTO + "]";
    }
}
