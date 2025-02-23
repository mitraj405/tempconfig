package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Ie  reason: default package and case insensitive filesystem */
/* compiled from: GstApiResponseDTO */
public final class C0541Ie implements Serializable {
    private static final long serialVersionUID = 1;
    private a data;
    private Boolean error;
    private String message;

    /* renamed from: Ie$a */
    /* compiled from: GstApiResponseDTO */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;
        private String GSTIN;
        private Date canDate;
        private String cancellationDate;
        private String effectiveFrom;
        private Date effectiveFromDate;
        private String effectiveTo;
        private Date effectiveToDate;
        private String name;
        private Date regDate;
        private String registrationDate;
        private String type;
        private String valid;

        public Date getCanDate() {
            return this.canDate;
        }

        public String getCancellationDate() {
            return this.cancellationDate;
        }

        public String getEffectiveFrom() {
            return this.effectiveFrom;
        }

        public Date getEffectiveFromDate() {
            return this.effectiveFromDate;
        }

        public String getEffectiveTo() {
            return this.effectiveTo;
        }

        public Date getEffectiveToDate() {
            return this.effectiveToDate;
        }

        public String getGSTIN() {
            return this.GSTIN;
        }

        public String getName() {
            return this.name;
        }

        public Date getRegDate() {
            return this.regDate;
        }

        public String getRegistrationDate() {
            return this.registrationDate;
        }

        public String getType() {
            return this.type;
        }

        public String getValid() {
            return this.valid;
        }

        public void setCanDate(Date date) {
            this.canDate = date;
        }

        public void setCancellationDate(String str) {
            this.cancellationDate = str;
        }

        public void setEffectiveFrom(String str) {
            this.effectiveFrom = str;
        }

        public void setEffectiveFromDate(Date date) {
            this.effectiveFromDate = date;
        }

        public void setEffectiveTo(String str) {
            this.effectiveTo = str;
        }

        public void setEffectiveToDate(Date date) {
            this.effectiveToDate = date;
        }

        public void setGSTIN(String str) {
            this.GSTIN = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setRegDate(Date date) {
            this.regDate = date;
        }

        public void setRegistrationDate(String str) {
            this.registrationDate = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setValid(String str) {
            this.valid = str;
        }

        public String toString() {
            return "Data [GSTIN=" + this.GSTIN + ", name=" + this.name + ", valid=" + this.valid + ", effectiveFrom=" + this.effectiveFrom + ", effectiveTo=" + this.effectiveTo + ", type=" + this.type + ", cancellationDate=" + this.cancellationDate + ", registrationDate=" + this.registrationDate + ", effectiveFromDate=" + this.effectiveFromDate + ", effectiveToDate=" + this.effectiveToDate + ", canDate=" + this.canDate + ", regDate=" + this.regDate + "]";
        }
    }

    public a getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean isError() {
        return this.error;
    }

    public void setData(a aVar) {
        this.data = aVar;
    }

    public void setError(Boolean bool) {
        this.error = bool;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "GstApiResponseDTO [error=" + this.error + ", message=" + this.message + ", data=" + this.data + "]";
    }
}
