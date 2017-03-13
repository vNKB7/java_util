package my_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IO {
	public static List<String> readFile(String path) throws IOException {
		List<String> docs = new ArrayList<String>();
		
		File file = new File(path);
		InputStreamReader inputStreamReader = new InputStreamReader(
				new FileInputStream(file), "utf-8");
		BufferedReader in = new BufferedReader(inputStreamReader);
		String strTmp = "";
		while ((strTmp = in.readLine()) != null) {
			docs.add(strTmp.trim());
		}
		in.close();
		return docs;
	}
	
	public static void writeFile(String path, List<String> data){
		 java.io.File outFile = new java.io.File(path);
		 java.io.PrintWriter output = null;
		 try {
		 output = new java.io.PrintWriter(outFile);
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 }
		
		 for(String line : data){
			 output.println(line);
		 }
		 output.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
