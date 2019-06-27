package com.internousdev.ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/ddd HH:mm:ss");

		return simpleDateFormat.format(date);
	}
}
