package co.test.nisum.util;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

	public static String generateJWT(String secret, String name) {

		return Jwts.builder().setSubject(name).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}

}
