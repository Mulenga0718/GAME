package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LJG93";
		String password = "java";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select *"
					+ " from cart" 
					+ " where cart_member = ? " //'?'는 값을 나중에 채워 넣는 다는 것을 의미; ?에 값만 들어갈 수 있다. 
					+ " and cart_qty > ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001"); //첫번째 ?에 "a001"을 넣겠다.
			ps.setInt(2, 5); //두번째 ?에 5를 넣겠다. 
//			ps.setObject(0, sql);
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columCount = metaData.getColumnCount(); 
					
			while(rs.next()) {
				for(int i=1; i<=columCount; i++) {
					System.out.print(rs.getObject(i)+"\t");
				}
				System.out.println();
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