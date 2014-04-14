package com.capstone.fbvol.common.util.text;

import com.capstone.fbvol.common.util.CookieUtil;
import com.capstone.fbvol.common.util.date.DateUtil;
import com.capstone.fbvol.model.Entity;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���ڿ� ó���� �ʿ��� ����� ��Ƴ��� Ŭ����. �ܾ�ٲٱ⳪ ã����.
 *
 * @author ���ع�
 * @version 1.2
 */
public class StringUtil {

    private static Logger logger = LogManager.getLogger(StringUtil.class);


    /**
     * strOrg���� strFrom�� strTo���ڿ��� �ٲٴ� ��ƾ
     *
     * @param String strOrg ���ڿ��̴�.
     * @param String strFrom ���ڿ����� �ٲ��� �� ���ڿ��̴�.
     * @param String strTo ���ڿ����� �ٲ� ���ڿ��̴�.
     * @return String �ٲ���� ���� �Ѱ��ش�.
     *
     */
     public static String replaceString(String strOrg, String strFrom, String strTo)
     {
         int last=0, next=0;
         String strResult = "";

         while (true) {
             next = strOrg.indexOf(strFrom, last);
             if (next >= 0 ) {
                 strResult += strOrg.substring(last, next) + strTo;
                 last = next + strFrom.length();
             } else {
                 strResult += strOrg.substring(last);
                 break;
             }
         }
         return strResult;
     }

    /**
     * ��Ʈ���ȿ� Ư�� ĳ���Ͱ� ��� �ִ����� ��ȯ�ϴ� �޼ҵ�.
     *
     * @param in
     *            �˻��� ��Ʈ��.
     * @param lookFor
     *            ã�ƺ������ϴ� ĳ����.
     * @return �����ϴ°���.
     */
    private static int charCount(String in, char lookFor) {
        String search = new String(in);
        int index = search.indexOf(lookFor);
        int count = 0;

        while (index > 0) {
            count++;
            search = search.substring(index + 1);
            index = search.indexOf(lookFor);
        }

        return count;
    }

    /**
     * ��Ʈ���� ���ڷθ� �̷�����ִ����� �����ϴ� �޼ҵ�
     *
     * @param text
     *            �˻��� ��Ʈ��.
     * @return ������ ���ڷθ� �Ǿ������� true �ƴϸ� false�� ��ȯ�Ѵ�.
     */
    public final static boolean isNumeric(String text) {
        for (int i = 0; i < text.length(); i++)
            if (!Character.isLetterOrDigit(text.charAt(i))) {
                return (false);
            }

        return (true);
    }

    /**
     * ���Խ��� �̿��� split �Լ�
     * @param s
     * @param delimiter
     * @return
     */
    public static String[] split(String s, String delimiter) {

        String[] arr = s.split(delimiter);

        return arr;
    }

    public static String split(String s, String delimiter, int index) {

        if("".equals(s) || s==null) return "";

        String[] arr = split(s, delimiter);

        String result = "";

        try {
            result = arr[index];
        } catch (Exception e) {
            return "";
        }

        return result;
    }

    public static int splitCnt(String s, String delimiter) {

    	if("".equals(s) || s==null) return 0;

        String[] arr = split(s, delimiter);

        int count = 0;

        try {
        	count = arr.length;
        } catch (Exception e) {
            return 0;
        }

        return count;
    }


    /**
     * �����ڵ� ��ȯ ( 8859_1 --> KSC5601 )
     *
     * @param str
     *            ��ȯ�� ���ڿ�
     * @return ��ȯ�� ���ڿ�
     */
    public static String asciiToKsc(String str) {
        try {
            if (str == null) {
                return null;
            }

            return new String(str.getBytes("8859_1"), "KSC5601");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * �����ڵ� ��ȯ ( 8859_1 --> KSC5601 )
     *
     * @param str
     *            ��ȯ�� ���ڿ�
     * @return ��ȯ�� ���ڿ�
     */
    public static String kscToAscii(String str) {
        try {
            if (str == null) {
                return null;
            }

            return new String(str.getBytes("KSC5601"), "8859_1");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * ���ڰ� null�� ��� �ٸ� ���ڷ� ��ü
     *
     * @param str
     *            ����
     * @param val
     *            Null�� ��� ��ü�� ����
     * @author sybaek
     * @since 2000.6.16
     */
    public static String nvl(Object obj, String val) {

        String ret = (obj!=null) ? obj.toString().trim() : "";

        if ( "".equals(ret) ) {
            return val;
        } else {
            return ret;
        }
    }

    /**
     * ���ڰ� null�� ��� �ٸ� ���ڷ� ��ü
     *
     * @param str
     *            ����
     * @param val
     *            Null�� ��� ��ü�� ����
     * @author sybaek
     * @since 2000.6.16
     */
    public static String nvl(String str, String val) {

        if (str == null || "".equals(str.trim())) {
            return val;
        } else {
            return str;
        }
    }

    /**
     * ���� ��ȯ Returns a String with all occurrences of the String from replaced
     * by the String to.
     *
     * @param in
     *            �۾��� ���ڸ� �����ϴ� ���ڿ�
     * @param from
     *            ã�� ���ڿ�
     * @param to
     *            ��ȯ�� ���ڿ�
     * @return The new String
     */
    public static String replace(String in, String from, String to) {
        StringBuffer sb = new StringBuffer(in.length() * 2);
        String posString = in.toLowerCase();
        String cmpString = from.toLowerCase();
        int i = 0;
        boolean done = false;

        while ((i < in.length()) && !done) {
            int start = posString.indexOf(cmpString, i);

            if (start == -1) {
                done = true;
            } else {
                sb.append(in.substring(i, start) + to);
                i = start + from.length();
            }
        }

        if (i < in.length()) {
            sb.append(in.substring(i));
        }

        return sb.toString();
    }

    /**
     * String �� Ư���� ���ڰ� ��� �� �ִ��� return
     *
     * @param str
     *            ��� ���ڿ�
     * @param find
     *            ã���� �ϴ� ���ڿ�
     */
    public static int cntInStr(String str, String find) {
        int i = 0;
        int pos = 0;

        while (true) {
            pos = str.indexOf(find, pos);

            if (pos == -1) {
                break;
            }

            i++;
            pos++;
        }

        return i;
    }

    /**
     * �����ڵ� 2.0�ѱ��� �����ڵ� 1.2�ѱۺ��濵������ ��ȯ
     *
     * @param uni20
     *            ��� ���ڿ�
     */
    public static String uni20ToUni12(String uni20)
        throws UnsupportedEncodingException {
        if (uni20 == null) {
            return null;
        }

        int len = uni20.length();
        char[] out = new char[len];

        //for ����
        for (int i = 0; i < len; i++) {
            char c = uni20.charAt(i);

            if ((c < 0xac00) || (0xd7a3 < c)) {
                out[i] = c;
            } else { // �����ڵ� 2.0 �ѱ� ����

                try {
                    byte[] ksc = String.valueOf(c).getBytes("KSC5601");

                    if (ksc.length != 2) {
                        out[i] = '\ufffd';
                        System.err.println(
                            "Warning: Some of Unicode 2.0 hangul character was ignored.");
                    } else {
                        out[i] = (char) ((0x3400 +
                            (((ksc[0] & 0xff) - 0xb0) * 94) + (ksc[1] & 0xff)) -
                            0xa1);
                    }
                } catch (UnsupportedEncodingException ex) {
                    //throw new SQLException( ex.getMessage() );
                } //try ��
            } //2��° if�� ��
        }

        //for ��
        return new String(out);
    }

    /**
     * �����ڵ� 1.2 �ѱ��� �����ڵ� 2.0 �ѱۿ������� ��ȯ
     *
     * @param uni12
     *            ��� ���ڿ�
     */
    public static String uni12ToUni20(String uni12) {
        if (uni12 == null) {
            return null;
        }

        int len = uni12.length();
        char[] out = new char[len];
        byte[] ksc = new byte[2];

        for (int i = 0; i < len; i++) {
            char c = uni12.charAt(i);

            if ((c < 0x3400) || (0x4dff < c)) {
                out[i] = c;
            } else if (0x3d2e <= c) // �����ڵ� 1.2 �ѱ� ���� ���� A, B
             {
                System.err.println(
                    "Warning: Some of Unicode 1.2 hangul character was ignored.");
                out[i] = '\ufffd';
            } else {
                try {
                    ksc[0] = (byte) (((c - 0x3400) / 94) + 0xb0);
                    ksc[1] = (byte) (((c - 0x3400) % 94) + 0xa1);
                    out[i] = new String(ksc, "KSC5601").charAt(0);
                } catch (UnsupportedEncodingException ex) {
                    throw new InternalError(
                        "Fatal Error: KSC5601 encoding is not supported.");
                }
            }
        }

        return new String(out);
    }

    /**
     * varchar2 Ÿ���� �ڷḦ �̿��� sql���� ����� ���� �ϱ� ���� varchar2 string�� '���ڰ� �ڷῡ ���Ե� ���
     * ''�� ��ȯ�Ѵ�.
     *
     * @param str
     *            ��ȯ�� ���ڿ�
     */
    public static String getQuotedStr(String str) {
        //  ���ϰ��
        if (str == null) {
            return "";
        }

        //  '���ڰ� ��� ��Ʈ���� ���
        if (str.indexOf('\'') < 0) {
            return str;
        }

        //  '���ڰ� �ִ� ��Ʈ���� ��� '���ڸ� ''�� �ٲپ��ش�.
        StringBuffer strbuf = new StringBuffer(str);

        for (int i = 0; i < strbuf.length();) {
            if (strbuf.charAt(i) == '\'') {
                ;
                strbuf.replace(i, i + 1, new String("''"));
                i = i + 2;
            } else {
                i++;
            }
        }

        //  �ٲ� ��Ʈ���� ����
        return new String(strbuf);
    }

    /**
     * ���ڿ��� ���ڸ� �����ϰ� ���� ��� ù������ ��ġ�� return
     *
     * @param sVal
     *            �� ���ڿ�
     * @return int index of fist number string
     */
    public static int indexOfFirstNumber(String sVal) {
        String s = "";
        int iPos = 0;
        boolean b = false;

        for (int i = 0; i < sVal.length(); i++) {
            s = sVal.substring(i, i + 1);

            try {
                iPos = Integer.parseInt(s);
                b = true;
            } catch (Exception e) {
                b = false;
            }

            if (b) {
                iPos = i;

                break;
            }
        }

        return iPos;
    }


    /**
     * �ϳ��� ���ڿ�(String)�� ���ڷ� ��ȯ int return
     *
     * @param strNo
     *      ���ڿ� �Ѱ�
     * @return intNo (����)
     */
    public static int parseInt(String s) {
        try
        {
            if(s == null)
                return 0;
            else
                return Integer.parseInt(s);
        }
        catch(Exception e)
        {
        }
        return 0;
    }

    /**
     * �ϳ��� ���ڿ�(String)�� ���ڷ� ��ȯ int return
     *
     * @param strNo
     *      ���ڿ� �Ѱ�
     * @return intNo (����)
     */
    public static int parseInt(Object s) {
        try
        {
            if(s == null)
                return 0;
            else
                return ((Number)s).intValue();
        }
        catch(Exception e)
        {
        }
        return 0;
    }

    /**
     * �ֹι�ȣ���� ���� �����ϱ� ���(YYYY) return
     *
     * @param jumin
     *      �ֹι�ȣ13�ڸ�
     * @return year
     */
    public static String birthYearFromSsn(String jumin) {

        String year = "";

        if ((jumin.substring(6,7).equals("1"))||(jumin.substring(6,7).equals("2")))
        {
           year = ("19"+jumin.substring(0,2));
        }
        else if ((jumin.substring(6,7).equals("3")) ||(jumin.substring(6,7).equals("4")))
        {
            year = ("20"+jumin.substring(0,2));
        } else {
            year = ("19"+jumin.substring(0,2));
        }
        return year;
    }

    /**
     * �ֹι�ȣ���� ���� �����ϱ� ���(MM) return
     *
     * @param jumin
     *      �ֹι�ȣ13�ڸ�
     * @return month
     */
    public static String birthMonthFromSssn(String jumin) {

        String month = "";
         month=jumin.substring(2,4);
        return month;
    }

    /**
     * �ֹι�ȣ���� ����� �����ϱ� ����(DD) return
     *
     * @param jumin
     *      �ֹι�ȣ13�ڸ�
     * @return date
     */
    public static String birthDateFromSsn(String jumin) {

        String date = "";
         date=jumin.substring(4,6);
        return date;
    }

    /**
     * �ֹι�ȣ���� ���迬�� ����ϱ� ���� return
     *
     * @param jumin
     *      �ֹι�ȣ13�ڸ�
     * @return insuage ���迬��(���質��)
     */
    public static String insuAge(String jumin) {

        String today = ""; //��������
        int Yinterval = 0; //������
        int Minterval = 0; //������
        int Dinterval = 0; //������
        int insuage = 0;  //���� ����
        String strage = "";

        today = DateUtil.getDate();

        if (jumin == null) {

            strage = "";

        }else{

            if (jumin.length() != 13) {

                strage = "";

            } else {

                //�������ڿ� ������ ������ ����� ����
                Yinterval = Math.abs(parseInt(today.substring(0,4))-parseInt(birthYearFromSsn(jumin)));
                //�������ڿ� ������ ������ �޼��� ����
                Minterval = parseInt(today.substring(5,7))-parseInt(birthMonthFromSssn(jumin));
                //�������ڿ� ������ ������ �ϼ��� ����
                Dinterval = parseInt(today.substring(8,10))-parseInt(birthDateFromSsn(jumin));

                if( Minterval > 6){
                    insuage  = Yinterval + 1;
                }
                else if(Minterval == 6 ){
                    if (Dinterval>=0){
                        insuage = Yinterval + 1;
                    }else {
                        insuage = Yinterval;
                    }
                }
                else if(Minterval< -6){
                    insuage  = Yinterval - 1;
                }
                else if(Minterval == -6){
                    if (Dinterval<0){
                        insuage = Yinterval - 1;
                    }else {
                        insuage = Yinterval;
                    }
                }
                else{
                    insuage = Yinterval;
                }

                strage = String.valueOf(insuage);
            }


        }

        return strage;

    }


    /**
     * �������� ���� �޸��� ���Ե� ȭ������� ����
     *
     * @param double dblNumber �ٲ����� ���ڿ� ���̴�.
     * @return String �ٲ���� ���� �Ѱ��ش�.
     */
    public static String addComma(Object obj) {

        String str = "";

        if(obj!=null) {
            str = obj+"";

            if(str.length() <= 3) {
                return str;
            } else {
                StringBuffer sb=new StringBuffer(str);
                int index=-3;

                for(int i=str.trim().length(); i>3; i -= 3)
                {
                    sb.insert(i+index,",");
                }

                String chgStr = sb.toString();

                return chgStr;
            }
        } else {
            logger.error("DATA�� NULL�̱���...");
            return "0";
        }
    }



    /**
     * �ֹι�ȣ���� 6�ڸ�-7�ڸ��� ǥ���Ѵ�
     *
     * @param jumin
     *      �ֹι�ȣ13�ڸ�
     * @return strJumin xxxxxx-xxxxxxx
     */
    public static String addHyphen(String str) {
        String strJumin = "";

        if (str.length() == 13){
            strJumin = str.substring(0,6)+"-"+str.substring(6,13);
        } else {
            strJumin = str;
        }

        return strJumin;
    }


    /**
     * �����ڷ� ����� ���ڿ��� �Ľ��Ͽ� Entity�� ��´�.
     * ���� �̸��� 2�� �̻� �Ѿ� �� ��쿡�� String[] �� ��� Entity�� ���ε��Ѵ�.
     * 2006.11.23 ���ع�
     * @param param - �Ľ��� ���ڿ�
     * @param deli  - split�� ������
     * @return Entity
     */
    public static Entity str2Entity(String param) {

        Entity tmpEn = new Entity();
        Entity retEn = new Entity();

        if(param!=null && param.length()>0) {
            String[] arr1 = param.split("&");

            if(arr1.length>0) {

                for(int i=0 ; i<arr1.length ; i++) {
                    String[] arr2 = arr1[i].split("=");

                    String tmp  = arr2[0];
                    String tmpV = "";

                    try {
                        tmpV = StringUtil.nvl(arr2[1], "");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        tmpV = "";
                    }

                    if( tmpEn.getStrings(tmp)!=null ) {

                        String[] _t = tmpEn.getStrings(tmp);
                        String[] _tt = new String[_t.length+1];

                        //������ �ִ� ���� ����
                        for(int k=0 ; k<_t.length ; k++) {
                            _tt[k] = _t[k];
                        }

                        //���� �߰��Ǵ� �� ���ε�
                        _tt[_t.length] = tmpV;

                        tmpEn.setValue(tmp, _tt);
                        retEn.setValue(tmp, _tt);

                    } else {
                        tmpEn.setValue( tmp, new String[] {tmpV} );
                        retEn.setValue( tmp, tmpV );
                    }
                } //end of for

            }
        }

        return retEn;
    }


    /**
     * ����, �ѱ� ȥ�� ���ڿ��� ������ ���̿��� �߶��ִ� �Լ�
     *
     * @param str        ���ڿ�
     * @param limit    �ڸ����� �ϴ� ����
     * @return        ���ϴ� ���̴�� �߶��� ���ڿ�
     * @exception Execption error occurs
     * by jamesk
     */
    public static String cutStrLen (String str, int limit)  {

        int len = str.length();

        if (str == null || str.getBytes().length < limit ) return str ;

        int cnt=0, index=0;

        while (index < len && cnt < limit) {
            if (str.charAt(index++) < 256) // 1����Ʈ ���ڶ��...
                cnt++;     // ���� 1 ����
            else // 2����Ʈ ���ڶ��...
                cnt += 2;  // ���� 2 ����
        }

        if (index < len) {
            str = str.substring(0, index) + "...";
        }

        return str ;
    }


    /**
     * �ѱ۹��ڿ��� �������̸� ��´�.
     *
     * @param buf ���̸� ���� ���ڿ�
     * @return ���ڿ��� ��������
     * @since 1.0
     */
    public static int getHangulLength(String buf)
    {

        int datelen=0;
        for (int i=0; i<buf.length(); i++)
        {
            char nn;
            try
            {
                   nn = buf.charAt(i);
                   Character.UnicodeBlock uniTmp = Character.UnicodeBlock.of(nn);

                if( uniTmp == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO ||
                    uniTmp == Character.UnicodeBlock.HANGUL_JAMO ||
                    uniTmp == Character.UnicodeBlock.HANGUL_SYLLABLES ||
                    uniTmp == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  ||
                    uniTmp == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS ||
                    uniTmp == Character.UnicodeBlock.LATIN_1_SUPPLEMENT ||
                    uniTmp == Character.UnicodeBlock.SPECIALS ||
                    uniTmp == Character.UnicodeBlock.GREEK
                )
                   {
                    datelen ++;
                   }
                datelen ++;
            }
            catch (Exception e)
            {
                   System.out.println("In getHangulLength() Exception : "+e);
              }
        }

        return datelen;
    } // End : int getHangulLength()


    /**
     * Byte�� ��ȯ�ؼ� s_offset���� e_offset��ŭ�� ���ڿ��� ��´�.
     * @param str ���ڿ�
     * @param s_offset ���� ���ڿ��� ������ġ
     * @param e_offset ���� ���ڿ��� ��������ġ
     * @return s_offset���� e_offset��ŭ�� ���ڿ�
     * @since 1.0
     */
    public static String byteSubString(String str, int s_offset, int e_offset)
    {

        byte b[] = str.getBytes();

        byte f[] = new byte[e_offset-s_offset];
        int m=0;
        for(int i=s_offset;i<e_offset; i++)
        {
            f[m++] = b[i];
        }

        return new String(f);
    }


    /**
     * �ѱ��� ���Ե� ���ڿ����� s_offset���� e_offset��ŭ�� ���ڿ��� ��´�.
     * @param str �ѱ��� ���Ե� ���ڿ�
     * @param s_offset ���� ���ڿ��� ������ġ
     * @param e_offset ���� ���ڿ��� ��������ġ
     * @return s_offset���� e_offset��ŭ�� ���ڿ�
     * @since 1.0
     */
    public static String hangulSubString(String str, int s_offset, int e_offset)
    {
        String  sCnvStr = new String();

        int datelen=0;
        for(int i=0; i<str.length(); i++)
        {
            char nn;

            try
            {
                nn = str.charAt(i);

                Character.UnicodeBlock uniTmp = Character.UnicodeBlock.of(nn);

                //System.out.println("nn=[" + nn + "][" + uniTmp + "]");

                if( uniTmp == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO ||
                    uniTmp == Character.UnicodeBlock.HANGUL_JAMO ||
                    uniTmp == Character.UnicodeBlock.HANGUL_SYLLABLES ||
                    uniTmp == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  ||
                    uniTmp == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS ||
                    uniTmp == Character.UnicodeBlock.LATIN_1_SUPPLEMENT ||
                    uniTmp == Character.UnicodeBlock.SPECIALS ||
                    uniTmp == Character.UnicodeBlock.GREEK
                )
                {
                    // 2Byte����
                    datelen ++;
                }
                else if(uniTmp == Character.UnicodeBlock.BASIC_LATIN)
                {
                    // 1Byte����
                }
                else
                {
                    System.out.println("Unknown Charset:"+uniTmp);
                }
                datelen ++;

                if(datelen > s_offset && datelen <= e_offset)
                    sCnvStr += str.substring(i,i+1);
            }
            catch (Exception e)
            {
                System.out.println("In hangulSubString() Exception : "+e);
            }
        }

        return sCnvStr;
    } // End : String hangulSubString()


    /**
     * URL��ü�� �ش��ϴ� �������� ��¹��ڿ��� ���Ѵ�.<br>
     * @param   uURL �������� URL ��ü
     * @return  ���������� �ҽ����ڿ�
     */
    public static String getURLPageString(URL uURL) throws Exception
    {
        String sLine = "";
        String sDisplayString = "";
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new InputStreamReader(uURL.openStream() ) );

            while( (sLine = br.readLine() ) != null )
            {
                sDisplayString += sLine;
            }

        }
        catch(Exception e) { throw e; }
        finally { try { if( br != null ) br.close(); } catch(Exception e) {} }

        return sDisplayString;
    }

    /**
     * Datetime Ÿ������ ����Ǿ� �ִ� ��¥�� String���� ��ȯ�Ͽ� ����
     * @author Administrator
     * @return
     * @date   2007. 05. 28
     */
    public static String getCreateTime(Object date, String deli) {

        String dt = "";

        if(date!=null) {
            dt = date.toString();
            dt = DateUtil.getParseDateString(dt, deli);
        }

        return dt;
    }

    public static String getCreateTime(Object date) {
        return getCreateTime(date, "-");
    }

    /**
     * �Ҽ��� ���� �ڸ��� ������ ���ڸ�ŭ ǥ�����ָ�, �ݿø��� �ƴ� ��縦 �Ѵ�.
     * @param obj �������� ��ü
     * @param cipher �ڸ���
     * @return String
     * ���ع� �߰� - 2007.03.08
     */
    public static String jeolsa(Object obj, int cipher) {

        String ret = (obj!=null) ? obj.toString() : "0";

        if(ret.indexOf(".")==-1) {
            ret = ret + ".000000000";
        }

        String[] tmpArr = StringUtil.split(ret, "[.]");

        String str   =  tmpArr[0]; //�Ҽ��� �̻�
        String remain = tmpArr[1]; //�Ҽ��� ���ϸ� �����´�.

        if(remain.length()<cipher) {
            for(int i=0 ; i<cipher-remain.length() ; i++) {
                remain += "0";
            }
        } else {
            remain = remain.substring(0, cipher);
        }

        ret = str + "." + remain;

        return ret;
    }


    /**
     * HTML �±� ����
     */
    public static String escapeHtml(Object obj) {

        String result = "";

        if(obj==null) {
            return "";
        } else {
            result = obj.toString();

            result = StringEscapeUtils.escapeHtml(result);
        }

        return result;
    }

    /**
     * �ٹٲ�(\n) ���ڸ� <br>�� ��ȯ (press release)
     */
    public static String pressCrToBr(Object obj) {

        if(obj==null) {
            return "";
        }

        String msg = obj.toString();

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < msg.length(); i++)
        {
        	if(i < msg.length() - 1){
	            if(msg.charAt(i)=='\n' && msg.charAt(i+1)=='\n')
	            {

	                sb.append(msg.charAt(i));
	                sb.append("<p>");
	            }
	            else
	            {
	                sb.append(msg.charAt(i));
	            }
        	}
        }

        return sb.toString();
    }

    /**
     * �ٹٲ�(\n) ���ڸ� <br>�� ��ȯ
     */
    public static String crToBr(Object obj) {

        if(obj==null) {
            return "";
        }

        String msg = obj.toString();

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < msg.length(); i++)
        {
            if(msg.charAt(i) == '\n')
            {
                sb.append(msg.charAt(i));
                sb.append("<br>");
            }
            else
            {
                sb.append(msg.charAt(i));
            }
        }

        return sb.toString();
    }

    /**
     * ���� ������ language ������ ��´�.
     * @return
     */
    public static String getLanguage(HttpServletRequest request) {

        String result = "";

        Locale locale = RequestContextUtils.getLocale(request);

        result = locale.getLanguage();

        return result;
    }


    /**
     * CMS���� ���� ��Ű��(IWAUTH)�� ���������� �ľ�
     * @return
     */
    public static String getCookie(HttpServletRequest request, HttpServletResponse response) {

        String hostIp = request.getRequestURL().toString();

        String iwauth = "";

        //���� �׽�Ʈ �߿��� �۵����� �ʴ´�.
        if(hostIp.indexOf("127.0.0.1")>-1 || hostIp.indexOf("localhost")>-1) {
            iwauth = "test mode...";
        } else {
            CookieUtil cutil = new CookieUtil(request, response);

            iwauth = StringUtil.nvl(cutil.get("IWAUTH"), "");
        }

        return iwauth;
    }




    /**
     * String ���� �ִ��� üũ
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
   		return (str != null && str.length() > 0);
    }

    public static boolean isEmpty(String str) {
    	return (str == null || str.length() == 0);
    }

    /**
     * �˻� Keyword ���̶���Ʈ
     * - ���ڿ��� ���Ե� keyword �� ã�Ƽ� ���� ���ڿ� HTML tag�� ��� ��Ų��.
     */
    public static String markKeyword(String str, String keyword, String startTag, String endTag) {
        keyword =
            replace(
                replace(replace(keyword, "[", "\\["), ")", "\\)"),
                "(", "\\(");

        Pattern p = Pattern.compile( keyword , Pattern.CASE_INSENSITIVE );
        Matcher m = p.matcher( str );
        int start = 0;
        int lastEnd = 0;
        StringBuffer sbuf = new StringBuffer();
        while( m.find() ) {
            start = m.start();
            sbuf.append( str.substring(lastEnd, start) )
                .append(startTag + m.group() + endTag );
            lastEnd = m.end();
        }
        return sbuf.append(str.substring(lastEnd)).toString() ;
    }

    public static String getDirLanguage(String locale) {
    	String dirLanguage = "";

		if (locale.equals("ko")) {
			dirLanguage = "kr";
		} else if (locale.equals("zh")) {
			dirLanguage = "cn";
		} else {
			dirLanguage = "en";
		}

		return dirLanguage;
    }


    /**
     * ������ ���ڿ��� ó�� ��ġ�� ã�´�.
     * @param fullStr
     * @param findStr - ã�� ���ڿ�
     * @return
     */
    public static int indexOf(String fullStr, String findStr) {
    	if (isEmpty(fullStr)) {
    		return -1;
    	}

    	return fullStr.indexOf(findStr);
    }

    /**
     * ������ ���ڿ��� ó�� ��ġ�� ã�´�.
     * @param fullStr
     * @param findStr - ã�� ���ڿ�
     * @param fromIndex - ���� ��ġ
     * @return
     */
    public static int indexOf(String fullStr, String findStr, int fromIndex) {

    	if (isEmpty(fullStr) || isEmpty(findStr)) {
    		return -1;
    	}

    	return fullStr.indexOf(findStr, fromIndex);
    }

    /**
     * Return a substring of original string
     * @param fullStr
     * @param beginIndex - ã�� �����ϴ� ��ġ
     * @return
     */
    public static String substring(String fullStr, int beginIndex) {
    	if (isEmpty(fullStr)) {
    		return "";
    	}

    	return fullStr.substring(beginIndex);
    }

    /**
     * Return a substring of original string
     * @param fullStr
     * @param beginIndex - ���� ��ġ
     * @param endIndex - �� ��ġ
     * @return
     */
    public static String substring(String fullStr, int beginIndex, int endIndex) {
    	if (isEmpty(fullStr)) {
    		return "";
    	}

    	return fullStr.substring(beginIndex, endIndex);
    }

    /**
     *
     * @param src
     * @param from
     * @param to
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static String changeEncoding(String src, String from, String to) throws UnsupportedEncodingException {

    	return new String(src.getBytes(from),to);

    }


    public static String calculator(String a, String b, String operator) {

    	int result = 0;

    	try {
    		int numA = Integer.parseInt(a);
    		int numB = Integer.parseInt(b);

    		if (operator.equals("+")) {
    			result = numA + numB;
    		} else if (operator.equals("-")) {
    			result = numA - numB;
    		}

    	} catch(Exception e) {
    		return "";
    	}

    	return Integer.toString(result);
    }

}