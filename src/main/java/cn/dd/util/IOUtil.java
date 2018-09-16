package cn.dd.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class IOUtil {
	
	public static void writeDataFile(String dataFile, byte[] ba){
		OutputStream os = null;
		try{
			os = new FileOutputStream(dataFile, true);
			os.write(ba);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseUtil.close(os);
		}
		
	}
	public static void writeIndexFile(String indexFile,String str){
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileOutputStream(indexFile, true));
			pw.println(str);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CloseUtil.close(pw);
		}
		
	}

}
