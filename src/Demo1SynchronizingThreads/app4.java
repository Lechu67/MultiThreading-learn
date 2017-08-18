package Demo1SynchronizingThreads;

import java.util.Scanner;

class Processor extends Thread{
	
	private volatile boolean running = true;
	
	@Override
	public void run(){
		while(running){
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	public void shutDown(){
		this.running = false;
	}
}
public class app4 {

	public static void main(String[] args) {
		
		Processor proc1 = new Processor();
		proc1.start();
		Scanner scan = new Scanner(System.in);
		System.out.println("Press return to stop");
		scan.nextLine();
		proc1.shutDown();

	}

}
