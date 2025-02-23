package defpackage;

import cris.prs.webservices.dto.DmrcstatsionDto;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: p9  reason: default package and case insensitive filesystem */
/* compiled from: DmrcIrDTO */
public final class C1322p9 implements Serializable {
    private static final long serialVersionUID = 1;
    private String key;
    private List<DmrcstatsionDto> value;

    public String getKey() {
        return this.key;
    }

    public List<DmrcstatsionDto> getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(List<DmrcstatsionDto> list) {
        this.value = list;
    }
}
