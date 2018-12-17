package cn.dd.start;

import cn.dd.spider.Spider;
import cn.dd.spider.SpiderIndex;

public class SpiderStart {

	public static void main(String[] args) {
		String str = "http://news.sina.com.cn/c/nd/2018-09-12/doc-ihiycyfx7821477.shtml";
		Spider.crawler();
		SpiderIndex.input(str,"09月12日");
	}
}
