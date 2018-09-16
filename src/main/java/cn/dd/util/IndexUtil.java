package cn.dd.util;

import java.io.RandomAccessFile;

public class IndexUtil {
	public static String index(String pos, String size, String dataFile) {

		String encoding = "utf-8";
		String str = "";
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(dataFile, "r");
			Long po = Long.valueOf(pos);
			raf.seek(po);
			Integer si = Integer.valueOf(size);
			byte[] b = new byte[si];
			raf.read(b);
			str = new String(b, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(raf);
		}
		return str;
	}

	public static String index(String pos, String size, String dataFile,String encoding) {
		String str = "";
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(dataFile, "r");
			Long po = Long.valueOf(pos);
			raf.seek(po);
			Integer si = Integer.valueOf(size);
			byte[] b = new byte[si];
			raf.read(b);
			str = new String(b, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(raf);
		}
		return str;
	}
}
