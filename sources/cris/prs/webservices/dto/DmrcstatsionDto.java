package cris.prs.webservices.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class DmrcstatsionDto implements Serializable {
    private static final long serialVersionUID = 1;
    private float distance;
    private int dmrclinecolorcode;
    private int dmrcstationindex;
    private String dmrcstationname;
    private String irstationcode;

    public float getDistance() {
        return this.distance;
    }

    public int getDmrclinecolorcode() {
        return this.dmrclinecolorcode;
    }

    public int getDmrcstationindex() {
        return this.dmrcstationindex;
    }

    public String getDmrcstationname() {
        return this.dmrcstationname;
    }

    public String getIrstationcode() {
        return this.irstationcode;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public void setDmrclinecolorcode(int i) {
        this.dmrclinecolorcode = i;
    }

    public void setDmrcstationindex(int i) {
        this.dmrcstationindex = i;
    }

    public void setDmrcstationname(String str) {
        this.dmrcstationname = str;
    }

    public void setIrstationcode(String str) {
        this.irstationcode = str;
    }

    public String toString() {
        return "DmrcstatsionDto [dmrcstationindex=" + this.dmrcstationindex + ", dmrcstationname=" + this.dmrcstationname + ", dmrclinecolorcode=" + this.dmrclinecolorcode + ", irstationcode=" + this.irstationcode + ", distance=" + this.distance + "]";
    }
}
