package com.bit.utils;
import java.security.SecureRandom;
import org.springframework.stereotype.Component;
@Component
public class PasswordGeneratorUtil {
	private static SecureRandom random = new SecureRandom();
	//dic
    private static final String ALL_ALPHA_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*_=+-/";
//    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
//    private static final String NUMERIC = "0123456789";
//    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";
    public static String generatePassword(int len) {
	String result = "";
	for (int i = 0; i < len; i++) {
	    int index = random.nextInt(ALL_ALPHA_CHAR.length());
	    result += ALL_ALPHA_CHAR.charAt(index);
	}
	return result;
    }

}
