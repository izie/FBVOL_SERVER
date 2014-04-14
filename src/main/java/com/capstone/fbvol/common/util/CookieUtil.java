package com.capstone.fbvol.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��Ű ó�� ��ƿ
 *
 * @author ���ع�
 * @date   2008. 06. 17
 * @desc   ��Ű ó�� ��ƿ
 */
public class CookieUtil {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public CookieUtil(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * ��� ��Ű ȹ��
     * @author Administrator
     * @return
     * @date   2007. 06. 05
     */
    public Cookie[] getAll() {
        return request.getCookies();
    }

    /**
     * key������ �ش� ��Ű�� ��´�.
     */
    public Cookie getCookie(String name) {
        Cookie all[] = getAll();
        if(all == null)
            return null;
        for(int i = 0; i < all.length; i++)
        {
            Cookie cookie = all[i];
            if(cookie.getName().equals(name))
                return cookie;
        }

        return null;
    }

    /**
     * Key�� �̿��Ͽ� ���� ��´�.
     * @author Administrator
     * @return
     * @date   2007. 06. 05
     */
    public String get(String key) {

        String value = "";

        Cookie c = getCookie(key);

        if(c!=null) value = c.getValue();

        return value;
    }

    /**
     * ��Ű ��
     */
    public void add(String name, String value) {
        add(name, value, 0);
    }

    /**
     * ��Ű ��
     */
    public void add(String name, String value, Object maxAge) {
        Cookie c = create(name, value, maxAge);

        if(c == null) {
            return;
        } else {
            response.addCookie(c);
            return;
        }
    }


    //�������� ��Ű��
    private Cookie create(String name, String value, Object maxAge) {

        int expiry = 0;

        if(maxAge instanceof Number) {
            expiry = ((Number)maxAge).intValue();
        } else {
            try {
                expiry = Integer.parseInt(String.valueOf(maxAge));
            } catch(NumberFormatException nfe) {

            }
        }

        Cookie c = new Cookie(name, value);
        c.setMaxAge(expiry);
        c.setDomain(request.getContextPath());
        c.setPath("/");

        return c;
    }

}
