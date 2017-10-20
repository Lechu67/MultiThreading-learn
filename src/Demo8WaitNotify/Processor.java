package Demo8WaitNotify;

import java.util.Scanner;

public class Processor {
	
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producing....");
			wait();
			System.out.println("Resumed.");
		}
	}
	public void consume() throws InterruptedException{
		Thread.sleep(5000);
		synchronized (this) {
			System.out.println("Waiting for a return key..");
			Scanner scan = new Scanner(System.in);
			scan.nextLine();
			System.out.println("Let's resume");
			notify();
			Thread.sleep(5000);
		}
	}

}
