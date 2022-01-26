package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Excercise {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	File inFile = new File("D:/temp/newfile.txt");
	
	InputStream is = new FileInputStream(inFile);
	int data;
	while((data = is.read()) !=-1) {
		System.out.println("읽은 데이터:" + (char)data+ "남은 바이트 수:"+ is.available());
	}
	is.close();
	}

}
