package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    private final NetworkConnectionInfo.MobileSubtype mobileSubtype;
    private final NetworkConnectionInfo.NetworkType networkType;

    public static final class Builder extends NetworkConnectionInfo.Builder {
        private NetworkConnectionInfo.MobileSubtype mobileSubtype;
        private NetworkConnectionInfo.NetworkType networkType;

        public NetworkConnectionInfo build() {
            return new AutoValue_NetworkConnectionInfo(this.networkType, this.mobileSubtype);
        }

        public NetworkConnectionInfo.Builder setMobileSubtype(NetworkConnectionInfo.MobileSubtype mobileSubtype2) {
            this.mobileSubtype = mobileSubtype2;
            return this;
        }

        public NetworkConnectionInfo.Builder setNetworkType(NetworkConnectionInfo.NetworkType networkType2) {
            this.networkType = networkType2;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType2 = this.networkType;
        if (networkType2 != null ? networkType2.equals(networkConnectionInfo.getNetworkType()) : networkConnectionInfo.getNetworkType() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype2 = this.mobileSubtype;
            if (mobileSubtype2 == null) {
                if (networkConnectionInfo.getMobileSubtype() == null) {
                    return true;
                }
            } else if (mobileSubtype2.equals(networkConnectionInfo.getMobileSubtype())) {
                return true;
            }
        }
        return false;
    }

    public NetworkConnectionInfo.MobileSubtype getMobileSubtype() {
        return this.mobileSubtype;
    }

    public NetworkConnectionInfo.NetworkType getNetworkType() {
        return this.networkType;
    }

    public int hashCode() {
        int i;
        NetworkConnectionInfo.NetworkType networkType2 = this.networkType;
        int i2 = 0;
        if (networkType2 == null) {
            i = 0;
        } else {
            i = networkType2.hashCode();
        }
        int i3 = (i ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype2 = this.mobileSubtype;
        if (mobileSubtype2 != null) {
            i2 = mobileSubtype2.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.networkType + ", mobileSubtype=" + this.mobileSubtype + "}";
    }

    private AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType2, NetworkConnectionInfo.MobileSubtype mobileSubtype2) {
        this.networkType = networkType2;
        this.mobileSubtype = mobileSubtype2;
    }
}
