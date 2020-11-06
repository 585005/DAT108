package no.hvl.dat108;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class PasswordHelper {

	public static String generateRandomSalt() {
	    SecureRandom sr;
	    byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		    sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    return DatatypeConverter.printHexBinary(salt);
	}

	public static String hashWithSalt(String password, String salt) { 
		
		byte[] passhash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
			md.update(saltbytes);
			passhash = md.digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(passhash);
	}
	
	public static boolean validateWithSalt(String passord, String salt, String passordhash) {
		return passordhash.equals(hashWithSalt(passord, salt));
	}

	
}
