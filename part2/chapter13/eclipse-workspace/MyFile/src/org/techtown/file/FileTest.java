package org.techtown.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileTest {

	public static void main(String[] args) {
		FileTest test = new FileTest();
	    test.startup();

	}
	
	public void startup() {
	    File file = new File("test.txt");
	    try {
			FileOutputStream outstream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(outstream);
		    writer.write("æ»≥Á«œººø‰!");
		    writer.flush();
		    writer.close();  
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
