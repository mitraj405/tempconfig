package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: InvalidProtocolBufferException */
public class q extends IOException {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = -1616151763072450476L;

    /* compiled from: InvalidProtocolBufferException */
    public static class a extends q {
        private static final long serialVersionUID = 3283890091615336259L;

        public a() {
            super("Protocol message tag had invalid wire type.");
        }
    }

    public q(String str) {
        super(str);
    }

    public static q a() {
        return new q("Protocol message had invalid UTF-8.");
    }

    public static a b() {
        return new a();
    }

    public static q c() {
        return new q("CodedInputStream encountered a malformed varint.");
    }

    public static q d() {
        return new q("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static q e() {
        return new q("Failed to parse the message.");
    }

    public static q f() {
        return new q("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
