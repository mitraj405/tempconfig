package cris.prs.webservices.dto;

import java.util.List;

public final class ClassAvlDTO extends C0693Tb {
    private static final long serialVersionUID = 1;
    private List<C1060d2> avlDayList;
    private boolean avlFound;
    private String errorMessage;
    private List<InformationMessageDTO> informationMessage;
    private String lastUpdateTime;

    public List<C1060d2> getAvlDayList() {
        return this.avlDayList;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<InformationMessageDTO> getInformationMessage() {
        return this.informationMessage;
    }

    public String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public boolean isAvlFound() {
        return this.avlFound;
    }

    public void setAvlDayList(List<C1060d2> list) {
        this.avlDayList = list;
    }

    public void setAvlFound(boolean z) {
        this.avlFound = z;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setInformationMessage(List<InformationMessageDTO> list) {
        this.informationMessage = list;
    }

    public void setLastUpdateTime(String str) {
        this.lastUpdateTime = str;
    }
}
