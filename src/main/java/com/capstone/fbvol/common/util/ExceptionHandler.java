package com.capstone.fbvol.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 예외를 받아 적절한 메세지로 변환하여 리턴해주는 클래스
 */
public class ExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	public static String getErrorMessage(Exception e) {
		
		StackTraceElement[] ste = e.getStackTrace();
		String className = ste[0].getClassName();
		String methodName = ste[0].getMethodName();
		int lineNumber = ste[0].getLineNumber();
		String fileName = ste[0].getFileName();
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("오류가 발생하였습니다.<br><br>")
		.append(className)
		.append(".")
		.append(methodName)
		.append("() ")
		.append(fileName)
		.append(" ")
		.append(lineNumber)
		.append(" line.")
		.append("<br>")
		.append("[Error] : ")
		.append(e.toString());
		
		logger.error(className+"."+methodName+"() "+fileName+" "+lineNumber+" line.");
		logger.error("[ERROR] : " + e.toString());
		
		return sb.toString();
	}
	
}
