package org.spongycastle.jcajce.provider.symmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

abstract class SymmetricAlgorithmProvider extends AlgorithmProvider {
    public static void b(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        configurableProvider.b("Mac." + str + "-CMAC", str2);
        StringBuilder o = lf.o(str, "-CMAC", configurableProvider, lf.j("Alg.Alias.Mac.", str, "CMAC"), "KeyGenerator.");
        o.append(str);
        o.append("-CMAC");
        configurableProvider.b(o.toString(), str3);
        configurableProvider.b(lf.j("Alg.Alias.KeyGenerator.", str, "CMAC"), str.concat("-CMAC"));
    }

    public static void c(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        configurableProvider.b("Mac." + str + "-GMAC", str2);
        StringBuilder o = lf.o(str, "-GMAC", configurableProvider, lf.j("Alg.Alias.Mac.", str, "GMAC"), "KeyGenerator.");
        o.append(str);
        o.append("-GMAC");
        configurableProvider.b(o.toString(), str3);
        configurableProvider.b(lf.j("Alg.Alias.KeyGenerator.", str, "GMAC"), str.concat("-GMAC"));
    }

    public static void d(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        configurableProvider.b("Mac.POLY1305-".concat(str), str2);
        configurableProvider.b("Alg.Alias.Mac.POLY1305".concat(str), "POLY1305-".concat(str));
        configurableProvider.b("KeyGenerator.POLY1305-".concat(str), str3);
        configurableProvider.b("Alg.Alias.KeyGenerator.POLY1305".concat(str), "POLY1305-".concat(str));
    }
}
