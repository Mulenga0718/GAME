package k_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import j_collection.ScanUtil;

public class Login {
	String url = "jdbc:oracle:thin:@127.0.0.1:49724/xe";
	String user = "system";
	String password = "1234";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
public static void main(String[] args) {
		new Login().start();
}
	void start() {
	System.out.println("정규 게시판");

	while(true) {
		String sql = "SELECT * FROM T_MEMBER";
		ArrayList<Map<String, Object>> loginTable = (ArrayList<Map<String, Object>>)JDBCUtil.selectList(sql);
		System.out.print("(1) 로그인 (2)회원가입 (0) 종료>");
		int answer = ScanUtil.nextInt();	
		switch(answer) {
		case 1: System.out.print("아이디> ");
		String id = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String pwd = ScanUtil.nextLine();
		for(int i=0; i<loginTable.size(); i++) {
		if(id.equals((String)loginTable.get(i).get("ID")) && pwd.equals((String)loginTable.get(i).get("PWD"))){
			 new JDBCLogin().id = id;  new JDBCBoard().id = id; new PersonalInfo().id = id;	new JDBCBoard().start();}
		}
		System.out.println("일치하는 회원 정보가 없습니다."); break;
		
		case 2: sql = "INSERT INTO T_MEMBER (ID, PWD, NAME, EMAIL) "
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
		JDBCUtil.update(sql, param); break;
		
		case 0: System.out.println("시스템을 종료합니다.");
				System.exit(0); break;
		}
		
		}	
	}
	
}

