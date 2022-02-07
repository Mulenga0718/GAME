package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class JDBCtest {

	public static void main(String[] args) {
		
		ArrayList<Object> param = new ArrayList<Object>();
		
		
//		String sql = "SELECT * FROM CART "
//				+ " WHERE CART_MEMBER = ? "
//				+ " AND CART_QTY > ? ";
//		ArrayList<Object> param = new ArrayList<Object>();
//		param.add("a001");
//		param.add(5);
//		
//		
//		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);
//		
//		 sql = "SELECT * FROM T_MEMBER WHERE NAME = '이정규' ";
//		Map<String, Object> list1 = JDBCUtil.selectOne(sql);
//		System.out.println(list1);
//		
//		
//	
//		
//		 sql = "SELECT * FROM T_MEMBER";
//		List<Map<String, Object>> list3 = JDBCUtil.selectList(sql);
//		System.out.println(list3);
//		
//		 sql = "UPDATE T_MEMBER SET NAME = '김창식' WHERE ID ='dkrnq' ";
//		System.out.println("변경된 행의수 : " +JDBCUtil.update(sql));
		
		
		String sql = "insert into cart values(?,?,?,?)";
		param = new ArrayList<Object>();
		param.add("a001");
		param.add("2005040100001");
		param.add("P201000019");
		param.add(3);
		int result = JDBCUtil.update(sql, param);
		System.out.println(result +"행이 영향 받았습니다.");
	}
}
