package com.pengwei.library.util;

/**
 * ×Ö·û´®¹¤¾ßÀà
 * @author ÅíÍþ
 *
 */
public class StringUtil {

	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÊÇ¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		// trim() È¥µô×Ö·û´®µÄÇ°ºó¿Õ¸ñ
		if (str == null || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ²»ÊÇ¿Õ
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
