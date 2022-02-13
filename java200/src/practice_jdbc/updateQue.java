package practice_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class updateQue {

	
	private static String url = "jdbc:oracle:thin:@127.0.0.1:49724/xe";
	private static String user = "system";
	private static String password = "1234";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	//int update(String sql,List<Object> param) select문 제외한 나머지 인경우
		//물음표 있을 때
		
		// insert , update, delete
		// int result = ps.executeUpdate();
		//result:영향을 받은 행의 수 (몇줄이 영향을 받았는지)

		public static int updateQue(String sql, List<Object>param){
		int result =0;
		try {
			con = DriverManager.getConnection(url,user,password);
			ps=con.prepareStatement(sql);
			for(int i =0; i<param.size(); i++) {
				ps.setObject(i+1, param.get(i)); //물음표의 인덱스는 1부터 시작하니까 i+1
			}
			result = ps.executeUpdate();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			if (rs != null)try {rs.close();} catch (Exception e) {} //닫아서 반납을 해줌
			if (ps != null)try {ps.close();} catch (Exception e) {}
			if (con != null)try {con.close();} catch (Exception e) {}
		}
		return result;
		
	}
	
	
	
	
	
}
