package k_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonalInfo {
	public static String id;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "LJG93";
	String password = "java";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new PersonalInfo().start();
	}
	SimpleDateFormat format = new SimpleDateFormat();
	void start() {
		Map<String, Object> info = new HashMap<String, Object>();	
		while (true) {
			String sql = "SELECT * FROM T_MEMBER where ID = ?";
			ArrayList param = new ArrayList();
			param.add(id);
			info = JDBCUtil.selectOne(sql, param);
			 
			System.out.println("아이디\t비밀번호\t이름\t이메일\t\t\t가입일");
			
			System.out.print(info.get("ID")+"\t");
			System.out.printf("%-8s", info.get("PWD"));
			System.out.printf("%-7s",(String)info.get("NAME"));
			System.out.printf("%-20s",(String)info.get("EMAIL"));
			System.out.println("\t"+format.format(info.get("JOINDATE")));
			
			System.out.print("(1)수정 (2)삭제 (3)뒤로가기 (0)종료 >");
			int result = ScanUtil.nextInt();
			
			switch(result) {
			case 1: 
				mod(info); break;
			case 2: 
				delete(info); break;
			case 3: 
				new JDBCBoard().start(); break;
			case 0: 
				System.out.println("시스템을 종료하겠습니다.");
				System.exit(0);
			}
		}
	}
	private void delete(Map<String, Object> info) {
		String sql = "DELETE FROM T_MEMBER WHERE ID=?";
		ArrayList param = new ArrayList();
		param.add(info.get("ID"));
		System.out.println("정말 삭제하겠습니까?(Y|N)");
		String input = ScanUtil.nextLine();
		if(input.equals("Y")|| input.equals("y") ) {
		JDBCUtil.update(sql, param); new Login().start();}
		
	}
	private void mod(Map<String, Object> info) {
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
		param.add(info.get("ID"));
		JDBCUtil.update(sql, param);
		new JDBCBoard().start();
		
	}
}
