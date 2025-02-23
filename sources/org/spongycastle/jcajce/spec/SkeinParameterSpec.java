package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SkeinParameterSpec implements AlgorithmParameterSpec {
    public final Map a = Collections.unmodifiableMap(new HashMap());

    public static class Builder {
        public Builder() {
            new HashMap();
        }
    }
}
