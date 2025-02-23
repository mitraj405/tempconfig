package defpackage;

import java.io.Serializable;

/* renamed from: tl  reason: default package and case insensitive filesystem */
/* compiled from: MobileAppConfigDTO */
public final class C1408tl implements Serializable {
    private static final long serialVersionUID = 1;
    private Integer captchaFillCheckEndTime;
    private Integer captchaFillCheckStartTime;
    private Integer formFillCheckEnable;
    private Integer formFillCheckEndTime;
    private Integer formFillCheckStartTime;
    private boolean gstEnable;
    private Integer minmCaptchaInputTime;
    private Integer minmPaymentTime;
    private String minmPsgnInputTime;
    private Integer paymentCompletCheckEnable;

    public Integer getCaptchaFillCheckEndTime() {
        return this.captchaFillCheckEndTime;
    }

    public Integer getCaptchaFillCheckStartTime() {
        return this.captchaFillCheckStartTime;
    }

    public Integer getFormFillCheckEnable() {
        return this.formFillCheckEnable;
    }

    public Integer getFormFillCheckEndTime() {
        return this.formFillCheckEndTime;
    }

    public Integer getFormFillCheckStartTime() {
        return this.formFillCheckStartTime;
    }

    public Integer getMinmCaptchaInputTime() {
        return this.minmCaptchaInputTime;
    }

    public Integer getMinmPaymentTime() {
        return this.minmPaymentTime;
    }

    public String getMinmPsgnInputTime() {
        return this.minmPsgnInputTime;
    }

    public Integer getPaymentCompletCheckEnable() {
        return this.paymentCompletCheckEnable;
    }

    public boolean isGstEnable() {
        return this.gstEnable;
    }

    public void setCaptchaFillCheckEndTime(Integer num) {
        this.captchaFillCheckEndTime = num;
    }

    public void setCaptchaFillCheckStartTime(Integer num) {
        this.captchaFillCheckStartTime = num;
    }

    public void setFormFillCheckEnable(Integer num) {
        this.formFillCheckEnable = num;
    }

    public void setFormFillCheckEndTime(Integer num) {
        this.formFillCheckEndTime = num;
    }

    public void setFormFillCheckStartTime(Integer num) {
        this.formFillCheckStartTime = num;
    }

    public void setGstEnable(boolean z) {
        this.gstEnable = z;
    }

    public void setMinmCaptchaInputTime(Integer num) {
        this.minmCaptchaInputTime = num;
    }

    public void setMinmPaymentTime(Integer num) {
        this.minmPaymentTime = num;
    }

    public void setMinmPsgnInputTime(String str) {
        this.minmPsgnInputTime = str;
    }

    public void setPaymentCompletCheckEnable(Integer num) {
        this.paymentCompletCheckEnable = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MobileAppConfigDTO [formFillCheckStartTime=");
        sb.append(this.formFillCheckStartTime);
        sb.append(", formFillCheckEndTime=");
        sb.append(this.formFillCheckEndTime);
        sb.append(", captchaFillCheckStartTime=");
        sb.append(this.captchaFillCheckStartTime);
        sb.append(", captchaFillCheckEndTime=");
        sb.append(this.captchaFillCheckEndTime);
        sb.append(", minmPsgnInputTime=");
        sb.append(this.minmPsgnInputTime);
        sb.append(", minmCaptchaInputTime=");
        sb.append(this.minmCaptchaInputTime);
        sb.append(", minmPaymentTime=");
        sb.append(this.minmPaymentTime);
        sb.append(", formFillCheckEnable=");
        sb.append(this.formFillCheckEnable);
        sb.append(", paymentCompletCheckEnable=");
        sb.append(this.paymentCompletCheckEnable);
        sb.append(", gstEnable=");
        return xx.G(sb, this.gstEnable, "]");
    }
}
