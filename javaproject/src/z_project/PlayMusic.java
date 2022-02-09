package z_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import k_jdbc.JDBCUtil;
import k_jdbc.ScanUtil;

public class PlayMusic {
		
	static void play(String fmusic) throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
			
			String sql = " UPDATE MUSIC SET M_COUNT = M_COUNT +1 WHERE M_ADDR = ?";
			List<Object> param = new ArrayList<Object>();
			param.add(fmusic);
			
			JDBCUtil.update(sql, param);
			
			Timer m_timer = new Timer();
			File file = new File("D:"+File.separator+ "project"+File.separator+ fmusic+".wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			int response =0;
			while(response != 4) {
				System.out.println("(1)플레이 (2)정지 (3)다시듣기 (4)종료 >");
				response = ScanUtil.nextInt();
				switch(response) {
				
				
				case 1 : clip.start();
				System.out.println();
				TimerTask m_task = new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						clip.close();
						System.out.println("30초 미리듣기만 지원합니다. 구독권을 구매하십시오.");
					}
			
				};
				m_timer.schedule(m_task, 30000);
				
				break;
				case 2 : clip.stop();
				break;
				case 3 : clip.setMicrosecondPosition(0);
				break;
				case 4: 
					clip.close();
					System.out.println("플레이를 종료합니다.");
				}
			}m_timer.cancel();
			}
	static void play1(String fmusic) throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		
		
		File file = new File("D:"+File.separator+ "project"+File.separator+ fmusic+".wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		int response =0;
		while(response != 4) {
			System.out.println("(1)플레이 (2)정지 (3)다시듣기 (4)종료 >");
			response = ScanUtil.nextInt();
			switch(response) {
			
			
			case 1 : clip.start();
			break;
			case 2 : clip.stop();
			break;
			case 3 : clip.setMicrosecondPosition(0);
			break;
			case 4: 
				clip.close();
				System.out.println("플레이를 종료합니다.");
			}
		}
		}
	}

			
			


