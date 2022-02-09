package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T_JDBCBoard {

	public static void main(String[] args) {
		new T_JDBCBoard().start();
	}

	private void start() {
		while(true) {
			String sql = "SELECT A.ARTICLENO  "
					+ ", A.TITLE "
					+ ", A.ID  "
					+ ", to_char(A.WRITEDATE, 'MM/DD') as REG_DATE  "
					+ " FROM T_BOARD A "
					+ " LEFT OUTER JOIN MEMBER B ON A.ID = B.MEM_ID"
					+ " order by A.ARTICLENO desc";
			List<Map<String, Object>> boardList = JDBCUtil.selectList(sql);
			
			
			System.out.println("---------------------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("---------------------------------------");
			for(Map<String, Object> board: boardList) {
				System.out.println(board.get("ARTICLENO") 
						+ "\t" + board.get("TITLE")
						+ "\t" + board.get("ID")
						+ "\t" + board.get("REG_DATE"));
			}
			System.out.println("----------------------------------------");
			System.out.println("1.조회 2.등록 0.종료>");
			int input = ScanUtil.nextInt();
			switch(input) {
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

	private void read() {
		System.out.println("게시글 번호> ");
		int boardNo = ScanUtil.nextInt();
		
		String sql = "select A.ARTICLENO  "
				+ ", A.TITLE "
				+ ", A.CONTENT "
				+ ", B.MEM_NAME  "
				+ ", to_ char(A.WRITEDATE, 'MM/DD') as reg_date  "
				+ " from T_BOARD.A "
				+ " left outer join MEMBER B on A.ID = B.MEM_ID"
				+ " WHERE A.ARTICLENO = ?";
		
		List<Object> param = new ArrayList<Object>();
		param.add(boardNo);
		
		Map<String, Object> board = JDBCUtil.selectOne(sql, param);
		System.out.println("----------------------------------------------");
		System.out.println("번호\t: "+ board.get("articleno")	);
		System.out.println("작성자\t: "+ board.get("ID")	);
		System.out.println("작성일\t: "+ board.get("WRITEDATE")	);
		System.out.println("제목\t: "+ board.get("TITLE")	);
		System.out.println("내용\t: "+ board.get("CONTENT"));
		System.out.println("----------------------------------------------");
		
		System.out.println("1.수정 2.삭제 0.목록>");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			update(boardNo);
			break;
		case 2: 
			delete(boardNo);
			break;
		case 0:
			
		
			
		}
		
	}

	private void delete(int boardNo) {
		System.out.println("정말 삭제하시겠습니까?> ");
		String yn = ScanUtil.nextLine();
		
		if(yn.equals("Y")) {
			String sql = "DELETE FROM T_BOARD  "
					+ "WHERE ARTICLENO = ?";
			
			List<Object> param = new ArrayList<Object>();
			param.add(boardNo);
			if(0< JDBCUtil.update(sql, param)) {
				System.out.println("게시글이 삭제되었습니다.");
			}else {
				System.out.println("게시글 삭제에 실패하였습니다.");
			}
			
		}
		
	}

	private void update(int boardNo) {
		System.out.print("제목> ");
		String title = ScanUtil.nextLine();
		System.out.print("내용> ");
		String content = ScanUtil.nextLine();
		
		String sql = "UPDATE T_BOARD "
				+ "SET TITLE = ? "
				+ ", CONTENT = ?"
				+ "WHERE ARTICLENO = ? ";
		
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		if(0< JDBCUtil.update(sql, param)) {
			System.out.println("게시글 수정이 완료되었습니다.");
		}else {
			System.out.println("게시글 수정에 실패하였습니다.");
		}
		
	}

	private void insert() {
		
		System.out.println("제목 >");
		String title = ScanUtil.nextLine();
		System.out.println("내용 >");
		String content = ScanUtil.nextLine();
		System.out.println("아이디 >");
		String memId = ScanUtil.nextLine();
		
		String sql = "INSERT INTO T_BOARD VALUES((SELECT NVL(MAX(ARTICLENO),0)+1 "
				+ " FROM T_BOARD),?,?,?,SYSDATE)";
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(memId);
		
		if(0< JDBCUtil.update(sql, param)) {
			System.out.println("게시글 등록이 완료되었습니다.");
		}else {
			System.out.println("게시글 등록에 실패하였습니다.");
		}
	}
}
