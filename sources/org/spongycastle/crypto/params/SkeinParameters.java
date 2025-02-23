package org.spongycastle.crypto.params;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;

public class SkeinParameters implements CipherParameters {
    public final Hashtable a;

    public SkeinParameters() {
        this(new Hashtable());
    }

    public static class Builder {
        public final Hashtable a = new Hashtable();

        public Builder() {
        }

        public Builder(Hashtable hashtable) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                Integer num = (Integer) keys.nextElement();
                this.a.put(num, hashtable.get(num));
            }
        }
    }

    public SkeinParameters(Hashtable hashtable) {
        this.a = hashtable;
    }
}
