package defpackage;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: E4  reason: default package */
/* compiled from: CaptchaDTO */
public final class E4 implements Serializable {
    private static final long serialVersionUID = 1;
    private String aSQSTION;
    private String audioGenerated;
    private HashMap<String, Object> bufferMap;
    private Integer captcha;
    private String captchaQuestion;
    private Date captchaTime;
    private String captchaType;
    private String error;
    private String serverId;
    private String source;
    private String status;
    private Date timeStamp;

    public String getAudioGenerated() {
        return this.audioGenerated;
    }

    public HashMap<String, Object> getBufferMap() {
        return this.bufferMap;
    }

    public Integer getCaptcha() {
        return this.captcha;
    }

    public String getCaptchaQuestion() {
        return this.captchaQuestion;
    }

    public Date getCaptchaTime() {
        return this.captchaTime;
    }

    public String getCaptchaType() {
        return this.captchaType;
    }

    public String getError() {
        return this.error;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.status;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getaSQSTION() {
        return this.aSQSTION;
    }

    public void setAudioGenerated(String str) {
        this.audioGenerated = str;
    }

    public void setBufferMap(HashMap<String, Object> hashMap) {
        this.bufferMap = hashMap;
    }

    public void setCaptcha(Integer num) {
        this.captcha = num;
    }

    public void setCaptchaQuestion(String str) {
        this.captchaQuestion = str;
    }

    public void setCaptchaTime(Date date) {
        this.captchaTime = date;
    }

    public void setCaptchaType(String str) {
        this.captchaType = str;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setaSQSTION(String str) {
        this.aSQSTION = str;
    }

    public String toString() {
        return "CaptchaDTO [captchaType=" + this.captchaType + ", captchaQuestion=" + this.captchaQuestion + ", captchaTime=" + this.captchaTime + ", status=" + this.status + ", error=" + this.error + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", aSQSTION=" + this.aSQSTION + ", captcha=" + this.captcha + ", source=" + this.source + ", bufferMap=" + this.bufferMap + "]";
    }
}
