package org.spongycastle.crypto;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public interface KeyParser {
    AsymmetricKeyParameter a(ByteArrayInputStream byteArrayInputStream) throws IOException;
}
