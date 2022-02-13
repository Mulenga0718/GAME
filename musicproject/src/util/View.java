package util;

public interface View {
	
	int HOME = 1;
	int LOGIN = 11;
	int JOIN = 12;
	int MAIN = 111;
	int NOTICEBOARD = 5;
	int NOTICECONTENT = 51;
	int NOTICEADD = 52;
	int QBOARD = 6;
	int FAQBOARD = 61;
	int FAQANSWER = 611;
	int FAQADD = 612;
	int Q = 62;
	int QONE =621;
	int QANSWER = 622;
	int QONEADMIN =63;
	int QADMINANSWER = 631;
	int ADMINMAIN = 82; // 관리자 페이지
	int ADMINMEMBER = 821; //관리자 회원정보 관리
	int AMEMBERALL = 8211; //전체 회원 조회
	int AMEMBERSEARCH = 8212; //회원 검색
	int IDSEARCH = 82121; // 아이디 겁색
	int NAMESEARCH = 82122; //이름 검색
	int ADMININCOME = 822; //수입 확인
	int DAYINCOME = 8221; //일별 수입 조회
	int ADMINMUSIC = 823; //음악 정보 관리
	int ADMINMSELECT = 8231; //음악 상세정보
	int ADMINMMOD = 82311; // 음악 정보 수정
	int ADMINMADD = 8232;// 음악 추가
	int ADMINCOU = 824; //쿠폰 정보 관리 
	int ADMINSUB = 825; //구독권 관리
}
