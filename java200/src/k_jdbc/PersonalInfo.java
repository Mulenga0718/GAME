package k_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import j_collection.ScanUtil;

public class PersonalInfo {

	public static String id;
	String url = "jdbc:oracle:thin:@127.0.0.1:49724/xe";
	String user = "system";
	String password = "1234";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new PersonalInfo().start();
	}
	
	void start() {	
		SimpleDateFormat format = new SimpleDateFormat("MM-dd");

		
		while(true) {
		String sql = "SELECT * FROM T_MEMBER "
				+ "WHERE ID = ?";
		ArrayList param = new ArrayList();
		param.add(id);
				
		
		Map<String, Object> login = JDBCUtil.selectOne(sql, param);
		
		System.out.print(login.get("ID") + "\t");
		System.out.print(login.get("PWD") + "\t");
		System.out.print(login.get("NAME") + "\t");
		System.out.print(login.get("EMAIL") + "\t");
		System.out.println(format.format(login.get("JOINDATE")));	
	
		
	System.out.print("(1) 수정 (2) 삭제 (3)뒤로가기 (0) 종료");	
	int answer = ScanUtil.nextInt();
	switch(answer) {
	case 1: 
		mod(id); break;
	case 2:
		delete(id); break;
	case 3:	
		new JDBCBoard().start(); break;
	case 0: 
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
	}
	}
	}
	private static void delete(String id) {
		
		String sql = "DELETE FROM T_MEMBER WHERE ID=?";
		ArrayList param = new ArrayList();
		param.add(id);
		JDBCUtil.update(sql, param);
		new Login().start();
	}

	private static void mod(String id) {
		
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
		param.add(id);
		JDBCUtil.update(sql, param);
		
	}
}

