package com.shopperStackgeneric;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {

	public int randomNumber() {
		Random r=new Random();
		int number = r.nextInt(1000);
		return number;
	}
	public String localDate() {
		String localDate = LocalDate.now().toString().replace("-", "");
		return localDate;
		
	}
	public String localDateTime() {
		String localDateTime = LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
		return localDateTime;
	}
}
