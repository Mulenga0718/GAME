package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Boardpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boardpractice().start();
	}
	ArrayList<Map<String, Object>> boardTable = new ArrayList<Map<String, Object>>();
	SimpleDateFormat format = new SimpleDateFormat("MM-dd");
	
		void start() {

		
		while(true) {
			System.out.println("번호\t제목\t작성자\t날짜");
			Map<String, Object> board = new HashMap<String, Object>();
			for(int i=boardTable.size()-1; i> 0 ; i--) {
				System.out.println(board.get("BOARD_NO")+"\t"
			+board.get("TITLE")+"\t"+board.get("WRITER")+"\t"+format.format(board.get("REG_DATE")));
							
			System.out.println("1.조회 2.추가 0.종료");	
			int result = ScanUtil.nextInt();
			switch(result) {
			case 1: 
				read(); break;
			case 2: 
				insert(); break;
			case 0: 
				System.out.println("시스템을 종료하겠습니다.");
				System.exit(0);
			}
			}
			
		}
		
		
		
	}
		
		private void insert() {
			Map<String, Object> board = new HashMap<String, Object>();
			int max = 0;
			
			for(int i = 0; i< boardTable.size(); i++) {
				if(max < (int)boardTable.get(i).get("BOARD_NO")) {
					max = (int)boardTable.get(i).get("BOARD_NO");
				}
			board.put("BOARD_NO", max+1);
			System.out.print("제목 > ");
			board.put("TITLE", ScanUtil.nextLine());
			System.out.print("내용 > ");
			board.put("CONTENT", ScanUtil.nextLine());
			System.out.print("작성자 > ");
			board.put("WRITER", ScanUtil.nextLine());
			board.put("REG_DATE", new Date());
			boardTable.add(board);
				
			}
		
			
		}
		private void read() {
			Map<String, Object> board = new HashMap<String, Object>();
			
			System.out.print("몇 번을 조회하시겠습니까> ");
			int result = ScanUtil.nextInt();
			for(int i =0; i<boardTable.size(); i++) {
				if(result == (int)boardTable.get(i).get("BOARD_NO")){
					board = boardTable.get(i);
					}
			}
			System.out.print(board.get("BOARD_NO")+"\t");
			System.out.print(board.get("TITLE")+"\t");
			System.out.print(board.get("CONTENT")+"\t");
			System.out.print(board.get("WRITER")+"\t");
			System.out.print(board.get("REG_DATE"));
			
			System.out.print("1.삭제 2.수정 0.목록");
			result = ScanUtil.nextInt();
			
			switch(result) {
			case 1: 
				delete(board); break;
				
			case 2: 	
				mod(board); break;
				
			case 0: 

				break;
			}
			
			
		}

		private void mod(Map<String, Object> board) {
			
		}

		private void delete(Map<String, Object> board) {
			
		}
}










