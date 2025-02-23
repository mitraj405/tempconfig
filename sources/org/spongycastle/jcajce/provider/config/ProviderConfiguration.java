package org.spongycastle.jcajce.provider.config;

import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jce.spec.ECParameterSpec;

public interface ProviderConfiguration {
    DHParameterSpec a(int i);

    Set b();

    Map c();

    ECParameterSpec d();
}
