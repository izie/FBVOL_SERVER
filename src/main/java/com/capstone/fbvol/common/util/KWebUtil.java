package com.capstone.fbvol.common.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class KWebUtil
{
	/**
	 * ��Ű�Է� 
	 * @param response
	 * @param domain
	 * @param name
	 * @param value
	 * @param iTime
	 */
	public static void setCookie(HttpServletResponse response,String domain, 
                                 String name, String value, int iTime) {
        value = java.net.URLEncoder.encode(value);
        Cookie cookie = new Cookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath("/");
        cookie.setMaxAge(iTime);
        response.addCookie(cookie);
	}
	/**
	 * ��Ű�Է�
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void setCookie(HttpServletResponse response,
                                 String name, String value) {
        value = java.net.URLEncoder.encode(value);
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60*60*24*15);
        response.addCookie(cookie);
	}
	/**
	 * ��Ű��������
	 * @param request
	 * @param cookieName
	 * @return
	 * @throws Exception
	 */
	public static String getCookie(HttpServletRequest request,
                                   String cookieName) throws Exception {
        Cookie [] cookies = request.getCookies();
        if (cookies==null) return "";
        String value = "";
        for(int i=0;i<cookies.length;i++) {
                if(cookieName.equals(cookies[i].getName())) {
                        value = java.net.URLDecoder.decode(cookies[i].getValue());
                        break;
                }
        }
        return value;
	}
	/**
	 * ���� URL ��������
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static String getNextUrl(HttpServletRequest req)throws Exception {
		String requestURI = req.getRequestURI();
		String queryString = req.getQueryString();
			
		StringBuffer ret = new StringBuffer();
		ret.append(requestURI);
		
		if(queryString != null){
			ret.append("?").append(queryString);
		}else{
			ret.append(KUtil.nchk(req.getParameter("nextUrl")));
		}
		
		return KWebUtil.encode(ret.toString());
	}
	/**
	 * ���� URL ��������
	 * @param req
	 * @param encode
	 * @return
	 * @throws Exception
	 */
	public static String getNextUrl(HttpServletRequest req,int encode)throws Exception {
		String requestURI = req.getRequestURI();
		String queryString = req.getQueryString();
			
		StringBuffer ret = new StringBuffer();
		ret.append(requestURI);
		
		if(queryString != null){
			ret.append("?").append(queryString);
		}else{
			ret.append(KUtil.nchk(req.getParameter("nextUrl")));
		}
		if( encode == 1 ){
			return KWebUtil.encode(ret.toString());
		}
		return ret.toString();
	}
	/**
	 * ���� URL ��������
	 * @param req
	 * @param charSet
	 * @return
	 * @throws Exception
	 */
	public static String getNextUrl(HttpServletRequest req,String charSet)throws Exception {
		String requestURI = req.getRequestURI();
		String queryString = req.getQueryString();
			
		StringBuffer ret = new StringBuffer();
		ret.append(requestURI);
		
		if(queryString != null){
			ret.append("?").append(queryString);
		}else{
			ret.append(KUtil.nchk(req.getParameter("nextUrl")));
		}
		
		if(charSet == null || charSet.length() < 1){
			return ret.toString();
		}
		return KWebUtil.encode(ret.toString());
	}
	/**
	 * UTF-8 ���ڵ�
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String encode(String str)throws Exception{
		
		if(str == null || str.length() < 1){
			return "";
		}

		return java.net.URLEncoder.encode(str,"UTF-8");
	}
	/**
	 * ���ϴ� �ɸ��ͼ����� ���ڵ�
	 * @param str
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String encode(String str, String charset)throws Exception{
		
		if(str == null || str.length() < 1){
			return "";
		}

		return java.net.URLEncoder.encode(str, charset);
	}
	/**
	 * UTF-8 ���ڵ�
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String decode(String str)throws Exception{
		
		if(str == null || str.length() < 1){
			return "";
		}

		return java.net.URLDecoder.decode(str, "UTF-8");
	}
	/**
	 * ���ϴ� �ɸ��� ������ ���ڵ�
	 * @param str
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static String decode(String str, String charset)throws Exception{
		
		if(str == null || str.length() < 1){
			return "";
		}

		return java.net.URLDecoder.decode(str, charset);
	}
}
