package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCpractice {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LJG93";
		String password = "java";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 전체 조회
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from T_LAUNCH";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columCount = metaData.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columCount; i++) {
					System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();
			}
				
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		// 조건 조회

		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM T_LAUNCH";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println(name);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		// insert
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO T_LAUNCH" + " (NAME, TYPE, MENU,ADDRESS,PH)" + " VALUES(?,?,?,?,?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, "한솥도시락");
			ps.setString(2, "한식");
			ps.setString(3, "도시락");
			ps.setString(4, "250M");
			ps.setString(5, "042-527-3400");
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		// update문
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE T_LAUNCH" + " SET PH = ?" + " WHERE NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "010-4036-5374");
			ps.setString(2, "한솥도시락");
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		// delete

		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM T_LAUNCH WHERE PH = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "010-4036-5374");
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}
}