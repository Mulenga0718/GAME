package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import practice_jdbc.selectOneQuestion;

public class JDBCtest {

	public static void main(String[] args) {
		
	
		
		
//		String sql = "SELECT * FROM CART "
//				+ " WHERE CART_MEMBER = ? "
//				+ " AND CART_QTY > ? ";
//		ArrayList<Object> param = new ArrayList<Object>();
//		param.add("a001");
//		param.add(5);
//		
//		
//		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);
		
//		String sql = "SELECT * FROM T_MEMBER WHERE NAME = '이정규' ";
//		Map<String, Object> list1 = JDBCUtil.selectOne(sql);
//		System.out.println(list1);
		
		
		String sq2 = "SELECT * FROM T_MEMBER WHERE NAME = ? ";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add("이정규");
		Map<String, Object> list2 = selectOneQuestion.oneQue(sq2, param);
		System.out.println(list2);
		
//		String sql = "SELECT * FROM T_MEMBER";
//		List<Map<String, Object>> list3 = JDBCUtil.selectList(sql);
//		System.out.println(list3);
		
//		String sql = "UPDATE T_MEMBER SET NAME = '김창식' WHERE ID ='dkrnq' ";
//		System.out.println("변경된 행의수 : " +JDBCUtil.update(sql));
		
	}



}