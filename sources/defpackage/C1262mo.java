package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: mo  reason: default package and case insensitive filesystem */
/* compiled from: OptionDTO */
public final class C1262mo implements Serializable {
    private static final long serialVersionUID = 1;
    private Short defaultValue = 1;
    private String header;
    private List<a> options = new ArrayList();
    private String type;

    /* renamed from: mo$a */
    /* compiled from: OptionDTO */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;
        private String desc;
        private String label;
        private String sValue;
        private Short value;

        public String getDesc() {
            return this.desc;
        }

        public String getLabel() {
            return this.label;
        }

        public Short getValue() {
            return this.value;
        }

        public String getsValue() {
            return this.sValue;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public void setValue(Short sh) {
            this.value = sh;
        }

        public void setsValue(String str) {
            this.sValue = str;
        }
    }

    public Short getDefaultValue() {
        return this.defaultValue;
    }

    public String getHeader() {
        return this.header;
    }

    public List<a> getOptions() {
        return this.options;
    }

    public String getType() {
        return this.type;
    }

    public void setDefaultValue(Short sh) {
        this.defaultValue = sh;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public void setOptions(List<a> list) {
        this.options = list;
    }

    public void setType(String str) {
        this.type = str;
    }
}
