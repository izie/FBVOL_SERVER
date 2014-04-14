package com.capstone.fbvol.common.util.text;

import java.util.Comparator;


/**
 * String�� ���Ҽ��ְ� ���� Comparator Ŭ����.
 *
 * @author �� ��ȣ
 * @version 1.0
 */
public class StringComparator implements Comparator {
    ///////////////////////////////////////////////////////////////////////////
    //Data Member
    ///////////////////////////////////////////////////////////////////////////

    /** ��ҹ��ڸ� �������� �ƴ����� ���ѿ��� */
    private boolean caseSensitive;

    ///////////////////////////////////////////////////////////////////////////
    //Constructor
    ///////////////////////////////////////////////////////////////////////////

    /**
     * ���ο� StringComparator�� ���Ѵ�.
     */
    public StringComparator() {
        this(true);
    }

    /**
     * ���ο� StringComparator�� ���Ѵ�.
     *
     * @param caseSensitive
     *            ��ҹ��ڸ����������� ���� ����.
     */
    public StringComparator(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    ///////////////////////////////////////////////////////////////////////////
    //Function Method
    ///////////////////////////////////////////////////////////////////////////

    /**
     * ��ҹ��ڸ� �����ϰ��ִ����� ���θ� �˾ƺ�.
     *
     * @return ��ҹ��ڸ� �����ϸ� true �׷��������� false�� ��ȯ��.
     */
    public boolean isCaseSensitive() {
        return (caseSensitive);
    }

    /**
     * object�� String���� �����ϰ� �񱳸��Ѵ�. toString()�޼ҵ鸦 �̿� �ؼ� �� object�� Stringȭ�ϰ�
     * compareTo()�� �̿� �񱳸��Ѵ�.
     *
     * @param a
     *            ù��° object.
     * @param b
     *            �ι�° object.
     * @return ���� ���ٸ� 0, a�� b���� ��ٸ� -1, ũ�ٸ� 1�� ��ȯ��.
     */
    public int compare(Object a, Object b) {
        if (caseSensitive) {
            return (a.toString().compareTo(b.toString()));
        } else {
            return (a.toString().toLowerCase().compareTo(b.toString()
                                                          .toLowerCase()));
        }
    }
} //End of StringComparator.java
