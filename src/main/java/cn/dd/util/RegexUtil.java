package cn.dd.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	public static String match(String input, String regex) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			String result = m.group();
			sb.append(result);
		}
		return sb.toString();
	}

	public static String match(String input, String regex, int grpNum) {

		String result = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			result = m.group(grpNum);

		}
		return result;
	}

	public static List<String> matchList(String input, String regex) {

		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			String result = m.group();
			list.add(result);
		}
		return list;
	}

}
