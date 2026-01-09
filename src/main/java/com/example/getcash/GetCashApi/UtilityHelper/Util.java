package com.example.getcash.GetCashApi.UtilityHelper;

public class Util {
	public static synchronized String generateOtp() {
		int otp = (int) (Math.random() * 900000) + 100000;
		return String.valueOf(otp);
	}
}
