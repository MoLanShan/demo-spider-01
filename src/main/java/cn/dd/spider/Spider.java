package cn.dd.spider;

import java.io.File;
import java.util.List;
import cn.dd.util.IOUtil;
import cn.dd.util.RegexUtil;
import cn.dd.util.WebUtil;

public class Spider {
	public static void main(String[] args) {
		Spider.crawler();
	}

	public static void crawler() {

		String urlStr = "http://roll.news.sina.com.cn/news/gnxw/gdxw1/index.shtml";
		String encoding = "gb2312";
		String input = WebUtil.urlGetString(urlStr, encoding);// 爬取列表页内容
		String ulRegex = "<ul class=\"list_009\">[\\s\\S]*?</ul>";// 正则表达式
		String ulResult = RegexUtil.match(input, ulRegex);
		String liRegex = "<li>[\\s\\S]*?</li>";// 正则表达式
		List<String> list = RegexUtil.matchList(ulResult, liRegex);
		for (String str : list) {
			String grpRegex = "<li><a href=\"([\\S]*?)\" target=\"_blank\">([\\S\\s]*?)</a><span>\\(([\\S]*?) [\\S]*?\\)</span></li>";
			String liUrlStr = RegexUtil.match(str, grpRegex, 1);
			String liTitle = RegexUtil.match(str, grpRegex, 2);
			String liDate = RegexUtil.match(str, grpRegex, 3);
			Spider.detailProcessor(liUrlStr, liTitle, liDate);
		}
	}

	public static void detailProcessor(String liUrlStr, String liTitle,
			String liDate) {
		byte[] ba = WebUtil.urlGetByteArray(liUrlStr);// 爬取详情页
		String fileBaseDir = "F:" + File.separator + "something"
				+ File.separator + liDate + File.separator;
		File fileBaseDirObj = new File(fileBaseDir);
		if (!fileBaseDirObj.exists()) {
			fileBaseDirObj.mkdirs();
		}
		String dataPath = fileBaseDir + "spider_data.dat";
		String indexPath = fileBaseDir + "spider_index.dat";
		File dataFile = new File(dataPath);
		long pos = dataFile.length();
		StringBuffer sb = new StringBuffer();
		char c = '\u0001';// 将储存的索引文件各部分用分隔符间隔开。
		sb.append(liTitle).append(c).append(pos).append(c).append(ba.length)
				.append(c).append(liUrlStr);
		IOUtil.writeDataFile(dataPath, ba);
		IOUtil.writeIndexFile(indexPath, sb.toString());
	}
}
