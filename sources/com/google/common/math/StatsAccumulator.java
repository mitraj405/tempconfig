package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public final class StatsAccumulator {
    private long count = 0;
    private double max = Double.NaN;
    private double mean = 0.0d;
    private double min = Double.NaN;
    private double sumOfSquaresOfDeltas = 0.0d;

    public static double calculateNewMeanNonFinite(double d, double d2) {
        if (Doubles.isFinite(d)) {
            return d2;
        }
        if (Doubles.isFinite(d2) || d == d2) {
            return d;
        }
        return Double.NaN;
    }

    private void merge(long j, double d, double d2, double d3, double d4) {
        long j2 = j;
        double d5 = d;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        long j3 = this.count;
        if (j3 == 0) {
            this.count = j2;
            this.mean = d5;
            this.sumOfSquaresOfDeltas = d6;
            this.min = d7;
            this.max = d8;
            return;
        }
        this.count = j3 + j2;
        if (!Doubles.isFinite(this.mean) || !Doubles.isFinite(d)) {
            this.mean = calculateNewMeanNonFinite(this.mean, d5);
            this.sumOfSquaresOfDeltas = Double.NaN;
        } else {
            double d9 = this.mean;
            double d10 = d5 - d9;
            double d11 = (double) j2;
            double d12 = ((d10 * d11) / ((double) this.count)) + d9;
            this.mean = d12;
            this.sumOfSquaresOfDeltas = ((d5 - d12) * d10 * d11) + d6 + this.sumOfSquaresOfDeltas;
        }
        this.min = Math.min(this.min, d7);
        this.max = Math.max(this.max, d4);
    }

    public void add(double d) {
        long j = this.count;
        if (j == 0) {
            this.count = 1;
            this.mean = d;
            this.min = d;
            this.max = d;
            if (!Doubles.isFinite(d)) {
                this.sumOfSquaresOfDeltas = Double.NaN;
                return;
            }
            return;
        }
        this.count = j + 1;
        if (!Doubles.isFinite(d) || !Doubles.isFinite(this.mean)) {
            this.mean = calculateNewMeanNonFinite(this.mean, d);
            this.sumOfSquaresOfDeltas = Double.NaN;
        } else {
            double d2 = this.mean;
            double d3 = d - d2;
            double d4 = (d3 / ((double) this.count)) + d2;
            this.mean = d4;
            this.sumOfSquaresOfDeltas = ((d - d4) * d3) + this.sumOfSquaresOfDeltas;
        }
        this.min = Math.min(this.min, d);
        this.max = Math.max(this.max, d);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        for (Number doubleValue : iterable) {
            add(doubleValue.doubleValue());
        }
    }

    public long count() {
        return this.count;
    }

    public double max() {
        boolean z;
        if (this.count != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.max;
    }

    public double mean() {
        boolean z;
        if (this.count != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.mean;
    }

    public double min() {
        boolean z;
        if (this.count != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return this.min;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        boolean z;
        if (this.count != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) this.count);
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        boolean z;
        if (this.count > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) (this.count - 1));
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        return this.mean * ((double) this.count);
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(((Number) it.next()).doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double add : dArr) {
            add(add);
        }
    }

    public void addAll(int... iArr) {
        for (int i : iArr) {
            add((double) i);
        }
    }

    public void addAll(long... jArr) {
        for (long j : jArr) {
            add((double) j);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() != 0) {
            merge(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
        }
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() != 0) {
            merge(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.sumOfSquaresOfDeltas(), statsAccumulator.min(), statsAccumulator.max());
        }
    }
}
