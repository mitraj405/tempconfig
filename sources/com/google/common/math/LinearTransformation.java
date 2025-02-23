package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {
        private final double x1;
        private final double y1;

        public LinearTransformation and(double d, double d2) {
            boolean z;
            boolean z2 = true;
            if (!DoubleUtils.isFinite(d) || !DoubleUtils.isFinite(d2)) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z);
            double d3 = this.x1;
            if (d != d3) {
                return withSlope((d2 - this.y1) / (d - d3));
            }
            if (d2 == this.y1) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            return new VerticalLinearTransformation(this.x1);
        }

        public LinearTransformation withSlope(double d) {
            Preconditions.checkArgument(!Double.isNaN(d));
            if (DoubleUtils.isFinite(d)) {
                return new RegularLinearTransformation(d, this.y1 - (this.x1 * d));
            }
            return new VerticalLinearTransformation(this.x1);
        }

        private LinearTransformationBuilder(double d, double d2) {
            this.x1 = d;
            this.y1 = d2;
        }
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    public static LinearTransformation horizontal(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new RegularLinearTransformation(0.0d, d);
    }

    public static LinearTransformationBuilder mapping(double d, double d2) {
        boolean z;
        if (!DoubleUtils.isFinite(d) || !DoubleUtils.isFinite(d2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        return new LinearTransformationBuilder(d, d2);
    }

    public static LinearTransformation vertical(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new VerticalLinearTransformation(d);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d);

    public static final class VerticalLinearTransformation extends LinearTransformation {
        @LazyInit
        LinearTransformation inverse;
        final double x;

        public VerticalLinearTransformation(double d) {
            this.x = d;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.x, this);
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return true;
        }

        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.x)});
        }

        public double transform(double d) {
            throw new IllegalStateException();
        }

        public VerticalLinearTransformation(double d, LinearTransformation linearTransformation) {
            this.x = d;
            this.inverse = linearTransformation;
        }
    }

    public static final class RegularLinearTransformation extends LinearTransformation {
        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        public RegularLinearTransformation(double d, double d2) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = null;
        }

        private LinearTransformation createInverse() {
            double d = this.slope;
            if (d != 0.0d) {
                return new RegularLinearTransformation(1.0d / d, (this.yIntercept * -1.0d) / d, this);
            }
            return new VerticalLinearTransformation(this.yIntercept, this);
        }

        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        public boolean isHorizontal() {
            if (this.slope == 0.0d) {
                return true;
            }
            return false;
        }

        public boolean isVertical() {
            return false;
        }

        public double slope() {
            return this.slope;
        }

        public String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.slope), Double.valueOf(this.yIntercept)});
        }

        public double transform(double d) {
            return (d * this.slope) + this.yIntercept;
        }

        public RegularLinearTransformation(double d, double d2, LinearTransformation linearTransformation) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = linearTransformation;
        }
    }

    public static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        public boolean isHorizontal() {
            return false;
        }

        public boolean isVertical() {
            return false;
        }

        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        public double transform(double d) {
            return Double.NaN;
        }

        public LinearTransformation inverse() {
            return this;
        }
    }
}
