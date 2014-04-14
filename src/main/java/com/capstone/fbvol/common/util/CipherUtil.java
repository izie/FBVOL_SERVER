package com.capstone.fbvol.common.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;

public class CipherUtil {

	private final static String PRIVATE_KEY = "8aa18470a7031d110d2081f23179c012480d04b07481c126";

	private final static String ALGORITHM = "DESede";

	private final static String TRANSFORMATION = "DESede/ECB/PKCS5Padding";

	/**
	 * 암호화를 한다
	 *
	 * @param plainStr
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String plainStr) throws Exception {
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);

		cipher.init(Cipher.ENCRYPT_MODE, generateKey(toBytes(PRIVATE_KEY, 16)));

		byte[] plainBytes = plainStr.getBytes();
		byte[] encryptBytes = cipher.doFinal(plainBytes);

		return toHexString(encryptBytes);
	}

	/**
	 * 암호화된 문장을 복호화 한다
	 *
	 * @param hexStr
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String hexStr) throws Exception {
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);

		byte[] encryptBytes = toBytes(hexStr, 16);

		cipher.init(Cipher.DECRYPT_MODE, generateKey(toBytes(PRIVATE_KEY, 16)));

		byte[] decrypt = cipher.doFinal(encryptBytes);

		return new String(decrypt);
	}

	/**
	 * 암호화/복호화에 사용될 키를 생성한다
	 * @param keyData
	 * @return
	 * @throws Exception
	 */
	private static Key generateKey(byte[] keyData) throws Exception {
		return generateKey(ALGORITHM, keyData);
	}

	private static Key generateKey(String algorithm, byte[] keyData) throws Exception {
		KeySpec keySpec = new DESedeKeySpec(keyData);

		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(algorithm);
		SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);

		return secretKey;
	}


	/**
	 * <p>8, 10, 16진수 문자열을 바이트 배열로 변환한다.</p>
	 * <p>8, 10진수인 경우는 문자열의 3자리가, 16진수인 경우는 2자리가, 하나의 byte로 바뀐다.</p>
	 *
	 * <pre>
	 * ByteUtils.toBytes(null)     = null
	 * ByteUtils.toBytes("0E1F4E", 16) = [0x0e, 0xf4, 0x4e]
	 * ByteUtils.toBytes("48414e", 16) = [0x48, 0x41, 0x4e]
	 * </pre>
	 *
	 * @param digits 문자열
	 * @param radix 진수(8, 10, 16만 가능)
	 * @return
	 * @throws NumberFormatException
	 */
	private static byte[] toBytes(String digits, int radix) throws IllegalArgumentException, NumberFormatException {
		if (digits == null) {
			return null;
		}

		if (radix != 16 && radix != 10 && radix != 8) {
			throw new IllegalArgumentException("For input radix: \"" + radix + "\"");
		}

		int divLen = (radix == 16) ? 2 : 3;
    	int length = digits.length();

    	if (length % divLen == 1) {
    		throw new IllegalArgumentException("For input string: \"" + digits + "\"");
    	}

    	length = length / divLen;
    	byte[] bytes = new byte[length];

    	for (int i = 0; i < length; i++) {
    		int index = i * divLen;
    		bytes[i] = (byte)(Short.parseShort(digits.substring(index, index+divLen), radix));
    	}

    	return bytes;
	}

	/**
	 * <p>unsigned byte(바이트) 배열을 16진수 문자열로 바꾼다.</p>
	 *
	 * <pre>
	 * ByteUtils.toHexString(null)                   = null
	 * ByteUtils.toHexString([(byte)1, (byte)255])   = "01ff"
	 * </pre>
	 *
	 * @param bytes unsigned byte's array
	 * @return
	 * @see HexUtils.toString(byte[])
	 */
	public static String toHexString(byte[] bytes) {
		if (bytes == null) {
			return null;
		}

		StringBuffer result = new StringBuffer();

		for (byte b : bytes) {
			result.append(Integer.toString((b & 0xF0) >> 4, 16));
			result.append(Integer.toString(b & 0x0F, 16));
		}

		return result.toString();
	}

 	public static void main(String args[]) throws Exception {
 		System.err.println("암호: " + CipherUtil.encrypt("1111"));
		System.err.println("디암호: " + CipherUtil.decrypt("d7eb514c5383abf2"));
		System.err.println("디암호USER: " + CipherUtil.decrypt("36b43144ed895992"));
		System.err.println("암호: " + CipherUtil.decrypt("e98228a32ba5a6c2")); 
		
		 	}

}
