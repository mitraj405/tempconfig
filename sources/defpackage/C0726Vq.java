package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Vq  reason: default package and case insensitive filesystem */
/* compiled from: QuestionDTO */
public final class C0726Vq implements Serializable {
    private static final long serialVersionUID = 1;
    private String errorMsg;
    private ArrayList<a> levelDetail = new ArrayList<>();
    private String serverId;
    private Date timeStamp;

    /* renamed from: Vq$a */
    /* compiled from: QuestionDTO */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        private String levelId;
        private String levelName;

        public String getLevelId() {
            return this.levelId;
        }

        public String getLevelName() {
            return this.levelName;
        }

        public void setLevelId(String str) {
            this.levelId = str;
        }

        public void setLevelName(String str) {
            this.levelName = str;
        }
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public ArrayList<a> getLevelDetail() {
        return this.levelDetail;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setLevelDetail(ArrayList<a> arrayList) {
        this.levelDetail = arrayList;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }
}
