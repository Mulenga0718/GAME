package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import e_oop1.ScanUtil;

public class BoardPractice {
	public static void main(String[] args) {
	new BoardPractice().start();
}
	ArrayList<HashMap<String, Object>> boardTable1 = new ArrayList<HashMap<String, Object>>();
	SimpleDateFormat format = new SimpleDateFormat("MM-dd");
	
	void start(){
		while(true) {
			System.out.println("번호\t제목\t작성자\t작성일");
		for(int i= boardTable1.size(); i>=0; i--) {
			HashMap<String, Object> board1 = boardTable1.get(i);
			
			System.out.println(board1.get("BOARD_NO")+"\t"+board1.get("TITLE")+"\t"+board1.get("WRITER")+"\t"+format.format(board1.get("BOARD_DATE")));
			System.out.println("1.조회 2.등록 0.종료");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1: read();
			break;
			case 2: insert();
			break;
			case 0: System.exit(0);
			}
		}
		}
		
		//insert 
		//read
	}

	private void read() {
		
	}

	private void insert() {
		
	}
	
}
