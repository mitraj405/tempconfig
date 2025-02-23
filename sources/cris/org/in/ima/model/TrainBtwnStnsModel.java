package cris.org.in.ima.model;

import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.io.Serializable;
import java.util.ArrayList;

public final class TrainBtwnStnsModel implements Serializable {
    public AvlFareResponseDTO a;

    /* renamed from: a  reason: collision with other field name */
    public final TrainBtwnStnsDTO f5342a;

    /* renamed from: a  reason: collision with other field name */
    public C1060d2 f5343a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f5344a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f5345a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f5346a;
    public final Boolean b;

    /* renamed from: b  reason: collision with other field name */
    public Integer f5347b;
    public Boolean c;

    /* renamed from: c  reason: collision with other field name */
    public String f5348c = "";
    public String d = "GN";
    public String e;
    public String f;

    public TrainBtwnStnsModel(TrainBtwnStnsDTO trainBtwnStnsDTO) {
        Boolean bool = Boolean.FALSE;
        this.b = bool;
        this.f5344a = bool;
        this.b = bool;
        this.c = bool;
        this.f5342a = trainBtwnStnsDTO;
        this.a = null;
        this.f5346a = new ArrayList();
        if (trainBtwnStnsDTO.getAvlClasses() != null) {
            int size = trainBtwnStnsDTO.getAvlClasses().size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                this.f5346a.add(new AvlClassModel(trainBtwnStnsDTO.getAvlClasses().get(size)));
            }
        }
        this.f5348c = null;
        this.f5343a = null;
        this.d = "GN";
    }

    public final C1060d2 a() {
        return this.f5343a;
    }

    public final String b() {
        return this.f5348c;
    }

    public final String c() {
        return this.d;
    }

    public final TrainBtwnStnsDTO d() {
        return this.f5342a;
    }

    public final Integer e() {
        return this.f5345a;
    }

    public TrainBtwnStnsModel() {
        Boolean bool = Boolean.FALSE;
        this.f5344a = bool;
        this.b = bool;
        this.c = bool;
    }
}
