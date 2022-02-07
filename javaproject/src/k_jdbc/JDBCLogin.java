package k_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class JDBCLogin {
	public static String id;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "LJG93";
	String password = "java";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new JDBCLogin().start();
	}
		String sql = "SELECT * FROM T_MEMBER";
		ArrayList<Map<String, Object>> loginTable = new ArrayList<Map<String, Object>>();
		SimpleDateFormat format = new SimpleDateFormat("MM-dd");
		
		void start() {
			Map<String, Object> login = new HashMap<String, Object>();	
			while (true) {
				String sql = "SELECT * FROM T_MEMBER";
				loginTable = (ArrayList<Map<String, Object>>)JDBCUtil.selectList(sql);
				
				System.out.println("아이디\t비밀번호\t이름\t이메일\t\t\t가입일");
			for (int i = loginTable.size()- 1; i >= 0; i--) {
				login = loginTable.get(i);
				System.out.print(login.get("ID")+"\t");
				System.out.printf("%-8s", login.get("PWD"));
				System.out.printf("%-7s",(String)login.get("NAME"));
				System.out.printf("%-20s",(String)login.get("EMAIL"));
				System.out.println("\t"+format.format(login.get("JOINDATE")));
			}
				
				System.out.print("(1) 조회 (2) 추가  (0) 종료 >");
			
				int result = ScanUtil.nextInt();
				switch (result) {
				case 1:
					read();
					break;
				case 2:
					insert();
					break;
				case 3: 	
				case 0:
					System.out.println("시스템을 종료하겠습니다.");
					System.exit(0);
				}
			}

		}

		private void insert() {
			String sql = "INSERT INTO T_MEMBER (ID, PWD, NAME, EMAIL) "
					+ "VALUES(?,?,?,?)";
			ArrayList param = new ArrayList();
			System.out.print("아이디 >");
			param.add(ScanUtil.nextLine());
			System.out.print("비밀번호 >");
			param.add(ScanUtil.nextLine());
			System.out.print("이름 >");
			param.add(ScanUtil.nextLine());
			System.out.print("이메일 >");
			param.add(ScanUtil.nextLine());
			JDBCUtil.update(sql, param);
				
			
		}

		private void read() {
			String sql = "SELECT * FROM T_MEMBER "
					+ "WHERE ID = ?";
			ArrayList param = new ArrayList();
			System.out.print("조회할 아이디를 입력해주세요> ");
			param.add(ScanUtil.nextLine());
					
			
			Map<String, Object> login = JDBCUtil.selectOne(sql, param);
			
			System.out.print(login.get("ID") + "\t");
			System.out.print(login.get("PWD") + "\t");
			System.out.print(login.get("NAME") + "\t");
			System.out.print(login.get("EMAIL") + "\t");
			System.out.println(format.format(login.get("JOINDATE")));

			System.out.print("1.삭제 2.수정 0.목록");
			int result = ScanUtil.nextInt();

			switch (result) {
			case 1:
				delete(login);
				break;

			case 2:
				mod(login);
				break;

			case 0:

				break;
			}

		}

		private void mod(Map<String, Object> board) {
			// TODO Auto-generated method stub
			
			String sql = "UPDATE T_MEMBER SET ID=?, PWD=?, NAME=?, EMAIL=? WHERE ID= ?";
			ArrayList param = new ArrayList();
			System.out.print("아이디 >");
			param.add(ScanUtil.nextLine());
			System.out.print("비밀번호 >");
			param.add(ScanUtil.nextLine());
			System.out.print("이름 >");
			param.add(ScanUtil.nextLine());
			System.out.print("이메일 >");
			param.add(ScanUtil.nextLine());
			param.add(board.get("ID"));
			JDBCUtil.update(sql, param);
		}

		private void delete(Map<String, Object> board) {
			String sql = "DELETE FROM T_MEMBER WHERE ID=?";
			ArrayList param = new ArrayList();
			param.add(board.get("ID"));
			JDBCUtil.update(sql, param);
			
		}
}

