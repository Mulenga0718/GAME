package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop1.ScanUtil;

public class Board {
	
	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요. 
		 * 
		 * 번호, 제목, 내용, 작성자, 작성일 
		 * 
		 * 목록 - 조회(상세), 등록 
		 * 조회 - 수정, 삭제
		 */
		ArrayList<HashMap<String, Object>> boardTable = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> board = new HashMap<String, Object>();
		board.put("번호", 1);
		board.put("제목","연습입니다.");
		board.put("내용", "연습내용입니다.");
		board.put("작성자", "나");
		board.put("작성일", new Date());
		boardTable.add(board);
		
		board = new HashMap<String, Object>();
		board.put("번호", 2);
		board.put("제목","연습입니다.1");
		board.put("내용", "연습내용입니다.1");
		board.put("작성자", "나1");
		board.put("작성일", new Date());
		boardTable.add(board);
		
		board = new HashMap<String, Object>();
		board.put("번호", 3);
		board.put("제목","연습입니다.2");
		board.put("내용", "연습내용입니다.2");
		board.put("작성자", "나2");
		board.put("작성일", new Date());
		boardTable.add(board);
		
		Controller con = new Controller();
		int choice=0;
		
		do{con.list(board, boardTable);
		System.out.println("(1) list (2)종료");
		choice = ScanUtil.nextInt();
		}while(choice ==1);
	}
}
		
		
		
	    
		
	


