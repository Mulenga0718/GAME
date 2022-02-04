package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCtest {

	public static void main(String[] args) {
		
		String sql = "SELECT * FROM CART "
				+ " WHERE CART_MEMBER = ? "
				+ " AND CART_QTY > ? ";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add("a001");
		param.add(5);
		
		
		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);
		System.out.println(list);
		
	}

}
