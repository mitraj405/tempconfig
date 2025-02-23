package com.fasterxml.jackson.core;

import java.io.Serializable;

public class Version implements Comparable<Version>, Serializable {
    private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, (String) null, (String) null, (String) null);
    private static final long serialVersionUID = 1;
    protected final String _artifactId;
    protected final String _groupId;
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;

    public Version(int i, int i2, int i3, String str, String str2, String str3) {
        this._majorVersion = i;
        this._minorVersion = i2;
        this._patchLevel = i3;
        this._snapshotInfo = str;
        this._groupId = str2 == null ? "" : str2;
        this._artifactId = str3 == null ? "" : str3;
    }

    public static Version unknownVersion() {
        return UNKNOWN_VERSION;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Version version = (Version) obj;
        if (version._majorVersion == this._majorVersion && version._minorVersion == this._minorVersion && version._patchLevel == this._patchLevel && version._artifactId.equals(this._artifactId) && version._groupId.equals(this._groupId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this._artifactId.hashCode() ^ (((this._groupId.hashCode() + this._majorVersion) - this._minorVersion) + this._patchLevel);
    }

    public boolean isSnapshot() {
        String str = this._snapshotInfo;
        if (str == null || str.length() <= 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._majorVersion);
        sb.append('.');
        sb.append(this._minorVersion);
        sb.append('.');
        sb.append(this._patchLevel);
        if (isSnapshot()) {
            sb.append('-');
            sb.append(this._snapshotInfo);
        }
        return sb.toString();
    }

    public int compareTo(Version version) {
        if (version == this) {
            return 0;
        }
        int compareTo = this._groupId.compareTo(version._groupId);
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = this._artifactId.compareTo(version._artifactId);
        if (compareTo2 != 0) {
            return compareTo2;
        }
        int i = this._majorVersion - version._majorVersion;
        if (i != 0) {
            return i;
        }
        int i2 = this._minorVersion - version._minorVersion;
        return i2 == 0 ? this._patchLevel - version._patchLevel : i2;
    }
}
