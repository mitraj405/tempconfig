package defpackage;

/* renamed from: F4  reason: default package */
/* compiled from: CaptchaQueResponseDTO */
public final class F4 {
    private long captchaGenTime;
    private String captchaQuestion;
    private String captchaToken;

    public long getCaptchaGenTime() {
        return this.captchaGenTime;
    }

    public String getCaptchaQuestion() {
        return this.captchaQuestion;
    }

    public String getCaptchaToken() {
        return this.captchaToken;
    }

    public void setCaptchaGenTime(long j) {
        this.captchaGenTime = j;
    }

    public void setCaptchaQuestion(String str) {
        this.captchaQuestion = str;
    }

    public void setCaptchaToken(String str) {
        this.captchaToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CaptchaQueResponseDTO [captchaQuestion=");
        sb.append(this.captchaQuestion);
        sb.append(", captchaToken=");
        sb.append(this.captchaToken);
        sb.append(", captchaGenTime=");
        return lf.l(sb, this.captchaGenTime, "]");
    }
}
