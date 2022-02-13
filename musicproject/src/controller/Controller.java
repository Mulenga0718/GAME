package controller;

import service.AdminPage;
import service.Login;
import service.Main;
import service.Notice;
import service.Question;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		new Controller().start();
	}
	private Notice notice = Notice.getInstance();
	private Question question = Question.getInstance();
	private Login login = Login.getInstance();
	private Main main = Main.getInstance();
	private AdminPage adminPage = AdminPage.getInstance();
	private void start() {
		int view = View.HOME;
			while (true) {
			switch (view) {
			case View.HOME : view = home(); break;
			case View.LOGIN : view = login.login(); break;
			case View.MAIN : view = main.main(); break;
			case View.NOTICEBOARD : view = notice.noticeBoard(); break;
			case View.NOTICECONTENT : view = notice.noticecontent(); break;
			case View.NOTICEADD : view = notice.noticeadd(); break;
			case View.QBOARD :  view = question.questionboard(); break;
			case View.Q : view = question.question(); break;
			case View.QONE : view =  question.questionone(); break;
			case View.QANSWER : view = question.questionanswer(); break;
			case View.QADMINANSWER: view = question.qadminanswer(); break;
			case View.QONEADMIN: view = question.qustiononeadmin(); break;
			case View.FAQBOARD : view = question.faqboard(); break;
			case View.FAQANSWER: view = question.faqanswer(); break;
			case View.FAQADD : view = question.faqadd(); break;
			case View.ADMINMAIN : view = adminPage.adminMain(); break;
			case View.ADMINMEMBER : view = adminPage.adminMember(); break;
			case View.AMEMBERALL : view = adminPage.aMemberAll(); break;
			case View.AMEMBERSEARCH : view = adminPage.aMemberSearch(); break;
			case View.IDSEARCH : view = adminPage.idSearch(); break;
			case View.NAMESEARCH : view = adminPage.nameSearch(); break;
			case View.ADMININCOME : view = adminPage.adminIncome(); break;
			case View.DAYINCOME : view = adminPage.dayIncome(); break;
			case View.ADMINMUSIC : view = adminPage.adminMusic(); break;
			case View.ADMINMSELECT : view = adminPage.adminMselect(); break;
			case View.ADMINMMOD : view = adminPage.adminMmod(); break;
			case View.ADMINMADD : view = adminPage.adminMadd(); break;
			case 0: 
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
		}
	}
	
	private int home() {
		System.out.println("🎵==================== 대덕 뮤직 =======================🎵");
		System.out.println();
		System.out.print("1.로그인페이지 2.노래검색 3.인기차트 4.최신 음악"
				+ " 5.추천노래목록 6.공지사항 7.문의사항 0.프로그램종료 >");
		int result = ScanUtil.nextInt();
		switch(result) {
		case 1: return View.LOGIN;
		case 6: return View.NOTICEBOARD; 
		case 7: return View.QBOARD; 
		case 0: System.out.println("프로그램이 종료되었습니다.");
		System.exit(0);
		}
		return View.HOME;
	}
}