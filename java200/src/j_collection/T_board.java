package j_collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class T_board {
	public static void main(String[] args) {
		new T_board().start();
	}

	ArrayList<HashMap<String, Object>> boardTable = new ArrayList<HashMap<String, Object>>();
	SimpleDateFormat format = new SimpleDateFormat("MM/dd");
	
	void start() {
		while (true) {
			System.out.println("================================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			for (int i = boardTable.size() - 1; i >= 0; i--) {
				System.out.println("-----------------------------------------------");
				HashMap<String, Object> board = boardTable.get(i);
				System.out.println(board.get("BOARD_NO") + "\t" + board.get("TITLE") + "\t"+board.get("USER_NAME") + "\t"
						+ format.format(board.get("REG_DATE")));
			}
			System.out.println("================================================");

			System.out.println("1.조회 2.등록 0.종료");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				read();
				break;
			case 2:
				insert();
				break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}

	}

	private void insert() {
		HashMap<String, Object> board = new HashMap<String, Object>();

		int max = 0;
		for (int i = 0; i < boardTable.size(); i++) {
			if (max < (int) boardTable.get(i).get("BOARD_NO")) {
				max = (int) boardTable.get(i).get("BOARD_NO");
			}
		}

		board.put("BOARD_NO", max + 1);
		System.out.print("제목> ");
		board.put("TITLE", ScanUtil.nextLine());
		System.out.print("내용> ");
		board.put("CONTENT", ScanUtil.nextLine());
		System.out.print("작성자>");
		board.put("USER_NAME", ScanUtil.nextLine());
		board.put("REG_DATE", new Date());
		boardTable.add(board);
		System.out.println("게시글이 등록되었습니다.");
	}

	private void read() {
		System.out.println("조회할 게시물 번호>");
		int boardNo = ScanUtil.nextInt();
		HashMap<String, Object> board = null;
		for (int i = 0; i < boardTable.size(); i++) {
			if (boardNo == (int) (boardTable.get(i).get("BOARD_NO"))) {
				board = boardTable.get(i);
				break;

			}
		}
		System.out.println("================================");
		System.out.println("번호\t: " + board.get("BOARD_NO"));
		System.out.println("--------------------------------");
		System.out.println("작성자\t: " + board.get("USER_NAME"));
		System.out.println("--------------------------------");
		System.out.println("작성일\t:" + board.get("REG_DATE"));
		System.out.println("--------------------------------");
		System.out.println("제목\t:" + board.get("TITLE"));
		System.out.println("--------------------------------");
		System.out.println("내용\t" + board.get("CONTENT"));
		System.out.println("--------------------------------");

		System.out.println("1.수정 2.삭제 0.목록>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			update(board);
			break;
		case 2:
			delete(board);
			break;
		case 0:
			break;
		}

	}

	private void delete(HashMap<String, Object> board) {
		System.out.println("정말 삭제 하시겠습니까?(Y/N)>");
		String input = ScanUtil.nextLine();

		if (input.equals("Y")) {
			for (int i = 0; i < boardTable.size(); i++) {
				if (board.get("BOARD_NO") == boardTable.get(i).get("BOARD_NO")) {
					boardTable.remove(i);
					System.out.println("게시글이 삭제되었습니다.");
					break;
				}
			}
		}

	}

	private void update(HashMap<String, Object> board) {
		System.out.print("제목>");
		board.put("TITLE", ScanUtil.nextLine());
		System.out.println("내용>");
		board.put("CONTENT", ScanUtil.nextLine());

		System.out.println("게시글이 수정되었습니다.");

	}
}