package defpackage;

import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: wA  reason: default package and case insensitive filesystem */
/* compiled from: TrainBtwnStnsModelList */
public final class C1455wA implements Serializable {
    private static final long serialVersionUID = 1;
    private List<TrainBtwnStnsModel> alternateTrainBtwnStnsList;
    private List<String> quotaList;
    private List<TrainBtwnStnsModel> trainBtwnStnsList;
    private TrainBtwnStnsRespDto trainBtwnStnsRespDto;

    public C1455wA(TrainBtwnStnsRespDto trainBtwnStnsRespDto2) {
        this.trainBtwnStnsRespDto = trainBtwnStnsRespDto2;
        if (trainBtwnStnsRespDto2.getTrainBtwnStnsList() != null) {
            this.trainBtwnStnsList = new ArrayList();
            for (TrainBtwnStnsDTO trainBtwnStnsModel : trainBtwnStnsRespDto2.getTrainBtwnStnsList()) {
                this.trainBtwnStnsList.add(new TrainBtwnStnsModel(trainBtwnStnsModel));
            }
        }
        if (trainBtwnStnsRespDto2.getAlternateTrainBtwnStnsList() != null) {
            this.alternateTrainBtwnStnsList = new ArrayList();
            for (TrainBtwnStnsDTO trainBtwnStnsModel2 : trainBtwnStnsRespDto2.getAlternateTrainBtwnStnsList()) {
                this.alternateTrainBtwnStnsList.add(new TrainBtwnStnsModel(trainBtwnStnsModel2));
            }
        }
        this.quotaList = trainBtwnStnsRespDto2.getQuotaList();
    }

    public List<TrainBtwnStnsModel> getAlternateTrainBtwnStnsList() {
        return this.alternateTrainBtwnStnsList;
    }

    public List<String> getQuotaList() {
        return this.quotaList;
    }

    public List<TrainBtwnStnsModel> getTrainBtwnStnsList() {
        return this.trainBtwnStnsList;
    }

    public TrainBtwnStnsRespDto getTrainBtwnStnsRespDto() {
        return this.trainBtwnStnsRespDto;
    }

    public void setAlternateTrainBtwnStnsList(List<TrainBtwnStnsModel> list) {
        this.alternateTrainBtwnStnsList = list;
    }

    public void setQuotaList(List<String> list) {
        this.quotaList = list;
    }

    public void setTrainBtwnStnsList(List<TrainBtwnStnsModel> list) {
        this.trainBtwnStnsList = list;
    }

    public void setTrainBtwnStnsRespDto(TrainBtwnStnsRespDto trainBtwnStnsRespDto2) {
        this.trainBtwnStnsRespDto = trainBtwnStnsRespDto2;
    }
}
