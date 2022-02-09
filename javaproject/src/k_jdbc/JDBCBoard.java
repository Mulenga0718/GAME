package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCBoard {
	public static String id;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "LJG93";
	String password = "java";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public static void main(String[] args) {
		
		new JDBCBoard().start();
	}
	String sql = "SELECT * FROM T_BOARD";
	ArrayList<Map<String, Object>> boardTable = new ArrayList<Map<String, Object>>();
	SimpleDateFormat format = new SimpleDateFormat("MM-dd");

	void start() {
		
		Map<String, Object> board = new HashMap<String, Object>();
			
			while (true) {
				String sql = "SELECT * FROM T_BOARD ORDER BY 1";
				boardTable = (ArrayList<Map<String, Object>>)JDBCUtil.selectList(sql);
				System.out.println("           게시판 창");
				System.out.println("=======================================");
				System.out.println("번호\t제목\t\t작성자\t날짜");
			for (int i = boardTable.size()- 1; i >= 0; i--) {
				board = boardTable.get(i);
				System.out.println("--------------------------------------");
				System.out.print(board.get("ARTICLENO")+"\t");
				System.out.printf("%-13s", board.get("TITLE"));
				System.out.printf("%-4s",(String)board.get("ID"));
				System.out.println("\t"+format.format(board.get("WRITEDATE")));
			}
				System.out.println();
				System.out.print("(1) 조회 (2) 추가 (3) 회원정보 관리 (0) 종료");
			
				int result = ScanUtil.nextInt();
				switch (result) {
				case 1:
					read();
					break;
				case 2:
					insert();
					break;
				case 3: 
					new PersonalInfo().start(); break;
				case 0:
					System.out.println("시스템을 종료하겠습니다.");
					System.exit(0);
				}
			}

		}

	private void insert() {
	
		int max = 0;

		for (int i = 0; i < boardTable.size(); i++) {
			if (max <  Integer.parseInt(String.valueOf(boardTable.get(i).get("ARTICLENO")))) {
				max =  Integer.parseInt(String.valueOf(boardTable.get(i).get("ARTICLENO")));
			}
		}
		String sql = "INSERT INTO T_BOARD (ARTICLENO, TITLE, CONTENT, ID) "
				+ "VALUES(?,?,?,?)";
		ArrayList param = new ArrayList();
		param.add(max+1);
		System.out.print("제목 >");
		param.add(ScanUtil.nextLine());
		System.out.print("내용 >");
		param.add(ScanUtil.nextLine());
		param.add(id);
		JDBCUtil.update(sql, param);
		
		}

	private void read() {
		
		String sql = "SELECT * FROM T_BOARD "
				+ "WHERE ARTICLENO = ?";
		ArrayList param = new ArrayList();
		System.out.println();
		System.out.print("몇 번을 조회하시겠습니까> ");
		param.add(ScanUtil.nextInt());
				
		
		Map<String, Object> board = JDBCUtil.selectOne(sql, param);
		System.out.println("번호\t제목\t\t내용\t\t작성자\t날짜");
		System.out.println("================================================");
		System.out.print(board.get("ARTICLENO") + "\t");
		System.out.print(board.get("TITLE") + "\t");
		System.out.print(board.get("CONTENT") + "\t");
		System.out.print(board.get("ID") + "\t");
		System.out.println(format.format(board.get("WRITEDATE")));
		System.out.println("------------------------------------------------");
		System.out.println();

		System.out.print("1.삭제 2.수정 0.목록");
		int result = ScanUtil.nextInt();

		switch (result) {
		case 1:
			if(id.equals((String)board.get("ID"))) {
			delete(board);}
			else {System.out.println("타인의 정보에 접근할 수 없습니다.");}
			break;

		case 2:
			if(id.equals((String)board.get("ID"))) {
			mod(board);}
			else {System.out.println("타인의 정보에 접근할 수 없습니다.");} 
			break;

		case 0:

			break;
		}

	}

	private void mod(Map<String, Object> board) {
		String sql = "UPDATE T_BOARD SET TITLE=?, CONTENT=? WHERE ARTICLENO= ?";
		ArrayList param = new ArrayList();
		System.out.println("        게시글 수정 창");
		System.out.println("==================================");
		System.out.print("제목 >");
		param.add(ScanUtil.nextLine());
		System.out.print("내용 >");
		param.add(ScanUtil.nextLine());
		param.add(board.get("ARTICLENO"));
		JDBCUtil.update(sql, param);
	}

	private void delete(Map<String, Object> board) {
		System.out.println("정말 삭제하겠습니까?(Y|N)");
		String input = ScanUtil.nextLine();
		if(input.equals("Y")|| input.equals("y") ) {
	String sql = "DELETE FROM T_BOARD WHERE ARTICLENO=?";
	ArrayList param = new ArrayList();
	param.add(board.get("ARTICLENO"));
	JDBCUtil.update(sql, param);
	System.out.println("삭제되었습니다.");

		}
	}
}
