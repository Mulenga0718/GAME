package z_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import k_jdbc.JDBCUtil;
import k_jdbc.ScanUtil;

public class SearchMusic {
	PlayMusic pmusic = new PlayMusic();

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		new SearchMusic().start();
	}

	void start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		while (true) {
			System.out.println("      🎵==================== 대덕 뮤직 =======================🎵");
			System.out.println();
			System.out.print("(1)노래 검색 (2)대덕인기차트 (3)최신 음악 (4)추천노래목록 (5)내음악  (0)종료 >");
			int result = ScanUtil.nextInt();
			switch (result) {
			case 1:
				search();
				break;
			case 2:
				chartorder();
				break;
			case 3:
				newchart();
				break;
			case 4:
				recommend();
				break;
			case 5:
				mylist();
				break;
			case 0: 
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
		}
	}

	private void chartorder() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		System.out.println("-------------인기 차트--------------");
		String sql = "SELECT * FROM MUSIC ORDER BY M_COUNT DESC";
		List<Map<String, Object>> list = JDBCUtil.selectList(sql);

		for (int i = 0; i < list.size() / 5; i++) {
			for (int j = 0 + (i * 5); j < 5 + (i * 5); j++) {
				System.out.print((j + 1) + "\t");
				System.out.print(list.get(j).get("M_NAME") + "\t");
				System.out.println(list.get(j).get("M_SINGER"));
			}

			System.out.println("(1) 곡 선택 (2) 다음 페이지 (3) 이전페이지 (4)뒤로가기 > ");
			int result = ScanUtil.nextInt();
			switch (result) {

			case 1:
				System.out.print("곡을 선택하십시오 >");
				result = ScanUtil.nextInt();
				String fmusic = String.valueOf(list.get(result - 1).get("M_ADDR"));

				pmusic.play(fmusic); i -= 1;
				break;
			case 2:
				break;
			case 3:
				i -= 2;
				break;
			case 4:
				start();
			}
		}

	}

	private void newchart() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		System.out.println("-------------최신 차트--------------");
		String sql = "SELECT * FROM MUSIC ORDER BY M_DATE DESC";
		List<Map<String, Object>> list = JDBCUtil.selectList(sql);

		for (int i = 0; i < list.size() / 5; i++) {
			for (int j = 0 + (i * 5); j < 5 + (i * 5); j++) {
				System.out.print((j + 1) + "\t");
				System.out.print(list.get(j).get("M_NAME") + "\t");
				System.out.println(list.get(j).get("M_SINGER"));
			}

			System.out.println("(1) 곡 선택 (2) 다음 페이지 (3) 이전페이지 (4)뒤로가기 > ");
			int result = ScanUtil.nextInt();
			switch (result) {

			case 1:
				System.out.println("곡을 선택하십시오 >");
				result = ScanUtil.nextInt();
				String fmusic = String.valueOf(list.get(result - 1).get("M_ADDR"));

				pmusic.play(fmusic); i -= 1;
				break;
			case 2:
				break;
			case 3:
				i -= 2;
				break;
			case 4:
				start();
			}
		}
	}

	private void mylist() {

	}

	private void recommend() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		while (true) {
			System.out.print("(1)개발자의 추천 (2)선호 장르 추천 (3)기분에 맞는 노래 추천 (4)뒤로 가기 >");
			int result = ScanUtil.nextInt();
			switch (result) {
			case 1:
				delvelprecommand();
				break;
			case 2:
				genre();
				break;
			case 3:
				feel();
				break;
			case 4:
				start();
				break;
			}
		}
	}

	private void feel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		System.out.println("지금의 감정을 선택해주세요.");
		System.out.println("(1)기쁨 (2)편안함 (3)우울 (4)분노 > ");
		int result = ScanUtil.nextInt();
		String genre = null;

		if (result == 1) {
			genre = "HAPPY";
		} else if (result == 2) {
			genre = "CALM";
		} else if (result == 3) {
			genre = "GLOOMY";
		} else if (result == 4) {
			genre = "ANGREY";
		} else {
			System.out.println("다시 입력해주세요.");
			recommend();
		}

		String sql = "SELECT * FROM MUSIC WHERE M_FEEL = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(genre);
		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + "\t");
			System.out.print(list.get(i).get("M_NAME") + "\t");
			System.out.println(list.get(i).get("M_SINGER"));

		}
		System.out.println("곡을 선택하십시오 > ");
		result = ScanUtil.nextInt();
		String fmusic = String.valueOf(list.get(result - 1).get("M_ADDR"));
		pmusic.play(fmusic);

	}

	private void delvelprecommand() {

	}

	private void genre() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		System.out.println("장르 선택 ");
		System.out.println("(1)발라드 (2)댄스 (3)힙합 (4) 락");
		int result = ScanUtil.nextInt();
		String genre = null;

		if (result == 1) {
			genre = "BALAD";
		} else if (result == 2) {
			genre = "DANCE";
		} else if (result == 3) {
			genre = "HIPHOP";
		} else if (result == 4) {
			genre = "ROCK";
		} else {
			System.out.println("다시 입력해주세요.");
			recommend();
		}

		String sql = "SELECT * FROM MUSIC WHERE M_GENRE = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(genre);
		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + "\t");
			System.out.print(list.get(i).get("M_NAME") + "\t");
			System.out.println(list.get(i).get("M_SINGER"));

		}
		System.out.println("곡을 선택하십시오 > ");
		result = ScanUtil.nextInt();
		String fmusic = String.valueOf(list.get(result - 1).get("M_ADDR"));
		pmusic.play(fmusic);

	}

	private void search() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		String sql = "SELECT * FROM MUSIC   WHERE M_NAME = ? OR  M_SINGER = ? OR M_NAME LIKE ?  "
				+ "OR M_NAME LIKE ? OR M_NAME LIKE ? OR  M_SINGER LIKE ? OR  M_SINGER LIKE ? OR  M_SINGER LIKE ? ";
		List<Object> param = new ArrayList<Object>();
		System.out.print("검색 > ");
		String find = ScanUtil.nextLine();
		param.add(find);
		param.add(find);
		param.add("%" + find);
		param.add(find + "%");
		param.add("%" + find + "%");
		param.add("%" + find);
		param.add(find + "%");
		param.add("%" + find + "%");
		try {
		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);
		System.out.println("번호\t곡목\t가수");
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + "\t");
			System.out.println(list.get(i).get("M_NAME") + "\t" + list.get(i).get("M_SINGER"));
		}
		System.out.print("(1) 곡 선택 (2) 뒤로가기 >");
		int result = ScanUtil.nextInt();
		switch(result){
		case 1 : System.out.print("곡을 선택해주세요 >");
		 result = ScanUtil.nextInt();
		String fmusic = String.valueOf(list.get(result - 1).get("M_ADDR"));
		pmusic.play(fmusic); break;
		case 2: start(); break;
		
		}
		}catch(IndexOutOfBoundsException e) {
			System.out.println("검색 결과가 없습니다.");}
		
		
		
		}
	}


