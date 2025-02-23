package org.spongycastle.jce.provider;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.spongycastle.jce.spec.ECParameterSpec;

class BouncyCastleProviderConfiguration implements ProviderConfiguration {
    public final ThreadLocal a = new ThreadLocal();

    /* renamed from: a  reason: collision with other field name */
    public volatile HashMap f6567a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public volatile HashSet f6568a = new HashSet();
    public final ThreadLocal b = new ThreadLocal();

    static {
        new ProviderConfigurationPermission("threadLocalEcImplicitlyCa");
        new ProviderConfigurationPermission("ecImplicitlyCa");
        new ProviderConfigurationPermission("threadLocalDhDefaultParams");
        new ProviderConfigurationPermission("DhDefaultParams");
        new ProviderConfigurationPermission("acceptableEcCurves");
        new ProviderConfigurationPermission("additionalEcParameters");
    }

    public final DHParameterSpec a(int i) {
        Object obj = this.b.get();
        if (obj == null) {
            obj = null;
        }
        if (obj instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) obj;
            if (dHParameterSpec.getP().bitLength() == i) {
                return dHParameterSpec;
            }
        } else if (obj instanceof DHParameterSpec[]) {
            DHParameterSpec[] dHParameterSpecArr = (DHParameterSpec[]) obj;
            for (int i2 = 0; i2 != dHParameterSpecArr.length; i2++) {
                if (dHParameterSpecArr[i2].getP().bitLength() == i) {
                    return dHParameterSpecArr[i2];
                }
            }
        }
        return null;
    }

    public final Set b() {
        return Collections.unmodifiableSet(this.f6568a);
    }

    public final Map c() {
        return Collections.unmodifiableMap(this.f6567a);
    }

    public final ECParameterSpec d() {
        ECParameterSpec eCParameterSpec = (ECParameterSpec) this.a.get();
        if (eCParameterSpec != null) {
            return eCParameterSpec;
        }
        return null;
    }
}
