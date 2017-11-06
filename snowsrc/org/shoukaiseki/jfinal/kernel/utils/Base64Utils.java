package org.shoukaiseki.jfinal.kernel.utils;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {

	public static String encodeBase64(byte[] bytes) {
		// TODO Auto-generated method stub
		
//		Base64.encodeBase64String(bytes);
		return Base64.encodeBase64URLSafeString(bytes);
	}

	public static byte[] decodeBase64(String base64) {
		// TODO Auto-generated method stub
		return Base64.decodeBase64(base64);
	}

}
