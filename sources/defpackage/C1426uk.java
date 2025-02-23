package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: uk  reason: default package and case insensitive filesystem */
/* compiled from: MasterPassangerDTO */
public final class C1426uk implements Serializable {
    private static final long serialVersionUID = 1;
    private String errorMessage;
    private Integer maxAllowedPsgn;
    private ArrayList<a> passengerDetailList = new ArrayList<>();
    private String serverId;
    private Date timeStamp;
    private String userName;

    /* renamed from: uk$a */
    /* compiled from: MasterPassangerDTO */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        private short age;
        private String berthPreference;
        private int concessionCode;
        private Date dateOfBirth;
        private Date dateValid;
        private String deleteMasterListId;
        private Date dobOnID;
        private String editMasterListId;
        private String foodPreference = C0515Ga.AVLBLTY_ONLY;
        private String gender = "M";
        private String idCardNumber;
        private String idCardType;
        private Long masterListId;
        private Long masterListUserId;
        private String masterPassengerName;
        private String name;
        private String railwayIsuedCardNo;
        private Integer slno;
        private String srCtznConc = C0515Ga.AVLBLTY_ONLY;
        private String strDOB;
        private String strDobOnID;
        private String uidErrorMessage;
        private String userType;
        private String validDate;
        private String verificationCode;
        private int verificationStatus = 0;
        private String verificationStatusString;

        public short getAge() {
            return this.age;
        }

        public String getBerthPreference() {
            return this.berthPreference;
        }

        public int getConcessionCode() {
            return this.concessionCode;
        }

        public Date getDateOfBirth() {
            return this.dateOfBirth;
        }

        public Date getDateValid() {
            return this.dateValid;
        }

        public String getDeleteMasterListId() {
            return this.deleteMasterListId;
        }

        public Date getDobOnID() {
            return this.dobOnID;
        }

        public String getEditMasterListId() {
            return this.editMasterListId;
        }

        public String getFoodPreference() {
            return this.foodPreference;
        }

        public String getGender() {
            return this.gender;
        }

        public String getIdCardNumber() {
            return this.idCardNumber;
        }

        public String getIdCardType() {
            return this.idCardType;
        }

        public Long getMasterListId() {
            return this.masterListId;
        }

        public Long getMasterListUserId() {
            return this.masterListUserId;
        }

        public String getMasterPassengerName() {
            return this.masterPassengerName;
        }

        public String getName() {
            return this.name;
        }

        public String getRailwayIsuedCardNo() {
            return this.railwayIsuedCardNo;
        }

        public Integer getSlno() {
            return this.slno;
        }

        public String getSrCtznConc() {
            return this.srCtznConc;
        }

        public String getStrDOB() {
            return this.strDOB;
        }

        public String getStrDobOnID() {
            return this.strDobOnID;
        }

        public String getUidErrorMessage() {
            return this.uidErrorMessage;
        }

        public String getUserType() {
            return this.userType;
        }

        public String getValidDate() {
            return this.validDate;
        }

        public String getVerificationCode() {
            return this.verificationCode;
        }

        public int getVerificationStatus() {
            return this.verificationStatus;
        }

        public String getVerificationStatusString() {
            return this.verificationStatusString;
        }

        public void setAge(short s) {
            this.age = s;
        }

        public void setBerthPreference(String str) {
            this.berthPreference = str;
        }

        public void setConcessionCode(int i) {
            this.concessionCode = i;
        }

        public void setDateOfBirth(Date date) {
            this.dateOfBirth = date;
        }

        public void setDateValid(Date date) {
            this.dateValid = date;
        }

        public void setDeleteMasterListId(String str) {
            this.deleteMasterListId = str;
        }

        public void setDobOnID(Date date) {
            this.dobOnID = date;
        }

        public void setEditMasterListId(String str) {
            this.editMasterListId = str;
        }

        public void setFoodPreference(String str) {
            this.foodPreference = str;
        }

        public void setGender(String str) {
            this.gender = str;
        }

        public void setIdCardNumber(String str) {
            this.idCardNumber = str;
        }

        public void setIdCardType(String str) {
            this.idCardType = str;
        }

        public void setMasterListId(Long l) {
            this.masterListId = l;
        }

        public void setMasterListUserId(Long l) {
            this.masterListUserId = l;
        }

        public void setMasterPassengerName(String str) {
            this.masterPassengerName = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setRailwayIsuedCardNo(String str) {
            this.railwayIsuedCardNo = str;
        }

        public void setSlno(Integer num) {
            this.slno = num;
        }

        public void setSrCtznConc(String str) {
            this.srCtznConc = str;
        }

        public void setStrDOB(String str) {
            this.strDOB = str;
        }

        public void setStrDobOnID(String str) {
            this.strDobOnID = str;
        }

        public void setUidErrorMessage(String str) {
            this.uidErrorMessage = str;
        }

        public void setUserType(String str) {
            this.userType = str;
        }

        public void setValidDate(String str) {
            this.validDate = str;
        }

        public void setVerificationCode(String str) {
            this.verificationCode = str;
        }

        public void setVerificationStatus(int i) {
            this.verificationStatus = i;
        }

        public void setVerificationStatusString(String str) {
            this.verificationStatusString = str;
        }
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Integer getMaxAllowedPsgn() {
        return this.maxAllowedPsgn;
    }

    public ArrayList<a> getPassengerDetailList() {
        return this.passengerDetailList;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setMaxAllowedPsgn(Integer num) {
        this.maxAllowedPsgn = num;
    }

    public void setPassengerDetailList(ArrayList<a> arrayList) {
        this.passengerDetailList = arrayList;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
