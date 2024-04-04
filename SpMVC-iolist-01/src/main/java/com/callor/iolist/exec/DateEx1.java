package com.callor.iolist.exec;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx1 {

	public static void main(String[] args) {
		
		// 자바 1.8 이전버전의 문자열형 날짜 데이터 만들기
		//java.util.Date import
		Date date = new Date();
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:SS");
		
		String strDate = dayFormat.format(date);
		String strTime = timeFormat.format(date);
		System.out.println(strDate);
		System.out.println(strTime);
		
		
	}
}
