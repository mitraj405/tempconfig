package defpackage;

import cris.prs.webservices.dto.DmrcstatsionDto;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: U7  reason: default package */
/* compiled from: DMRCStationData */
public final class U7 implements Serializable {
    private static final long serialVersionUID = 1;
    private List<C1322p9> dmrcIrStations;
    private List<DmrcstatsionDto> dmrcStations;
    private String error;

    public List<C1322p9> getDmrcIrStations() {
        return this.dmrcIrStations;
    }

    public List<DmrcstatsionDto> getDmrcStations() {
        return this.dmrcStations;
    }

    public String getError() {
        return this.error;
    }

    public void setDmrcIrStations(List<C1322p9> list) {
        this.dmrcIrStations = list;
    }

    public void setDmrcStations(List<DmrcstatsionDto> list) {
        this.dmrcStations = list;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DMRCStationData [dmrcStations=");
        sb.append(this.dmrcStations);
        sb.append(", dmrcIrStations=");
        sb.append(this.dmrcIrStations);
        sb.append(", error=");
        return C0709Uj.j(sb, this.error, "]");
    }
}
