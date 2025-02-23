package org.spongycastle.jcajce.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;

public interface JcaJceHelper {
    Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException;
}
