package com.capstone.fbvol.common.util;


/**
 *  _a_t_ (#)DateUtil.java   v1.1  19-Nov-2002
 *
 *   ��¥ ��꿡 ������ �������� �޼ҵ�.
 *
 *
 *       public static int[] getMonthDaysArray(int yr)
 *           ������ �⵵�� �� �޿� ���Ե� ������ �迭�� ���ϴ� �޼ҵ�
 *
 *       public static int getDaysInYear(int y)
 *           ������ �⵵�� ���Ե� ���� ���ϴ� �޼ҵ�
 *
 *       public static int getDaysInMonth(int m, int y)
 *           ������ �⵵�� ������ �޿� ���Ե� ���� ���ϴ� �޼ҵ�
 *
 *       public static int getDaysFromMonthFirst(int d, int m, int y)
 *       public static int getDaysFromMonthFirst(String s)
 *           ������ �⵵�� 1�� 1�� ���Ŀ� ����� ���� ���ϴ� �޼ҵ�
 *           ���� ������ ��¥�� ��ȿ�� ������ ����� ���ܻ�Ȳ�� �����.
 *
 *       public static int getDaysFromYearFirst(int d, int m, int y)
 *       public static int getDaysFromYearFirst(String s)
 *           ������ �⵵�� 1�� 1�� ���Ŀ� ����� ���� ���ϴ� �޼ҵ�
 *
 *       public static int getDaysFrom21Century(int d, int m, int y)
 *       public static int getDaysFrom21Century(String s)
 *           2000�� 1�� 1�� ���Ŀ� ����� ���� ���ϴ� �޼ҵ�
 *
 *       public static int getDaysBetween(String s1, String s2)
 *           ������ �� ��¥�� (�� �� ����) ��¥ ���� ���ϴ� �޼ҵ�
 *
 *       public static int getDaysDiff(String s1, String s2)
 *           ������ �� ��¥�� ��¥ ���� ���ϴ� �޼ҵ�
 *
 *       public static int getDaysFromTo(String s1, String s2)
 *           ������ �� ��¥�� (�� �� ����) ��¥ ���� ���ϴ� �޼ҵ�
 *
 *       public static int getWeekdaysInMonth(int weekDay, int m, int y)
 *       public static int getWeekdaysInMonth(String weekName, int m, int y)
 *           ������ �⵵�� ������ �޿� ���Ե� ������ ������ ���� ���ϴ� �޼ҵ�
 *
 *       public static String getDateStringFrom21Century(int elapsed)
 *           2000�� 1�� ���� elapsed�� ����� ��¥�� String Ÿ�����δ� �޼ҵ�
 *
 *       public static String addDate(int offset, int d, int m, int y)
 *       public static String addDate(int offset, String date)
 *           ������ ��¥ ���� ������ offset�� ����� ��¥�� String Ÿ�����δ� �޼ҵ�
 *
 *
 *   [��� 1] �׷��?�� �޷��� 1582 �⵵ 10�� �޷��� ���������̴�.
 *            ��, 10�� 4�� ���� ���� 10�� 15���̾��. �׷��Ƿ�,
 *            �� ���� ������ ������ 21���� �Ѵ��̾��.
 * 
 *   [��� 2] ������ �޷��� 1752 �⵵ 9�� �޷��� ���������̴�.
 *            ��, 9�� 2�� ���� ���� 9�� 14���̾��. �׷��Ƿ�,
 *            �� ���� ���Ϸ簡 ������ 19���� �Ѵ��̾��.
 * 
 *         
 *  _a_t_ date    10-Sep-2002  (ver 1.0)   DateDiffTest.java
 *  _a_t_ date    19-Nov-2002  (ver 1.1)
 *  _a_t_ author  Pilho Kim    (phkim at cluecom.co.kr)
 */
public class DateUtil { 

  ////////////////////////////////////////////////////////////////////////////
  // �ϳ� �� �޷��� �� ��¥�� �迭�� ���Ѵ�.
  //
  public static int[] getMonthDaysArray(int yr) {
    int[] a1 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int[] a2 = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    if (yr <= 1582) {
      if ((yr % 4) == 0) {
        if (yr == 4) {
          return a1;
        }
        return a2;
      }
    }
    else {
      if (((yr % 4) == 0) && ((yr % 100) != 0)) {
        return a2;
      }
      else if ((yr % 400) == 0) {
        return a2;
      }
    }

    return a1;
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵�� �޿� �� ���� ������ ���Ѵ�.
  //
  public static int addWeekDays(int y, int m) {
    int[] b1 = { 3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };
    int[] b2 = { 3, 1, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };
    int i = 0;
    int rval = 0;

    if (y <= 1582) {
      if ((y % 4) == 0) {
        if (y == 4) {
          for (i = 0; i < m - 1; i++)
            rval += b1[i];
        }
        else {
          for (i = 0; i < m - 1; i++)
            rval += b2[i];
        }
      }
      else {
        for (i = 0; i < m - 1; i++)
          rval += b1[i];
      }
    }
    else {
      if (((y % 4) == 0) && ((y % 100) != 0)) {
        for (i = 0; i < m - 1; i++)
          rval += b2[i];
      }
      else if ((y % 400) == 0) {
        for (i = 0; i < m - 1; i++)
          rval += b2[i];
      }
      else {
        for (i = 0; i < m - 1; i++)
          rval += b1[i];
      }
    }

    return rval;
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵�� �� ��¥ ���� ���Ѵ�.
  //
  public static int getDaysInYear(int y) {
    if (y > 1582) {
        if (y % 400 == 0)
            return 366;
        else if (y % 100 == 0)
            return 365;
        else if (y % 4 == 0)
            return 366;
        else
            return 365;
    }
    else if (y == 1582)
        return 355;
    else if (y > 4) {
        if (y % 4 == 0)
            return 366;
        else
            return 365;
    }
    else if (y > 0)
        return 365;
    else
        return 0;
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵, ������ ���� �� ��¥ ���� ���Ѵ�.
  //
  public static int getDaysInMonth(int m, int y) {
    if (m < 1 || m > 12)
        throw new RuntimeException("Invalid month: " + m);

    int[] b = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if (m != 2 && m >= 1 && m <= 12 && y != 1582)
        return b[m - 1];
    if (m != 2 && m >= 1 && m <= 12 && y == 1582)
        if (m != 10)
            return b[m - 1];
        else 
            return b[m - 1] - 10;

    if (m != 2)
        return 0;

    // m == 2 (�� 2��)
    if (y > 1582) {
        if (y % 400 == 0)
            return 29;
        else if (y % 100 == 0)
            return 28;
        else if (y % 4 == 0)
            return 29;
        else
            return 28;
    }
    else if (y == 1582)
        return 28;
    else if (y > 4) {
        if (y % 4 == 0)
            return 29;
        else
            return 28;
    }
    else if (y > 0)
        return 28;
    else
        throw new RuntimeException("Invalid year: " + y);
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵�� ������ ���� ù�� ���� ������ �� ������ ��¥ ���� ���Ѵ�.
  //
  public static int getDaysFromMonthFirst(int d, int m, int y) {
    if (m < 1 || m > 12)
        throw new RuntimeException("Invalid month " + m + " in " + d + "/" + m + "/" + y);

    int max = getDaysInMonth(m, y);
    if (d >= 1 && d <= max)
        return d;
    else
        throw new RuntimeException("Invalid date " + d + " in " + d + "/" + m + "/" + y);
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵�� ù�� ���� ������ ���� ������ �� ������ ��¥ ���� ���Ѵ�.
  //
  public static int getDaysFromYearFirst(int d, int m, int y) {
    if (m < 1 || m > 12)
        throw new RuntimeException("Invalid month " + m + " in " + d + "/" + m + "/" + y);

    int max = getDaysInMonth(m, y);
    if (d >= 1 && d <= max) {
        int sum = d;
        for (int j = 1; j < m; j++)
            sum += getDaysInMonth(j, y);
        return sum;
    }
    else
        throw new RuntimeException("Invalid date " + d + " in " + d + "/" + m + "/" + y);
  }

  ////////////////////////////////////////////////////////////////////////////
  // 2000�� 1�� 1�� ���� ������ ��, ��, �� ������ ��¥ ���� ���Ѵ�.
  // 2000�� 1�� 1�� ������ ��쿡�� ������ �����Ѵ�.
  //
  public static int getDaysFrom21Century(int d, int m, int y) {
    if (y >= 2000) {
        int sum = getDaysFromYearFirst(d, m, y);
        for (int j = y - 1; j >= 2000; j--)
            sum += getDaysInYear(j);
        return sum - 1;
    }
    else if (y > 0 && y < 2000) {
        int sum = getDaysFromYearFirst(d, m, y);
        for (int j = 1999; j >= y; j--)
             sum -= getDaysInYear(y);
        return sum - 1;
    }
    else
        throw new RuntimeException("Invalid year " + y + " in " + d + "/" + m + "/" + y);
  }



  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵�� ������ ���� ù�� ���� ������ �� ������ ��¥ ���� ���Ѵ�.
  // 
  public static int getDaysFromMonthFirst(String s) {
    int d, m, y;
    if (s.length() == 8) {
        y = Integer.parseInt(s.substring(0, 4));
        m = Integer.parseInt(s.substring(4, 6));
        d = Integer.parseInt(s.substring(6));
        return getDaysFromMonthFirst(d, m, y);
    }
    else if (s.length() == 10) {
        y = Integer.parseInt(s.substring(0, 4));
        m = Integer.parseInt(s.substring(5, 7));
        d = Integer.parseInt(s.substring(8));
        return getDaysFromMonthFirst(d, m, y);
    }
    else if (s.length() == 11) {
        d = Integer.parseInt(s.substring(0, 2));
        String strM = s.substring(3, 6).toUpperCase();
        String[] monthNames = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
                                "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        m = 0;
        for (int j = 1; j <= 12; j++) {
            if (strM.equals(monthNames[j-1])) {
                m = j;
                break;
            }
        }
        if (m < 1 || m > 12)
            throw new RuntimeException("Invalid month name: " + strM + " in " + s);
        y = Integer.parseInt(s.substring(7));
        return getDaysFromMonthFirst(d, m, y);
    }
    else
        throw new RuntimeException("Invalid date format: " + s);
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵�� ù�� ���� ������ ���� ������ �� ������ ��¥ ���� ���Ѵ�.
  // 
  public static int getDaysFromYearFirst(String s) {
    int d, m, y;
    if (s.length() == 8) {
        y = Integer.parseInt(s.substring(0, 4));
        m = Integer.parseInt(s.substring(4, 6));
        d = Integer.parseInt(s.substring(6));
        return getDaysFromYearFirst(d, m, y);
    }
    else if (s.length() == 10) {
        y = Integer.parseInt(s.substring(0, 4));
        m = Integer.parseInt(s.substring(5, 7));
        d = Integer.parseInt(s.substring(8));
        return getDaysFromYearFirst(d, m, y);
    }
    else if (s.length() == 11) {
        d = Integer.parseInt(s.substring(0, 2));
        String strM = s.substring(3, 6).toUpperCase();
        String[] monthNames = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
                                "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        m = 0;
        for (int j = 1; j <= 12; j++) {
            if (strM.equals(monthNames[j-1])) {
                m = j;
                break;
            }
        }
        if (m < 1 || m > 12)
            throw new RuntimeException("Invalid month name: " + strM + " in " + s);
        y = Integer.parseInt(s.substring(7));
        return getDaysFromYearFirst(d, m, y);
    }
    else
        throw new RuntimeException("Invalid date format: " + s);
  }


  //////////////////////////////////////////////////////////////////////
  // 2000�� 1�� 1�� ���� ������ ��, ��, �� ������ ��¥ ���� ���Ѵ�.
  // 2000�� 1�� 1�� ������ ��쿡�� ������ �����Ѵ�.
  //
  public static int getDaysFrom21Century(String s) {
    int d, m, y;
    if (s.length() == 8) {
        y = Integer.parseInt(s.substring(0, 4));
        m = Integer.parseInt(s.substring(4, 6));
        d = Integer.parseInt(s.substring(6));
        return getDaysFrom21Century(d, m, y);
    }
    else if (s.length() == 10) {
        y = Integer.parseInt(s.substring(0, 4));
        m = Integer.parseInt(s.substring(5, 7));
        d = Integer.parseInt(s.substring(8));
        return getDaysFrom21Century(d, m, y);
    }
    else if (s.length() == 11) {
        d = Integer.parseInt(s.substring(0, 2));
        String strM = s.substring(3, 6).toUpperCase();
        String[] monthNames = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN",
                                "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        m = 0;
        for (int j = 1; j <= 12; j++) {
            if (strM.equals(monthNames[j-1])) {
                m = j;
                break;
            }
        }
        if (m < 1 || m > 12)
            throw new RuntimeException("Invalid month name: " + strM + " in " + s);
        y = Integer.parseInt(s.substring(7));
        return getDaysFrom21Century(d, m, y);
    }
    else
        throw new RuntimeException("Invalid date format: " + s);
  }


  /////////////////////////////////////////////
  // (�� �� ����) ��¥ ���� ���ϱ�
  //
  public static int getDaysBetween(String s1, String s2) {
    int y1 = getDaysFrom21Century(s1);
    int y2 = getDaysFrom21Century(s2);
    return y1 - y2 - 1;
  }


  /////////////////////////////////////////////
  // ��¥ ���� ���ϱ�
  //
  public static int getDaysDiff(int s1, int s2){
	  try{
	  	if( s1 < 19000000 || s2 < 19000000 ) 
			return 0;

		int y1 = getDaysFrom21Century(Integer.toString(s1));
		int y2 = getDaysFrom21Century(Integer.toString(s2));
		return y1 - y2;
	  }catch(Exception e){
	  	System.out.print(e.toString());
		return 0;
	  }
	
  }
  public static int getDaysDiff(String s1, String s2) {
    int y1 = getDaysFrom21Century(s1);
    int y2 = getDaysFrom21Century(s2);
    return y1 - y2;
  }


  /////////////////////////////////////////////
  // (�� �� ����) ��¥ ���� ���ϱ�
  //
  public static int getDaysFromTo(String s1, String s2) {
    int y1 = getDaysFrom21Century(s1);
    int y2 = getDaysFrom21Century(s2);
    return y1 - y2 + 1;
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵, ������ �� ������ ������ ��� �ִ� ȸ���� ���Ѵ�.
  //
  public static int getWeekdaysInMonth(int weekDay, int m, int y) {
    int week = ((weekDay - 1) % 7);
    int days = getDaysInMonth(m, y);
    int sum = 6;   // 2000�� 1�� 1���� �����
    if (y >= 2000) {
      for (int i = 2000; i < y; i++)
        sum += getDaysInYear(i);
    }
    else {
      for (int i = y; i < 2000; i++)
        sum -= getDaysInYear(i);
    }
    for (int i = 1; i < m; i++)
      sum += getDaysInMonth(i, y);

    // if (sum < 0)
    //  sum += 350*3000;

    int firstWeekDay = sum % 7;
    if (firstWeekDay < 0) {
        firstWeekDay += 7;
    }

    // firstWeekDay += 1;
    int n = firstWeekDay + days;
    int counter = (n / 7) + (((n % 7) > week) ? 1 : 0);
    if (firstWeekDay > week)
      counter--;

    return counter;
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ �⵵�� ������ �޿� ������ ������ ��� �ִ� ȸ���� ���Ѵ�.
  //
  public static int getWeekdaysInMonth(String weekName, int m, int y) {
    StringBuffer weekNames1 = new StringBuffer("�Ͽ�ȭ�������");
    StringBuffer weekNames2 = new StringBuffer("�������������");
    String[] weekNames3 = { "sun", "mon", "tue", "wed", "thu", "fri", "sat" };

    int n = weekNames1.indexOf(weekName);
    if (n < 0)
      n = weekNames2.indexOf(weekName);
    if (n < 0) {
      String str = weekName.toLowerCase();
      for (int i = 0; i < weekNames3.length; i++) {
        if (str.equals(weekNames3[i])) {
          n = i;
          break;
        }
      }
    }
    // System.out.println("n = " + n);

    if (n < 0)
      throw new RuntimeException("Invalid week name: " + weekName);

    return getWeekdaysInMonth(n + 1, m, y);
  }


  ////////////////////////////////////////////////////////////////////////////
  // 2000�� 1�� 1�� ������ n�� ����� ��¥ ���ϱ�
  //
  //  _a_t_ return  yyyy-mm-dd ����� String Ÿ��
  public static String getDateStringFrom21Century(int elapsed) {
    int y = 2000;
    int m = 1;
    int d = 1;

    int n = elapsed + 1;
    int j = 2000;
    if (n > 0) {
      while (n > getDaysInYear(j)) {
        n -= getDaysInYear(j); 
        j++;
      }
      y = j;

      int i = 1;
      while (n > getDaysInMonth(i, y)) {
        n -= getDaysInMonth(i, y); 
        i++;
      }
      m = i;
      d = n;
    }
    else if (n < 0) {
      while (n < 0) {
        n += getDaysInYear(j - 1); 
        j--;
      }
      y = j;

      int i = 1;
      while (n > getDaysInMonth(i, y)) {
        n -= getDaysInMonth(i, y); 
        i++;
      }
      m = i;
      d = n;
    }

    String strY = "" + y;
    String strM = "";
    String strD = "";

    if (m < 10)
      strM = "0" + m;
    else
      strM = "" + m;

    if (d < 10)
      strD = "0" + d;
    else
      strD = "" + d;

    return strY + "/" + strM + "/" + strD;
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ ��¥�� offset�� ����� ��¥ ���ϱ�
  //
  //  _a_t_ return  yyyy-mm-dd ����� String Ÿ��
  public static String addDate(int offset, int d, int m, int y) {
    int z = getDaysFrom21Century(d, m, y);
    int n = z + offset;
    return getDateStringFrom21Century(n);
  }


  ////////////////////////////////////////////////////////////////////////////
  // ������ ��¥�� offset�� ����� ��¥ ���ϱ�
  //
  //  _a_t_ return  yyyy-mm-dd ����� String Ÿ��
  public static String addDate(int offset, String date) {
    int z = getDaysFrom21Century(date);
    int n = z + offset;
    return getDateStringFrom21Century(n);
  }


  public static void main(String[] args) {
      System.out.println("----------------------------------------------");
      System.out.println("������ �⵵�� ���Ե� ���� ���ϱ�:");
      int x = getDaysInYear(2002);
      System.out.println(x);
      System.out.println("������ �⵵�� ������ �޿� ���Ե� ���� ���ϱ�:");
      int y = getDaysInMonth(1, 2002);
      System.out.println(y);
      System.out.println("2000�� 1�� 1�� ���� ����� ���� ���ϱ�:");
      int z = getDaysFromYearFirst(11, 9, 2002);
      System.out.println(z);
      int z1 = getDaysFromYearFirst("20020911");
      System.out.println(z1);
      int z2 = getDaysFromYearFirst("2002/09/11");
      System.out.println(z2);
      int z3 = getDaysFromYearFirst("2002-09-11");
      System.out.println(z3);
      int z4 = getDaysFromYearFirst("11-Sep-2002");
      System.out.println(z4);
      int z5 = getDaysFromMonthFirst("11-Sep-2002");
      System.out.println(z5);
      int z6 = getDaysFrom21Century(11, 9, 2002);
      System.out.println(z6);
      int z7 = getDaysFrom21Century("2002-09-11");
      System.out.println(z7);
      int z8 = getDaysFrom21Century("11-Sep-2002");
      System.out.println(z8);
      int u = getDaysDiff("11-Sep-2002", "01-Jan-2002");
      System.out.println(u);
      int u2 = getDaysDiff("01-Jan-2002", "11-Sep-2002");
      System.out.println(u2);
      int u3 = getDaysDiff("11-Sep-2002", "31-Dec-2000");
      System.out.println(u3);
      int u4 = getDaysDiff("2002-09-10", "2002-09-01");
      System.out.println(u4);
      int u5 = getDaysFrom21Century("31-Dec-2000");
      System.out.println(u5);
      int u6 = getDaysFrom21Century("2000-12-31");
      System.out.println(u6);
      int u7 = getDaysFrom21Century("1999-12-31");
      System.out.println(u7);
      int u8 = getDaysFrom21Century("2000-01-01");
      System.out.println(u8);

      System.out.println("-------------------------------------------------------------");
      System.out.println("������ �⵵�� ������ �޿� ���Ե� ������ ������ ���� ���ϱ�:");
      System.out.println("2002�� 11�� �ݿ��� ������ " + getWeekdaysInMonth(6, 11, 2002));
      System.out.println("2002�� 11�� ����� ������ " + getWeekdaysInMonth("��", 11, 2002));
      System.out.println("2002�� 12�� �ݿ��� ������ " + getWeekdaysInMonth(6, 12, 2002));
      System.out.println("2002�� 12�� �ݿ��� ������ " + getWeekdaysInMonth("��", 12, 2002));
      System.out.println("2002�� 12�� Tuesday ������ " + getWeekdaysInMonth("tue", 12, 2002));
      System.out.println("2002�� 12�� Saturday ������ " + getWeekdaysInMonth("sat", 12, 2001));
      System.out.println("1998�� 12�� Saturday ������ " + getWeekdaysInMonth("sat", 12, 1998));

      System.out.println("-------------------------------------------------------------");
      System.out.println("1990�� 12��   Sunday ������ " + getWeekdaysInMonth("sun", 12, 1990));
      System.out.println("                Monday ������ " + getWeekdaysInMonth("mon", 12, 1990));
      System.out.println("               Tuesday ������ " + getWeekdaysInMonth("tue", 12, 1990));
      System.out.println("              Wednsday ������ " + getWeekdaysInMonth("wed", 12, 1990));
      System.out.println("              Thursday ������ " + getWeekdaysInMonth("thu", 12, 1990));
      System.out.println("                Friday ������ " + getWeekdaysInMonth("fri", 12, 1990));
      System.out.println("              Saturday ������ " + getWeekdaysInMonth("sat", 12, 1990));

      System.out.println("-------------------------------------------------------------");
      System.out.println("2002�� 1�� 1�� �������� ������ ���� ��ŭ ����� ��¥ ���ϱ�:");
      System.out.println(getDateStringFrom21Century(366));
      System.out.println(getDateStringFrom21Century(-365));
      System.out.println(addDate(364, 1, 1, 2002));
      System.out.println(addDate(365, "2002/01/01"));
  }
}
