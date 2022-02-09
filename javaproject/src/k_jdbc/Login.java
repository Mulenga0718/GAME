package k_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.Map;

public class Login {

public static void main(String[] args) {
		
			new Login().start();
}

	 void start() {
	
	while(true) {
		
		String sql = "SELECT * FROM T_MEMBER";
		ArrayList<Map<String, Object>> loginTable = (ArrayList<Map<String, Object>>)JDBCUtil.selectList(sql);
		System.out.println("           정규 게시판");
		System.out.println("================================");
		System.out.print("(1) 로그인 (2)회원가입 (0) 종료>");
		int answer = ScanUtil.nextInt();
	
		switch(answer) {
		case 1:	
		System.out.println("             [로그인 창]");
		System.out.println("================================");
		
		System.out.print("아이디> ");
		String id = ScanUtil.nextLine();
		System.out.print("비밀번호> ");
		String pwd = ScanUtil.nextLine();
		
		for(int i=0; i<loginTable.size(); i++) {
		if(id.equals((String)loginTable.get(i).get("ID")) && pwd.equals((String)loginTable.get(i).get("PWD"))){
			 new JDBCLogin().id = id;  new JDBCBoard().id = id; new PersonalInfo().id = id;	new JDBCBoard().start();}
		}
		System.out.println("일치하는 회원 정보가 없습니다.");break;
				
		case 2:
			System.out.println("          [회원가입 창]");
			System.out.println("================================");
		
			sql = "INSERT INTO T_MEMBER (ID, PWD, NAME, EMAIL) "
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
			for(int i=0; i<loginTable.size(); i++) {
				if(loginTable.get(i).get("ID").equals(param.get(0))) {
					System.out.println("이미 가입된 회원입니다.");
					new Login().start();
				}
			
			}
			JDBCUtil.update(sql, param);
			System.out.println(param.get(0)+"님 회원가입을 축하드립니다.");
			
			break;
		case 0: System.out.println("시스템을 종료합니다.");
				System.exit(0); break;
		}

		}	
	}
	
}

