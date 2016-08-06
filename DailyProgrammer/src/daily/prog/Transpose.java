package daily.prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transpose {
	
	private static String line;
	
	public static void main(String args[]){
		String docTitle = args[0];
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(new File(docTitle))));
			
			while(scan.hasNextLine()){
				line = scan.nextLine();
				Storage.transpose(line);
				System.out.println(Storage.makeString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

 class Storage{
	 
	 public Storage(){
		 longestLine = 0;
		 map = new HashMap();
	 }
	private static Map map;
	private static int longestLine;
	 
	@SuppressWarnings("unchecked")
	public static void transpose(String line){
		if(line.length() > longestLine){
			longestLine = line.length();
		}
		for (int i = 0; i < line.length(); i++){
			map.put(i,line.charAt(i));
		}
	}
	
	public static String makeString(){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < longestLine; i++){
			str.append(map.get(i));
			str.append('\n');
		}
		return str.toString();
	}
}