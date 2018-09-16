package cn.dd.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import cn.dd.util.CloseUtil;
import cn.dd.util.IndexUtil;

public class SpiderIndex {
	public static void main(String[] args) {
		String str = "http://news.sina.com.cn/c/nd/2018-08-23/doc-ihicsiav8438010.shtml";
		SpiderIndex.input(str);
	}

	public static void input(String str) {
		String indexFile = "F:" + File.separator+ "/something/08月23日/spider_index.dat";
		String dataFile = "F:" + File.separator+ "/something/08月23日/spider_data.dat";
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
