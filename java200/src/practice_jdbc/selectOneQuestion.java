package practice_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class selectOneQuestion {

	//Map<String, Object> selectOne(String sql, List<Object> param) (쿼리,물음표에 들어갈 값)
	 //조회 결과 한줄 , 물음표 있을 때
	
	private static String url = "jdbc:oracle:thin:@127.0.0.1:49724/xe";
	private static String user = "system";
	private static String password = "1234";
	
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static Map<String, Object> oneQue(String sql, List<Object> param){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			con = DriverManager.getConnection(url,user,password);
			ps = con.prepareStatement(sql);//sql문을 
			for(int i =0; i<param.size(); i++) {
				ps.setObject(i+1,param.get(i));
			}
			rs = ps.executeQuery();
			ResultSetMetaData metaData =rs.getMetaData(); //쿼리문의 실행결과
			int colunmCount = metaData.getColumnCount();
			
			for(int i =1; i<=colunmCount; i++) {
				map.put(metaData.getColumnName(i), rs.getObject(i));
			}
			
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rs != null)try {rs.close();} catch (Exception e) {} //닫아서 반납을 해줌
			if (ps != null)try {ps.close();} catch (Exception e) {}
			if (con != null)try {con.close();} catch (Exception e){}
		} 
		return map;		
		
	}
	
	
	
	
	
	
	
	
}
