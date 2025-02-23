package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Do  reason: default package */
/* compiled from: ParameterDto */
public final class Do implements Serializable {
    private static final long serialVersionUID = 1;
    private String key;
    private String value;

    public Do() {
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ParameterDto [key=");
        sb.append(this.key);
        sb.append(", value=");
        return C0709Uj.j(sb, this.value, "]");
    }

    public Do(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
