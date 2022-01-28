package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop1.ScanUtil;

public class Controller {

	// 조회
	void list(HashMap<String, Object> board, ArrayList<HashMap<String, Object>> boardTable) {
		System.out.println("번호\t제목\t\t작성자\t작성일");
		for (int i = 0; i < boardTable.size(); i++) {
			board = boardTable.get(i);
			System.out.printf("%-8d",(int)board.get("번호"));
			System.out.printf("%-14s",(String)board.get("제목"));
			System.out.printf("%-4s",(String)board.get("작성자"));
			System.out.print("\t"+board.get("작성일"));
			System.out.println();
			System.out.println();

		}
		System.out.print("1.조회>  2.등록>");
		int choice = ScanUtil.nextInt();
		switch (choice) {
		case 1:
			select(board, boardTable);
			break;
		case 2:
			add(board, boardTable);
			break;
		}
	}

	void select(HashMap<String, Object> board, ArrayList<HashMap<String, Object>> boardTable) {
		System.out.println("몇번 글을 조회하시겠습니까?");
		int choice = ScanUtil.nextInt()-1;
		board = boardTable.get(choice);
		System.out.print(board.get("내용"));
		System.out.print("(1) 목록으로 돌아가기 (2) 수정 (3) 삭제");
		int choice1 = ScanUtil.nextInt();
		switch(choice1) {
		case 1: list(board, boardTable); break;
		case 2: modify(board, boardTable, choice); break;
		case 3: del(board, boardTable, choice); break;
		}
		
	}

	void add(HashMap<String, Object> board, ArrayList<HashMap<String, Object>> boardTable) {
		board = new HashMap<String, Object>();
		board.put("번호", boardTable.size() + 1);
		System.out.print("제목: ");
		board.put("제목", ScanUtil.nextLine());
		System.out.print("내용: ");
		board.put("내용", ScanUtil.nextLine());
		System.out.print("작성자: ");
		board.put("작성자", ScanUtil.nextLine());
		board.put("작성일", new Date());
		boardTable.add(board);
		
	}
	void del(HashMap<String, Object> board, ArrayList<HashMap<String, Object>> boardTable,int a) {
		System.out.println("글을 지우시겠습니까? (1)yes (2)no");
		board = boardTable.get(a);
		int choice = ScanUtil.nextInt();
		if(choice == 1) { board = boardTable.remove(a);}	
	}
	void modify(HashMap<String, Object> board, ArrayList<HashMap<String, Object>> boardTable, int a) {
		board = boardTable.get(a);
		System.out.println("수정하시겠습니까? (1)yes (2)no");
		int choice = ScanUtil.nextInt();
		if(choice ==1) {
			System.out.print("제목: ");
			board.put("제목", ScanUtil.nextLine());
			System.out.print("내용: ");
			board.put("내용", ScanUtil.nextLine());
			
		}
	}
	}

