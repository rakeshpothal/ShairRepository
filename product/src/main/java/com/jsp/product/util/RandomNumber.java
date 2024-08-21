package com.jsp.product.util;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomNumber {
	public String generateRandomNumber() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 16; i++) {
			sb.append(new SecureRandom().nextInt(10));

		}
		return sb.toString();
	}
}
