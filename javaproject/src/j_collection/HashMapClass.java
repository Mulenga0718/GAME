package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * object put(object key, object value) : 지정된 키와 값을 저장한다.
		 * object remove(object key) : 지정된 키로 저장된 값을 제거한다. 
		 * object get(object key) : 지정된 키의 값(없으면 null)을 반환한다. 
		 * set keyset() : 저장된 모든 키를 set으로 반환한다. 
		 */
		// 데이터 베이스 테이블을 표현할때 Hash map을 사용함. // 클래스를 사용할 수도 있음.
		// 컬럼명(key) 값(value)
		// hashmap에 복수 값 입력 가능?? ArrayList를 사용하면 가능 
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date());
		
		System.out.println(map);
		//HashMap은 index를 기준으로 저장되지 않기에 저장 순서가 없다. 
		//저장된 값을 수정
		map.put("name", "이순신");
		System.out.println(map);
		//저장된 값 삭제 
		map.remove("date");
		System.out.println(map);
		//저장된 값을 반환 ; object로 입력하였기에 object가 리턴됨 	
		Object value = map.get("name");
		//String 값으로 형변환 
		System.out.println(((String)value).substring(0,2));
		
		String value2 = (String)map.get("name");
		System.out.println(value2);
		
		//key set 
		Set<String> keys = map.keySet();
		System.out.println(keys);
		//값을 하나씩 출력할수 있는 for문 
		//데이터를 하나씩 꺼내서 for문 실행
		
		for(String key:keys) {
			System.out.println(key+":"+map.get(key));
		}
		
		
		ArrayList<HashMap<String, Object>> lprodTable = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID", 1);
		lprod.put("LPROD_GU", "P101");
		lprod.put("LPROD_NM", "컴퓨터제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID", 2);
		lprod.put("LPROD_GU", "P102");
		lprod.put("LPROD_NM", "전자제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID", 3);
		lprod.put("LPROD_GU", "P103");
		lprod.put("LPROD_NM", "여성캐주얼");
		lprodTable.add(lprod);
//		Set<String> keys1 = lprod.keySet();
//		System.out.println(keys1);
//		System.out.println(lprodTable);
//		
//		for(String key1: keys1) {
//			System.out.println(key1+":"+lprod.get(key1));
//		}
		
		for(int i=0; i<lprodTable.size(); i++) {
			lprod = lprodTable.get(i);
			for(String key : lprod.keySet()) {
				System.out.print(lprod.get(key)+"\t");
			}
			System.out.println();
		}
		
	}

}





