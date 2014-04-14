package com.capstone.fbvol.common.util;

import java.awt.*;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class KUtil
{
	
	//***** http 형식의 문서 자동링크 *****//
	//public static String linkURL(String url) { 
    //          String p = "(http://[\\.\\w\\-\\?/~_@&=%#]+)"; 
    //          String to = "  <a href=\"$0\" target='_blank'>$0</a>"; 

	//          RE r = new RE(p); 
    //            return r.subst(url, to, 0x0002); 
    //} 
	
	//**** reUrl 현재 페이지의 URL 정보를 가져와 인코딩하여 보내준다 *****//
	public static String reUrl(javax.servlet.http.HttpServletRequest request){
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		String reUrl = requestURI;
		if(queryString != null){
			reUrl += "?"+queryString;
		}
		return reUrl;
	}
	

	public static String nailView(String inFile){
		if(inFile == null || inFile.length() < 1){
			return "";
		}
		String fileExt = inFile.substring(inFile.lastIndexOf("."),inFile.length());
		String fileNam = inFile.substring(0,inFile.lastIndexOf("."));
		return (fileNam +"_"+fileExt);
	}

	public static String nailView(String inFile,int cnt){
		if(inFile == null || inFile.length() < 1){
			return "";
		}
		String fileExt = inFile.substring(inFile.lastIndexOf("."),inFile.length());
		String fileNam = inFile.substring(0,inFile.lastIndexOf("."));
		String str = "";
		for( int i = 0 ; i < cnt ; i++ ){
			str+="_";
		}
		return (fileNam +str+fileExt);
	}

	public static String nailView(String inFile,String retVal){
		if(inFile == null || inFile.length() < 1){
			return retVal;
		}
		String fileExt = inFile.substring(inFile.lastIndexOf("."),inFile.length());
		String fileNam = inFile.substring(0,inFile.lastIndexOf("."));
		return (fileNam +"_"+fileExt);
	}

	public static String nailView(String inFile, int cnt, String retVal){
		if(inFile == null || inFile.length() < 1){
			return retVal;
		}
		String str = "";
		for( int i = 0 ; i < cnt ; i++ ){
			str+="_";
		}
		String fileExt = inFile.substring(inFile.lastIndexOf("."),inFile.length());
		String fileNam = inFile.substring(0,inFile.lastIndexOf("."));
		return (fileNam +str+fileExt);
	}


	//***** 한국어 변환 *****//
	public static String toKor(String str) {
		String rtn = null;
		try {
			rtn = (str==null || str.length() < 1)?"":new String(str.getBytes("8859_1"),"euc-kr");
		} catch (UnsupportedEncodingException e) {}

		return rtn;
	}

	//***** 영어로 변환 *****//
	public static String toEng(String str) {
		String rtn = null;
		try {
				rtn = (str==null || str.length() < 1)?"":new String(str.getBytes("euc-kr"),"8859_1");
		} catch (UnsupportedEncodingException e) {}
		return rtn;
	}

	//***** null 공백 체크 *****//
	public static String nchk(String str) {
		if( str == null || str.trim().length() < 1 ) 
			return "";
		else  
			return str;
	}

	//***** null 공백 체크 *****//
	public static String nchk(String str, String retVal) {
		return (str==null || str.length() < 1) ? retVal : str;
	}

	public static int nchkToInt(String str) {
		if(str==null || str.trim().length() < 1){
			return 0;
		}else{
			try{ 
				return Integer.parseInt(str);
			}catch(Exception e){
			   return 0;
			}
		}
	}
	public static long nchkToLong(String str) {
		if(str==null || str.trim().length() < 1){
			return 0;
		}else{
			try{ 
				return Long.parseLong(str);
			}catch(Exception e){
			   return 0;
			}
		}
	}

	public static double nchkToDouble(String str) {
		if(str==null || str.length() < 1){
			return 0;
		}else{
			try{ 
				return Double.parseDouble(str);
			}catch(Exception e){
			   return 0;
			}
		}
	}

	public static int nchkToInt(String str,int retVal) {
		if(str==null || str.trim().length() < 1){
			return retVal;
		}else{
			try{ 
				return Integer.parseInt(str);
			}catch(Exception e){
			   return retVal;
			}
		}
	}
	
	public static int dateToInt(String str,int retVal) {
		if(str==null || str.length() < 1){
			return retVal;
		}else{
			
			try{ 
				String val = "";
				for( int i=0 ; i<str.length() ; i++ ){
					if( Character.isDigit( str.charAt(i) ) ){
						val += str.charAt(i);
					}
				}
				return Integer.parseInt(val);
			}catch(Exception e){
			   return retVal;
			}
		}
	}

	//***** 파일 이름변환 ***** 적용//
	public static String fileView(String fileName) {
			if(fileName==null){
				return "";
			}else if(fileName.length() < 15){
				return "";
			}
			return fileName.substring(fileName.indexOf("_")+1,fileName.length());
	}

	//***** 파일 이름변환 ***** 적용//
	public static String fileViewLink(String fileName) {
			if(fileName==null || fileName.length() < 15){
				return "";
			}
			StringBuffer sbf = new StringBuffer();
			sbf.append("<a href=\"/download.jsp?fn="+ URLEncoder.encode(fileName)+"\" target='nlink'>")
			   .append(fileName.substring(fileName.indexOf("_")+1,fileName.length()))
			   .append("</a>");

			return sbf.toString();
	}
	public static String fileLink(String fileName, String outVal) {
			if(fileName==null || fileName.length() < 15){
				return outVal;
			}
			StringBuffer sbf = new StringBuffer();
			sbf.append("<a href=\"/download.jsp?fn="+ URLEncoder.encode(fileName)+"\" target='nlink'>"+fileName+"</a>");

			return sbf.toString();
	}
	//***** 파일 이름변환 ***** 적용//
	public static String fileViewLink(String fileName,String outVal) {
			if(fileName==null || fileName.length() < 15){
				return outVal;
			}
			StringBuffer sbf = new StringBuffer();
			sbf.append("<a href=\"/download.jsp?fn="+ URLEncoder.encode(fileName)+"\" target='nlink'>")
			   .append(fileName.substring(fileName.indexOf("_")+1,fileName.length()))
			   .append("</a>");

			return sbf.toString();
	}

	public static String fileViewLink(String fileName,String outVal, int cut) {
			if(fileName==null || fileName.length() < 15){
				return outVal;
			}
			StringBuffer sbf = new StringBuffer();
			sbf.append("<a href=\"/download.jsp?fn="+ URLEncoder.encode(fileName)+"\" target='nlink'>")
			   .append( KUtil.cutTitle( fileName.substring( fileName.indexOf("_")+1, fileName.length() ),cut,".." ) )
			   .append("</a>");

			return sbf.toString();
	}
	
	//**** 주민번호 111111-111111형식 반환 *****//
	public static String snView(String sn){
		return sn.substring(0,6)+"-"+sn.substring(6,13);
	}
	
	//***** 문자열 변환 str 입력 문자, 변환할 문자 n1,변환될 문자 n2 *****//
	public static String replace(String str, String n1, String n2) {
        int itmp = 0;
        if (str==null) return "";
        
        String tmp = str;
        StringBuffer sb = new StringBuffer();
        sb.append("");
        while (tmp.indexOf(n1) > -1) {
                itmp = tmp.indexOf(n1);
                sb.append(tmp.substring(0,itmp));
                sb.append(n2);
                tmp = tmp.substring(itmp+n1.length());
        }
        sb.append(tmp);
        return sb.toString();
	}

	/***** html 모드로 출력할때 사용 *****/
	public static String toHtmlMode(String value) {
		String convertedValue = "";
		
		convertedValue = replace(value, "\n", "<BR>");
		
		return convertedValue;
		//return value;
	}

	/***** 텍스트 모드로 출력할경우 *****/
	public static String toTextMode(String value) {
		String convertedValue = "";
		
		convertedValue = replace(value, "<", "&lt");
		convertedValue = replace(convertedValue, ">", "&gt");
		convertedValue = replace(convertedValue, "\n", "<BR>");
		convertedValue = replace(convertedValue, " ", "&nbsp;");		
		convertedValue = replace(convertedValue, "\"", "&quot;");
		convertedValue = replace(convertedValue, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		//convertedValue = linkURL(convertedValue);
		
		return convertedValue;
	}

	public static String toTextMode(String value,String retVal) {
		
		String convertedValue = "";
		if( value==null || value.length()<1 ){
			return retVal;
		}
		convertedValue = replace(value, "<", "&lt");
		convertedValue = replace(convertedValue, ">", "&gt");
		convertedValue = replace(convertedValue, "\n", "<BR>");
		convertedValue = replace(convertedValue, " ", "&nbsp;");
		convertedValue = replace(convertedValue, "\"", "&quot;");
		convertedValue = replace(convertedValue, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		//convertedValue = linkURL(convertedValue);
		
		return convertedValue;
	}

	/***** 텍스트 모드로 출력할경우 *****/
	public static String toEditMode(String value) {
		String convertedValue = "";
		
		convertedValue = replace(value, "\"", "&quot;");
		
		return convertedValue;
	}

	/***** 검색의 경우 ' 문제 해결사용 *****/
	public static String toSearchMode(String value) {
		String convertedValue = "";
		
		convertedValue = replace(value, "\'", "\'\'");
		
		return convertedValue;
	}

	
	public static String formatDigit(int num) {
		// check digit
		int digit = Integer.toString(num).length()<=3?3:Integer.toString(num).length();
		if (digit<1) return null;
		int digit_maximun = 1;
		for(int i=0;i<digit;i++) {
			digit_maximun = digit_maximun * 10;
		}
		if (num>=digit_maximun) return null;
		
		// format string
		String formatString = Integer.toString(num);
		int    appendDigit = digit-formatString.length();
		
		for(int i=0;i<appendDigit;i++) {
			formatString = "0"+formatString;
		}

		return formatString;
	}
	/** 첫번재 숫자를 두번째 숫자의 길이만큼 늘려 문자로 보냄
	formatDigit(1,5) returns "00001", formatDigit(14,4) returns "0014". */
	public static String formatDigit(int num, int digit) {
		// check digit
		if (digit<1) return null;
		int digit_maximun = 1;
		for(int i=0;i<digit;i++) {
			digit_maximun = digit_maximun * 10;
		}
		if (num>=digit_maximun) return null;
		
		// format string
		String formatString = Integer.toString(num);
		int    appendDigit = digit-formatString.length();
		
		for(int i=0;i<appendDigit;i++) {
			formatString = "0"+formatString;
		}

		return formatString;
	}	

	public static String formatDigit(long num, int digit) {
		// check digit
		if (digit<1) return null;
		int digit_maximun = 1;
		for(int i=0;i<digit;i++) {
			digit_maximun = digit_maximun * 10;
		}
		if (num>=digit_maximun) return null;
		
		// format string
		String formatString = Long.toString(num);
		int    appendDigit = digit-formatString.length();
		
		for(int i=0;i<appendDigit;i++) {
			formatString = "0"+formatString;
		}

		return formatString;
	}
	
	public static String formatDigit(String num,int digit){
		if(digit < 1){ return null;	}
		int len = digit - num.length();
		String val = "";
		for(int i=0; i <len;i++){
			val += "0";
		}
		val += num;
		return val;
	}


	/** 
	 *   controlLength() method make oldString have less length than 'len'. If already, return it. 
	 *   But if more than 'len', controlLength() cut oldString with length='len-2' and put '..'. 
	 *
	 * @param  oldString string object to cut 
	 * @param  len required length of oldString 
	 * @param  suffix suffix of new String
	 * @return cutting value with length = len
	 */
	public static String controlLength(String oldString, int len, String suffix) {
		
		String newString = "";
		int index=0;
		int current_length=0;
		
		if (oldString==null) return oldString;

		while (index<oldString.length() && current_length<len) {
			char tmp_char = oldString.charAt(index);
			current_length++;
			index++;
			if (tmp_char>255) {
				current_length++;
			}
		}
		
		newString = oldString.substring(0,index);
		
		if (index<oldString.length()){
			newString += suffix ;
		}
		
		return newString;
	}
	

	/**
	 * @param java.lang.String pattern  "yyyy, MM, dd, HH, mm, ss and more"
	 * @return formatted string representation of current day and time with  your pattern.
	 */
	public static String getEngDate(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.ENGLISH);
		String dateString = formatter.format(new Date());
		return dateString;
	}
	//time ex) 20040924
	public static String chEngDate(int time,String pattern){
		try{
			String tme = Integer.toString(time);
			if( tme == null || tme.length()<6 ){
				return "";
			}

			SimpleDateFormat formatter =
				new SimpleDateFormat ("yyyyMMdd", Locale.ENGLISH);
			Date d = formatter.parse(Integer.toString(time));
			formatter = new SimpleDateFormat (pattern, Locale.ENGLISH);
			return formatter.format(d);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		
	}

	public static String getDate(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.KOREA);
		String dateString = formatter.format(new Date());
		return dateString;
	}

	public static String getDate(Date date, String pattern) {
		
		try{
			if( date == null || pattern==null || KUtil.nchk(pattern).length() < 1 ){
				return null;
			}
			SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.KOREA);
			String dateString = formatter.format(date);
			return dateString;	
		}catch(Exception e){
			System.out.print(e.toString());
			return null;
		}		
	}
	//time ex) 2004-09-24 11:12:21
	public static String getDate(String time,String pattern){
		try{
			if( KUtil.nchk(time).length() < 1 || KUtil.nchk(pattern).length() < 1 ){
				return null;
			}
			SimpleDateFormat formatter =
				new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			Date d = formatter.parse(time);
			formatter = new SimpleDateFormat (pattern, Locale.KOREA);
			return formatter.format(d);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		
	}
	//time ex) inPattern -> outPattern
	public static String getDate(String time,String inPattern, String outPattern){
		try{
			SimpleDateFormat formatter = new SimpleDateFormat (inPattern, Locale.KOREA);
			Date d = formatter.parse(time);
			formatter = new SimpleDateFormat (outPattern, Locale.KOREA);
			return formatter.format(d);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		
	}
	//time ex) 2004-09-24 11:12:21
	public static Date getDateObj(String time){
		try{
			SimpleDateFormat formatter =
				new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			Date d = formatter.parse(time);
			return d;	
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		
	}
	//time ex) 2004-09-24 11:12:21
	public static Date getDateObj(String time, String pattern){
		try{
			SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.KOREA);
			Date d = formatter.parse(time);
			return d;
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		
	}

	/**
	 * @param java.lang.String pattern  "yyyy, MM, dd, HH, mm, ss and more"
	 * @return formatted string representation of current day and time with  your pattern.
	 */
	public static int getIntDate(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.KOREA);
		String dateString = formatter.format(new Date());
		return Integer.parseInt(dateString);
	}

	public static long getLongDate(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat (pattern, Locale.KOREA);
		String dateString = formatter.format(new Date());
		return Long.parseLong(dateString);
	}
	
	//yyyyMMdd 형식의 데이타 @입력날짜 @2일 이후 return 입력날짜 +(이후날짜)
	public static int getNextDate(int date,int num){
		Calendar cal = Calendar.getInstance();
		int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
		int month = Integer.parseInt(Integer.toString(date).substring(4,6));
		int day   = Integer.parseInt(Integer.toString(date).substring(6,8));
		cal.set(year,month-1,day);
		cal.add(Calendar.DATE,num);
		int reYear = cal.get(Calendar.YEAR);
		int reMonth = cal.get(Calendar.MONTH)+1;
		int reDay = cal.get(Calendar.DATE);
		return Integer.parseInt(formatDigit(reYear,4)+formatDigit(reMonth,2)+formatDigit(reDay,2));
	}

	public static int getNextDate(int date,double num1){
		int num = (int)(num1*30);
		Calendar cal = Calendar.getInstance();
		int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
		int month = Integer.parseInt(Integer.toString(date).substring(4,6));
		int day   = Integer.parseInt(Integer.toString(date).substring(6,8));
		cal.set(year,month-1,day);
		cal.add(Calendar.DATE,num);
		int reYear = cal.get(Calendar.YEAR);
		int reMonth = cal.get(Calendar.MONTH)+1;
		int reDay = cal.get(Calendar.DATE);
		return Integer.parseInt(formatDigit(reYear,4)+formatDigit(reMonth,2)+formatDigit(reDay,2));
	}

	//yyyyMMdd 형식의 데이타 를 입력받아 해당주의 첫번째 날짜와 해당주의 마지막 날짜를 반환
	public static int[] getWeekDate(int date){
		Calendar cal = Calendar.getInstance();
		int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
		int month = Integer.parseInt(Integer.toString(date).substring(4,6));
		int day   = Integer.parseInt(Integer.toString(date).substring(6,8));
		cal.set(year,month-1,day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		//시작일 구하기
		int stWeek = 1-dayOfWeek;	//시작일 세팅
		
		
		cal.add(Calendar.DATE,stWeek);
		int stYear = cal.get(Calendar.YEAR);
		int stMonth = cal.get(Calendar.MONTH)+1;
		int stDay = cal.get(Calendar.DATE);
		
		//종료일 구하기
		cal.add(Calendar.DATE,6);
		int enYear = cal.get(Calendar.YEAR);
		int enMonth = cal.get(Calendar.MONTH)+1;
		int enDay = cal.get(Calendar.DATE);
		

		int []re = new int[2];
		re[0] = Integer.parseInt(formatDigit(stYear,4)+formatDigit(stMonth,2)+formatDigit(stDay,2));
		re[1] = Integer.parseInt(formatDigit(enYear,4)+formatDigit(enMonth,2)+formatDigit(enDay,2));
		return re;
	}

	//yyyyMMdd 형식의 데이타 를 입력받아 월의 마지막 날자인지 비교
	public static int isLastDate(int date){
		Calendar cal = Calendar.getInstance();
		int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
		int month = Integer.parseInt(Integer.toString(date).substring(4,6));
		int day   = Integer.parseInt(Integer.toString(date).substring(6,8));
		cal.set(year,month-1,day);

		int maxDay = cal.getActualMaximum(Calendar.DATE);
		int retValue = 0;
		if( day == maxDay ){
			retValue = 1;
			if( month%3 == 0 ){
				retValue = 2;
				if( month%6 == 0 ){
					retValue = 3;
					if( month == 12 ){
						retValue = 4;
					}
				}
			}
		}
		return retValue;

	}

	//yyyyMMdd 형식의 데이타 를 입력받아 각해당 분기의 첫날과 마지막날 반환
	public static int[] isStEdDate(int date,int gubun){
		Calendar cal = Calendar.getInstance();
		int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
		int month = Integer.parseInt(Integer.toString(date).substring(4,6));
		int day   = Integer.parseInt(Integer.toString(date).substring(6,8));
		cal.set(year,month-1,day);
		int maxDay = cal.getActualMaximum(Calendar.DATE);

		int []retVal = new int[2];
		
		int retValue = 0;
		if( gubun == 7 ){
			retVal = getWeekDate(date);
		}else if( gubun == 30 ){
			retVal[0] = year*10000+month*100+1;
			retVal[1] = year*10000+month*100+maxDay;
		}else if( gubun == 90 ){
			switch( month ){
				case 1:	case 2:
				case 3: retVal[0] = year*10000+100+1; retVal[1] = year*10000+300+31;break;
				case 4:	case 5:
				case 6: retVal[0] = year*10000+400+1; retVal[1] = year*10000+600+30;break;
				case 7:	case 8:
				case 9: retVal[0] = year*10000+700+1; retVal[1] = year*10000+900+30;break;
				default: retVal[0] = year*10000+900+1; retVal[1] = year*10000+1200+31;break;
			}
		}else if( gubun == 180 ){
			switch( month ){
				case 1:case 2:case 3:case 4:case 5:
				case 6:retVal[0] = year*10000+100+1; retVal[1] = year*10000+600+30;break;
				default:retVal[0] = year*10000+700+1; retVal[1] = year*10000+1200+31;break;
			}
		}else{
			retVal[0] = year*10000+100+1; retVal[1] = year*10000+1200+31;
		}
		return retVal;

	}
	public static String dayOfWeek(int date){
		try{
			Calendar cal = Calendar.getInstance();
			int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
			int month = Integer.parseInt(Integer.toString(date).substring(4,6));
			int day   = Integer.parseInt(Integer.toString(date).substring(6,8));
			cal.set(year,month-1,day);
			return getWeekKor(cal.get(Calendar.DAY_OF_WEEK)-1);
		}catch(Exception e){
			System.out.print(e.toString());
			return null;
		}
	}

	public static String getWeekKor(int cnt){
		try{
			String weekKor = null;
			switch( cnt ){
				case 1:weekKor="월";break;
				case 2:weekKor="화";break;
				case 3:weekKor="수";break;
				case 4:weekKor="목";break;
				case 5:weekKor="금";break;
				case 6:weekKor="토";break;
				default:weekKor="일";break;
			}
			return weekKor;
		}catch(Exception e){
			System.out.print(e.toString());
			return null;
		}
	}

	//yyyyMM 입력받아 +1달 의 년월을 반환한다
	public static int getNextMonth(int date){
		Calendar cal = Calendar.getInstance();
		int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
		int month = Integer.parseInt(Integer.toString(date).substring(4,6));
		cal.set(year,month-1,1);
		cal.add(Calendar.MONTH,1);
		int reYear = cal.get(Calendar.YEAR);
		int reMonth = cal.get(Calendar.MONTH)+1;
		return Integer.parseInt(formatDigit(reYear,4)+formatDigit(reMonth,2));
	}
	//yyyyMMdd 입력받아 +n달 의 년월을 반환한다
	public static int getNextMonth(int date,int during){
		Calendar cal = Calendar.getInstance();
		int year  = Integer.parseInt(Integer.toString(date).substring(0,4));
		int month = Integer.parseInt(Integer.toString(date).substring(4,6));
		int day   = Integer.parseInt(Integer.toString(date).substring(6,8));
		cal.set(year,month-1,day);
		cal.add(Calendar.MONTH,during);
		int reYear	= cal.get(Calendar.YEAR);
		int reMonth = cal.get(Calendar.MONTH)+1;
		int reDay	= cal.get(Calendar.DATE);
		return Integer.parseInt(formatDigit(reYear,4)+formatDigit(reMonth,2)+formatDigit(reDay,2));
	}
	
	public static String toHourViewMode(int hour){
		
		if(hour < 1 ){
			return "";
		}else{
			String h = Integer.toString(hour).substring(0,2);
			String m = Integer.toString(hour).substring(2,4);
			return h+":"+m;
		}
	}

	public static String toDateViewMode(int inDate){
		
		if(inDate < 190000 ){
			return "";
		}
		String year = Integer.toString(inDate).substring(0,4);
		String month = Integer.toString(inDate).substring(4,6);
		
		if(Integer.toString(inDate).length() > 6){
			String day = Integer.toString(inDate).substring(6,8);
			return year+"."+month+"."+day;
		}
		return year+"."+month;
	
	}
	
	public static String dateMode(int inDate,String inStr,String retVal){
		
		if(inDate < 190000 ){
			return retVal;
		}
		String year = Integer.toString(inDate).substring(0,4);
		String month = Integer.toString(inDate).substring(4,6);
		
		if(Integer.toString(inDate).length() > 6){
			String day = Integer.toString(inDate).substring(6,8);
			return year+inStr+month+inStr+day;
		}
		return year+inStr+month;
	
	}

	public static String dateMode1(int inDate,String inStr,String retVal){
		
		if(inDate < 190000 ){
			return retVal;
		}
		String year = Integer.toString(inDate).substring(0,4);
		String month = Integer.toString(inDate).substring(4,6);
		
		if(Integer.toString(inDate).length() > 6){
			String day = Integer.toString(inDate).substring(6,8);
			return year+"<br>"+month+inStr+day;
		}
		return year+"<br>"+month;
	
	}

	public static String dateMode(int inDate,String inFmt, String outFmt, String retVal){
		try{
			if( inDate < 1900 )	return retVal;

			SimpleDateFormat format = new SimpleDateFormat(inFmt);
			Date d = format.parse(Integer.toString(inDate));
			
			format = new SimpleDateFormat(outFmt);
			
			return format.format( d );

		}catch(Exception e){
			System.out.print(e.toString());
			return retVal;
		}
	}

	public static String dateMode(int inDate,String inFmt, String outFmt, String language, String retVal){
		try{
			if( inDate < 1900 )	return retVal;
			SimpleDateFormat format = new SimpleDateFormat(inFmt);
			Date d = format.parse(Integer.toString(inDate));
			
			format = new SimpleDateFormat(outFmt, new Locale(language));
			
			return format.format( d );

		}catch(Exception e){
			System.out.print(e.toString());
			return retVal;
		}
	}

	public static String toDateViewMode1(int inDate){
		
		if(inDate < 190000 ){
			return "";
		}
		String year = Integer.toString(inDate).substring(0,4);
		String month = Integer.toString(inDate).substring(4,6);
		
		if(Integer.toString(inDate).length() > 6){
			String day = Integer.toString(inDate).substring(6,8);
			return year+"<br>"+month+"."+day;
		}
		return year+"<br>"+month;
	
	}

	public static String toDateViewMode(String inDate,String inStr){
		String year = inDate.substring(0,4);
		String month = inDate.substring(4,6);
		if(inDate.length() > 6){
			String day = inDate.substring(6,8);
			return year+inStr+month+inStr+day;
		}
		return year+inStr+month;
		
	}

	public static String toDateViewMode(int inDate , String inStr){
		if(inDate < 1 ){
			return "";
		}else{
			String year = Integer.toString(inDate).substring(0,4);
			String month = Integer.toString(inDate).substring(4,6);
			if(Integer.toString(inDate).length() > 6){
				String day = Integer.toString(inDate).substring(6,8);
				return year+inStr+month+inStr+day;
			}
			return year+inStr+month;
		}
	}

	public static String toDateView(int inDate , String inStr){
		if(inDate < 1 ){
			return "";
		}else{
			String year = Integer.toString(inDate).substring(0,4);
			String month = Integer.toString(inDate).substring(4,6);
			String day = Integer.toString(inDate).substring(6,8);
			String hour = Integer.toString(inDate).substring(8,10);
			return year+inStr+month+inStr+day+" "+hour+"시";
		}
	}
	
	public static String vModePostNum(String str){
		try{
			if( str == null || str.length() < 6 ){
				return "";
			}
			return str.substring(0,3)+"-"+str.substring(3,6);
		}catch(Exception e){
			return null;
		}
	}

	public static String cutIntDate(int date, int st,int ed){
		try{
			if( Integer.toString(date).length() < st || Integer.toString(date).length() < ed ){
				return "";
			}
			return Integer.toString(date).substring(st,ed);
		}catch(Exception e){
			return null;
		}
	}
	
	public static String cutIntDate(int date, int st,int ed,int digitWidth){
		try{
			if( Integer.toString(date).length() < st || Integer.toString(date).length() < ed ){
				return "";
			}
			return KUtil.formatDigit(Integer.parseInt(Integer.toString(date).substring(st,ed)) ,digitWidth);
		}catch(Exception e){
			return "";
		}
	}

	public static int cutIntDateRI(int date, int st,int ed){
		try{
			if( Integer.toString(date).length() < st || Integer.toString(date).length() < ed ){
				return 0;
			}
			return Integer.parseInt(Integer.toString(date).substring(st,ed));
		}catch(Exception e){
			return 0;
		}
	}

	

	public static String cutLongDate(long date, int st,int ed){
		try{
			if( Long.toString(date).length() < st || Long.toString(date).length() < ed ){
				return "";
			}
			return Long.toString(date).substring(st,ed);
		}catch(Exception e){
			return null;
		}
	}

	/** 
	 *   decode() method returns decoded value of Hangul(ksc5601)
	 * @param  original value
	 * @return decoded value
	 */
	 public static String decode(String oldString) {
	 	
		 if (oldString==null) return oldString;
		 
		 try {
		 	oldString = new String(oldString.getBytes("8859_1"), "ksc5601");
		  } catch(UnsupportedEncodingException e) {
		  	System.out.println(e);
		  }
		  
		 return oldString;
	}

	/** 
	 *   encode() method returns encoded value of Hangul
	 *
	 * @param  original value
	 * @return encoded value
	 */
	 public static String encode(String oldString) {
	 	
		 if (oldString==null) return oldString;
		 
		 try {
		 	oldString = URLEncoder.encode(oldString);
		  } catch(Exception e) {
		  }
		  
		 return oldString;
	}
	
	/***** script alert out String *****/
	public static String scriptAlert(String str){
		StringBuffer sb = new StringBuffer();
		if (str==null || str.length() < 1){  
			return str; 
		}
		try{ 
			sb.append("<script language='javascript'>\n");
			sb.append("alert('");
			sb.append(str);
			sb.append("');\n");
			sb.append("</script>\n");
		}catch(Exception e){
			return str;
		}
		return sb.toString();
	}
	
	/***** script alert and history.back() *****/
	public static String scriptAlertBack(String str){
		StringBuffer sb = new StringBuffer();
		if (str==null || str.length() < 1){  
			return str; 
		}
		try{ 
			sb.append("<script language='javascript'>\n");
			sb.append("alert('");
			sb.append(str);
			sb.append("');\n");
			sb.append("history.back();\n");
			sb.append("</script>\n");
		}catch(Exception e){
			return str;
		}
		return sb.toString();
	}

	/***** script move *****/
	public static void scriptMove(javax.servlet.jsp.JspWriter rOut,String url){
		StringBuffer sb = new StringBuffer();
		try{ 
			sb.append("<script language='javascript'>\n");
			sb.append("document.location.href='"+url+"';\n");
			sb.append("</script>\n");
			rOut.print(sb.toString());
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/***** script alert and move *****/
	public static void scriptAlertMove(javax.servlet.jsp.JspWriter rOut,String str,String url){
		StringBuffer sb = new StringBuffer();
		try{
			
			sb.append("<script language='javascript'>\n");
			sb.append("alert('");
			sb.append(str);
			sb.append("');\n");
			sb.append("document.location.href='"+url+"';\n");
			sb.append("</script>\n");
			rOut.print(sb.toString());
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/***** script alert out String *****/
	public static String scriptOut(String str){
		StringBuffer sb = new StringBuffer();
		if (str==null || str.length() < 1){  
			return str; 
		}
		try{ 
			sb.append("<script language='javascript'>\n");
			sb.append(str);
			sb.append("\n");
			sb.append("</script>\n");
		}catch(Exception e){
			return str;
		}
		return sb.toString();
	}

		/***** script alert out String Use jspWriter *****/
	public static void scriptAlert(javax.servlet.jsp.JspWriter rOut,String str) throws Exception{
		StringBuffer sb = new StringBuffer();
		if (str!=null || str.length() >0){
			try{ 
				sb.append("<script language='javascript'>\n");
				sb.append("alert('");
				sb.append(str);
				sb.append("');\n");
				sb.append("</script>\n");

				rOut.print(sb.toString());
			}catch(Exception e){
				rOut.print(e);
			}
		}
	}
	
	/***** script alert and history.back() Use jspWriter *****/
	public static void scriptAlertBack(javax.servlet.jsp.JspWriter rOut,String str) throws Exception{
		StringBuffer sb = new StringBuffer();
		if (str!=null || str.length() >0){
			try{ 
				sb.append("<script language='javascript'>\n");
				sb.append("alert('");
				sb.append(str);
				sb.append("');\n");
				sb.append("history.back();\n");
				sb.append("</script>\n");

				rOut.print(sb.toString());
			}catch(Exception e){
				rOut.print(e);
			}
		}
		
	}

	/***** script alert out String Use jspWriter *****/
	public static void scriptOut(javax.servlet.jsp.JspWriter rOut,String str) throws Exception{
		StringBuffer sb = new StringBuffer();
		if (str!=null || str.length() >0){  
			try{ 
				sb.append("<script language='javascript'>\n");
				sb.append(str);
				sb.append("\n");
				sb.append("</script>");

				rOut.print(sb.toString());
			}catch(Exception e){
				rOut.print(e);
			}
			
		}
		
	}

	//***** String Cut + ... *****//
	public static String addDot(String str, int i) {
        if (str==null || str.length() < 1) return "";
        String tmp = str;
        if(tmp.length()>i) tmp=tmp.substring(0,i)+"...";
        return tmp;
	}
	
	
	public static String cutTitle(String str, int len, String tail, String retVal){ 
		if( str==null || str.length() < 1 )	return retVal;
		int txtlen = str.length(); 
		int cnt = 0, index = 0; 

		while (index < txtlen && cnt < len) { 
			if (str.charAt(index++) < 256) { // 1바이트 문자라면... 
				cnt++; // 길이 1 증가 
			} else { // 2바이트 문자라면... 
				cnt += 2; // 길이 2 증가 
			} 
		} 
		if (index < txtlen) { 
			str = str.substring(0, index) + tail; 
		} 
		return str; 

	} 
	/** 
	*게시판 제목 같은 글을 원하는 길이로 자릅니다. 
	*한글( or 한글 + 영어) 제목을 자르면 깨지는걸 막기위한 메소드이다. 
	*반환될 String 의 길이는 len과 tail의 length를 더한 길이가 될 것이다. 
	*마지막 character가 공백이면 이 공백은 제거된다. 
	*@param str : 원래의 글 
	*@param len : 자르고자 하는 길이 
	*@param tail : len 만큼 자르고 뒤에 붙일 꼬리글 
	*/ 
	public static String cutTitle(String str, int len,String tail){ 
		if( str==null ){
			return "";
		}
		if( str.length() <= len){ 
			return str; 
		} 
		StringCharacterIterator sci = new StringCharacterIterator(str);
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(sci.first()); 
		for(int i=1; i<len ; i++){ 
			if( i < len-1){ 
				buffer.append(sci.next()); 
			}else{ 
				char c=sci.next(); 
				if(c != 32){ //마지막 charater가 공백이 아닐경우 
				buffer.append(c); 
				} 
			} 
		} 
		buffer.append(tail); 
		return buffer.toString(); 
	} 

	public static String cutTitle(String str, int len){ 
		if( str==null ){
			return "";
		}
		if( str.length() <= len){ 
			return str; 
		} 
		StringCharacterIterator sci = new StringCharacterIterator(str);
		StringBuffer buffer = new StringBuffer(); 
		buffer.append(sci.first()); 
		for(int i=1; i<len ; i++){ 
			if( i < len-1){ 
				buffer.append(sci.next()); 
			}else{ 
				char c=sci.next(); 
				if(c != 32){ //마지막 charater가 공백이 아닐경우 
				buffer.append(c); 
				} 
			} 
		} 
		buffer.append("..."); 
		return buffer.toString(); 
	}



	//***** html 모드일 경우만 사용할 것 자동으로 링크 생성 *****//
	public static String wwwLink(String str) {
        if (str==null) return "";
        
        String tmp = str;
        int itmp = 0;
        int wend = 0;
 
        StringBuffer sb = new StringBuffer();
        sb.append("");
        
        while(tmp.indexOf("http://")>-1) {
                itmp = tmp.indexOf("http://");
                wend = tmp.indexOf(" ",itmp);
                if (wend>tmp.indexOf("\r",itmp)) wend = tmp.indexOf("\r",itmp);
                if (wend>tmp.indexOf("<",itmp)) wend = tmp.indexOf("<",itmp);
                else if (wend==-1) wend = tmp.length();
                sb.append(tmp.substring(0,itmp));
        
                if(itmp>3 && tmp.substring(itmp-3,itmp).indexOf("=")>-1) {
                wend = tmp.indexOf("</a>",itmp)+3;
                if (wend==2) wend = tmp.indexOf(">",itmp);
                sb.append(tmp.substring(itmp,wend));
                } else {
                sb.append("<a href=\""+
                    tmp.substring(itmp,wend)+"\" target=\"_blank\" class=\"ok-2\">");
                sb.append(tmp.substring(itmp,wend));
                sb.append("</a>");
                }
        
                tmp=tmp.substring(wend);
        }
        sb.append(tmp);
        
        tmp = sb.toString();
        sb.setLength(0);
 
        while(tmp.indexOf("www.")>-1) {
                itmp = tmp.indexOf("www.");
                wend = tmp.indexOf(" ",itmp);
                if (wend>tmp.indexOf("\r",itmp)) wend = tmp.indexOf("\r",itmp);
                if (wend>tmp.indexOf("<",itmp)) wend = tmp.indexOf("<",itmp);
                if (wend==-1) wend = tmp.length();
                sb.append(tmp.substring(0,itmp));
                if(itmp>10 && tmp.substring(itmp-10,itmp).indexOf("=")>-1) {
                wend = tmp.indexOf("</a>",itmp)+3;
                if (wend==2) wend = tmp.indexOf(">",itmp);
                sb.append(tmp.substring(itmp,wend));
                } else {
                sb.append("<a href=\"http://"+
                    tmp.substring(itmp,wend)+"\" target=\"_top\" class=\"ok-2\">");
                sb.append(tmp.substring(itmp,wend));
                sb.append("</a>");
 
                }
        
                tmp=tmp.substring(wend);
        }
        sb.append(tmp);
 
        return sb.toString();
 
	}

	//***** 콤마 있는 스트링 값을 숫자로 변환 *****//
	public static int comToInt(String str,int retVal) {
		if(str==null || str.length() < 1){
			return retVal;
		}else{
			try{ 
				String val = "";
				for( int i=0 ; i<str.length() ; i++ ){
					if( Character.isDigit( str.charAt(i) ) ){
						val += str.charAt(i);
					}
				}
				return Integer.parseInt(val);
			}catch(Exception e){
			   return retVal;
			}
		}
	}

	public static long comToLong(String str,long retVal) {
		if(str==null || str.length() < 1){
			return retVal;
		}else{
			try{ 
				String val = "";
				for( int i=0 ; i<str.length() ; i++ ){
					if( Character.isDigit( str.charAt(i) ) ){
						val += str.charAt(i);
					}
				}
				return Long.parseLong(val);

			}catch(Exception e){
			   return retVal;
			}
		}
	}

	public static double comToDouble(String str,double retVal) {
		if(str==null || str.length() < 1){
			return retVal;
		}else{
			try{ 
				String val = "";
				for( int i=0 ; i<str.length() ; i++ ){
					if( Character.isDigit( str.charAt(i) ) || str.charAt(i)=='.' ){
						val += str.charAt(i);
					}
				}
				return Double.parseDouble(val);
			}catch(Exception e){
			   return retVal;
			}
		}
	}
	

	//***** 숫자를 ,있는 문자로 변환 1,000,000,000  이런식 *****//
	public static String intToCom(int value) {
		boolean minus = false;
		if(value < 0){
			value = Math.abs(value);
			minus = true;
		}
		if (value<1000) {
			if(minus==false){
				return value+"";
			}else{
				return "-"+value;
			}
		}
		
		String str = null;
		while (value>999) {
			if (str==null) {
				str = formatDigit(value%1000,3)+"";
			} else {
				str = formatDigit(value%1000,3)+","+str;
			}
			value = value/1000;
		}
		str = value+","+str;
		if(minus==true){
			str = "-"+str;
		}
		return str;
	}

	//***** 숫자를 ,있는 문자로 변환 1,000,000,000  이런식 *****//
	public static String longToCom(long value) {
		boolean minus = false;
		if(value < 0){
			value = Math.abs(value);
			minus = true;
		}
		if (value<1000) {
			if(minus==false){
				return value+"";
			}else{
				return "-"+value;
			}
		}
		
		String str = null;
		while (value>999) {
			if (str==null) {
				str = formatDigit(value%1000,3)+"";
			} else {
				str = formatDigit(value%1000,3)+","+str;
			}
			value = value/1000;
		}
		str = value+","+str;
		if(minus==true){
			str = "-"+str;
		}
		return str;
	}

	//***** 숫자를 ,있는 문자로 변환 1,000,000,000  이런식 *****//
	public static String intToCS(int value) {
		boolean minus = false;
		if(value < 0){
			value = Math.abs(value);
			minus = true;
		}
		if (value<1000) {
			if(minus==false){
				return value+"";
			}else{
				return "-"+value;
			}
		}
		
		String str = null;
		while (value>999) {
			if (str==null) {
				str = formatDigit(value%1000,3)+"";
			} else {
				str = formatDigit(value%1000,3)+","+str;
			}
			value = value/1000;
		}
		str = value+","+str;
		if(minus==true){
			str = "-"+str;
		}
		return str;
	}
	

	//한자리 숫자에 0을 추가해서 리턴
	public static String addZero(String str){
		
		if (str.length()==1) str="0"+str;
		return str;
	}

	
	//New인지 아닌지를 체크, New이면 true 아니면 false를 반환
	public static boolean newCheck(String setDate, int intaval){

		String lsYear=getDate("yyyy");
		String lsMonth=getDate("MM");
		String lsDay=getDate("dd");
		
		lsMonth=addZero(lsMonth);
		lsDay=addZero(lsDay);

		String lsSet_Date=lsYear+lsMonth+lsDay;

		if((Integer.parseInt(lsSet_Date)-intaval) <= Integer.parseInt(setDate)) return true;
		else return false;
	}

	/*
	 * @param  original value
	 * @return encoded value
	 */
	public static Paint getPaint(String GradColor) {
		 return getPaint(GradColor, GradColor);
	}
	
	public static Paint getPaint(String initGradColor, String finalGradColor) {
		 return new GradientPaint(0, 0, getColor(initGradColor), 1000, 0, getColor(finalGradColor));
	}
	
	public static Color getColor(String RGBcolor) {
		int r_color = Integer.parseInt(RGBcolor.substring(0,2),16);
		int g_color = Integer.parseInt(RGBcolor.substring(2,4),16);
		int b_color = Integer.parseInt(RGBcolor.substring(4,6),16);
		
		return new Color(r_color, g_color, b_color);
	}
	

		public static String ksc5601(String Unicodestr)
	{

		String str = null;

		try
		{
			if (Unicodestr == null)
			{
				return	null;
			}

			str = new String(Unicodestr.getBytes("8859_1"), "KSC5601");

		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return	str;
	}

	/**
	 * KSC5601 -> ISO8859_1 로 변경 시킨다.
	 * 
	 * @param	Unicodestr	java.lang.String.  KSC5601 캐릭터 셋.
	 * @return	java.lang.String	ISO8859_1로 변환된 캐릭터 셋.
	 */
	public static String iso8859(String Unicodestr)
	{

		String str = null;

		try
		{
			if (Unicodestr == null)
			{
				return	null;
			}

			str = new String(Unicodestr.getBytes("KSC5601"), "8859_1");

		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		return	str;
	}

	public static int chkToInt(String val){
		if( KUtil.nchk(val).length() < 1 ){
			return 0;
		}else{
			return Integer.parseInt(val);
		}
	}

	public static String getTimeMillis(){
		
		return Long.toString(Calendar.getInstance().getTimeInMillis());

	}

	public static boolean fileDel(String dir, String fileName){
		if(dir == null || fileName == null || dir.length() < 1 || fileName.length() < 1){
			return false;
		}
		File file = new File(dir, fileName);
		return file.delete();

	}

	//text 파일 읽어 들이기
	public static String fileRead(String dir, String fileName){

		if(dir == null || fileName == null || dir.length() < 1 || fileName.length() < 1){
			return null;
		}
		
		File file = new File(dir, fileName);
		
		BufferedReader reader = null;
		StringBuffer sb = null;
		try{
			
			reader = new BufferedReader(new FileReader(file), 65536);
			sb = new StringBuffer();
			String strContent = "";
			
			while( (strContent = reader.readLine()) != null){
				sb.append(strContent+"\n");
			}//while

		}catch(Exception e){
		   return null;
		}finally{
			try{ if(reader != null){ reader.close(); }	}catch(Exception e){}
		}
		
		

		return sb.toString();

	}
	
	//text 문서 저장
	public static boolean fileSave(String dir, String fileName, String content){
		if(dir == null || fileName == null || dir.length() < 1 || fileName.length() < 1){
			return false;
		}
		
		FileOutputStream outstream = null;

		try{
			File file = new File(dir, fileName);
			outstream = new FileOutputStream(file); 

			int curByte=0;

			for( int i=0 ; i < content.length() ; i++ ) { 
				curByte = content.charAt(i); 
				outstream.write(curByte); 
			} 			
		}catch(Exception e){
		   return false;
		}finally{
			try{ if(outstream != null) outstream.close(); }catch(Exception e){}			   
		}
		
		return true;
	}

	//파일 복사
	public static boolean fileCopy(File in, File out) throws Exception{
		
		FileInputStream fis  = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		try{ 
			fis  = new FileInputStream(in);
			fos = new FileOutputStream(out);
			byte[] buf = new byte[1024];//1024바이트씩 읽어서 처리한다.

			int i = 0;
			while((i=fis.read(buf))!=-1) {
				   fos.write(buf, 0, i);
			}
		}catch(Exception e){
		   System.out.println(""+e+" error");
		   return false;
		}finally{
			fis.close();
			fos.close();
		}
		return true;
	}

	//특정 디렉토리 파일 전체 삭제
	public static boolean dirDel(File file) throws Exception{
		
		try{ 
			if(!file.isDirectory()){
				return false;
			}
			
			File[] arrFile = file.listFiles();
			for(int i=0 ; i<arrFile.length ; i++ ){
				boolean flag = arrFile[i].delete();
				System.out.println("flag::::"+flag);
			}
			
		}catch(Exception e){
		   System.out.println(""+e+" error");
		   return false;
		}finally{
		}
		return true;
	}


	public static int intToSub(int num, int st, int en) throws Exception{
		try{ 
			String strNum = Integer.toString(num);
			return Integer.parseInt(strNum.substring(st,en));
		}catch(Exception e){
		   return 0;
		}
		
	}

	public static int cutDate(String str, int st, int ed,int retVal) {
		try{
			if( KUtil.nchk(str).length() < ed ){
				return retVal;
			}
			
			if( st == -1 && ed != 0 )
				return Integer.parseInt( str.substring(ed) );
			else
				return Integer.parseInt( str.substring(st,ed) );
		}catch(Exception e){
			System.out.print(e.toString());
			return retVal;
		}
	}
	public static int cutDate(int inputval, int st, int ed,int retVal) {
		try{
			String str = Integer.toString(inputval);
			if( KUtil.nchk(str).length() < ed ){
				return retVal;
			}
			
			if( st == -1 && ed != 0 )
				return Integer.parseInt( str.substring(ed) );
			else
				return Integer.parseInt( str.substring(st,ed) );
		}catch(Exception e){
			System.out.print(e.toString());
			return retVal;
		}
	}

	public static String arrStrDateToStr(String arrStrDate,String seperator,String retVal){
		try{
			String val = "";
			if( KUtil.nchk(arrStrDate).length() < 1 ){
				return retVal;
			}

			String[] arrStr = arrStrDate.split("\n");
			for( int i=0 ; i<arrStr.length ; i++ ){
				if( KUtil.nchk(arrStr[i]).length() > 0 ){
					if( i != 0 ) val += seperator;
					val += KUtil.dateMode(KUtil.dateToInt(arrStr[i],0),"yyyyMMdd","yy.MM.dd","");
				}			
			}

			return val;
		}catch(Exception e){
			System.out.println(e.toString()+"arrStrDateToStr(String arrStrDate)");
			return null;
		}
	}
}
