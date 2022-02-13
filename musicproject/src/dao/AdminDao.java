package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class AdminDao {
	private AdminDao() {
		
	}
	private static AdminDao instance; 

	public static AdminDao getInstance() { 
		if (instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}
	
	public List<Map<String, Object>> aMemberAll() {
		String sql = "SELECT * FROM TB_MEMBER ORDER BY JOINDATE DESC" ;
		return JDBCUtil.selectList(sql);
	}
	public List<Map<String, Object>> idSearch(String id){

		String sql = "SELECT * FROM TB_MEMBER WHERE ID LIKE ?";
		List<Object> param = new ArrayList<Object>();
		param.add("%"+id+"%");
		return JDBCUtil.selectList(sql, param);
	}
	public List<Map<String, Object>> nameSearch(String name){

		String sql = "SELECT * FROM TB_MEMBER WHERE NAME LIKE ?";
		List<Object> param = new ArrayList<Object>();
		param.add("%"+name+"%");
		return JDBCUtil.selectList(sql, param);
	}
	public List<Map<String, Object>> dayIncomeM(String start, String end){
		String sql ="SELECT A.ID,"
				+ "         A.MUS_TOTAL AS INCOME , "
				+ "			B.M_NAME AS CONTENT, "
				+ "			TO_CHAR(A.MUS_DATE,'YYYYMMDD') AS MDATE"
				+ " FROM TB_ORDER_MUSIC A, TB_MUSIC B "
				+ " WHERE A.M_NO = B.M_NO  "
				+ "   AND A.MUS_DATE BETWEEN ? AND ?  "; 
		List<Object> param = new ArrayList<Object>();
		param.add(start);
		param.add(end);
	 return	JDBCUtil.selectList(sql, param);
	}
	public List<Map<String, Object>> dayIncomeS(String start, String end){
		String sql ="SELECT A.ID,"
				+ "         B.P_NAME AS CONTENT,  "
				+ "			A.SUB_TOTAL AS INCOME, "
				+ "			TO_CHAR(A.SUB_DATE,'YYYYMMDD') AS MDATE"
				+ " FROM TB_ORDER_SUB A, TB_SUBPROD B "
				+ " WHERE A.P_NO = B.P_NO "
				+ "   AND A.SUB_DATE BETWEEN ? AND ?  "; 
		List<Object> param = new ArrayList<Object>();
		param.add(start);
		param.add(end);
	 return	JDBCUtil.selectList(sql, param);
	}
	public List<Map<String, Object>> dayIncomeC(String start, String end){
		String sql ="SELECT A.ID,"
				+ "         A.COU_TOTAL AS INCOME, "
				+ "			B.COU_NAME AS CONTENT, "
				+ "			TO_CHAR(A.COU_DATE,'YYYYMMDD') AS MDATE"
				+ " FROM TB_ORDER_COU A, TB_COUPON B"
				+ " WHERE A.COU_NO = B.COU_NO "
				+ "  AND A.COU_DATE BETWEEN ? AND ?  "; 
		List<Object> param = new ArrayList<Object>();
		param.add(start);
		param.add(end);
	 return	JDBCUtil.selectList(sql, param);
	}
	public List<Map<String, Object>> adminMselect(){
		String sql = "SELECT * FROM TB_MUSIC ORDER BY M_NO DESC";
		return JDBCUtil.selectList(sql);
	}
	public int adminmadd(List<Object> param) {
		String sql = "INSERT INTO TB_MUSIC VALUES(?,?,?,?,?,?,?,?,?, 0)";
		return JDBCUtil.update(sql, param);
		
	}
	public int adminmmod(List<Object> param) {
		String sql = "UPDATE TB_MUSIC SET M_NO = ?, M_NAME = ?,  "
				+ "	 M_SINGER = ?, M_LYRICS = ?, M_DATE = ?, M_ADDR =?, G_CO = ? "
				+ "  ,F_NO = ?, M_AGE = ? "
				+ "  WHERE M_ID = ?  ";
		return JDBCUtil.update(sql, param);
	}
}
