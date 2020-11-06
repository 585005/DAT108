package no.hvl.dat108;

import javax.persistence.Embeddable;

@Embeddable
public class Password {

	private String pwd_hash;
    private String pwd_salt;
    
	private Password(String hash, String salt) {
		pwd_hash = hash;
		pwd_salt = salt;
	}
	
	public Password() {}

	@Override
	public String toString() {
		return "Password [pwd_hash=" + pwd_hash + ", pwd_salt=" + pwd_salt + "]";
	}
	

	public String getPwd_hash() {
		return pwd_hash;
	}


	public String getPwd_salt() {
		return pwd_salt;
	}


	public static Password createPassword(String passwordClear) {
		String salt = PasswordHelper.generateRandomSalt();
		String hash = PasswordHelper.hashWithSalt(passwordClear, salt);
		return new Password(hash, salt);
	}
}
