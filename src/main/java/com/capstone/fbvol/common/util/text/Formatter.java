package com.capstone.fbvol.common.util.text;

/**
 * <p>Title: giro INTERNET GIRO</p>
 * <p>Description: Format ��� Utility</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: giro</p>
 * @author Sungju Kang(sonaki@giro.or.kr)
 * @version 1.0
 */

import java.text.NumberFormat;

public class Formatter
{
	public final static int FILL_LEFT = 1;        // ����ä��
	public final static int FILL_RIGHT = 2;       // ����ä��

	public final static char WILDCARD_CHAR = '*'; // ���ϵ�ī�� ����
	public final static char FILL_ZERO = '0';     // '0'���� ä��
	public final static char FILL_SPACE = ' ';    // SPACE�� ä��

	/**
	 * ���ڹ��ڿ��� �޸�(,) ����
	 * @param src ���ڹ��ڿ�
	 * @return �޸��� ���Ե� ���� ���ڿ�
	 */
	public static String commaMoney(String src)
	{
		try
		{
			return commaMoney(Double.parseDouble(src));
		}
		catch(Exception e)
		{
			return "";
		}
	}

	/**
	 * ���ڿ� �޸�(,) ����
	 * @param src �޸����� ����
	 * @return �޸��� ���Ե� ���� ���ڿ�
	 */
	public static String commaMoney(double src)
	{
		return NumberFormat.getInstance().format(src);
	}

	/**
	 * ���ڿ��� Ư���κ�(from~to)�� Ư�����ڷ� ��ȯ�Ͽ� ���
	 * @param src Ư�����ڿ�
	 * @param from ���κ�(from)
	 * @param to ���κ�(to)
	 * @param hideCharacter ��� Ư������
	 * @return Ư���κ��� ����� ���ڿ�
	 */
	public static String hide(String src, int from, int to, char hideCharacter)
	{
		if(src == null || from < 0 || to > src.length())
			return src;

		StringBuffer hideString = new StringBuffer();
		String part1 = src.substring(0, from);
//    String part2 = src.substring(to, src.length());  2003-03-17 ������
		String part2 = src.substring(to);

		for(int i = from; i < to; i++)
			hideString.append(hideCharacter);

		return part1 + hideString.toString() + part2;
	}

	/**
	 * ���� ���ڿ�(���ϵ�ī���̿밡��)���� ��(���̺񱳾���)
	 * @param target1 ù��°���ڿ�
	 * @param target2 �ι�°���ڿ�
	 * @return ���ϵ� ī�带 �����Ͽ� ���� ���ڿ����� ����(true:�������ڿ�/false:�ٸ����ڿ�)
	 */
	public static boolean isSameString(String target1, String target2)
	{
		return isSameString(target1, target2, false);
	}

	/**
	 * ���� ���ڿ�(���ϵ�ī���̿밡��)���� ��
	 * @param target1 ù��°���ڿ�
	 * @param target2 �ι�°���ڿ�
	 * @param isLengthCheck ���̺񱳵� �Ұ����� ����
	 * @return ���ϵ� ī�带 �����Ͽ� ���� ���ڿ����� ����(true:�������ڿ�/false:�ٸ����ڿ�)
	 */
	public static boolean isSameString(String target1, String target2, boolean isLengthCheck)
	{
		boolean result = true;

		if(target1 != target2)
		{
			int len1 = target1.length();
			int len2 = target2.length();

			if(!isLengthCheck || len1 == len2)
			{
				if(!target1.equals(target2))
				{
					for(int i = 0; i < len1 && i < len2; i++)
					{
						if(target1.charAt(i) != target2.charAt(i) &&
							 target1.charAt(i) != WILDCARD_CHAR &&
							 target2.charAt(i) != WILDCARD_CHAR)
						{
							result = false;
							break;
						}
					}
				}
			}
			else
				result = false;
		}

		return result;
	}

	/**
	 * �ش繮�ڿ��� �������� �˾ƺ�
	 * @param data �ش繮�ڿ�
	 * @return ���ڿ���(true:����/false:�׿��ǰ��)
	 */
	public static boolean isNumeric(String data)
	{
		for(int i = 0; i < data.length(); i++)
			if(data.charAt(i) < '0' || data.charAt(i) > '9')
				return false;
		return true;
	}


	public static int getRandomNumberBySize(int size) {

		int result = 0;

		for (int i=0; i < size; i++) {
			double num = getRandomNumber(10);
			double exponent = size - (i+1);
			double powNum = Math.pow(10, exponent);
			num = num * powNum;
			result += num;
		}

		return result;
	}

	/**
	 * random number ��
	 * @param max random number�� �ִ밪
	 * @return 0~max-1 ������ random ��
	 */
	public static int getRandomNumber(int max)
	{
		return (int)Math.round((Math.random() * max) - 0.5f);
	}

	public static String replace(String src, String findStr, String replaceStr)
	{
		if(src == null || findStr == null)
			return src;

		StringBuffer result = new StringBuffer();
		int findStrLen = findStr.length();
		int srcLen = src.length();
		int i;

		for(i = 0; i <= srcLen - findStrLen; i++)
		{
			String str = src.substring(i, i + findStrLen);
			if(str.equals(findStr))
			{
				result.append(replaceStr);
				i += findStrLen - 1;
			}
			else
				result.append(str.substring(0, 1));
		}

		if(i < srcLen)
			result.append(src.substring(i, srcLen));

		return result.toString();
	}

	public static String substring(String src, int length)
	{
		if(src != null && src.length() > length)
			return src.substring(0, length);
		else
			return src;
	}

	public static String nvl(String str, String replaceStr)
	{
		if(str == null || str.equals(""))
			return replaceStr;
		else
			return str;
	}

	public static String nvl(String str)
	{
		return nvl(str, "0");
	}

	/**
	 * ���ڿ��� �� ���ڿ� ���� FIX�۾�(ex)000-1000 -> -1000)
	 * @param strNum ���ڿ� ����
	 * @return FIX�� ���ڿ�
	 */
	public static String strNumberFix(String strNum)
	{
		if(strNum != null) {
			int idx = strNum.indexOf("-");
			if(idx > 0)
				strNum = strNum.substring(idx);
		}
		return strNum;
	}

}
