package com.capstone.fbvol.common.util;

import java.util.Vector;


public class StrUtil{
	
	//��Ʈ�� ���ڿ� �ڸ���
	public static String cutStr(String inVal, int stNum, int edNum, String retVal){
		try{
			
			if( inVal == null || inVal.length() < 1 || inVal.length() < edNum) return retVal;
			
			return inVal.substring(stNum, edNum);

		}catch(Exception e){
			System.out.print(e.toString());
			return null;
		}
	}
	//���ڿ� �ϳ� �ڸ���
	public static String[] strSplit(String val, String regex, String retVal) {
		
		String[] str = new String[2];

		if( val == null || val.trim().length() < 1){
			str[0] = retVal;
			str[1] = retVal;
			return str;
		}

		
		int idx = val.indexOf(regex);
		str[0] = val.substring(0, idx);
		str[1] = val.substring(idx+1);

		return str;
	}
	//��ü ���ڿ� ����
	public static Vector strSplitAll(String val, String regex, String retVal) {
		
		Vector vec = new Vector();
		while (val.indexOf(regex) > -1){
			String[] str = strSplit(val, regex, retVal);
			vec.add( KUtil.nchk(str[0], retVal) );
		    val = KUtil.nchk(str[1]);
			if (val == null || val.equals("")) {
				vec.add( KUtil.nchk(val, retVal) );
			}
		}
		
		return vec;
	}
		
}
