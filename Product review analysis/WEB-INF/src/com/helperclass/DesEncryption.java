package com.helperclass;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Decoder;

import java.io.UnsupportedEncodingException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

public class DesEncryption 
{
	Cipher ecipher;
	Cipher dcipher;
	// 8-byte Salt
	byte[] salt = new byte[] { (byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, 0x5A };
	// Iteration count
	int iterationCount = 19;

	public DesEncryption(String passPhrase)
	{
		try 
		{
			// Create the key
			KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt,
					iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
					.generateSecret(keySpec);
			ecipher = Cipher.getInstance(key.getAlgorithm());
			dcipher = Cipher.getInstance(key.getAlgorithm());
			// Prepare the parameter to the ciphers
			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
					iterationCount);
			// Create the ciphers
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		} catch (java.security.InvalidAlgorithmParameterException e) {
		} catch (java.security.spec.InvalidKeySpecException e) {
		} catch (javax.crypto.NoSuchPaddingException e) {
		} catch (java.security.NoSuchAlgorithmException e) {
		} catch (java.security.InvalidKeyException e) {
		}
	}

	public String encrypt(String str) 
	{
		try {
			// Encode the string into bytes using utf-8
			byte[] utf8 = str.getBytes("UTF8");
			// Encrypt
			byte[] enc = ecipher.doFinal(utf8);
			// Encode bytes to base64 to get a string
			return new sun.misc.BASE64Encoder().encodeBuffer(enc);
		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (java.io.IOException e) {
		}
		return null;
	}

	public String decrypt(String str) 
	{
		if (str == null)
			return null;
		try 
		{
			//System.out.println("  final data in des : "+str);
			// Decode base64 to get bytes
			
			byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str.trim());
			//byte[] dec = ConversionProcess
			// Decrypt
			//System.out.println(" byte[] dec : "+dec);
			byte[] utf8 = dcipher.doFinal(dec);
			// Decode using utf-8
			//System.out.println("  Des final output :  "+ new String(utf8, "UTF8"));
			return new String(utf8, "UTF8");
			
			
			
		} catch (javax.crypto.BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) 
	{
		try {
			// Create encrypter/decrypter class
			DesEncryption encrypter = new DesEncryption("333kkk45");
			// Encrypt
			String encrypted = encrypter.encrypt("97_97#109_109#117_117#116_116#104_104#97_97#13_13#10_10#");
			System.out.println(encrypted);
			String decrypted = encrypter.decrypt("3deSInoeRcE/aY0C/tS8RKG0etuDrgEi");
			
			System.out.println(decrypted);
		} catch (Exception e) {
		}
	}

}