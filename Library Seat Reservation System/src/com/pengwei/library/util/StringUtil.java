package com.pengwei.library.util;

/**
 * �ַ���������
 * @author ����
 *
 */
public class StringUtil {

	/**
	 * �ж��ַ����Ƿ��ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		// trim() ȥ���ַ�����ǰ��ո�
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �ж��ַ����Ƿ��ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
}
