package androidx.constraintlayout.core;

import java.util.ArrayList;

public final class Metrics {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    public Metrics() {
        new ArrayList();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n*** Metrics ***\nmeasures: ");
        sb.append(this.a);
        sb.append("\nmeasuresWrap: 0\nmeasuresWrapInfeasible: 0\ndetermineGroups: 0\ninfeasibleDetermineGroups: 0\ngraphOptimizer: ");
        sb.append(this.c);
        sb.append("\nwidgets: ");
        sb.append(this.h);
        sb.append("\ngraphSolved: ");
        sb.append(this.d);
        sb.append("\nlinearSolved: ");
        return lf.l(sb, this.e, "\n");
    }
}
