package JBBL;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class util {
	public static String URLen(String in) {
		return URLEncoder.encode(in);
	}
	public static String URLde(String in) {
		return URLDecoder.decode(in);
	}
}
