package z_project;

import java.util.Timer;
import java.util.TimerTask;

public class Example {
	public static void main(String[] args) {
		

	Timer m_timer = new Timer();
	TimerTask m_task = new TimerTask() {
		
		public void run() {
			System.out.println("성공");
		}
	};
	m_timer.schedule(m_task, 5000);


}
}
