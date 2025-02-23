package org.spongycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.spongycastle.util.Strings;

public class ProviderConfigurationPermission extends BasicPermission {
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f6501c;

    public ProviderConfigurationPermission(String str) {
        super("SC", str);
        this.f6501c = str;
        StringTokenizer stringTokenizer = new StringTokenizer(Strings.e(str), " ,");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("threadlocalecimplicitlyca")) {
                i |= 1;
            } else if (nextToken.equals("ecimplicitlyca")) {
                i |= 2;
            } else if (nextToken.equals("threadlocaldhdefaultparams")) {
                i |= 4;
            } else if (nextToken.equals("dhdefaultparams")) {
                i |= 8;
            } else if (nextToken.equals("acceptableeccurves")) {
                i |= 16;
            } else if (nextToken.equals("additionalecparameters")) {
                i |= 32;
            } else if (nextToken.equals("all")) {
                i |= 63;
            }
        }
        if (i != 0) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProviderConfigurationPermission)) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission) obj;
        if (this.c != providerConfigurationPermission.c || !getName().equals(providerConfigurationPermission.getName())) {
            return false;
        }
        return true;
    }

    public final String getActions() {
        return this.f6501c;
    }

    public final int hashCode() {
        return getName().hashCode() + this.c;
    }

    public final boolean implies(Permission permission) {
        if (!(permission instanceof ProviderConfigurationPermission) || !getName().equals(permission.getName())) {
            return false;
        }
        int i = this.c;
        int i2 = ((ProviderConfigurationPermission) permission).c;
        if ((i & i2) == i2) {
            return true;
        }
        return false;
    }
}
