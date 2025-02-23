package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public abstract class NameTransformer {
    public static final NameTransformer NOP = new NopTransformer();

    public static class Chained extends NameTransformer implements Serializable {
        private static final long serialVersionUID = 1;
        protected final NameTransformer _t1;
        protected final NameTransformer _t2;

        public Chained(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
            this._t1 = nameTransformer;
            this._t2 = nameTransformer2;
        }

        public String toString() {
            return "[ChainedTransformer(" + this._t1 + ", " + this._t2 + ")]";
        }

        public String transform(String str) {
            return this._t1.transform(this._t2.transform(str));
        }
    }

    public static NameTransformer chainedTransformer(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
        return new Chained(nameTransformer, nameTransformer2);
    }

    public static NameTransformer simpleTransformer(final String str, final String str2) {
        boolean z;
        boolean z2 = true;
        if (str == null || str.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (str2 == null || str2.isEmpty()) {
            z2 = false;
        }
        if (z) {
            if (z2) {
                return new NameTransformer() {
                    public String toString() {
                        StringBuilder sb = new StringBuilder("[PreAndSuffixTransformer('");
                        sb.append(str);
                        sb.append("','");
                        return C0709Uj.j(sb, str2, "')]");
                    }

                    public String transform(String str) {
                        return str + str + str2;
                    }
                };
            }
            return new NameTransformer() {
                public String toString() {
                    return C0709Uj.j(new StringBuilder("[PrefixTransformer('"), str, "')]");
                }

                public String transform(String str) {
                    return C0709Uj.j(new StringBuilder(), str, str);
                }
            };
        } else if (z2) {
            return new NameTransformer() {
                public String toString() {
                    return C0709Uj.j(new StringBuilder("[SuffixTransformer('"), str2, "')]");
                }

                public String transform(String str) {
                    StringBuilder J = xx.J(str);
                    J.append(str2);
                    return J.toString();
                }
            };
        } else {
            return NOP;
        }
    }

    public abstract String transform(String str);

    public static final class NopTransformer extends NameTransformer implements Serializable {
        private static final long serialVersionUID = 1;

        public String transform(String str) {
            return str;
        }
    }
}
