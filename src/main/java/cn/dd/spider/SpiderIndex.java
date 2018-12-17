package cn.dd.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import cn.dd.util.CloseUtil;
import cn.dd.util.IndexUtil;

public class SpiderIndex {
	public static void main(String[] args) {
		String str = "http://news.sina.com.cn/c/nd/2018-09-12/doc-ihiycyfx7821477.shtml";
		SpiderIndex.input(str,"09月12日");
	}

	public static void input(String str ,String data) {
		String indexFile = "F:" + File.separator+ "/something/"+data+"/spider_index.dat";
		String dataFile = "F:" + File.separator+ "/something/"+data+"/spider_data.dat";
		BufferedReader bu = null;
		try {
			bu = new BufferedReader(new InputStreamReader(new FileInputStream(indexFile), "utf-8"));
			String len = null;
			while ((len = bu.readLine()) != null) {
				String[] st = len.split("\u0001");
				if (str.equals(st[3])) {
					String s = IndexUtil.index(st[1], st[2], dataFile);
					System.out.println(s);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(bu);
		}

	}

}
