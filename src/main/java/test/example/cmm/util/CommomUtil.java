package test.example.cmm.util;

@SuppressWarnings("unchecked")
public class CommomUtil {

	public static String parseString(Object object, String replacement) {
		// null捞 酒囱 版快 贸府
		if(object != null) {
			String str = String.valueOf(object);
			// Replace贸府
			if("".equals(str) || "null".equals(str) || "undefined".equals(str) || "NULL".equals(str) || "UNDEFINED".equals(str) || "unknown".equals(str) || "UNKNOWN".equals(str)) {
				return replacement == null ? "" : replacement;
			}
			return str;
		}
		return replacement;
	}
	public static String parseString(Object object) {
		return parseString(object, "");
	}
}
