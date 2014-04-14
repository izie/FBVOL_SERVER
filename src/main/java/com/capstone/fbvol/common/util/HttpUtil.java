package com.capstone.fbvol.common.util;

import com.capstone.fbvol.model.Entity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URLEncoder;

/***
 *   // - http://1co.simpledesign.co.kr/member_proc.php?exec=sjoin 1인창조기업 회원가입시 회원등록함
  //  http://1co.simpledesign.co.kr/member_proc.php?exec=skey  회원 등록할 URL 세션 키값
 * @author cw
 *
 */
public class HttpUtil {  
	  /**
	   * 
	   * @return
	   */
	public static String getSid() {
	    	String responseBody ="";
	    	try {
	    	   DefaultHttpClient httpclient = new DefaultHttpClient();
 		        HttpGet httpget = new HttpGet("http://1co.simpledesign.co.kr/member_proc.php?exec=skey"); 

		        System.out.println("getSid request " + httpget.getURI());

		        // Create a response handler
		        ResponseHandler<String> responseHandler = new BasicResponseHandler();
		          responseBody = httpclient.execute(httpget, responseHandler);
		        //System.out.println(responseBody);
		         
		        // When HttpClient instance is no longer needed, 
		        // shut down the connection manager to ensure
		        // immediate deallocation of all system resources
		        httpclient.getConnectionManager().shutdown();  
		        httpget = null;
		        httpclient = null;
		       
	    	} catch(Exception ex){ 
	    		 System.out.println(ex.getStackTrace());
	    	}
	    	finally{ 
	    		 return responseBody;
	    	}
	    } 
	/**
	 * http://1co.simpledesign.co.kr/member_proc.php?exec=sjoin 1인창조기업 회원가입시 회원등록함
	 * 회원 등록 폼을 날림
	 *  true;이면 정상 등록 , false이면 등록안됨 
	 *  // - http://1co.simpledesign.co.kr/member_proc.php?exec=sjoin 1인창조기업 회원가입시 회원등록함
  //  http://1co.simpledesign.co.kr/member_proc.php?exec=skey  회원 등록할 URL 세션 키값
  // user_id , passwd  ,name    , email, sid
  // 맨토링 관련 사이트 등록  
	 * @return
	 */
	public static String reg1CoRegMember(Entity ety) {
    	String responseBody ="";
    	try {
    	   DefaultHttpClient httpclient = new DefaultHttpClient();
    	   String user_id = ety.getString("user_id");
    	   String passwd = ety.getString("passwd");
    	   // String name = ety.getString("name");
    	    String email = ety.getString("email");
    	   // System.out.println("reg1CoRegMember ety: " + ety.toString());
    	    //System.out.println("reg1CoRegMember name1 " + ety.getString("name"));
    	    String name =  URLEncoder.encode(ety.getString("name"),"euc-kr"); 
    	    //System.out.println("reg1CoRegMember name2 " + name);
    	    
    	  // String email = URLEncoder.encode(ety.getString("email"),"euc-kr");  
    	   String _sid  = HttpUtil.getSid();
    	   // 회원등록 URL
    	   String sUrl = "http://1co.simpledesign.co.kr/member_proc.php?exec=sjoin";
    	   sUrl += "&user_id="+user_id;
    	   sUrl += "&passwd="+passwd;
    	   sUrl += "&name="+name;
    	   sUrl += "&email="+email; 
    	   sUrl += "&sid="+_sid;
    	   //
		     HttpGet httpget = new HttpGet(sUrl);  	
	        System.out.println("reg1CoRegMember request " + httpget.getURI());

	        // Create a response handler
	        ResponseHandler<String> responseHandler = new BasicResponseHandler();
	        responseBody = httpclient.execute(httpget, responseHandler);
	        
	        httpclient.getConnectionManager().shutdown();  
	        httpget = null;
	        httpclient = null;
	       
    	} catch(Exception ex){ 
    		 System.out.println(ex.getStackTrace());
    	}
    	finally{ 
    		 return responseBody;
    	}
    } 
}
