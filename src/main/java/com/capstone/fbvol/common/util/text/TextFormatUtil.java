package com.capstone.fbvol.common.util.text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;


/**
 * Text Format�� �ٷ궧 �ʿ��� ����� ��Ƴ��� Ŭ����. �ܾ�ٲٱ⳪ ã����...^^
 *
 * @author �� ��ȣ
 * @version 1.0
 */
public class TextFormatUtil {

	/**
	 * �־��� ���� ','�� ���� ��ȭ�� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� int�� ��ȭ Data
	 * @return			','�� ���� ��ȭ�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getMoneyFormat(123456789);
	 * System.out.println("Money : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * 
	 * Money : 123,456,789<br></PRE>
	 */
	public static String getMoneyFormat(int nVal) {
		String displayForm = new DecimalFormat("#,###,###,###").format(nVal);
		return displayForm;
	}
	/**
	 * �־��� ���� ','�� ���� ��ȭ�� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� long�� ��ȭ Data
	 * @return			','�� ���� ��ȭ�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getMoneyFormat(123456789);
	 * System.out.println("Money : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * 
	 * Money : 123,456,789<br></PRE>
	 */
	public static String getMoneyFormat(long nVal) {
		String displayForm = new DecimalFormat("#,###,###,###").format(nVal);
		return displayForm;
	}
	/**
	 * �־��� ���� ','�� ���� ��ȭ�� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� double�� ��ȭ Data
	 * @return			','�� ���� ��ȭ�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getMoneyFormat(123456789);
	 * System.out.println("Money : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * 
	 * Money : 123,456,789<br></PRE>
	 */
	public static String getMoneyFormat(double nVal) {
		String displayForm = new DecimalFormat("#,###,###,###").format(nVal);
		return displayForm;
	}
	/**
	 * �־��� ���� ','�� ���� ��ȭ�� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� String�� ��ȭ Data
	 * @return			','�� ���� ��ȭ�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getMoneyFormat(123456789);
	 * System.out.println("Money : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * 
	 * Money : 123,456,789<br></PRE>
	 */
	public static String getMoneyFormat(String strVal) {
		if(strVal==null || strVal.trim().equals("") || strVal.trim().equalsIgnoreCase("null")) return "0";

		double nVal = Double.parseDouble(strVal);
		String displayForm = new DecimalFormat("#,###,###,###").format(nVal);
		return displayForm;
	}


//----------------- 20041106�߰� -----------------------//
	/**
	 * �־��� ���� ','�� ���� ��ȭ�� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� Object�� ��ȭ Data
	 * @return			','�� ���� ��ȭ�� Object Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getMoneyFormat(123456789);
	 * System.out.println("Money : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * 
	 * Money : 123,456,789<br></PRE>
	 */
	public static String getMoneyFormat(Object objVal) {
        if (objVal == null) {
            return "";
		}
		String strVal  = objVal.toString();

		if(strVal==null || strVal.trim().equals("") || strVal.trim().equalsIgnoreCase("null")) return "0";

		double nVal = Double.parseDouble(strVal);
		String displayForm = new DecimalFormat("#,###,###,###").format(nVal);
		return displayForm;
	}
//----------------- 20041106�߰� -----------------------//

	
	/**
	 * �־��� ���� ','�� ���� Dollar�� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� String�� Dollar Data
	 * @return			','�� ���� Dollar�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getDollarFormat(123456789);
	 * System.out.println("Dollar Money : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * Dollar Money : 123,456,789.00<br></PRE>
	 */
	public static  String getDollarFormat(double dVal) {
		String displayForm = new DecimalFormat("#,###,###,##0.00").format(dVal);
		return displayForm;
	}

//----------------- 20040104�߰� -----------------------//
	/**
	 * �־��� ���� ','�� ���� Dollar�� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� String�� Dollar Data
	 * @return			','�� ���� Dollar�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getDollarFormat(123456789);
	 * System.out.println("Dollar Money : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * Dollar Money : 123,456,789.00<br></PRE>
	 */
	public static String getDollarFormat(Object objVal) {
        if (objVal == null) {
            return "";
		}
		String strVal  = objVal.toString();
		

		if(strVal==null || strVal.trim().equals("") || strVal.trim().equalsIgnoreCase("null")) return "0";

		double nVal = Double.parseDouble(strVal);
		String displayForm = new DecimalFormat("#,###,###,###").format(nVal);
		
		int index = strVal.indexOf(".");
		if(index != -1 ){
			String lastStrVal = strVal.substring(index);
			displayForm += lastStrVal;
		}
		return displayForm;
	}
//----------------- 20041106�߰� -----------------------//

	/**
	 * �־��� �� �տ� '0'�� ���� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  nVal		��ȯ�ؾ��ϴ� double�� Data
	 * @param  length	�����ؾ��ϴ� Data ����(nVal�� �����ϸ� ������ ��ŭ '0'���� ä���.)
	 * @return			nVal �տ� '0'���� ä�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getFillZeroFormat(1234,8);
	 * System.out.println("Number : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * Number : 00001234<br></PRE>
	 */
	public static String getFillZeroFormat(double nVal, int length) {
		String tmp = "";
		String displayForm = "";
		for(int i=0; i<length; i++) {
			tmp += "0";
		}
		
		if(tmp != null) {
			displayForm = new DecimalFormat(tmp).format(nVal);
		}
		
		return displayForm;
	}
	/**
	 * �־��� �� �ڿ� ' '�� ���� ��Ʈ������ ���� ������ �ش�.
	 *
	 * @param  strVal	��ȯ�ؾ��ϴ� String�� Data
	 * @param  length	�����ؾ��ϴ� Data ����(strVal�� �����ϸ� ������ ��ŭ ' '���� ä���.)
	 * @return			strVal �ڿ� '0'���� ä�� String Data
	 * <PRE><b>EX)</b>
	 * String strMoney = getFillZeroFormat(1234,8);
	 * System.out.println("Number : " + strMoney);
	 * <br><br><B>OUTPUT)</B>
	 * Number : 1234ssss(��, s�� Space�� ��� ǥ���Ͽ���.)<br></PRE>
	 */
	public static String getFillSpaceFormat(String strVal, int nLength) {

		int nCount = nLength - strVal.length();
		
		for(int i=0; i<nCount; i++) {
			strVal += " ";
		}
		
		return strVal;
	}
	/**
	 * �־��� ���� �����ڷ� ������ Vector�� �����Ѵ�.
	 *
	 * @param  strVal	�����ؾ��ϴ� String�� Data
	 * @param  strDelim	�����ؾ��ϴ� ������ �Ǵ� String�� Data
	 * @return			�����ڷ� ���� Vector
	 * <PRE><b>EX)</b>
	 * Vector vec = FormatUtil.getVTFromStringByDelim("1234|dasf|aaaa","|"); 
	 * System.out.println(vec.toString());
	 * <br><br><B>OUTPUT)</B>
	 * 1234, dasf, aaaa<br></PRE>
	 */
	public static Vector getVTFromStringByDelim(String strVal, String strDelim) {

		Vector vtVal = new Vector();
		
		StringTokenizer st = new StringTokenizer(strVal, strDelim);
		

	     while (st.hasMoreTokens()) {
	         vtVal.addElement(st.nextToken());
	     }
		
		return vtVal;
	}
	/**
	 * �־��� ���� YYYY.MM.DD������� �����Ѵ�.
	 * @param  data		��ȯ�ؾ��ϴ� String�� Data(YYYYMMDD ������� �޴´�.)
	 * @return			YYYY.MM.DD������� ���� String Data
	 */
	public static String getYYYYMMDDFormat(String data) {
		
		if(data==null || data.equals("")) return "";
		
 		try {
			int len = data.length();

			if(len==8) {
				data = data.substring(0,4) +"."+ data.substring(4,6) +"."+ data.substring(6,8);
			} else if (len>8) {
				data = data.indexOf("-")>-1 ? StringUtil.replace(data, "[-]", ".") : data;
				data = data.indexOf("/")>-1 ? StringUtil.replace(data, "[/]", ".") : data;
				data = data.substring(0, 10);
			}
			
			return data;
		} catch(Exception e) {
			return data;
		}
 	}

	
	/**
	 * �־��� ���� YYYY.MM.DD������� �����Ѵ�.
	 * @param  data		��ȯ�ؾ��ϴ� Object�� Data(YYYYMMDD ������� �޴´�.)
	 * @return			YYYY.MM.DD������� ���� String Data
	 */
	public static String getYYYYMMDDFormat(Object objVal) {

		if (objVal == null) {
            return "";
		}

		String data  = objVal.toString();

		return TextFormatUtil.getYYYYMMDDFormat(data);
 	}

	/**
	 * �־��� ���� HH:mm.ss������� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Object�� Data(HHmmss ������� �޴´�.)
	 * @return			HH:mm.ss������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strBirthday = FormatUtil.getYYYYMMDDFormat("123030");
	 * System.out.println("Birthday : " + strBirthday);
	 * <br><br><B>OUTPUT)</B>
	 * Birthday : 2005.01.04<br></PRE>
	 */
	public static String getHHmmssFormat(Object objVal) {

		if (objVal == null) {
            return "";
		}

		String temp = "";
		String data  = objVal.toString();

 		try {
			int len = data.length();

			if (len != 6) return data;

			temp = data.substring(0,2) + ":" + data.substring(2,4) + ":"
				+ data.substring(4,6);

			return temp;
		} catch(Exception e) {
			return temp;
		}
 	}

//----------------- 20041106�߰� -----------------------//


	/**
	 * �־��� ���� YYYY*MM*DD������� �����Ѵ�. ��, '*'�� �־��� �������̴�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� String�� Data(YYYYMMDD ������� �޴´�.)
	 * @param  delim	���� ǥ�ø� �ϴ� String�� Data
	 * @return			YYYY*MM*DD������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strBirthday = FormatUtil.getFormattedDate("20031008","@@");
	 * System.out.println("Birthday : " + strBirthday);
	 * <br><br><B>OUTPUT)</B>
	 * Birthday : 2003@@10@@08<br></PRE>
	 */
	public static String getFormattedDate(String data, String delim) {
 		try {
			
			if ( data==null || delim==null ) return "";
			
			String temp = "";
			int len = data.length();

			if (len != 8) return data;

			temp = data.substring(0,4) + delim + data.substring(4,6) + delim + data.substring(6,8);

			return temp;
		} catch(Exception e) {
			return data;
		}
 	}

//----------------- 20041106�߰�start -----------------------//
	/**
	 * �־��� ���� YYYY*MM*DD������� �����Ѵ�. ��, '*'�� �־��� �������̴�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Object�� Data(YYYYMMDD ������� �޴´�.)
	 * @param  delim	���� ǥ�ø� �ϴ� String�� Data
	 * @return			YYYY*MM*DD������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strBirthday = FormatUtil.getFormattedDate("20031008","@@");
	 * System.out.println("Birthday : " + strBirthday);
	 * <br><br><B>OUTPUT)</B>
	 * Birthday : 2003@@10@@08<br></PRE>
	 */
	public static String getFormattedDate(Object objVal, String delim) {
		if ( objVal==null || objVal==null ) return "";
		
		String temp = "";
		String data = objVal.toString();

		try {
			
			int len = data.length();

			if (len != 8) return data;

			temp = data.substring(0,4) + delim + data.substring(4,6) + delim + data.substring(6,8);

			return temp;
		} catch(Exception e) {
			return temp;
		}
 	}
//----------------- 20041106�߰�end-----------------------//

	
	/**
	 * �־��� Date���� form������� �����Ѵ�.
	 *
	 * @param  vDate	��ȯ�ؾ��ϴ� Date�� Data
	 * @param  form		��ȯ�ؾ��ϴ� �����̵Ǵ� format
	 * @return			form������� ���� String Data
	 * <PRE><b>EX)</b>
	 * Date currentTime_1 = new Date();
	 * String strBirthday = FormatUtil.getFormattedDate(currentTime_1,"yyyy.MM.dd G");
	 * System.out.println("Birthday : " + strBirthday);
	 * <br><br><B>OUTPUT)</B>
	 * Birthday : 2003.10.10 AD<br></PRE>
	 */
	public static String getFormattedDate(Date vDate, String form) {
 		try {
			if ( vDate==null || form==null ) return "";
			SimpleDateFormat sdf = new SimpleDateFormat(form);
			return sdf.format(vDate);
		} catch(Exception e) {
			return "null";
		}
 	}

	/**
	 * �־��� ���� ����ŷ���� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Card Number(16�ڸ�)
	 * @return			Card ǥ��������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getCardNoFormat("1234567890123456");
	 * System.out.println("CardNum : " + strCardNum);
	 * <br><B>OUTPUT)</B>
	 * CardNum : 1234-****-***2-345*<br></PRE>
	 */
	public static String getCardNoFormat(String data) {
 		try {
			
			if (data == null) return "";
			
			String temp = "";
			int len = data.length();

			if (len != 16 && len != 14) return data;

			if (len == 16)
				temp = data.substring(0,4) + "-****-***" + data.substring(11,12) + "-" + data.substring(12,15) + "*";
			else if (len == 14)
				temp = data.substring(0,4) + "-****-**" + data.substring(10);
				

			return temp;
		} catch(Exception e) {
			return data;
		}
 	}




//----------------- 20041106�߰� -----------------------//
	/**
	 * �־��� ���� ����ŷ���� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Card Number(16�ڸ�)
	 * @return			Card ǥ��������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getCardNoFormat("1234567890123456");
	 * System.out.println("CardNum : " + strCardNum);
	 * <br><B>OUTPUT)</B>
	 * CardNum : 1234-****-***2-345*<br></PRE>
	 */
	public static String getCardNoFormat(Object objVal) {
		if (objVal == null) return "";
		
		String temp = "";
		String data = objVal.toString();

		try {

			int len = data.length();

			if (len != 16) return data;

			// temp = data.substring(0,4) + "-****-***" + data.substring(11,12) + "-" + data.substring(12,15) + "*";
			temp = data.substring(0,4) + "-" + data.substring(4,9) + "-" + data.substring(9,11) + "-" 
					+ data.substring(11,12) + "-" + data.substring(12,16) ;

			return temp;
		} catch(Exception e) {
			return temp;
		}
 	}
//----------------- 20041106�߰� -----------------------//

	/**
	 * �־��� ���� ���ī�� ����ŷ���� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Card Number(16�ڸ�)
	 * @return			Card ǥ��������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getKiupCardNoFormat("1234567890123456");
	 * System.out.println("CardNum : " + strCardNum);
	 * <br><B>OUTPUT)</B>
	 * CardNum : ****-56**-9012-34**<br></PRE>
	 */
    public static String getKiupCardNoFormat(String data) {
 		try {
			
			if (data == null) return "";
			
			String temp = "";
			int len = data.length();

            //if (len != 16) return data;
            if (len != 16 && len != 14) return data;        //���̳ʽ�ī�� ó�� �߰�, 20050803 �ѱ�ȯ
 
            if (len == 16)
                temp = "****-" + data.substring(4,6)+"**-"+ data.substring(8,12) + "-" + data.substring(12,14) + "**";
            else
                temp = "****-" + data.substring(4,8)+"**-"+ data.substring(10,12)+ "**";

			return temp;
		} catch(Exception e) {
			return data;
		}
 	}

//----------------- 20041106�߰� -----------------------//
	/**
	 * �־��� ���� ���ī�� ����ŷ���� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Card Number(16�ڸ�)
	 * @return			Card ǥ��������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getKiupCardNoFormat("1234567890123456");
	 * System.out.println("CardNum : " + strCardNum);
	 * <br><B>OUTPUT)</B>
	 * CardNum : ****-56**-9012-34**<br></PRE>
	 */
    public static String getKiupCardNoFormat2(String data) {
		String temp = "";

		try {
			
			int len = data.length();

			if (len == 16) 
			{
				temp = data.substring(0,4) + "-" + data.substring(4,8) + "-" +  data.substring(8,12) + "-" 
					   + data.substring(12,16);
			}
			else if(len == 14)
			{
				temp = data.substring(0,4) + "-" + data.substring(4,10) + "-" +  data.substring(10,len);
			}
			else
			{
				return data;
			}
			return temp;
		} catch(Exception e) {
			return data;
		}
 	}

	/**
	 * �־��� ���� ���ī�� ����ŷ���� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Card Number(16�ڸ�)
	 * @return			Card ǥ��������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getKiupCardNoFormat("1234567890123456");
	 * System.out.println("CardNum : " + strCardNum);
	 * <br><B>OUTPUT)</B>
	 * CardNum : ****-56**-9012-34**<br></PRE>
	 */
    public static String getKiupCardNoFormat(Object objVal) {
		if (objVal == null) return "";
		
		String temp = "";
		String data = objVal.toString();

 		try {
			
			int len = data.length();

			if (len == 16) 
			{
				temp = data.substring(0,4) + "-" + data.substring(4,8) + "-" +  data.substring(8,12) + "-" 
					   + data.substring(12,len);
			}
			else if(len == 14)
			{
				temp = data.substring(0,4) + "-" + data.substring(4,10) + "-" +  data.substring(10,len);
			}
			else
			{
				return data;
			}
			return temp;
		} catch(Exception e) {
			return data;
		}
 	}
//----------------- 20041106�߰� -----------------------//
	
	
	/**
	 * �־��� ���� ����ŷ���� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Card Number(16�ڸ�)
	 * @param  delim	���� ǥ�ø� �ϴ� String�� Data
	 * @return			Card ǥ��������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getCardNoFormat("1234567890123456","@");
	 * System.out.println("CardNum : " + strCardNum);
	 * <br><B>OUTPUT)</B>
	 * CardNum : 1234-@@@@-@@@2-345@<br></PRE>
	 */
	public static String getCardNoFormat(String data, String delim) {
 		try {
			
			if ( data==null || delim==null ) return "";
			
			String temp = "";
			int len = data.length();

			if (len != 16) return data;

			temp = data.substring(0,4) + "-" + delim + delim + delim + delim + "-" + delim + delim + delim + data.substring(11,12) + "-" + data.substring(12,15) + delim;

			return temp;
		} catch(Exception e) {
			return data;
		}
 	}
	/**
	 * �־��� ���� ���ī�� ����ŷ���� �����Ѵ�.
	 *
	 * @param  data		��ȯ�ؾ��ϴ� Card Number(16�ڸ�)
	 * @param  delim	���� ǥ�ø� �ϴ� String�� Data
	 * @return			Card ǥ��������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getCardNoFormat("1234567890123456","@");
	 * System.out.println("CardNum : " + strCardNum);
	 * <br><B>OUTPUT)</B>
	 * CardNum : @@@@-@@78-9012-34@@<br></PRE>
	 */
	public static String getCardNoFormat2(String data, String delim) {
 		try {
			
			if ( data==null || delim==null ) return "";
			
			String temp = "";
			int len = data.length();

			if (len != 16) return data;

			temp = delim + delim + delim + delim + "-" + delim + delim + data.substring(6,8) + "-" + data.substring(8,12) + "-" +data.substring(12,14)+  delim   + delim;

			return temp;
		} catch(Exception e) {
			return data;
		}
 	}
	/**
	 * String�� null�̰ų� ��� Space�� Space 1��(" ")�� �ƴϸ� Trim()�Ͽ� �� �����Ѵ�.
	 *
	 * @param  str		�Է¹��� ��Ʈ��
	 * @return			Space 1��(" ")�� �ƴϸ� �Է¹��� String�� Trim()�� ��
	 * <PRE><b>EX)</b>
	 * String str = FormatUtil.N2S("as fg  123asdf   34    a");
	 * System.out.println("str : " + str);
	 * <br><B>OUTPUT)</B>
	 * str : as fg 123asdf 34 a<br></PRE>
	 */
	public static String N2S (String str) 
	{
		if (str == null) 
		{
			return " ";
		} 
		else 
		{
			if ( str.trim().equals("") ) 
			{
				return " ";
			} 
			else 
			{
				return str.trim();
			}
		}
	}
	/**
	 * String�� null�̰ų� ��� Space�� 0���� �ƴϸ� Integer�� ��ȯ�Ͽ� �� ����
	 *
	 * @param  str		�Է¹��� ��Ʈ��
	 * @return			0 �ƴϸ� �Է¹��� String�� Integer�� ��ȯ�� ��
	 * <PRE><b>EX)</b>
	 * int strToInt = FormatUtil.N2I("1234567");
	 * System.out.println("strToInt : " + (strToInt + 1));
	 * <br><B>OUTPUT)</B>
	 * strToInt : 1234568<br>
	 * String strTostr = FormatUtil.N2S("1234567");
	 * System.out.println("strTostr : " + (strTostr + 1));
	 * <br><B>OUTPUT)</B>
	 * strTostr : 12345671<br></PRE>
	 */
	public static int N2I (String str) throws NumberFormatException {
		if (str == null) {
			return 0;
		} else {
			if ( str.trim().equals("") ) {
				return 0;
			} else {
				return Integer.parseInt(str.trim());	
			}
		}
	}
	/**
	 * String�� null�̰ų� ��� Space�� 0.0���� �ƴϸ� Double�� ��ȯ�Ͽ� �� ����
	 *
	 * @param  str		�Է¹��� ��Ʈ��
	 * @return			0.0 �ƴϸ� �Է¹��� String�� Double�� ��ȯ�� ��
	 * <PRE><b>EX)</b>
	 * double strTodouble = FormatUtil.N2D("1234567.89");
	 * System.out.println("strTodouble : " + (strTodouble + 1.1));
	 * <br><B>OUTPUT)</B>
	 * strTodouble : 1234568.99<br></PRE>
	 */
	public static double N2D (String str) throws NumberFormatException {
		if (str == null) {
			return 0.0;
		} else {
			if ( str.trim().equals("") ) {
				return 0.0;
			} else {
				return Double.parseDouble(str.trim());	
			}
		}
	}

	/**
	 * String�� null�̰ų� ��� Space�� 0���� �ƴϸ� long���� ��ȯ�Ͽ� �� ����
	 *
	 * @param  str		�Է¹��� ��Ʈ��
	 * @return			0 �ƴϸ� �Է¹��� String�� long���� ��ȯ�� ��
	 * <PRE><b>EX)</b>
	 * long strTolong = FormatUtil.N2L("1234567");
	 * System.out.println("strToInt : " + (strTolong + 11));
	 * <br><B>OUTPUT)</B>
	 * strToInt : 1234578<br></PRE>
	 */
	public static long N2L (String str) throws NumberFormatException {
		if (str == null) {
			return 0;
		} else {
			if ( str.trim().equals("") ) {
				return 0;
			} else {
				return Long.parseLong(str.trim());	
			}
		}
	}
	/**
	 * Double�� ������ ��Ʈ������ ��ȯ�Ͽ� �� ����
	 *
	 * @param  str		�Է¹��� ��Ʈ��
	 * @return			������ ��Ʈ������ ��ȯ�� ��
	 * <PRE><b>EX)</b>
	 * String doubleTostr = FormatUtil.D2S("1234567.123");
	 * System.out.println("doubleTostr : " + (doubleTostr+123));
	 * <br><B>OUTPUT)</B>
	 * doubleTostr : 1234567.12123<br></PRE>
	 */
	public static String D2S (double dValue) throws NumberFormatException {
		DecimalFormat df = new DecimalFormat("#########################.##");
		return df.format(dValue);
	}
	/**
	 * \r\n ���� &lt;BR&gt;�� ��ȯ	
	 *
	 * @param  str		�Է¹��� ��Ʈ��
	 * @return			\r\n ���� &lt;BR&gt;�� ��ȯ�� ��
	 * <PRE><b>EX)</b>
	 * String str = CRLF2BR("Hello\r\nCHB&lt;br&gt;Card!\r\nWelcome To CHB World!!!");
	 * System.out.println("str : " + str);
	 * <br><br><B>OUTPUT)</B>
	 * str : Hello&lt;BR&gt;CHB&lt;br&gt;Card!&lt;BR&gt;Welcome To CHB World!!!</PRE>
	 */
	public static String crlf2br(Object obj)
	{
		String str = obj!=null ? obj.toString() : "";
		
		if (str == null) { return ""; }
		int length = str.length();
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < length; ++i)
		{
			String strComp = str.substring(i, i+1);
			if ("\r".compareTo(strComp) == 0)
			{
				strComp = str.substring(++i, i+1);
				if ("\n".compareTo(strComp) == 0) { strBuf.append("<BR>\r"); }
				else { strBuf.append("\r"); }
			}
			strBuf.append(strComp);
		}
		return strBuf.toString();
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	���� ��Ÿ���� String (������ y:��, m:��, w:��, d:��) Format -> (-):nnn:������
	 * @return			differ�� ��� ���� ���
	 * <PRE><b>EX)</b>
	 * Date day = new Date();
	 * System.out.println("Currentday : " + FormatUtil.getFormattedDate(day,"yyyy.MM.dd")); 
	 * day = FormatUtil.calculateDate(FormatUtil.getFormattedDate(day,"yyyyMMdd"),"-11d"); 
	 * day = FormatUtil.calculateDate(FormatUtil.getFormattedDate(day,"yyyyMMdd"),"-5m"); 
	 * day = FormatUtil.calculateDate(FormatUtil.getFormattedDate(day,"yyyyMMdd"),"-2y"); 
	 * System.out.println("\r\day : " + FormatUtil.getFormattedDate(day,"yyyy.MM.dd")); 
	 * <br><br><B>OUTPUT)</B>
	 * Currentday : 2003.10.10
	 * day : 2001.04.29 </PRE>
	 */
	public static Date calculateDate(String curDate, String differ) {
		
		int iYear	= 0;
		int iMonth	= 0;
		int iDate	= 0;
		
		Calendar vCalendar = Calendar.getInstance();
		
		try {

			iYear	= Integer.parseInt(curDate.substring(0,4));
			iMonth	= Integer.parseInt(curDate.substring(4,6)) - 1;
			iDate	= Integer.parseInt(curDate.substring(6,8));

		    int iDiffer = Integer.parseInt(differ.substring(0,differ.length()-1));
            char cFlag = differ.charAt(differ.length()-1);
			
			vCalendar.set(iYear, iMonth, iDate);

            switch(cFlag){
                case 'y' : vCalendar.add(Calendar.YEAR, iDiffer);break;
                case 'm' : vCalendar.add(Calendar.MONTH, iDiffer);break;
                case 'w' : vCalendar.add(Calendar.DATE, iDiffer*7);break;
                case 'd' : vCalendar.add(Calendar.DATE, iDiffer);break;
                default : break;
            }
			
			
		} catch(Exception ex) {

		}

		return vCalendar.getTime();
	}
	
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ����(day)�� ��Ÿ���� Integer
	 * @return			differ�� ��� ���� ���
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.daysAfter("20030124",-60); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 20021125 </PRE>
	 */
	public static String daysAfter(String curDate, int differ) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "00000000";

			tmpStr = differ + "d";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,"yyyyMMdd");
			
		} catch(Exception ex) {
			return "00000000";
		}
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� form������� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ����(day)�� ��Ÿ���� Integer
	 * @param  form		��ȯ�ؾ��ϴ� �����̵Ǵ� format
	 * @return			form������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.daysAfter("20030124",-60,"yyyy.MM.dd G"); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 2002.11.25 AD </PRE>
	 */
	public static String daysAfter(String curDate, int differ, String form) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "0000000000";

			tmpStr = differ + "d";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,form);
			
		} catch(Exception ex) {
			return "0000000000";
		}
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ��(week)�� ��Ÿ���� Integer
	 * @return			differ�� ��� ���� ���
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.weeksAfter("20030124",-8); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 20021129 </PRE>
	 */
	public static String weeksAfter(String curDate, int differ) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "00000000";

			tmpStr = differ + "w";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,"yyyyMMdd");
			
		} catch(Exception ex) {
			return "00000000";
		}
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� form������� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ��(week)�� ��Ÿ���� Integer
	 * @param  form		��ȯ�ؾ��ϴ� �����̵Ǵ� format
	 * @return			form������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.weeksAfter("20030124",-8,"yyyy.MM.dd G"); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 2002.11.29 AD </PRE>
	 */
	public static String weeksAfter(String curDate, int differ, String form) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "0000000000";

			tmpStr = differ + "w";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,form);
			
		} catch(Exception ex) {
			return "0000000000";
		}
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ��(month)�� ��Ÿ���� Integer
	 * @return			differ�� ��� ���� ���
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.monthsAfter("20030124",-4); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 20020924 </PRE>
	 */
	public static String monthsAfter(String curDate, int differ) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "00000000";

			tmpStr = differ + "m";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,"yyyyMMdd");
			
		} catch(Exception ex) {
			return "00000000";
		}
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� form������� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ��(month)�� ��Ÿ���� Integer
	 * @param  form		��ȯ�ؾ��ϴ� �����̵Ǵ� format
	 * @return			form������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.monthsAfter("20030124",-4,"yyyy.MM.dd G"); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 2002.09.24 AD </PRE>
	 */
	public static String monthsAfter(String curDate, int differ, String form) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "0000000000";

			tmpStr = differ + "m";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,form);
			
		} catch(Exception ex) {
			return "0000000000";
		}
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ��(year)�� ��Ÿ���� Integer
	 * @return			differ�� ��� ���� ���
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.yearsAfter("20030124",-6); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 19970124 </PRE>
	 */
	public static String yearsAfter(String curDate, int differ) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "00000000";

			tmpStr = differ + "y";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,"yyyyMMdd");
			
		} catch(Exception ex) {
			return "00000000";
		}
	}
	/**
	 * ������� ��Ÿ���� String�� �Է¹޾� differ�� ��� ����� ����Ͽ� form������� �����Ѵ�.
	 *
	 * @param  curDate	������� ��Ÿ���� String
	 * @param  differ	����� ��(year)�� ��Ÿ���� Integer
	 * @param  form		��ȯ�ؾ��ϴ� �����̵Ǵ� format
	 * @return			form������� ���� String Data
	 * <PRE><b>EX)</b>
	 * String day = FormatUtil.yearsAfter("20030124",-6,"yyyy.MM.dd G"); 
	 * System.out.println("day : " +day); 
	 * <br><br><B>OUTPUT)</B>
	 * day : 1997.01.24 AD </PRE>
	 */
	public static String yearsAfter(String curDate, int differ, String form) {
		
		Date vDate = new Date();
		String tmpStr = "";
		
		try {
			int len = curDate.length();
			if (len != 8) return "0000000000";

			tmpStr = differ + "y";
			vDate =  calculateDate(curDate, tmpStr);
			
			return getFormattedDate(vDate,form);
			
		} catch(Exception ex) {
			return "0000000000";
		}
	}
	/**
	 * �־��� ī���ȣ�� 4�ڸ� ����ǥ�� ������� �����Ѵ�.
	 *
	 * @param  cardno	ī���ȣ ����� String
	 * @return			����ǥ�� ������� ������ String
	 * <PRE><b>EX)</b>
	 * String strCardNum = FormatUtil.getCardnoFormat("9012345678901234"); 
	 * System.out.println("strCardNum : " +strCardNum); 
	 * <br><br><B>OUTPUT)</B>
	 * strCardNum : B123 </PRE>
	 */
	public static String getCardnoFormat(String cardno) {
		
		char char_f = cardno.charAt(0);
		String strTemp = cardno.substring(12,15);
		String str_GB = "";

		switch( char_f ) {
			
			case '3' :
						str_GB = "J";
						break;
			case '4' :
						str_GB = "V";
						break;
			case '5' :
						str_GB = "M";
						break;
			case '9' :
						str_GB = "B";
						break;
			default :
						str_GB = "V";
						break;
			
		}
		
		return str_GB + strTemp;
	}
	/**
	 * �־��� String�� �Ǹ��ȣ ǥ�� ������� �����Ѵ�.
	 *
	 * @param  juminno	�Ǹ��ȣ ����� String
	 * @return			�Ǹ��ȣ�� ���ڸ�(6)-���ڸ�(7) ������� ������ String
	 * <PRE><b>EX)</b>
	 * String strjuminNum = FormatUtil.getJuminNoFormat("7001011234567"); 
	 * System.out.println("strjuminNum : " +strjuminNum); 
	 * <br><br><B>OUTPUT)</B>
	 * strjuminNum : 700101-1234567 </PRE>
	 */
	public static String getJuminNoFormat(String juminno) {
		
		String szRtn = "";
 		try {

			
			int len = juminno.length();

			if (len != 13) return juminno;

			szRtn = juminno.substring(0,6) + "-" + juminno.substring(6,13) ;

		} catch(Exception e) {
			return juminno;
		}
		
		return szRtn;
	}
	/**
	 * �־��� String�� ����ŷ�� ���¹�ȣ ǥ�� ������� �����Ѵ�.
	 *
	 * @param  accNO	���¹�ȣ ����� String
	 * @return			���¹�ȣ�� ����ŷ�� ������� ������ String
	 * <PRE><b>EX)</b>
	 * String straccNO = FormatUtil.getEncAccountNo("50106123456"); 
	 * System.out.println("straccNO : " +straccNO); 
	 * <br><br><B>OUTPUT)</B>
	 * straccNO : 501****345* </PRE>
	 */
	public static String getEncAccountNo(String accNO) {
		
		String	szRtn = "";
		int		sLen = 0;

		try {
			sLen = accNO.trim().length();
			szRtn = accNO.trim().substring(0,sLen-8) + "****" + accNO.trim().substring(sLen-4,sLen-1)+ "*";
		} catch(Exception e) {
			return accNO;
		}
		return szRtn;
	}
	/**
	 * �־��� String�� ����ŷ�� ����ڹ�ȣ ǥ�� ������� �����Ѵ�.
	 *
	 * @param  bizNo	����ڹ�ȣ ����� String
	 * @return			����ڹ�ȣ�� ����ŷ�� ������� ������ String
	 * <PRE><b>EX)</b>
	 * String strbizNo = FormatUtil.getFormattedBizNo("1234567890"); 
	 * System.out.println("strbizNo : " +strbizNo); 
	 * <br><br><B>OUTPUT)</B>
	 * strbizNo : 123-45-67890 </PRE>
	 */
	public static String getFormattedBizNo(String bizNo) {
		
		String  szRtn = bizNo;
		int		sLen = 0;

		try {
			sLen = bizNo.trim().length();

			if (sLen==10) {
				szRtn = bizNo.substring(0,3) + "-" + bizNo.substring(3,5)+ "-" + bizNo.substring(5,10);
			}

		} catch(Exception e) {
			return szRtn;
		}
		
		return szRtn;
	}
	/**
	 * �־��� String�� null�̸� Space 1��(" ")�� �ƴϸ� Trim()�Ͽ� �����Ѵ�.
	 *
	 * @param  str		����ڹ�ȣ ����� String
	 * @return			" ", �ƴϸ� Trim() �� String
	 * <PRE><b>EX)</b>
	 * String str = FormatUtil.N2EMPTY("as  123   dkdk  "); 
	 * System.out.println("str : " +str); 
	 * <br><br><B>OUTPUT)</B>
	 * str : as 123 dkdk </PRE>
	 */
	public static String N2EMPTY (String str) 
	{
		if (str == null) 
		{
			return "";
		} 
		else 
		{
			if ( str.trim().equals("") ) 
			{
				return "";
			} 
			else 
			{
				return str.trim();
			}
		}
	}
	/**
	 * �־��� String�� ����ŷ�� �Ǹ��ȣ ǥ�� ������� �����Ѵ�.
	 *
	 * @param  juminno	�Ǹ��ȣ ����� String
	 * @return			�Ǹ��ȣ�� ����ŷ�� ������� ������ String
	 * <PRE><b>EX)</b>
	 * String strjuminNum = FormatUtil.getJuminFormat("7001011234567"); 
	 * System.out.println("strjuminNum : " +strjuminNum); 
	 * <br><br><B>OUTPUT)</B>
	 * strjuminNum : 700101-******* </PRE>
	 */
	public static String getJuminFormat(String juminno ) {
		
		String szRtn = "";
 		try {

			
			int len = juminno.length();

			if (len != 13) return juminno;

			szRtn = juminno.substring(0,6) + "-" +"*******" ;

		} catch(Exception e) {
			return juminno;
		}
		
		return szRtn;
	}
	/**
	 * �ѱ�,���� ��� 1byte�� ����ؼ� ó���Ͽ� ����� String�� ¥����.
	 * <%@ page contentType="text/html;charset=euc-kr" %> �ѱ����ڵ� ó��
	 * 
	 * @param  s		ó���� String Data
	 * @param  iLen		©�� Data ����
	 * @return			���ϴ� ���� ��Ŭ ©�� String
	 * <PRE><b>EX)</b>
	 * String strhangul = FormatUtil.strClip("Hangul : �ѱ� �� �����ϰ? �Ƹ��ٿ� ����Դϴ�.",30); 
	 * System.out.println("strhangul : " +strhangul); 
	 * <br><br><B>OUTPUT)</B>
	 * strhangul : �ѱ� 21C�� ���ص� �� </PRE>
	 */
	public static String strClip(String s, int iLen) {

		try {
			byte[] bRtn = s.getBytes();
			
			int iCut = iLen;
			int iMaxCnt = s.length();
	
			for(int i=0; i < bRtn.length; i++) {
				if(i > iLen-1) break;

				if(bRtn[i] < 0) {
					iCut--;
					i++;
				}
			}
			
			if(iCut > iMaxCnt) return s;
			
			return s.substring(0,iCut);
		}catch(Exception e) {
			return s;
		}
/*
		try {


			byte[] b = s.getBytes();
			int iCnt = b.length;

			//Jin �� �������� ���� ����. YIH 2003.04.04
			//if(iLen != s.length()) return s;
			if(iLen >= iCnt)
				return s;
			else {

				byte[] bRtn = new byte[iLen];
				
				int iRtn = 0;
				for(int i=0; i < iLen; i++) {
					bRtn[i] = b[i];
					if(bRtn[i] < 0) iRtn++;
				}


				if(iRtn%2!=0) {
					if(bRtn[iLen-1] < 0)
						bRtn[iLen-1] = (byte)0x20;
				}

				return new String(bRtn);
			}
		}
		catch(Exception e) {
			return "";
		}
*/
	}
	/**
	 * �Ϻ�ȣȭ�� 16�ڸ� Key�� ���ϱ� ���� �⺻����(�?��ȣ, ��������ȣ) �ڿ� 9�� ä��� �Լ�.
	 *
	 * @param  strConv	�?��ȣ, ��������ȣ ����� String
	 * @return			16�ڸ� Key ������� ������ String
	 * <PRE><b>EX)</b>
	 * String strConv = FormatUtil.makeEndecryptKEY("001012345678"); 
	 * System.out.println("strConv : " +strConv); 
	 * <br><br><B>OUTPUT)</B>
	 * strConv : 0010123456789999 </PRE>
	 */
	public static String makeEndecryptKEY(String strConv) {
		
		int iLen = strConv.length();
		String strTemp = strConv.toUpperCase();
		for (int i = (16 - iLen); i>0; i--) {
			strTemp += "9";
		}
		return strTemp;
	}


	//------------------------------ ����ö �߰� ------------------------------------//

	/**
	 * String ���ڰ��� Integer������ ��ȯ ��Ų��. <br>
	 * ���� Exception�߻�ÿ��� ������0�� �����Ѵ�.
	 * 
	 */
	public static int parseInt(final String arg) {
		try{
			return Integer.parseInt(arg.trim());
		}catch(NumberFormatException nfe){
			return 0;
		}
	}
	
	/**
	 * <pre>
	 * 
	 * ó�� ����
	 *    1. String ���ڰ��� long������ ��ȯ ��Ų��.
	 *    2. ���� Exception�߻�ÿ��� ������0�� �����Ѵ�.
	 * 
	 * Ư�� ����
	 * 
	 * ��� ���̺�
	 * 
	 * reference
	 * 
	 * </pre>
	 * 
	 * @param arg
	 * @return long
	 * @throws Exception
	 */
	public static long parseLong(final String arg) {
		try{
			return Long.parseLong(arg.trim());
		}catch(NumberFormatException nfe){
			return 0;
		}
	}
	
	/**
	 * <pre>
	 * 
	 * ó�� ����
	 *    1. String ���ڰ��� double������ ��ȯ ��Ų��.
	 *    2. ���� Exception�߻�ÿ��� ������0�� �����Ѵ�.
	 * 
	 * Ư�� ����
	 * 
	 * ��� ���̺�
	 * 
	 * reference
	 * 
	 * </pre>
	 * 
	 * @param arg
	 * @return double
	 * @throws Exception
	 */
	public static double parseDouble(final String arg) {
		try{
			return Double.parseDouble(arg.trim());
		}catch(NumberFormatException nfe){
			return 0;
		}
	}	



	/**
	 * �־��� String�� ����ŷ�� �ֹλ���ڹ�ȣ ǥ�� ������� �����Ѵ�.
	 *
	 * @param  bizNo	�ֹλ���ڹ�ȣ ����� String
	 * @return			�ֹλ���ڹ�ȣ�� ����ŷ�� ������� ������ String
	 * <PRE><b>EX)</b>
	 * #����ڹ�ȣ
	 * String Rbrn = FormatUtil.getFormattedRbrn("1234567890"); 
	 * System.out.println("Rbrn : " +Rbrn); 
	 * <br><br><B>OUTPUT)</B>
	 * strbizNo : 123-45-67890 </PRE>
	 * #�ֹι�ȣ
	 * String Rbrn = FormatUtil.getFormattedRbrn("1234567890123"); 
	 * System.out.println("Rbrn : " +Rbrn); 
	 * <br><br><B>OUTPUT)</B>
	 * strbizNo : 123456-7890123 </PRE>
	 */
	public static String getFormattedRbrn(String Rbrn) {
		
		String retRbrn  = "";
		int sLen		= 0;

		try {
			sLen = Rbrn.trim().length();
			
			// �ֹι�ȣ
			if(sLen == 13){
				retRbrn = Rbrn.substring(0,6) + "-*******";
			}// ����ڹ�ȣ
			else if (sLen == 10) {
				retRbrn = Rbrn.substring(0,3) + "-" + Rbrn.substring(3,5)+ "-" + Rbrn.substring(5,10);
			}

		} catch(Exception e) {
			return retRbrn;
		}
		
		return retRbrn;
	}


	/**
	 * �־��� String�� ����ŷ�� �ֹλ���ڹ�ȣ ǥ�� ������� �����Ѵ�.
	 *
	 * @param  Rbrn	�ֹλ���ڹ�ȣ ����� String
	 * @return			�ֹλ���ڹ�ȣ�� ����ŷ�� ������� ������ String
	 * <PRE><b>EX)</b>
	 * #����ڹ�ȣ
	 * String Rbrn = FormatUtil.getFormattedRbrnObj("1234567890"); 
	 * System.out.println("Rbrn : " +Rbrn); 
	 * <br><br><B>OUTPUT)</B>
	 * strbizNo : 123-45-67890 </PRE>
	 * #�ֹι�ȣ
	 * String Rbrn = FormatUtil.getFormattedRbrnObj("1234567890123"); 
	 * System.out.println("Rbrn : " +Rbrn); 
	 * <br><br><B>OUTPUT)</B>
	 * strbizNo : 123456-7890123 </PRE>
	 */
	public static String getFormattedRbrn(Object RbrnObj) {
		
        if (RbrnObj == null) {
            return "";
		}

		String retRbrn  = RbrnObj.toString();
		int sLen		= 0;

		try {
			sLen = retRbrn.trim().length();
			
			// �ֹι�ȣ
			if(sLen == 13){
				retRbrn = retRbrn.substring(0,6) + "-*******"; //+ "-" + retRbrn.substring(6,13) ;
			}// ����ڹ�ȣ
			else if (sLen == 10) {
				retRbrn = retRbrn.substring(0,3) + "-" + retRbrn.substring(3,5)+ "-" + retRbrn.substring(5,10);
			}

		} catch(Exception e) {
			return retRbrn;
		}
		
		return retRbrn;
	}

	/**
     * null2Void()
     * Object�� NULL�ΰ�� ������� �ƴѰ��� trim()����� String�� ���ϵȴ�.
     * 
     * @param obj
     * @return String
     */
    public static String null2Void(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj.toString().trim();
        }
    }


	/**
	 * slashCutDate()
	 * <p> 
	 * <pre> 
	 * ��¥�� �������� '/' ���� (��¥���)
	 * 2003/09/09  ==> 20030909 
	 * </pre>
	 * <p>
	 * ��� Table :
	 * Referencd Method : 
	 * <p>
	 * @param str
	 * @return String
	 */
	public static String slashCutDate(String str){
		
		str = strTrim(str);
		try{
			if( str.indexOf('/') == -1 ) return str;
			
			if (str.length() != 10){
				str = replaceStr(str, "/", "");
				return str;
			}

			if (String.valueOf(str.charAt(4)).equals("/") 
						&& String.valueOf(str.charAt(7)).equals("/")) {
							
				str = str.substring(0, 4) 
						+ str.substring(5, 7) 
						+ str.substring(8, 10);
			}
		} catch(Exception e) {
			return str;
		}

		return str;
	}


	/**
	 * strTrim()
	 * <p> 
	 * <pre> 
	 * ��Ʈ�� ���ڿ��� ��� ����
	 * </pre>
	 * <p>
	 * ��� Table :
	 * Referencd Method : 
	 * <p>
	 * @param str
	 * @return String
	 */
	public static String strTrim(String str){
		if (str!=null && !str.equals("")) {
			str = str.trim(); 
		} else {
			str = "";
		}
		return str;
	}


    /**
    * ��Ʈ���߿��� Ư����Ʈ���� ��ҹ��� �������� �����Ѵ�.
    * 
    * @param target  �ٲٷ��� ���ڿ��� ���� �� 
    * @param old  ã�� ���ڿ� 
    * @param newer  �ٲ��� ���ڿ� 
     */

    public static String replaceStr(String target, String old, String newer) {
        target = target.toUpperCase();
        old = old.toUpperCase();
		StringBuffer buf = new StringBuffer();
		try{

			int i = target.indexOf(old);
			if (i == -1) {
				return target;
			}   

			buf.append(target.substring(0, i) + newer);

			if (i + old.length() < target.length()) {
				buf.append(replaceStr(target.substring(i 
						+ old.length(), target.length()), old, newer));
			}
		} catch(Exception e) {
			return buf.toString();
		}

        return buf.toString();
        
    }
    
    public static String numberFormat(double number, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(number);
    }

    public static String numberFormat(float number, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(number);
    }

    public static String numberFormat(long number, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(number);
    }

    public static String numberFormat(int number, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(number);
    }

    public static String numberFormat(short number, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(number);
    }    
    
	public static String numberFormat(String number, String format) {
		if(number==null || number.trim().equals("") || number.trim().equalsIgnoreCase("null")) return "0";
		return numberFormat(Double.parseDouble(number), format);
	}
	
	public static String numberFormat(Object number, String format) {
		if(number==null || number.toString().trim().equals("") || number.toString().trim().equalsIgnoreCase("null")) return "0";
		return numberFormat(number.toString(), format);
	}
	
	

} //End of TextFormatUtil.java
