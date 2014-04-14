package com.capstone.fbvol.common.util;


public class SmsSender {
	private final String CODE = "130";
	private final String USER_CODE = "hostbank";
	private final String USER_NAME = "(주)호스트뱅크";
	private final String RDATE = "00000000";
	private final String RTIME = "000000";
	private final String DEPT_CODE = "ho-st-bnk";
	private final String DEPT_NAME = "(주)호스트뱅크";
	
	private String reqPhone1 = null;
	private String reqPhone2 = null;
	private String reqPhone3 = null;
	private Message message = new Message();
	
	public SmsSender() throws Exception {
			
			reqPhone1 = "011";
			reqPhone2 = "000";
			reqPhone3 = "0000";
		
	}

	public SmsSender(String hp,String hp1,String hp2) throws Exception {
		
		try{	
			reqPhone1 = hp;
			reqPhone2 = hp1;
			reqPhone3 = hp2;

		}catch(Exception e){
		   System.out.println(""+e+" error");
		}finally{
		}
		
	}
	
	public void send(String toName, String mobile1, String mobile2, String mobile3, String content) {
		System.out.println("toName :" + toName);
		System.out.println("mobile1 :" + mobile1);
		System.out.println("mobile2 :" + mobile2);
		System.out.println("mobile3 :" + mobile3);
		System.out.println("content :" + content);
		
		if(message == null) {
			System.out.println("message 객체가 널입니다");
		}

		message.sendMain(CODE, USER_CODE, USER_NAME, mobile1, mobile2, mobile3,
			content, RDATE, RTIME, reqPhone1, reqPhone2, reqPhone3, toName, DEPT_CODE, DEPT_NAME);
	}
	
	public void send(String mobile1, String mobile2, String mobile3, String content) {
		message.sendMain(CODE, USER_CODE, USER_NAME, mobile1, mobile2, mobile3,
			content, RDATE, RTIME, reqPhone1, reqPhone2, reqPhone3, "미지정", DEPT_CODE, DEPT_NAME);
	}
}
