package org.ems.com.asdits.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;

public class CryptoUtils {

	public static final String SHA_256 = "SHA-256";

	public static String getDigestHexString(String input, String algorithm) throws NoSuchAlgorithmException {
		
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		return Hex.toHexString(digest.digest(input.getBytes()));
	}
}
