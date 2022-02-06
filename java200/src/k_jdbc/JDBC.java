package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		/*
		 * JDBC(Java DataBase Connectivity)
		 * -자바와 데이터베이스를 연결해주는 라이브러리
		 * -ojdbc : 오라클 jdbc
		 * 
		 * JDBC 작성 단계
		 * 1.Connection 생성(DB 연결)
		 * 2.Statement 생성(쿼리작성)
		 * 3.Query 실행
		 * 4.ResultSet에서 결과 추출(select인 경우)
		 * 5.ResultSet, Statement, Connection 닫기
		 * 
		 */
		String url = "jdbc:oracle:thin:@127.0.0.1:49724/xe";
		String user = "system";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//DriverManager : 데이터베이스에 접속하기 위한 드러이버를 관리해주는 클래스 
		try {
			con = DriverManager.getConnection(url, user, password);
		
			String sql = "select * from member";
			ps = con.prepareStatement(sql); //오라클에서 받아온 정보를 문자로 변환
			ps.executeQuery();
			
			//select일 경우 
			rs= ps.executeQuery();
			
			//insert, update, delete ; 리턴 타입의 차이; int타입의 결과 반환  
			//int result = ps.executeUpdate();
			//result: 영향을 받은 행의 수
			while(rs.next()) {//next()의 의미는 다음줄에 접근하라! ; 다음줄이 있으면 true 없으면 false 반환 
				String memId = rs.getString(1); //컬럼의 인덱스 입력; MEM_ID; 
				String memPass = rs.getString("MEM_PASS"); //컬럼명 입력
				
				System.out.println("MEM_ID: " + memId + "  / MEM_PASS :"+ memPass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
			
		}

	}

}