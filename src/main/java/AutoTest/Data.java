package AutoTest;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;



public class Data {
	
	public static Stack<String> readText(String path) {
		Stack<String> results = new Stack<>();
		File file = new File(path);
		
		try {
			InputStream inputstream=new FileInputStream(file);//å­—èŠ‚è¾“å…¥æµ�
			InputStreamReader read=new InputStreamReader(inputstream);//å­—ç¬¦è¾“å…¥æµ�
			BufferedReader br=new BufferedReader(read);/*æ��ä¾›ç¼“å­˜æ–¹å¼�ï¼Œ*/
			String line;
			while((line=br.readLine())!=null) {
				results.push(line);
				//System.out.println(line);
			}
			inputstream.close();
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("can not find file");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public static List<String> readTextToList(String path) {
		List<String> results = new ArrayList<>();
		
		File file = new File(path);
		
		try {
			InputStream inputstream=new FileInputStream(file);//å­—èŠ‚è¾“å…¥æµ�
			InputStreamReader read=new InputStreamReader(inputstream);//å­—ç¬¦è¾“å…¥æµ�
			BufferedReader br=new BufferedReader(read);/*æ��ä¾›ç¼“å­˜æ–¹å¼�ï¼Œ*/
			String line;
			while((line=br.readLine())!=null) {
				results.add(line);
				System.out.println(line);
			}
			inputstream.close();
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("ä¸�èƒ½æ‰¾åˆ°æ–‡ä»¶");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public static void main(String[] args) { 
//		String pathname=".\\src\\main\\resources\\Data_searchbox";
//		File file =new File(pathname);//å£°æ˜Žfileå¯¹è±¡	
	
	}
}
	

